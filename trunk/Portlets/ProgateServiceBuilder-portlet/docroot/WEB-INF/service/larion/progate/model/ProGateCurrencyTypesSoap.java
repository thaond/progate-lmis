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
 * <a href="ProGateCurrencyTypesSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateCurrencyTypesSoap implements Serializable {
	public static ProGateCurrencyTypesSoap toSoapModel(
		ProGateCurrencyTypes model) {
		ProGateCurrencyTypesSoap soapModel = new ProGateCurrencyTypesSoap();

		soapModel.setCurrencyId(model.getCurrencyId());
		soapModel.setCode(model.getCode());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static ProGateCurrencyTypesSoap[] toSoapModels(
		ProGateCurrencyTypes[] models) {
		ProGateCurrencyTypesSoap[] soapModels = new ProGateCurrencyTypesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProGateCurrencyTypesSoap[][] toSoapModels(
		ProGateCurrencyTypes[][] models) {
		ProGateCurrencyTypesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProGateCurrencyTypesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProGateCurrencyTypesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProGateCurrencyTypesSoap[] toSoapModels(
		List<ProGateCurrencyTypes> models) {
		List<ProGateCurrencyTypesSoap> soapModels = new ArrayList<ProGateCurrencyTypesSoap>(models.size());

		for (ProGateCurrencyTypes model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProGateCurrencyTypesSoap[soapModels.size()]);
	}

	public ProGateCurrencyTypesSoap() {
	}

	public Integer getPrimaryKey() {
		return _currencyId;
	}

	public void setPrimaryKey(Integer pk) {
		setCurrencyId(pk);
	}

	public Integer getCurrencyId() {
		return _currencyId;
	}

	public void setCurrencyId(Integer currencyId) {
		_currencyId = currencyId;
	}

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private Integer _currencyId;
	private String _code;
	private String _description;
}