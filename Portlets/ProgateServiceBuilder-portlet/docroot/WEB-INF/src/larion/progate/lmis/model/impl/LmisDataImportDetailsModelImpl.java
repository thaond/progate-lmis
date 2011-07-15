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

import larion.progate.lmis.model.LmisDataImportDetails;
import larion.progate.lmis.model.LmisDataImportDetailsSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="LmisDataImportDetailsModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisDataImportDetailsModelImpl extends BaseModelImpl<LmisDataImportDetails> {
	public static final String TABLE_NAME = "lmis_data_import_details";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "root_id", new Integer(Types.INTEGER) },
			

			{ "import_id", new Integer(Types.INTEGER) },
			

			{ "start_time", new Integer(Types.TIMESTAMP) },
			

			{ "end_time", new Integer(Types.TIMESTAMP) },
			

			{ "scanner_id", new Integer(Types.VARCHAR) },
			

			{ "absence", new Integer(Types.INTEGER) },
			

			{ "staff_name", new Integer(Types.VARCHAR) }
		};
	public static final String TABLE_SQL_CREATE = "create table lmis_data_import_details (id INTEGER not null primary key,root_id INTEGER,import_id INTEGER,start_time DATE null,end_time DATE null,scanner_id VARCHAR(75) null,absence INTEGER,staff_name VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table lmis_data_import_details";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.lmis.model.LmisDataImportDetails"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.lmis.model.LmisDataImportDetails"),
			false);

	public static LmisDataImportDetails toModel(
		LmisDataImportDetailsSoap soapModel) {
		LmisDataImportDetails model = new LmisDataImportDetailsImpl();

		model.setLmisDataImportDetailsId(soapModel.getLmisDataImportDetailsId());
		model.setRootId(soapModel.getRootId());
		model.setImportId(soapModel.getImportId());
		model.setStartTime(soapModel.getStartTime());
		model.setEndTime(soapModel.getEndTime());
		model.setScannerId(soapModel.getScannerId());
		model.setAbSence(soapModel.getAbSence());
		model.setStaffName(soapModel.getStaffName());

		return model;
	}

	public static List<LmisDataImportDetails> toModels(
		LmisDataImportDetailsSoap[] soapModels) {
		List<LmisDataImportDetails> models = new ArrayList<LmisDataImportDetails>(soapModels.length);

		for (LmisDataImportDetailsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.lmis.model.LmisDataImportDetails"));

	public LmisDataImportDetailsModelImpl() {
	}

	public Integer getPrimaryKey() {
		return _lmisDataImportDetailsId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisDataImportDetailsId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _lmisDataImportDetailsId;
	}

	public Integer getLmisDataImportDetailsId() {
		return _lmisDataImportDetailsId;
	}

	public void setLmisDataImportDetailsId(Integer lmisDataImportDetailsId) {
		_lmisDataImportDetailsId = lmisDataImportDetailsId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public int getImportId() {
		return _importId;
	}

	public void setImportId(int importId) {
		_importId = importId;
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

	public String getScannerId() {
		return GetterUtil.getString(_scannerId);
	}

	public void setScannerId(String scannerId) {
		_scannerId = scannerId;
	}

	public int getAbSence() {
		return _abSence;
	}

	public void setAbSence(int abSence) {
		_abSence = abSence;
	}

	public String getStaffName() {
		return GetterUtil.getString(_staffName);
	}

	public void setStaffName(String staffName) {
		_staffName = staffName;
	}

	public LmisDataImportDetails toEscapedModel() {
		if (isEscapedModel()) {
			return (LmisDataImportDetails)this;
		}
		else {
			LmisDataImportDetails model = new LmisDataImportDetailsImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setLmisDataImportDetailsId(getLmisDataImportDetailsId());
			model.setRootId(getRootId());
			model.setImportId(getImportId());
			model.setStartTime(getStartTime());
			model.setEndTime(getEndTime());
			model.setScannerId(HtmlUtil.escape(getScannerId()));
			model.setAbSence(getAbSence());
			model.setStaffName(HtmlUtil.escape(getStaffName()));

			model = (LmisDataImportDetails)Proxy.newProxyInstance(LmisDataImportDetails.class.getClassLoader(),
					new Class[] { LmisDataImportDetails.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		LmisDataImportDetailsImpl clone = new LmisDataImportDetailsImpl();

		clone.setLmisDataImportDetailsId(getLmisDataImportDetailsId());
		clone.setRootId(getRootId());
		clone.setImportId(getImportId());
		clone.setStartTime(getStartTime());
		clone.setEndTime(getEndTime());
		clone.setScannerId(getScannerId());
		clone.setAbSence(getAbSence());
		clone.setStaffName(getStaffName());

		return clone;
	}

	public int compareTo(LmisDataImportDetails lmisDataImportDetails) {
		Integer pk = lmisDataImportDetails.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		LmisDataImportDetails lmisDataImportDetails = null;

		try {
			lmisDataImportDetails = (LmisDataImportDetails)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = lmisDataImportDetails.getPrimaryKey();

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

		sb.append("{lmisDataImportDetailsId=");
		sb.append(getLmisDataImportDetailsId());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", importId=");
		sb.append(getImportId());
		sb.append(", startTime=");
		sb.append(getStartTime());
		sb.append(", endTime=");
		sb.append(getEndTime());
		sb.append(", scannerId=");
		sb.append(getScannerId());
		sb.append(", abSence=");
		sb.append(getAbSence());
		sb.append(", staffName=");
		sb.append(getStaffName());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.lmis.model.LmisDataImportDetails");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>lmisDataImportDetailsId</column-name><column-value><![CDATA[");
		sb.append(getLmisDataImportDetailsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rootId</column-name><column-value><![CDATA[");
		sb.append(getRootId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>importId</column-name><column-value><![CDATA[");
		sb.append(getImportId());
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
			"<column><column-name>scannerId</column-name><column-value><![CDATA[");
		sb.append(getScannerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>abSence</column-name><column-value><![CDATA[");
		sb.append(getAbSence());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>staffName</column-name><column-value><![CDATA[");
		sb.append(getStaffName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _lmisDataImportDetailsId;
	private int _rootId;
	private int _importId;
	private Date _startTime;
	private Date _endTime;
	private String _scannerId;
	private int _abSence;
	private String _staffName;
}