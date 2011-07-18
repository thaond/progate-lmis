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
 * <a href="ViewFinalSlotsSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ViewFinalSlotsSoap implements Serializable {
	public static ViewFinalSlotsSoap toSoapModel(ViewFinalSlots model) {
		ViewFinalSlotsSoap soapModel = new ViewFinalSlotsSoap();

		soapModel.setSlotId(model.getSlotId());
		soapModel.setLevelId(model.getLevelId());
		soapModel.setRootId(model.getRootId());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setUserId(model.getUserId());
		soapModel.setRatingStatus(model.getRatingStatus());
		soapModel.setPointName(model.getPointName());
		soapModel.setMaxPointName(model.getMaxPointName());
		soapModel.setPointValue(model.getPointValue());
		soapModel.setMaxPointValue(model.getMaxPointValue());
		soapModel.setIsPassed(model.getIsPassed());

		return soapModel;
	}

	public static ViewFinalSlotsSoap[] toSoapModels(ViewFinalSlots[] models) {
		ViewFinalSlotsSoap[] soapModels = new ViewFinalSlotsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ViewFinalSlotsSoap[][] toSoapModels(ViewFinalSlots[][] models) {
		ViewFinalSlotsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ViewFinalSlotsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ViewFinalSlotsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ViewFinalSlotsSoap[] toSoapModels(List<ViewFinalSlots> models) {
		List<ViewFinalSlotsSoap> soapModels = new ArrayList<ViewFinalSlotsSoap>(models.size());

		for (ViewFinalSlots model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ViewFinalSlotsSoap[soapModels.size()]);
	}

	public ViewFinalSlotsSoap() {
	}

	public Integer getPrimaryKey() {
		return _slotId;
	}

	public void setPrimaryKey(Integer pk) {
		setSlotId(pk);
	}

	public Integer getSlotId() {
		return _slotId;
	}

	public void setSlotId(Integer slotId) {
		_slotId = slotId;
	}

	public int getLevelId() {
		return _levelId;
	}

	public void setLevelId(int levelId) {
		_levelId = levelId;
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

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public int getUserId() {
		return _userId;
	}

	public void setUserId(int userId) {
		_userId = userId;
	}

	public boolean getRatingStatus() {
		return _ratingStatus;
	}

	public boolean isRatingStatus() {
		return _ratingStatus;
	}

	public void setRatingStatus(boolean ratingStatus) {
		_ratingStatus = ratingStatus;
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

	public int getPointValue() {
		return _pointValue;
	}

	public void setPointValue(int pointValue) {
		_pointValue = pointValue;
	}

	public int getMaxPointValue() {
		return _maxPointValue;
	}

	public void setMaxPointValue(int maxPointValue) {
		_maxPointValue = maxPointValue;
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

	private Integer _slotId;
	private int _levelId;
	private int _rootId;
	private String _name;
	private String _description;
	private int _userId;
	private boolean _ratingStatus;
	private String _pointName;
	private String _maxPointName;
	private int _pointValue;
	private int _maxPointValue;
	private boolean _isPassed;
}