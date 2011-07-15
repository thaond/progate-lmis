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
 * <a href="LmisEmailSettingsSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisEmailSettingsSoap implements Serializable {
	public static LmisEmailSettingsSoap toSoapModel(LmisEmailSettings model) {
		LmisEmailSettingsSoap soapModel = new LmisEmailSettingsSoap();

		soapModel.setLmisEmailSettingId(model.getLmisEmailSettingId());
		soapModel.setRootId(model.getRootId());
		soapModel.setEmailName(model.getEmailName());
		soapModel.setEmailDescription(model.getEmailDescription());
		soapModel.setEmailTemplate(model.getEmailTemplate());
		soapModel.setEmailType(model.getEmailType());
		soapModel.setCategory(model.getCategory());
		soapModel.setToSender(model.getToSender());
		soapModel.setToPm(model.getToPm());
		soapModel.setToBod(model.getToBod());

		return soapModel;
	}

	public static LmisEmailSettingsSoap[] toSoapModels(
		LmisEmailSettings[] models) {
		LmisEmailSettingsSoap[] soapModels = new LmisEmailSettingsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LmisEmailSettingsSoap[][] toSoapModels(
		LmisEmailSettings[][] models) {
		LmisEmailSettingsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LmisEmailSettingsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LmisEmailSettingsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LmisEmailSettingsSoap[] toSoapModels(
		List<LmisEmailSettings> models) {
		List<LmisEmailSettingsSoap> soapModels = new ArrayList<LmisEmailSettingsSoap>(models.size());

		for (LmisEmailSettings model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LmisEmailSettingsSoap[soapModels.size()]);
	}

	public LmisEmailSettingsSoap() {
	}

	public Integer getPrimaryKey() {
		return _lmisEmailSettingId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisEmailSettingId(pk);
	}

	public Integer getLmisEmailSettingId() {
		return _lmisEmailSettingId;
	}

	public void setLmisEmailSettingId(Integer lmisEmailSettingId) {
		_lmisEmailSettingId = lmisEmailSettingId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public String getEmailName() {
		return _emailName;
	}

	public void setEmailName(String emailName) {
		_emailName = emailName;
	}

	public String getEmailDescription() {
		return _emailDescription;
	}

	public void setEmailDescription(String emailDescription) {
		_emailDescription = emailDescription;
	}

	public String getEmailTemplate() {
		return _emailTemplate;
	}

	public void setEmailTemplate(String emailTemplate) {
		_emailTemplate = emailTemplate;
	}

	public String getEmailType() {
		return _emailType;
	}

	public void setEmailType(String emailType) {
		_emailType = emailType;
	}

	public int getCategory() {
		return _category;
	}

	public void setCategory(int category) {
		_category = category;
	}

	public boolean getToSender() {
		return _toSender;
	}

	public boolean isToSender() {
		return _toSender;
	}

	public void setToSender(boolean toSender) {
		_toSender = toSender;
	}

	public boolean getToPm() {
		return _toPm;
	}

	public boolean isToPm() {
		return _toPm;
	}

	public void setToPm(boolean toPm) {
		_toPm = toPm;
	}

	public boolean getToBod() {
		return _toBod;
	}

	public boolean isToBod() {
		return _toBod;
	}

	public void setToBod(boolean toBod) {
		_toBod = toBod;
	}

	private Integer _lmisEmailSettingId;
	private int _rootId;
	private String _emailName;
	private String _emailDescription;
	private String _emailTemplate;
	private String _emailType;
	private int _category;
	private boolean _toSender;
	private boolean _toPm;
	private boolean _toBod;
}