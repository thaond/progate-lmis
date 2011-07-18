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
 * <a href="CdsTitleMinimumRequirementsUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsTitleMinimumRequirementsUtil {
	public static void cacheResult(
		larion.progate.cds.model.CdsTitleMinimumRequirements cdsTitleMinimumRequirements) {
		getPersistence().cacheResult(cdsTitleMinimumRequirements);
	}

	public static void cacheResult(
		java.util.List<larion.progate.cds.model.CdsTitleMinimumRequirements> cdsTitleMinimumRequirementses) {
		getPersistence().cacheResult(cdsTitleMinimumRequirementses);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.cds.model.CdsTitleMinimumRequirements create(
		java.lang.Integer CdsTitleMinimumRequirementsId) {
		return getPersistence().create(CdsTitleMinimumRequirementsId);
	}

	public static larion.progate.cds.model.CdsTitleMinimumRequirements remove(
		java.lang.Integer CdsTitleMinimumRequirementsId)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsTitleMinimumRequirementsException {
		return getPersistence().remove(CdsTitleMinimumRequirementsId);
	}

	public static larion.progate.cds.model.CdsTitleMinimumRequirements remove(
		larion.progate.cds.model.CdsTitleMinimumRequirements cdsTitleMinimumRequirements)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(cdsTitleMinimumRequirements);
	}

	public static larion.progate.cds.model.CdsTitleMinimumRequirements update(
		larion.progate.cds.model.CdsTitleMinimumRequirements cdsTitleMinimumRequirements)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(cdsTitleMinimumRequirements);
	}

	public static larion.progate.cds.model.CdsTitleMinimumRequirements update(
		larion.progate.cds.model.CdsTitleMinimumRequirements cdsTitleMinimumRequirements,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(cdsTitleMinimumRequirements, merge);
	}

	public static larion.progate.cds.model.CdsTitleMinimumRequirements updateImpl(
		larion.progate.cds.model.CdsTitleMinimumRequirements cdsTitleMinimumRequirements,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(cdsTitleMinimumRequirements, merge);
	}

	public static larion.progate.cds.model.CdsTitleMinimumRequirements findByPrimaryKey(
		java.lang.Integer CdsTitleMinimumRequirementsId)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsTitleMinimumRequirementsException {
		return getPersistence().findByPrimaryKey(CdsTitleMinimumRequirementsId);
	}

	public static larion.progate.cds.model.CdsTitleMinimumRequirements fetchByPrimaryKey(
		java.lang.Integer CdsTitleMinimumRequirementsId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(CdsTitleMinimumRequirementsId);
	}

	public static java.util.List<larion.progate.cds.model.CdsTitleMinimumRequirements> findByTitleId(
		int titleId) throws com.liferay.portal.SystemException {
		return getPersistence().findByTitleId(titleId);
	}

	public static java.util.List<larion.progate.cds.model.CdsTitleMinimumRequirements> findByTitleId(
		int titleId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByTitleId(titleId, start, end);
	}

	public static java.util.List<larion.progate.cds.model.CdsTitleMinimumRequirements> findByTitleId(
		int titleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByTitleId(titleId, start, end, obc);
	}

	public static larion.progate.cds.model.CdsTitleMinimumRequirements findByTitleId_First(
		int titleId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsTitleMinimumRequirementsException {
		return getPersistence().findByTitleId_First(titleId, obc);
	}

	public static larion.progate.cds.model.CdsTitleMinimumRequirements findByTitleId_Last(
		int titleId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsTitleMinimumRequirementsException {
		return getPersistence().findByTitleId_Last(titleId, obc);
	}

	public static larion.progate.cds.model.CdsTitleMinimumRequirements[] findByTitleId_PrevAndNext(
		java.lang.Integer CdsTitleMinimumRequirementsId, int titleId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsTitleMinimumRequirementsException {
		return getPersistence()
				   .findByTitleId_PrevAndNext(CdsTitleMinimumRequirementsId,
			titleId, obc);
	}

	public static java.util.List<larion.progate.cds.model.CdsTitleMinimumRequirements> findByMinimumRequirementId(
		int minimumRequirementId) throws com.liferay.portal.SystemException {
		return getPersistence().findByMinimumRequirementId(minimumRequirementId);
	}

	public static java.util.List<larion.progate.cds.model.CdsTitleMinimumRequirements> findByMinimumRequirementId(
		int minimumRequirementId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByMinimumRequirementId(minimumRequirementId, start, end);
	}

	public static java.util.List<larion.progate.cds.model.CdsTitleMinimumRequirements> findByMinimumRequirementId(
		int minimumRequirementId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByMinimumRequirementId(minimumRequirementId, start,
			end, obc);
	}

	public static larion.progate.cds.model.CdsTitleMinimumRequirements findByMinimumRequirementId_First(
		int minimumRequirementId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsTitleMinimumRequirementsException {
		return getPersistence()
				   .findByMinimumRequirementId_First(minimumRequirementId, obc);
	}

	public static larion.progate.cds.model.CdsTitleMinimumRequirements findByMinimumRequirementId_Last(
		int minimumRequirementId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsTitleMinimumRequirementsException {
		return getPersistence()
				   .findByMinimumRequirementId_Last(minimumRequirementId, obc);
	}

	public static larion.progate.cds.model.CdsTitleMinimumRequirements[] findByMinimumRequirementId_PrevAndNext(
		java.lang.Integer CdsTitleMinimumRequirementsId,
		int minimumRequirementId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsTitleMinimumRequirementsException {
		return getPersistence()
				   .findByMinimumRequirementId_PrevAndNext(CdsTitleMinimumRequirementsId,
			minimumRequirementId, obc);
	}

	public static java.util.List<larion.progate.cds.model.CdsTitleMinimumRequirements> findByMinimumRequirementLevelId(
		int minimumRequirementLevelId)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByMinimumRequirementLevelId(minimumRequirementLevelId);
	}

	public static java.util.List<larion.progate.cds.model.CdsTitleMinimumRequirements> findByMinimumRequirementLevelId(
		int minimumRequirementLevelId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByMinimumRequirementLevelId(minimumRequirementLevelId,
			start, end);
	}

	public static java.util.List<larion.progate.cds.model.CdsTitleMinimumRequirements> findByMinimumRequirementLevelId(
		int minimumRequirementLevelId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByMinimumRequirementLevelId(minimumRequirementLevelId,
			start, end, obc);
	}

	public static larion.progate.cds.model.CdsTitleMinimumRequirements findByMinimumRequirementLevelId_First(
		int minimumRequirementLevelId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsTitleMinimumRequirementsException {
		return getPersistence()
				   .findByMinimumRequirementLevelId_First(minimumRequirementLevelId,
			obc);
	}

	public static larion.progate.cds.model.CdsTitleMinimumRequirements findByMinimumRequirementLevelId_Last(
		int minimumRequirementLevelId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsTitleMinimumRequirementsException {
		return getPersistence()
				   .findByMinimumRequirementLevelId_Last(minimumRequirementLevelId,
			obc);
	}

	public static larion.progate.cds.model.CdsTitleMinimumRequirements[] findByMinimumRequirementLevelId_PrevAndNext(
		java.lang.Integer CdsTitleMinimumRequirementsId,
		int minimumRequirementLevelId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsTitleMinimumRequirementsException {
		return getPersistence()
				   .findByMinimumRequirementLevelId_PrevAndNext(CdsTitleMinimumRequirementsId,
			minimumRequirementLevelId, obc);
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

	public static java.util.List<larion.progate.cds.model.CdsTitleMinimumRequirements> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.cds.model.CdsTitleMinimumRequirements> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.cds.model.CdsTitleMinimumRequirements> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByTitleId(int titleId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByTitleId(titleId);
	}

	public static void removeByMinimumRequirementId(int minimumRequirementId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByMinimumRequirementId(minimumRequirementId);
	}

	public static void removeByMinimumRequirementLevelId(
		int minimumRequirementLevelId)
		throws com.liferay.portal.SystemException {
		getPersistence()
			.removeByMinimumRequirementLevelId(minimumRequirementLevelId);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByTitleId(int titleId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByTitleId(titleId);
	}

	public static int countByMinimumRequirementId(int minimumRequirementId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByMinimumRequirementId(minimumRequirementId);
	}

	public static int countByMinimumRequirementLevelId(
		int minimumRequirementLevelId)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .countByMinimumRequirementLevelId(minimumRequirementLevelId);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static CdsTitleMinimumRequirementsPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(
		CdsTitleMinimumRequirementsPersistence persistence) {
		_persistence = persistence;
	}

	private static CdsTitleMinimumRequirementsPersistence _persistence;
}