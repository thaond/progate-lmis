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
 * <a href="ProGateJournalArticleTypesSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateJournalArticleTypesSoap implements Serializable {
	public static ProGateJournalArticleTypesSoap toSoapModel(
		ProGateJournalArticleTypes model) {
		ProGateJournalArticleTypesSoap soapModel = new ProGateJournalArticleTypesSoap();

		soapModel.setJournalArticleTypesId(model.getJournalArticleTypesId());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static ProGateJournalArticleTypesSoap[] toSoapModels(
		ProGateJournalArticleTypes[] models) {
		ProGateJournalArticleTypesSoap[] soapModels = new ProGateJournalArticleTypesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProGateJournalArticleTypesSoap[][] toSoapModels(
		ProGateJournalArticleTypes[][] models) {
		ProGateJournalArticleTypesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProGateJournalArticleTypesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProGateJournalArticleTypesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProGateJournalArticleTypesSoap[] toSoapModels(
		List<ProGateJournalArticleTypes> models) {
		List<ProGateJournalArticleTypesSoap> soapModels = new ArrayList<ProGateJournalArticleTypesSoap>(models.size());

		for (ProGateJournalArticleTypes model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProGateJournalArticleTypesSoap[soapModels.size()]);
	}

	public ProGateJournalArticleTypesSoap() {
	}

	public Integer getPrimaryKey() {
		return _journalArticleTypesId;
	}

	public void setPrimaryKey(Integer pk) {
		setJournalArticleTypesId(pk);
	}

	public Integer getJournalArticleTypesId() {
		return _journalArticleTypesId;
	}

	public void setJournalArticleTypesId(Integer journalArticleTypesId) {
		_journalArticleTypesId = journalArticleTypesId;
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

	private Integer _journalArticleTypesId;
	private String _name;
	private String _description;
}