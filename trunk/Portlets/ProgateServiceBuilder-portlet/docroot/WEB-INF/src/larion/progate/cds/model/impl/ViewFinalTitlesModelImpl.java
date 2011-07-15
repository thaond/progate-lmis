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

import larion.progate.cds.model.ViewFinalTitles;
import larion.progate.cds.model.ViewFinalTitlesSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="ViewFinalTitlesModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ViewFinalTitlesModelImpl extends BaseModelImpl<ViewFinalTitles> {
	public static final String TABLE_NAME = "v_cds_performance_appraisal_final_cds_titles";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "root_id", new Integer(Types.INTEGER) },
			

			{ "user_id", new Integer(Types.INTEGER) },
			

			{ "title_id", new Integer(Types.INTEGER) },
			

			{ "titlename", new Integer(Types.VARCHAR) }
		};
	public static final String TABLE_SQL_CREATE = "create table v_cds_performance_appraisal_final_cds_titles (id INTEGER not null primary key,root_id INTEGER,user_id INTEGER,title_id INTEGER,titlename VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table v_cds_performance_appraisal_final_cds_titles";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.cds.model.ViewFinalTitles"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.cds.model.ViewFinalTitles"),
			false);

	public static ViewFinalTitles toModel(ViewFinalTitlesSoap soapModel) {
		ViewFinalTitles model = new ViewFinalTitlesImpl();

		model.setViewFinalTitlesId(soapModel.getViewFinalTitlesId());
		model.setRootId(soapModel.getRootId());
		model.setUserId(soapModel.getUserId());
		model.setTitleId(soapModel.getTitleId());
		model.setTitleName(soapModel.getTitleName());

		return model;
	}

	public static List<ViewFinalTitles> toModels(
		ViewFinalTitlesSoap[] soapModels) {
		List<ViewFinalTitles> models = new ArrayList<ViewFinalTitles>(soapModels.length);

		for (ViewFinalTitlesSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.cds.model.ViewFinalTitles"));

	public ViewFinalTitlesModelImpl() {
	}

	public Integer getPrimaryKey() {
		return _ViewFinalTitlesId;
	}

	public void setPrimaryKey(Integer pk) {
		setViewFinalTitlesId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _ViewFinalTitlesId;
	}

	public Integer getViewFinalTitlesId() {
		return _ViewFinalTitlesId;
	}

	public void setViewFinalTitlesId(Integer ViewFinalTitlesId) {
		_ViewFinalTitlesId = ViewFinalTitlesId;
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

	public int getTitleId() {
		return _titleId;
	}

	public void setTitleId(int titleId) {
		_titleId = titleId;
	}

	public String getTitleName() {
		return GetterUtil.getString(_titleName);
	}

	public void setTitleName(String titleName) {
		_titleName = titleName;
	}

	public ViewFinalTitles toEscapedModel() {
		if (isEscapedModel()) {
			return (ViewFinalTitles)this;
		}
		else {
			ViewFinalTitles model = new ViewFinalTitlesImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setViewFinalTitlesId(getViewFinalTitlesId());
			model.setRootId(getRootId());
			model.setUserId(getUserId());
			model.setTitleId(getTitleId());
			model.setTitleName(HtmlUtil.escape(getTitleName()));

			model = (ViewFinalTitles)Proxy.newProxyInstance(ViewFinalTitles.class.getClassLoader(),
					new Class[] { ViewFinalTitles.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		ViewFinalTitlesImpl clone = new ViewFinalTitlesImpl();

		clone.setViewFinalTitlesId(getViewFinalTitlesId());
		clone.setRootId(getRootId());
		clone.setUserId(getUserId());
		clone.setTitleId(getTitleId());
		clone.setTitleName(getTitleName());

		return clone;
	}

	public int compareTo(ViewFinalTitles viewFinalTitles) {
		Integer pk = viewFinalTitles.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ViewFinalTitles viewFinalTitles = null;

		try {
			viewFinalTitles = (ViewFinalTitles)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = viewFinalTitles.getPrimaryKey();

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

		sb.append("{ViewFinalTitlesId=");
		sb.append(getViewFinalTitlesId());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", titleId=");
		sb.append(getTitleId());
		sb.append(", titleName=");
		sb.append(getTitleName());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.cds.model.ViewFinalTitles");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ViewFinalTitlesId</column-name><column-value><![CDATA[");
		sb.append(getViewFinalTitlesId());
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
			"<column><column-name>titleId</column-name><column-value><![CDATA[");
		sb.append(getTitleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>titleName</column-name><column-value><![CDATA[");
		sb.append(getTitleName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _ViewFinalTitlesId;
	private int _rootId;
	private int _userId;
	private int _titleId;
	private String _titleName;
}