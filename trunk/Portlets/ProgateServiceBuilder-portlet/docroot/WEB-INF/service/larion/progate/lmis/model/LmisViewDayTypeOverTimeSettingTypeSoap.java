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
 * <a href="LmisViewDayTypeOverTimeSettingTypeSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewDayTypeOverTimeSettingTypeSoap implements Serializable {
	public static LmisViewDayTypeOverTimeSettingTypeSoap toSoapModel(
		LmisViewDayTypeOverTimeSettingType model) {
		LmisViewDayTypeOverTimeSettingTypeSoap soapModel = new LmisViewDayTypeOverTimeSettingTypeSoap();

		soapModel.setLmisViewDayTypeOverTimeSettingTypeId(model.getLmisViewDayTypeOverTimeSettingTypeId());
		soapModel.setOtTypeId(model.getOtTypeId());
		soapModel.setRootId(model.getRootId());
		soapModel.setName(model.getName());
		soapModel.setDayType(model.getDayType());
		soapModel.setOtId(model.getOtId());
		soapModel.setCoefficient(model.getCoefficient());
		soapModel.setNameOvertimeType(model.getNameOvertimeType());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static LmisViewDayTypeOverTimeSettingTypeSoap[] toSoapModels(
		LmisViewDayTypeOverTimeSettingType[] models) {
		LmisViewDayTypeOverTimeSettingTypeSoap[] soapModels = new LmisViewDayTypeOverTimeSettingTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LmisViewDayTypeOverTimeSettingTypeSoap[][] toSoapModels(
		LmisViewDayTypeOverTimeSettingType[][] models) {
		LmisViewDayTypeOverTimeSettingTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LmisViewDayTypeOverTimeSettingTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LmisViewDayTypeOverTimeSettingTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LmisViewDayTypeOverTimeSettingTypeSoap[] toSoapModels(
		List<LmisViewDayTypeOverTimeSettingType> models) {
		List<LmisViewDayTypeOverTimeSettingTypeSoap> soapModels = new ArrayList<LmisViewDayTypeOverTimeSettingTypeSoap>(models.size());

		for (LmisViewDayTypeOverTimeSettingType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LmisViewDayTypeOverTimeSettingTypeSoap[soapModels.size()]);
	}

	public LmisViewDayTypeOverTimeSettingTypeSoap() {
	}

	public Integer getPrimaryKey() {
		return _lmisViewDayTypeOverTimeSettingTypeId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisViewDayTypeOverTimeSettingTypeId(pk);
	}

	public Integer getLmisViewDayTypeOverTimeSettingTypeId() {
		return _lmisViewDayTypeOverTimeSettingTypeId;
	}

	public void setLmisViewDayTypeOverTimeSettingTypeId(
		Integer lmisViewDayTypeOverTimeSettingTypeId) {
		_lmisViewDayTypeOverTimeSettingTypeId = lmisViewDayTypeOverTimeSettingTypeId;
	}

	public int getOtTypeId() {
		return _otTypeId;
	}

	public void setOtTypeId(int otTypeId) {
		_otTypeId = otTypeId;
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

	public int getDayType() {
		return _dayType;
	}

	public void setDayType(int dayType) {
		_dayType = dayType;
	}

	public int getOtId() {
		return _otId;
	}

	public void setOtId(int otId) {
		_otId = otId;
	}

	public double getCoefficient() {
		return _coefficient;
	}

	public void setCoefficient(double coefficient) {
		_coefficient = coefficient;
	}

	public String getNameOvertimeType() {
		return _nameOvertimeType;
	}

	public void setNameOvertimeType(String nameOvertimeType) {
		_nameOvertimeType = nameOvertimeType;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private Integer _lmisViewDayTypeOverTimeSettingTypeId;
	private int _otTypeId;
	private int _rootId;
	private String _name;
	private int _dayType;
	private int _otId;
	private double _coefficient;
	private String _nameOvertimeType;
	private String _description;
}