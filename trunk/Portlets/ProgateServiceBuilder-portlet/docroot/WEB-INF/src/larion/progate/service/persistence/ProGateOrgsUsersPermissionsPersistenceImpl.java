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

import larion.progate.NoSuchProGateOrgsUsersPermissionsException;

import larion.progate.model.ProGateOrgsUsersPermissions;
import larion.progate.model.impl.ProGateOrgsUsersPermissionsImpl;
import larion.progate.model.impl.ProGateOrgsUsersPermissionsModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="ProGateOrgsUsersPermissionsPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateOrgsUsersPermissionsPersistenceImpl
	extends BasePersistenceImpl
	implements ProGateOrgsUsersPermissionsPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = ProGateOrgsUsersPermissionsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_ORGID = new FinderPath(ProGateOrgsUsersPermissionsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgsUsersPermissionsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOrgId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ORGID = new FinderPath(ProGateOrgsUsersPermissionsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgsUsersPermissionsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOrgId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGID = new FinderPath(ProGateOrgsUsersPermissionsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgsUsersPermissionsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByOrgId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_USERID = new FinderPath(ProGateOrgsUsersPermissionsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgsUsersPermissionsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByUserId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_USERID = new FinderPath(ProGateOrgsUsersPermissionsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgsUsersPermissionsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByUserId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(ProGateOrgsUsersPermissionsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgsUsersPermissionsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByUserId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(ProGateOrgsUsersPermissionsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgsUsersPermissionsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProGateOrgsUsersPermissionsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgsUsersPermissionsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(
		ProGateOrgsUsersPermissions proGateOrgsUsersPermissions) {
		EntityCacheUtil.putResult(ProGateOrgsUsersPermissionsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgsUsersPermissionsImpl.class,
			proGateOrgsUsersPermissions.getPrimaryKey(),
			proGateOrgsUsersPermissions);
	}

	public void cacheResult(
		List<ProGateOrgsUsersPermissions> proGateOrgsUsersPermissionses) {
		for (ProGateOrgsUsersPermissions proGateOrgsUsersPermissions : proGateOrgsUsersPermissionses) {
			if (EntityCacheUtil.getResult(
						ProGateOrgsUsersPermissionsModelImpl.ENTITY_CACHE_ENABLED,
						ProGateOrgsUsersPermissionsImpl.class,
						proGateOrgsUsersPermissions.getPrimaryKey(), this) == null) {
				cacheResult(proGateOrgsUsersPermissions);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(ProGateOrgsUsersPermissionsImpl.class.getName());
		EntityCacheUtil.clearCache(ProGateOrgsUsersPermissionsImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public ProGateOrgsUsersPermissions create(
		Integer ProGateOrgsUsersPermissionsId) {
		ProGateOrgsUsersPermissions proGateOrgsUsersPermissions = new ProGateOrgsUsersPermissionsImpl();

		proGateOrgsUsersPermissions.setNew(true);
		proGateOrgsUsersPermissions.setPrimaryKey(ProGateOrgsUsersPermissionsId);

		return proGateOrgsUsersPermissions;
	}

	public ProGateOrgsUsersPermissions remove(
		Integer ProGateOrgsUsersPermissionsId)
		throws NoSuchProGateOrgsUsersPermissionsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ProGateOrgsUsersPermissions proGateOrgsUsersPermissions = (ProGateOrgsUsersPermissions)session.get(ProGateOrgsUsersPermissionsImpl.class,
					ProGateOrgsUsersPermissionsId);

			if (proGateOrgsUsersPermissions == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No ProGateOrgsUsersPermissions exists with the primary key " +
						ProGateOrgsUsersPermissionsId);
				}

				throw new NoSuchProGateOrgsUsersPermissionsException(
					"No ProGateOrgsUsersPermissions exists with the primary key " +
					ProGateOrgsUsersPermissionsId);
			}

			return remove(proGateOrgsUsersPermissions);
		}
		catch (NoSuchProGateOrgsUsersPermissionsException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public ProGateOrgsUsersPermissions remove(
		ProGateOrgsUsersPermissions proGateOrgsUsersPermissions)
		throws SystemException {
		for (ModelListener<ProGateOrgsUsersPermissions> listener : listeners) {
			listener.onBeforeRemove(proGateOrgsUsersPermissions);
		}

		proGateOrgsUsersPermissions = removeImpl(proGateOrgsUsersPermissions);

		for (ModelListener<ProGateOrgsUsersPermissions> listener : listeners) {
			listener.onAfterRemove(proGateOrgsUsersPermissions);
		}

		return proGateOrgsUsersPermissions;
	}

	protected ProGateOrgsUsersPermissions removeImpl(
		ProGateOrgsUsersPermissions proGateOrgsUsersPermissions)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (proGateOrgsUsersPermissions.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(ProGateOrgsUsersPermissionsImpl.class,
						proGateOrgsUsersPermissions.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(proGateOrgsUsersPermissions);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(ProGateOrgsUsersPermissionsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgsUsersPermissionsImpl.class,
			proGateOrgsUsersPermissions.getPrimaryKey());

		return proGateOrgsUsersPermissions;
	}

	public ProGateOrgsUsersPermissions update(
		ProGateOrgsUsersPermissions proGateOrgsUsersPermissions)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(ProGateOrgsUsersPermissions proGateOrgsUsersPermissions) method. Use update(ProGateOrgsUsersPermissions proGateOrgsUsersPermissions, boolean merge) instead.");
		}

		return update(proGateOrgsUsersPermissions, false);
	}

	public ProGateOrgsUsersPermissions update(
		ProGateOrgsUsersPermissions proGateOrgsUsersPermissions, boolean merge)
		throws SystemException {
		boolean isNew = proGateOrgsUsersPermissions.isNew();

		for (ModelListener<ProGateOrgsUsersPermissions> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(proGateOrgsUsersPermissions);
			}
			else {
				listener.onBeforeUpdate(proGateOrgsUsersPermissions);
			}
		}

		proGateOrgsUsersPermissions = updateImpl(proGateOrgsUsersPermissions,
				merge);

		for (ModelListener<ProGateOrgsUsersPermissions> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(proGateOrgsUsersPermissions);
			}
			else {
				listener.onAfterUpdate(proGateOrgsUsersPermissions);
			}
		}

		return proGateOrgsUsersPermissions;
	}

	public ProGateOrgsUsersPermissions updateImpl(
		larion.progate.model.ProGateOrgsUsersPermissions proGateOrgsUsersPermissions,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, proGateOrgsUsersPermissions, merge);

			proGateOrgsUsersPermissions.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(ProGateOrgsUsersPermissionsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgsUsersPermissionsImpl.class,
			proGateOrgsUsersPermissions.getPrimaryKey(),
			proGateOrgsUsersPermissions);

		return proGateOrgsUsersPermissions;
	}

	public ProGateOrgsUsersPermissions findByPrimaryKey(
		Integer ProGateOrgsUsersPermissionsId)
		throws NoSuchProGateOrgsUsersPermissionsException, SystemException {
		ProGateOrgsUsersPermissions proGateOrgsUsersPermissions = fetchByPrimaryKey(ProGateOrgsUsersPermissionsId);

		if (proGateOrgsUsersPermissions == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"No ProGateOrgsUsersPermissions exists with the primary key " +
					ProGateOrgsUsersPermissionsId);
			}

			throw new NoSuchProGateOrgsUsersPermissionsException(
				"No ProGateOrgsUsersPermissions exists with the primary key " +
				ProGateOrgsUsersPermissionsId);
		}

		return proGateOrgsUsersPermissions;
	}

	public ProGateOrgsUsersPermissions fetchByPrimaryKey(
		Integer ProGateOrgsUsersPermissionsId) throws SystemException {
		ProGateOrgsUsersPermissions proGateOrgsUsersPermissions = (ProGateOrgsUsersPermissions)EntityCacheUtil.getResult(ProGateOrgsUsersPermissionsModelImpl.ENTITY_CACHE_ENABLED,
				ProGateOrgsUsersPermissionsImpl.class,
				ProGateOrgsUsersPermissionsId, this);

		if (proGateOrgsUsersPermissions == null) {
			Session session = null;

			try {
				session = openSession();

				proGateOrgsUsersPermissions = (ProGateOrgsUsersPermissions)session.get(ProGateOrgsUsersPermissionsImpl.class,
						ProGateOrgsUsersPermissionsId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (proGateOrgsUsersPermissions != null) {
					cacheResult(proGateOrgsUsersPermissions);
				}

				closeSession(session);
			}
		}

		return proGateOrgsUsersPermissions;
	}

	public List<ProGateOrgsUsersPermissions> findByOrgId(int orgId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(orgId) };

		List<ProGateOrgsUsersPermissions> list = (List<ProGateOrgsUsersPermissions>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ORGID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateOrgsUsersPermissions WHERE ");

				query.append("org_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orgId);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateOrgsUsersPermissions>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ORGID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateOrgsUsersPermissions> findByOrgId(int orgId, int start,
		int end) throws SystemException {
		return findByOrgId(orgId, start, end, null);
	}

	public List<ProGateOrgsUsersPermissions> findByOrgId(int orgId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(orgId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateOrgsUsersPermissions> list = (List<ProGateOrgsUsersPermissions>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ORGID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateOrgsUsersPermissions WHERE ");

				query.append("org_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orgId);

				list = (List<ProGateOrgsUsersPermissions>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateOrgsUsersPermissions>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ORGID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateOrgsUsersPermissions findByOrgId_First(int orgId,
		OrderByComparator obc)
		throws NoSuchProGateOrgsUsersPermissionsException, SystemException {
		List<ProGateOrgsUsersPermissions> list = findByOrgId(orgId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateOrgsUsersPermissions exists with the key {");

			msg.append("orgId=" + orgId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateOrgsUsersPermissionsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateOrgsUsersPermissions findByOrgId_Last(int orgId,
		OrderByComparator obc)
		throws NoSuchProGateOrgsUsersPermissionsException, SystemException {
		int count = countByOrgId(orgId);

		List<ProGateOrgsUsersPermissions> list = findByOrgId(orgId, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateOrgsUsersPermissions exists with the key {");

			msg.append("orgId=" + orgId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateOrgsUsersPermissionsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateOrgsUsersPermissions[] findByOrgId_PrevAndNext(
		Integer ProGateOrgsUsersPermissionsId, int orgId, OrderByComparator obc)
		throws NoSuchProGateOrgsUsersPermissionsException, SystemException {
		ProGateOrgsUsersPermissions proGateOrgsUsersPermissions = findByPrimaryKey(ProGateOrgsUsersPermissionsId);

		int count = countByOrgId(orgId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateOrgsUsersPermissions WHERE ");

			query.append("org_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(orgId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateOrgsUsersPermissions);

			ProGateOrgsUsersPermissions[] array = new ProGateOrgsUsersPermissionsImpl[3];

			array[0] = (ProGateOrgsUsersPermissions)objArray[0];
			array[1] = (ProGateOrgsUsersPermissions)objArray[1];
			array[2] = (ProGateOrgsUsersPermissions)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateOrgsUsersPermissions> findByUserId(int userId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(userId) };

		List<ProGateOrgsUsersPermissions> list = (List<ProGateOrgsUsersPermissions>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_USERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateOrgsUsersPermissions WHERE ");

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
					list = new ArrayList<ProGateOrgsUsersPermissions>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_USERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateOrgsUsersPermissions> findByUserId(int userId,
		int start, int end) throws SystemException {
		return findByUserId(userId, start, end, null);
	}

	public List<ProGateOrgsUsersPermissions> findByUserId(int userId,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(userId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateOrgsUsersPermissions> list = (List<ProGateOrgsUsersPermissions>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_USERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateOrgsUsersPermissions WHERE ");

				query.append("user_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				list = (List<ProGateOrgsUsersPermissions>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateOrgsUsersPermissions>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_USERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateOrgsUsersPermissions findByUserId_First(int userId,
		OrderByComparator obc)
		throws NoSuchProGateOrgsUsersPermissionsException, SystemException {
		List<ProGateOrgsUsersPermissions> list = findByUserId(userId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateOrgsUsersPermissions exists with the key {");

			msg.append("userId=" + userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateOrgsUsersPermissionsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateOrgsUsersPermissions findByUserId_Last(int userId,
		OrderByComparator obc)
		throws NoSuchProGateOrgsUsersPermissionsException, SystemException {
		int count = countByUserId(userId);

		List<ProGateOrgsUsersPermissions> list = findByUserId(userId,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateOrgsUsersPermissions exists with the key {");

			msg.append("userId=" + userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateOrgsUsersPermissionsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateOrgsUsersPermissions[] findByUserId_PrevAndNext(
		Integer ProGateOrgsUsersPermissionsId, int userId, OrderByComparator obc)
		throws NoSuchProGateOrgsUsersPermissionsException, SystemException {
		ProGateOrgsUsersPermissions proGateOrgsUsersPermissions = findByPrimaryKey(ProGateOrgsUsersPermissionsId);

		int count = countByUserId(userId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateOrgsUsersPermissions WHERE ");

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
					proGateOrgsUsersPermissions);

			ProGateOrgsUsersPermissions[] array = new ProGateOrgsUsersPermissionsImpl[3];

			array[0] = (ProGateOrgsUsersPermissions)objArray[0];
			array[1] = (ProGateOrgsUsersPermissions)objArray[1];
			array[2] = (ProGateOrgsUsersPermissions)objArray[2];

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

	public List<ProGateOrgsUsersPermissions> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<ProGateOrgsUsersPermissions> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<ProGateOrgsUsersPermissions> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateOrgsUsersPermissions> list = (List<ProGateOrgsUsersPermissions>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateOrgsUsersPermissions ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<ProGateOrgsUsersPermissions>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ProGateOrgsUsersPermissions>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateOrgsUsersPermissions>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByOrgId(int orgId) throws SystemException {
		for (ProGateOrgsUsersPermissions proGateOrgsUsersPermissions : findByOrgId(
				orgId)) {
			remove(proGateOrgsUsersPermissions);
		}
	}

	public void removeByUserId(int userId) throws SystemException {
		for (ProGateOrgsUsersPermissions proGateOrgsUsersPermissions : findByUserId(
				userId)) {
			remove(proGateOrgsUsersPermissions);
		}
	}

	public void removeAll() throws SystemException {
		for (ProGateOrgsUsersPermissions proGateOrgsUsersPermissions : findAll()) {
			remove(proGateOrgsUsersPermissions);
		}
	}

	public int countByOrgId(int orgId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(orgId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ORGID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateOrgsUsersPermissions WHERE ");

				query.append("org_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orgId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ORGID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
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
					"FROM larion.progate.model.ProGateOrgsUsersPermissions WHERE ");

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

	public int countAll() throws SystemException {
		Object[] finderArgs = new Object[0];

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(
						"SELECT COUNT(*) FROM larion.progate.model.ProGateOrgsUsersPermissions");

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
						"value.object.listener.larion.progate.model.ProGateOrgsUsersPermissions")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ProGateOrgsUsersPermissions>> listenersList = new ArrayList<ModelListener<ProGateOrgsUsersPermissions>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ProGateOrgsUsersPermissions>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(ProGateOrgsUsersPermissionsPersistenceImpl.class);
}