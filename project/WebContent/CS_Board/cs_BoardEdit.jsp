<%@page import="com.pagoda.dto.CSBDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file ="/inc/solgoda_header.jsp"%>
<% CSBDto dto = (CSBDto) request.getAttribute("dto"); %>
<script>	
	jQuery(document).ready(function(){
		jQuery("#writeForm").submit(function(){
			if(jQuery("#bname").val()==""){
				alert("관리자이름을 입력하세요");
				$("#bname").focus();
				return false;
			}
			if(jQuery("#ccategorynum").val()==""){
				alert("카테고리넘버를 입력하세요");
				$("#bpass").focus();
				return false;
			}		
			if(jQuery("#bpass").val()==""){
				alert("관리자 전용 비밀번호를 입력하세요");
				$("#bpass").focus();
				return false;
			}
			if(jQuery("#btitle").val()==""){
				alert("제목을 입력하세요");
				$("#btitle").focus();
				return false;
			}
			if(jQuery("#bcontent").val()==""){
				alert("내용을 입력하세요");
				$("#bcontent").focus();
				return false;
			}
		});
	});
</script>
<div id="main">
<div class="container"  style="margin-top:5%; min-height:500px">
	<h3>게시글 수정하기</h3>
		<form action="<%=request.getContextPath()%>/edit.service?cno=<%=dto.getCno()%>" method="post"  id="editForm" >
		   <fieldset>
		   <legend>EDIT</legend>
			<div class="form-group">
			  <label for="cname"  >관리자 이름</label>
			  <input type="text"   name="cname"   id="cname" value="<%=dto.getCname()%>"  class="form-control" readonly> 
			</div>			
			<div class="form-group">
			  <label for="cpass"  >관리자 비밀번호</label>
			  <input type="password"   name="cpass"   id="cpass" placeholder="관리자 비밀번호를 입력해주세요."  class="form-control" > 
			</div>
			<div class="form-group">
			  <label for="ccategorynum">카테고리Number</label>
			  <input type="text"   name="ccategorynum"   id="ccategorynum" value="<%=dto.getCcategorynum()%>" class="form-control" > 
			</div>																	
			<div class="form-group">
			  <label for="ctitle"  >제목</label>
			  <input type="text"   name="ctitle"   id="ctitle" value="<%=dto.getCtitle()%>"  class="form-control" > 
			</div>	
			<div class="form-group">
			  <label for="ccontent" >내용</label>
			  <textarea name="ccontent"  id="ccontent"  cols="60"  rows="10" class="form-control" ><%=dto.getCcontent()%></textarea>
			</div>				
			<div class="form-group  text-right">
				<input type="submit" class="btn btn-default" value="수정하기" style="color:white; background-color:#f4511e"> 
				<input type="reset" class="btn btn-default" value="취소">
				<a href="<%=request.getContextPath()%>/list.service"   class="btn btn-default">목록보기</a>
			</div>
		 </fieldset>		
		</form> <!-- end form -->	
</div>
</div>
<%@ include file="/inc/footer.jsp"%>