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
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * <a href="LmisDataInputsClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisDataInputsClp extends BaseModelImpl<LmisDataInputs>
	implements LmisDataInputs {
	public LmisDataInputsClp() {
	}

	public Integer getPrimaryKey() {
		return _lmisDataInputsId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisDataInputsId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _lmisDataInputsId;
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

	public LmisDataInputs toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			LmisDataInputs model = new LmisDataInputsClp();

			model.setEscapedModel(true);

			model.setLmisDataInputsId(getLmisDataInputsId());
			model.setRootId(getRootId());
			model.setUserId(getUserId());
			model.setDayValue(getDayValue());
			model.setStartTime(getStartTime());
			model.setEndTime(getEndTime());
			model.setInputBy(getInputBy());
			model.setInputAt(getInputAt());

			model = (LmisDataInputs)Proxy.newProxyInstance(LmisDataInputs.class.getClassLoader(),
					new Class[] { LmisDataInputs.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		LmisDataInputsClp clone = new LmisDataInputsClp();

		clone.setLmisDataInputsId(getLmisDataInputsId());
		clone.setRootId(getRootId());
		clone.setUserId(getUserId());
		clone.setDayValue(getDayValue());
		clone.setStartTime(getStartTime());
		clone.setEndTime(getEndTime());
		clone.setInputBy(getInputBy());
		clone.setInputAt(getInputAt());

		return clone;
	}

	public int compareTo(LmisDataInputs lmisDataInputs) {
		Integer pk = lmisDataInputs.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		LmisDataInputsClp lmisDataInputs = null;

		try {
			lmisDataInputs = (LmisDataInputsClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = lmisDataInputs.getPrimaryKey();

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

		sb.append("{lmisDataInputsId=");
		sb.append(getLmisDataInputsId());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", dayValue=");
		sb.append(getDayValue());
		sb.append(", startTime=");
		sb.append(getStartTime());
		sb.append(", endTime=");
		sb.append(getEndTime());
		sb.append(", inputBy=");
		sb.append(getInputBy());
		sb.append(", inputAt=");
		sb.append(getInputAt());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.lmis.model.LmisDataInputs");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>lmisDataInputsId</column-name><column-value><![CDATA[");
		sb.append(getLmisDataInputsId());
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
			"<column><column-name>dayValue</column-name><column-value><![CDATA[");
		sb.append(getDayValue());
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
			"<column><column-name>inputBy</column-name><column-value><![CDATA[");
		sb.append(getInputBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>inputAt</column-name><column-value><![CDATA[");
		sb.append(getInputAt());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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