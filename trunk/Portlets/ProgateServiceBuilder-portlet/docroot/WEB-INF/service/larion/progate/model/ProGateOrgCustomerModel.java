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
 * <a href="ProGateOrgCustomerModel.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface ProGateOrgCustomerModel extends BaseModel<ProGateOrgCustomer> {
	public Integer getPrimaryKey();

	public void setPrimaryKey(Integer pk);

	public Integer getProGateOrgCustomerId();

	public void setProGateOrgCustomerId(Integer ProGateOrgCustomerId);

	public int getCustomerType();

	public void setCustomerType(int customerType);

	public String getCustomerName();

	public void setCustomerName(String customerName);

	public int getOrgId();

	public void setOrgId(int orgId);

	public boolean getHasOrgMap();

	public boolean isHasOrgMap();

	public void setHasOrgMap(boolean hasOrgMap);

	public String getUrlOrgMap();

	public void setUrlOrgMap(String urlOrgMap);

	public String getLogo();

	public void setLogo(String logo);

	public String getWebsite();

	public void setWebsite(String website);

	public String getDescription();

	public void setDescription(String description);

	public Date getCreatedDate();

	public void setCreatedDate(Date createdDate);

	public Date getModifiedDate();

	public void setModifiedDate(Date modifiedDate);

	public ProGateOrgCustomer toEscapedModel();
}