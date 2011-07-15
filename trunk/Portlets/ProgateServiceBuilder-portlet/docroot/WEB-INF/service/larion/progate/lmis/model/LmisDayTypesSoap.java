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
import java.util.List;

/**
 * <a href="LmisDayTypesSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisDayTypesSoap implements Serializable {
	public static LmisDayTypesSoap toSoapModel(LmisDayTypes model) {
		LmisDayTypesSoap soapModel = new LmisDayTypesSoap();

		soapModel.setLmisDayTypeId(model.getLmisDayTypeId());
		soapModel.setRootId(model.getRootId());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setDayType(model.getDayType());

		return soapModel;
	}

	public static LmisDayTypesSoap[] toSoapModels(LmisDayTypes[] models) {
		LmisDayTypesSoap[] soapModels = new LmisDayTypesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LmisDayTypesSoap[][] toSoapModels(LmisDayTypes[][] models) {
		LmisDayTypesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LmisDayTypesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LmisDayTypesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LmisDayTypesSoap[] toSoapModels(List<LmisDayTypes> models) {
		List<LmisDayTypesSoap> soapModels = new ArrayList<LmisDayTypesSoap>(models.size());

		for (LmisDayTypes model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LmisDayTypesSoap[soapModels.size()]);
	}

	public LmisDayTypesSoap() {
	}

	public Integer getPrimaryKey() {
		return _LmisDayTypeId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisDayTypeId(pk);
	}

	public Integer getLmisDayTypeId() {
		return _LmisDayTypeId;
	}

	public void setLmisDayTypeId(Integer LmisDayTypeId) {
		_LmisDayTypeId = LmisDayTypeId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public String getName() {
		return _Name;
	}

	public void setName(String Name) {
		_Name = Name;
	}

	public String getDescription() {
		return _Description;
	}

	public void setDescription(String Description) {
		_Description = Description;
	}

	public int getDayType() {
		return _dayType;
	}

	public void setDayType(int dayType) {
		_dayType = dayType;
	}

	private Integer _LmisDayTypeId;
	private int _rootId;
	private String _Name;
	private String _Description;
	private int _dayType;
}