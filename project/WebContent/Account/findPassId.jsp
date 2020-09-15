<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file ="/inc/solgoda_header.jsp"%>
<style>
#pname1 {   margin-left: 2.5%; width:50% }
#pname2 { margin-left: 7.5%; width:50%} 
#pid2 { margin-left: 5%; width:50%} 
#pname3 { margin-left: 7.5%; width:50%} 
#pid3 { margin-left: 5%; width:50%}
#pemail1 {  width:50% }
#pemail3 {  width:50% }
#pphonenumber2 { width:50% }
</style>
<script>
	$(document).ready(function(){
		$("#find_id_form").submit(function(){
			if($("#pname1").val().trim()==""){
				alert("이름을 입력해주세요");
				$("#pname1").focus();
				return false;
			}
			if($("#pemail1").val().trim()==""){
				alert("이메일을 입력해주세요");
				$("#pemail1").focus();
				return false;		
			}
		});
	});
	$(document).ready(function(){
		$("#find_pass_form1").submit(function(){
			if($("#pname2").val().trim()==""){
				alert("이름을 입력해주세요.");
				$("#pname2").focus();
				return false;
			}			
			if($("#pid2").val().trim()==""){
				alert("아이디를 입력해주세요");
				$("#pid2").focus();
				return false;
			}
			if($("#pphonenumber2").val().trim()==""){
				alert("휴대폰번호를 입력해주세요.");
				$("#pphonenumber2").focus();
				return false;		
			}
		});
	});
	$(document).ready(function(){
		$("#find_pass_form2").submit(function(){
			if($("#pname3").val().trim()==""){
				alert("이름을 입력해주세요.");
				$("#pname3").focus();
				return false;
			}			
			if($("#pid3").val().trim()==""){
				alert("아이디를 입력해주세요");
				$("#pid3").focus();
				return false;
			}
			if($("#pemail3").val().trim()==""){
				alert("이메일을 입력해주세요.");
				$("#pemail3").focus();
				return false;		
			}
		});
	});
</script>
<div id="main">
	<div class="container">
		<h3>아이디 / 비밀번호찾기</h3>	
		<div style="margin-top:5%">
			<div class="col-sm-6">
				<form action="<%=request.getContextPath()%>/findId.do" method="post" id="find_id_form">
				<fieldset>
				<legend>아이디찾기</legend>
					<div class="form-group">
						<label for="pname1">이름</label>
						<input type="text" id="pname1" name="pname">
					</div>
					<div class="form-group">
						<label for="pemail1">이메일</label>
						<input type="text" id="pemail1" name="pemail">
					</div>	
					<div class="form-group text-center">
						<input type="submit" class="btn btn-danger" style="width:20%" value="확인">
					</div>	
				</fieldset>
				</form>
			</div>
		</div>
	</div><!-- end container -->
	<div class="container">
		<h3>비밀번호찾기</h3>	
		<div style="margin-top:5%">
				<div class="col-sm-6">
				<form action="<%=request.getContextPath()%>/findPass_p.do" method="post" id="find_pass_form1">
				<fieldset>
				<legend>휴대폰번호로 찾기</legend>
					<div class="form-group">
						<label for="pname2">이름</label>
						<input type="text" id="pname2" name="pname" >
					</div>
					<div class="form-group">
						<label for="pid2">아이디</label>
						<input type="text" id="pid2" name="pid">
					</div>	
					<div class="form-group">
						<label for="pphonenumber2">휴대폰번호</label>
						<input type="text" id="pphonenumber2" name="pphonenumber" placeholder="000-0000-0000 형식으로입력해주세요.">
					</div>	
					<div class="form-group text-center">
						<input type="submit" class="btn btn-danger" style="width:20%" value="확인">
					</div>	
				</fieldset>
				</form>
			</div>
			<div class="col-sm-6">
				<form action="<%=request.getContextPath()%>/findPass_e.do" method="post" id="find_pass_form2">
				<fieldset>
				<legend>이메일로 찾기</legend>
					<div class="form-group">
						<label for="pname3">이름</label>
						<input type="text" id="pname3" name="pname">
					</div>
					<div class="form-group">
						<label for="pid3">아이디</label>
						<input type="text" id="pid3" name="pid">
					</div>
					<div class="form-group">
						<label for="pemail3">이메일주소</label>
						<input type="text" id="pemail3" name="pemail">
					</div>	
					<div class="form-group text-center">
						<input type="submit" class="btn btn-danger" style="width:20%" value="확인">
					</div>	
				</fieldset>
				</form>
			</div>
		</div>
	</div><!-- end container -->
</div>
<%@ include file="/inc/footer.jsp" %>