package com.larion.progate.informationOrg.business;

import java.util.ArrayList;
import java.util.List;

public class OrgProvince extends BusinessObject {
	private int orgProvinceValue;
	private String orgProvinceName;	
	
	public OrgProvince() {
		
	}
	
	public OrgProvince(int OrgProvinceValue, String OrgProvinceName) {
		this.orgProvinceValue = OrgProvinceValue;
		this.orgProvinceName = OrgProvinceName;
	}
	
	public int getOrgProvinceValue() {
		return orgProvinceValue;
	}

	public void setOrgProvinceValue(int orgProvinceValue) {
		this.orgProvinceValue = orgProvinceValue;
	}

	public String getOrgProvinceName() {
		return orgProvinceName;
	}

	public void setOrgProvinceName(String orgProvinceName) {
		this.orgProvinceName = orgProvinceName;
	}
	
	public List<OrgProvince> getOrgProvinces() {
		List<OrgProvince> orgProvinces = new ArrayList<OrgProvince>();
		for (int i = 0; i <= 65; i++) {
			orgProvinces.add(new OrgProvince( i, "PC_"+i));
		}
		
		return orgProvinces;
	}
}