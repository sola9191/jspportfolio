<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file ="/inc/solgoda_header.jsp" %>

<script>	
	jQuery(document).ready(function(){
		jQuery("#edit_form").submit(function(){
			if(jQuery("#classcreator").val()==""){
				alert("작성자를 입력해주세요.");
				$("#teachercreator").focus();
				return false;
			}
			if(jQuery("#classcateno").val()==""){
				alert("강의카테고리번호를 선택해주세요.");
				$("#classcateno").focus();
				return false;
			}
			if(jQuery("#classname").val()==""){
				alert("강의명을 입력해주세요");
				$("#classname").focus();
				return false;
			}
			if(jQuery("#teachername").val()==""){
				alert("선생님을 선택해주세요.");
				$("#bcontent").focus();
				return false;
			}
			if(jQuery("#classprice").val()==""){
				alert("강의가격을 입력해주세요.");
				$("#classprice").focus();
				return false;
			}
			if(jQuery("#classstart").val()==""){
				alert("강의시작일을 입력해주세요.");
				$("#classstart").focus();
				return false;
			}
			if(jQuery("#classend").val()==""){
				alert("강의종료일을 입력해주세요.");
				$("#classend").focus();
				return false;
			}
			if(jQuery("#classcompo").val()==""){
				alert("강의구성을 입력해주세요.");
				$("#classcompo").focus();
				return false;
			}
			if(jQuery("#classdetail").val()==""){
				alert("강의정보를 입력해주세요.");
				$("#classdetail").focus();
				return false;
			}
		});
	});
	$(document).ready(function(){
		$("#classcateno").on("click", function(){
		$.ajax({url:"${pageContext.request.contextPath}/AJAX_Classcate"
			, type:"get"
			, dataType:"json"
			, data : { "cateno" : $("#classcateno").val() }
			, success:function( list ){
				console.log(list.data);
				$("#classcategory").val(list.data);				
			}, error:function(xhr, textStatus, errorThrown) {
				$("#test").html(textStatus + "(HTTP-" + xhr.status + "/"+errorThrown);
			}
		});		
	});
});
</script>
<div class="container"  style="margin-top:10%; min-height:500px">
		<form action="${pageContext.request.contextPath}/create.class" method="post"  id="edit_form">
		   <fieldset>
		   <legend>강의등록</legend>
		   	<div class="form-group">
			  <label for="classcreator">작성자</label>
			  <input type="text"   name="classcreator"   id="classcreator" placeholder="admin" class="form-control" > 
			</div>							
			<div class="form-group">
			  <label for="classcateno">강의카테고리번호</label>
			   <input type="number"   name="classcateno"   id="classcateno"   class="form-control" min="1" max="7"> 
			</div>	
			<div class="form-group">
			  <label for="classcategory">강의카테고리</label>
			   <input type="text"   name="classcategory"   id="classcategory"   class="form-control"  readonly> 
			</div>	
			<div class="form-group">
			  <label for="classname"  >강의명</label>
			  <input type="text"   name="classname"   id="classname"   class="form-control" > 
			</div>
			<div class="form-group">
			  <label for="teachername">담당강사</label>
			<select class="form-control" id="teachername" name="teachername">
			<c:forEach var="tlist" items="${teacherlist}" varStatus="status" >
        		<option>${tlist.teacherno}. ${tlist.teachername}</option>
			</c:forEach>        		
        	</select>
			</div>	
			<div class="form-group">
			  <label for="classprice">강의가격</label>
			  <input type="text"   name="classprice"   id="classprice"   class="form-control" > 
			</div>
			<div class="form-group">
			  <label for="classstart">강의시작일</label>
			  <input type="date"   name="classstart"   id="classstart"   class="form-control" > 
			</div>
			<div class="form-group">
			  <label for="classend">강의종료일</label>
			  <input type="date"   name="classend"   id="classend"   class="form-control" >
			</div>
			<div class="form-group">
			  <label for="classcompo">강의구성</label>
			   <input type="text"   name="classcompo"   id="classcompo"   class="form-control" > 
			</div>	
			<div class="form-group">
			  <label for="classdetail">강의정보</label>
			  	<textarea name="classdetail"  id="classdetail"  cols="60"  rows="10"   class="form-control" ></textarea>
			</div>
			<div class="form-group  text-right">
				<input type="submit"   value="입력"  class="btn btn-primary" >  
				<input type="reset"    value="취소"  class="btn btn-danger"  >
				<a href="${pageContext.request.contextPath}/list.class"   class="btn btn-success"   >목록보기</a>
			</div>
		 </fieldset>		
		</form> <!-- end form -->			
</div>
<%@ include file ="/inc/footer.jsp"%>