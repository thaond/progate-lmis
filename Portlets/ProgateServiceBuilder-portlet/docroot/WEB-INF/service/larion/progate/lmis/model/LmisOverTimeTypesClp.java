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
 * <a href="LmisOverTimeTypesClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisOverTimeTypesClp extends BaseModelImpl<LmisOverTimeTypes>
	implements LmisOverTimeTypes {
	public LmisOverTimeTypesClp() {
	}

	public Integer getPrimaryKey() {
		return _lmisOverTimeTypesId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisOverTimeTypesId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _lmisOverTimeTypesId;
	}

	public Integer getLmisOverTimeTypesId() {
		return _lmisOverTimeTypesId;
	}

	public void setLmisOverTimeTypesId(Integer lmisOverTimeTypesId) {
		_lmisOverTimeTypesId = lmisOverTimeTypesId;
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

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public LmisOverTimeTypes toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			LmisOverTimeTypes model = new LmisOverTimeTypesClp();

			model.setEscapedModel(true);

			model.setLmisOverTimeTypesId(getLmisOverTimeTypesId());
			model.setRootId(getRootId());
			model.setName(HtmlUtil.escape(getName()));
			model.setDescription(HtmlUtil.escape(getDescription()));

			model = (LmisOverTimeTypes)Proxy.newProxyInstance(LmisOverTimeTypes.class.getClassLoader(),
					new Class[] { LmisOverTimeTypes.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		LmisOverTimeTypesClp clone = new LmisOverTimeTypesClp();

		clone.setLmisOverTimeTypesId(getLmisOverTimeTypesId());
		clone.setRootId(getRootId());
		clone.setName(getName());
		clone.setDescription(getDescription());

		return clone;
	}

	public int compareTo(LmisOverTimeTypes lmisOverTimeTypes) {
		Integer pk = lmisOverTimeTypes.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		LmisOverTimeTypesClp lmisOverTimeTypes = null;

		try {
			lmisOverTimeTypes = (LmisOverTimeTypesClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = lmisOverTimeTypes.getPrimaryKey();

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

		sb.append("{lmisOverTimeTypesId=");
		sb.append(getLmisOverTimeTypesId());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.lmis.model.LmisOverTimeTypes");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>lmisOverTimeTypesId</column-name><column-value><![CDATA[");
		sb.append(getLmisOverTimeTypesId());
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
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _lmisOverTimeTypesId;
	private int _rootId;
	private String _name;
	private String _description;
}