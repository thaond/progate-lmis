package larion.progate.cds.service.persistence;

import java.util.List;

import larion.progate.cds.model.CdsPerformanceAppraisals;
import larion.progate.cds.model.impl.CdsPerformanceAppraisalsImpl;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class CdsPerformanceAppraisalsFinderImpl extends BasePersistenceImpl
		implements CdsPerformanceAppraisalsFinder {
	public static String GET_CdsPerformanceAppraisals = "CdsPerformanceAppraisals";

	public List<CdsPerformanceAppraisals> getCdsPerformanceAppraisals(
			int userId, int periodId) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_CdsPerformanceAppraisals);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("CdsPerformanceAppraisals",
					CdsPerformanceAppraisalsImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(userId);
			qPos.add(periodId);
			return (List) query.list();
		} catch (Exception e) {
			System.out.println("ERROR in CdsPerformanceAppraisalsFinderImpl "
					+ e.toString());
			return null;
		}
	}
}