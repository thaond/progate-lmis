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
 * <a href="LmisEmailSettingDetailsSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisEmailSettingDetailsSoap implements Serializable {
	public static LmisEmailSettingDetailsSoap toSoapModel(
		LmisEmailSettingDetails model) {
		LmisEmailSettingDetailsSoap soapModel = new LmisEmailSettingDetailsSoap();

		soapModel.setLmisEmailSettingDetailId(model.getLmisEmailSettingDetailId());
		soapModel.setEmailSettingId(model.getEmailSettingId());
		soapModel.setOrgRelatedId(model.getOrgRelatedId());
		soapModel.setUserRelatedId(model.getUserRelatedId());

		return soapModel;
	}

	public static LmisEmailSettingDetailsSoap[] toSoapModels(
		LmisEmailSettingDetails[] models) {
		LmisEmailSettingDetailsSoap[] soapModels = new LmisEmailSettingDetailsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LmisEmailSettingDetailsSoap[][] toSoapModels(
		LmisEmailSettingDetails[][] models) {
		LmisEmailSettingDetailsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LmisEmailSettingDetailsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LmisEmailSettingDetailsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LmisEmailSettingDetailsSoap[] toSoapModels(
		List<LmisEmailSettingDetails> models) {
		List<LmisEmailSettingDetailsSoap> soapModels = new ArrayList<LmisEmailSettingDetailsSoap>(models.size());

		for (LmisEmailSettingDetails model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LmisEmailSettingDetailsSoap[soapModels.size()]);
	}

	public LmisEmailSettingDetailsSoap() {
	}

	public Integer getPrimaryKey() {
		return _lmisEmailSettingDetailId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisEmailSettingDetailId(pk);
	}

	public Integer getLmisEmailSettingDetailId() {
		return _lmisEmailSettingDetailId;
	}

	public void setLmisEmailSettingDetailId(Integer lmisEmailSettingDetailId) {
		_lmisEmailSettingDetailId = lmisEmailSettingDetailId;
	}

	public int getEmailSettingId() {
		return _emailSettingId;
	}

	public void setEmailSettingId(int emailSettingId) {
		_emailSettingId = emailSettingId;
	}

	public int getOrgRelatedId() {
		return _orgRelatedId;
	}

	public void setOrgRelatedId(int orgRelatedId) {
		_orgRelatedId = orgRelatedId;
	}

	public int getUserRelatedId() {
		return _userRelatedId;
	}

	public void setUserRelatedId(int userRelatedId) {
		_userRelatedId = userRelatedId;
	}

	private Integer _lmisEmailSettingDetailId;
	private int _emailSettingId;
	private int _orgRelatedId;
	private int _userRelatedId;
}