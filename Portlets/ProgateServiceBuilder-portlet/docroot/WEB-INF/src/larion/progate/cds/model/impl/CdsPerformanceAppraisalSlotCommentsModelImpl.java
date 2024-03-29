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

package larion.progate.cds.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import larion.progate.cds.model.CdsPerformanceAppraisalSlotComments;
import larion.progate.cds.model.CdsPerformanceAppraisalSlotCommentsSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="CdsPerformanceAppraisalSlotCommentsModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsPerformanceAppraisalSlotCommentsModelImpl extends BaseModelImpl<CdsPerformanceAppraisalSlotComments> {
	public static final String TABLE_NAME = "cds_performance_appraisal_slot_comments";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "pa_id", new Integer(Types.INTEGER) },
			

			{ "root_id", new Integer(Types.INTEGER) },
			

			{ "period_id", new Integer(Types.INTEGER) },
			

			{ "user_id", new Integer(Types.INTEGER) },
			

			{ "slot_id", new Integer(Types.INTEGER) },
			

			{ "comment_by", new Integer(Types.INTEGER) },
			

			{ "comment_at", new Integer(Types.TIMESTAMP) },
			

			{ "comment_content", new Integer(Types.VARCHAR) }
		};
	public static final String TABLE_SQL_CREATE = "create table cds_performance_appraisal_slot_comments (id INTEGER not null primary key,pa_id INTEGER,root_id INTEGER,period_id INTEGER,user_id INTEGER,slot_id INTEGER,comment_by INTEGER,comment_at DATE null,comment_content VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table cds_performance_appraisal_slot_comments";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.cds.model.CdsPerformanceAppraisalSlotComments"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.cds.model.CdsPerformanceAppraisalSlotComments"),
			false);

	public static CdsPerformanceAppraisalSlotComments toModel(
		CdsPerformanceAppraisalSlotCommentsSoap soapModel) {
		CdsPerformanceAppraisalSlotComments model = new CdsPerformanceAppraisalSlotCommentsImpl();

		model.setCdsPerformanceAppraisalSlotCommentsId(soapModel.getCdsPerformanceAppraisalSlotCommentsId());
		model.setPaId(soapModel.getPaId());
		model.setRootId(soapModel.getRootId());
		model.setPeriodId(soapModel.getPeriodId());
		model.setUserId(soapModel.getUserId());
		model.setSlotId(soapModel.getSlotId());
		model.setCommentBy(soapModel.getCommentBy());
		model.setCommentAt(soapModel.getCommentAt());
		model.setCommentContent(soapModel.getCommentContent());

		return model;
	}

	public static List<CdsPerformanceAppraisalSlotComments> toModels(
		CdsPerformanceAppraisalSlotCommentsSoap[] soapModels) {
		List<CdsPerformanceAppraisalSlotComments> models = new ArrayList<CdsPerformanceAppraisalSlotComments>(soapModels.length);

		for (CdsPerformanceAppraisalSlotCommentsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.cds.model.CdsPerformanceAppraisalSlotComments"));

	public CdsPerformanceAppraisalSlotCommentsModelImpl() {
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
		return GetterUtil.getString(_commentContent);
	}

	public void setCommentContent(String commentContent) {
		_commentContent = commentContent;
	}

	public CdsPerformanceAppraisalSlotComments toEscapedModel() {
		if (isEscapedModel()) {
			return (CdsPerformanceAppraisalSlotComments)this;
		}
		else {
			CdsPerformanceAppraisalSlotComments model = new CdsPerformanceAppraisalSlotCommentsImpl();

			model.setNew(isNew());
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
		CdsPerformanceAppraisalSlotCommentsImpl clone = new CdsPerformanceAppraisalSlotCommentsImpl();

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

		CdsPerformanceAppraisalSlotComments cdsPerformanceAppraisalSlotComments = null;

		try {
			cdsPerformanceAppraisalSlotComments = (CdsPerformanceAppraisalSlotComments)obj;
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