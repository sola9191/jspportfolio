<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<footer style="margin-top:10%; background-color:#e3e3e3; height:230px;  padding-top:2%">
	<div class="container">
		<div class="col-sm-1"></div>
		<div class="col-sm-3">
			<div class="row">
				<p><a href="<%=request.getContextPath()%>/main.do"><img id="logo3" src="<%=request.getContextPath()%>/inc/images/solgoda_f.png" alt="솔고다그룹"></a></p>
				<p><img id="logo4" src="<%=request.getContextPath()%>/inc/images/winner_f.png" alt="올해의 교육대상"></p>
			</div>
			<div class="row">
				<input type="button" class="btn btn-danger" value="사이트 QR코드 바로가기" data-toggle="modal" data-target="#qrModal"/>				
			</div>
			<div class="row">
				<p><a href="http://pa4138.cafe24.com/springboard/" class="btn btn-primary">스프링보드 바로가기</a></p>
			</div>
		</div>    
	<div class="col-sm-8">
		    <p>(주) 파고다에스씨에스 </p>
			<p>대표 : 고루다 서울특별시 서초구 강남대로 419(서초동) TEL: 02-6907-2489 FAX: 02-533-8066</p>
			<p>사업자등록번호: 214-87-63551 통신판매신고: 2005-서울서초-05273</p>
			<p>Copyright© PAGODA SCS Inc. All rights reserved.</p>
			<p><a href="<%=request.getContextPath()%>/location.service" style="font-size:15px; font-weight:bold; color:black; ">찾아오시는길(map)</a></p>
	</div>
	</div>    

<!-- QR code modal -->
  <div class="modal fade" id="qrModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">포트폴리오공지사항</h4>
        </div>
        <div class="modal-body">
          <p>본 사이트는 상업적 목적이 아닌 개인 포트폴리오 용도로 제작되었으며 </p>
          <p>홈페이지의 일부내용과 기타 이미지 등은 그 출처가 따로 있음을 밝힙니다.</p>
          <p><img src="<%=request.getContextPath()%>/inc/images/qrcode.jpg" alt="포트폴리오 바로가기"  /></p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal" style="background-color:red; color:white; font-size:20px;">Close</button>
        </div>
      </div>
      
    </div>
  </div>
</footer>
</body>
</html>
