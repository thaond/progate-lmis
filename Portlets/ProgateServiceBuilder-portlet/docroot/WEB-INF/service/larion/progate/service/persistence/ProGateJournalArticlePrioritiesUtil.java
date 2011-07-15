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

package larion.progate.service.persistence;

/**
 * <a href="ProGateJournalArticlePrioritiesUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateJournalArticlePrioritiesUtil {
	public static void cacheResult(
		larion.progate.model.ProGateJournalArticlePriorities proGateJournalArticlePriorities) {
		getPersistence().cacheResult(proGateJournalArticlePriorities);
	}

	public static void cacheResult(
		java.util.List<larion.progate.model.ProGateJournalArticlePriorities> proGateJournalArticlePrioritieses) {
		getPersistence().cacheResult(proGateJournalArticlePrioritieses);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.model.ProGateJournalArticlePriorities create(
		java.lang.Integer journalArticlePrioritiesId) {
		return getPersistence().create(journalArticlePrioritiesId);
	}

	public static larion.progate.model.ProGateJournalArticlePriorities remove(
		java.lang.Integer journalArticlePrioritiesId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticlePrioritiesException {
		return getPersistence().remove(journalArticlePrioritiesId);
	}

	public static larion.progate.model.ProGateJournalArticlePriorities remove(
		larion.progate.model.ProGateJournalArticlePriorities proGateJournalArticlePriorities)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(proGateJournalArticlePriorities);
	}

	public static larion.progate.model.ProGateJournalArticlePriorities update(
		larion.progate.model.ProGateJournalArticlePriorities proGateJournalArticlePriorities)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(proGateJournalArticlePriorities);
	}

	public static larion.progate.model.ProGateJournalArticlePriorities update(
		larion.progate.model.ProGateJournalArticlePriorities proGateJournalArticlePriorities,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(proGateJournalArticlePriorities, merge);
	}

	public static larion.progate.model.ProGateJournalArticlePriorities updateImpl(
		larion.progate.model.ProGateJournalArticlePriorities proGateJournalArticlePriorities,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence()
				   .updateImpl(proGateJournalArticlePriorities, merge);
	}

	public static larion.progate.model.ProGateJournalArticlePriorities findByPrimaryKey(
		java.lang.Integer journalArticlePrioritiesId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticlePrioritiesException {
		return getPersistence().findByPrimaryKey(journalArticlePrioritiesId);
	}

	public static larion.progate.model.ProGateJournalArticlePriorities fetchByPrimaryKey(
		java.lang.Integer journalArticlePrioritiesId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(journalArticlePrioritiesId);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticlePriorities> findByname(
		java.lang.String name) throws com.liferay.portal.SystemException {
		return getPersistence().findByname(name);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticlePriorities> findByname(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByname(name, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticlePriorities> findByname(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByname(name, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticlePriorities findByname_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticlePrioritiesException {
		return getPersistence().findByname_First(name, obc);
	}

	public static larion.progate.model.ProGateJournalArticlePriorities findByname_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticlePrioritiesException {
		return getPersistence().findByname_Last(name, obc);
	}

	public static larion.progate.model.ProGateJournalArticlePriorities[] findByname_PrevAndNext(
		java.lang.Integer journalArticlePrioritiesId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticlePrioritiesException {
		return getPersistence()
				   .findByname_PrevAndNext(journalArticlePrioritiesId, name, obc);
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

	public static java.util.List<larion.progate.model.ProGateJournalArticlePriorities> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticlePriorities> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticlePriorities> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByname(java.lang.String name)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByname(name);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByname(java.lang.String name)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByname(name);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> getProGateJournalArticles(
		java.lang.Integer pk) throws com.liferay.portal.SystemException {
		return getPersistence().getProGateJournalArticles(pk);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> getProGateJournalArticles(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().getProGateJournalArticles(pk, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> getProGateJournalArticles(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().getProGateJournalArticles(pk, start, end, obc);
	}

	public static int getProGateJournalArticlesSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException {
		return getPersistence().getProGateJournalArticlesSize(pk);
	}

	public static boolean containsProGateJournalArticle(java.lang.Integer pk,
		java.lang.Integer proGateJournalArticlePK)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .containsProGateJournalArticle(pk, proGateJournalArticlePK);
	}

	public static boolean containsProGateJournalArticles(java.lang.Integer pk)
		throws com.liferay.portal.SystemException {
		return getPersistence().containsProGateJournalArticles(pk);
	}

	public static ProGateJournalArticlePrioritiesPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(
		ProGateJournalArticlePrioritiesPersistence persistence) {
		_persistence = persistence;
	}

	private static ProGateJournalArticlePrioritiesPersistence _persistence;
}