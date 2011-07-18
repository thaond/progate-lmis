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
 * <a href="ProgateMenusSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProgateMenusSoap implements Serializable {
	public static ProgateMenusSoap toSoapModel(ProgateMenus model) {
		ProgateMenusSoap soapModel = new ProgateMenusSoap();

		soapModel.setProgateMenusId(model.getProgateMenusId());
		soapModel.setName(model.getName());
		soapModel.setLayoutId(model.getLayoutId());
		soapModel.setNumberOrder(model.getNumberOrder());

		return soapModel;
	}

	public static ProgateMenusSoap[] toSoapModels(ProgateMenus[] models) {
		ProgateMenusSoap[] soapModels = new ProgateMenusSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProgateMenusSoap[][] toSoapModels(ProgateMenus[][] models) {
		ProgateMenusSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProgateMenusSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProgateMenusSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProgateMenusSoap[] toSoapModels(List<ProgateMenus> models) {
		List<ProgateMenusSoap> soapModels = new ArrayList<ProgateMenusSoap>(models.size());

		for (ProgateMenus model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProgateMenusSoap[soapModels.size()]);
	}

	public ProgateMenusSoap() {
	}

	public int getPrimaryKey() {
		return _ProgateMenusId;
	}

	public void setPrimaryKey(int pk) {
		setProgateMenusId(pk);
	}

	public int getProgateMenusId() {
		return _ProgateMenusId;
	}

	public void setProgateMenusId(int ProgateMenusId) {
		_ProgateMenusId = ProgateMenusId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public int getLayoutId() {
		return _layoutId;
	}

	public void setLayoutId(int layoutId) {
		_layoutId = layoutId;
	}

	public int getNumberOrder() {
		return _numberOrder;
	}

	public void setNumberOrder(int numberOrder) {
		_numberOrder = numberOrder;
	}

	private int _ProgateMenusId;
	private String _name;
	private int _layoutId;
	private int _numberOrder;
}