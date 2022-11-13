<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" type="text/css"
	href="${path}/views/css/MainCss.css" />
<link rel="stylesheet" type="text/css"
	href="${path}/views/css/search.css" />
<title>searchpage</title>
</head>
<body>

	<header>
		<div id="headerFirstDiv">
			<div>
				<a href="javascript:location.href='Main.jsp'"><img src="${path}/views/img/logo.png" /></a>
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
					<td id="4" onclick="change(this.id)">HealthNutrients</td>
					<td id="5" onclick="location.href='Member?cmd=surveylist'">Survey</td>
					<td id="6" onclick="location.href='Member?cmd=inbodylist'">InbodyTest</td>
					<td id="7" onclick="location.href='Member?cmd=membersearch'">Community</td>
				</tr>
			</table>
		</nav>
	</header>

	<table>
		<thead>
			<tr>
				<th>이미지</th>
				<th>헬스용품 이름</th>
				<th>가격</th>
				<th>상세설명</th>

			</tr>
		</thead>
		<tbody>

			<c:forEach var="HealthGoodsSelect" items="${ HealthGoodsSelect }">
				<tr id="${HealthGoodsSelect.healthGoodsId}"
					title="${HealthGoodsSelect.healthGoodsName}의 상세 페이지 가기"
					onclick="location.href='healthgoods?cmd=healthGoodsDetail&healthGoodsId=${HealthGoodsSelect.healthGoodsId}'">
					<td><img alt="사진" src="${HealthGoodsSelect.healthGoodsImg } "></td>
					<td>${ HealthGoodsSelect.healthGoodsName }</td>
					<td>${ HealthGoodsSelect.healthGoodsPrice }</td>
					<td>${ HealthGoodsSelect.healthGoodsDetail}</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>

	<table>
		<thead>
			<tr>
				<th>이미지</th>
				<th>식품 이름</th>
				<th>가격</th>
				<th>상세설명</th>

			</tr>
		</thead>

		<tbody>
			<c:forEach var="HealthFoodSelect" items="${ HealthFoodSelect }">
				<tr id="${HealthFoodSelect.hfid}"
					title="${HealthFoodSelect.hfname}의 상세 페이지 가기"
					onclick="location.href='healthfood?cmd=healthFoodDetail&hfid=${HealthFoodSelect.hfid}'">
					<td><img alt="사진" src="${HealthFoodSelect.hfimg } "></td>
					<td>${ HealthFoodSelect.hfname }</td>
					<td>${ HealthFoodSelect.hfprice }</td>
					<td>${ HealthFoodSelect.hfdetail}</td>
				</tr>
			</c:forEach>

		</tbody>

	</table>

	<table>
		<thead>
			<tr>
				<th>이미지</th>
				<th>영양제 이름</th>
				<th>가격</th>
				<th>상세설명</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach var="NutrientsSelect" items="${ NutrientsSelect }">
				<tr id="${NutrientsSelect.nutrientsID}"
					title="${NutrientsSelect.nutrientsName}의 상세 페이지 가기"
					onclick="location.href='nutrients?cmd=nutrientsDetail${NutrientsSelect.nutrientsID}'">
					<td><img alt="사진" src="${NutrientsSelect.nutrientsIMG } "></td>
					<td>${ NutrientsSelect.nutrientsName }</td>
					<td>${ NutrientsSelect.nutrientsPrice }</td>
					<td>${ NutrientsSelect.nutrientsDetail}</td>
				</tr>
			</c:forEach>


		</tbody>
	</table>

</body>
</html>