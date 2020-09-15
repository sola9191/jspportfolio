<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/inc/solgoda_header.jsp" %>
<%@page import="java.sql.*"%>
<%
 	String tmprname = null;
	String rname = null;
    String classname = null; 
	ArrayList<String> rclass = new ArrayList<>(); //데이터받아오는곳
	rclass = (ArrayList<String>) request.getAttribute("candtname"); 
	for(int i = 0; i<rclass.size() ; i++){
		tmprname = rclass.get(0);
		classname = rclass.get(0).substring(rclass.get(0).indexOf('/')+1);
	}
		rname = tmprname.substring(0, tmprname.indexOf('/'));
		
		pageContext.setAttribute("rname", rname);
		pageContext.setAttribute("classname", classname);

%>
<div id="main">
<div class="container"  style="margin-top:5%; min-height:500px">
	<h3>수강후기 상세보기</h3> 					
	<div class="panel" >
	  <div  class="panel-body"> 
	  		<span class="glyphicon glyphicon-plus"> 조회수</span>
	  		<p>${classinfo.rhit}</p>
		</div>	
	</div>	
	<div class="panel"  >
	  <div  class="panel-body">
	  		<span class="glyphicon glyphicon-plus"> 작성자</span> 
			<p>${rname}</p>
		</div>
	</div>
	<div class="panel"  >
	  <div  class="panel-body">
	  	<span class="glyphicon glyphicon-plus"> 수강강의</span> 
	     <p>${classname}</p>
	  </div>	
	</div>	
	<div class="panel"  >
	  <div  class="panel-body">
	  	<span class="glyphicon glyphicon-plus"> 별점</span> 
	     <c:choose>
	     <c:when test="${classinfo.rstar==1}"><p>★</p></c:when>
	     <c:when test="${classinfo.rstar==2}"><p>★★</p></c:when>
	     <c:when test="${classinfo.rstar==3}"><p>★★★</p></c:when>
	     <c:when test="${classinfo.rstar==4}"><p>★★★★</p></c:when>
	     <c:when test="${classinfo.rstar==5}"><p>★★★★★</p></c:when>
	  	 </c:choose>
	  </div>	
	</div>			
	<div class="panel"  >
	  <div  class="panel-body">
	  	<span class="glyphicon glyphicon-plus"> 제목</span> 
	     <p>${classinfo.rtitle}</p>
	  </div>	
	</div>
	<div class="panel"  >
	  <div  class="panel-body">
	  	<span class="glyphicon glyphicon-plus"> 내용</span>
	  	<p style="white-space:pre-wrap">${classinfo.rcontent}</p>
	  </div> 
	</div>	
	<div class="panel"  >
	  <div  class="panel-body">
	  	<span class="glyphicon glyphicon-plus"> 첨부파일</span>
	  	<div></div><img style="width:40%" src="<%=request.getContextPath()%>/upload/${classinfo.rfile}" alt="${classinfo.rfile}" /></div>
	  </div> 
	<div class="text-right"    >
		 <a href="${pageContext.request.contextPath}/chk_view.creview?rno=${classinfo.rno}"  class="btn btn-primary" >수정하기</a> 
		 <a href="${pageContext.request.contextPath}/delete_view.creview?rno=${classinfo.rno}"  class="btn btn-danger" >삭제하기</a>    
		 <a href="${pageContext.request.contextPath}/main.review"  class="btn btn-success" >목록보기</a> 	
	</div>						 
	</div>
</div>	
<%@ include file="/inc/footer.jsp" %>
