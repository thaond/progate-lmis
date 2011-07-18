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
 * <a href="CompetencyPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface CompetencyPersistence extends BasePersistence {
	public void cacheResult(larion.progate.cds.model.Competency competency);

	public void cacheResult(
		java.util.List<larion.progate.cds.model.Competency> competencies);

	public void clearCache();

	public larion.progate.cds.model.Competency create(
		java.lang.Integer competencyId);

	public larion.progate.cds.model.Competency remove(
		java.lang.Integer competencyId)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCompetencyException;

	public larion.progate.cds.model.Competency remove(
		larion.progate.cds.model.Competency competency)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.Competency update(
		larion.progate.cds.model.Competency competency)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.Competency update(
		larion.progate.cds.model.Competency competency, boolean merge)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.Competency updateImpl(
		larion.progate.cds.model.Competency competency, boolean merge)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.Competency findByPrimaryKey(
		java.lang.Integer competencyId)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCompetencyException;

	public larion.progate.cds.model.Competency fetchByPrimaryKey(
		java.lang.Integer competencyId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.Competency> findByname(
		java.lang.String name) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.Competency> findByname(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.Competency> findByname(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.Competency findByname_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCompetencyException;

	public larion.progate.cds.model.Competency findByname_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCompetencyException;

	public larion.progate.cds.model.Competency[] findByname_PrevAndNext(
		java.lang.Integer competencyId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCompetencyException;

	public java.util.List<larion.progate.cds.model.Competency> findByrootId(
		int rootId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.Competency> findByrootId(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.Competency> findByrootId(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.Competency findByrootId_First(int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCompetencyException;

	public larion.progate.cds.model.Competency findByrootId_Last(int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCompetencyException;

	public larion.progate.cds.model.Competency[] findByrootId_PrevAndNext(
		java.lang.Integer competencyId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCompetencyException;

	public java.util.List<larion.progate.cds.model.Competency> findBynumberOrderGreater(
		int numberOrder) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.Competency> findBynumberOrderGreater(
		int numberOrder, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.Competency> findBynumberOrderGreater(
		int numberOrder, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.Competency findBynumberOrderGreater_First(
		int numberOrder, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCompetencyException;

	public larion.progate.cds.model.Competency findBynumberOrderGreater_Last(
		int numberOrder, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCompetencyException;

	public larion.progate.cds.model.Competency[] findBynumberOrderGreater_PrevAndNext(
		java.lang.Integer competencyId, int numberOrder,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCompetencyException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.Competency> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.Competency> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.Competency> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByname(java.lang.String name)
		throws com.liferay.portal.SystemException;

	public void removeByrootId(int rootId)
		throws com.liferay.portal.SystemException;

	public void removeBynumberOrderGreater(int numberOrder)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByname(java.lang.String name)
		throws com.liferay.portal.SystemException;

	public int countByrootId(int rootId)
		throws com.liferay.portal.SystemException;

	public int countBynumberOrderGreater(int numberOrder)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.Level> getLevels(
		java.lang.Integer pk) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.Level> getLevels(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.Level> getLevels(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public int getLevelsSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;

	public boolean containsLevel(java.lang.Integer pk, java.lang.Integer levelPK)
		throws com.liferay.portal.SystemException;

	public boolean containsLevels(java.lang.Integer pk)
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
}