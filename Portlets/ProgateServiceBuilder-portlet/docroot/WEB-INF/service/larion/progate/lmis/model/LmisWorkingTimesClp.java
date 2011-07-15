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

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * <a href="LmisWorkingTimesClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisWorkingTimesClp extends BaseModelImpl<LmisWorkingTimes>
	implements LmisWorkingTimes {
	public LmisWorkingTimesClp() {
	}

	public Integer getPrimaryKey() {
		return _lmisWorkingTimeId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisWorkingTimeId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _lmisWorkingTimeId;
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

	public LmisWorkingTimes toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			LmisWorkingTimes model = new LmisWorkingTimesClp();

			model.setEscapedModel(true);

			model.setLmisWorkingTimeId(getLmisWorkingTimeId());
			model.setRootId(getRootId());
			model.setSessionName(HtmlUtil.escape(getSessionName()));
			model.setStartTime(getStartTime());
			model.setEndTime(getEndTime());
			model.setLimitLate(getLimitLate());
			model.setMaxLate(getMaxLate());
			model.setCoefficientLate(getCoefficientLate());
			model.setLimitEarly(getLimitEarly());
			model.setMaxEarly(getMaxEarly());
			model.setCoefficientEarly(getCoefficientEarly());

			model = (LmisWorkingTimes)Proxy.newProxyInstance(LmisWorkingTimes.class.getClassLoader(),
					new Class[] { LmisWorkingTimes.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		LmisWorkingTimesClp clone = new LmisWorkingTimesClp();

		clone.setLmisWorkingTimeId(getLmisWorkingTimeId());
		clone.setRootId(getRootId());
		clone.setSessionName(getSessionName());
		clone.setStartTime(getStartTime());
		clone.setEndTime(getEndTime());
		clone.setLimitLate(getLimitLate());
		clone.setMaxLate(getMaxLate());
		clone.setCoefficientLate(getCoefficientLate());
		clone.setLimitEarly(getLimitEarly());
		clone.setMaxEarly(getMaxEarly());
		clone.setCoefficientEarly(getCoefficientEarly());

		return clone;
	}

	public int compareTo(LmisWorkingTimes lmisWorkingTimes) {
		Integer pk = lmisWorkingTimes.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		LmisWorkingTimesClp lmisWorkingTimes = null;

		try {
			lmisWorkingTimes = (LmisWorkingTimesClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = lmisWorkingTimes.getPrimaryKey();

		if (getPrimaryKey().equals(pk)) {
			return true;
		}
		else {
			return false;
		}
	}

	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("{lmisWorkingTimeId=");
		sb.append(getLmisWorkingTimeId());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", sessionName=");
		sb.append(getSessionName());
		sb.append(", startTime=");
		sb.append(getStartTime());
		sb.append(", endTime=");
		sb.append(getEndTime());
		sb.append(", limitLate=");
		sb.append(getLimitLate());
		sb.append(", maxLate=");
		sb.append(getMaxLate());
		sb.append(", coefficientLate=");
		sb.append(getCoefficientLate());
		sb.append(", limitEarly=");
		sb.append(getLimitEarly());
		sb.append(", maxEarly=");
		sb.append(getMaxEarly());
		sb.append(", coefficientEarly=");
		sb.append(getCoefficientEarly());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.lmis.model.LmisWorkingTimes");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>lmisWorkingTimeId</column-name><column-value><![CDATA[");
		sb.append(getLmisWorkingTimeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rootId</column-name><column-value><![CDATA[");
		sb.append(getRootId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sessionName</column-name><column-value><![CDATA[");
		sb.append(getSessionName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startTime</column-name><column-value><![CDATA[");
		sb.append(getStartTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endTime</column-name><column-value><![CDATA[");
		sb.append(getEndTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>limitLate</column-name><column-value><![CDATA[");
		sb.append(getLimitLate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maxLate</column-name><column-value><![CDATA[");
		sb.append(getMaxLate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>coefficientLate</column-name><column-value><![CDATA[");
		sb.append(getCoefficientLate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>limitEarly</column-name><column-value><![CDATA[");
		sb.append(getLimitEarly());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maxEarly</column-name><column-value><![CDATA[");
		sb.append(getMaxEarly());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>coefficientEarly</column-name><column-value><![CDATA[");
		sb.append(getCoefficientEarly());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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