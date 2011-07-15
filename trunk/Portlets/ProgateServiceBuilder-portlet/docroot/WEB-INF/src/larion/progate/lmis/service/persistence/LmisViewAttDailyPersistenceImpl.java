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

import larion.progate.lmis.NoSuchLmisViewAttDailyException;
import larion.progate.lmis.model.LmisViewAttDaily;
import larion.progate.lmis.model.impl.LmisViewAttDailyImpl;
import larion.progate.lmis.model.impl.LmisViewAttDailyModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * <a href="LmisViewAttDailyPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewAttDailyPersistenceImpl extends BasePersistenceImpl
	implements LmisViewAttDailyPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = LmisViewAttDailyImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_ROOTID = new FinderPath(LmisViewAttDailyModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewAttDailyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ROOTID = new FinderPath(LmisViewAttDailyModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewAttDailyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ROOTID = new FinderPath(LmisViewAttDailyModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewAttDailyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByRootId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ORGID = new FinderPath(LmisViewAttDailyModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewAttDailyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOrgId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ORGID = new FinderPath(LmisViewAttDailyModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewAttDailyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOrgId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGID = new FinderPath(LmisViewAttDailyModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewAttDailyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByOrgId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_USERID = new FinderPath(LmisViewAttDailyModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewAttDailyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByUserId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_USERID = new FinderPath(LmisViewAttDailyModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewAttDailyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByUserId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(LmisViewAttDailyModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewAttDailyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByUserId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_DAYVALUE = new FinderPath(LmisViewAttDailyModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewAttDailyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByDayValue",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_DAYVALUE = new FinderPath(LmisViewAttDailyModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewAttDailyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByDayValue",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_DAYVALUE = new FinderPath(LmisViewAttDailyModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewAttDailyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByDayValue",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_FULLNAME = new FinderPath(LmisViewAttDailyModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewAttDailyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByFullName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_FULLNAME = new FinderPath(LmisViewAttDailyModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewAttDailyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByFullName",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_FULLNAME = new FinderPath(LmisViewAttDailyModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewAttDailyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByFullName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(LmisViewAttDailyModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewAttDailyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LmisViewAttDailyModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewAttDailyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(LmisViewAttDaily lmisViewAttDaily) {
		EntityCacheUtil.putResult(LmisViewAttDailyModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewAttDailyImpl.class, lmisViewAttDaily.getPrimaryKey(),
			lmisViewAttDaily);
	}

	public void cacheResult(List<LmisViewAttDaily> lmisViewAttDailies) {
		for (LmisViewAttDaily lmisViewAttDaily : lmisViewAttDailies) {
			if (EntityCacheUtil.getResult(
						LmisViewAttDailyModelImpl.ENTITY_CACHE_ENABLED,
						LmisViewAttDailyImpl.class,
						lmisViewAttDaily.getPrimaryKey(), this) == null) {
				cacheResult(lmisViewAttDaily);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(LmisViewAttDailyImpl.class.getName());
		EntityCacheUtil.clearCache(LmisViewAttDailyImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public LmisViewAttDaily create(Integer lmisViewAttDailyId) {
		LmisViewAttDaily lmisViewAttDaily = new LmisViewAttDailyImpl();

		lmisViewAttDaily.setNew(true);
		lmisViewAttDaily.setPrimaryKey(lmisViewAttDailyId);

		return lmisViewAttDaily;
	}

	public LmisViewAttDaily remove(Integer lmisViewAttDailyId)
		throws NoSuchLmisViewAttDailyException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LmisViewAttDaily lmisViewAttDaily = (LmisViewAttDaily)session.get(LmisViewAttDailyImpl.class,
					lmisViewAttDailyId);

			if (lmisViewAttDaily == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No LmisViewAttDaily exists with the primary key " +
						lmisViewAttDailyId);
				}

				throw new NoSuchLmisViewAttDailyException(
					"No LmisViewAttDaily exists with the primary key " +
					lmisViewAttDailyId);
			}

			return remove(lmisViewAttDaily);
		}
		catch (NoSuchLmisViewAttDailyException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public LmisViewAttDaily remove(LmisViewAttDaily lmisViewAttDaily)
		throws SystemException {
		for (ModelListener<LmisViewAttDaily> listener : listeners) {
			listener.onBeforeRemove(lmisViewAttDaily);
		}

		lmisViewAttDaily = removeImpl(lmisViewAttDaily);

		for (ModelListener<LmisViewAttDaily> listener : listeners) {
			listener.onAfterRemove(lmisViewAttDaily);
		}

		return lmisViewAttDaily;
	}

	protected LmisViewAttDaily removeImpl(LmisViewAttDaily lmisViewAttDaily)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (lmisViewAttDaily.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(LmisViewAttDailyImpl.class,
						lmisViewAttDaily.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(lmisViewAttDaily);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(LmisViewAttDailyModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewAttDailyImpl.class, lmisViewAttDaily.getPrimaryKey());

		return lmisViewAttDaily;
	}

	public LmisViewAttDaily update(LmisViewAttDaily lmisViewAttDaily)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(LmisViewAttDaily lmisViewAttDaily) method. Use update(LmisViewAttDaily lmisViewAttDaily, boolean merge) instead.");
		}

		return update(lmisViewAttDaily, false);
	}

	public LmisViewAttDaily update(LmisViewAttDaily lmisViewAttDaily,
		boolean merge) throws SystemException {
		boolean isNew = lmisViewAttDaily.isNew();

		for (ModelListener<LmisViewAttDaily> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(lmisViewAttDaily);
			}
			else {
				listener.onBeforeUpdate(lmisViewAttDaily);
			}
		}

		lmisViewAttDaily = updateImpl(lmisViewAttDaily, merge);

		for (ModelListener<LmisViewAttDaily> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(lmisViewAttDaily);
			}
			else {
				listener.onAfterUpdate(lmisViewAttDaily);
			}
		}

		return lmisViewAttDaily;
	}

	public LmisViewAttDaily updateImpl(
		larion.progate.lmis.model.LmisViewAttDaily lmisViewAttDaily,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, lmisViewAttDaily, merge);

			lmisViewAttDaily.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(LmisViewAttDailyModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewAttDailyImpl.class, lmisViewAttDaily.getPrimaryKey(),
			lmisViewAttDaily);

		return lmisViewAttDaily;
	}

	public LmisViewAttDaily findByPrimaryKey(Integer lmisViewAttDailyId)
		throws NoSuchLmisViewAttDailyException, SystemException {
		LmisViewAttDaily lmisViewAttDaily = fetchByPrimaryKey(lmisViewAttDailyId);

		if (lmisViewAttDaily == null) {
			if (_log.isWarnEnabled()) {
				_log.warn("No LmisViewAttDaily exists with the primary key " +
					lmisViewAttDailyId);
			}

			throw new NoSuchLmisViewAttDailyException(
				"No LmisViewAttDaily exists with the primary key " +
				lmisViewAttDailyId);
		}

		return lmisViewAttDaily;
	}

	public LmisViewAttDaily fetchByPrimaryKey(Integer lmisViewAttDailyId)
		throws SystemException {
		LmisViewAttDaily lmisViewAttDaily = (LmisViewAttDaily)EntityCacheUtil.getResult(LmisViewAttDailyModelImpl.ENTITY_CACHE_ENABLED,
				LmisViewAttDailyImpl.class, lmisViewAttDailyId, this);

		if (lmisViewAttDaily == null) {
			Session session = null;

			try {
				session = openSession();

				lmisViewAttDaily = (LmisViewAttDaily)session.get(LmisViewAttDailyImpl.class,
						lmisViewAttDailyId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (lmisViewAttDaily != null) {
					cacheResult(lmisViewAttDaily);
				}

				closeSession(session);
			}
		}

		return lmisViewAttDaily;
	}

	public List<LmisViewAttDaily> findByRootId(int rootId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		List<LmisViewAttDaily> list = (List<LmisViewAttDaily>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewAttDaily WHERE ");

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
					list = new ArrayList<LmisViewAttDaily>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewAttDaily> findByRootId(int rootId, int start, int end)
		throws SystemException {
		return findByRootId(rootId, start, end, null);
	}

	public List<LmisViewAttDaily> findByRootId(int rootId, int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(rootId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewAttDaily> list = (List<LmisViewAttDaily>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewAttDaily WHERE ");

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

				list = (List<LmisViewAttDaily>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewAttDaily>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewAttDaily findByRootId_First(int rootId, OrderByComparator obc)
		throws NoSuchLmisViewAttDailyException, SystemException {
		List<LmisViewAttDaily> list = findByRootId(rootId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewAttDaily exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewAttDailyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewAttDaily findByRootId_Last(int rootId, OrderByComparator obc)
		throws NoSuchLmisViewAttDailyException, SystemException {
		int count = countByRootId(rootId);

		List<LmisViewAttDaily> list = findByRootId(rootId, count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewAttDaily exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewAttDailyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewAttDaily[] findByRootId_PrevAndNext(
		Integer lmisViewAttDailyId, int rootId, OrderByComparator obc)
		throws NoSuchLmisViewAttDailyException, SystemException {
		LmisViewAttDaily lmisViewAttDaily = findByPrimaryKey(lmisViewAttDailyId);

		int count = countByRootId(rootId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewAttDaily WHERE ");

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
					lmisViewAttDaily);

			LmisViewAttDaily[] array = new LmisViewAttDailyImpl[3];

			array[0] = (LmisViewAttDaily)objArray[0];
			array[1] = (LmisViewAttDaily)objArray[1];
			array[2] = (LmisViewAttDaily)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewAttDaily> findByOrgId(int orgId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(orgId) };

		List<LmisViewAttDaily> list = (List<LmisViewAttDaily>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ORGID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewAttDaily WHERE ");

				query.append("org_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("created_at DESC");

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
					list = new ArrayList<LmisViewAttDaily>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ORGID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewAttDaily> findByOrgId(int orgId, int start, int end)
		throws SystemException {
		return findByOrgId(orgId, start, end, null);
	}

	public List<LmisViewAttDaily> findByOrgId(int orgId, int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(orgId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewAttDaily> list = (List<LmisViewAttDaily>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ORGID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewAttDaily WHERE ");

				query.append("org_id = ?");

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

				qPos.add(orgId);

				list = (List<LmisViewAttDaily>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewAttDaily>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ORGID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewAttDaily findByOrgId_First(int orgId, OrderByComparator obc)
		throws NoSuchLmisViewAttDailyException, SystemException {
		List<LmisViewAttDaily> list = findByOrgId(orgId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewAttDaily exists with the key {");

			msg.append("orgId=" + orgId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewAttDailyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewAttDaily findByOrgId_Last(int orgId, OrderByComparator obc)
		throws NoSuchLmisViewAttDailyException, SystemException {
		int count = countByOrgId(orgId);

		List<LmisViewAttDaily> list = findByOrgId(orgId, count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewAttDaily exists with the key {");

			msg.append("orgId=" + orgId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewAttDailyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewAttDaily[] findByOrgId_PrevAndNext(
		Integer lmisViewAttDailyId, int orgId, OrderByComparator obc)
		throws NoSuchLmisViewAttDailyException, SystemException {
		LmisViewAttDaily lmisViewAttDaily = findByPrimaryKey(lmisViewAttDailyId);

		int count = countByOrgId(orgId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewAttDaily WHERE ");

			query.append("org_id = ?");

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

			qPos.add(orgId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisViewAttDaily);

			LmisViewAttDaily[] array = new LmisViewAttDailyImpl[3];

			array[0] = (LmisViewAttDaily)objArray[0];
			array[1] = (LmisViewAttDaily)objArray[1];
			array[2] = (LmisViewAttDaily)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewAttDaily> findByUserId(int userId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(userId) };

		List<LmisViewAttDaily> list = (List<LmisViewAttDaily>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_USERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewAttDaily WHERE ");

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
					list = new ArrayList<LmisViewAttDaily>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_USERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewAttDaily> findByUserId(int userId, int start, int end)
		throws SystemException {
		return findByUserId(userId, start, end, null);
	}

	public List<LmisViewAttDaily> findByUserId(int userId, int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(userId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewAttDaily> list = (List<LmisViewAttDaily>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_USERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewAttDaily WHERE ");

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

				list = (List<LmisViewAttDaily>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewAttDaily>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_USERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewAttDaily findByUserId_First(int userId, OrderByComparator obc)
		throws NoSuchLmisViewAttDailyException, SystemException {
		List<LmisViewAttDaily> list = findByUserId(userId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewAttDaily exists with the key {");

			msg.append("userId=" + userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewAttDailyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewAttDaily findByUserId_Last(int userId, OrderByComparator obc)
		throws NoSuchLmisViewAttDailyException, SystemException {
		int count = countByUserId(userId);

		List<LmisViewAttDaily> list = findByUserId(userId, count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewAttDaily exists with the key {");

			msg.append("userId=" + userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewAttDailyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewAttDaily[] findByUserId_PrevAndNext(
		Integer lmisViewAttDailyId, int userId, OrderByComparator obc)
		throws NoSuchLmisViewAttDailyException, SystemException {
		LmisViewAttDaily lmisViewAttDaily = findByPrimaryKey(lmisViewAttDailyId);

		int count = countByUserId(userId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewAttDaily WHERE ");

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
					lmisViewAttDaily);

			LmisViewAttDaily[] array = new LmisViewAttDailyImpl[3];

			array[0] = (LmisViewAttDaily)objArray[0];
			array[1] = (LmisViewAttDaily)objArray[1];
			array[2] = (LmisViewAttDaily)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewAttDaily> findByDayValue(Date dayValue)
		throws SystemException {
		Object[] finderArgs = new Object[] { dayValue };

		List<LmisViewAttDaily> list = (List<LmisViewAttDaily>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DAYVALUE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewAttDaily WHERE ");

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
					list = new ArrayList<LmisViewAttDaily>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DAYVALUE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewAttDaily> findByDayValue(Date dayValue, int start,
		int end) throws SystemException {
		return findByDayValue(dayValue, start, end, null);
	}

	public List<LmisViewAttDaily> findByDayValue(Date dayValue, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				dayValue,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewAttDaily> list = (List<LmisViewAttDaily>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_DAYVALUE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewAttDaily WHERE ");

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

				list = (List<LmisViewAttDaily>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewAttDaily>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_DAYVALUE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewAttDaily findByDayValue_First(Date dayValue,
		OrderByComparator obc)
		throws NoSuchLmisViewAttDailyException, SystemException {
		List<LmisViewAttDaily> list = findByDayValue(dayValue, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewAttDaily exists with the key {");

			msg.append("dayValue=" + dayValue);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewAttDailyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewAttDaily findByDayValue_Last(Date dayValue,
		OrderByComparator obc)
		throws NoSuchLmisViewAttDailyException, SystemException {
		int count = countByDayValue(dayValue);

		List<LmisViewAttDaily> list = findByDayValue(dayValue, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewAttDaily exists with the key {");

			msg.append("dayValue=" + dayValue);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewAttDailyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewAttDaily[] findByDayValue_PrevAndNext(
		Integer lmisViewAttDailyId, Date dayValue, OrderByComparator obc)
		throws NoSuchLmisViewAttDailyException, SystemException {
		LmisViewAttDaily lmisViewAttDaily = findByPrimaryKey(lmisViewAttDailyId);

		int count = countByDayValue(dayValue);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewAttDaily WHERE ");

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
					lmisViewAttDaily);

			LmisViewAttDaily[] array = new LmisViewAttDailyImpl[3];

			array[0] = (LmisViewAttDaily)objArray[0];
			array[1] = (LmisViewAttDaily)objArray[1];
			array[2] = (LmisViewAttDaily)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewAttDaily> findByFullName(String fullName)
		throws SystemException {
		Object[] finderArgs = new Object[] { fullName };

		List<LmisViewAttDaily> list = (List<LmisViewAttDaily>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_FULLNAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewAttDaily WHERE ");

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
					list = new ArrayList<LmisViewAttDaily>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_FULLNAME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewAttDaily> findByFullName(String fullName, int start,
		int end) throws SystemException {
		return findByFullName(fullName, start, end, null);
	}

	public List<LmisViewAttDaily> findByFullName(String fullName, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				fullName,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewAttDaily> list = (List<LmisViewAttDaily>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_FULLNAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewAttDaily WHERE ");

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

				list = (List<LmisViewAttDaily>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewAttDaily>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_FULLNAME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewAttDaily findByFullName_First(String fullName,
		OrderByComparator obc)
		throws NoSuchLmisViewAttDailyException, SystemException {
		List<LmisViewAttDaily> list = findByFullName(fullName, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewAttDaily exists with the key {");

			msg.append("fullName=" + fullName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewAttDailyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewAttDaily findByFullName_Last(String fullName,
		OrderByComparator obc)
		throws NoSuchLmisViewAttDailyException, SystemException {
		int count = countByFullName(fullName);

		List<LmisViewAttDaily> list = findByFullName(fullName, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewAttDaily exists with the key {");

			msg.append("fullName=" + fullName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewAttDailyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewAttDaily[] findByFullName_PrevAndNext(
		Integer lmisViewAttDailyId, String fullName, OrderByComparator obc)
		throws NoSuchLmisViewAttDailyException, SystemException {
		LmisViewAttDaily lmisViewAttDaily = findByPrimaryKey(lmisViewAttDailyId);

		int count = countByFullName(fullName);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewAttDaily WHERE ");

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
					lmisViewAttDaily);

			LmisViewAttDaily[] array = new LmisViewAttDailyImpl[3];

			array[0] = (LmisViewAttDaily)objArray[0];
			array[1] = (LmisViewAttDaily)objArray[1];
			array[2] = (LmisViewAttDaily)objArray[2];

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

	public List<LmisViewAttDaily> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<LmisViewAttDaily> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<LmisViewAttDaily> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewAttDaily> list = (List<LmisViewAttDaily>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.lmis.model.LmisViewAttDaily ");

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
					list = (List<LmisViewAttDaily>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LmisViewAttDaily>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewAttDaily>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByRootId(int rootId) throws SystemException {
		for (LmisViewAttDaily lmisViewAttDaily : findByRootId(rootId)) {
			remove(lmisViewAttDaily);
		}
	}

	public void removeByOrgId(int orgId) throws SystemException {
		for (LmisViewAttDaily lmisViewAttDaily : findByOrgId(orgId)) {
			remove(lmisViewAttDaily);
		}
	}

	public void removeByUserId(int userId) throws SystemException {
		for (LmisViewAttDaily lmisViewAttDaily : findByUserId(userId)) {
			remove(lmisViewAttDaily);
		}
	}

	public void removeByDayValue(Date dayValue) throws SystemException {
		for (LmisViewAttDaily lmisViewAttDaily : findByDayValue(dayValue)) {
			remove(lmisViewAttDaily);
		}
	}

	public void removeByFullName(String fullName) throws SystemException {
		for (LmisViewAttDaily lmisViewAttDaily : findByFullName(fullName)) {
			remove(lmisViewAttDaily);
		}
	}

	public void removeAll() throws SystemException {
		for (LmisViewAttDaily lmisViewAttDaily : findAll()) {
			remove(lmisViewAttDaily);
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
					"FROM larion.progate.lmis.model.LmisViewAttDaily WHERE ");

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

	public int countByOrgId(int orgId) throws SystemException {
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
					"FROM larion.progate.lmis.model.LmisViewAttDaily WHERE ");

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
					"FROM larion.progate.lmis.model.LmisViewAttDaily WHERE ");

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
					"FROM larion.progate.lmis.model.LmisViewAttDaily WHERE ");

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
					"FROM larion.progate.lmis.model.LmisViewAttDaily WHERE ");

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
						"SELECT COUNT(*) FROM larion.progate.lmis.model.LmisViewAttDaily");

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
						"value.object.listener.larion.progate.lmis.model.LmisViewAttDaily")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LmisViewAttDaily>> listenersList = new ArrayList<ModelListener<LmisViewAttDaily>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LmisViewAttDaily>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(LmisViewAttDailyPersistenceImpl.class);
}