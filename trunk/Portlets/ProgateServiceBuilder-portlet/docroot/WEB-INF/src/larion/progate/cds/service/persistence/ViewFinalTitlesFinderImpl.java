package larion.progate.cds.service.persistence;

import java.util.List;

import larion.progate.cds.model.ViewFinalTitles;
import larion.progate.cds.model.impl.ViewFinalTitlesImpl;

import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.liferay.portal.SystemException;

public class ViewFinalTitlesFinderImpl extends BasePersistenceImpl implements
		ViewFinalTitlesFinder {
	public static String Get_FinalTitleList = "FinalTitleList";

	public List<ViewFinalTitles> getFinalTitleListByRootIdAndUserId(int rootId,
			int userId) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(Get_FinalTitleList);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("ViewFinalTitles", ViewFinalTitlesImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(rootId);
			qPos.add(userId);
			return (List) query.list();
		} catch (Exception e) {
			System.out
					.println("ERROR in ViewFinalTitlesFinderImpl.getFinalTitleListByRootIdAndUserId "
							+ e.toString());
			return null;
		}
	}
}