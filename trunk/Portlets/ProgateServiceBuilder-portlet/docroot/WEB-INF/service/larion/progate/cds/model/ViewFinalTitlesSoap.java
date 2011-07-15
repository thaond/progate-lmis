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
 * <a href="ViewFinalTitlesSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ViewFinalTitlesSoap implements Serializable {
	public static ViewFinalTitlesSoap toSoapModel(ViewFinalTitles model) {
		ViewFinalTitlesSoap soapModel = new ViewFinalTitlesSoap();

		soapModel.setViewFinalTitlesId(model.getViewFinalTitlesId());
		soapModel.setRootId(model.getRootId());
		soapModel.setUserId(model.getUserId());
		soapModel.setTitleId(model.getTitleId());
		soapModel.setTitleName(model.getTitleName());

		return soapModel;
	}

	public static ViewFinalTitlesSoap[] toSoapModels(ViewFinalTitles[] models) {
		ViewFinalTitlesSoap[] soapModels = new ViewFinalTitlesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ViewFinalTitlesSoap[][] toSoapModels(
		ViewFinalTitles[][] models) {
		ViewFinalTitlesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ViewFinalTitlesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ViewFinalTitlesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ViewFinalTitlesSoap[] toSoapModels(
		List<ViewFinalTitles> models) {
		List<ViewFinalTitlesSoap> soapModels = new ArrayList<ViewFinalTitlesSoap>(models.size());

		for (ViewFinalTitles model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ViewFinalTitlesSoap[soapModels.size()]);
	}

	public ViewFinalTitlesSoap() {
	}

	public Integer getPrimaryKey() {
		return _ViewFinalTitlesId;
	}

	public void setPrimaryKey(Integer pk) {
		setViewFinalTitlesId(pk);
	}

	public Integer getViewFinalTitlesId() {
		return _ViewFinalTitlesId;
	}

	public void setViewFinalTitlesId(Integer ViewFinalTitlesId) {
		_ViewFinalTitlesId = ViewFinalTitlesId;
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

	public int getTitleId() {
		return _titleId;
	}

	public void setTitleId(int titleId) {
		_titleId = titleId;
	}

	public String getTitleName() {
		return _titleName;
	}

	public void setTitleName(String titleName) {
		_titleName = titleName;
	}

	private Integer _ViewFinalTitlesId;
	private int _rootId;
	private int _userId;
	private int _titleId;
	private String _titleName;
}