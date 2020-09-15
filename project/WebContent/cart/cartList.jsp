<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/inc/solgoda_header.jsp" %>
	<%
		String cookie = request.getHeader("Cookie");
		if(cookie!=null){
			Cookie [] cookies = request.getCookies();
			for(int i = 0; i < cookies.length ; i++){
				if(cookies[i].getName().equals("itemcart")){
					String cartlist = URLDecoder.decode(cookies[i].getValue(), "UTF-8");
					String [] cartlistf = cartlist.split(",");
					pageContext.setAttribute("cno", cartlistf[0] );
					pageContext.setAttribute("ccate", cartlistf[1] );
					pageContext.setAttribute("cprice", cartlistf[2] );
					pageContext.setAttribute("cstart", cartlistf[3].subSequence(0, 10) );
					pageContext.setAttribute("cend", cartlistf[4].subSequence(0, 10) );
					pageContext.setAttribute("tname", cartlistf[5] );
					pageContext.setAttribute("cname", cartlistf[6] );
				}
			}			
		}
	%>
<script>


$(function(){

	$("input[type=checkbox]").prop("checked", true); //화면 띄웠을떄 다 체크되어있게 
	$("#itemall").on("click", function(){
		if($("#itemall").is(':checked')==true){
			$("#iteameach").prop("checked", true);
		}
		else{
			$("#iteameach").prop("checked", false);
		}
	});
	
	$("#deletecart").on("click", function(){
		if($("#iteameach").is(':checked')==false){
			alert("삭제하실 강의를 선택해주세요");
		}
		else{
		var check = confirm("해당강의를 삭제하시겠습니까?");
		if(check==true){
			$.ajax({
				url:"${pageContext.request.contextPath}/delete_Cart_AJAX", 
				type:"get", 
				dataType:"text",
				success:function(){			
					alert("해당강의가 삭제되었습니다");
					location.reload();
				},
				error:function(xhr, textStatus, errorThrown){
			 		alert(textStatus + "(HTTP: "+xhr.status+"/"+errorThrown);			 		
			 	}					
			});
		}	
		else { alert("취소되었습니다.");}		
		}
	});
});
		
</script>
<div id="main">
	<div class="container">
	<h3>장바구니</h3>	
	</div>

	<div class="container">
		<table class="table table-striped">		
			<thead>
			<tr><th colspan="5">장바구니 상품정보</th></tr>
			<tr>
			<th scope="col"><input type="checkbox" id="itemall"></th><th scope="col" style="width:50%">상품명</th>
			<th scope="col">수량</th>
			<th scope="col">가격</th><th scope="col">결제/삭제</th></tr>
			</thead>
			<c:choose>
			<c:when test = "${pageScope.cstart!=null}" >
			<tbody>
			<tr>
			<td scope="col"><input type="checkbox" id="iteameach"></td><td scope="col" id="cname">
			<p style="font-size:20px; font-weight:bold;">[${pageScope.ccate}]강의명: ${pageScope.cname}</p>
			<p>강의시작일: ${pageScope.cstart}</p>
			<p>강의종료일: ${pageScope.cend}</p>
			<p>담당선생님: ${pageScope.tname}</p>
			</td>
			<td scope="col">1</td>
			<td scope="col" id="cprice">${pageScope.cprice}</td>
			<td scope="col">
			<p><button type="button" class="btn btn-default" id="buy" data-toggle="modal" data-target="#pay">결제하기</button></p>
			<p><button type="button" class="btn btn-danger" id="deletecart">삭제하기</button></p>
			</td>
			</tr>
			</c:when>
			<c:otherwise>
			<tr><td colspan="6" style="height:80px">장바구니에 담긴 강의가 없습니다.</td></tr>
			</c:otherwise>
			</c:choose>
			</tbody>
		</table>
	</div><!--container -->
		<div class="container">
			<table class="table" id="t2">
			<thead > 
			<tr >
			<th style="text-align:center">총 상품금액</th>
			<th></th>
			<th style="text-align:center">배송비</th>
			<th></th>
			<th style="text-align:center">총결제금액</th>			
			</tr>
			</thead>
			<tbody>
			<tr>
			<td style="text-align:center">${pageScope.cprice}</td>
			<td style="text-align:center"><span class="glyphicon glyphicon-plus"></span></td>
			<td style="text-align:center">0</td>
			<td style="text-align:center"><span class="glyphicon glyphicon-chevron-right"></span></td>
			<td style="text-align:center">${pageScope.cprice}</td>
			</tr>
			</tbody>
			</table>
			
			<div class="text-center" style="margin-top:10%">
				<button type="button" class="btn btn-danger" onclick="location.href='<%=request.getContextPath()%>/main.do'">다른강의보기</button>	
			</div>
		</div><!-- end container -->
</div>

  <!-- 결제하기 Modal -->
  <div class="modal fade" id="pay" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Payment</h4>
        </div>
        <div class="modal-body">
          <p>결제 내역은 아래와 같습니다.</p>
          <p>[ ${pageScope.ccate} ] ${pageScope.cname}</p>
         	<p>강의시작일: ${pageScope.cstart}</p>
			<p>강의종료일: ${pageScope.cend}</p>
			<p>담당선생님: ${pageScope.tname}</p>
        </div>
        <div class="modal-footer">
          <p>총결제금액: ${pageScope.cprice}</p>
       	  <button type="button" class="btn btn-primary" onclick="location.href='<%=request.getContextPath()%>/payment.cart?cno=${pageScope.cno}'">결제진행</button>
          <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
        </div>
      </div>
      
    </div>
  </div><!-- end modal -->
  
    
	
	
<%@ include file="/inc/footer.jsp" %>
