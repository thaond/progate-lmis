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

import larion.progate.NoSuchOrgObjectObjectiveException;

import larion.progate.model.OrgObjectObjective;
import larion.progate.model.impl.OrgObjectObjectiveImpl;
import larion.progate.model.impl.OrgObjectObjectiveModelImpl;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="OrgObjectObjectivePersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class OrgObjectObjectivePersistenceImpl extends BasePersistenceImpl
	implements OrgObjectObjectivePersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = OrgObjectObjectiveImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_ORGOBJOBJECTIVENAME = new FinderPath(OrgObjectObjectiveModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectObjectiveModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOrgObjObjectiveName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ORGOBJOBJECTIVENAME = new FinderPath(OrgObjectObjectiveModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectObjectiveModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOrgObjObjectiveName",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGOBJOBJECTIVENAME = new FinderPath(OrgObjectObjectiveModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectObjectiveModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByOrgObjObjectiveName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ORGOBJECTPERSPECTIVEID = new FinderPath(OrgObjectObjectiveModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectObjectiveModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByorgObjectPerspectiveId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ORGOBJECTPERSPECTIVEID =
		new FinderPath(OrgObjectObjectiveModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectObjectiveModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByorgObjectPerspectiveId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGOBJECTPERSPECTIVEID = new FinderPath(OrgObjectObjectiveModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectObjectiveModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByorgObjectPerspectiveId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(OrgObjectObjectiveModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectObjectiveModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OrgObjectObjectiveModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectObjectiveModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(OrgObjectObjective orgObjectObjective) {
		EntityCacheUtil.putResult(OrgObjectObjectiveModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectObjectiveImpl.class, orgObjectObjective.getPrimaryKey(),
			orgObjectObjective);
	}

	public void cacheResult(List<OrgObjectObjective> orgObjectObjectives) {
		for (OrgObjectObjective orgObjectObjective : orgObjectObjectives) {
			if (EntityCacheUtil.getResult(
						OrgObjectObjectiveModelImpl.ENTITY_CACHE_ENABLED,
						OrgObjectObjectiveImpl.class,
						orgObjectObjective.getPrimaryKey(), this) == null) {
				cacheResult(orgObjectObjective);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(OrgObjectObjectiveImpl.class.getName());
		EntityCacheUtil.clearCache(OrgObjectObjectiveImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public OrgObjectObjective create(Integer orgObjectObjectiveId) {
		OrgObjectObjective orgObjectObjective = new OrgObjectObjectiveImpl();

		orgObjectObjective.setNew(true);
		orgObjectObjective.setPrimaryKey(orgObjectObjectiveId);

		return orgObjectObjective;
	}

	public OrgObjectObjective remove(Integer orgObjectObjectiveId)
		throws NoSuchOrgObjectObjectiveException, SystemException {
		Session session = null;

		try {
			session = openSession();

			OrgObjectObjective orgObjectObjective = (OrgObjectObjective)session.get(OrgObjectObjectiveImpl.class,
					orgObjectObjectiveId);

			if (orgObjectObjective == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No OrgObjectObjective exists with the primary key " +
						orgObjectObjectiveId);
				}

				throw new NoSuchOrgObjectObjectiveException(
					"No OrgObjectObjective exists with the primary key " +
					orgObjectObjectiveId);
			}

			return remove(orgObjectObjective);
		}
		catch (NoSuchOrgObjectObjectiveException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public OrgObjectObjective remove(OrgObjectObjective orgObjectObjective)
		throws SystemException {
		for (ModelListener<OrgObjectObjective> listener : listeners) {
			listener.onBeforeRemove(orgObjectObjective);
		}

		orgObjectObjective = removeImpl(orgObjectObjective);

		for (ModelListener<OrgObjectObjective> listener : listeners) {
			listener.onAfterRemove(orgObjectObjective);
		}

		return orgObjectObjective;
	}

	protected OrgObjectObjective removeImpl(
		OrgObjectObjective orgObjectObjective) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (orgObjectObjective.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(OrgObjectObjectiveImpl.class,
						orgObjectObjective.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(orgObjectObjective);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(OrgObjectObjectiveModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectObjectiveImpl.class, orgObjectObjective.getPrimaryKey());

		return orgObjectObjective;
	}

	public OrgObjectObjective update(OrgObjectObjective orgObjectObjective)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(OrgObjectObjective orgObjectObjective) method. Use update(OrgObjectObjective orgObjectObjective, boolean merge) instead.");
		}

		return update(orgObjectObjective, false);
	}

	public OrgObjectObjective update(OrgObjectObjective orgObjectObjective,
		boolean merge) throws SystemException {
		boolean isNew = orgObjectObjective.isNew();

		for (ModelListener<OrgObjectObjective> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(orgObjectObjective);
			}
			else {
				listener.onBeforeUpdate(orgObjectObjective);
			}
		}

		orgObjectObjective = updateImpl(orgObjectObjective, merge);

		for (ModelListener<OrgObjectObjective> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(orgObjectObjective);
			}
			else {
				listener.onAfterUpdate(orgObjectObjective);
			}
		}

		return orgObjectObjective;
	}

	public OrgObjectObjective updateImpl(
		larion.progate.model.OrgObjectObjective orgObjectObjective,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, orgObjectObjective, merge);

			orgObjectObjective.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(OrgObjectObjectiveModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectObjectiveImpl.class, orgObjectObjective.getPrimaryKey(),
			orgObjectObjective);

		return orgObjectObjective;
	}

	public OrgObjectObjective findByPrimaryKey(Integer orgObjectObjectiveId)
		throws NoSuchOrgObjectObjectiveException, SystemException {
		OrgObjectObjective orgObjectObjective = fetchByPrimaryKey(orgObjectObjectiveId);

		if (orgObjectObjective == null) {
			if (_log.isWarnEnabled()) {
				_log.warn("No OrgObjectObjective exists with the primary key " +
					orgObjectObjectiveId);
			}

			throw new NoSuchOrgObjectObjectiveException(
				"No OrgObjectObjective exists with the primary key " +
				orgObjectObjectiveId);
		}

		return orgObjectObjective;
	}

	public OrgObjectObjective fetchByPrimaryKey(Integer orgObjectObjectiveId)
		throws SystemException {
		OrgObjectObjective orgObjectObjective = (OrgObjectObjective)EntityCacheUtil.getResult(OrgObjectObjectiveModelImpl.ENTITY_CACHE_ENABLED,
				OrgObjectObjectiveImpl.class, orgObjectObjectiveId, this);

		if (orgObjectObjective == null) {
			Session session = null;

			try {
				session = openSession();

				orgObjectObjective = (OrgObjectObjective)session.get(OrgObjectObjectiveImpl.class,
						orgObjectObjectiveId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (orgObjectObjective != null) {
					cacheResult(orgObjectObjective);
				}

				closeSession(session);
			}
		}

		return orgObjectObjective;
	}

	public List<OrgObjectObjective> findByOrgObjObjectiveName(String name)
		throws SystemException {
		Object[] finderArgs = new Object[] { name };

		List<OrgObjectObjective> list = (List<OrgObjectObjective>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ORGOBJOBJECTIVENAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.OrgObjectObjective WHERE ");

				if (name == null) {
					query.append("name IS NULL");
				}
				else {
					query.append("name = ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("obj_id ASC, ");
				query.append("id ASC");

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
					list = new ArrayList<OrgObjectObjective>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ORGOBJOBJECTIVENAME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<OrgObjectObjective> findByOrgObjObjectiveName(String name,
		int start, int end) throws SystemException {
		return findByOrgObjObjectiveName(name, start, end, null);
	}

	public List<OrgObjectObjective> findByOrgObjObjectiveName(String name,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				name,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<OrgObjectObjective> list = (List<OrgObjectObjective>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ORGOBJOBJECTIVENAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.OrgObjectObjective WHERE ");

				if (name == null) {
					query.append("name IS NULL");
				}
				else {
					query.append("name = ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("obj_id ASC, ");
					query.append("id ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (name != null) {
					qPos.add(name);
				}

				list = (List<OrgObjectObjective>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<OrgObjectObjective>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ORGOBJOBJECTIVENAME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public OrgObjectObjective findByOrgObjObjectiveName_First(String name,
		OrderByComparator obc)
		throws NoSuchOrgObjectObjectiveException, SystemException {
		List<OrgObjectObjective> list = findByOrgObjObjectiveName(name, 0, 1,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No OrgObjectObjective exists with the key {");

			msg.append("name=" + name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrgObjectObjectiveException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public OrgObjectObjective findByOrgObjObjectiveName_Last(String name,
		OrderByComparator obc)
		throws NoSuchOrgObjectObjectiveException, SystemException {
		int count = countByOrgObjObjectiveName(name);

		List<OrgObjectObjective> list = findByOrgObjObjectiveName(name,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No OrgObjectObjective exists with the key {");

			msg.append("name=" + name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrgObjectObjectiveException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public OrgObjectObjective[] findByOrgObjObjectiveName_PrevAndNext(
		Integer orgObjectObjectiveId, String name, OrderByComparator obc)
		throws NoSuchOrgObjectObjectiveException, SystemException {
		OrgObjectObjective orgObjectObjective = findByPrimaryKey(orgObjectObjectiveId);

		int count = countByOrgObjObjectiveName(name);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.OrgObjectObjective WHERE ");

			if (name == null) {
				query.append("name IS NULL");
			}
			else {
				query.append("name = ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("obj_id ASC, ");
				query.append("id ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (name != null) {
				qPos.add(name);
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					orgObjectObjective);

			OrgObjectObjective[] array = new OrgObjectObjectiveImpl[3];

			array[0] = (OrgObjectObjective)objArray[0];
			array[1] = (OrgObjectObjective)objArray[1];
			array[2] = (OrgObjectObjective)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<OrgObjectObjective> findByorgObjectPerspectiveId(
		int orgObjectPerspectiveId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(orgObjectPerspectiveId) };

		List<OrgObjectObjective> list = (List<OrgObjectObjective>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ORGOBJECTPERSPECTIVEID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.OrgObjectObjective WHERE ");

				query.append("obj_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("obj_id ASC, ");
				query.append("id ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orgObjectPerspectiveId);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<OrgObjectObjective>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ORGOBJECTPERSPECTIVEID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<OrgObjectObjective> findByorgObjectPerspectiveId(
		int orgObjectPerspectiveId, int start, int end)
		throws SystemException {
		return findByorgObjectPerspectiveId(orgObjectPerspectiveId, start, end,
			null);
	}

	public List<OrgObjectObjective> findByorgObjectPerspectiveId(
		int orgObjectPerspectiveId, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(orgObjectPerspectiveId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<OrgObjectObjective> list = (List<OrgObjectObjective>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ORGOBJECTPERSPECTIVEID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.OrgObjectObjective WHERE ");

				query.append("obj_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("obj_id ASC, ");
					query.append("id ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orgObjectPerspectiveId);

				list = (List<OrgObjectObjective>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<OrgObjectObjective>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ORGOBJECTPERSPECTIVEID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public OrgObjectObjective findByorgObjectPerspectiveId_First(
		int orgObjectPerspectiveId, OrderByComparator obc)
		throws NoSuchOrgObjectObjectiveException, SystemException {
		List<OrgObjectObjective> list = findByorgObjectPerspectiveId(orgObjectPerspectiveId,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No OrgObjectObjective exists with the key {");

			msg.append("orgObjectPerspectiveId=" + orgObjectPerspectiveId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrgObjectObjectiveException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public OrgObjectObjective findByorgObjectPerspectiveId_Last(
		int orgObjectPerspectiveId, OrderByComparator obc)
		throws NoSuchOrgObjectObjectiveException, SystemException {
		int count = countByorgObjectPerspectiveId(orgObjectPerspectiveId);

		List<OrgObjectObjective> list = findByorgObjectPerspectiveId(orgObjectPerspectiveId,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No OrgObjectObjective exists with the key {");

			msg.append("orgObjectPerspectiveId=" + orgObjectPerspectiveId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrgObjectObjectiveException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public OrgObjectObjective[] findByorgObjectPerspectiveId_PrevAndNext(
		Integer orgObjectObjectiveId, int orgObjectPerspectiveId,
		OrderByComparator obc)
		throws NoSuchOrgObjectObjectiveException, SystemException {
		OrgObjectObjective orgObjectObjective = findByPrimaryKey(orgObjectObjectiveId);

		int count = countByorgObjectPerspectiveId(orgObjectPerspectiveId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.OrgObjectObjective WHERE ");

			query.append("obj_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("obj_id ASC, ");
				query.append("id ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(orgObjectPerspectiveId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					orgObjectObjective);

			OrgObjectObjective[] array = new OrgObjectObjectiveImpl[3];

			array[0] = (OrgObjectObjective)objArray[0];
			array[1] = (OrgObjectObjective)objArray[1];
			array[2] = (OrgObjectObjective)objArray[2];

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

	public List<OrgObjectObjective> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<OrgObjectObjective> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<OrgObjectObjective> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<OrgObjectObjective> list = (List<OrgObjectObjective>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.OrgObjectObjective ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("obj_id ASC, ");
					query.append("id ASC");
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<OrgObjectObjective>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<OrgObjectObjective>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<OrgObjectObjective>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByOrgObjObjectiveName(String name)
		throws SystemException {
		for (OrgObjectObjective orgObjectObjective : findByOrgObjObjectiveName(
				name)) {
			remove(orgObjectObjective);
		}
	}

	public void removeByorgObjectPerspectiveId(int orgObjectPerspectiveId)
		throws SystemException {
		for (OrgObjectObjective orgObjectObjective : findByorgObjectPerspectiveId(
				orgObjectPerspectiveId)) {
			remove(orgObjectObjective);
		}
	}

	public void removeAll() throws SystemException {
		for (OrgObjectObjective orgObjectObjective : findAll()) {
			remove(orgObjectObjective);
		}
	}

	public int countByOrgObjObjectiveName(String name)
		throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ORGOBJOBJECTIVENAME,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.OrgObjectObjective WHERE ");

				if (name == null) {
					query.append("name IS NULL");
				}
				else {
					query.append("name = ?");
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ORGOBJOBJECTIVENAME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByorgObjectPerspectiveId(int orgObjectPerspectiveId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(orgObjectPerspectiveId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ORGOBJECTPERSPECTIVEID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.OrgObjectObjective WHERE ");

				query.append("obj_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orgObjectPerspectiveId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ORGOBJECTPERSPECTIVEID,
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
						"SELECT COUNT(*) FROM larion.progate.model.OrgObjectObjective");

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

	public List<larion.progate.model.OrgObjectMeasure> getOrgObjectMeasures(
		Integer pk) throws SystemException {
		return getOrgObjectMeasures(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public List<larion.progate.model.OrgObjectMeasure> getOrgObjectMeasures(
		Integer pk, int start, int end) throws SystemException {
		return getOrgObjectMeasures(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_ORGOBJECTMEASURES = new FinderPath(larion.progate.model.impl.OrgObjectMeasureModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.model.impl.OrgObjectMeasureModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.service.persistence.OrgObjectMeasurePersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getOrgObjectMeasures",
			new String[] {
				Integer.class.getName(), "java.lang.Integer",
				"java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	public List<larion.progate.model.OrgObjectMeasure> getOrgObjectMeasures(
		Integer pk, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				pk, String.valueOf(start), String.valueOf(end),
				String.valueOf(obc)
			};

		List<larion.progate.model.OrgObjectMeasure> list = (List<larion.progate.model.OrgObjectMeasure>)FinderCacheUtil.getResult(FINDER_PATH_GET_ORGOBJECTMEASURES,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder sb = new StringBuilder();

				sb.append(_SQL_GETORGOBJECTMEASURES);

				if (obc != null) {
					sb.append("ORDER BY ");
					sb.append(obc.getOrderBy());
				}

				else {
					sb.append("ORDER BY ");

					sb.append("ebsc_orgobjectives_measures.obj_id ASC, ");
					sb.append("ebsc_orgobjectives_measures.id ASC");
				}

				String sql = sb.toString();

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("ebsc_orgobjectives_measures",
					larion.progate.model.impl.OrgObjectMeasureImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<larion.progate.model.OrgObjectMeasure>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<larion.progate.model.OrgObjectMeasure>();
				}

				orgObjectMeasurePersistence.cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_GET_ORGOBJECTMEASURES,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_ORGOBJECTMEASURES_SIZE = new FinderPath(larion.progate.model.impl.OrgObjectMeasureModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.model.impl.OrgObjectMeasureModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.service.persistence.OrgObjectMeasurePersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getOrgObjectMeasuresSize", new String[] { Integer.class.getName() });

	public int getOrgObjectMeasuresSize(Integer pk) throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_ORGOBJECTMEASURES_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETORGOBJECTMEASURESSIZE);

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

				FinderCacheUtil.putResult(FINDER_PATH_GET_ORGOBJECTMEASURES_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_ORGOBJECTMEASURE = new FinderPath(larion.progate.model.impl.OrgObjectMeasureModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.model.impl.OrgObjectMeasureModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.service.persistence.OrgObjectMeasurePersistenceImpl.FINDER_CLASS_NAME_LIST,
			"containsOrgObjectMeasure",
			new String[] { Integer.class.getName(), Integer.class.getName() });

	public boolean containsOrgObjectMeasure(Integer pk,
		Integer orgObjectMeasurePK) throws SystemException {
		Object[] finderArgs = new Object[] { pk, orgObjectMeasurePK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_ORGOBJECTMEASURE,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsOrgObjectMeasure.contains(pk,
							orgObjectMeasurePK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_ORGOBJECTMEASURE,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	public boolean containsOrgObjectMeasures(Integer pk)
		throws SystemException {
		if (getOrgObjectMeasuresSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.larion.progate.model.OrgObjectObjective")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<OrgObjectObjective>> listenersList = new ArrayList<ModelListener<OrgObjectObjective>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<OrgObjectObjective>)Class.forName(
							listenerClassName).newInstance());
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		containsOrgObjectMeasure = new ContainsOrgObjectMeasure(this);
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
	protected ContainsOrgObjectMeasure containsOrgObjectMeasure;

	protected class ContainsOrgObjectMeasure {
		protected ContainsOrgObjectMeasure(
			OrgObjectObjectivePersistenceImpl persistenceImpl) {
			super();

			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSORGOBJECTMEASURE,
					new int[] { Types.INTEGER, Types.INTEGER }, RowMapper.COUNT);
		}

		protected boolean contains(Integer orgObjectObjectiveId,
			Integer orgObjectMeasureId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						orgObjectObjectiveId, orgObjectMeasureId
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

	private static final String _SQL_GETORGOBJECTMEASURES = "SELECT {ebsc_orgobjectives_measures.*} FROM ebsc_orgobjectives_measures INNER JOIN ebsc_orgobjectives_objectives ON (ebsc_orgobjectives_objectives.orgObjectObjectiveId = ebsc_orgobjectives_measures.orgObjectObjectiveId) WHERE (ebsc_orgobjectives_objectives.orgObjectObjectiveId = ?)";
	private static final String _SQL_GETORGOBJECTMEASURESSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM ebsc_orgobjectives_measures WHERE orgObjectObjectiveId = ?";
	private static final String _SQL_CONTAINSORGOBJECTMEASURE = "SELECT COUNT(*) AS COUNT_VALUE FROM ebsc_orgobjectives_measures WHERE orgObjectObjectiveId = ? AND orgObjectMeasureId = ?";
	private static Log _log = LogFactoryUtil.getLog(OrgObjectObjectivePersistenceImpl.class);
}