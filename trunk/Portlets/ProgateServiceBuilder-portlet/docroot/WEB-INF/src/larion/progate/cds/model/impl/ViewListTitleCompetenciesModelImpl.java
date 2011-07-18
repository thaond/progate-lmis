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

import larion.progate.cds.model.ViewListTitleCompetencies;
import larion.progate.cds.model.ViewListTitleCompetenciesSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="ViewListTitleCompetenciesModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ViewListTitleCompetenciesModelImpl extends BaseModelImpl<ViewListTitleCompetencies> {
	public static final String TABLE_NAME = "v_title_competencies";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.VARCHAR) },
			

			{ "title_id", new Integer(Types.INTEGER) },
			

			{ "root_id", new Integer(Types.INTEGER) },
			

			{ "title_name", new Integer(Types.VARCHAR) },
			

			{ "abbreviation", new Integer(Types.VARCHAR) },
			

			{ "competency_id", new Integer(Types.INTEGER) },
			

			{ "competency_name", new Integer(Types.VARCHAR) },
			

			{ "competency_number_order", new Integer(Types.INTEGER) },
			

			{ "point_hash", new Integer(Types.INTEGER) },
			

			{ "point_value", new Integer(Types.VARCHAR) }
		};
	public static final String TABLE_SQL_CREATE = "create table v_title_competencies (id VARCHAR(75) not null primary key,title_id INTEGER,root_id INTEGER,title_name VARCHAR(75) null,abbreviation VARCHAR(75) null,competency_id INTEGER,competency_name VARCHAR(75) null,competency_number_order INTEGER,point_hash INTEGER,point_value VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table v_title_competencies";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.cds.model.ViewListTitleCompetencies"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.cds.model.ViewListTitleCompetencies"),
			false);

	public static ViewListTitleCompetencies toModel(
		ViewListTitleCompetenciesSoap soapModel) {
		ViewListTitleCompetencies model = new ViewListTitleCompetenciesImpl();

		model.setId(soapModel.getId());
		model.setTitleId(soapModel.getTitleId());
		model.setRootId(soapModel.getRootId());
		model.setTitleName(soapModel.getTitleName());
		model.setAbbreviation(soapModel.getAbbreviation());
		model.setCompetencyId(soapModel.getCompetencyId());
		model.setCompetencyName(soapModel.getCompetencyName());
		model.setCompetencyNumberOrder(soapModel.getCompetencyNumberOrder());
		model.setPointHash(soapModel.getPointHash());
		model.setPointValue(soapModel.getPointValue());

		return model;
	}

	public static List<ViewListTitleCompetencies> toModels(
		ViewListTitleCompetenciesSoap[] soapModels) {
		List<ViewListTitleCompetencies> models = new ArrayList<ViewListTitleCompetencies>(soapModels.length);

		for (ViewListTitleCompetenciesSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.cds.model.ViewListTitleCompetencies"));

	public ViewListTitleCompetenciesModelImpl() {
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

	public int getCompetencyId() {
		return _competencyId;
	}

	public void setCompetencyId(int competencyId) {
		_competencyId = competencyId;
	}

	public String getCompetencyName() {
		return GetterUtil.getString(_competencyName);
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
		return GetterUtil.getString(_pointValue);
	}

	public void setPointValue(String pointValue) {
		_pointValue = pointValue;
	}

	public ViewListTitleCompetencies toEscapedModel() {
		if (isEscapedModel()) {
			return (ViewListTitleCompetencies)this;
		}
		else {
			ViewListTitleCompetencies model = new ViewListTitleCompetenciesImpl();

			model.setNew(isNew());
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
		ViewListTitleCompetenciesImpl clone = new ViewListTitleCompetenciesImpl();

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

		ViewListTitleCompetencies viewListTitleCompetencies = null;

		try {
			viewListTitleCompetencies = (ViewListTitleCompetencies)obj;
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