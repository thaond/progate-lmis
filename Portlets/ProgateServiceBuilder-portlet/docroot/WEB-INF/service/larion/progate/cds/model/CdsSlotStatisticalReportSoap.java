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
 * <a href="CdsSlotStatisticalReportSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsSlotStatisticalReportSoap implements Serializable {
	public static CdsSlotStatisticalReportSoap toSoapModel(
		CdsSlotStatisticalReport model) {
		CdsSlotStatisticalReportSoap soapModel = new CdsSlotStatisticalReportSoap();

		soapModel.setSlotId(model.getSlotId());
		soapModel.setRootId(model.getRootId());
		soapModel.setLevelId(model.getLevelId());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setPeriodId(model.getPeriodId());
		soapModel.setUserId(model.getUserId());
		soapModel.setPmId(model.getPmId());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setLastName(model.getLastName());
		soapModel.setRatingStatusPm(model.getRatingStatusPm());
		soapModel.setRatingStatusBod(model.getRatingStatusBod());
		soapModel.setPointName(model.getPointName());
		soapModel.setPointValue(model.getPointValue());
		soapModel.setMaxPointName(model.getMaxPointName());
		soapModel.setMaxPointValue(model.getMaxPointValue());
		soapModel.setToDate(model.getToDate());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static CdsSlotStatisticalReportSoap[] toSoapModels(
		CdsSlotStatisticalReport[] models) {
		CdsSlotStatisticalReportSoap[] soapModels = new CdsSlotStatisticalReportSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CdsSlotStatisticalReportSoap[][] toSoapModels(
		CdsSlotStatisticalReport[][] models) {
		CdsSlotStatisticalReportSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CdsSlotStatisticalReportSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CdsSlotStatisticalReportSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CdsSlotStatisticalReportSoap[] toSoapModels(
		List<CdsSlotStatisticalReport> models) {
		List<CdsSlotStatisticalReportSoap> soapModels = new ArrayList<CdsSlotStatisticalReportSoap>(models.size());

		for (CdsSlotStatisticalReport model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CdsSlotStatisticalReportSoap[soapModels.size()]);
	}

	public CdsSlotStatisticalReportSoap() {
	}

	public Integer getPrimaryKey() {
		return _slotId;
	}

	public void setPrimaryKey(Integer pk) {
		setSlotId(pk);
	}

	public Integer getSlotId() {
		return _slotId;
	}

	public void setSlotId(Integer slotId) {
		_slotId = slotId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public int getLevelId() {
		return _levelId;
	}

	public void setLevelId(int levelId) {
		_levelId = levelId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public int getPeriodId() {
		return _periodId;
	}

	public void setPeriodId(int periodId) {
		_periodId = periodId;
	}

	public int getUserId() {
		return _userId;
	}

	public void setUserId(int userId) {
		_userId = userId;
	}

	public int getPmId() {
		return _pmId;
	}

	public void setPmId(int pmId) {
		_pmId = pmId;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
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

	public String getPointName() {
		return _pointName;
	}

	public void setPointName(String pointName) {
		_pointName = pointName;
	}

	public int getPointValue() {
		return _pointValue;
	}

	public void setPointValue(int pointValue) {
		_pointValue = pointValue;
	}

	public String getMaxPointName() {
		return _maxPointName;
	}

	public void setMaxPointName(String maxPointName) {
		_maxPointName = maxPointName;
	}

	public int getMaxPointValue() {
		return _maxPointValue;
	}

	public void setMaxPointValue(int maxPointValue) {
		_maxPointValue = maxPointValue;
	}

	public Date getToDate() {
		return _toDate;
	}

	public void setToDate(Date toDate) {
		_toDate = toDate;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private Integer _slotId;
	private int _rootId;
	private int _levelId;
	private String _name;
	private String _description;
	private int _periodId;
	private int _userId;
	private int _pmId;
	private String _firstName;
	private String _lastName;
	private int _ratingStatusPm;
	private int _ratingStatusBod;
	private String _pointName;
	private int _pointValue;
	private String _maxPointName;
	private int _maxPointValue;
	private Date _toDate;
	private int _status;
}