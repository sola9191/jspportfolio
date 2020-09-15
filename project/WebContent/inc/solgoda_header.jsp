<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="com.google.gson.*"%>
<%@ include file="/inc/modal.jsp" %>
<%@ include file="/inc/sidebar.jsp" %>
<!DOCTYPE html>
<html lang ="ko">
<head>
<title>솔고다어학원</title>
 <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
 <link href="<%=request.getContextPath()%>/inc/images/favicon.png" rel="shortcut icon" type="image/x-icon">
 <link href="<%=request.getContextPath()%>/inc/images/favicon.png" rel="icon" 		   type="image/x-icon"> 
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style>
@media (min-width: 768px)
.navbar-nav>li>a {
    padding-top: 30px;
    padding-bottom: 15px;
}
p#logos {    margin-top: 4%;    margin-left:3%;}
img#logo {    width: 30%;}
img#logo2 {    margin-top: 1%;}
img#logo3 {     width: 50%;}
div#line1 {    margin-top: 1%;}
li#bar {    width: 180px;    text-align: center;}
div#line1 {    font-size: 10px;}
.nav>li {    margin-top: -15px;}
a {    margin-top: 5px;}
div#main {    margin-top: 10%;  }
#addClass .container .r1 {	height: 50px;	background-color: #FFE4E1;	color: black;}
#addClass .container .r2 {	height: 300px;	background-color: gray;	color: black;}
#addClass .container .r3 { height: 150px; background-color: #999; color: black; }
#video .container .r1 { height: 250px; background-color: #FFB1BC; }
#video .container .r2 { height: 220px; background-color: #BEEFFF; }
#teachers .container .r1 { height: 150px; background-color: #50B4FF; }
.dropdown-menu>li>a { font-size: 12px; }
select {    height: 30px; }
input[type="search"] {    height: 31px;}
div#line1 {    padding-left: 100px;}
/* 여기서부터 수정합니다~*/
.header_1 .row.r1 {
    padding: 15px 0;
}
.header_1 {
    background-color: white;
}
#line1 .navbar-default .navbar-nav>li>a {
    color: black;
    font-size: 14px;
    /* font-weight: bold; */
    letter-spacing: -2px;
}
.header_2,.header_2 a {
    font-size: 18px;
    font-weight: bold;
    /* line-height: 32px; */
    color: #666;
    
}
.w3-sidebar {
    background-color: black;
    color: white;
    width: 80%;
    left: 10%;
    top: 20%;
    height: 20%;
}
.w3-bar-block .w3-bar-item.subcate {
    width: 14.25%;
    float: left;
    border: 1px solid gray;
    height: 50px;
    text-align: center;
}
.sol_bg.teacher {
    background-color: #000;
    color: white;
    padding-bottom: 131px;
}

.Panel.with.panel-primary {
    box-shadow: 0 0 1px rgb(0 0 0);
}
#nav_createAccount {
    margin-left: 390px;
    margin-top: 1%;
}
#slides { margin-top:3%}
</style>
</head>

<script>
$(function(){
	$("#1").on("click", function(){
		var classcate = $(this).text();
		location.href="<%=request.getContextPath()%>/allList.class?classcate="+classcate;		
	});
	$("#2").on("click", function(){
		var classcate = $(this).text();
		location.href="<%=request.getContextPath()%>/allList.class?classcate="+classcate;		
	});
	$("#3").on("click", function(){
		var classcate = $(this).text();
		location.href="<%=request.getContextPath()%>/allList.class?classcate="+classcate;		
	});
	$("#4").on("click", function(){
		var classcate = $(this).text();
		location.href="<%=request.getContextPath()%>/allList.class?classcate="+classcate;		
	});
	$("#5").on("click", function(){
		var classcate = $(this).text();
		location.href="<%=request.getContextPath()%>/allList.class?classcate="+classcate;		
	});
	$("#6").on("click", function(){
		var classcate = $(this).text();
		location.href="<%=request.getContextPath()%>/allList.class?classcate="+classcate;		
	});
	$("#7").on("click", function(){
		var classcate = $(this).text();
		location.href="<%=request.getContextPath()%>/allList.class?classcate="+classcate;		
	});
});



