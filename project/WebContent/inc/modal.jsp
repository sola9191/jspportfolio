<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang ="ko">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link href="<%=request.getContextPath()%>/inc/images/favicon.png" rel="shortcut icon" type="image/x-icon">
 <link href="<%=request.getContextPath()%>/inc/images/favicon.png" rel="icon" 		   type="image/x-icon"> 
</head>

<style>
.modal-header { background-color:red; color:white; font-size:20px; font-weight:bold; }
.modal-title { font-size:20px; font-weight:bold; } 


</style>
<body>
  <!-- Trigger the modal with a button -->
  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">    
      <!-- Modal content-->
      <div class="modal-content" style="width:130%">
        <div class="modal-header" >
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">8월이벤트</h4>
        </div>              
        <div class="modal-body" >
     
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner text-center">
      <div class="item active text-center">
        <p><img src="<%=request.getContextPath()%>/inc/images/return1.PNG" alt="Los Angeles" style="width:30%;">
        	<img src="<%=request.getContextPath()%>/inc/images/return2.PNG" alt="Chicago" style="width:30%;">
         	<img src="<%=request.getContextPath()%>/inc/images/return3.PNG" alt="New York" style="width:30%;"></p>
      </div>

      <div class="item text-center">
        <p><img src="<%=request.getContextPath()%>/inc/images/return3.PNG" alt="Chicago" style="width:30%;">
        <img src="<%=request.getContextPath()%>/inc/images/return4.PNG" alt="Chicago" style="width:30%;">
        <img src="<%=request.getContextPath()%>/inc/images/return5.PNG" alt="Chicago" style="width:30%;"></p>
      </div>
      
       <div class="item text-center">
        <p><img src="<%=request.getContextPath()%>/inc/images/return7.jpg" alt="Chicago" style="width:30%;">
        <img src="<%=request.getContextPath()%>/inc/images/return8.jpg" alt="Chicago" style="width:30%;">
        <img src="<%=request.getContextPath()%>/inc/images/return9.jpg" alt="Chicago" style="width:30%;"></p>
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
        
        
        <div class="modal-footer">
          <button type="button" class="btn btn-danger btn-lg" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div> 
</div>

</body>
</html>
