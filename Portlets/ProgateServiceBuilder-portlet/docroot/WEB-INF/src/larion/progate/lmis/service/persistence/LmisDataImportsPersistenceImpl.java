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
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQuery;
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQueryFactoryUtil;
import com.liferay.portal.kernel.dao.jdbc.RowMapper;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
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

import larion.progate.lmis.NoSuchLmisDataImportsException;
import larion.progate.lmis.model.LmisDataImports;
import larion.progate.lmis.model.impl.LmisDataImportsImpl;
import larion.progate.lmis.model.impl.LmisDataImportsModelImpl;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * <a href="LmisDataImportsPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisDataImportsPersistenceImpl extends BasePersistenceImpl
	implements LmisDataImportsPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = LmisDataImportsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_DATAIMPORTOF = new FinderPath(LmisDataImportsModelImpl.ENTITY_CACHE_ENABLED,
			LmisDataImportsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByDataImportOf",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_DATAIMPORTOF = new FinderPath(LmisDataImportsModelImpl.ENTITY_CACHE_ENABLED,
			LmisDataImportsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByDataImportOf",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_DATAIMPORTOF = new FinderPath(LmisDataImportsModelImpl.ENTITY_CACHE_ENABLED,
			LmisDataImportsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByDataImportOf",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_IMPORTBY = new FinderPath(LmisDataImportsModelImpl.ENTITY_CACHE_ENABLED,
			LmisDataImportsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByImportBy",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_IMPORTBY = new FinderPath(LmisDataImportsModelImpl.ENTITY_CACHE_ENABLED,
			LmisDataImportsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByImportBy",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_IMPORTBY = new FinderPath(LmisDataImportsModelImpl.ENTITY_CACHE_ENABLED,
			LmisDataImportsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByImportBy",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_DATEVALUE = new FinderPath(LmisDataImportsModelImpl.ENTITY_CACHE_ENABLED,
			LmisDataImportsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByDateValue",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_DATEVALUE = new FinderPath(LmisDataImportsModelImpl.ENTITY_CACHE_ENABLED,
			LmisDataImportsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByDateValue",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_DATEVALUE = new FinderPath(LmisDataImportsModelImpl.ENTITY_CACHE_ENABLED,
			LmisDataImportsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByDateValue",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(LmisDataImportsModelImpl.ENTITY_CACHE_ENABLED,
			LmisDataImportsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LmisDataImportsModelImpl.ENTITY_CACHE_ENABLED,
			LmisDataImportsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(LmisDataImports lmisDataImports) {
		EntityCacheUtil.putResult(LmisDataImportsModelImpl.ENTITY_CACHE_ENABLED,
			LmisDataImportsImpl.class, lmisDataImports.getPrimaryKey(),
			lmisDataImports);
	}

	public void cacheResult(List<LmisDataImports> lmisDataImportses) {
		for (LmisDataImports lmisDataImports : lmisDataImportses) {
			if (EntityCacheUtil.getResult(
						LmisDataImportsModelImpl.ENTITY_CACHE_ENABLED,
						LmisDataImportsImpl.class,
						lmisDataImports.getPrimaryKey(), this) == null) {
				cacheResult(lmisDataImports);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(LmisDataImportsImpl.class.getName());
		EntityCacheUtil.clearCache(LmisDataImportsImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public LmisDataImports create(Integer lmisDataImportsId) {
		LmisDataImports lmisDataImports = new LmisDataImportsImpl();

		lmisDataImports.setNew(true);
		lmisDataImports.setPrimaryKey(lmisDataImportsId);

		return lmisDataImports;
	}

	public LmisDataImports remove(Integer lmisDataImportsId)
		throws NoSuchLmisDataImportsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LmisDataImports lmisDataImports = (LmisDataImports)session.get(LmisDataImportsImpl.class,
					lmisDataImportsId);

			if (lmisDataImports == null) {
				if (_log.isWarnEnabled()) {
					_log.warn("No LmisDataImports exists with the primary key " +
						lmisDataImportsId);
				}

				throw new NoSuchLmisDataImportsException(
					"No LmisDataImports exists with the primary key " +
					lmisDataImportsId);
			}

			return remove(lmisDataImports);
		}
		catch (NoSuchLmisDataImportsException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public LmisDataImports remove(LmisDataImports lmisDataImports)
		throws SystemException {
		for (ModelListener<LmisDataImports> listener : listeners) {
			listener.onBeforeRemove(lmisDataImports);
		}

		lmisDataImports = removeImpl(lmisDataImports);

		for (ModelListener<LmisDataImports> listener : listeners) {
			listener.onAfterRemove(lmisDataImports);
		}

		return lmisDataImports;
	}

	protected LmisDataImports removeImpl(LmisDataImports lmisDataImports)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (lmisDataImports.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(LmisDataImportsImpl.class,
						lmisDataImports.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(lmisDataImports);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(LmisDataImportsModelImpl.ENTITY_CACHE_ENABLED,
			LmisDataImportsImpl.class, lmisDataImports.getPrimaryKey());

		return lmisDataImports;
	}

	public LmisDataImports update(LmisDataImports lmisDataImports)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(LmisDataImports lmisDataImports) method. Use update(LmisDataImports lmisDataImports, boolean merge) instead.");
		}

		return update(lmisDataImports, false);
	}

	public LmisDataImports update(LmisDataImports lmisDataImports, boolean merge)
		throws SystemException {
		boolean isNew = lmisDataImports.isNew();

		for (ModelListener<LmisDataImports> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(lmisDataImports);
			}
			else {
				listener.onBeforeUpdate(lmisDataImports);
			}
		}

		lmisDataImports = updateImpl(lmisDataImports, merge);

		for (ModelListener<LmisDataImports> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(lmisDataImports);
			}
			else {
				listener.onAfterUpdate(lmisDataImports);
			}
		}

		return lmisDataImports;
	}

	public LmisDataImports updateImpl(
		larion.progate.lmis.model.LmisDataImports lmisDataImports, boolean merge)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, lmisDataImports, merge);

			lmisDataImports.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(LmisDataImportsModelImpl.ENTITY_CACHE_ENABLED,
			LmisDataImportsImpl.class, lmisDataImports.getPrimaryKey(),
			lmisDataImports);

		return lmisDataImports;
	}

	public LmisDataImports findByPrimaryKey(Integer lmisDataImportsId)
		throws NoSuchLmisDataImportsException, SystemException {
		LmisDataImports lmisDataImports = fetchByPrimaryKey(lmisDataImportsId);

		if (lmisDataImports == null) {
			if (_log.isWarnEnabled()) {
				_log.warn("No LmisDataImports exists with the primary key " +
					lmisDataImportsId);
			}

			throw new NoSuchLmisDataImportsException(
				"No LmisDataImports exists with the primary key " +
				lmisDataImportsId);
		}

		return lmisDataImports;
	}

	public LmisDataImports fetchByPrimaryKey(Integer lmisDataImportsId)
		throws SystemException {
		LmisDataImports lmisDataImports = (LmisDataImports)EntityCacheUtil.getResult(LmisDataImportsModelImpl.ENTITY_CACHE_ENABLED,
				LmisDataImportsImpl.class, lmisDataImportsId, this);

		if (lmisDataImports == null) {
			Session session = null;

			try {
				session = openSession();

				lmisDataImports = (LmisDataImports)session.get(LmisDataImportsImpl.class,
						lmisDataImportsId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (lmisDataImports != null) {
					cacheResult(lmisDataImports);
				}

				closeSession(session);
			}
		}

		return lmisDataImports;
	}

	public List<LmisDataImports> findByDataImportOf(int rootId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		List<LmisDataImports> list = (List<LmisDataImports>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DATAIMPORTOF,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisDataImports WHERE ");

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
					list = new ArrayList<LmisDataImports>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DATAIMPORTOF,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisDataImports> findByDataImportOf(int rootId, int start,
		int end) throws SystemException {
		return findByDataImportOf(rootId, start, end, null);
	}

	public List<LmisDataImports> findByDataImportOf(int rootId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(rootId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisDataImports> list = (List<LmisDataImports>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_DATAIMPORTOF,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisDataImports WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rootId);

				list = (List<LmisDataImports>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisDataImports>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_DATAIMPORTOF,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisDataImports findByDataImportOf_First(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisDataImportsException, SystemException {
		List<LmisDataImports> list = findByDataImportOf(rootId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisDataImports exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisDataImportsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisDataImports findByDataImportOf_Last(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisDataImportsException, SystemException {
		int count = countByDataImportOf(rootId);

		List<LmisDataImports> list = findByDataImportOf(rootId, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisDataImports exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisDataImportsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisDataImports[] findByDataImportOf_PrevAndNext(
		Integer lmisDataImportsId, int rootId, OrderByComparator obc)
		throws NoSuchLmisDataImportsException, SystemException {
		LmisDataImports lmisDataImports = findByPrimaryKey(lmisDataImportsId);

		int count = countByDataImportOf(rootId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisDataImports WHERE ");

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
					lmisDataImports);

			LmisDataImports[] array = new LmisDataImportsImpl[3];

			array[0] = (LmisDataImports)objArray[0];
			array[1] = (LmisDataImports)objArray[1];
			array[2] = (LmisDataImports)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisDataImports> findByImportBy(int importBy)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(importBy) };

		List<LmisDataImports> list = (List<LmisDataImports>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_IMPORTBY,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisDataImports WHERE ");

				query.append("import_by = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(importBy);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisDataImports>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_IMPORTBY,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisDataImports> findByImportBy(int importBy, int start, int end)
		throws SystemException {
		return findByImportBy(importBy, start, end, null);
	}

	public List<LmisDataImports> findByImportBy(int importBy, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(importBy),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisDataImports> list = (List<LmisDataImports>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_IMPORTBY,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisDataImports WHERE ");

				query.append("import_by = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(importBy);

				list = (List<LmisDataImports>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisDataImports>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_IMPORTBY,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisDataImports findByImportBy_First(int importBy,
		OrderByComparator obc)
		throws NoSuchLmisDataImportsException, SystemException {
		List<LmisDataImports> list = findByImportBy(importBy, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisDataImports exists with the key {");

			msg.append("importBy=" + importBy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisDataImportsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisDataImports findByImportBy_Last(int importBy,
		OrderByComparator obc)
		throws NoSuchLmisDataImportsException, SystemException {
		int count = countByImportBy(importBy);

		List<LmisDataImports> list = findByImportBy(importBy, count - 1, count,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisDataImports exists with the key {");

			msg.append("importBy=" + importBy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisDataImportsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisDataImports[] findByImportBy_PrevAndNext(
		Integer lmisDataImportsId, int importBy, OrderByComparator obc)
		throws NoSuchLmisDataImportsException, SystemException {
		LmisDataImports lmisDataImports = findByPrimaryKey(lmisDataImportsId);

		int count = countByImportBy(importBy);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisDataImports WHERE ");

			query.append("import_by = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(importBy);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisDataImports);

			LmisDataImports[] array = new LmisDataImportsImpl[3];

			array[0] = (LmisDataImports)objArray[0];
			array[1] = (LmisDataImports)objArray[1];
			array[2] = (LmisDataImports)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisDataImports> findByDateValue(Date dateValue)
		throws SystemException {
		Object[] finderArgs = new Object[] { dateValue };

		List<LmisDataImports> list = (List<LmisDataImports>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DATEVALUE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisDataImports WHERE ");

				if (dateValue == null) {
					query.append("date_value IS NULL");
				}
				else {
					query.append("date_value = ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (dateValue != null) {
					qPos.add(CalendarUtil.getTimestamp(dateValue));
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisDataImports>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DATEVALUE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisDataImports> findByDateValue(Date dateValue, int start,
		int end) throws SystemException {
		return findByDateValue(dateValue, start, end, null);
	}

	public List<LmisDataImports> findByDateValue(Date dateValue, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				dateValue,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisDataImports> list = (List<LmisDataImports>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_DATEVALUE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisDataImports WHERE ");

				if (dateValue == null) {
					query.append("date_value IS NULL");
				}
				else {
					query.append("date_value = ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (dateValue != null) {
					qPos.add(CalendarUtil.getTimestamp(dateValue));
				}

				list = (List<LmisDataImports>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisDataImports>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_DATEVALUE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisDataImports findByDateValue_First(Date dateValue,
		OrderByComparator obc)
		throws NoSuchLmisDataImportsException, SystemException {
		List<LmisDataImports> list = findByDateValue(dateValue, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisDataImports exists with the key {");

			msg.append("dateValue=" + dateValue);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisDataImportsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisDataImports findByDateValue_Last(Date dateValue,
		OrderByComparator obc)
		throws NoSuchLmisDataImportsException, SystemException {
		int count = countByDateValue(dateValue);

		List<LmisDataImports> list = findByDateValue(dateValue, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisDataImports exists with the key {");

			msg.append("dateValue=" + dateValue);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisDataImportsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisDataImports[] findByDateValue_PrevAndNext(
		Integer lmisDataImportsId, Date dateValue, OrderByComparator obc)
		throws NoSuchLmisDataImportsException, SystemException {
		LmisDataImports lmisDataImports = findByPrimaryKey(lmisDataImportsId);

		int count = countByDateValue(dateValue);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisDataImports WHERE ");

			if (dateValue == null) {
				query.append("date_value IS NULL");
			}
			else {
				query.append("date_value = ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (dateValue != null) {
				qPos.add(CalendarUtil.getTimestamp(dateValue));
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisDataImports);

			LmisDataImports[] array = new LmisDataImportsImpl[3];

			array[0] = (LmisDataImports)objArray[0];
			array[1] = (LmisDataImports)objArray[1];
			array[2] = (LmisDataImports)objArray[2];

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

	public List<LmisDataImports> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<LmisDataImports> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<LmisDataImports> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisDataImports> list = (List<LmisDataImports>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.lmis.model.LmisDataImports ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<LmisDataImports>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LmisDataImports>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisDataImports>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByDataImportOf(int rootId) throws SystemException {
		for (LmisDataImports lmisDataImports : findByDataImportOf(rootId)) {
			remove(lmisDataImports);
		}
	}

	public void removeByImportBy(int importBy) throws SystemException {
		for (LmisDataImports lmisDataImports : findByImportBy(importBy)) {
			remove(lmisDataImports);
		}
	}

	public void removeByDateValue(Date dateValue) throws SystemException {
		for (LmisDataImports lmisDataImports : findByDateValue(dateValue)) {
			remove(lmisDataImports);
		}
	}

	public void removeAll() throws SystemException {
		for (LmisDataImports lmisDataImports : findAll()) {
			remove(lmisDataImports);
		}
	}

	public int countByDataImportOf(int rootId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DATAIMPORTOF,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisDataImports WHERE ");

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DATAIMPORTOF,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByImportBy(int importBy) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(importBy) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_IMPORTBY,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisDataImports WHERE ");

				query.append("import_by = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(importBy);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_IMPORTBY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByDateValue(Date dateValue) throws SystemException {
		Object[] finderArgs = new Object[] { dateValue };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DATEVALUE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisDataImports WHERE ");

				if (dateValue == null) {
					query.append("date_value IS NULL");
				}
				else {
					query.append("date_value = ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (dateValue != null) {
					qPos.add(CalendarUtil.getTimestamp(dateValue));
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DATEVALUE,
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
						"SELECT COUNT(*) FROM larion.progate.lmis.model.LmisDataImports");

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

	public List<larion.progate.lmis.model.LmisDataImportDetails> getLmisDataImportDetailses(
		Integer pk) throws SystemException {
		return getLmisDataImportDetailses(pk, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS);
	}

	public List<larion.progate.lmis.model.LmisDataImportDetails> getLmisDataImportDetailses(
		Integer pk, int start, int end) throws SystemException {
		return getLmisDataImportDetailses(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_LMISDATAIMPORTDETAILSES = new FinderPath(larion.progate.lmis.model.impl.LmisDataImportDetailsModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.lmis.model.impl.LmisDataImportDetailsModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.lmis.service.persistence.LmisDataImportDetailsPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getLmisDataImportDetailses",
			new String[] {
				Integer.class.getName(), "java.lang.Integer",
				"java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	public List<larion.progate.lmis.model.LmisDataImportDetails> getLmisDataImportDetailses(
		Integer pk, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				pk, String.valueOf(start), String.valueOf(end),
				String.valueOf(obc)
			};

		List<larion.progate.lmis.model.LmisDataImportDetails> list = (List<larion.progate.lmis.model.LmisDataImportDetails>)FinderCacheUtil.getResult(FINDER_PATH_GET_LMISDATAIMPORTDETAILSES,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder sb = new StringBuilder();

				sb.append(_SQL_GETLMISDATAIMPORTDETAILSES);

				if (obc != null) {
					sb.append("ORDER BY ");
					sb.append(obc.getOrderBy());
				}

				String sql = sb.toString();

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("lmis_data_import_details",
					larion.progate.lmis.model.impl.LmisDataImportDetailsImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<larion.progate.lmis.model.LmisDataImportDetails>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<larion.progate.lmis.model.LmisDataImportDetails>();
				}

				lmisDataImportDetailsPersistence.cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_GET_LMISDATAIMPORTDETAILSES,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_LMISDATAIMPORTDETAILSES_SIZE = new FinderPath(larion.progate.lmis.model.impl.LmisDataImportDetailsModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.lmis.model.impl.LmisDataImportDetailsModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.lmis.service.persistence.LmisDataImportDetailsPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getLmisDataImportDetailsesSize",
			new String[] { Integer.class.getName() });

	public int getLmisDataImportDetailsesSize(Integer pk)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_LMISDATAIMPORTDETAILSES_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETLMISDATAIMPORTDETAILSESSIZE);

				q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_GET_LMISDATAIMPORTDETAILSES_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_LMISDATAIMPORTDETAILS = new FinderPath(larion.progate.lmis.model.impl.LmisDataImportDetailsModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.lmis.model.impl.LmisDataImportDetailsModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.lmis.service.persistence.LmisDataImportDetailsPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"containsLmisDataImportDetails",
			new String[] { Integer.class.getName(), Integer.class.getName() });

	public boolean containsLmisDataImportDetails(Integer pk,
		Integer lmisDataImportDetailsPK) throws SystemException {
		Object[] finderArgs = new Object[] { pk, lmisDataImportDetailsPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_LMISDATAIMPORTDETAILS,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsLmisDataImportDetails.contains(
							pk, lmisDataImportDetailsPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_LMISDATAIMPORTDETAILS,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	public boolean containsLmisDataImportDetailses(Integer pk)
		throws SystemException {
		if (getLmisDataImportDetailsesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.larion.progate.lmis.model.LmisDataImports")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LmisDataImports>> listenersList = new ArrayList<ModelListener<LmisDataImports>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LmisDataImports>)Class.forName(
							listenerClassName).newInstance());
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		containsLmisDataImportDetails = new ContainsLmisDataImportDetails(this);
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
	protected ContainsLmisDataImportDetails containsLmisDataImportDetails;

	protected class ContainsLmisDataImportDetails {
		protected ContainsLmisDataImportDetails(
			LmisDataImportsPersistenceImpl persistenceImpl) {
			super();

			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSLMISDATAIMPORTDETAILS,
					new int[] { Types.INTEGER, Types.INTEGER }, RowMapper.COUNT);
		}

		protected boolean contains(Integer lmisDataImportsId,
			Integer lmisDataImportDetailsId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						lmisDataImportsId, lmisDataImportDetailsId
					});

			if (results.size() > 0) {
				Integer count = results.get(0);

				if (count.intValue() > 0) {
					return true;
				}
			}

			return false;
		}

		private MappingSqlQuery _mappingSqlQuery;
	}

	private static final String _SQL_GETLMISDATAIMPORTDETAILSES = "SELECT {lmis_data_import_details.*} FROM lmis_data_import_details INNER JOIN lmis_data_imports ON (lmis_data_imports.lmisDataImportsId = lmis_data_import_details.lmisDataImportsId) WHERE (lmis_data_imports.lmisDataImportsId = ?)";
	private static final String _SQL_GETLMISDATAIMPORTDETAILSESSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM lmis_data_import_details WHERE lmisDataImportsId = ?";
	private static final String _SQL_CONTAINSLMISDATAIMPORTDETAILS = "SELECT COUNT(*) AS COUNT_VALUE FROM lmis_data_import_details WHERE lmisDataImportsId = ? AND lmisDataImportDetailsId = ?";
	private static Log _log = LogFactoryUtil.getLog(LmisDataImportsPersistenceImpl.class);
}