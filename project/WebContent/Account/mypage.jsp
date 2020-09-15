<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file ="/inc/solgoda_header.jsp"%>
<style>
#myclasslist h4 { border-bottom: 2px solid black; font-size:25px; }
#myclasslist table { margin-left:5%; margin-top:2%; width:90%; }
#welcome .row p { font-size:20px; font-weight:bold; }
#welcome { margin-top:1%; }
#myreviewlist h4 { border-bottom: 2px solid black; font-size:25px; }
#myreviewlist {  margin-top:3%  }


</style>
<script>
	$(document).ready(function(){
		$.ajax({
			url:"${pageContext.request.contextPath}/mypage_classList_AJAX", 
			type:"get", 
			dataType: "json", 
			success:function(data){
				var data = data.list;
				
				var tabletag = $("<table class='table table-bordered'>");
				var theadtag = $("<thead><tr><th scope='col'>강의카테고리</th><th scope='col'>강의제목</th><th scope='col'>강의시작일</th><th scope='col'>강의종료일</th>");
				var tbodytag = $("<tbody>");
				for(var i =0; i<data.length ; i++){
				
				var trtag = $("<tr>");                 
				var tdtag1 = $("<td>"+data[i].ccate+"</td>");
				var tdtag2 = $("<td><a href='${pageContext.request.contextPath}/detail.class?classno="+data[i].cno+"'>"+data[i].cname+"</a></td>");
				var tdtag3 = $("<td>"+data[i].cstart.substring(0,10)+"</td>");
				var tdtag4 = $("<td>"+data[i].cend.substring(0,10)+"</td>");
				
				trtag.append(tdtag1).append(tdtag2).append(tdtag3).append(tdtag4);
				tbodytag.append(trtag);
				
				}			
								
				tabletag.append(theadtag).append(tbodytag);
				$("#myclasslist .row").append(tabletag);
				
				
			},
			error:function(xhr, textStatus, errorThrown){
				$("#myclasslist .row").html(textStatus + "(HTTP: "+xhr.status+"/"+errorThrown);
			}
		});		
		
		$.ajax({
			url:"${pageContext.request.contextPath}/mypage_reviewList_AJAX",
			type : "post", 
			dataType:"json",
			success:function(data){
				
				var list = data.list
				for(var i = 0; i<list.length ; i++){
				 var rtitle = "[제목]: "+list[i].rtitle;
				 var rcontent = list[i].rcontent;
				 var rdate = list[i].rdate;
				 var rfile = list[i].rfile;
				 var rno = list[i].rno;
				 var classname = "[강의명]: " + list[i].classname;
				 
				 var p1=$("<p>");  var p2=$("<p>");
				 
				 var div1 = $("<div class='panel-group'>");
				 var div2 = $("<div class='panel panel-default'>");
				 var div3 = $("<div class='panel-heading'>");
				 var atag = $("<a data-toggle='collapse' href='#"+list[i].rno+"'>");
				 var div4 = $("<div id='"+list[i].rno+"' class='panel-collapse collapse'>");
				 var div5 = $("<div class='panel-body'>");

				 p1.append(classname);
				 atag.append(rtitle); 
				 p2.append(atag);
				 				
				
				div3.append(p1).append(p2);
				
				div5.append(rcontent);
				div4.append(div5);
				div2.append(div3).append(div4);
				div1.append(div2);
				$("#myreviewlist_ajax").append(div1);
						
				}
							
			},
			error:function(xhr, textStatus, errorThrown){
				$("#myreviewlist_ajax").append(textStatus + "(HTTP: "+xhr.status+"/"+errorThrown);
			}
		});
});
</script>
<div id="main">
<div class="container">
	<h3>MY PAGE</h3>
</div>
	<div class="container" id="welcome">
		 <div class="row">
			<p style="margin-left:1%">${pname}님 환영합니다. <button type="button" onclick="location.href='<%=request.getContextPath()%>/detail_view.do'" class="btn btn-info">내정보관리</button></p>
	     </div>	 
    </div>	
	<div class="container" id="myclasslist">
		<h4>수강강의리스트</h4>	
		<div class="row"></div>		
	</div>
	
	<div class="container" id="myreviewlist" style="margin-top:10%">
		<h4>나의 수강후기 리스트</h4>
			<div id="myreviewlist_ajax"></div>
			<% 
				if(session.getAttribute("pid")!=null){
	      		String id = (String) session.getAttribute("pid");
	      		if(!(id.equals("admin"))) {%>
	      			<div><a class="btn btn-danger" href="<%=request.getContextPath()%>/write_view.creview">수강후기 쓰기</a></div>	
	      	<%}}%> 
	      							 
	</div>
</div>
<%@ include file="/inc/footer.jsp"%>