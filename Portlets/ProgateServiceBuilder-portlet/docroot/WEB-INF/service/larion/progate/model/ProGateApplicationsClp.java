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

package larion.progate.model;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * <a href="ProGateApplicationsClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateApplicationsClp extends BaseModelImpl<ProGateApplications>
	implements ProGateApplications {
	public ProGateApplicationsClp() {
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
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getDescription() {
		return _description;
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
		return _friendlyUrl;
	}

	public void setFriendlyUrl(String friendlyUrl) {
		_friendlyUrl = friendlyUrl;
	}

	public String getImageUrl() {
		return _imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		_imageUrl = imageUrl;
	}

	public String getIconUrl() {
		return _iconUrl;
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
			return this;
		}
		else {
			ProGateApplications model = new ProGateApplicationsClp();

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
		ProGateApplicationsClp clone = new ProGateApplicationsClp();

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

		ProGateApplicationsClp proGateApplications = null;

		try {
			proGateApplications = (ProGateApplicationsClp)obj;
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