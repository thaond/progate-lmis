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
 * <a href="CdsPAFinalCompeteniesSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsPAFinalCompeteniesSoap implements Serializable {
	public static CdsPAFinalCompeteniesSoap toSoapModel(
		CdsPAFinalCompetenies model) {
		CdsPAFinalCompeteniesSoap soapModel = new CdsPAFinalCompeteniesSoap();

		soapModel.setCdsPAFinalCompeteniesId(model.getCdsPAFinalCompeteniesId());
		soapModel.setPaId(model.getPaId());
		soapModel.setRootId(model.getRootId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCompetencyId(model.getCompetencyId());
		soapModel.setLevelRankingHash(model.getLevelRankingHash());
		soapModel.setLevelRankingValue(model.getLevelRankingValue());

		return soapModel;
	}

	public static CdsPAFinalCompeteniesSoap[] toSoapModels(
		CdsPAFinalCompetenies[] models) {
		CdsPAFinalCompeteniesSoap[] soapModels = new CdsPAFinalCompeteniesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CdsPAFinalCompeteniesSoap[][] toSoapModels(
		CdsPAFinalCompetenies[][] models) {
		CdsPAFinalCompeteniesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CdsPAFinalCompeteniesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CdsPAFinalCompeteniesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CdsPAFinalCompeteniesSoap[] toSoapModels(
		List<CdsPAFinalCompetenies> models) {
		List<CdsPAFinalCompeteniesSoap> soapModels = new ArrayList<CdsPAFinalCompeteniesSoap>(models.size());

		for (CdsPAFinalCompetenies model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CdsPAFinalCompeteniesSoap[soapModels.size()]);
	}

	public CdsPAFinalCompeteniesSoap() {
	}

	public Integer getPrimaryKey() {
		return _cdsPAFinalCompeteniesId;
	}

	public void setPrimaryKey(Integer pk) {
		setCdsPAFinalCompeteniesId(pk);
	}

	public Integer getCdsPAFinalCompeteniesId() {
		return _cdsPAFinalCompeteniesId;
	}

	public void setCdsPAFinalCompeteniesId(Integer cdsPAFinalCompeteniesId) {
		_cdsPAFinalCompeteniesId = cdsPAFinalCompeteniesId;
	}

	public int getPaId() {
		return _paId;
	}

	public void setPaId(int paId) {
		_paId = paId;
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

	public int getCompetencyId() {
		return _competencyId;
	}

	public void setCompetencyId(int competencyId) {
		_competencyId = competencyId;
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

	private Integer _cdsPAFinalCompeteniesId;
	private int _paId;
	private int _rootId;
	private int _userId;
	private int _competencyId;
	private int _levelRankingHash;
	private String _levelRankingValue;
}