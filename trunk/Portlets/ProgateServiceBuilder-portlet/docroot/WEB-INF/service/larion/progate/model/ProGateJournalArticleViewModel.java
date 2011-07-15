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

package larion.progate.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;

/**
 * <a href="ProGateJournalArticleViewModel.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface ProGateJournalArticleViewModel extends BaseModel<ProGateJournalArticleView> {
	public Integer getPrimaryKey();

	public void setPrimaryKey(Integer pk);

	public Integer getJournalArticleId();

	public void setJournalArticleId(Integer journalArticleId);

	public String getOrgId();

	public void setOrgId(String orgId);

	public String getOrgName();

	public void setOrgName(String orgName);

	public int getArticleType();

	public void setArticleType(int articleType);

	public String getTitle();

	public void setTitle(String title);

	public String getResourceUrl();

	public void setResourceUrl(String resourceUrl);

	public String getDescription();

	public void setDescription(String description);

	public String getContent();

	public void setContent(String content);

	public int getPriority();

	public void setPriority(int priority);

	public String getSmallImageUrl();

	public void setSmallImageUrl(String smallImageUrl);

	public String getBigImageUrl();

	public void setBigImageUrl(String bigImageUrl);

	public int getCreatedBy();

	public void setCreatedBy(int createdBy);

	public Date getCreatedAt();

	public void setCreatedAt(Date createdAt);

	public int getUpdatedBy();

	public void setUpdatedBy(int updatedBy);

	public Date getUpdatedAt();

	public void setUpdatedAt(Date updatedAt);

	public double getDiscount();

	public void setDiscount(double discount);

	public double getPrice();

	public void setPrice(double price);

	public int getCurrencyId();

	public void setCurrencyId(int currencyId);

	public int getProductType();

	public void setProductType(int productType);

	public boolean getIsHot();

	public boolean isIsHot();

	public void setIsHot(boolean isHot);

	public boolean getIsService();

	public boolean isIsService();

	public void setIsService(boolean isService);

	public Date getExpiredDate();

	public void setExpiredDate(Date expiredDate);

	public int getAmount();

	public void setAmount(int amount);

	public String getCurrencyCode();

	public void setCurrencyCode(String currencyCode);

	public String getJournalArticleTypesName();

	public void setJournalArticleTypesName(String journalArticleTypesName);

	public int getProgateCategory();

	public void setProgateCategory(int progateCategory);

	public ProGateJournalArticleView toEscapedModel();
}