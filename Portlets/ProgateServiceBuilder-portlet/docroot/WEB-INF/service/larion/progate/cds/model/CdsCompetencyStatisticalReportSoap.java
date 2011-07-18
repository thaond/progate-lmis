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
 * <a href="CdsCompetencyStatisticalReportSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsCompetencyStatisticalReportSoap implements Serializable {
	public static CdsCompetencyStatisticalReportSoap toSoapModel(
		CdsCompetencyStatisticalReport model) {
		CdsCompetencyStatisticalReportSoap soapModel = new CdsCompetencyStatisticalReportSoap();

		soapModel.setCompetencyId(model.getCompetencyId());
		soapModel.setRootId(model.getRootId());
		soapModel.setName(model.getName());
		soapModel.setPeriodId(model.getPeriodId());
		soapModel.setUserId(model.getUserId());
		soapModel.setLevelRankingHash(model.getLevelRankingHash());
		soapModel.setLevelRankingValue(model.getLevelRankingValue());

		return soapModel;
	}

	public static CdsCompetencyStatisticalReportSoap[] toSoapModels(
		CdsCompetencyStatisticalReport[] models) {
		CdsCompetencyStatisticalReportSoap[] soapModels = new CdsCompetencyStatisticalReportSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CdsCompetencyStatisticalReportSoap[][] toSoapModels(
		CdsCompetencyStatisticalReport[][] models) {
		CdsCompetencyStatisticalReportSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CdsCompetencyStatisticalReportSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CdsCompetencyStatisticalReportSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CdsCompetencyStatisticalReportSoap[] toSoapModels(
		List<CdsCompetencyStatisticalReport> models) {
		List<CdsCompetencyStatisticalReportSoap> soapModels = new ArrayList<CdsCompetencyStatisticalReportSoap>(models.size());

		for (CdsCompetencyStatisticalReport model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CdsCompetencyStatisticalReportSoap[soapModels.size()]);
	}

	public CdsCompetencyStatisticalReportSoap() {
	}

	public Integer getPrimaryKey() {
		return _competencyId;
	}

	public void setPrimaryKey(Integer pk) {
		setCompetencyId(pk);
	}

	public Integer getCompetencyId() {
		return _competencyId;
	}

	public void setCompetencyId(Integer competencyId) {
		_competencyId = competencyId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
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

	public int getLevelRankingHash() {
		return _levelRankingHash;
	}

	public void setLevelRankingHash(int levelRankingHash) {
		_levelRankingHash = levelRankingHash;
	}

	public String getLevelRankingValue() {
		return _levelRankingValue;
	}

	public void setLevelRankingValue(String levelRankingValue) {
		_levelRankingValue = levelRankingValue;
	}

	private Integer _competencyId;
	private int _rootId;
	private String _name;
	private int _periodId;
	private int _userId;
	private int _levelRankingHash;
	private String _levelRankingValue;
}