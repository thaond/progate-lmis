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

import larion.progate.NoSuchProGateOrgTypeException;

import larion.progate.model.ProGateOrgType;
import larion.progate.model.impl.ProGateOrgTypeImpl;
import larion.progate.model.impl.ProGateOrgTypeModelImpl;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="ProGateOrgTypePersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateOrgTypePersistenceImpl extends BasePersistenceImpl
	implements ProGateOrgTypePersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = ProGateOrgTypeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_NAME = new FinderPath(ProGateOrgTypeModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgTypeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByname",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_NAME = new FinderPath(ProGateOrgTypeModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgTypeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByname",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(ProGateOrgTypeModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgTypeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByname",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_STATUS = new FinderPath(ProGateOrgTypeModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgTypeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBystatus",
			new String[] { Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_STATUS = new FinderPath(ProGateOrgTypeModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgTypeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBystatus",
			new String[] {
				Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(ProGateOrgTypeModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgTypeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBystatus",
			new String[] { Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(ProGateOrgTypeModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgTypeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProGateOrgTypeModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgTypeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(ProGateOrgType proGateOrgType) {
		EntityCacheUtil.putResult(ProGateOrgTypeModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgTypeImpl.class, proGateOrgType.getPrimaryKey(),
			proGateOrgType);
	}

	public void cacheResult(List<ProGateOrgType> proGateOrgTypes) {
		for (ProGateOrgType proGateOrgType : proGateOrgTypes) {
			if (EntityCacheUtil.getResult(
						ProGateOrgTypeModelImpl.ENTITY_CACHE_ENABLED,
						ProGateOrgTypeImpl.class,
						proGateOrgType.getPrimaryKey(), this) == null) {
				cacheResult(proGateOrgType);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(ProGateOrgTypeImpl.class.getName());
		EntityCacheUtil.clearCache(ProGateOrgTypeImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public ProGateOrgType create(Integer orgTypeId) {
		ProGateOrgType proGateOrgType = new ProGateOrgTypeImpl();

		proGateOrgType.setNew(true);
		proGateOrgType.setPrimaryKey(orgTypeId);

		return proGateOrgType;
	}

	public ProGateOrgType remove(Integer orgTypeId)
		throws NoSuchProGateOrgTypeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ProGateOrgType proGateOrgType = (ProGateOrgType)session.get(ProGateOrgTypeImpl.class,
					orgTypeId);

			if (proGateOrgType == null) {
				if (_log.isWarnEnabled()) {
					_log.warn("No ProGateOrgType exists with the primary key " +
						orgTypeId);
				}

				throw new NoSuchProGateOrgTypeException(
					"No ProGateOrgType exists with the primary key " +
					orgTypeId);
			}

			return remove(proGateOrgType);
		}
		catch (NoSuchProGateOrgTypeException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public ProGateOrgType remove(ProGateOrgType proGateOrgType)
		throws SystemException {
		for (ModelListener<ProGateOrgType> listener : listeners) {
			listener.onBeforeRemove(proGateOrgType);
		}

		proGateOrgType = removeImpl(proGateOrgType);

		for (ModelListener<ProGateOrgType> listener : listeners) {
			listener.onAfterRemove(proGateOrgType);
		}

		return proGateOrgType;
	}

	protected ProGateOrgType removeImpl(ProGateOrgType proGateOrgType)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (proGateOrgType.isCachedModel() || BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(ProGateOrgTypeImpl.class,
						proGateOrgType.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(proGateOrgType);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(ProGateOrgTypeModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgTypeImpl.class, proGateOrgType.getPrimaryKey());

		return proGateOrgType;
	}

	public ProGateOrgType update(ProGateOrgType proGateOrgType)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(ProGateOrgType proGateOrgType) method. Use update(ProGateOrgType proGateOrgType, boolean merge) instead.");
		}

		return update(proGateOrgType, false);
	}

	public ProGateOrgType update(ProGateOrgType proGateOrgType, boolean merge)
		throws SystemException {
		boolean isNew = proGateOrgType.isNew();

		for (ModelListener<ProGateOrgType> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(proGateOrgType);
			}
			else {
				listener.onBeforeUpdate(proGateOrgType);
			}
		}

		proGateOrgType = updateImpl(proGateOrgType, merge);

		for (ModelListener<ProGateOrgType> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(proGateOrgType);
			}
			else {
				listener.onAfterUpdate(proGateOrgType);
			}
		}

		return proGateOrgType;
	}

	public ProGateOrgType updateImpl(
		larion.progate.model.ProGateOrgType proGateOrgType, boolean merge)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, proGateOrgType, merge);

			proGateOrgType.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(ProGateOrgTypeModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgTypeImpl.class, proGateOrgType.getPrimaryKey(),
			proGateOrgType);

		return proGateOrgType;
	}

	public ProGateOrgType findByPrimaryKey(Integer orgTypeId)
		throws NoSuchProGateOrgTypeException, SystemException {
		ProGateOrgType proGateOrgType = fetchByPrimaryKey(orgTypeId);

		if (proGateOrgType == null) {
			if (_log.isWarnEnabled()) {
				_log.warn("No ProGateOrgType exists with the primary key " +
					orgTypeId);
			}

			throw new NoSuchProGateOrgTypeException(
				"No ProGateOrgType exists with the primary key " + orgTypeId);
		}

		return proGateOrgType;
	}

	public ProGateOrgType fetchByPrimaryKey(Integer orgTypeId)
		throws SystemException {
		ProGateOrgType proGateOrgType = (ProGateOrgType)EntityCacheUtil.getResult(ProGateOrgTypeModelImpl.ENTITY_CACHE_ENABLED,
				ProGateOrgTypeImpl.class, orgTypeId, this);

		if (proGateOrgType == null) {
			Session session = null;

			try {
				session = openSession();

				proGateOrgType = (ProGateOrgType)session.get(ProGateOrgTypeImpl.class,
						orgTypeId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (proGateOrgType != null) {
					cacheResult(proGateOrgType);
				}

				closeSession(session);
			}
		}

		return proGateOrgType;
	}

	public List<ProGateOrgType> findByname(String name)
		throws SystemException {
		Object[] finderArgs = new Object[] { name };

		List<ProGateOrgType> list = (List<ProGateOrgType>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_NAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.ProGateOrgType WHERE ");

				if (name == null) {
					query.append("name IS NULL");
				}
				else {
					query.append("name = ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("description ASC");

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
					list = new ArrayList<ProGateOrgType>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_NAME, finderArgs,
					list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateOrgType> findByname(String name, int start, int end)
		throws SystemException {
		return findByname(name, start, end, null);
	}

	public List<ProGateOrgType> findByname(String name, int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				name,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateOrgType> list = (List<ProGateOrgType>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_NAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.ProGateOrgType WHERE ");

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

					query.append("description ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (name != null) {
					qPos.add(name);
				}

				list = (List<ProGateOrgType>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateOrgType>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_NAME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateOrgType findByname_First(String name, OrderByComparator obc)
		throws NoSuchProGateOrgTypeException, SystemException {
		List<ProGateOrgType> list = findByname(name, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateOrgType exists with the key {");

			msg.append("name=" + name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateOrgTypeException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateOrgType findByname_Last(String name, OrderByComparator obc)
		throws NoSuchProGateOrgTypeException, SystemException {
		int count = countByname(name);

		List<ProGateOrgType> list = findByname(name, count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateOrgType exists with the key {");

			msg.append("name=" + name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateOrgTypeException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateOrgType[] findByname_PrevAndNext(Integer orgTypeId,
		String name, OrderByComparator obc)
		throws NoSuchProGateOrgTypeException, SystemException {
		ProGateOrgType proGateOrgType = findByPrimaryKey(orgTypeId);

		int count = countByname(name);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.ProGateOrgType WHERE ");

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

				query.append("description ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (name != null) {
				qPos.add(name);
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateOrgType);

			ProGateOrgType[] array = new ProGateOrgTypeImpl[3];

			array[0] = (ProGateOrgType)objArray[0];
			array[1] = (ProGateOrgType)objArray[1];
			array[2] = (ProGateOrgType)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateOrgType> findBystatus(boolean status)
		throws SystemException {
		Object[] finderArgs = new Object[] { Boolean.valueOf(status) };

		List<ProGateOrgType> list = (List<ProGateOrgType>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_STATUS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.ProGateOrgType WHERE ");

				query.append("status = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("description ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateOrgType>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_STATUS,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateOrgType> findBystatus(boolean status, int start, int end)
		throws SystemException {
		return findBystatus(status, start, end, null);
	}

	public List<ProGateOrgType> findBystatus(boolean status, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				Boolean.valueOf(status),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateOrgType> list = (List<ProGateOrgType>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_STATUS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.ProGateOrgType WHERE ");

				query.append("status = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("description ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				list = (List<ProGateOrgType>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateOrgType>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_STATUS,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateOrgType findBystatus_First(boolean status,
		OrderByComparator obc)
		throws NoSuchProGateOrgTypeException, SystemException {
		List<ProGateOrgType> list = findBystatus(status, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateOrgType exists with the key {");

			msg.append("status=" + status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateOrgTypeException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateOrgType findBystatus_Last(boolean status,
		OrderByComparator obc)
		throws NoSuchProGateOrgTypeException, SystemException {
		int count = countBystatus(status);

		List<ProGateOrgType> list = findBystatus(status, count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateOrgType exists with the key {");

			msg.append("status=" + status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateOrgTypeException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateOrgType[] findBystatus_PrevAndNext(Integer orgTypeId,
		boolean status, OrderByComparator obc)
		throws NoSuchProGateOrgTypeException, SystemException {
		ProGateOrgType proGateOrgType = findByPrimaryKey(orgTypeId);

		int count = countBystatus(status);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.ProGateOrgType WHERE ");

			query.append("status = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("description ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(status);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateOrgType);

			ProGateOrgType[] array = new ProGateOrgTypeImpl[3];

			array[0] = (ProGateOrgType)objArray[0];
			array[1] = (ProGateOrgType)objArray[1];
			array[2] = (ProGateOrgType)objArray[2];

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

	public List<ProGateOrgType> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<ProGateOrgType> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<ProGateOrgType> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateOrgType> list = (List<ProGateOrgType>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.ProGateOrgType ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("description ASC");
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<ProGateOrgType>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ProGateOrgType>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateOrgType>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByname(String name) throws SystemException {
		for (ProGateOrgType proGateOrgType : findByname(name)) {
			remove(proGateOrgType);
		}
	}

	public void removeBystatus(boolean status) throws SystemException {
		for (ProGateOrgType proGateOrgType : findBystatus(status)) {
			remove(proGateOrgType);
		}
	}

	public void removeAll() throws SystemException {
		for (ProGateOrgType proGateOrgType : findAll()) {
			remove(proGateOrgType);
		}
	}

	public int countByname(String name) throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_NAME,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append("FROM larion.progate.model.ProGateOrgType WHERE ");

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countBystatus(boolean status) throws SystemException {
		Object[] finderArgs = new Object[] { Boolean.valueOf(status) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_STATUS,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append("FROM larion.progate.model.ProGateOrgType WHERE ");

				query.append("status = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STATUS,
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
						"SELECT COUNT(*) FROM larion.progate.model.ProGateOrgType");

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

	public List<larion.progate.model.Organization> getOrganizations(Integer pk)
		throws SystemException {
		return getOrganizations(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public List<larion.progate.model.Organization> getOrganizations(
		Integer pk, int start, int end) throws SystemException {
		return getOrganizations(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_ORGANIZATIONS = new FinderPath(larion.progate.model.impl.OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.model.impl.OrganizationModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.service.persistence.OrganizationPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getOrganizations",
			new String[] {
				Integer.class.getName(), "java.lang.Integer",
				"java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	public List<larion.progate.model.Organization> getOrganizations(
		Integer pk, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				pk, String.valueOf(start), String.valueOf(end),
				String.valueOf(obc)
			};

		List<larion.progate.model.Organization> list = (List<larion.progate.model.Organization>)FinderCacheUtil.getResult(FINDER_PATH_GET_ORGANIZATIONS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder sb = new StringBuilder();

				sb.append(_SQL_GETORGANIZATIONS);

				if (obc != null) {
					sb.append("ORDER BY ");
					sb.append(obc.getOrderBy());
				}

				else {
					sb.append("ORDER BY ");

					sb.append("organizations.updated_at ASC, ");
					sb.append("organizations.created_at ASC, ");
					sb.append("organizations.name ASC");
				}

				String sql = sb.toString();

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("organizations",
					larion.progate.model.impl.OrganizationImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<larion.progate.model.Organization>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<larion.progate.model.Organization>();
				}

				organizationPersistence.cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_GET_ORGANIZATIONS,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_ORGANIZATIONS_SIZE = new FinderPath(larion.progate.model.impl.OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.model.impl.OrganizationModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.service.persistence.OrganizationPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getOrganizationsSize", new String[] { Integer.class.getName() });

	public int getOrganizationsSize(Integer pk) throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_ORGANIZATIONS_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETORGANIZATIONSSIZE);

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

				FinderCacheUtil.putResult(FINDER_PATH_GET_ORGANIZATIONS_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_ORGANIZATION = new FinderPath(larion.progate.model.impl.OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.model.impl.OrganizationModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.service.persistence.OrganizationPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"containsOrganization",
			new String[] { Integer.class.getName(), Integer.class.getName() });

	public boolean containsOrganization(Integer pk, Integer organizationPK)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk, organizationPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_ORGANIZATION,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsOrganization.contains(pk,
							organizationPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_ORGANIZATION,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	public boolean containsOrganizations(Integer pk) throws SystemException {
		if (getOrganizationsSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.larion.progate.model.ProGateOrgType")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ProGateOrgType>> listenersList = new ArrayList<ModelListener<ProGateOrgType>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ProGateOrgType>)Class.forName(
							listenerClassName).newInstance());
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		containsOrganization = new ContainsOrganization(this);
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
	protected ContainsOrganization containsOrganization;

	protected class ContainsOrganization {
		protected ContainsOrganization(
			ProGateOrgTypePersistenceImpl persistenceImpl) {
			super();

			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSORGANIZATION,
					new int[] { Types.INTEGER, Types.INTEGER }, RowMapper.COUNT);
		}

		protected boolean contains(Integer orgTypeId, Integer orgId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						orgTypeId, orgId
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

	private static final String _SQL_GETORGANIZATIONS = "SELECT {organizations.*} FROM organizations INNER JOIN progate_orgtypes ON (progate_orgtypes.orgTypeId = organizations.orgTypeId) WHERE (progate_orgtypes.orgTypeId = ?)";
	private static final String _SQL_GETORGANIZATIONSSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM organizations WHERE orgTypeId = ?";
	private static final String _SQL_CONTAINSORGANIZATION = "SELECT COUNT(*) AS COUNT_VALUE FROM organizations WHERE orgTypeId = ? AND orgId = ?";
	private static Log _log = LogFactoryUtil.getLog(ProGateOrgTypePersistenceImpl.class);
}