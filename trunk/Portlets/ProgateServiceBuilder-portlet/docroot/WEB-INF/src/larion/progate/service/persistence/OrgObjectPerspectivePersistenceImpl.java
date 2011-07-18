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

import larion.progate.NoSuchOrgObjectPerspectiveException;

import larion.progate.model.OrgObjectPerspective;
import larion.progate.model.impl.OrgObjectPerspectiveImpl;
import larion.progate.model.impl.OrgObjectPerspectiveModelImpl;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="OrgObjectPerspectivePersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class OrgObjectPerspectivePersistenceImpl extends BasePersistenceImpl
	implements OrgObjectPerspectivePersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = OrgObjectPerspectiveImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_ORGOBJPERSPECTIVENAME = new FinderPath(OrgObjectPerspectiveModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectPerspectiveModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOrgObjPerspectiveName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ORGOBJPERSPECTIVENAME =
		new FinderPath(OrgObjectPerspectiveModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectPerspectiveModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOrgObjPerspectiveName",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGOBJPERSPECTIVENAME = new FinderPath(OrgObjectPerspectiveModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectPerspectiveModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByOrgObjPerspectiveName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ORGOBJTYPE = new FinderPath(OrgObjectPerspectiveModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectPerspectiveModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOrgObjType",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ORGOBJTYPE = new FinderPath(OrgObjectPerspectiveModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectPerspectiveModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOrgObjType",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGOBJTYPE = new FinderPath(OrgObjectPerspectiveModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectPerspectiveModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByOrgObjType",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ORGOBJECTLISTID = new FinderPath(OrgObjectPerspectiveModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectPerspectiveModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByorgObjectListId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ORGOBJECTLISTID = new FinderPath(OrgObjectPerspectiveModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectPerspectiveModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByorgObjectListId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGOBJECTLISTID = new FinderPath(OrgObjectPerspectiveModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectPerspectiveModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByorgObjectListId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(OrgObjectPerspectiveModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectPerspectiveModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OrgObjectPerspectiveModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectPerspectiveModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(OrgObjectPerspective orgObjectPerspective) {
		EntityCacheUtil.putResult(OrgObjectPerspectiveModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectPerspectiveImpl.class,
			orgObjectPerspective.getPrimaryKey(), orgObjectPerspective);
	}

	public void cacheResult(List<OrgObjectPerspective> orgObjectPerspectives) {
		for (OrgObjectPerspective orgObjectPerspective : orgObjectPerspectives) {
			if (EntityCacheUtil.getResult(
						OrgObjectPerspectiveModelImpl.ENTITY_CACHE_ENABLED,
						OrgObjectPerspectiveImpl.class,
						orgObjectPerspective.getPrimaryKey(), this) == null) {
				cacheResult(orgObjectPerspective);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(OrgObjectPerspectiveImpl.class.getName());
		EntityCacheUtil.clearCache(OrgObjectPerspectiveImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public OrgObjectPerspective create(Integer orgObjectPerspectiveId) {
		OrgObjectPerspective orgObjectPerspective = new OrgObjectPerspectiveImpl();

		orgObjectPerspective.setNew(true);
		orgObjectPerspective.setPrimaryKey(orgObjectPerspectiveId);

		return orgObjectPerspective;
	}

	public OrgObjectPerspective remove(Integer orgObjectPerspectiveId)
		throws NoSuchOrgObjectPerspectiveException, SystemException {
		Session session = null;

		try {
			session = openSession();

			OrgObjectPerspective orgObjectPerspective = (OrgObjectPerspective)session.get(OrgObjectPerspectiveImpl.class,
					orgObjectPerspectiveId);

			if (orgObjectPerspective == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No OrgObjectPerspective exists with the primary key " +
						orgObjectPerspectiveId);
				}

				throw new NoSuchOrgObjectPerspectiveException(
					"No OrgObjectPerspective exists with the primary key " +
					orgObjectPerspectiveId);
			}

			return remove(orgObjectPerspective);
		}
		catch (NoSuchOrgObjectPerspectiveException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public OrgObjectPerspective remove(
		OrgObjectPerspective orgObjectPerspective) throws SystemException {
		for (ModelListener<OrgObjectPerspective> listener : listeners) {
			listener.onBeforeRemove(orgObjectPerspective);
		}

		orgObjectPerspective = removeImpl(orgObjectPerspective);

		for (ModelListener<OrgObjectPerspective> listener : listeners) {
			listener.onAfterRemove(orgObjectPerspective);
		}

		return orgObjectPerspective;
	}

	protected OrgObjectPerspective removeImpl(
		OrgObjectPerspective orgObjectPerspective) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (orgObjectPerspective.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(OrgObjectPerspectiveImpl.class,
						orgObjectPerspective.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(orgObjectPerspective);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(OrgObjectPerspectiveModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectPerspectiveImpl.class, orgObjectPerspective.getPrimaryKey());

		return orgObjectPerspective;
	}

	public OrgObjectPerspective update(
		OrgObjectPerspective orgObjectPerspective) throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(OrgObjectPerspective orgObjectPerspective) method. Use update(OrgObjectPerspective orgObjectPerspective, boolean merge) instead.");
		}

		return update(orgObjectPerspective, false);
	}

	public OrgObjectPerspective update(
		OrgObjectPerspective orgObjectPerspective, boolean merge)
		throws SystemException {
		boolean isNew = orgObjectPerspective.isNew();

		for (ModelListener<OrgObjectPerspective> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(orgObjectPerspective);
			}
			else {
				listener.onBeforeUpdate(orgObjectPerspective);
			}
		}

		orgObjectPerspective = updateImpl(orgObjectPerspective, merge);

		for (ModelListener<OrgObjectPerspective> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(orgObjectPerspective);
			}
			else {
				listener.onAfterUpdate(orgObjectPerspective);
			}
		}

		return orgObjectPerspective;
	}

	public OrgObjectPerspective updateImpl(
		larion.progate.model.OrgObjectPerspective orgObjectPerspective,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, orgObjectPerspective, merge);

			orgObjectPerspective.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(OrgObjectPerspectiveModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectPerspectiveImpl.class,
			orgObjectPerspective.getPrimaryKey(), orgObjectPerspective);

		return orgObjectPerspective;
	}

	public OrgObjectPerspective findByPrimaryKey(Integer orgObjectPerspectiveId)
		throws NoSuchOrgObjectPerspectiveException, SystemException {
		OrgObjectPerspective orgObjectPerspective = fetchByPrimaryKey(orgObjectPerspectiveId);

		if (orgObjectPerspective == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"No OrgObjectPerspective exists with the primary key " +
					orgObjectPerspectiveId);
			}

			throw new NoSuchOrgObjectPerspectiveException(
				"No OrgObjectPerspective exists with the primary key " +
				orgObjectPerspectiveId);
		}

		return orgObjectPerspective;
	}

	public OrgObjectPerspective fetchByPrimaryKey(
		Integer orgObjectPerspectiveId) throws SystemException {
		OrgObjectPerspective orgObjectPerspective = (OrgObjectPerspective)EntityCacheUtil.getResult(OrgObjectPerspectiveModelImpl.ENTITY_CACHE_ENABLED,
				OrgObjectPerspectiveImpl.class, orgObjectPerspectiveId, this);

		if (orgObjectPerspective == null) {
			Session session = null;

			try {
				session = openSession();

				orgObjectPerspective = (OrgObjectPerspective)session.get(OrgObjectPerspectiveImpl.class,
						orgObjectPerspectiveId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (orgObjectPerspective != null) {
					cacheResult(orgObjectPerspective);
				}

				closeSession(session);
			}
		}

		return orgObjectPerspective;
	}

	public List<OrgObjectPerspective> findByOrgObjPerspectiveName(String name)
		throws SystemException {
		Object[] finderArgs = new Object[] { name };

		List<OrgObjectPerspective> list = (List<OrgObjectPerspective>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ORGOBJPERSPECTIVENAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.OrgObjectPerspective WHERE ");

				if (name == null) {
					query.append("name IS NULL");
				}
				else {
					query.append("name = ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("obj_id ASC, ");
				query.append("pertype ASC");

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
					list = new ArrayList<OrgObjectPerspective>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ORGOBJPERSPECTIVENAME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<OrgObjectPerspective> findByOrgObjPerspectiveName(String name,
		int start, int end) throws SystemException {
		return findByOrgObjPerspectiveName(name, start, end, null);
	}

	public List<OrgObjectPerspective> findByOrgObjPerspectiveName(String name,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				name,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<OrgObjectPerspective> list = (List<OrgObjectPerspective>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ORGOBJPERSPECTIVENAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.OrgObjectPerspective WHERE ");

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
					query.append("pertype ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (name != null) {
					qPos.add(name);
				}

				list = (List<OrgObjectPerspective>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<OrgObjectPerspective>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ORGOBJPERSPECTIVENAME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public OrgObjectPerspective findByOrgObjPerspectiveName_First(String name,
		OrderByComparator obc)
		throws NoSuchOrgObjectPerspectiveException, SystemException {
		List<OrgObjectPerspective> list = findByOrgObjPerspectiveName(name, 0,
				1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No OrgObjectPerspective exists with the key {");

			msg.append("name=" + name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrgObjectPerspectiveException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public OrgObjectPerspective findByOrgObjPerspectiveName_Last(String name,
		OrderByComparator obc)
		throws NoSuchOrgObjectPerspectiveException, SystemException {
		int count = countByOrgObjPerspectiveName(name);

		List<OrgObjectPerspective> list = findByOrgObjPerspectiveName(name,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No OrgObjectPerspective exists with the key {");

			msg.append("name=" + name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrgObjectPerspectiveException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public OrgObjectPerspective[] findByOrgObjPerspectiveName_PrevAndNext(
		Integer orgObjectPerspectiveId, String name, OrderByComparator obc)
		throws NoSuchOrgObjectPerspectiveException, SystemException {
		OrgObjectPerspective orgObjectPerspective = findByPrimaryKey(orgObjectPerspectiveId);

		int count = countByOrgObjPerspectiveName(name);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.OrgObjectPerspective WHERE ");

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
				query.append("pertype ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (name != null) {
				qPos.add(name);
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					orgObjectPerspective);

			OrgObjectPerspective[] array = new OrgObjectPerspectiveImpl[3];

			array[0] = (OrgObjectPerspective)objArray[0];
			array[1] = (OrgObjectPerspective)objArray[1];
			array[2] = (OrgObjectPerspective)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<OrgObjectPerspective> findByOrgObjType(int pertype)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(pertype) };

		List<OrgObjectPerspective> list = (List<OrgObjectPerspective>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ORGOBJTYPE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.OrgObjectPerspective WHERE ");

				query.append("pertype = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("obj_id ASC, ");
				query.append("pertype ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pertype);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<OrgObjectPerspective>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ORGOBJTYPE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<OrgObjectPerspective> findByOrgObjType(int pertype, int start,
		int end) throws SystemException {
		return findByOrgObjType(pertype, start, end, null);
	}

	public List<OrgObjectPerspective> findByOrgObjType(int pertype, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(pertype),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<OrgObjectPerspective> list = (List<OrgObjectPerspective>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ORGOBJTYPE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.OrgObjectPerspective WHERE ");

				query.append("pertype = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("obj_id ASC, ");
					query.append("pertype ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pertype);

				list = (List<OrgObjectPerspective>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<OrgObjectPerspective>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ORGOBJTYPE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public OrgObjectPerspective findByOrgObjType_First(int pertype,
		OrderByComparator obc)
		throws NoSuchOrgObjectPerspectiveException, SystemException {
		List<OrgObjectPerspective> list = findByOrgObjType(pertype, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No OrgObjectPerspective exists with the key {");

			msg.append("pertype=" + pertype);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrgObjectPerspectiveException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public OrgObjectPerspective findByOrgObjType_Last(int pertype,
		OrderByComparator obc)
		throws NoSuchOrgObjectPerspectiveException, SystemException {
		int count = countByOrgObjType(pertype);

		List<OrgObjectPerspective> list = findByOrgObjType(pertype, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No OrgObjectPerspective exists with the key {");

			msg.append("pertype=" + pertype);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrgObjectPerspectiveException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public OrgObjectPerspective[] findByOrgObjType_PrevAndNext(
		Integer orgObjectPerspectiveId, int pertype, OrderByComparator obc)
		throws NoSuchOrgObjectPerspectiveException, SystemException {
		OrgObjectPerspective orgObjectPerspective = findByPrimaryKey(orgObjectPerspectiveId);

		int count = countByOrgObjType(pertype);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.OrgObjectPerspective WHERE ");

			query.append("pertype = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("obj_id ASC, ");
				query.append("pertype ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(pertype);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					orgObjectPerspective);

			OrgObjectPerspective[] array = new OrgObjectPerspectiveImpl[3];

			array[0] = (OrgObjectPerspective)objArray[0];
			array[1] = (OrgObjectPerspective)objArray[1];
			array[2] = (OrgObjectPerspective)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<OrgObjectPerspective> findByorgObjectListId(int orgObjectListId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(orgObjectListId) };

		List<OrgObjectPerspective> list = (List<OrgObjectPerspective>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ORGOBJECTLISTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.OrgObjectPerspective WHERE ");

				query.append("obj_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("obj_id ASC, ");
				query.append("pertype ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orgObjectListId);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<OrgObjectPerspective>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ORGOBJECTLISTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<OrgObjectPerspective> findByorgObjectListId(
		int orgObjectListId, int start, int end) throws SystemException {
		return findByorgObjectListId(orgObjectListId, start, end, null);
	}

	public List<OrgObjectPerspective> findByorgObjectListId(
		int orgObjectListId, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(orgObjectListId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<OrgObjectPerspective> list = (List<OrgObjectPerspective>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ORGOBJECTLISTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.OrgObjectPerspective WHERE ");

				query.append("obj_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("obj_id ASC, ");
					query.append("pertype ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orgObjectListId);

				list = (List<OrgObjectPerspective>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<OrgObjectPerspective>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ORGOBJECTLISTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public OrgObjectPerspective findByorgObjectListId_First(
		int orgObjectListId, OrderByComparator obc)
		throws NoSuchOrgObjectPerspectiveException, SystemException {
		List<OrgObjectPerspective> list = findByorgObjectListId(orgObjectListId,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No OrgObjectPerspective exists with the key {");

			msg.append("orgObjectListId=" + orgObjectListId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrgObjectPerspectiveException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public OrgObjectPerspective findByorgObjectListId_Last(
		int orgObjectListId, OrderByComparator obc)
		throws NoSuchOrgObjectPerspectiveException, SystemException {
		int count = countByorgObjectListId(orgObjectListId);

		List<OrgObjectPerspective> list = findByorgObjectListId(orgObjectListId,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No OrgObjectPerspective exists with the key {");

			msg.append("orgObjectListId=" + orgObjectListId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrgObjectPerspectiveException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public OrgObjectPerspective[] findByorgObjectListId_PrevAndNext(
		Integer orgObjectPerspectiveId, int orgObjectListId,
		OrderByComparator obc)
		throws NoSuchOrgObjectPerspectiveException, SystemException {
		OrgObjectPerspective orgObjectPerspective = findByPrimaryKey(orgObjectPerspectiveId);

		int count = countByorgObjectListId(orgObjectListId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.OrgObjectPerspective WHERE ");

			query.append("obj_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("obj_id ASC, ");
				query.append("pertype ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(orgObjectListId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					orgObjectPerspective);

			OrgObjectPerspective[] array = new OrgObjectPerspectiveImpl[3];

			array[0] = (OrgObjectPerspective)objArray[0];
			array[1] = (OrgObjectPerspective)objArray[1];
			array[2] = (OrgObjectPerspective)objArray[2];

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

	public List<OrgObjectPerspective> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<OrgObjectPerspective> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<OrgObjectPerspective> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<OrgObjectPerspective> list = (List<OrgObjectPerspective>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.OrgObjectPerspective ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("obj_id ASC, ");
					query.append("pertype ASC");
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<OrgObjectPerspective>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<OrgObjectPerspective>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<OrgObjectPerspective>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByOrgObjPerspectiveName(String name)
		throws SystemException {
		for (OrgObjectPerspective orgObjectPerspective : findByOrgObjPerspectiveName(
				name)) {
			remove(orgObjectPerspective);
		}
	}

	public void removeByOrgObjType(int pertype) throws SystemException {
		for (OrgObjectPerspective orgObjectPerspective : findByOrgObjType(
				pertype)) {
			remove(orgObjectPerspective);
		}
	}

	public void removeByorgObjectListId(int orgObjectListId)
		throws SystemException {
		for (OrgObjectPerspective orgObjectPerspective : findByorgObjectListId(
				orgObjectListId)) {
			remove(orgObjectPerspective);
		}
	}

	public void removeAll() throws SystemException {
		for (OrgObjectPerspective orgObjectPerspective : findAll()) {
			remove(orgObjectPerspective);
		}
	}

	public int countByOrgObjPerspectiveName(String name)
		throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ORGOBJPERSPECTIVENAME,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.OrgObjectPerspective WHERE ");

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ORGOBJPERSPECTIVENAME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByOrgObjType(int pertype) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(pertype) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ORGOBJTYPE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.OrgObjectPerspective WHERE ");

				query.append("pertype = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pertype);

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

	public int countByorgObjectListId(int orgObjectListId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(orgObjectListId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ORGOBJECTLISTID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.OrgObjectPerspective WHERE ");

				query.append("obj_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orgObjectListId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ORGOBJECTLISTID,
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
						"SELECT COUNT(*) FROM larion.progate.model.OrgObjectPerspective");

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

	public List<larion.progate.model.OrgObjectObjective> getOrgObjectObjectives(
		Integer pk) throws SystemException {
		return getOrgObjectObjectives(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public List<larion.progate.model.OrgObjectObjective> getOrgObjectObjectives(
		Integer pk, int start, int end) throws SystemException {
		return getOrgObjectObjectives(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_ORGOBJECTOBJECTIVES = new FinderPath(larion.progate.model.impl.OrgObjectObjectiveModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.model.impl.OrgObjectObjectiveModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.service.persistence.OrgObjectObjectivePersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getOrgObjectObjectives",
			new String[] {
				Integer.class.getName(), "java.lang.Integer",
				"java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	public List<larion.progate.model.OrgObjectObjective> getOrgObjectObjectives(
		Integer pk, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				pk, String.valueOf(start), String.valueOf(end),
				String.valueOf(obc)
			};

		List<larion.progate.model.OrgObjectObjective> list = (List<larion.progate.model.OrgObjectObjective>)FinderCacheUtil.getResult(FINDER_PATH_GET_ORGOBJECTOBJECTIVES,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder sb = new StringBuilder();

				sb.append(_SQL_GETORGOBJECTOBJECTIVES);

				if (obc != null) {
					sb.append("ORDER BY ");
					sb.append(obc.getOrderBy());
				}

				else {
					sb.append("ORDER BY ");

					sb.append("ebsc_orgobjectives_objectives.obj_id ASC, ");
					sb.append("ebsc_orgobjectives_objectives.id ASC");
				}

				String sql = sb.toString();

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("ebsc_orgobjectives_objectives",
					larion.progate.model.impl.OrgObjectObjectiveImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<larion.progate.model.OrgObjectObjective>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<larion.progate.model.OrgObjectObjective>();
				}

				orgObjectObjectivePersistence.cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_GET_ORGOBJECTOBJECTIVES,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_ORGOBJECTOBJECTIVES_SIZE = new FinderPath(larion.progate.model.impl.OrgObjectObjectiveModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.model.impl.OrgObjectObjectiveModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.service.persistence.OrgObjectObjectivePersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getOrgObjectObjectivesSize",
			new String[] { Integer.class.getName() });

	public int getOrgObjectObjectivesSize(Integer pk) throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_ORGOBJECTOBJECTIVES_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETORGOBJECTOBJECTIVESSIZE);

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

				FinderCacheUtil.putResult(FINDER_PATH_GET_ORGOBJECTOBJECTIVES_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_ORGOBJECTOBJECTIVE = new FinderPath(larion.progate.model.impl.OrgObjectObjectiveModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.model.impl.OrgObjectObjectiveModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.service.persistence.OrgObjectObjectivePersistenceImpl.FINDER_CLASS_NAME_LIST,
			"containsOrgObjectObjective",
			new String[] { Integer.class.getName(), Integer.class.getName() });

	public boolean containsOrgObjectObjective(Integer pk,
		Integer orgObjectObjectivePK) throws SystemException {
		Object[] finderArgs = new Object[] { pk, orgObjectObjectivePK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_ORGOBJECTOBJECTIVE,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsOrgObjectObjective.contains(
							pk, orgObjectObjectivePK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_ORGOBJECTOBJECTIVE,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	public boolean containsOrgObjectObjectives(Integer pk)
		throws SystemException {
		if (getOrgObjectObjectivesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.larion.progate.model.OrgObjectPerspective")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<OrgObjectPerspective>> listenersList = new ArrayList<ModelListener<OrgObjectPerspective>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<OrgObjectPerspective>)Class.forName(
							listenerClassName).newInstance());
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		containsOrgObjectObjective = new ContainsOrgObjectObjective(this);
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
	protected ContainsOrgObjectObjective containsOrgObjectObjective;

	protected class ContainsOrgObjectObjective {
		protected ContainsOrgObjectObjective(
			OrgObjectPerspectivePersistenceImpl persistenceImpl) {
			super();

			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSORGOBJECTOBJECTIVE,
					new int[] { Types.INTEGER, Types.INTEGER }, RowMapper.COUNT);
		}

		protected boolean contains(Integer orgObjectPerspectiveId,
			Integer orgObjectObjectiveId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						orgObjectPerspectiveId, orgObjectObjectiveId
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

	private static final String _SQL_GETORGOBJECTOBJECTIVES = "SELECT {ebsc_orgobjectives_objectives.*} FROM ebsc_orgobjectives_objectives INNER JOIN ebsc_orgobjectives_perspectives ON (ebsc_orgobjectives_perspectives.orgObjectPerspectiveId = ebsc_orgobjectives_objectives.orgObjectPerspectiveId) WHERE (ebsc_orgobjectives_perspectives.orgObjectPerspectiveId = ?)";
	private static final String _SQL_GETORGOBJECTOBJECTIVESSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM ebsc_orgobjectives_objectives WHERE orgObjectPerspectiveId = ?";
	private static final String _SQL_CONTAINSORGOBJECTOBJECTIVE = "SELECT COUNT(*) AS COUNT_VALUE FROM ebsc_orgobjectives_objectives WHERE orgObjectPerspectiveId = ? AND orgObjectObjectiveId = ?";
	private static Log _log = LogFactoryUtil.getLog(OrgObjectPerspectivePersistenceImpl.class);
}