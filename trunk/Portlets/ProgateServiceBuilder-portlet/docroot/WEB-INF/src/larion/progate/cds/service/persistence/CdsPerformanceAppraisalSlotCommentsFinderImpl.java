package larion.progate.cds.service.persistence;

import java.util.List;

import larion.progate.cds.model.CdsPerformanceAppraisalSlotComments;
import larion.progate.cds.model.impl.CdsPerformanceAppraisalSlotCommentsImpl;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class CdsPerformanceAppraisalSlotCommentsFinderImpl extends
		BasePersistenceImpl implements
		CdsPerformanceAppraisalSlotCommentsFinder {
	public static String GET_PASLOTCOMMENTS = "PASlotComments";

	public List<CdsPerformanceAppraisalSlotComments> getCdsPASlotComments(
			int userId, int periodId, int slotId) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_PASLOTCOMMENTS);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("CdsPerformanceAppraisalSlotComments",
					CdsPerformanceAppraisalSlotCommentsImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(userId);
			qPos.add(periodId);
			qPos.add(slotId);
			return (List) query.list();
		} catch (Exception e) {
			System.out.println("ERROR in getCdsPASlotCommentsFinder "
					+ e.toString());
			return null;
		}
	}
}