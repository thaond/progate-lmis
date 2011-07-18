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
import java.util.List;

import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang.time.DateUtils;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;

import larion.progate.cds.model.CdsTitleCompetencies;
import larion.progate.cds.model.CdsTitleMinimumRequirements;
import larion.progate.cds.model.CdsTitles;
import larion.progate.cds.model.Competency;
import larion.progate.cds.service.CdsMinimumRequirementsLocalServiceUtil;
import larion.progate.cds.service.CdsTitleCompetenciesLocalServiceUtil;
import larion.progate.cds.service.CdsTitleMinimumRequirementsLocalServiceUtil;
import larion.progate.cds.service.CdsTitlesLocalServiceUtil;
import larion.progate.cds.service.base.CdsTitlesLocalServiceBaseImpl;
import larion.progate.cds.service.persistence.CdsTitleCompetenciesUtil;
import larion.progate.cds.service.persistence.CdsTitleMinimumRequirementsUtil;
import larion.progate.cds.service.persistence.CdsTitlesUtil;
import larion.progate.cds.service.utils.Constants;

/**
 * <a href="CdsTitlesLocalServiceImpl.java.html"><b><i>View Source</i></b></a>
 * 
 * @author Brian Wing Shun Chan
 * 
 */
public class CdsTitlesLocalServiceImpl extends CdsTitlesLocalServiceBaseImpl {
	public boolean addCdsTitle(int rootId, String name, String abbreviation,
			int numberOrder, int createdBy, List titleCompetencies,
			List titleMinimumRequirements) throws SystemException,
			PortalException {
		try {
			Date date = new Date();
			date = DateUtils.addHours(date, Constants.UTC_HOURS);//Gio lay ra bi cham 7 tieng nen phai cong them
			CdsTitles title = createCdsTitles(null);
			title.setRootId(rootId);
			title.setName(name);
			title.setAbbreviation(abbreviation);
			
			//title.setNumberOrder(numberOrder);
			if (numberOrder <= 0)
				numberOrder = 1;
			// SET NUMBER ORDER
			List<CdsTitles> titleList = loadListTitles(rootId);
			int numberTitle = titleList.size();
			// neu STT(numberOrder) lon hon so title thi STT=so
			// title+1
			if (numberOrder > numberTitle)
				numberOrder = numberTitle + 1;
			// neu STT=so title thi title cuoi cung co STT tang 1
			else if (numberOrder == numberTitle) {
				CdsTitles title1 = titleList.get(numberTitle - 1);
				title1.setNumberOrder(numberOrder + 1);
				CdsTitles title2 = updateCdsTitles(title1);
			} else { // numberOrder=5; numberTitle=10;
						// i=4;i<10;
						// lay ra title thu 5, set lai numberOrder cua no=6
				for (int i = numberOrder - 1; i < numberTitle;) {
					CdsTitles title3 = titleList.get(i);
					i = i + 1;
					title3.setNumberOrder(i + 1);
					CdsTitles title4 = updateCdsTitles(title3);
				}
			}
			//
			title.setNumberOrder(numberOrder);
			// END SET NUMBER ORDER
			
			title.setCreatedBy(createdBy);
			title.setCreatedAt(date);
			title = addCdsTitles(title);
			CdsTitleCompetencies titleCompetency;
			CdsTitleMinimumRequirements titleMinRequirement;
			for (int i = 0; i < titleCompetencies.size(); i++) {
				titleCompetency = (CdsTitleCompetencies) titleCompetencies
						.get(i);
				CdsTitleCompetenciesLocalServiceUtil.addTitleCompetencies(
						title.getPrimaryKey(),
						titleCompetency.getCompetencyId(),
						titleCompetency.getPointHash(),
						titleCompetency.getPointValue());
			}
			for (int j = 0; j < titleMinimumRequirements.size(); j++) {
				titleMinRequirement = (CdsTitleMinimumRequirements) titleMinimumRequirements
						.get(j);
				CdsTitleMinimumRequirementsLocalServiceUtil
						.addTitleMinimumRequirements(title.getPrimaryKey(),
								titleMinRequirement.getMinimumRequirementId(),
								titleMinRequirement
										.getMinimumRequirementLevelId());
			}
			return true;
		} catch (Exception e) {
			System.out.println("ERROR in addCdsTitle " + e.toString());
			return false;
		}
	}

