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
 * <a href="ViewListTitleMinimumRequirementsSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ViewListTitleMinimumRequirementsSoap implements Serializable {
	public static ViewListTitleMinimumRequirementsSoap toSoapModel(
		ViewListTitleMinimumRequirements model) {
		ViewListTitleMinimumRequirementsSoap soapModel = new ViewListTitleMinimumRequirementsSoap();

		soapModel.setId(model.getId());
		soapModel.setTitleId(model.getTitleId());
		soapModel.setRootId(model.getRootId());
		soapModel.setTitleName(model.getTitleName());
		soapModel.setAbbreviation(model.getAbbreviation());
		soapModel.setMinimumRequirementId(model.getMinimumRequirementId());
		soapModel.setMinimumRequirementName(model.getMinimumRequirementName());
		soapModel.setMinimumRequirementNumberOrder(model.getMinimumRequirementNumberOrder());
		soapModel.setLevelId(model.getLevelId());
		soapModel.setLevel(model.getLevel());

		return soapModel;
	}

	public static ViewListTitleMinimumRequirementsSoap[] toSoapModels(
		ViewListTitleMinimumRequirements[] models) {
		ViewListTitleMinimumRequirementsSoap[] soapModels = new ViewListTitleMinimumRequirementsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ViewListTitleMinimumRequirementsSoap[][] toSoapModels(
		ViewListTitleMinimumRequirements[][] models) {
		ViewListTitleMinimumRequirementsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ViewListTitleMinimumRequirementsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ViewListTitleMinimumRequirementsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ViewListTitleMinimumRequirementsSoap[] toSoapModels(
		List<ViewListTitleMinimumRequirements> models) {
		List<ViewListTitleMinimumRequirementsSoap> soapModels = new ArrayList<ViewListTitleMinimumRequirementsSoap>(models.size());

		for (ViewListTitleMinimumRequirements model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ViewListTitleMinimumRequirementsSoap[soapModels.size()]);
	}

	public ViewListTitleMinimumRequirementsSoap() {
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

	public int getTitleId() {
		return _titleId;
	}

	public void setTitleId(int titleId) {
		_titleId = titleId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public String getTitleName() {
		return _titleName;
	}

	public void setTitleName(String titleName) {
		_titleName = titleName;
	}

	public String getAbbreviation() {
		return _abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		_abbreviation = abbreviation;
	}

	public int getMinimumRequirementId() {
		return _minimumRequirementId;
	}

	public void setMinimumRequirementId(int minimumRequirementId) {
		_minimumRequirementId = minimumRequirementId;
	}

	public String getMinimumRequirementName() {
		return _minimumRequirementName;
	}

	public void setMinimumRequirementName(String minimumRequirementName) {
		_minimumRequirementName = minimumRequirementName;
	}

	public int getMinimumRequirementNumberOrder() {
		return _minimumRequirementNumberOrder;
	}

	public void setMinimumRequirementNumberOrder(
		int minimumRequirementNumberOrder) {
		_minimumRequirementNumberOrder = minimumRequirementNumberOrder;
	}

	public int getLevelId() {
		return _levelId;
	}

	public void setLevelId(int levelId) {
		_levelId = levelId;
	}

	public String getLevel() {
		return _level;
	}

	public void setLevel(String level) {
		_level = level;
	}

	private String _id;
	private int _titleId;
	private int _rootId;
	private String _titleName;
	private String _abbreviation;
	private int _minimumRequirementId;
	private String _minimumRequirementName;
	private int _minimumRequirementNumberOrder;
	private int _levelId;
	private String _level;
}