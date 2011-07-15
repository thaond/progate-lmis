package com.larion.progate.organization.management.business;

import java.util.ArrayList;
import java.util.List;

public class OrgCity extends BusinessObject{
		
	private int orgCityValue;
	private String orgCityName;	
	
	public OrgCity() {
		
	}
	
	public OrgCity(int OrgCityValue, String OrgCityName) {
		this.orgCityValue = OrgCityValue;
		this.orgCityName = OrgCityName;
	}
	
	public int getOrgCityValue() {
		return orgCityValue;
	}

	public void setOrgCityValue(int orgCityValue) {
		this.orgCityValue = orgCityValue;
	}

	public String getOrgCityName() {
		return orgCityName;
	}

	public void setOrgCityName(String orgCityName) {
		this.orgCityName = orgCityName;
	}
	
	public List<OrgCity> getOrgCities() {
		List<OrgCity> orgCitys = new ArrayList<OrgCity>();
		for (int i = 0; i <= 65; i++) {
			orgCitys.add(new OrgCity( i, "PC_"+i));
		}
		
		return orgCitys;
	}
}
