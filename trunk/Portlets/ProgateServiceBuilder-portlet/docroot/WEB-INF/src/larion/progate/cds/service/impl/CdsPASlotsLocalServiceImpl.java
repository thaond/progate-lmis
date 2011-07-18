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

import larion.progate.cds.model.CdsPACompetencies;
import larion.progate.cds.model.CdsPAFinal;
import larion.progate.cds.model.CdsPAFinalCompetenies;
import larion.progate.cds.model.CdsPAFinalLevels;
import larion.progate.cds.model.CdsPAFinalSlots;
import larion.progate.cds.model.CdsPALevels;
import larion.progate.cds.model.CdsPASlots;
import larion.progate.cds.model.CdsPerformanceAppraisals;
import larion.progate.cds.model.CdsPoints;
import larion.progate.cds.model.ViewFinalSlots;
import larion.progate.cds.model.impl.CdsPAFinalSlotsImpl;
import larion.progate.cds.service.CdsEvaluationPeriodsLocalServiceUtil;
import larion.progate.cds.service.CdsPACompetenciesLocalServiceUtil;
import larion.progate.cds.service.CdsPAFinalCompeteniesLocalServiceUtil;
import larion.progate.cds.service.CdsPAFinalLevelsLocalServiceUtil;
import larion.progate.cds.service.CdsPAFinalLocalServiceUtil;
import larion.progate.cds.service.CdsPAFinalSlotsLocalServiceUtil;
import larion.progate.cds.service.CdsPALevelsLocalServiceUtil;
import larion.progate.cds.service.CdsPASlotsLocalServiceUtil;
import larion.progate.cds.service.CdsPerformanceAppraisalsLocalServiceUtil;
import larion.progate.cds.service.CdsPointsLocalServiceUtil;
import larion.progate.cds.service.base.CdsPASlotsLocalServiceBaseImpl;

import larion.progate.cds.service.persistence.CdsPAFinalCompeteniesUtil;
import larion.progate.cds.service.persistence.CdsPAFinalLevelsUtil;
import larion.progate.cds.service.persistence.CdsPAFinalSlotsUtil;
import larion.progate.cds.service.persistence.CdsPAFinalUtil;
import larion.progate.cds.service.persistence.CdsPASlotsFinderUtil;
import larion.progate.cds.service.persistence.CdsPASlotsUtil;

/**
 * <a href="CdsPASlotsLocalServiceImpl.java.html"><b><i>View Source</i></b></a>
 * 
 * @author Brian Wing Shun Chan
 * 
 */
public class CdsPASlotsLocalServiceImpl extends CdsPASlotsLocalServiceBaseImpl {
	public List<CdsPASlots> getCdsPASlotsList(int userId, int periodId)
			throws SystemException, PortalException {
		try {
			List<CdsPASlots> list = CdsPASlotsFinderUtil.getCdsPASlots(userId,
					periodId);
			if (list == null)
				list = new ArrayList<CdsPASlots>();
			return list;
		} catch (Exception e) {
			System.out
					.println("ERROR in CdsPASlotsLocalServiceImpl.getCdsPASlotsList "
							+ e.toString());
			List<CdsPASlots> listNull = new ArrayList<CdsPASlots>();
			return listNull;
		}

	}

