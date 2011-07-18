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

import larion.progate.NoSuchProgatePortalMenuException;

import larion.progate.model.ProgatePortalMenu;
import larion.progate.model.impl.ProgatePortalMenuImpl;
import larion.progate.model.impl.ProgatePortalMenuModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="ProgatePortalMenuPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProgatePortalMenuPersistenceImpl extends BasePersistenceImpl
	implements ProgatePortalMenuPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = ProgatePortalMenuImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_LAYOUTID = new FinderPath(ProgatePortalMenuModelImpl.ENTITY_CACHE_ENABLED,
			ProgatePortalMenuModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBylayoutId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_LAYOUTID = new FinderPath(ProgatePortalMenuModelImpl.ENTITY_CACHE_ENABLED,
			ProgatePortalMenuModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBylayoutId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_LAYOUTID = new FinderPath(ProgatePortalMenuModelImpl.ENTITY_CACHE_ENABLED,
			ProgatePortalMenuModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBylayoutId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ROLEID = new FinderPath(ProgatePortalMenuModelImpl.ENTITY_CACHE_ENABLED,
			ProgatePortalMenuModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByroleId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ROLEID = new FinderPath(ProgatePortalMenuModelImpl.ENTITY_CACHE_ENABLED,
			ProgatePortalMenuModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByroleId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ROLEID = new FinderPath(ProgatePortalMenuModelImpl.ENTITY_CACHE_ENABLED,
			ProgatePortalMenuModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByroleId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ORGID = new FinderPath(ProgatePortalMenuModelImpl.ENTITY_CACHE_ENABLED,
			ProgatePortalMenuModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByorgId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ORGID = new FinderPath(ProgatePortalMenuModelImpl.ENTITY_CACHE_ENABLED,
			ProgatePortalMenuModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByorgId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGID = new FinderPath(ProgatePortalMenuModelImpl.ENTITY_CACHE_ENABLED,
			ProgatePortalMenuModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByorgId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_NAME = new FinderPath(ProgatePortalMenuModelImpl.ENTITY_CACHE_ENABLED,
			ProgatePortalMenuModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByname",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_NAME = new FinderPath(ProgatePortalMenuModelImpl.ENTITY_CACHE_ENABLED,
			ProgatePortalMenuModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByname",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(ProgatePortalMenuModelImpl.ENTITY_CACHE_ENABLED,
			ProgatePortalMenuModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByname",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(ProgatePortalMenuModelImpl.ENTITY_CACHE_ENABLED,
			ProgatePortalMenuModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProgatePortalMenuModelImpl.ENTITY_CACHE_ENABLED,
			ProgatePortalMenuModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(ProgatePortalMenu progatePortalMenu) {
		EntityCacheUtil.putResult(ProgatePortalMenuModelImpl.ENTITY_CACHE_ENABLED,
			ProgatePortalMenuImpl.class, progatePortalMenu.getPrimaryKey(),
			progatePortalMenu);
	}

	public void cacheResult(List<ProgatePortalMenu> progatePortalMenus) {
		for (ProgatePortalMenu progatePortalMenu : progatePortalMenus) {
			if (EntityCacheUtil.getResult(
						ProgatePortalMenuModelImpl.ENTITY_CACHE_ENABLED,
						ProgatePortalMenuImpl.class,
						progatePortalMenu.getPrimaryKey(), this) == null) {
				cacheResult(progatePortalMenu);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(ProgatePortalMenuImpl.class.getName());
		EntityCacheUtil.clearCache(ProgatePortalMenuImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public ProgatePortalMenu create(Integer portalMenuId) {
		ProgatePortalMenu progatePortalMenu = new ProgatePortalMenuImpl();

		progatePortalMenu.setNew(true);
		progatePortalMenu.setPrimaryKey(portalMenuId);

		return progatePortalMenu;
	}

	public ProgatePortalMenu remove(Integer portalMenuId)
		throws NoSuchProgatePortalMenuException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ProgatePortalMenu progatePortalMenu = (ProgatePortalMenu)session.get(ProgatePortalMenuImpl.class,
					portalMenuId);

			if (progatePortalMenu == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No ProgatePortalMenu exists with the primary key " +
						portalMenuId);
				}

				throw new NoSuchProgatePortalMenuException(
					"No ProgatePortalMenu exists with the primary key " +
					portalMenuId);
			}

			return remove(progatePortalMenu);
		}
		catch (NoSuchProgatePortalMenuException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public ProgatePortalMenu remove(ProgatePortalMenu progatePortalMenu)
		throws SystemException {
		for (ModelListener<ProgatePortalMenu> listener : listeners) {
			listener.onBeforeRemove(progatePortalMenu);
		}

		progatePortalMenu = removeImpl(progatePortalMenu);

		for (ModelListener<ProgatePortalMenu> listener : listeners) {
			listener.onAfterRemove(progatePortalMenu);
		}

		return progatePortalMenu;
	}

	protected ProgatePortalMenu removeImpl(ProgatePortalMenu progatePortalMenu)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (progatePortalMenu.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(ProgatePortalMenuImpl.class,
						progatePortalMenu.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(progatePortalMenu);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(ProgatePortalMenuModelImpl.ENTITY_CACHE_ENABLED,
			ProgatePortalMenuImpl.class, progatePortalMenu.getPrimaryKey());

		return progatePortalMenu;
	}

	public ProgatePortalMenu update(ProgatePortalMenu progatePortalMenu)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(ProgatePortalMenu progatePortalMenu) method. Use update(ProgatePortalMenu progatePortalMenu, boolean merge) instead.");
		}

		return update(progatePortalMenu, false);
	}

	public ProgatePortalMenu update(ProgatePortalMenu progatePortalMenu,
		boolean merge) throws SystemException {
		boolean isNew = progatePortalMenu.isNew();

		for (ModelListener<ProgatePortalMenu> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(progatePortalMenu);
			}
			else {
				listener.onBeforeUpdate(progatePortalMenu);
			}
		}

		progatePortalMenu = updateImpl(progatePortalMenu, merge);

		for (ModelListener<ProgatePortalMenu> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(progatePortalMenu);
			}
			else {
				listener.onAfterUpdate(progatePortalMenu);
			}
		}

		return progatePortalMenu;
	}

	public ProgatePortalMenu updateImpl(
		larion.progate.model.ProgatePortalMenu progatePortalMenu, boolean merge)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, progatePortalMenu, merge);

			progatePortalMenu.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(ProgatePortalMenuModelImpl.ENTITY_CACHE_ENABLED,
			ProgatePortalMenuImpl.class, progatePortalMenu.getPrimaryKey(),
			progatePortalMenu);

		return progatePortalMenu;
	}

	public ProgatePortalMenu findByPrimaryKey(Integer portalMenuId)
		throws NoSuchProgatePortalMenuException, SystemException {
		ProgatePortalMenu progatePortalMenu = fetchByPrimaryKey(portalMenuId);

		if (progatePortalMenu == null) {
			if (_log.isWarnEnabled()) {
				_log.warn("No ProgatePortalMenu exists with the primary key " +
					portalMenuId);
			}

			throw new NoSuchProgatePortalMenuException(
				"No ProgatePortalMenu exists with the primary key " +
				portalMenuId);
		}

		return progatePortalMenu;
	}

	public ProgatePortalMenu fetchByPrimaryKey(Integer portalMenuId)
		throws SystemException {
		ProgatePortalMenu progatePortalMenu = (ProgatePortalMenu)EntityCacheUtil.getResult(ProgatePortalMenuModelImpl.ENTITY_CACHE_ENABLED,
				ProgatePortalMenuImpl.class, portalMenuId, this);

		if (progatePortalMenu == null) {
			Session session = null;

			try {
				session = openSession();

				progatePortalMenu = (ProgatePortalMenu)session.get(ProgatePortalMenuImpl.class,
						portalMenuId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (progatePortalMenu != null) {
					cacheResult(progatePortalMenu);
				}

				closeSession(session);
			}
		}

		return progatePortalMenu;
	}

	public List<ProgatePortalMenu> findBylayoutId(int layoutId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(layoutId) };

		List<ProgatePortalMenu> list = (List<ProgatePortalMenu>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_LAYOUTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProgatePortalMenu WHERE ");

				query.append("layout_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(layoutId);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProgatePortalMenu>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_LAYOUTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProgatePortalMenu> findBylayoutId(int layoutId, int start,
		int end) throws SystemException {
		return findBylayoutId(layoutId, start, end, null);
	}

	public List<ProgatePortalMenu> findBylayoutId(int layoutId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(layoutId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProgatePortalMenu> list = (List<ProgatePortalMenu>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_LAYOUTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProgatePortalMenu WHERE ");

				query.append("layout_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(layoutId);

				list = (List<ProgatePortalMenu>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProgatePortalMenu>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_LAYOUTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProgatePortalMenu findBylayoutId_First(int layoutId,
		OrderByComparator obc)
		throws NoSuchProgatePortalMenuException, SystemException {
		List<ProgatePortalMenu> list = findBylayoutId(layoutId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProgatePortalMenu exists with the key {");

			msg.append("layoutId=" + layoutId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProgatePortalMenuException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProgatePortalMenu findBylayoutId_Last(int layoutId,
		OrderByComparator obc)
		throws NoSuchProgatePortalMenuException, SystemException {
		int count = countBylayoutId(layoutId);

		List<ProgatePortalMenu> list = findBylayoutId(layoutId, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProgatePortalMenu exists with the key {");

			msg.append("layoutId=" + layoutId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProgatePortalMenuException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProgatePortalMenu[] findBylayoutId_PrevAndNext(
		Integer portalMenuId, int layoutId, OrderByComparator obc)
		throws NoSuchProgatePortalMenuException, SystemException {
		ProgatePortalMenu progatePortalMenu = findByPrimaryKey(portalMenuId);

		int count = countBylayoutId(layoutId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.ProgatePortalMenu WHERE ");

			query.append("layout_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(layoutId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					progatePortalMenu);

			ProgatePortalMenu[] array = new ProgatePortalMenuImpl[3];

			array[0] = (ProgatePortalMenu)objArray[0];
			array[1] = (ProgatePortalMenu)objArray[1];
			array[2] = (ProgatePortalMenu)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProgatePortalMenu> findByroleId(int roleId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(roleId) };

		List<ProgatePortalMenu> list = (List<ProgatePortalMenu>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ROLEID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProgatePortalMenu WHERE ");

				query.append("role_id = ?");

				query.append(" ");

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
					list = new ArrayList<ProgatePortalMenu>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ROLEID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProgatePortalMenu> findByroleId(int roleId, int start, int end)
		throws SystemException {
		return findByroleId(roleId, start, end, null);
	}

	public List<ProgatePortalMenu> findByroleId(int roleId, int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(roleId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProgatePortalMenu> list = (List<ProgatePortalMenu>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ROLEID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProgatePortalMenu WHERE ");

				query.append("role_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(roleId);

				list = (List<ProgatePortalMenu>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProgatePortalMenu>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ROLEID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProgatePortalMenu findByroleId_First(int roleId,
		OrderByComparator obc)
		throws NoSuchProgatePortalMenuException, SystemException {
		List<ProgatePortalMenu> list = findByroleId(roleId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProgatePortalMenu exists with the key {");

			msg.append("roleId=" + roleId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProgatePortalMenuException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProgatePortalMenu findByroleId_Last(int roleId, OrderByComparator obc)
		throws NoSuchProgatePortalMenuException, SystemException {
		int count = countByroleId(roleId);

		List<ProgatePortalMenu> list = findByroleId(roleId, count - 1, count,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProgatePortalMenu exists with the key {");

			msg.append("roleId=" + roleId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProgatePortalMenuException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProgatePortalMenu[] findByroleId_PrevAndNext(Integer portalMenuId,
		int roleId, OrderByComparator obc)
		throws NoSuchProgatePortalMenuException, SystemException {
		ProgatePortalMenu progatePortalMenu = findByPrimaryKey(portalMenuId);

		int count = countByroleId(roleId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.ProgatePortalMenu WHERE ");

			query.append("role_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(roleId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					progatePortalMenu);

			ProgatePortalMenu[] array = new ProgatePortalMenuImpl[3];

			array[0] = (ProgatePortalMenu)objArray[0];
			array[1] = (ProgatePortalMenu)objArray[1];
			array[2] = (ProgatePortalMenu)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProgatePortalMenu> findByorgId(int orgId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(orgId) };

		List<ProgatePortalMenu> list = (List<ProgatePortalMenu>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ORGID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProgatePortalMenu WHERE ");

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
					list = new ArrayList<ProgatePortalMenu>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ORGID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProgatePortalMenu> findByorgId(int orgId, int start, int end)
		throws SystemException {
		return findByorgId(orgId, start, end, null);
	}

	public List<ProgatePortalMenu> findByorgId(int orgId, int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(orgId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProgatePortalMenu> list = (List<ProgatePortalMenu>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ORGID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProgatePortalMenu WHERE ");

				query.append("org_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orgId);

				list = (List<ProgatePortalMenu>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProgatePortalMenu>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ORGID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProgatePortalMenu findByorgId_First(int orgId, OrderByComparator obc)
		throws NoSuchProgatePortalMenuException, SystemException {
		List<ProgatePortalMenu> list = findByorgId(orgId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProgatePortalMenu exists with the key {");

			msg.append("orgId=" + orgId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProgatePortalMenuException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProgatePortalMenu findByorgId_Last(int orgId, OrderByComparator obc)
		throws NoSuchProgatePortalMenuException, SystemException {
		int count = countByorgId(orgId);

		List<ProgatePortalMenu> list = findByorgId(orgId, count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProgatePortalMenu exists with the key {");

			msg.append("orgId=" + orgId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProgatePortalMenuException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProgatePortalMenu[] findByorgId_PrevAndNext(Integer portalMenuId,
		int orgId, OrderByComparator obc)
		throws NoSuchProgatePortalMenuException, SystemException {
		ProgatePortalMenu progatePortalMenu = findByPrimaryKey(portalMenuId);

		int count = countByorgId(orgId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.ProgatePortalMenu WHERE ");

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
					progatePortalMenu);

			ProgatePortalMenu[] array = new ProgatePortalMenuImpl[3];

			array[0] = (ProgatePortalMenu)objArray[0];
			array[1] = (ProgatePortalMenu)objArray[1];
			array[2] = (ProgatePortalMenu)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProgatePortalMenu> findByname(String name)
		throws SystemException {
		Object[] finderArgs = new Object[] { name };

		List<ProgatePortalMenu> list = (List<ProgatePortalMenu>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_NAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProgatePortalMenu WHERE ");

				if (name == null) {
					query.append("menu_name LIKE null");
				}
				else {
					query.append("menu_name LIKE ?");
				}

				query.append(" ");

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
					list = new ArrayList<ProgatePortalMenu>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_NAME, finderArgs,
					list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProgatePortalMenu> findByname(String name, int start, int end)
		throws SystemException {
		return findByname(name, start, end, null);
	}

	public List<ProgatePortalMenu> findByname(String name, int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				name,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProgatePortalMenu> list = (List<ProgatePortalMenu>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_NAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProgatePortalMenu WHERE ");

				if (name == null) {
					query.append("menu_name LIKE null");
				}
				else {
					query.append("menu_name LIKE ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (name != null) {
					qPos.add(name);
				}

				list = (List<ProgatePortalMenu>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProgatePortalMenu>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_NAME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProgatePortalMenu findByname_First(String name, OrderByComparator obc)
		throws NoSuchProgatePortalMenuException, SystemException {
		List<ProgatePortalMenu> list = findByname(name, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProgatePortalMenu exists with the key {");

			msg.append("name=" + name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProgatePortalMenuException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProgatePortalMenu findByname_Last(String name, OrderByComparator obc)
		throws NoSuchProgatePortalMenuException, SystemException {
		int count = countByname(name);

		List<ProgatePortalMenu> list = findByname(name, count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProgatePortalMenu exists with the key {");

			msg.append("name=" + name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProgatePortalMenuException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProgatePortalMenu[] findByname_PrevAndNext(Integer portalMenuId,
		String name, OrderByComparator obc)
		throws NoSuchProgatePortalMenuException, SystemException {
		ProgatePortalMenu progatePortalMenu = findByPrimaryKey(portalMenuId);

		int count = countByname(name);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.ProgatePortalMenu WHERE ");

			if (name == null) {
				query.append("menu_name LIKE null");
			}
			else {
				query.append("menu_name LIKE ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (name != null) {
				qPos.add(name);
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					progatePortalMenu);

			ProgatePortalMenu[] array = new ProgatePortalMenuImpl[3];

			array[0] = (ProgatePortalMenu)objArray[0];
			array[1] = (ProgatePortalMenu)objArray[1];
			array[2] = (ProgatePortalMenu)objArray[2];

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

	public List<ProgatePortalMenu> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<ProgatePortalMenu> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<ProgatePortalMenu> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProgatePortalMenu> list = (List<ProgatePortalMenu>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.ProgatePortalMenu ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<ProgatePortalMenu>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ProgatePortalMenu>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProgatePortalMenu>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeBylayoutId(int layoutId) throws SystemException {
		for (ProgatePortalMenu progatePortalMenu : findBylayoutId(layoutId)) {
			remove(progatePortalMenu);
		}
	}

	public void removeByroleId(int roleId) throws SystemException {
		for (ProgatePortalMenu progatePortalMenu : findByroleId(roleId)) {
			remove(progatePortalMenu);
		}
	}

	public void removeByorgId(int orgId) throws SystemException {
		for (ProgatePortalMenu progatePortalMenu : findByorgId(orgId)) {
			remove(progatePortalMenu);
		}
	}

	public void removeByname(String name) throws SystemException {
		for (ProgatePortalMenu progatePortalMenu : findByname(name)) {
			remove(progatePortalMenu);
		}
	}

	public void removeAll() throws SystemException {
		for (ProgatePortalMenu progatePortalMenu : findAll()) {
			remove(progatePortalMenu);
		}
	}

	public int countBylayoutId(int layoutId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(layoutId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_LAYOUTID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProgatePortalMenu WHERE ");

				query.append("layout_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(layoutId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LAYOUTID,
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
					"FROM larion.progate.model.ProgatePortalMenu WHERE ");

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

	public int countByorgId(int orgId) throws SystemException {
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
					"FROM larion.progate.model.ProgatePortalMenu WHERE ");

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
				query.append(
					"FROM larion.progate.model.ProgatePortalMenu WHERE ");

				if (name == null) {
					query.append("menu_name LIKE null");
				}
				else {
					query.append("menu_name LIKE ?");
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

	public int countAll() throws SystemException {
		Object[] finderArgs = new Object[0];

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(
						"SELECT COUNT(*) FROM larion.progate.model.ProgatePortalMenu");

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
						"value.object.listener.larion.progate.model.ProgatePortalMenu")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ProgatePortalMenu>> listenersList = new ArrayList<ModelListener<ProgatePortalMenu>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ProgatePortalMenu>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(ProgatePortalMenuPersistenceImpl.class);
}