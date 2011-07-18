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

package larion.progate.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.ListUtils;

import larion.progate.model.ProGateOrgCustomer;
import larion.progate.service.base.ProGateOrgCustomerLocalServiceBaseImpl;
import larion.progate.service.persistence.ProGateOrgCustomerUtil;

/**
 * <a href="ProGateOrgCustomerLocalServiceImpl.java.html"><b><i>View
 * Source</i></b></a>
 * 
 * @author Brian Wing Shun Chan
 * 
 */
public class ProGateOrgCustomerLocalServiceImpl extends
		ProGateOrgCustomerLocalServiceBaseImpl {

	public ProGateOrgCustomer createCustomerOrgProfile(String customerName,
			String description, int customerType, String logo, String website,
			boolean orgMap, String orgMapUrl, int orgId)
			throws com.liferay.portal.SystemException {
		try {
			List<ProGateOrgCustomer> checkCustName = ProGateOrgCustomerUtil
					.findBycustomerName(customerName);
			List<ProGateOrgCustomer> checkOrgId = ProGateOrgCustomerUtil
					.findByorgId(orgId);
			@SuppressWarnings("unchecked")
			List<ProGateOrgCustomer> checkOrg = ListUtils.intersection(
					checkCustName, checkOrgId);
			if ((checkOrg != null) && (checkOrg.size() > 0)) {
				return null;
			} else {
				ProGateOrgCustomer org = ProGateOrgCustomerUtil.create(null);
				org.setCustomerName(customerName);
				org.setDescription(description);
				org.setCustomerType(customerType);
				org.setCreatedDate(new Date());
				org.setModifiedDate(new Date());
				org.setWebsite(website);
				org.setLogo(logo);
				org.setHasOrgMap(orgMap);
				org.setUrlOrgMap(orgMapUrl);
				org.setOrgId(orgId);

				ProGateOrgCustomerUtil.update(org, false);
				return org;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("Errors in ProGateOrgCustomerLocalServiceImpl.createCustomerOrgProfile: "
							+ e.toString());
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	public List<ProGateOrgCustomer> getProGateOrgCusts(int orgId, int start,
			int end) throws com.liferay.portal.SystemException {
		try {
			List<ProGateOrgCustomer> result = null;
			List<ProGateOrgCustomer> temp = null;
			temp = ListUtils.intersection(
					ProGateOrgCustomerUtil.findByorgId(orgId),
					ProGateOrgCustomerUtil.findBycustomerTypeLower(1));

			if (end > temp.size()) {
				result = temp.subList(start, temp.size());
			} else {
				result = temp.subList(start, end);
			}
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("Errors in ProGateOrgCustomerLocalServiceImpl.getProGateOrgCusts: "
							+ e.toString());
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<ProGateOrgCustomer> getProGateOrgPartners(int orgId, int start,
			int end) throws com.liferay.portal.SystemException {
		try {
			List<ProGateOrgCustomer> result = null;
			List<ProGateOrgCustomer> temp = null;
			temp = ListUtils.intersection(
					ProGateOrgCustomerUtil.findByorgId(orgId),
					ProGateOrgCustomerUtil.findBycustomerTypeGreater(1));

			if (end > temp.size()) {
				result = temp.subList(start, temp.size());
			} else {
				result = temp.subList(start, end);
			}
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("Errors in ProGateOrgCustomerLocalServiceImpl.getProGateOrgPartners: "
							+ e.toString());
			return null;
		}
	}

	public List<ProGateOrgCustomer> getProGateOrgCustomers(int orgId,
			int start, int end) throws com.liferay.portal.SystemException {
		try {
			List<ProGateOrgCustomer> result = null;
			List<ProGateOrgCustomer> temp = null;
			temp = ProGateOrgCustomerUtil.findByorgId(orgId);

			if (end > temp.size()) {
				result = temp.subList(start, temp.size());
			} else {
				result = temp.subList(start, end);
			}
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("Errors in ProGateOrgCustomerLocalServiceImpl.getProGateOrgPartners: "
							+ e.toString());
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public int countProGateOrgCusts(int orgId)
			throws com.liferay.portal.SystemException {
		try {
			List<ProGateOrgCustomer> temp = null;
			temp = ListUtils.intersection(
					ProGateOrgCustomerUtil.findByorgId(orgId),
					ProGateOrgCustomerUtil.findBycustomerTypeLower(1));

			if (temp != null) {
				return temp.size();
			} else {
				return 0;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("Errors in ProGateOrgCustomerLocalServiceImpl.countProGateOrgCusts: "
							+ e.toString());
			return 0;
		}
	}

	@SuppressWarnings("unchecked")
	public int countProGateOrgPartners(int orgId) throws com.liferay.portal.SystemException {
		try {
			List<ProGateOrgCustomer> temp = null;
			temp = ListUtils.intersection(
					ProGateOrgCustomerUtil.findByorgId(orgId),
					ProGateOrgCustomerUtil.findBycustomerTypeGreater(1));

			if (temp != null) {
				return temp.size();
			} else {
				return 0;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("Errors in ProGateOrgCustomerLocalServiceImpl.countProGateOrgPartners: "
							+ e.toString());
			return 0;
		}
	}

	public int countProGateOrgCustomers(int orgId) throws com.liferay.portal.SystemException {
		try {
			List<ProGateOrgCustomer> temp = null;
			temp = ProGateOrgCustomerUtil.findByorgId(orgId);

			if (temp != null) {
				return temp.size();
			} else {
				return 0;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("Errors in ProGateOrgCustomerLocalServiceImpl.countProGateOrgCustomers: "
							+ e.toString());
			return 0;
		}
	}
	
	

	@SuppressWarnings("unchecked")
	public boolean validateCustName(String customerName, int orgId)
			throws com.liferay.portal.SystemException {
		List<ProGateOrgCustomer> checkOrg;
		try {
			List<ProGateOrgCustomer> checkCustName = ProGateOrgCustomerUtil
					.findBycustomerName(customerName);
			List<ProGateOrgCustomer> checkOrgId = ProGateOrgCustomerUtil
					.findByorgId(orgId);
			checkOrg = ListUtils.intersection(checkCustName, checkOrgId);

		} catch (Exception e) {
			System.out
					.println("Errors in ProGateOrgCustomerLocalServiceImpl.validateCustName: "
							+ e.toString());
			return false;
		}
		return ((checkOrg == null) || (checkOrg.size() == 0)) ? true : false;
	}

	public boolean deleteProGateOrgCustomer(int cusId) {
		try {
			ProGateOrgCustomerUtil.remove(cusId);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("Errors in ProGateOrgCustomerLocalServiceImpl.deleteProGateOrgCustomer: "
							+ e.toString());
			return false;
		}

	}
	
	
	public void testErrors(){
		try {
			throw new Exception();
		} catch (Exception e) {
			// TODO: handle exception
			Date todaysDate = new java.util.Date();
			SimpleDateFormat formatter = new SimpleDateFormat("EEE, dd-MMM-yyyy HH:mm:ss. ");

			String formattedDate = formatter.format(todaysDate);
			System.out
			.println(formattedDate + " sfsfg : "
					+ e.toString());
		}
	}
	
}