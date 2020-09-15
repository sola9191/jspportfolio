<%@page import="java.math.BigInteger"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.security.SecureRandom"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file ="/inc/solgoda_header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<style>
 .carousel-inner > .item > img {
      min-width: 70%;
      min-height: 200px;
    } 
input.btn.btn-danger {
    height: 75px;
    width: 80px;
    margin-left: -20%;
}
</style>
<%
	String remember ="";
	String pid="";
	//1. 쿠키값존재확인
	String cookie = request.getHeader("Cookie");

	//2. 쿠기값 가져오기
	if(cookie!=null){
		Cookie [] cookies = request.getCookies();
		for(int i = 0; i<cookies.length; i++){		
			if(cookies[i].getName().equals("remember")){
				remember = cookies[i].getValue();			
				System.out.println(remember);
			}
			if(cookies[i].getName().equals("pid")){
				pid = cookies[i].getValue();
			}
		}	
	}
%>
<script>
	$(document).ready(function(){
		$("#login_form").submit(function(){
			if($("#pid").val()==""){
				alert('아이디를 입력해주세요.');
				$("#pid").focus();
				return false;
			}				
			if($("#ppass").val()==""){
				alert('비밀번호를 입력해주세요.');
				$("#ppass").focus();
				return false;
			}	
		});
	});	
</script>
<div id="main">
	<div class="container">	
		<div class="col-sm-6">
			<div class="row r1">
			<form action="<%=request.getContextPath()%>/login.do" method="post" id="login_form">
			<fieldset>
			<legend>솔고다 계정 로그인</legend>
				<div class="col-sm-7">
				<div class="form-group">
					<input type="text" placeholder="아이디" style="width:250px; height:30px;" name="pid" id="pid"
					<% if(remember.equals("remember")){%> value="<%=pid%>" <%}%>/>
				</div>		
				<div class="form-group">
					<input type="password" placeholder="비밀번호" style="width:250px; height:30px;" name="ppass" id="ppass">
				</div>
				</div>
				<div class="col-sm-5">
				<div class="form-group">
					<input type="submit" class="btn btn-danger" value="로그인" >
				</div>
				</div>
				
				<div class="form-group">
					<input type="checkbox" id="rememberId" name="rememberId" style="width:15px;height:15px; margin-left:3%"
					<%if(remember.equals("remember")){%> checked<%}%>/>
					<label for ="rememberId">아이디저장</label>					
				</div>
				<div class="form-group" style="margin-left:3%">
					<a href="<%=request.getContextPath()%>/findId_view.do" class="btn btn-danger" >아이디/비밀번호찾기</a>
					<a href="<%=request.getContextPath()%>/createId_view.do" class="btn btn-primary">회원가입</a>
				</div>
			</fieldset>
			</form>	
			</div>
			
			<div class="row r2">
			<h3>SNS 로그인</h3>
			<p>
			<a href="https://kauth.kakao.com/oauth/authorize?client_id=9a3ae449dbf7d54fb4151c3a2165a2f1&redirect_uri=http://pa4138.cafe24.com/solgoda/kakaotalkLogin&response_type=code">
				<img src="${pageContext.request.contextPath}/Account/img/kakao.png" alt="카카오톡 로그인">
			</a>		
			</p>
			<%
			    String clientId = "L6KH98yvInrfVK6_AFfw";//애플리케이션 클라이언트 아이디값";
			    String redirectURI = URLEncoder.encode("http://pa4138.cafe24.com/solgoda/naverLogin", "UTF-8");
			    SecureRandom random = new SecureRandom();
			    String state = new BigInteger(130, random).toString();
			    String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
			    apiURL += "&client_id=" + clientId;
			    apiURL += "&redirect_uri=" + redirectURI;
			    apiURL += "&state=" + state;
			    session.setAttribute("state", state);
			 %>
			
			<p>
			<a href="<%=apiURL%>"><img src="${pageContext.request.contextPath}/Account/img/naver_Green.PNG" alt="네이버로그인" style="width:35%">
			</a>
			</p>
			
		</div>
		</div><!--  end col-sm-6 -->
		
		<div class="col-sm-6">
		<%
			String [] slides = {"slide1.jpg", "slide2.jpg", "slide3.jpg", "slide4.jpg", 
					"slide5.jpg", "slide6.jpg", "slide7.jpg"};
			
			pageContext.setAttribute("slides", slides);
		
		%>
		<c:set var="page_total" value="${fn:length(slides)}" />
		<c:set var="page_count" value="${page_total/1}"/>
		<c:set var="page_mod" value="${page_total%1}"/>
		  <div id="slides" class="carousel slide" data-ride="carousel">
		   
		    <ol class="carousel-indicators">
		    <c:forEach begin="0" end ="${page_total-1}" step="1" varStatus="status">
		      <li data-target="#slides" data-slide-to="${status.index}" 
		      style="background-color:white; " <c:if test="${status.first}"> class="active"</c:if> >
		      </li>
		      </c:forEach>
		    </ol> 
		    
		    <div class="carousel-inner">
		    <c:forEach begin="0" end="${page_count}" step="1" var="pic" items="${slides}"  varStatus="status">
		      <div class="item <c:if test="${status.first}"> active </c:if>">
		      	<img style=" width:100%;" src="${pageContext.request.contextPath}/Account/img/${pic}" alt="${pic}" class="img-responsive center-block">
		      </div>
		     </c:forEach>
		    </div>
		
		    <a class="left carousel-control" href="#slides" data-slide="prev">
		      <span class="glyphicon glyphicon-chevron-left"></span>
		      <span class="sr-only"></span>
		    </a>
		    <a class="right carousel-control" href="#slides" data-slide="next">
		      <span class="glyphicon glyphicon-chevron-right"></span>
		      <span class="sr-only"></span>
		    </a>
		  </div> 	
		</div>	
	</div><!-- end container -->
</div><!-- end id main -->
		
	
<%@ include file ="/inc/footer.jsp"%>