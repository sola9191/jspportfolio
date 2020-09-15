<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file ="/inc/solgoda_header.jsp"%>
<div id="main">
	<div class="container">
			<div class="text-center">
				<h3>솔고다 회원 가입이 완료되었습니다.</h3>		
			</div>			
			<div class="text-center">
				<img style="width:50%"src="<%=request.getContextPath()%>/Account/img/wel.PNG" alt="회원가입을 축하드립니다." />
			</div>
			<div class="text-center" style="margin-top:5%">	
				<p>믿을 수 있는 솔고다 회원가입을 축하합니다.</p>
				<p>이제, 솔고다 회원이 누릴 수 있는  서비스를 확인해보세요.</p>
			</div>

			<div class="form-group text-center" style="margin-top:5%">
				<a href="<%=request.getContextPath()%>/main.do" class="btn btn-primary">홈으로</a>
				<a href="<%=request.getContextPath()%>/login_view.do" class="btn btn-danger">로그인하기</a>			
			</div>
	</div>
</div>
<%@ include file="/inc/footer.jsp" %>



