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

package larion.progate.lmis.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import larion.progate.lmis.model.LmisDataInputs;
import larion.progate.lmis.model.LmisDataInputsSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="LmisDataInputsModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisDataInputsModelImpl extends BaseModelImpl<LmisDataInputs> {
	public static final String TABLE_NAME = "lmis_data_inputs";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "root_id", new Integer(Types.INTEGER) },
			

			{ "user_id", new Integer(Types.INTEGER) },
			

			{ "day_value", new Integer(Types.TIMESTAMP) },
			

			{ "start_time", new Integer(Types.TIMESTAMP) },
			

			{ "end_time", new Integer(Types.TIMESTAMP) },
			

			{ "input_by", new Integer(Types.INTEGER) },
			

			{ "input_at", new Integer(Types.TIMESTAMP) }
		};
	public static final String TABLE_SQL_CREATE = "create table lmis_data_inputs (id INTEGER not null primary key,root_id INTEGER,user_id INTEGER,day_value DATE null,start_time DATE null,end_time DATE null,input_by INTEGER,input_at DATE null)";
	public static final String TABLE_SQL_DROP = "drop table lmis_data_inputs";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.lmis.model.LmisDataInputs"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.lmis.model.LmisDataInputs"),
			false);

	public static LmisDataInputs toModel(LmisDataInputsSoap soapModel) {
		LmisDataInputs model = new LmisDataInputsImpl();

		model.setLmisDataInputsId(soapModel.getLmisDataInputsId());
		model.setRootId(soapModel.getRootId());
		model.setUserId(soapModel.getUserId());
		model.setDayValue(soapModel.getDayValue());
		model.setStartTime(soapModel.getStartTime());
		model.setEndTime(soapModel.getEndTime());
		model.setInputBy(soapModel.getInputBy());
		model.setInputAt(soapModel.getInputAt());

		return model;
	}

	public static List<LmisDataInputs> toModels(LmisDataInputsSoap[] soapModels) {
		List<LmisDataInputs> models = new ArrayList<LmisDataInputs>(soapModels.length);

		for (LmisDataInputsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.lmis.model.LmisDataInputs"));

	public LmisDataInputsModelImpl() {
	}

	public Integer getPrimaryKey() {
		return _lmisDataInputsId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisDataInputsId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _lmisDataInputsId;
	}

	public Integer getLmisDataInputsId() {
		return _lmisDataInputsId;
	}

	public void setLmisDataInputsId(Integer lmisDataInputsId) {
		_lmisDataInputsId = lmisDataInputsId;
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

	public Date getDayValue() {
		return _dayValue;
	}

	public void setDayValue(Date dayValue) {
		_dayValue = dayValue;
	}

	public Date getStartTime() {
		return _startTime;
	}

	public void setStartTime(Date startTime) {
		_startTime = startTime;
	}

	public Date getEndTime() {
		return _endTime;
	}

	public void setEndTime(Date endTime) {
		_endTime = endTime;
	}

	public int getInputBy() {
		return _inputBy;
	}

	public void setInputBy(int inputBy) {
		_inputBy = inputBy;
	}

	public Date getInputAt() {
		return _inputAt;
	}

	public void setInputAt(Date inputAt) {
		_inputAt = inputAt;
	}

	public LmisDataInputs toEscapedModel() {
		if (isEscapedModel()) {
			return (LmisDataInputs)this;
		}
		else {
			LmisDataInputs model = new LmisDataInputsImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setLmisDataInputsId(getLmisDataInputsId());
			model.setRootId(getRootId());
			model.setUserId(getUserId());
			model.setDayValue(getDayValue());
			model.setStartTime(getStartTime());
			model.setEndTime(getEndTime());
			model.setInputBy(getInputBy());
			model.setInputAt(getInputAt());

			model = (LmisDataInputs)Proxy.newProxyInstance(LmisDataInputs.class.getClassLoader(),
					new Class[] { LmisDataInputs.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		LmisDataInputsImpl clone = new LmisDataInputsImpl();

		clone.setLmisDataInputsId(getLmisDataInputsId());
		clone.setRootId(getRootId());
		clone.setUserId(getUserId());
		clone.setDayValue(getDayValue());
		clone.setStartTime(getStartTime());
		clone.setEndTime(getEndTime());
		clone.setInputBy(getInputBy());
		clone.setInputAt(getInputAt());

		return clone;
	}

	public int compareTo(LmisDataInputs lmisDataInputs) {
		Integer pk = lmisDataInputs.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		LmisDataInputs lmisDataInputs = null;

		try {
			lmisDataInputs = (LmisDataInputs)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = lmisDataInputs.getPrimaryKey();

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

		sb.append("{lmisDataInputsId=");
		sb.append(getLmisDataInputsId());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", dayValue=");
		sb.append(getDayValue());
		sb.append(", startTime=");
		sb.append(getStartTime());
		sb.append(", endTime=");
		sb.append(getEndTime());
		sb.append(", inputBy=");
		sb.append(getInputBy());
		sb.append(", inputAt=");
		sb.append(getInputAt());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.lmis.model.LmisDataInputs");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>lmisDataInputsId</column-name><column-value><![CDATA[");
		sb.append(getLmisDataInputsId());
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
			"<column><column-name>dayValue</column-name><column-value><![CDATA[");
		sb.append(getDayValue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startTime</column-name><column-value><![CDATA[");
		sb.append(getStartTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endTime</column-name><column-value><![CDATA[");
		sb.append(getEndTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>inputBy</column-name><column-value><![CDATA[");
		sb.append(getInputBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>inputAt</column-name><column-value><![CDATA[");
		sb.append(getInputAt());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _lmisDataInputsId;
	private int _rootId;
	private int _userId;
	private Date _dayValue;
	private Date _startTime;
	private Date _endTime;
	private int _inputBy;
	private Date _inputAt;
}