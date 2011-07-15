package larion.progate.cds.service.persistence;

import java.util.List;

import larion.progate.cds.model.CdsSlotStatisticalReport;
import larion.progate.cds.model.impl.CdsSlotStatisticalReportImpl;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class CdsSlotStatisticalReportFinderImpl extends BasePersistenceImpl
		implements CdsSlotStatisticalReportFinder {

	public static String GET_SlotsStatisticalReport = "SlotsStatisticalReport";

	public List<CdsSlotStatisticalReport> getCdsSlotStatisticalReport(
			int rootId, int userId, int periodId, int levelId)
			throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_SlotsStatisticalReport);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("CdsSlotStatisticalReport",
					CdsSlotStatisticalReportImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(periodId);
			qPos.add(userId);
			qPos.add(rootId);
			qPos.add(periodId);
			qPos.add(userId);
			qPos.add(rootId);
			qPos.add(userId);
			qPos.add(periodId);
			qPos.add(levelId);
			return (List) query.list();
		} catch (Exception e) {
			System.out
					.println("ERROR in CdsSlotStatisticalReportFinderImpl.getCdsSlotStatisticalReport() "
							+ e.toString());
			return null;
		}
	}
}