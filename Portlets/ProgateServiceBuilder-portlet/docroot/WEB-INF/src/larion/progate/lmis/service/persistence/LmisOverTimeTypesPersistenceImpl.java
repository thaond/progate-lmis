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

import larion.progate.lmis.NoSuchLmisOverTimeTypesException;
import larion.progate.lmis.model.LmisOverTimeTypes;
import larion.progate.lmis.model.impl.LmisOverTimeTypesImpl;
import larion.progate.lmis.model.impl.LmisOverTimeTypesModelImpl;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="LmisOverTimeTypesPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisOverTimeTypesPersistenceImpl extends BasePersistenceImpl
	implements LmisOverTimeTypesPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = LmisOverTimeTypesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_OVERTIMETYPESOF = new FinderPath(LmisOverTimeTypesModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeTypesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOverTimeTypesOf",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_OVERTIMETYPESOF = new FinderPath(LmisOverTimeTypesModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeTypesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOverTimeTypesOf",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_OVERTIMETYPESOF = new FinderPath(LmisOverTimeTypesModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeTypesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByOverTimeTypesOf",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(LmisOverTimeTypesModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeTypesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LmisOverTimeTypesModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeTypesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(LmisOverTimeTypes lmisOverTimeTypes) {
		EntityCacheUtil.putResult(LmisOverTimeTypesModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeTypesImpl.class, lmisOverTimeTypes.getPrimaryKey(),
			lmisOverTimeTypes);
	}

	public void cacheResult(List<LmisOverTimeTypes> lmisOverTimeTypeses) {
		for (LmisOverTimeTypes lmisOverTimeTypes : lmisOverTimeTypeses) {
			if (EntityCacheUtil.getResult(
						LmisOverTimeTypesModelImpl.ENTITY_CACHE_ENABLED,
						LmisOverTimeTypesImpl.class,
						lmisOverTimeTypes.getPrimaryKey(), this) == null) {
				cacheResult(lmisOverTimeTypes);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(LmisOverTimeTypesImpl.class.getName());
		EntityCacheUtil.clearCache(LmisOverTimeTypesImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public LmisOverTimeTypes create(Integer lmisOverTimeTypesId) {
		LmisOverTimeTypes lmisOverTimeTypes = new LmisOverTimeTypesImpl();

		lmisOverTimeTypes.setNew(true);
		lmisOverTimeTypes.setPrimaryKey(lmisOverTimeTypesId);

		return lmisOverTimeTypes;
	}

	public LmisOverTimeTypes remove(Integer lmisOverTimeTypesId)
		throws NoSuchLmisOverTimeTypesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LmisOverTimeTypes lmisOverTimeTypes = (LmisOverTimeTypes)session.get(LmisOverTimeTypesImpl.class,
					lmisOverTimeTypesId);

			if (lmisOverTimeTypes == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No LmisOverTimeTypes exists with the primary key " +
						lmisOverTimeTypesId);
				}

				throw new NoSuchLmisOverTimeTypesException(
					"No LmisOverTimeTypes exists with the primary key " +
					lmisOverTimeTypesId);
			}

			return remove(lmisOverTimeTypes);
		}
		catch (NoSuchLmisOverTimeTypesException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public LmisOverTimeTypes remove(LmisOverTimeTypes lmisOverTimeTypes)
		throws SystemException {
		for (ModelListener<LmisOverTimeTypes> listener : listeners) {
			listener.onBeforeRemove(lmisOverTimeTypes);
		}

		lmisOverTimeTypes = removeImpl(lmisOverTimeTypes);

		for (ModelListener<LmisOverTimeTypes> listener : listeners) {
			listener.onAfterRemove(lmisOverTimeTypes);
		}

		return lmisOverTimeTypes;
	}

	protected LmisOverTimeTypes removeImpl(LmisOverTimeTypes lmisOverTimeTypes)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (lmisOverTimeTypes.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(LmisOverTimeTypesImpl.class,
						lmisOverTimeTypes.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(lmisOverTimeTypes);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(LmisOverTimeTypesModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeTypesImpl.class, lmisOverTimeTypes.getPrimaryKey());

		return lmisOverTimeTypes;
	}

	public LmisOverTimeTypes update(LmisOverTimeTypes lmisOverTimeTypes)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(LmisOverTimeTypes lmisOverTimeTypes) method. Use update(LmisOverTimeTypes lmisOverTimeTypes, boolean merge) instead.");
		}

		return update(lmisOverTimeTypes, false);
	}

	public LmisOverTimeTypes update(LmisOverTimeTypes lmisOverTimeTypes,
		boolean merge) throws SystemException {
		boolean isNew = lmisOverTimeTypes.isNew();

		for (ModelListener<LmisOverTimeTypes> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(lmisOverTimeTypes);
			}
			else {
				listener.onBeforeUpdate(lmisOverTimeTypes);
			}
		}

		lmisOverTimeTypes = updateImpl(lmisOverTimeTypes, merge);

		for (ModelListener<LmisOverTimeTypes> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(lmisOverTimeTypes);
			}
			else {
				listener.onAfterUpdate(lmisOverTimeTypes);
			}
		}

		return lmisOverTimeTypes;
	}

	public LmisOverTimeTypes updateImpl(
		larion.progate.lmis.model.LmisOverTimeTypes lmisOverTimeTypes,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, lmisOverTimeTypes, merge);

			lmisOverTimeTypes.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(LmisOverTimeTypesModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeTypesImpl.class, lmisOverTimeTypes.getPrimaryKey(),
			lmisOverTimeTypes);

		return lmisOverTimeTypes;
	}

	public LmisOverTimeTypes findByPrimaryKey(Integer lmisOverTimeTypesId)
		throws NoSuchLmisOverTimeTypesException, SystemException {
		LmisOverTimeTypes lmisOverTimeTypes = fetchByPrimaryKey(lmisOverTimeTypesId);

		if (lmisOverTimeTypes == null) {
			if (_log.isWarnEnabled()) {
				_log.warn("No LmisOverTimeTypes exists with the primary key " +
					lmisOverTimeTypesId);
			}

			throw new NoSuchLmisOverTimeTypesException(
				"No LmisOverTimeTypes exists with the primary key " +
				lmisOverTimeTypesId);
		}

		return lmisOverTimeTypes;
	}

	public LmisOverTimeTypes fetchByPrimaryKey(Integer lmisOverTimeTypesId)
		throws SystemException {
		LmisOverTimeTypes lmisOverTimeTypes = (LmisOverTimeTypes)EntityCacheUtil.getResult(LmisOverTimeTypesModelImpl.ENTITY_CACHE_ENABLED,
				LmisOverTimeTypesImpl.class, lmisOverTimeTypesId, this);

		if (lmisOverTimeTypes == null) {
			Session session = null;

			try {
				session = openSession();

				lmisOverTimeTypes = (LmisOverTimeTypes)session.get(LmisOverTimeTypesImpl.class,
						lmisOverTimeTypesId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (lmisOverTimeTypes != null) {
					cacheResult(lmisOverTimeTypes);
				}

				closeSession(session);
			}
		}

		return lmisOverTimeTypes;
	}

	public List<LmisOverTimeTypes> findByOverTimeTypesOf(int rootId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		List<LmisOverTimeTypes> list = (List<LmisOverTimeTypes>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OVERTIMETYPESOF,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOverTimeTypes WHERE ");

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
					list = new ArrayList<LmisOverTimeTypes>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OVERTIMETYPESOF,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisOverTimeTypes> findByOverTimeTypesOf(int rootId, int start,
		int end) throws SystemException {
		return findByOverTimeTypesOf(rootId, start, end, null);
	}

	public List<LmisOverTimeTypes> findByOverTimeTypesOf(int rootId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(rootId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisOverTimeTypes> list = (List<LmisOverTimeTypes>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_OVERTIMETYPESOF,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOverTimeTypes WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rootId);

				list = (List<LmisOverTimeTypes>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisOverTimeTypes>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_OVERTIMETYPESOF,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisOverTimeTypes findByOverTimeTypesOf_First(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisOverTimeTypesException, SystemException {
		List<LmisOverTimeTypes> list = findByOverTimeTypesOf(rootId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOverTimeTypes exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOverTimeTypesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOverTimeTypes findByOverTimeTypesOf_Last(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisOverTimeTypesException, SystemException {
		int count = countByOverTimeTypesOf(rootId);

		List<LmisOverTimeTypes> list = findByOverTimeTypesOf(rootId, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOverTimeTypes exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOverTimeTypesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOverTimeTypes[] findByOverTimeTypesOf_PrevAndNext(
		Integer lmisOverTimeTypesId, int rootId, OrderByComparator obc)
		throws NoSuchLmisOverTimeTypesException, SystemException {
		LmisOverTimeTypes lmisOverTimeTypes = findByPrimaryKey(lmisOverTimeTypesId);

		int count = countByOverTimeTypesOf(rootId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisOverTimeTypes WHERE ");

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
					lmisOverTimeTypes);

			LmisOverTimeTypes[] array = new LmisOverTimeTypesImpl[3];

			array[0] = (LmisOverTimeTypes)objArray[0];
			array[1] = (LmisOverTimeTypes)objArray[1];
			array[2] = (LmisOverTimeTypes)objArray[2];

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

	public List<LmisOverTimeTypes> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<LmisOverTimeTypes> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<LmisOverTimeTypes> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisOverTimeTypes> list = (List<LmisOverTimeTypes>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOverTimeTypes ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<LmisOverTimeTypes>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LmisOverTimeTypes>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisOverTimeTypes>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByOverTimeTypesOf(int rootId) throws SystemException {
		for (LmisOverTimeTypes lmisOverTimeTypes : findByOverTimeTypesOf(rootId)) {
			remove(lmisOverTimeTypes);
		}
	}

	public void removeAll() throws SystemException {
		for (LmisOverTimeTypes lmisOverTimeTypes : findAll()) {
			remove(lmisOverTimeTypes);
		}
	}

	public int countByOverTimeTypesOf(int rootId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_OVERTIMETYPESOF,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisOverTimeTypes WHERE ");

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_OVERTIMETYPESOF,
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
						"SELECT COUNT(*) FROM larion.progate.lmis.model.LmisOverTimeTypes");

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

	public List<larion.progate.lmis.model.LmisOverTimeSettings> getLmisOverTimeSettingses(
		Integer pk) throws SystemException {
		return getLmisOverTimeSettingses(pk, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS);
	}

	public List<larion.progate.lmis.model.LmisOverTimeSettings> getLmisOverTimeSettingses(
		Integer pk, int start, int end) throws SystemException {
		return getLmisOverTimeSettingses(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_LMISOVERTIMESETTINGSES = new FinderPath(larion.progate.lmis.model.impl.LmisOverTimeSettingsModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.lmis.model.impl.LmisOverTimeSettingsModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.lmis.service.persistence.LmisOverTimeSettingsPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getLmisOverTimeSettingses",
			new String[] {
				Integer.class.getName(), "java.lang.Integer",
				"java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	public List<larion.progate.lmis.model.LmisOverTimeSettings> getLmisOverTimeSettingses(
		Integer pk, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				pk, String.valueOf(start), String.valueOf(end),
				String.valueOf(obc)
			};

		List<larion.progate.lmis.model.LmisOverTimeSettings> list = (List<larion.progate.lmis.model.LmisOverTimeSettings>)FinderCacheUtil.getResult(FINDER_PATH_GET_LMISOVERTIMESETTINGSES,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder sb = new StringBuilder();

				sb.append(_SQL_GETLMISOVERTIMESETTINGSES);

				if (obc != null) {
					sb.append("ORDER BY ");
					sb.append(obc.getOrderBy());
				}

				String sql = sb.toString();

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("lmis_overtime_settings",
					larion.progate.lmis.model.impl.LmisOverTimeSettingsImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<larion.progate.lmis.model.LmisOverTimeSettings>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<larion.progate.lmis.model.LmisOverTimeSettings>();
				}

				lmisOverTimeSettingsPersistence.cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_GET_LMISOVERTIMESETTINGSES,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_LMISOVERTIMESETTINGSES_SIZE = new FinderPath(larion.progate.lmis.model.impl.LmisOverTimeSettingsModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.lmis.model.impl.LmisOverTimeSettingsModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.lmis.service.persistence.LmisOverTimeSettingsPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getLmisOverTimeSettingsesSize",
			new String[] { Integer.class.getName() });

	public int getLmisOverTimeSettingsesSize(Integer pk)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_LMISOVERTIMESETTINGSES_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETLMISOVERTIMESETTINGSESSIZE);

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

				FinderCacheUtil.putResult(FINDER_PATH_GET_LMISOVERTIMESETTINGSES_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_LMISOVERTIMESETTINGS = new FinderPath(larion.progate.lmis.model.impl.LmisOverTimeSettingsModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.lmis.model.impl.LmisOverTimeSettingsModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.lmis.service.persistence.LmisOverTimeSettingsPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"containsLmisOverTimeSettings",
			new String[] { Integer.class.getName(), Integer.class.getName() });

	public boolean containsLmisOverTimeSettings(Integer pk,
		Integer lmisOverTimeSettingsPK) throws SystemException {
		Object[] finderArgs = new Object[] { pk, lmisOverTimeSettingsPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_LMISOVERTIMESETTINGS,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsLmisOverTimeSettings.contains(
							pk, lmisOverTimeSettingsPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_LMISOVERTIMESETTINGS,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	public boolean containsLmisOverTimeSettingses(Integer pk)
		throws SystemException {
		if (getLmisOverTimeSettingsesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public List<larion.progate.lmis.model.LmisOverTimeReportHours> getLmisOverTimeReportHourses(
		Integer pk) throws SystemException {
		return getLmisOverTimeReportHourses(pk, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS);
	}

	public List<larion.progate.lmis.model.LmisOverTimeReportHours> getLmisOverTimeReportHourses(
		Integer pk, int start, int end) throws SystemException {
		return getLmisOverTimeReportHourses(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_LMISOVERTIMEREPORTHOURSES = new FinderPath(larion.progate.lmis.model.impl.LmisOverTimeReportHoursModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.lmis.model.impl.LmisOverTimeReportHoursModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.lmis.service.persistence.LmisOverTimeReportHoursPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getLmisOverTimeReportHourses",
			new String[] {
				Integer.class.getName(), "java.lang.Integer",
				"java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	public List<larion.progate.lmis.model.LmisOverTimeReportHours> getLmisOverTimeReportHourses(
		Integer pk, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				pk, String.valueOf(start), String.valueOf(end),
				String.valueOf(obc)
			};

		List<larion.progate.lmis.model.LmisOverTimeReportHours> list = (List<larion.progate.lmis.model.LmisOverTimeReportHours>)FinderCacheUtil.getResult(FINDER_PATH_GET_LMISOVERTIMEREPORTHOURSES,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder sb = new StringBuilder();

				sb.append(_SQL_GETLMISOVERTIMEREPORTHOURSES);

				if (obc != null) {
					sb.append("ORDER BY ");
					sb.append(obc.getOrderBy());
				}

				String sql = sb.toString();

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("lmis_overtime_report_hours",
					larion.progate.lmis.model.impl.LmisOverTimeReportHoursImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<larion.progate.lmis.model.LmisOverTimeReportHours>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<larion.progate.lmis.model.LmisOverTimeReportHours>();
				}

				lmisOverTimeReportHoursPersistence.cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_GET_LMISOVERTIMEREPORTHOURSES,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_LMISOVERTIMEREPORTHOURSES_SIZE =
		new FinderPath(larion.progate.lmis.model.impl.LmisOverTimeReportHoursModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.lmis.model.impl.LmisOverTimeReportHoursModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.lmis.service.persistence.LmisOverTimeReportHoursPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getLmisOverTimeReportHoursesSize",
			new String[] { Integer.class.getName() });

	public int getLmisOverTimeReportHoursesSize(Integer pk)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_LMISOVERTIMEREPORTHOURSES_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETLMISOVERTIMEREPORTHOURSESSIZE);

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

				FinderCacheUtil.putResult(FINDER_PATH_GET_LMISOVERTIMEREPORTHOURSES_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_LMISOVERTIMEREPORTHOURS = new FinderPath(larion.progate.lmis.model.impl.LmisOverTimeReportHoursModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.lmis.model.impl.LmisOverTimeReportHoursModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.lmis.service.persistence.LmisOverTimeReportHoursPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"containsLmisOverTimeReportHours",
			new String[] { Integer.class.getName(), Integer.class.getName() });

	public boolean containsLmisOverTimeReportHours(Integer pk,
		Integer lmisOverTimeReportHoursPK) throws SystemException {
		Object[] finderArgs = new Object[] { pk, lmisOverTimeReportHoursPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_LMISOVERTIMEREPORTHOURS,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsLmisOverTimeReportHours.contains(
							pk, lmisOverTimeReportHoursPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_LMISOVERTIMEREPORTHOURS,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	public boolean containsLmisOverTimeReportHourses(Integer pk)
		throws SystemException {
		if (getLmisOverTimeReportHoursesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.larion.progate.lmis.model.LmisOverTimeTypes")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LmisOverTimeTypes>> listenersList = new ArrayList<ModelListener<LmisOverTimeTypes>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LmisOverTimeTypes>)Class.forName(
							listenerClassName).newInstance());
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		containsLmisOverTimeSettings = new ContainsLmisOverTimeSettings(this);

		containsLmisOverTimeReportHours = new ContainsLmisOverTimeReportHours(this);
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
	protected ContainsLmisOverTimeSettings containsLmisOverTimeSettings;
	protected ContainsLmisOverTimeReportHours containsLmisOverTimeReportHours;

	protected class ContainsLmisOverTimeSettings {
		protected ContainsLmisOverTimeSettings(
			LmisOverTimeTypesPersistenceImpl persistenceImpl) {
			super();

			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSLMISOVERTIMESETTINGS,
					new int[] { Types.INTEGER, Types.INTEGER }, RowMapper.COUNT);
		}

		protected boolean contains(Integer lmisOverTimeTypesId,
			Integer lmisOverTimeSettingsId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						lmisOverTimeTypesId, lmisOverTimeSettingsId
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

	protected class ContainsLmisOverTimeReportHours {
		protected ContainsLmisOverTimeReportHours(
			LmisOverTimeTypesPersistenceImpl persistenceImpl) {
			super();

			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSLMISOVERTIMEREPORTHOURS,
					new int[] { Types.INTEGER, Types.INTEGER }, RowMapper.COUNT);
		}

		protected boolean contains(Integer lmisOverTimeTypesId,
			Integer lmisOverTimeReportHoursId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						lmisOverTimeTypesId, lmisOverTimeReportHoursId
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

	private static final String _SQL_GETLMISOVERTIMESETTINGSES = "SELECT {lmis_overtime_settings.*} FROM lmis_overtime_settings INNER JOIN lmis_overtime_types ON (lmis_overtime_types.lmisOverTimeTypesId = lmis_overtime_settings.lmisOverTimeTypesId) WHERE (lmis_overtime_types.lmisOverTimeTypesId = ?)";
	private static final String _SQL_GETLMISOVERTIMESETTINGSESSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM lmis_overtime_settings WHERE lmisOverTimeTypesId = ?";
	private static final String _SQL_CONTAINSLMISOVERTIMESETTINGS = "SELECT COUNT(*) AS COUNT_VALUE FROM lmis_overtime_settings WHERE lmisOverTimeTypesId = ? AND lmisOverTimeSettingsId = ?";
	private static final String _SQL_GETLMISOVERTIMEREPORTHOURSES = "SELECT {lmis_overtime_report_hours.*} FROM lmis_overtime_report_hours INNER JOIN lmis_overtime_types ON (lmis_overtime_types.lmisOverTimeTypesId = lmis_overtime_report_hours.lmisOverTimeTypesId) WHERE (lmis_overtime_types.lmisOverTimeTypesId = ?)";
	private static final String _SQL_GETLMISOVERTIMEREPORTHOURSESSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM lmis_overtime_report_hours WHERE lmisOverTimeTypesId = ?";
	private static final String _SQL_CONTAINSLMISOVERTIMEREPORTHOURS = "SELECT COUNT(*) AS COUNT_VALUE FROM lmis_overtime_report_hours WHERE lmisOverTimeTypesId = ? AND lmisOverTimeReportHoursId = ?";
	private static Log _log = LogFactoryUtil.getLog(LmisOverTimeTypesPersistenceImpl.class);
}