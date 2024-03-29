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

/**
 * <a href="CdsPerformanceAppraisalsClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsPerformanceAppraisalsClp extends BaseModelImpl<CdsPerformanceAppraisals>
	implements CdsPerformanceAppraisals {
	public CdsPerformanceAppraisalsClp() {
	}

	public Integer getPrimaryKey() {
		return _cdsPerformanceAppraisalsId;
	}

	public void setPrimaryKey(Integer pk) {
		setCdsPerformanceAppraisalsId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _cdsPerformanceAppraisalsId;
	}

	public Integer getCdsPerformanceAppraisalsId() {
		return _cdsPerformanceAppraisalsId;
	}

	public void setCdsPerformanceAppraisalsId(
		Integer cdsPerformanceAppraisalsId) {
		_cdsPerformanceAppraisalsId = cdsPerformanceAppraisalsId;
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

	public int getTitleId() {
		return _titleId;
	}

	public void setTitleId(int titleId) {
		_titleId = titleId;
	}

	public int getRatingStatus() {
		return _ratingStatus;
	}

	public void setRatingStatus(int ratingStatus) {
		_ratingStatus = ratingStatus;
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

	public boolean getIsLocked() {
		return _isLocked;
	}

	public boolean isIsLocked() {
		return _isLocked;
	}

	public void setIsLocked(boolean isLocked) {
		_isLocked = isLocked;
	}

	public String getPmList() {
		return _pmList;
	}

	public void setPmList(String pmList) {
		_pmList = pmList;
	}

	public String getOrgList() {
		return _orgList;
	}

	public void setOrgList(String orgList) {
		_orgList = orgList;
	}

	public String getBodList() {
		return _bodList;
	}

	public void setBodList(String bodList) {
		_bodList = bodList;
	}

	public boolean getIsTitleUp() {
		return _isTitleUp;
	}

	public boolean isIsTitleUp() {
		return _isTitleUp;
	}

	public void setIsTitleUp(boolean isTitleUp) {
		_isTitleUp = isTitleUp;
	}

	public CdsPerformanceAppraisals toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			CdsPerformanceAppraisals model = new CdsPerformanceAppraisalsClp();

			model.setEscapedModel(true);

			model.setCdsPerformanceAppraisalsId(getCdsPerformanceAppraisalsId());
			model.setRootId(getRootId());
			model.setPeriodId(getPeriodId());
			model.setUserId(getUserId());
			model.setTitleId(getTitleId());
			model.setRatingStatus(getRatingStatus());
			model.setRatingStatusPm(getRatingStatusPm());
			model.setRatingStatusBod(getRatingStatusBod());
			model.setIsLocked(getIsLocked());
			model.setPmList(HtmlUtil.escape(getPmList()));
			model.setOrgList(HtmlUtil.escape(getOrgList()));
			model.setBodList(HtmlUtil.escape(getBodList()));
			model.setIsTitleUp(getIsTitleUp());

			model = (CdsPerformanceAppraisals)Proxy.newProxyInstance(CdsPerformanceAppraisals.class.getClassLoader(),
					new Class[] { CdsPerformanceAppraisals.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		CdsPerformanceAppraisalsClp clone = new CdsPerformanceAppraisalsClp();

		clone.setCdsPerformanceAppraisalsId(getCdsPerformanceAppraisalsId());
		clone.setRootId(getRootId());
		clone.setPeriodId(getPeriodId());
		clone.setUserId(getUserId());
		clone.setTitleId(getTitleId());
		clone.setRatingStatus(getRatingStatus());
		clone.setRatingStatusPm(getRatingStatusPm());
		clone.setRatingStatusBod(getRatingStatusBod());
		clone.setIsLocked(getIsLocked());
		clone.setPmList(getPmList());
		clone.setOrgList(getOrgList());
		clone.setBodList(getBodList());
		clone.setIsTitleUp(getIsTitleUp());

		return clone;
	}

	public int compareTo(CdsPerformanceAppraisals cdsPerformanceAppraisals) {
		Integer pk = cdsPerformanceAppraisals.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		CdsPerformanceAppraisalsClp cdsPerformanceAppraisals = null;

		try {
			cdsPerformanceAppraisals = (CdsPerformanceAppraisalsClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = cdsPerformanceAppraisals.getPrimaryKey();

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

		sb.append("{cdsPerformanceAppraisalsId=");
		sb.append(getCdsPerformanceAppraisalsId());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", periodId=");
		sb.append(getPeriodId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", titleId=");
		sb.append(getTitleId());
		sb.append(", ratingStatus=");
		sb.append(getRatingStatus());
		sb.append(", ratingStatusPm=");
		sb.append(getRatingStatusPm());
		sb.append(", ratingStatusBod=");
		sb.append(getRatingStatusBod());
		sb.append(", isLocked=");
		sb.append(getIsLocked());
		sb.append(", pmList=");
		sb.append(getPmList());
		sb.append(", orgList=");
		sb.append(getOrgList());
		sb.append(", bodList=");
		sb.append(getBodList());
		sb.append(", isTitleUp=");
		sb.append(getIsTitleUp());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.cds.model.CdsPerformanceAppraisals");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>cdsPerformanceAppraisalsId</column-name><column-value><![CDATA[");
		sb.append(getCdsPerformanceAppraisalsId());
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
			"<column><column-name>titleId</column-name><column-value><![CDATA[");
		sb.append(getTitleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ratingStatus</column-name><column-value><![CDATA[");
		sb.append(getRatingStatus());
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
			"<column><column-name>isLocked</column-name><column-value><![CDATA[");
		sb.append(getIsLocked());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pmList</column-name><column-value><![CDATA[");
		sb.append(getPmList());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orgList</column-name><column-value><![CDATA[");
		sb.append(getOrgList());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bodList</column-name><column-value><![CDATA[");
		sb.append(getBodList());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isTitleUp</column-name><column-value><![CDATA[");
		sb.append(getIsTitleUp());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _cdsPerformanceAppraisalsId;
	private int _rootId;
	private int _periodId;
	private int _userId;
	private int _titleId;
	private int _ratingStatus;
	private int _ratingStatusPm;
	private int _ratingStatusBod;
	private boolean _isLocked;
	private String _pmList;
	private String _orgList;
	private String _bodList;
	private boolean _isTitleUp;
}