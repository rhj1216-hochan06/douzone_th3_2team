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
<script type="text/javascript" defer src="${path}/views/js/suveylist.js"></script>

<title>Surveylist</title>
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
			<form action="search?cmd=searching" method="post">
				<p>
					<input type="hidden" name="column"> <input type="text"
						name="keyvalue" value="" placeholder="Search">
				</p>
			</form>

			<table>
				<tr>
					<td id="1" onclick="change(this.id)">Home</td>
					<td id="2" onclick="change(this.id)">HealthGoods</td>
					<td id="3" onclick="change(this.id)">HealthFood</td>
					<td id="4" onclick="change(this.id)">HealthNutrients</td>
					<td id="5" onclick="change(this.id)">Survey</td>
					<td id="6" onclick="change(this.id)">InbodyTest</td>
					<td id="7" onclick="change(this.id)">Community</td>
				</tr>
			</table>
		</nav>
	</header>
	<table>
		<tr id="survey">
			<td>Survey<input type="button" value="Survey"
				onclick="location.href='Member?cmd=survey'"></td>
		</tr>
		<thead>

			<tr>
				<th>설문 아이디</th>
				<th>목표</th>
				<th>현재 상태</th>
				<th>섭취 상태</th>
				<th></th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="SurveyserachAll" items="${ SurveyserachAll}">
				<form action="location.href='Member?cmd=surveyDelete" method="post"
					id="formsurveyDelete">
					<tr>
						<td>설문 아이디 :<input name="surveyid"
							value="${SurveyserachAll.surveyid }" readonly>
						</td>
						<td>목표 : ${ SurveyserachAll.goal }</td>
						<td>현재 상태 : ${ SurveyserachAll.currentstate }</td>
						<td>섭취 상태: ${SurveyserachAll.currentintke}</td>
						<td><input type="submit" value="삭제"
							onclick='return submitDelete(this.form);'></td>
					</tr>
				</form>
			</c:forEach>

		</tbody>
	</table>


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