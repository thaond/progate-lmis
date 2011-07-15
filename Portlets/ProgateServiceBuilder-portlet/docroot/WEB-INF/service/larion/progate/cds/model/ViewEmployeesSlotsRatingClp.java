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
 * <a href="ViewEmployeesSlotsRatingClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ViewEmployeesSlotsRatingClp extends BaseModelImpl<ViewEmployeesSlotsRating>
	implements ViewEmployeesSlotsRating {
	public ViewEmployeesSlotsRatingClp() {
	}

	public String getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(String pk) {
		setId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	public String getId() {
		return _id;
	}

	public void setId(String id) {
		_id = id;
	}

	public String getAliasName() {
		return _aliasName;
	}

	public void setAliasName(String aliasName) {
		_aliasName = aliasName;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public int getNumberOrder() {
		return _numberOrder;
	}

	public void setNumberOrder(int numberOrder) {
		_numberOrder = numberOrder;
	}

	public int getUserId() {
		return _userId;
	}

	public void setUserId(int userId) {
		_userId = userId;
	}

	public int getPeriodId() {
		return _periodId;
	}

	public void setPeriodId(int periodId) {
		_periodId = periodId;
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

	public int getRatingOrgId() {
		return _ratingOrgId;
	}

	public void setRatingOrgId(int ratingOrgId) {
		_ratingOrgId = ratingOrgId;
	}

	public int getRatingStatus() {
		return _ratingStatus;
	}

	public void setRatingStatus(int ratingStatus) {
		_ratingStatus = ratingStatus;
	}

	public int getRatingStatusBod() {
		return _ratingStatusBod;
	}

	public void setRatingStatusBod(int ratingStatusBod) {
		_ratingStatusBod = ratingStatusBod;
	}

	public int getRatingStatusPm() {
		return _ratingStatusPm;
	}

	public void setRatingStatusPm(int ratingStatusPm) {
		_ratingStatusPm = ratingStatusPm;
	}

	public ViewEmployeesSlotsRating toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			ViewEmployeesSlotsRating model = new ViewEmployeesSlotsRatingClp();

			model.setEscapedModel(true);

			model.setId(HtmlUtil.escape(getId()));
			model.setAliasName(HtmlUtil.escape(getAliasName()));
			model.setDescription(HtmlUtil.escape(getDescription()));
			model.setNumberOrder(getNumberOrder());
			model.setUserId(getUserId());
			model.setPeriodId(getPeriodId());
			model.setPeriodName(HtmlUtil.escape(getPeriodName()));
			model.setFromDate(getFromDate());
			model.setToDate(getToDate());
			model.setRatingOrgId(getRatingOrgId());
			model.setRatingStatus(getRatingStatus());
			model.setRatingStatusBod(getRatingStatusBod());
			model.setRatingStatusPm(getRatingStatusPm());

			model = (ViewEmployeesSlotsRating)Proxy.newProxyInstance(ViewEmployeesSlotsRating.class.getClassLoader(),
					new Class[] { ViewEmployeesSlotsRating.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		ViewEmployeesSlotsRatingClp clone = new ViewEmployeesSlotsRatingClp();

		clone.setId(getId());
		clone.setAliasName(getAliasName());
		clone.setDescription(getDescription());
		clone.setNumberOrder(getNumberOrder());
		clone.setUserId(getUserId());
		clone.setPeriodId(getPeriodId());
		clone.setPeriodName(getPeriodName());
		clone.setFromDate(getFromDate());
		clone.setToDate(getToDate());
		clone.setRatingOrgId(getRatingOrgId());
		clone.setRatingStatus(getRatingStatus());
		clone.setRatingStatusBod(getRatingStatusBod());
		clone.setRatingStatusPm(getRatingStatusPm());

		return clone;
	}

	public int compareTo(ViewEmployeesSlotsRating viewEmployeesSlotsRating) {
		String pk = viewEmployeesSlotsRating.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ViewEmployeesSlotsRatingClp viewEmployeesSlotsRating = null;

		try {
			viewEmployeesSlotsRating = (ViewEmployeesSlotsRatingClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		String pk = viewEmployeesSlotsRating.getPrimaryKey();

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

		sb.append("{id=");
		sb.append(getId());
		sb.append(", aliasName=");
		sb.append(getAliasName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", numberOrder=");
		sb.append(getNumberOrder());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", periodId=");
		sb.append(getPeriodId());
		sb.append(", periodName=");
		sb.append(getPeriodName());
		sb.append(", fromDate=");
		sb.append(getFromDate());
		sb.append(", toDate=");
		sb.append(getToDate());
		sb.append(", ratingOrgId=");
		sb.append(getRatingOrgId());
		sb.append(", ratingStatus=");
		sb.append(getRatingStatus());
		sb.append(", ratingStatusBod=");
		sb.append(getRatingStatusBod());
		sb.append(", ratingStatusPm=");
		sb.append(getRatingStatusPm());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.cds.model.ViewEmployeesSlotsRating");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>aliasName</column-name><column-value><![CDATA[");
		sb.append(getAliasName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numberOrder</column-name><column-value><![CDATA[");
		sb.append(getNumberOrder());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>periodId</column-name><column-value><![CDATA[");
		sb.append(getPeriodId());
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
			"<column><column-name>ratingOrgId</column-name><column-value><![CDATA[");
		sb.append(getRatingOrgId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ratingStatus</column-name><column-value><![CDATA[");
		sb.append(getRatingStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ratingStatusBod</column-name><column-value><![CDATA[");
		sb.append(getRatingStatusBod());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ratingStatusPm</column-name><column-value><![CDATA[");
		sb.append(getRatingStatusPm());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _id;
	private String _aliasName;
	private String _description;
	private int _numberOrder;
	private int _userId;
	private int _periodId;
	private String _periodName;
	private Date _fromDate;
	private Date _toDate;
	private int _ratingOrgId;
	private int _ratingStatus;
	private int _ratingStatusBod;
	private int _ratingStatusPm;
}