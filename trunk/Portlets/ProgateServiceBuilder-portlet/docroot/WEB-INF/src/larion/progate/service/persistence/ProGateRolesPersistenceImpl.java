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

import larion.progate.NoSuchProGateRolesException;

import larion.progate.model.ProGateRoles;
import larion.progate.model.impl.ProGateRolesImpl;
import larion.progate.model.impl.ProGateRolesModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="ProGateRolesPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateRolesPersistenceImpl extends BasePersistenceImpl
	implements ProGateRolesPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = ProGateRolesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_ROLETYPE = new FinderPath(ProGateRolesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateRolesModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByroleType", new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ROLETYPE = new FinderPath(ProGateRolesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateRolesModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByroleType",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ROLETYPE = new FinderPath(ProGateRolesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateRolesModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByroleType", new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_NAME = new FinderPath(ProGateRolesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateRolesModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByname", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_NAME = new FinderPath(ProGateRolesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateRolesModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByname",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(ProGateRolesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateRolesModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByname", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_PRIORITY = new FinderPath(ProGateRolesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateRolesModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findBypriority", new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_PRIORITY = new FinderPath(ProGateRolesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateRolesModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findBypriority",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_PRIORITY = new FinderPath(ProGateRolesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateRolesModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countBypriority", new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(ProGateRolesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateRolesModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProGateRolesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateRolesModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	public void cacheResult(ProGateRoles proGateRoles) {
		EntityCacheUtil.putResult(ProGateRolesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateRolesImpl.class, proGateRoles.getPrimaryKey(), proGateRoles);
	}

	public void cacheResult(List<ProGateRoles> proGateRoleses) {
		for (ProGateRoles proGateRoles : proGateRoleses) {
			if (EntityCacheUtil.getResult(
						ProGateRolesModelImpl.ENTITY_CACHE_ENABLED,
						ProGateRolesImpl.class, proGateRoles.getPrimaryKey(),
						this) == null) {
				cacheResult(proGateRoles);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(ProGateRolesImpl.class.getName());
		EntityCacheUtil.clearCache(ProGateRolesImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public ProGateRoles create(Integer roleId) {
		ProGateRoles proGateRoles = new ProGateRolesImpl();

		proGateRoles.setNew(true);
		proGateRoles.setPrimaryKey(roleId);

		return proGateRoles;
	}

	public ProGateRoles remove(Integer roleId)
		throws NoSuchProGateRolesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ProGateRoles proGateRoles = (ProGateRoles)session.get(ProGateRolesImpl.class,
					roleId);

			if (proGateRoles == null) {
				if (_log.isWarnEnabled()) {
					_log.warn("No ProGateRoles exists with the primary key " +
						roleId);
				}

				throw new NoSuchProGateRolesException(
					"No ProGateRoles exists with the primary key " + roleId);
			}

			return remove(proGateRoles);
		}
		catch (NoSuchProGateRolesException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public ProGateRoles remove(ProGateRoles proGateRoles)
		throws SystemException {
		for (ModelListener<ProGateRoles> listener : listeners) {
			listener.onBeforeRemove(proGateRoles);
		}

		proGateRoles = removeImpl(proGateRoles);

		for (ModelListener<ProGateRoles> listener : listeners) {
			listener.onAfterRemove(proGateRoles);
		}

		return proGateRoles;
	}

	protected ProGateRoles removeImpl(ProGateRoles proGateRoles)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (proGateRoles.isCachedModel() || BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(ProGateRolesImpl.class,
						proGateRoles.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(proGateRoles);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(ProGateRolesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateRolesImpl.class, proGateRoles.getPrimaryKey());

		return proGateRoles;
	}

	public ProGateRoles update(ProGateRoles proGateRoles)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(ProGateRoles proGateRoles) method. Use update(ProGateRoles proGateRoles, boolean merge) instead.");
		}

		return update(proGateRoles, false);
	}

	public ProGateRoles update(ProGateRoles proGateRoles, boolean merge)
		throws SystemException {
		boolean isNew = proGateRoles.isNew();

		for (ModelListener<ProGateRoles> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(proGateRoles);
			}
			else {
				listener.onBeforeUpdate(proGateRoles);
			}
		}

		proGateRoles = updateImpl(proGateRoles, merge);

		for (ModelListener<ProGateRoles> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(proGateRoles);
			}
			else {
				listener.onAfterUpdate(proGateRoles);
			}
		}

		return proGateRoles;
	}

	public ProGateRoles updateImpl(
		larion.progate.model.ProGateRoles proGateRoles, boolean merge)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, proGateRoles, merge);

			proGateRoles.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(ProGateRolesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateRolesImpl.class, proGateRoles.getPrimaryKey(), proGateRoles);

		return proGateRoles;
	}

	public ProGateRoles findByPrimaryKey(Integer roleId)
		throws NoSuchProGateRolesException, SystemException {
		ProGateRoles proGateRoles = fetchByPrimaryKey(roleId);

		if (proGateRoles == null) {
			if (_log.isWarnEnabled()) {
				_log.warn("No ProGateRoles exists with the primary key " +
					roleId);
			}

			throw new NoSuchProGateRolesException(
				"No ProGateRoles exists with the primary key " + roleId);
		}

		return proGateRoles;
	}

	public ProGateRoles fetchByPrimaryKey(Integer roleId)
		throws SystemException {
		ProGateRoles proGateRoles = (ProGateRoles)EntityCacheUtil.getResult(ProGateRolesModelImpl.ENTITY_CACHE_ENABLED,
				ProGateRolesImpl.class, roleId, this);

		if (proGateRoles == null) {
			Session session = null;

			try {
				session = openSession();

				proGateRoles = (ProGateRoles)session.get(ProGateRolesImpl.class,
						roleId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (proGateRoles != null) {
					cacheResult(proGateRoles);
				}

				closeSession(session);
			}
		}

		return proGateRoles;
	}

	public List<ProGateRoles> findByroleType(int roleType)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(roleType) };

		List<ProGateRoles> list = (List<ProGateRoles>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ROLETYPE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.ProGateRoles WHERE ");

				query.append("roletype = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("priority DESC, ");
				query.append("roletype ASC, ");
				query.append("name ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(roleType);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateRoles>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ROLETYPE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateRoles> findByroleType(int roleType, int start, int end)
		throws SystemException {
		return findByroleType(roleType, start, end, null);
	}

	public List<ProGateRoles> findByroleType(int roleType, int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(roleType),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateRoles> list = (List<ProGateRoles>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ROLETYPE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.ProGateRoles WHERE ");

				query.append("roletype = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("priority DESC, ");
					query.append("roletype ASC, ");
					query.append("name ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(roleType);

				list = (List<ProGateRoles>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateRoles>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ROLETYPE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateRoles findByroleType_First(int roleType, OrderByComparator obc)
		throws NoSuchProGateRolesException, SystemException {
		List<ProGateRoles> list = findByroleType(roleType, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateRoles exists with the key {");

			msg.append("roleType=" + roleType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateRolesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateRoles findByroleType_Last(int roleType, OrderByComparator obc)
		throws NoSuchProGateRolesException, SystemException {
		int count = countByroleType(roleType);

		List<ProGateRoles> list = findByroleType(roleType, count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateRoles exists with the key {");

			msg.append("roleType=" + roleType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateRolesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateRoles[] findByroleType_PrevAndNext(Integer roleId,
		int roleType, OrderByComparator obc)
		throws NoSuchProGateRolesException, SystemException {
		ProGateRoles proGateRoles = findByPrimaryKey(roleId);

		int count = countByroleType(roleType);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.ProGateRoles WHERE ");

			query.append("roletype = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("priority DESC, ");
				query.append("roletype ASC, ");
				query.append("name ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(roleType);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateRoles);

			ProGateRoles[] array = new ProGateRolesImpl[3];

			array[0] = (ProGateRoles)objArray[0];
			array[1] = (ProGateRoles)objArray[1];
			array[2] = (ProGateRoles)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateRoles> findByname(String name) throws SystemException {
		Object[] finderArgs = new Object[] { name };

		List<ProGateRoles> list = (List<ProGateRoles>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_NAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.ProGateRoles WHERE ");

				if (name == null) {
					query.append("name LIKE null");
				}
				else {
					query.append("name LIKE ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("priority DESC, ");
				query.append("roletype ASC, ");
				query.append("name ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (name != null) {
					qPos.add(name);
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateRoles>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_NAME, finderArgs,
					list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateRoles> findByname(String name, int start, int end)
		throws SystemException {
		return findByname(name, start, end, null);
	}

	public List<ProGateRoles> findByname(String name, int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				name,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateRoles> list = (List<ProGateRoles>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_NAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.ProGateRoles WHERE ");

				if (name == null) {
					query.append("name LIKE null");
				}
				else {
					query.append("name LIKE ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("priority DESC, ");
					query.append("roletype ASC, ");
					query.append("name ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (name != null) {
					qPos.add(name);
				}

				list = (List<ProGateRoles>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateRoles>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_NAME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateRoles findByname_First(String name, OrderByComparator obc)
		throws NoSuchProGateRolesException, SystemException {
		List<ProGateRoles> list = findByname(name, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateRoles exists with the key {");

			msg.append("name=" + name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateRolesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateRoles findByname_Last(String name, OrderByComparator obc)
		throws NoSuchProGateRolesException, SystemException {
		int count = countByname(name);

		List<ProGateRoles> list = findByname(name, count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateRoles exists with the key {");

			msg.append("name=" + name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateRolesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateRoles[] findByname_PrevAndNext(Integer roleId, String name,
		OrderByComparator obc)
		throws NoSuchProGateRolesException, SystemException {
		ProGateRoles proGateRoles = findByPrimaryKey(roleId);

		int count = countByname(name);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.ProGateRoles WHERE ");

			if (name == null) {
				query.append("name LIKE null");
			}
			else {
				query.append("name LIKE ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("priority DESC, ");
				query.append("roletype ASC, ");
				query.append("name ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (name != null) {
				qPos.add(name);
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateRoles);

			ProGateRoles[] array = new ProGateRolesImpl[3];

			array[0] = (ProGateRoles)objArray[0];
			array[1] = (ProGateRoles)objArray[1];
			array[2] = (ProGateRoles)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateRoles> findBypriority(int priority)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(priority) };

		List<ProGateRoles> list = (List<ProGateRoles>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_PRIORITY,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.ProGateRoles WHERE ");

				query.append("priority LIKE ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("priority DESC, ");
				query.append("roletype ASC, ");
				query.append("name ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(priority);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateRoles>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_PRIORITY,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateRoles> findBypriority(int priority, int start, int end)
		throws SystemException {
		return findBypriority(priority, start, end, null);
	}

	public List<ProGateRoles> findBypriority(int priority, int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(priority),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateRoles> list = (List<ProGateRoles>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_PRIORITY,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.ProGateRoles WHERE ");

				query.append("priority LIKE ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("priority DESC, ");
					query.append("roletype ASC, ");
					query.append("name ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(priority);

				list = (List<ProGateRoles>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateRoles>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_PRIORITY,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateRoles findBypriority_First(int priority, OrderByComparator obc)
		throws NoSuchProGateRolesException, SystemException {
		List<ProGateRoles> list = findBypriority(priority, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateRoles exists with the key {");

			msg.append("priority=" + priority);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateRolesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateRoles findBypriority_Last(int priority, OrderByComparator obc)
		throws NoSuchProGateRolesException, SystemException {
		int count = countBypriority(priority);

		List<ProGateRoles> list = findBypriority(priority, count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateRoles exists with the key {");

			msg.append("priority=" + priority);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateRolesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateRoles[] findBypriority_PrevAndNext(Integer roleId,
		int priority, OrderByComparator obc)
		throws NoSuchProGateRolesException, SystemException {
		ProGateRoles proGateRoles = findByPrimaryKey(roleId);

		int count = countBypriority(priority);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.ProGateRoles WHERE ");

			query.append("priority LIKE ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("priority DESC, ");
				query.append("roletype ASC, ");
				query.append("name ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(priority);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateRoles);

			ProGateRoles[] array = new ProGateRolesImpl[3];

			array[0] = (ProGateRoles)objArray[0];
			array[1] = (ProGateRoles)objArray[1];
			array[2] = (ProGateRoles)objArray[2];

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

	public List<ProGateRoles> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<ProGateRoles> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<ProGateRoles> findAll(int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateRoles> list = (List<ProGateRoles>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.ProGateRoles ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("priority DESC, ");
					query.append("roletype ASC, ");
					query.append("name ASC");
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<ProGateRoles>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ProGateRoles>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateRoles>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByroleType(int roleType) throws SystemException {
		for (ProGateRoles proGateRoles : findByroleType(roleType)) {
			remove(proGateRoles);
		}
	}

	public void removeByname(String name) throws SystemException {
		for (ProGateRoles proGateRoles : findByname(name)) {
			remove(proGateRoles);
		}
	}

	public void removeBypriority(int priority) throws SystemException {
		for (ProGateRoles proGateRoles : findBypriority(priority)) {
			remove(proGateRoles);
		}
	}

	public void removeAll() throws SystemException {
		for (ProGateRoles proGateRoles : findAll()) {
			remove(proGateRoles);
		}
	}

	public int countByroleType(int roleType) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(roleType) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ROLETYPE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append("FROM larion.progate.model.ProGateRoles WHERE ");

				query.append("roletype = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(roleType);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ROLETYPE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByname(String name) throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_NAME,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append("FROM larion.progate.model.ProGateRoles WHERE ");

				if (name == null) {
					query.append("name LIKE null");
				}
				else {
					query.append("name LIKE ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (name != null) {
					qPos.add(name);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countBypriority(int priority) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(priority) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PRIORITY,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append("FROM larion.progate.model.ProGateRoles WHERE ");

				query.append("priority LIKE ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(priority);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PRIORITY,
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
						"SELECT COUNT(*) FROM larion.progate.model.ProGateRoles");

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
						"value.object.listener.larion.progate.model.ProGateRoles")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ProGateRoles>> listenersList = new ArrayList<ModelListener<ProGateRoles>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ProGateRoles>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(ProGateRolesPersistenceImpl.class);
}