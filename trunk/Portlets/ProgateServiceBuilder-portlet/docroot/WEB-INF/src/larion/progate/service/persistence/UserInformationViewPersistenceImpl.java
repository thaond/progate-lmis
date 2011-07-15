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

import larion.progate.NoSuchUserInformationViewException;

import larion.progate.model.UserInformationView;
import larion.progate.model.impl.UserInformationViewImpl;
import larion.progate.model.impl.UserInformationViewModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="UserInformationViewPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class UserInformationViewPersistenceImpl extends BasePersistenceImpl
	implements UserInformationViewPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = UserInformationViewImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_USERID = new FinderPath(UserInformationViewModelImpl.ENTITY_CACHE_ENABLED,
			UserInformationViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByuserId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_USERID = new FinderPath(UserInformationViewModelImpl.ENTITY_CACHE_ENABLED,
			UserInformationViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByuserId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(UserInformationViewModelImpl.ENTITY_CACHE_ENABLED,
			UserInformationViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByuserId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ORGID = new FinderPath(UserInformationViewModelImpl.ENTITY_CACHE_ENABLED,
			UserInformationViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByorgId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ORGID = new FinderPath(UserInformationViewModelImpl.ENTITY_CACHE_ENABLED,
			UserInformationViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByorgId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGID = new FinderPath(UserInformationViewModelImpl.ENTITY_CACHE_ENABLED,
			UserInformationViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByorgId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ROLEID = new FinderPath(UserInformationViewModelImpl.ENTITY_CACHE_ENABLED,
			UserInformationViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByroleId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ROLEID = new FinderPath(UserInformationViewModelImpl.ENTITY_CACHE_ENABLED,
			UserInformationViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByroleId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ROLEID = new FinderPath(UserInformationViewModelImpl.ENTITY_CACHE_ENABLED,
			UserInformationViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByroleId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ISPROACTIVE = new FinderPath(UserInformationViewModelImpl.ENTITY_CACHE_ENABLED,
			UserInformationViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByisProActive",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ISPROACTIVE = new FinderPath(UserInformationViewModelImpl.ENTITY_CACHE_ENABLED,
			UserInformationViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByisProActive",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ISPROACTIVE = new FinderPath(UserInformationViewModelImpl.ENTITY_CACHE_ENABLED,
			UserInformationViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByisProActive",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_STATUS = new FinderPath(UserInformationViewModelImpl.ENTITY_CACHE_ENABLED,
			UserInformationViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBystatus",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_STATUS = new FinderPath(UserInformationViewModelImpl.ENTITY_CACHE_ENABLED,
			UserInformationViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBystatus",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(UserInformationViewModelImpl.ENTITY_CACHE_ENABLED,
			UserInformationViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBystatus",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_JOININGSTATUS = new FinderPath(UserInformationViewModelImpl.ENTITY_CACHE_ENABLED,
			UserInformationViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByjoiningStatus",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_JOININGSTATUS = new FinderPath(UserInformationViewModelImpl.ENTITY_CACHE_ENABLED,
			UserInformationViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByjoiningStatus",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_JOININGSTATUS = new FinderPath(UserInformationViewModelImpl.ENTITY_CACHE_ENABLED,
			UserInformationViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByjoiningStatus",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_SCREENNAME = new FinderPath(UserInformationViewModelImpl.ENTITY_CACHE_ENABLED,
			UserInformationViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByscreenName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_SCREENNAME = new FinderPath(UserInformationViewModelImpl.ENTITY_CACHE_ENABLED,
			UserInformationViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByscreenName",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_SCREENNAME = new FinderPath(UserInformationViewModelImpl.ENTITY_CACHE_ENABLED,
			UserInformationViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByscreenName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_EMAILADDRESS = new FinderPath(UserInformationViewModelImpl.ENTITY_CACHE_ENABLED,
			UserInformationViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByemailAddress",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_EMAILADDRESS = new FinderPath(UserInformationViewModelImpl.ENTITY_CACHE_ENABLED,
			UserInformationViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByemailAddress",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_EMAILADDRESS = new FinderPath(UserInformationViewModelImpl.ENTITY_CACHE_ENABLED,
			UserInformationViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByemailAddress",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_FIRSTNAME = new FinderPath(UserInformationViewModelImpl.ENTITY_CACHE_ENABLED,
			UserInformationViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByfirstName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_FIRSTNAME = new FinderPath(UserInformationViewModelImpl.ENTITY_CACHE_ENABLED,
			UserInformationViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByfirstName",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_FIRSTNAME = new FinderPath(UserInformationViewModelImpl.ENTITY_CACHE_ENABLED,
			UserInformationViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByfirstName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_LASTNAME = new FinderPath(UserInformationViewModelImpl.ENTITY_CACHE_ENABLED,
			UserInformationViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBylastName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_LASTNAME = new FinderPath(UserInformationViewModelImpl.ENTITY_CACHE_ENABLED,
			UserInformationViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBylastName",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_LASTNAME = new FinderPath(UserInformationViewModelImpl.ENTITY_CACHE_ENABLED,
			UserInformationViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBylastName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ISCURRENT = new FinderPath(UserInformationViewModelImpl.ENTITY_CACHE_ENABLED,
			UserInformationViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByisCurrent",
			new String[] { Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ISCURRENT = new FinderPath(UserInformationViewModelImpl.ENTITY_CACHE_ENABLED,
			UserInformationViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByisCurrent",
			new String[] {
				Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ISCURRENT = new FinderPath(UserInformationViewModelImpl.ENTITY_CACHE_ENABLED,
			UserInformationViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByisCurrent",
			new String[] { Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_SEARCHINFORMATION = new FinderPath(UserInformationViewModelImpl.ENTITY_CACHE_ENABLED,
			UserInformationViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBysearchInformation",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_SEARCHINFORMATION = new FinderPath(UserInformationViewModelImpl.ENTITY_CACHE_ENABLED,
			UserInformationViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBysearchInformation",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_SEARCHINFORMATION = new FinderPath(UserInformationViewModelImpl.ENTITY_CACHE_ENABLED,
			UserInformationViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBysearchInformation",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(UserInformationViewModelImpl.ENTITY_CACHE_ENABLED,
			UserInformationViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UserInformationViewModelImpl.ENTITY_CACHE_ENABLED,
			UserInformationViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(UserInformationView userInformationView) {
		EntityCacheUtil.putResult(UserInformationViewModelImpl.ENTITY_CACHE_ENABLED,
			UserInformationViewImpl.class, userInformationView.getPrimaryKey(),
			userInformationView);
	}

	public void cacheResult(List<UserInformationView> userInformationViews) {
		for (UserInformationView userInformationView : userInformationViews) {
			if (EntityCacheUtil.getResult(
						UserInformationViewModelImpl.ENTITY_CACHE_ENABLED,
						UserInformationViewImpl.class,
						userInformationView.getPrimaryKey(), this) == null) {
				cacheResult(userInformationView);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(UserInformationViewImpl.class.getName());
		EntityCacheUtil.clearCache(UserInformationViewImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public UserInformationView create(String UserInformationViewId) {
		UserInformationView userInformationView = new UserInformationViewImpl();

		userInformationView.setNew(true);
		userInformationView.setPrimaryKey(UserInformationViewId);

		return userInformationView;
	}

	public UserInformationView remove(String UserInformationViewId)
		throws NoSuchUserInformationViewException, SystemException {
		Session session = null;

		try {
			session = openSession();

			UserInformationView userInformationView = (UserInformationView)session.get(UserInformationViewImpl.class,
					UserInformationViewId);

			if (userInformationView == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No UserInformationView exists with the primary key " +
						UserInformationViewId);
				}

				throw new NoSuchUserInformationViewException(
					"No UserInformationView exists with the primary key " +
					UserInformationViewId);
			}

			return remove(userInformationView);
		}
		catch (NoSuchUserInformationViewException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public UserInformationView remove(UserInformationView userInformationView)
		throws SystemException {
		for (ModelListener<UserInformationView> listener : listeners) {
			listener.onBeforeRemove(userInformationView);
		}

		userInformationView = removeImpl(userInformationView);

		for (ModelListener<UserInformationView> listener : listeners) {
			listener.onAfterRemove(userInformationView);
		}

		return userInformationView;
	}

	protected UserInformationView removeImpl(
		UserInformationView userInformationView) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (userInformationView.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(UserInformationViewImpl.class,
						userInformationView.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(userInformationView);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(UserInformationViewModelImpl.ENTITY_CACHE_ENABLED,
			UserInformationViewImpl.class, userInformationView.getPrimaryKey());

		return userInformationView;
	}

	public UserInformationView update(UserInformationView userInformationView)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(UserInformationView userInformationView) method. Use update(UserInformationView userInformationView, boolean merge) instead.");
		}

		return update(userInformationView, false);
	}

	public UserInformationView update(UserInformationView userInformationView,
		boolean merge) throws SystemException {
		boolean isNew = userInformationView.isNew();

		for (ModelListener<UserInformationView> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(userInformationView);
			}
			else {
				listener.onBeforeUpdate(userInformationView);
			}
		}

		userInformationView = updateImpl(userInformationView, merge);

		for (ModelListener<UserInformationView> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(userInformationView);
			}
			else {
				listener.onAfterUpdate(userInformationView);
			}
		}

		return userInformationView;
	}

	public UserInformationView updateImpl(
		larion.progate.model.UserInformationView userInformationView,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, userInformationView, merge);

			userInformationView.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(UserInformationViewModelImpl.ENTITY_CACHE_ENABLED,
			UserInformationViewImpl.class, userInformationView.getPrimaryKey(),
			userInformationView);

		return userInformationView;
	}

	public UserInformationView findByPrimaryKey(String UserInformationViewId)
		throws NoSuchUserInformationViewException, SystemException {
		UserInformationView userInformationView = fetchByPrimaryKey(UserInformationViewId);

		if (userInformationView == null) {
			if (_log.isWarnEnabled()) {
				_log.warn("No UserInformationView exists with the primary key " +
					UserInformationViewId);
			}

			throw new NoSuchUserInformationViewException(
				"No UserInformationView exists with the primary key " +
				UserInformationViewId);
		}

		return userInformationView;
	}

	public UserInformationView fetchByPrimaryKey(String UserInformationViewId)
		throws SystemException {
		UserInformationView userInformationView = (UserInformationView)EntityCacheUtil.getResult(UserInformationViewModelImpl.ENTITY_CACHE_ENABLED,
				UserInformationViewImpl.class, UserInformationViewId, this);

		if (userInformationView == null) {
			Session session = null;

			try {
				session = openSession();

				userInformationView = (UserInformationView)session.get(UserInformationViewImpl.class,
						UserInformationViewId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (userInformationView != null) {
					cacheResult(userInformationView);
				}

				closeSession(session);
			}
		}

		return userInformationView;
	}

	public List<UserInformationView> findByuserId(int userId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(userId) };

		List<UserInformationView> list = (List<UserInformationView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_USERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.UserInformationView WHERE ");

				query.append("userid = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("screenname ASC");

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
					list = new ArrayList<UserInformationView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_USERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<UserInformationView> findByuserId(int userId, int start, int end)
		throws SystemException {
		return findByuserId(userId, start, end, null);
	}

	public List<UserInformationView> findByuserId(int userId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(userId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<UserInformationView> list = (List<UserInformationView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_USERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.UserInformationView WHERE ");

				query.append("userid = ?");

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

				qPos.add(userId);

				list = (List<UserInformationView>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<UserInformationView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_USERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public UserInformationView findByuserId_First(int userId,
		OrderByComparator obc)
		throws NoSuchUserInformationViewException, SystemException {
		List<UserInformationView> list = findByuserId(userId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No UserInformationView exists with the key {");

			msg.append("userId=" + userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserInformationViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public UserInformationView findByuserId_Last(int userId,
		OrderByComparator obc)
		throws NoSuchUserInformationViewException, SystemException {
		int count = countByuserId(userId);

		List<UserInformationView> list = findByuserId(userId, count - 1, count,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No UserInformationView exists with the key {");

			msg.append("userId=" + userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserInformationViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public UserInformationView[] findByuserId_PrevAndNext(
		String UserInformationViewId, int userId, OrderByComparator obc)
		throws NoSuchUserInformationViewException, SystemException {
		UserInformationView userInformationView = findByPrimaryKey(UserInformationViewId);

		int count = countByuserId(userId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.UserInformationView WHERE ");

			query.append("userid = ?");

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

			qPos.add(userId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					userInformationView);

			UserInformationView[] array = new UserInformationViewImpl[3];

			array[0] = (UserInformationView)objArray[0];
			array[1] = (UserInformationView)objArray[1];
			array[2] = (UserInformationView)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<UserInformationView> findByorgId(int orgId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(orgId) };

		List<UserInformationView> list = (List<UserInformationView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ORGID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.UserInformationView WHERE ");

				query.append("org_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("screenname ASC");

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
					list = new ArrayList<UserInformationView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ORGID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<UserInformationView> findByorgId(int orgId, int start, int end)
		throws SystemException {
		return findByorgId(orgId, start, end, null);
	}

	public List<UserInformationView> findByorgId(int orgId, int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(orgId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<UserInformationView> list = (List<UserInformationView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ORGID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.UserInformationView WHERE ");

				query.append("org_id = ?");

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

				qPos.add(orgId);

				list = (List<UserInformationView>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<UserInformationView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ORGID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public UserInformationView findByorgId_First(int orgId,
		OrderByComparator obc)
		throws NoSuchUserInformationViewException, SystemException {
		List<UserInformationView> list = findByorgId(orgId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No UserInformationView exists with the key {");

			msg.append("orgId=" + orgId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserInformationViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public UserInformationView findByorgId_Last(int orgId, OrderByComparator obc)
		throws NoSuchUserInformationViewException, SystemException {
		int count = countByorgId(orgId);

		List<UserInformationView> list = findByorgId(orgId, count - 1, count,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No UserInformationView exists with the key {");

			msg.append("orgId=" + orgId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserInformationViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public UserInformationView[] findByorgId_PrevAndNext(
		String UserInformationViewId, int orgId, OrderByComparator obc)
		throws NoSuchUserInformationViewException, SystemException {
		UserInformationView userInformationView = findByPrimaryKey(UserInformationViewId);

		int count = countByorgId(orgId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.UserInformationView WHERE ");

			query.append("org_id = ?");

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

			qPos.add(orgId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					userInformationView);

			UserInformationView[] array = new UserInformationViewImpl[3];

			array[0] = (UserInformationView)objArray[0];
			array[1] = (UserInformationView)objArray[1];
			array[2] = (UserInformationView)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<UserInformationView> findByroleId(int roleId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(roleId) };

		List<UserInformationView> list = (List<UserInformationView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ROLEID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.UserInformationView WHERE ");

				query.append("role_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("screenname ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(roleId);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<UserInformationView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ROLEID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<UserInformationView> findByroleId(int roleId, int start, int end)
		throws SystemException {
		return findByroleId(roleId, start, end, null);
	}

	public List<UserInformationView> findByroleId(int roleId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(roleId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<UserInformationView> list = (List<UserInformationView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ROLEID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.UserInformationView WHERE ");

				query.append("role_id = ?");

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

				qPos.add(roleId);

				list = (List<UserInformationView>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<UserInformationView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ROLEID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public UserInformationView findByroleId_First(int roleId,
		OrderByComparator obc)
		throws NoSuchUserInformationViewException, SystemException {
		List<UserInformationView> list = findByroleId(roleId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No UserInformationView exists with the key {");

			msg.append("roleId=" + roleId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserInformationViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public UserInformationView findByroleId_Last(int roleId,
		OrderByComparator obc)
		throws NoSuchUserInformationViewException, SystemException {
		int count = countByroleId(roleId);

		List<UserInformationView> list = findByroleId(roleId, count - 1, count,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No UserInformationView exists with the key {");

			msg.append("roleId=" + roleId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserInformationViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public UserInformationView[] findByroleId_PrevAndNext(
		String UserInformationViewId, int roleId, OrderByComparator obc)
		throws NoSuchUserInformationViewException, SystemException {
		UserInformationView userInformationView = findByPrimaryKey(UserInformationViewId);

		int count = countByroleId(roleId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.UserInformationView WHERE ");

			query.append("role_id = ?");

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

			qPos.add(roleId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					userInformationView);

			UserInformationView[] array = new UserInformationViewImpl[3];

			array[0] = (UserInformationView)objArray[0];
			array[1] = (UserInformationView)objArray[1];
			array[2] = (UserInformationView)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<UserInformationView> findByisProActive(int isProActive)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(isProActive) };

		List<UserInformationView> list = (List<UserInformationView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ISPROACTIVE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.UserInformationView WHERE ");

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
					list = new ArrayList<UserInformationView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ISPROACTIVE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<UserInformationView> findByisProActive(int isProActive,
		int start, int end) throws SystemException {
		return findByisProActive(isProActive, start, end, null);
	}

	public List<UserInformationView> findByisProActive(int isProActive,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(isProActive),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<UserInformationView> list = (List<UserInformationView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ISPROACTIVE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.UserInformationView WHERE ");

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

				list = (List<UserInformationView>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<UserInformationView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ISPROACTIVE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public UserInformationView findByisProActive_First(int isProActive,
		OrderByComparator obc)
		throws NoSuchUserInformationViewException, SystemException {
		List<UserInformationView> list = findByisProActive(isProActive, 0, 1,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No UserInformationView exists with the key {");

			msg.append("isProActive=" + isProActive);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserInformationViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public UserInformationView findByisProActive_Last(int isProActive,
		OrderByComparator obc)
		throws NoSuchUserInformationViewException, SystemException {
		int count = countByisProActive(isProActive);

		List<UserInformationView> list = findByisProActive(isProActive,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No UserInformationView exists with the key {");

			msg.append("isProActive=" + isProActive);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserInformationViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public UserInformationView[] findByisProActive_PrevAndNext(
		String UserInformationViewId, int isProActive, OrderByComparator obc)
		throws NoSuchUserInformationViewException, SystemException {
		UserInformationView userInformationView = findByPrimaryKey(UserInformationViewId);

		int count = countByisProActive(isProActive);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.UserInformationView WHERE ");

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

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					userInformationView);

			UserInformationView[] array = new UserInformationViewImpl[3];

			array[0] = (UserInformationView)objArray[0];
			array[1] = (UserInformationView)objArray[1];
			array[2] = (UserInformationView)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<UserInformationView> findBystatus(int status)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(status) };

		List<UserInformationView> list = (List<UserInformationView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_STATUS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.UserInformationView WHERE ");

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
					list = new ArrayList<UserInformationView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_STATUS,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<UserInformationView> findBystatus(int status, int start, int end)
		throws SystemException {
		return findBystatus(status, start, end, null);
	}

	public List<UserInformationView> findBystatus(int status, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(status),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<UserInformationView> list = (List<UserInformationView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_STATUS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.UserInformationView WHERE ");

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

				list = (List<UserInformationView>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<UserInformationView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_STATUS,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public UserInformationView findBystatus_First(int status,
		OrderByComparator obc)
		throws NoSuchUserInformationViewException, SystemException {
		List<UserInformationView> list = findBystatus(status, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No UserInformationView exists with the key {");

			msg.append("status=" + status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserInformationViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public UserInformationView findBystatus_Last(int status,
		OrderByComparator obc)
		throws NoSuchUserInformationViewException, SystemException {
		int count = countBystatus(status);

		List<UserInformationView> list = findBystatus(status, count - 1, count,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No UserInformationView exists with the key {");

			msg.append("status=" + status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserInformationViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public UserInformationView[] findBystatus_PrevAndNext(
		String UserInformationViewId, int status, OrderByComparator obc)
		throws NoSuchUserInformationViewException, SystemException {
		UserInformationView userInformationView = findByPrimaryKey(UserInformationViewId);

		int count = countBystatus(status);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.UserInformationView WHERE ");

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

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					userInformationView);

			UserInformationView[] array = new UserInformationViewImpl[3];

			array[0] = (UserInformationView)objArray[0];
			array[1] = (UserInformationView)objArray[1];
			array[2] = (UserInformationView)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<UserInformationView> findByjoiningStatus(int joiningStatus)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(joiningStatus) };

		List<UserInformationView> list = (List<UserInformationView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_JOININGSTATUS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.UserInformationView WHERE ");

				query.append("joining_status = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("screenname ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(joiningStatus);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<UserInformationView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_JOININGSTATUS,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<UserInformationView> findByjoiningStatus(int joiningStatus,
		int start, int end) throws SystemException {
		return findByjoiningStatus(joiningStatus, start, end, null);
	}

	public List<UserInformationView> findByjoiningStatus(int joiningStatus,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(joiningStatus),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<UserInformationView> list = (List<UserInformationView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_JOININGSTATUS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.UserInformationView WHERE ");

				query.append("joining_status = ?");

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

				qPos.add(joiningStatus);

				list = (List<UserInformationView>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<UserInformationView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_JOININGSTATUS,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public UserInformationView findByjoiningStatus_First(int joiningStatus,
		OrderByComparator obc)
		throws NoSuchUserInformationViewException, SystemException {
		List<UserInformationView> list = findByjoiningStatus(joiningStatus, 0,
				1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No UserInformationView exists with the key {");

			msg.append("joiningStatus=" + joiningStatus);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserInformationViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public UserInformationView findByjoiningStatus_Last(int joiningStatus,
		OrderByComparator obc)
		throws NoSuchUserInformationViewException, SystemException {
		int count = countByjoiningStatus(joiningStatus);

		List<UserInformationView> list = findByjoiningStatus(joiningStatus,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No UserInformationView exists with the key {");

			msg.append("joiningStatus=" + joiningStatus);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserInformationViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public UserInformationView[] findByjoiningStatus_PrevAndNext(
		String UserInformationViewId, int joiningStatus, OrderByComparator obc)
		throws NoSuchUserInformationViewException, SystemException {
		UserInformationView userInformationView = findByPrimaryKey(UserInformationViewId);

		int count = countByjoiningStatus(joiningStatus);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.UserInformationView WHERE ");

			query.append("joining_status = ?");

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

			qPos.add(joiningStatus);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					userInformationView);

			UserInformationView[] array = new UserInformationViewImpl[3];

			array[0] = (UserInformationView)objArray[0];
			array[1] = (UserInformationView)objArray[1];
			array[2] = (UserInformationView)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<UserInformationView> findByscreenName(String screenName)
		throws SystemException {
		Object[] finderArgs = new Object[] { screenName };

		List<UserInformationView> list = (List<UserInformationView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_SCREENNAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.UserInformationView WHERE ");

				if (screenName == null) {
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

				if (screenName != null) {
					qPos.add(screenName);
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<UserInformationView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_SCREENNAME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<UserInformationView> findByscreenName(String screenName,
		int start, int end) throws SystemException {
		return findByscreenName(screenName, start, end, null);
	}

	public List<UserInformationView> findByscreenName(String screenName,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				screenName,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<UserInformationView> list = (List<UserInformationView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_SCREENNAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.UserInformationView WHERE ");

				if (screenName == null) {
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

				if (screenName != null) {
					qPos.add(screenName);
				}

				list = (List<UserInformationView>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<UserInformationView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_SCREENNAME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public UserInformationView findByscreenName_First(String screenName,
		OrderByComparator obc)
		throws NoSuchUserInformationViewException, SystemException {
		List<UserInformationView> list = findByscreenName(screenName, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No UserInformationView exists with the key {");

			msg.append("screenName=" + screenName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserInformationViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public UserInformationView findByscreenName_Last(String screenName,
		OrderByComparator obc)
		throws NoSuchUserInformationViewException, SystemException {
		int count = countByscreenName(screenName);

		List<UserInformationView> list = findByscreenName(screenName,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No UserInformationView exists with the key {");

			msg.append("screenName=" + screenName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserInformationViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public UserInformationView[] findByscreenName_PrevAndNext(
		String UserInformationViewId, String screenName, OrderByComparator obc)
		throws NoSuchUserInformationViewException, SystemException {
		UserInformationView userInformationView = findByPrimaryKey(UserInformationViewId);

		int count = countByscreenName(screenName);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.UserInformationView WHERE ");

			if (screenName == null) {
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

			if (screenName != null) {
				qPos.add(screenName);
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					userInformationView);

			UserInformationView[] array = new UserInformationViewImpl[3];

			array[0] = (UserInformationView)objArray[0];
			array[1] = (UserInformationView)objArray[1];
			array[2] = (UserInformationView)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<UserInformationView> findByemailAddress(String emailAddress)
		throws SystemException {
		Object[] finderArgs = new Object[] { emailAddress };

		List<UserInformationView> list = (List<UserInformationView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_EMAILADDRESS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.UserInformationView WHERE ");

				if (emailAddress == null) {
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

				if (emailAddress != null) {
					qPos.add(emailAddress);
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<UserInformationView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_EMAILADDRESS,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<UserInformationView> findByemailAddress(String emailAddress,
		int start, int end) throws SystemException {
		return findByemailAddress(emailAddress, start, end, null);
	}

	public List<UserInformationView> findByemailAddress(String emailAddress,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				emailAddress,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<UserInformationView> list = (List<UserInformationView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_EMAILADDRESS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.UserInformationView WHERE ");

				if (emailAddress == null) {
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

				if (emailAddress != null) {
					qPos.add(emailAddress);
				}

				list = (List<UserInformationView>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<UserInformationView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_EMAILADDRESS,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public UserInformationView findByemailAddress_First(String emailAddress,
		OrderByComparator obc)
		throws NoSuchUserInformationViewException, SystemException {
		List<UserInformationView> list = findByemailAddress(emailAddress, 0, 1,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No UserInformationView exists with the key {");

			msg.append("emailAddress=" + emailAddress);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserInformationViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public UserInformationView findByemailAddress_Last(String emailAddress,
		OrderByComparator obc)
		throws NoSuchUserInformationViewException, SystemException {
		int count = countByemailAddress(emailAddress);

		List<UserInformationView> list = findByemailAddress(emailAddress,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No UserInformationView exists with the key {");

			msg.append("emailAddress=" + emailAddress);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserInformationViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public UserInformationView[] findByemailAddress_PrevAndNext(
		String UserInformationViewId, String emailAddress, OrderByComparator obc)
		throws NoSuchUserInformationViewException, SystemException {
		UserInformationView userInformationView = findByPrimaryKey(UserInformationViewId);

		int count = countByemailAddress(emailAddress);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.UserInformationView WHERE ");

			if (emailAddress == null) {
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

			if (emailAddress != null) {
				qPos.add(emailAddress);
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					userInformationView);

			UserInformationView[] array = new UserInformationViewImpl[3];

			array[0] = (UserInformationView)objArray[0];
			array[1] = (UserInformationView)objArray[1];
			array[2] = (UserInformationView)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<UserInformationView> findByfirstName(String firstName)
		throws SystemException {
		Object[] finderArgs = new Object[] { firstName };

		List<UserInformationView> list = (List<UserInformationView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_FIRSTNAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.UserInformationView WHERE ");

				if (firstName == null) {
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

				if (firstName != null) {
					qPos.add(firstName);
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<UserInformationView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_FIRSTNAME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<UserInformationView> findByfirstName(String firstName,
		int start, int end) throws SystemException {
		return findByfirstName(firstName, start, end, null);
	}

	public List<UserInformationView> findByfirstName(String firstName,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				firstName,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<UserInformationView> list = (List<UserInformationView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_FIRSTNAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.UserInformationView WHERE ");

				if (firstName == null) {
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

				if (firstName != null) {
					qPos.add(firstName);
				}

				list = (List<UserInformationView>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<UserInformationView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_FIRSTNAME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public UserInformationView findByfirstName_First(String firstName,
		OrderByComparator obc)
		throws NoSuchUserInformationViewException, SystemException {
		List<UserInformationView> list = findByfirstName(firstName, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No UserInformationView exists with the key {");

			msg.append("firstName=" + firstName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserInformationViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public UserInformationView findByfirstName_Last(String firstName,
		OrderByComparator obc)
		throws NoSuchUserInformationViewException, SystemException {
		int count = countByfirstName(firstName);

		List<UserInformationView> list = findByfirstName(firstName, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No UserInformationView exists with the key {");

			msg.append("firstName=" + firstName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserInformationViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public UserInformationView[] findByfirstName_PrevAndNext(
		String UserInformationViewId, String firstName, OrderByComparator obc)
		throws NoSuchUserInformationViewException, SystemException {
		UserInformationView userInformationView = findByPrimaryKey(UserInformationViewId);

		int count = countByfirstName(firstName);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.UserInformationView WHERE ");

			if (firstName == null) {
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

			if (firstName != null) {
				qPos.add(firstName);
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					userInformationView);

			UserInformationView[] array = new UserInformationViewImpl[3];

			array[0] = (UserInformationView)objArray[0];
			array[1] = (UserInformationView)objArray[1];
			array[2] = (UserInformationView)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<UserInformationView> findBylastName(String lastName)
		throws SystemException {
		Object[] finderArgs = new Object[] { lastName };

		List<UserInformationView> list = (List<UserInformationView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_LASTNAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.UserInformationView WHERE ");

				if (lastName == null) {
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

				if (lastName != null) {
					qPos.add(lastName);
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<UserInformationView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_LASTNAME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<UserInformationView> findBylastName(String lastName, int start,
		int end) throws SystemException {
		return findBylastName(lastName, start, end, null);
	}

	public List<UserInformationView> findBylastName(String lastName, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				lastName,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<UserInformationView> list = (List<UserInformationView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_LASTNAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.UserInformationView WHERE ");

				if (lastName == null) {
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

				if (lastName != null) {
					qPos.add(lastName);
				}

				list = (List<UserInformationView>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<UserInformationView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_LASTNAME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public UserInformationView findBylastName_First(String lastName,
		OrderByComparator obc)
		throws NoSuchUserInformationViewException, SystemException {
		List<UserInformationView> list = findBylastName(lastName, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No UserInformationView exists with the key {");

			msg.append("lastName=" + lastName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserInformationViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public UserInformationView findBylastName_Last(String lastName,
		OrderByComparator obc)
		throws NoSuchUserInformationViewException, SystemException {
		int count = countBylastName(lastName);

		List<UserInformationView> list = findBylastName(lastName, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No UserInformationView exists with the key {");

			msg.append("lastName=" + lastName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserInformationViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public UserInformationView[] findBylastName_PrevAndNext(
		String UserInformationViewId, String lastName, OrderByComparator obc)
		throws NoSuchUserInformationViewException, SystemException {
		UserInformationView userInformationView = findByPrimaryKey(UserInformationViewId);

		int count = countBylastName(lastName);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.UserInformationView WHERE ");

			if (lastName == null) {
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

			if (lastName != null) {
				qPos.add(lastName);
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					userInformationView);

			UserInformationView[] array = new UserInformationViewImpl[3];

			array[0] = (UserInformationView)objArray[0];
			array[1] = (UserInformationView)objArray[1];
			array[2] = (UserInformationView)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<UserInformationView> findByisCurrent(boolean isCurrent)
		throws SystemException {
		Object[] finderArgs = new Object[] { Boolean.valueOf(isCurrent) };

		List<UserInformationView> list = (List<UserInformationView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ISCURRENT,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.UserInformationView WHERE ");

				query.append("is_current = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("screenname ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isCurrent);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<UserInformationView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ISCURRENT,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<UserInformationView> findByisCurrent(boolean isCurrent,
		int start, int end) throws SystemException {
		return findByisCurrent(isCurrent, start, end, null);
	}

	public List<UserInformationView> findByisCurrent(boolean isCurrent,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				Boolean.valueOf(isCurrent),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<UserInformationView> list = (List<UserInformationView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ISCURRENT,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.UserInformationView WHERE ");

				query.append("is_current = ?");

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

				qPos.add(isCurrent);

				list = (List<UserInformationView>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<UserInformationView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ISCURRENT,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public UserInformationView findByisCurrent_First(boolean isCurrent,
		OrderByComparator obc)
		throws NoSuchUserInformationViewException, SystemException {
		List<UserInformationView> list = findByisCurrent(isCurrent, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No UserInformationView exists with the key {");

			msg.append("isCurrent=" + isCurrent);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserInformationViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public UserInformationView findByisCurrent_Last(boolean isCurrent,
		OrderByComparator obc)
		throws NoSuchUserInformationViewException, SystemException {
		int count = countByisCurrent(isCurrent);

		List<UserInformationView> list = findByisCurrent(isCurrent, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No UserInformationView exists with the key {");

			msg.append("isCurrent=" + isCurrent);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserInformationViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public UserInformationView[] findByisCurrent_PrevAndNext(
		String UserInformationViewId, boolean isCurrent, OrderByComparator obc)
		throws NoSuchUserInformationViewException, SystemException {
		UserInformationView userInformationView = findByPrimaryKey(UserInformationViewId);

		int count = countByisCurrent(isCurrent);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.UserInformationView WHERE ");

			query.append("is_current = ?");

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

			qPos.add(isCurrent);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					userInformationView);

			UserInformationView[] array = new UserInformationViewImpl[3];

			array[0] = (UserInformationView)objArray[0];
			array[1] = (UserInformationView)objArray[1];
			array[2] = (UserInformationView)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<UserInformationView> findBysearchInformation(
		String searchInformation) throws SystemException {
		Object[] finderArgs = new Object[] { searchInformation };

		List<UserInformationView> list = (List<UserInformationView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_SEARCHINFORMATION,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.UserInformationView WHERE ");

				if (searchInformation == null) {
					query.append("search_information LIKE null");
				}
				else {
					query.append("search_information LIKE ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("screenname ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (searchInformation != null) {
					qPos.add(searchInformation);
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<UserInformationView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_SEARCHINFORMATION,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<UserInformationView> findBysearchInformation(
		String searchInformation, int start, int end) throws SystemException {
		return findBysearchInformation(searchInformation, start, end, null);
	}

	public List<UserInformationView> findBysearchInformation(
		String searchInformation, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				searchInformation,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<UserInformationView> list = (List<UserInformationView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_SEARCHINFORMATION,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.UserInformationView WHERE ");

				if (searchInformation == null) {
					query.append("search_information LIKE null");
				}
				else {
					query.append("search_information LIKE ?");
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

				if (searchInformation != null) {
					qPos.add(searchInformation);
				}

				list = (List<UserInformationView>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<UserInformationView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_SEARCHINFORMATION,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public UserInformationView findBysearchInformation_First(
		String searchInformation, OrderByComparator obc)
		throws NoSuchUserInformationViewException, SystemException {
		List<UserInformationView> list = findBysearchInformation(searchInformation,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No UserInformationView exists with the key {");

			msg.append("searchInformation=" + searchInformation);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserInformationViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public UserInformationView findBysearchInformation_Last(
		String searchInformation, OrderByComparator obc)
		throws NoSuchUserInformationViewException, SystemException {
		int count = countBysearchInformation(searchInformation);

		List<UserInformationView> list = findBysearchInformation(searchInformation,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No UserInformationView exists with the key {");

			msg.append("searchInformation=" + searchInformation);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserInformationViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public UserInformationView[] findBysearchInformation_PrevAndNext(
		String UserInformationViewId, String searchInformation,
		OrderByComparator obc)
		throws NoSuchUserInformationViewException, SystemException {
		UserInformationView userInformationView = findByPrimaryKey(UserInformationViewId);

		int count = countBysearchInformation(searchInformation);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.UserInformationView WHERE ");

			if (searchInformation == null) {
				query.append("search_information LIKE null");
			}
			else {
				query.append("search_information LIKE ?");
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

			if (searchInformation != null) {
				qPos.add(searchInformation);
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					userInformationView);

			UserInformationView[] array = new UserInformationViewImpl[3];

			array[0] = (UserInformationView)objArray[0];
			array[1] = (UserInformationView)objArray[1];
			array[2] = (UserInformationView)objArray[2];

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

	public List<UserInformationView> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<UserInformationView> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<UserInformationView> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<UserInformationView> list = (List<UserInformationView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.UserInformationView ");

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
					list = (List<UserInformationView>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<UserInformationView>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<UserInformationView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByuserId(int userId) throws SystemException {
		for (UserInformationView userInformationView : findByuserId(userId)) {
			remove(userInformationView);
		}
	}

	public void removeByorgId(int orgId) throws SystemException {
		for (UserInformationView userInformationView : findByorgId(orgId)) {
			remove(userInformationView);
		}
	}

	public void removeByroleId(int roleId) throws SystemException {
		for (UserInformationView userInformationView : findByroleId(roleId)) {
			remove(userInformationView);
		}
	}

	public void removeByisProActive(int isProActive) throws SystemException {
		for (UserInformationView userInformationView : findByisProActive(
				isProActive)) {
			remove(userInformationView);
		}
	}

	public void removeBystatus(int status) throws SystemException {
		for (UserInformationView userInformationView : findBystatus(status)) {
			remove(userInformationView);
		}
	}

	public void removeByjoiningStatus(int joiningStatus)
		throws SystemException {
		for (UserInformationView userInformationView : findByjoiningStatus(
				joiningStatus)) {
			remove(userInformationView);
		}
	}

	public void removeByscreenName(String screenName) throws SystemException {
		for (UserInformationView userInformationView : findByscreenName(
				screenName)) {
			remove(userInformationView);
		}
	}

	public void removeByemailAddress(String emailAddress)
		throws SystemException {
		for (UserInformationView userInformationView : findByemailAddress(
				emailAddress)) {
			remove(userInformationView);
		}
	}

	public void removeByfirstName(String firstName) throws SystemException {
		for (UserInformationView userInformationView : findByfirstName(
				firstName)) {
			remove(userInformationView);
		}
	}

	public void removeBylastName(String lastName) throws SystemException {
		for (UserInformationView userInformationView : findBylastName(lastName)) {
			remove(userInformationView);
		}
	}

	public void removeByisCurrent(boolean isCurrent) throws SystemException {
		for (UserInformationView userInformationView : findByisCurrent(
				isCurrent)) {
			remove(userInformationView);
		}
	}

	public void removeBysearchInformation(String searchInformation)
		throws SystemException {
		for (UserInformationView userInformationView : findBysearchInformation(
				searchInformation)) {
			remove(userInformationView);
		}
	}

	public void removeAll() throws SystemException {
		for (UserInformationView userInformationView : findAll()) {
			remove(userInformationView);
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
					"FROM larion.progate.model.UserInformationView WHERE ");

				query.append("userid = ?");

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
					"FROM larion.progate.model.UserInformationView WHERE ");

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

	public int countByroleId(int roleId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(roleId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ROLEID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.UserInformationView WHERE ");

				query.append("role_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(roleId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ROLEID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByisProActive(int isProActive) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(isProActive) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ISPROACTIVE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.UserInformationView WHERE ");

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

	public int countBystatus(int status) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(status) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_STATUS,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.UserInformationView WHERE ");

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

	public int countByjoiningStatus(int joiningStatus)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(joiningStatus) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_JOININGSTATUS,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.UserInformationView WHERE ");

				query.append("joining_status = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(joiningStatus);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_JOININGSTATUS,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByscreenName(String screenName) throws SystemException {
		Object[] finderArgs = new Object[] { screenName };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_SCREENNAME,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.UserInformationView WHERE ");

				if (screenName == null) {
					query.append("screenname LIKE null");
				}
				else {
					query.append("screenname LIKE ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (screenName != null) {
					qPos.add(screenName);
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

	public int countByemailAddress(String emailAddress)
		throws SystemException {
		Object[] finderArgs = new Object[] { emailAddress };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_EMAILADDRESS,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.UserInformationView WHERE ");

				if (emailAddress == null) {
					query.append("emailaddress LIKE null");
				}
				else {
					query.append("emailaddress LIKE ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (emailAddress != null) {
					qPos.add(emailAddress);
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

	public int countByfirstName(String firstName) throws SystemException {
		Object[] finderArgs = new Object[] { firstName };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FIRSTNAME,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.UserInformationView WHERE ");

				if (firstName == null) {
					query.append("firstname LIKE null");
				}
				else {
					query.append("firstname LIKE ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (firstName != null) {
					qPos.add(firstName);
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

	public int countBylastName(String lastName) throws SystemException {
		Object[] finderArgs = new Object[] { lastName };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_LASTNAME,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.UserInformationView WHERE ");

				if (lastName == null) {
					query.append("lastname LIKE null");
				}
				else {
					query.append("lastname LIKE ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (lastName != null) {
					qPos.add(lastName);
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

	public int countByisCurrent(boolean isCurrent) throws SystemException {
		Object[] finderArgs = new Object[] { Boolean.valueOf(isCurrent) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ISCURRENT,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.UserInformationView WHERE ");

				query.append("is_current = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isCurrent);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ISCURRENT,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countBysearchInformation(String searchInformation)
		throws SystemException {
		Object[] finderArgs = new Object[] { searchInformation };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_SEARCHINFORMATION,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.UserInformationView WHERE ");

				if (searchInformation == null) {
					query.append("search_information LIKE null");
				}
				else {
					query.append("search_information LIKE ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (searchInformation != null) {
					qPos.add(searchInformation);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SEARCHINFORMATION,
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
						"SELECT COUNT(*) FROM larion.progate.model.UserInformationView");

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
						"value.object.listener.larion.progate.model.UserInformationView")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<UserInformationView>> listenersList = new ArrayList<ModelListener<UserInformationView>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<UserInformationView>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(UserInformationViewPersistenceImpl.class);
}