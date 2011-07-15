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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang.StringUtils;

import com.liferay.portal.SystemException;

import larion.progate.lmis.model.LmisViewAttDaily;
import larion.progate.lmis.model.LmisViewAttdance;
import larion.progate.model.Organization;
import larion.progate.lmis.service.base.LmisViewAttdanceLocalServiceBaseImpl;
import larion.progate.lmis.service.persistence.LmisViewAttDailyUtil;
import larion.progate.lmis.service.persistence.LmisViewAttdanceFinderUtil;
import larion.progate.lmis.service.persistence.LmisViewAttdanceUtil;

/**
 * <a href="LmisViewAttdanceLocalServiceImpl.java.html"><b><i>View
 * Source</i></b></a>
 * 
 * @author Brian Wing Shun Chan
 * 
 */
public class LmisViewAttdanceLocalServiceImpl extends
		LmisViewAttdanceLocalServiceBaseImpl {

	public List<larion.progate.lmis.model.LmisViewAttdance> getListAttByRootAndDay(
			int rootId, Date dayValue) throws SystemException {

		try {

			/*
			 * List<LmisViewAttdance> lsRoot = LmisViewAttdanceUtil
			 * .findByRootId(rootId); List<LmisViewAttdance> lsDate =
			 * LmisViewAttdanceUtil .findByDayValue(dayValue);
			 * List<LmisViewAttdance> ls = ListUtils.intersection(lsRoot,
			 * lsDate);
			 */
			List<LmisViewAttdance> ls = LmisViewAttdanceFinderUtil
					.getListAttByRootAndDay(rootId, dayValue);
			/*int idCom = 0;
			for (Iterator<LmisViewAttdance> iter = ls.iterator(); iter
					.hasNext();) {
				LmisViewAttdance LmisViewAttdance = iter.next();
				if (LmisViewAttdance.getLmisViewAttDailyId() == idCom) {
					iter.remove();
				}
				idCom = LmisViewAttdance.getLmisViewAttDailyId();
			}*/
		

			Calendar cal = Calendar.getInstance();
			@SuppressWarnings("deprecation")
			Date cur = cal.getTime();
			System.out.println("current date  : " + cur);

			List<LmisViewAttdance> lsResult = new ArrayList<LmisViewAttdance>();
			for (LmisViewAttdance obj : ls) {
				if (obj.getDayValue().before(cur)
						|| obj.getDayValue().equals(cur)) {
					lsResult.add(obj);
				}
			}
			if (dayValue.compareTo(cur) == 0) {
				List<LmisViewAttdance> lsFInal = new ArrayList<LmisViewAttdance>();
				for (LmisViewAttdance ob : lsResult) {
					if (StringUtils
							.isNotBlank(ob.getRealStartTime().toString())) {
						ob.setAbSence(2);
						lsFInal.add(ob);
					} else {
						lsFInal.add(ob);
					}

				}
				System.out.println("Success: special case");
				Set<LmisViewAttdance> s = new HashSet<LmisViewAttdance>();
				List<LmisViewAttdance> lsSpec = new ArrayList<LmisViewAttdance>();
				for (LmisViewAttdance i : lsFInal) {
					if (s.add(i)) {
						lsSpec.add(i);
					}
				}
				return lsSpec;

			}

			System.out
					.println("Success: LmisViewAttdance.getListAttByRootAndDay");

			Set<LmisViewAttdance> s = new HashSet<LmisViewAttdance>();
			List<LmisViewAttdance> lsr = new ArrayList<LmisViewAttdance>();
			for (LmisViewAttdance i : lsResult) {
				if (s.add(i)) {
					lsr.add(i);
				}
			}
			return lsr;

		} catch (Exception e) {
			System.out.println("Error in LmisViewAttdance  dayValue ="
					+ dayValue + e.toString());

		}
		return null;
	}

	public larion.progate.lmis.model.LmisViewAttdance getAttDetail(int id)
			throws SystemException {

		try {
			LmisViewAttdance result = LmisViewAttdanceUtil
					.fetchByPrimaryKey(id);

			System.out.println("Success: LmisViewAttdance.getAttDetail "
					+ result);
			return result;
		} catch (SystemException e) {
			System.out.println("Error in LmisViewAttdancegetAttDetail   id ="
					+ id);
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see larion.progate.lmis.service.LmisViewAttdanceLocalService#
	 * getListAttDailyByUserId(int, int)
	 */
	public List<larion.progate.lmis.model.LmisViewAttdance> getListAttDailyByUserId(
			int userId, int rootId) throws SystemException {

		/*
		 * List<LmisViewAttdance > lsRoot =
		 * LmisViewAttdanceUtil.findByRootId(rootId); List<LmisViewAttdance >
		 * lsUser = LmisViewAttdanceUtil.findByUserId(userId);
		 * List<LmisViewAttdance > ls = ListUtils.intersection(lsRoot, lsUser);
		 */
		List<LmisViewAttdance> ls = LmisViewAttdanceFinderUtil
				.getListAttDailyorder(userId, rootId);
		Calendar cal = Calendar.getInstance();
		@SuppressWarnings("deprecation")
		Date cur = cal.getTime();
		System.out.println("current date  : " + cur);
		List<LmisViewAttdance> lsResult = new ArrayList<LmisViewAttdance>();
		for (LmisViewAttdance obj : ls) {
			if (obj.getDayValue().before(cur) || obj.getDayValue().equals(cur)) {
				lsResult.add(obj);
			}
		}
		Set<LmisViewAttdance> s = new HashSet();
		List<LmisViewAttdance> lsr = new ArrayList<LmisViewAttdance>();
		for (LmisViewAttdance i : lsResult) {
			if (s.add(i)) {
				lsr.add(i);
			}
		}

		return lsr;
	}

	public List<LmisViewAttdance> getListAttDailyFilterTabPersonal(int rootId,
			int userId, Date date, int status, int absence)
			throws SystemException {
		List<LmisViewAttdance> ls = LmisViewAttdanceFinderUtil
				.getListAttDailyFilterTabPersonal(rootId, userId, date, status,
						absence);
		Calendar cal = Calendar.getInstance();
		@SuppressWarnings("deprecation")
		Date cur = cal.getTime();
		System.out.println("current date  : " + cur);
		List<LmisViewAttdance> lsResult = new ArrayList<LmisViewAttdance>();
		for (LmisViewAttdance obj : ls) {
			if (obj.getDayValue().before(cur) || obj.getDayValue().equals(cur)) {
				lsResult.add(obj);
			}
		}
		Set<LmisViewAttdance> s = new HashSet();
		List<LmisViewAttdance> lsr = new ArrayList<LmisViewAttdance>();
		for (LmisViewAttdance i : lsResult) {
			if (s.add(i)) {
				lsr.add(i);
			}
		}
		return lsr;
	}

	public List<LmisViewAttdance> getListAttDailyFilterTabOther(int rootId,
			Date date, String name) throws SystemException {
		List<LmisViewAttdance> ls = LmisViewAttdanceFinderUtil
				.getListAttDailyFilterTabOther(rootId, date, name);
		Calendar cal = Calendar.getInstance();
		@SuppressWarnings("deprecation")
		Date cur = cal.getTime();
		System.out.println("current date  : " + cur);
		List<LmisViewAttdance> lsResult = new ArrayList<LmisViewAttdance>();
		for (LmisViewAttdance obj : ls) {
			if (obj.getDayValue().before(cur) || obj.getDayValue().equals(cur)) {
				lsResult.add(obj);
			}
		}
		Set<LmisViewAttdance> s = new HashSet();
		List<LmisViewAttdance> lsr = new ArrayList<LmisViewAttdance>();
		for (LmisViewAttdance i : lsResult) {
			if (s.add(i)) {
				lsr.add(i);
			}
		}
		return lsr;
	}

}