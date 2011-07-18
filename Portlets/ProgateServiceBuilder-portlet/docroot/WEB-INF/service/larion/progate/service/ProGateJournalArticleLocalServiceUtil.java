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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;

/**
 * <a href="ProGateJournalArticleLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateJournalArticleLocalServiceUtil {
	public static larion.progate.model.ProGateJournalArticle addProGateJournalArticle(
		larion.progate.model.ProGateJournalArticle proGateJournalArticle)
		throws com.liferay.portal.SystemException {
		return getService().addProGateJournalArticle(proGateJournalArticle);
	}

	public static larion.progate.model.ProGateJournalArticle createProGateJournalArticle(
		java.lang.Integer journalArticleId) {
		return getService().createProGateJournalArticle(journalArticleId);
	}

	public static void deleteProGateJournalArticle(
		java.lang.Integer journalArticleId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteProGateJournalArticle(journalArticleId);
	}

	public static void deleteProGateJournalArticle(
		larion.progate.model.ProGateJournalArticle proGateJournalArticle)
		throws com.liferay.portal.SystemException {
		getService().deleteProGateJournalArticle(proGateJournalArticle);
	}

	public static java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	public static java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	public static larion.progate.model.ProGateJournalArticle getProGateJournalArticle(
		java.lang.Integer journalArticleId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getProGateJournalArticle(journalArticleId);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> getProGateJournalArticles(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getProGateJournalArticles(start, end);
	}

	public static int getProGateJournalArticlesCount()
		throws com.liferay.portal.SystemException {
		return getService().getProGateJournalArticlesCount();
	}

	public static larion.progate.model.ProGateJournalArticle updateProGateJournalArticle(
		larion.progate.model.ProGateJournalArticle proGateJournalArticle)
		throws com.liferay.portal.SystemException {
		return getService().updateProGateJournalArticle(proGateJournalArticle);
	}

	public static larion.progate.model.ProGateJournalArticle updateProGateJournalArticle(
		larion.progate.model.ProGateJournalArticle proGateJournalArticle,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService()
				   .updateProGateJournalArticle(proGateJournalArticle, merge);
	}

	public static larion.progate.model.ProGateJournalArticle createNewProduct(
		java.lang.String orgId, int userId, java.lang.String productName,
		java.lang.String titleUrl, java.lang.String ArticleType,
		java.lang.String description, double originalPrice, int currencyId,
		int productType, double promoteValue, boolean isBestSelling,
		boolean isHot, java.lang.String content,
		java.lang.String smallImagePath, java.lang.String bigImagePath,
		int amount, java.util.Date expiredDate) {
		return getService()
				   .createNewProduct(orgId, userId, productName, titleUrl,
			ArticleType, description, originalPrice, currencyId, productType,
			promoteValue, isBestSelling, isHot, content, smallImagePath,
			bigImagePath, amount, expiredDate);
	}

	public static larion.progate.model.ProGateJournalArticle createNewArticle(
		java.lang.String orgId, int userId, java.lang.String articleName,
		java.lang.String ArticleType, java.lang.String description,
		java.lang.String content, java.lang.String smallImagePath,
		java.lang.String resourceUrl, java.lang.String addInfo) {
		return getService()
				   .createNewArticle(orgId, userId, articleName, ArticleType,
			description, content, smallImagePath, resourceUrl, addInfo);
	}

	public static larion.progate.model.ProGateJournalArticle updateProGateJournalArticleSupportFAQ(
		larion.progate.model.ProGateJournalArticle object, int newOrder) {
		return getService()
				   .updateProGateJournalArticleSupportFAQ(object, newOrder);
	}

	public static larion.progate.model.ProGateJournalArticle createNewArticleObject(
		java.lang.String orgId, int userId, java.lang.String articleName,
		java.lang.String ArticleType, java.lang.String description,
		java.lang.String content, java.lang.String smallImagePath,
		java.lang.String resourceUrl, java.lang.String addInfo) {
		return getService()
				   .createNewArticleObject(orgId, userId, articleName,
			ArticleType, description, content, smallImagePath, resourceUrl,
			addInfo);
	}

	public static larion.progate.model.ProGateJournalArticle createNews(
		java.lang.String orgId, int userId, java.lang.String articleName,
		java.lang.String ArticleType, java.lang.String description,
		java.lang.String content, java.lang.String smallImagePath,
		java.lang.String resourceUrl, boolean isHot, java.lang.String addInfo) {
		return getService()
				   .createNews(orgId, userId, articleName, ArticleType,
			description, content, smallImagePath, resourceUrl, isHot, addInfo);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> getListProGateArticles(
		int orgId, java.lang.String articleType, java.lang.String addInfo,
		int start, int end) {
		return getService()
				   .getListProGateArticles(orgId, articleType, addInfo, start,
			end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> getListBlogArticles(
		long userId, java.lang.String addInfo, int start, int end) {
		return getService().getListBlogArticles(userId, addInfo, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> getListProGateArticlesByPrority(
		int orgId, java.lang.String articleType, boolean isHot,
		java.lang.String addInfo, int start, int end) {
		return getService()
				   .getListProGateArticlesByPrority(orgId, articleType, isHot,
			addInfo, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> getListCertArticles(
		int orgId, java.lang.String addInfo, int start, int end) {
		return getService().getListCertArticles(orgId, addInfo, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> getListAchievementArticles(
		int orgId, java.lang.String addInfo, int start, int end) {
		return getService()
				   .getListAchievementArticles(orgId, addInfo, start, end);
	}

	public static int countArticleByType(int orgId,
		java.lang.String articleType, java.lang.String addInfo) {
		return getService().countArticleByType(orgId, articleType, addInfo);
	}

	public static int countListBlogArticles(long userId,
		java.lang.String addInfo) {
		return getService().countListBlogArticles(userId, addInfo);
	}

	public static int countListProGateArticlesByPrority(int orgId,
		java.lang.String articleType, boolean isHot, java.lang.String addInfo) {
		return getService()
				   .countListProGateArticlesByPrority(orgId, articleType,
			isHot, addInfo);
	}

	public static int countListCertArticles(int orgId, java.lang.String addInfo) {
		return getService().countListCertArticles(orgId, addInfo);
	}

	public static int countListAchievementArticles(int orgId,
		java.lang.String addInfo) {
		return getService().countListAchievementArticles(orgId, addInfo);
	}

	public static larion.progate.model.ProGateJournalArticle getProGateJournalArticle(
		int articleId) {
		return getService().getProGateJournalArticle(articleId);
	}

	public static larion.progate.model.ProGateJournalArticle createEmptyObject() {
		return getService().createEmptyObject();
	}

	public static void deleteProGateJournalArticleFAQ(int articleId) {
		getService().deleteProGateJournalArticleFAQ(articleId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ProGateJournalArticleLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					ProGateJournalArticleLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new ProGateJournalArticleLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(ProGateJournalArticleLocalService service) {
		_service = service;
	}

	private static ProGateJournalArticleLocalService _service;
}