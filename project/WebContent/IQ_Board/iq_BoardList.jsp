<%@page import="com.pagoda.dto.IQBDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file ="/inc/solgoda_header.jsp" %>
<style>
#mainbtn {   width: 100%; }
</style>
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
		<a type="button" class="btn btn-danger" id="mainbtn">1:1문의 답변확인</a>
		</div>
		</div>
	</div><!-- end container -->
	<div class="container">
		<table class="table">
			<caption>일반상담: 솔고다인강에 궁금한 질문 & 답변</caption>
			<thead>
			<tr><th scope="col">진행상태</th><th scope="col">제목</th><th scope="col">등록일</th></tr>
			</thead>
			<tbody>
			<c:forEach var="list" items="${list}" varStatus="status">		
			<tr><td>
			<c:choose>
			<c:when test="${list.iread==0}">읽지않음</c:when>  
			<c:when test="${list.iread==1}">처리중</c:when>  	
			<c:when test="${list.iread==2}">처리완료</c:when>  
			</c:choose>
			</td><td><a href="${pageContext.request.contextPath}/detail_view.consult?ino=${list.ino}">${list.ititle}</a></td><td>${list.idate}</td></tr>		
			</c:forEach>
			</tbody>		
		</table>
	</div>
</div>

<%@ include file ="/inc/footer.jsp" %>