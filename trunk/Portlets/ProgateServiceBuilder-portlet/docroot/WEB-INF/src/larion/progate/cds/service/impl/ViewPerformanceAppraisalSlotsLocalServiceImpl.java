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
import java.util.List;

import org.apache.commons.collections.ListUtils;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;

import larion.progate.cds.model.ViewPerformanceAppraisalSlots;
import larion.progate.cds.service.base.ViewPerformanceAppraisalSlotsLocalServiceBaseImpl;
import larion.progate.cds.service.persistence.ViewPerformanceAppraisalSlotsFinderUtil;
import larion.progate.cds.service.persistence.ViewPerformanceAppraisalSlotsUtil;

/**
 * <a href="ViewPerformanceAppraisalSlotsLocalServiceImpl.java.html"><b><i>View
 * Source</i></b></a>
 * 
 * @author Brian Wing Shun Chan
 * 
 */
public class ViewPerformanceAppraisalSlotsLocalServiceImpl extends
		ViewPerformanceAppraisalSlotsLocalServiceBaseImpl {
	public List<ViewPerformanceAppraisalSlots> getCdsPASlots(int userId, int periodId, 
			int levelId) throws SystemException, PortalException {
		List<ViewPerformanceAppraisalSlots> listSlots = ViewPerformanceAppraisalSlotsFinderUtil
				.getCdsPASlots(userId, periodId, levelId);
		if (listSlots == null)
			listSlots = new ArrayList<ViewPerformanceAppraisalSlots>();
		return listSlots;
	}

	public ViewPerformanceAppraisalSlots getPASlotDetail(int userId, int periodId,
			int slotId) throws SystemException, PortalException {
			List<ViewPerformanceAppraisalSlots> listSlotDetails = ViewPerformanceAppraisalSlotsFinderUtil
					.getCdsPASlotDetails(userId, periodId, slotId);
			if (listSlotDetails == null)
			{
				listSlotDetails = new ArrayList<ViewPerformanceAppraisalSlots>();
				return listSlotDetails.get(0);
			}
			else
				return listSlotDetails.get(0);
	}
}