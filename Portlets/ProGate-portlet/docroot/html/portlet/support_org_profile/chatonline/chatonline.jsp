<div class="checkHidden">
			<input type="checkbox" name="box${rowCounter.count}" id="box${rowCounter.count}"/>
	</div>
	<div style="float:left;">
		<dl id="sample" class="dropdown sample">
	        <dt>
	        	<a href="javascript:void(0);" id="row${rowCounter.count}"><span>
	        		<img class="flag" src="<%=request.getContextPath()%>/images/support_org_profile/yahoo.jpeg" alt="" 
	                	 style="float: left;vertical-align: middle;"/>
	                <img style="vertical-align: middle; float: right; margin-top: 5pt;" alt="" 
	                	src="/ProGate-portlet/images/support_org_profile/menu_open.gif" class="flag"> 
	                	<span style="padding-top:5px;"><%= res.getString("yahoo")%></span>	                
	        	</span></a>
	        	<input type="hidden" id="typeChatOnline${rowCounter.count}" name="typeChatOnline${rowCounter.count}" value=""/>
	        </dt>
	        <dd >
	            <ul style="margin: 0 0 0 0;" id="list${rowCounter.count}">
		                <li>
			               <a href="javascript:void(0);">
			                	<img class="flag" src="<%=request.getContextPath()%>/images/support_org_profile/yahoo.jpeg" alt="" 
			                	 style="float: left;vertical-align: middle;"/>			                	
			                	<span style="padding-top:5px;"> <%= res.getString("yahoo")%> </span>
			               </a>	
		                </li>
	                </a>
	                <li>
	                	<a href="javascript:void(0);">
	                		<img class="flag" src="<%=request.getContextPath()%>/images/support_org_profile/skype.jpg" alt="" style="float:left;"/>
	                		<span style="padding-top:5px;"> <%= res.getString("skype")%> </span>
	                    </a>
	                </li>
	                <li>
	                	<a href="javascript:void(0);">
	                		<img class="flag" src="<%=request.getContextPath()%>/images/support_org_profile/window.jpeg" alt="" style="float:left;"/>
	                		<span style="padding-top:5px;"> <%= res.getString("window")%> </span>
	                    </a>
	                </li>
	                <li>
	                	<a href="javascript:void(0);">
	                		<img class="flag" src="<%=request.getContextPath()%>/images/support_org_profile/ICQ.jpeg" alt="" style="float:left;"/>
	                		<span style="padding-top:5px;"> <%= res.getString("icq")%> </span>
	                    </a>
	                </li>
	               <li>
	                	<a href="javascript:void(0);">
	                		<img class="flag" src="<%=request.getContextPath()%>/images/support_org_profile/googleTalk.jpeg" alt="" style="float:left;"/>
	                		<span style="padding-top:5px;"> <%= res.getString("gtalk")%> </span>
	                    </a>
	                </li>
	           </ul>
	        </dd>
	    </dl>
  </div>
  <div style="margin-top: -5px;">	
        <div style="float:left;">   
			<input type="text" class="chat-text" name="nick${rowCounter.count}" id="nick${rowCounter.count}" />(<font color="red">*</font>)
			<div id="checkNick${rowCounter.count}"></div>
		</div>
		<div style="float:left;">   
			<span class="chat-label"><%=res.getString("position")%> (<font color="red">*</font>)</span>
			<input type="text" class="chat-text" name="position${rowCounter.count}" id="position${rowCounter.count}" />
			<div id="checkPosition${rowCounter.count}"></div>
		</div>
  </div>
 <div style="clear:both;margin-bottom:30px;"></div> 	