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

import larion.progate.cds.NoSuchCdsEvaluationPeriodsException;
import larion.progate.cds.model.CdsEvaluationPeriods;
import larion.progate.cds.model.impl.CdsEvaluationPeriodsImpl;
import larion.progate.cds.model.impl.CdsEvaluationPeriodsModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="CdsEvaluationPeriodsPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsEvaluationPeriodsPersistenceImpl extends BasePersistenceImpl
	implements CdsEvaluationPeriodsPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = CdsEvaluationPeriodsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_STATUS = new FinderPath(CdsEvaluationPeriodsModelImpl.ENTITY_CACHE_ENABLED,
			CdsEvaluationPeriodsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBystatus",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_STATUS = new FinderPath(CdsEvaluationPeriodsModelImpl.ENTITY_CACHE_ENABLED,
			CdsEvaluationPeriodsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBystatus",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(CdsEvaluationPeriodsModelImpl.ENTITY_CACHE_ENABLED,
			CdsEvaluationPeriodsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBystatus",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ROOTID = new FinderPath(CdsEvaluationPeriodsModelImpl.ENTITY_CACHE_ENABLED,
			CdsEvaluationPeriodsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByrootId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ROOTID = new FinderPath(CdsEvaluationPeriodsModelImpl.ENTITY_CACHE_ENABLED,
			CdsEvaluationPeriodsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByrootId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ROOTID = new FinderPath(CdsEvaluationPeriodsModelImpl.ENTITY_CACHE_ENABLED,
			CdsEvaluationPeriodsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByrootId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ISMODIFIED = new FinderPath(CdsEvaluationPeriodsModelImpl.ENTITY_CACHE_ENABLED,
			CdsEvaluationPeriodsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByisModified",
			new String[] { Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ISMODIFIED = new FinderPath(CdsEvaluationPeriodsModelImpl.ENTITY_CACHE_ENABLED,
			CdsEvaluationPeriodsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByisModified",
			new String[] {
				Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ISMODIFIED = new FinderPath(CdsEvaluationPeriodsModelImpl.ENTITY_CACHE_ENABLED,
			CdsEvaluationPeriodsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByisModified",
			new String[] { Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(CdsEvaluationPeriodsModelImpl.ENTITY_CACHE_ENABLED,
			CdsEvaluationPeriodsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CdsEvaluationPeriodsModelImpl.ENTITY_CACHE_ENABLED,
			CdsEvaluationPeriodsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(CdsEvaluationPeriods cdsEvaluationPeriods) {
		EntityCacheUtil.putResult(CdsEvaluationPeriodsModelImpl.ENTITY_CACHE_ENABLED,
			CdsEvaluationPeriodsImpl.class,
			cdsEvaluationPeriods.getPrimaryKey(), cdsEvaluationPeriods);
	}

	public void cacheResult(List<CdsEvaluationPeriods> cdsEvaluationPeriodses) {
		for (CdsEvaluationPeriods cdsEvaluationPeriods : cdsEvaluationPeriodses) {
			if (EntityCacheUtil.getResult(
						CdsEvaluationPeriodsModelImpl.ENTITY_CACHE_ENABLED,
						CdsEvaluationPeriodsImpl.class,
						cdsEvaluationPeriods.getPrimaryKey(), this) == null) {
				cacheResult(cdsEvaluationPeriods);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(CdsEvaluationPeriodsImpl.class.getName());
		EntityCacheUtil.clearCache(CdsEvaluationPeriodsImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public CdsEvaluationPeriods create(Integer CdsEvaluationPeriodsId) {
		CdsEvaluationPeriods cdsEvaluationPeriods = new CdsEvaluationPeriodsImpl();

		cdsEvaluationPeriods.setNew(true);
		cdsEvaluationPeriods.setPrimaryKey(CdsEvaluationPeriodsId);

		return cdsEvaluationPeriods;
	}

	public CdsEvaluationPeriods remove(Integer CdsEvaluationPeriodsId)
		throws NoSuchCdsEvaluationPeriodsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CdsEvaluationPeriods cdsEvaluationPeriods = (CdsEvaluationPeriods)session.get(CdsEvaluationPeriodsImpl.class,
					CdsEvaluationPeriodsId);

			if (cdsEvaluationPeriods == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No CdsEvaluationPeriods exists with the primary key " +
						CdsEvaluationPeriodsId);
				}

				throw new NoSuchCdsEvaluationPeriodsException(
					"No CdsEvaluationPeriods exists with the primary key " +
					CdsEvaluationPeriodsId);
			}

			return remove(cdsEvaluationPeriods);
		}
		catch (NoSuchCdsEvaluationPeriodsException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public CdsEvaluationPeriods remove(
		CdsEvaluationPeriods cdsEvaluationPeriods) throws SystemException {
		for (ModelListener<CdsEvaluationPeriods> listener : listeners) {
			listener.onBeforeRemove(cdsEvaluationPeriods);
		}

		cdsEvaluationPeriods = removeImpl(cdsEvaluationPeriods);

		for (ModelListener<CdsEvaluationPeriods> listener : listeners) {
			listener.onAfterRemove(cdsEvaluationPeriods);
		}

		return cdsEvaluationPeriods;
	}

	protected CdsEvaluationPeriods removeImpl(
		CdsEvaluationPeriods cdsEvaluationPeriods) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (cdsEvaluationPeriods.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(CdsEvaluationPeriodsImpl.class,
						cdsEvaluationPeriods.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(cdsEvaluationPeriods);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(CdsEvaluationPeriodsModelImpl.ENTITY_CACHE_ENABLED,
			CdsEvaluationPeriodsImpl.class, cdsEvaluationPeriods.getPrimaryKey());

		return cdsEvaluationPeriods;
	}

	public CdsEvaluationPeriods update(
		CdsEvaluationPeriods cdsEvaluationPeriods) throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(CdsEvaluationPeriods cdsEvaluationPeriods) method. Use update(CdsEvaluationPeriods cdsEvaluationPeriods, boolean merge) instead.");
		}

		return update(cdsEvaluationPeriods, false);
	}

	public CdsEvaluationPeriods update(
		CdsEvaluationPeriods cdsEvaluationPeriods, boolean merge)
		throws SystemException {
		boolean isNew = cdsEvaluationPeriods.isNew();

		for (ModelListener<CdsEvaluationPeriods> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(cdsEvaluationPeriods);
			}
			else {
				listener.onBeforeUpdate(cdsEvaluationPeriods);
			}
		}

		cdsEvaluationPeriods = updateImpl(cdsEvaluationPeriods, merge);

		for (ModelListener<CdsEvaluationPeriods> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(cdsEvaluationPeriods);
			}
			else {
				listener.onAfterUpdate(cdsEvaluationPeriods);
			}
		}

		return cdsEvaluationPeriods;
	}

	public CdsEvaluationPeriods updateImpl(
		larion.progate.cds.model.CdsEvaluationPeriods cdsEvaluationPeriods,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, cdsEvaluationPeriods, merge);

			cdsEvaluationPeriods.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(CdsEvaluationPeriodsModelImpl.ENTITY_CACHE_ENABLED,
			CdsEvaluationPeriodsImpl.class,
			cdsEvaluationPeriods.getPrimaryKey(), cdsEvaluationPeriods);

		return cdsEvaluationPeriods;
	}

	public CdsEvaluationPeriods findByPrimaryKey(Integer CdsEvaluationPeriodsId)
		throws NoSuchCdsEvaluationPeriodsException, SystemException {
		CdsEvaluationPeriods cdsEvaluationPeriods = fetchByPrimaryKey(CdsEvaluationPeriodsId);

		if (cdsEvaluationPeriods == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"No CdsEvaluationPeriods exists with the primary key " +
					CdsEvaluationPeriodsId);
			}

			throw new NoSuchCdsEvaluationPeriodsException(
				"No CdsEvaluationPeriods exists with the primary key " +
				CdsEvaluationPeriodsId);
		}

		return cdsEvaluationPeriods;
	}

	public CdsEvaluationPeriods fetchByPrimaryKey(
		Integer CdsEvaluationPeriodsId) throws SystemException {
		CdsEvaluationPeriods cdsEvaluationPeriods = (CdsEvaluationPeriods)EntityCacheUtil.getResult(CdsEvaluationPeriodsModelImpl.ENTITY_CACHE_ENABLED,
				CdsEvaluationPeriodsImpl.class, CdsEvaluationPeriodsId, this);

		if (cdsEvaluationPeriods == null) {
			Session session = null;

			try {
				session = openSession();

				cdsEvaluationPeriods = (CdsEvaluationPeriods)session.get(CdsEvaluationPeriodsImpl.class,
						CdsEvaluationPeriodsId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (cdsEvaluationPeriods != null) {
					cacheResult(cdsEvaluationPeriods);
				}

				closeSession(session);
			}
		}

		return cdsEvaluationPeriods;
	}

	public List<CdsEvaluationPeriods> findBystatus(int status)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(status) };

		List<CdsEvaluationPeriods> list = (List<CdsEvaluationPeriods>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_STATUS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.CdsEvaluationPeriods WHERE ");

				query.append("status = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("from_date ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsEvaluationPeriods>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_STATUS,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<CdsEvaluationPeriods> findBystatus(int status, int start,
		int end) throws SystemException {
		return findBystatus(status, start, end, null);
	}

	public List<CdsEvaluationPeriods> findBystatus(int status, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(status),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<CdsEvaluationPeriods> list = (List<CdsEvaluationPeriods>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_STATUS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.CdsEvaluationPeriods WHERE ");

				query.append("status = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("from_date ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				list = (List<CdsEvaluationPeriods>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsEvaluationPeriods>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_STATUS,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public CdsEvaluationPeriods findBystatus_First(int status,
		OrderByComparator obc)
		throws NoSuchCdsEvaluationPeriodsException, SystemException {
		List<CdsEvaluationPeriods> list = findBystatus(status, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No CdsEvaluationPeriods exists with the key {");

			msg.append("status=" + status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsEvaluationPeriodsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsEvaluationPeriods findBystatus_Last(int status,
		OrderByComparator obc)
		throws NoSuchCdsEvaluationPeriodsException, SystemException {
		int count = countBystatus(status);

		List<CdsEvaluationPeriods> list = findBystatus(status, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No CdsEvaluationPeriods exists with the key {");

			msg.append("status=" + status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsEvaluationPeriodsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsEvaluationPeriods[] findBystatus_PrevAndNext(
		Integer CdsEvaluationPeriodsId, int status, OrderByComparator obc)
		throws NoSuchCdsEvaluationPeriodsException, SystemException {
		CdsEvaluationPeriods cdsEvaluationPeriods = findByPrimaryKey(CdsEvaluationPeriodsId);

		int count = countBystatus(status);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.cds.model.CdsEvaluationPeriods WHERE ");

			query.append("status = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("from_date ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(status);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					cdsEvaluationPeriods);

			CdsEvaluationPeriods[] array = new CdsEvaluationPeriodsImpl[3];

			array[0] = (CdsEvaluationPeriods)objArray[0];
			array[1] = (CdsEvaluationPeriods)objArray[1];
			array[2] = (CdsEvaluationPeriods)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<CdsEvaluationPeriods> findByrootId(int rootId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		List<CdsEvaluationPeriods> list = (List<CdsEvaluationPeriods>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.CdsEvaluationPeriods WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("from_date ASC");

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
					list = new ArrayList<CdsEvaluationPeriods>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<CdsEvaluationPeriods> findByrootId(int rootId, int start,
		int end) throws SystemException {
		return findByrootId(rootId, start, end, null);
	}

	public List<CdsEvaluationPeriods> findByrootId(int rootId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(rootId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<CdsEvaluationPeriods> list = (List<CdsEvaluationPeriods>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.CdsEvaluationPeriods WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("from_date ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rootId);

				list = (List<CdsEvaluationPeriods>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsEvaluationPeriods>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public CdsEvaluationPeriods findByrootId_First(int rootId,
		OrderByComparator obc)
		throws NoSuchCdsEvaluationPeriodsException, SystemException {
		List<CdsEvaluationPeriods> list = findByrootId(rootId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No CdsEvaluationPeriods exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsEvaluationPeriodsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsEvaluationPeriods findByrootId_Last(int rootId,
		OrderByComparator obc)
		throws NoSuchCdsEvaluationPeriodsException, SystemException {
		int count = countByrootId(rootId);

		List<CdsEvaluationPeriods> list = findByrootId(rootId, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No CdsEvaluationPeriods exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsEvaluationPeriodsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsEvaluationPeriods[] findByrootId_PrevAndNext(
		Integer CdsEvaluationPeriodsId, int rootId, OrderByComparator obc)
		throws NoSuchCdsEvaluationPeriodsException, SystemException {
		CdsEvaluationPeriods cdsEvaluationPeriods = findByPrimaryKey(CdsEvaluationPeriodsId);

		int count = countByrootId(rootId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.cds.model.CdsEvaluationPeriods WHERE ");

			query.append("root_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("from_date ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(rootId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					cdsEvaluationPeriods);

			CdsEvaluationPeriods[] array = new CdsEvaluationPeriodsImpl[3];

			array[0] = (CdsEvaluationPeriods)objArray[0];
			array[1] = (CdsEvaluationPeriods)objArray[1];
			array[2] = (CdsEvaluationPeriods)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<CdsEvaluationPeriods> findByisModified(boolean isModified)
		throws SystemException {
		Object[] finderArgs = new Object[] { Boolean.valueOf(isModified) };

		List<CdsEvaluationPeriods> list = (List<CdsEvaluationPeriods>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ISMODIFIED,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.CdsEvaluationPeriods WHERE ");

				query.append("is_modified = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("from_date ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isModified);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsEvaluationPeriods>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ISMODIFIED,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<CdsEvaluationPeriods> findByisModified(boolean isModified,
		int start, int end) throws SystemException {
		return findByisModified(isModified, start, end, null);
	}

	public List<CdsEvaluationPeriods> findByisModified(boolean isModified,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				Boolean.valueOf(isModified),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<CdsEvaluationPeriods> list = (List<CdsEvaluationPeriods>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ISMODIFIED,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.CdsEvaluationPeriods WHERE ");

				query.append("is_modified = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("from_date ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isModified);

				list = (List<CdsEvaluationPeriods>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsEvaluationPeriods>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ISMODIFIED,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public CdsEvaluationPeriods findByisModified_First(boolean isModified,
		OrderByComparator obc)
		throws NoSuchCdsEvaluationPeriodsException, SystemException {
		List<CdsEvaluationPeriods> list = findByisModified(isModified, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No CdsEvaluationPeriods exists with the key {");

			msg.append("isModified=" + isModified);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsEvaluationPeriodsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsEvaluationPeriods findByisModified_Last(boolean isModified,
		OrderByComparator obc)
		throws NoSuchCdsEvaluationPeriodsException, SystemException {
		int count = countByisModified(isModified);

		List<CdsEvaluationPeriods> list = findByisModified(isModified,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No CdsEvaluationPeriods exists with the key {");

			msg.append("isModified=" + isModified);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsEvaluationPeriodsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsEvaluationPeriods[] findByisModified_PrevAndNext(
		Integer CdsEvaluationPeriodsId, boolean isModified,
		OrderByComparator obc)
		throws NoSuchCdsEvaluationPeriodsException, SystemException {
		CdsEvaluationPeriods cdsEvaluationPeriods = findByPrimaryKey(CdsEvaluationPeriodsId);

		int count = countByisModified(isModified);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.cds.model.CdsEvaluationPeriods WHERE ");

			query.append("is_modified = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("from_date ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(isModified);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					cdsEvaluationPeriods);

			CdsEvaluationPeriods[] array = new CdsEvaluationPeriodsImpl[3];

			array[0] = (CdsEvaluationPeriods)objArray[0];
			array[1] = (CdsEvaluationPeriods)objArray[1];
			array[2] = (CdsEvaluationPeriods)objArray[2];

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

	public List<CdsEvaluationPeriods> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<CdsEvaluationPeriods> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<CdsEvaluationPeriods> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<CdsEvaluationPeriods> list = (List<CdsEvaluationPeriods>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.CdsEvaluationPeriods ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("from_date ASC");
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<CdsEvaluationPeriods>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<CdsEvaluationPeriods>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsEvaluationPeriods>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeBystatus(int status) throws SystemException {
		for (CdsEvaluationPeriods cdsEvaluationPeriods : findBystatus(status)) {
			remove(cdsEvaluationPeriods);
		}
	}

	public void removeByrootId(int rootId) throws SystemException {
		for (CdsEvaluationPeriods cdsEvaluationPeriods : findByrootId(rootId)) {
			remove(cdsEvaluationPeriods);
		}
	}

	public void removeByisModified(boolean isModified)
		throws SystemException {
		for (CdsEvaluationPeriods cdsEvaluationPeriods : findByisModified(
				isModified)) {
			remove(cdsEvaluationPeriods);
		}
	}

	public void removeAll() throws SystemException {
		for (CdsEvaluationPeriods cdsEvaluationPeriods : findAll()) {
			remove(cdsEvaluationPeriods);
		}
	}

	public int countBystatus(int status) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(status) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_STATUS,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.cds.model.CdsEvaluationPeriods WHERE ");

				query.append("status = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STATUS,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByrootId(int rootId) throws SystemException {
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
					"FROM larion.progate.cds.model.CdsEvaluationPeriods WHERE ");

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

	public int countByisModified(boolean isModified) throws SystemException {
		Object[] finderArgs = new Object[] { Boolean.valueOf(isModified) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ISMODIFIED,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.cds.model.CdsEvaluationPeriods WHERE ");

				query.append("is_modified = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isModified);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ISMODIFIED,
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
						"SELECT COUNT(*) FROM larion.progate.cds.model.CdsEvaluationPeriods");

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
						"value.object.listener.larion.progate.cds.model.CdsEvaluationPeriods")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CdsEvaluationPeriods>> listenersList = new ArrayList<ModelListener<CdsEvaluationPeriods>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CdsEvaluationPeriods>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(CdsEvaluationPeriodsPersistenceImpl.class);
}