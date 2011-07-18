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

import larion.progate.NoSuchOrgObjectTargetsException;

import larion.progate.model.OrgObjectTargets;
import larion.progate.model.impl.OrgObjectTargetsImpl;
import larion.progate.model.impl.OrgObjectTargetsModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="OrgObjectTargetsPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class OrgObjectTargetsPersistenceImpl extends BasePersistenceImpl
	implements OrgObjectTargetsPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = OrgObjectTargetsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_ORGOBJTARGETNAME = new FinderPath(OrgObjectTargetsModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectTargetsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOrgObjTargetName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ORGOBJTARGETNAME = new FinderPath(OrgObjectTargetsModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectTargetsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOrgObjTargetName",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGOBJTARGETNAME = new FinderPath(OrgObjectTargetsModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectTargetsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByOrgObjTargetName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ORGOBJECTMEASUREID = new FinderPath(OrgObjectTargetsModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectTargetsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByorgObjectMeasureId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ORGOBJECTMEASUREID = new FinderPath(OrgObjectTargetsModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectTargetsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByorgObjectMeasureId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGOBJECTMEASUREID = new FinderPath(OrgObjectTargetsModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectTargetsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByorgObjectMeasureId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(OrgObjectTargetsModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectTargetsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OrgObjectTargetsModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectTargetsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(OrgObjectTargets orgObjectTargets) {
		EntityCacheUtil.putResult(OrgObjectTargetsModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectTargetsImpl.class, orgObjectTargets.getPrimaryKey(),
			orgObjectTargets);
	}

	public void cacheResult(List<OrgObjectTargets> orgObjectTargetses) {
		for (OrgObjectTargets orgObjectTargets : orgObjectTargetses) {
			if (EntityCacheUtil.getResult(
						OrgObjectTargetsModelImpl.ENTITY_CACHE_ENABLED,
						OrgObjectTargetsImpl.class,
						orgObjectTargets.getPrimaryKey(), this) == null) {
				cacheResult(orgObjectTargets);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(OrgObjectTargetsImpl.class.getName());
		EntityCacheUtil.clearCache(OrgObjectTargetsImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public OrgObjectTargets create(Integer orgObjectTargetId) {
		OrgObjectTargets orgObjectTargets = new OrgObjectTargetsImpl();

		orgObjectTargets.setNew(true);
		orgObjectTargets.setPrimaryKey(orgObjectTargetId);

		return orgObjectTargets;
	}

	public OrgObjectTargets remove(Integer orgObjectTargetId)
		throws NoSuchOrgObjectTargetsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			OrgObjectTargets orgObjectTargets = (OrgObjectTargets)session.get(OrgObjectTargetsImpl.class,
					orgObjectTargetId);

			if (orgObjectTargets == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No OrgObjectTargets exists with the primary key " +
						orgObjectTargetId);
				}

				throw new NoSuchOrgObjectTargetsException(
					"No OrgObjectTargets exists with the primary key " +
					orgObjectTargetId);
			}

			return remove(orgObjectTargets);
		}
		catch (NoSuchOrgObjectTargetsException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public OrgObjectTargets remove(OrgObjectTargets orgObjectTargets)
		throws SystemException {
		for (ModelListener<OrgObjectTargets> listener : listeners) {
			listener.onBeforeRemove(orgObjectTargets);
		}

		orgObjectTargets = removeImpl(orgObjectTargets);

		for (ModelListener<OrgObjectTargets> listener : listeners) {
			listener.onAfterRemove(orgObjectTargets);
		}

		return orgObjectTargets;
	}

	protected OrgObjectTargets removeImpl(OrgObjectTargets orgObjectTargets)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (orgObjectTargets.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(OrgObjectTargetsImpl.class,
						orgObjectTargets.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(orgObjectTargets);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(OrgObjectTargetsModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectTargetsImpl.class, orgObjectTargets.getPrimaryKey());

		return orgObjectTargets;
	}

	public OrgObjectTargets update(OrgObjectTargets orgObjectTargets)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(OrgObjectTargets orgObjectTargets) method. Use update(OrgObjectTargets orgObjectTargets, boolean merge) instead.");
		}

		return update(orgObjectTargets, false);
	}

	public OrgObjectTargets update(OrgObjectTargets orgObjectTargets,
		boolean merge) throws SystemException {
		boolean isNew = orgObjectTargets.isNew();

		for (ModelListener<OrgObjectTargets> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(orgObjectTargets);
			}
			else {
				listener.onBeforeUpdate(orgObjectTargets);
			}
		}

		orgObjectTargets = updateImpl(orgObjectTargets, merge);

		for (ModelListener<OrgObjectTargets> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(orgObjectTargets);
			}
			else {
				listener.onAfterUpdate(orgObjectTargets);
			}
		}

		return orgObjectTargets;
	}

	public OrgObjectTargets updateImpl(
		larion.progate.model.OrgObjectTargets orgObjectTargets, boolean merge)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, orgObjectTargets, merge);

			orgObjectTargets.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(OrgObjectTargetsModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectTargetsImpl.class, orgObjectTargets.getPrimaryKey(),
			orgObjectTargets);

		return orgObjectTargets;
	}

	public OrgObjectTargets findByPrimaryKey(Integer orgObjectTargetId)
		throws NoSuchOrgObjectTargetsException, SystemException {
		OrgObjectTargets orgObjectTargets = fetchByPrimaryKey(orgObjectTargetId);

		if (orgObjectTargets == null) {
			if (_log.isWarnEnabled()) {
				_log.warn("No OrgObjectTargets exists with the primary key " +
					orgObjectTargetId);
			}

			throw new NoSuchOrgObjectTargetsException(
				"No OrgObjectTargets exists with the primary key " +
				orgObjectTargetId);
		}

		return orgObjectTargets;
	}

	public OrgObjectTargets fetchByPrimaryKey(Integer orgObjectTargetId)
		throws SystemException {
		OrgObjectTargets orgObjectTargets = (OrgObjectTargets)EntityCacheUtil.getResult(OrgObjectTargetsModelImpl.ENTITY_CACHE_ENABLED,
				OrgObjectTargetsImpl.class, orgObjectTargetId, this);

		if (orgObjectTargets == null) {
			Session session = null;

			try {
				session = openSession();

				orgObjectTargets = (OrgObjectTargets)session.get(OrgObjectTargetsImpl.class,
						orgObjectTargetId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (orgObjectTargets != null) {
					cacheResult(orgObjectTargets);
				}

				closeSession(session);
			}
		}

		return orgObjectTargets;
	}

	public List<OrgObjectTargets> findByOrgObjTargetName(String name)
		throws SystemException {
		Object[] finderArgs = new Object[] { name };

		List<OrgObjectTargets> list = (List<OrgObjectTargets>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ORGOBJTARGETNAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.OrgObjectTargets WHERE ");

				if (name == null) {
					query.append("name IS NULL");
				}
				else {
					query.append("name = ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("mea_id ASC, ");
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
					list = new ArrayList<OrgObjectTargets>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ORGOBJTARGETNAME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<OrgObjectTargets> findByOrgObjTargetName(String name,
		int start, int end) throws SystemException {
		return findByOrgObjTargetName(name, start, end, null);
	}

	public List<OrgObjectTargets> findByOrgObjTargetName(String name,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				name,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<OrgObjectTargets> list = (List<OrgObjectTargets>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ORGOBJTARGETNAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.OrgObjectTargets WHERE ");

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

					query.append("mea_id ASC, ");
					query.append("id ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (name != null) {
					qPos.add(name);
				}

				list = (List<OrgObjectTargets>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<OrgObjectTargets>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ORGOBJTARGETNAME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public OrgObjectTargets findByOrgObjTargetName_First(String name,
		OrderByComparator obc)
		throws NoSuchOrgObjectTargetsException, SystemException {
		List<OrgObjectTargets> list = findByOrgObjTargetName(name, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No OrgObjectTargets exists with the key {");

			msg.append("name=" + name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrgObjectTargetsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public OrgObjectTargets findByOrgObjTargetName_Last(String name,
		OrderByComparator obc)
		throws NoSuchOrgObjectTargetsException, SystemException {
		int count = countByOrgObjTargetName(name);

		List<OrgObjectTargets> list = findByOrgObjTargetName(name, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No OrgObjectTargets exists with the key {");

			msg.append("name=" + name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrgObjectTargetsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public OrgObjectTargets[] findByOrgObjTargetName_PrevAndNext(
		Integer orgObjectTargetId, String name, OrderByComparator obc)
		throws NoSuchOrgObjectTargetsException, SystemException {
		OrgObjectTargets orgObjectTargets = findByPrimaryKey(orgObjectTargetId);

		int count = countByOrgObjTargetName(name);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.OrgObjectTargets WHERE ");

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

				query.append("mea_id ASC, ");
				query.append("id ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (name != null) {
				qPos.add(name);
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					orgObjectTargets);

			OrgObjectTargets[] array = new OrgObjectTargetsImpl[3];

			array[0] = (OrgObjectTargets)objArray[0];
			array[1] = (OrgObjectTargets)objArray[1];
			array[2] = (OrgObjectTargets)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<OrgObjectTargets> findByorgObjectMeasureId(
		int orgObjectMeasureId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(orgObjectMeasureId) };

		List<OrgObjectTargets> list = (List<OrgObjectTargets>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ORGOBJECTMEASUREID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.OrgObjectTargets WHERE ");

				query.append("mea_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("mea_id ASC, ");
				query.append("id ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orgObjectMeasureId);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<OrgObjectTargets>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ORGOBJECTMEASUREID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<OrgObjectTargets> findByorgObjectMeasureId(
		int orgObjectMeasureId, int start, int end) throws SystemException {
		return findByorgObjectMeasureId(orgObjectMeasureId, start, end, null);
	}

	public List<OrgObjectTargets> findByorgObjectMeasureId(
		int orgObjectMeasureId, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(orgObjectMeasureId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<OrgObjectTargets> list = (List<OrgObjectTargets>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ORGOBJECTMEASUREID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.OrgObjectTargets WHERE ");

				query.append("mea_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("mea_id ASC, ");
					query.append("id ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orgObjectMeasureId);

				list = (List<OrgObjectTargets>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<OrgObjectTargets>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ORGOBJECTMEASUREID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public OrgObjectTargets findByorgObjectMeasureId_First(
		int orgObjectMeasureId, OrderByComparator obc)
		throws NoSuchOrgObjectTargetsException, SystemException {
		List<OrgObjectTargets> list = findByorgObjectMeasureId(orgObjectMeasureId,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No OrgObjectTargets exists with the key {");

			msg.append("orgObjectMeasureId=" + orgObjectMeasureId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrgObjectTargetsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public OrgObjectTargets findByorgObjectMeasureId_Last(
		int orgObjectMeasureId, OrderByComparator obc)
		throws NoSuchOrgObjectTargetsException, SystemException {
		int count = countByorgObjectMeasureId(orgObjectMeasureId);

		List<OrgObjectTargets> list = findByorgObjectMeasureId(orgObjectMeasureId,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No OrgObjectTargets exists with the key {");

			msg.append("orgObjectMeasureId=" + orgObjectMeasureId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrgObjectTargetsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public OrgObjectTargets[] findByorgObjectMeasureId_PrevAndNext(
		Integer orgObjectTargetId, int orgObjectMeasureId, OrderByComparator obc)
		throws NoSuchOrgObjectTargetsException, SystemException {
		OrgObjectTargets orgObjectTargets = findByPrimaryKey(orgObjectTargetId);

		int count = countByorgObjectMeasureId(orgObjectMeasureId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.OrgObjectTargets WHERE ");

			query.append("mea_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("mea_id ASC, ");
				query.append("id ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(orgObjectMeasureId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					orgObjectTargets);

			OrgObjectTargets[] array = new OrgObjectTargetsImpl[3];

			array[0] = (OrgObjectTargets)objArray[0];
			array[1] = (OrgObjectTargets)objArray[1];
			array[2] = (OrgObjectTargets)objArray[2];

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

	public List<OrgObjectTargets> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<OrgObjectTargets> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<OrgObjectTargets> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<OrgObjectTargets> list = (List<OrgObjectTargets>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.OrgObjectTargets ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("mea_id ASC, ");
					query.append("id ASC");
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<OrgObjectTargets>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<OrgObjectTargets>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<OrgObjectTargets>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByOrgObjTargetName(String name) throws SystemException {
		for (OrgObjectTargets orgObjectTargets : findByOrgObjTargetName(name)) {
			remove(orgObjectTargets);
		}
	}

	public void removeByorgObjectMeasureId(int orgObjectMeasureId)
		throws SystemException {
		for (OrgObjectTargets orgObjectTargets : findByorgObjectMeasureId(
				orgObjectMeasureId)) {
			remove(orgObjectTargets);
		}
	}

	public void removeAll() throws SystemException {
		for (OrgObjectTargets orgObjectTargets : findAll()) {
			remove(orgObjectTargets);
		}
	}

	public int countByOrgObjTargetName(String name) throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ORGOBJTARGETNAME,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.OrgObjectTargets WHERE ");

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ORGOBJTARGETNAME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByorgObjectMeasureId(int orgObjectMeasureId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(orgObjectMeasureId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ORGOBJECTMEASUREID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.OrgObjectTargets WHERE ");

				query.append("mea_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orgObjectMeasureId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ORGOBJECTMEASUREID,
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
						"SELECT COUNT(*) FROM larion.progate.model.OrgObjectTargets");

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
						"value.object.listener.larion.progate.model.OrgObjectTargets")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<OrgObjectTargets>> listenersList = new ArrayList<ModelListener<OrgObjectTargets>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<OrgObjectTargets>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(OrgObjectTargetsPersistenceImpl.class);
}