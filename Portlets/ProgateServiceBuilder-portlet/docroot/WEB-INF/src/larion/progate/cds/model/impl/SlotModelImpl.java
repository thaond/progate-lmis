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

import larion.progate.cds.model.Slot;
import larion.progate.cds.model.SlotSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="SlotModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class SlotModelImpl extends BaseModelImpl<Slot> {
	public static final String TABLE_NAME = "cds_slots";
	public static final Object[][] TABLE_COLUMNS = {
			{ "root_id", new Integer(Types.INTEGER) },
			

			{ "id", new Integer(Types.INTEGER) },
			

			{ "level_id", new Integer(Types.INTEGER) },
			

			{ "name", new Integer(Types.VARCHAR) },
			

			{ "description", new Integer(Types.VARCHAR) },
			

			{ "number_order", new Integer(Types.INTEGER) },
			

			{ "alias_name", new Integer(Types.VARCHAR) },
			

			{ "created_by", new Integer(Types.INTEGER) },
			

			{ "created_at", new Integer(Types.TIMESTAMP) },
			

			{ "updated_by", new Integer(Types.INTEGER) },
			

			{ "updated_at", new Integer(Types.TIMESTAMP) }
		};
	public static final String TABLE_SQL_CREATE = "create table cds_slots (root_id INTEGER,id INTEGER not null primary key,level_id INTEGER,name VARCHAR(75) null,description VARCHAR(75) null,number_order INTEGER,alias_name VARCHAR(75) null,created_by INTEGER,created_at DATE null,updated_by INTEGER,updated_at DATE null)";
	public static final String TABLE_SQL_DROP = "drop table cds_slots";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.cds.model.Slot"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.cds.model.Slot"),
			false);

	public static Slot toModel(SlotSoap soapModel) {
		Slot model = new SlotImpl();

		model.setRootId(soapModel.getRootId());
		model.setSlotId(soapModel.getSlotId());
		model.setLevelId(soapModel.getLevelId());
		model.setName(soapModel.getName());
		model.setDescription(soapModel.getDescription());
		model.setNumberOrder(soapModel.getNumberOrder());
		model.setAliasName(soapModel.getAliasName());
		model.setCreatedBy(soapModel.getCreatedBy());
		model.setCreatedAt(soapModel.getCreatedAt());
		model.setUpdatedBy(soapModel.getUpdatedBy());
		model.setUpdatedAt(soapModel.getUpdatedAt());

		return model;
	}

	public static List<Slot> toModels(SlotSoap[] soapModels) {
		List<Slot> models = new ArrayList<Slot>(soapModels.length);

		for (SlotSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.cds.model.Slot"));

	public SlotModelImpl() {
	}

	public Integer getPrimaryKey() {
		return _slotId;
	}

	public void setPrimaryKey(Integer pk) {
		setSlotId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _slotId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public Integer getSlotId() {
		return _slotId;
	}

	public void setSlotId(Integer slotId) {
		_slotId = slotId;
	}

	public int getLevelId() {
		return _levelId;
	}

	public void setLevelId(int levelId) {
		_levelId = levelId;
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

	public String getAliasName() {
		return GetterUtil.getString(_aliasName);
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

	public Slot toEscapedModel() {
		if (isEscapedModel()) {
			return (Slot)this;
		}
		else {
			Slot model = new SlotImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setRootId(getRootId());
			model.setSlotId(getSlotId());
			model.setLevelId(getLevelId());
			model.setName(HtmlUtil.escape(getName()));
			model.setDescription(HtmlUtil.escape(getDescription()));
			model.setNumberOrder(getNumberOrder());
			model.setAliasName(HtmlUtil.escape(getAliasName()));
			model.setCreatedBy(getCreatedBy());
			model.setCreatedAt(getCreatedAt());
			model.setUpdatedBy(getUpdatedBy());
			model.setUpdatedAt(getUpdatedAt());

			model = (Slot)Proxy.newProxyInstance(Slot.class.getClassLoader(),
					new Class[] { Slot.class }, new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		SlotImpl clone = new SlotImpl();

		clone.setRootId(getRootId());
		clone.setSlotId(getSlotId());
		clone.setLevelId(getLevelId());
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

	public int compareTo(Slot slot) {
		int value = 0;

		if (getNumberOrder() < slot.getNumberOrder()) {
			value = -1;
		}
		else if (getNumberOrder() > slot.getNumberOrder()) {
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

		Slot slot = null;

		try {
			slot = (Slot)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = slot.getPrimaryKey();

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
		sb.append(", slotId=");
		sb.append(getSlotId());
		sb.append(", levelId=");
		sb.append(getLevelId());
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
		sb.append("larion.progate.cds.model.Slot");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>rootId</column-name><column-value><![CDATA[");
		sb.append(getRootId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>slotId</column-name><column-value><![CDATA[");
		sb.append(getSlotId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>levelId</column-name><column-value><![CDATA[");
		sb.append(getLevelId());
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
	private Integer _slotId;
	private int _levelId;
	private String _name;
	private String _description;
	private int _numberOrder;
	private String _aliasName;
	private int _createdBy;
	private Date _createdAt;
	private int _updatedBy;
	private Date _updatedAt;
}