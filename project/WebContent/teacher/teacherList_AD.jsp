<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file ="/inc/solgoda_header.jsp" %>
<div id="main">
<div class="container"   style="margin-top:5%; min-height:500px">
	<table class="table">
		<caption>TEACHER LIST</caption>
		<thead>
			<tr><th scope="col">No.</th><th scope="col">TeacerName</th>
			<th scope="col">Writer</th><th scope="col">Date</th></tr>
		</thead>
			<c:forEach var="teacherinfo" items="${list}" varStatus="status">
			<tr><td>${list.size()-status.index}</td><td><a href="${pageContext.request.contextPath}/detail.teacher?teacherno=${teacherinfo.teacherno}">${teacherinfo.teachername}</a></td>
			<td>${teacherinfo.teachercreator}</td>
			<c:set var="postdate" value="${teacherinfo.teacherpostdate}"/>
				<td>${fn:substring(postdate,0,16) }</td></tr>
			</c:forEach>
		<tbody>
		</tbody>
	</table>
	<p class="text-right"><a href="<%=request.getContextPath()%>/register_view.teacher" class="btn btn-warning">선생님등록</a></p>
</div>
</div>

<%@ include file ="/inc/footer.jsp"%>