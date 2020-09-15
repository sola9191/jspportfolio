<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file ="/inc/solgoda_header.jsp"%>
<!--  END HEADER -->
<!--  END HEADER -->
<!--  END HEADER -->
<script>
	$(function(){
		$(document).on("submit", "#writeForm", function(){
		
			if(jQuery("#rname").val().trim()==""){
				alert("이름을 입력하세요");
				$("#rname").focus();
				return false;
			}
			
			if(jQuery("#rpass").val().trim()==""){
				alert("비밀번호를 입력하세요");
				$("#rpass").focus();
				return false;
			}
			if(jQuery("#rtitle").val().trim()==""){
				alert("제목을 입력하세요");
				$("#rtitle").focus();
				return false;
			}
			if(jQuery("#rcontent").val().trim()==""){
				alert("내용을 입력하세요");
				$("#rcontent").focus();
				return false;
			}
			
		});  
		
		 $('#rstar a').on("click", function(){
			    /* 별점의 on 클래스 전부 제거 */ 
	             $(this).parent().children("a").removeClass("on");
	            $(this).addClass("on").prevAll("a").addClass("on"); /* 클릭한 별과, 그 앞 까지 별점에 on 클래스 추가 */
	            $("#rstarssave").val($(this).attr("id"));
	            return false;
	        });	
		});
</script>
<style>
    #rstar a{
        text-decoration: none;
        color: gray;
    }
    #rstar a.on{
        color: red;
    }
</style>
<%
 	String tmprname = null;
	String rname = null;
    ArrayList<String> extrainfo = new ArrayList<>(); 
	ArrayList<String> rclass = new ArrayList<>();
	rclass = (ArrayList<String>) request.getAttribute("extrainfo"); 
	
	for(int i = 0; i<rclass.size() ; i++){
		tmprname = rclass.get(0);
		extrainfo.add(rclass.get(i).substring(rclass.get(i).indexOf('/')+1));
	}
		rname = tmprname.substring(0, tmprname.indexOf('/'));
		
		pageContext.setAttribute("rname", rname);
		pageContext.setAttribute("extrainfo", extrainfo);
		System.out.println(rname);

%>
<div id="main">
<div class="container">
	<h3>수강후기 쓰기 </h3>
		<form action="<%=request.getContextPath()%>/write.creview" method="post"  id="writeForm" enctype="multipart/form-data">
		   <fieldset>
		   	<div class="form-group">
			  <label for="rhit"  >조회수</label>
			  <input type="text"   name="rhit"   id="rhit" value="0"  class="form-control" readonly> 
			</div>	
			<div class="form-group">
			  <label for="rname"  >작성자</label>
			  <input type="text"   name="rname"   id="rname" value="${rname}"   class="form-control" > 
			</div>			
			<div class="form-group">
			  <label for="rpass"  >비밀번호</label>
			  <input type="password"   name="rpass"   id="rpass"   class="form-control" > 
			  <span>(*) 수정, 삭제시 필수</span>
			</div>	
			<div class="form-group">
			  <label for="rclass" >수강강의리스트</label>
			 	<div>		  
			  	<select id="rclass" name="rclass" style="width:100%">
			  		<c:forEach var="extrainfo" items="${extrainfo}" varStatus="status">
			  		<option value="${extrainfo}">${extrainfo}</option>
			  		</c:forEach>
			  	</select>
				 </div>
			</div>															
			<div class="form-group">
			  <label for="rtitle"  >제목</label>
			  <input type="text"   name="rtitle"   id="rtitle"   class="form-control" > 
			</div>				
			<div class="form-group">
			  <label for="rstar">별점</label>
			  	<div>
			  	<span id="rstar">
			        <a href="#" id="1">★</a>
			        <a href="#" id="2">★</a>
			        <a href="#" id="3">★</a>
			        <a href="#" id="4">★</a>
			        <a href="#" id="5">★</a>
				</span>
				</div>
			</div>
					
			<div class="form-group">
			  <label for="rcontent"  >내용</label>
			  <textarea name="rcontent"  id="rcontent"  cols="60"  rows="10"   class="form-control" ></textarea>
			</div>	
			<div class="form-group">
			  <label for="rfile"  >첨부파일</label>
			  <input type="file"   name="rfile"   id="rfile"   class="form-control" > 
			</div>				
			<input type="hidden" id="rstarssave" name="rstarssave" value=""/>
			
			<div class="form-group  text-right">
				<input type="submit"   value="입력"  class="btn btn-default"  style="color:white; background-color:#f4511e"   >  
				<input type="reset"    value="취소"  class="btn btn-default"    >  
				<a href="<%=request.getContextPath()%>/main.review"   class="btn btn-default"   >목록보기</a>
			</div>
		 </fieldset>		
		</form> <!-- end form -->	
</div>
</div>

<%@ include file ="/inc/footer.jsp"%>