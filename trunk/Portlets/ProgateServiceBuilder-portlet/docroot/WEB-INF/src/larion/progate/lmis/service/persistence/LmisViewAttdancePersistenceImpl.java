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

import larion.progate.lmis.NoSuchLmisViewAttdanceException;
import larion.progate.lmis.model.LmisViewAttdance;
import larion.progate.lmis.model.impl.LmisViewAttdanceImpl;
import larion.progate.lmis.model.impl.LmisViewAttdanceModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * <a href="LmisViewAttdancePersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewAttdancePersistenceImpl extends BasePersistenceImpl
	implements LmisViewAttdancePersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = LmisViewAttdanceImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_ROOTID = new FinderPath(LmisViewAttdanceModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewAttdanceModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ROOTID = new FinderPath(LmisViewAttdanceModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewAttdanceModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ROOTID = new FinderPath(LmisViewAttdanceModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewAttdanceModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByRootId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_USERID = new FinderPath(LmisViewAttdanceModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewAttdanceModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByUserId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_USERID = new FinderPath(LmisViewAttdanceModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewAttdanceModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByUserId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(LmisViewAttdanceModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewAttdanceModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByUserId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_DAYVALUE = new FinderPath(LmisViewAttdanceModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewAttdanceModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByDayValue",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_DAYVALUE = new FinderPath(LmisViewAttdanceModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewAttdanceModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByDayValue",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_DAYVALUE = new FinderPath(LmisViewAttdanceModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewAttdanceModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByDayValue",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_FULLNAME = new FinderPath(LmisViewAttdanceModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewAttdanceModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByFullName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_FULLNAME = new FinderPath(LmisViewAttdanceModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewAttdanceModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByFullName",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_FULLNAME = new FinderPath(LmisViewAttdanceModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewAttdanceModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByFullName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(LmisViewAttdanceModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewAttdanceModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LmisViewAttdanceModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewAttdanceModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(LmisViewAttdance lmisViewAttdance) {
		EntityCacheUtil.putResult(LmisViewAttdanceModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewAttdanceImpl.class, lmisViewAttdance.getPrimaryKey(),
			lmisViewAttdance);
	}

	public void cacheResult(List<LmisViewAttdance> lmisViewAttdances) {
		for (LmisViewAttdance lmisViewAttdance : lmisViewAttdances) {
			if (EntityCacheUtil.getResult(
						LmisViewAttdanceModelImpl.ENTITY_CACHE_ENABLED,
						LmisViewAttdanceImpl.class,
						lmisViewAttdance.getPrimaryKey(), this) == null) {
				cacheResult(lmisViewAttdance);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(LmisViewAttdanceImpl.class.getName());
		EntityCacheUtil.clearCache(LmisViewAttdanceImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public LmisViewAttdance create(Integer lmisViewAttDailyId) {
		LmisViewAttdance lmisViewAttdance = new LmisViewAttdanceImpl();

		lmisViewAttdance.setNew(true);
		lmisViewAttdance.setPrimaryKey(lmisViewAttDailyId);

		return lmisViewAttdance;
	}

	public LmisViewAttdance remove(Integer lmisViewAttDailyId)
		throws NoSuchLmisViewAttdanceException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LmisViewAttdance lmisViewAttdance = (LmisViewAttdance)session.get(LmisViewAttdanceImpl.class,
					lmisViewAttDailyId);

			if (lmisViewAttdance == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No LmisViewAttdance exists with the primary key " +
						lmisViewAttDailyId);
				}

				throw new NoSuchLmisViewAttdanceException(
					"No LmisViewAttdance exists with the primary key " +
					lmisViewAttDailyId);
			}

			return remove(lmisViewAttdance);
		}
		catch (NoSuchLmisViewAttdanceException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public LmisViewAttdance remove(LmisViewAttdance lmisViewAttdance)
		throws SystemException {
		for (ModelListener<LmisViewAttdance> listener : listeners) {
			listener.onBeforeRemove(lmisViewAttdance);
		}

		lmisViewAttdance = removeImpl(lmisViewAttdance);

		for (ModelListener<LmisViewAttdance> listener : listeners) {
			listener.onAfterRemove(lmisViewAttdance);
		}

		return lmisViewAttdance;
	}

	protected LmisViewAttdance removeImpl(LmisViewAttdance lmisViewAttdance)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (lmisViewAttdance.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(LmisViewAttdanceImpl.class,
						lmisViewAttdance.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(lmisViewAttdance);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(LmisViewAttdanceModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewAttdanceImpl.class, lmisViewAttdance.getPrimaryKey());

		return lmisViewAttdance;
	}

	public LmisViewAttdance update(LmisViewAttdance lmisViewAttdance)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(LmisViewAttdance lmisViewAttdance) method. Use update(LmisViewAttdance lmisViewAttdance, boolean merge) instead.");
		}

		return update(lmisViewAttdance, false);
	}

	public LmisViewAttdance update(LmisViewAttdance lmisViewAttdance,
		boolean merge) throws SystemException {
		boolean isNew = lmisViewAttdance.isNew();

		for (ModelListener<LmisViewAttdance> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(lmisViewAttdance);
			}
			else {
				listener.onBeforeUpdate(lmisViewAttdance);
			}
		}

		lmisViewAttdance = updateImpl(lmisViewAttdance, merge);

		for (ModelListener<LmisViewAttdance> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(lmisViewAttdance);
			}
			else {
				listener.onAfterUpdate(lmisViewAttdance);
			}
		}

		return lmisViewAttdance;
	}

	public LmisViewAttdance updateImpl(
		larion.progate.lmis.model.LmisViewAttdance lmisViewAttdance,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, lmisViewAttdance, merge);

			lmisViewAttdance.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(LmisViewAttdanceModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewAttdanceImpl.class, lmisViewAttdance.getPrimaryKey(),
			lmisViewAttdance);

		return lmisViewAttdance;
	}

	public LmisViewAttdance findByPrimaryKey(Integer lmisViewAttDailyId)
		throws NoSuchLmisViewAttdanceException, SystemException {
		LmisViewAttdance lmisViewAttdance = fetchByPrimaryKey(lmisViewAttDailyId);

		if (lmisViewAttdance == null) {
			if (_log.isWarnEnabled()) {
				_log.warn("No LmisViewAttdance exists with the primary key " +
					lmisViewAttDailyId);
			}

			throw new NoSuchLmisViewAttdanceException(
				"No LmisViewAttdance exists with the primary key " +
				lmisViewAttDailyId);
		}

		return lmisViewAttdance;
	}

	public LmisViewAttdance fetchByPrimaryKey(Integer lmisViewAttDailyId)
		throws SystemException {
		LmisViewAttdance lmisViewAttdance = (LmisViewAttdance)EntityCacheUtil.getResult(LmisViewAttdanceModelImpl.ENTITY_CACHE_ENABLED,
				LmisViewAttdanceImpl.class, lmisViewAttDailyId, this);

		if (lmisViewAttdance == null) {
			Session session = null;

			try {
				session = openSession();

				lmisViewAttdance = (LmisViewAttdance)session.get(LmisViewAttdanceImpl.class,
						lmisViewAttDailyId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (lmisViewAttdance != null) {
					cacheResult(lmisViewAttdance);
				}

				closeSession(session);
			}
		}

		return lmisViewAttdance;
	}

	public List<LmisViewAttdance> findByRootId(int rootId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		List<LmisViewAttdance> list = (List<LmisViewAttdance>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewAttdance WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("created_at DESC");

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
					list = new ArrayList<LmisViewAttdance>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewAttdance> findByRootId(int rootId, int start, int end)
		throws SystemException {
		return findByRootId(rootId, start, end, null);
	}

	public List<LmisViewAttdance> findByRootId(int rootId, int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(rootId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewAttdance> list = (List<LmisViewAttdance>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewAttdance WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("created_at DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rootId);

				list = (List<LmisViewAttdance>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewAttdance>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewAttdance findByRootId_First(int rootId, OrderByComparator obc)
		throws NoSuchLmisViewAttdanceException, SystemException {
		List<LmisViewAttdance> list = findByRootId(rootId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewAttdance exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewAttdanceException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewAttdance findByRootId_Last(int rootId, OrderByComparator obc)
		throws NoSuchLmisViewAttdanceException, SystemException {
		int count = countByRootId(rootId);

		List<LmisViewAttdance> list = findByRootId(rootId, count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewAttdance exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewAttdanceException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewAttdance[] findByRootId_PrevAndNext(
		Integer lmisViewAttDailyId, int rootId, OrderByComparator obc)
		throws NoSuchLmisViewAttdanceException, SystemException {
		LmisViewAttdance lmisViewAttdance = findByPrimaryKey(lmisViewAttDailyId);

		int count = countByRootId(rootId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewAttdance WHERE ");

			query.append("root_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("created_at DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(rootId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisViewAttdance);

			LmisViewAttdance[] array = new LmisViewAttdanceImpl[3];

			array[0] = (LmisViewAttdance)objArray[0];
			array[1] = (LmisViewAttdance)objArray[1];
			array[2] = (LmisViewAttdance)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewAttdance> findByUserId(int userId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(userId) };

		List<LmisViewAttdance> list = (List<LmisViewAttdance>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_USERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewAttdance WHERE ");

				query.append("user_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("created_at DESC");

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
					list = new ArrayList<LmisViewAttdance>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_USERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewAttdance> findByUserId(int userId, int start, int end)
		throws SystemException {
		return findByUserId(userId, start, end, null);
	}

	public List<LmisViewAttdance> findByUserId(int userId, int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(userId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewAttdance> list = (List<LmisViewAttdance>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_USERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewAttdance WHERE ");

				query.append("user_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("created_at DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				list = (List<LmisViewAttdance>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewAttdance>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_USERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewAttdance findByUserId_First(int userId, OrderByComparator obc)
		throws NoSuchLmisViewAttdanceException, SystemException {
		List<LmisViewAttdance> list = findByUserId(userId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewAttdance exists with the key {");

			msg.append("userId=" + userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewAttdanceException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewAttdance findByUserId_Last(int userId, OrderByComparator obc)
		throws NoSuchLmisViewAttdanceException, SystemException {
		int count = countByUserId(userId);

		List<LmisViewAttdance> list = findByUserId(userId, count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewAttdance exists with the key {");

			msg.append("userId=" + userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewAttdanceException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewAttdance[] findByUserId_PrevAndNext(
		Integer lmisViewAttDailyId, int userId, OrderByComparator obc)
		throws NoSuchLmisViewAttdanceException, SystemException {
		LmisViewAttdance lmisViewAttdance = findByPrimaryKey(lmisViewAttDailyId);

		int count = countByUserId(userId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewAttdance WHERE ");

			query.append("user_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("created_at DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(userId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisViewAttdance);

			LmisViewAttdance[] array = new LmisViewAttdanceImpl[3];

			array[0] = (LmisViewAttdance)objArray[0];
			array[1] = (LmisViewAttdance)objArray[1];
			array[2] = (LmisViewAttdance)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewAttdance> findByDayValue(Date dayValue)
		throws SystemException {
		Object[] finderArgs = new Object[] { dayValue };

		List<LmisViewAttdance> list = (List<LmisViewAttdance>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DAYVALUE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewAttdance WHERE ");

				if (dayValue == null) {
					query.append("day_value IS NULL");
				}
				else {
					query.append("day_value = ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("created_at DESC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (dayValue != null) {
					qPos.add(CalendarUtil.getTimestamp(dayValue));
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewAttdance>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DAYVALUE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewAttdance> findByDayValue(Date dayValue, int start,
		int end) throws SystemException {
		return findByDayValue(dayValue, start, end, null);
	}

	public List<LmisViewAttdance> findByDayValue(Date dayValue, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				dayValue,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewAttdance> list = (List<LmisViewAttdance>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_DAYVALUE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewAttdance WHERE ");

				if (dayValue == null) {
					query.append("day_value IS NULL");
				}
				else {
					query.append("day_value = ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("created_at DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (dayValue != null) {
					qPos.add(CalendarUtil.getTimestamp(dayValue));
				}

				list = (List<LmisViewAttdance>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewAttdance>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_DAYVALUE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewAttdance findByDayValue_First(Date dayValue,
		OrderByComparator obc)
		throws NoSuchLmisViewAttdanceException, SystemException {
		List<LmisViewAttdance> list = findByDayValue(dayValue, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewAttdance exists with the key {");

			msg.append("dayValue=" + dayValue);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewAttdanceException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewAttdance findByDayValue_Last(Date dayValue,
		OrderByComparator obc)
		throws NoSuchLmisViewAttdanceException, SystemException {
		int count = countByDayValue(dayValue);

		List<LmisViewAttdance> list = findByDayValue(dayValue, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewAttdance exists with the key {");

			msg.append("dayValue=" + dayValue);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewAttdanceException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewAttdance[] findByDayValue_PrevAndNext(
		Integer lmisViewAttDailyId, Date dayValue, OrderByComparator obc)
		throws NoSuchLmisViewAttdanceException, SystemException {
		LmisViewAttdance lmisViewAttdance = findByPrimaryKey(lmisViewAttDailyId);

		int count = countByDayValue(dayValue);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewAttdance WHERE ");

			if (dayValue == null) {
				query.append("day_value IS NULL");
			}
			else {
				query.append("day_value = ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("created_at DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (dayValue != null) {
				qPos.add(CalendarUtil.getTimestamp(dayValue));
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisViewAttdance);

			LmisViewAttdance[] array = new LmisViewAttdanceImpl[3];

			array[0] = (LmisViewAttdance)objArray[0];
			array[1] = (LmisViewAttdance)objArray[1];
			array[2] = (LmisViewAttdance)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewAttdance> findByFullName(String fullName)
		throws SystemException {
		Object[] finderArgs = new Object[] { fullName };

		List<LmisViewAttdance> list = (List<LmisViewAttdance>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_FULLNAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewAttdance WHERE ");

				if (fullName == null) {
					query.append("full_name LIKE null");
				}
				else {
					query.append("full_name LIKE ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("created_at DESC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (fullName != null) {
					qPos.add(fullName);
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewAttdance>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_FULLNAME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewAttdance> findByFullName(String fullName, int start,
		int end) throws SystemException {
		return findByFullName(fullName, start, end, null);
	}

	public List<LmisViewAttdance> findByFullName(String fullName, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				fullName,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewAttdance> list = (List<LmisViewAttdance>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_FULLNAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewAttdance WHERE ");

				if (fullName == null) {
					query.append("full_name LIKE null");
				}
				else {
					query.append("full_name LIKE ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("created_at DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (fullName != null) {
					qPos.add(fullName);
				}

				list = (List<LmisViewAttdance>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewAttdance>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_FULLNAME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewAttdance findByFullName_First(String fullName,
		OrderByComparator obc)
		throws NoSuchLmisViewAttdanceException, SystemException {
		List<LmisViewAttdance> list = findByFullName(fullName, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewAttdance exists with the key {");

			msg.append("fullName=" + fullName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewAttdanceException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewAttdance findByFullName_Last(String fullName,
		OrderByComparator obc)
		throws NoSuchLmisViewAttdanceException, SystemException {
		int count = countByFullName(fullName);

		List<LmisViewAttdance> list = findByFullName(fullName, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewAttdance exists with the key {");

			msg.append("fullName=" + fullName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewAttdanceException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewAttdance[] findByFullName_PrevAndNext(
		Integer lmisViewAttDailyId, String fullName, OrderByComparator obc)
		throws NoSuchLmisViewAttdanceException, SystemException {
		LmisViewAttdance lmisViewAttdance = findByPrimaryKey(lmisViewAttDailyId);

		int count = countByFullName(fullName);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewAttdance WHERE ");

			if (fullName == null) {
				query.append("full_name LIKE null");
			}
			else {
				query.append("full_name LIKE ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("created_at DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (fullName != null) {
				qPos.add(fullName);
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisViewAttdance);

			LmisViewAttdance[] array = new LmisViewAttdanceImpl[3];

			array[0] = (LmisViewAttdance)objArray[0];
			array[1] = (LmisViewAttdance)objArray[1];
			array[2] = (LmisViewAttdance)objArray[2];

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

	public List<LmisViewAttdance> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<LmisViewAttdance> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<LmisViewAttdance> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewAttdance> list = (List<LmisViewAttdance>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.lmis.model.LmisViewAttdance ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("created_at DESC");
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<LmisViewAttdance>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LmisViewAttdance>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewAttdance>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByRootId(int rootId) throws SystemException {
		for (LmisViewAttdance lmisViewAttdance : findByRootId(rootId)) {
			remove(lmisViewAttdance);
		}
	}

	public void removeByUserId(int userId) throws SystemException {
		for (LmisViewAttdance lmisViewAttdance : findByUserId(userId)) {
			remove(lmisViewAttdance);
		}
	}

	public void removeByDayValue(Date dayValue) throws SystemException {
		for (LmisViewAttdance lmisViewAttdance : findByDayValue(dayValue)) {
			remove(lmisViewAttdance);
		}
	}

	public void removeByFullName(String fullName) throws SystemException {
		for (LmisViewAttdance lmisViewAttdance : findByFullName(fullName)) {
			remove(lmisViewAttdance);
		}
	}

	public void removeAll() throws SystemException {
		for (LmisViewAttdance lmisViewAttdance : findAll()) {
			remove(lmisViewAttdance);
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
					"FROM larion.progate.lmis.model.LmisViewAttdance WHERE ");

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
					"FROM larion.progate.lmis.model.LmisViewAttdance WHERE ");

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

	public int countByDayValue(Date dayValue) throws SystemException {
		Object[] finderArgs = new Object[] { dayValue };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DAYVALUE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisViewAttdance WHERE ");

				if (dayValue == null) {
					query.append("day_value IS NULL");
				}
				else {
					query.append("day_value = ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (dayValue != null) {
					qPos.add(CalendarUtil.getTimestamp(dayValue));
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DAYVALUE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByFullName(String fullName) throws SystemException {
		Object[] finderArgs = new Object[] { fullName };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FULLNAME,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisViewAttdance WHERE ");

				if (fullName == null) {
					query.append("full_name LIKE null");
				}
				else {
					query.append("full_name LIKE ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (fullName != null) {
					qPos.add(fullName);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FULLNAME,
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
						"SELECT COUNT(*) FROM larion.progate.lmis.model.LmisViewAttdance");

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
						"value.object.listener.larion.progate.lmis.model.LmisViewAttdance")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LmisViewAttdance>> listenersList = new ArrayList<ModelListener<LmisViewAttdance>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LmisViewAttdance>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(LmisViewAttdancePersistenceImpl.class);
}