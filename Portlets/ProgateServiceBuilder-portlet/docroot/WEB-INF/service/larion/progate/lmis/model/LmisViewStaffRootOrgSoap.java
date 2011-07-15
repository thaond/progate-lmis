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

package larion.progate.lmis.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="LmisViewStaffRootOrgSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewStaffRootOrgSoap implements Serializable {
	public static LmisViewStaffRootOrgSoap toSoapModel(
		LmisViewStaffRootOrg model) {
		LmisViewStaffRootOrgSoap soapModel = new LmisViewStaffRootOrgSoap();

		soapModel.setUser_id(model.getUser_id());
		soapModel.setRootId(model.getRootId());
		soapModel.setOrgId(model.getOrgId());
		soapModel.setBodId(model.getBodId());
		soapModel.setScreenName(model.getScreenName());
		soapModel.setEmailAddress(model.getEmailAddress());

		return soapModel;
	}

	public static LmisViewStaffRootOrgSoap[] toSoapModels(
		LmisViewStaffRootOrg[] models) {
		LmisViewStaffRootOrgSoap[] soapModels = new LmisViewStaffRootOrgSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LmisViewStaffRootOrgSoap[][] toSoapModels(
		LmisViewStaffRootOrg[][] models) {
		LmisViewStaffRootOrgSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LmisViewStaffRootOrgSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LmisViewStaffRootOrgSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LmisViewStaffRootOrgSoap[] toSoapModels(
		List<LmisViewStaffRootOrg> models) {
		List<LmisViewStaffRootOrgSoap> soapModels = new ArrayList<LmisViewStaffRootOrgSoap>(models.size());

		for (LmisViewStaffRootOrg model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LmisViewStaffRootOrgSoap[soapModels.size()]);
	}

	public LmisViewStaffRootOrgSoap() {
	}

	public Integer getPrimaryKey() {
		return _User_id;
	}

	public void setPrimaryKey(Integer pk) {
		setUser_id(pk);
	}

	public Integer getUser_id() {
		return _User_id;
	}

	public void setUser_id(Integer User_id) {
		_User_id = User_id;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public int getOrgId() {
		return _orgId;
	}

	public void setOrgId(int orgId) {
		_orgId = orgId;
	}

	public int getBodId() {
		return _bodId;
	}

	public void setBodId(int bodId) {
		_bodId = bodId;
	}

	public String getScreenName() {
		return _screenName;
	}

	public void setScreenName(String screenName) {
		_screenName = screenName;
	}

	public String getEmailAddress() {
		return _emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	private Integer _User_id;
	private int _rootId;
	private int _orgId;
	private int _bodId;
	private String _screenName;
	private String _emailAddress;
}