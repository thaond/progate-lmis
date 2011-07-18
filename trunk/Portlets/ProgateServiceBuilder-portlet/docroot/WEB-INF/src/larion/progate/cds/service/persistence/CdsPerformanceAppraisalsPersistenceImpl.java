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

package larion.progate.cds.service.persistence;

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

import larion.progate.cds.NoSuchCdsPerformanceAppraisalsException;
import larion.progate.cds.model.CdsPerformanceAppraisals;
import larion.progate.cds.model.impl.CdsPerformanceAppraisalsImpl;
import larion.progate.cds.model.impl.CdsPerformanceAppraisalsModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="CdsPerformanceAppraisalsPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsPerformanceAppraisalsPersistenceImpl extends BasePersistenceImpl
	implements CdsPerformanceAppraisalsPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = CdsPerformanceAppraisalsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_PERIODID = new FinderPath(CdsPerformanceAppraisalsModelImpl.ENTITY_CACHE_ENABLED,
			CdsPerformanceAppraisalsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByPeriodId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_PERIODID = new FinderPath(CdsPerformanceAppraisalsModelImpl.ENTITY_CACHE_ENABLED,
			CdsPerformanceAppraisalsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByPeriodId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_PERIODID = new FinderPath(CdsPerformanceAppraisalsModelImpl.ENTITY_CACHE_ENABLED,
			CdsPerformanceAppraisalsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByPeriodId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_USERID = new FinderPath(CdsPerformanceAppraisalsModelImpl.ENTITY_CACHE_ENABLED,
			CdsPerformanceAppraisalsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByUserId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_USERID = new FinderPath(CdsPerformanceAppraisalsModelImpl.ENTITY_CACHE_ENABLED,
			CdsPerformanceAppraisalsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByUserId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(CdsPerformanceAppraisalsModelImpl.ENTITY_CACHE_ENABLED,
			CdsPerformanceAppraisalsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByUserId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ROOTID = new FinderPath(CdsPerformanceAppraisalsModelImpl.ENTITY_CACHE_ENABLED,
			CdsPerformanceAppraisalsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ROOTID = new FinderPath(CdsPerformanceAppraisalsModelImpl.ENTITY_CACHE_ENABLED,
			CdsPerformanceAppraisalsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ROOTID = new FinderPath(CdsPerformanceAppraisalsModelImpl.ENTITY_CACHE_ENABLED,
			CdsPerformanceAppraisalsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByRootId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(CdsPerformanceAppraisalsModelImpl.ENTITY_CACHE_ENABLED,
			CdsPerformanceAppraisalsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CdsPerformanceAppraisalsModelImpl.ENTITY_CACHE_ENABLED,
			CdsPerformanceAppraisalsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(CdsPerformanceAppraisals cdsPerformanceAppraisals) {
		EntityCacheUtil.putResult(CdsPerformanceAppraisalsModelImpl.ENTITY_CACHE_ENABLED,
			CdsPerformanceAppraisalsImpl.class,
			cdsPerformanceAppraisals.getPrimaryKey(), cdsPerformanceAppraisals);
	}

	public void cacheResult(
		List<CdsPerformanceAppraisals> cdsPerformanceAppraisalses) {
		for (CdsPerformanceAppraisals cdsPerformanceAppraisals : cdsPerformanceAppraisalses) {
			if (EntityCacheUtil.getResult(
						CdsPerformanceAppraisalsModelImpl.ENTITY_CACHE_ENABLED,
						CdsPerformanceAppraisalsImpl.class,
						cdsPerformanceAppraisals.getPrimaryKey(), this) == null) {
				cacheResult(cdsPerformanceAppraisals);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(CdsPerformanceAppraisalsImpl.class.getName());
		EntityCacheUtil.clearCache(CdsPerformanceAppraisalsImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public CdsPerformanceAppraisals create(Integer cdsPerformanceAppraisalsId) {
		CdsPerformanceAppraisals cdsPerformanceAppraisals = new CdsPerformanceAppraisalsImpl();

		cdsPerformanceAppraisals.setNew(true);
		cdsPerformanceAppraisals.setPrimaryKey(cdsPerformanceAppraisalsId);

		return cdsPerformanceAppraisals;
	}

	public CdsPerformanceAppraisals remove(Integer cdsPerformanceAppraisalsId)
		throws NoSuchCdsPerformanceAppraisalsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CdsPerformanceAppraisals cdsPerformanceAppraisals = (CdsPerformanceAppraisals)session.get(CdsPerformanceAppraisalsImpl.class,
					cdsPerformanceAppraisalsId);

			if (cdsPerformanceAppraisals == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No CdsPerformanceAppraisals exists with the primary key " +
						cdsPerformanceAppraisalsId);
				}

				throw new NoSuchCdsPerformanceAppraisalsException(
					"No CdsPerformanceAppraisals exists with the primary key " +
					cdsPerformanceAppraisalsId);
			}

			return remove(cdsPerformanceAppraisals);
		}
		catch (NoSuchCdsPerformanceAppraisalsException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public CdsPerformanceAppraisals remove(
		CdsPerformanceAppraisals cdsPerformanceAppraisals)
		throws SystemException {
		for (ModelListener<CdsPerformanceAppraisals> listener : listeners) {
			listener.onBeforeRemove(cdsPerformanceAppraisals);
		}

		cdsPerformanceAppraisals = removeImpl(cdsPerformanceAppraisals);

		for (ModelListener<CdsPerformanceAppraisals> listener : listeners) {
			listener.onAfterRemove(cdsPerformanceAppraisals);
		}

		return cdsPerformanceAppraisals;
	}

	protected CdsPerformanceAppraisals removeImpl(
		CdsPerformanceAppraisals cdsPerformanceAppraisals)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (cdsPerformanceAppraisals.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(CdsPerformanceAppraisalsImpl.class,
						cdsPerformanceAppraisals.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(cdsPerformanceAppraisals);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(CdsPerformanceAppraisalsModelImpl.ENTITY_CACHE_ENABLED,
			CdsPerformanceAppraisalsImpl.class,
			cdsPerformanceAppraisals.getPrimaryKey());

		return cdsPerformanceAppraisals;
	}

	public CdsPerformanceAppraisals update(
		CdsPerformanceAppraisals cdsPerformanceAppraisals)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(CdsPerformanceAppraisals cdsPerformanceAppraisals) method. Use update(CdsPerformanceAppraisals cdsPerformanceAppraisals, boolean merge) instead.");
		}

		return update(cdsPerformanceAppraisals, false);
	}

	public CdsPerformanceAppraisals update(
		CdsPerformanceAppraisals cdsPerformanceAppraisals, boolean merge)
		throws SystemException {
		boolean isNew = cdsPerformanceAppraisals.isNew();

		for (ModelListener<CdsPerformanceAppraisals> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(cdsPerformanceAppraisals);
			}
			else {
				listener.onBeforeUpdate(cdsPerformanceAppraisals);
			}
		}

		cdsPerformanceAppraisals = updateImpl(cdsPerformanceAppraisals, merge);

		for (ModelListener<CdsPerformanceAppraisals> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(cdsPerformanceAppraisals);
			}
			else {
				listener.onAfterUpdate(cdsPerformanceAppraisals);
			}
		}

		return cdsPerformanceAppraisals;
	}

	public CdsPerformanceAppraisals updateImpl(
		larion.progate.cds.model.CdsPerformanceAppraisals cdsPerformanceAppraisals,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, cdsPerformanceAppraisals, merge);

			cdsPerformanceAppraisals.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(CdsPerformanceAppraisalsModelImpl.ENTITY_CACHE_ENABLED,
			CdsPerformanceAppraisalsImpl.class,
			cdsPerformanceAppraisals.getPrimaryKey(), cdsPerformanceAppraisals);

		return cdsPerformanceAppraisals;
	}

	public CdsPerformanceAppraisals findByPrimaryKey(
		Integer cdsPerformanceAppraisalsId)
		throws NoSuchCdsPerformanceAppraisalsException, SystemException {
		CdsPerformanceAppraisals cdsPerformanceAppraisals = fetchByPrimaryKey(cdsPerformanceAppraisalsId);

		if (cdsPerformanceAppraisals == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"No CdsPerformanceAppraisals exists with the primary key " +
					cdsPerformanceAppraisalsId);
			}

			throw new NoSuchCdsPerformanceAppraisalsException(
				"No CdsPerformanceAppraisals exists with the primary key " +
				cdsPerformanceAppraisalsId);
		}

		return cdsPerformanceAppraisals;
	}

	public CdsPerformanceAppraisals fetchByPrimaryKey(
		Integer cdsPerformanceAppraisalsId) throws SystemException {
		CdsPerformanceAppraisals cdsPerformanceAppraisals = (CdsPerformanceAppraisals)EntityCacheUtil.getResult(CdsPerformanceAppraisalsModelImpl.ENTITY_CACHE_ENABLED,
				CdsPerformanceAppraisalsImpl.class, cdsPerformanceAppraisalsId,
				this);

		if (cdsPerformanceAppraisals == null) {
			Session session = null;

			try {
				session = openSession();

				cdsPerformanceAppraisals = (CdsPerformanceAppraisals)session.get(CdsPerformanceAppraisalsImpl.class,
						cdsPerformanceAppraisalsId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (cdsPerformanceAppraisals != null) {
					cacheResult(cdsPerformanceAppraisals);
				}

				closeSession(session);
			}
		}

		return cdsPerformanceAppraisals;
	}

	public List<CdsPerformanceAppraisals> findByPeriodId(int periodId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(periodId) };

		List<CdsPerformanceAppraisals> list = (List<CdsPerformanceAppraisals>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_PERIODID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.CdsPerformanceAppraisals WHERE ");

				query.append("period_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(periodId);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsPerformanceAppraisals>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_PERIODID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<CdsPerformanceAppraisals> findByPeriodId(int periodId,
		int start, int end) throws SystemException {
		return findByPeriodId(periodId, start, end, null);
	}

	public List<CdsPerformanceAppraisals> findByPeriodId(int periodId,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(periodId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<CdsPerformanceAppraisals> list = (List<CdsPerformanceAppraisals>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_PERIODID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.CdsPerformanceAppraisals WHERE ");

				query.append("period_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(periodId);

				list = (List<CdsPerformanceAppraisals>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsPerformanceAppraisals>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_PERIODID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public CdsPerformanceAppraisals findByPeriodId_First(int periodId,
		OrderByComparator obc)
		throws NoSuchCdsPerformanceAppraisalsException, SystemException {
		List<CdsPerformanceAppraisals> list = findByPeriodId(periodId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No CdsPerformanceAppraisals exists with the key {");

			msg.append("periodId=" + periodId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsPerformanceAppraisalsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsPerformanceAppraisals findByPeriodId_Last(int periodId,
		OrderByComparator obc)
		throws NoSuchCdsPerformanceAppraisalsException, SystemException {
		int count = countByPeriodId(periodId);

		List<CdsPerformanceAppraisals> list = findByPeriodId(periodId,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No CdsPerformanceAppraisals exists with the key {");

			msg.append("periodId=" + periodId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsPerformanceAppraisalsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsPerformanceAppraisals[] findByPeriodId_PrevAndNext(
		Integer cdsPerformanceAppraisalsId, int periodId, OrderByComparator obc)
		throws NoSuchCdsPerformanceAppraisalsException, SystemException {
		CdsPerformanceAppraisals cdsPerformanceAppraisals = findByPrimaryKey(cdsPerformanceAppraisalsId);

		int count = countByPeriodId(periodId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.cds.model.CdsPerformanceAppraisals WHERE ");

			query.append("period_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(periodId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					cdsPerformanceAppraisals);

			CdsPerformanceAppraisals[] array = new CdsPerformanceAppraisalsImpl[3];

			array[0] = (CdsPerformanceAppraisals)objArray[0];
			array[1] = (CdsPerformanceAppraisals)objArray[1];
			array[2] = (CdsPerformanceAppraisals)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<CdsPerformanceAppraisals> findByUserId(int userId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(userId) };

		List<CdsPerformanceAppraisals> list = (List<CdsPerformanceAppraisals>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_USERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.CdsPerformanceAppraisals WHERE ");

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
					list = new ArrayList<CdsPerformanceAppraisals>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_USERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<CdsPerformanceAppraisals> findByUserId(int userId, int start,
		int end) throws SystemException {
		return findByUserId(userId, start, end, null);
	}

	public List<CdsPerformanceAppraisals> findByUserId(int userId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(userId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<CdsPerformanceAppraisals> list = (List<CdsPerformanceAppraisals>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_USERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.CdsPerformanceAppraisals WHERE ");

				query.append("user_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				list = (List<CdsPerformanceAppraisals>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsPerformanceAppraisals>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_USERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public CdsPerformanceAppraisals findByUserId_First(int userId,
		OrderByComparator obc)
		throws NoSuchCdsPerformanceAppraisalsException, SystemException {
		List<CdsPerformanceAppraisals> list = findByUserId(userId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No CdsPerformanceAppraisals exists with the key {");

			msg.append("userId=" + userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsPerformanceAppraisalsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsPerformanceAppraisals findByUserId_Last(int userId,
		OrderByComparator obc)
		throws NoSuchCdsPerformanceAppraisalsException, SystemException {
		int count = countByUserId(userId);

		List<CdsPerformanceAppraisals> list = findByUserId(userId, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No CdsPerformanceAppraisals exists with the key {");

			msg.append("userId=" + userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsPerformanceAppraisalsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsPerformanceAppraisals[] findByUserId_PrevAndNext(
		Integer cdsPerformanceAppraisalsId, int userId, OrderByComparator obc)
		throws NoSuchCdsPerformanceAppraisalsException, SystemException {
		CdsPerformanceAppraisals cdsPerformanceAppraisals = findByPrimaryKey(cdsPerformanceAppraisalsId);

		int count = countByUserId(userId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.cds.model.CdsPerformanceAppraisals WHERE ");

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
					cdsPerformanceAppraisals);

			CdsPerformanceAppraisals[] array = new CdsPerformanceAppraisalsImpl[3];

			array[0] = (CdsPerformanceAppraisals)objArray[0];
			array[1] = (CdsPerformanceAppraisals)objArray[1];
			array[2] = (CdsPerformanceAppraisals)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<CdsPerformanceAppraisals> findByRootId(int rootId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		List<CdsPerformanceAppraisals> list = (List<CdsPerformanceAppraisals>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.CdsPerformanceAppraisals WHERE ");

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
					list = new ArrayList<CdsPerformanceAppraisals>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<CdsPerformanceAppraisals> findByRootId(int rootId, int start,
		int end) throws SystemException {
		return findByRootId(rootId, start, end, null);
	}

	public List<CdsPerformanceAppraisals> findByRootId(int rootId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(rootId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<CdsPerformanceAppraisals> list = (List<CdsPerformanceAppraisals>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.CdsPerformanceAppraisals WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rootId);

				list = (List<CdsPerformanceAppraisals>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsPerformanceAppraisals>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public CdsPerformanceAppraisals findByRootId_First(int rootId,
		OrderByComparator obc)
		throws NoSuchCdsPerformanceAppraisalsException, SystemException {
		List<CdsPerformanceAppraisals> list = findByRootId(rootId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No CdsPerformanceAppraisals exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsPerformanceAppraisalsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsPerformanceAppraisals findByRootId_Last(int rootId,
		OrderByComparator obc)
		throws NoSuchCdsPerformanceAppraisalsException, SystemException {
		int count = countByRootId(rootId);

		List<CdsPerformanceAppraisals> list = findByRootId(rootId, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No CdsPerformanceAppraisals exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsPerformanceAppraisalsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsPerformanceAppraisals[] findByRootId_PrevAndNext(
		Integer cdsPerformanceAppraisalsId, int rootId, OrderByComparator obc)
		throws NoSuchCdsPerformanceAppraisalsException, SystemException {
		CdsPerformanceAppraisals cdsPerformanceAppraisals = findByPrimaryKey(cdsPerformanceAppraisalsId);

		int count = countByRootId(rootId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.cds.model.CdsPerformanceAppraisals WHERE ");

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
					cdsPerformanceAppraisals);

			CdsPerformanceAppraisals[] array = new CdsPerformanceAppraisalsImpl[3];

			array[0] = (CdsPerformanceAppraisals)objArray[0];
			array[1] = (CdsPerformanceAppraisals)objArray[1];
			array[2] = (CdsPerformanceAppraisals)objArray[2];

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

	public List<CdsPerformanceAppraisals> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<CdsPerformanceAppraisals> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<CdsPerformanceAppraisals> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<CdsPerformanceAppraisals> list = (List<CdsPerformanceAppraisals>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.CdsPerformanceAppraisals ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<CdsPerformanceAppraisals>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<CdsPerformanceAppraisals>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsPerformanceAppraisals>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByPeriodId(int periodId) throws SystemException {
		for (CdsPerformanceAppraisals cdsPerformanceAppraisals : findByPeriodId(
				periodId)) {
			remove(cdsPerformanceAppraisals);
		}
	}

	public void removeByUserId(int userId) throws SystemException {
		for (CdsPerformanceAppraisals cdsPerformanceAppraisals : findByUserId(
				userId)) {
			remove(cdsPerformanceAppraisals);
		}
	}

	public void removeByRootId(int rootId) throws SystemException {
		for (CdsPerformanceAppraisals cdsPerformanceAppraisals : findByRootId(
				rootId)) {
			remove(cdsPerformanceAppraisals);
		}
	}

	public void removeAll() throws SystemException {
		for (CdsPerformanceAppraisals cdsPerformanceAppraisals : findAll()) {
			remove(cdsPerformanceAppraisals);
		}
	}

	public int countByPeriodId(int periodId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(periodId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PERIODID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.cds.model.CdsPerformanceAppraisals WHERE ");

				query.append("period_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(periodId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PERIODID,
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
					"FROM larion.progate.cds.model.CdsPerformanceAppraisals WHERE ");

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
					"FROM larion.progate.cds.model.CdsPerformanceAppraisals WHERE ");

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

	public int countAll() throws SystemException {
		Object[] finderArgs = new Object[0];

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(
						"SELECT COUNT(*) FROM larion.progate.cds.model.CdsPerformanceAppraisals");

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
						"value.object.listener.larion.progate.cds.model.CdsPerformanceAppraisals")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CdsPerformanceAppraisals>> listenersList = new ArrayList<ModelListener<CdsPerformanceAppraisals>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CdsPerformanceAppraisals>)Class.forName(
							listenerClassName).newInstance());
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	@BeanReference(name = "larion.progate.cds.service.persistence.CompetencyPersistence.impl")
	protected larion.progate.cds.service.persistence.CompetencyPersistence competencyPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.LevelPersistence.impl")
	protected larion.progate.cds.service.persistence.LevelPersistence levelPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.SlotPersistence.impl")
	protected larion.progate.cds.service.persistence.SlotPersistence slotPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPointsPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsPointsPersistence cdsPointsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsEvaluationPeriodsPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsEvaluationPeriodsPersistence cdsEvaluationPeriodsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsTitlesPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsTitlesPersistence cdsTitlesPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsTitleCompetenciesPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsTitleCompetenciesPersistence cdsTitleCompetenciesPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsMinimumRequirementsPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsMinimumRequirementsPersistence cdsMinimumRequirementsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsTitleMinimumRequirementsPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsTitleMinimumRequirementsPersistence cdsTitleMinimumRequirementsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsMinimumRequirementLevelsPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsMinimumRequirementLevelsPersistence cdsMinimumRequirementLevelsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewListTitleCompetenciesPersistence.impl")
	protected larion.progate.cds.service.persistence.ViewListTitleCompetenciesPersistence viewListTitleCompetenciesPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewListTitleMinimumRequirementsPersistence.impl")
	protected larion.progate.cds.service.persistence.ViewListTitleMinimumRequirementsPersistence viewListTitleMinimumRequirementsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPAFinalCompeteniesPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsPAFinalCompeteniesPersistence cdsPAFinalCompeteniesPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPAFinalLevelsPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsPAFinalLevelsPersistence cdsPAFinalLevelsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPAFinalSlotsPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsPAFinalSlotsPersistence cdsPAFinalSlotsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewFinalCompetenciesPersistence.impl")
	protected larion.progate.cds.service.persistence.ViewFinalCompetenciesPersistence viewFinalCompetenciesPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewFinalLevelsPersistence.impl")
	protected larion.progate.cds.service.persistence.ViewFinalLevelsPersistence viewFinalLevelsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewFinalSlotsPersistence.impl")
	protected larion.progate.cds.service.persistence.ViewFinalSlotsPersistence viewFinalSlotsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewFinalTitlesPersistence.impl")
	protected larion.progate.cds.service.persistence.ViewFinalTitlesPersistence viewFinalTitlesPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewSlotInformationPersistence.impl")
	protected larion.progate.cds.service.persistence.ViewSlotInformationPersistence viewSlotInformationPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPASlotsPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsPASlotsPersistence cdsPASlotsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPALevelsPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsPALevelsPersistence cdsPALevelsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPACompetenciesPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsPACompetenciesPersistence cdsPACompetenciesPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewPerformanceAppraisalLevelsPersistence.impl")
	protected larion.progate.cds.service.persistence.ViewPerformanceAppraisalLevelsPersistence viewPerformanceAppraisalLevelsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewPerformanceAppraisalSlotsPersistence.impl")
	protected larion.progate.cds.service.persistence.ViewPerformanceAppraisalSlotsPersistence viewPerformanceAppraisalSlotsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPerformanceAppraisalSlotRatingPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsPerformanceAppraisalSlotRatingPersistence cdsPerformanceAppraisalSlotRatingPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPerformanceAppraisalSlotCommentsPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsPerformanceAppraisalSlotCommentsPersistence cdsPerformanceAppraisalSlotCommentsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPerformanceAppraisalsPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsPerformanceAppraisalsPersistence cdsPerformanceAppraisalsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewEmployeesInProjectsPersistence.impl")
	protected larion.progate.cds.service.persistence.ViewEmployeesInProjectsPersistence viewEmployeesInProjectsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewEmployeesSlotsRatingPersistence.impl")
	protected larion.progate.cds.service.persistence.ViewEmployeesSlotsRatingPersistence viewEmployeesSlotsRatingPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsSlotStatisticalReportPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsSlotStatisticalReportPersistence cdsSlotStatisticalReportPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsLevelStatisticalReportPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsLevelStatisticalReportPersistence cdsLevelStatisticalReportPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsCompetencyStatisticalReportPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsCompetencyStatisticalReportPersistence cdsCompetencyStatisticalReportPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsCdpPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsCdpPersistence cdsCdpPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPAFinalPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsPAFinalPersistence cdsPAFinalPersistence;
	private static Log _log = LogFactoryUtil.getLog(CdsPerformanceAppraisalsPersistenceImpl.class);
}