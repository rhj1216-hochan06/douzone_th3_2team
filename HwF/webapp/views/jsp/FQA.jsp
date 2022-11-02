<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="../css/MainCss.css" />
<link rel="stylesheet" type="text/css" href="../css/FQA.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>

<meta charset="UTF-8">
<title>FQA</title>
</head>
<body>
	<header>
		<div id="headerFirstDiv">
			<div>
				<img src="../img/logo.png" />
			</div>
			<div>홈페이지 제목 (팀명)</div>
		</div>

		<nav>
			<p>
				<input type="text" value="" placeholder="Search" />
			</p>

			<table>
				<tr>
					<td>Home</td>
					<td>MyPage</td>
					<td>HealthFood</td>
					<td>HealthCafe</td>
					<td>HealthNutrients</td>
					<td>Survey</td>
					<td>InbodyTest</td>
					<td>Community</td>
				</tr>
			</table>
		</nav>
	</header>
	<article>
		<img src="../img/getMuscle.jpg" />
	</article>
	<a href="javascript:location.href='list.jsp' ">게시판 목록</a>
	<div id="containner" class="fqa">
		<div id="location">
			<h4>Home > 문의 > FAQ</h4>
		</div>
		<div id="title_fqa">FAQ(질문과 대답)</div>
		<input type="radio" name="accordion" id="answer1"> <label
			for="answer1"><p> 헬스장 이용안내</p> <i class="fas fa-angle-down"></i>
		</label>
		<div class="info">
			<ul>
				<p>ㆍ 헬스장</p>
				<p>월 ~ 토 06:00 ~ 24:00 / 일요일 07:00 ~ 22:00</p>
				<p>ㆍ 카페 영업시간</p>
				<p>월 ~ 토 09:00 ~ 20:00 / 일요일 09:00 ~ 20:00</p>
			</ul>
		</div>
		<input type="radio" name="accordion" id="answer2"> <label
			for="answer2"> <p>다른사람 명의의 계좌로 환불받을 수 있나요?</p> <i
			class="fas fa-angle-down"></i>
		</label>
		<div>
			<p>ㆍ 다른 사람 명의로는 환불할 수 없습니다. 고객님 본인 명의 계좌로만 환불이 가능합니다.</p>
		</div>
		<input type="radio" name="accordion" id="answer3"> <label
			for="answer3"> 환불계좌를 등록/변경하고 싶어요. <i
			class="fas fa-angle-down"></i>
		</label>
		<div class="info2">
			<ul>
				<p>ㆍ 마이페이지에서 환불계좌 등록 및 수정이 가능합니다. 환불계좌는 주문자 명의의 본인 계좌만 등록할 수 있습니다.</p>
				<p>ㆍ 주문 진행 상태가 '환불진행중' 또는 '환불완료' 에서는 환불계좌를 변경할 수 없습니다.</p>
			</ul>
		</div>
		<input type="radio" name="accordion" id="answer4"> <label
			for="answer4"> 주문을 취소하고 싶어요. <i class="fas fa-angle-down"></i>
		</label>
		<div class="info3">
			<ul>
			<p>ㆍ 주문하신 상품이 아직 제작전이면 취소가 가능하며, 마이페이지에서 주문취소를 하실 수 있습니다.</p>
			<p>ㆍ 주문하신 상품이 이미 만들어지고 있으면 취소는 어려운 점 양해부탁드립니다.</p>
			</ul>
		</div>
		<input type="radio" name="accordion" id="answer5"> <label
			for="answer5"> 영양제 예약 구매의 경우 어떻게 찾아가면 되나요? <i
			class="fas fa-angle-down"></i>
		</label>
		<div>
			<p>ㆍ 예약하신 날짜에 헬스장 내 카페에 방문하시어 고객님 성함을 말씀하시면 예약하신 영양제를 수령하실 수 있습니다.
			</p>
		</div>
		<input type="radio" name="accordion" id="answer6"> <label
			for="answer6"> 영양제 예약 구매기간 중 취소한다면 어떻게 해야하나요? <i
			class="fas fa-angle-down"></i>
		</label>
		<div>
			<p>ㆍ 헬스장 내 카페에 방문하시거나 My page에 들어가셔서 예약취소를 하시면 잔여 기간에 맞춰 환불해드립니다.</p>
		</div>
		<input type="radio" name="accordion" id="answer7"> <label
			for="answer7"> 상품에 대해서 문의하려면 어떻게 해야 하나요? 
			<i class="fas fa-angle-down"></i>
		</label>
		<div class="info4">
			<ul>
			<p>ㆍ 상품에 관한 내용은 상품상세 화면에 자세히 안내되어 있습니다.</p> 
			<p>ㆍ 마이페이지 > 주문내역에서 주문한 상품을 선택하시면 상세페이지로 이동합니다.</p>
			<p>ㆍ 상품 상세 내용에 표시되어 있지 않은 내용은 판매자에게 문의해 주십시오.</p>
			<p>> 판매자에게 문의</p>
			<p>1. "마이페이지 > 주문내역에서 상품 선택 > 배송/교환/반품 안내"에 표기된 판매자 연락처로 문의</p>
			<p>2. "["마이페이지 > 1:1문의하기 > 문읜타입에서 판매자에게 문의하기"를 선택한 후 질의 내용 작성</p>
			</ul>
		</div>
		
	</div>

	<footer>회사 이름, 대표 이름 등등</footer>
</body>
</html>