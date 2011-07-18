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

import larion.progate.lmis.NoSuchLmisWorkingTimesException;
import larion.progate.lmis.model.LmisWorkingTimes;
import larion.progate.lmis.model.impl.LmisWorkingTimesImpl;
import larion.progate.lmis.model.impl.LmisWorkingTimesModelImpl;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="LmisWorkingTimesPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisWorkingTimesPersistenceImpl extends BasePersistenceImpl
	implements LmisWorkingTimesPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = LmisWorkingTimesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_WORKINGTIMEOF = new FinderPath(LmisWorkingTimesModelImpl.ENTITY_CACHE_ENABLED,
			LmisWorkingTimesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByWorkingTimeOf",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_WORKINGTIMEOF = new FinderPath(LmisWorkingTimesModelImpl.ENTITY_CACHE_ENABLED,
			LmisWorkingTimesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByWorkingTimeOf",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_WORKINGTIMEOF = new FinderPath(LmisWorkingTimesModelImpl.ENTITY_CACHE_ENABLED,
			LmisWorkingTimesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByWorkingTimeOf",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_SESSION = new FinderPath(LmisWorkingTimesModelImpl.ENTITY_CACHE_ENABLED,
			LmisWorkingTimesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBySession",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_SESSION = new FinderPath(LmisWorkingTimesModelImpl.ENTITY_CACHE_ENABLED,
			LmisWorkingTimesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBySession",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_SESSION = new FinderPath(LmisWorkingTimesModelImpl.ENTITY_CACHE_ENABLED,
			LmisWorkingTimesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBySession",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(LmisWorkingTimesModelImpl.ENTITY_CACHE_ENABLED,
			LmisWorkingTimesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LmisWorkingTimesModelImpl.ENTITY_CACHE_ENABLED,
			LmisWorkingTimesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(LmisWorkingTimes lmisWorkingTimes) {
		EntityCacheUtil.putResult(LmisWorkingTimesModelImpl.ENTITY_CACHE_ENABLED,
			LmisWorkingTimesImpl.class, lmisWorkingTimes.getPrimaryKey(),
			lmisWorkingTimes);
	}

	public void cacheResult(List<LmisWorkingTimes> lmisWorkingTimeses) {
		for (LmisWorkingTimes lmisWorkingTimes : lmisWorkingTimeses) {
			if (EntityCacheUtil.getResult(
						LmisWorkingTimesModelImpl.ENTITY_CACHE_ENABLED,
						LmisWorkingTimesImpl.class,
						lmisWorkingTimes.getPrimaryKey(), this) == null) {
				cacheResult(lmisWorkingTimes);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(LmisWorkingTimesImpl.class.getName());
		EntityCacheUtil.clearCache(LmisWorkingTimesImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public LmisWorkingTimes create(Integer lmisWorkingTimeId) {
		LmisWorkingTimes lmisWorkingTimes = new LmisWorkingTimesImpl();

		lmisWorkingTimes.setNew(true);
		lmisWorkingTimes.setPrimaryKey(lmisWorkingTimeId);

		return lmisWorkingTimes;
	}

	public LmisWorkingTimes remove(Integer lmisWorkingTimeId)
		throws NoSuchLmisWorkingTimesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LmisWorkingTimes lmisWorkingTimes = (LmisWorkingTimes)session.get(LmisWorkingTimesImpl.class,
					lmisWorkingTimeId);

			if (lmisWorkingTimes == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No LmisWorkingTimes exists with the primary key " +
						lmisWorkingTimeId);
				}

				throw new NoSuchLmisWorkingTimesException(
					"No LmisWorkingTimes exists with the primary key " +
					lmisWorkingTimeId);
			}

			return remove(lmisWorkingTimes);
		}
		catch (NoSuchLmisWorkingTimesException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public LmisWorkingTimes remove(LmisWorkingTimes lmisWorkingTimes)
		throws SystemException {
		for (ModelListener<LmisWorkingTimes> listener : listeners) {
			listener.onBeforeRemove(lmisWorkingTimes);
		}

		lmisWorkingTimes = removeImpl(lmisWorkingTimes);

		for (ModelListener<LmisWorkingTimes> listener : listeners) {
			listener.onAfterRemove(lmisWorkingTimes);
		}

		return lmisWorkingTimes;
	}

	protected LmisWorkingTimes removeImpl(LmisWorkingTimes lmisWorkingTimes)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (lmisWorkingTimes.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(LmisWorkingTimesImpl.class,
						lmisWorkingTimes.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(lmisWorkingTimes);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(LmisWorkingTimesModelImpl.ENTITY_CACHE_ENABLED,
			LmisWorkingTimesImpl.class, lmisWorkingTimes.getPrimaryKey());

		return lmisWorkingTimes;
	}

	public LmisWorkingTimes update(LmisWorkingTimes lmisWorkingTimes)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(LmisWorkingTimes lmisWorkingTimes) method. Use update(LmisWorkingTimes lmisWorkingTimes, boolean merge) instead.");
		}

		return update(lmisWorkingTimes, false);
	}

	public LmisWorkingTimes update(LmisWorkingTimes lmisWorkingTimes,
		boolean merge) throws SystemException {
		boolean isNew = lmisWorkingTimes.isNew();

		for (ModelListener<LmisWorkingTimes> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(lmisWorkingTimes);
			}
			else {
				listener.onBeforeUpdate(lmisWorkingTimes);
			}
		}

		lmisWorkingTimes = updateImpl(lmisWorkingTimes, merge);

		for (ModelListener<LmisWorkingTimes> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(lmisWorkingTimes);
			}
			else {
				listener.onAfterUpdate(lmisWorkingTimes);
			}
		}

		return lmisWorkingTimes;
	}

	public LmisWorkingTimes updateImpl(
		larion.progate.lmis.model.LmisWorkingTimes lmisWorkingTimes,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, lmisWorkingTimes, merge);

			lmisWorkingTimes.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(LmisWorkingTimesModelImpl.ENTITY_CACHE_ENABLED,
			LmisWorkingTimesImpl.class, lmisWorkingTimes.getPrimaryKey(),
			lmisWorkingTimes);

		return lmisWorkingTimes;
	}

	public LmisWorkingTimes findByPrimaryKey(Integer lmisWorkingTimeId)
		throws NoSuchLmisWorkingTimesException, SystemException {
		LmisWorkingTimes lmisWorkingTimes = fetchByPrimaryKey(lmisWorkingTimeId);

		if (lmisWorkingTimes == null) {
			if (_log.isWarnEnabled()) {
				_log.warn("No LmisWorkingTimes exists with the primary key " +
					lmisWorkingTimeId);
			}

			throw new NoSuchLmisWorkingTimesException(
				"No LmisWorkingTimes exists with the primary key " +
				lmisWorkingTimeId);
		}

		return lmisWorkingTimes;
	}

	public LmisWorkingTimes fetchByPrimaryKey(Integer lmisWorkingTimeId)
		throws SystemException {
		LmisWorkingTimes lmisWorkingTimes = (LmisWorkingTimes)EntityCacheUtil.getResult(LmisWorkingTimesModelImpl.ENTITY_CACHE_ENABLED,
				LmisWorkingTimesImpl.class, lmisWorkingTimeId, this);

		if (lmisWorkingTimes == null) {
			Session session = null;

			try {
				session = openSession();

				lmisWorkingTimes = (LmisWorkingTimes)session.get(LmisWorkingTimesImpl.class,
						lmisWorkingTimeId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (lmisWorkingTimes != null) {
					cacheResult(lmisWorkingTimes);
				}

				closeSession(session);
			}
		}

		return lmisWorkingTimes;
	}

	public List<LmisWorkingTimes> findByWorkingTimeOf(int rootId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		List<LmisWorkingTimes> list = (List<LmisWorkingTimes>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_WORKINGTIMEOF,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisWorkingTimes WHERE ");

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
					list = new ArrayList<LmisWorkingTimes>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_WORKINGTIMEOF,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisWorkingTimes> findByWorkingTimeOf(int rootId, int start,
		int end) throws SystemException {
		return findByWorkingTimeOf(rootId, start, end, null);
	}

	public List<LmisWorkingTimes> findByWorkingTimeOf(int rootId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(rootId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisWorkingTimes> list = (List<LmisWorkingTimes>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_WORKINGTIMEOF,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisWorkingTimes WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rootId);

				list = (List<LmisWorkingTimes>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisWorkingTimes>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_WORKINGTIMEOF,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisWorkingTimes findByWorkingTimeOf_First(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisWorkingTimesException, SystemException {
		List<LmisWorkingTimes> list = findByWorkingTimeOf(rootId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisWorkingTimes exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisWorkingTimesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisWorkingTimes findByWorkingTimeOf_Last(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisWorkingTimesException, SystemException {
		int count = countByWorkingTimeOf(rootId);

		List<LmisWorkingTimes> list = findByWorkingTimeOf(rootId, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisWorkingTimes exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisWorkingTimesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisWorkingTimes[] findByWorkingTimeOf_PrevAndNext(
		Integer lmisWorkingTimeId, int rootId, OrderByComparator obc)
		throws NoSuchLmisWorkingTimesException, SystemException {
		LmisWorkingTimes lmisWorkingTimes = findByPrimaryKey(lmisWorkingTimeId);

		int count = countByWorkingTimeOf(rootId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisWorkingTimes WHERE ");

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
					lmisWorkingTimes);

			LmisWorkingTimes[] array = new LmisWorkingTimesImpl[3];

			array[0] = (LmisWorkingTimes)objArray[0];
			array[1] = (LmisWorkingTimes)objArray[1];
			array[2] = (LmisWorkingTimes)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisWorkingTimes> findBySession(String sessionName)
		throws SystemException {
		Object[] finderArgs = new Object[] { sessionName };

		List<LmisWorkingTimes> list = (List<LmisWorkingTimes>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_SESSION,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisWorkingTimes WHERE ");

				if (sessionName == null) {
					query.append("session_name IS NULL");
				}
				else {
					query.append("session_name = ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (sessionName != null) {
					qPos.add(sessionName);
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisWorkingTimes>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_SESSION,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisWorkingTimes> findBySession(String sessionName, int start,
		int end) throws SystemException {
		return findBySession(sessionName, start, end, null);
	}

	public List<LmisWorkingTimes> findBySession(String sessionName, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				sessionName,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisWorkingTimes> list = (List<LmisWorkingTimes>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_SESSION,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisWorkingTimes WHERE ");

				if (sessionName == null) {
					query.append("session_name IS NULL");
				}
				else {
					query.append("session_name = ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (sessionName != null) {
					qPos.add(sessionName);
				}

				list = (List<LmisWorkingTimes>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisWorkingTimes>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_SESSION,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisWorkingTimes findBySession_First(String sessionName,
		OrderByComparator obc)
		throws NoSuchLmisWorkingTimesException, SystemException {
		List<LmisWorkingTimes> list = findBySession(sessionName, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisWorkingTimes exists with the key {");

			msg.append("sessionName=" + sessionName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisWorkingTimesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisWorkingTimes findBySession_Last(String sessionName,
		OrderByComparator obc)
		throws NoSuchLmisWorkingTimesException, SystemException {
		int count = countBySession(sessionName);

		List<LmisWorkingTimes> list = findBySession(sessionName, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisWorkingTimes exists with the key {");

			msg.append("sessionName=" + sessionName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisWorkingTimesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisWorkingTimes[] findBySession_PrevAndNext(
		Integer lmisWorkingTimeId, String sessionName, OrderByComparator obc)
		throws NoSuchLmisWorkingTimesException, SystemException {
		LmisWorkingTimes lmisWorkingTimes = findByPrimaryKey(lmisWorkingTimeId);

		int count = countBySession(sessionName);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisWorkingTimes WHERE ");

			if (sessionName == null) {
				query.append("session_name IS NULL");
			}
			else {
				query.append("session_name = ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (sessionName != null) {
				qPos.add(sessionName);
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisWorkingTimes);

			LmisWorkingTimes[] array = new LmisWorkingTimesImpl[3];

			array[0] = (LmisWorkingTimes)objArray[0];
			array[1] = (LmisWorkingTimes)objArray[1];
			array[2] = (LmisWorkingTimes)objArray[2];

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

	public List<LmisWorkingTimes> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<LmisWorkingTimes> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<LmisWorkingTimes> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisWorkingTimes> list = (List<LmisWorkingTimes>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.lmis.model.LmisWorkingTimes ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<LmisWorkingTimes>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LmisWorkingTimes>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisWorkingTimes>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByWorkingTimeOf(int rootId) throws SystemException {
		for (LmisWorkingTimes lmisWorkingTimes : findByWorkingTimeOf(rootId)) {
			remove(lmisWorkingTimes);
		}
	}

	public void removeBySession(String sessionName) throws SystemException {
		for (LmisWorkingTimes lmisWorkingTimes : findBySession(sessionName)) {
			remove(lmisWorkingTimes);
		}
	}

	public void removeAll() throws SystemException {
		for (LmisWorkingTimes lmisWorkingTimes : findAll()) {
			remove(lmisWorkingTimes);
		}
	}

	public int countByWorkingTimeOf(int rootId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_WORKINGTIMEOF,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisWorkingTimes WHERE ");

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_WORKINGTIMEOF,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countBySession(String sessionName) throws SystemException {
		Object[] finderArgs = new Object[] { sessionName };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_SESSION,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisWorkingTimes WHERE ");

				if (sessionName == null) {
					query.append("session_name IS NULL");
				}
				else {
					query.append("session_name = ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (sessionName != null) {
					qPos.add(sessionName);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SESSION,
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
						"SELECT COUNT(*) FROM larion.progate.lmis.model.LmisWorkingTimes");

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

	public List<larion.progate.lmis.model.LmisWorkingCalendarSessions> getLmisWorkingCalendarSessionses(
		Integer pk) throws SystemException {
		return getLmisWorkingCalendarSessionses(pk, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS);
	}

	public List<larion.progate.lmis.model.LmisWorkingCalendarSessions> getLmisWorkingCalendarSessionses(
		Integer pk, int start, int end) throws SystemException {
		return getLmisWorkingCalendarSessionses(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_LMISWORKINGCALENDARSESSIONSES =
		new FinderPath(larion.progate.lmis.model.impl.LmisWorkingCalendarSessionsModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.lmis.model.impl.LmisWorkingCalendarSessionsModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.lmis.service.persistence.LmisWorkingCalendarSessionsPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getLmisWorkingCalendarSessionses",
			new String[] {
				Integer.class.getName(), "java.lang.Integer",
				"java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	public List<larion.progate.lmis.model.LmisWorkingCalendarSessions> getLmisWorkingCalendarSessionses(
		Integer pk, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				pk, String.valueOf(start), String.valueOf(end),
				String.valueOf(obc)
			};

		List<larion.progate.lmis.model.LmisWorkingCalendarSessions> list = (List<larion.progate.lmis.model.LmisWorkingCalendarSessions>)FinderCacheUtil.getResult(FINDER_PATH_GET_LMISWORKINGCALENDARSESSIONSES,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder sb = new StringBuilder();

				sb.append(_SQL_GETLMISWORKINGCALENDARSESSIONSES);

				if (obc != null) {
					sb.append("ORDER BY ");
					sb.append(obc.getOrderBy());
				}

				String sql = sb.toString();

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("lmis_working_calendar_sessions",
					larion.progate.lmis.model.impl.LmisWorkingCalendarSessionsImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<larion.progate.lmis.model.LmisWorkingCalendarSessions>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<larion.progate.lmis.model.LmisWorkingCalendarSessions>();
				}

				lmisWorkingCalendarSessionsPersistence.cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_GET_LMISWORKINGCALENDARSESSIONSES,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_LMISWORKINGCALENDARSESSIONSES_SIZE =
		new FinderPath(larion.progate.lmis.model.impl.LmisWorkingCalendarSessionsModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.lmis.model.impl.LmisWorkingCalendarSessionsModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.lmis.service.persistence.LmisWorkingCalendarSessionsPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getLmisWorkingCalendarSessionsesSize",
			new String[] { Integer.class.getName() });

	public int getLmisWorkingCalendarSessionsesSize(Integer pk)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_LMISWORKINGCALENDARSESSIONSES_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETLMISWORKINGCALENDARSESSIONSESSIZE);

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

				FinderCacheUtil.putResult(FINDER_PATH_GET_LMISWORKINGCALENDARSESSIONSES_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_LMISWORKINGCALENDARSESSIONS =
		new FinderPath(larion.progate.lmis.model.impl.LmisWorkingCalendarSessionsModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.lmis.model.impl.LmisWorkingCalendarSessionsModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.lmis.service.persistence.LmisWorkingCalendarSessionsPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"containsLmisWorkingCalendarSessions",
			new String[] { Integer.class.getName(), Integer.class.getName() });

	public boolean containsLmisWorkingCalendarSessions(Integer pk,
		Integer lmisWorkingCalendarSessionsPK) throws SystemException {
		Object[] finderArgs = new Object[] { pk, lmisWorkingCalendarSessionsPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_LMISWORKINGCALENDARSESSIONS,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsLmisWorkingCalendarSessions.contains(
							pk, lmisWorkingCalendarSessionsPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_LMISWORKINGCALENDARSESSIONS,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	public boolean containsLmisWorkingCalendarSessionses(Integer pk)
		throws SystemException {
		if (getLmisWorkingCalendarSessionsesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public List<larion.progate.lmis.model.LmisDataImports> getLmisDataImportses(
		Integer pk) throws SystemException {
		return getLmisDataImportses(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public List<larion.progate.lmis.model.LmisDataImports> getLmisDataImportses(
		Integer pk, int start, int end) throws SystemException {
		return getLmisDataImportses(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_LMISDATAIMPORTSES = new FinderPath(larion.progate.lmis.model.impl.LmisDataImportsModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.lmis.model.impl.LmisDataImportsModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.lmis.service.persistence.LmisDataImportsPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getLmisDataImportses",
			new String[] {
				Integer.class.getName(), "java.lang.Integer",
				"java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	public List<larion.progate.lmis.model.LmisDataImports> getLmisDataImportses(
		Integer pk, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				pk, String.valueOf(start), String.valueOf(end),
				String.valueOf(obc)
			};

		List<larion.progate.lmis.model.LmisDataImports> list = (List<larion.progate.lmis.model.LmisDataImports>)FinderCacheUtil.getResult(FINDER_PATH_GET_LMISDATAIMPORTSES,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder sb = new StringBuilder();

				sb.append(_SQL_GETLMISDATAIMPORTSES);

				if (obc != null) {
					sb.append("ORDER BY ");
					sb.append(obc.getOrderBy());
				}

				String sql = sb.toString();

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("lmis_data_imports",
					larion.progate.lmis.model.impl.LmisDataImportsImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<larion.progate.lmis.model.LmisDataImports>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<larion.progate.lmis.model.LmisDataImports>();
				}

				lmisDataImportsPersistence.cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_GET_LMISDATAIMPORTSES,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_LMISDATAIMPORTSES_SIZE = new FinderPath(larion.progate.lmis.model.impl.LmisDataImportsModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.lmis.model.impl.LmisDataImportsModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.lmis.service.persistence.LmisDataImportsPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getLmisDataImportsesSize", new String[] { Integer.class.getName() });

	public int getLmisDataImportsesSize(Integer pk) throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_LMISDATAIMPORTSES_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETLMISDATAIMPORTSESSIZE);

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

				FinderCacheUtil.putResult(FINDER_PATH_GET_LMISDATAIMPORTSES_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_LMISDATAIMPORTS = new FinderPath(larion.progate.lmis.model.impl.LmisDataImportsModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.lmis.model.impl.LmisDataImportsModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.lmis.service.persistence.LmisDataImportsPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"containsLmisDataImports",
			new String[] { Integer.class.getName(), Integer.class.getName() });

	public boolean containsLmisDataImports(Integer pk, Integer lmisDataImportsPK)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk, lmisDataImportsPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_LMISDATAIMPORTS,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsLmisDataImports.contains(pk,
							lmisDataImportsPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_LMISDATAIMPORTS,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	public boolean containsLmisDataImportses(Integer pk)
		throws SystemException {
		if (getLmisDataImportsesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.larion.progate.lmis.model.LmisWorkingTimes")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LmisWorkingTimes>> listenersList = new ArrayList<ModelListener<LmisWorkingTimes>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LmisWorkingTimes>)Class.forName(
							listenerClassName).newInstance());
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		containsLmisWorkingCalendarSessions = new ContainsLmisWorkingCalendarSessions(this);

		containsLmisDataImports = new ContainsLmisDataImports(this);
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
	protected ContainsLmisWorkingCalendarSessions containsLmisWorkingCalendarSessions;
	protected ContainsLmisDataImports containsLmisDataImports;

	protected class ContainsLmisWorkingCalendarSessions {
		protected ContainsLmisWorkingCalendarSessions(
			LmisWorkingTimesPersistenceImpl persistenceImpl) {
			super();

			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSLMISWORKINGCALENDARSESSIONS,
					new int[] { Types.INTEGER, Types.INTEGER }, RowMapper.COUNT);
		}

		protected boolean contains(Integer lmisWorkingTimeId,
			Integer lmisWorkingCalendarSessionID) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						lmisWorkingTimeId, lmisWorkingCalendarSessionID
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

	protected class ContainsLmisDataImports {
		protected ContainsLmisDataImports(
			LmisWorkingTimesPersistenceImpl persistenceImpl) {
			super();

			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSLMISDATAIMPORTS,
					new int[] { Types.INTEGER, Types.INTEGER }, RowMapper.COUNT);
		}

		protected boolean contains(Integer lmisWorkingTimeId,
			Integer lmisDataImportsId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						lmisWorkingTimeId, lmisDataImportsId
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

	private static final String _SQL_GETLMISWORKINGCALENDARSESSIONSES = "SELECT {lmis_working_calendar_sessions.*} FROM lmis_working_calendar_sessions INNER JOIN lmis_workingtime_settings ON (lmis_workingtime_settings.lmisWorkingTimeId = lmis_working_calendar_sessions.lmisWorkingTimeId) WHERE (lmis_workingtime_settings.lmisWorkingTimeId = ?)";
	private static final String _SQL_GETLMISWORKINGCALENDARSESSIONSESSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM lmis_working_calendar_sessions WHERE lmisWorkingTimeId = ?";
	private static final String _SQL_CONTAINSLMISWORKINGCALENDARSESSIONS = "SELECT COUNT(*) AS COUNT_VALUE FROM lmis_working_calendar_sessions WHERE lmisWorkingTimeId = ? AND lmisWorkingCalendarSessionID = ?";
	private static final String _SQL_GETLMISDATAIMPORTSES = "SELECT {lmis_data_imports.*} FROM lmis_data_imports INNER JOIN lmis_workingtime_settings ON (lmis_workingtime_settings.lmisWorkingTimeId = lmis_data_imports.lmisWorkingTimeId) WHERE (lmis_workingtime_settings.lmisWorkingTimeId = ?)";
	private static final String _SQL_GETLMISDATAIMPORTSESSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM lmis_data_imports WHERE lmisWorkingTimeId = ?";
	private static final String _SQL_CONTAINSLMISDATAIMPORTS = "SELECT COUNT(*) AS COUNT_VALUE FROM lmis_data_imports WHERE lmisWorkingTimeId = ? AND lmisDataImportsId = ?";
	private static Log _log = LogFactoryUtil.getLog(LmisWorkingTimesPersistenceImpl.class);
}