/**
 * Copyright (c) 2000-2009 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package larion.progate.lmis.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.ListUtils;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import larion.progate.lmis.model.LmisWorkingCalendars;
import larion.progate.lmis.service.base.LmisWorkingCalendarsLocalServiceBaseImpl;
import larion.progate.lmis.service.persistence.LmisWorkingCalendarsFinderUtil;
import larion.progate.lmis.service.persistence.LmisWorkingCalendarsUtil;
import larion.progate.lmis.service.utils.LmisConst;

/**
 * <a href="LmisWorkingCalendarsLocalServiceImpl.java.html"><b><i>View
 * Source</i></b></a>
 * 
 * @author Brian Wing Shun Chan
 * 
 */
public class LmisWorkingCalendarsLocalServiceImpl extends
		LmisWorkingCalendarsLocalServiceBaseImpl {
	
	
	public List<LmisWorkingCalendars> workingcalendar(int rootid, int year,
			int month) throws PortalException, SystemException {

		return LmisWorkingCalendarsFinderUtil.workingcalendar(rootid, year,
				month);
	}

	public java.util.List<larion.progate.lmis.model.LmisWorkingCalendars> findByWorkingCalendarOf(
			int rootId) throws com.liferay.portal.SystemException {
		return LmisWorkingCalendarsUtil.findByWorkingCalendarOf(rootId);
	}

	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public java.util.List<larion.progate.lmis.model.LmisWorkingCalendars> getListWorkingCalendar(
			int rootId, Date date) {
		try {	
			
			Calendar cal =Calendar.getInstance();
			@SuppressWarnings("deprecation")
			Date date1 = new Date(date.toString());
			@SuppressWarnings("deprecation")
			Date date2 = new Date(date.toString());		
			date1.setDate(cal.getActualMinimum(Calendar.DAY_OF_MONTH));
			date2.setDate(cal.getActualMaximum(Calendar.DAY_OF_MONTH));
			System.out.println("date 1: " + date1);
			System.out.println("date 2: " + date2);
	
			List<LmisWorkingCalendars> tmp1 = ListUtils.intersection(
					LmisWorkingCalendarsUtil.findByWorkingCalendarOf(rootId),
					(ListUtils.intersection(
							LmisWorkingCalendarsUtil.findByDaySmaller(date2),
							LmisWorkingCalendarsUtil.findByDayGreater(date1))));
			
			List<LmisWorkingCalendars> tmp2 =ListUtils.intersection(LmisWorkingCalendarsUtil.findByDayType(0),( ListUtils.intersection(
					LmisWorkingCalendarsUtil.findByWorkingCalendarOf(rootId),
					(ListUtils.intersection(
							LmisWorkingCalendarsUtil.findByDaySmaller(date2),
							LmisWorkingCalendarsUtil.findByDayGreater(date1))))));
			List<LmisWorkingCalendars> result = ListUtils.subtract(tmp1, tmp2);

			System.out.println("CallgetListWorkingCalendar(" + rootId + ","
					+ date + ")");
			return result;
		} catch (Exception e) {
			System.out
					.println("Error LmisWorkingCalendarsLocalServiceImpl. getListWorkingCalendar "
							+ e.toString());
		}
		return null;
	}

	public boolean deleteWorkingCalendar(int rootid, int calendarId) {
		try {
			System.out.println("Delete dayId:" + calendarId);
			LmisWorkingCalendars objDelete = LmisWorkingCalendarsUtil
					.fetchByPrimaryKey(calendarId);
			if (objDelete.getLmisWorkingCalendarId() == null) {
				System.out
						.println("End function: deleteWorkingCalendar with false return");
				return false;
			} else {
				objDelete.setDayType(LmisConst.Config_Delete_Date_Type);
				objDelete.setIsModified(true);
				System.out
						.println("End function: deleteWorkingCalendar with true return");
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out
			.println("Error LmisWorkingCalendarsLocalServiceImpl.deleteWorkingCalendar "
					+ e.toString());
			return false;
		}
		
	}

	public boolean addWorkingCalendar(int rootId, Date date, int dayType,
			String description) throws SystemException, PortalException {

		try {
			System.out.println("Add dayId:" + date);
			List<LmisWorkingCalendars> lsDate = LmisWorkingCalendarsUtil.findByDayValue(date);
			List<LmisWorkingCalendars> lsRoot = LmisWorkingCalendarsUtil.findByWorkingCalendarOf(rootId);
			List<LmisWorkingCalendars> ls= ListUtils.intersection(lsDate, lsRoot);
			System.out.println("ls size" + ls.toString());
			if(ls!=null & ls.size() !=0){
			LmisWorkingCalendars objAdd = ls.get(0);
			System.out.println(objAdd.toString());
			if (objAdd.getLmisWorkingCalendarId() == null) {
				System.out
						.println("End function: addWorkingCalendar with false return");
				return false;
			} else {

				// objAdd = createLmisWorkingCalendars(null);
				objAdd.setDayType(dayType);
				objAdd.setDayValue(date);
				objAdd.setIsModified(true);
				objAdd.setDescription(description);
				System.out
						.println("End function: addWorkingCalendar with true return");
				return true;
			}
			}
			else 
				
				return false;

		} catch (Exception e) {

			System.out
			.println("Error LmisWorkingCalendarsLocalServiceImpl.addWorkingCalendar "
					+ e.toString());	
			return false;

		}
		

	}
}