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

import larion.progate.cds.model.CdsPAFinalSlots;
import larion.progate.cds.model.CdsPAFinalSlotsSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="CdsPAFinalSlotsModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsPAFinalSlotsModelImpl extends BaseModelImpl<CdsPAFinalSlots> {
	public static final String TABLE_NAME = "cds_performance_appraisal_final_slots";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "pa_id", new Integer(Types.INTEGER) },
			

			{ "root_id", new Integer(Types.INTEGER) },
			

			{ "user_id", new Integer(Types.INTEGER) },
			

			{ "slot_id", new Integer(Types.INTEGER) },
			

			{ "rating_status", new Integer(Types.BOOLEAN) },
			

			{ "point_name", new Integer(Types.VARCHAR) },
			

			{ "max_point_name", new Integer(Types.VARCHAR) },
			

			{ "point_value", new Integer(Types.INTEGER) },
			

			{ "max_point_value", new Integer(Types.INTEGER) },
			

			{ "is_passed", new Integer(Types.BOOLEAN) }
		};
	public static final String TABLE_SQL_CREATE = "create table cds_performance_appraisal_final_slots (id INTEGER not null primary key,pa_id INTEGER,root_id INTEGER,user_id INTEGER,slot_id INTEGER,rating_status BOOLEAN,point_name VARCHAR(75) null,max_point_name VARCHAR(75) null,point_value INTEGER,max_point_value INTEGER,is_passed BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table cds_performance_appraisal_final_slots";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.cds.model.CdsPAFinalSlots"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.cds.model.CdsPAFinalSlots"),
			false);

	public static CdsPAFinalSlots toModel(CdsPAFinalSlotsSoap soapModel) {
		CdsPAFinalSlots model = new CdsPAFinalSlotsImpl();

		model.setCdsPAFinalSlotsId(soapModel.getCdsPAFinalSlotsId());
		model.setPaId(soapModel.getPaId());
		model.setRootId(soapModel.getRootId());
		model.setUserId(soapModel.getUserId());
		model.setSlotId(soapModel.getSlotId());
		model.setRatingStatus(soapModel.getRatingStatus());
		model.setPointName(soapModel.getPointName());
		model.setMaxPointName(soapModel.getMaxPointName());
		model.setPointValue(soapModel.getPointValue());
		model.setMaxPointValue(soapModel.getMaxPointValue());
		model.setIsPassed(soapModel.getIsPassed());

		return model;
	}

	public static List<CdsPAFinalSlots> toModels(
		CdsPAFinalSlotsSoap[] soapModels) {
		List<CdsPAFinalSlots> models = new ArrayList<CdsPAFinalSlots>(soapModels.length);

		for (CdsPAFinalSlotsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.cds.model.CdsPAFinalSlots"));

	public CdsPAFinalSlotsModelImpl() {
	}

	public Integer getPrimaryKey() {
		return _CdsPAFinalSlotsId;
	}

	public void setPrimaryKey(Integer pk) {
		setCdsPAFinalSlotsId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _CdsPAFinalSlotsId;
	}

	public Integer getCdsPAFinalSlotsId() {
		return _CdsPAFinalSlotsId;
	}

	public void setCdsPAFinalSlotsId(Integer CdsPAFinalSlotsId) {
		_CdsPAFinalSlotsId = CdsPAFinalSlotsId;
	}

	public int getPaId() {
		return _paId;
	}

	public void setPaId(int paId) {
		_paId = paId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public int getUserId() {
		return _userId;
	}

	public void setUserId(int userId) {
		_userId = userId;
	}

	public int getSlotId() {
		return _slotId;
	}

	public void setSlotId(int slotId) {
		_slotId = slotId;
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

	public CdsPAFinalSlots toEscapedModel() {
		if (isEscapedModel()) {
			return (CdsPAFinalSlots)this;
		}
		else {
			CdsPAFinalSlots model = new CdsPAFinalSlotsImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setCdsPAFinalSlotsId(getCdsPAFinalSlotsId());
			model.setPaId(getPaId());
			model.setRootId(getRootId());
			model.setUserId(getUserId());
			model.setSlotId(getSlotId());
			model.setRatingStatus(getRatingStatus());
			model.setPointName(HtmlUtil.escape(getPointName()));
			model.setMaxPointName(HtmlUtil.escape(getMaxPointName()));
			model.setPointValue(getPointValue());
			model.setMaxPointValue(getMaxPointValue());
			model.setIsPassed(getIsPassed());

			model = (CdsPAFinalSlots)Proxy.newProxyInstance(CdsPAFinalSlots.class.getClassLoader(),
					new Class[] { CdsPAFinalSlots.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		CdsPAFinalSlotsImpl clone = new CdsPAFinalSlotsImpl();

		clone.setCdsPAFinalSlotsId(getCdsPAFinalSlotsId());
		clone.setPaId(getPaId());
		clone.setRootId(getRootId());
		clone.setUserId(getUserId());
		clone.setSlotId(getSlotId());
		clone.setRatingStatus(getRatingStatus());
		clone.setPointName(getPointName());
		clone.setMaxPointName(getMaxPointName());
		clone.setPointValue(getPointValue());
		clone.setMaxPointValue(getMaxPointValue());
		clone.setIsPassed(getIsPassed());

		return clone;
	}

	public int compareTo(CdsPAFinalSlots cdsPAFinalSlots) {
		Integer pk = cdsPAFinalSlots.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		CdsPAFinalSlots cdsPAFinalSlots = null;

		try {
			cdsPAFinalSlots = (CdsPAFinalSlots)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = cdsPAFinalSlots.getPrimaryKey();

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

		sb.append("{CdsPAFinalSlotsId=");
		sb.append(getCdsPAFinalSlotsId());
		sb.append(", paId=");
		sb.append(getPaId());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", slotId=");
		sb.append(getSlotId());
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
		sb.append("larion.progate.cds.model.CdsPAFinalSlots");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>CdsPAFinalSlotsId</column-name><column-value><![CDATA[");
		sb.append(getCdsPAFinalSlotsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>paId</column-name><column-value><![CDATA[");
		sb.append(getPaId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rootId</column-name><column-value><![CDATA[");
		sb.append(getRootId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>slotId</column-name><column-value><![CDATA[");
		sb.append(getSlotId());
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

	private Integer _CdsPAFinalSlotsId;
	private int _paId;
	private int _rootId;
	private int _userId;
	private int _slotId;
	private boolean _ratingStatus;
	private String _pointName;
	private String _maxPointName;
	private int _pointValue;
	private int _maxPointValue;
	private boolean _isPassed;
}