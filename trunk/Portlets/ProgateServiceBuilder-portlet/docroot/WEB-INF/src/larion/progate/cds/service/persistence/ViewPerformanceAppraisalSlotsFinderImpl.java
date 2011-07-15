package larion.progate.cds.service.persistence;

import java.util.List;

import larion.progate.cds.model.ViewPerformanceAppraisalSlots;
import larion.progate.cds.model.impl.ViewPerformanceAppraisalSlotsImpl;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class ViewPerformanceAppraisalSlotsFinderImpl extends
		BasePersistenceImpl implements ViewPerformanceAppraisalSlotsFinder {
	public static String GET_PASLOTS = "PASlots";

	public List<ViewPerformanceAppraisalSlots> getCdsPASlots(int userId,
			int periodId, int levelId) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_PASLOTS);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("ViewPerformanceAppraisalSlots",
					ViewPerformanceAppraisalSlotsImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(userId);
			qPos.add(periodId);
			qPos.add(levelId);
			return (List) query.list();
		} catch (Exception e) {
			System.out.println("ERROR in getCdsPASlotsFinder " + e.toString());
			return null;
		}
	}

	public static String GET_PASLOTDETAILS = "PASlotDetails";

	public List<ViewPerformanceAppraisalSlots> getCdsPASlotDetails(int userId,
			int periodId, int slotId) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_PASLOTDETAILS);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("ViewPerformanceAppraisalSlots",
					ViewPerformanceAppraisalSlotsImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(userId);
			qPos.add(periodId);
			qPos.add(slotId);
			return (List) query.list();
		} catch (Exception e) {
			System.out.println("ERROR in getCdsPASlotDetailsFinder "
					+ e.toString());
			return null;
		}
	}
}