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
 * <a href="LmisOvertimeMonthlyClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisOvertimeMonthlyClp extends BaseModelImpl<LmisOvertimeMonthly>
	implements LmisOvertimeMonthly {
	public LmisOvertimeMonthlyClp() {
	}

	public Integer getPrimaryKey() {
		return _lmisOvertimeMonthlyId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisOvertimeMonthlyId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _lmisOvertimeMonthlyId;
	}

	public Integer getLmisOvertimeMonthlyId() {
		return _lmisOvertimeMonthlyId;
	}

	public void setLmisOvertimeMonthlyId(Integer lmisOvertimeMonthlyId) {
		_lmisOvertimeMonthlyId = lmisOvertimeMonthlyId;
	}

	public int getMonthValue() {
		return _monthValue;
	}

	public void setMonthValue(int monthValue) {
		_monthValue = monthValue;
	}

	public int getYearValue() {
		return _yearValue;
	}

	public void setYearValue(int yearValue) {
		_yearValue = yearValue;
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

	public String getOtType() {
		return _otType;
	}

	public void setOtType(String otType) {
		_otType = otType;
	}

	public int getOtId() {
		return _otId;
	}

	public void setOtId(int otId) {
		_otId = otId;
	}

	public double getTotalHour() {
		return _totalHour;
	}

	public void setTotalHour(double totalHour) {
		_totalHour = totalHour;
	}

	public double getTotalHourFinal() {
		return _totalHourFinal;
	}

	public void setTotalHourFinal(double totalHourFinal) {
		_totalHourFinal = totalHourFinal;
	}

	public int getOrgId() {
		return _orgId;
	}

	public void setOrgId(int orgId) {
		_orgId = orgId;
	}

	public LmisOvertimeMonthly toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			LmisOvertimeMonthly model = new LmisOvertimeMonthlyClp();

			model.setEscapedModel(true);

			model.setLmisOvertimeMonthlyId(getLmisOvertimeMonthlyId());
			model.setMonthValue(getMonthValue());
			model.setYearValue(getYearValue());
			model.setRootId(getRootId());
			model.setUserId(getUserId());
			model.setOtType(HtmlUtil.escape(getOtType()));
			model.setOtId(getOtId());
			model.setTotalHour(getTotalHour());
			model.setTotalHourFinal(getTotalHourFinal());
			model.setOrgId(getOrgId());

			model = (LmisOvertimeMonthly)Proxy.newProxyInstance(LmisOvertimeMonthly.class.getClassLoader(),
					new Class[] { LmisOvertimeMonthly.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		LmisOvertimeMonthlyClp clone = new LmisOvertimeMonthlyClp();

		clone.setLmisOvertimeMonthlyId(getLmisOvertimeMonthlyId());
		clone.setMonthValue(getMonthValue());
		clone.setYearValue(getYearValue());
		clone.setRootId(getRootId());
		clone.setUserId(getUserId());
		clone.setOtType(getOtType());
		clone.setOtId(getOtId());
		clone.setTotalHour(getTotalHour());
		clone.setTotalHourFinal(getTotalHourFinal());
		clone.setOrgId(getOrgId());

		return clone;
	}

	public int compareTo(LmisOvertimeMonthly lmisOvertimeMonthly) {
		Integer pk = lmisOvertimeMonthly.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		LmisOvertimeMonthlyClp lmisOvertimeMonthly = null;

		try {
			lmisOvertimeMonthly = (LmisOvertimeMonthlyClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = lmisOvertimeMonthly.getPrimaryKey();

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

		sb.append("{lmisOvertimeMonthlyId=");
		sb.append(getLmisOvertimeMonthlyId());
		sb.append(", monthValue=");
		sb.append(getMonthValue());
		sb.append(", yearValue=");
		sb.append(getYearValue());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", otType=");
		sb.append(getOtType());
		sb.append(", otId=");
		sb.append(getOtId());
		sb.append(", totalHour=");
		sb.append(getTotalHour());
		sb.append(", totalHourFinal=");
		sb.append(getTotalHourFinal());
		sb.append(", orgId=");
		sb.append(getOrgId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.lmis.model.LmisOvertimeMonthly");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>lmisOvertimeMonthlyId</column-name><column-value><![CDATA[");
		sb.append(getLmisOvertimeMonthlyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>monthValue</column-name><column-value><![CDATA[");
		sb.append(getMonthValue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>yearValue</column-name><column-value><![CDATA[");
		sb.append(getYearValue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rootId</column-name><column-value><![CDATA[");
		sb.append(getRootId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>otType</column-name><column-value><![CDATA[");
		sb.append(getOtType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>otId</column-name><column-value><![CDATA[");
		sb.append(getOtId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalHour</column-name><column-value><![CDATA[");
		sb.append(getTotalHour());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalHourFinal</column-name><column-value><![CDATA[");
		sb.append(getTotalHourFinal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orgId</column-name><column-value><![CDATA[");
		sb.append(getOrgId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _lmisOvertimeMonthlyId;
	private int _monthValue;
	private int _yearValue;
	private int _rootId;
	private int _userId;
	private String _otType;
	private int _otId;
	private double _totalHour;
	private double _totalHourFinal;
	private int _orgId;
}