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

import larion.progate.lmis.NoSuchLmisViewStaffMappingPmException;
import larion.progate.lmis.model.LmisViewStaffMappingPm;
import larion.progate.lmis.model.impl.LmisViewStaffMappingPmImpl;
import larion.progate.lmis.model.impl.LmisViewStaffMappingPmModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="LmisViewStaffMappingPmPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewStaffMappingPmPersistenceImpl extends BasePersistenceImpl
	implements LmisViewStaffMappingPmPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = LmisViewStaffMappingPmImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_STAFFUID = new FinderPath(LmisViewStaffMappingPmModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffMappingPmModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByStaffUID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_STAFFUID = new FinderPath(LmisViewStaffMappingPmModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffMappingPmModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByStaffUID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_STAFFUID = new FinderPath(LmisViewStaffMappingPmModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffMappingPmModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByStaffUID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ROOTID = new FinderPath(LmisViewStaffMappingPmModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffMappingPmModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ROOTID = new FinderPath(LmisViewStaffMappingPmModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffMappingPmModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ROOTID = new FinderPath(LmisViewStaffMappingPmModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffMappingPmModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByRootID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_PMUID = new FinderPath(LmisViewStaffMappingPmModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffMappingPmModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByPmUID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_PMUID = new FinderPath(LmisViewStaffMappingPmModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffMappingPmModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByPmUID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_PMUID = new FinderPath(LmisViewStaffMappingPmModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffMappingPmModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByPmUID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_BODID = new FinderPath(LmisViewStaffMappingPmModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffMappingPmModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByBodId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_BODID = new FinderPath(LmisViewStaffMappingPmModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffMappingPmModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByBodId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_BODID = new FinderPath(LmisViewStaffMappingPmModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffMappingPmModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByBodId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(LmisViewStaffMappingPmModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffMappingPmModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LmisViewStaffMappingPmModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffMappingPmModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(LmisViewStaffMappingPm lmisViewStaffMappingPm) {
		EntityCacheUtil.putResult(LmisViewStaffMappingPmModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffMappingPmImpl.class,
			lmisViewStaffMappingPm.getPrimaryKey(), lmisViewStaffMappingPm);
	}

	public void cacheResult(
		List<LmisViewStaffMappingPm> lmisViewStaffMappingPms) {
		for (LmisViewStaffMappingPm lmisViewStaffMappingPm : lmisViewStaffMappingPms) {
			if (EntityCacheUtil.getResult(
						LmisViewStaffMappingPmModelImpl.ENTITY_CACHE_ENABLED,
						LmisViewStaffMappingPmImpl.class,
						lmisViewStaffMappingPm.getPrimaryKey(), this) == null) {
				cacheResult(lmisViewStaffMappingPm);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(LmisViewStaffMappingPmImpl.class.getName());
		EntityCacheUtil.clearCache(LmisViewStaffMappingPmImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public LmisViewStaffMappingPm create(Integer lmisViewStaffMappingPmId) {
		LmisViewStaffMappingPm lmisViewStaffMappingPm = new LmisViewStaffMappingPmImpl();

		lmisViewStaffMappingPm.setNew(true);
		lmisViewStaffMappingPm.setPrimaryKey(lmisViewStaffMappingPmId);

		return lmisViewStaffMappingPm;
	}

	public LmisViewStaffMappingPm remove(Integer lmisViewStaffMappingPmId)
		throws NoSuchLmisViewStaffMappingPmException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LmisViewStaffMappingPm lmisViewStaffMappingPm = (LmisViewStaffMappingPm)session.get(LmisViewStaffMappingPmImpl.class,
					lmisViewStaffMappingPmId);

			if (lmisViewStaffMappingPm == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No LmisViewStaffMappingPm exists with the primary key " +
						lmisViewStaffMappingPmId);
				}

				throw new NoSuchLmisViewStaffMappingPmException(
					"No LmisViewStaffMappingPm exists with the primary key " +
					lmisViewStaffMappingPmId);
			}

			return remove(lmisViewStaffMappingPm);
		}
		catch (NoSuchLmisViewStaffMappingPmException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public LmisViewStaffMappingPm remove(
		LmisViewStaffMappingPm lmisViewStaffMappingPm)
		throws SystemException {
		for (ModelListener<LmisViewStaffMappingPm> listener : listeners) {
			listener.onBeforeRemove(lmisViewStaffMappingPm);
		}

		lmisViewStaffMappingPm = removeImpl(lmisViewStaffMappingPm);

		for (ModelListener<LmisViewStaffMappingPm> listener : listeners) {
			listener.onAfterRemove(lmisViewStaffMappingPm);
		}

		return lmisViewStaffMappingPm;
	}

	protected LmisViewStaffMappingPm removeImpl(
		LmisViewStaffMappingPm lmisViewStaffMappingPm)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (lmisViewStaffMappingPm.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(LmisViewStaffMappingPmImpl.class,
						lmisViewStaffMappingPm.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(lmisViewStaffMappingPm);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(LmisViewStaffMappingPmModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffMappingPmImpl.class,
			lmisViewStaffMappingPm.getPrimaryKey());

		return lmisViewStaffMappingPm;
	}

	public LmisViewStaffMappingPm update(
		LmisViewStaffMappingPm lmisViewStaffMappingPm)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(LmisViewStaffMappingPm lmisViewStaffMappingPm) method. Use update(LmisViewStaffMappingPm lmisViewStaffMappingPm, boolean merge) instead.");
		}

		return update(lmisViewStaffMappingPm, false);
	}

	public LmisViewStaffMappingPm update(
		LmisViewStaffMappingPm lmisViewStaffMappingPm, boolean merge)
		throws SystemException {
		boolean isNew = lmisViewStaffMappingPm.isNew();

		for (ModelListener<LmisViewStaffMappingPm> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(lmisViewStaffMappingPm);
			}
			else {
				listener.onBeforeUpdate(lmisViewStaffMappingPm);
			}
		}

		lmisViewStaffMappingPm = updateImpl(lmisViewStaffMappingPm, merge);

		for (ModelListener<LmisViewStaffMappingPm> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(lmisViewStaffMappingPm);
			}
			else {
				listener.onAfterUpdate(lmisViewStaffMappingPm);
			}
		}

		return lmisViewStaffMappingPm;
	}

	public LmisViewStaffMappingPm updateImpl(
		larion.progate.lmis.model.LmisViewStaffMappingPm lmisViewStaffMappingPm,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, lmisViewStaffMappingPm, merge);

			lmisViewStaffMappingPm.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(LmisViewStaffMappingPmModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffMappingPmImpl.class,
			lmisViewStaffMappingPm.getPrimaryKey(), lmisViewStaffMappingPm);

		return lmisViewStaffMappingPm;
	}

	public LmisViewStaffMappingPm findByPrimaryKey(
		Integer lmisViewStaffMappingPmId)
		throws NoSuchLmisViewStaffMappingPmException, SystemException {
		LmisViewStaffMappingPm lmisViewStaffMappingPm = fetchByPrimaryKey(lmisViewStaffMappingPmId);

		if (lmisViewStaffMappingPm == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"No LmisViewStaffMappingPm exists with the primary key " +
					lmisViewStaffMappingPmId);
			}

			throw new NoSuchLmisViewStaffMappingPmException(
				"No LmisViewStaffMappingPm exists with the primary key " +
				lmisViewStaffMappingPmId);
		}

		return lmisViewStaffMappingPm;
	}

	public LmisViewStaffMappingPm fetchByPrimaryKey(
		Integer lmisViewStaffMappingPmId) throws SystemException {
		LmisViewStaffMappingPm lmisViewStaffMappingPm = (LmisViewStaffMappingPm)EntityCacheUtil.getResult(LmisViewStaffMappingPmModelImpl.ENTITY_CACHE_ENABLED,
				LmisViewStaffMappingPmImpl.class, lmisViewStaffMappingPmId, this);

		if (lmisViewStaffMappingPm == null) {
			Session session = null;

			try {
				session = openSession();

				lmisViewStaffMappingPm = (LmisViewStaffMappingPm)session.get(LmisViewStaffMappingPmImpl.class,
						lmisViewStaffMappingPmId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (lmisViewStaffMappingPm != null) {
					cacheResult(lmisViewStaffMappingPm);
				}

				closeSession(session);
			}
		}

		return lmisViewStaffMappingPm;
	}

	public List<LmisViewStaffMappingPm> findByStaffUID(int staffUID)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(staffUID) };

		List<LmisViewStaffMappingPm> list = (List<LmisViewStaffMappingPm>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_STAFFUID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewStaffMappingPm WHERE ");

				query.append("staff_uid = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(staffUID);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewStaffMappingPm>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_STAFFUID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewStaffMappingPm> findByStaffUID(int staffUID, int start,
		int end) throws SystemException {
		return findByStaffUID(staffUID, start, end, null);
	}

	public List<LmisViewStaffMappingPm> findByStaffUID(int staffUID, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(staffUID),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewStaffMappingPm> list = (List<LmisViewStaffMappingPm>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_STAFFUID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewStaffMappingPm WHERE ");

				query.append("staff_uid = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(staffUID);

				list = (List<LmisViewStaffMappingPm>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewStaffMappingPm>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_STAFFUID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewStaffMappingPm findByStaffUID_First(int staffUID,
		OrderByComparator obc)
		throws NoSuchLmisViewStaffMappingPmException, SystemException {
		List<LmisViewStaffMappingPm> list = findByStaffUID(staffUID, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewStaffMappingPm exists with the key {");

			msg.append("staffUID=" + staffUID);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewStaffMappingPmException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewStaffMappingPm findByStaffUID_Last(int staffUID,
		OrderByComparator obc)
		throws NoSuchLmisViewStaffMappingPmException, SystemException {
		int count = countByStaffUID(staffUID);

		List<LmisViewStaffMappingPm> list = findByStaffUID(staffUID, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewStaffMappingPm exists with the key {");

			msg.append("staffUID=" + staffUID);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewStaffMappingPmException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewStaffMappingPm[] findByStaffUID_PrevAndNext(
		Integer lmisViewStaffMappingPmId, int staffUID, OrderByComparator obc)
		throws NoSuchLmisViewStaffMappingPmException, SystemException {
		LmisViewStaffMappingPm lmisViewStaffMappingPm = findByPrimaryKey(lmisViewStaffMappingPmId);

		int count = countByStaffUID(staffUID);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewStaffMappingPm WHERE ");

			query.append("staff_uid = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(staffUID);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisViewStaffMappingPm);

			LmisViewStaffMappingPm[] array = new LmisViewStaffMappingPmImpl[3];

			array[0] = (LmisViewStaffMappingPm)objArray[0];
			array[1] = (LmisViewStaffMappingPm)objArray[1];
			array[2] = (LmisViewStaffMappingPm)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewStaffMappingPm> findByRootID(int rootId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		List<LmisViewStaffMappingPm> list = (List<LmisViewStaffMappingPm>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewStaffMappingPm WHERE ");

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
					list = new ArrayList<LmisViewStaffMappingPm>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewStaffMappingPm> findByRootID(int rootId, int start,
		int end) throws SystemException {
		return findByRootID(rootId, start, end, null);
	}

	public List<LmisViewStaffMappingPm> findByRootID(int rootId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(rootId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewStaffMappingPm> list = (List<LmisViewStaffMappingPm>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewStaffMappingPm WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rootId);

				list = (List<LmisViewStaffMappingPm>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewStaffMappingPm>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewStaffMappingPm findByRootID_First(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisViewStaffMappingPmException, SystemException {
		List<LmisViewStaffMappingPm> list = findByRootID(rootId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewStaffMappingPm exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewStaffMappingPmException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewStaffMappingPm findByRootID_Last(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisViewStaffMappingPmException, SystemException {
		int count = countByRootID(rootId);

		List<LmisViewStaffMappingPm> list = findByRootID(rootId, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewStaffMappingPm exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewStaffMappingPmException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewStaffMappingPm[] findByRootID_PrevAndNext(
		Integer lmisViewStaffMappingPmId, int rootId, OrderByComparator obc)
		throws NoSuchLmisViewStaffMappingPmException, SystemException {
		LmisViewStaffMappingPm lmisViewStaffMappingPm = findByPrimaryKey(lmisViewStaffMappingPmId);

		int count = countByRootID(rootId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewStaffMappingPm WHERE ");

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
					lmisViewStaffMappingPm);

			LmisViewStaffMappingPm[] array = new LmisViewStaffMappingPmImpl[3];

			array[0] = (LmisViewStaffMappingPm)objArray[0];
			array[1] = (LmisViewStaffMappingPm)objArray[1];
			array[2] = (LmisViewStaffMappingPm)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewStaffMappingPm> findByPmUID(int pmUID)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(pmUID) };

		List<LmisViewStaffMappingPm> list = (List<LmisViewStaffMappingPm>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_PMUID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewStaffMappingPm WHERE ");

				query.append("pm_uid = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pmUID);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewStaffMappingPm>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_PMUID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewStaffMappingPm> findByPmUID(int pmUID, int start,
		int end) throws SystemException {
		return findByPmUID(pmUID, start, end, null);
	}

	public List<LmisViewStaffMappingPm> findByPmUID(int pmUID, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(pmUID),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewStaffMappingPm> list = (List<LmisViewStaffMappingPm>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_PMUID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewStaffMappingPm WHERE ");

				query.append("pm_uid = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pmUID);

				list = (List<LmisViewStaffMappingPm>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewStaffMappingPm>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_PMUID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewStaffMappingPm findByPmUID_First(int pmUID,
		OrderByComparator obc)
		throws NoSuchLmisViewStaffMappingPmException, SystemException {
		List<LmisViewStaffMappingPm> list = findByPmUID(pmUID, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewStaffMappingPm exists with the key {");

			msg.append("pmUID=" + pmUID);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewStaffMappingPmException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewStaffMappingPm findByPmUID_Last(int pmUID,
		OrderByComparator obc)
		throws NoSuchLmisViewStaffMappingPmException, SystemException {
		int count = countByPmUID(pmUID);

		List<LmisViewStaffMappingPm> list = findByPmUID(pmUID, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewStaffMappingPm exists with the key {");

			msg.append("pmUID=" + pmUID);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewStaffMappingPmException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewStaffMappingPm[] findByPmUID_PrevAndNext(
		Integer lmisViewStaffMappingPmId, int pmUID, OrderByComparator obc)
		throws NoSuchLmisViewStaffMappingPmException, SystemException {
		LmisViewStaffMappingPm lmisViewStaffMappingPm = findByPrimaryKey(lmisViewStaffMappingPmId);

		int count = countByPmUID(pmUID);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewStaffMappingPm WHERE ");

			query.append("pm_uid = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(pmUID);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisViewStaffMappingPm);

			LmisViewStaffMappingPm[] array = new LmisViewStaffMappingPmImpl[3];

			array[0] = (LmisViewStaffMappingPm)objArray[0];
			array[1] = (LmisViewStaffMappingPm)objArray[1];
			array[2] = (LmisViewStaffMappingPm)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewStaffMappingPm> findByBodId(int bodId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(bodId) };

		List<LmisViewStaffMappingPm> list = (List<LmisViewStaffMappingPm>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_BODID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewStaffMappingPm WHERE ");

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
					list = new ArrayList<LmisViewStaffMappingPm>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_BODID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewStaffMappingPm> findByBodId(int bodId, int start,
		int end) throws SystemException {
		return findByBodId(bodId, start, end, null);
	}

	public List<LmisViewStaffMappingPm> findByBodId(int bodId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(bodId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewStaffMappingPm> list = (List<LmisViewStaffMappingPm>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_BODID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewStaffMappingPm WHERE ");

				query.append("bod_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(bodId);

				list = (List<LmisViewStaffMappingPm>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewStaffMappingPm>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_BODID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewStaffMappingPm findByBodId_First(int bodId,
		OrderByComparator obc)
		throws NoSuchLmisViewStaffMappingPmException, SystemException {
		List<LmisViewStaffMappingPm> list = findByBodId(bodId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewStaffMappingPm exists with the key {");

			msg.append("bodId=" + bodId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewStaffMappingPmException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewStaffMappingPm findByBodId_Last(int bodId,
		OrderByComparator obc)
		throws NoSuchLmisViewStaffMappingPmException, SystemException {
		int count = countByBodId(bodId);

		List<LmisViewStaffMappingPm> list = findByBodId(bodId, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewStaffMappingPm exists with the key {");

			msg.append("bodId=" + bodId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewStaffMappingPmException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewStaffMappingPm[] findByBodId_PrevAndNext(
		Integer lmisViewStaffMappingPmId, int bodId, OrderByComparator obc)
		throws NoSuchLmisViewStaffMappingPmException, SystemException {
		LmisViewStaffMappingPm lmisViewStaffMappingPm = findByPrimaryKey(lmisViewStaffMappingPmId);

		int count = countByBodId(bodId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewStaffMappingPm WHERE ");

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
					lmisViewStaffMappingPm);

			LmisViewStaffMappingPm[] array = new LmisViewStaffMappingPmImpl[3];

			array[0] = (LmisViewStaffMappingPm)objArray[0];
			array[1] = (LmisViewStaffMappingPm)objArray[1];
			array[2] = (LmisViewStaffMappingPm)objArray[2];

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

	public List<LmisViewStaffMappingPm> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<LmisViewStaffMappingPm> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<LmisViewStaffMappingPm> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewStaffMappingPm> list = (List<LmisViewStaffMappingPm>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewStaffMappingPm ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<LmisViewStaffMappingPm>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LmisViewStaffMappingPm>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewStaffMappingPm>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByStaffUID(int staffUID) throws SystemException {
		for (LmisViewStaffMappingPm lmisViewStaffMappingPm : findByStaffUID(
				staffUID)) {
			remove(lmisViewStaffMappingPm);
		}
	}

	public void removeByRootID(int rootId) throws SystemException {
		for (LmisViewStaffMappingPm lmisViewStaffMappingPm : findByRootID(
				rootId)) {
			remove(lmisViewStaffMappingPm);
		}
	}

	public void removeByPmUID(int pmUID) throws SystemException {
		for (LmisViewStaffMappingPm lmisViewStaffMappingPm : findByPmUID(pmUID)) {
			remove(lmisViewStaffMappingPm);
		}
	}

	public void removeByBodId(int bodId) throws SystemException {
		for (LmisViewStaffMappingPm lmisViewStaffMappingPm : findByBodId(bodId)) {
			remove(lmisViewStaffMappingPm);
		}
	}

	public void removeAll() throws SystemException {
		for (LmisViewStaffMappingPm lmisViewStaffMappingPm : findAll()) {
			remove(lmisViewStaffMappingPm);
		}
	}

	public int countByStaffUID(int staffUID) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(staffUID) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_STAFFUID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisViewStaffMappingPm WHERE ");

				query.append("staff_uid = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(staffUID);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STAFFUID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
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
					"FROM larion.progate.lmis.model.LmisViewStaffMappingPm WHERE ");

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

	public int countByPmUID(int pmUID) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(pmUID) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PMUID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisViewStaffMappingPm WHERE ");

				query.append("pm_uid = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pmUID);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PMUID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByBodId(int bodId) throws SystemException {
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
					"FROM larion.progate.lmis.model.LmisViewStaffMappingPm WHERE ");

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
						"SELECT COUNT(*) FROM larion.progate.lmis.model.LmisViewStaffMappingPm");

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
						"value.object.listener.larion.progate.lmis.model.LmisViewStaffMappingPm")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LmisViewStaffMappingPm>> listenersList = new ArrayList<ModelListener<LmisViewStaffMappingPm>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LmisViewStaffMappingPm>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(LmisViewStaffMappingPmPersistenceImpl.class);
}