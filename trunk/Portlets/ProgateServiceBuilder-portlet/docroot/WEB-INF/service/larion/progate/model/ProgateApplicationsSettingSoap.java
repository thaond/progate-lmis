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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="ProgateApplicationsSettingSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProgateApplicationsSettingSoap implements Serializable {
	public static ProgateApplicationsSettingSoap toSoapModel(
		ProgateApplicationsSetting model) {
		ProgateApplicationsSettingSoap soapModel = new ProgateApplicationsSettingSoap();

		soapModel.setProgateApplicationsSettingId(model.getProgateApplicationsSettingId());
		soapModel.setAppId(model.getAppId());
		soapModel.setRoleId(model.getRoleId());
		soapModel.setDefaultPosition(model.getDefaultPosition());

		return soapModel;
	}

	public static ProgateApplicationsSettingSoap[] toSoapModels(
		ProgateApplicationsSetting[] models) {
		ProgateApplicationsSettingSoap[] soapModels = new ProgateApplicationsSettingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProgateApplicationsSettingSoap[][] toSoapModels(
		ProgateApplicationsSetting[][] models) {
		ProgateApplicationsSettingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProgateApplicationsSettingSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProgateApplicationsSettingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProgateApplicationsSettingSoap[] toSoapModels(
		List<ProgateApplicationsSetting> models) {
		List<ProgateApplicationsSettingSoap> soapModels = new ArrayList<ProgateApplicationsSettingSoap>(models.size());

		for (ProgateApplicationsSetting model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProgateApplicationsSettingSoap[soapModels.size()]);
	}

	public ProgateApplicationsSettingSoap() {
	}

	public Integer getPrimaryKey() {
		return _ProgateApplicationsSettingId;
	}

	public void setPrimaryKey(Integer pk) {
		setProgateApplicationsSettingId(pk);
	}

	public Integer getProgateApplicationsSettingId() {
		return _ProgateApplicationsSettingId;
	}

	public void setProgateApplicationsSettingId(
		Integer ProgateApplicationsSettingId) {
		_ProgateApplicationsSettingId = ProgateApplicationsSettingId;
	}

	public int getAppId() {
		return _appId;
	}

	public void setAppId(int appId) {
		_appId = appId;
	}

	public int getRoleId() {
		return _roleId;
	}

	public void setRoleId(int roleId) {
		_roleId = roleId;
	}

	public int getDefaultPosition() {
		return _defaultPosition;
	}

	public void setDefaultPosition(int defaultPosition) {
		_defaultPosition = defaultPosition;
	}

	private Integer _ProgateApplicationsSettingId;
	private int _appId;
	private int _roleId;
	private int _defaultPosition;
}