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
 * <a href="ProGateJournalArticleTypesLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateJournalArticleTypesLocalServiceUtil {
	public static larion.progate.model.ProGateJournalArticleTypes addProGateJournalArticleTypes(
		larion.progate.model.ProGateJournalArticleTypes proGateJournalArticleTypes)
		throws com.liferay.portal.SystemException {
		return getService()
				   .addProGateJournalArticleTypes(proGateJournalArticleTypes);
	}

	public static larion.progate.model.ProGateJournalArticleTypes createProGateJournalArticleTypes(
		java.lang.Integer journalArticleTypesId) {
		return getService()
				   .createProGateJournalArticleTypes(journalArticleTypesId);
	}

	public static void deleteProGateJournalArticleTypes(
		java.lang.Integer journalArticleTypesId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteProGateJournalArticleTypes(journalArticleTypesId);
	}

	public static void deleteProGateJournalArticleTypes(
		larion.progate.model.ProGateJournalArticleTypes proGateJournalArticleTypes)
		throws com.liferay.portal.SystemException {
		getService().deleteProGateJournalArticleTypes(proGateJournalArticleTypes);
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

	public static larion.progate.model.ProGateJournalArticleTypes getProGateJournalArticleTypes(
		java.lang.Integer journalArticleTypesId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getProGateJournalArticleTypes(journalArticleTypesId);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleTypes> getProGateJournalArticleTypeses(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getProGateJournalArticleTypeses(start, end);
	}

	public static int getProGateJournalArticleTypesesCount()
		throws com.liferay.portal.SystemException {
		return getService().getProGateJournalArticleTypesesCount();
	}

	public static larion.progate.model.ProGateJournalArticleTypes updateProGateJournalArticleTypes(
		larion.progate.model.ProGateJournalArticleTypes proGateJournalArticleTypes)
		throws com.liferay.portal.SystemException {
		return getService()
				   .updateProGateJournalArticleTypes(proGateJournalArticleTypes);
	}

	public static larion.progate.model.ProGateJournalArticleTypes updateProGateJournalArticleTypes(
		larion.progate.model.ProGateJournalArticleTypes proGateJournalArticleTypes,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService()
				   .updateProGateJournalArticleTypes(proGateJournalArticleTypes,
			merge);
	}

	public static java.lang.String getArticleTypeProduct() {
		return getService().getArticleTypeProduct();
	}

	public static larion.progate.model.ProGateJournalArticleTypes createProGateJournalArticleTypes(
		java.lang.String name) {
		return getService().createProGateJournalArticleTypes(name);
	}

	public static java.lang.String getArticleTypeIntroduce() {
		return getService().getArticleTypeIntroduce();
	}

	public static java.lang.String getArticleTypeNews() {
		return getService().getArticleTypeNews();
	}

	public static java.lang.String getArticleTypeHome() {
		return getService().getArticleTypeHome();
	}

	public static java.lang.String getArticleTypeSupport() {
		return getService().getArticleTypeSupport();
	}

	public static java.lang.String getArticleTypeResource() {
		return getService().getArticleTypeResource();
	}

	public static java.lang.String getArticleTypeCert() {
		return getService().getArticleTypeCert();
	}

	public static java.lang.String getArticleTypeRecommendation() {
		return getService().getArticleTypeRecommendation();
	}

	public static java.lang.String getArticleTypeAdvertisement() {
		return getService().getArticleTypeAdvertisement();
	}

	public static java.lang.String getArticleTypeApplication() {
		return getService().getArticleTypeApplication();
	}

	public static java.lang.String getArticleTypeAchievement() {
		return getService().getArticleTypeAchievement();
	}

	public static java.lang.String getArticleTypeOrgOverall() {
		return getService().getArticleTypeOrgOverall();
	}

	public static java.lang.String getArticleTypeOrgHistory() {
		return getService().getArticleTypeOrgHistory();
	}

	public static java.lang.String getArticleTypeOrgMap() {
		return getService().getArticleTypeOrgMap();
	}

	public static java.lang.String getArticleTypeOrgCustomer() {
		return getService().getArticleTypeOrgCustomer();
	}

	public static java.lang.String getArticleTypeOrgPartner() {
		return getService().getArticleTypeOrgPartner();
	}

	public static java.lang.String getArticleTypeOrgOverallIntro() {
		return getService().getArticleTypeOrgOverallIntro();
	}

	public static java.lang.String getArticleTypeOrgOverallVision() {
		return getService().getArticleTypeOrgOverallVision();
	}

	public static java.lang.String getArticleTypeOrgOverallMission() {
		return getService().getArticleTypeOrgOverallMission();
	}

	public static java.lang.String getArticleTypeOrgOverallCoreValue() {
		return getService().getArticleTypeOrgOverallCoreValue();
	}

	public static java.lang.String getArticleTypeOrgSupportFaq() {
		return getService().getArticleTypeOrgSupportFaq();
	}

	public static java.lang.String getArticleTypeOrgSupportGuideline() {
		return getService().getArticleTypeOrgSupportGuideline();
	}

	public static java.lang.String getArticleTypeOrgSupportVideo() {
		return getService().getArticleTypeOrgSupportVideo();
	}

	public static java.lang.String getArticleTypeOrgSupportPdf() {
		return getService().getArticleTypeOrgSupportPdf();
	}

	public static java.lang.String getArticleTypeOrgSupportOnline() {
		return getService().getArticleTypeOrgSupportOnline();
	}

	public static void clearService() {
		_service = null;
	}

	public static ProGateJournalArticleTypesLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					ProGateJournalArticleTypesLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new ProGateJournalArticleTypesLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(ProGateJournalArticleTypesLocalService service) {
		_service = service;
	}

	private static ProGateJournalArticleTypesLocalService _service;
}