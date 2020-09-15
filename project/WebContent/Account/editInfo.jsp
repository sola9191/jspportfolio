<%@page import="com.pagoda.dto.Cre_Acc_Dto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file ="/inc/solgoda_header.jsp"%>
<% Cre_Acc_Dto dto = (Cre_Acc_Dto) request.getAttribute("dto"); %>
<% String birthday = dto.getPbirthDay().substring(0,4)+"년"+dto.getPbirthDay().substring(4,6)+"월"+dto.getPbirthDay().substring(6)+"일"; %>
<script> 
	$(document).ready(function(){
		$("#edit_info_form").submit(function(){
			if($("#old").val().trim()==""){
				alert("기존 비밀번호를 입력해주세요");
				$("#old").focus();
				return false;
			}
			else if($("#new").val().trim()==""){
				alert("변경할 비밀번호를 입력해주세요.");
				$("#new").focus();
				return false;
			}
			else if($("#passChk").val().trim()==""){
				alert("비밀번호 재확인을 입력해주세요.");
				$("#passChk").focus();
				return false;
			}
			else if($("#new").val()!=$("#passChk").val()){
				alert("비밀번호를 다시확인해주세요.");
				$("#passChk").focus();
				return false;
			}	
			else if($("#pphonenumber1").val().trim()==""){
				alert("휴대폰번호를 입력해주세요");
				$("#pphonenumber1").focus();
				return false;
			}
			else if($("#pphonenumber2").val().trim()==""){
				alert("휴대폰번호를 입력해주세요");
				$("#pphonenumber2").focus();
				return false;
			}
			else if($("#pphonenumber3").val().trim()==""){
				alert("휴대폰번호를 입력해주세요");
				$("#pphonenumber3").focus();
				return false;
			}
					
			else if($("#pemail1").val().trim()==""){
				alert("이메일을 입력해주세요");
				$("#pemail1").focus();
				return false;
			}			
			else if($("#pemail2").val().trim()==""){
				alert("이메일을 입력해주세요");
				$("#pemail2").focus();
				return false;
			}
			else if($(":radio[name='text']:checked").length==0){
				alert("문자정보서비스 동의/미동의 여부를 확인해주세요.");
				$(":radio[id='textagree']").attr("checked", "checked");
				return false;
			}
			else if($(":radio[name='email']:checked").length==0){
				alert("이메일정보 동의/미동의 여부를 확인해주세요.");
				$(":radio[id='emailagree']").attr("checked", "checked");
				return false;
			}			
		});	
	});

</script>
<div id="main">
	<div class="container text-center" style="height:100px;">
		<h3 style="color: red;">회원정보변경</h3>
		<h5 style="color: black;">안전한 개인정보보호를 위해 주기적으로 비밀번호 및 이메일, 휴대번호 등 최신정보를 변경해주세요.</h5>
	</div>	
	<div class="container well" style="margin-top:3%">
			<table class="table table-striped">
			<tbody>
				<tr><th scope="row" width="25%" >이름</th><td><%=dto.getPname()%></td></tr>
				<tr><th scope="row" width="25%">아이디</th><td><%=dto.getPid()%></td></tr>
			</tbody>
			</table>
	</div>
	<div class="container well">
			<form action="<%=request.getContextPath()%>/editInfo.do" method="post" id="edit_info_form">	
				<fieldset>
					<table class="table table-striped">
						<tbody>						
						<tr>
							<th scope="row">기존비밀번호</th>
							<td><input type="password" id="old" name="old" placeholder="8자 이상 영문+숫자+특수기호 조합" 
							style="width: 300px;" minlength="8"></td>
						</tr>	
						<tr>
							<th scope="row">변경할비밀번호</th>
							<td><input type="password" id="new" name="new" placeholder="8자 이상 영문+숫자+특수기호 조합" 
							style="width: 300px;" minlength="8"></td>
						</tr>
						<tr>
							<th scope="row">비밀번호확인</th>
							<td><input type="password" id="passChk" name="passChk"	placeholder="위의 비밀번호를 다시 한번 기입" 
							style="width: 300px;" minlength="8"></td>
						</tr>
						<tr>
							<th scope="row">생년월일</th><td><%=birthday%></td>
						</tr>
						<tr>	
							<th scope="row">휴대폰번호</th>
							<td><input type="text" id="pphonenumber1" name="pphonenumber1" style="width: 100px;" maxlength="3" minlength="3">
							<input type="text" id="pphonenumber2" name="pphonenumber2" style="width: 100px;" maxlength="4" minlength="4">
							<input type="text" id="pphonenumber3" name="pphonenumber3" style="width: 100px;" maxlength="4" minlength="4"></td>
						</tr>
						<tr>
							<th scope="row">이메일</th>
							<td><input type="text" id="pemail1" name="pemail1" style="width:100px">
							<span>@</span>
							<input type="text" id="pemail2" name="pemail2" style="width:190px"></td>
						</tr>
						</tbody>
					</table>
			<div class="text-left" style="margin-top:5%">
					<div class="col-sm-3">정보수신동의</div>
					<div class="col-sm-9">
					<div class="row r1">
						<strong>문자정보서비스</strong>
						<p>솔고다에서 발송하는 문자(SMS)를 통한 수강 및 이벤트 정보 수신에 동의합니다</p>
				 		<input type="radio" value="y" id="textagree" name="text"><label for="textagree">예</label>
				 		<input type="radio" value="n" id="textdisagree" name="text"><label for="textdisagree">아니오</label>
					</div>
					<div class="row r2" style="margin-top:3%">
						<strong>이메일정보</strong>
						<p>솔고다에서 발송하는 이메일을 통한 수강과 관련정보(이벤트/할인쿠폰/기획전/프로모션 등)의 안내를 받으시겠습니까?</p>
				 		<input type="radio" value="y" id="emailagree" name="email"><label for="emailagree">예</label>
				 		<input type="radio" value="n" id="emaildisagree" name="email"><label for="emaildisagree">아니오</label>
					</div>
					</div>
			</div>	
			<div class="form-group text-center">
				<a href="<%=request.getContextPath()%>/detail_view.do" class="btn btn-primary" style="margin-top:4%" >뒤로가기</a>
				<input type="submit" value="회원정보수정" class="btn btn-danger" style="margin-top:4%">			
			</div>	
	</fieldset>
	</form>
</div>
</div>
<%@ include file="/inc/footer.jsp"%>