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
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import larion.progate.cds.NoSuchCdsPAFinalCompeteniesException;
import larion.progate.cds.model.CdsPAFinalCompetenies;
import larion.progate.cds.model.impl.CdsPAFinalCompeteniesImpl;
import larion.progate.cds.model.impl.CdsPAFinalCompeteniesModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="CdsPAFinalCompeteniesPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsPAFinalCompeteniesPersistenceImpl extends BasePersistenceImpl
	implements CdsPAFinalCompeteniesPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = CdsPAFinalCompeteniesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_ROOTID = new FinderPath(CdsPAFinalCompeteniesModelImpl.ENTITY_CACHE_ENABLED,
			CdsPAFinalCompeteniesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ROOTID = new FinderPath(CdsPAFinalCompeteniesModelImpl.ENTITY_CACHE_ENABLED,
			CdsPAFinalCompeteniesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ROOTID = new FinderPath(CdsPAFinalCompeteniesModelImpl.ENTITY_CACHE_ENABLED,
			CdsPAFinalCompeteniesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByRootId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_USERID = new FinderPath(CdsPAFinalCompeteniesModelImpl.ENTITY_CACHE_ENABLED,
			CdsPAFinalCompeteniesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByUserId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_USERID = new FinderPath(CdsPAFinalCompeteniesModelImpl.ENTITY_CACHE_ENABLED,
			CdsPAFinalCompeteniesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByUserId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(CdsPAFinalCompeteniesModelImpl.ENTITY_CACHE_ENABLED,
			CdsPAFinalCompeteniesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByUserId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(CdsPAFinalCompeteniesModelImpl.ENTITY_CACHE_ENABLED,
			CdsPAFinalCompeteniesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CdsPAFinalCompeteniesModelImpl.ENTITY_CACHE_ENABLED,
			CdsPAFinalCompeteniesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(CdsPAFinalCompetenies cdsPAFinalCompetenies) {
		EntityCacheUtil.putResult(CdsPAFinalCompeteniesModelImpl.ENTITY_CACHE_ENABLED,
			CdsPAFinalCompeteniesImpl.class,
			cdsPAFinalCompetenies.getPrimaryKey(), cdsPAFinalCompetenies);
	}

	public void cacheResult(List<CdsPAFinalCompetenies> cdsPAFinalCompetenieses) {
		for (CdsPAFinalCompetenies cdsPAFinalCompetenies : cdsPAFinalCompetenieses) {
			if (EntityCacheUtil.getResult(
						CdsPAFinalCompeteniesModelImpl.ENTITY_CACHE_ENABLED,
						CdsPAFinalCompeteniesImpl.class,
						cdsPAFinalCompetenies.getPrimaryKey(), this) == null) {
				cacheResult(cdsPAFinalCompetenies);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(CdsPAFinalCompeteniesImpl.class.getName());
		EntityCacheUtil.clearCache(CdsPAFinalCompeteniesImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public CdsPAFinalCompetenies create(Integer cdsPAFinalCompeteniesId) {
		CdsPAFinalCompetenies cdsPAFinalCompetenies = new CdsPAFinalCompeteniesImpl();

		cdsPAFinalCompetenies.setNew(true);
		cdsPAFinalCompetenies.setPrimaryKey(cdsPAFinalCompeteniesId);

		return cdsPAFinalCompetenies;
	}

	public CdsPAFinalCompetenies remove(Integer cdsPAFinalCompeteniesId)
		throws NoSuchCdsPAFinalCompeteniesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CdsPAFinalCompetenies cdsPAFinalCompetenies = (CdsPAFinalCompetenies)session.get(CdsPAFinalCompeteniesImpl.class,
					cdsPAFinalCompeteniesId);

			if (cdsPAFinalCompetenies == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No CdsPAFinalCompetenies exists with the primary key " +
						cdsPAFinalCompeteniesId);
				}

				throw new NoSuchCdsPAFinalCompeteniesException(
					"No CdsPAFinalCompetenies exists with the primary key " +
					cdsPAFinalCompeteniesId);
			}

			return remove(cdsPAFinalCompetenies);
		}
		catch (NoSuchCdsPAFinalCompeteniesException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public CdsPAFinalCompetenies remove(
		CdsPAFinalCompetenies cdsPAFinalCompetenies) throws SystemException {
		for (ModelListener<CdsPAFinalCompetenies> listener : listeners) {
			listener.onBeforeRemove(cdsPAFinalCompetenies);
		}

		cdsPAFinalCompetenies = removeImpl(cdsPAFinalCompetenies);

		for (ModelListener<CdsPAFinalCompetenies> listener : listeners) {
			listener.onAfterRemove(cdsPAFinalCompetenies);
		}

		return cdsPAFinalCompetenies;
	}

	protected CdsPAFinalCompetenies removeImpl(
		CdsPAFinalCompetenies cdsPAFinalCompetenies) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (cdsPAFinalCompetenies.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(CdsPAFinalCompeteniesImpl.class,
						cdsPAFinalCompetenies.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(cdsPAFinalCompetenies);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(CdsPAFinalCompeteniesModelImpl.ENTITY_CACHE_ENABLED,
			CdsPAFinalCompeteniesImpl.class,
			cdsPAFinalCompetenies.getPrimaryKey());

		return cdsPAFinalCompetenies;
	}

	public CdsPAFinalCompetenies update(
		CdsPAFinalCompetenies cdsPAFinalCompetenies) throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(CdsPAFinalCompetenies cdsPAFinalCompetenies) method. Use update(CdsPAFinalCompetenies cdsPAFinalCompetenies, boolean merge) instead.");
		}

		return update(cdsPAFinalCompetenies, false);
	}

	public CdsPAFinalCompetenies update(
		CdsPAFinalCompetenies cdsPAFinalCompetenies, boolean merge)
		throws SystemException {
		boolean isNew = cdsPAFinalCompetenies.isNew();

		for (ModelListener<CdsPAFinalCompetenies> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(cdsPAFinalCompetenies);
			}
			else {
				listener.onBeforeUpdate(cdsPAFinalCompetenies);
			}
		}

		cdsPAFinalCompetenies = updateImpl(cdsPAFinalCompetenies, merge);

		for (ModelListener<CdsPAFinalCompetenies> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(cdsPAFinalCompetenies);
			}
			else {
				listener.onAfterUpdate(cdsPAFinalCompetenies);
			}
		}

		return cdsPAFinalCompetenies;
	}

	public CdsPAFinalCompetenies updateImpl(
		larion.progate.cds.model.CdsPAFinalCompetenies cdsPAFinalCompetenies,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, cdsPAFinalCompetenies, merge);

			cdsPAFinalCompetenies.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(CdsPAFinalCompeteniesModelImpl.ENTITY_CACHE_ENABLED,
			CdsPAFinalCompeteniesImpl.class,
			cdsPAFinalCompetenies.getPrimaryKey(), cdsPAFinalCompetenies);

		return cdsPAFinalCompetenies;
	}

	public CdsPAFinalCompetenies findByPrimaryKey(
		Integer cdsPAFinalCompeteniesId)
		throws NoSuchCdsPAFinalCompeteniesException, SystemException {
		CdsPAFinalCompetenies cdsPAFinalCompetenies = fetchByPrimaryKey(cdsPAFinalCompeteniesId);

		if (cdsPAFinalCompetenies == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"No CdsPAFinalCompetenies exists with the primary key " +
					cdsPAFinalCompeteniesId);
			}

			throw new NoSuchCdsPAFinalCompeteniesException(
				"No CdsPAFinalCompetenies exists with the primary key " +
				cdsPAFinalCompeteniesId);
		}

		return cdsPAFinalCompetenies;
	}

	public CdsPAFinalCompetenies fetchByPrimaryKey(
		Integer cdsPAFinalCompeteniesId) throws SystemException {
		CdsPAFinalCompetenies cdsPAFinalCompetenies = (CdsPAFinalCompetenies)EntityCacheUtil.getResult(CdsPAFinalCompeteniesModelImpl.ENTITY_CACHE_ENABLED,
				CdsPAFinalCompeteniesImpl.class, cdsPAFinalCompeteniesId, this);

		if (cdsPAFinalCompetenies == null) {
			Session session = null;

			try {
				session = openSession();

				cdsPAFinalCompetenies = (CdsPAFinalCompetenies)session.get(CdsPAFinalCompeteniesImpl.class,
						cdsPAFinalCompeteniesId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (cdsPAFinalCompetenies != null) {
					cacheResult(cdsPAFinalCompetenies);
				}

				closeSession(session);
			}
		}

		return cdsPAFinalCompetenies;
	}

	public List<CdsPAFinalCompetenies> findByRootId(int rootId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		List<CdsPAFinalCompetenies> list = (List<CdsPAFinalCompetenies>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.CdsPAFinalCompetenies WHERE ");

				query.append("root_id = ?");

				query.append(" ");

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
					list = new ArrayList<CdsPAFinalCompetenies>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<CdsPAFinalCompetenies> findByRootId(int rootId, int start,
		int end) throws SystemException {
		return findByRootId(rootId, start, end, null);
	}

	public List<CdsPAFinalCompetenies> findByRootId(int rootId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(rootId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<CdsPAFinalCompetenies> list = (List<CdsPAFinalCompetenies>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.CdsPAFinalCompetenies WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rootId);

				list = (List<CdsPAFinalCompetenies>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsPAFinalCompetenies>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public CdsPAFinalCompetenies findByRootId_First(int rootId,
		OrderByComparator obc)
		throws NoSuchCdsPAFinalCompeteniesException, SystemException {
		List<CdsPAFinalCompetenies> list = findByRootId(rootId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No CdsPAFinalCompetenies exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsPAFinalCompeteniesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsPAFinalCompetenies findByRootId_Last(int rootId,
		OrderByComparator obc)
		throws NoSuchCdsPAFinalCompeteniesException, SystemException {
		int count = countByRootId(rootId);

		List<CdsPAFinalCompetenies> list = findByRootId(rootId, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No CdsPAFinalCompetenies exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsPAFinalCompeteniesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsPAFinalCompetenies[] findByRootId_PrevAndNext(
		Integer cdsPAFinalCompeteniesId, int rootId, OrderByComparator obc)
		throws NoSuchCdsPAFinalCompeteniesException, SystemException {
		CdsPAFinalCompetenies cdsPAFinalCompetenies = findByPrimaryKey(cdsPAFinalCompeteniesId);

		int count = countByRootId(rootId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.cds.model.CdsPAFinalCompetenies WHERE ");

			query.append("root_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(rootId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					cdsPAFinalCompetenies);

			CdsPAFinalCompetenies[] array = new CdsPAFinalCompeteniesImpl[3];

			array[0] = (CdsPAFinalCompetenies)objArray[0];
			array[1] = (CdsPAFinalCompetenies)objArray[1];
			array[2] = (CdsPAFinalCompetenies)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<CdsPAFinalCompetenies> findByUserId(int userId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(userId) };

		List<CdsPAFinalCompetenies> list = (List<CdsPAFinalCompetenies>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_USERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.CdsPAFinalCompetenies WHERE ");

				query.append("user_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsPAFinalCompetenies>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_USERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<CdsPAFinalCompetenies> findByUserId(int userId, int start,
		int end) throws SystemException {
		return findByUserId(userId, start, end, null);
	}

	public List<CdsPAFinalCompetenies> findByUserId(int userId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(userId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<CdsPAFinalCompetenies> list = (List<CdsPAFinalCompetenies>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_USERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.CdsPAFinalCompetenies WHERE ");

				query.append("user_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				list = (List<CdsPAFinalCompetenies>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsPAFinalCompetenies>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_USERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public CdsPAFinalCompetenies findByUserId_First(int userId,
		OrderByComparator obc)
		throws NoSuchCdsPAFinalCompeteniesException, SystemException {
		List<CdsPAFinalCompetenies> list = findByUserId(userId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No CdsPAFinalCompetenies exists with the key {");

			msg.append("userId=" + userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsPAFinalCompeteniesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsPAFinalCompetenies findByUserId_Last(int userId,
		OrderByComparator obc)
		throws NoSuchCdsPAFinalCompeteniesException, SystemException {
		int count = countByUserId(userId);

		List<CdsPAFinalCompetenies> list = findByUserId(userId, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No CdsPAFinalCompetenies exists with the key {");

			msg.append("userId=" + userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsPAFinalCompeteniesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsPAFinalCompetenies[] findByUserId_PrevAndNext(
		Integer cdsPAFinalCompeteniesId, int userId, OrderByComparator obc)
		throws NoSuchCdsPAFinalCompeteniesException, SystemException {
		CdsPAFinalCompetenies cdsPAFinalCompetenies = findByPrimaryKey(cdsPAFinalCompeteniesId);

		int count = countByUserId(userId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.cds.model.CdsPAFinalCompetenies WHERE ");

			query.append("user_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(userId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					cdsPAFinalCompetenies);

			CdsPAFinalCompetenies[] array = new CdsPAFinalCompeteniesImpl[3];

			array[0] = (CdsPAFinalCompetenies)objArray[0];
			array[1] = (CdsPAFinalCompetenies)objArray[1];
			array[2] = (CdsPAFinalCompetenies)objArray[2];

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

	public List<CdsPAFinalCompetenies> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<CdsPAFinalCompetenies> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<CdsPAFinalCompetenies> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<CdsPAFinalCompetenies> list = (List<CdsPAFinalCompetenies>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.CdsPAFinalCompetenies ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<CdsPAFinalCompetenies>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<CdsPAFinalCompetenies>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsPAFinalCompetenies>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByRootId(int rootId) throws SystemException {
		for (CdsPAFinalCompetenies cdsPAFinalCompetenies : findByRootId(rootId)) {
			remove(cdsPAFinalCompetenies);
		}
	}

	public void removeByUserId(int userId) throws SystemException {
		for (CdsPAFinalCompetenies cdsPAFinalCompetenies : findByUserId(userId)) {
			remove(cdsPAFinalCompetenies);
		}
	}

	public void removeAll() throws SystemException {
		for (CdsPAFinalCompetenies cdsPAFinalCompetenies : findAll()) {
			remove(cdsPAFinalCompetenies);
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
				query.append(
					"FROM larion.progate.cds.model.CdsPAFinalCompetenies WHERE ");

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

	public int countByUserId(int userId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(userId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.cds.model.CdsPAFinalCompetenies WHERE ");

				query.append("user_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID,
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
						"SELECT COUNT(*) FROM larion.progate.cds.model.CdsPAFinalCompetenies");

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

	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.larion.progate.cds.model.CdsPAFinalCompetenies")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CdsPAFinalCompetenies>> listenersList = new ArrayList<ModelListener<CdsPAFinalCompetenies>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CdsPAFinalCompetenies>)Class.forName(
							listenerClassName).newInstance());
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
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
	private static Log _log = LogFactoryUtil.getLog(CdsPAFinalCompeteniesPersistenceImpl.class);
}