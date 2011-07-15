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

import larion.progate.cds.NoSuchCdsPASlotsException;
import larion.progate.cds.model.CdsPASlots;
import larion.progate.cds.model.impl.CdsPASlotsImpl;
import larion.progate.cds.model.impl.CdsPASlotsModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="CdsPASlotsPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsPASlotsPersistenceImpl extends BasePersistenceImpl
	implements CdsPASlotsPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = CdsPASlotsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_PERIODID = new FinderPath(CdsPASlotsModelImpl.ENTITY_CACHE_ENABLED,
			CdsPASlotsModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByPeriodId", new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_PERIODID = new FinderPath(CdsPASlotsModelImpl.ENTITY_CACHE_ENABLED,
			CdsPASlotsModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByPeriodId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_PERIODID = new FinderPath(CdsPASlotsModelImpl.ENTITY_CACHE_ENABLED,
			CdsPASlotsModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByPeriodId", new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_USERID = new FinderPath(CdsPASlotsModelImpl.ENTITY_CACHE_ENABLED,
			CdsPASlotsModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByUserId", new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_USERID = new FinderPath(CdsPASlotsModelImpl.ENTITY_CACHE_ENABLED,
			CdsPASlotsModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByUserId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(CdsPASlotsModelImpl.ENTITY_CACHE_ENABLED,
			CdsPASlotsModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByUserId", new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(CdsPASlotsModelImpl.ENTITY_CACHE_ENABLED,
			CdsPASlotsModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CdsPASlotsModelImpl.ENTITY_CACHE_ENABLED,
			CdsPASlotsModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	public void cacheResult(CdsPASlots cdsPASlots) {
		EntityCacheUtil.putResult(CdsPASlotsModelImpl.ENTITY_CACHE_ENABLED,
			CdsPASlotsImpl.class, cdsPASlots.getPrimaryKey(), cdsPASlots);
	}

	public void cacheResult(List<CdsPASlots> cdsPASlotses) {
		for (CdsPASlots cdsPASlots : cdsPASlotses) {
			if (EntityCacheUtil.getResult(
						CdsPASlotsModelImpl.ENTITY_CACHE_ENABLED,
						CdsPASlotsImpl.class, cdsPASlots.getPrimaryKey(), this) == null) {
				cacheResult(cdsPASlots);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(CdsPASlotsImpl.class.getName());
		EntityCacheUtil.clearCache(CdsPASlotsImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public CdsPASlots create(Integer CdsPASlotsId) {
		CdsPASlots cdsPASlots = new CdsPASlotsImpl();

		cdsPASlots.setNew(true);
		cdsPASlots.setPrimaryKey(CdsPASlotsId);

		return cdsPASlots;
	}

	public CdsPASlots remove(Integer CdsPASlotsId)
		throws NoSuchCdsPASlotsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CdsPASlots cdsPASlots = (CdsPASlots)session.get(CdsPASlotsImpl.class,
					CdsPASlotsId);

			if (cdsPASlots == null) {
				if (_log.isWarnEnabled()) {
					_log.warn("No CdsPASlots exists with the primary key " +
						CdsPASlotsId);
				}

				throw new NoSuchCdsPASlotsException(
					"No CdsPASlots exists with the primary key " +
					CdsPASlotsId);
			}

			return remove(cdsPASlots);
		}
		catch (NoSuchCdsPASlotsException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public CdsPASlots remove(CdsPASlots cdsPASlots) throws SystemException {
		for (ModelListener<CdsPASlots> listener : listeners) {
			listener.onBeforeRemove(cdsPASlots);
		}

		cdsPASlots = removeImpl(cdsPASlots);

		for (ModelListener<CdsPASlots> listener : listeners) {
			listener.onAfterRemove(cdsPASlots);
		}

		return cdsPASlots;
	}

	protected CdsPASlots removeImpl(CdsPASlots cdsPASlots)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (cdsPASlots.isCachedModel() || BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(CdsPASlotsImpl.class,
						cdsPASlots.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(cdsPASlots);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(CdsPASlotsModelImpl.ENTITY_CACHE_ENABLED,
			CdsPASlotsImpl.class, cdsPASlots.getPrimaryKey());

		return cdsPASlots;
	}

	public CdsPASlots update(CdsPASlots cdsPASlots) throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(CdsPASlots cdsPASlots) method. Use update(CdsPASlots cdsPASlots, boolean merge) instead.");
		}

		return update(cdsPASlots, false);
	}

	public CdsPASlots update(CdsPASlots cdsPASlots, boolean merge)
		throws SystemException {
		boolean isNew = cdsPASlots.isNew();

		for (ModelListener<CdsPASlots> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(cdsPASlots);
			}
			else {
				listener.onBeforeUpdate(cdsPASlots);
			}
		}

		cdsPASlots = updateImpl(cdsPASlots, merge);

		for (ModelListener<CdsPASlots> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(cdsPASlots);
			}
			else {
				listener.onAfterUpdate(cdsPASlots);
			}
		}

		return cdsPASlots;
	}

	public CdsPASlots updateImpl(
		larion.progate.cds.model.CdsPASlots cdsPASlots, boolean merge)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, cdsPASlots, merge);

			cdsPASlots.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(CdsPASlotsModelImpl.ENTITY_CACHE_ENABLED,
			CdsPASlotsImpl.class, cdsPASlots.getPrimaryKey(), cdsPASlots);

		return cdsPASlots;
	}

	public CdsPASlots findByPrimaryKey(Integer CdsPASlotsId)
		throws NoSuchCdsPASlotsException, SystemException {
		CdsPASlots cdsPASlots = fetchByPrimaryKey(CdsPASlotsId);

		if (cdsPASlots == null) {
			if (_log.isWarnEnabled()) {
				_log.warn("No CdsPASlots exists with the primary key " +
					CdsPASlotsId);
			}

			throw new NoSuchCdsPASlotsException(
				"No CdsPASlots exists with the primary key " + CdsPASlotsId);
		}

		return cdsPASlots;
	}

	public CdsPASlots fetchByPrimaryKey(Integer CdsPASlotsId)
		throws SystemException {
		CdsPASlots cdsPASlots = (CdsPASlots)EntityCacheUtil.getResult(CdsPASlotsModelImpl.ENTITY_CACHE_ENABLED,
				CdsPASlotsImpl.class, CdsPASlotsId, this);

		if (cdsPASlots == null) {
			Session session = null;

			try {
				session = openSession();

				cdsPASlots = (CdsPASlots)session.get(CdsPASlotsImpl.class,
						CdsPASlotsId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (cdsPASlots != null) {
					cacheResult(cdsPASlots);
				}

				closeSession(session);
			}
		}

		return cdsPASlots;
	}

	public List<CdsPASlots> findByPeriodId(int periodId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(periodId) };

		List<CdsPASlots> list = (List<CdsPASlots>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_PERIODID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.cds.model.CdsPASlots WHERE ");

				query.append("period_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(periodId);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsPASlots>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_PERIODID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<CdsPASlots> findByPeriodId(int periodId, int start, int end)
		throws SystemException {
		return findByPeriodId(periodId, start, end, null);
	}

	public List<CdsPASlots> findByPeriodId(int periodId, int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(periodId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<CdsPASlots> list = (List<CdsPASlots>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_PERIODID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.cds.model.CdsPASlots WHERE ");

				query.append("period_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(periodId);

				list = (List<CdsPASlots>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsPASlots>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_PERIODID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public CdsPASlots findByPeriodId_First(int periodId, OrderByComparator obc)
		throws NoSuchCdsPASlotsException, SystemException {
		List<CdsPASlots> list = findByPeriodId(periodId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No CdsPASlots exists with the key {");

			msg.append("periodId=" + periodId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsPASlotsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsPASlots findByPeriodId_Last(int periodId, OrderByComparator obc)
		throws NoSuchCdsPASlotsException, SystemException {
		int count = countByPeriodId(periodId);

		List<CdsPASlots> list = findByPeriodId(periodId, count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No CdsPASlots exists with the key {");

			msg.append("periodId=" + periodId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsPASlotsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsPASlots[] findByPeriodId_PrevAndNext(Integer CdsPASlotsId,
		int periodId, OrderByComparator obc)
		throws NoSuchCdsPASlotsException, SystemException {
		CdsPASlots cdsPASlots = findByPrimaryKey(CdsPASlotsId);

		int count = countByPeriodId(periodId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.cds.model.CdsPASlots WHERE ");

			query.append("period_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(periodId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					cdsPASlots);

			CdsPASlots[] array = new CdsPASlotsImpl[3];

			array[0] = (CdsPASlots)objArray[0];
			array[1] = (CdsPASlots)objArray[1];
			array[2] = (CdsPASlots)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<CdsPASlots> findByUserId(int userId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(userId) };

		List<CdsPASlots> list = (List<CdsPASlots>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_USERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.cds.model.CdsPASlots WHERE ");

				query.append("user_id  = ?");

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
					list = new ArrayList<CdsPASlots>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_USERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<CdsPASlots> findByUserId(int userId, int start, int end)
		throws SystemException {
		return findByUserId(userId, start, end, null);
	}

	public List<CdsPASlots> findByUserId(int userId, int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(userId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<CdsPASlots> list = (List<CdsPASlots>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_USERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.cds.model.CdsPASlots WHERE ");

				query.append("user_id  = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				list = (List<CdsPASlots>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsPASlots>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_USERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public CdsPASlots findByUserId_First(int userId, OrderByComparator obc)
		throws NoSuchCdsPASlotsException, SystemException {
		List<CdsPASlots> list = findByUserId(userId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No CdsPASlots exists with the key {");

			msg.append("userId=" + userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsPASlotsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsPASlots findByUserId_Last(int userId, OrderByComparator obc)
		throws NoSuchCdsPASlotsException, SystemException {
		int count = countByUserId(userId);

		List<CdsPASlots> list = findByUserId(userId, count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No CdsPASlots exists with the key {");

			msg.append("userId=" + userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsPASlotsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsPASlots[] findByUserId_PrevAndNext(Integer CdsPASlotsId,
		int userId, OrderByComparator obc)
		throws NoSuchCdsPASlotsException, SystemException {
		CdsPASlots cdsPASlots = findByPrimaryKey(CdsPASlotsId);

		int count = countByUserId(userId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.cds.model.CdsPASlots WHERE ");

			query.append("user_id  = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(userId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					cdsPASlots);

			CdsPASlots[] array = new CdsPASlotsImpl[3];

			array[0] = (CdsPASlots)objArray[0];
			array[1] = (CdsPASlots)objArray[1];
			array[2] = (CdsPASlots)objArray[2];

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

	public List<CdsPASlots> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<CdsPASlots> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<CdsPASlots> findAll(int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<CdsPASlots> list = (List<CdsPASlots>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.cds.model.CdsPASlots ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<CdsPASlots>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<CdsPASlots>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsPASlots>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByPeriodId(int periodId) throws SystemException {
		for (CdsPASlots cdsPASlots : findByPeriodId(periodId)) {
			remove(cdsPASlots);
		}
	}

	public void removeByUserId(int userId) throws SystemException {
		for (CdsPASlots cdsPASlots : findByUserId(userId)) {
			remove(cdsPASlots);
		}
	}

	public void removeAll() throws SystemException {
		for (CdsPASlots cdsPASlots : findAll()) {
			remove(cdsPASlots);
		}
	}

	public int countByPeriodId(int periodId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(periodId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PERIODID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append("FROM larion.progate.cds.model.CdsPASlots WHERE ");

				query.append("period_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(periodId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PERIODID,
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
				query.append("FROM larion.progate.cds.model.CdsPASlots WHERE ");

				query.append("user_id  = ?");

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
						"SELECT COUNT(*) FROM larion.progate.cds.model.CdsPASlots");

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
						"value.object.listener.larion.progate.cds.model.CdsPASlots")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CdsPASlots>> listenersList = new ArrayList<ModelListener<CdsPASlots>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CdsPASlots>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(CdsPASlotsPersistenceImpl.class);
}