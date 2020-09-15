<%@page import="com.pagoda.dto.RBDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file ="/inc/solgoda_header.jsp"%>
<div id="main">
	<div class="container">
		<h3>수강후기게시판</h3>
		  <div id="slides" class="carousel slide" data-ride="carousel" data-interval="false">	   
		    <ol class="carousel-indicators">
		    <c:forEach begin="0" end ="1" step="1" varStatus="status">
		      <li data-target="#slides" data-slide-to="${status.index}" 
		      style="background-color:white; " <c:if test="${status.first}"> class="active"</c:if> >
		      </li>
		      </c:forEach>
		    </ol> 
		    
		    <div class="carousel-inner text-center">

		      <div class="item  active" >
		      <iframe width="300" height="200" src="https://www.youtube.com/embed/V0g2yyqYRdg" frameborder="0"
			allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
			<iframe width="300" height="200" src="https://www.youtube.com/embed/LS_4lpYSwtk" frameborder="0" 
			allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>	
			<iframe width="300" height="200" src="https://www.youtube.com/embed/bSOJtowCn84" frameborder="0" 
			allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
		      </div>
		      <div class="item">
		      <iframe width="300" height="200" src="https://www.youtube.com/embed/ABFMYgPB9Rs" frameborder="0" 
		      allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
			<iframe width="300" height="200" src="https://www.youtube.com/embed/cQe-A9ETjSk" frameborder="0" 
			allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>	
			<iframe width="300" height="200" src="https://www.youtube.com/embed/vq5Fm7_75Aw" frameborder="0" 
			allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
		      </div>
		      
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
	<div class="container" style="margin-top:5%">		
		<table class="table">
			<thead>
				<tr class="danger">
				<th scope="col" style="width:40%; text-align:center">제목</th>
				<th scope="col" style="width:20%; text-align:center">별점</th>
				<th scope="col" style="width:20%; text-align:center">작성날짜</th>
				<th scope="col" style="width:20%; text-align:center">조회수</th>
				</tr>
			</thead>			
			<tbody class="text-center">
				<c:forEach var="dto" items="${items.test}" varStatus ="status">	
					<tr>
					<td>
					    <a href="<%=request.getContextPath()%>/detail.creview?rno=${dto.rno}">${dto.rtitle}</a>			    
					</td>
					<c:choose>
					     <c:when test="${dto.rstar==1}"><td>★</td></c:when>
					     <c:when test="${dto.rstar==2}"><td>★★</td></c:when>
					     <c:when test="${dto.rstar==3}"><td>★★★</td></c:when>
					     <c:when test="${dto.rstar==4}"><td>★★★★</td></c:when>
					     <c:when test="${dto.rstar==5}"><td>★★★★★</td></c:when>
					     <c:otherwise><td></td></c:otherwise>
				  	 </c:choose>
			  	 	<c:set var="rdate" value="${dto.rdate}"/>
					<td>${fn:substring(rdate,0,10) }</td><td>${dto.rhit}</td>
					</tr>
				</c:forEach>
			</tbody>			
			<tfoot>
			<tr>
			<td colspan="5" class="text-center">
				<ul class="pagination">
					<c:if test="${items.bottom_start>items.bottomlist}">
						<li><a href="${pageContext.request.contextPath}/main.review?pstartno=${(items.bottom_start-2)*items.onepageLimit}">이전</a></li>				
					</c:if>
					<c:forEach var="i" begin="${items.bottom_start}" end="${items.bottom_end}" >
						<li <c:if test="${items.bottom_current==i}">class="active"</c:if>>
						<a href="${pageContext.request.contextPath}/main.review?pstartno=${(i-1)*items.onepageLimit}">${i}</a>
						</li> 
					</c:forEach>
					<c:if test="${items.pageall>items.bottom_end}">
						<li><a href="${pageContext.request.contextPath}/main.review?pstartno=${items.bottom_end*items.onepageLimit}">다음</a></li>				
					</c:if>
				</ul>
				</td>
			</tr>
			</tfoot>		
		</table>
		<p class="text-right"><a href="<%=request.getContextPath()%>/write_view.creview" class="btn btn-danger" >수강후기쓰기</a></p>
	</div><!-- end container -->
</div>

   
    
    
    
    
    
   
  

<%@ include file ="/inc/footer.jsp"%>
