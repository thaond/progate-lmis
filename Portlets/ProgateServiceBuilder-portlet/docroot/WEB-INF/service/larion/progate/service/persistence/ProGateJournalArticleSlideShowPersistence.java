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
 * <a href="ProGateJournalArticleSlideShowPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface ProGateJournalArticleSlideShowPersistence
	extends BasePersistence {
	public void cacheResult(
		larion.progate.model.ProGateJournalArticleSlideShow proGateJournalArticleSlideShow);

	public void cacheResult(
		java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> proGateJournalArticleSlideShows);

	public void clearCache();

	public larion.progate.model.ProGateJournalArticleSlideShow create(
		java.lang.Integer journalArticleSlideShowId);

	public larion.progate.model.ProGateJournalArticleSlideShow remove(
		java.lang.Integer journalArticleSlideShowId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException;

	public larion.progate.model.ProGateJournalArticleSlideShow remove(
		larion.progate.model.ProGateJournalArticleSlideShow proGateJournalArticleSlideShow)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleSlideShow update(
		larion.progate.model.ProGateJournalArticleSlideShow proGateJournalArticleSlideShow)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleSlideShow update(
		larion.progate.model.ProGateJournalArticleSlideShow proGateJournalArticleSlideShow,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleSlideShow updateImpl(
		larion.progate.model.ProGateJournalArticleSlideShow proGateJournalArticleSlideShow,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleSlideShow findByPrimaryKey(
		java.lang.Integer journalArticleSlideShowId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException;

	public larion.progate.model.ProGateJournalArticleSlideShow fetchByPrimaryKey(
		java.lang.Integer journalArticleSlideShowId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByorgId(
		int orgId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByorgId(
		int orgId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByorgId(
		int orgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleSlideShow findByorgId_First(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException;

	public larion.progate.model.ProGateJournalArticleSlideShow findByorgId_Last(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException;

	public larion.progate.model.ProGateJournalArticleSlideShow[] findByorgId_PrevAndNext(
		java.lang.Integer journalArticleSlideShowId, int orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException;

	public java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByslideIndexGreater(
		int slideIndex) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByslideIndexGreater(
		int slideIndex, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByslideIndexGreater(
		int slideIndex, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleSlideShow findByslideIndexGreater_First(
		int slideIndex, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException;

	public larion.progate.model.ProGateJournalArticleSlideShow findByslideIndexGreater_Last(
		int slideIndex, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException;

	public larion.progate.model.ProGateJournalArticleSlideShow[] findByslideIndexGreater_PrevAndNext(
		java.lang.Integer journalArticleSlideShowId, int slideIndex,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException;

	public java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByslideIndexLower(
		int slideIndex) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByslideIndexLower(
		int slideIndex, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByslideIndexLower(
		int slideIndex, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleSlideShow findByslideIndexLower_First(
		int slideIndex, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException;

	public larion.progate.model.ProGateJournalArticleSlideShow findByslideIndexLower_Last(
		int slideIndex, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException;

	public larion.progate.model.ProGateJournalArticleSlideShow[] findByslideIndexLower_PrevAndNext(
		java.lang.Integer journalArticleSlideShowId, int slideIndex,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException;

	public java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByslideIndexEqual(
		int slideIndex) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByslideIndexEqual(
		int slideIndex, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByslideIndexEqual(
		int slideIndex, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleSlideShow findByslideIndexEqual_First(
		int slideIndex, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException;

	public larion.progate.model.ProGateJournalArticleSlideShow findByslideIndexEqual_Last(
		int slideIndex, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException;

	public larion.progate.model.ProGateJournalArticleSlideShow[] findByslideIndexEqual_PrevAndNext(
		java.lang.Integer journalArticleSlideShowId, int slideIndex,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException;

	public java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByimageUrl(
		java.lang.String imageUrl) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByimageUrl(
		java.lang.String imageUrl, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByimageUrl(
		java.lang.String imageUrl, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleSlideShow findByimageUrl_First(
		java.lang.String imageUrl,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException;

	public larion.progate.model.ProGateJournalArticleSlideShow findByimageUrl_Last(
		java.lang.String imageUrl,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException;

	public larion.progate.model.ProGateJournalArticleSlideShow[] findByimageUrl_PrevAndNext(
		java.lang.Integer journalArticleSlideShowId, java.lang.String imageUrl,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException;

	public java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByproductId(
		int productId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByproductId(
		int productId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByproductId(
		int productId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleSlideShow findByproductId_First(
		int productId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException;

	public larion.progate.model.ProGateJournalArticleSlideShow findByproductId_Last(
		int productId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException;

	public larion.progate.model.ProGateJournalArticleSlideShow[] findByproductId_PrevAndNext(
		java.lang.Integer journalArticleSlideShowId, int productId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException;

	public java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findBycreatedBy(
		int createdBy) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findBycreatedBy(
		int createdBy, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findBycreatedBy(
		int createdBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleSlideShow findBycreatedBy_First(
		int createdBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException;

	public larion.progate.model.ProGateJournalArticleSlideShow findBycreatedBy_Last(
		int createdBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException;

	public larion.progate.model.ProGateJournalArticleSlideShow[] findBycreatedBy_PrevAndNext(
		java.lang.Integer journalArticleSlideShowId, int createdBy,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException;

	public java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findBycreatedAtEqual(
		java.util.Date createdAt) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findBycreatedAtEqual(
		java.util.Date createdAt, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findBycreatedAtEqual(
		java.util.Date createdAt, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleSlideShow findBycreatedAtEqual_First(
		java.util.Date createdAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException;

	public larion.progate.model.ProGateJournalArticleSlideShow findBycreatedAtEqual_Last(
		java.util.Date createdAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException;

	public larion.progate.model.ProGateJournalArticleSlideShow[] findBycreatedAtEqual_PrevAndNext(
		java.lang.Integer journalArticleSlideShowId, java.util.Date createdAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException;

	public java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findBycreatedAtGreater(
		java.util.Date createdAt) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findBycreatedAtGreater(
		java.util.Date createdAt, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findBycreatedAtGreater(
		java.util.Date createdAt, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleSlideShow findBycreatedAtGreater_First(
		java.util.Date createdAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException;

	public larion.progate.model.ProGateJournalArticleSlideShow findBycreatedAtGreater_Last(
		java.util.Date createdAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException;

	public larion.progate.model.ProGateJournalArticleSlideShow[] findBycreatedAtGreater_PrevAndNext(
		java.lang.Integer journalArticleSlideShowId, java.util.Date createdAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException;

	public java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findBycreatedAtLower(
		java.util.Date createdAt) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findBycreatedAtLower(
		java.util.Date createdAt, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findBycreatedAtLower(
		java.util.Date createdAt, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleSlideShow findBycreatedAtLower_First(
		java.util.Date createdAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException;

	public larion.progate.model.ProGateJournalArticleSlideShow findBycreatedAtLower_Last(
		java.util.Date createdAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException;

	public larion.progate.model.ProGateJournalArticleSlideShow[] findBycreatedAtLower_PrevAndNext(
		java.lang.Integer journalArticleSlideShowId, java.util.Date createdAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException;

	public java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByupdatedBy(
		int updatedBy) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByupdatedBy(
		int updatedBy, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByupdatedBy(
		int updatedBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleSlideShow findByupdatedBy_First(
		int updatedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException;

	public larion.progate.model.ProGateJournalArticleSlideShow findByupdatedBy_Last(
		int updatedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException;

	public larion.progate.model.ProGateJournalArticleSlideShow[] findByupdatedBy_PrevAndNext(
		java.lang.Integer journalArticleSlideShowId, int updatedBy,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException;

	public java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByupdatedAtGreater(
		java.util.Date updatedAt) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByupdatedAtGreater(
		java.util.Date updatedAt, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByupdatedAtGreater(
		java.util.Date updatedAt, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleSlideShow findByupdatedAtGreater_First(
		java.util.Date updatedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException;

	public larion.progate.model.ProGateJournalArticleSlideShow findByupdatedAtGreater_Last(
		java.util.Date updatedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException;

	public larion.progate.model.ProGateJournalArticleSlideShow[] findByupdatedAtGreater_PrevAndNext(
		java.lang.Integer journalArticleSlideShowId, java.util.Date updatedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException;

	public java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByupdatedAtLower(
		java.util.Date updatedAt) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByupdatedAtLower(
		java.util.Date updatedAt, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByupdatedAtLower(
		java.util.Date updatedAt, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleSlideShow findByupdatedAtLower_First(
		java.util.Date updatedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException;

	public larion.progate.model.ProGateJournalArticleSlideShow findByupdatedAtLower_Last(
		java.util.Date updatedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException;

	public larion.progate.model.ProGateJournalArticleSlideShow[] findByupdatedAtLower_PrevAndNext(
		java.lang.Integer journalArticleSlideShowId, java.util.Date updatedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException;

	public java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByupdatedAtEqual(
		java.util.Date updatedAt) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByupdatedAtEqual(
		java.util.Date updatedAt, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByupdatedAtEqual(
		java.util.Date updatedAt, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateJournalArticleSlideShow findByupdatedAtEqual_First(
		java.util.Date updatedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException;

	public larion.progate.model.ProGateJournalArticleSlideShow findByupdatedAtEqual_Last(
		java.util.Date updatedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException;

	public larion.progate.model.ProGateJournalArticleSlideShow[] findByupdatedAtEqual_PrevAndNext(
		java.lang.Integer journalArticleSlideShowId, java.util.Date updatedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByorgId(int orgId)
		throws com.liferay.portal.SystemException;

	public void removeByslideIndexGreater(int slideIndex)
		throws com.liferay.portal.SystemException;

	public void removeByslideIndexLower(int slideIndex)
		throws com.liferay.portal.SystemException;

	public void removeByslideIndexEqual(int slideIndex)
		throws com.liferay.portal.SystemException;

	public void removeByimageUrl(java.lang.String imageUrl)
		throws com.liferay.portal.SystemException;

	public void removeByproductId(int productId)
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

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByorgId(int orgId)
		throws com.liferay.portal.SystemException;

	public int countByslideIndexGreater(int slideIndex)
		throws com.liferay.portal.SystemException;

	public int countByslideIndexLower(int slideIndex)
		throws com.liferay.portal.SystemException;

	public int countByslideIndexEqual(int slideIndex)
		throws com.liferay.portal.SystemException;

	public int countByimageUrl(java.lang.String imageUrl)
		throws com.liferay.portal.SystemException;

	public int countByproductId(int productId)
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

	public int countAll() throws com.liferay.portal.SystemException;
}