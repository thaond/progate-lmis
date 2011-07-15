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

package larion.progate.cds.service.persistence;

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

import larion.progate.cds.NoSuchCdsPAFinalSlotsException;
import larion.progate.cds.model.CdsPAFinalSlots;
import larion.progate.cds.model.impl.CdsPAFinalSlotsImpl;
import larion.progate.cds.model.impl.CdsPAFinalSlotsModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="CdsPAFinalSlotsPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsPAFinalSlotsPersistenceImpl extends BasePersistenceImpl
	implements CdsPAFinalSlotsPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = CdsPAFinalSlotsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_ROOTID = new FinderPath(CdsPAFinalSlotsModelImpl.ENTITY_CACHE_ENABLED,
			CdsPAFinalSlotsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ROOTID = new FinderPath(CdsPAFinalSlotsModelImpl.ENTITY_CACHE_ENABLED,
			CdsPAFinalSlotsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ROOTID = new FinderPath(CdsPAFinalSlotsModelImpl.ENTITY_CACHE_ENABLED,
			CdsPAFinalSlotsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByRootId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_USERID = new FinderPath(CdsPAFinalSlotsModelImpl.ENTITY_CACHE_ENABLED,
			CdsPAFinalSlotsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByUserId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_USERID = new FinderPath(CdsPAFinalSlotsModelImpl.ENTITY_CACHE_ENABLED,
			CdsPAFinalSlotsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByUserId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(CdsPAFinalSlotsModelImpl.ENTITY_CACHE_ENABLED,
			CdsPAFinalSlotsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByUserId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(CdsPAFinalSlotsModelImpl.ENTITY_CACHE_ENABLED,
			CdsPAFinalSlotsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CdsPAFinalSlotsModelImpl.ENTITY_CACHE_ENABLED,
			CdsPAFinalSlotsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(CdsPAFinalSlots cdsPAFinalSlots) {
		EntityCacheUtil.putResult(CdsPAFinalSlotsModelImpl.ENTITY_CACHE_ENABLED,
			CdsPAFinalSlotsImpl.class, cdsPAFinalSlots.getPrimaryKey(),
			cdsPAFinalSlots);
	}

	public void cacheResult(List<CdsPAFinalSlots> cdsPAFinalSlotses) {
		for (CdsPAFinalSlots cdsPAFinalSlots : cdsPAFinalSlotses) {
			if (EntityCacheUtil.getResult(
						CdsPAFinalSlotsModelImpl.ENTITY_CACHE_ENABLED,
						CdsPAFinalSlotsImpl.class,
						cdsPAFinalSlots.getPrimaryKey(), this) == null) {
				cacheResult(cdsPAFinalSlots);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(CdsPAFinalSlotsImpl.class.getName());
		EntityCacheUtil.clearCache(CdsPAFinalSlotsImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public CdsPAFinalSlots create(Integer CdsPAFinalSlotsId) {
		CdsPAFinalSlots cdsPAFinalSlots = new CdsPAFinalSlotsImpl();

		cdsPAFinalSlots.setNew(true);
		cdsPAFinalSlots.setPrimaryKey(CdsPAFinalSlotsId);

		return cdsPAFinalSlots;
	}

	public CdsPAFinalSlots remove(Integer CdsPAFinalSlotsId)
		throws NoSuchCdsPAFinalSlotsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CdsPAFinalSlots cdsPAFinalSlots = (CdsPAFinalSlots)session.get(CdsPAFinalSlotsImpl.class,
					CdsPAFinalSlotsId);

			if (cdsPAFinalSlots == null) {
				if (_log.isWarnEnabled()) {
					_log.warn("No CdsPAFinalSlots exists with the primary key " +
						CdsPAFinalSlotsId);
				}

				throw new NoSuchCdsPAFinalSlotsException(
					"No CdsPAFinalSlots exists with the primary key " +
					CdsPAFinalSlotsId);
			}

			return remove(cdsPAFinalSlots);
		}
		catch (NoSuchCdsPAFinalSlotsException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public CdsPAFinalSlots remove(CdsPAFinalSlots cdsPAFinalSlots)
		throws SystemException {
		for (ModelListener<CdsPAFinalSlots> listener : listeners) {
			listener.onBeforeRemove(cdsPAFinalSlots);
		}

		cdsPAFinalSlots = removeImpl(cdsPAFinalSlots);

		for (ModelListener<CdsPAFinalSlots> listener : listeners) {
			listener.onAfterRemove(cdsPAFinalSlots);
		}

		return cdsPAFinalSlots;
	}

	protected CdsPAFinalSlots removeImpl(CdsPAFinalSlots cdsPAFinalSlots)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (cdsPAFinalSlots.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(CdsPAFinalSlotsImpl.class,
						cdsPAFinalSlots.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(cdsPAFinalSlots);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(CdsPAFinalSlotsModelImpl.ENTITY_CACHE_ENABLED,
			CdsPAFinalSlotsImpl.class, cdsPAFinalSlots.getPrimaryKey());

		return cdsPAFinalSlots;
	}

	public CdsPAFinalSlots update(CdsPAFinalSlots cdsPAFinalSlots)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(CdsPAFinalSlots cdsPAFinalSlots) method. Use update(CdsPAFinalSlots cdsPAFinalSlots, boolean merge) instead.");
		}

		return update(cdsPAFinalSlots, false);
	}

	public CdsPAFinalSlots update(CdsPAFinalSlots cdsPAFinalSlots, boolean merge)
		throws SystemException {
		boolean isNew = cdsPAFinalSlots.isNew();

		for (ModelListener<CdsPAFinalSlots> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(cdsPAFinalSlots);
			}
			else {
				listener.onBeforeUpdate(cdsPAFinalSlots);
			}
		}

		cdsPAFinalSlots = updateImpl(cdsPAFinalSlots, merge);

		for (ModelListener<CdsPAFinalSlots> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(cdsPAFinalSlots);
			}
			else {
				listener.onAfterUpdate(cdsPAFinalSlots);
			}
		}

		return cdsPAFinalSlots;
	}

	public CdsPAFinalSlots updateImpl(
		larion.progate.cds.model.CdsPAFinalSlots cdsPAFinalSlots, boolean merge)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, cdsPAFinalSlots, merge);

			cdsPAFinalSlots.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(CdsPAFinalSlotsModelImpl.ENTITY_CACHE_ENABLED,
			CdsPAFinalSlotsImpl.class, cdsPAFinalSlots.getPrimaryKey(),
			cdsPAFinalSlots);

		return cdsPAFinalSlots;
	}

	public CdsPAFinalSlots findByPrimaryKey(Integer CdsPAFinalSlotsId)
		throws NoSuchCdsPAFinalSlotsException, SystemException {
		CdsPAFinalSlots cdsPAFinalSlots = fetchByPrimaryKey(CdsPAFinalSlotsId);

		if (cdsPAFinalSlots == null) {
			if (_log.isWarnEnabled()) {
				_log.warn("No CdsPAFinalSlots exists with the primary key " +
					CdsPAFinalSlotsId);
			}

			throw new NoSuchCdsPAFinalSlotsException(
				"No CdsPAFinalSlots exists with the primary key " +
				CdsPAFinalSlotsId);
		}

		return cdsPAFinalSlots;
	}

	public CdsPAFinalSlots fetchByPrimaryKey(Integer CdsPAFinalSlotsId)
		throws SystemException {
		CdsPAFinalSlots cdsPAFinalSlots = (CdsPAFinalSlots)EntityCacheUtil.getResult(CdsPAFinalSlotsModelImpl.ENTITY_CACHE_ENABLED,
				CdsPAFinalSlotsImpl.class, CdsPAFinalSlotsId, this);

		if (cdsPAFinalSlots == null) {
			Session session = null;

			try {
				session = openSession();

				cdsPAFinalSlots = (CdsPAFinalSlots)session.get(CdsPAFinalSlotsImpl.class,
						CdsPAFinalSlotsId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (cdsPAFinalSlots != null) {
					cacheResult(cdsPAFinalSlots);
				}

				closeSession(session);
			}
		}

		return cdsPAFinalSlots;
	}

	public List<CdsPAFinalSlots> findByRootId(int rootId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		List<CdsPAFinalSlots> list = (List<CdsPAFinalSlots>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.CdsPAFinalSlots WHERE ");

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
					list = new ArrayList<CdsPAFinalSlots>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<CdsPAFinalSlots> findByRootId(int rootId, int start, int end)
		throws SystemException {
		return findByRootId(rootId, start, end, null);
	}

	public List<CdsPAFinalSlots> findByRootId(int rootId, int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(rootId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<CdsPAFinalSlots> list = (List<CdsPAFinalSlots>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.CdsPAFinalSlots WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rootId);

				list = (List<CdsPAFinalSlots>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsPAFinalSlots>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public CdsPAFinalSlots findByRootId_First(int rootId, OrderByComparator obc)
		throws NoSuchCdsPAFinalSlotsException, SystemException {
		List<CdsPAFinalSlots> list = findByRootId(rootId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No CdsPAFinalSlots exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsPAFinalSlotsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsPAFinalSlots findByRootId_Last(int rootId, OrderByComparator obc)
		throws NoSuchCdsPAFinalSlotsException, SystemException {
		int count = countByRootId(rootId);

		List<CdsPAFinalSlots> list = findByRootId(rootId, count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No CdsPAFinalSlots exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsPAFinalSlotsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsPAFinalSlots[] findByRootId_PrevAndNext(
		Integer CdsPAFinalSlotsId, int rootId, OrderByComparator obc)
		throws NoSuchCdsPAFinalSlotsException, SystemException {
		CdsPAFinalSlots cdsPAFinalSlots = findByPrimaryKey(CdsPAFinalSlotsId);

		int count = countByRootId(rootId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.cds.model.CdsPAFinalSlots WHERE ");

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
					cdsPAFinalSlots);

			CdsPAFinalSlots[] array = new CdsPAFinalSlotsImpl[3];

			array[0] = (CdsPAFinalSlots)objArray[0];
			array[1] = (CdsPAFinalSlots)objArray[1];
			array[2] = (CdsPAFinalSlots)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<CdsPAFinalSlots> findByUserId(int userId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(userId) };

		List<CdsPAFinalSlots> list = (List<CdsPAFinalSlots>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_USERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.CdsPAFinalSlots WHERE ");

				query.append("user_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsPAFinalSlots>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_USERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<CdsPAFinalSlots> findByUserId(int userId, int start, int end)
		throws SystemException {
		return findByUserId(userId, start, end, null);
	}

	public List<CdsPAFinalSlots> findByUserId(int userId, int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(userId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<CdsPAFinalSlots> list = (List<CdsPAFinalSlots>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_USERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.CdsPAFinalSlots WHERE ");

				query.append("user_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				list = (List<CdsPAFinalSlots>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsPAFinalSlots>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_USERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public CdsPAFinalSlots findByUserId_First(int userId, OrderByComparator obc)
		throws NoSuchCdsPAFinalSlotsException, SystemException {
		List<CdsPAFinalSlots> list = findByUserId(userId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No CdsPAFinalSlots exists with the key {");

			msg.append("userId=" + userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsPAFinalSlotsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsPAFinalSlots findByUserId_Last(int userId, OrderByComparator obc)
		throws NoSuchCdsPAFinalSlotsException, SystemException {
		int count = countByUserId(userId);

		List<CdsPAFinalSlots> list = findByUserId(userId, count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No CdsPAFinalSlots exists with the key {");

			msg.append("userId=" + userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsPAFinalSlotsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsPAFinalSlots[] findByUserId_PrevAndNext(
		Integer CdsPAFinalSlotsId, int userId, OrderByComparator obc)
		throws NoSuchCdsPAFinalSlotsException, SystemException {
		CdsPAFinalSlots cdsPAFinalSlots = findByPrimaryKey(CdsPAFinalSlotsId);

		int count = countByUserId(userId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.cds.model.CdsPAFinalSlots WHERE ");

			query.append("user_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(userId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					cdsPAFinalSlots);

			CdsPAFinalSlots[] array = new CdsPAFinalSlotsImpl[3];

			array[0] = (CdsPAFinalSlots)objArray[0];
			array[1] = (CdsPAFinalSlots)objArray[1];
			array[2] = (CdsPAFinalSlots)objArray[2];

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

	public List<CdsPAFinalSlots> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<CdsPAFinalSlots> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<CdsPAFinalSlots> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<CdsPAFinalSlots> list = (List<CdsPAFinalSlots>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.cds.model.CdsPAFinalSlots ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<CdsPAFinalSlots>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<CdsPAFinalSlots>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsPAFinalSlots>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByRootId(int rootId) throws SystemException {
		for (CdsPAFinalSlots cdsPAFinalSlots : findByRootId(rootId)) {
			remove(cdsPAFinalSlots);
		}
	}

	public void removeByUserId(int userId) throws SystemException {
		for (CdsPAFinalSlots cdsPAFinalSlots : findByUserId(userId)) {
			remove(cdsPAFinalSlots);
		}
	}

	public void removeAll() throws SystemException {
		for (CdsPAFinalSlots cdsPAFinalSlots : findAll()) {
			remove(cdsPAFinalSlots);
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
					"FROM larion.progate.cds.model.CdsPAFinalSlots WHERE ");

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

	public int countByUserId(int userId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(userId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.cds.model.CdsPAFinalSlots WHERE ");

				query.append("user_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

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
						"SELECT COUNT(*) FROM larion.progate.cds.model.CdsPAFinalSlots");

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
						"value.object.listener.larion.progate.cds.model.CdsPAFinalSlots")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CdsPAFinalSlots>> listenersList = new ArrayList<ModelListener<CdsPAFinalSlots>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CdsPAFinalSlots>)Class.forName(
							listenerClassName).newInstance());
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	@BeanReference(name = "larion.progate.cds.service.persistence.CompetencyPersistence.impl")
	protected larion.progate.cds.service.persistence.CompetencyPersistence competencyPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.LevelPersistence.impl")
	protected larion.progate.cds.service.persistence.LevelPersistence levelPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.SlotPersistence.impl")
	protected larion.progate.cds.service.persistence.SlotPersistence slotPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPointsPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsPointsPersistence cdsPointsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsEvaluationPeriodsPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsEvaluationPeriodsPersistence cdsEvaluationPeriodsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsTitlesPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsTitlesPersistence cdsTitlesPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsTitleCompetenciesPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsTitleCompetenciesPersistence cdsTitleCompetenciesPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsMinimumRequirementsPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsMinimumRequirementsPersistence cdsMinimumRequirementsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsTitleMinimumRequirementsPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsTitleMinimumRequirementsPersistence cdsTitleMinimumRequirementsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsMinimumRequirementLevelsPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsMinimumRequirementLevelsPersistence cdsMinimumRequirementLevelsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewListTitleCompetenciesPersistence.impl")
	protected larion.progate.cds.service.persistence.ViewListTitleCompetenciesPersistence viewListTitleCompetenciesPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewListTitleMinimumRequirementsPersistence.impl")
	protected larion.progate.cds.service.persistence.ViewListTitleMinimumRequirementsPersistence viewListTitleMinimumRequirementsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPAFinalCompeteniesPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsPAFinalCompeteniesPersistence cdsPAFinalCompeteniesPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPAFinalLevelsPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsPAFinalLevelsPersistence cdsPAFinalLevelsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPAFinalSlotsPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsPAFinalSlotsPersistence cdsPAFinalSlotsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewFinalCompetenciesPersistence.impl")
	protected larion.progate.cds.service.persistence.ViewFinalCompetenciesPersistence viewFinalCompetenciesPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewFinalLevelsPersistence.impl")
	protected larion.progate.cds.service.persistence.ViewFinalLevelsPersistence viewFinalLevelsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewFinalSlotsPersistence.impl")
	protected larion.progate.cds.service.persistence.ViewFinalSlotsPersistence viewFinalSlotsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewFinalTitlesPersistence.impl")
	protected larion.progate.cds.service.persistence.ViewFinalTitlesPersistence viewFinalTitlesPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewSlotInformationPersistence.impl")
	protected larion.progate.cds.service.persistence.ViewSlotInformationPersistence viewSlotInformationPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPASlotsPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsPASlotsPersistence cdsPASlotsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPALevelsPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsPALevelsPersistence cdsPALevelsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPACompetenciesPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsPACompetenciesPersistence cdsPACompetenciesPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewPerformanceAppraisalLevelsPersistence.impl")
	protected larion.progate.cds.service.persistence.ViewPerformanceAppraisalLevelsPersistence viewPerformanceAppraisalLevelsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewPerformanceAppraisalSlotsPersistence.impl")
	protected larion.progate.cds.service.persistence.ViewPerformanceAppraisalSlotsPersistence viewPerformanceAppraisalSlotsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPerformanceAppraisalSlotRatingPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsPerformanceAppraisalSlotRatingPersistence cdsPerformanceAppraisalSlotRatingPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPerformanceAppraisalSlotCommentsPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsPerformanceAppraisalSlotCommentsPersistence cdsPerformanceAppraisalSlotCommentsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPerformanceAppraisalsPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsPerformanceAppraisalsPersistence cdsPerformanceAppraisalsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewEmployeesInProjectsPersistence.impl")
	protected larion.progate.cds.service.persistence.ViewEmployeesInProjectsPersistence viewEmployeesInProjectsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewEmployeesSlotsRatingPersistence.impl")
	protected larion.progate.cds.service.persistence.ViewEmployeesSlotsRatingPersistence viewEmployeesSlotsRatingPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsSlotStatisticalReportPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsSlotStatisticalReportPersistence cdsSlotStatisticalReportPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsLevelStatisticalReportPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsLevelStatisticalReportPersistence cdsLevelStatisticalReportPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsCompetencyStatisticalReportPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsCompetencyStatisticalReportPersistence cdsCompetencyStatisticalReportPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsCdpPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsCdpPersistence cdsCdpPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPAFinalPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsPAFinalPersistence cdsPAFinalPersistence;
	private static Log _log = LogFactoryUtil.getLog(CdsPAFinalSlotsPersistenceImpl.class);
}