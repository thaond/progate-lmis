package larion.progate.cds.service.persistence;

import java.util.List;

import larion.progate.cds.model.CdsPerformanceAppraisalSlotRating;
import larion.progate.cds.model.impl.CdsPerformanceAppraisalSlotRatingImpl;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class CdsPerformanceAppraisalSlotRatingFinderImpl extends
		BasePersistenceImpl implements CdsPerformanceAppraisalSlotRatingFinder {

	public static String GET_LAST_RATING_NOT_APPROVED = "LastRatingNotApproved";
	public static String GET_SLOT_RATING_HISTORY = "SlotRatingHistory";

	public List<CdsPerformanceAppraisalSlotRating> getSlotRatingHistory(
			int rootId, int userId, int slotId) throws SystemException,
			PortalException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_SLOT_RATING_HISTORY);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("CdsPerformanceAppraisalSlotRating",
					CdsPerformanceAppraisalSlotRatingImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(rootId);
			qPos.add(userId);
			qPos.add(slotId);
			return (List) query.list();
		} catch (Exception e) {
			System.out
					.println("ERROR in CdsPerformanceAppraisalSlotRatingFinderImpl.getSlotRatingHistory "
							+ e.toString());
			return null;
		}
	}

	public List<CdsPerformanceAppraisalSlotRating> getLastRatingNotApproved(
			int periodId, int userId, int slotId, int userType)
			throws SystemException, PortalException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_LAST_RATING_NOT_APPROVED);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("CdsPerformanceAppraisalSlotRating",
					CdsPerformanceAppraisalSlotRatingImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(periodId);
			qPos.add(userId);
			qPos.add(slotId);
			qPos.add(userType);
			return (List) query.list();
		} catch (Exception e) {
			System.out
					.println("ERROR in CdsPerformanceAppraisalSlotRatingFinderImpl.getLastRatingNotApproved "
							+ e.toString());
			return null;
		}
	}
}