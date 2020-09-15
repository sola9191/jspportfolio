<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file ="/inc/solgoda_header.jsp"%>
<div id="main">
	<div class="container">
		<h3>아이디찾기</h3>
		<pre>고객님의 ID는 ${tmpId} 입니다.</pre>
		<div class="text-center" style="margin-top:5%">
			<a href="<%=request.getContextPath()%>/main.do" class="btn btn-primary">홈으로가기</a>
			<a href="<%=request.getContextPath()%>/findId_view.do" class="btn btn-success">비밀번호찾기</a>
			<a href="<%=request.getContextPath()%>/login_view.do" class="btn btn-danger">로그인하기</a>
		</div>
	</div>
</div>
<%@include file="/inc/footer.jsp" %>