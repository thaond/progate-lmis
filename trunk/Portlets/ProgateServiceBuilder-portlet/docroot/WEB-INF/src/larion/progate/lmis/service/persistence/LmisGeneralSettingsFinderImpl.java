package larion.progate.lmis.service.persistence;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.ObjectUtils;

import larion.progate.lmis.model.LmisGeneralSettings;
import larion.progate.lmis.model.LmisWorkingCalendars;
import larion.progate.lmis.model.impl.LmisGeneralSettingsImpl;
import larion.progate.lmis.service.utils.LmisConst;
import larion.progate.lmis.service.utils.LmisUtils;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.util.DateFormats;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

public class LmisGeneralSettingsFinderImpl extends BasePersistenceImpl
		implements LmisGeneralSettingsFinder {

	public String caculateTotalDayOffHavePermission(int userid, int month,
			int year, int rootid) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			System.out.println("open sesion");
			String sql = "select lmis_caculate_total_dayoff_have_permission("
					+ userid + "," + month + "," + year + "," + rootid + ")";
			SQLQuery query = session.createSQLQuery(sql);
			System.out.println(query.list().get(0));
			return query.list().get(0).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public String caculateTotalDayOffDontHavePermission(int userid, int month,
			int year, int rootid) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			System.out.println("open sesion");
			String sql = "select lmis_caculate_total_dayoff_dont_have_permission("
					+ userid + "," + month + "," + year + "," + rootid + ")";
			SQLQuery query = session.createSQLQuery(sql);
			System.out.println(query.list().get(0));
			return query.list().get(0).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public String caculateTimeRemainTimeChangeRequest(int userid, int rootid)
			throws SystemException {
		Session session = null;
		try {
			session = openSession();
			System.out.println("open sesion");
			String sql = "select lmis_caculate_time_remain_time_change_request("
					+ userid + "," + rootid + ")";
			System.out.println("SQL content:caculateTimeRemainTimeChangeRequest: "+sql);
			SQLQuery query = session.createSQLQuery(sql);
			System.out.println(query.list().get(0));
			return query.list().get(0).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public Date getBlock(int rootId, int userId, String dayStr,
			int sessionType, int blockType) {
		Session session = null;
		try {
			session = openSession();
			String sql = "select lmis_get_block_down(" + rootId + "," + userId
					+ ",text('" + dayStr + "')," + sessionType + ","
					+ blockType + ")";
			System.out.println("Query: " + sql);
			SQLQuery q = session.createSQLQuery(sql);
			List<Object> ls = q.list();
			System.out.println("List: " + ls);
			if (ls.size() > 0) {
				return LmisUtils.convertStrtoDate(ls.get(0).toString(),
						"HH:mm:ss");
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Integer> getListBodUIDofUID(int rootId, int userId) {
		Session session = null;
		try {
			session = openSession();
			String sql = "select bod_uid from vw_staff_mapping WHERE root_id ="
					+ rootId + " AND staff_uid=" + userId;
			System.out.println("Sql content:" + sql);
			SQLQuery q = session.createSQLQuery(sql);
			List<Integer> lsInt = new ArrayList<Integer>();

			List<Object> ls = q.list();
			System.out.println("ls content:getListBodUIDofUID" + ls);
			Set<Integer> s = new HashSet<Integer>();
			if (ls.size() > 0) {
				for (Object i : ls) {
					Integer tmp = Integer.parseInt(i.toString());
					if (s.add(tmp)) {
						lsInt.add(tmp);
					}

				}
			}
			return lsInt;
		} catch (Exception e) {
			System.out
					.println("Error in LmisGeneralSetting.getListBodUIDofUID");
			return new ArrayList<Integer>();
		}

	}

	public String getMaxTimeChangeReqEndDate(int rootId, int userId)
			throws Exception {
		Session s = null;
		try {
			s = openSession();
			String sql = "SELECT MAX(end_date) FROM lmis_timechange_requests WHERE "
					+ " root_id=" + rootId + " AND requested_by=" + userId + " AND end_date > current_date AND requested_status =2;";
			System.out.println("SQL content:" + sql);
			SQLQuery q = s.createSQLQuery(sql);
			List ls = q.list();
			if (ls.size() > 0) {
				return ls.get(0).toString();
			}
			return null;
		} catch (Exception e) {
			System.out
					.println("Error in LmisGeneralSettingsFinderImpl.getMaxTimeChangeReqEndDate");
			return null;
		}
	}
	
	public  String updateRoleUser(int orgId,int userId,int oldRole,int newRole) throws SystemException { 
        Session session = null; 
        try { 
        	
            session = openSession(); 
            System.out.println("open sesion");	      
            String sql = "select lmis_update_role_user("+orgId+","+userId+","+oldRole+","+newRole+"  )";
            System.out.println("sql:  "+ sql);
            SQLQuery query = session.createSQLQuery(sql); 	      
            System.out.println(query.toString());         
            return query.list().get(0).toString();                      
        } catch (Exception e) { 
        	System.out
			.println("Error in LmisGeneralSettingsFinderImpl.updateRoleUser");

        } 
        return null; 
    }

	public int caculateDayWillOff(int rootId, Date startDate, Date endDate, int startSession, int endSession){
		Session s = null;
		try {
			System.out.println("Test: caculateDayWillOff");
			s = openSession();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			df.format(startDate);
			df.format(endDate);
			System.out.println("SQL content test caculateDayWillOff: ");
			String sql = "select lmis_caculate_date_will_off(" + rootId + ",date('" + startDate + "'),date('" + endDate + "')," + startSession + "," + endSession+ ")";
			System.out.println("SQL content: "+sql);
			SQLQuery q = s.createSQLQuery(sql);
			List<Object> ls = q.list();
			int r = 0;
			if(ls.size() > 0){
				r = Integer.parseInt(ls.get(0).toString());
				System.out.println("caculateDayWillOff: "+r);
				
			}
			return r;
		} catch (Exception e) {
			System.out.println("Error in LmisGeneralSettingsFinderImpl.caculateDayWillOff:" +e.toString());
			return 0;
		}
	}
	public double getTotalWorkingTimeOfUID(int rootId, int userId, int month, int year){
		Session s= null;
		
		try {
			s= openSession();
			String sql = "SELECT total_working_time FROM lmis_attendance_monthly WHERE user_id="+userId +" AND root_id="+rootId +" AND month_value="+month +" AND year_value="+year +";";
			System.out.println("SQL content:"+sql);
			SQLQuery q =s.createSQLQuery(sql);
			List<Object> ls = q.list();
			double r =0;
			if(ls.size() >0){
				r = Double.parseDouble(ls.get(0).toString());
			}
			return r;
		} catch (Exception e) {
			System.out.println("Error in LmisGeneralSettingsFinderImpl.getTotalWorkingTimeOfUID:" +e.toString());
			return 0;
		}
	}
	public double getTypeAbsenceInMonthlyDetail(int rootId, int userId,int mon, int year, int absenceId, int type ){
		Session s = null;
		try {
			s = openSession();
			String sql = "SELECT lmis_get_absence_monthly_detail_type(" +rootId + "," +userId + "," + absenceId + "," +mon + "," + year + "," + type + ");";
			System.out.println("SQL content:" +sql);
			SQLQuery q = s.createSQLQuery(sql);
			List<Object> ls = q.list();
			double r =0;
			if(ls.size() > 0 ){
				r = Double.parseDouble(ls.get(0).toString());
			}
			return r;
		} catch (Exception e) {
			System.out.println("Error in LmisGeneralSettingsFinderImpl.getTypeAbsenceInMonthlyDetail"+e.toString());
			return 0;
		}
	}
	public double getTypeAbsenceInYearDetail(int rootId, int userId,int year, int absenceId, int type ){
		Session s = null;
		try {
			s = openSession();
			String sql = "SELECT lmis_get_absence_year_detail_type(" +rootId + "," +userId + "," + absenceId + "," + year + "," + type + ");";
			System.out.println("SQL content getTypeAbsenceInYearDetail:" +sql);
			SQLQuery q = s.createSQLQuery(sql);
			List<Object> ls = q.list();
			double r =0;
			if(ls.size() > 0 ){
				r = Double.parseDouble(ls.get(0).toString());
			}
			return r;
		} catch (Exception e) {
			System.out.println("Error in LmisGeneralSettingsFinderImpl.getTypeAbsenceInYearDetail"+e.toString());
			return 0;
		}
	}
	public double getTotalDayOffOfUID(int rootId, int userId, int month,int year){
		Session s = null;
		try {
			s = openSession();
			String sql = "SELECT lmis_get_total_dayoff_of_userid(" +rootId + "," +userId+ "," +month+"," +year+");";
			System.out.println("SQL content getTotalDayOffOfUID: "+sql);
			SQLQuery q=  s.createSQLQuery(sql);
			List<Object> ls = q.list();
			double r=0;
			if(ls.size() >0 ){
				r = Double.parseDouble(ls.get(0).toString());
			}
			return r;
		} catch (Exception e) {
			System.out.println("Error LmisGeneralSettingsFinderImpl.getTotalDayOffOfUID:"+e.toString());
			return 0;
		}
	}
	
	public double getTotalTimeFinalRewardOfUID(int rootId, int userId, int month,int year){
		Session s = null;
		try {
			s = openSession();
			String sql = "SELECT lmis_get_total_time_final_reward(" +rootId + "," +userId+ "," +month+"," +year+");";
			System.out.println("SQL content getTotalDayOffOfUID: "+sql);
			SQLQuery q=  s.createSQLQuery(sql);
			List<Object> ls = q.list();
			double r=0;
			if(ls.size() >0 ){
				r = Double.parseDouble(ls.get(0).toString());
			}
			return r;
		} catch (Exception e) {
			System.out.println("Error LmisGeneralSettingsFinderImpl.getTotalTimeFinalRewardOfUID:"+e.toString());
			return 0;
		}
	}
	/**
	 * @param rootId
	 * @param userId
	 * @param month
	 * @param year
	 * @param otId
	 * @param isEff
	 * @return total_hour or total_hour_final in lmis_overtime_monthly
	 */
	public double getTotalHourOverTimeOfStaffInMonth(int rootId, int userId, int month,int year, int otId,boolean isEff){
		Session s = null;
		try {
			s = openSession();
			String sql = "SELECT lmis_get_info_overtime_of_user_by_month(" +rootId + "," +userId+ "," +month+"," +year+","+otId+ ","+ isEff+ ");";
			System.out.println("SQL content getTotalHourOverTimeOfStaffInMonth: "+sql);
			SQLQuery q=  s.createSQLQuery(sql);
			List<Object> ls = q.list();
			double r=0;
			if(ls.size() >0 ){
				r = Double.parseDouble(ls.get(0).toString());
			}
			return r;
		} catch (Exception e) {
			System.out.println("Error LmisGeneralSettingsFinderImpl.getTotalHourOverTimeOfStaffInMonth:"+e.toString());
			return 0;
		}
	}
	
	/* (non-Javadoc)
	 * @see larion.progate.lmis.service.persistence.LmisGeneralSettingsFinder#getOverTimeHourFinalOfStaffInMonth(int, int, int, int)
	 */
	public double getOverTimeHourFinalOfStaffInMonth(int rootId, int userId, int month,int year){
		Session s = null;
		try {
			s = openSession();
			String sql = "SELECT lmis_get_info_overtime_final_of_user_by_month(" +rootId + "," +userId+ "," +month+"," +year+");";
			System.out.println("SQL content getOverTimeHourFinalOfStaffInMonth: "+sql);
			SQLQuery q=  s.createSQLQuery(sql);
			List<Object> ls = q.list();
			double r=0;
			if(ls.size() >0 ){
				r = Double.parseDouble(ls.get(0).toString());
			}
			return r;
		} catch (Exception e) {
			System.out.println("Error LmisGeneralSettingsFinderImpl.getOverTimeHourFinalOfStaffInMonth:"+e.toString());
			return 0;
		}
	}
	public double getTotalDayAbsenceCompensasion(int rootId, int userId, int month,int year,int type){
		Session s = null;
		try {
			s = openSession();
			String sql = "SELECT lmis_get_day_compensasion_overtime_of_staff_by_month(" +rootId + "," +userId+ "," +month+"," +year+","+type +");";
			System.out.println("SQL content getTotalDayAbsenceCompensasion: "+sql);
			SQLQuery q=  s.createSQLQuery(sql);
			List<Object> ls = q.list();
			double r=0;
			if(ls.size() >0 ){
				r = Double.parseDouble(ls.get(0).toString());
			}
			return r;
		} catch (Exception e) {
			System.out.println("Error LmisGeneralSettingsFinderImpl.getTotalDayAbsenceCompensasion:"+e.toString());
			return 0;
		}
	}
	public double getDayCompensationNextMonthOfStaffInMonth(int rootId, int userId, int month,int year){
		Session s = null;
		try {
			s = openSession();
			String sql = "SELECT lmis_get_total_day_compensation_next_month(" +rootId + "," +userId+ "," +month+"," +year+");";
			System.out.println("SQL content getDayCompensationNextMonthOfStaffInMonth: "+sql);
			SQLQuery q=  s.createSQLQuery(sql);
			List<Object> ls = q.list();
			double r=0;
			if(ls.size() >0 ){
				r = Double.parseDouble(ls.get(0).toString());
			}
			return r;
		} catch (Exception e) {
			System.out.println("Error LmisGeneralSettingsFinderImpl.getDayCompensationNextMonthOfStaffInMonth:"+e.toString());
			return 0;
		}
	}
	public double getTotalHourOverTimeReward(int rootId, int userId, int month,int year){
		Session s = null;
		try {
			s = openSession();
			String sql = "SELECT lmis_get_total_hour_overtime_reward(" +rootId + "," +userId+ "," +month+"," +year+");";
			System.out.println("SQL content getTotalHourOverTimeReward: "+sql);
			SQLQuery q=  s.createSQLQuery(sql);
			List<Object> ls = q.list();
			double r=0;
			if(ls.size() >0 ){
				r = Double.parseDouble(ls.get(0).toString());
			}
			return r;
		} catch (Exception e) {
			System.out.println("Error LmisGeneralSettingsFinderImpl.getTotalHourOverTimeReward:"+e.toString());
			return 0;
		}
	}
	public Date getDetailSummayReportDate(int rootId, int userId, int year, int monStart,int monEnd, int type){
		Session s = null;
		try {
			s = openSession();
			String sql = "SELECT lmis_summay_report_date(" +rootId + "," +userId+ ","+year+ ","+ monStart + "," +monEnd + "," +type + ");";
			System.out.println("SQL content getDetailSummayReportDate: "+sql);
			SQLQuery q=  s.createSQLQuery(sql);
			List<Object> ls = q.list();
			
			if (ls.size() > 0) {
				Object o = ls.get(0);
				if (o != null) {
					System.out.println("Object Date:" + o);
					try {
						return LmisUtils.convertStrtoDate(o.toString(),
								"HH:mm:ss");
					} catch (ParseException e) {
						System.out.println("Parse ");
						return null;
					}
				}
				return null;
			}
			return null;
		} catch (Exception e) {
			System.out.println("Error LmisGeneralSettingsFinderImpl.getDetailSummayReportDate:"+e.toString());
			return null;
		}
	}
	public int getDetailSummayReportInt(int rootId, int userId, int year, int monStart,int monEnd, int type){
		Session s = null;
		try {
			s = openSession();
			String sql = "SELECT lmis_summay_report_int(" +rootId + "," +userId+ ","+year+ ","+ monStart + "," +monEnd + "," +type + ");";
			System.out.println("SQL content getDetailSummayReportInt: "+sql);
			SQLQuery q=  s.createSQLQuery(sql);
			List<Object> ls = q.list();
			int r=0;
			if(ls.size() >0 ){
				r = Integer.parseInt(ls.get(0).toString());
			}
			return r;
		} 
		catch (Exception e) {
			System.out.println("Error LmisGeneralSettingsFinderImpl.getDetailSummayReportInt:"+e.toString());
			return 0;
		}
	}
	public double getDetailSummayReportDouble(int rootId, int userId, int year, int monStart,int monEnd, int type){
		Session s = null;
		try {
			s = openSession();
			String sql = "SELECT lmis_summay_report_double(" +rootId + "," +userId+ ","+year+ ","+ monStart + "," +monEnd + "," +type + ");";
			System.out.println("SQL content getDetailSummayReportDouble: "+sql);
			SQLQuery q=  s.createSQLQuery(sql);
			List<Object> ls = q.list();
			double r=0;
			if(ls.size() >0 ){
				r = Double.parseDouble(ls.get(0).toString());
			}
			return r;
		} catch (Exception e) {
			System.out.println("Error LmisGeneralSettingsFinderImpl.getDetailSummayReportDouble:"+e.toString());
			return 0;
		}
	}
	public List<LmisGeneralSettings> getInfoConfigFileAttendance(int rootId){
		Session s = null;
		try {
			s = openSession();
			String sql = "SELECT * FROM lmis_general_settings WHERE root_id="+ rootId +" AND conf_type >=100 AND conf_type<=103";
			SQLQuery q = s.createSQLQuery(sql);
			q.addEntity("LmisGeneralSettings", LmisGeneralSettingsImpl.class);
			
			List<LmisGeneralSettings> ls = q.list();
			
		
			return ls;
		} catch (Exception e) {
			System.out.println("Error in LmisGeneralSettingsFinderImpl.getInfoConfigFileAttendance:"+e.toString());
			return new ArrayList<LmisGeneralSettings>();
		}
	}
	public boolean updateInfoConfigFileAttendance(int rootId,String code, String name, String chkIn, String chkOut){
		Session s = null;
		try {
			s = openSession();
			String sql = "SELECT lmis_insert_conf_file_attendance("+rootId+",'"+ code+"','"+name+"','"+chkIn+"','"+chkOut+"');";
			SQLQuery q = s.createSQLQuery(sql);
			List<Object> ls = q.list();
			boolean flag=false;
			if(ls.size() >0){
				
				System.out.println("updateInfoConfigFileAttendance: Object: "+ls.get(0).toString());
				flag= Boolean.parseBoolean(ls.get(0).toString());
			}
			return flag;
		} catch (Exception e) {
			System.out.println("Error in LmisGeneralSettingsFinderImpl.updateInfoConfigFileAttendance:"+e.toString());
			return false;
		}
	}
	public double getTotalDayCompensationRemaining(int rootId, int userId, int mon, int year){
		Session s = null;
		
		try {
			System.out.println("Call getTotalDayCompensationRemaining");
			s = openSession();
			String sql ="SELECT lmis_get_total_day_compensation_remaining(" +rootId + "," +userId + "," +mon + "," +year +");";
			System.out.println("SQL content: getTotalDayCompensationRemaining: "+sql);
			SQLQuery q = s.createSQLQuery(sql);
			List<Object> ls = q.list();
			double r =0.0;
			//Test
			System.out.println("List object: "+ls.toString());
			if(!ls.isEmpty()){
				r = Double.parseDouble(ls.get(0).toString());
			}
			return r;
		} catch (Exception e) {
			System.out.println("Error in LmisGeneralSettingsFinderImpl.getTotalDayCompensationRemaining:"+e.toString());
			return 0.0;
		}
	}
	public double getTotalDayAwardPrevYearRemaining(int rootId, int userId, int year){
		Session s = null;
		
		try {
			s = openSession();
			String sql ="SELECT lmis_get_total_day_award_prev_year_remaining(" +rootId + "," +userId + ","  +year +");";
			SQLQuery q = s.createSQLQuery(sql);
			List<Object> ls = q.list();
			double r =0;
			if(!ls.isEmpty()){
				r = Double.parseDouble(ls.get(0).toString());
			}
			return r;
		} catch (Exception e) {
			System.out.println("Error in LmisGeneralSettingsFinderImpl.getTotalDayAwardPrevYearRemaining:"+e.toString());
			return 0;
		}
	}
	public double getTotalDayAwardRemaining(int rootId, int userId, int year){
		Session s = null;
		
		try {
			s = openSession();
			String sql ="SELECT lmis_get_total_day_award_remaining(" +rootId + "," +userId + ","  +year +");";
			System.out.println("SQL content: getTotalDayAwardRemaining: "+sql);
			SQLQuery q = s.createSQLQuery(sql);
			List<Object> ls = q.list();
			double r =0;
			if(!ls.isEmpty() && ls.size()>0 ){
				r = Double.parseDouble(ls.get(0).toString());
			}
			return r;
		} catch (Exception e) {
			System.out.println("Error in LmisGeneralSettingsFinderImpl.getTotalDayCompensationRemaining:"+e.toString());
			return 0;
		}
	}
	public String getAppName(){
		Session s = null;
		
		try {
			s = openSession();
			String sql ="SELECT lmis_get_name_of_app()";
			SQLQuery q = s.createSQLQuery(sql);
			List<Object> ls = q.list();
			String r =null;
			if(ls.size() >0){
				r = ls.get(0).toString();
			}
			return r;
		} catch (Exception e) {
			System.out.println("Error in LmisGeneralSettingsFinderImpl.getTotalDayCompensationRemaining:"+e.toString());
			return "";
		}
	}
}
