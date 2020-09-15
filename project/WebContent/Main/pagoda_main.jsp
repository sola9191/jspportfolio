<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file ="/inc/solgoda_header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<style>
/*main꺼 끌어옴*/
div#videolist { text-align: center; margin-top: 5%; } 
div#choice { margin-top: 3%; } 
ul#listdetail > li{ width: 184.01px; } 
#cnum { text-align:right; font-size:large} 
#ctime { font-size:large} div#service { margin-top: 3%; } 
#service .container .row.r2 { margin-top: 3%; } 
#service .container .row.r3 { margin-top: 3%; } 
a.btn.btn-default { background-color: black; color: white; width: 150px; height: 40px; } 
#main .r1{ height: 40px; text-align: left; font-size: 25px; background-color: #cc3333; width:85%;
color: white; letter-spacing: 10px; margin-left: 8%;} 
ul.nav.nav-pills { margin-top: 1%; margin-left:90px; text-align:center; }
#test{ margin-top:1%}  
#translate { width:30%; margin-bottom:5%; }
#reviewtitle { font-size:20px; font-weight:bold; color:black;}
#lastcontainer { margin-top:5%;  height:100px }
#lastcontainer .panel-body { height:300px }
#noticelist p { margin: 0 0 30px; }
#noticelist a { font-size:13px; color:black; }
.row.service.r1 { margin-top:10%;  margin-bottom:10% }
.row.service.r2 { margin-top:10%;  margin-bottom:10% }
.row.service.r3 { margin-top:10%;  margin-bottom:10% }
#teacherlink { height:300px; width:280px; }
#videolist a { color: black; font-weight: bold;}
#classdetail { margin-top:10%; margin-bottom:3% }
select#language { width: 32%; height: 30px; margin-left: 9%; }


