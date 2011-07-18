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

import larion.progate.NoSuchProgateOrganizationsStaffsException;

import larion.progate.model.ProgateOrganizationsStaffs;
import larion.progate.model.impl.ProgateOrganizationsStaffsImpl;
import larion.progate.model.impl.ProgateOrganizationsStaffsModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="ProgateOrganizationsStaffsPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProgateOrganizationsStaffsPersistenceImpl
	extends BasePersistenceImpl implements ProgateOrganizationsStaffsPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = ProgateOrganizationsStaffsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_ORGID = new FinderPath(ProgateOrganizationsStaffsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationsStaffsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByorgId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ORGID = new FinderPath(ProgateOrganizationsStaffsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationsStaffsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByorgId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGID = new FinderPath(ProgateOrganizationsStaffsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationsStaffsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByorgId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ROOTID = new FinderPath(ProgateOrganizationsStaffsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationsStaffsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByrootId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ROOTID = new FinderPath(ProgateOrganizationsStaffsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationsStaffsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByrootId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ROOTID = new FinderPath(ProgateOrganizationsStaffsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationsStaffsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByrootId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_BODID = new FinderPath(ProgateOrganizationsStaffsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationsStaffsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBybodId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_BODID = new FinderPath(ProgateOrganizationsStaffsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationsStaffsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBybodId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_BODID = new FinderPath(ProgateOrganizationsStaffsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationsStaffsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBybodId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_PARTICIPANTID = new FinderPath(ProgateOrganizationsStaffsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationsStaffsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByparticipantId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_PARTICIPANTID = new FinderPath(ProgateOrganizationsStaffsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationsStaffsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByparticipantId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_PARTICIPANTID = new FinderPath(ProgateOrganizationsStaffsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationsStaffsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByparticipantId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ISACTIVE = new FinderPath(ProgateOrganizationsStaffsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationsStaffsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByisActive",
			new String[] { Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ISACTIVE = new FinderPath(ProgateOrganizationsStaffsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationsStaffsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByisActive",
			new String[] {
				Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ISACTIVE = new FinderPath(ProgateOrganizationsStaffsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationsStaffsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByisActive",
			new String[] { Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ISREMOVED = new FinderPath(ProgateOrganizationsStaffsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationsStaffsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByisRemoved",
			new String[] { Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ISREMOVED = new FinderPath(ProgateOrganizationsStaffsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationsStaffsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByisRemoved",
			new String[] {
				Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ISREMOVED = new FinderPath(ProgateOrganizationsStaffsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationsStaffsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByisRemoved",
			new String[] { Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_SCANNERCODE = new FinderPath(ProgateOrganizationsStaffsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationsStaffsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByscannerCode",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_SCANNERCODE = new FinderPath(ProgateOrganizationsStaffsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationsStaffsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByscannerCode",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_SCANNERCODE = new FinderPath(ProgateOrganizationsStaffsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationsStaffsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByscannerCode",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_STAFFCODE = new FinderPath(ProgateOrganizationsStaffsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationsStaffsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBystaffCode",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_STAFFCODE = new FinderPath(ProgateOrganizationsStaffsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationsStaffsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBystaffCode",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_STAFFCODE = new FinderPath(ProgateOrganizationsStaffsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationsStaffsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBystaffCode",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_USERID = new FinderPath(ProgateOrganizationsStaffsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationsStaffsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByuserId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_USERID = new FinderPath(ProgateOrganizationsStaffsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationsStaffsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByuserId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(ProgateOrganizationsStaffsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationsStaffsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByuserId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(ProgateOrganizationsStaffsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationsStaffsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProgateOrganizationsStaffsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationsStaffsModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(
		ProgateOrganizationsStaffs progateOrganizationsStaffs) {
		EntityCacheUtil.putResult(ProgateOrganizationsStaffsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationsStaffsImpl.class,
			progateOrganizationsStaffs.getPrimaryKey(),
			progateOrganizationsStaffs);
	}

	public void cacheResult(
		List<ProgateOrganizationsStaffs> progateOrganizationsStaffses) {
		for (ProgateOrganizationsStaffs progateOrganizationsStaffs : progateOrganizationsStaffses) {
			if (EntityCacheUtil.getResult(
						ProgateOrganizationsStaffsModelImpl.ENTITY_CACHE_ENABLED,
						ProgateOrganizationsStaffsImpl.class,
						progateOrganizationsStaffs.getPrimaryKey(), this) == null) {
				cacheResult(progateOrganizationsStaffs);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(ProgateOrganizationsStaffsImpl.class.getName());
		EntityCacheUtil.clearCache(ProgateOrganizationsStaffsImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public ProgateOrganizationsStaffs create(
		Integer ProgateOrganizationsStaffsId) {
		ProgateOrganizationsStaffs progateOrganizationsStaffs = new ProgateOrganizationsStaffsImpl();

		progateOrganizationsStaffs.setNew(true);
		progateOrganizationsStaffs.setPrimaryKey(ProgateOrganizationsStaffsId);

		return progateOrganizationsStaffs;
	}

	public ProgateOrganizationsStaffs remove(
		Integer ProgateOrganizationsStaffsId)
		throws NoSuchProgateOrganizationsStaffsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ProgateOrganizationsStaffs progateOrganizationsStaffs = (ProgateOrganizationsStaffs)session.get(ProgateOrganizationsStaffsImpl.class,
					ProgateOrganizationsStaffsId);

			if (progateOrganizationsStaffs == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No ProgateOrganizationsStaffs exists with the primary key " +
						ProgateOrganizationsStaffsId);
				}

				throw new NoSuchProgateOrganizationsStaffsException(
					"No ProgateOrganizationsStaffs exists with the primary key " +
					ProgateOrganizationsStaffsId);
			}

			return remove(progateOrganizationsStaffs);
		}
		catch (NoSuchProgateOrganizationsStaffsException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public ProgateOrganizationsStaffs remove(
		ProgateOrganizationsStaffs progateOrganizationsStaffs)
		throws SystemException {
		for (ModelListener<ProgateOrganizationsStaffs> listener : listeners) {
			listener.onBeforeRemove(progateOrganizationsStaffs);
		}

		progateOrganizationsStaffs = removeImpl(progateOrganizationsStaffs);

		for (ModelListener<ProgateOrganizationsStaffs> listener : listeners) {
			listener.onAfterRemove(progateOrganizationsStaffs);
		}

		return progateOrganizationsStaffs;
	}

	protected ProgateOrganizationsStaffs removeImpl(
		ProgateOrganizationsStaffs progateOrganizationsStaffs)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (progateOrganizationsStaffs.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(ProgateOrganizationsStaffsImpl.class,
						progateOrganizationsStaffs.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(progateOrganizationsStaffs);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(ProgateOrganizationsStaffsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationsStaffsImpl.class,
			progateOrganizationsStaffs.getPrimaryKey());

		return progateOrganizationsStaffs;
	}

	public ProgateOrganizationsStaffs update(
		ProgateOrganizationsStaffs progateOrganizationsStaffs)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(ProgateOrganizationsStaffs progateOrganizationsStaffs) method. Use update(ProgateOrganizationsStaffs progateOrganizationsStaffs, boolean merge) instead.");
		}

		return update(progateOrganizationsStaffs, false);
	}

	public ProgateOrganizationsStaffs update(
		ProgateOrganizationsStaffs progateOrganizationsStaffs, boolean merge)
		throws SystemException {
		boolean isNew = progateOrganizationsStaffs.isNew();

		for (ModelListener<ProgateOrganizationsStaffs> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(progateOrganizationsStaffs);
			}
			else {
				listener.onBeforeUpdate(progateOrganizationsStaffs);
			}
		}

		progateOrganizationsStaffs = updateImpl(progateOrganizationsStaffs,
				merge);

		for (ModelListener<ProgateOrganizationsStaffs> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(progateOrganizationsStaffs);
			}
			else {
				listener.onAfterUpdate(progateOrganizationsStaffs);
			}
		}

		return progateOrganizationsStaffs;
	}

	public ProgateOrganizationsStaffs updateImpl(
		larion.progate.model.ProgateOrganizationsStaffs progateOrganizationsStaffs,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, progateOrganizationsStaffs, merge);

			progateOrganizationsStaffs.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(ProgateOrganizationsStaffsModelImpl.ENTITY_CACHE_ENABLED,
			ProgateOrganizationsStaffsImpl.class,
			progateOrganizationsStaffs.getPrimaryKey(),
			progateOrganizationsStaffs);

		return progateOrganizationsStaffs;
	}

	public ProgateOrganizationsStaffs findByPrimaryKey(
		Integer ProgateOrganizationsStaffsId)
		throws NoSuchProgateOrganizationsStaffsException, SystemException {
		ProgateOrganizationsStaffs progateOrganizationsStaffs = fetchByPrimaryKey(ProgateOrganizationsStaffsId);

		if (progateOrganizationsStaffs == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"No ProgateOrganizationsStaffs exists with the primary key " +
					ProgateOrganizationsStaffsId);
			}

			throw new NoSuchProgateOrganizationsStaffsException(
				"No ProgateOrganizationsStaffs exists with the primary key " +
				ProgateOrganizationsStaffsId);
		}

		return progateOrganizationsStaffs;
	}

	public ProgateOrganizationsStaffs fetchByPrimaryKey(
		Integer ProgateOrganizationsStaffsId) throws SystemException {
		ProgateOrganizationsStaffs progateOrganizationsStaffs = (ProgateOrganizationsStaffs)EntityCacheUtil.getResult(ProgateOrganizationsStaffsModelImpl.ENTITY_CACHE_ENABLED,
				ProgateOrganizationsStaffsImpl.class,
				ProgateOrganizationsStaffsId, this);

		if (progateOrganizationsStaffs == null) {
			Session session = null;

			try {
				session = openSession();

				progateOrganizationsStaffs = (ProgateOrganizationsStaffs)session.get(ProgateOrganizationsStaffsImpl.class,
						ProgateOrganizationsStaffsId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (progateOrganizationsStaffs != null) {
					cacheResult(progateOrganizationsStaffs);
				}

				closeSession(session);
			}
		}

		return progateOrganizationsStaffs;
	}

	public List<ProgateOrganizationsStaffs> findByorgId(int orgId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(orgId) };

		List<ProgateOrganizationsStaffs> list = (List<ProgateOrganizationsStaffs>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ORGID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProgateOrganizationsStaffs WHERE ");

				query.append("org_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("staff_code ASC, ");
				query.append("scanner_code ASC");

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
					list = new ArrayList<ProgateOrganizationsStaffs>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ORGID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProgateOrganizationsStaffs> findByorgId(int orgId, int start,
		int end) throws SystemException {
		return findByorgId(orgId, start, end, null);
	}

	public List<ProgateOrganizationsStaffs> findByorgId(int orgId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(orgId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProgateOrganizationsStaffs> list = (List<ProgateOrganizationsStaffs>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ORGID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProgateOrganizationsStaffs WHERE ");

				query.append("org_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("staff_code ASC, ");
					query.append("scanner_code ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orgId);

				list = (List<ProgateOrganizationsStaffs>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProgateOrganizationsStaffs>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ORGID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProgateOrganizationsStaffs findByorgId_First(int orgId,
		OrderByComparator obc)
		throws NoSuchProgateOrganizationsStaffsException, SystemException {
		List<ProgateOrganizationsStaffs> list = findByorgId(orgId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProgateOrganizationsStaffs exists with the key {");

			msg.append("orgId=" + orgId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProgateOrganizationsStaffsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProgateOrganizationsStaffs findByorgId_Last(int orgId,
		OrderByComparator obc)
		throws NoSuchProgateOrganizationsStaffsException, SystemException {
		int count = countByorgId(orgId);

		List<ProgateOrganizationsStaffs> list = findByorgId(orgId, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProgateOrganizationsStaffs exists with the key {");

			msg.append("orgId=" + orgId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProgateOrganizationsStaffsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProgateOrganizationsStaffs[] findByorgId_PrevAndNext(
		Integer ProgateOrganizationsStaffsId, int orgId, OrderByComparator obc)
		throws NoSuchProgateOrganizationsStaffsException, SystemException {
		ProgateOrganizationsStaffs progateOrganizationsStaffs = findByPrimaryKey(ProgateOrganizationsStaffsId);

		int count = countByorgId(orgId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProgateOrganizationsStaffs WHERE ");

			query.append("org_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("staff_code ASC, ");
				query.append("scanner_code ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(orgId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					progateOrganizationsStaffs);

			ProgateOrganizationsStaffs[] array = new ProgateOrganizationsStaffsImpl[3];

			array[0] = (ProgateOrganizationsStaffs)objArray[0];
			array[1] = (ProgateOrganizationsStaffs)objArray[1];
			array[2] = (ProgateOrganizationsStaffs)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProgateOrganizationsStaffs> findByrootId(int rootId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		List<ProgateOrganizationsStaffs> list = (List<ProgateOrganizationsStaffs>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProgateOrganizationsStaffs WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("staff_code ASC, ");
				query.append("scanner_code ASC");

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
					list = new ArrayList<ProgateOrganizationsStaffs>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProgateOrganizationsStaffs> findByrootId(int rootId, int start,
		int end) throws SystemException {
		return findByrootId(rootId, start, end, null);
	}

	public List<ProgateOrganizationsStaffs> findByrootId(int rootId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(rootId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProgateOrganizationsStaffs> list = (List<ProgateOrganizationsStaffs>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProgateOrganizationsStaffs WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("staff_code ASC, ");
					query.append("scanner_code ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rootId);

				list = (List<ProgateOrganizationsStaffs>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProgateOrganizationsStaffs>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProgateOrganizationsStaffs findByrootId_First(int rootId,
		OrderByComparator obc)
		throws NoSuchProgateOrganizationsStaffsException, SystemException {
		List<ProgateOrganizationsStaffs> list = findByrootId(rootId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProgateOrganizationsStaffs exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProgateOrganizationsStaffsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProgateOrganizationsStaffs findByrootId_Last(int rootId,
		OrderByComparator obc)
		throws NoSuchProgateOrganizationsStaffsException, SystemException {
		int count = countByrootId(rootId);

		List<ProgateOrganizationsStaffs> list = findByrootId(rootId, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProgateOrganizationsStaffs exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProgateOrganizationsStaffsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProgateOrganizationsStaffs[] findByrootId_PrevAndNext(
		Integer ProgateOrganizationsStaffsId, int rootId, OrderByComparator obc)
		throws NoSuchProgateOrganizationsStaffsException, SystemException {
		ProgateOrganizationsStaffs progateOrganizationsStaffs = findByPrimaryKey(ProgateOrganizationsStaffsId);

		int count = countByrootId(rootId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProgateOrganizationsStaffs WHERE ");

			query.append("root_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("staff_code ASC, ");
				query.append("scanner_code ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(rootId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					progateOrganizationsStaffs);

			ProgateOrganizationsStaffs[] array = new ProgateOrganizationsStaffsImpl[3];

			array[0] = (ProgateOrganizationsStaffs)objArray[0];
			array[1] = (ProgateOrganizationsStaffs)objArray[1];
			array[2] = (ProgateOrganizationsStaffs)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProgateOrganizationsStaffs> findBybodId(int bodId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(bodId) };

		List<ProgateOrganizationsStaffs> list = (List<ProgateOrganizationsStaffs>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_BODID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProgateOrganizationsStaffs WHERE ");

				query.append("bod_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("staff_code ASC, ");
				query.append("scanner_code ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(bodId);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProgateOrganizationsStaffs>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_BODID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProgateOrganizationsStaffs> findBybodId(int bodId, int start,
		int end) throws SystemException {
		return findBybodId(bodId, start, end, null);
	}

	public List<ProgateOrganizationsStaffs> findBybodId(int bodId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(bodId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProgateOrganizationsStaffs> list = (List<ProgateOrganizationsStaffs>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_BODID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProgateOrganizationsStaffs WHERE ");

				query.append("bod_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("staff_code ASC, ");
					query.append("scanner_code ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(bodId);

				list = (List<ProgateOrganizationsStaffs>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProgateOrganizationsStaffs>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_BODID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProgateOrganizationsStaffs findBybodId_First(int bodId,
		OrderByComparator obc)
		throws NoSuchProgateOrganizationsStaffsException, SystemException {
		List<ProgateOrganizationsStaffs> list = findBybodId(bodId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProgateOrganizationsStaffs exists with the key {");

			msg.append("bodId=" + bodId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProgateOrganizationsStaffsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProgateOrganizationsStaffs findBybodId_Last(int bodId,
		OrderByComparator obc)
		throws NoSuchProgateOrganizationsStaffsException, SystemException {
		int count = countBybodId(bodId);

		List<ProgateOrganizationsStaffs> list = findBybodId(bodId, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProgateOrganizationsStaffs exists with the key {");

			msg.append("bodId=" + bodId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProgateOrganizationsStaffsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProgateOrganizationsStaffs[] findBybodId_PrevAndNext(
		Integer ProgateOrganizationsStaffsId, int bodId, OrderByComparator obc)
		throws NoSuchProgateOrganizationsStaffsException, SystemException {
		ProgateOrganizationsStaffs progateOrganizationsStaffs = findByPrimaryKey(ProgateOrganizationsStaffsId);

		int count = countBybodId(bodId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProgateOrganizationsStaffs WHERE ");

			query.append("bod_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("staff_code ASC, ");
				query.append("scanner_code ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(bodId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					progateOrganizationsStaffs);

			ProgateOrganizationsStaffs[] array = new ProgateOrganizationsStaffsImpl[3];

			array[0] = (ProgateOrganizationsStaffs)objArray[0];
			array[1] = (ProgateOrganizationsStaffs)objArray[1];
			array[2] = (ProgateOrganizationsStaffs)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProgateOrganizationsStaffs> findByparticipantId(
		int participantId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(participantId) };

		List<ProgateOrganizationsStaffs> list = (List<ProgateOrganizationsStaffs>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_PARTICIPANTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProgateOrganizationsStaffs WHERE ");

				query.append("participant_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("staff_code ASC, ");
				query.append("scanner_code ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(participantId);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProgateOrganizationsStaffs>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_PARTICIPANTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProgateOrganizationsStaffs> findByparticipantId(
		int participantId, int start, int end) throws SystemException {
		return findByparticipantId(participantId, start, end, null);
	}

	public List<ProgateOrganizationsStaffs> findByparticipantId(
		int participantId, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(participantId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProgateOrganizationsStaffs> list = (List<ProgateOrganizationsStaffs>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_PARTICIPANTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProgateOrganizationsStaffs WHERE ");

				query.append("participant_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("staff_code ASC, ");
					query.append("scanner_code ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(participantId);

				list = (List<ProgateOrganizationsStaffs>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProgateOrganizationsStaffs>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_PARTICIPANTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProgateOrganizationsStaffs findByparticipantId_First(
		int participantId, OrderByComparator obc)
		throws NoSuchProgateOrganizationsStaffsException, SystemException {
		List<ProgateOrganizationsStaffs> list = findByparticipantId(participantId,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProgateOrganizationsStaffs exists with the key {");

			msg.append("participantId=" + participantId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProgateOrganizationsStaffsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProgateOrganizationsStaffs findByparticipantId_Last(
		int participantId, OrderByComparator obc)
		throws NoSuchProgateOrganizationsStaffsException, SystemException {
		int count = countByparticipantId(participantId);

		List<ProgateOrganizationsStaffs> list = findByparticipantId(participantId,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProgateOrganizationsStaffs exists with the key {");

			msg.append("participantId=" + participantId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProgateOrganizationsStaffsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProgateOrganizationsStaffs[] findByparticipantId_PrevAndNext(
		Integer ProgateOrganizationsStaffsId, int participantId,
		OrderByComparator obc)
		throws NoSuchProgateOrganizationsStaffsException, SystemException {
		ProgateOrganizationsStaffs progateOrganizationsStaffs = findByPrimaryKey(ProgateOrganizationsStaffsId);

		int count = countByparticipantId(participantId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProgateOrganizationsStaffs WHERE ");

			query.append("participant_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("staff_code ASC, ");
				query.append("scanner_code ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(participantId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					progateOrganizationsStaffs);

			ProgateOrganizationsStaffs[] array = new ProgateOrganizationsStaffsImpl[3];

			array[0] = (ProgateOrganizationsStaffs)objArray[0];
			array[1] = (ProgateOrganizationsStaffs)objArray[1];
			array[2] = (ProgateOrganizationsStaffs)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProgateOrganizationsStaffs> findByisActive(boolean isActive)
		throws SystemException {
		Object[] finderArgs = new Object[] { Boolean.valueOf(isActive) };

		List<ProgateOrganizationsStaffs> list = (List<ProgateOrganizationsStaffs>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ISACTIVE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProgateOrganizationsStaffs WHERE ");

				query.append("is_active = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("staff_code ASC, ");
				query.append("scanner_code ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isActive);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProgateOrganizationsStaffs>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ISACTIVE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProgateOrganizationsStaffs> findByisActive(boolean isActive,
		int start, int end) throws SystemException {
		return findByisActive(isActive, start, end, null);
	}

	public List<ProgateOrganizationsStaffs> findByisActive(boolean isActive,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				Boolean.valueOf(isActive),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProgateOrganizationsStaffs> list = (List<ProgateOrganizationsStaffs>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ISACTIVE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProgateOrganizationsStaffs WHERE ");

				query.append("is_active = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("staff_code ASC, ");
					query.append("scanner_code ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isActive);

				list = (List<ProgateOrganizationsStaffs>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProgateOrganizationsStaffs>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ISACTIVE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProgateOrganizationsStaffs findByisActive_First(boolean isActive,
		OrderByComparator obc)
		throws NoSuchProgateOrganizationsStaffsException, SystemException {
		List<ProgateOrganizationsStaffs> list = findByisActive(isActive, 0, 1,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProgateOrganizationsStaffs exists with the key {");

			msg.append("isActive=" + isActive);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProgateOrganizationsStaffsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProgateOrganizationsStaffs findByisActive_Last(boolean isActive,
		OrderByComparator obc)
		throws NoSuchProgateOrganizationsStaffsException, SystemException {
		int count = countByisActive(isActive);

		List<ProgateOrganizationsStaffs> list = findByisActive(isActive,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProgateOrganizationsStaffs exists with the key {");

			msg.append("isActive=" + isActive);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProgateOrganizationsStaffsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProgateOrganizationsStaffs[] findByisActive_PrevAndNext(
		Integer ProgateOrganizationsStaffsId, boolean isActive,
		OrderByComparator obc)
		throws NoSuchProgateOrganizationsStaffsException, SystemException {
		ProgateOrganizationsStaffs progateOrganizationsStaffs = findByPrimaryKey(ProgateOrganizationsStaffsId);

		int count = countByisActive(isActive);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProgateOrganizationsStaffs WHERE ");

			query.append("is_active = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("staff_code ASC, ");
				query.append("scanner_code ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(isActive);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					progateOrganizationsStaffs);

			ProgateOrganizationsStaffs[] array = new ProgateOrganizationsStaffsImpl[3];

			array[0] = (ProgateOrganizationsStaffs)objArray[0];
			array[1] = (ProgateOrganizationsStaffs)objArray[1];
			array[2] = (ProgateOrganizationsStaffs)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProgateOrganizationsStaffs> findByisRemoved(boolean isRemoved)
		throws SystemException {
		Object[] finderArgs = new Object[] { Boolean.valueOf(isRemoved) };

		List<ProgateOrganizationsStaffs> list = (List<ProgateOrganizationsStaffs>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ISREMOVED,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProgateOrganizationsStaffs WHERE ");

				query.append("is_removed = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("staff_code ASC, ");
				query.append("scanner_code ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isRemoved);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProgateOrganizationsStaffs>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ISREMOVED,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProgateOrganizationsStaffs> findByisRemoved(boolean isRemoved,
		int start, int end) throws SystemException {
		return findByisRemoved(isRemoved, start, end, null);
	}

	public List<ProgateOrganizationsStaffs> findByisRemoved(boolean isRemoved,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				Boolean.valueOf(isRemoved),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProgateOrganizationsStaffs> list = (List<ProgateOrganizationsStaffs>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ISREMOVED,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProgateOrganizationsStaffs WHERE ");

				query.append("is_removed = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("staff_code ASC, ");
					query.append("scanner_code ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isRemoved);

				list = (List<ProgateOrganizationsStaffs>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProgateOrganizationsStaffs>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ISREMOVED,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProgateOrganizationsStaffs findByisRemoved_First(boolean isRemoved,
		OrderByComparator obc)
		throws NoSuchProgateOrganizationsStaffsException, SystemException {
		List<ProgateOrganizationsStaffs> list = findByisRemoved(isRemoved, 0,
				1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProgateOrganizationsStaffs exists with the key {");

			msg.append("isRemoved=" + isRemoved);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProgateOrganizationsStaffsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProgateOrganizationsStaffs findByisRemoved_Last(boolean isRemoved,
		OrderByComparator obc)
		throws NoSuchProgateOrganizationsStaffsException, SystemException {
		int count = countByisRemoved(isRemoved);

		List<ProgateOrganizationsStaffs> list = findByisRemoved(isRemoved,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProgateOrganizationsStaffs exists with the key {");

			msg.append("isRemoved=" + isRemoved);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProgateOrganizationsStaffsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProgateOrganizationsStaffs[] findByisRemoved_PrevAndNext(
		Integer ProgateOrganizationsStaffsId, boolean isRemoved,
		OrderByComparator obc)
		throws NoSuchProgateOrganizationsStaffsException, SystemException {
		ProgateOrganizationsStaffs progateOrganizationsStaffs = findByPrimaryKey(ProgateOrganizationsStaffsId);

		int count = countByisRemoved(isRemoved);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProgateOrganizationsStaffs WHERE ");

			query.append("is_removed = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("staff_code ASC, ");
				query.append("scanner_code ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(isRemoved);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					progateOrganizationsStaffs);

			ProgateOrganizationsStaffs[] array = new ProgateOrganizationsStaffsImpl[3];

			array[0] = (ProgateOrganizationsStaffs)objArray[0];
			array[1] = (ProgateOrganizationsStaffs)objArray[1];
			array[2] = (ProgateOrganizationsStaffs)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProgateOrganizationsStaffs> findByscannerCode(
		String scannerCode) throws SystemException {
		Object[] finderArgs = new Object[] { scannerCode };

		List<ProgateOrganizationsStaffs> list = (List<ProgateOrganizationsStaffs>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_SCANNERCODE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProgateOrganizationsStaffs WHERE ");

				if (scannerCode == null) {
					query.append("scanner_code IS NULL");
				}
				else {
					query.append("scanner_code = ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("staff_code ASC, ");
				query.append("scanner_code ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (scannerCode != null) {
					qPos.add(scannerCode);
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProgateOrganizationsStaffs>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_SCANNERCODE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProgateOrganizationsStaffs> findByscannerCode(
		String scannerCode, int start, int end) throws SystemException {
		return findByscannerCode(scannerCode, start, end, null);
	}

	public List<ProgateOrganizationsStaffs> findByscannerCode(
		String scannerCode, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				scannerCode,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProgateOrganizationsStaffs> list = (List<ProgateOrganizationsStaffs>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_SCANNERCODE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProgateOrganizationsStaffs WHERE ");

				if (scannerCode == null) {
					query.append("scanner_code IS NULL");
				}
				else {
					query.append("scanner_code = ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("staff_code ASC, ");
					query.append("scanner_code ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (scannerCode != null) {
					qPos.add(scannerCode);
				}

				list = (List<ProgateOrganizationsStaffs>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProgateOrganizationsStaffs>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_SCANNERCODE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProgateOrganizationsStaffs findByscannerCode_First(
		String scannerCode, OrderByComparator obc)
		throws NoSuchProgateOrganizationsStaffsException, SystemException {
		List<ProgateOrganizationsStaffs> list = findByscannerCode(scannerCode,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProgateOrganizationsStaffs exists with the key {");

			msg.append("scannerCode=" + scannerCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProgateOrganizationsStaffsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProgateOrganizationsStaffs findByscannerCode_Last(
		String scannerCode, OrderByComparator obc)
		throws NoSuchProgateOrganizationsStaffsException, SystemException {
		int count = countByscannerCode(scannerCode);

		List<ProgateOrganizationsStaffs> list = findByscannerCode(scannerCode,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProgateOrganizationsStaffs exists with the key {");

			msg.append("scannerCode=" + scannerCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProgateOrganizationsStaffsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProgateOrganizationsStaffs[] findByscannerCode_PrevAndNext(
		Integer ProgateOrganizationsStaffsId, String scannerCode,
		OrderByComparator obc)
		throws NoSuchProgateOrganizationsStaffsException, SystemException {
		ProgateOrganizationsStaffs progateOrganizationsStaffs = findByPrimaryKey(ProgateOrganizationsStaffsId);

		int count = countByscannerCode(scannerCode);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProgateOrganizationsStaffs WHERE ");

			if (scannerCode == null) {
				query.append("scanner_code IS NULL");
			}
			else {
				query.append("scanner_code = ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("staff_code ASC, ");
				query.append("scanner_code ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (scannerCode != null) {
				qPos.add(scannerCode);
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					progateOrganizationsStaffs);

			ProgateOrganizationsStaffs[] array = new ProgateOrganizationsStaffsImpl[3];

			array[0] = (ProgateOrganizationsStaffs)objArray[0];
			array[1] = (ProgateOrganizationsStaffs)objArray[1];
			array[2] = (ProgateOrganizationsStaffs)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProgateOrganizationsStaffs> findBystaffCode(String staffCode)
		throws SystemException {
		Object[] finderArgs = new Object[] { staffCode };

		List<ProgateOrganizationsStaffs> list = (List<ProgateOrganizationsStaffs>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_STAFFCODE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProgateOrganizationsStaffs WHERE ");

				if (staffCode == null) {
					query.append("staff_code IS NULL");
				}
				else {
					query.append("staff_code = ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("staff_code ASC, ");
				query.append("scanner_code ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (staffCode != null) {
					qPos.add(staffCode);
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProgateOrganizationsStaffs>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_STAFFCODE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProgateOrganizationsStaffs> findBystaffCode(String staffCode,
		int start, int end) throws SystemException {
		return findBystaffCode(staffCode, start, end, null);
	}

	public List<ProgateOrganizationsStaffs> findBystaffCode(String staffCode,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				staffCode,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProgateOrganizationsStaffs> list = (List<ProgateOrganizationsStaffs>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_STAFFCODE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProgateOrganizationsStaffs WHERE ");

				if (staffCode == null) {
					query.append("staff_code IS NULL");
				}
				else {
					query.append("staff_code = ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("staff_code ASC, ");
					query.append("scanner_code ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (staffCode != null) {
					qPos.add(staffCode);
				}

				list = (List<ProgateOrganizationsStaffs>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProgateOrganizationsStaffs>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_STAFFCODE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProgateOrganizationsStaffs findBystaffCode_First(String staffCode,
		OrderByComparator obc)
		throws NoSuchProgateOrganizationsStaffsException, SystemException {
		List<ProgateOrganizationsStaffs> list = findBystaffCode(staffCode, 0,
				1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProgateOrganizationsStaffs exists with the key {");

			msg.append("staffCode=" + staffCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProgateOrganizationsStaffsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProgateOrganizationsStaffs findBystaffCode_Last(String staffCode,
		OrderByComparator obc)
		throws NoSuchProgateOrganizationsStaffsException, SystemException {
		int count = countBystaffCode(staffCode);

		List<ProgateOrganizationsStaffs> list = findBystaffCode(staffCode,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProgateOrganizationsStaffs exists with the key {");

			msg.append("staffCode=" + staffCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProgateOrganizationsStaffsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProgateOrganizationsStaffs[] findBystaffCode_PrevAndNext(
		Integer ProgateOrganizationsStaffsId, String staffCode,
		OrderByComparator obc)
		throws NoSuchProgateOrganizationsStaffsException, SystemException {
		ProgateOrganizationsStaffs progateOrganizationsStaffs = findByPrimaryKey(ProgateOrganizationsStaffsId);

		int count = countBystaffCode(staffCode);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProgateOrganizationsStaffs WHERE ");

			if (staffCode == null) {
				query.append("staff_code IS NULL");
			}
			else {
				query.append("staff_code = ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("staff_code ASC, ");
				query.append("scanner_code ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (staffCode != null) {
				qPos.add(staffCode);
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					progateOrganizationsStaffs);

			ProgateOrganizationsStaffs[] array = new ProgateOrganizationsStaffsImpl[3];

			array[0] = (ProgateOrganizationsStaffs)objArray[0];
			array[1] = (ProgateOrganizationsStaffs)objArray[1];
			array[2] = (ProgateOrganizationsStaffs)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProgateOrganizationsStaffs> findByuserId(int userId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(userId) };

		List<ProgateOrganizationsStaffs> list = (List<ProgateOrganizationsStaffs>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_USERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProgateOrganizationsStaffs WHERE ");

				query.append("user_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("staff_code ASC, ");
				query.append("scanner_code ASC");

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
					list = new ArrayList<ProgateOrganizationsStaffs>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_USERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProgateOrganizationsStaffs> findByuserId(int userId, int start,
		int end) throws SystemException {
		return findByuserId(userId, start, end, null);
	}

	public List<ProgateOrganizationsStaffs> findByuserId(int userId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(userId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProgateOrganizationsStaffs> list = (List<ProgateOrganizationsStaffs>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_USERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProgateOrganizationsStaffs WHERE ");

				query.append("user_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("staff_code ASC, ");
					query.append("scanner_code ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				list = (List<ProgateOrganizationsStaffs>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProgateOrganizationsStaffs>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_USERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProgateOrganizationsStaffs findByuserId_First(int userId,
		OrderByComparator obc)
		throws NoSuchProgateOrganizationsStaffsException, SystemException {
		List<ProgateOrganizationsStaffs> list = findByuserId(userId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProgateOrganizationsStaffs exists with the key {");

			msg.append("userId=" + userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProgateOrganizationsStaffsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProgateOrganizationsStaffs findByuserId_Last(int userId,
		OrderByComparator obc)
		throws NoSuchProgateOrganizationsStaffsException, SystemException {
		int count = countByuserId(userId);

		List<ProgateOrganizationsStaffs> list = findByuserId(userId, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProgateOrganizationsStaffs exists with the key {");

			msg.append("userId=" + userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProgateOrganizationsStaffsException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProgateOrganizationsStaffs[] findByuserId_PrevAndNext(
		Integer ProgateOrganizationsStaffsId, int userId, OrderByComparator obc)
		throws NoSuchProgateOrganizationsStaffsException, SystemException {
		ProgateOrganizationsStaffs progateOrganizationsStaffs = findByPrimaryKey(ProgateOrganizationsStaffsId);

		int count = countByuserId(userId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProgateOrganizationsStaffs WHERE ");

			query.append("user_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("staff_code ASC, ");
				query.append("scanner_code ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(userId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					progateOrganizationsStaffs);

			ProgateOrganizationsStaffs[] array = new ProgateOrganizationsStaffsImpl[3];

			array[0] = (ProgateOrganizationsStaffs)objArray[0];
			array[1] = (ProgateOrganizationsStaffs)objArray[1];
			array[2] = (ProgateOrganizationsStaffs)objArray[2];

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

	public List<ProgateOrganizationsStaffs> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<ProgateOrganizationsStaffs> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<ProgateOrganizationsStaffs> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProgateOrganizationsStaffs> list = (List<ProgateOrganizationsStaffs>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProgateOrganizationsStaffs ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("staff_code ASC, ");
					query.append("scanner_code ASC");
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<ProgateOrganizationsStaffs>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ProgateOrganizationsStaffs>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProgateOrganizationsStaffs>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByorgId(int orgId) throws SystemException {
		for (ProgateOrganizationsStaffs progateOrganizationsStaffs : findByorgId(
				orgId)) {
			remove(progateOrganizationsStaffs);
		}
	}

	public void removeByrootId(int rootId) throws SystemException {
		for (ProgateOrganizationsStaffs progateOrganizationsStaffs : findByrootId(
				rootId)) {
			remove(progateOrganizationsStaffs);
		}
	}

	public void removeBybodId(int bodId) throws SystemException {
		for (ProgateOrganizationsStaffs progateOrganizationsStaffs : findBybodId(
				bodId)) {
			remove(progateOrganizationsStaffs);
		}
	}

	public void removeByparticipantId(int participantId)
		throws SystemException {
		for (ProgateOrganizationsStaffs progateOrganizationsStaffs : findByparticipantId(
				participantId)) {
			remove(progateOrganizationsStaffs);
		}
	}

	public void removeByisActive(boolean isActive) throws SystemException {
		for (ProgateOrganizationsStaffs progateOrganizationsStaffs : findByisActive(
				isActive)) {
			remove(progateOrganizationsStaffs);
		}
	}

	public void removeByisRemoved(boolean isRemoved) throws SystemException {
		for (ProgateOrganizationsStaffs progateOrganizationsStaffs : findByisRemoved(
				isRemoved)) {
			remove(progateOrganizationsStaffs);
		}
	}

	public void removeByscannerCode(String scannerCode)
		throws SystemException {
		for (ProgateOrganizationsStaffs progateOrganizationsStaffs : findByscannerCode(
				scannerCode)) {
			remove(progateOrganizationsStaffs);
		}
	}

	public void removeBystaffCode(String staffCode) throws SystemException {
		for (ProgateOrganizationsStaffs progateOrganizationsStaffs : findBystaffCode(
				staffCode)) {
			remove(progateOrganizationsStaffs);
		}
	}

	public void removeByuserId(int userId) throws SystemException {
		for (ProgateOrganizationsStaffs progateOrganizationsStaffs : findByuserId(
				userId)) {
			remove(progateOrganizationsStaffs);
		}
	}

	public void removeAll() throws SystemException {
		for (ProgateOrganizationsStaffs progateOrganizationsStaffs : findAll()) {
			remove(progateOrganizationsStaffs);
		}
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
					"FROM larion.progate.model.ProgateOrganizationsStaffs WHERE ");

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

	public int countByrootId(int rootId) throws SystemException {
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
					"FROM larion.progate.model.ProgateOrganizationsStaffs WHERE ");

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

	public int countBybodId(int bodId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(bodId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_BODID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProgateOrganizationsStaffs WHERE ");

				query.append("bod_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(bodId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BODID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByparticipantId(int participantId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(participantId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PARTICIPANTID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProgateOrganizationsStaffs WHERE ");

				query.append("participant_id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(participantId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PARTICIPANTID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByisActive(boolean isActive) throws SystemException {
		Object[] finderArgs = new Object[] { Boolean.valueOf(isActive) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ISACTIVE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProgateOrganizationsStaffs WHERE ");

				query.append("is_active = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isActive);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ISACTIVE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByisRemoved(boolean isRemoved) throws SystemException {
		Object[] finderArgs = new Object[] { Boolean.valueOf(isRemoved) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ISREMOVED,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProgateOrganizationsStaffs WHERE ");

				query.append("is_removed = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isRemoved);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ISREMOVED,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByscannerCode(String scannerCode) throws SystemException {
		Object[] finderArgs = new Object[] { scannerCode };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_SCANNERCODE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProgateOrganizationsStaffs WHERE ");

				if (scannerCode == null) {
					query.append("scanner_code IS NULL");
				}
				else {
					query.append("scanner_code = ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (scannerCode != null) {
					qPos.add(scannerCode);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SCANNERCODE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countBystaffCode(String staffCode) throws SystemException {
		Object[] finderArgs = new Object[] { staffCode };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_STAFFCODE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProgateOrganizationsStaffs WHERE ");

				if (staffCode == null) {
					query.append("staff_code IS NULL");
				}
				else {
					query.append("staff_code = ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (staffCode != null) {
					qPos.add(staffCode);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STAFFCODE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
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
					"FROM larion.progate.model.ProgateOrganizationsStaffs WHERE ");

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

	public int countAll() throws SystemException {
		Object[] finderArgs = new Object[0];

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(
						"SELECT COUNT(*) FROM larion.progate.model.ProgateOrganizationsStaffs");

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
						"value.object.listener.larion.progate.model.ProgateOrganizationsStaffs")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ProgateOrganizationsStaffs>> listenersList = new ArrayList<ModelListener<ProgateOrganizationsStaffs>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ProgateOrganizationsStaffs>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(ProgateOrganizationsStaffsPersistenceImpl.class);
}