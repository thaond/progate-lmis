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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * <a href="UserInformationViewPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface UserInformationViewPersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.model.UserInformationView userInformationView);

	public void cacheResult(
		java.util.List<larion.progate.model.UserInformationView> userInformationViews);

	public void clearCache();

	public larion.progate.model.UserInformationView create(
		java.lang.String UserInformationViewId);

	public larion.progate.model.UserInformationView remove(
		java.lang.String UserInformationViewId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserInformationViewException;

	public larion.progate.model.UserInformationView remove(
		larion.progate.model.UserInformationView userInformationView)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.UserInformationView update(
		larion.progate.model.UserInformationView userInformationView)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.UserInformationView update(
		larion.progate.model.UserInformationView userInformationView,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.model.UserInformationView updateImpl(
		larion.progate.model.UserInformationView userInformationView,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.model.UserInformationView findByPrimaryKey(
		java.lang.String UserInformationViewId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserInformationViewException;

	public larion.progate.model.UserInformationView fetchByPrimaryKey(
		java.lang.String UserInformationViewId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.UserInformationView> findByuserId(
		int userId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.UserInformationView> findByuserId(
		int userId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.UserInformationView> findByuserId(
		int userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.UserInformationView findByuserId_First(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserInformationViewException;

	public larion.progate.model.UserInformationView findByuserId_Last(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserInformationViewException;

	public larion.progate.model.UserInformationView[] findByuserId_PrevAndNext(
		java.lang.String UserInformationViewId, int userId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserInformationViewException;

	public java.util.List<larion.progate.model.UserInformationView> findByorgId(
		int orgId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.UserInformationView> findByorgId(
		int orgId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.UserInformationView> findByorgId(
		int orgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.UserInformationView findByorgId_First(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserInformationViewException;

	public larion.progate.model.UserInformationView findByorgId_Last(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserInformationViewException;

	public larion.progate.model.UserInformationView[] findByorgId_PrevAndNext(
		java.lang.String UserInformationViewId, int orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserInformationViewException;

	public java.util.List<larion.progate.model.UserInformationView> findByroleId(
		int roleId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.UserInformationView> findByroleId(
		int roleId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.UserInformationView> findByroleId(
		int roleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.UserInformationView findByroleId_First(
		int roleId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserInformationViewException;

	public larion.progate.model.UserInformationView findByroleId_Last(
		int roleId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserInformationViewException;

	public larion.progate.model.UserInformationView[] findByroleId_PrevAndNext(
		java.lang.String UserInformationViewId, int roleId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserInformationViewException;

	public java.util.List<larion.progate.model.UserInformationView> findByisProActive(
		int isProActive) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.UserInformationView> findByisProActive(
		int isProActive, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.UserInformationView> findByisProActive(
		int isProActive, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.UserInformationView findByisProActive_First(
		int isProActive, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserInformationViewException;

	public larion.progate.model.UserInformationView findByisProActive_Last(
		int isProActive, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserInformationViewException;

	public larion.progate.model.UserInformationView[] findByisProActive_PrevAndNext(
		java.lang.String UserInformationViewId, int isProActive,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserInformationViewException;

	public java.util.List<larion.progate.model.UserInformationView> findBystatus(
		int status) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.UserInformationView> findBystatus(
		int status, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.UserInformationView> findBystatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.UserInformationView findBystatus_First(
		int status, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserInformationViewException;

	public larion.progate.model.UserInformationView findBystatus_Last(
		int status, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserInformationViewException;

	public larion.progate.model.UserInformationView[] findBystatus_PrevAndNext(
		java.lang.String UserInformationViewId, int status,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserInformationViewException;

	public java.util.List<larion.progate.model.UserInformationView> findByjoiningStatus(
		int joiningStatus) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.UserInformationView> findByjoiningStatus(
		int joiningStatus, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.UserInformationView> findByjoiningStatus(
		int joiningStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.UserInformationView findByjoiningStatus_First(
		int joiningStatus, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserInformationViewException;

	public larion.progate.model.UserInformationView findByjoiningStatus_Last(
		int joiningStatus, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserInformationViewException;

	public larion.progate.model.UserInformationView[] findByjoiningStatus_PrevAndNext(
		java.lang.String UserInformationViewId, int joiningStatus,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserInformationViewException;

	public java.util.List<larion.progate.model.UserInformationView> findByscreenName(
		java.lang.String screenName) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.UserInformationView> findByscreenName(
		java.lang.String screenName, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.UserInformationView> findByscreenName(
		java.lang.String screenName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.UserInformationView findByscreenName_First(
		java.lang.String screenName,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserInformationViewException;

	public larion.progate.model.UserInformationView findByscreenName_Last(
		java.lang.String screenName,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserInformationViewException;

	public larion.progate.model.UserInformationView[] findByscreenName_PrevAndNext(
		java.lang.String UserInformationViewId, java.lang.String screenName,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserInformationViewException;

	public java.util.List<larion.progate.model.UserInformationView> findByemailAddress(
		java.lang.String emailAddress)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.UserInformationView> findByemailAddress(
		java.lang.String emailAddress, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.UserInformationView> findByemailAddress(
		java.lang.String emailAddress, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.UserInformationView findByemailAddress_First(
		java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserInformationViewException;

	public larion.progate.model.UserInformationView findByemailAddress_Last(
		java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserInformationViewException;

	public larion.progate.model.UserInformationView[] findByemailAddress_PrevAndNext(
		java.lang.String UserInformationViewId, java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserInformationViewException;

	public java.util.List<larion.progate.model.UserInformationView> findByfirstName(
		java.lang.String firstName) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.UserInformationView> findByfirstName(
		java.lang.String firstName, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.UserInformationView> findByfirstName(
		java.lang.String firstName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.UserInformationView findByfirstName_First(
		java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserInformationViewException;

	public larion.progate.model.UserInformationView findByfirstName_Last(
		java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserInformationViewException;

	public larion.progate.model.UserInformationView[] findByfirstName_PrevAndNext(
		java.lang.String UserInformationViewId, java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserInformationViewException;

	public java.util.List<larion.progate.model.UserInformationView> findBylastName(
		java.lang.String lastName) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.UserInformationView> findBylastName(
		java.lang.String lastName, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.UserInformationView> findBylastName(
		java.lang.String lastName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.UserInformationView findBylastName_First(
		java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserInformationViewException;

	public larion.progate.model.UserInformationView findBylastName_Last(
		java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserInformationViewException;

	public larion.progate.model.UserInformationView[] findBylastName_PrevAndNext(
		java.lang.String UserInformationViewId, java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserInformationViewException;

	public java.util.List<larion.progate.model.UserInformationView> findByisCurrent(
		boolean isCurrent) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.UserInformationView> findByisCurrent(
		boolean isCurrent, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.UserInformationView> findByisCurrent(
		boolean isCurrent, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.UserInformationView findByisCurrent_First(
		boolean isCurrent, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserInformationViewException;

	public larion.progate.model.UserInformationView findByisCurrent_Last(
		boolean isCurrent, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserInformationViewException;

	public larion.progate.model.UserInformationView[] findByisCurrent_PrevAndNext(
		java.lang.String UserInformationViewId, boolean isCurrent,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserInformationViewException;

	public java.util.List<larion.progate.model.UserInformationView> findBysearchInformation(
		java.lang.String searchInformation)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.UserInformationView> findBysearchInformation(
		java.lang.String searchInformation, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.UserInformationView> findBysearchInformation(
		java.lang.String searchInformation, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.UserInformationView findBysearchInformation_First(
		java.lang.String searchInformation,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserInformationViewException;

	public larion.progate.model.UserInformationView findBysearchInformation_Last(
		java.lang.String searchInformation,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserInformationViewException;

	public larion.progate.model.UserInformationView[] findBysearchInformation_PrevAndNext(
		java.lang.String UserInformationViewId,
		java.lang.String searchInformation,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserInformationViewException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.UserInformationView> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.UserInformationView> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.UserInformationView> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByuserId(int userId)
		throws com.liferay.portal.SystemException;

	public void removeByorgId(int orgId)
		throws com.liferay.portal.SystemException;

	public void removeByroleId(int roleId)
		throws com.liferay.portal.SystemException;

	public void removeByisProActive(int isProActive)
		throws com.liferay.portal.SystemException;

	public void removeBystatus(int status)
		throws com.liferay.portal.SystemException;

	public void removeByjoiningStatus(int joiningStatus)
		throws com.liferay.portal.SystemException;

	public void removeByscreenName(java.lang.String screenName)
		throws com.liferay.portal.SystemException;

	public void removeByemailAddress(java.lang.String emailAddress)
		throws com.liferay.portal.SystemException;

	public void removeByfirstName(java.lang.String firstName)
		throws com.liferay.portal.SystemException;

	public void removeBylastName(java.lang.String lastName)
		throws com.liferay.portal.SystemException;

	public void removeByisCurrent(boolean isCurrent)
		throws com.liferay.portal.SystemException;

	public void removeBysearchInformation(java.lang.String searchInformation)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByuserId(int userId)
		throws com.liferay.portal.SystemException;

	public int countByorgId(int orgId)
		throws com.liferay.portal.SystemException;

	public int countByroleId(int roleId)
		throws com.liferay.portal.SystemException;

	public int countByisProActive(int isProActive)
		throws com.liferay.portal.SystemException;

	public int countBystatus(int status)
		throws com.liferay.portal.SystemException;

	public int countByjoiningStatus(int joiningStatus)
		throws com.liferay.portal.SystemException;

	public int countByscreenName(java.lang.String screenName)
		throws com.liferay.portal.SystemException;

	public int countByemailAddress(java.lang.String emailAddress)
		throws com.liferay.portal.SystemException;

	public int countByfirstName(java.lang.String firstName)
		throws com.liferay.portal.SystemException;

	public int countBylastName(java.lang.String lastName)
		throws com.liferay.portal.SystemException;

	public int countByisCurrent(boolean isCurrent)
		throws com.liferay.portal.SystemException;

	public int countBysearchInformation(java.lang.String searchInformation)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;
}