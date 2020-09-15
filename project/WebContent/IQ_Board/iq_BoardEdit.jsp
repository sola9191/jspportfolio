<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file ="/inc/solgoda_header.jsp" %>
<style>
#mainbtn {   width: 100%; }
#detail { margin-top:2% }
</style>
<script>
	$(document).ready(function(){
		$("#edit_form").submit(function(){
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
	});
</script>
<div id="main">
	<div class="container">
		<div class="row">
		<h3>1:1문의</h3>
		</div>
		<div class="row">
		<div class="col-sm-6 text-center" >
		<a href="${pageContext.request.contextPath}/write_view.consult" type="button" class="btn btn-default" id="mainbtn">1:1문의</a>
		</div>
		<div class="col-sm-6 text-center">
		<a href="${pageContext.request.contextPath}/list.consult?pno=${userinfo.pno}" type="button" class="btn btn-danger" id="mainbtn">1:1문의 답변확인</a>
		</div>
		</div>
	</div><!-- end container -->
	<div id="detail">
	<div class="container">
		<h4>글상세보기</h4>
			<form action ="${pageContext.request.contextPath}/edit.consult?ino=${dto.ino}" method="post" id="edit_form"
			enctype="multipart/form-data">
			<fieldset>
			<div class="row r1">			
			<table class="table">
				<tbody>
					<tr><th scope="row" id="list">이름</th><td>${userinfo.pid}</td></tr>
					<tr><th scope="row" id="list">휴대폰</th><td>${userinfo.pphonenumber}</td></tr>
					<tr><th scope="row" id="list">이메일</th><td>
					<Input type="text" name="iemail" id="iemail" value="${dto.iemail}"/></td></tr>
					<tr><th scope="row"  id="list">제목</th><td>
					<Input type="text" name ="ititle" id="ititle" value="${dto.ititle}" /></td></tr>
					<tr><th scope="row"  id="list">내용</th><td>
					<textarea cols="60"  rows="10" name="icontent" id="icontent">${dto.icontent}</textarea></td></tr>
					<tr><th scope="row" id="list">첨부파일</th><td>
					<input type="file" id="ifile" name="ifile" /></td>
					</tr>
				</tbody>
			</table>
			</div>
			<div class="row r2 text-right">	
				<input type="submit" class="btn btn-info" value="수정하기" />
				<a href="${pageContext.request.contextPath}/detail_view.consult?ino=${dto.ino}" class="btn btn-warning">취소</a>
			</div>
			</fieldset>
			</form>
		</div>
	</div>
</div>

<%@ include file ="/inc/footer.jsp" %>