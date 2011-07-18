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

import larion.progate.cds.NoSuchCdsLevelStatisticalReportException;
import larion.progate.cds.model.CdsLevelStatisticalReport;
import larion.progate.cds.model.impl.CdsLevelStatisticalReportImpl;
import larion.progate.cds.model.impl.CdsLevelStatisticalReportModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="CdsLevelStatisticalReportPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsLevelStatisticalReportPersistenceImpl
	extends BasePersistenceImpl implements CdsLevelStatisticalReportPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = CdsLevelStatisticalReportImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(CdsLevelStatisticalReportModelImpl.ENTITY_CACHE_ENABLED,
			CdsLevelStatisticalReportModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CdsLevelStatisticalReportModelImpl.ENTITY_CACHE_ENABLED,
			CdsLevelStatisticalReportModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(CdsLevelStatisticalReport cdsLevelStatisticalReport) {
		EntityCacheUtil.putResult(CdsLevelStatisticalReportModelImpl.ENTITY_CACHE_ENABLED,
			CdsLevelStatisticalReportImpl.class,
			cdsLevelStatisticalReport.getPrimaryKey(), cdsLevelStatisticalReport);
	}

	public void cacheResult(
		List<CdsLevelStatisticalReport> cdsLevelStatisticalReports) {
		for (CdsLevelStatisticalReport cdsLevelStatisticalReport : cdsLevelStatisticalReports) {
			if (EntityCacheUtil.getResult(
						CdsLevelStatisticalReportModelImpl.ENTITY_CACHE_ENABLED,
						CdsLevelStatisticalReportImpl.class,
						cdsLevelStatisticalReport.getPrimaryKey(), this) == null) {
				cacheResult(cdsLevelStatisticalReport);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(CdsLevelStatisticalReportImpl.class.getName());
		EntityCacheUtil.clearCache(CdsLevelStatisticalReportImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public CdsLevelStatisticalReport create(Integer levelId) {
		CdsLevelStatisticalReport cdsLevelStatisticalReport = new CdsLevelStatisticalReportImpl();

		cdsLevelStatisticalReport.setNew(true);
		cdsLevelStatisticalReport.setPrimaryKey(levelId);

		return cdsLevelStatisticalReport;
	}

	public CdsLevelStatisticalReport remove(Integer levelId)
		throws NoSuchCdsLevelStatisticalReportException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CdsLevelStatisticalReport cdsLevelStatisticalReport = (CdsLevelStatisticalReport)session.get(CdsLevelStatisticalReportImpl.class,
					levelId);

			if (cdsLevelStatisticalReport == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No CdsLevelStatisticalReport exists with the primary key " +
						levelId);
				}

				throw new NoSuchCdsLevelStatisticalReportException(
					"No CdsLevelStatisticalReport exists with the primary key " +
					levelId);
			}

			return remove(cdsLevelStatisticalReport);
		}
		catch (NoSuchCdsLevelStatisticalReportException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public CdsLevelStatisticalReport remove(
		CdsLevelStatisticalReport cdsLevelStatisticalReport)
		throws SystemException {
		for (ModelListener<CdsLevelStatisticalReport> listener : listeners) {
			listener.onBeforeRemove(cdsLevelStatisticalReport);
		}

		cdsLevelStatisticalReport = removeImpl(cdsLevelStatisticalReport);

		for (ModelListener<CdsLevelStatisticalReport> listener : listeners) {
			listener.onAfterRemove(cdsLevelStatisticalReport);
		}

		return cdsLevelStatisticalReport;
	}

	protected CdsLevelStatisticalReport removeImpl(
		CdsLevelStatisticalReport cdsLevelStatisticalReport)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (cdsLevelStatisticalReport.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(CdsLevelStatisticalReportImpl.class,
						cdsLevelStatisticalReport.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(cdsLevelStatisticalReport);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(CdsLevelStatisticalReportModelImpl.ENTITY_CACHE_ENABLED,
			CdsLevelStatisticalReportImpl.class,
			cdsLevelStatisticalReport.getPrimaryKey());

		return cdsLevelStatisticalReport;
	}

	public CdsLevelStatisticalReport update(
		CdsLevelStatisticalReport cdsLevelStatisticalReport)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(CdsLevelStatisticalReport cdsLevelStatisticalReport) method. Use update(CdsLevelStatisticalReport cdsLevelStatisticalReport, boolean merge) instead.");
		}

		return update(cdsLevelStatisticalReport, false);
	}

	public CdsLevelStatisticalReport update(
		CdsLevelStatisticalReport cdsLevelStatisticalReport, boolean merge)
		throws SystemException {
		boolean isNew = cdsLevelStatisticalReport.isNew();

		for (ModelListener<CdsLevelStatisticalReport> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(cdsLevelStatisticalReport);
			}
			else {
				listener.onBeforeUpdate(cdsLevelStatisticalReport);
			}
		}

		cdsLevelStatisticalReport = updateImpl(cdsLevelStatisticalReport, merge);

		for (ModelListener<CdsLevelStatisticalReport> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(cdsLevelStatisticalReport);
			}
			else {
				listener.onAfterUpdate(cdsLevelStatisticalReport);
			}
		}

		return cdsLevelStatisticalReport;
	}

	public CdsLevelStatisticalReport updateImpl(
		larion.progate.cds.model.CdsLevelStatisticalReport cdsLevelStatisticalReport,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, cdsLevelStatisticalReport, merge);

			cdsLevelStatisticalReport.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(CdsLevelStatisticalReportModelImpl.ENTITY_CACHE_ENABLED,
			CdsLevelStatisticalReportImpl.class,
			cdsLevelStatisticalReport.getPrimaryKey(), cdsLevelStatisticalReport);

		return cdsLevelStatisticalReport;
	}

	public CdsLevelStatisticalReport findByPrimaryKey(Integer levelId)
		throws NoSuchCdsLevelStatisticalReportException, SystemException {
		CdsLevelStatisticalReport cdsLevelStatisticalReport = fetchByPrimaryKey(levelId);

		if (cdsLevelStatisticalReport == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"No CdsLevelStatisticalReport exists with the primary key " +
					levelId);
			}

			throw new NoSuchCdsLevelStatisticalReportException(
				"No CdsLevelStatisticalReport exists with the primary key " +
				levelId);
		}

		return cdsLevelStatisticalReport;
	}

	public CdsLevelStatisticalReport fetchByPrimaryKey(Integer levelId)
		throws SystemException {
		CdsLevelStatisticalReport cdsLevelStatisticalReport = (CdsLevelStatisticalReport)EntityCacheUtil.getResult(CdsLevelStatisticalReportModelImpl.ENTITY_CACHE_ENABLED,
				CdsLevelStatisticalReportImpl.class, levelId, this);

		if (cdsLevelStatisticalReport == null) {
			Session session = null;

			try {
				session = openSession();

				cdsLevelStatisticalReport = (CdsLevelStatisticalReport)session.get(CdsLevelStatisticalReportImpl.class,
						levelId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (cdsLevelStatisticalReport != null) {
					cacheResult(cdsLevelStatisticalReport);
				}

				closeSession(session);
			}
		}

		return cdsLevelStatisticalReport;
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

	public List<CdsLevelStatisticalReport> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<CdsLevelStatisticalReport> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<CdsLevelStatisticalReport> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<CdsLevelStatisticalReport> list = (List<CdsLevelStatisticalReport>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.CdsLevelStatisticalReport ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<CdsLevelStatisticalReport>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<CdsLevelStatisticalReport>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsLevelStatisticalReport>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeAll() throws SystemException {
		for (CdsLevelStatisticalReport cdsLevelStatisticalReport : findAll()) {
			remove(cdsLevelStatisticalReport);
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
						"SELECT COUNT(*) FROM larion.progate.cds.model.CdsLevelStatisticalReport");

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
						"value.object.listener.larion.progate.cds.model.CdsLevelStatisticalReport")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CdsLevelStatisticalReport>> listenersList = new ArrayList<ModelListener<CdsLevelStatisticalReport>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CdsLevelStatisticalReport>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(CdsLevelStatisticalReportPersistenceImpl.class);
}