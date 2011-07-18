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

import larion.progate.cds.model.ViewFinalLevels;
import larion.progate.cds.model.ViewFinalLevelsSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="ViewFinalLevelsModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ViewFinalLevelsModelImpl extends BaseModelImpl<ViewFinalLevels> {
	public static final String TABLE_NAME = "v_final_levels";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "competency_id", new Integer(Types.INTEGER) },
			

			{ "root_id", new Integer(Types.INTEGER) },
			

			{ "name", new Integer(Types.VARCHAR) },
			

			{ "user_id", new Integer(Types.INTEGER) },
			

			{ "total_level_point", new Integer(Types.INTEGER) },
			

			{ "is_passed", new Integer(Types.BOOLEAN) }
		};
	public static final String TABLE_SQL_CREATE = "create table v_final_levels (id INTEGER not null primary key,competency_id INTEGER,root_id INTEGER,name VARCHAR(75) null,user_id INTEGER,total_level_point INTEGER,is_passed BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table v_final_levels";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.cds.model.ViewFinalLevels"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.cds.model.ViewFinalLevels"),
			false);

	public static ViewFinalLevels toModel(ViewFinalLevelsSoap soapModel) {
		ViewFinalLevels model = new ViewFinalLevelsImpl();

		model.setLevelId(soapModel.getLevelId());
		model.setCompetencyId(soapModel.getCompetencyId());
		model.setRootId(soapModel.getRootId());
		model.setName(soapModel.getName());
		model.setUserId(soapModel.getUserId());
		model.setTotalLevelPoint(soapModel.getTotalLevelPoint());
		model.setIsPassed(soapModel.getIsPassed());

		return model;
	}

	public static List<ViewFinalLevels> toModels(
		ViewFinalLevelsSoap[] soapModels) {
		List<ViewFinalLevels> models = new ArrayList<ViewFinalLevels>(soapModels.length);

		for (ViewFinalLevelsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.cds.model.ViewFinalLevels"));

	public ViewFinalLevelsModelImpl() {
	}

	public Integer getPrimaryKey() {
		return _levelId;
	}

	public void setPrimaryKey(Integer pk) {
		setLevelId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _levelId;
	}

	public Integer getLevelId() {
		return _levelId;
	}

	public void setLevelId(Integer levelId) {
		_levelId = levelId;
	}

	public int getCompetencyId() {
		return _competencyId;
	}

	public void setCompetencyId(int competencyId) {
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

	public int getTotalLevelPoint() {
		return _totalLevelPoint;
	}

	public void setTotalLevelPoint(int totalLevelPoint) {
		_totalLevelPoint = totalLevelPoint;
	}

	public boolean getIsPassed() {
		return _isPassed;
	}

	public boolean isIsPassed() {
		return _isPassed;
	}

	public void setIsPassed(boolean isPassed) {
		_isPassed = isPassed;
	}

	public ViewFinalLevels toEscapedModel() {
		if (isEscapedModel()) {
			return (ViewFinalLevels)this;
		}
		else {
			ViewFinalLevels model = new ViewFinalLevelsImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setLevelId(getLevelId());
			model.setCompetencyId(getCompetencyId());
			model.setRootId(getRootId());
			model.setName(HtmlUtil.escape(getName()));
			model.setUserId(getUserId());
			model.setTotalLevelPoint(getTotalLevelPoint());
			model.setIsPassed(getIsPassed());

			model = (ViewFinalLevels)Proxy.newProxyInstance(ViewFinalLevels.class.getClassLoader(),
					new Class[] { ViewFinalLevels.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		ViewFinalLevelsImpl clone = new ViewFinalLevelsImpl();

		clone.setLevelId(getLevelId());
		clone.setCompetencyId(getCompetencyId());
		clone.setRootId(getRootId());
		clone.setName(getName());
		clone.setUserId(getUserId());
		clone.setTotalLevelPoint(getTotalLevelPoint());
		clone.setIsPassed(getIsPassed());

		return clone;
	}

	public int compareTo(ViewFinalLevels viewFinalLevels) {
		Integer pk = viewFinalLevels.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ViewFinalLevels viewFinalLevels = null;

		try {
			viewFinalLevels = (ViewFinalLevels)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = viewFinalLevels.getPrimaryKey();

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

		sb.append("{levelId=");
		sb.append(getLevelId());
		sb.append(", competencyId=");
		sb.append(getCompetencyId());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", totalLevelPoint=");
		sb.append(getTotalLevelPoint());
		sb.append(", isPassed=");
		sb.append(getIsPassed());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.cds.model.ViewFinalLevels");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>levelId</column-name><column-value><![CDATA[");
		sb.append(getLevelId());
		sb.append("]]></column-value></column>");
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
			"<column><column-name>totalLevelPoint</column-name><column-value><![CDATA[");
		sb.append(getTotalLevelPoint());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isPassed</column-name><column-value><![CDATA[");
		sb.append(getIsPassed());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _levelId;
	private int _competencyId;
	private int _rootId;
	private String _name;
	private int _userId;
	private int _totalLevelPoint;
	private boolean _isPassed;
}