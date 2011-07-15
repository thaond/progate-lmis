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

package larion.progate.cds.model;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * <a href="ViewFinalTitlesClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ViewFinalTitlesClp extends BaseModelImpl<ViewFinalTitles>
	implements ViewFinalTitles {
	public ViewFinalTitlesClp() {
	}

	public Integer getPrimaryKey() {
		return _ViewFinalTitlesId;
	}

	public void setPrimaryKey(Integer pk) {
		setViewFinalTitlesId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _ViewFinalTitlesId;
	}

	public Integer getViewFinalTitlesId() {
		return _ViewFinalTitlesId;
	}

	public void setViewFinalTitlesId(Integer ViewFinalTitlesId) {
		_ViewFinalTitlesId = ViewFinalTitlesId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public int getUserId() {
		return _userId;
	}

	public void setUserId(int userId) {
		_userId = userId;
	}

	public int getTitleId() {
		return _titleId;
	}

	public void setTitleId(int titleId) {
		_titleId = titleId;
	}

	public String getTitleName() {
		return _titleName;
	}

	public void setTitleName(String titleName) {
		_titleName = titleName;
	}

	public ViewFinalTitles toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			ViewFinalTitles model = new ViewFinalTitlesClp();

			model.setEscapedModel(true);

			model.setViewFinalTitlesId(getViewFinalTitlesId());
			model.setRootId(getRootId());
			model.setUserId(getUserId());
			model.setTitleId(getTitleId());
			model.setTitleName(HtmlUtil.escape(getTitleName()));

			model = (ViewFinalTitles)Proxy.newProxyInstance(ViewFinalTitles.class.getClassLoader(),
					new Class[] { ViewFinalTitles.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		ViewFinalTitlesClp clone = new ViewFinalTitlesClp();

		clone.setViewFinalTitlesId(getViewFinalTitlesId());
		clone.setRootId(getRootId());
		clone.setUserId(getUserId());
		clone.setTitleId(getTitleId());
		clone.setTitleName(getTitleName());

		return clone;
	}

	public int compareTo(ViewFinalTitles viewFinalTitles) {
		Integer pk = viewFinalTitles.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ViewFinalTitlesClp viewFinalTitles = null;

		try {
			viewFinalTitles = (ViewFinalTitlesClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = viewFinalTitles.getPrimaryKey();

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

		sb.append("{ViewFinalTitlesId=");
		sb.append(getViewFinalTitlesId());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", titleId=");
		sb.append(getTitleId());
		sb.append(", titleName=");
		sb.append(getTitleName());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.cds.model.ViewFinalTitles");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ViewFinalTitlesId</column-name><column-value><![CDATA[");
		sb.append(getViewFinalTitlesId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rootId</column-name><column-value><![CDATA[");
		sb.append(getRootId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>titleId</column-name><column-value><![CDATA[");
		sb.append(getTitleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>titleName</column-name><column-value><![CDATA[");
		sb.append(getTitleName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _ViewFinalTitlesId;
	private int _rootId;
	private int _userId;
	private int _titleId;
	private String _titleName;
}