	public boolean addPASlots(int rootId, int userId, int periodId,
			List<Integer> CompetenciesList, List<Integer> LevelsList,
			List<ViewFinalSlots> SlotsList) throws SystemException,
			PortalException {
		try {
			CdsPerformanceAppraisals PA = CdsPerformanceAppraisalsLocalServiceUtil
					.getCdsPerformanceAppraisals(userId, periodId);
			// nhan vien moi vao sau khi dot CDS mo thi chua co trigger nen xay
			// ra loi
			// khi lay ra null thi k cho nhan vien do chon slot danh gia
			// trong dot do
			if (PA == null) {
				System.out
						.println("Dot CDS da duoc mo truoc khi nhan vien vao cong ty");
				System.out.println("Hay dong dot CDS va mo lai");
				return false;
			}
			int paId = PA.getPrimaryKey();
			// LAY RA POINTMAX ADD VAO PASLOT
			CdsPoints pointMax = CdsPointsLocalServiceUtil
					.getCdsPointMax(rootId);
			if (pointMax == null) {
				System.out.println("Cau hinh thang diem chua co diem");
				return false;
			}
			// CHUA BAT LOI KHI KHONG CO POINT

			int sizeOfCompetencyList = CompetenciesList.size();
			int sizeOfLevelList = LevelsList.size();
			int sizeOfSlotList = SlotsList.size();

			// XOA COMPETENCIES
			// so sanh competency giua listmoi va list trong database
			// phan tu co trong database ma k co trong list moi thi xoa
			// phan tu co trong list moi ma k co trong database thi them vao
			List<CdsPACompetencies> CompetencyListInDataBase = CdsPACompetenciesLocalServiceUtil
					.getCdsPACompetencies(userId, periodId);
			int sizeOfCompetencyListDataBase = CompetencyListInDataBase.size();

			int j, find;
			for (int i = 0; i < sizeOfCompetencyListDataBase; i++) {
				find = 0;// phan tu trong database k co trong listmoi
				// listmoi chay
				for (j = 0; j < sizeOfCompetencyList; j++) {
					if (CompetenciesList.get(j).equals(
							CompetencyListInDataBase.get(i).getCompetencyId())) {
						find = 1;// tim thay phan tu trong database co trong
									// listmoi xoa phan tu do trong listmoi
						CompetenciesList.remove(j);
						sizeOfCompetencyList = sizeOfCompetencyList - 1;
					}
				}
				if (find == 0)// tim k thay trong list moi thi xoa phan tu do
								// trong database
				{
					CdsPACompetenciesLocalServiceUtil
							.deleteCdsPACompetencies(CompetencyListInDataBase
									.get(i).getPrimaryKey());
				}
			}

			// XOA LEVELS
			List<CdsPALevels> LevelsListInDataBase = CdsPALevelsLocalServiceUtil
					.getCdsPALevelsList(userId, periodId);
			int sizeOfLevelsListInDataBase = LevelsListInDataBase.size();

			for (int i = 0; i < sizeOfLevelsListInDataBase; i++) {
				find = 0;// phan tu trong database k co trong listmoi
				// listmoi chay
				for (j = 0; j < sizeOfLevelList; j++) {
					if (LevelsList.get(j).equals(
							LevelsListInDataBase.get(i).getLevelId())) {
						find = 1;// tim thay phan tu trong database co trong
									// listmoi xoa phan tu do trong listmoi
						LevelsList.remove(j);
						sizeOfLevelList = sizeOfLevelList - 1;
					}
				}
				if (find == 0)// tim k thay trong list moi thi xoa phan tu do
								// trong database
				{
					CdsPALevelsLocalServiceUtil
							.deleteCdsPALevels(LevelsListInDataBase.get(i)
									.getPrimaryKey());
				}
			}

			// XOA SLOTS
			List<CdsPASlots> SlotsListInDataBase = CdsPASlotsLocalServiceUtil
					.getCdsPASlotsList(userId, periodId);
			int sizeOfSlotsListInDataBase = SlotsListInDataBase.size();

			for (int i = 0; i < sizeOfSlotsListInDataBase; i++) {
				find = 0;// phan tu trong database k co trong listmoi
				// listmoi chay
				for (j = 0; j < sizeOfSlotList; j++) {
					if (SlotsList.get(j).getSlotId()
							.equals(SlotsListInDataBase.get(i).getSlotId())) {
						find = 1;// tim thay phan tu trong database co trong
									// listmoi xoa phan tu do trong listmoi
						ViewFinalSlots tempSlot = SlotsList.remove(j);
						sizeOfSlotList = sizeOfSlotList - 1;
					}
				}
				if (find == 0)// tim k thay trong list moi thi xoa phan tu do
								// trong database
				{
					CdsPASlotsLocalServiceUtil
							.deleteCdsPASlots(SlotsListInDataBase.get(i)
									.getPrimaryKey());
				}
			}

			// KET THUC XOA
			// add danh sach competency

			for (int i = 0; i < sizeOfCompetencyList; i++) {
				CdsPACompetencies cdsPACompetency = CdsPACompetenciesLocalServiceUtil
						.createCdsPACompetencies(null);
				cdsPACompetency.setPaId(paId);
				cdsPACompetency.setRootId(rootId);
				cdsPACompetency.setUserId(userId);
				cdsPACompetency.setPeriodId(periodId);

				cdsPACompetency.setCompetencyId(CompetenciesList.get(i));

				CdsPACompetencies tmpCdsPACompetency = CdsPACompetenciesLocalServiceUtil
						.addCdsPACompetencies(cdsPACompetency);
			}
			// add danh sach level

			for (int i = 0; i < sizeOfLevelList; i++) {
				CdsPALevels cdsPALevel = CdsPALevelsLocalServiceUtil
						.createCdsPALevels(null);
				cdsPALevel.setPaId(paId);
				cdsPALevel.setRootId(rootId);
				cdsPALevel.setUserId(userId);
				cdsPALevel.setPeriodId(periodId);

				cdsPALevel.setLevelId(LevelsList.get(i));
				CdsPALevels tmpCdsPALevel = CdsPALevelsLocalServiceUtil
						.addCdsPALevels(cdsPALevel);
			}
			int pointValue, maxPointValue;
			// add danh sach slot
			for (int i = 0; i < sizeOfSlotList; i++) {
				CdsPASlots cdsPASlot = createCdsPASlots(null);
				cdsPASlot.setPaId(paId);
				cdsPASlot.setRootId(rootId);
				cdsPASlot.setUserId(userId);
				cdsPASlot.setPeriodId(periodId);
				cdsPASlot.setRatingStatus(0);
				cdsPASlot.setRatingStatusPm(0);
				cdsPASlot.setRatingStatusBod(0);

				ViewFinalSlots finalSlot = SlotsList.get(i);

				cdsPASlot.setSlotId(finalSlot.getSlotId());
				cdsPASlot.setPointName(finalSlot.getPointName());

				pointValue = finalSlot.getPointValue();
				cdsPASlot.setPointValue(pointValue);
				// XET LAI MAXPOINT LAY TU CdsPoint ra
				cdsPASlot.setMaxPointName(pointMax.getPointName());

				maxPointValue = pointMax.getPointValue();
				cdsPASlot.setMaxPointValue(maxPointValue);

				float point = (float) ((maxPointValue * 1.0) / 2);

				if ((float) pointValue >= point)
					cdsPASlot.setIsPassed(true);
				else
					cdsPASlot.setIsPassed(false);
				CdsPASlots tmpCdsPASlot = addCdsPASlots(cdsPASlot);
			}
			return true;
		} catch (Exception e) {
			System.out
					.println("ERROR in CdsPASlotsLocalServiceImpl.addPASlots "
							+ e.toString());
			return false;
		}
	}

