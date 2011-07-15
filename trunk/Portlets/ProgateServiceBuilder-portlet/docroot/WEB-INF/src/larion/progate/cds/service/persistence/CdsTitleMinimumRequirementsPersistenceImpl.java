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

import larion.progate.cds.NoSuchCdsTitleMinimumRequirementsException;
import larion.progate.cds.model.CdsTitleMinimumRequirements;
import larion.progate.cds.model.impl.CdsTitleMinimumRequirementsImpl;
import larion.progate.cds.model.impl.CdsTitleMinimumRequirementsModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="CdsTitleMinimumRequirementsPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsTitleMinimumRequirementsPersistenceImpl
	extends BasePersistenceImpl
	implements CdsTitleMinimumRequirementsPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = CdsTitleMinimumRequirementsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_TITLEID = new FinderPath(CdsTitleMinimumRequirementsModelImpl.ENTITY_CACHE_ENABLED,
			CdsTitleMinimumRequirementsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByTitleId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_TITLEID = new FinderPath(CdsTitleMinimumRequirementsModelImpl.ENTITY_CACHE_ENABLED,
			CdsTitleMinimumRequirementsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByTitleId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_TITLEID = new FinderPath(CdsTitleMinimumRequirementsModelImpl.ENTITY_CACHE_ENABLED,
			CdsTitleMinimumRequirementsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByTitleId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_MINIMUMREQUIREMENTID = new FinderPath(CdsTitleMinimumRequirementsModelImpl.ENTITY_CACHE_ENABLED,
			CdsTitleMinimumRequirementsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByMinimumRequirementId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_MINIMUMREQUIREMENTID = new FinderPath(CdsTitleMinimumRequirementsModelImpl.ENTITY_CACHE_ENABLED,
			CdsTitleMinimumRequirementsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByMinimumRequirementId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_MINIMUMREQUIREMENTID = new FinderPath(CdsTitleMinimumRequirementsModelImpl.ENTITY_CACHE_ENABLED,
			CdsTitleMinimumRequirementsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByMinimumRequirementId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_MINIMUMREQUIREMENTLEVELID =
		new FinderPath(CdsTitleMinimumRequirementsModelImpl.ENTITY_CACHE_ENABLED,
			CdsTitleMinimumRequirementsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByMinimumRequirementLevelId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_MINIMUMREQUIREMENTLEVELID =
		new FinderPath(CdsTitleMinimumRequirementsModelImpl.ENTITY_CACHE_ENABLED,
			CdsTitleMinimumRequirementsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByMinimumRequirementLevelId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_MINIMUMREQUIREMENTLEVELID =
		new FinderPath(CdsTitleMinimumRequirementsModelImpl.ENTITY_CACHE_ENABLED,
			CdsTitleMinimumRequirementsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByMinimumRequirementLevelId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(CdsTitleMinimumRequirementsModelImpl.ENTITY_CACHE_ENABLED,
			CdsTitleMinimumRequirementsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CdsTitleMinimumRequirementsModelImpl.ENTITY_CACHE_ENABLED,
			CdsTitleMinimumRequirementsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(
		CdsTitleMinimumRequirements cdsTitleMinimumRequirements) {
		EntityCacheUtil.putResult(CdsTitleMinimumRequirementsModelImpl.ENTITY_CACHE_ENABLED,
			CdsTitleMinimumRequirementsImpl.class,
			cdsTitleMinimumRequirements.getPrimaryKey(),
			cdsTitleMinimumRequirements);
	}

	public void cacheResult(
		List<CdsTitleMinimumRequirements> cdsTitleMinimumRequirementses) {
		for (CdsTitleMinimumRequirements cdsTitleMinimumRequirements : cdsTitleMinimumRequirementses) {
			if (EntityCacheUtil.getResult(
						CdsTitleMinimumRequirementsModelImpl.ENTITY_CACHE_ENABLED,
						CdsTitleMinimumRequirementsImpl.class,
						cdsTitleMinimumRequirements.getPrimaryKey(), this) == null) {
				cacheResult(cdsTitleMinimumRequirements);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(CdsTitleMinimumRequirementsImpl.class.getName());
		EntityCacheUtil.clearCache(CdsTitleMinimumRequirementsImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public CdsTitleMinimumRequirements create(
		Integer CdsTitleMinimumRequirementsId) {
		CdsTitleMinimumRequirements cdsTitleMinimumRequirements = new CdsTitleMinimumRequirementsImpl();

		cdsTitleMinimumRequirements.setNew(true);
		cdsTitleMinimumRequirements.setPrimaryKey(CdsTitleMinimumRequirementsId);

		return cdsTitleMinimumRequirements;
	}

	public CdsTitleMinimumRequirements remove(
		Integer CdsTitleMinimumRequirementsId)
		throws NoSuchCdsTitleMinimumRequirementsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CdsTitleMinimumRequirements cdsTitleMinimumRequirements = (CdsTitleMinimumRequirements)session.get(CdsTitleMinimumRequirementsImpl.class,
					CdsTitleMinimumRequirementsId);

			if (cdsTitleMinimumRequirements == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No CdsTitleMinimumRequirements exists with the primary key " +
						CdsTitleMinimumRequirementsId);
				}

				throw new NoSuchCdsTitleMinimumRequirementsException(
					"No CdsTitleMinimumRequirements exists with the primary key " +
					CdsTitleMinimumRequirementsId);
			}

			return remove(cdsTitleMinimumRequirements);
		}
		catch (NoSuchCdsTitleMinimumRequirementsException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public CdsTitleMinimumRequirements remove(
		CdsTitleMinimumRequirements cdsTitleMinimumRequirements)
		throws SystemException {
		for (ModelListener<CdsTitleMinimumRequirements> listener : listeners) {
			listener.onBeforeRemove(cdsTitleMinimumRequirements);
		}

		cdsTitleMinimumRequirements = removeImpl(cdsTitleMinimumRequirements);

		for (ModelListener<CdsTitleMinimumRequirements> listener : listeners) {
			listener.onAfterRemove(cdsTitleMinimumRequirements);
		}

		return cdsTitleMinimumRequirements;
	}

	protected CdsTitleMinimumRequirements removeImpl(
		CdsTitleMinimumRequirements cdsTitleMinimumRequirements)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (cdsTitleMinimumRequirements.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(CdsTitleMinimumRequirementsImpl.class,
						cdsTitleMinimumRequirements.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(cdsTitleMinimumRequirements);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(CdsTitleMinimumRequirementsModelImpl.ENTITY_CACHE_ENABLED,
			CdsTitleMinimumRequirementsImpl.class,
			cdsTitleMinimumRequirements.getPrimaryKey());

		return cdsTitleMinimumRequirements;
	}

	public CdsTitleMinimumRequirements update(
		CdsTitleMinimumRequirements cdsTitleMinimumRequirements)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(CdsTitleMinimumRequirements cdsTitleMinimumRequirements) method. Use update(CdsTitleMinimumRequirements cdsTitleMinimumRequirements, boolean merge) instead.");
		}

		return update(cdsTitleMinimumRequirements, false);
	}

	public CdsTitleMinimumRequirements update(
		CdsTitleMinimumRequirements cdsTitleMinimumRequirements, boolean merge)
		throws SystemException {
		boolean isNew = cdsTitleMinimumRequirements.isNew();

		for (ModelListener<CdsTitleMinimumRequirements> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(cdsTitleMinimumRequirements);
			}
			else {
				listener.onBeforeUpdate(cdsTitleMinimumRequirements);
			}
		}

		cdsTitleMinimumRequirements = updateImpl(cdsTitleMinimumRequirements,
				merge);

		for (ModelListener<CdsTitleMinimumRequirements> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(cdsTitleMinimumRequirements);
			}
			else {
				listener.onAfterUpdate(cdsTitleMinimumRequirements);
			}
		}

		return cdsTitleMinimumRequirements;
	}

	public CdsTitleMinimumRequirements updateImpl(
		larion.progate.cds.model.CdsTitleMinimumRequirements cdsTitleMinimumRequirements,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, cdsTitleMinimumRequirements, merge);

			cdsTitleMinimumRequirements.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(CdsTitleMinimumRequirementsModelImpl.ENTITY_CACHE_ENABLED,
			CdsTitleMinimumRequirementsImpl.class,
			cdsTitleMinimumRequirements.getPrimaryKey(),
			cdsTitleMinimumRequirements);

		return cdsTitleMinimumRequirements;
	}

	public CdsTitleMinimumRequirements findByPrimaryKey(
		Integer CdsTitleMinimumRequirementsId)
		throws NoSuchCdsTitleMinimumRequirementsException, SystemException {
		CdsTitleMinimumRequirements cdsTitleMinimumRequirements = fetchByPrimaryKey(CdsTitleMinimumRequirementsId);

		if (cdsTitleMinimumRequirements == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"No CdsTitleMinimumRequirements exists with the primary key " +
					CdsTitleMinimumRequirementsId);
			}

			throw new NoSuchCdsTitleMinimumRequirementsException(
				"No CdsTitleMinimumRequirements exists with the primary key " +
				CdsTitleMinimumRequirementsId);
		}

		return cdsTitleMinimumRequirements;
	}

	public CdsTitleMinimumRequirements fetchByPrimaryKey(
		Integer CdsTitleMinimumRequirementsId) throws SystemException {
		CdsTitleMinimumRequirements cdsTitleMinimumRequirements = (CdsTitleMinimumRequirements)EntityCacheUtil.getResult(CdsTitleMinimumRequirementsModelImpl.ENTITY_CACHE_ENABLED,
				CdsTitleMinimumRequirementsImpl.class,
				CdsTitleMinimumRequirementsId, this);

		if (cdsTitleMinimumRequirements == null) {
			Session session = null;

			try {
				session = openSession();

				cdsTitleMinimumRequirements = (CdsTitleMinimumRequirements)session.get(CdsTitleMinimumRequirementsImpl.class,
						CdsTitleMinimumRequirementsId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (cdsTitleMinimumRequirements != null) {
					cacheResult(cdsTitleMinimumRequirements);
				}

				closeSession(session);
			}
		}

		return cdsTitleMinimumRequirements;
	}

	public List<CdsTitleMinimumRequirements> findByTitleId(int titleId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(titleId) };

		List<CdsTitleMinimumRequirements> list = (List<CdsTitleMinimumRequirements>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_TITLEID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.CdsTitleMinimumRequirements WHERE ");

				query.append("title_id = ?");

				query.append(" ");

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
					list = new ArrayList<CdsTitleMinimumRequirements>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_TITLEID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<CdsTitleMinimumRequirements> findByTitleId(int titleId,
		int start, int end) throws SystemException {
		return findByTitleId(titleId, start, end, null);
	}

	public List<CdsTitleMinimumRequirements> findByTitleId(int titleId,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(titleId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<CdsTitleMinimumRequirements> list = (List<CdsTitleMinimumRequirements>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_TITLEID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.CdsTitleMinimumRequirements WHERE ");

				query.append("title_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(titleId);

				list = (List<CdsTitleMinimumRequirements>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsTitleMinimumRequirements>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_TITLEID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public CdsTitleMinimumRequirements findByTitleId_First(int titleId,
		OrderByComparator obc)
		throws NoSuchCdsTitleMinimumRequirementsException, SystemException {
		List<CdsTitleMinimumRequirements> list = findByTitleId(titleId, 0, 1,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No CdsTitleMinimumRequirements exists with the key {");

			msg.append("titleId=" + titleId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsTitleMinimumRequirementsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsTitleMinimumRequirements findByTitleId_Last(int titleId,
		OrderByComparator obc)
		throws NoSuchCdsTitleMinimumRequirementsException, SystemException {
		int count = countByTitleId(titleId);

		List<CdsTitleMinimumRequirements> list = findByTitleId(titleId,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No CdsTitleMinimumRequirements exists with the key {");

			msg.append("titleId=" + titleId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsTitleMinimumRequirementsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsTitleMinimumRequirements[] findByTitleId_PrevAndNext(
		Integer CdsTitleMinimumRequirementsId, int titleId,
		OrderByComparator obc)
		throws NoSuchCdsTitleMinimumRequirementsException, SystemException {
		CdsTitleMinimumRequirements cdsTitleMinimumRequirements = findByPrimaryKey(CdsTitleMinimumRequirementsId);

		int count = countByTitleId(titleId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.cds.model.CdsTitleMinimumRequirements WHERE ");

			query.append("title_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(titleId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					cdsTitleMinimumRequirements);

			CdsTitleMinimumRequirements[] array = new CdsTitleMinimumRequirementsImpl[3];

			array[0] = (CdsTitleMinimumRequirements)objArray[0];
			array[1] = (CdsTitleMinimumRequirements)objArray[1];
			array[2] = (CdsTitleMinimumRequirements)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<CdsTitleMinimumRequirements> findByMinimumRequirementId(
		int minimumRequirementId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(minimumRequirementId) };

		List<CdsTitleMinimumRequirements> list = (List<CdsTitleMinimumRequirements>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_MINIMUMREQUIREMENTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.CdsTitleMinimumRequirements WHERE ");

				query.append("minimum_requirement_id = ?");

				query.append(" ");

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
					list = new ArrayList<CdsTitleMinimumRequirements>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_MINIMUMREQUIREMENTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<CdsTitleMinimumRequirements> findByMinimumRequirementId(
		int minimumRequirementId, int start, int end) throws SystemException {
		return findByMinimumRequirementId(minimumRequirementId, start, end, null);
	}

	public List<CdsTitleMinimumRequirements> findByMinimumRequirementId(
		int minimumRequirementId, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(minimumRequirementId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<CdsTitleMinimumRequirements> list = (List<CdsTitleMinimumRequirements>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_MINIMUMREQUIREMENTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.CdsTitleMinimumRequirements WHERE ");

				query.append("minimum_requirement_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(minimumRequirementId);

				list = (List<CdsTitleMinimumRequirements>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsTitleMinimumRequirements>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_MINIMUMREQUIREMENTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public CdsTitleMinimumRequirements findByMinimumRequirementId_First(
		int minimumRequirementId, OrderByComparator obc)
		throws NoSuchCdsTitleMinimumRequirementsException, SystemException {
		List<CdsTitleMinimumRequirements> list = findByMinimumRequirementId(minimumRequirementId,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No CdsTitleMinimumRequirements exists with the key {");

			msg.append("minimumRequirementId=" + minimumRequirementId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsTitleMinimumRequirementsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsTitleMinimumRequirements findByMinimumRequirementId_Last(
		int minimumRequirementId, OrderByComparator obc)
		throws NoSuchCdsTitleMinimumRequirementsException, SystemException {
		int count = countByMinimumRequirementId(minimumRequirementId);

		List<CdsTitleMinimumRequirements> list = findByMinimumRequirementId(minimumRequirementId,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No CdsTitleMinimumRequirements exists with the key {");

			msg.append("minimumRequirementId=" + minimumRequirementId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsTitleMinimumRequirementsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsTitleMinimumRequirements[] findByMinimumRequirementId_PrevAndNext(
		Integer CdsTitleMinimumRequirementsId, int minimumRequirementId,
		OrderByComparator obc)
		throws NoSuchCdsTitleMinimumRequirementsException, SystemException {
		CdsTitleMinimumRequirements cdsTitleMinimumRequirements = findByPrimaryKey(CdsTitleMinimumRequirementsId);

		int count = countByMinimumRequirementId(minimumRequirementId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.cds.model.CdsTitleMinimumRequirements WHERE ");

			query.append("minimum_requirement_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(minimumRequirementId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					cdsTitleMinimumRequirements);

			CdsTitleMinimumRequirements[] array = new CdsTitleMinimumRequirementsImpl[3];

			array[0] = (CdsTitleMinimumRequirements)objArray[0];
			array[1] = (CdsTitleMinimumRequirements)objArray[1];
			array[2] = (CdsTitleMinimumRequirements)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<CdsTitleMinimumRequirements> findByMinimumRequirementLevelId(
		int minimumRequirementLevelId) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(minimumRequirementLevelId)
			};

		List<CdsTitleMinimumRequirements> list = (List<CdsTitleMinimumRequirements>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_MINIMUMREQUIREMENTLEVELID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.CdsTitleMinimumRequirements WHERE ");

				query.append("level_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(minimumRequirementLevelId);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsTitleMinimumRequirements>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_MINIMUMREQUIREMENTLEVELID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<CdsTitleMinimumRequirements> findByMinimumRequirementLevelId(
		int minimumRequirementLevelId, int start, int end)
		throws SystemException {
		return findByMinimumRequirementLevelId(minimumRequirementLevelId,
			start, end, null);
	}

	public List<CdsTitleMinimumRequirements> findByMinimumRequirementLevelId(
		int minimumRequirementLevelId, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(minimumRequirementLevelId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<CdsTitleMinimumRequirements> list = (List<CdsTitleMinimumRequirements>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_MINIMUMREQUIREMENTLEVELID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.CdsTitleMinimumRequirements WHERE ");

				query.append("level_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(minimumRequirementLevelId);

				list = (List<CdsTitleMinimumRequirements>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsTitleMinimumRequirements>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_MINIMUMREQUIREMENTLEVELID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public CdsTitleMinimumRequirements findByMinimumRequirementLevelId_First(
		int minimumRequirementLevelId, OrderByComparator obc)
		throws NoSuchCdsTitleMinimumRequirementsException, SystemException {
		List<CdsTitleMinimumRequirements> list = findByMinimumRequirementLevelId(minimumRequirementLevelId,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No CdsTitleMinimumRequirements exists with the key {");

			msg.append("minimumRequirementLevelId=" +
				minimumRequirementLevelId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsTitleMinimumRequirementsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsTitleMinimumRequirements findByMinimumRequirementLevelId_Last(
		int minimumRequirementLevelId, OrderByComparator obc)
		throws NoSuchCdsTitleMinimumRequirementsException, SystemException {
		int count = countByMinimumRequirementLevelId(minimumRequirementLevelId);

		List<CdsTitleMinimumRequirements> list = findByMinimumRequirementLevelId(minimumRequirementLevelId,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No CdsTitleMinimumRequirements exists with the key {");

			msg.append("minimumRequirementLevelId=" +
				minimumRequirementLevelId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCdsTitleMinimumRequirementsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public CdsTitleMinimumRequirements[] findByMinimumRequirementLevelId_PrevAndNext(
		Integer CdsTitleMinimumRequirementsId, int minimumRequirementLevelId,
		OrderByComparator obc)
		throws NoSuchCdsTitleMinimumRequirementsException, SystemException {
		CdsTitleMinimumRequirements cdsTitleMinimumRequirements = findByPrimaryKey(CdsTitleMinimumRequirementsId);

		int count = countByMinimumRequirementLevelId(minimumRequirementLevelId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.cds.model.CdsTitleMinimumRequirements WHERE ");

			query.append("level_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(minimumRequirementLevelId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					cdsTitleMinimumRequirements);

			CdsTitleMinimumRequirements[] array = new CdsTitleMinimumRequirementsImpl[3];

			array[0] = (CdsTitleMinimumRequirements)objArray[0];
			array[1] = (CdsTitleMinimumRequirements)objArray[1];
			array[2] = (CdsTitleMinimumRequirements)objArray[2];

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

	public List<CdsTitleMinimumRequirements> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<CdsTitleMinimumRequirements> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<CdsTitleMinimumRequirements> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<CdsTitleMinimumRequirements> list = (List<CdsTitleMinimumRequirements>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.cds.model.CdsTitleMinimumRequirements ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<CdsTitleMinimumRequirements>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<CdsTitleMinimumRequirements>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<CdsTitleMinimumRequirements>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByTitleId(int titleId) throws SystemException {
		for (CdsTitleMinimumRequirements cdsTitleMinimumRequirements : findByTitleId(
				titleId)) {
			remove(cdsTitleMinimumRequirements);
		}
	}

	public void removeByMinimumRequirementId(int minimumRequirementId)
		throws SystemException {
		for (CdsTitleMinimumRequirements cdsTitleMinimumRequirements : findByMinimumRequirementId(
				minimumRequirementId)) {
			remove(cdsTitleMinimumRequirements);
		}
	}

	public void removeByMinimumRequirementLevelId(int minimumRequirementLevelId)
		throws SystemException {
		for (CdsTitleMinimumRequirements cdsTitleMinimumRequirements : findByMinimumRequirementLevelId(
				minimumRequirementLevelId)) {
			remove(cdsTitleMinimumRequirements);
		}
	}

	public void removeAll() throws SystemException {
		for (CdsTitleMinimumRequirements cdsTitleMinimumRequirements : findAll()) {
			remove(cdsTitleMinimumRequirements);
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
					"FROM larion.progate.cds.model.CdsTitleMinimumRequirements WHERE ");

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
					"FROM larion.progate.cds.model.CdsTitleMinimumRequirements WHERE ");

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

	public int countByMinimumRequirementLevelId(int minimumRequirementLevelId)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(minimumRequirementLevelId)
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MINIMUMREQUIREMENTLEVELID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.cds.model.CdsTitleMinimumRequirements WHERE ");

				query.append("level_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(minimumRequirementLevelId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MINIMUMREQUIREMENTLEVELID,
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
						"SELECT COUNT(*) FROM larion.progate.cds.model.CdsTitleMinimumRequirements");

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
						"value.object.listener.larion.progate.cds.model.CdsTitleMinimumRequirements")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CdsTitleMinimumRequirements>> listenersList = new ArrayList<ModelListener<CdsTitleMinimumRequirements>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CdsTitleMinimumRequirements>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(CdsTitleMinimumRequirementsPersistenceImpl.class);
}