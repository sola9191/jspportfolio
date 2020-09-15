<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file ="/inc/solgoda_header.jsp" %>

<div class="container"  style="margin-top:5%; min-height:500px">
	<h3>선생님정보</h3>
	<div class="panel"  >
	  <div  class="panel-body">
	  		<span class="glyphicon glyphicon-plus">작성자</span> 
			<p>${tinfo.teachercreator}</p>
		</div>
	</div>					
	<div class="panel"  >
	  <div  class="panel-body">
	  		<span class="glyphicon glyphicon-plus">선생님이름</span> 
			<p>${tinfo.teachername}</p>
		</div>
	</div>				
	<div class="panel"  >
	  <div  class="panel-body">
	  	<span class="glyphicon glyphicon-plus">선생님정보</span> 
	     <p>${tinfo.teacherinfo}</p>
	  </div>	
	</div>
	<div class="panel"  >
	  <div  class="panel-body">
	  	<span class="glyphicon glyphicon-plus">선생님강의정보</span> 
	     <p style="white-space:pre-wrap;">아직안함</p>
	  </div>	
	</div>
	  <div class="panel"  >
	  <div  class="panel-body">
	  	<span class="glyphicon glyphicon-plus">선생님사진</span>	  	
	  	<p><img style="width:20%" src="<%=request.getContextPath()%>/upload/${tinfo.teacherimg}" alt="${tinfo.teacherimg}" /></p>
	  </div> 
	</div>	
	<div class="text-right"    >
		
		 <a href="<%=request.getContextPath()%>/edit_view.teacher?tno=${tinfo.teacherno}"  class="btn btn-primary" >수정</a> 
		 <input type="button" class="btn btn-danger" id="delete_event" name="delete" value="삭제하기" />  
		 <a href="<%=request.getContextPath()%>/list.teacher"  class="btn btn-success" >목록보기</a> 
	</div>						 
</div>	
<script>
$(function(){
		$("#delete_event").click(function(){
			var check = confirm("게시글을 삭제하시겠습니까?");			
			if(check==true){
				location.href="<%=request.getContextPath()%>/delete.teacher?teacherno=${tinfo.teacherno}";
			}
			else { alert("게시글 삭제를 취소하셨습니다.");}
		});
	});
</script>
<%@ include file ="/inc/footer.jsp"%>