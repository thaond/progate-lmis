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
 * <a href="LevelClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LevelClp extends BaseModelImpl<Level> implements Level {
	public LevelClp() {
	}

	public Integer getPrimaryKey() {
		return _levelId;
	}

	public void setPrimaryKey(Integer pk) {
		setLevelId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _levelId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public Integer getLevelId() {
		return _levelId;
	}

	public void setLevelId(Integer levelId) {
		_levelId = levelId;
	}

	public int getCompetencyId() {
		return _competencyId;
	}

	public void setCompetencyId(int competencyId) {
		_competencyId = competencyId;
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

	public String getAliasName() {
		return _aliasName;
	}

	public void setAliasName(String aliasName) {
		_aliasName = aliasName;
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

	public Level toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			Level model = new LevelClp();

			model.setEscapedModel(true);

			model.setRootId(getRootId());
			model.setLevelId(getLevelId());
			model.setCompetencyId(getCompetencyId());
			model.setName(HtmlUtil.escape(getName()));
			model.setDescription(HtmlUtil.escape(getDescription()));
			model.setNumberOrder(getNumberOrder());
			model.setAliasName(HtmlUtil.escape(getAliasName()));
			model.setCreatedBy(getCreatedBy());
			model.setCreatedAt(getCreatedAt());
			model.setUpdatedBy(getUpdatedBy());
			model.setUpdatedAt(getUpdatedAt());

			model = (Level)Proxy.newProxyInstance(Level.class.getClassLoader(),
					new Class[] { Level.class }, new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		LevelClp clone = new LevelClp();

		clone.setRootId(getRootId());
		clone.setLevelId(getLevelId());
		clone.setCompetencyId(getCompetencyId());
		clone.setName(getName());
		clone.setDescription(getDescription());
		clone.setNumberOrder(getNumberOrder());
		clone.setAliasName(getAliasName());
		clone.setCreatedBy(getCreatedBy());
		clone.setCreatedAt(getCreatedAt());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedAt(getUpdatedAt());

		return clone;
	}

	public int compareTo(Level level) {
		int value = 0;

		if (getNumberOrder() < level.getNumberOrder()) {
			value = -1;
		}
		else if (getNumberOrder() > level.getNumberOrder()) {
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

		LevelClp level = null;

		try {
			level = (LevelClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = level.getPrimaryKey();

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

		sb.append("{rootId=");
		sb.append(getRootId());
		sb.append(", levelId=");
		sb.append(getLevelId());
		sb.append(", competencyId=");
		sb.append(getCompetencyId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", numberOrder=");
		sb.append(getNumberOrder());
		sb.append(", aliasName=");
		sb.append(getAliasName());
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
		sb.append("larion.progate.cds.model.Level");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>rootId</column-name><column-value><![CDATA[");
		sb.append(getRootId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>levelId</column-name><column-value><![CDATA[");
		sb.append(getLevelId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>competencyId</column-name><column-value><![CDATA[");
		sb.append(getCompetencyId());
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
			"<column><column-name>aliasName</column-name><column-value><![CDATA[");
		sb.append(getAliasName());
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

	private int _rootId;
	private Integer _levelId;
	private int _competencyId;
	private String _name;
	private String _description;
	private int _numberOrder;
	private String _aliasName;
	private int _createdBy;
	private Date _createdAt;
	private int _updatedBy;
	private Date _updatedAt;
}