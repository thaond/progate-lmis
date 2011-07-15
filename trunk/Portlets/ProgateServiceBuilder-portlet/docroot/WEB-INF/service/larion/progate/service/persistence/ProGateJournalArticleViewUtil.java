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
 * <a href="ProGateJournalArticleViewUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateJournalArticleViewUtil {
	public static void cacheResult(
		larion.progate.model.ProGateJournalArticleView proGateJournalArticleView) {
		getPersistence().cacheResult(proGateJournalArticleView);
	}

	public static void cacheResult(
		java.util.List<larion.progate.model.ProGateJournalArticleView> proGateJournalArticleViews) {
		getPersistence().cacheResult(proGateJournalArticleViews);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.model.ProGateJournalArticleView create(
		java.lang.Integer journalArticleId) {
		return getPersistence().create(journalArticleId);
	}

	public static larion.progate.model.ProGateJournalArticleView remove(
		java.lang.Integer journalArticleId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().remove(journalArticleId);
	}

	public static larion.progate.model.ProGateJournalArticleView remove(
		larion.progate.model.ProGateJournalArticleView proGateJournalArticleView)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(proGateJournalArticleView);
	}

	public static larion.progate.model.ProGateJournalArticleView update(
		larion.progate.model.ProGateJournalArticleView proGateJournalArticleView)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(proGateJournalArticleView);
	}

	public static larion.progate.model.ProGateJournalArticleView update(
		larion.progate.model.ProGateJournalArticleView proGateJournalArticleView,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(proGateJournalArticleView, merge);
	}

	public static larion.progate.model.ProGateJournalArticleView updateImpl(
		larion.progate.model.ProGateJournalArticleView proGateJournalArticleView,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(proGateJournalArticleView, merge);
	}

	public static larion.progate.model.ProGateJournalArticleView findByPrimaryKey(
		java.lang.Integer journalArticleId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findByPrimaryKey(journalArticleId);
	}

	public static larion.progate.model.ProGateJournalArticleView fetchByPrimaryKey(
		java.lang.Integer journalArticleId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(journalArticleId);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findByorgId(
		java.lang.String orgId) throws com.liferay.portal.SystemException {
		return getPersistence().findByorgId(orgId);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findByorgId(
		java.lang.String orgId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByorgId(orgId, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findByorgId(
		java.lang.String orgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByorgId(orgId, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findByorgId_First(
		java.lang.String orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findByorgId_First(orgId, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findByorgId_Last(
		java.lang.String orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findByorgId_Last(orgId, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView[] findByorgId_PrevAndNext(
		java.lang.Integer journalArticleId, java.lang.String orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence()
				   .findByorgId_PrevAndNext(journalArticleId, orgId, obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findByprogateCategory(
		int progateCategory) throws com.liferay.portal.SystemException {
		return getPersistence().findByprogateCategory(progateCategory);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findByprogateCategory(
		int progateCategory, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByprogateCategory(progateCategory, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findByprogateCategory(
		int progateCategory, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByprogateCategory(progateCategory, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findByprogateCategory_First(
		int progateCategory,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findByprogateCategory_First(progateCategory, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findByprogateCategory_Last(
		int progateCategory,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findByprogateCategory_Last(progateCategory, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView[] findByprogateCategory_PrevAndNext(
		java.lang.Integer journalArticleId, int progateCategory,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence()
				   .findByprogateCategory_PrevAndNext(journalArticleId,
			progateCategory, obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findByarticleTypeEquals(
		int articleType) throws com.liferay.portal.SystemException {
		return getPersistence().findByarticleTypeEquals(articleType);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findByarticleTypeEquals(
		int articleType, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByarticleTypeEquals(articleType, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findByarticleTypeEquals(
		int articleType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByarticleTypeEquals(articleType, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findByarticleTypeEquals_First(
		int articleType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findByarticleTypeEquals_First(articleType, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findByarticleTypeEquals_Last(
		int articleType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findByarticleTypeEquals_Last(articleType, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView[] findByarticleTypeEquals_PrevAndNext(
		java.lang.Integer journalArticleId, int articleType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence()
				   .findByarticleTypeEquals_PrevAndNext(journalArticleId,
			articleType, obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findByarticleTypeGreater(
		int articleType) throws com.liferay.portal.SystemException {
		return getPersistence().findByarticleTypeGreater(articleType);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findByarticleTypeGreater(
		int articleType, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByarticleTypeGreater(articleType, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findByarticleTypeGreater(
		int articleType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByarticleTypeGreater(articleType, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findByarticleTypeGreater_First(
		int articleType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findByarticleTypeGreater_First(articleType, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findByarticleTypeGreater_Last(
		int articleType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findByarticleTypeGreater_Last(articleType, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView[] findByarticleTypeGreater_PrevAndNext(
		java.lang.Integer journalArticleId, int articleType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence()
				   .findByarticleTypeGreater_PrevAndNext(journalArticleId,
			articleType, obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findByarticleTypeLower(
		int articleType) throws com.liferay.portal.SystemException {
		return getPersistence().findByarticleTypeLower(articleType);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findByarticleTypeLower(
		int articleType, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByarticleTypeLower(articleType, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findByarticleTypeLower(
		int articleType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByarticleTypeLower(articleType, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findByarticleTypeLower_First(
		int articleType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findByarticleTypeLower_First(articleType, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findByarticleTypeLower_Last(
		int articleType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findByarticleTypeLower_Last(articleType, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView[] findByarticleTypeLower_PrevAndNext(
		java.lang.Integer journalArticleId, int articleType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence()
				   .findByarticleTypeLower_PrevAndNext(journalArticleId,
			articleType, obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findByproductTypeEquals(
		int productType) throws com.liferay.portal.SystemException {
		return getPersistence().findByproductTypeEquals(productType);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findByproductTypeEquals(
		int productType, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByproductTypeEquals(productType, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findByproductTypeEquals(
		int productType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByproductTypeEquals(productType, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findByproductTypeEquals_First(
		int productType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findByproductTypeEquals_First(productType, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findByproductTypeEquals_Last(
		int productType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findByproductTypeEquals_Last(productType, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView[] findByproductTypeEquals_PrevAndNext(
		java.lang.Integer journalArticleId, int productType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence()
				   .findByproductTypeEquals_PrevAndNext(journalArticleId,
			productType, obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findByproductTypeGreater(
		int productType) throws com.liferay.portal.SystemException {
		return getPersistence().findByproductTypeGreater(productType);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findByproductTypeGreater(
		int productType, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByproductTypeGreater(productType, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findByproductTypeGreater(
		int productType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByproductTypeGreater(productType, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findByproductTypeGreater_First(
		int productType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findByproductTypeGreater_First(productType, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findByproductTypeGreater_Last(
		int productType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findByproductTypeGreater_Last(productType, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView[] findByproductTypeGreater_PrevAndNext(
		java.lang.Integer journalArticleId, int productType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence()
				   .findByproductTypeGreater_PrevAndNext(journalArticleId,
			productType, obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findByproductTypeLower(
		int productType) throws com.liferay.portal.SystemException {
		return getPersistence().findByproductTypeLower(productType);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findByproductTypeLower(
		int productType, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByproductTypeLower(productType, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findByproductTypeLower(
		int productType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByproductTypeLower(productType, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findByproductTypeLower_First(
		int productType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findByproductTypeLower_First(productType, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findByproductTypeLower_Last(
		int productType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findByproductTypeLower_Last(productType, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView[] findByproductTypeLower_PrevAndNext(
		java.lang.Integer journalArticleId, int productType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence()
				   .findByproductTypeLower_PrevAndNext(journalArticleId,
			productType, obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findBytitle(
		java.lang.String title) throws com.liferay.portal.SystemException {
		return getPersistence().findBytitle(title);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findBytitle(
		java.lang.String title, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBytitle(title, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findBytitle(
		java.lang.String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBytitle(title, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findBytitle_First(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findBytitle_First(title, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findBytitle_Last(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findBytitle_Last(title, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView[] findBytitle_PrevAndNext(
		java.lang.Integer journalArticleId, java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence()
				   .findBytitle_PrevAndNext(journalArticleId, title, obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findBypriorityEqual(
		int priority) throws com.liferay.portal.SystemException {
		return getPersistence().findBypriorityEqual(priority);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findBypriorityEqual(
		int priority, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBypriorityEqual(priority, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findBypriorityEqual(
		int priority, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBypriorityEqual(priority, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findBypriorityEqual_First(
		int priority, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findBypriorityEqual_First(priority, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findBypriorityEqual_Last(
		int priority, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findBypriorityEqual_Last(priority, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView[] findBypriorityEqual_PrevAndNext(
		java.lang.Integer journalArticleId, int priority,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence()
				   .findBypriorityEqual_PrevAndNext(journalArticleId, priority,
			obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findBypriorityLower(
		int priority) throws com.liferay.portal.SystemException {
		return getPersistence().findBypriorityLower(priority);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findBypriorityLower(
		int priority, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBypriorityLower(priority, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findBypriorityLower(
		int priority, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBypriorityLower(priority, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findBypriorityLower_First(
		int priority, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findBypriorityLower_First(priority, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findBypriorityLower_Last(
		int priority, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findBypriorityLower_Last(priority, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView[] findBypriorityLower_PrevAndNext(
		java.lang.Integer journalArticleId, int priority,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence()
				   .findBypriorityLower_PrevAndNext(journalArticleId, priority,
			obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findBypriorityGreater(
		int priority) throws com.liferay.portal.SystemException {
		return getPersistence().findBypriorityGreater(priority);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findBypriorityGreater(
		int priority, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBypriorityGreater(priority, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findBypriorityGreater(
		int priority, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBypriorityGreater(priority, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findBypriorityGreater_First(
		int priority, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findBypriorityGreater_First(priority, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findBypriorityGreater_Last(
		int priority, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findBypriorityGreater_Last(priority, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView[] findBypriorityGreater_PrevAndNext(
		java.lang.Integer journalArticleId, int priority,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence()
				   .findBypriorityGreater_PrevAndNext(journalArticleId,
			priority, obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findBycreatedBy(
		int createdBy) throws com.liferay.portal.SystemException {
		return getPersistence().findBycreatedBy(createdBy);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findBycreatedBy(
		int createdBy, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBycreatedBy(createdBy, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findBycreatedBy(
		int createdBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBycreatedBy(createdBy, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findBycreatedBy_First(
		int createdBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findBycreatedBy_First(createdBy, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findBycreatedBy_Last(
		int createdBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findBycreatedBy_Last(createdBy, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView[] findBycreatedBy_PrevAndNext(
		java.lang.Integer journalArticleId, int createdBy,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence()
				   .findBycreatedBy_PrevAndNext(journalArticleId, createdBy, obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findBycreatedAtEqual(
		java.util.Date createdAt) throws com.liferay.portal.SystemException {
		return getPersistence().findBycreatedAtEqual(createdAt);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findBycreatedAtEqual(
		java.util.Date createdAt, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBycreatedAtEqual(createdAt, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findBycreatedAtEqual(
		java.util.Date createdAt, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBycreatedAtEqual(createdAt, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findBycreatedAtEqual_First(
		java.util.Date createdAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findBycreatedAtEqual_First(createdAt, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findBycreatedAtEqual_Last(
		java.util.Date createdAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findBycreatedAtEqual_Last(createdAt, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView[] findBycreatedAtEqual_PrevAndNext(
		java.lang.Integer journalArticleId, java.util.Date createdAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence()
				   .findBycreatedAtEqual_PrevAndNext(journalArticleId,
			createdAt, obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findBycreatedAtGreater(
		java.util.Date createdAt) throws com.liferay.portal.SystemException {
		return getPersistence().findBycreatedAtGreater(createdAt);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findBycreatedAtGreater(
		java.util.Date createdAt, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBycreatedAtGreater(createdAt, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findBycreatedAtGreater(
		java.util.Date createdAt, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findBycreatedAtGreater(createdAt, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findBycreatedAtGreater_First(
		java.util.Date createdAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findBycreatedAtGreater_First(createdAt, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findBycreatedAtGreater_Last(
		java.util.Date createdAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findBycreatedAtGreater_Last(createdAt, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView[] findBycreatedAtGreater_PrevAndNext(
		java.lang.Integer journalArticleId, java.util.Date createdAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence()
				   .findBycreatedAtGreater_PrevAndNext(journalArticleId,
			createdAt, obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findBycreatedAtLower(
		java.util.Date createdAt) throws com.liferay.portal.SystemException {
		return getPersistence().findBycreatedAtLower(createdAt);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findBycreatedAtLower(
		java.util.Date createdAt, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBycreatedAtLower(createdAt, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findBycreatedAtLower(
		java.util.Date createdAt, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBycreatedAtLower(createdAt, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findBycreatedAtLower_First(
		java.util.Date createdAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findBycreatedAtLower_First(createdAt, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findBycreatedAtLower_Last(
		java.util.Date createdAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findBycreatedAtLower_Last(createdAt, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView[] findBycreatedAtLower_PrevAndNext(
		java.lang.Integer journalArticleId, java.util.Date createdAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence()
				   .findBycreatedAtLower_PrevAndNext(journalArticleId,
			createdAt, obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findByupdatedBy(
		int updatedBy) throws com.liferay.portal.SystemException {
		return getPersistence().findByupdatedBy(updatedBy);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findByupdatedBy(
		int updatedBy, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByupdatedBy(updatedBy, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findByupdatedBy(
		int updatedBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByupdatedBy(updatedBy, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findByupdatedBy_First(
		int updatedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findByupdatedBy_First(updatedBy, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findByupdatedBy_Last(
		int updatedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findByupdatedBy_Last(updatedBy, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView[] findByupdatedBy_PrevAndNext(
		java.lang.Integer journalArticleId, int updatedBy,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence()
				   .findByupdatedBy_PrevAndNext(journalArticleId, updatedBy, obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findByupdatedAtGreater(
		java.util.Date updatedAt) throws com.liferay.portal.SystemException {
		return getPersistence().findByupdatedAtGreater(updatedAt);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findByupdatedAtGreater(
		java.util.Date updatedAt, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByupdatedAtGreater(updatedAt, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findByupdatedAtGreater(
		java.util.Date updatedAt, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByupdatedAtGreater(updatedAt, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findByupdatedAtGreater_First(
		java.util.Date updatedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findByupdatedAtGreater_First(updatedAt, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findByupdatedAtGreater_Last(
		java.util.Date updatedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findByupdatedAtGreater_Last(updatedAt, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView[] findByupdatedAtGreater_PrevAndNext(
		java.lang.Integer journalArticleId, java.util.Date updatedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence()
				   .findByupdatedAtGreater_PrevAndNext(journalArticleId,
			updatedAt, obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findByupdatedAtLower(
		java.util.Date updatedAt) throws com.liferay.portal.SystemException {
		return getPersistence().findByupdatedAtLower(updatedAt);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findByupdatedAtLower(
		java.util.Date updatedAt, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByupdatedAtLower(updatedAt, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findByupdatedAtLower(
		java.util.Date updatedAt, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByupdatedAtLower(updatedAt, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findByupdatedAtLower_First(
		java.util.Date updatedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findByupdatedAtLower_First(updatedAt, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findByupdatedAtLower_Last(
		java.util.Date updatedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findByupdatedAtLower_Last(updatedAt, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView[] findByupdatedAtLower_PrevAndNext(
		java.lang.Integer journalArticleId, java.util.Date updatedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence()
				   .findByupdatedAtLower_PrevAndNext(journalArticleId,
			updatedAt, obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findByupdatedAtEqual(
		java.util.Date updatedAt) throws com.liferay.portal.SystemException {
		return getPersistence().findByupdatedAtEqual(updatedAt);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findByupdatedAtEqual(
		java.util.Date updatedAt, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByupdatedAtEqual(updatedAt, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findByupdatedAtEqual(
		java.util.Date updatedAt, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByupdatedAtEqual(updatedAt, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findByupdatedAtEqual_First(
		java.util.Date updatedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findByupdatedAtEqual_First(updatedAt, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findByupdatedAtEqual_Last(
		java.util.Date updatedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findByupdatedAtEqual_Last(updatedAt, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView[] findByupdatedAtEqual_PrevAndNext(
		java.lang.Integer journalArticleId, java.util.Date updatedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence()
				   .findByupdatedAtEqual_PrevAndNext(journalArticleId,
			updatedAt, obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findBydiscountEqual(
		double discount) throws com.liferay.portal.SystemException {
		return getPersistence().findBydiscountEqual(discount);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findBydiscountEqual(
		double discount, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBydiscountEqual(discount, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findBydiscountEqual(
		double discount, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBydiscountEqual(discount, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findBydiscountEqual_First(
		double discount, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findBydiscountEqual_First(discount, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findBydiscountEqual_Last(
		double discount, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findBydiscountEqual_Last(discount, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView[] findBydiscountEqual_PrevAndNext(
		java.lang.Integer journalArticleId, double discount,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence()
				   .findBydiscountEqual_PrevAndNext(journalArticleId, discount,
			obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findBydiscountGreater(
		double discount) throws com.liferay.portal.SystemException {
		return getPersistence().findBydiscountGreater(discount);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findBydiscountGreater(
		double discount, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBydiscountGreater(discount, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findBydiscountGreater(
		double discount, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBydiscountGreater(discount, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findBydiscountGreater_First(
		double discount, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findBydiscountGreater_First(discount, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findBydiscountGreater_Last(
		double discount, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findBydiscountGreater_Last(discount, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView[] findBydiscountGreater_PrevAndNext(
		java.lang.Integer journalArticleId, double discount,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence()
				   .findBydiscountGreater_PrevAndNext(journalArticleId,
			discount, obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findBydiscountLower(
		double discount) throws com.liferay.portal.SystemException {
		return getPersistence().findBydiscountLower(discount);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findBydiscountLower(
		double discount, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBydiscountLower(discount, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findBydiscountLower(
		double discount, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBydiscountLower(discount, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findBydiscountLower_First(
		double discount, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findBydiscountLower_First(discount, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findBydiscountLower_Last(
		double discount, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findBydiscountLower_Last(discount, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView[] findBydiscountLower_PrevAndNext(
		java.lang.Integer journalArticleId, double discount,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence()
				   .findBydiscountLower_PrevAndNext(journalArticleId, discount,
			obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findBypriceEqual(
		double price) throws com.liferay.portal.SystemException {
		return getPersistence().findBypriceEqual(price);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findBypriceEqual(
		double price, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBypriceEqual(price, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findBypriceEqual(
		double price, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBypriceEqual(price, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findBypriceEqual_First(
		double price, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findBypriceEqual_First(price, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findBypriceEqual_Last(
		double price, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findBypriceEqual_Last(price, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView[] findBypriceEqual_PrevAndNext(
		java.lang.Integer journalArticleId, double price,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence()
				   .findBypriceEqual_PrevAndNext(journalArticleId, price, obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findBypriceGreater(
		double price) throws com.liferay.portal.SystemException {
		return getPersistence().findBypriceGreater(price);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findBypriceGreater(
		double price, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBypriceGreater(price, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findBypriceGreater(
		double price, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBypriceGreater(price, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findBypriceGreater_First(
		double price, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findBypriceGreater_First(price, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findBypriceGreater_Last(
		double price, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findBypriceGreater_Last(price, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView[] findBypriceGreater_PrevAndNext(
		java.lang.Integer journalArticleId, double price,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence()
				   .findBypriceGreater_PrevAndNext(journalArticleId, price, obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findBypriceLower(
		double price) throws com.liferay.portal.SystemException {
		return getPersistence().findBypriceLower(price);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findBypriceLower(
		double price, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBypriceLower(price, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findBypriceLower(
		double price, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBypriceLower(price, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findBypriceLower_First(
		double price, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findBypriceLower_First(price, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findBypriceLower_Last(
		double price, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findBypriceLower_Last(price, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView[] findBypriceLower_PrevAndNext(
		java.lang.Integer journalArticleId, double price,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence()
				   .findBypriceLower_PrevAndNext(journalArticleId, price, obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findByproductType(
		int productType) throws com.liferay.portal.SystemException {
		return getPersistence().findByproductType(productType);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findByproductType(
		int productType, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByproductType(productType, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findByproductType(
		int productType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByproductType(productType, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findByproductType_First(
		int productType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findByproductType_First(productType, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findByproductType_Last(
		int productType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findByproductType_Last(productType, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView[] findByproductType_PrevAndNext(
		java.lang.Integer journalArticleId, int productType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence()
				   .findByproductType_PrevAndNext(journalArticleId,
			productType, obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findByisService(
		boolean isService) throws com.liferay.portal.SystemException {
		return getPersistence().findByisService(isService);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findByisService(
		boolean isService, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByisService(isService, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findByisService(
		boolean isService, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByisService(isService, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findByisService_First(
		boolean isService, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findByisService_First(isService, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findByisService_Last(
		boolean isService, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findByisService_Last(isService, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView[] findByisService_PrevAndNext(
		java.lang.Integer journalArticleId, boolean isService,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence()
				   .findByisService_PrevAndNext(journalArticleId, isService, obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findByisHot(
		boolean isHot) throws com.liferay.portal.SystemException {
		return getPersistence().findByisHot(isHot);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findByisHot(
		boolean isHot, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByisHot(isHot, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findByisHot(
		boolean isHot, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByisHot(isHot, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findByisHot_First(
		boolean isHot, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findByisHot_First(isHot, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findByisHot_Last(
		boolean isHot, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findByisHot_Last(isHot, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView[] findByisHot_PrevAndNext(
		java.lang.Integer journalArticleId, boolean isHot,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence()
				   .findByisHot_PrevAndNext(journalArticleId, isHot, obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findBycurrencyCode(
		java.lang.String currencyCode)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBycurrencyCode(currencyCode);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findBycurrencyCode(
		java.lang.String currencyCode, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBycurrencyCode(currencyCode, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findBycurrencyCode(
		java.lang.String currencyCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBycurrencyCode(currencyCode, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findBycurrencyCode_First(
		java.lang.String currencyCode,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findBycurrencyCode_First(currencyCode, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findBycurrencyCode_Last(
		java.lang.String currencyCode,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence().findBycurrencyCode_Last(currencyCode, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView[] findBycurrencyCode_PrevAndNext(
		java.lang.Integer journalArticleId, java.lang.String currencyCode,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence()
				   .findBycurrencyCode_PrevAndNext(journalArticleId,
			currencyCode, obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findByjournalArticleTypesName(
		java.lang.String journalArticleTypesName)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByjournalArticleTypesName(journalArticleTypesName);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findByjournalArticleTypesName(
		java.lang.String journalArticleTypesName, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByjournalArticleTypesName(journalArticleTypesName,
			start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findByjournalArticleTypesName(
		java.lang.String journalArticleTypesName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByjournalArticleTypesName(journalArticleTypesName,
			start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findByjournalArticleTypesName_First(
		java.lang.String journalArticleTypesName,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence()
				   .findByjournalArticleTypesName_First(journalArticleTypesName,
			obc);
	}

	public static larion.progate.model.ProGateJournalArticleView findByjournalArticleTypesName_Last(
		java.lang.String journalArticleTypesName,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence()
				   .findByjournalArticleTypesName_Last(journalArticleTypesName,
			obc);
	}

	public static larion.progate.model.ProGateJournalArticleView[] findByjournalArticleTypesName_PrevAndNext(
		java.lang.Integer journalArticleId,
		java.lang.String journalArticleTypesName,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException {
		return getPersistence()
				   .findByjournalArticleTypesName_PrevAndNext(journalArticleId,
			journalArticleTypesName, obc);
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

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleView> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByorgId(java.lang.String orgId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByorgId(orgId);
	}

	public static void removeByprogateCategory(int progateCategory)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByprogateCategory(progateCategory);
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

	public static void removeByproductTypeEquals(int productType)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByproductTypeEquals(productType);
	}

	public static void removeByproductTypeGreater(int productType)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByproductTypeGreater(productType);
	}

	public static void removeByproductTypeLower(int productType)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByproductTypeLower(productType);
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

	public static void removeBydiscountEqual(double discount)
		throws com.liferay.portal.SystemException {
		getPersistence().removeBydiscountEqual(discount);
	}

	public static void removeBydiscountGreater(double discount)
		throws com.liferay.portal.SystemException {
		getPersistence().removeBydiscountGreater(discount);
	}

	public static void removeBydiscountLower(double discount)
		throws com.liferay.portal.SystemException {
		getPersistence().removeBydiscountLower(discount);
	}

	public static void removeBypriceEqual(double price)
		throws com.liferay.portal.SystemException {
		getPersistence().removeBypriceEqual(price);
	}

	public static void removeBypriceGreater(double price)
		throws com.liferay.portal.SystemException {
		getPersistence().removeBypriceGreater(price);
	}

	public static void removeBypriceLower(double price)
		throws com.liferay.portal.SystemException {
		getPersistence().removeBypriceLower(price);
	}

	public static void removeByproductType(int productType)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByproductType(productType);
	}

	public static void removeByisService(boolean isService)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByisService(isService);
	}

	public static void removeByisHot(boolean isHot)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByisHot(isHot);
	}

	public static void removeBycurrencyCode(java.lang.String currencyCode)
		throws com.liferay.portal.SystemException {
		getPersistence().removeBycurrencyCode(currencyCode);
	}

	public static void removeByjournalArticleTypesName(
		java.lang.String journalArticleTypesName)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByjournalArticleTypesName(journalArticleTypesName);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByorgId(java.lang.String orgId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByorgId(orgId);
	}

	public static int countByprogateCategory(int progateCategory)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByprogateCategory(progateCategory);
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

	public static int countByproductTypeEquals(int productType)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByproductTypeEquals(productType);
	}

	public static int countByproductTypeGreater(int productType)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByproductTypeGreater(productType);
	}

	public static int countByproductTypeLower(int productType)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByproductTypeLower(productType);
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

	public static int countBydiscountEqual(double discount)
		throws com.liferay.portal.SystemException {
		return getPersistence().countBydiscountEqual(discount);
	}

	public static int countBydiscountGreater(double discount)
		throws com.liferay.portal.SystemException {
		return getPersistence().countBydiscountGreater(discount);
	}

	public static int countBydiscountLower(double discount)
		throws com.liferay.portal.SystemException {
		return getPersistence().countBydiscountLower(discount);
	}

	public static int countBypriceEqual(double price)
		throws com.liferay.portal.SystemException {
		return getPersistence().countBypriceEqual(price);
	}

	public static int countBypriceGreater(double price)
		throws com.liferay.portal.SystemException {
		return getPersistence().countBypriceGreater(price);
	}

	public static int countBypriceLower(double price)
		throws com.liferay.portal.SystemException {
		return getPersistence().countBypriceLower(price);
	}

	public static int countByproductType(int productType)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByproductType(productType);
	}

	public static int countByisService(boolean isService)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByisService(isService);
	}

	public static int countByisHot(boolean isHot)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByisHot(isHot);
	}

	public static int countBycurrencyCode(java.lang.String currencyCode)
		throws com.liferay.portal.SystemException {
		return getPersistence().countBycurrencyCode(currencyCode);
	}

	public static int countByjournalArticleTypesName(
		java.lang.String journalArticleTypesName)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .countByjournalArticleTypesName(journalArticleTypesName);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static ProGateJournalArticleViewPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(ProGateJournalArticleViewPersistence persistence) {
		_persistence = persistence;
	}

	private static ProGateJournalArticleViewPersistence _persistence;
}