</style>
<script>
	$(function(){		
		$.ajax({
			url: "${pageContext.request.contextPath}/main_all1_AJAX", 
		    type: "post", dataType:"json", 
		 	success: function( data ){
		 		var ccate = data.ccate;
		 		for(var i = 0 ; i<ccate.length ; i++){	 			
		 			var classcatename = ccate[i].classcatename;		 			
		 			//동적데이터생성	
		 			var tr = $("<tr>");
		 			var td = $("<td id='subname' style='cursor:pointer'>").html(classcatename);				 		
		 			//3. tbody에 데이터삽입	 
		 			tr.append(td);
		 			$(".sub_ajx tbody").append(tr);	 			
		 		}	 		
		 	},
		 	error:function(xhr, textStatus, errorThrown){
		 		$(".sub_ajx tbody").html(textStatus + "(HTTP: "+xhr.status+"/"+errorThrown);			 		
		 	}			 	
		});	
		 		
		$.ajax({
			url: "${pageContext.request.contextPath}/main_all2_AJAX", 
		    type: "post", dataType:"json", 
		 	success: function( data ){
		 		var tname = data.tname;
		 		for(var i = 0 ; i<tname.length ; i++){	 			
		 			var teachername = tname[i].teachername;		 			
		 			//동적데이터생성	
		 			var tr = $("<tr>");
		 			var td = $("<td id='tname' style='cursor:pointer'>").html(teachername);				 		
		 			//3. tbody에 데이터삽입	 
		 			tr.append(td);
		 			$(".teacher_ajx tbody").append(tr);	 			
		 		}	 		
		 	},
		 	error:function(xhr, textStatus, errorThrown){
		 		$(".teacher_ajx tbody").html(textStatus + "(HTTP: "+xhr.status+"/"+errorThrown);				 		
		 	}			 	
		});	
		
		 $.ajax({
			url: "${pageContext.request.contextPath}/main_all3_AJAX", 
		    type: "post", dataType:"json", 
		    success: function( data ){
		 		var cname = data.cname;
		 		for(var i = 0 ; i<cname.length ; i++){	 			
		 			var classname = cname[i].classname;		 			
		 			//동적데이터생성	
		 			var tr = $("<tr>");
		 			var td = $("<td id='classlist'>");
		 			var a = $("<a style='cursor:pointer'>").html(classname);				 		
		 			//3. tbody에 데이터삽입	 
		 			td.append(a);
		 			tr.append(td);
		 			$(".class_ajx tbody").append(tr);	 			
		 		}	 		
		 	},
		 	error:function(xhr, textStatus, errorThrown){
		 		$(".class_ajx tbody").html(textStatus + "(HTTP: "+xhr.status+"/"+errorThrown);				 		
		 	}			 	
		});	
		 		
		//공지사항 불러오는 아작스 
		
		$.ajax({
			url:"${pageContext.request.contextPath}/main_notice_AJAX",
			type:"post",
			dataType:"json",
			success:function(data){
				console.log(data.noticelist);
				var list = data.noticelist;
				for(var i = 0; i<list.length ; i++){
					 var nno = list[i].nno;
					 var nname = list[i].nname;
					 var ntitle = list[i].ntitle;
					 var ndate = list[i].ndate;
			 
					 var p1= $("<p>"); 
					 var atag = $("<a href='${pageContext.request.contextPath}/detail_view.notice?nno="+nno+"'>");
			 	
				atag.append(ntitle);
					 p1.append(atag);
				$("#noticelist").append(p1);
			
				}	
						
			
			}, 
			error:function(xhr, textStatus, errorThrown){
				alert(textStatus + "(HTTP: "+xhr.status+"/"+errorThrown);
			}	
		});		
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////처음 웹페이지 키자마자 나오는것~~
	//나중에 장바구니 클릭했을떼 cookie값 저장하는 Servlet으로 보낼 변수들
		var savesub = null;		var saveteacher = null;   var saveclassname = null; var classno = null; //이거 핵중요
		//1. 과목선택하면 과목들 나옴 
		$("#chhosesub").on("click", function(){		
			$(".sub_ajx tbody").empty();
			$(".teacher_ajx tbody").empty();
			$.ajax({
				url: "${pageContext.request.contextPath}/main_subject_AJAX", 
			    type: "get", dataType:"xml", 
			 	success: function(xml){
			 		console.log(xml);
			 		//1.데이터추출
			 		var cate = $(xml).find("cate");
			 		for( var i=0 ; i<cate.length ; i++){
			 			var classname = $(cate[i]).find("classcatename").text();		 			
			 			//2.동적데이터생성	
			 			var tr = $("<tr>");
			 			var td = $("<td id='subname' style='cursor:pointer'>").html(classname);				 		
			 			//3. tbody에 데이터삽입	 
			 			tr.append(td);
			 			$(".sub_ajx tbody").append(tr);
			 		} 	
			 	},
			 	error:function(xhr, textStatus, errorThrown){
			 		$(".sub_ajx tbody").html(textStatus + "(HTTP: "+xhr.status+"/"+errorThrown);			 		
			 	}			 	
			});			
		});		
		//2. 과목선택시선생님들 이름나옴
		$(document).on("click", "#subname", function(){		
			savesub = $(this).text();
			$(".teacher_ajx tbody").empty();
			$(".class_ajx tbody").empty();
			$.ajax({
				url: "${pageContext.request.contextPath}/main_teacher_AJAX", 
				type: "get", dataType:"xml",
				data: {"subname": $(this).text() },
				success:function( xml ){
					var each = $(xml).find("each");
					for (var i =0 ; i<each.length ; i++){
						var teachername = $(each[i]).find("teachername").text();
						var tr = $("<tr>");
						var td = $("<td id='tname' style='cursor:pointer'>").html(teachername);
						tr.append(td);
						$(".teacher_ajx tbody").append(tr);
					}
				},
				error:function(xhr, textStatus, errorThrown){
			 		$(".teacher_ajx tbody").html(textStatus + "(HTTP: "+xhr.status+"/"+errorThrown);			 		
			 	}								
		});	
	});	
	//3. 선생님들이름 클릭시 강의목록나옴
		$(document).on("click", "#tname", function(){
			saveteacher = $(this).text();
			$(".class_ajx tbody").empty();
			$.ajax({
				url:"${pageContext.request.contextPath}/main_class_AJAX",
				type:"get",
				dataType:"xml",
				data:{"tcname" : $(this).text(),
					  "sbjname" : savesub },
				success:function(xml){
					console.log(xml);
					var classlist = $(xml).find("list");
					for(var i = 0; i<classlist.length; i++){
						
						var classname = $(classlist[i]).find("classes").text();
						var tr = $("<tr>");
						var td = $("<td id='classlist'>");
						var a = $("<a style='cursor:pointer'>").html(classname);
						td.append(a);
						tr.append(td);
						$(".class_ajx tbody").append(tr);
					}
				},
				error:function(xhr, textStatus, errorThrown){
					$(".class_ajx tbody").html(textStatus + "(HTTP: "+xhr.status+"/"+errorThrown);
				}		
			});
		});
		//4. 강의 클릭시 선택한 강의정보입니다에 담김
		$(document).on("click", "#classlist", function(){
			$("#eventbtn").empty();
			saveclassname = $(this).text();
			$("#selectedclass tbody").empty();
			$.ajax({
				url:"${pageContext.request.contextPath}/main_final_AJAX",
				type:"get",
				datatype:"xml",
				data:{"classname" : $(this).text() },
				success:function(xml){
					console.log(xml);
					var classinfolist = $(xml).find("list");
					for(var i = 0; i<classinfolist.length ; i++){
						classno = $(classinfolist[i]).find("classno").text();
						var classname = $(classinfolist[i]).find("classname").text();
						var classprice = $(classinfolist[i]).find("classprice").text();
						var classstart = $(classinfolist[i]).find("classstart").text();
						var classend =  $(classinfolist[i]).find("classend").text();						
						//table 형태로 만들기
						var tr = $("<tr>"); 		
						var td = $("<td id='shoptmpname'>");
						var p1 = $("<p><input type='checkbox' name='classchk' id='classchk' checked><label for='classchk'>").append(
						"강의명: ").append(classname).append(" 강의가격: ").append(classprice);	
						var p2 = $("<p>").html("강의시작일: ").append(classstart);	
						var p3 = $("<p>").html("강의종료일: ").append(classend).append("</td>");
						
						td.append(p1).append(p2).append(p3);
						tr.append(td);
						$("#selectedclass tbody").append(tr);
						var p1 = $("<p>"); var p2 = $("<p>"); 
						var btn1 = $("<button type='button' id='classdetail' class='btn btn-primary'>");
						var btn2 = $("<button type='button' id='cart' class='btn btn-danger' data-toggle='modal' data-target='#newcart'>");
						
						btn1.append("강의상세보기"); p1.append(btn1);
						btn2.append("장바구니"); p2.append(btn2);
						$("#eventbtn").append(p1).append(p2);
						
					}
			},
				error:function(xhr, textStatus, errorThrown){
					$("#selectedclass tbody").html(textStatus + "(HTTP: "+xhr.status+"/"+errorThrown);
				}			
			});	
		});	
		
		///////////////////////////여기는 리뷰
		$.ajax({
			url:"${pageContext.request.contextPath}/main_review_AJAX",
			type:"post",
			dataType:"json",
			success:function(data){
				console.log(data.reviewlist);
				var list = data.reviewlist;
				for(var i = 0; i<list.length ; i++){
				 var rtitle = list[i].rtitle;
				 var rcontent = list[i].rcontent;
				 var rdate = list[i].rdate;
				 var rfile = list[i].rfile;
				 var rno = list[i].rno;
				 var classname = list[i].classname;
				 
				 var p1=$("<p>");  var p2=$("<p>");
				 var span = $("<span class='glyphicon glyphicon-education'></span>");
				 var div1 = $("<div class='panel-group col-sm-3' id='accordion'>");
				 var div2 = $("<div class='panel panel-default'>");
				 var div3 = $("<div class='panel'  style='height:80px'>");
				 var atag = $("<a data-toggle='collapse' href='#"+list[i].rno+"' id='reviewtitle' data-parent='#accordion'>");
				 var div4 = $("<div id='"+list[i].rno+"' class='panel-collapse collapse'>");
				 var div5 = $("<div class='panel-body' style='white-space:pre-wrap;'>");

				
				 p1.append(span).append(classname);
				 atag.append(rtitle); 
				 p2.append(atag);			 				
				 div3.append(p1).append(p2);
				 div5.append(rcontent);
				 div4.append(div5);
				 div2.append(div3).append(div4);
				 div1.append(div2);
				 $("#reviewlist").append(div1);
						
				}
			}, 
			error:function(xhr, textStatus, errorThrown){
				alert(textStatus + "(HTTP: "+xhr.status+"/"+errorThrown);
			}	
		});		
				
		//카트눌렀을때 데이터 가지고 이동
		$(document).on("click", "#cart", function(){
			$.ajax({
				url: "${pageContext.request.contextPath}/main_cart_AJAX", 
				type: "post",
				dataType: "json",
				data: { "classname" : saveclassname } 
			});
		});
		
		$(document).on("click", "#translate", function(){
			if($("#language").val()==("nochoose")) {  
				alert("언어를 선택해주세요"); return false; }
			
			else if($("#beforesen").val().trim()==("")) { 			
				alert("번역을 원하시는 문장을 입력해주세요."); 
				$("#beforesen").focus();				}
			
			else{
				$.ajax({
					url: "${pageContext.request.contextPath}/translator", 
					type: "post",
					dataType: "json",
					data: { "oldsen" : $("#beforesen").val() ,  
						    "language" : $("#language").val() } ,
					success:function(data){
						console.log(data.result.translatedText);
						$("#aftersen").val(data.result.translatedText);	
					}, 
					error:function(xhr, textStatus, errorThrown){
						alert(textStatus + "(HTTP: "+xhr.status+"/"+errorThrown);
					}	
				});
			}			
		});
	// 강의 상세정보보기 아작스
	$(document).on("click", "#classdetail", function(){
		location.href="${pageContext.request.contextPath}/detail.class?classno="+classno
	});
	
});				
</script>

