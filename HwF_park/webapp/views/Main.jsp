<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" type="text/css" href="../views/css/MainCss.css" />
<script type="text/javascript" src="../views/js/MainJS.js"></script>
<title>Main</title>
</head>
<body>
	<header>
		<div id="headerFirstDiv">
			<div>
				<img src="../views/img/logo.png" />
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
					<td id="7" onclick="location.href='board?cmd=list'">Community</td>
				</tr>
			</table>
		</nav>
	</header>
	<div id="selectList">
		<!--이달의 메뉴 추천 & 헬스장 운동법 소개-->
		<article class="MonthMenu" id="s1">
			<img src="../views/img/getMuscle.jpg" />
			<div>
				<table>
					<th colspan="2">이달의 HOT & SALE 메뉴</th>
					<tr>
						<td><img src="../views/img/logo.png" /></td>
						<td><img src="../views/img/logo.png" /></td>
					</tr>
					<tr>
						<td><img src="../views/img/logo.png" /></td>
						<td><img src="../views/img/logo.png" /></td>
					</tr>
				</table>

				<table id="healthintro">
					<th>헬스장 및 운동법 소개</th>
					<tr>
						<td><img src="../views/views/logo.png" /></td>
					</tr>
				</table>
			</div>
		</article>

		<!--영양제 카테고리-->
		<article class="category" id="s4">
			<table>
				<th colspan="3">영양제 카테고리</th>
				<tr>
					<td>
						<h1>비타민</h1> <img src="../views/img/vitamin.png" />
					</td>
					<td>
						<h1>헬스 보충제</h1> <img src="../views/img/protein.png" />
					</td>
					<td>
						<h1>다이어트 보충제</h1> <img src="../views/img/diet.png" />
					</td>
				</tr>
			</table>
		</article>
	</div>
	<footer>회사 이름, 대표 이름 등등</footer>
</body>
</html>
