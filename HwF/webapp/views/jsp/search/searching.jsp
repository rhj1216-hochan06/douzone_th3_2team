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
<link rel="stylesheet" type="text/css" href="${path}/views/css/MainCss.css" />
<link rel="stylesheet" type="text/css" href="${path}/views/css/search.css" />
<script type="text/javascript" src="../js/MainJS.js"></script>
<title>searching</title>
</head>
<body>
	<h3>상품검색</h3>
	<!-- <form action="../search?cmd=searching" method="post"> -->
	<form action="../../../search?cmd=searching" method="post">
		<select name="column">
			<option value="healthGoodsName">품목</option>
			<option value="hfname">품목</option>
			<option value="nutrientsName">품목</option>
		</select> 
		<input type="text" name="keyvalue"> <input type="submit" value="검색">
	</form>

	<h3>다중검색하기</h3>
	
	<form action="board?cmd=searching" method="post">
		<input type="checkbox" name="healthGoodsName" value="healthGoodsName" checked>
		   헬스용품 : <input	type="checkbox" name="hfName" value="hfName">
			식품 : <input type="checkbox" name="nutrientsName" value="nutrientsName">영양제 <br> 
			내용 : <input	type="text" name="keyvalue"> <input type="submit" value="검색">
	</form>

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
				<tr>
					<td><img alt="사진" src="${HealthGoodsSelect.healthgoodsIMG } "></td>
					<td>${ HealthGoodsSelect.healthgoodsName }</td>
					<td>${ HealthGoodsSelect.healthgoodsPrice }</td>
					<td>${ HealthGoodsSelect.healthgoodsDetail}</td>
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
				<tr>
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
				<tr>
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