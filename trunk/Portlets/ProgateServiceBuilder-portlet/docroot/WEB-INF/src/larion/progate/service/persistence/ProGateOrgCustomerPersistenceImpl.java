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
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import larion.progate.NoSuchProGateOrgCustomerException;

import larion.progate.model.ProGateOrgCustomer;
import larion.progate.model.impl.ProGateOrgCustomerImpl;
import larion.progate.model.impl.ProGateOrgCustomerModelImpl;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * <a href="ProGateOrgCustomerPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateOrgCustomerPersistenceImpl extends BasePersistenceImpl
	implements ProGateOrgCustomerPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = ProGateOrgCustomerImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_CUSTOMERNAME = new FinderPath(ProGateOrgCustomerModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycustomerName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_CUSTOMERNAME = new FinderPath(ProGateOrgCustomerModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycustomerName",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_CUSTOMERNAME = new FinderPath(ProGateOrgCustomerModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBycustomerName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_CUSTOMERTYPEEQUAL = new FinderPath(ProGateOrgCustomerModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycustomerTypeEqual",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_CUSTOMERTYPEEQUAL = new FinderPath(ProGateOrgCustomerModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycustomerTypeEqual",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_CUSTOMERTYPEEQUAL = new FinderPath(ProGateOrgCustomerModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBycustomerTypeEqual",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_CUSTOMERTYPEGREATER = new FinderPath(ProGateOrgCustomerModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycustomerTypeGreater",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_CUSTOMERTYPEGREATER = new FinderPath(ProGateOrgCustomerModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycustomerTypeGreater",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_CUSTOMERTYPEGREATER = new FinderPath(ProGateOrgCustomerModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBycustomerTypeGreater",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_CUSTOMERTYPELOWER = new FinderPath(ProGateOrgCustomerModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycustomerTypeLower",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_CUSTOMERTYPELOWER = new FinderPath(ProGateOrgCustomerModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycustomerTypeLower",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_CUSTOMERTYPELOWER = new FinderPath(ProGateOrgCustomerModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBycustomerTypeLower",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ORGID = new FinderPath(ProGateOrgCustomerModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByorgId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ORGID = new FinderPath(ProGateOrgCustomerModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByorgId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGID = new FinderPath(ProGateOrgCustomerModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByorgId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_CREATEDDATEEQUAL = new FinderPath(ProGateOrgCustomerModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycreatedDateEqual",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_CREATEDDATEEQUAL = new FinderPath(ProGateOrgCustomerModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycreatedDateEqual",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_CREATEDDATEEQUAL = new FinderPath(ProGateOrgCustomerModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBycreatedDateEqual",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_CREATEDDATEGREATER = new FinderPath(ProGateOrgCustomerModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycreatedDateGreater",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_CREATEDDATEGREATER = new FinderPath(ProGateOrgCustomerModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycreatedDateGreater",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_CREATEDDATEGREATER = new FinderPath(ProGateOrgCustomerModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBycreatedDateGreater",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_CREATEDDATELOWER = new FinderPath(ProGateOrgCustomerModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycreatedDateLower",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_CREATEDDATELOWER = new FinderPath(ProGateOrgCustomerModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycreatedDateLower",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_CREATEDDATELOWER = new FinderPath(ProGateOrgCustomerModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBycreatedDateLower",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_MODIFIEDDATEEQUAL = new FinderPath(ProGateOrgCustomerModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBymodifiedDateEqual",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_MODIFIEDDATEEQUAL = new FinderPath(ProGateOrgCustomerModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBymodifiedDateEqual",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_MODIFIEDDATEEQUAL = new FinderPath(ProGateOrgCustomerModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBymodifiedDateEqual",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_MODIFIEDDATEGREATER = new FinderPath(ProGateOrgCustomerModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBymodifiedDateGreater",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_MODIFIEDDATEGREATER = new FinderPath(ProGateOrgCustomerModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBymodifiedDateGreater",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_MODIFIEDDATEGREATER = new FinderPath(ProGateOrgCustomerModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBymodifiedDateGreater",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_MODIFIEDDATELOWER = new FinderPath(ProGateOrgCustomerModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBymodifiedDateLower",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_MODIFIEDDATELOWER = new FinderPath(ProGateOrgCustomerModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBymodifiedDateLower",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_MODIFIEDDATELOWER = new FinderPath(ProGateOrgCustomerModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBymodifiedDateLower",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(ProGateOrgCustomerModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProGateOrgCustomerModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(ProGateOrgCustomer proGateOrgCustomer) {
		EntityCacheUtil.putResult(ProGateOrgCustomerModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerImpl.class, proGateOrgCustomer.getPrimaryKey(),
			proGateOrgCustomer);
	}

	public void cacheResult(List<ProGateOrgCustomer> proGateOrgCustomers) {
		for (ProGateOrgCustomer proGateOrgCustomer : proGateOrgCustomers) {
			if (EntityCacheUtil.getResult(
						ProGateOrgCustomerModelImpl.ENTITY_CACHE_ENABLED,
						ProGateOrgCustomerImpl.class,
						proGateOrgCustomer.getPrimaryKey(), this) == null) {
				cacheResult(proGateOrgCustomer);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(ProGateOrgCustomerImpl.class.getName());
		EntityCacheUtil.clearCache(ProGateOrgCustomerImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public ProGateOrgCustomer create(Integer ProGateOrgCustomerId) {
		ProGateOrgCustomer proGateOrgCustomer = new ProGateOrgCustomerImpl();

		proGateOrgCustomer.setNew(true);
		proGateOrgCustomer.setPrimaryKey(ProGateOrgCustomerId);

		return proGateOrgCustomer;
	}

	public ProGateOrgCustomer remove(Integer ProGateOrgCustomerId)
		throws NoSuchProGateOrgCustomerException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ProGateOrgCustomer proGateOrgCustomer = (ProGateOrgCustomer)session.get(ProGateOrgCustomerImpl.class,
					ProGateOrgCustomerId);

			if (proGateOrgCustomer == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No ProGateOrgCustomer exists with the primary key " +
						ProGateOrgCustomerId);
				}

				throw new NoSuchProGateOrgCustomerException(
					"No ProGateOrgCustomer exists with the primary key " +
					ProGateOrgCustomerId);
			}

			return remove(proGateOrgCustomer);
		}
		catch (NoSuchProGateOrgCustomerException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public ProGateOrgCustomer remove(ProGateOrgCustomer proGateOrgCustomer)
		throws SystemException {
		for (ModelListener<ProGateOrgCustomer> listener : listeners) {
			listener.onBeforeRemove(proGateOrgCustomer);
		}

		proGateOrgCustomer = removeImpl(proGateOrgCustomer);

		for (ModelListener<ProGateOrgCustomer> listener : listeners) {
			listener.onAfterRemove(proGateOrgCustomer);
		}

		return proGateOrgCustomer;
	}

	protected ProGateOrgCustomer removeImpl(
		ProGateOrgCustomer proGateOrgCustomer) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (proGateOrgCustomer.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(ProGateOrgCustomerImpl.class,
						proGateOrgCustomer.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(proGateOrgCustomer);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(ProGateOrgCustomerModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerImpl.class, proGateOrgCustomer.getPrimaryKey());

		return proGateOrgCustomer;
	}

	public ProGateOrgCustomer update(ProGateOrgCustomer proGateOrgCustomer)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(ProGateOrgCustomer proGateOrgCustomer) method. Use update(ProGateOrgCustomer proGateOrgCustomer, boolean merge) instead.");
		}

		return update(proGateOrgCustomer, false);
	}

	public ProGateOrgCustomer update(ProGateOrgCustomer proGateOrgCustomer,
		boolean merge) throws SystemException {
		boolean isNew = proGateOrgCustomer.isNew();

		for (ModelListener<ProGateOrgCustomer> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(proGateOrgCustomer);
			}
			else {
				listener.onBeforeUpdate(proGateOrgCustomer);
			}
		}

		proGateOrgCustomer = updateImpl(proGateOrgCustomer, merge);

		for (ModelListener<ProGateOrgCustomer> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(proGateOrgCustomer);
			}
			else {
				listener.onAfterUpdate(proGateOrgCustomer);
			}
		}

		return proGateOrgCustomer;
	}

	public ProGateOrgCustomer updateImpl(
		larion.progate.model.ProGateOrgCustomer proGateOrgCustomer,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, proGateOrgCustomer, merge);

			proGateOrgCustomer.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(ProGateOrgCustomerModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerImpl.class, proGateOrgCustomer.getPrimaryKey(),
			proGateOrgCustomer);

		return proGateOrgCustomer;
	}

	public ProGateOrgCustomer findByPrimaryKey(Integer ProGateOrgCustomerId)
		throws NoSuchProGateOrgCustomerException, SystemException {
		ProGateOrgCustomer proGateOrgCustomer = fetchByPrimaryKey(ProGateOrgCustomerId);

		if (proGateOrgCustomer == null) {
			if (_log.isWarnEnabled()) {
				_log.warn("No ProGateOrgCustomer exists with the primary key " +
					ProGateOrgCustomerId);
			}

			throw new NoSuchProGateOrgCustomerException(
				"No ProGateOrgCustomer exists with the primary key " +
				ProGateOrgCustomerId);
		}

		return proGateOrgCustomer;
	}

	public ProGateOrgCustomer fetchByPrimaryKey(Integer ProGateOrgCustomerId)
		throws SystemException {
		ProGateOrgCustomer proGateOrgCustomer = (ProGateOrgCustomer)EntityCacheUtil.getResult(ProGateOrgCustomerModelImpl.ENTITY_CACHE_ENABLED,
				ProGateOrgCustomerImpl.class, ProGateOrgCustomerId, this);

		if (proGateOrgCustomer == null) {
			Session session = null;

			try {
				session = openSession();

				proGateOrgCustomer = (ProGateOrgCustomer)session.get(ProGateOrgCustomerImpl.class,
						ProGateOrgCustomerId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (proGateOrgCustomer != null) {
					cacheResult(proGateOrgCustomer);
				}

				closeSession(session);
			}
		}

		return proGateOrgCustomer;
	}

	public List<ProGateOrgCustomer> findBycustomerName(String customerName)
		throws SystemException {
		Object[] finderArgs = new Object[] { customerName };

		List<ProGateOrgCustomer> list = (List<ProGateOrgCustomer>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_CUSTOMERNAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateOrgCustomer WHERE ");

				if (customerName == null) {
					query.append("customer_name IS NULL");
				}
				else {
					query.append("customer_name = ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("modified_date DESC, ");
				query.append("created_date DESC, ");
				query.append("customer_name DESC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (customerName != null) {
					qPos.add(customerName);
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateOrgCustomer>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_CUSTOMERNAME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateOrgCustomer> findBycustomerName(String customerName,
		int start, int end) throws SystemException {
		return findBycustomerName(customerName, start, end, null);
	}

	public List<ProGateOrgCustomer> findBycustomerName(String customerName,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				customerName,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateOrgCustomer> list = (List<ProGateOrgCustomer>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_CUSTOMERNAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateOrgCustomer WHERE ");

				if (customerName == null) {
					query.append("customer_name IS NULL");
				}
				else {
					query.append("customer_name = ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("modified_date DESC, ");
					query.append("created_date DESC, ");
					query.append("customer_name DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (customerName != null) {
					qPos.add(customerName);
				}

				list = (List<ProGateOrgCustomer>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateOrgCustomer>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_CUSTOMERNAME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateOrgCustomer findBycustomerName_First(String customerName,
		OrderByComparator obc)
		throws NoSuchProGateOrgCustomerException, SystemException {
		List<ProGateOrgCustomer> list = findBycustomerName(customerName, 0, 1,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateOrgCustomer exists with the key {");

			msg.append("customerName=" + customerName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateOrgCustomerException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateOrgCustomer findBycustomerName_Last(String customerName,
		OrderByComparator obc)
		throws NoSuchProGateOrgCustomerException, SystemException {
		int count = countBycustomerName(customerName);

		List<ProGateOrgCustomer> list = findBycustomerName(customerName,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateOrgCustomer exists with the key {");

			msg.append("customerName=" + customerName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateOrgCustomerException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateOrgCustomer[] findBycustomerName_PrevAndNext(
		Integer ProGateOrgCustomerId, String customerName, OrderByComparator obc)
		throws NoSuchProGateOrgCustomerException, SystemException {
		ProGateOrgCustomer proGateOrgCustomer = findByPrimaryKey(ProGateOrgCustomerId);

		int count = countBycustomerName(customerName);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.ProGateOrgCustomer WHERE ");

			if (customerName == null) {
				query.append("customer_name IS NULL");
			}
			else {
				query.append("customer_name = ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("modified_date DESC, ");
				query.append("created_date DESC, ");
				query.append("customer_name DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (customerName != null) {
				qPos.add(customerName);
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateOrgCustomer);

			ProGateOrgCustomer[] array = new ProGateOrgCustomerImpl[3];

			array[0] = (ProGateOrgCustomer)objArray[0];
			array[1] = (ProGateOrgCustomer)objArray[1];
			array[2] = (ProGateOrgCustomer)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateOrgCustomer> findBycustomerTypeEqual(int customerType)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(customerType) };

		List<ProGateOrgCustomer> list = (List<ProGateOrgCustomer>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_CUSTOMERTYPEEQUAL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateOrgCustomer WHERE ");

				query.append("customer_type = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("modified_date DESC, ");
				query.append("created_date DESC, ");
				query.append("customer_name DESC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(customerType);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateOrgCustomer>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_CUSTOMERTYPEEQUAL,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateOrgCustomer> findBycustomerTypeEqual(int customerType,
		int start, int end) throws SystemException {
		return findBycustomerTypeEqual(customerType, start, end, null);
	}

	public List<ProGateOrgCustomer> findBycustomerTypeEqual(int customerType,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(customerType),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateOrgCustomer> list = (List<ProGateOrgCustomer>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_CUSTOMERTYPEEQUAL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateOrgCustomer WHERE ");

				query.append("customer_type = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("modified_date DESC, ");
					query.append("created_date DESC, ");
					query.append("customer_name DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(customerType);

				list = (List<ProGateOrgCustomer>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateOrgCustomer>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_CUSTOMERTYPEEQUAL,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateOrgCustomer findBycustomerTypeEqual_First(int customerType,
		OrderByComparator obc)
		throws NoSuchProGateOrgCustomerException, SystemException {
		List<ProGateOrgCustomer> list = findBycustomerTypeEqual(customerType,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateOrgCustomer exists with the key {");

			msg.append("customerType=" + customerType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateOrgCustomerException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateOrgCustomer findBycustomerTypeEqual_Last(int customerType,
		OrderByComparator obc)
		throws NoSuchProGateOrgCustomerException, SystemException {
		int count = countBycustomerTypeEqual(customerType);

		List<ProGateOrgCustomer> list = findBycustomerTypeEqual(customerType,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateOrgCustomer exists with the key {");

			msg.append("customerType=" + customerType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateOrgCustomerException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateOrgCustomer[] findBycustomerTypeEqual_PrevAndNext(
		Integer ProGateOrgCustomerId, int customerType, OrderByComparator obc)
		throws NoSuchProGateOrgCustomerException, SystemException {
		ProGateOrgCustomer proGateOrgCustomer = findByPrimaryKey(ProGateOrgCustomerId);

		int count = countBycustomerTypeEqual(customerType);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.ProGateOrgCustomer WHERE ");

			query.append("customer_type = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("modified_date DESC, ");
				query.append("created_date DESC, ");
				query.append("customer_name DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(customerType);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateOrgCustomer);

			ProGateOrgCustomer[] array = new ProGateOrgCustomerImpl[3];

			array[0] = (ProGateOrgCustomer)objArray[0];
			array[1] = (ProGateOrgCustomer)objArray[1];
			array[2] = (ProGateOrgCustomer)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateOrgCustomer> findBycustomerTypeGreater(int customerType)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(customerType) };

		List<ProGateOrgCustomer> list = (List<ProGateOrgCustomer>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_CUSTOMERTYPEGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateOrgCustomer WHERE ");

				query.append("customer_type >= ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("modified_date DESC, ");
				query.append("created_date DESC, ");
				query.append("customer_name DESC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(customerType);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateOrgCustomer>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_CUSTOMERTYPEGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateOrgCustomer> findBycustomerTypeGreater(
		int customerType, int start, int end) throws SystemException {
		return findBycustomerTypeGreater(customerType, start, end, null);
	}

	public List<ProGateOrgCustomer> findBycustomerTypeGreater(
		int customerType, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(customerType),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateOrgCustomer> list = (List<ProGateOrgCustomer>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_CUSTOMERTYPEGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateOrgCustomer WHERE ");

				query.append("customer_type >= ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("modified_date DESC, ");
					query.append("created_date DESC, ");
					query.append("customer_name DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(customerType);

				list = (List<ProGateOrgCustomer>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateOrgCustomer>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_CUSTOMERTYPEGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateOrgCustomer findBycustomerTypeGreater_First(
		int customerType, OrderByComparator obc)
		throws NoSuchProGateOrgCustomerException, SystemException {
		List<ProGateOrgCustomer> list = findBycustomerTypeGreater(customerType,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateOrgCustomer exists with the key {");

			msg.append("customerType=" + customerType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateOrgCustomerException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateOrgCustomer findBycustomerTypeGreater_Last(int customerType,
		OrderByComparator obc)
		throws NoSuchProGateOrgCustomerException, SystemException {
		int count = countBycustomerTypeGreater(customerType);

		List<ProGateOrgCustomer> list = findBycustomerTypeGreater(customerType,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateOrgCustomer exists with the key {");

			msg.append("customerType=" + customerType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateOrgCustomerException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateOrgCustomer[] findBycustomerTypeGreater_PrevAndNext(
		Integer ProGateOrgCustomerId, int customerType, OrderByComparator obc)
		throws NoSuchProGateOrgCustomerException, SystemException {
		ProGateOrgCustomer proGateOrgCustomer = findByPrimaryKey(ProGateOrgCustomerId);

		int count = countBycustomerTypeGreater(customerType);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.ProGateOrgCustomer WHERE ");

			query.append("customer_type >= ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("modified_date DESC, ");
				query.append("created_date DESC, ");
				query.append("customer_name DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(customerType);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateOrgCustomer);

			ProGateOrgCustomer[] array = new ProGateOrgCustomerImpl[3];

			array[0] = (ProGateOrgCustomer)objArray[0];
			array[1] = (ProGateOrgCustomer)objArray[1];
			array[2] = (ProGateOrgCustomer)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateOrgCustomer> findBycustomerTypeLower(int customerType)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(customerType) };

		List<ProGateOrgCustomer> list = (List<ProGateOrgCustomer>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_CUSTOMERTYPELOWER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateOrgCustomer WHERE ");

				query.append("customer_type <= ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("modified_date DESC, ");
				query.append("created_date DESC, ");
				query.append("customer_name DESC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(customerType);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateOrgCustomer>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_CUSTOMERTYPELOWER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateOrgCustomer> findBycustomerTypeLower(int customerType,
		int start, int end) throws SystemException {
		return findBycustomerTypeLower(customerType, start, end, null);
	}

	public List<ProGateOrgCustomer> findBycustomerTypeLower(int customerType,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(customerType),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateOrgCustomer> list = (List<ProGateOrgCustomer>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_CUSTOMERTYPELOWER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateOrgCustomer WHERE ");

				query.append("customer_type <= ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("modified_date DESC, ");
					query.append("created_date DESC, ");
					query.append("customer_name DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(customerType);

				list = (List<ProGateOrgCustomer>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateOrgCustomer>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_CUSTOMERTYPELOWER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateOrgCustomer findBycustomerTypeLower_First(int customerType,
		OrderByComparator obc)
		throws NoSuchProGateOrgCustomerException, SystemException {
		List<ProGateOrgCustomer> list = findBycustomerTypeLower(customerType,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateOrgCustomer exists with the key {");

			msg.append("customerType=" + customerType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateOrgCustomerException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateOrgCustomer findBycustomerTypeLower_Last(int customerType,
		OrderByComparator obc)
		throws NoSuchProGateOrgCustomerException, SystemException {
		int count = countBycustomerTypeLower(customerType);

		List<ProGateOrgCustomer> list = findBycustomerTypeLower(customerType,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateOrgCustomer exists with the key {");

			msg.append("customerType=" + customerType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateOrgCustomerException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateOrgCustomer[] findBycustomerTypeLower_PrevAndNext(
		Integer ProGateOrgCustomerId, int customerType, OrderByComparator obc)
		throws NoSuchProGateOrgCustomerException, SystemException {
		ProGateOrgCustomer proGateOrgCustomer = findByPrimaryKey(ProGateOrgCustomerId);

		int count = countBycustomerTypeLower(customerType);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.ProGateOrgCustomer WHERE ");

			query.append("customer_type <= ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("modified_date DESC, ");
				query.append("created_date DESC, ");
				query.append("customer_name DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(customerType);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateOrgCustomer);

			ProGateOrgCustomer[] array = new ProGateOrgCustomerImpl[3];

			array[0] = (ProGateOrgCustomer)objArray[0];
			array[1] = (ProGateOrgCustomer)objArray[1];
			array[2] = (ProGateOrgCustomer)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateOrgCustomer> findByorgId(int orgId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(orgId) };

		List<ProGateOrgCustomer> list = (List<ProGateOrgCustomer>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ORGID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateOrgCustomer WHERE ");

				query.append("org_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("modified_date DESC, ");
				query.append("created_date DESC, ");
				query.append("customer_name DESC");

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
					list = new ArrayList<ProGateOrgCustomer>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ORGID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateOrgCustomer> findByorgId(int orgId, int start, int end)
		throws SystemException {
		return findByorgId(orgId, start, end, null);
	}

	public List<ProGateOrgCustomer> findByorgId(int orgId, int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(orgId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateOrgCustomer> list = (List<ProGateOrgCustomer>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ORGID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateOrgCustomer WHERE ");

				query.append("org_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("modified_date DESC, ");
					query.append("created_date DESC, ");
					query.append("customer_name DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orgId);

				list = (List<ProGateOrgCustomer>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateOrgCustomer>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ORGID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateOrgCustomer findByorgId_First(int orgId, OrderByComparator obc)
		throws NoSuchProGateOrgCustomerException, SystemException {
		List<ProGateOrgCustomer> list = findByorgId(orgId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateOrgCustomer exists with the key {");

			msg.append("orgId=" + orgId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateOrgCustomerException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateOrgCustomer findByorgId_Last(int orgId, OrderByComparator obc)
		throws NoSuchProGateOrgCustomerException, SystemException {
		int count = countByorgId(orgId);

		List<ProGateOrgCustomer> list = findByorgId(orgId, count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateOrgCustomer exists with the key {");

			msg.append("orgId=" + orgId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateOrgCustomerException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateOrgCustomer[] findByorgId_PrevAndNext(
		Integer ProGateOrgCustomerId, int orgId, OrderByComparator obc)
		throws NoSuchProGateOrgCustomerException, SystemException {
		ProGateOrgCustomer proGateOrgCustomer = findByPrimaryKey(ProGateOrgCustomerId);

		int count = countByorgId(orgId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.ProGateOrgCustomer WHERE ");

			query.append("org_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("modified_date DESC, ");
				query.append("created_date DESC, ");
				query.append("customer_name DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(orgId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateOrgCustomer);

			ProGateOrgCustomer[] array = new ProGateOrgCustomerImpl[3];

			array[0] = (ProGateOrgCustomer)objArray[0];
			array[1] = (ProGateOrgCustomer)objArray[1];
			array[2] = (ProGateOrgCustomer)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateOrgCustomer> findBycreatedDateEqual(Date createdDate)
		throws SystemException {
		Object[] finderArgs = new Object[] { createdDate };

		List<ProGateOrgCustomer> list = (List<ProGateOrgCustomer>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_CREATEDDATEEQUAL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateOrgCustomer WHERE ");

				if (createdDate == null) {
					query.append("created_date IS NULL");
				}
				else {
					query.append("created_date = ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("modified_date DESC, ");
				query.append("created_date DESC, ");
				query.append("customer_name DESC");

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
					list = new ArrayList<ProGateOrgCustomer>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_CREATEDDATEEQUAL,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateOrgCustomer> findBycreatedDateEqual(Date createdDate,
		int start, int end) throws SystemException {
		return findBycreatedDateEqual(createdDate, start, end, null);
	}

	public List<ProGateOrgCustomer> findBycreatedDateEqual(Date createdDate,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				createdDate,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateOrgCustomer> list = (List<ProGateOrgCustomer>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_CREATEDDATEEQUAL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateOrgCustomer WHERE ");

				if (createdDate == null) {
					query.append("created_date IS NULL");
				}
				else {
					query.append("created_date = ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("modified_date DESC, ");
					query.append("created_date DESC, ");
					query.append("customer_name DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (createdDate != null) {
					qPos.add(CalendarUtil.getTimestamp(createdDate));
				}

				list = (List<ProGateOrgCustomer>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateOrgCustomer>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_CREATEDDATEEQUAL,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateOrgCustomer findBycreatedDateEqual_First(Date createdDate,
		OrderByComparator obc)
		throws NoSuchProGateOrgCustomerException, SystemException {
		List<ProGateOrgCustomer> list = findBycreatedDateEqual(createdDate, 0,
				1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateOrgCustomer exists with the key {");

			msg.append("createdDate=" + createdDate);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateOrgCustomerException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateOrgCustomer findBycreatedDateEqual_Last(Date createdDate,
		OrderByComparator obc)
		throws NoSuchProGateOrgCustomerException, SystemException {
		int count = countBycreatedDateEqual(createdDate);

		List<ProGateOrgCustomer> list = findBycreatedDateEqual(createdDate,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateOrgCustomer exists with the key {");

			msg.append("createdDate=" + createdDate);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateOrgCustomerException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateOrgCustomer[] findBycreatedDateEqual_PrevAndNext(
		Integer ProGateOrgCustomerId, Date createdDate, OrderByComparator obc)
		throws NoSuchProGateOrgCustomerException, SystemException {
		ProGateOrgCustomer proGateOrgCustomer = findByPrimaryKey(ProGateOrgCustomerId);

		int count = countBycreatedDateEqual(createdDate);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.ProGateOrgCustomer WHERE ");

			if (createdDate == null) {
				query.append("created_date IS NULL");
			}
			else {
				query.append("created_date = ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("modified_date DESC, ");
				query.append("created_date DESC, ");
				query.append("customer_name DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (createdDate != null) {
				qPos.add(CalendarUtil.getTimestamp(createdDate));
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateOrgCustomer);

			ProGateOrgCustomer[] array = new ProGateOrgCustomerImpl[3];

			array[0] = (ProGateOrgCustomer)objArray[0];
			array[1] = (ProGateOrgCustomer)objArray[1];
			array[2] = (ProGateOrgCustomer)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateOrgCustomer> findBycreatedDateGreater(Date createdDate)
		throws SystemException {
		Object[] finderArgs = new Object[] { createdDate };

		List<ProGateOrgCustomer> list = (List<ProGateOrgCustomer>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_CREATEDDATEGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateOrgCustomer WHERE ");

				if (createdDate == null) {
					query.append("created_date >= null");
				}
				else {
					query.append("created_date >= ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("modified_date DESC, ");
				query.append("created_date DESC, ");
				query.append("customer_name DESC");

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
					list = new ArrayList<ProGateOrgCustomer>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_CREATEDDATEGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateOrgCustomer> findBycreatedDateGreater(Date createdDate,
		int start, int end) throws SystemException {
		return findBycreatedDateGreater(createdDate, start, end, null);
	}

	public List<ProGateOrgCustomer> findBycreatedDateGreater(Date createdDate,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				createdDate,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateOrgCustomer> list = (List<ProGateOrgCustomer>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_CREATEDDATEGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateOrgCustomer WHERE ");

				if (createdDate == null) {
					query.append("created_date >= null");
				}
				else {
					query.append("created_date >= ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("modified_date DESC, ");
					query.append("created_date DESC, ");
					query.append("customer_name DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (createdDate != null) {
					qPos.add(CalendarUtil.getTimestamp(createdDate));
				}

				list = (List<ProGateOrgCustomer>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateOrgCustomer>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_CREATEDDATEGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateOrgCustomer findBycreatedDateGreater_First(Date createdDate,
		OrderByComparator obc)
		throws NoSuchProGateOrgCustomerException, SystemException {
		List<ProGateOrgCustomer> list = findBycreatedDateGreater(createdDate,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateOrgCustomer exists with the key {");

			msg.append("createdDate=" + createdDate);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateOrgCustomerException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateOrgCustomer findBycreatedDateGreater_Last(Date createdDate,
		OrderByComparator obc)
		throws NoSuchProGateOrgCustomerException, SystemException {
		int count = countBycreatedDateGreater(createdDate);

		List<ProGateOrgCustomer> list = findBycreatedDateGreater(createdDate,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateOrgCustomer exists with the key {");

			msg.append("createdDate=" + createdDate);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateOrgCustomerException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateOrgCustomer[] findBycreatedDateGreater_PrevAndNext(
		Integer ProGateOrgCustomerId, Date createdDate, OrderByComparator obc)
		throws NoSuchProGateOrgCustomerException, SystemException {
		ProGateOrgCustomer proGateOrgCustomer = findByPrimaryKey(ProGateOrgCustomerId);

		int count = countBycreatedDateGreater(createdDate);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.ProGateOrgCustomer WHERE ");

			if (createdDate == null) {
				query.append("created_date >= null");
			}
			else {
				query.append("created_date >= ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("modified_date DESC, ");
				query.append("created_date DESC, ");
				query.append("customer_name DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (createdDate != null) {
				qPos.add(CalendarUtil.getTimestamp(createdDate));
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateOrgCustomer);

			ProGateOrgCustomer[] array = new ProGateOrgCustomerImpl[3];

			array[0] = (ProGateOrgCustomer)objArray[0];
			array[1] = (ProGateOrgCustomer)objArray[1];
			array[2] = (ProGateOrgCustomer)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateOrgCustomer> findBycreatedDateLower(Date createdDate)
		throws SystemException {
		Object[] finderArgs = new Object[] { createdDate };

		List<ProGateOrgCustomer> list = (List<ProGateOrgCustomer>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_CREATEDDATELOWER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateOrgCustomer WHERE ");

				if (createdDate == null) {
					query.append("created_date <= null");
				}
				else {
					query.append("created_date <= ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("modified_date DESC, ");
				query.append("created_date DESC, ");
				query.append("customer_name DESC");

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
					list = new ArrayList<ProGateOrgCustomer>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_CREATEDDATELOWER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateOrgCustomer> findBycreatedDateLower(Date createdDate,
		int start, int end) throws SystemException {
		return findBycreatedDateLower(createdDate, start, end, null);
	}

	public List<ProGateOrgCustomer> findBycreatedDateLower(Date createdDate,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				createdDate,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateOrgCustomer> list = (List<ProGateOrgCustomer>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_CREATEDDATELOWER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateOrgCustomer WHERE ");

				if (createdDate == null) {
					query.append("created_date <= null");
				}
				else {
					query.append("created_date <= ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("modified_date DESC, ");
					query.append("created_date DESC, ");
					query.append("customer_name DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (createdDate != null) {
					qPos.add(CalendarUtil.getTimestamp(createdDate));
				}

				list = (List<ProGateOrgCustomer>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateOrgCustomer>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_CREATEDDATELOWER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateOrgCustomer findBycreatedDateLower_First(Date createdDate,
		OrderByComparator obc)
		throws NoSuchProGateOrgCustomerException, SystemException {
		List<ProGateOrgCustomer> list = findBycreatedDateLower(createdDate, 0,
				1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateOrgCustomer exists with the key {");

			msg.append("createdDate=" + createdDate);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateOrgCustomerException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateOrgCustomer findBycreatedDateLower_Last(Date createdDate,
		OrderByComparator obc)
		throws NoSuchProGateOrgCustomerException, SystemException {
		int count = countBycreatedDateLower(createdDate);

		List<ProGateOrgCustomer> list = findBycreatedDateLower(createdDate,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateOrgCustomer exists with the key {");

			msg.append("createdDate=" + createdDate);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateOrgCustomerException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateOrgCustomer[] findBycreatedDateLower_PrevAndNext(
		Integer ProGateOrgCustomerId, Date createdDate, OrderByComparator obc)
		throws NoSuchProGateOrgCustomerException, SystemException {
		ProGateOrgCustomer proGateOrgCustomer = findByPrimaryKey(ProGateOrgCustomerId);

		int count = countBycreatedDateLower(createdDate);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.ProGateOrgCustomer WHERE ");

			if (createdDate == null) {
				query.append("created_date <= null");
			}
			else {
				query.append("created_date <= ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("modified_date DESC, ");
				query.append("created_date DESC, ");
				query.append("customer_name DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (createdDate != null) {
				qPos.add(CalendarUtil.getTimestamp(createdDate));
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateOrgCustomer);

			ProGateOrgCustomer[] array = new ProGateOrgCustomerImpl[3];

			array[0] = (ProGateOrgCustomer)objArray[0];
			array[1] = (ProGateOrgCustomer)objArray[1];
			array[2] = (ProGateOrgCustomer)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateOrgCustomer> findBymodifiedDateEqual(Date modifiedDate)
		throws SystemException {
		Object[] finderArgs = new Object[] { modifiedDate };

		List<ProGateOrgCustomer> list = (List<ProGateOrgCustomer>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_MODIFIEDDATEEQUAL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateOrgCustomer WHERE ");

				if (modifiedDate == null) {
					query.append("modified_date IS NULL");
				}
				else {
					query.append("modified_date = ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("modified_date DESC, ");
				query.append("created_date DESC, ");
				query.append("customer_name DESC");

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
					list = new ArrayList<ProGateOrgCustomer>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_MODIFIEDDATEEQUAL,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateOrgCustomer> findBymodifiedDateEqual(Date modifiedDate,
		int start, int end) throws SystemException {
		return findBymodifiedDateEqual(modifiedDate, start, end, null);
	}

	public List<ProGateOrgCustomer> findBymodifiedDateEqual(Date modifiedDate,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				modifiedDate,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateOrgCustomer> list = (List<ProGateOrgCustomer>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_MODIFIEDDATEEQUAL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateOrgCustomer WHERE ");

				if (modifiedDate == null) {
					query.append("modified_date IS NULL");
				}
				else {
					query.append("modified_date = ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("modified_date DESC, ");
					query.append("created_date DESC, ");
					query.append("customer_name DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (modifiedDate != null) {
					qPos.add(CalendarUtil.getTimestamp(modifiedDate));
				}

				list = (List<ProGateOrgCustomer>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateOrgCustomer>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_MODIFIEDDATEEQUAL,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateOrgCustomer findBymodifiedDateEqual_First(Date modifiedDate,
		OrderByComparator obc)
		throws NoSuchProGateOrgCustomerException, SystemException {
		List<ProGateOrgCustomer> list = findBymodifiedDateEqual(modifiedDate,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateOrgCustomer exists with the key {");

			msg.append("modifiedDate=" + modifiedDate);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateOrgCustomerException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateOrgCustomer findBymodifiedDateEqual_Last(Date modifiedDate,
		OrderByComparator obc)
		throws NoSuchProGateOrgCustomerException, SystemException {
		int count = countBymodifiedDateEqual(modifiedDate);

		List<ProGateOrgCustomer> list = findBymodifiedDateEqual(modifiedDate,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateOrgCustomer exists with the key {");

			msg.append("modifiedDate=" + modifiedDate);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateOrgCustomerException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateOrgCustomer[] findBymodifiedDateEqual_PrevAndNext(
		Integer ProGateOrgCustomerId, Date modifiedDate, OrderByComparator obc)
		throws NoSuchProGateOrgCustomerException, SystemException {
		ProGateOrgCustomer proGateOrgCustomer = findByPrimaryKey(ProGateOrgCustomerId);

		int count = countBymodifiedDateEqual(modifiedDate);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.ProGateOrgCustomer WHERE ");

			if (modifiedDate == null) {
				query.append("modified_date IS NULL");
			}
			else {
				query.append("modified_date = ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("modified_date DESC, ");
				query.append("created_date DESC, ");
				query.append("customer_name DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (modifiedDate != null) {
				qPos.add(CalendarUtil.getTimestamp(modifiedDate));
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateOrgCustomer);

			ProGateOrgCustomer[] array = new ProGateOrgCustomerImpl[3];

			array[0] = (ProGateOrgCustomer)objArray[0];
			array[1] = (ProGateOrgCustomer)objArray[1];
			array[2] = (ProGateOrgCustomer)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateOrgCustomer> findBymodifiedDateGreater(Date modifiedDate)
		throws SystemException {
		Object[] finderArgs = new Object[] { modifiedDate };

		List<ProGateOrgCustomer> list = (List<ProGateOrgCustomer>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_MODIFIEDDATEGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateOrgCustomer WHERE ");

				if (modifiedDate == null) {
					query.append("modified_date >= null");
				}
				else {
					query.append("modified_date >= ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("modified_date DESC, ");
				query.append("created_date DESC, ");
				query.append("customer_name DESC");

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
					list = new ArrayList<ProGateOrgCustomer>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_MODIFIEDDATEGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateOrgCustomer> findBymodifiedDateGreater(
		Date modifiedDate, int start, int end) throws SystemException {
		return findBymodifiedDateGreater(modifiedDate, start, end, null);
	}

	public List<ProGateOrgCustomer> findBymodifiedDateGreater(
		Date modifiedDate, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				modifiedDate,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateOrgCustomer> list = (List<ProGateOrgCustomer>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_MODIFIEDDATEGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateOrgCustomer WHERE ");

				if (modifiedDate == null) {
					query.append("modified_date >= null");
				}
				else {
					query.append("modified_date >= ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("modified_date DESC, ");
					query.append("created_date DESC, ");
					query.append("customer_name DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (modifiedDate != null) {
					qPos.add(CalendarUtil.getTimestamp(modifiedDate));
				}

				list = (List<ProGateOrgCustomer>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateOrgCustomer>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_MODIFIEDDATEGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateOrgCustomer findBymodifiedDateGreater_First(
		Date modifiedDate, OrderByComparator obc)
		throws NoSuchProGateOrgCustomerException, SystemException {
		List<ProGateOrgCustomer> list = findBymodifiedDateGreater(modifiedDate,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateOrgCustomer exists with the key {");

			msg.append("modifiedDate=" + modifiedDate);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateOrgCustomerException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateOrgCustomer findBymodifiedDateGreater_Last(
		Date modifiedDate, OrderByComparator obc)
		throws NoSuchProGateOrgCustomerException, SystemException {
		int count = countBymodifiedDateGreater(modifiedDate);

		List<ProGateOrgCustomer> list = findBymodifiedDateGreater(modifiedDate,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateOrgCustomer exists with the key {");

			msg.append("modifiedDate=" + modifiedDate);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateOrgCustomerException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateOrgCustomer[] findBymodifiedDateGreater_PrevAndNext(
		Integer ProGateOrgCustomerId, Date modifiedDate, OrderByComparator obc)
		throws NoSuchProGateOrgCustomerException, SystemException {
		ProGateOrgCustomer proGateOrgCustomer = findByPrimaryKey(ProGateOrgCustomerId);

		int count = countBymodifiedDateGreater(modifiedDate);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.ProGateOrgCustomer WHERE ");

			if (modifiedDate == null) {
				query.append("modified_date >= null");
			}
			else {
				query.append("modified_date >= ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("modified_date DESC, ");
				query.append("created_date DESC, ");
				query.append("customer_name DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (modifiedDate != null) {
				qPos.add(CalendarUtil.getTimestamp(modifiedDate));
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateOrgCustomer);

			ProGateOrgCustomer[] array = new ProGateOrgCustomerImpl[3];

			array[0] = (ProGateOrgCustomer)objArray[0];
			array[1] = (ProGateOrgCustomer)objArray[1];
			array[2] = (ProGateOrgCustomer)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateOrgCustomer> findBymodifiedDateLower(Date modifiedDate)
		throws SystemException {
		Object[] finderArgs = new Object[] { modifiedDate };

		List<ProGateOrgCustomer> list = (List<ProGateOrgCustomer>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_MODIFIEDDATELOWER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateOrgCustomer WHERE ");

				if (modifiedDate == null) {
					query.append("modified_date <= null");
				}
				else {
					query.append("modified_date <= ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("modified_date DESC, ");
				query.append("created_date DESC, ");
				query.append("customer_name DESC");

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
					list = new ArrayList<ProGateOrgCustomer>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_MODIFIEDDATELOWER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateOrgCustomer> findBymodifiedDateLower(Date modifiedDate,
		int start, int end) throws SystemException {
		return findBymodifiedDateLower(modifiedDate, start, end, null);
	}

	public List<ProGateOrgCustomer> findBymodifiedDateLower(Date modifiedDate,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				modifiedDate,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateOrgCustomer> list = (List<ProGateOrgCustomer>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_MODIFIEDDATELOWER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateOrgCustomer WHERE ");

				if (modifiedDate == null) {
					query.append("modified_date <= null");
				}
				else {
					query.append("modified_date <= ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("modified_date DESC, ");
					query.append("created_date DESC, ");
					query.append("customer_name DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (modifiedDate != null) {
					qPos.add(CalendarUtil.getTimestamp(modifiedDate));
				}

				list = (List<ProGateOrgCustomer>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateOrgCustomer>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_MODIFIEDDATELOWER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateOrgCustomer findBymodifiedDateLower_First(Date modifiedDate,
		OrderByComparator obc)
		throws NoSuchProGateOrgCustomerException, SystemException {
		List<ProGateOrgCustomer> list = findBymodifiedDateLower(modifiedDate,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateOrgCustomer exists with the key {");

			msg.append("modifiedDate=" + modifiedDate);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateOrgCustomerException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateOrgCustomer findBymodifiedDateLower_Last(Date modifiedDate,
		OrderByComparator obc)
		throws NoSuchProGateOrgCustomerException, SystemException {
		int count = countBymodifiedDateLower(modifiedDate);

		List<ProGateOrgCustomer> list = findBymodifiedDateLower(modifiedDate,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateOrgCustomer exists with the key {");

			msg.append("modifiedDate=" + modifiedDate);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateOrgCustomerException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateOrgCustomer[] findBymodifiedDateLower_PrevAndNext(
		Integer ProGateOrgCustomerId, Date modifiedDate, OrderByComparator obc)
		throws NoSuchProGateOrgCustomerException, SystemException {
		ProGateOrgCustomer proGateOrgCustomer = findByPrimaryKey(ProGateOrgCustomerId);

		int count = countBymodifiedDateLower(modifiedDate);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.model.ProGateOrgCustomer WHERE ");

			if (modifiedDate == null) {
				query.append("modified_date <= null");
			}
			else {
				query.append("modified_date <= ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("modified_date DESC, ");
				query.append("created_date DESC, ");
				query.append("customer_name DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (modifiedDate != null) {
				qPos.add(CalendarUtil.getTimestamp(modifiedDate));
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateOrgCustomer);

			ProGateOrgCustomer[] array = new ProGateOrgCustomerImpl[3];

			array[0] = (ProGateOrgCustomer)objArray[0];
			array[1] = (ProGateOrgCustomer)objArray[1];
			array[2] = (ProGateOrgCustomer)objArray[2];

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

	public List<ProGateOrgCustomer> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<ProGateOrgCustomer> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<ProGateOrgCustomer> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateOrgCustomer> list = (List<ProGateOrgCustomer>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.ProGateOrgCustomer ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("modified_date DESC, ");
					query.append("created_date DESC, ");
					query.append("customer_name DESC");
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<ProGateOrgCustomer>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ProGateOrgCustomer>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateOrgCustomer>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeBycustomerName(String customerName)
		throws SystemException {
		for (ProGateOrgCustomer proGateOrgCustomer : findBycustomerName(
				customerName)) {
			remove(proGateOrgCustomer);
		}
	}

	public void removeBycustomerTypeEqual(int customerType)
		throws SystemException {
		for (ProGateOrgCustomer proGateOrgCustomer : findBycustomerTypeEqual(
				customerType)) {
			remove(proGateOrgCustomer);
		}
	}

	public void removeBycustomerTypeGreater(int customerType)
		throws SystemException {
		for (ProGateOrgCustomer proGateOrgCustomer : findBycustomerTypeGreater(
				customerType)) {
			remove(proGateOrgCustomer);
		}
	}

	public void removeBycustomerTypeLower(int customerType)
		throws SystemException {
		for (ProGateOrgCustomer proGateOrgCustomer : findBycustomerTypeLower(
				customerType)) {
			remove(proGateOrgCustomer);
		}
	}

	public void removeByorgId(int orgId) throws SystemException {
		for (ProGateOrgCustomer proGateOrgCustomer : findByorgId(orgId)) {
			remove(proGateOrgCustomer);
		}
	}

	public void removeBycreatedDateEqual(Date createdDate)
		throws SystemException {
		for (ProGateOrgCustomer proGateOrgCustomer : findBycreatedDateEqual(
				createdDate)) {
			remove(proGateOrgCustomer);
		}
	}

	public void removeBycreatedDateGreater(Date createdDate)
		throws SystemException {
		for (ProGateOrgCustomer proGateOrgCustomer : findBycreatedDateGreater(
				createdDate)) {
			remove(proGateOrgCustomer);
		}
	}

	public void removeBycreatedDateLower(Date createdDate)
		throws SystemException {
		for (ProGateOrgCustomer proGateOrgCustomer : findBycreatedDateLower(
				createdDate)) {
			remove(proGateOrgCustomer);
		}
	}

	public void removeBymodifiedDateEqual(Date modifiedDate)
		throws SystemException {
		for (ProGateOrgCustomer proGateOrgCustomer : findBymodifiedDateEqual(
				modifiedDate)) {
			remove(proGateOrgCustomer);
		}
	}

	public void removeBymodifiedDateGreater(Date modifiedDate)
		throws SystemException {
		for (ProGateOrgCustomer proGateOrgCustomer : findBymodifiedDateGreater(
				modifiedDate)) {
			remove(proGateOrgCustomer);
		}
	}

	public void removeBymodifiedDateLower(Date modifiedDate)
		throws SystemException {
		for (ProGateOrgCustomer proGateOrgCustomer : findBymodifiedDateLower(
				modifiedDate)) {
			remove(proGateOrgCustomer);
		}
	}

	public void removeAll() throws SystemException {
		for (ProGateOrgCustomer proGateOrgCustomer : findAll()) {
			remove(proGateOrgCustomer);
		}
	}

	public int countBycustomerName(String customerName)
		throws SystemException {
		Object[] finderArgs = new Object[] { customerName };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CUSTOMERNAME,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateOrgCustomer WHERE ");

				if (customerName == null) {
					query.append("customer_name IS NULL");
				}
				else {
					query.append("customer_name = ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (customerName != null) {
					qPos.add(customerName);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CUSTOMERNAME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countBycustomerTypeEqual(int customerType)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(customerType) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CUSTOMERTYPEEQUAL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateOrgCustomer WHERE ");

				query.append("customer_type = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(customerType);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CUSTOMERTYPEEQUAL,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countBycustomerTypeGreater(int customerType)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(customerType) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CUSTOMERTYPEGREATER,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateOrgCustomer WHERE ");

				query.append("customer_type >= ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(customerType);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CUSTOMERTYPEGREATER,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countBycustomerTypeLower(int customerType)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(customerType) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CUSTOMERTYPELOWER,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateOrgCustomer WHERE ");

				query.append("customer_type <= ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(customerType);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CUSTOMERTYPELOWER,
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
					"FROM larion.progate.model.ProGateOrgCustomer WHERE ");

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
					"FROM larion.progate.model.ProGateOrgCustomer WHERE ");

				if (createdDate == null) {
					query.append("created_date IS NULL");
				}
				else {
					query.append("created_date = ?");
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
					"FROM larion.progate.model.ProGateOrgCustomer WHERE ");

				if (createdDate == null) {
					query.append("created_date >= null");
				}
				else {
					query.append("created_date >= ?");
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
					"FROM larion.progate.model.ProGateOrgCustomer WHERE ");

				if (createdDate == null) {
					query.append("created_date <= null");
				}
				else {
					query.append("created_date <= ?");
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
					"FROM larion.progate.model.ProGateOrgCustomer WHERE ");

				if (modifiedDate == null) {
					query.append("modified_date IS NULL");
				}
				else {
					query.append("modified_date = ?");
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
					"FROM larion.progate.model.ProGateOrgCustomer WHERE ");

				if (modifiedDate == null) {
					query.append("modified_date >= null");
				}
				else {
					query.append("modified_date >= ?");
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
					"FROM larion.progate.model.ProGateOrgCustomer WHERE ");

				if (modifiedDate == null) {
					query.append("modified_date <= null");
				}
				else {
					query.append("modified_date <= ?");
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
						"SELECT COUNT(*) FROM larion.progate.model.ProGateOrgCustomer");

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

	public List<larion.progate.model.ProGateOrgCustomerRepresenter> getProGateOrgCustomerRepresenters(
		Integer pk) throws SystemException {
		return getProGateOrgCustomerRepresenters(pk, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS);
	}

	public List<larion.progate.model.ProGateOrgCustomerRepresenter> getProGateOrgCustomerRepresenters(
		Integer pk, int start, int end) throws SystemException {
		return getProGateOrgCustomerRepresenters(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_PROGATEORGCUSTOMERREPRESENTERS =
		new FinderPath(larion.progate.model.impl.ProGateOrgCustomerRepresenterModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.model.impl.ProGateOrgCustomerRepresenterModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.service.persistence.ProGateOrgCustomerRepresenterPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getProGateOrgCustomerRepresenters",
			new String[] {
				Integer.class.getName(), "java.lang.Integer",
				"java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	public List<larion.progate.model.ProGateOrgCustomerRepresenter> getProGateOrgCustomerRepresenters(
		Integer pk, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				pk, String.valueOf(start), String.valueOf(end),
				String.valueOf(obc)
			};

		List<larion.progate.model.ProGateOrgCustomerRepresenter> list = (List<larion.progate.model.ProGateOrgCustomerRepresenter>)FinderCacheUtil.getResult(FINDER_PATH_GET_PROGATEORGCUSTOMERREPRESENTERS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder sb = new StringBuilder();

				sb.append(_SQL_GETPROGATEORGCUSTOMERREPRESENTERS);

				if (obc != null) {
					sb.append("ORDER BY ");
					sb.append(obc.getOrderBy());
				}

				else {
					sb.append("ORDER BY ");

					sb.append(
						"progate_org_customer_representer.modified_date DESC, ");
					sb.append(
						"progate_org_customer_representer.created_date DESC, ");
					sb.append(
						"progate_org_customer_representer.display_name ASC");
				}

				String sql = sb.toString();

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("progate_org_customer_representer",
					larion.progate.model.impl.ProGateOrgCustomerRepresenterImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<larion.progate.model.ProGateOrgCustomerRepresenter>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<larion.progate.model.ProGateOrgCustomerRepresenter>();
				}

				proGateOrgCustomerRepresenterPersistence.cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_GET_PROGATEORGCUSTOMERREPRESENTERS,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_PROGATEORGCUSTOMERREPRESENTERS_SIZE =
		new FinderPath(larion.progate.model.impl.ProGateOrgCustomerRepresenterModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.model.impl.ProGateOrgCustomerRepresenterModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.service.persistence.ProGateOrgCustomerRepresenterPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getProGateOrgCustomerRepresentersSize",
			new String[] { Integer.class.getName() });

	public int getProGateOrgCustomerRepresentersSize(Integer pk)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_PROGATEORGCUSTOMERREPRESENTERS_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETPROGATEORGCUSTOMERREPRESENTERSSIZE);

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

				FinderCacheUtil.putResult(FINDER_PATH_GET_PROGATEORGCUSTOMERREPRESENTERS_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_PROGATEORGCUSTOMERREPRESENTER =
		new FinderPath(larion.progate.model.impl.ProGateOrgCustomerRepresenterModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.model.impl.ProGateOrgCustomerRepresenterModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.service.persistence.ProGateOrgCustomerRepresenterPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"containsProGateOrgCustomerRepresenter",
			new String[] { Integer.class.getName(), Integer.class.getName() });

	public boolean containsProGateOrgCustomerRepresenter(Integer pk,
		Integer proGateOrgCustomerRepresenterPK) throws SystemException {
		Object[] finderArgs = new Object[] { pk, proGateOrgCustomerRepresenterPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_PROGATEORGCUSTOMERREPRESENTER,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsProGateOrgCustomerRepresenter.contains(
							pk, proGateOrgCustomerRepresenterPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_PROGATEORGCUSTOMERREPRESENTER,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	public boolean containsProGateOrgCustomerRepresenters(Integer pk)
		throws SystemException {
		if (getProGateOrgCustomerRepresentersSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.larion.progate.model.ProGateOrgCustomer")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ProGateOrgCustomer>> listenersList = new ArrayList<ModelListener<ProGateOrgCustomer>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ProGateOrgCustomer>)Class.forName(
							listenerClassName).newInstance());
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		containsProGateOrgCustomerRepresenter = new ContainsProGateOrgCustomerRepresenter(this);
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
	protected ContainsProGateOrgCustomerRepresenter containsProGateOrgCustomerRepresenter;

	protected class ContainsProGateOrgCustomerRepresenter {
		protected ContainsProGateOrgCustomerRepresenter(
			ProGateOrgCustomerPersistenceImpl persistenceImpl) {
			super();

			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSPROGATEORGCUSTOMERREPRESENTER,
					new int[] { Types.INTEGER, Types.INTEGER }, RowMapper.COUNT);
		}

		protected boolean contains(Integer ProGateOrgCustomerId,
			Integer ProGateOrgCustomerRepresenterId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						ProGateOrgCustomerId, ProGateOrgCustomerRepresenterId
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

	private static final String _SQL_GETPROGATEORGCUSTOMERREPRESENTERS = "SELECT {progate_org_customer_representer.*} FROM progate_org_customer_representer INNER JOIN progate_org_customer ON (progate_org_customer.ProGateOrgCustomerId = progate_org_customer_representer.ProGateOrgCustomerId) WHERE (progate_org_customer.ProGateOrgCustomerId = ?)";
	private static final String _SQL_GETPROGATEORGCUSTOMERREPRESENTERSSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM progate_org_customer_representer WHERE ProGateOrgCustomerId = ?";
	private static final String _SQL_CONTAINSPROGATEORGCUSTOMERREPRESENTER = "SELECT COUNT(*) AS COUNT_VALUE FROM progate_org_customer_representer WHERE ProGateOrgCustomerId = ? AND ProGateOrgCustomerRepresenterId = ?";
	private static Log _log = LogFactoryUtil.getLog(ProGateOrgCustomerPersistenceImpl.class);
}