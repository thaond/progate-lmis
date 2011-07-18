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
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import larion.progate.lmis.NoSuchLmisDayTypesException;
import larion.progate.lmis.model.LmisDayTypes;
import larion.progate.lmis.model.impl.LmisDayTypesImpl;
import larion.progate.lmis.model.impl.LmisDayTypesModelImpl;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="LmisDayTypesPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisDayTypesPersistenceImpl extends BasePersistenceImpl
	implements LmisDayTypesPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = LmisDayTypesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_DAYTYPEOF = new FinderPath(LmisDayTypesModelImpl.ENTITY_CACHE_ENABLED,
			LmisDayTypesModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByDayTypeOf", new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_DAYTYPEOF = new FinderPath(LmisDayTypesModelImpl.ENTITY_CACHE_ENABLED,
			LmisDayTypesModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByDayTypeOf",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_DAYTYPEOF = new FinderPath(LmisDayTypesModelImpl.ENTITY_CACHE_ENABLED,
			LmisDayTypesModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByDayTypeOf", new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(LmisDayTypesModelImpl.ENTITY_CACHE_ENABLED,
			LmisDayTypesModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LmisDayTypesModelImpl.ENTITY_CACHE_ENABLED,
			LmisDayTypesModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	public void cacheResult(LmisDayTypes lmisDayTypes) {
		EntityCacheUtil.putResult(LmisDayTypesModelImpl.ENTITY_CACHE_ENABLED,
			LmisDayTypesImpl.class, lmisDayTypes.getPrimaryKey(), lmisDayTypes);
	}

	public void cacheResult(List<LmisDayTypes> lmisDayTypeses) {
		for (LmisDayTypes lmisDayTypes : lmisDayTypeses) {
			if (EntityCacheUtil.getResult(
						LmisDayTypesModelImpl.ENTITY_CACHE_ENABLED,
						LmisDayTypesImpl.class, lmisDayTypes.getPrimaryKey(),
						this) == null) {
				cacheResult(lmisDayTypes);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(LmisDayTypesImpl.class.getName());
		EntityCacheUtil.clearCache(LmisDayTypesImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public LmisDayTypes create(Integer LmisDayTypeId) {
		LmisDayTypes lmisDayTypes = new LmisDayTypesImpl();

		lmisDayTypes.setNew(true);
		lmisDayTypes.setPrimaryKey(LmisDayTypeId);

		return lmisDayTypes;
	}

	public LmisDayTypes remove(Integer LmisDayTypeId)
		throws NoSuchLmisDayTypesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LmisDayTypes lmisDayTypes = (LmisDayTypes)session.get(LmisDayTypesImpl.class,
					LmisDayTypeId);

			if (lmisDayTypes == null) {
				if (_log.isWarnEnabled()) {
					_log.warn("No LmisDayTypes exists with the primary key " +
						LmisDayTypeId);
				}

				throw new NoSuchLmisDayTypesException(
					"No LmisDayTypes exists with the primary key " +
					LmisDayTypeId);
			}

			return remove(lmisDayTypes);
		}
		catch (NoSuchLmisDayTypesException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public LmisDayTypes remove(LmisDayTypes lmisDayTypes)
		throws SystemException {
		for (ModelListener<LmisDayTypes> listener : listeners) {
			listener.onBeforeRemove(lmisDayTypes);
		}

		lmisDayTypes = removeImpl(lmisDayTypes);

		for (ModelListener<LmisDayTypes> listener : listeners) {
			listener.onAfterRemove(lmisDayTypes);
		}

		return lmisDayTypes;
	}

	protected LmisDayTypes removeImpl(LmisDayTypes lmisDayTypes)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (lmisDayTypes.isCachedModel() || BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(LmisDayTypesImpl.class,
						lmisDayTypes.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(lmisDayTypes);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(LmisDayTypesModelImpl.ENTITY_CACHE_ENABLED,
			LmisDayTypesImpl.class, lmisDayTypes.getPrimaryKey());

		return lmisDayTypes;
	}

	public LmisDayTypes update(LmisDayTypes lmisDayTypes)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(LmisDayTypes lmisDayTypes) method. Use update(LmisDayTypes lmisDayTypes, boolean merge) instead.");
		}

		return update(lmisDayTypes, false);
	}

	public LmisDayTypes update(LmisDayTypes lmisDayTypes, boolean merge)
		throws SystemException {
		boolean isNew = lmisDayTypes.isNew();

		for (ModelListener<LmisDayTypes> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(lmisDayTypes);
			}
			else {
				listener.onBeforeUpdate(lmisDayTypes);
			}
		}

		lmisDayTypes = updateImpl(lmisDayTypes, merge);

		for (ModelListener<LmisDayTypes> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(lmisDayTypes);
			}
			else {
				listener.onAfterUpdate(lmisDayTypes);
			}
		}

		return lmisDayTypes;
	}

	public LmisDayTypes updateImpl(
		larion.progate.lmis.model.LmisDayTypes lmisDayTypes, boolean merge)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, lmisDayTypes, merge);

			lmisDayTypes.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(LmisDayTypesModelImpl.ENTITY_CACHE_ENABLED,
			LmisDayTypesImpl.class, lmisDayTypes.getPrimaryKey(), lmisDayTypes);

		return lmisDayTypes;
	}

	public LmisDayTypes findByPrimaryKey(Integer LmisDayTypeId)
		throws NoSuchLmisDayTypesException, SystemException {
		LmisDayTypes lmisDayTypes = fetchByPrimaryKey(LmisDayTypeId);

		if (lmisDayTypes == null) {
			if (_log.isWarnEnabled()) {
				_log.warn("No LmisDayTypes exists with the primary key " +
					LmisDayTypeId);
			}

			throw new NoSuchLmisDayTypesException(
				"No LmisDayTypes exists with the primary key " + LmisDayTypeId);
		}

		return lmisDayTypes;
	}

	public LmisDayTypes fetchByPrimaryKey(Integer LmisDayTypeId)
		throws SystemException {
		LmisDayTypes lmisDayTypes = (LmisDayTypes)EntityCacheUtil.getResult(LmisDayTypesModelImpl.ENTITY_CACHE_ENABLED,
				LmisDayTypesImpl.class, LmisDayTypeId, this);

		if (lmisDayTypes == null) {
			Session session = null;

			try {
				session = openSession();

				lmisDayTypes = (LmisDayTypes)session.get(LmisDayTypesImpl.class,
						LmisDayTypeId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (lmisDayTypes != null) {
					cacheResult(lmisDayTypes);
				}

				closeSession(session);
			}
		}

		return lmisDayTypes;
	}

	public List<LmisDayTypes> findByDayTypeOf(int rootId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		List<LmisDayTypes> list = (List<LmisDayTypes>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DAYTYPEOF,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisDayTypes WHERE ");

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
					list = new ArrayList<LmisDayTypes>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DAYTYPEOF,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisDayTypes> findByDayTypeOf(int rootId, int start, int end)
		throws SystemException {
		return findByDayTypeOf(rootId, start, end, null);
	}

	public List<LmisDayTypes> findByDayTypeOf(int rootId, int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(rootId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisDayTypes> list = (List<LmisDayTypes>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_DAYTYPEOF,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisDayTypes WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rootId);

				list = (List<LmisDayTypes>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisDayTypes>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_DAYTYPEOF,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisDayTypes findByDayTypeOf_First(int rootId, OrderByComparator obc)
		throws NoSuchLmisDayTypesException, SystemException {
		List<LmisDayTypes> list = findByDayTypeOf(rootId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisDayTypes exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisDayTypesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisDayTypes findByDayTypeOf_Last(int rootId, OrderByComparator obc)
		throws NoSuchLmisDayTypesException, SystemException {
		int count = countByDayTypeOf(rootId);

		List<LmisDayTypes> list = findByDayTypeOf(rootId, count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisDayTypes exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisDayTypesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisDayTypes[] findByDayTypeOf_PrevAndNext(Integer LmisDayTypeId,
		int rootId, OrderByComparator obc)
		throws NoSuchLmisDayTypesException, SystemException {
		LmisDayTypes lmisDayTypes = findByPrimaryKey(LmisDayTypeId);

		int count = countByDayTypeOf(rootId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.lmis.model.LmisDayTypes WHERE ");

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
					lmisDayTypes);

			LmisDayTypes[] array = new LmisDayTypesImpl[3];

			array[0] = (LmisDayTypes)objArray[0];
			array[1] = (LmisDayTypes)objArray[1];
			array[2] = (LmisDayTypes)objArray[2];

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

	public List<LmisDayTypes> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<LmisDayTypes> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<LmisDayTypes> findAll(int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisDayTypes> list = (List<LmisDayTypes>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.lmis.model.LmisDayTypes ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<LmisDayTypes>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LmisDayTypes>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisDayTypes>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByDayTypeOf(int rootId) throws SystemException {
		for (LmisDayTypes lmisDayTypes : findByDayTypeOf(rootId)) {
			remove(lmisDayTypes);
		}
	}

	public void removeAll() throws SystemException {
		for (LmisDayTypes lmisDayTypes : findAll()) {
			remove(lmisDayTypes);
		}
	}

	public int countByDayTypeOf(int rootId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DAYTYPEOF,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisDayTypes WHERE ");

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DAYTYPEOF,
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
						"SELECT COUNT(*) FROM larion.progate.lmis.model.LmisDayTypes");

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

	public List<larion.progate.lmis.model.LmisWorkingCalendars> getLmisWorkingCalendarses(
		Integer pk) throws SystemException {
		return getLmisWorkingCalendarses(pk, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS);
	}

	public List<larion.progate.lmis.model.LmisWorkingCalendars> getLmisWorkingCalendarses(
		Integer pk, int start, int end) throws SystemException {
		return getLmisWorkingCalendarses(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_LMISWORKINGCALENDARSES = new FinderPath(larion.progate.lmis.model.impl.LmisWorkingCalendarsModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.lmis.model.impl.LmisWorkingCalendarsModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.lmis.service.persistence.LmisWorkingCalendarsPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getLmisWorkingCalendarses",
			new String[] {
				Integer.class.getName(), "java.lang.Integer",
				"java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	public List<larion.progate.lmis.model.LmisWorkingCalendars> getLmisWorkingCalendarses(
		Integer pk, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				pk, String.valueOf(start), String.valueOf(end),
				String.valueOf(obc)
			};

		List<larion.progate.lmis.model.LmisWorkingCalendars> list = (List<larion.progate.lmis.model.LmisWorkingCalendars>)FinderCacheUtil.getResult(FINDER_PATH_GET_LMISWORKINGCALENDARSES,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder sb = new StringBuilder();

				sb.append(_SQL_GETLMISWORKINGCALENDARSES);

				if (obc != null) {
					sb.append("ORDER BY ");
					sb.append(obc.getOrderBy());
				}

				else {
					sb.append("ORDER BY ");

					sb.append("lmis_working_calendars.day_value ASC");
				}

				String sql = sb.toString();

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("lmis_working_calendars",
					larion.progate.lmis.model.impl.LmisWorkingCalendarsImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<larion.progate.lmis.model.LmisWorkingCalendars>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<larion.progate.lmis.model.LmisWorkingCalendars>();
				}

				lmisWorkingCalendarsPersistence.cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_GET_LMISWORKINGCALENDARSES,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_LMISWORKINGCALENDARSES_SIZE = new FinderPath(larion.progate.lmis.model.impl.LmisWorkingCalendarsModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.lmis.model.impl.LmisWorkingCalendarsModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.lmis.service.persistence.LmisWorkingCalendarsPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getLmisWorkingCalendarsesSize",
			new String[] { Integer.class.getName() });

	public int getLmisWorkingCalendarsesSize(Integer pk)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_LMISWORKINGCALENDARSES_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETLMISWORKINGCALENDARSESSIZE);

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

				FinderCacheUtil.putResult(FINDER_PATH_GET_LMISWORKINGCALENDARSES_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_LMISWORKINGCALENDARS = new FinderPath(larion.progate.lmis.model.impl.LmisWorkingCalendarsModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.lmis.model.impl.LmisWorkingCalendarsModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.lmis.service.persistence.LmisWorkingCalendarsPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"containsLmisWorkingCalendars",
			new String[] { Integer.class.getName(), Integer.class.getName() });

	public boolean containsLmisWorkingCalendars(Integer pk,
		Integer lmisWorkingCalendarsPK) throws SystemException {
		Object[] finderArgs = new Object[] { pk, lmisWorkingCalendarsPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_LMISWORKINGCALENDARS,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsLmisWorkingCalendars.contains(
							pk, lmisWorkingCalendarsPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_LMISWORKINGCALENDARS,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	public boolean containsLmisWorkingCalendarses(Integer pk)
		throws SystemException {
		if (getLmisWorkingCalendarsesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.larion.progate.lmis.model.LmisDayTypes")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LmisDayTypes>> listenersList = new ArrayList<ModelListener<LmisDayTypes>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LmisDayTypes>)Class.forName(
							listenerClassName).newInstance());
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		containsLmisWorkingCalendars = new ContainsLmisWorkingCalendars(this);
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
	protected ContainsLmisWorkingCalendars containsLmisWorkingCalendars;

	protected class ContainsLmisWorkingCalendars {
		protected ContainsLmisWorkingCalendars(
			LmisDayTypesPersistenceImpl persistenceImpl) {
			super();

			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSLMISWORKINGCALENDARS,
					new int[] { Types.INTEGER, Types.INTEGER }, RowMapper.COUNT);
		}

		protected boolean contains(Integer LmisDayTypeId,
			Integer lmisWorkingCalendarId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						LmisDayTypeId, lmisWorkingCalendarId
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

	private static final String _SQL_GETLMISWORKINGCALENDARSES = "SELECT {lmis_working_calendars.*} FROM lmis_working_calendars INNER JOIN lmis_day_types ON (lmis_day_types.LmisDayTypeId = lmis_working_calendars.LmisDayTypeId) WHERE (lmis_day_types.LmisDayTypeId = ?)";
	private static final String _SQL_GETLMISWORKINGCALENDARSESSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM lmis_working_calendars WHERE LmisDayTypeId = ?";
	private static final String _SQL_CONTAINSLMISWORKINGCALENDARS = "SELECT COUNT(*) AS COUNT_VALUE FROM lmis_working_calendars WHERE LmisDayTypeId = ? AND lmisWorkingCalendarId = ?";
	private static Log _log = LogFactoryUtil.getLog(LmisDayTypesPersistenceImpl.class);
}