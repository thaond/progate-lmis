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

package larion.progate.cds.service.persistence;

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

import larion.progate.cds.NoSuchViewEmployeesInProjectsException;
import larion.progate.cds.model.ViewEmployeesInProjects;
import larion.progate.cds.model.impl.ViewEmployeesInProjectsImpl;
import larion.progate.cds.model.impl.ViewEmployeesInProjectsModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="ViewEmployeesInProjectsPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ViewEmployeesInProjectsPersistenceImpl extends BasePersistenceImpl
	implements ViewEmployeesInProjectsPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = ViewEmployeesInProjectsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_ROOTID = new FinderPath(ViewEmployeesInProjectsModelImpl.ENTITY_CACHE_ENABLED,
			ViewEmployeesInProjectsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ROOTID = new FinderPath(ViewEmployeesInProjectsModelImpl.ENTITY_CACHE_ENABLED,
			ViewEmployeesInProjectsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ROOTID = new FinderPath(ViewEmployeesInProjectsModelImpl.ENTITY_CACHE_ENABLED,
			ViewEmployeesInProjectsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByRootId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ORGID = new FinderPath(ViewEmployeesInProjectsModelImpl.ENTITY_CACHE_ENABLED,
			ViewEmployeesInProjectsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOrgId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ORGID = new FinderPath(ViewEmployeesInProjectsModelImpl.ENTITY_CACHE_ENABLED,
			ViewEmployeesInProjectsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOrgId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGID = new FinderPath(ViewEmployeesInProjectsModelImpl.ENTITY_CACHE_ENABLED,
			ViewEmployeesInProjectsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByOrgId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(ViewEmployeesInProjectsModelImpl.ENTITY_CACHE_ENABLED,
			ViewEmployeesInProjectsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ViewEmployeesInProjectsModelImpl.ENTITY_CACHE_ENABLED,
			ViewEmployeesInProjectsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(ViewEmployeesInProjects viewEmployeesInProjects) {
		EntityCacheUtil.putResult(ViewEmployeesInProjectsModelImpl.ENTITY_CACHE_ENABLED,
			ViewEmployeesInProjectsImpl.class,
			viewEmployeesInProjects.getPrimaryKey(), viewEmployeesInProjects);
	}

	public void cacheResult(
		List<ViewEmployeesInProjects> viewEmployeesInProjectses) {
		for (ViewEmployeesInProjects viewEmployeesInProjects : viewEmployeesInProjectses) {
			if (EntityCacheUtil.getResult(
						ViewEmployeesInProjectsModelImpl.ENTITY_CACHE_ENABLED,
						ViewEmployeesInProjectsImpl.class,
						viewEmployeesInProjects.getPrimaryKey(), this) == null) {
				cacheResult(viewEmployeesInProjects);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(ViewEmployeesInProjectsImpl.class.getName());
		EntityCacheUtil.clearCache(ViewEmployeesInProjectsImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public ViewEmployeesInProjects create(String id) {
		ViewEmployeesInProjects viewEmployeesInProjects = new ViewEmployeesInProjectsImpl();

		viewEmployeesInProjects.setNew(true);
		viewEmployeesInProjects.setPrimaryKey(id);

		return viewEmployeesInProjects;
	}

	public ViewEmployeesInProjects remove(String id)
		throws NoSuchViewEmployeesInProjectsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ViewEmployeesInProjects viewEmployeesInProjects = (ViewEmployeesInProjects)session.get(ViewEmployeesInProjectsImpl.class,
					id);

			if (viewEmployeesInProjects == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No ViewEmployeesInProjects exists with the primary key " +
						id);
				}

				throw new NoSuchViewEmployeesInProjectsException(
					"No ViewEmployeesInProjects exists with the primary key " +
					id);
			}

			return remove(viewEmployeesInProjects);
		}
		catch (NoSuchViewEmployeesInProjectsException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public ViewEmployeesInProjects remove(
		ViewEmployeesInProjects viewEmployeesInProjects)
		throws SystemException {
		for (ModelListener<ViewEmployeesInProjects> listener : listeners) {
			listener.onBeforeRemove(viewEmployeesInProjects);
		}

		viewEmployeesInProjects = removeImpl(viewEmployeesInProjects);

		for (ModelListener<ViewEmployeesInProjects> listener : listeners) {
			listener.onAfterRemove(viewEmployeesInProjects);
		}

		return viewEmployeesInProjects;
	}

	protected ViewEmployeesInProjects removeImpl(
		ViewEmployeesInProjects viewEmployeesInProjects)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (viewEmployeesInProjects.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(ViewEmployeesInProjectsImpl.class,
						viewEmployeesInProjects.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(viewEmployeesInProjects);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(ViewEmployeesInProjectsModelImpl.ENTITY_CACHE_ENABLED,
			ViewEmployeesInProjectsImpl.class,
			viewEmployeesInProjects.getPrimaryKey());

		return viewEmployeesInProjects;
	}

	public ViewEmployeesInProjects update(
		ViewEmployeesInProjects viewEmployeesInProjects)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(ViewEmployeesInProjects viewEmployeesInProjects) method. Use update(ViewEmployeesInProjects viewEmployeesInProjects, boolean merge) instead.");
		}

		return update(viewEmployeesInProjects, false);
	}

	public ViewEmployeesInProjects update(
		ViewEmployeesInProjects viewEmployeesInProjects, boolean merge)
		throws SystemException {
		boolean isNew = viewEmployeesInProjects.isNew();

		for (ModelListener<ViewEmployeesInProjects> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(viewEmployeesInProjects);
			}
			else {
				listener.onBeforeUpdate(viewEmployeesInProjects);
			}
		}

		viewEmployeesInProjects = updateImpl(viewEmployeesInProjects, merge);

		for (ModelListener<ViewEmployeesInProjects> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(viewEmployeesInProjects);
			}
			else {
				listener.onAfterUpdate(viewEmployeesInProjects);
			}
		}

		return viewEmployeesInProjects;
	}

	public ViewEmployeesInProjects updateImpl(
		larion.progate.cds.model.ViewEmployeesInProjects viewEmployeesInProjects,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, viewEmployeesInProjects, merge);

			viewEmployeesInProjects.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(ViewEmployeesInProjectsModelImpl.ENTITY_CACHE_ENABLED,
			ViewEmployeesInProjectsImpl.class,
			viewEmployeesInProjects.getPrimaryKey(), viewEmployeesInProjects);

		return viewEmployeesInProjects;
	}

	public ViewEmployeesInProjects findByPrimaryKey(String id)
		throws NoSuchViewEmployeesInProjectsException, SystemException {
		ViewEmployeesInProjects viewEmployeesInProjects = fetchByPrimaryKey(id);

		if (viewEmployeesInProjects == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"No ViewEmployeesInProjects exists with the primary key " +
					id);
			}

			throw new NoSuchViewEmployeesInProjectsException(
				"No ViewEmployeesInProjects exists with the primary key " + id);
		}

		return viewEmployeesInProjects;
	}

	public ViewEmployeesInProjects fetchByPrimaryKey(String id)
		throws SystemException {
		ViewEmployeesInProjects viewEmployeesInProjects = (ViewEmployeesInProjects)EntityCacheUtil.getResult(ViewEmployeesInProjectsModelImpl.ENTITY_CACHE_ENABLED,
				ViewEmployeesInProjectsImpl.class, id, this);

		if (viewEmployeesInProjects == null) {
			Session session = null;

			try {
				session = openSession();

				viewEmployeesInProjects = (ViewEmployeesInProjects)session.get(ViewEmployeesInProjectsImpl.class,
						id);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (viewEmployeesInProjects != null) {
					cacheResult(viewEmployeesInProjects);
				}

				closeSession(session);
			}
		}

		return viewEmployeesInProjects;
	}

	public List<ViewEmployeesInProjects> findByRootId(int rootId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		List<ViewEmployeesInProjects> list = (List<ViewEmployeesInProjects>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.ViewEmployeesInProjects WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("firstname ASC, ");
				query.append("lastname ASC");

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
					list = new ArrayList<ViewEmployeesInProjects>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ViewEmployeesInProjects> findByRootId(int rootId, int start,
		int end) throws SystemException {
		return findByRootId(rootId, start, end, null);
	}

	public List<ViewEmployeesInProjects> findByRootId(int rootId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(rootId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ViewEmployeesInProjects> list = (List<ViewEmployeesInProjects>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.ViewEmployeesInProjects WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("firstname ASC, ");
					query.append("lastname ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rootId);

				list = (List<ViewEmployeesInProjects>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ViewEmployeesInProjects>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ViewEmployeesInProjects findByRootId_First(int rootId,
		OrderByComparator obc)
		throws NoSuchViewEmployeesInProjectsException, SystemException {
		List<ViewEmployeesInProjects> list = findByRootId(rootId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ViewEmployeesInProjects exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchViewEmployeesInProjectsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ViewEmployeesInProjects findByRootId_Last(int rootId,
		OrderByComparator obc)
		throws NoSuchViewEmployeesInProjectsException, SystemException {
		int count = countByRootId(rootId);

		List<ViewEmployeesInProjects> list = findByRootId(rootId, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ViewEmployeesInProjects exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchViewEmployeesInProjectsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ViewEmployeesInProjects[] findByRootId_PrevAndNext(String id,
		int rootId, OrderByComparator obc)
		throws NoSuchViewEmployeesInProjectsException, SystemException {
		ViewEmployeesInProjects viewEmployeesInProjects = findByPrimaryKey(id);

		int count = countByRootId(rootId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.cds.model.ViewEmployeesInProjects WHERE ");

			query.append("root_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("firstname ASC, ");
				query.append("lastname ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(rootId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					viewEmployeesInProjects);

			ViewEmployeesInProjects[] array = new ViewEmployeesInProjectsImpl[3];

			array[0] = (ViewEmployeesInProjects)objArray[0];
			array[1] = (ViewEmployeesInProjects)objArray[1];
			array[2] = (ViewEmployeesInProjects)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ViewEmployeesInProjects> findByOrgId(int orgId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(orgId) };

		List<ViewEmployeesInProjects> list = (List<ViewEmployeesInProjects>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ORGID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.ViewEmployeesInProjects WHERE ");

				query.append("org_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("firstname ASC, ");
				query.append("lastname ASC");

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
					list = new ArrayList<ViewEmployeesInProjects>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ORGID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ViewEmployeesInProjects> findByOrgId(int orgId, int start,
		int end) throws SystemException {
		return findByOrgId(orgId, start, end, null);
	}

	public List<ViewEmployeesInProjects> findByOrgId(int orgId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(orgId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ViewEmployeesInProjects> list = (List<ViewEmployeesInProjects>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ORGID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.ViewEmployeesInProjects WHERE ");

				query.append("org_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("firstname ASC, ");
					query.append("lastname ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orgId);

				list = (List<ViewEmployeesInProjects>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ViewEmployeesInProjects>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ORGID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ViewEmployeesInProjects findByOrgId_First(int orgId,
		OrderByComparator obc)
		throws NoSuchViewEmployeesInProjectsException, SystemException {
		List<ViewEmployeesInProjects> list = findByOrgId(orgId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ViewEmployeesInProjects exists with the key {");

			msg.append("orgId=" + orgId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchViewEmployeesInProjectsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ViewEmployeesInProjects findByOrgId_Last(int orgId,
		OrderByComparator obc)
		throws NoSuchViewEmployeesInProjectsException, SystemException {
		int count = countByOrgId(orgId);

		List<ViewEmployeesInProjects> list = findByOrgId(orgId, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ViewEmployeesInProjects exists with the key {");

			msg.append("orgId=" + orgId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchViewEmployeesInProjectsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ViewEmployeesInProjects[] findByOrgId_PrevAndNext(String id,
		int orgId, OrderByComparator obc)
		throws NoSuchViewEmployeesInProjectsException, SystemException {
		ViewEmployeesInProjects viewEmployeesInProjects = findByPrimaryKey(id);

		int count = countByOrgId(orgId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.cds.model.ViewEmployeesInProjects WHERE ");

			query.append("org_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("firstname ASC, ");
				query.append("lastname ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(orgId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					viewEmployeesInProjects);

			ViewEmployeesInProjects[] array = new ViewEmployeesInProjectsImpl[3];

			array[0] = (ViewEmployeesInProjects)objArray[0];
			array[1] = (ViewEmployeesInProjects)objArray[1];
			array[2] = (ViewEmployeesInProjects)objArray[2];

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

	public List<ViewEmployeesInProjects> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<ViewEmployeesInProjects> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<ViewEmployeesInProjects> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ViewEmployeesInProjects> list = (List<ViewEmployeesInProjects>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.ViewEmployeesInProjects ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("firstname ASC, ");
					query.append("lastname ASC");
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<ViewEmployeesInProjects>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ViewEmployeesInProjects>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ViewEmployeesInProjects>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByRootId(int rootId) throws SystemException {
		for (ViewEmployeesInProjects viewEmployeesInProjects : findByRootId(
				rootId)) {
			remove(viewEmployeesInProjects);
		}
	}

	public void removeByOrgId(int orgId) throws SystemException {
		for (ViewEmployeesInProjects viewEmployeesInProjects : findByOrgId(
				orgId)) {
			remove(viewEmployeesInProjects);
		}
	}

	public void removeAll() throws SystemException {
		for (ViewEmployeesInProjects viewEmployeesInProjects : findAll()) {
			remove(viewEmployeesInProjects);
		}
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
					"FROM larion.progate.cds.model.ViewEmployeesInProjects WHERE ");

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
					"FROM larion.progate.cds.model.ViewEmployeesInProjects WHERE ");

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

	public int countAll() throws SystemException {
		Object[] finderArgs = new Object[0];

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(
						"SELECT COUNT(*) FROM larion.progate.cds.model.ViewEmployeesInProjects");

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
						"value.object.listener.larion.progate.cds.model.ViewEmployeesInProjects")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ViewEmployeesInProjects>> listenersList = new ArrayList<ModelListener<ViewEmployeesInProjects>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ViewEmployeesInProjects>)Class.forName(
							listenerClassName).newInstance());
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	@BeanReference(name = "larion.progate.cds.service.persistence.CompetencyPersistence.impl")
	protected larion.progate.cds.service.persistence.CompetencyPersistence competencyPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.LevelPersistence.impl")
	protected larion.progate.cds.service.persistence.LevelPersistence levelPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.SlotPersistence.impl")
	protected larion.progate.cds.service.persistence.SlotPersistence slotPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPointsPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsPointsPersistence cdsPointsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsEvaluationPeriodsPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsEvaluationPeriodsPersistence cdsEvaluationPeriodsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsTitlesPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsTitlesPersistence cdsTitlesPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsTitleCompetenciesPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsTitleCompetenciesPersistence cdsTitleCompetenciesPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsMinimumRequirementsPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsMinimumRequirementsPersistence cdsMinimumRequirementsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsTitleMinimumRequirementsPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsTitleMinimumRequirementsPersistence cdsTitleMinimumRequirementsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsMinimumRequirementLevelsPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsMinimumRequirementLevelsPersistence cdsMinimumRequirementLevelsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewListTitleCompetenciesPersistence.impl")
	protected larion.progate.cds.service.persistence.ViewListTitleCompetenciesPersistence viewListTitleCompetenciesPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewListTitleMinimumRequirementsPersistence.impl")
	protected larion.progate.cds.service.persistence.ViewListTitleMinimumRequirementsPersistence viewListTitleMinimumRequirementsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPAFinalCompeteniesPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsPAFinalCompeteniesPersistence cdsPAFinalCompeteniesPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPAFinalLevelsPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsPAFinalLevelsPersistence cdsPAFinalLevelsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPAFinalSlotsPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsPAFinalSlotsPersistence cdsPAFinalSlotsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewFinalCompetenciesPersistence.impl")
	protected larion.progate.cds.service.persistence.ViewFinalCompetenciesPersistence viewFinalCompetenciesPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewFinalLevelsPersistence.impl")
	protected larion.progate.cds.service.persistence.ViewFinalLevelsPersistence viewFinalLevelsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewFinalSlotsPersistence.impl")
	protected larion.progate.cds.service.persistence.ViewFinalSlotsPersistence viewFinalSlotsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewFinalTitlesPersistence.impl")
	protected larion.progate.cds.service.persistence.ViewFinalTitlesPersistence viewFinalTitlesPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewSlotInformationPersistence.impl")
	protected larion.progate.cds.service.persistence.ViewSlotInformationPersistence viewSlotInformationPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPASlotsPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsPASlotsPersistence cdsPASlotsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPALevelsPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsPALevelsPersistence cdsPALevelsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPACompetenciesPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsPACompetenciesPersistence cdsPACompetenciesPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewPerformanceAppraisalLevelsPersistence.impl")
	protected larion.progate.cds.service.persistence.ViewPerformanceAppraisalLevelsPersistence viewPerformanceAppraisalLevelsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewPerformanceAppraisalSlotsPersistence.impl")
	protected larion.progate.cds.service.persistence.ViewPerformanceAppraisalSlotsPersistence viewPerformanceAppraisalSlotsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPerformanceAppraisalSlotRatingPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsPerformanceAppraisalSlotRatingPersistence cdsPerformanceAppraisalSlotRatingPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPerformanceAppraisalSlotCommentsPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsPerformanceAppraisalSlotCommentsPersistence cdsPerformanceAppraisalSlotCommentsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPerformanceAppraisalsPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsPerformanceAppraisalsPersistence cdsPerformanceAppraisalsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewEmployeesInProjectsPersistence.impl")
	protected larion.progate.cds.service.persistence.ViewEmployeesInProjectsPersistence viewEmployeesInProjectsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewEmployeesSlotsRatingPersistence.impl")
	protected larion.progate.cds.service.persistence.ViewEmployeesSlotsRatingPersistence viewEmployeesSlotsRatingPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsSlotStatisticalReportPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsSlotStatisticalReportPersistence cdsSlotStatisticalReportPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsLevelStatisticalReportPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsLevelStatisticalReportPersistence cdsLevelStatisticalReportPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsCompetencyStatisticalReportPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsCompetencyStatisticalReportPersistence cdsCompetencyStatisticalReportPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsCdpPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsCdpPersistence cdsCdpPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPAFinalPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsPAFinalPersistence cdsPAFinalPersistence;
	private static Log _log = LogFactoryUtil.getLog(ViewEmployeesInProjectsPersistenceImpl.class);
}