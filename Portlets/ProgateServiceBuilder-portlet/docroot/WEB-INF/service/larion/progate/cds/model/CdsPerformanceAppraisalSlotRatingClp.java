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
 * <a href="CdsPerformanceAppraisalSlotRatingClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsPerformanceAppraisalSlotRatingClp extends BaseModelImpl<CdsPerformanceAppraisalSlotRating>
	implements CdsPerformanceAppraisalSlotRating {
	public CdsPerformanceAppraisalSlotRatingClp() {
	}

	public Integer getPrimaryKey() {
		return _CdsPerformanceAppraisalSlotRatingId;
	}

	public void setPrimaryKey(Integer pk) {
		setCdsPerformanceAppraisalSlotRatingId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _CdsPerformanceAppraisalSlotRatingId;
	}

	public Integer getCdsPerformanceAppraisalSlotRatingId() {
		return _CdsPerformanceAppraisalSlotRatingId;
	}

	public void setCdsPerformanceAppraisalSlotRatingId(
		Integer CdsPerformanceAppraisalSlotRatingId) {
		_CdsPerformanceAppraisalSlotRatingId = CdsPerformanceAppraisalSlotRatingId;
	}

	public int getPaId() {
		return _paId;
	}

	public void setPaId(int paId) {
		_paId = paId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
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

	public int getSlotId() {
		return _slotId;
	}

	public void setSlotId(int slotId) {
		_slotId = slotId;
	}

	public int getRatingBy() {
		return _ratingBy;
	}

	public void setRatingBy(int ratingBy) {
		_ratingBy = ratingBy;
	}

	public Date getRatingAt() {
		return _ratingAt;
	}

	public void setRatingAt(Date ratingAt) {
		_ratingAt = ratingAt;
	}

	public boolean getRatingStatus() {
		return _ratingStatus;
	}

	public boolean isRatingStatus() {
		return _ratingStatus;
	}

	public void setRatingStatus(boolean ratingStatus) {
		_ratingStatus = ratingStatus;
	}

	public int getUserType() {
		return _userType;
	}

	public void setUserType(int userType) {
		_userType = userType;
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

	public int getRatingOrgId() {
		return _ratingOrgId;
	}

	public void setRatingOrgId(int ratingOrgId) {
		_ratingOrgId = ratingOrgId;
	}

	public CdsPerformanceAppraisalSlotRating toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			CdsPerformanceAppraisalSlotRating model = new CdsPerformanceAppraisalSlotRatingClp();

			model.setEscapedModel(true);

			model.setCdsPerformanceAppraisalSlotRatingId(getCdsPerformanceAppraisalSlotRatingId());
			model.setPaId(getPaId());
			model.setRootId(getRootId());
			model.setPeriodId(getPeriodId());
			model.setUserId(getUserId());
			model.setSlotId(getSlotId());
			model.setRatingBy(getRatingBy());
			model.setRatingAt(getRatingAt());
			model.setRatingStatus(getRatingStatus());
			model.setUserType(getUserType());
			model.setPointName(HtmlUtil.escape(getPointName()));
			model.setPointValue(getPointValue());
			model.setRatingOrgId(getRatingOrgId());

			model = (CdsPerformanceAppraisalSlotRating)Proxy.newProxyInstance(CdsPerformanceAppraisalSlotRating.class.getClassLoader(),
					new Class[] { CdsPerformanceAppraisalSlotRating.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		CdsPerformanceAppraisalSlotRatingClp clone = new CdsPerformanceAppraisalSlotRatingClp();

		clone.setCdsPerformanceAppraisalSlotRatingId(getCdsPerformanceAppraisalSlotRatingId());
		clone.setPaId(getPaId());
		clone.setRootId(getRootId());
		clone.setPeriodId(getPeriodId());
		clone.setUserId(getUserId());
		clone.setSlotId(getSlotId());
		clone.setRatingBy(getRatingBy());
		clone.setRatingAt(getRatingAt());
		clone.setRatingStatus(getRatingStatus());
		clone.setUserType(getUserType());
		clone.setPointName(getPointName());
		clone.setPointValue(getPointValue());
		clone.setRatingOrgId(getRatingOrgId());

		return clone;
	}

	public int compareTo(
		CdsPerformanceAppraisalSlotRating cdsPerformanceAppraisalSlotRating) {
		int value = 0;

		value = DateUtil.compareTo(getRatingAt(),
				cdsPerformanceAppraisalSlotRating.getRatingAt());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		CdsPerformanceAppraisalSlotRatingClp cdsPerformanceAppraisalSlotRating = null;

		try {
			cdsPerformanceAppraisalSlotRating = (CdsPerformanceAppraisalSlotRatingClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = cdsPerformanceAppraisalSlotRating.getPrimaryKey();

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

		sb.append("{CdsPerformanceAppraisalSlotRatingId=");
		sb.append(getCdsPerformanceAppraisalSlotRatingId());
		sb.append(", paId=");
		sb.append(getPaId());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", periodId=");
		sb.append(getPeriodId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", slotId=");
		sb.append(getSlotId());
		sb.append(", ratingBy=");
		sb.append(getRatingBy());
		sb.append(", ratingAt=");
		sb.append(getRatingAt());
		sb.append(", ratingStatus=");
		sb.append(getRatingStatus());
		sb.append(", userType=");
		sb.append(getUserType());
		sb.append(", pointName=");
		sb.append(getPointName());
		sb.append(", pointValue=");
		sb.append(getPointValue());
		sb.append(", ratingOrgId=");
		sb.append(getRatingOrgId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.cds.model.CdsPerformanceAppraisalSlotRating");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>CdsPerformanceAppraisalSlotRatingId</column-name><column-value><![CDATA[");
		sb.append(getCdsPerformanceAppraisalSlotRatingId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>paId</column-name><column-value><![CDATA[");
		sb.append(getPaId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rootId</column-name><column-value><![CDATA[");
		sb.append(getRootId());
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
			"<column><column-name>slotId</column-name><column-value><![CDATA[");
		sb.append(getSlotId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ratingBy</column-name><column-value><![CDATA[");
		sb.append(getRatingBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ratingAt</column-name><column-value><![CDATA[");
		sb.append(getRatingAt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ratingStatus</column-name><column-value><![CDATA[");
		sb.append(getRatingStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userType</column-name><column-value><![CDATA[");
		sb.append(getUserType());
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
			"<column><column-name>ratingOrgId</column-name><column-value><![CDATA[");
		sb.append(getRatingOrgId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _CdsPerformanceAppraisalSlotRatingId;
	private int _paId;
	private int _rootId;
	private int _periodId;
	private int _userId;
	private int _slotId;
	private int _ratingBy;
	private Date _ratingAt;
	private boolean _ratingStatus;
	private int _userType;
	private String _pointName;
	private int _pointValue;
	private int _ratingOrgId;
}