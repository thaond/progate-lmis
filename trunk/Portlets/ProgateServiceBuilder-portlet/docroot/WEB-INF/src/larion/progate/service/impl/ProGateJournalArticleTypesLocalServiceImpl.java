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

package larion.progate.service.impl;

import larion.progate.model.ProGateJournalArticleTypes;
import larion.progate.service.base.ProGateJournalArticleTypesLocalServiceBaseImpl;
import larion.progate.service.persistence.ProGateJournalArticleTypesUtil;

/**
 * <a href="ProGateJournalArticleTypesLocalServiceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateJournalArticleTypesLocalServiceImpl
	extends ProGateJournalArticleTypesLocalServiceBaseImpl {
	
	public String getArticleTypeProduct(){
		try {
			return ProGateJournalArticleTypesUtil.findByname("Org_Product").get(0).getName();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	
	public ProGateJournalArticleTypes createProGateJournalArticleTypes(String name){
		try {
			ProGateJournalArticleTypes obj = ProGateJournalArticleTypesUtil.create(null);
			obj.setDescription(name);
			obj.setName(name);
			ProGateJournalArticleTypesUtil.update(obj, false);
			return obj;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	
	public String getArticleTypeIntroduce(){
		try {
			return ProGateJournalArticleTypesUtil.findByname("Org_Introduction").get(0).getName();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	
	public String getArticleTypeNews(){
		try {
			return ProGateJournalArticleTypesUtil.findByname("Org_News").get(0).getName();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	
	public String getArticleTypeHome(){
		try {
			return ProGateJournalArticleTypesUtil.findByname("Org_Home").get(0).getName();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	
	public String getArticleTypeService(){
		try {
			return ProGateJournalArticleTypesUtil.findByname("Org_Service").get(0).getName();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	
	public String getArticleTypeSupport(){
		try {
			return ProGateJournalArticleTypesUtil.findByname("Org_Support").get(0).getName();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	
	public String getArticleTypeResource(){
		try {
			return ProGateJournalArticleTypesUtil.findByname("Org_Resource").get(0).getName();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	
	public String getArticleTypeCert(){
		try {
			return ProGateJournalArticleTypesUtil.findByname("Org_Cert").get(0).getName();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	
	public String getArticleTypeRecommendation(){
		try {
			return ProGateJournalArticleTypesUtil.findByname("Org_Recommendation").get(0).getName();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	
	public String getArticleTypeAdvertisement(){
		try {
			return ProGateJournalArticleTypesUtil.findByname("Org_Advertisement").get(0).getName();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	
	public String getArticleTypeApplication(){
		try {
			return ProGateJournalArticleTypesUtil.findByname("Org_Application").get(0).getName();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	
	public String getArticleTypeAchievement(){
		try {
			return ProGateJournalArticleTypesUtil.findByname("Org_Achievement").get(0).getName();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	
	public String getArticleTypeOrgOverall(){
		try {
			return ProGateJournalArticleTypesUtil.findByname("Org_Overall").get(0).getName();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	
	public String getArticleTypeOrgHistory(){
		try {
			return ProGateJournalArticleTypesUtil.findByname("Org_History").get(0).getName();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	
	public String getArticleTypeOrgMap(){
		try {
			return ProGateJournalArticleTypesUtil.findByname("Org_Map").get(0).getName();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	
	public String getArticleTypeOrgCustomer(){
		try {
			return ProGateJournalArticleTypesUtil.findByname("Org_Customer").get(0).getName();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	
	public String getArticleTypeOrgPartner(){
		try {
			return ProGateJournalArticleTypesUtil.findByname("Org_Partner").get(0).getName();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	
	public String getArticleTypeOrgOverallIntro(){
		try {
			return ProGateJournalArticleTypesUtil.findByname("Org_Overall_Intro").get(0).getName();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	
	public String getArticleTypeOrgOverallVision(){
		try {
			return ProGateJournalArticleTypesUtil.findByname("Org_Overall_Vision").get(0).getName();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	
	
	
	public String getArticleTypeOrgOverallMission(){
		try {
			return ProGateJournalArticleTypesUtil.findByname("Org_Overall_Mission").get(0).getName();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	
	public String getArticleTypeOrgOverallCoreValue(){
		try {
			return ProGateJournalArticleTypesUtil.findByname("Org_Overall_CoreValue").get(0).getName();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	
	public String getArticleTypeOrgSupportFaq(){
		try {
			return ProGateJournalArticleTypesUtil.findByname("Org_Support_FAQ").get(0).getName();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	
	public String getArticleTypeOrgSupportGuideline(){
		try {
			return ProGateJournalArticleTypesUtil.findByname("Org_Support_Guideline").get(0).getName();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	
	public String getArticleTypeOrgSupportVideo(){
		try {
			return ProGateJournalArticleTypesUtil.findByname("Org_Support_Video").get(0).getName();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	
	public String getArticleTypeOrgSupportPdf(){
		try {
			return ProGateJournalArticleTypesUtil.findByname("Org_Support_Pdf").get(0).getName();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	
	public String getArticleTypeOrgSupportOnline(){
		try {
			return ProGateJournalArticleTypesUtil.findByname("Org_Support_Online").get(0).getName();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}

}
