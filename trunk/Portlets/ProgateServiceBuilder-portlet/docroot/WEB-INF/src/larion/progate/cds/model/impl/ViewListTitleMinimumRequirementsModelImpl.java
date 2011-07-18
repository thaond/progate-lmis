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

package larion.progate.cds.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import larion.progate.cds.model.ViewListTitleMinimumRequirements;
import larion.progate.cds.model.ViewListTitleMinimumRequirementsSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="ViewListTitleMinimumRequirementsModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ViewListTitleMinimumRequirementsModelImpl extends BaseModelImpl<ViewListTitleMinimumRequirements> {
	public static final String TABLE_NAME = "v_title_minimum_requirements";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.VARCHAR) },
			

			{ "title_id", new Integer(Types.INTEGER) },
			

			{ "root_id", new Integer(Types.INTEGER) },
			

			{ "title_name", new Integer(Types.VARCHAR) },
			

			{ "abbreviation", new Integer(Types.VARCHAR) },
			

			{ "minimum_requirement_id", new Integer(Types.INTEGER) },
			

			{ "minimum_requirement_name", new Integer(Types.VARCHAR) },
			

			{ "minimum_requirement_number_order", new Integer(Types.INTEGER) },
			

			{ "level_id", new Integer(Types.INTEGER) },
			

			{ "level", new Integer(Types.VARCHAR) }
		};
	public static final String TABLE_SQL_CREATE = "create table v_title_minimum_requirements (id VARCHAR(75) not null primary key,title_id INTEGER,root_id INTEGER,title_name VARCHAR(75) null,abbreviation VARCHAR(75) null,minimum_requirement_id INTEGER,minimum_requirement_name VARCHAR(75) null,minimum_requirement_number_order INTEGER,level_id INTEGER,level VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table v_title_minimum_requirements";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.cds.model.ViewListTitleMinimumRequirements"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.cds.model.ViewListTitleMinimumRequirements"),
			false);

	public static ViewListTitleMinimumRequirements toModel(
		ViewListTitleMinimumRequirementsSoap soapModel) {
		ViewListTitleMinimumRequirements model = new ViewListTitleMinimumRequirementsImpl();

		model.setId(soapModel.getId());
		model.setTitleId(soapModel.getTitleId());
		model.setRootId(soapModel.getRootId());
		model.setTitleName(soapModel.getTitleName());
		model.setAbbreviation(soapModel.getAbbreviation());
		model.setMinimumRequirementId(soapModel.getMinimumRequirementId());
		model.setMinimumRequirementName(soapModel.getMinimumRequirementName());
		model.setMinimumRequirementNumberOrder(soapModel.getMinimumRequirementNumberOrder());
		model.setLevelId(soapModel.getLevelId());
		model.setLevel(soapModel.getLevel());

		return model;
	}

	public static List<ViewListTitleMinimumRequirements> toModels(
		ViewListTitleMinimumRequirementsSoap[] soapModels) {
		List<ViewListTitleMinimumRequirements> models = new ArrayList<ViewListTitleMinimumRequirements>(soapModels.length);

		for (ViewListTitleMinimumRequirementsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.cds.model.ViewListTitleMinimumRequirements"));

	public ViewListTitleMinimumRequirementsModelImpl() {
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
		return GetterUtil.getString(_id);
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
		return GetterUtil.getString(_titleName);
	}

	public void setTitleName(String titleName) {
		_titleName = titleName;
	}

	public String getAbbreviation() {
		return GetterUtil.getString(_abbreviation);
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
		return GetterUtil.getString(_minimumRequirementName);
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
		return GetterUtil.getString(_level);
	}

	public void setLevel(String level) {
		_level = level;
	}

	public ViewListTitleMinimumRequirements toEscapedModel() {
		if (isEscapedModel()) {
			return (ViewListTitleMinimumRequirements)this;
		}
		else {
			ViewListTitleMinimumRequirements model = new ViewListTitleMinimumRequirementsImpl();

			model.setNew(isNew());
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
		ViewListTitleMinimumRequirementsImpl clone = new ViewListTitleMinimumRequirementsImpl();

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

		ViewListTitleMinimumRequirements viewListTitleMinimumRequirements = null;

		try {
			viewListTitleMinimumRequirements = (ViewListTitleMinimumRequirements)obj;
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