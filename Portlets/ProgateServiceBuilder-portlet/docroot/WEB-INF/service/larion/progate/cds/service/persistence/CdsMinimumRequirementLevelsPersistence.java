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
 * <a href="CdsMinimumRequirementLevelsPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface CdsMinimumRequirementLevelsPersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.cds.model.CdsMinimumRequirementLevels cdsMinimumRequirementLevels);

	public void cacheResult(
		java.util.List<larion.progate.cds.model.CdsMinimumRequirementLevels> cdsMinimumRequirementLevelses);

	public void clearCache();

	public larion.progate.cds.model.CdsMinimumRequirementLevels create(
		java.lang.Integer minimumRequirementLevelId);

	public larion.progate.cds.model.CdsMinimumRequirementLevels remove(
		java.lang.Integer minimumRequirementLevelId)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsMinimumRequirementLevelsException;

	public larion.progate.cds.model.CdsMinimumRequirementLevels remove(
		larion.progate.cds.model.CdsMinimumRequirementLevels cdsMinimumRequirementLevels)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.CdsMinimumRequirementLevels update(
		larion.progate.cds.model.CdsMinimumRequirementLevels cdsMinimumRequirementLevels)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.CdsMinimumRequirementLevels update(
		larion.progate.cds.model.CdsMinimumRequirementLevels cdsMinimumRequirementLevels,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.CdsMinimumRequirementLevels updateImpl(
		larion.progate.cds.model.CdsMinimumRequirementLevels cdsMinimumRequirementLevels,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.CdsMinimumRequirementLevels findByPrimaryKey(
		java.lang.Integer minimumRequirementLevelId)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsMinimumRequirementLevelsException;

	public larion.progate.cds.model.CdsMinimumRequirementLevels fetchByPrimaryKey(
		java.lang.Integer minimumRequirementLevelId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsMinimumRequirementLevels> findByMinimumRequirementId(
		int minimumRequirementId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsMinimumRequirementLevels> findByMinimumRequirementId(
		int minimumRequirementId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsMinimumRequirementLevels> findByMinimumRequirementId(
		int minimumRequirementId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.CdsMinimumRequirementLevels findByMinimumRequirementId_First(
		int minimumRequirementId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsMinimumRequirementLevelsException;

	public larion.progate.cds.model.CdsMinimumRequirementLevels findByMinimumRequirementId_Last(
		int minimumRequirementId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsMinimumRequirementLevelsException;

	public larion.progate.cds.model.CdsMinimumRequirementLevels[] findByMinimumRequirementId_PrevAndNext(
		java.lang.Integer minimumRequirementLevelId, int minimumRequirementId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsMinimumRequirementLevelsException;

	public java.util.List<larion.progate.cds.model.CdsMinimumRequirementLevels> findByName(
		java.lang.String name) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsMinimumRequirementLevels> findByName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsMinimumRequirementLevels> findByName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.CdsMinimumRequirementLevels findByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsMinimumRequirementLevelsException;

	public larion.progate.cds.model.CdsMinimumRequirementLevels findByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsMinimumRequirementLevelsException;

	public larion.progate.cds.model.CdsMinimumRequirementLevels[] findByName_PrevAndNext(
		java.lang.Integer minimumRequirementLevelId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsMinimumRequirementLevelsException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsMinimumRequirementLevels> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsMinimumRequirementLevels> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsMinimumRequirementLevels> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByMinimumRequirementId(int minimumRequirementId)
		throws com.liferay.portal.SystemException;

	public void removeByName(java.lang.String name)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByMinimumRequirementId(int minimumRequirementId)
		throws com.liferay.portal.SystemException;

	public int countByName(java.lang.String name)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;

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