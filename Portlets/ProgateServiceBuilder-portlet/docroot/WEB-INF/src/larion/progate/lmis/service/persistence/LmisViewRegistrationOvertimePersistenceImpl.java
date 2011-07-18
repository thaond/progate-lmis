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

import larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeException;
import larion.progate.lmis.model.LmisViewRegistrationOvertime;
import larion.progate.lmis.model.impl.LmisViewRegistrationOvertimeImpl;
import larion.progate.lmis.model.impl.LmisViewRegistrationOvertimeModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * <a href="LmisViewRegistrationOvertimePersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewRegistrationOvertimePersistenceImpl
	extends BasePersistenceImpl
	implements LmisViewRegistrationOvertimePersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = LmisViewRegistrationOvertimeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_ROOTID = new FinderPath(LmisViewRegistrationOvertimeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewRegistrationOvertimeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ROOTID = new FinderPath(LmisViewRegistrationOvertimeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewRegistrationOvertimeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ROOTID = new FinderPath(LmisViewRegistrationOvertimeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewRegistrationOvertimeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByRootID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_REQUESTID = new FinderPath(LmisViewRegistrationOvertimeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewRegistrationOvertimeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRequestID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_REQUESTID = new FinderPath(LmisViewRegistrationOvertimeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewRegistrationOvertimeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRequestID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_REQUESTID = new FinderPath(LmisViewRegistrationOvertimeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewRegistrationOvertimeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByRequestID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ORGID = new FinderPath(LmisViewRegistrationOvertimeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewRegistrationOvertimeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOrgID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ORGID = new FinderPath(LmisViewRegistrationOvertimeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewRegistrationOvertimeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOrgID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGID = new FinderPath(LmisViewRegistrationOvertimeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewRegistrationOvertimeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByOrgID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_REQUESTEDAT = new FinderPath(LmisViewRegistrationOvertimeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewRegistrationOvertimeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRequestedAt",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_REQUESTEDAT = new FinderPath(LmisViewRegistrationOvertimeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewRegistrationOvertimeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRequestedAt",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_REQUESTEDAT = new FinderPath(LmisViewRegistrationOvertimeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewRegistrationOvertimeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByRequestedAt",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_REQUESTEDSTATUS = new FinderPath(LmisViewRegistrationOvertimeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewRegistrationOvertimeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRequestedStatus",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_REQUESTEDSTATUS = new FinderPath(LmisViewRegistrationOvertimeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewRegistrationOvertimeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRequestedStatus",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_REQUESTEDSTATUS = new FinderPath(LmisViewRegistrationOvertimeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewRegistrationOvertimeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByRequestedStatus",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_USERID = new FinderPath(LmisViewRegistrationOvertimeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewRegistrationOvertimeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByuserID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_USERID = new FinderPath(LmisViewRegistrationOvertimeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewRegistrationOvertimeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByuserID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(LmisViewRegistrationOvertimeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewRegistrationOvertimeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByuserID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_REQUESTEDBY = new FinderPath(LmisViewRegistrationOvertimeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewRegistrationOvertimeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRequestedBy",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_REQUESTEDBY = new FinderPath(LmisViewRegistrationOvertimeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewRegistrationOvertimeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRequestedBy",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_REQUESTEDBY = new FinderPath(LmisViewRegistrationOvertimeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewRegistrationOvertimeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByRequestedBy",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_APPROVEDBY = new FinderPath(LmisViewRegistrationOvertimeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewRegistrationOvertimeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByApprovedBy",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_APPROVEDBY = new FinderPath(LmisViewRegistrationOvertimeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewRegistrationOvertimeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByApprovedBy",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_APPROVEDBY = new FinderPath(LmisViewRegistrationOvertimeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewRegistrationOvertimeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByApprovedBy",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(LmisViewRegistrationOvertimeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewRegistrationOvertimeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LmisViewRegistrationOvertimeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewRegistrationOvertimeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(
		LmisViewRegistrationOvertime lmisViewRegistrationOvertime) {
		EntityCacheUtil.putResult(LmisViewRegistrationOvertimeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewRegistrationOvertimeImpl.class,
			lmisViewRegistrationOvertime.getPrimaryKey(),
			lmisViewRegistrationOvertime);
	}

	public void cacheResult(
		List<LmisViewRegistrationOvertime> lmisViewRegistrationOvertimes) {
		for (LmisViewRegistrationOvertime lmisViewRegistrationOvertime : lmisViewRegistrationOvertimes) {
			if (EntityCacheUtil.getResult(
						LmisViewRegistrationOvertimeModelImpl.ENTITY_CACHE_ENABLED,
						LmisViewRegistrationOvertimeImpl.class,
						lmisViewRegistrationOvertime.getPrimaryKey(), this) == null) {
				cacheResult(lmisViewRegistrationOvertime);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(LmisViewRegistrationOvertimeImpl.class.getName());
		EntityCacheUtil.clearCache(LmisViewRegistrationOvertimeImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public LmisViewRegistrationOvertime create(
		Integer lmisViewRegistrationOvertimeId) {
		LmisViewRegistrationOvertime lmisViewRegistrationOvertime = new LmisViewRegistrationOvertimeImpl();

		lmisViewRegistrationOvertime.setNew(true);
		lmisViewRegistrationOvertime.setPrimaryKey(lmisViewRegistrationOvertimeId);

		return lmisViewRegistrationOvertime;
	}

	public LmisViewRegistrationOvertime remove(
		Integer lmisViewRegistrationOvertimeId)
		throws NoSuchLmisViewRegistrationOvertimeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LmisViewRegistrationOvertime lmisViewRegistrationOvertime = (LmisViewRegistrationOvertime)session.get(LmisViewRegistrationOvertimeImpl.class,
					lmisViewRegistrationOvertimeId);

			if (lmisViewRegistrationOvertime == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No LmisViewRegistrationOvertime exists with the primary key " +
						lmisViewRegistrationOvertimeId);
				}

				throw new NoSuchLmisViewRegistrationOvertimeException(
					"No LmisViewRegistrationOvertime exists with the primary key " +
					lmisViewRegistrationOvertimeId);
			}

			return remove(lmisViewRegistrationOvertime);
		}
		catch (NoSuchLmisViewRegistrationOvertimeException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public LmisViewRegistrationOvertime remove(
		LmisViewRegistrationOvertime lmisViewRegistrationOvertime)
		throws SystemException {
		for (ModelListener<LmisViewRegistrationOvertime> listener : listeners) {
			listener.onBeforeRemove(lmisViewRegistrationOvertime);
		}

		lmisViewRegistrationOvertime = removeImpl(lmisViewRegistrationOvertime);

		for (ModelListener<LmisViewRegistrationOvertime> listener : listeners) {
			listener.onAfterRemove(lmisViewRegistrationOvertime);
		}

		return lmisViewRegistrationOvertime;
	}

	protected LmisViewRegistrationOvertime removeImpl(
		LmisViewRegistrationOvertime lmisViewRegistrationOvertime)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (lmisViewRegistrationOvertime.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(LmisViewRegistrationOvertimeImpl.class,
						lmisViewRegistrationOvertime.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(lmisViewRegistrationOvertime);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(LmisViewRegistrationOvertimeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewRegistrationOvertimeImpl.class,
			lmisViewRegistrationOvertime.getPrimaryKey());

		return lmisViewRegistrationOvertime;
	}

	public LmisViewRegistrationOvertime update(
		LmisViewRegistrationOvertime lmisViewRegistrationOvertime)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(LmisViewRegistrationOvertime lmisViewRegistrationOvertime) method. Use update(LmisViewRegistrationOvertime lmisViewRegistrationOvertime, boolean merge) instead.");
		}

		return update(lmisViewRegistrationOvertime, false);
	}

	public LmisViewRegistrationOvertime update(
		LmisViewRegistrationOvertime lmisViewRegistrationOvertime, boolean merge)
		throws SystemException {
		boolean isNew = lmisViewRegistrationOvertime.isNew();

		for (ModelListener<LmisViewRegistrationOvertime> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(lmisViewRegistrationOvertime);
			}
			else {
				listener.onBeforeUpdate(lmisViewRegistrationOvertime);
			}
		}

		lmisViewRegistrationOvertime = updateImpl(lmisViewRegistrationOvertime,
				merge);

		for (ModelListener<LmisViewRegistrationOvertime> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(lmisViewRegistrationOvertime);
			}
			else {
				listener.onAfterUpdate(lmisViewRegistrationOvertime);
			}
		}

		return lmisViewRegistrationOvertime;
	}

	public LmisViewRegistrationOvertime updateImpl(
		larion.progate.lmis.model.LmisViewRegistrationOvertime lmisViewRegistrationOvertime,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, lmisViewRegistrationOvertime, merge);

			lmisViewRegistrationOvertime.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(LmisViewRegistrationOvertimeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewRegistrationOvertimeImpl.class,
			lmisViewRegistrationOvertime.getPrimaryKey(),
			lmisViewRegistrationOvertime);

		return lmisViewRegistrationOvertime;
	}

	public LmisViewRegistrationOvertime findByPrimaryKey(
		Integer lmisViewRegistrationOvertimeId)
		throws NoSuchLmisViewRegistrationOvertimeException, SystemException {
		LmisViewRegistrationOvertime lmisViewRegistrationOvertime = fetchByPrimaryKey(lmisViewRegistrationOvertimeId);

		if (lmisViewRegistrationOvertime == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"No LmisViewRegistrationOvertime exists with the primary key " +
					lmisViewRegistrationOvertimeId);
			}

			throw new NoSuchLmisViewRegistrationOvertimeException(
				"No LmisViewRegistrationOvertime exists with the primary key " +
				lmisViewRegistrationOvertimeId);
		}

		return lmisViewRegistrationOvertime;
	}

	public LmisViewRegistrationOvertime fetchByPrimaryKey(
		Integer lmisViewRegistrationOvertimeId) throws SystemException {
		LmisViewRegistrationOvertime lmisViewRegistrationOvertime = (LmisViewRegistrationOvertime)EntityCacheUtil.getResult(LmisViewRegistrationOvertimeModelImpl.ENTITY_CACHE_ENABLED,
				LmisViewRegistrationOvertimeImpl.class,
				lmisViewRegistrationOvertimeId, this);

		if (lmisViewRegistrationOvertime == null) {
			Session session = null;

			try {
				session = openSession();

				lmisViewRegistrationOvertime = (LmisViewRegistrationOvertime)session.get(LmisViewRegistrationOvertimeImpl.class,
						lmisViewRegistrationOvertimeId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (lmisViewRegistrationOvertime != null) {
					cacheResult(lmisViewRegistrationOvertime);
				}

				closeSession(session);
			}
		}

		return lmisViewRegistrationOvertime;
	}

	public List<LmisViewRegistrationOvertime> findByRootID(int rootId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		List<LmisViewRegistrationOvertime> list = (List<LmisViewRegistrationOvertime>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewRegistrationOvertime WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("requested_status ASC");

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
					list = new ArrayList<LmisViewRegistrationOvertime>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewRegistrationOvertime> findByRootID(int rootId,
		int start, int end) throws SystemException {
		return findByRootID(rootId, start, end, null);
	}

	public List<LmisViewRegistrationOvertime> findByRootID(int rootId,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(rootId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewRegistrationOvertime> list = (List<LmisViewRegistrationOvertime>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewRegistrationOvertime WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("requested_status ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rootId);

				list = (List<LmisViewRegistrationOvertime>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewRegistrationOvertime>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewRegistrationOvertime findByRootID_First(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisViewRegistrationOvertimeException, SystemException {
		List<LmisViewRegistrationOvertime> list = findByRootID(rootId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewRegistrationOvertime exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewRegistrationOvertimeException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewRegistrationOvertime findByRootID_Last(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisViewRegistrationOvertimeException, SystemException {
		int count = countByRootID(rootId);

		List<LmisViewRegistrationOvertime> list = findByRootID(rootId,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewRegistrationOvertime exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewRegistrationOvertimeException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewRegistrationOvertime[] findByRootID_PrevAndNext(
		Integer lmisViewRegistrationOvertimeId, int rootId,
		OrderByComparator obc)
		throws NoSuchLmisViewRegistrationOvertimeException, SystemException {
		LmisViewRegistrationOvertime lmisViewRegistrationOvertime = findByPrimaryKey(lmisViewRegistrationOvertimeId);

		int count = countByRootID(rootId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewRegistrationOvertime WHERE ");

			query.append("root_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("requested_status ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(rootId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisViewRegistrationOvertime);

			LmisViewRegistrationOvertime[] array = new LmisViewRegistrationOvertimeImpl[3];

			array[0] = (LmisViewRegistrationOvertime)objArray[0];
			array[1] = (LmisViewRegistrationOvertime)objArray[1];
			array[2] = (LmisViewRegistrationOvertime)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewRegistrationOvertime> findByRequestID(int requestId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(requestId) };

		List<LmisViewRegistrationOvertime> list = (List<LmisViewRegistrationOvertime>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_REQUESTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewRegistrationOvertime WHERE ");

				query.append("request_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("requested_status ASC");

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
					list = new ArrayList<LmisViewRegistrationOvertime>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_REQUESTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewRegistrationOvertime> findByRequestID(int requestId,
		int start, int end) throws SystemException {
		return findByRequestID(requestId, start, end, null);
	}

	public List<LmisViewRegistrationOvertime> findByRequestID(int requestId,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(requestId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewRegistrationOvertime> list = (List<LmisViewRegistrationOvertime>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_REQUESTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewRegistrationOvertime WHERE ");

				query.append("request_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("requested_status ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(requestId);

				list = (List<LmisViewRegistrationOvertime>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewRegistrationOvertime>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_REQUESTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewRegistrationOvertime findByRequestID_First(int requestId,
		OrderByComparator obc)
		throws NoSuchLmisViewRegistrationOvertimeException, SystemException {
		List<LmisViewRegistrationOvertime> list = findByRequestID(requestId, 0,
				1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewRegistrationOvertime exists with the key {");

			msg.append("requestId=" + requestId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewRegistrationOvertimeException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewRegistrationOvertime findByRequestID_Last(int requestId,
		OrderByComparator obc)
		throws NoSuchLmisViewRegistrationOvertimeException, SystemException {
		int count = countByRequestID(requestId);

		List<LmisViewRegistrationOvertime> list = findByRequestID(requestId,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewRegistrationOvertime exists with the key {");

			msg.append("requestId=" + requestId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewRegistrationOvertimeException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewRegistrationOvertime[] findByRequestID_PrevAndNext(
		Integer lmisViewRegistrationOvertimeId, int requestId,
		OrderByComparator obc)
		throws NoSuchLmisViewRegistrationOvertimeException, SystemException {
		LmisViewRegistrationOvertime lmisViewRegistrationOvertime = findByPrimaryKey(lmisViewRegistrationOvertimeId);

		int count = countByRequestID(requestId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewRegistrationOvertime WHERE ");

			query.append("request_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("requested_status ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(requestId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisViewRegistrationOvertime);

			LmisViewRegistrationOvertime[] array = new LmisViewRegistrationOvertimeImpl[3];

			array[0] = (LmisViewRegistrationOvertime)objArray[0];
			array[1] = (LmisViewRegistrationOvertime)objArray[1];
			array[2] = (LmisViewRegistrationOvertime)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewRegistrationOvertime> findByOrgID(int orgId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(orgId) };

		List<LmisViewRegistrationOvertime> list = (List<LmisViewRegistrationOvertime>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ORGID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewRegistrationOvertime WHERE ");

				query.append("org_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("requested_status ASC");

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
					list = new ArrayList<LmisViewRegistrationOvertime>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ORGID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewRegistrationOvertime> findByOrgID(int orgId, int start,
		int end) throws SystemException {
		return findByOrgID(orgId, start, end, null);
	}

	public List<LmisViewRegistrationOvertime> findByOrgID(int orgId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(orgId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewRegistrationOvertime> list = (List<LmisViewRegistrationOvertime>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ORGID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewRegistrationOvertime WHERE ");

				query.append("org_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("requested_status ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orgId);

				list = (List<LmisViewRegistrationOvertime>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewRegistrationOvertime>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ORGID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewRegistrationOvertime findByOrgID_First(int orgId,
		OrderByComparator obc)
		throws NoSuchLmisViewRegistrationOvertimeException, SystemException {
		List<LmisViewRegistrationOvertime> list = findByOrgID(orgId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewRegistrationOvertime exists with the key {");

			msg.append("orgId=" + orgId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewRegistrationOvertimeException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewRegistrationOvertime findByOrgID_Last(int orgId,
		OrderByComparator obc)
		throws NoSuchLmisViewRegistrationOvertimeException, SystemException {
		int count = countByOrgID(orgId);

		List<LmisViewRegistrationOvertime> list = findByOrgID(orgId, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewRegistrationOvertime exists with the key {");

			msg.append("orgId=" + orgId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewRegistrationOvertimeException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewRegistrationOvertime[] findByOrgID_PrevAndNext(
		Integer lmisViewRegistrationOvertimeId, int orgId, OrderByComparator obc)
		throws NoSuchLmisViewRegistrationOvertimeException, SystemException {
		LmisViewRegistrationOvertime lmisViewRegistrationOvertime = findByPrimaryKey(lmisViewRegistrationOvertimeId);

		int count = countByOrgID(orgId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewRegistrationOvertime WHERE ");

			query.append("org_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("requested_status ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(orgId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisViewRegistrationOvertime);

			LmisViewRegistrationOvertime[] array = new LmisViewRegistrationOvertimeImpl[3];

			array[0] = (LmisViewRegistrationOvertime)objArray[0];
			array[1] = (LmisViewRegistrationOvertime)objArray[1];
			array[2] = (LmisViewRegistrationOvertime)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewRegistrationOvertime> findByRequestedAt(
		Date requestedAt) throws SystemException {
		Object[] finderArgs = new Object[] { requestedAt };

		List<LmisViewRegistrationOvertime> list = (List<LmisViewRegistrationOvertime>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_REQUESTEDAT,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewRegistrationOvertime WHERE ");

				if (requestedAt == null) {
					query.append("requested_at IS NULL");
				}
				else {
					query.append("requested_at = ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("requested_status ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (requestedAt != null) {
					qPos.add(CalendarUtil.getTimestamp(requestedAt));
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewRegistrationOvertime>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_REQUESTEDAT,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewRegistrationOvertime> findByRequestedAt(
		Date requestedAt, int start, int end) throws SystemException {
		return findByRequestedAt(requestedAt, start, end, null);
	}

	public List<LmisViewRegistrationOvertime> findByRequestedAt(
		Date requestedAt, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				requestedAt,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewRegistrationOvertime> list = (List<LmisViewRegistrationOvertime>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_REQUESTEDAT,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewRegistrationOvertime WHERE ");

				if (requestedAt == null) {
					query.append("requested_at IS NULL");
				}
				else {
					query.append("requested_at = ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("requested_status ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (requestedAt != null) {
					qPos.add(CalendarUtil.getTimestamp(requestedAt));
				}

				list = (List<LmisViewRegistrationOvertime>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewRegistrationOvertime>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_REQUESTEDAT,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewRegistrationOvertime findByRequestedAt_First(
		Date requestedAt, OrderByComparator obc)
		throws NoSuchLmisViewRegistrationOvertimeException, SystemException {
		List<LmisViewRegistrationOvertime> list = findByRequestedAt(requestedAt,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewRegistrationOvertime exists with the key {");

			msg.append("requestedAt=" + requestedAt);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewRegistrationOvertimeException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewRegistrationOvertime findByRequestedAt_Last(
		Date requestedAt, OrderByComparator obc)
		throws NoSuchLmisViewRegistrationOvertimeException, SystemException {
		int count = countByRequestedAt(requestedAt);

		List<LmisViewRegistrationOvertime> list = findByRequestedAt(requestedAt,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewRegistrationOvertime exists with the key {");

			msg.append("requestedAt=" + requestedAt);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewRegistrationOvertimeException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewRegistrationOvertime[] findByRequestedAt_PrevAndNext(
		Integer lmisViewRegistrationOvertimeId, Date requestedAt,
		OrderByComparator obc)
		throws NoSuchLmisViewRegistrationOvertimeException, SystemException {
		LmisViewRegistrationOvertime lmisViewRegistrationOvertime = findByPrimaryKey(lmisViewRegistrationOvertimeId);

		int count = countByRequestedAt(requestedAt);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewRegistrationOvertime WHERE ");

			if (requestedAt == null) {
				query.append("requested_at IS NULL");
			}
			else {
				query.append("requested_at = ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("requested_status ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (requestedAt != null) {
				qPos.add(CalendarUtil.getTimestamp(requestedAt));
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisViewRegistrationOvertime);

			LmisViewRegistrationOvertime[] array = new LmisViewRegistrationOvertimeImpl[3];

			array[0] = (LmisViewRegistrationOvertime)objArray[0];
			array[1] = (LmisViewRegistrationOvertime)objArray[1];
			array[2] = (LmisViewRegistrationOvertime)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewRegistrationOvertime> findByRequestedStatus(
		int requestedStatus) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(requestedStatus) };

		List<LmisViewRegistrationOvertime> list = (List<LmisViewRegistrationOvertime>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_REQUESTEDSTATUS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewRegistrationOvertime WHERE ");

				query.append("requested_status = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("requested_status ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(requestedStatus);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewRegistrationOvertime>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_REQUESTEDSTATUS,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewRegistrationOvertime> findByRequestedStatus(
		int requestedStatus, int start, int end) throws SystemException {
		return findByRequestedStatus(requestedStatus, start, end, null);
	}

	public List<LmisViewRegistrationOvertime> findByRequestedStatus(
		int requestedStatus, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(requestedStatus),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewRegistrationOvertime> list = (List<LmisViewRegistrationOvertime>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_REQUESTEDSTATUS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewRegistrationOvertime WHERE ");

				query.append("requested_status = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("requested_status ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(requestedStatus);

				list = (List<LmisViewRegistrationOvertime>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewRegistrationOvertime>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_REQUESTEDSTATUS,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewRegistrationOvertime findByRequestedStatus_First(
		int requestedStatus, OrderByComparator obc)
		throws NoSuchLmisViewRegistrationOvertimeException, SystemException {
		List<LmisViewRegistrationOvertime> list = findByRequestedStatus(requestedStatus,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewRegistrationOvertime exists with the key {");

			msg.append("requestedStatus=" + requestedStatus);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewRegistrationOvertimeException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewRegistrationOvertime findByRequestedStatus_Last(
		int requestedStatus, OrderByComparator obc)
		throws NoSuchLmisViewRegistrationOvertimeException, SystemException {
		int count = countByRequestedStatus(requestedStatus);

		List<LmisViewRegistrationOvertime> list = findByRequestedStatus(requestedStatus,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewRegistrationOvertime exists with the key {");

			msg.append("requestedStatus=" + requestedStatus);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewRegistrationOvertimeException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewRegistrationOvertime[] findByRequestedStatus_PrevAndNext(
		Integer lmisViewRegistrationOvertimeId, int requestedStatus,
		OrderByComparator obc)
		throws NoSuchLmisViewRegistrationOvertimeException, SystemException {
		LmisViewRegistrationOvertime lmisViewRegistrationOvertime = findByPrimaryKey(lmisViewRegistrationOvertimeId);

		int count = countByRequestedStatus(requestedStatus);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewRegistrationOvertime WHERE ");

			query.append("requested_status = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("requested_status ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(requestedStatus);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisViewRegistrationOvertime);

			LmisViewRegistrationOvertime[] array = new LmisViewRegistrationOvertimeImpl[3];

			array[0] = (LmisViewRegistrationOvertime)objArray[0];
			array[1] = (LmisViewRegistrationOvertime)objArray[1];
			array[2] = (LmisViewRegistrationOvertime)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewRegistrationOvertime> findByuserID(int userId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(userId) };

		List<LmisViewRegistrationOvertime> list = (List<LmisViewRegistrationOvertime>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_USERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewRegistrationOvertime WHERE ");

				query.append("user_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("requested_status ASC");

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
					list = new ArrayList<LmisViewRegistrationOvertime>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_USERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewRegistrationOvertime> findByuserID(int userId,
		int start, int end) throws SystemException {
		return findByuserID(userId, start, end, null);
	}

	public List<LmisViewRegistrationOvertime> findByuserID(int userId,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(userId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewRegistrationOvertime> list = (List<LmisViewRegistrationOvertime>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_USERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewRegistrationOvertime WHERE ");

				query.append("user_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("requested_status ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				list = (List<LmisViewRegistrationOvertime>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewRegistrationOvertime>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_USERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewRegistrationOvertime findByuserID_First(int userId,
		OrderByComparator obc)
		throws NoSuchLmisViewRegistrationOvertimeException, SystemException {
		List<LmisViewRegistrationOvertime> list = findByuserID(userId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewRegistrationOvertime exists with the key {");

			msg.append("userId=" + userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewRegistrationOvertimeException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewRegistrationOvertime findByuserID_Last(int userId,
		OrderByComparator obc)
		throws NoSuchLmisViewRegistrationOvertimeException, SystemException {
		int count = countByuserID(userId);

		List<LmisViewRegistrationOvertime> list = findByuserID(userId,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewRegistrationOvertime exists with the key {");

			msg.append("userId=" + userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewRegistrationOvertimeException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewRegistrationOvertime[] findByuserID_PrevAndNext(
		Integer lmisViewRegistrationOvertimeId, int userId,
		OrderByComparator obc)
		throws NoSuchLmisViewRegistrationOvertimeException, SystemException {
		LmisViewRegistrationOvertime lmisViewRegistrationOvertime = findByPrimaryKey(lmisViewRegistrationOvertimeId);

		int count = countByuserID(userId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewRegistrationOvertime WHERE ");

			query.append("user_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("requested_status ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(userId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisViewRegistrationOvertime);

			LmisViewRegistrationOvertime[] array = new LmisViewRegistrationOvertimeImpl[3];

			array[0] = (LmisViewRegistrationOvertime)objArray[0];
			array[1] = (LmisViewRegistrationOvertime)objArray[1];
			array[2] = (LmisViewRegistrationOvertime)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewRegistrationOvertime> findByRequestedBy(int requestedBy)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(requestedBy) };

		List<LmisViewRegistrationOvertime> list = (List<LmisViewRegistrationOvertime>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_REQUESTEDBY,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewRegistrationOvertime WHERE ");

				query.append("requested_by = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("requested_status ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(requestedBy);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewRegistrationOvertime>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_REQUESTEDBY,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewRegistrationOvertime> findByRequestedBy(
		int requestedBy, int start, int end) throws SystemException {
		return findByRequestedBy(requestedBy, start, end, null);
	}

	public List<LmisViewRegistrationOvertime> findByRequestedBy(
		int requestedBy, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(requestedBy),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewRegistrationOvertime> list = (List<LmisViewRegistrationOvertime>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_REQUESTEDBY,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewRegistrationOvertime WHERE ");

				query.append("requested_by = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("requested_status ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(requestedBy);

				list = (List<LmisViewRegistrationOvertime>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewRegistrationOvertime>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_REQUESTEDBY,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewRegistrationOvertime findByRequestedBy_First(
		int requestedBy, OrderByComparator obc)
		throws NoSuchLmisViewRegistrationOvertimeException, SystemException {
		List<LmisViewRegistrationOvertime> list = findByRequestedBy(requestedBy,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewRegistrationOvertime exists with the key {");

			msg.append("requestedBy=" + requestedBy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewRegistrationOvertimeException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewRegistrationOvertime findByRequestedBy_Last(
		int requestedBy, OrderByComparator obc)
		throws NoSuchLmisViewRegistrationOvertimeException, SystemException {
		int count = countByRequestedBy(requestedBy);

		List<LmisViewRegistrationOvertime> list = findByRequestedBy(requestedBy,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewRegistrationOvertime exists with the key {");

			msg.append("requestedBy=" + requestedBy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewRegistrationOvertimeException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewRegistrationOvertime[] findByRequestedBy_PrevAndNext(
		Integer lmisViewRegistrationOvertimeId, int requestedBy,
		OrderByComparator obc)
		throws NoSuchLmisViewRegistrationOvertimeException, SystemException {
		LmisViewRegistrationOvertime lmisViewRegistrationOvertime = findByPrimaryKey(lmisViewRegistrationOvertimeId);

		int count = countByRequestedBy(requestedBy);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewRegistrationOvertime WHERE ");

			query.append("requested_by = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("requested_status ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(requestedBy);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisViewRegistrationOvertime);

			LmisViewRegistrationOvertime[] array = new LmisViewRegistrationOvertimeImpl[3];

			array[0] = (LmisViewRegistrationOvertime)objArray[0];
			array[1] = (LmisViewRegistrationOvertime)objArray[1];
			array[2] = (LmisViewRegistrationOvertime)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewRegistrationOvertime> findByApprovedBy(int approvedBy)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(approvedBy) };

		List<LmisViewRegistrationOvertime> list = (List<LmisViewRegistrationOvertime>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_APPROVEDBY,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewRegistrationOvertime WHERE ");

				query.append("approved_by = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("requested_status ASC");

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
					list = new ArrayList<LmisViewRegistrationOvertime>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_APPROVEDBY,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewRegistrationOvertime> findByApprovedBy(int approvedBy,
		int start, int end) throws SystemException {
		return findByApprovedBy(approvedBy, start, end, null);
	}

	public List<LmisViewRegistrationOvertime> findByApprovedBy(int approvedBy,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(approvedBy),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewRegistrationOvertime> list = (List<LmisViewRegistrationOvertime>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_APPROVEDBY,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewRegistrationOvertime WHERE ");

				query.append("approved_by = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("requested_status ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(approvedBy);

				list = (List<LmisViewRegistrationOvertime>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewRegistrationOvertime>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_APPROVEDBY,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewRegistrationOvertime findByApprovedBy_First(int approvedBy,
		OrderByComparator obc)
		throws NoSuchLmisViewRegistrationOvertimeException, SystemException {
		List<LmisViewRegistrationOvertime> list = findByApprovedBy(approvedBy,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewRegistrationOvertime exists with the key {");

			msg.append("approvedBy=" + approvedBy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewRegistrationOvertimeException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewRegistrationOvertime findByApprovedBy_Last(int approvedBy,
		OrderByComparator obc)
		throws NoSuchLmisViewRegistrationOvertimeException, SystemException {
		int count = countByApprovedBy(approvedBy);

		List<LmisViewRegistrationOvertime> list = findByApprovedBy(approvedBy,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewRegistrationOvertime exists with the key {");

			msg.append("approvedBy=" + approvedBy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewRegistrationOvertimeException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewRegistrationOvertime[] findByApprovedBy_PrevAndNext(
		Integer lmisViewRegistrationOvertimeId, int approvedBy,
		OrderByComparator obc)
		throws NoSuchLmisViewRegistrationOvertimeException, SystemException {
		LmisViewRegistrationOvertime lmisViewRegistrationOvertime = findByPrimaryKey(lmisViewRegistrationOvertimeId);

		int count = countByApprovedBy(approvedBy);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewRegistrationOvertime WHERE ");

			query.append("approved_by = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("requested_status ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(approvedBy);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisViewRegistrationOvertime);

			LmisViewRegistrationOvertime[] array = new LmisViewRegistrationOvertimeImpl[3];

			array[0] = (LmisViewRegistrationOvertime)objArray[0];
			array[1] = (LmisViewRegistrationOvertime)objArray[1];
			array[2] = (LmisViewRegistrationOvertime)objArray[2];

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

	public List<LmisViewRegistrationOvertime> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<LmisViewRegistrationOvertime> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<LmisViewRegistrationOvertime> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewRegistrationOvertime> list = (List<LmisViewRegistrationOvertime>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewRegistrationOvertime ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("requested_status ASC");
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<LmisViewRegistrationOvertime>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LmisViewRegistrationOvertime>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewRegistrationOvertime>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByRootID(int rootId) throws SystemException {
		for (LmisViewRegistrationOvertime lmisViewRegistrationOvertime : findByRootID(
				rootId)) {
			remove(lmisViewRegistrationOvertime);
		}
	}

	public void removeByRequestID(int requestId) throws SystemException {
		for (LmisViewRegistrationOvertime lmisViewRegistrationOvertime : findByRequestID(
				requestId)) {
			remove(lmisViewRegistrationOvertime);
		}
	}

	public void removeByOrgID(int orgId) throws SystemException {
		for (LmisViewRegistrationOvertime lmisViewRegistrationOvertime : findByOrgID(
				orgId)) {
			remove(lmisViewRegistrationOvertime);
		}
	}

	public void removeByRequestedAt(Date requestedAt) throws SystemException {
		for (LmisViewRegistrationOvertime lmisViewRegistrationOvertime : findByRequestedAt(
				requestedAt)) {
			remove(lmisViewRegistrationOvertime);
		}
	}

	public void removeByRequestedStatus(int requestedStatus)
		throws SystemException {
		for (LmisViewRegistrationOvertime lmisViewRegistrationOvertime : findByRequestedStatus(
				requestedStatus)) {
			remove(lmisViewRegistrationOvertime);
		}
	}

	public void removeByuserID(int userId) throws SystemException {
		for (LmisViewRegistrationOvertime lmisViewRegistrationOvertime : findByuserID(
				userId)) {
			remove(lmisViewRegistrationOvertime);
		}
	}

	public void removeByRequestedBy(int requestedBy) throws SystemException {
		for (LmisViewRegistrationOvertime lmisViewRegistrationOvertime : findByRequestedBy(
				requestedBy)) {
			remove(lmisViewRegistrationOvertime);
		}
	}

	public void removeByApprovedBy(int approvedBy) throws SystemException {
		for (LmisViewRegistrationOvertime lmisViewRegistrationOvertime : findByApprovedBy(
				approvedBy)) {
			remove(lmisViewRegistrationOvertime);
		}
	}

	public void removeAll() throws SystemException {
		for (LmisViewRegistrationOvertime lmisViewRegistrationOvertime : findAll()) {
			remove(lmisViewRegistrationOvertime);
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
					"FROM larion.progate.lmis.model.LmisViewRegistrationOvertime WHERE ");

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
					"FROM larion.progate.lmis.model.LmisViewRegistrationOvertime WHERE ");

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
					"FROM larion.progate.lmis.model.LmisViewRegistrationOvertime WHERE ");

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

	public int countByRequestedAt(Date requestedAt) throws SystemException {
		Object[] finderArgs = new Object[] { requestedAt };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_REQUESTEDAT,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisViewRegistrationOvertime WHERE ");

				if (requestedAt == null) {
					query.append("requested_at IS NULL");
				}
				else {
					query.append("requested_at = ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (requestedAt != null) {
					qPos.add(CalendarUtil.getTimestamp(requestedAt));
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_REQUESTEDAT,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByRequestedStatus(int requestedStatus)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(requestedStatus) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_REQUESTEDSTATUS,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisViewRegistrationOvertime WHERE ");

				query.append("requested_status = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(requestedStatus);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_REQUESTEDSTATUS,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByuserID(int userId) throws SystemException {
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
					"FROM larion.progate.lmis.model.LmisViewRegistrationOvertime WHERE ");

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

	public int countByRequestedBy(int requestedBy) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(requestedBy) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_REQUESTEDBY,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisViewRegistrationOvertime WHERE ");

				query.append("requested_by = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(requestedBy);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_REQUESTEDBY,
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
					"FROM larion.progate.lmis.model.LmisViewRegistrationOvertime WHERE ");

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
						"SELECT COUNT(*) FROM larion.progate.lmis.model.LmisViewRegistrationOvertime");

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
						"value.object.listener.larion.progate.lmis.model.LmisViewRegistrationOvertime")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LmisViewRegistrationOvertime>> listenersList = new ArrayList<ModelListener<LmisViewRegistrationOvertime>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LmisViewRegistrationOvertime>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(LmisViewRegistrationOvertimePersistenceImpl.class);
}