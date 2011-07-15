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

import larion.progate.lmis.NoSuchLmisOverTimeSettingsException;
import larion.progate.lmis.model.LmisOverTimeSettings;
import larion.progate.lmis.model.impl.LmisOverTimeSettingsImpl;
import larion.progate.lmis.model.impl.LmisOverTimeSettingsModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="LmisOverTimeSettingsPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisOverTimeSettingsPersistenceImpl extends BasePersistenceImpl
	implements LmisOverTimeSettingsPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = LmisOverTimeSettingsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_OTID = new FinderPath(LmisOverTimeSettingsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeSettingsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOtID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_OTID = new FinderPath(LmisOverTimeSettingsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeSettingsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOtID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_OTID = new FinderPath(LmisOverTimeSettingsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeSettingsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByOtID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_DAYID = new FinderPath(LmisOverTimeSettingsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeSettingsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByDayID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_DAYID = new FinderPath(LmisOverTimeSettingsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeSettingsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByDayID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_DAYID = new FinderPath(LmisOverTimeSettingsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeSettingsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByDayID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OVERTIMESETTINGSOF = new FinderPath(LmisOverTimeSettingsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeSettingsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOverTimeSettingsOf",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_OVERTIMESETTINGSOF = new FinderPath(LmisOverTimeSettingsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeSettingsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOverTimeSettingsOf",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_OVERTIMESETTINGSOF = new FinderPath(LmisOverTimeSettingsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeSettingsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByOverTimeSettingsOf",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(LmisOverTimeSettingsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeSettingsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LmisOverTimeSettingsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeSettingsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(LmisOverTimeSettings lmisOverTimeSettings) {
		EntityCacheUtil.putResult(LmisOverTimeSettingsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeSettingsImpl.class,
			lmisOverTimeSettings.getPrimaryKey(), lmisOverTimeSettings);
	}

	public void cacheResult(List<LmisOverTimeSettings> lmisOverTimeSettingses) {
		for (LmisOverTimeSettings lmisOverTimeSettings : lmisOverTimeSettingses) {
			if (EntityCacheUtil.getResult(
						LmisOverTimeSettingsModelImpl.ENTITY_CACHE_ENABLED,
						LmisOverTimeSettingsImpl.class,
						lmisOverTimeSettings.getPrimaryKey(), this) == null) {
				cacheResult(lmisOverTimeSettings);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(LmisOverTimeSettingsImpl.class.getName());
		EntityCacheUtil.clearCache(LmisOverTimeSettingsImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public LmisOverTimeSettings create(Integer lmisOverTimeSettingsId) {
		LmisOverTimeSettings lmisOverTimeSettings = new LmisOverTimeSettingsImpl();

		lmisOverTimeSettings.setNew(true);
		lmisOverTimeSettings.setPrimaryKey(lmisOverTimeSettingsId);

		return lmisOverTimeSettings;
	}

	public LmisOverTimeSettings remove(Integer lmisOverTimeSettingsId)
		throws NoSuchLmisOverTimeSettingsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LmisOverTimeSettings lmisOverTimeSettings = (LmisOverTimeSettings)session.get(LmisOverTimeSettingsImpl.class,
					lmisOverTimeSettingsId);

			if (lmisOverTimeSettings == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No LmisOverTimeSettings exists with the primary key " +
						lmisOverTimeSettingsId);
				}

				throw new NoSuchLmisOverTimeSettingsException(
					"No LmisOverTimeSettings exists with the primary key " +
					lmisOverTimeSettingsId);
			}

			return remove(lmisOverTimeSettings);
		}
		catch (NoSuchLmisOverTimeSettingsException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public LmisOverTimeSettings remove(
		LmisOverTimeSettings lmisOverTimeSettings) throws SystemException {
		for (ModelListener<LmisOverTimeSettings> listener : listeners) {
			listener.onBeforeRemove(lmisOverTimeSettings);
		}

		lmisOverTimeSettings = removeImpl(lmisOverTimeSettings);

		for (ModelListener<LmisOverTimeSettings> listener : listeners) {
			listener.onAfterRemove(lmisOverTimeSettings);
		}

		return lmisOverTimeSettings;
	}

	protected LmisOverTimeSettings removeImpl(
		LmisOverTimeSettings lmisOverTimeSettings) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (lmisOverTimeSettings.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(LmisOverTimeSettingsImpl.class,
						lmisOverTimeSettings.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(lmisOverTimeSettings);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(LmisOverTimeSettingsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeSettingsImpl.class, lmisOverTimeSettings.getPrimaryKey());

		return lmisOverTimeSettings;
	}

	public LmisOverTimeSettings update(
		LmisOverTimeSettings lmisOverTimeSettings) throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(LmisOverTimeSettings lmisOverTimeSettings) method. Use update(LmisOverTimeSettings lmisOverTimeSettings, boolean merge) instead.");
		}

		return update(lmisOverTimeSettings, false);
	}

	public LmisOverTimeSettings update(
		LmisOverTimeSettings lmisOverTimeSettings, boolean merge)
		throws SystemException {
		boolean isNew = lmisOverTimeSettings.isNew();

		for (ModelListener<LmisOverTimeSettings> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(lmisOverTimeSettings);
			}
			else {
				listener.onBeforeUpdate(lmisOverTimeSettings);
			}
		}

		lmisOverTimeSettings = updateImpl(lmisOverTimeSettings, merge);

		for (ModelListener<LmisOverTimeSettings> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(lmisOverTimeSettings);
			}
			else {
				listener.onAfterUpdate(lmisOverTimeSettings);
			}
		}

		return lmisOverTimeSettings;
	}

	public LmisOverTimeSettings updateImpl(
		larion.progate.lmis.model.LmisOverTimeSettings lmisOverTimeSettings,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, lmisOverTimeSettings, merge);

			lmisOverTimeSettings.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(LmisOverTimeSettingsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeSettingsImpl.class,
			lmisOverTimeSettings.getPrimaryKey(), lmisOverTimeSettings);

		return lmisOverTimeSettings;
	}

	public LmisOverTimeSettings findByPrimaryKey(Integer lmisOverTimeSettingsId)
		throws NoSuchLmisOverTimeSettingsException, SystemException {
		LmisOverTimeSettings lmisOverTimeSettings = fetchByPrimaryKey(lmisOverTimeSettingsId);

		if (lmisOverTimeSettings == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"No LmisOverTimeSettings exists with the primary key " +
					lmisOverTimeSettingsId);
			}

			throw new NoSuchLmisOverTimeSettingsException(
				"No LmisOverTimeSettings exists with the primary key " +
				lmisOverTimeSettingsId);
		}

		return lmisOverTimeSettings;
	}

	public LmisOverTimeSettings fetchByPrimaryKey(
		Integer lmisOverTimeSettingsId) throws SystemException {
		LmisOverTimeSettings lmisOverTimeSettings = (LmisOverTimeSettings)EntityCacheUtil.getResult(LmisOverTimeSettingsModelImpl.ENTITY_CACHE_ENABLED,
				LmisOverTimeSettingsImpl.class, lmisOverTimeSettingsId, this);

		if (lmisOverTimeSettings == null) {
			Session session = null;

			try {
				session = openSession();

				lmisOverTimeSettings = (LmisOverTimeSettings)session.get(LmisOverTimeSettingsImpl.class,
						lmisOverTimeSettingsId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (lmisOverTimeSettings != null) {
					cacheResult(lmisOverTimeSettings);
				}

				closeSession(session);
			}
		}

		return lmisOverTimeSettings;
	}

	public List<LmisOverTimeSettings> findByOtID(int otId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(otId) };

		List<LmisOverTimeSettings> list = (List<LmisOverTimeSettings>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOverTimeSettings WHERE ");

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
					list = new ArrayList<LmisOverTimeSettings>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OTID, finderArgs,
					list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisOverTimeSettings> findByOtID(int otId, int start, int end)
		throws SystemException {
		return findByOtID(otId, start, end, null);
	}

	public List<LmisOverTimeSettings> findByOtID(int otId, int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(otId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisOverTimeSettings> list = (List<LmisOverTimeSettings>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_OTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOverTimeSettings WHERE ");

				query.append("ot_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(otId);

				list = (List<LmisOverTimeSettings>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisOverTimeSettings>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_OTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisOverTimeSettings findByOtID_First(int otId, OrderByComparator obc)
		throws NoSuchLmisOverTimeSettingsException, SystemException {
		List<LmisOverTimeSettings> list = findByOtID(otId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOverTimeSettings exists with the key {");

			msg.append("otId=" + otId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOverTimeSettingsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOverTimeSettings findByOtID_Last(int otId, OrderByComparator obc)
		throws NoSuchLmisOverTimeSettingsException, SystemException {
		int count = countByOtID(otId);

		List<LmisOverTimeSettings> list = findByOtID(otId, count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOverTimeSettings exists with the key {");

			msg.append("otId=" + otId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOverTimeSettingsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOverTimeSettings[] findByOtID_PrevAndNext(
		Integer lmisOverTimeSettingsId, int otId, OrderByComparator obc)
		throws NoSuchLmisOverTimeSettingsException, SystemException {
		LmisOverTimeSettings lmisOverTimeSettings = findByPrimaryKey(lmisOverTimeSettingsId);

		int count = countByOtID(otId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisOverTimeSettings WHERE ");

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
					lmisOverTimeSettings);

			LmisOverTimeSettings[] array = new LmisOverTimeSettingsImpl[3];

			array[0] = (LmisOverTimeSettings)objArray[0];
			array[1] = (LmisOverTimeSettings)objArray[1];
			array[2] = (LmisOverTimeSettings)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisOverTimeSettings> findByDayID(int dayType)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(dayType) };

		List<LmisOverTimeSettings> list = (List<LmisOverTimeSettings>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DAYID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOverTimeSettings WHERE ");

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
					list = new ArrayList<LmisOverTimeSettings>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DAYID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisOverTimeSettings> findByDayID(int dayType, int start,
		int end) throws SystemException {
		return findByDayID(dayType, start, end, null);
	}

	public List<LmisOverTimeSettings> findByDayID(int dayType, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(dayType),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisOverTimeSettings> list = (List<LmisOverTimeSettings>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_DAYID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOverTimeSettings WHERE ");

				query.append("day_type = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dayType);

				list = (List<LmisOverTimeSettings>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisOverTimeSettings>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_DAYID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisOverTimeSettings findByDayID_First(int dayType,
		OrderByComparator obc)
		throws NoSuchLmisOverTimeSettingsException, SystemException {
		List<LmisOverTimeSettings> list = findByDayID(dayType, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOverTimeSettings exists with the key {");

			msg.append("dayType=" + dayType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOverTimeSettingsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOverTimeSettings findByDayID_Last(int dayType,
		OrderByComparator obc)
		throws NoSuchLmisOverTimeSettingsException, SystemException {
		int count = countByDayID(dayType);

		List<LmisOverTimeSettings> list = findByDayID(dayType, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOverTimeSettings exists with the key {");

			msg.append("dayType=" + dayType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOverTimeSettingsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOverTimeSettings[] findByDayID_PrevAndNext(
		Integer lmisOverTimeSettingsId, int dayType, OrderByComparator obc)
		throws NoSuchLmisOverTimeSettingsException, SystemException {
		LmisOverTimeSettings lmisOverTimeSettings = findByPrimaryKey(lmisOverTimeSettingsId);

		int count = countByDayID(dayType);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisOverTimeSettings WHERE ");

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
					lmisOverTimeSettings);

			LmisOverTimeSettings[] array = new LmisOverTimeSettingsImpl[3];

			array[0] = (LmisOverTimeSettings)objArray[0];
			array[1] = (LmisOverTimeSettings)objArray[1];
			array[2] = (LmisOverTimeSettings)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisOverTimeSettings> findByOverTimeSettingsOf(int rootId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		List<LmisOverTimeSettings> list = (List<LmisOverTimeSettings>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OVERTIMESETTINGSOF,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOverTimeSettings WHERE ");

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
					list = new ArrayList<LmisOverTimeSettings>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OVERTIMESETTINGSOF,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisOverTimeSettings> findByOverTimeSettingsOf(int rootId,
		int start, int end) throws SystemException {
		return findByOverTimeSettingsOf(rootId, start, end, null);
	}

	public List<LmisOverTimeSettings> findByOverTimeSettingsOf(int rootId,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(rootId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisOverTimeSettings> list = (List<LmisOverTimeSettings>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_OVERTIMESETTINGSOF,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOverTimeSettings WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rootId);

				list = (List<LmisOverTimeSettings>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisOverTimeSettings>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_OVERTIMESETTINGSOF,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisOverTimeSettings findByOverTimeSettingsOf_First(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisOverTimeSettingsException, SystemException {
		List<LmisOverTimeSettings> list = findByOverTimeSettingsOf(rootId, 0,
				1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOverTimeSettings exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOverTimeSettingsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOverTimeSettings findByOverTimeSettingsOf_Last(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisOverTimeSettingsException, SystemException {
		int count = countByOverTimeSettingsOf(rootId);

		List<LmisOverTimeSettings> list = findByOverTimeSettingsOf(rootId,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOverTimeSettings exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOverTimeSettingsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOverTimeSettings[] findByOverTimeSettingsOf_PrevAndNext(
		Integer lmisOverTimeSettingsId, int rootId, OrderByComparator obc)
		throws NoSuchLmisOverTimeSettingsException, SystemException {
		LmisOverTimeSettings lmisOverTimeSettings = findByPrimaryKey(lmisOverTimeSettingsId);

		int count = countByOverTimeSettingsOf(rootId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisOverTimeSettings WHERE ");

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
					lmisOverTimeSettings);

			LmisOverTimeSettings[] array = new LmisOverTimeSettingsImpl[3];

			array[0] = (LmisOverTimeSettings)objArray[0];
			array[1] = (LmisOverTimeSettings)objArray[1];
			array[2] = (LmisOverTimeSettings)objArray[2];

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

	public List<LmisOverTimeSettings> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<LmisOverTimeSettings> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<LmisOverTimeSettings> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisOverTimeSettings> list = (List<LmisOverTimeSettings>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOverTimeSettings ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<LmisOverTimeSettings>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LmisOverTimeSettings>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisOverTimeSettings>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByOtID(int otId) throws SystemException {
		for (LmisOverTimeSettings lmisOverTimeSettings : findByOtID(otId)) {
			remove(lmisOverTimeSettings);
		}
	}

	public void removeByDayID(int dayType) throws SystemException {
		for (LmisOverTimeSettings lmisOverTimeSettings : findByDayID(dayType)) {
			remove(lmisOverTimeSettings);
		}
	}

	public void removeByOverTimeSettingsOf(int rootId)
		throws SystemException {
		for (LmisOverTimeSettings lmisOverTimeSettings : findByOverTimeSettingsOf(
				rootId)) {
			remove(lmisOverTimeSettings);
		}
	}

	public void removeAll() throws SystemException {
		for (LmisOverTimeSettings lmisOverTimeSettings : findAll()) {
			remove(lmisOverTimeSettings);
		}
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
					"FROM larion.progate.lmis.model.LmisOverTimeSettings WHERE ");

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

	public int countByDayID(int dayType) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(dayType) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DAYID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisOverTimeSettings WHERE ");

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DAYID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByOverTimeSettingsOf(int rootId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_OVERTIMESETTINGSOF,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisOverTimeSettings WHERE ");

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_OVERTIMESETTINGSOF,
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
						"SELECT COUNT(*) FROM larion.progate.lmis.model.LmisOverTimeSettings");

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
						"value.object.listener.larion.progate.lmis.model.LmisOverTimeSettings")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LmisOverTimeSettings>> listenersList = new ArrayList<ModelListener<LmisOverTimeSettings>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LmisOverTimeSettings>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(LmisOverTimeSettingsPersistenceImpl.class);
}