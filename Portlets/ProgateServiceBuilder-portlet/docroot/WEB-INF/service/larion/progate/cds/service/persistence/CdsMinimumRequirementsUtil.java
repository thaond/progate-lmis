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
 * <a href="CdsMinimumRequirementsUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsMinimumRequirementsUtil {
	public static void cacheResult(
		larion.progate.cds.model.CdsMinimumRequirements cdsMinimumRequirements) {
		getPersistence().cacheResult(cdsMinimumRequirements);
	}

	public static void cacheResult(
		java.util.List<larion.progate.cds.model.CdsMinimumRequirements> cdsMinimumRequirementses) {
		getPersistence().cacheResult(cdsMinimumRequirementses);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.cds.model.CdsMinimumRequirements create(
		java.lang.Integer minimumRequirementId) {
		return getPersistence().create(minimumRequirementId);
	}

	public static larion.progate.cds.model.CdsMinimumRequirements remove(
		java.lang.Integer minimumRequirementId)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsMinimumRequirementsException {
		return getPersistence().remove(minimumRequirementId);
	}

	public static larion.progate.cds.model.CdsMinimumRequirements remove(
		larion.progate.cds.model.CdsMinimumRequirements cdsMinimumRequirements)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(cdsMinimumRequirements);
	}

	public static larion.progate.cds.model.CdsMinimumRequirements update(
		larion.progate.cds.model.CdsMinimumRequirements cdsMinimumRequirements)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(cdsMinimumRequirements);
	}

	public static larion.progate.cds.model.CdsMinimumRequirements update(
		larion.progate.cds.model.CdsMinimumRequirements cdsMinimumRequirements,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(cdsMinimumRequirements, merge);
	}

	public static larion.progate.cds.model.CdsMinimumRequirements updateImpl(
		larion.progate.cds.model.CdsMinimumRequirements cdsMinimumRequirements,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(cdsMinimumRequirements, merge);
	}

	public static larion.progate.cds.model.CdsMinimumRequirements findByPrimaryKey(
		java.lang.Integer minimumRequirementId)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsMinimumRequirementsException {
		return getPersistence().findByPrimaryKey(minimumRequirementId);
	}

	public static larion.progate.cds.model.CdsMinimumRequirements fetchByPrimaryKey(
		java.lang.Integer minimumRequirementId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(minimumRequirementId);
	}

	public static java.util.List<larion.progate.cds.model.CdsMinimumRequirements> findByRootId(
		int rootId) throws com.liferay.portal.SystemException {
		return getPersistence().findByRootId(rootId);
	}

	public static java.util.List<larion.progate.cds.model.CdsMinimumRequirements> findByRootId(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootId(rootId, start, end);
	}

	public static java.util.List<larion.progate.cds.model.CdsMinimumRequirements> findByRootId(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootId(rootId, start, end, obc);
	}

	public static larion.progate.cds.model.CdsMinimumRequirements findByRootId_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsMinimumRequirementsException {
		return getPersistence().findByRootId_First(rootId, obc);
	}

	public static larion.progate.cds.model.CdsMinimumRequirements findByRootId_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsMinimumRequirementsException {
		return getPersistence().findByRootId_Last(rootId, obc);
	}

	public static larion.progate.cds.model.CdsMinimumRequirements[] findByRootId_PrevAndNext(
		java.lang.Integer minimumRequirementId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsMinimumRequirementsException {
		return getPersistence()
				   .findByRootId_PrevAndNext(minimumRequirementId, rootId, obc);
	}

	public static java.util.List<larion.progate.cds.model.CdsMinimumRequirements> findBynumberOrderGreater(
		int numberOrder) throws com.liferay.portal.SystemException {
		return getPersistence().findBynumberOrderGreater(numberOrder);
	}

	public static java.util.List<larion.progate.cds.model.CdsMinimumRequirements> findBynumberOrderGreater(
		int numberOrder, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBynumberOrderGreater(numberOrder, start, end);
	}

	public static java.util.List<larion.progate.cds.model.CdsMinimumRequirements> findBynumberOrderGreater(
		int numberOrder, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findBynumberOrderGreater(numberOrder, start, end, obc);
	}

	public static larion.progate.cds.model.CdsMinimumRequirements findBynumberOrderGreater_First(
		int numberOrder, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsMinimumRequirementsException {
		return getPersistence().findBynumberOrderGreater_First(numberOrder, obc);
	}

	public static larion.progate.cds.model.CdsMinimumRequirements findBynumberOrderGreater_Last(
		int numberOrder, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsMinimumRequirementsException {
		return getPersistence().findBynumberOrderGreater_Last(numberOrder, obc);
	}

	public static larion.progate.cds.model.CdsMinimumRequirements[] findBynumberOrderGreater_PrevAndNext(
		java.lang.Integer minimumRequirementId, int numberOrder,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsMinimumRequirementsException {
		return getPersistence()
				   .findBynumberOrderGreater_PrevAndNext(minimumRequirementId,
			numberOrder, obc);
	}

	public static java.util.List<larion.progate.cds.model.CdsMinimumRequirements> findByName(
		java.lang.String name) throws com.liferay.portal.SystemException {
		return getPersistence().findByName(name);
	}

	public static java.util.List<larion.progate.cds.model.CdsMinimumRequirements> findByName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByName(name, start, end);
	}

	public static java.util.List<larion.progate.cds.model.CdsMinimumRequirements> findByName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByName(name, start, end, obc);
	}

	public static larion.progate.cds.model.CdsMinimumRequirements findByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsMinimumRequirementsException {
		return getPersistence().findByName_First(name, obc);
	}

	public static larion.progate.cds.model.CdsMinimumRequirements findByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsMinimumRequirementsException {
		return getPersistence().findByName_Last(name, obc);
	}

	public static larion.progate.cds.model.CdsMinimumRequirements[] findByName_PrevAndNext(
		java.lang.Integer minimumRequirementId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsMinimumRequirementsException {
		return getPersistence()
				   .findByName_PrevAndNext(minimumRequirementId, name, obc);
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

	public static java.util.List<larion.progate.cds.model.CdsMinimumRequirements> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.cds.model.CdsMinimumRequirements> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.cds.model.CdsMinimumRequirements> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByRootId(int rootId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByRootId(rootId);
	}

	public static void removeBynumberOrderGreater(int numberOrder)
		throws com.liferay.portal.SystemException {
		getPersistence().removeBynumberOrderGreater(numberOrder);
	}

	public static void removeByName(java.lang.String name)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByName(name);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByRootId(int rootId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByRootId(rootId);
	}

	public static int countBynumberOrderGreater(int numberOrder)
		throws com.liferay.portal.SystemException {
		return getPersistence().countBynumberOrderGreater(numberOrder);
	}

	public static int countByName(java.lang.String name)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByName(name);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static java.util.List<larion.progate.cds.model.CdsMinimumRequirementLevels> getCdsMinimumRequirementLevelses(
		java.lang.Integer pk) throws com.liferay.portal.SystemException {
		return getPersistence().getCdsMinimumRequirementLevelses(pk);
	}

	public static java.util.List<larion.progate.cds.model.CdsMinimumRequirementLevels> getCdsMinimumRequirementLevelses(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().getCdsMinimumRequirementLevelses(pk, start, end);
	}

	public static java.util.List<larion.progate.cds.model.CdsMinimumRequirementLevels> getCdsMinimumRequirementLevelses(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .getCdsMinimumRequirementLevelses(pk, start, end, obc);
	}

	public static int getCdsMinimumRequirementLevelsesSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException {
		return getPersistence().getCdsMinimumRequirementLevelsesSize(pk);
	}

	public static boolean containsCdsMinimumRequirementLevels(
		java.lang.Integer pk, java.lang.Integer cdsMinimumRequirementLevelsPK)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .containsCdsMinimumRequirementLevels(pk,
			cdsMinimumRequirementLevelsPK);
	}

	public static boolean containsCdsMinimumRequirementLevelses(
		java.lang.Integer pk) throws com.liferay.portal.SystemException {
		return getPersistence().containsCdsMinimumRequirementLevelses(pk);
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

	public static CdsMinimumRequirementsPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(CdsMinimumRequirementsPersistence persistence) {
		_persistence = persistence;
	}

	private static CdsMinimumRequirementsPersistence _persistence;
}