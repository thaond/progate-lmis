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
 * <a href="ProGateUserApplicationsSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateUserApplicationsSoap implements Serializable {
	public static ProGateUserApplicationsSoap toSoapModel(
		ProGateUserApplications model) {
		ProGateUserApplicationsSoap soapModel = new ProGateUserApplicationsSoap();

		soapModel.setProGateUserApplicationsId(model.getProGateUserApplicationsId());
		soapModel.setUserId(model.getUserId());
		soapModel.setAppsId(model.getAppsId());
		soapModel.setOrgId(model.getOrgId());
		soapModel.setPosition(model.getPosition());

		return soapModel;
	}

	public static ProGateUserApplicationsSoap[] toSoapModels(
		ProGateUserApplications[] models) {
		ProGateUserApplicationsSoap[] soapModels = new ProGateUserApplicationsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProGateUserApplicationsSoap[][] toSoapModels(
		ProGateUserApplications[][] models) {
		ProGateUserApplicationsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProGateUserApplicationsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProGateUserApplicationsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProGateUserApplicationsSoap[] toSoapModels(
		List<ProGateUserApplications> models) {
		List<ProGateUserApplicationsSoap> soapModels = new ArrayList<ProGateUserApplicationsSoap>(models.size());

		for (ProGateUserApplications model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProGateUserApplicationsSoap[soapModels.size()]);
	}

	public ProGateUserApplicationsSoap() {
	}

	public Integer getPrimaryKey() {
		return _ProGateUserApplicationsId;
	}

	public void setPrimaryKey(Integer pk) {
		setProGateUserApplicationsId(pk);
	}

	public Integer getProGateUserApplicationsId() {
		return _ProGateUserApplicationsId;
	}

	public void setProGateUserApplicationsId(Integer ProGateUserApplicationsId) {
		_ProGateUserApplicationsId = ProGateUserApplicationsId;
	}

	public int getUserId() {
		return _userId;
	}

	public void setUserId(int userId) {
		_userId = userId;
	}

	public int getAppsId() {
		return _appsId;
	}

	public void setAppsId(int appsId) {
		_appsId = appsId;
	}

	public int getOrgId() {
		return _orgId;
	}

	public void setOrgId(int orgId) {
		_orgId = orgId;
	}

	public int getPosition() {
		return _position;
	}

	public void setPosition(int position) {
		_position = position;
	}

	private Integer _ProGateUserApplicationsId;
	private int _userId;
	private int _appsId;
	private int _orgId;
	private int _position;
}