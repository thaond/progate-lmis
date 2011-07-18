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
 * <a href="UserUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class UserUtil {
	public static void cacheResult(larion.progate.model.User user) {
		getPersistence().cacheResult(user);
	}

	public static void cacheResult(
		java.util.List<larion.progate.model.User> users) {
		getPersistence().cacheResult(users);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.model.User create(java.lang.Integer userid) {
		return getPersistence().create(userid);
	}

	public static larion.progate.model.User remove(java.lang.Integer userid)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserException {
		return getPersistence().remove(userid);
	}

	public static larion.progate.model.User remove(
		larion.progate.model.User user)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(user);
	}

	public static larion.progate.model.User update(
		larion.progate.model.User user)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(user);
	}

	public static larion.progate.model.User update(
		larion.progate.model.User user, boolean merge)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(user, merge);
	}

	public static larion.progate.model.User updateImpl(
		larion.progate.model.User user, boolean merge)
		throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(user, merge);
	}

	public static larion.progate.model.User findByPrimaryKey(
		java.lang.Integer userid)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserException {
		return getPersistence().findByPrimaryKey(userid);
	}

	public static larion.progate.model.User fetchByPrimaryKey(
		java.lang.Integer userid) throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(userid);
	}

	public static java.util.List<larion.progate.model.User> findByscreenname(
		java.lang.String screenname) throws com.liferay.portal.SystemException {
		return getPersistence().findByscreenname(screenname);
	}

	public static java.util.List<larion.progate.model.User> findByscreenname(
		java.lang.String screenname, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByscreenname(screenname, start, end);
	}

	public static java.util.List<larion.progate.model.User> findByscreenname(
		java.lang.String screenname, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByscreenname(screenname, start, end, obc);
	}

	public static larion.progate.model.User findByscreenname_First(
		java.lang.String screenname,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserException {
		return getPersistence().findByscreenname_First(screenname, obc);
	}

	public static larion.progate.model.User findByscreenname_Last(
		java.lang.String screenname,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserException {
		return getPersistence().findByscreenname_Last(screenname, obc);
	}

	public static larion.progate.model.User[] findByscreenname_PrevAndNext(
		java.lang.Integer userid, java.lang.String screenname,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserException {
		return getPersistence()
				   .findByscreenname_PrevAndNext(userid, screenname, obc);
	}

	public static java.util.List<larion.progate.model.User> findByisProActive(
		boolean isProActive) throws com.liferay.portal.SystemException {
		return getPersistence().findByisProActive(isProActive);
	}

	public static java.util.List<larion.progate.model.User> findByisProActive(
		boolean isProActive, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByisProActive(isProActive, start, end);
	}

	public static java.util.List<larion.progate.model.User> findByisProActive(
		boolean isProActive, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByisProActive(isProActive, start, end, obc);
	}

	public static larion.progate.model.User findByisProActive_First(
		boolean isProActive,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserException {
		return getPersistence().findByisProActive_First(isProActive, obc);
	}

	public static larion.progate.model.User findByisProActive_Last(
		boolean isProActive,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserException {
		return getPersistence().findByisProActive_Last(isProActive, obc);
	}

	public static larion.progate.model.User[] findByisProActive_PrevAndNext(
		java.lang.Integer userid, boolean isProActive,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserException {
		return getPersistence()
				   .findByisProActive_PrevAndNext(userid, isProActive, obc);
	}

	public static java.util.List<larion.progate.model.User> findBystatus(
		boolean status) throws com.liferay.portal.SystemException {
		return getPersistence().findBystatus(status);
	}

	public static java.util.List<larion.progate.model.User> findBystatus(
		boolean status, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBystatus(status, start, end);
	}

	public static java.util.List<larion.progate.model.User> findBystatus(
		boolean status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBystatus(status, start, end, obc);
	}

	public static larion.progate.model.User findBystatus_First(boolean status,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserException {
		return getPersistence().findBystatus_First(status, obc);
	}

	public static larion.progate.model.User findBystatus_Last(boolean status,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserException {
		return getPersistence().findBystatus_Last(status, obc);
	}

	public static larion.progate.model.User[] findBystatus_PrevAndNext(
		java.lang.Integer userid, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserException {
		return getPersistence().findBystatus_PrevAndNext(userid, status, obc);
	}

	public static java.util.List<larion.progate.model.User> findByemailaddress(
		java.lang.String emailaddress)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByemailaddress(emailaddress);
	}

	public static java.util.List<larion.progate.model.User> findByemailaddress(
		java.lang.String emailaddress, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByemailaddress(emailaddress, start, end);
	}

	public static java.util.List<larion.progate.model.User> findByemailaddress(
		java.lang.String emailaddress, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByemailaddress(emailaddress, start, end, obc);
	}

	public static larion.progate.model.User findByemailaddress_First(
		java.lang.String emailaddress,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserException {
		return getPersistence().findByemailaddress_First(emailaddress, obc);
	}

	public static larion.progate.model.User findByemailaddress_Last(
		java.lang.String emailaddress,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserException {
		return getPersistence().findByemailaddress_Last(emailaddress, obc);
	}

	public static larion.progate.model.User[] findByemailaddress_PrevAndNext(
		java.lang.Integer userid, java.lang.String emailaddress,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserException {
		return getPersistence()
				   .findByemailaddress_PrevAndNext(userid, emailaddress, obc);
	}

	public static java.util.List<larion.progate.model.User> findByfirstname(
		java.lang.String firstname) throws com.liferay.portal.SystemException {
		return getPersistence().findByfirstname(firstname);
	}

	public static java.util.List<larion.progate.model.User> findByfirstname(
		java.lang.String firstname, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByfirstname(firstname, start, end);
	}

	public static java.util.List<larion.progate.model.User> findByfirstname(
		java.lang.String firstname, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByfirstname(firstname, start, end, obc);
	}

	public static larion.progate.model.User findByfirstname_First(
		java.lang.String firstname,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserException {
		return getPersistence().findByfirstname_First(firstname, obc);
	}

	public static larion.progate.model.User findByfirstname_Last(
		java.lang.String firstname,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserException {
		return getPersistence().findByfirstname_Last(firstname, obc);
	}

	public static larion.progate.model.User[] findByfirstname_PrevAndNext(
		java.lang.Integer userid, java.lang.String firstname,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserException {
		return getPersistence()
				   .findByfirstname_PrevAndNext(userid, firstname, obc);
	}

	public static java.util.List<larion.progate.model.User> findBymiddlename(
		java.lang.String middlename) throws com.liferay.portal.SystemException {
		return getPersistence().findBymiddlename(middlename);
	}

	public static java.util.List<larion.progate.model.User> findBymiddlename(
		java.lang.String middlename, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBymiddlename(middlename, start, end);
	}

	public static java.util.List<larion.progate.model.User> findBymiddlename(
		java.lang.String middlename, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBymiddlename(middlename, start, end, obc);
	}

	public static larion.progate.model.User findBymiddlename_First(
		java.lang.String middlename,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserException {
		return getPersistence().findBymiddlename_First(middlename, obc);
	}

	public static larion.progate.model.User findBymiddlename_Last(
		java.lang.String middlename,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserException {
		return getPersistence().findBymiddlename_Last(middlename, obc);
	}

	public static larion.progate.model.User[] findBymiddlename_PrevAndNext(
		java.lang.Integer userid, java.lang.String middlename,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserException {
		return getPersistence()
				   .findBymiddlename_PrevAndNext(userid, middlename, obc);
	}

	public static java.util.List<larion.progate.model.User> findBylastname(
		java.lang.String lastname) throws com.liferay.portal.SystemException {
		return getPersistence().findBylastname(lastname);
	}

	public static java.util.List<larion.progate.model.User> findBylastname(
		java.lang.String lastname, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBylastname(lastname, start, end);
	}

	public static java.util.List<larion.progate.model.User> findBylastname(
		java.lang.String lastname, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBylastname(lastname, start, end, obc);
	}

	public static larion.progate.model.User findBylastname_First(
		java.lang.String lastname,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserException {
		return getPersistence().findBylastname_First(lastname, obc);
	}

	public static larion.progate.model.User findBylastname_Last(
		java.lang.String lastname,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserException {
		return getPersistence().findBylastname_Last(lastname, obc);
	}

	public static larion.progate.model.User[] findBylastname_PrevAndNext(
		java.lang.Integer userid, java.lang.String lastname,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserException {
		return getPersistence().findBylastname_PrevAndNext(userid, lastname, obc);
	}

	public static java.util.List<larion.progate.model.User> findByactive(
		boolean active) throws com.liferay.portal.SystemException {
		return getPersistence().findByactive(active);
	}

	public static java.util.List<larion.progate.model.User> findByactive(
		boolean active, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByactive(active, start, end);
	}

	public static java.util.List<larion.progate.model.User> findByactive(
		boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByactive(active, start, end, obc);
	}

	public static larion.progate.model.User findByactive_First(boolean active,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserException {
		return getPersistence().findByactive_First(active, obc);
	}

	public static larion.progate.model.User findByactive_Last(boolean active,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserException {
		return getPersistence().findByactive_Last(active, obc);
	}

	public static larion.progate.model.User[] findByactive_PrevAndNext(
		java.lang.Integer userid, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserException {
		return getPersistence().findByactive_PrevAndNext(userid, active, obc);
	}

	public static java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	public static java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	public static java.util.List<larion.progate.model.User> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.model.User> findAll(int start,
		int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.model.User> findAll(int start,
		int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByscreenname(java.lang.String screenname)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByscreenname(screenname);
	}

	public static void removeByisProActive(boolean isProActive)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByisProActive(isProActive);
	}

	public static void removeBystatus(boolean status)
		throws com.liferay.portal.SystemException {
		getPersistence().removeBystatus(status);
	}

	public static void removeByemailaddress(java.lang.String emailaddress)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByemailaddress(emailaddress);
	}

	public static void removeByfirstname(java.lang.String firstname)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByfirstname(firstname);
	}

	public static void removeBymiddlename(java.lang.String middlename)
		throws com.liferay.portal.SystemException {
		getPersistence().removeBymiddlename(middlename);
	}

	public static void removeBylastname(java.lang.String lastname)
		throws com.liferay.portal.SystemException {
		getPersistence().removeBylastname(lastname);
	}

	public static void removeByactive(boolean active)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByactive(active);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByscreenname(java.lang.String screenname)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByscreenname(screenname);
	}

	public static int countByisProActive(boolean isProActive)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByisProActive(isProActive);
	}

	public static int countBystatus(boolean status)
		throws com.liferay.portal.SystemException {
		return getPersistence().countBystatus(status);
	}

	public static int countByemailaddress(java.lang.String emailaddress)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByemailaddress(emailaddress);
	}

	public static int countByfirstname(java.lang.String firstname)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByfirstname(firstname);
	}

	public static int countBymiddlename(java.lang.String middlename)
		throws com.liferay.portal.SystemException {
		return getPersistence().countBymiddlename(middlename);
	}

	public static int countBylastname(java.lang.String lastname)
		throws com.liferay.portal.SystemException {
		return getPersistence().countBylastname(lastname);
	}

	public static int countByactive(boolean active)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByactive(active);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static UserPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(UserPersistence persistence) {
		_persistence = persistence;
	}

	private static UserPersistence _persistence;
}