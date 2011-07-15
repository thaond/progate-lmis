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

import larion.progate.cds.model.CdsMinimumRequirementLevels;
import larion.progate.cds.model.CdsMinimumRequirementLevelsSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="CdsMinimumRequirementLevelsModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsMinimumRequirementLevelsModelImpl extends BaseModelImpl<CdsMinimumRequirementLevels> {
	public static final String TABLE_NAME = "cds_minimum_requirement_levels";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "minimum_requirement_id", new Integer(Types.INTEGER) },
			

			{ "name", new Integer(Types.VARCHAR) },
			

			{ "description", new Integer(Types.VARCHAR) },
			

			{ "number_order", new Integer(Types.INTEGER) },
			

			{ "created_by", new Integer(Types.INTEGER) },
			

			{ "created_at", new Integer(Types.TIMESTAMP) },
			

			{ "updated_by", new Integer(Types.INTEGER) },
			

			{ "updated_at", new Integer(Types.TIMESTAMP) }
		};
	public static final String TABLE_SQL_CREATE = "create table cds_minimum_requirement_levels (id INTEGER not null primary key,minimum_requirement_id INTEGER,name VARCHAR(75) null,description VARCHAR(75) null,number_order INTEGER,created_by INTEGER,created_at DATE null,updated_by INTEGER,updated_at DATE null)";
	public static final String TABLE_SQL_DROP = "drop table cds_minimum_requirement_levels";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.cds.model.CdsMinimumRequirementLevels"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.cds.model.CdsMinimumRequirementLevels"),
			false);

	public static CdsMinimumRequirementLevels toModel(
		CdsMinimumRequirementLevelsSoap soapModel) {
		CdsMinimumRequirementLevels model = new CdsMinimumRequirementLevelsImpl();

		model.setMinimumRequirementLevelId(soapModel.getMinimumRequirementLevelId());
		model.setMinimumRequirementId(soapModel.getMinimumRequirementId());
		model.setName(soapModel.getName());
		model.setDescription(soapModel.getDescription());
		model.setNumberOrder(soapModel.getNumberOrder());
		model.setCreatedBy(soapModel.getCreatedBy());
		model.setCreatedAt(soapModel.getCreatedAt());
		model.setUpdatedBy(soapModel.getUpdatedBy());
		model.setUpdatedAt(soapModel.getUpdatedAt());

		return model;
	}

	public static List<CdsMinimumRequirementLevels> toModels(
		CdsMinimumRequirementLevelsSoap[] soapModels) {
		List<CdsMinimumRequirementLevels> models = new ArrayList<CdsMinimumRequirementLevels>(soapModels.length);

		for (CdsMinimumRequirementLevelsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.cds.model.CdsMinimumRequirementLevels"));

	public CdsMinimumRequirementLevelsModelImpl() {
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
			return (CdsMinimumRequirementLevels)this;
		}
		else {
			CdsMinimumRequirementLevels model = new CdsMinimumRequirementLevelsImpl();

			model.setNew(isNew());
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
		CdsMinimumRequirementLevelsImpl clone = new CdsMinimumRequirementLevelsImpl();

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

		CdsMinimumRequirementLevels cdsMinimumRequirementLevels = null;

		try {
			cdsMinimumRequirementLevels = (CdsMinimumRequirementLevels)obj;
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