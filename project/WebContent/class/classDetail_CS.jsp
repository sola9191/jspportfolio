<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/inc/solgoda_header.jsp"%>
<script>
//장바구니에 담기 눌렀을때 
$(function(){
	var classname = "${cinfo.classname}";

	$(document).on("click", "#itemcart", function(){
		$.ajax({
			url: "${pageContext.request.contextPath}/main_cart_AJAX", 
			type: "post",
			dataType: "json",
			data: { "classname" : classname },
		});
	});
});

</script>
<div id="main">
<div class="wrap">
	<div class="container" style="height:60px; background-color:lightgray;">
	<h3><span style="font-weight:bold">[${cinfo.classcategory}]</span>${cinfo.classname}</h3>	
	<div style="margin-top:5%">
			<c:set var="startdate" value="${cinfo.classstart}"/>
			<c:set var="enddate" value="${cinfo.classend}"/>
		<table class="table">	
			<tbody>
			<tr><td rowspan="2" style="font-size:20px">${cinfo.classname}</td><td>수강시작일: ${fn:substring(startdate,0,10)}</td></tr>
			<tr><td>수강종료일: ${fn:substring(enddate,0,10)}</td></tr>			
			<tr><td colspan="2" style="text-align:right">강의가격: ${cinfo.classprice}</td></tr>	
		</tbody>
			</table>
		<div class="text-right">
		<input type="button" class="btn btn-danger" id="itemcart" data-toggle='modal' data-target='#newcart' value="장바구니에담기"/>
		</div>
	</div>	
	</div><!-- end container -->
	
	<div class="container" style="height:60px; background-color:lightgray; margin-top:20%" >
	<h3>수강후기</h3>
	
	<c:forEach var="reviewdto" items="${reviewlist}" varStatus="status">
	<div class="panel group col-sm-4" style="margin-top:5%; height:50px; " >
	<div class="panel panel-default">
		<div class="panel-heading">
		<a href="<%=request.getContextPath()%>/detail.creview?rno=${reviewdto.rno}">${reviewdto.rtitle}</a>
		<c:choose>
			     <c:when test="${reviewdto.rstar==1}"><p>★</p></c:when>
			     <c:when test="${reviewdto.rstar==2}"><p>★★</p></c:when>
			     <c:when test="${reviewdto.rstar==3}"><p>★★★</p></c:when>
			     <c:when test="${reviewdto.rstar==4}"><p>★★★★</p></c:when>
			     <c:when test="${reviewdto.rstar==5}"><p>★★★★★</p></c:when>
			     <c:otherwise><p></p></c:otherwise>
		</c:choose>
		</div>
		</div>
	</div>
	</c:forEach>
	</div><!-- end container -->
	
	
	<div class="container" style="margin-top:20%; margin-bottom:5%"  >
	  <ul class="nav nav-tabs text-center" >
	    <li class="active"><a data-toggle="tab" href="#detailclass" style="margin-left:5px; width:565px;">강의소개</a></li>
	    <li><a data-toggle="tab" href="#detailteacher" style="width:565px;"  >선생님소개</a></li>
	  </ul>
	  <div class="tab-content" style="margin-top:5%">
	    <div id="detailclass" class="tab-pane fade in active">
	      <p  style="white-space:pre-wrap">${cinfo.classdetail}</p>
	    </div>
	    <div id="detailteacher" class="tab-pane fade">
	      <h3>${tinfo.teachername}</h3>
	      <div class="col-sm-4" style="white-space:pre-wrap">${tinfo.teacherinfo}</div>
	      <div class="col-sm-4"></div>
	      <div class="col-sm-4">
	      <img style="width:80%" src="<%=request.getContextPath()%>/upload/${tinfo.teacherimg}" alt="${tinfo.teacherimg}" />
	      </div>
	    </div>
	  </div>
	</div>	
</div><!-- end wrap -->
</div><!-- end main -->

<!--  modal -->
	<div class="container">
  <!-- 회원이 장바구니 눌렀을때 장바구니에 담겼다고 뜨는 Modal id는 mycart -->
  <div class="modal fade" id="newcart" role="dialog">
    <div class="modal-dialog">    
      <div class="modal-content">
        <div class="modal-header" style="background-color:#466090;">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title" style="background-color:#466090;
    color:white !important;
    text-align: center;
    font-size: 30px;">장바구니</h4>
        </div>
        <div class="modal-body">
          <p>장바구니에 상품이 담겼습니다.</p>
        </div>
        <div class="modal-footer">
        	<div class="text-center">
	          <button type="button" class="btn btn-default" data-dismiss="modal">강의계속보기</button>
	          <button type="button" class="btn btn-danger" onclick="location.href='<%=request.getContextPath()%>/myCartList.cart'">장바구니 > </button>
	        </div>
        </div>
      </div>      
    </div>
  </div>
</div>


<%@ include  file="/inc/footer.jsp" %>