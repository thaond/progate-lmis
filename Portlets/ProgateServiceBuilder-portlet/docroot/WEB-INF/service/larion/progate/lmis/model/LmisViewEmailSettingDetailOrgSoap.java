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
 * <a href="LmisViewEmailSettingDetailOrgSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewEmailSettingDetailOrgSoap implements Serializable {
	public static LmisViewEmailSettingDetailOrgSoap toSoapModel(
		LmisViewEmailSettingDetailOrg model) {
		LmisViewEmailSettingDetailOrgSoap soapModel = new LmisViewEmailSettingDetailOrgSoap();

		soapModel.setOrgRelatedId(model.getOrgRelatedId());
		soapModel.setId_(model.getId_());
		soapModel.setRootId(model.getRootId());
		soapModel.setName(model.getName());
		soapModel.setCategory(model.getCategory());
		soapModel.setToSender(model.getToSender());
		soapModel.setToPm(model.getToPm());
		soapModel.setToBod(model.getToBod());
		soapModel.setEmailType(model.getEmailType());
		soapModel.setEmailOrg(model.getEmailOrg());

		return soapModel;
	}

	public static LmisViewEmailSettingDetailOrgSoap[] toSoapModels(
		LmisViewEmailSettingDetailOrg[] models) {
		LmisViewEmailSettingDetailOrgSoap[] soapModels = new LmisViewEmailSettingDetailOrgSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LmisViewEmailSettingDetailOrgSoap[][] toSoapModels(
		LmisViewEmailSettingDetailOrg[][] models) {
		LmisViewEmailSettingDetailOrgSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LmisViewEmailSettingDetailOrgSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LmisViewEmailSettingDetailOrgSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LmisViewEmailSettingDetailOrgSoap[] toSoapModels(
		List<LmisViewEmailSettingDetailOrg> models) {
		List<LmisViewEmailSettingDetailOrgSoap> soapModels = new ArrayList<LmisViewEmailSettingDetailOrgSoap>(models.size());

		for (LmisViewEmailSettingDetailOrg model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LmisViewEmailSettingDetailOrgSoap[soapModels.size()]);
	}

	public LmisViewEmailSettingDetailOrgSoap() {
	}

	public Integer getPrimaryKey() {
		return _orgRelatedId;
	}

	public void setPrimaryKey(Integer pk) {
		setOrgRelatedId(pk);
	}

	public Integer getOrgRelatedId() {
		return _orgRelatedId;
	}

	public void setOrgRelatedId(Integer orgRelatedId) {
		_orgRelatedId = orgRelatedId;
	}

	public int getId_() {
		return _id_;
	}

	public void setId_(int id_) {
		_id_ = id_;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public int getCategory() {
		return _category;
	}

	public void setCategory(int category) {
		_category = category;
	}

	public boolean getToSender() {
		return _toSender;
	}

	public boolean isToSender() {
		return _toSender;
	}

	public void setToSender(boolean toSender) {
		_toSender = toSender;
	}

	public boolean getToPm() {
		return _toPm;
	}

	public boolean isToPm() {
		return _toPm;
	}

	public void setToPm(boolean toPm) {
		_toPm = toPm;
	}

	public boolean getToBod() {
		return _toBod;
	}

	public boolean isToBod() {
		return _toBod;
	}

	public void setToBod(boolean toBod) {
		_toBod = toBod;
	}

	public String getEmailType() {
		return _emailType;
	}

	public void setEmailType(String emailType) {
		_emailType = emailType;
	}

	public String getEmailOrg() {
		return _emailOrg;
	}

	public void setEmailOrg(String emailOrg) {
		_emailOrg = emailOrg;
	}

	private Integer _orgRelatedId;
	private int _id_;
	private int _rootId;
	private String _name;
	private int _category;
	private boolean _toSender;
	private boolean _toPm;
	private boolean _toBod;
	private String _emailType;
	private String _emailOrg;
}