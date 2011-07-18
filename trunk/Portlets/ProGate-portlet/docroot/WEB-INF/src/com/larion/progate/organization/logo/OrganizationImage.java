package com.larion.progate.organization.logo;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.imagegallery.model.IGImage;
import com.liferay.portlet.imagegallery.service.IGImageLocalServiceUtil;

import larion.progate.model.Organization;
import larion.progate.service.OrganizationLocalServiceUtil;

public class OrganizationImage {
	public static String NO_LOGO = "org_no_logo.jpg";
	public static int LOGO = 1;
	public static int BANNER = 2;
	private Integer _orgId = 0;
	private Organization _org;
	IGImage _logo;
	private int _imageType = LOGO;
	private String _orgName = "";
	private long imageId = 0;
		
	public OrganizationImage(Integer orgId, int orgImageType ){
		this._orgId = orgId;
		this._imageType = orgImageType;
	}
	
	public OrganizationImage(Organization org, int orgImageType ){
		this._org = org;
		this._imageType = orgImageType;
	}
	
	public Integer getOrgId(){
		if(_org != null){
			_orgId = _org.getOrgId();
		}
		return _orgId;
	}
	
	public void setLocalImageId(long imageId) {
		this.imageId = imageId;
	}
	
	public long getLocalImageId() {
		return this.imageId;
	}
	
	public boolean isNoImage(){	
		//return getImage() == null;
		boolean retVal = true;
		if(_imageType == LOGO){
			if(getOrganization().getLogoId() != null){
				if (getOrganization().getLogoId().trim().length() > 0) {
					retVal = false;
				}
			}
		} else if(_imageType == BANNER){
			if(getOrganization().getBannerId() != null){
				if (getOrganization().getBannerId().trim().length() > 0) {
					retVal = false;
				}
			}
		}
		return retVal;
	}
	
	public Long getLargeImageId(){
		return getImage().getLargeImageId();		
	}
	
	public String getImageUrl(){		
		String ret = "";
		try {
			if(_imageType == LOGO){
				return getOrganization().getLogoId();
			} else if(_imageType == BANNER){
				return getOrganization().getBannerId();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return ret;
	}
	
	public Long getImageId(){			
		return this.imageId;
	}
	
	
	
	public Long getSmallImageId(){
		return getImage().getSmallImageId();	
	}
	
	private IGImage getImage(){
		if(_logo == null){
			try {
				if(getImageId() > 0){
					_logo = IGImageLocalServiceUtil.getIGImage(getImageId());
				}
			} catch (PortalException e) {
				
				e.printStackTrace();
			} catch (SystemException e) {
				
				e.printStackTrace();
			}
		}
		return _logo;		
	}	
	
	public String getOrgName(){
		if(this.getOrganization() != null){
			_orgName = getOrganization().getName();
		}
		return _orgName;
	}
	
	public Organization getOrganization(){
		if(_org == null){
			try {
				_org = OrganizationLocalServiceUtil.getOrganization(this._orgId);
			} catch (PortalException e) {
				
				e.printStackTrace();
			} catch (SystemException e) {				
				e.printStackTrace();
			}
		}
		return _org;
	}
	
	
}
