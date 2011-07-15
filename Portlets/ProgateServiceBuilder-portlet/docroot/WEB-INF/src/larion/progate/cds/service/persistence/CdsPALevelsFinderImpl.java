package larion.progate.cds.service.persistence;

import java.util.List;

import larion.progate.cds.model.CdsPALevels;
import larion.progate.cds.model.impl.CdsPALevelsImpl;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class CdsPALevelsFinderImpl extends BasePersistenceImpl implements
		CdsPALevelsFinder {
	public static String GET_CdsPerformanceAppraisalLevels = "CdsPerformanceAppraisalLevels";

	public List<CdsPALevels> getCdsPALevels(int userId, int periodId)
			throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_CdsPerformanceAppraisalLevels);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("CdsPALevels", CdsPALevelsImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(userId);
			qPos.add(periodId);
			return (List) query.list();
		} catch (Exception e) {
			System.out
					.println("ERROR in CdsPALevelsFinderImpl " + e.toString());
			return null;
		}
	}
}