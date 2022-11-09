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
	href="${path}/views/css/basketList.css" />
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="${path}/views/js/basket.js"></script>


<title>allList</title>
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

				<table id="
        healthintro">
					<th>헬스장 및 운동법 소개</th>
					<tr>
						<td><img src="${path}/views/img/logo.png" /></td>
					</tr>
				</table>
			</div>
		</article>

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
	<div id="nutrientsListDiv">
		<form action="${path}/cart?cmd=deleteSelete" method="post">
			<table>
				<tr>
					<th>물품 이름</th>
					<th>가격</th>
					<th>받는 방식</th>
					<th>받을 날짜</th>
					<th>수령이 끝나는 날짜</th>
					<th>사진</th>
					<th>삭제</th>
				</tr>
				<c:forEach var="cartdto" items="${cartList }">
					<tr id="${cartdto.memberId}">
						<td>${cartdto.productsName}</td>
						<td>${cartdto.productsPrice }</td>
						<td id="purchasemethod">${cartdto.reservation }</td>
						<td>${cartdto.purchasetime }</td>
						<td>${cartdto.endtime }</td>
						<td><img src="${cartdto.productsIMG }" /></td>
						<td><input type="checkbox" name="whatcheck"
							value="${cartdto.cartId}" onclick="check_checkbox(event)" /></td>
				</c:forEach>
				</tr>
				<tr class="lasttr">
					<td colspan="7"><input type="text" id="hiddenid"
						name="hiddenid" value="0" />
						<input type="button"
						id="cartchecked" value="구매" onclick="location.href='cart?cmd=purchase'"/>
						<input
						type="submit" id="cartchecked" name="deletecheck" value="삭제" /></td>
				</tr>
			</table>

		</form>
	</div>

	<footer>회사 이름, 대표 이름 등등</footer>
</body>
</html>