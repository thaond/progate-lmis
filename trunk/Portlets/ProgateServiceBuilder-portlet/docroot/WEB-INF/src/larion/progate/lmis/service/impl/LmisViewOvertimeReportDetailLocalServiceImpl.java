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

import larion.progate.lmis.model.LmisViewOvertimeReportDetail;
import larion.progate.lmis.service.base.LmisViewOvertimeReportDetailLocalServiceBaseImpl;
import larion.progate.lmis.service.persistence.LmisViewOvertimeReportDetailUtil;

/**
 * <a href="LmisViewOvertimeReportDetailLocalServiceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewOvertimeReportDetailLocalServiceImpl
	extends LmisViewOvertimeReportDetailLocalServiceBaseImpl {
	
	public List<LmisViewOvertimeReportDetail> getListOverTimeRepDetail(int orgId,int reportId) throws com.liferay.portal.SystemException {	
		List<LmisViewOvertimeReportDetail> lsReq = LmisViewOvertimeReportDetailUtil.findByOTRepId(reportId);
		List<LmisViewOvertimeReportDetail> lsOrg = LmisViewOvertimeReportDetailUtil.findByOrgID(orgId);		
		List<LmisViewOvertimeReportDetail> lsResult = ListUtils.intersection(lsOrg, lsReq);		

		return lsResult;
	}	 
}