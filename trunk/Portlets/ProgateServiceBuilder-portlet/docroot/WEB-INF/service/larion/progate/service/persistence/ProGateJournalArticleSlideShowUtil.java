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
 * <a href="ProGateJournalArticleSlideShowUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateJournalArticleSlideShowUtil {
	public static void cacheResult(
		larion.progate.model.ProGateJournalArticleSlideShow proGateJournalArticleSlideShow) {
		getPersistence().cacheResult(proGateJournalArticleSlideShow);
	}

	public static void cacheResult(
		java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> proGateJournalArticleSlideShows) {
		getPersistence().cacheResult(proGateJournalArticleSlideShows);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.model.ProGateJournalArticleSlideShow create(
		java.lang.Integer journalArticleSlideShowId) {
		return getPersistence().create(journalArticleSlideShowId);
	}

	public static larion.progate.model.ProGateJournalArticleSlideShow remove(
		java.lang.Integer journalArticleSlideShowId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException {
		return getPersistence().remove(journalArticleSlideShowId);
	}

	public static larion.progate.model.ProGateJournalArticleSlideShow remove(
		larion.progate.model.ProGateJournalArticleSlideShow proGateJournalArticleSlideShow)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(proGateJournalArticleSlideShow);
	}

	public static larion.progate.model.ProGateJournalArticleSlideShow update(
		larion.progate.model.ProGateJournalArticleSlideShow proGateJournalArticleSlideShow)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(proGateJournalArticleSlideShow);
	}

	public static larion.progate.model.ProGateJournalArticleSlideShow update(
		larion.progate.model.ProGateJournalArticleSlideShow proGateJournalArticleSlideShow,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(proGateJournalArticleSlideShow, merge);
	}

	public static larion.progate.model.ProGateJournalArticleSlideShow updateImpl(
		larion.progate.model.ProGateJournalArticleSlideShow proGateJournalArticleSlideShow,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(proGateJournalArticleSlideShow, merge);
	}

	public static larion.progate.model.ProGateJournalArticleSlideShow findByPrimaryKey(
		java.lang.Integer journalArticleSlideShowId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException {
		return getPersistence().findByPrimaryKey(journalArticleSlideShowId);
	}

	public static larion.progate.model.ProGateJournalArticleSlideShow fetchByPrimaryKey(
		java.lang.Integer journalArticleSlideShowId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(journalArticleSlideShowId);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByorgId(
		int orgId) throws com.liferay.portal.SystemException {
		return getPersistence().findByorgId(orgId);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByorgId(
		int orgId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByorgId(orgId, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByorgId(
		int orgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByorgId(orgId, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticleSlideShow findByorgId_First(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException {
		return getPersistence().findByorgId_First(orgId, obc);
	}

	public static larion.progate.model.ProGateJournalArticleSlideShow findByorgId_Last(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException {
		return getPersistence().findByorgId_Last(orgId, obc);
	}

	public static larion.progate.model.ProGateJournalArticleSlideShow[] findByorgId_PrevAndNext(
		java.lang.Integer journalArticleSlideShowId, int orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException {
		return getPersistence()
				   .findByorgId_PrevAndNext(journalArticleSlideShowId, orgId,
			obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByslideIndexGreater(
		int slideIndex) throws com.liferay.portal.SystemException {
		return getPersistence().findByslideIndexGreater(slideIndex);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByslideIndexGreater(
		int slideIndex, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByslideIndexGreater(slideIndex, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByslideIndexGreater(
		int slideIndex, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByslideIndexGreater(slideIndex, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticleSlideShow findByslideIndexGreater_First(
		int slideIndex, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException {
		return getPersistence().findByslideIndexGreater_First(slideIndex, obc);
	}

	public static larion.progate.model.ProGateJournalArticleSlideShow findByslideIndexGreater_Last(
		int slideIndex, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException {
		return getPersistence().findByslideIndexGreater_Last(slideIndex, obc);
	}

	public static larion.progate.model.ProGateJournalArticleSlideShow[] findByslideIndexGreater_PrevAndNext(
		java.lang.Integer journalArticleSlideShowId, int slideIndex,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException {
		return getPersistence()
				   .findByslideIndexGreater_PrevAndNext(journalArticleSlideShowId,
			slideIndex, obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByslideIndexLower(
		int slideIndex) throws com.liferay.portal.SystemException {
		return getPersistence().findByslideIndexLower(slideIndex);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByslideIndexLower(
		int slideIndex, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByslideIndexLower(slideIndex, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByslideIndexLower(
		int slideIndex, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByslideIndexLower(slideIndex, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticleSlideShow findByslideIndexLower_First(
		int slideIndex, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException {
		return getPersistence().findByslideIndexLower_First(slideIndex, obc);
	}

	public static larion.progate.model.ProGateJournalArticleSlideShow findByslideIndexLower_Last(
		int slideIndex, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException {
		return getPersistence().findByslideIndexLower_Last(slideIndex, obc);
	}

	public static larion.progate.model.ProGateJournalArticleSlideShow[] findByslideIndexLower_PrevAndNext(
		java.lang.Integer journalArticleSlideShowId, int slideIndex,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException {
		return getPersistence()
				   .findByslideIndexLower_PrevAndNext(journalArticleSlideShowId,
			slideIndex, obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByslideIndexEqual(
		int slideIndex) throws com.liferay.portal.SystemException {
		return getPersistence().findByslideIndexEqual(slideIndex);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByslideIndexEqual(
		int slideIndex, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByslideIndexEqual(slideIndex, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByslideIndexEqual(
		int slideIndex, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByslideIndexEqual(slideIndex, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticleSlideShow findByslideIndexEqual_First(
		int slideIndex, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException {
		return getPersistence().findByslideIndexEqual_First(slideIndex, obc);
	}

	public static larion.progate.model.ProGateJournalArticleSlideShow findByslideIndexEqual_Last(
		int slideIndex, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException {
		return getPersistence().findByslideIndexEqual_Last(slideIndex, obc);
	}

	public static larion.progate.model.ProGateJournalArticleSlideShow[] findByslideIndexEqual_PrevAndNext(
		java.lang.Integer journalArticleSlideShowId, int slideIndex,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException {
		return getPersistence()
				   .findByslideIndexEqual_PrevAndNext(journalArticleSlideShowId,
			slideIndex, obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByimageUrl(
		java.lang.String imageUrl) throws com.liferay.portal.SystemException {
		return getPersistence().findByimageUrl(imageUrl);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByimageUrl(
		java.lang.String imageUrl, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByimageUrl(imageUrl, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByimageUrl(
		java.lang.String imageUrl, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByimageUrl(imageUrl, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticleSlideShow findByimageUrl_First(
		java.lang.String imageUrl,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException {
		return getPersistence().findByimageUrl_First(imageUrl, obc);
	}

	public static larion.progate.model.ProGateJournalArticleSlideShow findByimageUrl_Last(
		java.lang.String imageUrl,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException {
		return getPersistence().findByimageUrl_Last(imageUrl, obc);
	}

	public static larion.progate.model.ProGateJournalArticleSlideShow[] findByimageUrl_PrevAndNext(
		java.lang.Integer journalArticleSlideShowId, java.lang.String imageUrl,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException {
		return getPersistence()
				   .findByimageUrl_PrevAndNext(journalArticleSlideShowId,
			imageUrl, obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByproductId(
		int productId) throws com.liferay.portal.SystemException {
		return getPersistence().findByproductId(productId);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByproductId(
		int productId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByproductId(productId, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByproductId(
		int productId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByproductId(productId, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticleSlideShow findByproductId_First(
		int productId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException {
		return getPersistence().findByproductId_First(productId, obc);
	}

	public static larion.progate.model.ProGateJournalArticleSlideShow findByproductId_Last(
		int productId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException {
		return getPersistence().findByproductId_Last(productId, obc);
	}

	public static larion.progate.model.ProGateJournalArticleSlideShow[] findByproductId_PrevAndNext(
		java.lang.Integer journalArticleSlideShowId, int productId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException {
		return getPersistence()
				   .findByproductId_PrevAndNext(journalArticleSlideShowId,
			productId, obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findBycreatedBy(
		int createdBy) throws com.liferay.portal.SystemException {
		return getPersistence().findBycreatedBy(createdBy);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findBycreatedBy(
		int createdBy, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBycreatedBy(createdBy, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findBycreatedBy(
		int createdBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBycreatedBy(createdBy, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticleSlideShow findBycreatedBy_First(
		int createdBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException {
		return getPersistence().findBycreatedBy_First(createdBy, obc);
	}

	public static larion.progate.model.ProGateJournalArticleSlideShow findBycreatedBy_Last(
		int createdBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException {
		return getPersistence().findBycreatedBy_Last(createdBy, obc);
	}

	public static larion.progate.model.ProGateJournalArticleSlideShow[] findBycreatedBy_PrevAndNext(
		java.lang.Integer journalArticleSlideShowId, int createdBy,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException {
		return getPersistence()
				   .findBycreatedBy_PrevAndNext(journalArticleSlideShowId,
			createdBy, obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findBycreatedAtEqual(
		java.util.Date createdAt) throws com.liferay.portal.SystemException {
		return getPersistence().findBycreatedAtEqual(createdAt);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findBycreatedAtEqual(
		java.util.Date createdAt, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBycreatedAtEqual(createdAt, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findBycreatedAtEqual(
		java.util.Date createdAt, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBycreatedAtEqual(createdAt, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticleSlideShow findBycreatedAtEqual_First(
		java.util.Date createdAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException {
		return getPersistence().findBycreatedAtEqual_First(createdAt, obc);
	}

	public static larion.progate.model.ProGateJournalArticleSlideShow findBycreatedAtEqual_Last(
		java.util.Date createdAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException {
		return getPersistence().findBycreatedAtEqual_Last(createdAt, obc);
	}

	public static larion.progate.model.ProGateJournalArticleSlideShow[] findBycreatedAtEqual_PrevAndNext(
		java.lang.Integer journalArticleSlideShowId, java.util.Date createdAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException {
		return getPersistence()
				   .findBycreatedAtEqual_PrevAndNext(journalArticleSlideShowId,
			createdAt, obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findBycreatedAtGreater(
		java.util.Date createdAt) throws com.liferay.portal.SystemException {
		return getPersistence().findBycreatedAtGreater(createdAt);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findBycreatedAtGreater(
		java.util.Date createdAt, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBycreatedAtGreater(createdAt, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findBycreatedAtGreater(
		java.util.Date createdAt, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findBycreatedAtGreater(createdAt, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticleSlideShow findBycreatedAtGreater_First(
		java.util.Date createdAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException {
		return getPersistence().findBycreatedAtGreater_First(createdAt, obc);
	}

	public static larion.progate.model.ProGateJournalArticleSlideShow findBycreatedAtGreater_Last(
		java.util.Date createdAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException {
		return getPersistence().findBycreatedAtGreater_Last(createdAt, obc);
	}

	public static larion.progate.model.ProGateJournalArticleSlideShow[] findBycreatedAtGreater_PrevAndNext(
		java.lang.Integer journalArticleSlideShowId, java.util.Date createdAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException {
		return getPersistence()
				   .findBycreatedAtGreater_PrevAndNext(journalArticleSlideShowId,
			createdAt, obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findBycreatedAtLower(
		java.util.Date createdAt) throws com.liferay.portal.SystemException {
		return getPersistence().findBycreatedAtLower(createdAt);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findBycreatedAtLower(
		java.util.Date createdAt, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBycreatedAtLower(createdAt, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findBycreatedAtLower(
		java.util.Date createdAt, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBycreatedAtLower(createdAt, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticleSlideShow findBycreatedAtLower_First(
		java.util.Date createdAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException {
		return getPersistence().findBycreatedAtLower_First(createdAt, obc);
	}

	public static larion.progate.model.ProGateJournalArticleSlideShow findBycreatedAtLower_Last(
		java.util.Date createdAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException {
		return getPersistence().findBycreatedAtLower_Last(createdAt, obc);
	}

	public static larion.progate.model.ProGateJournalArticleSlideShow[] findBycreatedAtLower_PrevAndNext(
		java.lang.Integer journalArticleSlideShowId, java.util.Date createdAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException {
		return getPersistence()
				   .findBycreatedAtLower_PrevAndNext(journalArticleSlideShowId,
			createdAt, obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByupdatedBy(
		int updatedBy) throws com.liferay.portal.SystemException {
		return getPersistence().findByupdatedBy(updatedBy);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByupdatedBy(
		int updatedBy, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByupdatedBy(updatedBy, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByupdatedBy(
		int updatedBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByupdatedBy(updatedBy, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticleSlideShow findByupdatedBy_First(
		int updatedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException {
		return getPersistence().findByupdatedBy_First(updatedBy, obc);
	}

	public static larion.progate.model.ProGateJournalArticleSlideShow findByupdatedBy_Last(
		int updatedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException {
		return getPersistence().findByupdatedBy_Last(updatedBy, obc);
	}

	public static larion.progate.model.ProGateJournalArticleSlideShow[] findByupdatedBy_PrevAndNext(
		java.lang.Integer journalArticleSlideShowId, int updatedBy,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException {
		return getPersistence()
				   .findByupdatedBy_PrevAndNext(journalArticleSlideShowId,
			updatedBy, obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByupdatedAtGreater(
		java.util.Date updatedAt) throws com.liferay.portal.SystemException {
		return getPersistence().findByupdatedAtGreater(updatedAt);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByupdatedAtGreater(
		java.util.Date updatedAt, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByupdatedAtGreater(updatedAt, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByupdatedAtGreater(
		java.util.Date updatedAt, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByupdatedAtGreater(updatedAt, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticleSlideShow findByupdatedAtGreater_First(
		java.util.Date updatedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException {
		return getPersistence().findByupdatedAtGreater_First(updatedAt, obc);
	}

	public static larion.progate.model.ProGateJournalArticleSlideShow findByupdatedAtGreater_Last(
		java.util.Date updatedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException {
		return getPersistence().findByupdatedAtGreater_Last(updatedAt, obc);
	}

	public static larion.progate.model.ProGateJournalArticleSlideShow[] findByupdatedAtGreater_PrevAndNext(
		java.lang.Integer journalArticleSlideShowId, java.util.Date updatedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException {
		return getPersistence()
				   .findByupdatedAtGreater_PrevAndNext(journalArticleSlideShowId,
			updatedAt, obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByupdatedAtLower(
		java.util.Date updatedAt) throws com.liferay.portal.SystemException {
		return getPersistence().findByupdatedAtLower(updatedAt);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByupdatedAtLower(
		java.util.Date updatedAt, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByupdatedAtLower(updatedAt, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByupdatedAtLower(
		java.util.Date updatedAt, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByupdatedAtLower(updatedAt, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticleSlideShow findByupdatedAtLower_First(
		java.util.Date updatedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException {
		return getPersistence().findByupdatedAtLower_First(updatedAt, obc);
	}

	public static larion.progate.model.ProGateJournalArticleSlideShow findByupdatedAtLower_Last(
		java.util.Date updatedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException {
		return getPersistence().findByupdatedAtLower_Last(updatedAt, obc);
	}

	public static larion.progate.model.ProGateJournalArticleSlideShow[] findByupdatedAtLower_PrevAndNext(
		java.lang.Integer journalArticleSlideShowId, java.util.Date updatedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException {
		return getPersistence()
				   .findByupdatedAtLower_PrevAndNext(journalArticleSlideShowId,
			updatedAt, obc);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByupdatedAtEqual(
		java.util.Date updatedAt) throws com.liferay.portal.SystemException {
		return getPersistence().findByupdatedAtEqual(updatedAt);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByupdatedAtEqual(
		java.util.Date updatedAt, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByupdatedAtEqual(updatedAt, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findByupdatedAtEqual(
		java.util.Date updatedAt, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByupdatedAtEqual(updatedAt, start, end, obc);
	}

	public static larion.progate.model.ProGateJournalArticleSlideShow findByupdatedAtEqual_First(
		java.util.Date updatedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException {
		return getPersistence().findByupdatedAtEqual_First(updatedAt, obc);
	}

	public static larion.progate.model.ProGateJournalArticleSlideShow findByupdatedAtEqual_Last(
		java.util.Date updatedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException {
		return getPersistence().findByupdatedAtEqual_Last(updatedAt, obc);
	}

	public static larion.progate.model.ProGateJournalArticleSlideShow[] findByupdatedAtEqual_PrevAndNext(
		java.lang.Integer journalArticleSlideShowId, java.util.Date updatedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateJournalArticleSlideShowException {
		return getPersistence()
				   .findByupdatedAtEqual_PrevAndNext(journalArticleSlideShowId,
			updatedAt, obc);
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

	public static java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.model.ProGateJournalArticleSlideShow> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByorgId(int orgId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByorgId(orgId);
	}

	public static void removeByslideIndexGreater(int slideIndex)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByslideIndexGreater(slideIndex);
	}

	public static void removeByslideIndexLower(int slideIndex)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByslideIndexLower(slideIndex);
	}

	public static void removeByslideIndexEqual(int slideIndex)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByslideIndexEqual(slideIndex);
	}

	public static void removeByimageUrl(java.lang.String imageUrl)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByimageUrl(imageUrl);
	}

	public static void removeByproductId(int productId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByproductId(productId);
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

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByorgId(int orgId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByorgId(orgId);
	}

	public static int countByslideIndexGreater(int slideIndex)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByslideIndexGreater(slideIndex);
	}

	public static int countByslideIndexLower(int slideIndex)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByslideIndexLower(slideIndex);
	}

	public static int countByslideIndexEqual(int slideIndex)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByslideIndexEqual(slideIndex);
	}

	public static int countByimageUrl(java.lang.String imageUrl)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByimageUrl(imageUrl);
	}

	public static int countByproductId(int productId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByproductId(productId);
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

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static ProGateJournalArticleSlideShowPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(
		ProGateJournalArticleSlideShowPersistence persistence) {
		_persistence = persistence;
	}

	private static ProGateJournalArticleSlideShowPersistence _persistence;
}