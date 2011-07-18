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
import java.util.List;

import org.apache.commons.collections.ListUtils;

import com.liferay.portal.kernel.util.ListUtil;

import larion.progate.lmis.model.LmisEmailSettingDetails;
import larion.progate.lmis.model.LmisViewEmailSettingDetailOrg;
import larion.progate.lmis.model.LmisViewEmailSettingDetailUser;
import larion.progate.lmis.model.LmisViewEmailSettingDetailUser;
import larion.progate.lmis.model.LmisViewEmailSettingDetailUser;
import larion.progate.model.ProGateJournalArticleView;
import larion.progate.lmis.service.LmisEmailSettingDetailsLocalServiceUtil;
import larion.progate.lmis.service.LmisViewEmailSettingDetailOrgLocalServiceUtil;
import larion.progate.lmis.service.LmisViewEmailSettingDetailUserLocalServiceUtil;
import larion.progate.lmis.service.base.LmisViewEmailSettingDetailUserLocalServiceBaseImpl;
import larion.progate.lmis.service.persistence.LmisEmailSettingDetailsUtil;
import larion.progate.lmis.service.persistence.LmisViewEmailSettingDetailUserUtil;
import larion.progate.lmis.service.persistence.LmisViewEmailSettingDetailUserUtil;

/**
 * <a href="LmisViewEmailSettingDetailUserLocalServiceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewEmailSettingDetailUserLocalServiceImpl
	extends LmisViewEmailSettingDetailUserLocalServiceBaseImpl {
	
	public java.util.List<LmisViewEmailSettingDetailUser> getListEmail(int rootid,String type) {
		
		
		try {
			List<LmisViewEmailSettingDetailUser> result = new ArrayList<LmisViewEmailSettingDetailUser>();
			List<LmisViewEmailSettingDetailUser> r = ListUtils.intersection(LmisViewEmailSettingDetailUserUtil.findByRootID(rootid),LmisViewEmailSettingDetailUserUtil.findByEmailType(type));
			System.out.println("Call getListEmailUserRelated(" +type + ";" + rootid+ ")");
			System.out.println("r.size = " + r.size());
			System.out.println(r.toString());
			System.out.println("Result in JSP");
			result =r;		
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			System.out
			.println("Error LmisViewEmailSettingDetailUserLocalServiceImpl.getListEmailUserRelated"
							+ e.toString());
		}
		return null;
	}
	
	public java.util.List<LmisViewEmailSettingDetailUser> getListEmailUserRelated(int rootid,int id) {
		
		
		try {
			List<LmisViewEmailSettingDetailUser> result = new ArrayList<LmisViewEmailSettingDetailUser>();
			List<LmisViewEmailSettingDetailUser> r = ListUtils.intersection(LmisViewEmailSettingDetailUserUtil.findByRootID(rootid),LmisViewEmailSettingDetailUserUtil.findByID(id));
			System.out.println("Call getListEmailUserRelated(" +id + "," + rootid+ ")");
			System.out.println("r.size = " + r.size());
			System.out.println(r.toString());
			System.out.println("Result in JSP");
			result =r;		
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			System.out
			.println("Error LmisViewEmailSettingDetailUserLocalServiceImpl.getListEmailUserRelated"
							+ e.toString());
		}
		return null;
	}
	
	
	
	
	

	}
