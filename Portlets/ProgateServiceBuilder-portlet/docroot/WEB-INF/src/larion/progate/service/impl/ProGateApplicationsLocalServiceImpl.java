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

import larion.progate.model.ProGateApplications;
import larion.progate.model.ProGateUserApplications;
import larion.progate.service.base.ProGateApplicationsLocalServiceBaseImpl;
import larion.progate.service.persistence.ProGateApplicationsUtil;
import larion.progate.service.persistence.ProGateUserApplicationsUtil;

/**
 * <a href="ProGateApplicationsLocalServiceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateApplicationsLocalServiceImpl
	extends ProGateApplicationsLocalServiceBaseImpl {
	
	public List<ProGateApplications> getListApplicationBaseOnUserId(int userId,
			int start, int end) {
		List<ProGateApplications> result = new ArrayList<ProGateApplications>();
		try {
			List<ProGateUserApplications> listUserApps = ProGateUserApplicationsUtil
					.findByuserId(userId);

			if (end > listUserApps.size()) {
				listUserApps = listUserApps.subList(start, listUserApps.size());
			} else {
				listUserApps = listUserApps.subList(start, end);
			}

			if (listUserApps != null) {
				for (ProGateUserApplications proGateUserApplications : listUserApps) {
					int appId = proGateUserApplications.getAppsId();
					result.add(ProGateApplicationsUtil.findByPrimaryKey(appId));
				}
			}

			return result;
		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("Errors in ProGateUserApplicationsLocalServiceImpl.getListApplicationBaseOnUserId: "
							+ e.toString());
			return null;
		}

	}
}