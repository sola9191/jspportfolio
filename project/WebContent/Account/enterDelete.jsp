<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file ="/inc/solgoda_header.jsp"%>
<script>
	$(document).ready(function(){
		$("#delete_form").submit(function(){
			if($("#pid").val()==""){
				alert('아이디를 입력해주세요.');
				$("#pid").focus();
				return false;
			}				
			if($("#ppass").val()==""){
				alert('비밀번호를 입력해주세요.');
				$("#ppass").focus();
				return false;
			}	
		});
	});	
</script>
<div id="main">
	<div class="container well text-center" >
		<form action="<%=request.getContextPath()%>/delete_view.do" method="post" id="delete_form">
 			<fieldset>
 			<legend>회원님의 정보 보호를 위해 로그인을 한번 더 해주시기 바랍니다.</legend>
			<div class="row" style="margin-top:2%">
				<input type="text" id="pid" name="pid" 
				placeholder="아이디" style="width:400px; height:40px;">
			</div>
			<div class="row" style="margin-top:2%">
				<input type="password" id="ppass" name="ppass"
				placeholder="비밀번호" style="width:400px; height:40px;">
			</div>
			<div class="form-group" style="margin-top:5%">
				<input type="submit" value="로그인" class="btn btn-danger" style="width:400px">
			</div>
			</fieldset>
		</form>
	</div>
</div>
<%@ include file= "/inc/footer.jsp" %>