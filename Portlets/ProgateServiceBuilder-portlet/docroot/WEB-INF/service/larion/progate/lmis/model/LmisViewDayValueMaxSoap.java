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

package larion.progate.lmis.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="LmisViewDayValueMaxSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewDayValueMaxSoap implements Serializable {
	public static LmisViewDayValueMaxSoap toSoapModel(LmisViewDayValueMax model) {
		LmisViewDayValueMaxSoap soapModel = new LmisViewDayValueMaxSoap();

		soapModel.setLmisViewDayValueMaxId(model.getLmisViewDayValueMaxId());
		soapModel.setDayValue(model.getDayValue());
		soapModel.setRootId(model.getRootId());

		return soapModel;
	}

	public static LmisViewDayValueMaxSoap[] toSoapModels(
		LmisViewDayValueMax[] models) {
		LmisViewDayValueMaxSoap[] soapModels = new LmisViewDayValueMaxSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LmisViewDayValueMaxSoap[][] toSoapModels(
		LmisViewDayValueMax[][] models) {
		LmisViewDayValueMaxSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LmisViewDayValueMaxSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LmisViewDayValueMaxSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LmisViewDayValueMaxSoap[] toSoapModels(
		List<LmisViewDayValueMax> models) {
		List<LmisViewDayValueMaxSoap> soapModels = new ArrayList<LmisViewDayValueMaxSoap>(models.size());

		for (LmisViewDayValueMax model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LmisViewDayValueMaxSoap[soapModels.size()]);
	}

	public LmisViewDayValueMaxSoap() {
	}

	public Integer getPrimaryKey() {
		return _lmisViewDayValueMaxId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisViewDayValueMaxId(pk);
	}

	public Integer getLmisViewDayValueMaxId() {
		return _lmisViewDayValueMaxId;
	}

	public void setLmisViewDayValueMaxId(Integer lmisViewDayValueMaxId) {
		_lmisViewDayValueMaxId = lmisViewDayValueMaxId;
	}

	public Date getDayValue() {
		return _dayValue;
	}

	public void setDayValue(Date dayValue) {
		_dayValue = dayValue;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	private Integer _lmisViewDayValueMaxId;
	private Date _dayValue;
	private int _rootId;
}