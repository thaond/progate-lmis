package com.larion.progate.achievementMgmt.constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.compass.core.util.backport.java.util.Collections;


/**
 * Constants
 */
public interface RequestConst {	

	/* Form variables */
	public static final String DISPLAY_STYLE = "displayStyle";
	public static final String FRIENDLY_URL = "friendlyUrl";
	public static final String NUM_OF_ITEM = "numOfItem";
	
	public static final int INCREMENT_CONST = 20;
	
	public static final String FULL_VIEW = "full_view";
	public static final String SHORT_VIEW = "short_view";
	public static final List<String> DISPLAY_STYLE_ARRAY = new ArrayList<String>(Arrays.asList(FULL_VIEW, SHORT_VIEW));
	
	public static final String ORG_ID = "orgId";
	public static final String VIEW_MODE = "viewMode";
	public static final String DISPLAY_MODE = "display";	
	public static final String IS_ORG_ADMIN = "isOrgAdmin";
	public static final String BEAN = "achieList";	
	
	public static final String ACTION = "action";	
	public static final String ACHIE_ID = "cId";	
	public static final String ACTION_STATUS = "actionStatus";
	
	public static final String ADD_ACHIE = "add";
	public static final String EDIT_ACHIE = "edit";
	public static final String DELETE_ACHIE = "del";
	
	public static final int JA_ERROR = -1;
	public static final int JA_NORMAL = 0;
	public static final int JA_SUCCESS = 1;	
}
