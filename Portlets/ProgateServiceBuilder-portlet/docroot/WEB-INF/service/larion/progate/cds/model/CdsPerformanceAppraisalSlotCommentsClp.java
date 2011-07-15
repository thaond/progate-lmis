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

import java.util.Date;

/**
 * <a href="CdsPerformanceAppraisalSlotCommentsClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsPerformanceAppraisalSlotCommentsClp extends BaseModelImpl<CdsPerformanceAppraisalSlotComments>
	implements CdsPerformanceAppraisalSlotComments {
	public CdsPerformanceAppraisalSlotCommentsClp() {
	}

	public Integer getPrimaryKey() {
		return _CdsPerformanceAppraisalSlotCommentsId;
	}

	public void setPrimaryKey(Integer pk) {
		setCdsPerformanceAppraisalSlotCommentsId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _CdsPerformanceAppraisalSlotCommentsId;
	}

	public Integer getCdsPerformanceAppraisalSlotCommentsId() {
		return _CdsPerformanceAppraisalSlotCommentsId;
	}

	public void setCdsPerformanceAppraisalSlotCommentsId(
		Integer CdsPerformanceAppraisalSlotCommentsId) {
		_CdsPerformanceAppraisalSlotCommentsId = CdsPerformanceAppraisalSlotCommentsId;
	}

	public int getPaId() {
		return _paId;
	}

	public void setPaId(int paId) {
		_paId = paId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public int getPeriodId() {
		return _periodId;
	}

	public void setPeriodId(int periodId) {
		_periodId = periodId;
	}

	public int getUserId() {
		return _userId;
	}

	public void setUserId(int userId) {
		_userId = userId;
	}

	public int getSlotId() {
		return _slotId;
	}

	public void setSlotId(int slotId) {
		_slotId = slotId;
	}

	public int getCommentBy() {
		return _commentBy;
	}

	public void setCommentBy(int commentBy) {
		_commentBy = commentBy;
	}

	public Date getCommentAt() {
		return _commentAt;
	}

	public void setCommentAt(Date commentAt) {
		_commentAt = commentAt;
	}

	public String getCommentContent() {
		return _commentContent;
	}

	public void setCommentContent(String commentContent) {
		_commentContent = commentContent;
	}

	public CdsPerformanceAppraisalSlotComments toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			CdsPerformanceAppraisalSlotComments model = new CdsPerformanceAppraisalSlotCommentsClp();

			model.setEscapedModel(true);

			model.setCdsPerformanceAppraisalSlotCommentsId(getCdsPerformanceAppraisalSlotCommentsId());
			model.setPaId(getPaId());
			model.setRootId(getRootId());
			model.setPeriodId(getPeriodId());
			model.setUserId(getUserId());
			model.setSlotId(getSlotId());
			model.setCommentBy(getCommentBy());
			model.setCommentAt(getCommentAt());
			model.setCommentContent(HtmlUtil.escape(getCommentContent()));

			model = (CdsPerformanceAppraisalSlotComments)Proxy.newProxyInstance(CdsPerformanceAppraisalSlotComments.class.getClassLoader(),
					new Class[] { CdsPerformanceAppraisalSlotComments.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		CdsPerformanceAppraisalSlotCommentsClp clone = new CdsPerformanceAppraisalSlotCommentsClp();

		clone.setCdsPerformanceAppraisalSlotCommentsId(getCdsPerformanceAppraisalSlotCommentsId());
		clone.setPaId(getPaId());
		clone.setRootId(getRootId());
		clone.setPeriodId(getPeriodId());
		clone.setUserId(getUserId());
		clone.setSlotId(getSlotId());
		clone.setCommentBy(getCommentBy());
		clone.setCommentAt(getCommentAt());
		clone.setCommentContent(getCommentContent());

		return clone;
	}

	public int compareTo(
		CdsPerformanceAppraisalSlotComments cdsPerformanceAppraisalSlotComments) {
		Integer pk = cdsPerformanceAppraisalSlotComments.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		CdsPerformanceAppraisalSlotCommentsClp cdsPerformanceAppraisalSlotComments =
			null;

		try {
			cdsPerformanceAppraisalSlotComments = (CdsPerformanceAppraisalSlotCommentsClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = cdsPerformanceAppraisalSlotComments.getPrimaryKey();

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

		sb.append("{CdsPerformanceAppraisalSlotCommentsId=");
		sb.append(getCdsPerformanceAppraisalSlotCommentsId());
		sb.append(", paId=");
		sb.append(getPaId());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", periodId=");
		sb.append(getPeriodId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", slotId=");
		sb.append(getSlotId());
		sb.append(", commentBy=");
		sb.append(getCommentBy());
		sb.append(", commentAt=");
		sb.append(getCommentAt());
		sb.append(", commentContent=");
		sb.append(getCommentContent());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append(
			"larion.progate.cds.model.CdsPerformanceAppraisalSlotComments");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>CdsPerformanceAppraisalSlotCommentsId</column-name><column-value><![CDATA[");
		sb.append(getCdsPerformanceAppraisalSlotCommentsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>paId</column-name><column-value><![CDATA[");
		sb.append(getPaId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rootId</column-name><column-value><![CDATA[");
		sb.append(getRootId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>periodId</column-name><column-value><![CDATA[");
		sb.append(getPeriodId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>slotId</column-name><column-value><![CDATA[");
		sb.append(getSlotId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>commentBy</column-name><column-value><![CDATA[");
		sb.append(getCommentBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>commentAt</column-name><column-value><![CDATA[");
		sb.append(getCommentAt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>commentContent</column-name><column-value><![CDATA[");
		sb.append(getCommentContent());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _CdsPerformanceAppraisalSlotCommentsId;
	private int _paId;
	private int _rootId;
	private int _periodId;
	private int _userId;
	private int _slotId;
	private int _commentBy;
	private Date _commentAt;
	private String _commentContent;
}