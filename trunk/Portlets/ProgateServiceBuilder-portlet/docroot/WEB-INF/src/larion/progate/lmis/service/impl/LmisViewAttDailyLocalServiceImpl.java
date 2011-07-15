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
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.ListUtils;

import com.liferay.portal.SystemException;

import larion.progate.lmis.model.LmisViewAttDaily;
import larion.progate.lmis.model.LmisViewAttdance;
import larion.progate.lmis.service.base.LmisViewAttDailyLocalServiceBaseImpl;
import larion.progate.lmis.service.persistence.LmisViewAttDailyFinderUtil;
import larion.progate.lmis.service.persistence.LmisViewAttDailyUtil;

/**
 * <a href="LmisViewAttDailyLocalServiceImpl.java.html"><b><i>View
 * Source</i></b></a>
 * 
 * @author Brian Wing Shun Chan
 * 
 */
public class LmisViewAttDailyLocalServiceImpl extends
		LmisViewAttDailyLocalServiceBaseImpl {

	@Override
	public List<larion.progate.lmis.model.LmisViewAttDaily> findByRootId(int rootId)
			throws com.liferay.portal.SystemException {
		return LmisViewAttDailyUtil.findByRootId(rootId);
	}


	@Override
	public List<larion.progate.lmis.model.LmisViewAttDaily> getListAttDailyByUserId(
			int userId,int rootId) throws SystemException {
		
		List<LmisViewAttDaily> lsRoot = LmisViewAttDailyUtil.findByRootId(rootId);		
		List<LmisViewAttDaily> lsUser = LmisViewAttDailyUtil.findByUserId(userId);
		List<LmisViewAttDaily> ls = ListUtils.intersection(lsRoot, lsUser);		
		return ls;
	}

	
	@Override
	public List<larion.progate.lmis.model.LmisViewAttDaily> getListAttByRootAndDay(
			int rootId, Date dayValue) throws SystemException {

		try {

			List<LmisViewAttDaily> lsRoot = LmisViewAttDailyUtil.findByRootId(rootId);		
			List<LmisViewAttDaily> lsDate = LmisViewAttDailyUtil.findByDayValue(dayValue);
			List<LmisViewAttDaily> ls = ListUtils.intersection(lsRoot, lsDate);		
			int idCom = 0;		
			for (Iterator<LmisViewAttDaily> iter = ls.iterator(); iter.hasNext();) {
				LmisViewAttDaily lmisViewAttDaily = iter.next();
				if (lmisViewAttDaily.getLmisViewAttDailyId() == idCom) {
					iter.remove();
				}			
				idCom = lmisViewAttDaily.getLmisViewAttDailyId();			
			}		

			System.out.println("Success: LmisViewAttDaily.getListAttByRootAndDay");
			return ls;
		} catch (SystemException e) {
			System.out.println("Error in LmisViewAttDaily  dayValue ="
					+ dayValue);
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public larion.progate.lmis.model.LmisViewAttDaily getAttDetail(int id)
			throws SystemException {

		try {
			LmisViewAttDaily result = LmisViewAttDailyUtil
					.fetchByPrimaryKey(id);

			System.out.println("Success: LmisViewAttDaily.getAttDetail "
					+ result);
			return result;
		} catch (SystemException e) {
			System.out.println("Error in LmisViewAttDailygetAttDetail   id ="
					+ id);
			e.printStackTrace();
		}
		return null;
	}
		
	@Override
	public List<larion.progate.lmis.model.LmisViewAttDaily> getListAttByOrgId(
			int orgId) throws SystemException {

		try {
			List<LmisViewAttDaily> ls = LmisViewAttDailyUtil.findByOrgId(orgId) ;
			System.out.println("Success: LmisViewAttDaily.getListAttByOrgId");
			return ls;
		} catch (SystemException e) {
			System.out.println("Error in LmisViewAttDaily  orgId ="
					+ orgId);
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<larion.progate.lmis.model.LmisViewAttDaily> getListAttByRootAndDayOrg(
			int rootId, Date dayValue,int subOrgId) throws SystemException {

		try {

			/*List<LmisViewAttDaily> lsRoot = LmisViewAttDailyUtil.findByRootId(rootId);
			List<LmisViewAttDaily> lsDate = LmisViewAttDailyUtil.findByDayValue(dayValue);
			List<LmisViewAttDaily> lsOrg = LmisViewAttDailyUtil.findByOrgId(subOrgId);
			List<LmisViewAttDaily> ls = ListUtils.intersection(lsRoot, lsDate);
			List<LmisViewAttDaily> lsResult =  ListUtils.intersection(ls, lsOrg);*/
			
			List<LmisViewAttDaily> lsResult =  LmisViewAttDailyFinderUtil.getListAttByRootAndDay(rootId, dayValue, subOrgId);

			System.out.println("Success: LmisViewAttDaily.getListAttByRootAndDayOrg");
			Set<LmisViewAttDaily> s =  new HashSet();
			List<LmisViewAttDaily> lsr = new ArrayList<LmisViewAttDaily>();
			for (LmisViewAttDaily i : lsResult) {
				if(s.add(i)){
					lsr.add(i);
				}
			}			
			return lsr;
		} catch (Exception e) {
			System.out.println(e.toString());
			System.out.println("Error in LmisViewAttDaily.getListAttByRootAndDayOrg dayValue ="
					+ dayValue + " and  subOrgId = " + subOrgId);			
		}
		return null;
	}
	
	
}