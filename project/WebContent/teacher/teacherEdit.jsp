<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file ="/inc/solgoda_header.jsp" %>

<div class="container"  style="margin-top:10%; min-height:500px">
		<form action="${pageContext.request.contextPath}/edit.teacher?teacherno=${tinfo.teacherno}" method="post"  id="edit_Form" enctype="multipart/form-data">
		   <fieldset>
		   <legend>정보수정</legend>
		   	<div class="form-group">
			  <label for="teachercreator">작성자</label>
			  <input type="text"   name="teachercreator"   id="teachercreator" value="${tinfo.teachercreator}" class="form-control" > 
			</div>	
			<div class="form-group">
			  <label for="teachername"  >선생님 이름</label>
			  <input type="text"   name="teachername"   id="teachername"  value="${tinfo.teachername}" class="form-control" > 
			</div>			
			<div class="form-group">
			  <label for="teacherinfo">선생님 정보</label>
			  <textarea name="teacherinfo"  id="teacherinfo"  cols="60"  rows="10"   class="form-control" >${tinfo.teacherinfo}</textarea>
			</div>	
			<div class="form-group">
			  <label for="teacherimg" >선생님사진</label>
			  <input type="file" name="teacherimg"  id="teacherimg">
			</div>
			<div class="form-group  text-right">
				<input type="submit"   value="입력"   class="btn btn-primary"  >  
				<input type="reset"    value="취소"  class="btn btn-danger"    >  
				<a href="${pageContext.request.contextPath}/list.teacher"   class="btn btn-success">목록보기</a>
			</div>
		 </fieldset>		
		</form> <!-- end form -->	
</div>
<script>	
	jQuery(document).ready(function(){
		jQuery("#editForm").submit(function(){
			if(jQuery("#bpass").val()==""){
				alert("비밀번호를 입력하세요");
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
<!-- END FOOTER -->
<!-- END FOOTER -->
<!-- END FOOTER -->
<!-- END FOOTER -->
<%@ include  file="/inc/footer.jsp" %>