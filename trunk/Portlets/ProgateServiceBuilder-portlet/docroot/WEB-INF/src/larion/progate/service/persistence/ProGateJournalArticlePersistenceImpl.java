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

import larion.progate.NoSuchProGateJournalArticleException;

import larion.progate.model.ProGateJournalArticle;
import larion.progate.model.impl.ProGateJournalArticleImpl;
import larion.progate.model.impl.ProGateJournalArticleModelImpl;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * <a href="ProGateJournalArticlePersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateJournalArticlePersistenceImpl extends BasePersistenceImpl
	implements ProGateJournalArticlePersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = ProGateJournalArticleImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_ORGID = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByorgId",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ORGID = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByorgId",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGID = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByorgId",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ARTICLEORDEREQUALS = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByarticleOrderEquals",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ARTICLEORDEREQUALS = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByarticleOrderEquals",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ARTICLEORDEREQUALS = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByarticleOrderEquals",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ARTICLEORDERGREATER = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByarticleOrderGreater",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ARTICLEORDERGREATER = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByarticleOrderGreater",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ARTICLEORDERGREATER = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByarticleOrderGreater",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ARTICLEORDERLOWER = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByarticleOrderLower",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ARTICLEORDERLOWER = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByarticleOrderLower",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ARTICLEORDERLOWER = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByarticleOrderLower",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ARTICLETYPEEQUALS = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByarticleTypeEquals",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ARTICLETYPEEQUALS = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByarticleTypeEquals",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ARTICLETYPEEQUALS = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByarticleTypeEquals",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ARTICLETYPEGREATER = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByarticleTypeGreater",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ARTICLETYPEGREATER = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByarticleTypeGreater",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ARTICLETYPEGREATER = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByarticleTypeGreater",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ARTICLETYPELOWER = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByarticleTypeLower",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ARTICLETYPELOWER = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByarticleTypeLower",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ARTICLETYPELOWER = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByarticleTypeLower",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_TITLE = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBytitle",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_TITLE = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBytitle",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_TITLE = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBytitle",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_PRIORITYEQUAL = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBypriorityEqual",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_PRIORITYEQUAL = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBypriorityEqual",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_PRIORITYEQUAL = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBypriorityEqual",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_PRIORITYLOWER = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBypriorityLower",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_PRIORITYLOWER = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBypriorityLower",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_PRIORITYLOWER = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBypriorityLower",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_PRIORITYGREATER = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBypriorityGreater",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_PRIORITYGREATER = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBypriorityGreater",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_PRIORITYGREATER = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBypriorityGreater",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_CREATEDBY = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycreatedBy",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_CREATEDBY = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycreatedBy",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_CREATEDBY = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBycreatedBy",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_CREATEDATEQUAL = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycreatedAtEqual",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_CREATEDATEQUAL = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycreatedAtEqual",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_CREATEDATEQUAL = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBycreatedAtEqual",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_CREATEDATGREATER = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycreatedAtGreater",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_CREATEDATGREATER = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycreatedAtGreater",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_CREATEDATGREATER = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBycreatedAtGreater",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_CREATEDATLOWER = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycreatedAtLower",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_CREATEDATLOWER = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findBycreatedAtLower",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_CREATEDATLOWER = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countBycreatedAtLower",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_UPDATEDBY = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByupdatedBy",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_UPDATEDBY = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByupdatedBy",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_UPDATEDBY = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByupdatedBy",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_UPDATEDATGREATER = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByupdatedAtGreater",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_UPDATEDATGREATER = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByupdatedAtGreater",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_UPDATEDATGREATER = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByupdatedAtGreater",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_UPDATEDATLOWER = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByupdatedAtLower",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_UPDATEDATLOWER = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByupdatedAtLower",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_UPDATEDATLOWER = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByupdatedAtLower",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_UPDATEDATEQUAL = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByupdatedAtEqual",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_UPDATEDATEQUAL = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByupdatedAtEqual",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_UPDATEDATEQUAL = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByupdatedAtEqual",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ADDINFO = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByaddInfo",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ADDINFO = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByaddInfo",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ADDINFO = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByaddInfo",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(ProGateJournalArticle proGateJournalArticle) {
		EntityCacheUtil.putResult(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleImpl.class,
			proGateJournalArticle.getPrimaryKey(), proGateJournalArticle);
	}

	public void cacheResult(List<ProGateJournalArticle> proGateJournalArticles) {
		for (ProGateJournalArticle proGateJournalArticle : proGateJournalArticles) {
			if (EntityCacheUtil.getResult(
						ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
						ProGateJournalArticleImpl.class,
						proGateJournalArticle.getPrimaryKey(), this) == null) {
				cacheResult(proGateJournalArticle);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(ProGateJournalArticleImpl.class.getName());
		EntityCacheUtil.clearCache(ProGateJournalArticleImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public ProGateJournalArticle create(Integer journalArticleId) {
		ProGateJournalArticle proGateJournalArticle = new ProGateJournalArticleImpl();

		proGateJournalArticle.setNew(true);
		proGateJournalArticle.setPrimaryKey(journalArticleId);

		return proGateJournalArticle;
	}

	public ProGateJournalArticle remove(Integer journalArticleId)
		throws NoSuchProGateJournalArticleException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ProGateJournalArticle proGateJournalArticle = (ProGateJournalArticle)session.get(ProGateJournalArticleImpl.class,
					journalArticleId);

			if (proGateJournalArticle == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No ProGateJournalArticle exists with the primary key " +
						journalArticleId);
				}

				throw new NoSuchProGateJournalArticleException(
					"No ProGateJournalArticle exists with the primary key " +
					journalArticleId);
			}

			return remove(proGateJournalArticle);
		}
		catch (NoSuchProGateJournalArticleException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public ProGateJournalArticle remove(
		ProGateJournalArticle proGateJournalArticle) throws SystemException {
		for (ModelListener<ProGateJournalArticle> listener : listeners) {
			listener.onBeforeRemove(proGateJournalArticle);
		}

		proGateJournalArticle = removeImpl(proGateJournalArticle);

		for (ModelListener<ProGateJournalArticle> listener : listeners) {
			listener.onAfterRemove(proGateJournalArticle);
		}

		return proGateJournalArticle;
	}

	protected ProGateJournalArticle removeImpl(
		ProGateJournalArticle proGateJournalArticle) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (proGateJournalArticle.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(ProGateJournalArticleImpl.class,
						proGateJournalArticle.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(proGateJournalArticle);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleImpl.class,
			proGateJournalArticle.getPrimaryKey());

		return proGateJournalArticle;
	}

	public ProGateJournalArticle update(
		ProGateJournalArticle proGateJournalArticle) throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(ProGateJournalArticle proGateJournalArticle) method. Use update(ProGateJournalArticle proGateJournalArticle, boolean merge) instead.");
		}

		return update(proGateJournalArticle, false);
	}

	public ProGateJournalArticle update(
		ProGateJournalArticle proGateJournalArticle, boolean merge)
		throws SystemException {
		boolean isNew = proGateJournalArticle.isNew();

		for (ModelListener<ProGateJournalArticle> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(proGateJournalArticle);
			}
			else {
				listener.onBeforeUpdate(proGateJournalArticle);
			}
		}

		proGateJournalArticle = updateImpl(proGateJournalArticle, merge);

		for (ModelListener<ProGateJournalArticle> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(proGateJournalArticle);
			}
			else {
				listener.onAfterUpdate(proGateJournalArticle);
			}
		}

		return proGateJournalArticle;
	}

	public ProGateJournalArticle updateImpl(
		larion.progate.model.ProGateJournalArticle proGateJournalArticle,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, proGateJournalArticle, merge);

			proGateJournalArticle.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
			ProGateJournalArticleImpl.class,
			proGateJournalArticle.getPrimaryKey(), proGateJournalArticle);

		return proGateJournalArticle;
	}

	public ProGateJournalArticle findByPrimaryKey(Integer journalArticleId)
		throws NoSuchProGateJournalArticleException, SystemException {
		ProGateJournalArticle proGateJournalArticle = fetchByPrimaryKey(journalArticleId);

		if (proGateJournalArticle == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"No ProGateJournalArticle exists with the primary key " +
					journalArticleId);
			}

			throw new NoSuchProGateJournalArticleException(
				"No ProGateJournalArticle exists with the primary key " +
				journalArticleId);
		}

		return proGateJournalArticle;
	}

	public ProGateJournalArticle fetchByPrimaryKey(Integer journalArticleId)
		throws SystemException {
		ProGateJournalArticle proGateJournalArticle = (ProGateJournalArticle)EntityCacheUtil.getResult(ProGateJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
				ProGateJournalArticleImpl.class, journalArticleId, this);

		if (proGateJournalArticle == null) {
			Session session = null;

			try {
				session = openSession();

				proGateJournalArticle = (ProGateJournalArticle)session.get(ProGateJournalArticleImpl.class,
						journalArticleId);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (proGateJournalArticle != null) {
					cacheResult(proGateJournalArticle);
				}

				closeSession(session);
			}
		}

		return proGateJournalArticle;
	}

	public List<ProGateJournalArticle> findByorgId(String orgId)
		throws SystemException {
		Object[] finderArgs = new Object[] { orgId };

		List<ProGateJournalArticle> list = (List<ProGateJournalArticle>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ORGID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

				if (orgId == null) {
					query.append("orgid IS NULL");
				}
				else {
					query.append("orgid = ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("article_order ASC, ");
				query.append("updated_at DESC, ");
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
					list = new ArrayList<ProGateJournalArticle>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ORGID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticle> findByorgId(String orgId, int start,
		int end) throws SystemException {
		return findByorgId(orgId, start, end, null);
	}

	public List<ProGateJournalArticle> findByorgId(String orgId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				orgId,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticle> list = (List<ProGateJournalArticle>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ORGID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

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

					query.append("article_order ASC, ");
					query.append("updated_at DESC, ");
					query.append("priority DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (orgId != null) {
					qPos.add(orgId);
				}

				list = (List<ProGateJournalArticle>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticle>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ORGID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticle findByorgId_First(String orgId,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		List<ProGateJournalArticle> list = findByorgId(orgId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticle exists with the key {");

			msg.append("orgId=" + orgId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticle findByorgId_Last(String orgId,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		int count = countByorgId(orgId);

		List<ProGateJournalArticle> list = findByorgId(orgId, count - 1, count,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticle exists with the key {");

			msg.append("orgId=" + orgId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticle[] findByorgId_PrevAndNext(
		Integer journalArticleId, String orgId, OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		ProGateJournalArticle proGateJournalArticle = findByPrimaryKey(journalArticleId);

		int count = countByorgId(orgId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticle WHERE ");

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

				query.append("article_order ASC, ");
				query.append("updated_at DESC, ");
				query.append("priority DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (orgId != null) {
				qPos.add(orgId);
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticle);

			ProGateJournalArticle[] array = new ProGateJournalArticleImpl[3];

			array[0] = (ProGateJournalArticle)objArray[0];
			array[1] = (ProGateJournalArticle)objArray[1];
			array[2] = (ProGateJournalArticle)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticle> findByarticleOrderEquals(
		int articleOrder) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(articleOrder) };

		List<ProGateJournalArticle> list = (List<ProGateJournalArticle>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ARTICLEORDEREQUALS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

				query.append("article_order = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("article_order ASC, ");
				query.append("updated_at DESC, ");
				query.append("priority DESC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(articleOrder);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticle>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ARTICLEORDEREQUALS,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticle> findByarticleOrderEquals(
		int articleOrder, int start, int end) throws SystemException {
		return findByarticleOrderEquals(articleOrder, start, end, null);
	}

	public List<ProGateJournalArticle> findByarticleOrderEquals(
		int articleOrder, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(articleOrder),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticle> list = (List<ProGateJournalArticle>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ARTICLEORDEREQUALS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

				query.append("article_order = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("article_order ASC, ");
					query.append("updated_at DESC, ");
					query.append("priority DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(articleOrder);

				list = (List<ProGateJournalArticle>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticle>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ARTICLEORDEREQUALS,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticle findByarticleOrderEquals_First(
		int articleOrder, OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		List<ProGateJournalArticle> list = findByarticleOrderEquals(articleOrder,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticle exists with the key {");

			msg.append("articleOrder=" + articleOrder);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticle findByarticleOrderEquals_Last(
		int articleOrder, OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		int count = countByarticleOrderEquals(articleOrder);

		List<ProGateJournalArticle> list = findByarticleOrderEquals(articleOrder,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticle exists with the key {");

			msg.append("articleOrder=" + articleOrder);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticle[] findByarticleOrderEquals_PrevAndNext(
		Integer journalArticleId, int articleOrder, OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		ProGateJournalArticle proGateJournalArticle = findByPrimaryKey(journalArticleId);

		int count = countByarticleOrderEquals(articleOrder);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticle WHERE ");

			query.append("article_order = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("article_order ASC, ");
				query.append("updated_at DESC, ");
				query.append("priority DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(articleOrder);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticle);

			ProGateJournalArticle[] array = new ProGateJournalArticleImpl[3];

			array[0] = (ProGateJournalArticle)objArray[0];
			array[1] = (ProGateJournalArticle)objArray[1];
			array[2] = (ProGateJournalArticle)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticle> findByarticleOrderGreater(
		int articleOrder) throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(articleOrder) };

		List<ProGateJournalArticle> list = (List<ProGateJournalArticle>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ARTICLEORDERGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

				query.append("article_order >= ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("article_order ASC, ");
				query.append("updated_at DESC, ");
				query.append("priority DESC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(articleOrder);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticle>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ARTICLEORDERGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticle> findByarticleOrderGreater(
		int articleOrder, int start, int end) throws SystemException {
		return findByarticleOrderGreater(articleOrder, start, end, null);
	}

	public List<ProGateJournalArticle> findByarticleOrderGreater(
		int articleOrder, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(articleOrder),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticle> list = (List<ProGateJournalArticle>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ARTICLEORDERGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

				query.append("article_order >= ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("article_order ASC, ");
					query.append("updated_at DESC, ");
					query.append("priority DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(articleOrder);

				list = (List<ProGateJournalArticle>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticle>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ARTICLEORDERGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticle findByarticleOrderGreater_First(
		int articleOrder, OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		List<ProGateJournalArticle> list = findByarticleOrderGreater(articleOrder,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticle exists with the key {");

			msg.append("articleOrder=" + articleOrder);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticle findByarticleOrderGreater_Last(
		int articleOrder, OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		int count = countByarticleOrderGreater(articleOrder);

		List<ProGateJournalArticle> list = findByarticleOrderGreater(articleOrder,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticle exists with the key {");

			msg.append("articleOrder=" + articleOrder);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticle[] findByarticleOrderGreater_PrevAndNext(
		Integer journalArticleId, int articleOrder, OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		ProGateJournalArticle proGateJournalArticle = findByPrimaryKey(journalArticleId);

		int count = countByarticleOrderGreater(articleOrder);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticle WHERE ");

			query.append("article_order >= ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("article_order ASC, ");
				query.append("updated_at DESC, ");
				query.append("priority DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(articleOrder);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticle);

			ProGateJournalArticle[] array = new ProGateJournalArticleImpl[3];

			array[0] = (ProGateJournalArticle)objArray[0];
			array[1] = (ProGateJournalArticle)objArray[1];
			array[2] = (ProGateJournalArticle)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticle> findByarticleOrderLower(int articleOrder)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(articleOrder) };

		List<ProGateJournalArticle> list = (List<ProGateJournalArticle>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ARTICLEORDERLOWER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

				query.append("article_order <= ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("article_order ASC, ");
				query.append("updated_at DESC, ");
				query.append("priority DESC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(articleOrder);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticle>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ARTICLEORDERLOWER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticle> findByarticleOrderLower(
		int articleOrder, int start, int end) throws SystemException {
		return findByarticleOrderLower(articleOrder, start, end, null);
	}

	public List<ProGateJournalArticle> findByarticleOrderLower(
		int articleOrder, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(articleOrder),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticle> list = (List<ProGateJournalArticle>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ARTICLEORDERLOWER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

				query.append("article_order <= ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("article_order ASC, ");
					query.append("updated_at DESC, ");
					query.append("priority DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(articleOrder);

				list = (List<ProGateJournalArticle>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticle>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ARTICLEORDERLOWER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticle findByarticleOrderLower_First(
		int articleOrder, OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		List<ProGateJournalArticle> list = findByarticleOrderLower(articleOrder,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticle exists with the key {");

			msg.append("articleOrder=" + articleOrder);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticle findByarticleOrderLower_Last(
		int articleOrder, OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		int count = countByarticleOrderLower(articleOrder);

		List<ProGateJournalArticle> list = findByarticleOrderLower(articleOrder,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticle exists with the key {");

			msg.append("articleOrder=" + articleOrder);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticle[] findByarticleOrderLower_PrevAndNext(
		Integer journalArticleId, int articleOrder, OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		ProGateJournalArticle proGateJournalArticle = findByPrimaryKey(journalArticleId);

		int count = countByarticleOrderLower(articleOrder);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticle WHERE ");

			query.append("article_order <= ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("article_order ASC, ");
				query.append("updated_at DESC, ");
				query.append("priority DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(articleOrder);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticle);

			ProGateJournalArticle[] array = new ProGateJournalArticleImpl[3];

			array[0] = (ProGateJournalArticle)objArray[0];
			array[1] = (ProGateJournalArticle)objArray[1];
			array[2] = (ProGateJournalArticle)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticle> findByarticleTypeEquals(int articleType)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(articleType) };

		List<ProGateJournalArticle> list = (List<ProGateJournalArticle>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ARTICLETYPEEQUALS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

				query.append("articletype = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("article_order ASC, ");
				query.append("updated_at DESC, ");
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
					list = new ArrayList<ProGateJournalArticle>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ARTICLETYPEEQUALS,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticle> findByarticleTypeEquals(
		int articleType, int start, int end) throws SystemException {
		return findByarticleTypeEquals(articleType, start, end, null);
	}

	public List<ProGateJournalArticle> findByarticleTypeEquals(
		int articleType, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(articleType),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticle> list = (List<ProGateJournalArticle>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ARTICLETYPEEQUALS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

				query.append("articletype = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("article_order ASC, ");
					query.append("updated_at DESC, ");
					query.append("priority DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(articleType);

				list = (List<ProGateJournalArticle>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticle>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ARTICLETYPEEQUALS,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticle findByarticleTypeEquals_First(
		int articleType, OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		List<ProGateJournalArticle> list = findByarticleTypeEquals(articleType,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticle exists with the key {");

			msg.append("articleType=" + articleType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticle findByarticleTypeEquals_Last(int articleType,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		int count = countByarticleTypeEquals(articleType);

		List<ProGateJournalArticle> list = findByarticleTypeEquals(articleType,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticle exists with the key {");

			msg.append("articleType=" + articleType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticle[] findByarticleTypeEquals_PrevAndNext(
		Integer journalArticleId, int articleType, OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		ProGateJournalArticle proGateJournalArticle = findByPrimaryKey(journalArticleId);

		int count = countByarticleTypeEquals(articleType);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticle WHERE ");

			query.append("articletype = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("article_order ASC, ");
				query.append("updated_at DESC, ");
				query.append("priority DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(articleType);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticle);

			ProGateJournalArticle[] array = new ProGateJournalArticleImpl[3];

			array[0] = (ProGateJournalArticle)objArray[0];
			array[1] = (ProGateJournalArticle)objArray[1];
			array[2] = (ProGateJournalArticle)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticle> findByarticleTypeGreater(int articleType)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(articleType) };

		List<ProGateJournalArticle> list = (List<ProGateJournalArticle>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ARTICLETYPEGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

				query.append("articletype >= ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("article_order ASC, ");
				query.append("updated_at DESC, ");
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
					list = new ArrayList<ProGateJournalArticle>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ARTICLETYPEGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticle> findByarticleTypeGreater(
		int articleType, int start, int end) throws SystemException {
		return findByarticleTypeGreater(articleType, start, end, null);
	}

	public List<ProGateJournalArticle> findByarticleTypeGreater(
		int articleType, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(articleType),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticle> list = (List<ProGateJournalArticle>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ARTICLETYPEGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

				query.append("articletype >= ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("article_order ASC, ");
					query.append("updated_at DESC, ");
					query.append("priority DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(articleType);

				list = (List<ProGateJournalArticle>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticle>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ARTICLETYPEGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticle findByarticleTypeGreater_First(
		int articleType, OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		List<ProGateJournalArticle> list = findByarticleTypeGreater(articleType,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticle exists with the key {");

			msg.append("articleType=" + articleType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticle findByarticleTypeGreater_Last(
		int articleType, OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		int count = countByarticleTypeGreater(articleType);

		List<ProGateJournalArticle> list = findByarticleTypeGreater(articleType,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticle exists with the key {");

			msg.append("articleType=" + articleType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticle[] findByarticleTypeGreater_PrevAndNext(
		Integer journalArticleId, int articleType, OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		ProGateJournalArticle proGateJournalArticle = findByPrimaryKey(journalArticleId);

		int count = countByarticleTypeGreater(articleType);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticle WHERE ");

			query.append("articletype >= ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("article_order ASC, ");
				query.append("updated_at DESC, ");
				query.append("priority DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(articleType);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticle);

			ProGateJournalArticle[] array = new ProGateJournalArticleImpl[3];

			array[0] = (ProGateJournalArticle)objArray[0];
			array[1] = (ProGateJournalArticle)objArray[1];
			array[2] = (ProGateJournalArticle)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticle> findByarticleTypeLower(int articleType)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(articleType) };

		List<ProGateJournalArticle> list = (List<ProGateJournalArticle>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ARTICLETYPELOWER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

				query.append("articletype <= ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("article_order ASC, ");
				query.append("updated_at DESC, ");
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
					list = new ArrayList<ProGateJournalArticle>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ARTICLETYPELOWER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticle> findByarticleTypeLower(int articleType,
		int start, int end) throws SystemException {
		return findByarticleTypeLower(articleType, start, end, null);
	}

	public List<ProGateJournalArticle> findByarticleTypeLower(int articleType,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(articleType),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticle> list = (List<ProGateJournalArticle>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ARTICLETYPELOWER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

				query.append("articletype <= ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("article_order ASC, ");
					query.append("updated_at DESC, ");
					query.append("priority DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(articleType);

				list = (List<ProGateJournalArticle>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticle>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ARTICLETYPELOWER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticle findByarticleTypeLower_First(int articleType,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		List<ProGateJournalArticle> list = findByarticleTypeLower(articleType,
				0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticle exists with the key {");

			msg.append("articleType=" + articleType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticle findByarticleTypeLower_Last(int articleType,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		int count = countByarticleTypeLower(articleType);

		List<ProGateJournalArticle> list = findByarticleTypeLower(articleType,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticle exists with the key {");

			msg.append("articleType=" + articleType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticle[] findByarticleTypeLower_PrevAndNext(
		Integer journalArticleId, int articleType, OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		ProGateJournalArticle proGateJournalArticle = findByPrimaryKey(journalArticleId);

		int count = countByarticleTypeLower(articleType);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticle WHERE ");

			query.append("articletype <= ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("article_order ASC, ");
				query.append("updated_at DESC, ");
				query.append("priority DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(articleType);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticle);

			ProGateJournalArticle[] array = new ProGateJournalArticleImpl[3];

			array[0] = (ProGateJournalArticle)objArray[0];
			array[1] = (ProGateJournalArticle)objArray[1];
			array[2] = (ProGateJournalArticle)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticle> findBytitle(String title)
		throws SystemException {
		Object[] finderArgs = new Object[] { title };

		List<ProGateJournalArticle> list = (List<ProGateJournalArticle>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_TITLE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

				if (title == null) {
					query.append("title LIKE null");
				}
				else {
					query.append("title LIKE ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("article_order ASC, ");
				query.append("updated_at DESC, ");
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
					list = new ArrayList<ProGateJournalArticle>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_TITLE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticle> findBytitle(String title, int start,
		int end) throws SystemException {
		return findBytitle(title, start, end, null);
	}

	public List<ProGateJournalArticle> findBytitle(String title, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				title,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticle> list = (List<ProGateJournalArticle>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_TITLE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

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

					query.append("article_order ASC, ");
					query.append("updated_at DESC, ");
					query.append("priority DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (title != null) {
					qPos.add(title);
				}

				list = (List<ProGateJournalArticle>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticle>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_TITLE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticle findBytitle_First(String title,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		List<ProGateJournalArticle> list = findBytitle(title, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticle exists with the key {");

			msg.append("title=" + title);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticle findBytitle_Last(String title,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		int count = countBytitle(title);

		List<ProGateJournalArticle> list = findBytitle(title, count - 1, count,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticle exists with the key {");

			msg.append("title=" + title);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticle[] findBytitle_PrevAndNext(
		Integer journalArticleId, String title, OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		ProGateJournalArticle proGateJournalArticle = findByPrimaryKey(journalArticleId);

		int count = countBytitle(title);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticle WHERE ");

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

				query.append("article_order ASC, ");
				query.append("updated_at DESC, ");
				query.append("priority DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (title != null) {
				qPos.add(title);
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticle);

			ProGateJournalArticle[] array = new ProGateJournalArticleImpl[3];

			array[0] = (ProGateJournalArticle)objArray[0];
			array[1] = (ProGateJournalArticle)objArray[1];
			array[2] = (ProGateJournalArticle)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticle> findBypriorityEqual(int priority)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(priority) };

		List<ProGateJournalArticle> list = (List<ProGateJournalArticle>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_PRIORITYEQUAL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

				query.append("priority = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("article_order ASC, ");
				query.append("updated_at DESC, ");
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
					list = new ArrayList<ProGateJournalArticle>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_PRIORITYEQUAL,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticle> findBypriorityEqual(int priority,
		int start, int end) throws SystemException {
		return findBypriorityEqual(priority, start, end, null);
	}

	public List<ProGateJournalArticle> findBypriorityEqual(int priority,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(priority),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticle> list = (List<ProGateJournalArticle>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_PRIORITYEQUAL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

				query.append("priority = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("article_order ASC, ");
					query.append("updated_at DESC, ");
					query.append("priority DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(priority);

				list = (List<ProGateJournalArticle>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticle>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_PRIORITYEQUAL,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticle findBypriorityEqual_First(int priority,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		List<ProGateJournalArticle> list = findBypriorityEqual(priority, 0, 1,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticle exists with the key {");

			msg.append("priority=" + priority);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticle findBypriorityEqual_Last(int priority,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		int count = countBypriorityEqual(priority);

		List<ProGateJournalArticle> list = findBypriorityEqual(priority,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticle exists with the key {");

			msg.append("priority=" + priority);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticle[] findBypriorityEqual_PrevAndNext(
		Integer journalArticleId, int priority, OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		ProGateJournalArticle proGateJournalArticle = findByPrimaryKey(journalArticleId);

		int count = countBypriorityEqual(priority);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticle WHERE ");

			query.append("priority = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("article_order ASC, ");
				query.append("updated_at DESC, ");
				query.append("priority DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(priority);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticle);

			ProGateJournalArticle[] array = new ProGateJournalArticleImpl[3];

			array[0] = (ProGateJournalArticle)objArray[0];
			array[1] = (ProGateJournalArticle)objArray[1];
			array[2] = (ProGateJournalArticle)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticle> findBypriorityLower(int priority)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(priority) };

		List<ProGateJournalArticle> list = (List<ProGateJournalArticle>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_PRIORITYLOWER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

				query.append("priority <= ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("article_order ASC, ");
				query.append("updated_at DESC, ");
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
					list = new ArrayList<ProGateJournalArticle>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_PRIORITYLOWER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticle> findBypriorityLower(int priority,
		int start, int end) throws SystemException {
		return findBypriorityLower(priority, start, end, null);
	}

	public List<ProGateJournalArticle> findBypriorityLower(int priority,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(priority),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticle> list = (List<ProGateJournalArticle>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_PRIORITYLOWER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

				query.append("priority <= ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("article_order ASC, ");
					query.append("updated_at DESC, ");
					query.append("priority DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(priority);

				list = (List<ProGateJournalArticle>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticle>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_PRIORITYLOWER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticle findBypriorityLower_First(int priority,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		List<ProGateJournalArticle> list = findBypriorityLower(priority, 0, 1,
				obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticle exists with the key {");

			msg.append("priority=" + priority);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticle findBypriorityLower_Last(int priority,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		int count = countBypriorityLower(priority);

		List<ProGateJournalArticle> list = findBypriorityLower(priority,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticle exists with the key {");

			msg.append("priority=" + priority);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticle[] findBypriorityLower_PrevAndNext(
		Integer journalArticleId, int priority, OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		ProGateJournalArticle proGateJournalArticle = findByPrimaryKey(journalArticleId);

		int count = countBypriorityLower(priority);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticle WHERE ");

			query.append("priority <= ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("article_order ASC, ");
				query.append("updated_at DESC, ");
				query.append("priority DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(priority);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticle);

			ProGateJournalArticle[] array = new ProGateJournalArticleImpl[3];

			array[0] = (ProGateJournalArticle)objArray[0];
			array[1] = (ProGateJournalArticle)objArray[1];
			array[2] = (ProGateJournalArticle)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticle> findBypriorityGreater(int priority)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(priority) };

		List<ProGateJournalArticle> list = (List<ProGateJournalArticle>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_PRIORITYGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

				query.append("priority >= ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("article_order ASC, ");
				query.append("updated_at DESC, ");
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
					list = new ArrayList<ProGateJournalArticle>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_PRIORITYGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticle> findBypriorityGreater(int priority,
		int start, int end) throws SystemException {
		return findBypriorityGreater(priority, start, end, null);
	}

	public List<ProGateJournalArticle> findBypriorityGreater(int priority,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(priority),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticle> list = (List<ProGateJournalArticle>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_PRIORITYGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

				query.append("priority >= ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("article_order ASC, ");
					query.append("updated_at DESC, ");
					query.append("priority DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(priority);

				list = (List<ProGateJournalArticle>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticle>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_PRIORITYGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticle findBypriorityGreater_First(int priority,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		List<ProGateJournalArticle> list = findBypriorityGreater(priority, 0,
				1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticle exists with the key {");

			msg.append("priority=" + priority);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticle findBypriorityGreater_Last(int priority,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		int count = countBypriorityGreater(priority);

		List<ProGateJournalArticle> list = findBypriorityGreater(priority,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticle exists with the key {");

			msg.append("priority=" + priority);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticle[] findBypriorityGreater_PrevAndNext(
		Integer journalArticleId, int priority, OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		ProGateJournalArticle proGateJournalArticle = findByPrimaryKey(journalArticleId);

		int count = countBypriorityGreater(priority);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticle WHERE ");

			query.append("priority >= ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("article_order ASC, ");
				query.append("updated_at DESC, ");
				query.append("priority DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(priority);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticle);

			ProGateJournalArticle[] array = new ProGateJournalArticleImpl[3];

			array[0] = (ProGateJournalArticle)objArray[0];
			array[1] = (ProGateJournalArticle)objArray[1];
			array[2] = (ProGateJournalArticle)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticle> findBycreatedBy(int createdBy)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(createdBy) };

		List<ProGateJournalArticle> list = (List<ProGateJournalArticle>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_CREATEDBY,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

				query.append("created_by = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("article_order ASC, ");
				query.append("updated_at DESC, ");
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
					list = new ArrayList<ProGateJournalArticle>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_CREATEDBY,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticle> findBycreatedBy(int createdBy,
		int start, int end) throws SystemException {
		return findBycreatedBy(createdBy, start, end, null);
	}

	public List<ProGateJournalArticle> findBycreatedBy(int createdBy,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(createdBy),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticle> list = (List<ProGateJournalArticle>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_CREATEDBY,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

				query.append("created_by = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("article_order ASC, ");
					query.append("updated_at DESC, ");
					query.append("priority DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(createdBy);

				list = (List<ProGateJournalArticle>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticle>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_CREATEDBY,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticle findBycreatedBy_First(int createdBy,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		List<ProGateJournalArticle> list = findBycreatedBy(createdBy, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticle exists with the key {");

			msg.append("createdBy=" + createdBy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticle findBycreatedBy_Last(int createdBy,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		int count = countBycreatedBy(createdBy);

		List<ProGateJournalArticle> list = findBycreatedBy(createdBy,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticle exists with the key {");

			msg.append("createdBy=" + createdBy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticle[] findBycreatedBy_PrevAndNext(
		Integer journalArticleId, int createdBy, OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		ProGateJournalArticle proGateJournalArticle = findByPrimaryKey(journalArticleId);

		int count = countBycreatedBy(createdBy);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticle WHERE ");

			query.append("created_by = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("article_order ASC, ");
				query.append("updated_at DESC, ");
				query.append("priority DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(createdBy);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticle);

			ProGateJournalArticle[] array = new ProGateJournalArticleImpl[3];

			array[0] = (ProGateJournalArticle)objArray[0];
			array[1] = (ProGateJournalArticle)objArray[1];
			array[2] = (ProGateJournalArticle)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticle> findBycreatedAtEqual(Date createdAt)
		throws SystemException {
		Object[] finderArgs = new Object[] { createdAt };

		List<ProGateJournalArticle> list = (List<ProGateJournalArticle>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_CREATEDATEQUAL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

				if (createdAt == null) {
					query.append("created_at IS NULL");
				}
				else {
					query.append("created_at = ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("article_order ASC, ");
				query.append("updated_at DESC, ");
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
					list = new ArrayList<ProGateJournalArticle>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_CREATEDATEQUAL,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticle> findBycreatedAtEqual(Date createdAt,
		int start, int end) throws SystemException {
		return findBycreatedAtEqual(createdAt, start, end, null);
	}

	public List<ProGateJournalArticle> findBycreatedAtEqual(Date createdAt,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				createdAt,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticle> list = (List<ProGateJournalArticle>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_CREATEDATEQUAL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

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

					query.append("article_order ASC, ");
					query.append("updated_at DESC, ");
					query.append("priority DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (createdAt != null) {
					qPos.add(CalendarUtil.getTimestamp(createdAt));
				}

				list = (List<ProGateJournalArticle>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticle>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_CREATEDATEQUAL,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticle findBycreatedAtEqual_First(Date createdAt,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		List<ProGateJournalArticle> list = findBycreatedAtEqual(createdAt, 0,
				1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticle exists with the key {");

			msg.append("createdAt=" + createdAt);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticle findBycreatedAtEqual_Last(Date createdAt,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		int count = countBycreatedAtEqual(createdAt);

		List<ProGateJournalArticle> list = findBycreatedAtEqual(createdAt,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticle exists with the key {");

			msg.append("createdAt=" + createdAt);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticle[] findBycreatedAtEqual_PrevAndNext(
		Integer journalArticleId, Date createdAt, OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		ProGateJournalArticle proGateJournalArticle = findByPrimaryKey(journalArticleId);

		int count = countBycreatedAtEqual(createdAt);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticle WHERE ");

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

				query.append("article_order ASC, ");
				query.append("updated_at DESC, ");
				query.append("priority DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (createdAt != null) {
				qPos.add(CalendarUtil.getTimestamp(createdAt));
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticle);

			ProGateJournalArticle[] array = new ProGateJournalArticleImpl[3];

			array[0] = (ProGateJournalArticle)objArray[0];
			array[1] = (ProGateJournalArticle)objArray[1];
			array[2] = (ProGateJournalArticle)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticle> findBycreatedAtGreater(Date createdAt)
		throws SystemException {
		Object[] finderArgs = new Object[] { createdAt };

		List<ProGateJournalArticle> list = (List<ProGateJournalArticle>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_CREATEDATGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

				if (createdAt == null) {
					query.append("created_at >= null");
				}
				else {
					query.append("created_at >= ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("article_order ASC, ");
				query.append("updated_at DESC, ");
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
					list = new ArrayList<ProGateJournalArticle>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_CREATEDATGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticle> findBycreatedAtGreater(Date createdAt,
		int start, int end) throws SystemException {
		return findBycreatedAtGreater(createdAt, start, end, null);
	}

	public List<ProGateJournalArticle> findBycreatedAtGreater(Date createdAt,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				createdAt,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticle> list = (List<ProGateJournalArticle>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_CREATEDATGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

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

					query.append("article_order ASC, ");
					query.append("updated_at DESC, ");
					query.append("priority DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (createdAt != null) {
					qPos.add(CalendarUtil.getTimestamp(createdAt));
				}

				list = (List<ProGateJournalArticle>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticle>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_CREATEDATGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticle findBycreatedAtGreater_First(Date createdAt,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		List<ProGateJournalArticle> list = findBycreatedAtGreater(createdAt, 0,
				1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticle exists with the key {");

			msg.append("createdAt=" + createdAt);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticle findBycreatedAtGreater_Last(Date createdAt,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		int count = countBycreatedAtGreater(createdAt);

		List<ProGateJournalArticle> list = findBycreatedAtGreater(createdAt,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticle exists with the key {");

			msg.append("createdAt=" + createdAt);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticle[] findBycreatedAtGreater_PrevAndNext(
		Integer journalArticleId, Date createdAt, OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		ProGateJournalArticle proGateJournalArticle = findByPrimaryKey(journalArticleId);

		int count = countBycreatedAtGreater(createdAt);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticle WHERE ");

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

				query.append("article_order ASC, ");
				query.append("updated_at DESC, ");
				query.append("priority DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (createdAt != null) {
				qPos.add(CalendarUtil.getTimestamp(createdAt));
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticle);

			ProGateJournalArticle[] array = new ProGateJournalArticleImpl[3];

			array[0] = (ProGateJournalArticle)objArray[0];
			array[1] = (ProGateJournalArticle)objArray[1];
			array[2] = (ProGateJournalArticle)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticle> findBycreatedAtLower(Date createdAt)
		throws SystemException {
		Object[] finderArgs = new Object[] { createdAt };

		List<ProGateJournalArticle> list = (List<ProGateJournalArticle>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_CREATEDATLOWER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

				if (createdAt == null) {
					query.append("created_at <= null");
				}
				else {
					query.append("created_at <= ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("article_order ASC, ");
				query.append("updated_at DESC, ");
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
					list = new ArrayList<ProGateJournalArticle>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_CREATEDATLOWER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticle> findBycreatedAtLower(Date createdAt,
		int start, int end) throws SystemException {
		return findBycreatedAtLower(createdAt, start, end, null);
	}

	public List<ProGateJournalArticle> findBycreatedAtLower(Date createdAt,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				createdAt,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticle> list = (List<ProGateJournalArticle>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_CREATEDATLOWER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

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

					query.append("article_order ASC, ");
					query.append("updated_at DESC, ");
					query.append("priority DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (createdAt != null) {
					qPos.add(CalendarUtil.getTimestamp(createdAt));
				}

				list = (List<ProGateJournalArticle>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticle>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_CREATEDATLOWER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticle findBycreatedAtLower_First(Date createdAt,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		List<ProGateJournalArticle> list = findBycreatedAtLower(createdAt, 0,
				1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticle exists with the key {");

			msg.append("createdAt=" + createdAt);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticle findBycreatedAtLower_Last(Date createdAt,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		int count = countBycreatedAtLower(createdAt);

		List<ProGateJournalArticle> list = findBycreatedAtLower(createdAt,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticle exists with the key {");

			msg.append("createdAt=" + createdAt);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticle[] findBycreatedAtLower_PrevAndNext(
		Integer journalArticleId, Date createdAt, OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		ProGateJournalArticle proGateJournalArticle = findByPrimaryKey(journalArticleId);

		int count = countBycreatedAtLower(createdAt);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticle WHERE ");

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

				query.append("article_order ASC, ");
				query.append("updated_at DESC, ");
				query.append("priority DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (createdAt != null) {
				qPos.add(CalendarUtil.getTimestamp(createdAt));
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticle);

			ProGateJournalArticle[] array = new ProGateJournalArticleImpl[3];

			array[0] = (ProGateJournalArticle)objArray[0];
			array[1] = (ProGateJournalArticle)objArray[1];
			array[2] = (ProGateJournalArticle)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticle> findByupdatedBy(int updatedBy)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(updatedBy) };

		List<ProGateJournalArticle> list = (List<ProGateJournalArticle>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_UPDATEDBY,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

				query.append("updated_by = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("article_order ASC, ");
				query.append("updated_at DESC, ");
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
					list = new ArrayList<ProGateJournalArticle>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_UPDATEDBY,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticle> findByupdatedBy(int updatedBy,
		int start, int end) throws SystemException {
		return findByupdatedBy(updatedBy, start, end, null);
	}

	public List<ProGateJournalArticle> findByupdatedBy(int updatedBy,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Integer(updatedBy),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticle> list = (List<ProGateJournalArticle>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_UPDATEDBY,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

				query.append("updated_by = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("article_order ASC, ");
					query.append("updated_at DESC, ");
					query.append("priority DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(updatedBy);

				list = (List<ProGateJournalArticle>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticle>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_UPDATEDBY,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticle findByupdatedBy_First(int updatedBy,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		List<ProGateJournalArticle> list = findByupdatedBy(updatedBy, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticle exists with the key {");

			msg.append("updatedBy=" + updatedBy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticle findByupdatedBy_Last(int updatedBy,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		int count = countByupdatedBy(updatedBy);

		List<ProGateJournalArticle> list = findByupdatedBy(updatedBy,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticle exists with the key {");

			msg.append("updatedBy=" + updatedBy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticle[] findByupdatedBy_PrevAndNext(
		Integer journalArticleId, int updatedBy, OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		ProGateJournalArticle proGateJournalArticle = findByPrimaryKey(journalArticleId);

		int count = countByupdatedBy(updatedBy);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticle WHERE ");

			query.append("updated_by = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("article_order ASC, ");
				query.append("updated_at DESC, ");
				query.append("priority DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(updatedBy);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticle);

			ProGateJournalArticle[] array = new ProGateJournalArticleImpl[3];

			array[0] = (ProGateJournalArticle)objArray[0];
			array[1] = (ProGateJournalArticle)objArray[1];
			array[2] = (ProGateJournalArticle)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticle> findByupdatedAtGreater(Date updatedAt)
		throws SystemException {
		Object[] finderArgs = new Object[] { updatedAt };

		List<ProGateJournalArticle> list = (List<ProGateJournalArticle>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_UPDATEDATGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

				if (updatedAt == null) {
					query.append("updated_at >= null");
				}
				else {
					query.append("updated_at >= ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("article_order ASC, ");
				query.append("updated_at DESC, ");
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
					list = new ArrayList<ProGateJournalArticle>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_UPDATEDATGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticle> findByupdatedAtGreater(Date updatedAt,
		int start, int end) throws SystemException {
		return findByupdatedAtGreater(updatedAt, start, end, null);
	}

	public List<ProGateJournalArticle> findByupdatedAtGreater(Date updatedAt,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				updatedAt,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticle> list = (List<ProGateJournalArticle>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_UPDATEDATGREATER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

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

					query.append("article_order ASC, ");
					query.append("updated_at DESC, ");
					query.append("priority DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (updatedAt != null) {
					qPos.add(CalendarUtil.getTimestamp(updatedAt));
				}

				list = (List<ProGateJournalArticle>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticle>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_UPDATEDATGREATER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticle findByupdatedAtGreater_First(Date updatedAt,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		List<ProGateJournalArticle> list = findByupdatedAtGreater(updatedAt, 0,
				1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticle exists with the key {");

			msg.append("updatedAt=" + updatedAt);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticle findByupdatedAtGreater_Last(Date updatedAt,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		int count = countByupdatedAtGreater(updatedAt);

		List<ProGateJournalArticle> list = findByupdatedAtGreater(updatedAt,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticle exists with the key {");

			msg.append("updatedAt=" + updatedAt);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticle[] findByupdatedAtGreater_PrevAndNext(
		Integer journalArticleId, Date updatedAt, OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		ProGateJournalArticle proGateJournalArticle = findByPrimaryKey(journalArticleId);

		int count = countByupdatedAtGreater(updatedAt);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticle WHERE ");

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

				query.append("article_order ASC, ");
				query.append("updated_at DESC, ");
				query.append("priority DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (updatedAt != null) {
				qPos.add(CalendarUtil.getTimestamp(updatedAt));
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticle);

			ProGateJournalArticle[] array = new ProGateJournalArticleImpl[3];

			array[0] = (ProGateJournalArticle)objArray[0];
			array[1] = (ProGateJournalArticle)objArray[1];
			array[2] = (ProGateJournalArticle)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticle> findByupdatedAtLower(Date updatedAt)
		throws SystemException {
		Object[] finderArgs = new Object[] { updatedAt };

		List<ProGateJournalArticle> list = (List<ProGateJournalArticle>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_UPDATEDATLOWER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

				if (updatedAt == null) {
					query.append("updated_at <= null");
				}
				else {
					query.append("updated_at <= ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("article_order ASC, ");
				query.append("updated_at DESC, ");
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
					list = new ArrayList<ProGateJournalArticle>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_UPDATEDATLOWER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticle> findByupdatedAtLower(Date updatedAt,
		int start, int end) throws SystemException {
		return findByupdatedAtLower(updatedAt, start, end, null);
	}

	public List<ProGateJournalArticle> findByupdatedAtLower(Date updatedAt,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				updatedAt,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticle> list = (List<ProGateJournalArticle>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_UPDATEDATLOWER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

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

					query.append("article_order ASC, ");
					query.append("updated_at DESC, ");
					query.append("priority DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (updatedAt != null) {
					qPos.add(CalendarUtil.getTimestamp(updatedAt));
				}

				list = (List<ProGateJournalArticle>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticle>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_UPDATEDATLOWER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticle findByupdatedAtLower_First(Date updatedAt,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		List<ProGateJournalArticle> list = findByupdatedAtLower(updatedAt, 0,
				1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticle exists with the key {");

			msg.append("updatedAt=" + updatedAt);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticle findByupdatedAtLower_Last(Date updatedAt,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		int count = countByupdatedAtLower(updatedAt);

		List<ProGateJournalArticle> list = findByupdatedAtLower(updatedAt,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticle exists with the key {");

			msg.append("updatedAt=" + updatedAt);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticle[] findByupdatedAtLower_PrevAndNext(
		Integer journalArticleId, Date updatedAt, OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		ProGateJournalArticle proGateJournalArticle = findByPrimaryKey(journalArticleId);

		int count = countByupdatedAtLower(updatedAt);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticle WHERE ");

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

				query.append("article_order ASC, ");
				query.append("updated_at DESC, ");
				query.append("priority DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (updatedAt != null) {
				qPos.add(CalendarUtil.getTimestamp(updatedAt));
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticle);

			ProGateJournalArticle[] array = new ProGateJournalArticleImpl[3];

			array[0] = (ProGateJournalArticle)objArray[0];
			array[1] = (ProGateJournalArticle)objArray[1];
			array[2] = (ProGateJournalArticle)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticle> findByupdatedAtEqual(Date updatedAt)
		throws SystemException {
		Object[] finderArgs = new Object[] { updatedAt };

		List<ProGateJournalArticle> list = (List<ProGateJournalArticle>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_UPDATEDATEQUAL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

				if (updatedAt == null) {
					query.append("updated_at IS NULL");
				}
				else {
					query.append("updated_at = ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("article_order ASC, ");
				query.append("updated_at DESC, ");
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
					list = new ArrayList<ProGateJournalArticle>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_UPDATEDATEQUAL,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticle> findByupdatedAtEqual(Date updatedAt,
		int start, int end) throws SystemException {
		return findByupdatedAtEqual(updatedAt, start, end, null);
	}

	public List<ProGateJournalArticle> findByupdatedAtEqual(Date updatedAt,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				updatedAt,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticle> list = (List<ProGateJournalArticle>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_UPDATEDATEQUAL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

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

					query.append("article_order ASC, ");
					query.append("updated_at DESC, ");
					query.append("priority DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (updatedAt != null) {
					qPos.add(CalendarUtil.getTimestamp(updatedAt));
				}

				list = (List<ProGateJournalArticle>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticle>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_UPDATEDATEQUAL,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticle findByupdatedAtEqual_First(Date updatedAt,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		List<ProGateJournalArticle> list = findByupdatedAtEqual(updatedAt, 0,
				1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticle exists with the key {");

			msg.append("updatedAt=" + updatedAt);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticle findByupdatedAtEqual_Last(Date updatedAt,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		int count = countByupdatedAtEqual(updatedAt);

		List<ProGateJournalArticle> list = findByupdatedAtEqual(updatedAt,
				count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticle exists with the key {");

			msg.append("updatedAt=" + updatedAt);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticle[] findByupdatedAtEqual_PrevAndNext(
		Integer journalArticleId, Date updatedAt, OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		ProGateJournalArticle proGateJournalArticle = findByPrimaryKey(journalArticleId);

		int count = countByupdatedAtEqual(updatedAt);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticle WHERE ");

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

				query.append("article_order ASC, ");
				query.append("updated_at DESC, ");
				query.append("priority DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (updatedAt != null) {
				qPos.add(CalendarUtil.getTimestamp(updatedAt));
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticle);

			ProGateJournalArticle[] array = new ProGateJournalArticleImpl[3];

			array[0] = (ProGateJournalArticle)objArray[0];
			array[1] = (ProGateJournalArticle)objArray[1];
			array[2] = (ProGateJournalArticle)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<ProGateJournalArticle> findByaddInfo(String addInfo)
		throws SystemException {
		Object[] finderArgs = new Object[] { addInfo };

		List<ProGateJournalArticle> list = (List<ProGateJournalArticle>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ADDINFO,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

				if (addInfo == null) {
					query.append("addInfo IS NULL");
				}
				else {
					query.append("addInfo = ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("article_order ASC, ");
				query.append("updated_at DESC, ");
				query.append("priority DESC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (addInfo != null) {
					qPos.add(addInfo);
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticle>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ADDINFO,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<ProGateJournalArticle> findByaddInfo(String addInfo, int start,
		int end) throws SystemException {
		return findByaddInfo(addInfo, start, end, null);
	}

	public List<ProGateJournalArticle> findByaddInfo(String addInfo, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				addInfo,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticle> list = (List<ProGateJournalArticle>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ADDINFO,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

				if (addInfo == null) {
					query.append("addInfo IS NULL");
				}
				else {
					query.append("addInfo = ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("article_order ASC, ");
					query.append("updated_at DESC, ");
					query.append("priority DESC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (addInfo != null) {
					qPos.add(addInfo);
				}

				list = (List<ProGateJournalArticle>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticle>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ADDINFO,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public ProGateJournalArticle findByaddInfo_First(String addInfo,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		List<ProGateJournalArticle> list = findByaddInfo(addInfo, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticle exists with the key {");

			msg.append("addInfo=" + addInfo);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticle findByaddInfo_Last(String addInfo,
		OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		int count = countByaddInfo(addInfo);

		List<ProGateJournalArticle> list = findByaddInfo(addInfo, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No ProGateJournalArticle exists with the key {");

			msg.append("addInfo=" + addInfo);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProGateJournalArticleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public ProGateJournalArticle[] findByaddInfo_PrevAndNext(
		Integer journalArticleId, String addInfo, OrderByComparator obc)
		throws NoSuchProGateJournalArticleException, SystemException {
		ProGateJournalArticle proGateJournalArticle = findByPrimaryKey(journalArticleId);

		int count = countByaddInfo(addInfo);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM larion.progate.model.ProGateJournalArticle WHERE ");

			if (addInfo == null) {
				query.append("addInfo IS NULL");
			}
			else {
				query.append("addInfo = ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("article_order ASC, ");
				query.append("updated_at DESC, ");
				query.append("priority DESC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (addInfo != null) {
				qPos.add(addInfo);
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					proGateJournalArticle);

			ProGateJournalArticle[] array = new ProGateJournalArticleImpl[3];

			array[0] = (ProGateJournalArticle)objArray[0];
			array[1] = (ProGateJournalArticle)objArray[1];
			array[2] = (ProGateJournalArticle)objArray[2];

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

	public List<ProGateJournalArticle> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<ProGateJournalArticle> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<ProGateJournalArticle> findAll(int start, int end,
		OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<ProGateJournalArticle> list = (List<ProGateJournalArticle>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM larion.progate.model.ProGateJournalArticle ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("article_order ASC, ");
					query.append("updated_at DESC, ");
					query.append("priority DESC");
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<ProGateJournalArticle>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ProGateJournalArticle>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ProGateJournalArticle>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByorgId(String orgId) throws SystemException {
		for (ProGateJournalArticle proGateJournalArticle : findByorgId(orgId)) {
			remove(proGateJournalArticle);
		}
	}

	public void removeByarticleOrderEquals(int articleOrder)
		throws SystemException {
		for (ProGateJournalArticle proGateJournalArticle : findByarticleOrderEquals(
				articleOrder)) {
			remove(proGateJournalArticle);
		}
	}

	public void removeByarticleOrderGreater(int articleOrder)
		throws SystemException {
		for (ProGateJournalArticle proGateJournalArticle : findByarticleOrderGreater(
				articleOrder)) {
			remove(proGateJournalArticle);
		}
	}

	public void removeByarticleOrderLower(int articleOrder)
		throws SystemException {
		for (ProGateJournalArticle proGateJournalArticle : findByarticleOrderLower(
				articleOrder)) {
			remove(proGateJournalArticle);
		}
	}

	public void removeByarticleTypeEquals(int articleType)
		throws SystemException {
		for (ProGateJournalArticle proGateJournalArticle : findByarticleTypeEquals(
				articleType)) {
			remove(proGateJournalArticle);
		}
	}

	public void removeByarticleTypeGreater(int articleType)
		throws SystemException {
		for (ProGateJournalArticle proGateJournalArticle : findByarticleTypeGreater(
				articleType)) {
			remove(proGateJournalArticle);
		}
	}

	public void removeByarticleTypeLower(int articleType)
		throws SystemException {
		for (ProGateJournalArticle proGateJournalArticle : findByarticleTypeLower(
				articleType)) {
			remove(proGateJournalArticle);
		}
	}

	public void removeBytitle(String title) throws SystemException {
		for (ProGateJournalArticle proGateJournalArticle : findBytitle(title)) {
			remove(proGateJournalArticle);
		}
	}

	public void removeBypriorityEqual(int priority) throws SystemException {
		for (ProGateJournalArticle proGateJournalArticle : findBypriorityEqual(
				priority)) {
			remove(proGateJournalArticle);
		}
	}

	public void removeBypriorityLower(int priority) throws SystemException {
		for (ProGateJournalArticle proGateJournalArticle : findBypriorityLower(
				priority)) {
			remove(proGateJournalArticle);
		}
	}

	public void removeBypriorityGreater(int priority) throws SystemException {
		for (ProGateJournalArticle proGateJournalArticle : findBypriorityGreater(
				priority)) {
			remove(proGateJournalArticle);
		}
	}

	public void removeBycreatedBy(int createdBy) throws SystemException {
		for (ProGateJournalArticle proGateJournalArticle : findBycreatedBy(
				createdBy)) {
			remove(proGateJournalArticle);
		}
	}

	public void removeBycreatedAtEqual(Date createdAt)
		throws SystemException {
		for (ProGateJournalArticle proGateJournalArticle : findBycreatedAtEqual(
				createdAt)) {
			remove(proGateJournalArticle);
		}
	}

	public void removeBycreatedAtGreater(Date createdAt)
		throws SystemException {
		for (ProGateJournalArticle proGateJournalArticle : findBycreatedAtGreater(
				createdAt)) {
			remove(proGateJournalArticle);
		}
	}

	public void removeBycreatedAtLower(Date createdAt)
		throws SystemException {
		for (ProGateJournalArticle proGateJournalArticle : findBycreatedAtLower(
				createdAt)) {
			remove(proGateJournalArticle);
		}
	}

	public void removeByupdatedBy(int updatedBy) throws SystemException {
		for (ProGateJournalArticle proGateJournalArticle : findByupdatedBy(
				updatedBy)) {
			remove(proGateJournalArticle);
		}
	}

	public void removeByupdatedAtGreater(Date updatedAt)
		throws SystemException {
		for (ProGateJournalArticle proGateJournalArticle : findByupdatedAtGreater(
				updatedAt)) {
			remove(proGateJournalArticle);
		}
	}

	public void removeByupdatedAtLower(Date updatedAt)
		throws SystemException {
		for (ProGateJournalArticle proGateJournalArticle : findByupdatedAtLower(
				updatedAt)) {
			remove(proGateJournalArticle);
		}
	}

	public void removeByupdatedAtEqual(Date updatedAt)
		throws SystemException {
		for (ProGateJournalArticle proGateJournalArticle : findByupdatedAtEqual(
				updatedAt)) {
			remove(proGateJournalArticle);
		}
	}

	public void removeByaddInfo(String addInfo) throws SystemException {
		for (ProGateJournalArticle proGateJournalArticle : findByaddInfo(
				addInfo)) {
			remove(proGateJournalArticle);
		}
	}

	public void removeAll() throws SystemException {
		for (ProGateJournalArticle proGateJournalArticle : findAll()) {
			remove(proGateJournalArticle);
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
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

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

	public int countByarticleOrderEquals(int articleOrder)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(articleOrder) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ARTICLEORDEREQUALS,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

				query.append("article_order = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(articleOrder);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ARTICLEORDEREQUALS,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByarticleOrderGreater(int articleOrder)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(articleOrder) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ARTICLEORDERGREATER,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

				query.append("article_order >= ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(articleOrder);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ARTICLEORDERGREATER,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByarticleOrderLower(int articleOrder)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Integer(articleOrder) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ARTICLEORDERLOWER,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

				query.append("article_order <= ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(articleOrder);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ARTICLEORDERLOWER,
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
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

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
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

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
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

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
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

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
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

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
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

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
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

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
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

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
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

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
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

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
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

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
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

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
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

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
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

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
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

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

	public int countByaddInfo(String addInfo) throws SystemException {
		Object[] finderArgs = new Object[] { addInfo };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ADDINFO,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM larion.progate.model.ProGateJournalArticle WHERE ");

				if (addInfo == null) {
					query.append("addInfo IS NULL");
				}
				else {
					query.append("addInfo = ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (addInfo != null) {
					qPos.add(addInfo);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ADDINFO,
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
						"SELECT COUNT(*) FROM larion.progate.model.ProGateJournalArticle");

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

	public List<larion.progate.model.ProGateJournalArticleSlideShow> getProGateJournalArticleSlideShows(
		Integer pk) throws SystemException {
		return getProGateJournalArticleSlideShows(pk, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS);
	}

	public List<larion.progate.model.ProGateJournalArticleSlideShow> getProGateJournalArticleSlideShows(
		Integer pk, int start, int end) throws SystemException {
		return getProGateJournalArticleSlideShows(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_PROGATEJOURNALARTICLESLIDESHOWS =
		new FinderPath(larion.progate.model.impl.ProGateJournalArticleSlideShowModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.model.impl.ProGateJournalArticleSlideShowModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.service.persistence.ProGateJournalArticleSlideShowPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getProGateJournalArticleSlideShows",
			new String[] {
				Integer.class.getName(), "java.lang.Integer",
				"java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	public List<larion.progate.model.ProGateJournalArticleSlideShow> getProGateJournalArticleSlideShows(
		Integer pk, int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				pk, String.valueOf(start), String.valueOf(end),
				String.valueOf(obc)
			};

		List<larion.progate.model.ProGateJournalArticleSlideShow> list = (List<larion.progate.model.ProGateJournalArticleSlideShow>)FinderCacheUtil.getResult(FINDER_PATH_GET_PROGATEJOURNALARTICLESLIDESHOWS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder sb = new StringBuilder();

				sb.append(_SQL_GETPROGATEJOURNALARTICLESLIDESHOWS);

				if (obc != null) {
					sb.append("ORDER BY ");
					sb.append(obc.getOrderBy());
				}

				else {
					sb.append("ORDER BY ");

					sb.append("progate_products_slideshow.slideindex ASC, ");
					sb.append("progate_products_slideshow.updated_at DESC, ");
					sb.append("progate_products_slideshow.created_at DESC");
				}

				String sql = sb.toString();

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("progate_products_slideshow",
					larion.progate.model.impl.ProGateJournalArticleSlideShowImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<larion.progate.model.ProGateJournalArticleSlideShow>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<larion.progate.model.ProGateJournalArticleSlideShow>();
				}

				proGateJournalArticleSlideShowPersistence.cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_GET_PROGATEJOURNALARTICLESLIDESHOWS,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_PROGATEJOURNALARTICLESLIDESHOWS_SIZE =
		new FinderPath(larion.progate.model.impl.ProGateJournalArticleSlideShowModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.model.impl.ProGateJournalArticleSlideShowModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.service.persistence.ProGateJournalArticleSlideShowPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getProGateJournalArticleSlideShowsSize",
			new String[] { Integer.class.getName() });

	public int getProGateJournalArticleSlideShowsSize(Integer pk)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_PROGATEJOURNALARTICLESLIDESHOWS_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETPROGATEJOURNALARTICLESLIDESHOWSSIZE);

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

				FinderCacheUtil.putResult(FINDER_PATH_GET_PROGATEJOURNALARTICLESLIDESHOWS_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_PROGATEJOURNALARTICLESLIDESHOW =
		new FinderPath(larion.progate.model.impl.ProGateJournalArticleSlideShowModelImpl.ENTITY_CACHE_ENABLED,
			larion.progate.model.impl.ProGateJournalArticleSlideShowModelImpl.FINDER_CACHE_ENABLED,
			larion.progate.service.persistence.ProGateJournalArticleSlideShowPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"containsProGateJournalArticleSlideShow",
			new String[] { Integer.class.getName(), Integer.class.getName() });

	public boolean containsProGateJournalArticleSlideShow(Integer pk,
		Integer proGateJournalArticleSlideShowPK) throws SystemException {
		Object[] finderArgs = new Object[] { pk, proGateJournalArticleSlideShowPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_PROGATEJOURNALARTICLESLIDESHOW,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsProGateJournalArticleSlideShow.contains(
							pk, proGateJournalArticleSlideShowPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_PROGATEJOURNALARTICLESLIDESHOW,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	public boolean containsProGateJournalArticleSlideShows(Integer pk)
		throws SystemException {
		if (getProGateJournalArticleSlideShowsSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.larion.progate.model.ProGateJournalArticle")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ProGateJournalArticle>> listenersList = new ArrayList<ModelListener<ProGateJournalArticle>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ProGateJournalArticle>)Class.forName(
							listenerClassName).newInstance());
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		containsProGateProductsServices = new ContainsProGateProductsServices(this);

		containsProGateJournalArticleSlideShow = new ContainsProGateJournalArticleSlideShow(this);
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
	protected ContainsProGateJournalArticleSlideShow containsProGateJournalArticleSlideShow;

	protected class ContainsProGateProductsServices {
		protected ContainsProGateProductsServices(
			ProGateJournalArticlePersistenceImpl persistenceImpl) {
			super();

			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSPROGATEPRODUCTSSERVICES,
					new int[] { Types.INTEGER, Types.INTEGER }, RowMapper.COUNT);
		}

		protected boolean contains(Integer journalArticleId,
			Integer productsServicesId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						journalArticleId, productsServicesId
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

	protected class ContainsProGateJournalArticleSlideShow {
		protected ContainsProGateJournalArticleSlideShow(
			ProGateJournalArticlePersistenceImpl persistenceImpl) {
			super();

			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSPROGATEJOURNALARTICLESLIDESHOW,
					new int[] { Types.INTEGER, Types.INTEGER }, RowMapper.COUNT);
		}

		protected boolean contains(Integer journalArticleId,
			Integer journalArticleSlideShowId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						journalArticleId, journalArticleSlideShowId
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

	private static final String _SQL_GETPROGATEPRODUCTSSERVICESES = "SELECT {progate_products_services.*} FROM progate_products_services INNER JOIN progate_journalarticle ON (progate_journalarticle.journalArticleId = progate_products_services.journalArticleId) WHERE (progate_journalarticle.journalArticleId = ?)";
	private static final String _SQL_GETPROGATEPRODUCTSSERVICESESSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM progate_products_services WHERE journalArticleId = ?";
	private static final String _SQL_CONTAINSPROGATEPRODUCTSSERVICES = "SELECT COUNT(*) AS COUNT_VALUE FROM progate_products_services WHERE journalArticleId = ? AND productsServicesId = ?";
	private static final String _SQL_GETPROGATEJOURNALARTICLESLIDESHOWS = "SELECT {progate_products_slideshow.*} FROM progate_products_slideshow INNER JOIN progate_journalarticle ON (progate_journalarticle.journalArticleId = progate_products_slideshow.journalArticleId) WHERE (progate_journalarticle.journalArticleId = ?)";
	private static final String _SQL_GETPROGATEJOURNALARTICLESLIDESHOWSSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM progate_products_slideshow WHERE journalArticleId = ?";
	private static final String _SQL_CONTAINSPROGATEJOURNALARTICLESLIDESHOW = "SELECT COUNT(*) AS COUNT_VALUE FROM progate_products_slideshow WHERE journalArticleId = ? AND journalArticleSlideShowId = ?";
	private static Log _log = LogFactoryUtil.getLog(ProGateJournalArticlePersistenceImpl.class);
}