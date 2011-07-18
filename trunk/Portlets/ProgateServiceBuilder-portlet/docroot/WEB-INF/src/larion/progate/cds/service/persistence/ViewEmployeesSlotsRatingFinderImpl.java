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

public class ViewEmployeesSlotsRatingFinderImpl extends BasePersistenceImpl
		implements ViewEmployeesSlotsRatingFinder {

	public static String GET_EMPLOYEES_SLOTS_RATING = "EmployeesSlotsRating";

	public List<ViewPerformanceAppraisalSlots> getEmployeesSlotsRating(
			int periodId, int userId) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_EMPLOYEES_SLOTS_RATING);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("ViewPerformanceAppraisalSlots",
					ViewPerformanceAppraisalSlotsImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(periodId);
			qPos.add(userId);
			return (List) query.list();
		} catch (Exception e) {
			System.out
					.println("ERROR in ViewEmployeesSlotsRatingFinderImpl.getEmployeesSlotsRating "
							+ e.toString());
			return null;
		}
	}
}