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
 * <a href="CountrySoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CountrySoap implements Serializable {
	public static CountrySoap toSoapModel(Country model) {
		CountrySoap soapModel = new CountrySoap();

		soapModel.setCountryId(model.getCountryId());
		soapModel.setName(model.getName());
		soapModel.setActive(model.getActive());

		return soapModel;
	}

	public static CountrySoap[] toSoapModels(Country[] models) {
		CountrySoap[] soapModels = new CountrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CountrySoap[][] toSoapModels(Country[][] models) {
		CountrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CountrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new CountrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CountrySoap[] toSoapModels(List<Country> models) {
		List<CountrySoap> soapModels = new ArrayList<CountrySoap>(models.size());

		for (Country model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CountrySoap[soapModels.size()]);
	}

	public CountrySoap() {
	}

	public Integer getPrimaryKey() {
		return _countryId;
	}

	public void setPrimaryKey(Integer pk) {
		setCountryId(pk);
	}

	public Integer getCountryId() {
		return _countryId;
	}

	public void setCountryId(Integer countryId) {
		_countryId = countryId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;
	}

	private Integer _countryId;
	private String _name;
	private boolean _active;
}