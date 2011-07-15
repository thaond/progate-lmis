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
 * <a href="ViewListTitleCompetenciesSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ViewListTitleCompetenciesSoap implements Serializable {
	public static ViewListTitleCompetenciesSoap toSoapModel(
		ViewListTitleCompetencies model) {
		ViewListTitleCompetenciesSoap soapModel = new ViewListTitleCompetenciesSoap();

		soapModel.setId(model.getId());
		soapModel.setTitleId(model.getTitleId());
		soapModel.setRootId(model.getRootId());
		soapModel.setTitleName(model.getTitleName());
		soapModel.setAbbreviation(model.getAbbreviation());
		soapModel.setCompetencyId(model.getCompetencyId());
		soapModel.setCompetencyName(model.getCompetencyName());
		soapModel.setCompetencyNumberOrder(model.getCompetencyNumberOrder());
		soapModel.setPointHash(model.getPointHash());
		soapModel.setPointValue(model.getPointValue());

		return soapModel;
	}

	public static ViewListTitleCompetenciesSoap[] toSoapModels(
		ViewListTitleCompetencies[] models) {
		ViewListTitleCompetenciesSoap[] soapModels = new ViewListTitleCompetenciesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ViewListTitleCompetenciesSoap[][] toSoapModels(
		ViewListTitleCompetencies[][] models) {
		ViewListTitleCompetenciesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ViewListTitleCompetenciesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ViewListTitleCompetenciesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ViewListTitleCompetenciesSoap[] toSoapModels(
		List<ViewListTitleCompetencies> models) {
		List<ViewListTitleCompetenciesSoap> soapModels = new ArrayList<ViewListTitleCompetenciesSoap>(models.size());

		for (ViewListTitleCompetencies model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ViewListTitleCompetenciesSoap[soapModels.size()]);
	}

	public ViewListTitleCompetenciesSoap() {
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

	public int getCompetencyId() {
		return _competencyId;
	}

	public void setCompetencyId(int competencyId) {
		_competencyId = competencyId;
	}

	public String getCompetencyName() {
		return _competencyName;
	}

	public void setCompetencyName(String competencyName) {
		_competencyName = competencyName;
	}

	public int getCompetencyNumberOrder() {
		return _competencyNumberOrder;
	}

	public void setCompetencyNumberOrder(int competencyNumberOrder) {
		_competencyNumberOrder = competencyNumberOrder;
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

	private String _id;
	private int _titleId;
	private int _rootId;
	private String _titleName;
	private String _abbreviation;
	private int _competencyId;
	private String _competencyName;
	private int _competencyNumberOrder;
	private int _pointHash;
	private String _pointValue;
}