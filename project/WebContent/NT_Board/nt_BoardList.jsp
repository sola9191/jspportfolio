<%@page import="com.pagoda.dto.NTBDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ include file ="/inc/solgoda_header.jsp"%>

<style>
#r2 a.btn.btn-default {
	width: 150px;
    height: 40px;
}
#r3 a.btn.btn-default {
	width: 150px;
    height: 40px;
}
</style>
<div id="main">
		<div class = "container">
			<h3>공지사항</h3>
		</div>
		<div class="container well">
			<table class="table table-striped">
				<thead>
					<tr>
					<td scope="col">분류</td>
					<td scope="col">제목</td>	
					<td scope="col">글쓴이</td>	
					<td scope="col">날짜</td>			
					</tr>	
				</thead>
				<tbody>
					<c:forEach var="list" items="${list}" varStatus="status">
					<tr>
					<td>
					<c:if test="${list.ncate==0}"><span style="color:black;" class="glyphicon glyphicon-bullhorn"></span></c:if>	
					<c:if test="${list.ncate==1}"><span style="color:black;" class="glyphicon glyphicon-wrench"></span></c:if>
					<c:if test="${list.ncate==2}"><span style="color:red;" class="glyphicon glyphicon-star"></span></c:if>
					</td>
					<td><a href="${pageContext.request.contextPath}/detail_view.notice?nno=${list.nno}">${list.ntitle}</a></td>
					<td>${list.nname}</td>
					<td>
					<c:set var = "ndate" value ="${list.ndate}"/>
				    <c:set var = "simplendate" value = "${fn:substring(ndate, 0 , 10)}" />
					${simplendate}</td></tr>
					</c:forEach>				
				</tbody>
			</table>	
			<% 
				HttpSession s = request.getSession(); 
			   if(s.getAttribute("pid")!=null){
				   if(((String)s.getAttribute("pid")).equals("admin")){%>
					   <p class="text-right"><a href="<%=request.getContextPath()%>/write_view.notice" class="btn btn-warning">관리자글쓰기</a></p><%} }%>
		</div>
</div>
<%@ include file = "/inc/footer.jsp"%>

