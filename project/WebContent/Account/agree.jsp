<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file ="/inc/solgoda_header.jsp"%>
<%
	if(request.getParameter("kid")!=null) {
		 pageContext.setAttribute("kid", (String) request.getParameter("kid"));
	}
%>
<div id="main">
<div class="container">
  <h3>회원가입</h3>
  <strong>솔고다 사이트의 회원가입을 할 수 있습니다</strong>
  <div class="text-center" style="text-decoration:underline; margin-top:5%">
  	<p><strong>솔고다 회원으로 가입을 원하실 경우,</strong></p>
  	<p><strong>아래 <span style="color:red">약관</span> 및 <span style="color:red">개인정보 처리방침</span>
  	에 대한 안내를 반드시 읽고, 동의해주세요.</strong></p>
  </div>
  <div class="text-right">
  	<label for="agreeall">모두 동의합니다.</label>
	<input type="checkbox" id="agreeall" name="agreeall">
  </div> 
  <div class="panel-group" id="accordion">
    <div class="panel panel-default">
      <div class="panel-heading">
          <h4 class="panel-title">
          <strong>솔고다 회원가입약관(필수사항)</strong>
          <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">내용보기</a>
        </h4>
      </div>
      <div id="collapse1" class="panel-collapse collapse in">
        <div class="panel-body">
        <textarea cols="60" rows="10" class="form-control"><%@ include file="agree1.txt" %></textarea>
        </div>
      </div>
      <div class="text-right">
       	<label for="agree1">회원가입약관 내용에 동의합니다.</label>
       	<input type="checkbox" id="agree1" name="check">
	  </div>   
    </div>
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
        <strong>개인정보 수집 및 이용 동의(필수사항)</strong>
          <a data-toggle="collapse" data-parent="#accordion" href="#collapse2">내용보기</a>
        </h4>
      </div>
      <div id="collapse2" class="panel-collapse collapse">
        <div class="panel-body">
        <textarea cols="60" rows="10" class="form-control"><%@ include file="agree2.txt" %></textarea>
        </div>
      </div>
      <div class="text-right">
      <label for="agree2">개인정보방침에 동의합니다.</label>
      <input type="checkbox" id="agree2" name="check" >
      </div>
    </div>
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
        <strong>이벤트 및 광고 알림 문자/메일, 쪽지(선택)</strong>
          <a data-toggle="collapse" data-parent="#accordion" href="#collapse3">내용보기</a>
        </h4>
      </div>
      <div id="collapse3" class="panel-collapse collapse">
        <div class="panel-body">
        <textarea cols="60" rows="10" class="form-control"><%@ include file="agree3.txt" %></textarea>
        </div>
      </div>
      <div class="text-right">
      <label for="agree3">개인정보 제3자 제공에 관한 동의사항을 읽었으며, 이에 동의합니다.</label>
      <input type="checkbox" id="agree3" name="check" >
      </div>
    </div>
  </div> 
  	<div class="form-group text-center">
  		<a href="<%=request.getContextPath()%>/createInfo.do?kid=${kid}" class="btn btn-danger btn-lg" id="join">회원가입하기</a>
  		
  	</div>
</div>
</div>
<script>
     $(function(){
    	 $("#agreeall").on("click", function(){
    		 if($("#agreeall").is(':checked')==true){
    			 $("[name=check]").prop("checked", true);
    		 }
    		 else{
    			 $("[name=check]").prop("checked", false);
    		 }
    		 });
    	 $("#join").click(function(){	
    	 	if($("#agree1:checked").length==0){
				alert("회원가입약관에 동의해주세요.");
				$("#agree1").attr("checked", "chedcked");
				return false;
			}
    	 	if($("#agree2:checked").length==0){
				alert("개인정보방침에 동의해주세요.");
				$("#agree2").attr("checked", "chedcked");
				return false;
			}
    	 	});
    	 
    	 });
</script>

<%@include file="/inc/footer.jsp"%>