<div id="main" style="margin-bottop:5%">
<div class="container " >
 <div class="row r1">솔고다인강빠른수강신청</div> 
    	<div class="row r3" style="margin-top:2%">
			<div class="col-sm-1"></div>  
			<div class="col-sm-10">
			<table class="table table-hover">
			<thead>
				<tr>
					<th id="chhosesub" style="width:30%; cursor:pointer; text-align:center; ">과목선택</th>
					<th style="width:30%; cursor:pointer; text-align:center; ">선생님선택</th>
					<th style="width:40%; cursor:pointer; text-align:center; ">강의선택</th>
				</tr>
			</thead>		
			</table>		
			</div>    
			<div class="col-sm-1"></div> 
		</div>
		<div class="row r4 text-center">
			<div class="col-sm-1"></div>      
			<div class="col-sm-3 sub_ajx">
			<table class="table table-hover" style ="border:2px solid #F5F5F5">
				<tbody>
				</tbody>
			</table>
			</div>
			<div class="col-sm-3 teacher_ajx">
			<table class=" table table-hover" style ="border:2px solid #F5F5F5">
				<tbody>
				</tbody>
			</table>
			</div>	
			<div class="col-sm-4 class_ajx">
			<table class=" table table-hover" style ="border:2px solid #F5F5F5">
				<tbody>
				</tbody>
			</table>
			</div>			
			<div class="col-sm-1"></div>      	     
    	</div>
	<div class="row r5" style="margin-top:5%">
		<div class="col-sm-1"></div>  
		<div class="col-sm-6">
		<div id="selectedclass">
		<table class="table table-striped">
		<thead>
		 	<tr><th>선택한 과목 정보입니다.</th></tr>
		</thead>
		<tbody>
		</tbody> 	
		</table>
		</div>
		</div>
		<div class="col-sm-4" id="eventbtn">
		</div>
		<div class="col-sm-1"></div> 
	</div>
