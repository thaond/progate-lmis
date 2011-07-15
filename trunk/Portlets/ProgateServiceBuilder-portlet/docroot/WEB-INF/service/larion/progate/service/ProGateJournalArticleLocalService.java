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

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;

/**
 * <a href="ProGateJournalArticleLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ProGateJournalArticleLocalService {
	public larion.progate.model.ProGateJournalArticle addProGateJournalArticle(
		larion.progate.model.ProGateJournalArticle proGateJournalArticle)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticle createProGateJournalArticle(
		java.lang.Integer journalArticleId);

	public void deleteProGateJournalArticle(java.lang.Integer journalArticleId)
		throws com.liferay.portal.SystemException,
			com.liferay.portal.PortalException;

	public void deleteProGateJournalArticle(
		larion.progate.model.ProGateJournalArticle proGateJournalArticle)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public larion.progate.model.ProGateJournalArticle getProGateJournalArticle(
		java.lang.Integer journalArticleId)
		throws com.liferay.portal.SystemException,
			com.liferay.portal.PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.model.ProGateJournalArticle> getProGateJournalArticles(
		int start, int end) throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getProGateJournalArticlesCount()
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticle updateProGateJournalArticle(
		larion.progate.model.ProGateJournalArticle proGateJournalArticle)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticle updateProGateJournalArticle(
		larion.progate.model.ProGateJournalArticle proGateJournalArticle,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticle createNewProduct(
		java.lang.String orgId, int userId, java.lang.String productName,
		java.lang.String titleUrl, java.lang.String ArticleType,
		java.lang.String description, double originalPrice, int currencyId,
		int productType, double promoteValue, boolean isBestSelling,
		boolean isHot, java.lang.String content,
		java.lang.String smallImagePath, java.lang.String bigImagePath,
		int amount, java.util.Date expiredDate);

	public larion.progate.model.ProGateJournalArticle createNewArticle(
		java.lang.String orgId, int userId, java.lang.String articleName,
		java.lang.String ArticleType, java.lang.String description,
		java.lang.String content, java.lang.String smallImagePath,
		java.lang.String resourceUrl, java.lang.String addInfo);

	public larion.progate.model.ProGateJournalArticle updateProGateJournalArticleSupportFAQ(
		larion.progate.model.ProGateJournalArticle object, int newOrder);

	public larion.progate.model.ProGateJournalArticle createNewArticleObject(
		java.lang.String orgId, int userId, java.lang.String articleName,
		java.lang.String ArticleType, java.lang.String description,
		java.lang.String content, java.lang.String smallImagePath,
		java.lang.String resourceUrl, java.lang.String addInfo);

	public larion.progate.model.ProGateJournalArticle createNews(
		java.lang.String orgId, int userId, java.lang.String articleName,
		java.lang.String ArticleType, java.lang.String description,
		java.lang.String content, java.lang.String smallImagePath,
		java.lang.String resourceUrl, boolean isHot, java.lang.String addInfo);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.model.ProGateJournalArticle> getListProGateArticles(
		int orgId, java.lang.String articleType, java.lang.String addInfo,
		int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.model.ProGateJournalArticle> getListBlogArticles(
		long userId, java.lang.String addInfo, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.model.ProGateJournalArticle> getListProGateArticlesByPrority(
		int orgId, java.lang.String articleType, boolean isHot,
		java.lang.String addInfo, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.model.ProGateJournalArticle> getListCertArticles(
		int orgId, java.lang.String addInfo, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.model.ProGateJournalArticle> getListAchievementArticles(
		int orgId, java.lang.String addInfo, int start, int end);

	public int countArticleByType(int orgId, java.lang.String articleType,
		java.lang.String addInfo);

	public int countListBlogArticles(long userId, java.lang.String addInfo);

	public int countListProGateArticlesByPrority(int orgId,
		java.lang.String articleType, boolean isHot, java.lang.String addInfo);

	public int countListCertArticles(int orgId, java.lang.String addInfo);

	public int countListAchievementArticles(int orgId, java.lang.String addInfo);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public larion.progate.model.ProGateJournalArticle getProGateJournalArticle(
		int articleId);

	public larion.progate.model.ProGateJournalArticle createEmptyObject();

	public void deleteProGateJournalArticleFAQ(int articleId);
}