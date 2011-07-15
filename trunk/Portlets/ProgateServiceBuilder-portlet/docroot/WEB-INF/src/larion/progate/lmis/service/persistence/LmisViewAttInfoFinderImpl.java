package larion.progate.lmis.service.persistence;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import larion.progate.lmis.model.LmisViewAttInfo;
import larion.progate.lmis.model.LmisViewAttdance;
import larion.progate.lmis.model.impl.LmisViewAttInfoImpl;
import larion.progate.lmis.model.impl.LmisViewAttdanceImpl;


public class LmisViewAttInfoFinderImpl extends BasePersistenceImpl implements
LmisViewAttInfoFinder {
	

	public List<LmisViewAttInfo> getListAttManageByPM(int rootId, int pmId,
			Date dayValue, String name) throws SystemException {
		Session session = null;
		try {
			DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
			String dateStr = df.format(dayValue);
			session = openSession();
			StringBuilder sql = new StringBuilder();

			if (name == null) {
				sql.append("select a.*, b.* "
						+ " from (select distinct staff_uid, root_id, staff_code "
						+ "from vw_staff_mapping "
						+ "where root_id = "
						+ rootId
						+ " AND pm_uid = "
						+ pmId
						+ ") a "
						+ "left join vw_attendance b ON (b.root_id = a.root_id) AND (b.user_id = a.staff_uid) "
						+ "where b.day_value = '" + dateStr + "'");
				  sql.append(" order by absence desc, full_name asc ");
			}
			else{
				sql.append("select a.*, b.* "
						+ " from (select distinct staff_uid, root_id, staff_code "
						+ "from vw_staff_mapping "
						+ "where root_id = "
						+ rootId
						+ " AND pm_uid = "
						+ pmId
						+ ") a "
						+ "left join vw_attendance b ON (b.root_id = a.root_id) AND (b.user_id = a.staff_uid) "
						+ "where b.day_value = '" + dateStr + "'");
				sql.append(" AND full_name like  '%"+name+"%'" );
				  sql.append(" order by absence desc, full_name asc ");
			}

			System.out
					.println("SQL content LmisViewAttInfoFinderImpl.getListAttManageByPM: "
							+ sql.toString());
			SQLQuery q = session.createSQLQuery(sql.toString());
			q.addEntity("LmisViewAttInfo", LmisViewAttInfoImpl.class);
			return q.list();

		} catch (Exception e) {
			System.out
					.println("Error in LmisViewAttInfoFinderImpl.getListAttManageByPM: "
							+ e.toString());
			return new ArrayList<LmisViewAttInfo>();
		}
	}
	
	public List<LmisViewAttInfo> getListAttManageByBOD(int rootId, int bodId,
			Date dayValue, String name) throws SystemException {
		Session session = null;
		try {
			DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
			String dateStr = df.format(dayValue);
			session = openSession();
			StringBuilder sql = new StringBuilder();

			if (name == null) {
				sql.append("select a.*, b.* "
						+ " from (select distinct staff_uid, root_id, staff_code "
						+ "from vw_staff_mapping "
						+ "where root_id = "
						+ rootId
						+ " AND bod_uid = "
						+ bodId
						+ ") a "
						+ "left join vw_attendance b ON (b.root_id = a.root_id) AND (b.user_id = a.staff_uid) "
						+ "where b.day_value = '" + dateStr + "'");
				  sql.append(" order by absence desc, full_name asc ");
			} else {
				sql.append("select a.*, b.* "
						+ " from (select distinct staff_uid, root_id, staff_code "
						+ "from vw_staff_mapping "
						+ "where root_id = "
						+ rootId
						+ " AND bod_uid = "
						+ bodId
						+ ") a "
						+ "left join vw_attendance b ON (b.root_id = a.root_id) AND (b.user_id = a.staff_uid) "
						+ "where b.day_value = '" + dateStr + "'");
				sql.append(" AND full_name like  '%" + name + "%'");
				 sql.append(" order by absence desc, full_name asc ");
			}
			System.out
					.println("SQL content LmisViewAttInfoFinderImpl.getListAttManageByBOD: "
							+ sql.toString());
			SQLQuery q = session.createSQLQuery(sql.toString());
			q.addEntity("LmisViewAttInfo", LmisViewAttInfoImpl.class);
			return q.list();

		} catch (Exception e) {
			System.out
					.println("Error in LmisViewAttInfoFinderImpl.getListAttManageByBOD: "
							+ e.toString());
			return new ArrayList<LmisViewAttInfo>();
		}
	}
	

	


}