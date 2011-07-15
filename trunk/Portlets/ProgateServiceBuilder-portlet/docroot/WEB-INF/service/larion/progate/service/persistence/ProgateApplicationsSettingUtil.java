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
 * <a href="ProgateApplicationsSettingUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProgateApplicationsSettingUtil {
	public static void cacheResult(
		larion.progate.model.ProgateApplicationsSetting progateApplicationsSetting) {
		getPersistence().cacheResult(progateApplicationsSetting);
	}

	public static void cacheResult(
		java.util.List<larion.progate.model.ProgateApplicationsSetting> progateApplicationsSettings) {
		getPersistence().cacheResult(progateApplicationsSettings);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.model.ProgateApplicationsSetting create(
		java.lang.Integer ProgateApplicationsSettingId) {
		return getPersistence().create(ProgateApplicationsSettingId);
	}

	public static larion.progate.model.ProgateApplicationsSetting remove(
		java.lang.Integer ProgateApplicationsSettingId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateApplicationsSettingException {
		return getPersistence().remove(ProgateApplicationsSettingId);
	}

	public static larion.progate.model.ProgateApplicationsSetting remove(
		larion.progate.model.ProgateApplicationsSetting progateApplicationsSetting)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(progateApplicationsSetting);
	}

	public static larion.progate.model.ProgateApplicationsSetting update(
		larion.progate.model.ProgateApplicationsSetting progateApplicationsSetting)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(progateApplicationsSetting);
	}

	public static larion.progate.model.ProgateApplicationsSetting update(
		larion.progate.model.ProgateApplicationsSetting progateApplicationsSetting,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(progateApplicationsSetting, merge);
	}

	public static larion.progate.model.ProgateApplicationsSetting updateImpl(
		larion.progate.model.ProgateApplicationsSetting progateApplicationsSetting,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(progateApplicationsSetting, merge);
	}

	public static larion.progate.model.ProgateApplicationsSetting findByPrimaryKey(
		java.lang.Integer ProgateApplicationsSettingId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateApplicationsSettingException {
		return getPersistence().findByPrimaryKey(ProgateApplicationsSettingId);
	}

	public static larion.progate.model.ProgateApplicationsSetting fetchByPrimaryKey(
		java.lang.Integer ProgateApplicationsSettingId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(ProgateApplicationsSettingId);
	}

	public static java.util.List<larion.progate.model.ProgateApplicationsSetting> findByappId(
		int appId) throws com.liferay.portal.SystemException {
		return getPersistence().findByappId(appId);
	}

	public static java.util.List<larion.progate.model.ProgateApplicationsSetting> findByappId(
		int appId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByappId(appId, start, end);
	}

	public static java.util.List<larion.progate.model.ProgateApplicationsSetting> findByappId(
		int appId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByappId(appId, start, end, obc);
	}

	public static larion.progate.model.ProgateApplicationsSetting findByappId_First(
		int appId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateApplicationsSettingException {
		return getPersistence().findByappId_First(appId, obc);
	}

	public static larion.progate.model.ProgateApplicationsSetting findByappId_Last(
		int appId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateApplicationsSettingException {
		return getPersistence().findByappId_Last(appId, obc);
	}

	public static larion.progate.model.ProgateApplicationsSetting[] findByappId_PrevAndNext(
		java.lang.Integer ProgateApplicationsSettingId, int appId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateApplicationsSettingException {
		return getPersistence()
				   .findByappId_PrevAndNext(ProgateApplicationsSettingId,
			appId, obc);
	}

	public static java.util.List<larion.progate.model.ProgateApplicationsSetting> findByroleId(
		int roleId) throws com.liferay.portal.SystemException {
		return getPersistence().findByroleId(roleId);
	}

	public static java.util.List<larion.progate.model.ProgateApplicationsSetting> findByroleId(
		int roleId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByroleId(roleId, start, end);
	}

	public static java.util.List<larion.progate.model.ProgateApplicationsSetting> findByroleId(
		int roleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByroleId(roleId, start, end, obc);
	}

	public static larion.progate.model.ProgateApplicationsSetting findByroleId_First(
		int roleId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateApplicationsSettingException {
		return getPersistence().findByroleId_First(roleId, obc);
	}

	public static larion.progate.model.ProgateApplicationsSetting findByroleId_Last(
		int roleId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateApplicationsSettingException {
		return getPersistence().findByroleId_Last(roleId, obc);
	}

	public static larion.progate.model.ProgateApplicationsSetting[] findByroleId_PrevAndNext(
		java.lang.Integer ProgateApplicationsSettingId, int roleId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateApplicationsSettingException {
		return getPersistence()
				   .findByroleId_PrevAndNext(ProgateApplicationsSettingId,
			roleId, obc);
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

	public static java.util.List<larion.progate.model.ProgateApplicationsSetting> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.model.ProgateApplicationsSetting> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.model.ProgateApplicationsSetting> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByappId(int appId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByappId(appId);
	}

	public static void removeByroleId(int roleId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByroleId(roleId);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByappId(int appId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByappId(appId);
	}

	public static int countByroleId(int roleId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByroleId(roleId);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static ProgateApplicationsSettingPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(
		ProgateApplicationsSettingPersistence persistence) {
		_persistence = persistence;
	}

	private static ProgateApplicationsSettingPersistence _persistence;
}