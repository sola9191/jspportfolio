<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file ="/inc/solgoda_header.jsp" %>
<div id="main">
<div class="container">
	<h3>강의목록</h3>
	<table  class="table table-hover">
		<thead>
			<tr><th scope="col">No.</th>
			<th scope="col">강의카테고리</th><th scope="col">강의명</th>
			<th scope="col">강의시작일</th><th scope="col">강의종료일</th></tr>
		</thead>
			<c:forEach var="clist" items="${list}" varStatus="status">
			<tr><td>${status.count}</td>
			<td>${clist.classcategory}</td><td><a href="${pageContext.request.contextPath}/detail.class?classno=${clist.classno}">${clist.classname}</a></td>
			 <c:set var="start" value="${clist.classstart}"/>
				<td>${fn:substring(start,0,10) }</td>
			 <c:set var="end" value="${clist.classend}"/>
				<td>${fn:substring(end,0,10) }</td>
				</tr>
			</c:forEach>
		<tbody>
		</tbody>
	</table>
</div>
</div>
<%@ include file ="/inc/footer.jsp"%>