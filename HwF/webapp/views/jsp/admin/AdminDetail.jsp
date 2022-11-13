<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- JSTL 사용하기 위해 태그라이브러리 임포트 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" type="text/css" href="${path}/views/css/AdminCss.css">

<title>고객 QnA</title>
</head>

<body>

	<!-- header -->
	<header>
		<div id="headerFirstDiv">
			<div>
				<img src="${path}/views/img/logo.png" /> <!-- <img src="../img/logo.png" /> -->
			</div>
			<div>홈페이지 제목 (팀명)</div>
		</div>
	</header>

	<!-- content-->
	<div class="content">
	
		<div class="contentTop">
			<br><br>
			<a href="javascript:location.href='AdminMain.jsp'"><img class="contentTopImg" src="${path}/views/img/avataaars.svg" style="width: 100px; height: 100px" /></a>
			<br><br>
			<h1 class="contentTopText">관리자 [상품 관리] 페이지</h1>
			<br><br>
		</div>
		
		<div class="main">		
		
		<table class="qnatable" width="700" cellpadding="3" style="margin-left: auto; margin-right:auto;">
		<th>
		<a href="./views/jsp/qna/writeform.jsp">글쓰기</a> 
		<a href="./views/jsp/qna/searchList.jsp">검색</a>
		</th>
		<tr>
				
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

				<tr>
					<td colspan="4" align="right">
				<form action="./admin?cmd=AdminQnaUpdate" method="post">
					<table style="margin-left: auto; margin-right:auto;">
					<tr><td>답 변</td><td>
					<input type="String" name="qnaanswer" value="${ dto.qnaanswer }"required> 
					<input type = "hidden" name ="qnaid" value = "${ dto.qnaid }"required></td></tr>
					<input type="submit" value="답변달기">
					</table>
				</form>
					<br><br>
					<input type="button" value="삭제"
						onclick="href='admin?cmd=delete&qnaid=${ dto.qnaid }'" /> 
					</td>
				</tr>
		</table>
	
		</div>
	</div> <!-- end content -->

	<!-- footer -->
	<footer>회사 이름, 대표 이름 등등</footer>

</body>
</html>