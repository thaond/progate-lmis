package larion.progate.cds.service.persistence;

import java.util.List;

import larion.progate.cds.model.CdsLevelStatisticalReport;
import larion.progate.cds.model.impl.CdsLevelStatisticalReportImpl;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class CdsLevelStatisticalReportFinderImpl extends BasePersistenceImpl
		implements CdsLevelStatisticalReportFinder {
	public static String GET_LevelStatisticalReport = "LevelStatisticalReport";

	public List<CdsLevelStatisticalReport> getCdsLevelStatisticalReport(
			int rootId, int userId, int periodId, int competencyId)
			throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_LevelStatisticalReport);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("CdsLevelStatisticalReport",
					CdsLevelStatisticalReportImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(periodId);
			qPos.add(userId);
			qPos.add(rootId);
			qPos.add(periodId);
			qPos.add(userId);
			qPos.add(rootId);
			qPos.add(competencyId);
			return (List) query.list();
		} catch (Exception e) {
			System.out
					.println("ERROR in CdsLevelStatisticalReportFinderImpl.getCdsLevelStatisticalReport() "
							+ e.toString());
			return null;
		}
	}
}