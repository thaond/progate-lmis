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
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import larion.progate.NoSuchProgateOrganizationParticipantsException;

import larion.progate.model.ProgateOrganizationParticipants;
import larion.progate.model.impl.ProgateOrganizationParticipantsImpl;
import larion.progate.model.impl.ProgateOrganizationParticipantsModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * <a href="ProgateOrganizationParticipantsPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProgateOrganizationParticipantsPersistenceImpl
	extends BasePersistenceImpl
	implements ProgateOrganizationParticipantsPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = ProgateOrganizationParticipantsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_USERID = new FinderPath(ProgateOrganizationParticipantsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationParticipantsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByuserId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_USERID = new FinderPath(ProgateOrganizationParticipantsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationParticipantsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByuserId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(ProgateOrganizationParticipantsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationParticipantsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByuserId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ORGID = new FinderPath(ProgateOrganizationParticipantsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationParticipantsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByorgId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ORGID = new FinderPath(ProgateOrganizationParticipantsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationParticipantsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByorgId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGID = new FinderPath(ProgateOrganizationParticipantsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationParticipantsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByorgId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ROLEID = new FinderPath(ProgateOrganizationParticipantsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationParticipantsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByroleId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ROLEID = new FinderPath(ProgateOrganizationParticipantsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationParticipantsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByroleId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ROLEID = new FinderPath(ProgateOrganizationParticipantsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationParticipantsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByroleId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_REQUESTEDBY = new FinderPath(ProgateOrganizationParticipantsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationParticipantsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByrequestedBy",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_REQUESTEDBY = new FinderPath(ProgateOrganizationParticipantsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationParticipantsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByrequestedBy",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_REQUESTEDBY = new FinderPath(ProgateOrganizationParticipantsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationParticipantsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByrequestedBy",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_REQUESTEDAT = new FinderPath(ProgateOrganizationParticipantsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationParticipantsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByrequestedAt",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_REQUESTEDAT = new FinderPath(ProgateOrganizationParticipantsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationParticipantsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByrequestedAt",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_REQUESTEDAT = new FinderPath(ProgateOrganizationParticipantsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationParticipantsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByrequestedAt",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_APPROVEDBY = new FinderPath(ProgateOrganizationParticipantsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationParticipantsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByapprovedBy",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_APPROVEDBY = new FinderPath(ProgateOrganizationParticipantsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationParticipantsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByapprovedBy",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_APPROVEDBY = new FinderPath(ProgateOrganizationParticipantsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationParticipantsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByapprovedBy",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_APPROVEDAT = new FinderPath(ProgateOrganizationParticipantsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationParticipantsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByapprovedAt",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_APPROVEDAT = new FinderPath(ProgateOrganizationParticipantsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationParticipantsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByapprovedAt",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_APPROVEDAT = new FinderPath(ProgateOrganizationParticipantsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationParticipantsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByapprovedAt",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_STATUS = new FinderPath(ProgateOrganizationParticipantsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationParticipantsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBystatus",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_STATUS = new FinderPath(ProgateOrganizationParticipantsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationParticipantsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBystatus",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(ProgateOrganizationParticipantsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationParticipantsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBystatus",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ISCURRENT = new FinderPath(ProgateOrganizationParticipantsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationParticipantsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByisCurrent",
			new String[] { Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ISCURRENT = new FinderPath(ProgateOrganizationParticipantsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationParticipantsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByisCurrent",
			new String[] {
				Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ISCURRENT = new FinderPath(ProgateOrganizationParticipantsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationParticipantsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByisCurrent",
			new String[] { Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(ProgateOrganizationParticipantsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationParticipantsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProgateOrganizationParticipantsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationParticipantsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(
		ProgateOrganizationParticipants progateOrganizationParticipants) {
		EntityCacheUtil.putResult(ProgateOrganizationParticipantsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationParticipantsImpl.class,
			progateOrganizationParticipants.getPrimaryKey(),
			progateOrganizationParticipants);
	}

	public void cacheResult(
		List<ProgateOrganizationParticipants> progateOrganizationParticipantses) {
		for (ProgateOrganizationParticipants progateOrganizationParticipants : progateOrganizationParticipantses) {
			if (EntityCacheUtil.getResult(
						ProgateOrganizationParticipantsModelImpl.ENTITY_CACHE_ENABLED,
						ProgateOrganizationParticipantsImpl.class,
						progateOrganizationParticipants.getPrimaryKey(), this) == null) {
				cacheResult(progateOrganizationParticipants);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(ProgateOrganizationParticipantsImpl.class.getName());
		EntityCacheUtil.clearCache(ProgateOrganizationParticipantsImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public ProgateOrganizationParticipants create(
		Integer ProgateOrganizationParticipantsId) {
		ProgateOrganizationParticipants progateOrganizationParticipants = new ProgateOrganizationParticipantsImpl();

		progateOrganizationParticipants.setNew(true);
		progateOrganizationParticipants.setPrimaryKey(ProgateOrganizationParticipantsId);

		return progateOrganizationParticipants;
	}

	public ProgateOrganizationParticipants remove(
		Integer ProgateOrganizationParticipantsId)
		throws NoSuchProgateOrganizationParticipantsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ProgateOrganizationParticipants progateOrganizationParticipants = (ProgateOrganizationParticipants)session.get(ProgateOrganizationParticipantsImpl.class,
					ProgateOrganizationParticipantsId);

			if (progateOrganizationParticipants == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No ProgateOrganizationParticipants exists with the primary key " +
						ProgateOrganizationParticipantsId);
				}

				throw new NoSuchProgateOrganizationParticipantsException(
					"No ProgateOrganizationParticipants exists with the primary key " +
					ProgateOrganizationParticipantsId);
			}

			return remove(progateOrganizationParticipants);
		}
		catch (NoSuchProgateOrganizationParticipantsException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public ProgateOrganizationParticipants remove(
		ProgateOrganizationParticipants progateOrganizationParticipants)
		throws SystemException {
		for (ModelListener<ProgateOrganizationParticipants> listener : listeners) {
			listener.onBeforeRemove(progateOrganizationParticipants);
		}

		progateOrganizationParticipants = removeImpl(progateOrganizationParticipants);

		for (ModelListener<ProgateOrganizationParticipants> listener : listeners) {
			listener.onAfterRemove(progateOrganizationParticipants);
		}

		return progateOrganizationParticipants;
	}

	protected ProgateOrganizationParticipants removeImpl(
		ProgateOrganizationParticipants progateOrganizationParticipants)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (progateOrganizationParticipants.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(ProgateOrganizationParticipantsImpl.class,
						progateOrganizationParticipants.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(progateOrganizationParticipants);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(ProgateOrganizationParticipantsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationParticipantsImpl.class,
			progateOrganizationParticipants.getPrimaryKey());

		return progateOrganizationParticipants;
	}

	public ProgateOrganizationParticipants update(
		ProgateOrganizationParticipants progateOrganizationParticipants)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(ProgateOrganizationParticipants progateOrganizationParticipants) method. Use update(ProgateOrganizationParticipants progateOrganizationParticipants, boolean merge) instead.");
		}

		return update(progateOrganizationParticipants, false);
	}

	public ProgateOrganizationParticipants update(
		ProgateOrganizationParticipants progateOrganizationParticipants,
		boolean merge) throws SystemException {
		boolean isNew = progateOrganizationParticipants.isNew();

		for (ModelListener<ProgateOrganizationParticipants> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(progateOrganizationParticipants);
			}
			else {
				listener.onBeforeUpdate(progateOrganizationParticipants);
			}
		}

		progateOrganizationParticipants = updateImpl(progateOrganizationParticipants,
				merge);

		for (ModelListener<ProgateOrganizationParticipants> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(progateOrganizationParticipants);
			}
			else {
				listener.onAfterUpdate(progateOrganizationParticipants);
			}
		}

		return progateOrganizationParticipants;
	}

	public ProgateOrganizationParticipants updateImpl(
		larion.progate.model.ProgateOrganizationParticipants progateOrganizationParticipants,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, progateOrganizationParticipants,
				merge);

			progateOrganizationParticipants.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(ProgateOrganizationParticipantsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationParticipantsImpl.class,
			progateOrganizationParticipants.getPrimaryKey(),
			progateOrganizationParticipants);

		return progateOrganizationParticipants;
	}

	public ProgateOrganizationParticipants findByPrimaryKey(
		Integer ProgateOrganizationParticipantsId)
		throws NoSuchProgateOrganizationParticipantsException, SystemException {
		ProgateOrganizationParticipants progateOrganizationParticipants = fetchByPrimaryKey(ProgateOrganizationParticipantsId);

		if (progateOrganizationParticipants == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"No ProgateOrganizationParticipants exists with the primary key " +
					ProgateOrganizationParticipantsId);
			}

			throw new NoSuchProgateOrganizationParticipantsException(
				"No ProgateOrganizationParticipants exists with the primary key " +
				ProgateOrganizationParticipantsId);
		}

		return progateOrganizationParticipants;
	}

	public ProgateOrganizationParticipants fetchByPrimaryKey(
		Integer ProgateOrganizationParticipantsId) throws SystemException {
		ProgateOrganizationParticipants progateOrganizationParticipants = (ProgateOrganizationParticipants)EntityCacheUtil.getResult(ProgateOrganizationParticipantsModelImpl.ENTITY_CACHE_ENABLED,
				ProgateOrganizationParticipantsImpl.class,
				ProgateOrganizationParticipantsId, this);

		if (progateOrganizationParticipants == null) {
			Session session = null;

			try {
				session = openSession();

				progateOrganizationParticipants = (ProgateOrganizationParticipants)session.get(ProgateOrganizationParticipantsImpl.class,
						ProgateOrganizationParticipantsId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (progateOrganizationParticipants != null) {
					cacheResult(progateOrganizationParticipants);
				}

				closeSession(session);
			}
		}

		return progateOrganizationParticipants;
	}

	public List<ProgateOrganizationParticipants> findByuserId(int userId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(userId) };

		List<ProgateOrganizationParticipants> list = (List<ProgateOrganizationParticipants>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_USERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProgateOrganizationParticipants WHERE ");

				query.append("user_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("approved_at DESC, ");
				query.append("requested_at DESC, ");
				query.append("org_id ASC");

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
					list = new ArrayList<ProgateOrganizationParticipants>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_USERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProgateOrganizationParticipants> findByuserId(int userId,
		int start, int end) throws SystemException {
		return findByuserId(userId, start, end, null);
	}

	public List<ProgateOrganizationParticipants> findByuserId(int userId,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(userId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProgateOrganizationParticipants> list = (List<ProgateOrganizationParticipants>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_USERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProgateOrganizationParticipants WHERE ");

				query.append("user_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("approved_at DESC, ");
					query.append("requested_at DESC, ");
					query.append("org_id ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				list = (List<ProgateOrganizationParticipants>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProgateOrganizationParticipants>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_USERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProgateOrganizationParticipants findByuserId_First(int userId,
		OrderByComparator obc)
		throws NoSuchProgateOrganizationParticipantsException, SystemException {
		List<ProgateOrganizationParticipants> list = findByuserId(userId, 0, 1,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No ProgateOrganizationParticipants exists with the key {");

			msg.append("userId=" + userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProgateOrganizationParticipantsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProgateOrganizationParticipants findByuserId_Last(int userId,
		OrderByComparator obc)
		throws NoSuchProgateOrganizationParticipantsException, SystemException {
		int count = countByuserId(userId);

		List<ProgateOrganizationParticipants> list = findByuserId(userId,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No ProgateOrganizationParticipants exists with the key {");

			msg.append("userId=" + userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProgateOrganizationParticipantsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProgateOrganizationParticipants[] findByuserId_PrevAndNext(
		Integer ProgateOrganizationParticipantsId, int userId,
		OrderByComparator obc)
		throws NoSuchProgateOrganizationParticipantsException, SystemException {
		ProgateOrganizationParticipants progateOrganizationParticipants = findByPrimaryKey(ProgateOrganizationParticipantsId);

		int count = countByuserId(userId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProgateOrganizationParticipants WHERE ");

			query.append("user_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("approved_at DESC, ");
				query.append("requested_at DESC, ");
				query.append("org_id ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(userId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					progateOrganizationParticipants);

			ProgateOrganizationParticipants[] array = new ProgateOrganizationParticipantsImpl[3];

			array[0] = (ProgateOrganizationParticipants)objArray[0];
			array[1] = (ProgateOrganizationParticipants)objArray[1];
			array[2] = (ProgateOrganizationParticipants)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProgateOrganizationParticipants> findByorgId(int orgId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(orgId) };

		List<ProgateOrganizationParticipants> list = (List<ProgateOrganizationParticipants>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ORGID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProgateOrganizationParticipants WHERE ");

				query.append("org_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("approved_at DESC, ");
				query.append("requested_at DESC, ");
				query.append("org_id ASC");

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
					list = new ArrayList<ProgateOrganizationParticipants>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ORGID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProgateOrganizationParticipants> findByorgId(int orgId,
		int start, int end) throws SystemException {
		return findByorgId(orgId, start, end, null);
	}

	public List<ProgateOrganizationParticipants> findByorgId(int orgId,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(orgId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProgateOrganizationParticipants> list = (List<ProgateOrganizationParticipants>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ORGID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProgateOrganizationParticipants WHERE ");

				query.append("org_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("approved_at DESC, ");
					query.append("requested_at DESC, ");
					query.append("org_id ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orgId);

				list = (List<ProgateOrganizationParticipants>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProgateOrganizationParticipants>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ORGID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProgateOrganizationParticipants findByorgId_First(int orgId,
		OrderByComparator obc)
		throws NoSuchProgateOrganizationParticipantsException, SystemException {
		List<ProgateOrganizationParticipants> list = findByorgId(orgId, 0, 1,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No ProgateOrganizationParticipants exists with the key {");

			msg.append("orgId=" + orgId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProgateOrganizationParticipantsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProgateOrganizationParticipants findByorgId_Last(int orgId,
		OrderByComparator obc)
		throws NoSuchProgateOrganizationParticipantsException, SystemException {
		int count = countByorgId(orgId);

		List<ProgateOrganizationParticipants> list = findByorgId(orgId,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No ProgateOrganizationParticipants exists with the key {");

			msg.append("orgId=" + orgId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProgateOrganizationParticipantsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProgateOrganizationParticipants[] findByorgId_PrevAndNext(
		Integer ProgateOrganizationParticipantsId, int orgId,
		OrderByComparator obc)
		throws NoSuchProgateOrganizationParticipantsException, SystemException {
		ProgateOrganizationParticipants progateOrganizationParticipants = findByPrimaryKey(ProgateOrganizationParticipantsId);

		int count = countByorgId(orgId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProgateOrganizationParticipants WHERE ");

			query.append("org_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("approved_at DESC, ");
				query.append("requested_at DESC, ");
				query.append("org_id ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(orgId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					progateOrganizationParticipants);

			ProgateOrganizationParticipants[] array = new ProgateOrganizationParticipantsImpl[3];

			array[0] = (ProgateOrganizationParticipants)objArray[0];
			array[1] = (ProgateOrganizationParticipants)objArray[1];
			array[2] = (ProgateOrganizationParticipants)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProgateOrganizationParticipants> findByroleId(int roleId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(roleId) };

		List<ProgateOrganizationParticipants> list = (List<ProgateOrganizationParticipants>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ROLEID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProgateOrganizationParticipants WHERE ");

				query.append("role_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("approved_at DESC, ");
				query.append("requested_at DESC, ");
				query.append("org_id ASC");

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
					list = new ArrayList<ProgateOrganizationParticipants>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ROLEID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProgateOrganizationParticipants> findByroleId(int roleId,
		int start, int end) throws SystemException {
		return findByroleId(roleId, start, end, null);
	}

	public List<ProgateOrganizationParticipants> findByroleId(int roleId,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(roleId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProgateOrganizationParticipants> list = (List<ProgateOrganizationParticipants>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ROLEID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProgateOrganizationParticipants WHERE ");

				query.append("role_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("approved_at DESC, ");
					query.append("requested_at DESC, ");
					query.append("org_id ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(roleId);

				list = (List<ProgateOrganizationParticipants>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProgateOrganizationParticipants>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ROLEID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProgateOrganizationParticipants findByroleId_First(int roleId,
		OrderByComparator obc)
		throws NoSuchProgateOrganizationParticipantsException, SystemException {
		List<ProgateOrganizationParticipants> list = findByroleId(roleId, 0, 1,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No ProgateOrganizationParticipants exists with the key {");

			msg.append("roleId=" + roleId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProgateOrganizationParticipantsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProgateOrganizationParticipants findByroleId_Last(int roleId,
		OrderByComparator obc)
		throws NoSuchProgateOrganizationParticipantsException, SystemException {
		int count = countByroleId(roleId);

		List<ProgateOrganizationParticipants> list = findByroleId(roleId,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No ProgateOrganizationParticipants exists with the key {");

			msg.append("roleId=" + roleId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProgateOrganizationParticipantsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProgateOrganizationParticipants[] findByroleId_PrevAndNext(
		Integer ProgateOrganizationParticipantsId, int roleId,
		OrderByComparator obc)
		throws NoSuchProgateOrganizationParticipantsException, SystemException {
		ProgateOrganizationParticipants progateOrganizationParticipants = findByPrimaryKey(ProgateOrganizationParticipantsId);

		int count = countByroleId(roleId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProgateOrganizationParticipants WHERE ");

			query.append("role_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("approved_at DESC, ");
				query.append("requested_at DESC, ");
				query.append("org_id ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(roleId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					progateOrganizationParticipants);

			ProgateOrganizationParticipants[] array = new ProgateOrganizationParticipantsImpl[3];

			array[0] = (ProgateOrganizationParticipants)objArray[0];
			array[1] = (ProgateOrganizationParticipants)objArray[1];
			array[2] = (ProgateOrganizationParticipants)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProgateOrganizationParticipants> findByrequestedBy(
		int requestedBy) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(requestedBy) };

		List<ProgateOrganizationParticipants> list = (List<ProgateOrganizationParticipants>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_REQUESTEDBY,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProgateOrganizationParticipants WHERE ");

				query.append("requested_by = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("approved_at DESC, ");
				query.append("requested_at DESC, ");
				query.append("org_id ASC");

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
					list = new ArrayList<ProgateOrganizationParticipants>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_REQUESTEDBY,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProgateOrganizationParticipants> findByrequestedBy(
		int requestedBy, int start, int end) throws SystemException {
		return findByrequestedBy(requestedBy, start, end, null);
	}

	public List<ProgateOrganizationParticipants> findByrequestedBy(
		int requestedBy, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(requestedBy),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProgateOrganizationParticipants> list = (List<ProgateOrganizationParticipants>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_REQUESTEDBY,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProgateOrganizationParticipants WHERE ");

				query.append("requested_by = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("approved_at DESC, ");
					query.append("requested_at DESC, ");
					query.append("org_id ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(requestedBy);

				list = (List<ProgateOrganizationParticipants>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProgateOrganizationParticipants>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_REQUESTEDBY,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProgateOrganizationParticipants findByrequestedBy_First(
		int requestedBy, OrderByComparator obc)
		throws NoSuchProgateOrganizationParticipantsException, SystemException {
		List<ProgateOrganizationParticipants> list = findByrequestedBy(requestedBy,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No ProgateOrganizationParticipants exists with the key {");

			msg.append("requestedBy=" + requestedBy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProgateOrganizationParticipantsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProgateOrganizationParticipants findByrequestedBy_Last(
		int requestedBy, OrderByComparator obc)
		throws NoSuchProgateOrganizationParticipantsException, SystemException {
		int count = countByrequestedBy(requestedBy);

		List<ProgateOrganizationParticipants> list = findByrequestedBy(requestedBy,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No ProgateOrganizationParticipants exists with the key {");

			msg.append("requestedBy=" + requestedBy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProgateOrganizationParticipantsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProgateOrganizationParticipants[] findByrequestedBy_PrevAndNext(
		Integer ProgateOrganizationParticipantsId, int requestedBy,
		OrderByComparator obc)
		throws NoSuchProgateOrganizationParticipantsException, SystemException {
		ProgateOrganizationParticipants progateOrganizationParticipants = findByPrimaryKey(ProgateOrganizationParticipantsId);

		int count = countByrequestedBy(requestedBy);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProgateOrganizationParticipants WHERE ");

			query.append("requested_by = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("approved_at DESC, ");
				query.append("requested_at DESC, ");
				query.append("org_id ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(requestedBy);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					progateOrganizationParticipants);

			ProgateOrganizationParticipants[] array = new ProgateOrganizationParticipantsImpl[3];

			array[0] = (ProgateOrganizationParticipants)objArray[0];
			array[1] = (ProgateOrganizationParticipants)objArray[1];
			array[2] = (ProgateOrganizationParticipants)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProgateOrganizationParticipants> findByrequestedAt(
		Date requestedAt) throws SystemException {
		Object[] finderArgs = new Object[] { requestedAt };

		List<ProgateOrganizationParticipants> list = (List<ProgateOrganizationParticipants>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_REQUESTEDAT,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProgateOrganizationParticipants WHERE ");

				if (requestedAt == null) {
					query.append("requested_at IS NULL");
				}
				else {
					query.append("requested_at = ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("approved_at DESC, ");
				query.append("requested_at DESC, ");
				query.append("org_id ASC");

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
					list = new ArrayList<ProgateOrganizationParticipants>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_REQUESTEDAT,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProgateOrganizationParticipants> findByrequestedAt(
		Date requestedAt, int start, int end) throws SystemException {
		return findByrequestedAt(requestedAt, start, end, null);
	}

	public List<ProgateOrganizationParticipants> findByrequestedAt(
		Date requestedAt, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				requestedAt,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProgateOrganizationParticipants> list = (List<ProgateOrganizationParticipants>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_REQUESTEDAT,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProgateOrganizationParticipants WHERE ");

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

					query.append("approved_at DESC, ");
					query.append("requested_at DESC, ");
					query.append("org_id ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (requestedAt != null) {
					qPos.add(CalendarUtil.getTimestamp(requestedAt));
				}

				list = (List<ProgateOrganizationParticipants>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProgateOrganizationParticipants>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_REQUESTEDAT,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProgateOrganizationParticipants findByrequestedAt_First(
		Date requestedAt, OrderByComparator obc)
		throws NoSuchProgateOrganizationParticipantsException, SystemException {
		List<ProgateOrganizationParticipants> list = findByrequestedAt(requestedAt,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No ProgateOrganizationParticipants exists with the key {");

			msg.append("requestedAt=" + requestedAt);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProgateOrganizationParticipantsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProgateOrganizationParticipants findByrequestedAt_Last(
		Date requestedAt, OrderByComparator obc)
		throws NoSuchProgateOrganizationParticipantsException, SystemException {
		int count = countByrequestedAt(requestedAt);

		List<ProgateOrganizationParticipants> list = findByrequestedAt(requestedAt,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No ProgateOrganizationParticipants exists with the key {");

			msg.append("requestedAt=" + requestedAt);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProgateOrganizationParticipantsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProgateOrganizationParticipants[] findByrequestedAt_PrevAndNext(
		Integer ProgateOrganizationParticipantsId, Date requestedAt,
		OrderByComparator obc)
		throws NoSuchProgateOrganizationParticipantsException, SystemException {
		ProgateOrganizationParticipants progateOrganizationParticipants = findByPrimaryKey(ProgateOrganizationParticipantsId);

		int count = countByrequestedAt(requestedAt);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProgateOrganizationParticipants WHERE ");

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

				query.append("approved_at DESC, ");
				query.append("requested_at DESC, ");
				query.append("org_id ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (requestedAt != null) {
				qPos.add(CalendarUtil.getTimestamp(requestedAt));
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					progateOrganizationParticipants);

			ProgateOrganizationParticipants[] array = new ProgateOrganizationParticipantsImpl[3];

			array[0] = (ProgateOrganizationParticipants)objArray[0];
			array[1] = (ProgateOrganizationParticipants)objArray[1];
			array[2] = (ProgateOrganizationParticipants)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProgateOrganizationParticipants> findByapprovedBy(
		int approvedBy) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(approvedBy) };

		List<ProgateOrganizationParticipants> list = (List<ProgateOrganizationParticipants>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_APPROVEDBY,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProgateOrganizationParticipants WHERE ");

				query.append("approved_by = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("approved_at DESC, ");
				query.append("requested_at DESC, ");
				query.append("org_id ASC");

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
					list = new ArrayList<ProgateOrganizationParticipants>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_APPROVEDBY,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProgateOrganizationParticipants> findByapprovedBy(
		int approvedBy, int start, int end) throws SystemException {
		return findByapprovedBy(approvedBy, start, end, null);
	}

	public List<ProgateOrganizationParticipants> findByapprovedBy(
		int approvedBy, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(approvedBy),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProgateOrganizationParticipants> list = (List<ProgateOrganizationParticipants>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_APPROVEDBY,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProgateOrganizationParticipants WHERE ");

				query.append("approved_by = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("approved_at DESC, ");
					query.append("requested_at DESC, ");
					query.append("org_id ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(approvedBy);

				list = (List<ProgateOrganizationParticipants>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProgateOrganizationParticipants>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_APPROVEDBY,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProgateOrganizationParticipants findByapprovedBy_First(
		int approvedBy, OrderByComparator obc)
		throws NoSuchProgateOrganizationParticipantsException, SystemException {
		List<ProgateOrganizationParticipants> list = findByapprovedBy(approvedBy,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No ProgateOrganizationParticipants exists with the key {");

			msg.append("approvedBy=" + approvedBy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProgateOrganizationParticipantsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProgateOrganizationParticipants findByapprovedBy_Last(
		int approvedBy, OrderByComparator obc)
		throws NoSuchProgateOrganizationParticipantsException, SystemException {
		int count = countByapprovedBy(approvedBy);

		List<ProgateOrganizationParticipants> list = findByapprovedBy(approvedBy,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No ProgateOrganizationParticipants exists with the key {");

			msg.append("approvedBy=" + approvedBy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProgateOrganizationParticipantsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProgateOrganizationParticipants[] findByapprovedBy_PrevAndNext(
		Integer ProgateOrganizationParticipantsId, int approvedBy,
		OrderByComparator obc)
		throws NoSuchProgateOrganizationParticipantsException, SystemException {
		ProgateOrganizationParticipants progateOrganizationParticipants = findByPrimaryKey(ProgateOrganizationParticipantsId);

		int count = countByapprovedBy(approvedBy);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProgateOrganizationParticipants WHERE ");

			query.append("approved_by = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("approved_at DESC, ");
				query.append("requested_at DESC, ");
				query.append("org_id ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(approvedBy);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					progateOrganizationParticipants);

			ProgateOrganizationParticipants[] array = new ProgateOrganizationParticipantsImpl[3];

			array[0] = (ProgateOrganizationParticipants)objArray[0];
			array[1] = (ProgateOrganizationParticipants)objArray[1];
			array[2] = (ProgateOrganizationParticipants)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProgateOrganizationParticipants> findByapprovedAt(
		Date approvedAt) throws SystemException {
		Object[] finderArgs = new Object[] { approvedAt };

		List<ProgateOrganizationParticipants> list = (List<ProgateOrganizationParticipants>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_APPROVEDAT,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProgateOrganizationParticipants WHERE ");

				if (approvedAt == null) {
					query.append("approved_at IS NULL");
				}
				else {
					query.append("approved_at = ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("approved_at DESC, ");
				query.append("requested_at DESC, ");
				query.append("org_id ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (approvedAt != null) {
					qPos.add(CalendarUtil.getTimestamp(approvedAt));
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProgateOrganizationParticipants>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_APPROVEDAT,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProgateOrganizationParticipants> findByapprovedAt(
		Date approvedAt, int start, int end) throws SystemException {
		return findByapprovedAt(approvedAt, start, end, null);
	}

	public List<ProgateOrganizationParticipants> findByapprovedAt(
		Date approvedAt, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				approvedAt,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProgateOrganizationParticipants> list = (List<ProgateOrganizationParticipants>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_APPROVEDAT,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProgateOrganizationParticipants WHERE ");

				if (approvedAt == null) {
					query.append("approved_at IS NULL");
				}
				else {
					query.append("approved_at = ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("approved_at DESC, ");
					query.append("requested_at DESC, ");
					query.append("org_id ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (approvedAt != null) {
					qPos.add(CalendarUtil.getTimestamp(approvedAt));
				}

				list = (List<ProgateOrganizationParticipants>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProgateOrganizationParticipants>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_APPROVEDAT,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProgateOrganizationParticipants findByapprovedAt_First(
		Date approvedAt, OrderByComparator obc)
		throws NoSuchProgateOrganizationParticipantsException, SystemException {
		List<ProgateOrganizationParticipants> list = findByapprovedAt(approvedAt,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No ProgateOrganizationParticipants exists with the key {");

			msg.append("approvedAt=" + approvedAt);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProgateOrganizationParticipantsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProgateOrganizationParticipants findByapprovedAt_Last(
		Date approvedAt, OrderByComparator obc)
		throws NoSuchProgateOrganizationParticipantsException, SystemException {
		int count = countByapprovedAt(approvedAt);

		List<ProgateOrganizationParticipants> list = findByapprovedAt(approvedAt,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No ProgateOrganizationParticipants exists with the key {");

			msg.append("approvedAt=" + approvedAt);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProgateOrganizationParticipantsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProgateOrganizationParticipants[] findByapprovedAt_PrevAndNext(
		Integer ProgateOrganizationParticipantsId, Date approvedAt,
		OrderByComparator obc)
		throws NoSuchProgateOrganizationParticipantsException, SystemException {
		ProgateOrganizationParticipants progateOrganizationParticipants = findByPrimaryKey(ProgateOrganizationParticipantsId);

		int count = countByapprovedAt(approvedAt);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProgateOrganizationParticipants WHERE ");

			if (approvedAt == null) {
				query.append("approved_at IS NULL");
			}
			else {
				query.append("approved_at = ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("approved_at DESC, ");
				query.append("requested_at DESC, ");
				query.append("org_id ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (approvedAt != null) {
				qPos.add(CalendarUtil.getTimestamp(approvedAt));
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					progateOrganizationParticipants);

			ProgateOrganizationParticipants[] array = new ProgateOrganizationParticipantsImpl[3];

			array[0] = (ProgateOrganizationParticipants)objArray[0];
			array[1] = (ProgateOrganizationParticipants)objArray[1];
			array[2] = (ProgateOrganizationParticipants)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProgateOrganizationParticipants> findBystatus(int status)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(status) };

		List<ProgateOrganizationParticipants> list = (List<ProgateOrganizationParticipants>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_STATUS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProgateOrganizationParticipants WHERE ");

				query.append("status = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("approved_at DESC, ");
				query.append("requested_at DESC, ");
				query.append("org_id ASC");

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
					list = new ArrayList<ProgateOrganizationParticipants>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_STATUS,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProgateOrganizationParticipants> findBystatus(int status,
		int start, int end) throws SystemException {
		return findBystatus(status, start, end, null);
	}

	public List<ProgateOrganizationParticipants> findBystatus(int status,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(status),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProgateOrganizationParticipants> list = (List<ProgateOrganizationParticipants>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_STATUS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProgateOrganizationParticipants WHERE ");

				query.append("status = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("approved_at DESC, ");
					query.append("requested_at DESC, ");
					query.append("org_id ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				list = (List<ProgateOrganizationParticipants>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProgateOrganizationParticipants>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_STATUS,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProgateOrganizationParticipants findBystatus_First(int status,
		OrderByComparator obc)
		throws NoSuchProgateOrganizationParticipantsException, SystemException {
		List<ProgateOrganizationParticipants> list = findBystatus(status, 0, 1,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No ProgateOrganizationParticipants exists with the key {");

			msg.append("status=" + status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProgateOrganizationParticipantsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProgateOrganizationParticipants findBystatus_Last(int status,
		OrderByComparator obc)
		throws NoSuchProgateOrganizationParticipantsException, SystemException {
		int count = countBystatus(status);

		List<ProgateOrganizationParticipants> list = findBystatus(status,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No ProgateOrganizationParticipants exists with the key {");

			msg.append("status=" + status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProgateOrganizationParticipantsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProgateOrganizationParticipants[] findBystatus_PrevAndNext(
		Integer ProgateOrganizationParticipantsId, int status,
		OrderByComparator obc)
		throws NoSuchProgateOrganizationParticipantsException, SystemException {
		ProgateOrganizationParticipants progateOrganizationParticipants = findByPrimaryKey(ProgateOrganizationParticipantsId);

		int count = countBystatus(status);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProgateOrganizationParticipants WHERE ");

			query.append("status = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("approved_at DESC, ");
				query.append("requested_at DESC, ");
				query.append("org_id ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(status);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					progateOrganizationParticipants);

			ProgateOrganizationParticipants[] array = new ProgateOrganizationParticipantsImpl[3];

			array[0] = (ProgateOrganizationParticipants)objArray[0];
			array[1] = (ProgateOrganizationParticipants)objArray[1];
			array[2] = (ProgateOrganizationParticipants)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProgateOrganizationParticipants> findByisCurrent(
		boolean isCurrent) throws SystemException {
		Object[] finderArgs = new Object[] { Boolean.valueOf(isCurrent) };

		List<ProgateOrganizationParticipants> list = (List<ProgateOrganizationParticipants>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ISCURRENT,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProgateOrganizationParticipants WHERE ");

				query.append("is_current = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("approved_at DESC, ");
				query.append("requested_at DESC, ");
				query.append("org_id ASC");

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
					list = new ArrayList<ProgateOrganizationParticipants>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ISCURRENT,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProgateOrganizationParticipants> findByisCurrent(
		boolean isCurrent, int start, int end) throws SystemException {
		return findByisCurrent(isCurrent, start, end, null);
	}

	public List<ProgateOrganizationParticipants> findByisCurrent(
		boolean isCurrent, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				Boolean.valueOf(isCurrent),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProgateOrganizationParticipants> list = (List<ProgateOrganizationParticipants>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ISCURRENT,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProgateOrganizationParticipants WHERE ");

				query.append("is_current = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("approved_at DESC, ");
					query.append("requested_at DESC, ");
					query.append("org_id ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isCurrent);

				list = (List<ProgateOrganizationParticipants>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProgateOrganizationParticipants>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ISCURRENT,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProgateOrganizationParticipants findByisCurrent_First(
		boolean isCurrent, OrderByComparator obc)
		throws NoSuchProgateOrganizationParticipantsException, SystemException {
		List<ProgateOrganizationParticipants> list = findByisCurrent(isCurrent,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No ProgateOrganizationParticipants exists with the key {");

			msg.append("isCurrent=" + isCurrent);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProgateOrganizationParticipantsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProgateOrganizationParticipants findByisCurrent_Last(
		boolean isCurrent, OrderByComparator obc)
		throws NoSuchProgateOrganizationParticipantsException, SystemException {
		int count = countByisCurrent(isCurrent);

		List<ProgateOrganizationParticipants> list = findByisCurrent(isCurrent,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No ProgateOrganizationParticipants exists with the key {");

			msg.append("isCurrent=" + isCurrent);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProgateOrganizationParticipantsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProgateOrganizationParticipants[] findByisCurrent_PrevAndNext(
		Integer ProgateOrganizationParticipantsId, boolean isCurrent,
		OrderByComparator obc)
		throws NoSuchProgateOrganizationParticipantsException, SystemException {
		ProgateOrganizationParticipants progateOrganizationParticipants = findByPrimaryKey(ProgateOrganizationParticipantsId);

		int count = countByisCurrent(isCurrent);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProgateOrganizationParticipants WHERE ");

			query.append("is_current = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("approved_at DESC, ");
				query.append("requested_at DESC, ");
				query.append("org_id ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(isCurrent);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					progateOrganizationParticipants);

			ProgateOrganizationParticipants[] array = new ProgateOrganizationParticipantsImpl[3];

			array[0] = (ProgateOrganizationParticipants)objArray[0];
			array[1] = (ProgateOrganizationParticipants)objArray[1];
			array[2] = (ProgateOrganizationParticipants)objArray[2];

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

	public List<ProgateOrganizationParticipants> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<ProgateOrganizationParticipants> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<ProgateOrganizationParticipants> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProgateOrganizationParticipants> list = (List<ProgateOrganizationParticipants>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProgateOrganizationParticipants ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("approved_at DESC, ");
					query.append("requested_at DESC, ");
					query.append("org_id ASC");
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<ProgateOrganizationParticipants>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ProgateOrganizationParticipants>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProgateOrganizationParticipants>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByuserId(int userId) throws SystemException {
		for (ProgateOrganizationParticipants progateOrganizationParticipants : findByuserId(
				userId)) {
			remove(progateOrganizationParticipants);
		}
	}

	public void removeByorgId(int orgId) throws SystemException {
		for (ProgateOrganizationParticipants progateOrganizationParticipants : findByorgId(
				orgId)) {
			remove(progateOrganizationParticipants);
		}
	}

	public void removeByroleId(int roleId) throws SystemException {
		for (ProgateOrganizationParticipants progateOrganizationParticipants : findByroleId(
				roleId)) {
			remove(progateOrganizationParticipants);
		}
	}

	public void removeByrequestedBy(int requestedBy) throws SystemException {
		for (ProgateOrganizationParticipants progateOrganizationParticipants : findByrequestedBy(
				requestedBy)) {
			remove(progateOrganizationParticipants);
		}
	}

	public void removeByrequestedAt(Date requestedAt) throws SystemException {
		for (ProgateOrganizationParticipants progateOrganizationParticipants : findByrequestedAt(
				requestedAt)) {
			remove(progateOrganizationParticipants);
		}
	}

	public void removeByapprovedBy(int approvedBy) throws SystemException {
		for (ProgateOrganizationParticipants progateOrganizationParticipants : findByapprovedBy(
				approvedBy)) {
			remove(progateOrganizationParticipants);
		}
	}

	public void removeByapprovedAt(Date approvedAt) throws SystemException {
		for (ProgateOrganizationParticipants progateOrganizationParticipants : findByapprovedAt(
				approvedAt)) {
			remove(progateOrganizationParticipants);
		}
	}

	public void removeBystatus(int status) throws SystemException {
		for (ProgateOrganizationParticipants progateOrganizationParticipants : findBystatus(
				status)) {
			remove(progateOrganizationParticipants);
		}
	}

	public void removeByisCurrent(boolean isCurrent) throws SystemException {
		for (ProgateOrganizationParticipants progateOrganizationParticipants : findByisCurrent(
				isCurrent)) {
			remove(progateOrganizationParticipants);
		}
	}

	public void removeAll() throws SystemException {
		for (ProgateOrganizationParticipants progateOrganizationParticipants : findAll()) {
			remove(progateOrganizationParticipants);
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
					"FROM larion.progate.model.ProgateOrganizationParticipants WHERE ");

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
					"FROM larion.progate.model.ProgateOrganizationParticipants WHERE ");

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
					"FROM larion.progate.model.ProgateOrganizationParticipants WHERE ");

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

	public int countByrequestedBy(int requestedBy) throws SystemException {
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
					"FROM larion.progate.model.ProgateOrganizationParticipants WHERE ");

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

	public int countByrequestedAt(Date requestedAt) throws SystemException {
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
					"FROM larion.progate.model.ProgateOrganizationParticipants WHERE ");

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

	public int countByapprovedBy(int approvedBy) throws SystemException {
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
					"FROM larion.progate.model.ProgateOrganizationParticipants WHERE ");

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

	public int countByapprovedAt(Date approvedAt) throws SystemException {
		Object[] finderArgs = new Object[] { approvedAt };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_APPROVEDAT,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProgateOrganizationParticipants WHERE ");

				if (approvedAt == null) {
					query.append("approved_at IS NULL");
				}
				else {
					query.append("approved_at = ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (approvedAt != null) {
					qPos.add(CalendarUtil.getTimestamp(approvedAt));
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_APPROVEDAT,
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
					"FROM larion.progate.model.ProgateOrganizationParticipants WHERE ");

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
					"FROM larion.progate.model.ProgateOrganizationParticipants WHERE ");

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

	public int countAll() throws SystemException {
		Object[] finderArgs = new Object[0];

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(
						"SELECT COUNT(*) FROM larion.progate.model.ProgateOrganizationParticipants");

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
						"value.object.listener.larion.progate.model.ProgateOrganizationParticipants")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ProgateOrganizationParticipants>> listenersList =
					new ArrayList<ModelListener<ProgateOrganizationParticipants>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ProgateOrganizationParticipants>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(ProgateOrganizationParticipantsPersistenceImpl.class);
}