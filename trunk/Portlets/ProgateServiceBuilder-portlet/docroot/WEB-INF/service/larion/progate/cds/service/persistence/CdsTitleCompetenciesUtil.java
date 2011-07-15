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
 * <a href="CdsTitleCompetenciesUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsTitleCompetenciesUtil {
	public static void cacheResult(
		larion.progate.cds.model.CdsTitleCompetencies cdsTitleCompetencies) {
		getPersistence().cacheResult(cdsTitleCompetencies);
	}

	public static void cacheResult(
		java.util.List<larion.progate.cds.model.CdsTitleCompetencies> cdsTitleCompetencieses) {
		getPersistence().cacheResult(cdsTitleCompetencieses);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.cds.model.CdsTitleCompetencies create(
		java.lang.Integer CdsTitleCompetenciesId) {
		return getPersistence().create(CdsTitleCompetenciesId);
	}

	public static larion.progate.cds.model.CdsTitleCompetencies remove(
		java.lang.Integer CdsTitleCompetenciesId)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsTitleCompetenciesException {
		return getPersistence().remove(CdsTitleCompetenciesId);
	}

	public static larion.progate.cds.model.CdsTitleCompetencies remove(
		larion.progate.cds.model.CdsTitleCompetencies cdsTitleCompetencies)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(cdsTitleCompetencies);
	}

	public static larion.progate.cds.model.CdsTitleCompetencies update(
		larion.progate.cds.model.CdsTitleCompetencies cdsTitleCompetencies)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(cdsTitleCompetencies);
	}

	public static larion.progate.cds.model.CdsTitleCompetencies update(
		larion.progate.cds.model.CdsTitleCompetencies cdsTitleCompetencies,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(cdsTitleCompetencies, merge);
	}

	public static larion.progate.cds.model.CdsTitleCompetencies updateImpl(
		larion.progate.cds.model.CdsTitleCompetencies cdsTitleCompetencies,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(cdsTitleCompetencies, merge);
	}

	public static larion.progate.cds.model.CdsTitleCompetencies findByPrimaryKey(
		java.lang.Integer CdsTitleCompetenciesId)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsTitleCompetenciesException {
		return getPersistence().findByPrimaryKey(CdsTitleCompetenciesId);
	}

	public static larion.progate.cds.model.CdsTitleCompetencies fetchByPrimaryKey(
		java.lang.Integer CdsTitleCompetenciesId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(CdsTitleCompetenciesId);
	}

	public static java.util.List<larion.progate.cds.model.CdsTitleCompetencies> findByCdsTitleId(
		int cdsTitleId) throws com.liferay.portal.SystemException {
		return getPersistence().findByCdsTitleId(cdsTitleId);
	}

	public static java.util.List<larion.progate.cds.model.CdsTitleCompetencies> findByCdsTitleId(
		int cdsTitleId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByCdsTitleId(cdsTitleId, start, end);
	}

	public static java.util.List<larion.progate.cds.model.CdsTitleCompetencies> findByCdsTitleId(
		int cdsTitleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByCdsTitleId(cdsTitleId, start, end, obc);
	}

	public static larion.progate.cds.model.CdsTitleCompetencies findByCdsTitleId_First(
		int cdsTitleId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsTitleCompetenciesException {
		return getPersistence().findByCdsTitleId_First(cdsTitleId, obc);
	}

	public static larion.progate.cds.model.CdsTitleCompetencies findByCdsTitleId_Last(
		int cdsTitleId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsTitleCompetenciesException {
		return getPersistence().findByCdsTitleId_Last(cdsTitleId, obc);
	}

	public static larion.progate.cds.model.CdsTitleCompetencies[] findByCdsTitleId_PrevAndNext(
		java.lang.Integer CdsTitleCompetenciesId, int cdsTitleId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsTitleCompetenciesException {
		return getPersistence()
				   .findByCdsTitleId_PrevAndNext(CdsTitleCompetenciesId,
			cdsTitleId, obc);
	}

	public static java.util.List<larion.progate.cds.model.CdsTitleCompetencies> findByCompetencyId(
		int competencyId) throws com.liferay.portal.SystemException {
		return getPersistence().findByCompetencyId(competencyId);
	}

	public static java.util.List<larion.progate.cds.model.CdsTitleCompetencies> findByCompetencyId(
		int competencyId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByCompetencyId(competencyId, start, end);
	}

	public static java.util.List<larion.progate.cds.model.CdsTitleCompetencies> findByCompetencyId(
		int competencyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByCompetencyId(competencyId, start, end, obc);
	}

	public static larion.progate.cds.model.CdsTitleCompetencies findByCompetencyId_First(
		int competencyId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsTitleCompetenciesException {
		return getPersistence().findByCompetencyId_First(competencyId, obc);
	}

	public static larion.progate.cds.model.CdsTitleCompetencies findByCompetencyId_Last(
		int competencyId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsTitleCompetenciesException {
		return getPersistence().findByCompetencyId_Last(competencyId, obc);
	}

	public static larion.progate.cds.model.CdsTitleCompetencies[] findByCompetencyId_PrevAndNext(
		java.lang.Integer CdsTitleCompetenciesId, int competencyId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsTitleCompetenciesException {
		return getPersistence()
				   .findByCompetencyId_PrevAndNext(CdsTitleCompetenciesId,
			competencyId, obc);
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

	public static java.util.List<larion.progate.cds.model.CdsTitleCompetencies> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.cds.model.CdsTitleCompetencies> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.cds.model.CdsTitleCompetencies> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByCdsTitleId(int cdsTitleId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByCdsTitleId(cdsTitleId);
	}

	public static void removeByCompetencyId(int competencyId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByCompetencyId(competencyId);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByCdsTitleId(int cdsTitleId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByCdsTitleId(cdsTitleId);
	}

	public static int countByCompetencyId(int competencyId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByCompetencyId(competencyId);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static CdsTitleCompetenciesPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(CdsTitleCompetenciesPersistence persistence) {
		_persistence = persistence;
	}

	private static CdsTitleCompetenciesPersistence _persistence;
}