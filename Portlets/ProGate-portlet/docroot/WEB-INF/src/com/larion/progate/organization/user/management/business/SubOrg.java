package com.larion.progate.organization.user.management.business;

import com.larion.progate.common.bean.BusinessObject;

public class SubOrg extends BusinessObject {

	private int orgId;
	private String orgName;

	public int getOrgId() {
		return orgId;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public SubOrg() {

	}

	public SubOrg(int orgId, String orgName) {
		this.orgId = orgId;
		this.orgName = orgName;
	}
}
