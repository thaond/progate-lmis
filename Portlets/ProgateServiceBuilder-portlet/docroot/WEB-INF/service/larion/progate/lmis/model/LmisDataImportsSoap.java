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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="LmisDataImportsSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisDataImportsSoap implements Serializable {
	public static LmisDataImportsSoap toSoapModel(LmisDataImports model) {
		LmisDataImportsSoap soapModel = new LmisDataImportsSoap();

		soapModel.setLmisDataImportsId(model.getLmisDataImportsId());
		soapModel.setRootId(model.getRootId());
		soapModel.setDateValue(model.getDateValue());
		soapModel.setImportType(model.getImportType());
		soapModel.setImportBy(model.getImportBy());
		soapModel.setImportAt(model.getImportAt());
		soapModel.setSessionId(model.getSessionId());

		return soapModel;
	}

	public static LmisDataImportsSoap[] toSoapModels(LmisDataImports[] models) {
		LmisDataImportsSoap[] soapModels = new LmisDataImportsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LmisDataImportsSoap[][] toSoapModels(
		LmisDataImports[][] models) {
		LmisDataImportsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LmisDataImportsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LmisDataImportsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LmisDataImportsSoap[] toSoapModels(
		List<LmisDataImports> models) {
		List<LmisDataImportsSoap> soapModels = new ArrayList<LmisDataImportsSoap>(models.size());

		for (LmisDataImports model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LmisDataImportsSoap[soapModels.size()]);
	}

	public LmisDataImportsSoap() {
	}

	public Integer getPrimaryKey() {
		return _lmisDataImportsId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisDataImportsId(pk);
	}

	public Integer getLmisDataImportsId() {
		return _lmisDataImportsId;
	}

	public void setLmisDataImportsId(Integer lmisDataImportsId) {
		_lmisDataImportsId = lmisDataImportsId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public Date getDateValue() {
		return _dateValue;
	}

	public void setDateValue(Date dateValue) {
		_dateValue = dateValue;
	}

	public int getImportType() {
		return _importType;
	}

	public void setImportType(int importType) {
		_importType = importType;
	}

	public int getImportBy() {
		return _importBy;
	}

	public void setImportBy(int importBy) {
		_importBy = importBy;
	}

	public Date getImportAt() {
		return _importAt;
	}

	public void setImportAt(Date importAt) {
		_importAt = importAt;
	}

	public int getSessionId() {
		return _sessionId;
	}

	public void setSessionId(int sessionId) {
		_sessionId = sessionId;
	}

	private Integer _lmisDataImportsId;
	private int _rootId;
	private Date _dateValue;
	private int _importType;
	private int _importBy;
	private Date _importAt;
	private int _sessionId;
}