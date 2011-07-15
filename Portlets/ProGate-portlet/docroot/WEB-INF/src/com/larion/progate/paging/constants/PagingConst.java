package com.larion.progate.paging.constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.compass.core.util.backport.java.util.Collections;


/**
 * Constants
 */
public interface PagingConst {		
	
	// Paging
	public static final String GOTO_PAGE = "page";
	public static final String PAGE_SIZE = "pageSize";
	public static final String CURRENT_PAGE = "currentPage";
	public static final String PAGING = "paging";
	public static final String TOTAL_RECORD = "numRecords";
	public static final String INCREMENT = "increment";
	public static final String BUFFER = "buffer";
	public static final String BUFFER_ARRAY = "bufferArray";
	public static final String URL_TO_REDIRECT = "urlToRedirect";
	
	public static final int INCREMENT_CONST = 10;
	public static final int BUFFER_CONST = 2;
	public static final List<Integer> BUFFER_ARRAY_CONST = new ArrayList<Integer>(Arrays.asList(10, 20, 50, 100));	
	
}
