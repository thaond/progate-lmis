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
 * <a href="LmisDataImportDetailsUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisDataImportDetailsUtil {
	public static void cacheResult(
		larion.progate.lmis.model.LmisDataImportDetails lmisDataImportDetails) {
		getPersistence().cacheResult(lmisDataImportDetails);
	}

	public static void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisDataImportDetails> lmisDataImportDetailses) {
		getPersistence().cacheResult(lmisDataImportDetailses);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.lmis.model.LmisDataImportDetails create(
		java.lang.Integer lmisDataImportDetailsId) {
		return getPersistence().create(lmisDataImportDetailsId);
	}

	public static larion.progate.lmis.model.LmisDataImportDetails remove(
		java.lang.Integer lmisDataImportDetailsId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisDataImportDetailsException {
		return getPersistence().remove(lmisDataImportDetailsId);
	}

	public static larion.progate.lmis.model.LmisDataImportDetails remove(
		larion.progate.lmis.model.LmisDataImportDetails lmisDataImportDetails)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(lmisDataImportDetails);
	}

	public static larion.progate.lmis.model.LmisDataImportDetails update(
		larion.progate.lmis.model.LmisDataImportDetails lmisDataImportDetails)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisDataImportDetails);
	}

	public static larion.progate.lmis.model.LmisDataImportDetails update(
		larion.progate.lmis.model.LmisDataImportDetails lmisDataImportDetails,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisDataImportDetails, merge);
	}

	public static larion.progate.lmis.model.LmisDataImportDetails updateImpl(
		larion.progate.lmis.model.LmisDataImportDetails lmisDataImportDetails,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(lmisDataImportDetails, merge);
	}

	public static larion.progate.lmis.model.LmisDataImportDetails findByPrimaryKey(
		java.lang.Integer lmisDataImportDetailsId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisDataImportDetailsException {
		return getPersistence().findByPrimaryKey(lmisDataImportDetailsId);
	}

	public static larion.progate.lmis.model.LmisDataImportDetails fetchByPrimaryKey(
		java.lang.Integer lmisDataImportDetailsId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(lmisDataImportDetailsId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisDataImportDetails> findByDataImportDetailsOf(
		int rootId) throws com.liferay.portal.SystemException {
		return getPersistence().findByDataImportDetailsOf(rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisDataImportDetails> findByDataImportDetailsOf(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByDataImportDetailsOf(rootId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisDataImportDetails> findByDataImportDetailsOf(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByDataImportDetailsOf(rootId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisDataImportDetails findByDataImportDetailsOf_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisDataImportDetailsException {
		return getPersistence().findByDataImportDetailsOf_First(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisDataImportDetails findByDataImportDetailsOf_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisDataImportDetailsException {
		return getPersistence().findByDataImportDetailsOf_Last(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisDataImportDetails[] findByDataImportDetailsOf_PrevAndNext(
		java.lang.Integer lmisDataImportDetailsId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisDataImportDetailsException {
		return getPersistence()
				   .findByDataImportDetailsOf_PrevAndNext(lmisDataImportDetailsId,
			rootId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisDataImportDetails> findByScannerID(
		java.lang.String scannerId) throws com.liferay.portal.SystemException {
		return getPersistence().findByScannerID(scannerId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisDataImportDetails> findByScannerID(
		java.lang.String scannerId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByScannerID(scannerId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisDataImportDetails> findByScannerID(
		java.lang.String scannerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByScannerID(scannerId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisDataImportDetails findByScannerID_First(
		java.lang.String scannerId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisDataImportDetailsException {
		return getPersistence().findByScannerID_First(scannerId, obc);
	}

	public static larion.progate.lmis.model.LmisDataImportDetails findByScannerID_Last(
		java.lang.String scannerId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisDataImportDetailsException {
		return getPersistence().findByScannerID_Last(scannerId, obc);
	}

	public static larion.progate.lmis.model.LmisDataImportDetails[] findByScannerID_PrevAndNext(
		java.lang.Integer lmisDataImportDetailsId, java.lang.String scannerId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisDataImportDetailsException {
		return getPersistence()
				   .findByScannerID_PrevAndNext(lmisDataImportDetailsId,
			scannerId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisDataImportDetails> findByImportID(
		int importId) throws com.liferay.portal.SystemException {
		return getPersistence().findByImportID(importId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisDataImportDetails> findByImportID(
		int importId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByImportID(importId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisDataImportDetails> findByImportID(
		int importId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByImportID(importId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisDataImportDetails findByImportID_First(
		int importId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisDataImportDetailsException {
		return getPersistence().findByImportID_First(importId, obc);
	}

	public static larion.progate.lmis.model.LmisDataImportDetails findByImportID_Last(
		int importId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisDataImportDetailsException {
		return getPersistence().findByImportID_Last(importId, obc);
	}

	public static larion.progate.lmis.model.LmisDataImportDetails[] findByImportID_PrevAndNext(
		java.lang.Integer lmisDataImportDetailsId, int importId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisDataImportDetailsException {
		return getPersistence()
				   .findByImportID_PrevAndNext(lmisDataImportDetailsId,
			importId, obc);
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

	public static java.util.List<larion.progate.lmis.model.LmisDataImportDetails> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.lmis.model.LmisDataImportDetails> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisDataImportDetails> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByDataImportDetailsOf(int rootId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByDataImportDetailsOf(rootId);
	}

	public static void removeByScannerID(java.lang.String scannerId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByScannerID(scannerId);
	}

	public static void removeByImportID(int importId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByImportID(importId);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByDataImportDetailsOf(int rootId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByDataImportDetailsOf(rootId);
	}

	public static int countByScannerID(java.lang.String scannerId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByScannerID(scannerId);
	}

	public static int countByImportID(int importId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByImportID(importId);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static LmisDataImportDetailsPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(LmisDataImportDetailsPersistence persistence) {
		_persistence = persistence;
	}

	private static LmisDataImportDetailsPersistence _persistence;
}