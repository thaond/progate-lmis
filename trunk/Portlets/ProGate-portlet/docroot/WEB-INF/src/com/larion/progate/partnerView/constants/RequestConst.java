package com.larion.progate.partnerView.constants;

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
	
	public static final String FULL_VIEW = "full_view";
	public static final String SHORT_VIEW = "short_view";
	public static final List<String> DISPLAY_STYLE_ARRAY = new ArrayList<String>(Arrays.asList(FULL_VIEW, SHORT_VIEW));
	
	public static final String ORG_ID = "orgId";
	public static final String VIEW_MODE = "viewMode";
	public static final String DISPLAY_MODE = "display";	
	public static final String IS_ORG_ADMIN = "isOrgAdmin";
	public static final String BEAN = "partnerList";
	public static final String OBJECT_ID = "objectId";
	public static final String ACTION = "action";
		
	public static final int JA_ERROR = -1;
	public static final int JA_NORMAL = 0;
	public static final int JA_SUCCESS = 1;
	
	// Paging
	public static final String GOTO_PAGE = "page";
	public static final String CURRENT_PAGE = "currentPage";
	public static final String PAGING = "paging";
	public static final String TOTAL_RECORD = "numRecords";
	public static final String INCREMENT = "increment";
	public static final String BUFFER = "buffer";
	public static final String BUFFER_ARRAY = "bufferArray";
	
	public static final int INCREMENT_CONST = 4;
	public static final int BUFFER_CONST = 2;
	public static final List<Integer> BUFFER_ARRAY_CONST = new ArrayList<Integer>(Arrays.asList(10, 20, 50, 100));	
	
}
