package larion.progate.cds.service.persistence;

import java.util.List;

import larion.progate.cds.model.ViewFinalLevels;
import larion.progate.cds.model.impl.ViewFinalLevelsImpl;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class ViewFinalLevelsFinderImpl extends BasePersistenceImpl implements
		ViewFinalLevelsFinder {
	public static String Get_FinalLevels = "FinalLevels";

	public List<ViewFinalLevels> getLevelsListByRootIdAndUserIdAndCompetencyId(
			int rootId, int userId, int competencyId) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(Get_FinalLevels);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("ViewFinalLevels", ViewFinalLevelsImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(rootId);
			qPos.add(userId);
			qPos.add(competencyId);
			return (List) query.list();
		} catch (Exception e) {
			System.out
					.println("ERROR in ViewFinalLevelsFinderImpl.getLevelsListByRootIdAndUserIdAndCompetencyId "
							+ e.toString());
			return null;
		}
	}
}
