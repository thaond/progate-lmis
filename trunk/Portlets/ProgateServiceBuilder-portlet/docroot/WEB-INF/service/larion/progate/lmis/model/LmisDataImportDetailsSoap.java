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
 * <a href="LmisDataImportDetailsSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisDataImportDetailsSoap implements Serializable {
	public static LmisDataImportDetailsSoap toSoapModel(
		LmisDataImportDetails model) {
		LmisDataImportDetailsSoap soapModel = new LmisDataImportDetailsSoap();

		soapModel.setLmisDataImportDetailsId(model.getLmisDataImportDetailsId());
		soapModel.setRootId(model.getRootId());
		soapModel.setImportId(model.getImportId());
		soapModel.setStartTime(model.getStartTime());
		soapModel.setEndTime(model.getEndTime());
		soapModel.setScannerId(model.getScannerId());
		soapModel.setAbSence(model.getAbSence());
		soapModel.setStaffName(model.getStaffName());

		return soapModel;
	}

	public static LmisDataImportDetailsSoap[] toSoapModels(
		LmisDataImportDetails[] models) {
		LmisDataImportDetailsSoap[] soapModels = new LmisDataImportDetailsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LmisDataImportDetailsSoap[][] toSoapModels(
		LmisDataImportDetails[][] models) {
		LmisDataImportDetailsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LmisDataImportDetailsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LmisDataImportDetailsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LmisDataImportDetailsSoap[] toSoapModels(
		List<LmisDataImportDetails> models) {
		List<LmisDataImportDetailsSoap> soapModels = new ArrayList<LmisDataImportDetailsSoap>(models.size());

		for (LmisDataImportDetails model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LmisDataImportDetailsSoap[soapModels.size()]);
	}

	public LmisDataImportDetailsSoap() {
	}

	public Integer getPrimaryKey() {
		return _lmisDataImportDetailsId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisDataImportDetailsId(pk);
	}

	public Integer getLmisDataImportDetailsId() {
		return _lmisDataImportDetailsId;
	}

	public void setLmisDataImportDetailsId(Integer lmisDataImportDetailsId) {
		_lmisDataImportDetailsId = lmisDataImportDetailsId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public int getImportId() {
		return _importId;
	}

	public void setImportId(int importId) {
		_importId = importId;
	}

	public Date getStartTime() {
		return _startTime;
	}

	public void setStartTime(Date startTime) {
		_startTime = startTime;
	}

	public Date getEndTime() {
		return _endTime;
	}

	public void setEndTime(Date endTime) {
		_endTime = endTime;
	}

	public String getScannerId() {
		return _scannerId;
	}

	public void setScannerId(String scannerId) {
		_scannerId = scannerId;
	}

	public int getAbSence() {
		return _abSence;
	}

	public void setAbSence(int abSence) {
		_abSence = abSence;
	}

	public String getStaffName() {
		return _staffName;
	}

	public void setStaffName(String staffName) {
		_staffName = staffName;
	}

	private Integer _lmisDataImportDetailsId;
	private int _rootId;
	private int _importId;
	private Date _startTime;
	private Date _endTime;
	private String _scannerId;
	private int _abSence;
	private String _staffName;
}