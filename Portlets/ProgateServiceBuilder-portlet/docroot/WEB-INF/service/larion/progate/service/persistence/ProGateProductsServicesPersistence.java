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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * <a href="ProGateProductsServicesPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface ProGateProductsServicesPersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.model.ProGateProductsServices proGateProductsServices);

	public void cacheResult(
		java.util.List<larion.progate.model.ProGateProductsServices> proGateProductsServiceses);

	public void clearCache();

	public larion.progate.model.ProGateProductsServices create(
		java.lang.Integer productsServicesId);

	public larion.progate.model.ProGateProductsServices remove(
		java.lang.Integer productsServicesId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException;

	public larion.progate.model.ProGateProductsServices remove(
		larion.progate.model.ProGateProductsServices proGateProductsServices)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateProductsServices update(
		larion.progate.model.ProGateProductsServices proGateProductsServices)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateProductsServices update(
		larion.progate.model.ProGateProductsServices proGateProductsServices,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateProductsServices updateImpl(
		larion.progate.model.ProGateProductsServices proGateProductsServices,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateProductsServices findByPrimaryKey(
		java.lang.Integer productsServicesId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException;

	public larion.progate.model.ProGateProductsServices fetchByPrimaryKey(
		java.lang.Integer productsServicesId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateProductsServices> findByarticleId(
		int articleId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateProductsServices> findByarticleId(
		int articleId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateProductsServices> findByarticleId(
		int articleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateProductsServices findByarticleId_First(
		int articleId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException;

	public larion.progate.model.ProGateProductsServices findByarticleId_Last(
		int articleId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException;

	public larion.progate.model.ProGateProductsServices[] findByarticleId_PrevAndNext(
		java.lang.Integer productsServicesId, int articleId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException;

	public java.util.List<larion.progate.model.ProGateProductsServices> findByprogateCategory(
		int progateCategory) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateProductsServices> findByprogateCategory(
		int progateCategory, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateProductsServices> findByprogateCategory(
		int progateCategory, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateProductsServices findByprogateCategory_First(
		int progateCategory,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException;

	public larion.progate.model.ProGateProductsServices findByprogateCategory_Last(
		int progateCategory,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException;

	public larion.progate.model.ProGateProductsServices[] findByprogateCategory_PrevAndNext(
		java.lang.Integer productsServicesId, int progateCategory,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException;

	public java.util.List<larion.progate.model.ProGateProductsServices> findByorgId(
		int orgId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateProductsServices> findByorgId(
		int orgId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateProductsServices> findByorgId(
		int orgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateProductsServices findByorgId_First(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException;

	public larion.progate.model.ProGateProductsServices findByorgId_Last(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException;

	public larion.progate.model.ProGateProductsServices[] findByorgId_PrevAndNext(
		java.lang.Integer productsServicesId, int orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException;

	public java.util.List<larion.progate.model.ProGateProductsServices> findBydiscountEqual(
		double discount) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateProductsServices> findBydiscountEqual(
		double discount, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateProductsServices> findBydiscountEqual(
		double discount, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateProductsServices findBydiscountEqual_First(
		double discount, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException;

	public larion.progate.model.ProGateProductsServices findBydiscountEqual_Last(
		double discount, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException;

	public larion.progate.model.ProGateProductsServices[] findBydiscountEqual_PrevAndNext(
		java.lang.Integer productsServicesId, double discount,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException;

	public java.util.List<larion.progate.model.ProGateProductsServices> findBydiscountGreater(
		double discount) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateProductsServices> findBydiscountGreater(
		double discount, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateProductsServices> findBydiscountGreater(
		double discount, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateProductsServices findBydiscountGreater_First(
		double discount, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException;

	public larion.progate.model.ProGateProductsServices findBydiscountGreater_Last(
		double discount, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException;

	public larion.progate.model.ProGateProductsServices[] findBydiscountGreater_PrevAndNext(
		java.lang.Integer productsServicesId, double discount,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException;

	public java.util.List<larion.progate.model.ProGateProductsServices> findBydiscountLower(
		double discount) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateProductsServices> findBydiscountLower(
		double discount, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateProductsServices> findBydiscountLower(
		double discount, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateProductsServices findBydiscountLower_First(
		double discount, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException;

	public larion.progate.model.ProGateProductsServices findBydiscountLower_Last(
		double discount, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException;

	public larion.progate.model.ProGateProductsServices[] findBydiscountLower_PrevAndNext(
		java.lang.Integer productsServicesId, double discount,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException;

	public java.util.List<larion.progate.model.ProGateProductsServices> findBypriceEqual(
		double price) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateProductsServices> findBypriceEqual(
		double price, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateProductsServices> findBypriceEqual(
		double price, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateProductsServices findBypriceEqual_First(
		double price, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException;

	public larion.progate.model.ProGateProductsServices findBypriceEqual_Last(
		double price, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException;

	public larion.progate.model.ProGateProductsServices[] findBypriceEqual_PrevAndNext(
		java.lang.Integer productsServicesId, double price,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException;

	public java.util.List<larion.progate.model.ProGateProductsServices> findBypriceGreater(
		double price) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateProductsServices> findBypriceGreater(
		double price, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateProductsServices> findBypriceGreater(
		double price, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateProductsServices findBypriceGreater_First(
		double price, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException;

	public larion.progate.model.ProGateProductsServices findBypriceGreater_Last(
		double price, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException;

	public larion.progate.model.ProGateProductsServices[] findBypriceGreater_PrevAndNext(
		java.lang.Integer productsServicesId, double price,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException;

	public java.util.List<larion.progate.model.ProGateProductsServices> findBypriceLower(
		double price) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateProductsServices> findBypriceLower(
		double price, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateProductsServices> findBypriceLower(
		double price, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateProductsServices findBypriceLower_First(
		double price, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException;

	public larion.progate.model.ProGateProductsServices findBypriceLower_Last(
		double price, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException;

	public larion.progate.model.ProGateProductsServices[] findBypriceLower_PrevAndNext(
		java.lang.Integer productsServicesId, double price,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException;

	public java.util.List<larion.progate.model.ProGateProductsServices> findByproductType(
		int productType) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateProductsServices> findByproductType(
		int productType, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateProductsServices> findByproductType(
		int productType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateProductsServices findByproductType_First(
		int productType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException;

	public larion.progate.model.ProGateProductsServices findByproductType_Last(
		int productType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException;

	public larion.progate.model.ProGateProductsServices[] findByproductType_PrevAndNext(
		java.lang.Integer productsServicesId, int productType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException;

	public java.util.List<larion.progate.model.ProGateProductsServices> findByisService(
		boolean isService) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateProductsServices> findByisService(
		boolean isService, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateProductsServices> findByisService(
		boolean isService, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateProductsServices findByisService_First(
		boolean isService, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException;

	public larion.progate.model.ProGateProductsServices findByisService_Last(
		boolean isService, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException;

	public larion.progate.model.ProGateProductsServices[] findByisService_PrevAndNext(
		java.lang.Integer productsServicesId, boolean isService,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException;

	public java.util.List<larion.progate.model.ProGateProductsServices> findByisHot(
		boolean isHot) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateProductsServices> findByisHot(
		boolean isHot, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateProductsServices> findByisHot(
		boolean isHot, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateProductsServices findByisHot_First(
		boolean isHot, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException;

	public larion.progate.model.ProGateProductsServices findByisHot_Last(
		boolean isHot, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException;

	public larion.progate.model.ProGateProductsServices[] findByisHot_PrevAndNext(
		java.lang.Integer productsServicesId, boolean isHot,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateProductsServices> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateProductsServices> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateProductsServices> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByarticleId(int articleId)
		throws com.liferay.portal.SystemException;

	public void removeByprogateCategory(int progateCategory)
		throws com.liferay.portal.SystemException;

	public void removeByorgId(int orgId)
		throws com.liferay.portal.SystemException;

	public void removeBydiscountEqual(double discount)
		throws com.liferay.portal.SystemException;

	public void removeBydiscountGreater(double discount)
		throws com.liferay.portal.SystemException;

	public void removeBydiscountLower(double discount)
		throws com.liferay.portal.SystemException;

	public void removeBypriceEqual(double price)
		throws com.liferay.portal.SystemException;

	public void removeBypriceGreater(double price)
		throws com.liferay.portal.SystemException;

	public void removeBypriceLower(double price)
		throws com.liferay.portal.SystemException;

	public void removeByproductType(int productType)
		throws com.liferay.portal.SystemException;

	public void removeByisService(boolean isService)
		throws com.liferay.portal.SystemException;

	public void removeByisHot(boolean isHot)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByarticleId(int articleId)
		throws com.liferay.portal.SystemException;

	public int countByprogateCategory(int progateCategory)
		throws com.liferay.portal.SystemException;

	public int countByorgId(int orgId)
		throws com.liferay.portal.SystemException;

	public int countBydiscountEqual(double discount)
		throws com.liferay.portal.SystemException;

	public int countBydiscountGreater(double discount)
		throws com.liferay.portal.SystemException;

	public int countBydiscountLower(double discount)
		throws com.liferay.portal.SystemException;

	public int countBypriceEqual(double price)
		throws com.liferay.portal.SystemException;

	public int countBypriceGreater(double price)
		throws com.liferay.portal.SystemException;

	public int countBypriceLower(double price)
		throws com.liferay.portal.SystemException;

	public int countByproductType(int productType)
		throws com.liferay.portal.SystemException;

	public int countByisService(boolean isService)
		throws com.liferay.portal.SystemException;

	public int countByisHot(boolean isHot)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;
}