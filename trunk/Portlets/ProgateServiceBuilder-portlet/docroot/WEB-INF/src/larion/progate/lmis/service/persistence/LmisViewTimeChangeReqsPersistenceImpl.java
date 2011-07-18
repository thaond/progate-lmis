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

import larion.progate.lmis.NoSuchLmisViewTimeChangeReqsException;
import larion.progate.lmis.model.LmisViewTimeChangeReqs;
import larion.progate.lmis.model.impl.LmisViewTimeChangeReqsImpl;
import larion.progate.lmis.model.impl.LmisViewTimeChangeReqsModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="LmisViewTimeChangeReqsPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewTimeChangeReqsPersistenceImpl extends BasePersistenceImpl
	implements LmisViewTimeChangeReqsPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = LmisViewTimeChangeReqsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_ROOTID = new FinderPath(LmisViewTimeChangeReqsModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewTimeChangeReqsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ROOTID = new FinderPath(LmisViewTimeChangeReqsModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewTimeChangeReqsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ROOTID = new FinderPath(LmisViewTimeChangeReqsModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewTimeChangeReqsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByRootId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_USERID = new FinderPath(LmisViewTimeChangeReqsModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewTimeChangeReqsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByUserId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_USERID = new FinderPath(LmisViewTimeChangeReqsModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewTimeChangeReqsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByUserId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(LmisViewTimeChangeReqsModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewTimeChangeReqsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByUserId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(LmisViewTimeChangeReqsModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewTimeChangeReqsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LmisViewTimeChangeReqsModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewTimeChangeReqsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(LmisViewTimeChangeReqs lmisViewTimeChangeReqs) {
		EntityCacheUtil.putResult(LmisViewTimeChangeReqsModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewTimeChangeReqsImpl.class,
			lmisViewTimeChangeReqs.getPrimaryKey(), lmisViewTimeChangeReqs);
	}

	public void cacheResult(
		List<LmisViewTimeChangeReqs> lmisViewTimeChangeReqses) {
		for (LmisViewTimeChangeReqs lmisViewTimeChangeReqs : lmisViewTimeChangeReqses) {
			if (EntityCacheUtil.getResult(
						LmisViewTimeChangeReqsModelImpl.ENTITY_CACHE_ENABLED,
						LmisViewTimeChangeReqsImpl.class,
						lmisViewTimeChangeReqs.getPrimaryKey(), this) == null) {
				cacheResult(lmisViewTimeChangeReqs);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(LmisViewTimeChangeReqsImpl.class.getName());
		EntityCacheUtil.clearCache(LmisViewTimeChangeReqsImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public LmisViewTimeChangeReqs create(Integer lmisViewTimeChangeReqId) {
		LmisViewTimeChangeReqs lmisViewTimeChangeReqs = new LmisViewTimeChangeReqsImpl();

		lmisViewTimeChangeReqs.setNew(true);
		lmisViewTimeChangeReqs.setPrimaryKey(lmisViewTimeChangeReqId);

		return lmisViewTimeChangeReqs;
	}

	public LmisViewTimeChangeReqs remove(Integer lmisViewTimeChangeReqId)
		throws NoSuchLmisViewTimeChangeReqsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LmisViewTimeChangeReqs lmisViewTimeChangeReqs = (LmisViewTimeChangeReqs)session.get(LmisViewTimeChangeReqsImpl.class,
					lmisViewTimeChangeReqId);

			if (lmisViewTimeChangeReqs == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No LmisViewTimeChangeReqs exists with the primary key " +
						lmisViewTimeChangeReqId);
				}

				throw new NoSuchLmisViewTimeChangeReqsException(
					"No LmisViewTimeChangeReqs exists with the primary key " +
					lmisViewTimeChangeReqId);
			}

			return remove(lmisViewTimeChangeReqs);
		}
		catch (NoSuchLmisViewTimeChangeReqsException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public LmisViewTimeChangeReqs remove(
		LmisViewTimeChangeReqs lmisViewTimeChangeReqs)
		throws SystemException {
		for (ModelListener<LmisViewTimeChangeReqs> listener : listeners) {
			listener.onBeforeRemove(lmisViewTimeChangeReqs);
		}

		lmisViewTimeChangeReqs = removeImpl(lmisViewTimeChangeReqs);

		for (ModelListener<LmisViewTimeChangeReqs> listener : listeners) {
			listener.onAfterRemove(lmisViewTimeChangeReqs);
		}

		return lmisViewTimeChangeReqs;
	}

	protected LmisViewTimeChangeReqs removeImpl(
		LmisViewTimeChangeReqs lmisViewTimeChangeReqs)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (lmisViewTimeChangeReqs.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(LmisViewTimeChangeReqsImpl.class,
						lmisViewTimeChangeReqs.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(lmisViewTimeChangeReqs);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(LmisViewTimeChangeReqsModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewTimeChangeReqsImpl.class,
			lmisViewTimeChangeReqs.getPrimaryKey());

		return lmisViewTimeChangeReqs;
	}

	public LmisViewTimeChangeReqs update(
		LmisViewTimeChangeReqs lmisViewTimeChangeReqs)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(LmisViewTimeChangeReqs lmisViewTimeChangeReqs) method. Use update(LmisViewTimeChangeReqs lmisViewTimeChangeReqs, boolean merge) instead.");
		}

		return update(lmisViewTimeChangeReqs, false);
	}

	public LmisViewTimeChangeReqs update(
		LmisViewTimeChangeReqs lmisViewTimeChangeReqs, boolean merge)
		throws SystemException {
		boolean isNew = lmisViewTimeChangeReqs.isNew();

		for (ModelListener<LmisViewTimeChangeReqs> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(lmisViewTimeChangeReqs);
			}
			else {
				listener.onBeforeUpdate(lmisViewTimeChangeReqs);
			}
		}

		lmisViewTimeChangeReqs = updateImpl(lmisViewTimeChangeReqs, merge);

		for (ModelListener<LmisViewTimeChangeReqs> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(lmisViewTimeChangeReqs);
			}
			else {
				listener.onAfterUpdate(lmisViewTimeChangeReqs);
			}
		}

		return lmisViewTimeChangeReqs;
	}

	public LmisViewTimeChangeReqs updateImpl(
		larion.progate.lmis.model.LmisViewTimeChangeReqs lmisViewTimeChangeReqs,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, lmisViewTimeChangeReqs, merge);

			lmisViewTimeChangeReqs.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(LmisViewTimeChangeReqsModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewTimeChangeReqsImpl.class,
			lmisViewTimeChangeReqs.getPrimaryKey(), lmisViewTimeChangeReqs);

		return lmisViewTimeChangeReqs;
	}

	public LmisViewTimeChangeReqs findByPrimaryKey(
		Integer lmisViewTimeChangeReqId)
		throws NoSuchLmisViewTimeChangeReqsException, SystemException {
		LmisViewTimeChangeReqs lmisViewTimeChangeReqs = fetchByPrimaryKey(lmisViewTimeChangeReqId);

		if (lmisViewTimeChangeReqs == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"No LmisViewTimeChangeReqs exists with the primary key " +
					lmisViewTimeChangeReqId);
			}

			throw new NoSuchLmisViewTimeChangeReqsException(
				"No LmisViewTimeChangeReqs exists with the primary key " +
				lmisViewTimeChangeReqId);
		}

		return lmisViewTimeChangeReqs;
	}

	public LmisViewTimeChangeReqs fetchByPrimaryKey(
		Integer lmisViewTimeChangeReqId) throws SystemException {
		LmisViewTimeChangeReqs lmisViewTimeChangeReqs = (LmisViewTimeChangeReqs)EntityCacheUtil.getResult(LmisViewTimeChangeReqsModelImpl.ENTITY_CACHE_ENABLED,
				LmisViewTimeChangeReqsImpl.class, lmisViewTimeChangeReqId, this);

		if (lmisViewTimeChangeReqs == null) {
			Session session = null;

			try {
				session = openSession();

				lmisViewTimeChangeReqs = (LmisViewTimeChangeReqs)session.get(LmisViewTimeChangeReqsImpl.class,
						lmisViewTimeChangeReqId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (lmisViewTimeChangeReqs != null) {
					cacheResult(lmisViewTimeChangeReqs);
				}

				closeSession(session);
			}
		}

		return lmisViewTimeChangeReqs;
	}

	public List<LmisViewTimeChangeReqs> findByRootId(int rootId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		List<LmisViewTimeChangeReqs> list = (List<LmisViewTimeChangeReqs>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewTimeChangeReqs WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("requested_status ASC, ");
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
					list = new ArrayList<LmisViewTimeChangeReqs>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewTimeChangeReqs> findByRootId(int rootId, int start,
		int end) throws SystemException {
		return findByRootId(rootId, start, end, null);
	}

	public List<LmisViewTimeChangeReqs> findByRootId(int rootId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(rootId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewTimeChangeReqs> list = (List<LmisViewTimeChangeReqs>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewTimeChangeReqs WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("requested_status ASC, ");
					query.append("requested_status ASC, ");
					query.append("start_date DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rootId);

				list = (List<LmisViewTimeChangeReqs>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewTimeChangeReqs>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewTimeChangeReqs findByRootId_First(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisViewTimeChangeReqsException, SystemException {
		List<LmisViewTimeChangeReqs> list = findByRootId(rootId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewTimeChangeReqs exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewTimeChangeReqsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewTimeChangeReqs findByRootId_Last(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisViewTimeChangeReqsException, SystemException {
		int count = countByRootId(rootId);

		List<LmisViewTimeChangeReqs> list = findByRootId(rootId, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewTimeChangeReqs exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewTimeChangeReqsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewTimeChangeReqs[] findByRootId_PrevAndNext(
		Integer lmisViewTimeChangeReqId, int rootId, OrderByComparator obc)
		throws NoSuchLmisViewTimeChangeReqsException, SystemException {
		LmisViewTimeChangeReqs lmisViewTimeChangeReqs = findByPrimaryKey(lmisViewTimeChangeReqId);

		int count = countByRootId(rootId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewTimeChangeReqs WHERE ");

			query.append("root_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("requested_status ASC, ");
				query.append("requested_status ASC, ");
				query.append("start_date DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(rootId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisViewTimeChangeReqs);

			LmisViewTimeChangeReqs[] array = new LmisViewTimeChangeReqsImpl[3];

			array[0] = (LmisViewTimeChangeReqs)objArray[0];
			array[1] = (LmisViewTimeChangeReqs)objArray[1];
			array[2] = (LmisViewTimeChangeReqs)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewTimeChangeReqs> findByUserId(int requestedBy)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(requestedBy) };

		List<LmisViewTimeChangeReqs> list = (List<LmisViewTimeChangeReqs>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_USERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewTimeChangeReqs WHERE ");

				query.append("requested_by = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("requested_status ASC, ");
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
					list = new ArrayList<LmisViewTimeChangeReqs>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_USERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewTimeChangeReqs> findByUserId(int requestedBy,
		int start, int end) throws SystemException {
		return findByUserId(requestedBy, start, end, null);
	}

	public List<LmisViewTimeChangeReqs> findByUserId(int requestedBy,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(requestedBy),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewTimeChangeReqs> list = (List<LmisViewTimeChangeReqs>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_USERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewTimeChangeReqs WHERE ");

				query.append("requested_by = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("requested_status ASC, ");
					query.append("requested_status ASC, ");
					query.append("start_date DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(requestedBy);

				list = (List<LmisViewTimeChangeReqs>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewTimeChangeReqs>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_USERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewTimeChangeReqs findByUserId_First(int requestedBy,
		OrderByComparator obc)
		throws NoSuchLmisViewTimeChangeReqsException, SystemException {
		List<LmisViewTimeChangeReqs> list = findByUserId(requestedBy, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewTimeChangeReqs exists with the key {");

			msg.append("requestedBy=" + requestedBy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewTimeChangeReqsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewTimeChangeReqs findByUserId_Last(int requestedBy,
		OrderByComparator obc)
		throws NoSuchLmisViewTimeChangeReqsException, SystemException {
		int count = countByUserId(requestedBy);

		List<LmisViewTimeChangeReqs> list = findByUserId(requestedBy,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewTimeChangeReqs exists with the key {");

			msg.append("requestedBy=" + requestedBy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewTimeChangeReqsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewTimeChangeReqs[] findByUserId_PrevAndNext(
		Integer lmisViewTimeChangeReqId, int requestedBy, OrderByComparator obc)
		throws NoSuchLmisViewTimeChangeReqsException, SystemException {
		LmisViewTimeChangeReqs lmisViewTimeChangeReqs = findByPrimaryKey(lmisViewTimeChangeReqId);

		int count = countByUserId(requestedBy);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewTimeChangeReqs WHERE ");

			query.append("requested_by = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("requested_status ASC, ");
				query.append("requested_status ASC, ");
				query.append("start_date DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(requestedBy);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisViewTimeChangeReqs);

			LmisViewTimeChangeReqs[] array = new LmisViewTimeChangeReqsImpl[3];

			array[0] = (LmisViewTimeChangeReqs)objArray[0];
			array[1] = (LmisViewTimeChangeReqs)objArray[1];
			array[2] = (LmisViewTimeChangeReqs)objArray[2];

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

	public List<LmisViewTimeChangeReqs> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<LmisViewTimeChangeReqs> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<LmisViewTimeChangeReqs> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewTimeChangeReqs> list = (List<LmisViewTimeChangeReqs>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewTimeChangeReqs ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("requested_status ASC, ");
					query.append("requested_status ASC, ");
					query.append("start_date DESC");
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<LmisViewTimeChangeReqs>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LmisViewTimeChangeReqs>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewTimeChangeReqs>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByRootId(int rootId) throws SystemException {
		for (LmisViewTimeChangeReqs lmisViewTimeChangeReqs : findByRootId(
				rootId)) {
			remove(lmisViewTimeChangeReqs);
		}
	}

	public void removeByUserId(int requestedBy) throws SystemException {
		for (LmisViewTimeChangeReqs lmisViewTimeChangeReqs : findByUserId(
				requestedBy)) {
			remove(lmisViewTimeChangeReqs);
		}
	}

	public void removeAll() throws SystemException {
		for (LmisViewTimeChangeReqs lmisViewTimeChangeReqs : findAll()) {
			remove(lmisViewTimeChangeReqs);
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
					"FROM larion.progate.lmis.model.LmisViewTimeChangeReqs WHERE ");

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
					"FROM larion.progate.lmis.model.LmisViewTimeChangeReqs WHERE ");

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
						"SELECT COUNT(*) FROM larion.progate.lmis.model.LmisViewTimeChangeReqs");

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
						"value.object.listener.larion.progate.lmis.model.LmisViewTimeChangeReqs")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LmisViewTimeChangeReqs>> listenersList = new ArrayList<ModelListener<LmisViewTimeChangeReqs>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LmisViewTimeChangeReqs>)Class.forName(
							listenerClassName).newInstance());
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
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
	private static Log _log = LogFactoryUtil.getLog(LmisViewTimeChangeReqsPersistenceImpl.class);
}