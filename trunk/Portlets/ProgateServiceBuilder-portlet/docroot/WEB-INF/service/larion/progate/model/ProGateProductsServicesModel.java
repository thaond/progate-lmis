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
 * <a href="ProGateProductsServicesModel.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface ProGateProductsServicesModel extends BaseModel<ProGateProductsServices> {
	public Integer getPrimaryKey();

	public void setPrimaryKey(Integer pk);

	public Integer getProductsServicesId();

	public void setProductsServicesId(Integer productsServicesId);

	public int getArticleId();

	public void setArticleId(int articleId);

	public int getOrgId();

	public void setOrgId(int orgId);

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

	public int getProgateCategory();

	public void setProgateCategory(int progateCategory);

	public Date getExpiredDate();

	public void setExpiredDate(Date expiredDate);

	public int getAmount();

	public void setAmount(int amount);

	public ProGateProductsServices toEscapedModel();
}