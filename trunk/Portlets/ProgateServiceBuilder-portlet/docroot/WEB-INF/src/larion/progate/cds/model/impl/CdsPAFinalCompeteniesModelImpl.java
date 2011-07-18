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

import larion.progate.cds.model.CdsPAFinalCompetenies;
import larion.progate.cds.model.CdsPAFinalCompeteniesSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="CdsPAFinalCompeteniesModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsPAFinalCompeteniesModelImpl extends BaseModelImpl<CdsPAFinalCompetenies> {
	public static final String TABLE_NAME = "cds_performance_appraisal_final_competencies";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "pa_id", new Integer(Types.INTEGER) },
			

			{ "root_id", new Integer(Types.INTEGER) },
			

			{ "user_id", new Integer(Types.INTEGER) },
			

			{ "competency_id", new Integer(Types.INTEGER) },
			

			{ "level_ranking_hash", new Integer(Types.INTEGER) },
			

			{ "level_ranking_value", new Integer(Types.VARCHAR) }
		};
	public static final String TABLE_SQL_CREATE = "create table cds_performance_appraisal_final_competencies (id INTEGER not null primary key,pa_id INTEGER,root_id INTEGER,user_id INTEGER,competency_id INTEGER,level_ranking_hash INTEGER,level_ranking_value VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table cds_performance_appraisal_final_competencies";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.cds.model.CdsPAFinalCompetenies"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.cds.model.CdsPAFinalCompetenies"),
			false);

	public static CdsPAFinalCompetenies toModel(
		CdsPAFinalCompeteniesSoap soapModel) {
		CdsPAFinalCompetenies model = new CdsPAFinalCompeteniesImpl();

		model.setCdsPAFinalCompeteniesId(soapModel.getCdsPAFinalCompeteniesId());
		model.setPaId(soapModel.getPaId());
		model.setRootId(soapModel.getRootId());
		model.setUserId(soapModel.getUserId());
		model.setCompetencyId(soapModel.getCompetencyId());
		model.setLevelRankingHash(soapModel.getLevelRankingHash());
		model.setLevelRankingValue(soapModel.getLevelRankingValue());

		return model;
	}

	public static List<CdsPAFinalCompetenies> toModels(
		CdsPAFinalCompeteniesSoap[] soapModels) {
		List<CdsPAFinalCompetenies> models = new ArrayList<CdsPAFinalCompetenies>(soapModels.length);

		for (CdsPAFinalCompeteniesSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.cds.model.CdsPAFinalCompetenies"));

	public CdsPAFinalCompeteniesModelImpl() {
	}

	public Integer getPrimaryKey() {
		return _cdsPAFinalCompeteniesId;
	}

	public void setPrimaryKey(Integer pk) {
		setCdsPAFinalCompeteniesId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _cdsPAFinalCompeteniesId;
	}

	public Integer getCdsPAFinalCompeteniesId() {
		return _cdsPAFinalCompeteniesId;
	}

	public void setCdsPAFinalCompeteniesId(Integer cdsPAFinalCompeteniesId) {
		_cdsPAFinalCompeteniesId = cdsPAFinalCompeteniesId;
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

	public CdsPAFinalCompetenies toEscapedModel() {
		if (isEscapedModel()) {
			return (CdsPAFinalCompetenies)this;
		}
		else {
			CdsPAFinalCompetenies model = new CdsPAFinalCompeteniesImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setCdsPAFinalCompeteniesId(getCdsPAFinalCompeteniesId());
			model.setPaId(getPaId());
			model.setRootId(getRootId());
			model.setUserId(getUserId());
			model.setCompetencyId(getCompetencyId());
			model.setLevelRankingHash(getLevelRankingHash());
			model.setLevelRankingValue(HtmlUtil.escape(getLevelRankingValue()));

			model = (CdsPAFinalCompetenies)Proxy.newProxyInstance(CdsPAFinalCompetenies.class.getClassLoader(),
					new Class[] { CdsPAFinalCompetenies.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		CdsPAFinalCompeteniesImpl clone = new CdsPAFinalCompeteniesImpl();

		clone.setCdsPAFinalCompeteniesId(getCdsPAFinalCompeteniesId());
		clone.setPaId(getPaId());
		clone.setRootId(getRootId());
		clone.setUserId(getUserId());
		clone.setCompetencyId(getCompetencyId());
		clone.setLevelRankingHash(getLevelRankingHash());
		clone.setLevelRankingValue(getLevelRankingValue());

		return clone;
	}

	public int compareTo(CdsPAFinalCompetenies cdsPAFinalCompetenies) {
		Integer pk = cdsPAFinalCompetenies.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		CdsPAFinalCompetenies cdsPAFinalCompetenies = null;

		try {
			cdsPAFinalCompetenies = (CdsPAFinalCompetenies)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = cdsPAFinalCompetenies.getPrimaryKey();

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

		sb.append("{cdsPAFinalCompeteniesId=");
		sb.append(getCdsPAFinalCompeteniesId());
		sb.append(", paId=");
		sb.append(getPaId());
		sb.append(", rootId=");
		sb.append(getRootId());
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
		sb.append("larion.progate.cds.model.CdsPAFinalCompetenies");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>cdsPAFinalCompeteniesId</column-name><column-value><![CDATA[");
		sb.append(getCdsPAFinalCompeteniesId());
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

	private Integer _cdsPAFinalCompeteniesId;
	private int _paId;
	private int _rootId;
	private int _userId;
	private int _competencyId;
	private int _levelRankingHash;
	private String _levelRankingValue;
}