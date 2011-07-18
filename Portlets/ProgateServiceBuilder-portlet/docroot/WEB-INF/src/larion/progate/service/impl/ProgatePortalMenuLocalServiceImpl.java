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

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.ListUtils;

import larion.progate.model.ProgatePortalMenu;
import larion.progate.service.ProGateRolesLocalServiceUtil;
import larion.progate.service.base.ProgatePortalMenuLocalServiceBaseImpl;
import larion.progate.service.persistence.ProgatePortalMenuUtil;

/**
 * <a href="ProgatePortalMenuLocalServiceImpl.java.html"><b><i>View
 * Source</i></b></a>
 * 
 * @author Brian Wing Shun Chan
 * 
 */
public class ProgatePortalMenuLocalServiceImpl extends
		ProgatePortalMenuLocalServiceBaseImpl {

	@Override
	@SuppressWarnings("unchecked")
	public List<ProgatePortalMenu> getProgatePortalMenus(int orgId, int roleId,
			int start, int end) {
		try {
			List<ProgatePortalMenu> result = new ArrayList<ProgatePortalMenu>();
			List<ProgatePortalMenu> listData = ListUtils.intersection(
					ProgatePortalMenuUtil.findByorgId(orgId),
					ProgatePortalMenuUtil.findByroleId(roleId));
			if (end > listData.size()) {
				result = listData.subList(start, listData.size());
			} else {
				result = listData.subList(start, end);
			}
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("There are some errors in "
					+ this.getClass().getName() + ".getProgatePortalMenus "
					+ e.toString());
			return null;
		}
	}

	public List<ProgatePortalMenu> getProgatePortalMenus(int orgId, int roleId) {
		try {
			List<ProgatePortalMenu> result = new ArrayList<ProgatePortalMenu>();

			int priorityOfRole = ProGateRolesLocalServiceUtil.getProGateRoles(
					roleId).getPriority();

			List<ProgatePortalMenu> listMenuByOrgId = ProgatePortalMenuUtil
					.findByorgId(orgId);

			for (ProgatePortalMenu portalMenu : listMenuByOrgId) {
				if (priorityOfRole >= ProGateRolesLocalServiceUtil
						.getProGateRoles(portalMenu.getRoleId()).getPriority()) {
					result.add(portalMenu);
				}
			}

			return result;
		} catch (Exception e) {
			System.out.println("There are some errors in "
					+ this.getClass().getName() + ".getProgatePortalMenus "
					+ e.toString());
			return null;
		}
	}
}