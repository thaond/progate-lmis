package com.larion.progate.informationOrg.formbean;

import java.util.Date;

import org.apache.struts.action.ActionForm;

public class InformationOrg extends ActionForm{
	String typeOfActivity;
	Date establishDate;
	long quantityOfMembers;
	String founder;
	String website;
	
	public String getTypeOfActivity(){
		return typeOfActivity;
	}
	
	public void setTypeOfActivity(String typeOfActivity){
		this.typeOfActivity = typeOfActivity;
	}
	
	public Date getEstablishDate(){
		return establishDate;
	}
	
	public void setEstablishDate(Date establishDate){
		this.establishDate = establishDate;
	}
	
	public long getQuantityOfMembers(){
		return quantityOfMembers;
	}
	public void setQuantityOfMembers(long quantityOfMembers){
		this.quantityOfMembers = quantityOfMembers;
	}
	
	public String getFounder(){
		return founder;
	}
	public void setFounder(String founder){
		this.founder = founder;
	}
	
	public String getWebsite(){
		return website;
	}
	public void setWebsite(String website){
		this.website = website;
	}
}