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
 * <a href="CdsTitleCompetenciesPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface CdsTitleCompetenciesPersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.cds.model.CdsTitleCompetencies cdsTitleCompetencies);

	public void cacheResult(
		java.util.List<larion.progate.cds.model.CdsTitleCompetencies> cdsTitleCompetencieses);

	public void clearCache();

	public larion.progate.cds.model.CdsTitleCompetencies create(
		java.lang.Integer CdsTitleCompetenciesId);

	public larion.progate.cds.model.CdsTitleCompetencies remove(
		java.lang.Integer CdsTitleCompetenciesId)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsTitleCompetenciesException;

	public larion.progate.cds.model.CdsTitleCompetencies remove(
		larion.progate.cds.model.CdsTitleCompetencies cdsTitleCompetencies)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.CdsTitleCompetencies update(
		larion.progate.cds.model.CdsTitleCompetencies cdsTitleCompetencies)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.CdsTitleCompetencies update(
		larion.progate.cds.model.CdsTitleCompetencies cdsTitleCompetencies,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.CdsTitleCompetencies updateImpl(
		larion.progate.cds.model.CdsTitleCompetencies cdsTitleCompetencies,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.CdsTitleCompetencies findByPrimaryKey(
		java.lang.Integer CdsTitleCompetenciesId)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsTitleCompetenciesException;

	public larion.progate.cds.model.CdsTitleCompetencies fetchByPrimaryKey(
		java.lang.Integer CdsTitleCompetenciesId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsTitleCompetencies> findByCdsTitleId(
		int cdsTitleId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsTitleCompetencies> findByCdsTitleId(
		int cdsTitleId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsTitleCompetencies> findByCdsTitleId(
		int cdsTitleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.CdsTitleCompetencies findByCdsTitleId_First(
		int cdsTitleId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsTitleCompetenciesException;

	public larion.progate.cds.model.CdsTitleCompetencies findByCdsTitleId_Last(
		int cdsTitleId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsTitleCompetenciesException;

	public larion.progate.cds.model.CdsTitleCompetencies[] findByCdsTitleId_PrevAndNext(
		java.lang.Integer CdsTitleCompetenciesId, int cdsTitleId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsTitleCompetenciesException;

	public java.util.List<larion.progate.cds.model.CdsTitleCompetencies> findByCompetencyId(
		int competencyId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsTitleCompetencies> findByCompetencyId(
		int competencyId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsTitleCompetencies> findByCompetencyId(
		int competencyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.CdsTitleCompetencies findByCompetencyId_First(
		int competencyId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsTitleCompetenciesException;

	public larion.progate.cds.model.CdsTitleCompetencies findByCompetencyId_Last(
		int competencyId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsTitleCompetenciesException;

	public larion.progate.cds.model.CdsTitleCompetencies[] findByCompetencyId_PrevAndNext(
		java.lang.Integer CdsTitleCompetenciesId, int competencyId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsTitleCompetenciesException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsTitleCompetencies> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsTitleCompetencies> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsTitleCompetencies> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByCdsTitleId(int cdsTitleId)
		throws com.liferay.portal.SystemException;

	public void removeByCompetencyId(int competencyId)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByCdsTitleId(int cdsTitleId)
		throws com.liferay.portal.SystemException;

	public int countByCompetencyId(int competencyId)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;
}