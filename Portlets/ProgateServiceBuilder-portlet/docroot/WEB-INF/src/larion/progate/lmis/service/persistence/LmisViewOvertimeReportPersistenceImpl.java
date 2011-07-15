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

import larion.progate.lmis.NoSuchLmisViewOvertimeReportException;
import larion.progate.lmis.model.LmisViewOvertimeReport;
import larion.progate.lmis.model.impl.LmisViewOvertimeReportImpl;
import larion.progate.lmis.model.impl.LmisViewOvertimeReportModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * <a href="LmisViewOvertimeReportPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewOvertimeReportPersistenceImpl extends BasePersistenceImpl
	implements LmisViewOvertimeReportPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = LmisViewOvertimeReportImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_ROOTID = new FinderPath(LmisViewOvertimeReportModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewOvertimeReportModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ROOTID = new FinderPath(LmisViewOvertimeReportModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewOvertimeReportModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ROOTID = new FinderPath(LmisViewOvertimeReportModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewOvertimeReportModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByRootID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ORGID = new FinderPath(LmisViewOvertimeReportModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewOvertimeReportModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOrgID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ORGID = new FinderPath(LmisViewOvertimeReportModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewOvertimeReportModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOrgID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGID = new FinderPath(LmisViewOvertimeReportModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewOvertimeReportModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByOrgID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_REPORTEDAT = new FinderPath(LmisViewOvertimeReportModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewOvertimeReportModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByReportedAt",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_REPORTEDAT = new FinderPath(LmisViewOvertimeReportModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewOvertimeReportModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByReportedAt",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_REPORTEDAT = new FinderPath(LmisViewOvertimeReportModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewOvertimeReportModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByReportedAt",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_REPORTEDSTATUS = new FinderPath(LmisViewOvertimeReportModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewOvertimeReportModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByreportedStatus",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_REPORTEDSTATUS = new FinderPath(LmisViewOvertimeReportModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewOvertimeReportModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByreportedStatus",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_REPORTEDSTATUS = new FinderPath(LmisViewOvertimeReportModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewOvertimeReportModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByreportedStatus",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_REPORTEDBY = new FinderPath(LmisViewOvertimeReportModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewOvertimeReportModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByReportedBy",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_REPORTEDBY = new FinderPath(LmisViewOvertimeReportModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewOvertimeReportModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByReportedBy",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_REPORTEDBY = new FinderPath(LmisViewOvertimeReportModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewOvertimeReportModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByReportedBy",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(LmisViewOvertimeReportModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewOvertimeReportModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LmisViewOvertimeReportModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewOvertimeReportModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(LmisViewOvertimeReport lmisViewOvertimeReport) {
		EntityCacheUtil.putResult(LmisViewOvertimeReportModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewOvertimeReportImpl.class,
			lmisViewOvertimeReport.getPrimaryKey(), lmisViewOvertimeReport);
	}

	public void cacheResult(
		List<LmisViewOvertimeReport> lmisViewOvertimeReports) {
		for (LmisViewOvertimeReport lmisViewOvertimeReport : lmisViewOvertimeReports) {
			if (EntityCacheUtil.getResult(
						LmisViewOvertimeReportModelImpl.ENTITY_CACHE_ENABLED,
						LmisViewOvertimeReportImpl.class,
						lmisViewOvertimeReport.getPrimaryKey(), this) == null) {
				cacheResult(lmisViewOvertimeReport);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(LmisViewOvertimeReportImpl.class.getName());
		EntityCacheUtil.clearCache(LmisViewOvertimeReportImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public LmisViewOvertimeReport create(Integer lmisViewOvertimeReportId) {
		LmisViewOvertimeReport lmisViewOvertimeReport = new LmisViewOvertimeReportImpl();

		lmisViewOvertimeReport.setNew(true);
		lmisViewOvertimeReport.setPrimaryKey(lmisViewOvertimeReportId);

		return lmisViewOvertimeReport;
	}

	public LmisViewOvertimeReport remove(Integer lmisViewOvertimeReportId)
		throws NoSuchLmisViewOvertimeReportException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LmisViewOvertimeReport lmisViewOvertimeReport = (LmisViewOvertimeReport)session.get(LmisViewOvertimeReportImpl.class,
					lmisViewOvertimeReportId);

			if (lmisViewOvertimeReport == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No LmisViewOvertimeReport exists with the primary key " +
						lmisViewOvertimeReportId);
				}

				throw new NoSuchLmisViewOvertimeReportException(
					"No LmisViewOvertimeReport exists with the primary key " +
					lmisViewOvertimeReportId);
			}

			return remove(lmisViewOvertimeReport);
		}
		catch (NoSuchLmisViewOvertimeReportException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public LmisViewOvertimeReport remove(
		LmisViewOvertimeReport lmisViewOvertimeReport)
		throws SystemException {
		for (ModelListener<LmisViewOvertimeReport> listener : listeners) {
			listener.onBeforeRemove(lmisViewOvertimeReport);
		}

		lmisViewOvertimeReport = removeImpl(lmisViewOvertimeReport);

		for (ModelListener<LmisViewOvertimeReport> listener : listeners) {
			listener.onAfterRemove(lmisViewOvertimeReport);
		}

		return lmisViewOvertimeReport;
	}

	protected LmisViewOvertimeReport removeImpl(
		LmisViewOvertimeReport lmisViewOvertimeReport)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (lmisViewOvertimeReport.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(LmisViewOvertimeReportImpl.class,
						lmisViewOvertimeReport.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(lmisViewOvertimeReport);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(LmisViewOvertimeReportModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewOvertimeReportImpl.class,
			lmisViewOvertimeReport.getPrimaryKey());

		return lmisViewOvertimeReport;
	}

	public LmisViewOvertimeReport update(
		LmisViewOvertimeReport lmisViewOvertimeReport)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(LmisViewOvertimeReport lmisViewOvertimeReport) method. Use update(LmisViewOvertimeReport lmisViewOvertimeReport, boolean merge) instead.");
		}

		return update(lmisViewOvertimeReport, false);
	}

	public LmisViewOvertimeReport update(
		LmisViewOvertimeReport lmisViewOvertimeReport, boolean merge)
		throws SystemException {
		boolean isNew = lmisViewOvertimeReport.isNew();

		for (ModelListener<LmisViewOvertimeReport> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(lmisViewOvertimeReport);
			}
			else {
				listener.onBeforeUpdate(lmisViewOvertimeReport);
			}
		}

		lmisViewOvertimeReport = updateImpl(lmisViewOvertimeReport, merge);

		for (ModelListener<LmisViewOvertimeReport> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(lmisViewOvertimeReport);
			}
			else {
				listener.onAfterUpdate(lmisViewOvertimeReport);
			}
		}

		return lmisViewOvertimeReport;
	}

	public LmisViewOvertimeReport updateImpl(
		larion.progate.lmis.model.LmisViewOvertimeReport lmisViewOvertimeReport,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, lmisViewOvertimeReport, merge);

			lmisViewOvertimeReport.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(LmisViewOvertimeReportModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewOvertimeReportImpl.class,
			lmisViewOvertimeReport.getPrimaryKey(), lmisViewOvertimeReport);

		return lmisViewOvertimeReport;
	}

	public LmisViewOvertimeReport findByPrimaryKey(
		Integer lmisViewOvertimeReportId)
		throws NoSuchLmisViewOvertimeReportException, SystemException {
		LmisViewOvertimeReport lmisViewOvertimeReport = fetchByPrimaryKey(lmisViewOvertimeReportId);

		if (lmisViewOvertimeReport == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"No LmisViewOvertimeReport exists with the primary key " +
					lmisViewOvertimeReportId);
			}

			throw new NoSuchLmisViewOvertimeReportException(
				"No LmisViewOvertimeReport exists with the primary key " +
				lmisViewOvertimeReportId);
		}

		return lmisViewOvertimeReport;
	}

	public LmisViewOvertimeReport fetchByPrimaryKey(
		Integer lmisViewOvertimeReportId) throws SystemException {
		LmisViewOvertimeReport lmisViewOvertimeReport = (LmisViewOvertimeReport)EntityCacheUtil.getResult(LmisViewOvertimeReportModelImpl.ENTITY_CACHE_ENABLED,
				LmisViewOvertimeReportImpl.class, lmisViewOvertimeReportId, this);

		if (lmisViewOvertimeReport == null) {
			Session session = null;

			try {
				session = openSession();

				lmisViewOvertimeReport = (LmisViewOvertimeReport)session.get(LmisViewOvertimeReportImpl.class,
						lmisViewOvertimeReportId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (lmisViewOvertimeReport != null) {
					cacheResult(lmisViewOvertimeReport);
				}

				closeSession(session);
			}
		}

		return lmisViewOvertimeReport;
	}

	public List<LmisViewOvertimeReport> findByRootID(int rootId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		List<LmisViewOvertimeReport> list = (List<LmisViewOvertimeReport>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewOvertimeReport WHERE ");

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
					list = new ArrayList<LmisViewOvertimeReport>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewOvertimeReport> findByRootID(int rootId, int start,
		int end) throws SystemException {
		return findByRootID(rootId, start, end, null);
	}

	public List<LmisViewOvertimeReport> findByRootID(int rootId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(rootId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewOvertimeReport> list = (List<LmisViewOvertimeReport>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewOvertimeReport WHERE ");

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

				list = (List<LmisViewOvertimeReport>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewOvertimeReport>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewOvertimeReport findByRootID_First(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisViewOvertimeReportException, SystemException {
		List<LmisViewOvertimeReport> list = findByRootID(rootId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewOvertimeReport exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewOvertimeReportException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewOvertimeReport findByRootID_Last(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisViewOvertimeReportException, SystemException {
		int count = countByRootID(rootId);

		List<LmisViewOvertimeReport> list = findByRootID(rootId, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewOvertimeReport exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewOvertimeReportException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewOvertimeReport[] findByRootID_PrevAndNext(
		Integer lmisViewOvertimeReportId, int rootId, OrderByComparator obc)
		throws NoSuchLmisViewOvertimeReportException, SystemException {
		LmisViewOvertimeReport lmisViewOvertimeReport = findByPrimaryKey(lmisViewOvertimeReportId);

		int count = countByRootID(rootId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewOvertimeReport WHERE ");

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
					lmisViewOvertimeReport);

			LmisViewOvertimeReport[] array = new LmisViewOvertimeReportImpl[3];

			array[0] = (LmisViewOvertimeReport)objArray[0];
			array[1] = (LmisViewOvertimeReport)objArray[1];
			array[2] = (LmisViewOvertimeReport)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewOvertimeReport> findByOrgID(int orgId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(orgId) };

		List<LmisViewOvertimeReport> list = (List<LmisViewOvertimeReport>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ORGID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewOvertimeReport WHERE ");

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
					list = new ArrayList<LmisViewOvertimeReport>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ORGID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewOvertimeReport> findByOrgID(int orgId, int start,
		int end) throws SystemException {
		return findByOrgID(orgId, start, end, null);
	}

	public List<LmisViewOvertimeReport> findByOrgID(int orgId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(orgId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewOvertimeReport> list = (List<LmisViewOvertimeReport>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ORGID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewOvertimeReport WHERE ");

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

				list = (List<LmisViewOvertimeReport>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewOvertimeReport>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ORGID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewOvertimeReport findByOrgID_First(int orgId,
		OrderByComparator obc)
		throws NoSuchLmisViewOvertimeReportException, SystemException {
		List<LmisViewOvertimeReport> list = findByOrgID(orgId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewOvertimeReport exists with the key {");

			msg.append("orgId=" + orgId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewOvertimeReportException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewOvertimeReport findByOrgID_Last(int orgId,
		OrderByComparator obc)
		throws NoSuchLmisViewOvertimeReportException, SystemException {
		int count = countByOrgID(orgId);

		List<LmisViewOvertimeReport> list = findByOrgID(orgId, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewOvertimeReport exists with the key {");

			msg.append("orgId=" + orgId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewOvertimeReportException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewOvertimeReport[] findByOrgID_PrevAndNext(
		Integer lmisViewOvertimeReportId, int orgId, OrderByComparator obc)
		throws NoSuchLmisViewOvertimeReportException, SystemException {
		LmisViewOvertimeReport lmisViewOvertimeReport = findByPrimaryKey(lmisViewOvertimeReportId);

		int count = countByOrgID(orgId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewOvertimeReport WHERE ");

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
					lmisViewOvertimeReport);

			LmisViewOvertimeReport[] array = new LmisViewOvertimeReportImpl[3];

			array[0] = (LmisViewOvertimeReport)objArray[0];
			array[1] = (LmisViewOvertimeReport)objArray[1];
			array[2] = (LmisViewOvertimeReport)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewOvertimeReport> findByReportedAt(Date reportedAt)
		throws SystemException {
		Object[] finderArgs = new Object[] { reportedAt };

		List<LmisViewOvertimeReport> list = (List<LmisViewOvertimeReport>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_REPORTEDAT,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewOvertimeReport WHERE ");

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
					list = new ArrayList<LmisViewOvertimeReport>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_REPORTEDAT,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewOvertimeReport> findByReportedAt(Date reportedAt,
		int start, int end) throws SystemException {
		return findByReportedAt(reportedAt, start, end, null);
	}

	public List<LmisViewOvertimeReport> findByReportedAt(Date reportedAt,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				reportedAt,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewOvertimeReport> list = (List<LmisViewOvertimeReport>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_REPORTEDAT,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewOvertimeReport WHERE ");

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

				list = (List<LmisViewOvertimeReport>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewOvertimeReport>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_REPORTEDAT,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewOvertimeReport findByReportedAt_First(Date reportedAt,
		OrderByComparator obc)
		throws NoSuchLmisViewOvertimeReportException, SystemException {
		List<LmisViewOvertimeReport> list = findByReportedAt(reportedAt, 0, 1,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewOvertimeReport exists with the key {");

			msg.append("reportedAt=" + reportedAt);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewOvertimeReportException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewOvertimeReport findByReportedAt_Last(Date reportedAt,
		OrderByComparator obc)
		throws NoSuchLmisViewOvertimeReportException, SystemException {
		int count = countByReportedAt(reportedAt);

		List<LmisViewOvertimeReport> list = findByReportedAt(reportedAt,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewOvertimeReport exists with the key {");

			msg.append("reportedAt=" + reportedAt);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewOvertimeReportException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewOvertimeReport[] findByReportedAt_PrevAndNext(
		Integer lmisViewOvertimeReportId, Date reportedAt, OrderByComparator obc)
		throws NoSuchLmisViewOvertimeReportException, SystemException {
		LmisViewOvertimeReport lmisViewOvertimeReport = findByPrimaryKey(lmisViewOvertimeReportId);

		int count = countByReportedAt(reportedAt);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewOvertimeReport WHERE ");

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
					lmisViewOvertimeReport);

			LmisViewOvertimeReport[] array = new LmisViewOvertimeReportImpl[3];

			array[0] = (LmisViewOvertimeReport)objArray[0];
			array[1] = (LmisViewOvertimeReport)objArray[1];
			array[2] = (LmisViewOvertimeReport)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewOvertimeReport> findByreportedStatus(int reportedStatus)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(reportedStatus) };

		List<LmisViewOvertimeReport> list = (List<LmisViewOvertimeReport>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_REPORTEDSTATUS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewOvertimeReport WHERE ");

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
					list = new ArrayList<LmisViewOvertimeReport>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_REPORTEDSTATUS,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewOvertimeReport> findByreportedStatus(
		int reportedStatus, int start, int end) throws SystemException {
		return findByreportedStatus(reportedStatus, start, end, null);
	}

	public List<LmisViewOvertimeReport> findByreportedStatus(
		int reportedStatus, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(reportedStatus),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewOvertimeReport> list = (List<LmisViewOvertimeReport>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_REPORTEDSTATUS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewOvertimeReport WHERE ");

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

				list = (List<LmisViewOvertimeReport>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewOvertimeReport>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_REPORTEDSTATUS,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewOvertimeReport findByreportedStatus_First(
		int reportedStatus, OrderByComparator obc)
		throws NoSuchLmisViewOvertimeReportException, SystemException {
		List<LmisViewOvertimeReport> list = findByreportedStatus(reportedStatus,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewOvertimeReport exists with the key {");

			msg.append("reportedStatus=" + reportedStatus);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewOvertimeReportException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewOvertimeReport findByreportedStatus_Last(
		int reportedStatus, OrderByComparator obc)
		throws NoSuchLmisViewOvertimeReportException, SystemException {
		int count = countByreportedStatus(reportedStatus);

		List<LmisViewOvertimeReport> list = findByreportedStatus(reportedStatus,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewOvertimeReport exists with the key {");

			msg.append("reportedStatus=" + reportedStatus);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewOvertimeReportException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewOvertimeReport[] findByreportedStatus_PrevAndNext(
		Integer lmisViewOvertimeReportId, int reportedStatus,
		OrderByComparator obc)
		throws NoSuchLmisViewOvertimeReportException, SystemException {
		LmisViewOvertimeReport lmisViewOvertimeReport = findByPrimaryKey(lmisViewOvertimeReportId);

		int count = countByreportedStatus(reportedStatus);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewOvertimeReport WHERE ");

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
					lmisViewOvertimeReport);

			LmisViewOvertimeReport[] array = new LmisViewOvertimeReportImpl[3];

			array[0] = (LmisViewOvertimeReport)objArray[0];
			array[1] = (LmisViewOvertimeReport)objArray[1];
			array[2] = (LmisViewOvertimeReport)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewOvertimeReport> findByReportedBy(int reportedBy)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(reportedBy) };

		List<LmisViewOvertimeReport> list = (List<LmisViewOvertimeReport>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_REPORTEDBY,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewOvertimeReport WHERE ");

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
					list = new ArrayList<LmisViewOvertimeReport>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_REPORTEDBY,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewOvertimeReport> findByReportedBy(int reportedBy,
		int start, int end) throws SystemException {
		return findByReportedBy(reportedBy, start, end, null);
	}

	public List<LmisViewOvertimeReport> findByReportedBy(int reportedBy,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(reportedBy),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewOvertimeReport> list = (List<LmisViewOvertimeReport>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_REPORTEDBY,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewOvertimeReport WHERE ");

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

				list = (List<LmisViewOvertimeReport>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewOvertimeReport>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_REPORTEDBY,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewOvertimeReport findByReportedBy_First(int reportedBy,
		OrderByComparator obc)
		throws NoSuchLmisViewOvertimeReportException, SystemException {
		List<LmisViewOvertimeReport> list = findByReportedBy(reportedBy, 0, 1,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewOvertimeReport exists with the key {");

			msg.append("reportedBy=" + reportedBy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewOvertimeReportException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewOvertimeReport findByReportedBy_Last(int reportedBy,
		OrderByComparator obc)
		throws NoSuchLmisViewOvertimeReportException, SystemException {
		int count = countByReportedBy(reportedBy);

		List<LmisViewOvertimeReport> list = findByReportedBy(reportedBy,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewOvertimeReport exists with the key {");

			msg.append("reportedBy=" + reportedBy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewOvertimeReportException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewOvertimeReport[] findByReportedBy_PrevAndNext(
		Integer lmisViewOvertimeReportId, int reportedBy, OrderByComparator obc)
		throws NoSuchLmisViewOvertimeReportException, SystemException {
		LmisViewOvertimeReport lmisViewOvertimeReport = findByPrimaryKey(lmisViewOvertimeReportId);

		int count = countByReportedBy(reportedBy);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewOvertimeReport WHERE ");

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
					lmisViewOvertimeReport);

			LmisViewOvertimeReport[] array = new LmisViewOvertimeReportImpl[3];

			array[0] = (LmisViewOvertimeReport)objArray[0];
			array[1] = (LmisViewOvertimeReport)objArray[1];
			array[2] = (LmisViewOvertimeReport)objArray[2];

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

	public List<LmisViewOvertimeReport> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<LmisViewOvertimeReport> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<LmisViewOvertimeReport> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewOvertimeReport> list = (List<LmisViewOvertimeReport>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewOvertimeReport ");

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
					list = (List<LmisViewOvertimeReport>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LmisViewOvertimeReport>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewOvertimeReport>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByRootID(int rootId) throws SystemException {
		for (LmisViewOvertimeReport lmisViewOvertimeReport : findByRootID(
				rootId)) {
			remove(lmisViewOvertimeReport);
		}
	}

	public void removeByOrgID(int orgId) throws SystemException {
		for (LmisViewOvertimeReport lmisViewOvertimeReport : findByOrgID(orgId)) {
			remove(lmisViewOvertimeReport);
		}
	}

	public void removeByReportedAt(Date reportedAt) throws SystemException {
		for (LmisViewOvertimeReport lmisViewOvertimeReport : findByReportedAt(
				reportedAt)) {
			remove(lmisViewOvertimeReport);
		}
	}

	public void removeByreportedStatus(int reportedStatus)
		throws SystemException {
		for (LmisViewOvertimeReport lmisViewOvertimeReport : findByreportedStatus(
				reportedStatus)) {
			remove(lmisViewOvertimeReport);
		}
	}

	public void removeByReportedBy(int reportedBy) throws SystemException {
		for (LmisViewOvertimeReport lmisViewOvertimeReport : findByReportedBy(
				reportedBy)) {
			remove(lmisViewOvertimeReport);
		}
	}

	public void removeAll() throws SystemException {
		for (LmisViewOvertimeReport lmisViewOvertimeReport : findAll()) {
			remove(lmisViewOvertimeReport);
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
					"FROM larion.progate.lmis.model.LmisViewOvertimeReport WHERE ");

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
					"FROM larion.progate.lmis.model.LmisViewOvertimeReport WHERE ");

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
					"FROM larion.progate.lmis.model.LmisViewOvertimeReport WHERE ");

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
					"FROM larion.progate.lmis.model.LmisViewOvertimeReport WHERE ");

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
					"FROM larion.progate.lmis.model.LmisViewOvertimeReport WHERE ");

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

	public int countAll() throws SystemException {
		Object[] finderArgs = new Object[0];

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(
						"SELECT COUNT(*) FROM larion.progate.lmis.model.LmisViewOvertimeReport");

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
						"value.object.listener.larion.progate.lmis.model.LmisViewOvertimeReport")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LmisViewOvertimeReport>> listenersList = new ArrayList<ModelListener<LmisViewOvertimeReport>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LmisViewOvertimeReport>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(LmisViewOvertimeReportPersistenceImpl.class);
}