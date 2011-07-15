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

import larion.progate.cds.NoSuchViewListTitleMinimumRequirementsException;
import larion.progate.cds.model.ViewListTitleMinimumRequirements;
import larion.progate.cds.model.impl.ViewListTitleMinimumRequirementsImpl;
import larion.progate.cds.model.impl.ViewListTitleMinimumRequirementsModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="ViewListTitleMinimumRequirementsPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ViewListTitleMinimumRequirementsPersistenceImpl
	extends BasePersistenceImpl
	implements ViewListTitleMinimumRequirementsPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = ViewListTitleMinimumRequirementsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_TITLEID = new FinderPath(ViewListTitleMinimumRequirementsModelImpl.ENTITY_CACHE_ENABLED,
			ViewListTitleMinimumRequirementsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByTitleId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_TITLEID = new FinderPath(ViewListTitleMinimumRequirementsModelImpl.ENTITY_CACHE_ENABLED,
			ViewListTitleMinimumRequirementsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByTitleId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_TITLEID = new FinderPath(ViewListTitleMinimumRequirementsModelImpl.ENTITY_CACHE_ENABLED,
			ViewListTitleMinimumRequirementsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByTitleId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(ViewListTitleMinimumRequirementsModelImpl.ENTITY_CACHE_ENABLED,
			ViewListTitleMinimumRequirementsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ViewListTitleMinimumRequirementsModelImpl.ENTITY_CACHE_ENABLED,
			ViewListTitleMinimumRequirementsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(
		ViewListTitleMinimumRequirements viewListTitleMinimumRequirements) {
		EntityCacheUtil.putResult(ViewListTitleMinimumRequirementsModelImpl.ENTITY_CACHE_ENABLED,
			ViewListTitleMinimumRequirementsImpl.class,
			viewListTitleMinimumRequirements.getPrimaryKey(),
			viewListTitleMinimumRequirements);
	}

	public void cacheResult(
		List<ViewListTitleMinimumRequirements> viewListTitleMinimumRequirementses) {
		for (ViewListTitleMinimumRequirements viewListTitleMinimumRequirements : viewListTitleMinimumRequirementses) {
			if (EntityCacheUtil.getResult(
						ViewListTitleMinimumRequirementsModelImpl.ENTITY_CACHE_ENABLED,
						ViewListTitleMinimumRequirementsImpl.class,
						viewListTitleMinimumRequirements.getPrimaryKey(), this) == null) {
				cacheResult(viewListTitleMinimumRequirements);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(ViewListTitleMinimumRequirementsImpl.class.getName());
		EntityCacheUtil.clearCache(ViewListTitleMinimumRequirementsImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public ViewListTitleMinimumRequirements create(String id) {
		ViewListTitleMinimumRequirements viewListTitleMinimumRequirements = new ViewListTitleMinimumRequirementsImpl();

		viewListTitleMinimumRequirements.setNew(true);
		viewListTitleMinimumRequirements.setPrimaryKey(id);

		return viewListTitleMinimumRequirements;
	}

	public ViewListTitleMinimumRequirements remove(String id)
		throws NoSuchViewListTitleMinimumRequirementsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ViewListTitleMinimumRequirements viewListTitleMinimumRequirements = (ViewListTitleMinimumRequirements)session.get(ViewListTitleMinimumRequirementsImpl.class,
					id);

			if (viewListTitleMinimumRequirements == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No ViewListTitleMinimumRequirements exists with the primary key " +
						id);
				}

				throw new NoSuchViewListTitleMinimumRequirementsException(
					"No ViewListTitleMinimumRequirements exists with the primary key " +
					id);
			}

			return remove(viewListTitleMinimumRequirements);
		}
		catch (NoSuchViewListTitleMinimumRequirementsException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public ViewListTitleMinimumRequirements remove(
		ViewListTitleMinimumRequirements viewListTitleMinimumRequirements)
		throws SystemException {
		for (ModelListener<ViewListTitleMinimumRequirements> listener : listeners) {
			listener.onBeforeRemove(viewListTitleMinimumRequirements);
		}

		viewListTitleMinimumRequirements = removeImpl(viewListTitleMinimumRequirements);

		for (ModelListener<ViewListTitleMinimumRequirements> listener : listeners) {
			listener.onAfterRemove(viewListTitleMinimumRequirements);
		}

		return viewListTitleMinimumRequirements;
	}

	protected ViewListTitleMinimumRequirements removeImpl(
		ViewListTitleMinimumRequirements viewListTitleMinimumRequirements)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (viewListTitleMinimumRequirements.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(ViewListTitleMinimumRequirementsImpl.class,
						viewListTitleMinimumRequirements.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(viewListTitleMinimumRequirements);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(ViewListTitleMinimumRequirementsModelImpl.ENTITY_CACHE_ENABLED,
			ViewListTitleMinimumRequirementsImpl.class,
			viewListTitleMinimumRequirements.getPrimaryKey());

		return viewListTitleMinimumRequirements;
	}

	public ViewListTitleMinimumRequirements update(
		ViewListTitleMinimumRequirements viewListTitleMinimumRequirements)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(ViewListTitleMinimumRequirements viewListTitleMinimumRequirements) method. Use update(ViewListTitleMinimumRequirements viewListTitleMinimumRequirements, boolean merge) instead.");
		}

		return update(viewListTitleMinimumRequirements, false);
	}

	public ViewListTitleMinimumRequirements update(
		ViewListTitleMinimumRequirements viewListTitleMinimumRequirements,
		boolean merge) throws SystemException {
		boolean isNew = viewListTitleMinimumRequirements.isNew();

		for (ModelListener<ViewListTitleMinimumRequirements> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(viewListTitleMinimumRequirements);
			}
			else {
				listener.onBeforeUpdate(viewListTitleMinimumRequirements);
			}
		}

		viewListTitleMinimumRequirements = updateImpl(viewListTitleMinimumRequirements,
				merge);

		for (ModelListener<ViewListTitleMinimumRequirements> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(viewListTitleMinimumRequirements);
			}
			else {
				listener.onAfterUpdate(viewListTitleMinimumRequirements);
			}
		}

		return viewListTitleMinimumRequirements;
	}

	public ViewListTitleMinimumRequirements updateImpl(
		larion.progate.cds.model.ViewListTitleMinimumRequirements viewListTitleMinimumRequirements,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, viewListTitleMinimumRequirements,
				merge);

			viewListTitleMinimumRequirements.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(ViewListTitleMinimumRequirementsModelImpl.ENTITY_CACHE_ENABLED,
			ViewListTitleMinimumRequirementsImpl.class,
			viewListTitleMinimumRequirements.getPrimaryKey(),
			viewListTitleMinimumRequirements);

		return viewListTitleMinimumRequirements;
	}

	public ViewListTitleMinimumRequirements findByPrimaryKey(String id)
		throws NoSuchViewListTitleMinimumRequirementsException, SystemException {
		ViewListTitleMinimumRequirements viewListTitleMinimumRequirements = fetchByPrimaryKey(id);

		if (viewListTitleMinimumRequirements == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"No ViewListTitleMinimumRequirements exists with the primary key " +
					id);
			}

			throw new NoSuchViewListTitleMinimumRequirementsException(
				"No ViewListTitleMinimumRequirements exists with the primary key " +
				id);
		}

		return viewListTitleMinimumRequirements;
	}

	public ViewListTitleMinimumRequirements fetchByPrimaryKey(String id)
		throws SystemException {
		ViewListTitleMinimumRequirements viewListTitleMinimumRequirements = (ViewListTitleMinimumRequirements)EntityCacheUtil.getResult(ViewListTitleMinimumRequirementsModelImpl.ENTITY_CACHE_ENABLED,
				ViewListTitleMinimumRequirementsImpl.class, id, this);

		if (viewListTitleMinimumRequirements == null) {
			Session session = null;

			try {
				session = openSession();

				viewListTitleMinimumRequirements = (ViewListTitleMinimumRequirements)session.get(ViewListTitleMinimumRequirementsImpl.class,
						id);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (viewListTitleMinimumRequirements != null) {
					cacheResult(viewListTitleMinimumRequirements);
				}

				closeSession(session);
			}
		}

		return viewListTitleMinimumRequirements;
	}

	public List<ViewListTitleMinimumRequirements> findByTitleId(int titleId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(titleId) };

		List<ViewListTitleMinimumRequirements> list = (List<ViewListTitleMinimumRequirements>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_TITLEID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.ViewListTitleMinimumRequirements WHERE ");

				query.append("title_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("minimum_requirement_number_order ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(titleId);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ViewListTitleMinimumRequirements>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_TITLEID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ViewListTitleMinimumRequirements> findByTitleId(int titleId,
		int start, int end) throws SystemException {
		return findByTitleId(titleId, start, end, null);
	}

	public List<ViewListTitleMinimumRequirements> findByTitleId(int titleId,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(titleId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ViewListTitleMinimumRequirements> list = (List<ViewListTitleMinimumRequirements>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_TITLEID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.ViewListTitleMinimumRequirements WHERE ");

				query.append("title_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("minimum_requirement_number_order ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(titleId);

				list = (List<ViewListTitleMinimumRequirements>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ViewListTitleMinimumRequirements>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_TITLEID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ViewListTitleMinimumRequirements findByTitleId_First(int titleId,
		OrderByComparator obc)
		throws NoSuchViewListTitleMinimumRequirementsException, SystemException {
		List<ViewListTitleMinimumRequirements> list = findByTitleId(titleId, 0,
				1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No ViewListTitleMinimumRequirements exists with the key {");

			msg.append("titleId=" + titleId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchViewListTitleMinimumRequirementsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ViewListTitleMinimumRequirements findByTitleId_Last(int titleId,
		OrderByComparator obc)
		throws NoSuchViewListTitleMinimumRequirementsException, SystemException {
		int count = countByTitleId(titleId);

		List<ViewListTitleMinimumRequirements> list = findByTitleId(titleId,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No ViewListTitleMinimumRequirements exists with the key {");

			msg.append("titleId=" + titleId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchViewListTitleMinimumRequirementsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ViewListTitleMinimumRequirements[] findByTitleId_PrevAndNext(
		String id, int titleId, OrderByComparator obc)
		throws NoSuchViewListTitleMinimumRequirementsException, SystemException {
		ViewListTitleMinimumRequirements viewListTitleMinimumRequirements = findByPrimaryKey(id);

		int count = countByTitleId(titleId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.cds.model.ViewListTitleMinimumRequirements WHERE ");

			query.append("title_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("minimum_requirement_number_order ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(titleId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					viewListTitleMinimumRequirements);

			ViewListTitleMinimumRequirements[] array = new ViewListTitleMinimumRequirementsImpl[3];

			array[0] = (ViewListTitleMinimumRequirements)objArray[0];
			array[1] = (ViewListTitleMinimumRequirements)objArray[1];
			array[2] = (ViewListTitleMinimumRequirements)objArray[2];

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

	public List<ViewListTitleMinimumRequirements> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<ViewListTitleMinimumRequirements> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<ViewListTitleMinimumRequirements> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ViewListTitleMinimumRequirements> list = (List<ViewListTitleMinimumRequirements>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.ViewListTitleMinimumRequirements ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("minimum_requirement_number_order ASC");
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<ViewListTitleMinimumRequirements>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ViewListTitleMinimumRequirements>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ViewListTitleMinimumRequirements>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByTitleId(int titleId) throws SystemException {
		for (ViewListTitleMinimumRequirements viewListTitleMinimumRequirements : findByTitleId(
				titleId)) {
			remove(viewListTitleMinimumRequirements);
		}
	}

	public void removeAll() throws SystemException {
		for (ViewListTitleMinimumRequirements viewListTitleMinimumRequirements : findAll()) {
			remove(viewListTitleMinimumRequirements);
		}
	}

	public int countByTitleId(int titleId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(titleId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TITLEID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.cds.model.ViewListTitleMinimumRequirements WHERE ");

				query.append("title_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(titleId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TITLEID,
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
						"SELECT COUNT(*) FROM larion.progate.cds.model.ViewListTitleMinimumRequirements");

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
						"value.object.listener.larion.progate.cds.model.ViewListTitleMinimumRequirements")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ViewListTitleMinimumRequirements>> listenersList =
					new ArrayList<ModelListener<ViewListTitleMinimumRequirements>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ViewListTitleMinimumRequirements>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(ViewListTitleMinimumRequirementsPersistenceImpl.class);
}