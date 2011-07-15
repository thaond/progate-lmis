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
 * <a href="CdsCdpClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsCdpClp extends BaseModelImpl<CdsCdp> implements CdsCdp {
	public CdsCdpClp() {
	}

	public Integer getPrimaryKey() {
		return _CdsCdpId;
	}

	public void setPrimaryKey(Integer pk) {
		setCdsCdpId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _CdsCdpId;
	}

	public Integer getCdsCdpId() {
		return _CdsCdpId;
	}

	public void setCdsCdpId(Integer CdsCdpId) {
		_CdsCdpId = CdsCdpId;
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

	public int getWrittenBy() {
		return _writtenBy;
	}

	public void setWrittenBy(int writtenBy) {
		_writtenBy = writtenBy;
	}

	public Date getWrittenAt() {
		return _writtenAt;
	}

	public void setWrittenAt(Date writtenAt) {
		_writtenAt = writtenAt;
	}

	public String getWrittenContent() {
		return _writtenContent;
	}

	public void setWrittenContent(String writtenContent) {
		_writtenContent = writtenContent;
	}

	public CdsCdp toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			CdsCdp model = new CdsCdpClp();

			model.setEscapedModel(true);

			model.setCdsCdpId(getCdsCdpId());
			model.setRootId(getRootId());
			model.setPeriodId(getPeriodId());
			model.setUserId(getUserId());
			model.setWrittenBy(getWrittenBy());
			model.setWrittenAt(getWrittenAt());
			model.setWrittenContent(HtmlUtil.escape(getWrittenContent()));

			model = (CdsCdp)Proxy.newProxyInstance(CdsCdp.class.getClassLoader(),
					new Class[] { CdsCdp.class }, new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		CdsCdpClp clone = new CdsCdpClp();

		clone.setCdsCdpId(getCdsCdpId());
		clone.setRootId(getRootId());
		clone.setPeriodId(getPeriodId());
		clone.setUserId(getUserId());
		clone.setWrittenBy(getWrittenBy());
		clone.setWrittenAt(getWrittenAt());
		clone.setWrittenContent(getWrittenContent());

		return clone;
	}

	public int compareTo(CdsCdp cdsCdp) {
		Integer pk = cdsCdp.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		CdsCdpClp cdsCdp = null;

		try {
			cdsCdp = (CdsCdpClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = cdsCdp.getPrimaryKey();

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

		sb.append("{CdsCdpId=");
		sb.append(getCdsCdpId());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", periodId=");
		sb.append(getPeriodId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", writtenBy=");
		sb.append(getWrittenBy());
		sb.append(", writtenAt=");
		sb.append(getWrittenAt());
		sb.append(", writtenContent=");
		sb.append(getWrittenContent());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.cds.model.CdsCdp");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>CdsCdpId</column-name><column-value><![CDATA[");
		sb.append(getCdsCdpId());
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
			"<column><column-name>writtenBy</column-name><column-value><![CDATA[");
		sb.append(getWrittenBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>writtenAt</column-name><column-value><![CDATA[");
		sb.append(getWrittenAt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>writtenContent</column-name><column-value><![CDATA[");
		sb.append(getWrittenContent());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _CdsCdpId;
	private int _rootId;
	private int _periodId;
	private int _userId;
	private int _writtenBy;
	private Date _writtenAt;
	private String _writtenContent;
}