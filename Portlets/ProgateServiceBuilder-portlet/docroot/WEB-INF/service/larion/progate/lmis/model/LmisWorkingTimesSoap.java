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
 * <a href="LmisWorkingTimesSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisWorkingTimesSoap implements Serializable {
	public static LmisWorkingTimesSoap toSoapModel(LmisWorkingTimes model) {
		LmisWorkingTimesSoap soapModel = new LmisWorkingTimesSoap();

		soapModel.setLmisWorkingTimeId(model.getLmisWorkingTimeId());
		soapModel.setRootId(model.getRootId());
		soapModel.setSessionName(model.getSessionName());
		soapModel.setStartTime(model.getStartTime());
		soapModel.setEndTime(model.getEndTime());
		soapModel.setLimitLate(model.getLimitLate());
		soapModel.setMaxLate(model.getMaxLate());
		soapModel.setCoefficientLate(model.getCoefficientLate());
		soapModel.setLimitEarly(model.getLimitEarly());
		soapModel.setMaxEarly(model.getMaxEarly());
		soapModel.setCoefficientEarly(model.getCoefficientEarly());

		return soapModel;
	}

	public static LmisWorkingTimesSoap[] toSoapModels(LmisWorkingTimes[] models) {
		LmisWorkingTimesSoap[] soapModels = new LmisWorkingTimesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LmisWorkingTimesSoap[][] toSoapModels(
		LmisWorkingTimes[][] models) {
		LmisWorkingTimesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LmisWorkingTimesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LmisWorkingTimesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LmisWorkingTimesSoap[] toSoapModels(
		List<LmisWorkingTimes> models) {
		List<LmisWorkingTimesSoap> soapModels = new ArrayList<LmisWorkingTimesSoap>(models.size());

		for (LmisWorkingTimes model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LmisWorkingTimesSoap[soapModels.size()]);
	}

	public LmisWorkingTimesSoap() {
	}

	public Integer getPrimaryKey() {
		return _lmisWorkingTimeId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisWorkingTimeId(pk);
	}

	public Integer getLmisWorkingTimeId() {
		return _lmisWorkingTimeId;
	}

	public void setLmisWorkingTimeId(Integer lmisWorkingTimeId) {
		_lmisWorkingTimeId = lmisWorkingTimeId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public String getSessionName() {
		return _sessionName;
	}

	public void setSessionName(String sessionName) {
		_sessionName = sessionName;
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

	public int getLimitLate() {
		return _limitLate;
	}

	public void setLimitLate(int limitLate) {
		_limitLate = limitLate;
	}

	public int getMaxLate() {
		return _maxLate;
	}

	public void setMaxLate(int maxLate) {
		_maxLate = maxLate;
	}

	public double getCoefficientLate() {
		return _coefficientLate;
	}

	public void setCoefficientLate(double coefficientLate) {
		_coefficientLate = coefficientLate;
	}

	public int getLimitEarly() {
		return _limitEarly;
	}

	public void setLimitEarly(int limitEarly) {
		_limitEarly = limitEarly;
	}

	public int getMaxEarly() {
		return _maxEarly;
	}

	public void setMaxEarly(int maxEarly) {
		_maxEarly = maxEarly;
	}

	public double getCoefficientEarly() {
		return _coefficientEarly;
	}

	public void setCoefficientEarly(double coefficientEarly) {
		_coefficientEarly = coefficientEarly;
	}

	private Integer _lmisWorkingTimeId;
	private int _rootId;
	private String _sessionName;
	private Date _startTime;
	private Date _endTime;
	private int _limitLate;
	private int _maxLate;
	private double _coefficientLate;
	private int _limitEarly;
	private int _maxEarly;
	private double _coefficientEarly;
}