	// Dem so slot nhan vien da chon truoc khi danh gia
	public int countSlotPreEvaluate(int userId, int periodId)
			throws SystemException, PortalException {
		try {
			List<CdsPASlots> listByUserId = CdsPASlotsUtil.findByUserId(userId);
			List<CdsPASlots> listByPeriodId = CdsPASlotsUtil
					.findByPeriodId(periodId);
			List<CdsPASlots> listPASlots = ListUtils.intersection(listByUserId,
					listByPeriodId);
			return listPASlots.size();
		} catch (Exception e) {
			System.out
					.println("ERROR in CdsPASlotsLocalServiceImpl.countSlotPreEvaluate "
							+ e.toString());
			return 0;
		}

	}

	// Dem so slot nhan vien da danh gia
	public int countSlotEvaluateByUser(int userId, int periodId,
			int ratingStatus) throws SystemException, PortalException {
		try {
			List<CdsPASlots> listSlots = CdsPASlotsFinderUtil
					.getCdsPASlotsRatingByUser(userId, periodId, ratingStatus);
			if (listSlots == null)
				return 0;
			return listSlots.size();
		} catch (Exception e) {
			System.out
					.println("ERROR in CdsPASlotsLocalServiceImpl.countSlotEvaluateByUser "
							+ e.toString());
			return 0;
		}
	}

	// Update cds_performance_appraisal_slot khi import file
	public boolean updatePASlotsImport(int userId, int periodId)
			throws SystemException, PortalException {
		try {
			List<CdsPASlots> listPeriod = CdsPASlotsUtil
					.findByPeriodId(periodId);
			List<CdsPASlots> listUserId = CdsPASlotsUtil.findByUserId(userId);
			List<CdsPASlots> listSlots = ListUtils.intersection(listPeriod,
					listUserId);
			for (int i = 0; i < listSlots.size(); i++) {
				CdsPASlots pASlot = getCdsPASlots(listSlots.get(i)
						.getPrimaryKey());
				pASlot.setRatingStatusBod(1);
				CdsPASlots succeed = updateCdsPASlots(pASlot);
			}
			return true;
		} catch (Exception e) {
			System.out
					.println("ERROR in CdsPASlotsLocalServiceImpl.updatePASlotsImport "
							+ e.toString());
			return false;
		}
	}

