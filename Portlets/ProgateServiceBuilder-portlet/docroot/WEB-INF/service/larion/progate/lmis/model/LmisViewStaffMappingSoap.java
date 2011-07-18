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
 * <a href="LmisViewStaffMappingSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewStaffMappingSoap implements Serializable {
	public static LmisViewStaffMappingSoap toSoapModel(
		LmisViewStaffMapping model) {
		LmisViewStaffMappingSoap soapModel = new LmisViewStaffMappingSoap();

		soapModel.setLmisViewStaffMappingId(model.getLmisViewStaffMappingId());
		soapModel.setOrgId(model.getOrgId());
		soapModel.setRootId(model.getRootId());
		soapModel.setBodId(model.getBodId());
		soapModel.setStaffUID(model.getStaffUID());
		soapModel.setPmUID(model.getPmUID());
		soapModel.setBodUID(model.getBodUID());

		return soapModel;
	}

	public static LmisViewStaffMappingSoap[] toSoapModels(
		LmisViewStaffMapping[] models) {
		LmisViewStaffMappingSoap[] soapModels = new LmisViewStaffMappingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LmisViewStaffMappingSoap[][] toSoapModels(
		LmisViewStaffMapping[][] models) {
		LmisViewStaffMappingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LmisViewStaffMappingSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LmisViewStaffMappingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LmisViewStaffMappingSoap[] toSoapModels(
		List<LmisViewStaffMapping> models) {
		List<LmisViewStaffMappingSoap> soapModels = new ArrayList<LmisViewStaffMappingSoap>(models.size());

		for (LmisViewStaffMapping model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LmisViewStaffMappingSoap[soapModels.size()]);
	}

	public LmisViewStaffMappingSoap() {
	}

	public Integer getPrimaryKey() {
		return _lmisViewStaffMappingId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisViewStaffMappingId(pk);
	}

	public Integer getLmisViewStaffMappingId() {
		return _lmisViewStaffMappingId;
	}

	public void setLmisViewStaffMappingId(Integer lmisViewStaffMappingId) {
		_lmisViewStaffMappingId = lmisViewStaffMappingId;
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

	public int getBodUID() {
		return _bodUID;
	}

	public void setBodUID(int bodUID) {
		_bodUID = bodUID;
	}

	private Integer _lmisViewStaffMappingId;
	private int _orgId;
	private int _rootId;
	private int _bodId;
	private int _staffUID;
	private int _pmUID;
	private int _bodUID;
}