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

/**
 * <a href="ProGateProductsServicesUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateProductsServicesUtil {
	public static void cacheResult(
		larion.progate.model.ProGateProductsServices proGateProductsServices) {
		getPersistence().cacheResult(proGateProductsServices);
	}

	public static void cacheResult(
		java.util.List<larion.progate.model.ProGateProductsServices> proGateProductsServiceses) {
		getPersistence().cacheResult(proGateProductsServiceses);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.model.ProGateProductsServices create(
		java.lang.Integer productsServicesId) {
		return getPersistence().create(productsServicesId);
	}

	public static larion.progate.model.ProGateProductsServices remove(
		java.lang.Integer productsServicesId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException {
		return getPersistence().remove(productsServicesId);
	}

	public static larion.progate.model.ProGateProductsServices remove(
		larion.progate.model.ProGateProductsServices proGateProductsServices)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(proGateProductsServices);
	}

	public static larion.progate.model.ProGateProductsServices update(
		larion.progate.model.ProGateProductsServices proGateProductsServices)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(proGateProductsServices);
	}

	public static larion.progate.model.ProGateProductsServices update(
		larion.progate.model.ProGateProductsServices proGateProductsServices,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(proGateProductsServices, merge);
	}

	public static larion.progate.model.ProGateProductsServices updateImpl(
		larion.progate.model.ProGateProductsServices proGateProductsServices,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(proGateProductsServices, merge);
	}

	public static larion.progate.model.ProGateProductsServices findByPrimaryKey(
		java.lang.Integer productsServicesId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException {
		return getPersistence().findByPrimaryKey(productsServicesId);
	}

	public static larion.progate.model.ProGateProductsServices fetchByPrimaryKey(
		java.lang.Integer productsServicesId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(productsServicesId);
	}

	public static java.util.List<larion.progate.model.ProGateProductsServices> findByarticleId(
		int articleId) throws com.liferay.portal.SystemException {
		return getPersistence().findByarticleId(articleId);
	}

	public static java.util.List<larion.progate.model.ProGateProductsServices> findByarticleId(
		int articleId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByarticleId(articleId, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateProductsServices> findByarticleId(
		int articleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByarticleId(articleId, start, end, obc);
	}

	public static larion.progate.model.ProGateProductsServices findByarticleId_First(
		int articleId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException {
		return getPersistence().findByarticleId_First(articleId, obc);
	}

	public static larion.progate.model.ProGateProductsServices findByarticleId_Last(
		int articleId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException {
		return getPersistence().findByarticleId_Last(articleId, obc);
	}

	public static larion.progate.model.ProGateProductsServices[] findByarticleId_PrevAndNext(
		java.lang.Integer productsServicesId, int articleId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException {
		return getPersistence()
				   .findByarticleId_PrevAndNext(productsServicesId, articleId,
			obc);
	}

	public static java.util.List<larion.progate.model.ProGateProductsServices> findByprogateCategory(
		int progateCategory) throws com.liferay.portal.SystemException {
		return getPersistence().findByprogateCategory(progateCategory);
	}

	public static java.util.List<larion.progate.model.ProGateProductsServices> findByprogateCategory(
		int progateCategory, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByprogateCategory(progateCategory, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateProductsServices> findByprogateCategory(
		int progateCategory, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByprogateCategory(progateCategory, start, end, obc);
	}

	public static larion.progate.model.ProGateProductsServices findByprogateCategory_First(
		int progateCategory,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException {
		return getPersistence().findByprogateCategory_First(progateCategory, obc);
	}

	public static larion.progate.model.ProGateProductsServices findByprogateCategory_Last(
		int progateCategory,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException {
		return getPersistence().findByprogateCategory_Last(progateCategory, obc);
	}

	public static larion.progate.model.ProGateProductsServices[] findByprogateCategory_PrevAndNext(
		java.lang.Integer productsServicesId, int progateCategory,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException {
		return getPersistence()
				   .findByprogateCategory_PrevAndNext(productsServicesId,
			progateCategory, obc);
	}

	public static java.util.List<larion.progate.model.ProGateProductsServices> findByorgId(
		int orgId) throws com.liferay.portal.SystemException {
		return getPersistence().findByorgId(orgId);
	}

	public static java.util.List<larion.progate.model.ProGateProductsServices> findByorgId(
		int orgId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByorgId(orgId, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateProductsServices> findByorgId(
		int orgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByorgId(orgId, start, end, obc);
	}

	public static larion.progate.model.ProGateProductsServices findByorgId_First(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException {
		return getPersistence().findByorgId_First(orgId, obc);
	}

	public static larion.progate.model.ProGateProductsServices findByorgId_Last(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException {
		return getPersistence().findByorgId_Last(orgId, obc);
	}

	public static larion.progate.model.ProGateProductsServices[] findByorgId_PrevAndNext(
		java.lang.Integer productsServicesId, int orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException {
		return getPersistence()
				   .findByorgId_PrevAndNext(productsServicesId, orgId, obc);
	}

	public static java.util.List<larion.progate.model.ProGateProductsServices> findBydiscountEqual(
		double discount) throws com.liferay.portal.SystemException {
		return getPersistence().findBydiscountEqual(discount);
	}

	public static java.util.List<larion.progate.model.ProGateProductsServices> findBydiscountEqual(
		double discount, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBydiscountEqual(discount, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateProductsServices> findBydiscountEqual(
		double discount, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBydiscountEqual(discount, start, end, obc);
	}

	public static larion.progate.model.ProGateProductsServices findBydiscountEqual_First(
		double discount, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException {
		return getPersistence().findBydiscountEqual_First(discount, obc);
	}

	public static larion.progate.model.ProGateProductsServices findBydiscountEqual_Last(
		double discount, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException {
		return getPersistence().findBydiscountEqual_Last(discount, obc);
	}

	public static larion.progate.model.ProGateProductsServices[] findBydiscountEqual_PrevAndNext(
		java.lang.Integer productsServicesId, double discount,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException {
		return getPersistence()
				   .findBydiscountEqual_PrevAndNext(productsServicesId,
			discount, obc);
	}

	public static java.util.List<larion.progate.model.ProGateProductsServices> findBydiscountGreater(
		double discount) throws com.liferay.portal.SystemException {
		return getPersistence().findBydiscountGreater(discount);
	}

	public static java.util.List<larion.progate.model.ProGateProductsServices> findBydiscountGreater(
		double discount, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBydiscountGreater(discount, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateProductsServices> findBydiscountGreater(
		double discount, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBydiscountGreater(discount, start, end, obc);
	}

	public static larion.progate.model.ProGateProductsServices findBydiscountGreater_First(
		double discount, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException {
		return getPersistence().findBydiscountGreater_First(discount, obc);
	}

	public static larion.progate.model.ProGateProductsServices findBydiscountGreater_Last(
		double discount, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException {
		return getPersistence().findBydiscountGreater_Last(discount, obc);
	}

	public static larion.progate.model.ProGateProductsServices[] findBydiscountGreater_PrevAndNext(
		java.lang.Integer productsServicesId, double discount,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException {
		return getPersistence()
				   .findBydiscountGreater_PrevAndNext(productsServicesId,
			discount, obc);
	}

	public static java.util.List<larion.progate.model.ProGateProductsServices> findBydiscountLower(
		double discount) throws com.liferay.portal.SystemException {
		return getPersistence().findBydiscountLower(discount);
	}

	public static java.util.List<larion.progate.model.ProGateProductsServices> findBydiscountLower(
		double discount, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBydiscountLower(discount, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateProductsServices> findBydiscountLower(
		double discount, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBydiscountLower(discount, start, end, obc);
	}

	public static larion.progate.model.ProGateProductsServices findBydiscountLower_First(
		double discount, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException {
		return getPersistence().findBydiscountLower_First(discount, obc);
	}

	public static larion.progate.model.ProGateProductsServices findBydiscountLower_Last(
		double discount, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException {
		return getPersistence().findBydiscountLower_Last(discount, obc);
	}

	public static larion.progate.model.ProGateProductsServices[] findBydiscountLower_PrevAndNext(
		java.lang.Integer productsServicesId, double discount,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException {
		return getPersistence()
				   .findBydiscountLower_PrevAndNext(productsServicesId,
			discount, obc);
	}

	public static java.util.List<larion.progate.model.ProGateProductsServices> findBypriceEqual(
		double price) throws com.liferay.portal.SystemException {
		return getPersistence().findBypriceEqual(price);
	}

	public static java.util.List<larion.progate.model.ProGateProductsServices> findBypriceEqual(
		double price, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBypriceEqual(price, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateProductsServices> findBypriceEqual(
		double price, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBypriceEqual(price, start, end, obc);
	}

	public static larion.progate.model.ProGateProductsServices findBypriceEqual_First(
		double price, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException {
		return getPersistence().findBypriceEqual_First(price, obc);
	}

	public static larion.progate.model.ProGateProductsServices findBypriceEqual_Last(
		double price, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException {
		return getPersistence().findBypriceEqual_Last(price, obc);
	}

	public static larion.progate.model.ProGateProductsServices[] findBypriceEqual_PrevAndNext(
		java.lang.Integer productsServicesId, double price,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException {
		return getPersistence()
				   .findBypriceEqual_PrevAndNext(productsServicesId, price, obc);
	}

	public static java.util.List<larion.progate.model.ProGateProductsServices> findBypriceGreater(
		double price) throws com.liferay.portal.SystemException {
		return getPersistence().findBypriceGreater(price);
	}

	public static java.util.List<larion.progate.model.ProGateProductsServices> findBypriceGreater(
		double price, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBypriceGreater(price, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateProductsServices> findBypriceGreater(
		double price, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBypriceGreater(price, start, end, obc);
	}

	public static larion.progate.model.ProGateProductsServices findBypriceGreater_First(
		double price, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException {
		return getPersistence().findBypriceGreater_First(price, obc);
	}

	public static larion.progate.model.ProGateProductsServices findBypriceGreater_Last(
		double price, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException {
		return getPersistence().findBypriceGreater_Last(price, obc);
	}

	public static larion.progate.model.ProGateProductsServices[] findBypriceGreater_PrevAndNext(
		java.lang.Integer productsServicesId, double price,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException {
		return getPersistence()
				   .findBypriceGreater_PrevAndNext(productsServicesId, price,
			obc);
	}

	public static java.util.List<larion.progate.model.ProGateProductsServices> findBypriceLower(
		double price) throws com.liferay.portal.SystemException {
		return getPersistence().findBypriceLower(price);
	}

	public static java.util.List<larion.progate.model.ProGateProductsServices> findBypriceLower(
		double price, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBypriceLower(price, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateProductsServices> findBypriceLower(
		double price, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBypriceLower(price, start, end, obc);
	}

	public static larion.progate.model.ProGateProductsServices findBypriceLower_First(
		double price, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException {
		return getPersistence().findBypriceLower_First(price, obc);
	}

	public static larion.progate.model.ProGateProductsServices findBypriceLower_Last(
		double price, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException {
		return getPersistence().findBypriceLower_Last(price, obc);
	}

	public static larion.progate.model.ProGateProductsServices[] findBypriceLower_PrevAndNext(
		java.lang.Integer productsServicesId, double price,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException {
		return getPersistence()
				   .findBypriceLower_PrevAndNext(productsServicesId, price, obc);
	}

	public static java.util.List<larion.progate.model.ProGateProductsServices> findByproductType(
		int productType) throws com.liferay.portal.SystemException {
		return getPersistence().findByproductType(productType);
	}

	public static java.util.List<larion.progate.model.ProGateProductsServices> findByproductType(
		int productType, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByproductType(productType, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateProductsServices> findByproductType(
		int productType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByproductType(productType, start, end, obc);
	}

	public static larion.progate.model.ProGateProductsServices findByproductType_First(
		int productType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException {
		return getPersistence().findByproductType_First(productType, obc);
	}

	public static larion.progate.model.ProGateProductsServices findByproductType_Last(
		int productType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException {
		return getPersistence().findByproductType_Last(productType, obc);
	}

	public static larion.progate.model.ProGateProductsServices[] findByproductType_PrevAndNext(
		java.lang.Integer productsServicesId, int productType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException {
		return getPersistence()
				   .findByproductType_PrevAndNext(productsServicesId,
			productType, obc);
	}

	public static java.util.List<larion.progate.model.ProGateProductsServices> findByisService(
		boolean isService) throws com.liferay.portal.SystemException {
		return getPersistence().findByisService(isService);
	}

	public static java.util.List<larion.progate.model.ProGateProductsServices> findByisService(
		boolean isService, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByisService(isService, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateProductsServices> findByisService(
		boolean isService, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByisService(isService, start, end, obc);
	}

	public static larion.progate.model.ProGateProductsServices findByisService_First(
		boolean isService, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException {
		return getPersistence().findByisService_First(isService, obc);
	}

	public static larion.progate.model.ProGateProductsServices findByisService_Last(
		boolean isService, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException {
		return getPersistence().findByisService_Last(isService, obc);
	}

	public static larion.progate.model.ProGateProductsServices[] findByisService_PrevAndNext(
		java.lang.Integer productsServicesId, boolean isService,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException {
		return getPersistence()
				   .findByisService_PrevAndNext(productsServicesId, isService,
			obc);
	}

	public static java.util.List<larion.progate.model.ProGateProductsServices> findByisHot(
		boolean isHot) throws com.liferay.portal.SystemException {
		return getPersistence().findByisHot(isHot);
	}

	public static java.util.List<larion.progate.model.ProGateProductsServices> findByisHot(
		boolean isHot, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByisHot(isHot, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateProductsServices> findByisHot(
		boolean isHot, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByisHot(isHot, start, end, obc);
	}

	public static larion.progate.model.ProGateProductsServices findByisHot_First(
		boolean isHot, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException {
		return getPersistence().findByisHot_First(isHot, obc);
	}

	public static larion.progate.model.ProGateProductsServices findByisHot_Last(
		boolean isHot, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException {
		return getPersistence().findByisHot_Last(isHot, obc);
	}

	public static larion.progate.model.ProGateProductsServices[] findByisHot_PrevAndNext(
		java.lang.Integer productsServicesId, boolean isHot,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateProductsServicesException {
		return getPersistence()
				   .findByisHot_PrevAndNext(productsServicesId, isHot, obc);
	}

	public static java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	public static java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateProductsServices> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.model.ProGateProductsServices> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.model.ProGateProductsServices> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByarticleId(int articleId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByarticleId(articleId);
	}

	public static void removeByprogateCategory(int progateCategory)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByprogateCategory(progateCategory);
	}

	public static void removeByorgId(int orgId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByorgId(orgId);
	}

	public static void removeBydiscountEqual(double discount)
		throws com.liferay.portal.SystemException {
		getPersistence().removeBydiscountEqual(discount);
	}

	public static void removeBydiscountGreater(double discount)
		throws com.liferay.portal.SystemException {
		getPersistence().removeBydiscountGreater(discount);
	}

	public static void removeBydiscountLower(double discount)
		throws com.liferay.portal.SystemException {
		getPersistence().removeBydiscountLower(discount);
	}

	public static void removeBypriceEqual(double price)
		throws com.liferay.portal.SystemException {
		getPersistence().removeBypriceEqual(price);
	}

	public static void removeBypriceGreater(double price)
		throws com.liferay.portal.SystemException {
		getPersistence().removeBypriceGreater(price);
	}

	public static void removeBypriceLower(double price)
		throws com.liferay.portal.SystemException {
		getPersistence().removeBypriceLower(price);
	}

	public static void removeByproductType(int productType)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByproductType(productType);
	}

	public static void removeByisService(boolean isService)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByisService(isService);
	}

	public static void removeByisHot(boolean isHot)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByisHot(isHot);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByarticleId(int articleId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByarticleId(articleId);
	}

	public static int countByprogateCategory(int progateCategory)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByprogateCategory(progateCategory);
	}

	public static int countByorgId(int orgId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByorgId(orgId);
	}

	public static int countBydiscountEqual(double discount)
		throws com.liferay.portal.SystemException {
		return getPersistence().countBydiscountEqual(discount);
	}

	public static int countBydiscountGreater(double discount)
		throws com.liferay.portal.SystemException {
		return getPersistence().countBydiscountGreater(discount);
	}

	public static int countBydiscountLower(double discount)
		throws com.liferay.portal.SystemException {
		return getPersistence().countBydiscountLower(discount);
	}

	public static int countBypriceEqual(double price)
		throws com.liferay.portal.SystemException {
		return getPersistence().countBypriceEqual(price);
	}

	public static int countBypriceGreater(double price)
		throws com.liferay.portal.SystemException {
		return getPersistence().countBypriceGreater(price);
	}

	public static int countBypriceLower(double price)
		throws com.liferay.portal.SystemException {
		return getPersistence().countBypriceLower(price);
	}

	public static int countByproductType(int productType)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByproductType(productType);
	}

	public static int countByisService(boolean isService)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByisService(isService);
	}

	public static int countByisHot(boolean isHot)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByisHot(isHot);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static ProGateProductsServicesPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(ProGateProductsServicesPersistence persistence) {
		_persistence = persistence;
	}

	private static ProGateProductsServicesPersistence _persistence;
}