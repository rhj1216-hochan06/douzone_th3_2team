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
<link rel="stylesheet" type="text/css"
	href="${path}/views/css/MainCss.css">
<link rel="stylesheet" type="text/css"
	href="${path}/views/css/listqna.css" />
	<link rel="stylesheet" type="text/css"
	href="${path}/views/css/listqna.css" />
<title>list.jsp List Page</title>
<style type="text/css">
th {
	background: orange
}
;
</style>
</head>
<body>
	<header>
		<div id="headerFirstDiv">
			<div>
				<img src="${path}/views/img/logo.png" />
			</div>
			<div>홈페이지 제목 (팀명)</div>
		</div>

		<nav>
			<form action="search?cmd=searching" method="post">
				<p>
					<input type="hidden" name="column"> <input type="text"
						name="keyvalue" value="" placeholder="Search">
				</p>
			</form>

			<table>
				<tr>
					<td id="1" onclick="location.href='/HwF/Main.jsp'">Home</td>
					<td id="2" onclick="change(this.id)">HealthFood</td>
					<td id="3" onclick="change(this.id)">HealthCafe</td>
					<td id="4" onclick="location.href='nutrients?cmd=list'">HealthNutrients</td>
					<td id="5" onclick="location.href='Member?cmd=surveylist'">Survey</td>
               		<td id="6" onclick="location.href='Member?cmd=inbodylist'">InbodyTest</td>
					<td id="7" onclick="location.href='Member?cmd=membersearch'">Community</td>
				</tr>
			</table>
		</nav>
	</header>
	<p></p>
	<p></p>

	<div class="container">
		<div class="headerqna" >1:1 문의</div>
		<div class="side">side bar</div>
		<div class="main">
			<a href="./views/jsp/qna/writeform.jsp">글쓰기</a>
<!-- 			<a href="./views/jsp/qna/searchList.jsp">검색</a> -->
		<th align="right">
		<tr>
		<form action="Member?cmd=membersearchboard" method="post">		
		<select name="column">
			<option value="qnadate">날짜</option>
			<option value="qnatitle">제목</option>
			<option value="qnacontent">내용</option>
			<option value="qnaanswer">답변</option>
			<option value="memberid">아이디</option>
		</select>
		<input type="text" name="keyvalue" value="" placeholder="Search">
		</tr>
		</form>
		</th> 
			

			<table class="qnatable" width="1800" cellpadding="3">
				<tr>
					<th width="50">번호</th>
					<th width="350">날짜</th>
					<th width="300">제목</th>
					<th width="500">내용</th>
					<th width="500">답변</th>
<!-- 					<th width="100">이름</th>
					<th width="100">삭제</th> -->

				</tr>

				<c:forEach var="list" items="${list}">

					<tr>
						<td>${ list.qnaid }</td>
						<td>${ list.qnadate }</td>
						<td>${ list.qnatitle }</td>
						<%-- <td><a
							href="javascript:location.href='board?cmd=detail&qnaid=${ list.qnaid }' ">${ list.qnacontent }</a></td> --%>
							<td onclick="javascript:location.href='board?cmd=detail&qnaid=${ list.qnaid }' ">${ list.qnacontent }</td>
						<td>${ list.qnaanswer }</td>
						<%-- <td>${ list.memberid }</td>
						<td><a
							href="javascript:location.href='board?cmd=delete&qnaid=${ list.qnaid }' ">삭제하기</a></td> --%>

					</tr>
				</c:forEach>
			</table>
		</div>

		<div class="footer">footer</div>
	</div>
</body>
</html>