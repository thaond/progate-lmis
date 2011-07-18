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
 * <a href="ProGateJournalArticleViewLocalServiceClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateJournalArticleViewLocalServiceClp
	implements ProGateJournalArticleViewLocalService {
	public ProGateJournalArticleViewLocalServiceClp(
		ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;
	}

	public larion.progate.model.ProGateJournalArticleView addProGateJournalArticleView(
		larion.progate.model.ProGateJournalArticleView proGateJournalArticleView)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(proGateJournalArticleView);

		if (proGateJournalArticleView == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.model.ProGateJournalArticleView");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("addProGateJournalArticleView",
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

		return (larion.progate.model.ProGateJournalArticleView)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.model.ProGateJournalArticleView createProGateJournalArticleView(
		java.lang.Integer journalArticleId) {
		Object paramObj0 = ClpSerializer.translateInput(journalArticleId);

		if (journalArticleId == null) {
			paramObj0 = new NullWrapper("java.lang.Integer");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("createProGateJournalArticleView",
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

		return (larion.progate.model.ProGateJournalArticleView)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteProGateJournalArticleView(
		java.lang.Integer journalArticleId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(journalArticleId);

		if (journalArticleId == null) {
			paramObj0 = new NullWrapper("java.lang.Integer");
		}

		try {
			_classLoaderProxy.invoke("deleteProGateJournalArticleView",
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

	public void deleteProGateJournalArticleView(
		larion.progate.model.ProGateJournalArticleView proGateJournalArticleView)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(proGateJournalArticleView);

		if (proGateJournalArticleView == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.model.ProGateJournalArticleView");
		}

		try {
			_classLoaderProxy.invoke("deleteProGateJournalArticleView",
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

	public larion.progate.model.ProGateJournalArticleView getProGateJournalArticleView(
		java.lang.Integer journalArticleId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(journalArticleId);

		if (journalArticleId == null) {
			paramObj0 = new NullWrapper("java.lang.Integer");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getProGateJournalArticleView",
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

		return (larion.progate.model.ProGateJournalArticleView)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.model.ProGateJournalArticleView> getProGateJournalArticleViews(
		int start, int end) throws com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(start);

		Object paramObj1 = new IntegerWrapper(end);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getProGateJournalArticleViews",
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

		return (java.util.List<larion.progate.model.ProGateJournalArticleView>)ClpSerializer.translateOutput(returnObj);
	}

	public int getProGateJournalArticleViewsCount()
		throws com.liferay.portal.SystemException {
		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getProGateJournalArticleViewsCount",
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

	public larion.progate.model.ProGateJournalArticleView updateProGateJournalArticleView(
		larion.progate.model.ProGateJournalArticleView proGateJournalArticleView)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(proGateJournalArticleView);

		if (proGateJournalArticleView == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.model.ProGateJournalArticleView");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("updateProGateJournalArticleView",
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

		return (larion.progate.model.ProGateJournalArticleView)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.model.ProGateJournalArticleView updateProGateJournalArticleView(
		larion.progate.model.ProGateJournalArticleView proGateJournalArticleView,
		boolean merge) throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(proGateJournalArticleView);

		if (proGateJournalArticleView == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.model.ProGateJournalArticleView");
		}

		Object paramObj1 = new BooleanWrapper(merge);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("updateProGateJournalArticleView",
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

		return (larion.progate.model.ProGateJournalArticleView)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.model.ProGateJournalArticleView> getListArticleByOrgIdAndProductType(
		int orgId, int productType, java.lang.String ArticleType,
		boolean isHotProduct, int start, int end)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(orgId);

		Object paramObj1 = new IntegerWrapper(productType);

		Object paramObj2 = ClpSerializer.translateInput(ArticleType);

		if (ArticleType == null) {
			paramObj2 = new NullWrapper("java.lang.String");
		}

		Object paramObj3 = new BooleanWrapper(isHotProduct);

		Object paramObj4 = new IntegerWrapper(start);

		Object paramObj5 = new IntegerWrapper(end);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getListArticleByOrgIdAndProductType",
					new Object[] {
						paramObj0, paramObj1, paramObj2, paramObj3, paramObj4,
						paramObj5
					});
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

		return (java.util.List<larion.progate.model.ProGateJournalArticleView>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.model.ProGateJournalArticleView> getListArticleByOrgIdAndProductType(
		int orgId, int productType, java.lang.String ArticleType,
		int categoryType, boolean isHotProduct, int start, int end)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(orgId);

		Object paramObj1 = new IntegerWrapper(productType);

		Object paramObj2 = ClpSerializer.translateInput(ArticleType);

		if (ArticleType == null) {
			paramObj2 = new NullWrapper("java.lang.String");
		}

		Object paramObj3 = new IntegerWrapper(categoryType);

		Object paramObj4 = new BooleanWrapper(isHotProduct);

		Object paramObj5 = new IntegerWrapper(start);

		Object paramObj6 = new IntegerWrapper(end);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getListArticleByOrgIdAndProductType",
					new Object[] {
						paramObj0, paramObj1, paramObj2, paramObj3, paramObj4,
						paramObj5, paramObj6
					});
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

		return (java.util.List<larion.progate.model.ProGateJournalArticleView>)ClpSerializer.translateOutput(returnObj);
	}

	public int countListArticleByOrgIdAndProductType(int orgId,
		int productType, java.lang.String ArticleType, boolean isHotProduct)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(orgId);

		Object paramObj1 = new IntegerWrapper(productType);

		Object paramObj2 = ClpSerializer.translateInput(ArticleType);

		if (ArticleType == null) {
			paramObj2 = new NullWrapper("java.lang.String");
		}

		Object paramObj3 = new BooleanWrapper(isHotProduct);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("countListArticleByOrgIdAndProductType",
					new Object[] { paramObj0, paramObj1, paramObj2, paramObj3 });
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

	public int countListArticleByOrgIdAndProductType(int orgId,
		int productType, java.lang.String ArticleType, int categoryType,
		boolean isHotProduct) throws com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(orgId);

		Object paramObj1 = new IntegerWrapper(productType);

		Object paramObj2 = ClpSerializer.translateInput(ArticleType);

		if (ArticleType == null) {
			paramObj2 = new NullWrapper("java.lang.String");
		}

		Object paramObj3 = new IntegerWrapper(categoryType);

		Object paramObj4 = new BooleanWrapper(isHotProduct);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("countListArticleByOrgIdAndProductType",
					new Object[] {
						paramObj0, paramObj1, paramObj2, paramObj3, paramObj4
					});
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

	public boolean updateProGateArticleViewObject(
		larion.progate.model.ProGateJournalArticleView articleViewObject) {
		Object paramObj0 = ClpSerializer.translateInput(articleViewObject);

		if (articleViewObject == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.model.ProGateJournalArticleView");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("updateProGateArticleViewObject",
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

		return ((Boolean)returnObj).booleanValue();
	}

	public boolean deleteProGateArticleViewObject(
		larion.progate.model.ProGateJournalArticleView articleViewObject) {
		Object paramObj0 = ClpSerializer.translateInput(articleViewObject);

		if (articleViewObject == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.model.ProGateJournalArticleView");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("deleteProGateArticleViewObject",
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

		return ((Boolean)returnObj).booleanValue();
	}

	private ClassLoaderProxy _classLoaderProxy;
}