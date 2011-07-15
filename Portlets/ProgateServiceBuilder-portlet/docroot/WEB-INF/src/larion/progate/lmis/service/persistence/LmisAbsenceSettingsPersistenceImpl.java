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

import larion.progate.lmis.NoSuchLmisAbsenceSettingsException;
import larion.progate.lmis.model.LmisAbsenceSettings;
import larion.progate.lmis.model.impl.LmisAbsenceSettingsImpl;
import larion.progate.lmis.model.impl.LmisAbsenceSettingsModelImpl;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="LmisAbsenceSettingsPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisAbsenceSettingsPersistenceImpl extends BasePersistenceImpl
	implements LmisAbsenceSettingsPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = LmisAbsenceSettingsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_ROOTID = new FinderPath(LmisAbsenceSettingsModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceSettingsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ROOTID = new FinderPath(LmisAbsenceSettingsModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceSettingsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ROOTID = new FinderPath(LmisAbsenceSettingsModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceSettingsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByRootID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ABSENCEPERMISSIVE = new FinderPath(LmisAbsenceSettingsModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceSettingsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByAbsencePermissive",
			new String[] { Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ABSENCEPERMISSIVE = new FinderPath(LmisAbsenceSettingsModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceSettingsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByAbsencePermissive",
			new String[] {
				Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ABSENCEPERMISSIVE = new FinderPath(LmisAbsenceSettingsModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceSettingsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByAbsencePermissive",
			new String[] { Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(LmisAbsenceSettingsModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceSettingsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LmisAbsenceSettingsModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceSettingsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(LmisAbsenceSettings lmisAbsenceSettings) {
		EntityCacheUtil.putResult(LmisAbsenceSettingsModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceSettingsImpl.class, lmisAbsenceSettings.getPrimaryKey(),
			lmisAbsenceSettings);
	}

	public void cacheResult(List<LmisAbsenceSettings> lmisAbsenceSettingses) {
		for (LmisAbsenceSettings lmisAbsenceSettings : lmisAbsenceSettingses) {
			if (EntityCacheUtil.getResult(
						LmisAbsenceSettingsModelImpl.ENTITY_CACHE_ENABLED,
						LmisAbsenceSettingsImpl.class,
						lmisAbsenceSettings.getPrimaryKey(), this) == null) {
				cacheResult(lmisAbsenceSettings);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(LmisAbsenceSettingsImpl.class.getName());
		EntityCacheUtil.clearCache(LmisAbsenceSettingsImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public LmisAbsenceSettings create(Integer lmisAbsenceSettingsId) {
		LmisAbsenceSettings lmisAbsenceSettings = new LmisAbsenceSettingsImpl();

		lmisAbsenceSettings.setNew(true);
		lmisAbsenceSettings.setPrimaryKey(lmisAbsenceSettingsId);

		return lmisAbsenceSettings;
	}

	public LmisAbsenceSettings remove(Integer lmisAbsenceSettingsId)
		throws NoSuchLmisAbsenceSettingsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LmisAbsenceSettings lmisAbsenceSettings = (LmisAbsenceSettings)session.get(LmisAbsenceSettingsImpl.class,
					lmisAbsenceSettingsId);

			if (lmisAbsenceSettings == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No LmisAbsenceSettings exists with the primary key " +
						lmisAbsenceSettingsId);
				}

				throw new NoSuchLmisAbsenceSettingsException(
					"No LmisAbsenceSettings exists with the primary key " +
					lmisAbsenceSettingsId);
			}

			return remove(lmisAbsenceSettings);
		}
		catch (NoSuchLmisAbsenceSettingsException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public LmisAbsenceSettings remove(LmisAbsenceSettings lmisAbsenceSettings)
		throws SystemException {
		for (ModelListener<LmisAbsenceSettings> listener : listeners) {
			listener.onBeforeRemove(lmisAbsenceSettings);
		}

		lmisAbsenceSettings = removeImpl(lmisAbsenceSettings);

		for (ModelListener<LmisAbsenceSettings> listener : listeners) {
			listener.onAfterRemove(lmisAbsenceSettings);
		}

		return lmisAbsenceSettings;
	}

	protected LmisAbsenceSettings removeImpl(
		LmisAbsenceSettings lmisAbsenceSettings) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (lmisAbsenceSettings.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(LmisAbsenceSettingsImpl.class,
						lmisAbsenceSettings.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(lmisAbsenceSettings);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(LmisAbsenceSettingsModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceSettingsImpl.class, lmisAbsenceSettings.getPrimaryKey());

		return lmisAbsenceSettings;
	}

	public LmisAbsenceSettings update(LmisAbsenceSettings lmisAbsenceSettings)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(LmisAbsenceSettings lmisAbsenceSettings) method. Use update(LmisAbsenceSettings lmisAbsenceSettings, boolean merge) instead.");
		}

		return update(lmisAbsenceSettings, false);
	}

	public LmisAbsenceSettings update(LmisAbsenceSettings lmisAbsenceSettings,
		boolean merge) throws SystemException {
		boolean isNew = lmisAbsenceSettings.isNew();

		for (ModelListener<LmisAbsenceSettings> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(lmisAbsenceSettings);
			}
			else {
				listener.onBeforeUpdate(lmisAbsenceSettings);
			}
		}

		lmisAbsenceSettings = updateImpl(lmisAbsenceSettings, merge);

		for (ModelListener<LmisAbsenceSettings> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(lmisAbsenceSettings);
			}
			else {
				listener.onAfterUpdate(lmisAbsenceSettings);
			}
		}

		return lmisAbsenceSettings;
	}

	public LmisAbsenceSettings updateImpl(
		larion.progate.lmis.model.LmisAbsenceSettings lmisAbsenceSettings,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, lmisAbsenceSettings, merge);

			lmisAbsenceSettings.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(LmisAbsenceSettingsModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceSettingsImpl.class, lmisAbsenceSettings.getPrimaryKey(),
			lmisAbsenceSettings);

		return lmisAbsenceSettings;
	}

	public LmisAbsenceSettings findByPrimaryKey(Integer lmisAbsenceSettingsId)
		throws NoSuchLmisAbsenceSettingsException, SystemException {
		LmisAbsenceSettings lmisAbsenceSettings = fetchByPrimaryKey(lmisAbsenceSettingsId);

		if (lmisAbsenceSettings == null) {
			if (_log.isWarnEnabled()) {
				_log.warn("No LmisAbsenceSettings exists with the primary key " +
					lmisAbsenceSettingsId);
			}

			throw new NoSuchLmisAbsenceSettingsException(
				"No LmisAbsenceSettings exists with the primary key " +
				lmisAbsenceSettingsId);
		}

		return lmisAbsenceSettings;
	}

	public LmisAbsenceSettings fetchByPrimaryKey(Integer lmisAbsenceSettingsId)
		throws SystemException {
		LmisAbsenceSettings lmisAbsenceSettings = (LmisAbsenceSettings)EntityCacheUtil.getResult(LmisAbsenceSettingsModelImpl.ENTITY_CACHE_ENABLED,
				LmisAbsenceSettingsImpl.class, lmisAbsenceSettingsId, this);

		if (lmisAbsenceSettings == null) {
			Session session = null;

			try {
				session = openSession();

				lmisAbsenceSettings = (LmisAbsenceSettings)session.get(LmisAbsenceSettingsImpl.class,
						lmisAbsenceSettingsId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (lmisAbsenceSettings != null) {
					cacheResult(lmisAbsenceSettings);
				}

				closeSession(session);
			}
		}

		return lmisAbsenceSettings;
	}

	public List<LmisAbsenceSettings> findByRootID(int rootId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		List<LmisAbsenceSettings> list = (List<LmisAbsenceSettings>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceSettings WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("name ASC");

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
					list = new ArrayList<LmisAbsenceSettings>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisAbsenceSettings> findByRootID(int rootId, int start, int end)
		throws SystemException {
		return findByRootID(rootId, start, end, null);
	}

	public List<LmisAbsenceSettings> findByRootID(int rootId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(rootId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisAbsenceSettings> list = (List<LmisAbsenceSettings>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceSettings WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("name ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rootId);

				list = (List<LmisAbsenceSettings>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisAbsenceSettings>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisAbsenceSettings findByRootID_First(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisAbsenceSettingsException, SystemException {
		List<LmisAbsenceSettings> list = findByRootID(rootId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAbsenceSettings exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAbsenceSettingsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAbsenceSettings findByRootID_Last(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisAbsenceSettingsException, SystemException {
		int count = countByRootID(rootId);

		List<LmisAbsenceSettings> list = findByRootID(rootId, count - 1, count,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAbsenceSettings exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAbsenceSettingsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAbsenceSettings[] findByRootID_PrevAndNext(
		Integer lmisAbsenceSettingsId, int rootId, OrderByComparator obc)
		throws NoSuchLmisAbsenceSettingsException, SystemException {
		LmisAbsenceSettings lmisAbsenceSettings = findByPrimaryKey(lmisAbsenceSettingsId);

		int count = countByRootID(rootId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisAbsenceSettings WHERE ");

			query.append("root_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("name ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(rootId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisAbsenceSettings);

			LmisAbsenceSettings[] array = new LmisAbsenceSettingsImpl[3];

			array[0] = (LmisAbsenceSettings)objArray[0];
			array[1] = (LmisAbsenceSettings)objArray[1];
			array[2] = (LmisAbsenceSettings)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisAbsenceSettings> findByAbsencePermissive(
		boolean absencePermissive) throws SystemException {
		Object[] finderArgs = new Object[] { Boolean.valueOf(absencePermissive) };

		List<LmisAbsenceSettings> list = (List<LmisAbsenceSettings>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ABSENCEPERMISSIVE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceSettings WHERE ");

				query.append("absence_permissive = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("name ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(absencePermissive);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisAbsenceSettings>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ABSENCEPERMISSIVE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisAbsenceSettings> findByAbsencePermissive(
		boolean absencePermissive, int start, int end)
		throws SystemException {
		return findByAbsencePermissive(absencePermissive, start, end, null);
	}

	public List<LmisAbsenceSettings> findByAbsencePermissive(
		boolean absencePermissive, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				Boolean.valueOf(absencePermissive),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisAbsenceSettings> list = (List<LmisAbsenceSettings>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ABSENCEPERMISSIVE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceSettings WHERE ");

				query.append("absence_permissive = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("name ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(absencePermissive);

				list = (List<LmisAbsenceSettings>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisAbsenceSettings>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ABSENCEPERMISSIVE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisAbsenceSettings findByAbsencePermissive_First(
		boolean absencePermissive, OrderByComparator obc)
		throws NoSuchLmisAbsenceSettingsException, SystemException {
		List<LmisAbsenceSettings> list = findByAbsencePermissive(absencePermissive,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAbsenceSettings exists with the key {");

			msg.append("absencePermissive=" + absencePermissive);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAbsenceSettingsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAbsenceSettings findByAbsencePermissive_Last(
		boolean absencePermissive, OrderByComparator obc)
		throws NoSuchLmisAbsenceSettingsException, SystemException {
		int count = countByAbsencePermissive(absencePermissive);

		List<LmisAbsenceSettings> list = findByAbsencePermissive(absencePermissive,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAbsenceSettings exists with the key {");

			msg.append("absencePermissive=" + absencePermissive);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAbsenceSettingsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAbsenceSettings[] findByAbsencePermissive_PrevAndNext(
		Integer lmisAbsenceSettingsId, boolean absencePermissive,
		OrderByComparator obc)
		throws NoSuchLmisAbsenceSettingsException, SystemException {
		LmisAbsenceSettings lmisAbsenceSettings = findByPrimaryKey(lmisAbsenceSettingsId);

		int count = countByAbsencePermissive(absencePermissive);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisAbsenceSettings WHERE ");

			query.append("absence_permissive = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("name ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(absencePermissive);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisAbsenceSettings);

			LmisAbsenceSettings[] array = new LmisAbsenceSettingsImpl[3];

			array[0] = (LmisAbsenceSettings)objArray[0];
			array[1] = (LmisAbsenceSettings)objArray[1];
			array[2] = (LmisAbsenceSettings)objArray[2];

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

	public List<LmisAbsenceSettings> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<LmisAbsenceSettings> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<LmisAbsenceSettings> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisAbsenceSettings> list = (List<LmisAbsenceSettings>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceSettings ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("name ASC");
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<LmisAbsenceSettings>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LmisAbsenceSettings>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisAbsenceSettings>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByRootID(int rootId) throws SystemException {
		for (LmisAbsenceSettings lmisAbsenceSettings : findByRootID(rootId)) {
			remove(lmisAbsenceSettings);
		}
	}

	public void removeByAbsencePermissive(boolean absencePermissive)
		throws SystemException {
		for (LmisAbsenceSettings lmisAbsenceSettings : findByAbsencePermissive(
				absencePermissive)) {
			remove(lmisAbsenceSettings);
		}
	}

	public void removeAll() throws SystemException {
		for (LmisAbsenceSettings lmisAbsenceSettings : findAll()) {
			remove(lmisAbsenceSettings);
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
					"FROM larion.progate.lmis.model.LmisAbsenceSettings WHERE ");

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

	public int countByAbsencePermissive(boolean absencePermissive)
		throws SystemException {
		Object[] finderArgs = new Object[] { Boolean.valueOf(absencePermissive) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ABSENCEPERMISSIVE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceSettings WHERE ");

				query.append("absence_permissive = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(absencePermissive);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ABSENCEPERMISSIVE,
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
						"SELECT COUNT(*) FROM larion.progate.lmis.model.LmisAbsenceSettings");

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

	public List<larion.progate.lmis.model.LmisAttendanceDaily> getLmisAttendanceDailies(
		Integer pk) throws SystemException {
		return getLmisAttendanceDailies(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public List<larion.progate.lmis.model.LmisAttendanceDaily> getLmisAttendanceDailies(
		Integer pk, int start, int end) throws SystemException {
		return getLmisAttendanceDailies(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_LMISATTENDANCEDAILIES = new FinderPath(larion.progate.lmis.model.impl.LmisAttendanceDailyModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.lmis.model.impl.LmisAttendanceDailyModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.lmis.service.persistence.LmisAttendanceDailyPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getLmisAttendanceDailies",
			new String[] {
				Integer.class.getName(), "java.lang.Integer",
				"java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	public List<larion.progate.lmis.model.LmisAttendanceDaily> getLmisAttendanceDailies(
		Integer pk, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				pk, String.valueOf(start), String.valueOf(end),
				String.valueOf(obc)
			};

		List<larion.progate.lmis.model.LmisAttendanceDaily> list = (List<larion.progate.lmis.model.LmisAttendanceDaily>)FinderCacheUtil.getResult(FINDER_PATH_GET_LMISATTENDANCEDAILIES,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder sb = new StringBuilder();

				sb.append(_SQL_GETLMISATTENDANCEDAILIES);

				if (obc != null) {
					sb.append("ORDER BY ");
					sb.append(obc.getOrderBy());
				}

				else {
					sb.append("ORDER BY ");

					sb.append("lmis_attendance_daily.day_value ASC");
				}

				String sql = sb.toString();

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("lmis_attendance_daily",
					larion.progate.lmis.model.impl.LmisAttendanceDailyImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<larion.progate.lmis.model.LmisAttendanceDaily>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<larion.progate.lmis.model.LmisAttendanceDaily>();
				}

				lmisAttendanceDailyPersistence.cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_GET_LMISATTENDANCEDAILIES,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_LMISATTENDANCEDAILIES_SIZE = new FinderPath(larion.progate.lmis.model.impl.LmisAttendanceDailyModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.lmis.model.impl.LmisAttendanceDailyModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.lmis.service.persistence.LmisAttendanceDailyPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getLmisAttendanceDailiesSize",
			new String[] { Integer.class.getName() });

	public int getLmisAttendanceDailiesSize(Integer pk)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_LMISATTENDANCEDAILIES_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETLMISATTENDANCEDAILIESSIZE);

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

				FinderCacheUtil.putResult(FINDER_PATH_GET_LMISATTENDANCEDAILIES_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_LMISATTENDANCEDAILY = new FinderPath(larion.progate.lmis.model.impl.LmisAttendanceDailyModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.lmis.model.impl.LmisAttendanceDailyModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.lmis.service.persistence.LmisAttendanceDailyPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"containsLmisAttendanceDaily",
			new String[] { Integer.class.getName(), Integer.class.getName() });

	public boolean containsLmisAttendanceDaily(Integer pk,
		Integer lmisAttendanceDailyPK) throws SystemException {
		Object[] finderArgs = new Object[] { pk, lmisAttendanceDailyPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_LMISATTENDANCEDAILY,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsLmisAttendanceDaily.contains(
							pk, lmisAttendanceDailyPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_LMISATTENDANCEDAILY,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	public boolean containsLmisAttendanceDailies(Integer pk)
		throws SystemException {
		if (getLmisAttendanceDailiesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public List<larion.progate.lmis.model.LmisAbsenceRequests> getLmisAbsenceRequestses(
		Integer pk) throws SystemException {
		return getLmisAbsenceRequestses(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public List<larion.progate.lmis.model.LmisAbsenceRequests> getLmisAbsenceRequestses(
		Integer pk, int start, int end) throws SystemException {
		return getLmisAbsenceRequestses(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_LMISABSENCEREQUESTSES = new FinderPath(larion.progate.lmis.model.impl.LmisAbsenceRequestsModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.lmis.model.impl.LmisAbsenceRequestsModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.lmis.service.persistence.LmisAbsenceRequestsPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getLmisAbsenceRequestses",
			new String[] {
				Integer.class.getName(), "java.lang.Integer",
				"java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	public List<larion.progate.lmis.model.LmisAbsenceRequests> getLmisAbsenceRequestses(
		Integer pk, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				pk, String.valueOf(start), String.valueOf(end),
				String.valueOf(obc)
			};

		List<larion.progate.lmis.model.LmisAbsenceRequests> list = (List<larion.progate.lmis.model.LmisAbsenceRequests>)FinderCacheUtil.getResult(FINDER_PATH_GET_LMISABSENCEREQUESTSES,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder sb = new StringBuilder();

				sb.append(_SQL_GETLMISABSENCEREQUESTSES);

				if (obc != null) {
					sb.append("ORDER BY ");
					sb.append(obc.getOrderBy());
				}

				else {
					sb.append("ORDER BY ");

					sb.append("lmis_absence_requests.requested_status ASC, ");
					sb.append("lmis_absence_requests.created_at DESC");
				}

				String sql = sb.toString();

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("lmis_absence_requests",
					larion.progate.lmis.model.impl.LmisAbsenceRequestsImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<larion.progate.lmis.model.LmisAbsenceRequests>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<larion.progate.lmis.model.LmisAbsenceRequests>();
				}

				lmisAbsenceRequestsPersistence.cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_GET_LMISABSENCEREQUESTSES,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_LMISABSENCEREQUESTSES_SIZE = new FinderPath(larion.progate.lmis.model.impl.LmisAbsenceRequestsModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.lmis.model.impl.LmisAbsenceRequestsModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.lmis.service.persistence.LmisAbsenceRequestsPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getLmisAbsenceRequestsesSize",
			new String[] { Integer.class.getName() });

	public int getLmisAbsenceRequestsesSize(Integer pk)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_LMISABSENCEREQUESTSES_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETLMISABSENCEREQUESTSESSIZE);

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

				FinderCacheUtil.putResult(FINDER_PATH_GET_LMISABSENCEREQUESTSES_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_LMISABSENCEREQUESTS = new FinderPath(larion.progate.lmis.model.impl.LmisAbsenceRequestsModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.lmis.model.impl.LmisAbsenceRequestsModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.lmis.service.persistence.LmisAbsenceRequestsPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"containsLmisAbsenceRequests",
			new String[] { Integer.class.getName(), Integer.class.getName() });

	public boolean containsLmisAbsenceRequests(Integer pk,
		Integer lmisAbsenceRequestsPK) throws SystemException {
		Object[] finderArgs = new Object[] { pk, lmisAbsenceRequestsPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_LMISABSENCEREQUESTS,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsLmisAbsenceRequests.contains(
							pk, lmisAbsenceRequestsPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_LMISABSENCEREQUESTS,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	public boolean containsLmisAbsenceRequestses(Integer pk)
		throws SystemException {
		if (getLmisAbsenceRequestsesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.larion.progate.lmis.model.LmisAbsenceSettings")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LmisAbsenceSettings>> listenersList = new ArrayList<ModelListener<LmisAbsenceSettings>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LmisAbsenceSettings>)Class.forName(
							listenerClassName).newInstance());
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		containsLmisAttendanceDaily = new ContainsLmisAttendanceDaily(this);

		containsLmisAbsenceRequests = new ContainsLmisAbsenceRequests(this);
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
	protected ContainsLmisAttendanceDaily containsLmisAttendanceDaily;
	protected ContainsLmisAbsenceRequests containsLmisAbsenceRequests;

	protected class ContainsLmisAttendanceDaily {
		protected ContainsLmisAttendanceDaily(
			LmisAbsenceSettingsPersistenceImpl persistenceImpl) {
			super();

			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSLMISATTENDANCEDAILY,
					new int[] { Types.INTEGER, Types.INTEGER }, RowMapper.COUNT);
		}

		protected boolean contains(Integer lmisAbsenceSettingsId,
			Integer lmisAttendanceDailyId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						lmisAbsenceSettingsId, lmisAttendanceDailyId
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

	protected class ContainsLmisAbsenceRequests {
		protected ContainsLmisAbsenceRequests(
			LmisAbsenceSettingsPersistenceImpl persistenceImpl) {
			super();

			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSLMISABSENCEREQUESTS,
					new int[] { Types.INTEGER, Types.INTEGER }, RowMapper.COUNT);
		}

		protected boolean contains(Integer lmisAbsenceSettingsId,
			Integer lmisAbsenceRequestsId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						lmisAbsenceSettingsId, lmisAbsenceRequestsId
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

	private static final String _SQL_GETLMISATTENDANCEDAILIES = "SELECT {lmis_attendance_daily.*} FROM lmis_attendance_daily INNER JOIN lmis_absence_settings ON (lmis_absence_settings.lmisAbsenceSettingsId = lmis_attendance_daily.lmisAbsenceSettingsId) WHERE (lmis_absence_settings.lmisAbsenceSettingsId = ?)";
	private static final String _SQL_GETLMISATTENDANCEDAILIESSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM lmis_attendance_daily WHERE lmisAbsenceSettingsId = ?";
	private static final String _SQL_CONTAINSLMISATTENDANCEDAILY = "SELECT COUNT(*) AS COUNT_VALUE FROM lmis_attendance_daily WHERE lmisAbsenceSettingsId = ? AND lmisAttendanceDailyId = ?";
	private static final String _SQL_GETLMISABSENCEREQUESTSES = "SELECT {lmis_absence_requests.*} FROM lmis_absence_requests INNER JOIN lmis_absence_settings ON (lmis_absence_settings.lmisAbsenceSettingsId = lmis_absence_requests.lmisAbsenceSettingsId) WHERE (lmis_absence_settings.lmisAbsenceSettingsId = ?)";
	private static final String _SQL_GETLMISABSENCEREQUESTSESSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM lmis_absence_requests WHERE lmisAbsenceSettingsId = ?";
	private static final String _SQL_CONTAINSLMISABSENCEREQUESTS = "SELECT COUNT(*) AS COUNT_VALUE FROM lmis_absence_requests WHERE lmisAbsenceSettingsId = ? AND lmisAbsenceRequestsId = ?";
	private static Log _log = LogFactoryUtil.getLog(LmisAbsenceSettingsPersistenceImpl.class);
}