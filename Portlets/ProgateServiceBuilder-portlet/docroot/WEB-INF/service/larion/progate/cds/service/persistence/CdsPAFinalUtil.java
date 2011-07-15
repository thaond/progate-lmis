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

package larion.progate.cds.service.persistence;

/**
 * <a href="CdsPAFinalUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsPAFinalUtil {
	public static void cacheResult(
		larion.progate.cds.model.CdsPAFinal cdsPAFinal) {
		getPersistence().cacheResult(cdsPAFinal);
	}

	public static void cacheResult(
		java.util.List<larion.progate.cds.model.CdsPAFinal> cdsPAFinals) {
		getPersistence().cacheResult(cdsPAFinals);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.cds.model.CdsPAFinal create(
		java.lang.Integer cdsPAFinalId) {
		return getPersistence().create(cdsPAFinalId);
	}

	public static larion.progate.cds.model.CdsPAFinal remove(
		java.lang.Integer cdsPAFinalId)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPAFinalException {
		return getPersistence().remove(cdsPAFinalId);
	}

	public static larion.progate.cds.model.CdsPAFinal remove(
		larion.progate.cds.model.CdsPAFinal cdsPAFinal)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(cdsPAFinal);
	}

	public static larion.progate.cds.model.CdsPAFinal update(
		larion.progate.cds.model.CdsPAFinal cdsPAFinal)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(cdsPAFinal);
	}

	public static larion.progate.cds.model.CdsPAFinal update(
		larion.progate.cds.model.CdsPAFinal cdsPAFinal, boolean merge)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(cdsPAFinal, merge);
	}

	public static larion.progate.cds.model.CdsPAFinal updateImpl(
		larion.progate.cds.model.CdsPAFinal cdsPAFinal, boolean merge)
		throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(cdsPAFinal, merge);
	}

	public static larion.progate.cds.model.CdsPAFinal findByPrimaryKey(
		java.lang.Integer cdsPAFinalId)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPAFinalException {
		return getPersistence().findByPrimaryKey(cdsPAFinalId);
	}

	public static larion.progate.cds.model.CdsPAFinal fetchByPrimaryKey(
		java.lang.Integer cdsPAFinalId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(cdsPAFinalId);
	}

	public static java.util.List<larion.progate.cds.model.CdsPAFinal> findByRootId(
		int rootId) throws com.liferay.portal.SystemException {
		return getPersistence().findByRootId(rootId);
	}

	public static java.util.List<larion.progate.cds.model.CdsPAFinal> findByRootId(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootId(rootId, start, end);
	}

	public static java.util.List<larion.progate.cds.model.CdsPAFinal> findByRootId(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootId(rootId, start, end, obc);
	}

	public static larion.progate.cds.model.CdsPAFinal findByRootId_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPAFinalException {
		return getPersistence().findByRootId_First(rootId, obc);
	}

	public static larion.progate.cds.model.CdsPAFinal findByRootId_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPAFinalException {
		return getPersistence().findByRootId_Last(rootId, obc);
	}

	public static larion.progate.cds.model.CdsPAFinal[] findByRootId_PrevAndNext(
		java.lang.Integer cdsPAFinalId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPAFinalException {
		return getPersistence()
				   .findByRootId_PrevAndNext(cdsPAFinalId, rootId, obc);
	}

	public static java.util.List<larion.progate.cds.model.CdsPAFinal> findByUserId(
		int userId) throws com.liferay.portal.SystemException {
		return getPersistence().findByUserId(userId);
	}

	public static java.util.List<larion.progate.cds.model.CdsPAFinal> findByUserId(
		int userId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByUserId(userId, start, end);
	}

	public static java.util.List<larion.progate.cds.model.CdsPAFinal> findByUserId(
		int userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByUserId(userId, start, end, obc);
	}

	public static larion.progate.cds.model.CdsPAFinal findByUserId_First(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPAFinalException {
		return getPersistence().findByUserId_First(userId, obc);
	}

	public static larion.progate.cds.model.CdsPAFinal findByUserId_Last(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPAFinalException {
		return getPersistence().findByUserId_Last(userId, obc);
	}

	public static larion.progate.cds.model.CdsPAFinal[] findByUserId_PrevAndNext(
		java.lang.Integer cdsPAFinalId, int userId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPAFinalException {
		return getPersistence()
				   .findByUserId_PrevAndNext(cdsPAFinalId, userId, obc);
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

	public static java.util.List<larion.progate.cds.model.CdsPAFinal> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.cds.model.CdsPAFinal> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.cds.model.CdsPAFinal> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByRootId(int rootId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByRootId(rootId);
	}

	public static void removeByUserId(int userId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByUserId(userId);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByRootId(int rootId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByRootId(rootId);
	}

	public static int countByUserId(int userId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByUserId(userId);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static CdsPAFinalPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(CdsPAFinalPersistence persistence) {
		_persistence = persistence;
	}

	private static CdsPAFinalPersistence _persistence;
}