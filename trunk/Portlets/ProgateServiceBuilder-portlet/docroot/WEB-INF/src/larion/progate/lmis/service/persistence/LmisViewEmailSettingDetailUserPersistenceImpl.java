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

import larion.progate.lmis.NoSuchLmisViewEmailSettingDetailUserException;
import larion.progate.lmis.model.LmisViewEmailSettingDetailUser;
import larion.progate.lmis.model.impl.LmisViewEmailSettingDetailUserImpl;
import larion.progate.lmis.model.impl.LmisViewEmailSettingDetailUserModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="LmisViewEmailSettingDetailUserPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewEmailSettingDetailUserPersistenceImpl
	extends BasePersistenceImpl
	implements LmisViewEmailSettingDetailUserPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = LmisViewEmailSettingDetailUserImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_EMAILTYPE = new FinderPath(LmisViewEmailSettingDetailUserModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewEmailSettingDetailUserModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByEmailType",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_EMAILTYPE = new FinderPath(LmisViewEmailSettingDetailUserModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewEmailSettingDetailUserModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByEmailType",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_EMAILTYPE = new FinderPath(LmisViewEmailSettingDetailUserModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewEmailSettingDetailUserModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByEmailType",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ROOTID = new FinderPath(LmisViewEmailSettingDetailUserModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewEmailSettingDetailUserModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ROOTID = new FinderPath(LmisViewEmailSettingDetailUserModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewEmailSettingDetailUserModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ROOTID = new FinderPath(LmisViewEmailSettingDetailUserModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewEmailSettingDetailUserModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByRootID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ID = new FinderPath(LmisViewEmailSettingDetailUserModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewEmailSettingDetailUserModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ID = new FinderPath(LmisViewEmailSettingDetailUserModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewEmailSettingDetailUserModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ID = new FinderPath(LmisViewEmailSettingDetailUserModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewEmailSettingDetailUserModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_CATEGORY = new FinderPath(LmisViewEmailSettingDetailUserModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewEmailSettingDetailUserModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByCategory",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_CATEGORY = new FinderPath(LmisViewEmailSettingDetailUserModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewEmailSettingDetailUserModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByCategory",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORY = new FinderPath(LmisViewEmailSettingDetailUserModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewEmailSettingDetailUserModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByCategory",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_EMAILNAME = new FinderPath(LmisViewEmailSettingDetailUserModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewEmailSettingDetailUserModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByEmailName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_EMAILNAME = new FinderPath(LmisViewEmailSettingDetailUserModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewEmailSettingDetailUserModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByEmailName",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_EMAILNAME = new FinderPath(LmisViewEmailSettingDetailUserModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewEmailSettingDetailUserModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByEmailName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(LmisViewEmailSettingDetailUserModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewEmailSettingDetailUserModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LmisViewEmailSettingDetailUserModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewEmailSettingDetailUserModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(
		LmisViewEmailSettingDetailUser lmisViewEmailSettingDetailUser) {
		EntityCacheUtil.putResult(LmisViewEmailSettingDetailUserModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewEmailSettingDetailUserImpl.class,
			lmisViewEmailSettingDetailUser.getPrimaryKey(),
			lmisViewEmailSettingDetailUser);
	}

	public void cacheResult(
		List<LmisViewEmailSettingDetailUser> lmisViewEmailSettingDetailUsers) {
		for (LmisViewEmailSettingDetailUser lmisViewEmailSettingDetailUser : lmisViewEmailSettingDetailUsers) {
			if (EntityCacheUtil.getResult(
						LmisViewEmailSettingDetailUserModelImpl.ENTITY_CACHE_ENABLED,
						LmisViewEmailSettingDetailUserImpl.class,
						lmisViewEmailSettingDetailUser.getPrimaryKey(), this) == null) {
				cacheResult(lmisViewEmailSettingDetailUser);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(LmisViewEmailSettingDetailUserImpl.class.getName());
		EntityCacheUtil.clearCache(LmisViewEmailSettingDetailUserImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public LmisViewEmailSettingDetailUser create(Integer userRelatedId) {
		LmisViewEmailSettingDetailUser lmisViewEmailSettingDetailUser = new LmisViewEmailSettingDetailUserImpl();

		lmisViewEmailSettingDetailUser.setNew(true);
		lmisViewEmailSettingDetailUser.setPrimaryKey(userRelatedId);

		return lmisViewEmailSettingDetailUser;
	}

	public LmisViewEmailSettingDetailUser remove(Integer userRelatedId)
		throws NoSuchLmisViewEmailSettingDetailUserException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LmisViewEmailSettingDetailUser lmisViewEmailSettingDetailUser = (LmisViewEmailSettingDetailUser)session.get(LmisViewEmailSettingDetailUserImpl.class,
					userRelatedId);

			if (lmisViewEmailSettingDetailUser == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No LmisViewEmailSettingDetailUser exists with the primary key " +
						userRelatedId);
				}

				throw new NoSuchLmisViewEmailSettingDetailUserException(
					"No LmisViewEmailSettingDetailUser exists with the primary key " +
					userRelatedId);
			}

			return remove(lmisViewEmailSettingDetailUser);
		}
		catch (NoSuchLmisViewEmailSettingDetailUserException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public LmisViewEmailSettingDetailUser remove(
		LmisViewEmailSettingDetailUser lmisViewEmailSettingDetailUser)
		throws SystemException {
		for (ModelListener<LmisViewEmailSettingDetailUser> listener : listeners) {
			listener.onBeforeRemove(lmisViewEmailSettingDetailUser);
		}

		lmisViewEmailSettingDetailUser = removeImpl(lmisViewEmailSettingDetailUser);

		for (ModelListener<LmisViewEmailSettingDetailUser> listener : listeners) {
			listener.onAfterRemove(lmisViewEmailSettingDetailUser);
		}

		return lmisViewEmailSettingDetailUser;
	}

	protected LmisViewEmailSettingDetailUser removeImpl(
		LmisViewEmailSettingDetailUser lmisViewEmailSettingDetailUser)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (lmisViewEmailSettingDetailUser.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(LmisViewEmailSettingDetailUserImpl.class,
						lmisViewEmailSettingDetailUser.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(lmisViewEmailSettingDetailUser);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(LmisViewEmailSettingDetailUserModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewEmailSettingDetailUserImpl.class,
			lmisViewEmailSettingDetailUser.getPrimaryKey());

		return lmisViewEmailSettingDetailUser;
	}

	public LmisViewEmailSettingDetailUser update(
		LmisViewEmailSettingDetailUser lmisViewEmailSettingDetailUser)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(LmisViewEmailSettingDetailUser lmisViewEmailSettingDetailUser) method. Use update(LmisViewEmailSettingDetailUser lmisViewEmailSettingDetailUser, boolean merge) instead.");
		}

		return update(lmisViewEmailSettingDetailUser, false);
	}

	public LmisViewEmailSettingDetailUser update(
		LmisViewEmailSettingDetailUser lmisViewEmailSettingDetailUser,
		boolean merge) throws SystemException {
		boolean isNew = lmisViewEmailSettingDetailUser.isNew();

		for (ModelListener<LmisViewEmailSettingDetailUser> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(lmisViewEmailSettingDetailUser);
			}
			else {
				listener.onBeforeUpdate(lmisViewEmailSettingDetailUser);
			}
		}

		lmisViewEmailSettingDetailUser = updateImpl(lmisViewEmailSettingDetailUser,
				merge);

		for (ModelListener<LmisViewEmailSettingDetailUser> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(lmisViewEmailSettingDetailUser);
			}
			else {
				listener.onAfterUpdate(lmisViewEmailSettingDetailUser);
			}
		}

		return lmisViewEmailSettingDetailUser;
	}

	public LmisViewEmailSettingDetailUser updateImpl(
		larion.progate.lmis.model.LmisViewEmailSettingDetailUser lmisViewEmailSettingDetailUser,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, lmisViewEmailSettingDetailUser,
				merge);

			lmisViewEmailSettingDetailUser.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(LmisViewEmailSettingDetailUserModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewEmailSettingDetailUserImpl.class,
			lmisViewEmailSettingDetailUser.getPrimaryKey(),
			lmisViewEmailSettingDetailUser);

		return lmisViewEmailSettingDetailUser;
	}

	public LmisViewEmailSettingDetailUser findByPrimaryKey(
		Integer userRelatedId)
		throws NoSuchLmisViewEmailSettingDetailUserException, SystemException {
		LmisViewEmailSettingDetailUser lmisViewEmailSettingDetailUser = fetchByPrimaryKey(userRelatedId);

		if (lmisViewEmailSettingDetailUser == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"No LmisViewEmailSettingDetailUser exists with the primary key " +
					userRelatedId);
			}

			throw new NoSuchLmisViewEmailSettingDetailUserException(
				"No LmisViewEmailSettingDetailUser exists with the primary key " +
				userRelatedId);
		}

		return lmisViewEmailSettingDetailUser;
	}

	public LmisViewEmailSettingDetailUser fetchByPrimaryKey(
		Integer userRelatedId) throws SystemException {
		LmisViewEmailSettingDetailUser lmisViewEmailSettingDetailUser = (LmisViewEmailSettingDetailUser)EntityCacheUtil.getResult(LmisViewEmailSettingDetailUserModelImpl.ENTITY_CACHE_ENABLED,
				LmisViewEmailSettingDetailUserImpl.class, userRelatedId, this);

		if (lmisViewEmailSettingDetailUser == null) {
			Session session = null;

			try {
				session = openSession();

				lmisViewEmailSettingDetailUser = (LmisViewEmailSettingDetailUser)session.get(LmisViewEmailSettingDetailUserImpl.class,
						userRelatedId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (lmisViewEmailSettingDetailUser != null) {
					cacheResult(lmisViewEmailSettingDetailUser);
				}

				closeSession(session);
			}
		}

		return lmisViewEmailSettingDetailUser;
	}

	public List<LmisViewEmailSettingDetailUser> findByEmailType(
		String emailType) throws SystemException {
		Object[] finderArgs = new Object[] { emailType };

		List<LmisViewEmailSettingDetailUser> list = (List<LmisViewEmailSettingDetailUser>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_EMAILTYPE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewEmailSettingDetailUser WHERE ");

				if (emailType == null) {
					query.append("email_type LIKE null");
				}
				else {
					query.append("email_type LIKE ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (emailType != null) {
					qPos.add(emailType);
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewEmailSettingDetailUser>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_EMAILTYPE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewEmailSettingDetailUser> findByEmailType(
		String emailType, int start, int end) throws SystemException {
		return findByEmailType(emailType, start, end, null);
	}

	public List<LmisViewEmailSettingDetailUser> findByEmailType(
		String emailType, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				emailType,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewEmailSettingDetailUser> list = (List<LmisViewEmailSettingDetailUser>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_EMAILTYPE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewEmailSettingDetailUser WHERE ");

				if (emailType == null) {
					query.append("email_type LIKE null");
				}
				else {
					query.append("email_type LIKE ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (emailType != null) {
					qPos.add(emailType);
				}

				list = (List<LmisViewEmailSettingDetailUser>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewEmailSettingDetailUser>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_EMAILTYPE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewEmailSettingDetailUser findByEmailType_First(
		String emailType, OrderByComparator obc)
		throws NoSuchLmisViewEmailSettingDetailUserException, SystemException {
		List<LmisViewEmailSettingDetailUser> list = findByEmailType(emailType,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No LmisViewEmailSettingDetailUser exists with the key {");

			msg.append("emailType=" + emailType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewEmailSettingDetailUserException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewEmailSettingDetailUser findByEmailType_Last(
		String emailType, OrderByComparator obc)
		throws NoSuchLmisViewEmailSettingDetailUserException, SystemException {
		int count = countByEmailType(emailType);

		List<LmisViewEmailSettingDetailUser> list = findByEmailType(emailType,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No LmisViewEmailSettingDetailUser exists with the key {");

			msg.append("emailType=" + emailType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewEmailSettingDetailUserException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewEmailSettingDetailUser[] findByEmailType_PrevAndNext(
		Integer userRelatedId, String emailType, OrderByComparator obc)
		throws NoSuchLmisViewEmailSettingDetailUserException, SystemException {
		LmisViewEmailSettingDetailUser lmisViewEmailSettingDetailUser = findByPrimaryKey(userRelatedId);

		int count = countByEmailType(emailType);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewEmailSettingDetailUser WHERE ");

			if (emailType == null) {
				query.append("email_type LIKE null");
			}
			else {
				query.append("email_type LIKE ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (emailType != null) {
				qPos.add(emailType);
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisViewEmailSettingDetailUser);

			LmisViewEmailSettingDetailUser[] array = new LmisViewEmailSettingDetailUserImpl[3];

			array[0] = (LmisViewEmailSettingDetailUser)objArray[0];
			array[1] = (LmisViewEmailSettingDetailUser)objArray[1];
			array[2] = (LmisViewEmailSettingDetailUser)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewEmailSettingDetailUser> findByRootID(int rootId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		List<LmisViewEmailSettingDetailUser> list = (List<LmisViewEmailSettingDetailUser>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewEmailSettingDetailUser WHERE ");

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
					list = new ArrayList<LmisViewEmailSettingDetailUser>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewEmailSettingDetailUser> findByRootID(int rootId,
		int start, int end) throws SystemException {
		return findByRootID(rootId, start, end, null);
	}

	public List<LmisViewEmailSettingDetailUser> findByRootID(int rootId,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(rootId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewEmailSettingDetailUser> list = (List<LmisViewEmailSettingDetailUser>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewEmailSettingDetailUser WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rootId);

				list = (List<LmisViewEmailSettingDetailUser>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewEmailSettingDetailUser>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewEmailSettingDetailUser findByRootID_First(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisViewEmailSettingDetailUserException, SystemException {
		List<LmisViewEmailSettingDetailUser> list = findByRootID(rootId, 0, 1,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No LmisViewEmailSettingDetailUser exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewEmailSettingDetailUserException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewEmailSettingDetailUser findByRootID_Last(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisViewEmailSettingDetailUserException, SystemException {
		int count = countByRootID(rootId);

		List<LmisViewEmailSettingDetailUser> list = findByRootID(rootId,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No LmisViewEmailSettingDetailUser exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewEmailSettingDetailUserException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewEmailSettingDetailUser[] findByRootID_PrevAndNext(
		Integer userRelatedId, int rootId, OrderByComparator obc)
		throws NoSuchLmisViewEmailSettingDetailUserException, SystemException {
		LmisViewEmailSettingDetailUser lmisViewEmailSettingDetailUser = findByPrimaryKey(userRelatedId);

		int count = countByRootID(rootId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewEmailSettingDetailUser WHERE ");

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
					lmisViewEmailSettingDetailUser);

			LmisViewEmailSettingDetailUser[] array = new LmisViewEmailSettingDetailUserImpl[3];

			array[0] = (LmisViewEmailSettingDetailUser)objArray[0];
			array[1] = (LmisViewEmailSettingDetailUser)objArray[1];
			array[2] = (LmisViewEmailSettingDetailUser)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewEmailSettingDetailUser> findByID(int id_)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(id_) };

		List<LmisViewEmailSettingDetailUser> list = (List<LmisViewEmailSettingDetailUser>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewEmailSettingDetailUser WHERE ");

				query.append("id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewEmailSettingDetailUser>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ID, finderArgs,
					list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewEmailSettingDetailUser> findByID(int id_, int start,
		int end) throws SystemException {
		return findByID(id_, start, end, null);
	}

	public List<LmisViewEmailSettingDetailUser> findByID(int id_, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(id_),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewEmailSettingDetailUser> list = (List<LmisViewEmailSettingDetailUser>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewEmailSettingDetailUser WHERE ");

				query.append("id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_);

				list = (List<LmisViewEmailSettingDetailUser>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewEmailSettingDetailUser>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewEmailSettingDetailUser findByID_First(int id_,
		OrderByComparator obc)
		throws NoSuchLmisViewEmailSettingDetailUserException, SystemException {
		List<LmisViewEmailSettingDetailUser> list = findByID(id_, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No LmisViewEmailSettingDetailUser exists with the key {");

			msg.append("id_=" + id_);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewEmailSettingDetailUserException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewEmailSettingDetailUser findByID_Last(int id_,
		OrderByComparator obc)
		throws NoSuchLmisViewEmailSettingDetailUserException, SystemException {
		int count = countByID(id_);

		List<LmisViewEmailSettingDetailUser> list = findByID(id_, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No LmisViewEmailSettingDetailUser exists with the key {");

			msg.append("id_=" + id_);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewEmailSettingDetailUserException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewEmailSettingDetailUser[] findByID_PrevAndNext(
		Integer userRelatedId, int id_, OrderByComparator obc)
		throws NoSuchLmisViewEmailSettingDetailUserException, SystemException {
		LmisViewEmailSettingDetailUser lmisViewEmailSettingDetailUser = findByPrimaryKey(userRelatedId);

		int count = countByID(id_);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewEmailSettingDetailUser WHERE ");

			query.append("id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(id_);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisViewEmailSettingDetailUser);

			LmisViewEmailSettingDetailUser[] array = new LmisViewEmailSettingDetailUserImpl[3];

			array[0] = (LmisViewEmailSettingDetailUser)objArray[0];
			array[1] = (LmisViewEmailSettingDetailUser)objArray[1];
			array[2] = (LmisViewEmailSettingDetailUser)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewEmailSettingDetailUser> findByCategory(int category)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(category) };

		List<LmisViewEmailSettingDetailUser> list = (List<LmisViewEmailSettingDetailUser>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_CATEGORY,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewEmailSettingDetailUser WHERE ");

				query.append("category = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(category);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewEmailSettingDetailUser>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_CATEGORY,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewEmailSettingDetailUser> findByCategory(int category,
		int start, int end) throws SystemException {
		return findByCategory(category, start, end, null);
	}

	public List<LmisViewEmailSettingDetailUser> findByCategory(int category,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(category),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewEmailSettingDetailUser> list = (List<LmisViewEmailSettingDetailUser>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_CATEGORY,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewEmailSettingDetailUser WHERE ");

				query.append("category = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(category);

				list = (List<LmisViewEmailSettingDetailUser>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewEmailSettingDetailUser>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_CATEGORY,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewEmailSettingDetailUser findByCategory_First(int category,
		OrderByComparator obc)
		throws NoSuchLmisViewEmailSettingDetailUserException, SystemException {
		List<LmisViewEmailSettingDetailUser> list = findByCategory(category, 0,
				1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No LmisViewEmailSettingDetailUser exists with the key {");

			msg.append("category=" + category);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewEmailSettingDetailUserException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewEmailSettingDetailUser findByCategory_Last(int category,
		OrderByComparator obc)
		throws NoSuchLmisViewEmailSettingDetailUserException, SystemException {
		int count = countByCategory(category);

		List<LmisViewEmailSettingDetailUser> list = findByCategory(category,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No LmisViewEmailSettingDetailUser exists with the key {");

			msg.append("category=" + category);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewEmailSettingDetailUserException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewEmailSettingDetailUser[] findByCategory_PrevAndNext(
		Integer userRelatedId, int category, OrderByComparator obc)
		throws NoSuchLmisViewEmailSettingDetailUserException, SystemException {
		LmisViewEmailSettingDetailUser lmisViewEmailSettingDetailUser = findByPrimaryKey(userRelatedId);

		int count = countByCategory(category);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewEmailSettingDetailUser WHERE ");

			query.append("category = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(category);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisViewEmailSettingDetailUser);

			LmisViewEmailSettingDetailUser[] array = new LmisViewEmailSettingDetailUserImpl[3];

			array[0] = (LmisViewEmailSettingDetailUser)objArray[0];
			array[1] = (LmisViewEmailSettingDetailUser)objArray[1];
			array[2] = (LmisViewEmailSettingDetailUser)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewEmailSettingDetailUser> findByEmailName(String name)
		throws SystemException {
		Object[] finderArgs = new Object[] { name };

		List<LmisViewEmailSettingDetailUser> list = (List<LmisViewEmailSettingDetailUser>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_EMAILNAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewEmailSettingDetailUser WHERE ");

				if (name == null) {
					query.append("email_name LIKE null");
				}
				else {
					query.append("email_name LIKE ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (name != null) {
					qPos.add(name);
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewEmailSettingDetailUser>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_EMAILNAME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewEmailSettingDetailUser> findByEmailName(String name,
		int start, int end) throws SystemException {
		return findByEmailName(name, start, end, null);
	}

	public List<LmisViewEmailSettingDetailUser> findByEmailName(String name,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				name,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewEmailSettingDetailUser> list = (List<LmisViewEmailSettingDetailUser>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_EMAILNAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewEmailSettingDetailUser WHERE ");

				if (name == null) {
					query.append("email_name LIKE null");
				}
				else {
					query.append("email_name LIKE ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (name != null) {
					qPos.add(name);
				}

				list = (List<LmisViewEmailSettingDetailUser>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewEmailSettingDetailUser>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_EMAILNAME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewEmailSettingDetailUser findByEmailName_First(String name,
		OrderByComparator obc)
		throws NoSuchLmisViewEmailSettingDetailUserException, SystemException {
		List<LmisViewEmailSettingDetailUser> list = findByEmailName(name, 0, 1,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No LmisViewEmailSettingDetailUser exists with the key {");

			msg.append("name=" + name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewEmailSettingDetailUserException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewEmailSettingDetailUser findByEmailName_Last(String name,
		OrderByComparator obc)
		throws NoSuchLmisViewEmailSettingDetailUserException, SystemException {
		int count = countByEmailName(name);

		List<LmisViewEmailSettingDetailUser> list = findByEmailName(name,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No LmisViewEmailSettingDetailUser exists with the key {");

			msg.append("name=" + name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewEmailSettingDetailUserException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewEmailSettingDetailUser[] findByEmailName_PrevAndNext(
		Integer userRelatedId, String name, OrderByComparator obc)
		throws NoSuchLmisViewEmailSettingDetailUserException, SystemException {
		LmisViewEmailSettingDetailUser lmisViewEmailSettingDetailUser = findByPrimaryKey(userRelatedId);

		int count = countByEmailName(name);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewEmailSettingDetailUser WHERE ");

			if (name == null) {
				query.append("email_name LIKE null");
			}
			else {
				query.append("email_name LIKE ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (name != null) {
				qPos.add(name);
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisViewEmailSettingDetailUser);

			LmisViewEmailSettingDetailUser[] array = new LmisViewEmailSettingDetailUserImpl[3];

			array[0] = (LmisViewEmailSettingDetailUser)objArray[0];
			array[1] = (LmisViewEmailSettingDetailUser)objArray[1];
			array[2] = (LmisViewEmailSettingDetailUser)objArray[2];

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

	public List<LmisViewEmailSettingDetailUser> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<LmisViewEmailSettingDetailUser> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<LmisViewEmailSettingDetailUser> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewEmailSettingDetailUser> list = (List<LmisViewEmailSettingDetailUser>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewEmailSettingDetailUser ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<LmisViewEmailSettingDetailUser>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LmisViewEmailSettingDetailUser>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewEmailSettingDetailUser>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByEmailType(String emailType) throws SystemException {
		for (LmisViewEmailSettingDetailUser lmisViewEmailSettingDetailUser : findByEmailType(
				emailType)) {
			remove(lmisViewEmailSettingDetailUser);
		}
	}

	public void removeByRootID(int rootId) throws SystemException {
		for (LmisViewEmailSettingDetailUser lmisViewEmailSettingDetailUser : findByRootID(
				rootId)) {
			remove(lmisViewEmailSettingDetailUser);
		}
	}

	public void removeByID(int id_) throws SystemException {
		for (LmisViewEmailSettingDetailUser lmisViewEmailSettingDetailUser : findByID(
				id_)) {
			remove(lmisViewEmailSettingDetailUser);
		}
	}

	public void removeByCategory(int category) throws SystemException {
		for (LmisViewEmailSettingDetailUser lmisViewEmailSettingDetailUser : findByCategory(
				category)) {
			remove(lmisViewEmailSettingDetailUser);
		}
	}

	public void removeByEmailName(String name) throws SystemException {
		for (LmisViewEmailSettingDetailUser lmisViewEmailSettingDetailUser : findByEmailName(
				name)) {
			remove(lmisViewEmailSettingDetailUser);
		}
	}

	public void removeAll() throws SystemException {
		for (LmisViewEmailSettingDetailUser lmisViewEmailSettingDetailUser : findAll()) {
			remove(lmisViewEmailSettingDetailUser);
		}
	}

	public int countByEmailType(String emailType) throws SystemException {
		Object[] finderArgs = new Object[] { emailType };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_EMAILTYPE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisViewEmailSettingDetailUser WHERE ");

				if (emailType == null) {
					query.append("email_type LIKE null");
				}
				else {
					query.append("email_type LIKE ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (emailType != null) {
					qPos.add(emailType);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMAILTYPE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
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
					"FROM larion.progate.lmis.model.LmisViewEmailSettingDetailUser WHERE ");

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

	public int countByID(int id_) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(id_) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisViewEmailSettingDetailUser WHERE ");

				query.append("id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ID, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByCategory(int category) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(category) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CATEGORY,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisViewEmailSettingDetailUser WHERE ");

				query.append("category = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(category);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CATEGORY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByEmailName(String name) throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_EMAILNAME,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisViewEmailSettingDetailUser WHERE ");

				if (name == null) {
					query.append("email_name LIKE null");
				}
				else {
					query.append("email_name LIKE ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (name != null) {
					qPos.add(name);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMAILNAME,
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
						"SELECT COUNT(*) FROM larion.progate.lmis.model.LmisViewEmailSettingDetailUser");

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
						"value.object.listener.larion.progate.lmis.model.LmisViewEmailSettingDetailUser")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LmisViewEmailSettingDetailUser>> listenersList =
					new ArrayList<ModelListener<LmisViewEmailSettingDetailUser>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LmisViewEmailSettingDetailUser>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(LmisViewEmailSettingDetailUserPersistenceImpl.class);
}