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
 * <a href="CdsTitleCompetenciesSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsTitleCompetenciesSoap implements Serializable {
	public static CdsTitleCompetenciesSoap toSoapModel(
		CdsTitleCompetencies model) {
		CdsTitleCompetenciesSoap soapModel = new CdsTitleCompetenciesSoap();

		soapModel.setCdsTitleCompetenciesId(model.getCdsTitleCompetenciesId());
		soapModel.setCdsTitleId(model.getCdsTitleId());
		soapModel.setCompetencyId(model.getCompetencyId());
		soapModel.setPointHash(model.getPointHash());
		soapModel.setPointValue(model.getPointValue());

		return soapModel;
	}

	public static CdsTitleCompetenciesSoap[] toSoapModels(
		CdsTitleCompetencies[] models) {
		CdsTitleCompetenciesSoap[] soapModels = new CdsTitleCompetenciesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CdsTitleCompetenciesSoap[][] toSoapModels(
		CdsTitleCompetencies[][] models) {
		CdsTitleCompetenciesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CdsTitleCompetenciesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CdsTitleCompetenciesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CdsTitleCompetenciesSoap[] toSoapModels(
		List<CdsTitleCompetencies> models) {
		List<CdsTitleCompetenciesSoap> soapModels = new ArrayList<CdsTitleCompetenciesSoap>(models.size());

		for (CdsTitleCompetencies model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CdsTitleCompetenciesSoap[soapModels.size()]);
	}

	public CdsTitleCompetenciesSoap() {
	}

	public Integer getPrimaryKey() {
		return _CdsTitleCompetenciesId;
	}

	public void setPrimaryKey(Integer pk) {
		setCdsTitleCompetenciesId(pk);
	}

	public Integer getCdsTitleCompetenciesId() {
		return _CdsTitleCompetenciesId;
	}

	public void setCdsTitleCompetenciesId(Integer CdsTitleCompetenciesId) {
		_CdsTitleCompetenciesId = CdsTitleCompetenciesId;
	}

	public int getCdsTitleId() {
		return _cdsTitleId;
	}

	public void setCdsTitleId(int cdsTitleId) {
		_cdsTitleId = cdsTitleId;
	}

	public int getCompetencyId() {
		return _competencyId;
	}

	public void setCompetencyId(int competencyId) {
		_competencyId = competencyId;
	}

	public int getPointHash() {
		return _pointHash;
	}

	public void setPointHash(int pointHash) {
		_pointHash = pointHash;
	}

	public String getPointValue() {
		return _pointValue;
	}

	public void setPointValue(String pointValue) {
		_pointValue = pointValue;
	}

	private Integer _CdsTitleCompetenciesId;
	private int _cdsTitleId;
	private int _competencyId;
	private int _pointHash;
	private String _pointValue;
}