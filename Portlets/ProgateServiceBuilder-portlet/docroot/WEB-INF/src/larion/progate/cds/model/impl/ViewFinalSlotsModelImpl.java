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

import larion.progate.cds.model.ViewFinalSlots;
import larion.progate.cds.model.ViewFinalSlotsSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="ViewFinalSlotsModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ViewFinalSlotsModelImpl extends BaseModelImpl<ViewFinalSlots> {
	public static final String TABLE_NAME = "v_final_slots";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "level_id", new Integer(Types.INTEGER) },
			

			{ "root_id", new Integer(Types.INTEGER) },
			

			{ "name", new Integer(Types.VARCHAR) },
			

			{ "description", new Integer(Types.VARCHAR) },
			

			{ "user_id", new Integer(Types.INTEGER) },
			

			{ "rating_status", new Integer(Types.BOOLEAN) },
			

			{ "point_name", new Integer(Types.VARCHAR) },
			

			{ "max_point_name", new Integer(Types.VARCHAR) },
			

			{ "point_value", new Integer(Types.INTEGER) },
			

			{ "max_point_value", new Integer(Types.INTEGER) },
			

			{ "is_passed", new Integer(Types.BOOLEAN) }
		};
	public static final String TABLE_SQL_CREATE = "create table v_final_slots (id INTEGER not null primary key,level_id INTEGER,root_id INTEGER,name VARCHAR(75) null,description VARCHAR(75) null,user_id INTEGER,rating_status BOOLEAN,point_name VARCHAR(75) null,max_point_name VARCHAR(75) null,point_value INTEGER,max_point_value INTEGER,is_passed BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table v_final_slots";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.cds.model.ViewFinalSlots"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.cds.model.ViewFinalSlots"),
			false);

	public static ViewFinalSlots toModel(ViewFinalSlotsSoap soapModel) {
		ViewFinalSlots model = new ViewFinalSlotsImpl();

		model.setSlotId(soapModel.getSlotId());
		model.setLevelId(soapModel.getLevelId());
		model.setRootId(soapModel.getRootId());
		model.setName(soapModel.getName());
		model.setDescription(soapModel.getDescription());
		model.setUserId(soapModel.getUserId());
		model.setRatingStatus(soapModel.getRatingStatus());
		model.setPointName(soapModel.getPointName());
		model.setMaxPointName(soapModel.getMaxPointName());
		model.setPointValue(soapModel.getPointValue());
		model.setMaxPointValue(soapModel.getMaxPointValue());
		model.setIsPassed(soapModel.getIsPassed());

		return model;
	}

	public static List<ViewFinalSlots> toModels(ViewFinalSlotsSoap[] soapModels) {
		List<ViewFinalSlots> models = new ArrayList<ViewFinalSlots>(soapModels.length);

		for (ViewFinalSlotsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.cds.model.ViewFinalSlots"));

	public ViewFinalSlotsModelImpl() {
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

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
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

	public int getUserId() {
		return _userId;
	}

	public void setUserId(int userId) {
		_userId = userId;
	}

	public boolean getRatingStatus() {
		return _ratingStatus;
	}

	public boolean isRatingStatus() {
		return _ratingStatus;
	}

	public void setRatingStatus(boolean ratingStatus) {
		_ratingStatus = ratingStatus;
	}

	public String getPointName() {
		return GetterUtil.getString(_pointName);
	}

	public void setPointName(String pointName) {
		_pointName = pointName;
	}

	public String getMaxPointName() {
		return GetterUtil.getString(_maxPointName);
	}

	public void setMaxPointName(String maxPointName) {
		_maxPointName = maxPointName;
	}

	public int getPointValue() {
		return _pointValue;
	}

	public void setPointValue(int pointValue) {
		_pointValue = pointValue;
	}

	public int getMaxPointValue() {
		return _maxPointValue;
	}

	public void setMaxPointValue(int maxPointValue) {
		_maxPointValue = maxPointValue;
	}

	public boolean getIsPassed() {
		return _isPassed;
	}

	public boolean isIsPassed() {
		return _isPassed;
	}

	public void setIsPassed(boolean isPassed) {
		_isPassed = isPassed;
	}

	public ViewFinalSlots toEscapedModel() {
		if (isEscapedModel()) {
			return (ViewFinalSlots)this;
		}
		else {
			ViewFinalSlots model = new ViewFinalSlotsImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setSlotId(getSlotId());
			model.setLevelId(getLevelId());
			model.setRootId(getRootId());
			model.setName(HtmlUtil.escape(getName()));
			model.setDescription(HtmlUtil.escape(getDescription()));
			model.setUserId(getUserId());
			model.setRatingStatus(getRatingStatus());
			model.setPointName(HtmlUtil.escape(getPointName()));
			model.setMaxPointName(HtmlUtil.escape(getMaxPointName()));
			model.setPointValue(getPointValue());
			model.setMaxPointValue(getMaxPointValue());
			model.setIsPassed(getIsPassed());

			model = (ViewFinalSlots)Proxy.newProxyInstance(ViewFinalSlots.class.getClassLoader(),
					new Class[] { ViewFinalSlots.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		ViewFinalSlotsImpl clone = new ViewFinalSlotsImpl();

		clone.setSlotId(getSlotId());
		clone.setLevelId(getLevelId());
		clone.setRootId(getRootId());
		clone.setName(getName());
		clone.setDescription(getDescription());
		clone.setUserId(getUserId());
		clone.setRatingStatus(getRatingStatus());
		clone.setPointName(getPointName());
		clone.setMaxPointName(getMaxPointName());
		clone.setPointValue(getPointValue());
		clone.setMaxPointValue(getMaxPointValue());
		clone.setIsPassed(getIsPassed());

		return clone;
	}

	public int compareTo(ViewFinalSlots viewFinalSlots) {
		Integer pk = viewFinalSlots.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ViewFinalSlots viewFinalSlots = null;

		try {
			viewFinalSlots = (ViewFinalSlots)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = viewFinalSlots.getPrimaryKey();

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

		sb.append("{slotId=");
		sb.append(getSlotId());
		sb.append(", levelId=");
		sb.append(getLevelId());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", ratingStatus=");
		sb.append(getRatingStatus());
		sb.append(", pointName=");
		sb.append(getPointName());
		sb.append(", maxPointName=");
		sb.append(getMaxPointName());
		sb.append(", pointValue=");
		sb.append(getPointValue());
		sb.append(", maxPointValue=");
		sb.append(getMaxPointValue());
		sb.append(", isPassed=");
		sb.append(getIsPassed());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.cds.model.ViewFinalSlots");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>slotId</column-name><column-value><![CDATA[");
		sb.append(getSlotId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>levelId</column-name><column-value><![CDATA[");
		sb.append(getLevelId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rootId</column-name><column-value><![CDATA[");
		sb.append(getRootId());
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
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ratingStatus</column-name><column-value><![CDATA[");
		sb.append(getRatingStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pointName</column-name><column-value><![CDATA[");
		sb.append(getPointName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maxPointName</column-name><column-value><![CDATA[");
		sb.append(getMaxPointName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pointValue</column-name><column-value><![CDATA[");
		sb.append(getPointValue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maxPointValue</column-name><column-value><![CDATA[");
		sb.append(getMaxPointValue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isPassed</column-name><column-value><![CDATA[");
		sb.append(getIsPassed());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _slotId;
	private int _levelId;
	private int _rootId;
	private String _name;
	private String _description;
	private int _userId;
	private boolean _ratingStatus;
	private String _pointName;
	private String _maxPointName;
	private int _pointValue;
	private int _maxPointValue;
	private boolean _isPassed;
}