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
<link rel="stylesheet" type="text/css" href="${path}/views/css/introduce.css" />
<script type="text/javascript" src="../js/MainJS.js"></script>
<title>searching</title>
</head>
<body>

<article class = "introduce">
		<div class = "intro">추천 페이지입니다.</div>
</article>

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
				<th>식 품 이름</th>
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
					<td><img alt="사진" src="${list.nutrientsIMG } "></td>
					<td>${ NutrientsSelect.nutrientsName }</td>
					<td>${ NutrientsSelect.nutrientsPrice }</td>
					<td>${ NutrientsSelect.nutrientsDetail}</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>

</body>
</html>