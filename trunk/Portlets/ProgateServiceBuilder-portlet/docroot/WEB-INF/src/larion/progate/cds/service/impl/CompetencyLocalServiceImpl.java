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

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang.time.DateUtils;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;

import larion.progate.cds.model.CdsTitleCompetencies;
import larion.progate.cds.model.CdsTitles;
import larion.progate.cds.model.Competency;
import larion.progate.cds.model.Level;
import larion.progate.cds.model.Slot;
import larion.progate.cds.service.CdsTitleCompetenciesLocalServiceUtil;
import larion.progate.cds.service.CdsTitlesLocalServiceUtil;
import larion.progate.cds.service.LevelLocalServiceUtil;
import larion.progate.cds.service.SlotLocalServiceUtil;
import larion.progate.cds.service.base.CompetencyLocalServiceBaseImpl;
import larion.progate.cds.service.persistence.CompetencyUtil;
import larion.progate.cds.service.persistence.LevelUtil;
import larion.progate.cds.service.utils.Constants;

/**
 * <a href="CompetencyLocalServiceImpl.java.html"><b><i>View Source</i></b></a>
 * 
 * @author Brian Wing Shun Chan
 * 
 */
public class CompetencyLocalServiceImpl extends CompetencyLocalServiceBaseImpl {
	// Khi delete competency thi can tat ca delete level va slot ben trong no
	public boolean deleteCdsCompetency(int competencyId)
			throws PortalException, SystemException {
		try {
			List<Level> levelList = LevelUtil.findBycompetencyId(competencyId);
			Iterator<Level> itLevel = levelList.iterator();
			while (itLevel.hasNext()) {
				Level tmp = itLevel.next();
				LevelLocalServiceUtil.deleteCdsLevel(tmp.getPrimaryKey());
			}
			Competency competency = getCompetency(competencyId);
			List<Competency> competencyList = CompetencyUtil
					.findBynumberOrderGreater(competency.getNumberOrder());

			// START DELETE cds_title_competencies
			List<CdsTitleCompetencies> listTitleCompetencies = CdsTitleCompetenciesLocalServiceUtil
					.getCdsTitleCompetenciesListByCompetencyId(competencyId);
			for (CdsTitleCompetencies titleCompetency : listTitleCompetencies) {
				CdsTitleCompetenciesLocalServiceUtil
						.deleteCdsTitleCompetencies(titleCompetency);
			}
			// END DELETE cds_title_competencies
			deleteCompetency(competencyId);
			// SET NUMBER ORDER
			Iterator<Competency> itCompetency = competencyList.iterator();
			while (itCompetency.hasNext()) {
				Competency com1 = itCompetency.next();
				int numberOrder = com1.getNumberOrder() - 1;
				com1.setNumberOrder(numberOrder);
				Competency com2 = updateCompetency(com1);
			}
			// END SET NUMBER ORDER
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// Ham add competency
	public boolean addCdsCompetency(int rootId, String name, int numberOrder,
			int createdBy) throws PortalException, SystemException {
		try {
			Competency competency = createCompetency(null);
			competency.setRootId(rootId);
			competency.setName(name);
			if (numberOrder <= 0)
				numberOrder = 1;
			// SET NUMBER ORDER
			List<Competency> competencyList = getCompetencyListByRootId(rootId);
			int numberCompetency = competencyList.size();
			// neu STT(numberOrder) lon hon so competency thi STT=so
			// competency+1
			if (numberOrder > numberCompetency)
				numberOrder = numberCompetency + 1;
			// neu STT=so competency thi competency cuoi cung co STT tang 1
			else if (numberOrder == numberCompetency) {
				Competency com1 = competencyList.get(numberCompetency - 1);
				com1.setNumberOrder(numberOrder + 1);
				Competency com2 = updateCompetency(com1);
			} else { // numberOrder=5; numberCompetency=10;
						// i=4;i<10;
						// lay ra competency thu 5, set lai numberOrder cua no=6
				for (int i = numberOrder - 1; i < numberCompetency;) {
					Competency com3 = competencyList.get(i);
					i = i + 1;
					com3.setNumberOrder(i + 1);
					Competency com4 = updateCompetency(com3);
				}
			}
			//
			competency.setNumberOrder(numberOrder);
			// END SET NUMBER ORDER
			competency.setCreatedBy(createdBy);
			// Lay ra ngay hien tai lam ngay tao competency
			Date date = new Date();
			date = DateUtils.addHours(date, Constants.UTC_HOURS);//Gio lay ra bi cham 7 tieng nen phai cong them
			competency.setCreatedAt(date);
			Competency c = addCompetency(competency);
			// End add competency
			// Start add cds_title_competencies
			List<CdsTitles> titleList = CdsTitlesLocalServiceUtil
					.loadListTitles(rootId);
			int sizeOfTitleList = titleList.size();
			if (sizeOfTitleList > 0) {
				for (CdsTitles title : titleList) {

					boolean tmpTitle = CdsTitleCompetenciesLocalServiceUtil
							.addTitleCompetencies(title.getPrimaryKey(),
									c.getPrimaryKey(), -1, "N/A");
				}

			}
			// End add cds_title_competencies
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// Set aliasName cua tat ca level va slot chua trong competency
	// tham so truyen vao la competencyId voi aliasName cua competency da thay
	// doi roi
	private boolean setAliasNameOfLevelsAndSlots(int competencyId)
			throws PortalException, SystemException {
		try {
			// Lay ra name cua competency
			Competency competency = getCompetency(competencyId);
			String competencyName = competency.getName();
			// Lay ra danh sach level dua vao competencyId
			List<Level> levelList = LevelLocalServiceUtil
					.getLevelListByCompetencyId(competencyId);
			Iterator<Level> itLevel = levelList.iterator();
			while (itLevel.hasNext()) {
				Level level = itLevel.next();
				//
				StringBuilder alias = new StringBuilder();
				alias.append(competencyName);
				alias.append(" - ");
				alias.append(level.getName());
				// update aliasName cua level
				Level lev = LevelLocalServiceUtil.getLevel(level
						.getPrimaryKey());
				lev.setAliasName(alias.toString());
				Level tmpLevel = LevelLocalServiceUtil.updateLevel(lev);
				boolean b = LevelLocalServiceUtil.setAliasNameOfSlots(tmpLevel
						.getPrimaryKey());
				if (b == false)
					return false;
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// Ham update competency
	public boolean updateCdsCompetency(int competencyId, String name,
			int numberOrder, int updateBy) throws PortalException,
			SystemException {
		try {
			Competency competency = getCompetency(competencyId);
			competency.setName(name);
			if (numberOrder <= 0)
				numberOrder = 1;
			// SET NUMBER ORDER
			// Lay ra numberOrder cua competency dang update
			int index = competency.getNumberOrder();
			List<Competency> competencyList = getCompetencyListByRootId(competency
					.getRootId());
			int numberCompetency = competencyList.size();
			// neu numberOrder moi < numberOrder cu thi competency tu
			// numberOrder moi
			// den competency nho hon numberOrder cu tang them 1
			// vi du 1<3: (copetency 2 co numberOrder=3)
			if (numberOrder < index) {
				competency.setNumberOrder(numberOrder);
				for (int i = numberOrder - 1; i < index - 1;) { // competency 0
																// dang co
																// numberOrder=1
																// tang len 2
					Competency com1 = competencyList.get(i);
					i = i + 1;
					com1.setNumberOrder(i + 1);
					Competency com2 = updateCompetency(com1);
				}
			}
			// neu numberOrder moi > numberOrder cu va <= numberCompetency
			// thi tu competency co numerOrder > numberOrder cu 1dv
			// den competency co numberOrder=numberOrder moi deu giam 1
			// --index=5 la competency 4 vay competency lon hon 1 la competency
			// index
			// --competency co numberOrder=6 la competency thu 5
			else if ((numberOrder > index)) {
				if (numberOrder > numberCompetency)
					numberOrder = numberCompetency;
				competency.setNumberOrder(numberOrder);
				for (int i = index; i < numberOrder; i++) { // competency thu 5
															// co numberOrder=6
															// giam 1 la 5
					Competency com3 = competencyList.get(i);
					com3.setNumberOrder(i);
					Competency com4 = updateCompetency(com3);
				}
			}
			// END SET NUMBER ORDER
			competency.setUpdatedBy(updateBy);
			// Lay ra ngay hien tai lam ngay update competency
			Date date = new Date();
			date = DateUtils.addHours(date, Constants.UTC_HOURS);//Gio lay ra bi cham 7 tieng nen phai cong them
			competency.setUpdatedAt(date);
			Competency c = updateCompetency(competency);
			// set aliasname cua level va slot
			if (setAliasNameOfLevelsAndSlots(competencyId) == false)
				return false;
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// Lay ra danh sach competency co rootId=rootId truyen vao
	public List<Competency> getCompetencyListByRootId(int rootId)
			throws PortalException, SystemException {
		List<Competency> competencyList = CompetencyUtil.findByrootId(rootId);
		return competencyList;
	}

	// Lay ra danh sach competency dua vao competencyName
	public List<Competency> getCompetencyListByCompetencyName(
			int rootId, String competencyName) throws PortalException, SystemException {
		List<Competency> rootList = CompetencyUtil.findByrootId(rootId);
		List<Competency> competenciesList = CompetencyUtil.findByname(competencyName);
		List<Competency> competencyList = ListUtils.intersection(rootList, competenciesList);
		return competencyList;
	}
	
	//Kiem tra trung ten competency
	public boolean checkCompetencyName (int rootId, String competencyName) 
		throws SystemException, PortalException{
		try {
			List<Competency> rootList = CompetencyUtil.findByrootId(rootId);
			List<Competency> competenciesList = CompetencyUtil.findByname(competencyName);
			List<Competency> competency = ListUtils.intersection(rootList, competenciesList);
			if (competency.size() != 0)
				return true;	//Da ton tai
			else
				return false;	//Chua ton tai
		} catch (Exception e) {
			System.out.println("ERROR in CompetencyLocalServiceImpl.checkCompetencyName " 
					+ e.toString());
			return true;
		}
	}
}