package larion.progate.cds.service.persistence;

import java.util.List;

import larion.progate.cds.model.ViewFinalSlots;
import larion.progate.cds.model.impl.ViewFinalSlotsImpl;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class ViewFinalSlotsFinderImpl extends BasePersistenceImpl implements
		ViewFinalSlotsFinder {
	//Xem ket qua
	public static String Get_AllFinalSlots = "AllFinalSlots";
	public static String Get_FinalSlotsPass = "FinalSlotsPass";
	public static String Get_FinalSlotsFail = "FinalSlotsFail";
	public static String Get_FinalSlotsNotStart = "FinalSlotsNotStart";
	//Danh gia slot
	public static String Get_AllFinalSlotsNotInPASlot = "AllFinalSlotsNotInPASlot";
	public static String Get_FinalSlotsPassNotInPASlot = "FinalSlotsPassNotInPASlot";
	public static String Get_FinalSlotsFailNotInPASlot = "FinalSlotsFailNotInPASlot";
	public static String Get_FinalSlotsNotStartNotInPASlot = "FinalSlotsNotStartNotInPASlot";
	
	//Xem ket qua
	// lay ra tat ca slot
	public List<ViewFinalSlots> getAllSlotsList(
			int rootId, int userId, int levelId) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(Get_AllFinalSlots);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("ViewFinalSlots", ViewFinalSlotsImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(rootId);
			qPos.add(userId);
			qPos.add(levelId);
			return (List) query.list();
		} catch (Exception e) {
			System.out.println("ERROR in ViewFinalSlotsFinderImpl.getAllSlotsList " + e.toString());
			return null;
		}
	}

	// lay ra nhung slot dat
	public List<ViewFinalSlots> getSlotsPassList(
			int rootId, int userId, int levelId) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(Get_FinalSlotsPass);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("ViewFinalSlots", ViewFinalSlotsImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(rootId);
			qPos.add(userId);
			qPos.add(levelId);
			return (List) query.list();
		} catch (Exception e) {
			System.out.println("ERROR in ViewFinalSlotsFinderImpl.getSlotsPassList " + e.toString());
			return null;
		}
	}
	
	//lay ra nhung slot k dat
	public List<ViewFinalSlots> getSlotsFailList(
			int rootId, int userId, int levelId) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(Get_FinalSlotsFail);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("ViewFinalSlots", ViewFinalSlotsImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(rootId);
			qPos.add(userId);
			qPos.add(levelId);
			return (List) query.list();
		} catch (Exception e) {
			System.out.println("ERROR in ViewFinalSlotsFinderImpl.getSlotsFailList " + e.toString());
			return null;
		}
	}
	
	//lay ra nhung slot chua danh gia
	public List<ViewFinalSlots> getSlotsNotStartList(
			int rootId, int userId, int levelId) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(Get_FinalSlotsNotStart);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("ViewFinalSlots", ViewFinalSlotsImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(rootId);
			qPos.add(userId);
			qPos.add(levelId);
			qPos.add(rootId);
			qPos.add(userId);
			return (List) query.list();
		} catch (Exception e) {
			System.out.println("ERROR in ViewFinalSlotsFinderImpl.getSlotsNotStartList " + e.toString());
			return null;
		}
	}
	
	//Danh gia slot
	// lay ra tat ca slot
	public List<ViewFinalSlots> getAllSlotsListNotInPASlot(
			int rootId, int userId, int periodId) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(Get_AllFinalSlotsNotInPASlot);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("ViewFinalSlots", ViewFinalSlotsImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(rootId);
			qPos.add(userId);
			qPos.add(rootId);
			qPos.add(rootId);
			qPos.add(userId);
			qPos.add(periodId);
			return (List) query.list();
		} catch (Exception e) {
			System.out.println("ERROR in ViewFinalSlotsFinderImpl.getAllSlotsListNotInPASlot " + e.toString());
			return null;
		}
	}
	
	// lay ra nhung slot dat
	public List<ViewFinalSlots> getSlotsPassListNotInPASlot(
			int rootId, int userId, int periodId) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(Get_FinalSlotsPassNotInPASlot);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("ViewFinalSlots", ViewFinalSlotsImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(rootId);
			qPos.add(userId);
			qPos.add(rootId);
			qPos.add(rootId);
			qPos.add(userId);
			qPos.add(periodId);
			return (List) query.list();
		} catch (Exception e) {
			System.out.println("ERROR in ViewFinalSlotsFinderImpl.getSlotsPassListNotInPASlot " + e.toString());
			return null;
		}
	}
	
	//lay ra nhung slot k dat
	public List<ViewFinalSlots> getSlotsFailListNotInPASlot(
			int rootId, int userId, int periodId) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(Get_FinalSlotsFailNotInPASlot);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("ViewFinalSlots", ViewFinalSlotsImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(rootId);
			qPos.add(userId);
			qPos.add(rootId);
			qPos.add(rootId);
			qPos.add(userId);
			qPos.add(periodId);
			return (List) query.list();
		} catch (Exception e) {
			System.out.println("ERROR in ViewFinalSlotsFinderImpl.getSlotsFailListNotInPASlot " + e.toString());
			return null;
		}
	}
	
	//lay ra nhung slot chua danh gia
	public List<ViewFinalSlots> getSlotsNotStartListNotInPASlot(
			int rootId, int userId, int periodId) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(Get_FinalSlotsNotStartNotInPASlot);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("ViewFinalSlots", ViewFinalSlotsImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(rootId);
			qPos.add(userId);
			qPos.add(rootId);
			qPos.add(rootId);
			qPos.add(userId);
			qPos.add(rootId);
			qPos.add(userId);
			qPos.add(periodId);
			return (List) query.list();
		} catch (Exception e) {
			System.out.println("ERROR in ViewFinalSlotsFinderImpl.getSlotsNotStartListNotInPASlot " + e.toString());
			return null;
		}
	}
}