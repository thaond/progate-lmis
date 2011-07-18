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

import org.apache.commons.lang.time.DateUtils;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;

import larion.progate.cds.model.CdsTitleCompetencies;
import larion.progate.cds.model.Competency;
import larion.progate.cds.model.Level;
import larion.progate.cds.model.Slot;
import larion.progate.cds.service.CdsTitleCompetenciesLocalServiceUtil;
import larion.progate.cds.service.CompetencyLocalServiceUtil;
import larion.progate.cds.service.LevelLocalServiceUtil;
import larion.progate.cds.service.SlotLocalServiceUtil;
import larion.progate.cds.service.base.LevelLocalServiceBaseImpl;
import larion.progate.cds.service.persistence.LevelFinderUtil;
import larion.progate.cds.service.persistence.LevelUtil;
import larion.progate.cds.service.persistence.SlotUtil;
import larion.progate.cds.service.utils.Constants;

/**
 * <a href="LevelLocalServiceImpl.java.html"><b><i>View Source</i></b></a>
 * 
 * @author Brian Wing Shun Chan
 * 
 */
public class LevelLocalServiceImpl extends LevelLocalServiceBaseImpl {
	// Ham delete level goi ham deleteSlot de delete tat ca ca slot trong level
	// do
	public boolean deleteCdsLevel(int levelId) throws PortalException,
			SystemException {
		try {
			// delete tat ca slot trong level
			List<Slot> slotList = SlotUtil.findBylevelId(levelId);
			Iterator<Slot> itSlot = slotList.iterator();
			while (itSlot.hasNext()) {
				Slot tmp = itSlot.next();
				SlotLocalServiceUtil.deleteSlot(tmp.getPrimaryKey());
			}
			// SET NUMBER ORDER
			Level level = getLevel(levelId);
			int numberOrder = level.getNumberOrder();
			// Lay ra danh sach level thuoc competency chua level can xoa
			List<Level> levelList = getLevelListByCompetencyId(level
					.getCompetencyId());
			int numberLevel = levelList.size();

			deleteLevel(levelId);
			// START UPDATE cds_title_competencies
			List<CdsTitleCompetencies> listTitleCompetencies = CdsTitleCompetenciesLocalServiceUtil
					.getCdsTitleCompetenciesListByCompetencyId(level
							.getCompetencyId());
			for (CdsTitleCompetencies titleCompetency : listTitleCompetencies) {
				CdsTitleCompetenciesLocalServiceUtil.updateTitleCompetencies(
						titleCompetency.getPrimaryKey(), -1, "N/A");
			}
			// END UPDATE cds_title_competencies

			for (int i = numberOrder; i < numberLevel; i++) {
				Level lev1 = levelList.get(i);
				int newnumber = lev1.getNumberOrder() - 1;
				lev1.setNumberOrder(newnumber);
				Level lev2 = updateLevel(lev1);
			}
			// END SET NUMBER ORDER
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// add level
	public boolean addCdsLevel(int competencyId, String name, int numberOrder,
			int createdBy) throws PortalException, SystemException {
		try {
			Level level = createLevel(null);
			level.setCompetencyId(competencyId);
			level.setName(name);
			if (numberOrder <= 0)
				numberOrder = 1;
			// SET NUMBER ORDER
			List<Level> levelList = getLevelListByCompetencyId(competencyId);
			int numberLevel = levelList.size();
			// neu numberOrder lon hon so level thi numberOrder=so level+1
			if (numberOrder > numberLevel)
				numberOrder = numberLevel + 1;
			// neu numberOrder=so level thi level cuoi cung co numberOrder tang
			// 1
			else if (numberOrder == numberLevel) {
				Level lev1 = levelList.get(numberLevel - 1);
				lev1.setNumberOrder(numberOrder + 1);
				Level lev2 = updateLevel(lev1);
			} else { // numberOrder=5; numberLevel=10;
						// i=4;i<10;
						// lay ra level thu 5, set lai numberOrder cua no=6
				for (int i = numberOrder - 1; i < numberLevel;) {
					Level lev3 = levelList.get(i);
					i = i + 1;
					lev3.setNumberOrder(i + 1);
					Level lev4 = updateLevel(lev3);
				}
			}
			//
			level.setNumberOrder(numberOrder);
			// END SET NUMBER ORDER
			level.setCreatedBy(createdBy);
			// Set rootId tu competency dua xuong
			Competency competency = CompetencyLocalServiceUtil
					.getCompetency(competencyId);
			level.setRootId(competency.getRootId());
			// Lay ra name cua competency
			String competencyName = competency.getName();
			// Set aliasName cua level
			StringBuilder alias = new StringBuilder();
			alias.append(competencyName);
			alias.append(" - ");
			alias.append(name);
			level.setAliasName(alias.toString());
			// Lay ra ngay hien tai lam ngay tao level
			Date date = new Date();
			date = DateUtils.addHours(date, Constants.UTC_HOURS);//Gio lay ra bi cham 7 tieng nen phai cong them
			level.setCreatedAt(date);
			//
			Level l = addLevel(level);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// Set aliasName cua tat ca slot
	// tham so truyen vao la levelId voi aliasName cua level da thay doi roi
	public boolean setAliasNameOfSlots(int levelId) throws PortalException,
			SystemException {
		try {
			// Lay ra aliasName cua level
			Level level = getLevel(levelId);
			String aliasLevel = level.getAliasName();
			// Lay ra danh sach slot dua vao levelId
			List<Slot> slotList = SlotLocalServiceUtil
					.getSlotListByLevelId(levelId);
			Iterator<Slot> itSlot = slotList.iterator();
			while (itSlot.hasNext()) {
				Slot slot = itSlot.next();
				//
				StringBuilder alias = new StringBuilder();
				alias.append(aliasLevel);
				alias.append(" - ");
				alias.append(slot.getName());
				// update aliasName cua slot
				Slot s = SlotLocalServiceUtil.getSlot(slot.getPrimaryKey());
				s.setAliasName(alias.toString());
				Slot tmp = SlotLocalServiceUtil.updateSlot(s);
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// Ham update level
	public boolean updateCdsLevel(int levelId, String name, int numberOrder,
			int updateBy) throws PortalException, SystemException {
		try {
			Level level = getLevel(levelId);
			level.setName(name);
			if (numberOrder <= 0)
				numberOrder = 1;
			// SET NUMBER ORDER
			// Lay ra numberOrder cua level dang update
			int index = level.getNumberOrder();
			List<Level> levelList = getLevelListByCompetencyId(level
					.getCompetencyId());
			int numberLevel = levelList.size();
			// neu numberOrder moi < numberOrder cu thi level tu numberOrder moi
			// den level nho hon numberOrder cu tang them 1
			// vi du 1<3: (copetency 2 co numberOrder=3)
			if (numberOrder < index) {
				level.setNumberOrder(numberOrder);
				for (int i = numberOrder - 1; i < index - 1;) { // level 0 dang
																// co
																// numberOrder=1
																// tang len 2
					Level lev1 = levelList.get(i);
					i = i + 1;
					lev1.setNumberOrder(i + 1);
					Level lev2 = updateLevel(lev1);
				}
			}
			// neu numberOrder moi > numberOrder cu va <= numberLevel
			// thi tu level co numerOrder > numberOrder cu 1dv
			// den level co numberOrder=numberOrder moi deu giam 1
			// --index=5 la level 4 vay level lon hon 1 la level index
			// --level co numberOrder=6 la level thu 5
			else if ((numberOrder > index)) {
				if (numberOrder > numberLevel)
					numberOrder = numberLevel;
				level.setNumberOrder(numberOrder);
				for (int i = index; i < numberOrder; i++) { // level thu 5 co
															// numberOrder=6
															// giam 1 la 5
					Level lev3 = levelList.get(i);
					lev3.setNumberOrder(i);
					Level lev4 = updateLevel(lev3);
				}
			}
			// END SET NUMBER ORDER
			level.setUpdatedBy(updateBy);
			// Lay ra name cua competency chua level dang update
			Competency competency = CompetencyLocalServiceUtil
					.getCompetency(level.getCompetencyId());
			String competencyName = competency.getName();
			//
			StringBuilder alias = new StringBuilder();
			alias.append(competencyName);
			alias.append(" - ");
			alias.append(name);
			// set lai aliasName cua level
			level.setAliasName(alias.toString());
			// Lay ra ngay hien tai lam ngay update level
			Date date = new Date();
			date = DateUtils.addHours(date, Constants.UTC_HOURS);//Gio lay ra bi cham 7 tieng nen phai cong them
			level.setUpdatedAt(date);

			Level l = updateLevel(level);
			// can set lai aliasName cua tat ca slot chua trong level do
			if (setAliasNameOfSlots(levelId) == false)
				return false;
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// Lay ra danh sach level co competencyId=competencyId truyen vao
	public List<Level> getLevelListByCompetencyId(int competencyId)
			throws PortalException, SystemException {
		//List<Level> rootList = LevelUtil.fin
		List<Level> levelList = LevelUtil.findBycompetencyId(competencyId);
		return levelList;
	}

	// Lay ra danh sach level dua vao levelName
	public List<Level> getLevelListByLevelName(String levelName)
			throws PortalException, SystemException {
		List<Level> levelList = LevelUtil.findByname(levelName);
		return levelList;
	}
	
	//Kiem tra trung ten level
	public boolean checkLevelName (int rootId, String levelName, int competencyId)
			throws SystemException, PortalException {
		try {
			List<Level> level = LevelFinderUtil.getExistedLevel(rootId,
					levelName, competencyId);
			if (level == null)
				level = new ArrayList<Level>();
			if (level.size() != 0)
				return true; //Da ton tai
			else
				return false; //Chua ton tai
		} catch (Exception e) {
			System.out.println("ERROR in LevelLocalServiceImpl.checkLevelName " + e.toString());
			return true;
		}
	}
}