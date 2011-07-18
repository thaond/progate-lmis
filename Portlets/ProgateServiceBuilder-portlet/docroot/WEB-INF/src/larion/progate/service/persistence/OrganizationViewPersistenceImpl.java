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

import larion.progate.NoSuchOrganizationViewException;

import larion.progate.model.OrganizationView;
import larion.progate.model.impl.OrganizationViewImpl;
import larion.progate.model.impl.OrganizationViewModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="OrganizationViewPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class OrganizationViewPersistenceImpl extends BasePersistenceImpl
	implements OrganizationViewPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = OrganizationViewImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_ORGNAME = new FinderPath(OrganizationViewModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByorgName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ORGNAME = new FinderPath(OrganizationViewModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByorgName",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGNAME = new FinderPath(OrganizationViewModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByorgName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ORGNAMELOWER = new FinderPath(OrganizationViewModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByorgNameLower",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ORGNAMELOWER = new FinderPath(OrganizationViewModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByorgNameLower",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGNAMELOWER = new FinderPath(OrganizationViewModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByorgNameLower",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_COUNTPRODUCT = new FinderPath(OrganizationViewModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycountProduct",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_COUNTPRODUCT = new FinderPath(OrganizationViewModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycountProduct",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_COUNTPRODUCT = new FinderPath(OrganizationViewModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBycountProduct",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(OrganizationViewModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OrganizationViewModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(OrganizationView organizationView) {
		EntityCacheUtil.putResult(OrganizationViewModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationViewImpl.class, organizationView.getPrimaryKey(),
			organizationView);
	}

	public void cacheResult(List<OrganizationView> organizationViews) {
		for (OrganizationView organizationView : organizationViews) {
			if (EntityCacheUtil.getResult(
						OrganizationViewModelImpl.ENTITY_CACHE_ENABLED,
						OrganizationViewImpl.class,
						organizationView.getPrimaryKey(), this) == null) {
				cacheResult(organizationView);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(OrganizationViewImpl.class.getName());
		EntityCacheUtil.clearCache(OrganizationViewImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public OrganizationView create(int orgId) {
		OrganizationView organizationView = new OrganizationViewImpl();

		organizationView.setNew(true);
		organizationView.setPrimaryKey(orgId);

		return organizationView;
	}

	public OrganizationView remove(int orgId)
		throws NoSuchOrganizationViewException, SystemException {
		Session session = null;

		try {
			session = openSession();

			OrganizationView organizationView = (OrganizationView)session.get(OrganizationViewImpl.class,
					new Integer(orgId));

			if (organizationView == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No OrganizationView exists with the primary key " +
						orgId);
				}

				throw new NoSuchOrganizationViewException(
					"No OrganizationView exists with the primary key " + orgId);
			}

			return remove(organizationView);
		}
		catch (NoSuchOrganizationViewException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public OrganizationView remove(OrganizationView organizationView)
		throws SystemException {
		for (ModelListener<OrganizationView> listener : listeners) {
			listener.onBeforeRemove(organizationView);
		}

		organizationView = removeImpl(organizationView);

		for (ModelListener<OrganizationView> listener : listeners) {
			listener.onAfterRemove(organizationView);
		}

		return organizationView;
	}

	protected OrganizationView removeImpl(OrganizationView organizationView)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (organizationView.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(OrganizationViewImpl.class,
						organizationView.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(organizationView);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(OrganizationViewModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationViewImpl.class, organizationView.getPrimaryKey());

		return organizationView;
	}

	public OrganizationView update(OrganizationView organizationView)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(OrganizationView organizationView) method. Use update(OrganizationView organizationView, boolean merge) instead.");
		}

		return update(organizationView, false);
	}

	public OrganizationView update(OrganizationView organizationView,
		boolean merge) throws SystemException {
		boolean isNew = organizationView.isNew();

		for (ModelListener<OrganizationView> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(organizationView);
			}
			else {
				listener.onBeforeUpdate(organizationView);
			}
		}

		organizationView = updateImpl(organizationView, merge);

		for (ModelListener<OrganizationView> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(organizationView);
			}
			else {
				listener.onAfterUpdate(organizationView);
			}
		}

		return organizationView;
	}

	public OrganizationView updateImpl(
		larion.progate.model.OrganizationView organizationView, boolean merge)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, organizationView, merge);

			organizationView.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(OrganizationViewModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationViewImpl.class, organizationView.getPrimaryKey(),
			organizationView);

		return organizationView;
	}

	public OrganizationView findByPrimaryKey(int orgId)
		throws NoSuchOrganizationViewException, SystemException {
		OrganizationView organizationView = fetchByPrimaryKey(orgId);

		if (organizationView == null) {
			if (_log.isWarnEnabled()) {
				_log.warn("No OrganizationView exists with the primary key " +
					orgId);
			}

			throw new NoSuchOrganizationViewException(
				"No OrganizationView exists with the primary key " + orgId);
		}

		return organizationView;
	}

	public OrganizationView fetchByPrimaryKey(int orgId)
		throws SystemException {
		OrganizationView organizationView = (OrganizationView)EntityCacheUtil.getResult(OrganizationViewModelImpl.ENTITY_CACHE_ENABLED,
				OrganizationViewImpl.class, orgId, this);

		if (organizationView == null) {
			Session session = null;

			try {
				session = openSession();

				organizationView = (OrganizationView)session.get(OrganizationViewImpl.class,
						new Integer(orgId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (organizationView != null) {
					cacheResult(organizationView);
				}

				closeSession(session);
			}
		}

		return organizationView;
	}

	public List<OrganizationView> findByorgName(String orgName)
		throws SystemException {
		Object[] finderArgs = new Object[] { orgName };

		List<OrganizationView> list = (List<OrganizationView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ORGNAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.OrganizationView WHERE ");

				if (orgName == null) {
					query.append("org_name LIKE null");
				}
				else {
					query.append("org_name LIKE ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("count_products DESC, ");
				query.append("org_name ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (orgName != null) {
					qPos.add(orgName);
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<OrganizationView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ORGNAME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<OrganizationView> findByorgName(String orgName, int start,
		int end) throws SystemException {
		return findByorgName(orgName, start, end, null);
	}

	public List<OrganizationView> findByorgName(String orgName, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				orgName,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<OrganizationView> list = (List<OrganizationView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ORGNAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.OrganizationView WHERE ");

				if (orgName == null) {
					query.append("org_name LIKE null");
				}
				else {
					query.append("org_name LIKE ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("count_products DESC, ");
					query.append("org_name ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (orgName != null) {
					qPos.add(orgName);
				}

				list = (List<OrganizationView>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<OrganizationView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ORGNAME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public OrganizationView findByorgName_First(String orgName,
		OrderByComparator obc)
		throws NoSuchOrganizationViewException, SystemException {
		List<OrganizationView> list = findByorgName(orgName, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No OrganizationView exists with the key {");

			msg.append("orgName=" + orgName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrganizationViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public OrganizationView findByorgName_Last(String orgName,
		OrderByComparator obc)
		throws NoSuchOrganizationViewException, SystemException {
		int count = countByorgName(orgName);

		List<OrganizationView> list = findByorgName(orgName, count - 1, count,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No OrganizationView exists with the key {");

			msg.append("orgName=" + orgName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrganizationViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public OrganizationView[] findByorgName_PrevAndNext(int orgId,
		String orgName, OrderByComparator obc)
		throws NoSuchOrganizationViewException, SystemException {
		OrganizationView organizationView = findByPrimaryKey(orgId);

		int count = countByorgName(orgName);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.OrganizationView WHERE ");

			if (orgName == null) {
				query.append("org_name LIKE null");
			}
			else {
				query.append("org_name LIKE ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("count_products DESC, ");
				query.append("org_name ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (orgName != null) {
				qPos.add(orgName);
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					organizationView);

			OrganizationView[] array = new OrganizationViewImpl[3];

			array[0] = (OrganizationView)objArray[0];
			array[1] = (OrganizationView)objArray[1];
			array[2] = (OrganizationView)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<OrganizationView> findByorgNameLower(String orgNameLower)
		throws SystemException {
		Object[] finderArgs = new Object[] { orgNameLower };

		List<OrganizationView> list = (List<OrganizationView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ORGNAMELOWER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.OrganizationView WHERE ");

				if (orgNameLower == null) {
					query.append("org_name_lower LIKE null");
				}
				else {
					query.append("org_name_lower LIKE ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("count_products DESC, ");
				query.append("org_name ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (orgNameLower != null) {
					qPos.add(orgNameLower);
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<OrganizationView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ORGNAMELOWER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<OrganizationView> findByorgNameLower(String orgNameLower,
		int start, int end) throws SystemException {
		return findByorgNameLower(orgNameLower, start, end, null);
	}

	public List<OrganizationView> findByorgNameLower(String orgNameLower,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				orgNameLower,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<OrganizationView> list = (List<OrganizationView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ORGNAMELOWER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.OrganizationView WHERE ");

				if (orgNameLower == null) {
					query.append("org_name_lower LIKE null");
				}
				else {
					query.append("org_name_lower LIKE ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("count_products DESC, ");
					query.append("org_name ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (orgNameLower != null) {
					qPos.add(orgNameLower);
				}

				list = (List<OrganizationView>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<OrganizationView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ORGNAMELOWER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public OrganizationView findByorgNameLower_First(String orgNameLower,
		OrderByComparator obc)
		throws NoSuchOrganizationViewException, SystemException {
		List<OrganizationView> list = findByorgNameLower(orgNameLower, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No OrganizationView exists with the key {");

			msg.append("orgNameLower=" + orgNameLower);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrganizationViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public OrganizationView findByorgNameLower_Last(String orgNameLower,
		OrderByComparator obc)
		throws NoSuchOrganizationViewException, SystemException {
		int count = countByorgNameLower(orgNameLower);

		List<OrganizationView> list = findByorgNameLower(orgNameLower,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No OrganizationView exists with the key {");

			msg.append("orgNameLower=" + orgNameLower);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrganizationViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public OrganizationView[] findByorgNameLower_PrevAndNext(int orgId,
		String orgNameLower, OrderByComparator obc)
		throws NoSuchOrganizationViewException, SystemException {
		OrganizationView organizationView = findByPrimaryKey(orgId);

		int count = countByorgNameLower(orgNameLower);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.OrganizationView WHERE ");

			if (orgNameLower == null) {
				query.append("org_name_lower LIKE null");
			}
			else {
				query.append("org_name_lower LIKE ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("count_products DESC, ");
				query.append("org_name ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (orgNameLower != null) {
				qPos.add(orgNameLower);
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					organizationView);

			OrganizationView[] array = new OrganizationViewImpl[3];

			array[0] = (OrganizationView)objArray[0];
			array[1] = (OrganizationView)objArray[1];
			array[2] = (OrganizationView)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<OrganizationView> findBycountProduct(int countProduct)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(countProduct) };

		List<OrganizationView> list = (List<OrganizationView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_COUNTPRODUCT,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.OrganizationView WHERE ");

				query.append("count_products LIKE ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("count_products DESC, ");
				query.append("org_name ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(countProduct);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<OrganizationView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_COUNTPRODUCT,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<OrganizationView> findBycountProduct(int countProduct,
		int start, int end) throws SystemException {
		return findBycountProduct(countProduct, start, end, null);
	}

	public List<OrganizationView> findBycountProduct(int countProduct,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(countProduct),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<OrganizationView> list = (List<OrganizationView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_COUNTPRODUCT,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.OrganizationView WHERE ");

				query.append("count_products LIKE ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("count_products DESC, ");
					query.append("org_name ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(countProduct);

				list = (List<OrganizationView>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<OrganizationView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_COUNTPRODUCT,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public OrganizationView findBycountProduct_First(int countProduct,
		OrderByComparator obc)
		throws NoSuchOrganizationViewException, SystemException {
		List<OrganizationView> list = findBycountProduct(countProduct, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No OrganizationView exists with the key {");

			msg.append("countProduct=" + countProduct);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrganizationViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public OrganizationView findBycountProduct_Last(int countProduct,
		OrderByComparator obc)
		throws NoSuchOrganizationViewException, SystemException {
		int count = countBycountProduct(countProduct);

		List<OrganizationView> list = findBycountProduct(countProduct,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No OrganizationView exists with the key {");

			msg.append("countProduct=" + countProduct);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrganizationViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public OrganizationView[] findBycountProduct_PrevAndNext(int orgId,
		int countProduct, OrderByComparator obc)
		throws NoSuchOrganizationViewException, SystemException {
		OrganizationView organizationView = findByPrimaryKey(orgId);

		int count = countBycountProduct(countProduct);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.OrganizationView WHERE ");

			query.append("count_products LIKE ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("count_products DESC, ");
				query.append("org_name ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(countProduct);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					organizationView);

			OrganizationView[] array = new OrganizationViewImpl[3];

			array[0] = (OrganizationView)objArray[0];
			array[1] = (OrganizationView)objArray[1];
			array[2] = (OrganizationView)objArray[2];

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

	public List<OrganizationView> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<OrganizationView> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<OrganizationView> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<OrganizationView> list = (List<OrganizationView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.OrganizationView ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("count_products DESC, ");
					query.append("org_name ASC");
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<OrganizationView>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<OrganizationView>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<OrganizationView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByorgName(String orgName) throws SystemException {
		for (OrganizationView organizationView : findByorgName(orgName)) {
			remove(organizationView);
		}
	}

	public void removeByorgNameLower(String orgNameLower)
		throws SystemException {
		for (OrganizationView organizationView : findByorgNameLower(
				orgNameLower)) {
			remove(organizationView);
		}
	}

	public void removeBycountProduct(int countProduct)
		throws SystemException {
		for (OrganizationView organizationView : findBycountProduct(
				countProduct)) {
			remove(organizationView);
		}
	}

	public void removeAll() throws SystemException {
		for (OrganizationView organizationView : findAll()) {
			remove(organizationView);
		}
	}

	public int countByorgName(String orgName) throws SystemException {
		Object[] finderArgs = new Object[] { orgName };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ORGNAME,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.OrganizationView WHERE ");

				if (orgName == null) {
					query.append("org_name LIKE null");
				}
				else {
					query.append("org_name LIKE ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (orgName != null) {
					qPos.add(orgName);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ORGNAME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByorgNameLower(String orgNameLower)
		throws SystemException {
		Object[] finderArgs = new Object[] { orgNameLower };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ORGNAMELOWER,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.OrganizationView WHERE ");

				if (orgNameLower == null) {
					query.append("org_name_lower LIKE null");
				}
				else {
					query.append("org_name_lower LIKE ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (orgNameLower != null) {
					qPos.add(orgNameLower);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ORGNAMELOWER,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countBycountProduct(int countProduct) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(countProduct) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COUNTPRODUCT,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.OrganizationView WHERE ");

				query.append("count_products LIKE ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(countProduct);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COUNTPRODUCT,
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
						"SELECT COUNT(*) FROM larion.progate.model.OrganizationView");

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
						"value.object.listener.larion.progate.model.OrganizationView")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<OrganizationView>> listenersList = new ArrayList<ModelListener<OrganizationView>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<OrganizationView>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(OrganizationViewPersistenceImpl.class);
}