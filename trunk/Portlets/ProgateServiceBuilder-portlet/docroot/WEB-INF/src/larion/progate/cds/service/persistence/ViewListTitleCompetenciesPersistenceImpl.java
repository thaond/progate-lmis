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

import larion.progate.cds.NoSuchViewListTitleCompetenciesException;
import larion.progate.cds.model.ViewListTitleCompetencies;
import larion.progate.cds.model.impl.ViewListTitleCompetenciesImpl;
import larion.progate.cds.model.impl.ViewListTitleCompetenciesModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="ViewListTitleCompetenciesPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ViewListTitleCompetenciesPersistenceImpl
	extends BasePersistenceImpl implements ViewListTitleCompetenciesPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = ViewListTitleCompetenciesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_TITLEID = new FinderPath(ViewListTitleCompetenciesModelImpl.ENTITY_CACHE_ENABLED,
			ViewListTitleCompetenciesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByTitleId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_TITLEID = new FinderPath(ViewListTitleCompetenciesModelImpl.ENTITY_CACHE_ENABLED,
			ViewListTitleCompetenciesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByTitleId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_TITLEID = new FinderPath(ViewListTitleCompetenciesModelImpl.ENTITY_CACHE_ENABLED,
			ViewListTitleCompetenciesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByTitleId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(ViewListTitleCompetenciesModelImpl.ENTITY_CACHE_ENABLED,
			ViewListTitleCompetenciesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ViewListTitleCompetenciesModelImpl.ENTITY_CACHE_ENABLED,
			ViewListTitleCompetenciesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(ViewListTitleCompetencies viewListTitleCompetencies) {
		EntityCacheUtil.putResult(ViewListTitleCompetenciesModelImpl.ENTITY_CACHE_ENABLED,
			ViewListTitleCompetenciesImpl.class,
			viewListTitleCompetencies.getPrimaryKey(), viewListTitleCompetencies);
	}

	public void cacheResult(
		List<ViewListTitleCompetencies> viewListTitleCompetencieses) {
		for (ViewListTitleCompetencies viewListTitleCompetencies : viewListTitleCompetencieses) {
			if (EntityCacheUtil.getResult(
						ViewListTitleCompetenciesModelImpl.ENTITY_CACHE_ENABLED,
						ViewListTitleCompetenciesImpl.class,
						viewListTitleCompetencies.getPrimaryKey(), this) == null) {
				cacheResult(viewListTitleCompetencies);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(ViewListTitleCompetenciesImpl.class.getName());
		EntityCacheUtil.clearCache(ViewListTitleCompetenciesImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public ViewListTitleCompetencies create(String id) {
		ViewListTitleCompetencies viewListTitleCompetencies = new ViewListTitleCompetenciesImpl();

		viewListTitleCompetencies.setNew(true);
		viewListTitleCompetencies.setPrimaryKey(id);

		return viewListTitleCompetencies;
	}

	public ViewListTitleCompetencies remove(String id)
		throws NoSuchViewListTitleCompetenciesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ViewListTitleCompetencies viewListTitleCompetencies = (ViewListTitleCompetencies)session.get(ViewListTitleCompetenciesImpl.class,
					id);

			if (viewListTitleCompetencies == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No ViewListTitleCompetencies exists with the primary key " +
						id);
				}

				throw new NoSuchViewListTitleCompetenciesException(
					"No ViewListTitleCompetencies exists with the primary key " +
					id);
			}

			return remove(viewListTitleCompetencies);
		}
		catch (NoSuchViewListTitleCompetenciesException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public ViewListTitleCompetencies remove(
		ViewListTitleCompetencies viewListTitleCompetencies)
		throws SystemException {
		for (ModelListener<ViewListTitleCompetencies> listener : listeners) {
			listener.onBeforeRemove(viewListTitleCompetencies);
		}

		viewListTitleCompetencies = removeImpl(viewListTitleCompetencies);

		for (ModelListener<ViewListTitleCompetencies> listener : listeners) {
			listener.onAfterRemove(viewListTitleCompetencies);
		}

		return viewListTitleCompetencies;
	}

	protected ViewListTitleCompetencies removeImpl(
		ViewListTitleCompetencies viewListTitleCompetencies)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (viewListTitleCompetencies.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(ViewListTitleCompetenciesImpl.class,
						viewListTitleCompetencies.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(viewListTitleCompetencies);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(ViewListTitleCompetenciesModelImpl.ENTITY_CACHE_ENABLED,
			ViewListTitleCompetenciesImpl.class,
			viewListTitleCompetencies.getPrimaryKey());

		return viewListTitleCompetencies;
	}

	public ViewListTitleCompetencies update(
		ViewListTitleCompetencies viewListTitleCompetencies)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(ViewListTitleCompetencies viewListTitleCompetencies) method. Use update(ViewListTitleCompetencies viewListTitleCompetencies, boolean merge) instead.");
		}

		return update(viewListTitleCompetencies, false);
	}

	public ViewListTitleCompetencies update(
		ViewListTitleCompetencies viewListTitleCompetencies, boolean merge)
		throws SystemException {
		boolean isNew = viewListTitleCompetencies.isNew();

		for (ModelListener<ViewListTitleCompetencies> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(viewListTitleCompetencies);
			}
			else {
				listener.onBeforeUpdate(viewListTitleCompetencies);
			}
		}

		viewListTitleCompetencies = updateImpl(viewListTitleCompetencies, merge);

		for (ModelListener<ViewListTitleCompetencies> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(viewListTitleCompetencies);
			}
			else {
				listener.onAfterUpdate(viewListTitleCompetencies);
			}
		}

		return viewListTitleCompetencies;
	}

	public ViewListTitleCompetencies updateImpl(
		larion.progate.cds.model.ViewListTitleCompetencies viewListTitleCompetencies,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, viewListTitleCompetencies, merge);

			viewListTitleCompetencies.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(ViewListTitleCompetenciesModelImpl.ENTITY_CACHE_ENABLED,
			ViewListTitleCompetenciesImpl.class,
			viewListTitleCompetencies.getPrimaryKey(), viewListTitleCompetencies);

		return viewListTitleCompetencies;
	}

	public ViewListTitleCompetencies findByPrimaryKey(String id)
		throws NoSuchViewListTitleCompetenciesException, SystemException {
		ViewListTitleCompetencies viewListTitleCompetencies = fetchByPrimaryKey(id);

		if (viewListTitleCompetencies == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"No ViewListTitleCompetencies exists with the primary key " +
					id);
			}

			throw new NoSuchViewListTitleCompetenciesException(
				"No ViewListTitleCompetencies exists with the primary key " +
				id);
		}

		return viewListTitleCompetencies;
	}

	public ViewListTitleCompetencies fetchByPrimaryKey(String id)
		throws SystemException {
		ViewListTitleCompetencies viewListTitleCompetencies = (ViewListTitleCompetencies)EntityCacheUtil.getResult(ViewListTitleCompetenciesModelImpl.ENTITY_CACHE_ENABLED,
				ViewListTitleCompetenciesImpl.class, id, this);

		if (viewListTitleCompetencies == null) {
			Session session = null;

			try {
				session = openSession();

				viewListTitleCompetencies = (ViewListTitleCompetencies)session.get(ViewListTitleCompetenciesImpl.class,
						id);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (viewListTitleCompetencies != null) {
					cacheResult(viewListTitleCompetencies);
				}

				closeSession(session);
			}
		}

		return viewListTitleCompetencies;
	}

	public List<ViewListTitleCompetencies> findByTitleId(int titleId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(titleId) };

		List<ViewListTitleCompetencies> list = (List<ViewListTitleCompetencies>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_TITLEID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.ViewListTitleCompetencies WHERE ");

				query.append("title_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("competency_number_order ASC");

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
					list = new ArrayList<ViewListTitleCompetencies>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_TITLEID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ViewListTitleCompetencies> findByTitleId(int titleId,
		int start, int end) throws SystemException {
		return findByTitleId(titleId, start, end, null);
	}

	public List<ViewListTitleCompetencies> findByTitleId(int titleId,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(titleId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ViewListTitleCompetencies> list = (List<ViewListTitleCompetencies>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_TITLEID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.ViewListTitleCompetencies WHERE ");

				query.append("title_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("competency_number_order ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(titleId);

				list = (List<ViewListTitleCompetencies>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ViewListTitleCompetencies>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_TITLEID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ViewListTitleCompetencies findByTitleId_First(int titleId,
		OrderByComparator obc)
		throws NoSuchViewListTitleCompetenciesException, SystemException {
		List<ViewListTitleCompetencies> list = findByTitleId(titleId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ViewListTitleCompetencies exists with the key {");

			msg.append("titleId=" + titleId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchViewListTitleCompetenciesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ViewListTitleCompetencies findByTitleId_Last(int titleId,
		OrderByComparator obc)
		throws NoSuchViewListTitleCompetenciesException, SystemException {
		int count = countByTitleId(titleId);

		List<ViewListTitleCompetencies> list = findByTitleId(titleId,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ViewListTitleCompetencies exists with the key {");

			msg.append("titleId=" + titleId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchViewListTitleCompetenciesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ViewListTitleCompetencies[] findByTitleId_PrevAndNext(String id,
		int titleId, OrderByComparator obc)
		throws NoSuchViewListTitleCompetenciesException, SystemException {
		ViewListTitleCompetencies viewListTitleCompetencies = findByPrimaryKey(id);

		int count = countByTitleId(titleId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.cds.model.ViewListTitleCompetencies WHERE ");

			query.append("title_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("competency_number_order ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(titleId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					viewListTitleCompetencies);

			ViewListTitleCompetencies[] array = new ViewListTitleCompetenciesImpl[3];

			array[0] = (ViewListTitleCompetencies)objArray[0];
			array[1] = (ViewListTitleCompetencies)objArray[1];
			array[2] = (ViewListTitleCompetencies)objArray[2];

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

	public List<ViewListTitleCompetencies> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<ViewListTitleCompetencies> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<ViewListTitleCompetencies> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ViewListTitleCompetencies> list = (List<ViewListTitleCompetencies>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.ViewListTitleCompetencies ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("competency_number_order ASC");
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<ViewListTitleCompetencies>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ViewListTitleCompetencies>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ViewListTitleCompetencies>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByTitleId(int titleId) throws SystemException {
		for (ViewListTitleCompetencies viewListTitleCompetencies : findByTitleId(
				titleId)) {
			remove(viewListTitleCompetencies);
		}
	}

	public void removeAll() throws SystemException {
		for (ViewListTitleCompetencies viewListTitleCompetencies : findAll()) {
			remove(viewListTitleCompetencies);
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
					"FROM larion.progate.cds.model.ViewListTitleCompetencies WHERE ");

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
						"SELECT COUNT(*) FROM larion.progate.cds.model.ViewListTitleCompetencies");

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
						"value.object.listener.larion.progate.cds.model.ViewListTitleCompetencies")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ViewListTitleCompetencies>> listenersList = new ArrayList<ModelListener<ViewListTitleCompetencies>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ViewListTitleCompetencies>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(ViewListTitleCompetenciesPersistenceImpl.class);
}