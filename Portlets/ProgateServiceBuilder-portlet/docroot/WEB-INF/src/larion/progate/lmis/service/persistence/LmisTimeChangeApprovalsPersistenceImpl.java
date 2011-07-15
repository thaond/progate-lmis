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

import larion.progate.lmis.NoSuchLmisTimeChangeApprovalsException;
import larion.progate.lmis.model.LmisTimeChangeApprovals;
import larion.progate.lmis.model.impl.LmisTimeChangeApprovalsImpl;
import larion.progate.lmis.model.impl.LmisTimeChangeApprovalsModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="LmisTimeChangeApprovalsPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisTimeChangeApprovalsPersistenceImpl extends BasePersistenceImpl
	implements LmisTimeChangeApprovalsPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = LmisTimeChangeApprovalsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_REQUESTID = new FinderPath(LmisTimeChangeApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			LmisTimeChangeApprovalsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRequestId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_REQUESTID = new FinderPath(LmisTimeChangeApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			LmisTimeChangeApprovalsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRequestId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_REQUESTID = new FinderPath(LmisTimeChangeApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			LmisTimeChangeApprovalsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByRequestId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ROOTID = new FinderPath(LmisTimeChangeApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			LmisTimeChangeApprovalsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ROOTID = new FinderPath(LmisTimeChangeApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			LmisTimeChangeApprovalsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ROOTID = new FinderPath(LmisTimeChangeApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			LmisTimeChangeApprovalsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByRootId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_APPROVEDBY = new FinderPath(LmisTimeChangeApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			LmisTimeChangeApprovalsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByApprovedBy",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_APPROVEDBY = new FinderPath(LmisTimeChangeApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			LmisTimeChangeApprovalsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByApprovedBy",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_APPROVEDBY = new FinderPath(LmisTimeChangeApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			LmisTimeChangeApprovalsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByApprovedBy",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(LmisTimeChangeApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			LmisTimeChangeApprovalsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LmisTimeChangeApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			LmisTimeChangeApprovalsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(LmisTimeChangeApprovals lmisTimeChangeApprovals) {
		EntityCacheUtil.putResult(LmisTimeChangeApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			LmisTimeChangeApprovalsImpl.class,
			lmisTimeChangeApprovals.getPrimaryKey(), lmisTimeChangeApprovals);
	}

	public void cacheResult(
		List<LmisTimeChangeApprovals> lmisTimeChangeApprovalses) {
		for (LmisTimeChangeApprovals lmisTimeChangeApprovals : lmisTimeChangeApprovalses) {
			if (EntityCacheUtil.getResult(
						LmisTimeChangeApprovalsModelImpl.ENTITY_CACHE_ENABLED,
						LmisTimeChangeApprovalsImpl.class,
						lmisTimeChangeApprovals.getPrimaryKey(), this) == null) {
				cacheResult(lmisTimeChangeApprovals);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(LmisTimeChangeApprovalsImpl.class.getName());
		EntityCacheUtil.clearCache(LmisTimeChangeApprovalsImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public LmisTimeChangeApprovals create(Integer lmisTimeChangeApprovalId) {
		LmisTimeChangeApprovals lmisTimeChangeApprovals = new LmisTimeChangeApprovalsImpl();

		lmisTimeChangeApprovals.setNew(true);
		lmisTimeChangeApprovals.setPrimaryKey(lmisTimeChangeApprovalId);

		return lmisTimeChangeApprovals;
	}

	public LmisTimeChangeApprovals remove(Integer lmisTimeChangeApprovalId)
		throws NoSuchLmisTimeChangeApprovalsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LmisTimeChangeApprovals lmisTimeChangeApprovals = (LmisTimeChangeApprovals)session.get(LmisTimeChangeApprovalsImpl.class,
					lmisTimeChangeApprovalId);

			if (lmisTimeChangeApprovals == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No LmisTimeChangeApprovals exists with the primary key " +
						lmisTimeChangeApprovalId);
				}

				throw new NoSuchLmisTimeChangeApprovalsException(
					"No LmisTimeChangeApprovals exists with the primary key " +
					lmisTimeChangeApprovalId);
			}

			return remove(lmisTimeChangeApprovals);
		}
		catch (NoSuchLmisTimeChangeApprovalsException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public LmisTimeChangeApprovals remove(
		LmisTimeChangeApprovals lmisTimeChangeApprovals)
		throws SystemException {
		for (ModelListener<LmisTimeChangeApprovals> listener : listeners) {
			listener.onBeforeRemove(lmisTimeChangeApprovals);
		}

		lmisTimeChangeApprovals = removeImpl(lmisTimeChangeApprovals);

		for (ModelListener<LmisTimeChangeApprovals> listener : listeners) {
			listener.onAfterRemove(lmisTimeChangeApprovals);
		}

		return lmisTimeChangeApprovals;
	}

	protected LmisTimeChangeApprovals removeImpl(
		LmisTimeChangeApprovals lmisTimeChangeApprovals)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (lmisTimeChangeApprovals.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(LmisTimeChangeApprovalsImpl.class,
						lmisTimeChangeApprovals.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(lmisTimeChangeApprovals);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(LmisTimeChangeApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			LmisTimeChangeApprovalsImpl.class,
			lmisTimeChangeApprovals.getPrimaryKey());

		return lmisTimeChangeApprovals;
	}

	public LmisTimeChangeApprovals update(
		LmisTimeChangeApprovals lmisTimeChangeApprovals)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(LmisTimeChangeApprovals lmisTimeChangeApprovals) method. Use update(LmisTimeChangeApprovals lmisTimeChangeApprovals, boolean merge) instead.");
		}

		return update(lmisTimeChangeApprovals, false);
	}

	public LmisTimeChangeApprovals update(
		LmisTimeChangeApprovals lmisTimeChangeApprovals, boolean merge)
		throws SystemException {
		boolean isNew = lmisTimeChangeApprovals.isNew();

		for (ModelListener<LmisTimeChangeApprovals> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(lmisTimeChangeApprovals);
			}
			else {
				listener.onBeforeUpdate(lmisTimeChangeApprovals);
			}
		}

		lmisTimeChangeApprovals = updateImpl(lmisTimeChangeApprovals, merge);

		for (ModelListener<LmisTimeChangeApprovals> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(lmisTimeChangeApprovals);
			}
			else {
				listener.onAfterUpdate(lmisTimeChangeApprovals);
			}
		}

		return lmisTimeChangeApprovals;
	}

	public LmisTimeChangeApprovals updateImpl(
		larion.progate.lmis.model.LmisTimeChangeApprovals lmisTimeChangeApprovals,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, lmisTimeChangeApprovals, merge);

			lmisTimeChangeApprovals.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(LmisTimeChangeApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			LmisTimeChangeApprovalsImpl.class,
			lmisTimeChangeApprovals.getPrimaryKey(), lmisTimeChangeApprovals);

		return lmisTimeChangeApprovals;
	}

	public LmisTimeChangeApprovals findByPrimaryKey(
		Integer lmisTimeChangeApprovalId)
		throws NoSuchLmisTimeChangeApprovalsException, SystemException {
		LmisTimeChangeApprovals lmisTimeChangeApprovals = fetchByPrimaryKey(lmisTimeChangeApprovalId);

		if (lmisTimeChangeApprovals == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"No LmisTimeChangeApprovals exists with the primary key " +
					lmisTimeChangeApprovalId);
			}

			throw new NoSuchLmisTimeChangeApprovalsException(
				"No LmisTimeChangeApprovals exists with the primary key " +
				lmisTimeChangeApprovalId);
		}

		return lmisTimeChangeApprovals;
	}

	public LmisTimeChangeApprovals fetchByPrimaryKey(
		Integer lmisTimeChangeApprovalId) throws SystemException {
		LmisTimeChangeApprovals lmisTimeChangeApprovals = (LmisTimeChangeApprovals)EntityCacheUtil.getResult(LmisTimeChangeApprovalsModelImpl.ENTITY_CACHE_ENABLED,
				LmisTimeChangeApprovalsImpl.class, lmisTimeChangeApprovalId,
				this);

		if (lmisTimeChangeApprovals == null) {
			Session session = null;

			try {
				session = openSession();

				lmisTimeChangeApprovals = (LmisTimeChangeApprovals)session.get(LmisTimeChangeApprovalsImpl.class,
						lmisTimeChangeApprovalId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (lmisTimeChangeApprovals != null) {
					cacheResult(lmisTimeChangeApprovals);
				}

				closeSession(session);
			}
		}

		return lmisTimeChangeApprovals;
	}

	public List<LmisTimeChangeApprovals> findByRequestId(int requestId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(requestId) };

		List<LmisTimeChangeApprovals> list = (List<LmisTimeChangeApprovals>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_REQUESTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisTimeChangeApprovals WHERE ");

				query.append("request_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("approved_status ASC, ");
				query.append("approved_at DESC");

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
					list = new ArrayList<LmisTimeChangeApprovals>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_REQUESTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisTimeChangeApprovals> findByRequestId(int requestId,
		int start, int end) throws SystemException {
		return findByRequestId(requestId, start, end, null);
	}

	public List<LmisTimeChangeApprovals> findByRequestId(int requestId,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(requestId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisTimeChangeApprovals> list = (List<LmisTimeChangeApprovals>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_REQUESTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisTimeChangeApprovals WHERE ");

				query.append("request_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("approved_status ASC, ");
					query.append("approved_at DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(requestId);

				list = (List<LmisTimeChangeApprovals>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisTimeChangeApprovals>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_REQUESTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisTimeChangeApprovals findByRequestId_First(int requestId,
		OrderByComparator obc)
		throws NoSuchLmisTimeChangeApprovalsException, SystemException {
		List<LmisTimeChangeApprovals> list = findByRequestId(requestId, 0, 1,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisTimeChangeApprovals exists with the key {");

			msg.append("requestId=" + requestId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisTimeChangeApprovalsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisTimeChangeApprovals findByRequestId_Last(int requestId,
		OrderByComparator obc)
		throws NoSuchLmisTimeChangeApprovalsException, SystemException {
		int count = countByRequestId(requestId);

		List<LmisTimeChangeApprovals> list = findByRequestId(requestId,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisTimeChangeApprovals exists with the key {");

			msg.append("requestId=" + requestId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisTimeChangeApprovalsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisTimeChangeApprovals[] findByRequestId_PrevAndNext(
		Integer lmisTimeChangeApprovalId, int requestId, OrderByComparator obc)
		throws NoSuchLmisTimeChangeApprovalsException, SystemException {
		LmisTimeChangeApprovals lmisTimeChangeApprovals = findByPrimaryKey(lmisTimeChangeApprovalId);

		int count = countByRequestId(requestId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisTimeChangeApprovals WHERE ");

			query.append("request_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("approved_status ASC, ");
				query.append("approved_at DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(requestId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisTimeChangeApprovals);

			LmisTimeChangeApprovals[] array = new LmisTimeChangeApprovalsImpl[3];

			array[0] = (LmisTimeChangeApprovals)objArray[0];
			array[1] = (LmisTimeChangeApprovals)objArray[1];
			array[2] = (LmisTimeChangeApprovals)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisTimeChangeApprovals> findByRootId(int rootId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		List<LmisTimeChangeApprovals> list = (List<LmisTimeChangeApprovals>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisTimeChangeApprovals WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("approved_status ASC, ");
				query.append("approved_at DESC");

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
					list = new ArrayList<LmisTimeChangeApprovals>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisTimeChangeApprovals> findByRootId(int rootId, int start,
		int end) throws SystemException {
		return findByRootId(rootId, start, end, null);
	}

	public List<LmisTimeChangeApprovals> findByRootId(int rootId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(rootId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisTimeChangeApprovals> list = (List<LmisTimeChangeApprovals>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisTimeChangeApprovals WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("approved_status ASC, ");
					query.append("approved_at DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rootId);

				list = (List<LmisTimeChangeApprovals>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisTimeChangeApprovals>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisTimeChangeApprovals findByRootId_First(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisTimeChangeApprovalsException, SystemException {
		List<LmisTimeChangeApprovals> list = findByRootId(rootId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisTimeChangeApprovals exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisTimeChangeApprovalsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisTimeChangeApprovals findByRootId_Last(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisTimeChangeApprovalsException, SystemException {
		int count = countByRootId(rootId);

		List<LmisTimeChangeApprovals> list = findByRootId(rootId, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisTimeChangeApprovals exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisTimeChangeApprovalsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisTimeChangeApprovals[] findByRootId_PrevAndNext(
		Integer lmisTimeChangeApprovalId, int rootId, OrderByComparator obc)
		throws NoSuchLmisTimeChangeApprovalsException, SystemException {
		LmisTimeChangeApprovals lmisTimeChangeApprovals = findByPrimaryKey(lmisTimeChangeApprovalId);

		int count = countByRootId(rootId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisTimeChangeApprovals WHERE ");

			query.append("root_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("approved_status ASC, ");
				query.append("approved_at DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(rootId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisTimeChangeApprovals);

			LmisTimeChangeApprovals[] array = new LmisTimeChangeApprovalsImpl[3];

			array[0] = (LmisTimeChangeApprovals)objArray[0];
			array[1] = (LmisTimeChangeApprovals)objArray[1];
			array[2] = (LmisTimeChangeApprovals)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisTimeChangeApprovals> findByApprovedBy(int approvedBy)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(approvedBy) };

		List<LmisTimeChangeApprovals> list = (List<LmisTimeChangeApprovals>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_APPROVEDBY,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisTimeChangeApprovals WHERE ");

				query.append("approved_by = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("approved_status ASC, ");
				query.append("approved_at DESC");

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
					list = new ArrayList<LmisTimeChangeApprovals>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_APPROVEDBY,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisTimeChangeApprovals> findByApprovedBy(int approvedBy,
		int start, int end) throws SystemException {
		return findByApprovedBy(approvedBy, start, end, null);
	}

	public List<LmisTimeChangeApprovals> findByApprovedBy(int approvedBy,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(approvedBy),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisTimeChangeApprovals> list = (List<LmisTimeChangeApprovals>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_APPROVEDBY,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisTimeChangeApprovals WHERE ");

				query.append("approved_by = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("approved_status ASC, ");
					query.append("approved_at DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(approvedBy);

				list = (List<LmisTimeChangeApprovals>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisTimeChangeApprovals>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_APPROVEDBY,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisTimeChangeApprovals findByApprovedBy_First(int approvedBy,
		OrderByComparator obc)
		throws NoSuchLmisTimeChangeApprovalsException, SystemException {
		List<LmisTimeChangeApprovals> list = findByApprovedBy(approvedBy, 0, 1,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisTimeChangeApprovals exists with the key {");

			msg.append("approvedBy=" + approvedBy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisTimeChangeApprovalsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisTimeChangeApprovals findByApprovedBy_Last(int approvedBy,
		OrderByComparator obc)
		throws NoSuchLmisTimeChangeApprovalsException, SystemException {
		int count = countByApprovedBy(approvedBy);

		List<LmisTimeChangeApprovals> list = findByApprovedBy(approvedBy,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisTimeChangeApprovals exists with the key {");

			msg.append("approvedBy=" + approvedBy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisTimeChangeApprovalsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisTimeChangeApprovals[] findByApprovedBy_PrevAndNext(
		Integer lmisTimeChangeApprovalId, int approvedBy, OrderByComparator obc)
		throws NoSuchLmisTimeChangeApprovalsException, SystemException {
		LmisTimeChangeApprovals lmisTimeChangeApprovals = findByPrimaryKey(lmisTimeChangeApprovalId);

		int count = countByApprovedBy(approvedBy);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisTimeChangeApprovals WHERE ");

			query.append("approved_by = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("approved_status ASC, ");
				query.append("approved_at DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(approvedBy);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisTimeChangeApprovals);

			LmisTimeChangeApprovals[] array = new LmisTimeChangeApprovalsImpl[3];

			array[0] = (LmisTimeChangeApprovals)objArray[0];
			array[1] = (LmisTimeChangeApprovals)objArray[1];
			array[2] = (LmisTimeChangeApprovals)objArray[2];

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

	public List<LmisTimeChangeApprovals> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<LmisTimeChangeApprovals> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<LmisTimeChangeApprovals> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisTimeChangeApprovals> list = (List<LmisTimeChangeApprovals>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisTimeChangeApprovals ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("approved_status ASC, ");
					query.append("approved_at DESC");
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<LmisTimeChangeApprovals>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LmisTimeChangeApprovals>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisTimeChangeApprovals>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByRequestId(int requestId) throws SystemException {
		for (LmisTimeChangeApprovals lmisTimeChangeApprovals : findByRequestId(
				requestId)) {
			remove(lmisTimeChangeApprovals);
		}
	}

	public void removeByRootId(int rootId) throws SystemException {
		for (LmisTimeChangeApprovals lmisTimeChangeApprovals : findByRootId(
				rootId)) {
			remove(lmisTimeChangeApprovals);
		}
	}

	public void removeByApprovedBy(int approvedBy) throws SystemException {
		for (LmisTimeChangeApprovals lmisTimeChangeApprovals : findByApprovedBy(
				approvedBy)) {
			remove(lmisTimeChangeApprovals);
		}
	}

	public void removeAll() throws SystemException {
		for (LmisTimeChangeApprovals lmisTimeChangeApprovals : findAll()) {
			remove(lmisTimeChangeApprovals);
		}
	}

	public int countByRequestId(int requestId) throws SystemException {
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
					"FROM larion.progate.lmis.model.LmisTimeChangeApprovals WHERE ");

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
					"FROM larion.progate.lmis.model.LmisTimeChangeApprovals WHERE ");

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
					"FROM larion.progate.lmis.model.LmisTimeChangeApprovals WHERE ");

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
						"SELECT COUNT(*) FROM larion.progate.lmis.model.LmisTimeChangeApprovals");

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
						"value.object.listener.larion.progate.lmis.model.LmisTimeChangeApprovals")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LmisTimeChangeApprovals>> listenersList = new ArrayList<ModelListener<LmisTimeChangeApprovals>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LmisTimeChangeApprovals>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(LmisTimeChangeApprovalsPersistenceImpl.class);
}