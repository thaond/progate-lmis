package com.larion.progate.organization.management.business;

import java.util.ArrayList;
import java.util.List;

public class OrgMaxNoOfUser extends BusinessObject{
		
	private int orgMaxNoOfUserValue;
	private String orgMaxNoOfUserName;	
	
	public OrgMaxNoOfUser() {
		
	}
	
	public OrgMaxNoOfUser(int orgMaxNoOfUserValue, String orgMaxNoOfUserName) {
		this.orgMaxNoOfUserValue = orgMaxNoOfUserValue;
		this.orgMaxNoOfUserName = orgMaxNoOfUserName;
	}
	
	public int getOrgMaxNoOfUserValue() {
		return orgMaxNoOfUserValue;
	}

	public void setOrgMaxNoOfUserValue(int orgMaxNoOfUserValue) {
		this.orgMaxNoOfUserValue = orgMaxNoOfUserValue;
	}

	public String getOrgMaxNoOfUserName() {
		return orgMaxNoOfUserName;
	}

	public void setOrgMaxNoOfUserName(String orgMaxNoOfUserName) {
		this.orgMaxNoOfUserName = orgMaxNoOfUserName;
	}
	
	public List<OrgMaxNoOfUser> getOrgMaxNoOfUsers() {
		List<OrgMaxNoOfUser> orgMaxNoOfUsers = new ArrayList<OrgMaxNoOfUser>();
		
		orgMaxNoOfUsers.add(new OrgMaxNoOfUser( 10, "10"));
		orgMaxNoOfUsers.add(new OrgMaxNoOfUser( 50, "50"));
		orgMaxNoOfUsers.add(new OrgMaxNoOfUser( 100, "100"));
		orgMaxNoOfUsers.add(new OrgMaxNoOfUser( 1000, "1,000"));
		orgMaxNoOfUsers.add(new OrgMaxNoOfUser( 2000, "2,000"));
		orgMaxNoOfUsers.add(new OrgMaxNoOfUser( 5000, "5,000"));
		orgMaxNoOfUsers.add(new OrgMaxNoOfUser( 10000, "10,000"));		
		
		return orgMaxNoOfUsers;
	}
}