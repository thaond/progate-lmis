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
 * <a href="ProGateJournalArticleTypesLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ProGateJournalArticleTypesLocalService {
	public larion.progate.model.ProGateJournalArticleTypes addProGateJournalArticleTypes(
		larion.progate.model.ProGateJournalArticleTypes proGateJournalArticleTypes)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleTypes createProGateJournalArticleTypes(
		java.lang.Integer journalArticleTypesId);

	public void deleteProGateJournalArticleTypes(
		java.lang.Integer journalArticleTypesId)
		throws com.liferay.portal.SystemException,
			com.liferay.portal.PortalException;

	public void deleteProGateJournalArticleTypes(
		larion.progate.model.ProGateJournalArticleTypes proGateJournalArticleTypes)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public larion.progate.model.ProGateJournalArticleTypes getProGateJournalArticleTypes(
		java.lang.Integer journalArticleTypesId)
		throws com.liferay.portal.SystemException,
			com.liferay.portal.PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.model.ProGateJournalArticleTypes> getProGateJournalArticleTypeses(
		int start, int end) throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getProGateJournalArticleTypesesCount()
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleTypes updateProGateJournalArticleTypes(
		larion.progate.model.ProGateJournalArticleTypes proGateJournalArticleTypes)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleTypes updateProGateJournalArticleTypes(
		larion.progate.model.ProGateJournalArticleTypes proGateJournalArticleTypes,
		boolean merge) throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getArticleTypeProduct();

	public larion.progate.model.ProGateJournalArticleTypes createProGateJournalArticleTypes(
		java.lang.String name);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getArticleTypeIntroduce();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getArticleTypeNews();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getArticleTypeHome();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getArticleTypeSupport();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getArticleTypeResource();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getArticleTypeCert();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getArticleTypeRecommendation();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getArticleTypeAdvertisement();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getArticleTypeApplication();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getArticleTypeAchievement();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getArticleTypeOrgOverall();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getArticleTypeOrgHistory();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getArticleTypeOrgMap();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getArticleTypeOrgCustomer();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getArticleTypeOrgPartner();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getArticleTypeOrgOverallIntro();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getArticleTypeOrgOverallVision();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getArticleTypeOrgOverallMission();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getArticleTypeOrgOverallCoreValue();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getArticleTypeOrgSupportFaq();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getArticleTypeOrgSupportGuideline();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getArticleTypeOrgSupportVideo();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getArticleTypeOrgSupportPdf();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getArticleTypeOrgSupportOnline();
}