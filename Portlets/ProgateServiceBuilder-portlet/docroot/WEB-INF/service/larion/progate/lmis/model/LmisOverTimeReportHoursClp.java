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

/**
 * <a href="LmisOverTimeReportHoursClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisOverTimeReportHoursClp extends BaseModelImpl<LmisOverTimeReportHours>
	implements LmisOverTimeReportHours {
	public LmisOverTimeReportHoursClp() {
	}

	public Integer getPrimaryKey() {
		return _lmisOverTimeReportHoursId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisOverTimeReportHoursId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _lmisOverTimeReportHoursId;
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

	public LmisOverTimeReportHours toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			LmisOverTimeReportHours model = new LmisOverTimeReportHoursClp();

			model.setEscapedModel(true);

			model.setLmisOverTimeReportHoursId(getLmisOverTimeReportHoursId());
			model.setDetailId(getDetailId());
			model.setOtType(HtmlUtil.escape(getOtType()));
			model.setOtHour(getOtHour());
			model.setOtCoefficient(getOtCoefficient());
			model.setOtId(getOtId());

			model = (LmisOverTimeReportHours)Proxy.newProxyInstance(LmisOverTimeReportHours.class.getClassLoader(),
					new Class[] { LmisOverTimeReportHours.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		LmisOverTimeReportHoursClp clone = new LmisOverTimeReportHoursClp();

		clone.setLmisOverTimeReportHoursId(getLmisOverTimeReportHoursId());
		clone.setDetailId(getDetailId());
		clone.setOtType(getOtType());
		clone.setOtHour(getOtHour());
		clone.setOtCoefficient(getOtCoefficient());
		clone.setOtId(getOtId());

		return clone;
	}

	public int compareTo(LmisOverTimeReportHours lmisOverTimeReportHours) {
		Integer pk = lmisOverTimeReportHours.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		LmisOverTimeReportHoursClp lmisOverTimeReportHours = null;

		try {
			lmisOverTimeReportHours = (LmisOverTimeReportHoursClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = lmisOverTimeReportHours.getPrimaryKey();

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

		sb.append("{lmisOverTimeReportHoursId=");
		sb.append(getLmisOverTimeReportHoursId());
		sb.append(", detailId=");
		sb.append(getDetailId());
		sb.append(", otType=");
		sb.append(getOtType());
		sb.append(", otHour=");
		sb.append(getOtHour());
		sb.append(", otCoefficient=");
		sb.append(getOtCoefficient());
		sb.append(", otId=");
		sb.append(getOtId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.lmis.model.LmisOverTimeReportHours");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>lmisOverTimeReportHoursId</column-name><column-value><![CDATA[");
		sb.append(getLmisOverTimeReportHoursId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>detailId</column-name><column-value><![CDATA[");
		sb.append(getDetailId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>otType</column-name><column-value><![CDATA[");
		sb.append(getOtType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>otHour</column-name><column-value><![CDATA[");
		sb.append(getOtHour());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>otCoefficient</column-name><column-value><![CDATA[");
		sb.append(getOtCoefficient());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>otId</column-name><column-value><![CDATA[");
		sb.append(getOtId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _lmisOverTimeReportHoursId;
	private int _detailId;
	private String _otType;
	private double _otHour;
	private double _otCoefficient;
	private int _otId;
}