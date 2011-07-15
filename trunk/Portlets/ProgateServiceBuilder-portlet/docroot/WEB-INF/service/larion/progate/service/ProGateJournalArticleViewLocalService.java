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
 * <a href="ProGateJournalArticleViewLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ProGateJournalArticleViewLocalService {
	public larion.progate.model.ProGateJournalArticleView addProGateJournalArticleView(
		larion.progate.model.ProGateJournalArticleView proGateJournalArticleView)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleView createProGateJournalArticleView(
		java.lang.Integer journalArticleId);

	public void deleteProGateJournalArticleView(
		java.lang.Integer journalArticleId)
		throws com.liferay.portal.SystemException,
			com.liferay.portal.PortalException;

	public void deleteProGateJournalArticleView(
		larion.progate.model.ProGateJournalArticleView proGateJournalArticleView)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public larion.progate.model.ProGateJournalArticleView getProGateJournalArticleView(
		java.lang.Integer journalArticleId)
		throws com.liferay.portal.SystemException,
			com.liferay.portal.PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.model.ProGateJournalArticleView> getProGateJournalArticleViews(
		int start, int end) throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getProGateJournalArticleViewsCount()
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleView updateProGateJournalArticleView(
		larion.progate.model.ProGateJournalArticleView proGateJournalArticleView)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleView updateProGateJournalArticleView(
		larion.progate.model.ProGateJournalArticleView proGateJournalArticleView,
		boolean merge) throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.model.ProGateJournalArticleView> getListArticleByOrgIdAndProductType(
		int orgId, int productType, java.lang.String ArticleType,
		boolean isHotProduct, int start, int end)
		throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.model.ProGateJournalArticleView> getListArticleByOrgIdAndProductType(
		int orgId, int productType, java.lang.String ArticleType,
		int categoryType, boolean isHotProduct, int start, int end)
		throws com.liferay.portal.SystemException;

	public int countListArticleByOrgIdAndProductType(int orgId,
		int productType, java.lang.String ArticleType, boolean isHotProduct)
		throws com.liferay.portal.SystemException;

	public int countListArticleByOrgIdAndProductType(int orgId,
		int productType, java.lang.String ArticleType, int categoryType,
		boolean isHotProduct) throws com.liferay.portal.SystemException;

	public boolean updateProGateArticleViewObject(
		larion.progate.model.ProGateJournalArticleView articleViewObject);

	public boolean deleteProGateArticleViewObject(
		larion.progate.model.ProGateJournalArticleView articleViewObject);
}