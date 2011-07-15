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

import larion.progate.lmis.NoSuchLmisViewStaffRootOrgFNException;
import larion.progate.lmis.model.LmisViewStaffRootOrgFN;
import larion.progate.lmis.model.impl.LmisViewStaffRootOrgFNImpl;
import larion.progate.lmis.model.impl.LmisViewStaffRootOrgFNModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="LmisViewStaffRootOrgFNPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewStaffRootOrgFNPersistenceImpl extends BasePersistenceImpl
	implements LmisViewStaffRootOrgFNPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = LmisViewStaffRootOrgFNImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_ROOTID = new FinderPath(LmisViewStaffRootOrgFNModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffRootOrgFNModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ROOTID = new FinderPath(LmisViewStaffRootOrgFNModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffRootOrgFNModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ROOTID = new FinderPath(LmisViewStaffRootOrgFNModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffRootOrgFNModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByRootID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_USERID = new FinderPath(LmisViewStaffRootOrgFNModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffRootOrgFNModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByUserId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_USERID = new FinderPath(LmisViewStaffRootOrgFNModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffRootOrgFNModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByUserId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(LmisViewStaffRootOrgFNModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffRootOrgFNModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByUserId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ORGID = new FinderPath(LmisViewStaffRootOrgFNModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffRootOrgFNModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOrgID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ORGID = new FinderPath(LmisViewStaffRootOrgFNModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffRootOrgFNModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOrgID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGID = new FinderPath(LmisViewStaffRootOrgFNModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffRootOrgFNModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByOrgID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_FULLNAME = new FinderPath(LmisViewStaffRootOrgFNModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffRootOrgFNModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByFullName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_FULLNAME = new FinderPath(LmisViewStaffRootOrgFNModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffRootOrgFNModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByFullName",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_FULLNAME = new FinderPath(LmisViewStaffRootOrgFNModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffRootOrgFNModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByFullName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(LmisViewStaffRootOrgFNModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffRootOrgFNModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LmisViewStaffRootOrgFNModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffRootOrgFNModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(LmisViewStaffRootOrgFN lmisViewStaffRootOrgFN) {
		EntityCacheUtil.putResult(LmisViewStaffRootOrgFNModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffRootOrgFNImpl.class,
			lmisViewStaffRootOrgFN.getPrimaryKey(), lmisViewStaffRootOrgFN);
	}

	public void cacheResult(
		List<LmisViewStaffRootOrgFN> lmisViewStaffRootOrgFNs) {
		for (LmisViewStaffRootOrgFN lmisViewStaffRootOrgFN : lmisViewStaffRootOrgFNs) {
			if (EntityCacheUtil.getResult(
						LmisViewStaffRootOrgFNModelImpl.ENTITY_CACHE_ENABLED,
						LmisViewStaffRootOrgFNImpl.class,
						lmisViewStaffRootOrgFN.getPrimaryKey(), this) == null) {
				cacheResult(lmisViewStaffRootOrgFN);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(LmisViewStaffRootOrgFNImpl.class.getName());
		EntityCacheUtil.clearCache(LmisViewStaffRootOrgFNImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public LmisViewStaffRootOrgFN create(Integer lmisViewStaffRootOrgFNId) {
		LmisViewStaffRootOrgFN lmisViewStaffRootOrgFN = new LmisViewStaffRootOrgFNImpl();

		lmisViewStaffRootOrgFN.setNew(true);
		lmisViewStaffRootOrgFN.setPrimaryKey(lmisViewStaffRootOrgFNId);

		return lmisViewStaffRootOrgFN;
	}

	public LmisViewStaffRootOrgFN remove(Integer lmisViewStaffRootOrgFNId)
		throws NoSuchLmisViewStaffRootOrgFNException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LmisViewStaffRootOrgFN lmisViewStaffRootOrgFN = (LmisViewStaffRootOrgFN)session.get(LmisViewStaffRootOrgFNImpl.class,
					lmisViewStaffRootOrgFNId);

			if (lmisViewStaffRootOrgFN == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No LmisViewStaffRootOrgFN exists with the primary key " +
						lmisViewStaffRootOrgFNId);
				}

				throw new NoSuchLmisViewStaffRootOrgFNException(
					"No LmisViewStaffRootOrgFN exists with the primary key " +
					lmisViewStaffRootOrgFNId);
			}

			return remove(lmisViewStaffRootOrgFN);
		}
		catch (NoSuchLmisViewStaffRootOrgFNException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public LmisViewStaffRootOrgFN remove(
		LmisViewStaffRootOrgFN lmisViewStaffRootOrgFN)
		throws SystemException {
		for (ModelListener<LmisViewStaffRootOrgFN> listener : listeners) {
			listener.onBeforeRemove(lmisViewStaffRootOrgFN);
		}

		lmisViewStaffRootOrgFN = removeImpl(lmisViewStaffRootOrgFN);

		for (ModelListener<LmisViewStaffRootOrgFN> listener : listeners) {
			listener.onAfterRemove(lmisViewStaffRootOrgFN);
		}

		return lmisViewStaffRootOrgFN;
	}

	protected LmisViewStaffRootOrgFN removeImpl(
		LmisViewStaffRootOrgFN lmisViewStaffRootOrgFN)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (lmisViewStaffRootOrgFN.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(LmisViewStaffRootOrgFNImpl.class,
						lmisViewStaffRootOrgFN.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(lmisViewStaffRootOrgFN);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(LmisViewStaffRootOrgFNModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffRootOrgFNImpl.class,
			lmisViewStaffRootOrgFN.getPrimaryKey());

		return lmisViewStaffRootOrgFN;
	}

	public LmisViewStaffRootOrgFN update(
		LmisViewStaffRootOrgFN lmisViewStaffRootOrgFN)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(LmisViewStaffRootOrgFN lmisViewStaffRootOrgFN) method. Use update(LmisViewStaffRootOrgFN lmisViewStaffRootOrgFN, boolean merge) instead.");
		}

		return update(lmisViewStaffRootOrgFN, false);
	}

	public LmisViewStaffRootOrgFN update(
		LmisViewStaffRootOrgFN lmisViewStaffRootOrgFN, boolean merge)
		throws SystemException {
		boolean isNew = lmisViewStaffRootOrgFN.isNew();

		for (ModelListener<LmisViewStaffRootOrgFN> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(lmisViewStaffRootOrgFN);
			}
			else {
				listener.onBeforeUpdate(lmisViewStaffRootOrgFN);
			}
		}

		lmisViewStaffRootOrgFN = updateImpl(lmisViewStaffRootOrgFN, merge);

		for (ModelListener<LmisViewStaffRootOrgFN> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(lmisViewStaffRootOrgFN);
			}
			else {
				listener.onAfterUpdate(lmisViewStaffRootOrgFN);
			}
		}

		return lmisViewStaffRootOrgFN;
	}

	public LmisViewStaffRootOrgFN updateImpl(
		larion.progate.lmis.model.LmisViewStaffRootOrgFN lmisViewStaffRootOrgFN,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, lmisViewStaffRootOrgFN, merge);

			lmisViewStaffRootOrgFN.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(LmisViewStaffRootOrgFNModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffRootOrgFNImpl.class,
			lmisViewStaffRootOrgFN.getPrimaryKey(), lmisViewStaffRootOrgFN);

		return lmisViewStaffRootOrgFN;
	}

	public LmisViewStaffRootOrgFN findByPrimaryKey(
		Integer lmisViewStaffRootOrgFNId)
		throws NoSuchLmisViewStaffRootOrgFNException, SystemException {
		LmisViewStaffRootOrgFN lmisViewStaffRootOrgFN = fetchByPrimaryKey(lmisViewStaffRootOrgFNId);

		if (lmisViewStaffRootOrgFN == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"No LmisViewStaffRootOrgFN exists with the primary key " +
					lmisViewStaffRootOrgFNId);
			}

			throw new NoSuchLmisViewStaffRootOrgFNException(
				"No LmisViewStaffRootOrgFN exists with the primary key " +
				lmisViewStaffRootOrgFNId);
		}

		return lmisViewStaffRootOrgFN;
	}

	public LmisViewStaffRootOrgFN fetchByPrimaryKey(
		Integer lmisViewStaffRootOrgFNId) throws SystemException {
		LmisViewStaffRootOrgFN lmisViewStaffRootOrgFN = (LmisViewStaffRootOrgFN)EntityCacheUtil.getResult(LmisViewStaffRootOrgFNModelImpl.ENTITY_CACHE_ENABLED,
				LmisViewStaffRootOrgFNImpl.class, lmisViewStaffRootOrgFNId, this);

		if (lmisViewStaffRootOrgFN == null) {
			Session session = null;

			try {
				session = openSession();

				lmisViewStaffRootOrgFN = (LmisViewStaffRootOrgFN)session.get(LmisViewStaffRootOrgFNImpl.class,
						lmisViewStaffRootOrgFNId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (lmisViewStaffRootOrgFN != null) {
					cacheResult(lmisViewStaffRootOrgFN);
				}

				closeSession(session);
			}
		}

		return lmisViewStaffRootOrgFN;
	}

	public List<LmisViewStaffRootOrgFN> findByRootID(int rootId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		List<LmisViewStaffRootOrgFN> list = (List<LmisViewStaffRootOrgFN>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewStaffRootOrgFN WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("emailaddress ASC");

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
					list = new ArrayList<LmisViewStaffRootOrgFN>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewStaffRootOrgFN> findByRootID(int rootId, int start,
		int end) throws SystemException {
		return findByRootID(rootId, start, end, null);
	}

	public List<LmisViewStaffRootOrgFN> findByRootID(int rootId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(rootId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewStaffRootOrgFN> list = (List<LmisViewStaffRootOrgFN>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewStaffRootOrgFN WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("emailaddress ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rootId);

				list = (List<LmisViewStaffRootOrgFN>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewStaffRootOrgFN>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewStaffRootOrgFN findByRootID_First(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisViewStaffRootOrgFNException, SystemException {
		List<LmisViewStaffRootOrgFN> list = findByRootID(rootId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewStaffRootOrgFN exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewStaffRootOrgFNException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewStaffRootOrgFN findByRootID_Last(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisViewStaffRootOrgFNException, SystemException {
		int count = countByRootID(rootId);

		List<LmisViewStaffRootOrgFN> list = findByRootID(rootId, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewStaffRootOrgFN exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewStaffRootOrgFNException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewStaffRootOrgFN[] findByRootID_PrevAndNext(
		Integer lmisViewStaffRootOrgFNId, int rootId, OrderByComparator obc)
		throws NoSuchLmisViewStaffRootOrgFNException, SystemException {
		LmisViewStaffRootOrgFN lmisViewStaffRootOrgFN = findByPrimaryKey(lmisViewStaffRootOrgFNId);

		int count = countByRootID(rootId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewStaffRootOrgFN WHERE ");

			query.append("root_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("emailaddress ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(rootId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisViewStaffRootOrgFN);

			LmisViewStaffRootOrgFN[] array = new LmisViewStaffRootOrgFNImpl[3];

			array[0] = (LmisViewStaffRootOrgFN)objArray[0];
			array[1] = (LmisViewStaffRootOrgFN)objArray[1];
			array[2] = (LmisViewStaffRootOrgFN)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewStaffRootOrgFN> findByUserId(int userId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(userId) };

		List<LmisViewStaffRootOrgFN> list = (List<LmisViewStaffRootOrgFN>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_USERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewStaffRootOrgFN WHERE ");

				query.append("user_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("emailaddress ASC");

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
					list = new ArrayList<LmisViewStaffRootOrgFN>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_USERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewStaffRootOrgFN> findByUserId(int userId, int start,
		int end) throws SystemException {
		return findByUserId(userId, start, end, null);
	}

	public List<LmisViewStaffRootOrgFN> findByUserId(int userId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(userId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewStaffRootOrgFN> list = (List<LmisViewStaffRootOrgFN>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_USERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewStaffRootOrgFN WHERE ");

				query.append("user_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("emailaddress ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				list = (List<LmisViewStaffRootOrgFN>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewStaffRootOrgFN>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_USERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewStaffRootOrgFN findByUserId_First(int userId,
		OrderByComparator obc)
		throws NoSuchLmisViewStaffRootOrgFNException, SystemException {
		List<LmisViewStaffRootOrgFN> list = findByUserId(userId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewStaffRootOrgFN exists with the key {");

			msg.append("userId=" + userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewStaffRootOrgFNException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewStaffRootOrgFN findByUserId_Last(int userId,
		OrderByComparator obc)
		throws NoSuchLmisViewStaffRootOrgFNException, SystemException {
		int count = countByUserId(userId);

		List<LmisViewStaffRootOrgFN> list = findByUserId(userId, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewStaffRootOrgFN exists with the key {");

			msg.append("userId=" + userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewStaffRootOrgFNException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewStaffRootOrgFN[] findByUserId_PrevAndNext(
		Integer lmisViewStaffRootOrgFNId, int userId, OrderByComparator obc)
		throws NoSuchLmisViewStaffRootOrgFNException, SystemException {
		LmisViewStaffRootOrgFN lmisViewStaffRootOrgFN = findByPrimaryKey(lmisViewStaffRootOrgFNId);

		int count = countByUserId(userId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewStaffRootOrgFN WHERE ");

			query.append("user_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("emailaddress ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(userId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisViewStaffRootOrgFN);

			LmisViewStaffRootOrgFN[] array = new LmisViewStaffRootOrgFNImpl[3];

			array[0] = (LmisViewStaffRootOrgFN)objArray[0];
			array[1] = (LmisViewStaffRootOrgFN)objArray[1];
			array[2] = (LmisViewStaffRootOrgFN)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewStaffRootOrgFN> findByOrgID(int orgId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(orgId) };

		List<LmisViewStaffRootOrgFN> list = (List<LmisViewStaffRootOrgFN>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ORGID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewStaffRootOrgFN WHERE ");

				query.append("org_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("emailaddress ASC");

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
					list = new ArrayList<LmisViewStaffRootOrgFN>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ORGID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewStaffRootOrgFN> findByOrgID(int orgId, int start,
		int end) throws SystemException {
		return findByOrgID(orgId, start, end, null);
	}

	public List<LmisViewStaffRootOrgFN> findByOrgID(int orgId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(orgId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewStaffRootOrgFN> list = (List<LmisViewStaffRootOrgFN>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ORGID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewStaffRootOrgFN WHERE ");

				query.append("org_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("emailaddress ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orgId);

				list = (List<LmisViewStaffRootOrgFN>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewStaffRootOrgFN>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ORGID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewStaffRootOrgFN findByOrgID_First(int orgId,
		OrderByComparator obc)
		throws NoSuchLmisViewStaffRootOrgFNException, SystemException {
		List<LmisViewStaffRootOrgFN> list = findByOrgID(orgId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewStaffRootOrgFN exists with the key {");

			msg.append("orgId=" + orgId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewStaffRootOrgFNException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewStaffRootOrgFN findByOrgID_Last(int orgId,
		OrderByComparator obc)
		throws NoSuchLmisViewStaffRootOrgFNException, SystemException {
		int count = countByOrgID(orgId);

		List<LmisViewStaffRootOrgFN> list = findByOrgID(orgId, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewStaffRootOrgFN exists with the key {");

			msg.append("orgId=" + orgId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewStaffRootOrgFNException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewStaffRootOrgFN[] findByOrgID_PrevAndNext(
		Integer lmisViewStaffRootOrgFNId, int orgId, OrderByComparator obc)
		throws NoSuchLmisViewStaffRootOrgFNException, SystemException {
		LmisViewStaffRootOrgFN lmisViewStaffRootOrgFN = findByPrimaryKey(lmisViewStaffRootOrgFNId);

		int count = countByOrgID(orgId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewStaffRootOrgFN WHERE ");

			query.append("org_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("emailaddress ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(orgId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisViewStaffRootOrgFN);

			LmisViewStaffRootOrgFN[] array = new LmisViewStaffRootOrgFNImpl[3];

			array[0] = (LmisViewStaffRootOrgFN)objArray[0];
			array[1] = (LmisViewStaffRootOrgFN)objArray[1];
			array[2] = (LmisViewStaffRootOrgFN)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewStaffRootOrgFN> findByFullName(String fullName)
		throws SystemException {
		Object[] finderArgs = new Object[] { fullName };

		List<LmisViewStaffRootOrgFN> list = (List<LmisViewStaffRootOrgFN>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_FULLNAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewStaffRootOrgFN WHERE ");

				if (fullName == null) {
					query.append("fullname LIKE null");
				}
				else {
					query.append("fullname LIKE ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("emailaddress ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (fullName != null) {
					qPos.add(fullName);
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewStaffRootOrgFN>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_FULLNAME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewStaffRootOrgFN> findByFullName(String fullName,
		int start, int end) throws SystemException {
		return findByFullName(fullName, start, end, null);
	}

	public List<LmisViewStaffRootOrgFN> findByFullName(String fullName,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				fullName,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewStaffRootOrgFN> list = (List<LmisViewStaffRootOrgFN>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_FULLNAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewStaffRootOrgFN WHERE ");

				if (fullName == null) {
					query.append("fullname LIKE null");
				}
				else {
					query.append("fullname LIKE ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("emailaddress ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (fullName != null) {
					qPos.add(fullName);
				}

				list = (List<LmisViewStaffRootOrgFN>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewStaffRootOrgFN>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_FULLNAME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewStaffRootOrgFN findByFullName_First(String fullName,
		OrderByComparator obc)
		throws NoSuchLmisViewStaffRootOrgFNException, SystemException {
		List<LmisViewStaffRootOrgFN> list = findByFullName(fullName, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewStaffRootOrgFN exists with the key {");

			msg.append("fullName=" + fullName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewStaffRootOrgFNException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewStaffRootOrgFN findByFullName_Last(String fullName,
		OrderByComparator obc)
		throws NoSuchLmisViewStaffRootOrgFNException, SystemException {
		int count = countByFullName(fullName);

		List<LmisViewStaffRootOrgFN> list = findByFullName(fullName, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewStaffRootOrgFN exists with the key {");

			msg.append("fullName=" + fullName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewStaffRootOrgFNException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewStaffRootOrgFN[] findByFullName_PrevAndNext(
		Integer lmisViewStaffRootOrgFNId, String fullName, OrderByComparator obc)
		throws NoSuchLmisViewStaffRootOrgFNException, SystemException {
		LmisViewStaffRootOrgFN lmisViewStaffRootOrgFN = findByPrimaryKey(lmisViewStaffRootOrgFNId);

		int count = countByFullName(fullName);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewStaffRootOrgFN WHERE ");

			if (fullName == null) {
				query.append("fullname LIKE null");
			}
			else {
				query.append("fullname LIKE ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("emailaddress ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (fullName != null) {
				qPos.add(fullName);
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisViewStaffRootOrgFN);

			LmisViewStaffRootOrgFN[] array = new LmisViewStaffRootOrgFNImpl[3];

			array[0] = (LmisViewStaffRootOrgFN)objArray[0];
			array[1] = (LmisViewStaffRootOrgFN)objArray[1];
			array[2] = (LmisViewStaffRootOrgFN)objArray[2];

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

	public List<LmisViewStaffRootOrgFN> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<LmisViewStaffRootOrgFN> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<LmisViewStaffRootOrgFN> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewStaffRootOrgFN> list = (List<LmisViewStaffRootOrgFN>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewStaffRootOrgFN ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("emailaddress ASC");
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<LmisViewStaffRootOrgFN>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LmisViewStaffRootOrgFN>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewStaffRootOrgFN>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByRootID(int rootId) throws SystemException {
		for (LmisViewStaffRootOrgFN lmisViewStaffRootOrgFN : findByRootID(
				rootId)) {
			remove(lmisViewStaffRootOrgFN);
		}
	}

	public void removeByUserId(int userId) throws SystemException {
		for (LmisViewStaffRootOrgFN lmisViewStaffRootOrgFN : findByUserId(
				userId)) {
			remove(lmisViewStaffRootOrgFN);
		}
	}

	public void removeByOrgID(int orgId) throws SystemException {
		for (LmisViewStaffRootOrgFN lmisViewStaffRootOrgFN : findByOrgID(orgId)) {
			remove(lmisViewStaffRootOrgFN);
		}
	}

	public void removeByFullName(String fullName) throws SystemException {
		for (LmisViewStaffRootOrgFN lmisViewStaffRootOrgFN : findByFullName(
				fullName)) {
			remove(lmisViewStaffRootOrgFN);
		}
	}

	public void removeAll() throws SystemException {
		for (LmisViewStaffRootOrgFN lmisViewStaffRootOrgFN : findAll()) {
			remove(lmisViewStaffRootOrgFN);
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
					"FROM larion.progate.lmis.model.LmisViewStaffRootOrgFN WHERE ");

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
					"FROM larion.progate.lmis.model.LmisViewStaffRootOrgFN WHERE ");

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
					"FROM larion.progate.lmis.model.LmisViewStaffRootOrgFN WHERE ");

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

	public int countByFullName(String fullName) throws SystemException {
		Object[] finderArgs = new Object[] { fullName };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FULLNAME,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisViewStaffRootOrgFN WHERE ");

				if (fullName == null) {
					query.append("fullname LIKE null");
				}
				else {
					query.append("fullname LIKE ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (fullName != null) {
					qPos.add(fullName);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FULLNAME,
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
						"SELECT COUNT(*) FROM larion.progate.lmis.model.LmisViewStaffRootOrgFN");

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
						"value.object.listener.larion.progate.lmis.model.LmisViewStaffRootOrgFN")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LmisViewStaffRootOrgFN>> listenersList = new ArrayList<ModelListener<LmisViewStaffRootOrgFN>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LmisViewStaffRootOrgFN>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(LmisViewStaffRootOrgFNPersistenceImpl.class);
}