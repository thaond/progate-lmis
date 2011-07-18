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

import larion.progate.NoSuchProgateLayoutsMenusException;

import larion.progate.model.ProgateLayoutsMenus;
import larion.progate.model.impl.ProgateLayoutsMenusImpl;
import larion.progate.model.impl.ProgateLayoutsMenusModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="ProgateLayoutsMenusPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProgateLayoutsMenusPersistenceImpl extends BasePersistenceImpl
	implements ProgateLayoutsMenusPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = ProgateLayoutsMenusImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_LAYOUTID = new FinderPath(ProgateLayoutsMenusModelImpl.ENTITY_CACHE_ENABLED,
			ProgateLayoutsMenusModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBylayoutId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_LAYOUTID = new FinderPath(ProgateLayoutsMenusModelImpl.ENTITY_CACHE_ENABLED,
			ProgateLayoutsMenusModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBylayoutId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_LAYOUTID = new FinderPath(ProgateLayoutsMenusModelImpl.ENTITY_CACHE_ENABLED,
			ProgateLayoutsMenusModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBylayoutId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(ProgateLayoutsMenusModelImpl.ENTITY_CACHE_ENABLED,
			ProgateLayoutsMenusModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProgateLayoutsMenusModelImpl.ENTITY_CACHE_ENABLED,
			ProgateLayoutsMenusModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(ProgateLayoutsMenus progateLayoutsMenus) {
		EntityCacheUtil.putResult(ProgateLayoutsMenusModelImpl.ENTITY_CACHE_ENABLED,
			ProgateLayoutsMenusImpl.class, progateLayoutsMenus.getPrimaryKey(),
			progateLayoutsMenus);
	}

	public void cacheResult(List<ProgateLayoutsMenus> progateLayoutsMenuses) {
		for (ProgateLayoutsMenus progateLayoutsMenus : progateLayoutsMenuses) {
			if (EntityCacheUtil.getResult(
						ProgateLayoutsMenusModelImpl.ENTITY_CACHE_ENABLED,
						ProgateLayoutsMenusImpl.class,
						progateLayoutsMenus.getPrimaryKey(), this) == null) {
				cacheResult(progateLayoutsMenus);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(ProgateLayoutsMenusImpl.class.getName());
		EntityCacheUtil.clearCache(ProgateLayoutsMenusImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public ProgateLayoutsMenus create(int ProgateLayoutsMenusId) {
		ProgateLayoutsMenus progateLayoutsMenus = new ProgateLayoutsMenusImpl();

		progateLayoutsMenus.setNew(true);
		progateLayoutsMenus.setPrimaryKey(ProgateLayoutsMenusId);

		return progateLayoutsMenus;
	}

	public ProgateLayoutsMenus remove(int ProgateLayoutsMenusId)
		throws NoSuchProgateLayoutsMenusException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ProgateLayoutsMenus progateLayoutsMenus = (ProgateLayoutsMenus)session.get(ProgateLayoutsMenusImpl.class,
					new Integer(ProgateLayoutsMenusId));

			if (progateLayoutsMenus == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No ProgateLayoutsMenus exists with the primary key " +
						ProgateLayoutsMenusId);
				}

				throw new NoSuchProgateLayoutsMenusException(
					"No ProgateLayoutsMenus exists with the primary key " +
					ProgateLayoutsMenusId);
			}

			return remove(progateLayoutsMenus);
		}
		catch (NoSuchProgateLayoutsMenusException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public ProgateLayoutsMenus remove(ProgateLayoutsMenus progateLayoutsMenus)
		throws SystemException {
		for (ModelListener<ProgateLayoutsMenus> listener : listeners) {
			listener.onBeforeRemove(progateLayoutsMenus);
		}

		progateLayoutsMenus = removeImpl(progateLayoutsMenus);

		for (ModelListener<ProgateLayoutsMenus> listener : listeners) {
			listener.onAfterRemove(progateLayoutsMenus);
		}

		return progateLayoutsMenus;
	}

	protected ProgateLayoutsMenus removeImpl(
		ProgateLayoutsMenus progateLayoutsMenus) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (progateLayoutsMenus.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(ProgateLayoutsMenusImpl.class,
						progateLayoutsMenus.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(progateLayoutsMenus);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(ProgateLayoutsMenusModelImpl.ENTITY_CACHE_ENABLED,
			ProgateLayoutsMenusImpl.class, progateLayoutsMenus.getPrimaryKey());

		return progateLayoutsMenus;
	}

	public ProgateLayoutsMenus update(ProgateLayoutsMenus progateLayoutsMenus)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(ProgateLayoutsMenus progateLayoutsMenus) method. Use update(ProgateLayoutsMenus progateLayoutsMenus, boolean merge) instead.");
		}

		return update(progateLayoutsMenus, false);
	}

	public ProgateLayoutsMenus update(ProgateLayoutsMenus progateLayoutsMenus,
		boolean merge) throws SystemException {
		boolean isNew = progateLayoutsMenus.isNew();

		for (ModelListener<ProgateLayoutsMenus> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(progateLayoutsMenus);
			}
			else {
				listener.onBeforeUpdate(progateLayoutsMenus);
			}
		}

		progateLayoutsMenus = updateImpl(progateLayoutsMenus, merge);

		for (ModelListener<ProgateLayoutsMenus> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(progateLayoutsMenus);
			}
			else {
				listener.onAfterUpdate(progateLayoutsMenus);
			}
		}

		return progateLayoutsMenus;
	}

	public ProgateLayoutsMenus updateImpl(
		larion.progate.model.ProgateLayoutsMenus progateLayoutsMenus,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, progateLayoutsMenus, merge);

			progateLayoutsMenus.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(ProgateLayoutsMenusModelImpl.ENTITY_CACHE_ENABLED,
			ProgateLayoutsMenusImpl.class, progateLayoutsMenus.getPrimaryKey(),
			progateLayoutsMenus);

		return progateLayoutsMenus;
	}

	public ProgateLayoutsMenus findByPrimaryKey(int ProgateLayoutsMenusId)
		throws NoSuchProgateLayoutsMenusException, SystemException {
		ProgateLayoutsMenus progateLayoutsMenus = fetchByPrimaryKey(ProgateLayoutsMenusId);

		if (progateLayoutsMenus == null) {
			if (_log.isWarnEnabled()) {
				_log.warn("No ProgateLayoutsMenus exists with the primary key " +
					ProgateLayoutsMenusId);
			}

			throw new NoSuchProgateLayoutsMenusException(
				"No ProgateLayoutsMenus exists with the primary key " +
				ProgateLayoutsMenusId);
		}

		return progateLayoutsMenus;
	}

	public ProgateLayoutsMenus fetchByPrimaryKey(int ProgateLayoutsMenusId)
		throws SystemException {
		ProgateLayoutsMenus progateLayoutsMenus = (ProgateLayoutsMenus)EntityCacheUtil.getResult(ProgateLayoutsMenusModelImpl.ENTITY_CACHE_ENABLED,
				ProgateLayoutsMenusImpl.class, ProgateLayoutsMenusId, this);

		if (progateLayoutsMenus == null) {
			Session session = null;

			try {
				session = openSession();

				progateLayoutsMenus = (ProgateLayoutsMenus)session.get(ProgateLayoutsMenusImpl.class,
						new Integer(ProgateLayoutsMenusId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (progateLayoutsMenus != null) {
					cacheResult(progateLayoutsMenus);
				}

				closeSession(session);
			}
		}

		return progateLayoutsMenus;
	}

	public List<ProgateLayoutsMenus> findBylayoutId(int layoutId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(layoutId) };

		List<ProgateLayoutsMenus> list = (List<ProgateLayoutsMenus>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_LAYOUTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProgateLayoutsMenus WHERE ");

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
					list = new ArrayList<ProgateLayoutsMenus>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_LAYOUTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProgateLayoutsMenus> findBylayoutId(int layoutId, int start,
		int end) throws SystemException {
		return findBylayoutId(layoutId, start, end, null);
	}

	public List<ProgateLayoutsMenus> findBylayoutId(int layoutId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(layoutId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProgateLayoutsMenus> list = (List<ProgateLayoutsMenus>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_LAYOUTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProgateLayoutsMenus WHERE ");

				query.append("layout_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(layoutId);

				list = (List<ProgateLayoutsMenus>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProgateLayoutsMenus>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_LAYOUTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProgateLayoutsMenus findBylayoutId_First(int layoutId,
		OrderByComparator obc)
		throws NoSuchProgateLayoutsMenusException, SystemException {
		List<ProgateLayoutsMenus> list = findBylayoutId(layoutId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProgateLayoutsMenus exists with the key {");

			msg.append("layoutId=" + layoutId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProgateLayoutsMenusException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProgateLayoutsMenus findBylayoutId_Last(int layoutId,
		OrderByComparator obc)
		throws NoSuchProgateLayoutsMenusException, SystemException {
		int count = countBylayoutId(layoutId);

		List<ProgateLayoutsMenus> list = findBylayoutId(layoutId, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProgateLayoutsMenus exists with the key {");

			msg.append("layoutId=" + layoutId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProgateLayoutsMenusException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProgateLayoutsMenus[] findBylayoutId_PrevAndNext(
		int ProgateLayoutsMenusId, int layoutId, OrderByComparator obc)
		throws NoSuchProgateLayoutsMenusException, SystemException {
		ProgateLayoutsMenus progateLayoutsMenus = findByPrimaryKey(ProgateLayoutsMenusId);

		int count = countBylayoutId(layoutId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.ProgateLayoutsMenus WHERE ");

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
					progateLayoutsMenus);

			ProgateLayoutsMenus[] array = new ProgateLayoutsMenusImpl[3];

			array[0] = (ProgateLayoutsMenus)objArray[0];
			array[1] = (ProgateLayoutsMenus)objArray[1];
			array[2] = (ProgateLayoutsMenus)objArray[2];

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

	public List<ProgateLayoutsMenus> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<ProgateLayoutsMenus> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<ProgateLayoutsMenus> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProgateLayoutsMenus> list = (List<ProgateLayoutsMenus>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.ProgateLayoutsMenus ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<ProgateLayoutsMenus>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ProgateLayoutsMenus>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProgateLayoutsMenus>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeBylayoutId(int layoutId) throws SystemException {
		for (ProgateLayoutsMenus progateLayoutsMenus : findBylayoutId(layoutId)) {
			remove(progateLayoutsMenus);
		}
	}

	public void removeAll() throws SystemException {
		for (ProgateLayoutsMenus progateLayoutsMenus : findAll()) {
			remove(progateLayoutsMenus);
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
					"FROM larion.progate.model.ProgateLayoutsMenus WHERE ");

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

	public int countAll() throws SystemException {
		Object[] finderArgs = new Object[0];

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(
						"SELECT COUNT(*) FROM larion.progate.model.ProgateLayoutsMenus");

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
						"value.object.listener.larion.progate.model.ProgateLayoutsMenus")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ProgateLayoutsMenus>> listenersList = new ArrayList<ModelListener<ProgateLayoutsMenus>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ProgateLayoutsMenus>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(ProgateLayoutsMenusPersistenceImpl.class);
}