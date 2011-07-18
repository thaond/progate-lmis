package larion.progate.cds.service.persistence;

import java.util.List;

import larion.progate.cds.model.CdsPASlots;
import larion.progate.cds.model.impl.CdsPASlotsImpl;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class CdsPASlotsFinderImpl extends BasePersistenceImpl implements
		CdsPASlotsFinder {
	public static String GET_CdsPerformanceAppraisalSlots = "CdsPerformanceAppraisalSlots";

	public List<CdsPASlots> getCdsPASlots(int userId, int periodId)
			throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_CdsPerformanceAppraisalSlots);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("CdsPASlots", CdsPASlotsImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(userId);
			qPos.add(periodId);
			return (List) query.list();
		} catch (Exception e) {
			System.out
					.println("ERROR in CdsPASlotsFinderImpl.getCdsPASlots "
							+ e.toString());
			return null;
		}
	}

	public static String GET_PA_SLOTS_RATING_BY_USER = "PASlotsRatingByUser";

	public List<CdsPASlots> getCdsPASlotsRatingByUser(int userId, int periodId,
			int ratingStatus) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_PA_SLOTS_RATING_BY_USER);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("CdsPASlots", CdsPASlotsImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(userId);
			qPos.add(periodId);
			qPos.add(ratingStatus);
			return (List) query.list();
		} catch (Exception e) {
			System.out
					.println("ERROR in CdsPASlotsFinderImpl.getCdsPASlotsRatingByUser "
							+ e.toString());
			return null;
		}
	}

	public static String GET_PA_SLOTS_RATING_BY_PM = "PASlotsRatingByPM";

	public List<CdsPASlots> getCdsPASlotRatingByPM(int periodId, int userId) 
			throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_PA_SLOTS_RATING_BY_PM);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("CdsPASlots", CdsPASlotsImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(periodId);
			qPos.add(userId);
			return (List) query.list();
		} catch (Exception e) {
			System.out
					.println("ERROR in CdsPASlotsFinderImpl.getCdsPASlotRatingByPM "
							+ e.toString());
			return null;
		}
	}

}