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
import java.util.List;

import larion.progate.lmis.model.LmisEmailSettingDetails;
import larion.progate.lmis.service.LmisEmailSettingDetailsLocalServiceUtil;
import larion.progate.lmis.service.base.LmisEmailSettingDetailsLocalServiceBaseImpl;
import larion.progate.lmis.service.persistence.LmisEmailSettingDetailsUtil;

/**
 * <a href="LmisEmailSettingDetailsLocalServiceImpl.java.html"><b><i>View
 * Source</i></b></a>
 * 
 * @author Brian Wing Shun Chan
 * 
 */
public class LmisEmailSettingDetailsLocalServiceImpl extends
		LmisEmailSettingDetailsLocalServiceBaseImpl {

	@Override
	public boolean updateEmailSettingDetail(int rootId, int emailId,
			ArrayList<Integer> orgid, ArrayList<Integer> userid) {

		try {

			// Xoa het cac record
			List<LmisEmailSettingDetails> lsEmail =	LmisEmailSettingDetailsUtil.findByemailId(emailId);
			
			if (lsEmail != null) {
				System.out.println("lsEmail.size(): " + lsEmail.size());
			} else {
				System.out.println("lsEmail.size(): null");
			}
			for (LmisEmailSettingDetails lmisEmailSettingDetails : lsEmail) {
				System.out.println("lmisEmailSettingDetails: " + lmisEmailSettingDetails.getPrimaryKey());
				LmisEmailSettingDetailsUtil.remove(lmisEmailSettingDetails);
			}
		
			System.out.println("userid: " + userid);
			for (Integer userKey : userid) {
				LmisEmailSettingDetails eUser = LmisEmailSettingDetailsUtil
						.create(null);
				eUser.setUserRelatedId(userKey);
				eUser.setEmailSettingId(emailId);
				LmisEmailSettingDetailsLocalServiceUtil
						.updateLmisEmailSettingDetails(eUser, false);
				System.out.println("eUser: " + eUser.getPrimaryKey());
			}

			for (Integer orgKey : orgid) {
				LmisEmailSettingDetails eOrg = LmisEmailSettingDetailsUtil
						.create(null);
				eOrg.setOrgRelatedId(orgKey);
				eOrg.setEmailSettingId(emailId);
				LmisEmailSettingDetailsLocalServiceUtil
						.updateLmisEmailSettingDetails(eOrg, false);
				System.out.println("eOrg: " + eOrg.getPrimaryKey());
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

	}
}