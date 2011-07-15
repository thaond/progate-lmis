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
 * <a href="LmisAbsenceSettingsSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisAbsenceSettingsSoap implements Serializable {
	public static LmisAbsenceSettingsSoap toSoapModel(LmisAbsenceSettings model) {
		LmisAbsenceSettingsSoap soapModel = new LmisAbsenceSettingsSoap();

		soapModel.setLmisAbsenceSettingsId(model.getLmisAbsenceSettingsId());
		soapModel.setRootId(model.getRootId());
		soapModel.setName_(model.getName_());
		soapModel.setDesCription(model.getDesCription());
		soapModel.setIsSubtract(model.getIsSubtract());
		soapModel.setIsModified(model.getIsModified());
		soapModel.setAbsencePermissive(model.getAbsencePermissive());

		return soapModel;
	}

	public static LmisAbsenceSettingsSoap[] toSoapModels(
		LmisAbsenceSettings[] models) {
		LmisAbsenceSettingsSoap[] soapModels = new LmisAbsenceSettingsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LmisAbsenceSettingsSoap[][] toSoapModels(
		LmisAbsenceSettings[][] models) {
		LmisAbsenceSettingsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LmisAbsenceSettingsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LmisAbsenceSettingsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LmisAbsenceSettingsSoap[] toSoapModels(
		List<LmisAbsenceSettings> models) {
		List<LmisAbsenceSettingsSoap> soapModels = new ArrayList<LmisAbsenceSettingsSoap>(models.size());

		for (LmisAbsenceSettings model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LmisAbsenceSettingsSoap[soapModels.size()]);
	}

	public LmisAbsenceSettingsSoap() {
	}

	public Integer getPrimaryKey() {
		return _lmisAbsenceSettingsId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisAbsenceSettingsId(pk);
	}

	public Integer getLmisAbsenceSettingsId() {
		return _lmisAbsenceSettingsId;
	}

	public void setLmisAbsenceSettingsId(Integer lmisAbsenceSettingsId) {
		_lmisAbsenceSettingsId = lmisAbsenceSettingsId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public String getName_() {
		return _name_;
	}

	public void setName_(String name_) {
		_name_ = name_;
	}

	public String getDesCription() {
		return _desCription;
	}

	public void setDesCription(String desCription) {
		_desCription = desCription;
	}

	public boolean getIsSubtract() {
		return _isSubtract;
	}

	public boolean isIsSubtract() {
		return _isSubtract;
	}

	public void setIsSubtract(boolean isSubtract) {
		_isSubtract = isSubtract;
	}

	public boolean getIsModified() {
		return _isModified;
	}

	public boolean isIsModified() {
		return _isModified;
	}

	public void setIsModified(boolean isModified) {
		_isModified = isModified;
	}

	public boolean getAbsencePermissive() {
		return _absencePermissive;
	}

	public boolean isAbsencePermissive() {
		return _absencePermissive;
	}

	public void setAbsencePermissive(boolean absencePermissive) {
		_absencePermissive = absencePermissive;
	}

	private Integer _lmisAbsenceSettingsId;
	private int _rootId;
	private String _name_;
	private String _desCription;
	private boolean _isSubtract;
	private boolean _isModified;
	private boolean _absencePermissive;
}