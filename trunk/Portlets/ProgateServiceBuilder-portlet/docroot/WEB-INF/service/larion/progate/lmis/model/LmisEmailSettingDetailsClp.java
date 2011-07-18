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
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * <a href="LmisEmailSettingDetailsClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisEmailSettingDetailsClp extends BaseModelImpl<LmisEmailSettingDetails>
	implements LmisEmailSettingDetails {
	public LmisEmailSettingDetailsClp() {
	}

	public Integer getPrimaryKey() {
		return _lmisEmailSettingDetailId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisEmailSettingDetailId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _lmisEmailSettingDetailId;
	}

	public Integer getLmisEmailSettingDetailId() {
		return _lmisEmailSettingDetailId;
	}

	public void setLmisEmailSettingDetailId(Integer lmisEmailSettingDetailId) {
		_lmisEmailSettingDetailId = lmisEmailSettingDetailId;
	}

	public int getEmailSettingId() {
		return _emailSettingId;
	}

	public void setEmailSettingId(int emailSettingId) {
		_emailSettingId = emailSettingId;
	}

	public int getOrgRelatedId() {
		return _orgRelatedId;
	}

	public void setOrgRelatedId(int orgRelatedId) {
		_orgRelatedId = orgRelatedId;
	}

	public int getUserRelatedId() {
		return _userRelatedId;
	}

	public void setUserRelatedId(int userRelatedId) {
		_userRelatedId = userRelatedId;
	}

	public LmisEmailSettingDetails toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			LmisEmailSettingDetails model = new LmisEmailSettingDetailsClp();

			model.setEscapedModel(true);

			model.setLmisEmailSettingDetailId(getLmisEmailSettingDetailId());
			model.setEmailSettingId(getEmailSettingId());
			model.setOrgRelatedId(getOrgRelatedId());
			model.setUserRelatedId(getUserRelatedId());

			model = (LmisEmailSettingDetails)Proxy.newProxyInstance(LmisEmailSettingDetails.class.getClassLoader(),
					new Class[] { LmisEmailSettingDetails.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		LmisEmailSettingDetailsClp clone = new LmisEmailSettingDetailsClp();

		clone.setLmisEmailSettingDetailId(getLmisEmailSettingDetailId());
		clone.setEmailSettingId(getEmailSettingId());
		clone.setOrgRelatedId(getOrgRelatedId());
		clone.setUserRelatedId(getUserRelatedId());

		return clone;
	}

	public int compareTo(LmisEmailSettingDetails lmisEmailSettingDetails) {
		Integer pk = lmisEmailSettingDetails.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		LmisEmailSettingDetailsClp lmisEmailSettingDetails = null;

		try {
			lmisEmailSettingDetails = (LmisEmailSettingDetailsClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = lmisEmailSettingDetails.getPrimaryKey();

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

		sb.append("{lmisEmailSettingDetailId=");
		sb.append(getLmisEmailSettingDetailId());
		sb.append(", emailSettingId=");
		sb.append(getEmailSettingId());
		sb.append(", orgRelatedId=");
		sb.append(getOrgRelatedId());
		sb.append(", userRelatedId=");
		sb.append(getUserRelatedId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.lmis.model.LmisEmailSettingDetails");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>lmisEmailSettingDetailId</column-name><column-value><![CDATA[");
		sb.append(getLmisEmailSettingDetailId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailSettingId</column-name><column-value><![CDATA[");
		sb.append(getEmailSettingId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orgRelatedId</column-name><column-value><![CDATA[");
		sb.append(getOrgRelatedId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userRelatedId</column-name><column-value><![CDATA[");
		sb.append(getUserRelatedId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _lmisEmailSettingDetailId;
	private int _emailSettingId;
	private int _orgRelatedId;
	private int _userRelatedId;
}