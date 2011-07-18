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

import larion.progate.cds.model.ViewFinalCompetencies;
import larion.progate.cds.model.ViewFinalCompetenciesSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="ViewFinalCompetenciesModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ViewFinalCompetenciesModelImpl extends BaseModelImpl<ViewFinalCompetencies> {
	public static final String TABLE_NAME = "v_final_competencies";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "root_id", new Integer(Types.INTEGER) },
			

			{ "name", new Integer(Types.VARCHAR) },
			

			{ "user_id", new Integer(Types.INTEGER) },
			

			{ "level_ranking_hash", new Integer(Types.INTEGER) },
			

			{ "level_ranking_value", new Integer(Types.VARCHAR) }
		};
	public static final String TABLE_SQL_CREATE = "create table v_final_competencies (id INTEGER not null primary key,root_id INTEGER,name VARCHAR(75) null,user_id INTEGER,level_ranking_hash INTEGER,level_ranking_value VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table v_final_competencies";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.cds.model.ViewFinalCompetencies"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.cds.model.ViewFinalCompetencies"),
			false);

	public static ViewFinalCompetencies toModel(
		ViewFinalCompetenciesSoap soapModel) {
		ViewFinalCompetencies model = new ViewFinalCompetenciesImpl();

		model.setCompetencyId(soapModel.getCompetencyId());
		model.setRootId(soapModel.getRootId());
		model.setName(soapModel.getName());
		model.setUserId(soapModel.getUserId());
		model.setLevelRankingHash(soapModel.getLevelRankingHash());
		model.setLevelRankingValue(soapModel.getLevelRankingValue());

		return model;
	}

	public static List<ViewFinalCompetencies> toModels(
		ViewFinalCompetenciesSoap[] soapModels) {
		List<ViewFinalCompetencies> models = new ArrayList<ViewFinalCompetencies>(soapModels.length);

		for (ViewFinalCompetenciesSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.cds.model.ViewFinalCompetencies"));

	public ViewFinalCompetenciesModelImpl() {
	}

	public Integer getPrimaryKey() {
		return _competencyId;
	}

	public void setPrimaryKey(Integer pk) {
		setCompetencyId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _competencyId;
	}

	public Integer getCompetencyId() {
		return _competencyId;
	}

	public void setCompetencyId(Integer competencyId) {
		_competencyId = competencyId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public String getName() {
		return GetterUtil.getString(_name);
	}

	public void setName(String name) {
		_name = name;
	}

	public int getUserId() {
		return _userId;
	}

	public void setUserId(int userId) {
		_userId = userId;
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

	public ViewFinalCompetencies toEscapedModel() {
		if (isEscapedModel()) {
			return (ViewFinalCompetencies)this;
		}
		else {
			ViewFinalCompetencies model = new ViewFinalCompetenciesImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setCompetencyId(getCompetencyId());
			model.setRootId(getRootId());
			model.setName(HtmlUtil.escape(getName()));
			model.setUserId(getUserId());
			model.setLevelRankingHash(getLevelRankingHash());
			model.setLevelRankingValue(HtmlUtil.escape(getLevelRankingValue()));

			model = (ViewFinalCompetencies)Proxy.newProxyInstance(ViewFinalCompetencies.class.getClassLoader(),
					new Class[] { ViewFinalCompetencies.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		ViewFinalCompetenciesImpl clone = new ViewFinalCompetenciesImpl();

		clone.setCompetencyId(getCompetencyId());
		clone.setRootId(getRootId());
		clone.setName(getName());
		clone.setUserId(getUserId());
		clone.setLevelRankingHash(getLevelRankingHash());
		clone.setLevelRankingValue(getLevelRankingValue());

		return clone;
	}

	public int compareTo(ViewFinalCompetencies viewFinalCompetencies) {
		Integer pk = viewFinalCompetencies.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ViewFinalCompetencies viewFinalCompetencies = null;

		try {
			viewFinalCompetencies = (ViewFinalCompetencies)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = viewFinalCompetencies.getPrimaryKey();

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

		sb.append("{competencyId=");
		sb.append(getCompetencyId());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", userId=");
		sb.append(getUserId());
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
		sb.append("larion.progate.cds.model.ViewFinalCompetencies");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>competencyId</column-name><column-value><![CDATA[");
		sb.append(getCompetencyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rootId</column-name><column-value><![CDATA[");
		sb.append(getRootId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
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

	private Integer _competencyId;
	private int _rootId;
	private String _name;
	private int _userId;
	private int _levelRankingHash;
	private String _levelRankingValue;
}