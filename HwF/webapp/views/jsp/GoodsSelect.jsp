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
<title>전체상품 조회</title>
</head>

<!-- 해당 페이지만 단일 실행시 주소경로 : http://localhost:8080/HwF/views/jsp/GoodsSelect.jsp -->

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
			<h1 class="contentTopText">관리자 [전체상품 조회] 페이지</h1>
			<br><br>
		</div>
	
		<div class="contentBottom">
		
			<br><br>
		
			<details>
			<summary><h3>헬스용품</h3></summary>
			
			<table border="1" width="900" style="margin-left: auto; margin-right:auto;">
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>가격</th>
					<th>카테고리</th>
					<th>이미지</th>
					<th>상세설명</th>
					<th>추천 링크</th>
				</tr>
		
				<c:forEach var="HealthGoodsSelect" items="${ HealthGoodsSelect }">
					<tr>
						<td>${ HealthGoodsSelect.healthGoodsId }</td>
						<td>${ HealthGoodsSelect.healthGoodsName }</td>
						<td>${ HealthGoodsSelect.healthGoodsPrice }</td>
						<td>${ HealthGoodsSelect.healthGoodsCategory }</td>
						<td><img src="${ HealthGoodsSelect.healthGoodsImg }" style="width: 100px; height: 100px"/></td>
						<td>${ HealthGoodsSelect.healthGoodsDetail }</td>
						<td>${ HealthGoodsSelect.link }</td>
					</tr>
				</c:forEach>
			</table>
			
			<br>
			</details>
			
			
			
			<details>
			<summary><h3>헬스식품</h3></summary>
			
			<table border="1" width="900" style="margin-left: auto; margin-right:auto;">
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>가격</th>
					<th>카테고리</th>
					<th>이미지</th>
					<th>상세설명</th>
					<th>제조날짜</th>
					<th>추천 링크</th>
				</tr>
		
				<c:forEach var="HealthFoodSelect" items="${ HealthFoodSelect }">
					<tr>
						<td>${ HealthFoodSelect.hfId }</td>
						<td>${ HealthFoodSelect.hfName }</td>
						<td>${ HealthFoodSelect.hfPrice }</td>
						<td>${ HealthFoodSelect.hfCategory }</td>
						<td><img src="${ HealthFoodSelect.hfImg }" style="width: 100px; height: 100px"/></td>
						<td>${ HealthFoodSelect.hfDetail }</td>
						<td>${ HealthFoodSelect.hfDom }</td>
						<td>${ HealthFoodSelect.link }</td>
					</tr>
				</c:forEach>
			</table>
			
			<br>
			</details>
			
			
			
			<details>
			<summary><h3>영양제</h3></summary>
			
			<table border="1" width="900" style="margin-left: auto; margin-right:auto;">
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>가격</th>
					<th>카테고리</th>
					<th>이미지</th>
					<th>상세설명</th>
					<th>제조날짜</th>
					<th>1일 섭취 갯수</th>
					<th>1통 당 갯수</th>
					<th>현재 잔여 갯수</th>
					<th>추천 링크</th>
				</tr>
		
				<c:forEach var="NutrientsSelect" items="${ NutrientsSelect }">
					<tr>
						<td>${ NutrientsSelect.nutrientsId }</td>
						<td>${ NutrientsSelect.nutrientsName }</td>
						<td>${ NutrientsSelect.nutrientsPrice }</td>
						<td>${ NutrientsSelect.nutrientsCategory }</td>
						<td><img src="${ NutrientsSelect.nutrientsImg }" style="width: 100px; height: 100px"/></td>
						<td>${ NutrientsSelect.nutrientsDetail }</td>
						<td>${ NutrientsSelect.nutrientsDom }</td>
						<td>${ NutrientsSelect.dailyIntake }</td>
						<td>${ NutrientsSelect.numPerBottle }</td>
						<td>${ NutrientsSelect.remainingNum }</td>
						<td>${ NutrientsSelect.link }</td>
					</tr>
				</c:forEach>
			</table>
			
			<br>
			</details>
			
			<br>
		
			</div> <!-- end contentBottom -->
			
		</div> <!-- end content -->
	


	<!-- footer -->
	<footer>회사 이름, 대표 이름 등등</footer>

</body>
</html>