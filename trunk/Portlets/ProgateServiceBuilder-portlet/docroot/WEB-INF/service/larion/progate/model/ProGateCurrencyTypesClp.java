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

/**
 * <a href="ProGateCurrencyTypesClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateCurrencyTypesClp extends BaseModelImpl<ProGateCurrencyTypes>
	implements ProGateCurrencyTypes {
	public ProGateCurrencyTypesClp() {
	}

	public Integer getPrimaryKey() {
		return _currencyId;
	}

	public void setPrimaryKey(Integer pk) {
		setCurrencyId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _currencyId;
	}

	public Integer getCurrencyId() {
		return _currencyId;
	}

	public void setCurrencyId(Integer currencyId) {
		_currencyId = currencyId;
	}

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public ProGateCurrencyTypes toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			ProGateCurrencyTypes model = new ProGateCurrencyTypesClp();

			model.setEscapedModel(true);

			model.setCurrencyId(getCurrencyId());
			model.setCode(HtmlUtil.escape(getCode()));
			model.setDescription(HtmlUtil.escape(getDescription()));

			model = (ProGateCurrencyTypes)Proxy.newProxyInstance(ProGateCurrencyTypes.class.getClassLoader(),
					new Class[] { ProGateCurrencyTypes.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		ProGateCurrencyTypesClp clone = new ProGateCurrencyTypesClp();

		clone.setCurrencyId(getCurrencyId());
		clone.setCode(getCode());
		clone.setDescription(getDescription());

		return clone;
	}

	public int compareTo(ProGateCurrencyTypes proGateCurrencyTypes) {
		Integer pk = proGateCurrencyTypes.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ProGateCurrencyTypesClp proGateCurrencyTypes = null;

		try {
			proGateCurrencyTypes = (ProGateCurrencyTypesClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = proGateCurrencyTypes.getPrimaryKey();

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

		sb.append("{currencyId=");
		sb.append(getCurrencyId());
		sb.append(", code=");
		sb.append(getCode());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.model.ProGateCurrencyTypes");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>currencyId</column-name><column-value><![CDATA[");
		sb.append(getCurrencyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>code</column-name><column-value><![CDATA[");
		sb.append(getCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _currencyId;
	private String _code;
	private String _description;
}