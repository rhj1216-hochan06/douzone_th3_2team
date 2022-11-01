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
<link rel="stylesheet" type="text/css" href="${path}/views/css/MainCss.css">
<title>AdminUserSelect.jsp</title>
</head>

<!-- 해당 페이지만 단일 실행시 주소경로 : http://localhost:8080/HwF/views/jsp/AdminUserSelect.jsp -->

<body>

	<header>
		<div id="headerFirstDiv">
			<div>
				<img src="${path}/views/img/logo.png" /> <!-- <img src="../img/logo.png" /> -->
			</div>
			<div>홈페이지 제목 (팀명)</div>
		</div>
	</header>
	
	<h1>회원 조회 페이지</h1>

	<table border="1" width="900">
		<tr>
			<th>아이디</th>
			<!-- <th>비번</th> -->
			<th>이름</th>
			<th>성별</th>
		</tr>

		<c:forEach var="AdminUserSelect" items="${ AdminUserSelect }">
			<tr>
				<td>${ AdminUserSelect.memberId }</td>
				<%-- <td>${ AdminUserSelect.memberPwd }</td> --%>
				<td>${ AdminUserSelect.memberName }</td>
				<td>${ AdminUserSelect.memberSex }</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<!-- 	<input type="button" value="고객 정보 등록" onclick=" javascript:window.location.href='writeForm.do' ">
	<input type="button" value="고객 정보 수정" onclick=" javascript:window.location.href='updateForm.do' ">
	<input type="button" value="고객 정보 삭제" onclick=" javascript:window.location.href='deleteForm.do' "> -->

	<footer>회사 이름, 대표 이름 등등</footer>

</body>
</html>