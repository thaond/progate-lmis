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
import java.util.Date;
import java.util.List;

/**
 * <a href="ProGateApplicationsSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateApplicationsSoap implements Serializable {
	public static ProGateApplicationsSoap toSoapModel(ProGateApplications model) {
		ProGateApplicationsSoap soapModel = new ProGateApplicationsSoap();

		soapModel.setProGateApplicationsId(model.getProGateApplicationsId());
		soapModel.setLayoutId(model.getLayoutId());
		soapModel.setName(model.getName());
		soapModel.setTitle(model.getTitle());
		soapModel.setDescription(model.getDescription());
		soapModel.setIsHidden(model.getIsHidden());
		soapModel.setFriendlyUrl(model.getFriendlyUrl());
		soapModel.setImageUrl(model.getImageUrl());
		soapModel.setIconUrl(model.getIconUrl());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static ProGateApplicationsSoap[] toSoapModels(
		ProGateApplications[] models) {
		ProGateApplicationsSoap[] soapModels = new ProGateApplicationsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProGateApplicationsSoap[][] toSoapModels(
		ProGateApplications[][] models) {
		ProGateApplicationsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProGateApplicationsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProGateApplicationsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProGateApplicationsSoap[] toSoapModels(
		List<ProGateApplications> models) {
		List<ProGateApplicationsSoap> soapModels = new ArrayList<ProGateApplicationsSoap>(models.size());

		for (ProGateApplications model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProGateApplicationsSoap[soapModels.size()]);
	}

	public ProGateApplicationsSoap() {
	}

	public Integer getPrimaryKey() {
		return _ProGateApplicationsId;
	}

	public void setPrimaryKey(Integer pk) {
		setProGateApplicationsId(pk);
	}

	public Integer getProGateApplicationsId() {
		return _ProGateApplicationsId;
	}

	public void setProGateApplicationsId(Integer ProGateApplicationsId) {
		_ProGateApplicationsId = ProGateApplicationsId;
	}

	public int getLayoutId() {
		return _layoutId;
	}

	public void setLayoutId(int layoutId) {
		_layoutId = layoutId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public boolean getIsHidden() {
		return _isHidden;
	}

	public boolean isIsHidden() {
		return _isHidden;
	}

	public void setIsHidden(boolean isHidden) {
		_isHidden = isHidden;
	}

	public String getFriendlyUrl() {
		return _friendlyUrl;
	}

	public void setFriendlyUrl(String friendlyUrl) {
		_friendlyUrl = friendlyUrl;
	}

	public String getImageUrl() {
		return _imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		_imageUrl = imageUrl;
	}

	public String getIconUrl() {
		return _iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		_iconUrl = iconUrl;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	private Integer _ProGateApplicationsId;
	private int _layoutId;
	private String _name;
	private String _title;
	private String _description;
	private boolean _isHidden;
	private String _friendlyUrl;
	private String _imageUrl;
	private String _iconUrl;
	private Date _createdDate;
	private Date _modifiedDate;
}