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
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import larion.progate.NoSuchViewProGatePermissionsRolesException;

import larion.progate.model.ViewProGatePermissionsRoles;
import larion.progate.model.impl.ViewProGatePermissionsRolesImpl;
import larion.progate.model.impl.ViewProGatePermissionsRolesModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="ViewProGatePermissionsRolesPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ViewProGatePermissionsRolesPersistenceImpl
	extends BasePersistenceImpl
	implements ViewProGatePermissionsRolesPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = ViewProGatePermissionsRolesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(ViewProGatePermissionsRolesModelImpl.ENTITY_CACHE_ENABLED,
			ViewProGatePermissionsRolesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ViewProGatePermissionsRolesModelImpl.ENTITY_CACHE_ENABLED,
			ViewProGatePermissionsRolesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(
		ViewProGatePermissionsRoles viewProGatePermissionsRoles) {
		EntityCacheUtil.putResult(ViewProGatePermissionsRolesModelImpl.ENTITY_CACHE_ENABLED,
			ViewProGatePermissionsRolesImpl.class,
			viewProGatePermissionsRoles.getPrimaryKey(),
			viewProGatePermissionsRoles);
	}

	public void cacheResult(
		List<ViewProGatePermissionsRoles> viewProGatePermissionsRoleses) {
		for (ViewProGatePermissionsRoles viewProGatePermissionsRoles : viewProGatePermissionsRoleses) {
			if (EntityCacheUtil.getResult(
						ViewProGatePermissionsRolesModelImpl.ENTITY_CACHE_ENABLED,
						ViewProGatePermissionsRolesImpl.class,
						viewProGatePermissionsRoles.getPrimaryKey(), this) == null) {
				cacheResult(viewProGatePermissionsRoles);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(ViewProGatePermissionsRolesImpl.class.getName());
		EntityCacheUtil.clearCache(ViewProGatePermissionsRolesImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public ViewProGatePermissionsRoles create(String ProGatePermissionsRolesId) {
		ViewProGatePermissionsRoles viewProGatePermissionsRoles = new ViewProGatePermissionsRolesImpl();

		viewProGatePermissionsRoles.setNew(true);
		viewProGatePermissionsRoles.setPrimaryKey(ProGatePermissionsRolesId);

		return viewProGatePermissionsRoles;
	}

	public ViewProGatePermissionsRoles remove(String ProGatePermissionsRolesId)
		throws NoSuchViewProGatePermissionsRolesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ViewProGatePermissionsRoles viewProGatePermissionsRoles = (ViewProGatePermissionsRoles)session.get(ViewProGatePermissionsRolesImpl.class,
					ProGatePermissionsRolesId);

			if (viewProGatePermissionsRoles == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No ViewProGatePermissionsRoles exists with the primary key " +
						ProGatePermissionsRolesId);
				}

				throw new NoSuchViewProGatePermissionsRolesException(
					"No ViewProGatePermissionsRoles exists with the primary key " +
					ProGatePermissionsRolesId);
			}

			return remove(viewProGatePermissionsRoles);
		}
		catch (NoSuchViewProGatePermissionsRolesException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public ViewProGatePermissionsRoles remove(
		ViewProGatePermissionsRoles viewProGatePermissionsRoles)
		throws SystemException {
		for (ModelListener<ViewProGatePermissionsRoles> listener : listeners) {
			listener.onBeforeRemove(viewProGatePermissionsRoles);
		}

		viewProGatePermissionsRoles = removeImpl(viewProGatePermissionsRoles);

		for (ModelListener<ViewProGatePermissionsRoles> listener : listeners) {
			listener.onAfterRemove(viewProGatePermissionsRoles);
		}

		return viewProGatePermissionsRoles;
	}

	protected ViewProGatePermissionsRoles removeImpl(
		ViewProGatePermissionsRoles viewProGatePermissionsRoles)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (viewProGatePermissionsRoles.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(ViewProGatePermissionsRolesImpl.class,
						viewProGatePermissionsRoles.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(viewProGatePermissionsRoles);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(ViewProGatePermissionsRolesModelImpl.ENTITY_CACHE_ENABLED,
			ViewProGatePermissionsRolesImpl.class,
			viewProGatePermissionsRoles.getPrimaryKey());

		return viewProGatePermissionsRoles;
	}

	public ViewProGatePermissionsRoles update(
		ViewProGatePermissionsRoles viewProGatePermissionsRoles)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(ViewProGatePermissionsRoles viewProGatePermissionsRoles) method. Use update(ViewProGatePermissionsRoles viewProGatePermissionsRoles, boolean merge) instead.");
		}

		return update(viewProGatePermissionsRoles, false);
	}

	public ViewProGatePermissionsRoles update(
		ViewProGatePermissionsRoles viewProGatePermissionsRoles, boolean merge)
		throws SystemException {
		boolean isNew = viewProGatePermissionsRoles.isNew();

		for (ModelListener<ViewProGatePermissionsRoles> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(viewProGatePermissionsRoles);
			}
			else {
				listener.onBeforeUpdate(viewProGatePermissionsRoles);
			}
		}

		viewProGatePermissionsRoles = updateImpl(viewProGatePermissionsRoles,
				merge);

		for (ModelListener<ViewProGatePermissionsRoles> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(viewProGatePermissionsRoles);
			}
			else {
				listener.onAfterUpdate(viewProGatePermissionsRoles);
			}
		}

		return viewProGatePermissionsRoles;
	}

	public ViewProGatePermissionsRoles updateImpl(
		larion.progate.model.ViewProGatePermissionsRoles viewProGatePermissionsRoles,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, viewProGatePermissionsRoles, merge);

			viewProGatePermissionsRoles.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(ViewProGatePermissionsRolesModelImpl.ENTITY_CACHE_ENABLED,
			ViewProGatePermissionsRolesImpl.class,
			viewProGatePermissionsRoles.getPrimaryKey(),
			viewProGatePermissionsRoles);

		return viewProGatePermissionsRoles;
	}

	public ViewProGatePermissionsRoles findByPrimaryKey(
		String ProGatePermissionsRolesId)
		throws NoSuchViewProGatePermissionsRolesException, SystemException {
		ViewProGatePermissionsRoles viewProGatePermissionsRoles = fetchByPrimaryKey(ProGatePermissionsRolesId);

		if (viewProGatePermissionsRoles == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"No ViewProGatePermissionsRoles exists with the primary key " +
					ProGatePermissionsRolesId);
			}

			throw new NoSuchViewProGatePermissionsRolesException(
				"No ViewProGatePermissionsRoles exists with the primary key " +
				ProGatePermissionsRolesId);
		}

		return viewProGatePermissionsRoles;
	}

	public ViewProGatePermissionsRoles fetchByPrimaryKey(
		String ProGatePermissionsRolesId) throws SystemException {
		ViewProGatePermissionsRoles viewProGatePermissionsRoles = (ViewProGatePermissionsRoles)EntityCacheUtil.getResult(ViewProGatePermissionsRolesModelImpl.ENTITY_CACHE_ENABLED,
				ViewProGatePermissionsRolesImpl.class,
				ProGatePermissionsRolesId, this);

		if (viewProGatePermissionsRoles == null) {
			Session session = null;

			try {
				session = openSession();

				viewProGatePermissionsRoles = (ViewProGatePermissionsRoles)session.get(ViewProGatePermissionsRolesImpl.class,
						ProGatePermissionsRolesId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (viewProGatePermissionsRoles != null) {
					cacheResult(viewProGatePermissionsRoles);
				}

				closeSession(session);
			}
		}

		return viewProGatePermissionsRoles;
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

	public List<ViewProGatePermissionsRoles> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<ViewProGatePermissionsRoles> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<ViewProGatePermissionsRoles> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ViewProGatePermissionsRoles> list = (List<ViewProGatePermissionsRoles>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ViewProGatePermissionsRoles ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<ViewProGatePermissionsRoles>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ViewProGatePermissionsRoles>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ViewProGatePermissionsRoles>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeAll() throws SystemException {
		for (ViewProGatePermissionsRoles viewProGatePermissionsRoles : findAll()) {
			remove(viewProGatePermissionsRoles);
		}
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
						"SELECT COUNT(*) FROM larion.progate.model.ViewProGatePermissionsRoles");

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
						"value.object.listener.larion.progate.model.ViewProGatePermissionsRoles")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ViewProGatePermissionsRoles>> listenersList = new ArrayList<ModelListener<ViewProGatePermissionsRoles>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ViewProGatePermissionsRoles>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(ViewProGatePermissionsRolesPersistenceImpl.class);
}