package com.larion.progate.organization.management.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class OrgForm extends ActionForm{
	
	private String org_Name = "";

	public String getOrg_Name() {
		return org_Name;
	}

	public void setOrg_Name(String orgName) {
		this.org_Name = orgName;
		System.out.println(this.org_Name);
	}
	/*
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		
		boolean isOrgNameExist = false;
		ActionErrors errors = new ActionErrors();
		try {
			if (!"".equals(orgName)) {
				List<Organization> orgs = OrganizationUtil.findByOrgName(this.orgName);
				if (orgs.size() != 0) {
					isOrgNameExist = true;
				}
			}			
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		if (isOrgNameExist) {
			errors.add(Request.ORG_NAME, new ActionMessage("org.error.orgName.exist"));
		}
		
		return errors;
	}*/
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.org_Name = "";
	}
}
