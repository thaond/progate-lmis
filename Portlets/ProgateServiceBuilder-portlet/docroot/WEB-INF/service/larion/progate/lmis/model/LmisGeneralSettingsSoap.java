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
 * <a href="LmisGeneralSettingsSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisGeneralSettingsSoap implements Serializable {
	public static LmisGeneralSettingsSoap toSoapModel(LmisGeneralSettings model) {
		LmisGeneralSettingsSoap soapModel = new LmisGeneralSettingsSoap();

		soapModel.setLmisGeneralSettingId(model.getLmisGeneralSettingId());
		soapModel.setRootId(model.getRootId());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setConfType(model.getConfType());
		soapModel.setConfValue(model.getConfValue());

		return soapModel;
	}

	public static LmisGeneralSettingsSoap[] toSoapModels(
		LmisGeneralSettings[] models) {
		LmisGeneralSettingsSoap[] soapModels = new LmisGeneralSettingsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LmisGeneralSettingsSoap[][] toSoapModels(
		LmisGeneralSettings[][] models) {
		LmisGeneralSettingsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LmisGeneralSettingsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LmisGeneralSettingsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LmisGeneralSettingsSoap[] toSoapModels(
		List<LmisGeneralSettings> models) {
		List<LmisGeneralSettingsSoap> soapModels = new ArrayList<LmisGeneralSettingsSoap>(models.size());

		for (LmisGeneralSettings model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LmisGeneralSettingsSoap[soapModels.size()]);
	}

	public LmisGeneralSettingsSoap() {
	}

	public Integer getPrimaryKey() {
		return _lmisGeneralSettingId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisGeneralSettingId(pk);
	}

	public Integer getLmisGeneralSettingId() {
		return _lmisGeneralSettingId;
	}

	public void setLmisGeneralSettingId(Integer lmisGeneralSettingId) {
		_lmisGeneralSettingId = lmisGeneralSettingId;
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

	public int getConfType() {
		return _confType;
	}

	public void setConfType(int confType) {
		_confType = confType;
	}

	public double getConfValue() {
		return _confValue;
	}

	public void setConfValue(double confValue) {
		_confValue = confValue;
	}

	private Integer _lmisGeneralSettingId;
	private int _rootId;
	private String _name;
	private String _description;
	private int _confType;
	private double _confValue;
}