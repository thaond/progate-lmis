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

import larion.progate.lmis.NoSuchLmisDataImportDetailsException;
import larion.progate.lmis.model.LmisDataImportDetails;
import larion.progate.lmis.model.impl.LmisDataImportDetailsImpl;
import larion.progate.lmis.model.impl.LmisDataImportDetailsModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="LmisDataImportDetailsPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisDataImportDetailsPersistenceImpl extends BasePersistenceImpl
	implements LmisDataImportDetailsPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = LmisDataImportDetailsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_DATAIMPORTDETAILSOF = new FinderPath(LmisDataImportDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LmisDataImportDetailsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByDataImportDetailsOf",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_DATAIMPORTDETAILSOF = new FinderPath(LmisDataImportDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LmisDataImportDetailsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByDataImportDetailsOf",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_DATAIMPORTDETAILSOF = new FinderPath(LmisDataImportDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LmisDataImportDetailsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByDataImportDetailsOf",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_SCANNERID = new FinderPath(LmisDataImportDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LmisDataImportDetailsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByScannerID",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_SCANNERID = new FinderPath(LmisDataImportDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LmisDataImportDetailsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByScannerID",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_SCANNERID = new FinderPath(LmisDataImportDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LmisDataImportDetailsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByScannerID",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_IMPORTID = new FinderPath(LmisDataImportDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LmisDataImportDetailsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByImportID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_IMPORTID = new FinderPath(LmisDataImportDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LmisDataImportDetailsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByImportID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_IMPORTID = new FinderPath(LmisDataImportDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LmisDataImportDetailsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByImportID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(LmisDataImportDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LmisDataImportDetailsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LmisDataImportDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LmisDataImportDetailsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(LmisDataImportDetails lmisDataImportDetails) {
		EntityCacheUtil.putResult(LmisDataImportDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LmisDataImportDetailsImpl.class,
			lmisDataImportDetails.getPrimaryKey(), lmisDataImportDetails);
	}

	public void cacheResult(List<LmisDataImportDetails> lmisDataImportDetailses) {
		for (LmisDataImportDetails lmisDataImportDetails : lmisDataImportDetailses) {
			if (EntityCacheUtil.getResult(
						LmisDataImportDetailsModelImpl.ENTITY_CACHE_ENABLED,
						LmisDataImportDetailsImpl.class,
						lmisDataImportDetails.getPrimaryKey(), this) == null) {
				cacheResult(lmisDataImportDetails);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(LmisDataImportDetailsImpl.class.getName());
		EntityCacheUtil.clearCache(LmisDataImportDetailsImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public LmisDataImportDetails create(Integer lmisDataImportDetailsId) {
		LmisDataImportDetails lmisDataImportDetails = new LmisDataImportDetailsImpl();

		lmisDataImportDetails.setNew(true);
		lmisDataImportDetails.setPrimaryKey(lmisDataImportDetailsId);

		return lmisDataImportDetails;
	}

	public LmisDataImportDetails remove(Integer lmisDataImportDetailsId)
		throws NoSuchLmisDataImportDetailsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LmisDataImportDetails lmisDataImportDetails = (LmisDataImportDetails)session.get(LmisDataImportDetailsImpl.class,
					lmisDataImportDetailsId);

			if (lmisDataImportDetails == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No LmisDataImportDetails exists with the primary key " +
						lmisDataImportDetailsId);
				}

				throw new NoSuchLmisDataImportDetailsException(
					"No LmisDataImportDetails exists with the primary key " +
					lmisDataImportDetailsId);
			}

			return remove(lmisDataImportDetails);
		}
		catch (NoSuchLmisDataImportDetailsException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public LmisDataImportDetails remove(
		LmisDataImportDetails lmisDataImportDetails) throws SystemException {
		for (ModelListener<LmisDataImportDetails> listener : listeners) {
			listener.onBeforeRemove(lmisDataImportDetails);
		}

		lmisDataImportDetails = removeImpl(lmisDataImportDetails);

		for (ModelListener<LmisDataImportDetails> listener : listeners) {
			listener.onAfterRemove(lmisDataImportDetails);
		}

		return lmisDataImportDetails;
	}

	protected LmisDataImportDetails removeImpl(
		LmisDataImportDetails lmisDataImportDetails) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (lmisDataImportDetails.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(LmisDataImportDetailsImpl.class,
						lmisDataImportDetails.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(lmisDataImportDetails);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(LmisDataImportDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LmisDataImportDetailsImpl.class,
			lmisDataImportDetails.getPrimaryKey());

		return lmisDataImportDetails;
	}

	public LmisDataImportDetails update(
		LmisDataImportDetails lmisDataImportDetails) throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(LmisDataImportDetails lmisDataImportDetails) method. Use update(LmisDataImportDetails lmisDataImportDetails, boolean merge) instead.");
		}

		return update(lmisDataImportDetails, false);
	}

	public LmisDataImportDetails update(
		LmisDataImportDetails lmisDataImportDetails, boolean merge)
		throws SystemException {
		boolean isNew = lmisDataImportDetails.isNew();

		for (ModelListener<LmisDataImportDetails> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(lmisDataImportDetails);
			}
			else {
				listener.onBeforeUpdate(lmisDataImportDetails);
			}
		}

		lmisDataImportDetails = updateImpl(lmisDataImportDetails, merge);

		for (ModelListener<LmisDataImportDetails> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(lmisDataImportDetails);
			}
			else {
				listener.onAfterUpdate(lmisDataImportDetails);
			}
		}

		return lmisDataImportDetails;
	}

	public LmisDataImportDetails updateImpl(
		larion.progate.lmis.model.LmisDataImportDetails lmisDataImportDetails,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, lmisDataImportDetails, merge);

			lmisDataImportDetails.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(LmisDataImportDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LmisDataImportDetailsImpl.class,
			lmisDataImportDetails.getPrimaryKey(), lmisDataImportDetails);

		return lmisDataImportDetails;
	}

	public LmisDataImportDetails findByPrimaryKey(
		Integer lmisDataImportDetailsId)
		throws NoSuchLmisDataImportDetailsException, SystemException {
		LmisDataImportDetails lmisDataImportDetails = fetchByPrimaryKey(lmisDataImportDetailsId);

		if (lmisDataImportDetails == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"No LmisDataImportDetails exists with the primary key " +
					lmisDataImportDetailsId);
			}

			throw new NoSuchLmisDataImportDetailsException(
				"No LmisDataImportDetails exists with the primary key " +
				lmisDataImportDetailsId);
		}

		return lmisDataImportDetails;
	}

	public LmisDataImportDetails fetchByPrimaryKey(
		Integer lmisDataImportDetailsId) throws SystemException {
		LmisDataImportDetails lmisDataImportDetails = (LmisDataImportDetails)EntityCacheUtil.getResult(LmisDataImportDetailsModelImpl.ENTITY_CACHE_ENABLED,
				LmisDataImportDetailsImpl.class, lmisDataImportDetailsId, this);

		if (lmisDataImportDetails == null) {
			Session session = null;

			try {
				session = openSession();

				lmisDataImportDetails = (LmisDataImportDetails)session.get(LmisDataImportDetailsImpl.class,
						lmisDataImportDetailsId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (lmisDataImportDetails != null) {
					cacheResult(lmisDataImportDetails);
				}

				closeSession(session);
			}
		}

		return lmisDataImportDetails;
	}

	public List<LmisDataImportDetails> findByDataImportDetailsOf(int rootId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		List<LmisDataImportDetails> list = (List<LmisDataImportDetails>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DATAIMPORTDETAILSOF,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisDataImportDetails WHERE ");

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
					list = new ArrayList<LmisDataImportDetails>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DATAIMPORTDETAILSOF,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisDataImportDetails> findByDataImportDetailsOf(int rootId,
		int start, int end) throws SystemException {
		return findByDataImportDetailsOf(rootId, start, end, null);
	}

	public List<LmisDataImportDetails> findByDataImportDetailsOf(int rootId,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(rootId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisDataImportDetails> list = (List<LmisDataImportDetails>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_DATAIMPORTDETAILSOF,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisDataImportDetails WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rootId);

				list = (List<LmisDataImportDetails>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisDataImportDetails>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_DATAIMPORTDETAILSOF,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisDataImportDetails findByDataImportDetailsOf_First(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisDataImportDetailsException, SystemException {
		List<LmisDataImportDetails> list = findByDataImportDetailsOf(rootId, 0,
				1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisDataImportDetails exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisDataImportDetailsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisDataImportDetails findByDataImportDetailsOf_Last(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisDataImportDetailsException, SystemException {
		int count = countByDataImportDetailsOf(rootId);

		List<LmisDataImportDetails> list = findByDataImportDetailsOf(rootId,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisDataImportDetails exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisDataImportDetailsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisDataImportDetails[] findByDataImportDetailsOf_PrevAndNext(
		Integer lmisDataImportDetailsId, int rootId, OrderByComparator obc)
		throws NoSuchLmisDataImportDetailsException, SystemException {
		LmisDataImportDetails lmisDataImportDetails = findByPrimaryKey(lmisDataImportDetailsId);

		int count = countByDataImportDetailsOf(rootId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisDataImportDetails WHERE ");

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
					lmisDataImportDetails);

			LmisDataImportDetails[] array = new LmisDataImportDetailsImpl[3];

			array[0] = (LmisDataImportDetails)objArray[0];
			array[1] = (LmisDataImportDetails)objArray[1];
			array[2] = (LmisDataImportDetails)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisDataImportDetails> findByScannerID(String scannerId)
		throws SystemException {
		Object[] finderArgs = new Object[] { scannerId };

		List<LmisDataImportDetails> list = (List<LmisDataImportDetails>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_SCANNERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisDataImportDetails WHERE ");

				if (scannerId == null) {
					query.append("scanner_id IS NULL");
				}
				else {
					query.append("scanner_id = ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (scannerId != null) {
					qPos.add(scannerId);
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisDataImportDetails>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_SCANNERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisDataImportDetails> findByScannerID(String scannerId,
		int start, int end) throws SystemException {
		return findByScannerID(scannerId, start, end, null);
	}

	public List<LmisDataImportDetails> findByScannerID(String scannerId,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				scannerId,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisDataImportDetails> list = (List<LmisDataImportDetails>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_SCANNERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisDataImportDetails WHERE ");

				if (scannerId == null) {
					query.append("scanner_id IS NULL");
				}
				else {
					query.append("scanner_id = ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (scannerId != null) {
					qPos.add(scannerId);
				}

				list = (List<LmisDataImportDetails>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisDataImportDetails>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_SCANNERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisDataImportDetails findByScannerID_First(String scannerId,
		OrderByComparator obc)
		throws NoSuchLmisDataImportDetailsException, SystemException {
		List<LmisDataImportDetails> list = findByScannerID(scannerId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisDataImportDetails exists with the key {");

			msg.append("scannerId=" + scannerId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisDataImportDetailsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisDataImportDetails findByScannerID_Last(String scannerId,
		OrderByComparator obc)
		throws NoSuchLmisDataImportDetailsException, SystemException {
		int count = countByScannerID(scannerId);

		List<LmisDataImportDetails> list = findByScannerID(scannerId,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisDataImportDetails exists with the key {");

			msg.append("scannerId=" + scannerId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisDataImportDetailsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisDataImportDetails[] findByScannerID_PrevAndNext(
		Integer lmisDataImportDetailsId, String scannerId, OrderByComparator obc)
		throws NoSuchLmisDataImportDetailsException, SystemException {
		LmisDataImportDetails lmisDataImportDetails = findByPrimaryKey(lmisDataImportDetailsId);

		int count = countByScannerID(scannerId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisDataImportDetails WHERE ");

			if (scannerId == null) {
				query.append("scanner_id IS NULL");
			}
			else {
				query.append("scanner_id = ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (scannerId != null) {
				qPos.add(scannerId);
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisDataImportDetails);

			LmisDataImportDetails[] array = new LmisDataImportDetailsImpl[3];

			array[0] = (LmisDataImportDetails)objArray[0];
			array[1] = (LmisDataImportDetails)objArray[1];
			array[2] = (LmisDataImportDetails)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisDataImportDetails> findByImportID(int importId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(importId) };

		List<LmisDataImportDetails> list = (List<LmisDataImportDetails>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_IMPORTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisDataImportDetails WHERE ");

				query.append("import_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(importId);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisDataImportDetails>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_IMPORTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisDataImportDetails> findByImportID(int importId, int start,
		int end) throws SystemException {
		return findByImportID(importId, start, end, null);
	}

	public List<LmisDataImportDetails> findByImportID(int importId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(importId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisDataImportDetails> list = (List<LmisDataImportDetails>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_IMPORTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisDataImportDetails WHERE ");

				query.append("import_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(importId);

				list = (List<LmisDataImportDetails>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisDataImportDetails>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_IMPORTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisDataImportDetails findByImportID_First(int importId,
		OrderByComparator obc)
		throws NoSuchLmisDataImportDetailsException, SystemException {
		List<LmisDataImportDetails> list = findByImportID(importId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisDataImportDetails exists with the key {");

			msg.append("importId=" + importId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisDataImportDetailsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisDataImportDetails findByImportID_Last(int importId,
		OrderByComparator obc)
		throws NoSuchLmisDataImportDetailsException, SystemException {
		int count = countByImportID(importId);

		List<LmisDataImportDetails> list = findByImportID(importId, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisDataImportDetails exists with the key {");

			msg.append("importId=" + importId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisDataImportDetailsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisDataImportDetails[] findByImportID_PrevAndNext(
		Integer lmisDataImportDetailsId, int importId, OrderByComparator obc)
		throws NoSuchLmisDataImportDetailsException, SystemException {
		LmisDataImportDetails lmisDataImportDetails = findByPrimaryKey(lmisDataImportDetailsId);

		int count = countByImportID(importId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisDataImportDetails WHERE ");

			query.append("import_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(importId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisDataImportDetails);

			LmisDataImportDetails[] array = new LmisDataImportDetailsImpl[3];

			array[0] = (LmisDataImportDetails)objArray[0];
			array[1] = (LmisDataImportDetails)objArray[1];
			array[2] = (LmisDataImportDetails)objArray[2];

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

	public List<LmisDataImportDetails> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<LmisDataImportDetails> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<LmisDataImportDetails> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisDataImportDetails> list = (List<LmisDataImportDetails>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisDataImportDetails ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<LmisDataImportDetails>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LmisDataImportDetails>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisDataImportDetails>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByDataImportDetailsOf(int rootId)
		throws SystemException {
		for (LmisDataImportDetails lmisDataImportDetails : findByDataImportDetailsOf(
				rootId)) {
			remove(lmisDataImportDetails);
		}
	}

	public void removeByScannerID(String scannerId) throws SystemException {
		for (LmisDataImportDetails lmisDataImportDetails : findByScannerID(
				scannerId)) {
			remove(lmisDataImportDetails);
		}
	}

	public void removeByImportID(int importId) throws SystemException {
		for (LmisDataImportDetails lmisDataImportDetails : findByImportID(
				importId)) {
			remove(lmisDataImportDetails);
		}
	}

	public void removeAll() throws SystemException {
		for (LmisDataImportDetails lmisDataImportDetails : findAll()) {
			remove(lmisDataImportDetails);
		}
	}

	public int countByDataImportDetailsOf(int rootId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DATAIMPORTDETAILSOF,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisDataImportDetails WHERE ");

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DATAIMPORTDETAILSOF,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByScannerID(String scannerId) throws SystemException {
		Object[] finderArgs = new Object[] { scannerId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_SCANNERID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisDataImportDetails WHERE ");

				if (scannerId == null) {
					query.append("scanner_id IS NULL");
				}
				else {
					query.append("scanner_id = ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (scannerId != null) {
					qPos.add(scannerId);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SCANNERID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByImportID(int importId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(importId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_IMPORTID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisDataImportDetails WHERE ");

				query.append("import_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(importId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_IMPORTID,
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
						"SELECT COUNT(*) FROM larion.progate.lmis.model.LmisDataImportDetails");

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
						"value.object.listener.larion.progate.lmis.model.LmisDataImportDetails")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LmisDataImportDetails>> listenersList = new ArrayList<ModelListener<LmisDataImportDetails>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LmisDataImportDetails>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(LmisDataImportDetailsPersistenceImpl.class);
}