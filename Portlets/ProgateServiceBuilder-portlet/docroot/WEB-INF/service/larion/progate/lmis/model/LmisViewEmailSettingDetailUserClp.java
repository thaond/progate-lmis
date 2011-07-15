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

package larion.progate.lmis.model;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * <a href="LmisViewEmailSettingDetailUserClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewEmailSettingDetailUserClp extends BaseModelImpl<LmisViewEmailSettingDetailUser>
	implements LmisViewEmailSettingDetailUser {
	public LmisViewEmailSettingDetailUserClp() {
	}

	public Integer getPrimaryKey() {
		return _userRelatedId;
	}

	public void setPrimaryKey(Integer pk) {
		setUserRelatedId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _userRelatedId;
	}

	public Integer getUserRelatedId() {
		return _userRelatedId;
	}

	public void setUserRelatedId(Integer userRelatedId) {
		_userRelatedId = userRelatedId;
	}

	public int getId_() {
		return _id_;
	}

	public void setId_(int id_) {
		_id_ = id_;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public int getCategory() {
		return _category;
	}

	public void setCategory(int category) {
		_category = category;
	}

	public boolean getToSender() {
		return _toSender;
	}

	public boolean isToSender() {
		return _toSender;
	}

	public void setToSender(boolean toSender) {
		_toSender = toSender;
	}

	public boolean getToPm() {
		return _toPm;
	}

	public boolean isToPm() {
		return _toPm;
	}

	public void setToPm(boolean toPm) {
		_toPm = toPm;
	}

	public boolean getToBod() {
		return _toBod;
	}

	public boolean isToBod() {
		return _toBod;
	}

	public void setToBod(boolean toBod) {
		_toBod = toBod;
	}

	public String getEmailType() {
		return _emailType;
	}

	public void setEmailType(String emailType) {
		_emailType = emailType;
	}

	public String getEmailUser() {
		return _emailUser;
	}

	public void setEmailUser(String emailUser) {
		_emailUser = emailUser;
	}

	public LmisViewEmailSettingDetailUser toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			LmisViewEmailSettingDetailUser model = new LmisViewEmailSettingDetailUserClp();

			model.setEscapedModel(true);

			model.setUserRelatedId(getUserRelatedId());
			model.setId_(getId_());
			model.setRootId(getRootId());
			model.setName(HtmlUtil.escape(getName()));
			model.setCategory(getCategory());
			model.setToSender(getToSender());
			model.setToPm(getToPm());
			model.setToBod(getToBod());
			model.setEmailType(HtmlUtil.escape(getEmailType()));
			model.setEmailUser(HtmlUtil.escape(getEmailUser()));

			model = (LmisViewEmailSettingDetailUser)Proxy.newProxyInstance(LmisViewEmailSettingDetailUser.class.getClassLoader(),
					new Class[] { LmisViewEmailSettingDetailUser.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		LmisViewEmailSettingDetailUserClp clone = new LmisViewEmailSettingDetailUserClp();

		clone.setUserRelatedId(getUserRelatedId());
		clone.setId_(getId_());
		clone.setRootId(getRootId());
		clone.setName(getName());
		clone.setCategory(getCategory());
		clone.setToSender(getToSender());
		clone.setToPm(getToPm());
		clone.setToBod(getToBod());
		clone.setEmailType(getEmailType());
		clone.setEmailUser(getEmailUser());

		return clone;
	}

	public int compareTo(
		LmisViewEmailSettingDetailUser lmisViewEmailSettingDetailUser) {
		Integer pk = lmisViewEmailSettingDetailUser.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		LmisViewEmailSettingDetailUserClp lmisViewEmailSettingDetailUser = null;

		try {
			lmisViewEmailSettingDetailUser = (LmisViewEmailSettingDetailUserClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = lmisViewEmailSettingDetailUser.getPrimaryKey();

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

		sb.append("{userRelatedId=");
		sb.append(getUserRelatedId());
		sb.append(", id_=");
		sb.append(getId_());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", category=");
		sb.append(getCategory());
		sb.append(", toSender=");
		sb.append(getToSender());
		sb.append(", toPm=");
		sb.append(getToPm());
		sb.append(", toBod=");
		sb.append(getToBod());
		sb.append(", emailType=");
		sb.append(getEmailType());
		sb.append(", emailUser=");
		sb.append(getEmailUser());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.lmis.model.LmisViewEmailSettingDetailUser");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>userRelatedId</column-name><column-value><![CDATA[");
		sb.append(getUserRelatedId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>id_</column-name><column-value><![CDATA[");
		sb.append(getId_());
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
			"<column><column-name>category</column-name><column-value><![CDATA[");
		sb.append(getCategory());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>toSender</column-name><column-value><![CDATA[");
		sb.append(getToSender());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>toPm</column-name><column-value><![CDATA[");
		sb.append(getToPm());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>toBod</column-name><column-value><![CDATA[");
		sb.append(getToBod());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailType</column-name><column-value><![CDATA[");
		sb.append(getEmailType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailUser</column-name><column-value><![CDATA[");
		sb.append(getEmailUser());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _userRelatedId;
	private int _id_;
	private int _rootId;
	private String _name;
	private int _category;
	private boolean _toSender;
	private boolean _toPm;
	private boolean _toBod;
	private String _emailType;
	private String _emailUser;
}