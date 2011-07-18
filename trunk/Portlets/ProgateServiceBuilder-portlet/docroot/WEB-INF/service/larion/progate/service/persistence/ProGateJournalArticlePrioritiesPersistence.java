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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * <a href="ProGateJournalArticlePrioritiesPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface ProGateJournalArticlePrioritiesPersistence
	extends BasePersistence {
	public void cacheResult(
		larion.progate.model.ProGateJournalArticlePriorities proGateJournalArticlePriorities);

	public void cacheResult(
		java.util.List<larion.progate.model.ProGateJournalArticlePriorities> proGateJournalArticlePrioritieses);

	public void clearCache();

	public larion.progate.model.ProGateJournalArticlePriorities create(
		java.lang.Integer journalArticlePrioritiesId);

	public larion.progate.model.ProGateJournalArticlePriorities remove(
		java.lang.Integer journalArticlePrioritiesId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticlePrioritiesException;

	public larion.progate.model.ProGateJournalArticlePriorities remove(
		larion.progate.model.ProGateJournalArticlePriorities proGateJournalArticlePriorities)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticlePriorities update(
		larion.progate.model.ProGateJournalArticlePriorities proGateJournalArticlePriorities)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticlePriorities update(
		larion.progate.model.ProGateJournalArticlePriorities proGateJournalArticlePriorities,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticlePriorities updateImpl(
		larion.progate.model.ProGateJournalArticlePriorities proGateJournalArticlePriorities,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticlePriorities findByPrimaryKey(
		java.lang.Integer journalArticlePrioritiesId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticlePrioritiesException;

	public larion.progate.model.ProGateJournalArticlePriorities fetchByPrimaryKey(
		java.lang.Integer journalArticlePrioritiesId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticlePriorities> findByname(
		java.lang.String name) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticlePriorities> findByname(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticlePriorities> findByname(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticlePriorities findByname_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticlePrioritiesException;

	public larion.progate.model.ProGateJournalArticlePriorities findByname_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticlePrioritiesException;

	public larion.progate.model.ProGateJournalArticlePriorities[] findByname_PrevAndNext(
		java.lang.Integer journalArticlePrioritiesId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticlePrioritiesException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticlePriorities> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticlePriorities> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticlePriorities> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByname(java.lang.String name)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByname(java.lang.String name)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> getProGateJournalArticles(
		java.lang.Integer pk) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> getProGateJournalArticles(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> getProGateJournalArticles(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public int getProGateJournalArticlesSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;

	public boolean containsProGateJournalArticle(java.lang.Integer pk,
		java.lang.Integer proGateJournalArticlePK)
		throws com.liferay.portal.SystemException;

	public boolean containsProGateJournalArticles(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;
}