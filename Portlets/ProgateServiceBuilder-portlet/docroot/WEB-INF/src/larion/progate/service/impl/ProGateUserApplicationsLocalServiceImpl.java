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

import java.util.List;

import larion.progate.model.ProGateUserApplications;
import larion.progate.model.ProgateApplicationsSetting;
import larion.progate.service.ProgateApplicationsSettingLocalServiceUtil;
import larion.progate.service.ProgateOrganizationParticipantsLocalServiceUtil;
import larion.progate.service.base.ProGateUserApplicationsLocalServiceBaseImpl;
import larion.progate.service.persistence.ProGateUserApplicationsUtil;
import larion.progate.service.persistence.ProgateOrganizationParticipantsUtil;

/**
 * <a href="ProGateUserApplicationsLocalServiceImpl.java.html"><b><i>View
 * Source</i></b></a>
 * 
 * @author Brian Wing Shun Chan
 * 
 */
public class ProGateUserApplicationsLocalServiceImpl extends
		ProGateUserApplicationsLocalServiceBaseImpl {

	public List<ProGateUserApplications> createDefaultAppForUser(long userId)
			throws com.liferay.portal.SystemException {
		List<ProGateUserApplications> result = null;
		try {
			int roleId = ProgateOrganizationParticipantsUtil
					.findByuserId((int) userId).get(0).getRoleId();
			List<ProgateApplicationsSetting> listDefaultAppByRole = ProgateApplicationsSettingLocalServiceUtil
					.getListDefaultAppByRoleId(roleId);
			for (ProgateApplicationsSetting progateApplicationsSetting : listDefaultAppByRole) {
				ProGateUserApplications object = ProGateUserApplicationsUtil
						.create(null);
				object.setOrgId(0);
				object.setPosition(progateApplicationsSetting
						.getDefaultPosition());
				object.setUserId((int) userId);
				object.setAppsId(progateApplicationsSetting.getAppId());
				ProGateUserApplicationsUtil.update(object, false);
			}

		} catch (Exception e) {
			System.out
					.println("There are some errors in ProGateUserApplicationsLocalServiceImpl.createDefaultAppForUser"
							+ e.toString());
			result = null;
		}
		return result;
	}
}