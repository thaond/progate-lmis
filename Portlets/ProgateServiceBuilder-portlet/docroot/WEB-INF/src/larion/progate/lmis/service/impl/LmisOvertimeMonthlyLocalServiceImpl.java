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

import larion.progate.lmis.model.LmisOvertimeMonthly;
import larion.progate.lmis.model.LmisViewRegistrationOvertime;
import larion.progate.lmis.service.base.LmisOvertimeMonthlyLocalServiceBaseImpl;
import larion.progate.lmis.service.persistence.LmisOvertimeMonthlyUtil;
import larion.progate.lmis.service.persistence.LmisViewRegistrationOvertimeUtil;
import larion.progate.lmis.service.utils.LmisConst;

/**
 * <a href="LmisOvertimeMonthlyLocalServiceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisOvertimeMonthlyLocalServiceImpl
	extends LmisOvertimeMonthlyLocalServiceBaseImpl {
	
	public double countTotalOverTime(int rootId,int orgId,int monthValue,int yearValue) throws SystemException{
		try{
		double total=0;
		List<LmisOvertimeMonthly> lsRoot = LmisOvertimeMonthlyUtil.findByOvertimeMonthlyOf(rootId);
		List<LmisOvertimeMonthly> lsOrg = LmisOvertimeMonthlyUtil.findByOrgID(orgId);
		List<LmisOvertimeMonthly> lsMonth = LmisOvertimeMonthlyUtil.findByMonthValue(monthValue);
		List<LmisOvertimeMonthly> lsYear = LmisOvertimeMonthlyUtil.findByYearValue(yearValue);
		List<LmisOvertimeMonthly> ls= ListUtils.intersection(ListUtils.intersection(lsRoot, lsOrg),lsYear);
		List<LmisOvertimeMonthly> lsFinal=  ListUtils.intersection(ls, lsMonth);
		for (LmisOvertimeMonthly lmisOvertimeMonthly : lsFinal) {
			total+= lmisOvertimeMonthly.getTotalHour();
		}		
		return total;
		} catch (Exception e) {
			System.out.println("Error : " + e.toString());

		}
		return 0;
	}
	
	
	public double getTotalOverTimeBefore21h(int rootId,int userId,int monthValue,int yearValue) throws SystemException{
		try{
		double total=0;
		List<LmisOvertimeMonthly> lsRoot = LmisOvertimeMonthlyUtil.findByOvertimeMonthlyOf(rootId);
		List<LmisOvertimeMonthly> lsUser = LmisOvertimeMonthlyUtil.findByUserID(userId);
		List<LmisOvertimeMonthly> lsMonth = LmisOvertimeMonthlyUtil.findByMonthValue(monthValue);
		List<LmisOvertimeMonthly> lsYear = LmisOvertimeMonthlyUtil.findByYearValue(yearValue);
		List<LmisOvertimeMonthly> lsOt = LmisOvertimeMonthlyUtil.findByOtID(LmisConst.OverTime_Type_Before_21h);
		List<LmisOvertimeMonthly> ls= ListUtils.intersection(ListUtils.intersection(lsRoot, lsUser),lsYear);
		List<LmisOvertimeMonthly> lsFinal=  ListUtils.intersection(ListUtils.intersection(ls, lsMonth),lsOt);			
		return lsFinal.get(0).getTotalHour();
		} catch (Exception e) {
			System.out.println("Error : " + e.toString());

		}
		return 0;
	}
	
	
	public double getTotalOverTimeAfter21h(int rootId,int userId,int monthValue,int yearValue) throws SystemException{
		try{
		double total=0;
		List<LmisOvertimeMonthly> lsRoot = LmisOvertimeMonthlyUtil.findByOvertimeMonthlyOf(rootId);
		List<LmisOvertimeMonthly> lsUser = LmisOvertimeMonthlyUtil.findByUserID(userId);
		List<LmisOvertimeMonthly> lsMonth = LmisOvertimeMonthlyUtil.findByMonthValue(monthValue);
		List<LmisOvertimeMonthly> lsYear = LmisOvertimeMonthlyUtil.findByYearValue(yearValue);
		List<LmisOvertimeMonthly> lsOt = LmisOvertimeMonthlyUtil.findByOtID(LmisConst.OverTime_Type_Between_21h_24h);
		List<LmisOvertimeMonthly> ls= ListUtils.intersection(ListUtils.intersection(lsRoot, lsUser),lsYear);
		List<LmisOvertimeMonthly> lsFinal=  ListUtils.intersection(ListUtils.intersection(ls, lsMonth),lsOt);			
		return lsFinal.get(0).getTotalHour();
		} catch (Exception e) {
			System.out.println("Error : " + e.toString());

		}
		return 0;
	}
	
	
	public double getTotalOverTimeAfter24h(int rootId,int userId,int monthValue,int yearValue) throws SystemException{
		try{
		double total=0;
		List<LmisOvertimeMonthly> lsRoot = LmisOvertimeMonthlyUtil.findByOvertimeMonthlyOf(rootId);
		List<LmisOvertimeMonthly> lsUser = LmisOvertimeMonthlyUtil.findByUserID(userId);
		List<LmisOvertimeMonthly> lsMonth = LmisOvertimeMonthlyUtil.findByMonthValue(monthValue);
		List<LmisOvertimeMonthly> lsYear = LmisOvertimeMonthlyUtil.findByYearValue(yearValue);
		List<LmisOvertimeMonthly> lsOt = LmisOvertimeMonthlyUtil.findByOtID(LmisConst.OverTime_Type_After_24h);
		List<LmisOvertimeMonthly> ls= ListUtils.intersection(ListUtils.intersection(lsRoot, lsUser),lsYear);
		List<LmisOvertimeMonthly> lsFinal=  ListUtils.intersection(ListUtils.intersection(ls, lsMonth),lsOt);			
		return lsFinal.get(0).getTotalHour();
		} catch (Exception e) {
			System.out.println("Error : " + e.toString());

		}
		return 0;
	}
	
}