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

package larion.progate.service;

import com.liferay.portal.kernel.util.BooleanWrapper;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.DoubleWrapper;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.LongWrapper;
import com.liferay.portal.kernel.util.NullWrapper;

/**
 * <a href="ProGateJournalArticleLocalServiceClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateJournalArticleLocalServiceClp
	implements ProGateJournalArticleLocalService {
	public ProGateJournalArticleLocalServiceClp(
		ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;
	}

	public larion.progate.model.ProGateJournalArticle addProGateJournalArticle(
		larion.progate.model.ProGateJournalArticle proGateJournalArticle)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(proGateJournalArticle);

		if (proGateJournalArticle == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.model.ProGateJournalArticle");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("addProGateJournalArticle",
					new Object[] { paramObj0 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (larion.progate.model.ProGateJournalArticle)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.model.ProGateJournalArticle createProGateJournalArticle(
		java.lang.Integer journalArticleId) {
		Object paramObj0 = ClpSerializer.translateInput(journalArticleId);

		if (journalArticleId == null) {
			paramObj0 = new NullWrapper("java.lang.Integer");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("createProGateJournalArticle",
					new Object[] { paramObj0 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (larion.progate.model.ProGateJournalArticle)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteProGateJournalArticle(java.lang.Integer journalArticleId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(journalArticleId);

		if (journalArticleId == null) {
			paramObj0 = new NullWrapper("java.lang.Integer");
		}

		try {
			_classLoaderProxy.invoke("deleteProGateJournalArticle",
				new Object[] { paramObj0 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.PortalException) {
				throw (com.liferay.portal.PortalException)t;
			}

			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void deleteProGateJournalArticle(
		larion.progate.model.ProGateJournalArticle proGateJournalArticle)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(proGateJournalArticle);

		if (proGateJournalArticle == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.model.ProGateJournalArticle");
		}

		try {
			_classLoaderProxy.invoke("deleteProGateJournalArticle",
				new Object[] { paramObj0 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(dynamicQuery);

		if (dynamicQuery == null) {
			paramObj0 = new NullWrapper(
					"com.liferay.portal.kernel.dao.orm.DynamicQuery");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("dynamicQuery",
					new Object[] { paramObj0 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<Object>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(dynamicQuery);

		if (dynamicQuery == null) {
			paramObj0 = new NullWrapper(
					"com.liferay.portal.kernel.dao.orm.DynamicQuery");
		}

		Object paramObj1 = new IntegerWrapper(start);

		Object paramObj2 = new IntegerWrapper(end);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("dynamicQuery",
					new Object[] { paramObj0, paramObj1, paramObj2 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<Object>)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.model.ProGateJournalArticle getProGateJournalArticle(
		java.lang.Integer journalArticleId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(journalArticleId);

		if (journalArticleId == null) {
			paramObj0 = new NullWrapper("java.lang.Integer");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getProGateJournalArticle",
					new Object[] { paramObj0 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.PortalException) {
				throw (com.liferay.portal.PortalException)t;
			}

			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (larion.progate.model.ProGateJournalArticle)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.model.ProGateJournalArticle> getProGateJournalArticles(
		int start, int end) throws com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(start);

		Object paramObj1 = new IntegerWrapper(end);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getProGateJournalArticles",
					new Object[] { paramObj0, paramObj1 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<larion.progate.model.ProGateJournalArticle>)ClpSerializer.translateOutput(returnObj);
	}

	public int getProGateJournalArticlesCount()
		throws com.liferay.portal.SystemException {
		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getProGateJournalArticlesCount",
					new Object[0]);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public larion.progate.model.ProGateJournalArticle updateProGateJournalArticle(
		larion.progate.model.ProGateJournalArticle proGateJournalArticle)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(proGateJournalArticle);

		if (proGateJournalArticle == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.model.ProGateJournalArticle");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("updateProGateJournalArticle",
					new Object[] { paramObj0 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (larion.progate.model.ProGateJournalArticle)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.model.ProGateJournalArticle updateProGateJournalArticle(
		larion.progate.model.ProGateJournalArticle proGateJournalArticle,
		boolean merge) throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(proGateJournalArticle);

		if (proGateJournalArticle == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.model.ProGateJournalArticle");
		}

		Object paramObj1 = new BooleanWrapper(merge);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("updateProGateJournalArticle",
					new Object[] { paramObj0, paramObj1 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (larion.progate.model.ProGateJournalArticle)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.model.ProGateJournalArticle createNewProduct(
		java.lang.String orgId, int userId, java.lang.String productName,
		java.lang.String titleUrl, java.lang.String ArticleType,
		java.lang.String description, double originalPrice, int currencyId,
		int productType, double promoteValue, boolean isBestSelling,
		boolean isHot, java.lang.String content,
		java.lang.String smallImagePath, java.lang.String bigImagePath,
		int amount, java.util.Date expiredDate) {
		Object paramObj0 = ClpSerializer.translateInput(orgId);

		if (orgId == null) {
			paramObj0 = new NullWrapper("java.lang.String");
		}

		Object paramObj1 = new IntegerWrapper(userId);

		Object paramObj2 = ClpSerializer.translateInput(productName);

		if (productName == null) {
			paramObj2 = new NullWrapper("java.lang.String");
		}

		Object paramObj3 = ClpSerializer.translateInput(titleUrl);

		if (titleUrl == null) {
			paramObj3 = new NullWrapper("java.lang.String");
		}

		Object paramObj4 = ClpSerializer.translateInput(ArticleType);

		if (ArticleType == null) {
			paramObj4 = new NullWrapper("java.lang.String");
		}

		Object paramObj5 = ClpSerializer.translateInput(description);

		if (description == null) {
			paramObj5 = new NullWrapper("java.lang.String");
		}

		Object paramObj6 = new DoubleWrapper(originalPrice);

		Object paramObj7 = new IntegerWrapper(currencyId);

		Object paramObj8 = new IntegerWrapper(productType);

		Object paramObj9 = new DoubleWrapper(promoteValue);

		Object paramObj10 = new BooleanWrapper(isBestSelling);

		Object paramObj11 = new BooleanWrapper(isHot);

		Object paramObj12 = ClpSerializer.translateInput(content);

		if (content == null) {
			paramObj12 = new NullWrapper("java.lang.String");
		}

		Object paramObj13 = ClpSerializer.translateInput(smallImagePath);

		if (smallImagePath == null) {
			paramObj13 = new NullWrapper("java.lang.String");
		}

		Object paramObj14 = ClpSerializer.translateInput(bigImagePath);

		if (bigImagePath == null) {
			paramObj14 = new NullWrapper("java.lang.String");
		}

		Object paramObj15 = new IntegerWrapper(amount);

		Object paramObj16 = ClpSerializer.translateInput(expiredDate);

		if (expiredDate == null) {
			paramObj16 = new NullWrapper("java.util.Date");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("createNewProduct",
					new Object[] {
						paramObj0, paramObj1, paramObj2, paramObj3, paramObj4,
						paramObj5, paramObj6, paramObj7, paramObj8, paramObj9,
						paramObj10, paramObj11, paramObj12, paramObj13,
						paramObj14, paramObj15, paramObj16
					});
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (larion.progate.model.ProGateJournalArticle)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.model.ProGateJournalArticle createNewArticle(
		java.lang.String orgId, int userId, java.lang.String articleName,
		java.lang.String ArticleType, java.lang.String description,
		java.lang.String content, java.lang.String smallImagePath,
		java.lang.String resourceUrl, java.lang.String addInfo) {
		Object paramObj0 = ClpSerializer.translateInput(orgId);

		if (orgId == null) {
			paramObj0 = new NullWrapper("java.lang.String");
		}

		Object paramObj1 = new IntegerWrapper(userId);

		Object paramObj2 = ClpSerializer.translateInput(articleName);

		if (articleName == null) {
			paramObj2 = new NullWrapper("java.lang.String");
		}

		Object paramObj3 = ClpSerializer.translateInput(ArticleType);

		if (ArticleType == null) {
			paramObj3 = new NullWrapper("java.lang.String");
		}

		Object paramObj4 = ClpSerializer.translateInput(description);

		if (description == null) {
			paramObj4 = new NullWrapper("java.lang.String");
		}

		Object paramObj5 = ClpSerializer.translateInput(content);

		if (content == null) {
			paramObj5 = new NullWrapper("java.lang.String");
		}

		Object paramObj6 = ClpSerializer.translateInput(smallImagePath);

		if (smallImagePath == null) {
			paramObj6 = new NullWrapper("java.lang.String");
		}

		Object paramObj7 = ClpSerializer.translateInput(resourceUrl);

		if (resourceUrl == null) {
			paramObj7 = new NullWrapper("java.lang.String");
		}

		Object paramObj8 = ClpSerializer.translateInput(addInfo);

		if (addInfo == null) {
			paramObj8 = new NullWrapper("java.lang.String");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("createNewArticle",
					new Object[] {
						paramObj0, paramObj1, paramObj2, paramObj3, paramObj4,
						paramObj5, paramObj6, paramObj7, paramObj8
					});
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (larion.progate.model.ProGateJournalArticle)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.model.ProGateJournalArticle updateProGateJournalArticleSupportFAQ(
		larion.progate.model.ProGateJournalArticle object, int newOrder) {
		Object paramObj0 = ClpSerializer.translateInput(object);

		if (object == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.model.ProGateJournalArticle");
		}

		Object paramObj1 = new IntegerWrapper(newOrder);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("updateProGateJournalArticleSupportFAQ",
					new Object[] { paramObj0, paramObj1 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (larion.progate.model.ProGateJournalArticle)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.model.ProGateJournalArticle createNewArticleObject(
		java.lang.String orgId, int userId, java.lang.String articleName,
		java.lang.String ArticleType, java.lang.String description,
		java.lang.String content, java.lang.String smallImagePath,
		java.lang.String resourceUrl, java.lang.String addInfo) {
		Object paramObj0 = ClpSerializer.translateInput(orgId);

		if (orgId == null) {
			paramObj0 = new NullWrapper("java.lang.String");
		}

		Object paramObj1 = new IntegerWrapper(userId);

		Object paramObj2 = ClpSerializer.translateInput(articleName);

		if (articleName == null) {
			paramObj2 = new NullWrapper("java.lang.String");
		}

		Object paramObj3 = ClpSerializer.translateInput(ArticleType);

		if (ArticleType == null) {
			paramObj3 = new NullWrapper("java.lang.String");
		}

		Object paramObj4 = ClpSerializer.translateInput(description);

		if (description == null) {
			paramObj4 = new NullWrapper("java.lang.String");
		}

		Object paramObj5 = ClpSerializer.translateInput(content);

		if (content == null) {
			paramObj5 = new NullWrapper("java.lang.String");
		}

		Object paramObj6 = ClpSerializer.translateInput(smallImagePath);

		if (smallImagePath == null) {
			paramObj6 = new NullWrapper("java.lang.String");
		}

		Object paramObj7 = ClpSerializer.translateInput(resourceUrl);

		if (resourceUrl == null) {
			paramObj7 = new NullWrapper("java.lang.String");
		}

		Object paramObj8 = ClpSerializer.translateInput(addInfo);

		if (addInfo == null) {
			paramObj8 = new NullWrapper("java.lang.String");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("createNewArticleObject",
					new Object[] {
						paramObj0, paramObj1, paramObj2, paramObj3, paramObj4,
						paramObj5, paramObj6, paramObj7, paramObj8
					});
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (larion.progate.model.ProGateJournalArticle)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.model.ProGateJournalArticle createNews(
		java.lang.String orgId, int userId, java.lang.String articleName,
		java.lang.String ArticleType, java.lang.String description,
		java.lang.String content, java.lang.String smallImagePath,
		java.lang.String resourceUrl, boolean isHot, java.lang.String addInfo) {
		Object paramObj0 = ClpSerializer.translateInput(orgId);

		if (orgId == null) {
			paramObj0 = new NullWrapper("java.lang.String");
		}

		Object paramObj1 = new IntegerWrapper(userId);

		Object paramObj2 = ClpSerializer.translateInput(articleName);

		if (articleName == null) {
			paramObj2 = new NullWrapper("java.lang.String");
		}

		Object paramObj3 = ClpSerializer.translateInput(ArticleType);

		if (ArticleType == null) {
			paramObj3 = new NullWrapper("java.lang.String");
		}

		Object paramObj4 = ClpSerializer.translateInput(description);

		if (description == null) {
			paramObj4 = new NullWrapper("java.lang.String");
		}

		Object paramObj5 = ClpSerializer.translateInput(content);

		if (content == null) {
			paramObj5 = new NullWrapper("java.lang.String");
		}

		Object paramObj6 = ClpSerializer.translateInput(smallImagePath);

		if (smallImagePath == null) {
			paramObj6 = new NullWrapper("java.lang.String");
		}

		Object paramObj7 = ClpSerializer.translateInput(resourceUrl);

		if (resourceUrl == null) {
			paramObj7 = new NullWrapper("java.lang.String");
		}

		Object paramObj8 = new BooleanWrapper(isHot);

		Object paramObj9 = ClpSerializer.translateInput(addInfo);

		if (addInfo == null) {
			paramObj9 = new NullWrapper("java.lang.String");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("createNews",
					new Object[] {
						paramObj0, paramObj1, paramObj2, paramObj3, paramObj4,
						paramObj5, paramObj6, paramObj7, paramObj8, paramObj9
					});
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (larion.progate.model.ProGateJournalArticle)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.model.ProGateJournalArticle> getListProGateArticles(
		int orgId, java.lang.String articleType, java.lang.String addInfo,
		int start, int end) {
		Object paramObj0 = new IntegerWrapper(orgId);

		Object paramObj1 = ClpSerializer.translateInput(articleType);

		if (articleType == null) {
			paramObj1 = new NullWrapper("java.lang.String");
		}

		Object paramObj2 = ClpSerializer.translateInput(addInfo);

		if (addInfo == null) {
			paramObj2 = new NullWrapper("java.lang.String");
		}

		Object paramObj3 = new IntegerWrapper(start);

		Object paramObj4 = new IntegerWrapper(end);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getListProGateArticles",
					new Object[] {
						paramObj0, paramObj1, paramObj2, paramObj3, paramObj4
					});
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<larion.progate.model.ProGateJournalArticle>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.model.ProGateJournalArticle> getListBlogArticles(
		long userId, java.lang.String addInfo, int start, int end) {
		Object paramObj0 = new LongWrapper(userId);

		Object paramObj1 = ClpSerializer.translateInput(addInfo);

		if (addInfo == null) {
			paramObj1 = new NullWrapper("java.lang.String");
		}

		Object paramObj2 = new IntegerWrapper(start);

		Object paramObj3 = new IntegerWrapper(end);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getListBlogArticles",
					new Object[] { paramObj0, paramObj1, paramObj2, paramObj3 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<larion.progate.model.ProGateJournalArticle>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.model.ProGateJournalArticle> getListProGateArticlesByPrority(
		int orgId, java.lang.String articleType, boolean isHot,
		java.lang.String addInfo, int start, int end) {
		Object paramObj0 = new IntegerWrapper(orgId);

		Object paramObj1 = ClpSerializer.translateInput(articleType);

		if (articleType == null) {
			paramObj1 = new NullWrapper("java.lang.String");
		}

		Object paramObj2 = new BooleanWrapper(isHot);

		Object paramObj3 = ClpSerializer.translateInput(addInfo);

		if (addInfo == null) {
			paramObj3 = new NullWrapper("java.lang.String");
		}

		Object paramObj4 = new IntegerWrapper(start);

		Object paramObj5 = new IntegerWrapper(end);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getListProGateArticlesByPrority",
					new Object[] {
						paramObj0, paramObj1, paramObj2, paramObj3, paramObj4,
						paramObj5
					});
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<larion.progate.model.ProGateJournalArticle>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.model.ProGateJournalArticle> getListCertArticles(
		int orgId, java.lang.String addInfo, int start, int end) {
		Object paramObj0 = new IntegerWrapper(orgId);

		Object paramObj1 = ClpSerializer.translateInput(addInfo);

		if (addInfo == null) {
			paramObj1 = new NullWrapper("java.lang.String");
		}

		Object paramObj2 = new IntegerWrapper(start);

		Object paramObj3 = new IntegerWrapper(end);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getListCertArticles",
					new Object[] { paramObj0, paramObj1, paramObj2, paramObj3 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<larion.progate.model.ProGateJournalArticle>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.model.ProGateJournalArticle> getListAchievementArticles(
		int orgId, java.lang.String addInfo, int start, int end) {
		Object paramObj0 = new IntegerWrapper(orgId);

		Object paramObj1 = ClpSerializer.translateInput(addInfo);

		if (addInfo == null) {
			paramObj1 = new NullWrapper("java.lang.String");
		}

		Object paramObj2 = new IntegerWrapper(start);

		Object paramObj3 = new IntegerWrapper(end);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getListAchievementArticles",
					new Object[] { paramObj0, paramObj1, paramObj2, paramObj3 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<larion.progate.model.ProGateJournalArticle>)ClpSerializer.translateOutput(returnObj);
	}

	public int countArticleByType(int orgId, java.lang.String articleType,
		java.lang.String addInfo) {
		Object paramObj0 = new IntegerWrapper(orgId);

		Object paramObj1 = ClpSerializer.translateInput(articleType);

		if (articleType == null) {
			paramObj1 = new NullWrapper("java.lang.String");
		}

		Object paramObj2 = ClpSerializer.translateInput(addInfo);

		if (addInfo == null) {
			paramObj2 = new NullWrapper("java.lang.String");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("countArticleByType",
					new Object[] { paramObj0, paramObj1, paramObj2 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public int countListBlogArticles(long userId, java.lang.String addInfo) {
		Object paramObj0 = new LongWrapper(userId);

		Object paramObj1 = ClpSerializer.translateInput(addInfo);

		if (addInfo == null) {
			paramObj1 = new NullWrapper("java.lang.String");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("countListBlogArticles",
					new Object[] { paramObj0, paramObj1 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public int countListProGateArticlesByPrority(int orgId,
		java.lang.String articleType, boolean isHot, java.lang.String addInfo) {
		Object paramObj0 = new IntegerWrapper(orgId);

		Object paramObj1 = ClpSerializer.translateInput(articleType);

		if (articleType == null) {
			paramObj1 = new NullWrapper("java.lang.String");
		}

		Object paramObj2 = new BooleanWrapper(isHot);

		Object paramObj3 = ClpSerializer.translateInput(addInfo);

		if (addInfo == null) {
			paramObj3 = new NullWrapper("java.lang.String");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("countListProGateArticlesByPrority",
					new Object[] { paramObj0, paramObj1, paramObj2, paramObj3 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public int countListCertArticles(int orgId, java.lang.String addInfo) {
		Object paramObj0 = new IntegerWrapper(orgId);

		Object paramObj1 = ClpSerializer.translateInput(addInfo);

		if (addInfo == null) {
			paramObj1 = new NullWrapper("java.lang.String");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("countListCertArticles",
					new Object[] { paramObj0, paramObj1 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public int countListAchievementArticles(int orgId, java.lang.String addInfo) {
		Object paramObj0 = new IntegerWrapper(orgId);

		Object paramObj1 = ClpSerializer.translateInput(addInfo);

		if (addInfo == null) {
			paramObj1 = new NullWrapper("java.lang.String");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("countListAchievementArticles",
					new Object[] { paramObj0, paramObj1 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public larion.progate.model.ProGateJournalArticle getProGateJournalArticle(
		int articleId) {
		Object paramObj0 = new IntegerWrapper(articleId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getProGateJournalArticle",
					new Object[] { paramObj0 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (larion.progate.model.ProGateJournalArticle)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.model.ProGateJournalArticle createEmptyObject() {
		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("createEmptyObject",
					new Object[0]);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (larion.progate.model.ProGateJournalArticle)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteProGateJournalArticleFAQ(int articleId) {
		Object paramObj0 = new IntegerWrapper(articleId);

		try {
			_classLoaderProxy.invoke("deleteProGateJournalArticleFAQ",
				new Object[] { paramObj0 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	private ClassLoaderProxy _classLoaderProxy;
}