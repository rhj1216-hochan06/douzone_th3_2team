<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" type="text/css"
	href="${path}/views/css/allList.css" />
<script type="text/javascript" src="${path}/views/js/all.js"></script>
<title>Survay</title>
</head>
<body>
	<header>
		<div id="headerFirstDiv">
			<div>
				<img src="${path}/views/img/logo.png" />
			</div>
			<div>홈페이지 제목 (팀명)</div>
		</div>

		<nav>
			<p>
				<input type="text" value="" placeholder="Search" />
			</p>

			<table>
				<tr>
					<td id="1" onclick="change(this.id)">Home</td>
					<td id="2" onclick="change(this.id)">HealthFood</td>
					<td id="3" onclick="change(this.id)">HealthCafe</td>
					<td id="4" onclick="change(this.id)">HealthNutrients</td>
					<td id="5" onclick="change(this.id)">Survey</td>
					<td id="6" onclick="change(this.id)">InbodyTest</td>
					<td id="7" onclick="change(this.id)">Community</td>
				</tr>
			</table>
		</nav>
	</header>
	<div id="form">
		<form action="./Member?cmd=surveyresult" method="post">
			당신의 목표는? : <select name="goal">
				<option value="1">근육 만들기~~~</option>
				<option value="2">다이어트!</option>
			</select> <br> 
			일어선 상태로 고개만 숙여 발을 본다면?: <select name="currentstate">
				<option value="1">배만 보인다</option>
				<option value="2">발이 배에 살짝 가려저 보인다.</option>
				<option value="3">발이 잘 보인다</option>
			</select> <br> 
			삼시세끼를 영양소를 구분해 잘 챙겨 먹는다: <select name="currentintke">
				<option value="1"> 항상 배가 부를 때 까지 먹는다</option>
				<option value="2"> 적당히 배부를게 잘 챙겨 먹는다</option>
				<option value="3"> 끼니는 대충 해결 하는것 영양소는 중요하지 않다.</option>
			</select> <br>
			<input type="submit" value="제출" >
		</form>
	</div>




	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	
	<footer>회사 이름, 대표 이름 등등</footer>
</body>
</html>