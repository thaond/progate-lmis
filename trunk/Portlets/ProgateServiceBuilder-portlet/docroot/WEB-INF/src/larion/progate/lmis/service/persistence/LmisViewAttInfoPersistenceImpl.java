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
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import larion.progate.lmis.NoSuchLmisViewAttInfoException;
import larion.progate.lmis.model.LmisViewAttInfo;
import larion.progate.lmis.model.impl.LmisViewAttInfoImpl;
import larion.progate.lmis.model.impl.LmisViewAttInfoModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * <a href="LmisViewAttInfoPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewAttInfoPersistenceImpl extends BasePersistenceImpl
	implements LmisViewAttInfoPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = LmisViewAttInfoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_ROOTID = new FinderPath(LmisViewAttInfoModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewAttInfoModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ROOTID = new FinderPath(LmisViewAttInfoModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewAttInfoModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ROOTID = new FinderPath(LmisViewAttInfoModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewAttInfoModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByRootId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_USERID = new FinderPath(LmisViewAttInfoModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewAttInfoModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByUserId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_USERID = new FinderPath(LmisViewAttInfoModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewAttInfoModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByUserId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(LmisViewAttInfoModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewAttInfoModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByUserId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_DAYVALUE = new FinderPath(LmisViewAttInfoModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewAttInfoModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByDayValue",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_DAYVALUE = new FinderPath(LmisViewAttInfoModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewAttInfoModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByDayValue",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_DAYVALUE = new FinderPath(LmisViewAttInfoModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewAttInfoModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByDayValue",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_FULLNAME = new FinderPath(LmisViewAttInfoModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewAttInfoModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByFullName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_FULLNAME = new FinderPath(LmisViewAttInfoModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewAttInfoModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByFullName",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_FULLNAME = new FinderPath(LmisViewAttInfoModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewAttInfoModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByFullName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(LmisViewAttInfoModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewAttInfoModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LmisViewAttInfoModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewAttInfoModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(LmisViewAttInfo lmisViewAttInfo) {
		EntityCacheUtil.putResult(LmisViewAttInfoModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewAttInfoImpl.class, lmisViewAttInfo.getPrimaryKey(),
			lmisViewAttInfo);
	}

	public void cacheResult(List<LmisViewAttInfo> lmisViewAttInfos) {
		for (LmisViewAttInfo lmisViewAttInfo : lmisViewAttInfos) {
			if (EntityCacheUtil.getResult(
						LmisViewAttInfoModelImpl.ENTITY_CACHE_ENABLED,
						LmisViewAttInfoImpl.class,
						lmisViewAttInfo.getPrimaryKey(), this) == null) {
				cacheResult(lmisViewAttInfo);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(LmisViewAttInfoImpl.class.getName());
		EntityCacheUtil.clearCache(LmisViewAttInfoImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public LmisViewAttInfo create(Integer lmisViewAttInfoId) {
		LmisViewAttInfo lmisViewAttInfo = new LmisViewAttInfoImpl();

		lmisViewAttInfo.setNew(true);
		lmisViewAttInfo.setPrimaryKey(lmisViewAttInfoId);

		return lmisViewAttInfo;
	}

	public LmisViewAttInfo remove(Integer lmisViewAttInfoId)
		throws NoSuchLmisViewAttInfoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LmisViewAttInfo lmisViewAttInfo = (LmisViewAttInfo)session.get(LmisViewAttInfoImpl.class,
					lmisViewAttInfoId);

			if (lmisViewAttInfo == null) {
				if (_log.isWarnEnabled()) {
					_log.warn("No LmisViewAttInfo exists with the primary key " +
						lmisViewAttInfoId);
				}

				throw new NoSuchLmisViewAttInfoException(
					"No LmisViewAttInfo exists with the primary key " +
					lmisViewAttInfoId);
			}

			return remove(lmisViewAttInfo);
		}
		catch (NoSuchLmisViewAttInfoException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public LmisViewAttInfo remove(LmisViewAttInfo lmisViewAttInfo)
		throws SystemException {
		for (ModelListener<LmisViewAttInfo> listener : listeners) {
			listener.onBeforeRemove(lmisViewAttInfo);
		}

		lmisViewAttInfo = removeImpl(lmisViewAttInfo);

		for (ModelListener<LmisViewAttInfo> listener : listeners) {
			listener.onAfterRemove(lmisViewAttInfo);
		}

		return lmisViewAttInfo;
	}

	protected LmisViewAttInfo removeImpl(LmisViewAttInfo lmisViewAttInfo)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (lmisViewAttInfo.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(LmisViewAttInfoImpl.class,
						lmisViewAttInfo.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(lmisViewAttInfo);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(LmisViewAttInfoModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewAttInfoImpl.class, lmisViewAttInfo.getPrimaryKey());

		return lmisViewAttInfo;
	}

	public LmisViewAttInfo update(LmisViewAttInfo lmisViewAttInfo)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(LmisViewAttInfo lmisViewAttInfo) method. Use update(LmisViewAttInfo lmisViewAttInfo, boolean merge) instead.");
		}

		return update(lmisViewAttInfo, false);
	}

	public LmisViewAttInfo update(LmisViewAttInfo lmisViewAttInfo, boolean merge)
		throws SystemException {
		boolean isNew = lmisViewAttInfo.isNew();

		for (ModelListener<LmisViewAttInfo> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(lmisViewAttInfo);
			}
			else {
				listener.onBeforeUpdate(lmisViewAttInfo);
			}
		}

		lmisViewAttInfo = updateImpl(lmisViewAttInfo, merge);

		for (ModelListener<LmisViewAttInfo> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(lmisViewAttInfo);
			}
			else {
				listener.onAfterUpdate(lmisViewAttInfo);
			}
		}

		return lmisViewAttInfo;
	}

	public LmisViewAttInfo updateImpl(
		larion.progate.lmis.model.LmisViewAttInfo lmisViewAttInfo, boolean merge)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, lmisViewAttInfo, merge);

			lmisViewAttInfo.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(LmisViewAttInfoModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewAttInfoImpl.class, lmisViewAttInfo.getPrimaryKey(),
			lmisViewAttInfo);

		return lmisViewAttInfo;
	}

	public LmisViewAttInfo findByPrimaryKey(Integer lmisViewAttInfoId)
		throws NoSuchLmisViewAttInfoException, SystemException {
		LmisViewAttInfo lmisViewAttInfo = fetchByPrimaryKey(lmisViewAttInfoId);

		if (lmisViewAttInfo == null) {
			if (_log.isWarnEnabled()) {
				_log.warn("No LmisViewAttInfo exists with the primary key " +
					lmisViewAttInfoId);
			}

			throw new NoSuchLmisViewAttInfoException(
				"No LmisViewAttInfo exists with the primary key " +
				lmisViewAttInfoId);
		}

		return lmisViewAttInfo;
	}

	public LmisViewAttInfo fetchByPrimaryKey(Integer lmisViewAttInfoId)
		throws SystemException {
		LmisViewAttInfo lmisViewAttInfo = (LmisViewAttInfo)EntityCacheUtil.getResult(LmisViewAttInfoModelImpl.ENTITY_CACHE_ENABLED,
				LmisViewAttInfoImpl.class, lmisViewAttInfoId, this);

		if (lmisViewAttInfo == null) {
			Session session = null;

			try {
				session = openSession();

				lmisViewAttInfo = (LmisViewAttInfo)session.get(LmisViewAttInfoImpl.class,
						lmisViewAttInfoId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (lmisViewAttInfo != null) {
					cacheResult(lmisViewAttInfo);
				}

				closeSession(session);
			}
		}

		return lmisViewAttInfo;
	}

	public List<LmisViewAttInfo> findByRootId(int rootId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		List<LmisViewAttInfo> list = (List<LmisViewAttInfo>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewAttInfo WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

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
					list = new ArrayList<LmisViewAttInfo>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewAttInfo> findByRootId(int rootId, int start, int end)
		throws SystemException {
		return findByRootId(rootId, start, end, null);
	}

	public List<LmisViewAttInfo> findByRootId(int rootId, int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(rootId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewAttInfo> list = (List<LmisViewAttInfo>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewAttInfo WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("created_at DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rootId);

				list = (List<LmisViewAttInfo>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewAttInfo>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewAttInfo findByRootId_First(int rootId, OrderByComparator obc)
		throws NoSuchLmisViewAttInfoException, SystemException {
		List<LmisViewAttInfo> list = findByRootId(rootId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewAttInfo exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewAttInfoException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewAttInfo findByRootId_Last(int rootId, OrderByComparator obc)
		throws NoSuchLmisViewAttInfoException, SystemException {
		int count = countByRootId(rootId);

		List<LmisViewAttInfo> list = findByRootId(rootId, count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewAttInfo exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewAttInfoException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewAttInfo[] findByRootId_PrevAndNext(
		Integer lmisViewAttInfoId, int rootId, OrderByComparator obc)
		throws NoSuchLmisViewAttInfoException, SystemException {
		LmisViewAttInfo lmisViewAttInfo = findByPrimaryKey(lmisViewAttInfoId);

		int count = countByRootId(rootId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewAttInfo WHERE ");

			query.append("root_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("created_at DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(rootId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisViewAttInfo);

			LmisViewAttInfo[] array = new LmisViewAttInfoImpl[3];

			array[0] = (LmisViewAttInfo)objArray[0];
			array[1] = (LmisViewAttInfo)objArray[1];
			array[2] = (LmisViewAttInfo)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewAttInfo> findByUserId(int userId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(userId) };

		List<LmisViewAttInfo> list = (List<LmisViewAttInfo>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_USERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewAttInfo WHERE ");

				query.append("user_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("created_at DESC");

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
					list = new ArrayList<LmisViewAttInfo>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_USERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewAttInfo> findByUserId(int userId, int start, int end)
		throws SystemException {
		return findByUserId(userId, start, end, null);
	}

	public List<LmisViewAttInfo> findByUserId(int userId, int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(userId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewAttInfo> list = (List<LmisViewAttInfo>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_USERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewAttInfo WHERE ");

				query.append("user_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("created_at DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				list = (List<LmisViewAttInfo>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewAttInfo>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_USERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewAttInfo findByUserId_First(int userId, OrderByComparator obc)
		throws NoSuchLmisViewAttInfoException, SystemException {
		List<LmisViewAttInfo> list = findByUserId(userId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewAttInfo exists with the key {");

			msg.append("userId=" + userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewAttInfoException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewAttInfo findByUserId_Last(int userId, OrderByComparator obc)
		throws NoSuchLmisViewAttInfoException, SystemException {
		int count = countByUserId(userId);

		List<LmisViewAttInfo> list = findByUserId(userId, count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewAttInfo exists with the key {");

			msg.append("userId=" + userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewAttInfoException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewAttInfo[] findByUserId_PrevAndNext(
		Integer lmisViewAttInfoId, int userId, OrderByComparator obc)
		throws NoSuchLmisViewAttInfoException, SystemException {
		LmisViewAttInfo lmisViewAttInfo = findByPrimaryKey(lmisViewAttInfoId);

		int count = countByUserId(userId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewAttInfo WHERE ");

			query.append("user_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("created_at DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(userId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisViewAttInfo);

			LmisViewAttInfo[] array = new LmisViewAttInfoImpl[3];

			array[0] = (LmisViewAttInfo)objArray[0];
			array[1] = (LmisViewAttInfo)objArray[1];
			array[2] = (LmisViewAttInfo)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewAttInfo> findByDayValue(Date dayValue)
		throws SystemException {
		Object[] finderArgs = new Object[] { dayValue };

		List<LmisViewAttInfo> list = (List<LmisViewAttInfo>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DAYVALUE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewAttInfo WHERE ");

				if (dayValue == null) {
					query.append("day_value IS NULL");
				}
				else {
					query.append("day_value = ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("created_at DESC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (dayValue != null) {
					qPos.add(CalendarUtil.getTimestamp(dayValue));
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewAttInfo>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DAYVALUE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewAttInfo> findByDayValue(Date dayValue, int start,
		int end) throws SystemException {
		return findByDayValue(dayValue, start, end, null);
	}

	public List<LmisViewAttInfo> findByDayValue(Date dayValue, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				dayValue,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewAttInfo> list = (List<LmisViewAttInfo>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_DAYVALUE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewAttInfo WHERE ");

				if (dayValue == null) {
					query.append("day_value IS NULL");
				}
				else {
					query.append("day_value = ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("created_at DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (dayValue != null) {
					qPos.add(CalendarUtil.getTimestamp(dayValue));
				}

				list = (List<LmisViewAttInfo>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewAttInfo>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_DAYVALUE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewAttInfo findByDayValue_First(Date dayValue,
		OrderByComparator obc)
		throws NoSuchLmisViewAttInfoException, SystemException {
		List<LmisViewAttInfo> list = findByDayValue(dayValue, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewAttInfo exists with the key {");

			msg.append("dayValue=" + dayValue);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewAttInfoException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewAttInfo findByDayValue_Last(Date dayValue,
		OrderByComparator obc)
		throws NoSuchLmisViewAttInfoException, SystemException {
		int count = countByDayValue(dayValue);

		List<LmisViewAttInfo> list = findByDayValue(dayValue, count - 1, count,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewAttInfo exists with the key {");

			msg.append("dayValue=" + dayValue);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewAttInfoException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewAttInfo[] findByDayValue_PrevAndNext(
		Integer lmisViewAttInfoId, Date dayValue, OrderByComparator obc)
		throws NoSuchLmisViewAttInfoException, SystemException {
		LmisViewAttInfo lmisViewAttInfo = findByPrimaryKey(lmisViewAttInfoId);

		int count = countByDayValue(dayValue);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewAttInfo WHERE ");

			if (dayValue == null) {
				query.append("day_value IS NULL");
			}
			else {
				query.append("day_value = ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("created_at DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (dayValue != null) {
				qPos.add(CalendarUtil.getTimestamp(dayValue));
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisViewAttInfo);

			LmisViewAttInfo[] array = new LmisViewAttInfoImpl[3];

			array[0] = (LmisViewAttInfo)objArray[0];
			array[1] = (LmisViewAttInfo)objArray[1];
			array[2] = (LmisViewAttInfo)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewAttInfo> findByFullName(String fullName)
		throws SystemException {
		Object[] finderArgs = new Object[] { fullName };

		List<LmisViewAttInfo> list = (List<LmisViewAttInfo>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_FULLNAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewAttInfo WHERE ");

				if (fullName == null) {
					query.append("full_name LIKE null");
				}
				else {
					query.append("full_name LIKE ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("created_at DESC");

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
					list = new ArrayList<LmisViewAttInfo>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_FULLNAME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewAttInfo> findByFullName(String fullName, int start,
		int end) throws SystemException {
		return findByFullName(fullName, start, end, null);
	}

	public List<LmisViewAttInfo> findByFullName(String fullName, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				fullName,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewAttInfo> list = (List<LmisViewAttInfo>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_FULLNAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewAttInfo WHERE ");

				if (fullName == null) {
					query.append("full_name LIKE null");
				}
				else {
					query.append("full_name LIKE ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("created_at DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (fullName != null) {
					qPos.add(fullName);
				}

				list = (List<LmisViewAttInfo>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewAttInfo>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_FULLNAME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewAttInfo findByFullName_First(String fullName,
		OrderByComparator obc)
		throws NoSuchLmisViewAttInfoException, SystemException {
		List<LmisViewAttInfo> list = findByFullName(fullName, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewAttInfo exists with the key {");

			msg.append("fullName=" + fullName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewAttInfoException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewAttInfo findByFullName_Last(String fullName,
		OrderByComparator obc)
		throws NoSuchLmisViewAttInfoException, SystemException {
		int count = countByFullName(fullName);

		List<LmisViewAttInfo> list = findByFullName(fullName, count - 1, count,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewAttInfo exists with the key {");

			msg.append("fullName=" + fullName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewAttInfoException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewAttInfo[] findByFullName_PrevAndNext(
		Integer lmisViewAttInfoId, String fullName, OrderByComparator obc)
		throws NoSuchLmisViewAttInfoException, SystemException {
		LmisViewAttInfo lmisViewAttInfo = findByPrimaryKey(lmisViewAttInfoId);

		int count = countByFullName(fullName);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewAttInfo WHERE ");

			if (fullName == null) {
				query.append("full_name LIKE null");
			}
			else {
				query.append("full_name LIKE ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("created_at DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (fullName != null) {
				qPos.add(fullName);
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisViewAttInfo);

			LmisViewAttInfo[] array = new LmisViewAttInfoImpl[3];

			array[0] = (LmisViewAttInfo)objArray[0];
			array[1] = (LmisViewAttInfo)objArray[1];
			array[2] = (LmisViewAttInfo)objArray[2];

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

	public List<LmisViewAttInfo> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<LmisViewAttInfo> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<LmisViewAttInfo> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewAttInfo> list = (List<LmisViewAttInfo>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.lmis.model.LmisViewAttInfo ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("created_at DESC");
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<LmisViewAttInfo>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LmisViewAttInfo>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewAttInfo>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByRootId(int rootId) throws SystemException {
		for (LmisViewAttInfo lmisViewAttInfo : findByRootId(rootId)) {
			remove(lmisViewAttInfo);
		}
	}

	public void removeByUserId(int userId) throws SystemException {
		for (LmisViewAttInfo lmisViewAttInfo : findByUserId(userId)) {
			remove(lmisViewAttInfo);
		}
	}

	public void removeByDayValue(Date dayValue) throws SystemException {
		for (LmisViewAttInfo lmisViewAttInfo : findByDayValue(dayValue)) {
			remove(lmisViewAttInfo);
		}
	}

	public void removeByFullName(String fullName) throws SystemException {
		for (LmisViewAttInfo lmisViewAttInfo : findByFullName(fullName)) {
			remove(lmisViewAttInfo);
		}
	}

	public void removeAll() throws SystemException {
		for (LmisViewAttInfo lmisViewAttInfo : findAll()) {
			remove(lmisViewAttInfo);
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
					"FROM larion.progate.lmis.model.LmisViewAttInfo WHERE ");

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
					"FROM larion.progate.lmis.model.LmisViewAttInfo WHERE ");

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

	public int countByDayValue(Date dayValue) throws SystemException {
		Object[] finderArgs = new Object[] { dayValue };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DAYVALUE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisViewAttInfo WHERE ");

				if (dayValue == null) {
					query.append("day_value IS NULL");
				}
				else {
					query.append("day_value = ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (dayValue != null) {
					qPos.add(CalendarUtil.getTimestamp(dayValue));
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DAYVALUE,
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
					"FROM larion.progate.lmis.model.LmisViewAttInfo WHERE ");

				if (fullName == null) {
					query.append("full_name LIKE null");
				}
				else {
					query.append("full_name LIKE ?");
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
						"SELECT COUNT(*) FROM larion.progate.lmis.model.LmisViewAttInfo");

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
						"value.object.listener.larion.progate.lmis.model.LmisViewAttInfo")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LmisViewAttInfo>> listenersList = new ArrayList<ModelListener<LmisViewAttInfo>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LmisViewAttInfo>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(LmisViewAttInfoPersistenceImpl.class);
}