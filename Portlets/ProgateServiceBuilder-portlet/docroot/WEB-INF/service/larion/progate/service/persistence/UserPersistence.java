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
 * <a href="UserPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface UserPersistence extends BasePersistence {
	public void cacheResult(larion.progate.model.User user);

	public void cacheResult(java.util.List<larion.progate.model.User> users);

	public void clearCache();

	public larion.progate.model.User create(java.lang.Integer userid);

	public larion.progate.model.User remove(java.lang.Integer userid)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserException;

	public larion.progate.model.User remove(larion.progate.model.User user)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.User update(larion.progate.model.User user)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.User update(larion.progate.model.User user,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.model.User updateImpl(
		larion.progate.model.User user, boolean merge)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.User findByPrimaryKey(java.lang.Integer userid)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserException;

	public larion.progate.model.User fetchByPrimaryKey(java.lang.Integer userid)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.User> findByscreenname(
		java.lang.String screenname) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.User> findByscreenname(
		java.lang.String screenname, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.User> findByscreenname(
		java.lang.String screenname, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.User findByscreenname_First(
		java.lang.String screenname,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserException;

	public larion.progate.model.User findByscreenname_Last(
		java.lang.String screenname,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserException;

	public larion.progate.model.User[] findByscreenname_PrevAndNext(
		java.lang.Integer userid, java.lang.String screenname,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserException;

	public java.util.List<larion.progate.model.User> findByisProActive(
		boolean isProActive) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.User> findByisProActive(
		boolean isProActive, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.User> findByisProActive(
		boolean isProActive, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.User findByisProActive_First(
		boolean isProActive,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserException;

	public larion.progate.model.User findByisProActive_Last(
		boolean isProActive,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserException;

	public larion.progate.model.User[] findByisProActive_PrevAndNext(
		java.lang.Integer userid, boolean isProActive,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserException;

	public java.util.List<larion.progate.model.User> findBystatus(
		boolean status) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.User> findBystatus(
		boolean status, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.User> findBystatus(
		boolean status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.User findBystatus_First(boolean status,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserException;

	public larion.progate.model.User findBystatus_Last(boolean status,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserException;

	public larion.progate.model.User[] findBystatus_PrevAndNext(
		java.lang.Integer userid, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserException;

	public java.util.List<larion.progate.model.User> findByemailaddress(
		java.lang.String emailaddress)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.User> findByemailaddress(
		java.lang.String emailaddress, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.User> findByemailaddress(
		java.lang.String emailaddress, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.User findByemailaddress_First(
		java.lang.String emailaddress,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserException;

	public larion.progate.model.User findByemailaddress_Last(
		java.lang.String emailaddress,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserException;

	public larion.progate.model.User[] findByemailaddress_PrevAndNext(
		java.lang.Integer userid, java.lang.String emailaddress,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserException;

	public java.util.List<larion.progate.model.User> findByfirstname(
		java.lang.String firstname) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.User> findByfirstname(
		java.lang.String firstname, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.User> findByfirstname(
		java.lang.String firstname, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.User findByfirstname_First(
		java.lang.String firstname,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserException;

	public larion.progate.model.User findByfirstname_Last(
		java.lang.String firstname,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserException;

	public larion.progate.model.User[] findByfirstname_PrevAndNext(
		java.lang.Integer userid, java.lang.String firstname,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserException;

	public java.util.List<larion.progate.model.User> findBymiddlename(
		java.lang.String middlename) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.User> findBymiddlename(
		java.lang.String middlename, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.User> findBymiddlename(
		java.lang.String middlename, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.User findBymiddlename_First(
		java.lang.String middlename,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserException;

	public larion.progate.model.User findBymiddlename_Last(
		java.lang.String middlename,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserException;

	public larion.progate.model.User[] findBymiddlename_PrevAndNext(
		java.lang.Integer userid, java.lang.String middlename,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserException;

	public java.util.List<larion.progate.model.User> findBylastname(
		java.lang.String lastname) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.User> findBylastname(
		java.lang.String lastname, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.User> findBylastname(
		java.lang.String lastname, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.User findBylastname_First(
		java.lang.String lastname,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserException;

	public larion.progate.model.User findBylastname_Last(
		java.lang.String lastname,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserException;

	public larion.progate.model.User[] findBylastname_PrevAndNext(
		java.lang.Integer userid, java.lang.String lastname,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserException;

	public java.util.List<larion.progate.model.User> findByactive(
		boolean active) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.User> findByactive(
		boolean active, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.User> findByactive(
		boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.User findByactive_First(boolean active,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserException;

	public larion.progate.model.User findByactive_Last(boolean active,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserException;

	public larion.progate.model.User[] findByactive_PrevAndNext(
		java.lang.Integer userid, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchUserException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.User> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.User> findAll(int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.User> findAll(int start,
		int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByscreenname(java.lang.String screenname)
		throws com.liferay.portal.SystemException;

	public void removeByisProActive(boolean isProActive)
		throws com.liferay.portal.SystemException;

	public void removeBystatus(boolean status)
		throws com.liferay.portal.SystemException;

	public void removeByemailaddress(java.lang.String emailaddress)
		throws com.liferay.portal.SystemException;

	public void removeByfirstname(java.lang.String firstname)
		throws com.liferay.portal.SystemException;

	public void removeBymiddlename(java.lang.String middlename)
		throws com.liferay.portal.SystemException;

	public void removeBylastname(java.lang.String lastname)
		throws com.liferay.portal.SystemException;

	public void removeByactive(boolean active)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByscreenname(java.lang.String screenname)
		throws com.liferay.portal.SystemException;

	public int countByisProActive(boolean isProActive)
		throws com.liferay.portal.SystemException;

	public int countBystatus(boolean status)
		throws com.liferay.portal.SystemException;

	public int countByemailaddress(java.lang.String emailaddress)
		throws com.liferay.portal.SystemException;

	public int countByfirstname(java.lang.String firstname)
		throws com.liferay.portal.SystemException;

	public int countBymiddlename(java.lang.String middlename)
		throws com.liferay.portal.SystemException;

	public int countBylastname(java.lang.String lastname)
		throws com.liferay.portal.SystemException;

	public int countByactive(boolean active)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;
}