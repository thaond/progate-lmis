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
 * <a href="CdsPAFinalSlotsSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsPAFinalSlotsSoap implements Serializable {
	public static CdsPAFinalSlotsSoap toSoapModel(CdsPAFinalSlots model) {
		CdsPAFinalSlotsSoap soapModel = new CdsPAFinalSlotsSoap();

		soapModel.setCdsPAFinalSlotsId(model.getCdsPAFinalSlotsId());
		soapModel.setPaId(model.getPaId());
		soapModel.setRootId(model.getRootId());
		soapModel.setUserId(model.getUserId());
		soapModel.setSlotId(model.getSlotId());
		soapModel.setRatingStatus(model.getRatingStatus());
		soapModel.setPointName(model.getPointName());
		soapModel.setMaxPointName(model.getMaxPointName());
		soapModel.setPointValue(model.getPointValue());
		soapModel.setMaxPointValue(model.getMaxPointValue());
		soapModel.setIsPassed(model.getIsPassed());

		return soapModel;
	}

	public static CdsPAFinalSlotsSoap[] toSoapModels(CdsPAFinalSlots[] models) {
		CdsPAFinalSlotsSoap[] soapModels = new CdsPAFinalSlotsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CdsPAFinalSlotsSoap[][] toSoapModels(
		CdsPAFinalSlots[][] models) {
		CdsPAFinalSlotsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CdsPAFinalSlotsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CdsPAFinalSlotsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CdsPAFinalSlotsSoap[] toSoapModels(
		List<CdsPAFinalSlots> models) {
		List<CdsPAFinalSlotsSoap> soapModels = new ArrayList<CdsPAFinalSlotsSoap>(models.size());

		for (CdsPAFinalSlots model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CdsPAFinalSlotsSoap[soapModels.size()]);
	}

	public CdsPAFinalSlotsSoap() {
	}

	public Integer getPrimaryKey() {
		return _CdsPAFinalSlotsId;
	}

	public void setPrimaryKey(Integer pk) {
		setCdsPAFinalSlotsId(pk);
	}

	public Integer getCdsPAFinalSlotsId() {
		return _CdsPAFinalSlotsId;
	}

	public void setCdsPAFinalSlotsId(Integer CdsPAFinalSlotsId) {
		_CdsPAFinalSlotsId = CdsPAFinalSlotsId;
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

	public boolean getRatingStatus() {
		return _ratingStatus;
	}

	public boolean isRatingStatus() {
		return _ratingStatus;
	}

	public void setRatingStatus(boolean ratingStatus) {
		_ratingStatus = ratingStatus;
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

	private Integer _CdsPAFinalSlotsId;
	private int _paId;
	private int _rootId;
	private int _userId;
	private int _slotId;
	private boolean _ratingStatus;
	private String _pointName;
	private String _maxPointName;
	private int _pointValue;
	private int _maxPointValue;
	private boolean _isPassed;
}