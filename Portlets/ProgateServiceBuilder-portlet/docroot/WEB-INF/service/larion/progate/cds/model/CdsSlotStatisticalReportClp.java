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

package larion.progate.cds.model;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * <a href="CdsSlotStatisticalReportClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsSlotStatisticalReportClp extends BaseModelImpl<CdsSlotStatisticalReport>
	implements CdsSlotStatisticalReport {
	public CdsSlotStatisticalReportClp() {
	}

	public Integer getPrimaryKey() {
		return _slotId;
	}

	public void setPrimaryKey(Integer pk) {
		setSlotId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _slotId;
	}

	public Integer getSlotId() {
		return _slotId;
	}

	public void setSlotId(Integer slotId) {
		_slotId = slotId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public int getLevelId() {
		return _levelId;
	}

	public void setLevelId(int levelId) {
		_levelId = levelId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public int getPeriodId() {
		return _periodId;
	}

	public void setPeriodId(int periodId) {
		_periodId = periodId;
	}

	public int getUserId() {
		return _userId;
	}

	public void setUserId(int userId) {
		_userId = userId;
	}

	public int getPmId() {
		return _pmId;
	}

	public void setPmId(int pmId) {
		_pmId = pmId;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public int getRatingStatusPm() {
		return _ratingStatusPm;
	}

	public void setRatingStatusPm(int ratingStatusPm) {
		_ratingStatusPm = ratingStatusPm;
	}

	public int getRatingStatusBod() {
		return _ratingStatusBod;
	}

	public void setRatingStatusBod(int ratingStatusBod) {
		_ratingStatusBod = ratingStatusBod;
	}

	public String getPointName() {
		return _pointName;
	}

	public void setPointName(String pointName) {
		_pointName = pointName;
	}

	public int getPointValue() {
		return _pointValue;
	}

	public void setPointValue(int pointValue) {
		_pointValue = pointValue;
	}

	public String getMaxPointName() {
		return _maxPointName;
	}

	public void setMaxPointName(String maxPointName) {
		_maxPointName = maxPointName;
	}

	public int getMaxPointValue() {
		return _maxPointValue;
	}

	public void setMaxPointValue(int maxPointValue) {
		_maxPointValue = maxPointValue;
	}

	public Date getToDate() {
		return _toDate;
	}

	public void setToDate(Date toDate) {
		_toDate = toDate;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public CdsSlotStatisticalReport toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			CdsSlotStatisticalReport model = new CdsSlotStatisticalReportClp();

			model.setEscapedModel(true);

			model.setSlotId(getSlotId());
			model.setRootId(getRootId());
			model.setLevelId(getLevelId());
			model.setName(HtmlUtil.escape(getName()));
			model.setDescription(HtmlUtil.escape(getDescription()));
			model.setPeriodId(getPeriodId());
			model.setUserId(getUserId());
			model.setPmId(getPmId());
			model.setFirstName(HtmlUtil.escape(getFirstName()));
			model.setLastName(HtmlUtil.escape(getLastName()));
			model.setRatingStatusPm(getRatingStatusPm());
			model.setRatingStatusBod(getRatingStatusBod());
			model.setPointName(HtmlUtil.escape(getPointName()));
			model.setPointValue(getPointValue());
			model.setMaxPointName(HtmlUtil.escape(getMaxPointName()));
			model.setMaxPointValue(getMaxPointValue());
			model.setToDate(getToDate());
			model.setStatus(getStatus());

			model = (CdsSlotStatisticalReport)Proxy.newProxyInstance(CdsSlotStatisticalReport.class.getClassLoader(),
					new Class[] { CdsSlotStatisticalReport.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		CdsSlotStatisticalReportClp clone = new CdsSlotStatisticalReportClp();

		clone.setSlotId(getSlotId());
		clone.setRootId(getRootId());
		clone.setLevelId(getLevelId());
		clone.setName(getName());
		clone.setDescription(getDescription());
		clone.setPeriodId(getPeriodId());
		clone.setUserId(getUserId());
		clone.setPmId(getPmId());
		clone.setFirstName(getFirstName());
		clone.setLastName(getLastName());
		clone.setRatingStatusPm(getRatingStatusPm());
		clone.setRatingStatusBod(getRatingStatusBod());
		clone.setPointName(getPointName());
		clone.setPointValue(getPointValue());
		clone.setMaxPointName(getMaxPointName());
		clone.setMaxPointValue(getMaxPointValue());
		clone.setToDate(getToDate());
		clone.setStatus(getStatus());

		return clone;
	}

	public int compareTo(CdsSlotStatisticalReport cdsSlotStatisticalReport) {
		Integer pk = cdsSlotStatisticalReport.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		CdsSlotStatisticalReportClp cdsSlotStatisticalReport = null;

		try {
			cdsSlotStatisticalReport = (CdsSlotStatisticalReportClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = cdsSlotStatisticalReport.getPrimaryKey();

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

		sb.append("{slotId=");
		sb.append(getSlotId());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", levelId=");
		sb.append(getLevelId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", periodId=");
		sb.append(getPeriodId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", pmId=");
		sb.append(getPmId());
		sb.append(", firstName=");
		sb.append(getFirstName());
		sb.append(", lastName=");
		sb.append(getLastName());
		sb.append(", ratingStatusPm=");
		sb.append(getRatingStatusPm());
		sb.append(", ratingStatusBod=");
		sb.append(getRatingStatusBod());
		sb.append(", pointName=");
		sb.append(getPointName());
		sb.append(", pointValue=");
		sb.append(getPointValue());
		sb.append(", maxPointName=");
		sb.append(getMaxPointName());
		sb.append(", maxPointValue=");
		sb.append(getMaxPointValue());
		sb.append(", toDate=");
		sb.append(getToDate());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.cds.model.CdsSlotStatisticalReport");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>slotId</column-name><column-value><![CDATA[");
		sb.append(getSlotId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rootId</column-name><column-value><![CDATA[");
		sb.append(getRootId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>levelId</column-name><column-value><![CDATA[");
		sb.append(getLevelId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>periodId</column-name><column-value><![CDATA[");
		sb.append(getPeriodId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pmId</column-name><column-value><![CDATA[");
		sb.append(getPmId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firstName</column-name><column-value><![CDATA[");
		sb.append(getFirstName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastName</column-name><column-value><![CDATA[");
		sb.append(getLastName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ratingStatusPm</column-name><column-value><![CDATA[");
		sb.append(getRatingStatusPm());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ratingStatusBod</column-name><column-value><![CDATA[");
		sb.append(getRatingStatusBod());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pointName</column-name><column-value><![CDATA[");
		sb.append(getPointName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pointValue</column-name><column-value><![CDATA[");
		sb.append(getPointValue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maxPointName</column-name><column-value><![CDATA[");
		sb.append(getMaxPointName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maxPointValue</column-name><column-value><![CDATA[");
		sb.append(getMaxPointValue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>toDate</column-name><column-value><![CDATA[");
		sb.append(getToDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _slotId;
	private int _rootId;
	private int _levelId;
	private String _name;
	private String _description;
	private int _periodId;
	private int _userId;
	private int _pmId;
	private String _firstName;
	private String _lastName;
	private int _ratingStatusPm;
	private int _ratingStatusBod;
	private String _pointName;
	private int _pointValue;
	private String _maxPointName;
	private int _maxPointValue;
	private Date _toDate;
	private int _status;
}