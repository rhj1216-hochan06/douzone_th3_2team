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
<title>HealthGoodsSelect.jsp</title>
</head>

<!-- 해당 페이지만 단일 실행시 주소경로 : http://localhost:8080/HwF/views/jsp/AdminMemberSelect.jsp -->

<body>

	<!-- header -->
	<header>
		<div id="headerFirstDiv">
			<div>
				<img src="${path}/views/img/logo.png" /> <!-- <img src="../img/logo.png" /> -->
			</div>
			<div>상품 조회 페이지</div>
		</div>
	</header>
	
	<h3>헬스용품</h3>
	<table border="1" width="900">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>가격</th>
			<th>카테고리</th>
			<th>이미지</th>
			<th>상세설명</th>
		</tr>

		<c:forEach var="HealthGoodsSelect" items="${ HealthGoodsSelect }">
			<tr>
				<td>${ HealthGoodsSelect.healthGoodsId }</td>
				<td>${ HealthGoodsSelect.healthGoodsName }</td>
				<td>${ HealthGoodsSelect.healthGoodsPrice }</td>
				<td>${ HealthGoodsSelect.healthGoodsCategory }</td>
				<td><img src="${ HealthGoodsSelect.healthGoodsImg }" style="width: 100px; height: 100px"/></td>
				<td>${ HealthGoodsSelect.healthGoodsDetail }</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	
	
		
	<!-- 	<input type="button" value="고객 정보 등록" onclick=" javascript:window.location.href='writeForm.do' ">
	<input type="button" value="고객 정보 수정" onclick=" javascript:window.location.href='updateForm.do' ">
	<input type="button" value="고객 정보 삭제" onclick=" javascript:window.location.href='deleteForm.do' "> -->

	<!-- footer -->
	<footer>회사 이름, 대표 이름 등등</footer>

</body>
</html>