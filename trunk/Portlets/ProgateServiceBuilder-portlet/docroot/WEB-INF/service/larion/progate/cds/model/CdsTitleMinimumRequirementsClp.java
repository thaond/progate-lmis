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
 * <a href="CdsTitleMinimumRequirementsClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsTitleMinimumRequirementsClp extends BaseModelImpl<CdsTitleMinimumRequirements>
	implements CdsTitleMinimumRequirements {
	public CdsTitleMinimumRequirementsClp() {
	}

	public Integer getPrimaryKey() {
		return _CdsTitleMinimumRequirementsId;
	}

	public void setPrimaryKey(Integer pk) {
		setCdsTitleMinimumRequirementsId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _CdsTitleMinimumRequirementsId;
	}

	public Integer getCdsTitleMinimumRequirementsId() {
		return _CdsTitleMinimumRequirementsId;
	}

	public void setCdsTitleMinimumRequirementsId(
		Integer CdsTitleMinimumRequirementsId) {
		_CdsTitleMinimumRequirementsId = CdsTitleMinimumRequirementsId;
	}

	public int getTitleId() {
		return _titleId;
	}

	public void setTitleId(int titleId) {
		_titleId = titleId;
	}

	public int getMinimumRequirementId() {
		return _minimumRequirementId;
	}

	public void setMinimumRequirementId(int minimumRequirementId) {
		_minimumRequirementId = minimumRequirementId;
	}

	public int getMinimumRequirementLevelId() {
		return _minimumRequirementLevelId;
	}

	public void setMinimumRequirementLevelId(int minimumRequirementLevelId) {
		_minimumRequirementLevelId = minimumRequirementLevelId;
	}

	public CdsTitleMinimumRequirements toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			CdsTitleMinimumRequirements model = new CdsTitleMinimumRequirementsClp();

			model.setEscapedModel(true);

			model.setCdsTitleMinimumRequirementsId(getCdsTitleMinimumRequirementsId());
			model.setTitleId(getTitleId());
			model.setMinimumRequirementId(getMinimumRequirementId());
			model.setMinimumRequirementLevelId(getMinimumRequirementLevelId());

			model = (CdsTitleMinimumRequirements)Proxy.newProxyInstance(CdsTitleMinimumRequirements.class.getClassLoader(),
					new Class[] { CdsTitleMinimumRequirements.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		CdsTitleMinimumRequirementsClp clone = new CdsTitleMinimumRequirementsClp();

		clone.setCdsTitleMinimumRequirementsId(getCdsTitleMinimumRequirementsId());
		clone.setTitleId(getTitleId());
		clone.setMinimumRequirementId(getMinimumRequirementId());
		clone.setMinimumRequirementLevelId(getMinimumRequirementLevelId());

		return clone;
	}

	public int compareTo(
		CdsTitleMinimumRequirements cdsTitleMinimumRequirements) {
		Integer pk = cdsTitleMinimumRequirements.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		CdsTitleMinimumRequirementsClp cdsTitleMinimumRequirements = null;

		try {
			cdsTitleMinimumRequirements = (CdsTitleMinimumRequirementsClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = cdsTitleMinimumRequirements.getPrimaryKey();

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

		sb.append("{CdsTitleMinimumRequirementsId=");
		sb.append(getCdsTitleMinimumRequirementsId());
		sb.append(", titleId=");
		sb.append(getTitleId());
		sb.append(", minimumRequirementId=");
		sb.append(getMinimumRequirementId());
		sb.append(", minimumRequirementLevelId=");
		sb.append(getMinimumRequirementLevelId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.cds.model.CdsTitleMinimumRequirements");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>CdsTitleMinimumRequirementsId</column-name><column-value><![CDATA[");
		sb.append(getCdsTitleMinimumRequirementsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>titleId</column-name><column-value><![CDATA[");
		sb.append(getTitleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>minimumRequirementId</column-name><column-value><![CDATA[");
		sb.append(getMinimumRequirementId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>minimumRequirementLevelId</column-name><column-value><![CDATA[");
		sb.append(getMinimumRequirementLevelId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _CdsTitleMinimumRequirementsId;
	private int _titleId;
	private int _minimumRequirementId;
	private int _minimumRequirementLevelId;
}