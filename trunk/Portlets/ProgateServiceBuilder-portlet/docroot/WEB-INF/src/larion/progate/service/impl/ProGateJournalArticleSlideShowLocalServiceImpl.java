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

package larion.progate.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.ListUtils;

import larion.progate.model.ProGateJournalArticleSlideShow;
import larion.progate.service.base.ProGateJournalArticleSlideShowLocalServiceBaseImpl;
import larion.progate.service.persistence.ProGateJournalArticleSlideShowUtil;

/**
 * <a href="ProGateJournalArticleSlideShowLocalServiceImpl.java.html"><b><i>View
 * Source</i></b></a>
 * 
 * @author Brian Wing Shun Chan
 * 
 */
public class ProGateJournalArticleSlideShowLocalServiceImpl extends
		ProGateJournalArticleSlideShowLocalServiceBaseImpl {

	public ProGateJournalArticleSlideShow createArticleSlideShow(int orgId,
			int productId, String imageUrl, String title, String titleurl,
			int slideIndex, int createdBy) {

		try {
			ProGateJournalArticleSlideShow newSlideShow = ProGateJournalArticleSlideShowUtil
					.create(null);
			newSlideShow.setOrgId(orgId);
			newSlideShow.setProductId(productId);
			newSlideShow.setImageUrl(imageUrl);
			newSlideShow.setTitle(title);
			newSlideShow.setTitleUrl(titleurl);
			newSlideShow.setSlideIndex(slideIndex);
			newSlideShow.setCreatedBy(createdBy);
			newSlideShow.setIsService(false);
			newSlideShow.setCreatedAt(new Date());
			newSlideShow.setUpdatedAt(new Date());

			ProGateJournalArticleSlideShowUtil.update(newSlideShow, false);
			return newSlideShow;
		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("Exception in ProGateJournalArticleSlideShowLocalServiceImpl.createArticleSlideShow"
							+ e.toString());
			return null;
		}

	}

	public ProGateJournalArticleSlideShow getSlideShowByIndex(int index) {
		ProGateJournalArticleSlideShow result = null;
		try {
			List<ProGateJournalArticleSlideShow> listResult = ProGateJournalArticleSlideShowUtil
					.findByslideIndexEqual(index);
			if ((listResult != null) && (listResult.size() > 0)) {
				result = listResult.get(0);
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("Errors in ProGateJournalArticleSlideShowLocalServiceImpl.getSlideShowByIndex"
							+ e.toString());
		}

		return result;
	}

	@SuppressWarnings("unchecked")
	public List<ProGateJournalArticleSlideShow> getProGateJournalArticleSlideShows(
			int orgId, int start, int end) {
		List<ProGateJournalArticleSlideShow> result = null;
		List<ProGateJournalArticleSlideShow> temp = null;
		try {
			temp = ListUtils.intersection(
					ProGateJournalArticleSlideShowUtil.findAll(),
					ProGateJournalArticleSlideShowUtil.findByorgId(orgId));
			
			if (end > temp.size()) {
				result = temp.subList(start, temp.size());
			} else {
				result = temp.subList(start, end);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("Errors in ProGateJournalArticleSlideShowLocalServiceImpl.getProGateJournalArticleSlideShows"
							+ e.toString());
		}

		return result;
	}
	
	@SuppressWarnings("unchecked")
	public int countProGateJournalArticleSlideShows(
			int orgId) {
		List<ProGateJournalArticleSlideShow> temp = null;
		int result = 0;
		try {
			temp = ListUtils.intersection(
					ProGateJournalArticleSlideShowUtil.findAll(),
					ProGateJournalArticleSlideShowUtil.findByorgId(orgId));
			
			if (temp != null) {
				result = temp.size();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("Errors in ProGateJournalArticleSlideShowLocalServiceImpl.countProGateJournalArticleSlideShows"
							+ e.toString());
		}

		return result;
	}
}
