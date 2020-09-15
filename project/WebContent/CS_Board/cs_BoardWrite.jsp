<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file ="/inc/solgoda_header.jsp"%>
<!--  END HEADER -->
<!--  END HEADER -->
<!--  END HEADER -->
<script>	
	jQuery(document).ready(function(){
		jQuery("#writeForm").submit(function(){
			if(jQuery("#bname").val()==""){
				alert("관리자이름을 입력하세요");
				$("#bname").focus();
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
			if(jQuery("#bpass").val()=="1234"){
				alert("관리자 전용 비밀번호를 입력하세요");
				$("#bpass").focus();
				return false;
			}
		});
	});
</script>
<div id="main">
<div class="container"  style="margin-top:5%; min-height:500px">
	<h3>게시글등록</h3>
		<form action="<%=request.getContextPath()%>/write.service" method="post"  id="writeForm" >
		   <fieldset>
		   	<div class="form-group">
			  <label for="cname"  >관리자 이름</label>
			  <input type="text"   name="cname"   id="cname"   class="form-control" value="솔고다관리자" > 
			</div>			
			<div class="form-group">
			  <label for="cpass"  >관리자 비밀번호</label>
			  <input type="password"   name="cpass"   id="cpass"   class="form-control" placeholder="관리자 전용 비밀번호를 입력해주세요." > 
			</div>
			<div class="form-group">
			  <label for="ccategorynum">카테고리Number</label>
			  <p>1:수강문의  2:환급문의  3:결제/환불/변경  4:교재/테블릿/상품권  5:회원/회원정보  6:PC 원격지원  7:오류문의  8:기타 
			  <input type="text"   name="ccategorynum"   id="ccategorynum" class="form-control"> 
			</div>	
			<!--  생략
			<div class="form-group">
				<label for="ccategory">카테고리</label>
				<div>
				<select id="ccategory" name="ccategory">
					<option value ="default" selected>전체</option>
					<option value="qam1">수강문의</option>
					<option value="qam2">환급문의</option>
					<option value="qam3">결제/환불/변경</option>
					<option value="qam4">교재/테블릿/상품권</option>
					<option value="qam5">회원/회원정보</option>
					<option value="qam6">pc원격지원</option>
					<option value="qam7">오류문의</option>
					<option value="qam8">기타</option>					
				</select>
				</div>	
			</div>	
			-->														
			<div class="form-group">
			  <label for="ctitle"  >제목</label>
			  <input type="text"   name="ctitle"   id="ctitle"   class="form-control" > 
			</div>	
			<div class="form-group">
			  <label for="ccontent"  >내용</label>
			  <textarea name="ccontent"  id="ccontent"  cols="60"  rows="10"   class="form-control" ></textarea>
			</div>				
			<div class="form-group  text-right">
				<input type="submit"   value="입력"  class="btn btn-default"  style="color:white; background-color:#f4511e"   >  
				<input type="reset"    value="취소"  class="btn btn-default"    >  
				<a href="<%=request.getContextPath()%>/list.service"   class="btn btn-default"   >목록보기</a>
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