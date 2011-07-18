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
 * <a href="LmisViewStaffRootOrgFNClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewStaffRootOrgFNClp extends BaseModelImpl<LmisViewStaffRootOrgFN>
	implements LmisViewStaffRootOrgFN {
	public LmisViewStaffRootOrgFNClp() {
	}

	public Integer getPrimaryKey() {
		return _lmisViewStaffRootOrgFNId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisViewStaffRootOrgFNId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _lmisViewStaffRootOrgFNId;
	}

	public Integer getLmisViewStaffRootOrgFNId() {
		return _lmisViewStaffRootOrgFNId;
	}

	public void setLmisViewStaffRootOrgFNId(Integer lmisViewStaffRootOrgFNId) {
		_lmisViewStaffRootOrgFNId = lmisViewStaffRootOrgFNId;
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
		return _staffCode;
	}

	public void setStaffCode(String staffCode) {
		_staffCode = staffCode;
	}

	public String getScannerCode() {
		return _scannerCode;
	}

	public void setScannerCode(String scannerCode) {
		_scannerCode = scannerCode;
	}

	public String getScreenName() {
		return _screenName;
	}

	public void setScreenName(String screenName) {
		_screenName = screenName;
	}

	public String getFullName() {
		return _fullName;
	}

	public void setFullName(String fullName) {
		_fullName = fullName;
	}

	public String getEmailAddress() {
		return _emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	public LmisViewStaffRootOrgFN toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			LmisViewStaffRootOrgFN model = new LmisViewStaffRootOrgFNClp();

			model.setEscapedModel(true);

			model.setLmisViewStaffRootOrgFNId(getLmisViewStaffRootOrgFNId());
			model.setUserId(getUserId());
			model.setRootId(getRootId());
			model.setOrgId(getOrgId());
			model.setBodId(getBodId());
			model.setStaffCode(HtmlUtil.escape(getStaffCode()));
			model.setScannerCode(HtmlUtil.escape(getScannerCode()));
			model.setScreenName(HtmlUtil.escape(getScreenName()));
			model.setFullName(HtmlUtil.escape(getFullName()));
			model.setEmailAddress(HtmlUtil.escape(getEmailAddress()));

			model = (LmisViewStaffRootOrgFN)Proxy.newProxyInstance(LmisViewStaffRootOrgFN.class.getClassLoader(),
					new Class[] { LmisViewStaffRootOrgFN.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		LmisViewStaffRootOrgFNClp clone = new LmisViewStaffRootOrgFNClp();

		clone.setLmisViewStaffRootOrgFNId(getLmisViewStaffRootOrgFNId());
		clone.setUserId(getUserId());
		clone.setRootId(getRootId());
		clone.setOrgId(getOrgId());
		clone.setBodId(getBodId());
		clone.setStaffCode(getStaffCode());
		clone.setScannerCode(getScannerCode());
		clone.setScreenName(getScreenName());
		clone.setFullName(getFullName());
		clone.setEmailAddress(getEmailAddress());

		return clone;
	}

	public int compareTo(LmisViewStaffRootOrgFN lmisViewStaffRootOrgFN) {
		int value = 0;

		value = getEmailAddress()
					.compareTo(lmisViewStaffRootOrgFN.getEmailAddress());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		LmisViewStaffRootOrgFNClp lmisViewStaffRootOrgFN = null;

		try {
			lmisViewStaffRootOrgFN = (LmisViewStaffRootOrgFNClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = lmisViewStaffRootOrgFN.getPrimaryKey();

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

		sb.append("{lmisViewStaffRootOrgFNId=");
		sb.append(getLmisViewStaffRootOrgFNId());
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
		sb.append("larion.progate.lmis.model.LmisViewStaffRootOrgFN");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>lmisViewStaffRootOrgFNId</column-name><column-value><![CDATA[");
		sb.append(getLmisViewStaffRootOrgFNId());
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

	private Integer _lmisViewStaffRootOrgFNId;
	private int _userId;
	private int _rootId;
	private int _orgId;
	private int _bodId;
	private String _staffCode;
	private String _scannerCode;
	private String _screenName;
	private String _fullName;
	private String _emailAddress;
}