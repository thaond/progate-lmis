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
 * <a href="LmisOverTimeSettingsSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisOverTimeSettingsSoap implements Serializable {
	public static LmisOverTimeSettingsSoap toSoapModel(
		LmisOverTimeSettings model) {
		LmisOverTimeSettingsSoap soapModel = new LmisOverTimeSettingsSoap();

		soapModel.setLmisOverTimeSettingsId(model.getLmisOverTimeSettingsId());
		soapModel.setRootId(model.getRootId());
		soapModel.setOtId(model.getOtId());
		soapModel.setDayType(model.getDayType());
		soapModel.setCoEfficient(model.getCoEfficient());

		return soapModel;
	}

	public static LmisOverTimeSettingsSoap[] toSoapModels(
		LmisOverTimeSettings[] models) {
		LmisOverTimeSettingsSoap[] soapModels = new LmisOverTimeSettingsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LmisOverTimeSettingsSoap[][] toSoapModels(
		LmisOverTimeSettings[][] models) {
		LmisOverTimeSettingsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LmisOverTimeSettingsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LmisOverTimeSettingsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LmisOverTimeSettingsSoap[] toSoapModels(
		List<LmisOverTimeSettings> models) {
		List<LmisOverTimeSettingsSoap> soapModels = new ArrayList<LmisOverTimeSettingsSoap>(models.size());

		for (LmisOverTimeSettings model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LmisOverTimeSettingsSoap[soapModels.size()]);
	}

	public LmisOverTimeSettingsSoap() {
	}

	public Integer getPrimaryKey() {
		return _lmisOverTimeSettingsId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisOverTimeSettingsId(pk);
	}

	public Integer getLmisOverTimeSettingsId() {
		return _lmisOverTimeSettingsId;
	}

	public void setLmisOverTimeSettingsId(Integer lmisOverTimeSettingsId) {
		_lmisOverTimeSettingsId = lmisOverTimeSettingsId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public int getOtId() {
		return _otId;
	}

	public void setOtId(int otId) {
		_otId = otId;
	}

	public int getDayType() {
		return _dayType;
	}

	public void setDayType(int dayType) {
		_dayType = dayType;
	}

	public double getCoEfficient() {
		return _coEfficient;
	}

	public void setCoEfficient(double coEfficient) {
		_coEfficient = coEfficient;
	}

	private Integer _lmisOverTimeSettingsId;
	private int _rootId;
	private int _otId;
	private int _dayType;
	private double _coEfficient;
}