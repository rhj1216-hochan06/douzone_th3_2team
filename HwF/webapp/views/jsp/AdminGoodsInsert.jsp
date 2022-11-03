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
<!-- 부트스트랩 css 사용 -->
<%-- <link rel="stylesheet" type="text/css" href="${path}/views/css/bootstrap.css"> --%>

<title>상품 등록</title>
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
			<a href="javascript:location.href='../../AdminMain.jsp'"><img class="contentTopImg" src="${path}/views/img/avataaars.svg" style="width: 100px; height: 100px" /></a>
			<br><br>
			<h1 class="contentTopText">관리자 [상품 등록] 페이지</h1>
			<br><br>
		</div>
		
		<div class="contentBottom">
			<br><br><br><br><br><br>
			<a href="javascript:location.href='AdminHealthGoodsInsert.jsp'"><img src="${path}/views/img/IconHealthGoods.png" alt="헬스용품 등록" style="width: 150px; height: 150px"><span>헬스용품 등록</span></a>
			<a href="javascript:location.href='AdminHealthFoodInsert.jsp'"><img src="${path}/views/img/IconHealthFood.png" alt="헬스식품 등록" style="width: 150px; height: 150px"><span>헬스식품 등록</span></a>
			<a href="javascript:location.href='AdminNutrientsInsert.jsp'"><img src="${path}/views/img/IconNutrients.png" alt="영양제 등록" style="width: 150px; height: 150px"><span>영양제 등록</span></a>
			<br><br><br><br><br><br><br>
		</div>
		
	</div> <!-- end content -->

	<!-- footer -->
	<footer>회사 이름, 대표 이름 등등</footer>

</body>
</html>