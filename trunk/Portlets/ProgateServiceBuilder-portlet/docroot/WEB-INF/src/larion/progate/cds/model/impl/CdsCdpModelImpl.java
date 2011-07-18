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

import larion.progate.cds.model.CdsCdp;
import larion.progate.cds.model.CdsCdpSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="CdsCdpModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsCdpModelImpl extends BaseModelImpl<CdsCdp> {
	public static final String TABLE_NAME = "cds_cdp";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "root_id", new Integer(Types.INTEGER) },
			

			{ "period_id", new Integer(Types.INTEGER) },
			

			{ "user_id", new Integer(Types.INTEGER) },
			

			{ "written_by", new Integer(Types.INTEGER) },
			

			{ "written_at", new Integer(Types.TIMESTAMP) },
			

			{ "written_content", new Integer(Types.VARCHAR) }
		};
	public static final String TABLE_SQL_CREATE = "create table cds_cdp (id INTEGER not null primary key,root_id INTEGER,period_id INTEGER,user_id INTEGER,written_by INTEGER,written_at DATE null,written_content VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table cds_cdp";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.cds.model.CdsCdp"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.cds.model.CdsCdp"),
			false);

	public static CdsCdp toModel(CdsCdpSoap soapModel) {
		CdsCdp model = new CdsCdpImpl();

		model.setCdsCdpId(soapModel.getCdsCdpId());
		model.setRootId(soapModel.getRootId());
		model.setPeriodId(soapModel.getPeriodId());
		model.setUserId(soapModel.getUserId());
		model.setWrittenBy(soapModel.getWrittenBy());
		model.setWrittenAt(soapModel.getWrittenAt());
		model.setWrittenContent(soapModel.getWrittenContent());

		return model;
	}

	public static List<CdsCdp> toModels(CdsCdpSoap[] soapModels) {
		List<CdsCdp> models = new ArrayList<CdsCdp>(soapModels.length);

		for (CdsCdpSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.cds.model.CdsCdp"));

	public CdsCdpModelImpl() {
	}

	public Integer getPrimaryKey() {
		return _CdsCdpId;
	}

	public void setPrimaryKey(Integer pk) {
		setCdsCdpId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _CdsCdpId;
	}

	public Integer getCdsCdpId() {
		return _CdsCdpId;
	}

	public void setCdsCdpId(Integer CdsCdpId) {
		_CdsCdpId = CdsCdpId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public int getPeriodId() {
		return _periodId;
	}

	public void setPeriodId(int periodId) {
		_periodId = periodId;
	}

	public int getUserId() {
		return _userId;
	}

	public void setUserId(int userId) {
		_userId = userId;
	}

	public int getWrittenBy() {
		return _writtenBy;
	}

	public void setWrittenBy(int writtenBy) {
		_writtenBy = writtenBy;
	}

	public Date getWrittenAt() {
		return _writtenAt;
	}

	public void setWrittenAt(Date writtenAt) {
		_writtenAt = writtenAt;
	}

	public String getWrittenContent() {
		return GetterUtil.getString(_writtenContent);
	}

	public void setWrittenContent(String writtenContent) {
		_writtenContent = writtenContent;
	}

	public CdsCdp toEscapedModel() {
		if (isEscapedModel()) {
			return (CdsCdp)this;
		}
		else {
			CdsCdp model = new CdsCdpImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setCdsCdpId(getCdsCdpId());
			model.setRootId(getRootId());
			model.setPeriodId(getPeriodId());
			model.setUserId(getUserId());
			model.setWrittenBy(getWrittenBy());
			model.setWrittenAt(getWrittenAt());
			model.setWrittenContent(HtmlUtil.escape(getWrittenContent()));

			model = (CdsCdp)Proxy.newProxyInstance(CdsCdp.class.getClassLoader(),
					new Class[] { CdsCdp.class }, new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		CdsCdpImpl clone = new CdsCdpImpl();

		clone.setCdsCdpId(getCdsCdpId());
		clone.setRootId(getRootId());
		clone.setPeriodId(getPeriodId());
		clone.setUserId(getUserId());
		clone.setWrittenBy(getWrittenBy());
		clone.setWrittenAt(getWrittenAt());
		clone.setWrittenContent(getWrittenContent());

		return clone;
	}

	public int compareTo(CdsCdp cdsCdp) {
		Integer pk = cdsCdp.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		CdsCdp cdsCdp = null;

		try {
			cdsCdp = (CdsCdp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = cdsCdp.getPrimaryKey();

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

		sb.append("{CdsCdpId=");
		sb.append(getCdsCdpId());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", periodId=");
		sb.append(getPeriodId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", writtenBy=");
		sb.append(getWrittenBy());
		sb.append(", writtenAt=");
		sb.append(getWrittenAt());
		sb.append(", writtenContent=");
		sb.append(getWrittenContent());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.cds.model.CdsCdp");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>CdsCdpId</column-name><column-value><![CDATA[");
		sb.append(getCdsCdpId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rootId</column-name><column-value><![CDATA[");
		sb.append(getRootId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>periodId</column-name><column-value><![CDATA[");
		sb.append(getPeriodId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>writtenBy</column-name><column-value><![CDATA[");
		sb.append(getWrittenBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>writtenAt</column-name><column-value><![CDATA[");
		sb.append(getWrittenAt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>writtenContent</column-name><column-value><![CDATA[");
		sb.append(getWrittenContent());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _CdsCdpId;
	private int _rootId;
	private int _periodId;
	private int _userId;
	private int _writtenBy;
	private Date _writtenAt;
	private String _writtenContent;
}