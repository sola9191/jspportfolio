<%@page import="com.pagoda.dto.CSBDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<script>
	$(document).ready(function(){
		$("#search_form").submit(function(){
			if($("#search").val()==""){
				alert("검색을 원하시는 단어를 입력해주세요.");	
				return false;
			}
		});
	});

</script>
<div id="main">
		<div class = "container">
			<h3>자주 묻는 질문</h3>
		</div>
			<div class="container well" style="height:200px">
				<div class="row r1 text-center">
					<form method="get" action="${pageContext.request.contextPath}/search.service" id="search_form">
						<fieldset>		
							<select id="qamenu" name="qamenu" >
								<option value ="default" selected>전체</option>
								<option value="qam1">수강문의</option>
								<option value="qam2">환급문의</option>
								<option value="qam3">결제/환불/변경</option>
								<option value="qam4">교재/테블릿/상품권</option>
								<option value="qam5">회원/회원정보</option>
								<option value="qam6">pc원격지원</option>
								<option value="qam7">오류문의</option>
								<option value="qam8">기타</option>					
							</select>
								<input type="text" name="search" id="search" style="width:300px"/>
								<input type="submit" value="검색" class="btn btn-danger"/>
							</fieldset>
						</form>
					</div>		
				
				<div class="row r2 text-center">
					<div class="col-sm-12">
					<div id="r2">
						<a href="${pageContext.request.contextPath}/sort.service?ccategorynum=1" class="btn btn-default" id="btn1">수강문의</a>
						<a href="${pageContext.request.contextPath}/sort.service?ccategorynum=2" class="btn btn-default" id="btn2">환급문의</a>
						<a href="${pageContext.request.contextPath}/sort.service?ccategorynum=3" class="btn btn-default" id="btn3">결제/환불/변경</a>
						<a href="${pageContext.request.contextPath}/sort.service?ccategorynum=4" class="btn btn-default" id="btn4">교재/테블릿/상품권</a>
					</div>
					</div>
				</div>
				
				<div class="row r3 text-center">
					<div class="col-sm-12">
					<div id="r3">
						<a href="${pageContext.request.contextPath}/sort.service?ccategorynum=5" class="btn btn-default">회원/회원정보</a>
						<a href="${pageContext.request.contextPath}/sort.service?ccategorynum=6" class="btn btn-default">PC 원격지원</a>
						<a href="${pageContext.request.contextPath}/sort.service?ccategorynum=7" class="btn btn-default">오류문의</a>
						<a href="${pageContext.request.contextPath}/sort.service?ccategorynum=8" class="btn btn-default">기타</a>
					</div>
					</div>
				</div>
		</div><!--  end container -->
		<div class="container well">
			<table class="table table-striped">
				<thead>
					<tr>
					<td scope="col">NO.</td>
					<td scope="col">제목</td>		
					</tr>	
				</thead>
				<tbody>
					<c:forEach var="list" items="${list}" varStatus="status">
					<tr><td>${status.count}</td><td><a href="${pageContext.request.contextPath}/detail_view.service?cno=${list.cno}">${list.ctitle}</a></td></tr>
					</c:forEach>				
				</tbody>
			</table>	
			<% 
				HttpSession s = request.getSession(); 
			   if(s.getAttribute("pid")!=null){
				   if(((String)s.getAttribute("pid")).equals("admin")){%>
					   <p class="text-right"><a href="<%=request.getContextPath()%>/write_view.service" class="btn btn-danger">관리자글쓰기</a></p><%}
				   else {%><p class="text-right"><a href="<%=request.getContextPath()%>/write_view.consult" class="btn btn-default">1:1문의하기</a></p> <%} 
			   }%>										
				
		</div>
</div>
<%@ include file = "/inc/footer.jsp"%>

