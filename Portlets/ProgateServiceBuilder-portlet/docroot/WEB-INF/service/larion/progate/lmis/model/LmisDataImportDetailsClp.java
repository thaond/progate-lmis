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

import java.util.Date;

/**
 * <a href="LmisDataImportDetailsClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisDataImportDetailsClp extends BaseModelImpl<LmisDataImportDetails>
	implements LmisDataImportDetails {
	public LmisDataImportDetailsClp() {
	}

	public Integer getPrimaryKey() {
		return _lmisDataImportDetailsId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisDataImportDetailsId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _lmisDataImportDetailsId;
	}

	public Integer getLmisDataImportDetailsId() {
		return _lmisDataImportDetailsId;
	}

	public void setLmisDataImportDetailsId(Integer lmisDataImportDetailsId) {
		_lmisDataImportDetailsId = lmisDataImportDetailsId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public int getImportId() {
		return _importId;
	}

	public void setImportId(int importId) {
		_importId = importId;
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

	public String getScannerId() {
		return _scannerId;
	}

	public void setScannerId(String scannerId) {
		_scannerId = scannerId;
	}

	public int getAbSence() {
		return _abSence;
	}

	public void setAbSence(int abSence) {
		_abSence = abSence;
	}

	public String getStaffName() {
		return _staffName;
	}

	public void setStaffName(String staffName) {
		_staffName = staffName;
	}

	public LmisDataImportDetails toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			LmisDataImportDetails model = new LmisDataImportDetailsClp();

			model.setEscapedModel(true);

			model.setLmisDataImportDetailsId(getLmisDataImportDetailsId());
			model.setRootId(getRootId());
			model.setImportId(getImportId());
			model.setStartTime(getStartTime());
			model.setEndTime(getEndTime());
			model.setScannerId(HtmlUtil.escape(getScannerId()));
			model.setAbSence(getAbSence());
			model.setStaffName(HtmlUtil.escape(getStaffName()));

			model = (LmisDataImportDetails)Proxy.newProxyInstance(LmisDataImportDetails.class.getClassLoader(),
					new Class[] { LmisDataImportDetails.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		LmisDataImportDetailsClp clone = new LmisDataImportDetailsClp();

		clone.setLmisDataImportDetailsId(getLmisDataImportDetailsId());
		clone.setRootId(getRootId());
		clone.setImportId(getImportId());
		clone.setStartTime(getStartTime());
		clone.setEndTime(getEndTime());
		clone.setScannerId(getScannerId());
		clone.setAbSence(getAbSence());
		clone.setStaffName(getStaffName());

		return clone;
	}

	public int compareTo(LmisDataImportDetails lmisDataImportDetails) {
		Integer pk = lmisDataImportDetails.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		LmisDataImportDetailsClp lmisDataImportDetails = null;

		try {
			lmisDataImportDetails = (LmisDataImportDetailsClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = lmisDataImportDetails.getPrimaryKey();

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

		sb.append("{lmisDataImportDetailsId=");
		sb.append(getLmisDataImportDetailsId());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", importId=");
		sb.append(getImportId());
		sb.append(", startTime=");
		sb.append(getStartTime());
		sb.append(", endTime=");
		sb.append(getEndTime());
		sb.append(", scannerId=");
		sb.append(getScannerId());
		sb.append(", abSence=");
		sb.append(getAbSence());
		sb.append(", staffName=");
		sb.append(getStaffName());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.lmis.model.LmisDataImportDetails");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>lmisDataImportDetailsId</column-name><column-value><![CDATA[");
		sb.append(getLmisDataImportDetailsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rootId</column-name><column-value><![CDATA[");
		sb.append(getRootId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>importId</column-name><column-value><![CDATA[");
		sb.append(getImportId());
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
			"<column><column-name>scannerId</column-name><column-value><![CDATA[");
		sb.append(getScannerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>abSence</column-name><column-value><![CDATA[");
		sb.append(getAbSence());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>staffName</column-name><column-value><![CDATA[");
		sb.append(getStaffName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _lmisDataImportDetailsId;
	private int _rootId;
	private int _importId;
	private Date _startTime;
	private Date _endTime;
	private String _scannerId;
	private int _abSence;
	private String _staffName;
}