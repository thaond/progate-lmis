package larion.progate.cds.service.persistence;

import java.util.List;

import larion.progate.cds.model.Slot;
import larion.progate.cds.model.impl.SlotImpl;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class SlotFinderImpl extends BasePersistenceImpl
		implements SlotFinder {

	public static String GET_EXISTED_SLOT = "ExistedSlot";

	public List<Slot> getExistedSlot(int rootId, String slotName, int levelId)
			throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_EXISTED_SLOT);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("Slot", SlotImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(rootId);
			qPos.add(slotName);
			qPos.add(levelId);
			return (List) query.list();
		} catch (Exception e) {
			System.out
					.println("ERROR in SlotFinderImpl.getExistedSlot "
							+ e.toString());
			return null;
		}
	}
}