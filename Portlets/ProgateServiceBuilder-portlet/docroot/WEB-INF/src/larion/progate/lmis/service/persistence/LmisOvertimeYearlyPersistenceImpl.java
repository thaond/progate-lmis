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

import larion.progate.lmis.NoSuchLmisOvertimeYearlyException;
import larion.progate.lmis.model.LmisOvertimeYearly;
import larion.progate.lmis.model.impl.LmisOvertimeYearlyImpl;
import larion.progate.lmis.model.impl.LmisOvertimeYearlyModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="LmisOvertimeYearlyPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisOvertimeYearlyPersistenceImpl extends BasePersistenceImpl
	implements LmisOvertimeYearlyPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = LmisOvertimeYearlyImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_OVERTIMEYEAROF = new FinderPath(LmisOvertimeYearlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeYearlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOvertimeYearOf",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_OVERTIMEYEAROF = new FinderPath(LmisOvertimeYearlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeYearlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOvertimeYearOf",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_OVERTIMEYEAROF = new FinderPath(LmisOvertimeYearlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeYearlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByOvertimeYearOf",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_USERID = new FinderPath(LmisOvertimeYearlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeYearlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByUserID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_USERID = new FinderPath(LmisOvertimeYearlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeYearlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByUserID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(LmisOvertimeYearlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeYearlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByUserID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_YEARVALUE = new FinderPath(LmisOvertimeYearlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeYearlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByYearValue",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_YEARVALUE = new FinderPath(LmisOvertimeYearlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeYearlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByYearValue",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_YEARVALUE = new FinderPath(LmisOvertimeYearlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeYearlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByYearValue",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(LmisOvertimeYearlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeYearlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LmisOvertimeYearlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeYearlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(LmisOvertimeYearly lmisOvertimeYearly) {
		EntityCacheUtil.putResult(LmisOvertimeYearlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeYearlyImpl.class, lmisOvertimeYearly.getPrimaryKey(),
			lmisOvertimeYearly);
	}

	public void cacheResult(List<LmisOvertimeYearly> lmisOvertimeYearlies) {
		for (LmisOvertimeYearly lmisOvertimeYearly : lmisOvertimeYearlies) {
			if (EntityCacheUtil.getResult(
						LmisOvertimeYearlyModelImpl.ENTITY_CACHE_ENABLED,
						LmisOvertimeYearlyImpl.class,
						lmisOvertimeYearly.getPrimaryKey(), this) == null) {
				cacheResult(lmisOvertimeYearly);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(LmisOvertimeYearlyImpl.class.getName());
		EntityCacheUtil.clearCache(LmisOvertimeYearlyImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public LmisOvertimeYearly create(Integer lmisOvertimeYearlyId) {
		LmisOvertimeYearly lmisOvertimeYearly = new LmisOvertimeYearlyImpl();

		lmisOvertimeYearly.setNew(true);
		lmisOvertimeYearly.setPrimaryKey(lmisOvertimeYearlyId);

		return lmisOvertimeYearly;
	}

	public LmisOvertimeYearly remove(Integer lmisOvertimeYearlyId)
		throws NoSuchLmisOvertimeYearlyException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LmisOvertimeYearly lmisOvertimeYearly = (LmisOvertimeYearly)session.get(LmisOvertimeYearlyImpl.class,
					lmisOvertimeYearlyId);

			if (lmisOvertimeYearly == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No LmisOvertimeYearly exists with the primary key " +
						lmisOvertimeYearlyId);
				}

				throw new NoSuchLmisOvertimeYearlyException(
					"No LmisOvertimeYearly exists with the primary key " +
					lmisOvertimeYearlyId);
			}

			return remove(lmisOvertimeYearly);
		}
		catch (NoSuchLmisOvertimeYearlyException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public LmisOvertimeYearly remove(LmisOvertimeYearly lmisOvertimeYearly)
		throws SystemException {
		for (ModelListener<LmisOvertimeYearly> listener : listeners) {
			listener.onBeforeRemove(lmisOvertimeYearly);
		}

		lmisOvertimeYearly = removeImpl(lmisOvertimeYearly);

		for (ModelListener<LmisOvertimeYearly> listener : listeners) {
			listener.onAfterRemove(lmisOvertimeYearly);
		}

		return lmisOvertimeYearly;
	}

	protected LmisOvertimeYearly removeImpl(
		LmisOvertimeYearly lmisOvertimeYearly) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (lmisOvertimeYearly.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(LmisOvertimeYearlyImpl.class,
						lmisOvertimeYearly.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(lmisOvertimeYearly);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(LmisOvertimeYearlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeYearlyImpl.class, lmisOvertimeYearly.getPrimaryKey());

		return lmisOvertimeYearly;
	}

	public LmisOvertimeYearly update(LmisOvertimeYearly lmisOvertimeYearly)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(LmisOvertimeYearly lmisOvertimeYearly) method. Use update(LmisOvertimeYearly lmisOvertimeYearly, boolean merge) instead.");
		}

		return update(lmisOvertimeYearly, false);
	}

	public LmisOvertimeYearly update(LmisOvertimeYearly lmisOvertimeYearly,
		boolean merge) throws SystemException {
		boolean isNew = lmisOvertimeYearly.isNew();

		for (ModelListener<LmisOvertimeYearly> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(lmisOvertimeYearly);
			}
			else {
				listener.onBeforeUpdate(lmisOvertimeYearly);
			}
		}

		lmisOvertimeYearly = updateImpl(lmisOvertimeYearly, merge);

		for (ModelListener<LmisOvertimeYearly> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(lmisOvertimeYearly);
			}
			else {
				listener.onAfterUpdate(lmisOvertimeYearly);
			}
		}

		return lmisOvertimeYearly;
	}

	public LmisOvertimeYearly updateImpl(
		larion.progate.lmis.model.LmisOvertimeYearly lmisOvertimeYearly,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, lmisOvertimeYearly, merge);

			lmisOvertimeYearly.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(LmisOvertimeYearlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeYearlyImpl.class, lmisOvertimeYearly.getPrimaryKey(),
			lmisOvertimeYearly);

		return lmisOvertimeYearly;
	}

	public LmisOvertimeYearly findByPrimaryKey(Integer lmisOvertimeYearlyId)
		throws NoSuchLmisOvertimeYearlyException, SystemException {
		LmisOvertimeYearly lmisOvertimeYearly = fetchByPrimaryKey(lmisOvertimeYearlyId);

		if (lmisOvertimeYearly == null) {
			if (_log.isWarnEnabled()) {
				_log.warn("No LmisOvertimeYearly exists with the primary key " +
					lmisOvertimeYearlyId);
			}

			throw new NoSuchLmisOvertimeYearlyException(
				"No LmisOvertimeYearly exists with the primary key " +
				lmisOvertimeYearlyId);
		}

		return lmisOvertimeYearly;
	}

	public LmisOvertimeYearly fetchByPrimaryKey(Integer lmisOvertimeYearlyId)
		throws SystemException {
		LmisOvertimeYearly lmisOvertimeYearly = (LmisOvertimeYearly)EntityCacheUtil.getResult(LmisOvertimeYearlyModelImpl.ENTITY_CACHE_ENABLED,
				LmisOvertimeYearlyImpl.class, lmisOvertimeYearlyId, this);

		if (lmisOvertimeYearly == null) {
			Session session = null;

			try {
				session = openSession();

				lmisOvertimeYearly = (LmisOvertimeYearly)session.get(LmisOvertimeYearlyImpl.class,
						lmisOvertimeYearlyId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (lmisOvertimeYearly != null) {
					cacheResult(lmisOvertimeYearly);
				}

				closeSession(session);
			}
		}

		return lmisOvertimeYearly;
	}

	public List<LmisOvertimeYearly> findByOvertimeYearOf(int rootId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		List<LmisOvertimeYearly> list = (List<LmisOvertimeYearly>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OVERTIMEYEAROF,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOvertimeYearly WHERE ");

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
					list = new ArrayList<LmisOvertimeYearly>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OVERTIMEYEAROF,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisOvertimeYearly> findByOvertimeYearOf(int rootId, int start,
		int end) throws SystemException {
		return findByOvertimeYearOf(rootId, start, end, null);
	}

	public List<LmisOvertimeYearly> findByOvertimeYearOf(int rootId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(rootId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisOvertimeYearly> list = (List<LmisOvertimeYearly>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_OVERTIMEYEAROF,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOvertimeYearly WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rootId);

				list = (List<LmisOvertimeYearly>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisOvertimeYearly>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_OVERTIMEYEAROF,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisOvertimeYearly findByOvertimeYearOf_First(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisOvertimeYearlyException, SystemException {
		List<LmisOvertimeYearly> list = findByOvertimeYearOf(rootId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOvertimeYearly exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOvertimeYearlyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOvertimeYearly findByOvertimeYearOf_Last(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisOvertimeYearlyException, SystemException {
		int count = countByOvertimeYearOf(rootId);

		List<LmisOvertimeYearly> list = findByOvertimeYearOf(rootId, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOvertimeYearly exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOvertimeYearlyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOvertimeYearly[] findByOvertimeYearOf_PrevAndNext(
		Integer lmisOvertimeYearlyId, int rootId, OrderByComparator obc)
		throws NoSuchLmisOvertimeYearlyException, SystemException {
		LmisOvertimeYearly lmisOvertimeYearly = findByPrimaryKey(lmisOvertimeYearlyId);

		int count = countByOvertimeYearOf(rootId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisOvertimeYearly WHERE ");

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
					lmisOvertimeYearly);

			LmisOvertimeYearly[] array = new LmisOvertimeYearlyImpl[3];

			array[0] = (LmisOvertimeYearly)objArray[0];
			array[1] = (LmisOvertimeYearly)objArray[1];
			array[2] = (LmisOvertimeYearly)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisOvertimeYearly> findByUserID(int userId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(userId) };

		List<LmisOvertimeYearly> list = (List<LmisOvertimeYearly>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_USERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOvertimeYearly WHERE ");

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
					list = new ArrayList<LmisOvertimeYearly>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_USERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisOvertimeYearly> findByUserID(int userId, int start, int end)
		throws SystemException {
		return findByUserID(userId, start, end, null);
	}

	public List<LmisOvertimeYearly> findByUserID(int userId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(userId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisOvertimeYearly> list = (List<LmisOvertimeYearly>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_USERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOvertimeYearly WHERE ");

				query.append("user_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				list = (List<LmisOvertimeYearly>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisOvertimeYearly>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_USERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisOvertimeYearly findByUserID_First(int userId,
		OrderByComparator obc)
		throws NoSuchLmisOvertimeYearlyException, SystemException {
		List<LmisOvertimeYearly> list = findByUserID(userId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOvertimeYearly exists with the key {");

			msg.append("userId=" + userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOvertimeYearlyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOvertimeYearly findByUserID_Last(int userId,
		OrderByComparator obc)
		throws NoSuchLmisOvertimeYearlyException, SystemException {
		int count = countByUserID(userId);

		List<LmisOvertimeYearly> list = findByUserID(userId, count - 1, count,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOvertimeYearly exists with the key {");

			msg.append("userId=" + userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOvertimeYearlyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOvertimeYearly[] findByUserID_PrevAndNext(
		Integer lmisOvertimeYearlyId, int userId, OrderByComparator obc)
		throws NoSuchLmisOvertimeYearlyException, SystemException {
		LmisOvertimeYearly lmisOvertimeYearly = findByPrimaryKey(lmisOvertimeYearlyId);

		int count = countByUserID(userId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisOvertimeYearly WHERE ");

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
					lmisOvertimeYearly);

			LmisOvertimeYearly[] array = new LmisOvertimeYearlyImpl[3];

			array[0] = (LmisOvertimeYearly)objArray[0];
			array[1] = (LmisOvertimeYearly)objArray[1];
			array[2] = (LmisOvertimeYearly)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisOvertimeYearly> findByYearValue(int yearValue)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(yearValue) };

		List<LmisOvertimeYearly> list = (List<LmisOvertimeYearly>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_YEARVALUE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOvertimeYearly WHERE ");

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
					list = new ArrayList<LmisOvertimeYearly>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_YEARVALUE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisOvertimeYearly> findByYearValue(int yearValue, int start,
		int end) throws SystemException {
		return findByYearValue(yearValue, start, end, null);
	}

	public List<LmisOvertimeYearly> findByYearValue(int yearValue, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(yearValue),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisOvertimeYearly> list = (List<LmisOvertimeYearly>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_YEARVALUE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOvertimeYearly WHERE ");

				query.append("year_value = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(yearValue);

				list = (List<LmisOvertimeYearly>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisOvertimeYearly>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_YEARVALUE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisOvertimeYearly findByYearValue_First(int yearValue,
		OrderByComparator obc)
		throws NoSuchLmisOvertimeYearlyException, SystemException {
		List<LmisOvertimeYearly> list = findByYearValue(yearValue, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOvertimeYearly exists with the key {");

			msg.append("yearValue=" + yearValue);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOvertimeYearlyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOvertimeYearly findByYearValue_Last(int yearValue,
		OrderByComparator obc)
		throws NoSuchLmisOvertimeYearlyException, SystemException {
		int count = countByYearValue(yearValue);

		List<LmisOvertimeYearly> list = findByYearValue(yearValue, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOvertimeYearly exists with the key {");

			msg.append("yearValue=" + yearValue);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOvertimeYearlyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOvertimeYearly[] findByYearValue_PrevAndNext(
		Integer lmisOvertimeYearlyId, int yearValue, OrderByComparator obc)
		throws NoSuchLmisOvertimeYearlyException, SystemException {
		LmisOvertimeYearly lmisOvertimeYearly = findByPrimaryKey(lmisOvertimeYearlyId);

		int count = countByYearValue(yearValue);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisOvertimeYearly WHERE ");

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
					lmisOvertimeYearly);

			LmisOvertimeYearly[] array = new LmisOvertimeYearlyImpl[3];

			array[0] = (LmisOvertimeYearly)objArray[0];
			array[1] = (LmisOvertimeYearly)objArray[1];
			array[2] = (LmisOvertimeYearly)objArray[2];

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

	public List<LmisOvertimeYearly> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<LmisOvertimeYearly> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<LmisOvertimeYearly> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisOvertimeYearly> list = (List<LmisOvertimeYearly>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOvertimeYearly ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<LmisOvertimeYearly>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LmisOvertimeYearly>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisOvertimeYearly>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByOvertimeYearOf(int rootId) throws SystemException {
		for (LmisOvertimeYearly lmisOvertimeYearly : findByOvertimeYearOf(
				rootId)) {
			remove(lmisOvertimeYearly);
		}
	}

	public void removeByUserID(int userId) throws SystemException {
		for (LmisOvertimeYearly lmisOvertimeYearly : findByUserID(userId)) {
			remove(lmisOvertimeYearly);
		}
	}

	public void removeByYearValue(int yearValue) throws SystemException {
		for (LmisOvertimeYearly lmisOvertimeYearly : findByYearValue(yearValue)) {
			remove(lmisOvertimeYearly);
		}
	}

	public void removeAll() throws SystemException {
		for (LmisOvertimeYearly lmisOvertimeYearly : findAll()) {
			remove(lmisOvertimeYearly);
		}
	}

	public int countByOvertimeYearOf(int rootId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_OVERTIMEYEAROF,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisOvertimeYearly WHERE ");

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_OVERTIMEYEAROF,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByUserID(int userId) throws SystemException {
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
					"FROM larion.progate.lmis.model.LmisOvertimeYearly WHERE ");

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
					"FROM larion.progate.lmis.model.LmisOvertimeYearly WHERE ");

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

	public int countAll() throws SystemException {
		Object[] finderArgs = new Object[0];

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(
						"SELECT COUNT(*) FROM larion.progate.lmis.model.LmisOvertimeYearly");

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
						"value.object.listener.larion.progate.lmis.model.LmisOvertimeYearly")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LmisOvertimeYearly>> listenersList = new ArrayList<ModelListener<LmisOvertimeYearly>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LmisOvertimeYearly>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(LmisOvertimeYearlyPersistenceImpl.class);
}