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
 * <a href="ViewSlotInformationSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ViewSlotInformationSoap implements Serializable {
	public static ViewSlotInformationSoap toSoapModel(ViewSlotInformation model) {
		ViewSlotInformationSoap soapModel = new ViewSlotInformationSoap();

		soapModel.setViewSlotInformationId(model.getViewSlotInformationId());
		soapModel.setRootId(model.getRootId());
		soapModel.setUserId(model.getUserId());
		soapModel.setSlotId(model.getSlotId());
		soapModel.setPointName(model.getPointName());
		soapModel.setMaxPointName(model.getMaxPointName());
		soapModel.setIsPassed(model.getIsPassed());
		soapModel.setPeriodName(model.getPeriodName());
		soapModel.setFromDate(model.getFromDate());
		soapModel.setToDate(model.getToDate());
		soapModel.setPmName(model.getPmName());
		soapModel.setOrgName(model.getOrgName());

		return soapModel;
	}

	public static ViewSlotInformationSoap[] toSoapModels(
		ViewSlotInformation[] models) {
		ViewSlotInformationSoap[] soapModels = new ViewSlotInformationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ViewSlotInformationSoap[][] toSoapModels(
		ViewSlotInformation[][] models) {
		ViewSlotInformationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ViewSlotInformationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ViewSlotInformationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ViewSlotInformationSoap[] toSoapModels(
		List<ViewSlotInformation> models) {
		List<ViewSlotInformationSoap> soapModels = new ArrayList<ViewSlotInformationSoap>(models.size());

		for (ViewSlotInformation model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ViewSlotInformationSoap[soapModels.size()]);
	}

	public ViewSlotInformationSoap() {
	}

	public Integer getPrimaryKey() {
		return _viewSlotInformationId;
	}

	public void setPrimaryKey(Integer pk) {
		setViewSlotInformationId(pk);
	}

	public Integer getViewSlotInformationId() {
		return _viewSlotInformationId;
	}

	public void setViewSlotInformationId(Integer viewSlotInformationId) {
		_viewSlotInformationId = viewSlotInformationId;
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

	public int getSlotId() {
		return _slotId;
	}

	public void setSlotId(int slotId) {
		_slotId = slotId;
	}

	public String getPointName() {
		return _pointName;
	}

	public void setPointName(String pointName) {
		_pointName = pointName;
	}

	public String getMaxPointName() {
		return _maxPointName;
	}

	public void setMaxPointName(String maxPointName) {
		_maxPointName = maxPointName;
	}

	public boolean getIsPassed() {
		return _isPassed;
	}

	public boolean isIsPassed() {
		return _isPassed;
	}

	public void setIsPassed(boolean isPassed) {
		_isPassed = isPassed;
	}

	public String getPeriodName() {
		return _periodName;
	}

	public void setPeriodName(String periodName) {
		_periodName = periodName;
	}

	public Date getFromDate() {
		return _fromDate;
	}

	public void setFromDate(Date fromDate) {
		_fromDate = fromDate;
	}

	public Date getToDate() {
		return _toDate;
	}

	public void setToDate(Date toDate) {
		_toDate = toDate;
	}

	public String getPmName() {
		return _pmName;
	}

	public void setPmName(String pmName) {
		_pmName = pmName;
	}

	public String getOrgName() {
		return _orgName;
	}

	public void setOrgName(String orgName) {
		_orgName = orgName;
	}

	private Integer _viewSlotInformationId;
	private int _rootId;
	private int _userId;
	private int _slotId;
	private String _pointName;
	private String _maxPointName;
	private boolean _isPassed;
	private String _periodName;
	private Date _fromDate;
	private Date _toDate;
	private String _pmName;
	private String _orgName;
}