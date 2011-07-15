package larion.progate.cds.service.persistence;

import java.util.List;

import larion.progate.cds.model.CdsCompetencyStatisticalReport;
import larion.progate.cds.model.impl.CdsCompetencyStatisticalReportImpl;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class CdsCompetencyStatisticalReportFinderImpl extends
		BasePersistenceImpl implements CdsCompetencyStatisticalReportFinder {
	public static String GET_CompetencyStatisticalReport = "CompetencyStatisticalReport";
	public static String GET_ReportBasedOnCometencyId = "ReportBasedOnCometencyId";

	public List<CdsCompetencyStatisticalReport> getCdsCompetencyStatisticalReport(
			int rootId, int userId, int periodId) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_CompetencyStatisticalReport);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("CdsCompetencyStatisticalReport",
					CdsCompetencyStatisticalReportImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(periodId);
			qPos.add(userId);
			qPos.add(rootId);
			qPos.add(periodId);
			qPos.add(userId);
			qPos.add(rootId);
			qPos.add(rootId);
			return (List) query.list();
		} catch (Exception e) {
			System.out
					.println("ERROR in CdsCompetencyStatisticalReportFinderImpl.getCdsCompetencyStatisticalReport() "
							+ e.toString());
			return null;
		}
	}

	public List<CdsCompetencyStatisticalReport> getCdsCompetencyStatisticalReportByCompetencyId(
			int rootId, int userId, int periodId, int competencyId)
			throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_ReportBasedOnCometencyId);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("CdsCompetencyStatisticalReport",
					CdsCompetencyStatisticalReportImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(periodId);
			qPos.add(userId);
			qPos.add(rootId);
			qPos.add(periodId);
			qPos.add(userId);
			qPos.add(rootId);
			qPos.add(rootId);
			qPos.add(competencyId);
			return (List) query.list();
		} catch (Exception e) {
			System.out
					.println("ERROR in CdsCompetencyStatisticalReportFinderImpl.getCdsCompetencyStatisticalReportByCompetencyId() "
							+ e.toString());
			return null;
		}
	}
}