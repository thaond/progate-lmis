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

import larion.progate.lmis.NoSuchLmisOvertimeMonthlyException;
import larion.progate.lmis.model.LmisOvertimeMonthly;
import larion.progate.lmis.model.impl.LmisOvertimeMonthlyImpl;
import larion.progate.lmis.model.impl.LmisOvertimeMonthlyModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="LmisOvertimeMonthlyPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisOvertimeMonthlyPersistenceImpl extends BasePersistenceImpl
	implements LmisOvertimeMonthlyPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = LmisOvertimeMonthlyImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_OVERTIMEMONTHLYOF = new FinderPath(LmisOvertimeMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeMonthlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOvertimeMonthlyOf",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_OVERTIMEMONTHLYOF = new FinderPath(LmisOvertimeMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeMonthlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOvertimeMonthlyOf",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_OVERTIMEMONTHLYOF = new FinderPath(LmisOvertimeMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeMonthlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByOvertimeMonthlyOf",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_USERID = new FinderPath(LmisOvertimeMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeMonthlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByUserID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_USERID = new FinderPath(LmisOvertimeMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeMonthlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByUserID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(LmisOvertimeMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeMonthlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByUserID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ORGID = new FinderPath(LmisOvertimeMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeMonthlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOrgID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ORGID = new FinderPath(LmisOvertimeMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeMonthlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOrgID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGID = new FinderPath(LmisOvertimeMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeMonthlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByOrgID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OTID = new FinderPath(LmisOvertimeMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeMonthlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOtID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_OTID = new FinderPath(LmisOvertimeMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeMonthlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOtID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_OTID = new FinderPath(LmisOvertimeMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeMonthlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByOtID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_MONTHVALUE = new FinderPath(LmisOvertimeMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeMonthlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByMonthValue",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_MONTHVALUE = new FinderPath(LmisOvertimeMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeMonthlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByMonthValue",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_MONTHVALUE = new FinderPath(LmisOvertimeMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeMonthlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByMonthValue",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_YEARVALUE = new FinderPath(LmisOvertimeMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeMonthlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByYearValue",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_YEARVALUE = new FinderPath(LmisOvertimeMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeMonthlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByYearValue",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_YEARVALUE = new FinderPath(LmisOvertimeMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeMonthlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByYearValue",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(LmisOvertimeMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeMonthlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LmisOvertimeMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeMonthlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(LmisOvertimeMonthly lmisOvertimeMonthly) {
		EntityCacheUtil.putResult(LmisOvertimeMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeMonthlyImpl.class, lmisOvertimeMonthly.getPrimaryKey(),
			lmisOvertimeMonthly);
	}

	public void cacheResult(List<LmisOvertimeMonthly> lmisOvertimeMonthlies) {
		for (LmisOvertimeMonthly lmisOvertimeMonthly : lmisOvertimeMonthlies) {
			if (EntityCacheUtil.getResult(
						LmisOvertimeMonthlyModelImpl.ENTITY_CACHE_ENABLED,
						LmisOvertimeMonthlyImpl.class,
						lmisOvertimeMonthly.getPrimaryKey(), this) == null) {
				cacheResult(lmisOvertimeMonthly);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(LmisOvertimeMonthlyImpl.class.getName());
		EntityCacheUtil.clearCache(LmisOvertimeMonthlyImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public LmisOvertimeMonthly create(Integer lmisOvertimeMonthlyId) {
		LmisOvertimeMonthly lmisOvertimeMonthly = new LmisOvertimeMonthlyImpl();

		lmisOvertimeMonthly.setNew(true);
		lmisOvertimeMonthly.setPrimaryKey(lmisOvertimeMonthlyId);

		return lmisOvertimeMonthly;
	}

	public LmisOvertimeMonthly remove(Integer lmisOvertimeMonthlyId)
		throws NoSuchLmisOvertimeMonthlyException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LmisOvertimeMonthly lmisOvertimeMonthly = (LmisOvertimeMonthly)session.get(LmisOvertimeMonthlyImpl.class,
					lmisOvertimeMonthlyId);

			if (lmisOvertimeMonthly == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No LmisOvertimeMonthly exists with the primary key " +
						lmisOvertimeMonthlyId);
				}

				throw new NoSuchLmisOvertimeMonthlyException(
					"No LmisOvertimeMonthly exists with the primary key " +
					lmisOvertimeMonthlyId);
			}

			return remove(lmisOvertimeMonthly);
		}
		catch (NoSuchLmisOvertimeMonthlyException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public LmisOvertimeMonthly remove(LmisOvertimeMonthly lmisOvertimeMonthly)
		throws SystemException {
		for (ModelListener<LmisOvertimeMonthly> listener : listeners) {
			listener.onBeforeRemove(lmisOvertimeMonthly);
		}

		lmisOvertimeMonthly = removeImpl(lmisOvertimeMonthly);

		for (ModelListener<LmisOvertimeMonthly> listener : listeners) {
			listener.onAfterRemove(lmisOvertimeMonthly);
		}

		return lmisOvertimeMonthly;
	}

	protected LmisOvertimeMonthly removeImpl(
		LmisOvertimeMonthly lmisOvertimeMonthly) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (lmisOvertimeMonthly.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(LmisOvertimeMonthlyImpl.class,
						lmisOvertimeMonthly.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(lmisOvertimeMonthly);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(LmisOvertimeMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeMonthlyImpl.class, lmisOvertimeMonthly.getPrimaryKey());

		return lmisOvertimeMonthly;
	}

	public LmisOvertimeMonthly update(LmisOvertimeMonthly lmisOvertimeMonthly)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(LmisOvertimeMonthly lmisOvertimeMonthly) method. Use update(LmisOvertimeMonthly lmisOvertimeMonthly, boolean merge) instead.");
		}

		return update(lmisOvertimeMonthly, false);
	}

	public LmisOvertimeMonthly update(LmisOvertimeMonthly lmisOvertimeMonthly,
		boolean merge) throws SystemException {
		boolean isNew = lmisOvertimeMonthly.isNew();

		for (ModelListener<LmisOvertimeMonthly> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(lmisOvertimeMonthly);
			}
			else {
				listener.onBeforeUpdate(lmisOvertimeMonthly);
			}
		}

		lmisOvertimeMonthly = updateImpl(lmisOvertimeMonthly, merge);

		for (ModelListener<LmisOvertimeMonthly> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(lmisOvertimeMonthly);
			}
			else {
				listener.onAfterUpdate(lmisOvertimeMonthly);
			}
		}

		return lmisOvertimeMonthly;
	}

	public LmisOvertimeMonthly updateImpl(
		larion.progate.lmis.model.LmisOvertimeMonthly lmisOvertimeMonthly,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, lmisOvertimeMonthly, merge);

			lmisOvertimeMonthly.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(LmisOvertimeMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeMonthlyImpl.class, lmisOvertimeMonthly.getPrimaryKey(),
			lmisOvertimeMonthly);

		return lmisOvertimeMonthly;
	}

	public LmisOvertimeMonthly findByPrimaryKey(Integer lmisOvertimeMonthlyId)
		throws NoSuchLmisOvertimeMonthlyException, SystemException {
		LmisOvertimeMonthly lmisOvertimeMonthly = fetchByPrimaryKey(lmisOvertimeMonthlyId);

		if (lmisOvertimeMonthly == null) {
			if (_log.isWarnEnabled()) {
				_log.warn("No LmisOvertimeMonthly exists with the primary key " +
					lmisOvertimeMonthlyId);
			}

			throw new NoSuchLmisOvertimeMonthlyException(
				"No LmisOvertimeMonthly exists with the primary key " +
				lmisOvertimeMonthlyId);
		}

		return lmisOvertimeMonthly;
	}

	public LmisOvertimeMonthly fetchByPrimaryKey(Integer lmisOvertimeMonthlyId)
		throws SystemException {
		LmisOvertimeMonthly lmisOvertimeMonthly = (LmisOvertimeMonthly)EntityCacheUtil.getResult(LmisOvertimeMonthlyModelImpl.ENTITY_CACHE_ENABLED,
				LmisOvertimeMonthlyImpl.class, lmisOvertimeMonthlyId, this);

		if (lmisOvertimeMonthly == null) {
			Session session = null;

			try {
				session = openSession();

				lmisOvertimeMonthly = (LmisOvertimeMonthly)session.get(LmisOvertimeMonthlyImpl.class,
						lmisOvertimeMonthlyId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (lmisOvertimeMonthly != null) {
					cacheResult(lmisOvertimeMonthly);
				}

				closeSession(session);
			}
		}

		return lmisOvertimeMonthly;
	}

	public List<LmisOvertimeMonthly> findByOvertimeMonthlyOf(int rootId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		List<LmisOvertimeMonthly> list = (List<LmisOvertimeMonthly>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OVERTIMEMONTHLYOF,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOvertimeMonthly WHERE ");

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
					list = new ArrayList<LmisOvertimeMonthly>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OVERTIMEMONTHLYOF,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisOvertimeMonthly> findByOvertimeMonthlyOf(int rootId,
		int start, int end) throws SystemException {
		return findByOvertimeMonthlyOf(rootId, start, end, null);
	}

	public List<LmisOvertimeMonthly> findByOvertimeMonthlyOf(int rootId,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(rootId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisOvertimeMonthly> list = (List<LmisOvertimeMonthly>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_OVERTIMEMONTHLYOF,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOvertimeMonthly WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rootId);

				list = (List<LmisOvertimeMonthly>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisOvertimeMonthly>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_OVERTIMEMONTHLYOF,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisOvertimeMonthly findByOvertimeMonthlyOf_First(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisOvertimeMonthlyException, SystemException {
		List<LmisOvertimeMonthly> list = findByOvertimeMonthlyOf(rootId, 0, 1,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOvertimeMonthly exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOvertimeMonthlyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOvertimeMonthly findByOvertimeMonthlyOf_Last(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisOvertimeMonthlyException, SystemException {
		int count = countByOvertimeMonthlyOf(rootId);

		List<LmisOvertimeMonthly> list = findByOvertimeMonthlyOf(rootId,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOvertimeMonthly exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOvertimeMonthlyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOvertimeMonthly[] findByOvertimeMonthlyOf_PrevAndNext(
		Integer lmisOvertimeMonthlyId, int rootId, OrderByComparator obc)
		throws NoSuchLmisOvertimeMonthlyException, SystemException {
		LmisOvertimeMonthly lmisOvertimeMonthly = findByPrimaryKey(lmisOvertimeMonthlyId);

		int count = countByOvertimeMonthlyOf(rootId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisOvertimeMonthly WHERE ");

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
					lmisOvertimeMonthly);

			LmisOvertimeMonthly[] array = new LmisOvertimeMonthlyImpl[3];

			array[0] = (LmisOvertimeMonthly)objArray[0];
			array[1] = (LmisOvertimeMonthly)objArray[1];
			array[2] = (LmisOvertimeMonthly)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisOvertimeMonthly> findByUserID(int userId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(userId) };

		List<LmisOvertimeMonthly> list = (List<LmisOvertimeMonthly>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_USERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOvertimeMonthly WHERE ");

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
					list = new ArrayList<LmisOvertimeMonthly>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_USERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisOvertimeMonthly> findByUserID(int userId, int start, int end)
		throws SystemException {
		return findByUserID(userId, start, end, null);
	}

	public List<LmisOvertimeMonthly> findByUserID(int userId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(userId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisOvertimeMonthly> list = (List<LmisOvertimeMonthly>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_USERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOvertimeMonthly WHERE ");

				query.append("user_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				list = (List<LmisOvertimeMonthly>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisOvertimeMonthly>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_USERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisOvertimeMonthly findByUserID_First(int userId,
		OrderByComparator obc)
		throws NoSuchLmisOvertimeMonthlyException, SystemException {
		List<LmisOvertimeMonthly> list = findByUserID(userId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOvertimeMonthly exists with the key {");

			msg.append("userId=" + userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOvertimeMonthlyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOvertimeMonthly findByUserID_Last(int userId,
		OrderByComparator obc)
		throws NoSuchLmisOvertimeMonthlyException, SystemException {
		int count = countByUserID(userId);

		List<LmisOvertimeMonthly> list = findByUserID(userId, count - 1, count,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOvertimeMonthly exists with the key {");

			msg.append("userId=" + userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOvertimeMonthlyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOvertimeMonthly[] findByUserID_PrevAndNext(
		Integer lmisOvertimeMonthlyId, int userId, OrderByComparator obc)
		throws NoSuchLmisOvertimeMonthlyException, SystemException {
		LmisOvertimeMonthly lmisOvertimeMonthly = findByPrimaryKey(lmisOvertimeMonthlyId);

		int count = countByUserID(userId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisOvertimeMonthly WHERE ");

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
					lmisOvertimeMonthly);

			LmisOvertimeMonthly[] array = new LmisOvertimeMonthlyImpl[3];

			array[0] = (LmisOvertimeMonthly)objArray[0];
			array[1] = (LmisOvertimeMonthly)objArray[1];
			array[2] = (LmisOvertimeMonthly)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisOvertimeMonthly> findByOrgID(int orgId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(orgId) };

		List<LmisOvertimeMonthly> list = (List<LmisOvertimeMonthly>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ORGID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOvertimeMonthly WHERE ");

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
					list = new ArrayList<LmisOvertimeMonthly>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ORGID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisOvertimeMonthly> findByOrgID(int orgId, int start, int end)
		throws SystemException {
		return findByOrgID(orgId, start, end, null);
	}

	public List<LmisOvertimeMonthly> findByOrgID(int orgId, int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(orgId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisOvertimeMonthly> list = (List<LmisOvertimeMonthly>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ORGID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOvertimeMonthly WHERE ");

				query.append("org_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orgId);

				list = (List<LmisOvertimeMonthly>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisOvertimeMonthly>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ORGID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisOvertimeMonthly findByOrgID_First(int orgId,
		OrderByComparator obc)
		throws NoSuchLmisOvertimeMonthlyException, SystemException {
		List<LmisOvertimeMonthly> list = findByOrgID(orgId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOvertimeMonthly exists with the key {");

			msg.append("orgId=" + orgId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOvertimeMonthlyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOvertimeMonthly findByOrgID_Last(int orgId, OrderByComparator obc)
		throws NoSuchLmisOvertimeMonthlyException, SystemException {
		int count = countByOrgID(orgId);

		List<LmisOvertimeMonthly> list = findByOrgID(orgId, count - 1, count,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOvertimeMonthly exists with the key {");

			msg.append("orgId=" + orgId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOvertimeMonthlyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOvertimeMonthly[] findByOrgID_PrevAndNext(
		Integer lmisOvertimeMonthlyId, int orgId, OrderByComparator obc)
		throws NoSuchLmisOvertimeMonthlyException, SystemException {
		LmisOvertimeMonthly lmisOvertimeMonthly = findByPrimaryKey(lmisOvertimeMonthlyId);

		int count = countByOrgID(orgId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisOvertimeMonthly WHERE ");

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
					lmisOvertimeMonthly);

			LmisOvertimeMonthly[] array = new LmisOvertimeMonthlyImpl[3];

			array[0] = (LmisOvertimeMonthly)objArray[0];
			array[1] = (LmisOvertimeMonthly)objArray[1];
			array[2] = (LmisOvertimeMonthly)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisOvertimeMonthly> findByOtID(int otId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(otId) };

		List<LmisOvertimeMonthly> list = (List<LmisOvertimeMonthly>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOvertimeMonthly WHERE ");

				query.append("ot_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(otId);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisOvertimeMonthly>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OTID, finderArgs,
					list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisOvertimeMonthly> findByOtID(int otId, int start, int end)
		throws SystemException {
		return findByOtID(otId, start, end, null);
	}

	public List<LmisOvertimeMonthly> findByOtID(int otId, int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(otId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisOvertimeMonthly> list = (List<LmisOvertimeMonthly>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_OTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOvertimeMonthly WHERE ");

				query.append("ot_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(otId);

				list = (List<LmisOvertimeMonthly>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisOvertimeMonthly>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_OTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisOvertimeMonthly findByOtID_First(int otId, OrderByComparator obc)
		throws NoSuchLmisOvertimeMonthlyException, SystemException {
		List<LmisOvertimeMonthly> list = findByOtID(otId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOvertimeMonthly exists with the key {");

			msg.append("otId=" + otId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOvertimeMonthlyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOvertimeMonthly findByOtID_Last(int otId, OrderByComparator obc)
		throws NoSuchLmisOvertimeMonthlyException, SystemException {
		int count = countByOtID(otId);

		List<LmisOvertimeMonthly> list = findByOtID(otId, count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOvertimeMonthly exists with the key {");

			msg.append("otId=" + otId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOvertimeMonthlyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOvertimeMonthly[] findByOtID_PrevAndNext(
		Integer lmisOvertimeMonthlyId, int otId, OrderByComparator obc)
		throws NoSuchLmisOvertimeMonthlyException, SystemException {
		LmisOvertimeMonthly lmisOvertimeMonthly = findByPrimaryKey(lmisOvertimeMonthlyId);

		int count = countByOtID(otId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisOvertimeMonthly WHERE ");

			query.append("ot_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(otId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisOvertimeMonthly);

			LmisOvertimeMonthly[] array = new LmisOvertimeMonthlyImpl[3];

			array[0] = (LmisOvertimeMonthly)objArray[0];
			array[1] = (LmisOvertimeMonthly)objArray[1];
			array[2] = (LmisOvertimeMonthly)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisOvertimeMonthly> findByMonthValue(int monthValue)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(monthValue) };

		List<LmisOvertimeMonthly> list = (List<LmisOvertimeMonthly>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_MONTHVALUE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOvertimeMonthly WHERE ");

				query.append("month_value = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(monthValue);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisOvertimeMonthly>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_MONTHVALUE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisOvertimeMonthly> findByMonthValue(int monthValue,
		int start, int end) throws SystemException {
		return findByMonthValue(monthValue, start, end, null);
	}

	public List<LmisOvertimeMonthly> findByMonthValue(int monthValue,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(monthValue),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisOvertimeMonthly> list = (List<LmisOvertimeMonthly>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_MONTHVALUE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOvertimeMonthly WHERE ");

				query.append("month_value = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(monthValue);

				list = (List<LmisOvertimeMonthly>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisOvertimeMonthly>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_MONTHVALUE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisOvertimeMonthly findByMonthValue_First(int monthValue,
		OrderByComparator obc)
		throws NoSuchLmisOvertimeMonthlyException, SystemException {
		List<LmisOvertimeMonthly> list = findByMonthValue(monthValue, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOvertimeMonthly exists with the key {");

			msg.append("monthValue=" + monthValue);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOvertimeMonthlyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOvertimeMonthly findByMonthValue_Last(int monthValue,
		OrderByComparator obc)
		throws NoSuchLmisOvertimeMonthlyException, SystemException {
		int count = countByMonthValue(monthValue);

		List<LmisOvertimeMonthly> list = findByMonthValue(monthValue,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOvertimeMonthly exists with the key {");

			msg.append("monthValue=" + monthValue);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOvertimeMonthlyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOvertimeMonthly[] findByMonthValue_PrevAndNext(
		Integer lmisOvertimeMonthlyId, int monthValue, OrderByComparator obc)
		throws NoSuchLmisOvertimeMonthlyException, SystemException {
		LmisOvertimeMonthly lmisOvertimeMonthly = findByPrimaryKey(lmisOvertimeMonthlyId);

		int count = countByMonthValue(monthValue);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisOvertimeMonthly WHERE ");

			query.append("month_value = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(monthValue);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisOvertimeMonthly);

			LmisOvertimeMonthly[] array = new LmisOvertimeMonthlyImpl[3];

			array[0] = (LmisOvertimeMonthly)objArray[0];
			array[1] = (LmisOvertimeMonthly)objArray[1];
			array[2] = (LmisOvertimeMonthly)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisOvertimeMonthly> findByYearValue(int yearValue)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(yearValue) };

		List<LmisOvertimeMonthly> list = (List<LmisOvertimeMonthly>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_YEARVALUE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOvertimeMonthly WHERE ");

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
					list = new ArrayList<LmisOvertimeMonthly>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_YEARVALUE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisOvertimeMonthly> findByYearValue(int yearValue, int start,
		int end) throws SystemException {
		return findByYearValue(yearValue, start, end, null);
	}

	public List<LmisOvertimeMonthly> findByYearValue(int yearValue, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(yearValue),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisOvertimeMonthly> list = (List<LmisOvertimeMonthly>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_YEARVALUE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOvertimeMonthly WHERE ");

				query.append("year_value = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(yearValue);

				list = (List<LmisOvertimeMonthly>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisOvertimeMonthly>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_YEARVALUE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisOvertimeMonthly findByYearValue_First(int yearValue,
		OrderByComparator obc)
		throws NoSuchLmisOvertimeMonthlyException, SystemException {
		List<LmisOvertimeMonthly> list = findByYearValue(yearValue, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOvertimeMonthly exists with the key {");

			msg.append("yearValue=" + yearValue);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOvertimeMonthlyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOvertimeMonthly findByYearValue_Last(int yearValue,
		OrderByComparator obc)
		throws NoSuchLmisOvertimeMonthlyException, SystemException {
		int count = countByYearValue(yearValue);

		List<LmisOvertimeMonthly> list = findByYearValue(yearValue, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOvertimeMonthly exists with the key {");

			msg.append("yearValue=" + yearValue);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOvertimeMonthlyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOvertimeMonthly[] findByYearValue_PrevAndNext(
		Integer lmisOvertimeMonthlyId, int yearValue, OrderByComparator obc)
		throws NoSuchLmisOvertimeMonthlyException, SystemException {
		LmisOvertimeMonthly lmisOvertimeMonthly = findByPrimaryKey(lmisOvertimeMonthlyId);

		int count = countByYearValue(yearValue);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisOvertimeMonthly WHERE ");

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
					lmisOvertimeMonthly);

			LmisOvertimeMonthly[] array = new LmisOvertimeMonthlyImpl[3];

			array[0] = (LmisOvertimeMonthly)objArray[0];
			array[1] = (LmisOvertimeMonthly)objArray[1];
			array[2] = (LmisOvertimeMonthly)objArray[2];

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

	public List<LmisOvertimeMonthly> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<LmisOvertimeMonthly> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<LmisOvertimeMonthly> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisOvertimeMonthly> list = (List<LmisOvertimeMonthly>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOvertimeMonthly ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<LmisOvertimeMonthly>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LmisOvertimeMonthly>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisOvertimeMonthly>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByOvertimeMonthlyOf(int rootId) throws SystemException {
		for (LmisOvertimeMonthly lmisOvertimeMonthly : findByOvertimeMonthlyOf(
				rootId)) {
			remove(lmisOvertimeMonthly);
		}
	}

	public void removeByUserID(int userId) throws SystemException {
		for (LmisOvertimeMonthly lmisOvertimeMonthly : findByUserID(userId)) {
			remove(lmisOvertimeMonthly);
		}
	}

	public void removeByOrgID(int orgId) throws SystemException {
		for (LmisOvertimeMonthly lmisOvertimeMonthly : findByOrgID(orgId)) {
			remove(lmisOvertimeMonthly);
		}
	}

	public void removeByOtID(int otId) throws SystemException {
		for (LmisOvertimeMonthly lmisOvertimeMonthly : findByOtID(otId)) {
			remove(lmisOvertimeMonthly);
		}
	}

	public void removeByMonthValue(int monthValue) throws SystemException {
		for (LmisOvertimeMonthly lmisOvertimeMonthly : findByMonthValue(
				monthValue)) {
			remove(lmisOvertimeMonthly);
		}
	}

	public void removeByYearValue(int yearValue) throws SystemException {
		for (LmisOvertimeMonthly lmisOvertimeMonthly : findByYearValue(
				yearValue)) {
			remove(lmisOvertimeMonthly);
		}
	}

	public void removeAll() throws SystemException {
		for (LmisOvertimeMonthly lmisOvertimeMonthly : findAll()) {
			remove(lmisOvertimeMonthly);
		}
	}

	public int countByOvertimeMonthlyOf(int rootId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_OVERTIMEMONTHLYOF,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisOvertimeMonthly WHERE ");

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_OVERTIMEMONTHLYOF,
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
					"FROM larion.progate.lmis.model.LmisOvertimeMonthly WHERE ");

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
					"FROM larion.progate.lmis.model.LmisOvertimeMonthly WHERE ");

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

	public int countByOtID(int otId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(otId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_OTID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisOvertimeMonthly WHERE ");

				query.append("ot_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(otId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_OTID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByMonthValue(int monthValue) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(monthValue) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MONTHVALUE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisOvertimeMonthly WHERE ");

				query.append("month_value = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(monthValue);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MONTHVALUE,
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
					"FROM larion.progate.lmis.model.LmisOvertimeMonthly WHERE ");

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
						"SELECT COUNT(*) FROM larion.progate.lmis.model.LmisOvertimeMonthly");

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
						"value.object.listener.larion.progate.lmis.model.LmisOvertimeMonthly")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LmisOvertimeMonthly>> listenersList = new ArrayList<ModelListener<LmisOvertimeMonthly>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LmisOvertimeMonthly>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(LmisOvertimeMonthlyPersistenceImpl.class);
}