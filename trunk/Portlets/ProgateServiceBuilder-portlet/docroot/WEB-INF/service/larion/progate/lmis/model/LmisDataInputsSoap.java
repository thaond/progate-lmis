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
import java.util.Date;
import java.util.List;

/**
 * <a href="LmisDataInputsSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisDataInputsSoap implements Serializable {
	public static LmisDataInputsSoap toSoapModel(LmisDataInputs model) {
		LmisDataInputsSoap soapModel = new LmisDataInputsSoap();

		soapModel.setLmisDataInputsId(model.getLmisDataInputsId());
		soapModel.setRootId(model.getRootId());
		soapModel.setUserId(model.getUserId());
		soapModel.setDayValue(model.getDayValue());
		soapModel.setStartTime(model.getStartTime());
		soapModel.setEndTime(model.getEndTime());
		soapModel.setInputBy(model.getInputBy());
		soapModel.setInputAt(model.getInputAt());

		return soapModel;
	}

	public static LmisDataInputsSoap[] toSoapModels(LmisDataInputs[] models) {
		LmisDataInputsSoap[] soapModels = new LmisDataInputsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LmisDataInputsSoap[][] toSoapModels(LmisDataInputs[][] models) {
		LmisDataInputsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LmisDataInputsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LmisDataInputsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LmisDataInputsSoap[] toSoapModels(List<LmisDataInputs> models) {
		List<LmisDataInputsSoap> soapModels = new ArrayList<LmisDataInputsSoap>(models.size());

		for (LmisDataInputs model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LmisDataInputsSoap[soapModels.size()]);
	}

	public LmisDataInputsSoap() {
	}

	public Integer getPrimaryKey() {
		return _lmisDataInputsId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisDataInputsId(pk);
	}

	public Integer getLmisDataInputsId() {
		return _lmisDataInputsId;
	}

	public void setLmisDataInputsId(Integer lmisDataInputsId) {
		_lmisDataInputsId = lmisDataInputsId;
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

	public Date getDayValue() {
		return _dayValue;
	}

	public void setDayValue(Date dayValue) {
		_dayValue = dayValue;
	}

	public Date getStartTime() {
		return _startTime;
	}

	public void setStartTime(Date startTime) {
		_startTime = startTime;
	}

	public Date getEndTime() {
		return _endTime;
	}

	public void setEndTime(Date endTime) {
		_endTime = endTime;
	}

	public int getInputBy() {
		return _inputBy;
	}

	public void setInputBy(int inputBy) {
		_inputBy = inputBy;
	}

	public Date getInputAt() {
		return _inputAt;
	}

	public void setInputAt(Date inputAt) {
		_inputAt = inputAt;
	}

	private Integer _lmisDataInputsId;
	private int _rootId;
	private int _userId;
	private Date _dayValue;
	private Date _startTime;
	private Date _endTime;
	private int _inputBy;
	private Date _inputAt;
}