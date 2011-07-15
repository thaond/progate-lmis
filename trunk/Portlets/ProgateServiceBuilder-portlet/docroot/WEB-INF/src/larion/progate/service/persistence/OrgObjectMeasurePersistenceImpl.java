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

import larion.progate.NoSuchOrgObjectMeasureException;

import larion.progate.model.OrgObjectMeasure;
import larion.progate.model.impl.OrgObjectMeasureImpl;
import larion.progate.model.impl.OrgObjectMeasureModelImpl;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="OrgObjectMeasurePersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class OrgObjectMeasurePersistenceImpl extends BasePersistenceImpl
	implements OrgObjectMeasurePersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = OrgObjectMeasureImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_ORGOBJMEASURENAME = new FinderPath(OrgObjectMeasureModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectMeasureModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOrgObjMeasureName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ORGOBJMEASURENAME = new FinderPath(OrgObjectMeasureModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectMeasureModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOrgObjMeasureName",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGOBJMEASURENAME = new FinderPath(OrgObjectMeasureModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectMeasureModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByOrgObjMeasureName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ORGOBJECTOBJECTIVEID = new FinderPath(OrgObjectMeasureModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectMeasureModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOrgObjectObjectiveId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ORGOBJECTOBJECTIVEID = new FinderPath(OrgObjectMeasureModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectMeasureModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOrgObjectObjectiveId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGOBJECTOBJECTIVEID = new FinderPath(OrgObjectMeasureModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectMeasureModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByOrgObjectObjectiveId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(OrgObjectMeasureModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectMeasureModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OrgObjectMeasureModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectMeasureModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(OrgObjectMeasure orgObjectMeasure) {
		EntityCacheUtil.putResult(OrgObjectMeasureModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectMeasureImpl.class, orgObjectMeasure.getPrimaryKey(),
			orgObjectMeasure);
	}

	public void cacheResult(List<OrgObjectMeasure> orgObjectMeasures) {
		for (OrgObjectMeasure orgObjectMeasure : orgObjectMeasures) {
			if (EntityCacheUtil.getResult(
						OrgObjectMeasureModelImpl.ENTITY_CACHE_ENABLED,
						OrgObjectMeasureImpl.class,
						orgObjectMeasure.getPrimaryKey(), this) == null) {
				cacheResult(orgObjectMeasure);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(OrgObjectMeasureImpl.class.getName());
		EntityCacheUtil.clearCache(OrgObjectMeasureImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public OrgObjectMeasure create(Integer orgObjectMeasureId) {
		OrgObjectMeasure orgObjectMeasure = new OrgObjectMeasureImpl();

		orgObjectMeasure.setNew(true);
		orgObjectMeasure.setPrimaryKey(orgObjectMeasureId);

		return orgObjectMeasure;
	}

	public OrgObjectMeasure remove(Integer orgObjectMeasureId)
		throws NoSuchOrgObjectMeasureException, SystemException {
		Session session = null;

		try {
			session = openSession();

			OrgObjectMeasure orgObjectMeasure = (OrgObjectMeasure)session.get(OrgObjectMeasureImpl.class,
					orgObjectMeasureId);

			if (orgObjectMeasure == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No OrgObjectMeasure exists with the primary key " +
						orgObjectMeasureId);
				}

				throw new NoSuchOrgObjectMeasureException(
					"No OrgObjectMeasure exists with the primary key " +
					orgObjectMeasureId);
			}

			return remove(orgObjectMeasure);
		}
		catch (NoSuchOrgObjectMeasureException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public OrgObjectMeasure remove(OrgObjectMeasure orgObjectMeasure)
		throws SystemException {
		for (ModelListener<OrgObjectMeasure> listener : listeners) {
			listener.onBeforeRemove(orgObjectMeasure);
		}

		orgObjectMeasure = removeImpl(orgObjectMeasure);

		for (ModelListener<OrgObjectMeasure> listener : listeners) {
			listener.onAfterRemove(orgObjectMeasure);
		}

		return orgObjectMeasure;
	}

	protected OrgObjectMeasure removeImpl(OrgObjectMeasure orgObjectMeasure)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (orgObjectMeasure.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(OrgObjectMeasureImpl.class,
						orgObjectMeasure.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(orgObjectMeasure);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(OrgObjectMeasureModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectMeasureImpl.class, orgObjectMeasure.getPrimaryKey());

		return orgObjectMeasure;
	}

	public OrgObjectMeasure update(OrgObjectMeasure orgObjectMeasure)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(OrgObjectMeasure orgObjectMeasure) method. Use update(OrgObjectMeasure orgObjectMeasure, boolean merge) instead.");
		}

		return update(orgObjectMeasure, false);
	}

	public OrgObjectMeasure update(OrgObjectMeasure orgObjectMeasure,
		boolean merge) throws SystemException {
		boolean isNew = orgObjectMeasure.isNew();

		for (ModelListener<OrgObjectMeasure> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(orgObjectMeasure);
			}
			else {
				listener.onBeforeUpdate(orgObjectMeasure);
			}
		}

		orgObjectMeasure = updateImpl(orgObjectMeasure, merge);

		for (ModelListener<OrgObjectMeasure> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(orgObjectMeasure);
			}
			else {
				listener.onAfterUpdate(orgObjectMeasure);
			}
		}

		return orgObjectMeasure;
	}

	public OrgObjectMeasure updateImpl(
		larion.progate.model.OrgObjectMeasure orgObjectMeasure, boolean merge)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, orgObjectMeasure, merge);

			orgObjectMeasure.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(OrgObjectMeasureModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectMeasureImpl.class, orgObjectMeasure.getPrimaryKey(),
			orgObjectMeasure);

		return orgObjectMeasure;
	}

	public OrgObjectMeasure findByPrimaryKey(Integer orgObjectMeasureId)
		throws NoSuchOrgObjectMeasureException, SystemException {
		OrgObjectMeasure orgObjectMeasure = fetchByPrimaryKey(orgObjectMeasureId);

		if (orgObjectMeasure == null) {
			if (_log.isWarnEnabled()) {
				_log.warn("No OrgObjectMeasure exists with the primary key " +
					orgObjectMeasureId);
			}

			throw new NoSuchOrgObjectMeasureException(
				"No OrgObjectMeasure exists with the primary key " +
				orgObjectMeasureId);
		}

		return orgObjectMeasure;
	}

	public OrgObjectMeasure fetchByPrimaryKey(Integer orgObjectMeasureId)
		throws SystemException {
		OrgObjectMeasure orgObjectMeasure = (OrgObjectMeasure)EntityCacheUtil.getResult(OrgObjectMeasureModelImpl.ENTITY_CACHE_ENABLED,
				OrgObjectMeasureImpl.class, orgObjectMeasureId, this);

		if (orgObjectMeasure == null) {
			Session session = null;

			try {
				session = openSession();

				orgObjectMeasure = (OrgObjectMeasure)session.get(OrgObjectMeasureImpl.class,
						orgObjectMeasureId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (orgObjectMeasure != null) {
					cacheResult(orgObjectMeasure);
				}

				closeSession(session);
			}
		}

		return orgObjectMeasure;
	}

	public List<OrgObjectMeasure> findByOrgObjMeasureName(String name)
		throws SystemException {
		Object[] finderArgs = new Object[] { name };

		List<OrgObjectMeasure> list = (List<OrgObjectMeasure>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ORGOBJMEASURENAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.OrgObjectMeasure WHERE ");

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
					list = new ArrayList<OrgObjectMeasure>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ORGOBJMEASURENAME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<OrgObjectMeasure> findByOrgObjMeasureName(String name,
		int start, int end) throws SystemException {
		return findByOrgObjMeasureName(name, start, end, null);
	}

	public List<OrgObjectMeasure> findByOrgObjMeasureName(String name,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				name,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<OrgObjectMeasure> list = (List<OrgObjectMeasure>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ORGOBJMEASURENAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.OrgObjectMeasure WHERE ");

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

				list = (List<OrgObjectMeasure>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<OrgObjectMeasure>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ORGOBJMEASURENAME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public OrgObjectMeasure findByOrgObjMeasureName_First(String name,
		OrderByComparator obc)
		throws NoSuchOrgObjectMeasureException, SystemException {
		List<OrgObjectMeasure> list = findByOrgObjMeasureName(name, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No OrgObjectMeasure exists with the key {");

			msg.append("name=" + name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrgObjectMeasureException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public OrgObjectMeasure findByOrgObjMeasureName_Last(String name,
		OrderByComparator obc)
		throws NoSuchOrgObjectMeasureException, SystemException {
		int count = countByOrgObjMeasureName(name);

		List<OrgObjectMeasure> list = findByOrgObjMeasureName(name, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No OrgObjectMeasure exists with the key {");

			msg.append("name=" + name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrgObjectMeasureException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public OrgObjectMeasure[] findByOrgObjMeasureName_PrevAndNext(
		Integer orgObjectMeasureId, String name, OrderByComparator obc)
		throws NoSuchOrgObjectMeasureException, SystemException {
		OrgObjectMeasure orgObjectMeasure = findByPrimaryKey(orgObjectMeasureId);

		int count = countByOrgObjMeasureName(name);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.OrgObjectMeasure WHERE ");

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
					orgObjectMeasure);

			OrgObjectMeasure[] array = new OrgObjectMeasureImpl[3];

			array[0] = (OrgObjectMeasure)objArray[0];
			array[1] = (OrgObjectMeasure)objArray[1];
			array[2] = (OrgObjectMeasure)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<OrgObjectMeasure> findByOrgObjectObjectiveId(
		int OrgObjectObjectiveId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(OrgObjectObjectiveId) };

		List<OrgObjectMeasure> list = (List<OrgObjectMeasure>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ORGOBJECTOBJECTIVEID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.OrgObjectMeasure WHERE ");

				query.append("obj_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("obj_id ASC, ");
				query.append("id ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(OrgObjectObjectiveId);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<OrgObjectMeasure>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ORGOBJECTOBJECTIVEID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<OrgObjectMeasure> findByOrgObjectObjectiveId(
		int OrgObjectObjectiveId, int start, int end) throws SystemException {
		return findByOrgObjectObjectiveId(OrgObjectObjectiveId, start, end, null);
	}

	public List<OrgObjectMeasure> findByOrgObjectObjectiveId(
		int OrgObjectObjectiveId, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(OrgObjectObjectiveId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<OrgObjectMeasure> list = (List<OrgObjectMeasure>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ORGOBJECTOBJECTIVEID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.OrgObjectMeasure WHERE ");

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

				qPos.add(OrgObjectObjectiveId);

				list = (List<OrgObjectMeasure>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<OrgObjectMeasure>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ORGOBJECTOBJECTIVEID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public OrgObjectMeasure findByOrgObjectObjectiveId_First(
		int OrgObjectObjectiveId, OrderByComparator obc)
		throws NoSuchOrgObjectMeasureException, SystemException {
		List<OrgObjectMeasure> list = findByOrgObjectObjectiveId(OrgObjectObjectiveId,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No OrgObjectMeasure exists with the key {");

			msg.append("OrgObjectObjectiveId=" + OrgObjectObjectiveId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrgObjectMeasureException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public OrgObjectMeasure findByOrgObjectObjectiveId_Last(
		int OrgObjectObjectiveId, OrderByComparator obc)
		throws NoSuchOrgObjectMeasureException, SystemException {
		int count = countByOrgObjectObjectiveId(OrgObjectObjectiveId);

		List<OrgObjectMeasure> list = findByOrgObjectObjectiveId(OrgObjectObjectiveId,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No OrgObjectMeasure exists with the key {");

			msg.append("OrgObjectObjectiveId=" + OrgObjectObjectiveId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrgObjectMeasureException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public OrgObjectMeasure[] findByOrgObjectObjectiveId_PrevAndNext(
		Integer orgObjectMeasureId, int OrgObjectObjectiveId,
		OrderByComparator obc)
		throws NoSuchOrgObjectMeasureException, SystemException {
		OrgObjectMeasure orgObjectMeasure = findByPrimaryKey(orgObjectMeasureId);

		int count = countByOrgObjectObjectiveId(OrgObjectObjectiveId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.OrgObjectMeasure WHERE ");

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

			qPos.add(OrgObjectObjectiveId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					orgObjectMeasure);

			OrgObjectMeasure[] array = new OrgObjectMeasureImpl[3];

			array[0] = (OrgObjectMeasure)objArray[0];
			array[1] = (OrgObjectMeasure)objArray[1];
			array[2] = (OrgObjectMeasure)objArray[2];

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

	public List<OrgObjectMeasure> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<OrgObjectMeasure> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<OrgObjectMeasure> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<OrgObjectMeasure> list = (List<OrgObjectMeasure>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.OrgObjectMeasure ");

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
					list = (List<OrgObjectMeasure>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<OrgObjectMeasure>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<OrgObjectMeasure>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByOrgObjMeasureName(String name)
		throws SystemException {
		for (OrgObjectMeasure orgObjectMeasure : findByOrgObjMeasureName(name)) {
			remove(orgObjectMeasure);
		}
	}

	public void removeByOrgObjectObjectiveId(int OrgObjectObjectiveId)
		throws SystemException {
		for (OrgObjectMeasure orgObjectMeasure : findByOrgObjectObjectiveId(
				OrgObjectObjectiveId)) {
			remove(orgObjectMeasure);
		}
	}

	public void removeAll() throws SystemException {
		for (OrgObjectMeasure orgObjectMeasure : findAll()) {
			remove(orgObjectMeasure);
		}
	}

	public int countByOrgObjMeasureName(String name) throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ORGOBJMEASURENAME,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.OrgObjectMeasure WHERE ");

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ORGOBJMEASURENAME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByOrgObjectObjectiveId(int OrgObjectObjectiveId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(OrgObjectObjectiveId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ORGOBJECTOBJECTIVEID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.OrgObjectMeasure WHERE ");

				query.append("obj_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(OrgObjectObjectiveId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ORGOBJECTOBJECTIVEID,
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
						"SELECT COUNT(*) FROM larion.progate.model.OrgObjectMeasure");

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

	public List<larion.progate.model.OrgObjectTargets> getOrgObjectTargetses(
		Integer pk) throws SystemException {
		return getOrgObjectTargetses(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public List<larion.progate.model.OrgObjectTargets> getOrgObjectTargetses(
		Integer pk, int start, int end) throws SystemException {
		return getOrgObjectTargetses(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_ORGOBJECTTARGETSES = new FinderPath(larion.progate.model.impl.OrgObjectTargetsModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.model.impl.OrgObjectTargetsModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.service.persistence.OrgObjectTargetsPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getOrgObjectTargetses",
			new String[] {
				Integer.class.getName(), "java.lang.Integer",
				"java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	public List<larion.progate.model.OrgObjectTargets> getOrgObjectTargetses(
		Integer pk, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				pk, String.valueOf(start), String.valueOf(end),
				String.valueOf(obc)
			};

		List<larion.progate.model.OrgObjectTargets> list = (List<larion.progate.model.OrgObjectTargets>)FinderCacheUtil.getResult(FINDER_PATH_GET_ORGOBJECTTARGETSES,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder sb = new StringBuilder();

				sb.append(_SQL_GETORGOBJECTTARGETSES);

				if (obc != null) {
					sb.append("ORDER BY ");
					sb.append(obc.getOrderBy());
				}

				else {
					sb.append("ORDER BY ");

					sb.append("ebsc_orgobjectives_targets.mea_id ASC, ");
					sb.append("ebsc_orgobjectives_targets.id ASC");
				}

				String sql = sb.toString();

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("ebsc_orgobjectives_targets",
					larion.progate.model.impl.OrgObjectTargetsImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<larion.progate.model.OrgObjectTargets>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<larion.progate.model.OrgObjectTargets>();
				}

				orgObjectTargetsPersistence.cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_GET_ORGOBJECTTARGETSES,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_ORGOBJECTTARGETSES_SIZE = new FinderPath(larion.progate.model.impl.OrgObjectTargetsModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.model.impl.OrgObjectTargetsModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.service.persistence.OrgObjectTargetsPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getOrgObjectTargetsesSize",
			new String[] { Integer.class.getName() });

	public int getOrgObjectTargetsesSize(Integer pk) throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_ORGOBJECTTARGETSES_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETORGOBJECTTARGETSESSIZE);

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

				FinderCacheUtil.putResult(FINDER_PATH_GET_ORGOBJECTTARGETSES_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_ORGOBJECTTARGETS = new FinderPath(larion.progate.model.impl.OrgObjectTargetsModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.model.impl.OrgObjectTargetsModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.service.persistence.OrgObjectTargetsPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"containsOrgObjectTargets",
			new String[] { Integer.class.getName(), Integer.class.getName() });

	public boolean containsOrgObjectTargets(Integer pk,
		Integer orgObjectTargetsPK) throws SystemException {
		Object[] finderArgs = new Object[] { pk, orgObjectTargetsPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_ORGOBJECTTARGETS,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsOrgObjectTargets.contains(pk,
							orgObjectTargetsPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_ORGOBJECTTARGETS,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	public boolean containsOrgObjectTargetses(Integer pk)
		throws SystemException {
		if (getOrgObjectTargetsesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.larion.progate.model.OrgObjectMeasure")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<OrgObjectMeasure>> listenersList = new ArrayList<ModelListener<OrgObjectMeasure>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<OrgObjectMeasure>)Class.forName(
							listenerClassName).newInstance());
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		containsOrgObjectTargets = new ContainsOrgObjectTargets(this);
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
	protected ContainsOrgObjectTargets containsOrgObjectTargets;

	protected class ContainsOrgObjectTargets {
		protected ContainsOrgObjectTargets(
			OrgObjectMeasurePersistenceImpl persistenceImpl) {
			super();

			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSORGOBJECTTARGETS,
					new int[] { Types.INTEGER, Types.INTEGER }, RowMapper.COUNT);
		}

		protected boolean contains(Integer orgObjectMeasureId,
			Integer orgObjectTargetId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						orgObjectMeasureId, orgObjectTargetId
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

	private static final String _SQL_GETORGOBJECTTARGETSES = "SELECT {ebsc_orgobjectives_targets.*} FROM ebsc_orgobjectives_targets INNER JOIN ebsc_orgobjectives_measures ON (ebsc_orgobjectives_measures.orgObjectMeasureId = ebsc_orgobjectives_targets.orgObjectMeasureId) WHERE (ebsc_orgobjectives_measures.orgObjectMeasureId = ?)";
	private static final String _SQL_GETORGOBJECTTARGETSESSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM ebsc_orgobjectives_targets WHERE orgObjectMeasureId = ?";
	private static final String _SQL_CONTAINSORGOBJECTTARGETS = "SELECT COUNT(*) AS COUNT_VALUE FROM ebsc_orgobjectives_targets WHERE orgObjectMeasureId = ? AND orgObjectTargetId = ?";
	private static Log _log = LogFactoryUtil.getLog(OrgObjectMeasurePersistenceImpl.class);
}