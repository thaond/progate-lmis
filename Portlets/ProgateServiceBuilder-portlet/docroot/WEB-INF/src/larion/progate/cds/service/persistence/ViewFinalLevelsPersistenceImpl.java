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

import larion.progate.cds.NoSuchViewFinalLevelsException;
import larion.progate.cds.model.ViewFinalLevels;
import larion.progate.cds.model.impl.ViewFinalLevelsImpl;
import larion.progate.cds.model.impl.ViewFinalLevelsModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="ViewFinalLevelsPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ViewFinalLevelsPersistenceImpl extends BasePersistenceImpl
	implements ViewFinalLevelsPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = ViewFinalLevelsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(ViewFinalLevelsModelImpl.ENTITY_CACHE_ENABLED,
			ViewFinalLevelsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ViewFinalLevelsModelImpl.ENTITY_CACHE_ENABLED,
			ViewFinalLevelsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(ViewFinalLevels viewFinalLevels) {
		EntityCacheUtil.putResult(ViewFinalLevelsModelImpl.ENTITY_CACHE_ENABLED,
			ViewFinalLevelsImpl.class, viewFinalLevels.getPrimaryKey(),
			viewFinalLevels);
	}

	public void cacheResult(List<ViewFinalLevels> viewFinalLevelses) {
		for (ViewFinalLevels viewFinalLevels : viewFinalLevelses) {
			if (EntityCacheUtil.getResult(
						ViewFinalLevelsModelImpl.ENTITY_CACHE_ENABLED,
						ViewFinalLevelsImpl.class,
						viewFinalLevels.getPrimaryKey(), this) == null) {
				cacheResult(viewFinalLevels);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(ViewFinalLevelsImpl.class.getName());
		EntityCacheUtil.clearCache(ViewFinalLevelsImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public ViewFinalLevels create(Integer levelId) {
		ViewFinalLevels viewFinalLevels = new ViewFinalLevelsImpl();

		viewFinalLevels.setNew(true);
		viewFinalLevels.setPrimaryKey(levelId);

		return viewFinalLevels;
	}

	public ViewFinalLevels remove(Integer levelId)
		throws NoSuchViewFinalLevelsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ViewFinalLevels viewFinalLevels = (ViewFinalLevels)session.get(ViewFinalLevelsImpl.class,
					levelId);

			if (viewFinalLevels == null) {
				if (_log.isWarnEnabled()) {
					_log.warn("No ViewFinalLevels exists with the primary key " +
						levelId);
				}

				throw new NoSuchViewFinalLevelsException(
					"No ViewFinalLevels exists with the primary key " +
					levelId);
			}

			return remove(viewFinalLevels);
		}
		catch (NoSuchViewFinalLevelsException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public ViewFinalLevels remove(ViewFinalLevels viewFinalLevels)
		throws SystemException {
		for (ModelListener<ViewFinalLevels> listener : listeners) {
			listener.onBeforeRemove(viewFinalLevels);
		}

		viewFinalLevels = removeImpl(viewFinalLevels);

		for (ModelListener<ViewFinalLevels> listener : listeners) {
			listener.onAfterRemove(viewFinalLevels);
		}

		return viewFinalLevels;
	}

	protected ViewFinalLevels removeImpl(ViewFinalLevels viewFinalLevels)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (viewFinalLevels.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(ViewFinalLevelsImpl.class,
						viewFinalLevels.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(viewFinalLevels);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(ViewFinalLevelsModelImpl.ENTITY_CACHE_ENABLED,
			ViewFinalLevelsImpl.class, viewFinalLevels.getPrimaryKey());

		return viewFinalLevels;
	}

	public ViewFinalLevels update(ViewFinalLevels viewFinalLevels)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(ViewFinalLevels viewFinalLevels) method. Use update(ViewFinalLevels viewFinalLevels, boolean merge) instead.");
		}

		return update(viewFinalLevels, false);
	}

	public ViewFinalLevels update(ViewFinalLevels viewFinalLevels, boolean merge)
		throws SystemException {
		boolean isNew = viewFinalLevels.isNew();

		for (ModelListener<ViewFinalLevels> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(viewFinalLevels);
			}
			else {
				listener.onBeforeUpdate(viewFinalLevels);
			}
		}

		viewFinalLevels = updateImpl(viewFinalLevels, merge);

		for (ModelListener<ViewFinalLevels> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(viewFinalLevels);
			}
			else {
				listener.onAfterUpdate(viewFinalLevels);
			}
		}

		return viewFinalLevels;
	}

	public ViewFinalLevels updateImpl(
		larion.progate.cds.model.ViewFinalLevels viewFinalLevels, boolean merge)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, viewFinalLevels, merge);

			viewFinalLevels.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(ViewFinalLevelsModelImpl.ENTITY_CACHE_ENABLED,
			ViewFinalLevelsImpl.class, viewFinalLevels.getPrimaryKey(),
			viewFinalLevels);

		return viewFinalLevels;
	}

	public ViewFinalLevels findByPrimaryKey(Integer levelId)
		throws NoSuchViewFinalLevelsException, SystemException {
		ViewFinalLevels viewFinalLevels = fetchByPrimaryKey(levelId);

		if (viewFinalLevels == null) {
			if (_log.isWarnEnabled()) {
				_log.warn("No ViewFinalLevels exists with the primary key " +
					levelId);
			}

			throw new NoSuchViewFinalLevelsException(
				"No ViewFinalLevels exists with the primary key " + levelId);
		}

		return viewFinalLevels;
	}

	public ViewFinalLevels fetchByPrimaryKey(Integer levelId)
		throws SystemException {
		ViewFinalLevels viewFinalLevels = (ViewFinalLevels)EntityCacheUtil.getResult(ViewFinalLevelsModelImpl.ENTITY_CACHE_ENABLED,
				ViewFinalLevelsImpl.class, levelId, this);

		if (viewFinalLevels == null) {
			Session session = null;

			try {
				session = openSession();

				viewFinalLevels = (ViewFinalLevels)session.get(ViewFinalLevelsImpl.class,
						levelId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (viewFinalLevels != null) {
					cacheResult(viewFinalLevels);
				}

				closeSession(session);
			}
		}

		return viewFinalLevels;
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

	public List<ViewFinalLevels> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<ViewFinalLevels> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<ViewFinalLevels> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ViewFinalLevels> list = (List<ViewFinalLevels>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.cds.model.ViewFinalLevels ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<ViewFinalLevels>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ViewFinalLevels>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ViewFinalLevels>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeAll() throws SystemException {
		for (ViewFinalLevels viewFinalLevels : findAll()) {
			remove(viewFinalLevels);
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
						"SELECT COUNT(*) FROM larion.progate.cds.model.ViewFinalLevels");

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
						"value.object.listener.larion.progate.cds.model.ViewFinalLevels")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ViewFinalLevels>> listenersList = new ArrayList<ModelListener<ViewFinalLevels>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ViewFinalLevels>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(ViewFinalLevelsPersistenceImpl.class);
}