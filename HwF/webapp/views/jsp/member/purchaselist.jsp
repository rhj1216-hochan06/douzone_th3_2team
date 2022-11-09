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

<title>purchaselist</title>
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
	<table>
		<thead>

			<tr>
				<th>구매 아이디</th>
				<th>구매 갯수</th>
				<th>구매 가격</th>
				<th>결제 방식 (카드/계좌이체)</th>
				<th>수령 방식 (즉시/예약)</th>
				<th>구매(결제) 날짜</th>
				<th>수령(픽업) 시작일</th>
				<th>수령(픽업) 기간</th>
				<th>헬스용품 id</th>
				<th>식품 id</th>
				<th>영양제 id</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="PurchaseSelectMemberid"
				items="${PurchaseSelectMemberid}">
				<tr>
					<td>구매 아이디 : ${PurchaseSelectMemberid.purchaseId}"</td>
					<td>구매 갯수 : ${PurchaseSelectMemberid.purchaseNum}"</td>
					<td>구매 가격 : ${PurchaseSelectMemberid.purchasePrice}"</td>
					<td>결제 방식 (카드/계좌이체) : ${PurchaseSelectMemberid.purchaseMethod}"</td>
					<td>수령 방식 (즉시/예약) : ${PurchaseSelectMemberid.purchaseReceipt}"</td>
					<td>구매(결제) 날짜 : ${PurchaseSelectMemberid.purchaseDate}"</td>
					<td>수령(픽업) 시작일 : ${PurchaseSelectMemberid.receiptStartDate}"</td>
					<td>수령(픽업) 기간 : ${PurchaseSelectMemberid.receiptPeriod}"</td>
					<td>헬스용품 id : ${PurchaseSelectMemberid.healthgoodsID}"</td>
					<td>식품 id : ${PurchaseSelectMemberid.hfid}"</td>
					<td>영양제 id : ${PurchaseSelectMemberid.nutrientsID}"</td>
				</tr>
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