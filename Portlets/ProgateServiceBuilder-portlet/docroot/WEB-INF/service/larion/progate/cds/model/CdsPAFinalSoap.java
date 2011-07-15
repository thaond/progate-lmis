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
import java.util.List;

/**
 * <a href="CdsPAFinalSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsPAFinalSoap implements Serializable {
	public static CdsPAFinalSoap toSoapModel(CdsPAFinal model) {
		CdsPAFinalSoap soapModel = new CdsPAFinalSoap();

		soapModel.setCdsPAFinalId(model.getCdsPAFinalId());
		soapModel.setRootId(model.getRootId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCdsTitleId(model.getCdsTitleId());

		return soapModel;
	}

	public static CdsPAFinalSoap[] toSoapModels(CdsPAFinal[] models) {
		CdsPAFinalSoap[] soapModels = new CdsPAFinalSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CdsPAFinalSoap[][] toSoapModels(CdsPAFinal[][] models) {
		CdsPAFinalSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CdsPAFinalSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CdsPAFinalSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CdsPAFinalSoap[] toSoapModels(List<CdsPAFinal> models) {
		List<CdsPAFinalSoap> soapModels = new ArrayList<CdsPAFinalSoap>(models.size());

		for (CdsPAFinal model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CdsPAFinalSoap[soapModels.size()]);
	}

	public CdsPAFinalSoap() {
	}

	public Integer getPrimaryKey() {
		return _cdsPAFinalId;
	}

	public void setPrimaryKey(Integer pk) {
		setCdsPAFinalId(pk);
	}

	public Integer getCdsPAFinalId() {
		return _cdsPAFinalId;
	}

	public void setCdsPAFinalId(Integer cdsPAFinalId) {
		_cdsPAFinalId = cdsPAFinalId;
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

	public int getCdsTitleId() {
		return _cdsTitleId;
	}

	public void setCdsTitleId(int cdsTitleId) {
		_cdsTitleId = cdsTitleId;
	}

	private Integer _cdsPAFinalId;
	private int _rootId;
	private int _userId;
	private int _cdsTitleId;
}