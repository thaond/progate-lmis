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
 * <a href="LmisViewEmailSettingDetailUserModel.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface LmisViewEmailSettingDetailUserModel extends BaseModel<LmisViewEmailSettingDetailUser> {
	public Integer getPrimaryKey();

	public void setPrimaryKey(Integer pk);

	public Integer getUserRelatedId();

	public void setUserRelatedId(Integer userRelatedId);

	public int getId_();

	public void setId_(int id_);

	public int getRootId();

	public void setRootId(int rootId);

	public String getName();

	public void setName(String name);

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

	public String getEmailType();

	public void setEmailType(String emailType);

	public String getEmailUser();

	public void setEmailUser(String emailUser);

	public LmisViewEmailSettingDetailUser toEscapedModel();
}