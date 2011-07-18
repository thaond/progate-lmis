package com.larion.progate.productOverview.constants;

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
	public static final String DISPLAY_SUB_STYLE = "displaySubStyle";
	public static final String FRIENDLY_URL = "friendlyUrl";
	public static final String NEW_PRODUCT_URL = "newProductUrl";
	public static final String SELLING_PRODUCT_URL = "sellingProductUrl";
	public static final String DISCOUNT_PRODUCT_URL = "discountProductUrl";
	public static final String NUM_OF_ITEM = "numOfItems";
	public static final String MAX_ITEM_TO_SHOW = "maxItems";
	
	public static final int INCREMENT_CONST = 10;
	public static final int MAX_ITEMS_CONST = 3;
	public static final int MAX_RELATED_PRODUCT = 3;
	
	public static final String PRODUCT_LIST = "productList";	
	public static final String COURSE_LIST = "courseList";
	public static final String COURSE_LIST_OVERVIEW = "courseListHome";	
	public static final String EXAM_LIST = "examList";
	public static final String EXAM_LIST_OVERVIEW = "examListHome";

	public static final String ALL_PRODUCT_LIST = "allProduct";
	public static final String NEW_PRODUCT_LIST = "newProduct";
	public static final String SELLING_PRODUCT_LIST = "sellingProduct";
	public static final String DISCOUNT_PRODUCT_LIST = "discountProduct";
	
	public static final List<String> DISPLAY_STYLE_ARRAY = new ArrayList<String>(
														Arrays.asList(PRODUCT_LIST, COURSE_LIST, COURSE_LIST_OVERVIEW, EXAM_LIST, EXAM_LIST_OVERVIEW));
	public static final List<String> DISPLAY_SUB_STYLE_ARRAY = new ArrayList<String>(
														Arrays.asList(ALL_PRODUCT_LIST, NEW_PRODUCT_LIST, SELLING_PRODUCT_LIST, DISCOUNT_PRODUCT_LIST));
	
	public static final String ORG_ID = "orgId";
	public static final String DISPLAY_MODE = "display";
	
	
}
