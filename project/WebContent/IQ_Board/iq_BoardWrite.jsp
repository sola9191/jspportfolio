<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file ="/inc/solgoda_header.jsp" %>
<style>
#mainbtn {   width: 100%; }
div#option {   margin-top: 3%; }
.col-sm-3 {   text-align: center; }
div#detail {   margin-top: 5%; }
th#list {    text-align: center; width: 300px; height: 50px; }
input[type="text"] {    width: 450px; }
#option .img { 
    width: 150px;
    height: 150px;}
</style>
<script>
	$(document).ready(function(){
		$("#write_form").submit(function(){
			if($("#iemail").val()==""){
				alert("이메일을 입력해주세요.");
				$("#iemail").focus();
				return false;
			}
			if($("#ititle").val()==""){
				alert("제목을 입력해주세요.");
				$("#ititle").focus();
				return false;
			}
			if($("#icontent").val()==""){
				alert("내용을 입력해주세요.");
				$("#icontent").focus();
				return false;
			}
		});
	});;
</script>

<div id="main">	
	<div class="container">
		<div class="row">
		<h3>1:1문의</h3>
		</div>
		<div class="row">
		<div class="col-sm-6 text-center" >
		<a href="${pageContext.request.contextPath}/write_view.consult" type="button" class="btn btn-danger" id="mainbtn">1:1문의</a>
		</div>
		<div class="col-sm-6 text-center">
		<a href="${pageContext.request.contextPath}/list.consult?pno=${userinfo.pno}" type="button" class="btn btn-default" id="mainbtn">1:1문의 답변확인</a>
		</div>
		</div>
	</div><!-- end container -->
<div id="option">
	<div class="container">
		<div class="row" id="r2">		
			<div class="col-sm-3">
			<img src ="<%=request.getContextPath()%>/IQ_Board/images/pc.PNG" alt="PC원격지원">
			<p><strong>PC원격지원</strong><p>
			<p>PC환경에 다른 사이트 이용 시 문제가 있을 경우 원격지원을 신청해주세요.</p>
			</div>
			
			<div class="col-sm-3">
			<img src ="<%=request.getContextPath()%>/IQ_Board/images/car.PNG" alt="배송조회">
			<p><strong>배송조회</strong><p>
			<p>교재, 기기/노트북 배송 현황을 확인해보세요.</p>
			</div>
			
			<div class="col-sm-3">
			<img src ="<%=request.getContextPath()%>/IQ_Board/images/refund.PNG" alt="환불문의">
			<p><strong>환불문의</strong></p>
			<p>솔고다인강 환불 문의가 있으실 경우 문의해주세요.</p>
			</div>
			
			<div class="col-sm-3">
			<img src ="<%=request.getContextPath()%>/IQ_Board/images/mobile.PNG" alt="모바일기기 관리">
			<p><strong>모바일기기 관리</strong></p>
			<p>기기정보 및 삭제가 필요하실 경우 이용해주세요.</p>

			</div>	
		</div>
	</div><!-- end container -->
</div><!-- end option -->	
<div id="detail">
	<div class="container">
		<form action="${pageContext.request.contextPath}/write.consult" method="post" id="write_form" enctype="multipart/form-data">
			<fieldset>
			<table class="table">
				<tbody>
					<tr><th scope="row" id="list">아이디</th><td><input type="text" name="pid" id="pid" value="${userinfo.pid}" readonly/></td></tr>
					<tr><th scope="row" id="list">휴대폰</th><td><input type="text" name="iphonenumber" 
					id="iphonenumber" value="${userinfo.pphonenumber}" readonly/></td></tr>
					<tr><th scope="row" id="list">이메일</th><td><input type="text" name="iemail" id="iemail" value="${userinfo.pemail}"></td></tr>
					<tr><th scope="row" id="list">제목</th><td><input type="text" name="ititle" id="ititle"></td></tr>
					<tr><th scope="row" id="list">내용</th><td><textarea cols="60"  rows="10" name="icontent" id="icontent"></textarea></td></tr>
					<tr><th scope="row" id="list">첨부파일</th>
					<td><input type="file" name="ifile" id="ifile"></td>
					</tr>
				</tbody>
			</table>
			<div class="form-group text-right">
				<input type="submit" value="등록하기" class="btn btn-danger">
				<a href="<%=request.getContextPath()%>/list.service" class="btn btn-success">자주묻는질문</a>							
			</div>
			</fieldset>
		</form>
	</div>
</div>
</div><!-- end main -->
<%@ include file ="/inc/footer.jsp" %>