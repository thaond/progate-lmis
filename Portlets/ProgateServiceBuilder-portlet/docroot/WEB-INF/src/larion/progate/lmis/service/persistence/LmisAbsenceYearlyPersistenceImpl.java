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

import larion.progate.lmis.NoSuchLmisAbsenceYearlyException;
import larion.progate.lmis.model.LmisAbsenceYearly;
import larion.progate.lmis.model.impl.LmisAbsenceYearlyImpl;
import larion.progate.lmis.model.impl.LmisAbsenceYearlyModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="LmisAbsenceYearlyPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisAbsenceYearlyPersistenceImpl extends BasePersistenceImpl
	implements LmisAbsenceYearlyPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = LmisAbsenceYearlyImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_ROOTID = new FinderPath(LmisAbsenceYearlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceYearlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ROOTID = new FinderPath(LmisAbsenceYearlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceYearlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ROOTID = new FinderPath(LmisAbsenceYearlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceYearlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByRootID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_USERID = new FinderPath(LmisAbsenceYearlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceYearlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByuserID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_USERID = new FinderPath(LmisAbsenceYearlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceYearlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByuserID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(LmisAbsenceYearlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceYearlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByuserID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_YEARVALUE = new FinderPath(LmisAbsenceYearlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceYearlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByYearValue",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_YEARVALUE = new FinderPath(LmisAbsenceYearlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceYearlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByYearValue",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_YEARVALUE = new FinderPath(LmisAbsenceYearlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceYearlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByYearValue",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ABSENCETYPE = new FinderPath(LmisAbsenceYearlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceYearlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByAbsenceType",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ABSENCETYPE = new FinderPath(LmisAbsenceYearlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceYearlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByAbsenceType",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ABSENCETYPE = new FinderPath(LmisAbsenceYearlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceYearlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByAbsenceType",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ABSENCETYPEID = new FinderPath(LmisAbsenceYearlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceYearlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByAbsenceTypeID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ABSENCETYPEID = new FinderPath(LmisAbsenceYearlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceYearlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByAbsenceTypeID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ABSENCETYPEID = new FinderPath(LmisAbsenceYearlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceYearlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByAbsenceTypeID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(LmisAbsenceYearlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceYearlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LmisAbsenceYearlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceYearlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(LmisAbsenceYearly lmisAbsenceYearly) {
		EntityCacheUtil.putResult(LmisAbsenceYearlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceYearlyImpl.class, lmisAbsenceYearly.getPrimaryKey(),
			lmisAbsenceYearly);
	}

	public void cacheResult(List<LmisAbsenceYearly> lmisAbsenceYearlies) {
		for (LmisAbsenceYearly lmisAbsenceYearly : lmisAbsenceYearlies) {
			if (EntityCacheUtil.getResult(
						LmisAbsenceYearlyModelImpl.ENTITY_CACHE_ENABLED,
						LmisAbsenceYearlyImpl.class,
						lmisAbsenceYearly.getPrimaryKey(), this) == null) {
				cacheResult(lmisAbsenceYearly);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(LmisAbsenceYearlyImpl.class.getName());
		EntityCacheUtil.clearCache(LmisAbsenceYearlyImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public LmisAbsenceYearly create(Integer lmisAbsenceYearlyId) {
		LmisAbsenceYearly lmisAbsenceYearly = new LmisAbsenceYearlyImpl();

		lmisAbsenceYearly.setNew(true);
		lmisAbsenceYearly.setPrimaryKey(lmisAbsenceYearlyId);

		return lmisAbsenceYearly;
	}

	public LmisAbsenceYearly remove(Integer lmisAbsenceYearlyId)
		throws NoSuchLmisAbsenceYearlyException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LmisAbsenceYearly lmisAbsenceYearly = (LmisAbsenceYearly)session.get(LmisAbsenceYearlyImpl.class,
					lmisAbsenceYearlyId);

			if (lmisAbsenceYearly == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No LmisAbsenceYearly exists with the primary key " +
						lmisAbsenceYearlyId);
				}

				throw new NoSuchLmisAbsenceYearlyException(
					"No LmisAbsenceYearly exists with the primary key " +
					lmisAbsenceYearlyId);
			}

			return remove(lmisAbsenceYearly);
		}
		catch (NoSuchLmisAbsenceYearlyException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public LmisAbsenceYearly remove(LmisAbsenceYearly lmisAbsenceYearly)
		throws SystemException {
		for (ModelListener<LmisAbsenceYearly> listener : listeners) {
			listener.onBeforeRemove(lmisAbsenceYearly);
		}

		lmisAbsenceYearly = removeImpl(lmisAbsenceYearly);

		for (ModelListener<LmisAbsenceYearly> listener : listeners) {
			listener.onAfterRemove(lmisAbsenceYearly);
		}

		return lmisAbsenceYearly;
	}

	protected LmisAbsenceYearly removeImpl(LmisAbsenceYearly lmisAbsenceYearly)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (lmisAbsenceYearly.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(LmisAbsenceYearlyImpl.class,
						lmisAbsenceYearly.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(lmisAbsenceYearly);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(LmisAbsenceYearlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceYearlyImpl.class, lmisAbsenceYearly.getPrimaryKey());

		return lmisAbsenceYearly;
	}

	public LmisAbsenceYearly update(LmisAbsenceYearly lmisAbsenceYearly)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(LmisAbsenceYearly lmisAbsenceYearly) method. Use update(LmisAbsenceYearly lmisAbsenceYearly, boolean merge) instead.");
		}

		return update(lmisAbsenceYearly, false);
	}

	public LmisAbsenceYearly update(LmisAbsenceYearly lmisAbsenceYearly,
		boolean merge) throws SystemException {
		boolean isNew = lmisAbsenceYearly.isNew();

		for (ModelListener<LmisAbsenceYearly> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(lmisAbsenceYearly);
			}
			else {
				listener.onBeforeUpdate(lmisAbsenceYearly);
			}
		}

		lmisAbsenceYearly = updateImpl(lmisAbsenceYearly, merge);

		for (ModelListener<LmisAbsenceYearly> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(lmisAbsenceYearly);
			}
			else {
				listener.onAfterUpdate(lmisAbsenceYearly);
			}
		}

		return lmisAbsenceYearly;
	}

	public LmisAbsenceYearly updateImpl(
		larion.progate.lmis.model.LmisAbsenceYearly lmisAbsenceYearly,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, lmisAbsenceYearly, merge);

			lmisAbsenceYearly.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(LmisAbsenceYearlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceYearlyImpl.class, lmisAbsenceYearly.getPrimaryKey(),
			lmisAbsenceYearly);

		return lmisAbsenceYearly;
	}

	public LmisAbsenceYearly findByPrimaryKey(Integer lmisAbsenceYearlyId)
		throws NoSuchLmisAbsenceYearlyException, SystemException {
		LmisAbsenceYearly lmisAbsenceYearly = fetchByPrimaryKey(lmisAbsenceYearlyId);

		if (lmisAbsenceYearly == null) {
			if (_log.isWarnEnabled()) {
				_log.warn("No LmisAbsenceYearly exists with the primary key " +
					lmisAbsenceYearlyId);
			}

			throw new NoSuchLmisAbsenceYearlyException(
				"No LmisAbsenceYearly exists with the primary key " +
				lmisAbsenceYearlyId);
		}

		return lmisAbsenceYearly;
	}

	public LmisAbsenceYearly fetchByPrimaryKey(Integer lmisAbsenceYearlyId)
		throws SystemException {
		LmisAbsenceYearly lmisAbsenceYearly = (LmisAbsenceYearly)EntityCacheUtil.getResult(LmisAbsenceYearlyModelImpl.ENTITY_CACHE_ENABLED,
				LmisAbsenceYearlyImpl.class, lmisAbsenceYearlyId, this);

		if (lmisAbsenceYearly == null) {
			Session session = null;

			try {
				session = openSession();

				lmisAbsenceYearly = (LmisAbsenceYearly)session.get(LmisAbsenceYearlyImpl.class,
						lmisAbsenceYearlyId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (lmisAbsenceYearly != null) {
					cacheResult(lmisAbsenceYearly);
				}

				closeSession(session);
			}
		}

		return lmisAbsenceYearly;
	}

	public List<LmisAbsenceYearly> findByRootID(int rootId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		List<LmisAbsenceYearly> list = (List<LmisAbsenceYearly>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceYearly WHERE ");

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
					list = new ArrayList<LmisAbsenceYearly>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisAbsenceYearly> findByRootID(int rootId, int start, int end)
		throws SystemException {
		return findByRootID(rootId, start, end, null);
	}

	public List<LmisAbsenceYearly> findByRootID(int rootId, int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(rootId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisAbsenceYearly> list = (List<LmisAbsenceYearly>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceYearly WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rootId);

				list = (List<LmisAbsenceYearly>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisAbsenceYearly>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisAbsenceYearly findByRootID_First(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisAbsenceYearlyException, SystemException {
		List<LmisAbsenceYearly> list = findByRootID(rootId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAbsenceYearly exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAbsenceYearlyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAbsenceYearly findByRootID_Last(int rootId, OrderByComparator obc)
		throws NoSuchLmisAbsenceYearlyException, SystemException {
		int count = countByRootID(rootId);

		List<LmisAbsenceYearly> list = findByRootID(rootId, count - 1, count,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAbsenceYearly exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAbsenceYearlyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAbsenceYearly[] findByRootID_PrevAndNext(
		Integer lmisAbsenceYearlyId, int rootId, OrderByComparator obc)
		throws NoSuchLmisAbsenceYearlyException, SystemException {
		LmisAbsenceYearly lmisAbsenceYearly = findByPrimaryKey(lmisAbsenceYearlyId);

		int count = countByRootID(rootId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisAbsenceYearly WHERE ");

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
					lmisAbsenceYearly);

			LmisAbsenceYearly[] array = new LmisAbsenceYearlyImpl[3];

			array[0] = (LmisAbsenceYearly)objArray[0];
			array[1] = (LmisAbsenceYearly)objArray[1];
			array[2] = (LmisAbsenceYearly)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisAbsenceYearly> findByuserID(int userId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(userId) };

		List<LmisAbsenceYearly> list = (List<LmisAbsenceYearly>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_USERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceYearly WHERE ");

				query.append("user_id = ?");

				query.append(" ");

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
					list = new ArrayList<LmisAbsenceYearly>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_USERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisAbsenceYearly> findByuserID(int userId, int start, int end)
		throws SystemException {
		return findByuserID(userId, start, end, null);
	}

	public List<LmisAbsenceYearly> findByuserID(int userId, int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(userId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisAbsenceYearly> list = (List<LmisAbsenceYearly>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_USERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceYearly WHERE ");

				query.append("user_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				list = (List<LmisAbsenceYearly>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisAbsenceYearly>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_USERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisAbsenceYearly findByuserID_First(int userId,
		OrderByComparator obc)
		throws NoSuchLmisAbsenceYearlyException, SystemException {
		List<LmisAbsenceYearly> list = findByuserID(userId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAbsenceYearly exists with the key {");

			msg.append("userId=" + userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAbsenceYearlyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAbsenceYearly findByuserID_Last(int userId, OrderByComparator obc)
		throws NoSuchLmisAbsenceYearlyException, SystemException {
		int count = countByuserID(userId);

		List<LmisAbsenceYearly> list = findByuserID(userId, count - 1, count,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAbsenceYearly exists with the key {");

			msg.append("userId=" + userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAbsenceYearlyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAbsenceYearly[] findByuserID_PrevAndNext(
		Integer lmisAbsenceYearlyId, int userId, OrderByComparator obc)
		throws NoSuchLmisAbsenceYearlyException, SystemException {
		LmisAbsenceYearly lmisAbsenceYearly = findByPrimaryKey(lmisAbsenceYearlyId);

		int count = countByuserID(userId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisAbsenceYearly WHERE ");

			query.append("user_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(userId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisAbsenceYearly);

			LmisAbsenceYearly[] array = new LmisAbsenceYearlyImpl[3];

			array[0] = (LmisAbsenceYearly)objArray[0];
			array[1] = (LmisAbsenceYearly)objArray[1];
			array[2] = (LmisAbsenceYearly)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisAbsenceYearly> findByYearValue(int yearValue)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(yearValue) };

		List<LmisAbsenceYearly> list = (List<LmisAbsenceYearly>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_YEARVALUE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceYearly WHERE ");

				query.append("year_value = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(yearValue);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisAbsenceYearly>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_YEARVALUE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisAbsenceYearly> findByYearValue(int yearValue, int start,
		int end) throws SystemException {
		return findByYearValue(yearValue, start, end, null);
	}

	public List<LmisAbsenceYearly> findByYearValue(int yearValue, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(yearValue),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisAbsenceYearly> list = (List<LmisAbsenceYearly>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_YEARVALUE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceYearly WHERE ");

				query.append("year_value = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(yearValue);

				list = (List<LmisAbsenceYearly>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisAbsenceYearly>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_YEARVALUE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisAbsenceYearly findByYearValue_First(int yearValue,
		OrderByComparator obc)
		throws NoSuchLmisAbsenceYearlyException, SystemException {
		List<LmisAbsenceYearly> list = findByYearValue(yearValue, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAbsenceYearly exists with the key {");

			msg.append("yearValue=" + yearValue);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAbsenceYearlyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAbsenceYearly findByYearValue_Last(int yearValue,
		OrderByComparator obc)
		throws NoSuchLmisAbsenceYearlyException, SystemException {
		int count = countByYearValue(yearValue);

		List<LmisAbsenceYearly> list = findByYearValue(yearValue, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAbsenceYearly exists with the key {");

			msg.append("yearValue=" + yearValue);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAbsenceYearlyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAbsenceYearly[] findByYearValue_PrevAndNext(
		Integer lmisAbsenceYearlyId, int yearValue, OrderByComparator obc)
		throws NoSuchLmisAbsenceYearlyException, SystemException {
		LmisAbsenceYearly lmisAbsenceYearly = findByPrimaryKey(lmisAbsenceYearlyId);

		int count = countByYearValue(yearValue);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisAbsenceYearly WHERE ");

			query.append("year_value = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(yearValue);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisAbsenceYearly);

			LmisAbsenceYearly[] array = new LmisAbsenceYearlyImpl[3];

			array[0] = (LmisAbsenceYearly)objArray[0];
			array[1] = (LmisAbsenceYearly)objArray[1];
			array[2] = (LmisAbsenceYearly)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisAbsenceYearly> findByAbsenceType(String absenceType)
		throws SystemException {
		Object[] finderArgs = new Object[] { absenceType };

		List<LmisAbsenceYearly> list = (List<LmisAbsenceYearly>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ABSENCETYPE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceYearly WHERE ");

				if (absenceType == null) {
					query.append("absence_type IS NULL");
				}
				else {
					query.append("absence_type = ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (absenceType != null) {
					qPos.add(absenceType);
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisAbsenceYearly>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ABSENCETYPE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisAbsenceYearly> findByAbsenceType(String absenceType,
		int start, int end) throws SystemException {
		return findByAbsenceType(absenceType, start, end, null);
	}

	public List<LmisAbsenceYearly> findByAbsenceType(String absenceType,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				absenceType,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisAbsenceYearly> list = (List<LmisAbsenceYearly>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ABSENCETYPE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceYearly WHERE ");

				if (absenceType == null) {
					query.append("absence_type IS NULL");
				}
				else {
					query.append("absence_type = ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (absenceType != null) {
					qPos.add(absenceType);
				}

				list = (List<LmisAbsenceYearly>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisAbsenceYearly>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ABSENCETYPE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisAbsenceYearly findByAbsenceType_First(String absenceType,
		OrderByComparator obc)
		throws NoSuchLmisAbsenceYearlyException, SystemException {
		List<LmisAbsenceYearly> list = findByAbsenceType(absenceType, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAbsenceYearly exists with the key {");

			msg.append("absenceType=" + absenceType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAbsenceYearlyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAbsenceYearly findByAbsenceType_Last(String absenceType,
		OrderByComparator obc)
		throws NoSuchLmisAbsenceYearlyException, SystemException {
		int count = countByAbsenceType(absenceType);

		List<LmisAbsenceYearly> list = findByAbsenceType(absenceType,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAbsenceYearly exists with the key {");

			msg.append("absenceType=" + absenceType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAbsenceYearlyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAbsenceYearly[] findByAbsenceType_PrevAndNext(
		Integer lmisAbsenceYearlyId, String absenceType, OrderByComparator obc)
		throws NoSuchLmisAbsenceYearlyException, SystemException {
		LmisAbsenceYearly lmisAbsenceYearly = findByPrimaryKey(lmisAbsenceYearlyId);

		int count = countByAbsenceType(absenceType);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisAbsenceYearly WHERE ");

			if (absenceType == null) {
				query.append("absence_type IS NULL");
			}
			else {
				query.append("absence_type = ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (absenceType != null) {
				qPos.add(absenceType);
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisAbsenceYearly);

			LmisAbsenceYearly[] array = new LmisAbsenceYearlyImpl[3];

			array[0] = (LmisAbsenceYearly)objArray[0];
			array[1] = (LmisAbsenceYearly)objArray[1];
			array[2] = (LmisAbsenceYearly)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisAbsenceYearly> findByAbsenceTypeID(int absenceTypeId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(absenceTypeId) };

		List<LmisAbsenceYearly> list = (List<LmisAbsenceYearly>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ABSENCETYPEID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceYearly WHERE ");

				query.append("absence_type_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(absenceTypeId);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisAbsenceYearly>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ABSENCETYPEID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisAbsenceYearly> findByAbsenceTypeID(int absenceTypeId,
		int start, int end) throws SystemException {
		return findByAbsenceTypeID(absenceTypeId, start, end, null);
	}

	public List<LmisAbsenceYearly> findByAbsenceTypeID(int absenceTypeId,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(absenceTypeId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisAbsenceYearly> list = (List<LmisAbsenceYearly>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ABSENCETYPEID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceYearly WHERE ");

				query.append("absence_type_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(absenceTypeId);

				list = (List<LmisAbsenceYearly>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisAbsenceYearly>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ABSENCETYPEID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisAbsenceYearly findByAbsenceTypeID_First(int absenceTypeId,
		OrderByComparator obc)
		throws NoSuchLmisAbsenceYearlyException, SystemException {
		List<LmisAbsenceYearly> list = findByAbsenceTypeID(absenceTypeId, 0, 1,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAbsenceYearly exists with the key {");

			msg.append("absenceTypeId=" + absenceTypeId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAbsenceYearlyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAbsenceYearly findByAbsenceTypeID_Last(int absenceTypeId,
		OrderByComparator obc)
		throws NoSuchLmisAbsenceYearlyException, SystemException {
		int count = countByAbsenceTypeID(absenceTypeId);

		List<LmisAbsenceYearly> list = findByAbsenceTypeID(absenceTypeId,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAbsenceYearly exists with the key {");

			msg.append("absenceTypeId=" + absenceTypeId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAbsenceYearlyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAbsenceYearly[] findByAbsenceTypeID_PrevAndNext(
		Integer lmisAbsenceYearlyId, int absenceTypeId, OrderByComparator obc)
		throws NoSuchLmisAbsenceYearlyException, SystemException {
		LmisAbsenceYearly lmisAbsenceYearly = findByPrimaryKey(lmisAbsenceYearlyId);

		int count = countByAbsenceTypeID(absenceTypeId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisAbsenceYearly WHERE ");

			query.append("absence_type_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(absenceTypeId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisAbsenceYearly);

			LmisAbsenceYearly[] array = new LmisAbsenceYearlyImpl[3];

			array[0] = (LmisAbsenceYearly)objArray[0];
			array[1] = (LmisAbsenceYearly)objArray[1];
			array[2] = (LmisAbsenceYearly)objArray[2];

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

	public List<LmisAbsenceYearly> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<LmisAbsenceYearly> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<LmisAbsenceYearly> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisAbsenceYearly> list = (List<LmisAbsenceYearly>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceYearly ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<LmisAbsenceYearly>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LmisAbsenceYearly>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisAbsenceYearly>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByRootID(int rootId) throws SystemException {
		for (LmisAbsenceYearly lmisAbsenceYearly : findByRootID(rootId)) {
			remove(lmisAbsenceYearly);
		}
	}

	public void removeByuserID(int userId) throws SystemException {
		for (LmisAbsenceYearly lmisAbsenceYearly : findByuserID(userId)) {
			remove(lmisAbsenceYearly);
		}
	}

	public void removeByYearValue(int yearValue) throws SystemException {
		for (LmisAbsenceYearly lmisAbsenceYearly : findByYearValue(yearValue)) {
			remove(lmisAbsenceYearly);
		}
	}

	public void removeByAbsenceType(String absenceType)
		throws SystemException {
		for (LmisAbsenceYearly lmisAbsenceYearly : findByAbsenceType(
				absenceType)) {
			remove(lmisAbsenceYearly);
		}
	}

	public void removeByAbsenceTypeID(int absenceTypeId)
		throws SystemException {
		for (LmisAbsenceYearly lmisAbsenceYearly : findByAbsenceTypeID(
				absenceTypeId)) {
			remove(lmisAbsenceYearly);
		}
	}

	public void removeAll() throws SystemException {
		for (LmisAbsenceYearly lmisAbsenceYearly : findAll()) {
			remove(lmisAbsenceYearly);
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
					"FROM larion.progate.lmis.model.LmisAbsenceYearly WHERE ");

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
					"FROM larion.progate.lmis.model.LmisAbsenceYearly WHERE ");

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

	public int countByYearValue(int yearValue) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(yearValue) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_YEARVALUE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceYearly WHERE ");

				query.append("year_value = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(yearValue);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_YEARVALUE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByAbsenceType(String absenceType) throws SystemException {
		Object[] finderArgs = new Object[] { absenceType };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ABSENCETYPE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceYearly WHERE ");

				if (absenceType == null) {
					query.append("absence_type IS NULL");
				}
				else {
					query.append("absence_type = ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (absenceType != null) {
					qPos.add(absenceType);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ABSENCETYPE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByAbsenceTypeID(int absenceTypeId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(absenceTypeId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ABSENCETYPEID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceYearly WHERE ");

				query.append("absence_type_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(absenceTypeId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ABSENCETYPEID,
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
						"SELECT COUNT(*) FROM larion.progate.lmis.model.LmisAbsenceYearly");

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
						"value.object.listener.larion.progate.lmis.model.LmisAbsenceYearly")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LmisAbsenceYearly>> listenersList = new ArrayList<ModelListener<LmisAbsenceYearly>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LmisAbsenceYearly>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(LmisAbsenceYearlyPersistenceImpl.class);
}