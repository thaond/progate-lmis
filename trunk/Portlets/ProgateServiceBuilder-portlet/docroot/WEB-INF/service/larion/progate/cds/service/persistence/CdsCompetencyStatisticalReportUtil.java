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
 * <a href="CdsCompetencyStatisticalReportUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsCompetencyStatisticalReportUtil {
	public static void cacheResult(
		larion.progate.cds.model.CdsCompetencyStatisticalReport cdsCompetencyStatisticalReport) {
		getPersistence().cacheResult(cdsCompetencyStatisticalReport);
	}

	public static void cacheResult(
		java.util.List<larion.progate.cds.model.CdsCompetencyStatisticalReport> cdsCompetencyStatisticalReports) {
		getPersistence().cacheResult(cdsCompetencyStatisticalReports);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.cds.model.CdsCompetencyStatisticalReport create(
		java.lang.Integer competencyId) {
		return getPersistence().create(competencyId);
	}

	public static larion.progate.cds.model.CdsCompetencyStatisticalReport remove(
		java.lang.Integer competencyId)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsCompetencyStatisticalReportException {
		return getPersistence().remove(competencyId);
	}

	public static larion.progate.cds.model.CdsCompetencyStatisticalReport remove(
		larion.progate.cds.model.CdsCompetencyStatisticalReport cdsCompetencyStatisticalReport)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(cdsCompetencyStatisticalReport);
	}

	public static larion.progate.cds.model.CdsCompetencyStatisticalReport update(
		larion.progate.cds.model.CdsCompetencyStatisticalReport cdsCompetencyStatisticalReport)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(cdsCompetencyStatisticalReport);
	}

	public static larion.progate.cds.model.CdsCompetencyStatisticalReport update(
		larion.progate.cds.model.CdsCompetencyStatisticalReport cdsCompetencyStatisticalReport,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(cdsCompetencyStatisticalReport, merge);
	}

	public static larion.progate.cds.model.CdsCompetencyStatisticalReport updateImpl(
		larion.progate.cds.model.CdsCompetencyStatisticalReport cdsCompetencyStatisticalReport,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(cdsCompetencyStatisticalReport, merge);
	}

	public static larion.progate.cds.model.CdsCompetencyStatisticalReport findByPrimaryKey(
		java.lang.Integer competencyId)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsCompetencyStatisticalReportException {
		return getPersistence().findByPrimaryKey(competencyId);
	}

	public static larion.progate.cds.model.CdsCompetencyStatisticalReport fetchByPrimaryKey(
		java.lang.Integer competencyId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(competencyId);
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

	public static java.util.List<larion.progate.cds.model.CdsCompetencyStatisticalReport> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.cds.model.CdsCompetencyStatisticalReport> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.cds.model.CdsCompetencyStatisticalReport> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static CdsCompetencyStatisticalReportPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(
		CdsCompetencyStatisticalReportPersistence persistence) {
		_persistence = persistence;
	}

	private static CdsCompetencyStatisticalReportPersistence _persistence;
}