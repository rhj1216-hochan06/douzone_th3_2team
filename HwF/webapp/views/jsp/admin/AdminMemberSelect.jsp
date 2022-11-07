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
<title>회원 조회</title>
</head>

<!-- 해당 페이지만 단일 실행시 주소경로 : http://localhost:8080/HwF/views/jsp/AdminMemberSelect.jsp -->

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
	
	
	
	<!-- content -->
	<div class="content">
	
		<div class="contentTop">
			<br><br>
			<a href="javascript:location.href='AdminMain.jsp'"><img class="contentTopImg" src="${path}/views/img/avataaars.svg" style="width: 100px; height: 100px" /></a>
			<br><br>
			<h1 class="contentTopText">관리자 [회원 조회] 페이지</h1>
			<br><br>
		</div>
		
		<div class="contentBottom">	
			<br><br><br><br><br><br>
			
			<table border="1" width="900" style="margin-left: auto; margin-right:auto;">
				<tr class="tableTitle">
					<th>아이디</th>
					<!-- <th>비번</th> -->
					<th>이름</th>
					<th>성별</th>
				</tr>
		
				<c:forEach var="AdminMemberSelect" items="${ AdminMemberSelect }">
					<tr>
						<td>${ AdminMemberSelect.memberId }</td>
						<%-- <td>${ AdminMemberSelect.memberPwd }</td> --%>
						<td>${ AdminMemberSelect.memberName }</td>
						<td>${ AdminMemberSelect.memberSex }</td>
					</tr>
				</c:forEach>
			</table>
	
			<br><br><br><br><br><br>
		</div> <!-- end contentBottom -->
		
	</div> <!-- end content -->

	<!-- footer -->
	<footer>회사 이름, 대표 이름 등등</footer>

</body>
</html>