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
 * <a href="LmisAbsenceYearlyClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisAbsenceYearlyClp extends BaseModelImpl<LmisAbsenceYearly>
	implements LmisAbsenceYearly {
	public LmisAbsenceYearlyClp() {
	}

	public Integer getPrimaryKey() {
		return _lmisAbsenceYearlyId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisAbsenceYearlyId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _lmisAbsenceYearlyId;
	}

	public Integer getLmisAbsenceYearlyId() {
		return _lmisAbsenceYearlyId;
	}

	public void setLmisAbsenceYearlyId(Integer lmisAbsenceYearlyId) {
		_lmisAbsenceYearlyId = lmisAbsenceYearlyId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public int getYearValue() {
		return _yearValue;
	}

	public void setYearValue(int yearValue) {
		_yearValue = yearValue;
	}

	public int getUserId() {
		return _userId;
	}

	public void setUserId(int userId) {
		_userId = userId;
	}

	public String getAbsenceType() {
		return _absenceType;
	}

	public void setAbsenceType(String absenceType) {
		_absenceType = absenceType;
	}

	public int getAbsenceTypeId() {
		return _absenceTypeId;
	}

	public void setAbsenceTypeId(int absenceTypeId) {
		_absenceTypeId = absenceTypeId;
	}

	public double getTotalDay() {
		return _totalDay;
	}

	public void setTotalDay(double totalDay) {
		_totalDay = totalDay;
	}

	public LmisAbsenceYearly toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			LmisAbsenceYearly model = new LmisAbsenceYearlyClp();

			model.setEscapedModel(true);

			model.setLmisAbsenceYearlyId(getLmisAbsenceYearlyId());
			model.setRootId(getRootId());
			model.setYearValue(getYearValue());
			model.setUserId(getUserId());
			model.setAbsenceType(HtmlUtil.escape(getAbsenceType()));
			model.setAbsenceTypeId(getAbsenceTypeId());
			model.setTotalDay(getTotalDay());

			model = (LmisAbsenceYearly)Proxy.newProxyInstance(LmisAbsenceYearly.class.getClassLoader(),
					new Class[] { LmisAbsenceYearly.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		LmisAbsenceYearlyClp clone = new LmisAbsenceYearlyClp();

		clone.setLmisAbsenceYearlyId(getLmisAbsenceYearlyId());
		clone.setRootId(getRootId());
		clone.setYearValue(getYearValue());
		clone.setUserId(getUserId());
		clone.setAbsenceType(getAbsenceType());
		clone.setAbsenceTypeId(getAbsenceTypeId());
		clone.setTotalDay(getTotalDay());

		return clone;
	}

	public int compareTo(LmisAbsenceYearly lmisAbsenceYearly) {
		Integer pk = lmisAbsenceYearly.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		LmisAbsenceYearlyClp lmisAbsenceYearly = null;

		try {
			lmisAbsenceYearly = (LmisAbsenceYearlyClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = lmisAbsenceYearly.getPrimaryKey();

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

		sb.append("{lmisAbsenceYearlyId=");
		sb.append(getLmisAbsenceYearlyId());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", yearValue=");
		sb.append(getYearValue());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", absenceType=");
		sb.append(getAbsenceType());
		sb.append(", absenceTypeId=");
		sb.append(getAbsenceTypeId());
		sb.append(", totalDay=");
		sb.append(getTotalDay());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.lmis.model.LmisAbsenceYearly");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>lmisAbsenceYearlyId</column-name><column-value><![CDATA[");
		sb.append(getLmisAbsenceYearlyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rootId</column-name><column-value><![CDATA[");
		sb.append(getRootId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>yearValue</column-name><column-value><![CDATA[");
		sb.append(getYearValue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>absenceType</column-name><column-value><![CDATA[");
		sb.append(getAbsenceType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>absenceTypeId</column-name><column-value><![CDATA[");
		sb.append(getAbsenceTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalDay</column-name><column-value><![CDATA[");
		sb.append(getTotalDay());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _lmisAbsenceYearlyId;
	private int _rootId;
	private int _yearValue;
	private int _userId;
	private String _absenceType;
	private int _absenceTypeId;
	private double _totalDay;
}