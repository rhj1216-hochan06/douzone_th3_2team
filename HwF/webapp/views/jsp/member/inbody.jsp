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
<link rel="stylesheet" type="text/css" href="${path}/views/css/allList.css" />
<script type="text/javascript" src="${path}/views/js/all.js"></script>
<title>Inbody</title>
</head>

<body>
	<header>
		<div id="headerFirstDiv">
			<div>
				<a href="javascript:location.href='../../../Main.jsp'"><img src="${path}/views/img/logo.png" /></a>
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
	<div id="form">
		<form action="./Member?cmd=inbodyresult" method="post">
			<table>
				<tr>
					<td>키</td>
					<td><input type="number" name="memberheight" required></td>
				</tr>
				<tr>
					<td>몸무게</td>
					<td><input type="number" name="memberweight" required></td>
				</tr>
				<tr>
					<td>근육량</td>
					<td><input type="text" name="bodymuscle" required></td>
				</tr>
				<tr>
					<td>체지방량</td>
					<td><input type="text" name="bodyfat" required></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="인바디값 제출">
				</tr>
			</table>
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