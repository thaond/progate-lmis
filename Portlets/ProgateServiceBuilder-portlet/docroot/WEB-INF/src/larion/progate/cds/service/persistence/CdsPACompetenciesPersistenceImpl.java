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

import larion.progate.cds.NoSuchCdsPACompetenciesException;
import larion.progate.cds.model.CdsPACompetencies;
import larion.progate.cds.model.impl.CdsPACompetenciesImpl;
import larion.progate.cds.model.impl.CdsPACompetenciesModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="CdsPACompetenciesPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsPACompetenciesPersistenceImpl extends BasePersistenceImpl
	implements CdsPACompetenciesPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = CdsPACompetenciesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_PERIODID = new FinderPath(CdsPACompetenciesModelImpl.ENTITY_CACHE_ENABLED,
			CdsPACompetenciesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByPeriodId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_PERIODID = new FinderPath(CdsPACompetenciesModelImpl.ENTITY_CACHE_ENABLED,
			CdsPACompetenciesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByPeriodId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_PERIODID = new FinderPath(CdsPACompetenciesModelImpl.ENTITY_CACHE_ENABLED,
			CdsPACompetenciesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByPeriodId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(CdsPACompetenciesModelImpl.ENTITY_CACHE_ENABLED,
			CdsPACompetenciesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CdsPACompetenciesModelImpl.ENTITY_CACHE_ENABLED,
			CdsPACompetenciesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(CdsPACompetencies cdsPACompetencies) {
		EntityCacheUtil.putResult(CdsPACompetenciesModelImpl.ENTITY_CACHE_ENABLED,
			CdsPACompetenciesImpl.class, cdsPACompetencies.getPrimaryKey(),
			cdsPACompetencies);
	}

	public void cacheResult(List<CdsPACompetencies> cdsPACompetencieses) {
		for (CdsPACompetencies cdsPACompetencies : cdsPACompetencieses) {
			if (EntityCacheUtil.getResult(
						CdsPACompetenciesModelImpl.ENTITY_CACHE_ENABLED,
						CdsPACompetenciesImpl.class,
						cdsPACompetencies.getPrimaryKey(), this) == null) {
				cacheResult(cdsPACompetencies);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(CdsPACompetenciesImpl.class.getName());
		EntityCacheUtil.clearCache(CdsPACompetenciesImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public CdsPACompetencies create(Integer CdsPACompetenciesId) {
		CdsPACompetencies cdsPACompetencies = new CdsPACompetenciesImpl();

		cdsPACompetencies.setNew(true);
		cdsPACompetencies.setPrimaryKey(CdsPACompetenciesId);

		return cdsPACompetencies;
	}

	public CdsPACompetencies remove(Integer CdsPACompetenciesId)
		throws NoSuchCdsPACompetenciesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CdsPACompetencies cdsPACompetencies = (CdsPACompetencies)session.get(CdsPACompetenciesImpl.class,
					CdsPACompetenciesId);

			if (cdsPACompetencies == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No CdsPACompetencies exists with the primary key " +
						CdsPACompetenciesId);
				}

				throw new NoSuchCdsPACompetenciesException(
					"No CdsPACompetencies exists with the primary key " +
					CdsPACompetenciesId);
			}

			return remove(cdsPACompetencies);
		}
		catch (NoSuchCdsPACompetenciesException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public CdsPACompetencies remove(CdsPACompetencies cdsPACompetencies)
		throws SystemException {
		for (ModelListener<CdsPACompetencies> listener : listeners) {
			listener.onBeforeRemove(cdsPACompetencies);
		}

		cdsPACompetencies = removeImpl(cdsPACompetencies);

		for (ModelListener<CdsPACompetencies> listener : listeners) {
			listener.onAfterRemove(cdsPACompetencies);
		}

		return cdsPACompetencies;
	}

	protected CdsPACompetencies removeImpl(CdsPACompetencies cdsPACompetencies)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (cdsPACompetencies.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(CdsPACompetenciesImpl.class,
						cdsPACompetencies.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(cdsPACompetencies);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(CdsPACompetenciesModelImpl.ENTITY_CACHE_ENABLED,
			CdsPACompetenciesImpl.class, cdsPACompetencies.getPrimaryKey());

		return cdsPACompetencies;
	}

	public CdsPACompetencies update(CdsPACompetencies cdsPACompetencies)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(CdsPACompetencies cdsPACompetencies) method. Use update(CdsPACompetencies cdsPACompetencies, boolean merge) instead.");
		}

		return update(cdsPACompetencies, false);
	}

	public CdsPACompetencies update(CdsPACompetencies cdsPACompetencies,
		boolean merge) throws SystemException {
		boolean isNew = cdsPACompetencies.isNew();

		for (ModelListener<CdsPACompetencies> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(cdsPACompetencies);
			}
			else {
				listener.onBeforeUpdate(cdsPACompetencies);
			}
		}

		cdsPACompetencies = updateImpl(cdsPACompetencies, merge);

		for (ModelListener<CdsPACompetencies> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(cdsPACompetencies);
			}
			else {
				listener.onAfterUpdate(cdsPACompetencies);
			}
		}

		return cdsPACompetencies;
	}

	public CdsPACompetencies updateImpl(
		larion.progate.cds.model.CdsPACompetencies cdsPACompetencies,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, cdsPACompetencies, merge);

			cdsPACompetencies.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(CdsPACompetenciesModelImpl.ENTITY_CACHE_ENABLED,
			CdsPACompetenciesImpl.class, cdsPACompetencies.getPrimaryKey(),
			cdsPACompetencies);

		return cdsPACompetencies;
	}

	public CdsPACompetencies findByPrimaryKey(Integer CdsPACompetenciesId)
		throws NoSuchCdsPACompetenciesException, SystemException {
		CdsPACompetencies cdsPACompetencies = fetchByPrimaryKey(CdsPACompetenciesId);

		if (cdsPACompetencies == null) {
			if (_log.isWarnEnabled()) {
				_log.warn("No CdsPACompetencies exists with the primary key " +
					CdsPACompetenciesId);
			}

			throw new NoSuchCdsPACompetenciesException(
				"No CdsPACompetencies exists with the primary key " +
				CdsPACompetenciesId);
		}

		return cdsPACompetencies;
	}

	public CdsPACompetencies fetchByPrimaryKey(Integer CdsPACompetenciesId)
		throws SystemException {
		CdsPACompetencies cdsPACompetencies = (CdsPACompetencies)EntityCacheUtil.getResult(CdsPACompetenciesModelImpl.ENTITY_CACHE_ENABLED,
				CdsPACompetenciesImpl.class, CdsPACompetenciesId, this);

		if (cdsPACompetencies == null) {
			Session session = null;

			try {
				session = openSession();

				cdsPACompetencies = (CdsPACompetencies)session.get(CdsPACompetenciesImpl.class,
						CdsPACompetenciesId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (cdsPACompetencies != null) {
					cacheResult(cdsPACompetencies);
				}

				closeSession(session);
			}
		}

		return cdsPACompetencies;
	}

	public List<CdsPACompetencies> findByPeriodId(int periodId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(periodId) };

		List<CdsPACompetencies> list = (List<CdsPACompetencies>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_PERIODID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.CdsPACompetencies WHERE ");

				query.append("period_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(periodId);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsPACompetencies>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_PERIODID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<CdsPACompetencies> findByPeriodId(int periodId, int start,
		int end) throws SystemException {
		return findByPeriodId(periodId, start, end, null);
	}

	public List<CdsPACompetencies> findByPeriodId(int periodId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(periodId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<CdsPACompetencies> list = (List<CdsPACompetencies>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_PERIODID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.CdsPACompetencies WHERE ");

				query.append("period_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(periodId);

				list = (List<CdsPACompetencies>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsPACompetencies>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_PERIODID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public CdsPACompetencies findByPeriodId_First(int periodId,
		OrderByComparator obc)
		throws NoSuchCdsPACompetenciesException, SystemException {
		List<CdsPACompetencies> list = findByPeriodId(periodId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No CdsPACompetencies exists with the key {");

			msg.append("periodId=" + periodId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsPACompetenciesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsPACompetencies findByPeriodId_Last(int periodId,
		OrderByComparator obc)
		throws NoSuchCdsPACompetenciesException, SystemException {
		int count = countByPeriodId(periodId);

		List<CdsPACompetencies> list = findByPeriodId(periodId, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No CdsPACompetencies exists with the key {");

			msg.append("periodId=" + periodId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsPACompetenciesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsPACompetencies[] findByPeriodId_PrevAndNext(
		Integer CdsPACompetenciesId, int periodId, OrderByComparator obc)
		throws NoSuchCdsPACompetenciesException, SystemException {
		CdsPACompetencies cdsPACompetencies = findByPrimaryKey(CdsPACompetenciesId);

		int count = countByPeriodId(periodId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.cds.model.CdsPACompetencies WHERE ");

			query.append("period_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(periodId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					cdsPACompetencies);

			CdsPACompetencies[] array = new CdsPACompetenciesImpl[3];

			array[0] = (CdsPACompetencies)objArray[0];
			array[1] = (CdsPACompetencies)objArray[1];
			array[2] = (CdsPACompetencies)objArray[2];

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

	public List<CdsPACompetencies> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<CdsPACompetencies> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<CdsPACompetencies> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<CdsPACompetencies> list = (List<CdsPACompetencies>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.cds.model.CdsPACompetencies ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<CdsPACompetencies>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<CdsPACompetencies>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsPACompetencies>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByPeriodId(int periodId) throws SystemException {
		for (CdsPACompetencies cdsPACompetencies : findByPeriodId(periodId)) {
			remove(cdsPACompetencies);
		}
	}

	public void removeAll() throws SystemException {
		for (CdsPACompetencies cdsPACompetencies : findAll()) {
			remove(cdsPACompetencies);
		}
	}

	public int countByPeriodId(int periodId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(periodId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PERIODID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.cds.model.CdsPACompetencies WHERE ");

				query.append("period_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(periodId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PERIODID,
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
						"SELECT COUNT(*) FROM larion.progate.cds.model.CdsPACompetencies");

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
						"value.object.listener.larion.progate.cds.model.CdsPACompetencies")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CdsPACompetencies>> listenersList = new ArrayList<ModelListener<CdsPACompetencies>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CdsPACompetencies>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(CdsPACompetenciesPersistenceImpl.class);
}