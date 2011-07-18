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

import larion.progate.NoSuchProGateApplicationsException;

import larion.progate.model.ProGateApplications;
import larion.progate.model.impl.ProGateApplicationsImpl;
import larion.progate.model.impl.ProGateApplicationsModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * <a href="ProGateApplicationsPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateApplicationsPersistenceImpl extends BasePersistenceImpl
	implements ProGateApplicationsPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = ProGateApplicationsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_LAYOUTID = new FinderPath(ProGateApplicationsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateApplicationsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBylayoutId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_LAYOUTID = new FinderPath(ProGateApplicationsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateApplicationsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBylayoutId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_LAYOUTID = new FinderPath(ProGateApplicationsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateApplicationsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBylayoutId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_NAME = new FinderPath(ProGateApplicationsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateApplicationsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByname",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_NAME = new FinderPath(ProGateApplicationsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateApplicationsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByname",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(ProGateApplicationsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateApplicationsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByname",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ISHIDDEN = new FinderPath(ProGateApplicationsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateApplicationsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByisHidden",
			new String[] { Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ISHIDDEN = new FinderPath(ProGateApplicationsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateApplicationsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByisHidden",
			new String[] {
				Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ISHIDDEN = new FinderPath(ProGateApplicationsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateApplicationsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByisHidden",
			new String[] { Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_CREATEDDATEEQUAL = new FinderPath(ProGateApplicationsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateApplicationsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycreatedDateEqual",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_CREATEDDATEEQUAL = new FinderPath(ProGateApplicationsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateApplicationsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycreatedDateEqual",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_CREATEDDATEEQUAL = new FinderPath(ProGateApplicationsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateApplicationsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBycreatedDateEqual",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_CREATEDDATEGREATER = new FinderPath(ProGateApplicationsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateApplicationsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycreatedDateGreater",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_CREATEDDATEGREATER = new FinderPath(ProGateApplicationsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateApplicationsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycreatedDateGreater",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_CREATEDDATEGREATER = new FinderPath(ProGateApplicationsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateApplicationsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBycreatedDateGreater",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_CREATEDDATELOWER = new FinderPath(ProGateApplicationsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateApplicationsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycreatedDateLower",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_CREATEDDATELOWER = new FinderPath(ProGateApplicationsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateApplicationsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycreatedDateLower",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_CREATEDDATELOWER = new FinderPath(ProGateApplicationsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateApplicationsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBycreatedDateLower",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_MODIFIEDDATEEQUAL = new FinderPath(ProGateApplicationsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateApplicationsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBymodifiedDateEqual",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_MODIFIEDDATEEQUAL = new FinderPath(ProGateApplicationsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateApplicationsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBymodifiedDateEqual",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_MODIFIEDDATEEQUAL = new FinderPath(ProGateApplicationsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateApplicationsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBymodifiedDateEqual",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_MODIFIEDDATEGREATER = new FinderPath(ProGateApplicationsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateApplicationsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBymodifiedDateGreater",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_MODIFIEDDATEGREATER = new FinderPath(ProGateApplicationsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateApplicationsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBymodifiedDateGreater",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_MODIFIEDDATEGREATER = new FinderPath(ProGateApplicationsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateApplicationsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBymodifiedDateGreater",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_MODIFIEDDATELOWER = new FinderPath(ProGateApplicationsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateApplicationsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBymodifiedDateLower",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_MODIFIEDDATELOWER = new FinderPath(ProGateApplicationsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateApplicationsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBymodifiedDateLower",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_MODIFIEDDATELOWER = new FinderPath(ProGateApplicationsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateApplicationsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBymodifiedDateLower",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(ProGateApplicationsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateApplicationsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProGateApplicationsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateApplicationsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(ProGateApplications proGateApplications) {
		EntityCacheUtil.putResult(ProGateApplicationsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateApplicationsImpl.class, proGateApplications.getPrimaryKey(),
			proGateApplications);
	}

	public void cacheResult(List<ProGateApplications> proGateApplicationses) {
		for (ProGateApplications proGateApplications : proGateApplicationses) {
			if (EntityCacheUtil.getResult(
						ProGateApplicationsModelImpl.ENTITY_CACHE_ENABLED,
						ProGateApplicationsImpl.class,
						proGateApplications.getPrimaryKey(), this) == null) {
				cacheResult(proGateApplications);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(ProGateApplicationsImpl.class.getName());
		EntityCacheUtil.clearCache(ProGateApplicationsImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public ProGateApplications create(Integer ProGateApplicationsId) {
		ProGateApplications proGateApplications = new ProGateApplicationsImpl();

		proGateApplications.setNew(true);
		proGateApplications.setPrimaryKey(ProGateApplicationsId);

		return proGateApplications;
	}

	public ProGateApplications remove(Integer ProGateApplicationsId)
		throws NoSuchProGateApplicationsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ProGateApplications proGateApplications = (ProGateApplications)session.get(ProGateApplicationsImpl.class,
					ProGateApplicationsId);

			if (proGateApplications == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No ProGateApplications exists with the primary key " +
						ProGateApplicationsId);
				}

				throw new NoSuchProGateApplicationsException(
					"No ProGateApplications exists with the primary key " +
					ProGateApplicationsId);
			}

			return remove(proGateApplications);
		}
		catch (NoSuchProGateApplicationsException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public ProGateApplications remove(ProGateApplications proGateApplications)
		throws SystemException {
		for (ModelListener<ProGateApplications> listener : listeners) {
			listener.onBeforeRemove(proGateApplications);
		}

		proGateApplications = removeImpl(proGateApplications);

		for (ModelListener<ProGateApplications> listener : listeners) {
			listener.onAfterRemove(proGateApplications);
		}

		return proGateApplications;
	}

	protected ProGateApplications removeImpl(
		ProGateApplications proGateApplications) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (proGateApplications.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(ProGateApplicationsImpl.class,
						proGateApplications.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(proGateApplications);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(ProGateApplicationsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateApplicationsImpl.class, proGateApplications.getPrimaryKey());

		return proGateApplications;
	}

	public ProGateApplications update(ProGateApplications proGateApplications)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(ProGateApplications proGateApplications) method. Use update(ProGateApplications proGateApplications, boolean merge) instead.");
		}

		return update(proGateApplications, false);
	}

	public ProGateApplications update(ProGateApplications proGateApplications,
		boolean merge) throws SystemException {
		boolean isNew = proGateApplications.isNew();

		for (ModelListener<ProGateApplications> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(proGateApplications);
			}
			else {
				listener.onBeforeUpdate(proGateApplications);
			}
		}

		proGateApplications = updateImpl(proGateApplications, merge);

		for (ModelListener<ProGateApplications> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(proGateApplications);
			}
			else {
				listener.onAfterUpdate(proGateApplications);
			}
		}

		return proGateApplications;
	}

	public ProGateApplications updateImpl(
		larion.progate.model.ProGateApplications proGateApplications,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, proGateApplications, merge);

			proGateApplications.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(ProGateApplicationsModelImpl.ENTITY_CACHE_ENABLED,
			ProGateApplicationsImpl.class, proGateApplications.getPrimaryKey(),
			proGateApplications);

		return proGateApplications;
	}

	public ProGateApplications findByPrimaryKey(Integer ProGateApplicationsId)
		throws NoSuchProGateApplicationsException, SystemException {
		ProGateApplications proGateApplications = fetchByPrimaryKey(ProGateApplicationsId);

		if (proGateApplications == null) {
			if (_log.isWarnEnabled()) {
				_log.warn("No ProGateApplications exists with the primary key " +
					ProGateApplicationsId);
			}

			throw new NoSuchProGateApplicationsException(
				"No ProGateApplications exists with the primary key " +
				ProGateApplicationsId);
		}

		return proGateApplications;
	}

	public ProGateApplications fetchByPrimaryKey(Integer ProGateApplicationsId)
		throws SystemException {
		ProGateApplications proGateApplications = (ProGateApplications)EntityCacheUtil.getResult(ProGateApplicationsModelImpl.ENTITY_CACHE_ENABLED,
				ProGateApplicationsImpl.class, ProGateApplicationsId, this);

		if (proGateApplications == null) {
			Session session = null;

			try {
				session = openSession();

				proGateApplications = (ProGateApplications)session.get(ProGateApplicationsImpl.class,
						ProGateApplicationsId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (proGateApplications != null) {
					cacheResult(proGateApplications);
				}

				closeSession(session);
			}
		}

		return proGateApplications;
	}

	public List<ProGateApplications> findBylayoutId(int layoutId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(layoutId) };

		List<ProGateApplications> list = (List<ProGateApplications>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_LAYOUTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateApplications WHERE ");

				query.append("layout_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(layoutId);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateApplications>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_LAYOUTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateApplications> findBylayoutId(int layoutId, int start,
		int end) throws SystemException {
		return findBylayoutId(layoutId, start, end, null);
	}

	public List<ProGateApplications> findBylayoutId(int layoutId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(layoutId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateApplications> list = (List<ProGateApplications>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_LAYOUTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateApplications WHERE ");

				query.append("layout_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(layoutId);

				list = (List<ProGateApplications>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateApplications>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_LAYOUTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateApplications findBylayoutId_First(int layoutId,
		OrderByComparator obc)
		throws NoSuchProGateApplicationsException, SystemException {
		List<ProGateApplications> list = findBylayoutId(layoutId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateApplications exists with the key {");

			msg.append("layoutId=" + layoutId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateApplicationsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateApplications findBylayoutId_Last(int layoutId,
		OrderByComparator obc)
		throws NoSuchProGateApplicationsException, SystemException {
		int count = countBylayoutId(layoutId);

		List<ProGateApplications> list = findBylayoutId(layoutId, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateApplications exists with the key {");

			msg.append("layoutId=" + layoutId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateApplicationsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateApplications[] findBylayoutId_PrevAndNext(
		Integer ProGateApplicationsId, int layoutId, OrderByComparator obc)
		throws NoSuchProGateApplicationsException, SystemException {
		ProGateApplications proGateApplications = findByPrimaryKey(ProGateApplicationsId);

		int count = countBylayoutId(layoutId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.ProGateApplications WHERE ");

			query.append("layout_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(layoutId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateApplications);

			ProGateApplications[] array = new ProGateApplicationsImpl[3];

			array[0] = (ProGateApplications)objArray[0];
			array[1] = (ProGateApplications)objArray[1];
			array[2] = (ProGateApplications)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateApplications> findByname(String name)
		throws SystemException {
		Object[] finderArgs = new Object[] { name };

		List<ProGateApplications> list = (List<ProGateApplications>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_NAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateApplications WHERE ");

				if (name == null) {
					query.append("name IS NULL");
				}
				else {
					query.append("name = ?");
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
					list = new ArrayList<ProGateApplications>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_NAME, finderArgs,
					list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateApplications> findByname(String name, int start, int end)
		throws SystemException {
		return findByname(name, start, end, null);
	}

	public List<ProGateApplications> findByname(String name, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				name,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateApplications> list = (List<ProGateApplications>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_NAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateApplications WHERE ");

				if (name == null) {
					query.append("name IS NULL");
				}
				else {
					query.append("name = ?");
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

				list = (List<ProGateApplications>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateApplications>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_NAME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateApplications findByname_First(String name,
		OrderByComparator obc)
		throws NoSuchProGateApplicationsException, SystemException {
		List<ProGateApplications> list = findByname(name, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateApplications exists with the key {");

			msg.append("name=" + name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateApplicationsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateApplications findByname_Last(String name,
		OrderByComparator obc)
		throws NoSuchProGateApplicationsException, SystemException {
		int count = countByname(name);

		List<ProGateApplications> list = findByname(name, count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateApplications exists with the key {");

			msg.append("name=" + name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateApplicationsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateApplications[] findByname_PrevAndNext(
		Integer ProGateApplicationsId, String name, OrderByComparator obc)
		throws NoSuchProGateApplicationsException, SystemException {
		ProGateApplications proGateApplications = findByPrimaryKey(ProGateApplicationsId);

		int count = countByname(name);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.ProGateApplications WHERE ");

			if (name == null) {
				query.append("name IS NULL");
			}
			else {
				query.append("name = ?");
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
					proGateApplications);

			ProGateApplications[] array = new ProGateApplicationsImpl[3];

			array[0] = (ProGateApplications)objArray[0];
			array[1] = (ProGateApplications)objArray[1];
			array[2] = (ProGateApplications)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateApplications> findByisHidden(boolean isHidden)
		throws SystemException {
		Object[] finderArgs = new Object[] { Boolean.valueOf(isHidden) };

		List<ProGateApplications> list = (List<ProGateApplications>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ISHIDDEN,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateApplications WHERE ");

				query.append("is_hidden = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isHidden);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateApplications>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ISHIDDEN,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateApplications> findByisHidden(boolean isHidden,
		int start, int end) throws SystemException {
		return findByisHidden(isHidden, start, end, null);
	}

	public List<ProGateApplications> findByisHidden(boolean isHidden,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				Boolean.valueOf(isHidden),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateApplications> list = (List<ProGateApplications>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ISHIDDEN,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateApplications WHERE ");

				query.append("is_hidden = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isHidden);

				list = (List<ProGateApplications>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateApplications>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ISHIDDEN,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateApplications findByisHidden_First(boolean isHidden,
		OrderByComparator obc)
		throws NoSuchProGateApplicationsException, SystemException {
		List<ProGateApplications> list = findByisHidden(isHidden, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateApplications exists with the key {");

			msg.append("isHidden=" + isHidden);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateApplicationsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateApplications findByisHidden_Last(boolean isHidden,
		OrderByComparator obc)
		throws NoSuchProGateApplicationsException, SystemException {
		int count = countByisHidden(isHidden);

		List<ProGateApplications> list = findByisHidden(isHidden, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateApplications exists with the key {");

			msg.append("isHidden=" + isHidden);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateApplicationsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateApplications[] findByisHidden_PrevAndNext(
		Integer ProGateApplicationsId, boolean isHidden, OrderByComparator obc)
		throws NoSuchProGateApplicationsException, SystemException {
		ProGateApplications proGateApplications = findByPrimaryKey(ProGateApplicationsId);

		int count = countByisHidden(isHidden);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.ProGateApplications WHERE ");

			query.append("is_hidden = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(isHidden);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateApplications);

			ProGateApplications[] array = new ProGateApplicationsImpl[3];

			array[0] = (ProGateApplications)objArray[0];
			array[1] = (ProGateApplications)objArray[1];
			array[2] = (ProGateApplications)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateApplications> findBycreatedDateEqual(Date createdDate)
		throws SystemException {
		Object[] finderArgs = new Object[] { createdDate };

		List<ProGateApplications> list = (List<ProGateApplications>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_CREATEDDATEEQUAL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateApplications WHERE ");

				if (createdDate == null) {
					query.append("created_at IS NULL");
				}
				else {
					query.append("created_at = ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (createdDate != null) {
					qPos.add(CalendarUtil.getTimestamp(createdDate));
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateApplications>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_CREATEDDATEEQUAL,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateApplications> findBycreatedDateEqual(Date createdDate,
		int start, int end) throws SystemException {
		return findBycreatedDateEqual(createdDate, start, end, null);
	}

	public List<ProGateApplications> findBycreatedDateEqual(Date createdDate,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				createdDate,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateApplications> list = (List<ProGateApplications>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_CREATEDDATEEQUAL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateApplications WHERE ");

				if (createdDate == null) {
					query.append("created_at IS NULL");
				}
				else {
					query.append("created_at = ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (createdDate != null) {
					qPos.add(CalendarUtil.getTimestamp(createdDate));
				}

				list = (List<ProGateApplications>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateApplications>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_CREATEDDATEEQUAL,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateApplications findBycreatedDateEqual_First(Date createdDate,
		OrderByComparator obc)
		throws NoSuchProGateApplicationsException, SystemException {
		List<ProGateApplications> list = findBycreatedDateEqual(createdDate, 0,
				1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateApplications exists with the key {");

			msg.append("createdDate=" + createdDate);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateApplicationsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateApplications findBycreatedDateEqual_Last(Date createdDate,
		OrderByComparator obc)
		throws NoSuchProGateApplicationsException, SystemException {
		int count = countBycreatedDateEqual(createdDate);

		List<ProGateApplications> list = findBycreatedDateEqual(createdDate,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateApplications exists with the key {");

			msg.append("createdDate=" + createdDate);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateApplicationsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateApplications[] findBycreatedDateEqual_PrevAndNext(
		Integer ProGateApplicationsId, Date createdDate, OrderByComparator obc)
		throws NoSuchProGateApplicationsException, SystemException {
		ProGateApplications proGateApplications = findByPrimaryKey(ProGateApplicationsId);

		int count = countBycreatedDateEqual(createdDate);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.ProGateApplications WHERE ");

			if (createdDate == null) {
				query.append("created_at IS NULL");
			}
			else {
				query.append("created_at = ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (createdDate != null) {
				qPos.add(CalendarUtil.getTimestamp(createdDate));
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateApplications);

			ProGateApplications[] array = new ProGateApplicationsImpl[3];

			array[0] = (ProGateApplications)objArray[0];
			array[1] = (ProGateApplications)objArray[1];
			array[2] = (ProGateApplications)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateApplications> findBycreatedDateGreater(Date createdDate)
		throws SystemException {
		Object[] finderArgs = new Object[] { createdDate };

		List<ProGateApplications> list = (List<ProGateApplications>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_CREATEDDATEGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateApplications WHERE ");

				if (createdDate == null) {
					query.append("created_at >= null");
				}
				else {
					query.append("created_at >= ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (createdDate != null) {
					qPos.add(CalendarUtil.getTimestamp(createdDate));
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateApplications>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_CREATEDDATEGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateApplications> findBycreatedDateGreater(
		Date createdDate, int start, int end) throws SystemException {
		return findBycreatedDateGreater(createdDate, start, end, null);
	}

	public List<ProGateApplications> findBycreatedDateGreater(
		Date createdDate, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				createdDate,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateApplications> list = (List<ProGateApplications>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_CREATEDDATEGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateApplications WHERE ");

				if (createdDate == null) {
					query.append("created_at >= null");
				}
				else {
					query.append("created_at >= ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (createdDate != null) {
					qPos.add(CalendarUtil.getTimestamp(createdDate));
				}

				list = (List<ProGateApplications>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateApplications>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_CREATEDDATEGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateApplications findBycreatedDateGreater_First(
		Date createdDate, OrderByComparator obc)
		throws NoSuchProGateApplicationsException, SystemException {
		List<ProGateApplications> list = findBycreatedDateGreater(createdDate,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateApplications exists with the key {");

			msg.append("createdDate=" + createdDate);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateApplicationsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateApplications findBycreatedDateGreater_Last(Date createdDate,
		OrderByComparator obc)
		throws NoSuchProGateApplicationsException, SystemException {
		int count = countBycreatedDateGreater(createdDate);

		List<ProGateApplications> list = findBycreatedDateGreater(createdDate,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateApplications exists with the key {");

			msg.append("createdDate=" + createdDate);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateApplicationsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateApplications[] findBycreatedDateGreater_PrevAndNext(
		Integer ProGateApplicationsId, Date createdDate, OrderByComparator obc)
		throws NoSuchProGateApplicationsException, SystemException {
		ProGateApplications proGateApplications = findByPrimaryKey(ProGateApplicationsId);

		int count = countBycreatedDateGreater(createdDate);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.ProGateApplications WHERE ");

			if (createdDate == null) {
				query.append("created_at >= null");
			}
			else {
				query.append("created_at >= ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (createdDate != null) {
				qPos.add(CalendarUtil.getTimestamp(createdDate));
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateApplications);

			ProGateApplications[] array = new ProGateApplicationsImpl[3];

			array[0] = (ProGateApplications)objArray[0];
			array[1] = (ProGateApplications)objArray[1];
			array[2] = (ProGateApplications)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateApplications> findBycreatedDateLower(Date createdDate)
		throws SystemException {
		Object[] finderArgs = new Object[] { createdDate };

		List<ProGateApplications> list = (List<ProGateApplications>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_CREATEDDATELOWER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateApplications WHERE ");

				if (createdDate == null) {
					query.append("created_at <= null");
				}
				else {
					query.append("created_at <= ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (createdDate != null) {
					qPos.add(CalendarUtil.getTimestamp(createdDate));
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateApplications>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_CREATEDDATELOWER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateApplications> findBycreatedDateLower(Date createdDate,
		int start, int end) throws SystemException {
		return findBycreatedDateLower(createdDate, start, end, null);
	}

	public List<ProGateApplications> findBycreatedDateLower(Date createdDate,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				createdDate,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateApplications> list = (List<ProGateApplications>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_CREATEDDATELOWER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateApplications WHERE ");

				if (createdDate == null) {
					query.append("created_at <= null");
				}
				else {
					query.append("created_at <= ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (createdDate != null) {
					qPos.add(CalendarUtil.getTimestamp(createdDate));
				}

				list = (List<ProGateApplications>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateApplications>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_CREATEDDATELOWER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateApplications findBycreatedDateLower_First(Date createdDate,
		OrderByComparator obc)
		throws NoSuchProGateApplicationsException, SystemException {
		List<ProGateApplications> list = findBycreatedDateLower(createdDate, 0,
				1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateApplications exists with the key {");

			msg.append("createdDate=" + createdDate);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateApplicationsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateApplications findBycreatedDateLower_Last(Date createdDate,
		OrderByComparator obc)
		throws NoSuchProGateApplicationsException, SystemException {
		int count = countBycreatedDateLower(createdDate);

		List<ProGateApplications> list = findBycreatedDateLower(createdDate,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateApplications exists with the key {");

			msg.append("createdDate=" + createdDate);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateApplicationsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateApplications[] findBycreatedDateLower_PrevAndNext(
		Integer ProGateApplicationsId, Date createdDate, OrderByComparator obc)
		throws NoSuchProGateApplicationsException, SystemException {
		ProGateApplications proGateApplications = findByPrimaryKey(ProGateApplicationsId);

		int count = countBycreatedDateLower(createdDate);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.ProGateApplications WHERE ");

			if (createdDate == null) {
				query.append("created_at <= null");
			}
			else {
				query.append("created_at <= ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (createdDate != null) {
				qPos.add(CalendarUtil.getTimestamp(createdDate));
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateApplications);

			ProGateApplications[] array = new ProGateApplicationsImpl[3];

			array[0] = (ProGateApplications)objArray[0];
			array[1] = (ProGateApplications)objArray[1];
			array[2] = (ProGateApplications)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateApplications> findBymodifiedDateEqual(Date modifiedDate)
		throws SystemException {
		Object[] finderArgs = new Object[] { modifiedDate };

		List<ProGateApplications> list = (List<ProGateApplications>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_MODIFIEDDATEEQUAL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateApplications WHERE ");

				if (modifiedDate == null) {
					query.append("updated_at IS NULL");
				}
				else {
					query.append("updated_at = ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (modifiedDate != null) {
					qPos.add(CalendarUtil.getTimestamp(modifiedDate));
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateApplications>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_MODIFIEDDATEEQUAL,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateApplications> findBymodifiedDateEqual(
		Date modifiedDate, int start, int end) throws SystemException {
		return findBymodifiedDateEqual(modifiedDate, start, end, null);
	}

	public List<ProGateApplications> findBymodifiedDateEqual(
		Date modifiedDate, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				modifiedDate,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateApplications> list = (List<ProGateApplications>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_MODIFIEDDATEEQUAL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateApplications WHERE ");

				if (modifiedDate == null) {
					query.append("updated_at IS NULL");
				}
				else {
					query.append("updated_at = ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (modifiedDate != null) {
					qPos.add(CalendarUtil.getTimestamp(modifiedDate));
				}

				list = (List<ProGateApplications>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateApplications>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_MODIFIEDDATEEQUAL,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateApplications findBymodifiedDateEqual_First(
		Date modifiedDate, OrderByComparator obc)
		throws NoSuchProGateApplicationsException, SystemException {
		List<ProGateApplications> list = findBymodifiedDateEqual(modifiedDate,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateApplications exists with the key {");

			msg.append("modifiedDate=" + modifiedDate);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateApplicationsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateApplications findBymodifiedDateEqual_Last(Date modifiedDate,
		OrderByComparator obc)
		throws NoSuchProGateApplicationsException, SystemException {
		int count = countBymodifiedDateEqual(modifiedDate);

		List<ProGateApplications> list = findBymodifiedDateEqual(modifiedDate,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateApplications exists with the key {");

			msg.append("modifiedDate=" + modifiedDate);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateApplicationsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateApplications[] findBymodifiedDateEqual_PrevAndNext(
		Integer ProGateApplicationsId, Date modifiedDate, OrderByComparator obc)
		throws NoSuchProGateApplicationsException, SystemException {
		ProGateApplications proGateApplications = findByPrimaryKey(ProGateApplicationsId);

		int count = countBymodifiedDateEqual(modifiedDate);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.ProGateApplications WHERE ");

			if (modifiedDate == null) {
				query.append("updated_at IS NULL");
			}
			else {
				query.append("updated_at = ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (modifiedDate != null) {
				qPos.add(CalendarUtil.getTimestamp(modifiedDate));
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateApplications);

			ProGateApplications[] array = new ProGateApplicationsImpl[3];

			array[0] = (ProGateApplications)objArray[0];
			array[1] = (ProGateApplications)objArray[1];
			array[2] = (ProGateApplications)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateApplications> findBymodifiedDateGreater(
		Date modifiedDate) throws SystemException {
		Object[] finderArgs = new Object[] { modifiedDate };

		List<ProGateApplications> list = (List<ProGateApplications>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_MODIFIEDDATEGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateApplications WHERE ");

				if (modifiedDate == null) {
					query.append("updated_at >= null");
				}
				else {
					query.append("updated_at >= ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (modifiedDate != null) {
					qPos.add(CalendarUtil.getTimestamp(modifiedDate));
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateApplications>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_MODIFIEDDATEGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateApplications> findBymodifiedDateGreater(
		Date modifiedDate, int start, int end) throws SystemException {
		return findBymodifiedDateGreater(modifiedDate, start, end, null);
	}

	public List<ProGateApplications> findBymodifiedDateGreater(
		Date modifiedDate, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				modifiedDate,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateApplications> list = (List<ProGateApplications>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_MODIFIEDDATEGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateApplications WHERE ");

				if (modifiedDate == null) {
					query.append("updated_at >= null");
				}
				else {
					query.append("updated_at >= ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (modifiedDate != null) {
					qPos.add(CalendarUtil.getTimestamp(modifiedDate));
				}

				list = (List<ProGateApplications>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateApplications>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_MODIFIEDDATEGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateApplications findBymodifiedDateGreater_First(
		Date modifiedDate, OrderByComparator obc)
		throws NoSuchProGateApplicationsException, SystemException {
		List<ProGateApplications> list = findBymodifiedDateGreater(modifiedDate,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateApplications exists with the key {");

			msg.append("modifiedDate=" + modifiedDate);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateApplicationsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateApplications findBymodifiedDateGreater_Last(
		Date modifiedDate, OrderByComparator obc)
		throws NoSuchProGateApplicationsException, SystemException {
		int count = countBymodifiedDateGreater(modifiedDate);

		List<ProGateApplications> list = findBymodifiedDateGreater(modifiedDate,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateApplications exists with the key {");

			msg.append("modifiedDate=" + modifiedDate);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateApplicationsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateApplications[] findBymodifiedDateGreater_PrevAndNext(
		Integer ProGateApplicationsId, Date modifiedDate, OrderByComparator obc)
		throws NoSuchProGateApplicationsException, SystemException {
		ProGateApplications proGateApplications = findByPrimaryKey(ProGateApplicationsId);

		int count = countBymodifiedDateGreater(modifiedDate);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.ProGateApplications WHERE ");

			if (modifiedDate == null) {
				query.append("updated_at >= null");
			}
			else {
				query.append("updated_at >= ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (modifiedDate != null) {
				qPos.add(CalendarUtil.getTimestamp(modifiedDate));
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateApplications);

			ProGateApplications[] array = new ProGateApplicationsImpl[3];

			array[0] = (ProGateApplications)objArray[0];
			array[1] = (ProGateApplications)objArray[1];
			array[2] = (ProGateApplications)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateApplications> findBymodifiedDateLower(Date modifiedDate)
		throws SystemException {
		Object[] finderArgs = new Object[] { modifiedDate };

		List<ProGateApplications> list = (List<ProGateApplications>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_MODIFIEDDATELOWER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateApplications WHERE ");

				if (modifiedDate == null) {
					query.append("updated_at <= null");
				}
				else {
					query.append("updated_at <= ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (modifiedDate != null) {
					qPos.add(CalendarUtil.getTimestamp(modifiedDate));
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateApplications>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_MODIFIEDDATELOWER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateApplications> findBymodifiedDateLower(
		Date modifiedDate, int start, int end) throws SystemException {
		return findBymodifiedDateLower(modifiedDate, start, end, null);
	}

	public List<ProGateApplications> findBymodifiedDateLower(
		Date modifiedDate, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				modifiedDate,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateApplications> list = (List<ProGateApplications>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_MODIFIEDDATELOWER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateApplications WHERE ");

				if (modifiedDate == null) {
					query.append("updated_at <= null");
				}
				else {
					query.append("updated_at <= ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (modifiedDate != null) {
					qPos.add(CalendarUtil.getTimestamp(modifiedDate));
				}

				list = (List<ProGateApplications>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateApplications>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_MODIFIEDDATELOWER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateApplications findBymodifiedDateLower_First(
		Date modifiedDate, OrderByComparator obc)
		throws NoSuchProGateApplicationsException, SystemException {
		List<ProGateApplications> list = findBymodifiedDateLower(modifiedDate,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateApplications exists with the key {");

			msg.append("modifiedDate=" + modifiedDate);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateApplicationsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateApplications findBymodifiedDateLower_Last(Date modifiedDate,
		OrderByComparator obc)
		throws NoSuchProGateApplicationsException, SystemException {
		int count = countBymodifiedDateLower(modifiedDate);

		List<ProGateApplications> list = findBymodifiedDateLower(modifiedDate,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateApplications exists with the key {");

			msg.append("modifiedDate=" + modifiedDate);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateApplicationsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateApplications[] findBymodifiedDateLower_PrevAndNext(
		Integer ProGateApplicationsId, Date modifiedDate, OrderByComparator obc)
		throws NoSuchProGateApplicationsException, SystemException {
		ProGateApplications proGateApplications = findByPrimaryKey(ProGateApplicationsId);

		int count = countBymodifiedDateLower(modifiedDate);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.ProGateApplications WHERE ");

			if (modifiedDate == null) {
				query.append("updated_at <= null");
			}
			else {
				query.append("updated_at <= ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (modifiedDate != null) {
				qPos.add(CalendarUtil.getTimestamp(modifiedDate));
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateApplications);

			ProGateApplications[] array = new ProGateApplicationsImpl[3];

			array[0] = (ProGateApplications)objArray[0];
			array[1] = (ProGateApplications)objArray[1];
			array[2] = (ProGateApplications)objArray[2];

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

	public List<ProGateApplications> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<ProGateApplications> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<ProGateApplications> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateApplications> list = (List<ProGateApplications>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.ProGateApplications ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<ProGateApplications>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ProGateApplications>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateApplications>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeBylayoutId(int layoutId) throws SystemException {
		for (ProGateApplications proGateApplications : findBylayoutId(layoutId)) {
			remove(proGateApplications);
		}
	}

	public void removeByname(String name) throws SystemException {
		for (ProGateApplications proGateApplications : findByname(name)) {
			remove(proGateApplications);
		}
	}

	public void removeByisHidden(boolean isHidden) throws SystemException {
		for (ProGateApplications proGateApplications : findByisHidden(isHidden)) {
			remove(proGateApplications);
		}
	}

	public void removeBycreatedDateEqual(Date createdDate)
		throws SystemException {
		for (ProGateApplications proGateApplications : findBycreatedDateEqual(
				createdDate)) {
			remove(proGateApplications);
		}
	}

	public void removeBycreatedDateGreater(Date createdDate)
		throws SystemException {
		for (ProGateApplications proGateApplications : findBycreatedDateGreater(
				createdDate)) {
			remove(proGateApplications);
		}
	}

	public void removeBycreatedDateLower(Date createdDate)
		throws SystemException {
		for (ProGateApplications proGateApplications : findBycreatedDateLower(
				createdDate)) {
			remove(proGateApplications);
		}
	}

	public void removeBymodifiedDateEqual(Date modifiedDate)
		throws SystemException {
		for (ProGateApplications proGateApplications : findBymodifiedDateEqual(
				modifiedDate)) {
			remove(proGateApplications);
		}
	}

	public void removeBymodifiedDateGreater(Date modifiedDate)
		throws SystemException {
		for (ProGateApplications proGateApplications : findBymodifiedDateGreater(
				modifiedDate)) {
			remove(proGateApplications);
		}
	}

	public void removeBymodifiedDateLower(Date modifiedDate)
		throws SystemException {
		for (ProGateApplications proGateApplications : findBymodifiedDateLower(
				modifiedDate)) {
			remove(proGateApplications);
		}
	}

	public void removeAll() throws SystemException {
		for (ProGateApplications proGateApplications : findAll()) {
			remove(proGateApplications);
		}
	}

	public int countBylayoutId(int layoutId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(layoutId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_LAYOUTID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateApplications WHERE ");

				query.append("layout_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(layoutId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LAYOUTID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByname(String name) throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_NAME,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateApplications WHERE ");

				if (name == null) {
					query.append("name IS NULL");
				}
				else {
					query.append("name = ?");
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByisHidden(boolean isHidden) throws SystemException {
		Object[] finderArgs = new Object[] { Boolean.valueOf(isHidden) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ISHIDDEN,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateApplications WHERE ");

				query.append("is_hidden = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isHidden);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ISHIDDEN,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countBycreatedDateEqual(Date createdDate)
		throws SystemException {
		Object[] finderArgs = new Object[] { createdDate };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CREATEDDATEEQUAL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateApplications WHERE ");

				if (createdDate == null) {
					query.append("created_at IS NULL");
				}
				else {
					query.append("created_at = ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (createdDate != null) {
					qPos.add(CalendarUtil.getTimestamp(createdDate));
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CREATEDDATEEQUAL,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countBycreatedDateGreater(Date createdDate)
		throws SystemException {
		Object[] finderArgs = new Object[] { createdDate };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CREATEDDATEGREATER,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateApplications WHERE ");

				if (createdDate == null) {
					query.append("created_at >= null");
				}
				else {
					query.append("created_at >= ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (createdDate != null) {
					qPos.add(CalendarUtil.getTimestamp(createdDate));
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CREATEDDATEGREATER,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countBycreatedDateLower(Date createdDate)
		throws SystemException {
		Object[] finderArgs = new Object[] { createdDate };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CREATEDDATELOWER,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateApplications WHERE ");

				if (createdDate == null) {
					query.append("created_at <= null");
				}
				else {
					query.append("created_at <= ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (createdDate != null) {
					qPos.add(CalendarUtil.getTimestamp(createdDate));
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CREATEDDATELOWER,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countBymodifiedDateEqual(Date modifiedDate)
		throws SystemException {
		Object[] finderArgs = new Object[] { modifiedDate };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MODIFIEDDATEEQUAL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateApplications WHERE ");

				if (modifiedDate == null) {
					query.append("updated_at IS NULL");
				}
				else {
					query.append("updated_at = ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (modifiedDate != null) {
					qPos.add(CalendarUtil.getTimestamp(modifiedDate));
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MODIFIEDDATEEQUAL,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countBymodifiedDateGreater(Date modifiedDate)
		throws SystemException {
		Object[] finderArgs = new Object[] { modifiedDate };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MODIFIEDDATEGREATER,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateApplications WHERE ");

				if (modifiedDate == null) {
					query.append("updated_at >= null");
				}
				else {
					query.append("updated_at >= ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (modifiedDate != null) {
					qPos.add(CalendarUtil.getTimestamp(modifiedDate));
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MODIFIEDDATEGREATER,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countBymodifiedDateLower(Date modifiedDate)
		throws SystemException {
		Object[] finderArgs = new Object[] { modifiedDate };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MODIFIEDDATELOWER,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateApplications WHERE ");

				if (modifiedDate == null) {
					query.append("updated_at <= null");
				}
				else {
					query.append("updated_at <= ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (modifiedDate != null) {
					qPos.add(CalendarUtil.getTimestamp(modifiedDate));
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MODIFIEDDATELOWER,
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
						"SELECT COUNT(*) FROM larion.progate.model.ProGateApplications");

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
						"value.object.listener.larion.progate.model.ProGateApplications")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ProGateApplications>> listenersList = new ArrayList<ModelListener<ProGateApplications>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ProGateApplications>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(ProGateApplicationsPersistenceImpl.class);
}