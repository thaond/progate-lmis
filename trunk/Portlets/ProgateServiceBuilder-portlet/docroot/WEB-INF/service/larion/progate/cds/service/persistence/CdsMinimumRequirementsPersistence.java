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
 * <a href="CdsMinimumRequirementsPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface CdsMinimumRequirementsPersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.cds.model.CdsMinimumRequirements cdsMinimumRequirements);

	public void cacheResult(
		java.util.List<larion.progate.cds.model.CdsMinimumRequirements> cdsMinimumRequirementses);

	public void clearCache();

	public larion.progate.cds.model.CdsMinimumRequirements create(
		java.lang.Integer minimumRequirementId);

	public larion.progate.cds.model.CdsMinimumRequirements remove(
		java.lang.Integer minimumRequirementId)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsMinimumRequirementsException;

	public larion.progate.cds.model.CdsMinimumRequirements remove(
		larion.progate.cds.model.CdsMinimumRequirements cdsMinimumRequirements)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.CdsMinimumRequirements update(
		larion.progate.cds.model.CdsMinimumRequirements cdsMinimumRequirements)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.CdsMinimumRequirements update(
		larion.progate.cds.model.CdsMinimumRequirements cdsMinimumRequirements,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.CdsMinimumRequirements updateImpl(
		larion.progate.cds.model.CdsMinimumRequirements cdsMinimumRequirements,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.CdsMinimumRequirements findByPrimaryKey(
		java.lang.Integer minimumRequirementId)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsMinimumRequirementsException;

	public larion.progate.cds.model.CdsMinimumRequirements fetchByPrimaryKey(
		java.lang.Integer minimumRequirementId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsMinimumRequirements> findByRootId(
		int rootId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsMinimumRequirements> findByRootId(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsMinimumRequirements> findByRootId(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.CdsMinimumRequirements findByRootId_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsMinimumRequirementsException;

	public larion.progate.cds.model.CdsMinimumRequirements findByRootId_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsMinimumRequirementsException;

	public larion.progate.cds.model.CdsMinimumRequirements[] findByRootId_PrevAndNext(
		java.lang.Integer minimumRequirementId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsMinimumRequirementsException;

	public java.util.List<larion.progate.cds.model.CdsMinimumRequirements> findBynumberOrderGreater(
		int numberOrder) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsMinimumRequirements> findBynumberOrderGreater(
		int numberOrder, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsMinimumRequirements> findBynumberOrderGreater(
		int numberOrder, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.CdsMinimumRequirements findBynumberOrderGreater_First(
		int numberOrder, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsMinimumRequirementsException;

	public larion.progate.cds.model.CdsMinimumRequirements findBynumberOrderGreater_Last(
		int numberOrder, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsMinimumRequirementsException;

	public larion.progate.cds.model.CdsMinimumRequirements[] findBynumberOrderGreater_PrevAndNext(
		java.lang.Integer minimumRequirementId, int numberOrder,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsMinimumRequirementsException;

	public java.util.List<larion.progate.cds.model.CdsMinimumRequirements> findByName(
		java.lang.String name) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsMinimumRequirements> findByName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsMinimumRequirements> findByName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.CdsMinimumRequirements findByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsMinimumRequirementsException;

	public larion.progate.cds.model.CdsMinimumRequirements findByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsMinimumRequirementsException;

	public larion.progate.cds.model.CdsMinimumRequirements[] findByName_PrevAndNext(
		java.lang.Integer minimumRequirementId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsMinimumRequirementsException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsMinimumRequirements> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsMinimumRequirements> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsMinimumRequirements> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByRootId(int rootId)
		throws com.liferay.portal.SystemException;

	public void removeBynumberOrderGreater(int numberOrder)
		throws com.liferay.portal.SystemException;

	public void removeByName(java.lang.String name)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByRootId(int rootId)
		throws com.liferay.portal.SystemException;

	public int countBynumberOrderGreater(int numberOrder)
		throws com.liferay.portal.SystemException;

	public int countByName(java.lang.String name)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsMinimumRequirementLevels> getCdsMinimumRequirementLevelses(
		java.lang.Integer pk) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsMinimumRequirementLevels> getCdsMinimumRequirementLevelses(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsMinimumRequirementLevels> getCdsMinimumRequirementLevelses(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public int getCdsMinimumRequirementLevelsesSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;

	public boolean containsCdsMinimumRequirementLevels(java.lang.Integer pk,
		java.lang.Integer cdsMinimumRequirementLevelsPK)
		throws com.liferay.portal.SystemException;

	public boolean containsCdsMinimumRequirementLevelses(java.lang.Integer pk)
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