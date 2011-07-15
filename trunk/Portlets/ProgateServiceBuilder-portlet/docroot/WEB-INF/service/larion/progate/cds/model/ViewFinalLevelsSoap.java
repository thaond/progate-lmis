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
 * <a href="ViewFinalLevelsSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ViewFinalLevelsSoap implements Serializable {
	public static ViewFinalLevelsSoap toSoapModel(ViewFinalLevels model) {
		ViewFinalLevelsSoap soapModel = new ViewFinalLevelsSoap();

		soapModel.setLevelId(model.getLevelId());
		soapModel.setCompetencyId(model.getCompetencyId());
		soapModel.setRootId(model.getRootId());
		soapModel.setName(model.getName());
		soapModel.setUserId(model.getUserId());
		soapModel.setTotalLevelPoint(model.getTotalLevelPoint());
		soapModel.setIsPassed(model.getIsPassed());

		return soapModel;
	}

	public static ViewFinalLevelsSoap[] toSoapModels(ViewFinalLevels[] models) {
		ViewFinalLevelsSoap[] soapModels = new ViewFinalLevelsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ViewFinalLevelsSoap[][] toSoapModels(
		ViewFinalLevels[][] models) {
		ViewFinalLevelsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ViewFinalLevelsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ViewFinalLevelsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ViewFinalLevelsSoap[] toSoapModels(
		List<ViewFinalLevels> models) {
		List<ViewFinalLevelsSoap> soapModels = new ArrayList<ViewFinalLevelsSoap>(models.size());

		for (ViewFinalLevels model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ViewFinalLevelsSoap[soapModels.size()]);
	}

	public ViewFinalLevelsSoap() {
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
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

	public boolean getIsPassed() {
		return _isPassed;
	}

	public boolean isIsPassed() {
		return _isPassed;
	}

	public void setIsPassed(boolean isPassed) {
		_isPassed = isPassed;
	}

	private Integer _levelId;
	private int _competencyId;
	private int _rootId;
	private String _name;
	private int _userId;
	private int _totalLevelPoint;
	private boolean _isPassed;
}