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

import larion.progate.lmis.NoSuchLmisEmailSettingsException;
import larion.progate.lmis.model.LmisEmailSettings;
import larion.progate.lmis.model.impl.LmisEmailSettingsImpl;
import larion.progate.lmis.model.impl.LmisEmailSettingsModelImpl;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="LmisEmailSettingsPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisEmailSettingsPersistenceImpl extends BasePersistenceImpl
	implements LmisEmailSettingsPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = LmisEmailSettingsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_EMAILSETTINGOF = new FinderPath(LmisEmailSettingsModelImpl.ENTITY_CACHE_ENABLED,
			LmisEmailSettingsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByEmailSettingOf",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_EMAILSETTINGOF = new FinderPath(LmisEmailSettingsModelImpl.ENTITY_CACHE_ENABLED,
			LmisEmailSettingsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByEmailSettingOf",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_EMAILSETTINGOF = new FinderPath(LmisEmailSettingsModelImpl.ENTITY_CACHE_ENABLED,
			LmisEmailSettingsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByEmailSettingOf",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_CATEGORYID = new FinderPath(LmisEmailSettingsModelImpl.ENTITY_CACHE_ENABLED,
			LmisEmailSettingsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByCategoryId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_CATEGORYID = new FinderPath(LmisEmailSettingsModelImpl.ENTITY_CACHE_ENABLED,
			LmisEmailSettingsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByCategoryId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORYID = new FinderPath(LmisEmailSettingsModelImpl.ENTITY_CACHE_ENABLED,
			LmisEmailSettingsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByCategoryId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_EMAILTYPE = new FinderPath(LmisEmailSettingsModelImpl.ENTITY_CACHE_ENABLED,
			LmisEmailSettingsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByEmailType",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_EMAILTYPE = new FinderPath(LmisEmailSettingsModelImpl.ENTITY_CACHE_ENABLED,
			LmisEmailSettingsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByEmailType",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_EMAILTYPE = new FinderPath(LmisEmailSettingsModelImpl.ENTITY_CACHE_ENABLED,
			LmisEmailSettingsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByEmailType",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(LmisEmailSettingsModelImpl.ENTITY_CACHE_ENABLED,
			LmisEmailSettingsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LmisEmailSettingsModelImpl.ENTITY_CACHE_ENABLED,
			LmisEmailSettingsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(LmisEmailSettings lmisEmailSettings) {
		EntityCacheUtil.putResult(LmisEmailSettingsModelImpl.ENTITY_CACHE_ENABLED,
			LmisEmailSettingsImpl.class, lmisEmailSettings.getPrimaryKey(),
			lmisEmailSettings);
	}

	public void cacheResult(List<LmisEmailSettings> lmisEmailSettingses) {
		for (LmisEmailSettings lmisEmailSettings : lmisEmailSettingses) {
			if (EntityCacheUtil.getResult(
						LmisEmailSettingsModelImpl.ENTITY_CACHE_ENABLED,
						LmisEmailSettingsImpl.class,
						lmisEmailSettings.getPrimaryKey(), this) == null) {
				cacheResult(lmisEmailSettings);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(LmisEmailSettingsImpl.class.getName());
		EntityCacheUtil.clearCache(LmisEmailSettingsImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public LmisEmailSettings create(Integer lmisEmailSettingId) {
		LmisEmailSettings lmisEmailSettings = new LmisEmailSettingsImpl();

		lmisEmailSettings.setNew(true);
		lmisEmailSettings.setPrimaryKey(lmisEmailSettingId);

		return lmisEmailSettings;
	}

	public LmisEmailSettings remove(Integer lmisEmailSettingId)
		throws NoSuchLmisEmailSettingsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LmisEmailSettings lmisEmailSettings = (LmisEmailSettings)session.get(LmisEmailSettingsImpl.class,
					lmisEmailSettingId);

			if (lmisEmailSettings == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No LmisEmailSettings exists with the primary key " +
						lmisEmailSettingId);
				}

				throw new NoSuchLmisEmailSettingsException(
					"No LmisEmailSettings exists with the primary key " +
					lmisEmailSettingId);
			}

			return remove(lmisEmailSettings);
		}
		catch (NoSuchLmisEmailSettingsException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public LmisEmailSettings remove(LmisEmailSettings lmisEmailSettings)
		throws SystemException {
		for (ModelListener<LmisEmailSettings> listener : listeners) {
			listener.onBeforeRemove(lmisEmailSettings);
		}

		lmisEmailSettings = removeImpl(lmisEmailSettings);

		for (ModelListener<LmisEmailSettings> listener : listeners) {
			listener.onAfterRemove(lmisEmailSettings);
		}

		return lmisEmailSettings;
	}

	protected LmisEmailSettings removeImpl(LmisEmailSettings lmisEmailSettings)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (lmisEmailSettings.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(LmisEmailSettingsImpl.class,
						lmisEmailSettings.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(lmisEmailSettings);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(LmisEmailSettingsModelImpl.ENTITY_CACHE_ENABLED,
			LmisEmailSettingsImpl.class, lmisEmailSettings.getPrimaryKey());

		return lmisEmailSettings;
	}

	public LmisEmailSettings update(LmisEmailSettings lmisEmailSettings)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(LmisEmailSettings lmisEmailSettings) method. Use update(LmisEmailSettings lmisEmailSettings, boolean merge) instead.");
		}

		return update(lmisEmailSettings, false);
	}

	public LmisEmailSettings update(LmisEmailSettings lmisEmailSettings,
		boolean merge) throws SystemException {
		boolean isNew = lmisEmailSettings.isNew();

		for (ModelListener<LmisEmailSettings> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(lmisEmailSettings);
			}
			else {
				listener.onBeforeUpdate(lmisEmailSettings);
			}
		}

		lmisEmailSettings = updateImpl(lmisEmailSettings, merge);

		for (ModelListener<LmisEmailSettings> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(lmisEmailSettings);
			}
			else {
				listener.onAfterUpdate(lmisEmailSettings);
			}
		}

		return lmisEmailSettings;
	}

	public LmisEmailSettings updateImpl(
		larion.progate.lmis.model.LmisEmailSettings lmisEmailSettings,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, lmisEmailSettings, merge);

			lmisEmailSettings.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(LmisEmailSettingsModelImpl.ENTITY_CACHE_ENABLED,
			LmisEmailSettingsImpl.class, lmisEmailSettings.getPrimaryKey(),
			lmisEmailSettings);

		return lmisEmailSettings;
	}

	public LmisEmailSettings findByPrimaryKey(Integer lmisEmailSettingId)
		throws NoSuchLmisEmailSettingsException, SystemException {
		LmisEmailSettings lmisEmailSettings = fetchByPrimaryKey(lmisEmailSettingId);

		if (lmisEmailSettings == null) {
			if (_log.isWarnEnabled()) {
				_log.warn("No LmisEmailSettings exists with the primary key " +
					lmisEmailSettingId);
			}

			throw new NoSuchLmisEmailSettingsException(
				"No LmisEmailSettings exists with the primary key " +
				lmisEmailSettingId);
		}

		return lmisEmailSettings;
	}

	public LmisEmailSettings fetchByPrimaryKey(Integer lmisEmailSettingId)
		throws SystemException {
		LmisEmailSettings lmisEmailSettings = (LmisEmailSettings)EntityCacheUtil.getResult(LmisEmailSettingsModelImpl.ENTITY_CACHE_ENABLED,
				LmisEmailSettingsImpl.class, lmisEmailSettingId, this);

		if (lmisEmailSettings == null) {
			Session session = null;

			try {
				session = openSession();

				lmisEmailSettings = (LmisEmailSettings)session.get(LmisEmailSettingsImpl.class,
						lmisEmailSettingId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (lmisEmailSettings != null) {
					cacheResult(lmisEmailSettings);
				}

				closeSession(session);
			}
		}

		return lmisEmailSettings;
	}

	public List<LmisEmailSettings> findByEmailSettingOf(int rootId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		List<LmisEmailSettings> list = (List<LmisEmailSettings>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_EMAILSETTINGOF,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisEmailSettings WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("email_type ASC");

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
					list = new ArrayList<LmisEmailSettings>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_EMAILSETTINGOF,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisEmailSettings> findByEmailSettingOf(int rootId, int start,
		int end) throws SystemException {
		return findByEmailSettingOf(rootId, start, end, null);
	}

	public List<LmisEmailSettings> findByEmailSettingOf(int rootId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(rootId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisEmailSettings> list = (List<LmisEmailSettings>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_EMAILSETTINGOF,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisEmailSettings WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("email_type ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rootId);

				list = (List<LmisEmailSettings>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisEmailSettings>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_EMAILSETTINGOF,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisEmailSettings findByEmailSettingOf_First(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisEmailSettingsException, SystemException {
		List<LmisEmailSettings> list = findByEmailSettingOf(rootId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisEmailSettings exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisEmailSettingsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisEmailSettings findByEmailSettingOf_Last(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisEmailSettingsException, SystemException {
		int count = countByEmailSettingOf(rootId);

		List<LmisEmailSettings> list = findByEmailSettingOf(rootId, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisEmailSettings exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisEmailSettingsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisEmailSettings[] findByEmailSettingOf_PrevAndNext(
		Integer lmisEmailSettingId, int rootId, OrderByComparator obc)
		throws NoSuchLmisEmailSettingsException, SystemException {
		LmisEmailSettings lmisEmailSettings = findByPrimaryKey(lmisEmailSettingId);

		int count = countByEmailSettingOf(rootId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisEmailSettings WHERE ");

			query.append("root_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("email_type ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(rootId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisEmailSettings);

			LmisEmailSettings[] array = new LmisEmailSettingsImpl[3];

			array[0] = (LmisEmailSettings)objArray[0];
			array[1] = (LmisEmailSettings)objArray[1];
			array[2] = (LmisEmailSettings)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisEmailSettings> findByCategoryId(int category)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(category) };

		List<LmisEmailSettings> list = (List<LmisEmailSettings>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_CATEGORYID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisEmailSettings WHERE ");

				query.append("category = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("email_type ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(category);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisEmailSettings>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_CATEGORYID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisEmailSettings> findByCategoryId(int category, int start,
		int end) throws SystemException {
		return findByCategoryId(category, start, end, null);
	}

	public List<LmisEmailSettings> findByCategoryId(int category, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(category),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisEmailSettings> list = (List<LmisEmailSettings>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_CATEGORYID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisEmailSettings WHERE ");

				query.append("category = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("email_type ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(category);

				list = (List<LmisEmailSettings>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisEmailSettings>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_CATEGORYID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisEmailSettings findByCategoryId_First(int category,
		OrderByComparator obc)
		throws NoSuchLmisEmailSettingsException, SystemException {
		List<LmisEmailSettings> list = findByCategoryId(category, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisEmailSettings exists with the key {");

			msg.append("category=" + category);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisEmailSettingsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisEmailSettings findByCategoryId_Last(int category,
		OrderByComparator obc)
		throws NoSuchLmisEmailSettingsException, SystemException {
		int count = countByCategoryId(category);

		List<LmisEmailSettings> list = findByCategoryId(category, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisEmailSettings exists with the key {");

			msg.append("category=" + category);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisEmailSettingsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisEmailSettings[] findByCategoryId_PrevAndNext(
		Integer lmisEmailSettingId, int category, OrderByComparator obc)
		throws NoSuchLmisEmailSettingsException, SystemException {
		LmisEmailSettings lmisEmailSettings = findByPrimaryKey(lmisEmailSettingId);

		int count = countByCategoryId(category);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisEmailSettings WHERE ");

			query.append("category = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("email_type ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(category);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisEmailSettings);

			LmisEmailSettings[] array = new LmisEmailSettingsImpl[3];

			array[0] = (LmisEmailSettings)objArray[0];
			array[1] = (LmisEmailSettings)objArray[1];
			array[2] = (LmisEmailSettings)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisEmailSettings> findByEmailType(String emailType)
		throws SystemException {
		Object[] finderArgs = new Object[] { emailType };

		List<LmisEmailSettings> list = (List<LmisEmailSettings>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_EMAILTYPE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisEmailSettings WHERE ");

				if (emailType == null) {
					query.append("email_type Like null");
				}
				else {
					query.append("email_type Like ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("email_type ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (emailType != null) {
					qPos.add(emailType);
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisEmailSettings>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_EMAILTYPE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisEmailSettings> findByEmailType(String emailType, int start,
		int end) throws SystemException {
		return findByEmailType(emailType, start, end, null);
	}

	public List<LmisEmailSettings> findByEmailType(String emailType, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				emailType,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisEmailSettings> list = (List<LmisEmailSettings>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_EMAILTYPE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisEmailSettings WHERE ");

				if (emailType == null) {
					query.append("email_type Like null");
				}
				else {
					query.append("email_type Like ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("email_type ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (emailType != null) {
					qPos.add(emailType);
				}

				list = (List<LmisEmailSettings>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisEmailSettings>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_EMAILTYPE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisEmailSettings findByEmailType_First(String emailType,
		OrderByComparator obc)
		throws NoSuchLmisEmailSettingsException, SystemException {
		List<LmisEmailSettings> list = findByEmailType(emailType, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisEmailSettings exists with the key {");

			msg.append("emailType=" + emailType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisEmailSettingsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisEmailSettings findByEmailType_Last(String emailType,
		OrderByComparator obc)
		throws NoSuchLmisEmailSettingsException, SystemException {
		int count = countByEmailType(emailType);

		List<LmisEmailSettings> list = findByEmailType(emailType, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisEmailSettings exists with the key {");

			msg.append("emailType=" + emailType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisEmailSettingsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisEmailSettings[] findByEmailType_PrevAndNext(
		Integer lmisEmailSettingId, String emailType, OrderByComparator obc)
		throws NoSuchLmisEmailSettingsException, SystemException {
		LmisEmailSettings lmisEmailSettings = findByPrimaryKey(lmisEmailSettingId);

		int count = countByEmailType(emailType);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisEmailSettings WHERE ");

			if (emailType == null) {
				query.append("email_type Like null");
			}
			else {
				query.append("email_type Like ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("email_type ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (emailType != null) {
				qPos.add(emailType);
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisEmailSettings);

			LmisEmailSettings[] array = new LmisEmailSettingsImpl[3];

			array[0] = (LmisEmailSettings)objArray[0];
			array[1] = (LmisEmailSettings)objArray[1];
			array[2] = (LmisEmailSettings)objArray[2];

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

	public List<LmisEmailSettings> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<LmisEmailSettings> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<LmisEmailSettings> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisEmailSettings> list = (List<LmisEmailSettings>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisEmailSettings ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("email_type ASC");
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<LmisEmailSettings>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LmisEmailSettings>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisEmailSettings>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByEmailSettingOf(int rootId) throws SystemException {
		for (LmisEmailSettings lmisEmailSettings : findByEmailSettingOf(rootId)) {
			remove(lmisEmailSettings);
		}
	}

	public void removeByCategoryId(int category) throws SystemException {
		for (LmisEmailSettings lmisEmailSettings : findByCategoryId(category)) {
			remove(lmisEmailSettings);
		}
	}

	public void removeByEmailType(String emailType) throws SystemException {
		for (LmisEmailSettings lmisEmailSettings : findByEmailType(emailType)) {
			remove(lmisEmailSettings);
		}
	}

	public void removeAll() throws SystemException {
		for (LmisEmailSettings lmisEmailSettings : findAll()) {
			remove(lmisEmailSettings);
		}
	}

	public int countByEmailSettingOf(int rootId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_EMAILSETTINGOF,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisEmailSettings WHERE ");

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMAILSETTINGOF,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByCategoryId(int category) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(category) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CATEGORYID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisEmailSettings WHERE ");

				query.append("category = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(category);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CATEGORYID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByEmailType(String emailType) throws SystemException {
		Object[] finderArgs = new Object[] { emailType };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_EMAILTYPE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisEmailSettings WHERE ");

				if (emailType == null) {
					query.append("email_type Like null");
				}
				else {
					query.append("email_type Like ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (emailType != null) {
					qPos.add(emailType);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMAILTYPE,
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
						"SELECT COUNT(*) FROM larion.progate.lmis.model.LmisEmailSettings");

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

	public List<larion.progate.lmis.model.LmisEmailSettingDetails> getLmisEmailSettingDetailses(
		Integer pk) throws SystemException {
		return getLmisEmailSettingDetailses(pk, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS);
	}

	public List<larion.progate.lmis.model.LmisEmailSettingDetails> getLmisEmailSettingDetailses(
		Integer pk, int start, int end) throws SystemException {
		return getLmisEmailSettingDetailses(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_LMISEMAILSETTINGDETAILSES = new FinderPath(larion.progate.lmis.model.impl.LmisEmailSettingDetailsModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.lmis.model.impl.LmisEmailSettingDetailsModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.lmis.service.persistence.LmisEmailSettingDetailsPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getLmisEmailSettingDetailses",
			new String[] {
				Integer.class.getName(), "java.lang.Integer",
				"java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	public List<larion.progate.lmis.model.LmisEmailSettingDetails> getLmisEmailSettingDetailses(
		Integer pk, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				pk, String.valueOf(start), String.valueOf(end),
				String.valueOf(obc)
			};

		List<larion.progate.lmis.model.LmisEmailSettingDetails> list = (List<larion.progate.lmis.model.LmisEmailSettingDetails>)FinderCacheUtil.getResult(FINDER_PATH_GET_LMISEMAILSETTINGDETAILSES,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder sb = new StringBuilder();

				sb.append(_SQL_GETLMISEMAILSETTINGDETAILSES);

				if (obc != null) {
					sb.append("ORDER BY ");
					sb.append(obc.getOrderBy());
				}

				String sql = sb.toString();

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("lmis_email_setting_details",
					larion.progate.lmis.model.impl.LmisEmailSettingDetailsImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<larion.progate.lmis.model.LmisEmailSettingDetails>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<larion.progate.lmis.model.LmisEmailSettingDetails>();
				}

				lmisEmailSettingDetailsPersistence.cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_GET_LMISEMAILSETTINGDETAILSES,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_LMISEMAILSETTINGDETAILSES_SIZE =
		new FinderPath(larion.progate.lmis.model.impl.LmisEmailSettingDetailsModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.lmis.model.impl.LmisEmailSettingDetailsModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.lmis.service.persistence.LmisEmailSettingDetailsPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getLmisEmailSettingDetailsesSize",
			new String[] { Integer.class.getName() });

	public int getLmisEmailSettingDetailsesSize(Integer pk)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_LMISEMAILSETTINGDETAILSES_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETLMISEMAILSETTINGDETAILSESSIZE);

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

				FinderCacheUtil.putResult(FINDER_PATH_GET_LMISEMAILSETTINGDETAILSES_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_LMISEMAILSETTINGDETAILS = new FinderPath(larion.progate.lmis.model.impl.LmisEmailSettingDetailsModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.lmis.model.impl.LmisEmailSettingDetailsModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.lmis.service.persistence.LmisEmailSettingDetailsPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"containsLmisEmailSettingDetails",
			new String[] { Integer.class.getName(), Integer.class.getName() });

	public boolean containsLmisEmailSettingDetails(Integer pk,
		Integer lmisEmailSettingDetailsPK) throws SystemException {
		Object[] finderArgs = new Object[] { pk, lmisEmailSettingDetailsPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_LMISEMAILSETTINGDETAILS,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsLmisEmailSettingDetails.contains(
							pk, lmisEmailSettingDetailsPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_LMISEMAILSETTINGDETAILS,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	public boolean containsLmisEmailSettingDetailses(Integer pk)
		throws SystemException {
		if (getLmisEmailSettingDetailsesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.larion.progate.lmis.model.LmisEmailSettings")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LmisEmailSettings>> listenersList = new ArrayList<ModelListener<LmisEmailSettings>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LmisEmailSettings>)Class.forName(
							listenerClassName).newInstance());
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		containsLmisEmailSettingDetails = new ContainsLmisEmailSettingDetails(this);
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
	protected ContainsLmisEmailSettingDetails containsLmisEmailSettingDetails;

	protected class ContainsLmisEmailSettingDetails {
		protected ContainsLmisEmailSettingDetails(
			LmisEmailSettingsPersistenceImpl persistenceImpl) {
			super();

			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSLMISEMAILSETTINGDETAILS,
					new int[] { Types.INTEGER, Types.INTEGER }, RowMapper.COUNT);
		}

		protected boolean contains(Integer lmisEmailSettingId,
			Integer lmisEmailSettingDetailId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						lmisEmailSettingId, lmisEmailSettingDetailId
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

	private static final String _SQL_GETLMISEMAILSETTINGDETAILSES = "SELECT {lmis_email_setting_details.*} FROM lmis_email_setting_details INNER JOIN lmis_email_settings ON (lmis_email_settings.lmisEmailSettingId = lmis_email_setting_details.lmisEmailSettingId) WHERE (lmis_email_settings.lmisEmailSettingId = ?)";
	private static final String _SQL_GETLMISEMAILSETTINGDETAILSESSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM lmis_email_setting_details WHERE lmisEmailSettingId = ?";
	private static final String _SQL_CONTAINSLMISEMAILSETTINGDETAILS = "SELECT COUNT(*) AS COUNT_VALUE FROM lmis_email_setting_details WHERE lmisEmailSettingId = ? AND lmisEmailSettingDetailId = ?";
	private static Log _log = LogFactoryUtil.getLog(LmisEmailSettingsPersistenceImpl.class);
}