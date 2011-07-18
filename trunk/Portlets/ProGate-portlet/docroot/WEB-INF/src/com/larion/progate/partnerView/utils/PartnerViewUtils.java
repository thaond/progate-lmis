/**
 * Copyright (c) [Year] [Organization] All rights reserved.
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

package com.larion.progate.partnerView.utils;

import java.util.*;

import com.larion.progate.partnerView.constants.PartnerViewConst;
import com.larion.progate.partnerView.constants.RequestConst;

import larion.progate.model.ProGateOrgCustomer;
import larion.progate.service.ProGateOrgCustomerLocalServiceUtil;

/**
 * <p>
 * Your description here
 * </p>
 * 
 * @author (Your name)
 * 
 */
public class PartnerViewUtils {

	public static List<ProGateOrgCustomer> getListPartner(int orgId, Map<String, Object> paging) throws Exception {
		
		int pageNum = (Integer)paging.get(RequestConst.CURRENT_PAGE);
		int increment = (Integer)paging.get(RequestConst.INCREMENT);
		
		//System.out.println("pageNum = " + pageNum + ", increment = " + increment);
		
		int startIndex = (pageNum - 1) * increment;
		int endIndex = pageNum * increment;
				
		return getListPartner(orgId, startIndex, endIndex);
	}
	
	public static List<ProGateOrgCustomer> getListPartner(int orgId, int startIndex, int endIndex) throws Exception {
		
		//System.out.println("startIndex = " + startIndex + ", endIndex = " + endIndex);
		
		List<ProGateOrgCustomer> partnerList = null;
		
		try {		
			if (orgId > 0) {
				partnerList = ProGateOrgCustomerLocalServiceUtil.getProGateOrgPartners(orgId, startIndex, endIndex);
				
				/*
				for (ProGateOrgCustomer item:partnerList) {
					System.out.println("getPrimaryKey = " + item.getPrimaryKey());
					System.out.println("getLogo = " + item.getLogo());
				}
				*/
			}
		} catch (Exception e) {
			System.out.println("getListPartner(" + orgId + ")");
			//e.printStackTrace();
			partnerList = null;
		}
		
		if (partnerList == null) {
			partnerList = new ArrayList<ProGateOrgCustomer>();
		}
		
		return partnerList;
	}
}
