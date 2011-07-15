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
 * <a href="CdsEvaluationPeriodsUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsEvaluationPeriodsUtil {
	public static void cacheResult(
		larion.progate.cds.model.CdsEvaluationPeriods cdsEvaluationPeriods) {
		getPersistence().cacheResult(cdsEvaluationPeriods);
	}

	public static void cacheResult(
		java.util.List<larion.progate.cds.model.CdsEvaluationPeriods> cdsEvaluationPeriodses) {
		getPersistence().cacheResult(cdsEvaluationPeriodses);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.cds.model.CdsEvaluationPeriods create(
		java.lang.Integer CdsEvaluationPeriodsId) {
		return getPersistence().create(CdsEvaluationPeriodsId);
	}

	public static larion.progate.cds.model.CdsEvaluationPeriods remove(
		java.lang.Integer CdsEvaluationPeriodsId)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsEvaluationPeriodsException {
		return getPersistence().remove(CdsEvaluationPeriodsId);
	}

	public static larion.progate.cds.model.CdsEvaluationPeriods remove(
		larion.progate.cds.model.CdsEvaluationPeriods cdsEvaluationPeriods)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(cdsEvaluationPeriods);
	}

	public static larion.progate.cds.model.CdsEvaluationPeriods update(
		larion.progate.cds.model.CdsEvaluationPeriods cdsEvaluationPeriods)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(cdsEvaluationPeriods);
	}

	public static larion.progate.cds.model.CdsEvaluationPeriods update(
		larion.progate.cds.model.CdsEvaluationPeriods cdsEvaluationPeriods,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(cdsEvaluationPeriods, merge);
	}

	public static larion.progate.cds.model.CdsEvaluationPeriods updateImpl(
		larion.progate.cds.model.CdsEvaluationPeriods cdsEvaluationPeriods,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(cdsEvaluationPeriods, merge);
	}

	public static larion.progate.cds.model.CdsEvaluationPeriods findByPrimaryKey(
		java.lang.Integer CdsEvaluationPeriodsId)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsEvaluationPeriodsException {
		return getPersistence().findByPrimaryKey(CdsEvaluationPeriodsId);
	}

	public static larion.progate.cds.model.CdsEvaluationPeriods fetchByPrimaryKey(
		java.lang.Integer CdsEvaluationPeriodsId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(CdsEvaluationPeriodsId);
	}

	public static java.util.List<larion.progate.cds.model.CdsEvaluationPeriods> findBystatus(
		int status) throws com.liferay.portal.SystemException {
		return getPersistence().findBystatus(status);
	}

	public static java.util.List<larion.progate.cds.model.CdsEvaluationPeriods> findBystatus(
		int status, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBystatus(status, start, end);
	}

	public static java.util.List<larion.progate.cds.model.CdsEvaluationPeriods> findBystatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBystatus(status, start, end, obc);
	}

	public static larion.progate.cds.model.CdsEvaluationPeriods findBystatus_First(
		int status, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsEvaluationPeriodsException {
		return getPersistence().findBystatus_First(status, obc);
	}

	public static larion.progate.cds.model.CdsEvaluationPeriods findBystatus_Last(
		int status, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsEvaluationPeriodsException {
		return getPersistence().findBystatus_Last(status, obc);
	}

	public static larion.progate.cds.model.CdsEvaluationPeriods[] findBystatus_PrevAndNext(
		java.lang.Integer CdsEvaluationPeriodsId, int status,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsEvaluationPeriodsException {
		return getPersistence()
				   .findBystatus_PrevAndNext(CdsEvaluationPeriodsId, status, obc);
	}

	public static java.util.List<larion.progate.cds.model.CdsEvaluationPeriods> findByrootId(
		int rootId) throws com.liferay.portal.SystemException {
		return getPersistence().findByrootId(rootId);
	}

	public static java.util.List<larion.progate.cds.model.CdsEvaluationPeriods> findByrootId(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByrootId(rootId, start, end);
	}

	public static java.util.List<larion.progate.cds.model.CdsEvaluationPeriods> findByrootId(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByrootId(rootId, start, end, obc);
	}

	public static larion.progate.cds.model.CdsEvaluationPeriods findByrootId_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsEvaluationPeriodsException {
		return getPersistence().findByrootId_First(rootId, obc);
	}

	public static larion.progate.cds.model.CdsEvaluationPeriods findByrootId_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsEvaluationPeriodsException {
		return getPersistence().findByrootId_Last(rootId, obc);
	}

	public static larion.progate.cds.model.CdsEvaluationPeriods[] findByrootId_PrevAndNext(
		java.lang.Integer CdsEvaluationPeriodsId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsEvaluationPeriodsException {
		return getPersistence()
				   .findByrootId_PrevAndNext(CdsEvaluationPeriodsId, rootId, obc);
	}

	public static java.util.List<larion.progate.cds.model.CdsEvaluationPeriods> findByisModified(
		boolean isModified) throws com.liferay.portal.SystemException {
		return getPersistence().findByisModified(isModified);
	}

	public static java.util.List<larion.progate.cds.model.CdsEvaluationPeriods> findByisModified(
		boolean isModified, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByisModified(isModified, start, end);
	}

	public static java.util.List<larion.progate.cds.model.CdsEvaluationPeriods> findByisModified(
		boolean isModified, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByisModified(isModified, start, end, obc);
	}

	public static larion.progate.cds.model.CdsEvaluationPeriods findByisModified_First(
		boolean isModified, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsEvaluationPeriodsException {
		return getPersistence().findByisModified_First(isModified, obc);
	}

	public static larion.progate.cds.model.CdsEvaluationPeriods findByisModified_Last(
		boolean isModified, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsEvaluationPeriodsException {
		return getPersistence().findByisModified_Last(isModified, obc);
	}

	public static larion.progate.cds.model.CdsEvaluationPeriods[] findByisModified_PrevAndNext(
		java.lang.Integer CdsEvaluationPeriodsId, boolean isModified,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsEvaluationPeriodsException {
		return getPersistence()
				   .findByisModified_PrevAndNext(CdsEvaluationPeriodsId,
			isModified, obc);
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

	public static java.util.List<larion.progate.cds.model.CdsEvaluationPeriods> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.cds.model.CdsEvaluationPeriods> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.cds.model.CdsEvaluationPeriods> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeBystatus(int status)
		throws com.liferay.portal.SystemException {
		getPersistence().removeBystatus(status);
	}

	public static void removeByrootId(int rootId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByrootId(rootId);
	}

	public static void removeByisModified(boolean isModified)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByisModified(isModified);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countBystatus(int status)
		throws com.liferay.portal.SystemException {
		return getPersistence().countBystatus(status);
	}

	public static int countByrootId(int rootId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByrootId(rootId);
	}

	public static int countByisModified(boolean isModified)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByisModified(isModified);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static CdsEvaluationPeriodsPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(CdsEvaluationPeriodsPersistence persistence) {
		_persistence = persistence;
	}

	private static CdsEvaluationPeriodsPersistence _persistence;
}