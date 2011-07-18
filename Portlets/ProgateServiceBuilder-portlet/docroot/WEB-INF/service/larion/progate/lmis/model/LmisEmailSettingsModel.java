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

import com.liferay.portal.model.BaseModel;

/**
 * <a href="LmisEmailSettingsModel.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface LmisEmailSettingsModel extends BaseModel<LmisEmailSettings> {
	public Integer getPrimaryKey();

	public void setPrimaryKey(Integer pk);

	public Integer getLmisEmailSettingId();

	public void setLmisEmailSettingId(Integer lmisEmailSettingId);

	public int getRootId();

	public void setRootId(int rootId);

	public String getEmailName();

	public void setEmailName(String emailName);

	public String getEmailDescription();

	public void setEmailDescription(String emailDescription);

	public String getEmailTemplate();

	public void setEmailTemplate(String emailTemplate);

	public String getEmailType();

	public void setEmailType(String emailType);

	public int getCategory();

	public void setCategory(int category);

	public boolean getToSender();

	public boolean isToSender();

	public void setToSender(boolean toSender);

	public boolean getToPm();

	public boolean isToPm();

	public void setToPm(boolean toPm);

	public boolean getToBod();

	public boolean isToBod();

	public void setToBod(boolean toBod);

	public LmisEmailSettings toEscapedModel();
}