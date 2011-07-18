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

import larion.progate.lmis.NoSuchLmisViewDayTypeOverTimeSettingTypeException;
import larion.progate.lmis.model.LmisViewDayTypeOverTimeSettingType;
import larion.progate.lmis.model.impl.LmisViewDayTypeOverTimeSettingTypeImpl;
import larion.progate.lmis.model.impl.LmisViewDayTypeOverTimeSettingTypeModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="LmisViewDayTypeOverTimeSettingTypePersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewDayTypeOverTimeSettingTypePersistenceImpl
	extends BasePersistenceImpl
	implements LmisViewDayTypeOverTimeSettingTypePersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = LmisViewDayTypeOverTimeSettingTypeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_ROOTID = new FinderPath(LmisViewDayTypeOverTimeSettingTypeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewDayTypeOverTimeSettingTypeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ROOTID = new FinderPath(LmisViewDayTypeOverTimeSettingTypeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewDayTypeOverTimeSettingTypeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ROOTID = new FinderPath(LmisViewDayTypeOverTimeSettingTypeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewDayTypeOverTimeSettingTypeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByRootID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_DAYTYPE = new FinderPath(LmisViewDayTypeOverTimeSettingTypeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewDayTypeOverTimeSettingTypeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByDayType",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_DAYTYPE = new FinderPath(LmisViewDayTypeOverTimeSettingTypeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewDayTypeOverTimeSettingTypeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByDayType",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_DAYTYPE = new FinderPath(LmisViewDayTypeOverTimeSettingTypeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewDayTypeOverTimeSettingTypeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByDayType",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(LmisViewDayTypeOverTimeSettingTypeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewDayTypeOverTimeSettingTypeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LmisViewDayTypeOverTimeSettingTypeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewDayTypeOverTimeSettingTypeModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(
		LmisViewDayTypeOverTimeSettingType lmisViewDayTypeOverTimeSettingType) {
		EntityCacheUtil.putResult(LmisViewDayTypeOverTimeSettingTypeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewDayTypeOverTimeSettingTypeImpl.class,
			lmisViewDayTypeOverTimeSettingType.getPrimaryKey(),
			lmisViewDayTypeOverTimeSettingType);
	}

	public void cacheResult(
		List<LmisViewDayTypeOverTimeSettingType> lmisViewDayTypeOverTimeSettingTypes) {
		for (LmisViewDayTypeOverTimeSettingType lmisViewDayTypeOverTimeSettingType : lmisViewDayTypeOverTimeSettingTypes) {
			if (EntityCacheUtil.getResult(
						LmisViewDayTypeOverTimeSettingTypeModelImpl.ENTITY_CACHE_ENABLED,
						LmisViewDayTypeOverTimeSettingTypeImpl.class,
						lmisViewDayTypeOverTimeSettingType.getPrimaryKey(), this) == null) {
				cacheResult(lmisViewDayTypeOverTimeSettingType);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(LmisViewDayTypeOverTimeSettingTypeImpl.class.getName());
		EntityCacheUtil.clearCache(LmisViewDayTypeOverTimeSettingTypeImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public LmisViewDayTypeOverTimeSettingType create(
		Integer lmisViewDayTypeOverTimeSettingTypeId) {
		LmisViewDayTypeOverTimeSettingType lmisViewDayTypeOverTimeSettingType = new LmisViewDayTypeOverTimeSettingTypeImpl();

		lmisViewDayTypeOverTimeSettingType.setNew(true);
		lmisViewDayTypeOverTimeSettingType.setPrimaryKey(lmisViewDayTypeOverTimeSettingTypeId);

		return lmisViewDayTypeOverTimeSettingType;
	}

	public LmisViewDayTypeOverTimeSettingType remove(
		Integer lmisViewDayTypeOverTimeSettingTypeId)
		throws NoSuchLmisViewDayTypeOverTimeSettingTypeException,
			SystemException {
		Session session = null;

		try {
			session = openSession();

			LmisViewDayTypeOverTimeSettingType lmisViewDayTypeOverTimeSettingType =
				(LmisViewDayTypeOverTimeSettingType)session.get(LmisViewDayTypeOverTimeSettingTypeImpl.class,
					lmisViewDayTypeOverTimeSettingTypeId);

			if (lmisViewDayTypeOverTimeSettingType == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No LmisViewDayTypeOverTimeSettingType exists with the primary key " +
						lmisViewDayTypeOverTimeSettingTypeId);
				}

				throw new NoSuchLmisViewDayTypeOverTimeSettingTypeException(
					"No LmisViewDayTypeOverTimeSettingType exists with the primary key " +
					lmisViewDayTypeOverTimeSettingTypeId);
			}

			return remove(lmisViewDayTypeOverTimeSettingType);
		}
		catch (NoSuchLmisViewDayTypeOverTimeSettingTypeException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public LmisViewDayTypeOverTimeSettingType remove(
		LmisViewDayTypeOverTimeSettingType lmisViewDayTypeOverTimeSettingType)
		throws SystemException {
		for (ModelListener<LmisViewDayTypeOverTimeSettingType> listener : listeners) {
			listener.onBeforeRemove(lmisViewDayTypeOverTimeSettingType);
		}

		lmisViewDayTypeOverTimeSettingType = removeImpl(lmisViewDayTypeOverTimeSettingType);

		for (ModelListener<LmisViewDayTypeOverTimeSettingType> listener : listeners) {
			listener.onAfterRemove(lmisViewDayTypeOverTimeSettingType);
		}

		return lmisViewDayTypeOverTimeSettingType;
	}

	protected LmisViewDayTypeOverTimeSettingType removeImpl(
		LmisViewDayTypeOverTimeSettingType lmisViewDayTypeOverTimeSettingType)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (lmisViewDayTypeOverTimeSettingType.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(LmisViewDayTypeOverTimeSettingTypeImpl.class,
						lmisViewDayTypeOverTimeSettingType.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(lmisViewDayTypeOverTimeSettingType);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(LmisViewDayTypeOverTimeSettingTypeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewDayTypeOverTimeSettingTypeImpl.class,
			lmisViewDayTypeOverTimeSettingType.getPrimaryKey());

		return lmisViewDayTypeOverTimeSettingType;
	}

	public LmisViewDayTypeOverTimeSettingType update(
		LmisViewDayTypeOverTimeSettingType lmisViewDayTypeOverTimeSettingType)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(LmisViewDayTypeOverTimeSettingType lmisViewDayTypeOverTimeSettingType) method. Use update(LmisViewDayTypeOverTimeSettingType lmisViewDayTypeOverTimeSettingType, boolean merge) instead.");
		}

		return update(lmisViewDayTypeOverTimeSettingType, false);
	}

	public LmisViewDayTypeOverTimeSettingType update(
		LmisViewDayTypeOverTimeSettingType lmisViewDayTypeOverTimeSettingType,
		boolean merge) throws SystemException {
		boolean isNew = lmisViewDayTypeOverTimeSettingType.isNew();

		for (ModelListener<LmisViewDayTypeOverTimeSettingType> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(lmisViewDayTypeOverTimeSettingType);
			}
			else {
				listener.onBeforeUpdate(lmisViewDayTypeOverTimeSettingType);
			}
		}

		lmisViewDayTypeOverTimeSettingType = updateImpl(lmisViewDayTypeOverTimeSettingType,
				merge);

		for (ModelListener<LmisViewDayTypeOverTimeSettingType> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(lmisViewDayTypeOverTimeSettingType);
			}
			else {
				listener.onAfterUpdate(lmisViewDayTypeOverTimeSettingType);
			}
		}

		return lmisViewDayTypeOverTimeSettingType;
	}

	public LmisViewDayTypeOverTimeSettingType updateImpl(
		larion.progate.lmis.model.LmisViewDayTypeOverTimeSettingType lmisViewDayTypeOverTimeSettingType,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session,
				lmisViewDayTypeOverTimeSettingType, merge);

			lmisViewDayTypeOverTimeSettingType.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(LmisViewDayTypeOverTimeSettingTypeModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewDayTypeOverTimeSettingTypeImpl.class,
			lmisViewDayTypeOverTimeSettingType.getPrimaryKey(),
			lmisViewDayTypeOverTimeSettingType);

		return lmisViewDayTypeOverTimeSettingType;
	}

	public LmisViewDayTypeOverTimeSettingType findByPrimaryKey(
		Integer lmisViewDayTypeOverTimeSettingTypeId)
		throws NoSuchLmisViewDayTypeOverTimeSettingTypeException,
			SystemException {
		LmisViewDayTypeOverTimeSettingType lmisViewDayTypeOverTimeSettingType = fetchByPrimaryKey(lmisViewDayTypeOverTimeSettingTypeId);

		if (lmisViewDayTypeOverTimeSettingType == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"No LmisViewDayTypeOverTimeSettingType exists with the primary key " +
					lmisViewDayTypeOverTimeSettingTypeId);
			}

			throw new NoSuchLmisViewDayTypeOverTimeSettingTypeException(
				"No LmisViewDayTypeOverTimeSettingType exists with the primary key " +
				lmisViewDayTypeOverTimeSettingTypeId);
		}

		return lmisViewDayTypeOverTimeSettingType;
	}

	public LmisViewDayTypeOverTimeSettingType fetchByPrimaryKey(
		Integer lmisViewDayTypeOverTimeSettingTypeId) throws SystemException {
		LmisViewDayTypeOverTimeSettingType lmisViewDayTypeOverTimeSettingType = (LmisViewDayTypeOverTimeSettingType)EntityCacheUtil.getResult(LmisViewDayTypeOverTimeSettingTypeModelImpl.ENTITY_CACHE_ENABLED,
				LmisViewDayTypeOverTimeSettingTypeImpl.class,
				lmisViewDayTypeOverTimeSettingTypeId, this);

		if (lmisViewDayTypeOverTimeSettingType == null) {
			Session session = null;

			try {
				session = openSession();

				lmisViewDayTypeOverTimeSettingType = (LmisViewDayTypeOverTimeSettingType)session.get(LmisViewDayTypeOverTimeSettingTypeImpl.class,
						lmisViewDayTypeOverTimeSettingTypeId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (lmisViewDayTypeOverTimeSettingType != null) {
					cacheResult(lmisViewDayTypeOverTimeSettingType);
				}

				closeSession(session);
			}
		}

		return lmisViewDayTypeOverTimeSettingType;
	}

	public List<LmisViewDayTypeOverTimeSettingType> findByRootID(int rootId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		List<LmisViewDayTypeOverTimeSettingType> list = (List<LmisViewDayTypeOverTimeSettingType>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewDayTypeOverTimeSettingType WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("ot_type_id ASC");

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
					list = new ArrayList<LmisViewDayTypeOverTimeSettingType>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewDayTypeOverTimeSettingType> findByRootID(int rootId,
		int start, int end) throws SystemException {
		return findByRootID(rootId, start, end, null);
	}

	public List<LmisViewDayTypeOverTimeSettingType> findByRootID(int rootId,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(rootId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewDayTypeOverTimeSettingType> list = (List<LmisViewDayTypeOverTimeSettingType>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewDayTypeOverTimeSettingType WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("ot_type_id ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rootId);

				list = (List<LmisViewDayTypeOverTimeSettingType>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewDayTypeOverTimeSettingType>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewDayTypeOverTimeSettingType findByRootID_First(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisViewDayTypeOverTimeSettingTypeException,
			SystemException {
		List<LmisViewDayTypeOverTimeSettingType> list = findByRootID(rootId, 0,
				1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No LmisViewDayTypeOverTimeSettingType exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewDayTypeOverTimeSettingTypeException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewDayTypeOverTimeSettingType findByRootID_Last(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisViewDayTypeOverTimeSettingTypeException,
			SystemException {
		int count = countByRootID(rootId);

		List<LmisViewDayTypeOverTimeSettingType> list = findByRootID(rootId,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No LmisViewDayTypeOverTimeSettingType exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewDayTypeOverTimeSettingTypeException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewDayTypeOverTimeSettingType[] findByRootID_PrevAndNext(
		Integer lmisViewDayTypeOverTimeSettingTypeId, int rootId,
		OrderByComparator obc)
		throws NoSuchLmisViewDayTypeOverTimeSettingTypeException,
			SystemException {
		LmisViewDayTypeOverTimeSettingType lmisViewDayTypeOverTimeSettingType = findByPrimaryKey(lmisViewDayTypeOverTimeSettingTypeId);

		int count = countByRootID(rootId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewDayTypeOverTimeSettingType WHERE ");

			query.append("root_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("ot_type_id ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(rootId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisViewDayTypeOverTimeSettingType);

			LmisViewDayTypeOverTimeSettingType[] array = new LmisViewDayTypeOverTimeSettingTypeImpl[3];

			array[0] = (LmisViewDayTypeOverTimeSettingType)objArray[0];
			array[1] = (LmisViewDayTypeOverTimeSettingType)objArray[1];
			array[2] = (LmisViewDayTypeOverTimeSettingType)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewDayTypeOverTimeSettingType> findByDayType(int dayType)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(dayType) };

		List<LmisViewDayTypeOverTimeSettingType> list = (List<LmisViewDayTypeOverTimeSettingType>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DAYTYPE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewDayTypeOverTimeSettingType WHERE ");

				query.append("day_type = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("ot_type_id ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dayType);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewDayTypeOverTimeSettingType>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DAYTYPE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewDayTypeOverTimeSettingType> findByDayType(int dayType,
		int start, int end) throws SystemException {
		return findByDayType(dayType, start, end, null);
	}

	public List<LmisViewDayTypeOverTimeSettingType> findByDayType(int dayType,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(dayType),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewDayTypeOverTimeSettingType> list = (List<LmisViewDayTypeOverTimeSettingType>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_DAYTYPE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewDayTypeOverTimeSettingType WHERE ");

				query.append("day_type = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("ot_type_id ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dayType);

				list = (List<LmisViewDayTypeOverTimeSettingType>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewDayTypeOverTimeSettingType>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_DAYTYPE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewDayTypeOverTimeSettingType findByDayType_First(int dayType,
		OrderByComparator obc)
		throws NoSuchLmisViewDayTypeOverTimeSettingTypeException,
			SystemException {
		List<LmisViewDayTypeOverTimeSettingType> list = findByDayType(dayType,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No LmisViewDayTypeOverTimeSettingType exists with the key {");

			msg.append("dayType=" + dayType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewDayTypeOverTimeSettingTypeException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewDayTypeOverTimeSettingType findByDayType_Last(int dayType,
		OrderByComparator obc)
		throws NoSuchLmisViewDayTypeOverTimeSettingTypeException,
			SystemException {
		int count = countByDayType(dayType);

		List<LmisViewDayTypeOverTimeSettingType> list = findByDayType(dayType,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No LmisViewDayTypeOverTimeSettingType exists with the key {");

			msg.append("dayType=" + dayType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewDayTypeOverTimeSettingTypeException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewDayTypeOverTimeSettingType[] findByDayType_PrevAndNext(
		Integer lmisViewDayTypeOverTimeSettingTypeId, int dayType,
		OrderByComparator obc)
		throws NoSuchLmisViewDayTypeOverTimeSettingTypeException,
			SystemException {
		LmisViewDayTypeOverTimeSettingType lmisViewDayTypeOverTimeSettingType = findByPrimaryKey(lmisViewDayTypeOverTimeSettingTypeId);

		int count = countByDayType(dayType);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewDayTypeOverTimeSettingType WHERE ");

			query.append("day_type = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("ot_type_id ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(dayType);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisViewDayTypeOverTimeSettingType);

			LmisViewDayTypeOverTimeSettingType[] array = new LmisViewDayTypeOverTimeSettingTypeImpl[3];

			array[0] = (LmisViewDayTypeOverTimeSettingType)objArray[0];
			array[1] = (LmisViewDayTypeOverTimeSettingType)objArray[1];
			array[2] = (LmisViewDayTypeOverTimeSettingType)objArray[2];

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

	public List<LmisViewDayTypeOverTimeSettingType> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<LmisViewDayTypeOverTimeSettingType> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<LmisViewDayTypeOverTimeSettingType> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewDayTypeOverTimeSettingType> list = (List<LmisViewDayTypeOverTimeSettingType>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewDayTypeOverTimeSettingType ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("ot_type_id ASC");
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<LmisViewDayTypeOverTimeSettingType>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LmisViewDayTypeOverTimeSettingType>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewDayTypeOverTimeSettingType>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByRootID(int rootId) throws SystemException {
		for (LmisViewDayTypeOverTimeSettingType lmisViewDayTypeOverTimeSettingType : findByRootID(
				rootId)) {
			remove(lmisViewDayTypeOverTimeSettingType);
		}
	}

	public void removeByDayType(int dayType) throws SystemException {
		for (LmisViewDayTypeOverTimeSettingType lmisViewDayTypeOverTimeSettingType : findByDayType(
				dayType)) {
			remove(lmisViewDayTypeOverTimeSettingType);
		}
	}

	public void removeAll() throws SystemException {
		for (LmisViewDayTypeOverTimeSettingType lmisViewDayTypeOverTimeSettingType : findAll()) {
			remove(lmisViewDayTypeOverTimeSettingType);
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
					"FROM larion.progate.lmis.model.LmisViewDayTypeOverTimeSettingType WHERE ");

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

	public int countByDayType(int dayType) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(dayType) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DAYTYPE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisViewDayTypeOverTimeSettingType WHERE ");

				query.append("day_type = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dayType);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DAYTYPE,
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
						"SELECT COUNT(*) FROM larion.progate.lmis.model.LmisViewDayTypeOverTimeSettingType");

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
						"value.object.listener.larion.progate.lmis.model.LmisViewDayTypeOverTimeSettingType")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LmisViewDayTypeOverTimeSettingType>> listenersList =
					new ArrayList<ModelListener<LmisViewDayTypeOverTimeSettingType>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LmisViewDayTypeOverTimeSettingType>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(LmisViewDayTypeOverTimeSettingTypePersistenceImpl.class);
}