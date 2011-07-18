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

import larion.progate.cds.model.CdsPoints;
import larion.progate.cds.model.CdsPointsSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="CdsPointsModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsPointsModelImpl extends BaseModelImpl<CdsPoints> {
	public static final String TABLE_NAME = "cds_points";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "root_id", new Integer(Types.INTEGER) },
			

			{ "point_name", new Integer(Types.VARCHAR) },
			

			{ "point_value", new Integer(Types.INTEGER) },
			

			{ "description", new Integer(Types.VARCHAR) },
			

			{ "created_by", new Integer(Types.INTEGER) },
			

			{ "created_at", new Integer(Types.TIMESTAMP) },
			

			{ "updated_by", new Integer(Types.INTEGER) },
			

			{ "updated_at", new Integer(Types.TIMESTAMP) }
		};
	public static final String TABLE_SQL_CREATE = "create table cds_points (id INTEGER not null primary key,root_id INTEGER,point_name VARCHAR(75) null,point_value INTEGER,description VARCHAR(75) null,created_by INTEGER,created_at DATE null,updated_by INTEGER,updated_at DATE null)";
	public static final String TABLE_SQL_DROP = "drop table cds_points";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.cds.model.CdsPoints"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.cds.model.CdsPoints"),
			false);

	public static CdsPoints toModel(CdsPointsSoap soapModel) {
		CdsPoints model = new CdsPointsImpl();

		model.setPointId(soapModel.getPointId());
		model.setRootId(soapModel.getRootId());
		model.setPointName(soapModel.getPointName());
		model.setPointValue(soapModel.getPointValue());
		model.setDescription(soapModel.getDescription());
		model.setCreatedBy(soapModel.getCreatedBy());
		model.setCreatedAt(soapModel.getCreatedAt());
		model.setUpdatedBy(soapModel.getUpdatedBy());
		model.setUpdatedAt(soapModel.getUpdatedAt());

		return model;
	}

	public static List<CdsPoints> toModels(CdsPointsSoap[] soapModels) {
		List<CdsPoints> models = new ArrayList<CdsPoints>(soapModels.length);

		for (CdsPointsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.cds.model.CdsPoints"));

	public CdsPointsModelImpl() {
	}

	public Integer getPrimaryKey() {
		return _pointId;
	}

	public void setPrimaryKey(Integer pk) {
		setPointId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _pointId;
	}

	public Integer getPointId() {
		return _pointId;
	}

	public void setPointId(Integer pointId) {
		_pointId = pointId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public String getPointName() {
		return GetterUtil.getString(_pointName);
	}

	public void setPointName(String pointName) {
		_pointName = pointName;
	}

	public int getPointValue() {
		return _pointValue;
	}

	public void setPointValue(int pointValue) {
		_pointValue = pointValue;
	}

	public String getDescription() {
		return GetterUtil.getString(_description);
	}

	public void setDescription(String description) {
		_description = description;
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

	public CdsPoints toEscapedModel() {
		if (isEscapedModel()) {
			return (CdsPoints)this;
		}
		else {
			CdsPoints model = new CdsPointsImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setPointId(getPointId());
			model.setRootId(getRootId());
			model.setPointName(HtmlUtil.escape(getPointName()));
			model.setPointValue(getPointValue());
			model.setDescription(HtmlUtil.escape(getDescription()));
			model.setCreatedBy(getCreatedBy());
			model.setCreatedAt(getCreatedAt());
			model.setUpdatedBy(getUpdatedBy());
			model.setUpdatedAt(getUpdatedAt());

			model = (CdsPoints)Proxy.newProxyInstance(CdsPoints.class.getClassLoader(),
					new Class[] { CdsPoints.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		CdsPointsImpl clone = new CdsPointsImpl();

		clone.setPointId(getPointId());
		clone.setRootId(getRootId());
		clone.setPointName(getPointName());
		clone.setPointValue(getPointValue());
		clone.setDescription(getDescription());
		clone.setCreatedBy(getCreatedBy());
		clone.setCreatedAt(getCreatedAt());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedAt(getUpdatedAt());

		return clone;
	}

	public int compareTo(CdsPoints cdsPoints) {
		int value = 0;

		if (getPointValue() < cdsPoints.getPointValue()) {
			value = -1;
		}
		else if (getPointValue() > cdsPoints.getPointValue()) {
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

		CdsPoints cdsPoints = null;

		try {
			cdsPoints = (CdsPoints)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = cdsPoints.getPrimaryKey();

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

		sb.append("{pointId=");
		sb.append(getPointId());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", pointName=");
		sb.append(getPointName());
		sb.append(", pointValue=");
		sb.append(getPointValue());
		sb.append(", description=");
		sb.append(getDescription());
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
		sb.append("larion.progate.cds.model.CdsPoints");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>pointId</column-name><column-value><![CDATA[");
		sb.append(getPointId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rootId</column-name><column-value><![CDATA[");
		sb.append(getRootId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pointName</column-name><column-value><![CDATA[");
		sb.append(getPointName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pointValue</column-name><column-value><![CDATA[");
		sb.append(getPointValue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
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

	private Integer _pointId;
	private int _rootId;
	private String _pointName;
	private int _pointValue;
	private String _description;
	private int _createdBy;
	private Date _createdAt;
	private int _updatedBy;
	private Date _updatedAt;
}