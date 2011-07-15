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

import larion.progate.NoSuchProGatePermissionsException;

import larion.progate.model.ProGatePermissions;
import larion.progate.model.impl.ProGatePermissionsImpl;
import larion.progate.model.impl.ProGatePermissionsModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="ProGatePermissionsPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGatePermissionsPersistenceImpl extends BasePersistenceImpl
	implements ProGatePermissionsPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = ProGatePermissionsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_APPLICATIONID = new FinderPath(ProGatePermissionsModelImpl.ENTITY_CACHE_ENABLED,
			ProGatePermissionsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByApplicationId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_APPLICATIONID = new FinderPath(ProGatePermissionsModelImpl.ENTITY_CACHE_ENABLED,
			ProGatePermissionsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByApplicationId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_APPLICATIONID = new FinderPath(ProGatePermissionsModelImpl.ENTITY_CACHE_ENABLED,
			ProGatePermissionsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByApplicationId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(ProGatePermissionsModelImpl.ENTITY_CACHE_ENABLED,
			ProGatePermissionsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProGatePermissionsModelImpl.ENTITY_CACHE_ENABLED,
			ProGatePermissionsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(ProGatePermissions proGatePermissions) {
		EntityCacheUtil.putResult(ProGatePermissionsModelImpl.ENTITY_CACHE_ENABLED,
			ProGatePermissionsImpl.class, proGatePermissions.getPrimaryKey(),
			proGatePermissions);
	}

	public void cacheResult(List<ProGatePermissions> proGatePermissionses) {
		for (ProGatePermissions proGatePermissions : proGatePermissionses) {
			if (EntityCacheUtil.getResult(
						ProGatePermissionsModelImpl.ENTITY_CACHE_ENABLED,
						ProGatePermissionsImpl.class,
						proGatePermissions.getPrimaryKey(), this) == null) {
				cacheResult(proGatePermissions);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(ProGatePermissionsImpl.class.getName());
		EntityCacheUtil.clearCache(ProGatePermissionsImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public ProGatePermissions create(String ProGatePermissionsId) {
		ProGatePermissions proGatePermissions = new ProGatePermissionsImpl();

		proGatePermissions.setNew(true);
		proGatePermissions.setPrimaryKey(ProGatePermissionsId);

		return proGatePermissions;
	}

	public ProGatePermissions remove(String ProGatePermissionsId)
		throws NoSuchProGatePermissionsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ProGatePermissions proGatePermissions = (ProGatePermissions)session.get(ProGatePermissionsImpl.class,
					ProGatePermissionsId);

			if (proGatePermissions == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No ProGatePermissions exists with the primary key " +
						ProGatePermissionsId);
				}

				throw new NoSuchProGatePermissionsException(
					"No ProGatePermissions exists with the primary key " +
					ProGatePermissionsId);
			}

			return remove(proGatePermissions);
		}
		catch (NoSuchProGatePermissionsException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public ProGatePermissions remove(ProGatePermissions proGatePermissions)
		throws SystemException {
		for (ModelListener<ProGatePermissions> listener : listeners) {
			listener.onBeforeRemove(proGatePermissions);
		}

		proGatePermissions = removeImpl(proGatePermissions);

		for (ModelListener<ProGatePermissions> listener : listeners) {
			listener.onAfterRemove(proGatePermissions);
		}

		return proGatePermissions;
	}

	protected ProGatePermissions removeImpl(
		ProGatePermissions proGatePermissions) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (proGatePermissions.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(ProGatePermissionsImpl.class,
						proGatePermissions.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(proGatePermissions);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(ProGatePermissionsModelImpl.ENTITY_CACHE_ENABLED,
			ProGatePermissionsImpl.class, proGatePermissions.getPrimaryKey());

		return proGatePermissions;
	}

	public ProGatePermissions update(ProGatePermissions proGatePermissions)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(ProGatePermissions proGatePermissions) method. Use update(ProGatePermissions proGatePermissions, boolean merge) instead.");
		}

		return update(proGatePermissions, false);
	}

	public ProGatePermissions update(ProGatePermissions proGatePermissions,
		boolean merge) throws SystemException {
		boolean isNew = proGatePermissions.isNew();

		for (ModelListener<ProGatePermissions> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(proGatePermissions);
			}
			else {
				listener.onBeforeUpdate(proGatePermissions);
			}
		}

		proGatePermissions = updateImpl(proGatePermissions, merge);

		for (ModelListener<ProGatePermissions> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(proGatePermissions);
			}
			else {
				listener.onAfterUpdate(proGatePermissions);
			}
		}

		return proGatePermissions;
	}

	public ProGatePermissions updateImpl(
		larion.progate.model.ProGatePermissions proGatePermissions,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, proGatePermissions, merge);

			proGatePermissions.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(ProGatePermissionsModelImpl.ENTITY_CACHE_ENABLED,
			ProGatePermissionsImpl.class, proGatePermissions.getPrimaryKey(),
			proGatePermissions);

		return proGatePermissions;
	}

	public ProGatePermissions findByPrimaryKey(String ProGatePermissionsId)
		throws NoSuchProGatePermissionsException, SystemException {
		ProGatePermissions proGatePermissions = fetchByPrimaryKey(ProGatePermissionsId);

		if (proGatePermissions == null) {
			if (_log.isWarnEnabled()) {
				_log.warn("No ProGatePermissions exists with the primary key " +
					ProGatePermissionsId);
			}

			throw new NoSuchProGatePermissionsException(
				"No ProGatePermissions exists with the primary key " +
				ProGatePermissionsId);
		}

		return proGatePermissions;
	}

	public ProGatePermissions fetchByPrimaryKey(String ProGatePermissionsId)
		throws SystemException {
		ProGatePermissions proGatePermissions = (ProGatePermissions)EntityCacheUtil.getResult(ProGatePermissionsModelImpl.ENTITY_CACHE_ENABLED,
				ProGatePermissionsImpl.class, ProGatePermissionsId, this);

		if (proGatePermissions == null) {
			Session session = null;

			try {
				session = openSession();

				proGatePermissions = (ProGatePermissions)session.get(ProGatePermissionsImpl.class,
						ProGatePermissionsId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (proGatePermissions != null) {
					cacheResult(proGatePermissions);
				}

				closeSession(session);
			}
		}

		return proGatePermissions;
	}

	public List<ProGatePermissions> findByApplicationId(int applicationId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(applicationId) };

		List<ProGatePermissions> list = (List<ProGatePermissions>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_APPLICATIONID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGatePermissions WHERE ");

				query.append("app_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(applicationId);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGatePermissions>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_APPLICATIONID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGatePermissions> findByApplicationId(int applicationId,
		int start, int end) throws SystemException {
		return findByApplicationId(applicationId, start, end, null);
	}

	public List<ProGatePermissions> findByApplicationId(int applicationId,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(applicationId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGatePermissions> list = (List<ProGatePermissions>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_APPLICATIONID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGatePermissions WHERE ");

				query.append("app_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(applicationId);

				list = (List<ProGatePermissions>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGatePermissions>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_APPLICATIONID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGatePermissions findByApplicationId_First(int applicationId,
		OrderByComparator obc)
		throws NoSuchProGatePermissionsException, SystemException {
		List<ProGatePermissions> list = findByApplicationId(applicationId, 0,
				1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGatePermissions exists with the key {");

			msg.append("applicationId=" + applicationId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGatePermissionsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGatePermissions findByApplicationId_Last(int applicationId,
		OrderByComparator obc)
		throws NoSuchProGatePermissionsException, SystemException {
		int count = countByApplicationId(applicationId);

		List<ProGatePermissions> list = findByApplicationId(applicationId,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGatePermissions exists with the key {");

			msg.append("applicationId=" + applicationId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGatePermissionsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGatePermissions[] findByApplicationId_PrevAndNext(
		String ProGatePermissionsId, int applicationId, OrderByComparator obc)
		throws NoSuchProGatePermissionsException, SystemException {
		ProGatePermissions proGatePermissions = findByPrimaryKey(ProGatePermissionsId);

		int count = countByApplicationId(applicationId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.ProGatePermissions WHERE ");

			query.append("app_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(applicationId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGatePermissions);

			ProGatePermissions[] array = new ProGatePermissionsImpl[3];

			array[0] = (ProGatePermissions)objArray[0];
			array[1] = (ProGatePermissions)objArray[1];
			array[2] = (ProGatePermissions)objArray[2];

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

	public List<ProGatePermissions> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<ProGatePermissions> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<ProGatePermissions> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGatePermissions> list = (List<ProGatePermissions>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.ProGatePermissions ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<ProGatePermissions>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ProGatePermissions>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGatePermissions>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByApplicationId(int applicationId)
		throws SystemException {
		for (ProGatePermissions proGatePermissions : findByApplicationId(
				applicationId)) {
			remove(proGatePermissions);
		}
	}

	public void removeAll() throws SystemException {
		for (ProGatePermissions proGatePermissions : findAll()) {
			remove(proGatePermissions);
		}
	}

	public int countByApplicationId(int applicationId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(applicationId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_APPLICATIONID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGatePermissions WHERE ");

				query.append("app_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(applicationId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_APPLICATIONID,
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
						"SELECT COUNT(*) FROM larion.progate.model.ProGatePermissions");

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
						"value.object.listener.larion.progate.model.ProGatePermissions")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ProGatePermissions>> listenersList = new ArrayList<ModelListener<ProGatePermissions>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ProGatePermissions>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(ProGatePermissionsPersistenceImpl.class);
}