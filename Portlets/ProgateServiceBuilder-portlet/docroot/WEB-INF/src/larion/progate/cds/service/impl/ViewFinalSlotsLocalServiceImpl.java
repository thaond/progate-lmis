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

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;

import larion.progate.cds.model.ViewFinalSlots;
import larion.progate.cds.service.base.ViewFinalSlotsLocalServiceBaseImpl;
import larion.progate.cds.service.persistence.ViewFinalSlotsFinderUtil;

/**
 * <a href="ViewFinalSlotsLocalServiceImpl.java.html"><b><i>View
 * Source</i></b></a>
 * 
 * @author Brian Wing Shun Chan
 * 
 */
public class ViewFinalSlotsLocalServiceImpl extends
		ViewFinalSlotsLocalServiceBaseImpl {
	// Xem ket qua
	public List<ViewFinalSlots> getFinalSlotsList(int rootId, int userId,
			int levelId, int statusOfSlot) throws PortalException,
			SystemException {
		// lay tat ca
		if (statusOfSlot == 0) {
			List<ViewFinalSlots> list1 = ViewFinalSlotsFinderUtil
					.getAllSlotsList(rootId, userId, levelId);
			if (list1 == null)
				list1 = new ArrayList<ViewFinalSlots>();
			return list1;
		}
		// slot dat
		else if (statusOfSlot == 1) {
			List<ViewFinalSlots> list2 = ViewFinalSlotsFinderUtil
					.getSlotsPassList(rootId, userId, levelId);
			if (list2 == null)
				list2 = new ArrayList<ViewFinalSlots>();
			return list2;
		}
		// slot khong dat dat
		else if (statusOfSlot == 2) {
			List<ViewFinalSlots> list3 = ViewFinalSlotsFinderUtil
					.getSlotsFailList(rootId, userId, levelId);
			if (list3 == null)
				list3 = new ArrayList<ViewFinalSlots>();
			return list3;
		}
		// slot chua danh gia
		else {
			List<ViewFinalSlots> list4 = ViewFinalSlotsFinderUtil
					.getSlotsNotStartList(rootId, userId, levelId);
			if (list4 == null)
				list4 = new ArrayList<ViewFinalSlots>();
			return list4;
		}

	}

	// Danh gia CDS
	public List<ViewFinalSlots> getFinalSlotsListNotInCdsPerformaceAppraisalSlots(
			int rootId, int userId, int statusOfSlot, int periodId)
			throws PortalException, SystemException {
		// lay tat ca
		if (statusOfSlot == 0) {
			List<ViewFinalSlots> list1 = ViewFinalSlotsFinderUtil
					.getAllSlotsListNotInPASlot(rootId, userId, periodId);
			if (list1 == null)
				list1 = new ArrayList<ViewFinalSlots>();
			return list1;
		}
		// slot dat
		else if (statusOfSlot == 1) {
			List<ViewFinalSlots> list2 = ViewFinalSlotsFinderUtil
					.getSlotsPassListNotInPASlot(rootId, userId, periodId);
			if (list2 == null)
				list2 = new ArrayList<ViewFinalSlots>();
			return list2;
		}
		// slot khong dat dat
		else if (statusOfSlot == 2) {
			List<ViewFinalSlots> list3 = ViewFinalSlotsFinderUtil
					.getSlotsFailListNotInPASlot(rootId, userId, periodId);
			if (list3 == null)
				list3 = new ArrayList<ViewFinalSlots>();
			return list3;
		}
		// slot chua danh gia
		else {
			List<ViewFinalSlots> list4 = ViewFinalSlotsFinderUtil
					.getSlotsNotStartListNotInPASlot(rootId, userId, periodId);
			if (list4 == null)
				list4 = new ArrayList<ViewFinalSlots>();
			return list4;
		}
	}
}