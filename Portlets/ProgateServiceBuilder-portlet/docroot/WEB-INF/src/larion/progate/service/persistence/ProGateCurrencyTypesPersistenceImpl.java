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
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import larion.progate.NoSuchProGateCurrencyTypesException;

import larion.progate.model.ProGateCurrencyTypes;
import larion.progate.model.impl.ProGateCurrencyTypesImpl;
import larion.progate.model.impl.ProGateCurrencyTypesModelImpl;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="ProGateCurrencyTypesPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateCurrencyTypesPersistenceImpl extends BasePersistenceImpl
	implements ProGateCurrencyTypesPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = ProGateCurrencyTypesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_CODE = new FinderPath(ProGateCurrencyTypesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateCurrencyTypesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycode",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_CODE = new FinderPath(ProGateCurrencyTypesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateCurrencyTypesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycode",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_CODE = new FinderPath(ProGateCurrencyTypesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateCurrencyTypesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBycode",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(ProGateCurrencyTypesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateCurrencyTypesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProGateCurrencyTypesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateCurrencyTypesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(ProGateCurrencyTypes proGateCurrencyTypes) {
		EntityCacheUtil.putResult(ProGateCurrencyTypesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateCurrencyTypesImpl.class,
			proGateCurrencyTypes.getPrimaryKey(), proGateCurrencyTypes);
	}

	public void cacheResult(List<ProGateCurrencyTypes> proGateCurrencyTypeses) {
		for (ProGateCurrencyTypes proGateCurrencyTypes : proGateCurrencyTypeses) {
			if (EntityCacheUtil.getResult(
						ProGateCurrencyTypesModelImpl.ENTITY_CACHE_ENABLED,
						ProGateCurrencyTypesImpl.class,
						proGateCurrencyTypes.getPrimaryKey(), this) == null) {
				cacheResult(proGateCurrencyTypes);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(ProGateCurrencyTypesImpl.class.getName());
		EntityCacheUtil.clearCache(ProGateCurrencyTypesImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public ProGateCurrencyTypes create(Integer currencyId) {
		ProGateCurrencyTypes proGateCurrencyTypes = new ProGateCurrencyTypesImpl();

		proGateCurrencyTypes.setNew(true);
		proGateCurrencyTypes.setPrimaryKey(currencyId);

		return proGateCurrencyTypes;
	}

	public ProGateCurrencyTypes remove(Integer currencyId)
		throws NoSuchProGateCurrencyTypesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ProGateCurrencyTypes proGateCurrencyTypes = (ProGateCurrencyTypes)session.get(ProGateCurrencyTypesImpl.class,
					currencyId);

			if (proGateCurrencyTypes == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No ProGateCurrencyTypes exists with the primary key " +
						currencyId);
				}

				throw new NoSuchProGateCurrencyTypesException(
					"No ProGateCurrencyTypes exists with the primary key " +
					currencyId);
			}

			return remove(proGateCurrencyTypes);
		}
		catch (NoSuchProGateCurrencyTypesException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public ProGateCurrencyTypes remove(
		ProGateCurrencyTypes proGateCurrencyTypes) throws SystemException {
		for (ModelListener<ProGateCurrencyTypes> listener : listeners) {
			listener.onBeforeRemove(proGateCurrencyTypes);
		}

		proGateCurrencyTypes = removeImpl(proGateCurrencyTypes);

		for (ModelListener<ProGateCurrencyTypes> listener : listeners) {
			listener.onAfterRemove(proGateCurrencyTypes);
		}

		return proGateCurrencyTypes;
	}

	protected ProGateCurrencyTypes removeImpl(
		ProGateCurrencyTypes proGateCurrencyTypes) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (proGateCurrencyTypes.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(ProGateCurrencyTypesImpl.class,
						proGateCurrencyTypes.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(proGateCurrencyTypes);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(ProGateCurrencyTypesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateCurrencyTypesImpl.class, proGateCurrencyTypes.getPrimaryKey());

		return proGateCurrencyTypes;
	}

	public ProGateCurrencyTypes update(
		ProGateCurrencyTypes proGateCurrencyTypes) throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(ProGateCurrencyTypes proGateCurrencyTypes) method. Use update(ProGateCurrencyTypes proGateCurrencyTypes, boolean merge) instead.");
		}

		return update(proGateCurrencyTypes, false);
	}

	public ProGateCurrencyTypes update(
		ProGateCurrencyTypes proGateCurrencyTypes, boolean merge)
		throws SystemException {
		boolean isNew = proGateCurrencyTypes.isNew();

		for (ModelListener<ProGateCurrencyTypes> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(proGateCurrencyTypes);
			}
			else {
				listener.onBeforeUpdate(proGateCurrencyTypes);
			}
		}

		proGateCurrencyTypes = updateImpl(proGateCurrencyTypes, merge);

		for (ModelListener<ProGateCurrencyTypes> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(proGateCurrencyTypes);
			}
			else {
				listener.onAfterUpdate(proGateCurrencyTypes);
			}
		}

		return proGateCurrencyTypes;
	}

	public ProGateCurrencyTypes updateImpl(
		larion.progate.model.ProGateCurrencyTypes proGateCurrencyTypes,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, proGateCurrencyTypes, merge);

			proGateCurrencyTypes.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(ProGateCurrencyTypesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateCurrencyTypesImpl.class,
			proGateCurrencyTypes.getPrimaryKey(), proGateCurrencyTypes);

		return proGateCurrencyTypes;
	}

	public ProGateCurrencyTypes findByPrimaryKey(Integer currencyId)
		throws NoSuchProGateCurrencyTypesException, SystemException {
		ProGateCurrencyTypes proGateCurrencyTypes = fetchByPrimaryKey(currencyId);

		if (proGateCurrencyTypes == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"No ProGateCurrencyTypes exists with the primary key " +
					currencyId);
			}

			throw new NoSuchProGateCurrencyTypesException(
				"No ProGateCurrencyTypes exists with the primary key " +
				currencyId);
		}

		return proGateCurrencyTypes;
	}

	public ProGateCurrencyTypes fetchByPrimaryKey(Integer currencyId)
		throws SystemException {
		ProGateCurrencyTypes proGateCurrencyTypes = (ProGateCurrencyTypes)EntityCacheUtil.getResult(ProGateCurrencyTypesModelImpl.ENTITY_CACHE_ENABLED,
				ProGateCurrencyTypesImpl.class, currencyId, this);

		if (proGateCurrencyTypes == null) {
			Session session = null;

			try {
				session = openSession();

				proGateCurrencyTypes = (ProGateCurrencyTypes)session.get(ProGateCurrencyTypesImpl.class,
						currencyId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (proGateCurrencyTypes != null) {
					cacheResult(proGateCurrencyTypes);
				}

				closeSession(session);
			}
		}

		return proGateCurrencyTypes;
	}

	public List<ProGateCurrencyTypes> findBycode(String code)
		throws SystemException {
		Object[] finderArgs = new Object[] { code };

		List<ProGateCurrencyTypes> list = (List<ProGateCurrencyTypes>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_CODE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateCurrencyTypes WHERE ");

				if (code == null) {
					query.append("code IS NULL");
				}
				else {
					query.append("code = ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (code != null) {
					qPos.add(code);
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateCurrencyTypes>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_CODE, finderArgs,
					list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateCurrencyTypes> findBycode(String code, int start, int end)
		throws SystemException {
		return findBycode(code, start, end, null);
	}

	public List<ProGateCurrencyTypes> findBycode(String code, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				code,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateCurrencyTypes> list = (List<ProGateCurrencyTypes>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_CODE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateCurrencyTypes WHERE ");

				if (code == null) {
					query.append("code IS NULL");
				}
				else {
					query.append("code = ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (code != null) {
					qPos.add(code);
				}

				list = (List<ProGateCurrencyTypes>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateCurrencyTypes>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_CODE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateCurrencyTypes findBycode_First(String code,
		OrderByComparator obc)
		throws NoSuchProGateCurrencyTypesException, SystemException {
		List<ProGateCurrencyTypes> list = findBycode(code, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateCurrencyTypes exists with the key {");

			msg.append("code=" + code);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateCurrencyTypesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateCurrencyTypes findBycode_Last(String code,
		OrderByComparator obc)
		throws NoSuchProGateCurrencyTypesException, SystemException {
		int count = countBycode(code);

		List<ProGateCurrencyTypes> list = findBycode(code, count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateCurrencyTypes exists with the key {");

			msg.append("code=" + code);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateCurrencyTypesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateCurrencyTypes[] findBycode_PrevAndNext(Integer currencyId,
		String code, OrderByComparator obc)
		throws NoSuchProGateCurrencyTypesException, SystemException {
		ProGateCurrencyTypes proGateCurrencyTypes = findByPrimaryKey(currencyId);

		int count = countBycode(code);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateCurrencyTypes WHERE ");

			if (code == null) {
				query.append("code IS NULL");
			}
			else {
				query.append("code = ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (code != null) {
				qPos.add(code);
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateCurrencyTypes);

			ProGateCurrencyTypes[] array = new ProGateCurrencyTypesImpl[3];

			array[0] = (ProGateCurrencyTypes)objArray[0];
			array[1] = (ProGateCurrencyTypes)objArray[1];
			array[2] = (ProGateCurrencyTypes)objArray[2];

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

	public List<ProGateCurrencyTypes> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<ProGateCurrencyTypes> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<ProGateCurrencyTypes> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateCurrencyTypes> list = (List<ProGateCurrencyTypes>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.ProGateCurrencyTypes ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<ProGateCurrencyTypes>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ProGateCurrencyTypes>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateCurrencyTypes>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeBycode(String code) throws SystemException {
		for (ProGateCurrencyTypes proGateCurrencyTypes : findBycode(code)) {
			remove(proGateCurrencyTypes);
		}
	}

	public void removeAll() throws SystemException {
		for (ProGateCurrencyTypes proGateCurrencyTypes : findAll()) {
			remove(proGateCurrencyTypes);
		}
	}

	public int countBycode(String code) throws SystemException {
		Object[] finderArgs = new Object[] { code };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CODE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateCurrencyTypes WHERE ");

				if (code == null) {
					query.append("code IS NULL");
				}
				else {
					query.append("code = ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (code != null) {
					qPos.add(code);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CODE,
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
						"SELECT COUNT(*) FROM larion.progate.model.ProGateCurrencyTypes");

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

	public List<larion.progate.model.ProGateProductsServices> getProGateProductsServiceses(
		Integer pk) throws SystemException {
		return getProGateProductsServiceses(pk, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS);
	}

	public List<larion.progate.model.ProGateProductsServices> getProGateProductsServiceses(
		Integer pk, int start, int end) throws SystemException {
		return getProGateProductsServiceses(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_PROGATEPRODUCTSSERVICESES = new FinderPath(larion.progate.model.impl.ProGateProductsServicesModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.model.impl.ProGateProductsServicesModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.service.persistence.ProGateProductsServicesPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getProGateProductsServiceses",
			new String[] {
				Integer.class.getName(), "java.lang.Integer",
				"java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	public List<larion.progate.model.ProGateProductsServices> getProGateProductsServiceses(
		Integer pk, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				pk, String.valueOf(start), String.valueOf(end),
				String.valueOf(obc)
			};

		List<larion.progate.model.ProGateProductsServices> list = (List<larion.progate.model.ProGateProductsServices>)FinderCacheUtil.getResult(FINDER_PATH_GET_PROGATEPRODUCTSSERVICESES,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder sb = new StringBuilder();

				sb.append(_SQL_GETPROGATEPRODUCTSSERVICESES);

				if (obc != null) {
					sb.append("ORDER BY ");
					sb.append(obc.getOrderBy());
				}

				else {
					sb.append("ORDER BY ");

					sb.append("progate_products_services.orgid ASC, ");
					sb.append("progate_products_services.producttype ASC, ");
					sb.append("progate_products_services.discount ASC, ");
					sb.append("progate_products_services.price ASC");
				}

				String sql = sb.toString();

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("progate_products_services",
					larion.progate.model.impl.ProGateProductsServicesImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<larion.progate.model.ProGateProductsServices>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<larion.progate.model.ProGateProductsServices>();
				}

				proGateProductsServicesPersistence.cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_GET_PROGATEPRODUCTSSERVICESES,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_PROGATEPRODUCTSSERVICESES_SIZE =
		new FinderPath(larion.progate.model.impl.ProGateProductsServicesModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.model.impl.ProGateProductsServicesModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.service.persistence.ProGateProductsServicesPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getProGateProductsServicesesSize",
			new String[] { Integer.class.getName() });

	public int getProGateProductsServicesesSize(Integer pk)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_PROGATEPRODUCTSSERVICESES_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETPROGATEPRODUCTSSERVICESESSIZE);

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

				FinderCacheUtil.putResult(FINDER_PATH_GET_PROGATEPRODUCTSSERVICESES_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_PROGATEPRODUCTSSERVICES = new FinderPath(larion.progate.model.impl.ProGateProductsServicesModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.model.impl.ProGateProductsServicesModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.service.persistence.ProGateProductsServicesPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"containsProGateProductsServices",
			new String[] { Integer.class.getName(), Integer.class.getName() });

	public boolean containsProGateProductsServices(Integer pk,
		Integer proGateProductsServicesPK) throws SystemException {
		Object[] finderArgs = new Object[] { pk, proGateProductsServicesPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_PROGATEPRODUCTSSERVICES,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsProGateProductsServices.contains(
							pk, proGateProductsServicesPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_PROGATEPRODUCTSSERVICES,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	public boolean containsProGateProductsServiceses(Integer pk)
		throws SystemException {
		if (getProGateProductsServicesesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.larion.progate.model.ProGateCurrencyTypes")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ProGateCurrencyTypes>> listenersList = new ArrayList<ModelListener<ProGateCurrencyTypes>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ProGateCurrencyTypes>)Class.forName(
							listenerClassName).newInstance());
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		containsProGateProductsServices = new ContainsProGateProductsServices(this);
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
	protected ContainsProGateProductsServices containsProGateProductsServices;

	protected class ContainsProGateProductsServices {
		protected ContainsProGateProductsServices(
			ProGateCurrencyTypesPersistenceImpl persistenceImpl) {
			super();

			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSPROGATEPRODUCTSSERVICES,
					new int[] { Types.INTEGER, Types.INTEGER }, RowMapper.COUNT);
		}

		protected boolean contains(Integer currencyId,
			Integer productsServicesId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						currencyId, productsServicesId
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

	private static final String _SQL_GETPROGATEPRODUCTSSERVICESES = "SELECT {progate_products_services.*} FROM progate_products_services INNER JOIN progate_currencytypes ON (progate_currencytypes.currencyId = progate_products_services.currencyId) WHERE (progate_currencytypes.currencyId = ?)";
	private static final String _SQL_GETPROGATEPRODUCTSSERVICESESSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM progate_products_services WHERE currencyId = ?";
	private static final String _SQL_CONTAINSPROGATEPRODUCTSSERVICES = "SELECT COUNT(*) AS COUNT_VALUE FROM progate_products_services WHERE currencyId = ? AND productsServicesId = ?";
	private static Log _log = LogFactoryUtil.getLog(ProGateCurrencyTypesPersistenceImpl.class);
}