package larion.progate.cds.service.persistence;

import java.util.List;

import larion.progate.cds.model.ViewFinalCompetencies;
import larion.progate.cds.model.impl.ViewFinalCompetenciesImpl;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class ViewFinalCompetenciesFinderImpl extends BasePersistenceImpl
		implements ViewFinalCompetenciesFinder {
	public static String Get_AllFinalCompetencies = "AllFinalCompetencies";
	public static String Get_FinalCompetenciesByCompetencyId = "FinalCompetenciesByCompetencyId";

	public List<ViewFinalCompetencies> getCompetenciesListByRootIdAndUserId(
			int rootId, int userId) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(Get_AllFinalCompetencies);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("ViewFinalCompetencies",
					ViewFinalCompetenciesImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(rootId);
			qPos.add(userId);
			qPos.add(rootId);
			return (List) query.list();
		} catch (Exception e) {
			System.out
					.println("ERROR IN ViewFinalCompetenciesFinderImpl.getCompetenciesListByRootIdAndUserId "
							+ e.toString());
			return null;
		}
	}

	public List<ViewFinalCompetencies> getCompetenciesListByRootIdAndUserIdAndCompetencyId(
			int rootId, int userId, int competencyId) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(Get_FinalCompetenciesByCompetencyId);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("ViewFinalCompetencies",
					ViewFinalCompetenciesImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(rootId);
			qPos.add(userId);
			qPos.add(rootId);
			qPos.add(competencyId);
			return (List) query.list();
		} catch (Exception e) {
			System.out
					.println("ERROR IN ViewFinalCompetenciesFinderImpl.getCompetenciesListByRootIdAndUserIdAndCompetencyId "
							+ e.toString());
			return null;
		}
	}
}