</script>
<body>
<nav class="navbar navbar-default navbar-fixed-top">
<div id="header">
  <div class="header_1">
	<div class="container">
		<div class="row r1">
			
			<div class="col-sm-5">
				<ul class="nav navbar-nav lnb l1">
					<li><p id="logos"><a href="<%=request.getContextPath()%>/main.do"><img id="logo" 
					src="<%=request.getContextPath()%>/inc/images/solgoda.PNG" alt="솔고다그룹"></a>
					<img id="logo2" src="<%=request.getContextPath()%>/inc/images/winner.png" alt="올해의 교육대상"></p></li>
				</ul>		
			</div>
			<div id="line1" class="col-sm-7">
				<ul class="nav navbar-nav lnb l2" style="font-size: 14px; font-weight: bold;">
	
				<%	
			      	if(session.getAttribute("pid")!=null){
			      		String id = (String) session.getAttribute("pid");
			      		if(id.equals("admin")){ //관리자모드일때 %>
			      		<li><a style="color:blue;" href="<%=request.getContextPath()%>/sogodamember_view.do">회원정보관리</a></li>	
			      		<li><a href="<%=request.getContextPath()%>/logout.do">로그아웃</a></li>
			           	<li><a href="<%=request.getContextPath()%>/list.teacher">선생님관리</a></li>
			           	<li><a href="<%=request.getContextPath()%>/list.class">강의관리</a></li>
			      		<li class="dropdown">
   					<a class="dropdown-toggle" data-toggle="dropdown" href="#">게시판관리<span class="caret"></span></a>
   				    	<ul class="dropdown-menu">
					      <li><a href="<%=request.getContextPath()%>/list.service">자주묻는질문</a></li>
					      <li><a href="<%=request.getContextPath()%>/write_view.consult">1:1문의</a></li>
					      <li><a href="<%=request.getContextPath()%>/list.notice">공지사항</a></li>
					    </ul>
					    </li>
					    	
	 	
			      		 <%}else{ //어드민아니고 다른유저 로그인시%>
			      		
			           	<li><a href="<%=request.getContextPath()%>/logout.do">로그아웃</a></li>		         
			           	<li class="dropdown">
   						<a class="dropdown-toggle" data-toggle="dropdown" href="#">고객센터<span class="caret"></span></a>
   				    	<ul class="dropdown-menu">
					      <li><a href="<%=request.getContextPath()%>/list.service">자주묻는질문</a></li>
					      <li><a href="<%=request.getContextPath()%>/write_view.consult">1:1문의</a></li>
					      <li><a href="<%=request.getContextPath()%>/list.notice">공지사항</a></li>
					    </ul>
					    </li>
						<li class="dropdown">
   						<a class="dropdown-toggle" data-toggle="dropdown" href="#">my<span class="caret"></span></a>
   				    	<ul class="dropdown-menu">
					      <li><a href="<%=request.getContextPath()%>/detail_view.do">내정보관리</a></li> 	
					      </ul>
					      </li>			          	
			           	<li><a href="<%=request.getContextPath()%>/mylecture.do">내강의실</a></li>
			           	<li><a href="<%=request.getContextPath()%>/myCartList.cart">장바구니</a></li>
			           	
			      	<%}
			      	}else{%>
			      	<% pageContext.setAttribute("path", "/login_view.do"); %>
			      		<li><a href="<%=request.getContextPath()%>/login_view.do">로그인</a></li>
			      		<li><a href="<%=request.getContextPath()%>/createId_view.do">회원가입</a></li>	      	
				      	<li class="dropdown">
	   					<a class="dropdown-toggle" data-toggle="dropdown" href="#">고객센터<span class="caret"></span></a>
	   				    	<ul class="dropdown-menu">
						      <li><a href="<%=request.getContextPath()%>/list.service">자주묻는질문</a></li>
						      <li><a href="<%=request.getContextPath()%>/write_view.consult">1:1문의</a></li>
						      <li><a href="<%=request.getContextPath()%>/list.notice">공지사항</a></li>
						    </ul>
						  </li>
						<li class="dropdown">
	   					<a class="dropdown-toggle" data-toggle="dropdown" href="#">my<span class="caret"></span></a>
	   				    	<ul class="dropdown-menu">
						      <li><a href="<%=request.getContextPath()%>/detail_view.do">내정보관리</a></li>
						     </ul>
				      	</li>				      		
				      	 	<li><a href="<%=request.getContextPath()%>/mylecture.do">내강의실</a></li>
				      	 	<li><a href="<%=request.getContextPath()%>/myCartList.cart">장바구니</a></li>
				      				      	
			      	<%}%>
				</ul>	
			</div>
		</div>
	</div><!-- end container -->
	</div><!-- end header1 -->
  <div class="header_2">
	<div class="container">
		<div class="row">
			<div class="col-sm-1"></div>
			<div class="col-sm-10">				
				<ul class="nav navbar-nav" style="padding-top:8px;">
					<li id="bar" style="position:relative"><button class="choosesub" onclick="w3_open()" 
					     style="background-color: black;
						    color: white; position: relative; top: 7px; line-height: 47px; border: 0 none;">&#9776;과목선택</button></li>					
					<li id="bar"><a href="<%=request.getContextPath()%>/solgoda.teacher">선생님소개</a></li>
					<li id="bar"><a href="<%=request.getContextPath()%>/main.review">수강후기</a></li>					
					<li id="bar"><a href="<%=request.getContextPath()%>/findbook.service">도서검색</a></li>	
					<li id="bar" ><a href="<%=request.getContextPath()%>/javaportfolio.do">자바포트폴리오</a></li>		
				</ul>
			</div>
			<div class="col-sm-1"></div>	
		</div>		
	</div>
</div><!-- end header2 -->
</div><!-- end wrap -->
</nav>
