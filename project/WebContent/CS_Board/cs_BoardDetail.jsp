<%@page import="com.pagoda.dto.CSBDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file ="/inc/solgoda_header.jsp"%>
<% CSBDto dto = (CSBDto) request.getAttribute("dto"); 
%>
<div id="main">
<div class="container"  style="margin-top:5%; min-height:500px">
	<h3>게시글 상세보기</h3>
		   <fieldset>
		   <legend>WRITE</legend>
		    <c:choose>
		   	   <c:when test="${dto.ccategorynum==1}"><c:set var="cate" value="수강문의" /></c:when>
		   	   <c:when test="${dto.ccategorynum==2}"><c:set var="cate" value="환급문의" /></c:when>
		   	   <c:when test="${dto.ccategorynum==3}"><c:set var="cate" value="결제/환불/변경" /></c:when>
		   	   <c:when test="${dto.ccategorynum==4}"><c:set var="cate" value="교재/테블릿/상품권" /></c:when>
		   	   <c:when test="${dto.ccategorynum==5}"><c:set var="cate" value="회원/회원정보" /></c:when>
		   	   <c:when test="${dto.ccategorynum==6}"><c:set var="cate" value="pc원격지원" /></c:when>
		   	   <c:when test="${dto.ccategorynum==7}"><c:set var="cate" value="오류문의" /></c:when>
		   	   <c:when test="${dto.ccategorynum==8}"><c:set var="cate" value="기타" /></c:when>
			</c:choose>
		   <div class="form-group">
			  <label for="ccategorynum">카테고리</label>
			  <input type="text"   name="ccategorynum"   id="ccategorynum" class="form-control" value="${cate}" readonly/>
			</div>		
			<div class="form-group">
			  <label for="cname"  >관리자 이름</label>
			  <input type="text"   name="cname"   id="cname" value="<%=dto.getCname()%>"  class="form-control" readonly> 
			</div>																	
			<div class="form-group">
			  <label for="ctitle"  >제목</label>
			  <input type="text"   name="ctitle"   id="ctitle" value="<%=dto.getCtitle()%>"  class="form-control" readonly> 
			</div>	
			<div class="form-group">
			  <label for="ccontent" >내용</label>
			  <textarea name="ccontent"  id="ccontent"  cols="60"  rows="30" class="form-control" readonly><%=dto.getCcontent() %></textarea>
			</div>				
			<div class="form-group  text-right">
				<a href="<%=request.getContextPath()%>/edit_view.service?cno=<%=dto.getCno()%>" class="btn btn-default"  style="color:white; background-color:#f4511e">게시글수정</a> 
				<a href="<%=request.getContextPath()%>/delete_view.service?cno=<%=dto.getCno()%>" class="btn btn-default">게시글삭제</a>
				<a href="<%=request.getContextPath()%>/list.service"   class="btn btn-default">목록보기</a>
			</div>
		 </fieldset>		
</div>
</div>
<%@ include file="/inc/footer.jsp"%>