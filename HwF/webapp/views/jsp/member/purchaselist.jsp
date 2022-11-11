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
	 <table border="1" width="900" style="margin-left: auto; margin-right:auto;">
            <tr class="tableTitle">
               <th>구매번호</th>
               <th>회원번호</th>
               <th>구매갯수</th>
               <th>구매가격</th>
               <th>결제방식</th>
               <th>수령방식</th>
               <th>결제날짜</th>
               <th>수령시작일</th>
               <th>수령기간</th>
               <th>헬스용품id</th>
               <th>헬스식품id</th>
               <th>영양제id</th>
            </tr>
      
            <c:forEach var="PurchaseSelectMemberid" items="${PurchaseSelectMemberid}">
               <tr>
                  <td>${ PurchaseSelectMemberid.purchaseId  }</td>
                  <td>${ PurchaseSelectMemberid.memberID }</td>
                  <td>${ PurchaseSelectMemberid.purchaseNum }개</td>
                  <td>${ PurchaseSelectMemberid.purchasePrice }원</td>
                  <td>${ PurchaseSelectMemberid.purchaseMethod }</td>
                  <td>${ PurchaseSelectMemberid.purchaseReceipt }</td>
                  <td>${ PurchaseSelectMemberid.purchaseDate }</td>
                  <td>${ PurchaseSelectMemberid.receiptStartDate }</td>
                  <td>${ PurchaseSelectMemberid.receiptPeriod }일</td>
                  <td>${ PurchaseSelectMemberid.healthgoodsID }</td>
                  <td>${ PurchaseSelectMemberid.hfid }</td>
                  <td>${ PurchaseSelectMemberid.nutrientsID }</td>
               </tr>
            </c:forEach>
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