</div>
</div><!--  end main -->

<div id="choice">
<div class="container text-center" style="margin-top:5%">
  <img src="<%=request.getContextPath()%>/Main/images/choice.gif" alt="수강생의 선택">
</div>
</div>
<div id="videolist">
<div class="container">
	<div class="col-sm-1"></div>
	<div class="col-sm-10" >
	  <ul class="nav nav-tabs" id="listdetail">
	    <li class="active"><a data-toggle="tab" href="#home">전체보기</a></li>
	    <li><a data-toggle="tab" href="#menu1">기초영어</a></li>
	    <li><a data-toggle="tab" href="#menu2">토익</a></li>
	    <li><a data-toggle="tab" href="#menu3">토익스피킹</a></li>
	    <li><a data-toggle="tab" href="#menu4">오픽</a></li>
	      
	  </ul>	
	  <div class="tab-content" style="margin-top: 4%;">
	    <div id="home" class="tab-pane fade in active">
		      <div class="col-sm-6">
		      <iframe width="400" height="250" src="https://www.youtube.com/embed/1MsYmi9NKr0" frameborder="0"  allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe></div>   
		      <div class="col-sm-6">
		      <iframe width="400" height="250" src="https://www.youtube.com/embed/yz9SGnrlnuQ" frameborder="0"  allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe></div>          	   		
	   	</div>
	    <div id="menu1" class="tab-pane fade">
		      <div class="col-sm-6">
		      <iframe width="400" height="250" src="https://www.youtube.com/embed/wM1qDGARDe8" frameborder="0"   allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe></div>   
		      <div class="col-sm-6">
		      <iframe width="400" height="250" src="https://www.youtube.com/embed/NkdCa7NVLMY" frameborder="0"  allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe></div>
		</div>
	    <div id="menu2" class="tab-pane fade">
	      		<div class="col-sm-6">
	      		<iframe width="400" height="250" src="https://www.youtube.com/embed/_OEAUg1wE4Y" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe></div>
	      		<div class="col-sm-6">
	      		<iframe width="400" height="250" src="https://www.youtube.com/embed/8P-RSzgzBcY" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe></div>
	    </div>
	    <div id="menu3" class="tab-pane fade">
	     		<div class="col-sm-6">
	     		<iframe width="400" height="250" src="https://www.youtube.com/embed/QGRkz5BK4ig" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe></div>
	     		<div class="col-sm-6">
	     		<iframe width="400" height="250" src="https://www.youtube.com/embed/aDnK9WZFmVI" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe></div>
	    </div>
	    <div id="menu4" class="tab-pane fade">
	    		<div class="col-sm-6">
	    		<iframe width="400" height="250" src="https://www.youtube.com/embed/4UrgoCzpmFY" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe></div>
	      		<div class="col-sm-6">
	      		<iframe width="400" height="250" src="https://www.youtube.com/embed/TbUWPHS0Ljw" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe></div>
	    </div>
	   </div>
	</div><!-- end col-sm-10 -->
	<div class="col-sm-1"></div>
