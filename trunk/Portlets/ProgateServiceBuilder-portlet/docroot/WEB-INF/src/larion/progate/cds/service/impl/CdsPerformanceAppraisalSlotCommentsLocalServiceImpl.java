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

package larion.progate.cds.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.time.DateUtils;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;

import larion.progate.cds.model.CdsPerformanceAppraisalSlotComments;
import larion.progate.cds.service.base.CdsPerformanceAppraisalSlotCommentsLocalServiceBaseImpl;
import larion.progate.cds.service.persistence.CdsPerformanceAppraisalSlotCommentsFinderUtil;
import larion.progate.cds.service.utils.Constants;

/**
 * <a
 * href="CdsPerformanceAppraisalSlotCommentsLocalServiceImpl.java.html"><b><i>
 * View Source</i></b></a>
 * 
 * @author Brian Wing Shun Chan
 * 
 */
public class CdsPerformanceAppraisalSlotCommentsLocalServiceImpl extends
		CdsPerformanceAppraisalSlotCommentsLocalServiceBaseImpl {
	public boolean addComment(int rootId, int userId, int periodId, int slotId,
			int commentBy, String commentContext) throws SystemException,
			PortalException {
		try {
			Date date = new Date();
			date = DateUtils.addHours(date, Constants.UTC_HOURS);// Gio lay ra bi cham 7 tieng nen phai cong them
			CdsPerformanceAppraisalSlotComments comment = createCdsPerformanceAppraisalSlotComments(null);
			comment.setRootId(rootId);
			comment.setPeriodId(periodId);
			comment.setUserId(userId);
			comment.setSlotId(slotId);
			comment.setCommentBy(commentBy);
			comment.setCommentAt(date);
			comment.setCommentContent(commentContext);
			CdsPerformanceAppraisalSlotComments succeed = addCdsPerformanceAppraisalSlotComments(comment);
			return true;
		} catch (Exception e) {
			System.out
					.println("ERROR in CdsPerformanceAppraisalSlotCommentsLocalServiceImpl.addComment "
							+ e.toString());
			return false;
		}
	}

	public List<CdsPerformanceAppraisalSlotComments> getSlotComments(
			int userId, int periodId, int slotId) throws SystemException,
			PortalException {
		try {
			List<CdsPerformanceAppraisalSlotComments> comments = CdsPerformanceAppraisalSlotCommentsFinderUtil
					.getCdsPASlotComments(userId, periodId, slotId);
			if (comments == null)
				comments = new ArrayList<CdsPerformanceAppraisalSlotComments>();
			return comments;
		} catch (Exception e) {
			System.out
					.println("ERROR in CdsPerformanceAppraisalSlotCommentsLocalServiceImpl.getSlotComments "
							+ e.toString());
			List<CdsPerformanceAppraisalSlotComments> listNull = new ArrayList<CdsPerformanceAppraisalSlotComments>();
			return listNull;
		}
	}
}