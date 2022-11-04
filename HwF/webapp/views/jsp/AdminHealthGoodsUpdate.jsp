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
<title>헬스용품 수정</title>
</head>

<!-- 해당 페이지만 단일 실행시 주소경로 : http://localhost:8080/HwF/views/jsp/AdminHealthGoodsInsert.jsp -->

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
			<h1 class="contentTopText">관리자 [헬스용품 수정] 페이지</h1>
			<br><br>
		</div>
	
		<div class="contentBottom">
			<br>
			<h3>헬스용품 수정</h3>
			
			<form action="./admin?cmd=AdminHealthGoodsUpdate" method="post"> <!-- <form action="admin?cmd=AdminHealthGoodsUpdate"과 동일한 결과 -->
				<table style="margin-left: auto; margin-right:auto;">
					<tr><td>번호</td><td><input type="number" name="healthGoodsId" value="${ param.healthGoodsId }"> </td></tr>
					<tr><td>이름</td><td><input type="text" name="healthGoodsName" value="${ com.hwf.model.GoodsDTO.healthGoodsName }"> </td></tr>
					<tr><td>가격</td><td><input type="number" name="healthGoodsPrice" value="${ com.hwf.model.GoodsDTO.healthGoodsPrice }"> </td></tr>
					<tr><td>카테고리</td><td><input type="number" name="healthGoodsCategory" value="${ com.hwf.model.GoodsDTO.healthGoodsCategory }"> </td></tr>
					<tr><td>이미지</td><td><input type="text" name="healthGoodsImg" value="${ com.hwf.model.GoodsDTO.healthGoodsImg }"> </td></tr>
					<tr><td>상세설명</td><td><textArea rows="5" cols="50" name="healthGoodsDetail">${ com.hwf.model.GoodsDTO.healthGoodsDetail }</textArea></td></tr>
					<tr><td>설문조사 링크</td><td><input type="number" name="healthGoodsLink" value="${ com.hwf.model.GoodsDTO.healthGoodsLink }"> </td></tr>
				</table>
				<br><br>
				<input type="submit" value="수정">    
			</form>
			
			<br>
		</div> <!-- end contentBottom -->
		
	</div> <!-- end content -->
	


	<!-- footer -->
	<footer>회사 이름, 대표 이름 등등</footer>

</body>
</html>