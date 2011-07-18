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

package larion.progate.lmis.service.persistence;

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

import larion.progate.lmis.NoSuchLmisOvertimeRequestsException;
import larion.progate.lmis.model.LmisOvertimeRequests;
import larion.progate.lmis.model.impl.LmisOvertimeRequestsImpl;
import larion.progate.lmis.model.impl.LmisOvertimeRequestsModelImpl;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="LmisOvertimeRequestsPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisOvertimeRequestsPersistenceImpl extends BasePersistenceImpl
	implements LmisOvertimeRequestsPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = LmisOvertimeRequestsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_REQUESTEDBY = new FinderPath(LmisOvertimeRequestsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeRequestsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRequestedBy",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_REQUESTEDBY = new FinderPath(LmisOvertimeRequestsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeRequestsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRequestedBy",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_REQUESTEDBY = new FinderPath(LmisOvertimeRequestsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeRequestsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByRequestedBy",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ORGID = new FinderPath(LmisOvertimeRequestsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeRequestsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOrgID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ORGID = new FinderPath(LmisOvertimeRequestsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeRequestsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOrgID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGID = new FinderPath(LmisOvertimeRequestsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeRequestsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByOrgID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OVERTIMEREQUETOF = new FinderPath(LmisOvertimeRequestsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeRequestsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOverTimeRequetOf",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_OVERTIMEREQUETOF = new FinderPath(LmisOvertimeRequestsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeRequestsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOverTimeRequetOf",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_OVERTIMEREQUETOF = new FinderPath(LmisOvertimeRequestsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeRequestsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByOverTimeRequetOf",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(LmisOvertimeRequestsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeRequestsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LmisOvertimeRequestsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeRequestsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(LmisOvertimeRequests lmisOvertimeRequests) {
		EntityCacheUtil.putResult(LmisOvertimeRequestsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeRequestsImpl.class,
			lmisOvertimeRequests.getPrimaryKey(), lmisOvertimeRequests);
	}

	public void cacheResult(List<LmisOvertimeRequests> lmisOvertimeRequestses) {
		for (LmisOvertimeRequests lmisOvertimeRequests : lmisOvertimeRequestses) {
			if (EntityCacheUtil.getResult(
						LmisOvertimeRequestsModelImpl.ENTITY_CACHE_ENABLED,
						LmisOvertimeRequestsImpl.class,
						lmisOvertimeRequests.getPrimaryKey(), this) == null) {
				cacheResult(lmisOvertimeRequests);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(LmisOvertimeRequestsImpl.class.getName());
		EntityCacheUtil.clearCache(LmisOvertimeRequestsImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public LmisOvertimeRequests create(Integer lmisOvertimeRequestsId) {
		LmisOvertimeRequests lmisOvertimeRequests = new LmisOvertimeRequestsImpl();

		lmisOvertimeRequests.setNew(true);
		lmisOvertimeRequests.setPrimaryKey(lmisOvertimeRequestsId);

		return lmisOvertimeRequests;
	}

	public LmisOvertimeRequests remove(Integer lmisOvertimeRequestsId)
		throws NoSuchLmisOvertimeRequestsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LmisOvertimeRequests lmisOvertimeRequests = (LmisOvertimeRequests)session.get(LmisOvertimeRequestsImpl.class,
					lmisOvertimeRequestsId);

			if (lmisOvertimeRequests == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No LmisOvertimeRequests exists with the primary key " +
						lmisOvertimeRequestsId);
				}

				throw new NoSuchLmisOvertimeRequestsException(
					"No LmisOvertimeRequests exists with the primary key " +
					lmisOvertimeRequestsId);
			}

			return remove(lmisOvertimeRequests);
		}
		catch (NoSuchLmisOvertimeRequestsException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public LmisOvertimeRequests remove(
		LmisOvertimeRequests lmisOvertimeRequests) throws SystemException {
		for (ModelListener<LmisOvertimeRequests> listener : listeners) {
			listener.onBeforeRemove(lmisOvertimeRequests);
		}

		lmisOvertimeRequests = removeImpl(lmisOvertimeRequests);

		for (ModelListener<LmisOvertimeRequests> listener : listeners) {
			listener.onAfterRemove(lmisOvertimeRequests);
		}

		return lmisOvertimeRequests;
	}

	protected LmisOvertimeRequests removeImpl(
		LmisOvertimeRequests lmisOvertimeRequests) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (lmisOvertimeRequests.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(LmisOvertimeRequestsImpl.class,
						lmisOvertimeRequests.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(lmisOvertimeRequests);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(LmisOvertimeRequestsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeRequestsImpl.class, lmisOvertimeRequests.getPrimaryKey());

		return lmisOvertimeRequests;
	}

	public LmisOvertimeRequests update(
		LmisOvertimeRequests lmisOvertimeRequests) throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(LmisOvertimeRequests lmisOvertimeRequests) method. Use update(LmisOvertimeRequests lmisOvertimeRequests, boolean merge) instead.");
		}

		return update(lmisOvertimeRequests, false);
	}

	public LmisOvertimeRequests update(
		LmisOvertimeRequests lmisOvertimeRequests, boolean merge)
		throws SystemException {
		boolean isNew = lmisOvertimeRequests.isNew();

		for (ModelListener<LmisOvertimeRequests> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(lmisOvertimeRequests);
			}
			else {
				listener.onBeforeUpdate(lmisOvertimeRequests);
			}
		}

		lmisOvertimeRequests = updateImpl(lmisOvertimeRequests, merge);

		for (ModelListener<LmisOvertimeRequests> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(lmisOvertimeRequests);
			}
			else {
				listener.onAfterUpdate(lmisOvertimeRequests);
			}
		}

		return lmisOvertimeRequests;
	}

	public LmisOvertimeRequests updateImpl(
		larion.progate.lmis.model.LmisOvertimeRequests lmisOvertimeRequests,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, lmisOvertimeRequests, merge);

			lmisOvertimeRequests.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(LmisOvertimeRequestsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeRequestsImpl.class,
			lmisOvertimeRequests.getPrimaryKey(), lmisOvertimeRequests);

		return lmisOvertimeRequests;
	}

	public LmisOvertimeRequests findByPrimaryKey(Integer lmisOvertimeRequestsId)
		throws NoSuchLmisOvertimeRequestsException, SystemException {
		LmisOvertimeRequests lmisOvertimeRequests = fetchByPrimaryKey(lmisOvertimeRequestsId);

		if (lmisOvertimeRequests == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"No LmisOvertimeRequests exists with the primary key " +
					lmisOvertimeRequestsId);
			}

			throw new NoSuchLmisOvertimeRequestsException(
				"No LmisOvertimeRequests exists with the primary key " +
				lmisOvertimeRequestsId);
		}

		return lmisOvertimeRequests;
	}

	public LmisOvertimeRequests fetchByPrimaryKey(
		Integer lmisOvertimeRequestsId) throws SystemException {
		LmisOvertimeRequests lmisOvertimeRequests = (LmisOvertimeRequests)EntityCacheUtil.getResult(LmisOvertimeRequestsModelImpl.ENTITY_CACHE_ENABLED,
				LmisOvertimeRequestsImpl.class, lmisOvertimeRequestsId, this);

		if (lmisOvertimeRequests == null) {
			Session session = null;

			try {
				session = openSession();

				lmisOvertimeRequests = (LmisOvertimeRequests)session.get(LmisOvertimeRequestsImpl.class,
						lmisOvertimeRequestsId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (lmisOvertimeRequests != null) {
					cacheResult(lmisOvertimeRequests);
				}

				closeSession(session);
			}
		}

		return lmisOvertimeRequests;
	}

	public List<LmisOvertimeRequests> findByRequestedBy(int requestedBy)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(requestedBy) };

		List<LmisOvertimeRequests> list = (List<LmisOvertimeRequests>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_REQUESTEDBY,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOvertimeRequests WHERE ");

				query.append("requested_by = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(requestedBy);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisOvertimeRequests>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_REQUESTEDBY,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisOvertimeRequests> findByRequestedBy(int requestedBy,
		int start, int end) throws SystemException {
		return findByRequestedBy(requestedBy, start, end, null);
	}

	public List<LmisOvertimeRequests> findByRequestedBy(int requestedBy,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(requestedBy),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisOvertimeRequests> list = (List<LmisOvertimeRequests>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_REQUESTEDBY,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOvertimeRequests WHERE ");

				query.append("requested_by = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(requestedBy);

				list = (List<LmisOvertimeRequests>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisOvertimeRequests>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_REQUESTEDBY,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisOvertimeRequests findByRequestedBy_First(int requestedBy,
		OrderByComparator obc)
		throws NoSuchLmisOvertimeRequestsException, SystemException {
		List<LmisOvertimeRequests> list = findByRequestedBy(requestedBy, 0, 1,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOvertimeRequests exists with the key {");

			msg.append("requestedBy=" + requestedBy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOvertimeRequestsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOvertimeRequests findByRequestedBy_Last(int requestedBy,
		OrderByComparator obc)
		throws NoSuchLmisOvertimeRequestsException, SystemException {
		int count = countByRequestedBy(requestedBy);

		List<LmisOvertimeRequests> list = findByRequestedBy(requestedBy,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOvertimeRequests exists with the key {");

			msg.append("requestedBy=" + requestedBy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOvertimeRequestsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOvertimeRequests[] findByRequestedBy_PrevAndNext(
		Integer lmisOvertimeRequestsId, int requestedBy, OrderByComparator obc)
		throws NoSuchLmisOvertimeRequestsException, SystemException {
		LmisOvertimeRequests lmisOvertimeRequests = findByPrimaryKey(lmisOvertimeRequestsId);

		int count = countByRequestedBy(requestedBy);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisOvertimeRequests WHERE ");

			query.append("requested_by = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(requestedBy);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisOvertimeRequests);

			LmisOvertimeRequests[] array = new LmisOvertimeRequestsImpl[3];

			array[0] = (LmisOvertimeRequests)objArray[0];
			array[1] = (LmisOvertimeRequests)objArray[1];
			array[2] = (LmisOvertimeRequests)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisOvertimeRequests> findByOrgID(int orgId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(orgId) };

		List<LmisOvertimeRequests> list = (List<LmisOvertimeRequests>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ORGID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOvertimeRequests WHERE ");

				query.append("org_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orgId);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisOvertimeRequests>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ORGID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisOvertimeRequests> findByOrgID(int orgId, int start, int end)
		throws SystemException {
		return findByOrgID(orgId, start, end, null);
	}

	public List<LmisOvertimeRequests> findByOrgID(int orgId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(orgId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisOvertimeRequests> list = (List<LmisOvertimeRequests>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ORGID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOvertimeRequests WHERE ");

				query.append("org_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orgId);

				list = (List<LmisOvertimeRequests>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisOvertimeRequests>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ORGID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisOvertimeRequests findByOrgID_First(int orgId,
		OrderByComparator obc)
		throws NoSuchLmisOvertimeRequestsException, SystemException {
		List<LmisOvertimeRequests> list = findByOrgID(orgId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOvertimeRequests exists with the key {");

			msg.append("orgId=" + orgId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOvertimeRequestsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOvertimeRequests findByOrgID_Last(int orgId,
		OrderByComparator obc)
		throws NoSuchLmisOvertimeRequestsException, SystemException {
		int count = countByOrgID(orgId);

		List<LmisOvertimeRequests> list = findByOrgID(orgId, count - 1, count,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOvertimeRequests exists with the key {");

			msg.append("orgId=" + orgId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOvertimeRequestsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOvertimeRequests[] findByOrgID_PrevAndNext(
		Integer lmisOvertimeRequestsId, int orgId, OrderByComparator obc)
		throws NoSuchLmisOvertimeRequestsException, SystemException {
		LmisOvertimeRequests lmisOvertimeRequests = findByPrimaryKey(lmisOvertimeRequestsId);

		int count = countByOrgID(orgId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisOvertimeRequests WHERE ");

			query.append("org_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(orgId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisOvertimeRequests);

			LmisOvertimeRequests[] array = new LmisOvertimeRequestsImpl[3];

			array[0] = (LmisOvertimeRequests)objArray[0];
			array[1] = (LmisOvertimeRequests)objArray[1];
			array[2] = (LmisOvertimeRequests)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisOvertimeRequests> findByOverTimeRequetOf(int rootId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		List<LmisOvertimeRequests> list = (List<LmisOvertimeRequests>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OVERTIMEREQUETOF,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOvertimeRequests WHERE ");

				query.append("root_id = ?");

				query.append(" ");

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
					list = new ArrayList<LmisOvertimeRequests>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OVERTIMEREQUETOF,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisOvertimeRequests> findByOverTimeRequetOf(int rootId,
		int start, int end) throws SystemException {
		return findByOverTimeRequetOf(rootId, start, end, null);
	}

	public List<LmisOvertimeRequests> findByOverTimeRequetOf(int rootId,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(rootId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisOvertimeRequests> list = (List<LmisOvertimeRequests>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_OVERTIMEREQUETOF,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOvertimeRequests WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rootId);

				list = (List<LmisOvertimeRequests>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisOvertimeRequests>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_OVERTIMEREQUETOF,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisOvertimeRequests findByOverTimeRequetOf_First(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisOvertimeRequestsException, SystemException {
		List<LmisOvertimeRequests> list = findByOverTimeRequetOf(rootId, 0, 1,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOvertimeRequests exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOvertimeRequestsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOvertimeRequests findByOverTimeRequetOf_Last(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisOvertimeRequestsException, SystemException {
		int count = countByOverTimeRequetOf(rootId);

		List<LmisOvertimeRequests> list = findByOverTimeRequetOf(rootId,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOvertimeRequests exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOvertimeRequestsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOvertimeRequests[] findByOverTimeRequetOf_PrevAndNext(
		Integer lmisOvertimeRequestsId, int rootId, OrderByComparator obc)
		throws NoSuchLmisOvertimeRequestsException, SystemException {
		LmisOvertimeRequests lmisOvertimeRequests = findByPrimaryKey(lmisOvertimeRequestsId);

		int count = countByOverTimeRequetOf(rootId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisOvertimeRequests WHERE ");

			query.append("root_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(rootId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisOvertimeRequests);

			LmisOvertimeRequests[] array = new LmisOvertimeRequestsImpl[3];

			array[0] = (LmisOvertimeRequests)objArray[0];
			array[1] = (LmisOvertimeRequests)objArray[1];
			array[2] = (LmisOvertimeRequests)objArray[2];

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

	public List<LmisOvertimeRequests> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<LmisOvertimeRequests> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<LmisOvertimeRequests> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisOvertimeRequests> list = (List<LmisOvertimeRequests>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOvertimeRequests ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<LmisOvertimeRequests>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LmisOvertimeRequests>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisOvertimeRequests>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByRequestedBy(int requestedBy) throws SystemException {
		for (LmisOvertimeRequests lmisOvertimeRequests : findByRequestedBy(
				requestedBy)) {
			remove(lmisOvertimeRequests);
		}
	}

	public void removeByOrgID(int orgId) throws SystemException {
		for (LmisOvertimeRequests lmisOvertimeRequests : findByOrgID(orgId)) {
			remove(lmisOvertimeRequests);
		}
	}

	public void removeByOverTimeRequetOf(int rootId) throws SystemException {
		for (LmisOvertimeRequests lmisOvertimeRequests : findByOverTimeRequetOf(
				rootId)) {
			remove(lmisOvertimeRequests);
		}
	}

	public void removeAll() throws SystemException {
		for (LmisOvertimeRequests lmisOvertimeRequests : findAll()) {
			remove(lmisOvertimeRequests);
		}
	}

	public int countByRequestedBy(int requestedBy) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(requestedBy) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_REQUESTEDBY,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisOvertimeRequests WHERE ");

				query.append("requested_by = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(requestedBy);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_REQUESTEDBY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByOrgID(int orgId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(orgId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ORGID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisOvertimeRequests WHERE ");

				query.append("org_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orgId);

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

	public int countByOverTimeRequetOf(int rootId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_OVERTIMEREQUETOF,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisOvertimeRequests WHERE ");

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_OVERTIMEREQUETOF,
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
						"SELECT COUNT(*) FROM larion.progate.lmis.model.LmisOvertimeRequests");

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

	public List<larion.progate.lmis.model.LmisOvertimeRequestDetails> getLmisOvertimeRequestDetailses(
		Integer pk) throws SystemException {
		return getLmisOvertimeRequestDetailses(pk, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS);
	}

	public List<larion.progate.lmis.model.LmisOvertimeRequestDetails> getLmisOvertimeRequestDetailses(
		Integer pk, int start, int end) throws SystemException {
		return getLmisOvertimeRequestDetailses(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_LMISOVERTIMEREQUESTDETAILSES = new FinderPath(larion.progate.lmis.model.impl.LmisOvertimeRequestDetailsModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.lmis.model.impl.LmisOvertimeRequestDetailsModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.lmis.service.persistence.LmisOvertimeRequestDetailsPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getLmisOvertimeRequestDetailses",
			new String[] {
				Integer.class.getName(), "java.lang.Integer",
				"java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	public List<larion.progate.lmis.model.LmisOvertimeRequestDetails> getLmisOvertimeRequestDetailses(
		Integer pk, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				pk, String.valueOf(start), String.valueOf(end),
				String.valueOf(obc)
			};

		List<larion.progate.lmis.model.LmisOvertimeRequestDetails> list = (List<larion.progate.lmis.model.LmisOvertimeRequestDetails>)FinderCacheUtil.getResult(FINDER_PATH_GET_LMISOVERTIMEREQUESTDETAILSES,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder sb = new StringBuilder();

				sb.append(_SQL_GETLMISOVERTIMEREQUESTDETAILSES);

				if (obc != null) {
					sb.append("ORDER BY ");
					sb.append(obc.getOrderBy());
				}

				String sql = sb.toString();

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("lmis_overtime_request_details",
					larion.progate.lmis.model.impl.LmisOvertimeRequestDetailsImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<larion.progate.lmis.model.LmisOvertimeRequestDetails>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<larion.progate.lmis.model.LmisOvertimeRequestDetails>();
				}

				lmisOvertimeRequestDetailsPersistence.cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_GET_LMISOVERTIMEREQUESTDETAILSES,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_LMISOVERTIMEREQUESTDETAILSES_SIZE =
		new FinderPath(larion.progate.lmis.model.impl.LmisOvertimeRequestDetailsModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.lmis.model.impl.LmisOvertimeRequestDetailsModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.lmis.service.persistence.LmisOvertimeRequestDetailsPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getLmisOvertimeRequestDetailsesSize",
			new String[] { Integer.class.getName() });

	public int getLmisOvertimeRequestDetailsesSize(Integer pk)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_LMISOVERTIMEREQUESTDETAILSES_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETLMISOVERTIMEREQUESTDETAILSESSIZE);

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

				FinderCacheUtil.putResult(FINDER_PATH_GET_LMISOVERTIMEREQUESTDETAILSES_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_LMISOVERTIMEREQUESTDETAILS =
		new FinderPath(larion.progate.lmis.model.impl.LmisOvertimeRequestDetailsModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.lmis.model.impl.LmisOvertimeRequestDetailsModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.lmis.service.persistence.LmisOvertimeRequestDetailsPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"containsLmisOvertimeRequestDetails",
			new String[] { Integer.class.getName(), Integer.class.getName() });

	public boolean containsLmisOvertimeRequestDetails(Integer pk,
		Integer lmisOvertimeRequestDetailsPK) throws SystemException {
		Object[] finderArgs = new Object[] { pk, lmisOvertimeRequestDetailsPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_LMISOVERTIMEREQUESTDETAILS,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsLmisOvertimeRequestDetails.contains(
							pk, lmisOvertimeRequestDetailsPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_LMISOVERTIMEREQUESTDETAILS,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	public boolean containsLmisOvertimeRequestDetailses(Integer pk)
		throws SystemException {
		if (getLmisOvertimeRequestDetailsesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public List<larion.progate.lmis.model.LmisOvertimeApprovals> getLmisOvertimeApprovalses(
		Integer pk) throws SystemException {
		return getLmisOvertimeApprovalses(pk, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS);
	}

	public List<larion.progate.lmis.model.LmisOvertimeApprovals> getLmisOvertimeApprovalses(
		Integer pk, int start, int end) throws SystemException {
		return getLmisOvertimeApprovalses(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_LMISOVERTIMEAPPROVALSES = new FinderPath(larion.progate.lmis.model.impl.LmisOvertimeApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.lmis.model.impl.LmisOvertimeApprovalsModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.lmis.service.persistence.LmisOvertimeApprovalsPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getLmisOvertimeApprovalses",
			new String[] {
				Integer.class.getName(), "java.lang.Integer",
				"java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	public List<larion.progate.lmis.model.LmisOvertimeApprovals> getLmisOvertimeApprovalses(
		Integer pk, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				pk, String.valueOf(start), String.valueOf(end),
				String.valueOf(obc)
			};

		List<larion.progate.lmis.model.LmisOvertimeApprovals> list = (List<larion.progate.lmis.model.LmisOvertimeApprovals>)FinderCacheUtil.getResult(FINDER_PATH_GET_LMISOVERTIMEAPPROVALSES,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder sb = new StringBuilder();

				sb.append(_SQL_GETLMISOVERTIMEAPPROVALSES);

				if (obc != null) {
					sb.append("ORDER BY ");
					sb.append(obc.getOrderBy());
				}

				else {
					sb.append("ORDER BY ");

					sb.append("lmis_overtime_approvals.approved_status ASC");
				}

				String sql = sb.toString();

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("lmis_overtime_approvals",
					larion.progate.lmis.model.impl.LmisOvertimeApprovalsImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<larion.progate.lmis.model.LmisOvertimeApprovals>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<larion.progate.lmis.model.LmisOvertimeApprovals>();
				}

				lmisOvertimeApprovalsPersistence.cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_GET_LMISOVERTIMEAPPROVALSES,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_LMISOVERTIMEAPPROVALSES_SIZE = new FinderPath(larion.progate.lmis.model.impl.LmisOvertimeApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.lmis.model.impl.LmisOvertimeApprovalsModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.lmis.service.persistence.LmisOvertimeApprovalsPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getLmisOvertimeApprovalsesSize",
			new String[] { Integer.class.getName() });

	public int getLmisOvertimeApprovalsesSize(Integer pk)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_LMISOVERTIMEAPPROVALSES_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETLMISOVERTIMEAPPROVALSESSIZE);

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

				FinderCacheUtil.putResult(FINDER_PATH_GET_LMISOVERTIMEAPPROVALSES_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_LMISOVERTIMEAPPROVALS = new FinderPath(larion.progate.lmis.model.impl.LmisOvertimeApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.lmis.model.impl.LmisOvertimeApprovalsModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.lmis.service.persistence.LmisOvertimeApprovalsPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"containsLmisOvertimeApprovals",
			new String[] { Integer.class.getName(), Integer.class.getName() });

	public boolean containsLmisOvertimeApprovals(Integer pk,
		Integer lmisOvertimeApprovalsPK) throws SystemException {
		Object[] finderArgs = new Object[] { pk, lmisOvertimeApprovalsPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_LMISOVERTIMEAPPROVALS,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsLmisOvertimeApprovals.contains(
							pk, lmisOvertimeApprovalsPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_LMISOVERTIMEAPPROVALS,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	public boolean containsLmisOvertimeApprovalses(Integer pk)
		throws SystemException {
		if (getLmisOvertimeApprovalsesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public List<larion.progate.lmis.model.LmisOverTimeReports> getLmisOverTimeReportses(
		Integer pk) throws SystemException {
		return getLmisOverTimeReportses(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public List<larion.progate.lmis.model.LmisOverTimeReports> getLmisOverTimeReportses(
		Integer pk, int start, int end) throws SystemException {
		return getLmisOverTimeReportses(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_LMISOVERTIMEREPORTSES = new FinderPath(larion.progate.lmis.model.impl.LmisOverTimeReportsModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.lmis.model.impl.LmisOverTimeReportsModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.lmis.service.persistence.LmisOverTimeReportsPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getLmisOverTimeReportses",
			new String[] {
				Integer.class.getName(), "java.lang.Integer",
				"java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	public List<larion.progate.lmis.model.LmisOverTimeReports> getLmisOverTimeReportses(
		Integer pk, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				pk, String.valueOf(start), String.valueOf(end),
				String.valueOf(obc)
			};

		List<larion.progate.lmis.model.LmisOverTimeReports> list = (List<larion.progate.lmis.model.LmisOverTimeReports>)FinderCacheUtil.getResult(FINDER_PATH_GET_LMISOVERTIMEREPORTSES,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder sb = new StringBuilder();

				sb.append(_SQL_GETLMISOVERTIMEREPORTSES);

				if (obc != null) {
					sb.append("ORDER BY ");
					sb.append(obc.getOrderBy());
				}

				String sql = sb.toString();

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("lmis_overtime_reports",
					larion.progate.lmis.model.impl.LmisOverTimeReportsImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<larion.progate.lmis.model.LmisOverTimeReports>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<larion.progate.lmis.model.LmisOverTimeReports>();
				}

				lmisOverTimeReportsPersistence.cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_GET_LMISOVERTIMEREPORTSES,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_LMISOVERTIMEREPORTSES_SIZE = new FinderPath(larion.progate.lmis.model.impl.LmisOverTimeReportsModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.lmis.model.impl.LmisOverTimeReportsModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.lmis.service.persistence.LmisOverTimeReportsPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getLmisOverTimeReportsesSize",
			new String[] { Integer.class.getName() });

	public int getLmisOverTimeReportsesSize(Integer pk)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_LMISOVERTIMEREPORTSES_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETLMISOVERTIMEREPORTSESSIZE);

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

				FinderCacheUtil.putResult(FINDER_PATH_GET_LMISOVERTIMEREPORTSES_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_LMISOVERTIMEREPORTS = new FinderPath(larion.progate.lmis.model.impl.LmisOverTimeReportsModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.lmis.model.impl.LmisOverTimeReportsModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.lmis.service.persistence.LmisOverTimeReportsPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"containsLmisOverTimeReports",
			new String[] { Integer.class.getName(), Integer.class.getName() });

	public boolean containsLmisOverTimeReports(Integer pk,
		Integer lmisOverTimeReportsPK) throws SystemException {
		Object[] finderArgs = new Object[] { pk, lmisOverTimeReportsPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_LMISOVERTIMEREPORTS,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsLmisOverTimeReports.contains(
							pk, lmisOverTimeReportsPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_LMISOVERTIMEREPORTS,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	public boolean containsLmisOverTimeReportses(Integer pk)
		throws SystemException {
		if (getLmisOverTimeReportsesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.larion.progate.lmis.model.LmisOvertimeRequests")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LmisOvertimeRequests>> listenersList = new ArrayList<ModelListener<LmisOvertimeRequests>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LmisOvertimeRequests>)Class.forName(
							listenerClassName).newInstance());
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		containsLmisOvertimeRequestDetails = new ContainsLmisOvertimeRequestDetails(this);

		containsLmisOvertimeApprovals = new ContainsLmisOvertimeApprovals(this);

		containsLmisOverTimeReports = new ContainsLmisOverTimeReports(this);
	}

	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisEmailSettingsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisEmailSettingsPersistence lmisEmailSettingsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisEmailSettingDetailsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisEmailSettingDetailsPersistence lmisEmailSettingDetailsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisTimeChangeApprovalsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisTimeChangeApprovalsPersistence lmisTimeChangeApprovalsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisTimeChangeRequestsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisTimeChangeRequestsPersistence lmisTimeChangeRequestsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisWorkingTimesPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisWorkingTimesPersistence lmisWorkingTimesPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisDayTypesPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisDayTypesPersistence lmisDayTypesPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisWorkingCalendarsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisWorkingCalendarsPersistence lmisWorkingCalendarsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisWorkingCalendarSessionsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisWorkingCalendarSessionsPersistence lmisWorkingCalendarSessionsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisGeneralSettingsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisGeneralSettingsPersistence lmisGeneralSettingsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewStaffMappingPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewStaffMappingPersistence lmisViewStaffMappingPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewStaffRootOrgPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewStaffRootOrgPersistence lmisViewStaffRootOrgPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewStaffRootOrgFNPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewStaffRootOrgFNPersistence lmisViewStaffRootOrgFNPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewStaffRootOrgOrderedPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewStaffRootOrgOrderedPersistence lmisViewStaffRootOrgOrderedPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewTimeChangeReqsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewTimeChangeReqsPersistence lmisViewTimeChangeReqsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewEmailSettingDetailOrgPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewEmailSettingDetailOrgPersistence lmisViewEmailSettingDetailOrgPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewEmailSettingDetailUserPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewEmailSettingDetailUserPersistence lmisViewEmailSettingDetailUserPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewWorkingCalendarPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewWorkingCalendarPersistence lmisViewWorkingCalendarPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisOverTimeSettingsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisOverTimeSettingsPersistence lmisOverTimeSettingsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisOverTimeTypesPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisOverTimeTypesPersistence lmisOverTimeTypesPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisDataInputsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisDataInputsPersistence lmisDataInputsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisAttendanceDailyPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisAttendanceDailyPersistence lmisAttendanceDailyPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisOvertimeRequestsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisOvertimeRequestsPersistence lmisOvertimeRequestsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisOvertimeRequestDetailsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisOvertimeRequestDetailsPersistence lmisOvertimeRequestDetailsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisOvertimeApprovalsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisOvertimeApprovalsPersistence lmisOvertimeApprovalsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisOvertimeMonthlyPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisOvertimeMonthlyPersistence lmisOvertimeMonthlyPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisDataImportsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisDataImportsPersistence lmisDataImportsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisDataImportDetailsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisDataImportDetailsPersistence lmisDataImportDetailsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisOverTimeReportHoursPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisOverTimeReportHoursPersistence lmisOverTimeReportHoursPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisOverTimeReportDetailsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisOverTimeReportDetailsPersistence lmisOverTimeReportDetailsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisOverTimeReportsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisOverTimeReportsPersistence lmisOverTimeReportsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisOvertimeYearlyPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisOvertimeYearlyPersistence lmisOvertimeYearlyPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisAbsenceYearlyPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisAbsenceYearlyPersistence lmisAbsenceYearlyPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisAbsenceMonthlyPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisAbsenceMonthlyPersistence lmisAbsenceMonthlyPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisAbsenceSettingsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisAbsenceSettingsPersistence lmisAbsenceSettingsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisAbsenceApprovalsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisAbsenceApprovalsPersistence lmisAbsenceApprovalsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisAbsenceRequestsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisAbsenceRequestsPersistence lmisAbsenceRequestsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewDayTypeOverTimeSettingTypePersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewDayTypeOverTimeSettingTypePersistence lmisViewDayTypeOverTimeSettingTypePersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewRegistrationOvertimePersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewRegistrationOvertimePersistence lmisViewRegistrationOvertimePersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewRegistrationOvertimeaApprovalPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewRegistrationOvertimeaApprovalPersistence lmisViewRegistrationOvertimeaApprovalPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewOTAppPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewOTAppPersistence lmisViewOTAppPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewReportOvertimePersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewReportOvertimePersistence lmisViewReportOvertimePersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewAttDailyPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewAttDailyPersistence lmisViewAttDailyPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewReportOvertimeApprovalPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewReportOvertimeApprovalPersistence lmisViewReportOvertimeApprovalPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewDayValueMaxPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewDayValueMaxPersistence lmisViewDayValueMaxPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewOrgUserRolesPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewOrgUserRolesPersistence lmisViewOrgUserRolesPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewAttInfoPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewAttInfoPersistence lmisViewAttInfoPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewStaffMappingPmPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewStaffMappingPmPersistence lmisViewStaffMappingPmPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewAttdancePersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewAttdancePersistence lmisViewAttdancePersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewOvertimeReportPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewOvertimeReportPersistence lmisViewOvertimeReportPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewOvertimeReportDetailPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewOvertimeReportDetailPersistence lmisViewOvertimeReportDetailPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisAttMonthlyPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisAttMonthlyPersistence lmisAttMonthlyPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisAttYearlyPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisAttYearlyPersistence lmisAttYearlyPersistence;
	protected ContainsLmisOvertimeRequestDetails containsLmisOvertimeRequestDetails;
	protected ContainsLmisOvertimeApprovals containsLmisOvertimeApprovals;
	protected ContainsLmisOverTimeReports containsLmisOverTimeReports;

	protected class ContainsLmisOvertimeRequestDetails {
		protected ContainsLmisOvertimeRequestDetails(
			LmisOvertimeRequestsPersistenceImpl persistenceImpl) {
			super();

			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSLMISOVERTIMEREQUESTDETAILS,
					new int[] { Types.INTEGER, Types.INTEGER }, RowMapper.COUNT);
		}

		protected boolean contains(Integer lmisOvertimeRequestsId,
			Integer lmisOvertimeRequestDetailsId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						lmisOvertimeRequestsId, lmisOvertimeRequestDetailsId
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

	protected class ContainsLmisOvertimeApprovals {
		protected ContainsLmisOvertimeApprovals(
			LmisOvertimeRequestsPersistenceImpl persistenceImpl) {
			super();

			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSLMISOVERTIMEAPPROVALS,
					new int[] { Types.INTEGER, Types.INTEGER }, RowMapper.COUNT);
		}

		protected boolean contains(Integer lmisOvertimeRequestsId,
			Integer lmisOvertimeApprovalsId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						lmisOvertimeRequestsId, lmisOvertimeApprovalsId
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

	protected class ContainsLmisOverTimeReports {
		protected ContainsLmisOverTimeReports(
			LmisOvertimeRequestsPersistenceImpl persistenceImpl) {
			super();

			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSLMISOVERTIMEREPORTS,
					new int[] { Types.INTEGER, Types.INTEGER }, RowMapper.COUNT);
		}

		protected boolean contains(Integer lmisOvertimeRequestsId,
			Integer lmisOverTimeReportsId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						lmisOvertimeRequestsId, lmisOverTimeReportsId
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

	private static final String _SQL_GETLMISOVERTIMEREQUESTDETAILSES = "SELECT {lmis_overtime_request_details.*} FROM lmis_overtime_request_details INNER JOIN lmis_overtime_requests ON (lmis_overtime_requests.lmisOvertimeRequestsId = lmis_overtime_request_details.lmisOvertimeRequestsId) WHERE (lmis_overtime_requests.lmisOvertimeRequestsId = ?)";
	private static final String _SQL_GETLMISOVERTIMEREQUESTDETAILSESSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM lmis_overtime_request_details WHERE lmisOvertimeRequestsId = ?";
	private static final String _SQL_CONTAINSLMISOVERTIMEREQUESTDETAILS = "SELECT COUNT(*) AS COUNT_VALUE FROM lmis_overtime_request_details WHERE lmisOvertimeRequestsId = ? AND lmisOvertimeRequestDetailsId = ?";
	private static final String _SQL_GETLMISOVERTIMEAPPROVALSES = "SELECT {lmis_overtime_approvals.*} FROM lmis_overtime_approvals INNER JOIN lmis_overtime_requests ON (lmis_overtime_requests.lmisOvertimeRequestsId = lmis_overtime_approvals.lmisOvertimeRequestsId) WHERE (lmis_overtime_requests.lmisOvertimeRequestsId = ?)";
	private static final String _SQL_GETLMISOVERTIMEAPPROVALSESSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM lmis_overtime_approvals WHERE lmisOvertimeRequestsId = ?";
	private static final String _SQL_CONTAINSLMISOVERTIMEAPPROVALS = "SELECT COUNT(*) AS COUNT_VALUE FROM lmis_overtime_approvals WHERE lmisOvertimeRequestsId = ? AND lmisOvertimeApprovalsId = ?";
	private static final String _SQL_GETLMISOVERTIMEREPORTSES = "SELECT {lmis_overtime_reports.*} FROM lmis_overtime_reports INNER JOIN lmis_overtime_requests ON (lmis_overtime_requests.lmisOvertimeRequestsId = lmis_overtime_reports.lmisOvertimeRequestsId) WHERE (lmis_overtime_requests.lmisOvertimeRequestsId = ?)";
	private static final String _SQL_GETLMISOVERTIMEREPORTSESSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM lmis_overtime_reports WHERE lmisOvertimeRequestsId = ?";
	private static final String _SQL_CONTAINSLMISOVERTIMEREPORTS = "SELECT COUNT(*) AS COUNT_VALUE FROM lmis_overtime_reports WHERE lmisOvertimeRequestsId = ? AND lmisOverTimeReportsId = ?";
	private static Log _log = LogFactoryUtil.getLog(LmisOvertimeRequestsPersistenceImpl.class);
}