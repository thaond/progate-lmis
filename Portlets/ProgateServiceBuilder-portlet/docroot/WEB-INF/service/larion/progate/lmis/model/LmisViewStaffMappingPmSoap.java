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
 * <a href="LmisViewStaffMappingPmSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewStaffMappingPmSoap implements Serializable {
	public static LmisViewStaffMappingPmSoap toSoapModel(
		LmisViewStaffMappingPm model) {
		LmisViewStaffMappingPmSoap soapModel = new LmisViewStaffMappingPmSoap();

		soapModel.setLmisViewStaffMappingPmId(model.getLmisViewStaffMappingPmId());
		soapModel.setOrgId(model.getOrgId());
		soapModel.setRootId(model.getRootId());
		soapModel.setBodId(model.getBodId());
		soapModel.setStaffUID(model.getStaffUID());
		soapModel.setPmUID(model.getPmUID());
		soapModel.setStaffCode(model.getStaffCode());

		return soapModel;
	}

	public static LmisViewStaffMappingPmSoap[] toSoapModels(
		LmisViewStaffMappingPm[] models) {
		LmisViewStaffMappingPmSoap[] soapModels = new LmisViewStaffMappingPmSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LmisViewStaffMappingPmSoap[][] toSoapModels(
		LmisViewStaffMappingPm[][] models) {
		LmisViewStaffMappingPmSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LmisViewStaffMappingPmSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LmisViewStaffMappingPmSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LmisViewStaffMappingPmSoap[] toSoapModels(
		List<LmisViewStaffMappingPm> models) {
		List<LmisViewStaffMappingPmSoap> soapModels = new ArrayList<LmisViewStaffMappingPmSoap>(models.size());

		for (LmisViewStaffMappingPm model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LmisViewStaffMappingPmSoap[soapModels.size()]);
	}

	public LmisViewStaffMappingPmSoap() {
	}

	public Integer getPrimaryKey() {
		return _lmisViewStaffMappingPmId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisViewStaffMappingPmId(pk);
	}

	public Integer getLmisViewStaffMappingPmId() {
		return _lmisViewStaffMappingPmId;
	}

	public void setLmisViewStaffMappingPmId(Integer lmisViewStaffMappingPmId) {
		_lmisViewStaffMappingPmId = lmisViewStaffMappingPmId;
	}

	public int getOrgId() {
		return _orgId;
	}

	public void setOrgId(int orgId) {
		_orgId = orgId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public int getBodId() {
		return _bodId;
	}

	public void setBodId(int bodId) {
		_bodId = bodId;
	}

	public int getStaffUID() {
		return _staffUID;
	}

	public void setStaffUID(int staffUID) {
		_staffUID = staffUID;
	}

	public int getPmUID() {
		return _pmUID;
	}

	public void setPmUID(int pmUID) {
		_pmUID = pmUID;
	}

	public String getStaffCode() {
		return _staffCode;
	}

	public void setStaffCode(String staffCode) {
		_staffCode = staffCode;
	}

	private Integer _lmisViewStaffMappingPmId;
	private int _orgId;
	private int _rootId;
	private int _bodId;
	private int _staffUID;
	private int _pmUID;
	private String _staffCode;
}