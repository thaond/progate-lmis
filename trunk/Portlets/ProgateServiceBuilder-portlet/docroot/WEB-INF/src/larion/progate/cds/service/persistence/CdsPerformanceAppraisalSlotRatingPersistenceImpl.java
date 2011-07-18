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

import larion.progate.cds.NoSuchCdsPerformanceAppraisalSlotRatingException;
import larion.progate.cds.model.CdsPerformanceAppraisalSlotRating;
import larion.progate.cds.model.impl.CdsPerformanceAppraisalSlotRatingImpl;
import larion.progate.cds.model.impl.CdsPerformanceAppraisalSlotRatingModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="CdsPerformanceAppraisalSlotRatingPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsPerformanceAppraisalSlotRatingPersistenceImpl
	extends BasePersistenceImpl
	implements CdsPerformanceAppraisalSlotRatingPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = CdsPerformanceAppraisalSlotRatingImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_USERID = new FinderPath(CdsPerformanceAppraisalSlotRatingModelImpl.ENTITY_CACHE_ENABLED,
			CdsPerformanceAppraisalSlotRatingModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByUserId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_USERID = new FinderPath(CdsPerformanceAppraisalSlotRatingModelImpl.ENTITY_CACHE_ENABLED,
			CdsPerformanceAppraisalSlotRatingModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByUserId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(CdsPerformanceAppraisalSlotRatingModelImpl.ENTITY_CACHE_ENABLED,
			CdsPerformanceAppraisalSlotRatingModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByUserId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_SLOTID = new FinderPath(CdsPerformanceAppraisalSlotRatingModelImpl.ENTITY_CACHE_ENABLED,
			CdsPerformanceAppraisalSlotRatingModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBySlotId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_SLOTID = new FinderPath(CdsPerformanceAppraisalSlotRatingModelImpl.ENTITY_CACHE_ENABLED,
			CdsPerformanceAppraisalSlotRatingModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBySlotId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_SLOTID = new FinderPath(CdsPerformanceAppraisalSlotRatingModelImpl.ENTITY_CACHE_ENABLED,
			CdsPerformanceAppraisalSlotRatingModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBySlotId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(CdsPerformanceAppraisalSlotRatingModelImpl.ENTITY_CACHE_ENABLED,
			CdsPerformanceAppraisalSlotRatingModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CdsPerformanceAppraisalSlotRatingModelImpl.ENTITY_CACHE_ENABLED,
			CdsPerformanceAppraisalSlotRatingModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(
		CdsPerformanceAppraisalSlotRating cdsPerformanceAppraisalSlotRating) {
		EntityCacheUtil.putResult(CdsPerformanceAppraisalSlotRatingModelImpl.ENTITY_CACHE_ENABLED,
			CdsPerformanceAppraisalSlotRatingImpl.class,
			cdsPerformanceAppraisalSlotRating.getPrimaryKey(),
			cdsPerformanceAppraisalSlotRating);
	}

	public void cacheResult(
		List<CdsPerformanceAppraisalSlotRating> cdsPerformanceAppraisalSlotRatings) {
		for (CdsPerformanceAppraisalSlotRating cdsPerformanceAppraisalSlotRating : cdsPerformanceAppraisalSlotRatings) {
			if (EntityCacheUtil.getResult(
						CdsPerformanceAppraisalSlotRatingModelImpl.ENTITY_CACHE_ENABLED,
						CdsPerformanceAppraisalSlotRatingImpl.class,
						cdsPerformanceAppraisalSlotRating.getPrimaryKey(), this) == null) {
				cacheResult(cdsPerformanceAppraisalSlotRating);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(CdsPerformanceAppraisalSlotRatingImpl.class.getName());
		EntityCacheUtil.clearCache(CdsPerformanceAppraisalSlotRatingImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public CdsPerformanceAppraisalSlotRating create(
		Integer CdsPerformanceAppraisalSlotRatingId) {
		CdsPerformanceAppraisalSlotRating cdsPerformanceAppraisalSlotRating = new CdsPerformanceAppraisalSlotRatingImpl();

		cdsPerformanceAppraisalSlotRating.setNew(true);
		cdsPerformanceAppraisalSlotRating.setPrimaryKey(CdsPerformanceAppraisalSlotRatingId);

		return cdsPerformanceAppraisalSlotRating;
	}

	public CdsPerformanceAppraisalSlotRating remove(
		Integer CdsPerformanceAppraisalSlotRatingId)
		throws NoSuchCdsPerformanceAppraisalSlotRatingException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CdsPerformanceAppraisalSlotRating cdsPerformanceAppraisalSlotRating = (CdsPerformanceAppraisalSlotRating)session.get(CdsPerformanceAppraisalSlotRatingImpl.class,
					CdsPerformanceAppraisalSlotRatingId);

			if (cdsPerformanceAppraisalSlotRating == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No CdsPerformanceAppraisalSlotRating exists with the primary key " +
						CdsPerformanceAppraisalSlotRatingId);
				}

				throw new NoSuchCdsPerformanceAppraisalSlotRatingException(
					"No CdsPerformanceAppraisalSlotRating exists with the primary key " +
					CdsPerformanceAppraisalSlotRatingId);
			}

			return remove(cdsPerformanceAppraisalSlotRating);
		}
		catch (NoSuchCdsPerformanceAppraisalSlotRatingException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public CdsPerformanceAppraisalSlotRating remove(
		CdsPerformanceAppraisalSlotRating cdsPerformanceAppraisalSlotRating)
		throws SystemException {
		for (ModelListener<CdsPerformanceAppraisalSlotRating> listener : listeners) {
			listener.onBeforeRemove(cdsPerformanceAppraisalSlotRating);
		}

		cdsPerformanceAppraisalSlotRating = removeImpl(cdsPerformanceAppraisalSlotRating);

		for (ModelListener<CdsPerformanceAppraisalSlotRating> listener : listeners) {
			listener.onAfterRemove(cdsPerformanceAppraisalSlotRating);
		}

		return cdsPerformanceAppraisalSlotRating;
	}

	protected CdsPerformanceAppraisalSlotRating removeImpl(
		CdsPerformanceAppraisalSlotRating cdsPerformanceAppraisalSlotRating)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (cdsPerformanceAppraisalSlotRating.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(CdsPerformanceAppraisalSlotRatingImpl.class,
						cdsPerformanceAppraisalSlotRating.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(cdsPerformanceAppraisalSlotRating);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(CdsPerformanceAppraisalSlotRatingModelImpl.ENTITY_CACHE_ENABLED,
			CdsPerformanceAppraisalSlotRatingImpl.class,
			cdsPerformanceAppraisalSlotRating.getPrimaryKey());

		return cdsPerformanceAppraisalSlotRating;
	}

	public CdsPerformanceAppraisalSlotRating update(
		CdsPerformanceAppraisalSlotRating cdsPerformanceAppraisalSlotRating)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(CdsPerformanceAppraisalSlotRating cdsPerformanceAppraisalSlotRating) method. Use update(CdsPerformanceAppraisalSlotRating cdsPerformanceAppraisalSlotRating, boolean merge) instead.");
		}

		return update(cdsPerformanceAppraisalSlotRating, false);
	}

	public CdsPerformanceAppraisalSlotRating update(
		CdsPerformanceAppraisalSlotRating cdsPerformanceAppraisalSlotRating,
		boolean merge) throws SystemException {
		boolean isNew = cdsPerformanceAppraisalSlotRating.isNew();

		for (ModelListener<CdsPerformanceAppraisalSlotRating> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(cdsPerformanceAppraisalSlotRating);
			}
			else {
				listener.onBeforeUpdate(cdsPerformanceAppraisalSlotRating);
			}
		}

		cdsPerformanceAppraisalSlotRating = updateImpl(cdsPerformanceAppraisalSlotRating,
				merge);

		for (ModelListener<CdsPerformanceAppraisalSlotRating> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(cdsPerformanceAppraisalSlotRating);
			}
			else {
				listener.onAfterUpdate(cdsPerformanceAppraisalSlotRating);
			}
		}

		return cdsPerformanceAppraisalSlotRating;
	}

	public CdsPerformanceAppraisalSlotRating updateImpl(
		larion.progate.cds.model.CdsPerformanceAppraisalSlotRating cdsPerformanceAppraisalSlotRating,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, cdsPerformanceAppraisalSlotRating,
				merge);

			cdsPerformanceAppraisalSlotRating.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(CdsPerformanceAppraisalSlotRatingModelImpl.ENTITY_CACHE_ENABLED,
			CdsPerformanceAppraisalSlotRatingImpl.class,
			cdsPerformanceAppraisalSlotRating.getPrimaryKey(),
			cdsPerformanceAppraisalSlotRating);

		return cdsPerformanceAppraisalSlotRating;
	}

	public CdsPerformanceAppraisalSlotRating findByPrimaryKey(
		Integer CdsPerformanceAppraisalSlotRatingId)
		throws NoSuchCdsPerformanceAppraisalSlotRatingException, SystemException {
		CdsPerformanceAppraisalSlotRating cdsPerformanceAppraisalSlotRating = fetchByPrimaryKey(CdsPerformanceAppraisalSlotRatingId);

		if (cdsPerformanceAppraisalSlotRating == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"No CdsPerformanceAppraisalSlotRating exists with the primary key " +
					CdsPerformanceAppraisalSlotRatingId);
			}

			throw new NoSuchCdsPerformanceAppraisalSlotRatingException(
				"No CdsPerformanceAppraisalSlotRating exists with the primary key " +
				CdsPerformanceAppraisalSlotRatingId);
		}

		return cdsPerformanceAppraisalSlotRating;
	}

	public CdsPerformanceAppraisalSlotRating fetchByPrimaryKey(
		Integer CdsPerformanceAppraisalSlotRatingId) throws SystemException {
		CdsPerformanceAppraisalSlotRating cdsPerformanceAppraisalSlotRating = (CdsPerformanceAppraisalSlotRating)EntityCacheUtil.getResult(CdsPerformanceAppraisalSlotRatingModelImpl.ENTITY_CACHE_ENABLED,
				CdsPerformanceAppraisalSlotRatingImpl.class,
				CdsPerformanceAppraisalSlotRatingId, this);

		if (cdsPerformanceAppraisalSlotRating == null) {
			Session session = null;

			try {
				session = openSession();

				cdsPerformanceAppraisalSlotRating = (CdsPerformanceAppraisalSlotRating)session.get(CdsPerformanceAppraisalSlotRatingImpl.class,
						CdsPerformanceAppraisalSlotRatingId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (cdsPerformanceAppraisalSlotRating != null) {
					cacheResult(cdsPerformanceAppraisalSlotRating);
				}

				closeSession(session);
			}
		}

		return cdsPerformanceAppraisalSlotRating;
	}

	public List<CdsPerformanceAppraisalSlotRating> findByUserId(int userId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(userId) };

		List<CdsPerformanceAppraisalSlotRating> list = (List<CdsPerformanceAppraisalSlotRating>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_USERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.CdsPerformanceAppraisalSlotRating WHERE ");

				query.append("user_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("rating_at ASC");

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
					list = new ArrayList<CdsPerformanceAppraisalSlotRating>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_USERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<CdsPerformanceAppraisalSlotRating> findByUserId(int userId,
		int start, int end) throws SystemException {
		return findByUserId(userId, start, end, null);
	}

	public List<CdsPerformanceAppraisalSlotRating> findByUserId(int userId,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(userId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<CdsPerformanceAppraisalSlotRating> list = (List<CdsPerformanceAppraisalSlotRating>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_USERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.CdsPerformanceAppraisalSlotRating WHERE ");

				query.append("user_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("rating_at ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				list = (List<CdsPerformanceAppraisalSlotRating>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsPerformanceAppraisalSlotRating>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_USERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public CdsPerformanceAppraisalSlotRating findByUserId_First(int userId,
		OrderByComparator obc)
		throws NoSuchCdsPerformanceAppraisalSlotRatingException, SystemException {
		List<CdsPerformanceAppraisalSlotRating> list = findByUserId(userId, 0,
				1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No CdsPerformanceAppraisalSlotRating exists with the key {");

			msg.append("userId=" + userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsPerformanceAppraisalSlotRatingException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsPerformanceAppraisalSlotRating findByUserId_Last(int userId,
		OrderByComparator obc)
		throws NoSuchCdsPerformanceAppraisalSlotRatingException, SystemException {
		int count = countByUserId(userId);

		List<CdsPerformanceAppraisalSlotRating> list = findByUserId(userId,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No CdsPerformanceAppraisalSlotRating exists with the key {");

			msg.append("userId=" + userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsPerformanceAppraisalSlotRatingException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsPerformanceAppraisalSlotRating[] findByUserId_PrevAndNext(
		Integer CdsPerformanceAppraisalSlotRatingId, int userId,
		OrderByComparator obc)
		throws NoSuchCdsPerformanceAppraisalSlotRatingException, SystemException {
		CdsPerformanceAppraisalSlotRating cdsPerformanceAppraisalSlotRating = findByPrimaryKey(CdsPerformanceAppraisalSlotRatingId);

		int count = countByUserId(userId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.cds.model.CdsPerformanceAppraisalSlotRating WHERE ");

			query.append("user_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("rating_at ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(userId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					cdsPerformanceAppraisalSlotRating);

			CdsPerformanceAppraisalSlotRating[] array = new CdsPerformanceAppraisalSlotRatingImpl[3];

			array[0] = (CdsPerformanceAppraisalSlotRating)objArray[0];
			array[1] = (CdsPerformanceAppraisalSlotRating)objArray[1];
			array[2] = (CdsPerformanceAppraisalSlotRating)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<CdsPerformanceAppraisalSlotRating> findBySlotId(int slotId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(slotId) };

		List<CdsPerformanceAppraisalSlotRating> list = (List<CdsPerformanceAppraisalSlotRating>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_SLOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.CdsPerformanceAppraisalSlotRating WHERE ");

				query.append("slot_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("rating_at ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(slotId);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsPerformanceAppraisalSlotRating>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_SLOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<CdsPerformanceAppraisalSlotRating> findBySlotId(int slotId,
		int start, int end) throws SystemException {
		return findBySlotId(slotId, start, end, null);
	}

	public List<CdsPerformanceAppraisalSlotRating> findBySlotId(int slotId,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(slotId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<CdsPerformanceAppraisalSlotRating> list = (List<CdsPerformanceAppraisalSlotRating>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_SLOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.CdsPerformanceAppraisalSlotRating WHERE ");

				query.append("slot_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("rating_at ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(slotId);

				list = (List<CdsPerformanceAppraisalSlotRating>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsPerformanceAppraisalSlotRating>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_SLOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public CdsPerformanceAppraisalSlotRating findBySlotId_First(int slotId,
		OrderByComparator obc)
		throws NoSuchCdsPerformanceAppraisalSlotRatingException, SystemException {
		List<CdsPerformanceAppraisalSlotRating> list = findBySlotId(slotId, 0,
				1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No CdsPerformanceAppraisalSlotRating exists with the key {");

			msg.append("slotId=" + slotId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsPerformanceAppraisalSlotRatingException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsPerformanceAppraisalSlotRating findBySlotId_Last(int slotId,
		OrderByComparator obc)
		throws NoSuchCdsPerformanceAppraisalSlotRatingException, SystemException {
		int count = countBySlotId(slotId);

		List<CdsPerformanceAppraisalSlotRating> list = findBySlotId(slotId,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No CdsPerformanceAppraisalSlotRating exists with the key {");

			msg.append("slotId=" + slotId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsPerformanceAppraisalSlotRatingException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsPerformanceAppraisalSlotRating[] findBySlotId_PrevAndNext(
		Integer CdsPerformanceAppraisalSlotRatingId, int slotId,
		OrderByComparator obc)
		throws NoSuchCdsPerformanceAppraisalSlotRatingException, SystemException {
		CdsPerformanceAppraisalSlotRating cdsPerformanceAppraisalSlotRating = findByPrimaryKey(CdsPerformanceAppraisalSlotRatingId);

		int count = countBySlotId(slotId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.cds.model.CdsPerformanceAppraisalSlotRating WHERE ");

			query.append("slot_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("rating_at ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(slotId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					cdsPerformanceAppraisalSlotRating);

			CdsPerformanceAppraisalSlotRating[] array = new CdsPerformanceAppraisalSlotRatingImpl[3];

			array[0] = (CdsPerformanceAppraisalSlotRating)objArray[0];
			array[1] = (CdsPerformanceAppraisalSlotRating)objArray[1];
			array[2] = (CdsPerformanceAppraisalSlotRating)objArray[2];

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

	public List<CdsPerformanceAppraisalSlotRating> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<CdsPerformanceAppraisalSlotRating> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<CdsPerformanceAppraisalSlotRating> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<CdsPerformanceAppraisalSlotRating> list = (List<CdsPerformanceAppraisalSlotRating>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.CdsPerformanceAppraisalSlotRating ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("rating_at ASC");
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<CdsPerformanceAppraisalSlotRating>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<CdsPerformanceAppraisalSlotRating>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsPerformanceAppraisalSlotRating>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByUserId(int userId) throws SystemException {
		for (CdsPerformanceAppraisalSlotRating cdsPerformanceAppraisalSlotRating : findByUserId(
				userId)) {
			remove(cdsPerformanceAppraisalSlotRating);
		}
	}

	public void removeBySlotId(int slotId) throws SystemException {
		for (CdsPerformanceAppraisalSlotRating cdsPerformanceAppraisalSlotRating : findBySlotId(
				slotId)) {
			remove(cdsPerformanceAppraisalSlotRating);
		}
	}

	public void removeAll() throws SystemException {
		for (CdsPerformanceAppraisalSlotRating cdsPerformanceAppraisalSlotRating : findAll()) {
			remove(cdsPerformanceAppraisalSlotRating);
		}
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
					"FROM larion.progate.cds.model.CdsPerformanceAppraisalSlotRating WHERE ");

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

	public int countBySlotId(int slotId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(slotId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_SLOTID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.cds.model.CdsPerformanceAppraisalSlotRating WHERE ");

				query.append("slot_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(slotId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SLOTID,
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
						"SELECT COUNT(*) FROM larion.progate.cds.model.CdsPerformanceAppraisalSlotRating");

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
						"value.object.listener.larion.progate.cds.model.CdsPerformanceAppraisalSlotRating")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CdsPerformanceAppraisalSlotRating>> listenersList =
					new ArrayList<ModelListener<CdsPerformanceAppraisalSlotRating>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CdsPerformanceAppraisalSlotRating>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(CdsPerformanceAppraisalSlotRatingPersistenceImpl.class);
}