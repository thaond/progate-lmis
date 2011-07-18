package com.larion.progate.informationOrg.business;

import java.util.ArrayList;
import java.util.List;

public class OrgType extends BusinessObject{
	private int orgTypeValue;
	private String orgTypeName;	
	
	public OrgType() {
		
	}
	
	public OrgType(int orgTypeValue, String orgTypeName) {
		this.orgTypeValue = orgTypeValue;
		this.orgTypeName = orgTypeName;
	}
	
	public int getOrgTypeValue() {
		return orgTypeValue;
	}

	public void setOrgTypeValue(int orgTypeValue) {
		this.orgTypeValue = orgTypeValue;
	}

	public String getOrgTypeName() {
		return orgTypeName;
	}

	public void setOrgTypeName(String orgTypeName) {
		this.orgTypeName = orgTypeName;
	}
	
	public List<OrgType> getOrgTypes() {
		List<OrgType> OrgTypes = new ArrayList<OrgType>();
		for (int i = 0; i <= 27; i++) {
			OrgTypes.add(new OrgType( i, "OT_"+i));
		}
		
		return OrgTypes;
	}
}