	public boolean addPASlotsImport(int rootId, int userId, int periodId,
			List<Integer> CompetenciesList, List<Integer> LevelsList,
			List<ViewFinalSlots> SlotsList) throws SystemException,
			PortalException {
		try {
			CdsPerformanceAppraisals PA = CdsPerformanceAppraisalsLocalServiceUtil
					.getCdsPerformanceAppraisals(userId, periodId);
			// nhan vien moi vao sau khi dot CDS mo thi chua co trigger nen xay
			// ra loi
			// khi lay ra null thi k cho nhan vien do chon slot danh gia
			// trong dot do
			if (PA == null) {
				System.out
						.println("Dot CDS da duoc mo truoc khi nhan vien vao cong ty");
				System.out.println("Hay dong dot CDS va mo lai");
				return false;
			}
			int paId = PA.getPrimaryKey();
			// LAY RA POINTMAX ADD VAO PASLOT
			CdsPoints pointMax = CdsPointsLocalServiceUtil
					.getCdsPointMax(rootId);
			if (pointMax == null) {
				System.out.println("Cau hinh thang diem chua co diem");
				return false;
			}
			// CHUA BAT LOI KHI KHONG CO POINT

			int sizeOfCompetencyList = CompetenciesList.size();
			int sizeOfLevelList = LevelsList.size();
			int sizeOfSlotList = SlotsList.size();

			// XOA COMPETENCIES

			List<CdsPACompetencies> CompetencyListInDataBase = CdsPACompetenciesLocalServiceUtil
					.getCdsPACompetencies(userId, periodId);
			for (CdsPACompetencies competency : CompetencyListInDataBase) {
				CdsPACompetenciesLocalServiceUtil
						.deleteCdsPACompetencies(competency);
			}

			// XOA LEVELS
			List<CdsPALevels> LevelsListInDataBase = CdsPALevelsLocalServiceUtil
					.getCdsPALevelsList(userId, periodId);
			for (CdsPALevels level : LevelsListInDataBase) {
				CdsPALevelsLocalServiceUtil.deleteCdsPALevels(level);
			}

			// XOA SLOTS
			List<CdsPASlots> SlotsListInDataBase = CdsPASlotsLocalServiceUtil
					.getCdsPASlotsList(userId, periodId);
			for (CdsPASlots slot : SlotsListInDataBase) {
				CdsPASlotsLocalServiceUtil.deleteCdsPASlots(slot);
			}

			// XOA Final Slot
			List<CdsPAFinalSlots> finalSlotListRootId = CdsPAFinalSlotsUtil
					.findByRootId(rootId);
			List<CdsPAFinalSlots> finalSlotListUserId = CdsPAFinalSlotsUtil
					.findByUserId(userId);
			List<CdsPAFinalSlots> finalSlotListInDatabase = ListUtils
					.intersection(finalSlotListRootId, finalSlotListUserId);
			for (CdsPAFinalSlots finalSlot : finalSlotListInDatabase) {
				CdsPAFinalSlotsLocalServiceUtil
						.deleteCdsPAFinalSlots(finalSlot);
			}

			// XOA Final Level
			List<CdsPAFinalLevels> finalLevelListRootId = CdsPAFinalLevelsUtil
					.findByRootId(rootId);
			List<CdsPAFinalLevels> finalLevelListUserId = CdsPAFinalLevelsUtil
					.findByUserId(userId);
			List<CdsPAFinalLevels> finalLevelListInDatabase = ListUtils
					.intersection(finalLevelListRootId, finalLevelListUserId);
			for (CdsPAFinalLevels finalLevel : finalLevelListInDatabase) {
				CdsPAFinalLevelsLocalServiceUtil
						.deleteCdsPAFinalLevels(finalLevel);
			}

			// XOA Final Competency
			List<CdsPAFinalCompetenies> finalCompetencyListRootId = CdsPAFinalCompeteniesUtil
					.findByRootId(rootId);
			List<CdsPAFinalCompetenies> finalCompetencyListUserId = CdsPAFinalCompeteniesUtil
					.findByUserId(userId);
			List<CdsPAFinalCompetenies> finalCompetencyListInDatabase = ListUtils
					.intersection(finalCompetencyListRootId,
							finalCompetencyListUserId);
			for (CdsPAFinalCompetenies finalCompetency : finalCompetencyListInDatabase) {
				CdsPAFinalCompeteniesLocalServiceUtil
						.deleteCdsPAFinalCompetenies(finalCompetency);
			}

			// Xoa PAFinal
			List<CdsPAFinal> finalListRootId = CdsPAFinalUtil
					.findByRootId(rootId);
			List<CdsPAFinal> finalListUserId = CdsPAFinalUtil
					.findByUserId(userId);
			List<CdsPAFinal> FinalList = ListUtils.intersection(
					finalListRootId, finalListUserId);
			for (CdsPAFinal cdsPAFinal : FinalList) {
				CdsPAFinalLocalServiceUtil.deleteCdsPAFinal(cdsPAFinal);
			}
			// KET THUC XOA
			
			//Dong dot mo dot lai de cap nhat lai paId
			CdsEvaluationPeriodsLocalServiceUtil.updateCdsPeriodImport(periodId, 3);
			CdsEvaluationPeriodsLocalServiceUtil.updateCdsPeriodImport(periodId, 2);
			// add danh sach competency

			for (int i = 0; i < sizeOfCompetencyList; i++) {
				CdsPACompetencies cdsPACompetency = CdsPACompetenciesLocalServiceUtil
						.createCdsPACompetencies(null);
				cdsPACompetency.setPaId(paId);
				cdsPACompetency.setRootId(rootId);
				cdsPACompetency.setUserId(userId);
				cdsPACompetency.setPeriodId(periodId);

				cdsPACompetency.setCompetencyId(CompetenciesList.get(i));

				CdsPACompetencies tmpCdsPACompetency = CdsPACompetenciesLocalServiceUtil
						.addCdsPACompetencies(cdsPACompetency);
			}
			// add danh sach level

			for (int i = 0; i < sizeOfLevelList; i++) {
				CdsPALevels cdsPALevel = CdsPALevelsLocalServiceUtil
						.createCdsPALevels(null);
				cdsPALevel.setPaId(paId);
				cdsPALevel.setRootId(rootId);
				cdsPALevel.setUserId(userId);
				cdsPALevel.setPeriodId(periodId);

				cdsPALevel.setLevelId(LevelsList.get(i));
				CdsPALevels tmpCdsPALevel = CdsPALevelsLocalServiceUtil
						.addCdsPALevels(cdsPALevel);
			}
			int pointValue, maxPointValue;
			// add danh sach slot
			for (int i = 0; i < sizeOfSlotList; i++) {
				CdsPASlots cdsPASlot = createCdsPASlots(null);
				cdsPASlot.setPaId(paId);
				cdsPASlot.setRootId(rootId);
				cdsPASlot.setUserId(userId);
				cdsPASlot.setPeriodId(periodId);
				cdsPASlot.setRatingStatus(1);
				cdsPASlot.setRatingStatusPm(0);
				cdsPASlot.setRatingStatusBod(0);

				ViewFinalSlots finalSlot = SlotsList.get(i);

				cdsPASlot.setSlotId(finalSlot.getSlotId());
				cdsPASlot.setPointName(finalSlot.getPointName());

				pointValue = finalSlot.getPointValue();
				cdsPASlot.setPointValue(pointValue);
				// XET LAI MAXPOINT LAY TU CdsPoint ra
				cdsPASlot.setMaxPointName(pointMax.getPointName());

				maxPointValue = pointMax.getPointValue();
				cdsPASlot.setMaxPointValue(maxPointValue);

				float point = (float) ((maxPointValue * 1.0) / 2);

				if ((float) pointValue >= point)
					cdsPASlot.setIsPassed(true);
				else
					cdsPASlot.setIsPassed(false);
				CdsPASlots tmpCdsPASlot = addCdsPASlots(cdsPASlot);
			}
			return true;
		} catch (Exception e) {
			System.out
					.println("ERROR in CdsPASlotsLocalServiceImpl.addPASlots "
							+ e.toString());
			return false;
		}
	}
}