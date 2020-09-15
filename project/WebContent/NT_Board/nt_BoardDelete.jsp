<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file ="/inc/solgoda_header.jsp"%>
<script>
	$(document).ready(function(){
		$("#chkpass").submit(function(){
			if($("#cpass").val()==""){
				alert("비밀번호를 입력해주세요.");
				$("#cpass").focus();
				return false;
			}
		});	
	});
</script>
<div id="main">
<div class="container" style="height:50px">
	<h3>공지사항 삭제</h3>
</div>
<div class="container text-center">
	<form action ="<%=request.getContextPath()%>/delete.notice?nno=<%=request.getParameter("nno")%>" method="post" id="chkpass"> 
		<fieldset>
			<legend>게시글 삭제를 위하여 비밀번호를 한 번 더 입력해주세요.</legend>
			<p class="text-center"><input type="password" id="npass" name="npass" style="width:500px"></p>
			<p class="text-center"><input type="submit" value="확인" class="btn btn-danger"></p>
			</fieldset>
		</form>
</div>
</div>
<%@ include file="/inc/footer.jsp"%>