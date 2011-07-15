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
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import larion.progate.lmis.NoSuchLmisOvertimeApprovalsException;
import larion.progate.lmis.model.LmisOvertimeApprovals;
import larion.progate.lmis.model.impl.LmisOvertimeApprovalsImpl;
import larion.progate.lmis.model.impl.LmisOvertimeApprovalsModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="LmisOvertimeApprovalsPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisOvertimeApprovalsPersistenceImpl extends BasePersistenceImpl
	implements LmisOvertimeApprovalsPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = LmisOvertimeApprovalsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_OVERTIMEAPPROVALSOF = new FinderPath(LmisOvertimeApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeApprovalsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOvertimeApprovalsOf",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_OVERTIMEAPPROVALSOF = new FinderPath(LmisOvertimeApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeApprovalsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOvertimeApprovalsOf",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_OVERTIMEAPPROVALSOF = new FinderPath(LmisOvertimeApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeApprovalsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByOvertimeApprovalsOf",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_REQUESTID = new FinderPath(LmisOvertimeApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeApprovalsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRequestID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_REQUESTID = new FinderPath(LmisOvertimeApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeApprovalsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRequestID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_REQUESTID = new FinderPath(LmisOvertimeApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeApprovalsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByRequestID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_REPORTIDGREATER = new FinderPath(LmisOvertimeApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeApprovalsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByReportIDGreater",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_REPORTIDGREATER = new FinderPath(LmisOvertimeApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeApprovalsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByReportIDGreater",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_REPORTIDGREATER = new FinderPath(LmisOvertimeApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeApprovalsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByReportIDGreater",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_APPROVEDBY = new FinderPath(LmisOvertimeApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeApprovalsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByApprovedBy",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_APPROVEDBY = new FinderPath(LmisOvertimeApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeApprovalsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByApprovedBy",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_APPROVEDBY = new FinderPath(LmisOvertimeApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeApprovalsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByApprovedBy",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_REPORTID = new FinderPath(LmisOvertimeApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeApprovalsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByReportID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_REPORTID = new FinderPath(LmisOvertimeApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeApprovalsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByReportID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_REPORTID = new FinderPath(LmisOvertimeApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeApprovalsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByReportID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(LmisOvertimeApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeApprovalsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LmisOvertimeApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeApprovalsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(LmisOvertimeApprovals lmisOvertimeApprovals) {
		EntityCacheUtil.putResult(LmisOvertimeApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeApprovalsImpl.class,
			lmisOvertimeApprovals.getPrimaryKey(), lmisOvertimeApprovals);
	}

	public void cacheResult(List<LmisOvertimeApprovals> lmisOvertimeApprovalses) {
		for (LmisOvertimeApprovals lmisOvertimeApprovals : lmisOvertimeApprovalses) {
			if (EntityCacheUtil.getResult(
						LmisOvertimeApprovalsModelImpl.ENTITY_CACHE_ENABLED,
						LmisOvertimeApprovalsImpl.class,
						lmisOvertimeApprovals.getPrimaryKey(), this) == null) {
				cacheResult(lmisOvertimeApprovals);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(LmisOvertimeApprovalsImpl.class.getName());
		EntityCacheUtil.clearCache(LmisOvertimeApprovalsImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public LmisOvertimeApprovals create(Integer lmisOvertimeApprovalsId) {
		LmisOvertimeApprovals lmisOvertimeApprovals = new LmisOvertimeApprovalsImpl();

		lmisOvertimeApprovals.setNew(true);
		lmisOvertimeApprovals.setPrimaryKey(lmisOvertimeApprovalsId);

		return lmisOvertimeApprovals;
	}

	public LmisOvertimeApprovals remove(Integer lmisOvertimeApprovalsId)
		throws NoSuchLmisOvertimeApprovalsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LmisOvertimeApprovals lmisOvertimeApprovals = (LmisOvertimeApprovals)session.get(LmisOvertimeApprovalsImpl.class,
					lmisOvertimeApprovalsId);

			if (lmisOvertimeApprovals == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No LmisOvertimeApprovals exists with the primary key " +
						lmisOvertimeApprovalsId);
				}

				throw new NoSuchLmisOvertimeApprovalsException(
					"No LmisOvertimeApprovals exists with the primary key " +
					lmisOvertimeApprovalsId);
			}

			return remove(lmisOvertimeApprovals);
		}
		catch (NoSuchLmisOvertimeApprovalsException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public LmisOvertimeApprovals remove(
		LmisOvertimeApprovals lmisOvertimeApprovals) throws SystemException {
		for (ModelListener<LmisOvertimeApprovals> listener : listeners) {
			listener.onBeforeRemove(lmisOvertimeApprovals);
		}

		lmisOvertimeApprovals = removeImpl(lmisOvertimeApprovals);

		for (ModelListener<LmisOvertimeApprovals> listener : listeners) {
			listener.onAfterRemove(lmisOvertimeApprovals);
		}

		return lmisOvertimeApprovals;
	}

	protected LmisOvertimeApprovals removeImpl(
		LmisOvertimeApprovals lmisOvertimeApprovals) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (lmisOvertimeApprovals.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(LmisOvertimeApprovalsImpl.class,
						lmisOvertimeApprovals.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(lmisOvertimeApprovals);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(LmisOvertimeApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeApprovalsImpl.class,
			lmisOvertimeApprovals.getPrimaryKey());

		return lmisOvertimeApprovals;
	}

	public LmisOvertimeApprovals update(
		LmisOvertimeApprovals lmisOvertimeApprovals) throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(LmisOvertimeApprovals lmisOvertimeApprovals) method. Use update(LmisOvertimeApprovals lmisOvertimeApprovals, boolean merge) instead.");
		}

		return update(lmisOvertimeApprovals, false);
	}

	public LmisOvertimeApprovals update(
		LmisOvertimeApprovals lmisOvertimeApprovals, boolean merge)
		throws SystemException {
		boolean isNew = lmisOvertimeApprovals.isNew();

		for (ModelListener<LmisOvertimeApprovals> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(lmisOvertimeApprovals);
			}
			else {
				listener.onBeforeUpdate(lmisOvertimeApprovals);
			}
		}

		lmisOvertimeApprovals = updateImpl(lmisOvertimeApprovals, merge);

		for (ModelListener<LmisOvertimeApprovals> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(lmisOvertimeApprovals);
			}
			else {
				listener.onAfterUpdate(lmisOvertimeApprovals);
			}
		}

		return lmisOvertimeApprovals;
	}

	public LmisOvertimeApprovals updateImpl(
		larion.progate.lmis.model.LmisOvertimeApprovals lmisOvertimeApprovals,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, lmisOvertimeApprovals, merge);

			lmisOvertimeApprovals.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(LmisOvertimeApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeApprovalsImpl.class,
			lmisOvertimeApprovals.getPrimaryKey(), lmisOvertimeApprovals);

		return lmisOvertimeApprovals;
	}

	public LmisOvertimeApprovals findByPrimaryKey(
		Integer lmisOvertimeApprovalsId)
		throws NoSuchLmisOvertimeApprovalsException, SystemException {
		LmisOvertimeApprovals lmisOvertimeApprovals = fetchByPrimaryKey(lmisOvertimeApprovalsId);

		if (lmisOvertimeApprovals == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"No LmisOvertimeApprovals exists with the primary key " +
					lmisOvertimeApprovalsId);
			}

			throw new NoSuchLmisOvertimeApprovalsException(
				"No LmisOvertimeApprovals exists with the primary key " +
				lmisOvertimeApprovalsId);
		}

		return lmisOvertimeApprovals;
	}

	public LmisOvertimeApprovals fetchByPrimaryKey(
		Integer lmisOvertimeApprovalsId) throws SystemException {
		LmisOvertimeApprovals lmisOvertimeApprovals = (LmisOvertimeApprovals)EntityCacheUtil.getResult(LmisOvertimeApprovalsModelImpl.ENTITY_CACHE_ENABLED,
				LmisOvertimeApprovalsImpl.class, lmisOvertimeApprovalsId, this);

		if (lmisOvertimeApprovals == null) {
			Session session = null;

			try {
				session = openSession();

				lmisOvertimeApprovals = (LmisOvertimeApprovals)session.get(LmisOvertimeApprovalsImpl.class,
						lmisOvertimeApprovalsId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (lmisOvertimeApprovals != null) {
					cacheResult(lmisOvertimeApprovals);
				}

				closeSession(session);
			}
		}

		return lmisOvertimeApprovals;
	}

	public List<LmisOvertimeApprovals> findByOvertimeApprovalsOf(int rootId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		List<LmisOvertimeApprovals> list = (List<LmisOvertimeApprovals>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OVERTIMEAPPROVALSOF,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOvertimeApprovals WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("approved_status ASC");

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
					list = new ArrayList<LmisOvertimeApprovals>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OVERTIMEAPPROVALSOF,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisOvertimeApprovals> findByOvertimeApprovalsOf(int rootId,
		int start, int end) throws SystemException {
		return findByOvertimeApprovalsOf(rootId, start, end, null);
	}

	public List<LmisOvertimeApprovals> findByOvertimeApprovalsOf(int rootId,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(rootId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisOvertimeApprovals> list = (List<LmisOvertimeApprovals>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_OVERTIMEAPPROVALSOF,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOvertimeApprovals WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("approved_status ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rootId);

				list = (List<LmisOvertimeApprovals>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisOvertimeApprovals>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_OVERTIMEAPPROVALSOF,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisOvertimeApprovals findByOvertimeApprovalsOf_First(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisOvertimeApprovalsException, SystemException {
		List<LmisOvertimeApprovals> list = findByOvertimeApprovalsOf(rootId, 0,
				1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOvertimeApprovals exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOvertimeApprovalsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOvertimeApprovals findByOvertimeApprovalsOf_Last(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisOvertimeApprovalsException, SystemException {
		int count = countByOvertimeApprovalsOf(rootId);

		List<LmisOvertimeApprovals> list = findByOvertimeApprovalsOf(rootId,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOvertimeApprovals exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOvertimeApprovalsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOvertimeApprovals[] findByOvertimeApprovalsOf_PrevAndNext(
		Integer lmisOvertimeApprovalsId, int rootId, OrderByComparator obc)
		throws NoSuchLmisOvertimeApprovalsException, SystemException {
		LmisOvertimeApprovals lmisOvertimeApprovals = findByPrimaryKey(lmisOvertimeApprovalsId);

		int count = countByOvertimeApprovalsOf(rootId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisOvertimeApprovals WHERE ");

			query.append("root_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("approved_status ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(rootId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisOvertimeApprovals);

			LmisOvertimeApprovals[] array = new LmisOvertimeApprovalsImpl[3];

			array[0] = (LmisOvertimeApprovals)objArray[0];
			array[1] = (LmisOvertimeApprovals)objArray[1];
			array[2] = (LmisOvertimeApprovals)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisOvertimeApprovals> findByRequestID(int requestId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(requestId) };

		List<LmisOvertimeApprovals> list = (List<LmisOvertimeApprovals>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_REQUESTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOvertimeApprovals WHERE ");

				query.append("request_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("approved_status ASC");

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
					list = new ArrayList<LmisOvertimeApprovals>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_REQUESTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisOvertimeApprovals> findByRequestID(int requestId,
		int start, int end) throws SystemException {
		return findByRequestID(requestId, start, end, null);
	}

	public List<LmisOvertimeApprovals> findByRequestID(int requestId,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(requestId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisOvertimeApprovals> list = (List<LmisOvertimeApprovals>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_REQUESTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOvertimeApprovals WHERE ");

				query.append("request_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("approved_status ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(requestId);

				list = (List<LmisOvertimeApprovals>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisOvertimeApprovals>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_REQUESTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisOvertimeApprovals findByRequestID_First(int requestId,
		OrderByComparator obc)
		throws NoSuchLmisOvertimeApprovalsException, SystemException {
		List<LmisOvertimeApprovals> list = findByRequestID(requestId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOvertimeApprovals exists with the key {");

			msg.append("requestId=" + requestId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOvertimeApprovalsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOvertimeApprovals findByRequestID_Last(int requestId,
		OrderByComparator obc)
		throws NoSuchLmisOvertimeApprovalsException, SystemException {
		int count = countByRequestID(requestId);

		List<LmisOvertimeApprovals> list = findByRequestID(requestId,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOvertimeApprovals exists with the key {");

			msg.append("requestId=" + requestId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOvertimeApprovalsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOvertimeApprovals[] findByRequestID_PrevAndNext(
		Integer lmisOvertimeApprovalsId, int requestId, OrderByComparator obc)
		throws NoSuchLmisOvertimeApprovalsException, SystemException {
		LmisOvertimeApprovals lmisOvertimeApprovals = findByPrimaryKey(lmisOvertimeApprovalsId);

		int count = countByRequestID(requestId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisOvertimeApprovals WHERE ");

			query.append("request_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("approved_status ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(requestId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisOvertimeApprovals);

			LmisOvertimeApprovals[] array = new LmisOvertimeApprovalsImpl[3];

			array[0] = (LmisOvertimeApprovals)objArray[0];
			array[1] = (LmisOvertimeApprovals)objArray[1];
			array[2] = (LmisOvertimeApprovals)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisOvertimeApprovals> findByReportIDGreater(int reportId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(reportId) };

		List<LmisOvertimeApprovals> list = (List<LmisOvertimeApprovals>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_REPORTIDGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOvertimeApprovals WHERE ");

				query.append("report_id > ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("approved_status ASC");

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
					list = new ArrayList<LmisOvertimeApprovals>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_REPORTIDGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisOvertimeApprovals> findByReportIDGreater(int reportId,
		int start, int end) throws SystemException {
		return findByReportIDGreater(reportId, start, end, null);
	}

	public List<LmisOvertimeApprovals> findByReportIDGreater(int reportId,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(reportId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisOvertimeApprovals> list = (List<LmisOvertimeApprovals>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_REPORTIDGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOvertimeApprovals WHERE ");

				query.append("report_id > ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("approved_status ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(reportId);

				list = (List<LmisOvertimeApprovals>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisOvertimeApprovals>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_REPORTIDGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisOvertimeApprovals findByReportIDGreater_First(int reportId,
		OrderByComparator obc)
		throws NoSuchLmisOvertimeApprovalsException, SystemException {
		List<LmisOvertimeApprovals> list = findByReportIDGreater(reportId, 0,
				1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOvertimeApprovals exists with the key {");

			msg.append("reportId=" + reportId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOvertimeApprovalsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOvertimeApprovals findByReportIDGreater_Last(int reportId,
		OrderByComparator obc)
		throws NoSuchLmisOvertimeApprovalsException, SystemException {
		int count = countByReportIDGreater(reportId);

		List<LmisOvertimeApprovals> list = findByReportIDGreater(reportId,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOvertimeApprovals exists with the key {");

			msg.append("reportId=" + reportId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOvertimeApprovalsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOvertimeApprovals[] findByReportIDGreater_PrevAndNext(
		Integer lmisOvertimeApprovalsId, int reportId, OrderByComparator obc)
		throws NoSuchLmisOvertimeApprovalsException, SystemException {
		LmisOvertimeApprovals lmisOvertimeApprovals = findByPrimaryKey(lmisOvertimeApprovalsId);

		int count = countByReportIDGreater(reportId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisOvertimeApprovals WHERE ");

			query.append("report_id > ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("approved_status ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(reportId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisOvertimeApprovals);

			LmisOvertimeApprovals[] array = new LmisOvertimeApprovalsImpl[3];

			array[0] = (LmisOvertimeApprovals)objArray[0];
			array[1] = (LmisOvertimeApprovals)objArray[1];
			array[2] = (LmisOvertimeApprovals)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisOvertimeApprovals> findByApprovedBy(int approvedBy)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(approvedBy) };

		List<LmisOvertimeApprovals> list = (List<LmisOvertimeApprovals>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_APPROVEDBY,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOvertimeApprovals WHERE ");

				query.append("approved_by = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("approved_status ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(approvedBy);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisOvertimeApprovals>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_APPROVEDBY,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisOvertimeApprovals> findByApprovedBy(int approvedBy,
		int start, int end) throws SystemException {
		return findByApprovedBy(approvedBy, start, end, null);
	}

	public List<LmisOvertimeApprovals> findByApprovedBy(int approvedBy,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(approvedBy),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisOvertimeApprovals> list = (List<LmisOvertimeApprovals>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_APPROVEDBY,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOvertimeApprovals WHERE ");

				query.append("approved_by = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("approved_status ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(approvedBy);

				list = (List<LmisOvertimeApprovals>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisOvertimeApprovals>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_APPROVEDBY,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisOvertimeApprovals findByApprovedBy_First(int approvedBy,
		OrderByComparator obc)
		throws NoSuchLmisOvertimeApprovalsException, SystemException {
		List<LmisOvertimeApprovals> list = findByApprovedBy(approvedBy, 0, 1,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOvertimeApprovals exists with the key {");

			msg.append("approvedBy=" + approvedBy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOvertimeApprovalsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOvertimeApprovals findByApprovedBy_Last(int approvedBy,
		OrderByComparator obc)
		throws NoSuchLmisOvertimeApprovalsException, SystemException {
		int count = countByApprovedBy(approvedBy);

		List<LmisOvertimeApprovals> list = findByApprovedBy(approvedBy,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOvertimeApprovals exists with the key {");

			msg.append("approvedBy=" + approvedBy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOvertimeApprovalsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOvertimeApprovals[] findByApprovedBy_PrevAndNext(
		Integer lmisOvertimeApprovalsId, int approvedBy, OrderByComparator obc)
		throws NoSuchLmisOvertimeApprovalsException, SystemException {
		LmisOvertimeApprovals lmisOvertimeApprovals = findByPrimaryKey(lmisOvertimeApprovalsId);

		int count = countByApprovedBy(approvedBy);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisOvertimeApprovals WHERE ");

			query.append("approved_by = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("approved_status ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(approvedBy);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisOvertimeApprovals);

			LmisOvertimeApprovals[] array = new LmisOvertimeApprovalsImpl[3];

			array[0] = (LmisOvertimeApprovals)objArray[0];
			array[1] = (LmisOvertimeApprovals)objArray[1];
			array[2] = (LmisOvertimeApprovals)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisOvertimeApprovals> findByReportID(int reportId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(reportId) };

		List<LmisOvertimeApprovals> list = (List<LmisOvertimeApprovals>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_REPORTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOvertimeApprovals WHERE ");

				query.append("report_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("approved_status ASC");

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
					list = new ArrayList<LmisOvertimeApprovals>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_REPORTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisOvertimeApprovals> findByReportID(int reportId, int start,
		int end) throws SystemException {
		return findByReportID(reportId, start, end, null);
	}

	public List<LmisOvertimeApprovals> findByReportID(int reportId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(reportId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisOvertimeApprovals> list = (List<LmisOvertimeApprovals>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_REPORTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOvertimeApprovals WHERE ");

				query.append("report_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("approved_status ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(reportId);

				list = (List<LmisOvertimeApprovals>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisOvertimeApprovals>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_REPORTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisOvertimeApprovals findByReportID_First(int reportId,
		OrderByComparator obc)
		throws NoSuchLmisOvertimeApprovalsException, SystemException {
		List<LmisOvertimeApprovals> list = findByReportID(reportId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOvertimeApprovals exists with the key {");

			msg.append("reportId=" + reportId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOvertimeApprovalsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOvertimeApprovals findByReportID_Last(int reportId,
		OrderByComparator obc)
		throws NoSuchLmisOvertimeApprovalsException, SystemException {
		int count = countByReportID(reportId);

		List<LmisOvertimeApprovals> list = findByReportID(reportId, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOvertimeApprovals exists with the key {");

			msg.append("reportId=" + reportId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOvertimeApprovalsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOvertimeApprovals[] findByReportID_PrevAndNext(
		Integer lmisOvertimeApprovalsId, int reportId, OrderByComparator obc)
		throws NoSuchLmisOvertimeApprovalsException, SystemException {
		LmisOvertimeApprovals lmisOvertimeApprovals = findByPrimaryKey(lmisOvertimeApprovalsId);

		int count = countByReportID(reportId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisOvertimeApprovals WHERE ");

			query.append("report_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("approved_status ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(reportId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisOvertimeApprovals);

			LmisOvertimeApprovals[] array = new LmisOvertimeApprovalsImpl[3];

			array[0] = (LmisOvertimeApprovals)objArray[0];
			array[1] = (LmisOvertimeApprovals)objArray[1];
			array[2] = (LmisOvertimeApprovals)objArray[2];

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

	public List<LmisOvertimeApprovals> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<LmisOvertimeApprovals> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<LmisOvertimeApprovals> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisOvertimeApprovals> list = (List<LmisOvertimeApprovals>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOvertimeApprovals ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("approved_status ASC");
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<LmisOvertimeApprovals>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LmisOvertimeApprovals>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisOvertimeApprovals>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByOvertimeApprovalsOf(int rootId)
		throws SystemException {
		for (LmisOvertimeApprovals lmisOvertimeApprovals : findByOvertimeApprovalsOf(
				rootId)) {
			remove(lmisOvertimeApprovals);
		}
	}

	public void removeByRequestID(int requestId) throws SystemException {
		for (LmisOvertimeApprovals lmisOvertimeApprovals : findByRequestID(
				requestId)) {
			remove(lmisOvertimeApprovals);
		}
	}

	public void removeByReportIDGreater(int reportId) throws SystemException {
		for (LmisOvertimeApprovals lmisOvertimeApprovals : findByReportIDGreater(
				reportId)) {
			remove(lmisOvertimeApprovals);
		}
	}

	public void removeByApprovedBy(int approvedBy) throws SystemException {
		for (LmisOvertimeApprovals lmisOvertimeApprovals : findByApprovedBy(
				approvedBy)) {
			remove(lmisOvertimeApprovals);
		}
	}

	public void removeByReportID(int reportId) throws SystemException {
		for (LmisOvertimeApprovals lmisOvertimeApprovals : findByReportID(
				reportId)) {
			remove(lmisOvertimeApprovals);
		}
	}

	public void removeAll() throws SystemException {
		for (LmisOvertimeApprovals lmisOvertimeApprovals : findAll()) {
			remove(lmisOvertimeApprovals);
		}
	}

	public int countByOvertimeApprovalsOf(int rootId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_OVERTIMEAPPROVALSOF,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisOvertimeApprovals WHERE ");

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_OVERTIMEAPPROVALSOF,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByRequestID(int requestId) throws SystemException {
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
					"FROM larion.progate.lmis.model.LmisOvertimeApprovals WHERE ");

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

	public int countByReportIDGreater(int reportId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(reportId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_REPORTIDGREATER,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisOvertimeApprovals WHERE ");

				query.append("report_id > ?");

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_REPORTIDGREATER,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByApprovedBy(int approvedBy) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(approvedBy) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_APPROVEDBY,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisOvertimeApprovals WHERE ");

				query.append("approved_by = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(approvedBy);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_APPROVEDBY,
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
					"FROM larion.progate.lmis.model.LmisOvertimeApprovals WHERE ");

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
						"SELECT COUNT(*) FROM larion.progate.lmis.model.LmisOvertimeApprovals");

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
						"value.object.listener.larion.progate.lmis.model.LmisOvertimeApprovals")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LmisOvertimeApprovals>> listenersList = new ArrayList<ModelListener<LmisOvertimeApprovals>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LmisOvertimeApprovals>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(LmisOvertimeApprovalsPersistenceImpl.class);
}