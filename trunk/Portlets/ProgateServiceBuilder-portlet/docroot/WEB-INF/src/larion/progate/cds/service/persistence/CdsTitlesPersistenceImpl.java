/**
 * Copyright (c) 2000-2009 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package larion.progate.cds.service.persistence;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistry;
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQuery;
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQueryFactoryUtil;
import com.liferay.portal.kernel.dao.jdbc.RowMapper;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import larion.progate.cds.NoSuchCdsTitlesException;
import larion.progate.cds.model.CdsTitles;
import larion.progate.cds.model.impl.CdsTitlesImpl;
import larion.progate.cds.model.impl.CdsTitlesModelImpl;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="CdsTitlesPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsTitlesPersistenceImpl extends BasePersistenceImpl
	implements CdsTitlesPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = CdsTitlesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_ROOTID = new FinderPath(CdsTitlesModelImpl.ENTITY_CACHE_ENABLED,
			CdsTitlesModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByRootId", new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ROOTID = new FinderPath(CdsTitlesModelImpl.ENTITY_CACHE_ENABLED,
			CdsTitlesModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByRootId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ROOTID = new FinderPath(CdsTitlesModelImpl.ENTITY_CACHE_ENABLED,
			CdsTitlesModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByRootId", new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_NUMBERORDERGREATER = new FinderPath(CdsTitlesModelImpl.ENTITY_CACHE_ENABLED,
			CdsTitlesModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findBynumberOrderGreater", new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_NUMBERORDERGREATER = new FinderPath(CdsTitlesModelImpl.ENTITY_CACHE_ENABLED,
			CdsTitlesModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findBynumberOrderGreater",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_NUMBERORDERGREATER = new FinderPath(CdsTitlesModelImpl.ENTITY_CACHE_ENABLED,
			CdsTitlesModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countBynumberOrderGreater",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(CdsTitlesModelImpl.ENTITY_CACHE_ENABLED,
			CdsTitlesModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CdsTitlesModelImpl.ENTITY_CACHE_ENABLED,
			CdsTitlesModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	public void cacheResult(CdsTitles cdsTitles) {
		EntityCacheUtil.putResult(CdsTitlesModelImpl.ENTITY_CACHE_ENABLED,
			CdsTitlesImpl.class, cdsTitles.getPrimaryKey(), cdsTitles);
	}

	public void cacheResult(List<CdsTitles> cdsTitleses) {
		for (CdsTitles cdsTitles : cdsTitleses) {
			if (EntityCacheUtil.getResult(
						CdsTitlesModelImpl.ENTITY_CACHE_ENABLED,
						CdsTitlesImpl.class, cdsTitles.getPrimaryKey(), this) == null) {
				cacheResult(cdsTitles);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(CdsTitlesImpl.class.getName());
		EntityCacheUtil.clearCache(CdsTitlesImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public CdsTitles create(Integer cdsTitleId) {
		CdsTitles cdsTitles = new CdsTitlesImpl();

		cdsTitles.setNew(true);
		cdsTitles.setPrimaryKey(cdsTitleId);

		return cdsTitles;
	}

	public CdsTitles remove(Integer cdsTitleId)
		throws NoSuchCdsTitlesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CdsTitles cdsTitles = (CdsTitles)session.get(CdsTitlesImpl.class,
					cdsTitleId);

			if (cdsTitles == null) {
				if (_log.isWarnEnabled()) {
					_log.warn("No CdsTitles exists with the primary key " +
						cdsTitleId);
				}

				throw new NoSuchCdsTitlesException(
					"No CdsTitles exists with the primary key " + cdsTitleId);
			}

			return remove(cdsTitles);
		}
		catch (NoSuchCdsTitlesException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public CdsTitles remove(CdsTitles cdsTitles) throws SystemException {
		for (ModelListener<CdsTitles> listener : listeners) {
			listener.onBeforeRemove(cdsTitles);
		}

		cdsTitles = removeImpl(cdsTitles);

		for (ModelListener<CdsTitles> listener : listeners) {
			listener.onAfterRemove(cdsTitles);
		}

		return cdsTitles;
	}

	protected CdsTitles removeImpl(CdsTitles cdsTitles)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (cdsTitles.isCachedModel() || BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(CdsTitlesImpl.class,
						cdsTitles.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(cdsTitles);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(CdsTitlesModelImpl.ENTITY_CACHE_ENABLED,
			CdsTitlesImpl.class, cdsTitles.getPrimaryKey());

		return cdsTitles;
	}

	public CdsTitles update(CdsTitles cdsTitles) throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(CdsTitles cdsTitles) method. Use update(CdsTitles cdsTitles, boolean merge) instead.");
		}

		return update(cdsTitles, false);
	}

	public CdsTitles update(CdsTitles cdsTitles, boolean merge)
		throws SystemException {
		boolean isNew = cdsTitles.isNew();

		for (ModelListener<CdsTitles> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(cdsTitles);
			}
			else {
				listener.onBeforeUpdate(cdsTitles);
			}
		}

		cdsTitles = updateImpl(cdsTitles, merge);

		for (ModelListener<CdsTitles> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(cdsTitles);
			}
			else {
				listener.onAfterUpdate(cdsTitles);
			}
		}

		return cdsTitles;
	}

	public CdsTitles updateImpl(larion.progate.cds.model.CdsTitles cdsTitles,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, cdsTitles, merge);

			cdsTitles.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(CdsTitlesModelImpl.ENTITY_CACHE_ENABLED,
			CdsTitlesImpl.class, cdsTitles.getPrimaryKey(), cdsTitles);

		return cdsTitles;
	}

	public CdsTitles findByPrimaryKey(Integer cdsTitleId)
		throws NoSuchCdsTitlesException, SystemException {
		CdsTitles cdsTitles = fetchByPrimaryKey(cdsTitleId);

		if (cdsTitles == null) {
			if (_log.isWarnEnabled()) {
				_log.warn("No CdsTitles exists with the primary key " +
					cdsTitleId);
			}

			throw new NoSuchCdsTitlesException(
				"No CdsTitles exists with the primary key " + cdsTitleId);
		}

		return cdsTitles;
	}

	public CdsTitles fetchByPrimaryKey(Integer cdsTitleId)
		throws SystemException {
		CdsTitles cdsTitles = (CdsTitles)EntityCacheUtil.getResult(CdsTitlesModelImpl.ENTITY_CACHE_ENABLED,
				CdsTitlesImpl.class, cdsTitleId, this);

		if (cdsTitles == null) {
			Session session = null;

			try {
				session = openSession();

				cdsTitles = (CdsTitles)session.get(CdsTitlesImpl.class,
						cdsTitleId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (cdsTitles != null) {
					cacheResult(cdsTitles);
				}

				closeSession(session);
			}
		}

		return cdsTitles;
	}

	public List<CdsTitles> findByRootId(int rootId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		List<CdsTitles> list = (List<CdsTitles>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.cds.model.CdsTitles WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("number_order ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rootId);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsTitles>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<CdsTitles> findByRootId(int rootId, int start, int end)
		throws SystemException {
		return findByRootId(rootId, start, end, null);
	}

	public List<CdsTitles> findByRootId(int rootId, int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(rootId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<CdsTitles> list = (List<CdsTitles>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.cds.model.CdsTitles WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("number_order ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rootId);

				list = (List<CdsTitles>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsTitles>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public CdsTitles findByRootId_First(int rootId, OrderByComparator obc)
		throws NoSuchCdsTitlesException, SystemException {
		List<CdsTitles> list = findByRootId(rootId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No CdsTitles exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsTitlesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsTitles findByRootId_Last(int rootId, OrderByComparator obc)
		throws NoSuchCdsTitlesException, SystemException {
		int count = countByRootId(rootId);

		List<CdsTitles> list = findByRootId(rootId, count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No CdsTitles exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsTitlesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsTitles[] findByRootId_PrevAndNext(Integer cdsTitleId, int rootId,
		OrderByComparator obc) throws NoSuchCdsTitlesException, SystemException {
		CdsTitles cdsTitles = findByPrimaryKey(cdsTitleId);

		int count = countByRootId(rootId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.cds.model.CdsTitles WHERE ");

			query.append("root_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("number_order ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(rootId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					cdsTitles);

			CdsTitles[] array = new CdsTitlesImpl[3];

			array[0] = (CdsTitles)objArray[0];
			array[1] = (CdsTitles)objArray[1];
			array[2] = (CdsTitles)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<CdsTitles> findBynumberOrderGreater(int numberOrder)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(numberOrder) };

		List<CdsTitles> list = (List<CdsTitles>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_NUMBERORDERGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.cds.model.CdsTitles WHERE ");

				query.append("number_order > ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("number_order ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(numberOrder);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsTitles>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_NUMBERORDERGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<CdsTitles> findBynumberOrderGreater(int numberOrder, int start,
		int end) throws SystemException {
		return findBynumberOrderGreater(numberOrder, start, end, null);
	}

	public List<CdsTitles> findBynumberOrderGreater(int numberOrder, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(numberOrder),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<CdsTitles> list = (List<CdsTitles>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_NUMBERORDERGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.cds.model.CdsTitles WHERE ");

				query.append("number_order > ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("number_order ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(numberOrder);

				list = (List<CdsTitles>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsTitles>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_NUMBERORDERGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public CdsTitles findBynumberOrderGreater_First(int numberOrder,
		OrderByComparator obc) throws NoSuchCdsTitlesException, SystemException {
		List<CdsTitles> list = findBynumberOrderGreater(numberOrder, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No CdsTitles exists with the key {");

			msg.append("numberOrder=" + numberOrder);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsTitlesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsTitles findBynumberOrderGreater_Last(int numberOrder,
		OrderByComparator obc) throws NoSuchCdsTitlesException, SystemException {
		int count = countBynumberOrderGreater(numberOrder);

		List<CdsTitles> list = findBynumberOrderGreater(numberOrder, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No CdsTitles exists with the key {");

			msg.append("numberOrder=" + numberOrder);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsTitlesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsTitles[] findBynumberOrderGreater_PrevAndNext(
		Integer cdsTitleId, int numberOrder, OrderByComparator obc)
		throws NoSuchCdsTitlesException, SystemException {
		CdsTitles cdsTitles = findByPrimaryKey(cdsTitleId);

		int count = countBynumberOrderGreater(numberOrder);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.cds.model.CdsTitles WHERE ");

			query.append("number_order > ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("number_order ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(numberOrder);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					cdsTitles);

			CdsTitles[] array = new CdsTitlesImpl[3];

			array[0] = (CdsTitles)objArray[0];
			array[1] = (CdsTitles)objArray[1];
			array[2] = (CdsTitles)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<Object> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			dynamicQuery.compile(session);

			return dynamicQuery.list();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<Object> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			dynamicQuery.setLimit(start, end);

			dynamicQuery.compile(session);

			return dynamicQuery.list();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<CdsTitles> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<CdsTitles> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<CdsTitles> findAll(int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<CdsTitles> list = (List<CdsTitles>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.cds.model.CdsTitles ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("number_order ASC");
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<CdsTitles>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<CdsTitles>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsTitles>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByRootId(int rootId) throws SystemException {
		for (CdsTitles cdsTitles : findByRootId(rootId)) {
			remove(cdsTitles);
		}
	}

	public void removeBynumberOrderGreater(int numberOrder)
		throws SystemException {
		for (CdsTitles cdsTitles : findBynumberOrderGreater(numberOrder)) {
			remove(cdsTitles);
		}
	}

	public void removeAll() throws SystemException {
		for (CdsTitles cdsTitles : findAll()) {
			remove(cdsTitles);
		}
	}

	public int countByRootId(int rootId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ROOTID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append("FROM larion.progate.cds.model.CdsTitles WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rootId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ROOTID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countBynumberOrderGreater(int numberOrder)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(numberOrder) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_NUMBERORDERGREATER,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append("FROM larion.progate.cds.model.CdsTitles WHERE ");

				query.append("number_order > ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(numberOrder);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NUMBERORDERGREATER,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countAll() throws SystemException {
		Object[] finderArgs = new Object[0];

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(
						"SELECT COUNT(*) FROM larion.progate.cds.model.CdsTitles");

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public List<larion.progate.cds.model.CdsPAFinal> getCdsPAFinals(Integer pk)
		throws SystemException {
		return getCdsPAFinals(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public List<larion.progate.cds.model.CdsPAFinal> getCdsPAFinals(
		Integer pk, int start, int end) throws SystemException {
		return getCdsPAFinals(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_CDSPAFINALS = new FinderPath(larion.progate.cds.model.impl.CdsPAFinalModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.cds.model.impl.CdsPAFinalModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.cds.service.persistence.CdsPAFinalPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getCdsPAFinals",
			new String[] {
				Integer.class.getName(), "java.lang.Integer",
				"java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	public List<larion.progate.cds.model.CdsPAFinal> getCdsPAFinals(
		Integer pk, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				pk, String.valueOf(start), String.valueOf(end),
				String.valueOf(obc)
			};

		List<larion.progate.cds.model.CdsPAFinal> list = (List<larion.progate.cds.model.CdsPAFinal>)FinderCacheUtil.getResult(FINDER_PATH_GET_CDSPAFINALS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder sb = new StringBuilder();

				sb.append(_SQL_GETCDSPAFINALS);

				if (obc != null) {
					sb.append("ORDER BY ");
					sb.append(obc.getOrderBy());
				}

				String sql = sb.toString();

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("cds_performance_appraisal_final",
					larion.progate.cds.model.impl.CdsPAFinalImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<larion.progate.cds.model.CdsPAFinal>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<larion.progate.cds.model.CdsPAFinal>();
				}

				cdsPAFinalPersistence.cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_GET_CDSPAFINALS,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_CDSPAFINALS_SIZE = new FinderPath(larion.progate.cds.model.impl.CdsPAFinalModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.cds.model.impl.CdsPAFinalModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.cds.service.persistence.CdsPAFinalPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getCdsPAFinalsSize", new String[] { Integer.class.getName() });

	public int getCdsPAFinalsSize(Integer pk) throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_CDSPAFINALS_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETCDSPAFINALSSIZE);

				q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_GET_CDSPAFINALS_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_CDSPAFINAL = new FinderPath(larion.progate.cds.model.impl.CdsPAFinalModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.cds.model.impl.CdsPAFinalModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.cds.service.persistence.CdsPAFinalPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"containsCdsPAFinal",
			new String[] { Integer.class.getName(), Integer.class.getName() });

	public boolean containsCdsPAFinal(Integer pk, Integer cdsPAFinalPK)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk, cdsPAFinalPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_CDSPAFINAL,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsCdsPAFinal.contains(pk,
							cdsPAFinalPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_CDSPAFINAL,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	public boolean containsCdsPAFinals(Integer pk) throws SystemException {
		if (getCdsPAFinalsSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public List<larion.progate.cds.model.CdsTitleCompetencies> getCdsTitleCompetencieses(
		Integer pk) throws SystemException {
		return getCdsTitleCompetencieses(pk, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS);
	}

	public List<larion.progate.cds.model.CdsTitleCompetencies> getCdsTitleCompetencieses(
		Integer pk, int start, int end) throws SystemException {
		return getCdsTitleCompetencieses(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_CDSTITLECOMPETENCIESES = new FinderPath(larion.progate.cds.model.impl.CdsTitleCompetenciesModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.cds.model.impl.CdsTitleCompetenciesModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.cds.service.persistence.CdsTitleCompetenciesPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getCdsTitleCompetencieses",
			new String[] {
				Integer.class.getName(), "java.lang.Integer",
				"java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	public List<larion.progate.cds.model.CdsTitleCompetencies> getCdsTitleCompetencieses(
		Integer pk, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				pk, String.valueOf(start), String.valueOf(end),
				String.valueOf(obc)
			};

		List<larion.progate.cds.model.CdsTitleCompetencies> list = (List<larion.progate.cds.model.CdsTitleCompetencies>)FinderCacheUtil.getResult(FINDER_PATH_GET_CDSTITLECOMPETENCIESES,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder sb = new StringBuilder();

				sb.append(_SQL_GETCDSTITLECOMPETENCIESES);

				if (obc != null) {
					sb.append("ORDER BY ");
					sb.append(obc.getOrderBy());
				}

				String sql = sb.toString();

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("cds_title_competencies",
					larion.progate.cds.model.impl.CdsTitleCompetenciesImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<larion.progate.cds.model.CdsTitleCompetencies>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<larion.progate.cds.model.CdsTitleCompetencies>();
				}

				cdsTitleCompetenciesPersistence.cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_GET_CDSTITLECOMPETENCIESES,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_CDSTITLECOMPETENCIESES_SIZE = new FinderPath(larion.progate.cds.model.impl.CdsTitleCompetenciesModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.cds.model.impl.CdsTitleCompetenciesModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.cds.service.persistence.CdsTitleCompetenciesPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getCdsTitleCompetenciesesSize",
			new String[] { Integer.class.getName() });

	public int getCdsTitleCompetenciesesSize(Integer pk)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_CDSTITLECOMPETENCIESES_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETCDSTITLECOMPETENCIESESSIZE);

				q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_GET_CDSTITLECOMPETENCIESES_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_CDSTITLECOMPETENCIES = new FinderPath(larion.progate.cds.model.impl.CdsTitleCompetenciesModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.cds.model.impl.CdsTitleCompetenciesModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.cds.service.persistence.CdsTitleCompetenciesPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"containsCdsTitleCompetencies",
			new String[] { Integer.class.getName(), Integer.class.getName() });

	public boolean containsCdsTitleCompetencies(Integer pk,
		Integer cdsTitleCompetenciesPK) throws SystemException {
		Object[] finderArgs = new Object[] { pk, cdsTitleCompetenciesPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_CDSTITLECOMPETENCIES,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsCdsTitleCompetencies.contains(
							pk, cdsTitleCompetenciesPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_CDSTITLECOMPETENCIES,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	public boolean containsCdsTitleCompetencieses(Integer pk)
		throws SystemException {
		if (getCdsTitleCompetenciesesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public List<larion.progate.cds.model.CdsTitleMinimumRequirements> getCdsTitleMinimumRequirementses(
		Integer pk) throws SystemException {
		return getCdsTitleMinimumRequirementses(pk, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS);
	}

	public List<larion.progate.cds.model.CdsTitleMinimumRequirements> getCdsTitleMinimumRequirementses(
		Integer pk, int start, int end) throws SystemException {
		return getCdsTitleMinimumRequirementses(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_CDSTITLEMINIMUMREQUIREMENTSES =
		new FinderPath(larion.progate.cds.model.impl.CdsTitleMinimumRequirementsModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.cds.model.impl.CdsTitleMinimumRequirementsModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.cds.service.persistence.CdsTitleMinimumRequirementsPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getCdsTitleMinimumRequirementses",
			new String[] {
				Integer.class.getName(), "java.lang.Integer",
				"java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	public List<larion.progate.cds.model.CdsTitleMinimumRequirements> getCdsTitleMinimumRequirementses(
		Integer pk, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				pk, String.valueOf(start), String.valueOf(end),
				String.valueOf(obc)
			};

		List<larion.progate.cds.model.CdsTitleMinimumRequirements> list = (List<larion.progate.cds.model.CdsTitleMinimumRequirements>)FinderCacheUtil.getResult(FINDER_PATH_GET_CDSTITLEMINIMUMREQUIREMENTSES,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder sb = new StringBuilder();

				sb.append(_SQL_GETCDSTITLEMINIMUMREQUIREMENTSES);

				if (obc != null) {
					sb.append("ORDER BY ");
					sb.append(obc.getOrderBy());
				}

				String sql = sb.toString();

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("cds_title_minimum_requirements",
					larion.progate.cds.model.impl.CdsTitleMinimumRequirementsImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<larion.progate.cds.model.CdsTitleMinimumRequirements>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<larion.progate.cds.model.CdsTitleMinimumRequirements>();
				}

				cdsTitleMinimumRequirementsPersistence.cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_GET_CDSTITLEMINIMUMREQUIREMENTSES,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_CDSTITLEMINIMUMREQUIREMENTSES_SIZE =
		new FinderPath(larion.progate.cds.model.impl.CdsTitleMinimumRequirementsModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.cds.model.impl.CdsTitleMinimumRequirementsModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.cds.service.persistence.CdsTitleMinimumRequirementsPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getCdsTitleMinimumRequirementsesSize",
			new String[] { Integer.class.getName() });

	public int getCdsTitleMinimumRequirementsesSize(Integer pk)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_CDSTITLEMINIMUMREQUIREMENTSES_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETCDSTITLEMINIMUMREQUIREMENTSESSIZE);

				q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_GET_CDSTITLEMINIMUMREQUIREMENTSES_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_CDSTITLEMINIMUMREQUIREMENTS =
		new FinderPath(larion.progate.cds.model.impl.CdsTitleMinimumRequirementsModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.cds.model.impl.CdsTitleMinimumRequirementsModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.cds.service.persistence.CdsTitleMinimumRequirementsPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"containsCdsTitleMinimumRequirements",
			new String[] { Integer.class.getName(), Integer.class.getName() });

	public boolean containsCdsTitleMinimumRequirements(Integer pk,
		Integer cdsTitleMinimumRequirementsPK) throws SystemException {
		Object[] finderArgs = new Object[] { pk, cdsTitleMinimumRequirementsPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_CDSTITLEMINIMUMREQUIREMENTS,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsCdsTitleMinimumRequirements.contains(
							pk, cdsTitleMinimumRequirementsPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_CDSTITLEMINIMUMREQUIREMENTS,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	public boolean containsCdsTitleMinimumRequirementses(Integer pk)
		throws SystemException {
		if (getCdsTitleMinimumRequirementsesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.larion.progate.cds.model.CdsTitles")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CdsTitles>> listenersList = new ArrayList<ModelListener<CdsTitles>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CdsTitles>)Class.forName(
							listenerClassName).newInstance());
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		containsCdsPAFinal = new ContainsCdsPAFinal(this);

		containsCdsTitleCompetencies = new ContainsCdsTitleCompetencies(this);

		containsCdsTitleMinimumRequirements = new ContainsCdsTitleMinimumRequirements(this);
	}

	@BeanReference(name = "larion.progate.cds.service.persistence.CompetencyPersistence.impl")
	protected larion.progate.cds.service.persistence.CompetencyPersistence competencyPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.LevelPersistence.impl")
	protected larion.progate.cds.service.persistence.LevelPersistence levelPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.SlotPersistence.impl")
	protected larion.progate.cds.service.persistence.SlotPersistence slotPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPointsPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsPointsPersistence cdsPointsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsEvaluationPeriodsPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsEvaluationPeriodsPersistence cdsEvaluationPeriodsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsTitlesPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsTitlesPersistence cdsTitlesPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsTitleCompetenciesPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsTitleCompetenciesPersistence cdsTitleCompetenciesPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsMinimumRequirementsPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsMinimumRequirementsPersistence cdsMinimumRequirementsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsTitleMinimumRequirementsPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsTitleMinimumRequirementsPersistence cdsTitleMinimumRequirementsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsMinimumRequirementLevelsPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsMinimumRequirementLevelsPersistence cdsMinimumRequirementLevelsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewListTitleCompetenciesPersistence.impl")
	protected larion.progate.cds.service.persistence.ViewListTitleCompetenciesPersistence viewListTitleCompetenciesPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewListTitleMinimumRequirementsPersistence.impl")
	protected larion.progate.cds.service.persistence.ViewListTitleMinimumRequirementsPersistence viewListTitleMinimumRequirementsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPAFinalCompeteniesPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsPAFinalCompeteniesPersistence cdsPAFinalCompeteniesPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPAFinalLevelsPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsPAFinalLevelsPersistence cdsPAFinalLevelsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPAFinalSlotsPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsPAFinalSlotsPersistence cdsPAFinalSlotsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewFinalCompetenciesPersistence.impl")
	protected larion.progate.cds.service.persistence.ViewFinalCompetenciesPersistence viewFinalCompetenciesPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewFinalLevelsPersistence.impl")
	protected larion.progate.cds.service.persistence.ViewFinalLevelsPersistence viewFinalLevelsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewFinalSlotsPersistence.impl")
	protected larion.progate.cds.service.persistence.ViewFinalSlotsPersistence viewFinalSlotsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewFinalTitlesPersistence.impl")
	protected larion.progate.cds.service.persistence.ViewFinalTitlesPersistence viewFinalTitlesPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewSlotInformationPersistence.impl")
	protected larion.progate.cds.service.persistence.ViewSlotInformationPersistence viewSlotInformationPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPASlotsPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsPASlotsPersistence cdsPASlotsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPALevelsPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsPALevelsPersistence cdsPALevelsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPACompetenciesPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsPACompetenciesPersistence cdsPACompetenciesPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewPerformanceAppraisalLevelsPersistence.impl")
	protected larion.progate.cds.service.persistence.ViewPerformanceAppraisalLevelsPersistence viewPerformanceAppraisalLevelsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewPerformanceAppraisalSlotsPersistence.impl")
	protected larion.progate.cds.service.persistence.ViewPerformanceAppraisalSlotsPersistence viewPerformanceAppraisalSlotsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPerformanceAppraisalSlotRatingPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsPerformanceAppraisalSlotRatingPersistence cdsPerformanceAppraisalSlotRatingPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPerformanceAppraisalSlotCommentsPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsPerformanceAppraisalSlotCommentsPersistence cdsPerformanceAppraisalSlotCommentsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPerformanceAppraisalsPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsPerformanceAppraisalsPersistence cdsPerformanceAppraisalsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewEmployeesInProjectsPersistence.impl")
	protected larion.progate.cds.service.persistence.ViewEmployeesInProjectsPersistence viewEmployeesInProjectsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewEmployeesSlotsRatingPersistence.impl")
	protected larion.progate.cds.service.persistence.ViewEmployeesSlotsRatingPersistence viewEmployeesSlotsRatingPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsSlotStatisticalReportPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsSlotStatisticalReportPersistence cdsSlotStatisticalReportPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsLevelStatisticalReportPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsLevelStatisticalReportPersistence cdsLevelStatisticalReportPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsCompetencyStatisticalReportPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsCompetencyStatisticalReportPersistence cdsCompetencyStatisticalReportPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsCdpPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsCdpPersistence cdsCdpPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPAFinalPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsPAFinalPersistence cdsPAFinalPersistence;
	protected ContainsCdsPAFinal containsCdsPAFinal;
	protected ContainsCdsTitleCompetencies containsCdsTitleCompetencies;
	protected ContainsCdsTitleMinimumRequirements containsCdsTitleMinimumRequirements;

	protected class ContainsCdsPAFinal {
		protected ContainsCdsPAFinal(CdsTitlesPersistenceImpl persistenceImpl) {
			super();

			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSCDSPAFINAL,
					new int[] { Types.INTEGER, Types.INTEGER }, RowMapper.COUNT);
		}

		protected boolean contains(Integer cdsTitleId, Integer cdsPAFinalId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						cdsTitleId, cdsPAFinalId
					});

			if (results.size() > 0) {
				Integer count = results.get(0);

				if (count.intValue() > 0) {
					return true;
				}
			}

			return false;
		}

		private MappingSqlQuery _mappingSqlQuery;
	}

	protected class ContainsCdsTitleCompetencies {
		protected ContainsCdsTitleCompetencies(
			CdsTitlesPersistenceImpl persistenceImpl) {
			super();

			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSCDSTITLECOMPETENCIES,
					new int[] { Types.INTEGER, Types.INTEGER }, RowMapper.COUNT);
		}

		protected boolean contains(Integer cdsTitleId,
			Integer CdsTitleCompetenciesId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						cdsTitleId, CdsTitleCompetenciesId
					});

			if (results.size() > 0) {
				Integer count = results.get(0);

				if (count.intValue() > 0) {
					return true;
				}
			}

			return false;
		}

		private MappingSqlQuery _mappingSqlQuery;
	}

	protected class ContainsCdsTitleMinimumRequirements {
		protected ContainsCdsTitleMinimumRequirements(
			CdsTitlesPersistenceImpl persistenceImpl) {
			super();

			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSCDSTITLEMINIMUMREQUIREMENTS,
					new int[] { Types.INTEGER, Types.INTEGER }, RowMapper.COUNT);
		}

		protected boolean contains(Integer cdsTitleId,
			Integer CdsTitleMinimumRequirementsId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						cdsTitleId, CdsTitleMinimumRequirementsId
					});

			if (results.size() > 0) {
				Integer count = results.get(0);

				if (count.intValue() > 0) {
					return true;
				}
			}

			return false;
		}

		private MappingSqlQuery _mappingSqlQuery;
	}

	private static final String _SQL_GETCDSPAFINALS = "SELECT {cds_performance_appraisal_final.*} FROM cds_performance_appraisal_final INNER JOIN cds_titles ON (cds_titles.cdsTitleId = cds_performance_appraisal_final.cdsTitleId) WHERE (cds_titles.cdsTitleId = ?)";
	private static final String _SQL_GETCDSPAFINALSSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM cds_performance_appraisal_final WHERE cdsTitleId = ?";
	private static final String _SQL_CONTAINSCDSPAFINAL = "SELECT COUNT(*) AS COUNT_VALUE FROM cds_performance_appraisal_final WHERE cdsTitleId = ? AND cdsPAFinalId = ?";
	private static final String _SQL_GETCDSTITLECOMPETENCIESES = "SELECT {cds_title_competencies.*} FROM cds_title_competencies INNER JOIN cds_titles ON (cds_titles.cdsTitleId = cds_title_competencies.cdsTitleId) WHERE (cds_titles.cdsTitleId = ?)";
	private static final String _SQL_GETCDSTITLECOMPETENCIESESSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM cds_title_competencies WHERE cdsTitleId = ?";
	private static final String _SQL_CONTAINSCDSTITLECOMPETENCIES = "SELECT COUNT(*) AS COUNT_VALUE FROM cds_title_competencies WHERE cdsTitleId = ? AND CdsTitleCompetenciesId = ?";
	private static final String _SQL_GETCDSTITLEMINIMUMREQUIREMENTSES = "SELECT {cds_title_minimum_requirements.*} FROM cds_title_minimum_requirements INNER JOIN cds_titles ON (cds_titles.cdsTitleId = cds_title_minimum_requirements.cdsTitleId) WHERE (cds_titles.cdsTitleId = ?)";
	private static final String _SQL_GETCDSTITLEMINIMUMREQUIREMENTSESSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM cds_title_minimum_requirements WHERE cdsTitleId = ?";
	private static final String _SQL_CONTAINSCDSTITLEMINIMUMREQUIREMENTS = "SELECT COUNT(*) AS COUNT_VALUE FROM cds_title_minimum_requirements WHERE cdsTitleId = ? AND CdsTitleMinimumRequirementsId = ?";
	private static Log _log = LogFactoryUtil.getLog(CdsTitlesPersistenceImpl.class);
}