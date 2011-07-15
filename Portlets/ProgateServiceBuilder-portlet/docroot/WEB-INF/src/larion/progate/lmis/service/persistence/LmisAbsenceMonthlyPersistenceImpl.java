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

import larion.progate.lmis.NoSuchLmisAbsenceMonthlyException;
import larion.progate.lmis.model.LmisAbsenceMonthly;
import larion.progate.lmis.model.impl.LmisAbsenceMonthlyImpl;
import larion.progate.lmis.model.impl.LmisAbsenceMonthlyModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="LmisAbsenceMonthlyPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisAbsenceMonthlyPersistenceImpl extends BasePersistenceImpl
	implements LmisAbsenceMonthlyPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = LmisAbsenceMonthlyImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_ROOTID = new FinderPath(LmisAbsenceMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceMonthlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ROOTID = new FinderPath(LmisAbsenceMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceMonthlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ROOTID = new FinderPath(LmisAbsenceMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceMonthlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByRootID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_USERID = new FinderPath(LmisAbsenceMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceMonthlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByuserID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_USERID = new FinderPath(LmisAbsenceMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceMonthlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByuserID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(LmisAbsenceMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceMonthlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByuserID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_MONTHVALUE = new FinderPath(LmisAbsenceMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceMonthlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByMonthValue",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_MONTHVALUE = new FinderPath(LmisAbsenceMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceMonthlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByMonthValue",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_MONTHVALUE = new FinderPath(LmisAbsenceMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceMonthlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByMonthValue",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_YEARVALUE = new FinderPath(LmisAbsenceMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceMonthlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByYearValue",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_YEARVALUE = new FinderPath(LmisAbsenceMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceMonthlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByYearValue",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_YEARVALUE = new FinderPath(LmisAbsenceMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceMonthlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByYearValue",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ABSENCETYPE = new FinderPath(LmisAbsenceMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceMonthlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByAbsenceType",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ABSENCETYPE = new FinderPath(LmisAbsenceMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceMonthlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByAbsenceType",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ABSENCETYPE = new FinderPath(LmisAbsenceMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceMonthlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByAbsenceType",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ABSENCETYPEID = new FinderPath(LmisAbsenceMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceMonthlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByAbsenceTypeID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ABSENCETYPEID = new FinderPath(LmisAbsenceMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceMonthlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByAbsenceTypeID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ABSENCETYPEID = new FinderPath(LmisAbsenceMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceMonthlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByAbsenceTypeID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(LmisAbsenceMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceMonthlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LmisAbsenceMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceMonthlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(LmisAbsenceMonthly lmisAbsenceMonthly) {
		EntityCacheUtil.putResult(LmisAbsenceMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceMonthlyImpl.class, lmisAbsenceMonthly.getPrimaryKey(),
			lmisAbsenceMonthly);
	}

	public void cacheResult(List<LmisAbsenceMonthly> lmisAbsenceMonthlies) {
		for (LmisAbsenceMonthly lmisAbsenceMonthly : lmisAbsenceMonthlies) {
			if (EntityCacheUtil.getResult(
						LmisAbsenceMonthlyModelImpl.ENTITY_CACHE_ENABLED,
						LmisAbsenceMonthlyImpl.class,
						lmisAbsenceMonthly.getPrimaryKey(), this) == null) {
				cacheResult(lmisAbsenceMonthly);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(LmisAbsenceMonthlyImpl.class.getName());
		EntityCacheUtil.clearCache(LmisAbsenceMonthlyImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public LmisAbsenceMonthly create(Integer lmisAbsenceMonthlyId) {
		LmisAbsenceMonthly lmisAbsenceMonthly = new LmisAbsenceMonthlyImpl();

		lmisAbsenceMonthly.setNew(true);
		lmisAbsenceMonthly.setPrimaryKey(lmisAbsenceMonthlyId);

		return lmisAbsenceMonthly;
	}

	public LmisAbsenceMonthly remove(Integer lmisAbsenceMonthlyId)
		throws NoSuchLmisAbsenceMonthlyException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LmisAbsenceMonthly lmisAbsenceMonthly = (LmisAbsenceMonthly)session.get(LmisAbsenceMonthlyImpl.class,
					lmisAbsenceMonthlyId);

			if (lmisAbsenceMonthly == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No LmisAbsenceMonthly exists with the primary key " +
						lmisAbsenceMonthlyId);
				}

				throw new NoSuchLmisAbsenceMonthlyException(
					"No LmisAbsenceMonthly exists with the primary key " +
					lmisAbsenceMonthlyId);
			}

			return remove(lmisAbsenceMonthly);
		}
		catch (NoSuchLmisAbsenceMonthlyException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public LmisAbsenceMonthly remove(LmisAbsenceMonthly lmisAbsenceMonthly)
		throws SystemException {
		for (ModelListener<LmisAbsenceMonthly> listener : listeners) {
			listener.onBeforeRemove(lmisAbsenceMonthly);
		}

		lmisAbsenceMonthly = removeImpl(lmisAbsenceMonthly);

		for (ModelListener<LmisAbsenceMonthly> listener : listeners) {
			listener.onAfterRemove(lmisAbsenceMonthly);
		}

		return lmisAbsenceMonthly;
	}

	protected LmisAbsenceMonthly removeImpl(
		LmisAbsenceMonthly lmisAbsenceMonthly) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (lmisAbsenceMonthly.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(LmisAbsenceMonthlyImpl.class,
						lmisAbsenceMonthly.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(lmisAbsenceMonthly);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(LmisAbsenceMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceMonthlyImpl.class, lmisAbsenceMonthly.getPrimaryKey());

		return lmisAbsenceMonthly;
	}

	public LmisAbsenceMonthly update(LmisAbsenceMonthly lmisAbsenceMonthly)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(LmisAbsenceMonthly lmisAbsenceMonthly) method. Use update(LmisAbsenceMonthly lmisAbsenceMonthly, boolean merge) instead.");
		}

		return update(lmisAbsenceMonthly, false);
	}

	public LmisAbsenceMonthly update(LmisAbsenceMonthly lmisAbsenceMonthly,
		boolean merge) throws SystemException {
		boolean isNew = lmisAbsenceMonthly.isNew();

		for (ModelListener<LmisAbsenceMonthly> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(lmisAbsenceMonthly);
			}
			else {
				listener.onBeforeUpdate(lmisAbsenceMonthly);
			}
		}

		lmisAbsenceMonthly = updateImpl(lmisAbsenceMonthly, merge);

		for (ModelListener<LmisAbsenceMonthly> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(lmisAbsenceMonthly);
			}
			else {
				listener.onAfterUpdate(lmisAbsenceMonthly);
			}
		}

		return lmisAbsenceMonthly;
	}

	public LmisAbsenceMonthly updateImpl(
		larion.progate.lmis.model.LmisAbsenceMonthly lmisAbsenceMonthly,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, lmisAbsenceMonthly, merge);

			lmisAbsenceMonthly.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(LmisAbsenceMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAbsenceMonthlyImpl.class, lmisAbsenceMonthly.getPrimaryKey(),
			lmisAbsenceMonthly);

		return lmisAbsenceMonthly;
	}

	public LmisAbsenceMonthly findByPrimaryKey(Integer lmisAbsenceMonthlyId)
		throws NoSuchLmisAbsenceMonthlyException, SystemException {
		LmisAbsenceMonthly lmisAbsenceMonthly = fetchByPrimaryKey(lmisAbsenceMonthlyId);

		if (lmisAbsenceMonthly == null) {
			if (_log.isWarnEnabled()) {
				_log.warn("No LmisAbsenceMonthly exists with the primary key " +
					lmisAbsenceMonthlyId);
			}

			throw new NoSuchLmisAbsenceMonthlyException(
				"No LmisAbsenceMonthly exists with the primary key " +
				lmisAbsenceMonthlyId);
		}

		return lmisAbsenceMonthly;
	}

	public LmisAbsenceMonthly fetchByPrimaryKey(Integer lmisAbsenceMonthlyId)
		throws SystemException {
		LmisAbsenceMonthly lmisAbsenceMonthly = (LmisAbsenceMonthly)EntityCacheUtil.getResult(LmisAbsenceMonthlyModelImpl.ENTITY_CACHE_ENABLED,
				LmisAbsenceMonthlyImpl.class, lmisAbsenceMonthlyId, this);

		if (lmisAbsenceMonthly == null) {
			Session session = null;

			try {
				session = openSession();

				lmisAbsenceMonthly = (LmisAbsenceMonthly)session.get(LmisAbsenceMonthlyImpl.class,
						lmisAbsenceMonthlyId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (lmisAbsenceMonthly != null) {
					cacheResult(lmisAbsenceMonthly);
				}

				closeSession(session);
			}
		}

		return lmisAbsenceMonthly;
	}

	public List<LmisAbsenceMonthly> findByRootID(int rootId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		List<LmisAbsenceMonthly> list = (List<LmisAbsenceMonthly>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceMonthly WHERE ");

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
					list = new ArrayList<LmisAbsenceMonthly>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisAbsenceMonthly> findByRootID(int rootId, int start, int end)
		throws SystemException {
		return findByRootID(rootId, start, end, null);
	}

	public List<LmisAbsenceMonthly> findByRootID(int rootId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(rootId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisAbsenceMonthly> list = (List<LmisAbsenceMonthly>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceMonthly WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rootId);

				list = (List<LmisAbsenceMonthly>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisAbsenceMonthly>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisAbsenceMonthly findByRootID_First(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisAbsenceMonthlyException, SystemException {
		List<LmisAbsenceMonthly> list = findByRootID(rootId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAbsenceMonthly exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAbsenceMonthlyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAbsenceMonthly findByRootID_Last(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisAbsenceMonthlyException, SystemException {
		int count = countByRootID(rootId);

		List<LmisAbsenceMonthly> list = findByRootID(rootId, count - 1, count,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAbsenceMonthly exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAbsenceMonthlyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAbsenceMonthly[] findByRootID_PrevAndNext(
		Integer lmisAbsenceMonthlyId, int rootId, OrderByComparator obc)
		throws NoSuchLmisAbsenceMonthlyException, SystemException {
		LmisAbsenceMonthly lmisAbsenceMonthly = findByPrimaryKey(lmisAbsenceMonthlyId);

		int count = countByRootID(rootId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisAbsenceMonthly WHERE ");

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
					lmisAbsenceMonthly);

			LmisAbsenceMonthly[] array = new LmisAbsenceMonthlyImpl[3];

			array[0] = (LmisAbsenceMonthly)objArray[0];
			array[1] = (LmisAbsenceMonthly)objArray[1];
			array[2] = (LmisAbsenceMonthly)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisAbsenceMonthly> findByuserID(int userId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(userId) };

		List<LmisAbsenceMonthly> list = (List<LmisAbsenceMonthly>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_USERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceMonthly WHERE ");

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
					list = new ArrayList<LmisAbsenceMonthly>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_USERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisAbsenceMonthly> findByuserID(int userId, int start, int end)
		throws SystemException {
		return findByuserID(userId, start, end, null);
	}

	public List<LmisAbsenceMonthly> findByuserID(int userId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(userId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisAbsenceMonthly> list = (List<LmisAbsenceMonthly>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_USERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceMonthly WHERE ");

				query.append("user_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				list = (List<LmisAbsenceMonthly>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisAbsenceMonthly>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_USERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisAbsenceMonthly findByuserID_First(int userId,
		OrderByComparator obc)
		throws NoSuchLmisAbsenceMonthlyException, SystemException {
		List<LmisAbsenceMonthly> list = findByuserID(userId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAbsenceMonthly exists with the key {");

			msg.append("userId=" + userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAbsenceMonthlyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAbsenceMonthly findByuserID_Last(int userId,
		OrderByComparator obc)
		throws NoSuchLmisAbsenceMonthlyException, SystemException {
		int count = countByuserID(userId);

		List<LmisAbsenceMonthly> list = findByuserID(userId, count - 1, count,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAbsenceMonthly exists with the key {");

			msg.append("userId=" + userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAbsenceMonthlyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAbsenceMonthly[] findByuserID_PrevAndNext(
		Integer lmisAbsenceMonthlyId, int userId, OrderByComparator obc)
		throws NoSuchLmisAbsenceMonthlyException, SystemException {
		LmisAbsenceMonthly lmisAbsenceMonthly = findByPrimaryKey(lmisAbsenceMonthlyId);

		int count = countByuserID(userId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisAbsenceMonthly WHERE ");

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
					lmisAbsenceMonthly);

			LmisAbsenceMonthly[] array = new LmisAbsenceMonthlyImpl[3];

			array[0] = (LmisAbsenceMonthly)objArray[0];
			array[1] = (LmisAbsenceMonthly)objArray[1];
			array[2] = (LmisAbsenceMonthly)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisAbsenceMonthly> findByMonthValue(int monthValue)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(monthValue) };

		List<LmisAbsenceMonthly> list = (List<LmisAbsenceMonthly>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_MONTHVALUE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceMonthly WHERE ");

				query.append("month_value = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(monthValue);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisAbsenceMonthly>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_MONTHVALUE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisAbsenceMonthly> findByMonthValue(int monthValue, int start,
		int end) throws SystemException {
		return findByMonthValue(monthValue, start, end, null);
	}

	public List<LmisAbsenceMonthly> findByMonthValue(int monthValue, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(monthValue),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisAbsenceMonthly> list = (List<LmisAbsenceMonthly>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_MONTHVALUE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceMonthly WHERE ");

				query.append("month_value = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(monthValue);

				list = (List<LmisAbsenceMonthly>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisAbsenceMonthly>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_MONTHVALUE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisAbsenceMonthly findByMonthValue_First(int monthValue,
		OrderByComparator obc)
		throws NoSuchLmisAbsenceMonthlyException, SystemException {
		List<LmisAbsenceMonthly> list = findByMonthValue(monthValue, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAbsenceMonthly exists with the key {");

			msg.append("monthValue=" + monthValue);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAbsenceMonthlyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAbsenceMonthly findByMonthValue_Last(int monthValue,
		OrderByComparator obc)
		throws NoSuchLmisAbsenceMonthlyException, SystemException {
		int count = countByMonthValue(monthValue);

		List<LmisAbsenceMonthly> list = findByMonthValue(monthValue, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAbsenceMonthly exists with the key {");

			msg.append("monthValue=" + monthValue);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAbsenceMonthlyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAbsenceMonthly[] findByMonthValue_PrevAndNext(
		Integer lmisAbsenceMonthlyId, int monthValue, OrderByComparator obc)
		throws NoSuchLmisAbsenceMonthlyException, SystemException {
		LmisAbsenceMonthly lmisAbsenceMonthly = findByPrimaryKey(lmisAbsenceMonthlyId);

		int count = countByMonthValue(monthValue);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisAbsenceMonthly WHERE ");

			query.append("month_value = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(monthValue);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisAbsenceMonthly);

			LmisAbsenceMonthly[] array = new LmisAbsenceMonthlyImpl[3];

			array[0] = (LmisAbsenceMonthly)objArray[0];
			array[1] = (LmisAbsenceMonthly)objArray[1];
			array[2] = (LmisAbsenceMonthly)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisAbsenceMonthly> findByYearValue(int yearValue)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(yearValue) };

		List<LmisAbsenceMonthly> list = (List<LmisAbsenceMonthly>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_YEARVALUE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceMonthly WHERE ");

				query.append("year_value = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(yearValue);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisAbsenceMonthly>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_YEARVALUE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisAbsenceMonthly> findByYearValue(int yearValue, int start,
		int end) throws SystemException {
		return findByYearValue(yearValue, start, end, null);
	}

	public List<LmisAbsenceMonthly> findByYearValue(int yearValue, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(yearValue),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisAbsenceMonthly> list = (List<LmisAbsenceMonthly>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_YEARVALUE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceMonthly WHERE ");

				query.append("year_value = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(yearValue);

				list = (List<LmisAbsenceMonthly>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisAbsenceMonthly>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_YEARVALUE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisAbsenceMonthly findByYearValue_First(int yearValue,
		OrderByComparator obc)
		throws NoSuchLmisAbsenceMonthlyException, SystemException {
		List<LmisAbsenceMonthly> list = findByYearValue(yearValue, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAbsenceMonthly exists with the key {");

			msg.append("yearValue=" + yearValue);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAbsenceMonthlyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAbsenceMonthly findByYearValue_Last(int yearValue,
		OrderByComparator obc)
		throws NoSuchLmisAbsenceMonthlyException, SystemException {
		int count = countByYearValue(yearValue);

		List<LmisAbsenceMonthly> list = findByYearValue(yearValue, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAbsenceMonthly exists with the key {");

			msg.append("yearValue=" + yearValue);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAbsenceMonthlyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAbsenceMonthly[] findByYearValue_PrevAndNext(
		Integer lmisAbsenceMonthlyId, int yearValue, OrderByComparator obc)
		throws NoSuchLmisAbsenceMonthlyException, SystemException {
		LmisAbsenceMonthly lmisAbsenceMonthly = findByPrimaryKey(lmisAbsenceMonthlyId);

		int count = countByYearValue(yearValue);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisAbsenceMonthly WHERE ");

			query.append("year_value = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(yearValue);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisAbsenceMonthly);

			LmisAbsenceMonthly[] array = new LmisAbsenceMonthlyImpl[3];

			array[0] = (LmisAbsenceMonthly)objArray[0];
			array[1] = (LmisAbsenceMonthly)objArray[1];
			array[2] = (LmisAbsenceMonthly)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisAbsenceMonthly> findByAbsenceType(String absenceType)
		throws SystemException {
		Object[] finderArgs = new Object[] { absenceType };

		List<LmisAbsenceMonthly> list = (List<LmisAbsenceMonthly>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ABSENCETYPE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceMonthly WHERE ");

				if (absenceType == null) {
					query.append("absence_type IS NULL");
				}
				else {
					query.append("absence_type = ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (absenceType != null) {
					qPos.add(absenceType);
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisAbsenceMonthly>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ABSENCETYPE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisAbsenceMonthly> findByAbsenceType(String absenceType,
		int start, int end) throws SystemException {
		return findByAbsenceType(absenceType, start, end, null);
	}

	public List<LmisAbsenceMonthly> findByAbsenceType(String absenceType,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				absenceType,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisAbsenceMonthly> list = (List<LmisAbsenceMonthly>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ABSENCETYPE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceMonthly WHERE ");

				if (absenceType == null) {
					query.append("absence_type IS NULL");
				}
				else {
					query.append("absence_type = ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (absenceType != null) {
					qPos.add(absenceType);
				}

				list = (List<LmisAbsenceMonthly>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisAbsenceMonthly>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ABSENCETYPE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisAbsenceMonthly findByAbsenceType_First(String absenceType,
		OrderByComparator obc)
		throws NoSuchLmisAbsenceMonthlyException, SystemException {
		List<LmisAbsenceMonthly> list = findByAbsenceType(absenceType, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAbsenceMonthly exists with the key {");

			msg.append("absenceType=" + absenceType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAbsenceMonthlyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAbsenceMonthly findByAbsenceType_Last(String absenceType,
		OrderByComparator obc)
		throws NoSuchLmisAbsenceMonthlyException, SystemException {
		int count = countByAbsenceType(absenceType);

		List<LmisAbsenceMonthly> list = findByAbsenceType(absenceType,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAbsenceMonthly exists with the key {");

			msg.append("absenceType=" + absenceType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAbsenceMonthlyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAbsenceMonthly[] findByAbsenceType_PrevAndNext(
		Integer lmisAbsenceMonthlyId, String absenceType, OrderByComparator obc)
		throws NoSuchLmisAbsenceMonthlyException, SystemException {
		LmisAbsenceMonthly lmisAbsenceMonthly = findByPrimaryKey(lmisAbsenceMonthlyId);

		int count = countByAbsenceType(absenceType);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisAbsenceMonthly WHERE ");

			if (absenceType == null) {
				query.append("absence_type IS NULL");
			}
			else {
				query.append("absence_type = ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (absenceType != null) {
				qPos.add(absenceType);
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisAbsenceMonthly);

			LmisAbsenceMonthly[] array = new LmisAbsenceMonthlyImpl[3];

			array[0] = (LmisAbsenceMonthly)objArray[0];
			array[1] = (LmisAbsenceMonthly)objArray[1];
			array[2] = (LmisAbsenceMonthly)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisAbsenceMonthly> findByAbsenceTypeID(int absenceTypeId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(absenceTypeId) };

		List<LmisAbsenceMonthly> list = (List<LmisAbsenceMonthly>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ABSENCETYPEID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceMonthly WHERE ");

				query.append("absence_type_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(absenceTypeId);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisAbsenceMonthly>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ABSENCETYPEID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisAbsenceMonthly> findByAbsenceTypeID(int absenceTypeId,
		int start, int end) throws SystemException {
		return findByAbsenceTypeID(absenceTypeId, start, end, null);
	}

	public List<LmisAbsenceMonthly> findByAbsenceTypeID(int absenceTypeId,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(absenceTypeId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisAbsenceMonthly> list = (List<LmisAbsenceMonthly>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ABSENCETYPEID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceMonthly WHERE ");

				query.append("absence_type_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(absenceTypeId);

				list = (List<LmisAbsenceMonthly>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisAbsenceMonthly>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ABSENCETYPEID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisAbsenceMonthly findByAbsenceTypeID_First(int absenceTypeId,
		OrderByComparator obc)
		throws NoSuchLmisAbsenceMonthlyException, SystemException {
		List<LmisAbsenceMonthly> list = findByAbsenceTypeID(absenceTypeId, 0,
				1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAbsenceMonthly exists with the key {");

			msg.append("absenceTypeId=" + absenceTypeId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAbsenceMonthlyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAbsenceMonthly findByAbsenceTypeID_Last(int absenceTypeId,
		OrderByComparator obc)
		throws NoSuchLmisAbsenceMonthlyException, SystemException {
		int count = countByAbsenceTypeID(absenceTypeId);

		List<LmisAbsenceMonthly> list = findByAbsenceTypeID(absenceTypeId,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAbsenceMonthly exists with the key {");

			msg.append("absenceTypeId=" + absenceTypeId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAbsenceMonthlyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAbsenceMonthly[] findByAbsenceTypeID_PrevAndNext(
		Integer lmisAbsenceMonthlyId, int absenceTypeId, OrderByComparator obc)
		throws NoSuchLmisAbsenceMonthlyException, SystemException {
		LmisAbsenceMonthly lmisAbsenceMonthly = findByPrimaryKey(lmisAbsenceMonthlyId);

		int count = countByAbsenceTypeID(absenceTypeId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisAbsenceMonthly WHERE ");

			query.append("absence_type_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(absenceTypeId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisAbsenceMonthly);

			LmisAbsenceMonthly[] array = new LmisAbsenceMonthlyImpl[3];

			array[0] = (LmisAbsenceMonthly)objArray[0];
			array[1] = (LmisAbsenceMonthly)objArray[1];
			array[2] = (LmisAbsenceMonthly)objArray[2];

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

	public List<LmisAbsenceMonthly> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<LmisAbsenceMonthly> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<LmisAbsenceMonthly> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisAbsenceMonthly> list = (List<LmisAbsenceMonthly>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceMonthly ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<LmisAbsenceMonthly>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LmisAbsenceMonthly>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisAbsenceMonthly>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByRootID(int rootId) throws SystemException {
		for (LmisAbsenceMonthly lmisAbsenceMonthly : findByRootID(rootId)) {
			remove(lmisAbsenceMonthly);
		}
	}

	public void removeByuserID(int userId) throws SystemException {
		for (LmisAbsenceMonthly lmisAbsenceMonthly : findByuserID(userId)) {
			remove(lmisAbsenceMonthly);
		}
	}

	public void removeByMonthValue(int monthValue) throws SystemException {
		for (LmisAbsenceMonthly lmisAbsenceMonthly : findByMonthValue(
				monthValue)) {
			remove(lmisAbsenceMonthly);
		}
	}

	public void removeByYearValue(int yearValue) throws SystemException {
		for (LmisAbsenceMonthly lmisAbsenceMonthly : findByYearValue(yearValue)) {
			remove(lmisAbsenceMonthly);
		}
	}

	public void removeByAbsenceType(String absenceType)
		throws SystemException {
		for (LmisAbsenceMonthly lmisAbsenceMonthly : findByAbsenceType(
				absenceType)) {
			remove(lmisAbsenceMonthly);
		}
	}

	public void removeByAbsenceTypeID(int absenceTypeId)
		throws SystemException {
		for (LmisAbsenceMonthly lmisAbsenceMonthly : findByAbsenceTypeID(
				absenceTypeId)) {
			remove(lmisAbsenceMonthly);
		}
	}

	public void removeAll() throws SystemException {
		for (LmisAbsenceMonthly lmisAbsenceMonthly : findAll()) {
			remove(lmisAbsenceMonthly);
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
					"FROM larion.progate.lmis.model.LmisAbsenceMonthly WHERE ");

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
					"FROM larion.progate.lmis.model.LmisAbsenceMonthly WHERE ");

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

	public int countByMonthValue(int monthValue) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(monthValue) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MONTHVALUE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceMonthly WHERE ");

				query.append("month_value = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(monthValue);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MONTHVALUE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByYearValue(int yearValue) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(yearValue) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_YEARVALUE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceMonthly WHERE ");

				query.append("year_value = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(yearValue);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_YEARVALUE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByAbsenceType(String absenceType) throws SystemException {
		Object[] finderArgs = new Object[] { absenceType };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ABSENCETYPE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceMonthly WHERE ");

				if (absenceType == null) {
					query.append("absence_type IS NULL");
				}
				else {
					query.append("absence_type = ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (absenceType != null) {
					qPos.add(absenceType);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ABSENCETYPE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByAbsenceTypeID(int absenceTypeId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(absenceTypeId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ABSENCETYPEID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisAbsenceMonthly WHERE ");

				query.append("absence_type_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(absenceTypeId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ABSENCETYPEID,
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
						"SELECT COUNT(*) FROM larion.progate.lmis.model.LmisAbsenceMonthly");

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
						"value.object.listener.larion.progate.lmis.model.LmisAbsenceMonthly")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LmisAbsenceMonthly>> listenersList = new ArrayList<ModelListener<LmisAbsenceMonthly>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LmisAbsenceMonthly>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(LmisAbsenceMonthlyPersistenceImpl.class);
}