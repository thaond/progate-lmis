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

package larion.progate.service.persistence;

/**
 * <a href="UserInformationViewFinderUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class UserInformationViewFinderUtil {
	public static java.util.List<larion.progate.model.User> findUsersToInvite(
		int orgId, java.lang.String searchPhrase)
		throws com.liferay.portal.SystemException {
		return getFinder().findUsersToInvite(orgId, searchPhrase);
	}

	public static java.util.List<larion.progate.model.UserInformationView> findOldMembers(
		int orgId, int roleId, java.lang.String searchPhrase) {
		return getFinder().findOldMembers(orgId, roleId, searchPhrase);
	}

	public static java.util.List<larion.progate.model.User> findListUsers(
		int isProactive, int status, java.lang.String searchPhrase)
		throws com.liferay.portal.SystemException {
		return getFinder().findListUsers(isProactive, status, searchPhrase);
	}

	public static java.util.List<larion.progate.model.UserInformationView> findUserInformationViewDetail(
		int userId, int roleId, java.lang.String searchPhrase)
		throws com.liferay.portal.SystemException {
		return getFinder()
				   .findUserInformationViewDetail(userId, roleId, searchPhrase);
	}

	public static UserInformationViewFinder getFinder() {
		return _finder;
	}

	public void setFinder(UserInformationViewFinder finder) {
		_finder = finder;
	}

	private static UserInformationViewFinder _finder;
}