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
 * <a href="CompetencyUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CompetencyUtil {
	public static void cacheResult(
		larion.progate.cds.model.Competency competency) {
		getPersistence().cacheResult(competency);
	}

	public static void cacheResult(
		java.util.List<larion.progate.cds.model.Competency> competencies) {
		getPersistence().cacheResult(competencies);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.cds.model.Competency create(
		java.lang.Integer competencyId) {
		return getPersistence().create(competencyId);
	}

	public static larion.progate.cds.model.Competency remove(
		java.lang.Integer competencyId)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCompetencyException {
		return getPersistence().remove(competencyId);
	}

	public static larion.progate.cds.model.Competency remove(
		larion.progate.cds.model.Competency competency)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(competency);
	}

	public static larion.progate.cds.model.Competency update(
		larion.progate.cds.model.Competency competency)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(competency);
	}

	public static larion.progate.cds.model.Competency update(
		larion.progate.cds.model.Competency competency, boolean merge)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(competency, merge);
	}

	public static larion.progate.cds.model.Competency updateImpl(
		larion.progate.cds.model.Competency competency, boolean merge)
		throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(competency, merge);
	}

	public static larion.progate.cds.model.Competency findByPrimaryKey(
		java.lang.Integer competencyId)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCompetencyException {
		return getPersistence().findByPrimaryKey(competencyId);
	}

	public static larion.progate.cds.model.Competency fetchByPrimaryKey(
		java.lang.Integer competencyId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(competencyId);
	}

	public static java.util.List<larion.progate.cds.model.Competency> findByname(
		java.lang.String name) throws com.liferay.portal.SystemException {
		return getPersistence().findByname(name);
	}

	public static java.util.List<larion.progate.cds.model.Competency> findByname(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByname(name, start, end);
	}

	public static java.util.List<larion.progate.cds.model.Competency> findByname(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByname(name, start, end, obc);
	}

	public static larion.progate.cds.model.Competency findByname_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCompetencyException {
		return getPersistence().findByname_First(name, obc);
	}

	public static larion.progate.cds.model.Competency findByname_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCompetencyException {
		return getPersistence().findByname_Last(name, obc);
	}

	public static larion.progate.cds.model.Competency[] findByname_PrevAndNext(
		java.lang.Integer competencyId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCompetencyException {
		return getPersistence().findByname_PrevAndNext(competencyId, name, obc);
	}

	public static java.util.List<larion.progate.cds.model.Competency> findByrootId(
		int rootId) throws com.liferay.portal.SystemException {
		return getPersistence().findByrootId(rootId);
	}

	public static java.util.List<larion.progate.cds.model.Competency> findByrootId(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByrootId(rootId, start, end);
	}

	public static java.util.List<larion.progate.cds.model.Competency> findByrootId(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByrootId(rootId, start, end, obc);
	}

	public static larion.progate.cds.model.Competency findByrootId_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCompetencyException {
		return getPersistence().findByrootId_First(rootId, obc);
	}

	public static larion.progate.cds.model.Competency findByrootId_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCompetencyException {
		return getPersistence().findByrootId_Last(rootId, obc);
	}

	public static larion.progate.cds.model.Competency[] findByrootId_PrevAndNext(
		java.lang.Integer competencyId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCompetencyException {
		return getPersistence()
				   .findByrootId_PrevAndNext(competencyId, rootId, obc);
	}

	public static java.util.List<larion.progate.cds.model.Competency> findBynumberOrderGreater(
		int numberOrder) throws com.liferay.portal.SystemException {
		return getPersistence().findBynumberOrderGreater(numberOrder);
	}

	public static java.util.List<larion.progate.cds.model.Competency> findBynumberOrderGreater(
		int numberOrder, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBynumberOrderGreater(numberOrder, start, end);
	}

	public static java.util.List<larion.progate.cds.model.Competency> findBynumberOrderGreater(
		int numberOrder, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findBynumberOrderGreater(numberOrder, start, end, obc);
	}

	public static larion.progate.cds.model.Competency findBynumberOrderGreater_First(
		int numberOrder, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCompetencyException {
		return getPersistence().findBynumberOrderGreater_First(numberOrder, obc);
	}

	public static larion.progate.cds.model.Competency findBynumberOrderGreater_Last(
		int numberOrder, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCompetencyException {
		return getPersistence().findBynumberOrderGreater_Last(numberOrder, obc);
	}

	public static larion.progate.cds.model.Competency[] findBynumberOrderGreater_PrevAndNext(
		java.lang.Integer competencyId, int numberOrder,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCompetencyException {
		return getPersistence()
				   .findBynumberOrderGreater_PrevAndNext(competencyId,
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

	public static java.util.List<larion.progate.cds.model.Competency> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.cds.model.Competency> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.cds.model.Competency> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByname(java.lang.String name)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByname(name);
	}

	public static void removeByrootId(int rootId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByrootId(rootId);
	}

	public static void removeBynumberOrderGreater(int numberOrder)
		throws com.liferay.portal.SystemException {
		getPersistence().removeBynumberOrderGreater(numberOrder);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByname(java.lang.String name)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByname(name);
	}

	public static int countByrootId(int rootId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByrootId(rootId);
	}

	public static int countBynumberOrderGreater(int numberOrder)
		throws com.liferay.portal.SystemException {
		return getPersistence().countBynumberOrderGreater(numberOrder);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static java.util.List<larion.progate.cds.model.Level> getLevels(
		java.lang.Integer pk) throws com.liferay.portal.SystemException {
		return getPersistence().getLevels(pk);
	}

	public static java.util.List<larion.progate.cds.model.Level> getLevels(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().getLevels(pk, start, end);
	}

	public static java.util.List<larion.progate.cds.model.Level> getLevels(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().getLevels(pk, start, end, obc);
	}

	public static int getLevelsSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException {
		return getPersistence().getLevelsSize(pk);
	}

	public static boolean containsLevel(java.lang.Integer pk,
		java.lang.Integer levelPK) throws com.liferay.portal.SystemException {
		return getPersistence().containsLevel(pk, levelPK);
	}

	public static boolean containsLevels(java.lang.Integer pk)
		throws com.liferay.portal.SystemException {
		return getPersistence().containsLevels(pk);
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

	public static CompetencyPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(CompetencyPersistence persistence) {
		_persistence = persistence;
	}

	private static CompetencyPersistence _persistence;
}