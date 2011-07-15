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
 * <a href="CdsPAFinalLevelsSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsPAFinalLevelsSoap implements Serializable {
	public static CdsPAFinalLevelsSoap toSoapModel(CdsPAFinalLevels model) {
		CdsPAFinalLevelsSoap soapModel = new CdsPAFinalLevelsSoap();

		soapModel.setCdsPAFinalLevelsId(model.getCdsPAFinalLevelsId());
		soapModel.setPaId(model.getPaId());
		soapModel.setRootId(model.getRootId());
		soapModel.setUserId(model.getUserId());
		soapModel.setLevelId(model.getLevelId());
		soapModel.setTotalLevelPoint(model.getTotalLevelPoint());
		soapModel.setIsPassed(model.getIsPassed());

		return soapModel;
	}

	public static CdsPAFinalLevelsSoap[] toSoapModels(CdsPAFinalLevels[] models) {
		CdsPAFinalLevelsSoap[] soapModels = new CdsPAFinalLevelsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CdsPAFinalLevelsSoap[][] toSoapModels(
		CdsPAFinalLevels[][] models) {
		CdsPAFinalLevelsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CdsPAFinalLevelsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CdsPAFinalLevelsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CdsPAFinalLevelsSoap[] toSoapModels(
		List<CdsPAFinalLevels> models) {
		List<CdsPAFinalLevelsSoap> soapModels = new ArrayList<CdsPAFinalLevelsSoap>(models.size());

		for (CdsPAFinalLevels model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CdsPAFinalLevelsSoap[soapModels.size()]);
	}

	public CdsPAFinalLevelsSoap() {
	}

	public Integer getPrimaryKey() {
		return _CdsPAFinalLevelsId;
	}

	public void setPrimaryKey(Integer pk) {
		setCdsPAFinalLevelsId(pk);
	}

	public Integer getCdsPAFinalLevelsId() {
		return _CdsPAFinalLevelsId;
	}

	public void setCdsPAFinalLevelsId(Integer CdsPAFinalLevelsId) {
		_CdsPAFinalLevelsId = CdsPAFinalLevelsId;
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

	public int getLevelId() {
		return _levelId;
	}

	public void setLevelId(int levelId) {
		_levelId = levelId;
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

	private Integer _CdsPAFinalLevelsId;
	private int _paId;
	private int _rootId;
	private int _userId;
	private int _levelId;
	private int _totalLevelPoint;
	private boolean _isPassed;
}