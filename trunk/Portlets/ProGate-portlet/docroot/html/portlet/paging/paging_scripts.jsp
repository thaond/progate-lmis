<%--

--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap" %>

<%@page import="com.larion.progate.paging.constants.PagingConst"%>

<%
	//System.out.println("urlToRedirect = " + paging.get(PagingConst.URL_TO_REDIRECT));	
	//System.out.println("increment = " + paging.get(PagingConst.INCREMENT));
	//System.out.println("totalRecords = " + paging.get(PagingConst.TOTAL_RECORD));
	//System.out.println("currentPage = " + paging.get(PagingConst.CURRENT_PAGE));
	
	List<Integer> bufferArray = PagingConst.BUFFER_ARRAY_CONST;
	List<Integer> bufferArrayReverse = new ArrayList<Integer>(bufferArray);
	Collections.copy(bufferArrayReverse, bufferArray);
	Collections.reverse(bufferArrayReverse); 
%>

<fmt:setBundle basename="content.Paging_vn" var="msg"></fmt:setBundle>

<%-- variables --%>
<c:set value="<%= PagingConst.BUFFER_CONST %>" var="buffer"/>
<c:set value="<%= PagingConst.GOTO_PAGE %>" var="goPage"/>
<c:set value="<%= (String)paging.get(PagingConst.URL_TO_REDIRECT) %>" var="urlToRedirect"/>
<c:set value="<%= (Integer)paging.get(PagingConst.INCREMENT) %>" var="increment"/>
<c:set value="<%= (Integer)paging.get(PagingConst.TOTAL_RECORD) %>" var="total"/>
<c:set value="<%= (Integer)paging.get(PagingConst.CURRENT_PAGE) %>" var="currentPage"/>

<c:if test="${total % increment == 0}">
	<fmt:formatNumber pattern="#" value="${total / increment}" var="totalPages" />
</c:if>
<c:if test="${total % increment != 0}">
	<fmt:formatNumber pattern="#" value="${(total - total % increment) / increment + 1}" var="totalPages" />
</c:if>

<c:set value="${1}" var="firstPage"/>
<c:set value="${currentPage - 1}" var="prevPage"/>
<c:set value="${currentPage + 1}" var="nextPage"/>
	
<script type="text/javascript">

	function isNotEmpty(inputStr) {
	    if (inputStr == "" || inputStr == null) {
	        alert('<fmt:message bundle="${msg}" key="error.paging.empty"/>');
	        
			return false;
	    }
	    
		return true;
	}
	
	function isNumber(inputStr) {
		if (isNotEmpty(inputStr)) {
			if (Number(inputStr)) {				
				for (var i = 0; i < inputStr.length; i++) {
					var oneChar = inputStr.substring(i, i + 1);
					if (oneChar < "0" || oneChar > "9") {
						alert('<fmt:message bundle="${msg}" key="error.paging.isNotNumber"/>');
						
						return false;
					}
				}
				
				return true;
			} else {
				alert('<fmt:message bundle="${msg}" key="error.paging.invalidNumber"/>');
				
				return false;
		    }
		}
		
		return true;
	}
	
	function onKeyPress(e) { 
		if (e.keyCode == 13) pagingGoTo();
		//if (e.which == 13) pagingGoTo();
	}
	
	function pagingGoTo() {
		var goToPage = document.getElementById('goToPage').value;
		//alert(pageNum);
		if (isNumber(goToPage)) {
			if (goToPage > ${totalPages}) {
				alert('<fmt:message bundle="${msg}" key="error.paging.isNotExisting"/>')
			} else {
				paging(goToPage);
			}
		}
  	}
	
	function paging(goToPage) {
		var pageNum = Number(goToPage);
		document.getElementById('goToPage').value = pageNum;
		
		// Handle redirect
		var hrefUrl = "${urlToRedirect}&${goPage}=" + pageNum;
		//alert("hrefUrl = " + hrefUrl);
		
		window.location.href = hrefUrl;
	}
	
	function changeDisplayPageNav() {
		if (jQuery("#pagenav_menu").css('display') == 'none') {
			jQuery("#pagenav_menu").css('display', 'block');
		} else {
			jQuery("#pagenav_menu").css('display', 'none');
		}		
	}

</script>
