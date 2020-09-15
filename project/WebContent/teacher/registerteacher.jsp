<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file ="/inc/solgoda_header.jsp" %>

<script>	
	jQuery(document).ready(function(){
		jQuery("#register_form").submit(function(){
			if(jQuery("#teachercreator").val()==""){
				alert("작성자를 입력해주세요.");
				$("#teachercreator").focus();
				return false;
			}
			if(jQuery("#teachername").val()==""){
				alert("선생님 이름을 입력해주세요.");
				$("#teachername").focus();
				return false;
			}
			if(jQuery("#teacherinfo").val()==""){
				alert("선생님 정보를 입력해주세요.");
				$("#teacherinfo").focus();
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
<div class="container"  style="margin-top:10%; min-height:500px">
		<form action="${pageContext.request.contextPath}/register.teacher" method="post"  id="register_form" 
		enctype="multipart/form-data">
		   <fieldset>
		   <legend>선생님등록</legend>
		   	<div class="form-group">
			  <label for="teachercreator">작성자</label>
			  <input type="text"   name="teachercreator"   id="teachercreator" placeholder="admin" class="form-control" > 
			</div>	
			<div class="form-group">
			  <label for="teachername"  >선생님 이름</label>
			  <input type="text"   name="teachername"   id="teachername"   class="form-control" > 
			</div>			
			<div class="form-group">
			  <label for="teacherinfo">선생님 정보</label>
			  <textarea name="teacherinfo"  id="teacherinfo"  cols="60"  rows="10"   class="form-control" ></textarea>
			</div>	
			<div class="form-group">
			  <label for="teacherimg" >선생님사진</label>
			  <input type="file" name="teacherimg"  id="teacherimg">
			</div>				
			<div class="form-group  text-right">
				<input type="submit"   value="입력"  class="btn btn-primary" >  
				<input type="reset"    value="취소"  class="btn btn-danger"  >  
				<a href="${pageContext.request.contextPath}/list.teacher"   class="btn btn-success"   >목록보기</a>
			</div>
		 </fieldset>		
		</form> <!-- end form -->	
</div>
<%@ include file ="/inc/footer.jsp"%>