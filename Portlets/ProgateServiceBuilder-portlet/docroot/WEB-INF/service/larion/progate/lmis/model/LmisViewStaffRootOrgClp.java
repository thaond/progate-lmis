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
 * <a href="LmisViewStaffRootOrgClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewStaffRootOrgClp extends BaseModelImpl<LmisViewStaffRootOrg>
	implements LmisViewStaffRootOrg {
	public LmisViewStaffRootOrgClp() {
	}

	public Integer getPrimaryKey() {
		return _User_id;
	}

	public void setPrimaryKey(Integer pk) {
		setUser_id(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _User_id;
	}

	public Integer getUser_id() {
		return _User_id;
	}

	public void setUser_id(Integer User_id) {
		_User_id = User_id;
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

	public String getScreenName() {
		return _screenName;
	}

	public void setScreenName(String screenName) {
		_screenName = screenName;
	}

	public String getEmailAddress() {
		return _emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	public LmisViewStaffRootOrg toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			LmisViewStaffRootOrg model = new LmisViewStaffRootOrgClp();

			model.setEscapedModel(true);

			model.setUser_id(getUser_id());
			model.setRootId(getRootId());
			model.setOrgId(getOrgId());
			model.setBodId(getBodId());
			model.setScreenName(HtmlUtil.escape(getScreenName()));
			model.setEmailAddress(HtmlUtil.escape(getEmailAddress()));

			model = (LmisViewStaffRootOrg)Proxy.newProxyInstance(LmisViewStaffRootOrg.class.getClassLoader(),
					new Class[] { LmisViewStaffRootOrg.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		LmisViewStaffRootOrgClp clone = new LmisViewStaffRootOrgClp();

		clone.setUser_id(getUser_id());
		clone.setRootId(getRootId());
		clone.setOrgId(getOrgId());
		clone.setBodId(getBodId());
		clone.setScreenName(getScreenName());
		clone.setEmailAddress(getEmailAddress());

		return clone;
	}

	public int compareTo(LmisViewStaffRootOrg lmisViewStaffRootOrg) {
		Integer pk = lmisViewStaffRootOrg.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		LmisViewStaffRootOrgClp lmisViewStaffRootOrg = null;

		try {
			lmisViewStaffRootOrg = (LmisViewStaffRootOrgClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = lmisViewStaffRootOrg.getPrimaryKey();

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

		sb.append("{User_id=");
		sb.append(getUser_id());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", orgId=");
		sb.append(getOrgId());
		sb.append(", bodId=");
		sb.append(getBodId());
		sb.append(", screenName=");
		sb.append(getScreenName());
		sb.append(", emailAddress=");
		sb.append(getEmailAddress());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.lmis.model.LmisViewStaffRootOrg");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>User_id</column-name><column-value><![CDATA[");
		sb.append(getUser_id());
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
			"<column><column-name>screenName</column-name><column-value><![CDATA[");
		sb.append(getScreenName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailAddress</column-name><column-value><![CDATA[");
		sb.append(getEmailAddress());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _User_id;
	private int _rootId;
	private int _orgId;
	private int _bodId;
	private String _screenName;
	private String _emailAddress;
}