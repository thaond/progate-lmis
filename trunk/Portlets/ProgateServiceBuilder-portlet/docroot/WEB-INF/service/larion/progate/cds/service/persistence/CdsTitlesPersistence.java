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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * <a href="CdsTitlesPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface CdsTitlesPersistence extends BasePersistence {
	public void cacheResult(larion.progate.cds.model.CdsTitles cdsTitles);

	public void cacheResult(
		java.util.List<larion.progate.cds.model.CdsTitles> cdsTitleses);

	public void clearCache();

	public larion.progate.cds.model.CdsTitles create(
		java.lang.Integer cdsTitleId);

	public larion.progate.cds.model.CdsTitles remove(
		java.lang.Integer cdsTitleId)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsTitlesException;

	public larion.progate.cds.model.CdsTitles remove(
		larion.progate.cds.model.CdsTitles cdsTitles)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.CdsTitles update(
		larion.progate.cds.model.CdsTitles cdsTitles)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.CdsTitles update(
		larion.progate.cds.model.CdsTitles cdsTitles, boolean merge)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.CdsTitles updateImpl(
		larion.progate.cds.model.CdsTitles cdsTitles, boolean merge)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.CdsTitles findByPrimaryKey(
		java.lang.Integer cdsTitleId)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsTitlesException;

	public larion.progate.cds.model.CdsTitles fetchByPrimaryKey(
		java.lang.Integer cdsTitleId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsTitles> findByRootId(
		int rootId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsTitles> findByRootId(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsTitles> findByRootId(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.CdsTitles findByRootId_First(int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsTitlesException;

	public larion.progate.cds.model.CdsTitles findByRootId_Last(int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsTitlesException;

	public larion.progate.cds.model.CdsTitles[] findByRootId_PrevAndNext(
		java.lang.Integer cdsTitleId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsTitlesException;

	public java.util.List<larion.progate.cds.model.CdsTitles> findBynumberOrderGreater(
		int numberOrder) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsTitles> findBynumberOrderGreater(
		int numberOrder, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsTitles> findBynumberOrderGreater(
		int numberOrder, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.CdsTitles findBynumberOrderGreater_First(
		int numberOrder, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsTitlesException;

	public larion.progate.cds.model.CdsTitles findBynumberOrderGreater_Last(
		int numberOrder, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsTitlesException;

	public larion.progate.cds.model.CdsTitles[] findBynumberOrderGreater_PrevAndNext(
		java.lang.Integer cdsTitleId, int numberOrder,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsTitlesException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsTitles> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsTitles> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsTitles> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByRootId(int rootId)
		throws com.liferay.portal.SystemException;

	public void removeBynumberOrderGreater(int numberOrder)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByRootId(int rootId)
		throws com.liferay.portal.SystemException;

	public int countBynumberOrderGreater(int numberOrder)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsPAFinal> getCdsPAFinals(
		java.lang.Integer pk) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsPAFinal> getCdsPAFinals(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsPAFinal> getCdsPAFinals(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public int getCdsPAFinalsSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;

	public boolean containsCdsPAFinal(java.lang.Integer pk,
		java.lang.Integer cdsPAFinalPK)
		throws com.liferay.portal.SystemException;

	public boolean containsCdsPAFinals(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsTitleCompetencies> getCdsTitleCompetencieses(
		java.lang.Integer pk) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsTitleCompetencies> getCdsTitleCompetencieses(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsTitleCompetencies> getCdsTitleCompetencieses(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public int getCdsTitleCompetenciesesSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;

	public boolean containsCdsTitleCompetencies(java.lang.Integer pk,
		java.lang.Integer cdsTitleCompetenciesPK)
		throws com.liferay.portal.SystemException;

	public boolean containsCdsTitleCompetencieses(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsTitleMinimumRequirements> getCdsTitleMinimumRequirementses(
		java.lang.Integer pk) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsTitleMinimumRequirements> getCdsTitleMinimumRequirementses(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsTitleMinimumRequirements> getCdsTitleMinimumRequirementses(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public int getCdsTitleMinimumRequirementsesSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;

	public boolean containsCdsTitleMinimumRequirements(java.lang.Integer pk,
		java.lang.Integer cdsTitleMinimumRequirementsPK)
		throws com.liferay.portal.SystemException;

	public boolean containsCdsTitleMinimumRequirementses(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;
}