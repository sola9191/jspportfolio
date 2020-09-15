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
		$("#reply_form").submit(function(){
			if($("#pid").val()==""){
				alert("아이디를 입력해주세요.");
				$("#pid").focus();
				return false;
			}
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
		<h3>1:1문의글 답변수정</h3>
		</div>
		<div class="row">
		<div class="col-sm-6 text-center" >
		<a href="${pageContext.request.contextPath}/write_view.consult" type="button" class="btn btn-default" id="mainbtn">1:1문의</a>
		</div>
		<div class="col-sm-6 text-center">
		<a href="${pageContext.request.contextPath}/list.consult" type="button" class="btn btn-danger" id="mainbtn">1:1문의 답변확인</a>
		</div>
		</div>
	</div><!-- end container -->
<div id="detail">
	<div class="container">
		<form action="${pageContext.request.contextPath}/edit_AD.consult?ino=${dto.ino}" method="post" id="reply_form">
			<fieldset>
			<table class="table">
				<tbody>
					<tr><th scope="row" id="list">처리상태</th><td>
					<select name="iread" id="iread">
					<option value="1">처리중</option>
					<option value="2">처리완료</option>
					</select>
					<tr><th scope="row" id="list">이름</th><td><input type="text" name="pid" id="pid" value="솔고다관리자" readonly></td></tr>
					<tr><th scope="row" id="list">이메일</th><td><input type="text" name="iemail" id="iemail" value="admin@solgoda.com" readonly></td></tr>
					<tr><th scope="row" id="list">제목</th><td><input type="text" name="ititle" id="ititle" value="${dto.ititle}"></td></tr>
					<tr><th scope="row" id="list">내용</th><td><textarea cols="60"  rows="10" name="icontent" id="icontent">${dto.icontent}</textarea></td></tr>
				</tbody>
			</table>
			<div class="form-group text-right">
				<input type="submit" value="등록하기" class="btn btn-info">
				<a href="javascript:history.go(-1);" class="btn btn-danger">등록취소</a>							
			</div>
			</fieldset>
		</form>
	</div>
</div>
</div><!-- end main -->
<%@ include file ="/inc/footer.jsp" %>