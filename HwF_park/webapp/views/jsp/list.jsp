<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" type="text/css" href="${path}/views/css/MainCss.css">
<link rel="stylesheet" type="text/css" href="${path}/views/css/listqna.css" />
<title>list.jsp List Page</title>
<style type="text/css">
th {
	background: orange
}
;				
</style>
</head>
<body>
<body>
	<header>
		<div id="headerFirstDiv">
			<div>
				<img src="${path}/views/img/logo.png" />
			</div>
			<div>홈페이지 제목 (팀명)</div>
		</div>

		<nav>
			<p>
				<input type="text" value="" placeholder="Search" />
			</p>

			<table>
				<tr>
					<td id="1" onclick="location.href='./views/main.jsp">Home</td>
					<td id="2" onclick="change(this.id)">HealthFood</td>
					<td id="3" onclick="change(this.id)">HealthCafe</td>
					<td id="4" onclick="change(this.id)">HealthNutrients</td>
					<td id="5" onclick="change(this.id)">Survey</td>
					<td id="6" onclick="change(this.id)">InbodyTest</td>
					<td id="7" onclick="location.href='board?cmd=list'">Community</td>
				</tr>
			</table>
		</nav>
	</header>
	<p></p>
	<p></p>
	<div class="container">
		<div class="headerqna">1:1 문의</div>
		<div class="side">side bar</div>
		<div class="main">
			<a href="jsp/writeform.jsp">글쓰기</a>
			<a href="jsp/searchList.jsp">검색</a>
	<table class="qnatable" width="700" cellpadding="3">
		<tr>
			<th width="50">번호</th>
			<th width="270">날짜</th>
			<th width="270">제목</th>
			<th width="200">답변</th>
			<th width="100">이름</th>

		</tr>

		<c:forEach var="list" items="${list}">

			<tr>
				<td>${ list.qnaid }</td>
				<td>${ list.qnadate }</td>
				<td>${ list.qnacontent }</td>
				<td>${ list.qnaanswer }</td>
				<td>${ list.memberid }</td>


			</tr>
		</c:forEach>
		
		
<%-- 				<c:forEach var="list" items="${list}">

			<tr>
				<td>${ list.qnaid }</td>
				<td>${ list.qnadate }</td>
				<td>${ list.qnacontent }</td>
				<td>${ list.qnaanswer }</td>
				<td>${ list.memberid }</td>


			</tr>
		</c:forEach> --%>
		
	</table>


		</div>

		<div class="footer">footer</div>
	</div>
</body>
</html>