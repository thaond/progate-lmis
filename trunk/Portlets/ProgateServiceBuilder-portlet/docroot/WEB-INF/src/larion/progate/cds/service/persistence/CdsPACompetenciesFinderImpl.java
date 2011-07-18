package larion.progate.cds.service.persistence;

import java.util.List;

import larion.progate.cds.model.CdsPACompetencies;
import larion.progate.cds.model.impl.CdsPACompetenciesImpl;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class CdsPACompetenciesFinderImpl extends BasePersistenceImpl implements
		CdsPACompetenciesFinder {
	public static String GET_PACOMPETENCIES = "PACompetencies";

	public List<CdsPACompetencies> getCdsPACompetencies(int userId, int periodId)
			throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_PACOMPETENCIES);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("CdsPACompetencies", CdsPACompetenciesImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(userId);
			qPos.add(periodId);
			List<CdsPACompetencies> listQ = (List) query.list();
			return (List) query.list();
		} catch (Exception e) {
			System.out.println("ERROR in getCdsPACompetenciesFinder "
					+ e.toString());
			return null;
		}
	}
}