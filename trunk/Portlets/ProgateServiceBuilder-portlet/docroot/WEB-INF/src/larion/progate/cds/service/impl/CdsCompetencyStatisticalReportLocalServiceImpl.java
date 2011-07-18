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

import larion.progate.cds.model.CdsCompetencyStatisticalReport;
import larion.progate.cds.service.base.CdsCompetencyStatisticalReportLocalServiceBaseImpl;
import larion.progate.cds.service.persistence.CdsCompetencyStatisticalReportFinderUtil;

/**
 * <a href="CdsCompetencyStatisticalReportLocalServiceImpl.java.html"><b><i>View
 * Source</i></b></a>
 * 
 * @author Brian Wing Shun Chan
 * 
 */
public class CdsCompetencyStatisticalReportLocalServiceImpl extends
		CdsCompetencyStatisticalReportLocalServiceBaseImpl {
	public List<CdsCompetencyStatisticalReport> getCdsCompetencyStatisticalReportList(
			int rootId, int userId, int periodId) throws SystemException,
			PortalException {
		try {
			List<CdsCompetencyStatisticalReport> list = CdsCompetencyStatisticalReportFinderUtil
					.getCdsCompetencyStatisticalReport(rootId, userId, periodId);
			if (list == null)
				list = new ArrayList<CdsCompetencyStatisticalReport>();
			return list;
		} catch (Exception e) {
			System.out
					.println("ERROR in CdsCompetencyStatisticalReportLocalServiceImpl.getCdsCompetencyStatisticalReportList() "
							+ e.toString());
			List<CdsCompetencyStatisticalReport> list1 = new ArrayList<CdsCompetencyStatisticalReport>();
			return list1;
		}
	}

	// lay ra LevelRankingValue
	public String getLevelRankingValue(int rootId, int userId, int periodId,
			int competencyId) throws SystemException, PortalException {
		try {
			List<CdsCompetencyStatisticalReport> list = CdsCompetencyStatisticalReportFinderUtil
					.getCdsCompetencyStatisticalReportByCompetencyId(rootId,
							userId, periodId, competencyId);
			if (list == null) {
				String a = "N/A";
				return a;
			}
			String rong="";
			if (list.get(0).getLevelRankingValue().compareTo(rong) == 0) {
				String b = "N/A";
				return b;
			} else
				return list.get(0).getLevelRankingValue();
		} catch (Exception e) {
			System.out
					.println("ERROR in CdsCompetencyStatisticalReportLocalServiceImpl.getLevelRankingValue() "
							+ e.toString());
			String c = "N/A";
			return c;
		}
	}
}