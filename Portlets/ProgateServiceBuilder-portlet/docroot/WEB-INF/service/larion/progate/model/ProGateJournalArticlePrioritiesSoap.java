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
 * <a href="ProGateJournalArticlePrioritiesSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateJournalArticlePrioritiesSoap implements Serializable {
	public static ProGateJournalArticlePrioritiesSoap toSoapModel(
		ProGateJournalArticlePriorities model) {
		ProGateJournalArticlePrioritiesSoap soapModel = new ProGateJournalArticlePrioritiesSoap();

		soapModel.setJournalArticlePrioritiesId(model.getJournalArticlePrioritiesId());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static ProGateJournalArticlePrioritiesSoap[] toSoapModels(
		ProGateJournalArticlePriorities[] models) {
		ProGateJournalArticlePrioritiesSoap[] soapModels = new ProGateJournalArticlePrioritiesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProGateJournalArticlePrioritiesSoap[][] toSoapModels(
		ProGateJournalArticlePriorities[][] models) {
		ProGateJournalArticlePrioritiesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProGateJournalArticlePrioritiesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProGateJournalArticlePrioritiesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProGateJournalArticlePrioritiesSoap[] toSoapModels(
		List<ProGateJournalArticlePriorities> models) {
		List<ProGateJournalArticlePrioritiesSoap> soapModels = new ArrayList<ProGateJournalArticlePrioritiesSoap>(models.size());

		for (ProGateJournalArticlePriorities model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProGateJournalArticlePrioritiesSoap[soapModels.size()]);
	}

	public ProGateJournalArticlePrioritiesSoap() {
	}

	public Integer getPrimaryKey() {
		return _journalArticlePrioritiesId;
	}

	public void setPrimaryKey(Integer pk) {
		setJournalArticlePrioritiesId(pk);
	}

	public Integer getJournalArticlePrioritiesId() {
		return _journalArticlePrioritiesId;
	}

	public void setJournalArticlePrioritiesId(
		Integer journalArticlePrioritiesId) {
		_journalArticlePrioritiesId = journalArticlePrioritiesId;
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

	private Integer _journalArticlePrioritiesId;
	private String _name;
	private String _description;
}