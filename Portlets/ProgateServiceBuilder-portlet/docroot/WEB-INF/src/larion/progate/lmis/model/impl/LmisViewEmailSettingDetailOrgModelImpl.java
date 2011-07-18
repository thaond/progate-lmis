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

package larion.progate.lmis.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import larion.progate.lmis.model.LmisViewEmailSettingDetailOrg;
import larion.progate.lmis.model.LmisViewEmailSettingDetailOrgSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="LmisViewEmailSettingDetailOrgModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewEmailSettingDetailOrgModelImpl extends BaseModelImpl<LmisViewEmailSettingDetailOrg> {
	public static final String TABLE_NAME = "vw_email_setting_detail_org";
	public static final Object[][] TABLE_COLUMNS = {
			{ "org_related_id", new Integer(Types.INTEGER) },
			

			{ "id", new Integer(Types.INTEGER) },
			

			{ "root_id", new Integer(Types.INTEGER) },
			

			{ "email_name", new Integer(Types.VARCHAR) },
			

			{ "category", new Integer(Types.INTEGER) },
			

			{ "to_sender", new Integer(Types.BOOLEAN) },
			

			{ "to_pm", new Integer(Types.BOOLEAN) },
			

			{ "to_bod", new Integer(Types.BOOLEAN) },
			

			{ "email_type", new Integer(Types.VARCHAR) },
			

			{ "email_org", new Integer(Types.VARCHAR) }
		};
	public static final String TABLE_SQL_CREATE = "create table vw_email_setting_detail_org (org_related_id INTEGER not null primary key,id INTEGER,root_id INTEGER,email_name VARCHAR(75) null,category INTEGER,to_sender BOOLEAN,to_pm BOOLEAN,to_bod BOOLEAN,email_type VARCHAR(75) null,email_org VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table vw_email_setting_detail_org";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.lmis.model.LmisViewEmailSettingDetailOrg"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.lmis.model.LmisViewEmailSettingDetailOrg"),
			false);

	public static LmisViewEmailSettingDetailOrg toModel(
		LmisViewEmailSettingDetailOrgSoap soapModel) {
		LmisViewEmailSettingDetailOrg model = new LmisViewEmailSettingDetailOrgImpl();

		model.setOrgRelatedId(soapModel.getOrgRelatedId());
		model.setId_(soapModel.getId_());
		model.setRootId(soapModel.getRootId());
		model.setName(soapModel.getName());
		model.setCategory(soapModel.getCategory());
		model.setToSender(soapModel.getToSender());
		model.setToPm(soapModel.getToPm());
		model.setToBod(soapModel.getToBod());
		model.setEmailType(soapModel.getEmailType());
		model.setEmailOrg(soapModel.getEmailOrg());

		return model;
	}

	public static List<LmisViewEmailSettingDetailOrg> toModels(
		LmisViewEmailSettingDetailOrgSoap[] soapModels) {
		List<LmisViewEmailSettingDetailOrg> models = new ArrayList<LmisViewEmailSettingDetailOrg>(soapModels.length);

		for (LmisViewEmailSettingDetailOrgSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.lmis.model.LmisViewEmailSettingDetailOrg"));

	public LmisViewEmailSettingDetailOrgModelImpl() {
	}

	public Integer getPrimaryKey() {
		return _orgRelatedId;
	}

	public void setPrimaryKey(Integer pk) {
		setOrgRelatedId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _orgRelatedId;
	}

	public Integer getOrgRelatedId() {
		return _orgRelatedId;
	}

	public void setOrgRelatedId(Integer orgRelatedId) {
		_orgRelatedId = orgRelatedId;
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
		return GetterUtil.getString(_name);
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
		return GetterUtil.getString(_emailType);
	}

	public void setEmailType(String emailType) {
		_emailType = emailType;
	}

	public String getEmailOrg() {
		return GetterUtil.getString(_emailOrg);
	}

	public void setEmailOrg(String emailOrg) {
		_emailOrg = emailOrg;
	}

	public LmisViewEmailSettingDetailOrg toEscapedModel() {
		if (isEscapedModel()) {
			return (LmisViewEmailSettingDetailOrg)this;
		}
		else {
			LmisViewEmailSettingDetailOrg model = new LmisViewEmailSettingDetailOrgImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setOrgRelatedId(getOrgRelatedId());
			model.setId_(getId_());
			model.setRootId(getRootId());
			model.setName(HtmlUtil.escape(getName()));
			model.setCategory(getCategory());
			model.setToSender(getToSender());
			model.setToPm(getToPm());
			model.setToBod(getToBod());
			model.setEmailType(HtmlUtil.escape(getEmailType()));
			model.setEmailOrg(HtmlUtil.escape(getEmailOrg()));

			model = (LmisViewEmailSettingDetailOrg)Proxy.newProxyInstance(LmisViewEmailSettingDetailOrg.class.getClassLoader(),
					new Class[] { LmisViewEmailSettingDetailOrg.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		LmisViewEmailSettingDetailOrgImpl clone = new LmisViewEmailSettingDetailOrgImpl();

		clone.setOrgRelatedId(getOrgRelatedId());
		clone.setId_(getId_());
		clone.setRootId(getRootId());
		clone.setName(getName());
		clone.setCategory(getCategory());
		clone.setToSender(getToSender());
		clone.setToPm(getToPm());
		clone.setToBod(getToBod());
		clone.setEmailType(getEmailType());
		clone.setEmailOrg(getEmailOrg());

		return clone;
	}

	public int compareTo(
		LmisViewEmailSettingDetailOrg lmisViewEmailSettingDetailOrg) {
		Integer pk = lmisViewEmailSettingDetailOrg.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		LmisViewEmailSettingDetailOrg lmisViewEmailSettingDetailOrg = null;

		try {
			lmisViewEmailSettingDetailOrg = (LmisViewEmailSettingDetailOrg)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = lmisViewEmailSettingDetailOrg.getPrimaryKey();

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

		sb.append("{orgRelatedId=");
		sb.append(getOrgRelatedId());
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
		sb.append(", emailOrg=");
		sb.append(getEmailOrg());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.lmis.model.LmisViewEmailSettingDetailOrg");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>orgRelatedId</column-name><column-value><![CDATA[");
		sb.append(getOrgRelatedId());
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
			"<column><column-name>emailOrg</column-name><column-value><![CDATA[");
		sb.append(getEmailOrg());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _orgRelatedId;
	private int _id_;
	private int _rootId;
	private String _name;
	private int _category;
	private boolean _toSender;
	private boolean _toPm;
	private boolean _toBod;
	private String _emailType;
	private String _emailOrg;
}