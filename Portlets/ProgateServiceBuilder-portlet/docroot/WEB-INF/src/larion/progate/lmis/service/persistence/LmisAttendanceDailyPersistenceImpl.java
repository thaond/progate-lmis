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

import larion.progate.lmis.NoSuchLmisAttendanceDailyException;
import larion.progate.lmis.model.LmisAttendanceDaily;
import larion.progate.lmis.model.impl.LmisAttendanceDailyImpl;
import larion.progate.lmis.model.impl.LmisAttendanceDailyModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * <a href="LmisAttendanceDailyPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisAttendanceDailyPersistenceImpl extends BasePersistenceImpl
	implements LmisAttendanceDailyPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = LmisAttendanceDailyImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_LMISATTENDANCEDAILYOF = new FinderPath(LmisAttendanceDailyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAttendanceDailyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByLmisAttendanceDailyOf",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_LMISATTENDANCEDAILYOF =
		new FinderPath(LmisAttendanceDailyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAttendanceDailyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByLmisAttendanceDailyOf",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_LMISATTENDANCEDAILYOF = new FinderPath(LmisAttendanceDailyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAttendanceDailyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByLmisAttendanceDailyOf",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_DAYVALUE = new FinderPath(LmisAttendanceDailyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAttendanceDailyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByDayValue",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_DAYVALUE = new FinderPath(LmisAttendanceDailyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAttendanceDailyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByDayValue",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_DAYVALUE = new FinderPath(LmisAttendanceDailyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAttendanceDailyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByDayValue",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_USERID = new FinderPath(LmisAttendanceDailyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAttendanceDailyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByUserID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_USERID = new FinderPath(LmisAttendanceDailyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAttendanceDailyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByUserID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(LmisAttendanceDailyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAttendanceDailyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByUserID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ROOTID = new FinderPath(LmisAttendanceDailyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAttendanceDailyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ROOTID = new FinderPath(LmisAttendanceDailyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAttendanceDailyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ROOTID = new FinderPath(LmisAttendanceDailyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAttendanceDailyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByRootID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ABSENCEVALUEGREATER = new FinderPath(LmisAttendanceDailyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAttendanceDailyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByabsenceValueGreater",
			new String[] { Double.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ABSENCEVALUEGREATER = new FinderPath(LmisAttendanceDailyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAttendanceDailyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByabsenceValueGreater",
			new String[] {
				Double.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ABSENCEVALUEGREATER = new FinderPath(LmisAttendanceDailyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAttendanceDailyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByabsenceValueGreater",
			new String[] { Double.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_DAYGREATER = new FinderPath(LmisAttendanceDailyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAttendanceDailyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByDayGreater",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_DAYGREATER = new FinderPath(LmisAttendanceDailyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAttendanceDailyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByDayGreater",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_DAYGREATER = new FinderPath(LmisAttendanceDailyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAttendanceDailyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByDayGreater",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_DAYSMALLER = new FinderPath(LmisAttendanceDailyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAttendanceDailyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByDaySmaller",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_DAYSMALLER = new FinderPath(LmisAttendanceDailyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAttendanceDailyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByDaySmaller",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_DAYSMALLER = new FinderPath(LmisAttendanceDailyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAttendanceDailyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByDaySmaller",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(LmisAttendanceDailyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAttendanceDailyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LmisAttendanceDailyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAttendanceDailyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(LmisAttendanceDaily lmisAttendanceDaily) {
		EntityCacheUtil.putResult(LmisAttendanceDailyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAttendanceDailyImpl.class, lmisAttendanceDaily.getPrimaryKey(),
			lmisAttendanceDaily);
	}

	public void cacheResult(List<LmisAttendanceDaily> lmisAttendanceDailies) {
		for (LmisAttendanceDaily lmisAttendanceDaily : lmisAttendanceDailies) {
			if (EntityCacheUtil.getResult(
						LmisAttendanceDailyModelImpl.ENTITY_CACHE_ENABLED,
						LmisAttendanceDailyImpl.class,
						lmisAttendanceDaily.getPrimaryKey(), this) == null) {
				cacheResult(lmisAttendanceDaily);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(LmisAttendanceDailyImpl.class.getName());
		EntityCacheUtil.clearCache(LmisAttendanceDailyImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public LmisAttendanceDaily create(Integer lmisAttendanceDailyId) {
		LmisAttendanceDaily lmisAttendanceDaily = new LmisAttendanceDailyImpl();

		lmisAttendanceDaily.setNew(true);
		lmisAttendanceDaily.setPrimaryKey(lmisAttendanceDailyId);

		return lmisAttendanceDaily;
	}

	public LmisAttendanceDaily remove(Integer lmisAttendanceDailyId)
		throws NoSuchLmisAttendanceDailyException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LmisAttendanceDaily lmisAttendanceDaily = (LmisAttendanceDaily)session.get(LmisAttendanceDailyImpl.class,
					lmisAttendanceDailyId);

			if (lmisAttendanceDaily == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No LmisAttendanceDaily exists with the primary key " +
						lmisAttendanceDailyId);
				}

				throw new NoSuchLmisAttendanceDailyException(
					"No LmisAttendanceDaily exists with the primary key " +
					lmisAttendanceDailyId);
			}

			return remove(lmisAttendanceDaily);
		}
		catch (NoSuchLmisAttendanceDailyException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public LmisAttendanceDaily remove(LmisAttendanceDaily lmisAttendanceDaily)
		throws SystemException {
		for (ModelListener<LmisAttendanceDaily> listener : listeners) {
			listener.onBeforeRemove(lmisAttendanceDaily);
		}

		lmisAttendanceDaily = removeImpl(lmisAttendanceDaily);

		for (ModelListener<LmisAttendanceDaily> listener : listeners) {
			listener.onAfterRemove(lmisAttendanceDaily);
		}

		return lmisAttendanceDaily;
	}

	protected LmisAttendanceDaily removeImpl(
		LmisAttendanceDaily lmisAttendanceDaily) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (lmisAttendanceDaily.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(LmisAttendanceDailyImpl.class,
						lmisAttendanceDaily.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(lmisAttendanceDaily);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(LmisAttendanceDailyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAttendanceDailyImpl.class, lmisAttendanceDaily.getPrimaryKey());

		return lmisAttendanceDaily;
	}

	public LmisAttendanceDaily update(LmisAttendanceDaily lmisAttendanceDaily)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(LmisAttendanceDaily lmisAttendanceDaily) method. Use update(LmisAttendanceDaily lmisAttendanceDaily, boolean merge) instead.");
		}

		return update(lmisAttendanceDaily, false);
	}

	public LmisAttendanceDaily update(LmisAttendanceDaily lmisAttendanceDaily,
		boolean merge) throws SystemException {
		boolean isNew = lmisAttendanceDaily.isNew();

		for (ModelListener<LmisAttendanceDaily> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(lmisAttendanceDaily);
			}
			else {
				listener.onBeforeUpdate(lmisAttendanceDaily);
			}
		}

		lmisAttendanceDaily = updateImpl(lmisAttendanceDaily, merge);

		for (ModelListener<LmisAttendanceDaily> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(lmisAttendanceDaily);
			}
			else {
				listener.onAfterUpdate(lmisAttendanceDaily);
			}
		}

		return lmisAttendanceDaily;
	}

	public LmisAttendanceDaily updateImpl(
		larion.progate.lmis.model.LmisAttendanceDaily lmisAttendanceDaily,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, lmisAttendanceDaily, merge);

			lmisAttendanceDaily.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(LmisAttendanceDailyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAttendanceDailyImpl.class, lmisAttendanceDaily.getPrimaryKey(),
			lmisAttendanceDaily);

		return lmisAttendanceDaily;
	}

	public LmisAttendanceDaily findByPrimaryKey(Integer lmisAttendanceDailyId)
		throws NoSuchLmisAttendanceDailyException, SystemException {
		LmisAttendanceDaily lmisAttendanceDaily = fetchByPrimaryKey(lmisAttendanceDailyId);

		if (lmisAttendanceDaily == null) {
			if (_log.isWarnEnabled()) {
				_log.warn("No LmisAttendanceDaily exists with the primary key " +
					lmisAttendanceDailyId);
			}

			throw new NoSuchLmisAttendanceDailyException(
				"No LmisAttendanceDaily exists with the primary key " +
				lmisAttendanceDailyId);
		}

		return lmisAttendanceDaily;
	}

	public LmisAttendanceDaily fetchByPrimaryKey(Integer lmisAttendanceDailyId)
		throws SystemException {
		LmisAttendanceDaily lmisAttendanceDaily = (LmisAttendanceDaily)EntityCacheUtil.getResult(LmisAttendanceDailyModelImpl.ENTITY_CACHE_ENABLED,
				LmisAttendanceDailyImpl.class, lmisAttendanceDailyId, this);

		if (lmisAttendanceDaily == null) {
			Session session = null;

			try {
				session = openSession();

				lmisAttendanceDaily = (LmisAttendanceDaily)session.get(LmisAttendanceDailyImpl.class,
						lmisAttendanceDailyId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (lmisAttendanceDaily != null) {
					cacheResult(lmisAttendanceDaily);
				}

				closeSession(session);
			}
		}

		return lmisAttendanceDaily;
	}

	public List<LmisAttendanceDaily> findByLmisAttendanceDailyOf(int rootId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		List<LmisAttendanceDaily> list = (List<LmisAttendanceDaily>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_LMISATTENDANCEDAILYOF,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAttendanceDaily WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("day_value ASC");

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
					list = new ArrayList<LmisAttendanceDaily>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_LMISATTENDANCEDAILYOF,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisAttendanceDaily> findByLmisAttendanceDailyOf(int rootId,
		int start, int end) throws SystemException {
		return findByLmisAttendanceDailyOf(rootId, start, end, null);
	}

	public List<LmisAttendanceDaily> findByLmisAttendanceDailyOf(int rootId,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(rootId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisAttendanceDaily> list = (List<LmisAttendanceDaily>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_LMISATTENDANCEDAILYOF,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAttendanceDaily WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("day_value ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rootId);

				list = (List<LmisAttendanceDaily>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisAttendanceDaily>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_LMISATTENDANCEDAILYOF,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisAttendanceDaily findByLmisAttendanceDailyOf_First(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisAttendanceDailyException, SystemException {
		List<LmisAttendanceDaily> list = findByLmisAttendanceDailyOf(rootId, 0,
				1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAttendanceDaily exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAttendanceDailyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAttendanceDaily findByLmisAttendanceDailyOf_Last(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisAttendanceDailyException, SystemException {
		int count = countByLmisAttendanceDailyOf(rootId);

		List<LmisAttendanceDaily> list = findByLmisAttendanceDailyOf(rootId,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAttendanceDaily exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAttendanceDailyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAttendanceDaily[] findByLmisAttendanceDailyOf_PrevAndNext(
		Integer lmisAttendanceDailyId, int rootId, OrderByComparator obc)
		throws NoSuchLmisAttendanceDailyException, SystemException {
		LmisAttendanceDaily lmisAttendanceDaily = findByPrimaryKey(lmisAttendanceDailyId);

		int count = countByLmisAttendanceDailyOf(rootId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisAttendanceDaily WHERE ");

			query.append("root_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("day_value ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(rootId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisAttendanceDaily);

			LmisAttendanceDaily[] array = new LmisAttendanceDailyImpl[3];

			array[0] = (LmisAttendanceDaily)objArray[0];
			array[1] = (LmisAttendanceDaily)objArray[1];
			array[2] = (LmisAttendanceDaily)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisAttendanceDaily> findByDayValue(Date dayValue)
		throws SystemException {
		Object[] finderArgs = new Object[] { dayValue };

		List<LmisAttendanceDaily> list = (List<LmisAttendanceDaily>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DAYVALUE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAttendanceDaily WHERE ");

				if (dayValue == null) {
					query.append("day_value IS NULL");
				}
				else {
					query.append("day_value = ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("day_value ASC");

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
					list = new ArrayList<LmisAttendanceDaily>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DAYVALUE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisAttendanceDaily> findByDayValue(Date dayValue, int start,
		int end) throws SystemException {
		return findByDayValue(dayValue, start, end, null);
	}

	public List<LmisAttendanceDaily> findByDayValue(Date dayValue, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				dayValue,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisAttendanceDaily> list = (List<LmisAttendanceDaily>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_DAYVALUE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAttendanceDaily WHERE ");

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

					query.append("day_value ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (dayValue != null) {
					qPos.add(CalendarUtil.getTimestamp(dayValue));
				}

				list = (List<LmisAttendanceDaily>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisAttendanceDaily>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_DAYVALUE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisAttendanceDaily findByDayValue_First(Date dayValue,
		OrderByComparator obc)
		throws NoSuchLmisAttendanceDailyException, SystemException {
		List<LmisAttendanceDaily> list = findByDayValue(dayValue, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAttendanceDaily exists with the key {");

			msg.append("dayValue=" + dayValue);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAttendanceDailyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAttendanceDaily findByDayValue_Last(Date dayValue,
		OrderByComparator obc)
		throws NoSuchLmisAttendanceDailyException, SystemException {
		int count = countByDayValue(dayValue);

		List<LmisAttendanceDaily> list = findByDayValue(dayValue, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAttendanceDaily exists with the key {");

			msg.append("dayValue=" + dayValue);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAttendanceDailyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAttendanceDaily[] findByDayValue_PrevAndNext(
		Integer lmisAttendanceDailyId, Date dayValue, OrderByComparator obc)
		throws NoSuchLmisAttendanceDailyException, SystemException {
		LmisAttendanceDaily lmisAttendanceDaily = findByPrimaryKey(lmisAttendanceDailyId);

		int count = countByDayValue(dayValue);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisAttendanceDaily WHERE ");

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

				query.append("day_value ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (dayValue != null) {
				qPos.add(CalendarUtil.getTimestamp(dayValue));
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisAttendanceDaily);

			LmisAttendanceDaily[] array = new LmisAttendanceDailyImpl[3];

			array[0] = (LmisAttendanceDaily)objArray[0];
			array[1] = (LmisAttendanceDaily)objArray[1];
			array[2] = (LmisAttendanceDaily)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisAttendanceDaily> findByUserID(int userId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(userId) };

		List<LmisAttendanceDaily> list = (List<LmisAttendanceDaily>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_USERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAttendanceDaily WHERE ");

				query.append("user_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("day_value ASC");

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
					list = new ArrayList<LmisAttendanceDaily>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_USERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisAttendanceDaily> findByUserID(int userId, int start, int end)
		throws SystemException {
		return findByUserID(userId, start, end, null);
	}

	public List<LmisAttendanceDaily> findByUserID(int userId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(userId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisAttendanceDaily> list = (List<LmisAttendanceDaily>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_USERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAttendanceDaily WHERE ");

				query.append("user_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("day_value ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				list = (List<LmisAttendanceDaily>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisAttendanceDaily>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_USERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisAttendanceDaily findByUserID_First(int userId,
		OrderByComparator obc)
		throws NoSuchLmisAttendanceDailyException, SystemException {
		List<LmisAttendanceDaily> list = findByUserID(userId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAttendanceDaily exists with the key {");

			msg.append("userId=" + userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAttendanceDailyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAttendanceDaily findByUserID_Last(int userId,
		OrderByComparator obc)
		throws NoSuchLmisAttendanceDailyException, SystemException {
		int count = countByUserID(userId);

		List<LmisAttendanceDaily> list = findByUserID(userId, count - 1, count,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAttendanceDaily exists with the key {");

			msg.append("userId=" + userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAttendanceDailyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAttendanceDaily[] findByUserID_PrevAndNext(
		Integer lmisAttendanceDailyId, int userId, OrderByComparator obc)
		throws NoSuchLmisAttendanceDailyException, SystemException {
		LmisAttendanceDaily lmisAttendanceDaily = findByPrimaryKey(lmisAttendanceDailyId);

		int count = countByUserID(userId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisAttendanceDaily WHERE ");

			query.append("user_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("day_value ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(userId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisAttendanceDaily);

			LmisAttendanceDaily[] array = new LmisAttendanceDailyImpl[3];

			array[0] = (LmisAttendanceDaily)objArray[0];
			array[1] = (LmisAttendanceDaily)objArray[1];
			array[2] = (LmisAttendanceDaily)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisAttendanceDaily> findByRootID(int rootId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		List<LmisAttendanceDaily> list = (List<LmisAttendanceDaily>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAttendanceDaily WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("day_value ASC");

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
					list = new ArrayList<LmisAttendanceDaily>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisAttendanceDaily> findByRootID(int rootId, int start, int end)
		throws SystemException {
		return findByRootID(rootId, start, end, null);
	}

	public List<LmisAttendanceDaily> findByRootID(int rootId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(rootId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisAttendanceDaily> list = (List<LmisAttendanceDaily>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAttendanceDaily WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("day_value ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rootId);

				list = (List<LmisAttendanceDaily>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisAttendanceDaily>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisAttendanceDaily findByRootID_First(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisAttendanceDailyException, SystemException {
		List<LmisAttendanceDaily> list = findByRootID(rootId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAttendanceDaily exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAttendanceDailyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAttendanceDaily findByRootID_Last(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisAttendanceDailyException, SystemException {
		int count = countByRootID(rootId);

		List<LmisAttendanceDaily> list = findByRootID(rootId, count - 1, count,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAttendanceDaily exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAttendanceDailyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAttendanceDaily[] findByRootID_PrevAndNext(
		Integer lmisAttendanceDailyId, int rootId, OrderByComparator obc)
		throws NoSuchLmisAttendanceDailyException, SystemException {
		LmisAttendanceDaily lmisAttendanceDaily = findByPrimaryKey(lmisAttendanceDailyId);

		int count = countByRootID(rootId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisAttendanceDaily WHERE ");

			query.append("root_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("day_value ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(rootId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisAttendanceDaily);

			LmisAttendanceDaily[] array = new LmisAttendanceDailyImpl[3];

			array[0] = (LmisAttendanceDaily)objArray[0];
			array[1] = (LmisAttendanceDaily)objArray[1];
			array[2] = (LmisAttendanceDaily)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisAttendanceDaily> findByabsenceValueGreater(
		double absenceValue) throws SystemException {
		Object[] finderArgs = new Object[] { new Double(absenceValue) };

		List<LmisAttendanceDaily> list = (List<LmisAttendanceDaily>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ABSENCEVALUEGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAttendanceDaily WHERE ");

				query.append("absence_value > ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("day_value ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(absenceValue);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisAttendanceDaily>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ABSENCEVALUEGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisAttendanceDaily> findByabsenceValueGreater(
		double absenceValue, int start, int end) throws SystemException {
		return findByabsenceValueGreater(absenceValue, start, end, null);
	}

	public List<LmisAttendanceDaily> findByabsenceValueGreater(
		double absenceValue, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				new Double(absenceValue),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisAttendanceDaily> list = (List<LmisAttendanceDaily>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ABSENCEVALUEGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAttendanceDaily WHERE ");

				query.append("absence_value > ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("day_value ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(absenceValue);

				list = (List<LmisAttendanceDaily>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisAttendanceDaily>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ABSENCEVALUEGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisAttendanceDaily findByabsenceValueGreater_First(
		double absenceValue, OrderByComparator obc)
		throws NoSuchLmisAttendanceDailyException, SystemException {
		List<LmisAttendanceDaily> list = findByabsenceValueGreater(absenceValue,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAttendanceDaily exists with the key {");

			msg.append("absenceValue=" + absenceValue);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAttendanceDailyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAttendanceDaily findByabsenceValueGreater_Last(
		double absenceValue, OrderByComparator obc)
		throws NoSuchLmisAttendanceDailyException, SystemException {
		int count = countByabsenceValueGreater(absenceValue);

		List<LmisAttendanceDaily> list = findByabsenceValueGreater(absenceValue,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAttendanceDaily exists with the key {");

			msg.append("absenceValue=" + absenceValue);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAttendanceDailyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAttendanceDaily[] findByabsenceValueGreater_PrevAndNext(
		Integer lmisAttendanceDailyId, double absenceValue,
		OrderByComparator obc)
		throws NoSuchLmisAttendanceDailyException, SystemException {
		LmisAttendanceDaily lmisAttendanceDaily = findByPrimaryKey(lmisAttendanceDailyId);

		int count = countByabsenceValueGreater(absenceValue);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisAttendanceDaily WHERE ");

			query.append("absence_value > ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("day_value ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(absenceValue);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisAttendanceDaily);

			LmisAttendanceDaily[] array = new LmisAttendanceDailyImpl[3];

			array[0] = (LmisAttendanceDaily)objArray[0];
			array[1] = (LmisAttendanceDaily)objArray[1];
			array[2] = (LmisAttendanceDaily)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisAttendanceDaily> findByDayGreater(Date dayValue)
		throws SystemException {
		Object[] finderArgs = new Object[] { dayValue };

		List<LmisAttendanceDaily> list = (List<LmisAttendanceDaily>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DAYGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAttendanceDaily WHERE ");

				if (dayValue == null) {
					query.append("day_value >= null");
				}
				else {
					query.append("day_value >= ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("day_value ASC");

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
					list = new ArrayList<LmisAttendanceDaily>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DAYGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisAttendanceDaily> findByDayGreater(Date dayValue, int start,
		int end) throws SystemException {
		return findByDayGreater(dayValue, start, end, null);
	}

	public List<LmisAttendanceDaily> findByDayGreater(Date dayValue, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				dayValue,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisAttendanceDaily> list = (List<LmisAttendanceDaily>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_DAYGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAttendanceDaily WHERE ");

				if (dayValue == null) {
					query.append("day_value >= null");
				}
				else {
					query.append("day_value >= ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("day_value ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (dayValue != null) {
					qPos.add(CalendarUtil.getTimestamp(dayValue));
				}

				list = (List<LmisAttendanceDaily>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisAttendanceDaily>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_DAYGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisAttendanceDaily findByDayGreater_First(Date dayValue,
		OrderByComparator obc)
		throws NoSuchLmisAttendanceDailyException, SystemException {
		List<LmisAttendanceDaily> list = findByDayGreater(dayValue, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAttendanceDaily exists with the key {");

			msg.append("dayValue=" + dayValue);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAttendanceDailyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAttendanceDaily findByDayGreater_Last(Date dayValue,
		OrderByComparator obc)
		throws NoSuchLmisAttendanceDailyException, SystemException {
		int count = countByDayGreater(dayValue);

		List<LmisAttendanceDaily> list = findByDayGreater(dayValue, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAttendanceDaily exists with the key {");

			msg.append("dayValue=" + dayValue);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAttendanceDailyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAttendanceDaily[] findByDayGreater_PrevAndNext(
		Integer lmisAttendanceDailyId, Date dayValue, OrderByComparator obc)
		throws NoSuchLmisAttendanceDailyException, SystemException {
		LmisAttendanceDaily lmisAttendanceDaily = findByPrimaryKey(lmisAttendanceDailyId);

		int count = countByDayGreater(dayValue);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisAttendanceDaily WHERE ");

			if (dayValue == null) {
				query.append("day_value >= null");
			}
			else {
				query.append("day_value >= ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("day_value ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (dayValue != null) {
				qPos.add(CalendarUtil.getTimestamp(dayValue));
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisAttendanceDaily);

			LmisAttendanceDaily[] array = new LmisAttendanceDailyImpl[3];

			array[0] = (LmisAttendanceDaily)objArray[0];
			array[1] = (LmisAttendanceDaily)objArray[1];
			array[2] = (LmisAttendanceDaily)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisAttendanceDaily> findByDaySmaller(Date dayValue)
		throws SystemException {
		Object[] finderArgs = new Object[] { dayValue };

		List<LmisAttendanceDaily> list = (List<LmisAttendanceDaily>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DAYSMALLER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAttendanceDaily WHERE ");

				if (dayValue == null) {
					query.append("day_value <= null");
				}
				else {
					query.append("day_value <= ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("day_value ASC");

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
					list = new ArrayList<LmisAttendanceDaily>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DAYSMALLER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisAttendanceDaily> findByDaySmaller(Date dayValue, int start,
		int end) throws SystemException {
		return findByDaySmaller(dayValue, start, end, null);
	}

	public List<LmisAttendanceDaily> findByDaySmaller(Date dayValue, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				dayValue,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisAttendanceDaily> list = (List<LmisAttendanceDaily>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_DAYSMALLER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAttendanceDaily WHERE ");

				if (dayValue == null) {
					query.append("day_value <= null");
				}
				else {
					query.append("day_value <= ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("day_value ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (dayValue != null) {
					qPos.add(CalendarUtil.getTimestamp(dayValue));
				}

				list = (List<LmisAttendanceDaily>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisAttendanceDaily>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_DAYSMALLER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisAttendanceDaily findByDaySmaller_First(Date dayValue,
		OrderByComparator obc)
		throws NoSuchLmisAttendanceDailyException, SystemException {
		List<LmisAttendanceDaily> list = findByDaySmaller(dayValue, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAttendanceDaily exists with the key {");

			msg.append("dayValue=" + dayValue);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAttendanceDailyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAttendanceDaily findByDaySmaller_Last(Date dayValue,
		OrderByComparator obc)
		throws NoSuchLmisAttendanceDailyException, SystemException {
		int count = countByDaySmaller(dayValue);

		List<LmisAttendanceDaily> list = findByDaySmaller(dayValue, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAttendanceDaily exists with the key {");

			msg.append("dayValue=" + dayValue);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAttendanceDailyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAttendanceDaily[] findByDaySmaller_PrevAndNext(
		Integer lmisAttendanceDailyId, Date dayValue, OrderByComparator obc)
		throws NoSuchLmisAttendanceDailyException, SystemException {
		LmisAttendanceDaily lmisAttendanceDaily = findByPrimaryKey(lmisAttendanceDailyId);

		int count = countByDaySmaller(dayValue);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisAttendanceDaily WHERE ");

			if (dayValue == null) {
				query.append("day_value <= null");
			}
			else {
				query.append("day_value <= ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("day_value ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (dayValue != null) {
				qPos.add(CalendarUtil.getTimestamp(dayValue));
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisAttendanceDaily);

			LmisAttendanceDaily[] array = new LmisAttendanceDailyImpl[3];

			array[0] = (LmisAttendanceDaily)objArray[0];
			array[1] = (LmisAttendanceDaily)objArray[1];
			array[2] = (LmisAttendanceDaily)objArray[2];

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

	public List<LmisAttendanceDaily> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<LmisAttendanceDaily> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<LmisAttendanceDaily> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisAttendanceDaily> list = (List<LmisAttendanceDaily>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAttendanceDaily ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("day_value ASC");
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<LmisAttendanceDaily>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LmisAttendanceDaily>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisAttendanceDaily>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByLmisAttendanceDailyOf(int rootId)
		throws SystemException {
		for (LmisAttendanceDaily lmisAttendanceDaily : findByLmisAttendanceDailyOf(
				rootId)) {
			remove(lmisAttendanceDaily);
		}
	}

	public void removeByDayValue(Date dayValue) throws SystemException {
		for (LmisAttendanceDaily lmisAttendanceDaily : findByDayValue(dayValue)) {
			remove(lmisAttendanceDaily);
		}
	}

	public void removeByUserID(int userId) throws SystemException {
		for (LmisAttendanceDaily lmisAttendanceDaily : findByUserID(userId)) {
			remove(lmisAttendanceDaily);
		}
	}

	public void removeByRootID(int rootId) throws SystemException {
		for (LmisAttendanceDaily lmisAttendanceDaily : findByRootID(rootId)) {
			remove(lmisAttendanceDaily);
		}
	}

	public void removeByabsenceValueGreater(double absenceValue)
		throws SystemException {
		for (LmisAttendanceDaily lmisAttendanceDaily : findByabsenceValueGreater(
				absenceValue)) {
			remove(lmisAttendanceDaily);
		}
	}

	public void removeByDayGreater(Date dayValue) throws SystemException {
		for (LmisAttendanceDaily lmisAttendanceDaily : findByDayGreater(
				dayValue)) {
			remove(lmisAttendanceDaily);
		}
	}

	public void removeByDaySmaller(Date dayValue) throws SystemException {
		for (LmisAttendanceDaily lmisAttendanceDaily : findByDaySmaller(
				dayValue)) {
			remove(lmisAttendanceDaily);
		}
	}

	public void removeAll() throws SystemException {
		for (LmisAttendanceDaily lmisAttendanceDaily : findAll()) {
			remove(lmisAttendanceDaily);
		}
	}

	public int countByLmisAttendanceDailyOf(int rootId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_LMISATTENDANCEDAILYOF,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisAttendanceDaily WHERE ");

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LMISATTENDANCEDAILYOF,
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
					"FROM larion.progate.lmis.model.LmisAttendanceDaily WHERE ");

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
					"FROM larion.progate.lmis.model.LmisAttendanceDaily WHERE ");

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
					"FROM larion.progate.lmis.model.LmisAttendanceDaily WHERE ");

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

	public int countByabsenceValueGreater(double absenceValue)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Double(absenceValue) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ABSENCEVALUEGREATER,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisAttendanceDaily WHERE ");

				query.append("absence_value > ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(absenceValue);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ABSENCEVALUEGREATER,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByDayGreater(Date dayValue) throws SystemException {
		Object[] finderArgs = new Object[] { dayValue };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DAYGREATER,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisAttendanceDaily WHERE ");

				if (dayValue == null) {
					query.append("day_value >= null");
				}
				else {
					query.append("day_value >= ?");
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DAYGREATER,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByDaySmaller(Date dayValue) throws SystemException {
		Object[] finderArgs = new Object[] { dayValue };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DAYSMALLER,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisAttendanceDaily WHERE ");

				if (dayValue == null) {
					query.append("day_value <= null");
				}
				else {
					query.append("day_value <= ?");
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DAYSMALLER,
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
						"SELECT COUNT(*) FROM larion.progate.lmis.model.LmisAttendanceDaily");

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
						"value.object.listener.larion.progate.lmis.model.LmisAttendanceDaily")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LmisAttendanceDaily>> listenersList = new ArrayList<ModelListener<LmisAttendanceDaily>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LmisAttendanceDaily>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(LmisAttendanceDailyPersistenceImpl.class);
}