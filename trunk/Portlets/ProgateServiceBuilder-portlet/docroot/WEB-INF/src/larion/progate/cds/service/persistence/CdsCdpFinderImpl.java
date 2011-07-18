package larion.progate.cds.service.persistence;

import java.util.List;

import larion.progate.cds.model.CdsCdp;
import larion.progate.cds.model.impl.CdsCdpImpl;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class CdsCdpFinderImpl extends BasePersistenceImpl implements
		CdsCdpFinder {
	public static String GET_CDP_INFO = "CdpInfo";

	public List<CdsCdp> getCdp(int rootId, int userId, int periodId)
			throws SystemException, PortalException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_CDP_INFO);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("CdsCdp", CdsCdpImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(rootId);
			qPos.add(userId);
			qPos.add(periodId);
			return (List) query.list();
		} catch (Exception e) {
			System.out.println("ERROR in CdsCdpFinderImpl.getCdp "
					+ e.toString());
			return null;
		}
	}
}