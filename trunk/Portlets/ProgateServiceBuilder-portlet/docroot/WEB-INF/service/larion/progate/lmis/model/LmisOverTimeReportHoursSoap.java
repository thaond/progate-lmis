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
import java.util.List;

/**
 * <a href="LmisOverTimeReportHoursSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisOverTimeReportHoursSoap implements Serializable {
	public static LmisOverTimeReportHoursSoap toSoapModel(
		LmisOverTimeReportHours model) {
		LmisOverTimeReportHoursSoap soapModel = new LmisOverTimeReportHoursSoap();

		soapModel.setLmisOverTimeReportHoursId(model.getLmisOverTimeReportHoursId());
		soapModel.setDetailId(model.getDetailId());
		soapModel.setOtType(model.getOtType());
		soapModel.setOtHour(model.getOtHour());
		soapModel.setOtCoefficient(model.getOtCoefficient());
		soapModel.setOtId(model.getOtId());

		return soapModel;
	}

	public static LmisOverTimeReportHoursSoap[] toSoapModels(
		LmisOverTimeReportHours[] models) {
		LmisOverTimeReportHoursSoap[] soapModels = new LmisOverTimeReportHoursSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LmisOverTimeReportHoursSoap[][] toSoapModels(
		LmisOverTimeReportHours[][] models) {
		LmisOverTimeReportHoursSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LmisOverTimeReportHoursSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LmisOverTimeReportHoursSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LmisOverTimeReportHoursSoap[] toSoapModels(
		List<LmisOverTimeReportHours> models) {
		List<LmisOverTimeReportHoursSoap> soapModels = new ArrayList<LmisOverTimeReportHoursSoap>(models.size());

		for (LmisOverTimeReportHours model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LmisOverTimeReportHoursSoap[soapModels.size()]);
	}

	public LmisOverTimeReportHoursSoap() {
	}

	public Integer getPrimaryKey() {
		return _lmisOverTimeReportHoursId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisOverTimeReportHoursId(pk);
	}

	public Integer getLmisOverTimeReportHoursId() {
		return _lmisOverTimeReportHoursId;
	}

	public void setLmisOverTimeReportHoursId(Integer lmisOverTimeReportHoursId) {
		_lmisOverTimeReportHoursId = lmisOverTimeReportHoursId;
	}

	public int getDetailId() {
		return _detailId;
	}

	public void setDetailId(int detailId) {
		_detailId = detailId;
	}

	public String getOtType() {
		return _otType;
	}

	public void setOtType(String otType) {
		_otType = otType;
	}

	public double getOtHour() {
		return _otHour;
	}

	public void setOtHour(double otHour) {
		_otHour = otHour;
	}

	public double getOtCoefficient() {
		return _otCoefficient;
	}

	public void setOtCoefficient(double otCoefficient) {
		_otCoefficient = otCoefficient;
	}

	public int getOtId() {
		return _otId;
	}

	public void setOtId(int otId) {
		_otId = otId;
	}

	private Integer _lmisOverTimeReportHoursId;
	private int _detailId;
	private String _otType;
	private double _otHour;
	private double _otCoefficient;
	private int _otId;
}