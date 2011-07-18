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
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQuery;
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQueryFactoryUtil;
import com.liferay.portal.kernel.dao.jdbc.RowMapper;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
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

import larion.progate.lmis.NoSuchLmisWorkingCalendarsException;
import larion.progate.lmis.model.LmisWorkingCalendars;
import larion.progate.lmis.model.impl.LmisWorkingCalendarsImpl;
import larion.progate.lmis.model.impl.LmisWorkingCalendarsModelImpl;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * <a href="LmisWorkingCalendarsPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisWorkingCalendarsPersistenceImpl extends BasePersistenceImpl
	implements LmisWorkingCalendarsPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = LmisWorkingCalendarsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_WORKINGCALENDAROF = new FinderPath(LmisWorkingCalendarsModelImpl.ENTITY_CACHE_ENABLED,
			LmisWorkingCalendarsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByWorkingCalendarOf",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_WORKINGCALENDAROF = new FinderPath(LmisWorkingCalendarsModelImpl.ENTITY_CACHE_ENABLED,
			LmisWorkingCalendarsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByWorkingCalendarOf",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_WORKINGCALENDAROF = new FinderPath(LmisWorkingCalendarsModelImpl.ENTITY_CACHE_ENABLED,
			LmisWorkingCalendarsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByWorkingCalendarOf",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_DAYGREATER = new FinderPath(LmisWorkingCalendarsModelImpl.ENTITY_CACHE_ENABLED,
			LmisWorkingCalendarsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByDayGreater",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_DAYGREATER = new FinderPath(LmisWorkingCalendarsModelImpl.ENTITY_CACHE_ENABLED,
			LmisWorkingCalendarsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByDayGreater",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_DAYGREATER = new FinderPath(LmisWorkingCalendarsModelImpl.ENTITY_CACHE_ENABLED,
			LmisWorkingCalendarsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByDayGreater",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_DAYSMALLER = new FinderPath(LmisWorkingCalendarsModelImpl.ENTITY_CACHE_ENABLED,
			LmisWorkingCalendarsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByDaySmaller",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_DAYSMALLER = new FinderPath(LmisWorkingCalendarsModelImpl.ENTITY_CACHE_ENABLED,
			LmisWorkingCalendarsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByDaySmaller",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_DAYSMALLER = new FinderPath(LmisWorkingCalendarsModelImpl.ENTITY_CACHE_ENABLED,
			LmisWorkingCalendarsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByDaySmaller",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_DAYTYPE = new FinderPath(LmisWorkingCalendarsModelImpl.ENTITY_CACHE_ENABLED,
			LmisWorkingCalendarsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByDayType",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_DAYTYPE = new FinderPath(LmisWorkingCalendarsModelImpl.ENTITY_CACHE_ENABLED,
			LmisWorkingCalendarsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByDayType",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_DAYTYPE = new FinderPath(LmisWorkingCalendarsModelImpl.ENTITY_CACHE_ENABLED,
			LmisWorkingCalendarsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByDayType",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_DAYVALUE = new FinderPath(LmisWorkingCalendarsModelImpl.ENTITY_CACHE_ENABLED,
			LmisWorkingCalendarsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByDayValue",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_DAYVALUE = new FinderPath(LmisWorkingCalendarsModelImpl.ENTITY_CACHE_ENABLED,
			LmisWorkingCalendarsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByDayValue",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_DAYVALUE = new FinderPath(LmisWorkingCalendarsModelImpl.ENTITY_CACHE_ENABLED,
			LmisWorkingCalendarsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByDayValue",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(LmisWorkingCalendarsModelImpl.ENTITY_CACHE_ENABLED,
			LmisWorkingCalendarsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LmisWorkingCalendarsModelImpl.ENTITY_CACHE_ENABLED,
			LmisWorkingCalendarsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(LmisWorkingCalendars lmisWorkingCalendars) {
		EntityCacheUtil.putResult(LmisWorkingCalendarsModelImpl.ENTITY_CACHE_ENABLED,
			LmisWorkingCalendarsImpl.class,
			lmisWorkingCalendars.getPrimaryKey(), lmisWorkingCalendars);
	}

	public void cacheResult(List<LmisWorkingCalendars> lmisWorkingCalendarses) {
		for (LmisWorkingCalendars lmisWorkingCalendars : lmisWorkingCalendarses) {
			if (EntityCacheUtil.getResult(
						LmisWorkingCalendarsModelImpl.ENTITY_CACHE_ENABLED,
						LmisWorkingCalendarsImpl.class,
						lmisWorkingCalendars.getPrimaryKey(), this) == null) {
				cacheResult(lmisWorkingCalendars);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(LmisWorkingCalendarsImpl.class.getName());
		EntityCacheUtil.clearCache(LmisWorkingCalendarsImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public LmisWorkingCalendars create(Integer lmisWorkingCalendarId) {
		LmisWorkingCalendars lmisWorkingCalendars = new LmisWorkingCalendarsImpl();

		lmisWorkingCalendars.setNew(true);
		lmisWorkingCalendars.setPrimaryKey(lmisWorkingCalendarId);

		return lmisWorkingCalendars;
	}

	public LmisWorkingCalendars remove(Integer lmisWorkingCalendarId)
		throws NoSuchLmisWorkingCalendarsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LmisWorkingCalendars lmisWorkingCalendars = (LmisWorkingCalendars)session.get(LmisWorkingCalendarsImpl.class,
					lmisWorkingCalendarId);

			if (lmisWorkingCalendars == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No LmisWorkingCalendars exists with the primary key " +
						lmisWorkingCalendarId);
				}

				throw new NoSuchLmisWorkingCalendarsException(
					"No LmisWorkingCalendars exists with the primary key " +
					lmisWorkingCalendarId);
			}

			return remove(lmisWorkingCalendars);
		}
		catch (NoSuchLmisWorkingCalendarsException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public LmisWorkingCalendars remove(
		LmisWorkingCalendars lmisWorkingCalendars) throws SystemException {
		for (ModelListener<LmisWorkingCalendars> listener : listeners) {
			listener.onBeforeRemove(lmisWorkingCalendars);
		}

		lmisWorkingCalendars = removeImpl(lmisWorkingCalendars);

		for (ModelListener<LmisWorkingCalendars> listener : listeners) {
			listener.onAfterRemove(lmisWorkingCalendars);
		}

		return lmisWorkingCalendars;
	}

	protected LmisWorkingCalendars removeImpl(
		LmisWorkingCalendars lmisWorkingCalendars) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (lmisWorkingCalendars.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(LmisWorkingCalendarsImpl.class,
						lmisWorkingCalendars.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(lmisWorkingCalendars);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(LmisWorkingCalendarsModelImpl.ENTITY_CACHE_ENABLED,
			LmisWorkingCalendarsImpl.class, lmisWorkingCalendars.getPrimaryKey());

		return lmisWorkingCalendars;
	}

	public LmisWorkingCalendars update(
		LmisWorkingCalendars lmisWorkingCalendars) throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(LmisWorkingCalendars lmisWorkingCalendars) method. Use update(LmisWorkingCalendars lmisWorkingCalendars, boolean merge) instead.");
		}

		return update(lmisWorkingCalendars, false);
	}

	public LmisWorkingCalendars update(
		LmisWorkingCalendars lmisWorkingCalendars, boolean merge)
		throws SystemException {
		boolean isNew = lmisWorkingCalendars.isNew();

		for (ModelListener<LmisWorkingCalendars> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(lmisWorkingCalendars);
			}
			else {
				listener.onBeforeUpdate(lmisWorkingCalendars);
			}
		}

		lmisWorkingCalendars = updateImpl(lmisWorkingCalendars, merge);

		for (ModelListener<LmisWorkingCalendars> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(lmisWorkingCalendars);
			}
			else {
				listener.onAfterUpdate(lmisWorkingCalendars);
			}
		}

		return lmisWorkingCalendars;
	}

	public LmisWorkingCalendars updateImpl(
		larion.progate.lmis.model.LmisWorkingCalendars lmisWorkingCalendars,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, lmisWorkingCalendars, merge);

			lmisWorkingCalendars.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(LmisWorkingCalendarsModelImpl.ENTITY_CACHE_ENABLED,
			LmisWorkingCalendarsImpl.class,
			lmisWorkingCalendars.getPrimaryKey(), lmisWorkingCalendars);

		return lmisWorkingCalendars;
	}

	public LmisWorkingCalendars findByPrimaryKey(Integer lmisWorkingCalendarId)
		throws NoSuchLmisWorkingCalendarsException, SystemException {
		LmisWorkingCalendars lmisWorkingCalendars = fetchByPrimaryKey(lmisWorkingCalendarId);

		if (lmisWorkingCalendars == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"No LmisWorkingCalendars exists with the primary key " +
					lmisWorkingCalendarId);
			}

			throw new NoSuchLmisWorkingCalendarsException(
				"No LmisWorkingCalendars exists with the primary key " +
				lmisWorkingCalendarId);
		}

		return lmisWorkingCalendars;
	}

	public LmisWorkingCalendars fetchByPrimaryKey(Integer lmisWorkingCalendarId)
		throws SystemException {
		LmisWorkingCalendars lmisWorkingCalendars = (LmisWorkingCalendars)EntityCacheUtil.getResult(LmisWorkingCalendarsModelImpl.ENTITY_CACHE_ENABLED,
				LmisWorkingCalendarsImpl.class, lmisWorkingCalendarId, this);

		if (lmisWorkingCalendars == null) {
			Session session = null;

			try {
				session = openSession();

				lmisWorkingCalendars = (LmisWorkingCalendars)session.get(LmisWorkingCalendarsImpl.class,
						lmisWorkingCalendarId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (lmisWorkingCalendars != null) {
					cacheResult(lmisWorkingCalendars);
				}

				closeSession(session);
			}
		}

		return lmisWorkingCalendars;
	}

	public List<LmisWorkingCalendars> findByWorkingCalendarOf(int rootId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		List<LmisWorkingCalendars> list = (List<LmisWorkingCalendars>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_WORKINGCALENDAROF,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisWorkingCalendars WHERE ");

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
					list = new ArrayList<LmisWorkingCalendars>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_WORKINGCALENDAROF,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisWorkingCalendars> findByWorkingCalendarOf(int rootId,
		int start, int end) throws SystemException {
		return findByWorkingCalendarOf(rootId, start, end, null);
	}

	public List<LmisWorkingCalendars> findByWorkingCalendarOf(int rootId,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(rootId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisWorkingCalendars> list = (List<LmisWorkingCalendars>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_WORKINGCALENDAROF,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisWorkingCalendars WHERE ");

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

				list = (List<LmisWorkingCalendars>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisWorkingCalendars>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_WORKINGCALENDAROF,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisWorkingCalendars findByWorkingCalendarOf_First(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisWorkingCalendarsException, SystemException {
		List<LmisWorkingCalendars> list = findByWorkingCalendarOf(rootId, 0, 1,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisWorkingCalendars exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisWorkingCalendarsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisWorkingCalendars findByWorkingCalendarOf_Last(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisWorkingCalendarsException, SystemException {
		int count = countByWorkingCalendarOf(rootId);

		List<LmisWorkingCalendars> list = findByWorkingCalendarOf(rootId,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisWorkingCalendars exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisWorkingCalendarsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisWorkingCalendars[] findByWorkingCalendarOf_PrevAndNext(
		Integer lmisWorkingCalendarId, int rootId, OrderByComparator obc)
		throws NoSuchLmisWorkingCalendarsException, SystemException {
		LmisWorkingCalendars lmisWorkingCalendars = findByPrimaryKey(lmisWorkingCalendarId);

		int count = countByWorkingCalendarOf(rootId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisWorkingCalendars WHERE ");

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
					lmisWorkingCalendars);

			LmisWorkingCalendars[] array = new LmisWorkingCalendarsImpl[3];

			array[0] = (LmisWorkingCalendars)objArray[0];
			array[1] = (LmisWorkingCalendars)objArray[1];
			array[2] = (LmisWorkingCalendars)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisWorkingCalendars> findByDayGreater(Date dayValue)
		throws SystemException {
		Object[] finderArgs = new Object[] { dayValue };

		List<LmisWorkingCalendars> list = (List<LmisWorkingCalendars>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DAYGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisWorkingCalendars WHERE ");

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
					list = new ArrayList<LmisWorkingCalendars>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DAYGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisWorkingCalendars> findByDayGreater(Date dayValue,
		int start, int end) throws SystemException {
		return findByDayGreater(dayValue, start, end, null);
	}

	public List<LmisWorkingCalendars> findByDayGreater(Date dayValue,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				dayValue,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisWorkingCalendars> list = (List<LmisWorkingCalendars>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_DAYGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisWorkingCalendars WHERE ");

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

				list = (List<LmisWorkingCalendars>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisWorkingCalendars>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_DAYGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisWorkingCalendars findByDayGreater_First(Date dayValue,
		OrderByComparator obc)
		throws NoSuchLmisWorkingCalendarsException, SystemException {
		List<LmisWorkingCalendars> list = findByDayGreater(dayValue, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisWorkingCalendars exists with the key {");

			msg.append("dayValue=" + dayValue);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisWorkingCalendarsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisWorkingCalendars findByDayGreater_Last(Date dayValue,
		OrderByComparator obc)
		throws NoSuchLmisWorkingCalendarsException, SystemException {
		int count = countByDayGreater(dayValue);

		List<LmisWorkingCalendars> list = findByDayGreater(dayValue, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisWorkingCalendars exists with the key {");

			msg.append("dayValue=" + dayValue);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisWorkingCalendarsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisWorkingCalendars[] findByDayGreater_PrevAndNext(
		Integer lmisWorkingCalendarId, Date dayValue, OrderByComparator obc)
		throws NoSuchLmisWorkingCalendarsException, SystemException {
		LmisWorkingCalendars lmisWorkingCalendars = findByPrimaryKey(lmisWorkingCalendarId);

		int count = countByDayGreater(dayValue);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisWorkingCalendars WHERE ");

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
					lmisWorkingCalendars);

			LmisWorkingCalendars[] array = new LmisWorkingCalendarsImpl[3];

			array[0] = (LmisWorkingCalendars)objArray[0];
			array[1] = (LmisWorkingCalendars)objArray[1];
			array[2] = (LmisWorkingCalendars)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisWorkingCalendars> findByDaySmaller(Date dayValue)
		throws SystemException {
		Object[] finderArgs = new Object[] { dayValue };

		List<LmisWorkingCalendars> list = (List<LmisWorkingCalendars>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DAYSMALLER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisWorkingCalendars WHERE ");

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
					list = new ArrayList<LmisWorkingCalendars>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DAYSMALLER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisWorkingCalendars> findByDaySmaller(Date dayValue,
		int start, int end) throws SystemException {
		return findByDaySmaller(dayValue, start, end, null);
	}

	public List<LmisWorkingCalendars> findByDaySmaller(Date dayValue,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				dayValue,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisWorkingCalendars> list = (List<LmisWorkingCalendars>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_DAYSMALLER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisWorkingCalendars WHERE ");

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

				list = (List<LmisWorkingCalendars>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisWorkingCalendars>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_DAYSMALLER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisWorkingCalendars findByDaySmaller_First(Date dayValue,
		OrderByComparator obc)
		throws NoSuchLmisWorkingCalendarsException, SystemException {
		List<LmisWorkingCalendars> list = findByDaySmaller(dayValue, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisWorkingCalendars exists with the key {");

			msg.append("dayValue=" + dayValue);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisWorkingCalendarsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisWorkingCalendars findByDaySmaller_Last(Date dayValue,
		OrderByComparator obc)
		throws NoSuchLmisWorkingCalendarsException, SystemException {
		int count = countByDaySmaller(dayValue);

		List<LmisWorkingCalendars> list = findByDaySmaller(dayValue, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisWorkingCalendars exists with the key {");

			msg.append("dayValue=" + dayValue);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisWorkingCalendarsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisWorkingCalendars[] findByDaySmaller_PrevAndNext(
		Integer lmisWorkingCalendarId, Date dayValue, OrderByComparator obc)
		throws NoSuchLmisWorkingCalendarsException, SystemException {
		LmisWorkingCalendars lmisWorkingCalendars = findByPrimaryKey(lmisWorkingCalendarId);

		int count = countByDaySmaller(dayValue);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisWorkingCalendars WHERE ");

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
					lmisWorkingCalendars);

			LmisWorkingCalendars[] array = new LmisWorkingCalendarsImpl[3];

			array[0] = (LmisWorkingCalendars)objArray[0];
			array[1] = (LmisWorkingCalendars)objArray[1];
			array[2] = (LmisWorkingCalendars)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisWorkingCalendars> findByDayType(int dayType)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(dayType) };

		List<LmisWorkingCalendars> list = (List<LmisWorkingCalendars>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DAYTYPE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisWorkingCalendars WHERE ");

				query.append("day_type = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("day_value ASC");

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
					list = new ArrayList<LmisWorkingCalendars>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DAYTYPE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisWorkingCalendars> findByDayType(int dayType, int start,
		int end) throws SystemException {
		return findByDayType(dayType, start, end, null);
	}

	public List<LmisWorkingCalendars> findByDayType(int dayType, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(dayType),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisWorkingCalendars> list = (List<LmisWorkingCalendars>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_DAYTYPE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisWorkingCalendars WHERE ");

				query.append("day_type = ?");

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

				qPos.add(dayType);

				list = (List<LmisWorkingCalendars>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisWorkingCalendars>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_DAYTYPE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisWorkingCalendars findByDayType_First(int dayType,
		OrderByComparator obc)
		throws NoSuchLmisWorkingCalendarsException, SystemException {
		List<LmisWorkingCalendars> list = findByDayType(dayType, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisWorkingCalendars exists with the key {");

			msg.append("dayType=" + dayType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisWorkingCalendarsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisWorkingCalendars findByDayType_Last(int dayType,
		OrderByComparator obc)
		throws NoSuchLmisWorkingCalendarsException, SystemException {
		int count = countByDayType(dayType);

		List<LmisWorkingCalendars> list = findByDayType(dayType, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisWorkingCalendars exists with the key {");

			msg.append("dayType=" + dayType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisWorkingCalendarsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisWorkingCalendars[] findByDayType_PrevAndNext(
		Integer lmisWorkingCalendarId, int dayType, OrderByComparator obc)
		throws NoSuchLmisWorkingCalendarsException, SystemException {
		LmisWorkingCalendars lmisWorkingCalendars = findByPrimaryKey(lmisWorkingCalendarId);

		int count = countByDayType(dayType);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisWorkingCalendars WHERE ");

			query.append("day_type = ?");

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

			qPos.add(dayType);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisWorkingCalendars);

			LmisWorkingCalendars[] array = new LmisWorkingCalendarsImpl[3];

			array[0] = (LmisWorkingCalendars)objArray[0];
			array[1] = (LmisWorkingCalendars)objArray[1];
			array[2] = (LmisWorkingCalendars)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisWorkingCalendars> findByDayValue(Date dayValue)
		throws SystemException {
		Object[] finderArgs = new Object[] { dayValue };

		List<LmisWorkingCalendars> list = (List<LmisWorkingCalendars>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DAYVALUE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisWorkingCalendars WHERE ");

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
					list = new ArrayList<LmisWorkingCalendars>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DAYVALUE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisWorkingCalendars> findByDayValue(Date dayValue, int start,
		int end) throws SystemException {
		return findByDayValue(dayValue, start, end, null);
	}

	public List<LmisWorkingCalendars> findByDayValue(Date dayValue, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				dayValue,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisWorkingCalendars> list = (List<LmisWorkingCalendars>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_DAYVALUE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisWorkingCalendars WHERE ");

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

				list = (List<LmisWorkingCalendars>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisWorkingCalendars>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_DAYVALUE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisWorkingCalendars findByDayValue_First(Date dayValue,
		OrderByComparator obc)
		throws NoSuchLmisWorkingCalendarsException, SystemException {
		List<LmisWorkingCalendars> list = findByDayValue(dayValue, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisWorkingCalendars exists with the key {");

			msg.append("dayValue=" + dayValue);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisWorkingCalendarsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisWorkingCalendars findByDayValue_Last(Date dayValue,
		OrderByComparator obc)
		throws NoSuchLmisWorkingCalendarsException, SystemException {
		int count = countByDayValue(dayValue);

		List<LmisWorkingCalendars> list = findByDayValue(dayValue, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisWorkingCalendars exists with the key {");

			msg.append("dayValue=" + dayValue);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisWorkingCalendarsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisWorkingCalendars[] findByDayValue_PrevAndNext(
		Integer lmisWorkingCalendarId, Date dayValue, OrderByComparator obc)
		throws NoSuchLmisWorkingCalendarsException, SystemException {
		LmisWorkingCalendars lmisWorkingCalendars = findByPrimaryKey(lmisWorkingCalendarId);

		int count = countByDayValue(dayValue);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisWorkingCalendars WHERE ");

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
					lmisWorkingCalendars);

			LmisWorkingCalendars[] array = new LmisWorkingCalendarsImpl[3];

			array[0] = (LmisWorkingCalendars)objArray[0];
			array[1] = (LmisWorkingCalendars)objArray[1];
			array[2] = (LmisWorkingCalendars)objArray[2];

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

	public List<LmisWorkingCalendars> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<LmisWorkingCalendars> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<LmisWorkingCalendars> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisWorkingCalendars> list = (List<LmisWorkingCalendars>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisWorkingCalendars ");

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
					list = (List<LmisWorkingCalendars>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LmisWorkingCalendars>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisWorkingCalendars>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByWorkingCalendarOf(int rootId) throws SystemException {
		for (LmisWorkingCalendars lmisWorkingCalendars : findByWorkingCalendarOf(
				rootId)) {
			remove(lmisWorkingCalendars);
		}
	}

	public void removeByDayGreater(Date dayValue) throws SystemException {
		for (LmisWorkingCalendars lmisWorkingCalendars : findByDayGreater(
				dayValue)) {
			remove(lmisWorkingCalendars);
		}
	}

	public void removeByDaySmaller(Date dayValue) throws SystemException {
		for (LmisWorkingCalendars lmisWorkingCalendars : findByDaySmaller(
				dayValue)) {
			remove(lmisWorkingCalendars);
		}
	}

	public void removeByDayType(int dayType) throws SystemException {
		for (LmisWorkingCalendars lmisWorkingCalendars : findByDayType(dayType)) {
			remove(lmisWorkingCalendars);
		}
	}

	public void removeByDayValue(Date dayValue) throws SystemException {
		for (LmisWorkingCalendars lmisWorkingCalendars : findByDayValue(
				dayValue)) {
			remove(lmisWorkingCalendars);
		}
	}

	public void removeAll() throws SystemException {
		for (LmisWorkingCalendars lmisWorkingCalendars : findAll()) {
			remove(lmisWorkingCalendars);
		}
	}

	public int countByWorkingCalendarOf(int rootId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_WORKINGCALENDAROF,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisWorkingCalendars WHERE ");

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_WORKINGCALENDAROF,
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
					"FROM larion.progate.lmis.model.LmisWorkingCalendars WHERE ");

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
					"FROM larion.progate.lmis.model.LmisWorkingCalendars WHERE ");

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
					"FROM larion.progate.lmis.model.LmisWorkingCalendars WHERE ");

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
					"FROM larion.progate.lmis.model.LmisWorkingCalendars WHERE ");

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
						"SELECT COUNT(*) FROM larion.progate.lmis.model.LmisWorkingCalendars");

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

	public List<larion.progate.lmis.model.LmisWorkingCalendarSessions> getLmisWorkingCalendarSessionses(
		Integer pk) throws SystemException {
		return getLmisWorkingCalendarSessionses(pk, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS);
	}

	public List<larion.progate.lmis.model.LmisWorkingCalendarSessions> getLmisWorkingCalendarSessionses(
		Integer pk, int start, int end) throws SystemException {
		return getLmisWorkingCalendarSessionses(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_LMISWORKINGCALENDARSESSIONSES =
		new FinderPath(larion.progate.lmis.model.impl.LmisWorkingCalendarSessionsModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.lmis.model.impl.LmisWorkingCalendarSessionsModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.lmis.service.persistence.LmisWorkingCalendarSessionsPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getLmisWorkingCalendarSessionses",
			new String[] {
				Integer.class.getName(), "java.lang.Integer",
				"java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	public List<larion.progate.lmis.model.LmisWorkingCalendarSessions> getLmisWorkingCalendarSessionses(
		Integer pk, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				pk, String.valueOf(start), String.valueOf(end),
				String.valueOf(obc)
			};

		List<larion.progate.lmis.model.LmisWorkingCalendarSessions> list = (List<larion.progate.lmis.model.LmisWorkingCalendarSessions>)FinderCacheUtil.getResult(FINDER_PATH_GET_LMISWORKINGCALENDARSESSIONSES,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder sb = new StringBuilder();

				sb.append(_SQL_GETLMISWORKINGCALENDARSESSIONSES);

				if (obc != null) {
					sb.append("ORDER BY ");
					sb.append(obc.getOrderBy());
				}

				String sql = sb.toString();

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("lmis_working_calendar_sessions",
					larion.progate.lmis.model.impl.LmisWorkingCalendarSessionsImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<larion.progate.lmis.model.LmisWorkingCalendarSessions>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<larion.progate.lmis.model.LmisWorkingCalendarSessions>();
				}

				lmisWorkingCalendarSessionsPersistence.cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_GET_LMISWORKINGCALENDARSESSIONSES,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_LMISWORKINGCALENDARSESSIONSES_SIZE =
		new FinderPath(larion.progate.lmis.model.impl.LmisWorkingCalendarSessionsModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.lmis.model.impl.LmisWorkingCalendarSessionsModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.lmis.service.persistence.LmisWorkingCalendarSessionsPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getLmisWorkingCalendarSessionsesSize",
			new String[] { Integer.class.getName() });

	public int getLmisWorkingCalendarSessionsesSize(Integer pk)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_LMISWORKINGCALENDARSESSIONSES_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETLMISWORKINGCALENDARSESSIONSESSIZE);

				q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_GET_LMISWORKINGCALENDARSESSIONSES_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_LMISWORKINGCALENDARSESSIONS =
		new FinderPath(larion.progate.lmis.model.impl.LmisWorkingCalendarSessionsModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.lmis.model.impl.LmisWorkingCalendarSessionsModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.lmis.service.persistence.LmisWorkingCalendarSessionsPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"containsLmisWorkingCalendarSessions",
			new String[] { Integer.class.getName(), Integer.class.getName() });

	public boolean containsLmisWorkingCalendarSessions(Integer pk,
		Integer lmisWorkingCalendarSessionsPK) throws SystemException {
		Object[] finderArgs = new Object[] { pk, lmisWorkingCalendarSessionsPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_LMISWORKINGCALENDARSESSIONS,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsLmisWorkingCalendarSessions.contains(
							pk, lmisWorkingCalendarSessionsPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_LMISWORKINGCALENDARSESSIONS,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	public boolean containsLmisWorkingCalendarSessionses(Integer pk)
		throws SystemException {
		if (getLmisWorkingCalendarSessionsesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.larion.progate.lmis.model.LmisWorkingCalendars")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LmisWorkingCalendars>> listenersList = new ArrayList<ModelListener<LmisWorkingCalendars>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LmisWorkingCalendars>)Class.forName(
							listenerClassName).newInstance());
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		containsLmisWorkingCalendarSessions = new ContainsLmisWorkingCalendarSessions(this);
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
	protected ContainsLmisWorkingCalendarSessions containsLmisWorkingCalendarSessions;

	protected class ContainsLmisWorkingCalendarSessions {
		protected ContainsLmisWorkingCalendarSessions(
			LmisWorkingCalendarsPersistenceImpl persistenceImpl) {
			super();

			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSLMISWORKINGCALENDARSESSIONS,
					new int[] { Types.INTEGER, Types.INTEGER }, RowMapper.COUNT);
		}

		protected boolean contains(Integer lmisWorkingCalendarId,
			Integer lmisWorkingCalendarSessionID) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						lmisWorkingCalendarId, lmisWorkingCalendarSessionID
					});

			if (results.size() > 0) {
				Integer count = results.get(0);

				if (count.intValue() > 0) {
					return true;
				}
			}

			return false;
		}

		private MappingSqlQuery _mappingSqlQuery;
	}

	private static final String _SQL_GETLMISWORKINGCALENDARSESSIONSES = "SELECT {lmis_working_calendar_sessions.*} FROM lmis_working_calendar_sessions INNER JOIN lmis_working_calendars ON (lmis_working_calendars.lmisWorkingCalendarId = lmis_working_calendar_sessions.lmisWorkingCalendarId) WHERE (lmis_working_calendars.lmisWorkingCalendarId = ?)";
	private static final String _SQL_GETLMISWORKINGCALENDARSESSIONSESSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM lmis_working_calendar_sessions WHERE lmisWorkingCalendarId = ?";
	private static final String _SQL_CONTAINSLMISWORKINGCALENDARSESSIONS = "SELECT COUNT(*) AS COUNT_VALUE FROM lmis_working_calendar_sessions WHERE lmisWorkingCalendarId = ? AND lmisWorkingCalendarSessionID = ?";
	private static Log _log = LogFactoryUtil.getLog(LmisWorkingCalendarsPersistenceImpl.class);
}