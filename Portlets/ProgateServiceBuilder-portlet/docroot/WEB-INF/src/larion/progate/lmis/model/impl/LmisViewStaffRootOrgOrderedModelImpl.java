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

import larion.progate.lmis.model.LmisViewStaffRootOrgOrdered;
import larion.progate.lmis.model.LmisViewStaffRootOrgOrderedSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="LmisViewStaffRootOrgOrderedModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewStaffRootOrgOrderedModelImpl extends BaseModelImpl<LmisViewStaffRootOrgOrdered> {
	public static final String TABLE_NAME = "vw_staff_root_org_fn_ordered";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "user_id", new Integer(Types.INTEGER) },
			

			{ "root_id", new Integer(Types.INTEGER) },
			

			{ "org_id", new Integer(Types.INTEGER) },
			

			{ "bod_id", new Integer(Types.INTEGER) },
			

			{ "staff_code", new Integer(Types.VARCHAR) },
			

			{ "scanner_code", new Integer(Types.VARCHAR) },
			

			{ "screenname", new Integer(Types.VARCHAR) },
			

			{ "firstname", new Integer(Types.VARCHAR) },
			

			{ "lastname", new Integer(Types.VARCHAR) },
			

			{ "fullname", new Integer(Types.VARCHAR) },
			

			{ "emailaddress", new Integer(Types.VARCHAR) }
		};
	public static final String TABLE_SQL_CREATE = "create table vw_staff_root_org_fn_ordered (id INTEGER not null primary key,user_id INTEGER,root_id INTEGER,org_id INTEGER,bod_id INTEGER,staff_code VARCHAR(75) null,scanner_code VARCHAR(75) null,screenname VARCHAR(75) null,firstname VARCHAR(75) null,lastname VARCHAR(75) null,fullname VARCHAR(75) null,emailaddress VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table vw_staff_root_org_fn_ordered";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.lmis.model.LmisViewStaffRootOrgOrdered"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.lmis.model.LmisViewStaffRootOrgOrdered"),
			false);

	public static LmisViewStaffRootOrgOrdered toModel(
		LmisViewStaffRootOrgOrderedSoap soapModel) {
		LmisViewStaffRootOrgOrdered model = new LmisViewStaffRootOrgOrderedImpl();

		model.setLmisViewStaffRootOrgOrderedId(soapModel.getLmisViewStaffRootOrgOrderedId());
		model.setUserId(soapModel.getUserId());
		model.setRootId(soapModel.getRootId());
		model.setOrgId(soapModel.getOrgId());
		model.setBodId(soapModel.getBodId());
		model.setStaffCode(soapModel.getStaffCode());
		model.setScannerCode(soapModel.getScannerCode());
		model.setScreenName(soapModel.getScreenName());
		model.setFirstName(soapModel.getFirstName());
		model.setLastName(soapModel.getLastName());
		model.setFullName(soapModel.getFullName());
		model.setEmailAddress(soapModel.getEmailAddress());

		return model;
	}

	public static List<LmisViewStaffRootOrgOrdered> toModels(
		LmisViewStaffRootOrgOrderedSoap[] soapModels) {
		List<LmisViewStaffRootOrgOrdered> models = new ArrayList<LmisViewStaffRootOrgOrdered>(soapModels.length);

		for (LmisViewStaffRootOrgOrderedSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.lmis.model.LmisViewStaffRootOrgOrdered"));

	public LmisViewStaffRootOrgOrderedModelImpl() {
	}

	public Integer getPrimaryKey() {
		return _lmisViewStaffRootOrgOrderedId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisViewStaffRootOrgOrderedId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _lmisViewStaffRootOrgOrderedId;
	}

	public Integer getLmisViewStaffRootOrgOrderedId() {
		return _lmisViewStaffRootOrgOrderedId;
	}

	public void setLmisViewStaffRootOrgOrderedId(
		Integer lmisViewStaffRootOrgOrderedId) {
		_lmisViewStaffRootOrgOrderedId = lmisViewStaffRootOrgOrderedId;
	}

	public int getUserId() {
		return _userId;
	}

	public void setUserId(int userId) {
		_userId = userId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public int getOrgId() {
		return _orgId;
	}

	public void setOrgId(int orgId) {
		_orgId = orgId;
	}

	public int getBodId() {
		return _bodId;
	}

	public void setBodId(int bodId) {
		_bodId = bodId;
	}

	public String getStaffCode() {
		return GetterUtil.getString(_staffCode);
	}

	public void setStaffCode(String staffCode) {
		_staffCode = staffCode;
	}

	public String getScannerCode() {
		return GetterUtil.getString(_scannerCode);
	}

	public void setScannerCode(String scannerCode) {
		_scannerCode = scannerCode;
	}

	public String getScreenName() {
		return GetterUtil.getString(_screenName);
	}

	public void setScreenName(String screenName) {
		_screenName = screenName;
	}

	public String getFirstName() {
		return GetterUtil.getString(_firstName);
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getLastName() {
		return GetterUtil.getString(_lastName);
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public String getFullName() {
		return GetterUtil.getString(_fullName);
	}

	public void setFullName(String fullName) {
		_fullName = fullName;
	}

	public String getEmailAddress() {
		return GetterUtil.getString(_emailAddress);
	}

	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	public LmisViewStaffRootOrgOrdered toEscapedModel() {
		if (isEscapedModel()) {
			return (LmisViewStaffRootOrgOrdered)this;
		}
		else {
			LmisViewStaffRootOrgOrdered model = new LmisViewStaffRootOrgOrderedImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setLmisViewStaffRootOrgOrderedId(getLmisViewStaffRootOrgOrderedId());
			model.setUserId(getUserId());
			model.setRootId(getRootId());
			model.setOrgId(getOrgId());
			model.setBodId(getBodId());
			model.setStaffCode(HtmlUtil.escape(getStaffCode()));
			model.setScannerCode(HtmlUtil.escape(getScannerCode()));
			model.setScreenName(HtmlUtil.escape(getScreenName()));
			model.setFirstName(HtmlUtil.escape(getFirstName()));
			model.setLastName(HtmlUtil.escape(getLastName()));
			model.setFullName(HtmlUtil.escape(getFullName()));
			model.setEmailAddress(HtmlUtil.escape(getEmailAddress()));

			model = (LmisViewStaffRootOrgOrdered)Proxy.newProxyInstance(LmisViewStaffRootOrgOrdered.class.getClassLoader(),
					new Class[] { LmisViewStaffRootOrgOrdered.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		LmisViewStaffRootOrgOrderedImpl clone = new LmisViewStaffRootOrgOrderedImpl();

		clone.setLmisViewStaffRootOrgOrderedId(getLmisViewStaffRootOrgOrderedId());
		clone.setUserId(getUserId());
		clone.setRootId(getRootId());
		clone.setOrgId(getOrgId());
		clone.setBodId(getBodId());
		clone.setStaffCode(getStaffCode());
		clone.setScannerCode(getScannerCode());
		clone.setScreenName(getScreenName());
		clone.setFirstName(getFirstName());
		clone.setLastName(getLastName());
		clone.setFullName(getFullName());
		clone.setEmailAddress(getEmailAddress());

		return clone;
	}

	public int compareTo(
		LmisViewStaffRootOrgOrdered lmisViewStaffRootOrgOrdered) {
		int value = 0;

		value = getFullName()
					.compareTo(lmisViewStaffRootOrgOrdered.getFullName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		LmisViewStaffRootOrgOrdered lmisViewStaffRootOrgOrdered = null;

		try {
			lmisViewStaffRootOrgOrdered = (LmisViewStaffRootOrgOrdered)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = lmisViewStaffRootOrgOrdered.getPrimaryKey();

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

		sb.append("{lmisViewStaffRootOrgOrderedId=");
		sb.append(getLmisViewStaffRootOrgOrderedId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", orgId=");
		sb.append(getOrgId());
		sb.append(", bodId=");
		sb.append(getBodId());
		sb.append(", staffCode=");
		sb.append(getStaffCode());
		sb.append(", scannerCode=");
		sb.append(getScannerCode());
		sb.append(", screenName=");
		sb.append(getScreenName());
		sb.append(", firstName=");
		sb.append(getFirstName());
		sb.append(", lastName=");
		sb.append(getLastName());
		sb.append(", fullName=");
		sb.append(getFullName());
		sb.append(", emailAddress=");
		sb.append(getEmailAddress());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.lmis.model.LmisViewStaffRootOrgOrdered");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>lmisViewStaffRootOrgOrderedId</column-name><column-value><![CDATA[");
		sb.append(getLmisViewStaffRootOrgOrderedId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rootId</column-name><column-value><![CDATA[");
		sb.append(getRootId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orgId</column-name><column-value><![CDATA[");
		sb.append(getOrgId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bodId</column-name><column-value><![CDATA[");
		sb.append(getBodId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>staffCode</column-name><column-value><![CDATA[");
		sb.append(getStaffCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>scannerCode</column-name><column-value><![CDATA[");
		sb.append(getScannerCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>screenName</column-name><column-value><![CDATA[");
		sb.append(getScreenName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firstName</column-name><column-value><![CDATA[");
		sb.append(getFirstName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastName</column-name><column-value><![CDATA[");
		sb.append(getLastName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fullName</column-name><column-value><![CDATA[");
		sb.append(getFullName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailAddress</column-name><column-value><![CDATA[");
		sb.append(getEmailAddress());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _lmisViewStaffRootOrgOrderedId;
	private int _userId;
	private int _rootId;
	private int _orgId;
	private int _bodId;
	private String _staffCode;
	private String _scannerCode;
	private String _screenName;
	private String _firstName;
	private String _lastName;
	private String _fullName;
	private String _emailAddress;
}