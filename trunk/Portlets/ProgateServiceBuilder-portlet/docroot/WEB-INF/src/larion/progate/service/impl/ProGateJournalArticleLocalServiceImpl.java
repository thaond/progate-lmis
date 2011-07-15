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

import java.util.*;
import java.util.regex.Pattern;

import org.apache.commons.collections.ListUtils;

import larion.progate.model.ProGateJournalArticle;
import larion.progate.model.ProGateJournalArticleTypes;
import larion.progate.model.ProGateProductsServices;
import larion.progate.model.impl.ProGateJournalArticleImpl;
import larion.progate.service.ProGateJournalArticleLocalServiceUtil;
import larion.progate.service.ProGateJournalArticleTypesLocalServiceUtil;
import larion.progate.service.base.ProGateJournalArticleLocalServiceBaseImpl;
import larion.progate.service.persistence.ProGateJournalArticlePrioritiesUtil;
import larion.progate.service.persistence.ProGateJournalArticleTypesUtil;
import larion.progate.service.persistence.ProGateJournalArticleUtil;
import larion.progate.service.persistence.ProGateProductsServicesUtil;
import larion.progate.service.utils.JournalArticleTypesUtils;

/**
 * <a href="ProGateJournalArticleLocalServiceImpl.java.html"><b><i>View
 * Source</i></b></a>
 * 
 * @author Brian Wing Shun Chan
 * 
 */
