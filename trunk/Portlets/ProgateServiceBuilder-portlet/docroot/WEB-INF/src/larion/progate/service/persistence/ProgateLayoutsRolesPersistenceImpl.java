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

import larion.progate.NoSuchProgateLayoutsRolesException;

import larion.progate.model.ProgateLayoutsRoles;
import larion.progate.model.impl.ProgateLayoutsRolesImpl;
import larion.progate.model.impl.ProgateLayoutsRolesModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="ProgateLayoutsRolesPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProgateLayoutsRolesPersistenceImpl extends BasePersistenceImpl
	implements ProgateLayoutsRolesPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = ProgateLayoutsRolesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(ProgateLayoutsRolesModelImpl.ENTITY_CACHE_ENABLED,
			ProgateLayoutsRolesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProgateLayoutsRolesModelImpl.ENTITY_CACHE_ENABLED,
			ProgateLayoutsRolesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(ProgateLayoutsRoles progateLayoutsRoles) {
		EntityCacheUtil.putResult(ProgateLayoutsRolesModelImpl.ENTITY_CACHE_ENABLED,
			ProgateLayoutsRolesImpl.class, progateLayoutsRoles.getPrimaryKey(),
			progateLayoutsRoles);
	}

	public void cacheResult(List<ProgateLayoutsRoles> progateLayoutsRoleses) {
		for (ProgateLayoutsRoles progateLayoutsRoles : progateLayoutsRoleses) {
			if (EntityCacheUtil.getResult(
						ProgateLayoutsRolesModelImpl.ENTITY_CACHE_ENABLED,
						ProgateLayoutsRolesImpl.class,
						progateLayoutsRoles.getPrimaryKey(), this) == null) {
				cacheResult(progateLayoutsRoles);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(ProgateLayoutsRolesImpl.class.getName());
		EntityCacheUtil.clearCache(ProgateLayoutsRolesImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public ProgateLayoutsRoles create(int ProgateLayoutsRolesId) {
		ProgateLayoutsRoles progateLayoutsRoles = new ProgateLayoutsRolesImpl();

		progateLayoutsRoles.setNew(true);
		progateLayoutsRoles.setPrimaryKey(ProgateLayoutsRolesId);

		return progateLayoutsRoles;
	}

	public ProgateLayoutsRoles remove(int ProgateLayoutsRolesId)
		throws NoSuchProgateLayoutsRolesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ProgateLayoutsRoles progateLayoutsRoles = (ProgateLayoutsRoles)session.get(ProgateLayoutsRolesImpl.class,
					new Integer(ProgateLayoutsRolesId));

			if (progateLayoutsRoles == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No ProgateLayoutsRoles exists with the primary key " +
						ProgateLayoutsRolesId);
				}

				throw new NoSuchProgateLayoutsRolesException(
					"No ProgateLayoutsRoles exists with the primary key " +
					ProgateLayoutsRolesId);
			}

			return remove(progateLayoutsRoles);
		}
		catch (NoSuchProgateLayoutsRolesException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public ProgateLayoutsRoles remove(ProgateLayoutsRoles progateLayoutsRoles)
		throws SystemException {
		for (ModelListener<ProgateLayoutsRoles> listener : listeners) {
			listener.onBeforeRemove(progateLayoutsRoles);
		}

		progateLayoutsRoles = removeImpl(progateLayoutsRoles);

		for (ModelListener<ProgateLayoutsRoles> listener : listeners) {
			listener.onAfterRemove(progateLayoutsRoles);
		}

		return progateLayoutsRoles;
	}

	protected ProgateLayoutsRoles removeImpl(
		ProgateLayoutsRoles progateLayoutsRoles) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (progateLayoutsRoles.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(ProgateLayoutsRolesImpl.class,
						progateLayoutsRoles.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(progateLayoutsRoles);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(ProgateLayoutsRolesModelImpl.ENTITY_CACHE_ENABLED,
			ProgateLayoutsRolesImpl.class, progateLayoutsRoles.getPrimaryKey());

		return progateLayoutsRoles;
	}

	public ProgateLayoutsRoles update(ProgateLayoutsRoles progateLayoutsRoles)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(ProgateLayoutsRoles progateLayoutsRoles) method. Use update(ProgateLayoutsRoles progateLayoutsRoles, boolean merge) instead.");
		}

		return update(progateLayoutsRoles, false);
	}

	public ProgateLayoutsRoles update(ProgateLayoutsRoles progateLayoutsRoles,
		boolean merge) throws SystemException {
		boolean isNew = progateLayoutsRoles.isNew();

		for (ModelListener<ProgateLayoutsRoles> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(progateLayoutsRoles);
			}
			else {
				listener.onBeforeUpdate(progateLayoutsRoles);
			}
		}

		progateLayoutsRoles = updateImpl(progateLayoutsRoles, merge);

		for (ModelListener<ProgateLayoutsRoles> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(progateLayoutsRoles);
			}
			else {
				listener.onAfterUpdate(progateLayoutsRoles);
			}
		}

		return progateLayoutsRoles;
	}

	public ProgateLayoutsRoles updateImpl(
		larion.progate.model.ProgateLayoutsRoles progateLayoutsRoles,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, progateLayoutsRoles, merge);

			progateLayoutsRoles.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(ProgateLayoutsRolesModelImpl.ENTITY_CACHE_ENABLED,
			ProgateLayoutsRolesImpl.class, progateLayoutsRoles.getPrimaryKey(),
			progateLayoutsRoles);

		return progateLayoutsRoles;
	}

	public ProgateLayoutsRoles findByPrimaryKey(int ProgateLayoutsRolesId)
		throws NoSuchProgateLayoutsRolesException, SystemException {
		ProgateLayoutsRoles progateLayoutsRoles = fetchByPrimaryKey(ProgateLayoutsRolesId);

		if (progateLayoutsRoles == null) {
			if (_log.isWarnEnabled()) {
				_log.warn("No ProgateLayoutsRoles exists with the primary key " +
					ProgateLayoutsRolesId);
			}

			throw new NoSuchProgateLayoutsRolesException(
				"No ProgateLayoutsRoles exists with the primary key " +
				ProgateLayoutsRolesId);
		}

		return progateLayoutsRoles;
	}

	public ProgateLayoutsRoles fetchByPrimaryKey(int ProgateLayoutsRolesId)
		throws SystemException {
		ProgateLayoutsRoles progateLayoutsRoles = (ProgateLayoutsRoles)EntityCacheUtil.getResult(ProgateLayoutsRolesModelImpl.ENTITY_CACHE_ENABLED,
				ProgateLayoutsRolesImpl.class, ProgateLayoutsRolesId, this);

		if (progateLayoutsRoles == null) {
			Session session = null;

			try {
				session = openSession();

				progateLayoutsRoles = (ProgateLayoutsRoles)session.get(ProgateLayoutsRolesImpl.class,
						new Integer(ProgateLayoutsRolesId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (progateLayoutsRoles != null) {
					cacheResult(progateLayoutsRoles);
				}

				closeSession(session);
			}
		}

		return progateLayoutsRoles;
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

	public List<ProgateLayoutsRoles> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<ProgateLayoutsRoles> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<ProgateLayoutsRoles> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProgateLayoutsRoles> list = (List<ProgateLayoutsRoles>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.ProgateLayoutsRoles ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<ProgateLayoutsRoles>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ProgateLayoutsRoles>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProgateLayoutsRoles>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeAll() throws SystemException {
		for (ProgateLayoutsRoles progateLayoutsRoles : findAll()) {
			remove(progateLayoutsRoles);
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
						"SELECT COUNT(*) FROM larion.progate.model.ProgateLayoutsRoles");

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
						"value.object.listener.larion.progate.model.ProgateLayoutsRoles")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ProgateLayoutsRoles>> listenersList = new ArrayList<ModelListener<ProgateLayoutsRoles>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ProgateLayoutsRoles>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(ProgateLayoutsRolesPersistenceImpl.class);
}