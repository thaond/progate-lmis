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
 * <a href="CdsCdpSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsCdpSoap implements Serializable {
	public static CdsCdpSoap toSoapModel(CdsCdp model) {
		CdsCdpSoap soapModel = new CdsCdpSoap();

		soapModel.setCdsCdpId(model.getCdsCdpId());
		soapModel.setRootId(model.getRootId());
		soapModel.setPeriodId(model.getPeriodId());
		soapModel.setUserId(model.getUserId());
		soapModel.setWrittenBy(model.getWrittenBy());
		soapModel.setWrittenAt(model.getWrittenAt());
		soapModel.setWrittenContent(model.getWrittenContent());

		return soapModel;
	}

	public static CdsCdpSoap[] toSoapModels(CdsCdp[] models) {
		CdsCdpSoap[] soapModels = new CdsCdpSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CdsCdpSoap[][] toSoapModels(CdsCdp[][] models) {
		CdsCdpSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CdsCdpSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CdsCdpSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CdsCdpSoap[] toSoapModels(List<CdsCdp> models) {
		List<CdsCdpSoap> soapModels = new ArrayList<CdsCdpSoap>(models.size());

		for (CdsCdp model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CdsCdpSoap[soapModels.size()]);
	}

	public CdsCdpSoap() {
	}

	public Integer getPrimaryKey() {
		return _CdsCdpId;
	}

	public void setPrimaryKey(Integer pk) {
		setCdsCdpId(pk);
	}

	public Integer getCdsCdpId() {
		return _CdsCdpId;
	}

	public void setCdsCdpId(Integer CdsCdpId) {
		_CdsCdpId = CdsCdpId;
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

	public int getWrittenBy() {
		return _writtenBy;
	}

	public void setWrittenBy(int writtenBy) {
		_writtenBy = writtenBy;
	}

	public Date getWrittenAt() {
		return _writtenAt;
	}

	public void setWrittenAt(Date writtenAt) {
		_writtenAt = writtenAt;
	}

	public String getWrittenContent() {
		return _writtenContent;
	}

	public void setWrittenContent(String writtenContent) {
		_writtenContent = writtenContent;
	}

	private Integer _CdsCdpId;
	private int _rootId;
	private int _periodId;
	private int _userId;
	private int _writtenBy;
	private Date _writtenAt;
	private String _writtenContent;
}