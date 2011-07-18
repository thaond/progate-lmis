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
 * <a href="CdsPASlotsClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsPASlotsClp extends BaseModelImpl<CdsPASlots>
	implements CdsPASlots {
	public CdsPASlotsClp() {
	}

	public Integer getPrimaryKey() {
		return _CdsPASlotsId;
	}

	public void setPrimaryKey(Integer pk) {
		setCdsPASlotsId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _CdsPASlotsId;
	}

	public Integer getCdsPASlotsId() {
		return _CdsPASlotsId;
	}

	public void setCdsPASlotsId(Integer CdsPASlotsId) {
		_CdsPASlotsId = CdsPASlotsId;
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

	public int getPmUid() {
		return _pmUid;
	}

	public void setPmUid(int pmUid) {
		_pmUid = pmUid;
	}

	public int getBodUid() {
		return _bodUid;
	}

	public void setBodUid(int bodUid) {
		_bodUid = bodUid;
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

	public String getMaxPointName() {
		return _maxPointName;
	}

	public void setMaxPointName(String maxPointName) {
		_maxPointName = maxPointName;
	}

	public int getPointValue() {
		return _pointValue;
	}

	public void setPointValue(int pointValue) {
		_pointValue = pointValue;
	}

	public int getMaxPointValue() {
		return _maxPointValue;
	}

	public void setMaxPointValue(int maxPointValue) {
		_maxPointValue = maxPointValue;
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

	public CdsPASlots toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			CdsPASlots model = new CdsPASlotsClp();

			model.setEscapedModel(true);

			model.setCdsPASlotsId(getCdsPASlotsId());
			model.setPaId(getPaId());
			model.setRootId(getRootId());
			model.setPeriodId(getPeriodId());
			model.setUserId(getUserId());
			model.setSlotId(getSlotId());
			model.setPmUid(getPmUid());
			model.setBodUid(getBodUid());
			model.setRatingOrgId(getRatingOrgId());
			model.setRatingStatus(getRatingStatus());
			model.setRatingStatusPm(getRatingStatusPm());
			model.setRatingStatusBod(getRatingStatusBod());
			model.setPointName(HtmlUtil.escape(getPointName()));
			model.setMaxPointName(HtmlUtil.escape(getMaxPointName()));
			model.setPointValue(getPointValue());
			model.setMaxPointValue(getMaxPointValue());
			model.setIsPassed(getIsPassed());

			model = (CdsPASlots)Proxy.newProxyInstance(CdsPASlots.class.getClassLoader(),
					new Class[] { CdsPASlots.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		CdsPASlotsClp clone = new CdsPASlotsClp();

		clone.setCdsPASlotsId(getCdsPASlotsId());
		clone.setPaId(getPaId());
		clone.setRootId(getRootId());
		clone.setPeriodId(getPeriodId());
		clone.setUserId(getUserId());
		clone.setSlotId(getSlotId());
		clone.setPmUid(getPmUid());
		clone.setBodUid(getBodUid());
		clone.setRatingOrgId(getRatingOrgId());
		clone.setRatingStatus(getRatingStatus());
		clone.setRatingStatusPm(getRatingStatusPm());
		clone.setRatingStatusBod(getRatingStatusBod());
		clone.setPointName(getPointName());
		clone.setMaxPointName(getMaxPointName());
		clone.setPointValue(getPointValue());
		clone.setMaxPointValue(getMaxPointValue());
		clone.setIsPassed(getIsPassed());

		return clone;
	}

	public int compareTo(CdsPASlots cdsPASlots) {
		Integer pk = cdsPASlots.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		CdsPASlotsClp cdsPASlots = null;

		try {
			cdsPASlots = (CdsPASlotsClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = cdsPASlots.getPrimaryKey();

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

		sb.append("{CdsPASlotsId=");
		sb.append(getCdsPASlotsId());
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
		sb.append(", pmUid=");
		sb.append(getPmUid());
		sb.append(", bodUid=");
		sb.append(getBodUid());
		sb.append(", ratingOrgId=");
		sb.append(getRatingOrgId());
		sb.append(", ratingStatus=");
		sb.append(getRatingStatus());
		sb.append(", ratingStatusPm=");
		sb.append(getRatingStatusPm());
		sb.append(", ratingStatusBod=");
		sb.append(getRatingStatusBod());
		sb.append(", pointName=");
		sb.append(getPointName());
		sb.append(", maxPointName=");
		sb.append(getMaxPointName());
		sb.append(", pointValue=");
		sb.append(getPointValue());
		sb.append(", maxPointValue=");
		sb.append(getMaxPointValue());
		sb.append(", isPassed=");
		sb.append(getIsPassed());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.cds.model.CdsPASlots");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>CdsPASlotsId</column-name><column-value><![CDATA[");
		sb.append(getCdsPASlotsId());
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
			"<column><column-name>pmUid</column-name><column-value><![CDATA[");
		sb.append(getPmUid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bodUid</column-name><column-value><![CDATA[");
		sb.append(getBodUid());
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
			"<column><column-name>maxPointName</column-name><column-value><![CDATA[");
		sb.append(getMaxPointName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pointValue</column-name><column-value><![CDATA[");
		sb.append(getPointValue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maxPointValue</column-name><column-value><![CDATA[");
		sb.append(getMaxPointValue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isPassed</column-name><column-value><![CDATA[");
		sb.append(getIsPassed());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _CdsPASlotsId;
	private int _paId;
	private int _rootId;
	private int _periodId;
	private int _userId;
	private int _slotId;
	private int _pmUid;
	private int _bodUid;
	private int _ratingOrgId;
	private int _ratingStatus;
	private int _ratingStatusPm;
	private int _ratingStatusBod;
	private String _pointName;
	private String _maxPointName;
	private int _pointValue;
	private int _maxPointValue;
	private boolean _isPassed;
}