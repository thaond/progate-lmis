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

import larion.progate.lmis.NoSuchLmisOverTimeReportsException;
import larion.progate.lmis.model.LmisOverTimeReports;
import larion.progate.lmis.model.impl.LmisOverTimeReportsImpl;
import larion.progate.lmis.model.impl.LmisOverTimeReportsModelImpl;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="LmisOverTimeReportsPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisOverTimeReportsPersistenceImpl extends BasePersistenceImpl
	implements LmisOverTimeReportsPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = LmisOverTimeReportsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_OVERTIMEREPORTOF = new FinderPath(LmisOverTimeReportsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeReportsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOverTimeReportOf",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_OVERTIMEREPORTOF = new FinderPath(LmisOverTimeReportsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeReportsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOverTimeReportOf",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_OVERTIMEREPORTOF = new FinderPath(LmisOverTimeReportsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeReportsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByOverTimeReportOf",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_REQUESTID = new FinderPath(LmisOverTimeReportsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeReportsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByrequestID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_REQUESTID = new FinderPath(LmisOverTimeReportsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeReportsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByrequestID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_REQUESTID = new FinderPath(LmisOverTimeReportsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeReportsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByrequestID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ORGID = new FinderPath(LmisOverTimeReportsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeReportsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByorgID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ORGID = new FinderPath(LmisOverTimeReportsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeReportsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByorgID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGID = new FinderPath(LmisOverTimeReportsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeReportsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByorgID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(LmisOverTimeReportsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeReportsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LmisOverTimeReportsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeReportsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(LmisOverTimeReports lmisOverTimeReports) {
		EntityCacheUtil.putResult(LmisOverTimeReportsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeReportsImpl.class, lmisOverTimeReports.getPrimaryKey(),
			lmisOverTimeReports);
	}

	public void cacheResult(List<LmisOverTimeReports> lmisOverTimeReportses) {
		for (LmisOverTimeReports lmisOverTimeReports : lmisOverTimeReportses) {
			if (EntityCacheUtil.getResult(
						LmisOverTimeReportsModelImpl.ENTITY_CACHE_ENABLED,
						LmisOverTimeReportsImpl.class,
						lmisOverTimeReports.getPrimaryKey(), this) == null) {
				cacheResult(lmisOverTimeReports);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(LmisOverTimeReportsImpl.class.getName());
		EntityCacheUtil.clearCache(LmisOverTimeReportsImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public LmisOverTimeReports create(Integer lmisOverTimeReportsId) {
		LmisOverTimeReports lmisOverTimeReports = new LmisOverTimeReportsImpl();

		lmisOverTimeReports.setNew(true);
		lmisOverTimeReports.setPrimaryKey(lmisOverTimeReportsId);

		return lmisOverTimeReports;
	}

	public LmisOverTimeReports remove(Integer lmisOverTimeReportsId)
		throws NoSuchLmisOverTimeReportsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LmisOverTimeReports lmisOverTimeReports = (LmisOverTimeReports)session.get(LmisOverTimeReportsImpl.class,
					lmisOverTimeReportsId);

			if (lmisOverTimeReports == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No LmisOverTimeReports exists with the primary key " +
						lmisOverTimeReportsId);
				}

				throw new NoSuchLmisOverTimeReportsException(
					"No LmisOverTimeReports exists with the primary key " +
					lmisOverTimeReportsId);
			}

			return remove(lmisOverTimeReports);
		}
		catch (NoSuchLmisOverTimeReportsException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public LmisOverTimeReports remove(LmisOverTimeReports lmisOverTimeReports)
		throws SystemException {
		for (ModelListener<LmisOverTimeReports> listener : listeners) {
			listener.onBeforeRemove(lmisOverTimeReports);
		}

		lmisOverTimeReports = removeImpl(lmisOverTimeReports);

		for (ModelListener<LmisOverTimeReports> listener : listeners) {
			listener.onAfterRemove(lmisOverTimeReports);
		}

		return lmisOverTimeReports;
	}

	protected LmisOverTimeReports removeImpl(
		LmisOverTimeReports lmisOverTimeReports) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (lmisOverTimeReports.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(LmisOverTimeReportsImpl.class,
						lmisOverTimeReports.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(lmisOverTimeReports);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(LmisOverTimeReportsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeReportsImpl.class, lmisOverTimeReports.getPrimaryKey());

		return lmisOverTimeReports;
	}

	public LmisOverTimeReports update(LmisOverTimeReports lmisOverTimeReports)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(LmisOverTimeReports lmisOverTimeReports) method. Use update(LmisOverTimeReports lmisOverTimeReports, boolean merge) instead.");
		}

		return update(lmisOverTimeReports, false);
	}

	public LmisOverTimeReports update(LmisOverTimeReports lmisOverTimeReports,
		boolean merge) throws SystemException {
		boolean isNew = lmisOverTimeReports.isNew();

		for (ModelListener<LmisOverTimeReports> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(lmisOverTimeReports);
			}
			else {
				listener.onBeforeUpdate(lmisOverTimeReports);
			}
		}

		lmisOverTimeReports = updateImpl(lmisOverTimeReports, merge);

		for (ModelListener<LmisOverTimeReports> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(lmisOverTimeReports);
			}
			else {
				listener.onAfterUpdate(lmisOverTimeReports);
			}
		}

		return lmisOverTimeReports;
	}

	public LmisOverTimeReports updateImpl(
		larion.progate.lmis.model.LmisOverTimeReports lmisOverTimeReports,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, lmisOverTimeReports, merge);

			lmisOverTimeReports.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(LmisOverTimeReportsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeReportsImpl.class, lmisOverTimeReports.getPrimaryKey(),
			lmisOverTimeReports);

		return lmisOverTimeReports;
	}

	public LmisOverTimeReports findByPrimaryKey(Integer lmisOverTimeReportsId)
		throws NoSuchLmisOverTimeReportsException, SystemException {
		LmisOverTimeReports lmisOverTimeReports = fetchByPrimaryKey(lmisOverTimeReportsId);

		if (lmisOverTimeReports == null) {
			if (_log.isWarnEnabled()) {
				_log.warn("No LmisOverTimeReports exists with the primary key " +
					lmisOverTimeReportsId);
			}

			throw new NoSuchLmisOverTimeReportsException(
				"No LmisOverTimeReports exists with the primary key " +
				lmisOverTimeReportsId);
		}

		return lmisOverTimeReports;
	}

	public LmisOverTimeReports fetchByPrimaryKey(Integer lmisOverTimeReportsId)
		throws SystemException {
		LmisOverTimeReports lmisOverTimeReports = (LmisOverTimeReports)EntityCacheUtil.getResult(LmisOverTimeReportsModelImpl.ENTITY_CACHE_ENABLED,
				LmisOverTimeReportsImpl.class, lmisOverTimeReportsId, this);

		if (lmisOverTimeReports == null) {
			Session session = null;

			try {
				session = openSession();

				lmisOverTimeReports = (LmisOverTimeReports)session.get(LmisOverTimeReportsImpl.class,
						lmisOverTimeReportsId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (lmisOverTimeReports != null) {
					cacheResult(lmisOverTimeReports);
				}

				closeSession(session);
			}
		}

		return lmisOverTimeReports;
	}

	public List<LmisOverTimeReports> findByOverTimeReportOf(int rootId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		List<LmisOverTimeReports> list = (List<LmisOverTimeReports>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OVERTIMEREPORTOF,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOverTimeReports WHERE ");

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
					list = new ArrayList<LmisOverTimeReports>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OVERTIMEREPORTOF,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisOverTimeReports> findByOverTimeReportOf(int rootId,
		int start, int end) throws SystemException {
		return findByOverTimeReportOf(rootId, start, end, null);
	}

	public List<LmisOverTimeReports> findByOverTimeReportOf(int rootId,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(rootId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisOverTimeReports> list = (List<LmisOverTimeReports>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_OVERTIMEREPORTOF,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOverTimeReports WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rootId);

				list = (List<LmisOverTimeReports>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisOverTimeReports>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_OVERTIMEREPORTOF,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisOverTimeReports findByOverTimeReportOf_First(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisOverTimeReportsException, SystemException {
		List<LmisOverTimeReports> list = findByOverTimeReportOf(rootId, 0, 1,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOverTimeReports exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOverTimeReportsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOverTimeReports findByOverTimeReportOf_Last(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisOverTimeReportsException, SystemException {
		int count = countByOverTimeReportOf(rootId);

		List<LmisOverTimeReports> list = findByOverTimeReportOf(rootId,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOverTimeReports exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOverTimeReportsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOverTimeReports[] findByOverTimeReportOf_PrevAndNext(
		Integer lmisOverTimeReportsId, int rootId, OrderByComparator obc)
		throws NoSuchLmisOverTimeReportsException, SystemException {
		LmisOverTimeReports lmisOverTimeReports = findByPrimaryKey(lmisOverTimeReportsId);

		int count = countByOverTimeReportOf(rootId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisOverTimeReports WHERE ");

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
					lmisOverTimeReports);

			LmisOverTimeReports[] array = new LmisOverTimeReportsImpl[3];

			array[0] = (LmisOverTimeReports)objArray[0];
			array[1] = (LmisOverTimeReports)objArray[1];
			array[2] = (LmisOverTimeReports)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisOverTimeReports> findByrequestID(int requestId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(requestId) };

		List<LmisOverTimeReports> list = (List<LmisOverTimeReports>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_REQUESTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOverTimeReports WHERE ");

				query.append("request_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(requestId);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisOverTimeReports>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_REQUESTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisOverTimeReports> findByrequestID(int requestId, int start,
		int end) throws SystemException {
		return findByrequestID(requestId, start, end, null);
	}

	public List<LmisOverTimeReports> findByrequestID(int requestId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(requestId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisOverTimeReports> list = (List<LmisOverTimeReports>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_REQUESTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOverTimeReports WHERE ");

				query.append("request_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(requestId);

				list = (List<LmisOverTimeReports>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisOverTimeReports>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_REQUESTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisOverTimeReports findByrequestID_First(int requestId,
		OrderByComparator obc)
		throws NoSuchLmisOverTimeReportsException, SystemException {
		List<LmisOverTimeReports> list = findByrequestID(requestId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOverTimeReports exists with the key {");

			msg.append("requestId=" + requestId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOverTimeReportsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOverTimeReports findByrequestID_Last(int requestId,
		OrderByComparator obc)
		throws NoSuchLmisOverTimeReportsException, SystemException {
		int count = countByrequestID(requestId);

		List<LmisOverTimeReports> list = findByrequestID(requestId, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOverTimeReports exists with the key {");

			msg.append("requestId=" + requestId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOverTimeReportsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOverTimeReports[] findByrequestID_PrevAndNext(
		Integer lmisOverTimeReportsId, int requestId, OrderByComparator obc)
		throws NoSuchLmisOverTimeReportsException, SystemException {
		LmisOverTimeReports lmisOverTimeReports = findByPrimaryKey(lmisOverTimeReportsId);

		int count = countByrequestID(requestId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisOverTimeReports WHERE ");

			query.append("request_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(requestId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisOverTimeReports);

			LmisOverTimeReports[] array = new LmisOverTimeReportsImpl[3];

			array[0] = (LmisOverTimeReports)objArray[0];
			array[1] = (LmisOverTimeReports)objArray[1];
			array[2] = (LmisOverTimeReports)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisOverTimeReports> findByorgID(int orgId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(orgId) };

		List<LmisOverTimeReports> list = (List<LmisOverTimeReports>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ORGID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOverTimeReports WHERE ");

				query.append("org_id = ?");

				query.append(" ");

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
					list = new ArrayList<LmisOverTimeReports>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ORGID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisOverTimeReports> findByorgID(int orgId, int start, int end)
		throws SystemException {
		return findByorgID(orgId, start, end, null);
	}

	public List<LmisOverTimeReports> findByorgID(int orgId, int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(orgId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisOverTimeReports> list = (List<LmisOverTimeReports>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ORGID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOverTimeReports WHERE ");

				query.append("org_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orgId);

				list = (List<LmisOverTimeReports>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisOverTimeReports>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ORGID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisOverTimeReports findByorgID_First(int orgId,
		OrderByComparator obc)
		throws NoSuchLmisOverTimeReportsException, SystemException {
		List<LmisOverTimeReports> list = findByorgID(orgId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOverTimeReports exists with the key {");

			msg.append("orgId=" + orgId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOverTimeReportsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOverTimeReports findByorgID_Last(int orgId, OrderByComparator obc)
		throws NoSuchLmisOverTimeReportsException, SystemException {
		int count = countByorgID(orgId);

		List<LmisOverTimeReports> list = findByorgID(orgId, count - 1, count,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOverTimeReports exists with the key {");

			msg.append("orgId=" + orgId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOverTimeReportsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOverTimeReports[] findByorgID_PrevAndNext(
		Integer lmisOverTimeReportsId, int orgId, OrderByComparator obc)
		throws NoSuchLmisOverTimeReportsException, SystemException {
		LmisOverTimeReports lmisOverTimeReports = findByPrimaryKey(lmisOverTimeReportsId);

		int count = countByorgID(orgId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisOverTimeReports WHERE ");

			query.append("org_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(orgId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisOverTimeReports);

			LmisOverTimeReports[] array = new LmisOverTimeReportsImpl[3];

			array[0] = (LmisOverTimeReports)objArray[0];
			array[1] = (LmisOverTimeReports)objArray[1];
			array[2] = (LmisOverTimeReports)objArray[2];

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

	public List<LmisOverTimeReports> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<LmisOverTimeReports> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<LmisOverTimeReports> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisOverTimeReports> list = (List<LmisOverTimeReports>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOverTimeReports ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<LmisOverTimeReports>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LmisOverTimeReports>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisOverTimeReports>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByOverTimeReportOf(int rootId) throws SystemException {
		for (LmisOverTimeReports lmisOverTimeReports : findByOverTimeReportOf(
				rootId)) {
			remove(lmisOverTimeReports);
		}
	}

	public void removeByrequestID(int requestId) throws SystemException {
		for (LmisOverTimeReports lmisOverTimeReports : findByrequestID(
				requestId)) {
			remove(lmisOverTimeReports);
		}
	}

	public void removeByorgID(int orgId) throws SystemException {
		for (LmisOverTimeReports lmisOverTimeReports : findByorgID(orgId)) {
			remove(lmisOverTimeReports);
		}
	}

	public void removeAll() throws SystemException {
		for (LmisOverTimeReports lmisOverTimeReports : findAll()) {
			remove(lmisOverTimeReports);
		}
	}

	public int countByOverTimeReportOf(int rootId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_OVERTIMEREPORTOF,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisOverTimeReports WHERE ");

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_OVERTIMEREPORTOF,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByrequestID(int requestId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(requestId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_REQUESTID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisOverTimeReports WHERE ");

				query.append("request_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(requestId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_REQUESTID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByorgID(int orgId) throws SystemException {
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
					"FROM larion.progate.lmis.model.LmisOverTimeReports WHERE ");

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

	public int countAll() throws SystemException {
		Object[] finderArgs = new Object[0];

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(
						"SELECT COUNT(*) FROM larion.progate.lmis.model.LmisOverTimeReports");

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

	public List<larion.progate.lmis.model.LmisOverTimeReportDetails> getLmisOverTimeReportDetailses(
		Integer pk) throws SystemException {
		return getLmisOverTimeReportDetailses(pk, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS);
	}

	public List<larion.progate.lmis.model.LmisOverTimeReportDetails> getLmisOverTimeReportDetailses(
		Integer pk, int start, int end) throws SystemException {
		return getLmisOverTimeReportDetailses(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_LMISOVERTIMEREPORTDETAILSES = new FinderPath(larion.progate.lmis.model.impl.LmisOverTimeReportDetailsModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.lmis.model.impl.LmisOverTimeReportDetailsModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.lmis.service.persistence.LmisOverTimeReportDetailsPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getLmisOverTimeReportDetailses",
			new String[] {
				Integer.class.getName(), "java.lang.Integer",
				"java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	public List<larion.progate.lmis.model.LmisOverTimeReportDetails> getLmisOverTimeReportDetailses(
		Integer pk, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				pk, String.valueOf(start), String.valueOf(end),
				String.valueOf(obc)
			};

		List<larion.progate.lmis.model.LmisOverTimeReportDetails> list = (List<larion.progate.lmis.model.LmisOverTimeReportDetails>)FinderCacheUtil.getResult(FINDER_PATH_GET_LMISOVERTIMEREPORTDETAILSES,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder sb = new StringBuilder();

				sb.append(_SQL_GETLMISOVERTIMEREPORTDETAILSES);

				if (obc != null) {
					sb.append("ORDER BY ");
					sb.append(obc.getOrderBy());
				}

				String sql = sb.toString();

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("lmis_overtime_report_details",
					larion.progate.lmis.model.impl.LmisOverTimeReportDetailsImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<larion.progate.lmis.model.LmisOverTimeReportDetails>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<larion.progate.lmis.model.LmisOverTimeReportDetails>();
				}

				lmisOverTimeReportDetailsPersistence.cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_GET_LMISOVERTIMEREPORTDETAILSES,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_LMISOVERTIMEREPORTDETAILSES_SIZE =
		new FinderPath(larion.progate.lmis.model.impl.LmisOverTimeReportDetailsModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.lmis.model.impl.LmisOverTimeReportDetailsModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.lmis.service.persistence.LmisOverTimeReportDetailsPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getLmisOverTimeReportDetailsesSize",
			new String[] { Integer.class.getName() });

	public int getLmisOverTimeReportDetailsesSize(Integer pk)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_LMISOVERTIMEREPORTDETAILSES_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETLMISOVERTIMEREPORTDETAILSESSIZE);

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

				FinderCacheUtil.putResult(FINDER_PATH_GET_LMISOVERTIMEREPORTDETAILSES_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_LMISOVERTIMEREPORTDETAILS =
		new FinderPath(larion.progate.lmis.model.impl.LmisOverTimeReportDetailsModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.lmis.model.impl.LmisOverTimeReportDetailsModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.lmis.service.persistence.LmisOverTimeReportDetailsPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"containsLmisOverTimeReportDetails",
			new String[] { Integer.class.getName(), Integer.class.getName() });

	public boolean containsLmisOverTimeReportDetails(Integer pk,
		Integer lmisOverTimeReportDetailsPK) throws SystemException {
		Object[] finderArgs = new Object[] { pk, lmisOverTimeReportDetailsPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_LMISOVERTIMEREPORTDETAILS,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsLmisOverTimeReportDetails.contains(
							pk, lmisOverTimeReportDetailsPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_LMISOVERTIMEREPORTDETAILS,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	public boolean containsLmisOverTimeReportDetailses(Integer pk)
		throws SystemException {
		if (getLmisOverTimeReportDetailsesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public List<larion.progate.lmis.model.LmisOvertimeApprovals> getLmisOvertimeApprovalses(
		Integer pk) throws SystemException {
		return getLmisOvertimeApprovalses(pk, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS);
	}

	public List<larion.progate.lmis.model.LmisOvertimeApprovals> getLmisOvertimeApprovalses(
		Integer pk, int start, int end) throws SystemException {
		return getLmisOvertimeApprovalses(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_LMISOVERTIMEAPPROVALSES = new FinderPath(larion.progate.lmis.model.impl.LmisOvertimeApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.lmis.model.impl.LmisOvertimeApprovalsModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.lmis.service.persistence.LmisOvertimeApprovalsPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getLmisOvertimeApprovalses",
			new String[] {
				Integer.class.getName(), "java.lang.Integer",
				"java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	public List<larion.progate.lmis.model.LmisOvertimeApprovals> getLmisOvertimeApprovalses(
		Integer pk, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				pk, String.valueOf(start), String.valueOf(end),
				String.valueOf(obc)
			};

		List<larion.progate.lmis.model.LmisOvertimeApprovals> list = (List<larion.progate.lmis.model.LmisOvertimeApprovals>)FinderCacheUtil.getResult(FINDER_PATH_GET_LMISOVERTIMEAPPROVALSES,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder sb = new StringBuilder();

				sb.append(_SQL_GETLMISOVERTIMEAPPROVALSES);

				if (obc != null) {
					sb.append("ORDER BY ");
					sb.append(obc.getOrderBy());
				}

				else {
					sb.append("ORDER BY ");

					sb.append("lmis_overtime_approvals.approved_status ASC");
				}

				String sql = sb.toString();

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("lmis_overtime_approvals",
					larion.progate.lmis.model.impl.LmisOvertimeApprovalsImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<larion.progate.lmis.model.LmisOvertimeApprovals>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<larion.progate.lmis.model.LmisOvertimeApprovals>();
				}

				lmisOvertimeApprovalsPersistence.cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_GET_LMISOVERTIMEAPPROVALSES,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_LMISOVERTIMEAPPROVALSES_SIZE = new FinderPath(larion.progate.lmis.model.impl.LmisOvertimeApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.lmis.model.impl.LmisOvertimeApprovalsModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.lmis.service.persistence.LmisOvertimeApprovalsPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getLmisOvertimeApprovalsesSize",
			new String[] { Integer.class.getName() });

	public int getLmisOvertimeApprovalsesSize(Integer pk)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_LMISOVERTIMEAPPROVALSES_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETLMISOVERTIMEAPPROVALSESSIZE);

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

				FinderCacheUtil.putResult(FINDER_PATH_GET_LMISOVERTIMEAPPROVALSES_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_LMISOVERTIMEAPPROVALS = new FinderPath(larion.progate.lmis.model.impl.LmisOvertimeApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.lmis.model.impl.LmisOvertimeApprovalsModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.lmis.service.persistence.LmisOvertimeApprovalsPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"containsLmisOvertimeApprovals",
			new String[] { Integer.class.getName(), Integer.class.getName() });

	public boolean containsLmisOvertimeApprovals(Integer pk,
		Integer lmisOvertimeApprovalsPK) throws SystemException {
		Object[] finderArgs = new Object[] { pk, lmisOvertimeApprovalsPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_LMISOVERTIMEAPPROVALS,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsLmisOvertimeApprovals.contains(
							pk, lmisOvertimeApprovalsPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_LMISOVERTIMEAPPROVALS,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	public boolean containsLmisOvertimeApprovalses(Integer pk)
		throws SystemException {
		if (getLmisOvertimeApprovalsesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.larion.progate.lmis.model.LmisOverTimeReports")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LmisOverTimeReports>> listenersList = new ArrayList<ModelListener<LmisOverTimeReports>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LmisOverTimeReports>)Class.forName(
							listenerClassName).newInstance());
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		containsLmisOverTimeReportDetails = new ContainsLmisOverTimeReportDetails(this);

		containsLmisOvertimeApprovals = new ContainsLmisOvertimeApprovals(this);
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
	protected ContainsLmisOverTimeReportDetails containsLmisOverTimeReportDetails;
	protected ContainsLmisOvertimeApprovals containsLmisOvertimeApprovals;

	protected class ContainsLmisOverTimeReportDetails {
		protected ContainsLmisOverTimeReportDetails(
			LmisOverTimeReportsPersistenceImpl persistenceImpl) {
			super();

			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSLMISOVERTIMEREPORTDETAILS,
					new int[] { Types.INTEGER, Types.INTEGER }, RowMapper.COUNT);
		}

		protected boolean contains(Integer lmisOverTimeReportsId,
			Integer lmisOverTimeReportDetailsId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						lmisOverTimeReportsId, lmisOverTimeReportDetailsId
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

	protected class ContainsLmisOvertimeApprovals {
		protected ContainsLmisOvertimeApprovals(
			LmisOverTimeReportsPersistenceImpl persistenceImpl) {
			super();

			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSLMISOVERTIMEAPPROVALS,
					new int[] { Types.INTEGER, Types.INTEGER }, RowMapper.COUNT);
		}

		protected boolean contains(Integer lmisOverTimeReportsId,
			Integer lmisOvertimeApprovalsId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						lmisOverTimeReportsId, lmisOvertimeApprovalsId
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

	private static final String _SQL_GETLMISOVERTIMEREPORTDETAILSES = "SELECT {lmis_overtime_report_details.*} FROM lmis_overtime_report_details INNER JOIN lmis_overtime_reports ON (lmis_overtime_reports.lmisOverTimeReportsId = lmis_overtime_report_details.lmisOverTimeReportsId) WHERE (lmis_overtime_reports.lmisOverTimeReportsId = ?)";
	private static final String _SQL_GETLMISOVERTIMEREPORTDETAILSESSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM lmis_overtime_report_details WHERE lmisOverTimeReportsId = ?";
	private static final String _SQL_CONTAINSLMISOVERTIMEREPORTDETAILS = "SELECT COUNT(*) AS COUNT_VALUE FROM lmis_overtime_report_details WHERE lmisOverTimeReportsId = ? AND lmisOverTimeReportDetailsId = ?";
	private static final String _SQL_GETLMISOVERTIMEAPPROVALSES = "SELECT {lmis_overtime_approvals.*} FROM lmis_overtime_approvals INNER JOIN lmis_overtime_reports ON (lmis_overtime_reports.lmisOverTimeReportsId = lmis_overtime_approvals.lmisOverTimeReportsId) WHERE (lmis_overtime_reports.lmisOverTimeReportsId = ?)";
	private static final String _SQL_GETLMISOVERTIMEAPPROVALSESSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM lmis_overtime_approvals WHERE lmisOverTimeReportsId = ?";
	private static final String _SQL_CONTAINSLMISOVERTIMEAPPROVALS = "SELECT COUNT(*) AS COUNT_VALUE FROM lmis_overtime_approvals WHERE lmisOverTimeReportsId = ? AND lmisOvertimeApprovalsId = ?";
	private static Log _log = LogFactoryUtil.getLog(LmisOverTimeReportsPersistenceImpl.class);
}