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

import larion.progate.lmis.NoSuchLmisAbsenceApprovalsException;
import larion.progate.lmis.model.LmisAbsenceApprovals;
import larion.progate.lmis.model.impl.LmisAbsenceApprovalsImpl;
import larion.progate.lmis.model.impl.LmisAbsenceApprovalsModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="LmisAbsenceApprovalsPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisAbsenceApprovalsPersistenceImpl extends BasePersistenceImpl
	implements LmisAbsenceApprovalsPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = LmisAbsenceApprovalsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_ROOTID = new FinderPath(LmisAbsenceApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceApprovalsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ROOTID = new FinderPath(LmisAbsenceApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceApprovalsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ROOTID = new FinderPath(LmisAbsenceApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceApprovalsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByRootID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_REQUESTID = new FinderPath(LmisAbsenceApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceApprovalsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRequestID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_REQUESTID = new FinderPath(LmisAbsenceApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceApprovalsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRequestID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_REQUESTID = new FinderPath(LmisAbsenceApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceApprovalsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByRequestID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_APPROVEDBY = new FinderPath(LmisAbsenceApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceApprovalsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByApprovedBy",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_APPROVEDBY = new FinderPath(LmisAbsenceApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceApprovalsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByApprovedBy",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_APPROVEDBY = new FinderPath(LmisAbsenceApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceApprovalsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByApprovedBy",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(LmisAbsenceApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceApprovalsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LmisAbsenceApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceApprovalsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(LmisAbsenceApprovals lmisAbsenceApprovals) {
		EntityCacheUtil.putResult(LmisAbsenceApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceApprovalsImpl.class,
			lmisAbsenceApprovals.getPrimaryKey(), lmisAbsenceApprovals);
	}

	public void cacheResult(List<LmisAbsenceApprovals> lmisAbsenceApprovalses) {
		for (LmisAbsenceApprovals lmisAbsenceApprovals : lmisAbsenceApprovalses) {
			if (EntityCacheUtil.getResult(
						LmisAbsenceApprovalsModelImpl.ENTITY_CACHE_ENABLED,
						LmisAbsenceApprovalsImpl.class,
						lmisAbsenceApprovals.getPrimaryKey(), this) == null) {
				cacheResult(lmisAbsenceApprovals);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(LmisAbsenceApprovalsImpl.class.getName());
		EntityCacheUtil.clearCache(LmisAbsenceApprovalsImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public LmisAbsenceApprovals create(Integer lmisAbsenceApprovalsId) {
		LmisAbsenceApprovals lmisAbsenceApprovals = new LmisAbsenceApprovalsImpl();

		lmisAbsenceApprovals.setNew(true);
		lmisAbsenceApprovals.setPrimaryKey(lmisAbsenceApprovalsId);

		return lmisAbsenceApprovals;
	}

	public LmisAbsenceApprovals remove(Integer lmisAbsenceApprovalsId)
		throws NoSuchLmisAbsenceApprovalsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LmisAbsenceApprovals lmisAbsenceApprovals = (LmisAbsenceApprovals)session.get(LmisAbsenceApprovalsImpl.class,
					lmisAbsenceApprovalsId);

			if (lmisAbsenceApprovals == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No LmisAbsenceApprovals exists with the primary key " +
						lmisAbsenceApprovalsId);
				}

				throw new NoSuchLmisAbsenceApprovalsException(
					"No LmisAbsenceApprovals exists with the primary key " +
					lmisAbsenceApprovalsId);
			}

			return remove(lmisAbsenceApprovals);
		}
		catch (NoSuchLmisAbsenceApprovalsException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public LmisAbsenceApprovals remove(
		LmisAbsenceApprovals lmisAbsenceApprovals) throws SystemException {
		for (ModelListener<LmisAbsenceApprovals> listener : listeners) {
			listener.onBeforeRemove(lmisAbsenceApprovals);
		}

		lmisAbsenceApprovals = removeImpl(lmisAbsenceApprovals);

		for (ModelListener<LmisAbsenceApprovals> listener : listeners) {
			listener.onAfterRemove(lmisAbsenceApprovals);
		}

		return lmisAbsenceApprovals;
	}

	protected LmisAbsenceApprovals removeImpl(
		LmisAbsenceApprovals lmisAbsenceApprovals) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (lmisAbsenceApprovals.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(LmisAbsenceApprovalsImpl.class,
						lmisAbsenceApprovals.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(lmisAbsenceApprovals);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(LmisAbsenceApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceApprovalsImpl.class, lmisAbsenceApprovals.getPrimaryKey());

		return lmisAbsenceApprovals;
	}

	public LmisAbsenceApprovals update(
		LmisAbsenceApprovals lmisAbsenceApprovals) throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(LmisAbsenceApprovals lmisAbsenceApprovals) method. Use update(LmisAbsenceApprovals lmisAbsenceApprovals, boolean merge) instead.");
		}

		return update(lmisAbsenceApprovals, false);
	}

	public LmisAbsenceApprovals update(
		LmisAbsenceApprovals lmisAbsenceApprovals, boolean merge)
		throws SystemException {
		boolean isNew = lmisAbsenceApprovals.isNew();

		for (ModelListener<LmisAbsenceApprovals> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(lmisAbsenceApprovals);
			}
			else {
				listener.onBeforeUpdate(lmisAbsenceApprovals);
			}
		}

		lmisAbsenceApprovals = updateImpl(lmisAbsenceApprovals, merge);

		for (ModelListener<LmisAbsenceApprovals> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(lmisAbsenceApprovals);
			}
			else {
				listener.onAfterUpdate(lmisAbsenceApprovals);
			}
		}

		return lmisAbsenceApprovals;
	}

	public LmisAbsenceApprovals updateImpl(
		larion.progate.lmis.model.LmisAbsenceApprovals lmisAbsenceApprovals,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, lmisAbsenceApprovals, merge);

			lmisAbsenceApprovals.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(LmisAbsenceApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceApprovalsImpl.class,
			lmisAbsenceApprovals.getPrimaryKey(), lmisAbsenceApprovals);

		return lmisAbsenceApprovals;
	}

	public LmisAbsenceApprovals findByPrimaryKey(Integer lmisAbsenceApprovalsId)
		throws NoSuchLmisAbsenceApprovalsException, SystemException {
		LmisAbsenceApprovals lmisAbsenceApprovals = fetchByPrimaryKey(lmisAbsenceApprovalsId);

		if (lmisAbsenceApprovals == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"No LmisAbsenceApprovals exists with the primary key " +
					lmisAbsenceApprovalsId);
			}

			throw new NoSuchLmisAbsenceApprovalsException(
				"No LmisAbsenceApprovals exists with the primary key " +
				lmisAbsenceApprovalsId);
		}

		return lmisAbsenceApprovals;
	}

	public LmisAbsenceApprovals fetchByPrimaryKey(
		Integer lmisAbsenceApprovalsId) throws SystemException {
		LmisAbsenceApprovals lmisAbsenceApprovals = (LmisAbsenceApprovals)EntityCacheUtil.getResult(LmisAbsenceApprovalsModelImpl.ENTITY_CACHE_ENABLED,
				LmisAbsenceApprovalsImpl.class, lmisAbsenceApprovalsId, this);

		if (lmisAbsenceApprovals == null) {
			Session session = null;

			try {
				session = openSession();

				lmisAbsenceApprovals = (LmisAbsenceApprovals)session.get(LmisAbsenceApprovalsImpl.class,
						lmisAbsenceApprovalsId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (lmisAbsenceApprovals != null) {
					cacheResult(lmisAbsenceApprovals);
				}

				closeSession(session);
			}
		}

		return lmisAbsenceApprovals;
	}

	public List<LmisAbsenceApprovals> findByRootID(int rootId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		List<LmisAbsenceApprovals> list = (List<LmisAbsenceApprovals>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceApprovals WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("approved_status ASC, ");
				query.append("approved_at ASC");

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
					list = new ArrayList<LmisAbsenceApprovals>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisAbsenceApprovals> findByRootID(int rootId, int start,
		int end) throws SystemException {
		return findByRootID(rootId, start, end, null);
	}

	public List<LmisAbsenceApprovals> findByRootID(int rootId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(rootId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisAbsenceApprovals> list = (List<LmisAbsenceApprovals>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceApprovals WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("approved_status ASC, ");
					query.append("approved_at ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rootId);

				list = (List<LmisAbsenceApprovals>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisAbsenceApprovals>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisAbsenceApprovals findByRootID_First(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisAbsenceApprovalsException, SystemException {
		List<LmisAbsenceApprovals> list = findByRootID(rootId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAbsenceApprovals exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAbsenceApprovalsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAbsenceApprovals findByRootID_Last(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisAbsenceApprovalsException, SystemException {
		int count = countByRootID(rootId);

		List<LmisAbsenceApprovals> list = findByRootID(rootId, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAbsenceApprovals exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAbsenceApprovalsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAbsenceApprovals[] findByRootID_PrevAndNext(
		Integer lmisAbsenceApprovalsId, int rootId, OrderByComparator obc)
		throws NoSuchLmisAbsenceApprovalsException, SystemException {
		LmisAbsenceApprovals lmisAbsenceApprovals = findByPrimaryKey(lmisAbsenceApprovalsId);

		int count = countByRootID(rootId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisAbsenceApprovals WHERE ");

			query.append("root_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("approved_status ASC, ");
				query.append("approved_at ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(rootId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisAbsenceApprovals);

			LmisAbsenceApprovals[] array = new LmisAbsenceApprovalsImpl[3];

			array[0] = (LmisAbsenceApprovals)objArray[0];
			array[1] = (LmisAbsenceApprovals)objArray[1];
			array[2] = (LmisAbsenceApprovals)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisAbsenceApprovals> findByRequestID(int requestId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(requestId) };

		List<LmisAbsenceApprovals> list = (List<LmisAbsenceApprovals>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_REQUESTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceApprovals WHERE ");

				query.append("request_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("approved_status ASC, ");
				query.append("approved_at ASC");

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
					list = new ArrayList<LmisAbsenceApprovals>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_REQUESTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisAbsenceApprovals> findByRequestID(int requestId, int start,
		int end) throws SystemException {
		return findByRequestID(requestId, start, end, null);
	}

	public List<LmisAbsenceApprovals> findByRequestID(int requestId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(requestId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisAbsenceApprovals> list = (List<LmisAbsenceApprovals>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_REQUESTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceApprovals WHERE ");

				query.append("request_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("approved_status ASC, ");
					query.append("approved_at ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(requestId);

				list = (List<LmisAbsenceApprovals>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisAbsenceApprovals>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_REQUESTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisAbsenceApprovals findByRequestID_First(int requestId,
		OrderByComparator obc)
		throws NoSuchLmisAbsenceApprovalsException, SystemException {
		List<LmisAbsenceApprovals> list = findByRequestID(requestId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAbsenceApprovals exists with the key {");

			msg.append("requestId=" + requestId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAbsenceApprovalsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAbsenceApprovals findByRequestID_Last(int requestId,
		OrderByComparator obc)
		throws NoSuchLmisAbsenceApprovalsException, SystemException {
		int count = countByRequestID(requestId);

		List<LmisAbsenceApprovals> list = findByRequestID(requestId, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAbsenceApprovals exists with the key {");

			msg.append("requestId=" + requestId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAbsenceApprovalsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAbsenceApprovals[] findByRequestID_PrevAndNext(
		Integer lmisAbsenceApprovalsId, int requestId, OrderByComparator obc)
		throws NoSuchLmisAbsenceApprovalsException, SystemException {
		LmisAbsenceApprovals lmisAbsenceApprovals = findByPrimaryKey(lmisAbsenceApprovalsId);

		int count = countByRequestID(requestId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisAbsenceApprovals WHERE ");

			query.append("request_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("approved_status ASC, ");
				query.append("approved_at ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(requestId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisAbsenceApprovals);

			LmisAbsenceApprovals[] array = new LmisAbsenceApprovalsImpl[3];

			array[0] = (LmisAbsenceApprovals)objArray[0];
			array[1] = (LmisAbsenceApprovals)objArray[1];
			array[2] = (LmisAbsenceApprovals)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisAbsenceApprovals> findByApprovedBy(int approvedBy)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(approvedBy) };

		List<LmisAbsenceApprovals> list = (List<LmisAbsenceApprovals>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_APPROVEDBY,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceApprovals WHERE ");

				query.append("approved_by = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("approved_status ASC, ");
				query.append("approved_at ASC");

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
					list = new ArrayList<LmisAbsenceApprovals>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_APPROVEDBY,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisAbsenceApprovals> findByApprovedBy(int approvedBy,
		int start, int end) throws SystemException {
		return findByApprovedBy(approvedBy, start, end, null);
	}

	public List<LmisAbsenceApprovals> findByApprovedBy(int approvedBy,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(approvedBy),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisAbsenceApprovals> list = (List<LmisAbsenceApprovals>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_APPROVEDBY,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceApprovals WHERE ");

				query.append("approved_by = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("approved_status ASC, ");
					query.append("approved_at ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(approvedBy);

				list = (List<LmisAbsenceApprovals>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisAbsenceApprovals>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_APPROVEDBY,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisAbsenceApprovals findByApprovedBy_First(int approvedBy,
		OrderByComparator obc)
		throws NoSuchLmisAbsenceApprovalsException, SystemException {
		List<LmisAbsenceApprovals> list = findByApprovedBy(approvedBy, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAbsenceApprovals exists with the key {");

			msg.append("approvedBy=" + approvedBy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAbsenceApprovalsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAbsenceApprovals findByApprovedBy_Last(int approvedBy,
		OrderByComparator obc)
		throws NoSuchLmisAbsenceApprovalsException, SystemException {
		int count = countByApprovedBy(approvedBy);

		List<LmisAbsenceApprovals> list = findByApprovedBy(approvedBy,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAbsenceApprovals exists with the key {");

			msg.append("approvedBy=" + approvedBy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAbsenceApprovalsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAbsenceApprovals[] findByApprovedBy_PrevAndNext(
		Integer lmisAbsenceApprovalsId, int approvedBy, OrderByComparator obc)
		throws NoSuchLmisAbsenceApprovalsException, SystemException {
		LmisAbsenceApprovals lmisAbsenceApprovals = findByPrimaryKey(lmisAbsenceApprovalsId);

		int count = countByApprovedBy(approvedBy);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisAbsenceApprovals WHERE ");

			query.append("approved_by = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("approved_status ASC, ");
				query.append("approved_at ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(approvedBy);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisAbsenceApprovals);

			LmisAbsenceApprovals[] array = new LmisAbsenceApprovalsImpl[3];

			array[0] = (LmisAbsenceApprovals)objArray[0];
			array[1] = (LmisAbsenceApprovals)objArray[1];
			array[2] = (LmisAbsenceApprovals)objArray[2];

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

	public List<LmisAbsenceApprovals> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<LmisAbsenceApprovals> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<LmisAbsenceApprovals> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisAbsenceApprovals> list = (List<LmisAbsenceApprovals>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceApprovals ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("approved_status ASC, ");
					query.append("approved_at ASC");
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<LmisAbsenceApprovals>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LmisAbsenceApprovals>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisAbsenceApprovals>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByRootID(int rootId) throws SystemException {
		for (LmisAbsenceApprovals lmisAbsenceApprovals : findByRootID(rootId)) {
			remove(lmisAbsenceApprovals);
		}
	}

	public void removeByRequestID(int requestId) throws SystemException {
		for (LmisAbsenceApprovals lmisAbsenceApprovals : findByRequestID(
				requestId)) {
			remove(lmisAbsenceApprovals);
		}
	}

	public void removeByApprovedBy(int approvedBy) throws SystemException {
		for (LmisAbsenceApprovals lmisAbsenceApprovals : findByApprovedBy(
				approvedBy)) {
			remove(lmisAbsenceApprovals);
		}
	}

	public void removeAll() throws SystemException {
		for (LmisAbsenceApprovals lmisAbsenceApprovals : findAll()) {
			remove(lmisAbsenceApprovals);
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
					"FROM larion.progate.lmis.model.LmisAbsenceApprovals WHERE ");

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
					"FROM larion.progate.lmis.model.LmisAbsenceApprovals WHERE ");

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
					"FROM larion.progate.lmis.model.LmisAbsenceApprovals WHERE ");

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

	public int countAll() throws SystemException {
		Object[] finderArgs = new Object[0];

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(
						"SELECT COUNT(*) FROM larion.progate.lmis.model.LmisAbsenceApprovals");

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
						"value.object.listener.larion.progate.lmis.model.LmisAbsenceApprovals")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LmisAbsenceApprovals>> listenersList = new ArrayList<ModelListener<LmisAbsenceApprovals>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LmisAbsenceApprovals>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(LmisAbsenceApprovalsPersistenceImpl.class);
}