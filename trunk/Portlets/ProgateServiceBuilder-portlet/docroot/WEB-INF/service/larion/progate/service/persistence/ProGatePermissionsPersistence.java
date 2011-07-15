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
 * <a href="ProGatePermissionsPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface ProGatePermissionsPersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.model.ProGatePermissions proGatePermissions);

	public void cacheResult(
		java.util.List<larion.progate.model.ProGatePermissions> proGatePermissionses);

	public void clearCache();

	public larion.progate.model.ProGatePermissions create(
		java.lang.String ProGatePermissionsId);

	public larion.progate.model.ProGatePermissions remove(
		java.lang.String ProGatePermissionsId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGatePermissionsException;

	public larion.progate.model.ProGatePermissions remove(
		larion.progate.model.ProGatePermissions proGatePermissions)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGatePermissions update(
		larion.progate.model.ProGatePermissions proGatePermissions)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGatePermissions update(
		larion.progate.model.ProGatePermissions proGatePermissions,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGatePermissions updateImpl(
		larion.progate.model.ProGatePermissions proGatePermissions,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGatePermissions findByPrimaryKey(
		java.lang.String ProGatePermissionsId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGatePermissionsException;

	public larion.progate.model.ProGatePermissions fetchByPrimaryKey(
		java.lang.String ProGatePermissionsId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGatePermissions> findByApplicationId(
		int applicationId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGatePermissions> findByApplicationId(
		int applicationId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGatePermissions> findByApplicationId(
		int applicationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGatePermissions findByApplicationId_First(
		int applicationId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGatePermissionsException;

	public larion.progate.model.ProGatePermissions findByApplicationId_Last(
		int applicationId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGatePermissionsException;

	public larion.progate.model.ProGatePermissions[] findByApplicationId_PrevAndNext(
		java.lang.String ProGatePermissionsId, int applicationId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGatePermissionsException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGatePermissions> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGatePermissions> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGatePermissions> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByApplicationId(int applicationId)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByApplicationId(int applicationId)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;
}