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

package larion.progate.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.ListUtils;

import larion.progate.model.ProGateJournalArticleView;
import larion.progate.model.ProGateJournalArticle;
import larion.progate.model.ProGateProductsServices;
import larion.progate.service.ProGateJournalArticleLocalServiceUtil;
import larion.progate.service.base.ProGateJournalArticleViewLocalServiceBaseImpl;
import larion.progate.service.persistence.ProGateJournalArticleViewUtil;
import larion.progate.service.persistence.ProGateJournalArticleUtil;
import larion.progate.service.persistence.ProGateProductsServicesUtil;

/**
 * <a href="ProGateJournalArticleViewLocalServiceImpl.java.html"><b><i>View
 * Source</i></b></a>
 * 
 * @author Brian Wing Shun Chan
 * 
 */
public class ProGateJournalArticleViewLocalServiceImpl extends
		ProGateJournalArticleViewLocalServiceBaseImpl {

	public List<ProGateJournalArticleView> getListArticleByOrgIdAndProductType(
			int orgId, int productType, String ArticleType,
			boolean isHotProduct, int start, int end)
			throws com.liferay.portal.SystemException {
		List<ProGateJournalArticleView> result = new ArrayList<ProGateJournalArticleView>();

		try {
			List<ProGateJournalArticleView> listArticleByOrgId = null;
			if (orgId == 0) {
				listArticleByOrgId = ProGateJournalArticleViewUtil.findAll();
			} else {
				listArticleByOrgId = ProGateJournalArticleViewUtil
						.findByorgId(Integer.toString(orgId));
			}

			List<ProGateJournalArticleView> listArticleByArtType = null;
			List<ProGateJournalArticleView> listArticleByProductType = null;

			if (productType == 0) {
				listArticleByProductType = ProGateJournalArticleViewUtil
						.findByproductTypeGreater(productType);
			} else {
				listArticleByProductType = ProGateJournalArticleViewUtil
						.findByproductTypeEquals(productType);
			}

			listArticleByArtType = ProGateJournalArticleViewUtil
					.findByjournalArticleTypesName(ArticleType);

			@SuppressWarnings("unchecked")
			List<ProGateJournalArticleView> listArticleresult = ListUtils
					.intersection(listArticleByProductType, ListUtils
							.intersection(listArticleByOrgId,
									listArticleByArtType));

			if (isHotProduct) {
				List<ProGateJournalArticleView> hotProductService = ProGateJournalArticleViewUtil
						.findByisHot(isHotProduct);

				@SuppressWarnings("unchecked")
				List<ProGateJournalArticleView> intersection = ListUtils
						.intersection(listArticleresult, hotProductService);
				if (end > intersection.size()) {
					result = intersection.subList(start, intersection.size());
				} else {
					result = intersection.subList(start, end);
				}
			} else {
				if (end > listArticleresult.size()) {
					result = listArticleresult.subList(start,
							listArticleresult.size());
				} else {
					result = listArticleresult.subList(start, end);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("Errors in ProGateJournalArticleViewLocalServiceImpl.getListArticleByOrgIdAndProductType: "
							+ e.toString());
		}
		return result;
	}

	public List<ProGateJournalArticleView> getListArticleByOrgIdAndProductType(
			int orgId, int productType, String ArticleType, int categoryType,
			boolean isHotProduct, int start, int end)
			throws com.liferay.portal.SystemException {
		List<ProGateJournalArticleView> result = new ArrayList<ProGateJournalArticleView>();

		try {
			List<ProGateJournalArticleView> listArticleByOrgId = null;
			if (orgId == 0) {
				listArticleByOrgId = ProGateJournalArticleViewUtil.findAll();
			} else {
				listArticleByOrgId = ProGateJournalArticleViewUtil
						.findByorgId(Integer.toString(orgId));
			}

			List<ProGateJournalArticleView> listArticleByArtType = null;
			List<ProGateJournalArticleView> listArticleByCatogeryType = null;
			List<ProGateJournalArticleView> listArticleByProductType = null;

			if (productType == 0) {
				listArticleByProductType = ProGateJournalArticleViewUtil
						.findByproductTypeGreater(productType);
			} else {
				listArticleByProductType = ProGateJournalArticleViewUtil
						.findByproductTypeEquals(productType);
			}

			listArticleByArtType = ProGateJournalArticleViewUtil
					.findByjournalArticleTypesName(ArticleType);

			listArticleByCatogeryType = ProGateJournalArticleViewUtil
					.findByprogateCategory(categoryType);

			@SuppressWarnings("unchecked")
			List<ProGateJournalArticleView> listArticleresult = ListUtils
					.intersection(listArticleByProductType, ListUtils
							.intersection(listArticleByOrgId, ListUtils
									.intersection(listArticleByCatogeryType,
											listArticleByArtType)));

			if (isHotProduct) {
				List<ProGateJournalArticleView> hotProductService = ProGateJournalArticleViewUtil
						.findByisHot(isHotProduct);

				@SuppressWarnings("unchecked")
				List<ProGateJournalArticleView> intersection = ListUtils
						.intersection(listArticleresult, hotProductService);
				if (end > intersection.size()) {
					result = intersection.subList(start, intersection.size());
				} else {
					result = intersection.subList(start, end);
				}
			} else {
				if (end > listArticleresult.size()) {
					result = listArticleresult.subList(start,
							listArticleresult.size());
				} else {
					result = listArticleresult.subList(start, end);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("Errors in ProGateJournalArticleViewLocalServiceImpl.getListArticleByOrgIdAndProductType: "
							+ e.toString());
		}
		return result;
	}

	public int countListArticleByOrgIdAndProductType(int orgId,
			int productType, String ArticleType, boolean isHotProduct)
			throws com.liferay.portal.SystemException {
		int result = 0;

		try {
			List<ProGateJournalArticleView> listArticleByOrgId = null;
			if (orgId == 0) {
				listArticleByOrgId = ProGateJournalArticleViewUtil.findAll();
			} else {
				listArticleByOrgId = ProGateJournalArticleViewUtil
						.findByorgId(Integer.toString(orgId));
			}

			List<ProGateJournalArticleView> listArticleByArtType = null;
			List<ProGateJournalArticleView> listArticleByProductType = null;

			if (productType == 0) {
				listArticleByProductType = ProGateJournalArticleViewUtil
						.findByproductTypeGreater(productType);
			} else {
				listArticleByProductType = ProGateJournalArticleViewUtil
						.findByproductTypeEquals(productType);
			}

			listArticleByArtType = ProGateJournalArticleViewUtil
					.findByjournalArticleTypesName(ArticleType);

			@SuppressWarnings("unchecked")
			List<ProGateJournalArticleView> listArticleresult = ListUtils
					.intersection(listArticleByProductType, ListUtils
							.intersection(listArticleByOrgId,
									listArticleByArtType));

			if (isHotProduct) {
				List<ProGateJournalArticleView> hotProductService = ProGateJournalArticleViewUtil
						.findByisHot(isHotProduct);

				@SuppressWarnings("unchecked")
				List<ProGateJournalArticleView> intersection = ListUtils
						.intersection(listArticleresult, hotProductService);
				if (intersection != null) {
					result = intersection.size();
				} else {
					result = 0;
				}
			} else {
				if (listArticleresult != null) {
					result = listArticleresult.size();
				} else {
					result = 0;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("Errors in ProGateJournalArticleViewLocalServiceImpl.countListArticleByOrgIdAndProductType: "
							+ e.toString());
		}
		return result;
	}

	public int countListArticleByOrgIdAndProductType(int orgId,
			int productType, String ArticleType, int categoryType,
			boolean isHotProduct) throws com.liferay.portal.SystemException {
		int result = 0;

		try {
			List<ProGateJournalArticleView> listArticleByOrgId = null;
			if (orgId == 0) {
				listArticleByOrgId = ProGateJournalArticleViewUtil.findAll();
			} else {
				listArticleByOrgId = ProGateJournalArticleViewUtil
						.findByorgId(Integer.toString(orgId));
			}

			List<ProGateJournalArticleView> listArticleByArtType = null;
			List<ProGateJournalArticleView> listArticleByCatogeryType = null;
			List<ProGateJournalArticleView> listArticleByProductType = null;

			if (productType == 0) {
				listArticleByProductType = ProGateJournalArticleViewUtil
						.findByproductTypeGreater(productType);
			} else {
				listArticleByProductType = ProGateJournalArticleViewUtil
						.findByproductTypeEquals(productType);
			}

			listArticleByArtType = ProGateJournalArticleViewUtil
					.findByjournalArticleTypesName(ArticleType);

			listArticleByCatogeryType = ProGateJournalArticleViewUtil
					.findByprogateCategory(categoryType);

			@SuppressWarnings("unchecked")
			List<ProGateJournalArticleView> listArticleresult = ListUtils
					.intersection(listArticleByProductType, ListUtils
							.intersection(listArticleByOrgId, ListUtils
									.intersection(listArticleByCatogeryType,
											listArticleByArtType)));

			if (isHotProduct) {
				List<ProGateJournalArticleView> hotProductService = ProGateJournalArticleViewUtil
						.findByisHot(isHotProduct);

				@SuppressWarnings("unchecked")
				List<ProGateJournalArticleView> intersection = ListUtils
						.intersection(listArticleresult, hotProductService);

				if (intersection != null) {
					result = intersection.size();
				} else {
					result = 0;
				}
			} else {
				if (listArticleresult != null) {
					result = listArticleresult.size();
				} else {
					result = 0;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("Errors in ProGateJournalArticleViewLocalServiceImpl.countListArticleByOrgIdAndProductType: "
							+ e.toString());
		}
		return result;
	}

	public boolean updateProGateArticleViewObject(
			ProGateJournalArticleView articleViewObject) {
		try {

			int articleId = articleViewObject.getPrimaryKey();

			// System.out.println("2 " + articleId);
			ProGateJournalArticle article = ProGateJournalArticleLocalServiceUtil
					.getProGateJournalArticle(articleId);

			article.setBigImageUrl(articleViewObject.getBigImageUrl());
			article.setContent(articleViewObject.getContent());
			article.setDescription(articleViewObject.getDescription());
			article.setSmallImageUrl(articleViewObject.getSmallImageUrl());
			article.setTitle(articleViewObject.getTitle());
			article.setResourceUrl(articleViewObject.getResourceUrl());
			article.setUpdatedAt(new Date());
			article.setUpdatedBy(articleViewObject.getUpdatedBy());

			ProGateJournalArticleUtil.update(article, false);

			List<ProGateProductsServices> products = ProGateProductsServicesUtil
					.findByarticleId(articleId);

			if ((products != null) && (products.size() > 0)) {
				ProGateProductsServices product = products.get(0);
				product.setCurrencyId(articleViewObject.getCurrencyId());
				product.setDiscount(articleViewObject.getDiscount());
				product.setIsHot(articleViewObject.getIsHot());
				product.setPrice(articleViewObject.getPrice());
				product.setProductType(articleViewObject.getProductType());
				product.setProgateCategory(articleViewObject
						.getProgateCategory());
				product.setAmount(articleViewObject.getAmount());
				product.setExpiredDate(articleViewObject.getExpiredDate());
				ProGateProductsServicesUtil.update(product, false);
			}

			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("Errors in ProGateJournalArticleViewLocalServiceImpl.updateProGatearticleViewObject "
							+ e.toString());
			return false;
		}

	}

	public boolean deleteProGateArticleViewObject(
			ProGateJournalArticleView articleViewObject) {
		try {

			int articleId = articleViewObject.getPrimaryKey();

			List<ProGateProductsServices> products = ProGateProductsServicesUtil
					.findByarticleId(articleId);

			for (ProGateProductsServices proGateProductsServices : products) {
				ProGateProductsServicesUtil.remove(proGateProductsServices);
			}
			ProGateJournalArticleUtil.remove(articleId);

			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("Errors in ProGateJournalArticleViewLocalServiceImpl.deleteProGatearticleViewObject "
							+ e.toString());
			return false;
		}

	}

}
