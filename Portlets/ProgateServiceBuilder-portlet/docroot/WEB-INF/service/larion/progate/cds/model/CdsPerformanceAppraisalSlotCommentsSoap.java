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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="CdsPerformanceAppraisalSlotCommentsSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsPerformanceAppraisalSlotCommentsSoap implements Serializable {
	public static CdsPerformanceAppraisalSlotCommentsSoap toSoapModel(
		CdsPerformanceAppraisalSlotComments model) {
		CdsPerformanceAppraisalSlotCommentsSoap soapModel = new CdsPerformanceAppraisalSlotCommentsSoap();

		soapModel.setCdsPerformanceAppraisalSlotCommentsId(model.getCdsPerformanceAppraisalSlotCommentsId());
		soapModel.setPaId(model.getPaId());
		soapModel.setRootId(model.getRootId());
		soapModel.setPeriodId(model.getPeriodId());
		soapModel.setUserId(model.getUserId());
		soapModel.setSlotId(model.getSlotId());
		soapModel.setCommentBy(model.getCommentBy());
		soapModel.setCommentAt(model.getCommentAt());
		soapModel.setCommentContent(model.getCommentContent());

		return soapModel;
	}

	public static CdsPerformanceAppraisalSlotCommentsSoap[] toSoapModels(
		CdsPerformanceAppraisalSlotComments[] models) {
		CdsPerformanceAppraisalSlotCommentsSoap[] soapModels = new CdsPerformanceAppraisalSlotCommentsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CdsPerformanceAppraisalSlotCommentsSoap[][] toSoapModels(
		CdsPerformanceAppraisalSlotComments[][] models) {
		CdsPerformanceAppraisalSlotCommentsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CdsPerformanceAppraisalSlotCommentsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CdsPerformanceAppraisalSlotCommentsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CdsPerformanceAppraisalSlotCommentsSoap[] toSoapModels(
		List<CdsPerformanceAppraisalSlotComments> models) {
		List<CdsPerformanceAppraisalSlotCommentsSoap> soapModels = new ArrayList<CdsPerformanceAppraisalSlotCommentsSoap>(models.size());

		for (CdsPerformanceAppraisalSlotComments model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CdsPerformanceAppraisalSlotCommentsSoap[soapModels.size()]);
	}

	public CdsPerformanceAppraisalSlotCommentsSoap() {
	}

	public Integer getPrimaryKey() {
		return _CdsPerformanceAppraisalSlotCommentsId;
	}

	public void setPrimaryKey(Integer pk) {
		setCdsPerformanceAppraisalSlotCommentsId(pk);
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