<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file ="/inc/solgoda_header.jsp"%>
<script>
	$(document).ready(function(){
		$("#delete_form").submit(function(){
			console.log($(":checkbox[name='enter']"));
			console.log($(":checkbox[name='enter']:checked"));
			if($(":checkbox[name='enter']:checked").length==0){
				alert("가입이유 하나이상을 체크해 주세요!");
				$(":checkbox[id='enter1']").attr("checked", "checked");
				return false;		
			}
			if($(":checkbox[name='out']:checked").length==0){
				alert("탈퇴이유 하나 이상을 체크해주세요.!");
				$(":checkbox[id='out1']").attr("checked", "checked");
				return false;		
			}
		});
	});	
</script>	
<div id="main">	
	<div class="container text-center"  style="height:150px">
		<h3 class="panel-heading">회원탈퇴</h3>
			<strong>회원님이 원하실 때 언제든지 다시 가입하시어 이용하실 수 있사오니 앞으로도 많은 관심 부탁 드립니다.</strong>
	</div>	
	<div class="container well text-left">
		<strong style="color:red; font-size:15px" >회원탈퇴 전 유의사항</strong>
		<p><strong style="color:red">ㅡ</strong>한번 탈퇴를 하시면 솔고다패밀리 사이트에서도 자동으로 탈퇴 됩니다. 원활한 서비스 관리를 위하여 탈퇴하신 아이디는 다시 이용하실 수 없으며
		재가입 시 다른 아이디를 이용하셔야 합니다.</p>
		<p><strong style="color:red">ㅡ</strong>솔고다패밀리 사이트의 로그인을 필요로 하는 서비스는 이용하실 수 없습니다. 개인정보 보호법에 의거하여
		어떠한 이유라도 회원탈퇴를 하시면 보유하신 이력(등록, 레벨테스트, 패밀리회원/머니, 이벤트응시/당첨, 할인쿠폰뿐만 아니라 성명, 생년월일, 이메일, 주소 등 모든 개인정보)
		및 웹사이트에 저장된 정보가 모두 소멸됩니다. 현재 솔고다어학원 강의를 수강하고 계신 경우에도 모두 소멸되어 모든 이력 확인이 불가하오니 회원
		탈퇴를 신중하게 고려해 주시기 바랍니다.</p>
		<p><strong style="color:red">ㅡ</strong>회원님께서 활동하셨던 커뮤니티 또한 이용하실 수 없습니다. 만약, 회원님께서 개설하신 동호회가 있으신 경우에는
		회원탈퇴 전에 미리 클럽장을 다른 회원에게 양도하시기 바랍니다.</p>
 	</div>
 	
 	<div class="container">
 		<form action="<%=request.getContextPath()%>/delete.do" method="post" id="delete_form">
 		<fieldset>
 		<div class="row r1">
 			<div class="col-sm-3"><p>솔고다 사이트 가입이유</p>(* 필수항목)</div>
 			<div class="col-sm-7">
 			<p><input type="checkbox" id="enter1" name="enter"><label for="enter1">주위 추천 및 권유</label></p>
 			<p><input type="checkbox" id="enter2" name="enter"><label for="enter2">온라인 수강 신청을 위해</label></p>
 			<p><input type="checkbox" id="enter3" name="enter"><label for="enter3">외국어 학습 정보를 얻기 위해</label></p>
 			<p><input type="checkbox" id="enter4" name="enter"><label for="enter4">기타</label>
 				<input type="text" placeholder="입력" style="width:300px"></p>
			</div>
 		</div><!-- end row r1 -->
 		<div class="row r2">
 			<div class="col-sm-3"><p>솔고다 사이트 탈퇴이유</p>(* 필수항목)</div>
 			<div class="col-sm-7">
 			<p><input type="checkbox" id="out1" name="out"><label for="out1">ID 변경을 위해</label></p>
 			<p><input type="checkbox" id="out2" name="out"><label for="out2">이용하고 싶은 컨텐츠의 부족</label></p>
 			<p><input type="checkbox" id="out3" name="out"><label for="out3">잦은 서비스 오류 및 장애</label></p>
 			<p><input type="checkbox" id="out4" name="out"><label for="out4">서비스 속도가 느림</label></p>
 			<p><input type="checkbox" id="out5" name="out"><label for="out5">더 이상 이용할 목적이 없어짐</label></p>
 			<p><input type="checkbox" id="out6" name="out"><label for="out6">개인정보 유출이 우려되서</label>
 			<p><input type="checkbox" id="out7" name="out"><label for="out7">기타</label>
 				<input type="text" placeholder="입력" style="width:400px"></p>
			</div>
 		</div><!-- end row r2 -->
 		<div class="row r3">
 			<div class="col-sm-3"><p>건의사항 및 의견</p>(1000자 내외로 입력하세요.)</div>
 			<div class="col-sm-7">
 				<textarea style="width:700px; height:300px"></textarea>
		</div>
 		</div><!-- end row r3 -->
 		<div class="form-group">
 			<input type="checkbox" id="online" name="online"><label for="online">온라인 회원정보만 삭제(체크하시면 추후에 다시 회원가입 하실 때 이전의 수강 이력 및 패밀리 머니 적립 내역을 확인 하실 수 있습니다.)</label>
 		</div>
 		<div class="form-group text-center">
 			<a href="<%=request.getContextPath()%>/detail_view.do" class="btn btn-primary" style="margin-top:4%" >뒤로가기</a>
 			<input type="submit" value="회원탈퇴" class="btn btn-danger" style="margin-top:4%">
 		</div>
 		</fieldset>
 	</form>
 	</div><!-- end container -->
</div>
<%@ include file= "/inc/footer.jsp" %>