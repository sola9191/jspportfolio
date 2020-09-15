<%@page import="com.pagoda.dto.Cre_Acc_Dto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file ="/inc/solgoda_header.jsp"%>
<% Cre_Acc_Dto dto = (Cre_Acc_Dto) request.getAttribute("dto"); %>
<div id="main">
<div class="container">
	<h3>내정보관리</h3>
</div>
	<div class="container well">
		<div class="form-group">
			<p style="font-size:20px; font-weight:bold;"><%=dto.getPname()%>님의 정보입니다.</p>			
				<table class="table table-striped">
					<tbody>
						<tr>
							<th scope="row">이름</th>
							<td><%=dto.getPname()%></td>
						</tr>
						<tr>
							<th scope="row">휴대폰번호</th>
							<td><%=dto.getPphonenumber()%></td>
						</tr>
						<tr>
							<th scope="row">아이디</th>
							<td><%=dto.getPid()%></td>
						</tr>
						<tr>
							<th scope="row">이메일</th>
							<td><%=dto.getPemail()%></td>
						</tr>
					</tbody>
				</table>
			</div>
		<div class="form-group text-right">
			<a href="<%=request.getContextPath()%>/enterDelete_view.do" class="btn btn-danger">회원 탈퇴</a>
			<a href="<%=request.getContextPath()%>/enterEditInfo_view.do" class="btn btn-primary">회원정보수정</a>
		</div>
	</div>
</div>
<%@ include file="/inc/footer.jsp"%>
