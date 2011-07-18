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
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import larion.progate.cds.NoSuchViewPerformanceAppraisalLevelsException;
import larion.progate.cds.model.ViewPerformanceAppraisalLevels;
import larion.progate.cds.model.impl.ViewPerformanceAppraisalLevelsImpl;
import larion.progate.cds.model.impl.ViewPerformanceAppraisalLevelsModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="ViewPerformanceAppraisalLevelsPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ViewPerformanceAppraisalLevelsPersistenceImpl
	extends BasePersistenceImpl
	implements ViewPerformanceAppraisalLevelsPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = ViewPerformanceAppraisalLevelsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(ViewPerformanceAppraisalLevelsModelImpl.ENTITY_CACHE_ENABLED,
			ViewPerformanceAppraisalLevelsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ViewPerformanceAppraisalLevelsModelImpl.ENTITY_CACHE_ENABLED,
			ViewPerformanceAppraisalLevelsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(
		ViewPerformanceAppraisalLevels viewPerformanceAppraisalLevels) {
		EntityCacheUtil.putResult(ViewPerformanceAppraisalLevelsModelImpl.ENTITY_CACHE_ENABLED,
			ViewPerformanceAppraisalLevelsImpl.class,
			viewPerformanceAppraisalLevels.getPrimaryKey(),
			viewPerformanceAppraisalLevels);
	}

	public void cacheResult(
		List<ViewPerformanceAppraisalLevels> viewPerformanceAppraisalLevelses) {
		for (ViewPerformanceAppraisalLevels viewPerformanceAppraisalLevels : viewPerformanceAppraisalLevelses) {
			if (EntityCacheUtil.getResult(
						ViewPerformanceAppraisalLevelsModelImpl.ENTITY_CACHE_ENABLED,
						ViewPerformanceAppraisalLevelsImpl.class,
						viewPerformanceAppraisalLevels.getPrimaryKey(), this) == null) {
				cacheResult(viewPerformanceAppraisalLevels);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(ViewPerformanceAppraisalLevelsImpl.class.getName());
		EntityCacheUtil.clearCache(ViewPerformanceAppraisalLevelsImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public ViewPerformanceAppraisalLevels create(String id) {
		ViewPerformanceAppraisalLevels viewPerformanceAppraisalLevels = new ViewPerformanceAppraisalLevelsImpl();

		viewPerformanceAppraisalLevels.setNew(true);
		viewPerformanceAppraisalLevels.setPrimaryKey(id);

		return viewPerformanceAppraisalLevels;
	}

	public ViewPerformanceAppraisalLevels remove(String id)
		throws NoSuchViewPerformanceAppraisalLevelsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ViewPerformanceAppraisalLevels viewPerformanceAppraisalLevels = (ViewPerformanceAppraisalLevels)session.get(ViewPerformanceAppraisalLevelsImpl.class,
					id);

			if (viewPerformanceAppraisalLevels == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No ViewPerformanceAppraisalLevels exists with the primary key " +
						id);
				}

				throw new NoSuchViewPerformanceAppraisalLevelsException(
					"No ViewPerformanceAppraisalLevels exists with the primary key " +
					id);
			}

			return remove(viewPerformanceAppraisalLevels);
		}
		catch (NoSuchViewPerformanceAppraisalLevelsException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public ViewPerformanceAppraisalLevels remove(
		ViewPerformanceAppraisalLevels viewPerformanceAppraisalLevels)
		throws SystemException {
		for (ModelListener<ViewPerformanceAppraisalLevels> listener : listeners) {
			listener.onBeforeRemove(viewPerformanceAppraisalLevels);
		}

		viewPerformanceAppraisalLevels = removeImpl(viewPerformanceAppraisalLevels);

		for (ModelListener<ViewPerformanceAppraisalLevels> listener : listeners) {
			listener.onAfterRemove(viewPerformanceAppraisalLevels);
		}

		return viewPerformanceAppraisalLevels;
	}

	protected ViewPerformanceAppraisalLevels removeImpl(
		ViewPerformanceAppraisalLevels viewPerformanceAppraisalLevels)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (viewPerformanceAppraisalLevels.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(ViewPerformanceAppraisalLevelsImpl.class,
						viewPerformanceAppraisalLevels.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(viewPerformanceAppraisalLevels);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(ViewPerformanceAppraisalLevelsModelImpl.ENTITY_CACHE_ENABLED,
			ViewPerformanceAppraisalLevelsImpl.class,
			viewPerformanceAppraisalLevels.getPrimaryKey());

		return viewPerformanceAppraisalLevels;
	}

	public ViewPerformanceAppraisalLevels update(
		ViewPerformanceAppraisalLevels viewPerformanceAppraisalLevels)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(ViewPerformanceAppraisalLevels viewPerformanceAppraisalLevels) method. Use update(ViewPerformanceAppraisalLevels viewPerformanceAppraisalLevels, boolean merge) instead.");
		}

		return update(viewPerformanceAppraisalLevels, false);
	}

	public ViewPerformanceAppraisalLevels update(
		ViewPerformanceAppraisalLevels viewPerformanceAppraisalLevels,
		boolean merge) throws SystemException {
		boolean isNew = viewPerformanceAppraisalLevels.isNew();

		for (ModelListener<ViewPerformanceAppraisalLevels> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(viewPerformanceAppraisalLevels);
			}
			else {
				listener.onBeforeUpdate(viewPerformanceAppraisalLevels);
			}
		}

		viewPerformanceAppraisalLevels = updateImpl(viewPerformanceAppraisalLevels,
				merge);

		for (ModelListener<ViewPerformanceAppraisalLevels> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(viewPerformanceAppraisalLevels);
			}
			else {
				listener.onAfterUpdate(viewPerformanceAppraisalLevels);
			}
		}

		return viewPerformanceAppraisalLevels;
	}

	public ViewPerformanceAppraisalLevels updateImpl(
		larion.progate.cds.model.ViewPerformanceAppraisalLevels viewPerformanceAppraisalLevels,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, viewPerformanceAppraisalLevels,
				merge);

			viewPerformanceAppraisalLevels.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(ViewPerformanceAppraisalLevelsModelImpl.ENTITY_CACHE_ENABLED,
			ViewPerformanceAppraisalLevelsImpl.class,
			viewPerformanceAppraisalLevels.getPrimaryKey(),
			viewPerformanceAppraisalLevels);

		return viewPerformanceAppraisalLevels;
	}

	public ViewPerformanceAppraisalLevels findByPrimaryKey(String id)
		throws NoSuchViewPerformanceAppraisalLevelsException, SystemException {
		ViewPerformanceAppraisalLevels viewPerformanceAppraisalLevels = fetchByPrimaryKey(id);

		if (viewPerformanceAppraisalLevels == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"No ViewPerformanceAppraisalLevels exists with the primary key " +
					id);
			}

			throw new NoSuchViewPerformanceAppraisalLevelsException(
				"No ViewPerformanceAppraisalLevels exists with the primary key " +
				id);
		}

		return viewPerformanceAppraisalLevels;
	}

	public ViewPerformanceAppraisalLevels fetchByPrimaryKey(String id)
		throws SystemException {
		ViewPerformanceAppraisalLevels viewPerformanceAppraisalLevels = (ViewPerformanceAppraisalLevels)EntityCacheUtil.getResult(ViewPerformanceAppraisalLevelsModelImpl.ENTITY_CACHE_ENABLED,
				ViewPerformanceAppraisalLevelsImpl.class, id, this);

		if (viewPerformanceAppraisalLevels == null) {
			Session session = null;

			try {
				session = openSession();

				viewPerformanceAppraisalLevels = (ViewPerformanceAppraisalLevels)session.get(ViewPerformanceAppraisalLevelsImpl.class,
						id);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (viewPerformanceAppraisalLevels != null) {
					cacheResult(viewPerformanceAppraisalLevels);
				}

				closeSession(session);
			}
		}

		return viewPerformanceAppraisalLevels;
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

	public List<ViewPerformanceAppraisalLevels> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<ViewPerformanceAppraisalLevels> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<ViewPerformanceAppraisalLevels> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ViewPerformanceAppraisalLevels> list = (List<ViewPerformanceAppraisalLevels>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.ViewPerformanceAppraisalLevels ");

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
					list = (List<ViewPerformanceAppraisalLevels>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ViewPerformanceAppraisalLevels>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ViewPerformanceAppraisalLevels>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeAll() throws SystemException {
		for (ViewPerformanceAppraisalLevels viewPerformanceAppraisalLevels : findAll()) {
			remove(viewPerformanceAppraisalLevels);
		}
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
						"SELECT COUNT(*) FROM larion.progate.cds.model.ViewPerformanceAppraisalLevels");

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
						"value.object.listener.larion.progate.cds.model.ViewPerformanceAppraisalLevels")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ViewPerformanceAppraisalLevels>> listenersList =
					new ArrayList<ModelListener<ViewPerformanceAppraisalLevels>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ViewPerformanceAppraisalLevels>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(ViewPerformanceAppraisalLevelsPersistenceImpl.class);
}