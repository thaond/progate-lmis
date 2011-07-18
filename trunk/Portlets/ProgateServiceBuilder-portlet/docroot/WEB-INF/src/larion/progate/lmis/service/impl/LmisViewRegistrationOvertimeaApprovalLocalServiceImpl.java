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

import com.liferay.portal.SystemException;
import larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval;
import larion.progate.lmis.service.LmisViewRegistrationOvertimeaApprovalLocalServiceUtil;
import larion.progate.lmis.service.base.LmisViewRegistrationOvertimeaApprovalLocalServiceBaseImpl;
import larion.progate.lmis.service.persistence.LmisOvertimeApprovalsUtil;
import larion.progate.lmis.service.persistence.LmisViewRegistrationOvertimeaApprovalUtil;

/**
 * <a href="LmisViewRegistrationOvertimeaApprovalLocalServiceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewRegistrationOvertimeaApprovalLocalServiceImpl
	extends LmisViewRegistrationOvertimeaApprovalLocalServiceBaseImpl {
	
	@Override
	public ArrayList<Integer> getListOverTimeApproval(int rootId, int approvedBy)
			throws com.liferay.portal.SystemException {

		ArrayList<Integer> arrPmId = new ArrayList<Integer>();
		try {
			List<larion.progate.lmis.model.LmisOvertimeApprovals> lsRoot = LmisOvertimeApprovalsUtil
					.findByOvertimeApprovalsOf(rootId);
			List<larion.progate.lmis.model.LmisOvertimeApprovals> lsApp = LmisOvertimeApprovalsUtil
					.findByApprovedBy(approvedBy);
			List<larion.progate.lmis.model.LmisOvertimeApprovals> lsResult = ListUtils.intersection(lsRoot,lsApp);
			if (lsResult.size() != 0 && lsResult != null ) {
				Iterator<larion.progate.lmis.model.LmisOvertimeApprovals> it = lsResult.iterator();
				while (it.hasNext()) {
					larion.progate.lmis.model.LmisOvertimeApprovals i = it.next();
					if(i.getRequestId()!=0){
					arrPmId.add(i.getRequestId());}
				}
				return arrPmId;
			}
		} catch (SystemException e) {
			System.out.println("Error in LmisViewRegistrationOvertimeaApproval.getListOverTimeApproval");
			e.printStackTrace();
		}
		return null;
	}


	public List<LmisViewRegistrationOvertimeaApproval> getListApproval(	int rootId, int approvedBy)		throws com.liferay.portal.SystemException {
		try {
			ArrayList<Integer> arrPmID = LmisViewRegistrationOvertimeaApprovalLocalServiceUtil
					.getListOverTimeApproval(rootId, approvedBy);
			System.out.println("Content " + arrPmID.toString());
			List<LmisViewRegistrationOvertimeaApproval> ls = new ArrayList<LmisViewRegistrationOvertimeaApproval>();
			for (int i : arrPmID) {
				LmisViewRegistrationOvertimeaApproval obj = LmisViewRegistrationOvertimeaApprovalUtil
						.fetchByPrimaryKey(i);
				ls.add(obj);
			}
			System.out
					.println("Success: LmisViewRegistrationOvertimeaApproval.getListApproval");
			return ls;
		} catch (SystemException e) {
			System.out
					.println("Error in LmisViewRegistrationOvertimeaApproval  approvedBy has id =" + approvedBy);
			e.printStackTrace();			
		}		
		return null;
	}
}