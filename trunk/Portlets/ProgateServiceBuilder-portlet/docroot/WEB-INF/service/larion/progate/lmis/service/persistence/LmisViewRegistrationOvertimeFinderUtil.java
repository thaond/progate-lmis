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

package larion.progate.lmis.service.persistence;

/**
 * <a href="LmisViewRegistrationOvertimeFinderUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewRegistrationOvertimeFinderUtil {
	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> getListOtReqRoleSpecs(
		int rootId) throws com.liferay.portal.SystemException {
		return getFinder().getListOtReqRoleSpecs(rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> getListOtReqRoleUser(
		int rootId, int userId) {
		return getFinder().getListOtReqRoleUser(rootId, userId);
	}

	public static int countOtRequestPending(int rootId, int userId) {
		return getFinder().countOtRequestPending(rootId, userId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> filterTabOther(
		int rootId, int orgId, int status) {
		return getFinder().filterTabOther(rootId, orgId, status);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewOTApp> filterTabManager(
		int rootId, int orgId, int userId, int status) {
		return getFinder().filterTabManager(rootId, orgId, userId, status);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> filterByDateTabManager(
		int rootId, java.util.Date day, int userId, int status) {
		return getFinder().filterByDateTabManager(rootId, day, userId, status);
	}

	public static LmisViewRegistrationOvertimeFinder getFinder() {
		return _finder;
	}

	public void setFinder(LmisViewRegistrationOvertimeFinder finder) {
		_finder = finder;
	}

	private static LmisViewRegistrationOvertimeFinder _finder;
}