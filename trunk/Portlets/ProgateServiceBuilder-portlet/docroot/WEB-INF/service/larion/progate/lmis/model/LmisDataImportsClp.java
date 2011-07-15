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
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * <a href="LmisDataImportsClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisDataImportsClp extends BaseModelImpl<LmisDataImports>
	implements LmisDataImports {
	public LmisDataImportsClp() {
	}

	public Integer getPrimaryKey() {
		return _lmisDataImportsId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisDataImportsId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _lmisDataImportsId;
	}

	public Integer getLmisDataImportsId() {
		return _lmisDataImportsId;
	}

	public void setLmisDataImportsId(Integer lmisDataImportsId) {
		_lmisDataImportsId = lmisDataImportsId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public Date getDateValue() {
		return _dateValue;
	}

	public void setDateValue(Date dateValue) {
		_dateValue = dateValue;
	}

	public int getImportType() {
		return _importType;
	}

	public void setImportType(int importType) {
		_importType = importType;
	}

	public int getImportBy() {
		return _importBy;
	}

	public void setImportBy(int importBy) {
		_importBy = importBy;
	}

	public Date getImportAt() {
		return _importAt;
	}

	public void setImportAt(Date importAt) {
		_importAt = importAt;
	}

	public int getSessionId() {
		return _sessionId;
	}

	public void setSessionId(int sessionId) {
		_sessionId = sessionId;
	}

	public LmisDataImports toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			LmisDataImports model = new LmisDataImportsClp();

			model.setEscapedModel(true);

			model.setLmisDataImportsId(getLmisDataImportsId());
			model.setRootId(getRootId());
			model.setDateValue(getDateValue());
			model.setImportType(getImportType());
			model.setImportBy(getImportBy());
			model.setImportAt(getImportAt());
			model.setSessionId(getSessionId());

			model = (LmisDataImports)Proxy.newProxyInstance(LmisDataImports.class.getClassLoader(),
					new Class[] { LmisDataImports.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		LmisDataImportsClp clone = new LmisDataImportsClp();

		clone.setLmisDataImportsId(getLmisDataImportsId());
		clone.setRootId(getRootId());
		clone.setDateValue(getDateValue());
		clone.setImportType(getImportType());
		clone.setImportBy(getImportBy());
		clone.setImportAt(getImportAt());
		clone.setSessionId(getSessionId());

		return clone;
	}

	public int compareTo(LmisDataImports lmisDataImports) {
		Integer pk = lmisDataImports.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		LmisDataImportsClp lmisDataImports = null;

		try {
			lmisDataImports = (LmisDataImportsClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = lmisDataImports.getPrimaryKey();

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

		sb.append("{lmisDataImportsId=");
		sb.append(getLmisDataImportsId());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", dateValue=");
		sb.append(getDateValue());
		sb.append(", importType=");
		sb.append(getImportType());
		sb.append(", importBy=");
		sb.append(getImportBy());
		sb.append(", importAt=");
		sb.append(getImportAt());
		sb.append(", sessionId=");
		sb.append(getSessionId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.lmis.model.LmisDataImports");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>lmisDataImportsId</column-name><column-value><![CDATA[");
		sb.append(getLmisDataImportsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rootId</column-name><column-value><![CDATA[");
		sb.append(getRootId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dateValue</column-name><column-value><![CDATA[");
		sb.append(getDateValue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>importType</column-name><column-value><![CDATA[");
		sb.append(getImportType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>importBy</column-name><column-value><![CDATA[");
		sb.append(getImportBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>importAt</column-name><column-value><![CDATA[");
		sb.append(getImportAt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sessionId</column-name><column-value><![CDATA[");
		sb.append(getSessionId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _lmisDataImportsId;
	private int _rootId;
	private Date _dateValue;
	private int _importType;
	private int _importBy;
	private Date _importAt;
	private int _sessionId;
}