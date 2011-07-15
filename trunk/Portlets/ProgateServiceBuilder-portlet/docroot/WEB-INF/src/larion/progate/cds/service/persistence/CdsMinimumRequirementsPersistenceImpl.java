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

import larion.progate.cds.NoSuchCdsMinimumRequirementsException;
import larion.progate.cds.model.CdsMinimumRequirements;
import larion.progate.cds.model.impl.CdsMinimumRequirementsImpl;
import larion.progate.cds.model.impl.CdsMinimumRequirementsModelImpl;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="CdsMinimumRequirementsPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsMinimumRequirementsPersistenceImpl extends BasePersistenceImpl
	implements CdsMinimumRequirementsPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = CdsMinimumRequirementsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_ROOTID = new FinderPath(CdsMinimumRequirementsModelImpl.ENTITY_CACHE_ENABLED,
			CdsMinimumRequirementsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ROOTID = new FinderPath(CdsMinimumRequirementsModelImpl.ENTITY_CACHE_ENABLED,
			CdsMinimumRequirementsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ROOTID = new FinderPath(CdsMinimumRequirementsModelImpl.ENTITY_CACHE_ENABLED,
			CdsMinimumRequirementsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByRootId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_NUMBERORDERGREATER = new FinderPath(CdsMinimumRequirementsModelImpl.ENTITY_CACHE_ENABLED,
			CdsMinimumRequirementsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBynumberOrderGreater",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_NUMBERORDERGREATER = new FinderPath(CdsMinimumRequirementsModelImpl.ENTITY_CACHE_ENABLED,
			CdsMinimumRequirementsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBynumberOrderGreater",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_NUMBERORDERGREATER = new FinderPath(CdsMinimumRequirementsModelImpl.ENTITY_CACHE_ENABLED,
			CdsMinimumRequirementsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBynumberOrderGreater",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_NAME = new FinderPath(CdsMinimumRequirementsModelImpl.ENTITY_CACHE_ENABLED,
			CdsMinimumRequirementsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_NAME = new FinderPath(CdsMinimumRequirementsModelImpl.ENTITY_CACHE_ENABLED,
			CdsMinimumRequirementsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByName",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(CdsMinimumRequirementsModelImpl.ENTITY_CACHE_ENABLED,
			CdsMinimumRequirementsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(CdsMinimumRequirementsModelImpl.ENTITY_CACHE_ENABLED,
			CdsMinimumRequirementsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CdsMinimumRequirementsModelImpl.ENTITY_CACHE_ENABLED,
			CdsMinimumRequirementsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(CdsMinimumRequirements cdsMinimumRequirements) {
		EntityCacheUtil.putResult(CdsMinimumRequirementsModelImpl.ENTITY_CACHE_ENABLED,
			CdsMinimumRequirementsImpl.class,
			cdsMinimumRequirements.getPrimaryKey(), cdsMinimumRequirements);
	}

	public void cacheResult(
		List<CdsMinimumRequirements> cdsMinimumRequirementses) {
		for (CdsMinimumRequirements cdsMinimumRequirements : cdsMinimumRequirementses) {
			if (EntityCacheUtil.getResult(
						CdsMinimumRequirementsModelImpl.ENTITY_CACHE_ENABLED,
						CdsMinimumRequirementsImpl.class,
						cdsMinimumRequirements.getPrimaryKey(), this) == null) {
				cacheResult(cdsMinimumRequirements);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(CdsMinimumRequirementsImpl.class.getName());
		EntityCacheUtil.clearCache(CdsMinimumRequirementsImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public CdsMinimumRequirements create(Integer minimumRequirementId) {
		CdsMinimumRequirements cdsMinimumRequirements = new CdsMinimumRequirementsImpl();

		cdsMinimumRequirements.setNew(true);
		cdsMinimumRequirements.setPrimaryKey(minimumRequirementId);

		return cdsMinimumRequirements;
	}

	public CdsMinimumRequirements remove(Integer minimumRequirementId)
		throws NoSuchCdsMinimumRequirementsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CdsMinimumRequirements cdsMinimumRequirements = (CdsMinimumRequirements)session.get(CdsMinimumRequirementsImpl.class,
					minimumRequirementId);

			if (cdsMinimumRequirements == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No CdsMinimumRequirements exists with the primary key " +
						minimumRequirementId);
				}

				throw new NoSuchCdsMinimumRequirementsException(
					"No CdsMinimumRequirements exists with the primary key " +
					minimumRequirementId);
			}

			return remove(cdsMinimumRequirements);
		}
		catch (NoSuchCdsMinimumRequirementsException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public CdsMinimumRequirements remove(
		CdsMinimumRequirements cdsMinimumRequirements)
		throws SystemException {
		for (ModelListener<CdsMinimumRequirements> listener : listeners) {
			listener.onBeforeRemove(cdsMinimumRequirements);
		}

		cdsMinimumRequirements = removeImpl(cdsMinimumRequirements);

		for (ModelListener<CdsMinimumRequirements> listener : listeners) {
			listener.onAfterRemove(cdsMinimumRequirements);
		}

		return cdsMinimumRequirements;
	}

	protected CdsMinimumRequirements removeImpl(
		CdsMinimumRequirements cdsMinimumRequirements)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (cdsMinimumRequirements.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(CdsMinimumRequirementsImpl.class,
						cdsMinimumRequirements.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(cdsMinimumRequirements);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(CdsMinimumRequirementsModelImpl.ENTITY_CACHE_ENABLED,
			CdsMinimumRequirementsImpl.class,
			cdsMinimumRequirements.getPrimaryKey());

		return cdsMinimumRequirements;
	}

	public CdsMinimumRequirements update(
		CdsMinimumRequirements cdsMinimumRequirements)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(CdsMinimumRequirements cdsMinimumRequirements) method. Use update(CdsMinimumRequirements cdsMinimumRequirements, boolean merge) instead.");
		}

		return update(cdsMinimumRequirements, false);
	}

	public CdsMinimumRequirements update(
		CdsMinimumRequirements cdsMinimumRequirements, boolean merge)
		throws SystemException {
		boolean isNew = cdsMinimumRequirements.isNew();

		for (ModelListener<CdsMinimumRequirements> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(cdsMinimumRequirements);
			}
			else {
				listener.onBeforeUpdate(cdsMinimumRequirements);
			}
		}

		cdsMinimumRequirements = updateImpl(cdsMinimumRequirements, merge);

		for (ModelListener<CdsMinimumRequirements> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(cdsMinimumRequirements);
			}
			else {
				listener.onAfterUpdate(cdsMinimumRequirements);
			}
		}

		return cdsMinimumRequirements;
	}

	public CdsMinimumRequirements updateImpl(
		larion.progate.cds.model.CdsMinimumRequirements cdsMinimumRequirements,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, cdsMinimumRequirements, merge);

			cdsMinimumRequirements.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(CdsMinimumRequirementsModelImpl.ENTITY_CACHE_ENABLED,
			CdsMinimumRequirementsImpl.class,
			cdsMinimumRequirements.getPrimaryKey(), cdsMinimumRequirements);

		return cdsMinimumRequirements;
	}

	public CdsMinimumRequirements findByPrimaryKey(Integer minimumRequirementId)
		throws NoSuchCdsMinimumRequirementsException, SystemException {
		CdsMinimumRequirements cdsMinimumRequirements = fetchByPrimaryKey(minimumRequirementId);

		if (cdsMinimumRequirements == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"No CdsMinimumRequirements exists with the primary key " +
					minimumRequirementId);
			}

			throw new NoSuchCdsMinimumRequirementsException(
				"No CdsMinimumRequirements exists with the primary key " +
				minimumRequirementId);
		}

		return cdsMinimumRequirements;
	}

	public CdsMinimumRequirements fetchByPrimaryKey(
		Integer minimumRequirementId) throws SystemException {
		CdsMinimumRequirements cdsMinimumRequirements = (CdsMinimumRequirements)EntityCacheUtil.getResult(CdsMinimumRequirementsModelImpl.ENTITY_CACHE_ENABLED,
				CdsMinimumRequirementsImpl.class, minimumRequirementId, this);

		if (cdsMinimumRequirements == null) {
			Session session = null;

			try {
				session = openSession();

				cdsMinimumRequirements = (CdsMinimumRequirements)session.get(CdsMinimumRequirementsImpl.class,
						minimumRequirementId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (cdsMinimumRequirements != null) {
					cacheResult(cdsMinimumRequirements);
				}

				closeSession(session);
			}
		}

		return cdsMinimumRequirements;
	}

	public List<CdsMinimumRequirements> findByRootId(int rootId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		List<CdsMinimumRequirements> list = (List<CdsMinimumRequirements>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.CdsMinimumRequirements WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("number_order ASC");

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
					list = new ArrayList<CdsMinimumRequirements>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<CdsMinimumRequirements> findByRootId(int rootId, int start,
		int end) throws SystemException {
		return findByRootId(rootId, start, end, null);
	}

	public List<CdsMinimumRequirements> findByRootId(int rootId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(rootId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<CdsMinimumRequirements> list = (List<CdsMinimumRequirements>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.CdsMinimumRequirements WHERE ");

				query.append("root_id = ?");

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

				qPos.add(rootId);

				list = (List<CdsMinimumRequirements>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsMinimumRequirements>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public CdsMinimumRequirements findByRootId_First(int rootId,
		OrderByComparator obc)
		throws NoSuchCdsMinimumRequirementsException, SystemException {
		List<CdsMinimumRequirements> list = findByRootId(rootId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No CdsMinimumRequirements exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsMinimumRequirementsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsMinimumRequirements findByRootId_Last(int rootId,
		OrderByComparator obc)
		throws NoSuchCdsMinimumRequirementsException, SystemException {
		int count = countByRootId(rootId);

		List<CdsMinimumRequirements> list = findByRootId(rootId, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No CdsMinimumRequirements exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsMinimumRequirementsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsMinimumRequirements[] findByRootId_PrevAndNext(
		Integer minimumRequirementId, int rootId, OrderByComparator obc)
		throws NoSuchCdsMinimumRequirementsException, SystemException {
		CdsMinimumRequirements cdsMinimumRequirements = findByPrimaryKey(minimumRequirementId);

		int count = countByRootId(rootId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.cds.model.CdsMinimumRequirements WHERE ");

			query.append("root_id = ?");

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

			qPos.add(rootId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					cdsMinimumRequirements);

			CdsMinimumRequirements[] array = new CdsMinimumRequirementsImpl[3];

			array[0] = (CdsMinimumRequirements)objArray[0];
			array[1] = (CdsMinimumRequirements)objArray[1];
			array[2] = (CdsMinimumRequirements)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<CdsMinimumRequirements> findBynumberOrderGreater(
		int numberOrder) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(numberOrder) };

		List<CdsMinimumRequirements> list = (List<CdsMinimumRequirements>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_NUMBERORDERGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.CdsMinimumRequirements WHERE ");

				query.append("number_order > ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("number_order ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(numberOrder);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsMinimumRequirements>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_NUMBERORDERGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<CdsMinimumRequirements> findBynumberOrderGreater(
		int numberOrder, int start, int end) throws SystemException {
		return findBynumberOrderGreater(numberOrder, start, end, null);
	}

	public List<CdsMinimumRequirements> findBynumberOrderGreater(
		int numberOrder, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(numberOrder),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<CdsMinimumRequirements> list = (List<CdsMinimumRequirements>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_NUMBERORDERGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.CdsMinimumRequirements WHERE ");

				query.append("number_order > ?");

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

				qPos.add(numberOrder);

				list = (List<CdsMinimumRequirements>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsMinimumRequirements>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_NUMBERORDERGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public CdsMinimumRequirements findBynumberOrderGreater_First(
		int numberOrder, OrderByComparator obc)
		throws NoSuchCdsMinimumRequirementsException, SystemException {
		List<CdsMinimumRequirements> list = findBynumberOrderGreater(numberOrder,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No CdsMinimumRequirements exists with the key {");

			msg.append("numberOrder=" + numberOrder);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsMinimumRequirementsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsMinimumRequirements findBynumberOrderGreater_Last(
		int numberOrder, OrderByComparator obc)
		throws NoSuchCdsMinimumRequirementsException, SystemException {
		int count = countBynumberOrderGreater(numberOrder);

		List<CdsMinimumRequirements> list = findBynumberOrderGreater(numberOrder,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No CdsMinimumRequirements exists with the key {");

			msg.append("numberOrder=" + numberOrder);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsMinimumRequirementsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsMinimumRequirements[] findBynumberOrderGreater_PrevAndNext(
		Integer minimumRequirementId, int numberOrder, OrderByComparator obc)
		throws NoSuchCdsMinimumRequirementsException, SystemException {
		CdsMinimumRequirements cdsMinimumRequirements = findByPrimaryKey(minimumRequirementId);

		int count = countBynumberOrderGreater(numberOrder);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.cds.model.CdsMinimumRequirements WHERE ");

			query.append("number_order > ?");

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

			qPos.add(numberOrder);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					cdsMinimumRequirements);

			CdsMinimumRequirements[] array = new CdsMinimumRequirementsImpl[3];

			array[0] = (CdsMinimumRequirements)objArray[0];
			array[1] = (CdsMinimumRequirements)objArray[1];
			array[2] = (CdsMinimumRequirements)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<CdsMinimumRequirements> findByName(String name)
		throws SystemException {
		Object[] finderArgs = new Object[] { name };

		List<CdsMinimumRequirements> list = (List<CdsMinimumRequirements>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_NAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.CdsMinimumRequirements WHERE ");

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
					list = new ArrayList<CdsMinimumRequirements>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_NAME, finderArgs,
					list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<CdsMinimumRequirements> findByName(String name, int start,
		int end) throws SystemException {
		return findByName(name, start, end, null);
	}

	public List<CdsMinimumRequirements> findByName(String name, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				name,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<CdsMinimumRequirements> list = (List<CdsMinimumRequirements>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_NAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.CdsMinimumRequirements WHERE ");

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

				list = (List<CdsMinimumRequirements>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsMinimumRequirements>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_NAME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public CdsMinimumRequirements findByName_First(String name,
		OrderByComparator obc)
		throws NoSuchCdsMinimumRequirementsException, SystemException {
		List<CdsMinimumRequirements> list = findByName(name, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No CdsMinimumRequirements exists with the key {");

			msg.append("name=" + name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsMinimumRequirementsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsMinimumRequirements findByName_Last(String name,
		OrderByComparator obc)
		throws NoSuchCdsMinimumRequirementsException, SystemException {
		int count = countByName(name);

		List<CdsMinimumRequirements> list = findByName(name, count - 1, count,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No CdsMinimumRequirements exists with the key {");

			msg.append("name=" + name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsMinimumRequirementsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsMinimumRequirements[] findByName_PrevAndNext(
		Integer minimumRequirementId, String name, OrderByComparator obc)
		throws NoSuchCdsMinimumRequirementsException, SystemException {
		CdsMinimumRequirements cdsMinimumRequirements = findByPrimaryKey(minimumRequirementId);

		int count = countByName(name);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.cds.model.CdsMinimumRequirements WHERE ");

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
					cdsMinimumRequirements);

			CdsMinimumRequirements[] array = new CdsMinimumRequirementsImpl[3];

			array[0] = (CdsMinimumRequirements)objArray[0];
			array[1] = (CdsMinimumRequirements)objArray[1];
			array[2] = (CdsMinimumRequirements)objArray[2];

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

	public List<CdsMinimumRequirements> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<CdsMinimumRequirements> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<CdsMinimumRequirements> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<CdsMinimumRequirements> list = (List<CdsMinimumRequirements>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.CdsMinimumRequirements ");

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
					list = (List<CdsMinimumRequirements>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<CdsMinimumRequirements>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsMinimumRequirements>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByRootId(int rootId) throws SystemException {
		for (CdsMinimumRequirements cdsMinimumRequirements : findByRootId(
				rootId)) {
			remove(cdsMinimumRequirements);
		}
	}

	public void removeBynumberOrderGreater(int numberOrder)
		throws SystemException {
		for (CdsMinimumRequirements cdsMinimumRequirements : findBynumberOrderGreater(
				numberOrder)) {
			remove(cdsMinimumRequirements);
		}
	}

	public void removeByName(String name) throws SystemException {
		for (CdsMinimumRequirements cdsMinimumRequirements : findByName(name)) {
			remove(cdsMinimumRequirements);
		}
	}

	public void removeAll() throws SystemException {
		for (CdsMinimumRequirements cdsMinimumRequirements : findAll()) {
			remove(cdsMinimumRequirements);
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
					"FROM larion.progate.cds.model.CdsMinimumRequirements WHERE ");

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

	public int countBynumberOrderGreater(int numberOrder)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(numberOrder) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_NUMBERORDERGREATER,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.cds.model.CdsMinimumRequirements WHERE ");

				query.append("number_order > ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(numberOrder);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NUMBERORDERGREATER,
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
					"FROM larion.progate.cds.model.CdsMinimumRequirements WHERE ");

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
						"SELECT COUNT(*) FROM larion.progate.cds.model.CdsMinimumRequirements");

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

	public List<larion.progate.cds.model.CdsMinimumRequirementLevels> getCdsMinimumRequirementLevelses(
		Integer pk) throws SystemException {
		return getCdsMinimumRequirementLevelses(pk, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS);
	}

	public List<larion.progate.cds.model.CdsMinimumRequirementLevels> getCdsMinimumRequirementLevelses(
		Integer pk, int start, int end) throws SystemException {
		return getCdsMinimumRequirementLevelses(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_CDSMINIMUMREQUIREMENTLEVELSES =
		new FinderPath(larion.progate.cds.model.impl.CdsMinimumRequirementLevelsModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.cds.model.impl.CdsMinimumRequirementLevelsModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.cds.service.persistence.CdsMinimumRequirementLevelsPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getCdsMinimumRequirementLevelses",
			new String[] {
				Integer.class.getName(), "java.lang.Integer",
				"java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	public List<larion.progate.cds.model.CdsMinimumRequirementLevels> getCdsMinimumRequirementLevelses(
		Integer pk, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				pk, String.valueOf(start), String.valueOf(end),
				String.valueOf(obc)
			};

		List<larion.progate.cds.model.CdsMinimumRequirementLevels> list = (List<larion.progate.cds.model.CdsMinimumRequirementLevels>)FinderCacheUtil.getResult(FINDER_PATH_GET_CDSMINIMUMREQUIREMENTLEVELSES,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder sb = new StringBuilder();

				sb.append(_SQL_GETCDSMINIMUMREQUIREMENTLEVELSES);

				if (obc != null) {
					sb.append("ORDER BY ");
					sb.append(obc.getOrderBy());
				}

				else {
					sb.append("ORDER BY ");

					sb.append("cds_minimum_requirement_levels.number_order ASC");
				}

				String sql = sb.toString();

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("cds_minimum_requirement_levels",
					larion.progate.cds.model.impl.CdsMinimumRequirementLevelsImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<larion.progate.cds.model.CdsMinimumRequirementLevels>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<larion.progate.cds.model.CdsMinimumRequirementLevels>();
				}

				cdsMinimumRequirementLevelsPersistence.cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_GET_CDSMINIMUMREQUIREMENTLEVELSES,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_CDSMINIMUMREQUIREMENTLEVELSES_SIZE =
		new FinderPath(larion.progate.cds.model.impl.CdsMinimumRequirementLevelsModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.cds.model.impl.CdsMinimumRequirementLevelsModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.cds.service.persistence.CdsMinimumRequirementLevelsPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getCdsMinimumRequirementLevelsesSize",
			new String[] { Integer.class.getName() });

	public int getCdsMinimumRequirementLevelsesSize(Integer pk)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_CDSMINIMUMREQUIREMENTLEVELSES_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETCDSMINIMUMREQUIREMENTLEVELSESSIZE);

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

				FinderCacheUtil.putResult(FINDER_PATH_GET_CDSMINIMUMREQUIREMENTLEVELSES_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_CDSMINIMUMREQUIREMENTLEVELS =
		new FinderPath(larion.progate.cds.model.impl.CdsMinimumRequirementLevelsModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.cds.model.impl.CdsMinimumRequirementLevelsModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.cds.service.persistence.CdsMinimumRequirementLevelsPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"containsCdsMinimumRequirementLevels",
			new String[] { Integer.class.getName(), Integer.class.getName() });

	public boolean containsCdsMinimumRequirementLevels(Integer pk,
		Integer cdsMinimumRequirementLevelsPK) throws SystemException {
		Object[] finderArgs = new Object[] { pk, cdsMinimumRequirementLevelsPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_CDSMINIMUMREQUIREMENTLEVELS,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsCdsMinimumRequirementLevels.contains(
							pk, cdsMinimumRequirementLevelsPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_CDSMINIMUMREQUIREMENTLEVELS,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	public boolean containsCdsMinimumRequirementLevelses(Integer pk)
		throws SystemException {
		if (getCdsMinimumRequirementLevelsesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
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
						"value.object.listener.larion.progate.cds.model.CdsMinimumRequirements")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CdsMinimumRequirements>> listenersList = new ArrayList<ModelListener<CdsMinimumRequirements>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CdsMinimumRequirements>)Class.forName(
							listenerClassName).newInstance());
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		containsCdsMinimumRequirementLevels = new ContainsCdsMinimumRequirementLevels(this);

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
	protected ContainsCdsMinimumRequirementLevels containsCdsMinimumRequirementLevels;
	protected ContainsCdsTitleMinimumRequirements containsCdsTitleMinimumRequirements;

	protected class ContainsCdsMinimumRequirementLevels {
		protected ContainsCdsMinimumRequirementLevels(
			CdsMinimumRequirementsPersistenceImpl persistenceImpl) {
			super();

			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSCDSMINIMUMREQUIREMENTLEVELS,
					new int[] { Types.INTEGER, Types.INTEGER }, RowMapper.COUNT);
		}

		protected boolean contains(Integer minimumRequirementId,
			Integer minimumRequirementLevelId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						minimumRequirementId, minimumRequirementLevelId
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

	protected class ContainsCdsTitleMinimumRequirements {
		protected ContainsCdsTitleMinimumRequirements(
			CdsMinimumRequirementsPersistenceImpl persistenceImpl) {
			super();

			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSCDSTITLEMINIMUMREQUIREMENTS,
					new int[] { Types.INTEGER, Types.INTEGER }, RowMapper.COUNT);
		}

		protected boolean contains(Integer minimumRequirementId,
			Integer CdsTitleMinimumRequirementsId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						minimumRequirementId, CdsTitleMinimumRequirementsId
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

	private static final String _SQL_GETCDSMINIMUMREQUIREMENTLEVELSES = "SELECT {cds_minimum_requirement_levels.*} FROM cds_minimum_requirement_levels INNER JOIN cds_minimum_requirements ON (cds_minimum_requirements.minimumRequirementId = cds_minimum_requirement_levels.minimumRequirementId) WHERE (cds_minimum_requirements.minimumRequirementId = ?)";
	private static final String _SQL_GETCDSMINIMUMREQUIREMENTLEVELSESSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM cds_minimum_requirement_levels WHERE minimumRequirementId = ?";
	private static final String _SQL_CONTAINSCDSMINIMUMREQUIREMENTLEVELS = "SELECT COUNT(*) AS COUNT_VALUE FROM cds_minimum_requirement_levels WHERE minimumRequirementId = ? AND minimumRequirementLevelId = ?";
	private static final String _SQL_GETCDSTITLEMINIMUMREQUIREMENTSES = "SELECT {cds_title_minimum_requirements.*} FROM cds_title_minimum_requirements INNER JOIN cds_minimum_requirements ON (cds_minimum_requirements.minimumRequirementId = cds_title_minimum_requirements.minimumRequirementId) WHERE (cds_minimum_requirements.minimumRequirementId = ?)";
	private static final String _SQL_GETCDSTITLEMINIMUMREQUIREMENTSESSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM cds_title_minimum_requirements WHERE minimumRequirementId = ?";
	private static final String _SQL_CONTAINSCDSTITLEMINIMUMREQUIREMENTS = "SELECT COUNT(*) AS COUNT_VALUE FROM cds_title_minimum_requirements WHERE minimumRequirementId = ? AND CdsTitleMinimumRequirementsId = ?";
	private static Log _log = LogFactoryUtil.getLog(CdsMinimumRequirementsPersistenceImpl.class);
}