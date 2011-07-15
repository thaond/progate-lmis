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
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQuery;
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQueryFactoryUtil;
import com.liferay.portal.kernel.dao.jdbc.RowMapper;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import larion.progate.cds.NoSuchCdsMinimumRequirementLevelsException;
import larion.progate.cds.model.CdsMinimumRequirementLevels;
import larion.progate.cds.model.impl.CdsMinimumRequirementLevelsImpl;
import larion.progate.cds.model.impl.CdsMinimumRequirementLevelsModelImpl;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="CdsMinimumRequirementLevelsPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsMinimumRequirementLevelsPersistenceImpl
	extends BasePersistenceImpl
	implements CdsMinimumRequirementLevelsPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = CdsMinimumRequirementLevelsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_MINIMUMREQUIREMENTID = new FinderPath(CdsMinimumRequirementLevelsModelImpl.ENTITY_CACHE_ENABLED,
			CdsMinimumRequirementLevelsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByMinimumRequirementId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_MINIMUMREQUIREMENTID = new FinderPath(CdsMinimumRequirementLevelsModelImpl.ENTITY_CACHE_ENABLED,
			CdsMinimumRequirementLevelsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByMinimumRequirementId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_MINIMUMREQUIREMENTID = new FinderPath(CdsMinimumRequirementLevelsModelImpl.ENTITY_CACHE_ENABLED,
			CdsMinimumRequirementLevelsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByMinimumRequirementId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_NAME = new FinderPath(CdsMinimumRequirementLevelsModelImpl.ENTITY_CACHE_ENABLED,
			CdsMinimumRequirementLevelsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_NAME = new FinderPath(CdsMinimumRequirementLevelsModelImpl.ENTITY_CACHE_ENABLED,
			CdsMinimumRequirementLevelsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByName",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(CdsMinimumRequirementLevelsModelImpl.ENTITY_CACHE_ENABLED,
			CdsMinimumRequirementLevelsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(CdsMinimumRequirementLevelsModelImpl.ENTITY_CACHE_ENABLED,
			CdsMinimumRequirementLevelsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CdsMinimumRequirementLevelsModelImpl.ENTITY_CACHE_ENABLED,
			CdsMinimumRequirementLevelsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(
		CdsMinimumRequirementLevels cdsMinimumRequirementLevels) {
		EntityCacheUtil.putResult(CdsMinimumRequirementLevelsModelImpl.ENTITY_CACHE_ENABLED,
			CdsMinimumRequirementLevelsImpl.class,
			cdsMinimumRequirementLevels.getPrimaryKey(),
			cdsMinimumRequirementLevels);
	}

	public void cacheResult(
		List<CdsMinimumRequirementLevels> cdsMinimumRequirementLevelses) {
		for (CdsMinimumRequirementLevels cdsMinimumRequirementLevels : cdsMinimumRequirementLevelses) {
			if (EntityCacheUtil.getResult(
						CdsMinimumRequirementLevelsModelImpl.ENTITY_CACHE_ENABLED,
						CdsMinimumRequirementLevelsImpl.class,
						cdsMinimumRequirementLevels.getPrimaryKey(), this) == null) {
				cacheResult(cdsMinimumRequirementLevels);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(CdsMinimumRequirementLevelsImpl.class.getName());
		EntityCacheUtil.clearCache(CdsMinimumRequirementLevelsImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public CdsMinimumRequirementLevels create(Integer minimumRequirementLevelId) {
		CdsMinimumRequirementLevels cdsMinimumRequirementLevels = new CdsMinimumRequirementLevelsImpl();

		cdsMinimumRequirementLevels.setNew(true);
		cdsMinimumRequirementLevels.setPrimaryKey(minimumRequirementLevelId);

		return cdsMinimumRequirementLevels;
	}

	public CdsMinimumRequirementLevels remove(Integer minimumRequirementLevelId)
		throws NoSuchCdsMinimumRequirementLevelsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CdsMinimumRequirementLevels cdsMinimumRequirementLevels = (CdsMinimumRequirementLevels)session.get(CdsMinimumRequirementLevelsImpl.class,
					minimumRequirementLevelId);

			if (cdsMinimumRequirementLevels == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No CdsMinimumRequirementLevels exists with the primary key " +
						minimumRequirementLevelId);
				}

				throw new NoSuchCdsMinimumRequirementLevelsException(
					"No CdsMinimumRequirementLevels exists with the primary key " +
					minimumRequirementLevelId);
			}

			return remove(cdsMinimumRequirementLevels);
		}
		catch (NoSuchCdsMinimumRequirementLevelsException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public CdsMinimumRequirementLevels remove(
		CdsMinimumRequirementLevels cdsMinimumRequirementLevels)
		throws SystemException {
		for (ModelListener<CdsMinimumRequirementLevels> listener : listeners) {
			listener.onBeforeRemove(cdsMinimumRequirementLevels);
		}

		cdsMinimumRequirementLevels = removeImpl(cdsMinimumRequirementLevels);

		for (ModelListener<CdsMinimumRequirementLevels> listener : listeners) {
			listener.onAfterRemove(cdsMinimumRequirementLevels);
		}

		return cdsMinimumRequirementLevels;
	}

	protected CdsMinimumRequirementLevels removeImpl(
		CdsMinimumRequirementLevels cdsMinimumRequirementLevels)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (cdsMinimumRequirementLevels.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(CdsMinimumRequirementLevelsImpl.class,
						cdsMinimumRequirementLevels.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(cdsMinimumRequirementLevels);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(CdsMinimumRequirementLevelsModelImpl.ENTITY_CACHE_ENABLED,
			CdsMinimumRequirementLevelsImpl.class,
			cdsMinimumRequirementLevels.getPrimaryKey());

		return cdsMinimumRequirementLevels;
	}

	public CdsMinimumRequirementLevels update(
		CdsMinimumRequirementLevels cdsMinimumRequirementLevels)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(CdsMinimumRequirementLevels cdsMinimumRequirementLevels) method. Use update(CdsMinimumRequirementLevels cdsMinimumRequirementLevels, boolean merge) instead.");
		}

		return update(cdsMinimumRequirementLevels, false);
	}

	public CdsMinimumRequirementLevels update(
		CdsMinimumRequirementLevels cdsMinimumRequirementLevels, boolean merge)
		throws SystemException {
		boolean isNew = cdsMinimumRequirementLevels.isNew();

		for (ModelListener<CdsMinimumRequirementLevels> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(cdsMinimumRequirementLevels);
			}
			else {
				listener.onBeforeUpdate(cdsMinimumRequirementLevels);
			}
		}

		cdsMinimumRequirementLevels = updateImpl(cdsMinimumRequirementLevels,
				merge);

		for (ModelListener<CdsMinimumRequirementLevels> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(cdsMinimumRequirementLevels);
			}
			else {
				listener.onAfterUpdate(cdsMinimumRequirementLevels);
			}
		}

		return cdsMinimumRequirementLevels;
	}

	public CdsMinimumRequirementLevels updateImpl(
		larion.progate.cds.model.CdsMinimumRequirementLevels cdsMinimumRequirementLevels,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, cdsMinimumRequirementLevels, merge);

			cdsMinimumRequirementLevels.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(CdsMinimumRequirementLevelsModelImpl.ENTITY_CACHE_ENABLED,
			CdsMinimumRequirementLevelsImpl.class,
			cdsMinimumRequirementLevels.getPrimaryKey(),
			cdsMinimumRequirementLevels);

		return cdsMinimumRequirementLevels;
	}

	public CdsMinimumRequirementLevels findByPrimaryKey(
		Integer minimumRequirementLevelId)
		throws NoSuchCdsMinimumRequirementLevelsException, SystemException {
		CdsMinimumRequirementLevels cdsMinimumRequirementLevels = fetchByPrimaryKey(minimumRequirementLevelId);

		if (cdsMinimumRequirementLevels == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"No CdsMinimumRequirementLevels exists with the primary key " +
					minimumRequirementLevelId);
			}

			throw new NoSuchCdsMinimumRequirementLevelsException(
				"No CdsMinimumRequirementLevels exists with the primary key " +
				minimumRequirementLevelId);
		}

		return cdsMinimumRequirementLevels;
	}

	public CdsMinimumRequirementLevels fetchByPrimaryKey(
		Integer minimumRequirementLevelId) throws SystemException {
		CdsMinimumRequirementLevels cdsMinimumRequirementLevels = (CdsMinimumRequirementLevels)EntityCacheUtil.getResult(CdsMinimumRequirementLevelsModelImpl.ENTITY_CACHE_ENABLED,
				CdsMinimumRequirementLevelsImpl.class,
				minimumRequirementLevelId, this);

		if (cdsMinimumRequirementLevels == null) {
			Session session = null;

			try {
				session = openSession();

				cdsMinimumRequirementLevels = (CdsMinimumRequirementLevels)session.get(CdsMinimumRequirementLevelsImpl.class,
						minimumRequirementLevelId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (cdsMinimumRequirementLevels != null) {
					cacheResult(cdsMinimumRequirementLevels);
				}

				closeSession(session);
			}
		}

		return cdsMinimumRequirementLevels;
	}

	public List<CdsMinimumRequirementLevels> findByMinimumRequirementId(
		int minimumRequirementId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(minimumRequirementId) };

		List<CdsMinimumRequirementLevels> list = (List<CdsMinimumRequirementLevels>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_MINIMUMREQUIREMENTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.CdsMinimumRequirementLevels WHERE ");

				query.append("minimum_requirement_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("number_order ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(minimumRequirementId);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsMinimumRequirementLevels>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_MINIMUMREQUIREMENTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<CdsMinimumRequirementLevels> findByMinimumRequirementId(
		int minimumRequirementId, int start, int end) throws SystemException {
		return findByMinimumRequirementId(minimumRequirementId, start, end, null);
	}

	public List<CdsMinimumRequirementLevels> findByMinimumRequirementId(
		int minimumRequirementId, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(minimumRequirementId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<CdsMinimumRequirementLevels> list = (List<CdsMinimumRequirementLevels>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_MINIMUMREQUIREMENTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.CdsMinimumRequirementLevels WHERE ");

				query.append("minimum_requirement_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("number_order ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(minimumRequirementId);

				list = (List<CdsMinimumRequirementLevels>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsMinimumRequirementLevels>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_MINIMUMREQUIREMENTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public CdsMinimumRequirementLevels findByMinimumRequirementId_First(
		int minimumRequirementId, OrderByComparator obc)
		throws NoSuchCdsMinimumRequirementLevelsException, SystemException {
		List<CdsMinimumRequirementLevels> list = findByMinimumRequirementId(minimumRequirementId,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No CdsMinimumRequirementLevels exists with the key {");

			msg.append("minimumRequirementId=" + minimumRequirementId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsMinimumRequirementLevelsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsMinimumRequirementLevels findByMinimumRequirementId_Last(
		int minimumRequirementId, OrderByComparator obc)
		throws NoSuchCdsMinimumRequirementLevelsException, SystemException {
		int count = countByMinimumRequirementId(minimumRequirementId);

		List<CdsMinimumRequirementLevels> list = findByMinimumRequirementId(minimumRequirementId,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No CdsMinimumRequirementLevels exists with the key {");

			msg.append("minimumRequirementId=" + minimumRequirementId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsMinimumRequirementLevelsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsMinimumRequirementLevels[] findByMinimumRequirementId_PrevAndNext(
		Integer minimumRequirementLevelId, int minimumRequirementId,
		OrderByComparator obc)
		throws NoSuchCdsMinimumRequirementLevelsException, SystemException {
		CdsMinimumRequirementLevels cdsMinimumRequirementLevels = findByPrimaryKey(minimumRequirementLevelId);

		int count = countByMinimumRequirementId(minimumRequirementId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.cds.model.CdsMinimumRequirementLevels WHERE ");

			query.append("minimum_requirement_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("number_order ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(minimumRequirementId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					cdsMinimumRequirementLevels);

			CdsMinimumRequirementLevels[] array = new CdsMinimumRequirementLevelsImpl[3];

			array[0] = (CdsMinimumRequirementLevels)objArray[0];
			array[1] = (CdsMinimumRequirementLevels)objArray[1];
			array[2] = (CdsMinimumRequirementLevels)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<CdsMinimumRequirementLevels> findByName(String name)
		throws SystemException {
		Object[] finderArgs = new Object[] { name };

		List<CdsMinimumRequirementLevels> list = (List<CdsMinimumRequirementLevels>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_NAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.CdsMinimumRequirementLevels WHERE ");

				if (name == null) {
					query.append("name LIKE null");
				}
				else {
					query.append("name LIKE ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("number_order ASC");

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
					list = new ArrayList<CdsMinimumRequirementLevels>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_NAME, finderArgs,
					list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<CdsMinimumRequirementLevels> findByName(String name, int start,
		int end) throws SystemException {
		return findByName(name, start, end, null);
	}

	public List<CdsMinimumRequirementLevels> findByName(String name, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				name,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<CdsMinimumRequirementLevels> list = (List<CdsMinimumRequirementLevels>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_NAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.CdsMinimumRequirementLevels WHERE ");

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

				else {
					query.append("ORDER BY ");

					query.append("number_order ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (name != null) {
					qPos.add(name);
				}

				list = (List<CdsMinimumRequirementLevels>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsMinimumRequirementLevels>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_NAME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public CdsMinimumRequirementLevels findByName_First(String name,
		OrderByComparator obc)
		throws NoSuchCdsMinimumRequirementLevelsException, SystemException {
		List<CdsMinimumRequirementLevels> list = findByName(name, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No CdsMinimumRequirementLevels exists with the key {");

			msg.append("name=" + name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsMinimumRequirementLevelsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsMinimumRequirementLevels findByName_Last(String name,
		OrderByComparator obc)
		throws NoSuchCdsMinimumRequirementLevelsException, SystemException {
		int count = countByName(name);

		List<CdsMinimumRequirementLevels> list = findByName(name, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No CdsMinimumRequirementLevels exists with the key {");

			msg.append("name=" + name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsMinimumRequirementLevelsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsMinimumRequirementLevels[] findByName_PrevAndNext(
		Integer minimumRequirementLevelId, String name, OrderByComparator obc)
		throws NoSuchCdsMinimumRequirementLevelsException, SystemException {
		CdsMinimumRequirementLevels cdsMinimumRequirementLevels = findByPrimaryKey(minimumRequirementLevelId);

		int count = countByName(name);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.cds.model.CdsMinimumRequirementLevels WHERE ");

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

			else {
				query.append("ORDER BY ");

				query.append("number_order ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (name != null) {
				qPos.add(name);
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					cdsMinimumRequirementLevels);

			CdsMinimumRequirementLevels[] array = new CdsMinimumRequirementLevelsImpl[3];

			array[0] = (CdsMinimumRequirementLevels)objArray[0];
			array[1] = (CdsMinimumRequirementLevels)objArray[1];
			array[2] = (CdsMinimumRequirementLevels)objArray[2];

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

	public List<CdsMinimumRequirementLevels> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<CdsMinimumRequirementLevels> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<CdsMinimumRequirementLevels> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<CdsMinimumRequirementLevels> list = (List<CdsMinimumRequirementLevels>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.CdsMinimumRequirementLevels ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("number_order ASC");
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<CdsMinimumRequirementLevels>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<CdsMinimumRequirementLevels>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsMinimumRequirementLevels>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByMinimumRequirementId(int minimumRequirementId)
		throws SystemException {
		for (CdsMinimumRequirementLevels cdsMinimumRequirementLevels : findByMinimumRequirementId(
				minimumRequirementId)) {
			remove(cdsMinimumRequirementLevels);
		}
	}

	public void removeByName(String name) throws SystemException {
		for (CdsMinimumRequirementLevels cdsMinimumRequirementLevels : findByName(
				name)) {
			remove(cdsMinimumRequirementLevels);
		}
	}

	public void removeAll() throws SystemException {
		for (CdsMinimumRequirementLevels cdsMinimumRequirementLevels : findAll()) {
			remove(cdsMinimumRequirementLevels);
		}
	}

	public int countByMinimumRequirementId(int minimumRequirementId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(minimumRequirementId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MINIMUMREQUIREMENTID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.cds.model.CdsMinimumRequirementLevels WHERE ");

				query.append("minimum_requirement_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(minimumRequirementId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MINIMUMREQUIREMENTID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByName(String name) throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_NAME,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.cds.model.CdsMinimumRequirementLevels WHERE ");

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

	public int countAll() throws SystemException {
		Object[] finderArgs = new Object[0];

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(
						"SELECT COUNT(*) FROM larion.progate.cds.model.CdsMinimumRequirementLevels");

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

	public List<larion.progate.cds.model.CdsTitleMinimumRequirements> getCdsTitleMinimumRequirementses(
		Integer pk) throws SystemException {
		return getCdsTitleMinimumRequirementses(pk, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS);
	}

	public List<larion.progate.cds.model.CdsTitleMinimumRequirements> getCdsTitleMinimumRequirementses(
		Integer pk, int start, int end) throws SystemException {
		return getCdsTitleMinimumRequirementses(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_CDSTITLEMINIMUMREQUIREMENTSES =
		new FinderPath(larion.progate.cds.model.impl.CdsTitleMinimumRequirementsModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.cds.model.impl.CdsTitleMinimumRequirementsModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.cds.service.persistence.CdsTitleMinimumRequirementsPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getCdsTitleMinimumRequirementses",
			new String[] {
				Integer.class.getName(), "java.lang.Integer",
				"java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	public List<larion.progate.cds.model.CdsTitleMinimumRequirements> getCdsTitleMinimumRequirementses(
		Integer pk, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				pk, String.valueOf(start), String.valueOf(end),
				String.valueOf(obc)
			};

		List<larion.progate.cds.model.CdsTitleMinimumRequirements> list = (List<larion.progate.cds.model.CdsTitleMinimumRequirements>)FinderCacheUtil.getResult(FINDER_PATH_GET_CDSTITLEMINIMUMREQUIREMENTSES,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder sb = new StringBuilder();

				sb.append(_SQL_GETCDSTITLEMINIMUMREQUIREMENTSES);

				if (obc != null) {
					sb.append("ORDER BY ");
					sb.append(obc.getOrderBy());
				}

				String sql = sb.toString();

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("cds_title_minimum_requirements",
					larion.progate.cds.model.impl.CdsTitleMinimumRequirementsImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<larion.progate.cds.model.CdsTitleMinimumRequirements>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<larion.progate.cds.model.CdsTitleMinimumRequirements>();
				}

				cdsTitleMinimumRequirementsPersistence.cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_GET_CDSTITLEMINIMUMREQUIREMENTSES,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_CDSTITLEMINIMUMREQUIREMENTSES_SIZE =
		new FinderPath(larion.progate.cds.model.impl.CdsTitleMinimumRequirementsModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.cds.model.impl.CdsTitleMinimumRequirementsModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.cds.service.persistence.CdsTitleMinimumRequirementsPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getCdsTitleMinimumRequirementsesSize",
			new String[] { Integer.class.getName() });

	public int getCdsTitleMinimumRequirementsesSize(Integer pk)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_CDSTITLEMINIMUMREQUIREMENTSES_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETCDSTITLEMINIMUMREQUIREMENTSESSIZE);

				q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_GET_CDSTITLEMINIMUMREQUIREMENTSES_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_CDSTITLEMINIMUMREQUIREMENTS =
		new FinderPath(larion.progate.cds.model.impl.CdsTitleMinimumRequirementsModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.cds.model.impl.CdsTitleMinimumRequirementsModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.cds.service.persistence.CdsTitleMinimumRequirementsPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"containsCdsTitleMinimumRequirements",
			new String[] { Integer.class.getName(), Integer.class.getName() });

	public boolean containsCdsTitleMinimumRequirements(Integer pk,
		Integer cdsTitleMinimumRequirementsPK) throws SystemException {
		Object[] finderArgs = new Object[] { pk, cdsTitleMinimumRequirementsPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_CDSTITLEMINIMUMREQUIREMENTS,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsCdsTitleMinimumRequirements.contains(
							pk, cdsTitleMinimumRequirementsPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_CDSTITLEMINIMUMREQUIREMENTS,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	public boolean containsCdsTitleMinimumRequirementses(Integer pk)
		throws SystemException {
		if (getCdsTitleMinimumRequirementsesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.larion.progate.cds.model.CdsMinimumRequirementLevels")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CdsMinimumRequirementLevels>> listenersList = new ArrayList<ModelListener<CdsMinimumRequirementLevels>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CdsMinimumRequirementLevels>)Class.forName(
							listenerClassName).newInstance());
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		containsCdsTitleMinimumRequirements = new ContainsCdsTitleMinimumRequirements(this);
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
	protected ContainsCdsTitleMinimumRequirements containsCdsTitleMinimumRequirements;

	protected class ContainsCdsTitleMinimumRequirements {
		protected ContainsCdsTitleMinimumRequirements(
			CdsMinimumRequirementLevelsPersistenceImpl persistenceImpl) {
			super();

			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSCDSTITLEMINIMUMREQUIREMENTS,
					new int[] { Types.INTEGER, Types.INTEGER }, RowMapper.COUNT);
		}

		protected boolean contains(Integer minimumRequirementLevelId,
			Integer CdsTitleMinimumRequirementsId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						minimumRequirementLevelId, CdsTitleMinimumRequirementsId
					});

			if (results.size() > 0) {
				Integer count = results.get(0);

				if (count.intValue() > 0) {
					return true;
				}
			}

			return false;
		}

		private MappingSqlQuery _mappingSqlQuery;
	}

	private static final String _SQL_GETCDSTITLEMINIMUMREQUIREMENTSES = "SELECT {cds_title_minimum_requirements.*} FROM cds_title_minimum_requirements INNER JOIN cds_minimum_requirement_levels ON (cds_minimum_requirement_levels.minimumRequirementLevelId = cds_title_minimum_requirements.minimumRequirementLevelId) WHERE (cds_minimum_requirement_levels.minimumRequirementLevelId = ?)";
	private static final String _SQL_GETCDSTITLEMINIMUMREQUIREMENTSESSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM cds_title_minimum_requirements WHERE minimumRequirementLevelId = ?";
	private static final String _SQL_CONTAINSCDSTITLEMINIMUMREQUIREMENTS = "SELECT COUNT(*) AS COUNT_VALUE FROM cds_title_minimum_requirements WHERE minimumRequirementLevelId = ? AND CdsTitleMinimumRequirementsId = ?";
	private static Log _log = LogFactoryUtil.getLog(CdsMinimumRequirementLevelsPersistenceImpl.class);
}