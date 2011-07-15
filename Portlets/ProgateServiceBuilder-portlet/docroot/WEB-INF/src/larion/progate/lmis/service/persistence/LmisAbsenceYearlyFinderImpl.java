package larion.progate.lmis.service.persistence;

import java.util.List;

import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

public class LmisAbsenceYearlyFinderImpl extends BasePersistenceImpl implements LmisAbsenceYearlyFinder{
	

	/**
	 * @param rootid
	 * @param userId
	 * @param year
	 * @return Nghi tong ngay nghi thuong nien nam truoc 
	 * 
	 */
	public double getTotalDayAwardPrevYear(int rootid, int userId,int year) {
		Session s = null;
		try {
			s = openSession();
			String sql ="SELECT lmis_get_total_day_award_prev_year(" + rootid + "," +userId + "," +year +")";
			System.out.println("SQL content getTotalDayAwardPrevYear: "+sql);
			SQLQuery q = s.createSQLQuery(sql);
			List<Object> ls = q.list();
			double r=0.0;
			if(ls.size() >0){
				r = Double.parseDouble(ls.get(0).toString());
				System.out.println("Result getTotalDayAwardPrevYear:" +r);
				
			}
			return r;
		} catch (Exception e) {
			System.out.println("Error in LmisAbsenceYearlyFinderImpl.getTotalDayAwardPrevYear:"+toString());
			return 0.0;
		}
	}
	
	/**
	 * @param rootid
	 * @param userId
	 * @param year
	 * @return Nghi tong ngay nghi thuong nien nam nay 
	 * @throws Exception
	 */
	public double getTotalDayAward(int rootid, int userId,int year){
		Session s = null;
		try {
			s = openSession();
			String sql ="SELECT lmis_get_total_day_award(" + rootid + "," +userId + "," +year +")";
			System.out.println("SQL content getTotalDayAward: "+sql);
			SQLQuery q = s.createSQLQuery(sql);
			List<Object> ls = q.list();
			double r=0.0;
			if(ls.size() >0){
				r = Double.parseDouble(ls.get(0).toString());
				System.out.println("Result getTotalDayAwardPrevYear:" +r);
				
			}
			return r;
		} catch (Exception e) {
			System.out.println("Error in LmisAbsenceYearlyFinderImpl.getTotalDayAward:"+toString());
			return 0.0;
		}
	}
	/**
	 * @param rootid
	 * @param userId
	 * @param year
	 * @return Nghi tong ngay nghi bu trang ca trong thang 
	 * @throws Exception
	 */
	public double getTotalDayCompensation(int rootid, int userId,int year, int month) {
		Session s = null;
		try {
			s = openSession();
			String sql ="SELECT lmis_get_total_day_compensation(" + rootid + "," +userId + "," +year + "," + month +")";
			System.out.println("SQL content getTotalDayAward: "+sql);
			SQLQuery q = s.createSQLQuery(sql);
			List<Object> ls = q.list();
			double r=0.0;
			if(ls.size() >0){
				r = Double.parseDouble(ls.get(0).toString());
				System.out.println("Result getTotalDayAwardPrevYear:" +r);
				
			}
			return r;
		} catch (Exception e) {
			System.out.println("Error in LmisAbsenceYearlyFinderImpl.getTotalDayCompensation:"+toString());
			return 0.0;
		}
	}
}
