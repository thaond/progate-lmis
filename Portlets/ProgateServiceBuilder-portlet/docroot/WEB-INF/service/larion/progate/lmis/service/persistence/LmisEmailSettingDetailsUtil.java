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
 * <a href="LmisEmailSettingDetailsUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisEmailSettingDetailsUtil {
	public static void cacheResult(
		larion.progate.lmis.model.LmisEmailSettingDetails lmisEmailSettingDetails) {
		getPersistence().cacheResult(lmisEmailSettingDetails);
	}

	public static void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisEmailSettingDetails> lmisEmailSettingDetailses) {
		getPersistence().cacheResult(lmisEmailSettingDetailses);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.lmis.model.LmisEmailSettingDetails create(
		java.lang.Integer lmisEmailSettingDetailId) {
		return getPersistence().create(lmisEmailSettingDetailId);
	}

	public static larion.progate.lmis.model.LmisEmailSettingDetails remove(
		java.lang.Integer lmisEmailSettingDetailId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisEmailSettingDetailsException {
		return getPersistence().remove(lmisEmailSettingDetailId);
	}

	public static larion.progate.lmis.model.LmisEmailSettingDetails remove(
		larion.progate.lmis.model.LmisEmailSettingDetails lmisEmailSettingDetails)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(lmisEmailSettingDetails);
	}

	public static larion.progate.lmis.model.LmisEmailSettingDetails update(
		larion.progate.lmis.model.LmisEmailSettingDetails lmisEmailSettingDetails)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisEmailSettingDetails);
	}

	public static larion.progate.lmis.model.LmisEmailSettingDetails update(
		larion.progate.lmis.model.LmisEmailSettingDetails lmisEmailSettingDetails,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisEmailSettingDetails, merge);
	}

	public static larion.progate.lmis.model.LmisEmailSettingDetails updateImpl(
		larion.progate.lmis.model.LmisEmailSettingDetails lmisEmailSettingDetails,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(lmisEmailSettingDetails, merge);
	}

	public static larion.progate.lmis.model.LmisEmailSettingDetails findByPrimaryKey(
		java.lang.Integer lmisEmailSettingDetailId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisEmailSettingDetailsException {
		return getPersistence().findByPrimaryKey(lmisEmailSettingDetailId);
	}

	public static larion.progate.lmis.model.LmisEmailSettingDetails fetchByPrimaryKey(
		java.lang.Integer lmisEmailSettingDetailId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(lmisEmailSettingDetailId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisEmailSettingDetails> findByemailId(
		int emailSettingId) throws com.liferay.portal.SystemException {
		return getPersistence().findByemailId(emailSettingId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisEmailSettingDetails> findByemailId(
		int emailSettingId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByemailId(emailSettingId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisEmailSettingDetails> findByemailId(
		int emailSettingId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByemailId(emailSettingId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisEmailSettingDetails findByemailId_First(
		int emailSettingId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisEmailSettingDetailsException {
		return getPersistence().findByemailId_First(emailSettingId, obc);
	}

	public static larion.progate.lmis.model.LmisEmailSettingDetails findByemailId_Last(
		int emailSettingId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisEmailSettingDetailsException {
		return getPersistence().findByemailId_Last(emailSettingId, obc);
	}

	public static larion.progate.lmis.model.LmisEmailSettingDetails[] findByemailId_PrevAndNext(
		java.lang.Integer lmisEmailSettingDetailId, int emailSettingId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisEmailSettingDetailsException {
		return getPersistence()
				   .findByemailId_PrevAndNext(lmisEmailSettingDetailId,
			emailSettingId, obc);
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

	public static java.util.List<larion.progate.lmis.model.LmisEmailSettingDetails> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.lmis.model.LmisEmailSettingDetails> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisEmailSettingDetails> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByemailId(int emailSettingId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByemailId(emailSettingId);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByemailId(int emailSettingId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByemailId(emailSettingId);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static LmisEmailSettingDetailsPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(LmisEmailSettingDetailsPersistence persistence) {
		_persistence = persistence;
	}

	private static LmisEmailSettingDetailsPersistence _persistence;
}