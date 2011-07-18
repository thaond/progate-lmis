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

import larion.progate.lmis.NoSuchLmisOvertimeRequestDetailsException;
import larion.progate.lmis.model.LmisOvertimeRequestDetails;
import larion.progate.lmis.model.impl.LmisOvertimeRequestDetailsImpl;
import larion.progate.lmis.model.impl.LmisOvertimeRequestDetailsModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="LmisOvertimeRequestDetailsPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisOvertimeRequestDetailsPersistenceImpl
	extends BasePersistenceImpl implements LmisOvertimeRequestDetailsPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = LmisOvertimeRequestDetailsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_OVERTIMEREQUESTDETAILSOF = new FinderPath(LmisOvertimeRequestDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeRequestDetailsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOvertimeRequestDetailsOf",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_OVERTIMEREQUESTDETAILSOF =
		new FinderPath(LmisOvertimeRequestDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeRequestDetailsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOvertimeRequestDetailsOf",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_OVERTIMEREQUESTDETAILSOF =
		new FinderPath(LmisOvertimeRequestDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeRequestDetailsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByOvertimeRequestDetailsOf",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_REQUESTEDID = new FinderPath(LmisOvertimeRequestDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeRequestDetailsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRequestedID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_REQUESTEDID = new FinderPath(LmisOvertimeRequestDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeRequestDetailsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRequestedID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_REQUESTEDID = new FinderPath(LmisOvertimeRequestDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeRequestDetailsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByRequestedID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_USERID = new FinderPath(LmisOvertimeRequestDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeRequestDetailsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByUserID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_USERID = new FinderPath(LmisOvertimeRequestDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeRequestDetailsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByUserID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(LmisOvertimeRequestDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeRequestDetailsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByUserID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(LmisOvertimeRequestDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeRequestDetailsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LmisOvertimeRequestDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeRequestDetailsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(
		LmisOvertimeRequestDetails lmisOvertimeRequestDetails) {
		EntityCacheUtil.putResult(LmisOvertimeRequestDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeRequestDetailsImpl.class,
			lmisOvertimeRequestDetails.getPrimaryKey(),
			lmisOvertimeRequestDetails);
	}

	public void cacheResult(
		List<LmisOvertimeRequestDetails> lmisOvertimeRequestDetailses) {
		for (LmisOvertimeRequestDetails lmisOvertimeRequestDetails : lmisOvertimeRequestDetailses) {
			if (EntityCacheUtil.getResult(
						LmisOvertimeRequestDetailsModelImpl.ENTITY_CACHE_ENABLED,
						LmisOvertimeRequestDetailsImpl.class,
						lmisOvertimeRequestDetails.getPrimaryKey(), this) == null) {
				cacheResult(lmisOvertimeRequestDetails);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(LmisOvertimeRequestDetailsImpl.class.getName());
		EntityCacheUtil.clearCache(LmisOvertimeRequestDetailsImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public LmisOvertimeRequestDetails create(
		Integer lmisOvertimeRequestDetailsId) {
		LmisOvertimeRequestDetails lmisOvertimeRequestDetails = new LmisOvertimeRequestDetailsImpl();

		lmisOvertimeRequestDetails.setNew(true);
		lmisOvertimeRequestDetails.setPrimaryKey(lmisOvertimeRequestDetailsId);

		return lmisOvertimeRequestDetails;
	}

	public LmisOvertimeRequestDetails remove(
		Integer lmisOvertimeRequestDetailsId)
		throws NoSuchLmisOvertimeRequestDetailsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LmisOvertimeRequestDetails lmisOvertimeRequestDetails = (LmisOvertimeRequestDetails)session.get(LmisOvertimeRequestDetailsImpl.class,
					lmisOvertimeRequestDetailsId);

			if (lmisOvertimeRequestDetails == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No LmisOvertimeRequestDetails exists with the primary key " +
						lmisOvertimeRequestDetailsId);
				}

				throw new NoSuchLmisOvertimeRequestDetailsException(
					"No LmisOvertimeRequestDetails exists with the primary key " +
					lmisOvertimeRequestDetailsId);
			}

			return remove(lmisOvertimeRequestDetails);
		}
		catch (NoSuchLmisOvertimeRequestDetailsException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public LmisOvertimeRequestDetails remove(
		LmisOvertimeRequestDetails lmisOvertimeRequestDetails)
		throws SystemException {
		for (ModelListener<LmisOvertimeRequestDetails> listener : listeners) {
			listener.onBeforeRemove(lmisOvertimeRequestDetails);
		}

		lmisOvertimeRequestDetails = removeImpl(lmisOvertimeRequestDetails);

		for (ModelListener<LmisOvertimeRequestDetails> listener : listeners) {
			listener.onAfterRemove(lmisOvertimeRequestDetails);
		}

		return lmisOvertimeRequestDetails;
	}

	protected LmisOvertimeRequestDetails removeImpl(
		LmisOvertimeRequestDetails lmisOvertimeRequestDetails)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (lmisOvertimeRequestDetails.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(LmisOvertimeRequestDetailsImpl.class,
						lmisOvertimeRequestDetails.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(lmisOvertimeRequestDetails);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(LmisOvertimeRequestDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeRequestDetailsImpl.class,
			lmisOvertimeRequestDetails.getPrimaryKey());

		return lmisOvertimeRequestDetails;
	}

	public LmisOvertimeRequestDetails update(
		LmisOvertimeRequestDetails lmisOvertimeRequestDetails)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(LmisOvertimeRequestDetails lmisOvertimeRequestDetails) method. Use update(LmisOvertimeRequestDetails lmisOvertimeRequestDetails, boolean merge) instead.");
		}

		return update(lmisOvertimeRequestDetails, false);
	}

	public LmisOvertimeRequestDetails update(
		LmisOvertimeRequestDetails lmisOvertimeRequestDetails, boolean merge)
		throws SystemException {
		boolean isNew = lmisOvertimeRequestDetails.isNew();

		for (ModelListener<LmisOvertimeRequestDetails> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(lmisOvertimeRequestDetails);
			}
			else {
				listener.onBeforeUpdate(lmisOvertimeRequestDetails);
			}
		}

		lmisOvertimeRequestDetails = updateImpl(lmisOvertimeRequestDetails,
				merge);

		for (ModelListener<LmisOvertimeRequestDetails> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(lmisOvertimeRequestDetails);
			}
			else {
				listener.onAfterUpdate(lmisOvertimeRequestDetails);
			}
		}

		return lmisOvertimeRequestDetails;
	}

	public LmisOvertimeRequestDetails updateImpl(
		larion.progate.lmis.model.LmisOvertimeRequestDetails lmisOvertimeRequestDetails,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, lmisOvertimeRequestDetails, merge);

			lmisOvertimeRequestDetails.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(LmisOvertimeRequestDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LmisOvertimeRequestDetailsImpl.class,
			lmisOvertimeRequestDetails.getPrimaryKey(),
			lmisOvertimeRequestDetails);

		return lmisOvertimeRequestDetails;
	}

	public LmisOvertimeRequestDetails findByPrimaryKey(
		Integer lmisOvertimeRequestDetailsId)
		throws NoSuchLmisOvertimeRequestDetailsException, SystemException {
		LmisOvertimeRequestDetails lmisOvertimeRequestDetails = fetchByPrimaryKey(lmisOvertimeRequestDetailsId);

		if (lmisOvertimeRequestDetails == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"No LmisOvertimeRequestDetails exists with the primary key " +
					lmisOvertimeRequestDetailsId);
			}

			throw new NoSuchLmisOvertimeRequestDetailsException(
				"No LmisOvertimeRequestDetails exists with the primary key " +
				lmisOvertimeRequestDetailsId);
		}

		return lmisOvertimeRequestDetails;
	}

	public LmisOvertimeRequestDetails fetchByPrimaryKey(
		Integer lmisOvertimeRequestDetailsId) throws SystemException {
		LmisOvertimeRequestDetails lmisOvertimeRequestDetails = (LmisOvertimeRequestDetails)EntityCacheUtil.getResult(LmisOvertimeRequestDetailsModelImpl.ENTITY_CACHE_ENABLED,
				LmisOvertimeRequestDetailsImpl.class,
				lmisOvertimeRequestDetailsId, this);

		if (lmisOvertimeRequestDetails == null) {
			Session session = null;

			try {
				session = openSession();

				lmisOvertimeRequestDetails = (LmisOvertimeRequestDetails)session.get(LmisOvertimeRequestDetailsImpl.class,
						lmisOvertimeRequestDetailsId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (lmisOvertimeRequestDetails != null) {
					cacheResult(lmisOvertimeRequestDetails);
				}

				closeSession(session);
			}
		}

		return lmisOvertimeRequestDetails;
	}

	public List<LmisOvertimeRequestDetails> findByOvertimeRequestDetailsOf(
		int rootId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		List<LmisOvertimeRequestDetails> list = (List<LmisOvertimeRequestDetails>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OVERTIMEREQUESTDETAILSOF,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOvertimeRequestDetails WHERE ");

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
					list = new ArrayList<LmisOvertimeRequestDetails>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OVERTIMEREQUESTDETAILSOF,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisOvertimeRequestDetails> findByOvertimeRequestDetailsOf(
		int rootId, int start, int end) throws SystemException {
		return findByOvertimeRequestDetailsOf(rootId, start, end, null);
	}

	public List<LmisOvertimeRequestDetails> findByOvertimeRequestDetailsOf(
		int rootId, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(rootId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisOvertimeRequestDetails> list = (List<LmisOvertimeRequestDetails>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_OVERTIMEREQUESTDETAILSOF,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOvertimeRequestDetails WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rootId);

				list = (List<LmisOvertimeRequestDetails>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisOvertimeRequestDetails>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_OVERTIMEREQUESTDETAILSOF,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisOvertimeRequestDetails findByOvertimeRequestDetailsOf_First(
		int rootId, OrderByComparator obc)
		throws NoSuchLmisOvertimeRequestDetailsException, SystemException {
		List<LmisOvertimeRequestDetails> list = findByOvertimeRequestDetailsOf(rootId,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOvertimeRequestDetails exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOvertimeRequestDetailsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOvertimeRequestDetails findByOvertimeRequestDetailsOf_Last(
		int rootId, OrderByComparator obc)
		throws NoSuchLmisOvertimeRequestDetailsException, SystemException {
		int count = countByOvertimeRequestDetailsOf(rootId);

		List<LmisOvertimeRequestDetails> list = findByOvertimeRequestDetailsOf(rootId,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOvertimeRequestDetails exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOvertimeRequestDetailsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOvertimeRequestDetails[] findByOvertimeRequestDetailsOf_PrevAndNext(
		Integer lmisOvertimeRequestDetailsId, int rootId, OrderByComparator obc)
		throws NoSuchLmisOvertimeRequestDetailsException, SystemException {
		LmisOvertimeRequestDetails lmisOvertimeRequestDetails = findByPrimaryKey(lmisOvertimeRequestDetailsId);

		int count = countByOvertimeRequestDetailsOf(rootId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisOvertimeRequestDetails WHERE ");

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
					lmisOvertimeRequestDetails);

			LmisOvertimeRequestDetails[] array = new LmisOvertimeRequestDetailsImpl[3];

			array[0] = (LmisOvertimeRequestDetails)objArray[0];
			array[1] = (LmisOvertimeRequestDetails)objArray[1];
			array[2] = (LmisOvertimeRequestDetails)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisOvertimeRequestDetails> findByRequestedID(int requestId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(requestId) };

		List<LmisOvertimeRequestDetails> list = (List<LmisOvertimeRequestDetails>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_REQUESTEDID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOvertimeRequestDetails WHERE ");

				query.append("request_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(requestId);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisOvertimeRequestDetails>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_REQUESTEDID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisOvertimeRequestDetails> findByRequestedID(int requestId,
		int start, int end) throws SystemException {
		return findByRequestedID(requestId, start, end, null);
	}

	public List<LmisOvertimeRequestDetails> findByRequestedID(int requestId,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(requestId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisOvertimeRequestDetails> list = (List<LmisOvertimeRequestDetails>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_REQUESTEDID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOvertimeRequestDetails WHERE ");

				query.append("request_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(requestId);

				list = (List<LmisOvertimeRequestDetails>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisOvertimeRequestDetails>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_REQUESTEDID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisOvertimeRequestDetails findByRequestedID_First(int requestId,
		OrderByComparator obc)
		throws NoSuchLmisOvertimeRequestDetailsException, SystemException {
		List<LmisOvertimeRequestDetails> list = findByRequestedID(requestId, 0,
				1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOvertimeRequestDetails exists with the key {");

			msg.append("requestId=" + requestId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOvertimeRequestDetailsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOvertimeRequestDetails findByRequestedID_Last(int requestId,
		OrderByComparator obc)
		throws NoSuchLmisOvertimeRequestDetailsException, SystemException {
		int count = countByRequestedID(requestId);

		List<LmisOvertimeRequestDetails> list = findByRequestedID(requestId,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOvertimeRequestDetails exists with the key {");

			msg.append("requestId=" + requestId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOvertimeRequestDetailsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOvertimeRequestDetails[] findByRequestedID_PrevAndNext(
		Integer lmisOvertimeRequestDetailsId, int requestId,
		OrderByComparator obc)
		throws NoSuchLmisOvertimeRequestDetailsException, SystemException {
		LmisOvertimeRequestDetails lmisOvertimeRequestDetails = findByPrimaryKey(lmisOvertimeRequestDetailsId);

		int count = countByRequestedID(requestId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisOvertimeRequestDetails WHERE ");

			query.append("request_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(requestId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisOvertimeRequestDetails);

			LmisOvertimeRequestDetails[] array = new LmisOvertimeRequestDetailsImpl[3];

			array[0] = (LmisOvertimeRequestDetails)objArray[0];
			array[1] = (LmisOvertimeRequestDetails)objArray[1];
			array[2] = (LmisOvertimeRequestDetails)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisOvertimeRequestDetails> findByUserID(int userId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(userId) };

		List<LmisOvertimeRequestDetails> list = (List<LmisOvertimeRequestDetails>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_USERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOvertimeRequestDetails WHERE ");

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
					list = new ArrayList<LmisOvertimeRequestDetails>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_USERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisOvertimeRequestDetails> findByUserID(int userId, int start,
		int end) throws SystemException {
		return findByUserID(userId, start, end, null);
	}

	public List<LmisOvertimeRequestDetails> findByUserID(int userId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(userId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisOvertimeRequestDetails> list = (List<LmisOvertimeRequestDetails>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_USERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOvertimeRequestDetails WHERE ");

				query.append("user_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				list = (List<LmisOvertimeRequestDetails>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisOvertimeRequestDetails>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_USERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisOvertimeRequestDetails findByUserID_First(int userId,
		OrderByComparator obc)
		throws NoSuchLmisOvertimeRequestDetailsException, SystemException {
		List<LmisOvertimeRequestDetails> list = findByUserID(userId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOvertimeRequestDetails exists with the key {");

			msg.append("userId=" + userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOvertimeRequestDetailsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOvertimeRequestDetails findByUserID_Last(int userId,
		OrderByComparator obc)
		throws NoSuchLmisOvertimeRequestDetailsException, SystemException {
		int count = countByUserID(userId);

		List<LmisOvertimeRequestDetails> list = findByUserID(userId, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisOvertimeRequestDetails exists with the key {");

			msg.append("userId=" + userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisOvertimeRequestDetailsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisOvertimeRequestDetails[] findByUserID_PrevAndNext(
		Integer lmisOvertimeRequestDetailsId, int userId, OrderByComparator obc)
		throws NoSuchLmisOvertimeRequestDetailsException, SystemException {
		LmisOvertimeRequestDetails lmisOvertimeRequestDetails = findByPrimaryKey(lmisOvertimeRequestDetailsId);

		int count = countByUserID(userId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisOvertimeRequestDetails WHERE ");

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
					lmisOvertimeRequestDetails);

			LmisOvertimeRequestDetails[] array = new LmisOvertimeRequestDetailsImpl[3];

			array[0] = (LmisOvertimeRequestDetails)objArray[0];
			array[1] = (LmisOvertimeRequestDetails)objArray[1];
			array[2] = (LmisOvertimeRequestDetails)objArray[2];

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

	public List<LmisOvertimeRequestDetails> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<LmisOvertimeRequestDetails> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<LmisOvertimeRequestDetails> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisOvertimeRequestDetails> list = (List<LmisOvertimeRequestDetails>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisOvertimeRequestDetails ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<LmisOvertimeRequestDetails>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LmisOvertimeRequestDetails>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisOvertimeRequestDetails>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByOvertimeRequestDetailsOf(int rootId)
		throws SystemException {
		for (LmisOvertimeRequestDetails lmisOvertimeRequestDetails : findByOvertimeRequestDetailsOf(
				rootId)) {
			remove(lmisOvertimeRequestDetails);
		}
	}

	public void removeByRequestedID(int requestId) throws SystemException {
		for (LmisOvertimeRequestDetails lmisOvertimeRequestDetails : findByRequestedID(
				requestId)) {
			remove(lmisOvertimeRequestDetails);
		}
	}

	public void removeByUserID(int userId) throws SystemException {
		for (LmisOvertimeRequestDetails lmisOvertimeRequestDetails : findByUserID(
				userId)) {
			remove(lmisOvertimeRequestDetails);
		}
	}

	public void removeAll() throws SystemException {
		for (LmisOvertimeRequestDetails lmisOvertimeRequestDetails : findAll()) {
			remove(lmisOvertimeRequestDetails);
		}
	}

	public int countByOvertimeRequestDetailsOf(int rootId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_OVERTIMEREQUESTDETAILSOF,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisOvertimeRequestDetails WHERE ");

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_OVERTIMEREQUESTDETAILSOF,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByRequestedID(int requestId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(requestId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_REQUESTEDID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisOvertimeRequestDetails WHERE ");

				query.append("request_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(requestId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_REQUESTEDID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByUserID(int userId) throws SystemException {
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
					"FROM larion.progate.lmis.model.LmisOvertimeRequestDetails WHERE ");

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
						"SELECT COUNT(*) FROM larion.progate.lmis.model.LmisOvertimeRequestDetails");

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
						"value.object.listener.larion.progate.lmis.model.LmisOvertimeRequestDetails")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LmisOvertimeRequestDetails>> listenersList = new ArrayList<ModelListener<LmisOvertimeRequestDetails>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LmisOvertimeRequestDetails>)Class.forName(
							listenerClassName).newInstance());
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
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
	private static Log _log = LogFactoryUtil.getLog(LmisOvertimeRequestDetailsPersistenceImpl.class);
}