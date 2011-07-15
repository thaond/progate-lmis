package larion.progate.cds.service.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.ListUtils;

import larion.progate.cds.model.CdsEvaluationPeriods;
import larion.progate.cds.model.CdsPerformanceAppraisals;
import larion.progate.cds.model.Competency;
import larion.progate.cds.model.Level;
import larion.progate.cds.model.Slot;
import larion.progate.cds.model.ViewFinalSlots;
import larion.progate.cds.service.CdsEvaluationPeriodsLocalServiceUtil;
import larion.progate.cds.service.CdsPASlotsLocalServiceUtil;
import larion.progate.cds.service.CdsPerformanceAppraisalsLocalServiceUtil;
import larion.progate.cds.service.CdsPointsLocalServiceUtil;
import larion.progate.cds.service.CompetencyLocalServiceUtil;
import larion.progate.cds.service.LevelLocalServiceUtil;
import larion.progate.cds.service.SlotLocalServiceUtil;
import larion.progate.cds.service.ViewFinalSlotsLocalServiceUtil;

import com.csvreader.CsvReader;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;

public class importFile {

	public boolean importData(int rootId, int userId, InputStream input)
			throws SystemException, PortalException {
		try {
			List<Integer> listCompetencies = new ArrayList<Integer>();
			List<Integer> listLevels = new ArrayList<Integer>();
			List<ViewFinalSlots> listSlots = new ArrayList<ViewFinalSlots>();
			int periodId = 0;
			// Kiem tra dot co fai la dot khoi tao chua
			int checkPeriod = CdsEvaluationPeriodsLocalServiceUtil
					.checkPeriod(rootId);
			if (checkPeriod == 0) {
				int checkAdd = CdsEvaluationPeriodsLocalServiceUtil
						.addCdsPeriodImport(rootId, userId);
				if (checkAdd == 0)
					return false;
				else
					periodId = checkAdd;
			} else
				periodId = checkPeriod;
			// Kiem tra dot khoi tao neu da duoc dong thi ko cho update nua
			CdsEvaluationPeriods checkStatus = CdsEvaluationPeriodsLocalServiceUtil
					.getCdsEvaluationPeriods(periodId);
			if (checkStatus.getStatus() == 3)
				// Update trang thai dong cho dot khoi tao
				CdsEvaluationPeriodsLocalServiceUtil.updateCdsPeriodImport(
						periodId, 2);
			
			Charset set = Charset.forName("ISO-8859-1");
			CsvReader reader = new CsvReader(input, set);
			reader.readHeaders();
			while (reader.readRecord()) {
				String competency = reader.get("Competency");
				String level = reader.get("Level");
				String slot = reader.get("Slot");
				String bodPoint = reader.get("BOD Evaluation");

				// Dua vao competency name lay ra competencyId, tu competencyId
				// do va level
				// name lay ra levelId, tu levelId va slot name lay ra slotId
				// cho vao list slot

				// Them competencyId vao list competency de khi chay ham
				// addPASlot se
				// add luon vao 3 bang PASlot, PALevel, PACompetency
				int flag = 0;
				List<Competency> listComp = CompetencyLocalServiceUtil
						.getCompetencyListByCompetencyName(rootId, competency);
				if (listComp.size() == 0)
					return false;
				for (int i = 0; i < listCompetencies.size(); i++) {
					if (listCompetencies.get(i).equals(
							listComp.get(0).getPrimaryKey())) {
						flag = 1;
						break;
					}
				}
				if (flag == 0)
					listCompetencies.add(listComp.get(0).getPrimaryKey());

				List<Level> listLvByComp = LevelLocalServiceUtil
						.getLevelListByCompetencyId(listComp.get(0)
								.getPrimaryKey());

				List<Level> listLvByName = LevelLocalServiceUtil
						.getLevelListByLevelName(level);

				List<Level> listLv = ListUtils.intersection(listLvByComp,
						listLvByName);
				if (listLv.size() == 0)
					return false;

				flag = 0;
				for (int i = 0; i < listLevels.size(); i++) {
					if (listLevels.get(i).equals(listLv.get(0).getPrimaryKey())) {
						flag = 1;
						break;
					}
				}
				if (flag == 0)
					listLevels.add(listLv.get(0).getPrimaryKey());
				List<Slot> listSltByLv = SlotLocalServiceUtil
						.getSlotListByLevelId(listLv.get(0).getPrimaryKey());

				List<Slot> listSltByName = SlotLocalServiceUtil
						.getSlotListBySlotName(slot);
				List<Slot> listSlt = ListUtils.intersection(listSltByLv,
						listSltByName);
				if (listSlt.size() == 0)
					return false;
				flag = 0;
				for (ViewFinalSlots slt : listSlots) {
					if (slt.getSlotId().equals(listSlt.get(0).getPrimaryKey())) {
						flag = 1;
						break;
					}
				}
				if (flag == 0) {
					ViewFinalSlots tmp = ViewFinalSlotsLocalServiceUtil
							.createViewFinalSlots(null);
					tmp.setSlotId(listSlt.get(0).getPrimaryKey());
					tmp.setPointName(bodPoint);
					tmp.setPointValue(CdsPointsLocalServiceUtil
							.getPointValueByPointName(bodPoint));
					listSlots.add(tmp);
				}
			}
			reader.close();
			// Goi ham add vao bang cds_performamce_appraisal_slots
			CdsPASlotsLocalServiceUtil.addPASlotsImport(rootId, userId, periodId,
					listCompetencies, listLevels, listSlots);
			// Goi ham update bang cds_performamce_appraisal_slots de chay trigger
			CdsPASlotsLocalServiceUtil.updatePASlotsImport(userId, periodId);
			//Set lai to_date trong dot khoi tao moi khi import
			// to_date + them 2 ngay de thay duoc nv trong bao cao thong ke
			//Dong dot
			CdsEvaluationPeriodsLocalServiceUtil.updateCdsPeriodImport(
					periodId, 3);
			return true;
		} catch (FileNotFoundException e) {
			System.out.println("File not found. ERROR in Utils.importFile "
					+ e.toString());
			return false;

		} catch (IOException e) {
			System.out.println("ERROR in IO Utils.importFile " + e.toString());
			return false;
		}
	}
}
