<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file ="/inc/solgoda_header.jsp"%>
<script>
	$(document).ready(function(){
		$("#chkpass").submit(function(){
			if($("#ppass").val()==""){
				alert("비밀번호를 입력해주세요.");
				$("#ppass").focus();
				return false;
			}
		});	
	});
</script>
<div id="main">
<div class="container" style="height:50px">
	<h3>내정보관리</h3>
</div>
<div class="container text-center">
	<form action ="<%=request.getContextPath()%>/editInfo_view.do" method="post" id="chkpass"> 
		<fieldset>
			<legend>개인정보보호를 위해 비밀번호를 한 번 더 입력해주세요.</legend>
			<p class="text-center"><input type="password" id="ppass" name="ppass" style="width:500px"></p>
			<p class="text-center"><input type="submit" value="확인" class="btn btn-danger"></p>
		</fieldset>
		</form>
</div>
</div>
<%@ include file="/inc/footer.jsp"%>