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
 * <a href="CdsPerformanceAppraisalSlotRatingSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsPerformanceAppraisalSlotRatingSoap implements Serializable {
	public static CdsPerformanceAppraisalSlotRatingSoap toSoapModel(
		CdsPerformanceAppraisalSlotRating model) {
		CdsPerformanceAppraisalSlotRatingSoap soapModel = new CdsPerformanceAppraisalSlotRatingSoap();

		soapModel.setCdsPerformanceAppraisalSlotRatingId(model.getCdsPerformanceAppraisalSlotRatingId());
		soapModel.setPaId(model.getPaId());
		soapModel.setRootId(model.getRootId());
		soapModel.setPeriodId(model.getPeriodId());
		soapModel.setUserId(model.getUserId());
		soapModel.setSlotId(model.getSlotId());
		soapModel.setRatingBy(model.getRatingBy());
		soapModel.setRatingAt(model.getRatingAt());
		soapModel.setRatingStatus(model.getRatingStatus());
		soapModel.setUserType(model.getUserType());
		soapModel.setPointName(model.getPointName());
		soapModel.setPointValue(model.getPointValue());
		soapModel.setRatingOrgId(model.getRatingOrgId());

		return soapModel;
	}

	public static CdsPerformanceAppraisalSlotRatingSoap[] toSoapModels(
		CdsPerformanceAppraisalSlotRating[] models) {
		CdsPerformanceAppraisalSlotRatingSoap[] soapModels = new CdsPerformanceAppraisalSlotRatingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CdsPerformanceAppraisalSlotRatingSoap[][] toSoapModels(
		CdsPerformanceAppraisalSlotRating[][] models) {
		CdsPerformanceAppraisalSlotRatingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CdsPerformanceAppraisalSlotRatingSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CdsPerformanceAppraisalSlotRatingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CdsPerformanceAppraisalSlotRatingSoap[] toSoapModels(
		List<CdsPerformanceAppraisalSlotRating> models) {
		List<CdsPerformanceAppraisalSlotRatingSoap> soapModels = new ArrayList<CdsPerformanceAppraisalSlotRatingSoap>(models.size());

		for (CdsPerformanceAppraisalSlotRating model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CdsPerformanceAppraisalSlotRatingSoap[soapModels.size()]);
	}

	public CdsPerformanceAppraisalSlotRatingSoap() {
	}

	public Integer getPrimaryKey() {
		return _CdsPerformanceAppraisalSlotRatingId;
	}

	public void setPrimaryKey(Integer pk) {
		setCdsPerformanceAppraisalSlotRatingId(pk);
	}

	public Integer getCdsPerformanceAppraisalSlotRatingId() {
		return _CdsPerformanceAppraisalSlotRatingId;
	}

	public void setCdsPerformanceAppraisalSlotRatingId(
		Integer CdsPerformanceAppraisalSlotRatingId) {
		_CdsPerformanceAppraisalSlotRatingId = CdsPerformanceAppraisalSlotRatingId;
	}

	public int getPaId() {
		return _paId;
	}

	public void setPaId(int paId) {
		_paId = paId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
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

	public int getSlotId() {
		return _slotId;
	}

	public void setSlotId(int slotId) {
		_slotId = slotId;
	}

	public int getRatingBy() {
		return _ratingBy;
	}

	public void setRatingBy(int ratingBy) {
		_ratingBy = ratingBy;
	}

	public Date getRatingAt() {
		return _ratingAt;
	}

	public void setRatingAt(Date ratingAt) {
		_ratingAt = ratingAt;
	}

	public boolean getRatingStatus() {
		return _ratingStatus;
	}

	public boolean isRatingStatus() {
		return _ratingStatus;
	}

	public void setRatingStatus(boolean ratingStatus) {
		_ratingStatus = ratingStatus;
	}

	public int getUserType() {
		return _userType;
	}

	public void setUserType(int userType) {
		_userType = userType;
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

	public int getRatingOrgId() {
		return _ratingOrgId;
	}

	public void setRatingOrgId(int ratingOrgId) {
		_ratingOrgId = ratingOrgId;
	}

	private Integer _CdsPerformanceAppraisalSlotRatingId;
	private int _paId;
	private int _rootId;
	private int _periodId;
	private int _userId;
	private int _slotId;
	private int _ratingBy;
	private Date _ratingAt;
	private boolean _ratingStatus;
	private int _userType;
	private String _pointName;
	private int _pointValue;
	private int _ratingOrgId;
}