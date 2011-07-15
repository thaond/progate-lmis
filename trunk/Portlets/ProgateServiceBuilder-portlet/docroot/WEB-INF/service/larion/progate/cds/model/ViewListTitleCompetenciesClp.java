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
 * <a href="ViewListTitleCompetenciesClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ViewListTitleCompetenciesClp extends BaseModelImpl<ViewListTitleCompetencies>
	implements ViewListTitleCompetencies {
	public ViewListTitleCompetenciesClp() {
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

	public int getCompetencyId() {
		return _competencyId;
	}

	public void setCompetencyId(int competencyId) {
		_competencyId = competencyId;
	}

	public String getCompetencyName() {
		return _competencyName;
	}

	public void setCompetencyName(String competencyName) {
		_competencyName = competencyName;
	}

	public int getCompetencyNumberOrder() {
		return _competencyNumberOrder;
	}

	public void setCompetencyNumberOrder(int competencyNumberOrder) {
		_competencyNumberOrder = competencyNumberOrder;
	}

	public int getPointHash() {
		return _pointHash;
	}

	public void setPointHash(int pointHash) {
		_pointHash = pointHash;
	}

	public String getPointValue() {
		return _pointValue;
	}

	public void setPointValue(String pointValue) {
		_pointValue = pointValue;
	}

	public ViewListTitleCompetencies toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			ViewListTitleCompetencies model = new ViewListTitleCompetenciesClp();

			model.setEscapedModel(true);

			model.setId(HtmlUtil.escape(getId()));
			model.setTitleId(getTitleId());
			model.setRootId(getRootId());
			model.setTitleName(HtmlUtil.escape(getTitleName()));
			model.setAbbreviation(HtmlUtil.escape(getAbbreviation()));
			model.setCompetencyId(getCompetencyId());
			model.setCompetencyName(HtmlUtil.escape(getCompetencyName()));
			model.setCompetencyNumberOrder(getCompetencyNumberOrder());
			model.setPointHash(getPointHash());
			model.setPointValue(HtmlUtil.escape(getPointValue()));

			model = (ViewListTitleCompetencies)Proxy.newProxyInstance(ViewListTitleCompetencies.class.getClassLoader(),
					new Class[] { ViewListTitleCompetencies.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		ViewListTitleCompetenciesClp clone = new ViewListTitleCompetenciesClp();

		clone.setId(getId());
		clone.setTitleId(getTitleId());
		clone.setRootId(getRootId());
		clone.setTitleName(getTitleName());
		clone.setAbbreviation(getAbbreviation());
		clone.setCompetencyId(getCompetencyId());
		clone.setCompetencyName(getCompetencyName());
		clone.setCompetencyNumberOrder(getCompetencyNumberOrder());
		clone.setPointHash(getPointHash());
		clone.setPointValue(getPointValue());

		return clone;
	}

	public int compareTo(ViewListTitleCompetencies viewListTitleCompetencies) {
		int value = 0;

		if (getCompetencyNumberOrder() < viewListTitleCompetencies.getCompetencyNumberOrder()) {
			value = -1;
		}
		else if (getCompetencyNumberOrder() > viewListTitleCompetencies.getCompetencyNumberOrder()) {
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

		ViewListTitleCompetenciesClp viewListTitleCompetencies = null;

		try {
			viewListTitleCompetencies = (ViewListTitleCompetenciesClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		String pk = viewListTitleCompetencies.getPrimaryKey();

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
		sb.append(", competencyId=");
		sb.append(getCompetencyId());
		sb.append(", competencyName=");
		sb.append(getCompetencyName());
		sb.append(", competencyNumberOrder=");
		sb.append(getCompetencyNumberOrder());
		sb.append(", pointHash=");
		sb.append(getPointHash());
		sb.append(", pointValue=");
		sb.append(getPointValue());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.cds.model.ViewListTitleCompetencies");
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
			"<column><column-name>competencyId</column-name><column-value><![CDATA[");
		sb.append(getCompetencyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>competencyName</column-name><column-value><![CDATA[");
		sb.append(getCompetencyName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>competencyNumberOrder</column-name><column-value><![CDATA[");
		sb.append(getCompetencyNumberOrder());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pointHash</column-name><column-value><![CDATA[");
		sb.append(getPointHash());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pointValue</column-name><column-value><![CDATA[");
		sb.append(getPointValue());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _id;
	private int _titleId;
	private int _rootId;
	private String _titleName;
	private String _abbreviation;
	private int _competencyId;
	private String _competencyName;
	private int _competencyNumberOrder;
	private int _pointHash;
	private String _pointValue;
}