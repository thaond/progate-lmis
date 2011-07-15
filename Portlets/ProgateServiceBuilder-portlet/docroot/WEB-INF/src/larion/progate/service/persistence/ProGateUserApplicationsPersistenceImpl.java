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

package larion.progate.service.persistence;

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

import larion.progate.NoSuchProGateUserApplicationsException;

import larion.progate.model.ProGateUserApplications;
import larion.progate.model.impl.ProGateUserApplicationsImpl;
import larion.progate.model.impl.ProGateUserApplicationsModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="ProGateUserApplicationsPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateUserApplicationsPersistenceImpl extends BasePersistenceImpl
	implements ProGateUserApplicationsPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = ProGateUserApplicationsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_USERID = new FinderPath(ProGateUserApplicationsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateUserApplicationsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByuserId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_USERID = new FinderPath(ProGateUserApplicationsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateUserApplicationsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByuserId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(ProGateUserApplicationsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateUserApplicationsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByuserId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ORGID = new FinderPath(ProGateUserApplicationsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateUserApplicationsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByorgId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ORGID = new FinderPath(ProGateUserApplicationsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateUserApplicationsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByorgId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGID = new FinderPath(ProGateUserApplicationsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateUserApplicationsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByorgId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_APPSID = new FinderPath(ProGateUserApplicationsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateUserApplicationsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByappsId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_APPSID = new FinderPath(ProGateUserApplicationsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateUserApplicationsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByappsId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_APPSID = new FinderPath(ProGateUserApplicationsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateUserApplicationsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByappsId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_INDEXEQUAL = new FinderPath(ProGateUserApplicationsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateUserApplicationsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByindexEqual",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_INDEXEQUAL = new FinderPath(ProGateUserApplicationsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateUserApplicationsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByindexEqual",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_INDEXEQUAL = new FinderPath(ProGateUserApplicationsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateUserApplicationsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByindexEqual",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_INDEXGREATER = new FinderPath(ProGateUserApplicationsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateUserApplicationsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByindexGreater",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_INDEXGREATER = new FinderPath(ProGateUserApplicationsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateUserApplicationsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByindexGreater",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_INDEXGREATER = new FinderPath(ProGateUserApplicationsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateUserApplicationsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByindexGreater",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_INDEXLOWER = new FinderPath(ProGateUserApplicationsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateUserApplicationsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByindexLower",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_INDEXLOWER = new FinderPath(ProGateUserApplicationsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateUserApplicationsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByindexLower",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_INDEXLOWER = new FinderPath(ProGateUserApplicationsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateUserApplicationsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByindexLower",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(ProGateUserApplicationsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateUserApplicationsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProGateUserApplicationsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateUserApplicationsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(ProGateUserApplications proGateUserApplications) {
		EntityCacheUtil.putResult(ProGateUserApplicationsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateUserApplicationsImpl.class,
			proGateUserApplications.getPrimaryKey(), proGateUserApplications);
	}

	public void cacheResult(
		List<ProGateUserApplications> proGateUserApplicationses) {
		for (ProGateUserApplications proGateUserApplications : proGateUserApplicationses) {
			if (EntityCacheUtil.getResult(
						ProGateUserApplicationsModelImpl.ENTITY_CACHE_ENABLED,
						ProGateUserApplicationsImpl.class,
						proGateUserApplications.getPrimaryKey(), this) == null) {
				cacheResult(proGateUserApplications);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(ProGateUserApplicationsImpl.class.getName());
		EntityCacheUtil.clearCache(ProGateUserApplicationsImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public ProGateUserApplications create(Integer ProGateUserApplicationsId) {
		ProGateUserApplications proGateUserApplications = new ProGateUserApplicationsImpl();

		proGateUserApplications.setNew(true);
		proGateUserApplications.setPrimaryKey(ProGateUserApplicationsId);

		return proGateUserApplications;
	}

	public ProGateUserApplications remove(Integer ProGateUserApplicationsId)
		throws NoSuchProGateUserApplicationsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ProGateUserApplications proGateUserApplications = (ProGateUserApplications)session.get(ProGateUserApplicationsImpl.class,
					ProGateUserApplicationsId);

			if (proGateUserApplications == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No ProGateUserApplications exists with the primary key " +
						ProGateUserApplicationsId);
				}

				throw new NoSuchProGateUserApplicationsException(
					"No ProGateUserApplications exists with the primary key " +
					ProGateUserApplicationsId);
			}

			return remove(proGateUserApplications);
		}
		catch (NoSuchProGateUserApplicationsException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public ProGateUserApplications remove(
		ProGateUserApplications proGateUserApplications)
		throws SystemException {
		for (ModelListener<ProGateUserApplications> listener : listeners) {
			listener.onBeforeRemove(proGateUserApplications);
		}

		proGateUserApplications = removeImpl(proGateUserApplications);

		for (ModelListener<ProGateUserApplications> listener : listeners) {
			listener.onAfterRemove(proGateUserApplications);
		}

		return proGateUserApplications;
	}

	protected ProGateUserApplications removeImpl(
		ProGateUserApplications proGateUserApplications)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (proGateUserApplications.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(ProGateUserApplicationsImpl.class,
						proGateUserApplications.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(proGateUserApplications);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(ProGateUserApplicationsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateUserApplicationsImpl.class,
			proGateUserApplications.getPrimaryKey());

		return proGateUserApplications;
	}

	public ProGateUserApplications update(
		ProGateUserApplications proGateUserApplications)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(ProGateUserApplications proGateUserApplications) method. Use update(ProGateUserApplications proGateUserApplications, boolean merge) instead.");
		}

		return update(proGateUserApplications, false);
	}

	public ProGateUserApplications update(
		ProGateUserApplications proGateUserApplications, boolean merge)
		throws SystemException {
		boolean isNew = proGateUserApplications.isNew();

		for (ModelListener<ProGateUserApplications> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(proGateUserApplications);
			}
			else {
				listener.onBeforeUpdate(proGateUserApplications);
			}
		}

		proGateUserApplications = updateImpl(proGateUserApplications, merge);

		for (ModelListener<ProGateUserApplications> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(proGateUserApplications);
			}
			else {
				listener.onAfterUpdate(proGateUserApplications);
			}
		}

		return proGateUserApplications;
	}

	public ProGateUserApplications updateImpl(
		larion.progate.model.ProGateUserApplications proGateUserApplications,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, proGateUserApplications, merge);

			proGateUserApplications.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(ProGateUserApplicationsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateUserApplicationsImpl.class,
			proGateUserApplications.getPrimaryKey(), proGateUserApplications);

		return proGateUserApplications;
	}

	public ProGateUserApplications findByPrimaryKey(
		Integer ProGateUserApplicationsId)
		throws NoSuchProGateUserApplicationsException, SystemException {
		ProGateUserApplications proGateUserApplications = fetchByPrimaryKey(ProGateUserApplicationsId);

		if (proGateUserApplications == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"No ProGateUserApplications exists with the primary key " +
					ProGateUserApplicationsId);
			}

			throw new NoSuchProGateUserApplicationsException(
				"No ProGateUserApplications exists with the primary key " +
				ProGateUserApplicationsId);
		}

		return proGateUserApplications;
	}

	public ProGateUserApplications fetchByPrimaryKey(
		Integer ProGateUserApplicationsId) throws SystemException {
		ProGateUserApplications proGateUserApplications = (ProGateUserApplications)EntityCacheUtil.getResult(ProGateUserApplicationsModelImpl.ENTITY_CACHE_ENABLED,
				ProGateUserApplicationsImpl.class, ProGateUserApplicationsId,
				this);

		if (proGateUserApplications == null) {
			Session session = null;

			try {
				session = openSession();

				proGateUserApplications = (ProGateUserApplications)session.get(ProGateUserApplicationsImpl.class,
						ProGateUserApplicationsId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (proGateUserApplications != null) {
					cacheResult(proGateUserApplications);
				}

				closeSession(session);
			}
		}

		return proGateUserApplications;
	}

	public List<ProGateUserApplications> findByuserId(int userId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(userId) };

		List<ProGateUserApplications> list = (List<ProGateUserApplications>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_USERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateUserApplications WHERE ");

				query.append("user_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("position ASC");

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
					list = new ArrayList<ProGateUserApplications>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_USERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateUserApplications> findByuserId(int userId, int start,
		int end) throws SystemException {
		return findByuserId(userId, start, end, null);
	}

	public List<ProGateUserApplications> findByuserId(int userId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(userId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateUserApplications> list = (List<ProGateUserApplications>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_USERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateUserApplications WHERE ");

				query.append("user_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("position ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				list = (List<ProGateUserApplications>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateUserApplications>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_USERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateUserApplications findByuserId_First(int userId,
		OrderByComparator obc)
		throws NoSuchProGateUserApplicationsException, SystemException {
		List<ProGateUserApplications> list = findByuserId(userId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateUserApplications exists with the key {");

			msg.append("userId=" + userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateUserApplicationsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateUserApplications findByuserId_Last(int userId,
		OrderByComparator obc)
		throws NoSuchProGateUserApplicationsException, SystemException {
		int count = countByuserId(userId);

		List<ProGateUserApplications> list = findByuserId(userId, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateUserApplications exists with the key {");

			msg.append("userId=" + userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateUserApplicationsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateUserApplications[] findByuserId_PrevAndNext(
		Integer ProGateUserApplicationsId, int userId, OrderByComparator obc)
		throws NoSuchProGateUserApplicationsException, SystemException {
		ProGateUserApplications proGateUserApplications = findByPrimaryKey(ProGateUserApplicationsId);

		int count = countByuserId(userId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateUserApplications WHERE ");

			query.append("user_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("position ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(userId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateUserApplications);

			ProGateUserApplications[] array = new ProGateUserApplicationsImpl[3];

			array[0] = (ProGateUserApplications)objArray[0];
			array[1] = (ProGateUserApplications)objArray[1];
			array[2] = (ProGateUserApplications)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateUserApplications> findByorgId(int orgId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(orgId) };

		List<ProGateUserApplications> list = (List<ProGateUserApplications>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ORGID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateUserApplications WHERE ");

				query.append("org_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("position ASC");

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
					list = new ArrayList<ProGateUserApplications>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ORGID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateUserApplications> findByorgId(int orgId, int start,
		int end) throws SystemException {
		return findByorgId(orgId, start, end, null);
	}

	public List<ProGateUserApplications> findByorgId(int orgId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(orgId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateUserApplications> list = (List<ProGateUserApplications>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ORGID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateUserApplications WHERE ");

				query.append("org_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("position ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orgId);

				list = (List<ProGateUserApplications>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateUserApplications>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ORGID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateUserApplications findByorgId_First(int orgId,
		OrderByComparator obc)
		throws NoSuchProGateUserApplicationsException, SystemException {
		List<ProGateUserApplications> list = findByorgId(orgId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateUserApplications exists with the key {");

			msg.append("orgId=" + orgId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateUserApplicationsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateUserApplications findByorgId_Last(int orgId,
		OrderByComparator obc)
		throws NoSuchProGateUserApplicationsException, SystemException {
		int count = countByorgId(orgId);

		List<ProGateUserApplications> list = findByorgId(orgId, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateUserApplications exists with the key {");

			msg.append("orgId=" + orgId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateUserApplicationsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateUserApplications[] findByorgId_PrevAndNext(
		Integer ProGateUserApplicationsId, int orgId, OrderByComparator obc)
		throws NoSuchProGateUserApplicationsException, SystemException {
		ProGateUserApplications proGateUserApplications = findByPrimaryKey(ProGateUserApplicationsId);

		int count = countByorgId(orgId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateUserApplications WHERE ");

			query.append("org_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("position ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(orgId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateUserApplications);

			ProGateUserApplications[] array = new ProGateUserApplicationsImpl[3];

			array[0] = (ProGateUserApplications)objArray[0];
			array[1] = (ProGateUserApplications)objArray[1];
			array[2] = (ProGateUserApplications)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateUserApplications> findByappsId(int appsId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(appsId) };

		List<ProGateUserApplications> list = (List<ProGateUserApplications>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_APPSID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateUserApplications WHERE ");

				query.append("app_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("position ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(appsId);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateUserApplications>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_APPSID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateUserApplications> findByappsId(int appsId, int start,
		int end) throws SystemException {
		return findByappsId(appsId, start, end, null);
	}

	public List<ProGateUserApplications> findByappsId(int appsId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(appsId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateUserApplications> list = (List<ProGateUserApplications>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_APPSID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateUserApplications WHERE ");

				query.append("app_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("position ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(appsId);

				list = (List<ProGateUserApplications>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateUserApplications>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_APPSID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateUserApplications findByappsId_First(int appsId,
		OrderByComparator obc)
		throws NoSuchProGateUserApplicationsException, SystemException {
		List<ProGateUserApplications> list = findByappsId(appsId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateUserApplications exists with the key {");

			msg.append("appsId=" + appsId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateUserApplicationsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateUserApplications findByappsId_Last(int appsId,
		OrderByComparator obc)
		throws NoSuchProGateUserApplicationsException, SystemException {
		int count = countByappsId(appsId);

		List<ProGateUserApplications> list = findByappsId(appsId, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateUserApplications exists with the key {");

			msg.append("appsId=" + appsId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateUserApplicationsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateUserApplications[] findByappsId_PrevAndNext(
		Integer ProGateUserApplicationsId, int appsId, OrderByComparator obc)
		throws NoSuchProGateUserApplicationsException, SystemException {
		ProGateUserApplications proGateUserApplications = findByPrimaryKey(ProGateUserApplicationsId);

		int count = countByappsId(appsId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateUserApplications WHERE ");

			query.append("app_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("position ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(appsId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateUserApplications);

			ProGateUserApplications[] array = new ProGateUserApplicationsImpl[3];

			array[0] = (ProGateUserApplications)objArray[0];
			array[1] = (ProGateUserApplications)objArray[1];
			array[2] = (ProGateUserApplications)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateUserApplications> findByindexEqual(int position)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(position) };

		List<ProGateUserApplications> list = (List<ProGateUserApplications>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_INDEXEQUAL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateUserApplications WHERE ");

				query.append("position = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("position ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(position);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateUserApplications>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_INDEXEQUAL,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateUserApplications> findByindexEqual(int position,
		int start, int end) throws SystemException {
		return findByindexEqual(position, start, end, null);
	}

	public List<ProGateUserApplications> findByindexEqual(int position,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(position),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateUserApplications> list = (List<ProGateUserApplications>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_INDEXEQUAL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateUserApplications WHERE ");

				query.append("position = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("position ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(position);

				list = (List<ProGateUserApplications>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateUserApplications>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_INDEXEQUAL,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateUserApplications findByindexEqual_First(int position,
		OrderByComparator obc)
		throws NoSuchProGateUserApplicationsException, SystemException {
		List<ProGateUserApplications> list = findByindexEqual(position, 0, 1,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateUserApplications exists with the key {");

			msg.append("position=" + position);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateUserApplicationsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateUserApplications findByindexEqual_Last(int position,
		OrderByComparator obc)
		throws NoSuchProGateUserApplicationsException, SystemException {
		int count = countByindexEqual(position);

		List<ProGateUserApplications> list = findByindexEqual(position,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateUserApplications exists with the key {");

			msg.append("position=" + position);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateUserApplicationsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateUserApplications[] findByindexEqual_PrevAndNext(
		Integer ProGateUserApplicationsId, int position, OrderByComparator obc)
		throws NoSuchProGateUserApplicationsException, SystemException {
		ProGateUserApplications proGateUserApplications = findByPrimaryKey(ProGateUserApplicationsId);

		int count = countByindexEqual(position);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateUserApplications WHERE ");

			query.append("position = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("position ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(position);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateUserApplications);

			ProGateUserApplications[] array = new ProGateUserApplicationsImpl[3];

			array[0] = (ProGateUserApplications)objArray[0];
			array[1] = (ProGateUserApplications)objArray[1];
			array[2] = (ProGateUserApplications)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateUserApplications> findByindexGreater(int position)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(position) };

		List<ProGateUserApplications> list = (List<ProGateUserApplications>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_INDEXGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateUserApplications WHERE ");

				query.append("position >= ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("position ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(position);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateUserApplications>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_INDEXGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateUserApplications> findByindexGreater(int position,
		int start, int end) throws SystemException {
		return findByindexGreater(position, start, end, null);
	}

	public List<ProGateUserApplications> findByindexGreater(int position,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(position),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateUserApplications> list = (List<ProGateUserApplications>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_INDEXGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateUserApplications WHERE ");

				query.append("position >= ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("position ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(position);

				list = (List<ProGateUserApplications>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateUserApplications>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_INDEXGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateUserApplications findByindexGreater_First(int position,
		OrderByComparator obc)
		throws NoSuchProGateUserApplicationsException, SystemException {
		List<ProGateUserApplications> list = findByindexGreater(position, 0, 1,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateUserApplications exists with the key {");

			msg.append("position=" + position);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateUserApplicationsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateUserApplications findByindexGreater_Last(int position,
		OrderByComparator obc)
		throws NoSuchProGateUserApplicationsException, SystemException {
		int count = countByindexGreater(position);

		List<ProGateUserApplications> list = findByindexGreater(position,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateUserApplications exists with the key {");

			msg.append("position=" + position);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateUserApplicationsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateUserApplications[] findByindexGreater_PrevAndNext(
		Integer ProGateUserApplicationsId, int position, OrderByComparator obc)
		throws NoSuchProGateUserApplicationsException, SystemException {
		ProGateUserApplications proGateUserApplications = findByPrimaryKey(ProGateUserApplicationsId);

		int count = countByindexGreater(position);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateUserApplications WHERE ");

			query.append("position >= ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("position ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(position);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateUserApplications);

			ProGateUserApplications[] array = new ProGateUserApplicationsImpl[3];

			array[0] = (ProGateUserApplications)objArray[0];
			array[1] = (ProGateUserApplications)objArray[1];
			array[2] = (ProGateUserApplications)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateUserApplications> findByindexLower(int position)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(position) };

		List<ProGateUserApplications> list = (List<ProGateUserApplications>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_INDEXLOWER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateUserApplications WHERE ");

				query.append("position <= ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("position ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(position);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateUserApplications>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_INDEXLOWER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateUserApplications> findByindexLower(int position,
		int start, int end) throws SystemException {
		return findByindexLower(position, start, end, null);
	}

	public List<ProGateUserApplications> findByindexLower(int position,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(position),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateUserApplications> list = (List<ProGateUserApplications>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_INDEXLOWER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateUserApplications WHERE ");

				query.append("position <= ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("position ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(position);

				list = (List<ProGateUserApplications>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateUserApplications>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_INDEXLOWER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateUserApplications findByindexLower_First(int position,
		OrderByComparator obc)
		throws NoSuchProGateUserApplicationsException, SystemException {
		List<ProGateUserApplications> list = findByindexLower(position, 0, 1,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateUserApplications exists with the key {");

			msg.append("position=" + position);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateUserApplicationsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateUserApplications findByindexLower_Last(int position,
		OrderByComparator obc)
		throws NoSuchProGateUserApplicationsException, SystemException {
		int count = countByindexLower(position);

		List<ProGateUserApplications> list = findByindexLower(position,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateUserApplications exists with the key {");

			msg.append("position=" + position);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateUserApplicationsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateUserApplications[] findByindexLower_PrevAndNext(
		Integer ProGateUserApplicationsId, int position, OrderByComparator obc)
		throws NoSuchProGateUserApplicationsException, SystemException {
		ProGateUserApplications proGateUserApplications = findByPrimaryKey(ProGateUserApplicationsId);

		int count = countByindexLower(position);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateUserApplications WHERE ");

			query.append("position <= ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("position ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(position);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateUserApplications);

			ProGateUserApplications[] array = new ProGateUserApplicationsImpl[3];

			array[0] = (ProGateUserApplications)objArray[0];
			array[1] = (ProGateUserApplications)objArray[1];
			array[2] = (ProGateUserApplications)objArray[2];

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

	public List<ProGateUserApplications> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<ProGateUserApplications> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<ProGateUserApplications> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateUserApplications> list = (List<ProGateUserApplications>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateUserApplications ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("position ASC");
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<ProGateUserApplications>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ProGateUserApplications>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateUserApplications>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByuserId(int userId) throws SystemException {
		for (ProGateUserApplications proGateUserApplications : findByuserId(
				userId)) {
			remove(proGateUserApplications);
		}
	}

	public void removeByorgId(int orgId) throws SystemException {
		for (ProGateUserApplications proGateUserApplications : findByorgId(
				orgId)) {
			remove(proGateUserApplications);
		}
	}

	public void removeByappsId(int appsId) throws SystemException {
		for (ProGateUserApplications proGateUserApplications : findByappsId(
				appsId)) {
			remove(proGateUserApplications);
		}
	}

	public void removeByindexEqual(int position) throws SystemException {
		for (ProGateUserApplications proGateUserApplications : findByindexEqual(
				position)) {
			remove(proGateUserApplications);
		}
	}

	public void removeByindexGreater(int position) throws SystemException {
		for (ProGateUserApplications proGateUserApplications : findByindexGreater(
				position)) {
			remove(proGateUserApplications);
		}
	}

	public void removeByindexLower(int position) throws SystemException {
		for (ProGateUserApplications proGateUserApplications : findByindexLower(
				position)) {
			remove(proGateUserApplications);
		}
	}

	public void removeAll() throws SystemException {
		for (ProGateUserApplications proGateUserApplications : findAll()) {
			remove(proGateUserApplications);
		}
	}

	public int countByuserId(int userId) throws SystemException {
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
					"FROM larion.progate.model.ProGateUserApplications WHERE ");

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

	public int countByorgId(int orgId) throws SystemException {
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
					"FROM larion.progate.model.ProGateUserApplications WHERE ");

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

	public int countByappsId(int appsId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(appsId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_APPSID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateUserApplications WHERE ");

				query.append("app_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(appsId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_APPSID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByindexEqual(int position) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(position) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_INDEXEQUAL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateUserApplications WHERE ");

				query.append("position = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(position);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_INDEXEQUAL,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByindexGreater(int position) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(position) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_INDEXGREATER,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateUserApplications WHERE ");

				query.append("position >= ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(position);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_INDEXGREATER,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByindexLower(int position) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(position) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_INDEXLOWER,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateUserApplications WHERE ");

				query.append("position <= ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(position);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_INDEXLOWER,
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
						"SELECT COUNT(*) FROM larion.progate.model.ProGateUserApplications");

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
						"value.object.listener.larion.progate.model.ProGateUserApplications")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ProGateUserApplications>> listenersList = new ArrayList<ModelListener<ProGateUserApplications>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ProGateUserApplications>)Class.forName(
							listenerClassName).newInstance());
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	@BeanReference(name = "larion.progate.service.persistence.UserPersistence.impl")
	protected larion.progate.service.persistence.UserPersistence userPersistence;
	@BeanReference(name = "larion.progate.service.persistence.UserInformationViewPersistence.impl")
	protected larion.progate.service.persistence.UserInformationViewPersistence userInformationViewPersistence;
	@BeanReference(name = "larion.progate.service.persistence.OrganizationPersistence.impl")
	protected larion.progate.service.persistence.OrganizationPersistence organizationPersistence;
	@BeanReference(name = "larion.progate.service.persistence.OrganizationViewPersistence.impl")
	protected larion.progate.service.persistence.OrganizationViewPersistence organizationViewPersistence;
	@BeanReference(name = "larion.progate.service.persistence.OrgObjectListPersistence.impl")
	protected larion.progate.service.persistence.OrgObjectListPersistence orgObjectListPersistence;
	@BeanReference(name = "larion.progate.service.persistence.OrgObjectApprovalPersistence.impl")
	protected larion.progate.service.persistence.OrgObjectApprovalPersistence orgObjectApprovalPersistence;
	@BeanReference(name = "larion.progate.service.persistence.OrgObjectPerspectivePersistence.impl")
	protected larion.progate.service.persistence.OrgObjectPerspectivePersistence orgObjectPerspectivePersistence;
	@BeanReference(name = "larion.progate.service.persistence.OrgObjectObjectivePersistence.impl")
	protected larion.progate.service.persistence.OrgObjectObjectivePersistence orgObjectObjectivePersistence;
	@BeanReference(name = "larion.progate.service.persistence.OrgObjectMeasurePersistence.impl")
	protected larion.progate.service.persistence.OrgObjectMeasurePersistence orgObjectMeasurePersistence;
	@BeanReference(name = "larion.progate.service.persistence.OrgObjectTargetsPersistence.impl")
	protected larion.progate.service.persistence.OrgObjectTargetsPersistence orgObjectTargetsPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProgatePortalMenuPersistence.impl")
	protected larion.progate.service.persistence.ProgatePortalMenuPersistence progatePortalMenuPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProGateRolesPersistence.impl")
	protected larion.progate.service.persistence.ProGateRolesPersistence proGateRolesPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProGateOrgTypePersistence.impl")
	protected larion.progate.service.persistence.ProGateOrgTypePersistence proGateOrgTypePersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProGateJournalArticlePersistence.impl")
	protected larion.progate.service.persistence.ProGateJournalArticlePersistence proGateJournalArticlePersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProGateProductsServicesPersistence.impl")
	protected larion.progate.service.persistence.ProGateProductsServicesPersistence proGateProductsServicesPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProGateCurrencyTypesPersistence.impl")
	protected larion.progate.service.persistence.ProGateCurrencyTypesPersistence proGateCurrencyTypesPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProGateJournalArticlePrioritiesPersistence.impl")
	protected larion.progate.service.persistence.ProGateJournalArticlePrioritiesPersistence proGateJournalArticlePrioritiesPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProGateJournalArticleTypesPersistence.impl")
	protected larion.progate.service.persistence.ProGateJournalArticleTypesPersistence proGateJournalArticleTypesPersistence;
	@BeanReference(name = "larion.progate.service.persistence.RegionPersistence.impl")
	protected larion.progate.service.persistence.RegionPersistence regionPersistence;
	@BeanReference(name = "larion.progate.service.persistence.CountryPersistence.impl")
	protected larion.progate.service.persistence.CountryPersistence countryPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProGateJournalArticleViewPersistence.impl")
	protected larion.progate.service.persistence.ProGateJournalArticleViewPersistence proGateJournalArticleViewPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProGateJournalArticleSlideShowPersistence.impl")
	protected larion.progate.service.persistence.ProGateJournalArticleSlideShowPersistence proGateJournalArticleSlideShowPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProGateOrgCustomerPersistence.impl")
	protected larion.progate.service.persistence.ProGateOrgCustomerPersistence proGateOrgCustomerPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProGateOrgCustomerRepresenterPersistence.impl")
	protected larion.progate.service.persistence.ProGateOrgCustomerRepresenterPersistence proGateOrgCustomerRepresenterPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProGateApplicationsPersistence.impl")
	protected larion.progate.service.persistence.ProGateApplicationsPersistence proGateApplicationsPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProGateUserApplicationsPersistence.impl")
	protected larion.progate.service.persistence.ProGateUserApplicationsPersistence proGateUserApplicationsPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProgateOrganizationParticipantsPersistence.impl")
	protected larion.progate.service.persistence.ProgateOrganizationParticipantsPersistence progateOrganizationParticipantsPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProgateOrganizationsStaffsPersistence.impl")
	protected larion.progate.service.persistence.ProgateOrganizationsStaffsPersistence progateOrganizationsStaffsPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProgateApplicationsSettingPersistence.impl")
	protected larion.progate.service.persistence.ProgateApplicationsSettingPersistence progateApplicationsSettingPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProgateMenusPersistence.impl")
	protected larion.progate.service.persistence.ProgateMenusPersistence progateMenusPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProgateLayoutsRolesPersistence.impl")
	protected larion.progate.service.persistence.ProgateLayoutsRolesPersistence progateLayoutsRolesPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProgateLayoutsMenusPersistence.impl")
	protected larion.progate.service.persistence.ProgateLayoutsMenusPersistence progateLayoutsMenusPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProGateMenuViewPersistence.impl")
	protected larion.progate.service.persistence.ProGateMenuViewPersistence proGateMenuViewPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProGateOrgsUsersPermissionsPersistence.impl")
	protected larion.progate.service.persistence.ProGateOrgsUsersPermissionsPersistence proGateOrgsUsersPermissionsPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProGatePermissionsPersistence.impl")
	protected larion.progate.service.persistence.ProGatePermissionsPersistence proGatePermissionsPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ViewOrgUsersPermissionsPersistence.impl")
	protected larion.progate.service.persistence.ViewOrgUsersPermissionsPersistence viewOrgUsersPermissionsPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ViewProGatePermissionsRolesPersistence.impl")
	protected larion.progate.service.persistence.ViewProGatePermissionsRolesPersistence viewProGatePermissionsRolesPersistence;
	private static Log _log = LogFactoryUtil.getLog(ProGateUserApplicationsPersistenceImpl.class);
}