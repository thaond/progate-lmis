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
 * <a href="CdsMinimumRequirementLevelsClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsMinimumRequirementLevelsClp extends BaseModelImpl<CdsMinimumRequirementLevels>
	implements CdsMinimumRequirementLevels {
	public CdsMinimumRequirementLevelsClp() {
	}

	public Integer getPrimaryKey() {
		return _minimumRequirementLevelId;
	}

	public void setPrimaryKey(Integer pk) {
		setMinimumRequirementLevelId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _minimumRequirementLevelId;
	}

	public Integer getMinimumRequirementLevelId() {
		return _minimumRequirementLevelId;
	}

	public void setMinimumRequirementLevelId(Integer minimumRequirementLevelId) {
		_minimumRequirementLevelId = minimumRequirementLevelId;
	}

	public int getMinimumRequirementId() {
		return _minimumRequirementId;
	}

	public void setMinimumRequirementId(int minimumRequirementId) {
		_minimumRequirementId = minimumRequirementId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
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

	public int getCreatedBy() {
		return _createdBy;
	}

	public void setCreatedBy(int createdBy) {
		_createdBy = createdBy;
	}

	public Date getCreatedAt() {
		return _createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		_createdAt = createdAt;
	}

	public int getUpdatedBy() {
		return _updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		_updatedBy = updatedBy;
	}

	public Date getUpdatedAt() {
		return _updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		_updatedAt = updatedAt;
	}

	public CdsMinimumRequirementLevels toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			CdsMinimumRequirementLevels model = new CdsMinimumRequirementLevelsClp();

			model.setEscapedModel(true);

			model.setMinimumRequirementLevelId(getMinimumRequirementLevelId());
			model.setMinimumRequirementId(getMinimumRequirementId());
			model.setName(HtmlUtil.escape(getName()));
			model.setDescription(HtmlUtil.escape(getDescription()));
			model.setNumberOrder(getNumberOrder());
			model.setCreatedBy(getCreatedBy());
			model.setCreatedAt(getCreatedAt());
			model.setUpdatedBy(getUpdatedBy());
			model.setUpdatedAt(getUpdatedAt());

			model = (CdsMinimumRequirementLevels)Proxy.newProxyInstance(CdsMinimumRequirementLevels.class.getClassLoader(),
					new Class[] { CdsMinimumRequirementLevels.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		CdsMinimumRequirementLevelsClp clone = new CdsMinimumRequirementLevelsClp();

		clone.setMinimumRequirementLevelId(getMinimumRequirementLevelId());
		clone.setMinimumRequirementId(getMinimumRequirementId());
		clone.setName(getName());
		clone.setDescription(getDescription());
		clone.setNumberOrder(getNumberOrder());
		clone.setCreatedBy(getCreatedBy());
		clone.setCreatedAt(getCreatedAt());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedAt(getUpdatedAt());

		return clone;
	}

	public int compareTo(
		CdsMinimumRequirementLevels cdsMinimumRequirementLevels) {
		int value = 0;

		if (getNumberOrder() < cdsMinimumRequirementLevels.getNumberOrder()) {
			value = -1;
		}
		else if (getNumberOrder() > cdsMinimumRequirementLevels.getNumberOrder()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		CdsMinimumRequirementLevelsClp cdsMinimumRequirementLevels = null;

		try {
			cdsMinimumRequirementLevels = (CdsMinimumRequirementLevelsClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = cdsMinimumRequirementLevels.getPrimaryKey();

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

		sb.append("{minimumRequirementLevelId=");
		sb.append(getMinimumRequirementLevelId());
		sb.append(", minimumRequirementId=");
		sb.append(getMinimumRequirementId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", numberOrder=");
		sb.append(getNumberOrder());
		sb.append(", createdBy=");
		sb.append(getCreatedBy());
		sb.append(", createdAt=");
		sb.append(getCreatedAt());
		sb.append(", updatedBy=");
		sb.append(getUpdatedBy());
		sb.append(", updatedAt=");
		sb.append(getUpdatedAt());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.cds.model.CdsMinimumRequirementLevels");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>minimumRequirementLevelId</column-name><column-value><![CDATA[");
		sb.append(getMinimumRequirementLevelId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>minimumRequirementId</column-name><column-value><![CDATA[");
		sb.append(getMinimumRequirementId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
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
			"<column><column-name>createdBy</column-name><column-value><![CDATA[");
		sb.append(getCreatedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdAt</column-name><column-value><![CDATA[");
		sb.append(getCreatedAt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>updatedBy</column-name><column-value><![CDATA[");
		sb.append(getUpdatedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>updatedAt</column-name><column-value><![CDATA[");
		sb.append(getUpdatedAt());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _minimumRequirementLevelId;
	private int _minimumRequirementId;
	private String _name;
	private String _description;
	private int _numberOrder;
	private int _createdBy;
	private Date _createdAt;
	private int _updatedBy;
	private Date _updatedAt;
}