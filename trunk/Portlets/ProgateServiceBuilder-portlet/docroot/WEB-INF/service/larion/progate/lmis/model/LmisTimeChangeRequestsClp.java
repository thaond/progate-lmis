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
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * <a href="LmisTimeChangeRequestsClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisTimeChangeRequestsClp extends BaseModelImpl<LmisTimeChangeRequests>
	implements LmisTimeChangeRequests {
	public LmisTimeChangeRequestsClp() {
	}

	public Integer getPrimaryKey() {
		return _lmisTimeChangeRequestId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisTimeChangeRequestId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _lmisTimeChangeRequestId;
	}

	public Integer getLmisTimeChangeRequestId() {
		return _lmisTimeChangeRequestId;
	}

	public void setLmisTimeChangeRequestId(Integer lmisTimeChangeRequestId) {
		_lmisTimeChangeRequestId = lmisTimeChangeRequestId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public int getRequestedBy() {
		return _requestedBy;
	}

	public void setRequestedBy(int requestedBy) {
		_requestedBy = requestedBy;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public boolean getMonSelected() {
		return _monSelected;
	}

	public boolean isMonSelected() {
		return _monSelected;
	}

	public void setMonSelected(boolean monSelected) {
		_monSelected = monSelected;
	}

	public Date getMonStartTime() {
		return _monStartTime;
	}

	public void setMonStartTime(Date monStartTime) {
		_monStartTime = monStartTime;
	}

	public Date getMonEndTime() {
		return _monEndTime;
	}

	public void setMonEndTime(Date monEndTime) {
		_monEndTime = monEndTime;
	}

	public boolean getTueSelected() {
		return _tueSelected;
	}

	public boolean isTueSelected() {
		return _tueSelected;
	}

	public void setTueSelected(boolean tueSelected) {
		_tueSelected = tueSelected;
	}

	public Date getTueStartTime() {
		return _tueStartTime;
	}

	public void setTueStartTime(Date tueStartTime) {
		_tueStartTime = tueStartTime;
	}

	public Date getTueEndTime() {
		return _tueEndTime;
	}

	public void setTueEndTime(Date tueEndTime) {
		_tueEndTime = tueEndTime;
	}

	public boolean getWedSelected() {
		return _wedSelected;
	}

	public boolean isWedSelected() {
		return _wedSelected;
	}

	public void setWedSelected(boolean wedSelected) {
		_wedSelected = wedSelected;
	}

	public Date getWedStartTime() {
		return _wedStartTime;
	}

	public void setWedStartTime(Date wedStartTime) {
		_wedStartTime = wedStartTime;
	}

	public Date getWedEndTime() {
		return _wedEndTime;
	}

	public void setWedEndTime(Date wedEndTime) {
		_wedEndTime = wedEndTime;
	}

	public boolean getThuSelected() {
		return _thuSelected;
	}

	public boolean isThuSelected() {
		return _thuSelected;
	}

	public void setThuSelected(boolean thuSelected) {
		_thuSelected = thuSelected;
	}

	public Date getThuStartTime() {
		return _thuStartTime;
	}

	public void setThuStartTime(Date thuStartTime) {
		_thuStartTime = thuStartTime;
	}

	public Date getThuEndTime() {
		return _thuEndTime;
	}

	public void setThuEndTime(Date thuEndTime) {
		_thuEndTime = thuEndTime;
	}

	public boolean getFriSelected() {
		return _friSelected;
	}

	public boolean isFriSelected() {
		return _friSelected;
	}

	public void setFriSelected(boolean friSelected) {
		_friSelected = friSelected;
	}

	public Date getFriStartTime() {
		return _friStartTime;
	}

	public void setFriStartTime(Date friStartTime) {
		_friStartTime = friStartTime;
	}

	public Date getFriEndTime() {
		return _friEndTime;
	}

	public void setFriEndTime(Date friEndTime) {
		_friEndTime = friEndTime;
	}

	public boolean getSatSelected() {
		return _satSelected;
	}

	public boolean isSatSelected() {
		return _satSelected;
	}

	public void setSatSelected(boolean satSelected) {
		_satSelected = satSelected;
	}

	public Date getSatStartTime() {
		return _satStartTime;
	}

	public void setSatStartTime(Date satStartTime) {
		_satStartTime = satStartTime;
	}

	public Date getSatEndTime() {
		return _satEndTime;
	}

	public void setSatEndTime(Date satEndTime) {
		_satEndTime = satEndTime;
	}

	public String getRequestedReason() {
		return _requestedReason;
	}

	public void setRequestedReason(String requestedReason) {
		_requestedReason = requestedReason;
	}

	public int getRequestedStatus() {
		return _requestedStatus;
	}

	public void setRequestedStatus(int requestedStatus) {
		_requestedStatus = requestedStatus;
	}

	public Date getCreatedAt() {
		return _createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		_createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return _updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		_updatedAt = updatedAt;
	}

	public LmisTimeChangeRequests toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			LmisTimeChangeRequests model = new LmisTimeChangeRequestsClp();

			model.setEscapedModel(true);

			model.setLmisTimeChangeRequestId(getLmisTimeChangeRequestId());
			model.setRootId(getRootId());
			model.setRequestedBy(getRequestedBy());
			model.setStartDate(getStartDate());
			model.setEndDate(getEndDate());
			model.setMonSelected(getMonSelected());
			model.setMonStartTime(getMonStartTime());
			model.setMonEndTime(getMonEndTime());
			model.setTueSelected(getTueSelected());
			model.setTueStartTime(getTueStartTime());
			model.setTueEndTime(getTueEndTime());
			model.setWedSelected(getWedSelected());
			model.setWedStartTime(getWedStartTime());
			model.setWedEndTime(getWedEndTime());
			model.setThuSelected(getThuSelected());
			model.setThuStartTime(getThuStartTime());
			model.setThuEndTime(getThuEndTime());
			model.setFriSelected(getFriSelected());
			model.setFriStartTime(getFriStartTime());
			model.setFriEndTime(getFriEndTime());
			model.setSatSelected(getSatSelected());
			model.setSatStartTime(getSatStartTime());
			model.setSatEndTime(getSatEndTime());
			model.setRequestedReason(HtmlUtil.escape(getRequestedReason()));
			model.setRequestedStatus(getRequestedStatus());
			model.setCreatedAt(getCreatedAt());
			model.setUpdatedAt(getUpdatedAt());

			model = (LmisTimeChangeRequests)Proxy.newProxyInstance(LmisTimeChangeRequests.class.getClassLoader(),
					new Class[] { LmisTimeChangeRequests.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		LmisTimeChangeRequestsClp clone = new LmisTimeChangeRequestsClp();

		clone.setLmisTimeChangeRequestId(getLmisTimeChangeRequestId());
		clone.setRootId(getRootId());
		clone.setRequestedBy(getRequestedBy());
		clone.setStartDate(getStartDate());
		clone.setEndDate(getEndDate());
		clone.setMonSelected(getMonSelected());
		clone.setMonStartTime(getMonStartTime());
		clone.setMonEndTime(getMonEndTime());
		clone.setTueSelected(getTueSelected());
		clone.setTueStartTime(getTueStartTime());
		clone.setTueEndTime(getTueEndTime());
		clone.setWedSelected(getWedSelected());
		clone.setWedStartTime(getWedStartTime());
		clone.setWedEndTime(getWedEndTime());
		clone.setThuSelected(getThuSelected());
		clone.setThuStartTime(getThuStartTime());
		clone.setThuEndTime(getThuEndTime());
		clone.setFriSelected(getFriSelected());
		clone.setFriStartTime(getFriStartTime());
		clone.setFriEndTime(getFriEndTime());
		clone.setSatSelected(getSatSelected());
		clone.setSatStartTime(getSatStartTime());
		clone.setSatEndTime(getSatEndTime());
		clone.setRequestedReason(getRequestedReason());
		clone.setRequestedStatus(getRequestedStatus());
		clone.setCreatedAt(getCreatedAt());
		clone.setUpdatedAt(getUpdatedAt());

		return clone;
	}

	public int compareTo(LmisTimeChangeRequests lmisTimeChangeRequests) {
		int value = 0;

		if (getRequestedStatus() < lmisTimeChangeRequests.getRequestedStatus()) {
			value = -1;
		}
		else if (getRequestedStatus() > lmisTimeChangeRequests.getRequestedStatus()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(getStartDate(),
				lmisTimeChangeRequests.getStartDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		LmisTimeChangeRequestsClp lmisTimeChangeRequests = null;

		try {
			lmisTimeChangeRequests = (LmisTimeChangeRequestsClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = lmisTimeChangeRequests.getPrimaryKey();

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

		sb.append("{lmisTimeChangeRequestId=");
		sb.append(getLmisTimeChangeRequestId());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", requestedBy=");
		sb.append(getRequestedBy());
		sb.append(", startDate=");
		sb.append(getStartDate());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append(", monSelected=");
		sb.append(getMonSelected());
		sb.append(", monStartTime=");
		sb.append(getMonStartTime());
		sb.append(", monEndTime=");
		sb.append(getMonEndTime());
		sb.append(", tueSelected=");
		sb.append(getTueSelected());
		sb.append(", tueStartTime=");
		sb.append(getTueStartTime());
		sb.append(", tueEndTime=");
		sb.append(getTueEndTime());
		sb.append(", wedSelected=");
		sb.append(getWedSelected());
		sb.append(", wedStartTime=");
		sb.append(getWedStartTime());
		sb.append(", wedEndTime=");
		sb.append(getWedEndTime());
		sb.append(", thuSelected=");
		sb.append(getThuSelected());
		sb.append(", thuStartTime=");
		sb.append(getThuStartTime());
		sb.append(", thuEndTime=");
		sb.append(getThuEndTime());
		sb.append(", friSelected=");
		sb.append(getFriSelected());
		sb.append(", friStartTime=");
		sb.append(getFriStartTime());
		sb.append(", friEndTime=");
		sb.append(getFriEndTime());
		sb.append(", satSelected=");
		sb.append(getSatSelected());
		sb.append(", satStartTime=");
		sb.append(getSatStartTime());
		sb.append(", satEndTime=");
		sb.append(getSatEndTime());
		sb.append(", requestedReason=");
		sb.append(getRequestedReason());
		sb.append(", requestedStatus=");
		sb.append(getRequestedStatus());
		sb.append(", createdAt=");
		sb.append(getCreatedAt());
		sb.append(", updatedAt=");
		sb.append(getUpdatedAt());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.lmis.model.LmisTimeChangeRequests");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>lmisTimeChangeRequestId</column-name><column-value><![CDATA[");
		sb.append(getLmisTimeChangeRequestId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rootId</column-name><column-value><![CDATA[");
		sb.append(getRootId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>requestedBy</column-name><column-value><![CDATA[");
		sb.append(getRequestedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startDate</column-name><column-value><![CDATA[");
		sb.append(getStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endDate</column-name><column-value><![CDATA[");
		sb.append(getEndDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>monSelected</column-name><column-value><![CDATA[");
		sb.append(getMonSelected());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>monStartTime</column-name><column-value><![CDATA[");
		sb.append(getMonStartTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>monEndTime</column-name><column-value><![CDATA[");
		sb.append(getMonEndTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tueSelected</column-name><column-value><![CDATA[");
		sb.append(getTueSelected());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tueStartTime</column-name><column-value><![CDATA[");
		sb.append(getTueStartTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tueEndTime</column-name><column-value><![CDATA[");
		sb.append(getTueEndTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>wedSelected</column-name><column-value><![CDATA[");
		sb.append(getWedSelected());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>wedStartTime</column-name><column-value><![CDATA[");
		sb.append(getWedStartTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>wedEndTime</column-name><column-value><![CDATA[");
		sb.append(getWedEndTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>thuSelected</column-name><column-value><![CDATA[");
		sb.append(getThuSelected());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>thuStartTime</column-name><column-value><![CDATA[");
		sb.append(getThuStartTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>thuEndTime</column-name><column-value><![CDATA[");
		sb.append(getThuEndTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>friSelected</column-name><column-value><![CDATA[");
		sb.append(getFriSelected());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>friStartTime</column-name><column-value><![CDATA[");
		sb.append(getFriStartTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>friEndTime</column-name><column-value><![CDATA[");
		sb.append(getFriEndTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>satSelected</column-name><column-value><![CDATA[");
		sb.append(getSatSelected());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>satStartTime</column-name><column-value><![CDATA[");
		sb.append(getSatStartTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>satEndTime</column-name><column-value><![CDATA[");
		sb.append(getSatEndTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>requestedReason</column-name><column-value><![CDATA[");
		sb.append(getRequestedReason());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>requestedStatus</column-name><column-value><![CDATA[");
		sb.append(getRequestedStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdAt</column-name><column-value><![CDATA[");
		sb.append(getCreatedAt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>updatedAt</column-name><column-value><![CDATA[");
		sb.append(getUpdatedAt());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _lmisTimeChangeRequestId;
	private int _rootId;
	private int _requestedBy;
	private Date _startDate;
	private Date _endDate;
	private boolean _monSelected;
	private Date _monStartTime;
	private Date _monEndTime;
	private boolean _tueSelected;
	private Date _tueStartTime;
	private Date _tueEndTime;
	private boolean _wedSelected;
	private Date _wedStartTime;
	private Date _wedEndTime;
	private boolean _thuSelected;
	private Date _thuStartTime;
	private Date _thuEndTime;
	private boolean _friSelected;
	private Date _friStartTime;
	private Date _friEndTime;
	private boolean _satSelected;
	private Date _satStartTime;
	private Date _satEndTime;
	private String _requestedReason;
	private int _requestedStatus;
	private Date _createdAt;
	private Date _updatedAt;
}