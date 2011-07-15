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

import larion.progate.NoSuchUserException;

import larion.progate.model.User;
import larion.progate.model.impl.UserImpl;
import larion.progate.model.impl.UserModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="UserPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class UserPersistenceImpl extends BasePersistenceImpl
	implements UserPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = UserImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_SCREENNAME = new FinderPath(UserModelImpl.ENTITY_CACHE_ENABLED,
			UserModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByscreenname", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_SCREENNAME = new FinderPath(UserModelImpl.ENTITY_CACHE_ENABLED,
			UserModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByscreenname",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_SCREENNAME = new FinderPath(UserModelImpl.ENTITY_CACHE_ENABLED,
			UserModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByscreenname", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ISPROACTIVE = new FinderPath(UserModelImpl.ENTITY_CACHE_ENABLED,
			UserModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByisProActive", new String[] { Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ISPROACTIVE = new FinderPath(UserModelImpl.ENTITY_CACHE_ENABLED,
			UserModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByisProActive",
			new String[] {
				Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ISPROACTIVE = new FinderPath(UserModelImpl.ENTITY_CACHE_ENABLED,
			UserModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByisProActive", new String[] { Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_STATUS = new FinderPath(UserModelImpl.ENTITY_CACHE_ENABLED,
			UserModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findBystatus", new String[] { Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_STATUS = new FinderPath(UserModelImpl.ENTITY_CACHE_ENABLED,
			UserModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findBystatus",
			new String[] {
				Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(UserModelImpl.ENTITY_CACHE_ENABLED,
			UserModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countBystatus", new String[] { Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_EMAILADDRESS = new FinderPath(UserModelImpl.ENTITY_CACHE_ENABLED,
			UserModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByemailaddress", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_EMAILADDRESS = new FinderPath(UserModelImpl.ENTITY_CACHE_ENABLED,
			UserModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByemailaddress",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_EMAILADDRESS = new FinderPath(UserModelImpl.ENTITY_CACHE_ENABLED,
			UserModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByemailaddress", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_FIRSTNAME = new FinderPath(UserModelImpl.ENTITY_CACHE_ENABLED,
			UserModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByfirstname", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_FIRSTNAME = new FinderPath(UserModelImpl.ENTITY_CACHE_ENABLED,
			UserModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByfirstname",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_FIRSTNAME = new FinderPath(UserModelImpl.ENTITY_CACHE_ENABLED,
			UserModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByfirstname", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_MIDDLENAME = new FinderPath(UserModelImpl.ENTITY_CACHE_ENABLED,
			UserModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findBymiddlename", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_MIDDLENAME = new FinderPath(UserModelImpl.ENTITY_CACHE_ENABLED,
			UserModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findBymiddlename",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_MIDDLENAME = new FinderPath(UserModelImpl.ENTITY_CACHE_ENABLED,
			UserModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countBymiddlename", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_LASTNAME = new FinderPath(UserModelImpl.ENTITY_CACHE_ENABLED,
			UserModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findBylastname", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_LASTNAME = new FinderPath(UserModelImpl.ENTITY_CACHE_ENABLED,
			UserModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findBylastname",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_LASTNAME = new FinderPath(UserModelImpl.ENTITY_CACHE_ENABLED,
			UserModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countBylastname", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ACTIVE = new FinderPath(UserModelImpl.ENTITY_CACHE_ENABLED,
			UserModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByactive", new String[] { Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ACTIVE = new FinderPath(UserModelImpl.ENTITY_CACHE_ENABLED,
			UserModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByactive",
			new String[] {
				Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVE = new FinderPath(UserModelImpl.ENTITY_CACHE_ENABLED,
			UserModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByactive", new String[] { Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(UserModelImpl.ENTITY_CACHE_ENABLED,
			UserModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UserModelImpl.ENTITY_CACHE_ENABLED,
			UserModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	public void cacheResult(User user) {
		EntityCacheUtil.putResult(UserModelImpl.ENTITY_CACHE_ENABLED,
			UserImpl.class, user.getPrimaryKey(), user);
	}

	public void cacheResult(List<User> users) {
		for (User user : users) {
			if (EntityCacheUtil.getResult(UserModelImpl.ENTITY_CACHE_ENABLED,
						UserImpl.class, user.getPrimaryKey(), this) == null) {
				cacheResult(user);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(UserImpl.class.getName());
		EntityCacheUtil.clearCache(UserImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public User create(Integer userid) {
		User user = new UserImpl();

		user.setNew(true);
		user.setPrimaryKey(userid);

		return user;
	}

	public User remove(Integer userid)
		throws NoSuchUserException, SystemException {
		Session session = null;

		try {
			session = openSession();

			User user = (User)session.get(UserImpl.class, userid);

			if (user == null) {
				if (_log.isWarnEnabled()) {
					_log.warn("No User exists with the primary key " + userid);
				}

				throw new NoSuchUserException(
					"No User exists with the primary key " + userid);
			}

			return remove(user);
		}
		catch (NoSuchUserException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public User remove(User user) throws SystemException {
		for (ModelListener<User> listener : listeners) {
			listener.onBeforeRemove(user);
		}

		user = removeImpl(user);

		for (ModelListener<User> listener : listeners) {
			listener.onAfterRemove(user);
		}

		return user;
	}

	protected User removeImpl(User user) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (user.isCachedModel() || BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(UserImpl.class,
						user.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(user);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(UserModelImpl.ENTITY_CACHE_ENABLED,
			UserImpl.class, user.getPrimaryKey());

		return user;
	}

	public User update(User user) throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(User user) method. Use update(User user, boolean merge) instead.");
		}

		return update(user, false);
	}

	public User update(User user, boolean merge) throws SystemException {
		boolean isNew = user.isNew();

		for (ModelListener<User> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(user);
			}
			else {
				listener.onBeforeUpdate(user);
			}
		}

		user = updateImpl(user, merge);

		for (ModelListener<User> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(user);
			}
			else {
				listener.onAfterUpdate(user);
			}
		}

		return user;
	}

	public User updateImpl(larion.progate.model.User user, boolean merge)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, user, merge);

			user.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(UserModelImpl.ENTITY_CACHE_ENABLED,
			UserImpl.class, user.getPrimaryKey(), user);

		return user;
	}

	public User findByPrimaryKey(Integer userid)
		throws NoSuchUserException, SystemException {
		User user = fetchByPrimaryKey(userid);

		if (user == null) {
			if (_log.isWarnEnabled()) {
				_log.warn("No User exists with the primary key " + userid);
			}

			throw new NoSuchUserException(
				"No User exists with the primary key " + userid);
		}

		return user;
	}

	public User fetchByPrimaryKey(Integer userid) throws SystemException {
		User user = (User)EntityCacheUtil.getResult(UserModelImpl.ENTITY_CACHE_ENABLED,
				UserImpl.class, userid, this);

		if (user == null) {
			Session session = null;

			try {
				session = openSession();

				user = (User)session.get(UserImpl.class, userid);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (user != null) {
					cacheResult(user);
				}

				closeSession(session);
			}
		}

		return user;
	}

	public List<User> findByscreenname(String screenname)
		throws SystemException {
		Object[] finderArgs = new Object[] { screenname };

		List<User> list = (List<User>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_SCREENNAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.User WHERE ");

				if (screenname == null) {
					query.append("screenname LIKE null");
				}
				else {
					query.append("screenname LIKE ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("screenname ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (screenname != null) {
					qPos.add(screenname);
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<User>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_SCREENNAME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<User> findByscreenname(String screenname, int start, int end)
		throws SystemException {
		return findByscreenname(screenname, start, end, null);
	}

	public List<User> findByscreenname(String screenname, int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				screenname,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<User> list = (List<User>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_SCREENNAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.User WHERE ");

				if (screenname == null) {
					query.append("screenname LIKE null");
				}
				else {
					query.append("screenname LIKE ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("screenname ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (screenname != null) {
					qPos.add(screenname);
				}

				list = (List<User>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<User>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_SCREENNAME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public User findByscreenname_First(String screenname, OrderByComparator obc)
		throws NoSuchUserException, SystemException {
		List<User> list = findByscreenname(screenname, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No User exists with the key {");

			msg.append("screenname=" + screenname);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public User findByscreenname_Last(String screenname, OrderByComparator obc)
		throws NoSuchUserException, SystemException {
		int count = countByscreenname(screenname);

		List<User> list = findByscreenname(screenname, count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No User exists with the key {");

			msg.append("screenname=" + screenname);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public User[] findByscreenname_PrevAndNext(Integer userid,
		String screenname, OrderByComparator obc)
		throws NoSuchUserException, SystemException {
		User user = findByPrimaryKey(userid);

		int count = countByscreenname(screenname);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.User WHERE ");

			if (screenname == null) {
				query.append("screenname LIKE null");
			}
			else {
				query.append("screenname LIKE ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("screenname ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (screenname != null) {
				qPos.add(screenname);
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, user);

			User[] array = new UserImpl[3];

			array[0] = (User)objArray[0];
			array[1] = (User)objArray[1];
			array[2] = (User)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<User> findByisProActive(boolean isProActive)
		throws SystemException {
		Object[] finderArgs = new Object[] { Boolean.valueOf(isProActive) };

		List<User> list = (List<User>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ISPROACTIVE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.User WHERE ");

				query.append("is_proactive = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("screenname ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isProActive);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<User>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ISPROACTIVE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<User> findByisProActive(boolean isProActive, int start, int end)
		throws SystemException {
		return findByisProActive(isProActive, start, end, null);
	}

	public List<User> findByisProActive(boolean isProActive, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				Boolean.valueOf(isProActive),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<User> list = (List<User>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ISPROACTIVE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.User WHERE ");

				query.append("is_proactive = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("screenname ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isProActive);

				list = (List<User>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<User>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ISPROACTIVE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public User findByisProActive_First(boolean isProActive,
		OrderByComparator obc) throws NoSuchUserException, SystemException {
		List<User> list = findByisProActive(isProActive, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No User exists with the key {");

			msg.append("isProActive=" + isProActive);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public User findByisProActive_Last(boolean isProActive,
		OrderByComparator obc) throws NoSuchUserException, SystemException {
		int count = countByisProActive(isProActive);

		List<User> list = findByisProActive(isProActive, count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No User exists with the key {");

			msg.append("isProActive=" + isProActive);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public User[] findByisProActive_PrevAndNext(Integer userid,
		boolean isProActive, OrderByComparator obc)
		throws NoSuchUserException, SystemException {
		User user = findByPrimaryKey(userid);

		int count = countByisProActive(isProActive);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.User WHERE ");

			query.append("is_proactive = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("screenname ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(isProActive);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, user);

			User[] array = new UserImpl[3];

			array[0] = (User)objArray[0];
			array[1] = (User)objArray[1];
			array[2] = (User)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<User> findBystatus(boolean status) throws SystemException {
		Object[] finderArgs = new Object[] { Boolean.valueOf(status) };

		List<User> list = (List<User>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_STATUS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.User WHERE ");

				query.append("status = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("screenname ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<User>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_STATUS,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<User> findBystatus(boolean status, int start, int end)
		throws SystemException {
		return findBystatus(status, start, end, null);
	}

	public List<User> findBystatus(boolean status, int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				Boolean.valueOf(status),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<User> list = (List<User>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_STATUS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.User WHERE ");

				query.append("status = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("screenname ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				list = (List<User>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<User>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_STATUS,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public User findBystatus_First(boolean status, OrderByComparator obc)
		throws NoSuchUserException, SystemException {
		List<User> list = findBystatus(status, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No User exists with the key {");

			msg.append("status=" + status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public User findBystatus_Last(boolean status, OrderByComparator obc)
		throws NoSuchUserException, SystemException {
		int count = countBystatus(status);

		List<User> list = findBystatus(status, count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No User exists with the key {");

			msg.append("status=" + status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public User[] findBystatus_PrevAndNext(Integer userid, boolean status,
		OrderByComparator obc) throws NoSuchUserException, SystemException {
		User user = findByPrimaryKey(userid);

		int count = countBystatus(status);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.User WHERE ");

			query.append("status = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("screenname ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(status);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, user);

			User[] array = new UserImpl[3];

			array[0] = (User)objArray[0];
			array[1] = (User)objArray[1];
			array[2] = (User)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<User> findByemailaddress(String emailaddress)
		throws SystemException {
		Object[] finderArgs = new Object[] { emailaddress };

		List<User> list = (List<User>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_EMAILADDRESS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.User WHERE ");

				if (emailaddress == null) {
					query.append("emailaddress LIKE null");
				}
				else {
					query.append("emailaddress LIKE ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("screenname ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (emailaddress != null) {
					qPos.add(emailaddress);
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<User>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_EMAILADDRESS,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<User> findByemailaddress(String emailaddress, int start, int end)
		throws SystemException {
		return findByemailaddress(emailaddress, start, end, null);
	}

	public List<User> findByemailaddress(String emailaddress, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				emailaddress,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<User> list = (List<User>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_EMAILADDRESS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.User WHERE ");

				if (emailaddress == null) {
					query.append("emailaddress LIKE null");
				}
				else {
					query.append("emailaddress LIKE ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("screenname ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (emailaddress != null) {
					qPos.add(emailaddress);
				}

				list = (List<User>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<User>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_EMAILADDRESS,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public User findByemailaddress_First(String emailaddress,
		OrderByComparator obc) throws NoSuchUserException, SystemException {
		List<User> list = findByemailaddress(emailaddress, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No User exists with the key {");

			msg.append("emailaddress=" + emailaddress);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public User findByemailaddress_Last(String emailaddress,
		OrderByComparator obc) throws NoSuchUserException, SystemException {
		int count = countByemailaddress(emailaddress);

		List<User> list = findByemailaddress(emailaddress, count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No User exists with the key {");

			msg.append("emailaddress=" + emailaddress);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public User[] findByemailaddress_PrevAndNext(Integer userid,
		String emailaddress, OrderByComparator obc)
		throws NoSuchUserException, SystemException {
		User user = findByPrimaryKey(userid);

		int count = countByemailaddress(emailaddress);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.User WHERE ");

			if (emailaddress == null) {
				query.append("emailaddress LIKE null");
			}
			else {
				query.append("emailaddress LIKE ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("screenname ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (emailaddress != null) {
				qPos.add(emailaddress);
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, user);

			User[] array = new UserImpl[3];

			array[0] = (User)objArray[0];
			array[1] = (User)objArray[1];
			array[2] = (User)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<User> findByfirstname(String firstname)
		throws SystemException {
		Object[] finderArgs = new Object[] { firstname };

		List<User> list = (List<User>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_FIRSTNAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.User WHERE ");

				if (firstname == null) {
					query.append("firstname LIKE null");
				}
				else {
					query.append("firstname LIKE ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("screenname ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (firstname != null) {
					qPos.add(firstname);
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<User>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_FIRSTNAME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<User> findByfirstname(String firstname, int start, int end)
		throws SystemException {
		return findByfirstname(firstname, start, end, null);
	}

	public List<User> findByfirstname(String firstname, int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				firstname,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<User> list = (List<User>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_FIRSTNAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.User WHERE ");

				if (firstname == null) {
					query.append("firstname LIKE null");
				}
				else {
					query.append("firstname LIKE ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("screenname ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (firstname != null) {
					qPos.add(firstname);
				}

				list = (List<User>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<User>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_FIRSTNAME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public User findByfirstname_First(String firstname, OrderByComparator obc)
		throws NoSuchUserException, SystemException {
		List<User> list = findByfirstname(firstname, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No User exists with the key {");

			msg.append("firstname=" + firstname);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public User findByfirstname_Last(String firstname, OrderByComparator obc)
		throws NoSuchUserException, SystemException {
		int count = countByfirstname(firstname);

		List<User> list = findByfirstname(firstname, count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No User exists with the key {");

			msg.append("firstname=" + firstname);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public User[] findByfirstname_PrevAndNext(Integer userid, String firstname,
		OrderByComparator obc) throws NoSuchUserException, SystemException {
		User user = findByPrimaryKey(userid);

		int count = countByfirstname(firstname);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.User WHERE ");

			if (firstname == null) {
				query.append("firstname LIKE null");
			}
			else {
				query.append("firstname LIKE ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("screenname ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (firstname != null) {
				qPos.add(firstname);
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, user);

			User[] array = new UserImpl[3];

			array[0] = (User)objArray[0];
			array[1] = (User)objArray[1];
			array[2] = (User)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<User> findBymiddlename(String middlename)
		throws SystemException {
		Object[] finderArgs = new Object[] { middlename };

		List<User> list = (List<User>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_MIDDLENAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.User WHERE ");

				if (middlename == null) {
					query.append("middlename LIKE null");
				}
				else {
					query.append("middlename LIKE ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("screenname ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (middlename != null) {
					qPos.add(middlename);
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<User>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_MIDDLENAME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<User> findBymiddlename(String middlename, int start, int end)
		throws SystemException {
		return findBymiddlename(middlename, start, end, null);
	}

	public List<User> findBymiddlename(String middlename, int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				middlename,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<User> list = (List<User>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_MIDDLENAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.User WHERE ");

				if (middlename == null) {
					query.append("middlename LIKE null");
				}
				else {
					query.append("middlename LIKE ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("screenname ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (middlename != null) {
					qPos.add(middlename);
				}

				list = (List<User>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<User>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_MIDDLENAME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public User findBymiddlename_First(String middlename, OrderByComparator obc)
		throws NoSuchUserException, SystemException {
		List<User> list = findBymiddlename(middlename, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No User exists with the key {");

			msg.append("middlename=" + middlename);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public User findBymiddlename_Last(String middlename, OrderByComparator obc)
		throws NoSuchUserException, SystemException {
		int count = countBymiddlename(middlename);

		List<User> list = findBymiddlename(middlename, count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No User exists with the key {");

			msg.append("middlename=" + middlename);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public User[] findBymiddlename_PrevAndNext(Integer userid,
		String middlename, OrderByComparator obc)
		throws NoSuchUserException, SystemException {
		User user = findByPrimaryKey(userid);

		int count = countBymiddlename(middlename);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.User WHERE ");

			if (middlename == null) {
				query.append("middlename LIKE null");
			}
			else {
				query.append("middlename LIKE ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("screenname ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (middlename != null) {
				qPos.add(middlename);
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, user);

			User[] array = new UserImpl[3];

			array[0] = (User)objArray[0];
			array[1] = (User)objArray[1];
			array[2] = (User)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<User> findBylastname(String lastname) throws SystemException {
		Object[] finderArgs = new Object[] { lastname };

		List<User> list = (List<User>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_LASTNAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.User WHERE ");

				if (lastname == null) {
					query.append("lastname LIKE null");
				}
				else {
					query.append("lastname LIKE ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("screenname ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (lastname != null) {
					qPos.add(lastname);
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<User>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_LASTNAME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<User> findBylastname(String lastname, int start, int end)
		throws SystemException {
		return findBylastname(lastname, start, end, null);
	}

	public List<User> findBylastname(String lastname, int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				lastname,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<User> list = (List<User>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_LASTNAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.User WHERE ");

				if (lastname == null) {
					query.append("lastname LIKE null");
				}
				else {
					query.append("lastname LIKE ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("screenname ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (lastname != null) {
					qPos.add(lastname);
				}

				list = (List<User>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<User>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_LASTNAME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public User findBylastname_First(String lastname, OrderByComparator obc)
		throws NoSuchUserException, SystemException {
		List<User> list = findBylastname(lastname, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No User exists with the key {");

			msg.append("lastname=" + lastname);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public User findBylastname_Last(String lastname, OrderByComparator obc)
		throws NoSuchUserException, SystemException {
		int count = countBylastname(lastname);

		List<User> list = findBylastname(lastname, count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No User exists with the key {");

			msg.append("lastname=" + lastname);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public User[] findBylastname_PrevAndNext(Integer userid, String lastname,
		OrderByComparator obc) throws NoSuchUserException, SystemException {
		User user = findByPrimaryKey(userid);

		int count = countBylastname(lastname);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.User WHERE ");

			if (lastname == null) {
				query.append("lastname LIKE null");
			}
			else {
				query.append("lastname LIKE ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("screenname ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (lastname != null) {
				qPos.add(lastname);
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, user);

			User[] array = new UserImpl[3];

			array[0] = (User)objArray[0];
			array[1] = (User)objArray[1];
			array[2] = (User)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<User> findByactive(boolean active) throws SystemException {
		Object[] finderArgs = new Object[] { Boolean.valueOf(active) };

		List<User> list = (List<User>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ACTIVE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.User WHERE ");

				query.append("active_ LIKE ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("screenname ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(active);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<User>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ACTIVE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<User> findByactive(boolean active, int start, int end)
		throws SystemException {
		return findByactive(active, start, end, null);
	}

	public List<User> findByactive(boolean active, int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				Boolean.valueOf(active),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<User> list = (List<User>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ACTIVE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.User WHERE ");

				query.append("active_ LIKE ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("screenname ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(active);

				list = (List<User>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<User>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ACTIVE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public User findByactive_First(boolean active, OrderByComparator obc)
		throws NoSuchUserException, SystemException {
		List<User> list = findByactive(active, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No User exists with the key {");

			msg.append("active=" + active);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public User findByactive_Last(boolean active, OrderByComparator obc)
		throws NoSuchUserException, SystemException {
		int count = countByactive(active);

		List<User> list = findByactive(active, count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No User exists with the key {");

			msg.append("active=" + active);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public User[] findByactive_PrevAndNext(Integer userid, boolean active,
		OrderByComparator obc) throws NoSuchUserException, SystemException {
		User user = findByPrimaryKey(userid);

		int count = countByactive(active);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.User WHERE ");

			query.append("active_ LIKE ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("screenname ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(active);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, user);

			User[] array = new UserImpl[3];

			array[0] = (User)objArray[0];
			array[1] = (User)objArray[1];
			array[2] = (User)objArray[2];

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

	public List<User> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<User> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	public List<User> findAll(int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<User> list = (List<User>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.User ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("screenname ASC");
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<User>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<User>)QueryUtil.list(q, getDialect(), start,
							end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<User>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByscreenname(String screenname) throws SystemException {
		for (User user : findByscreenname(screenname)) {
			remove(user);
		}
	}

	public void removeByisProActive(boolean isProActive)
		throws SystemException {
		for (User user : findByisProActive(isProActive)) {
			remove(user);
		}
	}

	public void removeBystatus(boolean status) throws SystemException {
		for (User user : findBystatus(status)) {
			remove(user);
		}
	}

	public void removeByemailaddress(String emailaddress)
		throws SystemException {
		for (User user : findByemailaddress(emailaddress)) {
			remove(user);
		}
	}

	public void removeByfirstname(String firstname) throws SystemException {
		for (User user : findByfirstname(firstname)) {
			remove(user);
		}
	}

	public void removeBymiddlename(String middlename) throws SystemException {
		for (User user : findBymiddlename(middlename)) {
			remove(user);
		}
	}

	public void removeBylastname(String lastname) throws SystemException {
		for (User user : findBylastname(lastname)) {
			remove(user);
		}
	}

	public void removeByactive(boolean active) throws SystemException {
		for (User user : findByactive(active)) {
			remove(user);
		}
	}

	public void removeAll() throws SystemException {
		for (User user : findAll()) {
			remove(user);
		}
	}

	public int countByscreenname(String screenname) throws SystemException {
		Object[] finderArgs = new Object[] { screenname };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_SCREENNAME,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append("FROM larion.progate.model.User WHERE ");

				if (screenname == null) {
					query.append("screenname LIKE null");
				}
				else {
					query.append("screenname LIKE ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (screenname != null) {
					qPos.add(screenname);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SCREENNAME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByisProActive(boolean isProActive)
		throws SystemException {
		Object[] finderArgs = new Object[] { Boolean.valueOf(isProActive) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ISPROACTIVE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append("FROM larion.progate.model.User WHERE ");

				query.append("is_proactive = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isProActive);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ISPROACTIVE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countBystatus(boolean status) throws SystemException {
		Object[] finderArgs = new Object[] { Boolean.valueOf(status) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_STATUS,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append("FROM larion.progate.model.User WHERE ");

				query.append("status = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STATUS,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByemailaddress(String emailaddress)
		throws SystemException {
		Object[] finderArgs = new Object[] { emailaddress };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_EMAILADDRESS,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append("FROM larion.progate.model.User WHERE ");

				if (emailaddress == null) {
					query.append("emailaddress LIKE null");
				}
				else {
					query.append("emailaddress LIKE ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (emailaddress != null) {
					qPos.add(emailaddress);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMAILADDRESS,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByfirstname(String firstname) throws SystemException {
		Object[] finderArgs = new Object[] { firstname };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FIRSTNAME,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append("FROM larion.progate.model.User WHERE ");

				if (firstname == null) {
					query.append("firstname LIKE null");
				}
				else {
					query.append("firstname LIKE ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (firstname != null) {
					qPos.add(firstname);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FIRSTNAME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countBymiddlename(String middlename) throws SystemException {
		Object[] finderArgs = new Object[] { middlename };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MIDDLENAME,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append("FROM larion.progate.model.User WHERE ");

				if (middlename == null) {
					query.append("middlename LIKE null");
				}
				else {
					query.append("middlename LIKE ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (middlename != null) {
					qPos.add(middlename);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MIDDLENAME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countBylastname(String lastname) throws SystemException {
		Object[] finderArgs = new Object[] { lastname };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_LASTNAME,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append("FROM larion.progate.model.User WHERE ");

				if (lastname == null) {
					query.append("lastname LIKE null");
				}
				else {
					query.append("lastname LIKE ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (lastname != null) {
					qPos.add(lastname);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LASTNAME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByactive(boolean active) throws SystemException {
		Object[] finderArgs = new Object[] { Boolean.valueOf(active) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ACTIVE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append("FROM larion.progate.model.User WHERE ");

				query.append("active_ LIKE ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(active);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ACTIVE,
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
						"SELECT COUNT(*) FROM larion.progate.model.User");

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
						"value.object.listener.larion.progate.model.User")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<User>> listenersList = new ArrayList<ModelListener<User>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<User>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(UserPersistenceImpl.class);
}