	// id truyen vao la titleId

	public boolean updateCdsTitle(int titleId, String name,
			String abbreviation, int numberOrder, int updatedBy,
			List titleCompetencies, List titleMinimumRequirements)
			throws SystemException, PortalException {
		try {
			CdsTitles title = getCdsTitles(titleId);
			Date date = new Date();
			date = DateUtils.addHours(date, Constants.UTC_HOURS);//Gio lay ra bi cham 7 tieng nen phai cong them
			title.setName(name);
			title.setAbbreviation(abbreviation);
			
			if (numberOrder <= 0)
				numberOrder = 1;
			// SET NUMBER ORDER
			// Lay ra numberOrder cua title dang update
			int index = title.getNumberOrder();
			List<CdsTitles> titleList = loadListTitles(title.getRootId());
			int numberTitle = titleList.size();
			// neu numberOrder moi < numberOrder cu thi title tu
			// numberOrder moi
			// den title nho hon numberOrder cu tang them 1
			// vi du 1<3: (copetency 2 co numberOrder=3)
			if (numberOrder < index) {
				title.setNumberOrder(numberOrder);
				for (int i = numberOrder - 1; i < index - 1;) { // competency 0
																// dang co
																// numberOrder=1
																// tang len 2
					CdsTitles title1 = titleList.get(i);
					i = i + 1;
					title1.setNumberOrder(i + 1);
					CdsTitles title2 = updateCdsTitles(title1);
				}
			}
			// neu numberOrder moi > numberOrder cu va <= numberTitle
			// thi tu title co numberOrder > numberOrder cu 1dv
			// den title co numberOrder=numberOrder moi deu giam 1
			// --index=5 la title 4 vay title lon hon 1 la title
			// index
			// --title co numberOrder=6 la title thu 5
			else if ((numberOrder > index)) {
				if (numberOrder > numberTitle)
					numberOrder = numberTitle;
				title.setNumberOrder(numberOrder);
				for (int i = index; i < numberOrder; i++) { // title thu 5
															// co numberOrder=6
															// giam 1 la 5
					CdsTitles title3 = titleList.get(i);
					title3.setNumberOrder(i);
					CdsTitles title4 = updateCdsTitles(title3);
				}
			}
			// END SET NUMBER ORDER
			title.setUpdatedBy(updatedBy);
			title.setUpdatedAt(date);
			title = updateCdsTitles(title);
			CdsTitleCompetencies titleCompetency1, titleCompetency2;
			CdsTitleMinimumRequirements titleMinRequirement1, titleMinRequirement2;

			/*
			 * Lay tung object trong titleCompetencies, tim theo titleId (bien
			 * id truyen vao), tim theo competencyId
			 * (titleCompetency1.getCompetencyId()). Lay giao cua 2 list tren.
			 * Sau do goi ham update va truyen bien vao
			 */

			for (int i = 0; i < titleCompetencies.size(); i++) {
				titleCompetency1 = (CdsTitleCompetencies) titleCompetencies
						.get(i);
				List<CdsTitleCompetencies> listTitles = CdsTitleCompetenciesUtil
						.findByCdsTitleId(titleId);
				List<CdsTitleCompetencies> listCompetencies = CdsTitleCompetenciesUtil
						.findByCompetencyId(titleCompetency1.getCompetencyId());
				List<CdsTitleCompetencies> list = ListUtils.intersection(
						listTitles, listCompetencies);
				for (int j = 0; j < list.size(); j++) {
					titleCompetency2 = list.get(j);
					CdsTitleCompetenciesLocalServiceUtil
							.updateTitleCompetencies(
									titleCompetency2.getPrimaryKey(),
									titleCompetency1.getPointHash(),
									titleCompetency1.getPointValue());
				}
			}

			List<CdsTitleMinimumRequirements> listTitleMini = CdsTitleMinimumRequirementsUtil
					.findByTitleId(titleId);
			for (int x = 0; x < listTitleMini.size(); x++) {
				titleMinRequirement1 = (CdsTitleMinimumRequirements) listTitleMini
						.get(x);
				CdsTitleMinimumRequirementsLocalServiceUtil
						.deleteTitleMinimumRequirements(titleMinRequirement1
								.getTitleId());
			}

			for (int y = 0; y < titleMinimumRequirements.size(); y++) {
				titleMinRequirement2 = (CdsTitleMinimumRequirements) titleMinimumRequirements
						.get(y);
				CdsTitleMinimumRequirementsLocalServiceUtil
						.addTitleMinimumRequirements(titleId,
								titleMinRequirement2.getMinimumRequirementId(),
								titleMinRequirement2
										.getMinimumRequirementLevelId());
			}

			/*
			 * CdsTitleCompetencies a, aa; CdsTitleMinimumRequirements b, bb;
			 * for (int x = 0; x < titleMinimumRequirements.size(); x++) { b =
			 * (CdsTitleMinimumRequirements) titleMinimumRequirements .get(x);
			 * List<CdsTitleMinimumRequirements> listTitle2 =
			 * CdsTitleMinimumRequirementsUtil .findByTitleId(id);
			 * List<CdsTitleMinimumRequirements> listMinimumRequirement =
			 * CdsTitleMinimumRequirementsUtil
			 * .findByMinimumRequirementId(b.getMinimumRequirementId());
			 * List<CdsTitleMinimumRequirements> list2 = ListUtils
			 * .intersection(listTitle2, listMinimumRequirement);
			 * 
			 * //Neu co list tra ve thi update lai list do, neu ko thi add them
			 * vao
			 * 
			 * if (list2.size() != 0){ for (int y = 0; y < list2.size(); y++) {
			 * bb = list2.get(y); CdsTitleMinimumRequirementsLocalServiceUtil
			 * .updateTitleMinimumRequirements( bb.getPrimaryKey(),
			 * b.getMinimumRequirementId(), b.getMinimumRequirementLevelId()); }
			 * } else CdsTitleMinimumRequirementsLocalServiceUtil
			 * .addTitleMinimumRequirements(id, b.getMinimumRequirementId(),
			 * b.getMinimumRequirementLevelId());
			 */

			// Con` loi~

			/*
			 * List<CdsTitleMinimumRequirements> listTitle3 =
			 * CdsTitleMinimumRequirementsUtil .findByTitleId(id);
			 * List<CdsTitleMinimumRequirements> listOut = ListUtils
			 * .subtract(titleMinimumRequirements,listTitle3);
			 * if(listOut.size()!=0){ for(int p = 0; p<listOut.size(); p++){ c =
			 * listOut.get(p); CdsTitleMinimumRequirementsLocalServiceUtil.
			 * deleteTitleMinimumRequirements(c.getPrimaryKey()); } }
			 */

			return true;
		} catch (Exception e) {
			System.out.println("ERROR in updateCdsTitle " + e.toString());
			return false;
		}
	}

