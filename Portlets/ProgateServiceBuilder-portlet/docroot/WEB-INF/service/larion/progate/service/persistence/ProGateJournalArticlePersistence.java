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
 * <a href="ProGateJournalArticlePersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface ProGateJournalArticlePersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.model.ProGateJournalArticle proGateJournalArticle);

	public void cacheResult(
		java.util.List<larion.progate.model.ProGateJournalArticle> proGateJournalArticles);

	public void clearCache();

	public larion.progate.model.ProGateJournalArticle create(
		java.lang.Integer journalArticleId);

	public larion.progate.model.ProGateJournalArticle remove(
		java.lang.Integer journalArticleId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public larion.progate.model.ProGateJournalArticle remove(
		larion.progate.model.ProGateJournalArticle proGateJournalArticle)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticle update(
		larion.progate.model.ProGateJournalArticle proGateJournalArticle)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticle update(
		larion.progate.model.ProGateJournalArticle proGateJournalArticle,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticle updateImpl(
		larion.progate.model.ProGateJournalArticle proGateJournalArticle,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticle findByPrimaryKey(
		java.lang.Integer journalArticleId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public larion.progate.model.ProGateJournalArticle fetchByPrimaryKey(
		java.lang.Integer journalArticleId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findByorgId(
		java.lang.String orgId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findByorgId(
		java.lang.String orgId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findByorgId(
		java.lang.String orgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticle findByorgId_First(
		java.lang.String orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public larion.progate.model.ProGateJournalArticle findByorgId_Last(
		java.lang.String orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public larion.progate.model.ProGateJournalArticle[] findByorgId_PrevAndNext(
		java.lang.Integer journalArticleId, java.lang.String orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findByarticleOrderEquals(
		int articleOrder) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findByarticleOrderEquals(
		int articleOrder, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findByarticleOrderEquals(
		int articleOrder, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticle findByarticleOrderEquals_First(
		int articleOrder, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public larion.progate.model.ProGateJournalArticle findByarticleOrderEquals_Last(
		int articleOrder, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public larion.progate.model.ProGateJournalArticle[] findByarticleOrderEquals_PrevAndNext(
		java.lang.Integer journalArticleId, int articleOrder,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findByarticleOrderGreater(
		int articleOrder) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findByarticleOrderGreater(
		int articleOrder, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findByarticleOrderGreater(
		int articleOrder, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticle findByarticleOrderGreater_First(
		int articleOrder, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public larion.progate.model.ProGateJournalArticle findByarticleOrderGreater_Last(
		int articleOrder, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public larion.progate.model.ProGateJournalArticle[] findByarticleOrderGreater_PrevAndNext(
		java.lang.Integer journalArticleId, int articleOrder,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findByarticleOrderLower(
		int articleOrder) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findByarticleOrderLower(
		int articleOrder, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findByarticleOrderLower(
		int articleOrder, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticle findByarticleOrderLower_First(
		int articleOrder, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public larion.progate.model.ProGateJournalArticle findByarticleOrderLower_Last(
		int articleOrder, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public larion.progate.model.ProGateJournalArticle[] findByarticleOrderLower_PrevAndNext(
		java.lang.Integer journalArticleId, int articleOrder,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findByarticleTypeEquals(
		int articleType) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findByarticleTypeEquals(
		int articleType, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findByarticleTypeEquals(
		int articleType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticle findByarticleTypeEquals_First(
		int articleType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public larion.progate.model.ProGateJournalArticle findByarticleTypeEquals_Last(
		int articleType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public larion.progate.model.ProGateJournalArticle[] findByarticleTypeEquals_PrevAndNext(
		java.lang.Integer journalArticleId, int articleType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findByarticleTypeGreater(
		int articleType) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findByarticleTypeGreater(
		int articleType, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findByarticleTypeGreater(
		int articleType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticle findByarticleTypeGreater_First(
		int articleType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public larion.progate.model.ProGateJournalArticle findByarticleTypeGreater_Last(
		int articleType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public larion.progate.model.ProGateJournalArticle[] findByarticleTypeGreater_PrevAndNext(
		java.lang.Integer journalArticleId, int articleType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findByarticleTypeLower(
		int articleType) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findByarticleTypeLower(
		int articleType, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findByarticleTypeLower(
		int articleType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticle findByarticleTypeLower_First(
		int articleType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public larion.progate.model.ProGateJournalArticle findByarticleTypeLower_Last(
		int articleType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public larion.progate.model.ProGateJournalArticle[] findByarticleTypeLower_PrevAndNext(
		java.lang.Integer journalArticleId, int articleType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findBytitle(
		java.lang.String title) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findBytitle(
		java.lang.String title, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findBytitle(
		java.lang.String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticle findBytitle_First(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public larion.progate.model.ProGateJournalArticle findBytitle_Last(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public larion.progate.model.ProGateJournalArticle[] findBytitle_PrevAndNext(
		java.lang.Integer journalArticleId, java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findBypriorityEqual(
		int priority) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findBypriorityEqual(
		int priority, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findBypriorityEqual(
		int priority, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticle findBypriorityEqual_First(
		int priority, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public larion.progate.model.ProGateJournalArticle findBypriorityEqual_Last(
		int priority, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public larion.progate.model.ProGateJournalArticle[] findBypriorityEqual_PrevAndNext(
		java.lang.Integer journalArticleId, int priority,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findBypriorityLower(
		int priority) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findBypriorityLower(
		int priority, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findBypriorityLower(
		int priority, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticle findBypriorityLower_First(
		int priority, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public larion.progate.model.ProGateJournalArticle findBypriorityLower_Last(
		int priority, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public larion.progate.model.ProGateJournalArticle[] findBypriorityLower_PrevAndNext(
		java.lang.Integer journalArticleId, int priority,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findBypriorityGreater(
		int priority) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findBypriorityGreater(
		int priority, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findBypriorityGreater(
		int priority, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticle findBypriorityGreater_First(
		int priority, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public larion.progate.model.ProGateJournalArticle findBypriorityGreater_Last(
		int priority, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public larion.progate.model.ProGateJournalArticle[] findBypriorityGreater_PrevAndNext(
		java.lang.Integer journalArticleId, int priority,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findBycreatedBy(
		int createdBy) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findBycreatedBy(
		int createdBy, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findBycreatedBy(
		int createdBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticle findBycreatedBy_First(
		int createdBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public larion.progate.model.ProGateJournalArticle findBycreatedBy_Last(
		int createdBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public larion.progate.model.ProGateJournalArticle[] findBycreatedBy_PrevAndNext(
		java.lang.Integer journalArticleId, int createdBy,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findBycreatedAtEqual(
		java.util.Date createdAt) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findBycreatedAtEqual(
		java.util.Date createdAt, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findBycreatedAtEqual(
		java.util.Date createdAt, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticle findBycreatedAtEqual_First(
		java.util.Date createdAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public larion.progate.model.ProGateJournalArticle findBycreatedAtEqual_Last(
		java.util.Date createdAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public larion.progate.model.ProGateJournalArticle[] findBycreatedAtEqual_PrevAndNext(
		java.lang.Integer journalArticleId, java.util.Date createdAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findBycreatedAtGreater(
		java.util.Date createdAt) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findBycreatedAtGreater(
		java.util.Date createdAt, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findBycreatedAtGreater(
		java.util.Date createdAt, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticle findBycreatedAtGreater_First(
		java.util.Date createdAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public larion.progate.model.ProGateJournalArticle findBycreatedAtGreater_Last(
		java.util.Date createdAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public larion.progate.model.ProGateJournalArticle[] findBycreatedAtGreater_PrevAndNext(
		java.lang.Integer journalArticleId, java.util.Date createdAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findBycreatedAtLower(
		java.util.Date createdAt) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findBycreatedAtLower(
		java.util.Date createdAt, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findBycreatedAtLower(
		java.util.Date createdAt, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticle findBycreatedAtLower_First(
		java.util.Date createdAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public larion.progate.model.ProGateJournalArticle findBycreatedAtLower_Last(
		java.util.Date createdAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public larion.progate.model.ProGateJournalArticle[] findBycreatedAtLower_PrevAndNext(
		java.lang.Integer journalArticleId, java.util.Date createdAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findByupdatedBy(
		int updatedBy) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findByupdatedBy(
		int updatedBy, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findByupdatedBy(
		int updatedBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticle findByupdatedBy_First(
		int updatedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public larion.progate.model.ProGateJournalArticle findByupdatedBy_Last(
		int updatedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public larion.progate.model.ProGateJournalArticle[] findByupdatedBy_PrevAndNext(
		java.lang.Integer journalArticleId, int updatedBy,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findByupdatedAtGreater(
		java.util.Date updatedAt) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findByupdatedAtGreater(
		java.util.Date updatedAt, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findByupdatedAtGreater(
		java.util.Date updatedAt, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticle findByupdatedAtGreater_First(
		java.util.Date updatedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public larion.progate.model.ProGateJournalArticle findByupdatedAtGreater_Last(
		java.util.Date updatedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public larion.progate.model.ProGateJournalArticle[] findByupdatedAtGreater_PrevAndNext(
		java.lang.Integer journalArticleId, java.util.Date updatedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findByupdatedAtLower(
		java.util.Date updatedAt) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findByupdatedAtLower(
		java.util.Date updatedAt, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findByupdatedAtLower(
		java.util.Date updatedAt, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticle findByupdatedAtLower_First(
		java.util.Date updatedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public larion.progate.model.ProGateJournalArticle findByupdatedAtLower_Last(
		java.util.Date updatedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public larion.progate.model.ProGateJournalArticle[] findByupdatedAtLower_PrevAndNext(
		java.lang.Integer journalArticleId, java.util.Date updatedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findByupdatedAtEqual(
		java.util.Date updatedAt) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findByupdatedAtEqual(
		java.util.Date updatedAt, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findByupdatedAtEqual(
		java.util.Date updatedAt, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticle findByupdatedAtEqual_First(
		java.util.Date updatedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public larion.progate.model.ProGateJournalArticle findByupdatedAtEqual_Last(
		java.util.Date updatedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public larion.progate.model.ProGateJournalArticle[] findByupdatedAtEqual_PrevAndNext(
		java.lang.Integer journalArticleId, java.util.Date updatedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findByaddInfo(
		java.lang.String addInfo) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findByaddInfo(
		java.lang.String addInfo, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findByaddInfo(
		java.lang.String addInfo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticle findByaddInfo_First(
		java.lang.String addInfo,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public larion.progate.model.ProGateJournalArticle findByaddInfo_Last(
		java.lang.String addInfo,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public larion.progate.model.ProGateJournalArticle[] findByaddInfo_PrevAndNext(
		java.lang.Integer journalArticleId, java.lang.String addInfo,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticle> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByorgId(java.lang.String orgId)
		throws com.liferay.portal.SystemException;

	public void removeByarticleOrderEquals(int articleOrder)
		throws com.liferay.portal.SystemException;

	public void removeByarticleOrderGreater(int articleOrder)
		throws com.liferay.portal.SystemException;

	public void removeByarticleOrderLower(int articleOrder)
		throws com.liferay.portal.SystemException;

	public void removeByarticleTypeEquals(int articleType)
		throws com.liferay.portal.SystemException;

	public void removeByarticleTypeGreater(int articleType)
		throws com.liferay.portal.SystemException;

	public void removeByarticleTypeLower(int articleType)
		throws com.liferay.portal.SystemException;

	public void removeBytitle(java.lang.String title)
		throws com.liferay.portal.SystemException;

	public void removeBypriorityEqual(int priority)
		throws com.liferay.portal.SystemException;

	public void removeBypriorityLower(int priority)
		throws com.liferay.portal.SystemException;

	public void removeBypriorityGreater(int priority)
		throws com.liferay.portal.SystemException;

	public void removeBycreatedBy(int createdBy)
		throws com.liferay.portal.SystemException;

	public void removeBycreatedAtEqual(java.util.Date createdAt)
		throws com.liferay.portal.SystemException;

	public void removeBycreatedAtGreater(java.util.Date createdAt)
		throws com.liferay.portal.SystemException;

	public void removeBycreatedAtLower(java.util.Date createdAt)
		throws com.liferay.portal.SystemException;

	public void removeByupdatedBy(int updatedBy)
		throws com.liferay.portal.SystemException;

	public void removeByupdatedAtGreater(java.util.Date updatedAt)
		throws com.liferay.portal.SystemException;

	public void removeByupdatedAtLower(java.util.Date updatedAt)
		throws com.liferay.portal.SystemException;

	public void removeByupdatedAtEqual(java.util.Date updatedAt)
		throws com.liferay.portal.SystemException;

	public void removeByaddInfo(java.lang.String addInfo)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByorgId(java.lang.String orgId)
		throws com.liferay.portal.SystemException;

	public int countByarticleOrderEquals(int articleOrder)
		throws com.liferay.portal.SystemException;

	public int countByarticleOrderGreater(int articleOrder)
		throws com.liferay.portal.SystemException;

	public int countByarticleOrderLower(int articleOrder)
		throws com.liferay.portal.SystemException;

	public int countByarticleTypeEquals(int articleType)
		throws com.liferay.portal.SystemException;

	public int countByarticleTypeGreater(int articleType)
		throws com.liferay.portal.SystemException;

	public int countByarticleTypeLower(int articleType)
		throws com.liferay.portal.SystemException;

	public int countBytitle(java.lang.String title)
		throws com.liferay.portal.SystemException;

	public int countBypriorityEqual(int priority)
		throws com.liferay.portal.SystemException;

	public int countBypriorityLower(int priority)
		throws com.liferay.portal.SystemException;

	public int countBypriorityGreater(int priority)
		throws com.liferay.portal.SystemException;

	public int countBycreatedBy(int createdBy)
		throws com.liferay.portal.SystemException;

	public int countBycreatedAtEqual(java.util.Date createdAt)
		throws com.liferay.portal.SystemException;

	public int countBycreatedAtGreater(java.util.Date createdAt)
		throws com.liferay.portal.SystemException;

	public int countBycreatedAtLower(java.util.Date createdAt)
		throws com.liferay.portal.SystemException;

	public int countByupdatedBy(int updatedBy)
		throws com.liferay.portal.SystemException;

	public int countByupdatedAtGreater(java.util.Date updatedAt)
		throws com.liferay.portal.SystemException;

	public int countByupdatedAtLower(java.util.Date updatedAt)
		throws com.liferay.portal.SystemException;

	public int countByupdatedAtEqual(java.util.Date updatedAt)
		throws com.liferay.portal.SystemException;

	public int countByaddInfo(java.lang.String addInfo)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateProductsServices> getProGateProductsServiceses(
		java.lang.Integer pk) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateProductsServices> getProGateProductsServiceses(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateProductsServices> getProGateProductsServiceses(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public int getProGateProductsServicesesSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;

	public boolean containsProGateProductsServices(java.lang.Integer pk,
		java.lang.Integer proGateProductsServicesPK)
		throws com.liferay.portal.SystemException;

	public boolean containsProGateProductsServiceses(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> getProGateJournalArticleSlideShows(
		java.lang.Integer pk) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> getProGateJournalArticleSlideShows(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> getProGateJournalArticleSlideShows(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public int getProGateJournalArticleSlideShowsSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;

	public boolean containsProGateJournalArticleSlideShow(
		java.lang.Integer pk, java.lang.Integer proGateJournalArticleSlideShowPK)
		throws com.liferay.portal.SystemException;

	public boolean containsProGateJournalArticleSlideShows(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;
}