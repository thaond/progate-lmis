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

package larion.progate.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import larion.progate.model.ProGateApplications;
import larion.progate.model.ProGateApplicationsSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="ProGateApplicationsModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateApplicationsModelImpl extends BaseModelImpl<ProGateApplications> {
	public static final String TABLE_NAME = "progate_applications";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "layout_id", new Integer(Types.INTEGER) },
			

			{ "name", new Integer(Types.VARCHAR) },
			

			{ "title", new Integer(Types.VARCHAR) },
			

			{ "description", new Integer(Types.VARCHAR) },
			

			{ "is_hidden", new Integer(Types.BOOLEAN) },
			

			{ "friendly_url", new Integer(Types.VARCHAR) },
			

			{ "image_url", new Integer(Types.VARCHAR) },
			

			{ "icon_url", new Integer(Types.VARCHAR) },
			

			{ "created_at", new Integer(Types.TIMESTAMP) },
			

			{ "updated_at", new Integer(Types.TIMESTAMP) }
		};
	public static final String TABLE_SQL_CREATE = "create table progate_applications (id INTEGER not null primary key,layout_id INTEGER,name VARCHAR(75) null,title VARCHAR(75) null,description VARCHAR(75) null,is_hidden BOOLEAN,friendly_url VARCHAR(75) null,image_url VARCHAR(75) null,icon_url VARCHAR(75) null,created_at DATE null,updated_at DATE null)";
	public static final String TABLE_SQL_DROP = "drop table progate_applications";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.model.ProGateApplications"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.model.ProGateApplications"),
			false);

	public static ProGateApplications toModel(ProGateApplicationsSoap soapModel) {
		ProGateApplications model = new ProGateApplicationsImpl();

		model.setProGateApplicationsId(soapModel.getProGateApplicationsId());
		model.setLayoutId(soapModel.getLayoutId());
		model.setName(soapModel.getName());
		model.setTitle(soapModel.getTitle());
		model.setDescription(soapModel.getDescription());
		model.setIsHidden(soapModel.getIsHidden());
		model.setFriendlyUrl(soapModel.getFriendlyUrl());
		model.setImageUrl(soapModel.getImageUrl());
		model.setIconUrl(soapModel.getIconUrl());
		model.setCreatedDate(soapModel.getCreatedDate());
		model.setModifiedDate(soapModel.getModifiedDate());

		return model;
	}

	public static List<ProGateApplications> toModels(
		ProGateApplicationsSoap[] soapModels) {
		List<ProGateApplications> models = new ArrayList<ProGateApplications>(soapModels.length);

		for (ProGateApplicationsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.model.ProGateApplications"));

	public ProGateApplicationsModelImpl() {
	}

	public Integer getPrimaryKey() {
		return _ProGateApplicationsId;
	}

	public void setPrimaryKey(Integer pk) {
		setProGateApplicationsId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _ProGateApplicationsId;
	}

	public Integer getProGateApplicationsId() {
		return _ProGateApplicationsId;
	}

	public void setProGateApplicationsId(Integer ProGateApplicationsId) {
		_ProGateApplicationsId = ProGateApplicationsId;
	}

	public int getLayoutId() {
		return _layoutId;
	}

	public void setLayoutId(int layoutId) {
		_layoutId = layoutId;
	}

	public String getName() {
		return GetterUtil.getString(_name);
	}

	public void setName(String name) {
		_name = name;
	}

	public String getTitle() {
		return GetterUtil.getString(_title);
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getDescription() {
		return GetterUtil.getString(_description);
	}

	public void setDescription(String description) {
		_description = description;
	}

	public boolean getIsHidden() {
		return _isHidden;
	}

	public boolean isIsHidden() {
		return _isHidden;
	}

	public void setIsHidden(boolean isHidden) {
		_isHidden = isHidden;
	}

	public String getFriendlyUrl() {
		return GetterUtil.getString(_friendlyUrl);
	}

	public void setFriendlyUrl(String friendlyUrl) {
		_friendlyUrl = friendlyUrl;
	}

	public String getImageUrl() {
		return GetterUtil.getString(_imageUrl);
	}

	public void setImageUrl(String imageUrl) {
		_imageUrl = imageUrl;
	}

	public String getIconUrl() {
		return GetterUtil.getString(_iconUrl);
	}

	public void setIconUrl(String iconUrl) {
		_iconUrl = iconUrl;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public ProGateApplications toEscapedModel() {
		if (isEscapedModel()) {
			return (ProGateApplications)this;
		}
		else {
			ProGateApplications model = new ProGateApplicationsImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setProGateApplicationsId(getProGateApplicationsId());
			model.setLayoutId(getLayoutId());
			model.setName(HtmlUtil.escape(getName()));
			model.setTitle(HtmlUtil.escape(getTitle()));
			model.setDescription(HtmlUtil.escape(getDescription()));
			model.setIsHidden(getIsHidden());
			model.setFriendlyUrl(HtmlUtil.escape(getFriendlyUrl()));
			model.setImageUrl(HtmlUtil.escape(getImageUrl()));
			model.setIconUrl(HtmlUtil.escape(getIconUrl()));
			model.setCreatedDate(getCreatedDate());
			model.setModifiedDate(getModifiedDate());

			model = (ProGateApplications)Proxy.newProxyInstance(ProGateApplications.class.getClassLoader(),
					new Class[] { ProGateApplications.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		ProGateApplicationsImpl clone = new ProGateApplicationsImpl();

		clone.setProGateApplicationsId(getProGateApplicationsId());
		clone.setLayoutId(getLayoutId());
		clone.setName(getName());
		clone.setTitle(getTitle());
		clone.setDescription(getDescription());
		clone.setIsHidden(getIsHidden());
		clone.setFriendlyUrl(getFriendlyUrl());
		clone.setImageUrl(getImageUrl());
		clone.setIconUrl(getIconUrl());
		clone.setCreatedDate(getCreatedDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	public int compareTo(ProGateApplications proGateApplications) {
		Integer pk = proGateApplications.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ProGateApplications proGateApplications = null;

		try {
			proGateApplications = (ProGateApplications)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = proGateApplications.getPrimaryKey();

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

		sb.append("{ProGateApplicationsId=");
		sb.append(getProGateApplicationsId());
		sb.append(", layoutId=");
		sb.append(getLayoutId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", isHidden=");
		sb.append(getIsHidden());
		sb.append(", friendlyUrl=");
		sb.append(getFriendlyUrl());
		sb.append(", imageUrl=");
		sb.append(getImageUrl());
		sb.append(", iconUrl=");
		sb.append(getIconUrl());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.model.ProGateApplications");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ProGateApplicationsId</column-name><column-value><![CDATA[");
		sb.append(getProGateApplicationsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>layoutId</column-name><column-value><![CDATA[");
		sb.append(getLayoutId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isHidden</column-name><column-value><![CDATA[");
		sb.append(getIsHidden());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>friendlyUrl</column-name><column-value><![CDATA[");
		sb.append(getFriendlyUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageUrl</column-name><column-value><![CDATA[");
		sb.append(getImageUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>iconUrl</column-name><column-value><![CDATA[");
		sb.append(getIconUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdDate</column-name><column-value><![CDATA[");
		sb.append(getCreatedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _ProGateApplicationsId;
	private int _layoutId;
	private String _name;
	private String _title;
	private String _description;
	private boolean _isHidden;
	private String _friendlyUrl;
	private String _imageUrl;
	private String _iconUrl;
	private Date _createdDate;
	private Date _modifiedDate;
}