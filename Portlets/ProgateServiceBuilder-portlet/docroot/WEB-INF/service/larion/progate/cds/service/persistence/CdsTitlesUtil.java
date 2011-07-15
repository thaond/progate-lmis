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
 * <a href="CdsTitlesUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsTitlesUtil {
	public static void cacheResult(larion.progate.cds.model.CdsTitles cdsTitles) {
		getPersistence().cacheResult(cdsTitles);
	}

	public static void cacheResult(
		java.util.List<larion.progate.cds.model.CdsTitles> cdsTitleses) {
		getPersistence().cacheResult(cdsTitleses);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.cds.model.CdsTitles create(
		java.lang.Integer cdsTitleId) {
		return getPersistence().create(cdsTitleId);
	}

	public static larion.progate.cds.model.CdsTitles remove(
		java.lang.Integer cdsTitleId)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsTitlesException {
		return getPersistence().remove(cdsTitleId);
	}

	public static larion.progate.cds.model.CdsTitles remove(
		larion.progate.cds.model.CdsTitles cdsTitles)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(cdsTitles);
	}

	public static larion.progate.cds.model.CdsTitles update(
		larion.progate.cds.model.CdsTitles cdsTitles)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(cdsTitles);
	}

	public static larion.progate.cds.model.CdsTitles update(
		larion.progate.cds.model.CdsTitles cdsTitles, boolean merge)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(cdsTitles, merge);
	}

	public static larion.progate.cds.model.CdsTitles updateImpl(
		larion.progate.cds.model.CdsTitles cdsTitles, boolean merge)
		throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(cdsTitles, merge);
	}

	public static larion.progate.cds.model.CdsTitles findByPrimaryKey(
		java.lang.Integer cdsTitleId)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsTitlesException {
		return getPersistence().findByPrimaryKey(cdsTitleId);
	}

	public static larion.progate.cds.model.CdsTitles fetchByPrimaryKey(
		java.lang.Integer cdsTitleId) throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(cdsTitleId);
	}

	public static java.util.List<larion.progate.cds.model.CdsTitles> findByRootId(
		int rootId) throws com.liferay.portal.SystemException {
		return getPersistence().findByRootId(rootId);
	}

	public static java.util.List<larion.progate.cds.model.CdsTitles> findByRootId(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootId(rootId, start, end);
	}

	public static java.util.List<larion.progate.cds.model.CdsTitles> findByRootId(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootId(rootId, start, end, obc);
	}

	public static larion.progate.cds.model.CdsTitles findByRootId_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsTitlesException {
		return getPersistence().findByRootId_First(rootId, obc);
	}

	public static larion.progate.cds.model.CdsTitles findByRootId_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsTitlesException {
		return getPersistence().findByRootId_Last(rootId, obc);
	}

	public static larion.progate.cds.model.CdsTitles[] findByRootId_PrevAndNext(
		java.lang.Integer cdsTitleId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsTitlesException {
		return getPersistence().findByRootId_PrevAndNext(cdsTitleId, rootId, obc);
	}

	public static java.util.List<larion.progate.cds.model.CdsTitles> findBynumberOrderGreater(
		int numberOrder) throws com.liferay.portal.SystemException {
		return getPersistence().findBynumberOrderGreater(numberOrder);
	}

	public static java.util.List<larion.progate.cds.model.CdsTitles> findBynumberOrderGreater(
		int numberOrder, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBynumberOrderGreater(numberOrder, start, end);
	}

	public static java.util.List<larion.progate.cds.model.CdsTitles> findBynumberOrderGreater(
		int numberOrder, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findBynumberOrderGreater(numberOrder, start, end, obc);
	}

	public static larion.progate.cds.model.CdsTitles findBynumberOrderGreater_First(
		int numberOrder, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsTitlesException {
		return getPersistence().findBynumberOrderGreater_First(numberOrder, obc);
	}

	public static larion.progate.cds.model.CdsTitles findBynumberOrderGreater_Last(
		int numberOrder, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsTitlesException {
		return getPersistence().findBynumberOrderGreater_Last(numberOrder, obc);
	}

	public static larion.progate.cds.model.CdsTitles[] findBynumberOrderGreater_PrevAndNext(
		java.lang.Integer cdsTitleId, int numberOrder,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsTitlesException {
		return getPersistence()
				   .findBynumberOrderGreater_PrevAndNext(cdsTitleId,
			numberOrder, obc);
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

	public static java.util.List<larion.progate.cds.model.CdsTitles> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.cds.model.CdsTitles> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.cds.model.CdsTitles> findAll(
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

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static java.util.List<larion.progate.cds.model.CdsPAFinal> getCdsPAFinals(
		java.lang.Integer pk) throws com.liferay.portal.SystemException {
		return getPersistence().getCdsPAFinals(pk);
	}

	public static java.util.List<larion.progate.cds.model.CdsPAFinal> getCdsPAFinals(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().getCdsPAFinals(pk, start, end);
	}

	public static java.util.List<larion.progate.cds.model.CdsPAFinal> getCdsPAFinals(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().getCdsPAFinals(pk, start, end, obc);
	}

	public static int getCdsPAFinalsSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException {
		return getPersistence().getCdsPAFinalsSize(pk);
	}

	public static boolean containsCdsPAFinal(java.lang.Integer pk,
		java.lang.Integer cdsPAFinalPK)
		throws com.liferay.portal.SystemException {
		return getPersistence().containsCdsPAFinal(pk, cdsPAFinalPK);
	}

	public static boolean containsCdsPAFinals(java.lang.Integer pk)
		throws com.liferay.portal.SystemException {
		return getPersistence().containsCdsPAFinals(pk);
	}

	public static java.util.List<larion.progate.cds.model.CdsTitleCompetencies> getCdsTitleCompetencieses(
		java.lang.Integer pk) throws com.liferay.portal.SystemException {
		return getPersistence().getCdsTitleCompetencieses(pk);
	}

	public static java.util.List<larion.progate.cds.model.CdsTitleCompetencies> getCdsTitleCompetencieses(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().getCdsTitleCompetencieses(pk, start, end);
	}

	public static java.util.List<larion.progate.cds.model.CdsTitleCompetencies> getCdsTitleCompetencieses(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().getCdsTitleCompetencieses(pk, start, end, obc);
	}

	public static int getCdsTitleCompetenciesesSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException {
		return getPersistence().getCdsTitleCompetenciesesSize(pk);
	}

	public static boolean containsCdsTitleCompetencies(java.lang.Integer pk,
		java.lang.Integer cdsTitleCompetenciesPK)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .containsCdsTitleCompetencies(pk, cdsTitleCompetenciesPK);
	}

	public static boolean containsCdsTitleCompetencieses(java.lang.Integer pk)
		throws com.liferay.portal.SystemException {
		return getPersistence().containsCdsTitleCompetencieses(pk);
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

	public static CdsTitlesPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(CdsTitlesPersistence persistence) {
		_persistence = persistence;
	}

	private static CdsTitlesPersistence _persistence;
}