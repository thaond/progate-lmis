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

import larion.progate.cds.NoSuchCdsTitleCompetenciesException;
import larion.progate.cds.model.CdsTitleCompetencies;
import larion.progate.cds.model.impl.CdsTitleCompetenciesImpl;
import larion.progate.cds.model.impl.CdsTitleCompetenciesModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="CdsTitleCompetenciesPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsTitleCompetenciesPersistenceImpl extends BasePersistenceImpl
	implements CdsTitleCompetenciesPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = CdsTitleCompetenciesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_CDSTITLEID = new FinderPath(CdsTitleCompetenciesModelImpl.ENTITY_CACHE_ENABLED,
			CdsTitleCompetenciesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByCdsTitleId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_CDSTITLEID = new FinderPath(CdsTitleCompetenciesModelImpl.ENTITY_CACHE_ENABLED,
			CdsTitleCompetenciesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByCdsTitleId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_CDSTITLEID = new FinderPath(CdsTitleCompetenciesModelImpl.ENTITY_CACHE_ENABLED,
			CdsTitleCompetenciesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByCdsTitleId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_COMPETENCYID = new FinderPath(CdsTitleCompetenciesModelImpl.ENTITY_CACHE_ENABLED,
			CdsTitleCompetenciesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByCompetencyId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_COMPETENCYID = new FinderPath(CdsTitleCompetenciesModelImpl.ENTITY_CACHE_ENABLED,
			CdsTitleCompetenciesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByCompetencyId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPETENCYID = new FinderPath(CdsTitleCompetenciesModelImpl.ENTITY_CACHE_ENABLED,
			CdsTitleCompetenciesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByCompetencyId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(CdsTitleCompetenciesModelImpl.ENTITY_CACHE_ENABLED,
			CdsTitleCompetenciesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CdsTitleCompetenciesModelImpl.ENTITY_CACHE_ENABLED,
			CdsTitleCompetenciesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(CdsTitleCompetencies cdsTitleCompetencies) {
		EntityCacheUtil.putResult(CdsTitleCompetenciesModelImpl.ENTITY_CACHE_ENABLED,
			CdsTitleCompetenciesImpl.class,
			cdsTitleCompetencies.getPrimaryKey(), cdsTitleCompetencies);
	}

	public void cacheResult(List<CdsTitleCompetencies> cdsTitleCompetencieses) {
		for (CdsTitleCompetencies cdsTitleCompetencies : cdsTitleCompetencieses) {
			if (EntityCacheUtil.getResult(
						CdsTitleCompetenciesModelImpl.ENTITY_CACHE_ENABLED,
						CdsTitleCompetenciesImpl.class,
						cdsTitleCompetencies.getPrimaryKey(), this) == null) {
				cacheResult(cdsTitleCompetencies);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(CdsTitleCompetenciesImpl.class.getName());
		EntityCacheUtil.clearCache(CdsTitleCompetenciesImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public CdsTitleCompetencies create(Integer CdsTitleCompetenciesId) {
		CdsTitleCompetencies cdsTitleCompetencies = new CdsTitleCompetenciesImpl();

		cdsTitleCompetencies.setNew(true);
		cdsTitleCompetencies.setPrimaryKey(CdsTitleCompetenciesId);

		return cdsTitleCompetencies;
	}

	public CdsTitleCompetencies remove(Integer CdsTitleCompetenciesId)
		throws NoSuchCdsTitleCompetenciesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CdsTitleCompetencies cdsTitleCompetencies = (CdsTitleCompetencies)session.get(CdsTitleCompetenciesImpl.class,
					CdsTitleCompetenciesId);

			if (cdsTitleCompetencies == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No CdsTitleCompetencies exists with the primary key " +
						CdsTitleCompetenciesId);
				}

				throw new NoSuchCdsTitleCompetenciesException(
					"No CdsTitleCompetencies exists with the primary key " +
					CdsTitleCompetenciesId);
			}

			return remove(cdsTitleCompetencies);
		}
		catch (NoSuchCdsTitleCompetenciesException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public CdsTitleCompetencies remove(
		CdsTitleCompetencies cdsTitleCompetencies) throws SystemException {
		for (ModelListener<CdsTitleCompetencies> listener : listeners) {
			listener.onBeforeRemove(cdsTitleCompetencies);
		}

		cdsTitleCompetencies = removeImpl(cdsTitleCompetencies);

		for (ModelListener<CdsTitleCompetencies> listener : listeners) {
			listener.onAfterRemove(cdsTitleCompetencies);
		}

		return cdsTitleCompetencies;
	}

	protected CdsTitleCompetencies removeImpl(
		CdsTitleCompetencies cdsTitleCompetencies) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (cdsTitleCompetencies.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(CdsTitleCompetenciesImpl.class,
						cdsTitleCompetencies.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(cdsTitleCompetencies);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(CdsTitleCompetenciesModelImpl.ENTITY_CACHE_ENABLED,
			CdsTitleCompetenciesImpl.class, cdsTitleCompetencies.getPrimaryKey());

		return cdsTitleCompetencies;
	}

	public CdsTitleCompetencies update(
		CdsTitleCompetencies cdsTitleCompetencies) throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(CdsTitleCompetencies cdsTitleCompetencies) method. Use update(CdsTitleCompetencies cdsTitleCompetencies, boolean merge) instead.");
		}

		return update(cdsTitleCompetencies, false);
	}

	public CdsTitleCompetencies update(
		CdsTitleCompetencies cdsTitleCompetencies, boolean merge)
		throws SystemException {
		boolean isNew = cdsTitleCompetencies.isNew();

		for (ModelListener<CdsTitleCompetencies> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(cdsTitleCompetencies);
			}
			else {
				listener.onBeforeUpdate(cdsTitleCompetencies);
			}
		}

		cdsTitleCompetencies = updateImpl(cdsTitleCompetencies, merge);

		for (ModelListener<CdsTitleCompetencies> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(cdsTitleCompetencies);
			}
			else {
				listener.onAfterUpdate(cdsTitleCompetencies);
			}
		}

		return cdsTitleCompetencies;
	}

	public CdsTitleCompetencies updateImpl(
		larion.progate.cds.model.CdsTitleCompetencies cdsTitleCompetencies,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, cdsTitleCompetencies, merge);

			cdsTitleCompetencies.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(CdsTitleCompetenciesModelImpl.ENTITY_CACHE_ENABLED,
			CdsTitleCompetenciesImpl.class,
			cdsTitleCompetencies.getPrimaryKey(), cdsTitleCompetencies);

		return cdsTitleCompetencies;
	}

	public CdsTitleCompetencies findByPrimaryKey(Integer CdsTitleCompetenciesId)
		throws NoSuchCdsTitleCompetenciesException, SystemException {
		CdsTitleCompetencies cdsTitleCompetencies = fetchByPrimaryKey(CdsTitleCompetenciesId);

		if (cdsTitleCompetencies == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"No CdsTitleCompetencies exists with the primary key " +
					CdsTitleCompetenciesId);
			}

			throw new NoSuchCdsTitleCompetenciesException(
				"No CdsTitleCompetencies exists with the primary key " +
				CdsTitleCompetenciesId);
		}

		return cdsTitleCompetencies;
	}

	public CdsTitleCompetencies fetchByPrimaryKey(
		Integer CdsTitleCompetenciesId) throws SystemException {
		CdsTitleCompetencies cdsTitleCompetencies = (CdsTitleCompetencies)EntityCacheUtil.getResult(CdsTitleCompetenciesModelImpl.ENTITY_CACHE_ENABLED,
				CdsTitleCompetenciesImpl.class, CdsTitleCompetenciesId, this);

		if (cdsTitleCompetencies == null) {
			Session session = null;

			try {
				session = openSession();

				cdsTitleCompetencies = (CdsTitleCompetencies)session.get(CdsTitleCompetenciesImpl.class,
						CdsTitleCompetenciesId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (cdsTitleCompetencies != null) {
					cacheResult(cdsTitleCompetencies);
				}

				closeSession(session);
			}
		}

		return cdsTitleCompetencies;
	}

	public List<CdsTitleCompetencies> findByCdsTitleId(int cdsTitleId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(cdsTitleId) };

		List<CdsTitleCompetencies> list = (List<CdsTitleCompetencies>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_CDSTITLEID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.CdsTitleCompetencies WHERE ");

				query.append("title_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(cdsTitleId);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsTitleCompetencies>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_CDSTITLEID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<CdsTitleCompetencies> findByCdsTitleId(int cdsTitleId,
		int start, int end) throws SystemException {
		return findByCdsTitleId(cdsTitleId, start, end, null);
	}

	public List<CdsTitleCompetencies> findByCdsTitleId(int cdsTitleId,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(cdsTitleId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<CdsTitleCompetencies> list = (List<CdsTitleCompetencies>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_CDSTITLEID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.CdsTitleCompetencies WHERE ");

				query.append("title_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(cdsTitleId);

				list = (List<CdsTitleCompetencies>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsTitleCompetencies>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_CDSTITLEID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public CdsTitleCompetencies findByCdsTitleId_First(int cdsTitleId,
		OrderByComparator obc)
		throws NoSuchCdsTitleCompetenciesException, SystemException {
		List<CdsTitleCompetencies> list = findByCdsTitleId(cdsTitleId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No CdsTitleCompetencies exists with the key {");

			msg.append("cdsTitleId=" + cdsTitleId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsTitleCompetenciesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsTitleCompetencies findByCdsTitleId_Last(int cdsTitleId,
		OrderByComparator obc)
		throws NoSuchCdsTitleCompetenciesException, SystemException {
		int count = countByCdsTitleId(cdsTitleId);

		List<CdsTitleCompetencies> list = findByCdsTitleId(cdsTitleId,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No CdsTitleCompetencies exists with the key {");

			msg.append("cdsTitleId=" + cdsTitleId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsTitleCompetenciesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsTitleCompetencies[] findByCdsTitleId_PrevAndNext(
		Integer CdsTitleCompetenciesId, int cdsTitleId, OrderByComparator obc)
		throws NoSuchCdsTitleCompetenciesException, SystemException {
		CdsTitleCompetencies cdsTitleCompetencies = findByPrimaryKey(CdsTitleCompetenciesId);

		int count = countByCdsTitleId(cdsTitleId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.cds.model.CdsTitleCompetencies WHERE ");

			query.append("title_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(cdsTitleId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					cdsTitleCompetencies);

			CdsTitleCompetencies[] array = new CdsTitleCompetenciesImpl[3];

			array[0] = (CdsTitleCompetencies)objArray[0];
			array[1] = (CdsTitleCompetencies)objArray[1];
			array[2] = (CdsTitleCompetencies)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<CdsTitleCompetencies> findByCompetencyId(int competencyId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(competencyId) };

		List<CdsTitleCompetencies> list = (List<CdsTitleCompetencies>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_COMPETENCYID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.CdsTitleCompetencies WHERE ");

				query.append("competency_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(competencyId);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsTitleCompetencies>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_COMPETENCYID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<CdsTitleCompetencies> findByCompetencyId(int competencyId,
		int start, int end) throws SystemException {
		return findByCompetencyId(competencyId, start, end, null);
	}

	public List<CdsTitleCompetencies> findByCompetencyId(int competencyId,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(competencyId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<CdsTitleCompetencies> list = (List<CdsTitleCompetencies>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_COMPETENCYID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.CdsTitleCompetencies WHERE ");

				query.append("competency_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(competencyId);

				list = (List<CdsTitleCompetencies>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsTitleCompetencies>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_COMPETENCYID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public CdsTitleCompetencies findByCompetencyId_First(int competencyId,
		OrderByComparator obc)
		throws NoSuchCdsTitleCompetenciesException, SystemException {
		List<CdsTitleCompetencies> list = findByCompetencyId(competencyId, 0,
				1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No CdsTitleCompetencies exists with the key {");

			msg.append("competencyId=" + competencyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsTitleCompetenciesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsTitleCompetencies findByCompetencyId_Last(int competencyId,
		OrderByComparator obc)
		throws NoSuchCdsTitleCompetenciesException, SystemException {
		int count = countByCompetencyId(competencyId);

		List<CdsTitleCompetencies> list = findByCompetencyId(competencyId,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No CdsTitleCompetencies exists with the key {");

			msg.append("competencyId=" + competencyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsTitleCompetenciesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsTitleCompetencies[] findByCompetencyId_PrevAndNext(
		Integer CdsTitleCompetenciesId, int competencyId, OrderByComparator obc)
		throws NoSuchCdsTitleCompetenciesException, SystemException {
		CdsTitleCompetencies cdsTitleCompetencies = findByPrimaryKey(CdsTitleCompetenciesId);

		int count = countByCompetencyId(competencyId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.cds.model.CdsTitleCompetencies WHERE ");

			query.append("competency_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(competencyId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					cdsTitleCompetencies);

			CdsTitleCompetencies[] array = new CdsTitleCompetenciesImpl[3];

			array[0] = (CdsTitleCompetencies)objArray[0];
			array[1] = (CdsTitleCompetencies)objArray[1];
			array[2] = (CdsTitleCompetencies)objArray[2];

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

	public List<CdsTitleCompetencies> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<CdsTitleCompetencies> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<CdsTitleCompetencies> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<CdsTitleCompetencies> list = (List<CdsTitleCompetencies>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.CdsTitleCompetencies ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<CdsTitleCompetencies>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<CdsTitleCompetencies>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsTitleCompetencies>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByCdsTitleId(int cdsTitleId) throws SystemException {
		for (CdsTitleCompetencies cdsTitleCompetencies : findByCdsTitleId(
				cdsTitleId)) {
			remove(cdsTitleCompetencies);
		}
	}

	public void removeByCompetencyId(int competencyId)
		throws SystemException {
		for (CdsTitleCompetencies cdsTitleCompetencies : findByCompetencyId(
				competencyId)) {
			remove(cdsTitleCompetencies);
		}
	}

	public void removeAll() throws SystemException {
		for (CdsTitleCompetencies cdsTitleCompetencies : findAll()) {
			remove(cdsTitleCompetencies);
		}
	}

	public int countByCdsTitleId(int cdsTitleId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(cdsTitleId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CDSTITLEID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.cds.model.CdsTitleCompetencies WHERE ");

				query.append("title_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(cdsTitleId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CDSTITLEID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByCompetencyId(int competencyId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(competencyId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPETENCYID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.cds.model.CdsTitleCompetencies WHERE ");

				query.append("competency_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(competencyId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPETENCYID,
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
						"SELECT COUNT(*) FROM larion.progate.cds.model.CdsTitleCompetencies");

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
						"value.object.listener.larion.progate.cds.model.CdsTitleCompetencies")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CdsTitleCompetencies>> listenersList = new ArrayList<ModelListener<CdsTitleCompetencies>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CdsTitleCompetencies>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(CdsTitleCompetenciesPersistenceImpl.class);
}