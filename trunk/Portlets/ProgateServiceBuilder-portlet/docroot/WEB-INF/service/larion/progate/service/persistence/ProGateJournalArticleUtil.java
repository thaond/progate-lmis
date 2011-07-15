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
 * <a href="ProGateJournalArticleUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateJournalArticleUtil {
	public static void cacheResult(
		larion.progate.model.ProGateJournalArticle proGateJournalArticle) {
		getPersistence().cacheResult(proGateJournalArticle);
	}

	public static void cacheResult(
		java.util.List<larion.progate.model.ProGateJournalArticle> proGateJournalArticles) {
		getPersistence().cacheResult(proGateJournalArticles);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.model.ProGateJournalArticle create(
		java.lang.Integer journalArticleId) {
		return getPersistence().create(journalArticleId);
	}

	public static larion.progate.model.ProGateJournalArticle remove(
		java.lang.Integer journalArticleId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence().remove(journalArticleId);
	}

	public static larion.progate.model.ProGateJournalArticle remove(
		larion.progate.model.ProGateJournalArticle proGateJournalArticle)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(proGateJournalArticle);
	}

	public static larion.progate.model.ProGateJournalArticle update(
		larion.progate.model.ProGateJournalArticle proGateJournalArticle)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(proGateJournalArticle);
	}

	public static larion.progate.model.ProGateJournalArticle update(
		larion.progate.model.ProGateJournalArticle proGateJournalArticle,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(proGateJournalArticle, merge);
	}

	public static larion.progate.model.ProGateJournalArticle updateImpl(
		larion.progate.model.ProGateJournalArticle proGateJournalArticle,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(proGateJournalArticle, merge);
	}

	public static larion.progate.model.ProGateJournalArticle findByPrimaryKey(
		java.lang.Integer journalArticleId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence().findByPrimaryKey(journalArticleId);
	}

	public static larion.progate.model.ProGateJournalArticle fetchByPrimaryKey(
		java.lang.Integer journalArticleId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(journalArticleId);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findByorgId(
		java.lang.String orgId) throws com.liferay.portal.SystemException {
		return getPersistence().findByorgId(orgId);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findByorgId(
		java.lang.String orgId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByorgId(orgId, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findByorgId(
		java.lang.String orgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByorgId(orgId, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticle findByorgId_First(
		java.lang.String orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence().findByorgId_First(orgId, obc);
	}

	public static larion.progate.model.ProGateJournalArticle findByorgId_Last(
		java.lang.String orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence().findByorgId_Last(orgId, obc);
	}

	public static larion.progate.model.ProGateJournalArticle[] findByorgId_PrevAndNext(
		java.lang.Integer journalArticleId, java.lang.String orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence()
				   .findByorgId_PrevAndNext(journalArticleId, orgId, obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findByarticleOrderEquals(
		int articleOrder) throws com.liferay.portal.SystemException {
		return getPersistence().findByarticleOrderEquals(articleOrder);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findByarticleOrderEquals(
		int articleOrder, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByarticleOrderEquals(articleOrder, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findByarticleOrderEquals(
		int articleOrder, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByarticleOrderEquals(articleOrder, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticle findByarticleOrderEquals_First(
		int articleOrder, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence().findByarticleOrderEquals_First(articleOrder, obc);
	}

	public static larion.progate.model.ProGateJournalArticle findByarticleOrderEquals_Last(
		int articleOrder, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence().findByarticleOrderEquals_Last(articleOrder, obc);
	}

	public static larion.progate.model.ProGateJournalArticle[] findByarticleOrderEquals_PrevAndNext(
		java.lang.Integer journalArticleId, int articleOrder,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence()
				   .findByarticleOrderEquals_PrevAndNext(journalArticleId,
			articleOrder, obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findByarticleOrderGreater(
		int articleOrder) throws com.liferay.portal.SystemException {
		return getPersistence().findByarticleOrderGreater(articleOrder);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findByarticleOrderGreater(
		int articleOrder, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByarticleOrderGreater(articleOrder, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findByarticleOrderGreater(
		int articleOrder, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByarticleOrderGreater(articleOrder, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticle findByarticleOrderGreater_First(
		int articleOrder, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence()
				   .findByarticleOrderGreater_First(articleOrder, obc);
	}

	public static larion.progate.model.ProGateJournalArticle findByarticleOrderGreater_Last(
		int articleOrder, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence().findByarticleOrderGreater_Last(articleOrder, obc);
	}

	public static larion.progate.model.ProGateJournalArticle[] findByarticleOrderGreater_PrevAndNext(
		java.lang.Integer journalArticleId, int articleOrder,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence()
				   .findByarticleOrderGreater_PrevAndNext(journalArticleId,
			articleOrder, obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findByarticleOrderLower(
		int articleOrder) throws com.liferay.portal.SystemException {
		return getPersistence().findByarticleOrderLower(articleOrder);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findByarticleOrderLower(
		int articleOrder, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByarticleOrderLower(articleOrder, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findByarticleOrderLower(
		int articleOrder, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByarticleOrderLower(articleOrder, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticle findByarticleOrderLower_First(
		int articleOrder, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence().findByarticleOrderLower_First(articleOrder, obc);
	}

	public static larion.progate.model.ProGateJournalArticle findByarticleOrderLower_Last(
		int articleOrder, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence().findByarticleOrderLower_Last(articleOrder, obc);
	}

	public static larion.progate.model.ProGateJournalArticle[] findByarticleOrderLower_PrevAndNext(
		java.lang.Integer journalArticleId, int articleOrder,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence()
				   .findByarticleOrderLower_PrevAndNext(journalArticleId,
			articleOrder, obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findByarticleTypeEquals(
		int articleType) throws com.liferay.portal.SystemException {
		return getPersistence().findByarticleTypeEquals(articleType);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findByarticleTypeEquals(
		int articleType, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByarticleTypeEquals(articleType, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findByarticleTypeEquals(
		int articleType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByarticleTypeEquals(articleType, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticle findByarticleTypeEquals_First(
		int articleType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence().findByarticleTypeEquals_First(articleType, obc);
	}

	public static larion.progate.model.ProGateJournalArticle findByarticleTypeEquals_Last(
		int articleType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence().findByarticleTypeEquals_Last(articleType, obc);
	}

	public static larion.progate.model.ProGateJournalArticle[] findByarticleTypeEquals_PrevAndNext(
		java.lang.Integer journalArticleId, int articleType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence()
				   .findByarticleTypeEquals_PrevAndNext(journalArticleId,
			articleType, obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findByarticleTypeGreater(
		int articleType) throws com.liferay.portal.SystemException {
		return getPersistence().findByarticleTypeGreater(articleType);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findByarticleTypeGreater(
		int articleType, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByarticleTypeGreater(articleType, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findByarticleTypeGreater(
		int articleType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByarticleTypeGreater(articleType, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticle findByarticleTypeGreater_First(
		int articleType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence().findByarticleTypeGreater_First(articleType, obc);
	}

	public static larion.progate.model.ProGateJournalArticle findByarticleTypeGreater_Last(
		int articleType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence().findByarticleTypeGreater_Last(articleType, obc);
	}

	public static larion.progate.model.ProGateJournalArticle[] findByarticleTypeGreater_PrevAndNext(
		java.lang.Integer journalArticleId, int articleType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence()
				   .findByarticleTypeGreater_PrevAndNext(journalArticleId,
			articleType, obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findByarticleTypeLower(
		int articleType) throws com.liferay.portal.SystemException {
		return getPersistence().findByarticleTypeLower(articleType);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findByarticleTypeLower(
		int articleType, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByarticleTypeLower(articleType, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findByarticleTypeLower(
		int articleType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByarticleTypeLower(articleType, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticle findByarticleTypeLower_First(
		int articleType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence().findByarticleTypeLower_First(articleType, obc);
	}

	public static larion.progate.model.ProGateJournalArticle findByarticleTypeLower_Last(
		int articleType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence().findByarticleTypeLower_Last(articleType, obc);
	}

	public static larion.progate.model.ProGateJournalArticle[] findByarticleTypeLower_PrevAndNext(
		java.lang.Integer journalArticleId, int articleType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence()
				   .findByarticleTypeLower_PrevAndNext(journalArticleId,
			articleType, obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findBytitle(
		java.lang.String title) throws com.liferay.portal.SystemException {
		return getPersistence().findBytitle(title);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findBytitle(
		java.lang.String title, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBytitle(title, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findBytitle(
		java.lang.String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBytitle(title, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticle findBytitle_First(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence().findBytitle_First(title, obc);
	}

	public static larion.progate.model.ProGateJournalArticle findBytitle_Last(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence().findBytitle_Last(title, obc);
	}

	public static larion.progate.model.ProGateJournalArticle[] findBytitle_PrevAndNext(
		java.lang.Integer journalArticleId, java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence()
				   .findBytitle_PrevAndNext(journalArticleId, title, obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findBypriorityEqual(
		int priority) throws com.liferay.portal.SystemException {
		return getPersistence().findBypriorityEqual(priority);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findBypriorityEqual(
		int priority, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBypriorityEqual(priority, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findBypriorityEqual(
		int priority, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBypriorityEqual(priority, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticle findBypriorityEqual_First(
		int priority, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence().findBypriorityEqual_First(priority, obc);
	}

	public static larion.progate.model.ProGateJournalArticle findBypriorityEqual_Last(
		int priority, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence().findBypriorityEqual_Last(priority, obc);
	}

	public static larion.progate.model.ProGateJournalArticle[] findBypriorityEqual_PrevAndNext(
		java.lang.Integer journalArticleId, int priority,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence()
				   .findBypriorityEqual_PrevAndNext(journalArticleId, priority,
			obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findBypriorityLower(
		int priority) throws com.liferay.portal.SystemException {
		return getPersistence().findBypriorityLower(priority);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findBypriorityLower(
		int priority, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBypriorityLower(priority, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findBypriorityLower(
		int priority, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBypriorityLower(priority, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticle findBypriorityLower_First(
		int priority, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence().findBypriorityLower_First(priority, obc);
	}

	public static larion.progate.model.ProGateJournalArticle findBypriorityLower_Last(
		int priority, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence().findBypriorityLower_Last(priority, obc);
	}

	public static larion.progate.model.ProGateJournalArticle[] findBypriorityLower_PrevAndNext(
		java.lang.Integer journalArticleId, int priority,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence()
				   .findBypriorityLower_PrevAndNext(journalArticleId, priority,
			obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findBypriorityGreater(
		int priority) throws com.liferay.portal.SystemException {
		return getPersistence().findBypriorityGreater(priority);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findBypriorityGreater(
		int priority, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBypriorityGreater(priority, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findBypriorityGreater(
		int priority, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBypriorityGreater(priority, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticle findBypriorityGreater_First(
		int priority, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence().findBypriorityGreater_First(priority, obc);
	}

	public static larion.progate.model.ProGateJournalArticle findBypriorityGreater_Last(
		int priority, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence().findBypriorityGreater_Last(priority, obc);
	}

	public static larion.progate.model.ProGateJournalArticle[] findBypriorityGreater_PrevAndNext(
		java.lang.Integer journalArticleId, int priority,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence()
				   .findBypriorityGreater_PrevAndNext(journalArticleId,
			priority, obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findBycreatedBy(
		int createdBy) throws com.liferay.portal.SystemException {
		return getPersistence().findBycreatedBy(createdBy);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findBycreatedBy(
		int createdBy, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBycreatedBy(createdBy, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findBycreatedBy(
		int createdBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBycreatedBy(createdBy, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticle findBycreatedBy_First(
		int createdBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence().findBycreatedBy_First(createdBy, obc);
	}

	public static larion.progate.model.ProGateJournalArticle findBycreatedBy_Last(
		int createdBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence().findBycreatedBy_Last(createdBy, obc);
	}

	public static larion.progate.model.ProGateJournalArticle[] findBycreatedBy_PrevAndNext(
		java.lang.Integer journalArticleId, int createdBy,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence()
				   .findBycreatedBy_PrevAndNext(journalArticleId, createdBy, obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findBycreatedAtEqual(
		java.util.Date createdAt) throws com.liferay.portal.SystemException {
		return getPersistence().findBycreatedAtEqual(createdAt);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findBycreatedAtEqual(
		java.util.Date createdAt, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBycreatedAtEqual(createdAt, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findBycreatedAtEqual(
		java.util.Date createdAt, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBycreatedAtEqual(createdAt, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticle findBycreatedAtEqual_First(
		java.util.Date createdAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence().findBycreatedAtEqual_First(createdAt, obc);
	}

	public static larion.progate.model.ProGateJournalArticle findBycreatedAtEqual_Last(
		java.util.Date createdAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence().findBycreatedAtEqual_Last(createdAt, obc);
	}

	public static larion.progate.model.ProGateJournalArticle[] findBycreatedAtEqual_PrevAndNext(
		java.lang.Integer journalArticleId, java.util.Date createdAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence()
				   .findBycreatedAtEqual_PrevAndNext(journalArticleId,
			createdAt, obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findBycreatedAtGreater(
		java.util.Date createdAt) throws com.liferay.portal.SystemException {
		return getPersistence().findBycreatedAtGreater(createdAt);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findBycreatedAtGreater(
		java.util.Date createdAt, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBycreatedAtGreater(createdAt, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findBycreatedAtGreater(
		java.util.Date createdAt, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findBycreatedAtGreater(createdAt, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticle findBycreatedAtGreater_First(
		java.util.Date createdAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence().findBycreatedAtGreater_First(createdAt, obc);
	}

	public static larion.progate.model.ProGateJournalArticle findBycreatedAtGreater_Last(
		java.util.Date createdAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence().findBycreatedAtGreater_Last(createdAt, obc);
	}

	public static larion.progate.model.ProGateJournalArticle[] findBycreatedAtGreater_PrevAndNext(
		java.lang.Integer journalArticleId, java.util.Date createdAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence()
				   .findBycreatedAtGreater_PrevAndNext(journalArticleId,
			createdAt, obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findBycreatedAtLower(
		java.util.Date createdAt) throws com.liferay.portal.SystemException {
		return getPersistence().findBycreatedAtLower(createdAt);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findBycreatedAtLower(
		java.util.Date createdAt, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBycreatedAtLower(createdAt, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findBycreatedAtLower(
		java.util.Date createdAt, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBycreatedAtLower(createdAt, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticle findBycreatedAtLower_First(
		java.util.Date createdAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence().findBycreatedAtLower_First(createdAt, obc);
	}

	public static larion.progate.model.ProGateJournalArticle findBycreatedAtLower_Last(
		java.util.Date createdAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence().findBycreatedAtLower_Last(createdAt, obc);
	}

	public static larion.progate.model.ProGateJournalArticle[] findBycreatedAtLower_PrevAndNext(
		java.lang.Integer journalArticleId, java.util.Date createdAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence()
				   .findBycreatedAtLower_PrevAndNext(journalArticleId,
			createdAt, obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findByupdatedBy(
		int updatedBy) throws com.liferay.portal.SystemException {
		return getPersistence().findByupdatedBy(updatedBy);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findByupdatedBy(
		int updatedBy, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByupdatedBy(updatedBy, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findByupdatedBy(
		int updatedBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByupdatedBy(updatedBy, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticle findByupdatedBy_First(
		int updatedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence().findByupdatedBy_First(updatedBy, obc);
	}

	public static larion.progate.model.ProGateJournalArticle findByupdatedBy_Last(
		int updatedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence().findByupdatedBy_Last(updatedBy, obc);
	}

	public static larion.progate.model.ProGateJournalArticle[] findByupdatedBy_PrevAndNext(
		java.lang.Integer journalArticleId, int updatedBy,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence()
				   .findByupdatedBy_PrevAndNext(journalArticleId, updatedBy, obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findByupdatedAtGreater(
		java.util.Date updatedAt) throws com.liferay.portal.SystemException {
		return getPersistence().findByupdatedAtGreater(updatedAt);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findByupdatedAtGreater(
		java.util.Date updatedAt, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByupdatedAtGreater(updatedAt, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findByupdatedAtGreater(
		java.util.Date updatedAt, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByupdatedAtGreater(updatedAt, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticle findByupdatedAtGreater_First(
		java.util.Date updatedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence().findByupdatedAtGreater_First(updatedAt, obc);
	}

	public static larion.progate.model.ProGateJournalArticle findByupdatedAtGreater_Last(
		java.util.Date updatedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence().findByupdatedAtGreater_Last(updatedAt, obc);
	}

	public static larion.progate.model.ProGateJournalArticle[] findByupdatedAtGreater_PrevAndNext(
		java.lang.Integer journalArticleId, java.util.Date updatedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence()
				   .findByupdatedAtGreater_PrevAndNext(journalArticleId,
			updatedAt, obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findByupdatedAtLower(
		java.util.Date updatedAt) throws com.liferay.portal.SystemException {
		return getPersistence().findByupdatedAtLower(updatedAt);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findByupdatedAtLower(
		java.util.Date updatedAt, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByupdatedAtLower(updatedAt, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findByupdatedAtLower(
		java.util.Date updatedAt, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByupdatedAtLower(updatedAt, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticle findByupdatedAtLower_First(
		java.util.Date updatedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence().findByupdatedAtLower_First(updatedAt, obc);
	}

	public static larion.progate.model.ProGateJournalArticle findByupdatedAtLower_Last(
		java.util.Date updatedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence().findByupdatedAtLower_Last(updatedAt, obc);
	}

	public static larion.progate.model.ProGateJournalArticle[] findByupdatedAtLower_PrevAndNext(
		java.lang.Integer journalArticleId, java.util.Date updatedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence()
				   .findByupdatedAtLower_PrevAndNext(journalArticleId,
			updatedAt, obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findByupdatedAtEqual(
		java.util.Date updatedAt) throws com.liferay.portal.SystemException {
		return getPersistence().findByupdatedAtEqual(updatedAt);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findByupdatedAtEqual(
		java.util.Date updatedAt, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByupdatedAtEqual(updatedAt, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findByupdatedAtEqual(
		java.util.Date updatedAt, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByupdatedAtEqual(updatedAt, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticle findByupdatedAtEqual_First(
		java.util.Date updatedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence().findByupdatedAtEqual_First(updatedAt, obc);
	}

	public static larion.progate.model.ProGateJournalArticle findByupdatedAtEqual_Last(
		java.util.Date updatedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence().findByupdatedAtEqual_Last(updatedAt, obc);
	}

	public static larion.progate.model.ProGateJournalArticle[] findByupdatedAtEqual_PrevAndNext(
		java.lang.Integer journalArticleId, java.util.Date updatedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence()
				   .findByupdatedAtEqual_PrevAndNext(journalArticleId,
			updatedAt, obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findByaddInfo(
		java.lang.String addInfo) throws com.liferay.portal.SystemException {
		return getPersistence().findByaddInfo(addInfo);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findByaddInfo(
		java.lang.String addInfo, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByaddInfo(addInfo, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findByaddInfo(
		java.lang.String addInfo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByaddInfo(addInfo, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticle findByaddInfo_First(
		java.lang.String addInfo,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence().findByaddInfo_First(addInfo, obc);
	}

	public static larion.progate.model.ProGateJournalArticle findByaddInfo_Last(
		java.lang.String addInfo,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence().findByaddInfo_Last(addInfo, obc);
	}

	public static larion.progate.model.ProGateJournalArticle[] findByaddInfo_PrevAndNext(
		java.lang.Integer journalArticleId, java.lang.String addInfo,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleException {
		return getPersistence()
				   .findByaddInfo_PrevAndNext(journalArticleId, addInfo, obc);
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

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticle> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByorgId(java.lang.String orgId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByorgId(orgId);
	}

	public static void removeByarticleOrderEquals(int articleOrder)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByarticleOrderEquals(articleOrder);
	}

	public static void removeByarticleOrderGreater(int articleOrder)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByarticleOrderGreater(articleOrder);
	}

	public static void removeByarticleOrderLower(int articleOrder)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByarticleOrderLower(articleOrder);
	}

	public static void removeByarticleTypeEquals(int articleType)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByarticleTypeEquals(articleType);
	}

	public static void removeByarticleTypeGreater(int articleType)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByarticleTypeGreater(articleType);
	}

	public static void removeByarticleTypeLower(int articleType)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByarticleTypeLower(articleType);
	}

	public static void removeBytitle(java.lang.String title)
		throws com.liferay.portal.SystemException {
		getPersistence().removeBytitle(title);
	}

	public static void removeBypriorityEqual(int priority)
		throws com.liferay.portal.SystemException {
		getPersistence().removeBypriorityEqual(priority);
	}

	public static void removeBypriorityLower(int priority)
		throws com.liferay.portal.SystemException {
		getPersistence().removeBypriorityLower(priority);
	}

	public static void removeBypriorityGreater(int priority)
		throws com.liferay.portal.SystemException {
		getPersistence().removeBypriorityGreater(priority);
	}

	public static void removeBycreatedBy(int createdBy)
		throws com.liferay.portal.SystemException {
		getPersistence().removeBycreatedBy(createdBy);
	}

	public static void removeBycreatedAtEqual(java.util.Date createdAt)
		throws com.liferay.portal.SystemException {
		getPersistence().removeBycreatedAtEqual(createdAt);
	}

	public static void removeBycreatedAtGreater(java.util.Date createdAt)
		throws com.liferay.portal.SystemException {
		getPersistence().removeBycreatedAtGreater(createdAt);
	}

	public static void removeBycreatedAtLower(java.util.Date createdAt)
		throws com.liferay.portal.SystemException {
		getPersistence().removeBycreatedAtLower(createdAt);
	}

	public static void removeByupdatedBy(int updatedBy)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByupdatedBy(updatedBy);
	}

	public static void removeByupdatedAtGreater(java.util.Date updatedAt)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByupdatedAtGreater(updatedAt);
	}

	public static void removeByupdatedAtLower(java.util.Date updatedAt)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByupdatedAtLower(updatedAt);
	}

	public static void removeByupdatedAtEqual(java.util.Date updatedAt)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByupdatedAtEqual(updatedAt);
	}

	public static void removeByaddInfo(java.lang.String addInfo)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByaddInfo(addInfo);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByorgId(java.lang.String orgId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByorgId(orgId);
	}

	public static int countByarticleOrderEquals(int articleOrder)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByarticleOrderEquals(articleOrder);
	}

	public static int countByarticleOrderGreater(int articleOrder)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByarticleOrderGreater(articleOrder);
	}

	public static int countByarticleOrderLower(int articleOrder)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByarticleOrderLower(articleOrder);
	}

	public static int countByarticleTypeEquals(int articleType)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByarticleTypeEquals(articleType);
	}

	public static int countByarticleTypeGreater(int articleType)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByarticleTypeGreater(articleType);
	}

	public static int countByarticleTypeLower(int articleType)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByarticleTypeLower(articleType);
	}

	public static int countBytitle(java.lang.String title)
		throws com.liferay.portal.SystemException {
		return getPersistence().countBytitle(title);
	}

	public static int countBypriorityEqual(int priority)
		throws com.liferay.portal.SystemException {
		return getPersistence().countBypriorityEqual(priority);
	}

	public static int countBypriorityLower(int priority)
		throws com.liferay.portal.SystemException {
		return getPersistence().countBypriorityLower(priority);
	}

	public static int countBypriorityGreater(int priority)
		throws com.liferay.portal.SystemException {
		return getPersistence().countBypriorityGreater(priority);
	}

	public static int countBycreatedBy(int createdBy)
		throws com.liferay.portal.SystemException {
		return getPersistence().countBycreatedBy(createdBy);
	}

	public static int countBycreatedAtEqual(java.util.Date createdAt)
		throws com.liferay.portal.SystemException {
		return getPersistence().countBycreatedAtEqual(createdAt);
	}

	public static int countBycreatedAtGreater(java.util.Date createdAt)
		throws com.liferay.portal.SystemException {
		return getPersistence().countBycreatedAtGreater(createdAt);
	}

	public static int countBycreatedAtLower(java.util.Date createdAt)
		throws com.liferay.portal.SystemException {
		return getPersistence().countBycreatedAtLower(createdAt);
	}

	public static int countByupdatedBy(int updatedBy)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByupdatedBy(updatedBy);
	}

	public static int countByupdatedAtGreater(java.util.Date updatedAt)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByupdatedAtGreater(updatedAt);
	}

	public static int countByupdatedAtLower(java.util.Date updatedAt)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByupdatedAtLower(updatedAt);
	}

	public static int countByupdatedAtEqual(java.util.Date updatedAt)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByupdatedAtEqual(updatedAt);
	}

	public static int countByaddInfo(java.lang.String addInfo)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByaddInfo(addInfo);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static java.util.List<larion.progate.model.ProGateProductsServices> getProGateProductsServiceses(
		java.lang.Integer pk) throws com.liferay.portal.SystemException {
		return getPersistence().getProGateProductsServiceses(pk);
	}

	public static java.util.List<larion.progate.model.ProGateProductsServices> getProGateProductsServiceses(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().getProGateProductsServiceses(pk, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateProductsServices> getProGateProductsServiceses(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().getProGateProductsServiceses(pk, start, end, obc);
	}

	public static int getProGateProductsServicesesSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException {
		return getPersistence().getProGateProductsServicesesSize(pk);
	}

	public static boolean containsProGateProductsServices(
		java.lang.Integer pk, java.lang.Integer proGateProductsServicesPK)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .containsProGateProductsServices(pk,
			proGateProductsServicesPK);
	}

	public static boolean containsProGateProductsServiceses(
		java.lang.Integer pk) throws com.liferay.portal.SystemException {
		return getPersistence().containsProGateProductsServiceses(pk);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> getProGateJournalArticleSlideShows(
		java.lang.Integer pk) throws com.liferay.portal.SystemException {
		return getPersistence().getProGateJournalArticleSlideShows(pk);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> getProGateJournalArticleSlideShows(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .getProGateJournalArticleSlideShows(pk, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> getProGateJournalArticleSlideShows(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .getProGateJournalArticleSlideShows(pk, start, end, obc);
	}

	public static int getProGateJournalArticleSlideShowsSize(
		java.lang.Integer pk) throws com.liferay.portal.SystemException {
		return getPersistence().getProGateJournalArticleSlideShowsSize(pk);
	}

	public static boolean containsProGateJournalArticleSlideShow(
		java.lang.Integer pk, java.lang.Integer proGateJournalArticleSlideShowPK)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .containsProGateJournalArticleSlideShow(pk,
			proGateJournalArticleSlideShowPK);
	}

	public static boolean containsProGateJournalArticleSlideShows(
		java.lang.Integer pk) throws com.liferay.portal.SystemException {
		return getPersistence().containsProGateJournalArticleSlideShows(pk);
	}

	public static ProGateJournalArticlePersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(ProGateJournalArticlePersistence persistence) {
		_persistence = persistence;
	}

	private static ProGateJournalArticlePersistence _persistence;
}