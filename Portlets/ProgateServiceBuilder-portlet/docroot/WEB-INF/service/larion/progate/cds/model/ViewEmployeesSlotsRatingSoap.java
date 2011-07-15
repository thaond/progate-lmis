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
 * <a href="ViewEmployeesSlotsRatingSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ViewEmployeesSlotsRatingSoap implements Serializable {
	public static ViewEmployeesSlotsRatingSoap toSoapModel(
		ViewEmployeesSlotsRating model) {
		ViewEmployeesSlotsRatingSoap soapModel = new ViewEmployeesSlotsRatingSoap();

		soapModel.setId(model.getId());
		soapModel.setAliasName(model.getAliasName());
		soapModel.setDescription(model.getDescription());
		soapModel.setNumberOrder(model.getNumberOrder());
		soapModel.setUserId(model.getUserId());
		soapModel.setPeriodId(model.getPeriodId());
		soapModel.setPeriodName(model.getPeriodName());
		soapModel.setFromDate(model.getFromDate());
		soapModel.setToDate(model.getToDate());
		soapModel.setRatingOrgId(model.getRatingOrgId());
		soapModel.setRatingStatus(model.getRatingStatus());
		soapModel.setRatingStatusBod(model.getRatingStatusBod());
		soapModel.setRatingStatusPm(model.getRatingStatusPm());

		return soapModel;
	}

	public static ViewEmployeesSlotsRatingSoap[] toSoapModels(
		ViewEmployeesSlotsRating[] models) {
		ViewEmployeesSlotsRatingSoap[] soapModels = new ViewEmployeesSlotsRatingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ViewEmployeesSlotsRatingSoap[][] toSoapModels(
		ViewEmployeesSlotsRating[][] models) {
		ViewEmployeesSlotsRatingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ViewEmployeesSlotsRatingSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ViewEmployeesSlotsRatingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ViewEmployeesSlotsRatingSoap[] toSoapModels(
		List<ViewEmployeesSlotsRating> models) {
		List<ViewEmployeesSlotsRatingSoap> soapModels = new ArrayList<ViewEmployeesSlotsRatingSoap>(models.size());

		for (ViewEmployeesSlotsRating model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ViewEmployeesSlotsRatingSoap[soapModels.size()]);
	}

	public ViewEmployeesSlotsRatingSoap() {
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

	public String getAliasName() {
		return _aliasName;
	}

	public void setAliasName(String aliasName) {
		_aliasName = aliasName;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public int getNumberOrder() {
		return _numberOrder;
	}

	public void setNumberOrder(int numberOrder) {
		_numberOrder = numberOrder;
	}

	public int getUserId() {
		return _userId;
	}

	public void setUserId(int userId) {
		_userId = userId;
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

	public int getRatingOrgId() {
		return _ratingOrgId;
	}

	public void setRatingOrgId(int ratingOrgId) {
		_ratingOrgId = ratingOrgId;
	}

	public int getRatingStatus() {
		return _ratingStatus;
	}

	public void setRatingStatus(int ratingStatus) {
		_ratingStatus = ratingStatus;
	}

	public int getRatingStatusBod() {
		return _ratingStatusBod;
	}

	public void setRatingStatusBod(int ratingStatusBod) {
		_ratingStatusBod = ratingStatusBod;
	}

	public int getRatingStatusPm() {
		return _ratingStatusPm;
	}

	public void setRatingStatusPm(int ratingStatusPm) {
		_ratingStatusPm = ratingStatusPm;
	}

	private String _id;
	private String _aliasName;
	private String _description;
	private int _numberOrder;
	private int _userId;
	private int _periodId;
	private String _periodName;
	private Date _fromDate;
	private Date _toDate;
	private int _ratingOrgId;
	private int _ratingStatus;
	private int _ratingStatusBod;
	private int _ratingStatusPm;
}