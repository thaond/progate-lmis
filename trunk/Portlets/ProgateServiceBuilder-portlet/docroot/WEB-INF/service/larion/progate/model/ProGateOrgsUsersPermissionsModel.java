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

/**
 * <a href="ProGateOrgsUsersPermissionsModel.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface ProGateOrgsUsersPermissionsModel extends BaseModel<ProGateOrgsUsersPermissions> {
	public Integer getPrimaryKey();

	public void setPrimaryKey(Integer pk);

	public Integer getProGateOrgsUsersPermissionsId();

	public void setProGateOrgsUsersPermissionsId(
		Integer ProGateOrgsUsersPermissionsId);

	public int getOrgId();

	public void setOrgId(int orgId);

	public int getUserId();

	public void setUserId(int userId);

	public String getPermissionId();

	public void setPermissionId(String permissionId);

	public int getValue();

	public void setValue(int value);

	public boolean getIsGrant();

	public boolean isIsGrant();

	public void setIsGrant(boolean isGrant);

	public int getPmId();

	public void setPmId(int pmId);

	public ProGateOrgsUsersPermissions toEscapedModel();
}