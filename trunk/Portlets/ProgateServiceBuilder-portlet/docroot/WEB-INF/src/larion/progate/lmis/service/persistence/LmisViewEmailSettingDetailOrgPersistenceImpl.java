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

import larion.progate.lmis.NoSuchLmisViewEmailSettingDetailOrgException;
import larion.progate.lmis.model.LmisViewEmailSettingDetailOrg;
import larion.progate.lmis.model.impl.LmisViewEmailSettingDetailOrgImpl;
import larion.progate.lmis.model.impl.LmisViewEmailSettingDetailOrgModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="LmisViewEmailSettingDetailOrgPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewEmailSettingDetailOrgPersistenceImpl
	extends BasePersistenceImpl
	implements LmisViewEmailSettingDetailOrgPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = LmisViewEmailSettingDetailOrgImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_EMAILTYPE = new FinderPath(LmisViewEmailSettingDetailOrgModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewEmailSettingDetailOrgModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByEmailType",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_EMAILTYPE = new FinderPath(LmisViewEmailSettingDetailOrgModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewEmailSettingDetailOrgModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByEmailType",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_EMAILTYPE = new FinderPath(LmisViewEmailSettingDetailOrgModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewEmailSettingDetailOrgModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByEmailType",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ROOTID = new FinderPath(LmisViewEmailSettingDetailOrgModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewEmailSettingDetailOrgModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ROOTID = new FinderPath(LmisViewEmailSettingDetailOrgModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewEmailSettingDetailOrgModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByRootID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ROOTID = new FinderPath(LmisViewEmailSettingDetailOrgModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewEmailSettingDetailOrgModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByRootID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ID = new FinderPath(LmisViewEmailSettingDetailOrgModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewEmailSettingDetailOrgModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ID = new FinderPath(LmisViewEmailSettingDetailOrgModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewEmailSettingDetailOrgModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByID",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ID = new FinderPath(LmisViewEmailSettingDetailOrgModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewEmailSettingDetailOrgModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByID",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_CATEGORY = new FinderPath(LmisViewEmailSettingDetailOrgModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewEmailSettingDetailOrgModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByCategory",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_CATEGORY = new FinderPath(LmisViewEmailSettingDetailOrgModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewEmailSettingDetailOrgModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByCategory",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORY = new FinderPath(LmisViewEmailSettingDetailOrgModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewEmailSettingDetailOrgModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByCategory",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_EMAILNAME = new FinderPath(LmisViewEmailSettingDetailOrgModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewEmailSettingDetailOrgModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByEmailName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_EMAILNAME = new FinderPath(LmisViewEmailSettingDetailOrgModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewEmailSettingDetailOrgModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByEmailName",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_EMAILNAME = new FinderPath(LmisViewEmailSettingDetailOrgModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewEmailSettingDetailOrgModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByEmailName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(LmisViewEmailSettingDetailOrgModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewEmailSettingDetailOrgModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LmisViewEmailSettingDetailOrgModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewEmailSettingDetailOrgModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(
		LmisViewEmailSettingDetailOrg lmisViewEmailSettingDetailOrg) {
		EntityCacheUtil.putResult(LmisViewEmailSettingDetailOrgModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewEmailSettingDetailOrgImpl.class,
			lmisViewEmailSettingDetailOrg.getPrimaryKey(),
			lmisViewEmailSettingDetailOrg);
	}

	public void cacheResult(
		List<LmisViewEmailSettingDetailOrg> lmisViewEmailSettingDetailOrgs) {
		for (LmisViewEmailSettingDetailOrg lmisViewEmailSettingDetailOrg : lmisViewEmailSettingDetailOrgs) {
			if (EntityCacheUtil.getResult(
						LmisViewEmailSettingDetailOrgModelImpl.ENTITY_CACHE_ENABLED,
						LmisViewEmailSettingDetailOrgImpl.class,
						lmisViewEmailSettingDetailOrg.getPrimaryKey(), this) == null) {
				cacheResult(lmisViewEmailSettingDetailOrg);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(LmisViewEmailSettingDetailOrgImpl.class.getName());
		EntityCacheUtil.clearCache(LmisViewEmailSettingDetailOrgImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public LmisViewEmailSettingDetailOrg create(Integer orgRelatedId) {
		LmisViewEmailSettingDetailOrg lmisViewEmailSettingDetailOrg = new LmisViewEmailSettingDetailOrgImpl();

		lmisViewEmailSettingDetailOrg.setNew(true);
		lmisViewEmailSettingDetailOrg.setPrimaryKey(orgRelatedId);

		return lmisViewEmailSettingDetailOrg;
	}

	public LmisViewEmailSettingDetailOrg remove(Integer orgRelatedId)
		throws NoSuchLmisViewEmailSettingDetailOrgException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LmisViewEmailSettingDetailOrg lmisViewEmailSettingDetailOrg = (LmisViewEmailSettingDetailOrg)session.get(LmisViewEmailSettingDetailOrgImpl.class,
					orgRelatedId);

			if (lmisViewEmailSettingDetailOrg == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No LmisViewEmailSettingDetailOrg exists with the primary key " +
						orgRelatedId);
				}

				throw new NoSuchLmisViewEmailSettingDetailOrgException(
					"No LmisViewEmailSettingDetailOrg exists with the primary key " +
					orgRelatedId);
			}

			return remove(lmisViewEmailSettingDetailOrg);
		}
		catch (NoSuchLmisViewEmailSettingDetailOrgException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public LmisViewEmailSettingDetailOrg remove(
		LmisViewEmailSettingDetailOrg lmisViewEmailSettingDetailOrg)
		throws SystemException {
		for (ModelListener<LmisViewEmailSettingDetailOrg> listener : listeners) {
			listener.onBeforeRemove(lmisViewEmailSettingDetailOrg);
		}

		lmisViewEmailSettingDetailOrg = removeImpl(lmisViewEmailSettingDetailOrg);

		for (ModelListener<LmisViewEmailSettingDetailOrg> listener : listeners) {
			listener.onAfterRemove(lmisViewEmailSettingDetailOrg);
		}

		return lmisViewEmailSettingDetailOrg;
	}

	protected LmisViewEmailSettingDetailOrg removeImpl(
		LmisViewEmailSettingDetailOrg lmisViewEmailSettingDetailOrg)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (lmisViewEmailSettingDetailOrg.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(LmisViewEmailSettingDetailOrgImpl.class,
						lmisViewEmailSettingDetailOrg.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(lmisViewEmailSettingDetailOrg);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(LmisViewEmailSettingDetailOrgModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewEmailSettingDetailOrgImpl.class,
			lmisViewEmailSettingDetailOrg.getPrimaryKey());

		return lmisViewEmailSettingDetailOrg;
	}

	public LmisViewEmailSettingDetailOrg update(
		LmisViewEmailSettingDetailOrg lmisViewEmailSettingDetailOrg)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(LmisViewEmailSettingDetailOrg lmisViewEmailSettingDetailOrg) method. Use update(LmisViewEmailSettingDetailOrg lmisViewEmailSettingDetailOrg, boolean merge) instead.");
		}

		return update(lmisViewEmailSettingDetailOrg, false);
	}

	public LmisViewEmailSettingDetailOrg update(
		LmisViewEmailSettingDetailOrg lmisViewEmailSettingDetailOrg,
		boolean merge) throws SystemException {
		boolean isNew = lmisViewEmailSettingDetailOrg.isNew();

		for (ModelListener<LmisViewEmailSettingDetailOrg> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(lmisViewEmailSettingDetailOrg);
			}
			else {
				listener.onBeforeUpdate(lmisViewEmailSettingDetailOrg);
			}
		}

		lmisViewEmailSettingDetailOrg = updateImpl(lmisViewEmailSettingDetailOrg,
				merge);

		for (ModelListener<LmisViewEmailSettingDetailOrg> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(lmisViewEmailSettingDetailOrg);
			}
			else {
				listener.onAfterUpdate(lmisViewEmailSettingDetailOrg);
			}
		}

		return lmisViewEmailSettingDetailOrg;
	}

	public LmisViewEmailSettingDetailOrg updateImpl(
		larion.progate.lmis.model.LmisViewEmailSettingDetailOrg lmisViewEmailSettingDetailOrg,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, lmisViewEmailSettingDetailOrg,
				merge);

			lmisViewEmailSettingDetailOrg.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(LmisViewEmailSettingDetailOrgModelImpl.ENTITY_CACHE_ENABLED,
			LmisViewEmailSettingDetailOrgImpl.class,
			lmisViewEmailSettingDetailOrg.getPrimaryKey(),
			lmisViewEmailSettingDetailOrg);

		return lmisViewEmailSettingDetailOrg;
	}

	public LmisViewEmailSettingDetailOrg findByPrimaryKey(Integer orgRelatedId)
		throws NoSuchLmisViewEmailSettingDetailOrgException, SystemException {
		LmisViewEmailSettingDetailOrg lmisViewEmailSettingDetailOrg = fetchByPrimaryKey(orgRelatedId);

		if (lmisViewEmailSettingDetailOrg == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"No LmisViewEmailSettingDetailOrg exists with the primary key " +
					orgRelatedId);
			}

			throw new NoSuchLmisViewEmailSettingDetailOrgException(
				"No LmisViewEmailSettingDetailOrg exists with the primary key " +
				orgRelatedId);
		}

		return lmisViewEmailSettingDetailOrg;
	}

	public LmisViewEmailSettingDetailOrg fetchByPrimaryKey(Integer orgRelatedId)
		throws SystemException {
		LmisViewEmailSettingDetailOrg lmisViewEmailSettingDetailOrg = (LmisViewEmailSettingDetailOrg)EntityCacheUtil.getResult(LmisViewEmailSettingDetailOrgModelImpl.ENTITY_CACHE_ENABLED,
				LmisViewEmailSettingDetailOrgImpl.class, orgRelatedId, this);

		if (lmisViewEmailSettingDetailOrg == null) {
			Session session = null;

			try {
				session = openSession();

				lmisViewEmailSettingDetailOrg = (LmisViewEmailSettingDetailOrg)session.get(LmisViewEmailSettingDetailOrgImpl.class,
						orgRelatedId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (lmisViewEmailSettingDetailOrg != null) {
					cacheResult(lmisViewEmailSettingDetailOrg);
				}

				closeSession(session);
			}
		}

		return lmisViewEmailSettingDetailOrg;
	}

	public List<LmisViewEmailSettingDetailOrg> findByEmailType(String emailType)
		throws SystemException {
		Object[] finderArgs = new Object[] { emailType };

		List<LmisViewEmailSettingDetailOrg> list = (List<LmisViewEmailSettingDetailOrg>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_EMAILTYPE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewEmailSettingDetailOrg WHERE ");

				if (emailType == null) {
					query.append("email_type LIKE null");
				}
				else {
					query.append("email_type LIKE ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (emailType != null) {
					qPos.add(emailType);
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewEmailSettingDetailOrg>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_EMAILTYPE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewEmailSettingDetailOrg> findByEmailType(
		String emailType, int start, int end) throws SystemException {
		return findByEmailType(emailType, start, end, null);
	}

	public List<LmisViewEmailSettingDetailOrg> findByEmailType(
		String emailType, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				emailType,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewEmailSettingDetailOrg> list = (List<LmisViewEmailSettingDetailOrg>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_EMAILTYPE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewEmailSettingDetailOrg WHERE ");

				if (emailType == null) {
					query.append("email_type LIKE null");
				}
				else {
					query.append("email_type LIKE ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (emailType != null) {
					qPos.add(emailType);
				}

				list = (List<LmisViewEmailSettingDetailOrg>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewEmailSettingDetailOrg>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_EMAILTYPE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewEmailSettingDetailOrg findByEmailType_First(
		String emailType, OrderByComparator obc)
		throws NoSuchLmisViewEmailSettingDetailOrgException, SystemException {
		List<LmisViewEmailSettingDetailOrg> list = findByEmailType(emailType,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewEmailSettingDetailOrg exists with the key {");

			msg.append("emailType=" + emailType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewEmailSettingDetailOrgException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewEmailSettingDetailOrg findByEmailType_Last(
		String emailType, OrderByComparator obc)
		throws NoSuchLmisViewEmailSettingDetailOrgException, SystemException {
		int count = countByEmailType(emailType);

		List<LmisViewEmailSettingDetailOrg> list = findByEmailType(emailType,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewEmailSettingDetailOrg exists with the key {");

			msg.append("emailType=" + emailType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewEmailSettingDetailOrgException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewEmailSettingDetailOrg[] findByEmailType_PrevAndNext(
		Integer orgRelatedId, String emailType, OrderByComparator obc)
		throws NoSuchLmisViewEmailSettingDetailOrgException, SystemException {
		LmisViewEmailSettingDetailOrg lmisViewEmailSettingDetailOrg = findByPrimaryKey(orgRelatedId);

		int count = countByEmailType(emailType);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewEmailSettingDetailOrg WHERE ");

			if (emailType == null) {
				query.append("email_type LIKE null");
			}
			else {
				query.append("email_type LIKE ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (emailType != null) {
				qPos.add(emailType);
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisViewEmailSettingDetailOrg);

			LmisViewEmailSettingDetailOrg[] array = new LmisViewEmailSettingDetailOrgImpl[3];

			array[0] = (LmisViewEmailSettingDetailOrg)objArray[0];
			array[1] = (LmisViewEmailSettingDetailOrg)objArray[1];
			array[2] = (LmisViewEmailSettingDetailOrg)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewEmailSettingDetailOrg> findByRootID(int rootId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		List<LmisViewEmailSettingDetailOrg> list = (List<LmisViewEmailSettingDetailOrg>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewEmailSettingDetailOrg WHERE ");

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
					list = new ArrayList<LmisViewEmailSettingDetailOrg>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewEmailSettingDetailOrg> findByRootID(int rootId,
		int start, int end) throws SystemException {
		return findByRootID(rootId, start, end, null);
	}

	public List<LmisViewEmailSettingDetailOrg> findByRootID(int rootId,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(rootId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewEmailSettingDetailOrg> list = (List<LmisViewEmailSettingDetailOrg>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewEmailSettingDetailOrg WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rootId);

				list = (List<LmisViewEmailSettingDetailOrg>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewEmailSettingDetailOrg>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewEmailSettingDetailOrg findByRootID_First(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisViewEmailSettingDetailOrgException, SystemException {
		List<LmisViewEmailSettingDetailOrg> list = findByRootID(rootId, 0, 1,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewEmailSettingDetailOrg exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewEmailSettingDetailOrgException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewEmailSettingDetailOrg findByRootID_Last(int rootId,
		OrderByComparator obc)
		throws NoSuchLmisViewEmailSettingDetailOrgException, SystemException {
		int count = countByRootID(rootId);

		List<LmisViewEmailSettingDetailOrg> list = findByRootID(rootId,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewEmailSettingDetailOrg exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewEmailSettingDetailOrgException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewEmailSettingDetailOrg[] findByRootID_PrevAndNext(
		Integer orgRelatedId, int rootId, OrderByComparator obc)
		throws NoSuchLmisViewEmailSettingDetailOrgException, SystemException {
		LmisViewEmailSettingDetailOrg lmisViewEmailSettingDetailOrg = findByPrimaryKey(orgRelatedId);

		int count = countByRootID(rootId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewEmailSettingDetailOrg WHERE ");

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
					lmisViewEmailSettingDetailOrg);

			LmisViewEmailSettingDetailOrg[] array = new LmisViewEmailSettingDetailOrgImpl[3];

			array[0] = (LmisViewEmailSettingDetailOrg)objArray[0];
			array[1] = (LmisViewEmailSettingDetailOrg)objArray[1];
			array[2] = (LmisViewEmailSettingDetailOrg)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewEmailSettingDetailOrg> findByID(int id_)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(id_) };

		List<LmisViewEmailSettingDetailOrg> list = (List<LmisViewEmailSettingDetailOrg>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewEmailSettingDetailOrg WHERE ");

				query.append("id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewEmailSettingDetailOrg>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ID, finderArgs,
					list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewEmailSettingDetailOrg> findByID(int id_, int start,
		int end) throws SystemException {
		return findByID(id_, start, end, null);
	}

	public List<LmisViewEmailSettingDetailOrg> findByID(int id_, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(id_),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewEmailSettingDetailOrg> list = (List<LmisViewEmailSettingDetailOrg>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewEmailSettingDetailOrg WHERE ");

				query.append("id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_);

				list = (List<LmisViewEmailSettingDetailOrg>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewEmailSettingDetailOrg>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewEmailSettingDetailOrg findByID_First(int id_,
		OrderByComparator obc)
		throws NoSuchLmisViewEmailSettingDetailOrgException, SystemException {
		List<LmisViewEmailSettingDetailOrg> list = findByID(id_, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewEmailSettingDetailOrg exists with the key {");

			msg.append("id_=" + id_);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewEmailSettingDetailOrgException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewEmailSettingDetailOrg findByID_Last(int id_,
		OrderByComparator obc)
		throws NoSuchLmisViewEmailSettingDetailOrgException, SystemException {
		int count = countByID(id_);

		List<LmisViewEmailSettingDetailOrg> list = findByID(id_, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewEmailSettingDetailOrg exists with the key {");

			msg.append("id_=" + id_);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewEmailSettingDetailOrgException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewEmailSettingDetailOrg[] findByID_PrevAndNext(
		Integer orgRelatedId, int id_, OrderByComparator obc)
		throws NoSuchLmisViewEmailSettingDetailOrgException, SystemException {
		LmisViewEmailSettingDetailOrg lmisViewEmailSettingDetailOrg = findByPrimaryKey(orgRelatedId);

		int count = countByID(id_);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewEmailSettingDetailOrg WHERE ");

			query.append("id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(id_);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisViewEmailSettingDetailOrg);

			LmisViewEmailSettingDetailOrg[] array = new LmisViewEmailSettingDetailOrgImpl[3];

			array[0] = (LmisViewEmailSettingDetailOrg)objArray[0];
			array[1] = (LmisViewEmailSettingDetailOrg)objArray[1];
			array[2] = (LmisViewEmailSettingDetailOrg)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewEmailSettingDetailOrg> findByCategory(int category)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(category) };

		List<LmisViewEmailSettingDetailOrg> list = (List<LmisViewEmailSettingDetailOrg>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_CATEGORY,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewEmailSettingDetailOrg WHERE ");

				query.append("category = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(category);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewEmailSettingDetailOrg>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_CATEGORY,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewEmailSettingDetailOrg> findByCategory(int category,
		int start, int end) throws SystemException {
		return findByCategory(category, start, end, null);
	}

	public List<LmisViewEmailSettingDetailOrg> findByCategory(int category,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(category),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewEmailSettingDetailOrg> list = (List<LmisViewEmailSettingDetailOrg>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_CATEGORY,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewEmailSettingDetailOrg WHERE ");

				query.append("category = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(category);

				list = (List<LmisViewEmailSettingDetailOrg>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewEmailSettingDetailOrg>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_CATEGORY,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewEmailSettingDetailOrg findByCategory_First(int category,
		OrderByComparator obc)
		throws NoSuchLmisViewEmailSettingDetailOrgException, SystemException {
		List<LmisViewEmailSettingDetailOrg> list = findByCategory(category, 0,
				1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewEmailSettingDetailOrg exists with the key {");

			msg.append("category=" + category);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewEmailSettingDetailOrgException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewEmailSettingDetailOrg findByCategory_Last(int category,
		OrderByComparator obc)
		throws NoSuchLmisViewEmailSettingDetailOrgException, SystemException {
		int count = countByCategory(category);

		List<LmisViewEmailSettingDetailOrg> list = findByCategory(category,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewEmailSettingDetailOrg exists with the key {");

			msg.append("category=" + category);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewEmailSettingDetailOrgException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewEmailSettingDetailOrg[] findByCategory_PrevAndNext(
		Integer orgRelatedId, int category, OrderByComparator obc)
		throws NoSuchLmisViewEmailSettingDetailOrgException, SystemException {
		LmisViewEmailSettingDetailOrg lmisViewEmailSettingDetailOrg = findByPrimaryKey(orgRelatedId);

		int count = countByCategory(category);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewEmailSettingDetailOrg WHERE ");

			query.append("category = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(category);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					lmisViewEmailSettingDetailOrg);

			LmisViewEmailSettingDetailOrg[] array = new LmisViewEmailSettingDetailOrgImpl[3];

			array[0] = (LmisViewEmailSettingDetailOrg)objArray[0];
			array[1] = (LmisViewEmailSettingDetailOrg)objArray[1];
			array[2] = (LmisViewEmailSettingDetailOrg)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<LmisViewEmailSettingDetailOrg> findByEmailName(String name)
		throws SystemException {
		Object[] finderArgs = new Object[] { name };

		List<LmisViewEmailSettingDetailOrg> list = (List<LmisViewEmailSettingDetailOrg>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_EMAILNAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewEmailSettingDetailOrg WHERE ");

				if (name == null) {
					query.append("email_name LIKE null");
				}
				else {
					query.append("email_name LIKE ?");
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
					list = new ArrayList<LmisViewEmailSettingDetailOrg>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_EMAILNAME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<LmisViewEmailSettingDetailOrg> findByEmailName(String name,
		int start, int end) throws SystemException {
		return findByEmailName(name, start, end, null);
	}

	public List<LmisViewEmailSettingDetailOrg> findByEmailName(String name,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				name,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewEmailSettingDetailOrg> list = (List<LmisViewEmailSettingDetailOrg>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_EMAILNAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewEmailSettingDetailOrg WHERE ");

				if (name == null) {
					query.append("email_name LIKE null");
				}
				else {
					query.append("email_name LIKE ?");
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

				list = (List<LmisViewEmailSettingDetailOrg>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewEmailSettingDetailOrg>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_EMAILNAME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public LmisViewEmailSettingDetailOrg findByEmailName_First(String name,
		OrderByComparator obc)
		throws NoSuchLmisViewEmailSettingDetailOrgException, SystemException {
		List<LmisViewEmailSettingDetailOrg> list = findByEmailName(name, 0, 1,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewEmailSettingDetailOrg exists with the key {");

			msg.append("name=" + name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewEmailSettingDetailOrgException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewEmailSettingDetailOrg findByEmailName_Last(String name,
		OrderByComparator obc)
		throws NoSuchLmisViewEmailSettingDetailOrgException, SystemException {
		int count = countByEmailName(name);

		List<LmisViewEmailSettingDetailOrg> list = findByEmailName(name,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No LmisViewEmailSettingDetailOrg exists with the key {");

			msg.append("name=" + name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLmisViewEmailSettingDetailOrgException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public LmisViewEmailSettingDetailOrg[] findByEmailName_PrevAndNext(
		Integer orgRelatedId, String name, OrderByComparator obc)
		throws NoSuchLmisViewEmailSettingDetailOrgException, SystemException {
		LmisViewEmailSettingDetailOrg lmisViewEmailSettingDetailOrg = findByPrimaryKey(orgRelatedId);

		int count = countByEmailName(name);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.lmis.model.LmisViewEmailSettingDetailOrg WHERE ");

			if (name == null) {
				query.append("email_name LIKE null");
			}
			else {
				query.append("email_name LIKE ?");
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
					lmisViewEmailSettingDetailOrg);

			LmisViewEmailSettingDetailOrg[] array = new LmisViewEmailSettingDetailOrgImpl[3];

			array[0] = (LmisViewEmailSettingDetailOrg)objArray[0];
			array[1] = (LmisViewEmailSettingDetailOrg)objArray[1];
			array[2] = (LmisViewEmailSettingDetailOrg)objArray[2];

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

	public List<LmisViewEmailSettingDetailOrg> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<LmisViewEmailSettingDetailOrg> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<LmisViewEmailSettingDetailOrg> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<LmisViewEmailSettingDetailOrg> list = (List<LmisViewEmailSettingDetailOrg>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.lmis.model.LmisViewEmailSettingDetailOrg ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<LmisViewEmailSettingDetailOrg>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LmisViewEmailSettingDetailOrg>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<LmisViewEmailSettingDetailOrg>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByEmailType(String emailType) throws SystemException {
		for (LmisViewEmailSettingDetailOrg lmisViewEmailSettingDetailOrg : findByEmailType(
				emailType)) {
			remove(lmisViewEmailSettingDetailOrg);
		}
	}

	public void removeByRootID(int rootId) throws SystemException {
		for (LmisViewEmailSettingDetailOrg lmisViewEmailSettingDetailOrg : findByRootID(
				rootId)) {
			remove(lmisViewEmailSettingDetailOrg);
		}
	}

	public void removeByID(int id_) throws SystemException {
		for (LmisViewEmailSettingDetailOrg lmisViewEmailSettingDetailOrg : findByID(
				id_)) {
			remove(lmisViewEmailSettingDetailOrg);
		}
	}

	public void removeByCategory(int category) throws SystemException {
		for (LmisViewEmailSettingDetailOrg lmisViewEmailSettingDetailOrg : findByCategory(
				category)) {
			remove(lmisViewEmailSettingDetailOrg);
		}
	}

	public void removeByEmailName(String name) throws SystemException {
		for (LmisViewEmailSettingDetailOrg lmisViewEmailSettingDetailOrg : findByEmailName(
				name)) {
			remove(lmisViewEmailSettingDetailOrg);
		}
	}

	public void removeAll() throws SystemException {
		for (LmisViewEmailSettingDetailOrg lmisViewEmailSettingDetailOrg : findAll()) {
			remove(lmisViewEmailSettingDetailOrg);
		}
	}

	public int countByEmailType(String emailType) throws SystemException {
		Object[] finderArgs = new Object[] { emailType };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_EMAILTYPE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisViewEmailSettingDetailOrg WHERE ");

				if (emailType == null) {
					query.append("email_type LIKE null");
				}
				else {
					query.append("email_type LIKE ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (emailType != null) {
					qPos.add(emailType);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMAILTYPE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
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
					"FROM larion.progate.lmis.model.LmisViewEmailSettingDetailOrg WHERE ");

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

	public int countByID(int id_) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(id_) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisViewEmailSettingDetailOrg WHERE ");

				query.append("id = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ID, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByCategory(int category) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(category) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CATEGORY,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisViewEmailSettingDetailOrg WHERE ");

				query.append("category = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(category);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CATEGORY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByEmailName(String name) throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_EMAILNAME,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.lmis.model.LmisViewEmailSettingDetailOrg WHERE ");

				if (name == null) {
					query.append("email_name LIKE null");
				}
				else {
					query.append("email_name LIKE ?");
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMAILNAME,
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
						"SELECT COUNT(*) FROM larion.progate.lmis.model.LmisViewEmailSettingDetailOrg");

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
						"value.object.listener.larion.progate.lmis.model.LmisViewEmailSettingDetailOrg")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LmisViewEmailSettingDetailOrg>> listenersList =
					new ArrayList<ModelListener<LmisViewEmailSettingDetailOrg>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LmisViewEmailSettingDetailOrg>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(LmisViewEmailSettingDetailOrgPersistenceImpl.class);
}