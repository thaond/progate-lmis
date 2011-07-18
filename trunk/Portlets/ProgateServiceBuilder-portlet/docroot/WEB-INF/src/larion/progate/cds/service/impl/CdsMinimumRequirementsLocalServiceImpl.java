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
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang.time.DateUtils;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;

import larion.progate.cds.model.CdsMinimumRequirementLevels;
import larion.progate.cds.model.CdsMinimumRequirements;
import larion.progate.cds.model.CdsTitleMinimumRequirements;

import larion.progate.cds.service.CdsMinimumRequirementLevelsLocalServiceUtil;
import larion.progate.cds.service.CdsTitleMinimumRequirementsLocalServiceUtil;
import larion.progate.cds.service.base.CdsMinimumRequirementsLocalServiceBaseImpl;
import larion.progate.cds.service.persistence.CdsMinimumRequirementLevelsUtil;
import larion.progate.cds.service.persistence.CdsMinimumRequirementsUtil;
import larion.progate.cds.service.utils.Constants;

/**
 * <a href="CdsMinimumRequirementsLocalServiceImpl.java.html"><b><i>View
 * Source</i></b></a>
 * 
 * @author Brian Wing Shun Chan
 * 
 */
public class CdsMinimumRequirementsLocalServiceImpl extends
		CdsMinimumRequirementsLocalServiceBaseImpl {
	// Delete minimum
	public boolean deleteCdsMinimumRequirement(int minimumRequirementId)
			throws PortalException, SystemException {
		try {
			// START DELETE cds_title_minimum_requirements
			List<CdsTitleMinimumRequirements> titleMiniList = CdsTitleMinimumRequirementsLocalServiceUtil
					.getCdsTitleMinimumRequirementsListByMinimumRequirementId(minimumRequirementId);
			for (CdsTitleMinimumRequirements titleMinimumRequirement : titleMiniList) {
				CdsTitleMinimumRequirementsLocalServiceUtil
						.deleteCdsTitleMinimumRequirements(titleMinimumRequirement);
			}
			// END DELETE cds_title_minimum_requirements
			// Khi delete mini thi can delete tat ca minilevel
			List<CdsMinimumRequirementLevels> miniLevelList = CdsMinimumRequirementLevelsUtil
					.findByMinimumRequirementId(minimumRequirementId);
			Iterator<CdsMinimumRequirementLevels> itminiLevel = miniLevelList
					.iterator();
			while (itminiLevel.hasNext()) {
				CdsMinimumRequirementLevels miniLevel = itminiLevel.next();
				CdsMinimumRequirementLevelsLocalServiceUtil
						.deleteCdsMinimumRequirementLevel(miniLevel
								.getPrimaryKey());
			}
			// delete mini
			CdsMinimumRequirements mini = getCdsMinimumRequirements(minimumRequirementId);
			List<CdsMinimumRequirements> miniList = CdsMinimumRequirementsUtil
					.findBynumberOrderGreater(mini.getNumberOrder());

			// SET NUMBER ORDER
			Iterator<CdsMinimumRequirements> itMini = miniList.iterator();
			while (itMini.hasNext()) {
				CdsMinimumRequirements mini1 = itMini.next();
				int numberOrder = mini1.getNumberOrder() - 1;
				mini1.setNumberOrder(numberOrder);
				CdsMinimumRequirements mini2 = updateCdsMinimumRequirements(mini1);
			}
			// END SET NUMBER ORDER
			deleteCdsMinimumRequirements(minimumRequirementId);
			return true;
		} catch (Exception e) {
			System.out
					.println("ERROR in CdsMinimumRequirementsLocalServiceImpl.deleteCdsMinimumRequirement "
							+ e.toString());
			return false;
		}
	}

	// Ham add mini
	public boolean addCdsMinimumRequirement(int rootId, String name,
			int numberOrder, int createdBy) throws PortalException,
			SystemException {
		try {
			CdsMinimumRequirements mini = createCdsMinimumRequirements(null);
			mini.setRootId(rootId);
			mini.setName(name);
			mini.setCreatedBy(createdBy);
			if (numberOrder <= 0)
				numberOrder = 1;
			// SET NUMBER ORDER
			List<CdsMinimumRequirements> miniList = getMinimumRequirementListByRootId(rootId);
			int numberMini = miniList.size();
			// neu STT(numberOrder) lon hon so mini thi STT=so mini+1
			if (numberOrder > numberMini)
				numberOrder = numberMini + 1;
			// neu STT=so mini thi mini cuoi cung co STT tang 1
			else if (numberOrder == numberMini) {
				CdsMinimumRequirements mini1 = miniList.get(numberMini - 1);
				mini1.setNumberOrder(numberOrder + 1);
				CdsMinimumRequirements mini2 = updateCdsMinimumRequirements(mini1);
			} else { // numberOrder=5; numberMini=10;
						// i=4;i<10;
						// lay ra mini thu 5, set lai numberOrder cua no=6
				for (int i = numberOrder - 1; i < numberMini;) {
					CdsMinimumRequirements mini3 = miniList.get(i);
					i = i + 1;
					mini3.setNumberOrder(i + 1);
					CdsMinimumRequirements mini4 = updateCdsMinimumRequirements(mini3);
				}
			}
			//
			mini.setNumberOrder(numberOrder);
			// END SET NUMBER ORDER
			// Lay ra ngay hien tai lam ngay tao mini
			Date date = new Date();
			date = DateUtils.addHours(date, Constants.UTC_HOURS);// Gio lay ra
																	// bi cham 7
																	// tieng nen
																	// phai cong
																	// them
			mini.setCreatedAt(date);
			CdsMinimumRequirements tmp = addCdsMinimumRequirements(mini);
			return true;
		} catch (Exception e) {
			System.out
					.println("ERROR in CdsMinimumRequirementsLocalServiceImpl.addCdsMinimumRequirement "
							+ e.toString());
			return false;
		}
	}

	// Ham update mini
	public boolean updateCdsMinimumRequirement(int minimumRequirementId,
			String name, int numberOrder, int updateBy) throws PortalException,
			SystemException {
		try {
			CdsMinimumRequirements mini = getCdsMinimumRequirements(minimumRequirementId);
			mini.setName(name);
			mini.setUpdatedBy(updateBy);
			if (numberOrder <= 0)
				numberOrder = 1;
			// SET NUMBER ORDER
			// Lay ra numberOrder cua mini dang update
			int index = mini.getNumberOrder();
			List<CdsMinimumRequirements> miniList = getMinimumRequirementListByRootId(mini
					.getRootId());
			int numberMini = miniList.size();
			// neu numberOrder moi < numberOrder cu thi mini tu numberOrder moi
			// den mini nho hon numberOrder cu tang them 1
			// vi du 1<3: (mini 2 co numberOrder=3)
			if (numberOrder < index) {
				mini.setNumberOrder(numberOrder);
				for (int i = numberOrder - 1; i < index - 1;) { // mini 0 dang
																// co
																// numberOrder=1
																// tang len 2
					CdsMinimumRequirements mini1 = miniList.get(i);
					i = i + 1;
					mini1.setNumberOrder(i + 1);
					CdsMinimumRequirements mini2 = updateCdsMinimumRequirements(mini1);
				}
			}
			// neu numberOrder moi > numberOrder cu va <= numberMini
			// thi tu mini co numerOrder > numberOrder cu 1dv
			// den mini co numberOrder=numberOrder moi deu giam 1
			// --index=5 la mini 4 vay mini lon hon 1 la mini index
			// --mini co numberOrder=6 la mini thu 5
			else if ((numberOrder > index)) {
				if (numberOrder > numberMini)
					numberOrder = numberMini;
				mini.setNumberOrder(numberOrder);
				for (int i = index; i < numberOrder; i++) { // mini thu 5 co
															// numberOrder=6
															// giam 1 la 5
					CdsMinimumRequirements mini3 = miniList.get(i);
					mini3.setNumberOrder(i);
					CdsMinimumRequirements mini4 = updateCdsMinimumRequirements(mini3);
				}
			}
			// END SET NUMBER ORDER
			// Lay ra ngay hien tai lam ngay update mini
			Date date = new Date();
			date = DateUtils.addHours(date, Constants.UTC_HOURS);// Gio lay ra
																	// bi cham 7
																	// tieng nen
																	// phai cong
																	// them
			mini.setUpdatedAt(date);
			CdsMinimumRequirements tmp = updateCdsMinimumRequirements(mini);
			return true;
		} catch (Exception e) {
			System.out
					.println("ERROR in CdsMinimumRequirementsLocalServiceImpl.updateCdsMinimumRequirement "
							+ e.toString());
			return false;
		}
	}

	// Lay tat ca Minimum Requirements theo RootId
	public List<CdsMinimumRequirements> getMinimumRequirementListByRootId(
			int rootId) throws SystemException, PortalException {
		try {
			List<CdsMinimumRequirements> minimumRequirementList = CdsMinimumRequirementsUtil
					.findByRootId(rootId);
			return minimumRequirementList;
		} catch (Exception e) {
			System.out
					.println("ERROR in CdsMinimumRequirementsLocalServiceImpl.getMinimumRequirementListByRootId "
							+ e.toString());
			List<CdsMinimumRequirements> listNull = new ArrayList<CdsMinimumRequirements>();
			return listNull;
		}
	}

	// Kiem tra trung ten
	public boolean checkMinimumRequirementName(int rootId,
			String minimumRequirementName) throws SystemException,
			PortalException {
		try {
			List<CdsMinimumRequirements> rootList = CdsMinimumRequirementsUtil
					.findByRootId(rootId);
			List<CdsMinimumRequirements> nameList = CdsMinimumRequirementsUtil
					.findByName(minimumRequirementName);
			List<CdsMinimumRequirements> miniList = ListUtils.intersection(
					rootList, nameList);
			if (miniList.size() != 0)
				return true; // Da ton tai
			else
				return false; // Chua ton tai
		} catch (Exception e) {
			System.out
					.println("ERROR in CdsMinimumRequirementsLocalServiceImpl.checkMinimumRequirementName() "
							+ e.toString());
			return true;
		}
	}
}