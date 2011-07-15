package com.larion.progate.myblog.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import larion.progate.service.ProGateJournalArticleLocalServiceUtil;
import org.springframework.web.portlet.mvc.ParameterizableViewController;

import com.larion.progate.common.utils.ProGateUtil;
import com.larion.progate.news_homepage.constants.News_Const;
import com.liferay.portal.kernel.util.ParamUtil;

public class DeleteMyBlogController extends ParameterizableViewController{
	
	@Override
	protected void handleActionRequestInternal(ActionRequest request,
			ActionResponse response) throws Exception {
		
		Map<String, Object> bean = new HashMap<String, Object>();
		
		int articleId = ParamUtil.getInteger(request,News_Const.ARTICLE_ID);
		
		// Get current User
		try{
			
			if (articleId != 0){
				ProGateJournalArticleLocalServiceUtil.deleteProGateJournalArticle(Integer.valueOf(articleId));
			}
			
		}catch(Exception e){
			
		}
		
		ProGateUtil.redirectToPageWithParams(request, response, 
				News_Const.MY_BLOG, 
				new String[] {}, 
				new String[] {});
		
	}
}