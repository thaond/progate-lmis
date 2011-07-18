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
import com.liferay.portal.model.impl.BaseModelImpl;

import larion.progate.cds.model.CdsPAFinal;
import larion.progate.cds.model.CdsPAFinalSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="CdsPAFinalModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsPAFinalModelImpl extends BaseModelImpl<CdsPAFinal> {
	public static final String TABLE_NAME = "cds_performance_appraisal_final";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "root_id", new Integer(Types.INTEGER) },
			

			{ "user_id", new Integer(Types.INTEGER) },
			

			{ "title_id", new Integer(Types.INTEGER) }
		};
	public static final String TABLE_SQL_CREATE = "create table cds_performance_appraisal_final (id INTEGER not null primary key,root_id INTEGER,user_id INTEGER,title_id INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table cds_performance_appraisal_final";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.cds.model.CdsPAFinal"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.cds.model.CdsPAFinal"),
			false);

	public static CdsPAFinal toModel(CdsPAFinalSoap soapModel) {
		CdsPAFinal model = new CdsPAFinalImpl();

		model.setCdsPAFinalId(soapModel.getCdsPAFinalId());
		model.setRootId(soapModel.getRootId());
		model.setUserId(soapModel.getUserId());
		model.setCdsTitleId(soapModel.getCdsTitleId());

		return model;
	}

	public static List<CdsPAFinal> toModels(CdsPAFinalSoap[] soapModels) {
		List<CdsPAFinal> models = new ArrayList<CdsPAFinal>(soapModels.length);

		for (CdsPAFinalSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.cds.model.CdsPAFinal"));

	public CdsPAFinalModelImpl() {
	}

	public Integer getPrimaryKey() {
		return _cdsPAFinalId;
	}

	public void setPrimaryKey(Integer pk) {
		setCdsPAFinalId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _cdsPAFinalId;
	}

	public Integer getCdsPAFinalId() {
		return _cdsPAFinalId;
	}

	public void setCdsPAFinalId(Integer cdsPAFinalId) {
		_cdsPAFinalId = cdsPAFinalId;
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

	public int getCdsTitleId() {
		return _cdsTitleId;
	}

	public void setCdsTitleId(int cdsTitleId) {
		_cdsTitleId = cdsTitleId;
	}

	public CdsPAFinal toEscapedModel() {
		if (isEscapedModel()) {
			return (CdsPAFinal)this;
		}
		else {
			CdsPAFinal model = new CdsPAFinalImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setCdsPAFinalId(getCdsPAFinalId());
			model.setRootId(getRootId());
			model.setUserId(getUserId());
			model.setCdsTitleId(getCdsTitleId());

			model = (CdsPAFinal)Proxy.newProxyInstance(CdsPAFinal.class.getClassLoader(),
					new Class[] { CdsPAFinal.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		CdsPAFinalImpl clone = new CdsPAFinalImpl();

		clone.setCdsPAFinalId(getCdsPAFinalId());
		clone.setRootId(getRootId());
		clone.setUserId(getUserId());
		clone.setCdsTitleId(getCdsTitleId());

		return clone;
	}

	public int compareTo(CdsPAFinal cdsPAFinal) {
		Integer pk = cdsPAFinal.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		CdsPAFinal cdsPAFinal = null;

		try {
			cdsPAFinal = (CdsPAFinal)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = cdsPAFinal.getPrimaryKey();

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

		sb.append("{cdsPAFinalId=");
		sb.append(getCdsPAFinalId());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", cdsTitleId=");
		sb.append(getCdsTitleId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.cds.model.CdsPAFinal");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>cdsPAFinalId</column-name><column-value><![CDATA[");
		sb.append(getCdsPAFinalId());
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
			"<column><column-name>cdsTitleId</column-name><column-value><![CDATA[");
		sb.append(getCdsTitleId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _cdsPAFinalId;
	private int _rootId;
	private int _userId;
	private int _cdsTitleId;
}