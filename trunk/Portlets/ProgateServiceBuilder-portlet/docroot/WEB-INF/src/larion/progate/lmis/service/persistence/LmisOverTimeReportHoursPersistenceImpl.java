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

import larion.progate.lmis.NoSuchLmisOverTimeReportHoursException;
import larion.progate.lmis.model.LmisOverTimeReportHours;
import larion.progate.lmis.model.impl.LmisOverTimeReportHoursImpl;
import larion.progate.lmis.model.impl.LmisOverTimeReportHoursModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="LmisOverTimeReportHoursPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisOverTimeReportHoursPersistenceImpl extends BasePersistenceImpl
	implements LmisOverTimeReportHoursPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = LmisOverTimeReportHoursImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_DETAILID = new FinderPath(LmisOverTimeReportHoursModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeReportHoursModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByDetailID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_DETAILID = new FinderPath(LmisOverTimeReportHoursModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeReportHoursModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByDetailID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_DETAILID = new FinderPath(LmisOverTimeReportHoursModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeReportHoursModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByDetailID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OTID = new FinderPath(LmisOverTimeReportHoursModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeReportHoursModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOtID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_OTID = new FinderPath(LmisOverTimeReportHoursModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeReportHoursModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOtID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_OTID = new FinderPath(LmisOverTimeReportHoursModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeReportHoursModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByOtID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(LmisOverTimeReportHoursModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeReportHoursModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LmisOverTimeReportHoursModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeReportHoursModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(LmisOverTimeReportHours lmisOverTimeReportHours) {
		EntityCacheUtil.putResult(LmisOverTimeReportHoursModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeReportHoursImpl.class,
			lmisOverTimeReportHours.getPrimaryKey(), lmisOverTimeReportHours);
	}

	public void cacheResult(
		List<LmisOverTimeReportHours> lmisOverTimeReportHourses) {
		for (LmisOverTimeReportHours lmisOverTimeReportHours : lmisOverTimeReportHourses) {
			if (EntityCacheUtil.getResult(
						LmisOverTimeReportHoursModelImpl.ENTITY_CACHE_ENABLED,
						LmisOverTimeReportHoursImpl.class,
						lmisOverTimeReportHours.getPrimaryKey(), this) == null) {
				cacheResult(lmisOverTimeReportHours);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(LmisOverTimeReportHoursImpl.class.getName());
		EntityCacheUtil.clearCache(LmisOverTimeReportHoursImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public LmisOverTimeReportHours create(Integer lmisOverTimeReportHoursId) {
		LmisOverTimeReportHours lmisOverTimeReportHours = new LmisOverTimeReportHoursImpl();

		lmisOverTimeReportHours.setNew(true);
		lmisOverTimeReportHours.setPrimaryKey(lmisOverTimeReportHoursId);

		return lmisOverTimeReportHours;
	}

	public LmisOverTimeReportHours remove(Integer lmisOverTimeReportHoursId)
		throws NoSuchLmisOverTimeReportHoursException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LmisOverTimeReportHours lmisOverTimeReportHours = (LmisOverTimeReportHours)session.get(LmisOverTimeReportHoursImpl.class,
					lmisOverTimeReportHoursId);

			if (lmisOverTimeReportHours == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No LmisOverTimeReportHours exists with the primary key " +
						lmisOverTimeReportHoursId);
				}

				throw new NoSuchLmisOverTimeReportHoursException(
					"No LmisOverTimeReportHours exists with the primary key " +
					lmisOverTimeReportHoursId);
			}

			return remove(lmisOverTimeReportHours);
		}
		catch (NoSuchLmisOverTimeReportHoursException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public LmisOverTimeReportHours remove(
		LmisOverTimeReportHours lmisOverTimeReportHours)
		throws SystemException {
		for (ModelListener<LmisOverTimeReportHours> listener : listeners) {
			listener.onBeforeRemove(lmisOverTimeReportHours);
		}

		lmisOverTimeReportHours = removeImpl(lmisOverTimeReportHours);

		for (ModelListener<LmisOverTimeReportHours> listener : listeners) {
			listener.onAfterRemove(lmisOverTimeReportHours);
		}

		return lmisOverTimeReportHours;
	}

	protected LmisOverTimeReportHours removeImpl(
		LmisOverTimeReportHours lmisOverTimeReportHours)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (lmisOverTimeReportHours.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(LmisOverTimeReportHoursImpl.class,
						lmisOverTimeReportHours.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(lmisOverTimeReportHours);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(LmisOverTimeReportHoursModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeReportHoursImpl.class,
			lmisOverTimeReportHours.getPrimaryKey());

		return lmisOverTimeReportHours;
	}

	public LmisOverTimeReportHours update(
		LmisOverTimeReportHours lmisOverTimeReportHours)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(LmisOverTimeReportHours lmisOverTimeReportHours) method. Use update(LmisOverTimeReportHours lmisOverTimeReportHours, boolean merge) instead.");
		}

		return update(lmisOverTimeReportHours, false);
	}

	public LmisOverTimeReportHours update(
		LmisOverTimeReportHours lmisOverTimeReportHours, boolean merge)
		throws SystemException {
		boolean isNew = lmisOverTimeReportHours.isNew();

		for (ModelListener<LmisOverTimeReportHours> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(lmisOverTimeReportHours);
			}
			else {
				listener.onBeforeUpdate(lmisOverTimeReportHours);
			}
		}

		lmisOverTimeReportHours = updateImpl(lmisOverTimeReportHours, merge);

		for (ModelListener<LmisOverTimeReportHours> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(lmisOverTimeReportHours);
			}
			else {
				listener.onAfterUpdate(lmisOverTimeReportHours);
			}
		}

		return lmisOverTimeReportHours;
	}

	public LmisOverTimeReportHours updateImpl(
		larion.progate.lmis.model.LmisOverTimeReportHours lmisOverTimeReportHours,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, lmisOverTimeReportHours, merge);

			lmisOverTimeReportHours.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(LmisOverTimeReportHoursModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeReportHoursImpl.class,
			lmisOverTimeReportHours.getPrimaryKey(), lmisOverTimeReportHours);

		return lmisOverTimeReportHours;
	}

	public LmisOverTimeReportHours findByPrimaryKey(
		Integer lmisOverTimeReportHoursId)
		throws NoSuchLmisOverTimeReportHoursException, SystemException {
		LmisOverTimeReportHours lmisOverTimeReportHours = fetchByPrimaryKey(lmisOverTimeReportHoursId);

		if (lmisOverTimeReportHours == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"No LmisOverTimeReportHours exists with the primary key " +
					lmisOverTimeReportHoursId);
			}

			throw new NoSuchLmisOverTimeReportHoursException(
				"No LmisOverTimeReportHours exists with the primary key " +
				lmisOverTimeReportHoursId);
		}

		return lmisOverTimeReportHours;
	}

	public LmisOverTimeReportHours fetchByPrimaryKey(
		Integer lmisOverTimeReportHoursId) throws SystemException {
		LmisOverTimeReportHours lmisOverTimeReportHours = (LmisOverTimeReportHours)EntityCacheUtil.getResult(LmisOverTimeReportHoursModelImpl.ENTITY_CACHE_ENABLED,
				LmisOverTimeReportHoursImpl.class, lmisOverTimeReportHoursId,
				this);

		if (lmisOverTimeReportHours == null) {
			Session session = null;

			try {
				session = openSession();

				lmisOverTimeReportHours = (LmisOverTimeReportHours)session.get(LmisOverTimeReportHoursImpl.class,
						lmisOverTimeReportHoursId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (lmisOverTimeReportHours != null) {
					cacheResult(lmisOverTimeReportHours);
				}

				closeSession(session);
			}
		}

		return lmisOverTimeReportHours;
	}

	public List<LmisOverTimeReportHours> findByDetailID(int detailId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(detailId) };

		List<LmisOverTimeReportHours> list = (List<LmisOverTimeReportHours>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DETAILID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOverTimeReportHours WHERE ");

				query.append("detail_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(detailId);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisOverTimeReportHours>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DETAILID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisOverTimeReportHours> findByDetailID(int detailId,
		int start, int end) throws SystemException {
		return findByDetailID(detailId, start, end, null);
	}

	public List<LmisOverTimeReportHours> findByDetailID(int detailId,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(detailId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisOverTimeReportHours> list = (List<LmisOverTimeReportHours>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_DETAILID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOverTimeReportHours WHERE ");

				query.append("detail_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(detailId);

				list = (List<LmisOverTimeReportHours>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisOverTimeReportHours>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_DETAILID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisOverTimeReportHours findByDetailID_First(int detailId,
		OrderByComparator obc)
		throws NoSuchLmisOverTimeReportHoursException, SystemException {
		List<LmisOverTimeReportHours> list = findByDetailID(detailId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOverTimeReportHours exists with the key {");

			msg.append("detailId=" + detailId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOverTimeReportHoursException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOverTimeReportHours findByDetailID_Last(int detailId,
		OrderByComparator obc)
		throws NoSuchLmisOverTimeReportHoursException, SystemException {
		int count = countByDetailID(detailId);

		List<LmisOverTimeReportHours> list = findByDetailID(detailId,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOverTimeReportHours exists with the key {");

			msg.append("detailId=" + detailId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOverTimeReportHoursException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOverTimeReportHours[] findByDetailID_PrevAndNext(
		Integer lmisOverTimeReportHoursId, int detailId, OrderByComparator obc)
		throws NoSuchLmisOverTimeReportHoursException, SystemException {
		LmisOverTimeReportHours lmisOverTimeReportHours = findByPrimaryKey(lmisOverTimeReportHoursId);

		int count = countByDetailID(detailId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisOverTimeReportHours WHERE ");

			query.append("detail_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(detailId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisOverTimeReportHours);

			LmisOverTimeReportHours[] array = new LmisOverTimeReportHoursImpl[3];

			array[0] = (LmisOverTimeReportHours)objArray[0];
			array[1] = (LmisOverTimeReportHours)objArray[1];
			array[2] = (LmisOverTimeReportHours)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisOverTimeReportHours> findByOtID(int otId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(otId) };

		List<LmisOverTimeReportHours> list = (List<LmisOverTimeReportHours>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOverTimeReportHours WHERE ");

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
					list = new ArrayList<LmisOverTimeReportHours>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OTID, finderArgs,
					list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisOverTimeReportHours> findByOtID(int otId, int start, int end)
		throws SystemException {
		return findByOtID(otId, start, end, null);
	}

	public List<LmisOverTimeReportHours> findByOtID(int otId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(otId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisOverTimeReportHours> list = (List<LmisOverTimeReportHours>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_OTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOverTimeReportHours WHERE ");

				query.append("ot_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(otId);

				list = (List<LmisOverTimeReportHours>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisOverTimeReportHours>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_OTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisOverTimeReportHours findByOtID_First(int otId,
		OrderByComparator obc)
		throws NoSuchLmisOverTimeReportHoursException, SystemException {
		List<LmisOverTimeReportHours> list = findByOtID(otId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOverTimeReportHours exists with the key {");

			msg.append("otId=" + otId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOverTimeReportHoursException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOverTimeReportHours findByOtID_Last(int otId,
		OrderByComparator obc)
		throws NoSuchLmisOverTimeReportHoursException, SystemException {
		int count = countByOtID(otId);

		List<LmisOverTimeReportHours> list = findByOtID(otId, count - 1, count,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOverTimeReportHours exists with the key {");

			msg.append("otId=" + otId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOverTimeReportHoursException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOverTimeReportHours[] findByOtID_PrevAndNext(
		Integer lmisOverTimeReportHoursId, int otId, OrderByComparator obc)
		throws NoSuchLmisOverTimeReportHoursException, SystemException {
		LmisOverTimeReportHours lmisOverTimeReportHours = findByPrimaryKey(lmisOverTimeReportHoursId);

		int count = countByOtID(otId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisOverTimeReportHours WHERE ");

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
					lmisOverTimeReportHours);

			LmisOverTimeReportHours[] array = new LmisOverTimeReportHoursImpl[3];

			array[0] = (LmisOverTimeReportHours)objArray[0];
			array[1] = (LmisOverTimeReportHours)objArray[1];
			array[2] = (LmisOverTimeReportHours)objArray[2];

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

	public List<LmisOverTimeReportHours> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<LmisOverTimeReportHours> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<LmisOverTimeReportHours> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisOverTimeReportHours> list = (List<LmisOverTimeReportHours>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOverTimeReportHours ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<LmisOverTimeReportHours>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LmisOverTimeReportHours>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisOverTimeReportHours>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByDetailID(int detailId) throws SystemException {
		for (LmisOverTimeReportHours lmisOverTimeReportHours : findByDetailID(
				detailId)) {
			remove(lmisOverTimeReportHours);
		}
	}

	public void removeByOtID(int otId) throws SystemException {
		for (LmisOverTimeReportHours lmisOverTimeReportHours : findByOtID(otId)) {
			remove(lmisOverTimeReportHours);
		}
	}

	public void removeAll() throws SystemException {
		for (LmisOverTimeReportHours lmisOverTimeReportHours : findAll()) {
			remove(lmisOverTimeReportHours);
		}
	}

	public int countByDetailID(int detailId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(detailId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DETAILID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisOverTimeReportHours WHERE ");

				query.append("detail_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(detailId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DETAILID,
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
					"FROM larion.progate.lmis.model.LmisOverTimeReportHours WHERE ");

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

	public int countAll() throws SystemException {
		Object[] finderArgs = new Object[0];

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(
						"SELECT COUNT(*) FROM larion.progate.lmis.model.LmisOverTimeReportHours");

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
						"value.object.listener.larion.progate.lmis.model.LmisOverTimeReportHours")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LmisOverTimeReportHours>> listenersList = new ArrayList<ModelListener<LmisOverTimeReportHours>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LmisOverTimeReportHours>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(LmisOverTimeReportHoursPersistenceImpl.class);
}