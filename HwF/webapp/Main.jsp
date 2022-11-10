<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" type="text/css" href="./views/css/MainCss.css" />
<script type="text/javascript" src="./views/js/MainJS.js"></script>
<title>Main</title>
</head>
<body>
	<header>
		<div id="headerFirstDiv">
			<div>
				<a href="javascript:location.href='Main.jsp'"><img src="./views/img/logo.png" /></a>
			</div>
			<div id="logindata">${membername1}</div>

			<div>홈페이지 제목 (팀명)</div>

			<div id="loginimg" onclick="location.href='Member?cmd=login'">
				<img src="./views/img/LoginIMG.png" title="로그인 / 마이페이지" />
			</div>
		</div>

		<nav>
			
				<form action="search?cmd=searching" method="post">
				<p>				
					<input type = "hidden" name = "column">
					<input type="text" name="keyvalue" value="" placeholder="Search">
				</p>
				</form> 
						
				<form action="recommend?cmd=surveysearching" method="post">
				<p>				
					<input type = "hidden" name = "column">
					추천 테스트창(임시용)<input type="text" name="keyvalue" value="" placeholder="다이어트 / 둘다 / 증량 / 1">
				</p>
				</form> 
				
				
				<form action="recommend?cmd=surveysearching" method="post">
					<input type = "hidden" name = "column" >
					<input type = "submit" name = "keyvalue" value = "다이어트" >
				</form> 
				
				<!-- 합치면 column은 inbody / keyvalue = memberid -->
				<form action="recommend?cmd=inbodysearching" method="post">
					<input type = "hidden" name = "column" value = "inbody">
					<input type = "hidden" name = "keyvalue" value = "admin" >
					<input type="submit" value = "설문결과">
				</form> 
				
				<form action="recommend?cmd=surveysearching" method="post">
					<input type = "hidden" name = "column" value = "survey">
					<input type = "hidden" name = "keyvalue" value = "2" >
					<input type="submit" value = "설문결과">
				</form> 
				
			 
			 	<form action="recommend?cmd=inbodysearching" method="post">
					<input type = "hidden" name = "column" value = "inbody">
					<input type = "submit" name = "keyvalue" value = "증량" >
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

	<%-- <%@include file="views/jsp/includes/header.jsp" %> --%>

	<div id="selectList">
	
		<!--이달의 메뉴 추천 & 헬스장 운동법 소개-->
		<article class="MonthMenu" id="s1">
			<img src="./views/img/getMuscle.jpg" />
			<div>
				<table>
					<th colspan="2">이달의 HOT & SALE 메뉴</th>
					<tr>
						<!-- <td><a href="javascript:location.href='Main.jsp'"><img src="https://img.danawa.com/prod_img/500000/137/335/img/13335137_1.jpg?shrink=330:330&_v=20220616100237" /></a></td> -->
						<td><img src="./views/img/logo.png" /></td>
						<td><img src="./views/img/logo.png" /></td>
					</tr>
					<tr>
						<td><img src="./views/img/logo.png" /></td>
						<td><img src="./views/img/logo.png" /></td>
					</tr>
				</table>

				<table id="healthintro">
					<th>헬스장 및 운동법 소개</th>
					<td><a href="./views/jsp/etc/introduce.jsp"> <img
								src="./views/img/logo.png" />
						</a></td>
				</table>
			</div>
		</article>


		<!--헬스용품 카테고리-->
		<article class="category" id="s2">
			<table>
				<th colspan="4">헬스용품 카테고리</th>
				<tr>
					<td onclick="location.href='healthgoods?cmd=healthGoodsList'">
						<h1>전체</h1> <img src="./views/img/IconHealthGoods.png" style="width: 150px; height: 150px" />
					</td>
					<td onclick="location.href='healthgoods?cmd=selectDumbbell'">
						<h1>운동용품</h1> <img src="./views/img/IconHealthGoodsDumbbell.png" style="width: 150px; height: 150px"/>
					</td>
					<td onclick="location.href='healthgoods?cmd=selectBelt'">
						<h1>벨트</h1> <img src="./views/img/IconHealthGoodsBelt.png" style="width: 150px; height: 150px"/>
					</td>
					<td onclick="location.href='healthgoods?cmd=selectGloves'">
						<h1>장갑</h1> <img src="./views/img/IconHealthGoodsGloves.png" style="width: 150px; height: 150px"/>
					</td>
				</tr>
			</table>
		</article>
		
		
		<!--헬스식품 카테고리-->
		<article class="category" id="s3">
			<table>
				<th colspan="4">헬스식품 카테고리</th>
				<tr>
					<td onclick="location.href='healthfood?cmd=healthFoodList'">
						<h1>전체</h1> <img src="./views/img/IconHealthFoodAll.png" style="width: 200px; height: 200px" />
					</td>
					<td onclick="location.href='healthfood?cmd=selectFood'">
						<h1>음식</h1> <img src="./views/img/IconHealthFoodSalad.png" style="width: 200px; height: 200px"/>
					</td>
					<td onclick="location.href='healthfood?cmd=selectCafe'">
						<h1>음료</h1> <img src="./views/img/IconHealthFoodCafe.png" style="width: 200pxx; height: 200px"/>
					</td>
				</tr>
			</table>
		</article>


		<!--영양제 카테고리-->
		<article class="category" id="s4">
			<table>
				<th colspan="4">영양제 카테고리</th>
				<tr>
					<td onclick="location.href='nutrients?cmd=list'">
						<h1>모든 영양제</h1> <img id="allnutrientsImg"
						src="./views/img/allList.png" />
					</td>
					<td onclick="location.href='nutrients?cmd=vitaminList'">
						<h1>비타민</h1> <img src="./views/img/vitamin.png" />
					</td>
					<td onclick="location.href='nutrients?cmd=proteinList'">
						<h1>헬스 보충제</h1> <img src="./views/img/protein.png" />
					</td>
					<td onclick="location.href='nutrients?cmd=dietList'">
						<h1>다이어트 보충제</h1> <img src="./views/img/diet.png" />
					</td>
				</tr>
			</table>
		</article>
		
	</div> <!-- end selectList -->
	
		<article class="category" id="s7">
			<table>
				<th colspan="2">문의</th>
				<tr>
					<td><a href="./views/jsp/qna/FQA.jsp">

							<h1>FQA</h1> <img src="./views/img/vitamin.png" />
					</a></td>
					<td><a href="board?cmd=list">
							<h1>1:1 문의</h1> <img src="./views/img/protein.png" />
					</a></td>
				</tr>
			</table>
		</article>
		
	</div>
	<footer>회사 이름, 대표 이름 등등 </footer>
</body>
</html>
