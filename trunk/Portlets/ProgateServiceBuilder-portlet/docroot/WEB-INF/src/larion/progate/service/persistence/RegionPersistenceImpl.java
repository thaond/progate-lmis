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

package larion.progate.service.persistence;

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

import larion.progate.NoSuchRegionException;

import larion.progate.model.Region;
import larion.progate.model.impl.RegionImpl;
import larion.progate.model.impl.RegionModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="RegionPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class RegionPersistenceImpl extends BasePersistenceImpl
	implements RegionPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = RegionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_NAME = new FinderPath(RegionModelImpl.ENTITY_CACHE_ENABLED,
			RegionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByname", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_NAME = new FinderPath(RegionModelImpl.ENTITY_CACHE_ENABLED,
			RegionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByname",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(RegionModelImpl.ENTITY_CACHE_ENABLED,
			RegionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByname", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ACTIVE = new FinderPath(RegionModelImpl.ENTITY_CACHE_ENABLED,
			RegionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByactive", new String[] { Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ACTIVE = new FinderPath(RegionModelImpl.ENTITY_CACHE_ENABLED,
			RegionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByactive",
			new String[] {
				Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVE = new FinderPath(RegionModelImpl.ENTITY_CACHE_ENABLED,
			RegionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByactive", new String[] { Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_REGIONCODE = new FinderPath(RegionModelImpl.ENTITY_CACHE_ENABLED,
			RegionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByregionCode", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_REGIONCODE = new FinderPath(RegionModelImpl.ENTITY_CACHE_ENABLED,
			RegionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByregionCode",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_REGIONCODE = new FinderPath(RegionModelImpl.ENTITY_CACHE_ENABLED,
			RegionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByregionCode", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(RegionModelImpl.ENTITY_CACHE_ENABLED,
			RegionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RegionModelImpl.ENTITY_CACHE_ENABLED,
			RegionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	public void cacheResult(Region region) {
		EntityCacheUtil.putResult(RegionModelImpl.ENTITY_CACHE_ENABLED,
			RegionImpl.class, region.getPrimaryKey(), region);
	}

	public void cacheResult(List<Region> regions) {
		for (Region region : regions) {
			if (EntityCacheUtil.getResult(
						RegionModelImpl.ENTITY_CACHE_ENABLED, RegionImpl.class,
						region.getPrimaryKey(), this) == null) {
				cacheResult(region);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(RegionImpl.class.getName());
		EntityCacheUtil.clearCache(RegionImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public Region create(Integer regionId) {
		Region region = new RegionImpl();

		region.setNew(true);
		region.setPrimaryKey(regionId);

		return region;
	}

	public Region remove(Integer regionId)
		throws NoSuchRegionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Region region = (Region)session.get(RegionImpl.class, regionId);

			if (region == null) {
				if (_log.isWarnEnabled()) {
					_log.warn("No Region exists with the primary key " +
						regionId);
				}

				throw new NoSuchRegionException(
					"No Region exists with the primary key " + regionId);
			}

			return remove(region);
		}
		catch (NoSuchRegionException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public Region remove(Region region) throws SystemException {
		for (ModelListener<Region> listener : listeners) {
			listener.onBeforeRemove(region);
		}

		region = removeImpl(region);

		for (ModelListener<Region> listener : listeners) {
			listener.onAfterRemove(region);
		}

		return region;
	}

	protected Region removeImpl(Region region) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (region.isCachedModel() || BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(RegionImpl.class,
						region.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(region);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(RegionModelImpl.ENTITY_CACHE_ENABLED,
			RegionImpl.class, region.getPrimaryKey());

		return region;
	}

	public Region update(Region region) throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(Region region) method. Use update(Region region, boolean merge) instead.");
		}

		return update(region, false);
	}

	public Region update(Region region, boolean merge)
		throws SystemException {
		boolean isNew = region.isNew();

		for (ModelListener<Region> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(region);
			}
			else {
				listener.onBeforeUpdate(region);
			}
		}

		region = updateImpl(region, merge);

		for (ModelListener<Region> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(region);
			}
			else {
				listener.onAfterUpdate(region);
			}
		}

		return region;
	}

	public Region updateImpl(larion.progate.model.Region region, boolean merge)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, region, merge);

			region.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(RegionModelImpl.ENTITY_CACHE_ENABLED,
			RegionImpl.class, region.getPrimaryKey(), region);

		return region;
	}

	public Region findByPrimaryKey(Integer regionId)
		throws NoSuchRegionException, SystemException {
		Region region = fetchByPrimaryKey(regionId);

		if (region == null) {
			if (_log.isWarnEnabled()) {
				_log.warn("No Region exists with the primary key " + regionId);
			}

			throw new NoSuchRegionException(
				"No Region exists with the primary key " + regionId);
		}

		return region;
	}

	public Region fetchByPrimaryKey(Integer regionId) throws SystemException {
		Region region = (Region)EntityCacheUtil.getResult(RegionModelImpl.ENTITY_CACHE_ENABLED,
				RegionImpl.class, regionId, this);

		if (region == null) {
			Session session = null;

			try {
				session = openSession();

				region = (Region)session.get(RegionImpl.class, regionId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (region != null) {
					cacheResult(region);
				}

				closeSession(session);
			}
		}

		return region;
	}

	public List<Region> findByname(String name) throws SystemException {
		Object[] finderArgs = new Object[] { name };

		List<Region> list = (List<Region>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_NAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.Region WHERE ");

				if (name == null) {
					query.append("name LIKE null");
				}
				else {
					query.append("name LIKE ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (name != null) {
					qPos.add(name);
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Region>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_NAME, finderArgs,
					list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<Region> findByname(String name, int start, int end)
		throws SystemException {
		return findByname(name, start, end, null);
	}

	public List<Region> findByname(String name, int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				name,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<Region> list = (List<Region>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_NAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.Region WHERE ");

				if (name == null) {
					query.append("name LIKE null");
				}
				else {
					query.append("name LIKE ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (name != null) {
					qPos.add(name);
				}

				list = (List<Region>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Region>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_NAME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public Region findByname_First(String name, OrderByComparator obc)
		throws NoSuchRegionException, SystemException {
		List<Region> list = findByname(name, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No Region exists with the key {");

			msg.append("name=" + name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchRegionException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public Region findByname_Last(String name, OrderByComparator obc)
		throws NoSuchRegionException, SystemException {
		int count = countByname(name);

		List<Region> list = findByname(name, count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No Region exists with the key {");

			msg.append("name=" + name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchRegionException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public Region[] findByname_PrevAndNext(Integer regionId, String name,
		OrderByComparator obc) throws NoSuchRegionException, SystemException {
		Region region = findByPrimaryKey(regionId);

		int count = countByname(name);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.Region WHERE ");

			if (name == null) {
				query.append("name LIKE null");
			}
			else {
				query.append("name LIKE ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (name != null) {
				qPos.add(name);
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, region);

			Region[] array = new RegionImpl[3];

			array[0] = (Region)objArray[0];
			array[1] = (Region)objArray[1];
			array[2] = (Region)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<Region> findByactive(boolean active) throws SystemException {
		Object[] finderArgs = new Object[] { Boolean.valueOf(active) };

		List<Region> list = (List<Region>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ACTIVE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.Region WHERE ");

				query.append("active_ LIKE ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(active);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Region>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ACTIVE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<Region> findByactive(boolean active, int start, int end)
		throws SystemException {
		return findByactive(active, start, end, null);
	}

	public List<Region> findByactive(boolean active, int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				Boolean.valueOf(active),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<Region> list = (List<Region>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ACTIVE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.Region WHERE ");

				query.append("active_ LIKE ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(active);

				list = (List<Region>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Region>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ACTIVE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public Region findByactive_First(boolean active, OrderByComparator obc)
		throws NoSuchRegionException, SystemException {
		List<Region> list = findByactive(active, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No Region exists with the key {");

			msg.append("active=" + active);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchRegionException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public Region findByactive_Last(boolean active, OrderByComparator obc)
		throws NoSuchRegionException, SystemException {
		int count = countByactive(active);

		List<Region> list = findByactive(active, count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No Region exists with the key {");

			msg.append("active=" + active);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchRegionException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public Region[] findByactive_PrevAndNext(Integer regionId, boolean active,
		OrderByComparator obc) throws NoSuchRegionException, SystemException {
		Region region = findByPrimaryKey(regionId);

		int count = countByactive(active);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.Region WHERE ");

			query.append("active_ LIKE ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(active);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, region);

			Region[] array = new RegionImpl[3];

			array[0] = (Region)objArray[0];
			array[1] = (Region)objArray[1];
			array[2] = (Region)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<Region> findByregionCode(String regionCode)
		throws SystemException {
		Object[] finderArgs = new Object[] { regionCode };

		List<Region> list = (List<Region>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_REGIONCODE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.Region WHERE ");

				if (regionCode == null) {
					query.append("regioncode LIKE null");
				}
				else {
					query.append("regioncode LIKE ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (regionCode != null) {
					qPos.add(regionCode);
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Region>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_REGIONCODE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<Region> findByregionCode(String regionCode, int start, int end)
		throws SystemException {
		return findByregionCode(regionCode, start, end, null);
	}

	public List<Region> findByregionCode(String regionCode, int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				regionCode,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<Region> list = (List<Region>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_REGIONCODE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.Region WHERE ");

				if (regionCode == null) {
					query.append("regioncode LIKE null");
				}
				else {
					query.append("regioncode LIKE ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (regionCode != null) {
					qPos.add(regionCode);
				}

				list = (List<Region>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Region>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_REGIONCODE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public Region findByregionCode_First(String regionCode,
		OrderByComparator obc) throws NoSuchRegionException, SystemException {
		List<Region> list = findByregionCode(regionCode, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No Region exists with the key {");

			msg.append("regionCode=" + regionCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchRegionException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public Region findByregionCode_Last(String regionCode, OrderByComparator obc)
		throws NoSuchRegionException, SystemException {
		int count = countByregionCode(regionCode);

		List<Region> list = findByregionCode(regionCode, count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No Region exists with the key {");

			msg.append("regionCode=" + regionCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchRegionException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public Region[] findByregionCode_PrevAndNext(Integer regionId,
		String regionCode, OrderByComparator obc)
		throws NoSuchRegionException, SystemException {
		Region region = findByPrimaryKey(regionId);

		int count = countByregionCode(regionCode);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.Region WHERE ");

			if (regionCode == null) {
				query.append("regioncode LIKE null");
			}
			else {
				query.append("regioncode LIKE ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (regionCode != null) {
				qPos.add(regionCode);
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, region);

			Region[] array = new RegionImpl[3];

			array[0] = (Region)objArray[0];
			array[1] = (Region)objArray[1];
			array[2] = (Region)objArray[2];

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

	public List<Region> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<Region> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	public List<Region> findAll(int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<Region> list = (List<Region>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.Region ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<Region>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Region>)QueryUtil.list(q, getDialect(), start,
							end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Region>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByname(String name) throws SystemException {
		for (Region region : findByname(name)) {
			remove(region);
		}
	}

	public void removeByactive(boolean active) throws SystemException {
		for (Region region : findByactive(active)) {
			remove(region);
		}
	}

	public void removeByregionCode(String regionCode) throws SystemException {
		for (Region region : findByregionCode(regionCode)) {
			remove(region);
		}
	}

	public void removeAll() throws SystemException {
		for (Region region : findAll()) {
			remove(region);
		}
	}

	public int countByname(String name) throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_NAME,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append("FROM larion.progate.model.Region WHERE ");

				if (name == null) {
					query.append("name LIKE null");
				}
				else {
					query.append("name LIKE ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (name != null) {
					qPos.add(name);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByactive(boolean active) throws SystemException {
		Object[] finderArgs = new Object[] { Boolean.valueOf(active) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ACTIVE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append("FROM larion.progate.model.Region WHERE ");

				query.append("active_ LIKE ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(active);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ACTIVE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByregionCode(String regionCode) throws SystemException {
		Object[] finderArgs = new Object[] { regionCode };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_REGIONCODE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append("FROM larion.progate.model.Region WHERE ");

				if (regionCode == null) {
					query.append("regioncode LIKE null");
				}
				else {
					query.append("regioncode LIKE ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (regionCode != null) {
					qPos.add(regionCode);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_REGIONCODE,
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
						"SELECT COUNT(*) FROM larion.progate.model.Region");

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
						"value.object.listener.larion.progate.model.Region")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Region>> listenersList = new ArrayList<ModelListener<Region>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Region>)Class.forName(
							listenerClassName).newInstance());
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	@BeanReference(name = "larion.progate.service.persistence.UserPersistence.impl")
	protected larion.progate.service.persistence.UserPersistence userPersistence;
	@BeanReference(name = "larion.progate.service.persistence.UserInformationViewPersistence.impl")
	protected larion.progate.service.persistence.UserInformationViewPersistence userInformationViewPersistence;
	@BeanReference(name = "larion.progate.service.persistence.OrganizationPersistence.impl")
	protected larion.progate.service.persistence.OrganizationPersistence organizationPersistence;
	@BeanReference(name = "larion.progate.service.persistence.OrganizationViewPersistence.impl")
	protected larion.progate.service.persistence.OrganizationViewPersistence organizationViewPersistence;
	@BeanReference(name = "larion.progate.service.persistence.OrgObjectListPersistence.impl")
	protected larion.progate.service.persistence.OrgObjectListPersistence orgObjectListPersistence;
	@BeanReference(name = "larion.progate.service.persistence.OrgObjectApprovalPersistence.impl")
	protected larion.progate.service.persistence.OrgObjectApprovalPersistence orgObjectApprovalPersistence;
	@BeanReference(name = "larion.progate.service.persistence.OrgObjectPerspectivePersistence.impl")
	protected larion.progate.service.persistence.OrgObjectPerspectivePersistence orgObjectPerspectivePersistence;
	@BeanReference(name = "larion.progate.service.persistence.OrgObjectObjectivePersistence.impl")
	protected larion.progate.service.persistence.OrgObjectObjectivePersistence orgObjectObjectivePersistence;
	@BeanReference(name = "larion.progate.service.persistence.OrgObjectMeasurePersistence.impl")
	protected larion.progate.service.persistence.OrgObjectMeasurePersistence orgObjectMeasurePersistence;
	@BeanReference(name = "larion.progate.service.persistence.OrgObjectTargetsPersistence.impl")
	protected larion.progate.service.persistence.OrgObjectTargetsPersistence orgObjectTargetsPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProgatePortalMenuPersistence.impl")
	protected larion.progate.service.persistence.ProgatePortalMenuPersistence progatePortalMenuPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProGateRolesPersistence.impl")
	protected larion.progate.service.persistence.ProGateRolesPersistence proGateRolesPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProGateOrgTypePersistence.impl")
	protected larion.progate.service.persistence.ProGateOrgTypePersistence proGateOrgTypePersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProGateJournalArticlePersistence.impl")
	protected larion.progate.service.persistence.ProGateJournalArticlePersistence proGateJournalArticlePersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProGateProductsServicesPersistence.impl")
	protected larion.progate.service.persistence.ProGateProductsServicesPersistence proGateProductsServicesPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProGateCurrencyTypesPersistence.impl")
	protected larion.progate.service.persistence.ProGateCurrencyTypesPersistence proGateCurrencyTypesPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProGateJournalArticlePrioritiesPersistence.impl")
	protected larion.progate.service.persistence.ProGateJournalArticlePrioritiesPersistence proGateJournalArticlePrioritiesPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProGateJournalArticleTypesPersistence.impl")
	protected larion.progate.service.persistence.ProGateJournalArticleTypesPersistence proGateJournalArticleTypesPersistence;
	@BeanReference(name = "larion.progate.service.persistence.RegionPersistence.impl")
	protected larion.progate.service.persistence.RegionPersistence regionPersistence;
	@BeanReference(name = "larion.progate.service.persistence.CountryPersistence.impl")
	protected larion.progate.service.persistence.CountryPersistence countryPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProGateJournalArticleViewPersistence.impl")
	protected larion.progate.service.persistence.ProGateJournalArticleViewPersistence proGateJournalArticleViewPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProGateJournalArticleSlideShowPersistence.impl")
	protected larion.progate.service.persistence.ProGateJournalArticleSlideShowPersistence proGateJournalArticleSlideShowPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProGateOrgCustomerPersistence.impl")
	protected larion.progate.service.persistence.ProGateOrgCustomerPersistence proGateOrgCustomerPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProGateOrgCustomerRepresenterPersistence.impl")
	protected larion.progate.service.persistence.ProGateOrgCustomerRepresenterPersistence proGateOrgCustomerRepresenterPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProGateApplicationsPersistence.impl")
	protected larion.progate.service.persistence.ProGateApplicationsPersistence proGateApplicationsPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProGateUserApplicationsPersistence.impl")
	protected larion.progate.service.persistence.ProGateUserApplicationsPersistence proGateUserApplicationsPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProgateOrganizationParticipantsPersistence.impl")
	protected larion.progate.service.persistence.ProgateOrganizationParticipantsPersistence progateOrganizationParticipantsPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProgateOrganizationsStaffsPersistence.impl")
	protected larion.progate.service.persistence.ProgateOrganizationsStaffsPersistence progateOrganizationsStaffsPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProgateApplicationsSettingPersistence.impl")
	protected larion.progate.service.persistence.ProgateApplicationsSettingPersistence progateApplicationsSettingPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProgateMenusPersistence.impl")
	protected larion.progate.service.persistence.ProgateMenusPersistence progateMenusPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProgateLayoutsRolesPersistence.impl")
	protected larion.progate.service.persistence.ProgateLayoutsRolesPersistence progateLayoutsRolesPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProgateLayoutsMenusPersistence.impl")
	protected larion.progate.service.persistence.ProgateLayoutsMenusPersistence progateLayoutsMenusPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProGateMenuViewPersistence.impl")
	protected larion.progate.service.persistence.ProGateMenuViewPersistence proGateMenuViewPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProGateOrgsUsersPermissionsPersistence.impl")
	protected larion.progate.service.persistence.ProGateOrgsUsersPermissionsPersistence proGateOrgsUsersPermissionsPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProGatePermissionsPersistence.impl")
	protected larion.progate.service.persistence.ProGatePermissionsPersistence proGatePermissionsPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ViewOrgUsersPermissionsPersistence.impl")
	protected larion.progate.service.persistence.ViewOrgUsersPermissionsPersistence viewOrgUsersPermissionsPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ViewProGatePermissionsRolesPersistence.impl")
	protected larion.progate.service.persistence.ViewProGatePermissionsRolesPersistence viewProGatePermissionsRolesPersistence;
	private static Log _log = LogFactoryUtil.getLog(RegionPersistenceImpl.class);
}