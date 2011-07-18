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
 * <a href="LmisViewStaffRootOrgFNSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewStaffRootOrgFNSoap implements Serializable {
	public static LmisViewStaffRootOrgFNSoap toSoapModel(
		LmisViewStaffRootOrgFN model) {
		LmisViewStaffRootOrgFNSoap soapModel = new LmisViewStaffRootOrgFNSoap();

		soapModel.setLmisViewStaffRootOrgFNId(model.getLmisViewStaffRootOrgFNId());
		soapModel.setUserId(model.getUserId());
		soapModel.setRootId(model.getRootId());
		soapModel.setOrgId(model.getOrgId());
		soapModel.setBodId(model.getBodId());
		soapModel.setStaffCode(model.getStaffCode());
		soapModel.setScannerCode(model.getScannerCode());
		soapModel.setScreenName(model.getScreenName());
		soapModel.setFullName(model.getFullName());
		soapModel.setEmailAddress(model.getEmailAddress());

		return soapModel;
	}

	public static LmisViewStaffRootOrgFNSoap[] toSoapModels(
		LmisViewStaffRootOrgFN[] models) {
		LmisViewStaffRootOrgFNSoap[] soapModels = new LmisViewStaffRootOrgFNSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LmisViewStaffRootOrgFNSoap[][] toSoapModels(
		LmisViewStaffRootOrgFN[][] models) {
		LmisViewStaffRootOrgFNSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LmisViewStaffRootOrgFNSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LmisViewStaffRootOrgFNSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LmisViewStaffRootOrgFNSoap[] toSoapModels(
		List<LmisViewStaffRootOrgFN> models) {
		List<LmisViewStaffRootOrgFNSoap> soapModels = new ArrayList<LmisViewStaffRootOrgFNSoap>(models.size());

		for (LmisViewStaffRootOrgFN model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LmisViewStaffRootOrgFNSoap[soapModels.size()]);
	}

	public LmisViewStaffRootOrgFNSoap() {
	}

	public Integer getPrimaryKey() {
		return _lmisViewStaffRootOrgFNId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisViewStaffRootOrgFNId(pk);
	}

	public Integer getLmisViewStaffRootOrgFNId() {
		return _lmisViewStaffRootOrgFNId;
	}

	public void setLmisViewStaffRootOrgFNId(Integer lmisViewStaffRootOrgFNId) {
		_lmisViewStaffRootOrgFNId = lmisViewStaffRootOrgFNId;
	}

	public int getUserId() {
		return _userId;
	}

	public void setUserId(int userId) {
		_userId = userId;
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

	public String getStaffCode() {
		return _staffCode;
	}

	public void setStaffCode(String staffCode) {
		_staffCode = staffCode;
	}

	public String getScannerCode() {
		return _scannerCode;
	}

	public void setScannerCode(String scannerCode) {
		_scannerCode = scannerCode;
	}

	public String getScreenName() {
		return _screenName;
	}

	public void setScreenName(String screenName) {
		_screenName = screenName;
	}

	public String getFullName() {
		return _fullName;
	}

	public void setFullName(String fullName) {
		_fullName = fullName;
	}

	public String getEmailAddress() {
		return _emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	private Integer _lmisViewStaffRootOrgFNId;
	private int _userId;
	private int _rootId;
	private int _orgId;
	private int _bodId;
	private String _staffCode;
	private String _scannerCode;
	private String _screenName;
	private String _fullName;
	private String _emailAddress;
}