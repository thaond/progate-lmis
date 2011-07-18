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
 * <a href="CdsPerformanceAppraisalsSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsPerformanceAppraisalsSoap implements Serializable {
	public static CdsPerformanceAppraisalsSoap toSoapModel(
		CdsPerformanceAppraisals model) {
		CdsPerformanceAppraisalsSoap soapModel = new CdsPerformanceAppraisalsSoap();

		soapModel.setCdsPerformanceAppraisalsId(model.getCdsPerformanceAppraisalsId());
		soapModel.setRootId(model.getRootId());
		soapModel.setPeriodId(model.getPeriodId());
		soapModel.setUserId(model.getUserId());
		soapModel.setTitleId(model.getTitleId());
		soapModel.setRatingStatus(model.getRatingStatus());
		soapModel.setRatingStatusPm(model.getRatingStatusPm());
		soapModel.setRatingStatusBod(model.getRatingStatusBod());
		soapModel.setIsLocked(model.getIsLocked());
		soapModel.setPmList(model.getPmList());
		soapModel.setOrgList(model.getOrgList());
		soapModel.setBodList(model.getBodList());
		soapModel.setIsTitleUp(model.getIsTitleUp());

		return soapModel;
	}

	public static CdsPerformanceAppraisalsSoap[] toSoapModels(
		CdsPerformanceAppraisals[] models) {
		CdsPerformanceAppraisalsSoap[] soapModels = new CdsPerformanceAppraisalsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CdsPerformanceAppraisalsSoap[][] toSoapModels(
		CdsPerformanceAppraisals[][] models) {
		CdsPerformanceAppraisalsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CdsPerformanceAppraisalsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CdsPerformanceAppraisalsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CdsPerformanceAppraisalsSoap[] toSoapModels(
		List<CdsPerformanceAppraisals> models) {
		List<CdsPerformanceAppraisalsSoap> soapModels = new ArrayList<CdsPerformanceAppraisalsSoap>(models.size());

		for (CdsPerformanceAppraisals model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CdsPerformanceAppraisalsSoap[soapModels.size()]);
	}

	public CdsPerformanceAppraisalsSoap() {
	}

	public Integer getPrimaryKey() {
		return _cdsPerformanceAppraisalsId;
	}

	public void setPrimaryKey(Integer pk) {
		setCdsPerformanceAppraisalsId(pk);
	}

	public Integer getCdsPerformanceAppraisalsId() {
		return _cdsPerformanceAppraisalsId;
	}

	public void setCdsPerformanceAppraisalsId(
		Integer cdsPerformanceAppraisalsId) {
		_cdsPerformanceAppraisalsId = cdsPerformanceAppraisalsId;
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

	public int getTitleId() {
		return _titleId;
	}

	public void setTitleId(int titleId) {
		_titleId = titleId;
	}

	public int getRatingStatus() {
		return _ratingStatus;
	}

	public void setRatingStatus(int ratingStatus) {
		_ratingStatus = ratingStatus;
	}

	public int getRatingStatusPm() {
		return _ratingStatusPm;
	}

	public void setRatingStatusPm(int ratingStatusPm) {
		_ratingStatusPm = ratingStatusPm;
	}

	public int getRatingStatusBod() {
		return _ratingStatusBod;
	}

	public void setRatingStatusBod(int ratingStatusBod) {
		_ratingStatusBod = ratingStatusBod;
	}

	public boolean getIsLocked() {
		return _isLocked;
	}

	public boolean isIsLocked() {
		return _isLocked;
	}

	public void setIsLocked(boolean isLocked) {
		_isLocked = isLocked;
	}

	public String getPmList() {
		return _pmList;
	}

	public void setPmList(String pmList) {
		_pmList = pmList;
	}

	public String getOrgList() {
		return _orgList;
	}

	public void setOrgList(String orgList) {
		_orgList = orgList;
	}

	public String getBodList() {
		return _bodList;
	}

	public void setBodList(String bodList) {
		_bodList = bodList;
	}

	public boolean getIsTitleUp() {
		return _isTitleUp;
	}

	public boolean isIsTitleUp() {
		return _isTitleUp;
	}

	public void setIsTitleUp(boolean isTitleUp) {
		_isTitleUp = isTitleUp;
	}

	private Integer _cdsPerformanceAppraisalsId;
	private int _rootId;
	private int _periodId;
	private int _userId;
	private int _titleId;
	private int _ratingStatus;
	private int _ratingStatusPm;
	private int _ratingStatusBod;
	private boolean _isLocked;
	private String _pmList;
	private String _orgList;
	private String _bodList;
	private boolean _isTitleUp;
}