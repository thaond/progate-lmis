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

import larion.progate.NoSuchOrgObjectApprovalException;

import larion.progate.model.OrgObjectApproval;
import larion.progate.model.impl.OrgObjectApprovalImpl;
import larion.progate.model.impl.OrgObjectApprovalModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="OrgObjectApprovalPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class OrgObjectApprovalPersistenceImpl extends BasePersistenceImpl
	implements OrgObjectApprovalPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = OrgObjectApprovalImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_ORGOBJAPPROVALUSERID = new FinderPath(OrgObjectApprovalModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectApprovalModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOrgObjApprovalUserId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ORGOBJAPPROVALUSERID = new FinderPath(OrgObjectApprovalModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectApprovalModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOrgObjApprovalUserId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGOBJAPPROVALUSERID = new FinderPath(OrgObjectApprovalModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectApprovalModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByOrgObjApprovalUserId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ORGOBJAPPROVALSTATUS = new FinderPath(OrgObjectApprovalModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectApprovalModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOrgObjApprovalStatus",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ORGOBJAPPROVALSTATUS = new FinderPath(OrgObjectApprovalModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectApprovalModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOrgObjApprovalStatus",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGOBJAPPROVALSTATUS = new FinderPath(OrgObjectApprovalModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectApprovalModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByOrgObjApprovalStatus",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(OrgObjectApprovalModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectApprovalModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OrgObjectApprovalModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectApprovalModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(OrgObjectApproval orgObjectApproval) {
		EntityCacheUtil.putResult(OrgObjectApprovalModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectApprovalImpl.class, orgObjectApproval.getPrimaryKey(),
			orgObjectApproval);
	}

	public void cacheResult(List<OrgObjectApproval> orgObjectApprovals) {
		for (OrgObjectApproval orgObjectApproval : orgObjectApprovals) {
			if (EntityCacheUtil.getResult(
						OrgObjectApprovalModelImpl.ENTITY_CACHE_ENABLED,
						OrgObjectApprovalImpl.class,
						orgObjectApproval.getPrimaryKey(), this) == null) {
				cacheResult(orgObjectApproval);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(OrgObjectApprovalImpl.class.getName());
		EntityCacheUtil.clearCache(OrgObjectApprovalImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public OrgObjectApproval create(Integer orgObjectApprovalId) {
		OrgObjectApproval orgObjectApproval = new OrgObjectApprovalImpl();

		orgObjectApproval.setNew(true);
		orgObjectApproval.setPrimaryKey(orgObjectApprovalId);

		return orgObjectApproval;
	}

	public OrgObjectApproval remove(Integer orgObjectApprovalId)
		throws NoSuchOrgObjectApprovalException, SystemException {
		Session session = null;

		try {
			session = openSession();

			OrgObjectApproval orgObjectApproval = (OrgObjectApproval)session.get(OrgObjectApprovalImpl.class,
					orgObjectApprovalId);

			if (orgObjectApproval == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No OrgObjectApproval exists with the primary key " +
						orgObjectApprovalId);
				}

				throw new NoSuchOrgObjectApprovalException(
					"No OrgObjectApproval exists with the primary key " +
					orgObjectApprovalId);
			}

			return remove(orgObjectApproval);
		}
		catch (NoSuchOrgObjectApprovalException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public OrgObjectApproval remove(OrgObjectApproval orgObjectApproval)
		throws SystemException {
		for (ModelListener<OrgObjectApproval> listener : listeners) {
			listener.onBeforeRemove(orgObjectApproval);
		}

		orgObjectApproval = removeImpl(orgObjectApproval);

		for (ModelListener<OrgObjectApproval> listener : listeners) {
			listener.onAfterRemove(orgObjectApproval);
		}

		return orgObjectApproval;
	}

	protected OrgObjectApproval removeImpl(OrgObjectApproval orgObjectApproval)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (orgObjectApproval.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(OrgObjectApprovalImpl.class,
						orgObjectApproval.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(orgObjectApproval);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(OrgObjectApprovalModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectApprovalImpl.class, orgObjectApproval.getPrimaryKey());

		return orgObjectApproval;
	}

	public OrgObjectApproval update(OrgObjectApproval orgObjectApproval)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(OrgObjectApproval orgObjectApproval) method. Use update(OrgObjectApproval orgObjectApproval, boolean merge) instead.");
		}

		return update(orgObjectApproval, false);
	}

	public OrgObjectApproval update(OrgObjectApproval orgObjectApproval,
		boolean merge) throws SystemException {
		boolean isNew = orgObjectApproval.isNew();

		for (ModelListener<OrgObjectApproval> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(orgObjectApproval);
			}
			else {
				listener.onBeforeUpdate(orgObjectApproval);
			}
		}

		orgObjectApproval = updateImpl(orgObjectApproval, merge);

		for (ModelListener<OrgObjectApproval> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(orgObjectApproval);
			}
			else {
				listener.onAfterUpdate(orgObjectApproval);
			}
		}

		return orgObjectApproval;
	}

	public OrgObjectApproval updateImpl(
		larion.progate.model.OrgObjectApproval orgObjectApproval, boolean merge)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, orgObjectApproval, merge);

			orgObjectApproval.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(OrgObjectApprovalModelImpl.ENTITY_CACHE_ENABLED,
			OrgObjectApprovalImpl.class, orgObjectApproval.getPrimaryKey(),
			orgObjectApproval);

		return orgObjectApproval;
	}

	public OrgObjectApproval findByPrimaryKey(Integer orgObjectApprovalId)
		throws NoSuchOrgObjectApprovalException, SystemException {
		OrgObjectApproval orgObjectApproval = fetchByPrimaryKey(orgObjectApprovalId);

		if (orgObjectApproval == null) {
			if (_log.isWarnEnabled()) {
				_log.warn("No OrgObjectApproval exists with the primary key " +
					orgObjectApprovalId);
			}

			throw new NoSuchOrgObjectApprovalException(
				"No OrgObjectApproval exists with the primary key " +
				orgObjectApprovalId);
		}

		return orgObjectApproval;
	}

	public OrgObjectApproval fetchByPrimaryKey(Integer orgObjectApprovalId)
		throws SystemException {
		OrgObjectApproval orgObjectApproval = (OrgObjectApproval)EntityCacheUtil.getResult(OrgObjectApprovalModelImpl.ENTITY_CACHE_ENABLED,
				OrgObjectApprovalImpl.class, orgObjectApprovalId, this);

		if (orgObjectApproval == null) {
			Session session = null;

			try {
				session = openSession();

				orgObjectApproval = (OrgObjectApproval)session.get(OrgObjectApprovalImpl.class,
						orgObjectApprovalId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (orgObjectApproval != null) {
					cacheResult(orgObjectApproval);
				}

				closeSession(session);
			}
		}

		return orgObjectApproval;
	}

	public List<OrgObjectApproval> findByOrgObjApprovalUserId(int approved_by)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(approved_by) };

		List<OrgObjectApproval> list = (List<OrgObjectApproval>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ORGOBJAPPROVALUSERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.OrgObjectApproval WHERE ");

				query.append("approved_by = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(approved_by);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<OrgObjectApproval>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ORGOBJAPPROVALUSERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<OrgObjectApproval> findByOrgObjApprovalUserId(int approved_by,
		int start, int end) throws SystemException {
		return findByOrgObjApprovalUserId(approved_by, start, end, null);
	}

	public List<OrgObjectApproval> findByOrgObjApprovalUserId(int approved_by,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(approved_by),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<OrgObjectApproval> list = (List<OrgObjectApproval>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ORGOBJAPPROVALUSERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.OrgObjectApproval WHERE ");

				query.append("approved_by = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(approved_by);

				list = (List<OrgObjectApproval>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<OrgObjectApproval>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ORGOBJAPPROVALUSERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public OrgObjectApproval findByOrgObjApprovalUserId_First(int approved_by,
		OrderByComparator obc)
		throws NoSuchOrgObjectApprovalException, SystemException {
		List<OrgObjectApproval> list = findByOrgObjApprovalUserId(approved_by,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No OrgObjectApproval exists with the key {");

			msg.append("approved_by=" + approved_by);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrgObjectApprovalException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public OrgObjectApproval findByOrgObjApprovalUserId_Last(int approved_by,
		OrderByComparator obc)
		throws NoSuchOrgObjectApprovalException, SystemException {
		int count = countByOrgObjApprovalUserId(approved_by);

		List<OrgObjectApproval> list = findByOrgObjApprovalUserId(approved_by,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No OrgObjectApproval exists with the key {");

			msg.append("approved_by=" + approved_by);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrgObjectApprovalException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public OrgObjectApproval[] findByOrgObjApprovalUserId_PrevAndNext(
		Integer orgObjectApprovalId, int approved_by, OrderByComparator obc)
		throws NoSuchOrgObjectApprovalException, SystemException {
		OrgObjectApproval orgObjectApproval = findByPrimaryKey(orgObjectApprovalId);

		int count = countByOrgObjApprovalUserId(approved_by);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.OrgObjectApproval WHERE ");

			query.append("approved_by = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(approved_by);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					orgObjectApproval);

			OrgObjectApproval[] array = new OrgObjectApprovalImpl[3];

			array[0] = (OrgObjectApproval)objArray[0];
			array[1] = (OrgObjectApproval)objArray[1];
			array[2] = (OrgObjectApproval)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<OrgObjectApproval> findByOrgObjApprovalStatus(int status)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(status) };

		List<OrgObjectApproval> list = (List<OrgObjectApproval>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ORGOBJAPPROVALSTATUS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.OrgObjectApproval WHERE ");

				query.append("status = ?");

				query.append(" ");

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
					list = new ArrayList<OrgObjectApproval>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ORGOBJAPPROVALSTATUS,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<OrgObjectApproval> findByOrgObjApprovalStatus(int status,
		int start, int end) throws SystemException {
		return findByOrgObjApprovalStatus(status, start, end, null);
	}

	public List<OrgObjectApproval> findByOrgObjApprovalStatus(int status,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(status),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<OrgObjectApproval> list = (List<OrgObjectApproval>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ORGOBJAPPROVALSTATUS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.OrgObjectApproval WHERE ");

				query.append("status = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				list = (List<OrgObjectApproval>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<OrgObjectApproval>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ORGOBJAPPROVALSTATUS,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public OrgObjectApproval findByOrgObjApprovalStatus_First(int status,
		OrderByComparator obc)
		throws NoSuchOrgObjectApprovalException, SystemException {
		List<OrgObjectApproval> list = findByOrgObjApprovalStatus(status, 0, 1,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No OrgObjectApproval exists with the key {");

			msg.append("status=" + status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrgObjectApprovalException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public OrgObjectApproval findByOrgObjApprovalStatus_Last(int status,
		OrderByComparator obc)
		throws NoSuchOrgObjectApprovalException, SystemException {
		int count = countByOrgObjApprovalStatus(status);

		List<OrgObjectApproval> list = findByOrgObjApprovalStatus(status,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No OrgObjectApproval exists with the key {");

			msg.append("status=" + status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrgObjectApprovalException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public OrgObjectApproval[] findByOrgObjApprovalStatus_PrevAndNext(
		Integer orgObjectApprovalId, int status, OrderByComparator obc)
		throws NoSuchOrgObjectApprovalException, SystemException {
		OrgObjectApproval orgObjectApproval = findByPrimaryKey(orgObjectApprovalId);

		int count = countByOrgObjApprovalStatus(status);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.OrgObjectApproval WHERE ");

			query.append("status = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(status);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					orgObjectApproval);

			OrgObjectApproval[] array = new OrgObjectApprovalImpl[3];

			array[0] = (OrgObjectApproval)objArray[0];
			array[1] = (OrgObjectApproval)objArray[1];
			array[2] = (OrgObjectApproval)objArray[2];

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

	public List<OrgObjectApproval> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<OrgObjectApproval> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<OrgObjectApproval> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<OrgObjectApproval> list = (List<OrgObjectApproval>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.OrgObjectApproval ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<OrgObjectApproval>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<OrgObjectApproval>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<OrgObjectApproval>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByOrgObjApprovalUserId(int approved_by)
		throws SystemException {
		for (OrgObjectApproval orgObjectApproval : findByOrgObjApprovalUserId(
				approved_by)) {
			remove(orgObjectApproval);
		}
	}

	public void removeByOrgObjApprovalStatus(int status)
		throws SystemException {
		for (OrgObjectApproval orgObjectApproval : findByOrgObjApprovalStatus(
				status)) {
			remove(orgObjectApproval);
		}
	}

	public void removeAll() throws SystemException {
		for (OrgObjectApproval orgObjectApproval : findAll()) {
			remove(orgObjectApproval);
		}
	}

	public int countByOrgObjApprovalUserId(int approved_by)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(approved_by) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ORGOBJAPPROVALUSERID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.OrgObjectApproval WHERE ");

				query.append("approved_by = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(approved_by);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ORGOBJAPPROVALUSERID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByOrgObjApprovalStatus(int status)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(status) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ORGOBJAPPROVALSTATUS,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.OrgObjectApproval WHERE ");

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ORGOBJAPPROVALSTATUS,
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
						"SELECT COUNT(*) FROM larion.progate.model.OrgObjectApproval");

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
						"value.object.listener.larion.progate.model.OrgObjectApproval")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<OrgObjectApproval>> listenersList = new ArrayList<ModelListener<OrgObjectApproval>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<OrgObjectApproval>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(OrgObjectApprovalPersistenceImpl.class);
}