	public boolean deleteCdsTitle(int titleId) throws SystemException,
			PortalException {
		try {
			List<CdsTitleCompetencies> listCompetencies = CdsTitleCompetenciesUtil
					.findByCdsTitleId(titleId);
			List<CdsTitleMinimumRequirements> listMinimumRequirements = CdsTitleMinimumRequirementsUtil
					.findByTitleId(titleId);
			for (int i = 0; i < listCompetencies.size(); i++)
				CdsTitleCompetenciesLocalServiceUtil
						.deleteTitleCompetencies(titleId);
			for (int j = 0; j < listMinimumRequirements.size(); j++)
				CdsTitleMinimumRequirementsLocalServiceUtil
						.deleteTitleMinimumRequirements(titleId);

			CdsTitles cdsTitle = getCdsTitles(titleId);
			deleteCdsTitles(titleId);
			// Set numberOrder
			List<CdsTitles> listTitle = CdsTitlesUtil
					.findBynumberOrderGreater(cdsTitle.getNumberOrder());
			int number = 0;
			for (CdsTitles t : listTitle) {
				number = t.getNumberOrder();
				t.setNumberOrder(number-1);
				CdsTitles temp = updateCdsTitles(t);
			}
			// End set numberOrder
			// CdsTitlesUtil.remove(titleId);
			return true;
		} catch (Exception e) {
			System.out
					.println("ERROR in CdsTitlesLocalServiceImpl.deleteCdsTitle() "
							+ e.toString());
			return false;
		}
	}

	public List<CdsTitles> loadListTitles(int rootId) throws SystemException,
			PortalException {
		List<CdsTitles> listTitles = CdsTitlesUtil.findByRootId(rootId);
		return listTitles;
	}
}