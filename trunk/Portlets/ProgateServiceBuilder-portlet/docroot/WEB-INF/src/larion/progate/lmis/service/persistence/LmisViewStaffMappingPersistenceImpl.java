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

import larion.progate.lmis.NoSuchLmisViewStaffMappingException;
import larion.progate.lmis.model.LmisViewStaffMapping;
import larion.progate.lmis.model.impl.LmisViewStaffMappingImpl;
import larion.progate.lmis.model.impl.LmisViewStaffMappingModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="LmisViewStaffMappingPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewStaffMappingPersistenceImpl extends BasePersistenceImpl
	implements LmisViewStaffMappingPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = LmisViewStaffMappingImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_STAFFUID = new FinderPath(LmisViewStaffMappingModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffMappingModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByStaffUID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_STAFFUID = new FinderPath(LmisViewStaffMappingModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffMappingModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByStaffUID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_STAFFUID = new FinderPath(LmisViewStaffMappingModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffMappingModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByStaffUID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ROOTID = new FinderPath(LmisViewStaffMappingModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffMappingModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ROOTID = new FinderPath(LmisViewStaffMappingModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffMappingModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ROOTID = new FinderPath(LmisViewStaffMappingModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffMappingModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByRootID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_PMUID = new FinderPath(LmisViewStaffMappingModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffMappingModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByPmUID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_PMUID = new FinderPath(LmisViewStaffMappingModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffMappingModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByPmUID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_PMUID = new FinderPath(LmisViewStaffMappingModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffMappingModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByPmUID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_BODID = new FinderPath(LmisViewStaffMappingModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffMappingModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByBodId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_BODID = new FinderPath(LmisViewStaffMappingModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffMappingModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByBodId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_BODID = new FinderPath(LmisViewStaffMappingModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffMappingModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByBodId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(LmisViewStaffMappingModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffMappingModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LmisViewStaffMappingModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffMappingModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(LmisViewStaffMapping lmisViewStaffMapping) {
		EntityCacheUtil.putResult(LmisViewStaffMappingModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffMappingImpl.class,
			lmisViewStaffMapping.getPrimaryKey(), lmisViewStaffMapping);
	}

	public void cacheResult(List<LmisViewStaffMapping> lmisViewStaffMappings) {
		for (LmisViewStaffMapping lmisViewStaffMapping : lmisViewStaffMappings) {
			if (EntityCacheUtil.getResult(
						LmisViewStaffMappingModelImpl.ENTITY_CACHE_ENABLED,
						LmisViewStaffMappingImpl.class,
						lmisViewStaffMapping.getPrimaryKey(), this) == null) {
				cacheResult(lmisViewStaffMapping);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(LmisViewStaffMappingImpl.class.getName());
		EntityCacheUtil.clearCache(LmisViewStaffMappingImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public LmisViewStaffMapping create(Integer lmisViewStaffMappingId) {
		LmisViewStaffMapping lmisViewStaffMapping = new LmisViewStaffMappingImpl();

		lmisViewStaffMapping.setNew(true);
		lmisViewStaffMapping.setPrimaryKey(lmisViewStaffMappingId);

		return lmisViewStaffMapping;
	}

	public LmisViewStaffMapping remove(Integer lmisViewStaffMappingId)
		throws NoSuchLmisViewStaffMappingException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LmisViewStaffMapping lmisViewStaffMapping = (LmisViewStaffMapping)session.get(LmisViewStaffMappingImpl.class,
					lmisViewStaffMappingId);

			if (lmisViewStaffMapping == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No LmisViewStaffMapping exists with the primary key " +
						lmisViewStaffMappingId);
				}

				throw new NoSuchLmisViewStaffMappingException(
					"No LmisViewStaffMapping exists with the primary key " +
					lmisViewStaffMappingId);
			}

			return remove(lmisViewStaffMapping);
		}
		catch (NoSuchLmisViewStaffMappingException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public LmisViewStaffMapping remove(
		LmisViewStaffMapping lmisViewStaffMapping) throws SystemException {
		for (ModelListener<LmisViewStaffMapping> listener : listeners) {
			listener.onBeforeRemove(lmisViewStaffMapping);
		}

		lmisViewStaffMapping = removeImpl(lmisViewStaffMapping);

		for (ModelListener<LmisViewStaffMapping> listener : listeners) {
			listener.onAfterRemove(lmisViewStaffMapping);
		}

		return lmisViewStaffMapping;
	}

	protected LmisViewStaffMapping removeImpl(
		LmisViewStaffMapping lmisViewStaffMapping) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (lmisViewStaffMapping.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(LmisViewStaffMappingImpl.class,
						lmisViewStaffMapping.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(lmisViewStaffMapping);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(LmisViewStaffMappingModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffMappingImpl.class, lmisViewStaffMapping.getPrimaryKey());

		return lmisViewStaffMapping;
	}

	public LmisViewStaffMapping update(
		LmisViewStaffMapping lmisViewStaffMapping) throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(LmisViewStaffMapping lmisViewStaffMapping) method. Use update(LmisViewStaffMapping lmisViewStaffMapping, boolean merge) instead.");
		}

		return update(lmisViewStaffMapping, false);
	}

	public LmisViewStaffMapping update(
		LmisViewStaffMapping lmisViewStaffMapping, boolean merge)
		throws SystemException {
		boolean isNew = lmisViewStaffMapping.isNew();

		for (ModelListener<LmisViewStaffMapping> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(lmisViewStaffMapping);
			}
			else {
				listener.onBeforeUpdate(lmisViewStaffMapping);
			}
		}

		lmisViewStaffMapping = updateImpl(lmisViewStaffMapping, merge);

		for (ModelListener<LmisViewStaffMapping> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(lmisViewStaffMapping);
			}
			else {
				listener.onAfterUpdate(lmisViewStaffMapping);
			}
		}

		return lmisViewStaffMapping;
	}

	public LmisViewStaffMapping updateImpl(
		larion.progate.lmis.model.LmisViewStaffMapping lmisViewStaffMapping,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, lmisViewStaffMapping, merge);

			lmisViewStaffMapping.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(LmisViewStaffMappingModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewStaffMappingImpl.class,
			lmisViewStaffMapping.getPrimaryKey(), lmisViewStaffMapping);

		return lmisViewStaffMapping;
	}

	public LmisViewStaffMapping findByPrimaryKey(Integer lmisViewStaffMappingId)
		throws NoSuchLmisViewStaffMappingException, SystemException {
		LmisViewStaffMapping lmisViewStaffMapping = fetchByPrimaryKey(lmisViewStaffMappingId);

		if (lmisViewStaffMapping == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"No LmisViewStaffMapping exists with the primary key " +
					lmisViewStaffMappingId);
			}

			throw new NoSuchLmisViewStaffMappingException(
				"No LmisViewStaffMapping exists with the primary key " +
				lmisViewStaffMappingId);
		}

		return lmisViewStaffMapping;
	}

	public LmisViewStaffMapping fetchByPrimaryKey(
		Integer lmisViewStaffMappingId) throws SystemException {
		LmisViewStaffMapping lmisViewStaffMapping = (LmisViewStaffMapping)EntityCacheUtil.getResult(LmisViewStaffMappingModelImpl.ENTITY_CACHE_ENABLED,
				LmisViewStaffMappingImpl.class, lmisViewStaffMappingId, this);

		if (lmisViewStaffMapping == null) {
			Session session = null;

			try {
				session = openSession();

				lmisViewStaffMapping = (LmisViewStaffMapping)session.get(LmisViewStaffMappingImpl.class,
						lmisViewStaffMappingId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (lmisViewStaffMapping != null) {
					cacheResult(lmisViewStaffMapping);
				}

				closeSession(session);
			}
		}

		return lmisViewStaffMapping;
	}

	public List<LmisViewStaffMapping> findByStaffUID(int staffUID)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(staffUID) };

		List<LmisViewStaffMapping> list = (List<LmisViewStaffMapping>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_STAFFUID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewStaffMapping WHERE ");

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
					list = new ArrayList<LmisViewStaffMapping>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_STAFFUID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewStaffMapping> findByStaffUID(int staffUID, int start,
		int end) throws SystemException {
		return findByStaffUID(staffUID, start, end, null);
	}

	public List<LmisViewStaffMapping> findByStaffUID(int staffUID, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(staffUID),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewStaffMapping> list = (List<LmisViewStaffMapping>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_STAFFUID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewStaffMapping WHERE ");

				query.append("staff_uid = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(staffUID);

				list = (List<LmisViewStaffMapping>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewStaffMapping>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_STAFFUID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewStaffMapping findByStaffUID_First(int staffUID,
		OrderByComparator obc)
		throws NoSuchLmisViewStaffMappingException, SystemException {
		List<LmisViewStaffMapping> list = findByStaffUID(staffUID, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewStaffMapping exists with the key {");

			msg.append("staffUID=" + staffUID);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewStaffMappingException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewStaffMapping findByStaffUID_Last(int staffUID,
		OrderByComparator obc)
		throws NoSuchLmisViewStaffMappingException, SystemException {
		int count = countByStaffUID(staffUID);

		List<LmisViewStaffMapping> list = findByStaffUID(staffUID, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewStaffMapping exists with the key {");

			msg.append("staffUID=" + staffUID);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewStaffMappingException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewStaffMapping[] findByStaffUID_PrevAndNext(
		Integer lmisViewStaffMappingId, int staffUID, OrderByComparator obc)
		throws NoSuchLmisViewStaffMappingException, SystemException {
		LmisViewStaffMapping lmisViewStaffMapping = findByPrimaryKey(lmisViewStaffMappingId);

		int count = countByStaffUID(staffUID);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewStaffMapping WHERE ");

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
					lmisViewStaffMapping);

			LmisViewStaffMapping[] array = new LmisViewStaffMappingImpl[3];

			array[0] = (LmisViewStaffMapping)objArray[0];
			array[1] = (LmisViewStaffMapping)objArray[1];
			array[2] = (LmisViewStaffMapping)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewStaffMapping> findByRootID(int rootId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		List<LmisViewStaffMapping> list = (List<LmisViewStaffMapping>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewStaffMapping WHERE ");

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
					list = new ArrayList<LmisViewStaffMapping>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewStaffMapping> findByRootID(int rootId, int start,
		int end) throws SystemException {
		return findByRootID(rootId, start, end, null);
	}

	public List<LmisViewStaffMapping> findByRootID(int rootId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(rootId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewStaffMapping> list = (List<LmisViewStaffMapping>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewStaffMapping WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rootId);

				list = (List<LmisViewStaffMapping>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewStaffMapping>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewStaffMapping findByRootID_First(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisViewStaffMappingException, SystemException {
		List<LmisViewStaffMapping> list = findByRootID(rootId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewStaffMapping exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewStaffMappingException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewStaffMapping findByRootID_Last(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisViewStaffMappingException, SystemException {
		int count = countByRootID(rootId);

		List<LmisViewStaffMapping> list = findByRootID(rootId, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewStaffMapping exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewStaffMappingException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewStaffMapping[] findByRootID_PrevAndNext(
		Integer lmisViewStaffMappingId, int rootId, OrderByComparator obc)
		throws NoSuchLmisViewStaffMappingException, SystemException {
		LmisViewStaffMapping lmisViewStaffMapping = findByPrimaryKey(lmisViewStaffMappingId);

		int count = countByRootID(rootId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewStaffMapping WHERE ");

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
					lmisViewStaffMapping);

			LmisViewStaffMapping[] array = new LmisViewStaffMappingImpl[3];

			array[0] = (LmisViewStaffMapping)objArray[0];
			array[1] = (LmisViewStaffMapping)objArray[1];
			array[2] = (LmisViewStaffMapping)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewStaffMapping> findByPmUID(int pmUID)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(pmUID) };

		List<LmisViewStaffMapping> list = (List<LmisViewStaffMapping>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_PMUID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewStaffMapping WHERE ");

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
					list = new ArrayList<LmisViewStaffMapping>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_PMUID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewStaffMapping> findByPmUID(int pmUID, int start, int end)
		throws SystemException {
		return findByPmUID(pmUID, start, end, null);
	}

	public List<LmisViewStaffMapping> findByPmUID(int pmUID, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(pmUID),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewStaffMapping> list = (List<LmisViewStaffMapping>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_PMUID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewStaffMapping WHERE ");

				query.append("pm_uid = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pmUID);

				list = (List<LmisViewStaffMapping>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewStaffMapping>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_PMUID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewStaffMapping findByPmUID_First(int pmUID,
		OrderByComparator obc)
		throws NoSuchLmisViewStaffMappingException, SystemException {
		List<LmisViewStaffMapping> list = findByPmUID(pmUID, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewStaffMapping exists with the key {");

			msg.append("pmUID=" + pmUID);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewStaffMappingException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewStaffMapping findByPmUID_Last(int pmUID,
		OrderByComparator obc)
		throws NoSuchLmisViewStaffMappingException, SystemException {
		int count = countByPmUID(pmUID);

		List<LmisViewStaffMapping> list = findByPmUID(pmUID, count - 1, count,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewStaffMapping exists with the key {");

			msg.append("pmUID=" + pmUID);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewStaffMappingException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewStaffMapping[] findByPmUID_PrevAndNext(
		Integer lmisViewStaffMappingId, int pmUID, OrderByComparator obc)
		throws NoSuchLmisViewStaffMappingException, SystemException {
		LmisViewStaffMapping lmisViewStaffMapping = findByPrimaryKey(lmisViewStaffMappingId);

		int count = countByPmUID(pmUID);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewStaffMapping WHERE ");

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
					lmisViewStaffMapping);

			LmisViewStaffMapping[] array = new LmisViewStaffMappingImpl[3];

			array[0] = (LmisViewStaffMapping)objArray[0];
			array[1] = (LmisViewStaffMapping)objArray[1];
			array[2] = (LmisViewStaffMapping)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewStaffMapping> findByBodId(int bodId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(bodId) };

		List<LmisViewStaffMapping> list = (List<LmisViewStaffMapping>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_BODID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewStaffMapping WHERE ");

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
					list = new ArrayList<LmisViewStaffMapping>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_BODID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewStaffMapping> findByBodId(int bodId, int start, int end)
		throws SystemException {
		return findByBodId(bodId, start, end, null);
	}

	public List<LmisViewStaffMapping> findByBodId(int bodId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(bodId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewStaffMapping> list = (List<LmisViewStaffMapping>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_BODID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewStaffMapping WHERE ");

				query.append("bod_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(bodId);

				list = (List<LmisViewStaffMapping>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewStaffMapping>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_BODID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewStaffMapping findByBodId_First(int bodId,
		OrderByComparator obc)
		throws NoSuchLmisViewStaffMappingException, SystemException {
		List<LmisViewStaffMapping> list = findByBodId(bodId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewStaffMapping exists with the key {");

			msg.append("bodId=" + bodId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewStaffMappingException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewStaffMapping findByBodId_Last(int bodId,
		OrderByComparator obc)
		throws NoSuchLmisViewStaffMappingException, SystemException {
		int count = countByBodId(bodId);

		List<LmisViewStaffMapping> list = findByBodId(bodId, count - 1, count,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewStaffMapping exists with the key {");

			msg.append("bodId=" + bodId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewStaffMappingException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewStaffMapping[] findByBodId_PrevAndNext(
		Integer lmisViewStaffMappingId, int bodId, OrderByComparator obc)
		throws NoSuchLmisViewStaffMappingException, SystemException {
		LmisViewStaffMapping lmisViewStaffMapping = findByPrimaryKey(lmisViewStaffMappingId);

		int count = countByBodId(bodId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewStaffMapping WHERE ");

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
					lmisViewStaffMapping);

			LmisViewStaffMapping[] array = new LmisViewStaffMappingImpl[3];

			array[0] = (LmisViewStaffMapping)objArray[0];
			array[1] = (LmisViewStaffMapping)objArray[1];
			array[2] = (LmisViewStaffMapping)objArray[2];

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

	public List<LmisViewStaffMapping> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<LmisViewStaffMapping> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<LmisViewStaffMapping> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewStaffMapping> list = (List<LmisViewStaffMapping>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewStaffMapping ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<LmisViewStaffMapping>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LmisViewStaffMapping>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewStaffMapping>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByStaffUID(int staffUID) throws SystemException {
		for (LmisViewStaffMapping lmisViewStaffMapping : findByStaffUID(
				staffUID)) {
			remove(lmisViewStaffMapping);
		}
	}

	public void removeByRootID(int rootId) throws SystemException {
		for (LmisViewStaffMapping lmisViewStaffMapping : findByRootID(rootId)) {
			remove(lmisViewStaffMapping);
		}
	}

	public void removeByPmUID(int pmUID) throws SystemException {
		for (LmisViewStaffMapping lmisViewStaffMapping : findByPmUID(pmUID)) {
			remove(lmisViewStaffMapping);
		}
	}

	public void removeByBodId(int bodId) throws SystemException {
		for (LmisViewStaffMapping lmisViewStaffMapping : findByBodId(bodId)) {
			remove(lmisViewStaffMapping);
		}
	}

	public void removeAll() throws SystemException {
		for (LmisViewStaffMapping lmisViewStaffMapping : findAll()) {
			remove(lmisViewStaffMapping);
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
					"FROM larion.progate.lmis.model.LmisViewStaffMapping WHERE ");

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
					"FROM larion.progate.lmis.model.LmisViewStaffMapping WHERE ");

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
					"FROM larion.progate.lmis.model.LmisViewStaffMapping WHERE ");

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
					"FROM larion.progate.lmis.model.LmisViewStaffMapping WHERE ");

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
						"SELECT COUNT(*) FROM larion.progate.lmis.model.LmisViewStaffMapping");

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
						"value.object.listener.larion.progate.lmis.model.LmisViewStaffMapping")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LmisViewStaffMapping>> listenersList = new ArrayList<ModelListener<LmisViewStaffMapping>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LmisViewStaffMapping>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(LmisViewStaffMappingPersistenceImpl.class);
}