<%@page import="com.pagoda.dto.CSBDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file ="/inc/solgoda_header.jsp"%>
<% CSBDto dto = (CSBDto) request.getAttribute("dto"); 
%>
<div id="main">
<div class="container"  style="margin-top:5%; min-height:500px">
	<h3>게시글 상세보기</h3>
		   <fieldset>
			<div class="form-group">
			  <label for="cname"  >작성자</label>
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
				<a href="<%=request.getContextPath()%>/list.service"   class="btn btn-default">목록보기</a>
			</div>
		 </fieldset>		
</div>
</div>
<%@ include file="/inc/footer.jsp"%>