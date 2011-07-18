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

import larion.progate.cds.NoSuchCdsPointsException;
import larion.progate.cds.model.CdsPoints;
import larion.progate.cds.model.impl.CdsPointsImpl;
import larion.progate.cds.model.impl.CdsPointsModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="CdsPointsPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsPointsPersistenceImpl extends BasePersistenceImpl
	implements CdsPointsPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = CdsPointsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_ROOTID = new FinderPath(CdsPointsModelImpl.ENTITY_CACHE_ENABLED,
			CdsPointsModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByrootId", new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ROOTID = new FinderPath(CdsPointsModelImpl.ENTITY_CACHE_ENABLED,
			CdsPointsModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByrootId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ROOTID = new FinderPath(CdsPointsModelImpl.ENTITY_CACHE_ENABLED,
			CdsPointsModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByrootId", new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_POINTNAME = new FinderPath(CdsPointsModelImpl.ENTITY_CACHE_ENABLED,
			CdsPointsModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByPointName", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_POINTNAME = new FinderPath(CdsPointsModelImpl.ENTITY_CACHE_ENABLED,
			CdsPointsModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByPointName",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_POINTNAME = new FinderPath(CdsPointsModelImpl.ENTITY_CACHE_ENABLED,
			CdsPointsModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByPointName", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(CdsPointsModelImpl.ENTITY_CACHE_ENABLED,
			CdsPointsModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CdsPointsModelImpl.ENTITY_CACHE_ENABLED,
			CdsPointsModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	public void cacheResult(CdsPoints cdsPoints) {
		EntityCacheUtil.putResult(CdsPointsModelImpl.ENTITY_CACHE_ENABLED,
			CdsPointsImpl.class, cdsPoints.getPrimaryKey(), cdsPoints);
	}

	public void cacheResult(List<CdsPoints> cdsPointses) {
		for (CdsPoints cdsPoints : cdsPointses) {
			if (EntityCacheUtil.getResult(
						CdsPointsModelImpl.ENTITY_CACHE_ENABLED,
						CdsPointsImpl.class, cdsPoints.getPrimaryKey(), this) == null) {
				cacheResult(cdsPoints);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(CdsPointsImpl.class.getName());
		EntityCacheUtil.clearCache(CdsPointsImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public CdsPoints create(Integer pointId) {
		CdsPoints cdsPoints = new CdsPointsImpl();

		cdsPoints.setNew(true);
		cdsPoints.setPrimaryKey(pointId);

		return cdsPoints;
	}

	public CdsPoints remove(Integer pointId)
		throws NoSuchCdsPointsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CdsPoints cdsPoints = (CdsPoints)session.get(CdsPointsImpl.class,
					pointId);

			if (cdsPoints == null) {
				if (_log.isWarnEnabled()) {
					_log.warn("No CdsPoints exists with the primary key " +
						pointId);
				}

				throw new NoSuchCdsPointsException(
					"No CdsPoints exists with the primary key " + pointId);
			}

			return remove(cdsPoints);
		}
		catch (NoSuchCdsPointsException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public CdsPoints remove(CdsPoints cdsPoints) throws SystemException {
		for (ModelListener<CdsPoints> listener : listeners) {
			listener.onBeforeRemove(cdsPoints);
		}

		cdsPoints = removeImpl(cdsPoints);

		for (ModelListener<CdsPoints> listener : listeners) {
			listener.onAfterRemove(cdsPoints);
		}

		return cdsPoints;
	}

	protected CdsPoints removeImpl(CdsPoints cdsPoints)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (cdsPoints.isCachedModel() || BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(CdsPointsImpl.class,
						cdsPoints.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(cdsPoints);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(CdsPointsModelImpl.ENTITY_CACHE_ENABLED,
			CdsPointsImpl.class, cdsPoints.getPrimaryKey());

		return cdsPoints;
	}

	public CdsPoints update(CdsPoints cdsPoints) throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(CdsPoints cdsPoints) method. Use update(CdsPoints cdsPoints, boolean merge) instead.");
		}

		return update(cdsPoints, false);
	}

	public CdsPoints update(CdsPoints cdsPoints, boolean merge)
		throws SystemException {
		boolean isNew = cdsPoints.isNew();

		for (ModelListener<CdsPoints> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(cdsPoints);
			}
			else {
				listener.onBeforeUpdate(cdsPoints);
			}
		}

		cdsPoints = updateImpl(cdsPoints, merge);

		for (ModelListener<CdsPoints> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(cdsPoints);
			}
			else {
				listener.onAfterUpdate(cdsPoints);
			}
		}

		return cdsPoints;
	}

	public CdsPoints updateImpl(larion.progate.cds.model.CdsPoints cdsPoints,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, cdsPoints, merge);

			cdsPoints.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(CdsPointsModelImpl.ENTITY_CACHE_ENABLED,
			CdsPointsImpl.class, cdsPoints.getPrimaryKey(), cdsPoints);

		return cdsPoints;
	}

	public CdsPoints findByPrimaryKey(Integer pointId)
		throws NoSuchCdsPointsException, SystemException {
		CdsPoints cdsPoints = fetchByPrimaryKey(pointId);

		if (cdsPoints == null) {
			if (_log.isWarnEnabled()) {
				_log.warn("No CdsPoints exists with the primary key " +
					pointId);
			}

			throw new NoSuchCdsPointsException(
				"No CdsPoints exists with the primary key " + pointId);
		}

		return cdsPoints;
	}

	public CdsPoints fetchByPrimaryKey(Integer pointId)
		throws SystemException {
		CdsPoints cdsPoints = (CdsPoints)EntityCacheUtil.getResult(CdsPointsModelImpl.ENTITY_CACHE_ENABLED,
				CdsPointsImpl.class, pointId, this);

		if (cdsPoints == null) {
			Session session = null;

			try {
				session = openSession();

				cdsPoints = (CdsPoints)session.get(CdsPointsImpl.class, pointId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (cdsPoints != null) {
					cacheResult(cdsPoints);
				}

				closeSession(session);
			}
		}

		return cdsPoints;
	}

	public List<CdsPoints> findByrootId(int rootId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		List<CdsPoints> list = (List<CdsPoints>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.cds.model.CdsPoints WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("point_value ASC");

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
					list = new ArrayList<CdsPoints>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<CdsPoints> findByrootId(int rootId, int start, int end)
		throws SystemException {
		return findByrootId(rootId, start, end, null);
	}

	public List<CdsPoints> findByrootId(int rootId, int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(rootId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<CdsPoints> list = (List<CdsPoints>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.cds.model.CdsPoints WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("point_value ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rootId);

				list = (List<CdsPoints>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsPoints>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public CdsPoints findByrootId_First(int rootId, OrderByComparator obc)
		throws NoSuchCdsPointsException, SystemException {
		List<CdsPoints> list = findByrootId(rootId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No CdsPoints exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsPointsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsPoints findByrootId_Last(int rootId, OrderByComparator obc)
		throws NoSuchCdsPointsException, SystemException {
		int count = countByrootId(rootId);

		List<CdsPoints> list = findByrootId(rootId, count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No CdsPoints exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsPointsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsPoints[] findByrootId_PrevAndNext(Integer pointId, int rootId,
		OrderByComparator obc) throws NoSuchCdsPointsException, SystemException {
		CdsPoints cdsPoints = findByPrimaryKey(pointId);

		int count = countByrootId(rootId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.cds.model.CdsPoints WHERE ");

			query.append("root_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("point_value ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(rootId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					cdsPoints);

			CdsPoints[] array = new CdsPointsImpl[3];

			array[0] = (CdsPoints)objArray[0];
			array[1] = (CdsPoints)objArray[1];
			array[2] = (CdsPoints)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<CdsPoints> findByPointName(String pointName)
		throws SystemException {
		Object[] finderArgs = new Object[] { pointName };

		List<CdsPoints> list = (List<CdsPoints>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_POINTNAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.cds.model.CdsPoints WHERE ");

				if (pointName == null) {
					query.append("point_name LIKE null");
				}
				else {
					query.append("point_name LIKE ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("point_value ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (pointName != null) {
					qPos.add(pointName);
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsPoints>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_POINTNAME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<CdsPoints> findByPointName(String pointName, int start, int end)
		throws SystemException {
		return findByPointName(pointName, start, end, null);
	}

	public List<CdsPoints> findByPointName(String pointName, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				pointName,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<CdsPoints> list = (List<CdsPoints>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_POINTNAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.cds.model.CdsPoints WHERE ");

				if (pointName == null) {
					query.append("point_name LIKE null");
				}
				else {
					query.append("point_name LIKE ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("point_value ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (pointName != null) {
					qPos.add(pointName);
				}

				list = (List<CdsPoints>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsPoints>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_POINTNAME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public CdsPoints findByPointName_First(String pointName,
		OrderByComparator obc) throws NoSuchCdsPointsException, SystemException {
		List<CdsPoints> list = findByPointName(pointName, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No CdsPoints exists with the key {");

			msg.append("pointName=" + pointName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsPointsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsPoints findByPointName_Last(String pointName,
		OrderByComparator obc) throws NoSuchCdsPointsException, SystemException {
		int count = countByPointName(pointName);

		List<CdsPoints> list = findByPointName(pointName, count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No CdsPoints exists with the key {");

			msg.append("pointName=" + pointName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsPointsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsPoints[] findByPointName_PrevAndNext(Integer pointId,
		String pointName, OrderByComparator obc)
		throws NoSuchCdsPointsException, SystemException {
		CdsPoints cdsPoints = findByPrimaryKey(pointId);

		int count = countByPointName(pointName);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.cds.model.CdsPoints WHERE ");

			if (pointName == null) {
				query.append("point_name LIKE null");
			}
			else {
				query.append("point_name LIKE ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("point_value ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (pointName != null) {
				qPos.add(pointName);
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					cdsPoints);

			CdsPoints[] array = new CdsPointsImpl[3];

			array[0] = (CdsPoints)objArray[0];
			array[1] = (CdsPoints)objArray[1];
			array[2] = (CdsPoints)objArray[2];

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

	public List<CdsPoints> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<CdsPoints> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<CdsPoints> findAll(int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<CdsPoints> list = (List<CdsPoints>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.cds.model.CdsPoints ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("point_value ASC");
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<CdsPoints>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<CdsPoints>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsPoints>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByrootId(int rootId) throws SystemException {
		for (CdsPoints cdsPoints : findByrootId(rootId)) {
			remove(cdsPoints);
		}
	}

	public void removeByPointName(String pointName) throws SystemException {
		for (CdsPoints cdsPoints : findByPointName(pointName)) {
			remove(cdsPoints);
		}
	}

	public void removeAll() throws SystemException {
		for (CdsPoints cdsPoints : findAll()) {
			remove(cdsPoints);
		}
	}

	public int countByrootId(int rootId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ROOTID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append("FROM larion.progate.cds.model.CdsPoints WHERE ");

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

	public int countByPointName(String pointName) throws SystemException {
		Object[] finderArgs = new Object[] { pointName };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_POINTNAME,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append("FROM larion.progate.cds.model.CdsPoints WHERE ");

				if (pointName == null) {
					query.append("point_name LIKE null");
				}
				else {
					query.append("point_name LIKE ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (pointName != null) {
					qPos.add(pointName);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_POINTNAME,
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
						"SELECT COUNT(*) FROM larion.progate.cds.model.CdsPoints");

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
						"value.object.listener.larion.progate.cds.model.CdsPoints")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CdsPoints>> listenersList = new ArrayList<ModelListener<CdsPoints>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CdsPoints>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(CdsPointsPersistenceImpl.class);
}