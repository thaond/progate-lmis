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
 * <a href="CdsTitleMinimumRequirementsPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface CdsTitleMinimumRequirementsPersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.cds.model.CdsTitleMinimumRequirements cdsTitleMinimumRequirements);

	public void cacheResult(
		java.util.List<larion.progate.cds.model.CdsTitleMinimumRequirements> cdsTitleMinimumRequirementses);

	public void clearCache();

	public larion.progate.cds.model.CdsTitleMinimumRequirements create(
		java.lang.Integer CdsTitleMinimumRequirementsId);

	public larion.progate.cds.model.CdsTitleMinimumRequirements remove(
		java.lang.Integer CdsTitleMinimumRequirementsId)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsTitleMinimumRequirementsException;

	public larion.progate.cds.model.CdsTitleMinimumRequirements remove(
		larion.progate.cds.model.CdsTitleMinimumRequirements cdsTitleMinimumRequirements)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.CdsTitleMinimumRequirements update(
		larion.progate.cds.model.CdsTitleMinimumRequirements cdsTitleMinimumRequirements)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.CdsTitleMinimumRequirements update(
		larion.progate.cds.model.CdsTitleMinimumRequirements cdsTitleMinimumRequirements,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.CdsTitleMinimumRequirements updateImpl(
		larion.progate.cds.model.CdsTitleMinimumRequirements cdsTitleMinimumRequirements,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.CdsTitleMinimumRequirements findByPrimaryKey(
		java.lang.Integer CdsTitleMinimumRequirementsId)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsTitleMinimumRequirementsException;

	public larion.progate.cds.model.CdsTitleMinimumRequirements fetchByPrimaryKey(
		java.lang.Integer CdsTitleMinimumRequirementsId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsTitleMinimumRequirements> findByTitleId(
		int titleId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsTitleMinimumRequirements> findByTitleId(
		int titleId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsTitleMinimumRequirements> findByTitleId(
		int titleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.CdsTitleMinimumRequirements findByTitleId_First(
		int titleId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsTitleMinimumRequirementsException;

	public larion.progate.cds.model.CdsTitleMinimumRequirements findByTitleId_Last(
		int titleId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsTitleMinimumRequirementsException;

	public larion.progate.cds.model.CdsTitleMinimumRequirements[] findByTitleId_PrevAndNext(
		java.lang.Integer CdsTitleMinimumRequirementsId, int titleId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsTitleMinimumRequirementsException;

	public java.util.List<larion.progate.cds.model.CdsTitleMinimumRequirements> findByMinimumRequirementId(
		int minimumRequirementId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsTitleMinimumRequirements> findByMinimumRequirementId(
		int minimumRequirementId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsTitleMinimumRequirements> findByMinimumRequirementId(
		int minimumRequirementId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.CdsTitleMinimumRequirements findByMinimumRequirementId_First(
		int minimumRequirementId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsTitleMinimumRequirementsException;

	public larion.progate.cds.model.CdsTitleMinimumRequirements findByMinimumRequirementId_Last(
		int minimumRequirementId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsTitleMinimumRequirementsException;

	public larion.progate.cds.model.CdsTitleMinimumRequirements[] findByMinimumRequirementId_PrevAndNext(
		java.lang.Integer CdsTitleMinimumRequirementsId,
		int minimumRequirementId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsTitleMinimumRequirementsException;

	public java.util.List<larion.progate.cds.model.CdsTitleMinimumRequirements> findByMinimumRequirementLevelId(
		int minimumRequirementLevelId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsTitleMinimumRequirements> findByMinimumRequirementLevelId(
		int minimumRequirementLevelId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsTitleMinimumRequirements> findByMinimumRequirementLevelId(
		int minimumRequirementLevelId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.CdsTitleMinimumRequirements findByMinimumRequirementLevelId_First(
		int minimumRequirementLevelId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsTitleMinimumRequirementsException;

	public larion.progate.cds.model.CdsTitleMinimumRequirements findByMinimumRequirementLevelId_Last(
		int minimumRequirementLevelId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsTitleMinimumRequirementsException;

	public larion.progate.cds.model.CdsTitleMinimumRequirements[] findByMinimumRequirementLevelId_PrevAndNext(
		java.lang.Integer CdsTitleMinimumRequirementsId,
		int minimumRequirementLevelId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsTitleMinimumRequirementsException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsTitleMinimumRequirements> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsTitleMinimumRequirements> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsTitleMinimumRequirements> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByTitleId(int titleId)
		throws com.liferay.portal.SystemException;

	public void removeByMinimumRequirementId(int minimumRequirementId)
		throws com.liferay.portal.SystemException;

	public void removeByMinimumRequirementLevelId(int minimumRequirementLevelId)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByTitleId(int titleId)
		throws com.liferay.portal.SystemException;

	public int countByMinimumRequirementId(int minimumRequirementId)
		throws com.liferay.portal.SystemException;

	public int countByMinimumRequirementLevelId(int minimumRequirementLevelId)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;
}