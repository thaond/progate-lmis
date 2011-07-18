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

import larion.progate.lmis.NoSuchLmisEmailSettingDetailsException;
import larion.progate.lmis.model.LmisEmailSettingDetails;
import larion.progate.lmis.model.impl.LmisEmailSettingDetailsImpl;
import larion.progate.lmis.model.impl.LmisEmailSettingDetailsModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="LmisEmailSettingDetailsPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisEmailSettingDetailsPersistenceImpl extends BasePersistenceImpl
	implements LmisEmailSettingDetailsPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = LmisEmailSettingDetailsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_EMAILID = new FinderPath(LmisEmailSettingDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LmisEmailSettingDetailsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByemailId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_EMAILID = new FinderPath(LmisEmailSettingDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LmisEmailSettingDetailsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByemailId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_EMAILID = new FinderPath(LmisEmailSettingDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LmisEmailSettingDetailsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByemailId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(LmisEmailSettingDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LmisEmailSettingDetailsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LmisEmailSettingDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LmisEmailSettingDetailsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(LmisEmailSettingDetails lmisEmailSettingDetails) {
		EntityCacheUtil.putResult(LmisEmailSettingDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LmisEmailSettingDetailsImpl.class,
			lmisEmailSettingDetails.getPrimaryKey(), lmisEmailSettingDetails);
	}

	public void cacheResult(
		List<LmisEmailSettingDetails> lmisEmailSettingDetailses) {
		for (LmisEmailSettingDetails lmisEmailSettingDetails : lmisEmailSettingDetailses) {
			if (EntityCacheUtil.getResult(
						LmisEmailSettingDetailsModelImpl.ENTITY_CACHE_ENABLED,
						LmisEmailSettingDetailsImpl.class,
						lmisEmailSettingDetails.getPrimaryKey(), this) == null) {
				cacheResult(lmisEmailSettingDetails);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(LmisEmailSettingDetailsImpl.class.getName());
		EntityCacheUtil.clearCache(LmisEmailSettingDetailsImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public LmisEmailSettingDetails create(Integer lmisEmailSettingDetailId) {
		LmisEmailSettingDetails lmisEmailSettingDetails = new LmisEmailSettingDetailsImpl();

		lmisEmailSettingDetails.setNew(true);
		lmisEmailSettingDetails.setPrimaryKey(lmisEmailSettingDetailId);

		return lmisEmailSettingDetails;
	}

	public LmisEmailSettingDetails remove(Integer lmisEmailSettingDetailId)
		throws NoSuchLmisEmailSettingDetailsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LmisEmailSettingDetails lmisEmailSettingDetails = (LmisEmailSettingDetails)session.get(LmisEmailSettingDetailsImpl.class,
					lmisEmailSettingDetailId);

			if (lmisEmailSettingDetails == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No LmisEmailSettingDetails exists with the primary key " +
						lmisEmailSettingDetailId);
				}

				throw new NoSuchLmisEmailSettingDetailsException(
					"No LmisEmailSettingDetails exists with the primary key " +
					lmisEmailSettingDetailId);
			}

			return remove(lmisEmailSettingDetails);
		}
		catch (NoSuchLmisEmailSettingDetailsException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public LmisEmailSettingDetails remove(
		LmisEmailSettingDetails lmisEmailSettingDetails)
		throws SystemException {
		for (ModelListener<LmisEmailSettingDetails> listener : listeners) {
			listener.onBeforeRemove(lmisEmailSettingDetails);
		}

		lmisEmailSettingDetails = removeImpl(lmisEmailSettingDetails);

		for (ModelListener<LmisEmailSettingDetails> listener : listeners) {
			listener.onAfterRemove(lmisEmailSettingDetails);
		}

		return lmisEmailSettingDetails;
	}

	protected LmisEmailSettingDetails removeImpl(
		LmisEmailSettingDetails lmisEmailSettingDetails)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (lmisEmailSettingDetails.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(LmisEmailSettingDetailsImpl.class,
						lmisEmailSettingDetails.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(lmisEmailSettingDetails);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(LmisEmailSettingDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LmisEmailSettingDetailsImpl.class,
			lmisEmailSettingDetails.getPrimaryKey());

		return lmisEmailSettingDetails;
	}

	public LmisEmailSettingDetails update(
		LmisEmailSettingDetails lmisEmailSettingDetails)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(LmisEmailSettingDetails lmisEmailSettingDetails) method. Use update(LmisEmailSettingDetails lmisEmailSettingDetails, boolean merge) instead.");
		}

		return update(lmisEmailSettingDetails, false);
	}

	public LmisEmailSettingDetails update(
		LmisEmailSettingDetails lmisEmailSettingDetails, boolean merge)
		throws SystemException {
		boolean isNew = lmisEmailSettingDetails.isNew();

		for (ModelListener<LmisEmailSettingDetails> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(lmisEmailSettingDetails);
			}
			else {
				listener.onBeforeUpdate(lmisEmailSettingDetails);
			}
		}

		lmisEmailSettingDetails = updateImpl(lmisEmailSettingDetails, merge);

		for (ModelListener<LmisEmailSettingDetails> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(lmisEmailSettingDetails);
			}
			else {
				listener.onAfterUpdate(lmisEmailSettingDetails);
			}
		}

		return lmisEmailSettingDetails;
	}

	public LmisEmailSettingDetails updateImpl(
		larion.progate.lmis.model.LmisEmailSettingDetails lmisEmailSettingDetails,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, lmisEmailSettingDetails, merge);

			lmisEmailSettingDetails.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(LmisEmailSettingDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LmisEmailSettingDetailsImpl.class,
			lmisEmailSettingDetails.getPrimaryKey(), lmisEmailSettingDetails);

		return lmisEmailSettingDetails;
	}

	public LmisEmailSettingDetails findByPrimaryKey(
		Integer lmisEmailSettingDetailId)
		throws NoSuchLmisEmailSettingDetailsException, SystemException {
		LmisEmailSettingDetails lmisEmailSettingDetails = fetchByPrimaryKey(lmisEmailSettingDetailId);

		if (lmisEmailSettingDetails == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"No LmisEmailSettingDetails exists with the primary key " +
					lmisEmailSettingDetailId);
			}

			throw new NoSuchLmisEmailSettingDetailsException(
				"No LmisEmailSettingDetails exists with the primary key " +
				lmisEmailSettingDetailId);
		}

		return lmisEmailSettingDetails;
	}

	public LmisEmailSettingDetails fetchByPrimaryKey(
		Integer lmisEmailSettingDetailId) throws SystemException {
		LmisEmailSettingDetails lmisEmailSettingDetails = (LmisEmailSettingDetails)EntityCacheUtil.getResult(LmisEmailSettingDetailsModelImpl.ENTITY_CACHE_ENABLED,
				LmisEmailSettingDetailsImpl.class, lmisEmailSettingDetailId,
				this);

		if (lmisEmailSettingDetails == null) {
			Session session = null;

			try {
				session = openSession();

				lmisEmailSettingDetails = (LmisEmailSettingDetails)session.get(LmisEmailSettingDetailsImpl.class,
						lmisEmailSettingDetailId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (lmisEmailSettingDetails != null) {
					cacheResult(lmisEmailSettingDetails);
				}

				closeSession(session);
			}
		}

		return lmisEmailSettingDetails;
	}

	public List<LmisEmailSettingDetails> findByemailId(int emailSettingId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(emailSettingId) };

		List<LmisEmailSettingDetails> list = (List<LmisEmailSettingDetails>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_EMAILID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisEmailSettingDetails WHERE ");

				query.append("email_setting_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(emailSettingId);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisEmailSettingDetails>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_EMAILID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisEmailSettingDetails> findByemailId(int emailSettingId,
		int start, int end) throws SystemException {
		return findByemailId(emailSettingId, start, end, null);
	}

	public List<LmisEmailSettingDetails> findByemailId(int emailSettingId,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(emailSettingId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisEmailSettingDetails> list = (List<LmisEmailSettingDetails>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_EMAILID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisEmailSettingDetails WHERE ");

				query.append("email_setting_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(emailSettingId);

				list = (List<LmisEmailSettingDetails>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisEmailSettingDetails>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_EMAILID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisEmailSettingDetails findByemailId_First(int emailSettingId,
		OrderByComparator obc)
		throws NoSuchLmisEmailSettingDetailsException, SystemException {
		List<LmisEmailSettingDetails> list = findByemailId(emailSettingId, 0,
				1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisEmailSettingDetails exists with the key {");

			msg.append("emailSettingId=" + emailSettingId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisEmailSettingDetailsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisEmailSettingDetails findByemailId_Last(int emailSettingId,
		OrderByComparator obc)
		throws NoSuchLmisEmailSettingDetailsException, SystemException {
		int count = countByemailId(emailSettingId);

		List<LmisEmailSettingDetails> list = findByemailId(emailSettingId,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisEmailSettingDetails exists with the key {");

			msg.append("emailSettingId=" + emailSettingId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisEmailSettingDetailsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisEmailSettingDetails[] findByemailId_PrevAndNext(
		Integer lmisEmailSettingDetailId, int emailSettingId,
		OrderByComparator obc)
		throws NoSuchLmisEmailSettingDetailsException, SystemException {
		LmisEmailSettingDetails lmisEmailSettingDetails = findByPrimaryKey(lmisEmailSettingDetailId);

		int count = countByemailId(emailSettingId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisEmailSettingDetails WHERE ");

			query.append("email_setting_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(emailSettingId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisEmailSettingDetails);

			LmisEmailSettingDetails[] array = new LmisEmailSettingDetailsImpl[3];

			array[0] = (LmisEmailSettingDetails)objArray[0];
			array[1] = (LmisEmailSettingDetails)objArray[1];
			array[2] = (LmisEmailSettingDetails)objArray[2];

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

	public List<LmisEmailSettingDetails> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<LmisEmailSettingDetails> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<LmisEmailSettingDetails> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisEmailSettingDetails> list = (List<LmisEmailSettingDetails>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisEmailSettingDetails ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<LmisEmailSettingDetails>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LmisEmailSettingDetails>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisEmailSettingDetails>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByemailId(int emailSettingId) throws SystemException {
		for (LmisEmailSettingDetails lmisEmailSettingDetails : findByemailId(
				emailSettingId)) {
			remove(lmisEmailSettingDetails);
		}
	}

	public void removeAll() throws SystemException {
		for (LmisEmailSettingDetails lmisEmailSettingDetails : findAll()) {
			remove(lmisEmailSettingDetails);
		}
	}

	public int countByemailId(int emailSettingId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(emailSettingId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_EMAILID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisEmailSettingDetails WHERE ");

				query.append("email_setting_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(emailSettingId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMAILID,
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
						"SELECT COUNT(*) FROM larion.progate.lmis.model.LmisEmailSettingDetails");

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
						"value.object.listener.larion.progate.lmis.model.LmisEmailSettingDetails")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LmisEmailSettingDetails>> listenersList = new ArrayList<ModelListener<LmisEmailSettingDetails>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LmisEmailSettingDetails>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(LmisEmailSettingDetailsPersistenceImpl.class);
}