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
 * <a href="LmisEmailSettingsUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisEmailSettingsUtil {
	public static void cacheResult(
		larion.progate.lmis.model.LmisEmailSettings lmisEmailSettings) {
		getPersistence().cacheResult(lmisEmailSettings);
	}

	public static void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisEmailSettings> lmisEmailSettingses) {
		getPersistence().cacheResult(lmisEmailSettingses);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.lmis.model.LmisEmailSettings create(
		java.lang.Integer lmisEmailSettingId) {
		return getPersistence().create(lmisEmailSettingId);
	}

	public static larion.progate.lmis.model.LmisEmailSettings remove(
		java.lang.Integer lmisEmailSettingId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisEmailSettingsException {
		return getPersistence().remove(lmisEmailSettingId);
	}

	public static larion.progate.lmis.model.LmisEmailSettings remove(
		larion.progate.lmis.model.LmisEmailSettings lmisEmailSettings)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(lmisEmailSettings);
	}

	public static larion.progate.lmis.model.LmisEmailSettings update(
		larion.progate.lmis.model.LmisEmailSettings lmisEmailSettings)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisEmailSettings);
	}

	public static larion.progate.lmis.model.LmisEmailSettings update(
		larion.progate.lmis.model.LmisEmailSettings lmisEmailSettings,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisEmailSettings, merge);
	}

	public static larion.progate.lmis.model.LmisEmailSettings updateImpl(
		larion.progate.lmis.model.LmisEmailSettings lmisEmailSettings,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(lmisEmailSettings, merge);
	}

	public static larion.progate.lmis.model.LmisEmailSettings findByPrimaryKey(
		java.lang.Integer lmisEmailSettingId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisEmailSettingsException {
		return getPersistence().findByPrimaryKey(lmisEmailSettingId);
	}

	public static larion.progate.lmis.model.LmisEmailSettings fetchByPrimaryKey(
		java.lang.Integer lmisEmailSettingId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(lmisEmailSettingId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisEmailSettings> findByEmailSettingOf(
		int rootId) throws com.liferay.portal.SystemException {
		return getPersistence().findByEmailSettingOf(rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisEmailSettings> findByEmailSettingOf(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByEmailSettingOf(rootId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisEmailSettings> findByEmailSettingOf(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByEmailSettingOf(rootId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisEmailSettings findByEmailSettingOf_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisEmailSettingsException {
		return getPersistence().findByEmailSettingOf_First(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisEmailSettings findByEmailSettingOf_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisEmailSettingsException {
		return getPersistence().findByEmailSettingOf_Last(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisEmailSettings[] findByEmailSettingOf_PrevAndNext(
		java.lang.Integer lmisEmailSettingId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisEmailSettingsException {
		return getPersistence()
				   .findByEmailSettingOf_PrevAndNext(lmisEmailSettingId,
			rootId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisEmailSettings> findByCategoryId(
		int category) throws com.liferay.portal.SystemException {
		return getPersistence().findByCategoryId(category);
	}

	public static java.util.List<larion.progate.lmis.model.LmisEmailSettings> findByCategoryId(
		int category, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByCategoryId(category, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisEmailSettings> findByCategoryId(
		int category, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByCategoryId(category, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisEmailSettings findByCategoryId_First(
		int category, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisEmailSettingsException {
		return getPersistence().findByCategoryId_First(category, obc);
	}

	public static larion.progate.lmis.model.LmisEmailSettings findByCategoryId_Last(
		int category, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisEmailSettingsException {
		return getPersistence().findByCategoryId_Last(category, obc);
	}

	public static larion.progate.lmis.model.LmisEmailSettings[] findByCategoryId_PrevAndNext(
		java.lang.Integer lmisEmailSettingId, int category,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisEmailSettingsException {
		return getPersistence()
				   .findByCategoryId_PrevAndNext(lmisEmailSettingId, category,
			obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisEmailSettings> findByEmailType(
		java.lang.String emailType) throws com.liferay.portal.SystemException {
		return getPersistence().findByEmailType(emailType);
	}

	public static java.util.List<larion.progate.lmis.model.LmisEmailSettings> findByEmailType(
		java.lang.String emailType, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByEmailType(emailType, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisEmailSettings> findByEmailType(
		java.lang.String emailType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByEmailType(emailType, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisEmailSettings findByEmailType_First(
		java.lang.String emailType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisEmailSettingsException {
		return getPersistence().findByEmailType_First(emailType, obc);
	}

	public static larion.progate.lmis.model.LmisEmailSettings findByEmailType_Last(
		java.lang.String emailType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisEmailSettingsException {
		return getPersistence().findByEmailType_Last(emailType, obc);
	}

	public static larion.progate.lmis.model.LmisEmailSettings[] findByEmailType_PrevAndNext(
		java.lang.Integer lmisEmailSettingId, java.lang.String emailType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisEmailSettingsException {
		return getPersistence()
				   .findByEmailType_PrevAndNext(lmisEmailSettingId, emailType,
			obc);
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

	public static java.util.List<larion.progate.lmis.model.LmisEmailSettings> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.lmis.model.LmisEmailSettings> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisEmailSettings> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByEmailSettingOf(int rootId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByEmailSettingOf(rootId);
	}

	public static void removeByCategoryId(int category)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByCategoryId(category);
	}

	public static void removeByEmailType(java.lang.String emailType)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByEmailType(emailType);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByEmailSettingOf(int rootId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByEmailSettingOf(rootId);
	}

	public static int countByCategoryId(int category)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByCategoryId(category);
	}

	public static int countByEmailType(java.lang.String emailType)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByEmailType(emailType);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static java.util.List<larion.progate.lmis.model.LmisEmailSettingDetails> getLmisEmailSettingDetailses(
		java.lang.Integer pk) throws com.liferay.portal.SystemException {
		return getPersistence().getLmisEmailSettingDetailses(pk);
	}

	public static java.util.List<larion.progate.lmis.model.LmisEmailSettingDetails> getLmisEmailSettingDetailses(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().getLmisEmailSettingDetailses(pk, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisEmailSettingDetails> getLmisEmailSettingDetailses(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().getLmisEmailSettingDetailses(pk, start, end, obc);
	}

	public static int getLmisEmailSettingDetailsesSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException {
		return getPersistence().getLmisEmailSettingDetailsesSize(pk);
	}

	public static boolean containsLmisEmailSettingDetails(
		java.lang.Integer pk, java.lang.Integer lmisEmailSettingDetailsPK)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .containsLmisEmailSettingDetails(pk,
			lmisEmailSettingDetailsPK);
	}

	public static boolean containsLmisEmailSettingDetailses(
		java.lang.Integer pk) throws com.liferay.portal.SystemException {
		return getPersistence().containsLmisEmailSettingDetailses(pk);
	}

	public static LmisEmailSettingsPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(LmisEmailSettingsPersistence persistence) {
		_persistence = persistence;
	}

	private static LmisEmailSettingsPersistence _persistence;
}