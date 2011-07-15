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

import larion.progate.NoSuchOrgObjectListException;

import larion.progate.model.OrgObjectList;
import larion.progate.model.impl.OrgObjectListImpl;
import larion.progate.model.impl.OrgObjectListModelImpl;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="OrgObjectListPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class OrgObjectListPersistenceImpl extends BasePersistenceImpl
	implements OrgObjectListPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = OrgObjectListImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_ORGID = new FinderPath(OrgObjectListModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectListModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOrgId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ORGID = new FinderPath(OrgObjectListModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectListModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOrgId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGID = new FinderPath(OrgObjectListModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectListModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByOrgId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ORGOBJNAME = new FinderPath(OrgObjectListModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectListModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOrgObjName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ORGOBJNAME = new FinderPath(OrgObjectListModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectListModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOrgObjName",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGOBJNAME = new FinderPath(OrgObjectListModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectListModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByOrgObjName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ORGOBJTYPE = new FinderPath(OrgObjectListModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectListModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOrgObjType",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ORGOBJTYPE = new FinderPath(OrgObjectListModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectListModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOrgObjType",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGOBJTYPE = new FinderPath(OrgObjectListModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectListModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByOrgObjType",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ORGOBJYEAR = new FinderPath(OrgObjectListModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectListModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOrgObjYear",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ORGOBJYEAR = new FinderPath(OrgObjectListModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectListModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOrgObjYear",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGOBJYEAR = new FinderPath(OrgObjectListModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectListModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByOrgObjYear",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(OrgObjectListModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectListModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OrgObjectListModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectListModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(OrgObjectList orgObjectList) {
		EntityCacheUtil.putResult(OrgObjectListModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectListImpl.class, orgObjectList.getPrimaryKey(),
			orgObjectList);
	}

	public void cacheResult(List<OrgObjectList> orgObjectLists) {
		for (OrgObjectList orgObjectList : orgObjectLists) {
			if (EntityCacheUtil.getResult(
						OrgObjectListModelImpl.ENTITY_CACHE_ENABLED,
						OrgObjectListImpl.class, orgObjectList.getPrimaryKey(),
						this) == null) {
				cacheResult(orgObjectList);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(OrgObjectListImpl.class.getName());
		EntityCacheUtil.clearCache(OrgObjectListImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public OrgObjectList create(Integer orgObjectListId) {
		OrgObjectList orgObjectList = new OrgObjectListImpl();

		orgObjectList.setNew(true);
		orgObjectList.setPrimaryKey(orgObjectListId);

		return orgObjectList;
	}

	public OrgObjectList remove(Integer orgObjectListId)
		throws NoSuchOrgObjectListException, SystemException {
		Session session = null;

		try {
			session = openSession();

			OrgObjectList orgObjectList = (OrgObjectList)session.get(OrgObjectListImpl.class,
					orgObjectListId);

			if (orgObjectList == null) {
				if (_log.isWarnEnabled()) {
					_log.warn("No OrgObjectList exists with the primary key " +
						orgObjectListId);
				}

				throw new NoSuchOrgObjectListException(
					"No OrgObjectList exists with the primary key " +
					orgObjectListId);
			}

			return remove(orgObjectList);
		}
		catch (NoSuchOrgObjectListException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public OrgObjectList remove(OrgObjectList orgObjectList)
		throws SystemException {
		for (ModelListener<OrgObjectList> listener : listeners) {
			listener.onBeforeRemove(orgObjectList);
		}

		orgObjectList = removeImpl(orgObjectList);

		for (ModelListener<OrgObjectList> listener : listeners) {
			listener.onAfterRemove(orgObjectList);
		}

		return orgObjectList;
	}

	protected OrgObjectList removeImpl(OrgObjectList orgObjectList)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (orgObjectList.isCachedModel() || BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(OrgObjectListImpl.class,
						orgObjectList.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(orgObjectList);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(OrgObjectListModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectListImpl.class, orgObjectList.getPrimaryKey());

		return orgObjectList;
	}

	public OrgObjectList update(OrgObjectList orgObjectList)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(OrgObjectList orgObjectList) method. Use update(OrgObjectList orgObjectList, boolean merge) instead.");
		}

		return update(orgObjectList, false);
	}

	public OrgObjectList update(OrgObjectList orgObjectList, boolean merge)
		throws SystemException {
		boolean isNew = orgObjectList.isNew();

		for (ModelListener<OrgObjectList> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(orgObjectList);
			}
			else {
				listener.onBeforeUpdate(orgObjectList);
			}
		}

		orgObjectList = updateImpl(orgObjectList, merge);

		for (ModelListener<OrgObjectList> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(orgObjectList);
			}
			else {
				listener.onAfterUpdate(orgObjectList);
			}
		}

		return orgObjectList;
	}

	public OrgObjectList updateImpl(
		larion.progate.model.OrgObjectList orgObjectList, boolean merge)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, orgObjectList, merge);

			orgObjectList.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(OrgObjectListModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectListImpl.class, orgObjectList.getPrimaryKey(),
			orgObjectList);

		return orgObjectList;
	}

	public OrgObjectList findByPrimaryKey(Integer orgObjectListId)
		throws NoSuchOrgObjectListException, SystemException {
		OrgObjectList orgObjectList = fetchByPrimaryKey(orgObjectListId);

		if (orgObjectList == null) {
			if (_log.isWarnEnabled()) {
				_log.warn("No OrgObjectList exists with the primary key " +
					orgObjectListId);
			}

			throw new NoSuchOrgObjectListException(
				"No OrgObjectList exists with the primary key " +
				orgObjectListId);
		}

		return orgObjectList;
	}

	public OrgObjectList fetchByPrimaryKey(Integer orgObjectListId)
		throws SystemException {
		OrgObjectList orgObjectList = (OrgObjectList)EntityCacheUtil.getResult(OrgObjectListModelImpl.ENTITY_CACHE_ENABLED,
				OrgObjectListImpl.class, orgObjectListId, this);

		if (orgObjectList == null) {
			Session session = null;

			try {
				session = openSession();

				orgObjectList = (OrgObjectList)session.get(OrgObjectListImpl.class,
						orgObjectListId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (orgObjectList != null) {
					cacheResult(orgObjectList);
				}

				closeSession(session);
			}
		}

		return orgObjectList;
	}

	public List<OrgObjectList> findByOrgId(int org_id)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(org_id) };

		List<OrgObjectList> list = (List<OrgObjectList>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ORGID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.OrgObjectList WHERE ");

				query.append("org_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("year DESC, ");
				query.append("month_hash ASC, ");
				query.append("name DESC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(org_id);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<OrgObjectList>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ORGID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<OrgObjectList> findByOrgId(int org_id, int start, int end)
		throws SystemException {
		return findByOrgId(org_id, start, end, null);
	}

	public List<OrgObjectList> findByOrgId(int org_id, int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(org_id),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<OrgObjectList> list = (List<OrgObjectList>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ORGID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.OrgObjectList WHERE ");

				query.append("org_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("year DESC, ");
					query.append("month_hash ASC, ");
					query.append("name DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(org_id);

				list = (List<OrgObjectList>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<OrgObjectList>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ORGID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public OrgObjectList findByOrgId_First(int org_id, OrderByComparator obc)
		throws NoSuchOrgObjectListException, SystemException {
		List<OrgObjectList> list = findByOrgId(org_id, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No OrgObjectList exists with the key {");

			msg.append("org_id=" + org_id);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrgObjectListException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public OrgObjectList findByOrgId_Last(int org_id, OrderByComparator obc)
		throws NoSuchOrgObjectListException, SystemException {
		int count = countByOrgId(org_id);

		List<OrgObjectList> list = findByOrgId(org_id, count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No OrgObjectList exists with the key {");

			msg.append("org_id=" + org_id);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrgObjectListException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public OrgObjectList[] findByOrgId_PrevAndNext(Integer orgObjectListId,
		int org_id, OrderByComparator obc)
		throws NoSuchOrgObjectListException, SystemException {
		OrgObjectList orgObjectList = findByPrimaryKey(orgObjectListId);

		int count = countByOrgId(org_id);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.OrgObjectList WHERE ");

			query.append("org_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("year DESC, ");
				query.append("month_hash ASC, ");
				query.append("name DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(org_id);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					orgObjectList);

			OrgObjectList[] array = new OrgObjectListImpl[3];

			array[0] = (OrgObjectList)objArray[0];
			array[1] = (OrgObjectList)objArray[1];
			array[2] = (OrgObjectList)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<OrgObjectList> findByOrgObjName(String name)
		throws SystemException {
		Object[] finderArgs = new Object[] { name };

		List<OrgObjectList> list = (List<OrgObjectList>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ORGOBJNAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.OrgObjectList WHERE ");

				if (name == null) {
					query.append("name LIKE null");
				}
				else {
					query.append("name LIKE ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("year DESC, ");
				query.append("month_hash ASC, ");
				query.append("name DESC");

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
					list = new ArrayList<OrgObjectList>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ORGOBJNAME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<OrgObjectList> findByOrgObjName(String name, int start, int end)
		throws SystemException {
		return findByOrgObjName(name, start, end, null);
	}

	public List<OrgObjectList> findByOrgObjName(String name, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				name,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<OrgObjectList> list = (List<OrgObjectList>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ORGOBJNAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.OrgObjectList WHERE ");

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

					query.append("year DESC, ");
					query.append("month_hash ASC, ");
					query.append("name DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (name != null) {
					qPos.add(name);
				}

				list = (List<OrgObjectList>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<OrgObjectList>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ORGOBJNAME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public OrgObjectList findByOrgObjName_First(String name,
		OrderByComparator obc)
		throws NoSuchOrgObjectListException, SystemException {
		List<OrgObjectList> list = findByOrgObjName(name, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No OrgObjectList exists with the key {");

			msg.append("name=" + name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrgObjectListException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public OrgObjectList findByOrgObjName_Last(String name,
		OrderByComparator obc)
		throws NoSuchOrgObjectListException, SystemException {
		int count = countByOrgObjName(name);

		List<OrgObjectList> list = findByOrgObjName(name, count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No OrgObjectList exists with the key {");

			msg.append("name=" + name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrgObjectListException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public OrgObjectList[] findByOrgObjName_PrevAndNext(
		Integer orgObjectListId, String name, OrderByComparator obc)
		throws NoSuchOrgObjectListException, SystemException {
		OrgObjectList orgObjectList = findByPrimaryKey(orgObjectListId);

		int count = countByOrgObjName(name);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.OrgObjectList WHERE ");

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

				query.append("year DESC, ");
				query.append("month_hash ASC, ");
				query.append("name DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (name != null) {
				qPos.add(name);
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					orgObjectList);

			OrgObjectList[] array = new OrgObjectListImpl[3];

			array[0] = (OrgObjectList)objArray[0];
			array[1] = (OrgObjectList)objArray[1];
			array[2] = (OrgObjectList)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<OrgObjectList> findByOrgObjType(int objtype)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(objtype) };

		List<OrgObjectList> list = (List<OrgObjectList>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ORGOBJTYPE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.OrgObjectList WHERE ");

				query.append("objtype = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("year DESC, ");
				query.append("month_hash ASC, ");
				query.append("name DESC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(objtype);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<OrgObjectList>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ORGOBJTYPE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<OrgObjectList> findByOrgObjType(int objtype, int start, int end)
		throws SystemException {
		return findByOrgObjType(objtype, start, end, null);
	}

	public List<OrgObjectList> findByOrgObjType(int objtype, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(objtype),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<OrgObjectList> list = (List<OrgObjectList>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ORGOBJTYPE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.OrgObjectList WHERE ");

				query.append("objtype = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("year DESC, ");
					query.append("month_hash ASC, ");
					query.append("name DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(objtype);

				list = (List<OrgObjectList>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<OrgObjectList>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ORGOBJTYPE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public OrgObjectList findByOrgObjType_First(int objtype,
		OrderByComparator obc)
		throws NoSuchOrgObjectListException, SystemException {
		List<OrgObjectList> list = findByOrgObjType(objtype, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No OrgObjectList exists with the key {");

			msg.append("objtype=" + objtype);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrgObjectListException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public OrgObjectList findByOrgObjType_Last(int objtype,
		OrderByComparator obc)
		throws NoSuchOrgObjectListException, SystemException {
		int count = countByOrgObjType(objtype);

		List<OrgObjectList> list = findByOrgObjType(objtype, count - 1, count,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No OrgObjectList exists with the key {");

			msg.append("objtype=" + objtype);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrgObjectListException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public OrgObjectList[] findByOrgObjType_PrevAndNext(
		Integer orgObjectListId, int objtype, OrderByComparator obc)
		throws NoSuchOrgObjectListException, SystemException {
		OrgObjectList orgObjectList = findByPrimaryKey(orgObjectListId);

		int count = countByOrgObjType(objtype);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.OrgObjectList WHERE ");

			query.append("objtype = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("year DESC, ");
				query.append("month_hash ASC, ");
				query.append("name DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(objtype);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					orgObjectList);

			OrgObjectList[] array = new OrgObjectListImpl[3];

			array[0] = (OrgObjectList)objArray[0];
			array[1] = (OrgObjectList)objArray[1];
			array[2] = (OrgObjectList)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<OrgObjectList> findByOrgObjYear(int year)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(year) };

		List<OrgObjectList> list = (List<OrgObjectList>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ORGOBJYEAR,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.OrgObjectList WHERE ");

				query.append("year = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("year DESC, ");
				query.append("month_hash ASC, ");
				query.append("name DESC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(year);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<OrgObjectList>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ORGOBJYEAR,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<OrgObjectList> findByOrgObjYear(int year, int start, int end)
		throws SystemException {
		return findByOrgObjYear(year, start, end, null);
	}

	public List<OrgObjectList> findByOrgObjYear(int year, int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(year),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<OrgObjectList> list = (List<OrgObjectList>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ORGOBJYEAR,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.OrgObjectList WHERE ");

				query.append("year = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("year DESC, ");
					query.append("month_hash ASC, ");
					query.append("name DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(year);

				list = (List<OrgObjectList>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<OrgObjectList>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ORGOBJYEAR,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public OrgObjectList findByOrgObjYear_First(int year, OrderByComparator obc)
		throws NoSuchOrgObjectListException, SystemException {
		List<OrgObjectList> list = findByOrgObjYear(year, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No OrgObjectList exists with the key {");

			msg.append("year=" + year);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrgObjectListException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public OrgObjectList findByOrgObjYear_Last(int year, OrderByComparator obc)
		throws NoSuchOrgObjectListException, SystemException {
		int count = countByOrgObjYear(year);

		List<OrgObjectList> list = findByOrgObjYear(year, count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No OrgObjectList exists with the key {");

			msg.append("year=" + year);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrgObjectListException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public OrgObjectList[] findByOrgObjYear_PrevAndNext(
		Integer orgObjectListId, int year, OrderByComparator obc)
		throws NoSuchOrgObjectListException, SystemException {
		OrgObjectList orgObjectList = findByPrimaryKey(orgObjectListId);

		int count = countByOrgObjYear(year);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.OrgObjectList WHERE ");

			query.append("year = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("year DESC, ");
				query.append("month_hash ASC, ");
				query.append("name DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(year);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					orgObjectList);

			OrgObjectList[] array = new OrgObjectListImpl[3];

			array[0] = (OrgObjectList)objArray[0];
			array[1] = (OrgObjectList)objArray[1];
			array[2] = (OrgObjectList)objArray[2];

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

	public List<OrgObjectList> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<OrgObjectList> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<OrgObjectList> findAll(int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<OrgObjectList> list = (List<OrgObjectList>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.OrgObjectList ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("year DESC, ");
					query.append("month_hash ASC, ");
					query.append("name DESC");
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<OrgObjectList>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<OrgObjectList>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<OrgObjectList>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByOrgId(int org_id) throws SystemException {
		for (OrgObjectList orgObjectList : findByOrgId(org_id)) {
			remove(orgObjectList);
		}
	}

	public void removeByOrgObjName(String name) throws SystemException {
		for (OrgObjectList orgObjectList : findByOrgObjName(name)) {
			remove(orgObjectList);
		}
	}

	public void removeByOrgObjType(int objtype) throws SystemException {
		for (OrgObjectList orgObjectList : findByOrgObjType(objtype)) {
			remove(orgObjectList);
		}
	}

	public void removeByOrgObjYear(int year) throws SystemException {
		for (OrgObjectList orgObjectList : findByOrgObjYear(year)) {
			remove(orgObjectList);
		}
	}

	public void removeAll() throws SystemException {
		for (OrgObjectList orgObjectList : findAll()) {
			remove(orgObjectList);
		}
	}

	public int countByOrgId(int org_id) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(org_id) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ORGID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append("FROM larion.progate.model.OrgObjectList WHERE ");

				query.append("org_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(org_id);

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

	public int countByOrgObjName(String name) throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ORGOBJNAME,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append("FROM larion.progate.model.OrgObjectList WHERE ");

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ORGOBJNAME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByOrgObjType(int objtype) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(objtype) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ORGOBJTYPE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append("FROM larion.progate.model.OrgObjectList WHERE ");

				query.append("objtype = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(objtype);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ORGOBJTYPE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByOrgObjYear(int year) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(year) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ORGOBJYEAR,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append("FROM larion.progate.model.OrgObjectList WHERE ");

				query.append("year = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(year);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ORGOBJYEAR,
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
						"SELECT COUNT(*) FROM larion.progate.model.OrgObjectList");

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

	public List<larion.progate.model.OrgObjectApproval> getOrgObjectApprovals(
		Integer pk) throws SystemException {
		return getOrgObjectApprovals(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public List<larion.progate.model.OrgObjectApproval> getOrgObjectApprovals(
		Integer pk, int start, int end) throws SystemException {
		return getOrgObjectApprovals(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_ORGOBJECTAPPROVALS = new FinderPath(larion.progate.model.impl.OrgObjectApprovalModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.model.impl.OrgObjectApprovalModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.service.persistence.OrgObjectApprovalPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getOrgObjectApprovals",
			new String[] {
				Integer.class.getName(), "java.lang.Integer",
				"java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	public List<larion.progate.model.OrgObjectApproval> getOrgObjectApprovals(
		Integer pk, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				pk, String.valueOf(start), String.valueOf(end),
				String.valueOf(obc)
			};

		List<larion.progate.model.OrgObjectApproval> list = (List<larion.progate.model.OrgObjectApproval>)FinderCacheUtil.getResult(FINDER_PATH_GET_ORGOBJECTAPPROVALS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder sb = new StringBuilder();

				sb.append(_SQL_GETORGOBJECTAPPROVALS);

				if (obc != null) {
					sb.append("ORDER BY ");
					sb.append(obc.getOrderBy());
				}

				String sql = sb.toString();

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("ebsc_orgobjectives_approval",
					larion.progate.model.impl.OrgObjectApprovalImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<larion.progate.model.OrgObjectApproval>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<larion.progate.model.OrgObjectApproval>();
				}

				orgObjectApprovalPersistence.cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_GET_ORGOBJECTAPPROVALS,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_ORGOBJECTAPPROVALS_SIZE = new FinderPath(larion.progate.model.impl.OrgObjectApprovalModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.model.impl.OrgObjectApprovalModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.service.persistence.OrgObjectApprovalPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getOrgObjectApprovalsSize",
			new String[] { Integer.class.getName() });

	public int getOrgObjectApprovalsSize(Integer pk) throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_ORGOBJECTAPPROVALS_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETORGOBJECTAPPROVALSSIZE);

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

				FinderCacheUtil.putResult(FINDER_PATH_GET_ORGOBJECTAPPROVALS_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_ORGOBJECTAPPROVAL = new FinderPath(larion.progate.model.impl.OrgObjectApprovalModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.model.impl.OrgObjectApprovalModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.service.persistence.OrgObjectApprovalPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"containsOrgObjectApproval",
			new String[] { Integer.class.getName(), Integer.class.getName() });

	public boolean containsOrgObjectApproval(Integer pk,
		Integer orgObjectApprovalPK) throws SystemException {
		Object[] finderArgs = new Object[] { pk, orgObjectApprovalPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_ORGOBJECTAPPROVAL,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsOrgObjectApproval.contains(pk,
							orgObjectApprovalPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_ORGOBJECTAPPROVAL,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	public boolean containsOrgObjectApprovals(Integer pk)
		throws SystemException {
		if (getOrgObjectApprovalsSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public List<larion.progate.model.OrgObjectPerspective> getOrgObjectPerspectives(
		Integer pk) throws SystemException {
		return getOrgObjectPerspectives(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public List<larion.progate.model.OrgObjectPerspective> getOrgObjectPerspectives(
		Integer pk, int start, int end) throws SystemException {
		return getOrgObjectPerspectives(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_ORGOBJECTPERSPECTIVES = new FinderPath(larion.progate.model.impl.OrgObjectPerspectiveModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.model.impl.OrgObjectPerspectiveModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.service.persistence.OrgObjectPerspectivePersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getOrgObjectPerspectives",
			new String[] {
				Integer.class.getName(), "java.lang.Integer",
				"java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	public List<larion.progate.model.OrgObjectPerspective> getOrgObjectPerspectives(
		Integer pk, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				pk, String.valueOf(start), String.valueOf(end),
				String.valueOf(obc)
			};

		List<larion.progate.model.OrgObjectPerspective> list = (List<larion.progate.model.OrgObjectPerspective>)FinderCacheUtil.getResult(FINDER_PATH_GET_ORGOBJECTPERSPECTIVES,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder sb = new StringBuilder();

				sb.append(_SQL_GETORGOBJECTPERSPECTIVES);

				if (obc != null) {
					sb.append("ORDER BY ");
					sb.append(obc.getOrderBy());
				}

				else {
					sb.append("ORDER BY ");

					sb.append("ebsc_orgobjectives_perspectives.obj_id ASC, ");
					sb.append("ebsc_orgobjectives_perspectives.pertype ASC");
				}

				String sql = sb.toString();

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("ebsc_orgobjectives_perspectives",
					larion.progate.model.impl.OrgObjectPerspectiveImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<larion.progate.model.OrgObjectPerspective>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<larion.progate.model.OrgObjectPerspective>();
				}

				orgObjectPerspectivePersistence.cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_GET_ORGOBJECTPERSPECTIVES,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_ORGOBJECTPERSPECTIVES_SIZE = new FinderPath(larion.progate.model.impl.OrgObjectPerspectiveModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.model.impl.OrgObjectPerspectiveModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.service.persistence.OrgObjectPerspectivePersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getOrgObjectPerspectivesSize",
			new String[] { Integer.class.getName() });

	public int getOrgObjectPerspectivesSize(Integer pk)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_ORGOBJECTPERSPECTIVES_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETORGOBJECTPERSPECTIVESSIZE);

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

				FinderCacheUtil.putResult(FINDER_PATH_GET_ORGOBJECTPERSPECTIVES_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_ORGOBJECTPERSPECTIVE = new FinderPath(larion.progate.model.impl.OrgObjectPerspectiveModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.model.impl.OrgObjectPerspectiveModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.service.persistence.OrgObjectPerspectivePersistenceImpl.FINDER_CLASS_NAME_LIST,
			"containsOrgObjectPerspective",
			new String[] { Integer.class.getName(), Integer.class.getName() });

	public boolean containsOrgObjectPerspective(Integer pk,
		Integer orgObjectPerspectivePK) throws SystemException {
		Object[] finderArgs = new Object[] { pk, orgObjectPerspectivePK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_ORGOBJECTPERSPECTIVE,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsOrgObjectPerspective.contains(
							pk, orgObjectPerspectivePK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_ORGOBJECTPERSPECTIVE,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	public boolean containsOrgObjectPerspectives(Integer pk)
		throws SystemException {
		if (getOrgObjectPerspectivesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.larion.progate.model.OrgObjectList")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<OrgObjectList>> listenersList = new ArrayList<ModelListener<OrgObjectList>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<OrgObjectList>)Class.forName(
							listenerClassName).newInstance());
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		containsOrgObjectApproval = new ContainsOrgObjectApproval(this);

		containsOrgObjectPerspective = new ContainsOrgObjectPerspective(this);
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
	protected ContainsOrgObjectApproval containsOrgObjectApproval;
	protected ContainsOrgObjectPerspective containsOrgObjectPerspective;

	protected class ContainsOrgObjectApproval {
		protected ContainsOrgObjectApproval(
			OrgObjectListPersistenceImpl persistenceImpl) {
			super();

			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSORGOBJECTAPPROVAL,
					new int[] { Types.INTEGER, Types.INTEGER }, RowMapper.COUNT);
		}

		protected boolean contains(Integer orgObjectListId,
			Integer orgObjectApprovalId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						orgObjectListId, orgObjectApprovalId
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

	protected class ContainsOrgObjectPerspective {
		protected ContainsOrgObjectPerspective(
			OrgObjectListPersistenceImpl persistenceImpl) {
			super();

			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSORGOBJECTPERSPECTIVE,
					new int[] { Types.INTEGER, Types.INTEGER }, RowMapper.COUNT);
		}

		protected boolean contains(Integer orgObjectListId,
			Integer orgObjectPerspectiveId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						orgObjectListId, orgObjectPerspectiveId
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

	private static final String _SQL_GETORGOBJECTAPPROVALS = "SELECT {ebsc_orgobjectives_approval.*} FROM ebsc_orgobjectives_approval INNER JOIN ebsc_orgobjectives_list ON (ebsc_orgobjectives_list.orgObjectListId = ebsc_orgobjectives_approval.orgObjectListId) WHERE (ebsc_orgobjectives_list.orgObjectListId = ?)";
	private static final String _SQL_GETORGOBJECTAPPROVALSSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM ebsc_orgobjectives_approval WHERE orgObjectListId = ?";
	private static final String _SQL_CONTAINSORGOBJECTAPPROVAL = "SELECT COUNT(*) AS COUNT_VALUE FROM ebsc_orgobjectives_approval WHERE orgObjectListId = ? AND orgObjectApprovalId = ?";
	private static final String _SQL_GETORGOBJECTPERSPECTIVES = "SELECT {ebsc_orgobjectives_perspectives.*} FROM ebsc_orgobjectives_perspectives INNER JOIN ebsc_orgobjectives_list ON (ebsc_orgobjectives_list.orgObjectListId = ebsc_orgobjectives_perspectives.orgObjectListId) WHERE (ebsc_orgobjectives_list.orgObjectListId = ?)";
	private static final String _SQL_GETORGOBJECTPERSPECTIVESSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM ebsc_orgobjectives_perspectives WHERE orgObjectListId = ?";
	private static final String _SQL_CONTAINSORGOBJECTPERSPECTIVE = "SELECT COUNT(*) AS COUNT_VALUE FROM ebsc_orgobjectives_perspectives WHERE orgObjectListId = ? AND orgObjectPerspectiveId = ?";
	private static Log _log = LogFactoryUtil.getLog(OrgObjectListPersistenceImpl.class);
}