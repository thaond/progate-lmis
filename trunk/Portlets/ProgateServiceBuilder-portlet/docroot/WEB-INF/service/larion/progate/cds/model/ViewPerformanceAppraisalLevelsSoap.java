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
 * <a href="ViewPerformanceAppraisalLevelsSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ViewPerformanceAppraisalLevelsSoap implements Serializable {
	public static ViewPerformanceAppraisalLevelsSoap toSoapModel(
		ViewPerformanceAppraisalLevels model) {
		ViewPerformanceAppraisalLevelsSoap soapModel = new ViewPerformanceAppraisalLevelsSoap();

		soapModel.setId(model.getId());
		soapModel.setLevelId(model.getLevelId());
		soapModel.setNumberOrder(model.getNumberOrder());
		soapModel.setCompetencyId(model.getCompetencyId());
		soapModel.setRootId(model.getRootId());
		soapModel.setLevelName(model.getLevelName());
		soapModel.setPaId(model.getPaId());
		soapModel.setUserId(model.getUserId());
		soapModel.setPeriodId(model.getPeriodId());
		soapModel.setTotalLevelPoint(model.getTotalLevelPoint());
		soapModel.setIsPassed(model.getIsPassed());

		return soapModel;
	}

	public static ViewPerformanceAppraisalLevelsSoap[] toSoapModels(
		ViewPerformanceAppraisalLevels[] models) {
		ViewPerformanceAppraisalLevelsSoap[] soapModels = new ViewPerformanceAppraisalLevelsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ViewPerformanceAppraisalLevelsSoap[][] toSoapModels(
		ViewPerformanceAppraisalLevels[][] models) {
		ViewPerformanceAppraisalLevelsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ViewPerformanceAppraisalLevelsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ViewPerformanceAppraisalLevelsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ViewPerformanceAppraisalLevelsSoap[] toSoapModels(
		List<ViewPerformanceAppraisalLevels> models) {
		List<ViewPerformanceAppraisalLevelsSoap> soapModels = new ArrayList<ViewPerformanceAppraisalLevelsSoap>(models.size());

		for (ViewPerformanceAppraisalLevels model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ViewPerformanceAppraisalLevelsSoap[soapModels.size()]);
	}

	public ViewPerformanceAppraisalLevelsSoap() {
	}

	public String getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(String pk) {
		setId(pk);
	}

	public String getId() {
		return _id;
	}

	public void setId(String id) {
		_id = id;
	}

	public int getLevelId() {
		return _levelId;
	}

	public void setLevelId(int levelId) {
		_levelId = levelId;
	}

	public int getNumberOrder() {
		return _numberOrder;
	}

	public void setNumberOrder(int numberOrder) {
		_numberOrder = numberOrder;
	}

	public int getCompetencyId() {
		return _competencyId;
	}

	public void setCompetencyId(int competencyId) {
		_competencyId = competencyId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public String getLevelName() {
		return _levelName;
	}

	public void setLevelName(String levelName) {
		_levelName = levelName;
	}

	public int getPaId() {
		return _paId;
	}

	public void setPaId(int paId) {
		_paId = paId;
	}

	public int getUserId() {
		return _userId;
	}

	public void setUserId(int userId) {
		_userId = userId;
	}

	public int getPeriodId() {
		return _periodId;
	}

	public void setPeriodId(int periodId) {
		_periodId = periodId;
	}

	public int getTotalLevelPoint() {
		return _totalLevelPoint;
	}

	public void setTotalLevelPoint(int totalLevelPoint) {
		_totalLevelPoint = totalLevelPoint;
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

	private String _id;
	private int _levelId;
	private int _numberOrder;
	private int _competencyId;
	private int _rootId;
	private String _levelName;
	private int _paId;
	private int _userId;
	private int _periodId;
	private int _totalLevelPoint;
	private boolean _isPassed;
}