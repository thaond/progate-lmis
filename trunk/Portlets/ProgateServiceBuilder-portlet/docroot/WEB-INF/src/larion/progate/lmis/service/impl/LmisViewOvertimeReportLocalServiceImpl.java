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

import com.liferay.portal.SystemException;


import larion.progate.lmis.model.LmisViewOvertimeReport;

import larion.progate.lmis.service.base.LmisViewOvertimeReportLocalServiceBaseImpl;
import larion.progate.lmis.service.persistence.LmisViewOvertimeReportUtil;


/**
 * <a href="LmisViewOvertimeReportReportLocalServiceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewOvertimeReportLocalServiceImpl
	extends LmisViewOvertimeReportLocalServiceBaseImpl {
	
	
	public List<LmisViewOvertimeReport> getListOverTimeRepRolePM(int rootId,int reportBy) throws com.liferay.portal.SystemException {
		try {
			

			List<larion.progate.lmis.model.LmisViewOvertimeReport> lsRoot = LmisViewOvertimeReportUtil.findByRootID(rootId);
			List<larion.progate.lmis.model.LmisViewOvertimeReport> lsRep = LmisViewOvertimeReportUtil.findByReportedBy(reportBy);
			List<larion.progate.lmis.model.LmisViewOvertimeReport> lsResult = ListUtils.intersection(lsRoot, lsRep);	
			System.out.println("Success:LmisViewOvertimeReport.getListOverTimeRepRolePM");
			return lsResult;
		} catch (SystemException e) {
			System.out
					.println("Error in LmisViewOvertimeReport.getListOverTimeRepRolePM  reportBy has id ="
							+ reportBy);
			e.printStackTrace();
		}
		return null;
	}
	
	

	public List<LmisViewOvertimeReport> getListOverTimeRepRoleBOD(int rootId,int reportBy) throws com.liferay.portal.SystemException {
		try {
			

			List<larion.progate.lmis.model.LmisViewOvertimeReport> lsRoot = LmisViewOvertimeReportUtil.findByRootID(rootId);
			List<larion.progate.lmis.model.LmisViewOvertimeReport> lsRep = LmisViewOvertimeReportUtil.findByReportedBy(reportBy);
			List<larion.progate.lmis.model.LmisViewOvertimeReport> lsResult = ListUtils.intersection(lsRoot, lsRep);	
			System.out.println("Success:LmisViewOvertimeReport.getListOverTimeRepRoleBOD");
			return lsResult;
		} catch (SystemException e) {
			System.out
					.println("Error in LmisViewOvertimeReport.getListOverTimeRepRoleBOD reportBy has id ="
							+ reportBy);
			e.printStackTrace();
		}
		return null;
	}
}