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
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * <a href="ViewSlotInformationClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ViewSlotInformationClp extends BaseModelImpl<ViewSlotInformation>
	implements ViewSlotInformation {
	public ViewSlotInformationClp() {
	}

	public Integer getPrimaryKey() {
		return _viewSlotInformationId;
	}

	public void setPrimaryKey(Integer pk) {
		setViewSlotInformationId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _viewSlotInformationId;
	}

	public Integer getViewSlotInformationId() {
		return _viewSlotInformationId;
	}

	public void setViewSlotInformationId(Integer viewSlotInformationId) {
		_viewSlotInformationId = viewSlotInformationId;
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

	public int getSlotId() {
		return _slotId;
	}

	public void setSlotId(int slotId) {
		_slotId = slotId;
	}

	public String getPointName() {
		return _pointName;
	}

	public void setPointName(String pointName) {
		_pointName = pointName;
	}

	public String getMaxPointName() {
		return _maxPointName;
	}

	public void setMaxPointName(String maxPointName) {
		_maxPointName = maxPointName;
	}

	public boolean getIsPassed() {
		return _isPassed;
	}

	public boolean isIsPassed() {
		return _isPassed;
	}

	public void setIsPassed(boolean isPassed) {
		_isPassed = isPassed;
	}

	public String getPeriodName() {
		return _periodName;
	}

	public void setPeriodName(String periodName) {
		_periodName = periodName;
	}

	public Date getFromDate() {
		return _fromDate;
	}

	public void setFromDate(Date fromDate) {
		_fromDate = fromDate;
	}

	public Date getToDate() {
		return _toDate;
	}

	public void setToDate(Date toDate) {
		_toDate = toDate;
	}

	public String getPmName() {
		return _pmName;
	}

	public void setPmName(String pmName) {
		_pmName = pmName;
	}

	public String getOrgName() {
		return _orgName;
	}

	public void setOrgName(String orgName) {
		_orgName = orgName;
	}

	public ViewSlotInformation toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			ViewSlotInformation model = new ViewSlotInformationClp();

			model.setEscapedModel(true);

			model.setViewSlotInformationId(getViewSlotInformationId());
			model.setRootId(getRootId());
			model.setUserId(getUserId());
			model.setSlotId(getSlotId());
			model.setPointName(HtmlUtil.escape(getPointName()));
			model.setMaxPointName(HtmlUtil.escape(getMaxPointName()));
			model.setIsPassed(getIsPassed());
			model.setPeriodName(HtmlUtil.escape(getPeriodName()));
			model.setFromDate(getFromDate());
			model.setToDate(getToDate());
			model.setPmName(HtmlUtil.escape(getPmName()));
			model.setOrgName(HtmlUtil.escape(getOrgName()));

			model = (ViewSlotInformation)Proxy.newProxyInstance(ViewSlotInformation.class.getClassLoader(),
					new Class[] { ViewSlotInformation.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		ViewSlotInformationClp clone = new ViewSlotInformationClp();

		clone.setViewSlotInformationId(getViewSlotInformationId());
		clone.setRootId(getRootId());
		clone.setUserId(getUserId());
		clone.setSlotId(getSlotId());
		clone.setPointName(getPointName());
		clone.setMaxPointName(getMaxPointName());
		clone.setIsPassed(getIsPassed());
		clone.setPeriodName(getPeriodName());
		clone.setFromDate(getFromDate());
		clone.setToDate(getToDate());
		clone.setPmName(getPmName());
		clone.setOrgName(getOrgName());

		return clone;
	}

	public int compareTo(ViewSlotInformation viewSlotInformation) {
		int value = 0;

		value = DateUtil.compareTo(getToDate(), viewSlotInformation.getToDate());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ViewSlotInformationClp viewSlotInformation = null;

		try {
			viewSlotInformation = (ViewSlotInformationClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = viewSlotInformation.getPrimaryKey();

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

		sb.append("{viewSlotInformationId=");
		sb.append(getViewSlotInformationId());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", slotId=");
		sb.append(getSlotId());
		sb.append(", pointName=");
		sb.append(getPointName());
		sb.append(", maxPointName=");
		sb.append(getMaxPointName());
		sb.append(", isPassed=");
		sb.append(getIsPassed());
		sb.append(", periodName=");
		sb.append(getPeriodName());
		sb.append(", fromDate=");
		sb.append(getFromDate());
		sb.append(", toDate=");
		sb.append(getToDate());
		sb.append(", pmName=");
		sb.append(getPmName());
		sb.append(", orgName=");
		sb.append(getOrgName());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.cds.model.ViewSlotInformation");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>viewSlotInformationId</column-name><column-value><![CDATA[");
		sb.append(getViewSlotInformationId());
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
			"<column><column-name>slotId</column-name><column-value><![CDATA[");
		sb.append(getSlotId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pointName</column-name><column-value><![CDATA[");
		sb.append(getPointName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maxPointName</column-name><column-value><![CDATA[");
		sb.append(getMaxPointName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isPassed</column-name><column-value><![CDATA[");
		sb.append(getIsPassed());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>periodName</column-name><column-value><![CDATA[");
		sb.append(getPeriodName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fromDate</column-name><column-value><![CDATA[");
		sb.append(getFromDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>toDate</column-name><column-value><![CDATA[");
		sb.append(getToDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pmName</column-name><column-value><![CDATA[");
		sb.append(getPmName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orgName</column-name><column-value><![CDATA[");
		sb.append(getOrgName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _viewSlotInformationId;
	private int _rootId;
	private int _userId;
	private int _slotId;
	private String _pointName;
	private String _maxPointName;
	private boolean _isPassed;
	private String _periodName;
	private Date _fromDate;
	private Date _toDate;
	private String _pmName;
	private String _orgName;
}