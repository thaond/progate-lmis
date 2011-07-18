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

import larion.progate.lmis.NoSuchLmisViewStaffRootOrgException;
import larion.progate.lmis.model.LmisViewStaffRootOrg;
import larion.progate.lmis.model.impl.LmisViewStaffRootOrgImpl;
import larion.progate.lmis.model.impl.LmisViewStaffRootOrgModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="LmisViewStaffRootOrgPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewStaffRootOrgPersistenceImpl extends BasePersistenceImpl
	implements LmisViewStaffRootOrgPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = LmisViewStaffRootOrgImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_ROOTID = new FinderPath(LmisViewStaffRootOrgModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffRootOrgModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ROOTID = new FinderPath(LmisViewStaffRootOrgModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffRootOrgModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ROOTID = new FinderPath(LmisViewStaffRootOrgModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffRootOrgModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByRootID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ORGID = new FinderPath(LmisViewStaffRootOrgModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffRootOrgModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOrgID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ORGID = new FinderPath(LmisViewStaffRootOrgModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffRootOrgModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOrgID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGID = new FinderPath(LmisViewStaffRootOrgModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffRootOrgModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByOrgID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_BODID = new FinderPath(LmisViewStaffRootOrgModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffRootOrgModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByBodID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_BODID = new FinderPath(LmisViewStaffRootOrgModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffRootOrgModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByBodID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_BODID = new FinderPath(LmisViewStaffRootOrgModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffRootOrgModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByBodID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(LmisViewStaffRootOrgModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffRootOrgModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LmisViewStaffRootOrgModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffRootOrgModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(LmisViewStaffRootOrg lmisViewStaffRootOrg) {
		EntityCacheUtil.putResult(LmisViewStaffRootOrgModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffRootOrgImpl.class,
			lmisViewStaffRootOrg.getPrimaryKey(), lmisViewStaffRootOrg);
	}

	public void cacheResult(List<LmisViewStaffRootOrg> lmisViewStaffRootOrgs) {
		for (LmisViewStaffRootOrg lmisViewStaffRootOrg : lmisViewStaffRootOrgs) {
			if (EntityCacheUtil.getResult(
						LmisViewStaffRootOrgModelImpl.ENTITY_CACHE_ENABLED,
						LmisViewStaffRootOrgImpl.class,
						lmisViewStaffRootOrg.getPrimaryKey(), this) == null) {
				cacheResult(lmisViewStaffRootOrg);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(LmisViewStaffRootOrgImpl.class.getName());
		EntityCacheUtil.clearCache(LmisViewStaffRootOrgImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public LmisViewStaffRootOrg create(Integer User_id) {
		LmisViewStaffRootOrg lmisViewStaffRootOrg = new LmisViewStaffRootOrgImpl();

		lmisViewStaffRootOrg.setNew(true);
		lmisViewStaffRootOrg.setPrimaryKey(User_id);

		return lmisViewStaffRootOrg;
	}

	public LmisViewStaffRootOrg remove(Integer User_id)
		throws NoSuchLmisViewStaffRootOrgException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LmisViewStaffRootOrg lmisViewStaffRootOrg = (LmisViewStaffRootOrg)session.get(LmisViewStaffRootOrgImpl.class,
					User_id);

			if (lmisViewStaffRootOrg == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No LmisViewStaffRootOrg exists with the primary key " +
						User_id);
				}

				throw new NoSuchLmisViewStaffRootOrgException(
					"No LmisViewStaffRootOrg exists with the primary key " +
					User_id);
			}

			return remove(lmisViewStaffRootOrg);
		}
		catch (NoSuchLmisViewStaffRootOrgException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public LmisViewStaffRootOrg remove(
		LmisViewStaffRootOrg lmisViewStaffRootOrg) throws SystemException {
		for (ModelListener<LmisViewStaffRootOrg> listener : listeners) {
			listener.onBeforeRemove(lmisViewStaffRootOrg);
		}

		lmisViewStaffRootOrg = removeImpl(lmisViewStaffRootOrg);

		for (ModelListener<LmisViewStaffRootOrg> listener : listeners) {
			listener.onAfterRemove(lmisViewStaffRootOrg);
		}

		return lmisViewStaffRootOrg;
	}

	protected LmisViewStaffRootOrg removeImpl(
		LmisViewStaffRootOrg lmisViewStaffRootOrg) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (lmisViewStaffRootOrg.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(LmisViewStaffRootOrgImpl.class,
						lmisViewStaffRootOrg.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(lmisViewStaffRootOrg);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(LmisViewStaffRootOrgModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffRootOrgImpl.class, lmisViewStaffRootOrg.getPrimaryKey());

		return lmisViewStaffRootOrg;
	}

	public LmisViewStaffRootOrg update(
		LmisViewStaffRootOrg lmisViewStaffRootOrg) throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(LmisViewStaffRootOrg lmisViewStaffRootOrg) method. Use update(LmisViewStaffRootOrg lmisViewStaffRootOrg, boolean merge) instead.");
		}

		return update(lmisViewStaffRootOrg, false);
	}

	public LmisViewStaffRootOrg update(
		LmisViewStaffRootOrg lmisViewStaffRootOrg, boolean merge)
		throws SystemException {
		boolean isNew = lmisViewStaffRootOrg.isNew();

		for (ModelListener<LmisViewStaffRootOrg> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(lmisViewStaffRootOrg);
			}
			else {
				listener.onBeforeUpdate(lmisViewStaffRootOrg);
			}
		}

		lmisViewStaffRootOrg = updateImpl(lmisViewStaffRootOrg, merge);

		for (ModelListener<LmisViewStaffRootOrg> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(lmisViewStaffRootOrg);
			}
			else {
				listener.onAfterUpdate(lmisViewStaffRootOrg);
			}
		}

		return lmisViewStaffRootOrg;
	}

	public LmisViewStaffRootOrg updateImpl(
		larion.progate.lmis.model.LmisViewStaffRootOrg lmisViewStaffRootOrg,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, lmisViewStaffRootOrg, merge);

			lmisViewStaffRootOrg.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(LmisViewStaffRootOrgModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffRootOrgImpl.class,
			lmisViewStaffRootOrg.getPrimaryKey(), lmisViewStaffRootOrg);

		return lmisViewStaffRootOrg;
	}

	public LmisViewStaffRootOrg findByPrimaryKey(Integer User_id)
		throws NoSuchLmisViewStaffRootOrgException, SystemException {
		LmisViewStaffRootOrg lmisViewStaffRootOrg = fetchByPrimaryKey(User_id);

		if (lmisViewStaffRootOrg == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"No LmisViewStaffRootOrg exists with the primary key " +
					User_id);
			}

			throw new NoSuchLmisViewStaffRootOrgException(
				"No LmisViewStaffRootOrg exists with the primary key " +
				User_id);
		}

		return lmisViewStaffRootOrg;
	}

	public LmisViewStaffRootOrg fetchByPrimaryKey(Integer User_id)
		throws SystemException {
		LmisViewStaffRootOrg lmisViewStaffRootOrg = (LmisViewStaffRootOrg)EntityCacheUtil.getResult(LmisViewStaffRootOrgModelImpl.ENTITY_CACHE_ENABLED,
				LmisViewStaffRootOrgImpl.class, User_id, this);

		if (lmisViewStaffRootOrg == null) {
			Session session = null;

			try {
				session = openSession();

				lmisViewStaffRootOrg = (LmisViewStaffRootOrg)session.get(LmisViewStaffRootOrgImpl.class,
						User_id);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (lmisViewStaffRootOrg != null) {
					cacheResult(lmisViewStaffRootOrg);
				}

				closeSession(session);
			}
		}

		return lmisViewStaffRootOrg;
	}

	public List<LmisViewStaffRootOrg> findByRootID(int rootId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		List<LmisViewStaffRootOrg> list = (List<LmisViewStaffRootOrg>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewStaffRootOrg WHERE ");

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
					list = new ArrayList<LmisViewStaffRootOrg>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewStaffRootOrg> findByRootID(int rootId, int start,
		int end) throws SystemException {
		return findByRootID(rootId, start, end, null);
	}

	public List<LmisViewStaffRootOrg> findByRootID(int rootId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(rootId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewStaffRootOrg> list = (List<LmisViewStaffRootOrg>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewStaffRootOrg WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rootId);

				list = (List<LmisViewStaffRootOrg>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewStaffRootOrg>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewStaffRootOrg findByRootID_First(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisViewStaffRootOrgException, SystemException {
		List<LmisViewStaffRootOrg> list = findByRootID(rootId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewStaffRootOrg exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewStaffRootOrgException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewStaffRootOrg findByRootID_Last(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisViewStaffRootOrgException, SystemException {
		int count = countByRootID(rootId);

		List<LmisViewStaffRootOrg> list = findByRootID(rootId, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewStaffRootOrg exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewStaffRootOrgException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewStaffRootOrg[] findByRootID_PrevAndNext(Integer User_id,
		int rootId, OrderByComparator obc)
		throws NoSuchLmisViewStaffRootOrgException, SystemException {
		LmisViewStaffRootOrg lmisViewStaffRootOrg = findByPrimaryKey(User_id);

		int count = countByRootID(rootId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewStaffRootOrg WHERE ");

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
					lmisViewStaffRootOrg);

			LmisViewStaffRootOrg[] array = new LmisViewStaffRootOrgImpl[3];

			array[0] = (LmisViewStaffRootOrg)objArray[0];
			array[1] = (LmisViewStaffRootOrg)objArray[1];
			array[2] = (LmisViewStaffRootOrg)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewStaffRootOrg> findByOrgID(int orgId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(orgId) };

		List<LmisViewStaffRootOrg> list = (List<LmisViewStaffRootOrg>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ORGID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewStaffRootOrg WHERE ");

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
					list = new ArrayList<LmisViewStaffRootOrg>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ORGID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewStaffRootOrg> findByOrgID(int orgId, int start, int end)
		throws SystemException {
		return findByOrgID(orgId, start, end, null);
	}

	public List<LmisViewStaffRootOrg> findByOrgID(int orgId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(orgId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewStaffRootOrg> list = (List<LmisViewStaffRootOrg>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ORGID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewStaffRootOrg WHERE ");

				query.append("org_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orgId);

				list = (List<LmisViewStaffRootOrg>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewStaffRootOrg>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ORGID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewStaffRootOrg findByOrgID_First(int orgId,
		OrderByComparator obc)
		throws NoSuchLmisViewStaffRootOrgException, SystemException {
		List<LmisViewStaffRootOrg> list = findByOrgID(orgId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewStaffRootOrg exists with the key {");

			msg.append("orgId=" + orgId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewStaffRootOrgException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewStaffRootOrg findByOrgID_Last(int orgId,
		OrderByComparator obc)
		throws NoSuchLmisViewStaffRootOrgException, SystemException {
		int count = countByOrgID(orgId);

		List<LmisViewStaffRootOrg> list = findByOrgID(orgId, count - 1, count,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewStaffRootOrg exists with the key {");

			msg.append("orgId=" + orgId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewStaffRootOrgException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewStaffRootOrg[] findByOrgID_PrevAndNext(Integer User_id,
		int orgId, OrderByComparator obc)
		throws NoSuchLmisViewStaffRootOrgException, SystemException {
		LmisViewStaffRootOrg lmisViewStaffRootOrg = findByPrimaryKey(User_id);

		int count = countByOrgID(orgId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewStaffRootOrg WHERE ");

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
					lmisViewStaffRootOrg);

			LmisViewStaffRootOrg[] array = new LmisViewStaffRootOrgImpl[3];

			array[0] = (LmisViewStaffRootOrg)objArray[0];
			array[1] = (LmisViewStaffRootOrg)objArray[1];
			array[2] = (LmisViewStaffRootOrg)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewStaffRootOrg> findByBodID(int bodId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(bodId) };

		List<LmisViewStaffRootOrg> list = (List<LmisViewStaffRootOrg>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_BODID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewStaffRootOrg WHERE ");

				query.append("bod_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(bodId);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewStaffRootOrg>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_BODID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewStaffRootOrg> findByBodID(int bodId, int start, int end)
		throws SystemException {
		return findByBodID(bodId, start, end, null);
	}

	public List<LmisViewStaffRootOrg> findByBodID(int bodId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(bodId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewStaffRootOrg> list = (List<LmisViewStaffRootOrg>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_BODID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewStaffRootOrg WHERE ");

				query.append("bod_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(bodId);

				list = (List<LmisViewStaffRootOrg>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewStaffRootOrg>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_BODID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewStaffRootOrg findByBodID_First(int bodId,
		OrderByComparator obc)
		throws NoSuchLmisViewStaffRootOrgException, SystemException {
		List<LmisViewStaffRootOrg> list = findByBodID(bodId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewStaffRootOrg exists with the key {");

			msg.append("bodId=" + bodId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewStaffRootOrgException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewStaffRootOrg findByBodID_Last(int bodId,
		OrderByComparator obc)
		throws NoSuchLmisViewStaffRootOrgException, SystemException {
		int count = countByBodID(bodId);

		List<LmisViewStaffRootOrg> list = findByBodID(bodId, count - 1, count,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewStaffRootOrg exists with the key {");

			msg.append("bodId=" + bodId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewStaffRootOrgException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewStaffRootOrg[] findByBodID_PrevAndNext(Integer User_id,
		int bodId, OrderByComparator obc)
		throws NoSuchLmisViewStaffRootOrgException, SystemException {
		LmisViewStaffRootOrg lmisViewStaffRootOrg = findByPrimaryKey(User_id);

		int count = countByBodID(bodId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewStaffRootOrg WHERE ");

			query.append("bod_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(bodId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisViewStaffRootOrg);

			LmisViewStaffRootOrg[] array = new LmisViewStaffRootOrgImpl[3];

			array[0] = (LmisViewStaffRootOrg)objArray[0];
			array[1] = (LmisViewStaffRootOrg)objArray[1];
			array[2] = (LmisViewStaffRootOrg)objArray[2];

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

	public List<LmisViewStaffRootOrg> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<LmisViewStaffRootOrg> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<LmisViewStaffRootOrg> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewStaffRootOrg> list = (List<LmisViewStaffRootOrg>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewStaffRootOrg ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<LmisViewStaffRootOrg>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LmisViewStaffRootOrg>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewStaffRootOrg>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByRootID(int rootId) throws SystemException {
		for (LmisViewStaffRootOrg lmisViewStaffRootOrg : findByRootID(rootId)) {
			remove(lmisViewStaffRootOrg);
		}
	}

	public void removeByOrgID(int orgId) throws SystemException {
		for (LmisViewStaffRootOrg lmisViewStaffRootOrg : findByOrgID(orgId)) {
			remove(lmisViewStaffRootOrg);
		}
	}

	public void removeByBodID(int bodId) throws SystemException {
		for (LmisViewStaffRootOrg lmisViewStaffRootOrg : findByBodID(bodId)) {
			remove(lmisViewStaffRootOrg);
		}
	}

	public void removeAll() throws SystemException {
		for (LmisViewStaffRootOrg lmisViewStaffRootOrg : findAll()) {
			remove(lmisViewStaffRootOrg);
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
					"FROM larion.progate.lmis.model.LmisViewStaffRootOrg WHERE ");

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
					"FROM larion.progate.lmis.model.LmisViewStaffRootOrg WHERE ");

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

	public int countByBodID(int bodId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(bodId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_BODID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisViewStaffRootOrg WHERE ");

				query.append("bod_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(bodId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BODID,
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
						"SELECT COUNT(*) FROM larion.progate.lmis.model.LmisViewStaffRootOrg");

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
						"value.object.listener.larion.progate.lmis.model.LmisViewStaffRootOrg")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LmisViewStaffRootOrg>> listenersList = new ArrayList<ModelListener<LmisViewStaffRootOrg>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LmisViewStaffRootOrg>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(LmisViewStaffRootOrgPersistenceImpl.class);
}