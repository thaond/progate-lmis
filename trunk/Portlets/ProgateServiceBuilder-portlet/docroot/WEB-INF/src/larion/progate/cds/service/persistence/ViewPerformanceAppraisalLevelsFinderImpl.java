package larion.progate.cds.service.persistence;

import java.util.List;

import larion.progate.cds.model.ViewPerformanceAppraisalLevels;
import larion.progate.cds.model.impl.ViewPerformanceAppraisalLevelsImpl;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class ViewPerformanceAppraisalLevelsFinderImpl extends
		BasePersistenceImpl implements ViewPerformanceAppraisalLevelsFinder {
	public static String GET_PALEVELS = "PALevels";

	public List<ViewPerformanceAppraisalLevels> getCdsPALevels(int userId, int periodId, int competencyId) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_PALEVELS);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("ViewPerformanceAppraisalLevels",
					ViewPerformanceAppraisalLevelsImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(userId);
			qPos.add(periodId);
			qPos.add(competencyId);
			return (List) query.list();
		} catch (Exception e) {
			System.out.println("ERROR in ViewPerformanceAppraisalLevelsFinderImpl.getCdsPALevelsFinder " + e.toString());
			return null;
		}
	}
}