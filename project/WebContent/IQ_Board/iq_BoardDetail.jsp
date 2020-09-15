<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file ="/inc/solgoda_header.jsp" %>
<style>
#mainbtn {   width: 100%; }
#detail { margin-top:2% }
</style>
<script>
	$(function(){
		$("#delete_event").click(function(){
			var check = confirm("게시글을 삭제하시겠습니까?");			
			if(check==true){
				location.href="<%=request.getContextPath()%>/delete.consult?ino=${dto.ino}";
			}
			else { alert("게시글 삭제를 취소하셨습니다.");}
		});
	});

</script>
<div id="main">
	<div class="container">
		<div class="row">
		<h3>1:1문의</h3>
		</div>
		<div class="row">
		<div class="col-sm-6 text-center" >
		<a href="${pageContext.request.contextPath}/write_view.consult" type="button" class="btn btn-default" id="mainbtn">1:1문의</a>
		</div>
		<div class="col-sm-6 text-center">
		<a href="${pageContext.request.contextPath}/list.consult?pno=${userinfo.pno}" type="button" class="btn btn-danger" id="mainbtn">1:1문의 답변확인</a>
		</div>
		</div>
	</div><!-- end container -->
	<div id="detail">
	<div class="container">
		<h4>글상세보기</h4>
			<div class="row r1">
			<table class="table">
				<tbody>
					<tr><th scope="row" id="list">아이디</th><td>${userinfo.pid}</td></tr>
					<tr><th scope="row" id="list">휴대폰</th><td>${userinfo.pphonenumber}</td></tr>
					<tr><th scope="row" id="list">이메일</th><td>${dto.iemail}</td></tr>
					<tr><th scope="row" id="list">제목</th><td>${dto.ititle}</td></tr>
					<tr><th scope="row" id="list">내용</th><td><textarea cols="60"  rows="10" readonly>${dto.icontent}</textarea></td></tr>
					<tr><th scope="row" id="list">첨부파일</th><td><p style=white-space:pre-wrap;><img src="/upload/${dto.ifile}" alt="${dto.ifile}"/></p></td>
					</tr>
				</tbody>
			</table>
			</div>
			<div class="row r2 text-right">	
	<% 
		HttpSession s = request.getSession(); 
	   	if(s.getAttribute("pid")!=null){
		   if(((String)s.getAttribute("pid")).equals("admin")){%>
			   <a href="${pageContext.request.contextPath}/reply_view.consult?ino=${dto.ino}" class="btn btn-success">답변달기</a><%} }%>	
				<a href="${pageContext.request.contextPath}/edit_view.consult?ino=${dto.ino}" class="btn btn-info">수정하기</a>
				<input type="button" class="btn btn-danger" id="delete_event" name="delete" value="삭제하기" />
				<a href="${pageContext.request.contextPath}/list.consult?pno=${userinfo.pno}" class="btn btn-warning">목록으로</a>	
			</div>
		</div>
	</div>
</div>

<%@ include file ="/inc/footer.jsp" %>