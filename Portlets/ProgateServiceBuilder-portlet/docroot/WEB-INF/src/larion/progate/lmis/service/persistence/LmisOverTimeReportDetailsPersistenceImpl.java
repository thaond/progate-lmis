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

package larion.progate.lmis.service.persistence;

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

import larion.progate.lmis.NoSuchLmisOverTimeReportDetailsException;
import larion.progate.lmis.model.LmisOverTimeReportDetails;
import larion.progate.lmis.model.impl.LmisOverTimeReportDetailsImpl;
import larion.progate.lmis.model.impl.LmisOverTimeReportDetailsModelImpl;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="LmisOverTimeReportDetailsPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisOverTimeReportDetailsPersistenceImpl
	extends BasePersistenceImpl implements LmisOverTimeReportDetailsPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = LmisOverTimeReportDetailsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_OVERTIMEREPORTDETAILSOF = new FinderPath(LmisOverTimeReportDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeReportDetailsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOverTimeReportDetailsOf",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_OVERTIMEREPORTDETAILSOF =
		new FinderPath(LmisOverTimeReportDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeReportDetailsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOverTimeReportDetailsOf",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_OVERTIMEREPORTDETAILSOF = new FinderPath(LmisOverTimeReportDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeReportDetailsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByOverTimeReportDetailsOf",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_REPORTID = new FinderPath(LmisOverTimeReportDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeReportDetailsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByreportID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_REPORTID = new FinderPath(LmisOverTimeReportDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeReportDetailsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByreportID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_REPORTID = new FinderPath(LmisOverTimeReportDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeReportDetailsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByreportID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_USERID = new FinderPath(LmisOverTimeReportDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeReportDetailsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByuserID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_USERID = new FinderPath(LmisOverTimeReportDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeReportDetailsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByuserID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(LmisOverTimeReportDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeReportDetailsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByuserID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(LmisOverTimeReportDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeReportDetailsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LmisOverTimeReportDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeReportDetailsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(LmisOverTimeReportDetails lmisOverTimeReportDetails) {
		EntityCacheUtil.putResult(LmisOverTimeReportDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeReportDetailsImpl.class,
			lmisOverTimeReportDetails.getPrimaryKey(), lmisOverTimeReportDetails);
	}

	public void cacheResult(
		List<LmisOverTimeReportDetails> lmisOverTimeReportDetailses) {
		for (LmisOverTimeReportDetails lmisOverTimeReportDetails : lmisOverTimeReportDetailses) {
			if (EntityCacheUtil.getResult(
						LmisOverTimeReportDetailsModelImpl.ENTITY_CACHE_ENABLED,
						LmisOverTimeReportDetailsImpl.class,
						lmisOverTimeReportDetails.getPrimaryKey(), this) == null) {
				cacheResult(lmisOverTimeReportDetails);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(LmisOverTimeReportDetailsImpl.class.getName());
		EntityCacheUtil.clearCache(LmisOverTimeReportDetailsImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public LmisOverTimeReportDetails create(Integer lmisOverTimeReportDetailsId) {
		LmisOverTimeReportDetails lmisOverTimeReportDetails = new LmisOverTimeReportDetailsImpl();

		lmisOverTimeReportDetails.setNew(true);
		lmisOverTimeReportDetails.setPrimaryKey(lmisOverTimeReportDetailsId);

		return lmisOverTimeReportDetails;
	}

	public LmisOverTimeReportDetails remove(Integer lmisOverTimeReportDetailsId)
		throws NoSuchLmisOverTimeReportDetailsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LmisOverTimeReportDetails lmisOverTimeReportDetails = (LmisOverTimeReportDetails)session.get(LmisOverTimeReportDetailsImpl.class,
					lmisOverTimeReportDetailsId);

			if (lmisOverTimeReportDetails == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No LmisOverTimeReportDetails exists with the primary key " +
						lmisOverTimeReportDetailsId);
				}

				throw new NoSuchLmisOverTimeReportDetailsException(
					"No LmisOverTimeReportDetails exists with the primary key " +
					lmisOverTimeReportDetailsId);
			}

			return remove(lmisOverTimeReportDetails);
		}
		catch (NoSuchLmisOverTimeReportDetailsException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public LmisOverTimeReportDetails remove(
		LmisOverTimeReportDetails lmisOverTimeReportDetails)
		throws SystemException {
		for (ModelListener<LmisOverTimeReportDetails> listener : listeners) {
			listener.onBeforeRemove(lmisOverTimeReportDetails);
		}

		lmisOverTimeReportDetails = removeImpl(lmisOverTimeReportDetails);

		for (ModelListener<LmisOverTimeReportDetails> listener : listeners) {
			listener.onAfterRemove(lmisOverTimeReportDetails);
		}

		return lmisOverTimeReportDetails;
	}

	protected LmisOverTimeReportDetails removeImpl(
		LmisOverTimeReportDetails lmisOverTimeReportDetails)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (lmisOverTimeReportDetails.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(LmisOverTimeReportDetailsImpl.class,
						lmisOverTimeReportDetails.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(lmisOverTimeReportDetails);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(LmisOverTimeReportDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeReportDetailsImpl.class,
			lmisOverTimeReportDetails.getPrimaryKey());

		return lmisOverTimeReportDetails;
	}

	public LmisOverTimeReportDetails update(
		LmisOverTimeReportDetails lmisOverTimeReportDetails)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(LmisOverTimeReportDetails lmisOverTimeReportDetails) method. Use update(LmisOverTimeReportDetails lmisOverTimeReportDetails, boolean merge) instead.");
		}

		return update(lmisOverTimeReportDetails, false);
	}

	public LmisOverTimeReportDetails update(
		LmisOverTimeReportDetails lmisOverTimeReportDetails, boolean merge)
		throws SystemException {
		boolean isNew = lmisOverTimeReportDetails.isNew();

		for (ModelListener<LmisOverTimeReportDetails> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(lmisOverTimeReportDetails);
			}
			else {
				listener.onBeforeUpdate(lmisOverTimeReportDetails);
			}
		}

		lmisOverTimeReportDetails = updateImpl(lmisOverTimeReportDetails, merge);

		for (ModelListener<LmisOverTimeReportDetails> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(lmisOverTimeReportDetails);
			}
			else {
				listener.onAfterUpdate(lmisOverTimeReportDetails);
			}
		}

		return lmisOverTimeReportDetails;
	}

	public LmisOverTimeReportDetails updateImpl(
		larion.progate.lmis.model.LmisOverTimeReportDetails lmisOverTimeReportDetails,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, lmisOverTimeReportDetails, merge);

			lmisOverTimeReportDetails.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(LmisOverTimeReportDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOverTimeReportDetailsImpl.class,
			lmisOverTimeReportDetails.getPrimaryKey(), lmisOverTimeReportDetails);

		return lmisOverTimeReportDetails;
	}

	public LmisOverTimeReportDetails findByPrimaryKey(
		Integer lmisOverTimeReportDetailsId)
		throws NoSuchLmisOverTimeReportDetailsException, SystemException {
		LmisOverTimeReportDetails lmisOverTimeReportDetails = fetchByPrimaryKey(lmisOverTimeReportDetailsId);

		if (lmisOverTimeReportDetails == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"No LmisOverTimeReportDetails exists with the primary key " +
					lmisOverTimeReportDetailsId);
			}

			throw new NoSuchLmisOverTimeReportDetailsException(
				"No LmisOverTimeReportDetails exists with the primary key " +
				lmisOverTimeReportDetailsId);
		}

		return lmisOverTimeReportDetails;
	}

	public LmisOverTimeReportDetails fetchByPrimaryKey(
		Integer lmisOverTimeReportDetailsId) throws SystemException {
		LmisOverTimeReportDetails lmisOverTimeReportDetails = (LmisOverTimeReportDetails)EntityCacheUtil.getResult(LmisOverTimeReportDetailsModelImpl.ENTITY_CACHE_ENABLED,
				LmisOverTimeReportDetailsImpl.class,
				lmisOverTimeReportDetailsId, this);

		if (lmisOverTimeReportDetails == null) {
			Session session = null;

			try {
				session = openSession();

				lmisOverTimeReportDetails = (LmisOverTimeReportDetails)session.get(LmisOverTimeReportDetailsImpl.class,
						lmisOverTimeReportDetailsId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (lmisOverTimeReportDetails != null) {
					cacheResult(lmisOverTimeReportDetails);
				}

				closeSession(session);
			}
		}

		return lmisOverTimeReportDetails;
	}

	public List<LmisOverTimeReportDetails> findByOverTimeReportDetailsOf(
		int rootId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		List<LmisOverTimeReportDetails> list = (List<LmisOverTimeReportDetails>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OVERTIMEREPORTDETAILSOF,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOverTimeReportDetails WHERE ");

				query.append("root_id = ?");

				query.append(" ");

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
					list = new ArrayList<LmisOverTimeReportDetails>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OVERTIMEREPORTDETAILSOF,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisOverTimeReportDetails> findByOverTimeReportDetailsOf(
		int rootId, int start, int end) throws SystemException {
		return findByOverTimeReportDetailsOf(rootId, start, end, null);
	}

	public List<LmisOverTimeReportDetails> findByOverTimeReportDetailsOf(
		int rootId, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(rootId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisOverTimeReportDetails> list = (List<LmisOverTimeReportDetails>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_OVERTIMEREPORTDETAILSOF,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOverTimeReportDetails WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rootId);

				list = (List<LmisOverTimeReportDetails>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisOverTimeReportDetails>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_OVERTIMEREPORTDETAILSOF,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisOverTimeReportDetails findByOverTimeReportDetailsOf_First(
		int rootId, OrderByComparator obc)
		throws NoSuchLmisOverTimeReportDetailsException, SystemException {
		List<LmisOverTimeReportDetails> list = findByOverTimeReportDetailsOf(rootId,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOverTimeReportDetails exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOverTimeReportDetailsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOverTimeReportDetails findByOverTimeReportDetailsOf_Last(
		int rootId, OrderByComparator obc)
		throws NoSuchLmisOverTimeReportDetailsException, SystemException {
		int count = countByOverTimeReportDetailsOf(rootId);

		List<LmisOverTimeReportDetails> list = findByOverTimeReportDetailsOf(rootId,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOverTimeReportDetails exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOverTimeReportDetailsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOverTimeReportDetails[] findByOverTimeReportDetailsOf_PrevAndNext(
		Integer lmisOverTimeReportDetailsId, int rootId, OrderByComparator obc)
		throws NoSuchLmisOverTimeReportDetailsException, SystemException {
		LmisOverTimeReportDetails lmisOverTimeReportDetails = findByPrimaryKey(lmisOverTimeReportDetailsId);

		int count = countByOverTimeReportDetailsOf(rootId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisOverTimeReportDetails WHERE ");

			query.append("root_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(rootId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisOverTimeReportDetails);

			LmisOverTimeReportDetails[] array = new LmisOverTimeReportDetailsImpl[3];

			array[0] = (LmisOverTimeReportDetails)objArray[0];
			array[1] = (LmisOverTimeReportDetails)objArray[1];
			array[2] = (LmisOverTimeReportDetails)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisOverTimeReportDetails> findByreportID(int reportId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(reportId) };

		List<LmisOverTimeReportDetails> list = (List<LmisOverTimeReportDetails>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_REPORTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOverTimeReportDetails WHERE ");

				query.append("report_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(reportId);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisOverTimeReportDetails>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_REPORTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisOverTimeReportDetails> findByreportID(int reportId,
		int start, int end) throws SystemException {
		return findByreportID(reportId, start, end, null);
	}

	public List<LmisOverTimeReportDetails> findByreportID(int reportId,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(reportId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisOverTimeReportDetails> list = (List<LmisOverTimeReportDetails>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_REPORTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOverTimeReportDetails WHERE ");

				query.append("report_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(reportId);

				list = (List<LmisOverTimeReportDetails>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisOverTimeReportDetails>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_REPORTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisOverTimeReportDetails findByreportID_First(int reportId,
		OrderByComparator obc)
		throws NoSuchLmisOverTimeReportDetailsException, SystemException {
		List<LmisOverTimeReportDetails> list = findByreportID(reportId, 0, 1,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOverTimeReportDetails exists with the key {");

			msg.append("reportId=" + reportId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOverTimeReportDetailsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOverTimeReportDetails findByreportID_Last(int reportId,
		OrderByComparator obc)
		throws NoSuchLmisOverTimeReportDetailsException, SystemException {
		int count = countByreportID(reportId);

		List<LmisOverTimeReportDetails> list = findByreportID(reportId,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOverTimeReportDetails exists with the key {");

			msg.append("reportId=" + reportId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOverTimeReportDetailsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOverTimeReportDetails[] findByreportID_PrevAndNext(
		Integer lmisOverTimeReportDetailsId, int reportId, OrderByComparator obc)
		throws NoSuchLmisOverTimeReportDetailsException, SystemException {
		LmisOverTimeReportDetails lmisOverTimeReportDetails = findByPrimaryKey(lmisOverTimeReportDetailsId);

		int count = countByreportID(reportId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisOverTimeReportDetails WHERE ");

			query.append("report_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(reportId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisOverTimeReportDetails);

			LmisOverTimeReportDetails[] array = new LmisOverTimeReportDetailsImpl[3];

			array[0] = (LmisOverTimeReportDetails)objArray[0];
			array[1] = (LmisOverTimeReportDetails)objArray[1];
			array[2] = (LmisOverTimeReportDetails)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisOverTimeReportDetails> findByuserID(int userId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(userId) };

		List<LmisOverTimeReportDetails> list = (List<LmisOverTimeReportDetails>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_USERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOverTimeReportDetails WHERE ");

				query.append("user_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisOverTimeReportDetails>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_USERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisOverTimeReportDetails> findByuserID(int userId, int start,
		int end) throws SystemException {
		return findByuserID(userId, start, end, null);
	}

	public List<LmisOverTimeReportDetails> findByuserID(int userId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(userId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisOverTimeReportDetails> list = (List<LmisOverTimeReportDetails>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_USERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOverTimeReportDetails WHERE ");

				query.append("user_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				list = (List<LmisOverTimeReportDetails>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisOverTimeReportDetails>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_USERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisOverTimeReportDetails findByuserID_First(int userId,
		OrderByComparator obc)
		throws NoSuchLmisOverTimeReportDetailsException, SystemException {
		List<LmisOverTimeReportDetails> list = findByuserID(userId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOverTimeReportDetails exists with the key {");

			msg.append("userId=" + userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOverTimeReportDetailsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOverTimeReportDetails findByuserID_Last(int userId,
		OrderByComparator obc)
		throws NoSuchLmisOverTimeReportDetailsException, SystemException {
		int count = countByuserID(userId);

		List<LmisOverTimeReportDetails> list = findByuserID(userId, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOverTimeReportDetails exists with the key {");

			msg.append("userId=" + userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOverTimeReportDetailsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOverTimeReportDetails[] findByuserID_PrevAndNext(
		Integer lmisOverTimeReportDetailsId, int userId, OrderByComparator obc)
		throws NoSuchLmisOverTimeReportDetailsException, SystemException {
		LmisOverTimeReportDetails lmisOverTimeReportDetails = findByPrimaryKey(lmisOverTimeReportDetailsId);

		int count = countByuserID(userId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisOverTimeReportDetails WHERE ");

			query.append("user_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(userId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisOverTimeReportDetails);

			LmisOverTimeReportDetails[] array = new LmisOverTimeReportDetailsImpl[3];

			array[0] = (LmisOverTimeReportDetails)objArray[0];
			array[1] = (LmisOverTimeReportDetails)objArray[1];
			array[2] = (LmisOverTimeReportDetails)objArray[2];

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

	public List<LmisOverTimeReportDetails> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<LmisOverTimeReportDetails> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<LmisOverTimeReportDetails> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisOverTimeReportDetails> list = (List<LmisOverTimeReportDetails>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOverTimeReportDetails ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<LmisOverTimeReportDetails>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LmisOverTimeReportDetails>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisOverTimeReportDetails>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByOverTimeReportDetailsOf(int rootId)
		throws SystemException {
		for (LmisOverTimeReportDetails lmisOverTimeReportDetails : findByOverTimeReportDetailsOf(
				rootId)) {
			remove(lmisOverTimeReportDetails);
		}
	}

	public void removeByreportID(int reportId) throws SystemException {
		for (LmisOverTimeReportDetails lmisOverTimeReportDetails : findByreportID(
				reportId)) {
			remove(lmisOverTimeReportDetails);
		}
	}

	public void removeByuserID(int userId) throws SystemException {
		for (LmisOverTimeReportDetails lmisOverTimeReportDetails : findByuserID(
				userId)) {
			remove(lmisOverTimeReportDetails);
		}
	}

	public void removeAll() throws SystemException {
		for (LmisOverTimeReportDetails lmisOverTimeReportDetails : findAll()) {
			remove(lmisOverTimeReportDetails);
		}
	}

	public int countByOverTimeReportDetailsOf(int rootId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_OVERTIMEREPORTDETAILSOF,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisOverTimeReportDetails WHERE ");

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_OVERTIMEREPORTDETAILSOF,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByreportID(int reportId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(reportId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_REPORTID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisOverTimeReportDetails WHERE ");

				query.append("report_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(reportId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_REPORTID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByuserID(int userId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(userId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisOverTimeReportDetails WHERE ");

				query.append("user_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID,
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
						"SELECT COUNT(*) FROM larion.progate.lmis.model.LmisOverTimeReportDetails");

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

	public List<larion.progate.lmis.model.LmisOverTimeReportHours> getLmisOverTimeReportHourses(
		Integer pk) throws SystemException {
		return getLmisOverTimeReportHourses(pk, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS);
	}

	public List<larion.progate.lmis.model.LmisOverTimeReportHours> getLmisOverTimeReportHourses(
		Integer pk, int start, int end) throws SystemException {
		return getLmisOverTimeReportHourses(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_LMISOVERTIMEREPORTHOURSES = new FinderPath(larion.progate.lmis.model.impl.LmisOverTimeReportHoursModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.lmis.model.impl.LmisOverTimeReportHoursModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.lmis.service.persistence.LmisOverTimeReportHoursPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getLmisOverTimeReportHourses",
			new String[] {
				Integer.class.getName(), "java.lang.Integer",
				"java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	public List<larion.progate.lmis.model.LmisOverTimeReportHours> getLmisOverTimeReportHourses(
		Integer pk, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				pk, String.valueOf(start), String.valueOf(end),
				String.valueOf(obc)
			};

		List<larion.progate.lmis.model.LmisOverTimeReportHours> list = (List<larion.progate.lmis.model.LmisOverTimeReportHours>)FinderCacheUtil.getResult(FINDER_PATH_GET_LMISOVERTIMEREPORTHOURSES,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder sb = new StringBuilder();

				sb.append(_SQL_GETLMISOVERTIMEREPORTHOURSES);

				if (obc != null) {
					sb.append("ORDER BY ");
					sb.append(obc.getOrderBy());
				}

				String sql = sb.toString();

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("lmis_overtime_report_hours",
					larion.progate.lmis.model.impl.LmisOverTimeReportHoursImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<larion.progate.lmis.model.LmisOverTimeReportHours>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<larion.progate.lmis.model.LmisOverTimeReportHours>();
				}

				lmisOverTimeReportHoursPersistence.cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_GET_LMISOVERTIMEREPORTHOURSES,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_LMISOVERTIMEREPORTHOURSES_SIZE =
		new FinderPath(larion.progate.lmis.model.impl.LmisOverTimeReportHoursModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.lmis.model.impl.LmisOverTimeReportHoursModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.lmis.service.persistence.LmisOverTimeReportHoursPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getLmisOverTimeReportHoursesSize",
			new String[] { Integer.class.getName() });

	public int getLmisOverTimeReportHoursesSize(Integer pk)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_LMISOVERTIMEREPORTHOURSES_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETLMISOVERTIMEREPORTHOURSESSIZE);

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

				FinderCacheUtil.putResult(FINDER_PATH_GET_LMISOVERTIMEREPORTHOURSES_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_LMISOVERTIMEREPORTHOURS = new FinderPath(larion.progate.lmis.model.impl.LmisOverTimeReportHoursModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.lmis.model.impl.LmisOverTimeReportHoursModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.lmis.service.persistence.LmisOverTimeReportHoursPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"containsLmisOverTimeReportHours",
			new String[] { Integer.class.getName(), Integer.class.getName() });

	public boolean containsLmisOverTimeReportHours(Integer pk,
		Integer lmisOverTimeReportHoursPK) throws SystemException {
		Object[] finderArgs = new Object[] { pk, lmisOverTimeReportHoursPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_LMISOVERTIMEREPORTHOURS,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsLmisOverTimeReportHours.contains(
							pk, lmisOverTimeReportHoursPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_LMISOVERTIMEREPORTHOURS,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	public boolean containsLmisOverTimeReportHourses(Integer pk)
		throws SystemException {
		if (getLmisOverTimeReportHoursesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.larion.progate.lmis.model.LmisOverTimeReportDetails")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LmisOverTimeReportDetails>> listenersList = new ArrayList<ModelListener<LmisOverTimeReportDetails>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LmisOverTimeReportDetails>)Class.forName(
							listenerClassName).newInstance());
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		containsLmisOverTimeReportHours = new ContainsLmisOverTimeReportHours(this);
	}

	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisEmailSettingsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisEmailSettingsPersistence lmisEmailSettingsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisEmailSettingDetailsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisEmailSettingDetailsPersistence lmisEmailSettingDetailsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisTimeChangeApprovalsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisTimeChangeApprovalsPersistence lmisTimeChangeApprovalsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisTimeChangeRequestsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisTimeChangeRequestsPersistence lmisTimeChangeRequestsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisWorkingTimesPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisWorkingTimesPersistence lmisWorkingTimesPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisDayTypesPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisDayTypesPersistence lmisDayTypesPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisWorkingCalendarsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisWorkingCalendarsPersistence lmisWorkingCalendarsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisWorkingCalendarSessionsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisWorkingCalendarSessionsPersistence lmisWorkingCalendarSessionsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisGeneralSettingsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisGeneralSettingsPersistence lmisGeneralSettingsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewStaffMappingPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewStaffMappingPersistence lmisViewStaffMappingPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewStaffRootOrgPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewStaffRootOrgPersistence lmisViewStaffRootOrgPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewStaffRootOrgFNPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewStaffRootOrgFNPersistence lmisViewStaffRootOrgFNPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewStaffRootOrgOrderedPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewStaffRootOrgOrderedPersistence lmisViewStaffRootOrgOrderedPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewTimeChangeReqsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewTimeChangeReqsPersistence lmisViewTimeChangeReqsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewEmailSettingDetailOrgPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewEmailSettingDetailOrgPersistence lmisViewEmailSettingDetailOrgPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewEmailSettingDetailUserPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewEmailSettingDetailUserPersistence lmisViewEmailSettingDetailUserPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewWorkingCalendarPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewWorkingCalendarPersistence lmisViewWorkingCalendarPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisOverTimeSettingsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisOverTimeSettingsPersistence lmisOverTimeSettingsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisOverTimeTypesPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisOverTimeTypesPersistence lmisOverTimeTypesPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisDataInputsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisDataInputsPersistence lmisDataInputsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisAttendanceDailyPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisAttendanceDailyPersistence lmisAttendanceDailyPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisOvertimeRequestsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisOvertimeRequestsPersistence lmisOvertimeRequestsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisOvertimeRequestDetailsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisOvertimeRequestDetailsPersistence lmisOvertimeRequestDetailsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisOvertimeApprovalsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisOvertimeApprovalsPersistence lmisOvertimeApprovalsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisOvertimeMonthlyPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisOvertimeMonthlyPersistence lmisOvertimeMonthlyPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisDataImportsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisDataImportsPersistence lmisDataImportsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisDataImportDetailsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisDataImportDetailsPersistence lmisDataImportDetailsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisOverTimeReportHoursPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisOverTimeReportHoursPersistence lmisOverTimeReportHoursPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisOverTimeReportDetailsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisOverTimeReportDetailsPersistence lmisOverTimeReportDetailsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisOverTimeReportsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisOverTimeReportsPersistence lmisOverTimeReportsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisOvertimeYearlyPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisOvertimeYearlyPersistence lmisOvertimeYearlyPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisAbsenceYearlyPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisAbsenceYearlyPersistence lmisAbsenceYearlyPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisAbsenceMonthlyPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisAbsenceMonthlyPersistence lmisAbsenceMonthlyPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisAbsenceSettingsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisAbsenceSettingsPersistence lmisAbsenceSettingsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisAbsenceApprovalsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisAbsenceApprovalsPersistence lmisAbsenceApprovalsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisAbsenceRequestsPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisAbsenceRequestsPersistence lmisAbsenceRequestsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewDayTypeOverTimeSettingTypePersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewDayTypeOverTimeSettingTypePersistence lmisViewDayTypeOverTimeSettingTypePersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewRegistrationOvertimePersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewRegistrationOvertimePersistence lmisViewRegistrationOvertimePersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewRegistrationOvertimeaApprovalPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewRegistrationOvertimeaApprovalPersistence lmisViewRegistrationOvertimeaApprovalPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewOTAppPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewOTAppPersistence lmisViewOTAppPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewReportOvertimePersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewReportOvertimePersistence lmisViewReportOvertimePersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewAttDailyPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewAttDailyPersistence lmisViewAttDailyPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewReportOvertimeApprovalPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewReportOvertimeApprovalPersistence lmisViewReportOvertimeApprovalPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewDayValueMaxPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewDayValueMaxPersistence lmisViewDayValueMaxPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewOrgUserRolesPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewOrgUserRolesPersistence lmisViewOrgUserRolesPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewAttInfoPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewAttInfoPersistence lmisViewAttInfoPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewStaffMappingPmPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewStaffMappingPmPersistence lmisViewStaffMappingPmPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewAttdancePersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewAttdancePersistence lmisViewAttdancePersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewOvertimeReportPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewOvertimeReportPersistence lmisViewOvertimeReportPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewOvertimeReportDetailPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisViewOvertimeReportDetailPersistence lmisViewOvertimeReportDetailPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisAttMonthlyPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisAttMonthlyPersistence lmisAttMonthlyPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisAttYearlyPersistence.impl")
	protected larion.progate.lmis.service.persistence.LmisAttYearlyPersistence lmisAttYearlyPersistence;
	protected ContainsLmisOverTimeReportHours containsLmisOverTimeReportHours;

	protected class ContainsLmisOverTimeReportHours {
		protected ContainsLmisOverTimeReportHours(
			LmisOverTimeReportDetailsPersistenceImpl persistenceImpl) {
			super();

			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSLMISOVERTIMEREPORTHOURS,
					new int[] { Types.INTEGER, Types.INTEGER }, RowMapper.COUNT);
		}

		protected boolean contains(Integer lmisOverTimeReportDetailsId,
			Integer lmisOverTimeReportHoursId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						lmisOverTimeReportDetailsId, lmisOverTimeReportHoursId
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

	private static final String _SQL_GETLMISOVERTIMEREPORTHOURSES = "SELECT {lmis_overtime_report_hours.*} FROM lmis_overtime_report_hours INNER JOIN lmis_overtime_report_details ON (lmis_overtime_report_details.lmisOverTimeReportDetailsId = lmis_overtime_report_hours.lmisOverTimeReportDetailsId) WHERE (lmis_overtime_report_details.lmisOverTimeReportDetailsId = ?)";
	private static final String _SQL_GETLMISOVERTIMEREPORTHOURSESSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM lmis_overtime_report_hours WHERE lmisOverTimeReportDetailsId = ?";
	private static final String _SQL_CONTAINSLMISOVERTIMEREPORTHOURS = "SELECT COUNT(*) AS COUNT_VALUE FROM lmis_overtime_report_hours WHERE lmisOverTimeReportDetailsId = ? AND lmisOverTimeReportHoursId = ?";
	private static Log _log = LogFactoryUtil.getLog(LmisOverTimeReportDetailsPersistenceImpl.class);
}