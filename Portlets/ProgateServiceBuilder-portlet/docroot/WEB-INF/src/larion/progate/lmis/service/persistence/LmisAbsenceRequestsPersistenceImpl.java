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
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import larion.progate.lmis.NoSuchLmisAbsenceRequestsException;
import larion.progate.lmis.model.LmisAbsenceRequests;
import larion.progate.lmis.model.impl.LmisAbsenceRequestsImpl;
import larion.progate.lmis.model.impl.LmisAbsenceRequestsModelImpl;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * <a href="LmisAbsenceRequestsPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisAbsenceRequestsPersistenceImpl extends BasePersistenceImpl
	implements LmisAbsenceRequestsPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = LmisAbsenceRequestsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_ROOTID = new FinderPath(LmisAbsenceRequestsModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceRequestsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ROOTID = new FinderPath(LmisAbsenceRequestsModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceRequestsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ROOTID = new FinderPath(LmisAbsenceRequestsModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceRequestsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByRootID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_REQUESTEDBY = new FinderPath(LmisAbsenceRequestsModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceRequestsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRequestedBy",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_REQUESTEDBY = new FinderPath(LmisAbsenceRequestsModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceRequestsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRequestedBy",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_REQUESTEDBY = new FinderPath(LmisAbsenceRequestsModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceRequestsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByRequestedBy",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ABSENCETYPEID = new FinderPath(LmisAbsenceRequestsModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceRequestsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByAbsenceTypeId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ABSENCETYPEID = new FinderPath(LmisAbsenceRequestsModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceRequestsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByAbsenceTypeId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ABSENCETYPEID = new FinderPath(LmisAbsenceRequestsModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceRequestsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByAbsenceTypeId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ABSENCETYPE = new FinderPath(LmisAbsenceRequestsModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceRequestsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByAbsenceType",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ABSENCETYPE = new FinderPath(LmisAbsenceRequestsModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceRequestsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByAbsenceType",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ABSENCETYPE = new FinderPath(LmisAbsenceRequestsModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceRequestsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByAbsenceType",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_REQUESTEDSTATUS = new FinderPath(LmisAbsenceRequestsModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceRequestsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRequestedStatus",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_REQUESTEDSTATUS = new FinderPath(LmisAbsenceRequestsModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceRequestsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRequestedStatus",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_REQUESTEDSTATUS = new FinderPath(LmisAbsenceRequestsModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceRequestsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByRequestedStatus",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_DAYGREATER = new FinderPath(LmisAbsenceRequestsModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceRequestsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByDayGreater",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_DAYGREATER = new FinderPath(LmisAbsenceRequestsModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceRequestsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByDayGreater",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_DAYGREATER = new FinderPath(LmisAbsenceRequestsModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceRequestsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByDayGreater",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_DAYSMALLER = new FinderPath(LmisAbsenceRequestsModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceRequestsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByDaySmaller",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_DAYSMALLER = new FinderPath(LmisAbsenceRequestsModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceRequestsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByDaySmaller",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_DAYSMALLER = new FinderPath(LmisAbsenceRequestsModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceRequestsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByDaySmaller",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(LmisAbsenceRequestsModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceRequestsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LmisAbsenceRequestsModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceRequestsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(LmisAbsenceRequests lmisAbsenceRequests) {
		EntityCacheUtil.putResult(LmisAbsenceRequestsModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceRequestsImpl.class, lmisAbsenceRequests.getPrimaryKey(),
			lmisAbsenceRequests);
	}

	public void cacheResult(List<LmisAbsenceRequests> lmisAbsenceRequestses) {
		for (LmisAbsenceRequests lmisAbsenceRequests : lmisAbsenceRequestses) {
			if (EntityCacheUtil.getResult(
						LmisAbsenceRequestsModelImpl.ENTITY_CACHE_ENABLED,
						LmisAbsenceRequestsImpl.class,
						lmisAbsenceRequests.getPrimaryKey(), this) == null) {
				cacheResult(lmisAbsenceRequests);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(LmisAbsenceRequestsImpl.class.getName());
		EntityCacheUtil.clearCache(LmisAbsenceRequestsImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public LmisAbsenceRequests create(Integer lmisAbsenceRequestsId) {
		LmisAbsenceRequests lmisAbsenceRequests = new LmisAbsenceRequestsImpl();

		lmisAbsenceRequests.setNew(true);
		lmisAbsenceRequests.setPrimaryKey(lmisAbsenceRequestsId);

		return lmisAbsenceRequests;
	}

	public LmisAbsenceRequests remove(Integer lmisAbsenceRequestsId)
		throws NoSuchLmisAbsenceRequestsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LmisAbsenceRequests lmisAbsenceRequests = (LmisAbsenceRequests)session.get(LmisAbsenceRequestsImpl.class,
					lmisAbsenceRequestsId);

			if (lmisAbsenceRequests == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No LmisAbsenceRequests exists with the primary key " +
						lmisAbsenceRequestsId);
				}

				throw new NoSuchLmisAbsenceRequestsException(
					"No LmisAbsenceRequests exists with the primary key " +
					lmisAbsenceRequestsId);
			}

			return remove(lmisAbsenceRequests);
		}
		catch (NoSuchLmisAbsenceRequestsException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public LmisAbsenceRequests remove(LmisAbsenceRequests lmisAbsenceRequests)
		throws SystemException {
		for (ModelListener<LmisAbsenceRequests> listener : listeners) {
			listener.onBeforeRemove(lmisAbsenceRequests);
		}

		lmisAbsenceRequests = removeImpl(lmisAbsenceRequests);

		for (ModelListener<LmisAbsenceRequests> listener : listeners) {
			listener.onAfterRemove(lmisAbsenceRequests);
		}

		return lmisAbsenceRequests;
	}

	protected LmisAbsenceRequests removeImpl(
		LmisAbsenceRequests lmisAbsenceRequests) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (lmisAbsenceRequests.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(LmisAbsenceRequestsImpl.class,
						lmisAbsenceRequests.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(lmisAbsenceRequests);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(LmisAbsenceRequestsModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceRequestsImpl.class, lmisAbsenceRequests.getPrimaryKey());

		return lmisAbsenceRequests;
	}

	public LmisAbsenceRequests update(LmisAbsenceRequests lmisAbsenceRequests)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(LmisAbsenceRequests lmisAbsenceRequests) method. Use update(LmisAbsenceRequests lmisAbsenceRequests, boolean merge) instead.");
		}

		return update(lmisAbsenceRequests, false);
	}

	public LmisAbsenceRequests update(LmisAbsenceRequests lmisAbsenceRequests,
		boolean merge) throws SystemException {
		boolean isNew = lmisAbsenceRequests.isNew();

		for (ModelListener<LmisAbsenceRequests> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(lmisAbsenceRequests);
			}
			else {
				listener.onBeforeUpdate(lmisAbsenceRequests);
			}
		}

		lmisAbsenceRequests = updateImpl(lmisAbsenceRequests, merge);

		for (ModelListener<LmisAbsenceRequests> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(lmisAbsenceRequests);
			}
			else {
				listener.onAfterUpdate(lmisAbsenceRequests);
			}
		}

		return lmisAbsenceRequests;
	}

	public LmisAbsenceRequests updateImpl(
		larion.progate.lmis.model.LmisAbsenceRequests lmisAbsenceRequests,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, lmisAbsenceRequests, merge);

			lmisAbsenceRequests.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(LmisAbsenceRequestsModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceRequestsImpl.class, lmisAbsenceRequests.getPrimaryKey(),
			lmisAbsenceRequests);

		return lmisAbsenceRequests;
	}

	public LmisAbsenceRequests findByPrimaryKey(Integer lmisAbsenceRequestsId)
		throws NoSuchLmisAbsenceRequestsException, SystemException {
		LmisAbsenceRequests lmisAbsenceRequests = fetchByPrimaryKey(lmisAbsenceRequestsId);

		if (lmisAbsenceRequests == null) {
			if (_log.isWarnEnabled()) {
				_log.warn("No LmisAbsenceRequests exists with the primary key " +
					lmisAbsenceRequestsId);
			}

			throw new NoSuchLmisAbsenceRequestsException(
				"No LmisAbsenceRequests exists with the primary key " +
				lmisAbsenceRequestsId);
		}

		return lmisAbsenceRequests;
	}

	public LmisAbsenceRequests fetchByPrimaryKey(Integer lmisAbsenceRequestsId)
		throws SystemException {
		LmisAbsenceRequests lmisAbsenceRequests = (LmisAbsenceRequests)EntityCacheUtil.getResult(LmisAbsenceRequestsModelImpl.ENTITY_CACHE_ENABLED,
				LmisAbsenceRequestsImpl.class, lmisAbsenceRequestsId, this);

		if (lmisAbsenceRequests == null) {
			Session session = null;

			try {
				session = openSession();

				lmisAbsenceRequests = (LmisAbsenceRequests)session.get(LmisAbsenceRequestsImpl.class,
						lmisAbsenceRequestsId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (lmisAbsenceRequests != null) {
					cacheResult(lmisAbsenceRequests);
				}

				closeSession(session);
			}
		}

		return lmisAbsenceRequests;
	}

	public List<LmisAbsenceRequests> findByRootID(int rootId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		List<LmisAbsenceRequests> list = (List<LmisAbsenceRequests>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceRequests WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("requested_status ASC, ");
				query.append("created_at DESC");

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
					list = new ArrayList<LmisAbsenceRequests>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisAbsenceRequests> findByRootID(int rootId, int start, int end)
		throws SystemException {
		return findByRootID(rootId, start, end, null);
	}

	public List<LmisAbsenceRequests> findByRootID(int rootId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(rootId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisAbsenceRequests> list = (List<LmisAbsenceRequests>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceRequests WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("requested_status ASC, ");
					query.append("created_at DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rootId);

				list = (List<LmisAbsenceRequests>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisAbsenceRequests>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisAbsenceRequests findByRootID_First(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisAbsenceRequestsException, SystemException {
		List<LmisAbsenceRequests> list = findByRootID(rootId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAbsenceRequests exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAbsenceRequestsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAbsenceRequests findByRootID_Last(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisAbsenceRequestsException, SystemException {
		int count = countByRootID(rootId);

		List<LmisAbsenceRequests> list = findByRootID(rootId, count - 1, count,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAbsenceRequests exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAbsenceRequestsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAbsenceRequests[] findByRootID_PrevAndNext(
		Integer lmisAbsenceRequestsId, int rootId, OrderByComparator obc)
		throws NoSuchLmisAbsenceRequestsException, SystemException {
		LmisAbsenceRequests lmisAbsenceRequests = findByPrimaryKey(lmisAbsenceRequestsId);

		int count = countByRootID(rootId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisAbsenceRequests WHERE ");

			query.append("root_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("requested_status ASC, ");
				query.append("created_at DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(rootId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisAbsenceRequests);

			LmisAbsenceRequests[] array = new LmisAbsenceRequestsImpl[3];

			array[0] = (LmisAbsenceRequests)objArray[0];
			array[1] = (LmisAbsenceRequests)objArray[1];
			array[2] = (LmisAbsenceRequests)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisAbsenceRequests> findByRequestedBy(int requestedBy)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(requestedBy) };

		List<LmisAbsenceRequests> list = (List<LmisAbsenceRequests>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_REQUESTEDBY,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceRequests WHERE ");

				query.append("requested_by = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("requested_status ASC, ");
				query.append("created_at DESC");

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
					list = new ArrayList<LmisAbsenceRequests>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_REQUESTEDBY,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisAbsenceRequests> findByRequestedBy(int requestedBy,
		int start, int end) throws SystemException {
		return findByRequestedBy(requestedBy, start, end, null);
	}

	public List<LmisAbsenceRequests> findByRequestedBy(int requestedBy,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(requestedBy),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisAbsenceRequests> list = (List<LmisAbsenceRequests>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_REQUESTEDBY,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceRequests WHERE ");

				query.append("requested_by = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("requested_status ASC, ");
					query.append("created_at DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(requestedBy);

				list = (List<LmisAbsenceRequests>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisAbsenceRequests>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_REQUESTEDBY,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisAbsenceRequests findByRequestedBy_First(int requestedBy,
		OrderByComparator obc)
		throws NoSuchLmisAbsenceRequestsException, SystemException {
		List<LmisAbsenceRequests> list = findByRequestedBy(requestedBy, 0, 1,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAbsenceRequests exists with the key {");

			msg.append("requestedBy=" + requestedBy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAbsenceRequestsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAbsenceRequests findByRequestedBy_Last(int requestedBy,
		OrderByComparator obc)
		throws NoSuchLmisAbsenceRequestsException, SystemException {
		int count = countByRequestedBy(requestedBy);

		List<LmisAbsenceRequests> list = findByRequestedBy(requestedBy,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAbsenceRequests exists with the key {");

			msg.append("requestedBy=" + requestedBy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAbsenceRequestsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAbsenceRequests[] findByRequestedBy_PrevAndNext(
		Integer lmisAbsenceRequestsId, int requestedBy, OrderByComparator obc)
		throws NoSuchLmisAbsenceRequestsException, SystemException {
		LmisAbsenceRequests lmisAbsenceRequests = findByPrimaryKey(lmisAbsenceRequestsId);

		int count = countByRequestedBy(requestedBy);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisAbsenceRequests WHERE ");

			query.append("requested_by = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("requested_status ASC, ");
				query.append("created_at DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(requestedBy);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisAbsenceRequests);

			LmisAbsenceRequests[] array = new LmisAbsenceRequestsImpl[3];

			array[0] = (LmisAbsenceRequests)objArray[0];
			array[1] = (LmisAbsenceRequests)objArray[1];
			array[2] = (LmisAbsenceRequests)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisAbsenceRequests> findByAbsenceTypeId(int absenceTypeId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(absenceTypeId) };

		List<LmisAbsenceRequests> list = (List<LmisAbsenceRequests>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ABSENCETYPEID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceRequests WHERE ");

				query.append("absence_type_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("requested_status ASC, ");
				query.append("created_at DESC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(absenceTypeId);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisAbsenceRequests>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ABSENCETYPEID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisAbsenceRequests> findByAbsenceTypeId(int absenceTypeId,
		int start, int end) throws SystemException {
		return findByAbsenceTypeId(absenceTypeId, start, end, null);
	}

	public List<LmisAbsenceRequests> findByAbsenceTypeId(int absenceTypeId,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(absenceTypeId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisAbsenceRequests> list = (List<LmisAbsenceRequests>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ABSENCETYPEID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceRequests WHERE ");

				query.append("absence_type_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("requested_status ASC, ");
					query.append("created_at DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(absenceTypeId);

				list = (List<LmisAbsenceRequests>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisAbsenceRequests>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ABSENCETYPEID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisAbsenceRequests findByAbsenceTypeId_First(int absenceTypeId,
		OrderByComparator obc)
		throws NoSuchLmisAbsenceRequestsException, SystemException {
		List<LmisAbsenceRequests> list = findByAbsenceTypeId(absenceTypeId, 0,
				1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAbsenceRequests exists with the key {");

			msg.append("absenceTypeId=" + absenceTypeId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAbsenceRequestsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAbsenceRequests findByAbsenceTypeId_Last(int absenceTypeId,
		OrderByComparator obc)
		throws NoSuchLmisAbsenceRequestsException, SystemException {
		int count = countByAbsenceTypeId(absenceTypeId);

		List<LmisAbsenceRequests> list = findByAbsenceTypeId(absenceTypeId,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAbsenceRequests exists with the key {");

			msg.append("absenceTypeId=" + absenceTypeId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAbsenceRequestsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAbsenceRequests[] findByAbsenceTypeId_PrevAndNext(
		Integer lmisAbsenceRequestsId, int absenceTypeId, OrderByComparator obc)
		throws NoSuchLmisAbsenceRequestsException, SystemException {
		LmisAbsenceRequests lmisAbsenceRequests = findByPrimaryKey(lmisAbsenceRequestsId);

		int count = countByAbsenceTypeId(absenceTypeId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisAbsenceRequests WHERE ");

			query.append("absence_type_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("requested_status ASC, ");
				query.append("created_at DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(absenceTypeId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisAbsenceRequests);

			LmisAbsenceRequests[] array = new LmisAbsenceRequestsImpl[3];

			array[0] = (LmisAbsenceRequests)objArray[0];
			array[1] = (LmisAbsenceRequests)objArray[1];
			array[2] = (LmisAbsenceRequests)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisAbsenceRequests> findByAbsenceType(String absenceType)
		throws SystemException {
		Object[] finderArgs = new Object[] { absenceType };

		List<LmisAbsenceRequests> list = (List<LmisAbsenceRequests>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ABSENCETYPE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceRequests WHERE ");

				if (absenceType == null) {
					query.append("absence_type IS NULL");
				}
				else {
					query.append("absence_type = ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("requested_status ASC, ");
				query.append("created_at DESC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (absenceType != null) {
					qPos.add(absenceType);
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisAbsenceRequests>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ABSENCETYPE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisAbsenceRequests> findByAbsenceType(String absenceType,
		int start, int end) throws SystemException {
		return findByAbsenceType(absenceType, start, end, null);
	}

	public List<LmisAbsenceRequests> findByAbsenceType(String absenceType,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				absenceType,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisAbsenceRequests> list = (List<LmisAbsenceRequests>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ABSENCETYPE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceRequests WHERE ");

				if (absenceType == null) {
					query.append("absence_type IS NULL");
				}
				else {
					query.append("absence_type = ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("requested_status ASC, ");
					query.append("created_at DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (absenceType != null) {
					qPos.add(absenceType);
				}

				list = (List<LmisAbsenceRequests>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisAbsenceRequests>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ABSENCETYPE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisAbsenceRequests findByAbsenceType_First(String absenceType,
		OrderByComparator obc)
		throws NoSuchLmisAbsenceRequestsException, SystemException {
		List<LmisAbsenceRequests> list = findByAbsenceType(absenceType, 0, 1,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAbsenceRequests exists with the key {");

			msg.append("absenceType=" + absenceType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAbsenceRequestsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAbsenceRequests findByAbsenceType_Last(String absenceType,
		OrderByComparator obc)
		throws NoSuchLmisAbsenceRequestsException, SystemException {
		int count = countByAbsenceType(absenceType);

		List<LmisAbsenceRequests> list = findByAbsenceType(absenceType,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAbsenceRequests exists with the key {");

			msg.append("absenceType=" + absenceType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAbsenceRequestsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAbsenceRequests[] findByAbsenceType_PrevAndNext(
		Integer lmisAbsenceRequestsId, String absenceType, OrderByComparator obc)
		throws NoSuchLmisAbsenceRequestsException, SystemException {
		LmisAbsenceRequests lmisAbsenceRequests = findByPrimaryKey(lmisAbsenceRequestsId);

		int count = countByAbsenceType(absenceType);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisAbsenceRequests WHERE ");

			if (absenceType == null) {
				query.append("absence_type IS NULL");
			}
			else {
				query.append("absence_type = ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("requested_status ASC, ");
				query.append("created_at DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (absenceType != null) {
				qPos.add(absenceType);
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisAbsenceRequests);

			LmisAbsenceRequests[] array = new LmisAbsenceRequestsImpl[3];

			array[0] = (LmisAbsenceRequests)objArray[0];
			array[1] = (LmisAbsenceRequests)objArray[1];
			array[2] = (LmisAbsenceRequests)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisAbsenceRequests> findByRequestedStatus(int requestedStatus)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(requestedStatus) };

		List<LmisAbsenceRequests> list = (List<LmisAbsenceRequests>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_REQUESTEDSTATUS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceRequests WHERE ");

				query.append("requested_status = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("requested_status ASC, ");
				query.append("created_at DESC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(requestedStatus);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisAbsenceRequests>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_REQUESTEDSTATUS,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisAbsenceRequests> findByRequestedStatus(
		int requestedStatus, int start, int end) throws SystemException {
		return findByRequestedStatus(requestedStatus, start, end, null);
	}

	public List<LmisAbsenceRequests> findByRequestedStatus(
		int requestedStatus, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(requestedStatus),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisAbsenceRequests> list = (List<LmisAbsenceRequests>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_REQUESTEDSTATUS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceRequests WHERE ");

				query.append("requested_status = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("requested_status ASC, ");
					query.append("created_at DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(requestedStatus);

				list = (List<LmisAbsenceRequests>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisAbsenceRequests>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_REQUESTEDSTATUS,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisAbsenceRequests findByRequestedStatus_First(
		int requestedStatus, OrderByComparator obc)
		throws NoSuchLmisAbsenceRequestsException, SystemException {
		List<LmisAbsenceRequests> list = findByRequestedStatus(requestedStatus,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAbsenceRequests exists with the key {");

			msg.append("requestedStatus=" + requestedStatus);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAbsenceRequestsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAbsenceRequests findByRequestedStatus_Last(int requestedStatus,
		OrderByComparator obc)
		throws NoSuchLmisAbsenceRequestsException, SystemException {
		int count = countByRequestedStatus(requestedStatus);

		List<LmisAbsenceRequests> list = findByRequestedStatus(requestedStatus,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAbsenceRequests exists with the key {");

			msg.append("requestedStatus=" + requestedStatus);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAbsenceRequestsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAbsenceRequests[] findByRequestedStatus_PrevAndNext(
		Integer lmisAbsenceRequestsId, int requestedStatus,
		OrderByComparator obc)
		throws NoSuchLmisAbsenceRequestsException, SystemException {
		LmisAbsenceRequests lmisAbsenceRequests = findByPrimaryKey(lmisAbsenceRequestsId);

		int count = countByRequestedStatus(requestedStatus);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisAbsenceRequests WHERE ");

			query.append("requested_status = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("requested_status ASC, ");
				query.append("created_at DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(requestedStatus);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisAbsenceRequests);

			LmisAbsenceRequests[] array = new LmisAbsenceRequestsImpl[3];

			array[0] = (LmisAbsenceRequests)objArray[0];
			array[1] = (LmisAbsenceRequests)objArray[1];
			array[2] = (LmisAbsenceRequests)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisAbsenceRequests> findByDayGreater(Date startDate)
		throws SystemException {
		Object[] finderArgs = new Object[] { startDate };

		List<LmisAbsenceRequests> list = (List<LmisAbsenceRequests>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DAYGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceRequests WHERE ");

				if (startDate == null) {
					query.append("start_date >= null");
				}
				else {
					query.append("start_date >= ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("requested_status ASC, ");
				query.append("created_at DESC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (startDate != null) {
					qPos.add(CalendarUtil.getTimestamp(startDate));
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisAbsenceRequests>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DAYGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisAbsenceRequests> findByDayGreater(Date startDate,
		int start, int end) throws SystemException {
		return findByDayGreater(startDate, start, end, null);
	}

	public List<LmisAbsenceRequests> findByDayGreater(Date startDate,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				startDate,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisAbsenceRequests> list = (List<LmisAbsenceRequests>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_DAYGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceRequests WHERE ");

				if (startDate == null) {
					query.append("start_date >= null");
				}
				else {
					query.append("start_date >= ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("requested_status ASC, ");
					query.append("created_at DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (startDate != null) {
					qPos.add(CalendarUtil.getTimestamp(startDate));
				}

				list = (List<LmisAbsenceRequests>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisAbsenceRequests>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_DAYGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisAbsenceRequests findByDayGreater_First(Date startDate,
		OrderByComparator obc)
		throws NoSuchLmisAbsenceRequestsException, SystemException {
		List<LmisAbsenceRequests> list = findByDayGreater(startDate, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAbsenceRequests exists with the key {");

			msg.append("startDate=" + startDate);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAbsenceRequestsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAbsenceRequests findByDayGreater_Last(Date startDate,
		OrderByComparator obc)
		throws NoSuchLmisAbsenceRequestsException, SystemException {
		int count = countByDayGreater(startDate);

		List<LmisAbsenceRequests> list = findByDayGreater(startDate, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAbsenceRequests exists with the key {");

			msg.append("startDate=" + startDate);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAbsenceRequestsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAbsenceRequests[] findByDayGreater_PrevAndNext(
		Integer lmisAbsenceRequestsId, Date startDate, OrderByComparator obc)
		throws NoSuchLmisAbsenceRequestsException, SystemException {
		LmisAbsenceRequests lmisAbsenceRequests = findByPrimaryKey(lmisAbsenceRequestsId);

		int count = countByDayGreater(startDate);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisAbsenceRequests WHERE ");

			if (startDate == null) {
				query.append("start_date >= null");
			}
			else {
				query.append("start_date >= ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("requested_status ASC, ");
				query.append("created_at DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (startDate != null) {
				qPos.add(CalendarUtil.getTimestamp(startDate));
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisAbsenceRequests);

			LmisAbsenceRequests[] array = new LmisAbsenceRequestsImpl[3];

			array[0] = (LmisAbsenceRequests)objArray[0];
			array[1] = (LmisAbsenceRequests)objArray[1];
			array[2] = (LmisAbsenceRequests)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisAbsenceRequests> findByDaySmaller(Date endDate)
		throws SystemException {
		Object[] finderArgs = new Object[] { endDate };

		List<LmisAbsenceRequests> list = (List<LmisAbsenceRequests>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DAYSMALLER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceRequests WHERE ");

				if (endDate == null) {
					query.append("end_date <= null");
				}
				else {
					query.append("end_date <= ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("requested_status ASC, ");
				query.append("created_at DESC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (endDate != null) {
					qPos.add(CalendarUtil.getTimestamp(endDate));
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisAbsenceRequests>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DAYSMALLER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisAbsenceRequests> findByDaySmaller(Date endDate, int start,
		int end) throws SystemException {
		return findByDaySmaller(endDate, start, end, null);
	}

	public List<LmisAbsenceRequests> findByDaySmaller(Date endDate, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				endDate,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisAbsenceRequests> list = (List<LmisAbsenceRequests>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_DAYSMALLER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceRequests WHERE ");

				if (endDate == null) {
					query.append("end_date <= null");
				}
				else {
					query.append("end_date <= ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("requested_status ASC, ");
					query.append("created_at DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (endDate != null) {
					qPos.add(CalendarUtil.getTimestamp(endDate));
				}

				list = (List<LmisAbsenceRequests>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisAbsenceRequests>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_DAYSMALLER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisAbsenceRequests findByDaySmaller_First(Date endDate,
		OrderByComparator obc)
		throws NoSuchLmisAbsenceRequestsException, SystemException {
		List<LmisAbsenceRequests> list = findByDaySmaller(endDate, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAbsenceRequests exists with the key {");

			msg.append("endDate=" + endDate);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAbsenceRequestsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAbsenceRequests findByDaySmaller_Last(Date endDate,
		OrderByComparator obc)
		throws NoSuchLmisAbsenceRequestsException, SystemException {
		int count = countByDaySmaller(endDate);

		List<LmisAbsenceRequests> list = findByDaySmaller(endDate, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAbsenceRequests exists with the key {");

			msg.append("endDate=" + endDate);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAbsenceRequestsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAbsenceRequests[] findByDaySmaller_PrevAndNext(
		Integer lmisAbsenceRequestsId, Date endDate, OrderByComparator obc)
		throws NoSuchLmisAbsenceRequestsException, SystemException {
		LmisAbsenceRequests lmisAbsenceRequests = findByPrimaryKey(lmisAbsenceRequestsId);

		int count = countByDaySmaller(endDate);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisAbsenceRequests WHERE ");

			if (endDate == null) {
				query.append("end_date <= null");
			}
			else {
				query.append("end_date <= ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("requested_status ASC, ");
				query.append("created_at DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (endDate != null) {
				qPos.add(CalendarUtil.getTimestamp(endDate));
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisAbsenceRequests);

			LmisAbsenceRequests[] array = new LmisAbsenceRequestsImpl[3];

			array[0] = (LmisAbsenceRequests)objArray[0];
			array[1] = (LmisAbsenceRequests)objArray[1];
			array[2] = (LmisAbsenceRequests)objArray[2];

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

	public List<LmisAbsenceRequests> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<LmisAbsenceRequests> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<LmisAbsenceRequests> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisAbsenceRequests> list = (List<LmisAbsenceRequests>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceRequests ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("requested_status ASC, ");
					query.append("created_at DESC");
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<LmisAbsenceRequests>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LmisAbsenceRequests>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisAbsenceRequests>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByRootID(int rootId) throws SystemException {
		for (LmisAbsenceRequests lmisAbsenceRequests : findByRootID(rootId)) {
			remove(lmisAbsenceRequests);
		}
	}

	public void removeByRequestedBy(int requestedBy) throws SystemException {
		for (LmisAbsenceRequests lmisAbsenceRequests : findByRequestedBy(
				requestedBy)) {
			remove(lmisAbsenceRequests);
		}
	}

	public void removeByAbsenceTypeId(int absenceTypeId)
		throws SystemException {
		for (LmisAbsenceRequests lmisAbsenceRequests : findByAbsenceTypeId(
				absenceTypeId)) {
			remove(lmisAbsenceRequests);
		}
	}

	public void removeByAbsenceType(String absenceType)
		throws SystemException {
		for (LmisAbsenceRequests lmisAbsenceRequests : findByAbsenceType(
				absenceType)) {
			remove(lmisAbsenceRequests);
		}
	}

	public void removeByRequestedStatus(int requestedStatus)
		throws SystemException {
		for (LmisAbsenceRequests lmisAbsenceRequests : findByRequestedStatus(
				requestedStatus)) {
			remove(lmisAbsenceRequests);
		}
	}

	public void removeByDayGreater(Date startDate) throws SystemException {
		for (LmisAbsenceRequests lmisAbsenceRequests : findByDayGreater(
				startDate)) {
			remove(lmisAbsenceRequests);
		}
	}

	public void removeByDaySmaller(Date endDate) throws SystemException {
		for (LmisAbsenceRequests lmisAbsenceRequests : findByDaySmaller(endDate)) {
			remove(lmisAbsenceRequests);
		}
	}

	public void removeAll() throws SystemException {
		for (LmisAbsenceRequests lmisAbsenceRequests : findAll()) {
			remove(lmisAbsenceRequests);
		}
	}

	public int countByRootID(int rootId) throws SystemException {
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
					"FROM larion.progate.lmis.model.LmisAbsenceRequests WHERE ");

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
					"FROM larion.progate.lmis.model.LmisAbsenceRequests WHERE ");

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

	public int countByAbsenceTypeId(int absenceTypeId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(absenceTypeId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ABSENCETYPEID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceRequests WHERE ");

				query.append("absence_type_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(absenceTypeId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ABSENCETYPEID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByAbsenceType(String absenceType) throws SystemException {
		Object[] finderArgs = new Object[] { absenceType };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ABSENCETYPE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceRequests WHERE ");

				if (absenceType == null) {
					query.append("absence_type IS NULL");
				}
				else {
					query.append("absence_type = ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (absenceType != null) {
					qPos.add(absenceType);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ABSENCETYPE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByRequestedStatus(int requestedStatus)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(requestedStatus) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_REQUESTEDSTATUS,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceRequests WHERE ");

				query.append("requested_status = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(requestedStatus);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_REQUESTEDSTATUS,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByDayGreater(Date startDate) throws SystemException {
		Object[] finderArgs = new Object[] { startDate };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DAYGREATER,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceRequests WHERE ");

				if (startDate == null) {
					query.append("start_date >= null");
				}
				else {
					query.append("start_date >= ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (startDate != null) {
					qPos.add(CalendarUtil.getTimestamp(startDate));
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DAYGREATER,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByDaySmaller(Date endDate) throws SystemException {
		Object[] finderArgs = new Object[] { endDate };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DAYSMALLER,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceRequests WHERE ");

				if (endDate == null) {
					query.append("end_date <= null");
				}
				else {
					query.append("end_date <= ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (endDate != null) {
					qPos.add(CalendarUtil.getTimestamp(endDate));
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DAYSMALLER,
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
						"SELECT COUNT(*) FROM larion.progate.lmis.model.LmisAbsenceRequests");

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

	public List<larion.progate.lmis.model.LmisAbsenceApprovals> getLmisAbsenceApprovalses(
		Integer pk) throws SystemException {
		return getLmisAbsenceApprovalses(pk, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS);
	}

	public List<larion.progate.lmis.model.LmisAbsenceApprovals> getLmisAbsenceApprovalses(
		Integer pk, int start, int end) throws SystemException {
		return getLmisAbsenceApprovalses(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_LMISABSENCEAPPROVALSES = new FinderPath(larion.progate.lmis.model.impl.LmisAbsenceApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.lmis.model.impl.LmisAbsenceApprovalsModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.lmis.service.persistence.LmisAbsenceApprovalsPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getLmisAbsenceApprovalses",
			new String[] {
				Integer.class.getName(), "java.lang.Integer",
				"java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	public List<larion.progate.lmis.model.LmisAbsenceApprovals> getLmisAbsenceApprovalses(
		Integer pk, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				pk, String.valueOf(start), String.valueOf(end),
				String.valueOf(obc)
			};

		List<larion.progate.lmis.model.LmisAbsenceApprovals> list = (List<larion.progate.lmis.model.LmisAbsenceApprovals>)FinderCacheUtil.getResult(FINDER_PATH_GET_LMISABSENCEAPPROVALSES,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder sb = new StringBuilder();

				sb.append(_SQL_GETLMISABSENCEAPPROVALSES);

				if (obc != null) {
					sb.append("ORDER BY ");
					sb.append(obc.getOrderBy());
				}

				else {
					sb.append("ORDER BY ");

					sb.append("lmis_absence_approvals.approved_status ASC, ");
					sb.append("lmis_absence_approvals.approved_at ASC");
				}

				String sql = sb.toString();

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("lmis_absence_approvals",
					larion.progate.lmis.model.impl.LmisAbsenceApprovalsImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<larion.progate.lmis.model.LmisAbsenceApprovals>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<larion.progate.lmis.model.LmisAbsenceApprovals>();
				}

				lmisAbsenceApprovalsPersistence.cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_GET_LMISABSENCEAPPROVALSES,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_LMISABSENCEAPPROVALSES_SIZE = new FinderPath(larion.progate.lmis.model.impl.LmisAbsenceApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.lmis.model.impl.LmisAbsenceApprovalsModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.lmis.service.persistence.LmisAbsenceApprovalsPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getLmisAbsenceApprovalsesSize",
			new String[] { Integer.class.getName() });

	public int getLmisAbsenceApprovalsesSize(Integer pk)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_LMISABSENCEAPPROVALSES_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETLMISABSENCEAPPROVALSESSIZE);

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

				FinderCacheUtil.putResult(FINDER_PATH_GET_LMISABSENCEAPPROVALSES_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_LMISABSENCEAPPROVALS = new FinderPath(larion.progate.lmis.model.impl.LmisAbsenceApprovalsModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.lmis.model.impl.LmisAbsenceApprovalsModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.lmis.service.persistence.LmisAbsenceApprovalsPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"containsLmisAbsenceApprovals",
			new String[] { Integer.class.getName(), Integer.class.getName() });

	public boolean containsLmisAbsenceApprovals(Integer pk,
		Integer lmisAbsenceApprovalsPK) throws SystemException {
		Object[] finderArgs = new Object[] { pk, lmisAbsenceApprovalsPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_LMISABSENCEAPPROVALS,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsLmisAbsenceApprovals.contains(
							pk, lmisAbsenceApprovalsPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_LMISABSENCEAPPROVALS,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	public boolean containsLmisAbsenceApprovalses(Integer pk)
		throws SystemException {
		if (getLmisAbsenceApprovalsesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.larion.progate.lmis.model.LmisAbsenceRequests")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LmisAbsenceRequests>> listenersList = new ArrayList<ModelListener<LmisAbsenceRequests>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LmisAbsenceRequests>)Class.forName(
							listenerClassName).newInstance());
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		containsLmisAbsenceApprovals = new ContainsLmisAbsenceApprovals(this);
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
	protected ContainsLmisAbsenceApprovals containsLmisAbsenceApprovals;

	protected class ContainsLmisAbsenceApprovals {
		protected ContainsLmisAbsenceApprovals(
			LmisAbsenceRequestsPersistenceImpl persistenceImpl) {
			super();

			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSLMISABSENCEAPPROVALS,
					new int[] { Types.INTEGER, Types.INTEGER }, RowMapper.COUNT);
		}

		protected boolean contains(Integer lmisAbsenceRequestsId,
			Integer lmisAbsenceApprovalsId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						lmisAbsenceRequestsId, lmisAbsenceApprovalsId
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

	private static final String _SQL_GETLMISABSENCEAPPROVALSES = "SELECT {lmis_absence_approvals.*} FROM lmis_absence_approvals INNER JOIN lmis_absence_requests ON (lmis_absence_requests.lmisAbsenceRequestsId = lmis_absence_approvals.lmisAbsenceRequestsId) WHERE (lmis_absence_requests.lmisAbsenceRequestsId = ?)";
	private static final String _SQL_GETLMISABSENCEAPPROVALSESSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM lmis_absence_approvals WHERE lmisAbsenceRequestsId = ?";
	private static final String _SQL_CONTAINSLMISABSENCEAPPROVALS = "SELECT COUNT(*) AS COUNT_VALUE FROM lmis_absence_approvals WHERE lmisAbsenceRequestsId = ? AND lmisAbsenceApprovalsId = ?";
	private static Log _log = LogFactoryUtil.getLog(LmisAbsenceRequestsPersistenceImpl.class);
}