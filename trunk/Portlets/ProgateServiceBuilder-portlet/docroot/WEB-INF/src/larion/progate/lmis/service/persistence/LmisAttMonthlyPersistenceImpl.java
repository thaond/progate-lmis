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

import larion.progate.lmis.NoSuchLmisAttMonthlyException;
import larion.progate.lmis.model.LmisAttMonthly;
import larion.progate.lmis.model.impl.LmisAttMonthlyImpl;
import larion.progate.lmis.model.impl.LmisAttMonthlyModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="LmisAttMonthlyPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisAttMonthlyPersistenceImpl extends BasePersistenceImpl
	implements LmisAttMonthlyPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = LmisAttMonthlyImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_ROOTID = new FinderPath(LmisAttMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAttMonthlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ROOTID = new FinderPath(LmisAttMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAttMonthlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ROOTID = new FinderPath(LmisAttMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAttMonthlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByRootId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_NUMDAYAWARD = new FinderPath(LmisAttMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAttMonthlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByNumDayAward",
			new String[] { Double.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_NUMDAYAWARD = new FinderPath(LmisAttMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAttMonthlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByNumDayAward",
			new String[] {
				Double.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_NUMDAYAWARD = new FinderPath(LmisAttMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAttMonthlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByNumDayAward",
			new String[] { Double.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_USERID = new FinderPath(LmisAttMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAttMonthlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByUserId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_USERID = new FinderPath(LmisAttMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAttMonthlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByUserId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(LmisAttMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAttMonthlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByUserId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_MONTHVALUE = new FinderPath(LmisAttMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAttMonthlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByMonthValue",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_MONTHVALUE = new FinderPath(LmisAttMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAttMonthlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByMonthValue",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_MONTHVALUE = new FinderPath(LmisAttMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAttMonthlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByMonthValue",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_YEARVALUE = new FinderPath(LmisAttMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAttMonthlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByYearValue",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_YEARVALUE = new FinderPath(LmisAttMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAttMonthlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByYearValue",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_YEARVALUE = new FinderPath(LmisAttMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAttMonthlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByYearValue",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(LmisAttMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAttMonthlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LmisAttMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAttMonthlyModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(LmisAttMonthly lmisAttMonthly) {
		EntityCacheUtil.putResult(LmisAttMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAttMonthlyImpl.class, lmisAttMonthly.getPrimaryKey(),
			lmisAttMonthly);
	}

	public void cacheResult(List<LmisAttMonthly> lmisAttMonthlies) {
		for (LmisAttMonthly lmisAttMonthly : lmisAttMonthlies) {
			if (EntityCacheUtil.getResult(
						LmisAttMonthlyModelImpl.ENTITY_CACHE_ENABLED,
						LmisAttMonthlyImpl.class,
						lmisAttMonthly.getPrimaryKey(), this) == null) {
				cacheResult(lmisAttMonthly);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(LmisAttMonthlyImpl.class.getName());
		EntityCacheUtil.clearCache(LmisAttMonthlyImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public LmisAttMonthly create(Integer lmisAttMonthlysId) {
		LmisAttMonthly lmisAttMonthly = new LmisAttMonthlyImpl();

		lmisAttMonthly.setNew(true);
		lmisAttMonthly.setPrimaryKey(lmisAttMonthlysId);

		return lmisAttMonthly;
	}

	public LmisAttMonthly remove(Integer lmisAttMonthlysId)
		throws NoSuchLmisAttMonthlyException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LmisAttMonthly lmisAttMonthly = (LmisAttMonthly)session.get(LmisAttMonthlyImpl.class,
					lmisAttMonthlysId);

			if (lmisAttMonthly == null) {
				if (_log.isWarnEnabled()) {
					_log.warn("No LmisAttMonthly exists with the primary key " +
						lmisAttMonthlysId);
				}

				throw new NoSuchLmisAttMonthlyException(
					"No LmisAttMonthly exists with the primary key " +
					lmisAttMonthlysId);
			}

			return remove(lmisAttMonthly);
		}
		catch (NoSuchLmisAttMonthlyException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public LmisAttMonthly remove(LmisAttMonthly lmisAttMonthly)
		throws SystemException {
		for (ModelListener<LmisAttMonthly> listener : listeners) {
			listener.onBeforeRemove(lmisAttMonthly);
		}

		lmisAttMonthly = removeImpl(lmisAttMonthly);

		for (ModelListener<LmisAttMonthly> listener : listeners) {
			listener.onAfterRemove(lmisAttMonthly);
		}

		return lmisAttMonthly;
	}

	protected LmisAttMonthly removeImpl(LmisAttMonthly lmisAttMonthly)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (lmisAttMonthly.isCachedModel() || BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(LmisAttMonthlyImpl.class,
						lmisAttMonthly.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(lmisAttMonthly);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(LmisAttMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAttMonthlyImpl.class, lmisAttMonthly.getPrimaryKey());

		return lmisAttMonthly;
	}

	public LmisAttMonthly update(LmisAttMonthly lmisAttMonthly)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(LmisAttMonthly lmisAttMonthly) method. Use update(LmisAttMonthly lmisAttMonthly, boolean merge) instead.");
		}

		return update(lmisAttMonthly, false);
	}

	public LmisAttMonthly update(LmisAttMonthly lmisAttMonthly, boolean merge)
		throws SystemException {
		boolean isNew = lmisAttMonthly.isNew();

		for (ModelListener<LmisAttMonthly> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(lmisAttMonthly);
			}
			else {
				listener.onBeforeUpdate(lmisAttMonthly);
			}
		}

		lmisAttMonthly = updateImpl(lmisAttMonthly, merge);

		for (ModelListener<LmisAttMonthly> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(lmisAttMonthly);
			}
			else {
				listener.onAfterUpdate(lmisAttMonthly);
			}
		}

		return lmisAttMonthly;
	}

	public LmisAttMonthly updateImpl(
		larion.progate.lmis.model.LmisAttMonthly lmisAttMonthly, boolean merge)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, lmisAttMonthly, merge);

			lmisAttMonthly.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(LmisAttMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			LmisAttMonthlyImpl.class, lmisAttMonthly.getPrimaryKey(),
			lmisAttMonthly);

		return lmisAttMonthly;
	}

	public LmisAttMonthly findByPrimaryKey(Integer lmisAttMonthlysId)
		throws NoSuchLmisAttMonthlyException, SystemException {
		LmisAttMonthly lmisAttMonthly = fetchByPrimaryKey(lmisAttMonthlysId);

		if (lmisAttMonthly == null) {
			if (_log.isWarnEnabled()) {
				_log.warn("No LmisAttMonthly exists with the primary key " +
					lmisAttMonthlysId);
			}

			throw new NoSuchLmisAttMonthlyException(
				"No LmisAttMonthly exists with the primary key " +
				lmisAttMonthlysId);
		}

		return lmisAttMonthly;
	}

	public LmisAttMonthly fetchByPrimaryKey(Integer lmisAttMonthlysId)
		throws SystemException {
		LmisAttMonthly lmisAttMonthly = (LmisAttMonthly)EntityCacheUtil.getResult(LmisAttMonthlyModelImpl.ENTITY_CACHE_ENABLED,
				LmisAttMonthlyImpl.class, lmisAttMonthlysId, this);

		if (lmisAttMonthly == null) {
			Session session = null;

			try {
				session = openSession();

				lmisAttMonthly = (LmisAttMonthly)session.get(LmisAttMonthlyImpl.class,
						lmisAttMonthlysId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (lmisAttMonthly != null) {
					cacheResult(lmisAttMonthly);
				}

				closeSession(session);
			}
		}

		return lmisAttMonthly;
	}

	public List<LmisAttMonthly> findByRootId(int rootId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		List<LmisAttMonthly> list = (List<LmisAttMonthly>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAttMonthly WHERE ");

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
					list = new ArrayList<LmisAttMonthly>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisAttMonthly> findByRootId(int rootId, int start, int end)
		throws SystemException {
		return findByRootId(rootId, start, end, null);
	}

	public List<LmisAttMonthly> findByRootId(int rootId, int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(rootId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisAttMonthly> list = (List<LmisAttMonthly>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAttMonthly WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rootId);

				list = (List<LmisAttMonthly>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisAttMonthly>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisAttMonthly findByRootId_First(int rootId, OrderByComparator obc)
		throws NoSuchLmisAttMonthlyException, SystemException {
		List<LmisAttMonthly> list = findByRootId(rootId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAttMonthly exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAttMonthlyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAttMonthly findByRootId_Last(int rootId, OrderByComparator obc)
		throws NoSuchLmisAttMonthlyException, SystemException {
		int count = countByRootId(rootId);

		List<LmisAttMonthly> list = findByRootId(rootId, count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAttMonthly exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAttMonthlyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAttMonthly[] findByRootId_PrevAndNext(
		Integer lmisAttMonthlysId, int rootId, OrderByComparator obc)
		throws NoSuchLmisAttMonthlyException, SystemException {
		LmisAttMonthly lmisAttMonthly = findByPrimaryKey(lmisAttMonthlysId);

		int count = countByRootId(rootId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.lmis.model.LmisAttMonthly WHERE ");

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
					lmisAttMonthly);

			LmisAttMonthly[] array = new LmisAttMonthlyImpl[3];

			array[0] = (LmisAttMonthly)objArray[0];
			array[1] = (LmisAttMonthly)objArray[1];
			array[2] = (LmisAttMonthly)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisAttMonthly> findByNumDayAward(double numDayAward)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Double(numDayAward) };

		List<LmisAttMonthly> list = (List<LmisAttMonthly>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_NUMDAYAWARD,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAttMonthly WHERE ");

				query.append("num_day_award = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(numDayAward);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisAttMonthly>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_NUMDAYAWARD,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisAttMonthly> findByNumDayAward(double numDayAward,
		int start, int end) throws SystemException {
		return findByNumDayAward(numDayAward, start, end, null);
	}

	public List<LmisAttMonthly> findByNumDayAward(double numDayAward,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Double(numDayAward),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisAttMonthly> list = (List<LmisAttMonthly>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_NUMDAYAWARD,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAttMonthly WHERE ");

				query.append("num_day_award = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(numDayAward);

				list = (List<LmisAttMonthly>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisAttMonthly>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_NUMDAYAWARD,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisAttMonthly findByNumDayAward_First(double numDayAward,
		OrderByComparator obc)
		throws NoSuchLmisAttMonthlyException, SystemException {
		List<LmisAttMonthly> list = findByNumDayAward(numDayAward, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAttMonthly exists with the key {");

			msg.append("numDayAward=" + numDayAward);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAttMonthlyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAttMonthly findByNumDayAward_Last(double numDayAward,
		OrderByComparator obc)
		throws NoSuchLmisAttMonthlyException, SystemException {
		int count = countByNumDayAward(numDayAward);

		List<LmisAttMonthly> list = findByNumDayAward(numDayAward, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAttMonthly exists with the key {");

			msg.append("numDayAward=" + numDayAward);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAttMonthlyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAttMonthly[] findByNumDayAward_PrevAndNext(
		Integer lmisAttMonthlysId, double numDayAward, OrderByComparator obc)
		throws NoSuchLmisAttMonthlyException, SystemException {
		LmisAttMonthly lmisAttMonthly = findByPrimaryKey(lmisAttMonthlysId);

		int count = countByNumDayAward(numDayAward);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.lmis.model.LmisAttMonthly WHERE ");

			query.append("num_day_award = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(numDayAward);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisAttMonthly);

			LmisAttMonthly[] array = new LmisAttMonthlyImpl[3];

			array[0] = (LmisAttMonthly)objArray[0];
			array[1] = (LmisAttMonthly)objArray[1];
			array[2] = (LmisAttMonthly)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisAttMonthly> findByUserId(int userId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(userId) };

		List<LmisAttMonthly> list = (List<LmisAttMonthly>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_USERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAttMonthly WHERE ");

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
					list = new ArrayList<LmisAttMonthly>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_USERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisAttMonthly> findByUserId(int userId, int start, int end)
		throws SystemException {
		return findByUserId(userId, start, end, null);
	}

	public List<LmisAttMonthly> findByUserId(int userId, int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(userId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisAttMonthly> list = (List<LmisAttMonthly>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_USERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAttMonthly WHERE ");

				query.append("user_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				list = (List<LmisAttMonthly>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisAttMonthly>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_USERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisAttMonthly findByUserId_First(int userId, OrderByComparator obc)
		throws NoSuchLmisAttMonthlyException, SystemException {
		List<LmisAttMonthly> list = findByUserId(userId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAttMonthly exists with the key {");

			msg.append("userId=" + userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAttMonthlyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAttMonthly findByUserId_Last(int userId, OrderByComparator obc)
		throws NoSuchLmisAttMonthlyException, SystemException {
		int count = countByUserId(userId);

		List<LmisAttMonthly> list = findByUserId(userId, count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAttMonthly exists with the key {");

			msg.append("userId=" + userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAttMonthlyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAttMonthly[] findByUserId_PrevAndNext(
		Integer lmisAttMonthlysId, int userId, OrderByComparator obc)
		throws NoSuchLmisAttMonthlyException, SystemException {
		LmisAttMonthly lmisAttMonthly = findByPrimaryKey(lmisAttMonthlysId);

		int count = countByUserId(userId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.lmis.model.LmisAttMonthly WHERE ");

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
					lmisAttMonthly);

			LmisAttMonthly[] array = new LmisAttMonthlyImpl[3];

			array[0] = (LmisAttMonthly)objArray[0];
			array[1] = (LmisAttMonthly)objArray[1];
			array[2] = (LmisAttMonthly)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisAttMonthly> findByMonthValue(int monthValue)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(monthValue) };

		List<LmisAttMonthly> list = (List<LmisAttMonthly>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_MONTHVALUE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAttMonthly WHERE ");

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
					list = new ArrayList<LmisAttMonthly>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_MONTHVALUE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisAttMonthly> findByMonthValue(int monthValue, int start,
		int end) throws SystemException {
		return findByMonthValue(monthValue, start, end, null);
	}

	public List<LmisAttMonthly> findByMonthValue(int monthValue, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(monthValue),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisAttMonthly> list = (List<LmisAttMonthly>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_MONTHVALUE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAttMonthly WHERE ");

				query.append("month_value = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(monthValue);

				list = (List<LmisAttMonthly>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisAttMonthly>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_MONTHVALUE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisAttMonthly findByMonthValue_First(int monthValue,
		OrderByComparator obc)
		throws NoSuchLmisAttMonthlyException, SystemException {
		List<LmisAttMonthly> list = findByMonthValue(monthValue, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAttMonthly exists with the key {");

			msg.append("monthValue=" + monthValue);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAttMonthlyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAttMonthly findByMonthValue_Last(int monthValue,
		OrderByComparator obc)
		throws NoSuchLmisAttMonthlyException, SystemException {
		int count = countByMonthValue(monthValue);

		List<LmisAttMonthly> list = findByMonthValue(monthValue, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAttMonthly exists with the key {");

			msg.append("monthValue=" + monthValue);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAttMonthlyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAttMonthly[] findByMonthValue_PrevAndNext(
		Integer lmisAttMonthlysId, int monthValue, OrderByComparator obc)
		throws NoSuchLmisAttMonthlyException, SystemException {
		LmisAttMonthly lmisAttMonthly = findByPrimaryKey(lmisAttMonthlysId);

		int count = countByMonthValue(monthValue);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.lmis.model.LmisAttMonthly WHERE ");

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
					lmisAttMonthly);

			LmisAttMonthly[] array = new LmisAttMonthlyImpl[3];

			array[0] = (LmisAttMonthly)objArray[0];
			array[1] = (LmisAttMonthly)objArray[1];
			array[2] = (LmisAttMonthly)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisAttMonthly> findByYearValue(int yearValue)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(yearValue) };

		List<LmisAttMonthly> list = (List<LmisAttMonthly>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_YEARVALUE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAttMonthly WHERE ");

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
					list = new ArrayList<LmisAttMonthly>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_YEARVALUE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisAttMonthly> findByYearValue(int yearValue, int start,
		int end) throws SystemException {
		return findByYearValue(yearValue, start, end, null);
	}

	public List<LmisAttMonthly> findByYearValue(int yearValue, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(yearValue),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisAttMonthly> list = (List<LmisAttMonthly>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_YEARVALUE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisAttMonthly WHERE ");

				query.append("year_value = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(yearValue);

				list = (List<LmisAttMonthly>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisAttMonthly>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_YEARVALUE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisAttMonthly findByYearValue_First(int yearValue,
		OrderByComparator obc)
		throws NoSuchLmisAttMonthlyException, SystemException {
		List<LmisAttMonthly> list = findByYearValue(yearValue, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAttMonthly exists with the key {");

			msg.append("yearValue=" + yearValue);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAttMonthlyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAttMonthly findByYearValue_Last(int yearValue,
		OrderByComparator obc)
		throws NoSuchLmisAttMonthlyException, SystemException {
		int count = countByYearValue(yearValue);

		List<LmisAttMonthly> list = findByYearValue(yearValue, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisAttMonthly exists with the key {");

			msg.append("yearValue=" + yearValue);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisAttMonthlyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisAttMonthly[] findByYearValue_PrevAndNext(
		Integer lmisAttMonthlysId, int yearValue, OrderByComparator obc)
		throws NoSuchLmisAttMonthlyException, SystemException {
		LmisAttMonthly lmisAttMonthly = findByPrimaryKey(lmisAttMonthlysId);

		int count = countByYearValue(yearValue);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.lmis.model.LmisAttMonthly WHERE ");

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
					lmisAttMonthly);

			LmisAttMonthly[] array = new LmisAttMonthlyImpl[3];

			array[0] = (LmisAttMonthly)objArray[0];
			array[1] = (LmisAttMonthly)objArray[1];
			array[2] = (LmisAttMonthly)objArray[2];

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

	public List<LmisAttMonthly> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<LmisAttMonthly> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<LmisAttMonthly> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisAttMonthly> list = (List<LmisAttMonthly>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.lmis.model.LmisAttMonthly ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<LmisAttMonthly>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LmisAttMonthly>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisAttMonthly>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByRootId(int rootId) throws SystemException {
		for (LmisAttMonthly lmisAttMonthly : findByRootId(rootId)) {
			remove(lmisAttMonthly);
		}
	}

	public void removeByNumDayAward(double numDayAward)
		throws SystemException {
		for (LmisAttMonthly lmisAttMonthly : findByNumDayAward(numDayAward)) {
			remove(lmisAttMonthly);
		}
	}

	public void removeByUserId(int userId) throws SystemException {
		for (LmisAttMonthly lmisAttMonthly : findByUserId(userId)) {
			remove(lmisAttMonthly);
		}
	}

	public void removeByMonthValue(int monthValue) throws SystemException {
		for (LmisAttMonthly lmisAttMonthly : findByMonthValue(monthValue)) {
			remove(lmisAttMonthly);
		}
	}

	public void removeByYearValue(int yearValue) throws SystemException {
		for (LmisAttMonthly lmisAttMonthly : findByYearValue(yearValue)) {
			remove(lmisAttMonthly);
		}
	}

	public void removeAll() throws SystemException {
		for (LmisAttMonthly lmisAttMonthly : findAll()) {
			remove(lmisAttMonthly);
		}
	}

	public int countByRootId(int rootId) throws SystemException {
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
					"FROM larion.progate.lmis.model.LmisAttMonthly WHERE ");

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

	public int countByNumDayAward(double numDayAward) throws SystemException {
		Object[] finderArgs = new Object[] { new Double(numDayAward) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_NUMDAYAWARD,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisAttMonthly WHERE ");

				query.append("num_day_award = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(numDayAward);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NUMDAYAWARD,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByUserId(int userId) throws SystemException {
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
					"FROM larion.progate.lmis.model.LmisAttMonthly WHERE ");

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
					"FROM larion.progate.lmis.model.LmisAttMonthly WHERE ");

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
					"FROM larion.progate.lmis.model.LmisAttMonthly WHERE ");

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

	public int countAll() throws SystemException {
		Object[] finderArgs = new Object[0];

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(
						"SELECT COUNT(*) FROM larion.progate.lmis.model.LmisAttMonthly");

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
						"value.object.listener.larion.progate.lmis.model.LmisAttMonthly")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LmisAttMonthly>> listenersList = new ArrayList<ModelListener<LmisAttMonthly>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LmisAttMonthly>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(LmisAttMonthlyPersistenceImpl.class);
}