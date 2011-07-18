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
 * <a href="CdsPerformanceAppraisalSlotRatingUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsPerformanceAppraisalSlotRatingUtil {
	public static void cacheResult(
		larion.progate.cds.model.CdsPerformanceAppraisalSlotRating cdsPerformanceAppraisalSlotRating) {
		getPersistence().cacheResult(cdsPerformanceAppraisalSlotRating);
	}

	public static void cacheResult(
		java.util.List<larion.progate.cds.model.CdsPerformanceAppraisalSlotRating> cdsPerformanceAppraisalSlotRatings) {
		getPersistence().cacheResult(cdsPerformanceAppraisalSlotRatings);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.cds.model.CdsPerformanceAppraisalSlotRating create(
		java.lang.Integer CdsPerformanceAppraisalSlotRatingId) {
		return getPersistence().create(CdsPerformanceAppraisalSlotRatingId);
	}

	public static larion.progate.cds.model.CdsPerformanceAppraisalSlotRating remove(
		java.lang.Integer CdsPerformanceAppraisalSlotRatingId)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPerformanceAppraisalSlotRatingException {
		return getPersistence().remove(CdsPerformanceAppraisalSlotRatingId);
	}

	public static larion.progate.cds.model.CdsPerformanceAppraisalSlotRating remove(
		larion.progate.cds.model.CdsPerformanceAppraisalSlotRating cdsPerformanceAppraisalSlotRating)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(cdsPerformanceAppraisalSlotRating);
	}

	public static larion.progate.cds.model.CdsPerformanceAppraisalSlotRating update(
		larion.progate.cds.model.CdsPerformanceAppraisalSlotRating cdsPerformanceAppraisalSlotRating)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(cdsPerformanceAppraisalSlotRating);
	}

	public static larion.progate.cds.model.CdsPerformanceAppraisalSlotRating update(
		larion.progate.cds.model.CdsPerformanceAppraisalSlotRating cdsPerformanceAppraisalSlotRating,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(cdsPerformanceAppraisalSlotRating, merge);
	}

	public static larion.progate.cds.model.CdsPerformanceAppraisalSlotRating updateImpl(
		larion.progate.cds.model.CdsPerformanceAppraisalSlotRating cdsPerformanceAppraisalSlotRating,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence()
				   .updateImpl(cdsPerformanceAppraisalSlotRating, merge);
	}

	public static larion.progate.cds.model.CdsPerformanceAppraisalSlotRating findByPrimaryKey(
		java.lang.Integer CdsPerformanceAppraisalSlotRatingId)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPerformanceAppraisalSlotRatingException {
		return getPersistence()
				   .findByPrimaryKey(CdsPerformanceAppraisalSlotRatingId);
	}

	public static larion.progate.cds.model.CdsPerformanceAppraisalSlotRating fetchByPrimaryKey(
		java.lang.Integer CdsPerformanceAppraisalSlotRatingId)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .fetchByPrimaryKey(CdsPerformanceAppraisalSlotRatingId);
	}

	public static java.util.List<larion.progate.cds.model.CdsPerformanceAppraisalSlotRating> findByUserId(
		int userId) throws com.liferay.portal.SystemException {
		return getPersistence().findByUserId(userId);
	}

	public static java.util.List<larion.progate.cds.model.CdsPerformanceAppraisalSlotRating> findByUserId(
		int userId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByUserId(userId, start, end);
	}

	public static java.util.List<larion.progate.cds.model.CdsPerformanceAppraisalSlotRating> findByUserId(
		int userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByUserId(userId, start, end, obc);
	}

	public static larion.progate.cds.model.CdsPerformanceAppraisalSlotRating findByUserId_First(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPerformanceAppraisalSlotRatingException {
		return getPersistence().findByUserId_First(userId, obc);
	}

	public static larion.progate.cds.model.CdsPerformanceAppraisalSlotRating findByUserId_Last(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPerformanceAppraisalSlotRatingException {
		return getPersistence().findByUserId_Last(userId, obc);
	}

	public static larion.progate.cds.model.CdsPerformanceAppraisalSlotRating[] findByUserId_PrevAndNext(
		java.lang.Integer CdsPerformanceAppraisalSlotRatingId, int userId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPerformanceAppraisalSlotRatingException {
		return getPersistence()
				   .findByUserId_PrevAndNext(CdsPerformanceAppraisalSlotRatingId,
			userId, obc);
	}

	public static java.util.List<larion.progate.cds.model.CdsPerformanceAppraisalSlotRating> findBySlotId(
		int slotId) throws com.liferay.portal.SystemException {
		return getPersistence().findBySlotId(slotId);
	}

	public static java.util.List<larion.progate.cds.model.CdsPerformanceAppraisalSlotRating> findBySlotId(
		int slotId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBySlotId(slotId, start, end);
	}

	public static java.util.List<larion.progate.cds.model.CdsPerformanceAppraisalSlotRating> findBySlotId(
		int slotId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBySlotId(slotId, start, end, obc);
	}

	public static larion.progate.cds.model.CdsPerformanceAppraisalSlotRating findBySlotId_First(
		int slotId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPerformanceAppraisalSlotRatingException {
		return getPersistence().findBySlotId_First(slotId, obc);
	}

	public static larion.progate.cds.model.CdsPerformanceAppraisalSlotRating findBySlotId_Last(
		int slotId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPerformanceAppraisalSlotRatingException {
		return getPersistence().findBySlotId_Last(slotId, obc);
	}

	public static larion.progate.cds.model.CdsPerformanceAppraisalSlotRating[] findBySlotId_PrevAndNext(
		java.lang.Integer CdsPerformanceAppraisalSlotRatingId, int slotId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPerformanceAppraisalSlotRatingException {
		return getPersistence()
				   .findBySlotId_PrevAndNext(CdsPerformanceAppraisalSlotRatingId,
			slotId, obc);
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

	public static java.util.List<larion.progate.cds.model.CdsPerformanceAppraisalSlotRating> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.cds.model.CdsPerformanceAppraisalSlotRating> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.cds.model.CdsPerformanceAppraisalSlotRating> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByUserId(int userId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByUserId(userId);
	}

	public static void removeBySlotId(int slotId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeBySlotId(slotId);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByUserId(int userId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByUserId(userId);
	}

	public static int countBySlotId(int slotId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countBySlotId(slotId);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static CdsPerformanceAppraisalSlotRatingPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(
		CdsPerformanceAppraisalSlotRatingPersistence persistence) {
		_persistence = persistence;
	}

	private static CdsPerformanceAppraisalSlotRatingPersistence _persistence;
}