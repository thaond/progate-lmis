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

import larion.progate.lmis.NoSuchLmisTimeChangeRequestsException;
import larion.progate.lmis.model.LmisTimeChangeRequests;
import larion.progate.lmis.model.impl.LmisTimeChangeRequestsImpl;
import larion.progate.lmis.model.impl.LmisTimeChangeRequestsModelImpl;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="LmisTimeChangeRequestsPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisTimeChangeRequestsPersistenceImpl extends BasePersistenceImpl
	implements LmisTimeChangeRequestsPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = LmisTimeChangeRequestsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_ROOTID = new FinderPath(LmisTimeChangeRequestsModelImpl.ENTITY_CACHE_ENABLED,
			LmisTimeChangeRequestsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ROOTID = new FinderPath(LmisTimeChangeRequestsModelImpl.ENTITY_CACHE_ENABLED,
			LmisTimeChangeRequestsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ROOTID = new FinderPath(LmisTimeChangeRequestsModelImpl.ENTITY_CACHE_ENABLED,
			LmisTimeChangeRequestsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByRootId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_USERID = new FinderPath(LmisTimeChangeRequestsModelImpl.ENTITY_CACHE_ENABLED,
			LmisTimeChangeRequestsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByUserId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_USERID = new FinderPath(LmisTimeChangeRequestsModelImpl.ENTITY_CACHE_ENABLED,
			LmisTimeChangeRequestsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByUserId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(LmisTimeChangeRequestsModelImpl.ENTITY_CACHE_ENABLED,
			LmisTimeChangeRequestsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByUserId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(LmisTimeChangeRequestsModelImpl.ENTITY_CACHE_ENABLED,
			LmisTimeChangeRequestsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LmisTimeChangeRequestsModelImpl.ENTITY_CACHE_ENABLED,
			LmisTimeChangeRequestsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(LmisTimeChangeRequests lmisTimeChangeRequests) {
		EntityCacheUtil.putResult(LmisTimeChangeRequestsModelImpl.ENTITY_CACHE_ENABLED,
			LmisTimeChangeRequestsImpl.class,
			lmisTimeChangeRequests.getPrimaryKey(), lmisTimeChangeRequests);
	}

	public void cacheResult(
		List<LmisTimeChangeRequests> lmisTimeChangeRequestses) {
		for (LmisTimeChangeRequests lmisTimeChangeRequests : lmisTimeChangeRequestses) {
			if (EntityCacheUtil.getResult(
						LmisTimeChangeRequestsModelImpl.ENTITY_CACHE_ENABLED,
						LmisTimeChangeRequestsImpl.class,
						lmisTimeChangeRequests.getPrimaryKey(), this) == null) {
				cacheResult(lmisTimeChangeRequests);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(LmisTimeChangeRequestsImpl.class.getName());
		EntityCacheUtil.clearCache(LmisTimeChangeRequestsImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public LmisTimeChangeRequests create(Integer lmisTimeChangeRequestId) {
		LmisTimeChangeRequests lmisTimeChangeRequests = new LmisTimeChangeRequestsImpl();

		lmisTimeChangeRequests.setNew(true);
		lmisTimeChangeRequests.setPrimaryKey(lmisTimeChangeRequestId);

		return lmisTimeChangeRequests;
	}

	public LmisTimeChangeRequests remove(Integer lmisTimeChangeRequestId)
		throws NoSuchLmisTimeChangeRequestsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LmisTimeChangeRequests lmisTimeChangeRequests = (LmisTimeChangeRequests)session.get(LmisTimeChangeRequestsImpl.class,
					lmisTimeChangeRequestId);

			if (lmisTimeChangeRequests == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No LmisTimeChangeRequests exists with the primary key " +
						lmisTimeChangeRequestId);
				}

				throw new NoSuchLmisTimeChangeRequestsException(
					"No LmisTimeChangeRequests exists with the primary key " +
					lmisTimeChangeRequestId);
			}

			return remove(lmisTimeChangeRequests);
		}
		catch (NoSuchLmisTimeChangeRequestsException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public LmisTimeChangeRequests remove(
		LmisTimeChangeRequests lmisTimeChangeRequests)
		throws SystemException {
		for (ModelListener<LmisTimeChangeRequests> listener : listeners) {
			listener.onBeforeRemove(lmisTimeChangeRequests);
		}

		lmisTimeChangeRequests = removeImpl(lmisTimeChangeRequests);

		for (ModelListener<LmisTimeChangeRequests> listener : listeners) {
			listener.onAfterRemove(lmisTimeChangeRequests);
		}

		return lmisTimeChangeRequests;
	}

	protected LmisTimeChangeRequests removeImpl(
		LmisTimeChangeRequests lmisTimeChangeRequests)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (lmisTimeChangeRequests.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(LmisTimeChangeRequestsImpl.class,
						lmisTimeChangeRequests.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(lmisTimeChangeRequests);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(LmisTimeChangeRequestsModelImpl.ENTITY_CACHE_ENABLED,
			LmisTimeChangeRequestsImpl.class,
			lmisTimeChangeRequests.getPrimaryKey());

		return lmisTimeChangeRequests;
	}

	public LmisTimeChangeRequests update(
		LmisTimeChangeRequests lmisTimeChangeRequests)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(LmisTimeChangeRequests lmisTimeChangeRequests) method. Use update(LmisTimeChangeRequests lmisTimeChangeRequests, boolean merge) instead.");
		}

		return update(lmisTimeChangeRequests, false);
	}

	public LmisTimeChangeRequests update(
		LmisTimeChangeRequests lmisTimeChangeRequests, boolean merge)
		throws SystemException {
		boolean isNew = lmisTimeChangeRequests.isNew();

		for (ModelListener<LmisTimeChangeRequests> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(lmisTimeChangeRequests);
			}
			else {
				listener.onBeforeUpdate(lmisTimeChangeRequests);
			}
		}

		lmisTimeChangeRequests = updateImpl(lmisTimeChangeRequests, merge);

		for (ModelListener<LmisTimeChangeRequests> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(lmisTimeChangeRequests);
			}
			else {
				listener.onAfterUpdate(lmisTimeChangeRequests);
			}
		}

		return lmisTimeChangeRequests;
	}

	public LmisTimeChangeRequests updateImpl(
		larion.progate.lmis.model.LmisTimeChangeRequests lmisTimeChangeRequests,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, lmisTimeChangeRequests, merge);

			lmisTimeChangeRequests.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(LmisTimeChangeRequestsModelImpl.ENTITY_CACHE_ENABLED,
			LmisTimeChangeRequestsImpl.class,
			lmisTimeChangeRequests.getPrimaryKey(), lmisTimeChangeRequests);

		return lmisTimeChangeRequests;
	}

	public LmisTimeChangeRequests findByPrimaryKey(
		Integer lmisTimeChangeRequestId)
		throws NoSuchLmisTimeChangeRequestsException, SystemException {
		LmisTimeChangeRequests lmisTimeChangeRequests = fetchByPrimaryKey(lmisTimeChangeRequestId);

		if (lmisTimeChangeRequests == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"No LmisTimeChangeRequests exists with the primary key " +
					lmisTimeChangeRequestId);
			}

			throw new NoSuchLmisTimeChangeRequestsException(
				"No LmisTimeChangeRequests exists with the primary key " +
				lmisTimeChangeRequestId);
		}

		return lmisTimeChangeRequests;
	}

	public LmisTimeChangeRequests fetchByPrimaryKey(
		Integer lmisTimeChangeRequestId) throws SystemException {
		LmisTimeChangeRequests lmisTimeChangeRequests = (LmisTimeChangeRequests)EntityCacheUtil.getResult(LmisTimeChangeRequestsModelImpl.ENTITY_CACHE_ENABLED,
				LmisTimeChangeRequestsImpl.class, lmisTimeChangeRequestId, this);

		if (lmisTimeChangeRequests == null) {
			Session session = null;

			try {
				session = openSession();

				lmisTimeChangeRequests = (LmisTimeChangeRequests)session.get(LmisTimeChangeRequestsImpl.class,
						lmisTimeChangeRequestId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (lmisTimeChangeRequests != null) {
					cacheResult(lmisTimeChangeRequests);
				}

				closeSession(session);
			}
		}

		return lmisTimeChangeRequests;
	}

	public List<LmisTimeChangeRequests> findByRootId(int rootId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		List<LmisTimeChangeRequests> list = (List<LmisTimeChangeRequests>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisTimeChangeRequests WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("requested_status ASC, ");
				query.append("start_date DESC");

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
					list = new ArrayList<LmisTimeChangeRequests>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisTimeChangeRequests> findByRootId(int rootId, int start,
		int end) throws SystemException {
		return findByRootId(rootId, start, end, null);
	}

	public List<LmisTimeChangeRequests> findByRootId(int rootId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(rootId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisTimeChangeRequests> list = (List<LmisTimeChangeRequests>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisTimeChangeRequests WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("requested_status ASC, ");
					query.append("start_date DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rootId);

				list = (List<LmisTimeChangeRequests>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisTimeChangeRequests>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisTimeChangeRequests findByRootId_First(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisTimeChangeRequestsException, SystemException {
		List<LmisTimeChangeRequests> list = findByRootId(rootId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisTimeChangeRequests exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisTimeChangeRequestsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisTimeChangeRequests findByRootId_Last(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisTimeChangeRequestsException, SystemException {
		int count = countByRootId(rootId);

		List<LmisTimeChangeRequests> list = findByRootId(rootId, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisTimeChangeRequests exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisTimeChangeRequestsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisTimeChangeRequests[] findByRootId_PrevAndNext(
		Integer lmisTimeChangeRequestId, int rootId, OrderByComparator obc)
		throws NoSuchLmisTimeChangeRequestsException, SystemException {
		LmisTimeChangeRequests lmisTimeChangeRequests = findByPrimaryKey(lmisTimeChangeRequestId);

		int count = countByRootId(rootId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisTimeChangeRequests WHERE ");

			query.append("root_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("requested_status ASC, ");
				query.append("start_date DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(rootId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisTimeChangeRequests);

			LmisTimeChangeRequests[] array = new LmisTimeChangeRequestsImpl[3];

			array[0] = (LmisTimeChangeRequests)objArray[0];
			array[1] = (LmisTimeChangeRequests)objArray[1];
			array[2] = (LmisTimeChangeRequests)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisTimeChangeRequests> findByUserId(int requestedBy)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(requestedBy) };

		List<LmisTimeChangeRequests> list = (List<LmisTimeChangeRequests>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_USERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisTimeChangeRequests WHERE ");

				query.append("requested_by = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("requested_status ASC, ");
				query.append("start_date DESC");

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
					list = new ArrayList<LmisTimeChangeRequests>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_USERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisTimeChangeRequests> findByUserId(int requestedBy,
		int start, int end) throws SystemException {
		return findByUserId(requestedBy, start, end, null);
	}

	public List<LmisTimeChangeRequests> findByUserId(int requestedBy,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(requestedBy),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisTimeChangeRequests> list = (List<LmisTimeChangeRequests>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_USERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisTimeChangeRequests WHERE ");

				query.append("requested_by = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("requested_status ASC, ");
					query.append("start_date DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(requestedBy);

				list = (List<LmisTimeChangeRequests>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisTimeChangeRequests>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_USERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisTimeChangeRequests findByUserId_First(int requestedBy,
		OrderByComparator obc)
		throws NoSuchLmisTimeChangeRequestsException, SystemException {
		List<LmisTimeChangeRequests> list = findByUserId(requestedBy, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisTimeChangeRequests exists with the key {");

			msg.append("requestedBy=" + requestedBy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisTimeChangeRequestsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisTimeChangeRequests findByUserId_Last(int requestedBy,
		OrderByComparator obc)
		throws NoSuchLmisTimeChangeRequestsException, SystemException {
		int count = countByUserId(requestedBy);

		List<LmisTimeChangeRequests> list = findByUserId(requestedBy,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisTimeChangeRequests exists with the key {");

			msg.append("requestedBy=" + requestedBy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisTimeChangeRequestsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisTimeChangeRequests[] findByUserId_PrevAndNext(
		Integer lmisTimeChangeRequestId, int requestedBy, OrderByComparator obc)
		throws NoSuchLmisTimeChangeRequestsException, SystemException {
		LmisTimeChangeRequests lmisTimeChangeRequests = findByPrimaryKey(lmisTimeChangeRequestId);

		int count = countByUserId(requestedBy);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisTimeChangeRequests WHERE ");

			query.append("requested_by = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("requested_status ASC, ");
				query.append("start_date DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(requestedBy);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisTimeChangeRequests);

			LmisTimeChangeRequests[] array = new LmisTimeChangeRequestsImpl[3];

			array[0] = (LmisTimeChangeRequests)objArray[0];
			array[1] = (LmisTimeChangeRequests)objArray[1];
			array[2] = (LmisTimeChangeRequests)objArray[2];

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

	public List<LmisTimeChangeRequests> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<LmisTimeChangeRequests> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<LmisTimeChangeRequests> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisTimeChangeRequests> list = (List<LmisTimeChangeRequests>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisTimeChangeRequests ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("requested_status ASC, ");
					query.append("start_date DESC");
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<LmisTimeChangeRequests>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LmisTimeChangeRequests>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisTimeChangeRequests>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByRootId(int rootId) throws SystemException {
		for (LmisTimeChangeRequests lmisTimeChangeRequests : findByRootId(
				rootId)) {
			remove(lmisTimeChangeRequests);
		}
	}

	public void removeByUserId(int requestedBy) throws SystemException {
		for (LmisTimeChangeRequests lmisTimeChangeRequests : findByUserId(
				requestedBy)) {
			remove(lmisTimeChangeRequests);
		}
	}

	public void removeAll() throws SystemException {
		for (LmisTimeChangeRequests lmisTimeChangeRequests : findAll()) {
			remove(lmisTimeChangeRequests);
		}
	}

	public int countByRootId(int rootId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ROOTID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisTimeChangeRequests WHERE ");

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

	public int countByUserId(int requestedBy) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(requestedBy) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisTimeChangeRequests WHERE ");

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID,
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
						"SELECT COUNT(*) FROM larion.progate.lmis.model.LmisTimeChangeRequests");

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

	public List<larion.progate.lmis.model.LmisTimeChangeApprovals> getLmisTimeChangeApprovalses(
		Integer pk) throws SystemException {
		return getLmisTimeChangeApprovalses(pk, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS);
	}

	public List<larion.progate.lmis.model.LmisTimeChangeApprovals> getLmisTimeChangeApprovalses(
		Integer pk, int start, int end) throws SystemException {
		return getLmisTimeChangeApprovalses(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_LMISTIMECHANGEAPPROVALSES = new FinderPath(larion.progate.lmis.model.impl.LmisTimeChangeApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.lmis.model.impl.LmisTimeChangeApprovalsModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.lmis.service.persistence.LmisTimeChangeApprovalsPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getLmisTimeChangeApprovalses",
			new String[] {
				Integer.class.getName(), "java.lang.Integer",
				"java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	public List<larion.progate.lmis.model.LmisTimeChangeApprovals> getLmisTimeChangeApprovalses(
		Integer pk, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				pk, String.valueOf(start), String.valueOf(end),
				String.valueOf(obc)
			};

		List<larion.progate.lmis.model.LmisTimeChangeApprovals> list = (List<larion.progate.lmis.model.LmisTimeChangeApprovals>)FinderCacheUtil.getResult(FINDER_PATH_GET_LMISTIMECHANGEAPPROVALSES,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder sb = new StringBuilder();

				sb.append(_SQL_GETLMISTIMECHANGEAPPROVALSES);

				if (obc != null) {
					sb.append("ORDER BY ");
					sb.append(obc.getOrderBy());
				}

				else {
					sb.append("ORDER BY ");

					sb.append("lmis_timechange_approvals.approved_status ASC, ");
					sb.append("lmis_timechange_approvals.approved_at DESC");
				}

				String sql = sb.toString();

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("lmis_timechange_approvals",
					larion.progate.lmis.model.impl.LmisTimeChangeApprovalsImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<larion.progate.lmis.model.LmisTimeChangeApprovals>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<larion.progate.lmis.model.LmisTimeChangeApprovals>();
				}

				lmisTimeChangeApprovalsPersistence.cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_GET_LMISTIMECHANGEAPPROVALSES,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_LMISTIMECHANGEAPPROVALSES_SIZE =
		new FinderPath(larion.progate.lmis.model.impl.LmisTimeChangeApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.lmis.model.impl.LmisTimeChangeApprovalsModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.lmis.service.persistence.LmisTimeChangeApprovalsPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getLmisTimeChangeApprovalsesSize",
			new String[] { Integer.class.getName() });

	public int getLmisTimeChangeApprovalsesSize(Integer pk)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_LMISTIMECHANGEAPPROVALSES_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETLMISTIMECHANGEAPPROVALSESSIZE);

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

				FinderCacheUtil.putResult(FINDER_PATH_GET_LMISTIMECHANGEAPPROVALSES_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_LMISTIMECHANGEAPPROVALS = new FinderPath(larion.progate.lmis.model.impl.LmisTimeChangeApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.lmis.model.impl.LmisTimeChangeApprovalsModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.lmis.service.persistence.LmisTimeChangeApprovalsPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"containsLmisTimeChangeApprovals",
			new String[] { Integer.class.getName(), Integer.class.getName() });

	public boolean containsLmisTimeChangeApprovals(Integer pk,
		Integer lmisTimeChangeApprovalsPK) throws SystemException {
		Object[] finderArgs = new Object[] { pk, lmisTimeChangeApprovalsPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_LMISTIMECHANGEAPPROVALS,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsLmisTimeChangeApprovals.contains(
							pk, lmisTimeChangeApprovalsPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_LMISTIMECHANGEAPPROVALS,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	public boolean containsLmisTimeChangeApprovalses(Integer pk)
		throws SystemException {
		if (getLmisTimeChangeApprovalsesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.larion.progate.lmis.model.LmisTimeChangeRequests")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LmisTimeChangeRequests>> listenersList = new ArrayList<ModelListener<LmisTimeChangeRequests>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LmisTimeChangeRequests>)Class.forName(
							listenerClassName).newInstance());
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		containsLmisTimeChangeApprovals = new ContainsLmisTimeChangeApprovals(this);
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
	protected ContainsLmisTimeChangeApprovals containsLmisTimeChangeApprovals;

	protected class ContainsLmisTimeChangeApprovals {
		protected ContainsLmisTimeChangeApprovals(
			LmisTimeChangeRequestsPersistenceImpl persistenceImpl) {
			super();

			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSLMISTIMECHANGEAPPROVALS,
					new int[] { Types.INTEGER, Types.INTEGER }, RowMapper.COUNT);
		}

		protected boolean contains(Integer lmisTimeChangeRequestId,
			Integer lmisTimeChangeApprovalId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						lmisTimeChangeRequestId, lmisTimeChangeApprovalId
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

	private static final String _SQL_GETLMISTIMECHANGEAPPROVALSES = "SELECT {lmis_timechange_approvals.*} FROM lmis_timechange_approvals INNER JOIN lmis_timechange_requests ON (lmis_timechange_requests.lmisTimeChangeRequestId = lmis_timechange_approvals.lmisTimeChangeRequestId) WHERE (lmis_timechange_requests.lmisTimeChangeRequestId = ?)";
	private static final String _SQL_GETLMISTIMECHANGEAPPROVALSESSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM lmis_timechange_approvals WHERE lmisTimeChangeRequestId = ?";
	private static final String _SQL_CONTAINSLMISTIMECHANGEAPPROVALS = "SELECT COUNT(*) AS COUNT_VALUE FROM lmis_timechange_approvals WHERE lmisTimeChangeRequestId = ? AND lmisTimeChangeApprovalId = ?";
	private static Log _log = LogFactoryUtil.getLog(LmisTimeChangeRequestsPersistenceImpl.class);
}