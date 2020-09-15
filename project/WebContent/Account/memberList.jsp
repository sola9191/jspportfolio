<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file ="/inc/solgoda_header.jsp" %>
<div id="main">
<div class="container">
	<h3>회원목록</h3>
	<table  class="table table-hover">
		<thead>
			<tr>
			<th scope="col">No.</th>
			<th scope="col">회원번호</th>
			<th scope="col">아이디</th>
			<th scope="col">회원이름</th>			
			<th scope="col">전화번호</th>
			<th scope="col">내/외국인</th>
			<th scope="col">이메일주소</th>
			<th scope="col">가입날짜</th>
			</tr>
		</thead>
			<c:forEach var="memberlist" items="${dto}" varStatus="status">
			<tr>
			<td>${dto.size()-status.index}</td>
			<td>${memberlist.pno}</td>
			<td>${memberlist.pid}</td>			
			<td>${memberlist.pname}</td>		
			<td>${memberlist.pphonenumber}</td>
			<td>${memberlist.plocal}</td>
			<td>${memberlist.pemail}</td>
			<td>${memberlist.pdate}</td>
			</tr>
			</c:forEach>
		<tbody>
		</tbody>
	</table>
</div>
</div>
<%@ include file ="/inc/footer.jsp"%>