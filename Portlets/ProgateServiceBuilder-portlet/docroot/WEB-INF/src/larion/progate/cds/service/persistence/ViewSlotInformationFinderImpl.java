package larion.progate.cds.service.persistence;

import java.util.List;

import larion.progate.cds.model.ViewSlotInformation;
import larion.progate.cds.model.impl.ViewSlotInformationImpl;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class ViewSlotInformationFinderImpl extends BasePersistenceImpl
		implements ViewSlotInformationFinder {
	public static String Get_SlotInformation = "SlotInformation";

	public List<ViewSlotInformation> getViewSlotInformationListBySlotIdAndUserId(
			int slotId, int userId) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(Get_SlotInformation);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("ViewSlotInformation",
					ViewSlotInformationImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(slotId);
			qPos.add(userId);
			return (List) query.list();
		} catch (Exception e) {
			System.out
					.println("ERROR in ViewSlotInformationFinderImpl.getViewSlotInformationListBySlotIdAndUserId "
							+ e.toString());
			return null;
		}
	}
}