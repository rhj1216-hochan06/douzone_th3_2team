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

<link rel="stylesheet" type="text/css" href="${path}/views/css/header.css" />
<link rel="stylesheet" type="text/css" href="${path}/views/css/allList.css" />
<link rel="stylesheet" type="text/css" href="${path}/views/css/footer.css" />

<script type="text/javascript" src="${path}/views/js/all.js"></script>

<title>구매내역 조회 페이지</title>
</head>
<body>

	<!-- header -->
	<header>
		<div id="headerFirstDiv">
			<div>
				<a href="javascript:location.href='Main.jsp'"><img src="${path}/views/img/logo.png" /></a>
			</div>
			<div>BE NATURAL</div>
			<div id="loginimg">
				<a onclick="location.href='cart?cmd=gobasket'"><img src="${path}/views/img/basketIcon.png" title="장바구니" /></a>
				<a onclick="location.href='Member?cmd=login'"><img src="${path}/views/img/LoginIMG.png" title="로그인 / 마이페이지" /></a>
			</div>
		</div>

		<nav>
			<form action="search?cmd=searching" method="post">
				<p>
					<input type="hidden" name="column"> 
					<input type="text" name="keyvalue" value="" placeholder="Search">
				</p>
			</form>

			<table>
				<tr>
					<td id="1" onclick="change(this.id)">Home</td>
					<td id="2" onclick="change(this.id)">HealthGoods</td>
					<td id="3" onclick="change(this.id)">HealthFood</td>
					<td id="4" onclick="change(this.id)">HealthNutrients</td>
					<td id="5" onclick="location.href='Member?cmd=surveylist'">Survey</td>
					<td id="6" onclick="location.href='Member?cmd=inbodylist'">InbodyTest</td>
					<td id="7" onclick="change(this.id)">Community</td>
				</tr>
			</table>
		</nav>
	</header>
	
	<table border="1" width="900" style="margin-left: auto; margin-right: auto;">
		<tr class="tableTitle">
			<th>회원id</th>
			<th>구매번호</th>
			<!-- <th>구매갯수</th> -->
			<th>구매가격</th>
			<th>결제날짜</th>
			<th>헬스용품id</th>
			<th>헬스식품id</th>
			<th>영양제id</th>
			<th>수령방식</th>
			<th>수령시작일</th>
			<th>수령기간</th>
		</tr>

		<c:forEach var="PurchaseSelectMemberid" items="${PurchaseSelectMemberid}">
			<tr>
				<td>${ PurchaseSelectMemberid.memberID }</td>
				<td>${ PurchaseSelectMemberid.purchaseId  }</td>
				<%-- <td>${ PurchaseSelectMemberid.purchaseNum }개</td> --%>
				<td>${ PurchaseSelectMemberid.purchasePrice }원</td>
				<td>${ PurchaseSelectMemberid.purchaseDate }</td>
				<td>${ PurchaseSelectMemberid.healthgoodsID }</td>
				<td>${ PurchaseSelectMemberid.hfid }</td>
				<td>${ PurchaseSelectMemberid.nutrientsID }</td>				
				<td>${ PurchaseSelectMemberid.purchaseReceipt }</td>
				<td>${ PurchaseSelectMemberid.receiptStartDate }</td>
				<td>${ PurchaseSelectMemberid.receiptPeriod }일</td>
			</tr>
		</c:forEach>
	</table>
	
	<br><br><br><br><br>
	
	

	<!-- footer -->
	<footer>
		<div id="footer">
			<div class="xans-element- xans-layout xans-layout-footer footer_start ">

				<div class="cs">
					<div class="cs-down">
					
						<div class="cs_left">
							<ul>
								<li class="title">C/S<span></span>
								</li>
							</ul>
							<ul class="cs_info">
								<li class="tel">02-548-3339</li>
								<li class="tel_time">AM 9:00 - PM 6:00 
								<span>(주말 및 공휴일 휴무)</span>
								</li>
							</ul>
						</div> <!-- end cs_left -->

						<div class="company_pg">
							<ul>
								<li class="title">COMPANY</li>
							</ul>
							<div class="inner2">
								<li class="info">
									<span>상호 <span>(주)레스트롱</span></span> <br>
									<span>대표<span class="han">000</span></span> <br>
									<span>사업자등록번호<span>123-98-05123</span></span> <br> 
									<span>통신판매업 신고<span>2022-서울종로-0500</span></span> <br>
									<span>전화 <span>02-517-1470</span></span> <br>
									<span>주소 <span> 서울 종로구 창경궁로 254 7층</span></span> <br>
								</li>
							</div>
						</div> <!-- end company_pg -->

						<div class="cs_right">
							<ul>
								<li class="title">BANK</li>
							</ul>
							<li class="info">
								<span class="han">국민은행</span> 
								<span class="num">98760212341562</span><br> 
								<span class="name">예금주 <strong> (주)000</strong></span>
							</li>
						</div> <!-- end cs_right -->
						
					</div> <!-- end cs-down -->

					<div class="company_i">
						<li class="utilMenu">
							<a href='./views/jsp/etc/policy.jsp'">이용약관</onclick>
						</li>
						<p></p>
					</div> <!-- end company_i -->
		
				</div> <!-- end cs -->
			</div>
		</div> <!-- end footer -->
	</footer>
	
</body>
</html>