</div><!-- end container -->
</div>
<div class="sol_bg  teacher">
 	<div class="container text-center" style="margin-top:5%">
 		<h3 style="font-size: 44px;
    letter-spacing: -2px;">솔고다인강 스타강사</h3>
 	<p>솔고다인강의 대표 스타강사를 소개합니다.</p>
 	</div>	
<% 
	String [] teacherList = {"teacher1.png", "teacher2.png", "teacher3.png", "teacher4.png", 
			"teacher5.PNG", "teacher6.jpg", "teacher7.jpg", "teacher8.png" };
	String [] teachername = {"주지후", "이현석", "켈리정", "라수진", "Wonsun", "재석유", "한예슬", "Alex"};
	pageContext.setAttribute("teacherList", teacherList);	
	pageContext.setAttribute("teachername", teachername);

%> 	

<c:set var="page_total" value="${fn:length(teacherList)-1}" />
<c:set var="page_count" value="${page_total/4}"/>
<c:set var="page_mod" value="${page_total%4}"/>


<div class="container" style="margin-top:5%">
<div class="row">
  <div id="teachers" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
    <c:forEach begin="0" end="${Math.floor(page_total/4)}" step="1" varStatus="status">
      <li data-target="#teachers" data-slide-to="${status.index}" 
      style="background-color:black;" <c:if test="${status.first}">class="active"</c:if> >
      </li>
    </c:forEach>
    </ol>

    <div class="carousel-inner" role="listbox">
    <c:forEach begin="0" end="${page_count}" varStatus="status">
      <div class="item <c:if test="${status.first}"> active </c:if>"> 
       	<c:forEach begin="${status.index*4}" end="${status.index*4+3 }" step="1" var="dto"	items="${teacherList}" varStatus="status">
       	<div class="col-sm-3">
      	  	<a href="${pageContext.request.contextPath}/solgodadetail.teacher?tname=${teachername[status.index]}"><img id="teacherlink" src="${pageContext.request.contextPath}/Main/images/${dto}" alt="${dto}" ></a>
        </div>
     </c:forEach>
      
    </div>
