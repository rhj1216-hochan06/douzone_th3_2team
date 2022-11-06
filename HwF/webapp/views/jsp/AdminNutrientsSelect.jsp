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
<title>영양제 관리</title>
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
	
	
	
	<!-- content -->
	<div class="content">
	
		<div class="contentTop">
			<br><br>
			<a href="javascript:location.href='AdminMain.jsp'"><img class="contentTopImg" src="${path}/views/img/avataaars.svg" style="width: 100px; height: 100px" /></a> 
			<br><br>
			<h1 class="contentTopText">관리자 [영양제 관리] 페이지</h1>
			<br><br>
		</div>
	
		<div class="contentBottom">
		
			<br><br>
			
			<h3>영양제 관리</h3> <br>
			
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
					<!-- <th>추천 링크</th> -->
				</tr>
		
				<c:forEach var="AdminNutrientsSelect" items="${ AdminNutrientsSelect }">
					<tr class="row" id="${AdminNutrientsSelect.nutrientsId}" title="${AdminNutrientsSelect.nutrientsName} 수정"
						onclick="location.href='admin?cmd=AdminNutrientsDetail&nutrientsId=${AdminNutrientsSelect.nutrientsId}'" >
						<td>${ AdminNutrientsSelect.nutrientsId }</td>
						<td>${ AdminNutrientsSelect.nutrientsName }</td>
						<td>${ AdminNutrientsSelect.nutrientsPrice }</td>
						<td>${ AdminNutrientsSelect.nutrientsCategory }</td>
						<td><img src="${ AdminNutrientsSelect.nutrientsImg }" style="width: 100px; height: 100px"/></td>
						<td>${ AdminNutrientsSelect.nutrientsDetail }</td>
						<td>${ AdminNutrientsSelect.nutrientsDom }</td>
						<td>${ AdminNutrientsSelect.dailyIntake }</td>
						<td>${ AdminNutrientsSelect.numPerBottle }</td>
						<td>${ AdminNutrientsSelect.remainingNum }</td>
						<%-- <td>${ AdminNutrientsSelect.nutrientsLink }</td> --%>
					</tr>
				</c:forEach>
			</table>
			
			<br><br>
		
		</div> <!-- end contentBottom -->
			
	</div> <!-- end content -->



	<!-- footer -->
	<footer>회사 이름, 대표 이름 등등</footer>

</body>
</html>