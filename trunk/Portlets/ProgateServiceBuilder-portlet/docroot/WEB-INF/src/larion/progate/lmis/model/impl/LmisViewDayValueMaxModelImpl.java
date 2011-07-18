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

import larion.progate.lmis.model.LmisViewDayValueMax;
import larion.progate.lmis.model.LmisViewDayValueMaxSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="LmisViewDayValueMaxModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewDayValueMaxModelImpl extends BaseModelImpl<LmisViewDayValueMax> {
	public static final String TABLE_NAME = "vw_day_value_max";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "day_value", new Integer(Types.TIMESTAMP) },
			

			{ "root_id", new Integer(Types.INTEGER) }
		};
	public static final String TABLE_SQL_CREATE = "create table vw_day_value_max (id INTEGER not null primary key,day_value DATE null,root_id INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table vw_day_value_max";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.lmis.model.LmisViewDayValueMax"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.lmis.model.LmisViewDayValueMax"),
			false);

	public static LmisViewDayValueMax toModel(LmisViewDayValueMaxSoap soapModel) {
		LmisViewDayValueMax model = new LmisViewDayValueMaxImpl();

		model.setLmisViewDayValueMaxId(soapModel.getLmisViewDayValueMaxId());
		model.setDayValue(soapModel.getDayValue());
		model.setRootId(soapModel.getRootId());

		return model;
	}

	public static List<LmisViewDayValueMax> toModels(
		LmisViewDayValueMaxSoap[] soapModels) {
		List<LmisViewDayValueMax> models = new ArrayList<LmisViewDayValueMax>(soapModels.length);

		for (LmisViewDayValueMaxSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.lmis.model.LmisViewDayValueMax"));

	public LmisViewDayValueMaxModelImpl() {
	}

	public Integer getPrimaryKey() {
		return _lmisViewDayValueMaxId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisViewDayValueMaxId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _lmisViewDayValueMaxId;
	}

	public Integer getLmisViewDayValueMaxId() {
		return _lmisViewDayValueMaxId;
	}

	public void setLmisViewDayValueMaxId(Integer lmisViewDayValueMaxId) {
		_lmisViewDayValueMaxId = lmisViewDayValueMaxId;
	}

	public Date getDayValue() {
		return _dayValue;
	}

	public void setDayValue(Date dayValue) {
		_dayValue = dayValue;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public LmisViewDayValueMax toEscapedModel() {
		if (isEscapedModel()) {
			return (LmisViewDayValueMax)this;
		}
		else {
			LmisViewDayValueMax model = new LmisViewDayValueMaxImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setLmisViewDayValueMaxId(getLmisViewDayValueMaxId());
			model.setDayValue(getDayValue());
			model.setRootId(getRootId());

			model = (LmisViewDayValueMax)Proxy.newProxyInstance(LmisViewDayValueMax.class.getClassLoader(),
					new Class[] { LmisViewDayValueMax.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		LmisViewDayValueMaxImpl clone = new LmisViewDayValueMaxImpl();

		clone.setLmisViewDayValueMaxId(getLmisViewDayValueMaxId());
		clone.setDayValue(getDayValue());
		clone.setRootId(getRootId());

		return clone;
	}

	public int compareTo(LmisViewDayValueMax lmisViewDayValueMax) {
		Integer pk = lmisViewDayValueMax.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		LmisViewDayValueMax lmisViewDayValueMax = null;

		try {
			lmisViewDayValueMax = (LmisViewDayValueMax)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = lmisViewDayValueMax.getPrimaryKey();

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

		sb.append("{lmisViewDayValueMaxId=");
		sb.append(getLmisViewDayValueMaxId());
		sb.append(", dayValue=");
		sb.append(getDayValue());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.lmis.model.LmisViewDayValueMax");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>lmisViewDayValueMaxId</column-name><column-value><![CDATA[");
		sb.append(getLmisViewDayValueMaxId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dayValue</column-name><column-value><![CDATA[");
		sb.append(getDayValue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rootId</column-name><column-value><![CDATA[");
		sb.append(getRootId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _lmisViewDayValueMaxId;
	private Date _dayValue;
	private int _rootId;
}