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
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.NullWrapper;

/**
 * <a href="ProGateJournalArticleTypesLocalServiceClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateJournalArticleTypesLocalServiceClp
	implements ProGateJournalArticleTypesLocalService {
	public ProGateJournalArticleTypesLocalServiceClp(
		ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;
	}

	public larion.progate.model.ProGateJournalArticleTypes addProGateJournalArticleTypes(
		larion.progate.model.ProGateJournalArticleTypes proGateJournalArticleTypes)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(proGateJournalArticleTypes);

		if (proGateJournalArticleTypes == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.model.ProGateJournalArticleTypes");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("addProGateJournalArticleTypes",
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

		return (larion.progate.model.ProGateJournalArticleTypes)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.model.ProGateJournalArticleTypes createProGateJournalArticleTypes(
		java.lang.Integer journalArticleTypesId) {
		Object paramObj0 = ClpSerializer.translateInput(journalArticleTypesId);

		if (journalArticleTypesId == null) {
			paramObj0 = new NullWrapper("java.lang.Integer");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("createProGateJournalArticleTypes",
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

		return (larion.progate.model.ProGateJournalArticleTypes)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteProGateJournalArticleTypes(
		java.lang.Integer journalArticleTypesId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(journalArticleTypesId);

		if (journalArticleTypesId == null) {
			paramObj0 = new NullWrapper("java.lang.Integer");
		}

		try {
			_classLoaderProxy.invoke("deleteProGateJournalArticleTypes",
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

	public void deleteProGateJournalArticleTypes(
		larion.progate.model.ProGateJournalArticleTypes proGateJournalArticleTypes)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(proGateJournalArticleTypes);

		if (proGateJournalArticleTypes == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.model.ProGateJournalArticleTypes");
		}

		try {
			_classLoaderProxy.invoke("deleteProGateJournalArticleTypes",
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

	public larion.progate.model.ProGateJournalArticleTypes getProGateJournalArticleTypes(
		java.lang.Integer journalArticleTypesId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(journalArticleTypesId);

		if (journalArticleTypesId == null) {
			paramObj0 = new NullWrapper("java.lang.Integer");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getProGateJournalArticleTypes",
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

		return (larion.progate.model.ProGateJournalArticleTypes)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.model.ProGateJournalArticleTypes> getProGateJournalArticleTypeses(
		int start, int end) throws com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(start);

		Object paramObj1 = new IntegerWrapper(end);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getProGateJournalArticleTypeses",
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

		return (java.util.List<larion.progate.model.ProGateJournalArticleTypes>)ClpSerializer.translateOutput(returnObj);
	}

	public int getProGateJournalArticleTypesesCount()
		throws com.liferay.portal.SystemException {
		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getProGateJournalArticleTypesesCount",
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

	public larion.progate.model.ProGateJournalArticleTypes updateProGateJournalArticleTypes(
		larion.progate.model.ProGateJournalArticleTypes proGateJournalArticleTypes)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(proGateJournalArticleTypes);

		if (proGateJournalArticleTypes == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.model.ProGateJournalArticleTypes");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("updateProGateJournalArticleTypes",
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

		return (larion.progate.model.ProGateJournalArticleTypes)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.model.ProGateJournalArticleTypes updateProGateJournalArticleTypes(
		larion.progate.model.ProGateJournalArticleTypes proGateJournalArticleTypes,
		boolean merge) throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(proGateJournalArticleTypes);

		if (proGateJournalArticleTypes == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.model.ProGateJournalArticleTypes");
		}

		Object paramObj1 = new BooleanWrapper(merge);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("updateProGateJournalArticleTypes",
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

		return (larion.progate.model.ProGateJournalArticleTypes)ClpSerializer.translateOutput(returnObj);
	}

	public java.lang.String getArticleTypeProduct() {
		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getArticleTypeProduct",
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

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.model.ProGateJournalArticleTypes createProGateJournalArticleTypes(
		java.lang.String name) {
		Object paramObj0 = ClpSerializer.translateInput(name);

		if (name == null) {
			paramObj0 = new NullWrapper("java.lang.String");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("createProGateJournalArticleTypes",
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

		return (larion.progate.model.ProGateJournalArticleTypes)ClpSerializer.translateOutput(returnObj);
	}

	public java.lang.String getArticleTypeIntroduce() {
		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getArticleTypeIntroduce",
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

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	public java.lang.String getArticleTypeNews() {
		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getArticleTypeNews",
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

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	public java.lang.String getArticleTypeHome() {
		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getArticleTypeHome",
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

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	public java.lang.String getArticleTypeSupport() {
		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getArticleTypeSupport",
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

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	public java.lang.String getArticleTypeResource() {
		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getArticleTypeResource",
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

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	public java.lang.String getArticleTypeCert() {
		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getArticleTypeCert",
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

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	public java.lang.String getArticleTypeRecommendation() {
		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getArticleTypeRecommendation",
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

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	public java.lang.String getArticleTypeAdvertisement() {
		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getArticleTypeAdvertisement",
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

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	public java.lang.String getArticleTypeApplication() {
		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getArticleTypeApplication",
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

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	public java.lang.String getArticleTypeAchievement() {
		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getArticleTypeAchievement",
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

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	public java.lang.String getArticleTypeOrgOverall() {
		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getArticleTypeOrgOverall",
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

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	public java.lang.String getArticleTypeOrgHistory() {
		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getArticleTypeOrgHistory",
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

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	public java.lang.String getArticleTypeOrgMap() {
		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getArticleTypeOrgMap",
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

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	public java.lang.String getArticleTypeOrgCustomer() {
		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getArticleTypeOrgCustomer",
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

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	public java.lang.String getArticleTypeOrgPartner() {
		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getArticleTypeOrgPartner",
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

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	public java.lang.String getArticleTypeOrgOverallIntro() {
		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getArticleTypeOrgOverallIntro",
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

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	public java.lang.String getArticleTypeOrgOverallVision() {
		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getArticleTypeOrgOverallVision",
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

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	public java.lang.String getArticleTypeOrgOverallMission() {
		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getArticleTypeOrgOverallMission",
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

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	public java.lang.String getArticleTypeOrgOverallCoreValue() {
		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getArticleTypeOrgOverallCoreValue",
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

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	public java.lang.String getArticleTypeOrgSupportFaq() {
		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getArticleTypeOrgSupportFaq",
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

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	public java.lang.String getArticleTypeOrgSupportGuideline() {
		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getArticleTypeOrgSupportGuideline",
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

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	public java.lang.String getArticleTypeOrgSupportVideo() {
		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getArticleTypeOrgSupportVideo",
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

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	public java.lang.String getArticleTypeOrgSupportPdf() {
		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getArticleTypeOrgSupportPdf",
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

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	public java.lang.String getArticleTypeOrgSupportOnline() {
		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getArticleTypeOrgSupportOnline",
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

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	private ClassLoaderProxy _classLoaderProxy;
}