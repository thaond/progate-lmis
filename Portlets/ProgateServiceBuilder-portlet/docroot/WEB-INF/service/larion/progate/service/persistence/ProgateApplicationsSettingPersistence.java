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
 * <a href="ProgateApplicationsSettingPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface ProgateApplicationsSettingPersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.model.ProgateApplicationsSetting progateApplicationsSetting);

	public void cacheResult(
		java.util.List<larion.progate.model.ProgateApplicationsSetting> progateApplicationsSettings);

	public void clearCache();

	public larion.progate.model.ProgateApplicationsSetting create(
		java.lang.Integer ProgateApplicationsSettingId);

	public larion.progate.model.ProgateApplicationsSetting remove(
		java.lang.Integer ProgateApplicationsSettingId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateApplicationsSettingException;

	public larion.progate.model.ProgateApplicationsSetting remove(
		larion.progate.model.ProgateApplicationsSetting progateApplicationsSetting)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProgateApplicationsSetting update(
		larion.progate.model.ProgateApplicationsSetting progateApplicationsSetting)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProgateApplicationsSetting update(
		larion.progate.model.ProgateApplicationsSetting progateApplicationsSetting,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.model.ProgateApplicationsSetting updateImpl(
		larion.progate.model.ProgateApplicationsSetting progateApplicationsSetting,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.model.ProgateApplicationsSetting findByPrimaryKey(
		java.lang.Integer ProgateApplicationsSettingId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateApplicationsSettingException;

	public larion.progate.model.ProgateApplicationsSetting fetchByPrimaryKey(
		java.lang.Integer ProgateApplicationsSettingId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateApplicationsSetting> findByappId(
		int appId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateApplicationsSetting> findByappId(
		int appId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateApplicationsSetting> findByappId(
		int appId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProgateApplicationsSetting findByappId_First(
		int appId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateApplicationsSettingException;

	public larion.progate.model.ProgateApplicationsSetting findByappId_Last(
		int appId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateApplicationsSettingException;

	public larion.progate.model.ProgateApplicationsSetting[] findByappId_PrevAndNext(
		java.lang.Integer ProgateApplicationsSettingId, int appId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateApplicationsSettingException;

	public java.util.List<larion.progate.model.ProgateApplicationsSetting> findByroleId(
		int roleId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateApplicationsSetting> findByroleId(
		int roleId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateApplicationsSetting> findByroleId(
		int roleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProgateApplicationsSetting findByroleId_First(
		int roleId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateApplicationsSettingException;

	public larion.progate.model.ProgateApplicationsSetting findByroleId_Last(
		int roleId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateApplicationsSettingException;

	public larion.progate.model.ProgateApplicationsSetting[] findByroleId_PrevAndNext(
		java.lang.Integer ProgateApplicationsSettingId, int roleId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateApplicationsSettingException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateApplicationsSetting> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateApplicationsSetting> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateApplicationsSetting> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByappId(int appId)
		throws com.liferay.portal.SystemException;

	public void removeByroleId(int roleId)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByappId(int appId)
		throws com.liferay.portal.SystemException;

	public int countByroleId(int roleId)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;
}