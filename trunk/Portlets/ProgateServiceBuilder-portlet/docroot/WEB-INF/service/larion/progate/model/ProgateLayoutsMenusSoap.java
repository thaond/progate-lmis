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

package larion.progate.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="ProgateLayoutsMenusSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProgateLayoutsMenusSoap implements Serializable {
	public static ProgateLayoutsMenusSoap toSoapModel(ProgateLayoutsMenus model) {
		ProgateLayoutsMenusSoap soapModel = new ProgateLayoutsMenusSoap();

		soapModel.setProgateLayoutsMenusId(model.getProgateLayoutsMenusId());
		soapModel.setLayoutId(model.getLayoutId());
		soapModel.setMenuName(model.getMenuName());

		return soapModel;
	}

	public static ProgateLayoutsMenusSoap[] toSoapModels(
		ProgateLayoutsMenus[] models) {
		ProgateLayoutsMenusSoap[] soapModels = new ProgateLayoutsMenusSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProgateLayoutsMenusSoap[][] toSoapModels(
		ProgateLayoutsMenus[][] models) {
		ProgateLayoutsMenusSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProgateLayoutsMenusSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProgateLayoutsMenusSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProgateLayoutsMenusSoap[] toSoapModels(
		List<ProgateLayoutsMenus> models) {
		List<ProgateLayoutsMenusSoap> soapModels = new ArrayList<ProgateLayoutsMenusSoap>(models.size());

		for (ProgateLayoutsMenus model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProgateLayoutsMenusSoap[soapModels.size()]);
	}

	public ProgateLayoutsMenusSoap() {
	}

	public int getPrimaryKey() {
		return _ProgateLayoutsMenusId;
	}

	public void setPrimaryKey(int pk) {
		setProgateLayoutsMenusId(pk);
	}

	public int getProgateLayoutsMenusId() {
		return _ProgateLayoutsMenusId;
	}

	public void setProgateLayoutsMenusId(int ProgateLayoutsMenusId) {
		_ProgateLayoutsMenusId = ProgateLayoutsMenusId;
	}

	public int getLayoutId() {
		return _layoutId;
	}

	public void setLayoutId(int layoutId) {
		_layoutId = layoutId;
	}

	public String getMenuName() {
		return _menuName;
	}

	public void setMenuName(String menuName) {
		_menuName = menuName;
	}

	private int _ProgateLayoutsMenusId;
	private int _layoutId;
	private String _menuName;
}