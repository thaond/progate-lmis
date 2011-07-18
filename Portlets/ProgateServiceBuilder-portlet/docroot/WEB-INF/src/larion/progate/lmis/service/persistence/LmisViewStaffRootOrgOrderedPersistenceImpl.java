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

import larion.progate.lmis.NoSuchLmisViewStaffRootOrgOrderedException;
import larion.progate.lmis.model.LmisViewStaffRootOrgOrdered;
import larion.progate.lmis.model.impl.LmisViewStaffRootOrgOrderedImpl;
import larion.progate.lmis.model.impl.LmisViewStaffRootOrgOrderedModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="LmisViewStaffRootOrgOrderedPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewStaffRootOrgOrderedPersistenceImpl
	extends BasePersistenceImpl
	implements LmisViewStaffRootOrgOrderedPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = LmisViewStaffRootOrgOrderedImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_ROOTID = new FinderPath(LmisViewStaffRootOrgOrderedModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffRootOrgOrderedModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ROOTID = new FinderPath(LmisViewStaffRootOrgOrderedModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffRootOrgOrderedModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ROOTID = new FinderPath(LmisViewStaffRootOrgOrderedModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffRootOrgOrderedModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByRootID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_USERID = new FinderPath(LmisViewStaffRootOrgOrderedModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffRootOrgOrderedModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByUserId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_USERID = new FinderPath(LmisViewStaffRootOrgOrderedModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffRootOrgOrderedModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByUserId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(LmisViewStaffRootOrgOrderedModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffRootOrgOrderedModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByUserId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ORGID = new FinderPath(LmisViewStaffRootOrgOrderedModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffRootOrgOrderedModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOrgID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ORGID = new FinderPath(LmisViewStaffRootOrgOrderedModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffRootOrgOrderedModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOrgID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGID = new FinderPath(LmisViewStaffRootOrgOrderedModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffRootOrgOrderedModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByOrgID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_FULLNAME = new FinderPath(LmisViewStaffRootOrgOrderedModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffRootOrgOrderedModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByFullName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_FULLNAME = new FinderPath(LmisViewStaffRootOrgOrderedModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffRootOrgOrderedModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByFullName",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_FULLNAME = new FinderPath(LmisViewStaffRootOrgOrderedModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffRootOrgOrderedModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByFullName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(LmisViewStaffRootOrgOrderedModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffRootOrgOrderedModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LmisViewStaffRootOrgOrderedModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffRootOrgOrderedModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(
		LmisViewStaffRootOrgOrdered lmisViewStaffRootOrgOrdered) {
		EntityCacheUtil.putResult(LmisViewStaffRootOrgOrderedModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffRootOrgOrderedImpl.class,
			lmisViewStaffRootOrgOrdered.getPrimaryKey(),
			lmisViewStaffRootOrgOrdered);
	}

	public void cacheResult(
		List<LmisViewStaffRootOrgOrdered> lmisViewStaffRootOrgOrdereds) {
		for (LmisViewStaffRootOrgOrdered lmisViewStaffRootOrgOrdered : lmisViewStaffRootOrgOrdereds) {
			if (EntityCacheUtil.getResult(
						LmisViewStaffRootOrgOrderedModelImpl.ENTITY_CACHE_ENABLED,
						LmisViewStaffRootOrgOrderedImpl.class,
						lmisViewStaffRootOrgOrdered.getPrimaryKey(), this) == null) {
				cacheResult(lmisViewStaffRootOrgOrdered);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(LmisViewStaffRootOrgOrderedImpl.class.getName());
		EntityCacheUtil.clearCache(LmisViewStaffRootOrgOrderedImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public LmisViewStaffRootOrgOrdered create(
		Integer lmisViewStaffRootOrgOrderedId) {
		LmisViewStaffRootOrgOrdered lmisViewStaffRootOrgOrdered = new LmisViewStaffRootOrgOrderedImpl();

		lmisViewStaffRootOrgOrdered.setNew(true);
		lmisViewStaffRootOrgOrdered.setPrimaryKey(lmisViewStaffRootOrgOrderedId);

		return lmisViewStaffRootOrgOrdered;
	}

	public LmisViewStaffRootOrgOrdered remove(
		Integer lmisViewStaffRootOrgOrderedId)
		throws NoSuchLmisViewStaffRootOrgOrderedException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LmisViewStaffRootOrgOrdered lmisViewStaffRootOrgOrdered = (LmisViewStaffRootOrgOrdered)session.get(LmisViewStaffRootOrgOrderedImpl.class,
					lmisViewStaffRootOrgOrderedId);

			if (lmisViewStaffRootOrgOrdered == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No LmisViewStaffRootOrgOrdered exists with the primary key " +
						lmisViewStaffRootOrgOrderedId);
				}

				throw new NoSuchLmisViewStaffRootOrgOrderedException(
					"No LmisViewStaffRootOrgOrdered exists with the primary key " +
					lmisViewStaffRootOrgOrderedId);
			}

			return remove(lmisViewStaffRootOrgOrdered);
		}
		catch (NoSuchLmisViewStaffRootOrgOrderedException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public LmisViewStaffRootOrgOrdered remove(
		LmisViewStaffRootOrgOrdered lmisViewStaffRootOrgOrdered)
		throws SystemException {
		for (ModelListener<LmisViewStaffRootOrgOrdered> listener : listeners) {
			listener.onBeforeRemove(lmisViewStaffRootOrgOrdered);
		}

		lmisViewStaffRootOrgOrdered = removeImpl(lmisViewStaffRootOrgOrdered);

		for (ModelListener<LmisViewStaffRootOrgOrdered> listener : listeners) {
			listener.onAfterRemove(lmisViewStaffRootOrgOrdered);
		}

		return lmisViewStaffRootOrgOrdered;
	}

	protected LmisViewStaffRootOrgOrdered removeImpl(
		LmisViewStaffRootOrgOrdered lmisViewStaffRootOrgOrdered)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (lmisViewStaffRootOrgOrdered.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(LmisViewStaffRootOrgOrderedImpl.class,
						lmisViewStaffRootOrgOrdered.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(lmisViewStaffRootOrgOrdered);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(LmisViewStaffRootOrgOrderedModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffRootOrgOrderedImpl.class,
			lmisViewStaffRootOrgOrdered.getPrimaryKey());

		return lmisViewStaffRootOrgOrdered;
	}

	public LmisViewStaffRootOrgOrdered update(
		LmisViewStaffRootOrgOrdered lmisViewStaffRootOrgOrdered)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(LmisViewStaffRootOrgOrdered lmisViewStaffRootOrgOrdered) method. Use update(LmisViewStaffRootOrgOrdered lmisViewStaffRootOrgOrdered, boolean merge) instead.");
		}

		return update(lmisViewStaffRootOrgOrdered, false);
	}

	public LmisViewStaffRootOrgOrdered update(
		LmisViewStaffRootOrgOrdered lmisViewStaffRootOrgOrdered, boolean merge)
		throws SystemException {
		boolean isNew = lmisViewStaffRootOrgOrdered.isNew();

		for (ModelListener<LmisViewStaffRootOrgOrdered> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(lmisViewStaffRootOrgOrdered);
			}
			else {
				listener.onBeforeUpdate(lmisViewStaffRootOrgOrdered);
			}
		}

		lmisViewStaffRootOrgOrdered = updateImpl(lmisViewStaffRootOrgOrdered,
				merge);

		for (ModelListener<LmisViewStaffRootOrgOrdered> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(lmisViewStaffRootOrgOrdered);
			}
			else {
				listener.onAfterUpdate(lmisViewStaffRootOrgOrdered);
			}
		}

		return lmisViewStaffRootOrgOrdered;
	}

	public LmisViewStaffRootOrgOrdered updateImpl(
		larion.progate.lmis.model.LmisViewStaffRootOrgOrdered lmisViewStaffRootOrgOrdered,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, lmisViewStaffRootOrgOrdered, merge);

			lmisViewStaffRootOrgOrdered.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(LmisViewStaffRootOrgOrderedModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffRootOrgOrderedImpl.class,
			lmisViewStaffRootOrgOrdered.getPrimaryKey(),
			lmisViewStaffRootOrgOrdered);

		return lmisViewStaffRootOrgOrdered;
	}

	public LmisViewStaffRootOrgOrdered findByPrimaryKey(
		Integer lmisViewStaffRootOrgOrderedId)
		throws NoSuchLmisViewStaffRootOrgOrderedException, SystemException {
		LmisViewStaffRootOrgOrdered lmisViewStaffRootOrgOrdered = fetchByPrimaryKey(lmisViewStaffRootOrgOrderedId);

		if (lmisViewStaffRootOrgOrdered == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"No LmisViewStaffRootOrgOrdered exists with the primary key " +
					lmisViewStaffRootOrgOrderedId);
			}

			throw new NoSuchLmisViewStaffRootOrgOrderedException(
				"No LmisViewStaffRootOrgOrdered exists with the primary key " +
				lmisViewStaffRootOrgOrderedId);
		}

		return lmisViewStaffRootOrgOrdered;
	}

	public LmisViewStaffRootOrgOrdered fetchByPrimaryKey(
		Integer lmisViewStaffRootOrgOrderedId) throws SystemException {
		LmisViewStaffRootOrgOrdered lmisViewStaffRootOrgOrdered = (LmisViewStaffRootOrgOrdered)EntityCacheUtil.getResult(LmisViewStaffRootOrgOrderedModelImpl.ENTITY_CACHE_ENABLED,
				LmisViewStaffRootOrgOrderedImpl.class,
				lmisViewStaffRootOrgOrderedId, this);

		if (lmisViewStaffRootOrgOrdered == null) {
			Session session = null;

			try {
				session = openSession();

				lmisViewStaffRootOrgOrdered = (LmisViewStaffRootOrgOrdered)session.get(LmisViewStaffRootOrgOrderedImpl.class,
						lmisViewStaffRootOrgOrderedId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (lmisViewStaffRootOrgOrdered != null) {
					cacheResult(lmisViewStaffRootOrgOrdered);
				}

				closeSession(session);
			}
		}

		return lmisViewStaffRootOrgOrdered;
	}

	public List<LmisViewStaffRootOrgOrdered> findByRootID(int rootId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		List<LmisViewStaffRootOrgOrdered> list = (List<LmisViewStaffRootOrgOrdered>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewStaffRootOrgOrdered WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("fullname ASC");

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
					list = new ArrayList<LmisViewStaffRootOrgOrdered>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewStaffRootOrgOrdered> findByRootID(int rootId,
		int start, int end) throws SystemException {
		return findByRootID(rootId, start, end, null);
	}

	public List<LmisViewStaffRootOrgOrdered> findByRootID(int rootId,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(rootId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewStaffRootOrgOrdered> list = (List<LmisViewStaffRootOrgOrdered>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewStaffRootOrgOrdered WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("fullname ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rootId);

				list = (List<LmisViewStaffRootOrgOrdered>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewStaffRootOrgOrdered>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewStaffRootOrgOrdered findByRootID_First(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisViewStaffRootOrgOrderedException, SystemException {
		List<LmisViewStaffRootOrgOrdered> list = findByRootID(rootId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewStaffRootOrgOrdered exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewStaffRootOrgOrderedException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewStaffRootOrgOrdered findByRootID_Last(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisViewStaffRootOrgOrderedException, SystemException {
		int count = countByRootID(rootId);

		List<LmisViewStaffRootOrgOrdered> list = findByRootID(rootId,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewStaffRootOrgOrdered exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewStaffRootOrgOrderedException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewStaffRootOrgOrdered[] findByRootID_PrevAndNext(
		Integer lmisViewStaffRootOrgOrderedId, int rootId, OrderByComparator obc)
		throws NoSuchLmisViewStaffRootOrgOrderedException, SystemException {
		LmisViewStaffRootOrgOrdered lmisViewStaffRootOrgOrdered = findByPrimaryKey(lmisViewStaffRootOrgOrderedId);

		int count = countByRootID(rootId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewStaffRootOrgOrdered WHERE ");

			query.append("root_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("fullname ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(rootId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisViewStaffRootOrgOrdered);

			LmisViewStaffRootOrgOrdered[] array = new LmisViewStaffRootOrgOrderedImpl[3];

			array[0] = (LmisViewStaffRootOrgOrdered)objArray[0];
			array[1] = (LmisViewStaffRootOrgOrdered)objArray[1];
			array[2] = (LmisViewStaffRootOrgOrdered)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewStaffRootOrgOrdered> findByUserId(int userId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(userId) };

		List<LmisViewStaffRootOrgOrdered> list = (List<LmisViewStaffRootOrgOrdered>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_USERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewStaffRootOrgOrdered WHERE ");

				query.append("user_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("fullname ASC");

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
					list = new ArrayList<LmisViewStaffRootOrgOrdered>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_USERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewStaffRootOrgOrdered> findByUserId(int userId,
		int start, int end) throws SystemException {
		return findByUserId(userId, start, end, null);
	}

	public List<LmisViewStaffRootOrgOrdered> findByUserId(int userId,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(userId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewStaffRootOrgOrdered> list = (List<LmisViewStaffRootOrgOrdered>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_USERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewStaffRootOrgOrdered WHERE ");

				query.append("user_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("fullname ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				list = (List<LmisViewStaffRootOrgOrdered>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewStaffRootOrgOrdered>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_USERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewStaffRootOrgOrdered findByUserId_First(int userId,
		OrderByComparator obc)
		throws NoSuchLmisViewStaffRootOrgOrderedException, SystemException {
		List<LmisViewStaffRootOrgOrdered> list = findByUserId(userId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewStaffRootOrgOrdered exists with the key {");

			msg.append("userId=" + userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewStaffRootOrgOrderedException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewStaffRootOrgOrdered findByUserId_Last(int userId,
		OrderByComparator obc)
		throws NoSuchLmisViewStaffRootOrgOrderedException, SystemException {
		int count = countByUserId(userId);

		List<LmisViewStaffRootOrgOrdered> list = findByUserId(userId,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewStaffRootOrgOrdered exists with the key {");

			msg.append("userId=" + userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewStaffRootOrgOrderedException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewStaffRootOrgOrdered[] findByUserId_PrevAndNext(
		Integer lmisViewStaffRootOrgOrderedId, int userId, OrderByComparator obc)
		throws NoSuchLmisViewStaffRootOrgOrderedException, SystemException {
		LmisViewStaffRootOrgOrdered lmisViewStaffRootOrgOrdered = findByPrimaryKey(lmisViewStaffRootOrgOrderedId);

		int count = countByUserId(userId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewStaffRootOrgOrdered WHERE ");

			query.append("user_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("fullname ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(userId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisViewStaffRootOrgOrdered);

			LmisViewStaffRootOrgOrdered[] array = new LmisViewStaffRootOrgOrderedImpl[3];

			array[0] = (LmisViewStaffRootOrgOrdered)objArray[0];
			array[1] = (LmisViewStaffRootOrgOrdered)objArray[1];
			array[2] = (LmisViewStaffRootOrgOrdered)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewStaffRootOrgOrdered> findByOrgID(int orgId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(orgId) };

		List<LmisViewStaffRootOrgOrdered> list = (List<LmisViewStaffRootOrgOrdered>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ORGID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewStaffRootOrgOrdered WHERE ");

				query.append("org_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("fullname ASC");

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
					list = new ArrayList<LmisViewStaffRootOrgOrdered>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ORGID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewStaffRootOrgOrdered> findByOrgID(int orgId, int start,
		int end) throws SystemException {
		return findByOrgID(orgId, start, end, null);
	}

	public List<LmisViewStaffRootOrgOrdered> findByOrgID(int orgId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(orgId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewStaffRootOrgOrdered> list = (List<LmisViewStaffRootOrgOrdered>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ORGID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewStaffRootOrgOrdered WHERE ");

				query.append("org_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("fullname ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orgId);

				list = (List<LmisViewStaffRootOrgOrdered>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewStaffRootOrgOrdered>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ORGID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewStaffRootOrgOrdered findByOrgID_First(int orgId,
		OrderByComparator obc)
		throws NoSuchLmisViewStaffRootOrgOrderedException, SystemException {
		List<LmisViewStaffRootOrgOrdered> list = findByOrgID(orgId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewStaffRootOrgOrdered exists with the key {");

			msg.append("orgId=" + orgId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewStaffRootOrgOrderedException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewStaffRootOrgOrdered findByOrgID_Last(int orgId,
		OrderByComparator obc)
		throws NoSuchLmisViewStaffRootOrgOrderedException, SystemException {
		int count = countByOrgID(orgId);

		List<LmisViewStaffRootOrgOrdered> list = findByOrgID(orgId, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewStaffRootOrgOrdered exists with the key {");

			msg.append("orgId=" + orgId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewStaffRootOrgOrderedException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewStaffRootOrgOrdered[] findByOrgID_PrevAndNext(
		Integer lmisViewStaffRootOrgOrderedId, int orgId, OrderByComparator obc)
		throws NoSuchLmisViewStaffRootOrgOrderedException, SystemException {
		LmisViewStaffRootOrgOrdered lmisViewStaffRootOrgOrdered = findByPrimaryKey(lmisViewStaffRootOrgOrderedId);

		int count = countByOrgID(orgId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewStaffRootOrgOrdered WHERE ");

			query.append("org_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("fullname ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(orgId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisViewStaffRootOrgOrdered);

			LmisViewStaffRootOrgOrdered[] array = new LmisViewStaffRootOrgOrderedImpl[3];

			array[0] = (LmisViewStaffRootOrgOrdered)objArray[0];
			array[1] = (LmisViewStaffRootOrgOrdered)objArray[1];
			array[2] = (LmisViewStaffRootOrgOrdered)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewStaffRootOrgOrdered> findByFullName(String fullName)
		throws SystemException {
		Object[] finderArgs = new Object[] { fullName };

		List<LmisViewStaffRootOrgOrdered> list = (List<LmisViewStaffRootOrgOrdered>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_FULLNAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewStaffRootOrgOrdered WHERE ");

				if (fullName == null) {
					query.append("fullname LIKE null");
				}
				else {
					query.append("fullname LIKE ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("fullname ASC");

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
					list = new ArrayList<LmisViewStaffRootOrgOrdered>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_FULLNAME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewStaffRootOrgOrdered> findByFullName(String fullName,
		int start, int end) throws SystemException {
		return findByFullName(fullName, start, end, null);
	}

	public List<LmisViewStaffRootOrgOrdered> findByFullName(String fullName,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				fullName,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewStaffRootOrgOrdered> list = (List<LmisViewStaffRootOrgOrdered>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_FULLNAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewStaffRootOrgOrdered WHERE ");

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

					query.append("fullname ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (fullName != null) {
					qPos.add(fullName);
				}

				list = (List<LmisViewStaffRootOrgOrdered>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewStaffRootOrgOrdered>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_FULLNAME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewStaffRootOrgOrdered findByFullName_First(String fullName,
		OrderByComparator obc)
		throws NoSuchLmisViewStaffRootOrgOrderedException, SystemException {
		List<LmisViewStaffRootOrgOrdered> list = findByFullName(fullName, 0, 1,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewStaffRootOrgOrdered exists with the key {");

			msg.append("fullName=" + fullName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewStaffRootOrgOrderedException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewStaffRootOrgOrdered findByFullName_Last(String fullName,
		OrderByComparator obc)
		throws NoSuchLmisViewStaffRootOrgOrderedException, SystemException {
		int count = countByFullName(fullName);

		List<LmisViewStaffRootOrgOrdered> list = findByFullName(fullName,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewStaffRootOrgOrdered exists with the key {");

			msg.append("fullName=" + fullName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewStaffRootOrgOrderedException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewStaffRootOrgOrdered[] findByFullName_PrevAndNext(
		Integer lmisViewStaffRootOrgOrderedId, String fullName,
		OrderByComparator obc)
		throws NoSuchLmisViewStaffRootOrgOrderedException, SystemException {
		LmisViewStaffRootOrgOrdered lmisViewStaffRootOrgOrdered = findByPrimaryKey(lmisViewStaffRootOrgOrderedId);

		int count = countByFullName(fullName);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewStaffRootOrgOrdered WHERE ");

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

				query.append("fullname ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (fullName != null) {
				qPos.add(fullName);
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisViewStaffRootOrgOrdered);

			LmisViewStaffRootOrgOrdered[] array = new LmisViewStaffRootOrgOrderedImpl[3];

			array[0] = (LmisViewStaffRootOrgOrdered)objArray[0];
			array[1] = (LmisViewStaffRootOrgOrdered)objArray[1];
			array[2] = (LmisViewStaffRootOrgOrdered)objArray[2];

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

	public List<LmisViewStaffRootOrgOrdered> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<LmisViewStaffRootOrgOrdered> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<LmisViewStaffRootOrgOrdered> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewStaffRootOrgOrdered> list = (List<LmisViewStaffRootOrgOrdered>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewStaffRootOrgOrdered ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("fullname ASC");
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<LmisViewStaffRootOrgOrdered>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LmisViewStaffRootOrgOrdered>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewStaffRootOrgOrdered>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByRootID(int rootId) throws SystemException {
		for (LmisViewStaffRootOrgOrdered lmisViewStaffRootOrgOrdered : findByRootID(
				rootId)) {
			remove(lmisViewStaffRootOrgOrdered);
		}
	}

	public void removeByUserId(int userId) throws SystemException {
		for (LmisViewStaffRootOrgOrdered lmisViewStaffRootOrgOrdered : findByUserId(
				userId)) {
			remove(lmisViewStaffRootOrgOrdered);
		}
	}

	public void removeByOrgID(int orgId) throws SystemException {
		for (LmisViewStaffRootOrgOrdered lmisViewStaffRootOrgOrdered : findByOrgID(
				orgId)) {
			remove(lmisViewStaffRootOrgOrdered);
		}
	}

	public void removeByFullName(String fullName) throws SystemException {
		for (LmisViewStaffRootOrgOrdered lmisViewStaffRootOrgOrdered : findByFullName(
				fullName)) {
			remove(lmisViewStaffRootOrgOrdered);
		}
	}

	public void removeAll() throws SystemException {
		for (LmisViewStaffRootOrgOrdered lmisViewStaffRootOrgOrdered : findAll()) {
			remove(lmisViewStaffRootOrgOrdered);
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
					"FROM larion.progate.lmis.model.LmisViewStaffRootOrgOrdered WHERE ");

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
					"FROM larion.progate.lmis.model.LmisViewStaffRootOrgOrdered WHERE ");

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
					"FROM larion.progate.lmis.model.LmisViewStaffRootOrgOrdered WHERE ");

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
					"FROM larion.progate.lmis.model.LmisViewStaffRootOrgOrdered WHERE ");

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
						"SELECT COUNT(*) FROM larion.progate.lmis.model.LmisViewStaffRootOrgOrdered");

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
						"value.object.listener.larion.progate.lmis.model.LmisViewStaffRootOrgOrdered")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LmisViewStaffRootOrgOrdered>> listenersList = new ArrayList<ModelListener<LmisViewStaffRootOrgOrdered>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LmisViewStaffRootOrgOrdered>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(LmisViewStaffRootOrgOrderedPersistenceImpl.class);
}