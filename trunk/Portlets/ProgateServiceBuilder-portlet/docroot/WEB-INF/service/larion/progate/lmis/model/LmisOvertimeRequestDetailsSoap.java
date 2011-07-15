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
 * <a href="LmisOvertimeRequestDetailsSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisOvertimeRequestDetailsSoap implements Serializable {
	public static LmisOvertimeRequestDetailsSoap toSoapModel(
		LmisOvertimeRequestDetails model) {
		LmisOvertimeRequestDetailsSoap soapModel = new LmisOvertimeRequestDetailsSoap();

		soapModel.setLmisOvertimeRequestDetailsId(model.getLmisOvertimeRequestDetailsId());
		soapModel.setRootId(model.getRootId());
		soapModel.setRequestId(model.getRequestId());
		soapModel.setUserId(model.getUserId());
		soapModel.setStartTime(model.getStartTime());
		soapModel.setEndTime(model.getEndTime());
		soapModel.setRequestedReason(model.getRequestedReason());
		soapModel.setRequestedHour(model.getRequestedHour());

		return soapModel;
	}

	public static LmisOvertimeRequestDetailsSoap[] toSoapModels(
		LmisOvertimeRequestDetails[] models) {
		LmisOvertimeRequestDetailsSoap[] soapModels = new LmisOvertimeRequestDetailsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LmisOvertimeRequestDetailsSoap[][] toSoapModels(
		LmisOvertimeRequestDetails[][] models) {
		LmisOvertimeRequestDetailsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LmisOvertimeRequestDetailsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LmisOvertimeRequestDetailsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LmisOvertimeRequestDetailsSoap[] toSoapModels(
		List<LmisOvertimeRequestDetails> models) {
		List<LmisOvertimeRequestDetailsSoap> soapModels = new ArrayList<LmisOvertimeRequestDetailsSoap>(models.size());

		for (LmisOvertimeRequestDetails model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LmisOvertimeRequestDetailsSoap[soapModels.size()]);
	}

	public LmisOvertimeRequestDetailsSoap() {
	}

	public Integer getPrimaryKey() {
		return _lmisOvertimeRequestDetailsId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisOvertimeRequestDetailsId(pk);
	}

	public Integer getLmisOvertimeRequestDetailsId() {
		return _lmisOvertimeRequestDetailsId;
	}

	public void setLmisOvertimeRequestDetailsId(
		Integer lmisOvertimeRequestDetailsId) {
		_lmisOvertimeRequestDetailsId = lmisOvertimeRequestDetailsId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public int getRequestId() {
		return _requestId;
	}

	public void setRequestId(int requestId) {
		_requestId = requestId;
	}

	public int getUserId() {
		return _userId;
	}

	public void setUserId(int userId) {
		_userId = userId;
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

	public String getRequestedReason() {
		return _requestedReason;
	}

	public void setRequestedReason(String requestedReason) {
		_requestedReason = requestedReason;
	}

	public double getRequestedHour() {
		return _requestedHour;
	}

	public void setRequestedHour(double requestedHour) {
		_requestedHour = requestedHour;
	}

	private Integer _lmisOvertimeRequestDetailsId;
	private int _rootId;
	private int _requestId;
	private int _userId;
	private Date _startTime;
	private Date _endTime;
	private String _requestedReason;
	private double _requestedHour;
}