<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file ="/inc/solgoda_header.jsp"%>
<script src="https://cdn.ckeditor.com/4.14.1/standard/ckeditor.js"></script>
<script>
	$(function(){		
		$("#send").on("submit", function(){
			if($("#email").val().trim()==""){
				alert("답변받을 이메일을 입력해주세요");
				$("#email").focus();
				return false;
			}
			
			else if($("#subject").val().trim()==""){
				alert("제목을 입력해주세요");
				$("#subject").focus();
				return false;
			}
			
		});
	});

</script>
<div id="main">
<div class="container">
		<h3 class="panel-heading">문의메일 보내기</h3>	
			<form action="${pageContext.request.contextPath}/email.service" method="post" id="send">
			<fieldset>
				<legend></legend>
				<div class="row form-group">
					<div class="col-sm-3"><label for="email">답변받을 EMAIL</label></div>
					<div class="col-sm-9"><input type="text" id="email" name="email" class="form-control"></div>
				</div>
				<div class="row form-group">
					<div class="col-sm-3"><label for="subject">TITLE</label></div>
					<div class="col-sm-9"><input type="text" id="subject" name="subject" class="form-control"></div>
				</div>
				<div class="row form-group">
					<div class="col-sm-3"><label for="content">CONTENT</label></div>
					<div class="col-sm-9"><textarea id="content" name="content" rows="10" cols="40" class="form-control">
					</textarea></div>
				</div>				
				<div class="row form-group">
					<div class="col-sm-3"></div>
					<div class="col-sm-9"><input type="submit" value="메일발송하기"  id="send" class="form-control btn btn-danger"></div>
				</div>
			</fieldset>
		</form>
		<script src="https://cdn.ckeditor.com/4.14.1/standard/ckeditor.js"></script>
         <script>
             CKEDITOR.replace( 'content' );
         </script>
	</div>
</div>
<%@ include file="/inc/footer.jsp"%>