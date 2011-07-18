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

package larion.progate.model;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * <a href="ProgateOrganizationsStaffsClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProgateOrganizationsStaffsClp extends BaseModelImpl<ProgateOrganizationsStaffs>
	implements ProgateOrganizationsStaffs {
	public ProgateOrganizationsStaffsClp() {
	}

	public Integer getPrimaryKey() {
		return _ProgateOrganizationsStaffsId;
	}

	public void setPrimaryKey(Integer pk) {
		setProgateOrganizationsStaffsId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _ProgateOrganizationsStaffsId;
	}

	public Integer getProgateOrganizationsStaffsId() {
		return _ProgateOrganizationsStaffsId;
	}

	public void setProgateOrganizationsStaffsId(
		Integer ProgateOrganizationsStaffsId) {
		_ProgateOrganizationsStaffsId = ProgateOrganizationsStaffsId;
	}

	public int getUserId() {
		return _userId;
	}

	public void setUserId(int userId) {
		_userId = userId;
	}

	public int getOrgId() {
		return _orgId;
	}

	public void setOrgId(int orgId) {
		_orgId = orgId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public int getBodId() {
		return _bodId;
	}

	public void setBodId(int bodId) {
		_bodId = bodId;
	}

	public int getParticipantId() {
		return _participantId;
	}

	public void setParticipantId(int participantId) {
		_participantId = participantId;
	}

	public String getPosition() {
		return _position;
	}

	public void setPosition(String position) {
		_position = position;
	}

	public double getAvailability() {
		return _availability;
	}

	public void setAvailability(double availability) {
		_availability = availability;
	}

	public Date getBeginTime() {
		return _beginTime;
	}

	public void setBeginTime(Date beginTime) {
		_beginTime = beginTime;
	}

	public Date getEndTime() {
		return _endTime;
	}

	public void setEndTime(Date endTime) {
		_endTime = endTime;
	}

	public boolean getIsActive() {
		return _isActive;
	}

	public boolean isIsActive() {
		return _isActive;
	}

	public void setIsActive(boolean isActive) {
		_isActive = isActive;
	}

	public boolean getIsRemoved() {
		return _isRemoved;
	}

	public boolean isIsRemoved() {
		return _isRemoved;
	}

	public void setIsRemoved(boolean isRemoved) {
		_isRemoved = isRemoved;
	}

	public String getStaffCode() {
		return _staffCode;
	}

	public void setStaffCode(String staffCode) {
		_staffCode = staffCode;
	}

	public String getScannerCode() {
		return _scannerCode;
	}

	public void setScannerCode(String scannerCode) {
		_scannerCode = scannerCode;
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

	public ProgateOrganizationsStaffs toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			ProgateOrganizationsStaffs model = new ProgateOrganizationsStaffsClp();

			model.setEscapedModel(true);

			model.setProgateOrganizationsStaffsId(getProgateOrganizationsStaffsId());
			model.setUserId(getUserId());
			model.setOrgId(getOrgId());
			model.setRootId(getRootId());
			model.setBodId(getBodId());
			model.setParticipantId(getParticipantId());
			model.setPosition(HtmlUtil.escape(getPosition()));
			model.setAvailability(getAvailability());
			model.setBeginTime(getBeginTime());
			model.setEndTime(getEndTime());
			model.setIsActive(getIsActive());
			model.setIsRemoved(getIsRemoved());
			model.setStaffCode(HtmlUtil.escape(getStaffCode()));
			model.setScannerCode(HtmlUtil.escape(getScannerCode()));
			model.setCreatedAt(getCreatedAt());
			model.setUpdatedAt(getUpdatedAt());

			model = (ProgateOrganizationsStaffs)Proxy.newProxyInstance(ProgateOrganizationsStaffs.class.getClassLoader(),
					new Class[] { ProgateOrganizationsStaffs.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		ProgateOrganizationsStaffsClp clone = new ProgateOrganizationsStaffsClp();

		clone.setProgateOrganizationsStaffsId(getProgateOrganizationsStaffsId());
		clone.setUserId(getUserId());
		clone.setOrgId(getOrgId());
		clone.setRootId(getRootId());
		clone.setBodId(getBodId());
		clone.setParticipantId(getParticipantId());
		clone.setPosition(getPosition());
		clone.setAvailability(getAvailability());
		clone.setBeginTime(getBeginTime());
		clone.setEndTime(getEndTime());
		clone.setIsActive(getIsActive());
		clone.setIsRemoved(getIsRemoved());
		clone.setStaffCode(getStaffCode());
		clone.setScannerCode(getScannerCode());
		clone.setCreatedAt(getCreatedAt());
		clone.setUpdatedAt(getUpdatedAt());

		return clone;
	}

	public int compareTo(ProgateOrganizationsStaffs progateOrganizationsStaffs) {
		int value = 0;

		value = getStaffCode()
					.compareTo(progateOrganizationsStaffs.getStaffCode());

		if (value != 0) {
			return value;
		}

		value = getScannerCode()
					.compareTo(progateOrganizationsStaffs.getScannerCode());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ProgateOrganizationsStaffsClp progateOrganizationsStaffs = null;

		try {
			progateOrganizationsStaffs = (ProgateOrganizationsStaffsClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = progateOrganizationsStaffs.getPrimaryKey();

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

		sb.append("{ProgateOrganizationsStaffsId=");
		sb.append(getProgateOrganizationsStaffsId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", orgId=");
		sb.append(getOrgId());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", bodId=");
		sb.append(getBodId());
		sb.append(", participantId=");
		sb.append(getParticipantId());
		sb.append(", position=");
		sb.append(getPosition());
		sb.append(", availability=");
		sb.append(getAvailability());
		sb.append(", beginTime=");
		sb.append(getBeginTime());
		sb.append(", endTime=");
		sb.append(getEndTime());
		sb.append(", isActive=");
		sb.append(getIsActive());
		sb.append(", isRemoved=");
		sb.append(getIsRemoved());
		sb.append(", staffCode=");
		sb.append(getStaffCode());
		sb.append(", scannerCode=");
		sb.append(getScannerCode());
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
		sb.append("larion.progate.model.ProgateOrganizationsStaffs");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ProgateOrganizationsStaffsId</column-name><column-value><![CDATA[");
		sb.append(getProgateOrganizationsStaffsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orgId</column-name><column-value><![CDATA[");
		sb.append(getOrgId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rootId</column-name><column-value><![CDATA[");
		sb.append(getRootId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bodId</column-name><column-value><![CDATA[");
		sb.append(getBodId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>participantId</column-name><column-value><![CDATA[");
		sb.append(getParticipantId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>position</column-name><column-value><![CDATA[");
		sb.append(getPosition());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>availability</column-name><column-value><![CDATA[");
		sb.append(getAvailability());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>beginTime</column-name><column-value><![CDATA[");
		sb.append(getBeginTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endTime</column-name><column-value><![CDATA[");
		sb.append(getEndTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isActive</column-name><column-value><![CDATA[");
		sb.append(getIsActive());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isRemoved</column-name><column-value><![CDATA[");
		sb.append(getIsRemoved());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>staffCode</column-name><column-value><![CDATA[");
		sb.append(getStaffCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>scannerCode</column-name><column-value><![CDATA[");
		sb.append(getScannerCode());
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

	private Integer _ProgateOrganizationsStaffsId;
	private int _userId;
	private int _orgId;
	private int _rootId;
	private int _bodId;
	private int _participantId;
	private String _position;
	private double _availability;
	private Date _beginTime;
	private Date _endTime;
	private boolean _isActive;
	private boolean _isRemoved;
	private String _staffCode;
	private String _scannerCode;
	private Date _createdAt;
	private Date _updatedAt;
}