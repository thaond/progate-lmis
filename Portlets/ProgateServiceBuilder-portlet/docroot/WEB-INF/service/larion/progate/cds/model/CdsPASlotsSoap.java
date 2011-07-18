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
import java.util.List;

/**
 * <a href="CdsPASlotsSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsPASlotsSoap implements Serializable {
	public static CdsPASlotsSoap toSoapModel(CdsPASlots model) {
		CdsPASlotsSoap soapModel = new CdsPASlotsSoap();

		soapModel.setCdsPASlotsId(model.getCdsPASlotsId());
		soapModel.setPaId(model.getPaId());
		soapModel.setRootId(model.getRootId());
		soapModel.setPeriodId(model.getPeriodId());
		soapModel.setUserId(model.getUserId());
		soapModel.setSlotId(model.getSlotId());
		soapModel.setPmUid(model.getPmUid());
		soapModel.setBodUid(model.getBodUid());
		soapModel.setRatingOrgId(model.getRatingOrgId());
		soapModel.setRatingStatus(model.getRatingStatus());
		soapModel.setRatingStatusPm(model.getRatingStatusPm());
		soapModel.setRatingStatusBod(model.getRatingStatusBod());
		soapModel.setPointName(model.getPointName());
		soapModel.setMaxPointName(model.getMaxPointName());
		soapModel.setPointValue(model.getPointValue());
		soapModel.setMaxPointValue(model.getMaxPointValue());
		soapModel.setIsPassed(model.getIsPassed());

		return soapModel;
	}

	public static CdsPASlotsSoap[] toSoapModels(CdsPASlots[] models) {
		CdsPASlotsSoap[] soapModels = new CdsPASlotsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CdsPASlotsSoap[][] toSoapModels(CdsPASlots[][] models) {
		CdsPASlotsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CdsPASlotsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CdsPASlotsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CdsPASlotsSoap[] toSoapModels(List<CdsPASlots> models) {
		List<CdsPASlotsSoap> soapModels = new ArrayList<CdsPASlotsSoap>(models.size());

		for (CdsPASlots model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CdsPASlotsSoap[soapModels.size()]);
	}

	public CdsPASlotsSoap() {
	}

	public Integer getPrimaryKey() {
		return _CdsPASlotsId;
	}

	public void setPrimaryKey(Integer pk) {
		setCdsPASlotsId(pk);
	}

	public Integer getCdsPASlotsId() {
		return _CdsPASlotsId;
	}

	public void setCdsPASlotsId(Integer CdsPASlotsId) {
		_CdsPASlotsId = CdsPASlotsId;
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

	public int getPmUid() {
		return _pmUid;
	}

	public void setPmUid(int pmUid) {
		_pmUid = pmUid;
	}

	public int getBodUid() {
		return _bodUid;
	}

	public void setBodUid(int bodUid) {
		_bodUid = bodUid;
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

	private Integer _CdsPASlotsId;
	private int _paId;
	private int _rootId;
	private int _periodId;
	private int _userId;
	private int _slotId;
	private int _pmUid;
	private int _bodUid;
	private int _ratingOrgId;
	private int _ratingStatus;
	private int _ratingStatusPm;
	private int _ratingStatusBod;
	private String _pointName;
	private String _maxPointName;
	private int _pointValue;
	private int _maxPointValue;
	private boolean _isPassed;
}