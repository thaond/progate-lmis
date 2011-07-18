package larion.progate.cds.service.persistence;

import java.util.Date;
import java.util.List;

import larion.progate.cds.model.CdsEvaluationPeriods;
import larion.progate.cds.model.impl.CdsEvaluationPeriodsImpl;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class CdsEvaluationPeriodsFinderImpl extends BasePersistenceImpl
		implements CdsEvaluationPeriodsFinder {
	public static String Get_ToDateOfPreviousPeriod = "ToDateOfPreviousPeriod";
	public static String Get_FromDateOfNextPeriod = "FromDateOfNextPeriod";

	public List<CdsEvaluationPeriods> GetToDateOfPreviousPeriod(int periodId)
			throws SystemException, PortalException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(Get_ToDateOfPreviousPeriod);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("CdsEvaluationPeriods",
					CdsEvaluationPeriodsImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(periodId);
			qPos.add(periodId);
			return (List) query.list();
		} catch (Exception e) {
			System.out
					.println("ERROR in CdsEvaluationPeriodsFinderImpl.GetToDateOfPreviousPeriod() "
							+ e.toString());
			return null;
		}
	}

	public List<CdsEvaluationPeriods> GetFromDateOfNextPeriod(int periodId) throws SystemException, PortalException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(Get_FromDateOfNextPeriod);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("CdsEvaluationPeriods",
					CdsEvaluationPeriodsImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(periodId);
			qPos.add(periodId);
			return (List) query.list();
		} catch (Exception e) {
			System.out
					.println("ERROR in CdsEvaluationPeriodsFinderImpl.GetFromDateOfNextPeriod() "
							+ e.toString());
			return null;
		}
	}
}