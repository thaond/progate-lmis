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
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQuery;
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQueryFactoryUtil;
import com.liferay.portal.kernel.dao.jdbc.RowMapper;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import larion.progate.NoSuchOrganizationException;

import larion.progate.model.Organization;
import larion.progate.model.impl.OrganizationImpl;
import larion.progate.model.impl.OrganizationModelImpl;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="OrganizationPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class OrganizationPersistenceImpl extends BasePersistenceImpl
	implements OrganizationPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = OrganizationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_LEVELSHARING = new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findBylevelSharing", new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_LEVELSHARING = new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findBylevelSharing",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_LEVELSHARING = new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countBylevelSharing", new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ISPROACTIVE = new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByisProactive", new String[] { Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ISPROACTIVE = new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByisProactive",
			new String[] {
				Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ISPROACTIVE = new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByisProactive", new String[] { Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ISPRIVATEPROFILE = new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByisPrivateProfile", new String[] { Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ISPRIVATEPROFILE = new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByisPrivateProfile",
			new String[] {
				Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ISPRIVATEPROFILE = new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByisPrivateProfile", new String[] { Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ORGNAME = new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByOrgName", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ORGNAME = new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByOrgName",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGNAME = new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByOrgName", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ORGPARENT = new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByorgParent", new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ORGPARENT = new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByorgParent",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGPARENT = new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByorgParent", new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ORGTYPE = new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByorgType", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ORGTYPE = new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByorgType",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGTYPE = new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByorgType", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ORGSTATUS = new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByorgStatus", new String[] { Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ORGSTATUS = new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByorgStatus",
			new String[] {
				Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGSTATUS = new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByorgStatus", new String[] { Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ROOTID = new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByrootId", new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ROOTID = new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByrootId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ROOTID = new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByrootId", new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_BODID = new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findBybodId", new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_BODID = new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findBybodId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_BODID = new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countBybodId", new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_LEVEL = new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findBylevel", new String[] { Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_LEVEL = new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findBylevel",
			new String[] {
				Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_LEVEL = new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countBylevel", new String[] { Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	public void cacheResult(Organization organization) {
		EntityCacheUtil.putResult(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationImpl.class, organization.getPrimaryKey(), organization);
	}

	public void cacheResult(List<Organization> organizations) {
		for (Organization organization : organizations) {
			if (EntityCacheUtil.getResult(
						OrganizationModelImpl.ENTITY_CACHE_ENABLED,
						OrganizationImpl.class, organization.getPrimaryKey(),
						this) == null) {
				cacheResult(organization);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(OrganizationImpl.class.getName());
		EntityCacheUtil.clearCache(OrganizationImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public Organization create(Integer orgId) {
		Organization organization = new OrganizationImpl();

		organization.setNew(true);
		organization.setPrimaryKey(orgId);

		return organization;
	}

	public Organization remove(Integer orgId)
		throws NoSuchOrganizationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Organization organization = (Organization)session.get(OrganizationImpl.class,
					orgId);

			if (organization == null) {
				if (_log.isWarnEnabled()) {
					_log.warn("No Organization exists with the primary key " +
						orgId);
				}

				throw new NoSuchOrganizationException(
					"No Organization exists with the primary key " + orgId);
			}

			return remove(organization);
		}
		catch (NoSuchOrganizationException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public Organization remove(Organization organization)
		throws SystemException {
		for (ModelListener<Organization> listener : listeners) {
			listener.onBeforeRemove(organization);
		}

		organization = removeImpl(organization);

		for (ModelListener<Organization> listener : listeners) {
			listener.onAfterRemove(organization);
		}

		return organization;
	}

	protected Organization removeImpl(Organization organization)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (organization.isCachedModel() || BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(OrganizationImpl.class,
						organization.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(organization);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationImpl.class, organization.getPrimaryKey());

		return organization;
	}

	public Organization update(Organization organization)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(Organization organization) method. Use update(Organization organization, boolean merge) instead.");
		}

		return update(organization, false);
	}

	public Organization update(Organization organization, boolean merge)
		throws SystemException {
		boolean isNew = organization.isNew();

		for (ModelListener<Organization> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(organization);
			}
			else {
				listener.onBeforeUpdate(organization);
			}
		}

		organization = updateImpl(organization, merge);

		for (ModelListener<Organization> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(organization);
			}
			else {
				listener.onAfterUpdate(organization);
			}
		}

		return organization;
	}

	public Organization updateImpl(
		larion.progate.model.Organization organization, boolean merge)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, organization, merge);

			organization.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationImpl.class, organization.getPrimaryKey(), organization);

		return organization;
	}

	public Organization findByPrimaryKey(Integer orgId)
		throws NoSuchOrganizationException, SystemException {
		Organization organization = fetchByPrimaryKey(orgId);

		if (organization == null) {
			if (_log.isWarnEnabled()) {
				_log.warn("No Organization exists with the primary key " +
					orgId);
			}

			throw new NoSuchOrganizationException(
				"No Organization exists with the primary key " + orgId);
		}

		return organization;
	}

	public Organization fetchByPrimaryKey(Integer orgId)
		throws SystemException {
		Organization organization = (Organization)EntityCacheUtil.getResult(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
				OrganizationImpl.class, orgId, this);

		if (organization == null) {
			Session session = null;

			try {
				session = openSession();

				organization = (Organization)session.get(OrganizationImpl.class,
						orgId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (organization != null) {
					cacheResult(organization);
				}

				closeSession(session);
			}
		}

		return organization;
	}

	public List<Organization> findBylevelSharing(int levelSharing)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(levelSharing) };

		List<Organization> list = (List<Organization>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_LEVELSHARING,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.Organization WHERE ");

				query.append("level_sharing LIKE ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("updated_at ASC, ");
				query.append("created_at ASC, ");
				query.append("name ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(levelSharing);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Organization>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_LEVELSHARING,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<Organization> findBylevelSharing(int levelSharing, int start,
		int end) throws SystemException {
		return findBylevelSharing(levelSharing, start, end, null);
	}

	public List<Organization> findBylevelSharing(int levelSharing, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(levelSharing),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<Organization> list = (List<Organization>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_LEVELSHARING,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.Organization WHERE ");

				query.append("level_sharing LIKE ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("updated_at ASC, ");
					query.append("created_at ASC, ");
					query.append("name ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(levelSharing);

				list = (List<Organization>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Organization>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_LEVELSHARING,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public Organization findBylevelSharing_First(int levelSharing,
		OrderByComparator obc)
		throws NoSuchOrganizationException, SystemException {
		List<Organization> list = findBylevelSharing(levelSharing, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No Organization exists with the key {");

			msg.append("levelSharing=" + levelSharing);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrganizationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public Organization findBylevelSharing_Last(int levelSharing,
		OrderByComparator obc)
		throws NoSuchOrganizationException, SystemException {
		int count = countBylevelSharing(levelSharing);

		List<Organization> list = findBylevelSharing(levelSharing, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No Organization exists with the key {");

			msg.append("levelSharing=" + levelSharing);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrganizationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public Organization[] findBylevelSharing_PrevAndNext(Integer orgId,
		int levelSharing, OrderByComparator obc)
		throws NoSuchOrganizationException, SystemException {
		Organization organization = findByPrimaryKey(orgId);

		int count = countBylevelSharing(levelSharing);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.Organization WHERE ");

			query.append("level_sharing LIKE ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("updated_at ASC, ");
				query.append("created_at ASC, ");
				query.append("name ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(levelSharing);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					organization);

			Organization[] array = new OrganizationImpl[3];

			array[0] = (Organization)objArray[0];
			array[1] = (Organization)objArray[1];
			array[2] = (Organization)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<Organization> findByisProactive(boolean isProactive)
		throws SystemException {
		Object[] finderArgs = new Object[] { Boolean.valueOf(isProactive) };

		List<Organization> list = (List<Organization>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ISPROACTIVE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.Organization WHERE ");

				query.append("is_proactive = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("updated_at ASC, ");
				query.append("created_at ASC, ");
				query.append("name ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isProactive);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Organization>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ISPROACTIVE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<Organization> findByisProactive(boolean isProactive, int start,
		int end) throws SystemException {
		return findByisProactive(isProactive, start, end, null);
	}

	public List<Organization> findByisProactive(boolean isProactive, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				Boolean.valueOf(isProactive),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<Organization> list = (List<Organization>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ISPROACTIVE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.Organization WHERE ");

				query.append("is_proactive = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("updated_at ASC, ");
					query.append("created_at ASC, ");
					query.append("name ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isProactive);

				list = (List<Organization>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Organization>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ISPROACTIVE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public Organization findByisProactive_First(boolean isProactive,
		OrderByComparator obc)
		throws NoSuchOrganizationException, SystemException {
		List<Organization> list = findByisProactive(isProactive, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No Organization exists with the key {");

			msg.append("isProactive=" + isProactive);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrganizationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public Organization findByisProactive_Last(boolean isProactive,
		OrderByComparator obc)
		throws NoSuchOrganizationException, SystemException {
		int count = countByisProactive(isProactive);

		List<Organization> list = findByisProactive(isProactive, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No Organization exists with the key {");

			msg.append("isProactive=" + isProactive);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrganizationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public Organization[] findByisProactive_PrevAndNext(Integer orgId,
		boolean isProactive, OrderByComparator obc)
		throws NoSuchOrganizationException, SystemException {
		Organization organization = findByPrimaryKey(orgId);

		int count = countByisProactive(isProactive);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.Organization WHERE ");

			query.append("is_proactive = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("updated_at ASC, ");
				query.append("created_at ASC, ");
				query.append("name ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(isProactive);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					organization);

			Organization[] array = new OrganizationImpl[3];

			array[0] = (Organization)objArray[0];
			array[1] = (Organization)objArray[1];
			array[2] = (Organization)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<Organization> findByisPrivateProfile(boolean isPrivateProfile)
		throws SystemException {
		Object[] finderArgs = new Object[] { Boolean.valueOf(isPrivateProfile) };

		List<Organization> list = (List<Organization>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ISPRIVATEPROFILE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.Organization WHERE ");

				query.append("is_private_profile LIKE ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("updated_at ASC, ");
				query.append("created_at ASC, ");
				query.append("name ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isPrivateProfile);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Organization>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ISPRIVATEPROFILE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<Organization> findByisPrivateProfile(boolean isPrivateProfile,
		int start, int end) throws SystemException {
		return findByisPrivateProfile(isPrivateProfile, start, end, null);
	}

	public List<Organization> findByisPrivateProfile(boolean isPrivateProfile,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				Boolean.valueOf(isPrivateProfile),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<Organization> list = (List<Organization>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ISPRIVATEPROFILE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.Organization WHERE ");

				query.append("is_private_profile LIKE ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("updated_at ASC, ");
					query.append("created_at ASC, ");
					query.append("name ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isPrivateProfile);

				list = (List<Organization>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Organization>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ISPRIVATEPROFILE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public Organization findByisPrivateProfile_First(boolean isPrivateProfile,
		OrderByComparator obc)
		throws NoSuchOrganizationException, SystemException {
		List<Organization> list = findByisPrivateProfile(isPrivateProfile, 0,
				1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No Organization exists with the key {");

			msg.append("isPrivateProfile=" + isPrivateProfile);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrganizationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public Organization findByisPrivateProfile_Last(boolean isPrivateProfile,
		OrderByComparator obc)
		throws NoSuchOrganizationException, SystemException {
		int count = countByisPrivateProfile(isPrivateProfile);

		List<Organization> list = findByisPrivateProfile(isPrivateProfile,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No Organization exists with the key {");

			msg.append("isPrivateProfile=" + isPrivateProfile);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrganizationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public Organization[] findByisPrivateProfile_PrevAndNext(Integer orgId,
		boolean isPrivateProfile, OrderByComparator obc)
		throws NoSuchOrganizationException, SystemException {
		Organization organization = findByPrimaryKey(orgId);

		int count = countByisPrivateProfile(isPrivateProfile);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.Organization WHERE ");

			query.append("is_private_profile LIKE ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("updated_at ASC, ");
				query.append("created_at ASC, ");
				query.append("name ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(isPrivateProfile);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					organization);

			Organization[] array = new OrganizationImpl[3];

			array[0] = (Organization)objArray[0];
			array[1] = (Organization)objArray[1];
			array[2] = (Organization)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<Organization> findByOrgName(String name)
		throws SystemException {
		Object[] finderArgs = new Object[] { name };

		List<Organization> list = (List<Organization>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ORGNAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.Organization WHERE ");

				if (name == null) {
					query.append("name LIKE null");
				}
				else {
					query.append("name LIKE ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("updated_at ASC, ");
				query.append("created_at ASC, ");
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
					list = new ArrayList<Organization>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ORGNAME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<Organization> findByOrgName(String name, int start, int end)
		throws SystemException {
		return findByOrgName(name, start, end, null);
	}

	public List<Organization> findByOrgName(String name, int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				name,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<Organization> list = (List<Organization>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ORGNAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.Organization WHERE ");

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

					query.append("updated_at ASC, ");
					query.append("created_at ASC, ");
					query.append("name ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (name != null) {
					qPos.add(name);
				}

				list = (List<Organization>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Organization>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ORGNAME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public Organization findByOrgName_First(String name, OrderByComparator obc)
		throws NoSuchOrganizationException, SystemException {
		List<Organization> list = findByOrgName(name, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No Organization exists with the key {");

			msg.append("name=" + name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrganizationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public Organization findByOrgName_Last(String name, OrderByComparator obc)
		throws NoSuchOrganizationException, SystemException {
		int count = countByOrgName(name);

		List<Organization> list = findByOrgName(name, count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No Organization exists with the key {");

			msg.append("name=" + name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrganizationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public Organization[] findByOrgName_PrevAndNext(Integer orgId, String name,
		OrderByComparator obc)
		throws NoSuchOrganizationException, SystemException {
		Organization organization = findByPrimaryKey(orgId);

		int count = countByOrgName(name);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.Organization WHERE ");

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

				query.append("updated_at ASC, ");
				query.append("created_at ASC, ");
				query.append("name ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (name != null) {
				qPos.add(name);
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					organization);

			Organization[] array = new OrganizationImpl[3];

			array[0] = (Organization)objArray[0];
			array[1] = (Organization)objArray[1];
			array[2] = (Organization)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<Organization> findByorgParent(int orgParent)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(orgParent) };

		List<Organization> list = (List<Organization>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ORGPARENT,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.Organization WHERE ");

				query.append("parent_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("updated_at ASC, ");
				query.append("created_at ASC, ");
				query.append("name ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orgParent);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Organization>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ORGPARENT,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<Organization> findByorgParent(int orgParent, int start, int end)
		throws SystemException {
		return findByorgParent(orgParent, start, end, null);
	}

	public List<Organization> findByorgParent(int orgParent, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(orgParent),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<Organization> list = (List<Organization>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ORGPARENT,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.Organization WHERE ");

				query.append("parent_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("updated_at ASC, ");
					query.append("created_at ASC, ");
					query.append("name ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orgParent);

				list = (List<Organization>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Organization>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ORGPARENT,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public Organization findByorgParent_First(int orgParent,
		OrderByComparator obc)
		throws NoSuchOrganizationException, SystemException {
		List<Organization> list = findByorgParent(orgParent, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No Organization exists with the key {");

			msg.append("orgParent=" + orgParent);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrganizationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public Organization findByorgParent_Last(int orgParent,
		OrderByComparator obc)
		throws NoSuchOrganizationException, SystemException {
		int count = countByorgParent(orgParent);

		List<Organization> list = findByorgParent(orgParent, count - 1, count,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No Organization exists with the key {");

			msg.append("orgParent=" + orgParent);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrganizationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public Organization[] findByorgParent_PrevAndNext(Integer orgId,
		int orgParent, OrderByComparator obc)
		throws NoSuchOrganizationException, SystemException {
		Organization organization = findByPrimaryKey(orgId);

		int count = countByorgParent(orgParent);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.Organization WHERE ");

			query.append("parent_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("updated_at ASC, ");
				query.append("created_at ASC, ");
				query.append("name ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(orgParent);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					organization);

			Organization[] array = new OrganizationImpl[3];

			array[0] = (Organization)objArray[0];
			array[1] = (Organization)objArray[1];
			array[2] = (Organization)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<Organization> findByorgType(String orgType)
		throws SystemException {
		Object[] finderArgs = new Object[] { orgType };

		List<Organization> list = (List<Organization>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ORGTYPE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.Organization WHERE ");

				if (orgType == null) {
					query.append("org_type LIKE null");
				}
				else {
					query.append("org_type LIKE ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("updated_at ASC, ");
				query.append("created_at ASC, ");
				query.append("name ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (orgType != null) {
					qPos.add(orgType);
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Organization>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ORGTYPE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<Organization> findByorgType(String orgType, int start, int end)
		throws SystemException {
		return findByorgType(orgType, start, end, null);
	}

	public List<Organization> findByorgType(String orgType, int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				orgType,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<Organization> list = (List<Organization>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ORGTYPE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.Organization WHERE ");

				if (orgType == null) {
					query.append("org_type LIKE null");
				}
				else {
					query.append("org_type LIKE ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("updated_at ASC, ");
					query.append("created_at ASC, ");
					query.append("name ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (orgType != null) {
					qPos.add(orgType);
				}

				list = (List<Organization>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Organization>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ORGTYPE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public Organization findByorgType_First(String orgType,
		OrderByComparator obc)
		throws NoSuchOrganizationException, SystemException {
		List<Organization> list = findByorgType(orgType, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No Organization exists with the key {");

			msg.append("orgType=" + orgType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrganizationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public Organization findByorgType_Last(String orgType, OrderByComparator obc)
		throws NoSuchOrganizationException, SystemException {
		int count = countByorgType(orgType);

		List<Organization> list = findByorgType(orgType, count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No Organization exists with the key {");

			msg.append("orgType=" + orgType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrganizationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public Organization[] findByorgType_PrevAndNext(Integer orgId,
		String orgType, OrderByComparator obc)
		throws NoSuchOrganizationException, SystemException {
		Organization organization = findByPrimaryKey(orgId);

		int count = countByorgType(orgType);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.Organization WHERE ");

			if (orgType == null) {
				query.append("org_type LIKE null");
			}
			else {
				query.append("org_type LIKE ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("updated_at ASC, ");
				query.append("created_at ASC, ");
				query.append("name ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (orgType != null) {
				qPos.add(orgType);
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					organization);

			Organization[] array = new OrganizationImpl[3];

			array[0] = (Organization)objArray[0];
			array[1] = (Organization)objArray[1];
			array[2] = (Organization)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<Organization> findByorgStatus(boolean orgStatus)
		throws SystemException {
		Object[] finderArgs = new Object[] { Boolean.valueOf(orgStatus) };

		List<Organization> list = (List<Organization>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ORGSTATUS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.Organization WHERE ");

				query.append("org_status = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("updated_at ASC, ");
				query.append("created_at ASC, ");
				query.append("name ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orgStatus);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Organization>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ORGSTATUS,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<Organization> findByorgStatus(boolean orgStatus, int start,
		int end) throws SystemException {
		return findByorgStatus(orgStatus, start, end, null);
	}

	public List<Organization> findByorgStatus(boolean orgStatus, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				Boolean.valueOf(orgStatus),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<Organization> list = (List<Organization>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ORGSTATUS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.Organization WHERE ");

				query.append("org_status = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("updated_at ASC, ");
					query.append("created_at ASC, ");
					query.append("name ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orgStatus);

				list = (List<Organization>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Organization>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ORGSTATUS,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public Organization findByorgStatus_First(boolean orgStatus,
		OrderByComparator obc)
		throws NoSuchOrganizationException, SystemException {
		List<Organization> list = findByorgStatus(orgStatus, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No Organization exists with the key {");

			msg.append("orgStatus=" + orgStatus);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrganizationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public Organization findByorgStatus_Last(boolean orgStatus,
		OrderByComparator obc)
		throws NoSuchOrganizationException, SystemException {
		int count = countByorgStatus(orgStatus);

		List<Organization> list = findByorgStatus(orgStatus, count - 1, count,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No Organization exists with the key {");

			msg.append("orgStatus=" + orgStatus);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrganizationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public Organization[] findByorgStatus_PrevAndNext(Integer orgId,
		boolean orgStatus, OrderByComparator obc)
		throws NoSuchOrganizationException, SystemException {
		Organization organization = findByPrimaryKey(orgId);

		int count = countByorgStatus(orgStatus);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.Organization WHERE ");

			query.append("org_status = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("updated_at ASC, ");
				query.append("created_at ASC, ");
				query.append("name ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(orgStatus);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					organization);

			Organization[] array = new OrganizationImpl[3];

			array[0] = (Organization)objArray[0];
			array[1] = (Organization)objArray[1];
			array[2] = (Organization)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<Organization> findByrootId(int rootId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		List<Organization> list = (List<Organization>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.Organization WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("updated_at ASC, ");
				query.append("created_at ASC, ");
				query.append("name ASC");

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
					list = new ArrayList<Organization>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<Organization> findByrootId(int rootId, int start, int end)
		throws SystemException {
		return findByrootId(rootId, start, end, null);
	}

	public List<Organization> findByrootId(int rootId, int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(rootId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<Organization> list = (List<Organization>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.Organization WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("updated_at ASC, ");
					query.append("created_at ASC, ");
					query.append("name ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rootId);

				list = (List<Organization>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Organization>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public Organization findByrootId_First(int rootId, OrderByComparator obc)
		throws NoSuchOrganizationException, SystemException {
		List<Organization> list = findByrootId(rootId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No Organization exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrganizationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public Organization findByrootId_Last(int rootId, OrderByComparator obc)
		throws NoSuchOrganizationException, SystemException {
		int count = countByrootId(rootId);

		List<Organization> list = findByrootId(rootId, count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No Organization exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrganizationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public Organization[] findByrootId_PrevAndNext(Integer orgId, int rootId,
		OrderByComparator obc)
		throws NoSuchOrganizationException, SystemException {
		Organization organization = findByPrimaryKey(orgId);

		int count = countByrootId(rootId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.Organization WHERE ");

			query.append("root_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("updated_at ASC, ");
				query.append("created_at ASC, ");
				query.append("name ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(rootId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					organization);

			Organization[] array = new OrganizationImpl[3];

			array[0] = (Organization)objArray[0];
			array[1] = (Organization)objArray[1];
			array[2] = (Organization)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<Organization> findBybodId(int bodId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(bodId) };

		List<Organization> list = (List<Organization>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_BODID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.Organization WHERE ");

				query.append("bod_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("updated_at ASC, ");
				query.append("created_at ASC, ");
				query.append("name ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(bodId);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Organization>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_BODID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<Organization> findBybodId(int bodId, int start, int end)
		throws SystemException {
		return findBybodId(bodId, start, end, null);
	}

	public List<Organization> findBybodId(int bodId, int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(bodId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<Organization> list = (List<Organization>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_BODID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.Organization WHERE ");

				query.append("bod_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("updated_at ASC, ");
					query.append("created_at ASC, ");
					query.append("name ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(bodId);

				list = (List<Organization>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Organization>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_BODID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public Organization findBybodId_First(int bodId, OrderByComparator obc)
		throws NoSuchOrganizationException, SystemException {
		List<Organization> list = findBybodId(bodId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No Organization exists with the key {");

			msg.append("bodId=" + bodId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrganizationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public Organization findBybodId_Last(int bodId, OrderByComparator obc)
		throws NoSuchOrganizationException, SystemException {
		int count = countBybodId(bodId);

		List<Organization> list = findBybodId(bodId, count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No Organization exists with the key {");

			msg.append("bodId=" + bodId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrganizationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public Organization[] findBybodId_PrevAndNext(Integer orgId, int bodId,
		OrderByComparator obc)
		throws NoSuchOrganizationException, SystemException {
		Organization organization = findByPrimaryKey(orgId);

		int count = countBybodId(bodId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.Organization WHERE ");

			query.append("bod_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("updated_at ASC, ");
				query.append("created_at ASC, ");
				query.append("name ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(bodId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					organization);

			Organization[] array = new OrganizationImpl[3];

			array[0] = (Organization)objArray[0];
			array[1] = (Organization)objArray[1];
			array[2] = (Organization)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<Organization> findBylevel(boolean orgStatus)
		throws SystemException {
		Object[] finderArgs = new Object[] { Boolean.valueOf(orgStatus) };

		List<Organization> list = (List<Organization>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_LEVEL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.Organization WHERE ");

				query.append("org_status = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("updated_at ASC, ");
				query.append("created_at ASC, ");
				query.append("name ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orgStatus);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Organization>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_LEVEL,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<Organization> findBylevel(boolean orgStatus, int start, int end)
		throws SystemException {
		return findBylevel(orgStatus, start, end, null);
	}

	public List<Organization> findBylevel(boolean orgStatus, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				Boolean.valueOf(orgStatus),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<Organization> list = (List<Organization>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_LEVEL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.Organization WHERE ");

				query.append("org_status = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("updated_at ASC, ");
					query.append("created_at ASC, ");
					query.append("name ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orgStatus);

				list = (List<Organization>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Organization>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_LEVEL,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public Organization findBylevel_First(boolean orgStatus,
		OrderByComparator obc)
		throws NoSuchOrganizationException, SystemException {
		List<Organization> list = findBylevel(orgStatus, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No Organization exists with the key {");

			msg.append("orgStatus=" + orgStatus);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrganizationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public Organization findBylevel_Last(boolean orgStatus,
		OrderByComparator obc)
		throws NoSuchOrganizationException, SystemException {
		int count = countBylevel(orgStatus);

		List<Organization> list = findBylevel(orgStatus, count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No Organization exists with the key {");

			msg.append("orgStatus=" + orgStatus);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrganizationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public Organization[] findBylevel_PrevAndNext(Integer orgId,
		boolean orgStatus, OrderByComparator obc)
		throws NoSuchOrganizationException, SystemException {
		Organization organization = findByPrimaryKey(orgId);

		int count = countBylevel(orgStatus);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.Organization WHERE ");

			query.append("org_status = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("updated_at ASC, ");
				query.append("created_at ASC, ");
				query.append("name ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(orgStatus);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					organization);

			Organization[] array = new OrganizationImpl[3];

			array[0] = (Organization)objArray[0];
			array[1] = (Organization)objArray[1];
			array[2] = (Organization)objArray[2];

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

	public List<Organization> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<Organization> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<Organization> findAll(int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<Organization> list = (List<Organization>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.Organization ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("updated_at ASC, ");
					query.append("created_at ASC, ");
					query.append("name ASC");
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<Organization>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Organization>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Organization>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeBylevelSharing(int levelSharing)
		throws SystemException {
		for (Organization organization : findBylevelSharing(levelSharing)) {
			remove(organization);
		}
	}

	public void removeByisProactive(boolean isProactive)
		throws SystemException {
		for (Organization organization : findByisProactive(isProactive)) {
			remove(organization);
		}
	}

	public void removeByisPrivateProfile(boolean isPrivateProfile)
		throws SystemException {
		for (Organization organization : findByisPrivateProfile(
				isPrivateProfile)) {
			remove(organization);
		}
	}

	public void removeByOrgName(String name) throws SystemException {
		for (Organization organization : findByOrgName(name)) {
			remove(organization);
		}
	}

	public void removeByorgParent(int orgParent) throws SystemException {
		for (Organization organization : findByorgParent(orgParent)) {
			remove(organization);
		}
	}

	public void removeByorgType(String orgType) throws SystemException {
		for (Organization organization : findByorgType(orgType)) {
			remove(organization);
		}
	}

	public void removeByorgStatus(boolean orgStatus) throws SystemException {
		for (Organization organization : findByorgStatus(orgStatus)) {
			remove(organization);
		}
	}

	public void removeByrootId(int rootId) throws SystemException {
		for (Organization organization : findByrootId(rootId)) {
			remove(organization);
		}
	}

	public void removeBybodId(int bodId) throws SystemException {
		for (Organization organization : findBybodId(bodId)) {
			remove(organization);
		}
	}

	public void removeBylevel(boolean orgStatus) throws SystemException {
		for (Organization organization : findBylevel(orgStatus)) {
			remove(organization);
		}
	}

	public void removeAll() throws SystemException {
		for (Organization organization : findAll()) {
			remove(organization);
		}
	}

	public int countBylevelSharing(int levelSharing) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(levelSharing) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_LEVELSHARING,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append("FROM larion.progate.model.Organization WHERE ");

				query.append("level_sharing LIKE ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(levelSharing);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LEVELSHARING,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByisProactive(boolean isProactive)
		throws SystemException {
		Object[] finderArgs = new Object[] { Boolean.valueOf(isProactive) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ISPROACTIVE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append("FROM larion.progate.model.Organization WHERE ");

				query.append("is_proactive = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isProactive);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ISPROACTIVE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByisPrivateProfile(boolean isPrivateProfile)
		throws SystemException {
		Object[] finderArgs = new Object[] { Boolean.valueOf(isPrivateProfile) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ISPRIVATEPROFILE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append("FROM larion.progate.model.Organization WHERE ");

				query.append("is_private_profile LIKE ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isPrivateProfile);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ISPRIVATEPROFILE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByOrgName(String name) throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ORGNAME,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append("FROM larion.progate.model.Organization WHERE ");

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ORGNAME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByorgParent(int orgParent) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(orgParent) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ORGPARENT,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append("FROM larion.progate.model.Organization WHERE ");

				query.append("parent_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orgParent);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ORGPARENT,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByorgType(String orgType) throws SystemException {
		Object[] finderArgs = new Object[] { orgType };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ORGTYPE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append("FROM larion.progate.model.Organization WHERE ");

				if (orgType == null) {
					query.append("org_type LIKE null");
				}
				else {
					query.append("org_type LIKE ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (orgType != null) {
					qPos.add(orgType);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ORGTYPE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByorgStatus(boolean orgStatus) throws SystemException {
		Object[] finderArgs = new Object[] { Boolean.valueOf(orgStatus) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ORGSTATUS,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append("FROM larion.progate.model.Organization WHERE ");

				query.append("org_status = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orgStatus);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ORGSTATUS,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByrootId(int rootId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ROOTID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append("FROM larion.progate.model.Organization WHERE ");

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

	public int countBybodId(int bodId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(bodId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_BODID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append("FROM larion.progate.model.Organization WHERE ");

				query.append("bod_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(bodId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BODID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countBylevel(boolean orgStatus) throws SystemException {
		Object[] finderArgs = new Object[] { Boolean.valueOf(orgStatus) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_LEVEL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append("FROM larion.progate.model.Organization WHERE ");

				query.append("org_status = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orgStatus);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LEVEL,
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
						"SELECT COUNT(*) FROM larion.progate.model.Organization");

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

	public List<larion.progate.model.OrgObjectList> getOrgObjectLists(
		Integer pk) throws SystemException {
		return getOrgObjectLists(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public List<larion.progate.model.OrgObjectList> getOrgObjectLists(
		Integer pk, int start, int end) throws SystemException {
		return getOrgObjectLists(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_ORGOBJECTLISTS = new FinderPath(larion.progate.model.impl.OrgObjectListModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.model.impl.OrgObjectListModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.service.persistence.OrgObjectListPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getOrgObjectLists",
			new String[] {
				Integer.class.getName(), "java.lang.Integer",
				"java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	public List<larion.progate.model.OrgObjectList> getOrgObjectLists(
		Integer pk, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				pk, String.valueOf(start), String.valueOf(end),
				String.valueOf(obc)
			};

		List<larion.progate.model.OrgObjectList> list = (List<larion.progate.model.OrgObjectList>)FinderCacheUtil.getResult(FINDER_PATH_GET_ORGOBJECTLISTS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder sb = new StringBuilder();

				sb.append(_SQL_GETORGOBJECTLISTS);

				if (obc != null) {
					sb.append("ORDER BY ");
					sb.append(obc.getOrderBy());
				}

				else {
					sb.append("ORDER BY ");

					sb.append("ebsc_orgobjectives_list.year DESC, ");
					sb.append("ebsc_orgobjectives_list.month_hash ASC, ");
					sb.append("ebsc_orgobjectives_list.name DESC");
				}

				String sql = sb.toString();

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("ebsc_orgobjectives_list",
					larion.progate.model.impl.OrgObjectListImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<larion.progate.model.OrgObjectList>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<larion.progate.model.OrgObjectList>();
				}

				orgObjectListPersistence.cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_GET_ORGOBJECTLISTS,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_ORGOBJECTLISTS_SIZE = new FinderPath(larion.progate.model.impl.OrgObjectListModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.model.impl.OrgObjectListModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.service.persistence.OrgObjectListPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getOrgObjectListsSize", new String[] { Integer.class.getName() });

	public int getOrgObjectListsSize(Integer pk) throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_ORGOBJECTLISTS_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETORGOBJECTLISTSSIZE);

				q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_GET_ORGOBJECTLISTS_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_ORGOBJECTLIST = new FinderPath(larion.progate.model.impl.OrgObjectListModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.model.impl.OrgObjectListModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.service.persistence.OrgObjectListPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"containsOrgObjectList",
			new String[] { Integer.class.getName(), Integer.class.getName() });

	public boolean containsOrgObjectList(Integer pk, Integer orgObjectListPK)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk, orgObjectListPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_ORGOBJECTLIST,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsOrgObjectList.contains(pk,
							orgObjectListPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_ORGOBJECTLIST,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	public boolean containsOrgObjectLists(Integer pk) throws SystemException {
		if (getOrgObjectListsSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public List<larion.progate.model.ProGateOrgCustomer> getProGateOrgCustomers(
		Integer pk) throws SystemException {
		return getProGateOrgCustomers(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public List<larion.progate.model.ProGateOrgCustomer> getProGateOrgCustomers(
		Integer pk, int start, int end) throws SystemException {
		return getProGateOrgCustomers(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_PROGATEORGCUSTOMERS = new FinderPath(larion.progate.model.impl.ProGateOrgCustomerModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.model.impl.ProGateOrgCustomerModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.service.persistence.ProGateOrgCustomerPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getProGateOrgCustomers",
			new String[] {
				Integer.class.getName(), "java.lang.Integer",
				"java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	public List<larion.progate.model.ProGateOrgCustomer> getProGateOrgCustomers(
		Integer pk, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				pk, String.valueOf(start), String.valueOf(end),
				String.valueOf(obc)
			};

		List<larion.progate.model.ProGateOrgCustomer> list = (List<larion.progate.model.ProGateOrgCustomer>)FinderCacheUtil.getResult(FINDER_PATH_GET_PROGATEORGCUSTOMERS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder sb = new StringBuilder();

				sb.append(_SQL_GETPROGATEORGCUSTOMERS);

				if (obc != null) {
					sb.append("ORDER BY ");
					sb.append(obc.getOrderBy());
				}

				else {
					sb.append("ORDER BY ");

					sb.append("progate_org_customer.modified_date DESC, ");
					sb.append("progate_org_customer.created_date DESC, ");
					sb.append("progate_org_customer.customer_name DESC");
				}

				String sql = sb.toString();

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("progate_org_customer",
					larion.progate.model.impl.ProGateOrgCustomerImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<larion.progate.model.ProGateOrgCustomer>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<larion.progate.model.ProGateOrgCustomer>();
				}

				proGateOrgCustomerPersistence.cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_GET_PROGATEORGCUSTOMERS,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_PROGATEORGCUSTOMERS_SIZE = new FinderPath(larion.progate.model.impl.ProGateOrgCustomerModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.model.impl.ProGateOrgCustomerModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.service.persistence.ProGateOrgCustomerPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getProGateOrgCustomersSize",
			new String[] { Integer.class.getName() });

	public int getProGateOrgCustomersSize(Integer pk) throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_PROGATEORGCUSTOMERS_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETPROGATEORGCUSTOMERSSIZE);

				q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_GET_PROGATEORGCUSTOMERS_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_PROGATEORGCUSTOMER = new FinderPath(larion.progate.model.impl.ProGateOrgCustomerModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.model.impl.ProGateOrgCustomerModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.service.persistence.ProGateOrgCustomerPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"containsProGateOrgCustomer",
			new String[] { Integer.class.getName(), Integer.class.getName() });

	public boolean containsProGateOrgCustomer(Integer pk,
		Integer proGateOrgCustomerPK) throws SystemException {
		Object[] finderArgs = new Object[] { pk, proGateOrgCustomerPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_PROGATEORGCUSTOMER,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsProGateOrgCustomer.contains(
							pk, proGateOrgCustomerPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_PROGATEORGCUSTOMER,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	public boolean containsProGateOrgCustomers(Integer pk)
		throws SystemException {
		if (getProGateOrgCustomersSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.larion.progate.model.Organization")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Organization>> listenersList = new ArrayList<ModelListener<Organization>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Organization>)Class.forName(
							listenerClassName).newInstance());
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		containsOrgObjectList = new ContainsOrgObjectList(this);

		containsProGateOrgCustomer = new ContainsProGateOrgCustomer(this);
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
	protected ContainsOrgObjectList containsOrgObjectList;
	protected ContainsProGateOrgCustomer containsProGateOrgCustomer;

	protected class ContainsOrgObjectList {
		protected ContainsOrgObjectList(
			OrganizationPersistenceImpl persistenceImpl) {
			super();

			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSORGOBJECTLIST,
					new int[] { Types.INTEGER, Types.INTEGER }, RowMapper.COUNT);
		}

		protected boolean contains(Integer orgId, Integer orgObjectListId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						orgId, orgObjectListId
					});

			if (results.size() > 0) {
				Integer count = results.get(0);

				if (count.intValue() > 0) {
					return true;
				}
			}

			return false;
		}

		private MappingSqlQuery _mappingSqlQuery;
	}

	protected class ContainsProGateOrgCustomer {
		protected ContainsProGateOrgCustomer(
			OrganizationPersistenceImpl persistenceImpl) {
			super();

			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSPROGATEORGCUSTOMER,
					new int[] { Types.INTEGER, Types.INTEGER }, RowMapper.COUNT);
		}

		protected boolean contains(Integer orgId, Integer ProGateOrgCustomerId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						orgId, ProGateOrgCustomerId
					});

			if (results.size() > 0) {
				Integer count = results.get(0);

				if (count.intValue() > 0) {
					return true;
				}
			}

			return false;
		}

		private MappingSqlQuery _mappingSqlQuery;
	}

	private static final String _SQL_GETORGOBJECTLISTS = "SELECT {ebsc_orgobjectives_list.*} FROM ebsc_orgobjectives_list INNER JOIN organizations ON (organizations.orgId = ebsc_orgobjectives_list.orgId) WHERE (organizations.orgId = ?)";
	private static final String _SQL_GETORGOBJECTLISTSSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM ebsc_orgobjectives_list WHERE orgId = ?";
	private static final String _SQL_CONTAINSORGOBJECTLIST = "SELECT COUNT(*) AS COUNT_VALUE FROM ebsc_orgobjectives_list WHERE orgId = ? AND orgObjectListId = ?";
	private static final String _SQL_GETPROGATEORGCUSTOMERS = "SELECT {progate_org_customer.*} FROM progate_org_customer INNER JOIN organizations ON (organizations.orgId = progate_org_customer.orgId) WHERE (organizations.orgId = ?)";
	private static final String _SQL_GETPROGATEORGCUSTOMERSSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM progate_org_customer WHERE orgId = ?";
	private static final String _SQL_CONTAINSPROGATEORGCUSTOMER = "SELECT COUNT(*) AS COUNT_VALUE FROM progate_org_customer WHERE orgId = ? AND ProGateOrgCustomerId = ?";
	private static Log _log = LogFactoryUtil.getLog(OrganizationPersistenceImpl.class);
}