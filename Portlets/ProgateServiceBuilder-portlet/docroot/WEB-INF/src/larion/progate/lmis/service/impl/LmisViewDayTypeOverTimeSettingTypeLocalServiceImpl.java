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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.ListUtils;

import larion.progate.lmis.model.LmisEmailSettingDetails;
import larion.progate.lmis.model.LmisOverTimeSettings;
import larion.progate.lmis.model.LmisOverTimeTypes;
import larion.progate.lmis.model.LmisViewDayTypeOverTimeSettingType;
import larion.progate.lmis.service.LmisEmailSettingDetailsLocalServiceUtil;
import larion.progate.lmis.service.LmisOverTimeSettingsLocalServiceUtil;
import larion.progate.lmis.service.LmisOverTimeTypesLocalServiceUtil;
import larion.progate.lmis.service.base.LmisViewDayTypeOverTimeSettingTypeLocalServiceBaseImpl;
import larion.progate.lmis.service.persistence.LmisEmailSettingDetailsUtil;
import larion.progate.lmis.service.persistence.LmisOverTimeSettingsUtil;
import larion.progate.lmis.service.persistence.LmisOverTimeTypesUtil;
import larion.progate.lmis.service.persistence.LmisViewDayTypeOverTimeSettingTypeUtil;
import larion.progate.lmis.service.utils.LmisUtils;

/**
 * <a href="LmisViewDayTypeOverTimeSettingTypeLocalServiceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewDayTypeOverTimeSettingTypeLocalServiceImpl
	extends LmisViewDayTypeOverTimeSettingTypeLocalServiceBaseImpl {
	
	public java.util.List<LmisViewDayTypeOverTimeSettingType> getCoeffieient(int rootId, int dayType) {
		try {
			System.out
			.println("Call getCoeffieient(" + rootId +","+ dayType 	+ ")");
			List<LmisViewDayTypeOverTimeSettingType> lsRoot = LmisViewDayTypeOverTimeSettingTypeUtil.findByRootID(rootId);
//			System.out.println("lsRoot  "+ lsRoot.toString());
			List<LmisViewDayTypeOverTimeSettingType> lsDay=LmisViewDayTypeOverTimeSettingTypeUtil.findByDayType(dayType);
//			System.out.println("lsDay  "+ lsDay.toString());
			List<LmisViewDayTypeOverTimeSettingType> result = ListUtils.intersection(lsRoot,lsDay);
//			System.out.println("result "+ result.toString());			
	
			return result;
		} catch (Exception e) {
			System.out
					.println("Error LmisViewDayTypeOverTimeSettingTypeLocalServiceImpl.getCoeffieient "
							+ e.toString());
		}
		return null;
	}
	
	/*public boolean updateViewDayTypeOverTimeSettingType(
			int rootId,int dayType,int dayId, int otId) {
		
		try {
			List<LmisViewDayTypeOverTimeSettingType> result = ListUtils.intersection(
					LmisViewDayTypeOverTimeSettingTypeUtil.findByRootID(rootId),LmisViewDayTypeOverTimeSettingTypeUtil.findByDayType(dayType));
	
			System.out.println("Content " + result.toString());
		
			// Xoa het cac record
			
			List<LmisOverTimeSettings> overSet = LmisOverTimeSettingsUtil.findByDayID(dayId);
			Iterator<LmisOverTimeSettings> itOver = overSet.iterator();
			while (itOver.hasNext()) {
				LmisOverTimeSettings i = itOver.next();
				System.out.println("Delete OverTimeSettings has ID:"
						+ i.getPrimaryKey());
				LmisOverTimeSettingsLocalServiceUtil.deleteLmisOverTimeSettings(i);						
			}
			
			
			List<LmisOverTimeTypes> overType= LmisOverTimeTypesUtil.fetchByPrimaryKey(lmisOverTimeTypesId)
			Iterator<LmisOverTimeSettings> itOver = overSet.iterator();
			while (itOver.hasNext()) {
				LmisOverTimeSettings i = itOver.next();
				System.out.println("Delete OverTimeSettings has ID:"
						+ i.getPrimaryKey());
				LmisOverTimeSettingsLocalServiceUtil.deleteLmisOverTimeSettings(i);						
			}

			for (int j = 0; j < userid.size(); j++) {
				LmisEmailSettingDetails eUser = LmisEmailSettingDetailsUtil
						.create(null);
				eUser.setUserRelatedId(userid.get(j));
				eUser.setEmailSettingId(emailId);
				LmisEmailSettingDetailsLocalServiceUtil
						.updateLmisEmailSettingDetails(eUser, false);
			}

			for (int k = 0; k < orgid.size(); k++) {
				LmisEmailSettingDetails eOrg = LmisEmailSettingDetailsUtil
						.create(null);
				eOrg.setOrgRelatedId(orgid.get(k));	
				eOrg.setEmailSettingId(emailId);
				LmisEmailSettingDetailsLocalServiceUtil
						.updateLmisEmailSettingDetails(eOrg, false);
			}

			System.out
					.println("Success in LmisEmailSettingDetailsLocalServiceImpl.updateemailSettingDetailOrgUser ");
			return true;

		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("Errors in LmisEmailSettingDetailsLocalServiceImpl.updateemailSettingDetailOrgUser "
							+ e.toString());
			return false;
		}

	}*/
}
		