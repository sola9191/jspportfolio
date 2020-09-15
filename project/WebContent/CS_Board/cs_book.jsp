<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/inc/solgoda_header.jsp" %>

<script>
$(function(){
	
		 $("#bookreuslt").empty();
		 $.ajax({
			url:"${pageContext.request.contextPath}/findbook_list_AJAX",  
		 	type:"get",
		    dataType:"json",
		    data: { "booktitle" : "파고다" },
		    success:function(data){
		    	console.log(data);
		    	console.log(data.items);
		    	var items = data.items;
		    	var tabletag = $("<table class='table table-striped'>");
		    	var theadtag = $("<thead style='text-align:center;'><tr><th style='width:10%'>책표지</th><th style='width:40%'>책이름</th><th style='width:30%'>저자</th><th style='width:10%'>출판년도</th><th style='width:10%'>가격</th></tr></thead>");
		    	var tbodytag = $("<tbody>")
		    	for(var i =0 ; i<items.length ; i++){
		    		var title=items[i].title;
		    		var link=items[i].link;
		    		var author = items[i].author;
					var pubdate = items[i].pubdate;
					var price = items[i].price;
					var image =items[i].image;
				//동적태그만들기
				var trtag = $('<tr><td style="width:10%"><img src="'+image+'" alt="'+image+'"/></td><td style="width:40%"><a href="'+link+'"'+title+'</a></td><td style="width:30%">' +author
						+ '</td><td style="width:10%">'+pubdate+'</td><td style="width:10%">'+price+'</td></tr>');
		    	
				tbodytag.append(trtag);	
		    	
		    	}  	
				tabletag.append(theadtag).append(tbodytag);			
				$("#bookreuslt").append(tabletag);		
		    	
		    },
		    error:function(xhr, textStatus, errorThrown){
		    	$("#bookreuslt").html(textStatus+ "(HTTP: "+xhr.status+"/"+errorThrown);		    	
		    }	 
		 });	 
	 });

		 $(document).on("click", "#searchbook", function(){
			 $("#bookreuslt").empty();
			 $.ajax({
				url:"${pageContext.request.contextPath}/findbook_list_AJAX",  
			 	type:"get",
			    dataType:"json",
			    data: { "booktitle" : $("#booktitle").val() },
			    success:function(data){
			    	console.log(data);
			    	console.log(data.items);
			    	var items = data.items;
			    	var tabletag = $("<table class='table table-striped'>");
			    	var theadtag = $("<thead style='text-align:center;'><tr><th style='width:10%'>책표지</th><th style='width:40%'>책이름</th><th style='width:30%'>저자</th><th style='width:10%'>출판년도</th><th style='width:10%'>가격</th></tr></thead>");
			    	var tbodytag = $("<tbody>")
			    	for(var i =0 ; i<items.length ; i++){
			    		var title=items[i].title;
			    		var link =items[i].link;
			    		var link=items[i].link;
			    		var author = items[i].author;
						var pubdate = items[i].pubdate;
						var price = items[i].price;
						var image =items[i].image;
					//동적태그만들기
					var trtag = $('<tr><td style="width:10%"><img src="'+image+'" alt="'+image+'"/></td><td style="width:40%"><a href="'+link+'"'+title+'</a></td><td style="width:30%">' +author
						+ '</td><td style="width:10%">'+pubdate+'</td><td style="width:10%">'+price+'</td></tr>');
			    	
					tbodytag.append(trtag);	
			    	
			    	}  	
					tabletag.append(theadtag).append(tbodytag);			
					$("#bookreuslt").append(tabletag);		
			    	
			    },
			    error:function(xhr, textStatus, errorThrown){
			    	$("#bookreuslt").html(textStatus+ "(HTTP: "+xhr.status+"/"+errorThrown);		    	
			    }	 
			 });	 
		 });

</script>
<div id="main" style="background-color:#CCCCCC; height:200px"  >
	<div class="container text-center">
	<h3>솔고다 도서검색기능</h3>
	<p>원하시는 도서의 제목을 검색해주세요</p>
	</div>
	
	<div class="container text-center" style="margin-top:2%">
	<input type="search" style="width:50%; height:40px" id="booktitle"
	placeholder="검색을 원하는 책타이틀을 입력해주세요.">
	<input type="button" id="searchbook" name="searchbook" value="검색하기" class="btn btn-danger" >
	</div>	
</div>
	<div class="container" id="bookreuslt" style="margin-top:5%;" ></div>

<%@ include file="/inc/footer.jsp" %>