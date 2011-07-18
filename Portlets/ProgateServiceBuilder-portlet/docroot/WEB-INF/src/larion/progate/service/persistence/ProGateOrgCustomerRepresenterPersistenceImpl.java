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

import larion.progate.NoSuchProGateOrgCustomerRepresenterException;

import larion.progate.model.ProGateOrgCustomerRepresenter;
import larion.progate.model.impl.ProGateOrgCustomerRepresenterImpl;
import larion.progate.model.impl.ProGateOrgCustomerRepresenterModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * <a href="ProGateOrgCustomerRepresenterPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateOrgCustomerRepresenterPersistenceImpl
	extends BasePersistenceImpl
	implements ProGateOrgCustomerRepresenterPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = ProGateOrgCustomerRepresenterImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_ROLE = new FinderPath(ProGateOrgCustomerRepresenterModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerRepresenterModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByrole",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ROLE = new FinderPath(ProGateOrgCustomerRepresenterModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerRepresenterModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByrole",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ROLE = new FinderPath(ProGateOrgCustomerRepresenterModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerRepresenterModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByrole",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_CUSTOMERID = new FinderPath(ProGateOrgCustomerRepresenterModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerRepresenterModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycustomerId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_CUSTOMERID = new FinderPath(ProGateOrgCustomerRepresenterModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerRepresenterModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycustomerId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_CUSTOMERID = new FinderPath(ProGateOrgCustomerRepresenterModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerRepresenterModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBycustomerId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ORGID = new FinderPath(ProGateOrgCustomerRepresenterModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerRepresenterModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByorgId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ORGID = new FinderPath(ProGateOrgCustomerRepresenterModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerRepresenterModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByorgId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGID = new FinderPath(ProGateOrgCustomerRepresenterModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerRepresenterModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByorgId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_DESCRIPTION = new FinderPath(ProGateOrgCustomerRepresenterModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerRepresenterModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBydescription",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_DESCRIPTION = new FinderPath(ProGateOrgCustomerRepresenterModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerRepresenterModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBydescription",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_DESCRIPTION = new FinderPath(ProGateOrgCustomerRepresenterModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerRepresenterModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBydescription",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_CREATEDDATEEQUAL = new FinderPath(ProGateOrgCustomerRepresenterModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerRepresenterModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycreatedDateEqual",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_CREATEDDATEEQUAL = new FinderPath(ProGateOrgCustomerRepresenterModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerRepresenterModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycreatedDateEqual",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_CREATEDDATEEQUAL = new FinderPath(ProGateOrgCustomerRepresenterModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerRepresenterModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBycreatedDateEqual",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_CREATEDDATEGREATER = new FinderPath(ProGateOrgCustomerRepresenterModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerRepresenterModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycreatedDateGreater",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_CREATEDDATEGREATER = new FinderPath(ProGateOrgCustomerRepresenterModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerRepresenterModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycreatedDateGreater",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_CREATEDDATEGREATER = new FinderPath(ProGateOrgCustomerRepresenterModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerRepresenterModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBycreatedDateGreater",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_CREATEDDATELOWER = new FinderPath(ProGateOrgCustomerRepresenterModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerRepresenterModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycreatedDateLower",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_CREATEDDATELOWER = new FinderPath(ProGateOrgCustomerRepresenterModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerRepresenterModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycreatedDateLower",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_CREATEDDATELOWER = new FinderPath(ProGateOrgCustomerRepresenterModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerRepresenterModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBycreatedDateLower",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_MODIFIEDDATEEQUAL = new FinderPath(ProGateOrgCustomerRepresenterModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerRepresenterModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBymodifiedDateEqual",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_MODIFIEDDATEEQUAL = new FinderPath(ProGateOrgCustomerRepresenterModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerRepresenterModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBymodifiedDateEqual",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_MODIFIEDDATEEQUAL = new FinderPath(ProGateOrgCustomerRepresenterModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerRepresenterModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBymodifiedDateEqual",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_MODIFIEDDATEGREATER = new FinderPath(ProGateOrgCustomerRepresenterModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerRepresenterModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBymodifiedDateGreater",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_MODIFIEDDATEGREATER = new FinderPath(ProGateOrgCustomerRepresenterModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerRepresenterModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBymodifiedDateGreater",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_MODIFIEDDATEGREATER = new FinderPath(ProGateOrgCustomerRepresenterModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerRepresenterModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBymodifiedDateGreater",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_MODIFIEDDATELOWER = new FinderPath(ProGateOrgCustomerRepresenterModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerRepresenterModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBymodifiedDateLower",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_MODIFIEDDATELOWER = new FinderPath(ProGateOrgCustomerRepresenterModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerRepresenterModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBymodifiedDateLower",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_MODIFIEDDATELOWER = new FinderPath(ProGateOrgCustomerRepresenterModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerRepresenterModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBymodifiedDateLower",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(ProGateOrgCustomerRepresenterModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerRepresenterModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProGateOrgCustomerRepresenterModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerRepresenterModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(
		ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter) {
		EntityCacheUtil.putResult(ProGateOrgCustomerRepresenterModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerRepresenterImpl.class,
			proGateOrgCustomerRepresenter.getPrimaryKey(),
			proGateOrgCustomerRepresenter);
	}

	public void cacheResult(
		List<ProGateOrgCustomerRepresenter> proGateOrgCustomerRepresenters) {
		for (ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter : proGateOrgCustomerRepresenters) {
			if (EntityCacheUtil.getResult(
						ProGateOrgCustomerRepresenterModelImpl.ENTITY_CACHE_ENABLED,
						ProGateOrgCustomerRepresenterImpl.class,
						proGateOrgCustomerRepresenter.getPrimaryKey(), this) == null) {
				cacheResult(proGateOrgCustomerRepresenter);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(ProGateOrgCustomerRepresenterImpl.class.getName());
		EntityCacheUtil.clearCache(ProGateOrgCustomerRepresenterImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public ProGateOrgCustomerRepresenter create(
		Integer ProGateOrgCustomerRepresenterId) {
		ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter = new ProGateOrgCustomerRepresenterImpl();

		proGateOrgCustomerRepresenter.setNew(true);
		proGateOrgCustomerRepresenter.setPrimaryKey(ProGateOrgCustomerRepresenterId);

		return proGateOrgCustomerRepresenter;
	}

	public ProGateOrgCustomerRepresenter remove(
		Integer ProGateOrgCustomerRepresenterId)
		throws NoSuchProGateOrgCustomerRepresenterException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter = (ProGateOrgCustomerRepresenter)session.get(ProGateOrgCustomerRepresenterImpl.class,
					ProGateOrgCustomerRepresenterId);

			if (proGateOrgCustomerRepresenter == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No ProGateOrgCustomerRepresenter exists with the primary key " +
						ProGateOrgCustomerRepresenterId);
				}

				throw new NoSuchProGateOrgCustomerRepresenterException(
					"No ProGateOrgCustomerRepresenter exists with the primary key " +
					ProGateOrgCustomerRepresenterId);
			}

			return remove(proGateOrgCustomerRepresenter);
		}
		catch (NoSuchProGateOrgCustomerRepresenterException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public ProGateOrgCustomerRepresenter remove(
		ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter)
		throws SystemException {
		for (ModelListener<ProGateOrgCustomerRepresenter> listener : listeners) {
			listener.onBeforeRemove(proGateOrgCustomerRepresenter);
		}

		proGateOrgCustomerRepresenter = removeImpl(proGateOrgCustomerRepresenter);

		for (ModelListener<ProGateOrgCustomerRepresenter> listener : listeners) {
			listener.onAfterRemove(proGateOrgCustomerRepresenter);
		}

		return proGateOrgCustomerRepresenter;
	}

	protected ProGateOrgCustomerRepresenter removeImpl(
		ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (proGateOrgCustomerRepresenter.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(ProGateOrgCustomerRepresenterImpl.class,
						proGateOrgCustomerRepresenter.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(proGateOrgCustomerRepresenter);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(ProGateOrgCustomerRepresenterModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerRepresenterImpl.class,
			proGateOrgCustomerRepresenter.getPrimaryKey());

		return proGateOrgCustomerRepresenter;
	}

	public ProGateOrgCustomerRepresenter update(
		ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter) method. Use update(ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter, boolean merge) instead.");
		}

		return update(proGateOrgCustomerRepresenter, false);
	}

	public ProGateOrgCustomerRepresenter update(
		ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter,
		boolean merge) throws SystemException {
		boolean isNew = proGateOrgCustomerRepresenter.isNew();

		for (ModelListener<ProGateOrgCustomerRepresenter> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(proGateOrgCustomerRepresenter);
			}
			else {
				listener.onBeforeUpdate(proGateOrgCustomerRepresenter);
			}
		}

		proGateOrgCustomerRepresenter = updateImpl(proGateOrgCustomerRepresenter,
				merge);

		for (ModelListener<ProGateOrgCustomerRepresenter> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(proGateOrgCustomerRepresenter);
			}
			else {
				listener.onAfterUpdate(proGateOrgCustomerRepresenter);
			}
		}

		return proGateOrgCustomerRepresenter;
	}

	public ProGateOrgCustomerRepresenter updateImpl(
		larion.progate.model.ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, proGateOrgCustomerRepresenter,
				merge);

			proGateOrgCustomerRepresenter.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(ProGateOrgCustomerRepresenterModelImpl.ENTITY_CACHE_ENABLED,
			ProGateOrgCustomerRepresenterImpl.class,
			proGateOrgCustomerRepresenter.getPrimaryKey(),
			proGateOrgCustomerRepresenter);

		return proGateOrgCustomerRepresenter;
	}

	public ProGateOrgCustomerRepresenter findByPrimaryKey(
		Integer ProGateOrgCustomerRepresenterId)
		throws NoSuchProGateOrgCustomerRepresenterException, SystemException {
		ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter = fetchByPrimaryKey(ProGateOrgCustomerRepresenterId);

		if (proGateOrgCustomerRepresenter == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"No ProGateOrgCustomerRepresenter exists with the primary key " +
					ProGateOrgCustomerRepresenterId);
			}

			throw new NoSuchProGateOrgCustomerRepresenterException(
				"No ProGateOrgCustomerRepresenter exists with the primary key " +
				ProGateOrgCustomerRepresenterId);
		}

		return proGateOrgCustomerRepresenter;
	}

	public ProGateOrgCustomerRepresenter fetchByPrimaryKey(
		Integer ProGateOrgCustomerRepresenterId) throws SystemException {
		ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter = (ProGateOrgCustomerRepresenter)EntityCacheUtil.getResult(ProGateOrgCustomerRepresenterModelImpl.ENTITY_CACHE_ENABLED,
				ProGateOrgCustomerRepresenterImpl.class,
				ProGateOrgCustomerRepresenterId, this);

		if (proGateOrgCustomerRepresenter == null) {
			Session session = null;

			try {
				session = openSession();

				proGateOrgCustomerRepresenter = (ProGateOrgCustomerRepresenter)session.get(ProGateOrgCustomerRepresenterImpl.class,
						ProGateOrgCustomerRepresenterId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (proGateOrgCustomerRepresenter != null) {
					cacheResult(proGateOrgCustomerRepresenter);
				}

				closeSession(session);
			}
		}

		return proGateOrgCustomerRepresenter;
	}

	public List<ProGateOrgCustomerRepresenter> findByrole(String role)
		throws SystemException {
		Object[] finderArgs = new Object[] { role };

		List<ProGateOrgCustomerRepresenter> list = (List<ProGateOrgCustomerRepresenter>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ROLE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateOrgCustomerRepresenter WHERE ");

				if (role == null) {
					query.append("role IS NULL");
				}
				else {
					query.append("role = ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("modified_date DESC, ");
				query.append("created_date DESC, ");
				query.append("display_name ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (role != null) {
					qPos.add(role);
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateOrgCustomerRepresenter>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ROLE, finderArgs,
					list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateOrgCustomerRepresenter> findByrole(String role,
		int start, int end) throws SystemException {
		return findByrole(role, start, end, null);
	}

	public List<ProGateOrgCustomerRepresenter> findByrole(String role,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				role,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateOrgCustomerRepresenter> list = (List<ProGateOrgCustomerRepresenter>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ROLE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateOrgCustomerRepresenter WHERE ");

				if (role == null) {
					query.append("role IS NULL");
				}
				else {
					query.append("role = ?");
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
					query.append("display_name ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (role != null) {
					qPos.add(role);
				}

				list = (List<ProGateOrgCustomerRepresenter>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateOrgCustomerRepresenter>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ROLE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateOrgCustomerRepresenter findByrole_First(String role,
		OrderByComparator obc)
		throws NoSuchProGateOrgCustomerRepresenterException, SystemException {
		List<ProGateOrgCustomerRepresenter> list = findByrole(role, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateOrgCustomerRepresenter exists with the key {");

			msg.append("role=" + role);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateOrgCustomerRepresenterException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateOrgCustomerRepresenter findByrole_Last(String role,
		OrderByComparator obc)
		throws NoSuchProGateOrgCustomerRepresenterException, SystemException {
		int count = countByrole(role);

		List<ProGateOrgCustomerRepresenter> list = findByrole(role, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateOrgCustomerRepresenter exists with the key {");

			msg.append("role=" + role);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateOrgCustomerRepresenterException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateOrgCustomerRepresenter[] findByrole_PrevAndNext(
		Integer ProGateOrgCustomerRepresenterId, String role,
		OrderByComparator obc)
		throws NoSuchProGateOrgCustomerRepresenterException, SystemException {
		ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter = findByPrimaryKey(ProGateOrgCustomerRepresenterId);

		int count = countByrole(role);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateOrgCustomerRepresenter WHERE ");

			if (role == null) {
				query.append("role IS NULL");
			}
			else {
				query.append("role = ?");
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
				query.append("display_name ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (role != null) {
				qPos.add(role);
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateOrgCustomerRepresenter);

			ProGateOrgCustomerRepresenter[] array = new ProGateOrgCustomerRepresenterImpl[3];

			array[0] = (ProGateOrgCustomerRepresenter)objArray[0];
			array[1] = (ProGateOrgCustomerRepresenter)objArray[1];
			array[2] = (ProGateOrgCustomerRepresenter)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateOrgCustomerRepresenter> findBycustomerId(int customerId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(customerId) };

		List<ProGateOrgCustomerRepresenter> list = (List<ProGateOrgCustomerRepresenter>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_CUSTOMERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateOrgCustomerRepresenter WHERE ");

				query.append("customer_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("modified_date DESC, ");
				query.append("created_date DESC, ");
				query.append("display_name ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(customerId);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateOrgCustomerRepresenter>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_CUSTOMERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateOrgCustomerRepresenter> findBycustomerId(
		int customerId, int start, int end) throws SystemException {
		return findBycustomerId(customerId, start, end, null);
	}

	public List<ProGateOrgCustomerRepresenter> findBycustomerId(
		int customerId, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(customerId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateOrgCustomerRepresenter> list = (List<ProGateOrgCustomerRepresenter>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_CUSTOMERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateOrgCustomerRepresenter WHERE ");

				query.append("customer_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("modified_date DESC, ");
					query.append("created_date DESC, ");
					query.append("display_name ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(customerId);

				list = (List<ProGateOrgCustomerRepresenter>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateOrgCustomerRepresenter>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_CUSTOMERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateOrgCustomerRepresenter findBycustomerId_First(
		int customerId, OrderByComparator obc)
		throws NoSuchProGateOrgCustomerRepresenterException, SystemException {
		List<ProGateOrgCustomerRepresenter> list = findBycustomerId(customerId,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateOrgCustomerRepresenter exists with the key {");

			msg.append("customerId=" + customerId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateOrgCustomerRepresenterException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateOrgCustomerRepresenter findBycustomerId_Last(int customerId,
		OrderByComparator obc)
		throws NoSuchProGateOrgCustomerRepresenterException, SystemException {
		int count = countBycustomerId(customerId);

		List<ProGateOrgCustomerRepresenter> list = findBycustomerId(customerId,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateOrgCustomerRepresenter exists with the key {");

			msg.append("customerId=" + customerId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateOrgCustomerRepresenterException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateOrgCustomerRepresenter[] findBycustomerId_PrevAndNext(
		Integer ProGateOrgCustomerRepresenterId, int customerId,
		OrderByComparator obc)
		throws NoSuchProGateOrgCustomerRepresenterException, SystemException {
		ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter = findByPrimaryKey(ProGateOrgCustomerRepresenterId);

		int count = countBycustomerId(customerId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateOrgCustomerRepresenter WHERE ");

			query.append("customer_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("modified_date DESC, ");
				query.append("created_date DESC, ");
				query.append("display_name ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(customerId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateOrgCustomerRepresenter);

			ProGateOrgCustomerRepresenter[] array = new ProGateOrgCustomerRepresenterImpl[3];

			array[0] = (ProGateOrgCustomerRepresenter)objArray[0];
			array[1] = (ProGateOrgCustomerRepresenter)objArray[1];
			array[2] = (ProGateOrgCustomerRepresenter)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateOrgCustomerRepresenter> findByorgId(int orgId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(orgId) };

		List<ProGateOrgCustomerRepresenter> list = (List<ProGateOrgCustomerRepresenter>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ORGID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateOrgCustomerRepresenter WHERE ");

				query.append("org_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("modified_date DESC, ");
				query.append("created_date DESC, ");
				query.append("display_name ASC");

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
					list = new ArrayList<ProGateOrgCustomerRepresenter>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ORGID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateOrgCustomerRepresenter> findByorgId(int orgId,
		int start, int end) throws SystemException {
		return findByorgId(orgId, start, end, null);
	}

	public List<ProGateOrgCustomerRepresenter> findByorgId(int orgId,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(orgId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateOrgCustomerRepresenter> list = (List<ProGateOrgCustomerRepresenter>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ORGID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateOrgCustomerRepresenter WHERE ");

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
					query.append("display_name ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orgId);

				list = (List<ProGateOrgCustomerRepresenter>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateOrgCustomerRepresenter>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ORGID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateOrgCustomerRepresenter findByorgId_First(int orgId,
		OrderByComparator obc)
		throws NoSuchProGateOrgCustomerRepresenterException, SystemException {
		List<ProGateOrgCustomerRepresenter> list = findByorgId(orgId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateOrgCustomerRepresenter exists with the key {");

			msg.append("orgId=" + orgId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateOrgCustomerRepresenterException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateOrgCustomerRepresenter findByorgId_Last(int orgId,
		OrderByComparator obc)
		throws NoSuchProGateOrgCustomerRepresenterException, SystemException {
		int count = countByorgId(orgId);

		List<ProGateOrgCustomerRepresenter> list = findByorgId(orgId,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateOrgCustomerRepresenter exists with the key {");

			msg.append("orgId=" + orgId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateOrgCustomerRepresenterException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateOrgCustomerRepresenter[] findByorgId_PrevAndNext(
		Integer ProGateOrgCustomerRepresenterId, int orgId,
		OrderByComparator obc)
		throws NoSuchProGateOrgCustomerRepresenterException, SystemException {
		ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter = findByPrimaryKey(ProGateOrgCustomerRepresenterId);

		int count = countByorgId(orgId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateOrgCustomerRepresenter WHERE ");

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
				query.append("display_name ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(orgId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateOrgCustomerRepresenter);

			ProGateOrgCustomerRepresenter[] array = new ProGateOrgCustomerRepresenterImpl[3];

			array[0] = (ProGateOrgCustomerRepresenter)objArray[0];
			array[1] = (ProGateOrgCustomerRepresenter)objArray[1];
			array[2] = (ProGateOrgCustomerRepresenter)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateOrgCustomerRepresenter> findBydescription(
		String description) throws SystemException {
		Object[] finderArgs = new Object[] { description };

		List<ProGateOrgCustomerRepresenter> list = (List<ProGateOrgCustomerRepresenter>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DESCRIPTION,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateOrgCustomerRepresenter WHERE ");

				if (description == null) {
					query.append("description IS NULL");
				}
				else {
					query.append("description = ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("modified_date DESC, ");
				query.append("created_date DESC, ");
				query.append("display_name ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (description != null) {
					qPos.add(description);
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateOrgCustomerRepresenter>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DESCRIPTION,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateOrgCustomerRepresenter> findBydescription(
		String description, int start, int end) throws SystemException {
		return findBydescription(description, start, end, null);
	}

	public List<ProGateOrgCustomerRepresenter> findBydescription(
		String description, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				description,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateOrgCustomerRepresenter> list = (List<ProGateOrgCustomerRepresenter>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_DESCRIPTION,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateOrgCustomerRepresenter WHERE ");

				if (description == null) {
					query.append("description IS NULL");
				}
				else {
					query.append("description = ?");
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
					query.append("display_name ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (description != null) {
					qPos.add(description);
				}

				list = (List<ProGateOrgCustomerRepresenter>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateOrgCustomerRepresenter>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_DESCRIPTION,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateOrgCustomerRepresenter findBydescription_First(
		String description, OrderByComparator obc)
		throws NoSuchProGateOrgCustomerRepresenterException, SystemException {
		List<ProGateOrgCustomerRepresenter> list = findBydescription(description,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateOrgCustomerRepresenter exists with the key {");

			msg.append("description=" + description);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateOrgCustomerRepresenterException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateOrgCustomerRepresenter findBydescription_Last(
		String description, OrderByComparator obc)
		throws NoSuchProGateOrgCustomerRepresenterException, SystemException {
		int count = countBydescription(description);

		List<ProGateOrgCustomerRepresenter> list = findBydescription(description,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateOrgCustomerRepresenter exists with the key {");

			msg.append("description=" + description);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateOrgCustomerRepresenterException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateOrgCustomerRepresenter[] findBydescription_PrevAndNext(
		Integer ProGateOrgCustomerRepresenterId, String description,
		OrderByComparator obc)
		throws NoSuchProGateOrgCustomerRepresenterException, SystemException {
		ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter = findByPrimaryKey(ProGateOrgCustomerRepresenterId);

		int count = countBydescription(description);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateOrgCustomerRepresenter WHERE ");

			if (description == null) {
				query.append("description IS NULL");
			}
			else {
				query.append("description = ?");
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
				query.append("display_name ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (description != null) {
				qPos.add(description);
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateOrgCustomerRepresenter);

			ProGateOrgCustomerRepresenter[] array = new ProGateOrgCustomerRepresenterImpl[3];

			array[0] = (ProGateOrgCustomerRepresenter)objArray[0];
			array[1] = (ProGateOrgCustomerRepresenter)objArray[1];
			array[2] = (ProGateOrgCustomerRepresenter)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateOrgCustomerRepresenter> findBycreatedDateEqual(
		Date createdDate) throws SystemException {
		Object[] finderArgs = new Object[] { createdDate };

		List<ProGateOrgCustomerRepresenter> list = (List<ProGateOrgCustomerRepresenter>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_CREATEDDATEEQUAL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateOrgCustomerRepresenter WHERE ");

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
				query.append("display_name ASC");

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
					list = new ArrayList<ProGateOrgCustomerRepresenter>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_CREATEDDATEEQUAL,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateOrgCustomerRepresenter> findBycreatedDateEqual(
		Date createdDate, int start, int end) throws SystemException {
		return findBycreatedDateEqual(createdDate, start, end, null);
	}

	public List<ProGateOrgCustomerRepresenter> findBycreatedDateEqual(
		Date createdDate, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				createdDate,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateOrgCustomerRepresenter> list = (List<ProGateOrgCustomerRepresenter>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_CREATEDDATEEQUAL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateOrgCustomerRepresenter WHERE ");

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
					query.append("display_name ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (createdDate != null) {
					qPos.add(CalendarUtil.getTimestamp(createdDate));
				}

				list = (List<ProGateOrgCustomerRepresenter>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateOrgCustomerRepresenter>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_CREATEDDATEEQUAL,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateOrgCustomerRepresenter findBycreatedDateEqual_First(
		Date createdDate, OrderByComparator obc)
		throws NoSuchProGateOrgCustomerRepresenterException, SystemException {
		List<ProGateOrgCustomerRepresenter> list = findBycreatedDateEqual(createdDate,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateOrgCustomerRepresenter exists with the key {");

			msg.append("createdDate=" + createdDate);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateOrgCustomerRepresenterException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateOrgCustomerRepresenter findBycreatedDateEqual_Last(
		Date createdDate, OrderByComparator obc)
		throws NoSuchProGateOrgCustomerRepresenterException, SystemException {
		int count = countBycreatedDateEqual(createdDate);

		List<ProGateOrgCustomerRepresenter> list = findBycreatedDateEqual(createdDate,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateOrgCustomerRepresenter exists with the key {");

			msg.append("createdDate=" + createdDate);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateOrgCustomerRepresenterException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateOrgCustomerRepresenter[] findBycreatedDateEqual_PrevAndNext(
		Integer ProGateOrgCustomerRepresenterId, Date createdDate,
		OrderByComparator obc)
		throws NoSuchProGateOrgCustomerRepresenterException, SystemException {
		ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter = findByPrimaryKey(ProGateOrgCustomerRepresenterId);

		int count = countBycreatedDateEqual(createdDate);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateOrgCustomerRepresenter WHERE ");

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
				query.append("display_name ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (createdDate != null) {
				qPos.add(CalendarUtil.getTimestamp(createdDate));
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateOrgCustomerRepresenter);

			ProGateOrgCustomerRepresenter[] array = new ProGateOrgCustomerRepresenterImpl[3];

			array[0] = (ProGateOrgCustomerRepresenter)objArray[0];
			array[1] = (ProGateOrgCustomerRepresenter)objArray[1];
			array[2] = (ProGateOrgCustomerRepresenter)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateOrgCustomerRepresenter> findBycreatedDateGreater(
		Date createdDate) throws SystemException {
		Object[] finderArgs = new Object[] { createdDate };

		List<ProGateOrgCustomerRepresenter> list = (List<ProGateOrgCustomerRepresenter>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_CREATEDDATEGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateOrgCustomerRepresenter WHERE ");

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
				query.append("display_name ASC");

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
					list = new ArrayList<ProGateOrgCustomerRepresenter>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_CREATEDDATEGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateOrgCustomerRepresenter> findBycreatedDateGreater(
		Date createdDate, int start, int end) throws SystemException {
		return findBycreatedDateGreater(createdDate, start, end, null);
	}

	public List<ProGateOrgCustomerRepresenter> findBycreatedDateGreater(
		Date createdDate, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				createdDate,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateOrgCustomerRepresenter> list = (List<ProGateOrgCustomerRepresenter>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_CREATEDDATEGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateOrgCustomerRepresenter WHERE ");

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
					query.append("display_name ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (createdDate != null) {
					qPos.add(CalendarUtil.getTimestamp(createdDate));
				}

				list = (List<ProGateOrgCustomerRepresenter>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateOrgCustomerRepresenter>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_CREATEDDATEGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateOrgCustomerRepresenter findBycreatedDateGreater_First(
		Date createdDate, OrderByComparator obc)
		throws NoSuchProGateOrgCustomerRepresenterException, SystemException {
		List<ProGateOrgCustomerRepresenter> list = findBycreatedDateGreater(createdDate,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateOrgCustomerRepresenter exists with the key {");

			msg.append("createdDate=" + createdDate);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateOrgCustomerRepresenterException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateOrgCustomerRepresenter findBycreatedDateGreater_Last(
		Date createdDate, OrderByComparator obc)
		throws NoSuchProGateOrgCustomerRepresenterException, SystemException {
		int count = countBycreatedDateGreater(createdDate);

		List<ProGateOrgCustomerRepresenter> list = findBycreatedDateGreater(createdDate,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateOrgCustomerRepresenter exists with the key {");

			msg.append("createdDate=" + createdDate);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateOrgCustomerRepresenterException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateOrgCustomerRepresenter[] findBycreatedDateGreater_PrevAndNext(
		Integer ProGateOrgCustomerRepresenterId, Date createdDate,
		OrderByComparator obc)
		throws NoSuchProGateOrgCustomerRepresenterException, SystemException {
		ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter = findByPrimaryKey(ProGateOrgCustomerRepresenterId);

		int count = countBycreatedDateGreater(createdDate);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateOrgCustomerRepresenter WHERE ");

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
				query.append("display_name ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (createdDate != null) {
				qPos.add(CalendarUtil.getTimestamp(createdDate));
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateOrgCustomerRepresenter);

			ProGateOrgCustomerRepresenter[] array = new ProGateOrgCustomerRepresenterImpl[3];

			array[0] = (ProGateOrgCustomerRepresenter)objArray[0];
			array[1] = (ProGateOrgCustomerRepresenter)objArray[1];
			array[2] = (ProGateOrgCustomerRepresenter)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateOrgCustomerRepresenter> findBycreatedDateLower(
		Date createdDate) throws SystemException {
		Object[] finderArgs = new Object[] { createdDate };

		List<ProGateOrgCustomerRepresenter> list = (List<ProGateOrgCustomerRepresenter>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_CREATEDDATELOWER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateOrgCustomerRepresenter WHERE ");

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
				query.append("display_name ASC");

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
					list = new ArrayList<ProGateOrgCustomerRepresenter>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_CREATEDDATELOWER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateOrgCustomerRepresenter> findBycreatedDateLower(
		Date createdDate, int start, int end) throws SystemException {
		return findBycreatedDateLower(createdDate, start, end, null);
	}

	public List<ProGateOrgCustomerRepresenter> findBycreatedDateLower(
		Date createdDate, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				createdDate,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateOrgCustomerRepresenter> list = (List<ProGateOrgCustomerRepresenter>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_CREATEDDATELOWER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateOrgCustomerRepresenter WHERE ");

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
					query.append("display_name ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (createdDate != null) {
					qPos.add(CalendarUtil.getTimestamp(createdDate));
				}

				list = (List<ProGateOrgCustomerRepresenter>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateOrgCustomerRepresenter>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_CREATEDDATELOWER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateOrgCustomerRepresenter findBycreatedDateLower_First(
		Date createdDate, OrderByComparator obc)
		throws NoSuchProGateOrgCustomerRepresenterException, SystemException {
		List<ProGateOrgCustomerRepresenter> list = findBycreatedDateLower(createdDate,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateOrgCustomerRepresenter exists with the key {");

			msg.append("createdDate=" + createdDate);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateOrgCustomerRepresenterException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateOrgCustomerRepresenter findBycreatedDateLower_Last(
		Date createdDate, OrderByComparator obc)
		throws NoSuchProGateOrgCustomerRepresenterException, SystemException {
		int count = countBycreatedDateLower(createdDate);

		List<ProGateOrgCustomerRepresenter> list = findBycreatedDateLower(createdDate,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateOrgCustomerRepresenter exists with the key {");

			msg.append("createdDate=" + createdDate);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateOrgCustomerRepresenterException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateOrgCustomerRepresenter[] findBycreatedDateLower_PrevAndNext(
		Integer ProGateOrgCustomerRepresenterId, Date createdDate,
		OrderByComparator obc)
		throws NoSuchProGateOrgCustomerRepresenterException, SystemException {
		ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter = findByPrimaryKey(ProGateOrgCustomerRepresenterId);

		int count = countBycreatedDateLower(createdDate);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateOrgCustomerRepresenter WHERE ");

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
				query.append("display_name ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (createdDate != null) {
				qPos.add(CalendarUtil.getTimestamp(createdDate));
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateOrgCustomerRepresenter);

			ProGateOrgCustomerRepresenter[] array = new ProGateOrgCustomerRepresenterImpl[3];

			array[0] = (ProGateOrgCustomerRepresenter)objArray[0];
			array[1] = (ProGateOrgCustomerRepresenter)objArray[1];
			array[2] = (ProGateOrgCustomerRepresenter)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateOrgCustomerRepresenter> findBymodifiedDateEqual(
		Date modifiedDate) throws SystemException {
		Object[] finderArgs = new Object[] { modifiedDate };

		List<ProGateOrgCustomerRepresenter> list = (List<ProGateOrgCustomerRepresenter>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_MODIFIEDDATEEQUAL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateOrgCustomerRepresenter WHERE ");

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
				query.append("display_name ASC");

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
					list = new ArrayList<ProGateOrgCustomerRepresenter>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_MODIFIEDDATEEQUAL,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateOrgCustomerRepresenter> findBymodifiedDateEqual(
		Date modifiedDate, int start, int end) throws SystemException {
		return findBymodifiedDateEqual(modifiedDate, start, end, null);
	}

	public List<ProGateOrgCustomerRepresenter> findBymodifiedDateEqual(
		Date modifiedDate, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				modifiedDate,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateOrgCustomerRepresenter> list = (List<ProGateOrgCustomerRepresenter>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_MODIFIEDDATEEQUAL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateOrgCustomerRepresenter WHERE ");

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
					query.append("display_name ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (modifiedDate != null) {
					qPos.add(CalendarUtil.getTimestamp(modifiedDate));
				}

				list = (List<ProGateOrgCustomerRepresenter>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateOrgCustomerRepresenter>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_MODIFIEDDATEEQUAL,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateOrgCustomerRepresenter findBymodifiedDateEqual_First(
		Date modifiedDate, OrderByComparator obc)
		throws NoSuchProGateOrgCustomerRepresenterException, SystemException {
		List<ProGateOrgCustomerRepresenter> list = findBymodifiedDateEqual(modifiedDate,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateOrgCustomerRepresenter exists with the key {");

			msg.append("modifiedDate=" + modifiedDate);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateOrgCustomerRepresenterException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateOrgCustomerRepresenter findBymodifiedDateEqual_Last(
		Date modifiedDate, OrderByComparator obc)
		throws NoSuchProGateOrgCustomerRepresenterException, SystemException {
		int count = countBymodifiedDateEqual(modifiedDate);

		List<ProGateOrgCustomerRepresenter> list = findBymodifiedDateEqual(modifiedDate,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateOrgCustomerRepresenter exists with the key {");

			msg.append("modifiedDate=" + modifiedDate);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateOrgCustomerRepresenterException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateOrgCustomerRepresenter[] findBymodifiedDateEqual_PrevAndNext(
		Integer ProGateOrgCustomerRepresenterId, Date modifiedDate,
		OrderByComparator obc)
		throws NoSuchProGateOrgCustomerRepresenterException, SystemException {
		ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter = findByPrimaryKey(ProGateOrgCustomerRepresenterId);

		int count = countBymodifiedDateEqual(modifiedDate);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateOrgCustomerRepresenter WHERE ");

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
				query.append("display_name ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (modifiedDate != null) {
				qPos.add(CalendarUtil.getTimestamp(modifiedDate));
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateOrgCustomerRepresenter);

			ProGateOrgCustomerRepresenter[] array = new ProGateOrgCustomerRepresenterImpl[3];

			array[0] = (ProGateOrgCustomerRepresenter)objArray[0];
			array[1] = (ProGateOrgCustomerRepresenter)objArray[1];
			array[2] = (ProGateOrgCustomerRepresenter)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateOrgCustomerRepresenter> findBymodifiedDateGreater(
		Date modifiedDate) throws SystemException {
		Object[] finderArgs = new Object[] { modifiedDate };

		List<ProGateOrgCustomerRepresenter> list = (List<ProGateOrgCustomerRepresenter>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_MODIFIEDDATEGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateOrgCustomerRepresenter WHERE ");

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
				query.append("display_name ASC");

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
					list = new ArrayList<ProGateOrgCustomerRepresenter>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_MODIFIEDDATEGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateOrgCustomerRepresenter> findBymodifiedDateGreater(
		Date modifiedDate, int start, int end) throws SystemException {
		return findBymodifiedDateGreater(modifiedDate, start, end, null);
	}

	public List<ProGateOrgCustomerRepresenter> findBymodifiedDateGreater(
		Date modifiedDate, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				modifiedDate,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateOrgCustomerRepresenter> list = (List<ProGateOrgCustomerRepresenter>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_MODIFIEDDATEGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateOrgCustomerRepresenter WHERE ");

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
					query.append("display_name ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (modifiedDate != null) {
					qPos.add(CalendarUtil.getTimestamp(modifiedDate));
				}

				list = (List<ProGateOrgCustomerRepresenter>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateOrgCustomerRepresenter>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_MODIFIEDDATEGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateOrgCustomerRepresenter findBymodifiedDateGreater_First(
		Date modifiedDate, OrderByComparator obc)
		throws NoSuchProGateOrgCustomerRepresenterException, SystemException {
		List<ProGateOrgCustomerRepresenter> list = findBymodifiedDateGreater(modifiedDate,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateOrgCustomerRepresenter exists with the key {");

			msg.append("modifiedDate=" + modifiedDate);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateOrgCustomerRepresenterException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateOrgCustomerRepresenter findBymodifiedDateGreater_Last(
		Date modifiedDate, OrderByComparator obc)
		throws NoSuchProGateOrgCustomerRepresenterException, SystemException {
		int count = countBymodifiedDateGreater(modifiedDate);

		List<ProGateOrgCustomerRepresenter> list = findBymodifiedDateGreater(modifiedDate,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateOrgCustomerRepresenter exists with the key {");

			msg.append("modifiedDate=" + modifiedDate);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateOrgCustomerRepresenterException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateOrgCustomerRepresenter[] findBymodifiedDateGreater_PrevAndNext(
		Integer ProGateOrgCustomerRepresenterId, Date modifiedDate,
		OrderByComparator obc)
		throws NoSuchProGateOrgCustomerRepresenterException, SystemException {
		ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter = findByPrimaryKey(ProGateOrgCustomerRepresenterId);

		int count = countBymodifiedDateGreater(modifiedDate);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateOrgCustomerRepresenter WHERE ");

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
				query.append("display_name ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (modifiedDate != null) {
				qPos.add(CalendarUtil.getTimestamp(modifiedDate));
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateOrgCustomerRepresenter);

			ProGateOrgCustomerRepresenter[] array = new ProGateOrgCustomerRepresenterImpl[3];

			array[0] = (ProGateOrgCustomerRepresenter)objArray[0];
			array[1] = (ProGateOrgCustomerRepresenter)objArray[1];
			array[2] = (ProGateOrgCustomerRepresenter)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateOrgCustomerRepresenter> findBymodifiedDateLower(
		Date modifiedDate) throws SystemException {
		Object[] finderArgs = new Object[] { modifiedDate };

		List<ProGateOrgCustomerRepresenter> list = (List<ProGateOrgCustomerRepresenter>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_MODIFIEDDATELOWER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateOrgCustomerRepresenter WHERE ");

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
				query.append("display_name ASC");

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
					list = new ArrayList<ProGateOrgCustomerRepresenter>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_MODIFIEDDATELOWER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateOrgCustomerRepresenter> findBymodifiedDateLower(
		Date modifiedDate, int start, int end) throws SystemException {
		return findBymodifiedDateLower(modifiedDate, start, end, null);
	}

	public List<ProGateOrgCustomerRepresenter> findBymodifiedDateLower(
		Date modifiedDate, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				modifiedDate,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateOrgCustomerRepresenter> list = (List<ProGateOrgCustomerRepresenter>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_MODIFIEDDATELOWER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateOrgCustomerRepresenter WHERE ");

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
					query.append("display_name ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (modifiedDate != null) {
					qPos.add(CalendarUtil.getTimestamp(modifiedDate));
				}

				list = (List<ProGateOrgCustomerRepresenter>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateOrgCustomerRepresenter>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_MODIFIEDDATELOWER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateOrgCustomerRepresenter findBymodifiedDateLower_First(
		Date modifiedDate, OrderByComparator obc)
		throws NoSuchProGateOrgCustomerRepresenterException, SystemException {
		List<ProGateOrgCustomerRepresenter> list = findBymodifiedDateLower(modifiedDate,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateOrgCustomerRepresenter exists with the key {");

			msg.append("modifiedDate=" + modifiedDate);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateOrgCustomerRepresenterException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateOrgCustomerRepresenter findBymodifiedDateLower_Last(
		Date modifiedDate, OrderByComparator obc)
		throws NoSuchProGateOrgCustomerRepresenterException, SystemException {
		int count = countBymodifiedDateLower(modifiedDate);

		List<ProGateOrgCustomerRepresenter> list = findBymodifiedDateLower(modifiedDate,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateOrgCustomerRepresenter exists with the key {");

			msg.append("modifiedDate=" + modifiedDate);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateOrgCustomerRepresenterException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateOrgCustomerRepresenter[] findBymodifiedDateLower_PrevAndNext(
		Integer ProGateOrgCustomerRepresenterId, Date modifiedDate,
		OrderByComparator obc)
		throws NoSuchProGateOrgCustomerRepresenterException, SystemException {
		ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter = findByPrimaryKey(ProGateOrgCustomerRepresenterId);

		int count = countBymodifiedDateLower(modifiedDate);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateOrgCustomerRepresenter WHERE ");

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
				query.append("display_name ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (modifiedDate != null) {
				qPos.add(CalendarUtil.getTimestamp(modifiedDate));
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateOrgCustomerRepresenter);

			ProGateOrgCustomerRepresenter[] array = new ProGateOrgCustomerRepresenterImpl[3];

			array[0] = (ProGateOrgCustomerRepresenter)objArray[0];
			array[1] = (ProGateOrgCustomerRepresenter)objArray[1];
			array[2] = (ProGateOrgCustomerRepresenter)objArray[2];

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

	public List<ProGateOrgCustomerRepresenter> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<ProGateOrgCustomerRepresenter> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<ProGateOrgCustomerRepresenter> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateOrgCustomerRepresenter> list = (List<ProGateOrgCustomerRepresenter>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateOrgCustomerRepresenter ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("modified_date DESC, ");
					query.append("created_date DESC, ");
					query.append("display_name ASC");
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<ProGateOrgCustomerRepresenter>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ProGateOrgCustomerRepresenter>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateOrgCustomerRepresenter>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByrole(String role) throws SystemException {
		for (ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter : findByrole(
				role)) {
			remove(proGateOrgCustomerRepresenter);
		}
	}

	public void removeBycustomerId(int customerId) throws SystemException {
		for (ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter : findBycustomerId(
				customerId)) {
			remove(proGateOrgCustomerRepresenter);
		}
	}

	public void removeByorgId(int orgId) throws SystemException {
		for (ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter : findByorgId(
				orgId)) {
			remove(proGateOrgCustomerRepresenter);
		}
	}

	public void removeBydescription(String description)
		throws SystemException {
		for (ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter : findBydescription(
				description)) {
			remove(proGateOrgCustomerRepresenter);
		}
	}

	public void removeBycreatedDateEqual(Date createdDate)
		throws SystemException {
		for (ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter : findBycreatedDateEqual(
				createdDate)) {
			remove(proGateOrgCustomerRepresenter);
		}
	}

	public void removeBycreatedDateGreater(Date createdDate)
		throws SystemException {
		for (ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter : findBycreatedDateGreater(
				createdDate)) {
			remove(proGateOrgCustomerRepresenter);
		}
	}

	public void removeBycreatedDateLower(Date createdDate)
		throws SystemException {
		for (ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter : findBycreatedDateLower(
				createdDate)) {
			remove(proGateOrgCustomerRepresenter);
		}
	}

	public void removeBymodifiedDateEqual(Date modifiedDate)
		throws SystemException {
		for (ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter : findBymodifiedDateEqual(
				modifiedDate)) {
			remove(proGateOrgCustomerRepresenter);
		}
	}

	public void removeBymodifiedDateGreater(Date modifiedDate)
		throws SystemException {
		for (ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter : findBymodifiedDateGreater(
				modifiedDate)) {
			remove(proGateOrgCustomerRepresenter);
		}
	}

	public void removeBymodifiedDateLower(Date modifiedDate)
		throws SystemException {
		for (ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter : findBymodifiedDateLower(
				modifiedDate)) {
			remove(proGateOrgCustomerRepresenter);
		}
	}

	public void removeAll() throws SystemException {
		for (ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter : findAll()) {
			remove(proGateOrgCustomerRepresenter);
		}
	}

	public int countByrole(String role) throws SystemException {
		Object[] finderArgs = new Object[] { role };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ROLE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateOrgCustomerRepresenter WHERE ");

				if (role == null) {
					query.append("role IS NULL");
				}
				else {
					query.append("role = ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (role != null) {
					qPos.add(role);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ROLE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countBycustomerId(int customerId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(customerId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CUSTOMERID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateOrgCustomerRepresenter WHERE ");

				query.append("customer_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(customerId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CUSTOMERID,
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
					"FROM larion.progate.model.ProGateOrgCustomerRepresenter WHERE ");

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

	public int countBydescription(String description) throws SystemException {
		Object[] finderArgs = new Object[] { description };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DESCRIPTION,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateOrgCustomerRepresenter WHERE ");

				if (description == null) {
					query.append("description IS NULL");
				}
				else {
					query.append("description = ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (description != null) {
					qPos.add(description);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DESCRIPTION,
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
					"FROM larion.progate.model.ProGateOrgCustomerRepresenter WHERE ");

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
					"FROM larion.progate.model.ProGateOrgCustomerRepresenter WHERE ");

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
					"FROM larion.progate.model.ProGateOrgCustomerRepresenter WHERE ");

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
					"FROM larion.progate.model.ProGateOrgCustomerRepresenter WHERE ");

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
					"FROM larion.progate.model.ProGateOrgCustomerRepresenter WHERE ");

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
					"FROM larion.progate.model.ProGateOrgCustomerRepresenter WHERE ");

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
						"SELECT COUNT(*) FROM larion.progate.model.ProGateOrgCustomerRepresenter");

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
						"value.object.listener.larion.progate.model.ProGateOrgCustomerRepresenter")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ProGateOrgCustomerRepresenter>> listenersList =
					new ArrayList<ModelListener<ProGateOrgCustomerRepresenter>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ProGateOrgCustomerRepresenter>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(ProGateOrgCustomerRepresenterPersistenceImpl.class);
}