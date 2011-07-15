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
 * <a href="ViewPerformanceAppraisalSlotsSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ViewPerformanceAppraisalSlotsSoap implements Serializable {
	public static ViewPerformanceAppraisalSlotsSoap toSoapModel(
		ViewPerformanceAppraisalSlots model) {
		ViewPerformanceAppraisalSlotsSoap soapModel = new ViewPerformanceAppraisalSlotsSoap();

		soapModel.setId(model.getId());
		soapModel.setSlotId(model.getSlotId());
		soapModel.setLevelId(model.getLevelId());
		soapModel.setCompetencyId(model.getCompetencyId());
		soapModel.setRootId(model.getRootId());
		soapModel.setSlotName(model.getSlotName());
		soapModel.setAliasName(model.getAliasName());
		soapModel.setDescription(model.getDescription());
		soapModel.setPaId(model.getPaId());
		soapModel.setSlotNumberOrder(model.getSlotNumberOrder());
		soapModel.setLevelNumberOrder(model.getLevelNumberOrder());
		soapModel.setCompetencyNumberOrder(model.getCompetencyNumberOrder());
		soapModel.setUserId(model.getUserId());
		soapModel.setPeriodId(model.getPeriodId());
		soapModel.setPeriodName(model.getPeriodName());
		soapModel.setFromDate(model.getFromDate());
		soapModel.setToDate(model.getToDate());
		soapModel.setBodUid(model.getBodUid());
		soapModel.setPmUid(model.getPmUid());
		soapModel.setRatingOrgId(model.getRatingOrgId());
		soapModel.setRatingStatus(model.getRatingStatus());
		soapModel.setRatingStatusBod(model.getRatingStatusBod());
		soapModel.setRatingStatusPm(model.getRatingStatusPm());
		soapModel.setPointName(model.getPointName());
		soapModel.setMaxPointName(model.getMaxPointName());
		soapModel.setPointValue(model.getPointValue());
		soapModel.setMaxPointValue(model.getMaxPointValue());
		soapModel.setIsPassed(model.getIsPassed());

		return soapModel;
	}

	public static ViewPerformanceAppraisalSlotsSoap[] toSoapModels(
		ViewPerformanceAppraisalSlots[] models) {
		ViewPerformanceAppraisalSlotsSoap[] soapModels = new ViewPerformanceAppraisalSlotsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ViewPerformanceAppraisalSlotsSoap[][] toSoapModels(
		ViewPerformanceAppraisalSlots[][] models) {
		ViewPerformanceAppraisalSlotsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ViewPerformanceAppraisalSlotsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ViewPerformanceAppraisalSlotsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ViewPerformanceAppraisalSlotsSoap[] toSoapModels(
		List<ViewPerformanceAppraisalSlots> models) {
		List<ViewPerformanceAppraisalSlotsSoap> soapModels = new ArrayList<ViewPerformanceAppraisalSlotsSoap>(models.size());

		for (ViewPerformanceAppraisalSlots model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ViewPerformanceAppraisalSlotsSoap[soapModels.size()]);
	}

	public ViewPerformanceAppraisalSlotsSoap() {
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

	public int getSlotId() {
		return _slotId;
	}

	public void setSlotId(int slotId) {
		_slotId = slotId;
	}

	public int getLevelId() {
		return _levelId;
	}

	public void setLevelId(int levelId) {
		_levelId = levelId;
	}

	public int getCompetencyId() {
		return _competencyId;
	}

	public void setCompetencyId(int competencyId) {
		_competencyId = competencyId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public String getSlotName() {
		return _slotName;
	}

	public void setSlotName(String slotName) {
		_slotName = slotName;
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

	public int getPaId() {
		return _paId;
	}

	public void setPaId(int paId) {
		_paId = paId;
	}

	public int getSlotNumberOrder() {
		return _slotNumberOrder;
	}

	public void setSlotNumberOrder(int slotNumberOrder) {
		_slotNumberOrder = slotNumberOrder;
	}

	public int getLevelNumberOrder() {
		return _levelNumberOrder;
	}

	public void setLevelNumberOrder(int levelNumberOrder) {
		_levelNumberOrder = levelNumberOrder;
	}

	public int getCompetencyNumberOrder() {
		return _competencyNumberOrder;
	}

	public void setCompetencyNumberOrder(int competencyNumberOrder) {
		_competencyNumberOrder = competencyNumberOrder;
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

	public int getBodUid() {
		return _bodUid;
	}

	public void setBodUid(int bodUid) {
		_bodUid = bodUid;
	}

	public int getPmUid() {
		return _pmUid;
	}

	public void setPmUid(int pmUid) {
		_pmUid = pmUid;
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

	public String getPointName() {
		return _pointName;
	}

	public void setPointName(String pointName) {
		_pointName = pointName;
	}

	public String getMaxPointName() {
		return _maxPointName;
	}

	public void setMaxPointName(String maxPointName) {
		_maxPointName = maxPointName;
	}

	public int getPointValue() {
		return _pointValue;
	}

	public void setPointValue(int pointValue) {
		_pointValue = pointValue;
	}

	public int getMaxPointValue() {
		return _maxPointValue;
	}

	public void setMaxPointValue(int maxPointValue) {
		_maxPointValue = maxPointValue;
	}

	public boolean getIsPassed() {
		return _isPassed;
	}

	public boolean isIsPassed() {
		return _isPassed;
	}

	public void setIsPassed(boolean isPassed) {
		_isPassed = isPassed;
	}

	private String _id;
	private int _slotId;
	private int _levelId;
	private int _competencyId;
	private int _rootId;
	private String _slotName;
	private String _aliasName;
	private String _description;
	private int _paId;
	private int _slotNumberOrder;
	private int _levelNumberOrder;
	private int _competencyNumberOrder;
	private int _userId;
	private int _periodId;
	private String _periodName;
	private Date _fromDate;
	private Date _toDate;
	private int _bodUid;
	private int _pmUid;
	private int _ratingOrgId;
	private int _ratingStatus;
	private int _ratingStatusBod;
	private int _ratingStatusPm;
	private String _pointName;
	private String _maxPointName;
	private int _pointValue;
	private int _maxPointValue;
	private boolean _isPassed;
}