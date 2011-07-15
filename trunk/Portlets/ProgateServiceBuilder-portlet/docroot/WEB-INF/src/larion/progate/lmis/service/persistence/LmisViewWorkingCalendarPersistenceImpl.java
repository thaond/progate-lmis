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

import larion.progate.lmis.NoSuchLmisViewWorkingCalendarException;
import larion.progate.lmis.model.LmisViewWorkingCalendar;
import larion.progate.lmis.model.impl.LmisViewWorkingCalendarImpl;
import larion.progate.lmis.model.impl.LmisViewWorkingCalendarModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * <a href="LmisViewWorkingCalendarPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewWorkingCalendarPersistenceImpl extends BasePersistenceImpl
	implements LmisViewWorkingCalendarPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = LmisViewWorkingCalendarImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_ROOTID = new FinderPath(LmisViewWorkingCalendarModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewWorkingCalendarModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ROOTID = new FinderPath(LmisViewWorkingCalendarModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewWorkingCalendarModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ROOTID = new FinderPath(LmisViewWorkingCalendarModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewWorkingCalendarModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByRootID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_DAYGREATER = new FinderPath(LmisViewWorkingCalendarModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewWorkingCalendarModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByDayGreater",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_DAYGREATER = new FinderPath(LmisViewWorkingCalendarModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewWorkingCalendarModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByDayGreater",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_DAYGREATER = new FinderPath(LmisViewWorkingCalendarModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewWorkingCalendarModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByDayGreater",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_DAYSMALLER = new FinderPath(LmisViewWorkingCalendarModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewWorkingCalendarModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByDaySmaller",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_DAYSMALLER = new FinderPath(LmisViewWorkingCalendarModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewWorkingCalendarModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByDaySmaller",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_DAYSMALLER = new FinderPath(LmisViewWorkingCalendarModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewWorkingCalendarModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByDaySmaller",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_DAYTYPE = new FinderPath(LmisViewWorkingCalendarModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewWorkingCalendarModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByDayType",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_DAYTYPE = new FinderPath(LmisViewWorkingCalendarModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewWorkingCalendarModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByDayType",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_DAYTYPE = new FinderPath(LmisViewWorkingCalendarModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewWorkingCalendarModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByDayType",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_DAYVALUE = new FinderPath(LmisViewWorkingCalendarModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewWorkingCalendarModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByDayValue",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_DAYVALUE = new FinderPath(LmisViewWorkingCalendarModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewWorkingCalendarModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByDayValue",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_DAYVALUE = new FinderPath(LmisViewWorkingCalendarModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewWorkingCalendarModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByDayValue",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(LmisViewWorkingCalendarModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewWorkingCalendarModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LmisViewWorkingCalendarModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewWorkingCalendarModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(LmisViewWorkingCalendar lmisViewWorkingCalendar) {
		EntityCacheUtil.putResult(LmisViewWorkingCalendarModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewWorkingCalendarImpl.class,
			lmisViewWorkingCalendar.getPrimaryKey(), lmisViewWorkingCalendar);
	}

	public void cacheResult(
		List<LmisViewWorkingCalendar> lmisViewWorkingCalendars) {
		for (LmisViewWorkingCalendar lmisViewWorkingCalendar : lmisViewWorkingCalendars) {
			if (EntityCacheUtil.getResult(
						LmisViewWorkingCalendarModelImpl.ENTITY_CACHE_ENABLED,
						LmisViewWorkingCalendarImpl.class,
						lmisViewWorkingCalendar.getPrimaryKey(), this) == null) {
				cacheResult(lmisViewWorkingCalendar);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(LmisViewWorkingCalendarImpl.class.getName());
		EntityCacheUtil.clearCache(LmisViewWorkingCalendarImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public LmisViewWorkingCalendar create(Integer lmisViewWorkingCalendarId) {
		LmisViewWorkingCalendar lmisViewWorkingCalendar = new LmisViewWorkingCalendarImpl();

		lmisViewWorkingCalendar.setNew(true);
		lmisViewWorkingCalendar.setPrimaryKey(lmisViewWorkingCalendarId);

		return lmisViewWorkingCalendar;
	}

	public LmisViewWorkingCalendar remove(Integer lmisViewWorkingCalendarId)
		throws NoSuchLmisViewWorkingCalendarException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LmisViewWorkingCalendar lmisViewWorkingCalendar = (LmisViewWorkingCalendar)session.get(LmisViewWorkingCalendarImpl.class,
					lmisViewWorkingCalendarId);

			if (lmisViewWorkingCalendar == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No LmisViewWorkingCalendar exists with the primary key " +
						lmisViewWorkingCalendarId);
				}

				throw new NoSuchLmisViewWorkingCalendarException(
					"No LmisViewWorkingCalendar exists with the primary key " +
					lmisViewWorkingCalendarId);
			}

			return remove(lmisViewWorkingCalendar);
		}
		catch (NoSuchLmisViewWorkingCalendarException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public LmisViewWorkingCalendar remove(
		LmisViewWorkingCalendar lmisViewWorkingCalendar)
		throws SystemException {
		for (ModelListener<LmisViewWorkingCalendar> listener : listeners) {
			listener.onBeforeRemove(lmisViewWorkingCalendar);
		}

		lmisViewWorkingCalendar = removeImpl(lmisViewWorkingCalendar);

		for (ModelListener<LmisViewWorkingCalendar> listener : listeners) {
			listener.onAfterRemove(lmisViewWorkingCalendar);
		}

		return lmisViewWorkingCalendar;
	}

	protected LmisViewWorkingCalendar removeImpl(
		LmisViewWorkingCalendar lmisViewWorkingCalendar)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (lmisViewWorkingCalendar.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(LmisViewWorkingCalendarImpl.class,
						lmisViewWorkingCalendar.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(lmisViewWorkingCalendar);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(LmisViewWorkingCalendarModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewWorkingCalendarImpl.class,
			lmisViewWorkingCalendar.getPrimaryKey());

		return lmisViewWorkingCalendar;
	}

	public LmisViewWorkingCalendar update(
		LmisViewWorkingCalendar lmisViewWorkingCalendar)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(LmisViewWorkingCalendar lmisViewWorkingCalendar) method. Use update(LmisViewWorkingCalendar lmisViewWorkingCalendar, boolean merge) instead.");
		}

		return update(lmisViewWorkingCalendar, false);
	}

	public LmisViewWorkingCalendar update(
		LmisViewWorkingCalendar lmisViewWorkingCalendar, boolean merge)
		throws SystemException {
		boolean isNew = lmisViewWorkingCalendar.isNew();

		for (ModelListener<LmisViewWorkingCalendar> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(lmisViewWorkingCalendar);
			}
			else {
				listener.onBeforeUpdate(lmisViewWorkingCalendar);
			}
		}

		lmisViewWorkingCalendar = updateImpl(lmisViewWorkingCalendar, merge);

		for (ModelListener<LmisViewWorkingCalendar> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(lmisViewWorkingCalendar);
			}
			else {
				listener.onAfterUpdate(lmisViewWorkingCalendar);
			}
		}

		return lmisViewWorkingCalendar;
	}

	public LmisViewWorkingCalendar updateImpl(
		larion.progate.lmis.model.LmisViewWorkingCalendar lmisViewWorkingCalendar,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, lmisViewWorkingCalendar, merge);

			lmisViewWorkingCalendar.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(LmisViewWorkingCalendarModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewWorkingCalendarImpl.class,
			lmisViewWorkingCalendar.getPrimaryKey(), lmisViewWorkingCalendar);

		return lmisViewWorkingCalendar;
	}

	public LmisViewWorkingCalendar findByPrimaryKey(
		Integer lmisViewWorkingCalendarId)
		throws NoSuchLmisViewWorkingCalendarException, SystemException {
		LmisViewWorkingCalendar lmisViewWorkingCalendar = fetchByPrimaryKey(lmisViewWorkingCalendarId);

		if (lmisViewWorkingCalendar == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"No LmisViewWorkingCalendar exists with the primary key " +
					lmisViewWorkingCalendarId);
			}

			throw new NoSuchLmisViewWorkingCalendarException(
				"No LmisViewWorkingCalendar exists with the primary key " +
				lmisViewWorkingCalendarId);
		}

		return lmisViewWorkingCalendar;
	}

	public LmisViewWorkingCalendar fetchByPrimaryKey(
		Integer lmisViewWorkingCalendarId) throws SystemException {
		LmisViewWorkingCalendar lmisViewWorkingCalendar = (LmisViewWorkingCalendar)EntityCacheUtil.getResult(LmisViewWorkingCalendarModelImpl.ENTITY_CACHE_ENABLED,
				LmisViewWorkingCalendarImpl.class, lmisViewWorkingCalendarId,
				this);

		if (lmisViewWorkingCalendar == null) {
			Session session = null;

			try {
				session = openSession();

				lmisViewWorkingCalendar = (LmisViewWorkingCalendar)session.get(LmisViewWorkingCalendarImpl.class,
						lmisViewWorkingCalendarId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (lmisViewWorkingCalendar != null) {
					cacheResult(lmisViewWorkingCalendar);
				}

				closeSession(session);
			}
		}

		return lmisViewWorkingCalendar;
	}

	public List<LmisViewWorkingCalendar> findByRootID(int rootId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		List<LmisViewWorkingCalendar> list = (List<LmisViewWorkingCalendar>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewWorkingCalendar WHERE ");

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
					list = new ArrayList<LmisViewWorkingCalendar>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewWorkingCalendar> findByRootID(int rootId, int start,
		int end) throws SystemException {
		return findByRootID(rootId, start, end, null);
	}

	public List<LmisViewWorkingCalendar> findByRootID(int rootId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(rootId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewWorkingCalendar> list = (List<LmisViewWorkingCalendar>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewWorkingCalendar WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rootId);

				list = (List<LmisViewWorkingCalendar>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewWorkingCalendar>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewWorkingCalendar findByRootID_First(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisViewWorkingCalendarException, SystemException {
		List<LmisViewWorkingCalendar> list = findByRootID(rootId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewWorkingCalendar exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewWorkingCalendarException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewWorkingCalendar findByRootID_Last(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisViewWorkingCalendarException, SystemException {
		int count = countByRootID(rootId);

		List<LmisViewWorkingCalendar> list = findByRootID(rootId, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewWorkingCalendar exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewWorkingCalendarException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewWorkingCalendar[] findByRootID_PrevAndNext(
		Integer lmisViewWorkingCalendarId, int rootId, OrderByComparator obc)
		throws NoSuchLmisViewWorkingCalendarException, SystemException {
		LmisViewWorkingCalendar lmisViewWorkingCalendar = findByPrimaryKey(lmisViewWorkingCalendarId);

		int count = countByRootID(rootId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewWorkingCalendar WHERE ");

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
					lmisViewWorkingCalendar);

			LmisViewWorkingCalendar[] array = new LmisViewWorkingCalendarImpl[3];

			array[0] = (LmisViewWorkingCalendar)objArray[0];
			array[1] = (LmisViewWorkingCalendar)objArray[1];
			array[2] = (LmisViewWorkingCalendar)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewWorkingCalendar> findByDayGreater(Date dayValue)
		throws SystemException {
		Object[] finderArgs = new Object[] { dayValue };

		List<LmisViewWorkingCalendar> list = (List<LmisViewWorkingCalendar>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DAYGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewWorkingCalendar WHERE ");

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

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewWorkingCalendar>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DAYGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewWorkingCalendar> findByDayGreater(Date dayValue,
		int start, int end) throws SystemException {
		return findByDayGreater(dayValue, start, end, null);
	}

	public List<LmisViewWorkingCalendar> findByDayGreater(Date dayValue,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				dayValue,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewWorkingCalendar> list = (List<LmisViewWorkingCalendar>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_DAYGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewWorkingCalendar WHERE ");

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

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (dayValue != null) {
					qPos.add(CalendarUtil.getTimestamp(dayValue));
				}

				list = (List<LmisViewWorkingCalendar>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewWorkingCalendar>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_DAYGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewWorkingCalendar findByDayGreater_First(Date dayValue,
		OrderByComparator obc)
		throws NoSuchLmisViewWorkingCalendarException, SystemException {
		List<LmisViewWorkingCalendar> list = findByDayGreater(dayValue, 0, 1,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewWorkingCalendar exists with the key {");

			msg.append("dayValue=" + dayValue);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewWorkingCalendarException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewWorkingCalendar findByDayGreater_Last(Date dayValue,
		OrderByComparator obc)
		throws NoSuchLmisViewWorkingCalendarException, SystemException {
		int count = countByDayGreater(dayValue);

		List<LmisViewWorkingCalendar> list = findByDayGreater(dayValue,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewWorkingCalendar exists with the key {");

			msg.append("dayValue=" + dayValue);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewWorkingCalendarException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewWorkingCalendar[] findByDayGreater_PrevAndNext(
		Integer lmisViewWorkingCalendarId, Date dayValue, OrderByComparator obc)
		throws NoSuchLmisViewWorkingCalendarException, SystemException {
		LmisViewWorkingCalendar lmisViewWorkingCalendar = findByPrimaryKey(lmisViewWorkingCalendarId);

		int count = countByDayGreater(dayValue);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewWorkingCalendar WHERE ");

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

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (dayValue != null) {
				qPos.add(CalendarUtil.getTimestamp(dayValue));
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisViewWorkingCalendar);

			LmisViewWorkingCalendar[] array = new LmisViewWorkingCalendarImpl[3];

			array[0] = (LmisViewWorkingCalendar)objArray[0];
			array[1] = (LmisViewWorkingCalendar)objArray[1];
			array[2] = (LmisViewWorkingCalendar)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewWorkingCalendar> findByDaySmaller(Date dayValue)
		throws SystemException {
		Object[] finderArgs = new Object[] { dayValue };

		List<LmisViewWorkingCalendar> list = (List<LmisViewWorkingCalendar>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DAYSMALLER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewWorkingCalendar WHERE ");

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

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewWorkingCalendar>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DAYSMALLER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewWorkingCalendar> findByDaySmaller(Date dayValue,
		int start, int end) throws SystemException {
		return findByDaySmaller(dayValue, start, end, null);
	}

	public List<LmisViewWorkingCalendar> findByDaySmaller(Date dayValue,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				dayValue,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewWorkingCalendar> list = (List<LmisViewWorkingCalendar>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_DAYSMALLER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewWorkingCalendar WHERE ");

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

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (dayValue != null) {
					qPos.add(CalendarUtil.getTimestamp(dayValue));
				}

				list = (List<LmisViewWorkingCalendar>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewWorkingCalendar>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_DAYSMALLER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewWorkingCalendar findByDaySmaller_First(Date dayValue,
		OrderByComparator obc)
		throws NoSuchLmisViewWorkingCalendarException, SystemException {
		List<LmisViewWorkingCalendar> list = findByDaySmaller(dayValue, 0, 1,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewWorkingCalendar exists with the key {");

			msg.append("dayValue=" + dayValue);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewWorkingCalendarException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewWorkingCalendar findByDaySmaller_Last(Date dayValue,
		OrderByComparator obc)
		throws NoSuchLmisViewWorkingCalendarException, SystemException {
		int count = countByDaySmaller(dayValue);

		List<LmisViewWorkingCalendar> list = findByDaySmaller(dayValue,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewWorkingCalendar exists with the key {");

			msg.append("dayValue=" + dayValue);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewWorkingCalendarException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewWorkingCalendar[] findByDaySmaller_PrevAndNext(
		Integer lmisViewWorkingCalendarId, Date dayValue, OrderByComparator obc)
		throws NoSuchLmisViewWorkingCalendarException, SystemException {
		LmisViewWorkingCalendar lmisViewWorkingCalendar = findByPrimaryKey(lmisViewWorkingCalendarId);

		int count = countByDaySmaller(dayValue);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewWorkingCalendar WHERE ");

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

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (dayValue != null) {
				qPos.add(CalendarUtil.getTimestamp(dayValue));
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisViewWorkingCalendar);

			LmisViewWorkingCalendar[] array = new LmisViewWorkingCalendarImpl[3];

			array[0] = (LmisViewWorkingCalendar)objArray[0];
			array[1] = (LmisViewWorkingCalendar)objArray[1];
			array[2] = (LmisViewWorkingCalendar)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewWorkingCalendar> findByDayType(int dayType)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(dayType) };

		List<LmisViewWorkingCalendar> list = (List<LmisViewWorkingCalendar>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DAYTYPE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewWorkingCalendar WHERE ");

				query.append("day_type = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dayType);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewWorkingCalendar>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DAYTYPE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewWorkingCalendar> findByDayType(int dayType, int start,
		int end) throws SystemException {
		return findByDayType(dayType, start, end, null);
	}

	public List<LmisViewWorkingCalendar> findByDayType(int dayType, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(dayType),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewWorkingCalendar> list = (List<LmisViewWorkingCalendar>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_DAYTYPE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewWorkingCalendar WHERE ");

				query.append("day_type = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dayType);

				list = (List<LmisViewWorkingCalendar>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewWorkingCalendar>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_DAYTYPE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewWorkingCalendar findByDayType_First(int dayType,
		OrderByComparator obc)
		throws NoSuchLmisViewWorkingCalendarException, SystemException {
		List<LmisViewWorkingCalendar> list = findByDayType(dayType, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewWorkingCalendar exists with the key {");

			msg.append("dayType=" + dayType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewWorkingCalendarException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewWorkingCalendar findByDayType_Last(int dayType,
		OrderByComparator obc)
		throws NoSuchLmisViewWorkingCalendarException, SystemException {
		int count = countByDayType(dayType);

		List<LmisViewWorkingCalendar> list = findByDayType(dayType, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewWorkingCalendar exists with the key {");

			msg.append("dayType=" + dayType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewWorkingCalendarException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewWorkingCalendar[] findByDayType_PrevAndNext(
		Integer lmisViewWorkingCalendarId, int dayType, OrderByComparator obc)
		throws NoSuchLmisViewWorkingCalendarException, SystemException {
		LmisViewWorkingCalendar lmisViewWorkingCalendar = findByPrimaryKey(lmisViewWorkingCalendarId);

		int count = countByDayType(dayType);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewWorkingCalendar WHERE ");

			query.append("day_type = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(dayType);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisViewWorkingCalendar);

			LmisViewWorkingCalendar[] array = new LmisViewWorkingCalendarImpl[3];

			array[0] = (LmisViewWorkingCalendar)objArray[0];
			array[1] = (LmisViewWorkingCalendar)objArray[1];
			array[2] = (LmisViewWorkingCalendar)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewWorkingCalendar> findByDayValue(Date dayValue)
		throws SystemException {
		Object[] finderArgs = new Object[] { dayValue };

		List<LmisViewWorkingCalendar> list = (List<LmisViewWorkingCalendar>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DAYVALUE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewWorkingCalendar WHERE ");

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

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewWorkingCalendar>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DAYVALUE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewWorkingCalendar> findByDayValue(Date dayValue,
		int start, int end) throws SystemException {
		return findByDayValue(dayValue, start, end, null);
	}

	public List<LmisViewWorkingCalendar> findByDayValue(Date dayValue,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				dayValue,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewWorkingCalendar> list = (List<LmisViewWorkingCalendar>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_DAYVALUE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewWorkingCalendar WHERE ");

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

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (dayValue != null) {
					qPos.add(CalendarUtil.getTimestamp(dayValue));
				}

				list = (List<LmisViewWorkingCalendar>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewWorkingCalendar>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_DAYVALUE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewWorkingCalendar findByDayValue_First(Date dayValue,
		OrderByComparator obc)
		throws NoSuchLmisViewWorkingCalendarException, SystemException {
		List<LmisViewWorkingCalendar> list = findByDayValue(dayValue, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewWorkingCalendar exists with the key {");

			msg.append("dayValue=" + dayValue);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewWorkingCalendarException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewWorkingCalendar findByDayValue_Last(Date dayValue,
		OrderByComparator obc)
		throws NoSuchLmisViewWorkingCalendarException, SystemException {
		int count = countByDayValue(dayValue);

		List<LmisViewWorkingCalendar> list = findByDayValue(dayValue,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewWorkingCalendar exists with the key {");

			msg.append("dayValue=" + dayValue);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewWorkingCalendarException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewWorkingCalendar[] findByDayValue_PrevAndNext(
		Integer lmisViewWorkingCalendarId, Date dayValue, OrderByComparator obc)
		throws NoSuchLmisViewWorkingCalendarException, SystemException {
		LmisViewWorkingCalendar lmisViewWorkingCalendar = findByPrimaryKey(lmisViewWorkingCalendarId);

		int count = countByDayValue(dayValue);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewWorkingCalendar WHERE ");

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

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (dayValue != null) {
				qPos.add(CalendarUtil.getTimestamp(dayValue));
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisViewWorkingCalendar);

			LmisViewWorkingCalendar[] array = new LmisViewWorkingCalendarImpl[3];

			array[0] = (LmisViewWorkingCalendar)objArray[0];
			array[1] = (LmisViewWorkingCalendar)objArray[1];
			array[2] = (LmisViewWorkingCalendar)objArray[2];

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

	public List<LmisViewWorkingCalendar> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<LmisViewWorkingCalendar> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<LmisViewWorkingCalendar> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewWorkingCalendar> list = (List<LmisViewWorkingCalendar>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewWorkingCalendar ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<LmisViewWorkingCalendar>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LmisViewWorkingCalendar>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewWorkingCalendar>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByRootID(int rootId) throws SystemException {
		for (LmisViewWorkingCalendar lmisViewWorkingCalendar : findByRootID(
				rootId)) {
			remove(lmisViewWorkingCalendar);
		}
	}

	public void removeByDayGreater(Date dayValue) throws SystemException {
		for (LmisViewWorkingCalendar lmisViewWorkingCalendar : findByDayGreater(
				dayValue)) {
			remove(lmisViewWorkingCalendar);
		}
	}

	public void removeByDaySmaller(Date dayValue) throws SystemException {
		for (LmisViewWorkingCalendar lmisViewWorkingCalendar : findByDaySmaller(
				dayValue)) {
			remove(lmisViewWorkingCalendar);
		}
	}

	public void removeByDayType(int dayType) throws SystemException {
		for (LmisViewWorkingCalendar lmisViewWorkingCalendar : findByDayType(
				dayType)) {
			remove(lmisViewWorkingCalendar);
		}
	}

	public void removeByDayValue(Date dayValue) throws SystemException {
		for (LmisViewWorkingCalendar lmisViewWorkingCalendar : findByDayValue(
				dayValue)) {
			remove(lmisViewWorkingCalendar);
		}
	}

	public void removeAll() throws SystemException {
		for (LmisViewWorkingCalendar lmisViewWorkingCalendar : findAll()) {
			remove(lmisViewWorkingCalendar);
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
					"FROM larion.progate.lmis.model.LmisViewWorkingCalendar WHERE ");

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
					"FROM larion.progate.lmis.model.LmisViewWorkingCalendar WHERE ");

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
					"FROM larion.progate.lmis.model.LmisViewWorkingCalendar WHERE ");

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

	public int countByDayType(int dayType) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(dayType) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DAYTYPE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisViewWorkingCalendar WHERE ");

				query.append("day_type = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dayType);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DAYTYPE,
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
					"FROM larion.progate.lmis.model.LmisViewWorkingCalendar WHERE ");

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

	public int countAll() throws SystemException {
		Object[] finderArgs = new Object[0];

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(
						"SELECT COUNT(*) FROM larion.progate.lmis.model.LmisViewWorkingCalendar");

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
						"value.object.listener.larion.progate.lmis.model.LmisViewWorkingCalendar")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LmisViewWorkingCalendar>> listenersList = new ArrayList<ModelListener<LmisViewWorkingCalendar>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LmisViewWorkingCalendar>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(LmisViewWorkingCalendarPersistenceImpl.class);
}