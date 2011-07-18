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

import java.util.Date;

import com.liferay.portal.SystemException;

import larion.progate.lmis.model.LmisOverTimeTypes;
import larion.progate.lmis.model.LmisTimeChangeRequests;
import larion.progate.lmis.service.LmisOverTimeSettingsLocalServiceUtil;
import larion.progate.lmis.service.LmisTimeChangeApprovalsLocalServiceUtil;
import larion.progate.lmis.service.base.LmisOverTimeTypesLocalServiceBaseImpl;
import larion.progate.lmis.service.persistence.LmisOverTimeSettingsUtil;
import larion.progate.lmis.service.persistence.LmisOverTimeTypesUtil;
import larion.progate.lmis.service.persistence.LmisTimeChangeRequestsUtil;
import larion.progate.lmis.service.utils.LmisConst;

/**
 * <a href="LmisOverTimeTypesLocalServiceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisOverTimeTypesLocalServiceImpl
	extends LmisOverTimeTypesLocalServiceBaseImpl {
	
	public boolean updateOverTimeTypes(int rootId,int settingId,int dayId,int otId,double coEfficient,String name,String desciption) throws SystemException {
		try {
			
						
				boolean flag = LmisOverTimeSettingsLocalServiceUtil.updateOverTimeSettings(rootId,settingId, dayId, otId, coEfficient, name, desciption);
						
				if (flag == true) {
					try {					
						LmisOverTimeTypes objOver =LmisOverTimeTypesUtil.fetchByPrimaryKey(otId);
						objOver.setName(name);
						objOver.setDescription(desciption);						
						LmisOverTimeTypesUtil.update(objOver, false);
						System.out
								.println("Success: LmisOverTimeTypesLocalServiceImpl.updateOverTimeTypes");
						return true;
					} catch (SystemException e) {
						System.out
								.println("Error in LmisOverTimeTypesLocalServiceImpl.updateOverTimeTypes");
						e.printStackTrace();
						return false;
					}
				} else {
					System.out
							.println("Error in LmisOverTimeTypesLocalServiceImpl.updateOverTimeTypes.updateOverTimeSettings");
					return false;
				}
		
		} catch (SystemException e) {
			System.out
					.println("Error in LmisOverTimeTypesLocalServiceImpl.updateOverTimeTypes"
							+ e.toString());
		}
		return false;
	}
}