<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang ="ko">
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link href="<%=request.getContextPath()%>/inc/images/favicon.png" rel="shortcut icon" type="image/x-icon">
 <link href="<%=request.getContextPath()%>/inc/images/favicon.png" rel="icon" 		   type="image/x-icon"> 
<style>
.w3-xxlarge {
    font-size: 15px!important; margin-top:5%;
}
</style>
<body>
<!-- Sidebar -->
<div class="w3-sidebar w3-bar-block w3-animate-left" style="display:none;z-index:5; width:50%;" id="mySidebar">
  <button class="w3-bar-item w3-button w3-large" onclick="w3_close()" style="background-color:crimson; color:white; text-align:right;">Close &times;</button>
  <button type="button" class="w3-bar-item w3-button  subcate" id="1">토익</button>
  <button type="button" class="w3-bar-item w3-button subcate" id="2">토플/GRE</button>
  <button type="button" class="w3-bar-item w3-button subcate" id="3">토익스피킹</button>
  <button type="button" class="w3-bar-item w3-button subcate" id="4">오픽 </button>
  <button type="button" class="w3-bar-item w3-button subcate" id="5">아이엘츠</button>
  <button type="button" class="w3-bar-item w3-button subcate" id="6">HSK/TSC</button>
  <button type="button" class="w3-bar-item w3-button subcate" id="7">JLPT</button>
</div>


<!-- Page Content -->
<div class="w3-overlay w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" id="myOverlay"></div>

<script>
function w3_open() {
  document.getElementById("mySidebar").style.display = "block";
  document.getElementById("myOverlay").style.display = "block";
}

function w3_close() {
  document.getElementById("mySidebar").style.display = "none";
  document.getElementById("myOverlay").style.display = "none";
}
</script>
          
</body>
</html>