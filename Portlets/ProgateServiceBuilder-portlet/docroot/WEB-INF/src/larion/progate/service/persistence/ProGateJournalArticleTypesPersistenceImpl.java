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

import larion.progate.NoSuchProGateJournalArticleTypesException;

import larion.progate.model.ProGateJournalArticleTypes;
import larion.progate.model.impl.ProGateJournalArticleTypesImpl;
import larion.progate.model.impl.ProGateJournalArticleTypesModelImpl;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="ProGateJournalArticleTypesPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateJournalArticleTypesPersistenceImpl
	extends BasePersistenceImpl implements ProGateJournalArticleTypesPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = ProGateJournalArticleTypesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_NAME = new FinderPath(ProGateJournalArticleTypesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleTypesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByname",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_NAME = new FinderPath(ProGateJournalArticleTypesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleTypesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByname",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(ProGateJournalArticleTypesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleTypesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByname",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(ProGateJournalArticleTypesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleTypesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProGateJournalArticleTypesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleTypesModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(
		ProGateJournalArticleTypes proGateJournalArticleTypes) {
		EntityCacheUtil.putResult(ProGateJournalArticleTypesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleTypesImpl.class,
			proGateJournalArticleTypes.getPrimaryKey(),
			proGateJournalArticleTypes);
	}

	public void cacheResult(
		List<ProGateJournalArticleTypes> proGateJournalArticleTypeses) {
		for (ProGateJournalArticleTypes proGateJournalArticleTypes : proGateJournalArticleTypeses) {
			if (EntityCacheUtil.getResult(
						ProGateJournalArticleTypesModelImpl.ENTITY_CACHE_ENABLED,
						ProGateJournalArticleTypesImpl.class,
						proGateJournalArticleTypes.getPrimaryKey(), this) == null) {
				cacheResult(proGateJournalArticleTypes);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(ProGateJournalArticleTypesImpl.class.getName());
		EntityCacheUtil.clearCache(ProGateJournalArticleTypesImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public ProGateJournalArticleTypes create(Integer journalArticleTypesId) {
		ProGateJournalArticleTypes proGateJournalArticleTypes = new ProGateJournalArticleTypesImpl();

		proGateJournalArticleTypes.setNew(true);
		proGateJournalArticleTypes.setPrimaryKey(journalArticleTypesId);

		return proGateJournalArticleTypes;
	}

	public ProGateJournalArticleTypes remove(Integer journalArticleTypesId)
		throws NoSuchProGateJournalArticleTypesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ProGateJournalArticleTypes proGateJournalArticleTypes = (ProGateJournalArticleTypes)session.get(ProGateJournalArticleTypesImpl.class,
					journalArticleTypesId);

			if (proGateJournalArticleTypes == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No ProGateJournalArticleTypes exists with the primary key " +
						journalArticleTypesId);
				}

				throw new NoSuchProGateJournalArticleTypesException(
					"No ProGateJournalArticleTypes exists with the primary key " +
					journalArticleTypesId);
			}

			return remove(proGateJournalArticleTypes);
		}
		catch (NoSuchProGateJournalArticleTypesException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public ProGateJournalArticleTypes remove(
		ProGateJournalArticleTypes proGateJournalArticleTypes)
		throws SystemException {
		for (ModelListener<ProGateJournalArticleTypes> listener : listeners) {
			listener.onBeforeRemove(proGateJournalArticleTypes);
		}

		proGateJournalArticleTypes = removeImpl(proGateJournalArticleTypes);

		for (ModelListener<ProGateJournalArticleTypes> listener : listeners) {
			listener.onAfterRemove(proGateJournalArticleTypes);
		}

		return proGateJournalArticleTypes;
	}

	protected ProGateJournalArticleTypes removeImpl(
		ProGateJournalArticleTypes proGateJournalArticleTypes)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (proGateJournalArticleTypes.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(ProGateJournalArticleTypesImpl.class,
						proGateJournalArticleTypes.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(proGateJournalArticleTypes);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(ProGateJournalArticleTypesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleTypesImpl.class,
			proGateJournalArticleTypes.getPrimaryKey());

		return proGateJournalArticleTypes;
	}

	public ProGateJournalArticleTypes update(
		ProGateJournalArticleTypes proGateJournalArticleTypes)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(ProGateJournalArticleTypes proGateJournalArticleTypes) method. Use update(ProGateJournalArticleTypes proGateJournalArticleTypes, boolean merge) instead.");
		}

		return update(proGateJournalArticleTypes, false);
	}

	public ProGateJournalArticleTypes update(
		ProGateJournalArticleTypes proGateJournalArticleTypes, boolean merge)
		throws SystemException {
		boolean isNew = proGateJournalArticleTypes.isNew();

		for (ModelListener<ProGateJournalArticleTypes> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(proGateJournalArticleTypes);
			}
			else {
				listener.onBeforeUpdate(proGateJournalArticleTypes);
			}
		}

		proGateJournalArticleTypes = updateImpl(proGateJournalArticleTypes,
				merge);

		for (ModelListener<ProGateJournalArticleTypes> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(proGateJournalArticleTypes);
			}
			else {
				listener.onAfterUpdate(proGateJournalArticleTypes);
			}
		}

		return proGateJournalArticleTypes;
	}

	public ProGateJournalArticleTypes updateImpl(
		larion.progate.model.ProGateJournalArticleTypes proGateJournalArticleTypes,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, proGateJournalArticleTypes, merge);

			proGateJournalArticleTypes.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(ProGateJournalArticleTypesModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleTypesImpl.class,
			proGateJournalArticleTypes.getPrimaryKey(),
			proGateJournalArticleTypes);

		return proGateJournalArticleTypes;
	}

	public ProGateJournalArticleTypes findByPrimaryKey(
		Integer journalArticleTypesId)
		throws NoSuchProGateJournalArticleTypesException, SystemException {
		ProGateJournalArticleTypes proGateJournalArticleTypes = fetchByPrimaryKey(journalArticleTypesId);

		if (proGateJournalArticleTypes == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"No ProGateJournalArticleTypes exists with the primary key " +
					journalArticleTypesId);
			}

			throw new NoSuchProGateJournalArticleTypesException(
				"No ProGateJournalArticleTypes exists with the primary key " +
				journalArticleTypesId);
		}

		return proGateJournalArticleTypes;
	}

	public ProGateJournalArticleTypes fetchByPrimaryKey(
		Integer journalArticleTypesId) throws SystemException {
		ProGateJournalArticleTypes proGateJournalArticleTypes = (ProGateJournalArticleTypes)EntityCacheUtil.getResult(ProGateJournalArticleTypesModelImpl.ENTITY_CACHE_ENABLED,
				ProGateJournalArticleTypesImpl.class, journalArticleTypesId,
				this);

		if (proGateJournalArticleTypes == null) {
			Session session = null;

			try {
				session = openSession();

				proGateJournalArticleTypes = (ProGateJournalArticleTypes)session.get(ProGateJournalArticleTypesImpl.class,
						journalArticleTypesId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (proGateJournalArticleTypes != null) {
					cacheResult(proGateJournalArticleTypes);
				}

				closeSession(session);
			}
		}

		return proGateJournalArticleTypes;
	}

	public List<ProGateJournalArticleTypes> findByname(String name)
		throws SystemException {
		Object[] finderArgs = new Object[] { name };

		List<ProGateJournalArticleTypes> list = (List<ProGateJournalArticleTypes>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_NAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleTypes WHERE ");

				if (name == null) {
					query.append("name LIKE null");
				}
				else {
					query.append("name LIKE ?");
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
					list = new ArrayList<ProGateJournalArticleTypes>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_NAME, finderArgs,
					list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticleTypes> findByname(String name, int start,
		int end) throws SystemException {
		return findByname(name, start, end, null);
	}

	public List<ProGateJournalArticleTypes> findByname(String name, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				name,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticleTypes> list = (List<ProGateJournalArticleTypes>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_NAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleTypes WHERE ");

				if (name == null) {
					query.append("name LIKE null");
				}
				else {
					query.append("name LIKE ?");
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

				list = (List<ProGateJournalArticleTypes>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleTypes>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_NAME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticleTypes findByname_First(String name,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleTypesException, SystemException {
		List<ProGateJournalArticleTypes> list = findByname(name, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleTypes exists with the key {");

			msg.append("name=" + name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleTypesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleTypes findByname_Last(String name,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleTypesException, SystemException {
		int count = countByname(name);

		List<ProGateJournalArticleTypes> list = findByname(name, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleTypes exists with the key {");

			msg.append("name=" + name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleTypesException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleTypes[] findByname_PrevAndNext(
		Integer journalArticleTypesId, String name, OrderByComparator obc)
		throws NoSuchProGateJournalArticleTypesException, SystemException {
		ProGateJournalArticleTypes proGateJournalArticleTypes = findByPrimaryKey(journalArticleTypesId);

		int count = countByname(name);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticleTypes WHERE ");

			if (name == null) {
				query.append("name LIKE null");
			}
			else {
				query.append("name LIKE ?");
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
					proGateJournalArticleTypes);

			ProGateJournalArticleTypes[] array = new ProGateJournalArticleTypesImpl[3];

			array[0] = (ProGateJournalArticleTypes)objArray[0];
			array[1] = (ProGateJournalArticleTypes)objArray[1];
			array[2] = (ProGateJournalArticleTypes)objArray[2];

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

	public List<ProGateJournalArticleTypes> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<ProGateJournalArticleTypes> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<ProGateJournalArticleTypes> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticleTypes> list = (List<ProGateJournalArticleTypes>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleTypes ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<ProGateJournalArticleTypes>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ProGateJournalArticleTypes>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleTypes>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByname(String name) throws SystemException {
		for (ProGateJournalArticleTypes proGateJournalArticleTypes : findByname(
				name)) {
			remove(proGateJournalArticleTypes);
		}
	}

	public void removeAll() throws SystemException {
		for (ProGateJournalArticleTypes proGateJournalArticleTypes : findAll()) {
			remove(proGateJournalArticleTypes);
		}
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
					"FROM larion.progate.model.ProGateJournalArticleTypes WHERE ");

				if (name == null) {
					query.append("name LIKE null");
				}
				else {
					query.append("name LIKE ?");
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

	public int countAll() throws SystemException {
		Object[] finderArgs = new Object[0];

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(
						"SELECT COUNT(*) FROM larion.progate.model.ProGateJournalArticleTypes");

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

	public List<larion.progate.model.ProGateJournalArticle> getProGateJournalArticles(
		Integer pk) throws SystemException {
		return getProGateJournalArticles(pk, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS);
	}

	public List<larion.progate.model.ProGateJournalArticle> getProGateJournalArticles(
		Integer pk, int start, int end) throws SystemException {
		return getProGateJournalArticles(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_PROGATEJOURNALARTICLES = new FinderPath(larion.progate.model.impl.ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.model.impl.ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.service.persistence.ProGateJournalArticlePersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getProGateJournalArticles",
			new String[] {
				Integer.class.getName(), "java.lang.Integer",
				"java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	public List<larion.progate.model.ProGateJournalArticle> getProGateJournalArticles(
		Integer pk, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				pk, String.valueOf(start), String.valueOf(end),
				String.valueOf(obc)
			};

		List<larion.progate.model.ProGateJournalArticle> list = (List<larion.progate.model.ProGateJournalArticle>)FinderCacheUtil.getResult(FINDER_PATH_GET_PROGATEJOURNALARTICLES,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder sb = new StringBuilder();

				sb.append(_SQL_GETPROGATEJOURNALARTICLES);

				if (obc != null) {
					sb.append("ORDER BY ");
					sb.append(obc.getOrderBy());
				}

				else {
					sb.append("ORDER BY ");

					sb.append("progate_journalarticle.article_order ASC, ");
					sb.append("progate_journalarticle.updated_at DESC, ");
					sb.append("progate_journalarticle.priority DESC");
				}

				String sql = sb.toString();

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("progate_journalarticle",
					larion.progate.model.impl.ProGateJournalArticleImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<larion.progate.model.ProGateJournalArticle>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<larion.progate.model.ProGateJournalArticle>();
				}

				proGateJournalArticlePersistence.cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_GET_PROGATEJOURNALARTICLES,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_PROGATEJOURNALARTICLES_SIZE = new FinderPath(larion.progate.model.impl.ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.model.impl.ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.service.persistence.ProGateJournalArticlePersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getProGateJournalArticlesSize",
			new String[] { Integer.class.getName() });

	public int getProGateJournalArticlesSize(Integer pk)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_PROGATEJOURNALARTICLES_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETPROGATEJOURNALARTICLESSIZE);

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

				FinderCacheUtil.putResult(FINDER_PATH_GET_PROGATEJOURNALARTICLES_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_PROGATEJOURNALARTICLE = new FinderPath(larion.progate.model.impl.ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.model.impl.ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.service.persistence.ProGateJournalArticlePersistenceImpl.FINDER_CLASS_NAME_LIST,
			"containsProGateJournalArticle",
			new String[] { Integer.class.getName(), Integer.class.getName() });

	public boolean containsProGateJournalArticle(Integer pk,
		Integer proGateJournalArticlePK) throws SystemException {
		Object[] finderArgs = new Object[] { pk, proGateJournalArticlePK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_PROGATEJOURNALARTICLE,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsProGateJournalArticle.contains(
							pk, proGateJournalArticlePK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_PROGATEJOURNALARTICLE,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	public boolean containsProGateJournalArticles(Integer pk)
		throws SystemException {
		if (getProGateJournalArticlesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.larion.progate.model.ProGateJournalArticleTypes")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ProGateJournalArticleTypes>> listenersList = new ArrayList<ModelListener<ProGateJournalArticleTypes>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ProGateJournalArticleTypes>)Class.forName(
							listenerClassName).newInstance());
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		containsProGateJournalArticle = new ContainsProGateJournalArticle(this);
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
	protected ContainsProGateJournalArticle containsProGateJournalArticle;

	protected class ContainsProGateJournalArticle {
		protected ContainsProGateJournalArticle(
			ProGateJournalArticleTypesPersistenceImpl persistenceImpl) {
			super();

			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSPROGATEJOURNALARTICLE,
					new int[] { Types.INTEGER, Types.INTEGER }, RowMapper.COUNT);
		}

		protected boolean contains(Integer journalArticleTypesId,
			Integer journalArticleId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						journalArticleTypesId, journalArticleId
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

	private static final String _SQL_GETPROGATEJOURNALARTICLES = "SELECT {progate_journalarticle.*} FROM progate_journalarticle INNER JOIN progate_journalarticle_types ON (progate_journalarticle_types.journalArticleTypesId = progate_journalarticle.journalArticleTypesId) WHERE (progate_journalarticle_types.journalArticleTypesId = ?)";
	private static final String _SQL_GETPROGATEJOURNALARTICLESSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM progate_journalarticle WHERE journalArticleTypesId = ?";
	private static final String _SQL_CONTAINSPROGATEJOURNALARTICLE = "SELECT COUNT(*) AS COUNT_VALUE FROM progate_journalarticle WHERE journalArticleTypesId = ? AND journalArticleId = ?";
	private static Log _log = LogFactoryUtil.getLog(ProGateJournalArticleTypesPersistenceImpl.class);
}