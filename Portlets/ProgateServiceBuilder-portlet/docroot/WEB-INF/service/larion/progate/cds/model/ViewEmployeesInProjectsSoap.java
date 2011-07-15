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

package larion.progate.cds.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="ViewEmployeesInProjectsSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ViewEmployeesInProjectsSoap implements Serializable {
	public static ViewEmployeesInProjectsSoap toSoapModel(
		ViewEmployeesInProjects model) {
		ViewEmployeesInProjectsSoap soapModel = new ViewEmployeesInProjectsSoap();

		soapModel.setId(model.getId());
		soapModel.setRootId(model.getRootId());
		soapModel.setUserId(model.getUserId());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setMiddleName(model.getMiddleName());
		soapModel.setLastName(model.getLastName());
		soapModel.setPosition(model.getPosition());
		soapModel.setTitleAbbreviation(model.getTitleAbbreviation());
		soapModel.setTitleName(model.getTitleName());
		soapModel.setOrgId(model.getOrgId());
		soapModel.setOrgList(model.getOrgList());
		soapModel.setPmList(model.getPmList());
		soapModel.setPeriodId(model.getPeriodId());
		soapModel.setPeriodName(model.getPeriodName());
		soapModel.setFromDate(model.getFromDate());
		soapModel.setToDate(model.getToDate());
		soapModel.setPeriodStatus(model.getPeriodStatus());
		soapModel.setRatingStatus(model.getRatingStatus());
		soapModel.setRatingStatusPm(model.getRatingStatusPm());
		soapModel.setRatingStatusBod(model.getRatingStatusBod());
		soapModel.setIsActive(model.getIsActive());
		soapModel.setIsRemoved(model.getIsRemoved());
		soapModel.setIsLocked(model.getIsLocked());
		soapModel.setBeginTime(model.getBeginTime());
		soapModel.setEndTime(model.getEndTime());
		soapModel.setIsTitleUp(model.getIsTitleUp());

		return soapModel;
	}

	public static ViewEmployeesInProjectsSoap[] toSoapModels(
		ViewEmployeesInProjects[] models) {
		ViewEmployeesInProjectsSoap[] soapModels = new ViewEmployeesInProjectsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ViewEmployeesInProjectsSoap[][] toSoapModels(
		ViewEmployeesInProjects[][] models) {
		ViewEmployeesInProjectsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ViewEmployeesInProjectsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ViewEmployeesInProjectsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ViewEmployeesInProjectsSoap[] toSoapModels(
		List<ViewEmployeesInProjects> models) {
		List<ViewEmployeesInProjectsSoap> soapModels = new ArrayList<ViewEmployeesInProjectsSoap>(models.size());

		for (ViewEmployeesInProjects model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ViewEmployeesInProjectsSoap[soapModels.size()]);
	}

	public ViewEmployeesInProjectsSoap() {
	}

	public String getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(String pk) {
		setId(pk);
	}

	public String getId() {
		return _id;
	}

	public void setId(String id) {
		_id = id;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public int getUserId() {
		return _userId;
	}

	public void setUserId(int userId) {
		_userId = userId;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getMiddleName() {
		return _middleName;
	}

	public void setMiddleName(String middleName) {
		_middleName = middleName;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public String getPosition() {
		return _position;
	}

	public void setPosition(String position) {
		_position = position;
	}

	public String getTitleAbbreviation() {
		return _titleAbbreviation;
	}

	public void setTitleAbbreviation(String titleAbbreviation) {
		_titleAbbreviation = titleAbbreviation;
	}

	public String getTitleName() {
		return _titleName;
	}

	public void setTitleName(String titleName) {
		_titleName = titleName;
	}

	public int getOrgId() {
		return _orgId;
	}

	public void setOrgId(int orgId) {
		_orgId = orgId;
	}

	public String getOrgList() {
		return _orgList;
	}

	public void setOrgList(String orgList) {
		_orgList = orgList;
	}

	public String getPmList() {
		return _pmList;
	}

	public void setPmList(String pmList) {
		_pmList = pmList;
	}

	public int getPeriodId() {
		return _periodId;
	}

	public void setPeriodId(int periodId) {
		_periodId = periodId;
	}

	public String getPeriodName() {
		return _periodName;
	}

	public void setPeriodName(String periodName) {
		_periodName = periodName;
	}

	public Date getFromDate() {
		return _fromDate;
	}

	public void setFromDate(Date fromDate) {
		_fromDate = fromDate;
	}

	public Date getToDate() {
		return _toDate;
	}

	public void setToDate(Date toDate) {
		_toDate = toDate;
	}

	public int getPeriodStatus() {
		return _periodStatus;
	}

	public void setPeriodStatus(int periodStatus) {
		_periodStatus = periodStatus;
	}

	public int getRatingStatus() {
		return _ratingStatus;
	}

	public void setRatingStatus(int ratingStatus) {
		_ratingStatus = ratingStatus;
	}

	public int getRatingStatusPm() {
		return _ratingStatusPm;
	}

	public void setRatingStatusPm(int ratingStatusPm) {
		_ratingStatusPm = ratingStatusPm;
	}

	public int getRatingStatusBod() {
		return _ratingStatusBod;
	}

	public void setRatingStatusBod(int ratingStatusBod) {
		_ratingStatusBod = ratingStatusBod;
	}

	public boolean getIsActive() {
		return _isActive;
	}

	public boolean isIsActive() {
		return _isActive;
	}

	public void setIsActive(boolean isActive) {
		_isActive = isActive;
	}

	public boolean getIsRemoved() {
		return _isRemoved;
	}

	public boolean isIsRemoved() {
		return _isRemoved;
	}

	public void setIsRemoved(boolean isRemoved) {
		_isRemoved = isRemoved;
	}

	public boolean getIsLocked() {
		return _isLocked;
	}

	public boolean isIsLocked() {
		return _isLocked;
	}

	public void setIsLocked(boolean isLocked) {
		_isLocked = isLocked;
	}

	public Date getBeginTime() {
		return _beginTime;
	}

	public void setBeginTime(Date beginTime) {
		_beginTime = beginTime;
	}

	public Date getEndTime() {
		return _endTime;
	}

	public void setEndTime(Date endTime) {
		_endTime = endTime;
	}

	public boolean getIsTitleUp() {
		return _isTitleUp;
	}

	public boolean isIsTitleUp() {
		return _isTitleUp;
	}

	public void setIsTitleUp(boolean isTitleUp) {
		_isTitleUp = isTitleUp;
	}

	private String _id;
	private int _rootId;
	private int _userId;
	private String _firstName;
	private String _middleName;
	private String _lastName;
	private String _position;
	private String _titleAbbreviation;
	private String _titleName;
	private int _orgId;
	private String _orgList;
	private String _pmList;
	private int _periodId;
	private String _periodName;
	private Date _fromDate;
	private Date _toDate;
	private int _periodStatus;
	private int _ratingStatus;
	private int _ratingStatusPm;
	private int _ratingStatusBod;
	private boolean _isActive;
	private boolean _isRemoved;
	private boolean _isLocked;
	private Date _beginTime;
	private Date _endTime;
	private boolean _isTitleUp;
}