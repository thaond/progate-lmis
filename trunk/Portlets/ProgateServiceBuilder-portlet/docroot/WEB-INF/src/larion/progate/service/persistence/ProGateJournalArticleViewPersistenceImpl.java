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

import larion.progate.NoSuchProGateJournalArticleViewException;

import larion.progate.model.ProGateJournalArticleView;
import larion.progate.model.impl.ProGateJournalArticleViewImpl;
import larion.progate.model.impl.ProGateJournalArticleViewModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * <a href="ProGateJournalArticleViewPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateJournalArticleViewPersistenceImpl
	extends BasePersistenceImpl implements ProGateJournalArticleViewPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = ProGateJournalArticleViewImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_ORGID = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByorgId",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ORGID = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByorgId",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGID = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByorgId",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_PROGATECATEGORY = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByprogateCategory",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_PROGATECATEGORY = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByprogateCategory",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_PROGATECATEGORY = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByprogateCategory",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ARTICLETYPEEQUALS = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByarticleTypeEquals",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ARTICLETYPEEQUALS = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByarticleTypeEquals",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ARTICLETYPEEQUALS = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByarticleTypeEquals",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ARTICLETYPEGREATER = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByarticleTypeGreater",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ARTICLETYPEGREATER = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByarticleTypeGreater",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ARTICLETYPEGREATER = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByarticleTypeGreater",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ARTICLETYPELOWER = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByarticleTypeLower",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ARTICLETYPELOWER = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByarticleTypeLower",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ARTICLETYPELOWER = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByarticleTypeLower",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_PRODUCTTYPEEQUALS = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByproductTypeEquals",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_PRODUCTTYPEEQUALS = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByproductTypeEquals",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_PRODUCTTYPEEQUALS = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByproductTypeEquals",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_PRODUCTTYPEGREATER = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByproductTypeGreater",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_PRODUCTTYPEGREATER = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByproductTypeGreater",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_PRODUCTTYPEGREATER = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByproductTypeGreater",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_PRODUCTTYPELOWER = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByproductTypeLower",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_PRODUCTTYPELOWER = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByproductTypeLower",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_PRODUCTTYPELOWER = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByproductTypeLower",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_TITLE = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBytitle",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_TITLE = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBytitle",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_TITLE = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBytitle",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_PRIORITYEQUAL = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBypriorityEqual",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_PRIORITYEQUAL = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBypriorityEqual",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_PRIORITYEQUAL = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBypriorityEqual",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_PRIORITYLOWER = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBypriorityLower",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_PRIORITYLOWER = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBypriorityLower",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_PRIORITYLOWER = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBypriorityLower",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_PRIORITYGREATER = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBypriorityGreater",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_PRIORITYGREATER = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBypriorityGreater",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_PRIORITYGREATER = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBypriorityGreater",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_CREATEDBY = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycreatedBy",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_CREATEDBY = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycreatedBy",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_CREATEDBY = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBycreatedBy",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_CREATEDATEQUAL = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycreatedAtEqual",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_CREATEDATEQUAL = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycreatedAtEqual",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_CREATEDATEQUAL = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBycreatedAtEqual",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_CREATEDATGREATER = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycreatedAtGreater",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_CREATEDATGREATER = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycreatedAtGreater",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_CREATEDATGREATER = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBycreatedAtGreater",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_CREATEDATLOWER = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycreatedAtLower",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_CREATEDATLOWER = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycreatedAtLower",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_CREATEDATLOWER = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBycreatedAtLower",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_UPDATEDBY = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByupdatedBy",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_UPDATEDBY = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByupdatedBy",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_UPDATEDBY = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByupdatedBy",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_UPDATEDATGREATER = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByupdatedAtGreater",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_UPDATEDATGREATER = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByupdatedAtGreater",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_UPDATEDATGREATER = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByupdatedAtGreater",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_UPDATEDATLOWER = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByupdatedAtLower",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_UPDATEDATLOWER = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByupdatedAtLower",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_UPDATEDATLOWER = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByupdatedAtLower",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_UPDATEDATEQUAL = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByupdatedAtEqual",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_UPDATEDATEQUAL = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByupdatedAtEqual",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_UPDATEDATEQUAL = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByupdatedAtEqual",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_DISCOUNTEQUAL = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBydiscountEqual",
			new String[] { Double.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_DISCOUNTEQUAL = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBydiscountEqual",
			new String[] {
				Double.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_DISCOUNTEQUAL = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBydiscountEqual",
			new String[] { Double.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_DISCOUNTGREATER = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBydiscountGreater",
			new String[] { Double.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_DISCOUNTGREATER = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBydiscountGreater",
			new String[] {
				Double.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_DISCOUNTGREATER = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBydiscountGreater",
			new String[] { Double.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_DISCOUNTLOWER = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBydiscountLower",
			new String[] { Double.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_DISCOUNTLOWER = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBydiscountLower",
			new String[] {
				Double.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_DISCOUNTLOWER = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBydiscountLower",
			new String[] { Double.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_PRICEEQUAL = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBypriceEqual",
			new String[] { Double.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_PRICEEQUAL = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBypriceEqual",
			new String[] {
				Double.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_PRICEEQUAL = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBypriceEqual",
			new String[] { Double.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_PRICEGREATER = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBypriceGreater",
			new String[] { Double.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_PRICEGREATER = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBypriceGreater",
			new String[] {
				Double.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_PRICEGREATER = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBypriceGreater",
			new String[] { Double.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_PRICELOWER = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBypriceLower",
			new String[] { Double.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_PRICELOWER = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBypriceLower",
			new String[] {
				Double.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_PRICELOWER = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBypriceLower",
			new String[] { Double.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_PRODUCTTYPE = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByproductType",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_PRODUCTTYPE = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByproductType",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_PRODUCTTYPE = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByproductType",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ISSERVICE = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByisService",
			new String[] { Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ISSERVICE = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByisService",
			new String[] {
				Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ISSERVICE = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByisService",
			new String[] { Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ISHOT = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByisHot",
			new String[] { Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ISHOT = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByisHot",
			new String[] {
				Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ISHOT = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByisHot",
			new String[] { Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_CURRENCYCODE = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycurrencyCode",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_CURRENCYCODE = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycurrencyCode",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_CURRENCYCODE = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBycurrencyCode",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_JOURNALARTICLETYPESNAME = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByjournalArticleTypesName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_JOURNALARTICLETYPESNAME =
		new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByjournalArticleTypesName",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_JOURNALARTICLETYPESNAME = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByjournalArticleTypesName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(ProGateJournalArticleView proGateJournalArticleView) {
		EntityCacheUtil.putResult(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewImpl.class,
			proGateJournalArticleView.getPrimaryKey(), proGateJournalArticleView);
	}

	public void cacheResult(
		List<ProGateJournalArticleView> proGateJournalArticleViews) {
		for (ProGateJournalArticleView proGateJournalArticleView : proGateJournalArticleViews) {
			if (EntityCacheUtil.getResult(
						ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
						ProGateJournalArticleViewImpl.class,
						proGateJournalArticleView.getPrimaryKey(), this) == null) {
				cacheResult(proGateJournalArticleView);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(ProGateJournalArticleViewImpl.class.getName());
		EntityCacheUtil.clearCache(ProGateJournalArticleViewImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public ProGateJournalArticleView create(Integer journalArticleId) {
		ProGateJournalArticleView proGateJournalArticleView = new ProGateJournalArticleViewImpl();

		proGateJournalArticleView.setNew(true);
		proGateJournalArticleView.setPrimaryKey(journalArticleId);

		return proGateJournalArticleView;
	}

	public ProGateJournalArticleView remove(Integer journalArticleId)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ProGateJournalArticleView proGateJournalArticleView = (ProGateJournalArticleView)session.get(ProGateJournalArticleViewImpl.class,
					journalArticleId);

			if (proGateJournalArticleView == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No ProGateJournalArticleView exists with the primary key " +
						journalArticleId);
				}

				throw new NoSuchProGateJournalArticleViewException(
					"No ProGateJournalArticleView exists with the primary key " +
					journalArticleId);
			}

			return remove(proGateJournalArticleView);
		}
		catch (NoSuchProGateJournalArticleViewException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public ProGateJournalArticleView remove(
		ProGateJournalArticleView proGateJournalArticleView)
		throws SystemException {
		for (ModelListener<ProGateJournalArticleView> listener : listeners) {
			listener.onBeforeRemove(proGateJournalArticleView);
		}

		proGateJournalArticleView = removeImpl(proGateJournalArticleView);

		for (ModelListener<ProGateJournalArticleView> listener : listeners) {
			listener.onAfterRemove(proGateJournalArticleView);
		}

		return proGateJournalArticleView;
	}

	protected ProGateJournalArticleView removeImpl(
		ProGateJournalArticleView proGateJournalArticleView)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (proGateJournalArticleView.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(ProGateJournalArticleViewImpl.class,
						proGateJournalArticleView.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(proGateJournalArticleView);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewImpl.class,
			proGateJournalArticleView.getPrimaryKey());

		return proGateJournalArticleView;
	}

	public ProGateJournalArticleView update(
		ProGateJournalArticleView proGateJournalArticleView)
		throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(ProGateJournalArticleView proGateJournalArticleView) method. Use update(ProGateJournalArticleView proGateJournalArticleView, boolean merge) instead.");
		}

		return update(proGateJournalArticleView, false);
	}

	public ProGateJournalArticleView update(
		ProGateJournalArticleView proGateJournalArticleView, boolean merge)
		throws SystemException {
		boolean isNew = proGateJournalArticleView.isNew();

		for (ModelListener<ProGateJournalArticleView> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(proGateJournalArticleView);
			}
			else {
				listener.onBeforeUpdate(proGateJournalArticleView);
			}
		}

		proGateJournalArticleView = updateImpl(proGateJournalArticleView, merge);

		for (ModelListener<ProGateJournalArticleView> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(proGateJournalArticleView);
			}
			else {
				listener.onAfterUpdate(proGateJournalArticleView);
			}
		}

		return proGateJournalArticleView;
	}

	public ProGateJournalArticleView updateImpl(
		larion.progate.model.ProGateJournalArticleView proGateJournalArticleView,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, proGateJournalArticleView, merge);

			proGateJournalArticleView.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleViewImpl.class,
			proGateJournalArticleView.getPrimaryKey(), proGateJournalArticleView);

		return proGateJournalArticleView;
	}

	public ProGateJournalArticleView findByPrimaryKey(Integer journalArticleId)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		ProGateJournalArticleView proGateJournalArticleView = fetchByPrimaryKey(journalArticleId);

		if (proGateJournalArticleView == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"No ProGateJournalArticleView exists with the primary key " +
					journalArticleId);
			}

			throw new NoSuchProGateJournalArticleViewException(
				"No ProGateJournalArticleView exists with the primary key " +
				journalArticleId);
		}

		return proGateJournalArticleView;
	}

	public ProGateJournalArticleView fetchByPrimaryKey(Integer journalArticleId)
		throws SystemException {
		ProGateJournalArticleView proGateJournalArticleView = (ProGateJournalArticleView)EntityCacheUtil.getResult(ProGateJournalArticleViewModelImpl.ENTITY_CACHE_ENABLED,
				ProGateJournalArticleViewImpl.class, journalArticleId, this);

		if (proGateJournalArticleView == null) {
			Session session = null;

			try {
				session = openSession();

				proGateJournalArticleView = (ProGateJournalArticleView)session.get(ProGateJournalArticleViewImpl.class,
						journalArticleId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (proGateJournalArticleView != null) {
					cacheResult(proGateJournalArticleView);
				}

				closeSession(session);
			}
		}

		return proGateJournalArticleView;
	}

	public List<ProGateJournalArticleView> findByorgId(String orgId)
		throws SystemException {
		Object[] finderArgs = new Object[] { orgId };

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ORGID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				if (orgId == null) {
					query.append("orgid IS NULL");
				}
				else {
					query.append("orgid = ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (orgId != null) {
					qPos.add(orgId);
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ORGID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticleView> findByorgId(String orgId, int start,
		int end) throws SystemException {
		return findByorgId(orgId, start, end, null);
	}

	public List<ProGateJournalArticleView> findByorgId(String orgId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				orgId,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ORGID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				if (orgId == null) {
					query.append("orgid IS NULL");
				}
				else {
					query.append("orgid = ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("updated_at DESC, ");
					query.append("created_at DESC, ");
					query.append("priority DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (orgId != null) {
					qPos.add(orgId);
				}

				list = (List<ProGateJournalArticleView>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ORGID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticleView findByorgId_First(String orgId,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		List<ProGateJournalArticleView> list = findByorgId(orgId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("orgId=" + orgId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView findByorgId_Last(String orgId,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		int count = countByorgId(orgId);

		List<ProGateJournalArticleView> list = findByorgId(orgId, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("orgId=" + orgId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView[] findByorgId_PrevAndNext(
		Integer journalArticleId, String orgId, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		ProGateJournalArticleView proGateJournalArticleView = findByPrimaryKey(journalArticleId);

		int count = countByorgId(orgId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

			if (orgId == null) {
				query.append("orgid IS NULL");
			}
			else {
				query.append("orgid = ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (orgId != null) {
				qPos.add(orgId);
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticleView);

			ProGateJournalArticleView[] array = new ProGateJournalArticleViewImpl[3];

			array[0] = (ProGateJournalArticleView)objArray[0];
			array[1] = (ProGateJournalArticleView)objArray[1];
			array[2] = (ProGateJournalArticleView)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticleView> findByprogateCategory(
		int progateCategory) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(progateCategory) };

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_PROGATECATEGORY,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				query.append("progate_category = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");

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
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_PROGATECATEGORY,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticleView> findByprogateCategory(
		int progateCategory, int start, int end) throws SystemException {
		return findByprogateCategory(progateCategory, start, end, null);
	}

	public List<ProGateJournalArticleView> findByprogateCategory(
		int progateCategory, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(progateCategory),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_PROGATECATEGORY,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				query.append("progate_category = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("updated_at DESC, ");
					query.append("created_at DESC, ");
					query.append("priority DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(progateCategory);

				list = (List<ProGateJournalArticleView>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_PROGATECATEGORY,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticleView findByprogateCategory_First(
		int progateCategory, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		List<ProGateJournalArticleView> list = findByprogateCategory(progateCategory,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("progateCategory=" + progateCategory);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView findByprogateCategory_Last(
		int progateCategory, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		int count = countByprogateCategory(progateCategory);

		List<ProGateJournalArticleView> list = findByprogateCategory(progateCategory,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("progateCategory=" + progateCategory);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView[] findByprogateCategory_PrevAndNext(
		Integer journalArticleId, int progateCategory, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		ProGateJournalArticleView proGateJournalArticleView = findByPrimaryKey(journalArticleId);

		int count = countByprogateCategory(progateCategory);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

			query.append("progate_category = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(progateCategory);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticleView);

			ProGateJournalArticleView[] array = new ProGateJournalArticleViewImpl[3];

			array[0] = (ProGateJournalArticleView)objArray[0];
			array[1] = (ProGateJournalArticleView)objArray[1];
			array[2] = (ProGateJournalArticleView)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticleView> findByarticleTypeEquals(
		int articleType) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(articleType) };

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ARTICLETYPEEQUALS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				query.append("articletype = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(articleType);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ARTICLETYPEEQUALS,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticleView> findByarticleTypeEquals(
		int articleType, int start, int end) throws SystemException {
		return findByarticleTypeEquals(articleType, start, end, null);
	}

	public List<ProGateJournalArticleView> findByarticleTypeEquals(
		int articleType, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(articleType),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ARTICLETYPEEQUALS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				query.append("articletype = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("updated_at DESC, ");
					query.append("created_at DESC, ");
					query.append("priority DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(articleType);

				list = (List<ProGateJournalArticleView>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ARTICLETYPEEQUALS,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticleView findByarticleTypeEquals_First(
		int articleType, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		List<ProGateJournalArticleView> list = findByarticleTypeEquals(articleType,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("articleType=" + articleType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView findByarticleTypeEquals_Last(
		int articleType, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		int count = countByarticleTypeEquals(articleType);

		List<ProGateJournalArticleView> list = findByarticleTypeEquals(articleType,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("articleType=" + articleType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView[] findByarticleTypeEquals_PrevAndNext(
		Integer journalArticleId, int articleType, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		ProGateJournalArticleView proGateJournalArticleView = findByPrimaryKey(journalArticleId);

		int count = countByarticleTypeEquals(articleType);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

			query.append("articletype = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(articleType);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticleView);

			ProGateJournalArticleView[] array = new ProGateJournalArticleViewImpl[3];

			array[0] = (ProGateJournalArticleView)objArray[0];
			array[1] = (ProGateJournalArticleView)objArray[1];
			array[2] = (ProGateJournalArticleView)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticleView> findByarticleTypeGreater(
		int articleType) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(articleType) };

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ARTICLETYPEGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				query.append("articletype >= ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(articleType);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ARTICLETYPEGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticleView> findByarticleTypeGreater(
		int articleType, int start, int end) throws SystemException {
		return findByarticleTypeGreater(articleType, start, end, null);
	}

	public List<ProGateJournalArticleView> findByarticleTypeGreater(
		int articleType, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(articleType),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ARTICLETYPEGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				query.append("articletype >= ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("updated_at DESC, ");
					query.append("created_at DESC, ");
					query.append("priority DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(articleType);

				list = (List<ProGateJournalArticleView>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ARTICLETYPEGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticleView findByarticleTypeGreater_First(
		int articleType, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		List<ProGateJournalArticleView> list = findByarticleTypeGreater(articleType,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("articleType=" + articleType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView findByarticleTypeGreater_Last(
		int articleType, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		int count = countByarticleTypeGreater(articleType);

		List<ProGateJournalArticleView> list = findByarticleTypeGreater(articleType,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("articleType=" + articleType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView[] findByarticleTypeGreater_PrevAndNext(
		Integer journalArticleId, int articleType, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		ProGateJournalArticleView proGateJournalArticleView = findByPrimaryKey(journalArticleId);

		int count = countByarticleTypeGreater(articleType);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

			query.append("articletype >= ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(articleType);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticleView);

			ProGateJournalArticleView[] array = new ProGateJournalArticleViewImpl[3];

			array[0] = (ProGateJournalArticleView)objArray[0];
			array[1] = (ProGateJournalArticleView)objArray[1];
			array[2] = (ProGateJournalArticleView)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticleView> findByarticleTypeLower(
		int articleType) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(articleType) };

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ARTICLETYPELOWER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				query.append("articletype <= ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(articleType);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ARTICLETYPELOWER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticleView> findByarticleTypeLower(
		int articleType, int start, int end) throws SystemException {
		return findByarticleTypeLower(articleType, start, end, null);
	}

	public List<ProGateJournalArticleView> findByarticleTypeLower(
		int articleType, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(articleType),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ARTICLETYPELOWER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				query.append("articletype <= ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("updated_at DESC, ");
					query.append("created_at DESC, ");
					query.append("priority DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(articleType);

				list = (List<ProGateJournalArticleView>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ARTICLETYPELOWER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticleView findByarticleTypeLower_First(
		int articleType, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		List<ProGateJournalArticleView> list = findByarticleTypeLower(articleType,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("articleType=" + articleType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView findByarticleTypeLower_Last(
		int articleType, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		int count = countByarticleTypeLower(articleType);

		List<ProGateJournalArticleView> list = findByarticleTypeLower(articleType,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("articleType=" + articleType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView[] findByarticleTypeLower_PrevAndNext(
		Integer journalArticleId, int articleType, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		ProGateJournalArticleView proGateJournalArticleView = findByPrimaryKey(journalArticleId);

		int count = countByarticleTypeLower(articleType);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

			query.append("articletype <= ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(articleType);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticleView);

			ProGateJournalArticleView[] array = new ProGateJournalArticleViewImpl[3];

			array[0] = (ProGateJournalArticleView)objArray[0];
			array[1] = (ProGateJournalArticleView)objArray[1];
			array[2] = (ProGateJournalArticleView)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticleView> findByproductTypeEquals(
		int productType) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(productType) };

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_PRODUCTTYPEEQUALS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				query.append("producttype = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");

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
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_PRODUCTTYPEEQUALS,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticleView> findByproductTypeEquals(
		int productType, int start, int end) throws SystemException {
		return findByproductTypeEquals(productType, start, end, null);
	}

	public List<ProGateJournalArticleView> findByproductTypeEquals(
		int productType, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(productType),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_PRODUCTTYPEEQUALS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				query.append("producttype = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("updated_at DESC, ");
					query.append("created_at DESC, ");
					query.append("priority DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(productType);

				list = (List<ProGateJournalArticleView>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_PRODUCTTYPEEQUALS,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticleView findByproductTypeEquals_First(
		int productType, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		List<ProGateJournalArticleView> list = findByproductTypeEquals(productType,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("productType=" + productType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView findByproductTypeEquals_Last(
		int productType, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		int count = countByproductTypeEquals(productType);

		List<ProGateJournalArticleView> list = findByproductTypeEquals(productType,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("productType=" + productType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView[] findByproductTypeEquals_PrevAndNext(
		Integer journalArticleId, int productType, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		ProGateJournalArticleView proGateJournalArticleView = findByPrimaryKey(journalArticleId);

		int count = countByproductTypeEquals(productType);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

			query.append("producttype = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(productType);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticleView);

			ProGateJournalArticleView[] array = new ProGateJournalArticleViewImpl[3];

			array[0] = (ProGateJournalArticleView)objArray[0];
			array[1] = (ProGateJournalArticleView)objArray[1];
			array[2] = (ProGateJournalArticleView)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticleView> findByproductTypeGreater(
		int productType) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(productType) };

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_PRODUCTTYPEGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				query.append("producttype >= ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");

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
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_PRODUCTTYPEGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticleView> findByproductTypeGreater(
		int productType, int start, int end) throws SystemException {
		return findByproductTypeGreater(productType, start, end, null);
	}

	public List<ProGateJournalArticleView> findByproductTypeGreater(
		int productType, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(productType),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_PRODUCTTYPEGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				query.append("producttype >= ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("updated_at DESC, ");
					query.append("created_at DESC, ");
					query.append("priority DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(productType);

				list = (List<ProGateJournalArticleView>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_PRODUCTTYPEGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticleView findByproductTypeGreater_First(
		int productType, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		List<ProGateJournalArticleView> list = findByproductTypeGreater(productType,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("productType=" + productType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView findByproductTypeGreater_Last(
		int productType, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		int count = countByproductTypeGreater(productType);

		List<ProGateJournalArticleView> list = findByproductTypeGreater(productType,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("productType=" + productType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView[] findByproductTypeGreater_PrevAndNext(
		Integer journalArticleId, int productType, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		ProGateJournalArticleView proGateJournalArticleView = findByPrimaryKey(journalArticleId);

		int count = countByproductTypeGreater(productType);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

			query.append("producttype >= ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(productType);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticleView);

			ProGateJournalArticleView[] array = new ProGateJournalArticleViewImpl[3];

			array[0] = (ProGateJournalArticleView)objArray[0];
			array[1] = (ProGateJournalArticleView)objArray[1];
			array[2] = (ProGateJournalArticleView)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticleView> findByproductTypeLower(
		int productType) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(productType) };

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_PRODUCTTYPELOWER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				query.append("producttype <= ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");

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
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_PRODUCTTYPELOWER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticleView> findByproductTypeLower(
		int productType, int start, int end) throws SystemException {
		return findByproductTypeLower(productType, start, end, null);
	}

	public List<ProGateJournalArticleView> findByproductTypeLower(
		int productType, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(productType),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_PRODUCTTYPELOWER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				query.append("producttype <= ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("updated_at DESC, ");
					query.append("created_at DESC, ");
					query.append("priority DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(productType);

				list = (List<ProGateJournalArticleView>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_PRODUCTTYPELOWER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticleView findByproductTypeLower_First(
		int productType, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		List<ProGateJournalArticleView> list = findByproductTypeLower(productType,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("productType=" + productType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView findByproductTypeLower_Last(
		int productType, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		int count = countByproductTypeLower(productType);

		List<ProGateJournalArticleView> list = findByproductTypeLower(productType,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("productType=" + productType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView[] findByproductTypeLower_PrevAndNext(
		Integer journalArticleId, int productType, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		ProGateJournalArticleView proGateJournalArticleView = findByPrimaryKey(journalArticleId);

		int count = countByproductTypeLower(productType);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

			query.append("producttype <= ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(productType);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticleView);

			ProGateJournalArticleView[] array = new ProGateJournalArticleViewImpl[3];

			array[0] = (ProGateJournalArticleView)objArray[0];
			array[1] = (ProGateJournalArticleView)objArray[1];
			array[2] = (ProGateJournalArticleView)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticleView> findBytitle(String title)
		throws SystemException {
		Object[] finderArgs = new Object[] { title };

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_TITLE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				if (title == null) {
					query.append("title LIKE null");
				}
				else {
					query.append("title LIKE ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (title != null) {
					qPos.add(title);
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_TITLE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticleView> findBytitle(String title, int start,
		int end) throws SystemException {
		return findBytitle(title, start, end, null);
	}

	public List<ProGateJournalArticleView> findBytitle(String title, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				title,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_TITLE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				if (title == null) {
					query.append("title LIKE null");
				}
				else {
					query.append("title LIKE ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("updated_at DESC, ");
					query.append("created_at DESC, ");
					query.append("priority DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (title != null) {
					qPos.add(title);
				}

				list = (List<ProGateJournalArticleView>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_TITLE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticleView findBytitle_First(String title,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		List<ProGateJournalArticleView> list = findBytitle(title, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("title=" + title);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView findBytitle_Last(String title,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		int count = countBytitle(title);

		List<ProGateJournalArticleView> list = findBytitle(title, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("title=" + title);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView[] findBytitle_PrevAndNext(
		Integer journalArticleId, String title, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		ProGateJournalArticleView proGateJournalArticleView = findByPrimaryKey(journalArticleId);

		int count = countBytitle(title);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

			if (title == null) {
				query.append("title LIKE null");
			}
			else {
				query.append("title LIKE ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (title != null) {
				qPos.add(title);
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticleView);

			ProGateJournalArticleView[] array = new ProGateJournalArticleViewImpl[3];

			array[0] = (ProGateJournalArticleView)objArray[0];
			array[1] = (ProGateJournalArticleView)objArray[1];
			array[2] = (ProGateJournalArticleView)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticleView> findBypriorityEqual(int priority)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(priority) };

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_PRIORITYEQUAL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				query.append("priority = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(priority);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_PRIORITYEQUAL,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticleView> findBypriorityEqual(int priority,
		int start, int end) throws SystemException {
		return findBypriorityEqual(priority, start, end, null);
	}

	public List<ProGateJournalArticleView> findBypriorityEqual(int priority,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(priority),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_PRIORITYEQUAL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				query.append("priority = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("updated_at DESC, ");
					query.append("created_at DESC, ");
					query.append("priority DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(priority);

				list = (List<ProGateJournalArticleView>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_PRIORITYEQUAL,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticleView findBypriorityEqual_First(int priority,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		List<ProGateJournalArticleView> list = findBypriorityEqual(priority, 0,
				1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("priority=" + priority);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView findBypriorityEqual_Last(int priority,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		int count = countBypriorityEqual(priority);

		List<ProGateJournalArticleView> list = findBypriorityEqual(priority,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("priority=" + priority);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView[] findBypriorityEqual_PrevAndNext(
		Integer journalArticleId, int priority, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		ProGateJournalArticleView proGateJournalArticleView = findByPrimaryKey(journalArticleId);

		int count = countBypriorityEqual(priority);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

			query.append("priority = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(priority);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticleView);

			ProGateJournalArticleView[] array = new ProGateJournalArticleViewImpl[3];

			array[0] = (ProGateJournalArticleView)objArray[0];
			array[1] = (ProGateJournalArticleView)objArray[1];
			array[2] = (ProGateJournalArticleView)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticleView> findBypriorityLower(int priority)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(priority) };

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_PRIORITYLOWER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				query.append("priority <= ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(priority);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_PRIORITYLOWER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticleView> findBypriorityLower(int priority,
		int start, int end) throws SystemException {
		return findBypriorityLower(priority, start, end, null);
	}

	public List<ProGateJournalArticleView> findBypriorityLower(int priority,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(priority),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_PRIORITYLOWER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				query.append("priority <= ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("updated_at DESC, ");
					query.append("created_at DESC, ");
					query.append("priority DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(priority);

				list = (List<ProGateJournalArticleView>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_PRIORITYLOWER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticleView findBypriorityLower_First(int priority,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		List<ProGateJournalArticleView> list = findBypriorityLower(priority, 0,
				1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("priority=" + priority);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView findBypriorityLower_Last(int priority,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		int count = countBypriorityLower(priority);

		List<ProGateJournalArticleView> list = findBypriorityLower(priority,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("priority=" + priority);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView[] findBypriorityLower_PrevAndNext(
		Integer journalArticleId, int priority, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		ProGateJournalArticleView proGateJournalArticleView = findByPrimaryKey(journalArticleId);

		int count = countBypriorityLower(priority);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

			query.append("priority <= ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(priority);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticleView);

			ProGateJournalArticleView[] array = new ProGateJournalArticleViewImpl[3];

			array[0] = (ProGateJournalArticleView)objArray[0];
			array[1] = (ProGateJournalArticleView)objArray[1];
			array[2] = (ProGateJournalArticleView)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticleView> findBypriorityGreater(int priority)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(priority) };

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_PRIORITYGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				query.append("priority >= ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(priority);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_PRIORITYGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticleView> findBypriorityGreater(int priority,
		int start, int end) throws SystemException {
		return findBypriorityGreater(priority, start, end, null);
	}

	public List<ProGateJournalArticleView> findBypriorityGreater(int priority,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(priority),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_PRIORITYGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				query.append("priority >= ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("updated_at DESC, ");
					query.append("created_at DESC, ");
					query.append("priority DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(priority);

				list = (List<ProGateJournalArticleView>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_PRIORITYGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticleView findBypriorityGreater_First(int priority,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		List<ProGateJournalArticleView> list = findBypriorityGreater(priority,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("priority=" + priority);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView findBypriorityGreater_Last(int priority,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		int count = countBypriorityGreater(priority);

		List<ProGateJournalArticleView> list = findBypriorityGreater(priority,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("priority=" + priority);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView[] findBypriorityGreater_PrevAndNext(
		Integer journalArticleId, int priority, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		ProGateJournalArticleView proGateJournalArticleView = findByPrimaryKey(journalArticleId);

		int count = countBypriorityGreater(priority);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

			query.append("priority >= ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(priority);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticleView);

			ProGateJournalArticleView[] array = new ProGateJournalArticleViewImpl[3];

			array[0] = (ProGateJournalArticleView)objArray[0];
			array[1] = (ProGateJournalArticleView)objArray[1];
			array[2] = (ProGateJournalArticleView)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticleView> findBycreatedBy(int createdBy)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(createdBy) };

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_CREATEDBY,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				query.append("created_by = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");

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
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_CREATEDBY,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticleView> findBycreatedBy(int createdBy,
		int start, int end) throws SystemException {
		return findBycreatedBy(createdBy, start, end, null);
	}

	public List<ProGateJournalArticleView> findBycreatedBy(int createdBy,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(createdBy),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_CREATEDBY,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				query.append("created_by = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("updated_at DESC, ");
					query.append("created_at DESC, ");
					query.append("priority DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(createdBy);

				list = (List<ProGateJournalArticleView>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_CREATEDBY,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticleView findBycreatedBy_First(int createdBy,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		List<ProGateJournalArticleView> list = findBycreatedBy(createdBy, 0, 1,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("createdBy=" + createdBy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView findBycreatedBy_Last(int createdBy,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		int count = countBycreatedBy(createdBy);

		List<ProGateJournalArticleView> list = findBycreatedBy(createdBy,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("createdBy=" + createdBy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView[] findBycreatedBy_PrevAndNext(
		Integer journalArticleId, int createdBy, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		ProGateJournalArticleView proGateJournalArticleView = findByPrimaryKey(journalArticleId);

		int count = countBycreatedBy(createdBy);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

			query.append("created_by = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(createdBy);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticleView);

			ProGateJournalArticleView[] array = new ProGateJournalArticleViewImpl[3];

			array[0] = (ProGateJournalArticleView)objArray[0];
			array[1] = (ProGateJournalArticleView)objArray[1];
			array[2] = (ProGateJournalArticleView)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticleView> findBycreatedAtEqual(Date createdAt)
		throws SystemException {
		Object[] finderArgs = new Object[] { createdAt };

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_CREATEDATEQUAL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				if (createdAt == null) {
					query.append("created_at IS NULL");
				}
				else {
					query.append("created_at = ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");

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
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_CREATEDATEQUAL,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticleView> findBycreatedAtEqual(
		Date createdAt, int start, int end) throws SystemException {
		return findBycreatedAtEqual(createdAt, start, end, null);
	}

	public List<ProGateJournalArticleView> findBycreatedAtEqual(
		Date createdAt, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				createdAt,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_CREATEDATEQUAL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

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

					query.append("updated_at DESC, ");
					query.append("created_at DESC, ");
					query.append("priority DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (createdAt != null) {
					qPos.add(CalendarUtil.getTimestamp(createdAt));
				}

				list = (List<ProGateJournalArticleView>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_CREATEDATEQUAL,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticleView findBycreatedAtEqual_First(
		Date createdAt, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		List<ProGateJournalArticleView> list = findBycreatedAtEqual(createdAt,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("createdAt=" + createdAt);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView findBycreatedAtEqual_Last(Date createdAt,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		int count = countBycreatedAtEqual(createdAt);

		List<ProGateJournalArticleView> list = findBycreatedAtEqual(createdAt,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("createdAt=" + createdAt);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView[] findBycreatedAtEqual_PrevAndNext(
		Integer journalArticleId, Date createdAt, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		ProGateJournalArticleView proGateJournalArticleView = findByPrimaryKey(journalArticleId);

		int count = countBycreatedAtEqual(createdAt);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

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

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (createdAt != null) {
				qPos.add(CalendarUtil.getTimestamp(createdAt));
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticleView);

			ProGateJournalArticleView[] array = new ProGateJournalArticleViewImpl[3];

			array[0] = (ProGateJournalArticleView)objArray[0];
			array[1] = (ProGateJournalArticleView)objArray[1];
			array[2] = (ProGateJournalArticleView)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticleView> findBycreatedAtGreater(
		Date createdAt) throws SystemException {
		Object[] finderArgs = new Object[] { createdAt };

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_CREATEDATGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				if (createdAt == null) {
					query.append("created_at >= null");
				}
				else {
					query.append("created_at >= ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");

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
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_CREATEDATGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticleView> findBycreatedAtGreater(
		Date createdAt, int start, int end) throws SystemException {
		return findBycreatedAtGreater(createdAt, start, end, null);
	}

	public List<ProGateJournalArticleView> findBycreatedAtGreater(
		Date createdAt, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				createdAt,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_CREATEDATGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

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

					query.append("updated_at DESC, ");
					query.append("created_at DESC, ");
					query.append("priority DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (createdAt != null) {
					qPos.add(CalendarUtil.getTimestamp(createdAt));
				}

				list = (List<ProGateJournalArticleView>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_CREATEDATGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticleView findBycreatedAtGreater_First(
		Date createdAt, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		List<ProGateJournalArticleView> list = findBycreatedAtGreater(createdAt,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("createdAt=" + createdAt);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView findBycreatedAtGreater_Last(
		Date createdAt, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		int count = countBycreatedAtGreater(createdAt);

		List<ProGateJournalArticleView> list = findBycreatedAtGreater(createdAt,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("createdAt=" + createdAt);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView[] findBycreatedAtGreater_PrevAndNext(
		Integer journalArticleId, Date createdAt, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		ProGateJournalArticleView proGateJournalArticleView = findByPrimaryKey(journalArticleId);

		int count = countBycreatedAtGreater(createdAt);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

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

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (createdAt != null) {
				qPos.add(CalendarUtil.getTimestamp(createdAt));
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticleView);

			ProGateJournalArticleView[] array = new ProGateJournalArticleViewImpl[3];

			array[0] = (ProGateJournalArticleView)objArray[0];
			array[1] = (ProGateJournalArticleView)objArray[1];
			array[2] = (ProGateJournalArticleView)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticleView> findBycreatedAtLower(Date createdAt)
		throws SystemException {
		Object[] finderArgs = new Object[] { createdAt };

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_CREATEDATLOWER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				if (createdAt == null) {
					query.append("created_at <= null");
				}
				else {
					query.append("created_at <= ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");

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
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_CREATEDATLOWER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticleView> findBycreatedAtLower(
		Date createdAt, int start, int end) throws SystemException {
		return findBycreatedAtLower(createdAt, start, end, null);
	}

	public List<ProGateJournalArticleView> findBycreatedAtLower(
		Date createdAt, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				createdAt,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_CREATEDATLOWER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

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

					query.append("updated_at DESC, ");
					query.append("created_at DESC, ");
					query.append("priority DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (createdAt != null) {
					qPos.add(CalendarUtil.getTimestamp(createdAt));
				}

				list = (List<ProGateJournalArticleView>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_CREATEDATLOWER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticleView findBycreatedAtLower_First(
		Date createdAt, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		List<ProGateJournalArticleView> list = findBycreatedAtLower(createdAt,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("createdAt=" + createdAt);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView findBycreatedAtLower_Last(Date createdAt,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		int count = countBycreatedAtLower(createdAt);

		List<ProGateJournalArticleView> list = findBycreatedAtLower(createdAt,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("createdAt=" + createdAt);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView[] findBycreatedAtLower_PrevAndNext(
		Integer journalArticleId, Date createdAt, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		ProGateJournalArticleView proGateJournalArticleView = findByPrimaryKey(journalArticleId);

		int count = countBycreatedAtLower(createdAt);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

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

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (createdAt != null) {
				qPos.add(CalendarUtil.getTimestamp(createdAt));
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticleView);

			ProGateJournalArticleView[] array = new ProGateJournalArticleViewImpl[3];

			array[0] = (ProGateJournalArticleView)objArray[0];
			array[1] = (ProGateJournalArticleView)objArray[1];
			array[2] = (ProGateJournalArticleView)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticleView> findByupdatedBy(int updatedBy)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(updatedBy) };

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_UPDATEDBY,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				query.append("updated_by = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");

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
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_UPDATEDBY,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticleView> findByupdatedBy(int updatedBy,
		int start, int end) throws SystemException {
		return findByupdatedBy(updatedBy, start, end, null);
	}

	public List<ProGateJournalArticleView> findByupdatedBy(int updatedBy,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(updatedBy),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_UPDATEDBY,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				query.append("updated_by = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("updated_at DESC, ");
					query.append("created_at DESC, ");
					query.append("priority DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(updatedBy);

				list = (List<ProGateJournalArticleView>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_UPDATEDBY,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticleView findByupdatedBy_First(int updatedBy,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		List<ProGateJournalArticleView> list = findByupdatedBy(updatedBy, 0, 1,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("updatedBy=" + updatedBy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView findByupdatedBy_Last(int updatedBy,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		int count = countByupdatedBy(updatedBy);

		List<ProGateJournalArticleView> list = findByupdatedBy(updatedBy,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("updatedBy=" + updatedBy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView[] findByupdatedBy_PrevAndNext(
		Integer journalArticleId, int updatedBy, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		ProGateJournalArticleView proGateJournalArticleView = findByPrimaryKey(journalArticleId);

		int count = countByupdatedBy(updatedBy);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

			query.append("updated_by = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(updatedBy);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticleView);

			ProGateJournalArticleView[] array = new ProGateJournalArticleViewImpl[3];

			array[0] = (ProGateJournalArticleView)objArray[0];
			array[1] = (ProGateJournalArticleView)objArray[1];
			array[2] = (ProGateJournalArticleView)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticleView> findByupdatedAtGreater(
		Date updatedAt) throws SystemException {
		Object[] finderArgs = new Object[] { updatedAt };

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_UPDATEDATGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				if (updatedAt == null) {
					query.append("updated_at >= null");
				}
				else {
					query.append("updated_at >= ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");

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
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_UPDATEDATGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticleView> findByupdatedAtGreater(
		Date updatedAt, int start, int end) throws SystemException {
		return findByupdatedAtGreater(updatedAt, start, end, null);
	}

	public List<ProGateJournalArticleView> findByupdatedAtGreater(
		Date updatedAt, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				updatedAt,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_UPDATEDATGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

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

					query.append("updated_at DESC, ");
					query.append("created_at DESC, ");
					query.append("priority DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (updatedAt != null) {
					qPos.add(CalendarUtil.getTimestamp(updatedAt));
				}

				list = (List<ProGateJournalArticleView>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_UPDATEDATGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticleView findByupdatedAtGreater_First(
		Date updatedAt, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		List<ProGateJournalArticleView> list = findByupdatedAtGreater(updatedAt,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("updatedAt=" + updatedAt);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView findByupdatedAtGreater_Last(
		Date updatedAt, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		int count = countByupdatedAtGreater(updatedAt);

		List<ProGateJournalArticleView> list = findByupdatedAtGreater(updatedAt,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("updatedAt=" + updatedAt);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView[] findByupdatedAtGreater_PrevAndNext(
		Integer journalArticleId, Date updatedAt, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		ProGateJournalArticleView proGateJournalArticleView = findByPrimaryKey(journalArticleId);

		int count = countByupdatedAtGreater(updatedAt);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

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

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (updatedAt != null) {
				qPos.add(CalendarUtil.getTimestamp(updatedAt));
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticleView);

			ProGateJournalArticleView[] array = new ProGateJournalArticleViewImpl[3];

			array[0] = (ProGateJournalArticleView)objArray[0];
			array[1] = (ProGateJournalArticleView)objArray[1];
			array[2] = (ProGateJournalArticleView)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticleView> findByupdatedAtLower(Date updatedAt)
		throws SystemException {
		Object[] finderArgs = new Object[] { updatedAt };

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_UPDATEDATLOWER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				if (updatedAt == null) {
					query.append("updated_at <= null");
				}
				else {
					query.append("updated_at <= ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");

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
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_UPDATEDATLOWER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticleView> findByupdatedAtLower(
		Date updatedAt, int start, int end) throws SystemException {
		return findByupdatedAtLower(updatedAt, start, end, null);
	}

	public List<ProGateJournalArticleView> findByupdatedAtLower(
		Date updatedAt, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				updatedAt,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_UPDATEDATLOWER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

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

					query.append("updated_at DESC, ");
					query.append("created_at DESC, ");
					query.append("priority DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (updatedAt != null) {
					qPos.add(CalendarUtil.getTimestamp(updatedAt));
				}

				list = (List<ProGateJournalArticleView>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_UPDATEDATLOWER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticleView findByupdatedAtLower_First(
		Date updatedAt, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		List<ProGateJournalArticleView> list = findByupdatedAtLower(updatedAt,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("updatedAt=" + updatedAt);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView findByupdatedAtLower_Last(Date updatedAt,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		int count = countByupdatedAtLower(updatedAt);

		List<ProGateJournalArticleView> list = findByupdatedAtLower(updatedAt,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("updatedAt=" + updatedAt);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView[] findByupdatedAtLower_PrevAndNext(
		Integer journalArticleId, Date updatedAt, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		ProGateJournalArticleView proGateJournalArticleView = findByPrimaryKey(journalArticleId);

		int count = countByupdatedAtLower(updatedAt);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

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

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (updatedAt != null) {
				qPos.add(CalendarUtil.getTimestamp(updatedAt));
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticleView);

			ProGateJournalArticleView[] array = new ProGateJournalArticleViewImpl[3];

			array[0] = (ProGateJournalArticleView)objArray[0];
			array[1] = (ProGateJournalArticleView)objArray[1];
			array[2] = (ProGateJournalArticleView)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticleView> findByupdatedAtEqual(Date updatedAt)
		throws SystemException {
		Object[] finderArgs = new Object[] { updatedAt };

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_UPDATEDATEQUAL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				if (updatedAt == null) {
					query.append("updated_at IS NULL");
				}
				else {
					query.append("updated_at = ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");

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
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_UPDATEDATEQUAL,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticleView> findByupdatedAtEqual(
		Date updatedAt, int start, int end) throws SystemException {
		return findByupdatedAtEqual(updatedAt, start, end, null);
	}

	public List<ProGateJournalArticleView> findByupdatedAtEqual(
		Date updatedAt, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				updatedAt,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_UPDATEDATEQUAL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

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

					query.append("updated_at DESC, ");
					query.append("created_at DESC, ");
					query.append("priority DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (updatedAt != null) {
					qPos.add(CalendarUtil.getTimestamp(updatedAt));
				}

				list = (List<ProGateJournalArticleView>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_UPDATEDATEQUAL,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticleView findByupdatedAtEqual_First(
		Date updatedAt, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		List<ProGateJournalArticleView> list = findByupdatedAtEqual(updatedAt,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("updatedAt=" + updatedAt);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView findByupdatedAtEqual_Last(Date updatedAt,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		int count = countByupdatedAtEqual(updatedAt);

		List<ProGateJournalArticleView> list = findByupdatedAtEqual(updatedAt,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("updatedAt=" + updatedAt);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView[] findByupdatedAtEqual_PrevAndNext(
		Integer journalArticleId, Date updatedAt, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		ProGateJournalArticleView proGateJournalArticleView = findByPrimaryKey(journalArticleId);

		int count = countByupdatedAtEqual(updatedAt);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

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

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (updatedAt != null) {
				qPos.add(CalendarUtil.getTimestamp(updatedAt));
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticleView);

			ProGateJournalArticleView[] array = new ProGateJournalArticleViewImpl[3];

			array[0] = (ProGateJournalArticleView)objArray[0];
			array[1] = (ProGateJournalArticleView)objArray[1];
			array[2] = (ProGateJournalArticleView)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticleView> findBydiscountEqual(double discount)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Double(discount) };

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DISCOUNTEQUAL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				query.append("discount = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");

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
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DISCOUNTEQUAL,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticleView> findBydiscountEqual(
		double discount, int start, int end) throws SystemException {
		return findBydiscountEqual(discount, start, end, null);
	}

	public List<ProGateJournalArticleView> findBydiscountEqual(
		double discount, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				new Double(discount),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_DISCOUNTEQUAL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				query.append("discount = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("updated_at DESC, ");
					query.append("created_at DESC, ");
					query.append("priority DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(discount);

				list = (List<ProGateJournalArticleView>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_DISCOUNTEQUAL,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticleView findBydiscountEqual_First(
		double discount, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		List<ProGateJournalArticleView> list = findBydiscountEqual(discount, 0,
				1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("discount=" + discount);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView findBydiscountEqual_Last(double discount,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		int count = countBydiscountEqual(discount);

		List<ProGateJournalArticleView> list = findBydiscountEqual(discount,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("discount=" + discount);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView[] findBydiscountEqual_PrevAndNext(
		Integer journalArticleId, double discount, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		ProGateJournalArticleView proGateJournalArticleView = findByPrimaryKey(journalArticleId);

		int count = countBydiscountEqual(discount);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

			query.append("discount = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(discount);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticleView);

			ProGateJournalArticleView[] array = new ProGateJournalArticleViewImpl[3];

			array[0] = (ProGateJournalArticleView)objArray[0];
			array[1] = (ProGateJournalArticleView)objArray[1];
			array[2] = (ProGateJournalArticleView)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticleView> findBydiscountGreater(
		double discount) throws SystemException {
		Object[] finderArgs = new Object[] { new Double(discount) };

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DISCOUNTGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				query.append("discount >= ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");

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
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DISCOUNTGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticleView> findBydiscountGreater(
		double discount, int start, int end) throws SystemException {
		return findBydiscountGreater(discount, start, end, null);
	}

	public List<ProGateJournalArticleView> findBydiscountGreater(
		double discount, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				new Double(discount),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_DISCOUNTGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				query.append("discount >= ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("updated_at DESC, ");
					query.append("created_at DESC, ");
					query.append("priority DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(discount);

				list = (List<ProGateJournalArticleView>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_DISCOUNTGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticleView findBydiscountGreater_First(
		double discount, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		List<ProGateJournalArticleView> list = findBydiscountGreater(discount,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("discount=" + discount);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView findBydiscountGreater_Last(
		double discount, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		int count = countBydiscountGreater(discount);

		List<ProGateJournalArticleView> list = findBydiscountGreater(discount,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("discount=" + discount);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView[] findBydiscountGreater_PrevAndNext(
		Integer journalArticleId, double discount, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		ProGateJournalArticleView proGateJournalArticleView = findByPrimaryKey(journalArticleId);

		int count = countBydiscountGreater(discount);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

			query.append("discount >= ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(discount);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticleView);

			ProGateJournalArticleView[] array = new ProGateJournalArticleViewImpl[3];

			array[0] = (ProGateJournalArticleView)objArray[0];
			array[1] = (ProGateJournalArticleView)objArray[1];
			array[2] = (ProGateJournalArticleView)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticleView> findBydiscountLower(double discount)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Double(discount) };

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DISCOUNTLOWER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				query.append("discount <= ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");

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
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DISCOUNTLOWER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticleView> findBydiscountLower(
		double discount, int start, int end) throws SystemException {
		return findBydiscountLower(discount, start, end, null);
	}

	public List<ProGateJournalArticleView> findBydiscountLower(
		double discount, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				new Double(discount),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_DISCOUNTLOWER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				query.append("discount <= ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("updated_at DESC, ");
					query.append("created_at DESC, ");
					query.append("priority DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(discount);

				list = (List<ProGateJournalArticleView>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_DISCOUNTLOWER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticleView findBydiscountLower_First(
		double discount, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		List<ProGateJournalArticleView> list = findBydiscountLower(discount, 0,
				1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("discount=" + discount);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView findBydiscountLower_Last(double discount,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		int count = countBydiscountLower(discount);

		List<ProGateJournalArticleView> list = findBydiscountLower(discount,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("discount=" + discount);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView[] findBydiscountLower_PrevAndNext(
		Integer journalArticleId, double discount, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		ProGateJournalArticleView proGateJournalArticleView = findByPrimaryKey(journalArticleId);

		int count = countBydiscountLower(discount);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

			query.append("discount <= ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(discount);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticleView);

			ProGateJournalArticleView[] array = new ProGateJournalArticleViewImpl[3];

			array[0] = (ProGateJournalArticleView)objArray[0];
			array[1] = (ProGateJournalArticleView)objArray[1];
			array[2] = (ProGateJournalArticleView)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticleView> findBypriceEqual(double price)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Double(price) };

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_PRICEEQUAL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				query.append("price = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");

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
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_PRICEEQUAL,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticleView> findBypriceEqual(double price,
		int start, int end) throws SystemException {
		return findBypriceEqual(price, start, end, null);
	}

	public List<ProGateJournalArticleView> findBypriceEqual(double price,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Double(price),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_PRICEEQUAL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				query.append("price = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("updated_at DESC, ");
					query.append("created_at DESC, ");
					query.append("priority DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(price);

				list = (List<ProGateJournalArticleView>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_PRICEEQUAL,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticleView findBypriceEqual_First(double price,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		List<ProGateJournalArticleView> list = findBypriceEqual(price, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("price=" + price);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView findBypriceEqual_Last(double price,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		int count = countBypriceEqual(price);

		List<ProGateJournalArticleView> list = findBypriceEqual(price,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("price=" + price);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView[] findBypriceEqual_PrevAndNext(
		Integer journalArticleId, double price, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		ProGateJournalArticleView proGateJournalArticleView = findByPrimaryKey(journalArticleId);

		int count = countBypriceEqual(price);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

			query.append("price = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(price);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticleView);

			ProGateJournalArticleView[] array = new ProGateJournalArticleViewImpl[3];

			array[0] = (ProGateJournalArticleView)objArray[0];
			array[1] = (ProGateJournalArticleView)objArray[1];
			array[2] = (ProGateJournalArticleView)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticleView> findBypriceGreater(double price)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Double(price) };

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_PRICEGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				query.append("price >= ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");

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
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_PRICEGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticleView> findBypriceGreater(double price,
		int start, int end) throws SystemException {
		return findBypriceGreater(price, start, end, null);
	}

	public List<ProGateJournalArticleView> findBypriceGreater(double price,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Double(price),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_PRICEGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				query.append("price >= ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("updated_at DESC, ");
					query.append("created_at DESC, ");
					query.append("priority DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(price);

				list = (List<ProGateJournalArticleView>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_PRICEGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticleView findBypriceGreater_First(double price,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		List<ProGateJournalArticleView> list = findBypriceGreater(price, 0, 1,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("price=" + price);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView findBypriceGreater_Last(double price,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		int count = countBypriceGreater(price);

		List<ProGateJournalArticleView> list = findBypriceGreater(price,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("price=" + price);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView[] findBypriceGreater_PrevAndNext(
		Integer journalArticleId, double price, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		ProGateJournalArticleView proGateJournalArticleView = findByPrimaryKey(journalArticleId);

		int count = countBypriceGreater(price);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

			query.append("price >= ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(price);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticleView);

			ProGateJournalArticleView[] array = new ProGateJournalArticleViewImpl[3];

			array[0] = (ProGateJournalArticleView)objArray[0];
			array[1] = (ProGateJournalArticleView)objArray[1];
			array[2] = (ProGateJournalArticleView)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticleView> findBypriceLower(double price)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Double(price) };

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_PRICELOWER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				query.append("price <= ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");

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
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_PRICELOWER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticleView> findBypriceLower(double price,
		int start, int end) throws SystemException {
		return findBypriceLower(price, start, end, null);
	}

	public List<ProGateJournalArticleView> findBypriceLower(double price,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Double(price),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_PRICELOWER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				query.append("price <= ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("updated_at DESC, ");
					query.append("created_at DESC, ");
					query.append("priority DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(price);

				list = (List<ProGateJournalArticleView>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_PRICELOWER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticleView findBypriceLower_First(double price,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		List<ProGateJournalArticleView> list = findBypriceLower(price, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("price=" + price);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView findBypriceLower_Last(double price,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		int count = countBypriceLower(price);

		List<ProGateJournalArticleView> list = findBypriceLower(price,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("price=" + price);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView[] findBypriceLower_PrevAndNext(
		Integer journalArticleId, double price, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		ProGateJournalArticleView proGateJournalArticleView = findByPrimaryKey(journalArticleId);

		int count = countBypriceLower(price);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

			query.append("price <= ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(price);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticleView);

			ProGateJournalArticleView[] array = new ProGateJournalArticleViewImpl[3];

			array[0] = (ProGateJournalArticleView)objArray[0];
			array[1] = (ProGateJournalArticleView)objArray[1];
			array[2] = (ProGateJournalArticleView)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticleView> findByproductType(int productType)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(productType) };

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_PRODUCTTYPE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				query.append("producttype LIKE ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");

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
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_PRODUCTTYPE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticleView> findByproductType(int productType,
		int start, int end) throws SystemException {
		return findByproductType(productType, start, end, null);
	}

	public List<ProGateJournalArticleView> findByproductType(int productType,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(productType),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_PRODUCTTYPE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				query.append("producttype LIKE ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("updated_at DESC, ");
					query.append("created_at DESC, ");
					query.append("priority DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(productType);

				list = (List<ProGateJournalArticleView>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_PRODUCTTYPE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticleView findByproductType_First(int productType,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		List<ProGateJournalArticleView> list = findByproductType(productType,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("productType=" + productType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView findByproductType_Last(int productType,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		int count = countByproductType(productType);

		List<ProGateJournalArticleView> list = findByproductType(productType,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("productType=" + productType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView[] findByproductType_PrevAndNext(
		Integer journalArticleId, int productType, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		ProGateJournalArticleView proGateJournalArticleView = findByPrimaryKey(journalArticleId);

		int count = countByproductType(productType);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

			query.append("producttype LIKE ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(productType);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticleView);

			ProGateJournalArticleView[] array = new ProGateJournalArticleViewImpl[3];

			array[0] = (ProGateJournalArticleView)objArray[0];
			array[1] = (ProGateJournalArticleView)objArray[1];
			array[2] = (ProGateJournalArticleView)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticleView> findByisService(boolean isService)
		throws SystemException {
		Object[] finderArgs = new Object[] { Boolean.valueOf(isService) };

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ISSERVICE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				query.append("isservice = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");

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
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ISSERVICE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticleView> findByisService(boolean isService,
		int start, int end) throws SystemException {
		return findByisService(isService, start, end, null);
	}

	public List<ProGateJournalArticleView> findByisService(boolean isService,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				Boolean.valueOf(isService),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ISSERVICE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				query.append("isservice = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("updated_at DESC, ");
					query.append("created_at DESC, ");
					query.append("priority DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isService);

				list = (List<ProGateJournalArticleView>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ISSERVICE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticleView findByisService_First(boolean isService,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		List<ProGateJournalArticleView> list = findByisService(isService, 0, 1,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("isService=" + isService);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView findByisService_Last(boolean isService,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		int count = countByisService(isService);

		List<ProGateJournalArticleView> list = findByisService(isService,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("isService=" + isService);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView[] findByisService_PrevAndNext(
		Integer journalArticleId, boolean isService, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		ProGateJournalArticleView proGateJournalArticleView = findByPrimaryKey(journalArticleId);

		int count = countByisService(isService);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

			query.append("isservice = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(isService);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticleView);

			ProGateJournalArticleView[] array = new ProGateJournalArticleViewImpl[3];

			array[0] = (ProGateJournalArticleView)objArray[0];
			array[1] = (ProGateJournalArticleView)objArray[1];
			array[2] = (ProGateJournalArticleView)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticleView> findByisHot(boolean isHot)
		throws SystemException {
		Object[] finderArgs = new Object[] { Boolean.valueOf(isHot) };

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ISHOT,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				query.append("is_hot = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");

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
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ISHOT,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticleView> findByisHot(boolean isHot,
		int start, int end) throws SystemException {
		return findByisHot(isHot, start, end, null);
	}

	public List<ProGateJournalArticleView> findByisHot(boolean isHot,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				Boolean.valueOf(isHot),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ISHOT,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				query.append("is_hot = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("updated_at DESC, ");
					query.append("created_at DESC, ");
					query.append("priority DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isHot);

				list = (List<ProGateJournalArticleView>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ISHOT,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticleView findByisHot_First(boolean isHot,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		List<ProGateJournalArticleView> list = findByisHot(isHot, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("isHot=" + isHot);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView findByisHot_Last(boolean isHot,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		int count = countByisHot(isHot);

		List<ProGateJournalArticleView> list = findByisHot(isHot, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("isHot=" + isHot);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView[] findByisHot_PrevAndNext(
		Integer journalArticleId, boolean isHot, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		ProGateJournalArticleView proGateJournalArticleView = findByPrimaryKey(journalArticleId);

		int count = countByisHot(isHot);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

			query.append("is_hot = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(isHot);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticleView);

			ProGateJournalArticleView[] array = new ProGateJournalArticleViewImpl[3];

			array[0] = (ProGateJournalArticleView)objArray[0];
			array[1] = (ProGateJournalArticleView)objArray[1];
			array[2] = (ProGateJournalArticleView)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticleView> findBycurrencyCode(
		String currencyCode) throws SystemException {
		Object[] finderArgs = new Object[] { currencyCode };

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_CURRENCYCODE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				if (currencyCode == null) {
					query.append("currencyCode IS NULL");
				}
				else {
					query.append("currencyCode = ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (currencyCode != null) {
					qPos.add(currencyCode);
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_CURRENCYCODE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticleView> findBycurrencyCode(
		String currencyCode, int start, int end) throws SystemException {
		return findBycurrencyCode(currencyCode, start, end, null);
	}

	public List<ProGateJournalArticleView> findBycurrencyCode(
		String currencyCode, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				currencyCode,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_CURRENCYCODE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				if (currencyCode == null) {
					query.append("currencyCode IS NULL");
				}
				else {
					query.append("currencyCode = ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("updated_at DESC, ");
					query.append("created_at DESC, ");
					query.append("priority DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (currencyCode != null) {
					qPos.add(currencyCode);
				}

				list = (List<ProGateJournalArticleView>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_CURRENCYCODE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticleView findBycurrencyCode_First(
		String currencyCode, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		List<ProGateJournalArticleView> list = findBycurrencyCode(currencyCode,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("currencyCode=" + currencyCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView findBycurrencyCode_Last(
		String currencyCode, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		int count = countBycurrencyCode(currencyCode);

		List<ProGateJournalArticleView> list = findBycurrencyCode(currencyCode,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("currencyCode=" + currencyCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView[] findBycurrencyCode_PrevAndNext(
		Integer journalArticleId, String currencyCode, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		ProGateJournalArticleView proGateJournalArticleView = findByPrimaryKey(journalArticleId);

		int count = countBycurrencyCode(currencyCode);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

			if (currencyCode == null) {
				query.append("currencyCode IS NULL");
			}
			else {
				query.append("currencyCode = ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (currencyCode != null) {
				qPos.add(currencyCode);
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticleView);

			ProGateJournalArticleView[] array = new ProGateJournalArticleViewImpl[3];

			array[0] = (ProGateJournalArticleView)objArray[0];
			array[1] = (ProGateJournalArticleView)objArray[1];
			array[2] = (ProGateJournalArticleView)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticleView> findByjournalArticleTypesName(
		String journalArticleTypesName) throws SystemException {
		Object[] finderArgs = new Object[] { journalArticleTypesName };

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_JOURNALARTICLETYPESNAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				if (journalArticleTypesName == null) {
					query.append("journalarticleTypesName IS NULL");
				}
				else {
					query.append("journalarticleTypesName = ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (journalArticleTypesName != null) {
					qPos.add(journalArticleTypesName);
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_JOURNALARTICLETYPESNAME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticleView> findByjournalArticleTypesName(
		String journalArticleTypesName, int start, int end)
		throws SystemException {
		return findByjournalArticleTypesName(journalArticleTypesName, start,
			end, null);
	}

	public List<ProGateJournalArticleView> findByjournalArticleTypesName(
		String journalArticleTypesName, int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				journalArticleTypesName,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_JOURNALARTICLETYPESNAME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				if (journalArticleTypesName == null) {
					query.append("journalarticleTypesName IS NULL");
				}
				else {
					query.append("journalarticleTypesName = ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("updated_at DESC, ");
					query.append("created_at DESC, ");
					query.append("priority DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (journalArticleTypesName != null) {
					qPos.add(journalArticleTypesName);
				}

				list = (List<ProGateJournalArticleView>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_JOURNALARTICLETYPESNAME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticleView findByjournalArticleTypesName_First(
		String journalArticleTypesName, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		List<ProGateJournalArticleView> list = findByjournalArticleTypesName(journalArticleTypesName,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("journalArticleTypesName=" + journalArticleTypesName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView findByjournalArticleTypesName_Last(
		String journalArticleTypesName, OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		int count = countByjournalArticleTypesName(journalArticleTypesName);

		List<ProGateJournalArticleView> list = findByjournalArticleTypesName(journalArticleTypesName,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticleView exists with the key {");

			msg.append("journalArticleTypesName=" + journalArticleTypesName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleViewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticleView[] findByjournalArticleTypesName_PrevAndNext(
		Integer journalArticleId, String journalArticleTypesName,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleViewException, SystemException {
		ProGateJournalArticleView proGateJournalArticleView = findByPrimaryKey(journalArticleId);

		int count = countByjournalArticleTypesName(journalArticleTypesName);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

			if (journalArticleTypesName == null) {
				query.append("journalarticleTypesName IS NULL");
			}
			else {
				query.append("journalarticleTypesName = ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("updated_at DESC, ");
				query.append("created_at DESC, ");
				query.append("priority DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (journalArticleTypesName != null) {
				qPos.add(journalArticleTypesName);
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticleView);

			ProGateJournalArticleView[] array = new ProGateJournalArticleViewImpl[3];

			array[0] = (ProGateJournalArticleView)objArray[0];
			array[1] = (ProGateJournalArticleView)objArray[1];
			array[2] = (ProGateJournalArticleView)objArray[2];

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

	public List<ProGateJournalArticleView> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<ProGateJournalArticleView> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<ProGateJournalArticleView> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticleView> list = (List<ProGateJournalArticleView>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("updated_at DESC, ");
					query.append("created_at DESC, ");
					query.append("priority DESC");
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<ProGateJournalArticleView>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ProGateJournalArticleView>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticleView>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByorgId(String orgId) throws SystemException {
		for (ProGateJournalArticleView proGateJournalArticleView : findByorgId(
				orgId)) {
			remove(proGateJournalArticleView);
		}
	}

	public void removeByprogateCategory(int progateCategory)
		throws SystemException {
		for (ProGateJournalArticleView proGateJournalArticleView : findByprogateCategory(
				progateCategory)) {
			remove(proGateJournalArticleView);
		}
	}

	public void removeByarticleTypeEquals(int articleType)
		throws SystemException {
		for (ProGateJournalArticleView proGateJournalArticleView : findByarticleTypeEquals(
				articleType)) {
			remove(proGateJournalArticleView);
		}
	}

	public void removeByarticleTypeGreater(int articleType)
		throws SystemException {
		for (ProGateJournalArticleView proGateJournalArticleView : findByarticleTypeGreater(
				articleType)) {
			remove(proGateJournalArticleView);
		}
	}

	public void removeByarticleTypeLower(int articleType)
		throws SystemException {
		for (ProGateJournalArticleView proGateJournalArticleView : findByarticleTypeLower(
				articleType)) {
			remove(proGateJournalArticleView);
		}
	}

	public void removeByproductTypeEquals(int productType)
		throws SystemException {
		for (ProGateJournalArticleView proGateJournalArticleView : findByproductTypeEquals(
				productType)) {
			remove(proGateJournalArticleView);
		}
	}

	public void removeByproductTypeGreater(int productType)
		throws SystemException {
		for (ProGateJournalArticleView proGateJournalArticleView : findByproductTypeGreater(
				productType)) {
			remove(proGateJournalArticleView);
		}
	}

	public void removeByproductTypeLower(int productType)
		throws SystemException {
		for (ProGateJournalArticleView proGateJournalArticleView : findByproductTypeLower(
				productType)) {
			remove(proGateJournalArticleView);
		}
	}

	public void removeBytitle(String title) throws SystemException {
		for (ProGateJournalArticleView proGateJournalArticleView : findBytitle(
				title)) {
			remove(proGateJournalArticleView);
		}
	}

	public void removeBypriorityEqual(int priority) throws SystemException {
		for (ProGateJournalArticleView proGateJournalArticleView : findBypriorityEqual(
				priority)) {
			remove(proGateJournalArticleView);
		}
	}

	public void removeBypriorityLower(int priority) throws SystemException {
		for (ProGateJournalArticleView proGateJournalArticleView : findBypriorityLower(
				priority)) {
			remove(proGateJournalArticleView);
		}
	}

	public void removeBypriorityGreater(int priority) throws SystemException {
		for (ProGateJournalArticleView proGateJournalArticleView : findBypriorityGreater(
				priority)) {
			remove(proGateJournalArticleView);
		}
	}

	public void removeBycreatedBy(int createdBy) throws SystemException {
		for (ProGateJournalArticleView proGateJournalArticleView : findBycreatedBy(
				createdBy)) {
			remove(proGateJournalArticleView);
		}
	}

	public void removeBycreatedAtEqual(Date createdAt)
		throws SystemException {
		for (ProGateJournalArticleView proGateJournalArticleView : findBycreatedAtEqual(
				createdAt)) {
			remove(proGateJournalArticleView);
		}
	}

	public void removeBycreatedAtGreater(Date createdAt)
		throws SystemException {
		for (ProGateJournalArticleView proGateJournalArticleView : findBycreatedAtGreater(
				createdAt)) {
			remove(proGateJournalArticleView);
		}
	}

	public void removeBycreatedAtLower(Date createdAt)
		throws SystemException {
		for (ProGateJournalArticleView proGateJournalArticleView : findBycreatedAtLower(
				createdAt)) {
			remove(proGateJournalArticleView);
		}
	}

	public void removeByupdatedBy(int updatedBy) throws SystemException {
		for (ProGateJournalArticleView proGateJournalArticleView : findByupdatedBy(
				updatedBy)) {
			remove(proGateJournalArticleView);
		}
	}

	public void removeByupdatedAtGreater(Date updatedAt)
		throws SystemException {
		for (ProGateJournalArticleView proGateJournalArticleView : findByupdatedAtGreater(
				updatedAt)) {
			remove(proGateJournalArticleView);
		}
	}

	public void removeByupdatedAtLower(Date updatedAt)
		throws SystemException {
		for (ProGateJournalArticleView proGateJournalArticleView : findByupdatedAtLower(
				updatedAt)) {
			remove(proGateJournalArticleView);
		}
	}

	public void removeByupdatedAtEqual(Date updatedAt)
		throws SystemException {
		for (ProGateJournalArticleView proGateJournalArticleView : findByupdatedAtEqual(
				updatedAt)) {
			remove(proGateJournalArticleView);
		}
	}

	public void removeBydiscountEqual(double discount)
		throws SystemException {
		for (ProGateJournalArticleView proGateJournalArticleView : findBydiscountEqual(
				discount)) {
			remove(proGateJournalArticleView);
		}
	}

	public void removeBydiscountGreater(double discount)
		throws SystemException {
		for (ProGateJournalArticleView proGateJournalArticleView : findBydiscountGreater(
				discount)) {
			remove(proGateJournalArticleView);
		}
	}

	public void removeBydiscountLower(double discount)
		throws SystemException {
		for (ProGateJournalArticleView proGateJournalArticleView : findBydiscountLower(
				discount)) {
			remove(proGateJournalArticleView);
		}
	}

	public void removeBypriceEqual(double price) throws SystemException {
		for (ProGateJournalArticleView proGateJournalArticleView : findBypriceEqual(
				price)) {
			remove(proGateJournalArticleView);
		}
	}

	public void removeBypriceGreater(double price) throws SystemException {
		for (ProGateJournalArticleView proGateJournalArticleView : findBypriceGreater(
				price)) {
			remove(proGateJournalArticleView);
		}
	}

	public void removeBypriceLower(double price) throws SystemException {
		for (ProGateJournalArticleView proGateJournalArticleView : findBypriceLower(
				price)) {
			remove(proGateJournalArticleView);
		}
	}

	public void removeByproductType(int productType) throws SystemException {
		for (ProGateJournalArticleView proGateJournalArticleView : findByproductType(
				productType)) {
			remove(proGateJournalArticleView);
		}
	}

	public void removeByisService(boolean isService) throws SystemException {
		for (ProGateJournalArticleView proGateJournalArticleView : findByisService(
				isService)) {
			remove(proGateJournalArticleView);
		}
	}

	public void removeByisHot(boolean isHot) throws SystemException {
		for (ProGateJournalArticleView proGateJournalArticleView : findByisHot(
				isHot)) {
			remove(proGateJournalArticleView);
		}
	}

	public void removeBycurrencyCode(String currencyCode)
		throws SystemException {
		for (ProGateJournalArticleView proGateJournalArticleView : findBycurrencyCode(
				currencyCode)) {
			remove(proGateJournalArticleView);
		}
	}

	public void removeByjournalArticleTypesName(String journalArticleTypesName)
		throws SystemException {
		for (ProGateJournalArticleView proGateJournalArticleView : findByjournalArticleTypesName(
				journalArticleTypesName)) {
			remove(proGateJournalArticleView);
		}
	}

	public void removeAll() throws SystemException {
		for (ProGateJournalArticleView proGateJournalArticleView : findAll()) {
			remove(proGateJournalArticleView);
		}
	}

	public int countByorgId(String orgId) throws SystemException {
		Object[] finderArgs = new Object[] { orgId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ORGID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				if (orgId == null) {
					query.append("orgid IS NULL");
				}
				else {
					query.append("orgid = ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (orgId != null) {
					qPos.add(orgId);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ORGID,
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
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

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

	public int countByarticleTypeEquals(int articleType)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(articleType) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ARTICLETYPEEQUALS,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				query.append("articletype = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(articleType);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ARTICLETYPEEQUALS,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByarticleTypeGreater(int articleType)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(articleType) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ARTICLETYPEGREATER,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				query.append("articletype >= ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(articleType);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ARTICLETYPEGREATER,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByarticleTypeLower(int articleType)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(articleType) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ARTICLETYPELOWER,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				query.append("articletype <= ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(articleType);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ARTICLETYPELOWER,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByproductTypeEquals(int productType)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(productType) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PRODUCTTYPEEQUALS,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PRODUCTTYPEEQUALS,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByproductTypeGreater(int productType)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(productType) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PRODUCTTYPEGREATER,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				query.append("producttype >= ?");

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PRODUCTTYPEGREATER,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByproductTypeLower(int productType)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(productType) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PRODUCTTYPELOWER,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				query.append("producttype <= ?");

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PRODUCTTYPELOWER,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countBytitle(String title) throws SystemException {
		Object[] finderArgs = new Object[] { title };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TITLE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				if (title == null) {
					query.append("title LIKE null");
				}
				else {
					query.append("title LIKE ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (title != null) {
					qPos.add(title);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TITLE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countBypriorityEqual(int priority) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(priority) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PRIORITYEQUAL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				query.append("priority = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(priority);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PRIORITYEQUAL,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countBypriorityLower(int priority) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(priority) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PRIORITYLOWER,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				query.append("priority <= ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(priority);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PRIORITYLOWER,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countBypriorityGreater(int priority) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(priority) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PRIORITYGREATER,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				query.append("priority >= ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(priority);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PRIORITYGREATER,
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
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

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
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

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
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

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
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

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
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

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
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

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
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

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
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

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
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

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
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

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
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

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
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

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
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

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
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

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
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				query.append("producttype LIKE ?");

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
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

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
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

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

	public int countBycurrencyCode(String currencyCode)
		throws SystemException {
		Object[] finderArgs = new Object[] { currencyCode };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CURRENCYCODE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				if (currencyCode == null) {
					query.append("currencyCode IS NULL");
				}
				else {
					query.append("currencyCode = ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (currencyCode != null) {
					qPos.add(currencyCode);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CURRENCYCODE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByjournalArticleTypesName(String journalArticleTypesName)
		throws SystemException {
		Object[] finderArgs = new Object[] { journalArticleTypesName };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_JOURNALARTICLETYPESNAME,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateJournalArticleView WHERE ");

				if (journalArticleTypesName == null) {
					query.append("journalarticleTypesName IS NULL");
				}
				else {
					query.append("journalarticleTypesName = ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (journalArticleTypesName != null) {
					qPos.add(journalArticleTypesName);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_JOURNALARTICLETYPESNAME,
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
						"SELECT COUNT(*) FROM larion.progate.model.ProGateJournalArticleView");

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
						"value.object.listener.larion.progate.model.ProGateJournalArticleView")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ProGateJournalArticleView>> listenersList = new ArrayList<ModelListener<ProGateJournalArticleView>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ProGateJournalArticleView>)Class.forName(
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
	private static Log _log = LogFactoryUtil.getLog(ProGateJournalArticleViewPersistenceImpl.class);
}