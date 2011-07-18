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

package com.larion.progate.customerRmd.utils;

import java.util.*;

import com.larion.progate.customerRmd.constants.CustomerRmdConst;
import com.larion.progate.customerRmd.constants.RequestConst;

import com.larion.progate.customerRmd.utils.CustomerRmd;
import com.larion.progate.paging.constants.PagingConst;

import larion.progate.model.ProGateOrgCustomer;
import larion.progate.model.ProGateOrgCustomerRepresenter;
import larion.progate.service.ProGateOrgCustomerLocalServiceUtil;
import larion.progate.service.ProGateOrgCustomerRepresenterLocalServiceUtil;

/**
 * <p>
 * Your description here
 * </p>
 * 
 * @author (Your name)
 * 
 */
public class CustomerRmdUtils {

	public static List<CustomerRmd> getListCustomerRmd(int orgId, Map<String, Object> paging) throws Exception {
		
		int pageNum = (Integer)paging.get(PagingConst.CURRENT_PAGE);
		int increment = (Integer)paging.get(PagingConst.INCREMENT);
		
		//System.out.println("pageNum = " + pageNum + ", increment = " + increment);
		
		int startIndex = (pageNum - 1) * increment;
		int endIndex = pageNum * increment;
				
		return getListCustomerRmd(orgId, startIndex, endIndex);
	}
	
	public static List<CustomerRmd> getListCustomerRmd(int orgId, int startIndex, int endIndex) throws Exception {
		
		//System.out.println("startIndex = " + startIndex + ", endIndex = " + endIndex);
		
		List<CustomerRmd> customerRmdList = new ArrayList<CustomerRmd>();
		
		try {		
			if (orgId > 0) {
				List<ProGateOrgCustomerRepresenter> representerList = ProGateOrgCustomerRepresenterLocalServiceUtil.getListCustRepresenterByOrgId(orgId, startIndex, endIndex, true);
				
				if (representerList != null) {
					for (int i = 0; i < representerList.size(); i++) {
						ProGateOrgCustomerRepresenter representerItem = representerList.get(i);
						ProGateOrgCustomer customer = ProGateOrgCustomerLocalServiceUtil.getProGateOrgCustomer(representerItem.getCustomerId());
						
						customerRmdList.add(new CustomerRmd(customer.getCustomerName(), 
															representerItem.getCustomerId(), 
															customer.getCustomerType(), 
															customer.getLogo(), 
															customer.getWebsite(), 
															customer.getDescription(), 
															representerItem.getDisplayName(), 
															representerItem.getRole(), 
															representerItem.getDescription()));
					}
				}
			}
		} catch (Exception e) {
			System.out.println("getListCustomerRmd(" + orgId + ")");
			//e.printStackTrace();
			customerRmdList = null;
		}
		
		return customerRmdList;
	}
}
