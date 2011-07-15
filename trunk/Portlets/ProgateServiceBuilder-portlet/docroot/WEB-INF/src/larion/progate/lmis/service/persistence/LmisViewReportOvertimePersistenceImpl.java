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

package larion.progate.lmis.service.persistence;

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
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import larion.progate.lmis.NoSuchLmisViewReportOvertimeException;
import larion.progate.lmis.model.LmisViewReportOvertime;
import larion.progate.lmis.model.impl.LmisViewReportOvertimeImpl;
import larion.progate.lmis.model.impl.LmisViewReportOvertimeModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * <a href="LmisViewReportOvertimePersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewReportOvertimePersistenceImpl extends BasePersistenceImpl
	implements LmisViewReportOvertimePersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = LmisViewReportOvertimeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_ROOTID = new FinderPath(LmisViewReportOvertimeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewReportOvertimeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ROOTID = new FinderPath(LmisViewReportOvertimeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewReportOvertimeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ROOTID = new FinderPath(LmisViewReportOvertimeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewReportOvertimeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByRootID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ORGID = new FinderPath(LmisViewReportOvertimeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewReportOvertimeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOrgID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ORGID = new FinderPath(LmisViewReportOvertimeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewReportOvertimeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOrgID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGID = new FinderPath(LmisViewReportOvertimeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewReportOvertimeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByOrgID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_REPORTEDAT = new FinderPath(LmisViewReportOvertimeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewReportOvertimeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByReportedAt",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_REPORTEDAT = new FinderPath(LmisViewReportOvertimeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewReportOvertimeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByReportedAt",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_REPORTEDAT = new FinderPath(LmisViewReportOvertimeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewReportOvertimeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByReportedAt",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_REPORTEDSTATUS = new FinderPath(LmisViewReportOvertimeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewReportOvertimeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByreportedStatus",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_REPORTEDSTATUS = new FinderPath(LmisViewReportOvertimeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewReportOvertimeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByreportedStatus",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_REPORTEDSTATUS = new FinderPath(LmisViewReportOvertimeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewReportOvertimeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByreportedStatus",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_REPORTEDBY = new FinderPath(LmisViewReportOvertimeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewReportOvertimeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByReportedBy",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_REPORTEDBY = new FinderPath(LmisViewReportOvertimeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewReportOvertimeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByReportedBy",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_REPORTEDBY = new FinderPath(LmisViewReportOvertimeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewReportOvertimeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByReportedBy",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_REPORTID = new FinderPath(LmisViewReportOvertimeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewReportOvertimeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByReportID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_REPORTID = new FinderPath(LmisViewReportOvertimeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewReportOvertimeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByReportID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_REPORTID = new FinderPath(LmisViewReportOvertimeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewReportOvertimeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByReportID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(LmisViewReportOvertimeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewReportOvertimeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LmisViewReportOvertimeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewReportOvertimeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(LmisViewReportOvertime lmisViewReportOvertime) {
		EntityCacheUtil.putResult(LmisViewReportOvertimeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewReportOvertimeImpl.class,
			lmisViewReportOvertime.getPrimaryKey(), lmisViewReportOvertime);
	}

	public void cacheResult(
		List<LmisViewReportOvertime> lmisViewReportOvertimes) {
		for (LmisViewReportOvertime lmisViewReportOvertime : lmisViewReportOvertimes) {
			if (EntityCacheUtil.getResult(
						LmisViewReportOvertimeModelImpl.ENTITY_CACHE_ENABLED,
						LmisViewReportOvertimeImpl.class,
						lmisViewReportOvertime.getPrimaryKey(), this) == null) {
				cacheResult(lmisViewReportOvertime);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(LmisViewReportOvertimeImpl.class.getName());
		EntityCacheUtil.clearCache(LmisViewReportOvertimeImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public LmisViewReportOvertime create(Integer lmisViewReportOvertimeId) {
		LmisViewReportOvertime lmisViewReportOvertime = new LmisViewReportOvertimeImpl();

		lmisViewReportOvertime.setNew(true);
		lmisViewReportOvertime.setPrimaryKey(lmisViewReportOvertimeId);

		return lmisViewReportOvertime;
	}

	public LmisViewReportOvertime remove(Integer lmisViewReportOvertimeId)
		throws NoSuchLmisViewReportOvertimeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LmisViewReportOvertime lmisViewReportOvertime = (LmisViewReportOvertime)session.get(LmisViewReportOvertimeImpl.class,
					lmisViewReportOvertimeId);

			if (lmisViewReportOvertime == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No LmisViewReportOvertime exists with the primary key " +
						lmisViewReportOvertimeId);
				}

				throw new NoSuchLmisViewReportOvertimeException(
					"No LmisViewReportOvertime exists with the primary key " +
					lmisViewReportOvertimeId);
			}

			return remove(lmisViewReportOvertime);
		}
		catch (NoSuchLmisViewReportOvertimeException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public LmisViewReportOvertime remove(
		LmisViewReportOvertime lmisViewReportOvertime)
		throws SystemException {
		for (ModelListener<LmisViewReportOvertime> listener : listeners) {
			listener.onBeforeRemove(lmisViewReportOvertime);
		}

		lmisViewReportOvertime = removeImpl(lmisViewReportOvertime);

		for (ModelListener<LmisViewReportOvertime> listener : listeners) {
			listener.onAfterRemove(lmisViewReportOvertime);
		}

		return lmisViewReportOvertime;
	}

	protected LmisViewReportOvertime removeImpl(
		LmisViewReportOvertime lmisViewReportOvertime)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (lmisViewReportOvertime.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(LmisViewReportOvertimeImpl.class,
						lmisViewReportOvertime.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(lmisViewReportOvertime);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(LmisViewReportOvertimeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewReportOvertimeImpl.class,
			lmisViewReportOvertime.getPrimaryKey());

		return lmisViewReportOvertime;
	}

	public LmisViewReportOvertime update(
		LmisViewReportOvertime lmisViewReportOvertime)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(LmisViewReportOvertime lmisViewReportOvertime) method. Use update(LmisViewReportOvertime lmisViewReportOvertime, boolean merge) instead.");
		}

		return update(lmisViewReportOvertime, false);
	}

	public LmisViewReportOvertime update(
		LmisViewReportOvertime lmisViewReportOvertime, boolean merge)
		throws SystemException {
		boolean isNew = lmisViewReportOvertime.isNew();

		for (ModelListener<LmisViewReportOvertime> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(lmisViewReportOvertime);
			}
			else {
				listener.onBeforeUpdate(lmisViewReportOvertime);
			}
		}

		lmisViewReportOvertime = updateImpl(lmisViewReportOvertime, merge);

		for (ModelListener<LmisViewReportOvertime> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(lmisViewReportOvertime);
			}
			else {
				listener.onAfterUpdate(lmisViewReportOvertime);
			}
		}

		return lmisViewReportOvertime;
	}

	public LmisViewReportOvertime updateImpl(
		larion.progate.lmis.model.LmisViewReportOvertime lmisViewReportOvertime,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, lmisViewReportOvertime, merge);

			lmisViewReportOvertime.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(LmisViewReportOvertimeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewReportOvertimeImpl.class,
			lmisViewReportOvertime.getPrimaryKey(), lmisViewReportOvertime);

		return lmisViewReportOvertime;
	}

	public LmisViewReportOvertime findByPrimaryKey(
		Integer lmisViewReportOvertimeId)
		throws NoSuchLmisViewReportOvertimeException, SystemException {
		LmisViewReportOvertime lmisViewReportOvertime = fetchByPrimaryKey(lmisViewReportOvertimeId);

		if (lmisViewReportOvertime == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"No LmisViewReportOvertime exists with the primary key " +
					lmisViewReportOvertimeId);
			}

			throw new NoSuchLmisViewReportOvertimeException(
				"No LmisViewReportOvertime exists with the primary key " +
				lmisViewReportOvertimeId);
		}

		return lmisViewReportOvertime;
	}

	public LmisViewReportOvertime fetchByPrimaryKey(
		Integer lmisViewReportOvertimeId) throws SystemException {
		LmisViewReportOvertime lmisViewReportOvertime = (LmisViewReportOvertime)EntityCacheUtil.getResult(LmisViewReportOvertimeModelImpl.ENTITY_CACHE_ENABLED,
				LmisViewReportOvertimeImpl.class, lmisViewReportOvertimeId, this);

		if (lmisViewReportOvertime == null) {
			Session session = null;

			try {
				session = openSession();

				lmisViewReportOvertime = (LmisViewReportOvertime)session.get(LmisViewReportOvertimeImpl.class,
						lmisViewReportOvertimeId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (lmisViewReportOvertime != null) {
					cacheResult(lmisViewReportOvertime);
				}

				closeSession(session);
			}
		}

		return lmisViewReportOvertime;
	}

	public List<LmisViewReportOvertime> findByRootID(int rootId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		List<LmisViewReportOvertime> list = (List<LmisViewReportOvertime>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewReportOvertime WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("reported_status ASC");

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
					list = new ArrayList<LmisViewReportOvertime>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewReportOvertime> findByRootID(int rootId, int start,
		int end) throws SystemException {
		return findByRootID(rootId, start, end, null);
	}

	public List<LmisViewReportOvertime> findByRootID(int rootId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(rootId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewReportOvertime> list = (List<LmisViewReportOvertime>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewReportOvertime WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("reported_status ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rootId);

				list = (List<LmisViewReportOvertime>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewReportOvertime>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewReportOvertime findByRootID_First(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisViewReportOvertimeException, SystemException {
		List<LmisViewReportOvertime> list = findByRootID(rootId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewReportOvertime exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewReportOvertimeException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewReportOvertime findByRootID_Last(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisViewReportOvertimeException, SystemException {
		int count = countByRootID(rootId);

		List<LmisViewReportOvertime> list = findByRootID(rootId, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewReportOvertime exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewReportOvertimeException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewReportOvertime[] findByRootID_PrevAndNext(
		Integer lmisViewReportOvertimeId, int rootId, OrderByComparator obc)
		throws NoSuchLmisViewReportOvertimeException, SystemException {
		LmisViewReportOvertime lmisViewReportOvertime = findByPrimaryKey(lmisViewReportOvertimeId);

		int count = countByRootID(rootId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewReportOvertime WHERE ");

			query.append("root_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("reported_status ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(rootId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisViewReportOvertime);

			LmisViewReportOvertime[] array = new LmisViewReportOvertimeImpl[3];

			array[0] = (LmisViewReportOvertime)objArray[0];
			array[1] = (LmisViewReportOvertime)objArray[1];
			array[2] = (LmisViewReportOvertime)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewReportOvertime> findByOrgID(int orgId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(orgId) };

		List<LmisViewReportOvertime> list = (List<LmisViewReportOvertime>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ORGID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewReportOvertime WHERE ");

				query.append("org_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("reported_status ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orgId);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewReportOvertime>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ORGID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewReportOvertime> findByOrgID(int orgId, int start,
		int end) throws SystemException {
		return findByOrgID(orgId, start, end, null);
	}

	public List<LmisViewReportOvertime> findByOrgID(int orgId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(orgId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewReportOvertime> list = (List<LmisViewReportOvertime>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ORGID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewReportOvertime WHERE ");

				query.append("org_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("reported_status ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orgId);

				list = (List<LmisViewReportOvertime>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewReportOvertime>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ORGID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewReportOvertime findByOrgID_First(int orgId,
		OrderByComparator obc)
		throws NoSuchLmisViewReportOvertimeException, SystemException {
		List<LmisViewReportOvertime> list = findByOrgID(orgId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewReportOvertime exists with the key {");

			msg.append("orgId=" + orgId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewReportOvertimeException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewReportOvertime findByOrgID_Last(int orgId,
		OrderByComparator obc)
		throws NoSuchLmisViewReportOvertimeException, SystemException {
		int count = countByOrgID(orgId);

		List<LmisViewReportOvertime> list = findByOrgID(orgId, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewReportOvertime exists with the key {");

			msg.append("orgId=" + orgId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewReportOvertimeException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewReportOvertime[] findByOrgID_PrevAndNext(
		Integer lmisViewReportOvertimeId, int orgId, OrderByComparator obc)
		throws NoSuchLmisViewReportOvertimeException, SystemException {
		LmisViewReportOvertime lmisViewReportOvertime = findByPrimaryKey(lmisViewReportOvertimeId);

		int count = countByOrgID(orgId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewReportOvertime WHERE ");

			query.append("org_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("reported_status ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(orgId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisViewReportOvertime);

			LmisViewReportOvertime[] array = new LmisViewReportOvertimeImpl[3];

			array[0] = (LmisViewReportOvertime)objArray[0];
			array[1] = (LmisViewReportOvertime)objArray[1];
			array[2] = (LmisViewReportOvertime)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewReportOvertime> findByReportedAt(Date reportedAt)
		throws SystemException {
		Object[] finderArgs = new Object[] { reportedAt };

		List<LmisViewReportOvertime> list = (List<LmisViewReportOvertime>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_REPORTEDAT,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewReportOvertime WHERE ");

				if (reportedAt == null) {
					query.append("reported_at IS NULL");
				}
				else {
					query.append("reported_at = ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("reported_status ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (reportedAt != null) {
					qPos.add(CalendarUtil.getTimestamp(reportedAt));
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewReportOvertime>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_REPORTEDAT,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewReportOvertime> findByReportedAt(Date reportedAt,
		int start, int end) throws SystemException {
		return findByReportedAt(reportedAt, start, end, null);
	}

	public List<LmisViewReportOvertime> findByReportedAt(Date reportedAt,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				reportedAt,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewReportOvertime> list = (List<LmisViewReportOvertime>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_REPORTEDAT,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewReportOvertime WHERE ");

				if (reportedAt == null) {
					query.append("reported_at IS NULL");
				}
				else {
					query.append("reported_at = ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("reported_status ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (reportedAt != null) {
					qPos.add(CalendarUtil.getTimestamp(reportedAt));
				}

				list = (List<LmisViewReportOvertime>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewReportOvertime>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_REPORTEDAT,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewReportOvertime findByReportedAt_First(Date reportedAt,
		OrderByComparator obc)
		throws NoSuchLmisViewReportOvertimeException, SystemException {
		List<LmisViewReportOvertime> list = findByReportedAt(reportedAt, 0, 1,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewReportOvertime exists with the key {");

			msg.append("reportedAt=" + reportedAt);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewReportOvertimeException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewReportOvertime findByReportedAt_Last(Date reportedAt,
		OrderByComparator obc)
		throws NoSuchLmisViewReportOvertimeException, SystemException {
		int count = countByReportedAt(reportedAt);

		List<LmisViewReportOvertime> list = findByReportedAt(reportedAt,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewReportOvertime exists with the key {");

			msg.append("reportedAt=" + reportedAt);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewReportOvertimeException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewReportOvertime[] findByReportedAt_PrevAndNext(
		Integer lmisViewReportOvertimeId, Date reportedAt, OrderByComparator obc)
		throws NoSuchLmisViewReportOvertimeException, SystemException {
		LmisViewReportOvertime lmisViewReportOvertime = findByPrimaryKey(lmisViewReportOvertimeId);

		int count = countByReportedAt(reportedAt);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewReportOvertime WHERE ");

			if (reportedAt == null) {
				query.append("reported_at IS NULL");
			}
			else {
				query.append("reported_at = ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("reported_status ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (reportedAt != null) {
				qPos.add(CalendarUtil.getTimestamp(reportedAt));
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisViewReportOvertime);

			LmisViewReportOvertime[] array = new LmisViewReportOvertimeImpl[3];

			array[0] = (LmisViewReportOvertime)objArray[0];
			array[1] = (LmisViewReportOvertime)objArray[1];
			array[2] = (LmisViewReportOvertime)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewReportOvertime> findByreportedStatus(int reportedStatus)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(reportedStatus) };

		List<LmisViewReportOvertime> list = (List<LmisViewReportOvertime>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_REPORTEDSTATUS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewReportOvertime WHERE ");

				query.append("reported_status = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("reported_status ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(reportedStatus);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewReportOvertime>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_REPORTEDSTATUS,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewReportOvertime> findByreportedStatus(
		int reportedStatus, int start, int end) throws SystemException {
		return findByreportedStatus(reportedStatus, start, end, null);
	}

	public List<LmisViewReportOvertime> findByreportedStatus(
		int reportedStatus, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(reportedStatus),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewReportOvertime> list = (List<LmisViewReportOvertime>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_REPORTEDSTATUS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewReportOvertime WHERE ");

				query.append("reported_status = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("reported_status ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(reportedStatus);

				list = (List<LmisViewReportOvertime>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewReportOvertime>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_REPORTEDSTATUS,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewReportOvertime findByreportedStatus_First(
		int reportedStatus, OrderByComparator obc)
		throws NoSuchLmisViewReportOvertimeException, SystemException {
		List<LmisViewReportOvertime> list = findByreportedStatus(reportedStatus,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewReportOvertime exists with the key {");

			msg.append("reportedStatus=" + reportedStatus);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewReportOvertimeException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewReportOvertime findByreportedStatus_Last(
		int reportedStatus, OrderByComparator obc)
		throws NoSuchLmisViewReportOvertimeException, SystemException {
		int count = countByreportedStatus(reportedStatus);

		List<LmisViewReportOvertime> list = findByreportedStatus(reportedStatus,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewReportOvertime exists with the key {");

			msg.append("reportedStatus=" + reportedStatus);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewReportOvertimeException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewReportOvertime[] findByreportedStatus_PrevAndNext(
		Integer lmisViewReportOvertimeId, int reportedStatus,
		OrderByComparator obc)
		throws NoSuchLmisViewReportOvertimeException, SystemException {
		LmisViewReportOvertime lmisViewReportOvertime = findByPrimaryKey(lmisViewReportOvertimeId);

		int count = countByreportedStatus(reportedStatus);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewReportOvertime WHERE ");

			query.append("reported_status = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("reported_status ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(reportedStatus);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisViewReportOvertime);

			LmisViewReportOvertime[] array = new LmisViewReportOvertimeImpl[3];

			array[0] = (LmisViewReportOvertime)objArray[0];
			array[1] = (LmisViewReportOvertime)objArray[1];
			array[2] = (LmisViewReportOvertime)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewReportOvertime> findByReportedBy(int reportedBy)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(reportedBy) };

		List<LmisViewReportOvertime> list = (List<LmisViewReportOvertime>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_REPORTEDBY,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewReportOvertime WHERE ");

				query.append("reported_by = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("reported_status ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(reportedBy);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewReportOvertime>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_REPORTEDBY,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewReportOvertime> findByReportedBy(int reportedBy,
		int start, int end) throws SystemException {
		return findByReportedBy(reportedBy, start, end, null);
	}

	public List<LmisViewReportOvertime> findByReportedBy(int reportedBy,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(reportedBy),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewReportOvertime> list = (List<LmisViewReportOvertime>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_REPORTEDBY,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewReportOvertime WHERE ");

				query.append("reported_by = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("reported_status ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(reportedBy);

				list = (List<LmisViewReportOvertime>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewReportOvertime>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_REPORTEDBY,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewReportOvertime findByReportedBy_First(int reportedBy,
		OrderByComparator obc)
		throws NoSuchLmisViewReportOvertimeException, SystemException {
		List<LmisViewReportOvertime> list = findByReportedBy(reportedBy, 0, 1,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewReportOvertime exists with the key {");

			msg.append("reportedBy=" + reportedBy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewReportOvertimeException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewReportOvertime findByReportedBy_Last(int reportedBy,
		OrderByComparator obc)
		throws NoSuchLmisViewReportOvertimeException, SystemException {
		int count = countByReportedBy(reportedBy);

		List<LmisViewReportOvertime> list = findByReportedBy(reportedBy,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewReportOvertime exists with the key {");

			msg.append("reportedBy=" + reportedBy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewReportOvertimeException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewReportOvertime[] findByReportedBy_PrevAndNext(
		Integer lmisViewReportOvertimeId, int reportedBy, OrderByComparator obc)
		throws NoSuchLmisViewReportOvertimeException, SystemException {
		LmisViewReportOvertime lmisViewReportOvertime = findByPrimaryKey(lmisViewReportOvertimeId);

		int count = countByReportedBy(reportedBy);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewReportOvertime WHERE ");

			query.append("reported_by = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("reported_status ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(reportedBy);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisViewReportOvertime);

			LmisViewReportOvertime[] array = new LmisViewReportOvertimeImpl[3];

			array[0] = (LmisViewReportOvertime)objArray[0];
			array[1] = (LmisViewReportOvertime)objArray[1];
			array[2] = (LmisViewReportOvertime)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewReportOvertime> findByReportID(int reportId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(reportId) };

		List<LmisViewReportOvertime> list = (List<LmisViewReportOvertime>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_REPORTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewReportOvertime WHERE ");

				query.append("report_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("reported_status ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(reportId);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewReportOvertime>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_REPORTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewReportOvertime> findByReportID(int reportId, int start,
		int end) throws SystemException {
		return findByReportID(reportId, start, end, null);
	}

	public List<LmisViewReportOvertime> findByReportID(int reportId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(reportId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewReportOvertime> list = (List<LmisViewReportOvertime>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_REPORTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewReportOvertime WHERE ");

				query.append("report_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("reported_status ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(reportId);

				list = (List<LmisViewReportOvertime>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewReportOvertime>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_REPORTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewReportOvertime findByReportID_First(int reportId,
		OrderByComparator obc)
		throws NoSuchLmisViewReportOvertimeException, SystemException {
		List<LmisViewReportOvertime> list = findByReportID(reportId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewReportOvertime exists with the key {");

			msg.append("reportId=" + reportId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewReportOvertimeException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewReportOvertime findByReportID_Last(int reportId,
		OrderByComparator obc)
		throws NoSuchLmisViewReportOvertimeException, SystemException {
		int count = countByReportID(reportId);

		List<LmisViewReportOvertime> list = findByReportID(reportId, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewReportOvertime exists with the key {");

			msg.append("reportId=" + reportId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewReportOvertimeException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewReportOvertime[] findByReportID_PrevAndNext(
		Integer lmisViewReportOvertimeId, int reportId, OrderByComparator obc)
		throws NoSuchLmisViewReportOvertimeException, SystemException {
		LmisViewReportOvertime lmisViewReportOvertime = findByPrimaryKey(lmisViewReportOvertimeId);

		int count = countByReportID(reportId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewReportOvertime WHERE ");

			query.append("report_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("reported_status ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(reportId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisViewReportOvertime);

			LmisViewReportOvertime[] array = new LmisViewReportOvertimeImpl[3];

			array[0] = (LmisViewReportOvertime)objArray[0];
			array[1] = (LmisViewReportOvertime)objArray[1];
			array[2] = (LmisViewReportOvertime)objArray[2];

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

	public List<LmisViewReportOvertime> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<LmisViewReportOvertime> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<LmisViewReportOvertime> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewReportOvertime> list = (List<LmisViewReportOvertime>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewReportOvertime ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("reported_status ASC");
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<LmisViewReportOvertime>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LmisViewReportOvertime>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewReportOvertime>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByRootID(int rootId) throws SystemException {
		for (LmisViewReportOvertime lmisViewReportOvertime : findByRootID(
				rootId)) {
			remove(lmisViewReportOvertime);
		}
	}

	public void removeByOrgID(int orgId) throws SystemException {
		for (LmisViewReportOvertime lmisViewReportOvertime : findByOrgID(orgId)) {
			remove(lmisViewReportOvertime);
		}
	}

	public void removeByReportedAt(Date reportedAt) throws SystemException {
		for (LmisViewReportOvertime lmisViewReportOvertime : findByReportedAt(
				reportedAt)) {
			remove(lmisViewReportOvertime);
		}
	}

	public void removeByreportedStatus(int reportedStatus)
		throws SystemException {
		for (LmisViewReportOvertime lmisViewReportOvertime : findByreportedStatus(
				reportedStatus)) {
			remove(lmisViewReportOvertime);
		}
	}

	public void removeByReportedBy(int reportedBy) throws SystemException {
		for (LmisViewReportOvertime lmisViewReportOvertime : findByReportedBy(
				reportedBy)) {
			remove(lmisViewReportOvertime);
		}
	}

	public void removeByReportID(int reportId) throws SystemException {
		for (LmisViewReportOvertime lmisViewReportOvertime : findByReportID(
				reportId)) {
			remove(lmisViewReportOvertime);
		}
	}

	public void removeAll() throws SystemException {
		for (LmisViewReportOvertime lmisViewReportOvertime : findAll()) {
			remove(lmisViewReportOvertime);
		}
	}

	public int countByRootID(int rootId) throws SystemException {
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
					"FROM larion.progate.lmis.model.LmisViewReportOvertime WHERE ");

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

	public int countByOrgID(int orgId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(orgId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ORGID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisViewReportOvertime WHERE ");

				query.append("org_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orgId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ORGID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByReportedAt(Date reportedAt) throws SystemException {
		Object[] finderArgs = new Object[] { reportedAt };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_REPORTEDAT,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisViewReportOvertime WHERE ");

				if (reportedAt == null) {
					query.append("reported_at IS NULL");
				}
				else {
					query.append("reported_at = ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (reportedAt != null) {
					qPos.add(CalendarUtil.getTimestamp(reportedAt));
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_REPORTEDAT,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByreportedStatus(int reportedStatus)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(reportedStatus) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_REPORTEDSTATUS,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisViewReportOvertime WHERE ");

				query.append("reported_status = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(reportedStatus);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_REPORTEDSTATUS,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByReportedBy(int reportedBy) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(reportedBy) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_REPORTEDBY,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisViewReportOvertime WHERE ");

				query.append("reported_by = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(reportedBy);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_REPORTEDBY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByReportID(int reportId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(reportId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_REPORTID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisViewReportOvertime WHERE ");

				query.append("report_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(reportId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_REPORTID,
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
						"SELECT COUNT(*) FROM larion.progate.lmis.model.LmisViewReportOvertime");

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
						"value.object.listener.larion.progate.lmis.model.LmisViewReportOvertime")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LmisViewReportOvertime>> listenersList = new ArrayList<ModelListener<LmisViewReportOvertime>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LmisViewReportOvertime>)Class.forName(
							listenerClassName).newInstance());
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisEmailSettingsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisEmailSettingsPersistence lmisEmailSettingsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisEmailSettingDetailsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisEmailSettingDetailsPersistence lmisEmailSettingDetailsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisTimeChangeApprovalsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisTimeChangeApprovalsPersistence lmisTimeChangeApprovalsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisTimeChangeRequestsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisTimeChangeRequestsPersistence lmisTimeChangeRequestsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisWorkingTimesPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisWorkingTimesPersistence lmisWorkingTimesPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisDayTypesPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisDayTypesPersistence lmisDayTypesPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisWorkingCalendarsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisWorkingCalendarsPersistence lmisWorkingCalendarsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisWorkingCalendarSessionsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisWorkingCalendarSessionsPersistence lmisWorkingCalendarSessionsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisGeneralSettingsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisGeneralSettingsPersistence lmisGeneralSettingsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewStaffMappingPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewStaffMappingPersistence lmisViewStaffMappingPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewStaffRootOrgPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewStaffRootOrgPersistence lmisViewStaffRootOrgPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewStaffRootOrgFNPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewStaffRootOrgFNPersistence lmisViewStaffRootOrgFNPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewStaffRootOrgOrderedPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewStaffRootOrgOrderedPersistence lmisViewStaffRootOrgOrderedPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewTimeChangeReqsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewTimeChangeReqsPersistence lmisViewTimeChangeReqsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewEmailSettingDetailOrgPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewEmailSettingDetailOrgPersistence lmisViewEmailSettingDetailOrgPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewEmailSettingDetailUserPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewEmailSettingDetailUserPersistence lmisViewEmailSettingDetailUserPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewWorkingCalendarPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewWorkingCalendarPersistence lmisViewWorkingCalendarPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisOverTimeSettingsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisOverTimeSettingsPersistence lmisOverTimeSettingsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisOverTimeTypesPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisOverTimeTypesPersistence lmisOverTimeTypesPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisDataInputsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisDataInputsPersistence lmisDataInputsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisAttendanceDailyPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisAttendanceDailyPersistence lmisAttendanceDailyPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisOvertimeRequestsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisOvertimeRequestsPersistence lmisOvertimeRequestsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisOvertimeRequestDetailsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisOvertimeRequestDetailsPersistence lmisOvertimeRequestDetailsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisOvertimeApprovalsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisOvertimeApprovalsPersistence lmisOvertimeApprovalsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisOvertimeMonthlyPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisOvertimeMonthlyPersistence lmisOvertimeMonthlyPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisDataImportsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisDataImportsPersistence lmisDataImportsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisDataImportDetailsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisDataImportDetailsPersistence lmisDataImportDetailsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisOverTimeReportHoursPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisOverTimeReportHoursPersistence lmisOverTimeReportHoursPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisOverTimeReportDetailsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisOverTimeReportDetailsPersistence lmisOverTimeReportDetailsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisOverTimeReportsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisOverTimeReportsPersistence lmisOverTimeReportsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisOvertimeYearlyPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisOvertimeYearlyPersistence lmisOvertimeYearlyPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisAbsenceYearlyPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisAbsenceYearlyPersistence lmisAbsenceYearlyPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisAbsenceMonthlyPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisAbsenceMonthlyPersistence lmisAbsenceMonthlyPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisAbsenceSettingsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisAbsenceSettingsPersistence lmisAbsenceSettingsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisAbsenceApprovalsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisAbsenceApprovalsPersistence lmisAbsenceApprovalsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisAbsenceRequestsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisAbsenceRequestsPersistence lmisAbsenceRequestsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewDayTypeOverTimeSettingTypePersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewDayTypeOverTimeSettingTypePersistence lmisViewDayTypeOverTimeSettingTypePersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewRegistrationOvertimePersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewRegistrationOvertimePersistence lmisViewRegistrationOvertimePersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewRegistrationOvertimeaApprovalPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewRegistrationOvertimeaApprovalPersistence lmisViewRegistrationOvertimeaApprovalPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewOTAppPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewOTAppPersistence lmisViewOTAppPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewReportOvertimePersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewReportOvertimePersistence lmisViewReportOvertimePersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewAttDailyPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewAttDailyPersistence lmisViewAttDailyPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewReportOvertimeApprovalPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewReportOvertimeApprovalPersistence lmisViewReportOvertimeApprovalPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewDayValueMaxPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewDayValueMaxPersistence lmisViewDayValueMaxPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewOrgUserRolesPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewOrgUserRolesPersistence lmisViewOrgUserRolesPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewAttInfoPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewAttInfoPersistence lmisViewAttInfoPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewStaffMappingPmPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewStaffMappingPmPersistence lmisViewStaffMappingPmPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewAttdancePersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewAttdancePersistence lmisViewAttdancePersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewOvertimeReportPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewOvertimeReportPersistence lmisViewOvertimeReportPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewOvertimeReportDetailPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewOvertimeReportDetailPersistence lmisViewOvertimeReportDetailPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisAttMonthlyPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisAttMonthlyPersistence lmisAttMonthlyPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisAttYearlyPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisAttYearlyPersistence lmisAttYearlyPersistence;
	private static Log _log = LogFactoryUtil.getLog(LmisViewReportOvertimePersistenceImpl.class);
}