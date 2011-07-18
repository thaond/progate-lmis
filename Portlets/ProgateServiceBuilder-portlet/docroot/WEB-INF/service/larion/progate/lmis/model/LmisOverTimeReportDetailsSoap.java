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
 * <a href="LmisOverTimeReportDetailsSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisOverTimeReportDetailsSoap implements Serializable {
	public static LmisOverTimeReportDetailsSoap toSoapModel(
		LmisOverTimeReportDetails model) {
		LmisOverTimeReportDetailsSoap soapModel = new LmisOverTimeReportDetailsSoap();

		soapModel.setLmisOverTimeReportDetailsId(model.getLmisOverTimeReportDetailsId());
		soapModel.setRootId(model.getRootId());
		soapModel.setReportId(model.getReportId());
		soapModel.setUserId(model.getUserId());
		soapModel.setStartTime(model.getStartTime());
		soapModel.setEndTime(model.getEndTime());
		soapModel.setTotalHour(model.getTotalHour());

		return soapModel;
	}

	public static LmisOverTimeReportDetailsSoap[] toSoapModels(
		LmisOverTimeReportDetails[] models) {
		LmisOverTimeReportDetailsSoap[] soapModels = new LmisOverTimeReportDetailsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LmisOverTimeReportDetailsSoap[][] toSoapModels(
		LmisOverTimeReportDetails[][] models) {
		LmisOverTimeReportDetailsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LmisOverTimeReportDetailsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LmisOverTimeReportDetailsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LmisOverTimeReportDetailsSoap[] toSoapModels(
		List<LmisOverTimeReportDetails> models) {
		List<LmisOverTimeReportDetailsSoap> soapModels = new ArrayList<LmisOverTimeReportDetailsSoap>(models.size());

		for (LmisOverTimeReportDetails model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LmisOverTimeReportDetailsSoap[soapModels.size()]);
	}

	public LmisOverTimeReportDetailsSoap() {
	}

	public Integer getPrimaryKey() {
		return _lmisOverTimeReportDetailsId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisOverTimeReportDetailsId(pk);
	}

	public Integer getLmisOverTimeReportDetailsId() {
		return _lmisOverTimeReportDetailsId;
	}

	public void setLmisOverTimeReportDetailsId(
		Integer lmisOverTimeReportDetailsId) {
		_lmisOverTimeReportDetailsId = lmisOverTimeReportDetailsId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public int getReportId() {
		return _reportId;
	}

	public void setReportId(int reportId) {
		_reportId = reportId;
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

	public double getTotalHour() {
		return _totalHour;
	}

	public void setTotalHour(double totalHour) {
		_totalHour = totalHour;
	}

	private Integer _lmisOverTimeReportDetailsId;
	private int _rootId;
	private int _reportId;
	private int _userId;
	private Date _startTime;
	private Date _endTime;
	private double _totalHour;
}