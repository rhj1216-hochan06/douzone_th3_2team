<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<link rel="stylesheet" type="text/css" href="${path}/views/css/detailnutrients.css" />
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="${path}/views/js/healthFoodJS.js"></script>
<script type="text/javascript" src="${path}/views/js/all.js"></script>


<title>헬스식품 상세 페이지</title>

</head>
<body>
	<header>
		<div id="headerFirstDiv">
			<div>
				<a href="javascript:location.href='Main.jsp'"><img src="${path}/views/img/logo.png" /></a>
			</div>
			<div>홈페이지 제목 (팀명)</div>
		</div>

		<!-- 메뉴 버튼 테이블 -->
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

	<div id="selectList">
	
		<article class="MonthMenu" id="s1">
			<img src="${path}/views/img/getMuscle.jpg" />
			<div>
				<table>
					<th colspan="2">이달의 HOT & SALE 메뉴</th>
					<tr>
						<td><img src="${path}/views/img/logo.png" /></td>
						<td><img src="${path}/views/img/logo.png" /></td>
					</tr>
					<tr>
						<td><img src="${path}/views/img/logo.png " /></td>
						<td><img src="${path}/views/img/logo.png" /></td>
					</tr>
				</table>

				<table id="healthintro">
					<th>헬스장 및 운동법 소개</th>
					<tr>
						<td><img src="${path}/views/img/logo.png" /></td>
					</tr>
				</table>
			</div>
		</article>


		<!--헬스용품 카테고리-->
		<article class="category" id="s2">
			<table>
				<th colspan="4">헬스용품 카테고리</th>
				<tr>
					<td onclick="location.href='healthgoods?cmd=healthGoodsList'">
						<h1>전체</h1> <img src="${path}/views/img/IconHealthGoods.png" style="width: 150px; height: 150px" />
					</td>
					<td onclick="location.href='healthgoods?cmd=selectDumbbell'">
						<h1>운동용품</h1> <img src="${path}/views/img/IconHealthGoodsDumbbell.png" style="width: 150px; height: 150px"/>
					</td>
					<td onclick="location.href='healthgoods?cmd=selectBelt'">
						<h1>벨트</h1> <img src="${path}/views/img/IconHealthGoodsBelt.png" style="width: 150px; height: 150px"/>
					</td>
					<td onclick="location.href='healthgoods?cmd=selectGloves'">
						<h1>장갑</h1> <img src="${path}/views/img/IconHealthGoodsGloves.png" style="width: 150px; height: 150px"/>
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
						<h1>전체</h1> <img src="${path}/views/img/IconHealthGoods.png" style="width: 150px; height: 150px" />
					</td>
					<td onclick="location.href='healthfood?cmd=selectFood'">
						<h1>음식</h1> <img src="${path}/views/img/IconSelectFood.png" style="width: 150px; height: 150px"/>
					</td>
					<td onclick="location.href='healthfood?cmd=selectCafe'">
						<h1>음료</h1> <img src="${path}/views/img/IconSelectCafe.png" style="width: 150px; height: 150px"/>
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
						src="${path}/views/img/allList.png" />
					</td>
					<td onclick="location.href='nutrients?cmd=vitaminList'">
						<h1>비타민</h1> <img src="${path}/views/img/vitamin.png" />
					</td>
					<td onclick="location.href='nutrients?cmd=proteinList'">
						<h1>헬스 보충제</h1> <img src="${path}/views/img/protein.png" />
					</td>
					<td onclick="location.href='nutrients?cmd=dietList'">
						<h1>다이어트 보충제</h1> <img src="${path}/views/img/diet.png" />
					</td>
				</tr>
			</table>
		</article>
		
	</div>


	<!-- 선택한 상품 보여주기 -->
	<div id="nutrientsListDiv">

		<c:forEach var="healthFoodList" items="${ healthFoodList }">

			<div>
				<img id="hfIMG" alt="사진" src="${ healthFoodList.hfIMG }">

			</div>

			<div id="nutrdiscription">

				<div>
					<h3>${ healthFoodList.hfName }</h3>
				</div>
				<br />

				<div>${ healthFoodList.hfDetail }</div>


				<div>
					<br />
					<div>
						제조날짜 : ${ healthFoodList.hfDoM }
					</div>
					
					<br />
					<div>
						가격 : <a id="result">${ healthFoodList.hfPrice }</a>원
					</div>
				</div>


			</div>
		</c:forEach>



		<div id="selectbuymethod">

			<div id="buy1">
				<form name="buyday" action="" method="post">
					<h1>총 가격</h1>

					<input id="onetotal" name="onetotal" value="0" readonly /> <p />
					<a>수량 결정</a> <p />
					<input id="countone" name="countone" value="0" readonly />

					<div id="calculationdiv">
						<input type='button' onclick="countnum('plus')" class="calculation" value='+' /> 
						<input type='button' onclick="countnum('minus')" class="calculation" value='-' />
					</div>
					
					<div>
						<input type="submit" id="bottlebasket" class="calculation" value="장바구니">
					</div>

				</form>
			</div> <!-- end buy1 -->

		</div> <!-- end selectbuymethod -->

	</div> <!-- end nutrientsListDiv -->

	<footer>회사 이름, 대표 이름 등등</footer>
</body>
</html>