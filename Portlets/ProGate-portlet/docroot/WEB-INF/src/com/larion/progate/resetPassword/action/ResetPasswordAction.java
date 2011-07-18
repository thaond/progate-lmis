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

package com.larion.progate.resetPassword.action;


import com.larion.progate.common.action.ParameterizableViewAction;
import com.larion.progate.common.constants.URLParameter_RS;
import com.larion.progate.video.constants.Video_Const;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import larion.progate.model.Organization;
import larion.progate.service.OrganizationLocalServiceUtil;


/**
 * <p>
 * Your description here
 * </p>
 * 
 * @author (Your name)
 * 
 */
public class ResetPasswordAction extends ParameterizableViewAction {

	@Override
	public void handleRenderRequestInternal(RenderRequest request,
			RenderResponse response, Map<String, Object> bean) throws Exception {
//		boolean errReCap = false;
//		if(request.getAttribute("INVALID_RECAPTCHA") != null){
//			errReCap = (Boolean)request.getAttribute("INVALID_RECAPTCHA");
//		}
//		
//		boolean emailIsValid = true;
//		if(request.getAttribute("emailIsValid") != null){
//			emailIsValid = (Boolean)request.getAttribute("emailIsValid");
//		}
//		
//		String email = "";
//		if(request.getAttribute("INPUT_EMAIL") != null){
//			email = (String)request.getAttribute("INPUT_EMAIL");
//		}
//		request.setAttribute("emailIsValid", emailIsValid);
//		request.setAttribute("INVALID_RECAPTCHA", errReCap);
//		request.setAttribute("INPUT_EMAIL", email);
		
		
		long userID = 0;
		boolean isLimited = false;
		String viewURL = PortalUtil.getCurrentURL(request);
		int index = viewURL.indexOf("change-pass?id=");
		if(index != -1){
			String[] sliptString = viewURL.split("=");
			String[] s = sliptString[1].split("\\/");
			userID = Long.parseLong(s[0]);
			Date currentDate = new Date();
			int currentDateNum = (currentDate.getYear()* 365)+ (currentDate.getMonth()*30)+ (currentDate.getDate());
			try{
				User user = UserLocalServiceUtil.getUser(userID);
				Date modifyPassDate = user.getPasswordModifiedDate();
				int modifyPassDateNum = (modifyPassDate.getYear()* 365)+ (modifyPassDate.getMonth()*30)+ (modifyPassDate.getDate());
				int limitedDate = currentDateNum - modifyPassDateNum;
				String fullName = user.getFullName();
				String email = user.getEmailAddress();
				boolean isResetPass = Boolean.parseBoolean(user.getGreeting());
				boolean isActivated = user.getActive();
				if(isActivated){
					if(isResetPass && (limitedDate <= 3)){  // limited
						
						request.setAttribute("UserId", userID);
						request.setAttribute("FullName", fullName);
						request.setAttribute("Email", email);
						
					}else if (isResetPass && (limitedDate > 3)){
						
						isLimited = true;
						request.setAttribute("isLimited", isLimited);
						
					}else{
						
						request.setAttribute("isResetPass", isResetPass);
					}
					
				}else{
					request.setAttribute("isActivated", isActivated);
				}
				
				
			}catch(Exception e){
				
			}
		}
		
		
		
	}

}
