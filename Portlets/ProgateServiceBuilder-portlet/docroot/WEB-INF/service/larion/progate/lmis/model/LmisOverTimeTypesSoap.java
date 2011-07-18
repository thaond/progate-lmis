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
 * <a href="LmisOverTimeTypesSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisOverTimeTypesSoap implements Serializable {
	public static LmisOverTimeTypesSoap toSoapModel(LmisOverTimeTypes model) {
		LmisOverTimeTypesSoap soapModel = new LmisOverTimeTypesSoap();

		soapModel.setLmisOverTimeTypesId(model.getLmisOverTimeTypesId());
		soapModel.setRootId(model.getRootId());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static LmisOverTimeTypesSoap[] toSoapModels(
		LmisOverTimeTypes[] models) {
		LmisOverTimeTypesSoap[] soapModels = new LmisOverTimeTypesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LmisOverTimeTypesSoap[][] toSoapModels(
		LmisOverTimeTypes[][] models) {
		LmisOverTimeTypesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LmisOverTimeTypesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LmisOverTimeTypesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LmisOverTimeTypesSoap[] toSoapModels(
		List<LmisOverTimeTypes> models) {
		List<LmisOverTimeTypesSoap> soapModels = new ArrayList<LmisOverTimeTypesSoap>(models.size());

		for (LmisOverTimeTypes model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LmisOverTimeTypesSoap[soapModels.size()]);
	}

	public LmisOverTimeTypesSoap() {
	}

	public Integer getPrimaryKey() {
		return _lmisOverTimeTypesId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisOverTimeTypesId(pk);
	}

	public Integer getLmisOverTimeTypesId() {
		return _lmisOverTimeTypesId;
	}

	public void setLmisOverTimeTypesId(Integer lmisOverTimeTypesId) {
		_lmisOverTimeTypesId = lmisOverTimeTypesId;
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

	private Integer _lmisOverTimeTypesId;
	private int _rootId;
	private String _name;
	private String _description;
}