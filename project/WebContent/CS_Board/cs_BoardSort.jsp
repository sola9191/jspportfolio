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
			<div class="container w3-panel w3-bottombar w3-topbar w3-border-red" style="height:200px">
				<div class="row r1 text-center" style="margin-top:2%">
					<form method="get" action="${pageContext.request.contextPath}/search.service" id="search_form">
						<fieldset>		
							<select id="qamenu" name="qamenu" >
								<option value="0">전체</option>
								<option value="1">수강문의</option>
								<option value="2">환급문의</option>
								<option value="3">결제/환불/변경</option>
								<option value="4">교재/테블릿/상품권</option>
								<option value="5">회원/회원정보</option>
								<option value="6">pc원격지원</option>
								<option value="7">오류문의</option>
								<option value="8">기타</option>								
							</select>
								<input type="text" name="search" id="search" style="width:300px"/>
								<input type="submit" value="검색" class="btn btn-danger"/>
							</fieldset>
						</form>
					</div>		
				
				<div class="row r2 text-center">
					<div class="col-sm-12">
					<div id="r2">
						<a href="${pageContext.request.contextPath}/sort.service?ccategorynum=1" class="w3-button w3-white w3-border w3-border-red w3-round-large" style="width:15%">수강문의</a>
						<a href="${pageContext.request.contextPath}/sort.service?ccategorynum=2" class="w3-button w3-white w3-border w3-border-red w3-round-large" style="width:15%">환급문의</a>
						<a href="${pageContext.request.contextPath}/sort.service?ccategorynum=3" class="w3-button w3-white w3-border w3-border-red w3-round-large" style="width:15%">결제/환불/변경</a>
						<a href="${pageContext.request.contextPath}/sort.service?ccategorynum=4" class="w3-button w3-white w3-border w3-border-red w3-round-large" style="width:15%">교재/테블릿/상품권</a>
					</div>
					</div>
				</div>
				
				<div class="row r3 text-center">
					<div class="col-sm-12">
					<div id="r3">
						<a href="${pageContext.request.contextPath}/sort.service?ccategorynum=5" class="w3-button w3-white w3-border w3-border-red w3-round-large" style="width:15%">회원/회원정보</a>
						<a href="${pageContext.request.contextPath}/sort.service?ccategorynum=6" class="w3-button w3-white w3-border w3-border-red w3-round-large" style="width:15%">PC 원격지원</a>
						<a href="${pageContext.request.contextPath}/sort.service?ccategorynum=7" class="w3-button w3-white w3-border w3-border-red w3-round-large" style="width:15%">오류문의</a>
						<a href="${pageContext.request.contextPath}/sort.service?ccategorynum=8" class="w3-button w3-white w3-border w3-border-red w3-round-large" style="width:15%">기타</a>
					</div>
					</div>
				</div>
		</div><!--  end container -->
		<div class="container">
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

