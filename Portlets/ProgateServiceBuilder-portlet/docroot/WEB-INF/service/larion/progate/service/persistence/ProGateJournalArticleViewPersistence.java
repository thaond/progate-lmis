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
 * <a href="ProGateJournalArticleViewPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface ProGateJournalArticleViewPersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.model.ProGateJournalArticleView proGateJournalArticleView);

	public void cacheResult(
		java.util.List<larion.progate.model.ProGateJournalArticleView> proGateJournalArticleViews);

	public void clearCache();

	public larion.progate.model.ProGateJournalArticleView create(
		java.lang.Integer journalArticleId);

	public larion.progate.model.ProGateJournalArticleView remove(
		java.lang.Integer journalArticleId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView remove(
		larion.progate.model.ProGateJournalArticleView proGateJournalArticleView)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleView update(
		larion.progate.model.ProGateJournalArticleView proGateJournalArticleView)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleView update(
		larion.progate.model.ProGateJournalArticleView proGateJournalArticleView,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleView updateImpl(
		larion.progate.model.ProGateJournalArticleView proGateJournalArticleView,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleView findByPrimaryKey(
		java.lang.Integer journalArticleId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView fetchByPrimaryKey(
		java.lang.Integer journalArticleId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findByorgId(
		java.lang.String orgId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findByorgId(
		java.lang.String orgId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findByorgId(
		java.lang.String orgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleView findByorgId_First(
		java.lang.String orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView findByorgId_Last(
		java.lang.String orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView[] findByorgId_PrevAndNext(
		java.lang.Integer journalArticleId, java.lang.String orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findByprogateCategory(
		int progateCategory) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findByprogateCategory(
		int progateCategory, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findByprogateCategory(
		int progateCategory, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleView findByprogateCategory_First(
		int progateCategory,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView findByprogateCategory_Last(
		int progateCategory,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView[] findByprogateCategory_PrevAndNext(
		java.lang.Integer journalArticleId, int progateCategory,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findByarticleTypeEquals(
		int articleType) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findByarticleTypeEquals(
		int articleType, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findByarticleTypeEquals(
		int articleType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleView findByarticleTypeEquals_First(
		int articleType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView findByarticleTypeEquals_Last(
		int articleType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView[] findByarticleTypeEquals_PrevAndNext(
		java.lang.Integer journalArticleId, int articleType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findByarticleTypeGreater(
		int articleType) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findByarticleTypeGreater(
		int articleType, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findByarticleTypeGreater(
		int articleType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleView findByarticleTypeGreater_First(
		int articleType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView findByarticleTypeGreater_Last(
		int articleType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView[] findByarticleTypeGreater_PrevAndNext(
		java.lang.Integer journalArticleId, int articleType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findByarticleTypeLower(
		int articleType) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findByarticleTypeLower(
		int articleType, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findByarticleTypeLower(
		int articleType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleView findByarticleTypeLower_First(
		int articleType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView findByarticleTypeLower_Last(
		int articleType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView[] findByarticleTypeLower_PrevAndNext(
		java.lang.Integer journalArticleId, int articleType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findByproductTypeEquals(
		int productType) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findByproductTypeEquals(
		int productType, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findByproductTypeEquals(
		int productType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleView findByproductTypeEquals_First(
		int productType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView findByproductTypeEquals_Last(
		int productType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView[] findByproductTypeEquals_PrevAndNext(
		java.lang.Integer journalArticleId, int productType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findByproductTypeGreater(
		int productType) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findByproductTypeGreater(
		int productType, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findByproductTypeGreater(
		int productType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleView findByproductTypeGreater_First(
		int productType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView findByproductTypeGreater_Last(
		int productType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView[] findByproductTypeGreater_PrevAndNext(
		java.lang.Integer journalArticleId, int productType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findByproductTypeLower(
		int productType) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findByproductTypeLower(
		int productType, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findByproductTypeLower(
		int productType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleView findByproductTypeLower_First(
		int productType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView findByproductTypeLower_Last(
		int productType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView[] findByproductTypeLower_PrevAndNext(
		java.lang.Integer journalArticleId, int productType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findBytitle(
		java.lang.String title) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findBytitle(
		java.lang.String title, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findBytitle(
		java.lang.String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleView findBytitle_First(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView findBytitle_Last(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView[] findBytitle_PrevAndNext(
		java.lang.Integer journalArticleId, java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findBypriorityEqual(
		int priority) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findBypriorityEqual(
		int priority, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findBypriorityEqual(
		int priority, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleView findBypriorityEqual_First(
		int priority, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView findBypriorityEqual_Last(
		int priority, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView[] findBypriorityEqual_PrevAndNext(
		java.lang.Integer journalArticleId, int priority,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findBypriorityLower(
		int priority) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findBypriorityLower(
		int priority, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findBypriorityLower(
		int priority, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleView findBypriorityLower_First(
		int priority, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView findBypriorityLower_Last(
		int priority, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView[] findBypriorityLower_PrevAndNext(
		java.lang.Integer journalArticleId, int priority,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findBypriorityGreater(
		int priority) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findBypriorityGreater(
		int priority, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findBypriorityGreater(
		int priority, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleView findBypriorityGreater_First(
		int priority, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView findBypriorityGreater_Last(
		int priority, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView[] findBypriorityGreater_PrevAndNext(
		java.lang.Integer journalArticleId, int priority,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findBycreatedBy(
		int createdBy) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findBycreatedBy(
		int createdBy, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findBycreatedBy(
		int createdBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleView findBycreatedBy_First(
		int createdBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView findBycreatedBy_Last(
		int createdBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView[] findBycreatedBy_PrevAndNext(
		java.lang.Integer journalArticleId, int createdBy,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findBycreatedAtEqual(
		java.util.Date createdAt) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findBycreatedAtEqual(
		java.util.Date createdAt, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findBycreatedAtEqual(
		java.util.Date createdAt, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleView findBycreatedAtEqual_First(
		java.util.Date createdAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView findBycreatedAtEqual_Last(
		java.util.Date createdAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView[] findBycreatedAtEqual_PrevAndNext(
		java.lang.Integer journalArticleId, java.util.Date createdAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findBycreatedAtGreater(
		java.util.Date createdAt) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findBycreatedAtGreater(
		java.util.Date createdAt, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findBycreatedAtGreater(
		java.util.Date createdAt, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleView findBycreatedAtGreater_First(
		java.util.Date createdAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView findBycreatedAtGreater_Last(
		java.util.Date createdAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView[] findBycreatedAtGreater_PrevAndNext(
		java.lang.Integer journalArticleId, java.util.Date createdAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findBycreatedAtLower(
		java.util.Date createdAt) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findBycreatedAtLower(
		java.util.Date createdAt, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findBycreatedAtLower(
		java.util.Date createdAt, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleView findBycreatedAtLower_First(
		java.util.Date createdAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView findBycreatedAtLower_Last(
		java.util.Date createdAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView[] findBycreatedAtLower_PrevAndNext(
		java.lang.Integer journalArticleId, java.util.Date createdAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findByupdatedBy(
		int updatedBy) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findByupdatedBy(
		int updatedBy, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findByupdatedBy(
		int updatedBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleView findByupdatedBy_First(
		int updatedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView findByupdatedBy_Last(
		int updatedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView[] findByupdatedBy_PrevAndNext(
		java.lang.Integer journalArticleId, int updatedBy,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findByupdatedAtGreater(
		java.util.Date updatedAt) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findByupdatedAtGreater(
		java.util.Date updatedAt, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findByupdatedAtGreater(
		java.util.Date updatedAt, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleView findByupdatedAtGreater_First(
		java.util.Date updatedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView findByupdatedAtGreater_Last(
		java.util.Date updatedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView[] findByupdatedAtGreater_PrevAndNext(
		java.lang.Integer journalArticleId, java.util.Date updatedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findByupdatedAtLower(
		java.util.Date updatedAt) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findByupdatedAtLower(
		java.util.Date updatedAt, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findByupdatedAtLower(
		java.util.Date updatedAt, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleView findByupdatedAtLower_First(
		java.util.Date updatedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView findByupdatedAtLower_Last(
		java.util.Date updatedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView[] findByupdatedAtLower_PrevAndNext(
		java.lang.Integer journalArticleId, java.util.Date updatedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findByupdatedAtEqual(
		java.util.Date updatedAt) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findByupdatedAtEqual(
		java.util.Date updatedAt, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findByupdatedAtEqual(
		java.util.Date updatedAt, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleView findByupdatedAtEqual_First(
		java.util.Date updatedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView findByupdatedAtEqual_Last(
		java.util.Date updatedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView[] findByupdatedAtEqual_PrevAndNext(
		java.lang.Integer journalArticleId, java.util.Date updatedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findBydiscountEqual(
		double discount) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findBydiscountEqual(
		double discount, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findBydiscountEqual(
		double discount, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleView findBydiscountEqual_First(
		double discount, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView findBydiscountEqual_Last(
		double discount, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView[] findBydiscountEqual_PrevAndNext(
		java.lang.Integer journalArticleId, double discount,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findBydiscountGreater(
		double discount) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findBydiscountGreater(
		double discount, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findBydiscountGreater(
		double discount, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleView findBydiscountGreater_First(
		double discount, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView findBydiscountGreater_Last(
		double discount, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView[] findBydiscountGreater_PrevAndNext(
		java.lang.Integer journalArticleId, double discount,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findBydiscountLower(
		double discount) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findBydiscountLower(
		double discount, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findBydiscountLower(
		double discount, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleView findBydiscountLower_First(
		double discount, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView findBydiscountLower_Last(
		double discount, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView[] findBydiscountLower_PrevAndNext(
		java.lang.Integer journalArticleId, double discount,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findBypriceEqual(
		double price) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findBypriceEqual(
		double price, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findBypriceEqual(
		double price, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleView findBypriceEqual_First(
		double price, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView findBypriceEqual_Last(
		double price, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView[] findBypriceEqual_PrevAndNext(
		java.lang.Integer journalArticleId, double price,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findBypriceGreater(
		double price) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findBypriceGreater(
		double price, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findBypriceGreater(
		double price, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleView findBypriceGreater_First(
		double price, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView findBypriceGreater_Last(
		double price, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView[] findBypriceGreater_PrevAndNext(
		java.lang.Integer journalArticleId, double price,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findBypriceLower(
		double price) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findBypriceLower(
		double price, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findBypriceLower(
		double price, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleView findBypriceLower_First(
		double price, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView findBypriceLower_Last(
		double price, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView[] findBypriceLower_PrevAndNext(
		java.lang.Integer journalArticleId, double price,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findByproductType(
		int productType) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findByproductType(
		int productType, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findByproductType(
		int productType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleView findByproductType_First(
		int productType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView findByproductType_Last(
		int productType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView[] findByproductType_PrevAndNext(
		java.lang.Integer journalArticleId, int productType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findByisService(
		boolean isService) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findByisService(
		boolean isService, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findByisService(
		boolean isService, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleView findByisService_First(
		boolean isService, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView findByisService_Last(
		boolean isService, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView[] findByisService_PrevAndNext(
		java.lang.Integer journalArticleId, boolean isService,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findByisHot(
		boolean isHot) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findByisHot(
		boolean isHot, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findByisHot(
		boolean isHot, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleView findByisHot_First(
		boolean isHot, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView findByisHot_Last(
		boolean isHot, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView[] findByisHot_PrevAndNext(
		java.lang.Integer journalArticleId, boolean isHot,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findBycurrencyCode(
		java.lang.String currencyCode)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findBycurrencyCode(
		java.lang.String currencyCode, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findBycurrencyCode(
		java.lang.String currencyCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleView findBycurrencyCode_First(
		java.lang.String currencyCode,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView findBycurrencyCode_Last(
		java.lang.String currencyCode,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView[] findBycurrencyCode_PrevAndNext(
		java.lang.Integer journalArticleId, java.lang.String currencyCode,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findByjournalArticleTypesName(
		java.lang.String journalArticleTypesName)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findByjournalArticleTypesName(
		java.lang.String journalArticleTypesName, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findByjournalArticleTypesName(
		java.lang.String journalArticleTypesName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleView findByjournalArticleTypesName_First(
		java.lang.String journalArticleTypesName,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView findByjournalArticleTypesName_Last(
		java.lang.String journalArticleTypesName,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public larion.progate.model.ProGateJournalArticleView[] findByjournalArticleTypesName_PrevAndNext(
		java.lang.Integer journalArticleId,
		java.lang.String journalArticleTypesName,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleViewException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleView> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByorgId(java.lang.String orgId)
		throws com.liferay.portal.SystemException;

	public void removeByprogateCategory(int progateCategory)
		throws com.liferay.portal.SystemException;

	public void removeByarticleTypeEquals(int articleType)
		throws com.liferay.portal.SystemException;

	public void removeByarticleTypeGreater(int articleType)
		throws com.liferay.portal.SystemException;

	public void removeByarticleTypeLower(int articleType)
		throws com.liferay.portal.SystemException;

	public void removeByproductTypeEquals(int productType)
		throws com.liferay.portal.SystemException;

	public void removeByproductTypeGreater(int productType)
		throws com.liferay.portal.SystemException;

	public void removeByproductTypeLower(int productType)
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

	public void removeBydiscountEqual(double discount)
		throws com.liferay.portal.SystemException;

	public void removeBydiscountGreater(double discount)
		throws com.liferay.portal.SystemException;

	public void removeBydiscountLower(double discount)
		throws com.liferay.portal.SystemException;

	public void removeBypriceEqual(double price)
		throws com.liferay.portal.SystemException;

	public void removeBypriceGreater(double price)
		throws com.liferay.portal.SystemException;

	public void removeBypriceLower(double price)
		throws com.liferay.portal.SystemException;

	public void removeByproductType(int productType)
		throws com.liferay.portal.SystemException;

	public void removeByisService(boolean isService)
		throws com.liferay.portal.SystemException;

	public void removeByisHot(boolean isHot)
		throws com.liferay.portal.SystemException;

	public void removeBycurrencyCode(java.lang.String currencyCode)
		throws com.liferay.portal.SystemException;

	public void removeByjournalArticleTypesName(
		java.lang.String journalArticleTypesName)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByorgId(java.lang.String orgId)
		throws com.liferay.portal.SystemException;

	public int countByprogateCategory(int progateCategory)
		throws com.liferay.portal.SystemException;

	public int countByarticleTypeEquals(int articleType)
		throws com.liferay.portal.SystemException;

	public int countByarticleTypeGreater(int articleType)
		throws com.liferay.portal.SystemException;

	public int countByarticleTypeLower(int articleType)
		throws com.liferay.portal.SystemException;

	public int countByproductTypeEquals(int productType)
		throws com.liferay.portal.SystemException;

	public int countByproductTypeGreater(int productType)
		throws com.liferay.portal.SystemException;

	public int countByproductTypeLower(int productType)
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

	public int countBydiscountEqual(double discount)
		throws com.liferay.portal.SystemException;

	public int countBydiscountGreater(double discount)
		throws com.liferay.portal.SystemException;

	public int countBydiscountLower(double discount)
		throws com.liferay.portal.SystemException;

	public int countBypriceEqual(double price)
		throws com.liferay.portal.SystemException;

	public int countBypriceGreater(double price)
		throws com.liferay.portal.SystemException;

	public int countBypriceLower(double price)
		throws com.liferay.portal.SystemException;

	public int countByproductType(int productType)
		throws com.liferay.portal.SystemException;

	public int countByisService(boolean isService)
		throws com.liferay.portal.SystemException;

	public int countByisHot(boolean isHot)
		throws com.liferay.portal.SystemException;

	public int countBycurrencyCode(java.lang.String currencyCode)
		throws com.liferay.portal.SystemException;

	public int countByjournalArticleTypesName(
		java.lang.String journalArticleTypesName)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;
}