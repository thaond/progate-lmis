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

import larion.progate.cds.model.CdsTitleCompetencies;
import larion.progate.cds.model.CdsTitleCompetenciesSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="CdsTitleCompetenciesModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsTitleCompetenciesModelImpl extends BaseModelImpl<CdsTitleCompetencies> {
	public static final String TABLE_NAME = "cds_title_competencies";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "title_id", new Integer(Types.INTEGER) },
			

			{ "competency_id", new Integer(Types.INTEGER) },
			

			{ "point_hash", new Integer(Types.INTEGER) },
			

			{ "point_value", new Integer(Types.VARCHAR) }
		};
	public static final String TABLE_SQL_CREATE = "create table cds_title_competencies (id INTEGER not null primary key,title_id INTEGER,competency_id INTEGER,point_hash INTEGER,point_value VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table cds_title_competencies";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.cds.model.CdsTitleCompetencies"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.cds.model.CdsTitleCompetencies"),
			false);

	public static CdsTitleCompetencies toModel(
		CdsTitleCompetenciesSoap soapModel) {
		CdsTitleCompetencies model = new CdsTitleCompetenciesImpl();

		model.setCdsTitleCompetenciesId(soapModel.getCdsTitleCompetenciesId());
		model.setCdsTitleId(soapModel.getCdsTitleId());
		model.setCompetencyId(soapModel.getCompetencyId());
		model.setPointHash(soapModel.getPointHash());
		model.setPointValue(soapModel.getPointValue());

		return model;
	}

	public static List<CdsTitleCompetencies> toModels(
		CdsTitleCompetenciesSoap[] soapModels) {
		List<CdsTitleCompetencies> models = new ArrayList<CdsTitleCompetencies>(soapModels.length);

		for (CdsTitleCompetenciesSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.cds.model.CdsTitleCompetencies"));

	public CdsTitleCompetenciesModelImpl() {
	}

	public Integer getPrimaryKey() {
		return _CdsTitleCompetenciesId;
	}

	public void setPrimaryKey(Integer pk) {
		setCdsTitleCompetenciesId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _CdsTitleCompetenciesId;
	}

	public Integer getCdsTitleCompetenciesId() {
		return _CdsTitleCompetenciesId;
	}

	public void setCdsTitleCompetenciesId(Integer CdsTitleCompetenciesId) {
		_CdsTitleCompetenciesId = CdsTitleCompetenciesId;
	}

	public int getCdsTitleId() {
		return _cdsTitleId;
	}

	public void setCdsTitleId(int cdsTitleId) {
		_cdsTitleId = cdsTitleId;
	}

	public int getCompetencyId() {
		return _competencyId;
	}

	public void setCompetencyId(int competencyId) {
		_competencyId = competencyId;
	}

	public int getPointHash() {
		return _pointHash;
	}

	public void setPointHash(int pointHash) {
		_pointHash = pointHash;
	}

	public String getPointValue() {
		return GetterUtil.getString(_pointValue);
	}

	public void setPointValue(String pointValue) {
		_pointValue = pointValue;
	}

	public CdsTitleCompetencies toEscapedModel() {
		if (isEscapedModel()) {
			return (CdsTitleCompetencies)this;
		}
		else {
			CdsTitleCompetencies model = new CdsTitleCompetenciesImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setCdsTitleCompetenciesId(getCdsTitleCompetenciesId());
			model.setCdsTitleId(getCdsTitleId());
			model.setCompetencyId(getCompetencyId());
			model.setPointHash(getPointHash());
			model.setPointValue(HtmlUtil.escape(getPointValue()));

			model = (CdsTitleCompetencies)Proxy.newProxyInstance(CdsTitleCompetencies.class.getClassLoader(),
					new Class[] { CdsTitleCompetencies.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		CdsTitleCompetenciesImpl clone = new CdsTitleCompetenciesImpl();

		clone.setCdsTitleCompetenciesId(getCdsTitleCompetenciesId());
		clone.setCdsTitleId(getCdsTitleId());
		clone.setCompetencyId(getCompetencyId());
		clone.setPointHash(getPointHash());
		clone.setPointValue(getPointValue());

		return clone;
	}

	public int compareTo(CdsTitleCompetencies cdsTitleCompetencies) {
		Integer pk = cdsTitleCompetencies.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		CdsTitleCompetencies cdsTitleCompetencies = null;

		try {
			cdsTitleCompetencies = (CdsTitleCompetencies)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = cdsTitleCompetencies.getPrimaryKey();

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

		sb.append("{CdsTitleCompetenciesId=");
		sb.append(getCdsTitleCompetenciesId());
		sb.append(", cdsTitleId=");
		sb.append(getCdsTitleId());
		sb.append(", competencyId=");
		sb.append(getCompetencyId());
		sb.append(", pointHash=");
		sb.append(getPointHash());
		sb.append(", pointValue=");
		sb.append(getPointValue());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.cds.model.CdsTitleCompetencies");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>CdsTitleCompetenciesId</column-name><column-value><![CDATA[");
		sb.append(getCdsTitleCompetenciesId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cdsTitleId</column-name><column-value><![CDATA[");
		sb.append(getCdsTitleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>competencyId</column-name><column-value><![CDATA[");
		sb.append(getCompetencyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pointHash</column-name><column-value><![CDATA[");
		sb.append(getPointHash());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pointValue</column-name><column-value><![CDATA[");
		sb.append(getPointValue());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _CdsTitleCompetenciesId;
	private int _cdsTitleId;
	private int _competencyId;
	private int _pointHash;
	private String _pointValue;
}