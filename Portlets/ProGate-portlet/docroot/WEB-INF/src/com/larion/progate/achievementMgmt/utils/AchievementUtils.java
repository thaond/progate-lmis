/**
 * Copyright (c) [Year] [Organization] All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.larion.progate.achievementMgmt.utils;

import java.util.*;

import com.larion.progate.achievementMgmt.constants.*;
import com.larion.progate.paging.constants.PagingConst;

import larion.progate.model.ProGateJournalArticle;
import larion.progate.service.ProGateJournalArticleLocalServiceUtil;

/**
 * <p>
 * Your description here
 * </p>
 * 
 * @author (Your name)
 * 
 */
public class AchievementUtils {

	public static List<ProGateJournalArticle> getListAchievementArticles(int orgId, Map<String, Object> paging) throws Exception {
		
		int pageNum = (Integer)paging.get(PagingConst.CURRENT_PAGE);
		int increment = (Integer)paging.get(PagingConst.INCREMENT);
		
		//System.out.println("pageNum = " + pageNum + ", increment = " + increment);
		
		int startIndex = (pageNum - 1) * increment;
		int endIndex = pageNum * increment;
				
		return getListAchievementArticles(orgId, startIndex, endIndex);
	}
	
	public static List<ProGateJournalArticle> getListAchievementArticles(int orgId, int startIndex, int endIndex) throws Exception {
		
		//System.out.println("startIndex = " + startIndex + ", endIndex = " + endIndex);
		
		List<ProGateJournalArticle> achieList = null;
		try {		
			if (orgId > 0) {
				achieList = ProGateJournalArticleLocalServiceUtil.getListAchievementArticles(orgId, null, startIndex, endIndex);
			}
		} catch (Exception e) {
			System.out.println("getListAchievementArticles(" + orgId + ")");
			//e.printStackTrace();
			achieList = null;
		}
		
		if (achieList == null) {
			achieList = new ArrayList<ProGateJournalArticle>();
		}
		
		return achieList;
	}
	
	public static ProGateJournalArticle getAchievementArticles(int achieId) throws Exception {
		
		ProGateJournalArticle achieItem = null; 
		try {					
			if (achieId > 0) {
				achieItem = ProGateJournalArticleLocalServiceUtil.getProGateJournalArticle(achieId);
			}			
		} catch (Exception e) {			
			System.out.println("getAchievementArticles(" + achieId + ") ==> Null data");
			// e.printStackTrace();
			achieItem = null;
		}
		
		if (achieItem == null) {
			achieItem = ProGateJournalArticleLocalServiceUtil.createEmptyObject();
			achieItem.setAddInfo(AchievementConst.JA_ADD_INFO_PREFIX + "=");
		}
		
		return achieItem;
	}
}
