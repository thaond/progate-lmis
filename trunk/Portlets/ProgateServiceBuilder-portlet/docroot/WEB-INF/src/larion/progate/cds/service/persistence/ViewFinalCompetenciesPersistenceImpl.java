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

import larion.progate.cds.NoSuchViewFinalCompetenciesException;
import larion.progate.cds.model.ViewFinalCompetencies;
import larion.progate.cds.model.impl.ViewFinalCompetenciesImpl;
import larion.progate.cds.model.impl.ViewFinalCompetenciesModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="ViewFinalCompetenciesPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ViewFinalCompetenciesPersistenceImpl extends BasePersistenceImpl
	implements ViewFinalCompetenciesPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = ViewFinalCompetenciesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(ViewFinalCompetenciesModelImpl.ENTITY_CACHE_ENABLED,
			ViewFinalCompetenciesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ViewFinalCompetenciesModelImpl.ENTITY_CACHE_ENABLED,
			ViewFinalCompetenciesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(ViewFinalCompetencies viewFinalCompetencies) {
		EntityCacheUtil.putResult(ViewFinalCompetenciesModelImpl.ENTITY_CACHE_ENABLED,
			ViewFinalCompetenciesImpl.class,
			viewFinalCompetencies.getPrimaryKey(), viewFinalCompetencies);
	}

	public void cacheResult(List<ViewFinalCompetencies> viewFinalCompetencieses) {
		for (ViewFinalCompetencies viewFinalCompetencies : viewFinalCompetencieses) {
			if (EntityCacheUtil.getResult(
						ViewFinalCompetenciesModelImpl.ENTITY_CACHE_ENABLED,
						ViewFinalCompetenciesImpl.class,
						viewFinalCompetencies.getPrimaryKey(), this) == null) {
				cacheResult(viewFinalCompetencies);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(ViewFinalCompetenciesImpl.class.getName());
		EntityCacheUtil.clearCache(ViewFinalCompetenciesImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public ViewFinalCompetencies create(Integer competencyId) {
		ViewFinalCompetencies viewFinalCompetencies = new ViewFinalCompetenciesImpl();

		viewFinalCompetencies.setNew(true);
		viewFinalCompetencies.setPrimaryKey(competencyId);

		return viewFinalCompetencies;
	}

	public ViewFinalCompetencies remove(Integer competencyId)
		throws NoSuchViewFinalCompetenciesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ViewFinalCompetencies viewFinalCompetencies = (ViewFinalCompetencies)session.get(ViewFinalCompetenciesImpl.class,
					competencyId);

			if (viewFinalCompetencies == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No ViewFinalCompetencies exists with the primary key " +
						competencyId);
				}

				throw new NoSuchViewFinalCompetenciesException(
					"No ViewFinalCompetencies exists with the primary key " +
					competencyId);
			}

			return remove(viewFinalCompetencies);
		}
		catch (NoSuchViewFinalCompetenciesException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public ViewFinalCompetencies remove(
		ViewFinalCompetencies viewFinalCompetencies) throws SystemException {
		for (ModelListener<ViewFinalCompetencies> listener : listeners) {
			listener.onBeforeRemove(viewFinalCompetencies);
		}

		viewFinalCompetencies = removeImpl(viewFinalCompetencies);

		for (ModelListener<ViewFinalCompetencies> listener : listeners) {
			listener.onAfterRemove(viewFinalCompetencies);
		}

		return viewFinalCompetencies;
	}

	protected ViewFinalCompetencies removeImpl(
		ViewFinalCompetencies viewFinalCompetencies) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (viewFinalCompetencies.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(ViewFinalCompetenciesImpl.class,
						viewFinalCompetencies.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(viewFinalCompetencies);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(ViewFinalCompetenciesModelImpl.ENTITY_CACHE_ENABLED,
			ViewFinalCompetenciesImpl.class,
			viewFinalCompetencies.getPrimaryKey());

		return viewFinalCompetencies;
	}

	public ViewFinalCompetencies update(
		ViewFinalCompetencies viewFinalCompetencies) throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(ViewFinalCompetencies viewFinalCompetencies) method. Use update(ViewFinalCompetencies viewFinalCompetencies, boolean merge) instead.");
		}

		return update(viewFinalCompetencies, false);
	}

	public ViewFinalCompetencies update(
		ViewFinalCompetencies viewFinalCompetencies, boolean merge)
		throws SystemException {
		boolean isNew = viewFinalCompetencies.isNew();

		for (ModelListener<ViewFinalCompetencies> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(viewFinalCompetencies);
			}
			else {
				listener.onBeforeUpdate(viewFinalCompetencies);
			}
		}

		viewFinalCompetencies = updateImpl(viewFinalCompetencies, merge);

		for (ModelListener<ViewFinalCompetencies> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(viewFinalCompetencies);
			}
			else {
				listener.onAfterUpdate(viewFinalCompetencies);
			}
		}

		return viewFinalCompetencies;
	}

	public ViewFinalCompetencies updateImpl(
		larion.progate.cds.model.ViewFinalCompetencies viewFinalCompetencies,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, viewFinalCompetencies, merge);

			viewFinalCompetencies.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(ViewFinalCompetenciesModelImpl.ENTITY_CACHE_ENABLED,
			ViewFinalCompetenciesImpl.class,
			viewFinalCompetencies.getPrimaryKey(), viewFinalCompetencies);

		return viewFinalCompetencies;
	}

	public ViewFinalCompetencies findByPrimaryKey(Integer competencyId)
		throws NoSuchViewFinalCompetenciesException, SystemException {
		ViewFinalCompetencies viewFinalCompetencies = fetchByPrimaryKey(competencyId);

		if (viewFinalCompetencies == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"No ViewFinalCompetencies exists with the primary key " +
					competencyId);
			}

			throw new NoSuchViewFinalCompetenciesException(
				"No ViewFinalCompetencies exists with the primary key " +
				competencyId);
		}

		return viewFinalCompetencies;
	}

	public ViewFinalCompetencies fetchByPrimaryKey(Integer competencyId)
		throws SystemException {
		ViewFinalCompetencies viewFinalCompetencies = (ViewFinalCompetencies)EntityCacheUtil.getResult(ViewFinalCompetenciesModelImpl.ENTITY_CACHE_ENABLED,
				ViewFinalCompetenciesImpl.class, competencyId, this);

		if (viewFinalCompetencies == null) {
			Session session = null;

			try {
				session = openSession();

				viewFinalCompetencies = (ViewFinalCompetencies)session.get(ViewFinalCompetenciesImpl.class,
						competencyId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (viewFinalCompetencies != null) {
					cacheResult(viewFinalCompetencies);
				}

				closeSession(session);
			}
		}

		return viewFinalCompetencies;
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

	public List<ViewFinalCompetencies> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<ViewFinalCompetencies> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<ViewFinalCompetencies> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ViewFinalCompetencies> list = (List<ViewFinalCompetencies>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.ViewFinalCompetencies ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<ViewFinalCompetencies>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ViewFinalCompetencies>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ViewFinalCompetencies>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeAll() throws SystemException {
		for (ViewFinalCompetencies viewFinalCompetencies : findAll()) {
			remove(viewFinalCompetencies);
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
						"SELECT COUNT(*) FROM larion.progate.cds.model.ViewFinalCompetencies");

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
						"value.object.listener.larion.progate.cds.model.ViewFinalCompetencies")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ViewFinalCompetencies>> listenersList = new ArrayList<ModelListener<ViewFinalCompetencies>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ViewFinalCompetencies>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(ViewFinalCompetenciesPersistenceImpl.class);
}