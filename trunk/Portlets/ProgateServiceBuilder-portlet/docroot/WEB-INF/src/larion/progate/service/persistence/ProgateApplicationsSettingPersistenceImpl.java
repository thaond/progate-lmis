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

package larion.progate.service.persistence;

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

import larion.progate.NoSuchProgateApplicationsSettingException;

import larion.progate.model.ProgateApplicationsSetting;
import larion.progate.model.impl.ProgateApplicationsSettingImpl;
import larion.progate.model.impl.ProgateApplicationsSettingModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="ProgateApplicationsSettingPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProgateApplicationsSettingPersistenceImpl
	extends BasePersistenceImpl implements ProgateApplicationsSettingPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = ProgateApplicationsSettingImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_APPID = new FinderPath(ProgateApplicationsSettingModelImpl.ENTITY_CACHE_ENABLED,
			ProgateApplicationsSettingModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByappId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_APPID = new FinderPath(ProgateApplicationsSettingModelImpl.ENTITY_CACHE_ENABLED,
			ProgateApplicationsSettingModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByappId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_APPID = new FinderPath(ProgateApplicationsSettingModelImpl.ENTITY_CACHE_ENABLED,
			ProgateApplicationsSettingModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByappId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ROLEID = new FinderPath(ProgateApplicationsSettingModelImpl.ENTITY_CACHE_ENABLED,
			ProgateApplicationsSettingModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByroleId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ROLEID = new FinderPath(ProgateApplicationsSettingModelImpl.ENTITY_CACHE_ENABLED,
			ProgateApplicationsSettingModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByroleId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ROLEID = new FinderPath(ProgateApplicationsSettingModelImpl.ENTITY_CACHE_ENABLED,
			ProgateApplicationsSettingModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByroleId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(ProgateApplicationsSettingModelImpl.ENTITY_CACHE_ENABLED,
			ProgateApplicationsSettingModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProgateApplicationsSettingModelImpl.ENTITY_CACHE_ENABLED,
			ProgateApplicationsSettingModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(
		ProgateApplicationsSetting progateApplicationsSetting) {
		EntityCacheUtil.putResult(ProgateApplicationsSettingModelImpl.ENTITY_CACHE_ENABLED,
			ProgateApplicationsSettingImpl.class,
			progateApplicationsSetting.getPrimaryKey(),
			progateApplicationsSetting);
	}

	public void cacheResult(
		List<ProgateApplicationsSetting> progateApplicationsSettings) {
		for (ProgateApplicationsSetting progateApplicationsSetting : progateApplicationsSettings) {
			if (EntityCacheUtil.getResult(
						ProgateApplicationsSettingModelImpl.ENTITY_CACHE_ENABLED,
						ProgateApplicationsSettingImpl.class,
						progateApplicationsSetting.getPrimaryKey(), this) == null) {
				cacheResult(progateApplicationsSetting);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(ProgateApplicationsSettingImpl.class.getName());
		EntityCacheUtil.clearCache(ProgateApplicationsSettingImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public ProgateApplicationsSetting create(
		Integer ProgateApplicationsSettingId) {
		ProgateApplicationsSetting progateApplicationsSetting = new ProgateApplicationsSettingImpl();

		progateApplicationsSetting.setNew(true);
		progateApplicationsSetting.setPrimaryKey(ProgateApplicationsSettingId);

		return progateApplicationsSetting;
	}

	public ProgateApplicationsSetting remove(
		Integer ProgateApplicationsSettingId)
		throws NoSuchProgateApplicationsSettingException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ProgateApplicationsSetting progateApplicationsSetting = (ProgateApplicationsSetting)session.get(ProgateApplicationsSettingImpl.class,
					ProgateApplicationsSettingId);

			if (progateApplicationsSetting == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No ProgateApplicationsSetting exists with the primary key " +
						ProgateApplicationsSettingId);
				}

				throw new NoSuchProgateApplicationsSettingException(
					"No ProgateApplicationsSetting exists with the primary key " +
					ProgateApplicationsSettingId);
			}

			return remove(progateApplicationsSetting);
		}
		catch (NoSuchProgateApplicationsSettingException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public ProgateApplicationsSetting remove(
		ProgateApplicationsSetting progateApplicationsSetting)
		throws SystemException {
		for (ModelListener<ProgateApplicationsSetting> listener : listeners) {
			listener.onBeforeRemove(progateApplicationsSetting);
		}

		progateApplicationsSetting = removeImpl(progateApplicationsSetting);

		for (ModelListener<ProgateApplicationsSetting> listener : listeners) {
			listener.onAfterRemove(progateApplicationsSetting);
		}

		return progateApplicationsSetting;
	}

	protected ProgateApplicationsSetting removeImpl(
		ProgateApplicationsSetting progateApplicationsSetting)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (progateApplicationsSetting.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(ProgateApplicationsSettingImpl.class,
						progateApplicationsSetting.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(progateApplicationsSetting);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(ProgateApplicationsSettingModelImpl.ENTITY_CACHE_ENABLED,
			ProgateApplicationsSettingImpl.class,
			progateApplicationsSetting.getPrimaryKey());

		return progateApplicationsSetting;
	}

	public ProgateApplicationsSetting update(
		ProgateApplicationsSetting progateApplicationsSetting)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(ProgateApplicationsSetting progateApplicationsSetting) method. Use update(ProgateApplicationsSetting progateApplicationsSetting, boolean merge) instead.");
		}

		return update(progateApplicationsSetting, false);
	}

	public ProgateApplicationsSetting update(
		ProgateApplicationsSetting progateApplicationsSetting, boolean merge)
		throws SystemException {
		boolean isNew = progateApplicationsSetting.isNew();

		for (ModelListener<ProgateApplicationsSetting> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(progateApplicationsSetting);
			}
			else {
				listener.onBeforeUpdate(progateApplicationsSetting);
			}
		}

		progateApplicationsSetting = updateImpl(progateApplicationsSetting,
				merge);

		for (ModelListener<ProgateApplicationsSetting> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(progateApplicationsSetting);
			}
			else {
				listener.onAfterUpdate(progateApplicationsSetting);
			}
		}

		return progateApplicationsSetting;
	}

	public ProgateApplicationsSetting updateImpl(
		larion.progate.model.ProgateApplicationsSetting progateApplicationsSetting,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, progateApplicationsSetting, merge);

			progateApplicationsSetting.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(ProgateApplicationsSettingModelImpl.ENTITY_CACHE_ENABLED,
			ProgateApplicationsSettingImpl.class,
			progateApplicationsSetting.getPrimaryKey(),
			progateApplicationsSetting);

		return progateApplicationsSetting;
	}

	public ProgateApplicationsSetting findByPrimaryKey(
		Integer ProgateApplicationsSettingId)
		throws NoSuchProgateApplicationsSettingException, SystemException {
		ProgateApplicationsSetting progateApplicationsSetting = fetchByPrimaryKey(ProgateApplicationsSettingId);

		if (progateApplicationsSetting == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"No ProgateApplicationsSetting exists with the primary key " +
					ProgateApplicationsSettingId);
			}

			throw new NoSuchProgateApplicationsSettingException(
				"No ProgateApplicationsSetting exists with the primary key " +
				ProgateApplicationsSettingId);
		}

		return progateApplicationsSetting;
	}

	public ProgateApplicationsSetting fetchByPrimaryKey(
		Integer ProgateApplicationsSettingId) throws SystemException {
		ProgateApplicationsSetting progateApplicationsSetting = (ProgateApplicationsSetting)EntityCacheUtil.getResult(ProgateApplicationsSettingModelImpl.ENTITY_CACHE_ENABLED,
				ProgateApplicationsSettingImpl.class,
				ProgateApplicationsSettingId, this);

		if (progateApplicationsSetting == null) {
			Session session = null;

			try {
				session = openSession();

				progateApplicationsSetting = (ProgateApplicationsSetting)session.get(ProgateApplicationsSettingImpl.class,
						ProgateApplicationsSettingId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (progateApplicationsSetting != null) {
					cacheResult(progateApplicationsSetting);
				}

				closeSession(session);
			}
		}

		return progateApplicationsSetting;
	}

	public List<ProgateApplicationsSetting> findByappId(int appId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(appId) };

		List<ProgateApplicationsSetting> list = (List<ProgateApplicationsSetting>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_APPID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProgateApplicationsSetting WHERE ");

				query.append("app_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("role_id DESC, ");
				query.append("app_id DESC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(appId);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProgateApplicationsSetting>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_APPID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProgateApplicationsSetting> findByappId(int appId, int start,
		int end) throws SystemException {
		return findByappId(appId, start, end, null);
	}

	public List<ProgateApplicationsSetting> findByappId(int appId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(appId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProgateApplicationsSetting> list = (List<ProgateApplicationsSetting>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_APPID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProgateApplicationsSetting WHERE ");

				query.append("app_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("role_id DESC, ");
					query.append("app_id DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(appId);

				list = (List<ProgateApplicationsSetting>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProgateApplicationsSetting>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_APPID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProgateApplicationsSetting findByappId_First(int appId,
		OrderByComparator obc)
		throws NoSuchProgateApplicationsSettingException, SystemException {
		List<ProgateApplicationsSetting> list = findByappId(appId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProgateApplicationsSetting exists with the key {");

			msg.append("appId=" + appId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProgateApplicationsSettingException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProgateApplicationsSetting findByappId_Last(int appId,
		OrderByComparator obc)
		throws NoSuchProgateApplicationsSettingException, SystemException {
		int count = countByappId(appId);

		List<ProgateApplicationsSetting> list = findByappId(appId, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProgateApplicationsSetting exists with the key {");

			msg.append("appId=" + appId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProgateApplicationsSettingException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProgateApplicationsSetting[] findByappId_PrevAndNext(
		Integer ProgateApplicationsSettingId, int appId, OrderByComparator obc)
		throws NoSuchProgateApplicationsSettingException, SystemException {
		ProgateApplicationsSetting progateApplicationsSetting = findByPrimaryKey(ProgateApplicationsSettingId);

		int count = countByappId(appId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProgateApplicationsSetting WHERE ");

			query.append("app_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("role_id DESC, ");
				query.append("app_id DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(appId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					progateApplicationsSetting);

			ProgateApplicationsSetting[] array = new ProgateApplicationsSettingImpl[3];

			array[0] = (ProgateApplicationsSetting)objArray[0];
			array[1] = (ProgateApplicationsSetting)objArray[1];
			array[2] = (ProgateApplicationsSetting)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProgateApplicationsSetting> findByroleId(int roleId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(roleId) };

		List<ProgateApplicationsSetting> list = (List<ProgateApplicationsSetting>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ROLEID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProgateApplicationsSetting WHERE ");

				query.append("role_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("role_id DESC, ");
				query.append("app_id DESC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(roleId);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProgateApplicationsSetting>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ROLEID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProgateApplicationsSetting> findByroleId(int roleId, int start,
		int end) throws SystemException {
		return findByroleId(roleId, start, end, null);
	}

	public List<ProgateApplicationsSetting> findByroleId(int roleId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(roleId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProgateApplicationsSetting> list = (List<ProgateApplicationsSetting>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ROLEID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProgateApplicationsSetting WHERE ");

				query.append("role_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("role_id DESC, ");
					query.append("app_id DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(roleId);

				list = (List<ProgateApplicationsSetting>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProgateApplicationsSetting>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ROLEID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProgateApplicationsSetting findByroleId_First(int roleId,
		OrderByComparator obc)
		throws NoSuchProgateApplicationsSettingException, SystemException {
		List<ProgateApplicationsSetting> list = findByroleId(roleId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProgateApplicationsSetting exists with the key {");

			msg.append("roleId=" + roleId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProgateApplicationsSettingException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProgateApplicationsSetting findByroleId_Last(int roleId,
		OrderByComparator obc)
		throws NoSuchProgateApplicationsSettingException, SystemException {
		int count = countByroleId(roleId);

		List<ProgateApplicationsSetting> list = findByroleId(roleId, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProgateApplicationsSetting exists with the key {");

			msg.append("roleId=" + roleId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProgateApplicationsSettingException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProgateApplicationsSetting[] findByroleId_PrevAndNext(
		Integer ProgateApplicationsSettingId, int roleId, OrderByComparator obc)
		throws NoSuchProgateApplicationsSettingException, SystemException {
		ProgateApplicationsSetting progateApplicationsSetting = findByPrimaryKey(ProgateApplicationsSettingId);

		int count = countByroleId(roleId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProgateApplicationsSetting WHERE ");

			query.append("role_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("role_id DESC, ");
				query.append("app_id DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(roleId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					progateApplicationsSetting);

			ProgateApplicationsSetting[] array = new ProgateApplicationsSettingImpl[3];

			array[0] = (ProgateApplicationsSetting)objArray[0];
			array[1] = (ProgateApplicationsSetting)objArray[1];
			array[2] = (ProgateApplicationsSetting)objArray[2];

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

	public List<ProgateApplicationsSetting> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<ProgateApplicationsSetting> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<ProgateApplicationsSetting> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProgateApplicationsSetting> list = (List<ProgateApplicationsSetting>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProgateApplicationsSetting ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("role_id DESC, ");
					query.append("app_id DESC");
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<ProgateApplicationsSetting>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ProgateApplicationsSetting>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProgateApplicationsSetting>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByappId(int appId) throws SystemException {
		for (ProgateApplicationsSetting progateApplicationsSetting : findByappId(
				appId)) {
			remove(progateApplicationsSetting);
		}
	}

	public void removeByroleId(int roleId) throws SystemException {
		for (ProgateApplicationsSetting progateApplicationsSetting : findByroleId(
				roleId)) {
			remove(progateApplicationsSetting);
		}
	}

	public void removeAll() throws SystemException {
		for (ProgateApplicationsSetting progateApplicationsSetting : findAll()) {
			remove(progateApplicationsSetting);
		}
	}

	public int countByappId(int appId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(appId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_APPID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProgateApplicationsSetting WHERE ");

				query.append("app_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(appId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_APPID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByroleId(int roleId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(roleId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ROLEID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProgateApplicationsSetting WHERE ");

				query.append("role_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(roleId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ROLEID,
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
						"SELECT COUNT(*) FROM larion.progate.model.ProgateApplicationsSetting");

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
						"value.object.listener.larion.progate.model.ProgateApplicationsSetting")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ProgateApplicationsSetting>> listenersList = new ArrayList<ModelListener<ProgateApplicationsSetting>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ProgateApplicationsSetting>)Class.forName(
							listenerClassName).newInstance());
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	@BeanReference(name = "larion.progate.service.persistence.UserPersistence.impl")
	protected larion.progate.service.persistence.UserPersistence userPersistence;
	@BeanReference(name = "larion.progate.service.persistence.UserInformationViewPersistence.impl")
	protected larion.progate.service.persistence.UserInformationViewPersistence userInformationViewPersistence;
	@BeanReference(name = "larion.progate.service.persistence.OrganizationPersistence.impl")
	protected larion.progate.service.persistence.OrganizationPersistence organizationPersistence;
	@BeanReference(name = "larion.progate.service.persistence.OrganizationViewPersistence.impl")
	protected larion.progate.service.persistence.OrganizationViewPersistence organizationViewPersistence;
	@BeanReference(name = "larion.progate.service.persistence.OrgObjectListPersistence.impl")
	protected larion.progate.service.persistence.OrgObjectListPersistence orgObjectListPersistence;
	@BeanReference(name = "larion.progate.service.persistence.OrgObjectApprovalPersistence.impl")
	protected larion.progate.service.persistence.OrgObjectApprovalPersistence orgObjectApprovalPersistence;
	@BeanReference(name = "larion.progate.service.persistence.OrgObjectPerspectivePersistence.impl")
	protected larion.progate.service.persistence.OrgObjectPerspectivePersistence orgObjectPerspectivePersistence;
	@BeanReference(name = "larion.progate.service.persistence.OrgObjectObjectivePersistence.impl")
	protected larion.progate.service.persistence.OrgObjectObjectivePersistence orgObjectObjectivePersistence;
	@BeanReference(name = "larion.progate.service.persistence.OrgObjectMeasurePersistence.impl")
	protected larion.progate.service.persistence.OrgObjectMeasurePersistence orgObjectMeasurePersistence;
	@BeanReference(name = "larion.progate.service.persistence.OrgObjectTargetsPersistence.impl")
	protected larion.progate.service.persistence.OrgObjectTargetsPersistence orgObjectTargetsPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProgatePortalMenuPersistence.impl")
	protected larion.progate.service.persistence.ProgatePortalMenuPersistence progatePortalMenuPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProGateRolesPersistence.impl")
	protected larion.progate.service.persistence.ProGateRolesPersistence proGateRolesPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProGateOrgTypePersistence.impl")
	protected larion.progate.service.persistence.ProGateOrgTypePersistence proGateOrgTypePersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProGateJournalArticlePersistence.impl")
	protected larion.progate.service.persistence.ProGateJournalArticlePersistence proGateJournalArticlePersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProGateProductsServicesPersistence.impl")
	protected larion.progate.service.persistence.ProGateProductsServicesPersistence proGateProductsServicesPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProGateCurrencyTypesPersistence.impl")
	protected larion.progate.service.persistence.ProGateCurrencyTypesPersistence proGateCurrencyTypesPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProGateJournalArticlePrioritiesPersistence.impl")
	protected larion.progate.service.persistence.ProGateJournalArticlePrioritiesPersistence proGateJournalArticlePrioritiesPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProGateJournalArticleTypesPersistence.impl")
	protected larion.progate.service.persistence.ProGateJournalArticleTypesPersistence proGateJournalArticleTypesPersistence;
	@BeanReference(name = "larion.progate.service.persistence.RegionPersistence.impl")
	protected larion.progate.service.persistence.RegionPersistence regionPersistence;
	@BeanReference(name = "larion.progate.service.persistence.CountryPersistence.impl")
	protected larion.progate.service.persistence.CountryPersistence countryPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProGateJournalArticleViewPersistence.impl")
	protected larion.progate.service.persistence.ProGateJournalArticleViewPersistence proGateJournalArticleViewPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProGateJournalArticleSlideShowPersistence.impl")
	protected larion.progate.service.persistence.ProGateJournalArticleSlideShowPersistence proGateJournalArticleSlideShowPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProGateOrgCustomerPersistence.impl")
	protected larion.progate.service.persistence.ProGateOrgCustomerPersistence proGateOrgCustomerPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProGateOrgCustomerRepresenterPersistence.impl")
	protected larion.progate.service.persistence.ProGateOrgCustomerRepresenterPersistence proGateOrgCustomerRepresenterPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProGateApplicationsPersistence.impl")
	protected larion.progate.service.persistence.ProGateApplicationsPersistence proGateApplicationsPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProGateUserApplicationsPersistence.impl")
	protected larion.progate.service.persistence.ProGateUserApplicationsPersistence proGateUserApplicationsPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProgateOrganizationParticipantsPersistence.impl")
	protected larion.progate.service.persistence.ProgateOrganizationParticipantsPersistence progateOrganizationParticipantsPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProgateOrganizationsStaffsPersistence.impl")
	protected larion.progate.service.persistence.ProgateOrganizationsStaffsPersistence progateOrganizationsStaffsPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProgateApplicationsSettingPersistence.impl")
	protected larion.progate.service.persistence.ProgateApplicationsSettingPersistence progateApplicationsSettingPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProgateMenusPersistence.impl")
	protected larion.progate.service.persistence.ProgateMenusPersistence progateMenusPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProgateLayoutsRolesPersistence.impl")
	protected larion.progate.service.persistence.ProgateLayoutsRolesPersistence progateLayoutsRolesPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProgateLayoutsMenusPersistence.impl")
	protected larion.progate.service.persistence.ProgateLayoutsMenusPersistence progateLayoutsMenusPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProGateMenuViewPersistence.impl")
	protected larion.progate.service.persistence.ProGateMenuViewPersistence proGateMenuViewPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProGateOrgsUsersPermissionsPersistence.impl")
	protected larion.progate.service.persistence.ProGateOrgsUsersPermissionsPersistence proGateOrgsUsersPermissionsPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProGatePermissionsPersistence.impl")
	protected larion.progate.service.persistence.ProGatePermissionsPersistence proGatePermissionsPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ViewOrgUsersPermissionsPersistence.impl")
	protected larion.progate.service.persistence.ViewOrgUsersPermissionsPersistence viewOrgUsersPermissionsPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ViewProGatePermissionsRolesPersistence.impl")
	protected larion.progate.service.persistence.ViewProGatePermissionsRolesPersistence viewProGatePermissionsRolesPersistence;
	private static Log _log = LogFactoryUtil.getLog(ProgateApplicationsSettingPersistenceImpl.class);
}