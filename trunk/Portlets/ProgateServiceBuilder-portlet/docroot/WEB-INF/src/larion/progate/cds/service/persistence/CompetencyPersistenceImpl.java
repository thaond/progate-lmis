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

package larion.progate.cds.service.persistence;

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

import larion.progate.cds.NoSuchCompetencyException;
import larion.progate.cds.model.Competency;
import larion.progate.cds.model.impl.CompetencyImpl;
import larion.progate.cds.model.impl.CompetencyModelImpl;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="CompetencyPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CompetencyPersistenceImpl extends BasePersistenceImpl
	implements CompetencyPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = CompetencyImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_NAME = new FinderPath(CompetencyModelImpl.ENTITY_CACHE_ENABLED,
			CompetencyModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByname", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_NAME = new FinderPath(CompetencyModelImpl.ENTITY_CACHE_ENABLED,
			CompetencyModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByname",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(CompetencyModelImpl.ENTITY_CACHE_ENABLED,
			CompetencyModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByname", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ROOTID = new FinderPath(CompetencyModelImpl.ENTITY_CACHE_ENABLED,
			CompetencyModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByrootId", new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ROOTID = new FinderPath(CompetencyModelImpl.ENTITY_CACHE_ENABLED,
			CompetencyModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByrootId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ROOTID = new FinderPath(CompetencyModelImpl.ENTITY_CACHE_ENABLED,
			CompetencyModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByrootId", new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_NUMBERORDERGREATER = new FinderPath(CompetencyModelImpl.ENTITY_CACHE_ENABLED,
			CompetencyModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findBynumberOrderGreater", new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_NUMBERORDERGREATER = new FinderPath(CompetencyModelImpl.ENTITY_CACHE_ENABLED,
			CompetencyModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findBynumberOrderGreater",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_NUMBERORDERGREATER = new FinderPath(CompetencyModelImpl.ENTITY_CACHE_ENABLED,
			CompetencyModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countBynumberOrderGreater",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(CompetencyModelImpl.ENTITY_CACHE_ENABLED,
			CompetencyModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CompetencyModelImpl.ENTITY_CACHE_ENABLED,
			CompetencyModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	public void cacheResult(Competency competency) {
		EntityCacheUtil.putResult(CompetencyModelImpl.ENTITY_CACHE_ENABLED,
			CompetencyImpl.class, competency.getPrimaryKey(), competency);
	}

	public void cacheResult(List<Competency> competencies) {
		for (Competency competency : competencies) {
			if (EntityCacheUtil.getResult(
						CompetencyModelImpl.ENTITY_CACHE_ENABLED,
						CompetencyImpl.class, competency.getPrimaryKey(), this) == null) {
				cacheResult(competency);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(CompetencyImpl.class.getName());
		EntityCacheUtil.clearCache(CompetencyImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public Competency create(Integer competencyId) {
		Competency competency = new CompetencyImpl();

		competency.setNew(true);
		competency.setPrimaryKey(competencyId);

		return competency;
	}

	public Competency remove(Integer competencyId)
		throws NoSuchCompetencyException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Competency competency = (Competency)session.get(CompetencyImpl.class,
					competencyId);

			if (competency == null) {
				if (_log.isWarnEnabled()) {
					_log.warn("No Competency exists with the primary key " +
						competencyId);
				}

				throw new NoSuchCompetencyException(
					"No Competency exists with the primary key " +
					competencyId);
			}

			return remove(competency);
		}
		catch (NoSuchCompetencyException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public Competency remove(Competency competency) throws SystemException {
		for (ModelListener<Competency> listener : listeners) {
			listener.onBeforeRemove(competency);
		}

		competency = removeImpl(competency);

		for (ModelListener<Competency> listener : listeners) {
			listener.onAfterRemove(competency);
		}

		return competency;
	}

	protected Competency removeImpl(Competency competency)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (competency.isCachedModel() || BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(CompetencyImpl.class,
						competency.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(competency);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(CompetencyModelImpl.ENTITY_CACHE_ENABLED,
			CompetencyImpl.class, competency.getPrimaryKey());

		return competency;
	}

	public Competency update(Competency competency) throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(Competency competency) method. Use update(Competency competency, boolean merge) instead.");
		}

		return update(competency, false);
	}

	public Competency update(Competency competency, boolean merge)
		throws SystemException {
		boolean isNew = competency.isNew();

		for (ModelListener<Competency> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(competency);
			}
			else {
				listener.onBeforeUpdate(competency);
			}
		}

		competency = updateImpl(competency, merge);

		for (ModelListener<Competency> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(competency);
			}
			else {
				listener.onAfterUpdate(competency);
			}
		}

		return competency;
	}

	public Competency updateImpl(
		larion.progate.cds.model.Competency competency, boolean merge)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, competency, merge);

			competency.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(CompetencyModelImpl.ENTITY_CACHE_ENABLED,
			CompetencyImpl.class, competency.getPrimaryKey(), competency);

		return competency;
	}

	public Competency findByPrimaryKey(Integer competencyId)
		throws NoSuchCompetencyException, SystemException {
		Competency competency = fetchByPrimaryKey(competencyId);

		if (competency == null) {
			if (_log.isWarnEnabled()) {
				_log.warn("No Competency exists with the primary key " +
					competencyId);
			}

			throw new NoSuchCompetencyException(
				"No Competency exists with the primary key " + competencyId);
		}

		return competency;
	}

	public Competency fetchByPrimaryKey(Integer competencyId)
		throws SystemException {
		Competency competency = (Competency)EntityCacheUtil.getResult(CompetencyModelImpl.ENTITY_CACHE_ENABLED,
				CompetencyImpl.class, competencyId, this);

		if (competency == null) {
			Session session = null;

			try {
				session = openSession();

				competency = (Competency)session.get(CompetencyImpl.class,
						competencyId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (competency != null) {
					cacheResult(competency);
				}

				closeSession(session);
			}
		}

		return competency;
	}

	public List<Competency> findByname(String name) throws SystemException {
		Object[] finderArgs = new Object[] { name };

		List<Competency> list = (List<Competency>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_NAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.cds.model.Competency WHERE ");

				if (name == null) {
					query.append("name LIKE null");
				}
				else {
					query.append("name LIKE ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("number_order ASC");

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
					list = new ArrayList<Competency>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_NAME, finderArgs,
					list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<Competency> findByname(String name, int start, int end)
		throws SystemException {
		return findByname(name, start, end, null);
	}

	public List<Competency> findByname(String name, int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				name,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<Competency> list = (List<Competency>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_NAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.cds.model.Competency WHERE ");

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

				else {
					query.append("ORDER BY ");

					query.append("number_order ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (name != null) {
					qPos.add(name);
				}

				list = (List<Competency>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Competency>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_NAME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public Competency findByname_First(String name, OrderByComparator obc)
		throws NoSuchCompetencyException, SystemException {
		List<Competency> list = findByname(name, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No Competency exists with the key {");

			msg.append("name=" + name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCompetencyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public Competency findByname_Last(String name, OrderByComparator obc)
		throws NoSuchCompetencyException, SystemException {
		int count = countByname(name);

		List<Competency> list = findByname(name, count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No Competency exists with the key {");

			msg.append("name=" + name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCompetencyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public Competency[] findByname_PrevAndNext(Integer competencyId,
		String name, OrderByComparator obc)
		throws NoSuchCompetencyException, SystemException {
		Competency competency = findByPrimaryKey(competencyId);

		int count = countByname(name);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.cds.model.Competency WHERE ");

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

			else {
				query.append("ORDER BY ");

				query.append("number_order ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (name != null) {
				qPos.add(name);
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					competency);

			Competency[] array = new CompetencyImpl[3];

			array[0] = (Competency)objArray[0];
			array[1] = (Competency)objArray[1];
			array[2] = (Competency)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<Competency> findByrootId(int rootId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(rootId) };

		List<Competency> list = (List<Competency>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.cds.model.Competency WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("number_order ASC");

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
					list = new ArrayList<Competency>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<Competency> findByrootId(int rootId, int start, int end)
		throws SystemException {
		return findByrootId(rootId, start, end, null);
	}

	public List<Competency> findByrootId(int rootId, int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(rootId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<Competency> list = (List<Competency>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.cds.model.Competency WHERE ");

				query.append("root_id = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("number_order ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rootId);

				list = (List<Competency>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Competency>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ROOTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public Competency findByrootId_First(int rootId, OrderByComparator obc)
		throws NoSuchCompetencyException, SystemException {
		List<Competency> list = findByrootId(rootId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No Competency exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCompetencyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public Competency findByrootId_Last(int rootId, OrderByComparator obc)
		throws NoSuchCompetencyException, SystemException {
		int count = countByrootId(rootId);

		List<Competency> list = findByrootId(rootId, count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No Competency exists with the key {");

			msg.append("rootId=" + rootId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCompetencyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public Competency[] findByrootId_PrevAndNext(Integer competencyId,
		int rootId, OrderByComparator obc)
		throws NoSuchCompetencyException, SystemException {
		Competency competency = findByPrimaryKey(competencyId);

		int count = countByrootId(rootId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.cds.model.Competency WHERE ");

			query.append("root_id = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("number_order ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(rootId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					competency);

			Competency[] array = new CompetencyImpl[3];

			array[0] = (Competency)objArray[0];
			array[1] = (Competency)objArray[1];
			array[2] = (Competency)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<Competency> findBynumberOrderGreater(int numberOrder)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(numberOrder) };

		List<Competency> list = (List<Competency>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_NUMBERORDERGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.cds.model.Competency WHERE ");

				query.append("number_order > ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("number_order ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(numberOrder);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Competency>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_NUMBERORDERGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<Competency> findBynumberOrderGreater(int numberOrder,
		int start, int end) throws SystemException {
		return findBynumberOrderGreater(numberOrder, start, end, null);
	}

	public List<Competency> findBynumberOrderGreater(int numberOrder,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(numberOrder),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<Competency> list = (List<Competency>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_NUMBERORDERGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.cds.model.Competency WHERE ");

				query.append("number_order > ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("number_order ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(numberOrder);

				list = (List<Competency>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Competency>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_NUMBERORDERGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public Competency findBynumberOrderGreater_First(int numberOrder,
		OrderByComparator obc)
		throws NoSuchCompetencyException, SystemException {
		List<Competency> list = findBynumberOrderGreater(numberOrder, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No Competency exists with the key {");

			msg.append("numberOrder=" + numberOrder);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCompetencyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public Competency findBynumberOrderGreater_Last(int numberOrder,
		OrderByComparator obc)
		throws NoSuchCompetencyException, SystemException {
		int count = countBynumberOrderGreater(numberOrder);

		List<Competency> list = findBynumberOrderGreater(numberOrder,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No Competency exists with the key {");

			msg.append("numberOrder=" + numberOrder);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCompetencyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public Competency[] findBynumberOrderGreater_PrevAndNext(
		Integer competencyId, int numberOrder, OrderByComparator obc)
		throws NoSuchCompetencyException, SystemException {
		Competency competency = findByPrimaryKey(competencyId);

		int count = countBynumberOrderGreater(numberOrder);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("FROM larion.progate.cds.model.Competency WHERE ");

			query.append("number_order > ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("number_order ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(numberOrder);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					competency);

			Competency[] array = new CompetencyImpl[3];

			array[0] = (Competency)objArray[0];
			array[1] = (Competency)objArray[1];
			array[2] = (Competency)objArray[2];

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

	public List<Competency> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<Competency> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<Competency> findAll(int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<Competency> list = (List<Competency>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.cds.model.Competency ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("number_order ASC");
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<Competency>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Competency>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Competency>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByname(String name) throws SystemException {
		for (Competency competency : findByname(name)) {
			remove(competency);
		}
	}

	public void removeByrootId(int rootId) throws SystemException {
		for (Competency competency : findByrootId(rootId)) {
			remove(competency);
		}
	}

	public void removeBynumberOrderGreater(int numberOrder)
		throws SystemException {
		for (Competency competency : findBynumberOrderGreater(numberOrder)) {
			remove(competency);
		}
	}

	public void removeAll() throws SystemException {
		for (Competency competency : findAll()) {
			remove(competency);
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
				query.append("FROM larion.progate.cds.model.Competency WHERE ");

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
				query.append("FROM larion.progate.cds.model.Competency WHERE ");

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

	public int countBynumberOrderGreater(int numberOrder)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(numberOrder) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_NUMBERORDERGREATER,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append("FROM larion.progate.cds.model.Competency WHERE ");

				query.append("number_order > ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(numberOrder);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NUMBERORDERGREATER,
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
						"SELECT COUNT(*) FROM larion.progate.cds.model.Competency");

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

	public List<larion.progate.cds.model.Level> getLevels(Integer pk)
		throws SystemException {
		return getLevels(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public List<larion.progate.cds.model.Level> getLevels(Integer pk,
		int start, int end) throws SystemException {
		return getLevels(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_LEVELS = new FinderPath(larion.progate.cds.model.impl.LevelModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.cds.model.impl.LevelModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.cds.service.persistence.LevelPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getLevels",
			new String[] {
				Integer.class.getName(), "java.lang.Integer",
				"java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	public List<larion.progate.cds.model.Level> getLevels(Integer pk,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				pk, String.valueOf(start), String.valueOf(end),
				String.valueOf(obc)
			};

		List<larion.progate.cds.model.Level> list = (List<larion.progate.cds.model.Level>)FinderCacheUtil.getResult(FINDER_PATH_GET_LEVELS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder sb = new StringBuilder();

				sb.append(_SQL_GETLEVELS);

				if (obc != null) {
					sb.append("ORDER BY ");
					sb.append(obc.getOrderBy());
				}

				else {
					sb.append("ORDER BY ");

					sb.append("cds_levels.number_order ASC");
				}

				String sql = sb.toString();

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("cds_levels",
					larion.progate.cds.model.impl.LevelImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<larion.progate.cds.model.Level>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<larion.progate.cds.model.Level>();
				}

				levelPersistence.cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_GET_LEVELS, finderArgs,
					list);

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_LEVELS_SIZE = new FinderPath(larion.progate.cds.model.impl.LevelModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.cds.model.impl.LevelModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.cds.service.persistence.LevelPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getLevelsSize", new String[] { Integer.class.getName() });

	public int getLevelsSize(Integer pk) throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_LEVELS_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETLEVELSSIZE);

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

				FinderCacheUtil.putResult(FINDER_PATH_GET_LEVELS_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_LEVEL = new FinderPath(larion.progate.cds.model.impl.LevelModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.cds.model.impl.LevelModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.cds.service.persistence.LevelPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"containsLevel",
			new String[] { Integer.class.getName(), Integer.class.getName() });

	public boolean containsLevel(Integer pk, Integer levelPK)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk, levelPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_LEVEL,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsLevel.contains(pk, levelPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_LEVEL,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	public boolean containsLevels(Integer pk) throws SystemException {
		if (getLevelsSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public List<larion.progate.cds.model.CdsTitleCompetencies> getCdsTitleCompetencieses(
		Integer pk) throws SystemException {
		return getCdsTitleCompetencieses(pk, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS);
	}

	public List<larion.progate.cds.model.CdsTitleCompetencies> getCdsTitleCompetencieses(
		Integer pk, int start, int end) throws SystemException {
		return getCdsTitleCompetencieses(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_CDSTITLECOMPETENCIESES = new FinderPath(larion.progate.cds.model.impl.CdsTitleCompetenciesModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.cds.model.impl.CdsTitleCompetenciesModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.cds.service.persistence.CdsTitleCompetenciesPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getCdsTitleCompetencieses",
			new String[] {
				Integer.class.getName(), "java.lang.Integer",
				"java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	public List<larion.progate.cds.model.CdsTitleCompetencies> getCdsTitleCompetencieses(
		Integer pk, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				pk, String.valueOf(start), String.valueOf(end),
				String.valueOf(obc)
			};

		List<larion.progate.cds.model.CdsTitleCompetencies> list = (List<larion.progate.cds.model.CdsTitleCompetencies>)FinderCacheUtil.getResult(FINDER_PATH_GET_CDSTITLECOMPETENCIESES,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder sb = new StringBuilder();

				sb.append(_SQL_GETCDSTITLECOMPETENCIESES);

				if (obc != null) {
					sb.append("ORDER BY ");
					sb.append(obc.getOrderBy());
				}

				String sql = sb.toString();

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("cds_title_competencies",
					larion.progate.cds.model.impl.CdsTitleCompetenciesImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<larion.progate.cds.model.CdsTitleCompetencies>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<larion.progate.cds.model.CdsTitleCompetencies>();
				}

				cdsTitleCompetenciesPersistence.cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_GET_CDSTITLECOMPETENCIESES,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_CDSTITLECOMPETENCIESES_SIZE = new FinderPath(larion.progate.cds.model.impl.CdsTitleCompetenciesModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.cds.model.impl.CdsTitleCompetenciesModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.cds.service.persistence.CdsTitleCompetenciesPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getCdsTitleCompetenciesesSize",
			new String[] { Integer.class.getName() });

	public int getCdsTitleCompetenciesesSize(Integer pk)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_CDSTITLECOMPETENCIESES_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETCDSTITLECOMPETENCIESESSIZE);

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

				FinderCacheUtil.putResult(FINDER_PATH_GET_CDSTITLECOMPETENCIESES_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_CDSTITLECOMPETENCIES = new FinderPath(larion.progate.cds.model.impl.CdsTitleCompetenciesModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.cds.model.impl.CdsTitleCompetenciesModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.cds.service.persistence.CdsTitleCompetenciesPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"containsCdsTitleCompetencies",
			new String[] { Integer.class.getName(), Integer.class.getName() });

	public boolean containsCdsTitleCompetencies(Integer pk,
		Integer cdsTitleCompetenciesPK) throws SystemException {
		Object[] finderArgs = new Object[] { pk, cdsTitleCompetenciesPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_CDSTITLECOMPETENCIES,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsCdsTitleCompetencies.contains(
							pk, cdsTitleCompetenciesPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_CDSTITLECOMPETENCIES,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	public boolean containsCdsTitleCompetencieses(Integer pk)
		throws SystemException {
		if (getCdsTitleCompetenciesesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.larion.progate.cds.model.Competency")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Competency>> listenersList = new ArrayList<ModelListener<Competency>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Competency>)Class.forName(
							listenerClassName).newInstance());
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		containsLevel = new ContainsLevel(this);

		containsCdsTitleCompetencies = new ContainsCdsTitleCompetencies(this);
	}

	@BeanReference(name = "larion.progate.cds.service.persistence.CompetencyPersistence.impl")
	protected larion.progate.cds.service.persistence.CompetencyPersistence competencyPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.LevelPersistence.impl")
	protected larion.progate.cds.service.persistence.LevelPersistence levelPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.SlotPersistence.impl")
	protected larion.progate.cds.service.persistence.SlotPersistence slotPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPointsPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsPointsPersistence cdsPointsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsEvaluationPeriodsPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsEvaluationPeriodsPersistence cdsEvaluationPeriodsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsTitlesPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsTitlesPersistence cdsTitlesPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsTitleCompetenciesPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsTitleCompetenciesPersistence cdsTitleCompetenciesPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsMinimumRequirementsPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsMinimumRequirementsPersistence cdsMinimumRequirementsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsTitleMinimumRequirementsPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsTitleMinimumRequirementsPersistence cdsTitleMinimumRequirementsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsMinimumRequirementLevelsPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsMinimumRequirementLevelsPersistence cdsMinimumRequirementLevelsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewListTitleCompetenciesPersistence.impl")
	protected larion.progate.cds.service.persistence.ViewListTitleCompetenciesPersistence viewListTitleCompetenciesPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewListTitleMinimumRequirementsPersistence.impl")
	protected larion.progate.cds.service.persistence.ViewListTitleMinimumRequirementsPersistence viewListTitleMinimumRequirementsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPAFinalCompeteniesPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsPAFinalCompeteniesPersistence cdsPAFinalCompeteniesPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPAFinalLevelsPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsPAFinalLevelsPersistence cdsPAFinalLevelsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPAFinalSlotsPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsPAFinalSlotsPersistence cdsPAFinalSlotsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewFinalCompetenciesPersistence.impl")
	protected larion.progate.cds.service.persistence.ViewFinalCompetenciesPersistence viewFinalCompetenciesPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewFinalLevelsPersistence.impl")
	protected larion.progate.cds.service.persistence.ViewFinalLevelsPersistence viewFinalLevelsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewFinalSlotsPersistence.impl")
	protected larion.progate.cds.service.persistence.ViewFinalSlotsPersistence viewFinalSlotsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewFinalTitlesPersistence.impl")
	protected larion.progate.cds.service.persistence.ViewFinalTitlesPersistence viewFinalTitlesPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewSlotInformationPersistence.impl")
	protected larion.progate.cds.service.persistence.ViewSlotInformationPersistence viewSlotInformationPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPASlotsPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsPASlotsPersistence cdsPASlotsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPALevelsPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsPALevelsPersistence cdsPALevelsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPACompetenciesPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsPACompetenciesPersistence cdsPACompetenciesPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewPerformanceAppraisalLevelsPersistence.impl")
	protected larion.progate.cds.service.persistence.ViewPerformanceAppraisalLevelsPersistence viewPerformanceAppraisalLevelsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewPerformanceAppraisalSlotsPersistence.impl")
	protected larion.progate.cds.service.persistence.ViewPerformanceAppraisalSlotsPersistence viewPerformanceAppraisalSlotsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPerformanceAppraisalSlotRatingPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsPerformanceAppraisalSlotRatingPersistence cdsPerformanceAppraisalSlotRatingPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPerformanceAppraisalSlotCommentsPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsPerformanceAppraisalSlotCommentsPersistence cdsPerformanceAppraisalSlotCommentsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPerformanceAppraisalsPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsPerformanceAppraisalsPersistence cdsPerformanceAppraisalsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewEmployeesInProjectsPersistence.impl")
	protected larion.progate.cds.service.persistence.ViewEmployeesInProjectsPersistence viewEmployeesInProjectsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewEmployeesSlotsRatingPersistence.impl")
	protected larion.progate.cds.service.persistence.ViewEmployeesSlotsRatingPersistence viewEmployeesSlotsRatingPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsSlotStatisticalReportPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsSlotStatisticalReportPersistence cdsSlotStatisticalReportPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsLevelStatisticalReportPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsLevelStatisticalReportPersistence cdsLevelStatisticalReportPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsCompetencyStatisticalReportPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsCompetencyStatisticalReportPersistence cdsCompetencyStatisticalReportPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsCdpPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsCdpPersistence cdsCdpPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPAFinalPersistence.impl")
	protected larion.progate.cds.service.persistence.CdsPAFinalPersistence cdsPAFinalPersistence;
	protected ContainsLevel containsLevel;
	protected ContainsCdsTitleCompetencies containsCdsTitleCompetencies;

	protected class ContainsLevel {
		protected ContainsLevel(CompetencyPersistenceImpl persistenceImpl) {
			super();

			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSLEVEL,
					new int[] { Types.INTEGER, Types.INTEGER }, RowMapper.COUNT);
		}

		protected boolean contains(Integer competencyId, Integer levelId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						competencyId, levelId
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

	protected class ContainsCdsTitleCompetencies {
		protected ContainsCdsTitleCompetencies(
			CompetencyPersistenceImpl persistenceImpl) {
			super();

			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSCDSTITLECOMPETENCIES,
					new int[] { Types.INTEGER, Types.INTEGER }, RowMapper.COUNT);
		}

		protected boolean contains(Integer competencyId,
			Integer CdsTitleCompetenciesId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						competencyId, CdsTitleCompetenciesId
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

	private static final String _SQL_GETLEVELS = "SELECT {cds_levels.*} FROM cds_levels INNER JOIN cds_competencies ON (cds_competencies.competencyId = cds_levels.competencyId) WHERE (cds_competencies.competencyId = ?)";
	private static final String _SQL_GETLEVELSSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM cds_levels WHERE competencyId = ?";
	private static final String _SQL_CONTAINSLEVEL = "SELECT COUNT(*) AS COUNT_VALUE FROM cds_levels WHERE competencyId = ? AND levelId = ?";
	private static final String _SQL_GETCDSTITLECOMPETENCIESES = "SELECT {cds_title_competencies.*} FROM cds_title_competencies INNER JOIN cds_competencies ON (cds_competencies.competencyId = cds_title_competencies.competencyId) WHERE (cds_competencies.competencyId = ?)";
	private static final String _SQL_GETCDSTITLECOMPETENCIESESSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM cds_title_competencies WHERE competencyId = ?";
	private static final String _SQL_CONTAINSCDSTITLECOMPETENCIES = "SELECT COUNT(*) AS COUNT_VALUE FROM cds_title_competencies WHERE competencyId = ? AND CdsTitleCompetenciesId = ?";
	private static Log _log = LogFactoryUtil.getLog(CompetencyPersistenceImpl.class);
}