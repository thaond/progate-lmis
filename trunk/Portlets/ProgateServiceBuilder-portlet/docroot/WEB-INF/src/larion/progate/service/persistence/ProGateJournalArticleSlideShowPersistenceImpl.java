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

import larion.progate.NoSuchProGateJournalArticleSlideShowException;

import larion.progate.model.ProGateJournalArticleSlideShow;
import larion.progate.model.impl.ProGateJournalArticleSlideShowImpl;
import larion.progate.model.impl.ProGateJournalArticleSlideShowModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * <a href="ProGateJournalArticleSlideShowPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateJournalArticleSlideShowPersistenceImpl
	extends BasePersistenceImpl
	implements ProGateJournalArticleSlideShowPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = ProGateJournalArticleSlideShowImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_ORGID = new FinderPath(ProGateJournalArticleSlideShowModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleSlideShowModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByorgId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ORGID = new FinderPath(ProGateJournalArticleSlideShowModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleSlideShowModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByorgId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGID = new FinderPath(ProGateJournalArticleSlideShowModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleSlideShowModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByorgId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_SLIDEINDEXGREATER = new FinderPath(ProGateJournalArticleSlideShowModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleSlideShowModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByslideIndexGreater",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_SLIDEINDEXGREATER = new FinderPath(ProGateJournalArticleSlideShowModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleSlideShowModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByslideIndexGreater",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_SLIDEINDEXGREATER = new FinderPath(ProGateJournalArticleSlideShowModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleSlideShowModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByslideIndexGreater",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_SLIDEINDEXLOWER = new FinderPath(ProGateJournalArticleSlideShowModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleSlideShowModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByslideIndexLower",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_SLIDEINDEXLOWER = new FinderPath(ProGateJournalArticleSlideShowModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleSlideShowModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByslideIndexLower",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_SLIDEINDEXLOWER = new FinderPath(ProGateJournalArticleSlideShowModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleSlideShowModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByslideIndexLower",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_SLIDEINDEXEQUAL = new FinderPath(ProGateJournalArticleSlideShowModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleSlideShowModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByslideIndexEqual",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_SLIDEINDEXEQUAL = new FinderPath(ProGateJournalArticleSlideShowModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleSlideShowModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByslideIndexEqual",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_SLIDEINDEXEQUAL = new FinderPath(ProGateJournalArticleSlideShowModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleSlideShowModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByslideIndexEqual",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_IMAGEURL = new FinderPath(ProGateJournalArticleSlideShowModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleSlideShowModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByimageUrl",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_IMAGEURL = new FinderPath(ProGateJournalArticleSlideShowModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleSlideShowModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByimageUrl",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_IMAGEURL = new FinderPath(ProGateJournalArticleSlideShowModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleSlideShowModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByimageUrl",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_PRODUCTID = new FinderPath(ProGateJournalArticleSlideShowModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleSlideShowModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByproductId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_PRODUCTID = new FinderPath(ProGateJournalArticleSlideShowModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleSlideShowModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByproductId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_PRODUCTID = new FinderPath(ProGateJournalArticleSlideShowModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleSlideShowModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByproductId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_CREATEDBY = new FinderPath(ProGateJournalArticleSlideShowModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleSlideShowModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycreatedBy",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_CREATEDBY = new FinderPath(ProGateJournalArticleSlideShowModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleSlideShowModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycreatedBy",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_CREATEDBY = new FinderPath(ProGateJournalArticleSlideShowModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleSlideShowModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBycreatedBy",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_CREATEDATEQUAL = new FinderPath(ProGateJournalArticleSlideShowModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleSlideShowModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycreatedAtEqual",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_CREATEDATEQUAL = new FinderPath(ProGateJournalArticleSlideShowModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleSlideShowModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycreatedAtEqual",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_CREATEDATEQUAL = new FinderPath(ProGateJournalArticleSlideShowModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleSlideShowModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBycreatedAtEqual",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_CREATEDATGREATER = new FinderPath(ProGateJournalArticleSlideShowModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleSlideShowModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycreatedAtGreater",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_CREATEDATGREATER = new FinderPath(ProGateJournalArticleSlideShowModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleSlideShowModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycreatedAtGreater",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_CREATEDATGREATER = new FinderPath(ProGateJournalArticleSlideShowModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleSlideShowModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBycreatedAtGreater",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_CREATEDATLOWER = new FinderPath(ProGateJournalArticleSlideShowModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleSlideShowModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycreatedAtLower",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_CREATEDATLOWER = new FinderPath(ProGateJournalArticleSlideShowModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleSlideShowModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycreatedAtLower",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_CREATEDATLOWER = new FinderPath(ProGateJournalArticleSlideShowModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleSlideShowModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBycreatedAtLower",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_UPDATEDBY = new FinderPath(ProGateJournalArticleSlideShowModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleSlideShowModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByupdatedBy",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_UPDATEDBY = new FinderPath(ProGateJournalArticleSlideShowModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleSlideShowModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByupdatedBy",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_UPDATEDBY = new FinderPath(ProGateJournalArticleSlideShowModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleSlideShowModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByupdatedBy",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_UPDATEDATGREATER = new FinderPath(ProGateJournalArticleSlideShowModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleSlideShowModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByupdatedAtGreater",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_UPDATEDATGREATER = new FinderPath(ProGateJournalArticleSlideShowModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleSlideShowModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByupdatedAtGreater",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_UPDATEDATGREATER = new FinderPath(ProGateJournalArticleSlideShowModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleSlideShowModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByupdatedAtGreater",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_UPDATEDATLOWER = new FinderPath(ProGateJournalArticleSlideShowModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleSlideShowModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByupdatedAtLower",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_UPDATEDATLOWER = new FinderPath(ProGateJournalArticleSlideShowModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleSlideShowModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByupdatedAtLower",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_UPDATEDATLOWER = new FinderPath(ProGateJournalArticleSlideShowModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleSlideShowModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByupdatedAtLower",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_UPDATEDATEQUAL = new FinderPath(ProGateJournalArticleSlideShowModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleSlideShowModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByupdatedAtEqual",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_UPDATEDATEQUAL = new FinderPath(ProGateJournalArticleSlideShowModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleSlideShowModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByupdatedAtEqual",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_UPDATEDATEQUAL = new FinderPath(ProGateJournalArticleSlideShowModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleSlideShowModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByupdatedAtEqual",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(ProGateJournalArticleSlideShowModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleSlideShowModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProGateJournalArticleSlideShowModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleSlideShowModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(
		ProGateJournalArticleSlideShow proGateJournalArticleSlideShow) {
		EntityCacheUtil.putResult(ProGateJournalArticleSlideShowModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleSlideShowImpl.class,
			proGateJournalArticleSlideShow.getPrimaryKey(),
			proGateJournalArticleSlideShow);
	}

	public void cacheResult(
		List<ProGateJournalArticleSlideShow> proGateJournalArticleSlideShows) {
		for (ProGateJournalArticleSlideShow proGateJournalArticleSlideShow : proGateJournalArticleSlideShows) {
			if (EntityCacheUtil.getResult(
						ProGateJournalArticleSlideShowModelImpl.ENTITY_CACHE_ENABLED,
						ProGateJournalArticleSlideShowImpl.class,
						proGateJournalArticleSlideShow.getPrimaryKey(), this) == null) {
				cacheResult(proGateJournalArticleSlideShow);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(ProGateJournalArticleSlideShowImpl.class.getName());
		EntityCacheUtil.clearCache(ProGateJournalArticleSlideShowImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public ProGateJournalArticleSlideShow create(
		Integer journalArticleSlideShowId) {
		ProGateJournalArticleSlideShow proGateJournalArticleSlideShow = new ProGateJournalArticleSlideShowImpl();

		proGateJournalArticleSlideShow.setNew(true);
		proGateJournalArticleSlideShow.setPrimaryKey(journalArticleSlideShowId);

		return proGateJournalArticleSlideShow;
	}

	public ProGateJournalArticleSlideShow remove(
		Integer journalArticleSlideShowId)
		throws NoSuchProGateJournalArticleSlideShowException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ProGateJournalArticleSlideShow proGateJournalArticleSlideShow = (ProGateJournalArticleSlideShow)session.get(ProGateJournalArticleSlideShowImpl.class,
					journalArticleSlideShowId);

			if (proGateJournalArticleSlideShow == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No ProGateJournalArticleSlideShow exists with the primary key " +
						journalArticleSlideShowId);
				}

				throw new NoSuchProGateJournalArticleSlideShowException(
					"No ProGateJournalArticleSlideShow exists with the primary key " +
					journalArticleSlideShowId);
			}

			return remove(proGateJournalArticleSlideShow);
		}
		catch (NoSuchProGateJournalArticleSlideShowException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public ProGateJournalArticleSlideShow remove(
		ProGateJournalArticleSlideShow proGateJournalArticleSlideShow)
		throws SystemException {
		for (ModelListener<ProGateJournalArticleSlideShow> listener : listeners) {
			listener.onBeforeRemove(proGateJournalArticleSlideShow);
		}

		proGateJournalArticleSlideShow = removeImpl(proGateJournalArticleSlideShow);

		for (ModelListener<ProGateJournalArticleSlideShow> listener : listeners) {
			listener.onAfterRemove(proGateJournalArticleSlideShow);
		}

		return proGateJournalArticleSlideShow;
	}

	protected ProGateJournalArticleSlideShow removeImpl(
		ProGateJournalArticleSlideShow proGateJournalArticleSlideShow)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (proGateJournalArticleSlideShow.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(ProGateJournalArticleSlideShowImpl.class,
						proGateJournalArticleSlideShow.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(proGateJournalArticleSlideShow);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(ProGateJournalArticleSlideShowModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleSlideShowImpl.class,
			proGateJournalArticleSlideShow.getPrimaryKey());

		return proGateJournalArticleSlideShow;
	}

	public ProGateJournalArticleSlideShow update(
		ProGateJournalArticleSlideShow proGateJournalArticleSlideShow)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(ProGateJournalArticleSlideShow proGateJournalArticleSlideShow) method. Use update(ProGateJournalArticleSlideShow proGateJournalArticleSlideShow, boolean merge) instead.");
		}

		return update(proGateJournalArticleSlideShow, false);
	}

	public ProGateJournalArticleSlideShow update(
		ProGateJournalArticleSlideShow proGateJournalArticleSlideShow,
		boolean merge) throws SystemException {
		boolean isNew = proGateJournalArticleSlideShow.isNew();

		for (ModelListener<ProGateJournalArticleSlideShow> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(proGateJournalArticleSlideShow);
			}
			else {
				listener.onBeforeUpdate(proGateJournalArticleSlideShow);
			}
		}

		proGateJournalArticleSlideShow = updateImpl(proGateJournalArticleSlideShow,
				merge);

		for (ModelListener<ProGateJournalArticleSlideShow> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(proGateJournalArticleSlideShow);
			}
			else {
				listener.onAfterUpdate(proGateJournalArticleSlideShow);
			}
		}

		return proGateJournalArticleSlideShow;
	}

	public ProGateJournalArticleSlideShow updateImpl(
		larion.progate.model.ProGateJournalArticleSlideShow proGateJournalArticleSlideShow,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, proGateJournalArticleSlideShow,
				merge);

			proGateJournalArticleSlideShow.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(ProGateJournalArticleSlideShowModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleSlideShowImpl.class,
			proGateJournalArticleSlideShow.getPrimaryKey(),
			proGateJournalArticleSlideShow);

		return proGateJournalArticleSlideShow;
	}

	public ProGateJournalArticleSlideShow findByPrimaryKey(
		Integer journalArticleSlideShowId)
		throws NoSuchProGateJournalArticleSlideShowException, SystemException {
		ProGateJournalArticleSlideShow proGateJournalArticleSlideShow = fetchByPrimaryKey(journalArticleSlideShowId);

		if (proGateJournalArticleSlideShow == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"No ProGateJournalArticleSlideShow exists with the primary key " +
					journalArticleSlideShowId);
			}

			throw new NoSuchProGateJournalArticleSlideShowException(
				"No ProGateJournalArticleSlideShow exists with the primary key " +
				journalArticleSlideShowId);
		}

		return proGateJournalArticleSlideShow;
	}

	public ProGateJournalArticleSlideShow fetchByPrimaryKey(
		Integer journalArticleSlideShowId) throws SystemException {
		ProGateJournalArticleSlideShow proGateJournalArticleSlideShow = (ProGateJournalArticleSlideShow)EntityCacheUtil.getResult(ProGateJournalArticleSlideShowModelImpl.ENTITY_CACHE_ENABLED,
				ProGateJournalArticleSlideShowImpl.class,
				journalArticleSlideShowId, this);

		if (proGateJournalArticleSlideShow == null) {
			Session session = null;

			try {
				session = openSession();

				proGateJournalArticleSlideShow = (ProGateJournalArticleSlideShow)session.get(ProGateJournalArticleSlideShowImpl.class,
						journalArticleSlideShowId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (proGateJournalArticleSlideShow != null) {
					cacheResult(proGateJournalArticleSlideShow);
				}

				closeSession(session);
			}
		}

		return proGateJournalArticleSlideShow;
	}

	public List<ProGateJournalArticleSlideShow> findByorgId(int orgId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(orgId) };

		List<ProGateJournalArticleSlideShow> list = (List<ProGateJournalArticleSlideShow>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ORGID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleSlideShow WHERE ");

				query.append("orgid = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("slideindex ASC, ");
				query.append("updated_at DESC, ");
				query.append("created_at DESC");

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
					list = new ArrayList<ProGateJournalArticleSlideShow>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ORGID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticleSlideShow> findByorgId(int orgId,
		int start, int end) throws SystemException {
		return findByorgId(orgId, start, end, null);
	}

	public List<ProGateJournalArticleSlideShow> findByorgId(int orgId,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(orgId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticleSlideShow> list = (List<ProGateJournalArticleSlideShow>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ORGID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleSlideShow WHERE ");

				query.append("orgid = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("slideindex ASC, ");
					query.append("updated_at DESC, ");
					query.append("created_at DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orgId);

				list = (List<ProGateJournalArticleSlideShow>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleSlideShow>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ORGID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticleSlideShow findByorgId_First(int orgId,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleSlideShowException, SystemException {
		List<ProGateJournalArticleSlideShow> list = findByorgId(orgId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No ProGateJournalArticleSlideShow exists with the key {");

			msg.append("orgId=" + orgId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleSlideShowException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleSlideShow findByorgId_Last(int orgId,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleSlideShowException, SystemException {
		int count = countByorgId(orgId);

		List<ProGateJournalArticleSlideShow> list = findByorgId(orgId,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No ProGateJournalArticleSlideShow exists with the key {");

			msg.append("orgId=" + orgId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleSlideShowException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleSlideShow[] findByorgId_PrevAndNext(
		Integer journalArticleSlideShowId, int orgId, OrderByComparator obc)
		throws NoSuchProGateJournalArticleSlideShowException, SystemException {
		ProGateJournalArticleSlideShow proGateJournalArticleSlideShow = findByPrimaryKey(journalArticleSlideShowId);

		int count = countByorgId(orgId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticleSlideShow WHERE ");

			query.append("orgid = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("slideindex ASC, ");
				query.append("updated_at DESC, ");
				query.append("created_at DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(orgId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticleSlideShow);

			ProGateJournalArticleSlideShow[] array = new ProGateJournalArticleSlideShowImpl[3];

			array[0] = (ProGateJournalArticleSlideShow)objArray[0];
			array[1] = (ProGateJournalArticleSlideShow)objArray[1];
			array[2] = (ProGateJournalArticleSlideShow)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticleSlideShow> findByslideIndexGreater(
		int slideIndex) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(slideIndex) };

		List<ProGateJournalArticleSlideShow> list = (List<ProGateJournalArticleSlideShow>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_SLIDEINDEXGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleSlideShow WHERE ");

				query.append("slideindex >= ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("slideindex ASC, ");
				query.append("updated_at DESC, ");
				query.append("created_at DESC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(slideIndex);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleSlideShow>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_SLIDEINDEXGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticleSlideShow> findByslideIndexGreater(
		int slideIndex, int start, int end) throws SystemException {
		return findByslideIndexGreater(slideIndex, start, end, null);
	}

	public List<ProGateJournalArticleSlideShow> findByslideIndexGreater(
		int slideIndex, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(slideIndex),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticleSlideShow> list = (List<ProGateJournalArticleSlideShow>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_SLIDEINDEXGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleSlideShow WHERE ");

				query.append("slideindex >= ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("slideindex ASC, ");
					query.append("updated_at DESC, ");
					query.append("created_at DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(slideIndex);

				list = (List<ProGateJournalArticleSlideShow>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleSlideShow>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_SLIDEINDEXGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticleSlideShow findByslideIndexGreater_First(
		int slideIndex, OrderByComparator obc)
		throws NoSuchProGateJournalArticleSlideShowException, SystemException {
		List<ProGateJournalArticleSlideShow> list = findByslideIndexGreater(slideIndex,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No ProGateJournalArticleSlideShow exists with the key {");

			msg.append("slideIndex=" + slideIndex);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleSlideShowException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleSlideShow findByslideIndexGreater_Last(
		int slideIndex, OrderByComparator obc)
		throws NoSuchProGateJournalArticleSlideShowException, SystemException {
		int count = countByslideIndexGreater(slideIndex);

		List<ProGateJournalArticleSlideShow> list = findByslideIndexGreater(slideIndex,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No ProGateJournalArticleSlideShow exists with the key {");

			msg.append("slideIndex=" + slideIndex);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleSlideShowException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleSlideShow[] findByslideIndexGreater_PrevAndNext(
		Integer journalArticleSlideShowId, int slideIndex, OrderByComparator obc)
		throws NoSuchProGateJournalArticleSlideShowException, SystemException {
		ProGateJournalArticleSlideShow proGateJournalArticleSlideShow = findByPrimaryKey(journalArticleSlideShowId);

		int count = countByslideIndexGreater(slideIndex);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticleSlideShow WHERE ");

			query.append("slideindex >= ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("slideindex ASC, ");
				query.append("updated_at DESC, ");
				query.append("created_at DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(slideIndex);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticleSlideShow);

			ProGateJournalArticleSlideShow[] array = new ProGateJournalArticleSlideShowImpl[3];

			array[0] = (ProGateJournalArticleSlideShow)objArray[0];
			array[1] = (ProGateJournalArticleSlideShow)objArray[1];
			array[2] = (ProGateJournalArticleSlideShow)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticleSlideShow> findByslideIndexLower(
		int slideIndex) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(slideIndex) };

		List<ProGateJournalArticleSlideShow> list = (List<ProGateJournalArticleSlideShow>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_SLIDEINDEXLOWER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleSlideShow WHERE ");

				query.append("slideindex <= ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("slideindex ASC, ");
				query.append("updated_at DESC, ");
				query.append("created_at DESC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(slideIndex);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleSlideShow>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_SLIDEINDEXLOWER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticleSlideShow> findByslideIndexLower(
		int slideIndex, int start, int end) throws SystemException {
		return findByslideIndexLower(slideIndex, start, end, null);
	}

	public List<ProGateJournalArticleSlideShow> findByslideIndexLower(
		int slideIndex, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(slideIndex),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticleSlideShow> list = (List<ProGateJournalArticleSlideShow>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_SLIDEINDEXLOWER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleSlideShow WHERE ");

				query.append("slideindex <= ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("slideindex ASC, ");
					query.append("updated_at DESC, ");
					query.append("created_at DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(slideIndex);

				list = (List<ProGateJournalArticleSlideShow>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleSlideShow>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_SLIDEINDEXLOWER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticleSlideShow findByslideIndexLower_First(
		int slideIndex, OrderByComparator obc)
		throws NoSuchProGateJournalArticleSlideShowException, SystemException {
		List<ProGateJournalArticleSlideShow> list = findByslideIndexLower(slideIndex,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No ProGateJournalArticleSlideShow exists with the key {");

			msg.append("slideIndex=" + slideIndex);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleSlideShowException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleSlideShow findByslideIndexLower_Last(
		int slideIndex, OrderByComparator obc)
		throws NoSuchProGateJournalArticleSlideShowException, SystemException {
		int count = countByslideIndexLower(slideIndex);

		List<ProGateJournalArticleSlideShow> list = findByslideIndexLower(slideIndex,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No ProGateJournalArticleSlideShow exists with the key {");

			msg.append("slideIndex=" + slideIndex);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleSlideShowException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleSlideShow[] findByslideIndexLower_PrevAndNext(
		Integer journalArticleSlideShowId, int slideIndex, OrderByComparator obc)
		throws NoSuchProGateJournalArticleSlideShowException, SystemException {
		ProGateJournalArticleSlideShow proGateJournalArticleSlideShow = findByPrimaryKey(journalArticleSlideShowId);

		int count = countByslideIndexLower(slideIndex);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticleSlideShow WHERE ");

			query.append("slideindex <= ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("slideindex ASC, ");
				query.append("updated_at DESC, ");
				query.append("created_at DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(slideIndex);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticleSlideShow);

			ProGateJournalArticleSlideShow[] array = new ProGateJournalArticleSlideShowImpl[3];

			array[0] = (ProGateJournalArticleSlideShow)objArray[0];
			array[1] = (ProGateJournalArticleSlideShow)objArray[1];
			array[2] = (ProGateJournalArticleSlideShow)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticleSlideShow> findByslideIndexEqual(
		int slideIndex) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(slideIndex) };

		List<ProGateJournalArticleSlideShow> list = (List<ProGateJournalArticleSlideShow>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_SLIDEINDEXEQUAL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleSlideShow WHERE ");

				query.append("slideindex = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("slideindex ASC, ");
				query.append("updated_at DESC, ");
				query.append("created_at DESC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(slideIndex);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleSlideShow>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_SLIDEINDEXEQUAL,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticleSlideShow> findByslideIndexEqual(
		int slideIndex, int start, int end) throws SystemException {
		return findByslideIndexEqual(slideIndex, start, end, null);
	}

	public List<ProGateJournalArticleSlideShow> findByslideIndexEqual(
		int slideIndex, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(slideIndex),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticleSlideShow> list = (List<ProGateJournalArticleSlideShow>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_SLIDEINDEXEQUAL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleSlideShow WHERE ");

				query.append("slideindex = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("slideindex ASC, ");
					query.append("updated_at DESC, ");
					query.append("created_at DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(slideIndex);

				list = (List<ProGateJournalArticleSlideShow>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleSlideShow>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_SLIDEINDEXEQUAL,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticleSlideShow findByslideIndexEqual_First(
		int slideIndex, OrderByComparator obc)
		throws NoSuchProGateJournalArticleSlideShowException, SystemException {
		List<ProGateJournalArticleSlideShow> list = findByslideIndexEqual(slideIndex,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No ProGateJournalArticleSlideShow exists with the key {");

			msg.append("slideIndex=" + slideIndex);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleSlideShowException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleSlideShow findByslideIndexEqual_Last(
		int slideIndex, OrderByComparator obc)
		throws NoSuchProGateJournalArticleSlideShowException, SystemException {
		int count = countByslideIndexEqual(slideIndex);

		List<ProGateJournalArticleSlideShow> list = findByslideIndexEqual(slideIndex,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No ProGateJournalArticleSlideShow exists with the key {");

			msg.append("slideIndex=" + slideIndex);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleSlideShowException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleSlideShow[] findByslideIndexEqual_PrevAndNext(
		Integer journalArticleSlideShowId, int slideIndex, OrderByComparator obc)
		throws NoSuchProGateJournalArticleSlideShowException, SystemException {
		ProGateJournalArticleSlideShow proGateJournalArticleSlideShow = findByPrimaryKey(journalArticleSlideShowId);

		int count = countByslideIndexEqual(slideIndex);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticleSlideShow WHERE ");

			query.append("slideindex = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("slideindex ASC, ");
				query.append("updated_at DESC, ");
				query.append("created_at DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(slideIndex);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticleSlideShow);

			ProGateJournalArticleSlideShow[] array = new ProGateJournalArticleSlideShowImpl[3];

			array[0] = (ProGateJournalArticleSlideShow)objArray[0];
			array[1] = (ProGateJournalArticleSlideShow)objArray[1];
			array[2] = (ProGateJournalArticleSlideShow)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticleSlideShow> findByimageUrl(String imageUrl)
		throws SystemException {
		Object[] finderArgs = new Object[] { imageUrl };

		List<ProGateJournalArticleSlideShow> list = (List<ProGateJournalArticleSlideShow>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_IMAGEURL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleSlideShow WHERE ");

				if (imageUrl == null) {
					query.append("imageurl IS NULL");
				}
				else {
					query.append("imageurl = ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("slideindex ASC, ");
				query.append("updated_at DESC, ");
				query.append("created_at DESC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (imageUrl != null) {
					qPos.add(imageUrl);
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleSlideShow>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_IMAGEURL,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticleSlideShow> findByimageUrl(
		String imageUrl, int start, int end) throws SystemException {
		return findByimageUrl(imageUrl, start, end, null);
	}

	public List<ProGateJournalArticleSlideShow> findByimageUrl(
		String imageUrl, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				imageUrl,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticleSlideShow> list = (List<ProGateJournalArticleSlideShow>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_IMAGEURL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleSlideShow WHERE ");

				if (imageUrl == null) {
					query.append("imageurl IS NULL");
				}
				else {
					query.append("imageurl = ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("slideindex ASC, ");
					query.append("updated_at DESC, ");
					query.append("created_at DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (imageUrl != null) {
					qPos.add(imageUrl);
				}

				list = (List<ProGateJournalArticleSlideShow>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleSlideShow>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_IMAGEURL,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticleSlideShow findByimageUrl_First(
		String imageUrl, OrderByComparator obc)
		throws NoSuchProGateJournalArticleSlideShowException, SystemException {
		List<ProGateJournalArticleSlideShow> list = findByimageUrl(imageUrl, 0,
				1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No ProGateJournalArticleSlideShow exists with the key {");

			msg.append("imageUrl=" + imageUrl);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleSlideShowException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleSlideShow findByimageUrl_Last(String imageUrl,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleSlideShowException, SystemException {
		int count = countByimageUrl(imageUrl);

		List<ProGateJournalArticleSlideShow> list = findByimageUrl(imageUrl,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No ProGateJournalArticleSlideShow exists with the key {");

			msg.append("imageUrl=" + imageUrl);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleSlideShowException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleSlideShow[] findByimageUrl_PrevAndNext(
		Integer journalArticleSlideShowId, String imageUrl,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleSlideShowException, SystemException {
		ProGateJournalArticleSlideShow proGateJournalArticleSlideShow = findByPrimaryKey(journalArticleSlideShowId);

		int count = countByimageUrl(imageUrl);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticleSlideShow WHERE ");

			if (imageUrl == null) {
				query.append("imageurl IS NULL");
			}
			else {
				query.append("imageurl = ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("slideindex ASC, ");
				query.append("updated_at DESC, ");
				query.append("created_at DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (imageUrl != null) {
				qPos.add(imageUrl);
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticleSlideShow);

			ProGateJournalArticleSlideShow[] array = new ProGateJournalArticleSlideShowImpl[3];

			array[0] = (ProGateJournalArticleSlideShow)objArray[0];
			array[1] = (ProGateJournalArticleSlideShow)objArray[1];
			array[2] = (ProGateJournalArticleSlideShow)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticleSlideShow> findByproductId(int productId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(productId) };

		List<ProGateJournalArticleSlideShow> list = (List<ProGateJournalArticleSlideShow>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_PRODUCTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleSlideShow WHERE ");

				query.append("productid = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("slideindex ASC, ");
				query.append("updated_at DESC, ");
				query.append("created_at DESC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(productId);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleSlideShow>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_PRODUCTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticleSlideShow> findByproductId(int productId,
		int start, int end) throws SystemException {
		return findByproductId(productId, start, end, null);
	}

	public List<ProGateJournalArticleSlideShow> findByproductId(int productId,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(productId),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticleSlideShow> list = (List<ProGateJournalArticleSlideShow>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_PRODUCTID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleSlideShow WHERE ");

				query.append("productid = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("slideindex ASC, ");
					query.append("updated_at DESC, ");
					query.append("created_at DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(productId);

				list = (List<ProGateJournalArticleSlideShow>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleSlideShow>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_PRODUCTID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticleSlideShow findByproductId_First(int productId,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleSlideShowException, SystemException {
		List<ProGateJournalArticleSlideShow> list = findByproductId(productId,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No ProGateJournalArticleSlideShow exists with the key {");

			msg.append("productId=" + productId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleSlideShowException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleSlideShow findByproductId_Last(int productId,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleSlideShowException, SystemException {
		int count = countByproductId(productId);

		List<ProGateJournalArticleSlideShow> list = findByproductId(productId,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No ProGateJournalArticleSlideShow exists with the key {");

			msg.append("productId=" + productId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleSlideShowException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleSlideShow[] findByproductId_PrevAndNext(
		Integer journalArticleSlideShowId, int productId, OrderByComparator obc)
		throws NoSuchProGateJournalArticleSlideShowException, SystemException {
		ProGateJournalArticleSlideShow proGateJournalArticleSlideShow = findByPrimaryKey(journalArticleSlideShowId);

		int count = countByproductId(productId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticleSlideShow WHERE ");

			query.append("productid = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("slideindex ASC, ");
				query.append("updated_at DESC, ");
				query.append("created_at DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(productId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticleSlideShow);

			ProGateJournalArticleSlideShow[] array = new ProGateJournalArticleSlideShowImpl[3];

			array[0] = (ProGateJournalArticleSlideShow)objArray[0];
			array[1] = (ProGateJournalArticleSlideShow)objArray[1];
			array[2] = (ProGateJournalArticleSlideShow)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticleSlideShow> findBycreatedBy(int createdBy)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(createdBy) };

		List<ProGateJournalArticleSlideShow> list = (List<ProGateJournalArticleSlideShow>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_CREATEDBY,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleSlideShow WHERE ");

				query.append("created_by = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("slideindex ASC, ");
				query.append("updated_at DESC, ");
				query.append("created_at DESC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(createdBy);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleSlideShow>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_CREATEDBY,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticleSlideShow> findBycreatedBy(int createdBy,
		int start, int end) throws SystemException {
		return findBycreatedBy(createdBy, start, end, null);
	}

	public List<ProGateJournalArticleSlideShow> findBycreatedBy(int createdBy,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(createdBy),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticleSlideShow> list = (List<ProGateJournalArticleSlideShow>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_CREATEDBY,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleSlideShow WHERE ");

				query.append("created_by = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("slideindex ASC, ");
					query.append("updated_at DESC, ");
					query.append("created_at DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(createdBy);

				list = (List<ProGateJournalArticleSlideShow>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleSlideShow>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_CREATEDBY,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticleSlideShow findBycreatedBy_First(int createdBy,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleSlideShowException, SystemException {
		List<ProGateJournalArticleSlideShow> list = findBycreatedBy(createdBy,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No ProGateJournalArticleSlideShow exists with the key {");

			msg.append("createdBy=" + createdBy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleSlideShowException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleSlideShow findBycreatedBy_Last(int createdBy,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleSlideShowException, SystemException {
		int count = countBycreatedBy(createdBy);

		List<ProGateJournalArticleSlideShow> list = findBycreatedBy(createdBy,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No ProGateJournalArticleSlideShow exists with the key {");

			msg.append("createdBy=" + createdBy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleSlideShowException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleSlideShow[] findBycreatedBy_PrevAndNext(
		Integer journalArticleSlideShowId, int createdBy, OrderByComparator obc)
		throws NoSuchProGateJournalArticleSlideShowException, SystemException {
		ProGateJournalArticleSlideShow proGateJournalArticleSlideShow = findByPrimaryKey(journalArticleSlideShowId);

		int count = countBycreatedBy(createdBy);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticleSlideShow WHERE ");

			query.append("created_by = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("slideindex ASC, ");
				query.append("updated_at DESC, ");
				query.append("created_at DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(createdBy);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticleSlideShow);

			ProGateJournalArticleSlideShow[] array = new ProGateJournalArticleSlideShowImpl[3];

			array[0] = (ProGateJournalArticleSlideShow)objArray[0];
			array[1] = (ProGateJournalArticleSlideShow)objArray[1];
			array[2] = (ProGateJournalArticleSlideShow)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticleSlideShow> findBycreatedAtEqual(
		Date createdAt) throws SystemException {
		Object[] finderArgs = new Object[] { createdAt };

		List<ProGateJournalArticleSlideShow> list = (List<ProGateJournalArticleSlideShow>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_CREATEDATEQUAL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleSlideShow WHERE ");

				if (createdAt == null) {
					query.append("created_at IS NULL");
				}
				else {
					query.append("created_at = ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("slideindex ASC, ");
				query.append("updated_at DESC, ");
				query.append("created_at DESC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (createdAt != null) {
					qPos.add(CalendarUtil.getTimestamp(createdAt));
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleSlideShow>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_CREATEDATEQUAL,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticleSlideShow> findBycreatedAtEqual(
		Date createdAt, int start, int end) throws SystemException {
		return findBycreatedAtEqual(createdAt, start, end, null);
	}

	public List<ProGateJournalArticleSlideShow> findBycreatedAtEqual(
		Date createdAt, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				createdAt,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticleSlideShow> list = (List<ProGateJournalArticleSlideShow>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_CREATEDATEQUAL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleSlideShow WHERE ");

				if (createdAt == null) {
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

				else {
					query.append("ORDER BY ");

					query.append("slideindex ASC, ");
					query.append("updated_at DESC, ");
					query.append("created_at DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (createdAt != null) {
					qPos.add(CalendarUtil.getTimestamp(createdAt));
				}

				list = (List<ProGateJournalArticleSlideShow>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleSlideShow>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_CREATEDATEQUAL,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticleSlideShow findBycreatedAtEqual_First(
		Date createdAt, OrderByComparator obc)
		throws NoSuchProGateJournalArticleSlideShowException, SystemException {
		List<ProGateJournalArticleSlideShow> list = findBycreatedAtEqual(createdAt,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No ProGateJournalArticleSlideShow exists with the key {");

			msg.append("createdAt=" + createdAt);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleSlideShowException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleSlideShow findBycreatedAtEqual_Last(
		Date createdAt, OrderByComparator obc)
		throws NoSuchProGateJournalArticleSlideShowException, SystemException {
		int count = countBycreatedAtEqual(createdAt);

		List<ProGateJournalArticleSlideShow> list = findBycreatedAtEqual(createdAt,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No ProGateJournalArticleSlideShow exists with the key {");

			msg.append("createdAt=" + createdAt);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleSlideShowException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleSlideShow[] findBycreatedAtEqual_PrevAndNext(
		Integer journalArticleSlideShowId, Date createdAt, OrderByComparator obc)
		throws NoSuchProGateJournalArticleSlideShowException, SystemException {
		ProGateJournalArticleSlideShow proGateJournalArticleSlideShow = findByPrimaryKey(journalArticleSlideShowId);

		int count = countBycreatedAtEqual(createdAt);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticleSlideShow WHERE ");

			if (createdAt == null) {
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

			else {
				query.append("ORDER BY ");

				query.append("slideindex ASC, ");
				query.append("updated_at DESC, ");
				query.append("created_at DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (createdAt != null) {
				qPos.add(CalendarUtil.getTimestamp(createdAt));
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticleSlideShow);

			ProGateJournalArticleSlideShow[] array = new ProGateJournalArticleSlideShowImpl[3];

			array[0] = (ProGateJournalArticleSlideShow)objArray[0];
			array[1] = (ProGateJournalArticleSlideShow)objArray[1];
			array[2] = (ProGateJournalArticleSlideShow)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticleSlideShow> findBycreatedAtGreater(
		Date createdAt) throws SystemException {
		Object[] finderArgs = new Object[] { createdAt };

		List<ProGateJournalArticleSlideShow> list = (List<ProGateJournalArticleSlideShow>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_CREATEDATGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleSlideShow WHERE ");

				if (createdAt == null) {
					query.append("created_at >= null");
				}
				else {
					query.append("created_at >= ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("slideindex ASC, ");
				query.append("updated_at DESC, ");
				query.append("created_at DESC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (createdAt != null) {
					qPos.add(CalendarUtil.getTimestamp(createdAt));
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleSlideShow>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_CREATEDATGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticleSlideShow> findBycreatedAtGreater(
		Date createdAt, int start, int end) throws SystemException {
		return findBycreatedAtGreater(createdAt, start, end, null);
	}

	public List<ProGateJournalArticleSlideShow> findBycreatedAtGreater(
		Date createdAt, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				createdAt,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticleSlideShow> list = (List<ProGateJournalArticleSlideShow>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_CREATEDATGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleSlideShow WHERE ");

				if (createdAt == null) {
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

				else {
					query.append("ORDER BY ");

					query.append("slideindex ASC, ");
					query.append("updated_at DESC, ");
					query.append("created_at DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (createdAt != null) {
					qPos.add(CalendarUtil.getTimestamp(createdAt));
				}

				list = (List<ProGateJournalArticleSlideShow>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleSlideShow>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_CREATEDATGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticleSlideShow findBycreatedAtGreater_First(
		Date createdAt, OrderByComparator obc)
		throws NoSuchProGateJournalArticleSlideShowException, SystemException {
		List<ProGateJournalArticleSlideShow> list = findBycreatedAtGreater(createdAt,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No ProGateJournalArticleSlideShow exists with the key {");

			msg.append("createdAt=" + createdAt);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleSlideShowException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleSlideShow findBycreatedAtGreater_Last(
		Date createdAt, OrderByComparator obc)
		throws NoSuchProGateJournalArticleSlideShowException, SystemException {
		int count = countBycreatedAtGreater(createdAt);

		List<ProGateJournalArticleSlideShow> list = findBycreatedAtGreater(createdAt,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No ProGateJournalArticleSlideShow exists with the key {");

			msg.append("createdAt=" + createdAt);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleSlideShowException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleSlideShow[] findBycreatedAtGreater_PrevAndNext(
		Integer journalArticleSlideShowId, Date createdAt, OrderByComparator obc)
		throws NoSuchProGateJournalArticleSlideShowException, SystemException {
		ProGateJournalArticleSlideShow proGateJournalArticleSlideShow = findByPrimaryKey(journalArticleSlideShowId);

		int count = countBycreatedAtGreater(createdAt);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticleSlideShow WHERE ");

			if (createdAt == null) {
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

			else {
				query.append("ORDER BY ");

				query.append("slideindex ASC, ");
				query.append("updated_at DESC, ");
				query.append("created_at DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (createdAt != null) {
				qPos.add(CalendarUtil.getTimestamp(createdAt));
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticleSlideShow);

			ProGateJournalArticleSlideShow[] array = new ProGateJournalArticleSlideShowImpl[3];

			array[0] = (ProGateJournalArticleSlideShow)objArray[0];
			array[1] = (ProGateJournalArticleSlideShow)objArray[1];
			array[2] = (ProGateJournalArticleSlideShow)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticleSlideShow> findBycreatedAtLower(
		Date createdAt) throws SystemException {
		Object[] finderArgs = new Object[] { createdAt };

		List<ProGateJournalArticleSlideShow> list = (List<ProGateJournalArticleSlideShow>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_CREATEDATLOWER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleSlideShow WHERE ");

				if (createdAt == null) {
					query.append("created_at <= null");
				}
				else {
					query.append("created_at <= ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("slideindex ASC, ");
				query.append("updated_at DESC, ");
				query.append("created_at DESC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (createdAt != null) {
					qPos.add(CalendarUtil.getTimestamp(createdAt));
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleSlideShow>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_CREATEDATLOWER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticleSlideShow> findBycreatedAtLower(
		Date createdAt, int start, int end) throws SystemException {
		return findBycreatedAtLower(createdAt, start, end, null);
	}

	public List<ProGateJournalArticleSlideShow> findBycreatedAtLower(
		Date createdAt, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				createdAt,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticleSlideShow> list = (List<ProGateJournalArticleSlideShow>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_CREATEDATLOWER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleSlideShow WHERE ");

				if (createdAt == null) {
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

				else {
					query.append("ORDER BY ");

					query.append("slideindex ASC, ");
					query.append("updated_at DESC, ");
					query.append("created_at DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (createdAt != null) {
					qPos.add(CalendarUtil.getTimestamp(createdAt));
				}

				list = (List<ProGateJournalArticleSlideShow>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleSlideShow>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_CREATEDATLOWER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticleSlideShow findBycreatedAtLower_First(
		Date createdAt, OrderByComparator obc)
		throws NoSuchProGateJournalArticleSlideShowException, SystemException {
		List<ProGateJournalArticleSlideShow> list = findBycreatedAtLower(createdAt,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No ProGateJournalArticleSlideShow exists with the key {");

			msg.append("createdAt=" + createdAt);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleSlideShowException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleSlideShow findBycreatedAtLower_Last(
		Date createdAt, OrderByComparator obc)
		throws NoSuchProGateJournalArticleSlideShowException, SystemException {
		int count = countBycreatedAtLower(createdAt);

		List<ProGateJournalArticleSlideShow> list = findBycreatedAtLower(createdAt,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No ProGateJournalArticleSlideShow exists with the key {");

			msg.append("createdAt=" + createdAt);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleSlideShowException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleSlideShow[] findBycreatedAtLower_PrevAndNext(
		Integer journalArticleSlideShowId, Date createdAt, OrderByComparator obc)
		throws NoSuchProGateJournalArticleSlideShowException, SystemException {
		ProGateJournalArticleSlideShow proGateJournalArticleSlideShow = findByPrimaryKey(journalArticleSlideShowId);

		int count = countBycreatedAtLower(createdAt);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticleSlideShow WHERE ");

			if (createdAt == null) {
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

			else {
				query.append("ORDER BY ");

				query.append("slideindex ASC, ");
				query.append("updated_at DESC, ");
				query.append("created_at DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (createdAt != null) {
				qPos.add(CalendarUtil.getTimestamp(createdAt));
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticleSlideShow);

			ProGateJournalArticleSlideShow[] array = new ProGateJournalArticleSlideShowImpl[3];

			array[0] = (ProGateJournalArticleSlideShow)objArray[0];
			array[1] = (ProGateJournalArticleSlideShow)objArray[1];
			array[2] = (ProGateJournalArticleSlideShow)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticleSlideShow> findByupdatedBy(int updatedBy)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(updatedBy) };

		List<ProGateJournalArticleSlideShow> list = (List<ProGateJournalArticleSlideShow>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_UPDATEDBY,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleSlideShow WHERE ");

				query.append("updated_by = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("slideindex ASC, ");
				query.append("updated_at DESC, ");
				query.append("created_at DESC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(updatedBy);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleSlideShow>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_UPDATEDBY,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticleSlideShow> findByupdatedBy(int updatedBy,
		int start, int end) throws SystemException {
		return findByupdatedBy(updatedBy, start, end, null);
	}

	public List<ProGateJournalArticleSlideShow> findByupdatedBy(int updatedBy,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(updatedBy),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticleSlideShow> list = (List<ProGateJournalArticleSlideShow>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_UPDATEDBY,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleSlideShow WHERE ");

				query.append("updated_by = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("slideindex ASC, ");
					query.append("updated_at DESC, ");
					query.append("created_at DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(updatedBy);

				list = (List<ProGateJournalArticleSlideShow>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleSlideShow>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_UPDATEDBY,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticleSlideShow findByupdatedBy_First(int updatedBy,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleSlideShowException, SystemException {
		List<ProGateJournalArticleSlideShow> list = findByupdatedBy(updatedBy,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No ProGateJournalArticleSlideShow exists with the key {");

			msg.append("updatedBy=" + updatedBy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleSlideShowException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleSlideShow findByupdatedBy_Last(int updatedBy,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleSlideShowException, SystemException {
		int count = countByupdatedBy(updatedBy);

		List<ProGateJournalArticleSlideShow> list = findByupdatedBy(updatedBy,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No ProGateJournalArticleSlideShow exists with the key {");

			msg.append("updatedBy=" + updatedBy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleSlideShowException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleSlideShow[] findByupdatedBy_PrevAndNext(
		Integer journalArticleSlideShowId, int updatedBy, OrderByComparator obc)
		throws NoSuchProGateJournalArticleSlideShowException, SystemException {
		ProGateJournalArticleSlideShow proGateJournalArticleSlideShow = findByPrimaryKey(journalArticleSlideShowId);

		int count = countByupdatedBy(updatedBy);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticleSlideShow WHERE ");

			query.append("updated_by = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("slideindex ASC, ");
				query.append("updated_at DESC, ");
				query.append("created_at DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(updatedBy);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticleSlideShow);

			ProGateJournalArticleSlideShow[] array = new ProGateJournalArticleSlideShowImpl[3];

			array[0] = (ProGateJournalArticleSlideShow)objArray[0];
			array[1] = (ProGateJournalArticleSlideShow)objArray[1];
			array[2] = (ProGateJournalArticleSlideShow)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticleSlideShow> findByupdatedAtGreater(
		Date updatedAt) throws SystemException {
		Object[] finderArgs = new Object[] { updatedAt };

		List<ProGateJournalArticleSlideShow> list = (List<ProGateJournalArticleSlideShow>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_UPDATEDATGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleSlideShow WHERE ");

				if (updatedAt == null) {
					query.append("updated_at >= null");
				}
				else {
					query.append("updated_at >= ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("slideindex ASC, ");
				query.append("updated_at DESC, ");
				query.append("created_at DESC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (updatedAt != null) {
					qPos.add(CalendarUtil.getTimestamp(updatedAt));
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleSlideShow>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_UPDATEDATGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticleSlideShow> findByupdatedAtGreater(
		Date updatedAt, int start, int end) throws SystemException {
		return findByupdatedAtGreater(updatedAt, start, end, null);
	}

	public List<ProGateJournalArticleSlideShow> findByupdatedAtGreater(
		Date updatedAt, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				updatedAt,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticleSlideShow> list = (List<ProGateJournalArticleSlideShow>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_UPDATEDATGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleSlideShow WHERE ");

				if (updatedAt == null) {
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

				else {
					query.append("ORDER BY ");

					query.append("slideindex ASC, ");
					query.append("updated_at DESC, ");
					query.append("created_at DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (updatedAt != null) {
					qPos.add(CalendarUtil.getTimestamp(updatedAt));
				}

				list = (List<ProGateJournalArticleSlideShow>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleSlideShow>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_UPDATEDATGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticleSlideShow findByupdatedAtGreater_First(
		Date updatedAt, OrderByComparator obc)
		throws NoSuchProGateJournalArticleSlideShowException, SystemException {
		List<ProGateJournalArticleSlideShow> list = findByupdatedAtGreater(updatedAt,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No ProGateJournalArticleSlideShow exists with the key {");

			msg.append("updatedAt=" + updatedAt);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleSlideShowException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleSlideShow findByupdatedAtGreater_Last(
		Date updatedAt, OrderByComparator obc)
		throws NoSuchProGateJournalArticleSlideShowException, SystemException {
		int count = countByupdatedAtGreater(updatedAt);

		List<ProGateJournalArticleSlideShow> list = findByupdatedAtGreater(updatedAt,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No ProGateJournalArticleSlideShow exists with the key {");

			msg.append("updatedAt=" + updatedAt);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleSlideShowException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleSlideShow[] findByupdatedAtGreater_PrevAndNext(
		Integer journalArticleSlideShowId, Date updatedAt, OrderByComparator obc)
		throws NoSuchProGateJournalArticleSlideShowException, SystemException {
		ProGateJournalArticleSlideShow proGateJournalArticleSlideShow = findByPrimaryKey(journalArticleSlideShowId);

		int count = countByupdatedAtGreater(updatedAt);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticleSlideShow WHERE ");

			if (updatedAt == null) {
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

			else {
				query.append("ORDER BY ");

				query.append("slideindex ASC, ");
				query.append("updated_at DESC, ");
				query.append("created_at DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (updatedAt != null) {
				qPos.add(CalendarUtil.getTimestamp(updatedAt));
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticleSlideShow);

			ProGateJournalArticleSlideShow[] array = new ProGateJournalArticleSlideShowImpl[3];

			array[0] = (ProGateJournalArticleSlideShow)objArray[0];
			array[1] = (ProGateJournalArticleSlideShow)objArray[1];
			array[2] = (ProGateJournalArticleSlideShow)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticleSlideShow> findByupdatedAtLower(
		Date updatedAt) throws SystemException {
		Object[] finderArgs = new Object[] { updatedAt };

		List<ProGateJournalArticleSlideShow> list = (List<ProGateJournalArticleSlideShow>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_UPDATEDATLOWER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleSlideShow WHERE ");

				if (updatedAt == null) {
					query.append("updated_at <= null");
				}
				else {
					query.append("updated_at <= ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("slideindex ASC, ");
				query.append("updated_at DESC, ");
				query.append("created_at DESC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (updatedAt != null) {
					qPos.add(CalendarUtil.getTimestamp(updatedAt));
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleSlideShow>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_UPDATEDATLOWER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticleSlideShow> findByupdatedAtLower(
		Date updatedAt, int start, int end) throws SystemException {
		return findByupdatedAtLower(updatedAt, start, end, null);
	}

	public List<ProGateJournalArticleSlideShow> findByupdatedAtLower(
		Date updatedAt, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				updatedAt,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticleSlideShow> list = (List<ProGateJournalArticleSlideShow>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_UPDATEDATLOWER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleSlideShow WHERE ");

				if (updatedAt == null) {
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

				else {
					query.append("ORDER BY ");

					query.append("slideindex ASC, ");
					query.append("updated_at DESC, ");
					query.append("created_at DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (updatedAt != null) {
					qPos.add(CalendarUtil.getTimestamp(updatedAt));
				}

				list = (List<ProGateJournalArticleSlideShow>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleSlideShow>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_UPDATEDATLOWER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticleSlideShow findByupdatedAtLower_First(
		Date updatedAt, OrderByComparator obc)
		throws NoSuchProGateJournalArticleSlideShowException, SystemException {
		List<ProGateJournalArticleSlideShow> list = findByupdatedAtLower(updatedAt,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No ProGateJournalArticleSlideShow exists with the key {");

			msg.append("updatedAt=" + updatedAt);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleSlideShowException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleSlideShow findByupdatedAtLower_Last(
		Date updatedAt, OrderByComparator obc)
		throws NoSuchProGateJournalArticleSlideShowException, SystemException {
		int count = countByupdatedAtLower(updatedAt);

		List<ProGateJournalArticleSlideShow> list = findByupdatedAtLower(updatedAt,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No ProGateJournalArticleSlideShow exists with the key {");

			msg.append("updatedAt=" + updatedAt);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleSlideShowException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleSlideShow[] findByupdatedAtLower_PrevAndNext(
		Integer journalArticleSlideShowId, Date updatedAt, OrderByComparator obc)
		throws NoSuchProGateJournalArticleSlideShowException, SystemException {
		ProGateJournalArticleSlideShow proGateJournalArticleSlideShow = findByPrimaryKey(journalArticleSlideShowId);

		int count = countByupdatedAtLower(updatedAt);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticleSlideShow WHERE ");

			if (updatedAt == null) {
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

			else {
				query.append("ORDER BY ");

				query.append("slideindex ASC, ");
				query.append("updated_at DESC, ");
				query.append("created_at DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (updatedAt != null) {
				qPos.add(CalendarUtil.getTimestamp(updatedAt));
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticleSlideShow);

			ProGateJournalArticleSlideShow[] array = new ProGateJournalArticleSlideShowImpl[3];

			array[0] = (ProGateJournalArticleSlideShow)objArray[0];
			array[1] = (ProGateJournalArticleSlideShow)objArray[1];
			array[2] = (ProGateJournalArticleSlideShow)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticleSlideShow> findByupdatedAtEqual(
		Date updatedAt) throws SystemException {
		Object[] finderArgs = new Object[] { updatedAt };

		List<ProGateJournalArticleSlideShow> list = (List<ProGateJournalArticleSlideShow>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_UPDATEDATEQUAL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleSlideShow WHERE ");

				if (updatedAt == null) {
					query.append("updated_at IS NULL");
				}
				else {
					query.append("updated_at = ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("slideindex ASC, ");
				query.append("updated_at DESC, ");
				query.append("created_at DESC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (updatedAt != null) {
					qPos.add(CalendarUtil.getTimestamp(updatedAt));
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleSlideShow>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_UPDATEDATEQUAL,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticleSlideShow> findByupdatedAtEqual(
		Date updatedAt, int start, int end) throws SystemException {
		return findByupdatedAtEqual(updatedAt, start, end, null);
	}

	public List<ProGateJournalArticleSlideShow> findByupdatedAtEqual(
		Date updatedAt, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				updatedAt,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticleSlideShow> list = (List<ProGateJournalArticleSlideShow>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_UPDATEDATEQUAL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleSlideShow WHERE ");

				if (updatedAt == null) {
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

				else {
					query.append("ORDER BY ");

					query.append("slideindex ASC, ");
					query.append("updated_at DESC, ");
					query.append("created_at DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (updatedAt != null) {
					qPos.add(CalendarUtil.getTimestamp(updatedAt));
				}

				list = (List<ProGateJournalArticleSlideShow>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleSlideShow>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_UPDATEDATEQUAL,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticleSlideShow findByupdatedAtEqual_First(
		Date updatedAt, OrderByComparator obc)
		throws NoSuchProGateJournalArticleSlideShowException, SystemException {
		List<ProGateJournalArticleSlideShow> list = findByupdatedAtEqual(updatedAt,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No ProGateJournalArticleSlideShow exists with the key {");

			msg.append("updatedAt=" + updatedAt);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleSlideShowException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleSlideShow findByupdatedAtEqual_Last(
		Date updatedAt, OrderByComparator obc)
		throws NoSuchProGateJournalArticleSlideShowException, SystemException {
		int count = countByupdatedAtEqual(updatedAt);

		List<ProGateJournalArticleSlideShow> list = findByupdatedAtEqual(updatedAt,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append(
				"No ProGateJournalArticleSlideShow exists with the key {");

			msg.append("updatedAt=" + updatedAt);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleSlideShowException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleSlideShow[] findByupdatedAtEqual_PrevAndNext(
		Integer journalArticleSlideShowId, Date updatedAt, OrderByComparator obc)
		throws NoSuchProGateJournalArticleSlideShowException, SystemException {
		ProGateJournalArticleSlideShow proGateJournalArticleSlideShow = findByPrimaryKey(journalArticleSlideShowId);

		int count = countByupdatedAtEqual(updatedAt);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticleSlideShow WHERE ");

			if (updatedAt == null) {
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

			else {
				query.append("ORDER BY ");

				query.append("slideindex ASC, ");
				query.append("updated_at DESC, ");
				query.append("created_at DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (updatedAt != null) {
				qPos.add(CalendarUtil.getTimestamp(updatedAt));
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticleSlideShow);

			ProGateJournalArticleSlideShow[] array = new ProGateJournalArticleSlideShowImpl[3];

			array[0] = (ProGateJournalArticleSlideShow)objArray[0];
			array[1] = (ProGateJournalArticleSlideShow)objArray[1];
			array[2] = (ProGateJournalArticleSlideShow)objArray[2];

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

	public List<ProGateJournalArticleSlideShow> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<ProGateJournalArticleSlideShow> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<ProGateJournalArticleSlideShow> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticleSlideShow> list = (List<ProGateJournalArticleSlideShow>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleSlideShow ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("slideindex ASC, ");
					query.append("updated_at DESC, ");
					query.append("created_at DESC");
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<ProGateJournalArticleSlideShow>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ProGateJournalArticleSlideShow>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleSlideShow>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByorgId(int orgId) throws SystemException {
		for (ProGateJournalArticleSlideShow proGateJournalArticleSlideShow : findByorgId(
				orgId)) {
			remove(proGateJournalArticleSlideShow);
		}
	}

	public void removeByslideIndexGreater(int slideIndex)
		throws SystemException {
		for (ProGateJournalArticleSlideShow proGateJournalArticleSlideShow : findByslideIndexGreater(
				slideIndex)) {
			remove(proGateJournalArticleSlideShow);
		}
	}

	public void removeByslideIndexLower(int slideIndex)
		throws SystemException {
		for (ProGateJournalArticleSlideShow proGateJournalArticleSlideShow : findByslideIndexLower(
				slideIndex)) {
			remove(proGateJournalArticleSlideShow);
		}
	}

	public void removeByslideIndexEqual(int slideIndex)
		throws SystemException {
		for (ProGateJournalArticleSlideShow proGateJournalArticleSlideShow : findByslideIndexEqual(
				slideIndex)) {
			remove(proGateJournalArticleSlideShow);
		}
	}

	public void removeByimageUrl(String imageUrl) throws SystemException {
		for (ProGateJournalArticleSlideShow proGateJournalArticleSlideShow : findByimageUrl(
				imageUrl)) {
			remove(proGateJournalArticleSlideShow);
		}
	}

	public void removeByproductId(int productId) throws SystemException {
		for (ProGateJournalArticleSlideShow proGateJournalArticleSlideShow : findByproductId(
				productId)) {
			remove(proGateJournalArticleSlideShow);
		}
	}

	public void removeBycreatedBy(int createdBy) throws SystemException {
		for (ProGateJournalArticleSlideShow proGateJournalArticleSlideShow : findBycreatedBy(
				createdBy)) {
			remove(proGateJournalArticleSlideShow);
		}
	}

	public void removeBycreatedAtEqual(Date createdAt)
		throws SystemException {
		for (ProGateJournalArticleSlideShow proGateJournalArticleSlideShow : findBycreatedAtEqual(
				createdAt)) {
			remove(proGateJournalArticleSlideShow);
		}
	}

	public void removeBycreatedAtGreater(Date createdAt)
		throws SystemException {
		for (ProGateJournalArticleSlideShow proGateJournalArticleSlideShow : findBycreatedAtGreater(
				createdAt)) {
			remove(proGateJournalArticleSlideShow);
		}
	}

	public void removeBycreatedAtLower(Date createdAt)
		throws SystemException {
		for (ProGateJournalArticleSlideShow proGateJournalArticleSlideShow : findBycreatedAtLower(
				createdAt)) {
			remove(proGateJournalArticleSlideShow);
		}
	}

	public void removeByupdatedBy(int updatedBy) throws SystemException {
		for (ProGateJournalArticleSlideShow proGateJournalArticleSlideShow : findByupdatedBy(
				updatedBy)) {
			remove(proGateJournalArticleSlideShow);
		}
	}

	public void removeByupdatedAtGreater(Date updatedAt)
		throws SystemException {
		for (ProGateJournalArticleSlideShow proGateJournalArticleSlideShow : findByupdatedAtGreater(
				updatedAt)) {
			remove(proGateJournalArticleSlideShow);
		}
	}

	public void removeByupdatedAtLower(Date updatedAt)
		throws SystemException {
		for (ProGateJournalArticleSlideShow proGateJournalArticleSlideShow : findByupdatedAtLower(
				updatedAt)) {
			remove(proGateJournalArticleSlideShow);
		}
	}

	public void removeByupdatedAtEqual(Date updatedAt)
		throws SystemException {
		for (ProGateJournalArticleSlideShow proGateJournalArticleSlideShow : findByupdatedAtEqual(
				updatedAt)) {
			remove(proGateJournalArticleSlideShow);
		}
	}

	public void removeAll() throws SystemException {
		for (ProGateJournalArticleSlideShow proGateJournalArticleSlideShow : findAll()) {
			remove(proGateJournalArticleSlideShow);
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
					"FROM larion.progate.model.ProGateJournalArticleSlideShow WHERE ");

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

	public int countByslideIndexGreater(int slideIndex)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(slideIndex) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_SLIDEINDEXGREATER,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateJournalArticleSlideShow WHERE ");

				query.append("slideindex >= ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(slideIndex);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SLIDEINDEXGREATER,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByslideIndexLower(int slideIndex) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(slideIndex) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_SLIDEINDEXLOWER,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateJournalArticleSlideShow WHERE ");

				query.append("slideindex <= ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(slideIndex);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SLIDEINDEXLOWER,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByslideIndexEqual(int slideIndex) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(slideIndex) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_SLIDEINDEXEQUAL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateJournalArticleSlideShow WHERE ");

				query.append("slideindex = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(slideIndex);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SLIDEINDEXEQUAL,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByimageUrl(String imageUrl) throws SystemException {
		Object[] finderArgs = new Object[] { imageUrl };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_IMAGEURL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateJournalArticleSlideShow WHERE ");

				if (imageUrl == null) {
					query.append("imageurl IS NULL");
				}
				else {
					query.append("imageurl = ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (imageUrl != null) {
					qPos.add(imageUrl);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_IMAGEURL,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByproductId(int productId) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(productId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PRODUCTID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateJournalArticleSlideShow WHERE ");

				query.append("productid = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(productId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PRODUCTID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countBycreatedBy(int createdBy) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(createdBy) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CREATEDBY,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateJournalArticleSlideShow WHERE ");

				query.append("created_by = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(createdBy);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CREATEDBY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countBycreatedAtEqual(Date createdAt) throws SystemException {
		Object[] finderArgs = new Object[] { createdAt };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CREATEDATEQUAL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateJournalArticleSlideShow WHERE ");

				if (createdAt == null) {
					query.append("created_at IS NULL");
				}
				else {
					query.append("created_at = ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (createdAt != null) {
					qPos.add(CalendarUtil.getTimestamp(createdAt));
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CREATEDATEQUAL,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countBycreatedAtGreater(Date createdAt)
		throws SystemException {
		Object[] finderArgs = new Object[] { createdAt };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CREATEDATGREATER,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateJournalArticleSlideShow WHERE ");

				if (createdAt == null) {
					query.append("created_at >= null");
				}
				else {
					query.append("created_at >= ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (createdAt != null) {
					qPos.add(CalendarUtil.getTimestamp(createdAt));
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CREATEDATGREATER,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countBycreatedAtLower(Date createdAt) throws SystemException {
		Object[] finderArgs = new Object[] { createdAt };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CREATEDATLOWER,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateJournalArticleSlideShow WHERE ");

				if (createdAt == null) {
					query.append("created_at <= null");
				}
				else {
					query.append("created_at <= ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (createdAt != null) {
					qPos.add(CalendarUtil.getTimestamp(createdAt));
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CREATEDATLOWER,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByupdatedBy(int updatedBy) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(updatedBy) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UPDATEDBY,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateJournalArticleSlideShow WHERE ");

				query.append("updated_by = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(updatedBy);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UPDATEDBY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByupdatedAtGreater(Date updatedAt)
		throws SystemException {
		Object[] finderArgs = new Object[] { updatedAt };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UPDATEDATGREATER,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateJournalArticleSlideShow WHERE ");

				if (updatedAt == null) {
					query.append("updated_at >= null");
				}
				else {
					query.append("updated_at >= ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (updatedAt != null) {
					qPos.add(CalendarUtil.getTimestamp(updatedAt));
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UPDATEDATGREATER,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByupdatedAtLower(Date updatedAt) throws SystemException {
		Object[] finderArgs = new Object[] { updatedAt };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UPDATEDATLOWER,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateJournalArticleSlideShow WHERE ");

				if (updatedAt == null) {
					query.append("updated_at <= null");
				}
				else {
					query.append("updated_at <= ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (updatedAt != null) {
					qPos.add(CalendarUtil.getTimestamp(updatedAt));
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UPDATEDATLOWER,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByupdatedAtEqual(Date updatedAt) throws SystemException {
		Object[] finderArgs = new Object[] { updatedAt };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UPDATEDATEQUAL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateJournalArticleSlideShow WHERE ");

				if (updatedAt == null) {
					query.append("updated_at IS NULL");
				}
				else {
					query.append("updated_at = ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (updatedAt != null) {
					qPos.add(CalendarUtil.getTimestamp(updatedAt));
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UPDATEDATEQUAL,
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
						"SELECT COUNT(*) FROM larion.progate.model.ProGateJournalArticleSlideShow");

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
						"value.object.listener.larion.progate.model.ProGateJournalArticleSlideShow")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ProGateJournalArticleSlideShow>> listenersList =
					new ArrayList<ModelListener<ProGateJournalArticleSlideShow>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ProGateJournalArticleSlideShow>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(ProGateJournalArticleSlideShowPersistenceImpl.class);
}