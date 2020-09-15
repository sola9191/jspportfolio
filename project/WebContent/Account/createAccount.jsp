<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file ="/inc/solgoda_header.jsp"%>
<style>

</style>
<script> 
	$(document).ready(function(){
		$("#cre_id").submit(function(){
			if($("#pname").val().trim()==""){
				alert("이름을 입력해주세요");
				$("#pname").focus();
				return false;
			}
			else if($("#birthDay_Year option:selected").val()==("default")){
				alert("태어나신 년도를 선택해주세요.");
				$("#birthDay_Year").focus();
				return false;			
			}
			else if($("#birthDay_Month option:selected").val()==("default")){
				alert("태어나신 월을 선택해주세요.");
				$("#birthDay_Month").focus();
				return false;
			}
			else if($("#birthDay_date option:selected").val()==("default")){
				alert("태어나신 날짜를 선택해주세요.");
				$("#birthDay_date").focus();
				return false;
			}
			else if($(":radio[name='pgender']:checked").length==0){
				alert("성별을 선택해주세요.");
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
			else if($("#pid").val().trim()==""){
				alert("아이디를 입력해주세요.");
				$("#pid").focus();
				return false;
			}
			else if($("#ppass").val().trim()==""){
				alert("비밀번호를 입력해주세요");
				$("#ppass").focus();
				return false;
			}
			else if($("#passChk").val().trim()==""){
				alert("비밀번호재확인을 입력해주세요.");
				$("#passChk").focus();
				return false;
			}
			else if($("#ppass").val()!=$("#passChk").val()){
				alert("비밀번호를 다시확인해주세요.");
				$("#passChk").focus();
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
			else if($("#iddouble").text()==""){
				alert("아이디 중복 체크를 하셔야 합니다.");
				return false;
			}
			
		});	
	});
	
	$(function(){
		$("#iddoublechk").click(function(){
			if($("#pid").val()==""){ $("#pid").focus(); return false; }
			else{
				$.ajax({
					url:"${pageContext.request.contextPath}/doubleIdChk.do",
					type:"get",
					dataType:"json",
					data:{"pid": $("#pid").val() },
					success:function(db){
						console.log(db);
						var data ="<span style='color:blue'>" +db.data +"</span>";
						if(db.data == "중복된 아이디가 존재합니다."){
							data = "<span style='color:red'>"+db.data+"</span>"; }
							$("#iddouble").html(data);
						}, error:function(xhr, textStatus, errorThrown){
						$("#iddouble").html(textStatus + "(HTTP-"+xhr.status+"/"+errorThrown);
						}});
					}
			});
	});	
</script>
<div id="main">
	<div class="container text-center" style="height: 100px;">
		<h3 style="color: red;">솔고다에 오신것을 환영합니다.</h3>
		<h5 style="color: black;">솔고다의 모든 온라인/모바일 사이트를 하나의 ID로 이용하실 수 있습니다.</h5>
	</div>	
	<div class="container">
		<div id="nav_createAccount">  
		  <ul class="nav nav-pills">
		    <li class="active"><a data-toggle="pill" href="#adult" style="height: 50px" >만 14세 이상 일반 회원가입</a></li>
		    <li><a data-toggle="pill" href="#children" style="height: 50px">14세 미만 일반 회원가입</a></li>
		  </ul>
	</div> 
	</div>
	<div class="container">
	  <div class="tab-content">
	    <div id="adult" class="tab-pane fade in active">
	      <p>
	      	<div id="mobile">
			<div class="container well">
				<form action="<%=request.getContextPath()%>/createId.do" method="post" id="cre_id">
					<table class="table table-striped">
						<tbody>
							<tr>
							<th scope="row">이름</th>
							<td><input type="text" name="pname" id="pname" style="width: 300px;"
							<%
							if(request.getAttribute("nickname")!=null){
								String name = (String) request.getAttribute("nickname");
								
								%> value="<%=request.getAttribute("nickname")%>" <%	} %>
							
							></td>
						</tr>
						<tr>
							<th scope="row">생년월일</th>
							<td><select name="birthDay_Year" id="birthDay_Year" style="width:100px;">
									<%
									//오늘날짜 가져오기
									Calendar cal = Calendar.getInstance();
									int year = cal.get(cal.YEAR);
									int month = cal.get(cal.MONTH)+1;
									int date = cal.get(cal.DATE);
										out.println("<option value='default' selected disabled hidden>=========</option>");
										for (int i = year; i > 1950; i--) {
										
										out.println("<option value='" + i + "'>" + i + "</option>");
									}
									%>
							</select> <select name="birthDay_Month" id="birthDay_Month" style="width:80px;">
									<%
										out.println("<option value='default' selected disabled hidden>======</option>");
										for (int i = 1; i < 13; i++) {
										if (i < 10) {
											out.println("<option value='" +"0"+ i + "'>" + "0" + i + "</option>");
										} else {
											out.println("<option value='" + i + "'>" + i + "</option>");
										}
									}
									%>
							</select> <select name="birthDay_date" id="birthDay_date" style="width:80px;">
									<%
										out.println("<option value='default' selected disabled hidden>======</option>");
										for (int i = 1; i < 32; i++) {
										if (i < 10) {
											out.println("<option value='" +"0"+ i + "'>" + "0" + i + "</option>");
										} else {
											out.println("<option value='" + i + "'>" + i + "</option>");
										}
									}
									%>
							</select></td>
						<tr>
							<th scope="row">성별</th>
							<td>
								<input type="radio" name="pgender" id="pgender" value="man"><label for="man">남</label> 
								<input type="radio" name="pgender" id="pgender" value="woman"><label for="woman">여</label>
							</td>
						</tr>
						<tr>
							<th scope="row">내외국인</th>
							<td><select id="plocal" name="plocal">
									<option value="local">내국인</option>
									<option value="global">외국인</option>
								</select>
							</td>
						</tr>
						<tr>
							<th scope="row">휴대폰번호</th>
							<td><input type="text" id="pphonenumber1" name="pphonenumber1" style="width: 100px;" maxlength="3" minlength="3">
							<input type="text" id="pphonenumber2" name="pphonenumber2" style="width: 100px;" maxlength="4" minlength="4">
							<input type="text" id="pphonenumber3" name="pphonenumber3" style="width: 100px;" maxlength="4" minlength="4"></td>
						</tr>
						<tr>
							<th scope="row">아이디</th>
							<td><input type="text" id="pid" name="pid"  value="${param.id}" placeholder="6~12 영문+숫자로 여백없이 기입" 
							style="width:300px;"  minlength="6" maxlength="12" > 
							<input type="button" class="btn btn-danger" value="중복확인" id="iddoublechk"><div id="iddouble"></div></td>
						</tr>
						<tr>
							<th scope="row">비밀번호</th>
							<td><input type="password" id="ppass" name="ppass" placeholder="8자 이상 영문+숫자+특수기호 조합" 
							style="width: 300px;" minlength="8"></td>
						</tr>
						<tr>
							<th scope="row">비밀번호재확인</th>
							<td><input type="password" id="passChk" name="passChk"	placeholder="위의 비밀번호를 다시 한번 기입" 
							style="width: 300px;" minlength="8"></td>
						</tr>
						<tr>
							<th scope="row">이메일</th>
							<td><input type="text" id="pemail1" name="pemail1" style="width:100px">
							<span>@</span>
							<input type="text" id="pemail2" name="pemail2" style="width: 200px"></td>
						</tr>
					</tbody>
				</table>
			<div class="text-center">
				<input type="hidden" name="kid" id="kid" value="<%=request.getParameter("kid")%>" />
				<input type="submit" value="회원가입" class="btn btn-danger">
			</div>
		</form>
	</div>
	</div><!--  end container -->
</div><!--  end container -->    
    <div id="children" class="tab-pane fade">
      <div style="margin-top:5%; margin-bottom:5%"><p style="font-size:20px; text-align:center;" >14세 미만은 부모님의 동의없이 가입하실수 없습니다.</p></div>
    </div>
  </div>

	<div class="container well">
		<h4>가입 시 유의사항</h4>
			<strong>안내사항</strong>
			<ol>
				<li>개인정보처리방침과 개인정보3자제공에 동의하지 않으시면 사이트 이용이 불가하오니 양해 부탁 드립니다.</li>
				<li>문자정보서비스 정보 수신 및 이메일 정보 수신에 동의하지 않으셔도 회원 가입은 가능합니다.</li>
				<li>입력하신 인증 정보는 본인 인증에만 사용되며 이외의 용도로 사용 또는 저장되지 않습니다.</li>
				<li>인증이 정상적으로 작동하지 않으면 브라우저의 팝업 차단 기능을 해제하신 후 이용해 주십시오.</li>
			</ol>
				<p>	※ 실명확인 등록 후 보통 48시간 이내에 등록 처리되지만, 서울신용평가 1577-1006 2번 연결 후 상담원을 통해 등록해주시면 좀 더 빠르게 처리됩니다.</p>			
	</div><!-- end container -->
</div>
</div><!--  end id -->


<%@ include file="/inc/footer.jsp"%>