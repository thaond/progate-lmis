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

import larion.progate.NoSuchViewOrgUsersPermissionsException;

import larion.progate.model.ViewOrgUsersPermissions;
import larion.progate.model.impl.ViewOrgUsersPermissionsImpl;
import larion.progate.model.impl.ViewOrgUsersPermissionsModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="ViewOrgUsersPermissionsPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ViewOrgUsersPermissionsPersistenceImpl extends BasePersistenceImpl
	implements ViewOrgUsersPermissionsPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = ViewOrgUsersPermissionsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_USERID = new FinderPath(ViewOrgUsersPermissionsModelImpl.ENTITY_CACHE_ENABLED,
			ViewOrgUsersPermissionsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByUserId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_USERID = new FinderPath(ViewOrgUsersPermissionsModelImpl.ENTITY_CACHE_ENABLED,
			ViewOrgUsersPermissionsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByUserId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(ViewOrgUsersPermissionsModelImpl.ENTITY_CACHE_ENABLED,
			ViewOrgUsersPermissionsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByUserId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ROOTID = new FinderPath(ViewOrgUsersPermissionsModelImpl.ENTITY_CACHE_ENABLED,
			ViewOrgUsersPermissionsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ROOTID = new FinderPath(ViewOrgUsersPermissionsModelImpl.ENTITY_CACHE_ENABLED,
			ViewOrgUsersPermissionsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ROOTID = new FinderPath(ViewOrgUsersPermissionsModelImpl.ENTITY_CACHE_ENABLED,
			ViewOrgUsersPermissionsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByRootId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(ViewOrgUsersPermissionsModelImpl.ENTITY_CACHE_ENABLED,
			ViewOrgUsersPermissionsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ViewOrgUsersPermissionsModelImpl.ENTITY_CACHE_ENABLED,
			ViewOrgUsersPermissionsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(ViewOrgUsersPermissions viewOrgUsersPermissions) {
		EntityCacheUtil.putResult(ViewOrgUsersPermissionsModelImpl.ENTITY_CACHE_ENABLED,
			ViewOrgUsersPermissionsImpl.class,
			viewOrgUsersPermissions.getPrimaryKey(), viewOrgUsersPermissions);
	}

	public void cacheResult(
		List<ViewOrgUsersPermissions> viewOrgUsersPermissionses) {
		for (ViewOrgUsersPermissions viewOrgUsersPermissions : viewOrgUsersPermissionses) {
			if (EntityCacheUtil.getResult(
						ViewOrgUsersPermissionsModelImpl.ENTITY_CACHE_ENABLED,
						ViewOrgUsersPermissionsImpl.class,
						viewOrgUsersPermissions.getPrimaryKey(), this) == null) {
				cacheResult(viewOrgUsersPermissions);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(ViewOrgUsersPermissionsImpl.class.getName());
		EntityCacheUtil.clearCache(ViewOrgUsersPermissionsImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public ViewOrgUsersPermissions create(String id) {
		ViewOrgUsersPermissions viewOrgUsersPermissions = new ViewOrgUsersPermissionsImpl();

		viewOrgUsersPermissions.setNew(true);
		viewOrgUsersPermissions.setPrimaryKey(id);

		return viewOrgUsersPermissions;
	}

	public ViewOrgUsersPermissions remove(String id)
		throws NoSuchViewOrgUsersPermissionsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ViewOrgUsersPermissions viewOrgUsersPermissions = (ViewOrgUsersPermissions)session.get(ViewOrgUsersPermissionsImpl.class,
					id);

			if (viewOrgUsersPermissions == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No ViewOrgUsersPermissions exists with the primary key " +
						id);
				}

				throw new NoSuchViewOrgUsersPermissionsException(
					"No ViewOrgUsersPermissions exists with the primary key " +
					id);
			}

			return remove(viewOrgUsersPermissions);
		}
		catch (NoSuchViewOrgUsersPermissionsException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public ViewOrgUsersPermissions remove(
		ViewOrgUsersPermissions viewOrgUsersPermissions)
		throws SystemException {
		for (ModelListener<ViewOrgUsersPermissions> listener : listeners) {
			listener.onBeforeRemove(viewOrgUsersPermissions);
		}

		viewOrgUsersPermissions = removeImpl(viewOrgUsersPermissions);

		for (ModelListener<ViewOrgUsersPermissions> listener : listeners) {
			listener.onAfterRemove(viewOrgUsersPermissions);
		}

		return viewOrgUsersPermissions;
	}

	protected ViewOrgUsersPermissions removeImpl(
		ViewOrgUsersPermissions viewOrgUsersPermissions)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (viewOrgUsersPermissions.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(ViewOrgUsersPermissionsImpl.class,
						viewOrgUsersPermissions.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(viewOrgUsersPermissions);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(ViewOrgUsersPermissionsModelImpl.ENTITY_CACHE_ENABLED,
			ViewOrgUsersPermissionsImpl.class,
			viewOrgUsersPermissions.getPrimaryKey());

		return viewOrgUsersPermissions;
	}

	public ViewOrgUsersPermissions update(
		ViewOrgUsersPermissions viewOrgUsersPermissions)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(ViewOrgUsersPermissions viewOrgUsersPermissions) method. Use update(ViewOrgUsersPermissions viewOrgUsersPermissions, boolean merge) instead.");
		}

		return update(viewOrgUsersPermissions, false);
	}

	public ViewOrgUsersPermissions update(
		ViewOrgUsersPermissions viewOrgUsersPermissions, boolean merge)
		throws SystemException {
		boolean isNew = viewOrgUsersPermissions.isNew();

		for (ModelListener<ViewOrgUsersPermissions> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(viewOrgUsersPermissions);
			}
			else {
				listener.onBeforeUpdate(viewOrgUsersPermissions);
			}
		}

		viewOrgUsersPermissions = updateImpl(viewOrgUsersPermissions, merge);

		for (ModelListener<ViewOrgUsersPermissions> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(viewOrgUsersPermissions);
			}
			else {
				listener.onAfterUpdate(viewOrgUsersPermissions);
			}
		}

		return viewOrgUsersPermissions;
	}

	public ViewOrgUsersPermissions updateImpl(
		larion.progate.model.ViewOrgUsersPermissions viewOrgUsersPermissions,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, viewOrgUsersPermissions, merge);

			viewOrgUsersPermissions.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(ViewOrgUsersPermissionsModelImpl.ENTITY_CACHE_ENABLED,
			ViewOrgUsersPermissionsImpl.class,
			viewOrgUsersPermissions.getPrimaryKey(), viewOrgUsersPermissions);

		return viewOrgUsersPermissions;
	}

	public ViewOrgUsersPermissions findByPrimaryKey(String id)
		throws NoSuchViewOrgUsersPermissionsException, SystemException {
		ViewOrgUsersPermissions viewOrgUsersPermissions = fetchByPrimaryKey(id);

		if (viewOrgUsersPermissions == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"No ViewOrgUsersPermissions exists with the primary key " +
					id);
			}

			throw new NoSuchViewOrgUsersPermissionsException(
				"No ViewOrgUsersPermissions exists with the primary key " + id);
		}

		return viewOrgUsersPermissions;
	}

	public ViewOrgUsersPermissions fetchByPrimaryKey(String id)
		throws SystemException {
		ViewOrgUsersPermissions viewOrgUsersPermissions = (ViewOrgUsersPermissions)EntityCacheUtil.getResult(ViewOrgUsersPermissionsModelImpl.ENTITY_CACHE_ENABLED,
				ViewOrgUsersPermissionsImpl.class, id, this);

		if (viewOrgUsersPermissions == null) {
			Session session = null;

			try {
				session = openSession();

				viewOrgUsersPermissions = (ViewOrgUsersPermissions)session.get(ViewOrgUsersPermissionsImpl.class,
						id);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (viewOrgUsersPermissions != null) {
					cacheResult(viewOrgUsersPermissions);
				}

				closeSession(session);
			}
		}

		return viewOrgUsersPermissions;
	}

	public List<ViewOrgUsersPermissions> findByUserId(int userId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(userId) };

		List<ViewOrgUsersPermissions> list = (List<ViewOrgUsersPermissions>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_USERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ViewOrgUsersPermissions WHERE ");

				query.append("user_id = ?");

				query.append(" ");

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
					list = new ArrayList<ViewOrgUsersPermissions>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_USERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ViewOrgUsersPermissions> findByUserId(int userId, int start,
		int end) throws SystemException {
		return findByUserId(userId, start, end, null);
	}

	public List<ViewOrgUsersPermissions> findByUserId(int userId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(userId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ViewOrgUsersPermissions> list = (List<ViewOrgUsersPermissions>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_USERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ViewOrgUsersPermissions WHERE ");

				query.append("user_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				list = (List<ViewOrgUsersPermissions>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ViewOrgUsersPermissions>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_USERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ViewOrgUsersPermissions findByUserId_First(int userId,
		OrderByComparator obc)
		throws NoSuchViewOrgUsersPermissionsException, SystemException {
		List<ViewOrgUsersPermissions> list = findByUserId(userId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ViewOrgUsersPermissions exists with the key {");

			msg.append("userId=" + userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchViewOrgUsersPermissionsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ViewOrgUsersPermissions findByUserId_Last(int userId,
		OrderByComparator obc)
		throws NoSuchViewOrgUsersPermissionsException, SystemException {
		int count = countByUserId(userId);

		List<ViewOrgUsersPermissions> list = findByUserId(userId, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ViewOrgUsersPermissions exists with the key {");

			msg.append("userId=" + userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchViewOrgUsersPermissionsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ViewOrgUsersPermissions[] findByUserId_PrevAndNext(String id,
		int userId, OrderByComparator obc)
		throws NoSuchViewOrgUsersPermissionsException, SystemException {
		ViewOrgUsersPermissions viewOrgUsersPermissions = findByPrimaryKey(id);

		int count = countByUserId(userId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ViewOrgUsersPermissions WHERE ");

			query.append("user_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(userId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					viewOrgUsersPermissions);

			ViewOrgUsersPermissions[] array = new ViewOrgUsersPermissionsImpl[3];

			array[0] = (ViewOrgUsersPermissions)objArray[0];
			array[1] = (ViewOrgUsersPermissions)objArray[1];
			array[2] = (ViewOrgUsersPermissions)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ViewOrgUsersPermissions> findByRootId(int rootId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		List<ViewOrgUsersPermissions> list = (List<ViewOrgUsersPermissions>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ViewOrgUsersPermissions WHERE ");

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
					list = new ArrayList<ViewOrgUsersPermissions>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ViewOrgUsersPermissions> findByRootId(int rootId, int start,
		int end) throws SystemException {
		return findByRootId(rootId, start, end, null);
	}

	public List<ViewOrgUsersPermissions> findByRootId(int rootId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(rootId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ViewOrgUsersPermissions> list = (List<ViewOrgUsersPermissions>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ViewOrgUsersPermissions WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rootId);

				list = (List<ViewOrgUsersPermissions>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ViewOrgUsersPermissions>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ViewOrgUsersPermissions findByRootId_First(int rootId,
		OrderByComparator obc)
		throws NoSuchViewOrgUsersPermissionsException, SystemException {
		List<ViewOrgUsersPermissions> list = findByRootId(rootId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ViewOrgUsersPermissions exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchViewOrgUsersPermissionsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ViewOrgUsersPermissions findByRootId_Last(int rootId,
		OrderByComparator obc)
		throws NoSuchViewOrgUsersPermissionsException, SystemException {
		int count = countByRootId(rootId);

		List<ViewOrgUsersPermissions> list = findByRootId(rootId, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ViewOrgUsersPermissions exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchViewOrgUsersPermissionsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ViewOrgUsersPermissions[] findByRootId_PrevAndNext(String id,
		int rootId, OrderByComparator obc)
		throws NoSuchViewOrgUsersPermissionsException, SystemException {
		ViewOrgUsersPermissions viewOrgUsersPermissions = findByPrimaryKey(id);

		int count = countByRootId(rootId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ViewOrgUsersPermissions WHERE ");

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
					viewOrgUsersPermissions);

			ViewOrgUsersPermissions[] array = new ViewOrgUsersPermissionsImpl[3];

			array[0] = (ViewOrgUsersPermissions)objArray[0];
			array[1] = (ViewOrgUsersPermissions)objArray[1];
			array[2] = (ViewOrgUsersPermissions)objArray[2];

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

	public List<ViewOrgUsersPermissions> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<ViewOrgUsersPermissions> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<ViewOrgUsersPermissions> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ViewOrgUsersPermissions> list = (List<ViewOrgUsersPermissions>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ViewOrgUsersPermissions ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<ViewOrgUsersPermissions>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ViewOrgUsersPermissions>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ViewOrgUsersPermissions>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByUserId(int userId) throws SystemException {
		for (ViewOrgUsersPermissions viewOrgUsersPermissions : findByUserId(
				userId)) {
			remove(viewOrgUsersPermissions);
		}
	}

	public void removeByRootId(int rootId) throws SystemException {
		for (ViewOrgUsersPermissions viewOrgUsersPermissions : findByRootId(
				rootId)) {
			remove(viewOrgUsersPermissions);
		}
	}

	public void removeAll() throws SystemException {
		for (ViewOrgUsersPermissions viewOrgUsersPermissions : findAll()) {
			remove(viewOrgUsersPermissions);
		}
	}

	public int countByUserId(int userId) throws SystemException {
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
					"FROM larion.progate.model.ViewOrgUsersPermissions WHERE ");

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

	public int countByRootId(int rootId) throws SystemException {
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
					"FROM larion.progate.model.ViewOrgUsersPermissions WHERE ");

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

	public int countAll() throws SystemException {
		Object[] finderArgs = new Object[0];

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(
						"SELECT COUNT(*) FROM larion.progate.model.ViewOrgUsersPermissions");

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
						"value.object.listener.larion.progate.model.ViewOrgUsersPermissions")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ViewOrgUsersPermissions>> listenersList = new ArrayList<ModelListener<ViewOrgUsersPermissions>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ViewOrgUsersPermissions>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(ViewOrgUsersPermissionsPersistenceImpl.class);
}