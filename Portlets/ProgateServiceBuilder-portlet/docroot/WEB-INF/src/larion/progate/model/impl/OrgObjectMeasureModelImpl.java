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

package larion.progate.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import larion.progate.model.OrgObjectMeasure;
import larion.progate.model.OrgObjectMeasureSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="OrgObjectMeasureModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class OrgObjectMeasureModelImpl extends BaseModelImpl<OrgObjectMeasure> {
	public static final String TABLE_NAME = "ebsc_orgobjectives_measures";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "obj_id", new Integer(Types.INTEGER) },
			

			{ "name", new Integer(Types.VARCHAR) },
			

			{ "description", new Integer(Types.VARCHAR) },
			

			{ "created_date", new Integer(Types.TIMESTAMP) },
			

			{ "weight_percent", new Integer(Types.DOUBLE) },
			

			{ "isassessed", new Integer(Types.BOOLEAN) },
			

			{ "result", new Integer(Types.DOUBLE) },
			

			{ "entering_percent", new Integer(Types.DOUBLE) },
			

			{ "completion_percent", new Integer(Types.DOUBLE) },
			

			{ "formula", new Integer(Types.VARCHAR) },
			

			{ "target_count", new Integer(Types.INTEGER) },
			

			{ "interpretation", new Integer(Types.VARCHAR) },
			

			{ "weight_percent_suggested", new Integer(Types.DOUBLE) }
		};
	public static final String TABLE_SQL_CREATE = "create table ebsc_orgobjectives_measures (id INTEGER not null primary key,obj_id INTEGER,name VARCHAR(75) null,description VARCHAR(75) null,created_date DATE null,weight_percent DOUBLE,isassessed BOOLEAN,result DOUBLE,entering_percent DOUBLE,completion_percent DOUBLE,formula VARCHAR(75) null,target_count INTEGER,interpretation VARCHAR(75) null,weight_percent_suggested DOUBLE)";
	public static final String TABLE_SQL_DROP = "drop table ebsc_orgobjectives_measures";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.model.OrgObjectMeasure"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.model.OrgObjectMeasure"),
			true);

	public static OrgObjectMeasure toModel(OrgObjectMeasureSoap soapModel) {
		OrgObjectMeasure model = new OrgObjectMeasureImpl();

		model.setOrgObjectMeasureId(soapModel.getOrgObjectMeasureId());
		model.setOrgObjectObjectiveId(soapModel.getOrgObjectObjectiveId());
		model.setName(soapModel.getName());
		model.setDescription(soapModel.getDescription());
		model.setCreated_date(soapModel.getCreated_date());
		model.setWeight_percent(soapModel.getWeight_percent());
		model.setIsassessed(soapModel.getIsassessed());
		model.setResult(soapModel.getResult());
		model.setEntering_percent(soapModel.getEntering_percent());
		model.setCompletion_percent(soapModel.getCompletion_percent());
		model.setFormula(soapModel.getFormula());
		model.setTarget_count(soapModel.getTarget_count());
		model.setInterpretation(soapModel.getInterpretation());
		model.setWeight_percent_suggested(soapModel.getWeight_percent_suggested());

		return model;
	}

	public static List<OrgObjectMeasure> toModels(
		OrgObjectMeasureSoap[] soapModels) {
		List<OrgObjectMeasure> models = new ArrayList<OrgObjectMeasure>(soapModels.length);

		for (OrgObjectMeasureSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.model.OrgObjectMeasure"));

	public OrgObjectMeasureModelImpl() {
	}

	public Integer getPrimaryKey() {
		return _orgObjectMeasureId;
	}

	public void setPrimaryKey(Integer pk) {
		setOrgObjectMeasureId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _orgObjectMeasureId;
	}

	public Integer getOrgObjectMeasureId() {
		return _orgObjectMeasureId;
	}

	public void setOrgObjectMeasureId(Integer orgObjectMeasureId) {
		_orgObjectMeasureId = orgObjectMeasureId;
	}

	public int getOrgObjectObjectiveId() {
		return _OrgObjectObjectiveId;
	}

	public void setOrgObjectObjectiveId(int OrgObjectObjectiveId) {
		_OrgObjectObjectiveId = OrgObjectObjectiveId;
	}

	public String getName() {
		return GetterUtil.getString(_name);
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return GetterUtil.getString(_description);
	}

	public void setDescription(String description) {
		_description = description;
	}

	public Date getCreated_date() {
		return _created_date;
	}

	public void setCreated_date(Date created_date) {
		_created_date = created_date;
	}

	public double getWeight_percent() {
		return _weight_percent;
	}

	public void setWeight_percent(double weight_percent) {
		_weight_percent = weight_percent;
	}

	public boolean getIsassessed() {
		return _isassessed;
	}

	public boolean isIsassessed() {
		return _isassessed;
	}

	public void setIsassessed(boolean isassessed) {
		_isassessed = isassessed;
	}

	public double getResult() {
		return _result;
	}

	public void setResult(double result) {
		_result = result;
	}

	public double getEntering_percent() {
		return _entering_percent;
	}

	public void setEntering_percent(double entering_percent) {
		_entering_percent = entering_percent;
	}

	public double getCompletion_percent() {
		return _completion_percent;
	}

	public void setCompletion_percent(double completion_percent) {
		_completion_percent = completion_percent;
	}

	public String getFormula() {
		return GetterUtil.getString(_formula);
	}

	public void setFormula(String formula) {
		_formula = formula;
	}

	public int getTarget_count() {
		return _target_count;
	}

	public void setTarget_count(int target_count) {
		_target_count = target_count;
	}

	public String getInterpretation() {
		return GetterUtil.getString(_interpretation);
	}

	public void setInterpretation(String interpretation) {
		_interpretation = interpretation;
	}

	public double getWeight_percent_suggested() {
		return _weight_percent_suggested;
	}

	public void setWeight_percent_suggested(double weight_percent_suggested) {
		_weight_percent_suggested = weight_percent_suggested;
	}

	public OrgObjectMeasure toEscapedModel() {
		if (isEscapedModel()) {
			return (OrgObjectMeasure)this;
		}
		else {
			OrgObjectMeasure model = new OrgObjectMeasureImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setOrgObjectMeasureId(getOrgObjectMeasureId());
			model.setOrgObjectObjectiveId(getOrgObjectObjectiveId());
			model.setName(HtmlUtil.escape(getName()));
			model.setDescription(HtmlUtil.escape(getDescription()));
			model.setCreated_date(getCreated_date());
			model.setWeight_percent(getWeight_percent());
			model.setIsassessed(getIsassessed());
			model.setResult(getResult());
			model.setEntering_percent(getEntering_percent());
			model.setCompletion_percent(getCompletion_percent());
			model.setFormula(HtmlUtil.escape(getFormula()));
			model.setTarget_count(getTarget_count());
			model.setInterpretation(HtmlUtil.escape(getInterpretation()));
			model.setWeight_percent_suggested(getWeight_percent_suggested());

			model = (OrgObjectMeasure)Proxy.newProxyInstance(OrgObjectMeasure.class.getClassLoader(),
					new Class[] { OrgObjectMeasure.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		OrgObjectMeasureImpl clone = new OrgObjectMeasureImpl();

		clone.setOrgObjectMeasureId(getOrgObjectMeasureId());
		clone.setOrgObjectObjectiveId(getOrgObjectObjectiveId());
		clone.setName(getName());
		clone.setDescription(getDescription());
		clone.setCreated_date(getCreated_date());
		clone.setWeight_percent(getWeight_percent());
		clone.setIsassessed(getIsassessed());
		clone.setResult(getResult());
		clone.setEntering_percent(getEntering_percent());
		clone.setCompletion_percent(getCompletion_percent());
		clone.setFormula(getFormula());
		clone.setTarget_count(getTarget_count());
		clone.setInterpretation(getInterpretation());
		clone.setWeight_percent_suggested(getWeight_percent_suggested());

		return clone;
	}

	public int compareTo(OrgObjectMeasure orgObjectMeasure) {
		int value = 0;

		if (getOrgObjectObjectiveId() < orgObjectMeasure.getOrgObjectObjectiveId()) {
			value = -1;
		}
		else if (getOrgObjectObjectiveId() > orgObjectMeasure.getOrgObjectObjectiveId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = getOrgObjectMeasureId()
					.compareTo(orgObjectMeasure.getOrgObjectMeasureId());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		OrgObjectMeasure orgObjectMeasure = null;

		try {
			orgObjectMeasure = (OrgObjectMeasure)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = orgObjectMeasure.getPrimaryKey();

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

		sb.append("{orgObjectMeasureId=");
		sb.append(getOrgObjectMeasureId());
		sb.append(", OrgObjectObjectiveId=");
		sb.append(getOrgObjectObjectiveId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", created_date=");
		sb.append(getCreated_date());
		sb.append(", weight_percent=");
		sb.append(getWeight_percent());
		sb.append(", isassessed=");
		sb.append(getIsassessed());
		sb.append(", result=");
		sb.append(getResult());
		sb.append(", entering_percent=");
		sb.append(getEntering_percent());
		sb.append(", completion_percent=");
		sb.append(getCompletion_percent());
		sb.append(", formula=");
		sb.append(getFormula());
		sb.append(", target_count=");
		sb.append(getTarget_count());
		sb.append(", interpretation=");
		sb.append(getInterpretation());
		sb.append(", weight_percent_suggested=");
		sb.append(getWeight_percent_suggested());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.model.OrgObjectMeasure");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>orgObjectMeasureId</column-name><column-value><![CDATA[");
		sb.append(getOrgObjectMeasureId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>OrgObjectObjectiveId</column-name><column-value><![CDATA[");
		sb.append(getOrgObjectObjectiveId());
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
			"<column><column-name>created_date</column-name><column-value><![CDATA[");
		sb.append(getCreated_date());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>weight_percent</column-name><column-value><![CDATA[");
		sb.append(getWeight_percent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isassessed</column-name><column-value><![CDATA[");
		sb.append(getIsassessed());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>result</column-name><column-value><![CDATA[");
		sb.append(getResult());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>entering_percent</column-name><column-value><![CDATA[");
		sb.append(getEntering_percent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>completion_percent</column-name><column-value><![CDATA[");
		sb.append(getCompletion_percent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>formula</column-name><column-value><![CDATA[");
		sb.append(getFormula());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>target_count</column-name><column-value><![CDATA[");
		sb.append(getTarget_count());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>interpretation</column-name><column-value><![CDATA[");
		sb.append(getInterpretation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>weight_percent_suggested</column-name><column-value><![CDATA[");
		sb.append(getWeight_percent_suggested());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _orgObjectMeasureId;
	private int _OrgObjectObjectiveId;
	private String _name;
	private String _description;
	private Date _created_date;
	private double _weight_percent;
	private boolean _isassessed;
	private double _result;
	private double _entering_percent;
	private double _completion_percent;
	private String _formula;
	private int _target_count;
	private String _interpretation;
	private double _weight_percent_suggested;
}