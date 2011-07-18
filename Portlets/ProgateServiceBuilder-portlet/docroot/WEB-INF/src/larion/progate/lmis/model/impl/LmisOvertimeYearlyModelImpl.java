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
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import larion.progate.lmis.model.LmisOvertimeYearly;
import larion.progate.lmis.model.LmisOvertimeYearlySoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="LmisOvertimeYearlyModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisOvertimeYearlyModelImpl extends BaseModelImpl<LmisOvertimeYearly> {
	public static final String TABLE_NAME = "lmis_overtime_yearly";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "year_value", new Integer(Types.INTEGER) },
			

			{ "root_id", new Integer(Types.INTEGER) },
			

			{ "user_id", new Integer(Types.INTEGER) },
			

			{ "ot_type", new Integer(Types.VARCHAR) },
			

			{ "ot_id", new Integer(Types.INTEGER) },
			

			{ "total_hour", new Integer(Types.DOUBLE) },
			

			{ "total_hour_final", new Integer(Types.DOUBLE) }
		};
	public static final String TABLE_SQL_CREATE = "create table lmis_overtime_yearly (id INTEGER not null primary key,year_value INTEGER,root_id INTEGER,user_id INTEGER,ot_type VARCHAR(75) null,ot_id INTEGER,total_hour DOUBLE,total_hour_final DOUBLE)";
	public static final String TABLE_SQL_DROP = "drop table lmis_overtime_yearly";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.lmis.model.LmisOvertimeYearly"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.lmis.model.LmisOvertimeYearly"),
			false);

	public static LmisOvertimeYearly toModel(LmisOvertimeYearlySoap soapModel) {
		LmisOvertimeYearly model = new LmisOvertimeYearlyImpl();

		model.setLmisOvertimeYearlyId(soapModel.getLmisOvertimeYearlyId());
		model.setYearValue(soapModel.getYearValue());
		model.setRootId(soapModel.getRootId());
		model.setUserId(soapModel.getUserId());
		model.setOtType(soapModel.getOtType());
		model.setOtId(soapModel.getOtId());
		model.setTotalHour(soapModel.getTotalHour());
		model.setTotalHourFinal(soapModel.getTotalHourFinal());

		return model;
	}

	public static List<LmisOvertimeYearly> toModels(
		LmisOvertimeYearlySoap[] soapModels) {
		List<LmisOvertimeYearly> models = new ArrayList<LmisOvertimeYearly>(soapModels.length);

		for (LmisOvertimeYearlySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.lmis.model.LmisOvertimeYearly"));

	public LmisOvertimeYearlyModelImpl() {
	}

	public Integer getPrimaryKey() {
		return _lmisOvertimeYearlyId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisOvertimeYearlyId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _lmisOvertimeYearlyId;
	}

	public Integer getLmisOvertimeYearlyId() {
		return _lmisOvertimeYearlyId;
	}

	public void setLmisOvertimeYearlyId(Integer lmisOvertimeYearlyId) {
		_lmisOvertimeYearlyId = lmisOvertimeYearlyId;
	}

	public int getYearValue() {
		return _yearValue;
	}

	public void setYearValue(int yearValue) {
		_yearValue = yearValue;
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

	public String getOtType() {
		return GetterUtil.getString(_otType);
	}

	public void setOtType(String otType) {
		_otType = otType;
	}

	public int getOtId() {
		return _otId;
	}

	public void setOtId(int otId) {
		_otId = otId;
	}

	public double getTotalHour() {
		return _totalHour;
	}

	public void setTotalHour(double totalHour) {
		_totalHour = totalHour;
	}

	public double getTotalHourFinal() {
		return _totalHourFinal;
	}

	public void setTotalHourFinal(double totalHourFinal) {
		_totalHourFinal = totalHourFinal;
	}

	public LmisOvertimeYearly toEscapedModel() {
		if (isEscapedModel()) {
			return (LmisOvertimeYearly)this;
		}
		else {
			LmisOvertimeYearly model = new LmisOvertimeYearlyImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setLmisOvertimeYearlyId(getLmisOvertimeYearlyId());
			model.setYearValue(getYearValue());
			model.setRootId(getRootId());
			model.setUserId(getUserId());
			model.setOtType(HtmlUtil.escape(getOtType()));
			model.setOtId(getOtId());
			model.setTotalHour(getTotalHour());
			model.setTotalHourFinal(getTotalHourFinal());

			model = (LmisOvertimeYearly)Proxy.newProxyInstance(LmisOvertimeYearly.class.getClassLoader(),
					new Class[] { LmisOvertimeYearly.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		LmisOvertimeYearlyImpl clone = new LmisOvertimeYearlyImpl();

		clone.setLmisOvertimeYearlyId(getLmisOvertimeYearlyId());
		clone.setYearValue(getYearValue());
		clone.setRootId(getRootId());
		clone.setUserId(getUserId());
		clone.setOtType(getOtType());
		clone.setOtId(getOtId());
		clone.setTotalHour(getTotalHour());
		clone.setTotalHourFinal(getTotalHourFinal());

		return clone;
	}

	public int compareTo(LmisOvertimeYearly lmisOvertimeYearly) {
		Integer pk = lmisOvertimeYearly.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		LmisOvertimeYearly lmisOvertimeYearly = null;

		try {
			lmisOvertimeYearly = (LmisOvertimeYearly)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = lmisOvertimeYearly.getPrimaryKey();

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

		sb.append("{lmisOvertimeYearlyId=");
		sb.append(getLmisOvertimeYearlyId());
		sb.append(", yearValue=");
		sb.append(getYearValue());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", otType=");
		sb.append(getOtType());
		sb.append(", otId=");
		sb.append(getOtId());
		sb.append(", totalHour=");
		sb.append(getTotalHour());
		sb.append(", totalHourFinal=");
		sb.append(getTotalHourFinal());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.lmis.model.LmisOvertimeYearly");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>lmisOvertimeYearlyId</column-name><column-value><![CDATA[");
		sb.append(getLmisOvertimeYearlyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>yearValue</column-name><column-value><![CDATA[");
		sb.append(getYearValue());
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
			"<column><column-name>otType</column-name><column-value><![CDATA[");
		sb.append(getOtType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>otId</column-name><column-value><![CDATA[");
		sb.append(getOtId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalHour</column-name><column-value><![CDATA[");
		sb.append(getTotalHour());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalHourFinal</column-name><column-value><![CDATA[");
		sb.append(getTotalHourFinal());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _lmisOvertimeYearlyId;
	private int _yearValue;
	private int _rootId;
	private int _userId;
	private String _otType;
	private int _otId;
	private double _totalHour;
	private double _totalHourFinal;
}