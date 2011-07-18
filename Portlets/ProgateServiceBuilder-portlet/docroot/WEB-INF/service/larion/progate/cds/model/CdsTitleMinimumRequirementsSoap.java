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
 * <a href="CdsTitleMinimumRequirementsSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsTitleMinimumRequirementsSoap implements Serializable {
	public static CdsTitleMinimumRequirementsSoap toSoapModel(
		CdsTitleMinimumRequirements model) {
		CdsTitleMinimumRequirementsSoap soapModel = new CdsTitleMinimumRequirementsSoap();

		soapModel.setCdsTitleMinimumRequirementsId(model.getCdsTitleMinimumRequirementsId());
		soapModel.setTitleId(model.getTitleId());
		soapModel.setMinimumRequirementId(model.getMinimumRequirementId());
		soapModel.setMinimumRequirementLevelId(model.getMinimumRequirementLevelId());

		return soapModel;
	}

	public static CdsTitleMinimumRequirementsSoap[] toSoapModels(
		CdsTitleMinimumRequirements[] models) {
		CdsTitleMinimumRequirementsSoap[] soapModels = new CdsTitleMinimumRequirementsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CdsTitleMinimumRequirementsSoap[][] toSoapModels(
		CdsTitleMinimumRequirements[][] models) {
		CdsTitleMinimumRequirementsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CdsTitleMinimumRequirementsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CdsTitleMinimumRequirementsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CdsTitleMinimumRequirementsSoap[] toSoapModels(
		List<CdsTitleMinimumRequirements> models) {
		List<CdsTitleMinimumRequirementsSoap> soapModels = new ArrayList<CdsTitleMinimumRequirementsSoap>(models.size());

		for (CdsTitleMinimumRequirements model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CdsTitleMinimumRequirementsSoap[soapModels.size()]);
	}

	public CdsTitleMinimumRequirementsSoap() {
	}

	public Integer getPrimaryKey() {
		return _CdsTitleMinimumRequirementsId;
	}

	public void setPrimaryKey(Integer pk) {
		setCdsTitleMinimumRequirementsId(pk);
	}

	public Integer getCdsTitleMinimumRequirementsId() {
		return _CdsTitleMinimumRequirementsId;
	}

	public void setCdsTitleMinimumRequirementsId(
		Integer CdsTitleMinimumRequirementsId) {
		_CdsTitleMinimumRequirementsId = CdsTitleMinimumRequirementsId;
	}

	public int getTitleId() {
		return _titleId;
	}

	public void setTitleId(int titleId) {
		_titleId = titleId;
	}

	public int getMinimumRequirementId() {
		return _minimumRequirementId;
	}

	public void setMinimumRequirementId(int minimumRequirementId) {
		_minimumRequirementId = minimumRequirementId;
	}

	public int getMinimumRequirementLevelId() {
		return _minimumRequirementLevelId;
	}

	public void setMinimumRequirementLevelId(int minimumRequirementLevelId) {
		_minimumRequirementLevelId = minimumRequirementLevelId;
	}

	private Integer _CdsTitleMinimumRequirementsId;
	private int _titleId;
	private int _minimumRequirementId;
	private int _minimumRequirementLevelId;
}