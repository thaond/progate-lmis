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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.collections.ListUtils;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;

import larion.progate.lmis.model.LmisViewWorkingCalendar;
import larion.progate.lmis.model.LmisWorkingCalendars;
import larion.progate.lmis.service.LmisWorkingCalendarsLocalServiceUtil;
import larion.progate.lmis.service.base.LmisViewWorkingCalendarLocalServiceBaseImpl;
import larion.progate.lmis.service.persistence.LmisViewWorkingCalendarUtil;
import larion.progate.lmis.service.persistence.LmisWorkingCalendarsUtil;
import larion.progate.lmis.service.utils.LmisConst;

/**
 * <a href="LmisViewWorkingCalendarLocalServiceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewWorkingCalendarLocalServiceImpl extends
		LmisViewWorkingCalendarLocalServiceBaseImpl {

	@Override
	@SuppressWarnings({ "unchecked", "deprecation" })
	public java.util.List<larion.progate.lmis.model.LmisViewWorkingCalendar> getListWorkingCalendar(
			int rootId, Date date) {
		try {	
	/*		System.out.println("Call getListWorkingCalendar(" + rootId + ","+ date + ")" + " result.size !=0 ");			
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");				
			Calendar cal=  Calendar.getInstance();
			Date date1 = formatter.parse(date.toString());			
			Date date2 = formatter.parse(date.toString());			
			cal.setTime(date1);			
			cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));			
			cal.setTime(date2);			
			cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));		
			System.out.println("date 1: " + date1);
			System.out.println("date 2: " + date2);*/
			System.out.println("Call getListWorkingCalendar(" + rootId + ","+ date + ")" + " result.size !=0 ");
			Calendar cal=  GregorianCalendar.getInstance();
			Date date1 = new Date(date.toString());			
			Date date2 = new Date(date.toString());
			date1.setDate(cal.getActualMinimum(GregorianCalendar.DAY_OF_MONTH));
			date2.setDate(cal.getMaximum(GregorianCalendar.DAY_OF_MONTH));

			List<LmisViewWorkingCalendar> tmp1 = ListUtils
					.intersection(LmisViewWorkingCalendarUtil
							.findByRootID(rootId),
							(ListUtils.intersection(LmisViewWorkingCalendarUtil
									.findByDaySmaller(date2),
									LmisViewWorkingCalendarUtil
											.findByDayGreater(date1))));
			System.out.println("tmp1 " + tmp1.toString());

			List<LmisViewWorkingCalendar> tmp2 = ListUtils.intersection(
					LmisViewWorkingCalendarUtil.findByDayType(LmisConst.Day_Normal),
					(ListUtils.intersection(LmisViewWorkingCalendarUtil
							.findByRootID(rootId),
							(ListUtils.intersection(LmisViewWorkingCalendarUtil
									.findByDaySmaller(date2),
									LmisViewWorkingCalendarUtil
											.findByDayGreater(date1))))));
			System.out.println("tmp2 " + tmp2.toString());
			List<LmisViewWorkingCalendar> result = ListUtils.subtract(tmp1,
					tmp2);

			
			if (result.size() == 0) {
				System.out.println("Call getListWorkingCalendar(" + rootId + ","+ date + ")" + " result.size =0 ");
				int year = date.getYear() + 1900;
				int month = date.getMonth() + 1;
				
				LmisWorkingCalendarsLocalServiceUtil.workingcalendar(rootId,
						year, month);			
				System.out.println("getyear: " + year);
				System.out.println("getmonth: " + month);
				Calendar cal1 = Calendar.getInstance();		
				Date date3 = new Date(date.toString());				
				Date date4 = new Date(date.toString());
				date1.setDate(cal.getActualMinimum(Calendar.DAY_OF_MONTH));
				date2.setDate(cal.getActualMaximum(Calendar.DAY_OF_MONTH));
				System.out.println("date 3: " + date3);
				System.out.println("date 4: " + date4);

				List<LmisViewWorkingCalendar> tmp3 = ListUtils.intersection(
						LmisViewWorkingCalendarUtil.findByRootID(rootId),
						(ListUtils.intersection(LmisViewWorkingCalendarUtil
								.findByDaySmaller(date2),
								LmisViewWorkingCalendarUtil
										.findByDayGreater(date1))));
				System.out.println("tmp3 " + tmp3.toString());
				List<LmisViewWorkingCalendar> tmp4 = ListUtils.intersection(
						LmisViewWorkingCalendarUtil.findByDayType(LmisConst.Day_Normal),
						(ListUtils.intersection(LmisViewWorkingCalendarUtil
								.findByRootID(rootId), (ListUtils.intersection(
								LmisViewWorkingCalendarUtil
										.findByDaySmaller(date2),
								LmisViewWorkingCalendarUtil
										.findByDayGreater(date1))))));
				System.out.println("tmp4 " + tmp4.toString());
				List<LmisViewWorkingCalendar> result1 = ListUtils.subtract(
						tmp3, tmp4);
				return result1;
			} else {
				System.out
						.println("Success LmisViewWorkingCalendarLocalServiceImpl. getListWorkingCalendar ");
				return result;
			}
		} catch (Exception e) {
			System.out
					.println("Error LmisViewWorkingCalendarLocalServiceImpl. getListWorkingCalendar "
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
		}
		return false;
	}

	public boolean addWorkingCalendar(int rootid, Date date, int dayType,
			String description) throws SystemException, PortalException {

		try {
			System.out.println("Add dayId:" + date);
			List<LmisWorkingCalendars> ls = LmisWorkingCalendarsUtil
					.findByDayValue(date);
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

		} catch (Exception e) {

			System.out.println(e.toString());

			return false;

		}

	}
}