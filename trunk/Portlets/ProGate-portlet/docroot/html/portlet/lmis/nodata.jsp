
<form action="" name="frmRequestOTList" method="post">
	<c:if test="${bean.typeUser !=bean.isStaff }">
		<div class="createChange"  >
			<input id="ctl-add" type="image" src="/ProGate-portlet/images/lmis/add.png" width="24px" height="24px"
				href="#" id="mode-edit-active">
		   	<a id="_createChange" href="#"><fmt:message key="lmis.common.create" /></a>
	    </div>
	</c:if>
	<div class="cls-ot">
		<div class="tableContainer">
			
			<div style="text-align: center; font-size: 16px;font-weight: bold; "><fmt:message key="lmis.ot.without"></fmt:message> <br/>
			  </div>
		</div>
	</div> 
</form>