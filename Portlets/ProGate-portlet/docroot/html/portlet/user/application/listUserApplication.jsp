<%@ include file="../../common/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<style type="text/css">

.right-panel-application ul {
	list-style: none;
	padding: 0;
}

.right-panel-application ul li{
	float: left;
	padding-top: 3px;
}

.right-panel-application .cell {
	margin-left: 40px;	
}

.right-panel-application .cell a {
	text-decoration: none;
}

.right-panel-application .cell img {
	height: 120px;
    padding-top: 10px;
    width: 120px;
}
</style>

<div class="right-panel-application">
	<c:forEach items="${bean.applications}" var="application" varStatus="count">
		<ul>
		<li>
		<div class="cell">
			<a href="<c:out value="${application.friendlyUrl}"></c:out>">
			
				<div class="tnt-cell-image">
					<div class="tnt-cell-text">
					<span><c:out value="${application.name}"></c:out></span>
					</div>
									
					<img alt='<c:out value="${application.name}"></c:out>'
						src='<c:out value="${application.description}"></c:out>'
						title='<c:out value="${application.name}"></c:out>' />				
				</div>
			</a>		
		</div>
		</li>
		</ul>
	</c:forEach>
</div>