</c:forEach>
</div>
    <a class="left carousel-control" href="#teachers" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#teachers" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>
</div><!-- end teachers -->
</div> <!-- end  -->


<div id="review" style="margin-top:5%">
	<div class="container">
		<div class="row r0" style="text-align:center;margin-bottom:3%">
		<h3 style=" font-size: 44px; letter-spacing: -2px;">수강후기</h3>
		<p >솔고다 수강생들의 생생 실시간 후기</p>
		</div>		
		<div class="row r1" id="reviewlist">
		</div>
		<p style="text-align:right"><a href="<%=request.getContextPath()%>/main.review" class="btn btn-danger">수강후기 더보기</a></p>
	</div>
</div><!--  end review -->
<div id="service" style="background-color:#f2f2f2">
	<div class="container">
		<div class="row r0 text-center" style="margin-bottom:3%; text-align:center; ">
		<h3 style=" font-size: 44px; letter-spacing: -2px;">통역서비스 이용하기</h3>
		<p >번역을 원하는 문장을 입력해주세요.</p>
		</div>
		<div class="row r0">
			<select name="language" id="language">
				<option value="nochoose">언어선택</option>
				<option value="korean">한국어</option>
				<option value="english">영어</option>
			</select>
		</div>
		<div class="text-center row r1" style="margin-top:2%"> 
			<div class="col-sm-6">

			<textarea rows="10" cols="50" id="beforesen" placeholder="번역을 원하는 문장을 입력해주세요."></textarea>
			</div>		
			<div class="col-sm-6" >
			<textarea rows="10" cols="50" id="aftersen"></textarea>
			</div>
		</div><!-- end row r1 -->
		<div class="text-center row r2">	
		<div class="col-sm-6">
			<button type="button" class="btn btn-primary" id="translate">번역하기</button>
		</div>	
		</div>		
	</div>
	
</div>

<div class="container" id="lastcontainer">
	<div class="panel-group col-sm-4">
			<div class="panel panel-default">
		 <div class="panel-heading">자바포트폴리오</div>
		 <div class="panel-body">
		 <iframe width="320" height="250" src="https://www.youtube.com/embed/GRZ-hn251F8" 
				frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
		 </div>
		 </div>
	</div>
	<div class="panel-group col-sm-4">
			<div class="panel panel-default">
		 <div class="panel-heading">공지사항</div>
		 <div class="panel-body" id="noticelist"></div>
		 </div>
	</div>
	
	
	<div class="panel-group col-sm-4">
	 	<div class="panel panel-default">
		 <div class="panel-heading"> 고객센터</div>
		 <div class="panel-body text-center">
     		<div class="row service r1" >
	     		<span style="font-size:18px" class="glyphicon glyphicon-earphone">02-6907-2489</span>
				<span style="font-size:18px" class="glyphicon glyphicon-time">평일09:00~18:00</span>
     		</div>
			<div class="row service r2">
				<a href="<%=request.getContextPath()%>/list.service" class="btn btn-default">자주묻는질문</a>
				<a href="<%=request.getContextPath()%>/write_view.consult" class="btn btn-default">1:1문의</a>
			</div>
			<div class="row service r3" >
				<a href="<%=request.getContextPath()%>/email_view.service" class="btn btn-default" style="width:88%" >문의메일 보내기</a>	
			</div>		
		</div>
		</div>	
	</div>
</div><!-- end container -->

















	<!-- moda test 2 -->
	<div class="container">
  <!-- 회원이 장바구니 눌렀을때 장바구니에 담겼다고 뜨는 Modal id는 mycart -->
  <div class="modal fade" id="newcart" role="dialog">
    <div class="modal-dialog">    
      <div class="modal-content">
        <div class="modal-header" style=" background-color:#466090;">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title" style=" background-color:#466090;
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







          
</body>
<%@ include file="/inc/footer.jsp"%>