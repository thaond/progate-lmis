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

package larion.progate.cds.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;

import larion.progate.cds.model.CdsLevelStatisticalReport;
import larion.progate.cds.service.base.CdsLevelStatisticalReportLocalServiceBaseImpl;
import larion.progate.cds.service.persistence.CdsLevelStatisticalReportFinderUtil;

/**
 * <a href="CdsLevelStatisticalReportLocalServiceImpl.java.html"><b><i>View
 * Source</i></b></a>
 * 
 * @author Brian Wing Shun Chan
 * 
 */
public class CdsLevelStatisticalReportLocalServiceImpl extends
		CdsLevelStatisticalReportLocalServiceBaseImpl {
	public List<CdsLevelStatisticalReport> getCdsLevelStatisticalReportList(
			int rootId, int userId, int periodId, int competencyId)
			throws SystemException, PortalException {
		try {
			List<CdsLevelStatisticalReport> list = CdsLevelStatisticalReportFinderUtil
					.getCdsLevelStatisticalReport(rootId, userId, periodId,
							competencyId);
			if (list == null)
				list = new ArrayList<CdsLevelStatisticalReport>();
			return list;
		} catch (Exception e) {
			System.out
					.println("ERROR in CdsLevelStatisticalReportLocalServiceImpl.getCdsLevelStatisticalReportList() "
							+ e.toString());
			List<CdsLevelStatisticalReport> list1 = new ArrayList<CdsLevelStatisticalReport>();
			return list1;
		}
	}
}