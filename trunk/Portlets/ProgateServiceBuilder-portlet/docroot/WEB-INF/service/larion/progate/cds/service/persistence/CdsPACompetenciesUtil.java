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
 * <a href="CdsPACompetenciesUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsPACompetenciesUtil {
	public static void cacheResult(
		larion.progate.cds.model.CdsPACompetencies cdsPACompetencies) {
		getPersistence().cacheResult(cdsPACompetencies);
	}

	public static void cacheResult(
		java.util.List<larion.progate.cds.model.CdsPACompetencies> cdsPACompetencieses) {
		getPersistence().cacheResult(cdsPACompetencieses);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.cds.model.CdsPACompetencies create(
		java.lang.Integer CdsPACompetenciesId) {
		return getPersistence().create(CdsPACompetenciesId);
	}

	public static larion.progate.cds.model.CdsPACompetencies remove(
		java.lang.Integer CdsPACompetenciesId)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPACompetenciesException {
		return getPersistence().remove(CdsPACompetenciesId);
	}

	public static larion.progate.cds.model.CdsPACompetencies remove(
		larion.progate.cds.model.CdsPACompetencies cdsPACompetencies)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(cdsPACompetencies);
	}

	public static larion.progate.cds.model.CdsPACompetencies update(
		larion.progate.cds.model.CdsPACompetencies cdsPACompetencies)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(cdsPACompetencies);
	}

	public static larion.progate.cds.model.CdsPACompetencies update(
		larion.progate.cds.model.CdsPACompetencies cdsPACompetencies,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(cdsPACompetencies, merge);
	}

	public static larion.progate.cds.model.CdsPACompetencies updateImpl(
		larion.progate.cds.model.CdsPACompetencies cdsPACompetencies,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(cdsPACompetencies, merge);
	}

	public static larion.progate.cds.model.CdsPACompetencies findByPrimaryKey(
		java.lang.Integer CdsPACompetenciesId)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPACompetenciesException {
		return getPersistence().findByPrimaryKey(CdsPACompetenciesId);
	}

	public static larion.progate.cds.model.CdsPACompetencies fetchByPrimaryKey(
		java.lang.Integer CdsPACompetenciesId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(CdsPACompetenciesId);
	}

	public static java.util.List<larion.progate.cds.model.CdsPACompetencies> findByPeriodId(
		int periodId) throws com.liferay.portal.SystemException {
		return getPersistence().findByPeriodId(periodId);
	}

	public static java.util.List<larion.progate.cds.model.CdsPACompetencies> findByPeriodId(
		int periodId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByPeriodId(periodId, start, end);
	}

	public static java.util.List<larion.progate.cds.model.CdsPACompetencies> findByPeriodId(
		int periodId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByPeriodId(periodId, start, end, obc);
	}

	public static larion.progate.cds.model.CdsPACompetencies findByPeriodId_First(
		int periodId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPACompetenciesException {
		return getPersistence().findByPeriodId_First(periodId, obc);
	}

	public static larion.progate.cds.model.CdsPACompetencies findByPeriodId_Last(
		int periodId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPACompetenciesException {
		return getPersistence().findByPeriodId_Last(periodId, obc);
	}

	public static larion.progate.cds.model.CdsPACompetencies[] findByPeriodId_PrevAndNext(
		java.lang.Integer CdsPACompetenciesId, int periodId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPACompetenciesException {
		return getPersistence()
				   .findByPeriodId_PrevAndNext(CdsPACompetenciesId, periodId,
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

	public static java.util.List<larion.progate.cds.model.CdsPACompetencies> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.cds.model.CdsPACompetencies> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.cds.model.CdsPACompetencies> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByPeriodId(int periodId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByPeriodId(periodId);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByPeriodId(int periodId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByPeriodId(periodId);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static CdsPACompetenciesPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(CdsPACompetenciesPersistence persistence) {
		_persistence = persistence;
	}

	private static CdsPACompetenciesPersistence _persistence;
}