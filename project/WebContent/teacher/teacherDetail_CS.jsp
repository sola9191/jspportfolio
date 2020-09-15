<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/inc/solgoda_header.jsp"%>

<div id="main">
	<div class="wrap">
	<div class="container">
	<div class="col-sm-7">
		<h2 style="font-weight:bold;">${teacherinfo.teachername}</h2>
		<p style=white-space:pre-wrap;>${teacherinfo.teacherinfo}</p>
	</div>
	<div class="col-sm-5" >
		<img style="height:300px" src="<%=request.getContextPath()%>/upload/${teacherinfo.teacherimg}" alt="${teacherinfo.teacherimg}" >
	</div>

	</div>
	<div class="container" style="margin-top:2%">
		<table class="table">
			<caption style="font-size:20px">담당강의</caption>
			<thead>
			<tr><th scope="col">강의카테고리</th><th scope="col">강의명</th><th scope="col">강의시작일</th>
			<th scope="col">강의종료일</th><th scope="col">강의가격</th></tr>
			</thead>
			<tbody>
			<c:forEach var="cinfo" items="${classinfo}" varStatus="status">
			<c:set var="startdate" value="${cinfo.classstart}"/>
			<c:set var="enddate" value="${cinfo.classend}"/>
			<tr><td>${cinfo.classcategory}</td><td><a href="${pageContext.request.contextPath}/detail.class?classno=${cinfo.classno}">${cinfo.classname}</a></td><td>${fn:substring(startdate,0,10)}</td>
			<td>${fn:substring(enddate,0,10)}</td><td>${cinfo.classprice}원</td></tr>
			</c:forEach>
			</tbody>
		</table>	
	</div>
	
	</div><!-- end main -->
</div><!-- end wrap -->

<%@ include file="/inc/footer.jsp" %>