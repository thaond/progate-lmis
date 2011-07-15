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
 * <a href="ProGateJournalArticleViewLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateJournalArticleViewLocalServiceUtil {
	public static larion.progate.model.ProGateJournalArticleView addProGateJournalArticleView(
		larion.progate.model.ProGateJournalArticleView proGateJournalArticleView)
		throws com.liferay.portal.SystemException {
		return getService()
				   .addProGateJournalArticleView(proGateJournalArticleView);
	}

	public static larion.progate.model.ProGateJournalArticleView createProGateJournalArticleView(
		java.lang.Integer journalArticleId) {
		return getService().createProGateJournalArticleView(journalArticleId);
	}

	public static void deleteProGateJournalArticleView(
		java.lang.Integer journalArticleId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteProGateJournalArticleView(journalArticleId);
	}

	public static void deleteProGateJournalArticleView(
		larion.progate.model.ProGateJournalArticleView proGateJournalArticleView)
		throws com.liferay.portal.SystemException {
		getService().deleteProGateJournalArticleView(proGateJournalArticleView);
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

	public static larion.progate.model.ProGateJournalArticleView getProGateJournalArticleView(
		java.lang.Integer journalArticleId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getProGateJournalArticleView(journalArticleId);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> getProGateJournalArticleViews(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getProGateJournalArticleViews(start, end);
	}

	public static int getProGateJournalArticleViewsCount()
		throws com.liferay.portal.SystemException {
		return getService().getProGateJournalArticleViewsCount();
	}

	public static larion.progate.model.ProGateJournalArticleView updateProGateJournalArticleView(
		larion.progate.model.ProGateJournalArticleView proGateJournalArticleView)
		throws com.liferay.portal.SystemException {
		return getService()
				   .updateProGateJournalArticleView(proGateJournalArticleView);
	}

	public static larion.progate.model.ProGateJournalArticleView updateProGateJournalArticleView(
		larion.progate.model.ProGateJournalArticleView proGateJournalArticleView,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService()
				   .updateProGateJournalArticleView(proGateJournalArticleView,
			merge);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> getListArticleByOrgIdAndProductType(
		int orgId, int productType, java.lang.String ArticleType,
		boolean isHotProduct, int start, int end)
		throws com.liferay.portal.SystemException {
		return getService()
				   .getListArticleByOrgIdAndProductType(orgId, productType,
			ArticleType, isHotProduct, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> getListArticleByOrgIdAndProductType(
		int orgId, int productType, java.lang.String ArticleType,
		int categoryType, boolean isHotProduct, int start, int end)
		throws com.liferay.portal.SystemException {
		return getService()
				   .getListArticleByOrgIdAndProductType(orgId, productType,
			ArticleType, categoryType, isHotProduct, start, end);
	}

	public static int countListArticleByOrgIdAndProductType(int orgId,
		int productType, java.lang.String ArticleType, boolean isHotProduct)
		throws com.liferay.portal.SystemException {
		return getService()
				   .countListArticleByOrgIdAndProductType(orgId, productType,
			ArticleType, isHotProduct);
	}

	public static int countListArticleByOrgIdAndProductType(int orgId,
		int productType, java.lang.String ArticleType, int categoryType,
		boolean isHotProduct) throws com.liferay.portal.SystemException {
		return getService()
				   .countListArticleByOrgIdAndProductType(orgId, productType,
			ArticleType, categoryType, isHotProduct);
	}

	public static boolean updateProGateArticleViewObject(
		larion.progate.model.ProGateJournalArticleView articleViewObject) {
		return getService().updateProGateArticleViewObject(articleViewObject);
	}

	public static boolean deleteProGateArticleViewObject(
		larion.progate.model.ProGateJournalArticleView articleViewObject) {
		return getService().deleteProGateArticleViewObject(articleViewObject);
	}

	public static void clearService() {
		_service = null;
	}

	public static ProGateJournalArticleViewLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					ProGateJournalArticleViewLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new ProGateJournalArticleViewLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(ProGateJournalArticleViewLocalService service) {
		_service = service;
	}

	private static ProGateJournalArticleViewLocalService _service;
}