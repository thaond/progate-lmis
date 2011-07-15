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

import larion.progate.lmis.model.LmisDataImports;
import larion.progate.lmis.model.LmisDataImportsSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="LmisDataImportsModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisDataImportsModelImpl extends BaseModelImpl<LmisDataImports> {
	public static final String TABLE_NAME = "lmis_data_imports";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "root_id", new Integer(Types.INTEGER) },
			

			{ "date_value", new Integer(Types.TIMESTAMP) },
			

			{ "import_type", new Integer(Types.INTEGER) },
			

			{ "import_by", new Integer(Types.INTEGER) },
			

			{ "import_at", new Integer(Types.TIMESTAMP) },
			

			{ "session_id", new Integer(Types.INTEGER) }
		};
	public static final String TABLE_SQL_CREATE = "create table lmis_data_imports (id INTEGER not null primary key,root_id INTEGER,date_value DATE null,import_type INTEGER,import_by INTEGER,import_at DATE null,session_id INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table lmis_data_imports";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.lmis.model.LmisDataImports"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.lmis.model.LmisDataImports"),
			false);

	public static LmisDataImports toModel(LmisDataImportsSoap soapModel) {
		LmisDataImports model = new LmisDataImportsImpl();

		model.setLmisDataImportsId(soapModel.getLmisDataImportsId());
		model.setRootId(soapModel.getRootId());
		model.setDateValue(soapModel.getDateValue());
		model.setImportType(soapModel.getImportType());
		model.setImportBy(soapModel.getImportBy());
		model.setImportAt(soapModel.getImportAt());
		model.setSessionId(soapModel.getSessionId());

		return model;
	}

	public static List<LmisDataImports> toModels(
		LmisDataImportsSoap[] soapModels) {
		List<LmisDataImports> models = new ArrayList<LmisDataImports>(soapModels.length);

		for (LmisDataImportsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.lmis.model.LmisDataImports"));

	public LmisDataImportsModelImpl() {
	}

	public Integer getPrimaryKey() {
		return _lmisDataImportsId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisDataImportsId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _lmisDataImportsId;
	}

	public Integer getLmisDataImportsId() {
		return _lmisDataImportsId;
	}

	public void setLmisDataImportsId(Integer lmisDataImportsId) {
		_lmisDataImportsId = lmisDataImportsId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public Date getDateValue() {
		return _dateValue;
	}

	public void setDateValue(Date dateValue) {
		_dateValue = dateValue;
	}

	public int getImportType() {
		return _importType;
	}

	public void setImportType(int importType) {
		_importType = importType;
	}

	public int getImportBy() {
		return _importBy;
	}

	public void setImportBy(int importBy) {
		_importBy = importBy;
	}

	public Date getImportAt() {
		return _importAt;
	}

	public void setImportAt(Date importAt) {
		_importAt = importAt;
	}

	public int getSessionId() {
		return _sessionId;
	}

	public void setSessionId(int sessionId) {
		_sessionId = sessionId;
	}

	public LmisDataImports toEscapedModel() {
		if (isEscapedModel()) {
			return (LmisDataImports)this;
		}
		else {
			LmisDataImports model = new LmisDataImportsImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setLmisDataImportsId(getLmisDataImportsId());
			model.setRootId(getRootId());
			model.setDateValue(getDateValue());
			model.setImportType(getImportType());
			model.setImportBy(getImportBy());
			model.setImportAt(getImportAt());
			model.setSessionId(getSessionId());

			model = (LmisDataImports)Proxy.newProxyInstance(LmisDataImports.class.getClassLoader(),
					new Class[] { LmisDataImports.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		LmisDataImportsImpl clone = new LmisDataImportsImpl();

		clone.setLmisDataImportsId(getLmisDataImportsId());
		clone.setRootId(getRootId());
		clone.setDateValue(getDateValue());
		clone.setImportType(getImportType());
		clone.setImportBy(getImportBy());
		clone.setImportAt(getImportAt());
		clone.setSessionId(getSessionId());

		return clone;
	}

	public int compareTo(LmisDataImports lmisDataImports) {
		Integer pk = lmisDataImports.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		LmisDataImports lmisDataImports = null;

		try {
			lmisDataImports = (LmisDataImports)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = lmisDataImports.getPrimaryKey();

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

		sb.append("{lmisDataImportsId=");
		sb.append(getLmisDataImportsId());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", dateValue=");
		sb.append(getDateValue());
		sb.append(", importType=");
		sb.append(getImportType());
		sb.append(", importBy=");
		sb.append(getImportBy());
		sb.append(", importAt=");
		sb.append(getImportAt());
		sb.append(", sessionId=");
		sb.append(getSessionId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.lmis.model.LmisDataImports");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>lmisDataImportsId</column-name><column-value><![CDATA[");
		sb.append(getLmisDataImportsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rootId</column-name><column-value><![CDATA[");
		sb.append(getRootId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dateValue</column-name><column-value><![CDATA[");
		sb.append(getDateValue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>importType</column-name><column-value><![CDATA[");
		sb.append(getImportType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>importBy</column-name><column-value><![CDATA[");
		sb.append(getImportBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>importAt</column-name><column-value><![CDATA[");
		sb.append(getImportAt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sessionId</column-name><column-value><![CDATA[");
		sb.append(getSessionId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _lmisDataImportsId;
	private int _rootId;
	private Date _dateValue;
	private int _importType;
	private int _importBy;
	private Date _importAt;
	private int _sessionId;
}