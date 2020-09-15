<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file ="/inc/solgoda_header.jsp" %>
<div id="main">
<div class="container"   style="margin-top:5%; min-height:500px">
	<table  class="table">
		<caption>CLASS LIST</caption>
		<thead>
			<tr><th scope="col">No.</th><th scope="col">카테고리넘버</th>
			<th scope="col">강의카테고리</th><th scope="col">강의명</th>
			<th scope="col">강의시작일</th><th scope="col">강의종료일</th></tr>
		</thead>
			<c:forEach var="clist" items="${list}" varStatus="status">
			<tr><td>${list.size()-status.index}</td><td>${clist.classcateno}</td>
			<td>${clist.classcategory}</td><td><a href="${pageContext.request.contextPath}/detail.class?classno=${clist.classno}">${clist.classname}</a></td>
			<td>${clist.classstart}</td><td>${clist.classend}</td><td></tr>
			</c:forEach>
		<tbody>
		</tbody>
	</table>
	<p class="text-right"><a href="<%=request.getContextPath()%>/create_view.class" class="btn btn-warning">강의등록</a></p>
</div>
</div>
<%@ include file ="/inc/footer.jsp"%>