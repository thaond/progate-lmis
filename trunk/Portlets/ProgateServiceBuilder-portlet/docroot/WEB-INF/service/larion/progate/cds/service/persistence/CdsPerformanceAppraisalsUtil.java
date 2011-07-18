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
 * <a href="CdsPerformanceAppraisalsUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsPerformanceAppraisalsUtil {
	public static void cacheResult(
		larion.progate.cds.model.CdsPerformanceAppraisals cdsPerformanceAppraisals) {
		getPersistence().cacheResult(cdsPerformanceAppraisals);
	}

	public static void cacheResult(
		java.util.List<larion.progate.cds.model.CdsPerformanceAppraisals> cdsPerformanceAppraisalses) {
		getPersistence().cacheResult(cdsPerformanceAppraisalses);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.cds.model.CdsPerformanceAppraisals create(
		java.lang.Integer cdsPerformanceAppraisalsId) {
		return getPersistence().create(cdsPerformanceAppraisalsId);
	}

	public static larion.progate.cds.model.CdsPerformanceAppraisals remove(
		java.lang.Integer cdsPerformanceAppraisalsId)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPerformanceAppraisalsException {
		return getPersistence().remove(cdsPerformanceAppraisalsId);
	}

	public static larion.progate.cds.model.CdsPerformanceAppraisals remove(
		larion.progate.cds.model.CdsPerformanceAppraisals cdsPerformanceAppraisals)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(cdsPerformanceAppraisals);
	}

	public static larion.progate.cds.model.CdsPerformanceAppraisals update(
		larion.progate.cds.model.CdsPerformanceAppraisals cdsPerformanceAppraisals)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(cdsPerformanceAppraisals);
	}

	public static larion.progate.cds.model.CdsPerformanceAppraisals update(
		larion.progate.cds.model.CdsPerformanceAppraisals cdsPerformanceAppraisals,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(cdsPerformanceAppraisals, merge);
	}

	public static larion.progate.cds.model.CdsPerformanceAppraisals updateImpl(
		larion.progate.cds.model.CdsPerformanceAppraisals cdsPerformanceAppraisals,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(cdsPerformanceAppraisals, merge);
	}

	public static larion.progate.cds.model.CdsPerformanceAppraisals findByPrimaryKey(
		java.lang.Integer cdsPerformanceAppraisalsId)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPerformanceAppraisalsException {
		return getPersistence().findByPrimaryKey(cdsPerformanceAppraisalsId);
	}

	public static larion.progate.cds.model.CdsPerformanceAppraisals fetchByPrimaryKey(
		java.lang.Integer cdsPerformanceAppraisalsId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(cdsPerformanceAppraisalsId);
	}

	public static java.util.List<larion.progate.cds.model.CdsPerformanceAppraisals> findByPeriodId(
		int periodId) throws com.liferay.portal.SystemException {
		return getPersistence().findByPeriodId(periodId);
	}

	public static java.util.List<larion.progate.cds.model.CdsPerformanceAppraisals> findByPeriodId(
		int periodId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByPeriodId(periodId, start, end);
	}

	public static java.util.List<larion.progate.cds.model.CdsPerformanceAppraisals> findByPeriodId(
		int periodId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByPeriodId(periodId, start, end, obc);
	}

	public static larion.progate.cds.model.CdsPerformanceAppraisals findByPeriodId_First(
		int periodId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPerformanceAppraisalsException {
		return getPersistence().findByPeriodId_First(periodId, obc);
	}

	public static larion.progate.cds.model.CdsPerformanceAppraisals findByPeriodId_Last(
		int periodId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPerformanceAppraisalsException {
		return getPersistence().findByPeriodId_Last(periodId, obc);
	}

	public static larion.progate.cds.model.CdsPerformanceAppraisals[] findByPeriodId_PrevAndNext(
		java.lang.Integer cdsPerformanceAppraisalsId, int periodId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPerformanceAppraisalsException {
		return getPersistence()
				   .findByPeriodId_PrevAndNext(cdsPerformanceAppraisalsId,
			periodId, obc);
	}

	public static java.util.List<larion.progate.cds.model.CdsPerformanceAppraisals> findByUserId(
		int userId) throws com.liferay.portal.SystemException {
		return getPersistence().findByUserId(userId);
	}

	public static java.util.List<larion.progate.cds.model.CdsPerformanceAppraisals> findByUserId(
		int userId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByUserId(userId, start, end);
	}

	public static java.util.List<larion.progate.cds.model.CdsPerformanceAppraisals> findByUserId(
		int userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByUserId(userId, start, end, obc);
	}

	public static larion.progate.cds.model.CdsPerformanceAppraisals findByUserId_First(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPerformanceAppraisalsException {
		return getPersistence().findByUserId_First(userId, obc);
	}

	public static larion.progate.cds.model.CdsPerformanceAppraisals findByUserId_Last(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPerformanceAppraisalsException {
		return getPersistence().findByUserId_Last(userId, obc);
	}

	public static larion.progate.cds.model.CdsPerformanceAppraisals[] findByUserId_PrevAndNext(
		java.lang.Integer cdsPerformanceAppraisalsId, int userId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPerformanceAppraisalsException {
		return getPersistence()
				   .findByUserId_PrevAndNext(cdsPerformanceAppraisalsId,
			userId, obc);
	}

	public static java.util.List<larion.progate.cds.model.CdsPerformanceAppraisals> findByRootId(
		int rootId) throws com.liferay.portal.SystemException {
		return getPersistence().findByRootId(rootId);
	}

	public static java.util.List<larion.progate.cds.model.CdsPerformanceAppraisals> findByRootId(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootId(rootId, start, end);
	}

	public static java.util.List<larion.progate.cds.model.CdsPerformanceAppraisals> findByRootId(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootId(rootId, start, end, obc);
	}

	public static larion.progate.cds.model.CdsPerformanceAppraisals findByRootId_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPerformanceAppraisalsException {
		return getPersistence().findByRootId_First(rootId, obc);
	}

	public static larion.progate.cds.model.CdsPerformanceAppraisals findByRootId_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPerformanceAppraisalsException {
		return getPersistence().findByRootId_Last(rootId, obc);
	}

	public static larion.progate.cds.model.CdsPerformanceAppraisals[] findByRootId_PrevAndNext(
		java.lang.Integer cdsPerformanceAppraisalsId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPerformanceAppraisalsException {
		return getPersistence()
				   .findByRootId_PrevAndNext(cdsPerformanceAppraisalsId,
			rootId, obc);
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

	public static java.util.List<larion.progate.cds.model.CdsPerformanceAppraisals> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.cds.model.CdsPerformanceAppraisals> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.cds.model.CdsPerformanceAppraisals> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByPeriodId(int periodId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByPeriodId(periodId);
	}

	public static void removeByUserId(int userId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByUserId(userId);
	}

	public static void removeByRootId(int rootId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByRootId(rootId);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByPeriodId(int periodId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByPeriodId(periodId);
	}

	public static int countByUserId(int userId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByUserId(userId);
	}

	public static int countByRootId(int rootId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByRootId(rootId);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static CdsPerformanceAppraisalsPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(CdsPerformanceAppraisalsPersistence persistence) {
		_persistence = persistence;
	}

	private static CdsPerformanceAppraisalsPersistence _persistence;
}