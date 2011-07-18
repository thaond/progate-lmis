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

package larion.progate.lmis.service.impl;

import java.util.List;

import org.apache.commons.collections.ListUtils;

import larion.progate.lmis.model.LmisEmailSettings;
import larion.progate.lmis.service.base.LmisEmailSettingsLocalServiceBaseImpl;
import larion.progate.lmis.service.persistence.LmisEmailSettingsUtil;

/**
 * <a href="LmisEmailSettingsLocalServiceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisEmailSettingsLocalServiceImpl
	extends LmisEmailSettingsLocalServiceBaseImpl {
	
	public java.util.List<LmisEmailSettings> getListEmailSetting(
			int rootId, int categoryId) {
		try {

			List<LmisEmailSettings> result = ListUtils.intersection(
					LmisEmailSettingsUtil.findByEmailSettingOf(rootId),
					LmisEmailSettingsUtil.findByCategoryId(categoryId));

			System.out.println("Call getListEmailSetting (" + rootId + ","
					+ categoryId + ")");

			return result;
		} catch (Exception e) {
			System.out
					.println("Error LmisEmailSettingsLocalServiceImpl.getListEmailSetting"
							+ e.toString());
		}
		return null;
	}
	
	public int getListEmailSettingDefault(
			int rootId, int categoryId,String emailType) {
		try {

			List<LmisEmailSettings> result = ListUtils.intersection(
					LmisEmailSettingsUtil.findByEmailSettingOf(rootId),
					LmisEmailSettingsUtil.findByCategoryId(categoryId));
			List<LmisEmailSettings> lsType=LmisEmailSettingsUtil.findByEmailType(emailType);
			List<LmisEmailSettings> finaly = ListUtils.intersection(result,lsType);
			System.out.println("Call getListEmailSetting (" + rootId + ","
					+ categoryId + ")");
			if(finaly.size()>0){

			return finaly.get(0).getLmisEmailSettingId();}
			else
				return 0;
		} catch (Exception e) {
			System.out
					.println("Error LmisEmailSettingsLocalServiceImpl.getListEmailSetting"
							+ e.toString());
		}
		return 0;
	}
	
	
	

}