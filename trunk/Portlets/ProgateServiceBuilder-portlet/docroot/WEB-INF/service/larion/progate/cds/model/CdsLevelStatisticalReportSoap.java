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
 * <a href="CdsLevelStatisticalReportSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsLevelStatisticalReportSoap implements Serializable {
	public static CdsLevelStatisticalReportSoap toSoapModel(
		CdsLevelStatisticalReport model) {
		CdsLevelStatisticalReportSoap soapModel = new CdsLevelStatisticalReportSoap();

		soapModel.setLevelId(model.getLevelId());
		soapModel.setRootId(model.getRootId());
		soapModel.setCompetencyId(model.getCompetencyId());
		soapModel.setName(model.getName());
		soapModel.setPeriodId(model.getPeriodId());
		soapModel.setUserId(model.getUserId());
		soapModel.setTotalLevelPoint(model.getTotalLevelPoint());

		return soapModel;
	}

	public static CdsLevelStatisticalReportSoap[] toSoapModels(
		CdsLevelStatisticalReport[] models) {
		CdsLevelStatisticalReportSoap[] soapModels = new CdsLevelStatisticalReportSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CdsLevelStatisticalReportSoap[][] toSoapModels(
		CdsLevelStatisticalReport[][] models) {
		CdsLevelStatisticalReportSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CdsLevelStatisticalReportSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CdsLevelStatisticalReportSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CdsLevelStatisticalReportSoap[] toSoapModels(
		List<CdsLevelStatisticalReport> models) {
		List<CdsLevelStatisticalReportSoap> soapModels = new ArrayList<CdsLevelStatisticalReportSoap>(models.size());

		for (CdsLevelStatisticalReport model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CdsLevelStatisticalReportSoap[soapModels.size()]);
	}

	public CdsLevelStatisticalReportSoap() {
	}

	public Integer getPrimaryKey() {
		return _levelId;
	}

	public void setPrimaryKey(Integer pk) {
		setLevelId(pk);
	}

	public Integer getLevelId() {
		return _levelId;
	}

	public void setLevelId(Integer levelId) {
		_levelId = levelId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public int getCompetencyId() {
		return _competencyId;
	}

	public void setCompetencyId(int competencyId) {
		_competencyId = competencyId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
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

	public int getTotalLevelPoint() {
		return _totalLevelPoint;
	}

	public void setTotalLevelPoint(int totalLevelPoint) {
		_totalLevelPoint = totalLevelPoint;
	}

	private Integer _levelId;
	private int _rootId;
	private int _competencyId;
	private String _name;
	private int _periodId;
	private int _userId;
	private int _totalLevelPoint;
}