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
 * <a href="ViewListTitleMinimumRequirementsClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ViewListTitleMinimumRequirementsClp extends BaseModelImpl<ViewListTitleMinimumRequirements>
	implements ViewListTitleMinimumRequirements {
	public ViewListTitleMinimumRequirementsClp() {
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

	public int getTitleId() {
		return _titleId;
	}

	public void setTitleId(int titleId) {
		_titleId = titleId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public String getTitleName() {
		return _titleName;
	}

	public void setTitleName(String titleName) {
		_titleName = titleName;
	}

	public String getAbbreviation() {
		return _abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		_abbreviation = abbreviation;
	}

	public int getMinimumRequirementId() {
		return _minimumRequirementId;
	}

	public void setMinimumRequirementId(int minimumRequirementId) {
		_minimumRequirementId = minimumRequirementId;
	}

	public String getMinimumRequirementName() {
		return _minimumRequirementName;
	}

	public void setMinimumRequirementName(String minimumRequirementName) {
		_minimumRequirementName = minimumRequirementName;
	}

	public int getMinimumRequirementNumberOrder() {
		return _minimumRequirementNumberOrder;
	}

	public void setMinimumRequirementNumberOrder(
		int minimumRequirementNumberOrder) {
		_minimumRequirementNumberOrder = minimumRequirementNumberOrder;
	}

	public int getLevelId() {
		return _levelId;
	}

	public void setLevelId(int levelId) {
		_levelId = levelId;
	}

	public String getLevel() {
		return _level;
	}

	public void setLevel(String level) {
		_level = level;
	}

	public ViewListTitleMinimumRequirements toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			ViewListTitleMinimumRequirements model = new ViewListTitleMinimumRequirementsClp();

			model.setEscapedModel(true);

			model.setId(HtmlUtil.escape(getId()));
			model.setTitleId(getTitleId());
			model.setRootId(getRootId());
			model.setTitleName(HtmlUtil.escape(getTitleName()));
			model.setAbbreviation(HtmlUtil.escape(getAbbreviation()));
			model.setMinimumRequirementId(getMinimumRequirementId());
			model.setMinimumRequirementName(HtmlUtil.escape(
					getMinimumRequirementName()));
			model.setMinimumRequirementNumberOrder(getMinimumRequirementNumberOrder());
			model.setLevelId(getLevelId());
			model.setLevel(HtmlUtil.escape(getLevel()));

			model = (ViewListTitleMinimumRequirements)Proxy.newProxyInstance(ViewListTitleMinimumRequirements.class.getClassLoader(),
					new Class[] { ViewListTitleMinimumRequirements.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		ViewListTitleMinimumRequirementsClp clone = new ViewListTitleMinimumRequirementsClp();

		clone.setId(getId());
		clone.setTitleId(getTitleId());
		clone.setRootId(getRootId());
		clone.setTitleName(getTitleName());
		clone.setAbbreviation(getAbbreviation());
		clone.setMinimumRequirementId(getMinimumRequirementId());
		clone.setMinimumRequirementName(getMinimumRequirementName());
		clone.setMinimumRequirementNumberOrder(getMinimumRequirementNumberOrder());
		clone.setLevelId(getLevelId());
		clone.setLevel(getLevel());

		return clone;
	}

	public int compareTo(
		ViewListTitleMinimumRequirements viewListTitleMinimumRequirements) {
		int value = 0;

		if (getMinimumRequirementNumberOrder() < viewListTitleMinimumRequirements.getMinimumRequirementNumberOrder()) {
			value = -1;
		}
		else if (getMinimumRequirementNumberOrder() > viewListTitleMinimumRequirements.getMinimumRequirementNumberOrder()) {
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

		ViewListTitleMinimumRequirementsClp viewListTitleMinimumRequirements = null;

		try {
			viewListTitleMinimumRequirements = (ViewListTitleMinimumRequirementsClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		String pk = viewListTitleMinimumRequirements.getPrimaryKey();

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
		sb.append(", titleId=");
		sb.append(getTitleId());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", titleName=");
		sb.append(getTitleName());
		sb.append(", abbreviation=");
		sb.append(getAbbreviation());
		sb.append(", minimumRequirementId=");
		sb.append(getMinimumRequirementId());
		sb.append(", minimumRequirementName=");
		sb.append(getMinimumRequirementName());
		sb.append(", minimumRequirementNumberOrder=");
		sb.append(getMinimumRequirementNumberOrder());
		sb.append(", levelId=");
		sb.append(getLevelId());
		sb.append(", level=");
		sb.append(getLevel());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.cds.model.ViewListTitleMinimumRequirements");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>titleId</column-name><column-value><![CDATA[");
		sb.append(getTitleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rootId</column-name><column-value><![CDATA[");
		sb.append(getRootId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>titleName</column-name><column-value><![CDATA[");
		sb.append(getTitleName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>abbreviation</column-name><column-value><![CDATA[");
		sb.append(getAbbreviation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>minimumRequirementId</column-name><column-value><![CDATA[");
		sb.append(getMinimumRequirementId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>minimumRequirementName</column-name><column-value><![CDATA[");
		sb.append(getMinimumRequirementName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>minimumRequirementNumberOrder</column-name><column-value><![CDATA[");
		sb.append(getMinimumRequirementNumberOrder());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>levelId</column-name><column-value><![CDATA[");
		sb.append(getLevelId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>level</column-name><column-value><![CDATA[");
		sb.append(getLevel());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _id;
	private int _titleId;
	private int _rootId;
	private String _titleName;
	private String _abbreviation;
	private int _minimumRequirementId;
	private String _minimumRequirementName;
	private int _minimumRequirementNumberOrder;
	private int _levelId;
	private String _level;
}