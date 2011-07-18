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
 * <a href="CdsMinimumRequirementLevelsUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsMinimumRequirementLevelsUtil {
	public static void cacheResult(
		larion.progate.cds.model.CdsMinimumRequirementLevels cdsMinimumRequirementLevels) {
		getPersistence().cacheResult(cdsMinimumRequirementLevels);
	}

	public static void cacheResult(
		java.util.List<larion.progate.cds.model.CdsMinimumRequirementLevels> cdsMinimumRequirementLevelses) {
		getPersistence().cacheResult(cdsMinimumRequirementLevelses);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.cds.model.CdsMinimumRequirementLevels create(
		java.lang.Integer minimumRequirementLevelId) {
		return getPersistence().create(minimumRequirementLevelId);
	}

	public static larion.progate.cds.model.CdsMinimumRequirementLevels remove(
		java.lang.Integer minimumRequirementLevelId)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsMinimumRequirementLevelsException {
		return getPersistence().remove(minimumRequirementLevelId);
	}

	public static larion.progate.cds.model.CdsMinimumRequirementLevels remove(
		larion.progate.cds.model.CdsMinimumRequirementLevels cdsMinimumRequirementLevels)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(cdsMinimumRequirementLevels);
	}

	public static larion.progate.cds.model.CdsMinimumRequirementLevels update(
		larion.progate.cds.model.CdsMinimumRequirementLevels cdsMinimumRequirementLevels)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(cdsMinimumRequirementLevels);
	}

	public static larion.progate.cds.model.CdsMinimumRequirementLevels update(
		larion.progate.cds.model.CdsMinimumRequirementLevels cdsMinimumRequirementLevels,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(cdsMinimumRequirementLevels, merge);
	}

	public static larion.progate.cds.model.CdsMinimumRequirementLevels updateImpl(
		larion.progate.cds.model.CdsMinimumRequirementLevels cdsMinimumRequirementLevels,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(cdsMinimumRequirementLevels, merge);
	}

	public static larion.progate.cds.model.CdsMinimumRequirementLevels findByPrimaryKey(
		java.lang.Integer minimumRequirementLevelId)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsMinimumRequirementLevelsException {
		return getPersistence().findByPrimaryKey(minimumRequirementLevelId);
	}

	public static larion.progate.cds.model.CdsMinimumRequirementLevels fetchByPrimaryKey(
		java.lang.Integer minimumRequirementLevelId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(minimumRequirementLevelId);
	}

	public static java.util.List<larion.progate.cds.model.CdsMinimumRequirementLevels> findByMinimumRequirementId(
		int minimumRequirementId) throws com.liferay.portal.SystemException {
		return getPersistence().findByMinimumRequirementId(minimumRequirementId);
	}

	public static java.util.List<larion.progate.cds.model.CdsMinimumRequirementLevels> findByMinimumRequirementId(
		int minimumRequirementId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByMinimumRequirementId(minimumRequirementId, start, end);
	}

	public static java.util.List<larion.progate.cds.model.CdsMinimumRequirementLevels> findByMinimumRequirementId(
		int minimumRequirementId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByMinimumRequirementId(minimumRequirementId, start,
			end, obc);
	}

	public static larion.progate.cds.model.CdsMinimumRequirementLevels findByMinimumRequirementId_First(
		int minimumRequirementId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsMinimumRequirementLevelsException {
		return getPersistence()
				   .findByMinimumRequirementId_First(minimumRequirementId, obc);
	}

	public static larion.progate.cds.model.CdsMinimumRequirementLevels findByMinimumRequirementId_Last(
		int minimumRequirementId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsMinimumRequirementLevelsException {
		return getPersistence()
				   .findByMinimumRequirementId_Last(minimumRequirementId, obc);
	}

	public static larion.progate.cds.model.CdsMinimumRequirementLevels[] findByMinimumRequirementId_PrevAndNext(
		java.lang.Integer minimumRequirementLevelId, int minimumRequirementId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsMinimumRequirementLevelsException {
		return getPersistence()
				   .findByMinimumRequirementId_PrevAndNext(minimumRequirementLevelId,
			minimumRequirementId, obc);
	}

	public static java.util.List<larion.progate.cds.model.CdsMinimumRequirementLevels> findByName(
		java.lang.String name) throws com.liferay.portal.SystemException {
		return getPersistence().findByName(name);
	}

	public static java.util.List<larion.progate.cds.model.CdsMinimumRequirementLevels> findByName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByName(name, start, end);
	}

	public static java.util.List<larion.progate.cds.model.CdsMinimumRequirementLevels> findByName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByName(name, start, end, obc);
	}

	public static larion.progate.cds.model.CdsMinimumRequirementLevels findByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsMinimumRequirementLevelsException {
		return getPersistence().findByName_First(name, obc);
	}

	public static larion.progate.cds.model.CdsMinimumRequirementLevels findByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsMinimumRequirementLevelsException {
		return getPersistence().findByName_Last(name, obc);
	}

	public static larion.progate.cds.model.CdsMinimumRequirementLevels[] findByName_PrevAndNext(
		java.lang.Integer minimumRequirementLevelId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsMinimumRequirementLevelsException {
		return getPersistence()
				   .findByName_PrevAndNext(minimumRequirementLevelId, name, obc);
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

	public static java.util.List<larion.progate.cds.model.CdsMinimumRequirementLevels> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.cds.model.CdsMinimumRequirementLevels> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.cds.model.CdsMinimumRequirementLevels> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByMinimumRequirementId(int minimumRequirementId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByMinimumRequirementId(minimumRequirementId);
	}

	public static void removeByName(java.lang.String name)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByName(name);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByMinimumRequirementId(int minimumRequirementId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByMinimumRequirementId(minimumRequirementId);
	}

	public static int countByName(java.lang.String name)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByName(name);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static java.util.List<larion.progate.cds.model.CdsTitleMinimumRequirements> getCdsTitleMinimumRequirementses(
		java.lang.Integer pk) throws com.liferay.portal.SystemException {
		return getPersistence().getCdsTitleMinimumRequirementses(pk);
	}

	public static java.util.List<larion.progate.cds.model.CdsTitleMinimumRequirements> getCdsTitleMinimumRequirementses(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().getCdsTitleMinimumRequirementses(pk, start, end);
	}

	public static java.util.List<larion.progate.cds.model.CdsTitleMinimumRequirements> getCdsTitleMinimumRequirementses(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .getCdsTitleMinimumRequirementses(pk, start, end, obc);
	}

	public static int getCdsTitleMinimumRequirementsesSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException {
		return getPersistence().getCdsTitleMinimumRequirementsesSize(pk);
	}

	public static boolean containsCdsTitleMinimumRequirements(
		java.lang.Integer pk, java.lang.Integer cdsTitleMinimumRequirementsPK)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .containsCdsTitleMinimumRequirements(pk,
			cdsTitleMinimumRequirementsPK);
	}

	public static boolean containsCdsTitleMinimumRequirementses(
		java.lang.Integer pk) throws com.liferay.portal.SystemException {
		return getPersistence().containsCdsTitleMinimumRequirementses(pk);
	}

	public static CdsMinimumRequirementLevelsPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(
		CdsMinimumRequirementLevelsPersistence persistence) {
		_persistence = persistence;
	}

	private static CdsMinimumRequirementLevelsPersistence _persistence;
}