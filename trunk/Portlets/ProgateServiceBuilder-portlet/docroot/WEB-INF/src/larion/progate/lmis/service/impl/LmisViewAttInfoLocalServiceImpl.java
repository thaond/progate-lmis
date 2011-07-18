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

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;

import larion.progate.lmis.service.base.LmisViewAttInfoLocalServiceBaseImpl;
import larion.progate.lmis.service.persistence.LmisViewAttInfoFinderUtil;
import larion.progate.lmis.model.LmisViewAttInfo;
import larion.progate.lmis.model.LmisViewAttdance;

import java.util.*;

import org.apache.commons.lang.StringUtils;

/**
 * <a href="LmisViewAttInfoLocalServiceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewAttInfoLocalServiceImpl extends
		LmisViewAttInfoLocalServiceBaseImpl {

	@Override
	public List<LmisViewAttInfo> getListAttManageByPM(int rootId, int pmId,
			Date dayValue,String name) throws PortalException, SystemException {
		try {
			List<LmisViewAttInfo> ls = LmisViewAttInfoFinderUtil
					.getListAttManageByPM(rootId, pmId, dayValue,name);
			System.out.println("success" + ls.toString());

			Calendar cal = Calendar.getInstance();
			@SuppressWarnings("deprecation")
			Date cur = cal.getTime();
			System.out.println("current date  : " + cur);

			List<LmisViewAttInfo> lsResult = new ArrayList<LmisViewAttInfo>();
			for (LmisViewAttInfo obj : ls) {
				if (obj.getDayValue().before(cur)
						|| obj.getDayValue().equals(cur)) {
					lsResult.add(obj);
				}
			}
			if (dayValue.compareTo(cur) == 0) {
				List<LmisViewAttInfo> lsFInal = new ArrayList<LmisViewAttInfo>();
				for (LmisViewAttInfo ob : lsResult) {
					if (StringUtils
							.isNotBlank(ob.getRealStartTime().toString())) {
						ob.setAbSence(2);
						lsFInal.add(ob);
					} else {
						lsFInal.add(ob);
					}

				}
				System.out.println("Success: special case");			
				Set<LmisViewAttInfo> s =  new HashSet();
				List<LmisViewAttInfo> lsSpec = new ArrayList<LmisViewAttInfo>();
				for (LmisViewAttInfo i : lsFInal) {
					if(s.add(i)){
						lsSpec.add(i);
					}
				}			
				return lsSpec;
				
			}
			System.out.println("Success: LmisViewAttInfo.getListAttManageByPM");
			Set<LmisViewAttInfo> s =  new HashSet();
			List<LmisViewAttInfo> lsr = new ArrayList<LmisViewAttInfo>();
			for (LmisViewAttInfo i : lsResult) {
				if(s.add(i)){
					lsr.add(i);
				}
			}			
			return lsr;

		} catch (Exception e) {
			System.out.println("Error: LmisViewAttInfo.getListAttManageByPM "+ e.toString());
		}
		return null;
	}
	
	@Override
	public List<LmisViewAttInfo> getListAttManageByBOD(int rootId, int bodId,
			Date dayValue,String name) throws PortalException, SystemException {
		try {
			List<LmisViewAttInfo> ls = LmisViewAttInfoFinderUtil
					.getListAttManageByBOD(rootId, bodId, dayValue,name);
			System.out.println("success" + ls.toString());

			Calendar cal = Calendar.getInstance();
			@SuppressWarnings("deprecation")
			Date cur = cal.getTime();
			System.out.println("current date  : " + cur);

			List<LmisViewAttInfo> lsResult = new ArrayList<LmisViewAttInfo>();
			for (LmisViewAttInfo obj : ls) {
				if (obj.getDayValue().before(cur)
						|| obj.getDayValue().equals(cur)) {
					lsResult.add(obj);
				}
			}
			if (dayValue.compareTo(cur) == 0) {
				List<LmisViewAttInfo> lsFInal = new ArrayList<LmisViewAttInfo>();
				for (LmisViewAttInfo ob : lsResult) {
					if (StringUtils
							.isNotBlank(ob.getRealStartTime().toString())) {
						ob.setAbSence(2);
						lsFInal.add(ob);
					} else {
						lsFInal.add(ob);
					}

				}
				Set<LmisViewAttInfo> s =  new HashSet();
				List<LmisViewAttInfo> lsSpec = new ArrayList<LmisViewAttInfo>();
				for (LmisViewAttInfo i : lsFInal) {
					if(s.add(i)){
						lsSpec.add(i);
					}
				}			
				return lsSpec;
				
			}

			System.out.println("Success: LmisViewAttInfo.getListAttManageByBOD");		
			Set<LmisViewAttInfo> s =  new HashSet();
			List<LmisViewAttInfo> lsr = new ArrayList<LmisViewAttInfo>();
			for (LmisViewAttInfo i : lsResult) {
				if(s.add(i)){
					lsr.add(i);
				}
			}			
			return lsr;

		} catch (Exception e) {
			System.out.println("Error: LmisViewAttInfo.getListAttManageByBOD "+ e.toString());	
		}
		return null;
	}

}