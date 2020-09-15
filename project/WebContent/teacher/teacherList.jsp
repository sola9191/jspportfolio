<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file ="/inc/solgoda_header.jsp" %>
<style>
#teacherlist { margin-top:5% }
#teacherlist img { height: 200px; width: 90%; margin-left: 2%; text-align:center; }
#tdetail p { text-align: left; font-size:20px; }
#classlist table caption { font-size:20px;  margin-top: 5%; }
</style>
<script>
	$(document).ready(function(){
		
		$.ajax({
			url: "${pageContext.request.contextPath}/teacher_list_AJAX",
			type: "post",
			dataType: "json",
			success:function( data ){	
				var tinfo = data.teacherinfo;
			
				for(var i =0; i<tinfo.length ; i++){	
					//동적태그만들기				
					var divgroup = $("<div class='panel group col-sm-3' id='teacher' >");
					var divpanel = $("<div class='panel panel-default'>");
					var body = $("<div class='panel-body text-center'>")
					var imgtag = $("<img src=${pageContext.request.contextPath}/upload/"+ tinfo[i].teacherimg+ " alt="+ tinfo[i].teacherimg+">");
					var atag =$("<a href=${pageContext.request.contextPath}/solgodadetail.teacher?tname="+tinfo[i].teachername+">");
					var foot = $("<div class='panel-footer text-center'>")
					var tname = tinfo[i].teachername;
					
					foot.append(tname);
					atag.append(imgtag);
					body.append(atag);
					divpanel.append(body).append(foot);
					divgroup.append(divpanel);
					$("#teacherlist").append(divgroup);
				}				
			},
		error:function(xhr, textStatus, errorThrown){
			alert(textStatus + "(HTTP: " + xhr.status + "/" + errorThrown);
		}
		});
			
		$(document).on("click", "#teacher", function(){ //선생님 누르면
			
		});		
	}); // end docunemt
			

</script>
<div id="main">
	<div class="container">
	<h3>선생님 소개</h3>
	</div>
</div>
<div id="maincate">	
<div class="container">
	<div class="row r1" id="teacherlist"></div>	
</div>
</div><!-- end maincate -->
<%@ include file ="/inc/footer.jsp"%>