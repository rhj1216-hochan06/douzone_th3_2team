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
<meta name="viewport" content="widt	h=device-width, initial-scale=1.0" />
<link rel="stylesheet" type="text/css"
	href="${path}/views/css/MainCss.css">
<link rel="stylesheet" type="text/css"
	href="${path}/views/css/listqna.css" />
<title>detail.jsp 상세보기 페이지</title>
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
					<!-- <td id="1" onclick="location.href='./views/main.jsp">Home</td> -->
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
		<div class="headerqna">1:1 문의</div>
		<div class="side">side bar</div>
		<div class="main">
			<a href="Member?cmd=membersearch">돌아가기</a>
			
			<table class="qnatable" width="1000" cellpadding="3">

					<tr>
						<td> 번 호 : ${ dto.qnaid }</td>
						<td> 아이디 : ${ dto.memberid }</td>
						<td> 제 목 :${ dto.qnatitle }</td>
					</tr>

					<tr>
						<td>날 짜 : ${ dto.qnadate }</td>
						<td>내 용 : ${ dto.qnacontent }</td>
						<td>답 변 : ${ dto.qnaanswer }</td>
					</tr>
					
<%-- 				<tr>
					<td colspan="4" align="right">
					<input type="button" value="수정"
						onclick="href='board?cmd=updateform&qnaid=${ dto.qnaid }'" method="post"/>
						 
				<form action="board?cmd=updateform&qnaid=${ dto.qnaid }" method="post">
					<input type = "hidden" name = "qnaid" value = '${dto.qnaid}'>
					<input type="submit" value = "수정">
				</form> 
						
						<input type="button" value="삭제"
						onclick="href='board?cmd=delete&qnaid=${ list.qnaid }'" /> <input
						type="button" value="답변"
						onclick="href='board?cmd=reply&qnaid=${ list.qnaid }'" /></td>
				</tr> --%>

			</table>
		</div>
		<div class="footer">footer</div>
	</div>

</body>
</html>