<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file ="/inc/solgoda_header.jsp"%>
<div id="main">
<div class="container"  style="margin-top:5%; min-height:500px">
	<h3>공지사항 상세보기</h3>
		   <fieldset>
		   <div class="form-group">
			  <label for="nname"  >관리자 이름</label>
			  <input type="text"   name="nname"   id="nname" value="${dto.nname}"  class="form-control" readonly> 
			</div>	
		   <div class="form-group">
			  <label for="ncate">글분류</label>
			   <p>0:일반 / 1:중요 / 2:긴급 </p>
			  <input type="text"   name="ncate"   id="ncate" class="form-control" value="${dto.ncate}" readonly>
			</div>																				
			<div class="form-group">
			  <label for="ntitle"  >제목</label>
			  <input type="text"   name="ntitle"   id="ntitle" value="${dto.ntitle}"  class="form-control" readonly> 
			</div>	
			<div class="form-group">
			  <label for="ncontent" >내용</label>
			  <textarea name="ncontent"  id="ncontent"  cols="60"  rows="30" class="form-control" readonly>${dto.ncontent}</textarea>
			</div>				
			<div class="form-group  text-right">
				<a href="<%=request.getContextPath()%>/edit_view.notice?nno=${dto.nno}" class="btn btn-danger" >게시글수정</a> 
				<a href="<%=request.getContextPath()%>/delete_view.notice?nno=${dto.nno}" class="btn btn-primary">게시글삭제</a>
				<a href="<%=request.getContextPath()%>/list.notice"   class="btn btn-success">목록보기</a>
			</div>
		 </fieldset>		
</div>
</div>
<%@ include file="/inc/footer.jsp"%>