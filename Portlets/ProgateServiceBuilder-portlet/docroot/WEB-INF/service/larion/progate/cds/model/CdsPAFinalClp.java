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
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * <a href="CdsPAFinalClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsPAFinalClp extends BaseModelImpl<CdsPAFinal>
	implements CdsPAFinal {
	public CdsPAFinalClp() {
	}

	public Integer getPrimaryKey() {
		return _cdsPAFinalId;
	}

	public void setPrimaryKey(Integer pk) {
		setCdsPAFinalId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _cdsPAFinalId;
	}

	public Integer getCdsPAFinalId() {
		return _cdsPAFinalId;
	}

	public void setCdsPAFinalId(Integer cdsPAFinalId) {
		_cdsPAFinalId = cdsPAFinalId;
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

	public int getCdsTitleId() {
		return _cdsTitleId;
	}

	public void setCdsTitleId(int cdsTitleId) {
		_cdsTitleId = cdsTitleId;
	}

	public CdsPAFinal toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			CdsPAFinal model = new CdsPAFinalClp();

			model.setEscapedModel(true);

			model.setCdsPAFinalId(getCdsPAFinalId());
			model.setRootId(getRootId());
			model.setUserId(getUserId());
			model.setCdsTitleId(getCdsTitleId());

			model = (CdsPAFinal)Proxy.newProxyInstance(CdsPAFinal.class.getClassLoader(),
					new Class[] { CdsPAFinal.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		CdsPAFinalClp clone = new CdsPAFinalClp();

		clone.setCdsPAFinalId(getCdsPAFinalId());
		clone.setRootId(getRootId());
		clone.setUserId(getUserId());
		clone.setCdsTitleId(getCdsTitleId());

		return clone;
	}

	public int compareTo(CdsPAFinal cdsPAFinal) {
		Integer pk = cdsPAFinal.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		CdsPAFinalClp cdsPAFinal = null;

		try {
			cdsPAFinal = (CdsPAFinalClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = cdsPAFinal.getPrimaryKey();

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

		sb.append("{cdsPAFinalId=");
		sb.append(getCdsPAFinalId());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", cdsTitleId=");
		sb.append(getCdsTitleId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.cds.model.CdsPAFinal");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>cdsPAFinalId</column-name><column-value><![CDATA[");
		sb.append(getCdsPAFinalId());
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
			"<column><column-name>cdsTitleId</column-name><column-value><![CDATA[");
		sb.append(getCdsTitleId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _cdsPAFinalId;
	private int _rootId;
	private int _userId;
	private int _cdsTitleId;
}