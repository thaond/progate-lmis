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

package larion.progate.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;

/**
 * <a href="UserInformationViewLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface UserInformationViewLocalService {
	public larion.progate.model.UserInformationView addUserInformationView(
		larion.progate.model.UserInformationView userInformationView)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.UserInformationView createUserInformationView(
		java.lang.String UserInformationViewId);

	public void deleteUserInformationView(
		java.lang.String UserInformationViewId)
		throws com.liferay.portal.SystemException,
			com.liferay.portal.PortalException;

	public void deleteUserInformationView(
		larion.progate.model.UserInformationView userInformationView)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public larion.progate.model.UserInformationView getUserInformationView(
		java.lang.String UserInformationViewId)
		throws com.liferay.portal.SystemException,
			com.liferay.portal.PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.model.UserInformationView> getUserInformationViews(
		int start, int end) throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getUserInformationViewsCount()
		throws com.liferay.portal.SystemException;

	public larion.progate.model.UserInformationView updateUserInformationView(
		larion.progate.model.UserInformationView userInformationView)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.UserInformationView updateUserInformationView(
		larion.progate.model.UserInformationView userInformationView,
		boolean merge) throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.model.UserInformationView> getMembersOfOrganization(
		int orgId, int roleId, java.lang.String searchPhrase, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getNumberOfMembersOfOrganization(int orgId, int roleId,
		java.lang.String searchPhrase);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.model.User> getUsersToInvite(
		int orgId, java.lang.String searchPhrase, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getNumberOfUsersToInvite(int orgId, java.lang.String searchPhrase);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.model.UserInformationView> getInvitedUsers(
		int orgId, java.lang.String searchPhrase, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getNumberOfInvitedUsers(int orgId, java.lang.String searchPhrase);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.model.UserInformationView> getWaitingUsers(
		int orgId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getNumberOfWaitingUsers(int orgId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.model.UserInformationView> getOldMembers(
		int orgId, int roleId, java.lang.String searchPhrase, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getNumberOfOldMembers(int orgId, int roleId,
		java.lang.String searchPhrase);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.model.UserInformationView> getListUsersByFilter(
		int orgId, int roleId, int joiningStatus,
		java.lang.String searchPhrase, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.model.UserInformationView> getListUsersByFilter(
		int orgId, int roleId, int joiningStatus, java.lang.String searchPhrase);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.model.UserInformationView> getListUsersByFilter(
		int orgId, int roleId, int joiningStatus, java.lang.Boolean isCurrent,
		java.lang.String searchPhrase);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.model.User> getListUsers(
		int isProactive, int status, java.lang.String searchPhrase, int start,
		int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getNumberOfListUsers(int isProactive, int status,
		java.lang.String searchPhrase);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.model.UserInformationView> getDetailInformationUser(
		int userId, int roleId, java.lang.String searchPhrase, int start,
		int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getNumberOfDetailInformationUser(int userId, int roleId,
		java.lang.String searchPhrase);

	public boolean updateUserRole(int userId, int orgId, int oldRoleId,
		int newRoleId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.model.UserInformationView> getRootOrgsOfUser(
		int userId, int roleId, java.lang.String searchPhrase, int start,
		int end);
}