public class ProGateJournalArticleLocalServiceImpl extends
		ProGateJournalArticleLocalServiceBaseImpl {

	public ProGateJournalArticle createNewProduct(String orgId, int userId,
			String productName, String titleUrl, String ArticleType,
			String description, double originalPrice, int currencyId,
			int productType, double promoteValue, boolean isBestSelling,
			boolean isHot, String content, String smallImagePath,
			String bigImagePath, int amount, Date expiredDate) {
		try {
			ProGateJournalArticle newArticle = ProGateJournalArticleUtil
					.create(null);
			if (orgId != null && orgId != "") {
				newArticle.setOrgId(orgId);
			} else {
				newArticle.setOrgId("0");
			}

			newArticle.setResourceUrl(titleUrl);
			newArticle.setTitle(productName);
			newArticle.setDescription(description);
			newArticle.setContent(content);
			newArticle.setPriority(ProGateJournalArticlePrioritiesUtil
					.findByname("Normal").get(0).getPrimaryKey());
			newArticle.setSmallImageUrl(smallImagePath);
			newArticle.setBigImageUrl(bigImagePath);
			newArticle.setCreatedBy(userId);
			newArticle.setCreatedAt(new Date());
			newArticle.setUpdatedBy(userId);
			newArticle.setUpdatedAt(new Date());
			newArticle.setArticleType(JournalArticleTypesUtils
					.getJournalArticleTypesIdByName(ArticleType));
			ProGateJournalArticleUtil.update(newArticle, false);
			int ArticleId = newArticle.getPrimaryKey();
			ProGateProductsServices product = ProGateProductsServicesUtil
					.create(null);
			product.setArticleId(ArticleId);
			if (orgId != null && orgId != "") {
				product.setOrgId(Integer.valueOf(orgId));
			}
			product.setPrice(originalPrice);
			product.setDiscount(promoteValue);
			product.setCurrencyId(currencyId);
			product.setProductType(productType);
			product.setIsHot(isHot);
			product.setIsService(false);
			product.setAmount(amount);
			product.setExpiredDate(expiredDate);
			ProGateProductsServicesUtil.update(product, false);

			return newArticle;
		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("Errors in ProGateJournalArticleLocalServiceImpl.createNewProduct "
							+ e.toString());
			return null;
		}

	}

	public ProGateJournalArticle createNewArticle(String orgId, int userId,
			String articleName, String ArticleType, String description,
			String content, String smallImagePath, String resourceUrl,
			String addInfo) {
		try {

			ProGateJournalArticle newArticle = ProGateJournalArticleUtil
					.create(null);
			if (orgId != null && orgId != "") {
				newArticle.setOrgId(orgId);
			} else {
				newArticle.setOrgId("0");
			}
			newArticle.setTitle(articleName);
			newArticle.setResourceUrl(null);
			newArticle.setDescription(description);
			newArticle.setContent(content);
			newArticle.setPriority(ProGateJournalArticlePrioritiesUtil
					.findByname("Normal").get(0).getPrimaryKey());
			newArticle.setSmallImageUrl(smallImagePath);
			newArticle.setResourceUrl(resourceUrl);
			newArticle.setCreatedBy(userId);
			newArticle.setCreatedAt(new Date());
			newArticle.setUpdatedBy(userId);
			newArticle.setUpdatedAt(new Date());
			newArticle.setAddInfo(addInfo);
			newArticle.setArticleType(JournalArticleTypesUtils
					.getJournalArticleTypesIdByName(ArticleType));
			ProGateJournalArticleUtil.update(newArticle, false);
			return newArticle;

		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("Errors in ProGateJournalArticleLocalServiceImpl.createNewArticle "
							+ e.toString());
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	public ProGateJournalArticle updateProGateJournalArticleSupportFAQ(
			ProGateJournalArticle object, int newOrder) {
		try {
			String descString = object.getDescription();
			String contentString = object.getContent();
			int oldOrder = object.getArticleOrder();
			int articleType = ProGateJournalArticleTypesLocalServiceUtil
					.getProGateJournalArticleTypes(object.getArticleType())
					.getPrimaryKey();
			int maxOrder = ProGateJournalArticleLocalServiceUtil
					.countArticleByType(
							Integer.parseInt(object.getOrgId()),
							ProGateJournalArticleTypesLocalServiceUtil
									.getProGateJournalArticleTypes(
											object.getArticleType()).getName(),
							"");
			String orgId = object.getOrgId();
			List<ProGateJournalArticle> listUpdate = null;
			List<ProGateJournalArticle> listTemp = new ArrayList<ProGateJournalArticle>();
			int articleId = object.getPrimaryKey();
			ProGateJournalArticle newObject = ProGateJournalArticleUtil
					.findByPrimaryKey(articleId);
			listTemp.add(newObject);
			if (oldOrder != newOrder) {

				if (newOrder > maxOrder) {
					newObject.setArticleOrder(maxOrder);
					newOrder = maxOrder;
					listUpdate = ListUtils
							.subtract(
									ListUtils
											.intersection(
													ProGateJournalArticleUtil
															.findByarticleOrderGreater(oldOrder),
													ListUtils.intersection(
															ProGateJournalArticleUtil
																	.findByorgId(orgId),
															ProGateJournalArticleUtil
																	.findByarticleTypeEquals(articleType))),
									listTemp);
					for (ProGateJournalArticle proGateJournalArticle : listUpdate) {
						proGateJournalArticle
								.setArticleOrder(proGateJournalArticle
										.getArticleOrder() - 1);
						ProGateJournalArticleUtil.update(proGateJournalArticle,
								false);
					}
				} else if (newOrder >= oldOrder) {
					newObject.setArticleOrder(newOrder);
					listUpdate = ListUtils
							.subtract(
									ListUtils
											.intersection(
													ListUtils
															.intersection(
																	ProGateJournalArticleUtil
																			.findByarticleOrderGreater(oldOrder),
																	ProGateJournalArticleUtil
																			.findByarticleOrderLower(newOrder)),
													ListUtils.intersection(
															ProGateJournalArticleUtil
																	.findByorgId(orgId),
															ProGateJournalArticleUtil
																	.findByarticleTypeEquals(articleType))),
									listTemp);
					for (ProGateJournalArticle proGateJournalArticle : listUpdate) {
						proGateJournalArticle
								.setArticleOrder(proGateJournalArticle
										.getArticleOrder() - 1);
						ProGateJournalArticleUtil.update(proGateJournalArticle,
								false);
					}
				} else {
					newObject.setArticleOrder(newOrder);
					listUpdate = ListUtils
							.subtract(
									ListUtils
											.intersection(
													ListUtils
															.intersection(
																	ProGateJournalArticleUtil
																			.findByarticleOrderLower(oldOrder),
																	ProGateJournalArticleUtil
																			.findByarticleOrderGreater(newOrder)),
													ListUtils.intersection(
															ProGateJournalArticleUtil
																	.findByorgId(orgId),
															ProGateJournalArticleUtil
																	.findByarticleTypeEquals(articleType))),
									listTemp);
					for (ProGateJournalArticle proGateJournalArticle : listUpdate) {
						proGateJournalArticle
								.setArticleOrder(proGateJournalArticle
										.getArticleOrder() + 1);
						ProGateJournalArticleUtil.update(proGateJournalArticle,
								false);
					}

				}
			}
			
			newObject.setAddInfo(object.getAddInfo());
			newObject.setTitle(object.getTitle());
			newObject.setContent(contentString);
			newObject.setDescription(descString);
			newObject.setUpdatedAt(new Date());
			newObject.setUpdatedBy(object.getUpdatedBy());
			ProGateJournalArticleUtil.update(newObject, false);

			return object;
		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("Errors in ProGateJournalArticleLocalServiceImpl.updateProGateJournalArticleSupportFAQ: "
							+ e.toString());
			return null;
		}
	}

	public ProGateJournalArticle createNewArticleObject(String orgId,
			int userId, String articleName, String ArticleType,
			String description, String content, String smallImagePath,
			String resourceUrl, String addInfo) {
		try {
			ProGateJournalArticle newArticle = ProGateJournalArticleUtil
					.create(null);
			if (orgId != null && orgId != "") {
				newArticle.setOrgId(orgId);
			} else {
				newArticle.setOrgId("0");
			}
			newArticle.setTitle(articleName);
			newArticle.setDescription(description);
			newArticle.setContent(content);
			newArticle.setPriority(ProGateJournalArticlePrioritiesUtil
					.findByname("Normal").get(0).getPrimaryKey());
			newArticle.setSmallImageUrl(smallImagePath);
			newArticle.setResourceUrl(resourceUrl);
			newArticle.setCreatedBy(userId);
			newArticle.setCreatedAt(new Date());
			newArticle.setUpdatedBy(userId);
			newArticle.setUpdatedAt(new Date());

			int articleTypeId = JournalArticleTypesUtils
					.getJournalArticleTypesIdByName(ArticleType);
			newArticle.setArticleType(articleTypeId);
			String articleOrder = "";
			if (addInfo.indexOf("articleOrder") != -1) {
				String[] splitString = Pattern.compile("!!!").split(addInfo);
				for (String string : splitString) {
					if (string.indexOf("articleOrder") != -1) {
						articleOrder = string.split("=")[1];
						break;
					}
				}
				if (articleOrder != "") {
					int valueOrder = Integer.parseInt(articleOrder);
					if (valueOrder > 0) {
						int count = 0;
						@SuppressWarnings("unchecked")
						List<ProGateJournalArticle> listResult = ListUtils
								.intersection(
										ProGateJournalArticleUtil
												.findByorgId(orgId),
										ProGateJournalArticleUtil
												.findByarticleTypeEquals(articleTypeId));
						if (listResult != null) {
							count = listResult.size();
						}

						if (count < valueOrder) {
							valueOrder = count + 1;
						}

						newArticle.setArticleOrder(valueOrder);

						@SuppressWarnings("unchecked")
						List<ProGateJournalArticle> listArticle = ListUtils
								.intersection(ProGateJournalArticleUtil
										.findByarticleOrderGreater(valueOrder),
										ProGateJournalArticleUtil
												.findByorgId(orgId));

						for (ProGateJournalArticle proGateJournalArticle : listArticle) {
							proGateJournalArticle
									.setArticleOrder(proGateJournalArticle
											.getArticleOrder() + 1);
							ProGateJournalArticleUtil.update(
									proGateJournalArticle, false);
						}
					}
				}
				newArticle.setAddInfo(addInfo);
			} else {
				newArticle.setAddInfo(addInfo);
			}

			ProGateJournalArticleUtil.update(newArticle, false);
			return newArticle;

		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("Errors in ProGateJournalArticleLocalServiceImpl.createNewArticle "
							+ e.toString());
			return null;
		}

	}

	public ProGateJournalArticle createNews(String orgId, int userId,
			String articleName, String ArticleType, String description,
			String content, String smallImagePath, String resourceUrl,
			boolean isHot, String addInfo) {
		ProGateJournalArticle newArticle = null;
		try {

			newArticle = ProGateJournalArticleUtil.create(null);
			if (orgId != null && orgId != "") {
				newArticle.setOrgId(orgId);
			} else {
				newArticle.setOrgId("0");
			}
			newArticle.setTitle(articleName);
			newArticle.setResourceUrl(null);
			newArticle.setDescription(description);
			newArticle.setContent(content);
			if (isHot) {
				newArticle.setPriority(ProGateJournalArticlePrioritiesUtil
						.findByname("Important").get(0).getPrimaryKey());
			} else {
				newArticle.setPriority(ProGateJournalArticlePrioritiesUtil
						.findByname("Normal").get(0).getPrimaryKey());
			}

			newArticle.setSmallImageUrl(smallImagePath);
			newArticle.setResourceUrl(resourceUrl);
			newArticle.setCreatedBy(userId);
			newArticle.setCreatedAt(new Date());
			newArticle.setUpdatedBy(userId);
			newArticle.setUpdatedAt(new Date());
			newArticle.setAddInfo(addInfo);
			newArticle.setArticleType(JournalArticleTypesUtils
					.getJournalArticleTypesIdByName(ArticleType));
			ProGateJournalArticleUtil.update(newArticle, false);

		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("Errors in ProGateJournalArticleLocalServiceImpl.createNews "
							+ e.toString());
			return null;
		}
		return newArticle;
	}

	public List<ProGateJournalArticle> getListProGateArticles(int orgId,
			String articleType, String addInfo, int start, int end) {
		return JournalArticleTypesUtils.getListArticleByType(orgId,
				articleType, addInfo, start, end);
	}

	public List<ProGateJournalArticle> getListBlogArticles(long userId,
			String addInfo, int start, int end) {
		return JournalArticleTypesUtils.getListBlogArticles((int) userId,
				addInfo, start, end);
	}

	public List<ProGateJournalArticle> getListProGateArticlesByPrority(
			int orgId, String articleType, boolean isHot, String addInfo,
			int start, int end) {
		return JournalArticleTypesUtils.getListArticleByTypeAndPriority(orgId,
				articleType, isHot, addInfo, start, end);
	}

	public List<ProGateJournalArticle> getListCertArticles(int orgId,
			String addInfo, int start, int end) {
		return JournalArticleTypesUtils.getListCertArticles(orgId, addInfo,
				start, end);
	}

	public List<ProGateJournalArticle> getListAchievementArticles(int orgId,
			String addInfo, int start, int end) {
		return JournalArticleTypesUtils.getListAchievementArticles(orgId,
				addInfo, start, end);
	}

	public int countArticleByType(int orgId, String articleType, String addInfo) {
		return JournalArticleTypesUtils.countArticleByType(orgId, articleType,
				addInfo);
	}

	public int countListBlogArticles(long userId, String addInfo) {
		try {
			List<ProGateJournalArticle> listData = JournalArticleTypesUtils
					.getListBlogArticles((int) userId, addInfo, 0,
							ProGateJournalArticleUtil.countAll());

			if (listData != null) {
				return listData.size();
			} else {
				return 0;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}

	}

	public int countListProGateArticlesByPrority(int orgId, String articleType,
			boolean isHot, String addInfo) {
		return JournalArticleTypesUtils.countListArticleByTypeAndPriority(
				orgId, articleType, isHot, addInfo);
	}

	public int countListCertArticles(int orgId, String addInfo) {
		return JournalArticleTypesUtils.countListCertArticles(orgId, addInfo);
	}

	public int countListAchievementArticles(int orgId, String addInfo) {
		return JournalArticleTypesUtils.countListAchievementArticles(orgId,
				addInfo);
	}

	public ProGateJournalArticle getProGateJournalArticle(int articleId) {
		try {
			return ProGateJournalArticleUtil.findByPrimaryKey(articleId);
		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("Errors in ProGateJournalArticleLocalServiceImpl.getProGateJournalArticle: "
							+ e.toString());
			return null;
		}
	}

	public ProGateJournalArticle createEmptyObject() {
		try {
			return ProGateJournalArticleUtil.create(null);
		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("Errors in ProGateJournalArticleLocalServiceImpl.createEmptyObject: "
							+ e.toString());
			return null;
		}
	}

	public void deleteProGateJournalArticleFAQ (int articleId) {
		
		try {
			ProGateJournalArticle object = ProGateJournalArticleUtil
					.findByPrimaryKey(articleId);
			if (object.getArticleType() == ProGateJournalArticleTypesUtil
					.findByname("Org_Support_FAQ").get(0).getPrimaryKey()) {
				List<ProGateJournalArticle> listObject = ProGateJournalArticleUtil
						.findByarticleOrderGreater(object.getArticleOrder());
				for (ProGateJournalArticle proGateJournalArticle : listObject) {
					proGateJournalArticle.setArticleOrder(proGateJournalArticle
							.getArticleOrder() - 1);
					ProGateJournalArticleUtil.update(proGateJournalArticle,
							false);
				}
			}
			ProGateJournalArticleUtil.remove(articleId);
		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("Errors in ProGateJournalArticleLocalServiceImpl.deleteProGateJournalArticle: "
							+ e.toString());
		}
	}

}
