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

import larion.progate.model.OrgObjectObjective;
import larion.progate.model.OrgObjectObjectiveSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="OrgObjectObjectiveModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class OrgObjectObjectiveModelImpl extends BaseModelImpl<OrgObjectObjective> {
	public static final String TABLE_NAME = "ebsc_orgobjectives_objectives";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "obj_id", new Integer(Types.INTEGER) },
			

			{ "name", new Integer(Types.VARCHAR) },
			

			{ "description", new Integer(Types.VARCHAR) },
			

			{ "created_date", new Integer(Types.TIMESTAMP) },
			

			{ "weight_percent", new Integer(Types.DOUBLE) },
			

			{ "entering_percent", new Integer(Types.DOUBLE) },
			

			{ "completion_percent", new Integer(Types.DOUBLE) },
			

			{ "measure_count", new Integer(Types.INTEGER) },
			

			{ "validweight", new Integer(Types.BOOLEAN) },
			

			{ "consistency_ratio", new Integer(Types.DOUBLE) },
			

			{ "weight_percent_suggested", new Integer(Types.DOUBLE) }
		};
	public static final String TABLE_SQL_CREATE = "create table ebsc_orgobjectives_objectives (id INTEGER not null primary key,obj_id INTEGER,name VARCHAR(75) null,description VARCHAR(75) null,created_date DATE null,weight_percent DOUBLE,entering_percent DOUBLE,completion_percent DOUBLE,measure_count INTEGER,validweight BOOLEAN,consistency_ratio DOUBLE,weight_percent_suggested DOUBLE)";
	public static final String TABLE_SQL_DROP = "drop table ebsc_orgobjectives_objectives";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.model.OrgObjectObjective"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.model.OrgObjectObjective"),
			true);

	public static OrgObjectObjective toModel(OrgObjectObjectiveSoap soapModel) {
		OrgObjectObjective model = new OrgObjectObjectiveImpl();

		model.setOrgObjectObjectiveId(soapModel.getOrgObjectObjectiveId());
		model.setOrgObjectPerspectiveId(soapModel.getOrgObjectPerspectiveId());
		model.setName(soapModel.getName());
		model.setDescription(soapModel.getDescription());
		model.setCreated_date(soapModel.getCreated_date());
		model.setWeight_percent(soapModel.getWeight_percent());
		model.setEntering_percent(soapModel.getEntering_percent());
		model.setCompletion_percent(soapModel.getCompletion_percent());
		model.setMeasure_count(soapModel.getMeasure_count());
		model.setValidweight(soapModel.getValidweight());
		model.setConsistency_ratio(soapModel.getConsistency_ratio());
		model.setWeight_percent_suggested(soapModel.getWeight_percent_suggested());

		return model;
	}

	public static List<OrgObjectObjective> toModels(
		OrgObjectObjectiveSoap[] soapModels) {
		List<OrgObjectObjective> models = new ArrayList<OrgObjectObjective>(soapModels.length);

		for (OrgObjectObjectiveSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.model.OrgObjectObjective"));

	public OrgObjectObjectiveModelImpl() {
	}

	public Integer getPrimaryKey() {
		return _orgObjectObjectiveId;
	}

	public void setPrimaryKey(Integer pk) {
		setOrgObjectObjectiveId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _orgObjectObjectiveId;
	}

	public Integer getOrgObjectObjectiveId() {
		return _orgObjectObjectiveId;
	}

	public void setOrgObjectObjectiveId(Integer orgObjectObjectiveId) {
		_orgObjectObjectiveId = orgObjectObjectiveId;
	}

	public int getOrgObjectPerspectiveId() {
		return _orgObjectPerspectiveId;
	}

	public void setOrgObjectPerspectiveId(int orgObjectPerspectiveId) {
		_orgObjectPerspectiveId = orgObjectPerspectiveId;
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

	public int getMeasure_count() {
		return _measure_count;
	}

	public void setMeasure_count(int measure_count) {
		_measure_count = measure_count;
	}

	public boolean getValidweight() {
		return _validweight;
	}

	public boolean isValidweight() {
		return _validweight;
	}

	public void setValidweight(boolean validweight) {
		_validweight = validweight;
	}

	public double getConsistency_ratio() {
		return _consistency_ratio;
	}

	public void setConsistency_ratio(double consistency_ratio) {
		_consistency_ratio = consistency_ratio;
	}

	public double getWeight_percent_suggested() {
		return _weight_percent_suggested;
	}

	public void setWeight_percent_suggested(double weight_percent_suggested) {
		_weight_percent_suggested = weight_percent_suggested;
	}

	public OrgObjectObjective toEscapedModel() {
		if (isEscapedModel()) {
			return (OrgObjectObjective)this;
		}
		else {
			OrgObjectObjective model = new OrgObjectObjectiveImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setOrgObjectObjectiveId(getOrgObjectObjectiveId());
			model.setOrgObjectPerspectiveId(getOrgObjectPerspectiveId());
			model.setName(HtmlUtil.escape(getName()));
			model.setDescription(HtmlUtil.escape(getDescription()));
			model.setCreated_date(getCreated_date());
			model.setWeight_percent(getWeight_percent());
			model.setEntering_percent(getEntering_percent());
			model.setCompletion_percent(getCompletion_percent());
			model.setMeasure_count(getMeasure_count());
			model.setValidweight(getValidweight());
			model.setConsistency_ratio(getConsistency_ratio());
			model.setWeight_percent_suggested(getWeight_percent_suggested());

			model = (OrgObjectObjective)Proxy.newProxyInstance(OrgObjectObjective.class.getClassLoader(),
					new Class[] { OrgObjectObjective.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		OrgObjectObjectiveImpl clone = new OrgObjectObjectiveImpl();

		clone.setOrgObjectObjectiveId(getOrgObjectObjectiveId());
		clone.setOrgObjectPerspectiveId(getOrgObjectPerspectiveId());
		clone.setName(getName());
		clone.setDescription(getDescription());
		clone.setCreated_date(getCreated_date());
		clone.setWeight_percent(getWeight_percent());
		clone.setEntering_percent(getEntering_percent());
		clone.setCompletion_percent(getCompletion_percent());
		clone.setMeasure_count(getMeasure_count());
		clone.setValidweight(getValidweight());
		clone.setConsistency_ratio(getConsistency_ratio());
		clone.setWeight_percent_suggested(getWeight_percent_suggested());

		return clone;
	}

	public int compareTo(OrgObjectObjective orgObjectObjective) {
		int value = 0;

		if (getOrgObjectPerspectiveId() < orgObjectObjective.getOrgObjectPerspectiveId()) {
			value = -1;
		}
		else if (getOrgObjectPerspectiveId() > orgObjectObjective.getOrgObjectPerspectiveId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = getOrgObjectObjectiveId()
					.compareTo(orgObjectObjective.getOrgObjectObjectiveId());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		OrgObjectObjective orgObjectObjective = null;

		try {
			orgObjectObjective = (OrgObjectObjective)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = orgObjectObjective.getPrimaryKey();

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

		sb.append("{orgObjectObjectiveId=");
		sb.append(getOrgObjectObjectiveId());
		sb.append(", orgObjectPerspectiveId=");
		sb.append(getOrgObjectPerspectiveId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", created_date=");
		sb.append(getCreated_date());
		sb.append(", weight_percent=");
		sb.append(getWeight_percent());
		sb.append(", entering_percent=");
		sb.append(getEntering_percent());
		sb.append(", completion_percent=");
		sb.append(getCompletion_percent());
		sb.append(", measure_count=");
		sb.append(getMeasure_count());
		sb.append(", validweight=");
		sb.append(getValidweight());
		sb.append(", consistency_ratio=");
		sb.append(getConsistency_ratio());
		sb.append(", weight_percent_suggested=");
		sb.append(getWeight_percent_suggested());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.model.OrgObjectObjective");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>orgObjectObjectiveId</column-name><column-value><![CDATA[");
		sb.append(getOrgObjectObjectiveId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orgObjectPerspectiveId</column-name><column-value><![CDATA[");
		sb.append(getOrgObjectPerspectiveId());
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
			"<column><column-name>entering_percent</column-name><column-value><![CDATA[");
		sb.append(getEntering_percent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>completion_percent</column-name><column-value><![CDATA[");
		sb.append(getCompletion_percent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>measure_count</column-name><column-value><![CDATA[");
		sb.append(getMeasure_count());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>validweight</column-name><column-value><![CDATA[");
		sb.append(getValidweight());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>consistency_ratio</column-name><column-value><![CDATA[");
		sb.append(getConsistency_ratio());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>weight_percent_suggested</column-name><column-value><![CDATA[");
		sb.append(getWeight_percent_suggested());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _orgObjectObjectiveId;
	private int _orgObjectPerspectiveId;
	private String _name;
	private String _description;
	private Date _created_date;
	private double _weight_percent;
	private double _entering_percent;
	private double _completion_percent;
	private int _measure_count;
	private boolean _validweight;
	private double _consistency_ratio;
	private double _weight_percent_suggested;
}