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
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import larion.progate.lmis.NoSuchLmisViewOTAppException;
import larion.progate.lmis.model.LmisViewOTApp;
import larion.progate.lmis.model.impl.LmisViewOTAppImpl;
import larion.progate.lmis.model.impl.LmisViewOTAppModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * <a href="LmisViewOTAppPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewOTAppPersistenceImpl extends BasePersistenceImpl
	implements LmisViewOTAppPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = LmisViewOTAppImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_ROOTID = new FinderPath(LmisViewOTAppModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewOTAppModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ROOTID = new FinderPath(LmisViewOTAppModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewOTAppModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ROOTID = new FinderPath(LmisViewOTAppModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewOTAppModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByRootID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ORGID = new FinderPath(LmisViewOTAppModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewOTAppModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOrgID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ORGID = new FinderPath(LmisViewOTAppModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewOTAppModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOrgID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGID = new FinderPath(LmisViewOTAppModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewOTAppModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByOrgID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_REQUESTEDAT = new FinderPath(LmisViewOTAppModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewOTAppModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRequestedAt",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_REQUESTEDAT = new FinderPath(LmisViewOTAppModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewOTAppModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRequestedAt",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_REQUESTEDAT = new FinderPath(LmisViewOTAppModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewOTAppModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByRequestedAt",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_REQUESTEDSTATUS = new FinderPath(LmisViewOTAppModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewOTAppModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRequestedStatus",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_REQUESTEDSTATUS = new FinderPath(LmisViewOTAppModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewOTAppModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRequestedStatus",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_REQUESTEDSTATUS = new FinderPath(LmisViewOTAppModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewOTAppModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByRequestedStatus",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_REQUESTEDBY = new FinderPath(LmisViewOTAppModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewOTAppModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRequestedBy",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_REQUESTEDBY = new FinderPath(LmisViewOTAppModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewOTAppModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRequestedBy",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_REQUESTEDBY = new FinderPath(LmisViewOTAppModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewOTAppModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByRequestedBy",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_APPROVEDBY = new FinderPath(LmisViewOTAppModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewOTAppModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByApprovedBy",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_APPROVEDBY = new FinderPath(LmisViewOTAppModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewOTAppModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByApprovedBy",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_APPROVEDBY = new FinderPath(LmisViewOTAppModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewOTAppModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByApprovedBy",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(LmisViewOTAppModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewOTAppModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LmisViewOTAppModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewOTAppModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(LmisViewOTApp lmisViewOTApp) {
		EntityCacheUtil.putResult(LmisViewOTAppModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewOTAppImpl.class, lmisViewOTApp.getPrimaryKey(),
			lmisViewOTApp);
	}

	public void cacheResult(List<LmisViewOTApp> lmisViewOTApps) {
		for (LmisViewOTApp lmisViewOTApp : lmisViewOTApps) {
			if (EntityCacheUtil.getResult(
						LmisViewOTAppModelImpl.ENTITY_CACHE_ENABLED,
						LmisViewOTAppImpl.class, lmisViewOTApp.getPrimaryKey(),
						this) == null) {
				cacheResult(lmisViewOTApp);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(LmisViewOTAppImpl.class.getName());
		EntityCacheUtil.clearCache(LmisViewOTAppImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public LmisViewOTApp create(Integer lmisViewOTAppId) {
		LmisViewOTApp lmisViewOTApp = new LmisViewOTAppImpl();

		lmisViewOTApp.setNew(true);
		lmisViewOTApp.setPrimaryKey(lmisViewOTAppId);

		return lmisViewOTApp;
	}

	public LmisViewOTApp remove(Integer lmisViewOTAppId)
		throws NoSuchLmisViewOTAppException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LmisViewOTApp lmisViewOTApp = (LmisViewOTApp)session.get(LmisViewOTAppImpl.class,
					lmisViewOTAppId);

			if (lmisViewOTApp == null) {
				if (_log.isWarnEnabled()) {
					_log.warn("No LmisViewOTApp exists with the primary key " +
						lmisViewOTAppId);
				}

				throw new NoSuchLmisViewOTAppException(
					"No LmisViewOTApp exists with the primary key " +
					lmisViewOTAppId);
			}

			return remove(lmisViewOTApp);
		}
		catch (NoSuchLmisViewOTAppException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public LmisViewOTApp remove(LmisViewOTApp lmisViewOTApp)
		throws SystemException {
		for (ModelListener<LmisViewOTApp> listener : listeners) {
			listener.onBeforeRemove(lmisViewOTApp);
		}

		lmisViewOTApp = removeImpl(lmisViewOTApp);

		for (ModelListener<LmisViewOTApp> listener : listeners) {
			listener.onAfterRemove(lmisViewOTApp);
		}

		return lmisViewOTApp;
	}

	protected LmisViewOTApp removeImpl(LmisViewOTApp lmisViewOTApp)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (lmisViewOTApp.isCachedModel() || BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(LmisViewOTAppImpl.class,
						lmisViewOTApp.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(lmisViewOTApp);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(LmisViewOTAppModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewOTAppImpl.class, lmisViewOTApp.getPrimaryKey());

		return lmisViewOTApp;
	}

	public LmisViewOTApp update(LmisViewOTApp lmisViewOTApp)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(LmisViewOTApp lmisViewOTApp) method. Use update(LmisViewOTApp lmisViewOTApp, boolean merge) instead.");
		}

		return update(lmisViewOTApp, false);
	}

	public LmisViewOTApp update(LmisViewOTApp lmisViewOTApp, boolean merge)
		throws SystemException {
		boolean isNew = lmisViewOTApp.isNew();

		for (ModelListener<LmisViewOTApp> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(lmisViewOTApp);
			}
			else {
				listener.onBeforeUpdate(lmisViewOTApp);
			}
		}

		lmisViewOTApp = updateImpl(lmisViewOTApp, merge);

		for (ModelListener<LmisViewOTApp> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(lmisViewOTApp);
			}
			else {
				listener.onAfterUpdate(lmisViewOTApp);
			}
		}

		return lmisViewOTApp;
	}

	public LmisViewOTApp updateImpl(
		larion.progate.lmis.model.LmisViewOTApp lmisViewOTApp, boolean merge)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, lmisViewOTApp, merge);

			lmisViewOTApp.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(LmisViewOTAppModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewOTAppImpl.class, lmisViewOTApp.getPrimaryKey(),
			lmisViewOTApp);

		return lmisViewOTApp;
	}

	public LmisViewOTApp findByPrimaryKey(Integer lmisViewOTAppId)
		throws NoSuchLmisViewOTAppException, SystemException {
		LmisViewOTApp lmisViewOTApp = fetchByPrimaryKey(lmisViewOTAppId);

		if (lmisViewOTApp == null) {
			if (_log.isWarnEnabled()) {
				_log.warn("No LmisViewOTApp exists with the primary key " +
					lmisViewOTAppId);
			}

			throw new NoSuchLmisViewOTAppException(
				"No LmisViewOTApp exists with the primary key " +
				lmisViewOTAppId);
		}

		return lmisViewOTApp;
	}

	public LmisViewOTApp fetchByPrimaryKey(Integer lmisViewOTAppId)
		throws SystemException {
		LmisViewOTApp lmisViewOTApp = (LmisViewOTApp)EntityCacheUtil.getResult(LmisViewOTAppModelImpl.ENTITY_CACHE_ENABLED,
				LmisViewOTAppImpl.class, lmisViewOTAppId, this);

		if (lmisViewOTApp == null) {
			Session session = null;

			try {
				session = openSession();

				lmisViewOTApp = (LmisViewOTApp)session.get(LmisViewOTAppImpl.class,
						lmisViewOTAppId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (lmisViewOTApp != null) {
					cacheResult(lmisViewOTApp);
				}

				closeSession(session);
			}
		}

		return lmisViewOTApp;
	}

	public List<LmisViewOTApp> findByRootID(int rootId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		List<LmisViewOTApp> list = (List<LmisViewOTApp>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewOTApp WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("requested_status ASC, ");
				query.append("updated_at DESC");

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
					list = new ArrayList<LmisViewOTApp>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewOTApp> findByRootID(int rootId, int start, int end)
		throws SystemException {
		return findByRootID(rootId, start, end, null);
	}

	public List<LmisViewOTApp> findByRootID(int rootId, int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(rootId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewOTApp> list = (List<LmisViewOTApp>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewOTApp WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("requested_status ASC, ");
					query.append("updated_at DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rootId);

				list = (List<LmisViewOTApp>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewOTApp>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewOTApp findByRootID_First(int rootId, OrderByComparator obc)
		throws NoSuchLmisViewOTAppException, SystemException {
		List<LmisViewOTApp> list = findByRootID(rootId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewOTApp exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewOTAppException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewOTApp findByRootID_Last(int rootId, OrderByComparator obc)
		throws NoSuchLmisViewOTAppException, SystemException {
		int count = countByRootID(rootId);

		List<LmisViewOTApp> list = findByRootID(rootId, count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewOTApp exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewOTAppException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewOTApp[] findByRootID_PrevAndNext(Integer lmisViewOTAppId,
		int rootId, OrderByComparator obc)
		throws NoSuchLmisViewOTAppException, SystemException {
		LmisViewOTApp lmisViewOTApp = findByPrimaryKey(lmisViewOTAppId);

		int count = countByRootID(rootId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.lmis.model.LmisViewOTApp WHERE ");

			query.append("root_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("requested_status ASC, ");
				query.append("updated_at DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(rootId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisViewOTApp);

			LmisViewOTApp[] array = new LmisViewOTAppImpl[3];

			array[0] = (LmisViewOTApp)objArray[0];
			array[1] = (LmisViewOTApp)objArray[1];
			array[2] = (LmisViewOTApp)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewOTApp> findByOrgID(int orgId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(orgId) };

		List<LmisViewOTApp> list = (List<LmisViewOTApp>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ORGID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewOTApp WHERE ");

				query.append("org_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("requested_status ASC, ");
				query.append("updated_at DESC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orgId);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewOTApp>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ORGID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewOTApp> findByOrgID(int orgId, int start, int end)
		throws SystemException {
		return findByOrgID(orgId, start, end, null);
	}

	public List<LmisViewOTApp> findByOrgID(int orgId, int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(orgId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewOTApp> list = (List<LmisViewOTApp>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ORGID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewOTApp WHERE ");

				query.append("org_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("requested_status ASC, ");
					query.append("updated_at DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orgId);

				list = (List<LmisViewOTApp>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewOTApp>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ORGID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewOTApp findByOrgID_First(int orgId, OrderByComparator obc)
		throws NoSuchLmisViewOTAppException, SystemException {
		List<LmisViewOTApp> list = findByOrgID(orgId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewOTApp exists with the key {");

			msg.append("orgId=" + orgId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewOTAppException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewOTApp findByOrgID_Last(int orgId, OrderByComparator obc)
		throws NoSuchLmisViewOTAppException, SystemException {
		int count = countByOrgID(orgId);

		List<LmisViewOTApp> list = findByOrgID(orgId, count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewOTApp exists with the key {");

			msg.append("orgId=" + orgId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewOTAppException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewOTApp[] findByOrgID_PrevAndNext(Integer lmisViewOTAppId,
		int orgId, OrderByComparator obc)
		throws NoSuchLmisViewOTAppException, SystemException {
		LmisViewOTApp lmisViewOTApp = findByPrimaryKey(lmisViewOTAppId);

		int count = countByOrgID(orgId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.lmis.model.LmisViewOTApp WHERE ");

			query.append("org_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("requested_status ASC, ");
				query.append("updated_at DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(orgId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisViewOTApp);

			LmisViewOTApp[] array = new LmisViewOTAppImpl[3];

			array[0] = (LmisViewOTApp)objArray[0];
			array[1] = (LmisViewOTApp)objArray[1];
			array[2] = (LmisViewOTApp)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewOTApp> findByRequestedAt(Date requestedAt)
		throws SystemException {
		Object[] finderArgs = new Object[] { requestedAt };

		List<LmisViewOTApp> list = (List<LmisViewOTApp>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_REQUESTEDAT,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewOTApp WHERE ");

				if (requestedAt == null) {
					query.append("requested_at IS NULL");
				}
				else {
					query.append("requested_at = ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("requested_status ASC, ");
				query.append("updated_at DESC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (requestedAt != null) {
					qPos.add(CalendarUtil.getTimestamp(requestedAt));
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewOTApp>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_REQUESTEDAT,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewOTApp> findByRequestedAt(Date requestedAt, int start,
		int end) throws SystemException {
		return findByRequestedAt(requestedAt, start, end, null);
	}

	public List<LmisViewOTApp> findByRequestedAt(Date requestedAt, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				requestedAt,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewOTApp> list = (List<LmisViewOTApp>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_REQUESTEDAT,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewOTApp WHERE ");

				if (requestedAt == null) {
					query.append("requested_at IS NULL");
				}
				else {
					query.append("requested_at = ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("requested_status ASC, ");
					query.append("updated_at DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (requestedAt != null) {
					qPos.add(CalendarUtil.getTimestamp(requestedAt));
				}

				list = (List<LmisViewOTApp>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewOTApp>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_REQUESTEDAT,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewOTApp findByRequestedAt_First(Date requestedAt,
		OrderByComparator obc)
		throws NoSuchLmisViewOTAppException, SystemException {
		List<LmisViewOTApp> list = findByRequestedAt(requestedAt, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewOTApp exists with the key {");

			msg.append("requestedAt=" + requestedAt);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewOTAppException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewOTApp findByRequestedAt_Last(Date requestedAt,
		OrderByComparator obc)
		throws NoSuchLmisViewOTAppException, SystemException {
		int count = countByRequestedAt(requestedAt);

		List<LmisViewOTApp> list = findByRequestedAt(requestedAt, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewOTApp exists with the key {");

			msg.append("requestedAt=" + requestedAt);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewOTAppException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewOTApp[] findByRequestedAt_PrevAndNext(
		Integer lmisViewOTAppId, Date requestedAt, OrderByComparator obc)
		throws NoSuchLmisViewOTAppException, SystemException {
		LmisViewOTApp lmisViewOTApp = findByPrimaryKey(lmisViewOTAppId);

		int count = countByRequestedAt(requestedAt);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.lmis.model.LmisViewOTApp WHERE ");

			if (requestedAt == null) {
				query.append("requested_at IS NULL");
			}
			else {
				query.append("requested_at = ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("requested_status ASC, ");
				query.append("updated_at DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (requestedAt != null) {
				qPos.add(CalendarUtil.getTimestamp(requestedAt));
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisViewOTApp);

			LmisViewOTApp[] array = new LmisViewOTAppImpl[3];

			array[0] = (LmisViewOTApp)objArray[0];
			array[1] = (LmisViewOTApp)objArray[1];
			array[2] = (LmisViewOTApp)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewOTApp> findByRequestedStatus(int requestedStatus)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(requestedStatus) };

		List<LmisViewOTApp> list = (List<LmisViewOTApp>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_REQUESTEDSTATUS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewOTApp WHERE ");

				query.append("requested_status = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("requested_status ASC, ");
				query.append("updated_at DESC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(requestedStatus);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewOTApp>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_REQUESTEDSTATUS,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewOTApp> findByRequestedStatus(int requestedStatus,
		int start, int end) throws SystemException {
		return findByRequestedStatus(requestedStatus, start, end, null);
	}

	public List<LmisViewOTApp> findByRequestedStatus(int requestedStatus,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(requestedStatus),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewOTApp> list = (List<LmisViewOTApp>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_REQUESTEDSTATUS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewOTApp WHERE ");

				query.append("requested_status = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("requested_status ASC, ");
					query.append("updated_at DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(requestedStatus);

				list = (List<LmisViewOTApp>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewOTApp>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_REQUESTEDSTATUS,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewOTApp findByRequestedStatus_First(int requestedStatus,
		OrderByComparator obc)
		throws NoSuchLmisViewOTAppException, SystemException {
		List<LmisViewOTApp> list = findByRequestedStatus(requestedStatus, 0, 1,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewOTApp exists with the key {");

			msg.append("requestedStatus=" + requestedStatus);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewOTAppException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewOTApp findByRequestedStatus_Last(int requestedStatus,
		OrderByComparator obc)
		throws NoSuchLmisViewOTAppException, SystemException {
		int count = countByRequestedStatus(requestedStatus);

		List<LmisViewOTApp> list = findByRequestedStatus(requestedStatus,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewOTApp exists with the key {");

			msg.append("requestedStatus=" + requestedStatus);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewOTAppException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewOTApp[] findByRequestedStatus_PrevAndNext(
		Integer lmisViewOTAppId, int requestedStatus, OrderByComparator obc)
		throws NoSuchLmisViewOTAppException, SystemException {
		LmisViewOTApp lmisViewOTApp = findByPrimaryKey(lmisViewOTAppId);

		int count = countByRequestedStatus(requestedStatus);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.lmis.model.LmisViewOTApp WHERE ");

			query.append("requested_status = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("requested_status ASC, ");
				query.append("updated_at DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(requestedStatus);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisViewOTApp);

			LmisViewOTApp[] array = new LmisViewOTAppImpl[3];

			array[0] = (LmisViewOTApp)objArray[0];
			array[1] = (LmisViewOTApp)objArray[1];
			array[2] = (LmisViewOTApp)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewOTApp> findByRequestedBy(int requestedBy)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(requestedBy) };

		List<LmisViewOTApp> list = (List<LmisViewOTApp>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_REQUESTEDBY,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewOTApp WHERE ");

				query.append("requested_by = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("requested_status ASC, ");
				query.append("updated_at DESC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(requestedBy);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewOTApp>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_REQUESTEDBY,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewOTApp> findByRequestedBy(int requestedBy, int start,
		int end) throws SystemException {
		return findByRequestedBy(requestedBy, start, end, null);
	}

	public List<LmisViewOTApp> findByRequestedBy(int requestedBy, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(requestedBy),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewOTApp> list = (List<LmisViewOTApp>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_REQUESTEDBY,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewOTApp WHERE ");

				query.append("requested_by = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("requested_status ASC, ");
					query.append("updated_at DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(requestedBy);

				list = (List<LmisViewOTApp>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewOTApp>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_REQUESTEDBY,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewOTApp findByRequestedBy_First(int requestedBy,
		OrderByComparator obc)
		throws NoSuchLmisViewOTAppException, SystemException {
		List<LmisViewOTApp> list = findByRequestedBy(requestedBy, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewOTApp exists with the key {");

			msg.append("requestedBy=" + requestedBy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewOTAppException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewOTApp findByRequestedBy_Last(int requestedBy,
		OrderByComparator obc)
		throws NoSuchLmisViewOTAppException, SystemException {
		int count = countByRequestedBy(requestedBy);

		List<LmisViewOTApp> list = findByRequestedBy(requestedBy, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewOTApp exists with the key {");

			msg.append("requestedBy=" + requestedBy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewOTAppException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewOTApp[] findByRequestedBy_PrevAndNext(
		Integer lmisViewOTAppId, int requestedBy, OrderByComparator obc)
		throws NoSuchLmisViewOTAppException, SystemException {
		LmisViewOTApp lmisViewOTApp = findByPrimaryKey(lmisViewOTAppId);

		int count = countByRequestedBy(requestedBy);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.lmis.model.LmisViewOTApp WHERE ");

			query.append("requested_by = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("requested_status ASC, ");
				query.append("updated_at DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(requestedBy);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisViewOTApp);

			LmisViewOTApp[] array = new LmisViewOTAppImpl[3];

			array[0] = (LmisViewOTApp)objArray[0];
			array[1] = (LmisViewOTApp)objArray[1];
			array[2] = (LmisViewOTApp)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewOTApp> findByApprovedBy(int approvedBy)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(approvedBy) };

		List<LmisViewOTApp> list = (List<LmisViewOTApp>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_APPROVEDBY,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewOTApp WHERE ");

				query.append("approved_by = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("requested_status ASC, ");
				query.append("updated_at DESC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(approvedBy);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewOTApp>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_APPROVEDBY,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewOTApp> findByApprovedBy(int approvedBy, int start,
		int end) throws SystemException {
		return findByApprovedBy(approvedBy, start, end, null);
	}

	public List<LmisViewOTApp> findByApprovedBy(int approvedBy, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(approvedBy),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewOTApp> list = (List<LmisViewOTApp>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_APPROVEDBY,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewOTApp WHERE ");

				query.append("approved_by = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("requested_status ASC, ");
					query.append("updated_at DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(approvedBy);

				list = (List<LmisViewOTApp>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewOTApp>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_APPROVEDBY,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewOTApp findByApprovedBy_First(int approvedBy,
		OrderByComparator obc)
		throws NoSuchLmisViewOTAppException, SystemException {
		List<LmisViewOTApp> list = findByApprovedBy(approvedBy, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewOTApp exists with the key {");

			msg.append("approvedBy=" + approvedBy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewOTAppException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewOTApp findByApprovedBy_Last(int approvedBy,
		OrderByComparator obc)
		throws NoSuchLmisViewOTAppException, SystemException {
		int count = countByApprovedBy(approvedBy);

		List<LmisViewOTApp> list = findByApprovedBy(approvedBy, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewOTApp exists with the key {");

			msg.append("approvedBy=" + approvedBy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewOTAppException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewOTApp[] findByApprovedBy_PrevAndNext(
		Integer lmisViewOTAppId, int approvedBy, OrderByComparator obc)
		throws NoSuchLmisViewOTAppException, SystemException {
		LmisViewOTApp lmisViewOTApp = findByPrimaryKey(lmisViewOTAppId);

		int count = countByApprovedBy(approvedBy);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.lmis.model.LmisViewOTApp WHERE ");

			query.append("approved_by = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("requested_status ASC, ");
				query.append("updated_at DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(approvedBy);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisViewOTApp);

			LmisViewOTApp[] array = new LmisViewOTAppImpl[3];

			array[0] = (LmisViewOTApp)objArray[0];
			array[1] = (LmisViewOTApp)objArray[1];
			array[2] = (LmisViewOTApp)objArray[2];

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

	public List<LmisViewOTApp> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<LmisViewOTApp> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<LmisViewOTApp> findAll(int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewOTApp> list = (List<LmisViewOTApp>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.lmis.model.LmisViewOTApp ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("requested_status ASC, ");
					query.append("updated_at DESC");
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<LmisViewOTApp>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LmisViewOTApp>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewOTApp>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByRootID(int rootId) throws SystemException {
		for (LmisViewOTApp lmisViewOTApp : findByRootID(rootId)) {
			remove(lmisViewOTApp);
		}
	}

	public void removeByOrgID(int orgId) throws SystemException {
		for (LmisViewOTApp lmisViewOTApp : findByOrgID(orgId)) {
			remove(lmisViewOTApp);
		}
	}

	public void removeByRequestedAt(Date requestedAt) throws SystemException {
		for (LmisViewOTApp lmisViewOTApp : findByRequestedAt(requestedAt)) {
			remove(lmisViewOTApp);
		}
	}

	public void removeByRequestedStatus(int requestedStatus)
		throws SystemException {
		for (LmisViewOTApp lmisViewOTApp : findByRequestedStatus(
				requestedStatus)) {
			remove(lmisViewOTApp);
		}
	}

	public void removeByRequestedBy(int requestedBy) throws SystemException {
		for (LmisViewOTApp lmisViewOTApp : findByRequestedBy(requestedBy)) {
			remove(lmisViewOTApp);
		}
	}

	public void removeByApprovedBy(int approvedBy) throws SystemException {
		for (LmisViewOTApp lmisViewOTApp : findByApprovedBy(approvedBy)) {
			remove(lmisViewOTApp);
		}
	}

	public void removeAll() throws SystemException {
		for (LmisViewOTApp lmisViewOTApp : findAll()) {
			remove(lmisViewOTApp);
		}
	}

	public int countByRootID(int rootId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ROOTID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisViewOTApp WHERE ");

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ROOTID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByOrgID(int orgId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(orgId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ORGID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisViewOTApp WHERE ");

				query.append("org_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orgId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ORGID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByRequestedAt(Date requestedAt) throws SystemException {
		Object[] finderArgs = new Object[] { requestedAt };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_REQUESTEDAT,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisViewOTApp WHERE ");

				if (requestedAt == null) {
					query.append("requested_at IS NULL");
				}
				else {
					query.append("requested_at = ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (requestedAt != null) {
					qPos.add(CalendarUtil.getTimestamp(requestedAt));
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_REQUESTEDAT,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByRequestedStatus(int requestedStatus)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(requestedStatus) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_REQUESTEDSTATUS,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisViewOTApp WHERE ");

				query.append("requested_status = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(requestedStatus);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_REQUESTEDSTATUS,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByRequestedBy(int requestedBy) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(requestedBy) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_REQUESTEDBY,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisViewOTApp WHERE ");

				query.append("requested_by = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(requestedBy);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_REQUESTEDBY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByApprovedBy(int approvedBy) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(approvedBy) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_APPROVEDBY,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisViewOTApp WHERE ");

				query.append("approved_by = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(approvedBy);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_APPROVEDBY,
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
						"SELECT COUNT(*) FROM larion.progate.lmis.model.LmisViewOTApp");

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
						"value.object.listener.larion.progate.lmis.model.LmisViewOTApp")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LmisViewOTApp>> listenersList = new ArrayList<ModelListener<LmisViewOTApp>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LmisViewOTApp>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(LmisViewOTAppPersistenceImpl.class);
}