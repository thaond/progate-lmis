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

import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang.time.DateUtils;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;

import larion.progate.cds.model.CdsMinimumRequirementLevels;
import larion.progate.cds.model.CdsTitleMinimumRequirements;
import larion.progate.cds.model.Level;
import larion.progate.cds.model.Slot;
import larion.progate.cds.service.CdsTitleMinimumRequirementsLocalServiceUtil;
import larion.progate.cds.service.LevelLocalServiceUtil;
import larion.progate.cds.service.base.CdsMinimumRequirementLevelsLocalServiceBaseImpl;
import larion.progate.cds.service.persistence.CdsMinimumRequirementLevelsUtil;
import larion.progate.cds.service.utils.Constants;

/**
 * <a href="CdsMinimumRequirementLevelsLocalServiceImpl.java.html"><b><i>View
 * Source</i></b></a>
 * 
 * @author Brian Wing Shun Chan
 * 
 */
public class CdsMinimumRequirementLevelsLocalServiceImpl extends
		CdsMinimumRequirementLevelsLocalServiceBaseImpl {
	public boolean deleteCdsMinimumRequirementLevel(
			int minimumRequirementLevelId) throws PortalException,
			SystemException {
		try {
			// SET NUMBER ORDER
			CdsMinimumRequirementLevels miniLevel = getCdsMinimumRequirementLevels(minimumRequirementLevelId);
			int numberOrder = miniLevel.getNumberOrder();
			// Lay ra danh sach miniLevel thuoc mini chua miniLevel can xoa
			List<CdsMinimumRequirementLevels> miniLevelList = getCdsMRLevelListByMinimumRequirementId(miniLevel
					.getMinimumRequirementId());
			int numberMiniLevel = miniLevelList.size();

			for (int i = numberOrder; i < numberMiniLevel; i++) {
				CdsMinimumRequirementLevels miniLevel1 = miniLevelList.get(i);
				int newNumber = miniLevel1.getNumberOrder() - 1;
				miniLevel1.setNumberOrder(newNumber);
				CdsMinimumRequirementLevels miniLevel2 = updateCdsMinimumRequirementLevels(miniLevel1);
			}
			// END SET NUMBER ORDER
			// START DELETE cds_title_minimum_requirements
			List<CdsTitleMinimumRequirements> titleMiniList = CdsTitleMinimumRequirementsLocalServiceUtil
					.getCdsTitleMinimumRequirementsListByMinimumRequirementLevelId(minimumRequirementLevelId);
			for (CdsTitleMinimumRequirements titleMinimumRequirement : titleMiniList) {
				CdsTitleMinimumRequirementsLocalServiceUtil
						.deleteCdsTitleMinimumRequirements(titleMinimumRequirement);
			}
			// END DELETE cds_title_minimum_requirements
			deleteCdsMinimumRequirementLevels(minimumRequirementLevelId);
			return true;
		} catch (Exception e) {
			System.out
					.println("ERROR in CdsMinimumRequirementLevelsLocalServiceImpl.deleteCdsMinimumRequirementLevel "
							+ e.toString());
			return false;
		}
	}

	// add miniLevel
	public boolean addCdsMinimumRequirementLevel(int minimumRequirementId,
			String name, int numberOrder, int createdBy)
			throws PortalException, SystemException {
		try {
			CdsMinimumRequirementLevels miniLevel = createCdsMinimumRequirementLevels(null);
			miniLevel.setMinimumRequirementId(minimumRequirementId);
			miniLevel.setName(name);
			miniLevel.setCreatedBy(createdBy);
			if (numberOrder <= 0)
				numberOrder = 1;
			// SET NUMBER ORDER
			List<CdsMinimumRequirementLevels> miniLevelList = getCdsMRLevelListByMinimumRequirementId(minimumRequirementId);
			int numberMiniLevel = miniLevelList.size();
			// neu numberOrder lon hon so miniLevel thi numberOrder=so
			// miniLevel+1
			if (numberOrder > numberMiniLevel)
				numberOrder = numberMiniLevel + 1;
			// neu numberOrder=so miniLevel thi miniLevel cuoi cung co
			// numberOrder tang 1
			else if (numberOrder == numberMiniLevel) {
				CdsMinimumRequirementLevels miniLevel1 = miniLevelList
						.get(numberMiniLevel - 1);
				miniLevel1.setNumberOrder(numberOrder + 1);
				CdsMinimumRequirementLevels miniLevel2 = updateCdsMinimumRequirementLevels(miniLevel1);
			} else { // numberOrder<numberMiniLevel; numberOrder=5;
						// numberMiniLevel=10;
						// miniLevelList: i=4;i<10;
						// lay ra miniLevel thu 5, set lai numberOrder cua no=6
				for (int i = numberOrder - 1; i < numberMiniLevel;) {
					CdsMinimumRequirementLevels miniLevel3 = miniLevelList
							.get(i);
					i = i + 1;
					miniLevel3.setNumberOrder(i + 1);
					CdsMinimumRequirementLevels miniLevel4 = updateCdsMinimumRequirementLevels(miniLevel3);
				}
			}
			//
			miniLevel.setNumberOrder(numberOrder);
			// END SET NUMBER ORDER
			// Lay ra ngay hien tai lam ngay tao miniLevel
			Date date = new Date();
			date = DateUtils.addHours(date, Constants.UTC_HOURS);// Gio lay ra
																	// bi cham 7
																	// tieng nen
																	// phai cong
																	// them
			miniLevel.setCreatedAt(date);
			CdsMinimumRequirementLevels tmp = addCdsMinimumRequirementLevels(miniLevel);
			return true;
		} catch (Exception e) {
			System.out
					.println("ERROR in CdsMinimumRequirementLevelsLocalServiceImpl.addCdsMinimumRequirementLevel "
							+ e.toString());
			return false;
		}
	}

	// Ham update miniLevel
	public boolean updateCdsMinimumRequirementLevel(
			int minimumRequirementLevelId, String name, int numberOrder,
			int updateBy) throws PortalException, SystemException {
		try {
			CdsMinimumRequirementLevels miniLevel = getCdsMinimumRequirementLevels(minimumRequirementLevelId);
			miniLevel.setName(name);
			miniLevel.setUpdatedBy(updateBy);
			if (numberOrder <= 0)
				numberOrder = 1;
			// SET NUMBER ORDER
			// Lay ra numberOrder cua miniLevel dang update
			int index = miniLevel.getNumberOrder();
			List<CdsMinimumRequirementLevels> miniLevelList = getCdsMRLevelListByMinimumRequirementId(miniLevel
					.getMinimumRequirementId());
			int numberMiniLevel = miniLevelList.size();
			// neu numberOrder moi < numberOrder cu thi miniLevel tu numberOrder
			// moi
			// den miniLevel nho hon numberOrder cu tang them 1
			// vi du 1<3: (miniLevel 2 co numberOrder=3)
			if (numberOrder < index) {
				miniLevel.setNumberOrder(numberOrder);
				for (int i = numberOrder - 1; i < index - 1;) { // miniLevel 0
																// dang co
																// numberOrder=1
																// tang len 2
					CdsMinimumRequirementLevels miniLevel1 = miniLevelList
							.get(i);
					i = i + 1;
					miniLevel1.setNumberOrder(i + 1);
					CdsMinimumRequirementLevels miniLevel2 = updateCdsMinimumRequirementLevels(miniLevel1);
				}
			}
			// neu numberOrder moi > numberOrder cu va <= numberMiniLevel
			// thi tu miniLevel co numerOrder > numberOrder cu 1dv
			// den miniLevel co numberOrder=numberOrder moi deu giam 1
			// --index=5 la miniLevel 4 vay miniLevel lon hon 1 la miniLevel
			// index
			// --miniLevel co numberOrder=6 la miniLevel thu 5
			else if ((numberOrder > index)) {
				if (numberOrder > numberMiniLevel)
					numberOrder = numberMiniLevel;
				miniLevel.setNumberOrder(numberOrder);
				for (int i = index; i < numberOrder; i++) { // miniLevel thu 5
															// co numberOrder=6
															// giam 1 la 5
					CdsMinimumRequirementLevels miniLevel3 = miniLevelList
							.get(i);
					miniLevel3.setNumberOrder(i);
					CdsMinimumRequirementLevels miniLevel4 = updateCdsMinimumRequirementLevels(miniLevel3);
				}
			}
			// END SET NUMBER ORDER
			// Lay ra ngay hien tai lam ngay update miniLevel
			Date date = new Date();
			date = DateUtils.addHours(date, Constants.UTC_HOURS);// Gio lay ra
																	// bi cham 7
																	// tieng nen
																	// phai cong
																	// them
			miniLevel.setUpdatedAt(date);
			CdsMinimumRequirementLevels tmp = updateCdsMinimumRequirementLevels(miniLevel);
			return true;
		} catch (Exception e) {
			System.out
					.println("ERROR in CdsMinimumRequirementLevelsLocalServiceImpl.updateCdsMinimumRequirementLevel "
							+ e.toString());
			return false;
		}
	}

	// lay cac level theo minimum requirement id
	public List<CdsMinimumRequirementLevels> getCdsMRLevelListByMinimumRequirementId(
			int minimumRequirementId) throws SystemException, PortalException {
		try {
			List<CdsMinimumRequirementLevels> minimumRequirementLevelList = CdsMinimumRequirementLevelsUtil
					.findByMinimumRequirementId(minimumRequirementId);
			return minimumRequirementLevelList;
		} catch (Exception e) {
			System.out
					.println("ERROR in CdsMinimumRequirementLevelsLocalServiceImpl.getCdsMRLevelListByMinimumRequirementId "
							+ e.toString());
			List<CdsMinimumRequirementLevels> listNull = new ArrayList<CdsMinimumRequirementLevels>();
			return listNull;
		}
	}

	// Kiem tra trung ten
	public boolean checkMinimumRequirementLevelName(int minimumRequirementId,
			String minimumRequirementLevelName) throws SystemException,
			PortalException {
		try {
			List<CdsMinimumRequirementLevels> minimumRequirementIdList = CdsMinimumRequirementLevelsUtil
					.findByMinimumRequirementId(minimumRequirementId);
			List<CdsMinimumRequirementLevels> nameList = CdsMinimumRequirementLevelsUtil
					.findByName(minimumRequirementLevelName);
			List<CdsMinimumRequirementLevels> minimumRequirementLevelList = ListUtils
					.intersection(minimumRequirementIdList, nameList);
			if (minimumRequirementLevelList.size() != 0)
				return true; // Da ton tai
			else
				return false; // Chua ton tai
		} catch (Exception e) {
			System.out
					.println("ERROR in CdsMinimumRequirementLevelsLocalServiceImpl.checkMinimumRequirementLevelName() "
							+ e.toString());
			return true;
		}
	}
}