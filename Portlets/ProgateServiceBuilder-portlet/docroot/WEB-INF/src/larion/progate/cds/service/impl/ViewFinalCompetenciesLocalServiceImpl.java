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

import larion.progate.cds.model.ViewFinalCompetencies;
import larion.progate.cds.model.ViewFinalLevels;
import larion.progate.cds.model.ViewFinalSlots;
import larion.progate.cds.service.ViewFinalLevelsLocalServiceUtil;
import larion.progate.cds.service.ViewFinalSlotsLocalServiceUtil;
import larion.progate.cds.service.base.ViewFinalCompetenciesLocalServiceBaseImpl;
import larion.progate.cds.service.persistence.ViewFinalCompetenciesFinderUtil;

/**
 * <a href="ViewFinalCompetenciesLocalServiceImpl.java.html"><b><i>View
 * Source</i></b></a>
 * 
 * @author Brian Wing Shun Chan
 * 
 */
public class ViewFinalCompetenciesLocalServiceImpl extends
		ViewFinalCompetenciesLocalServiceBaseImpl {
	public List<ViewFinalCompetencies> getFinalCompetenciesList(int rootId,
			int userId, int competencyId, int statusOfSlot)
			throws PortalException, SystemException {
		if (competencyId == 0) {
			List<ViewFinalCompetencies> list1 = ViewFinalCompetenciesFinderUtil
					.getCompetenciesListByRootIdAndUserId(rootId, userId);
			if (list1 == null) {
				list1 = new ArrayList<ViewFinalCompetencies>();
				return list1;
			} else {
				List<ViewFinalCompetencies> list2 = new ArrayList<ViewFinalCompetencies>();
				for (ViewFinalCompetencies finalCompetency : list1) {
					List<ViewFinalLevels> listLevel = ViewFinalLevelsLocalServiceUtil
							.getFinalLevelsList(rootId, userId,
									finalCompetency.getPrimaryKey(),
									statusOfSlot);
					if (listLevel != null) {
						int flag = 0;
						for (ViewFinalLevels finalLevels : listLevel) {
							List<ViewFinalSlots> listSlot = ViewFinalSlotsLocalServiceUtil
									.getFinalSlotsList(rootId, userId,
											finalLevels.getPrimaryKey(),
											statusOfSlot);
							if (listSlot != null) {
								flag = 1;
								break;
							}
						}
						if (flag == 1)
							list2.add(finalCompetency);
					}
				}
				return list2;
			}
		} else {
			List<ViewFinalCompetencies> list3 = ViewFinalCompetenciesFinderUtil
					.getCompetenciesListByRootIdAndUserIdAndCompetencyId(
							rootId, userId, competencyId);
			if (list3 == null) {
				list3 = new ArrayList<ViewFinalCompetencies>();
				return list3;
			} else {
				List<ViewFinalCompetencies> list4 = new ArrayList<ViewFinalCompetencies>();
				for (ViewFinalCompetencies finalCompetency : list3) {
					List<ViewFinalLevels> listLevel = ViewFinalLevelsLocalServiceUtil
							.getFinalLevelsList(rootId, userId,
									finalCompetency.getPrimaryKey(),
									statusOfSlot);
					if (listLevel != null) {
						int flag = 0;
						for (ViewFinalLevels finalLevels : listLevel) {
							List<ViewFinalSlots> listSlot = ViewFinalSlotsLocalServiceUtil
									.getFinalSlotsList(rootId, userId,
											finalLevels.getPrimaryKey(),
											statusOfSlot);
							if (listSlot != null) {
								flag = 1;
								break;
							}
						}
						if (flag == 1)
							list4.add(finalCompetency);
					}
				}
				return list4;
			}
		}
	}
}