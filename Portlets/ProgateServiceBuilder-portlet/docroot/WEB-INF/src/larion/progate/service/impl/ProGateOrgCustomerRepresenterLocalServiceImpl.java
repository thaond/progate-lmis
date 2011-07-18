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

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.ListUtils;

import larion.progate.model.ProGateOrgCustomerRepresenter;
import larion.progate.service.base.ProGateOrgCustomerRepresenterLocalServiceBaseImpl;
import larion.progate.service.persistence.ProGateOrgCustomerRepresenterUtil;

/**
 * <a href="ProGateOrgCustomerRepresenterLocalServiceImpl.java.html"><b><i>View
 * Source</i></b></a>
 * 
 * @author Brian Wing Shun Chan
 * 
 */
public class ProGateOrgCustomerRepresenterLocalServiceImpl extends
		ProGateOrgCustomerRepresenterLocalServiceBaseImpl {

	public ProGateOrgCustomerRepresenter createCustRepresenter(
			String firstName, String lastName, String role, String description,
			int customerId, int orgId) {
		try {
			ProGateOrgCustomerRepresenter object = ProGateOrgCustomerRepresenterUtil
					.create(null);
			object.setDescription(description);
			object.setFirstName(firstName);
			object.setLastName(lastName);
			object.setDisplayName(firstName + " " + lastName);
			object.setCustomerId(customerId);
			object.setRole(role);
			object.setModifiedDate(new Date());
			object.setCreatedDate(new Date());
			object.setOrgId(orgId);

			ProGateOrgCustomerRepresenterUtil.update(object, false);
			return object;
		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("Errors in ProGateOrgCustomerRepresenterLocalServiceImpl.createOrgRepresenter: "
							+ e.toString());
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<ProGateOrgCustomerRepresenter> getListCustRepresenterByOrgId(
			int orgId, int start, int end, boolean hasDescription) {
		try {
			List<ProGateOrgCustomerRepresenter> listCustomerRepresenter;
			List<ProGateOrgCustomerRepresenter> result = null;

			if (hasDescription) {
				listCustomerRepresenter = ListUtils.subtract(ListUtils
						.intersection(ProGateOrgCustomerRepresenterUtil
								.findByorgId(orgId),
								ProGateOrgCustomerRepresenterUtil.findAll()),
						ProGateOrgCustomerRepresenterUtil
								.findBydescription(null));
			} else {
				listCustomerRepresenter = ListUtils.intersection(
						ProGateOrgCustomerRepresenterUtil.findByorgId(orgId),
						ProGateOrgCustomerRepresenterUtil.findAll());
			}

			if (end > listCustomerRepresenter.size()) {
				result = listCustomerRepresenter.subList(start,
						listCustomerRepresenter.size());
			} else {
				result = listCustomerRepresenter.subList(start, end);
			}
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("Errors in ProGateOrgCustomerRepresenterLocalServiceImpl.getListCustRepresenterByOrgId: "
							+ e.toString());
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<ProGateOrgCustomerRepresenter> getListCustRepresenterByCustId(
			int custId, int start, int end, boolean hasDescription) {
		try {
			List<ProGateOrgCustomerRepresenter> listCustomerRepresenter;
			List<ProGateOrgCustomerRepresenter> result = null;

			if (hasDescription) {
				listCustomerRepresenter = ListUtils.subtract(ListUtils
						.intersection(ProGateOrgCustomerRepresenterUtil
								.findBycustomerId(custId),
								ProGateOrgCustomerRepresenterUtil.findAll()),
						ProGateOrgCustomerRepresenterUtil
								.findBydescription(null));
			} else {
				listCustomerRepresenter = ListUtils.intersection(
						ProGateOrgCustomerRepresenterUtil
								.findBycustomerId(custId),
						ProGateOrgCustomerRepresenterUtil.findAll());
			}

			if (end > listCustomerRepresenter.size()) {
				result = listCustomerRepresenter.subList(start,
						listCustomerRepresenter.size());
			} else {
				result = listCustomerRepresenter.subList(start, end);
			}
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("Errors in ProGateOrgCustomerRepresenterLocalServiceImpl.getListCustRepresenterByCustId: "
							+ e.toString());
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public int cListCustRepresenterByCustId(int custId, boolean hasDescription) {
		try {
			List<ProGateOrgCustomerRepresenter> listCustomerRepresenter;

			if (hasDescription) {
				listCustomerRepresenter = ListUtils.subtract(ListUtils
						.intersection(ProGateOrgCustomerRepresenterUtil
								.findBycustomerId(custId),
								ProGateOrgCustomerRepresenterUtil.findAll()),
						ProGateOrgCustomerRepresenterUtil
								.findBydescription(null));
			} else {
				listCustomerRepresenter = ListUtils.intersection(
						ProGateOrgCustomerRepresenterUtil
								.findBycustomerId(custId),
						ProGateOrgCustomerRepresenterUtil.findAll());
			}

			if (listCustomerRepresenter != null) {
				return listCustomerRepresenter.size();
			} else {
				return 0;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("Errors in ProGateOrgCustomerRepresenterLocalServiceImpl.getListCustRepresenterByCustId: "
							+ e.toString());
			return 0;
		}
	}

	@SuppressWarnings("unchecked")
	public int countListCustRepresenterByOrgId(int orgId, boolean hasDescription) {
		try {
			List<ProGateOrgCustomerRepresenter> listCustomerRepresenter;

			if (hasDescription) {
				listCustomerRepresenter = ListUtils.subtract(ListUtils
						.intersection(ProGateOrgCustomerRepresenterUtil
								.findByorgId(orgId),
								ProGateOrgCustomerRepresenterUtil.findAll()),
						ProGateOrgCustomerRepresenterUtil
								.findBydescription(null));
			} else {
				listCustomerRepresenter = ListUtils.intersection(
						ProGateOrgCustomerRepresenterUtil.findByorgId(orgId),
						ProGateOrgCustomerRepresenterUtil.findAll());
			}

			if (listCustomerRepresenter != null) {
				return listCustomerRepresenter.size();
			} else {
				return 0;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("Errors in ProGateOrgCustomerRepresenterLocalServiceImpl.getListCustRepresenterByCustId: "
							+ e.toString());
			return 0;
		}
	}

	@SuppressWarnings("unchecked")
	public int countListCustRepresenterByCustId(int customerId) {
		try {
			List<ProGateOrgCustomerRepresenter> listCustomerRepresenter;
			int result = 0;
			listCustomerRepresenter = ListUtils.intersection(
					ProGateOrgCustomerRepresenterUtil
							.findBycustomerId(customerId),
					ProGateOrgCustomerRepresenterUtil.findAll());
			if (listCustomerRepresenter != null) {
				result = listCustomerRepresenter.size();
			}
			return result;

		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("Errors in ProGateOrgCustomerRepresenterLocalServiceImpl.countListCustRepresenterByCustId: "
							+ e.toString());
			return 0;
		}
	}
}
