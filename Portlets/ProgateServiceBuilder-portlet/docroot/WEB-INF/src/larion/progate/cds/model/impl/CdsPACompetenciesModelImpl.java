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

import larion.progate.cds.model.CdsPACompetencies;
import larion.progate.cds.model.CdsPACompetenciesSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="CdsPACompetenciesModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsPACompetenciesModelImpl extends BaseModelImpl<CdsPACompetencies> {
	public static final String TABLE_NAME = "cds_performance_appraisal_competencies";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "pa_id", new Integer(Types.INTEGER) },
			

			{ "root_id", new Integer(Types.INTEGER) },
			

			{ "period_id", new Integer(Types.INTEGER) },
			

			{ "user_id ", new Integer(Types.INTEGER) },
			

			{ "competency_id", new Integer(Types.INTEGER) },
			

			{ "level_ranking_hash", new Integer(Types.INTEGER) },
			

			{ "level_ranking_value", new Integer(Types.VARCHAR) }
		};
	public static final String TABLE_SQL_CREATE = "create table cds_performance_appraisal_competencies (id INTEGER not null primary key,pa_id INTEGER,root_id INTEGER,period_id INTEGER,user_id  INTEGER,competency_id INTEGER,level_ranking_hash INTEGER,level_ranking_value VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table cds_performance_appraisal_competencies";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.cds.model.CdsPACompetencies"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.cds.model.CdsPACompetencies"),
			false);

	public static CdsPACompetencies toModel(CdsPACompetenciesSoap soapModel) {
		CdsPACompetencies model = new CdsPACompetenciesImpl();

		model.setCdsPACompetenciesId(soapModel.getCdsPACompetenciesId());
		model.setPaId(soapModel.getPaId());
		model.setRootId(soapModel.getRootId());
		model.setPeriodId(soapModel.getPeriodId());
		model.setUserId(soapModel.getUserId());
		model.setCompetencyId(soapModel.getCompetencyId());
		model.setLevelRankingHash(soapModel.getLevelRankingHash());
		model.setLevelRankingValue(soapModel.getLevelRankingValue());

		return model;
	}

	public static List<CdsPACompetencies> toModels(
		CdsPACompetenciesSoap[] soapModels) {
		List<CdsPACompetencies> models = new ArrayList<CdsPACompetencies>(soapModels.length);

		for (CdsPACompetenciesSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.cds.model.CdsPACompetencies"));

	public CdsPACompetenciesModelImpl() {
	}

	public Integer getPrimaryKey() {
		return _CdsPACompetenciesId;
	}

	public void setPrimaryKey(Integer pk) {
		setCdsPACompetenciesId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _CdsPACompetenciesId;
	}

	public Integer getCdsPACompetenciesId() {
		return _CdsPACompetenciesId;
	}

	public void setCdsPACompetenciesId(Integer CdsPACompetenciesId) {
		_CdsPACompetenciesId = CdsPACompetenciesId;
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

	public int getCompetencyId() {
		return _competencyId;
	}

	public void setCompetencyId(int competencyId) {
		_competencyId = competencyId;
	}

	public int getLevelRankingHash() {
		return _levelRankingHash;
	}

	public void setLevelRankingHash(int levelRankingHash) {
		_levelRankingHash = levelRankingHash;
	}

	public String getLevelRankingValue() {
		return GetterUtil.getString(_levelRankingValue);
	}

	public void setLevelRankingValue(String levelRankingValue) {
		_levelRankingValue = levelRankingValue;
	}

	public CdsPACompetencies toEscapedModel() {
		if (isEscapedModel()) {
			return (CdsPACompetencies)this;
		}
		else {
			CdsPACompetencies model = new CdsPACompetenciesImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setCdsPACompetenciesId(getCdsPACompetenciesId());
			model.setPaId(getPaId());
			model.setRootId(getRootId());
			model.setPeriodId(getPeriodId());
			model.setUserId(getUserId());
			model.setCompetencyId(getCompetencyId());
			model.setLevelRankingHash(getLevelRankingHash());
			model.setLevelRankingValue(HtmlUtil.escape(getLevelRankingValue()));

			model = (CdsPACompetencies)Proxy.newProxyInstance(CdsPACompetencies.class.getClassLoader(),
					new Class[] { CdsPACompetencies.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		CdsPACompetenciesImpl clone = new CdsPACompetenciesImpl();

		clone.setCdsPACompetenciesId(getCdsPACompetenciesId());
		clone.setPaId(getPaId());
		clone.setRootId(getRootId());
		clone.setPeriodId(getPeriodId());
		clone.setUserId(getUserId());
		clone.setCompetencyId(getCompetencyId());
		clone.setLevelRankingHash(getLevelRankingHash());
		clone.setLevelRankingValue(getLevelRankingValue());

		return clone;
	}

	public int compareTo(CdsPACompetencies cdsPACompetencies) {
		Integer pk = cdsPACompetencies.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		CdsPACompetencies cdsPACompetencies = null;

		try {
			cdsPACompetencies = (CdsPACompetencies)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = cdsPACompetencies.getPrimaryKey();

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

		sb.append("{CdsPACompetenciesId=");
		sb.append(getCdsPACompetenciesId());
		sb.append(", paId=");
		sb.append(getPaId());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", periodId=");
		sb.append(getPeriodId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", competencyId=");
		sb.append(getCompetencyId());
		sb.append(", levelRankingHash=");
		sb.append(getLevelRankingHash());
		sb.append(", levelRankingValue=");
		sb.append(getLevelRankingValue());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.cds.model.CdsPACompetencies");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>CdsPACompetenciesId</column-name><column-value><![CDATA[");
		sb.append(getCdsPACompetenciesId());
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
			"<column><column-name>periodId</column-name><column-value><![CDATA[");
		sb.append(getPeriodId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>competencyId</column-name><column-value><![CDATA[");
		sb.append(getCompetencyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>levelRankingHash</column-name><column-value><![CDATA[");
		sb.append(getLevelRankingHash());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>levelRankingValue</column-name><column-value><![CDATA[");
		sb.append(getLevelRankingValue());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _CdsPACompetenciesId;
	private int _paId;
	private int _rootId;
	private int _periodId;
	private int _userId;
	private int _competencyId;
	private int _levelRankingHash;
	private String _levelRankingValue;
}