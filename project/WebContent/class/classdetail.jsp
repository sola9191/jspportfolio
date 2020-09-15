<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file ="/inc/solgoda_header.jsp" %>

<div class="container"  style="margin-top:5%; min-height:500px">
	<h3>강의정보</h3>
	<div class="panel"  >
	  <div  class="panel-body">
	  		<span class="glyphicon glyphicon-plus">작성자</span> 
			<p>${cinfo.classcreator}</p>
		</div>
	</div>
	<div class="panel"  >
	  <div  class="panel-body">
	  		<span class="glyphicon glyphicon-plus">강의카테고리번호</span> 
			<p>${cinfo.classcateno}</p>
		</div>
	</div>
	<div class="panel"  >
	  <div  class="panel-body">
	  		<span class="glyphicon glyphicon-plus">강의카테고리</span> 
			<p>${cinfo.classcategory}</p>
		</div>
	</div>
	<div class="panel"  >
	  <div  class="panel-body">
	  		<span class="glyphicon glyphicon-plus">강의명</span> 
			<p>${cinfo.classname}</p>
		</div>
	</div>
	<div class="panel"  >
	  <div  class="panel-body">
	  		<span class="glyphicon glyphicon-plus">담당강사</span> 
			<p>${tname}</p>
		</div>
	</div>
	<div class="panel"  >
	  <div  class="panel-body">
	  		<span class="glyphicon glyphicon-plus">강의가격</span> 
			<p>${cinfo.classprice}</p>
		</div>
	</div>					
	<div class="panel"  >
	  <div  class="panel-body">
	  		<span class="glyphicon glyphicon-plus">강의시작일</span> 
			<p>${cinfo.classstart}</p>
		</div>
	</div>	
	<div class="panel"  >
	  <div  class="panel-body">
	  		<span class="glyphicon glyphicon-plus">강의종료일</span> 
			<p>${cinfo.classend}</p>
		</div>
	</div>				
	<div class="panel"  >
	  <div  class="panel-body">
	  	<span class="glyphicon glyphicon-plus">강의구성</span> 
	     <p>${cinfo.classcompo}</p>
	  </div>	
	</div>
	<div class="panel"  >
	  <div  class="panel-body">
	  	<span class="glyphicon glyphicon-plus">강의정보</span> 
	     <p style="white-space:pre-wrap;">${cinfo.classdetail}</p>
	  </div>	
	</div>
	<div class="text-right"    >
		<% 
		if(session.getAttribute("pid")!=null){
			if(session.getAttribute("pid").equals("admin")){%>
			
			 <a href="<%=request.getContextPath()%>/edit_view.class?classno=${cinfo.classno}"  class="btn btn-primary" >수정</a> 
			 <input type="button" class="btn btn-danger" id="delete_event" name="delete" value="삭제하기" />  
			 <a href="<%=request.getContextPath()%>/list.class"  class="btn btn-success" >목록보기</a> 
			 
		<%} } else{%>
		
			<button type="button" onclick="history.go(-1)" class="btn btn-danger">뒤로가기</button>
		
		
		<%}%>
		
		
	</div>						 
</div>	
<script>
$(function(){
		$("#delete_event").click(function(){
			var check = confirm("게시글을 삭제하시겠습니까?");			
			if(check==true){
				
				location.href="<%=request.getContextPath()%>/deleteclass.class?classno=${cinfo.classno}";
			}
			else { alert("게시글 삭제를 취소하셨습니다.");}
		});
	});
</script>
<%@ include file ="/inc/footer.jsp"%>