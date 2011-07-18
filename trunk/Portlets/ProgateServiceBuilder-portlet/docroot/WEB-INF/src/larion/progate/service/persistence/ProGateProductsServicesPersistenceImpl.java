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

import larion.progate.NoSuchProGateProductsServicesException;

import larion.progate.model.ProGateProductsServices;
import larion.progate.model.impl.ProGateProductsServicesImpl;
import larion.progate.model.impl.ProGateProductsServicesModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="ProGateProductsServicesPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateProductsServicesPersistenceImpl extends BasePersistenceImpl
	implements ProGateProductsServicesPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = ProGateProductsServicesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_ARTICLEID = new FinderPath(ProGateProductsServicesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateProductsServicesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByarticleId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ARTICLEID = new FinderPath(ProGateProductsServicesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateProductsServicesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByarticleId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ARTICLEID = new FinderPath(ProGateProductsServicesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateProductsServicesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByarticleId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_PROGATECATEGORY = new FinderPath(ProGateProductsServicesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateProductsServicesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByprogateCategory",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_PROGATECATEGORY = new FinderPath(ProGateProductsServicesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateProductsServicesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByprogateCategory",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_PROGATECATEGORY = new FinderPath(ProGateProductsServicesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateProductsServicesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByprogateCategory",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ORGID = new FinderPath(ProGateProductsServicesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateProductsServicesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByorgId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ORGID = new FinderPath(ProGateProductsServicesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateProductsServicesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByorgId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGID = new FinderPath(ProGateProductsServicesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateProductsServicesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByorgId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_DISCOUNTEQUAL = new FinderPath(ProGateProductsServicesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateProductsServicesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBydiscountEqual",
			new String[] { Double.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_DISCOUNTEQUAL = new FinderPath(ProGateProductsServicesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateProductsServicesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBydiscountEqual",
			new String[] {
				Double.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_DISCOUNTEQUAL = new FinderPath(ProGateProductsServicesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateProductsServicesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBydiscountEqual",
			new String[] { Double.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_DISCOUNTGREATER = new FinderPath(ProGateProductsServicesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateProductsServicesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBydiscountGreater",
			new String[] { Double.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_DISCOUNTGREATER = new FinderPath(ProGateProductsServicesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateProductsServicesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBydiscountGreater",
			new String[] {
				Double.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_DISCOUNTGREATER = new FinderPath(ProGateProductsServicesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateProductsServicesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBydiscountGreater",
			new String[] { Double.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_DISCOUNTLOWER = new FinderPath(ProGateProductsServicesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateProductsServicesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBydiscountLower",
			new String[] { Double.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_DISCOUNTLOWER = new FinderPath(ProGateProductsServicesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateProductsServicesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBydiscountLower",
			new String[] {
				Double.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_DISCOUNTLOWER = new FinderPath(ProGateProductsServicesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateProductsServicesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBydiscountLower",
			new String[] { Double.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_PRICEEQUAL = new FinderPath(ProGateProductsServicesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateProductsServicesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBypriceEqual",
			new String[] { Double.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_PRICEEQUAL = new FinderPath(ProGateProductsServicesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateProductsServicesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBypriceEqual",
			new String[] {
				Double.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_PRICEEQUAL = new FinderPath(ProGateProductsServicesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateProductsServicesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBypriceEqual",
			new String[] { Double.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_PRICEGREATER = new FinderPath(ProGateProductsServicesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateProductsServicesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBypriceGreater",
			new String[] { Double.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_PRICEGREATER = new FinderPath(ProGateProductsServicesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateProductsServicesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBypriceGreater",
			new String[] {
				Double.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_PRICEGREATER = new FinderPath(ProGateProductsServicesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateProductsServicesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBypriceGreater",
			new String[] { Double.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_PRICELOWER = new FinderPath(ProGateProductsServicesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateProductsServicesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBypriceLower",
			new String[] { Double.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_PRICELOWER = new FinderPath(ProGateProductsServicesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateProductsServicesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBypriceLower",
			new String[] {
				Double.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_PRICELOWER = new FinderPath(ProGateProductsServicesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateProductsServicesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBypriceLower",
			new String[] { Double.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_PRODUCTTYPE = new FinderPath(ProGateProductsServicesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateProductsServicesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByproductType",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_PRODUCTTYPE = new FinderPath(ProGateProductsServicesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateProductsServicesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByproductType",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_PRODUCTTYPE = new FinderPath(ProGateProductsServicesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateProductsServicesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByproductType",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ISSERVICE = new FinderPath(ProGateProductsServicesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateProductsServicesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByisService",
			new String[] { Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ISSERVICE = new FinderPath(ProGateProductsServicesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateProductsServicesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByisService",
			new String[] {
				Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ISSERVICE = new FinderPath(ProGateProductsServicesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateProductsServicesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByisService",
			new String[] { Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ISHOT = new FinderPath(ProGateProductsServicesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateProductsServicesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByisHot",
			new String[] { Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ISHOT = new FinderPath(ProGateProductsServicesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateProductsServicesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByisHot",
			new String[] {
				Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ISHOT = new FinderPath(ProGateProductsServicesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateProductsServicesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByisHot",
			new String[] { Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(ProGateProductsServicesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateProductsServicesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProGateProductsServicesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateProductsServicesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(ProGateProductsServices proGateProductsServices) {
		EntityCacheUtil.putResult(ProGateProductsServicesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateProductsServicesImpl.class,
			proGateProductsServices.getPrimaryKey(), proGateProductsServices);
	}

	public void cacheResult(
		List<ProGateProductsServices> proGateProductsServiceses) {
		for (ProGateProductsServices proGateProductsServices : proGateProductsServiceses) {
			if (EntityCacheUtil.getResult(
						ProGateProductsServicesModelImpl.ENTITY_CACHE_ENABLED,
						ProGateProductsServicesImpl.class,
						proGateProductsServices.getPrimaryKey(), this) == null) {
				cacheResult(proGateProductsServices);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(ProGateProductsServicesImpl.class.getName());
		EntityCacheUtil.clearCache(ProGateProductsServicesImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public ProGateProductsServices create(Integer productsServicesId) {
		ProGateProductsServices proGateProductsServices = new ProGateProductsServicesImpl();

		proGateProductsServices.setNew(true);
		proGateProductsServices.setPrimaryKey(productsServicesId);

		return proGateProductsServices;
	}

	public ProGateProductsServices remove(Integer productsServicesId)
		throws NoSuchProGateProductsServicesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ProGateProductsServices proGateProductsServices = (ProGateProductsServices)session.get(ProGateProductsServicesImpl.class,
					productsServicesId);

			if (proGateProductsServices == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No ProGateProductsServices exists with the primary key " +
						productsServicesId);
				}

				throw new NoSuchProGateProductsServicesException(
					"No ProGateProductsServices exists with the primary key " +
					productsServicesId);
			}

			return remove(proGateProductsServices);
		}
		catch (NoSuchProGateProductsServicesException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public ProGateProductsServices remove(
		ProGateProductsServices proGateProductsServices)
		throws SystemException {
		for (ModelListener<ProGateProductsServices> listener : listeners) {
			listener.onBeforeRemove(proGateProductsServices);
		}

		proGateProductsServices = removeImpl(proGateProductsServices);

		for (ModelListener<ProGateProductsServices> listener : listeners) {
			listener.onAfterRemove(proGateProductsServices);
		}

		return proGateProductsServices;
	}

	protected ProGateProductsServices removeImpl(
		ProGateProductsServices proGateProductsServices)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (proGateProductsServices.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(ProGateProductsServicesImpl.class,
						proGateProductsServices.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(proGateProductsServices);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(ProGateProductsServicesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateProductsServicesImpl.class,
			proGateProductsServices.getPrimaryKey());

		return proGateProductsServices;
	}

	public ProGateProductsServices update(
		ProGateProductsServices proGateProductsServices)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(ProGateProductsServices proGateProductsServices) method. Use update(ProGateProductsServices proGateProductsServices, boolean merge) instead.");
		}

		return update(proGateProductsServices, false);
	}

	public ProGateProductsServices update(
		ProGateProductsServices proGateProductsServices, boolean merge)
		throws SystemException {
		boolean isNew = proGateProductsServices.isNew();

		for (ModelListener<ProGateProductsServices> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(proGateProductsServices);
			}
			else {
				listener.onBeforeUpdate(proGateProductsServices);
			}
		}

		proGateProductsServices = updateImpl(proGateProductsServices, merge);

		for (ModelListener<ProGateProductsServices> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(proGateProductsServices);
			}
			else {
				listener.onAfterUpdate(proGateProductsServices);
			}
		}

		return proGateProductsServices;
	}

	public ProGateProductsServices updateImpl(
		larion.progate.model.ProGateProductsServices proGateProductsServices,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, proGateProductsServices, merge);

			proGateProductsServices.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(ProGateProductsServicesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateProductsServicesImpl.class,
			proGateProductsServices.getPrimaryKey(), proGateProductsServices);

		return proGateProductsServices;
	}

	public ProGateProductsServices findByPrimaryKey(Integer productsServicesId)
		throws NoSuchProGateProductsServicesException, SystemException {
		ProGateProductsServices proGateProductsServices = fetchByPrimaryKey(productsServicesId);

		if (proGateProductsServices == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"No ProGateProductsServices exists with the primary key " +
					productsServicesId);
			}

			throw new NoSuchProGateProductsServicesException(
				"No ProGateProductsServices exists with the primary key " +
				productsServicesId);
		}

		return proGateProductsServices;
	}

	public ProGateProductsServices fetchByPrimaryKey(Integer productsServicesId)
		throws SystemException {
		ProGateProductsServices proGateProductsServices = (ProGateProductsServices)EntityCacheUtil.getResult(ProGateProductsServicesModelImpl.ENTITY_CACHE_ENABLED,
				ProGateProductsServicesImpl.class, productsServicesId, this);

		if (proGateProductsServices == null) {
			Session session = null;

			try {
				session = openSession();

				proGateProductsServices = (ProGateProductsServices)session.get(ProGateProductsServicesImpl.class,
						productsServicesId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (proGateProductsServices != null) {
					cacheResult(proGateProductsServices);
				}

				closeSession(session);
			}
		}

		return proGateProductsServices;
	}

	public List<ProGateProductsServices> findByarticleId(int articleId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(articleId) };

		List<ProGateProductsServices> list = (List<ProGateProductsServices>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ARTICLEID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateProductsServices WHERE ");

				query.append("articleid = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("orgid ASC, ");
				query.append("producttype ASC, ");
				query.append("discount ASC, ");
				query.append("price ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(articleId);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateProductsServices>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ARTICLEID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateProductsServices> findByarticleId(int articleId,
		int start, int end) throws SystemException {
		return findByarticleId(articleId, start, end, null);
	}

	public List<ProGateProductsServices> findByarticleId(int articleId,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(articleId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateProductsServices> list = (List<ProGateProductsServices>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ARTICLEID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateProductsServices WHERE ");

				query.append("articleid = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("orgid ASC, ");
					query.append("producttype ASC, ");
					query.append("discount ASC, ");
					query.append("price ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(articleId);

				list = (List<ProGateProductsServices>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateProductsServices>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ARTICLEID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateProductsServices findByarticleId_First(int articleId,
		OrderByComparator obc)
		throws NoSuchProGateProductsServicesException, SystemException {
		List<ProGateProductsServices> list = findByarticleId(articleId, 0, 1,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateProductsServices exists with the key {");

			msg.append("articleId=" + articleId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateProductsServicesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateProductsServices findByarticleId_Last(int articleId,
		OrderByComparator obc)
		throws NoSuchProGateProductsServicesException, SystemException {
		int count = countByarticleId(articleId);

		List<ProGateProductsServices> list = findByarticleId(articleId,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateProductsServices exists with the key {");

			msg.append("articleId=" + articleId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateProductsServicesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateProductsServices[] findByarticleId_PrevAndNext(
		Integer productsServicesId, int articleId, OrderByComparator obc)
		throws NoSuchProGateProductsServicesException, SystemException {
		ProGateProductsServices proGateProductsServices = findByPrimaryKey(productsServicesId);

		int count = countByarticleId(articleId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateProductsServices WHERE ");

			query.append("articleid = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("orgid ASC, ");
				query.append("producttype ASC, ");
				query.append("discount ASC, ");
				query.append("price ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(articleId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateProductsServices);

			ProGateProductsServices[] array = new ProGateProductsServicesImpl[3];

			array[0] = (ProGateProductsServices)objArray[0];
			array[1] = (ProGateProductsServices)objArray[1];
			array[2] = (ProGateProductsServices)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateProductsServices> findByprogateCategory(
		int progateCategory) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(progateCategory) };

		List<ProGateProductsServices> list = (List<ProGateProductsServices>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_PROGATECATEGORY,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateProductsServices WHERE ");

				query.append("progate_category = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("orgid ASC, ");
				query.append("producttype ASC, ");
				query.append("discount ASC, ");
				query.append("price ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(progateCategory);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateProductsServices>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_PROGATECATEGORY,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateProductsServices> findByprogateCategory(
		int progateCategory, int start, int end) throws SystemException {
		return findByprogateCategory(progateCategory, start, end, null);
	}

	public List<ProGateProductsServices> findByprogateCategory(
		int progateCategory, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(progateCategory),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateProductsServices> list = (List<ProGateProductsServices>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_PROGATECATEGORY,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateProductsServices WHERE ");

				query.append("progate_category = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("orgid ASC, ");
					query.append("producttype ASC, ");
					query.append("discount ASC, ");
					query.append("price ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(progateCategory);

				list = (List<ProGateProductsServices>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateProductsServices>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_PROGATECATEGORY,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateProductsServices findByprogateCategory_First(
		int progateCategory, OrderByComparator obc)
		throws NoSuchProGateProductsServicesException, SystemException {
		List<ProGateProductsServices> list = findByprogateCategory(progateCategory,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateProductsServices exists with the key {");

			msg.append("progateCategory=" + progateCategory);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateProductsServicesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateProductsServices findByprogateCategory_Last(
		int progateCategory, OrderByComparator obc)
		throws NoSuchProGateProductsServicesException, SystemException {
		int count = countByprogateCategory(progateCategory);

		List<ProGateProductsServices> list = findByprogateCategory(progateCategory,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateProductsServices exists with the key {");

			msg.append("progateCategory=" + progateCategory);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateProductsServicesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateProductsServices[] findByprogateCategory_PrevAndNext(
		Integer productsServicesId, int progateCategory, OrderByComparator obc)
		throws NoSuchProGateProductsServicesException, SystemException {
		ProGateProductsServices proGateProductsServices = findByPrimaryKey(productsServicesId);

		int count = countByprogateCategory(progateCategory);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateProductsServices WHERE ");

			query.append("progate_category = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("orgid ASC, ");
				query.append("producttype ASC, ");
				query.append("discount ASC, ");
				query.append("price ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(progateCategory);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateProductsServices);

			ProGateProductsServices[] array = new ProGateProductsServicesImpl[3];

			array[0] = (ProGateProductsServices)objArray[0];
			array[1] = (ProGateProductsServices)objArray[1];
			array[2] = (ProGateProductsServices)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateProductsServices> findByorgId(int orgId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(orgId) };

		List<ProGateProductsServices> list = (List<ProGateProductsServices>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ORGID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateProductsServices WHERE ");

				query.append("orgid = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("orgid ASC, ");
				query.append("producttype ASC, ");
				query.append("discount ASC, ");
				query.append("price ASC");

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
					list = new ArrayList<ProGateProductsServices>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ORGID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateProductsServices> findByorgId(int orgId, int start,
		int end) throws SystemException {
		return findByorgId(orgId, start, end, null);
	}

	public List<ProGateProductsServices> findByorgId(int orgId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(orgId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateProductsServices> list = (List<ProGateProductsServices>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ORGID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateProductsServices WHERE ");

				query.append("orgid = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("orgid ASC, ");
					query.append("producttype ASC, ");
					query.append("discount ASC, ");
					query.append("price ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orgId);

				list = (List<ProGateProductsServices>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateProductsServices>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ORGID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateProductsServices findByorgId_First(int orgId,
		OrderByComparator obc)
		throws NoSuchProGateProductsServicesException, SystemException {
		List<ProGateProductsServices> list = findByorgId(orgId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateProductsServices exists with the key {");

			msg.append("orgId=" + orgId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateProductsServicesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateProductsServices findByorgId_Last(int orgId,
		OrderByComparator obc)
		throws NoSuchProGateProductsServicesException, SystemException {
		int count = countByorgId(orgId);

		List<ProGateProductsServices> list = findByorgId(orgId, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateProductsServices exists with the key {");

			msg.append("orgId=" + orgId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateProductsServicesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateProductsServices[] findByorgId_PrevAndNext(
		Integer productsServicesId, int orgId, OrderByComparator obc)
		throws NoSuchProGateProductsServicesException, SystemException {
		ProGateProductsServices proGateProductsServices = findByPrimaryKey(productsServicesId);

		int count = countByorgId(orgId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateProductsServices WHERE ");

			query.append("orgid = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("orgid ASC, ");
				query.append("producttype ASC, ");
				query.append("discount ASC, ");
				query.append("price ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(orgId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateProductsServices);

			ProGateProductsServices[] array = new ProGateProductsServicesImpl[3];

			array[0] = (ProGateProductsServices)objArray[0];
			array[1] = (ProGateProductsServices)objArray[1];
			array[2] = (ProGateProductsServices)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateProductsServices> findBydiscountEqual(double discount)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Double(discount) };

		List<ProGateProductsServices> list = (List<ProGateProductsServices>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DISCOUNTEQUAL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateProductsServices WHERE ");

				query.append("discount = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("orgid ASC, ");
				query.append("producttype ASC, ");
				query.append("discount ASC, ");
				query.append("price ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(discount);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateProductsServices>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DISCOUNTEQUAL,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateProductsServices> findBydiscountEqual(double discount,
		int start, int end) throws SystemException {
		return findBydiscountEqual(discount, start, end, null);
	}

	public List<ProGateProductsServices> findBydiscountEqual(double discount,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Double(discount),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateProductsServices> list = (List<ProGateProductsServices>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_DISCOUNTEQUAL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateProductsServices WHERE ");

				query.append("discount = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("orgid ASC, ");
					query.append("producttype ASC, ");
					query.append("discount ASC, ");
					query.append("price ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(discount);

				list = (List<ProGateProductsServices>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateProductsServices>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_DISCOUNTEQUAL,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateProductsServices findBydiscountEqual_First(double discount,
		OrderByComparator obc)
		throws NoSuchProGateProductsServicesException, SystemException {
		List<ProGateProductsServices> list = findBydiscountEqual(discount, 0,
				1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateProductsServices exists with the key {");

			msg.append("discount=" + discount);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateProductsServicesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateProductsServices findBydiscountEqual_Last(double discount,
		OrderByComparator obc)
		throws NoSuchProGateProductsServicesException, SystemException {
		int count = countBydiscountEqual(discount);

		List<ProGateProductsServices> list = findBydiscountEqual(discount,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateProductsServices exists with the key {");

			msg.append("discount=" + discount);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateProductsServicesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateProductsServices[] findBydiscountEqual_PrevAndNext(
		Integer productsServicesId, double discount, OrderByComparator obc)
		throws NoSuchProGateProductsServicesException, SystemException {
		ProGateProductsServices proGateProductsServices = findByPrimaryKey(productsServicesId);

		int count = countBydiscountEqual(discount);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateProductsServices WHERE ");

			query.append("discount = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("orgid ASC, ");
				query.append("producttype ASC, ");
				query.append("discount ASC, ");
				query.append("price ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(discount);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateProductsServices);

			ProGateProductsServices[] array = new ProGateProductsServicesImpl[3];

			array[0] = (ProGateProductsServices)objArray[0];
			array[1] = (ProGateProductsServices)objArray[1];
			array[2] = (ProGateProductsServices)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateProductsServices> findBydiscountGreater(double discount)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Double(discount) };

		List<ProGateProductsServices> list = (List<ProGateProductsServices>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DISCOUNTGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateProductsServices WHERE ");

				query.append("discount >= ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("orgid ASC, ");
				query.append("producttype ASC, ");
				query.append("discount ASC, ");
				query.append("price ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(discount);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateProductsServices>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DISCOUNTGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateProductsServices> findBydiscountGreater(
		double discount, int start, int end) throws SystemException {
		return findBydiscountGreater(discount, start, end, null);
	}

	public List<ProGateProductsServices> findBydiscountGreater(
		double discount, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				new Double(discount),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateProductsServices> list = (List<ProGateProductsServices>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_DISCOUNTGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateProductsServices WHERE ");

				query.append("discount >= ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("orgid ASC, ");
					query.append("producttype ASC, ");
					query.append("discount ASC, ");
					query.append("price ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(discount);

				list = (List<ProGateProductsServices>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateProductsServices>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_DISCOUNTGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateProductsServices findBydiscountGreater_First(
		double discount, OrderByComparator obc)
		throws NoSuchProGateProductsServicesException, SystemException {
		List<ProGateProductsServices> list = findBydiscountGreater(discount, 0,
				1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateProductsServices exists with the key {");

			msg.append("discount=" + discount);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateProductsServicesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateProductsServices findBydiscountGreater_Last(double discount,
		OrderByComparator obc)
		throws NoSuchProGateProductsServicesException, SystemException {
		int count = countBydiscountGreater(discount);

		List<ProGateProductsServices> list = findBydiscountGreater(discount,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateProductsServices exists with the key {");

			msg.append("discount=" + discount);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateProductsServicesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateProductsServices[] findBydiscountGreater_PrevAndNext(
		Integer productsServicesId, double discount, OrderByComparator obc)
		throws NoSuchProGateProductsServicesException, SystemException {
		ProGateProductsServices proGateProductsServices = findByPrimaryKey(productsServicesId);

		int count = countBydiscountGreater(discount);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateProductsServices WHERE ");

			query.append("discount >= ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("orgid ASC, ");
				query.append("producttype ASC, ");
				query.append("discount ASC, ");
				query.append("price ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(discount);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateProductsServices);

			ProGateProductsServices[] array = new ProGateProductsServicesImpl[3];

			array[0] = (ProGateProductsServices)objArray[0];
			array[1] = (ProGateProductsServices)objArray[1];
			array[2] = (ProGateProductsServices)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateProductsServices> findBydiscountLower(double discount)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Double(discount) };

		List<ProGateProductsServices> list = (List<ProGateProductsServices>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DISCOUNTLOWER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateProductsServices WHERE ");

				query.append("discount <= ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("orgid ASC, ");
				query.append("producttype ASC, ");
				query.append("discount ASC, ");
				query.append("price ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(discount);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateProductsServices>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DISCOUNTLOWER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateProductsServices> findBydiscountLower(double discount,
		int start, int end) throws SystemException {
		return findBydiscountLower(discount, start, end, null);
	}

	public List<ProGateProductsServices> findBydiscountLower(double discount,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Double(discount),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateProductsServices> list = (List<ProGateProductsServices>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_DISCOUNTLOWER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateProductsServices WHERE ");

				query.append("discount <= ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("orgid ASC, ");
					query.append("producttype ASC, ");
					query.append("discount ASC, ");
					query.append("price ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(discount);

				list = (List<ProGateProductsServices>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateProductsServices>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_DISCOUNTLOWER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateProductsServices findBydiscountLower_First(double discount,
		OrderByComparator obc)
		throws NoSuchProGateProductsServicesException, SystemException {
		List<ProGateProductsServices> list = findBydiscountLower(discount, 0,
				1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateProductsServices exists with the key {");

			msg.append("discount=" + discount);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateProductsServicesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateProductsServices findBydiscountLower_Last(double discount,
		OrderByComparator obc)
		throws NoSuchProGateProductsServicesException, SystemException {
		int count = countBydiscountLower(discount);

		List<ProGateProductsServices> list = findBydiscountLower(discount,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateProductsServices exists with the key {");

			msg.append("discount=" + discount);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateProductsServicesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateProductsServices[] findBydiscountLower_PrevAndNext(
		Integer productsServicesId, double discount, OrderByComparator obc)
		throws NoSuchProGateProductsServicesException, SystemException {
		ProGateProductsServices proGateProductsServices = findByPrimaryKey(productsServicesId);

		int count = countBydiscountLower(discount);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateProductsServices WHERE ");

			query.append("discount <= ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("orgid ASC, ");
				query.append("producttype ASC, ");
				query.append("discount ASC, ");
				query.append("price ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(discount);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateProductsServices);

			ProGateProductsServices[] array = new ProGateProductsServicesImpl[3];

			array[0] = (ProGateProductsServices)objArray[0];
			array[1] = (ProGateProductsServices)objArray[1];
			array[2] = (ProGateProductsServices)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateProductsServices> findBypriceEqual(double price)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Double(price) };

		List<ProGateProductsServices> list = (List<ProGateProductsServices>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_PRICEEQUAL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateProductsServices WHERE ");

				query.append("price = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("orgid ASC, ");
				query.append("producttype ASC, ");
				query.append("discount ASC, ");
				query.append("price ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(price);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateProductsServices>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_PRICEEQUAL,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateProductsServices> findBypriceEqual(double price,
		int start, int end) throws SystemException {
		return findBypriceEqual(price, start, end, null);
	}

	public List<ProGateProductsServices> findBypriceEqual(double price,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Double(price),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateProductsServices> list = (List<ProGateProductsServices>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_PRICEEQUAL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateProductsServices WHERE ");

				query.append("price = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("orgid ASC, ");
					query.append("producttype ASC, ");
					query.append("discount ASC, ");
					query.append("price ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(price);

				list = (List<ProGateProductsServices>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateProductsServices>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_PRICEEQUAL,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateProductsServices findBypriceEqual_First(double price,
		OrderByComparator obc)
		throws NoSuchProGateProductsServicesException, SystemException {
		List<ProGateProductsServices> list = findBypriceEqual(price, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateProductsServices exists with the key {");

			msg.append("price=" + price);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateProductsServicesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateProductsServices findBypriceEqual_Last(double price,
		OrderByComparator obc)
		throws NoSuchProGateProductsServicesException, SystemException {
		int count = countBypriceEqual(price);

		List<ProGateProductsServices> list = findBypriceEqual(price, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateProductsServices exists with the key {");

			msg.append("price=" + price);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateProductsServicesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateProductsServices[] findBypriceEqual_PrevAndNext(
		Integer productsServicesId, double price, OrderByComparator obc)
		throws NoSuchProGateProductsServicesException, SystemException {
		ProGateProductsServices proGateProductsServices = findByPrimaryKey(productsServicesId);

		int count = countBypriceEqual(price);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateProductsServices WHERE ");

			query.append("price = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("orgid ASC, ");
				query.append("producttype ASC, ");
				query.append("discount ASC, ");
				query.append("price ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(price);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateProductsServices);

			ProGateProductsServices[] array = new ProGateProductsServicesImpl[3];

			array[0] = (ProGateProductsServices)objArray[0];
			array[1] = (ProGateProductsServices)objArray[1];
			array[2] = (ProGateProductsServices)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateProductsServices> findBypriceGreater(double price)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Double(price) };

		List<ProGateProductsServices> list = (List<ProGateProductsServices>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_PRICEGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateProductsServices WHERE ");

				query.append("price >= ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("orgid ASC, ");
				query.append("producttype ASC, ");
				query.append("discount ASC, ");
				query.append("price ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(price);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateProductsServices>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_PRICEGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateProductsServices> findBypriceGreater(double price,
		int start, int end) throws SystemException {
		return findBypriceGreater(price, start, end, null);
	}

	public List<ProGateProductsServices> findBypriceGreater(double price,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Double(price),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateProductsServices> list = (List<ProGateProductsServices>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_PRICEGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateProductsServices WHERE ");

				query.append("price >= ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("orgid ASC, ");
					query.append("producttype ASC, ");
					query.append("discount ASC, ");
					query.append("price ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(price);

				list = (List<ProGateProductsServices>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateProductsServices>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_PRICEGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateProductsServices findBypriceGreater_First(double price,
		OrderByComparator obc)
		throws NoSuchProGateProductsServicesException, SystemException {
		List<ProGateProductsServices> list = findBypriceGreater(price, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateProductsServices exists with the key {");

			msg.append("price=" + price);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateProductsServicesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateProductsServices findBypriceGreater_Last(double price,
		OrderByComparator obc)
		throws NoSuchProGateProductsServicesException, SystemException {
		int count = countBypriceGreater(price);

		List<ProGateProductsServices> list = findBypriceGreater(price,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateProductsServices exists with the key {");

			msg.append("price=" + price);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateProductsServicesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateProductsServices[] findBypriceGreater_PrevAndNext(
		Integer productsServicesId, double price, OrderByComparator obc)
		throws NoSuchProGateProductsServicesException, SystemException {
		ProGateProductsServices proGateProductsServices = findByPrimaryKey(productsServicesId);

		int count = countBypriceGreater(price);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateProductsServices WHERE ");

			query.append("price >= ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("orgid ASC, ");
				query.append("producttype ASC, ");
				query.append("discount ASC, ");
				query.append("price ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(price);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateProductsServices);

			ProGateProductsServices[] array = new ProGateProductsServicesImpl[3];

			array[0] = (ProGateProductsServices)objArray[0];
			array[1] = (ProGateProductsServices)objArray[1];
			array[2] = (ProGateProductsServices)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateProductsServices> findBypriceLower(double price)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Double(price) };

		List<ProGateProductsServices> list = (List<ProGateProductsServices>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_PRICELOWER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateProductsServices WHERE ");

				query.append("price <= ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("orgid ASC, ");
				query.append("producttype ASC, ");
				query.append("discount ASC, ");
				query.append("price ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(price);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateProductsServices>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_PRICELOWER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateProductsServices> findBypriceLower(double price,
		int start, int end) throws SystemException {
		return findBypriceLower(price, start, end, null);
	}

	public List<ProGateProductsServices> findBypriceLower(double price,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Double(price),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateProductsServices> list = (List<ProGateProductsServices>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_PRICELOWER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateProductsServices WHERE ");

				query.append("price <= ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("orgid ASC, ");
					query.append("producttype ASC, ");
					query.append("discount ASC, ");
					query.append("price ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(price);

				list = (List<ProGateProductsServices>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateProductsServices>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_PRICELOWER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateProductsServices findBypriceLower_First(double price,
		OrderByComparator obc)
		throws NoSuchProGateProductsServicesException, SystemException {
		List<ProGateProductsServices> list = findBypriceLower(price, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateProductsServices exists with the key {");

			msg.append("price=" + price);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateProductsServicesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateProductsServices findBypriceLower_Last(double price,
		OrderByComparator obc)
		throws NoSuchProGateProductsServicesException, SystemException {
		int count = countBypriceLower(price);

		List<ProGateProductsServices> list = findBypriceLower(price, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateProductsServices exists with the key {");

			msg.append("price=" + price);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateProductsServicesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateProductsServices[] findBypriceLower_PrevAndNext(
		Integer productsServicesId, double price, OrderByComparator obc)
		throws NoSuchProGateProductsServicesException, SystemException {
		ProGateProductsServices proGateProductsServices = findByPrimaryKey(productsServicesId);

		int count = countBypriceLower(price);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateProductsServices WHERE ");

			query.append("price <= ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("orgid ASC, ");
				query.append("producttype ASC, ");
				query.append("discount ASC, ");
				query.append("price ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(price);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateProductsServices);

			ProGateProductsServices[] array = new ProGateProductsServicesImpl[3];

			array[0] = (ProGateProductsServices)objArray[0];
			array[1] = (ProGateProductsServices)objArray[1];
			array[2] = (ProGateProductsServices)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateProductsServices> findByproductType(int productType)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(productType) };

		List<ProGateProductsServices> list = (List<ProGateProductsServices>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_PRODUCTTYPE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateProductsServices WHERE ");

				query.append("producttype = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("orgid ASC, ");
				query.append("producttype ASC, ");
				query.append("discount ASC, ");
				query.append("price ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(productType);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateProductsServices>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_PRODUCTTYPE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateProductsServices> findByproductType(int productType,
		int start, int end) throws SystemException {
		return findByproductType(productType, start, end, null);
	}

	public List<ProGateProductsServices> findByproductType(int productType,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(productType),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateProductsServices> list = (List<ProGateProductsServices>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_PRODUCTTYPE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateProductsServices WHERE ");

				query.append("producttype = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("orgid ASC, ");
					query.append("producttype ASC, ");
					query.append("discount ASC, ");
					query.append("price ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(productType);

				list = (List<ProGateProductsServices>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateProductsServices>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_PRODUCTTYPE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateProductsServices findByproductType_First(int productType,
		OrderByComparator obc)
		throws NoSuchProGateProductsServicesException, SystemException {
		List<ProGateProductsServices> list = findByproductType(productType, 0,
				1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateProductsServices exists with the key {");

			msg.append("productType=" + productType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateProductsServicesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateProductsServices findByproductType_Last(int productType,
		OrderByComparator obc)
		throws NoSuchProGateProductsServicesException, SystemException {
		int count = countByproductType(productType);

		List<ProGateProductsServices> list = findByproductType(productType,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateProductsServices exists with the key {");

			msg.append("productType=" + productType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateProductsServicesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateProductsServices[] findByproductType_PrevAndNext(
		Integer productsServicesId, int productType, OrderByComparator obc)
		throws NoSuchProGateProductsServicesException, SystemException {
		ProGateProductsServices proGateProductsServices = findByPrimaryKey(productsServicesId);

		int count = countByproductType(productType);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateProductsServices WHERE ");

			query.append("producttype = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("orgid ASC, ");
				query.append("producttype ASC, ");
				query.append("discount ASC, ");
				query.append("price ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(productType);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateProductsServices);

			ProGateProductsServices[] array = new ProGateProductsServicesImpl[3];

			array[0] = (ProGateProductsServices)objArray[0];
			array[1] = (ProGateProductsServices)objArray[1];
			array[2] = (ProGateProductsServices)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateProductsServices> findByisService(boolean isService)
		throws SystemException {
		Object[] finderArgs = new Object[] { Boolean.valueOf(isService) };

		List<ProGateProductsServices> list = (List<ProGateProductsServices>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ISSERVICE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateProductsServices WHERE ");

				query.append("isservice = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("orgid ASC, ");
				query.append("producttype ASC, ");
				query.append("discount ASC, ");
				query.append("price ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isService);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateProductsServices>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ISSERVICE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateProductsServices> findByisService(boolean isService,
		int start, int end) throws SystemException {
		return findByisService(isService, start, end, null);
	}

	public List<ProGateProductsServices> findByisService(boolean isService,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				Boolean.valueOf(isService),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateProductsServices> list = (List<ProGateProductsServices>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ISSERVICE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateProductsServices WHERE ");

				query.append("isservice = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("orgid ASC, ");
					query.append("producttype ASC, ");
					query.append("discount ASC, ");
					query.append("price ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isService);

				list = (List<ProGateProductsServices>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateProductsServices>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ISSERVICE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateProductsServices findByisService_First(boolean isService,
		OrderByComparator obc)
		throws NoSuchProGateProductsServicesException, SystemException {
		List<ProGateProductsServices> list = findByisService(isService, 0, 1,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateProductsServices exists with the key {");

			msg.append("isService=" + isService);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateProductsServicesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateProductsServices findByisService_Last(boolean isService,
		OrderByComparator obc)
		throws NoSuchProGateProductsServicesException, SystemException {
		int count = countByisService(isService);

		List<ProGateProductsServices> list = findByisService(isService,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateProductsServices exists with the key {");

			msg.append("isService=" + isService);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateProductsServicesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateProductsServices[] findByisService_PrevAndNext(
		Integer productsServicesId, boolean isService, OrderByComparator obc)
		throws NoSuchProGateProductsServicesException, SystemException {
		ProGateProductsServices proGateProductsServices = findByPrimaryKey(productsServicesId);

		int count = countByisService(isService);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateProductsServices WHERE ");

			query.append("isservice = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("orgid ASC, ");
				query.append("producttype ASC, ");
				query.append("discount ASC, ");
				query.append("price ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(isService);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateProductsServices);

			ProGateProductsServices[] array = new ProGateProductsServicesImpl[3];

			array[0] = (ProGateProductsServices)objArray[0];
			array[1] = (ProGateProductsServices)objArray[1];
			array[2] = (ProGateProductsServices)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateProductsServices> findByisHot(boolean isHot)
		throws SystemException {
		Object[] finderArgs = new Object[] { Boolean.valueOf(isHot) };

		List<ProGateProductsServices> list = (List<ProGateProductsServices>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ISHOT,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateProductsServices WHERE ");

				query.append("is_hot = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("orgid ASC, ");
				query.append("producttype ASC, ");
				query.append("discount ASC, ");
				query.append("price ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isHot);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateProductsServices>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ISHOT,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateProductsServices> findByisHot(boolean isHot, int start,
		int end) throws SystemException {
		return findByisHot(isHot, start, end, null);
	}

	public List<ProGateProductsServices> findByisHot(boolean isHot, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				Boolean.valueOf(isHot),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateProductsServices> list = (List<ProGateProductsServices>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ISHOT,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateProductsServices WHERE ");

				query.append("is_hot = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("orgid ASC, ");
					query.append("producttype ASC, ");
					query.append("discount ASC, ");
					query.append("price ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isHot);

				list = (List<ProGateProductsServices>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateProductsServices>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ISHOT,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateProductsServices findByisHot_First(boolean isHot,
		OrderByComparator obc)
		throws NoSuchProGateProductsServicesException, SystemException {
		List<ProGateProductsServices> list = findByisHot(isHot, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateProductsServices exists with the key {");

			msg.append("isHot=" + isHot);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateProductsServicesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateProductsServices findByisHot_Last(boolean isHot,
		OrderByComparator obc)
		throws NoSuchProGateProductsServicesException, SystemException {
		int count = countByisHot(isHot);

		List<ProGateProductsServices> list = findByisHot(isHot, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateProductsServices exists with the key {");

			msg.append("isHot=" + isHot);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateProductsServicesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateProductsServices[] findByisHot_PrevAndNext(
		Integer productsServicesId, boolean isHot, OrderByComparator obc)
		throws NoSuchProGateProductsServicesException, SystemException {
		ProGateProductsServices proGateProductsServices = findByPrimaryKey(productsServicesId);

		int count = countByisHot(isHot);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateProductsServices WHERE ");

			query.append("is_hot = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("orgid ASC, ");
				query.append("producttype ASC, ");
				query.append("discount ASC, ");
				query.append("price ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(isHot);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateProductsServices);

			ProGateProductsServices[] array = new ProGateProductsServicesImpl[3];

			array[0] = (ProGateProductsServices)objArray[0];
			array[1] = (ProGateProductsServices)objArray[1];
			array[2] = (ProGateProductsServices)objArray[2];

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

	public List<ProGateProductsServices> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<ProGateProductsServices> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<ProGateProductsServices> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateProductsServices> list = (List<ProGateProductsServices>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateProductsServices ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("orgid ASC, ");
					query.append("producttype ASC, ");
					query.append("discount ASC, ");
					query.append("price ASC");
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<ProGateProductsServices>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ProGateProductsServices>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateProductsServices>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByarticleId(int articleId) throws SystemException {
		for (ProGateProductsServices proGateProductsServices : findByarticleId(
				articleId)) {
			remove(proGateProductsServices);
		}
	}

	public void removeByprogateCategory(int progateCategory)
		throws SystemException {
		for (ProGateProductsServices proGateProductsServices : findByprogateCategory(
				progateCategory)) {
			remove(proGateProductsServices);
		}
	}

	public void removeByorgId(int orgId) throws SystemException {
		for (ProGateProductsServices proGateProductsServices : findByorgId(
				orgId)) {
			remove(proGateProductsServices);
		}
	}

	public void removeBydiscountEqual(double discount)
		throws SystemException {
		for (ProGateProductsServices proGateProductsServices : findBydiscountEqual(
				discount)) {
			remove(proGateProductsServices);
		}
	}

	public void removeBydiscountGreater(double discount)
		throws SystemException {
		for (ProGateProductsServices proGateProductsServices : findBydiscountGreater(
				discount)) {
			remove(proGateProductsServices);
		}
	}

	public void removeBydiscountLower(double discount)
		throws SystemException {
		for (ProGateProductsServices proGateProductsServices : findBydiscountLower(
				discount)) {
			remove(proGateProductsServices);
		}
	}

	public void removeBypriceEqual(double price) throws SystemException {
		for (ProGateProductsServices proGateProductsServices : findBypriceEqual(
				price)) {
			remove(proGateProductsServices);
		}
	}

	public void removeBypriceGreater(double price) throws SystemException {
		for (ProGateProductsServices proGateProductsServices : findBypriceGreater(
				price)) {
			remove(proGateProductsServices);
		}
	}

	public void removeBypriceLower(double price) throws SystemException {
		for (ProGateProductsServices proGateProductsServices : findBypriceLower(
				price)) {
			remove(proGateProductsServices);
		}
	}

	public void removeByproductType(int productType) throws SystemException {
		for (ProGateProductsServices proGateProductsServices : findByproductType(
				productType)) {
			remove(proGateProductsServices);
		}
	}

	public void removeByisService(boolean isService) throws SystemException {
		for (ProGateProductsServices proGateProductsServices : findByisService(
				isService)) {
			remove(proGateProductsServices);
		}
	}

	public void removeByisHot(boolean isHot) throws SystemException {
		for (ProGateProductsServices proGateProductsServices : findByisHot(
				isHot)) {
			remove(proGateProductsServices);
		}
	}

	public void removeAll() throws SystemException {
		for (ProGateProductsServices proGateProductsServices : findAll()) {
			remove(proGateProductsServices);
		}
	}

	public int countByarticleId(int articleId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(articleId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ARTICLEID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateProductsServices WHERE ");

				query.append("articleid = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(articleId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ARTICLEID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByprogateCategory(int progateCategory)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(progateCategory) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PROGATECATEGORY,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateProductsServices WHERE ");

				query.append("progate_category = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(progateCategory);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PROGATECATEGORY,
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
					"FROM larion.progate.model.ProGateProductsServices WHERE ");

				query.append("orgid = ?");

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

	public int countBydiscountEqual(double discount) throws SystemException {
		Object[] finderArgs = new Object[] { new Double(discount) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DISCOUNTEQUAL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateProductsServices WHERE ");

				query.append("discount = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(discount);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DISCOUNTEQUAL,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countBydiscountGreater(double discount)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Double(discount) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DISCOUNTGREATER,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateProductsServices WHERE ");

				query.append("discount >= ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(discount);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DISCOUNTGREATER,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countBydiscountLower(double discount) throws SystemException {
		Object[] finderArgs = new Object[] { new Double(discount) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DISCOUNTLOWER,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateProductsServices WHERE ");

				query.append("discount <= ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(discount);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DISCOUNTLOWER,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countBypriceEqual(double price) throws SystemException {
		Object[] finderArgs = new Object[] { new Double(price) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PRICEEQUAL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateProductsServices WHERE ");

				query.append("price = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(price);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PRICEEQUAL,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countBypriceGreater(double price) throws SystemException {
		Object[] finderArgs = new Object[] { new Double(price) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PRICEGREATER,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateProductsServices WHERE ");

				query.append("price >= ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(price);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PRICEGREATER,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countBypriceLower(double price) throws SystemException {
		Object[] finderArgs = new Object[] { new Double(price) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PRICELOWER,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateProductsServices WHERE ");

				query.append("price <= ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(price);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PRICELOWER,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByproductType(int productType) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(productType) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PRODUCTTYPE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateProductsServices WHERE ");

				query.append("producttype = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(productType);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PRODUCTTYPE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByisService(boolean isService) throws SystemException {
		Object[] finderArgs = new Object[] { Boolean.valueOf(isService) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ISSERVICE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateProductsServices WHERE ");

				query.append("isservice = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isService);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ISSERVICE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByisHot(boolean isHot) throws SystemException {
		Object[] finderArgs = new Object[] { Boolean.valueOf(isHot) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ISHOT,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateProductsServices WHERE ");

				query.append("is_hot = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isHot);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ISHOT,
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
						"SELECT COUNT(*) FROM larion.progate.model.ProGateProductsServices");

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
						"value.object.listener.larion.progate.model.ProGateProductsServices")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ProGateProductsServices>> listenersList = new ArrayList<ModelListener<ProGateProductsServices>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ProGateProductsServices>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(ProGateProductsServicesPersistenceImpl.class);
}