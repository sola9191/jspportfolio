<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file ="/inc/solgoda_header.jsp"%>
<!--  END HEADER -->
<!--  END HEADER -->
<!--  END HEADER -->
<script>	
	jQuery(document).ready(function(){
		jQuery("#writeForm").submit(function(){
			if(jQuery("#nname").val()==""){
				alert("관리자이름을 입력하세요");
				$("#nname").focus();
				return false;
			}
			if(jQuery("#ncate").val()==""){
				alert("카테고리넘버를 입력하세요");
				$("#bpass").focus();
				return false;
			}		
			if(jQuery("#npass").val()==""){
				alert("관리자 전용 비밀번호를 입력하세요");
				$("#npass").focus();
				return false;
			}
			if(jQuery("#ntitle").val()==""){
				alert("제목을 입력하세요");
				$("#ntitle").focus();
				return false;
			}
			if(jQuery("#ncontent").val()==""){
				alert("내용을 입력하세요");
				$("#ncontent").focus();
				return false;
			}

		});
	});
</script>
<div id="main">
<div class="container"  style="margin-top:5%; min-height:500px">
	<h3>공지사항 등록</h3>
		<form action="<%=request.getContextPath()%>/write.notice" method="post"  id="writeForm" >
		   <fieldset>
		   	<div class="form-group">
			  <label for="nname"  >관리자 이름</label>
			  <input type="text"   name="nname"   id="nname"   class="form-control" value="솔고다관리자" > 
			</div>			
			<div class="form-group">
			  <label for="npass"  >관리자 비밀번호</label>
			  <input type="password"   name="npass"   id="npass"   class="form-control" placeholder="관리자 전용 비밀번호를 입력해주세요." > 
			</div>
			<div class="form-group">
			  <label for="ncate">글분류</label>
			  <p>0:일반 / 1:중요 / 2:긴급 </p>
			  <input type="text"   name="ncate"   id="ncate" class="form-control"> 
			</div>													
			<div class="form-group">
			  <label for="ntitle"  >제목</label>
			  <input type="text"   name="ntitle"   id="ntitle"   class="form-control" > 
			</div>	
			<div class="form-group">
			  <label for="ncontent"  >내용</label>
			  <textarea name="ncontent"  id="ncontent"  cols="60"  rows="10"   class="form-control" ></textarea>
			</div>				
			<div class="form-group  text-right">
				<input type="submit"   value="입력"  class="btn btn-danger">  
				<input type="reset"    value="취소"  class="btn btn-primary"    >  
				<a href="<%=request.getContextPath()%>/list.notice"   class="btn btn-success" >목록보기</a>
			</div>
		 </fieldset>		
		</form> <!-- end form -->	
</div>
</div>
<!-- END FOOTER -->
<!-- END FOOTER -->
<!-- END FOOTER -->
<!-- END FOOTER -->
<%@ include  file="/inc/footer.jsp" %>