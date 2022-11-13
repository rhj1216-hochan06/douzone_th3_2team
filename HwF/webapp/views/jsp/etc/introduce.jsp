<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" type="text/css" href="${path}/views/css/policy.css" />
<link rel="stylesheet" type="text/css" href="${path}/views/css/MainCss.css" />
<link rel="stylesheet" type="text/css" href="${path}/views/css/introduce.css" />

<title>intro</title>

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
			<form action="../../../search?cmd=searching" method="post">
				<p>
					<input type="hidden" name="column"> <input type="text"
						name="keyvalue" value="" placeholder="Search">
				</p>
			</form>

			<table>
				<tr>
					<td id="1" onclick="location.href='../../../Main.jsp'">Home</td>
					<!-- <td id="1" onclick="location.href='../../../../../Main.jsp'">Home</td> -->
					<td id="2" onclick="change(this.id)">HealthFood</td>
					<td id="3" onclick="change(this.id)">HealthCafe</td>
					<td id="4" onclick="location.href='../../../nutrients?cmd=list'">HealthNutrients</td>
					<td id="5" onclick="location.href='Member?cmd=surveylist'">Survey</td>
               		<td id="6" onclick="location.href='Member?cmd=inbodylist'">InbodyTest</td>
					<td id="7" onclick="location.href='../../../Member?cmd=membersearch'">Community</td>
				</tr>
			</table>
		</nav>
	</header>
	<p></p>
	<p></p>
	<article class = "introduce">
		<div class = "intro">상큼하게 터지는 헬스장을 찾아주셔서 감사합니다.</div>
		
		<img src = "https://contents.hiltonhotels.jp/ko/h/selhi/hotel_service_20191209111241_main_sp.jpg" width ="800", height = "400">
		
		<h2>저희 헬스장은 항상 청결을 우선시하며, 매일 1~2시간 간격으로 소독을 진행하고 있습니다.</h2>
		<h2>항상 찾아주셔서 감사합니다!!</h2>
		
		<p></p>
		
		<h2>야! 너도 진실의 방 보낼 수 있어~</h2>
		<div class = "diet">
		<img src = "https://mblogthumb-phinf.pstatic.net/20160822_246/dudfhr20005_1471874906605g7jnT_JPEG/1.jpg?type=w2" width ="300", height = "300">
		&nbsp;&nbsp;
		<img id = "arrow"src = "https://mblogthumb-phinf.pstatic.net/20120502_286/waawo_1335951548482zerxq_PNG/141_anwansoon.png?type=w2" width ="150", height = "150">
		&nbsp;&nbsp;
		<img src = "https://cdn.koism.com/upload/culzineContents/2017/04/WH1000/1493255898.7542.6.jpg" width ="300", height = "300">
		</div>
		<p></p>
		
		<h2>동글동글한 몸에서 다부진 체격으로 다시 태어날 수 있습니다. </h2>
		<p></p>
		<p></p>
		
		<h2><p>천국의 계단 헬스장 입점!!</p></h2>
		<div class = heaven">
		<img src ="https://mblogthumb-phinf.pstatic.net/MjAyMjA1MDFfNzYg/MDAxNjUxNDE0ODI5Njg2.imz7lVqx_zY88EWO06wGlMYA8F_tKnegUvRQwW83zxwg.aqmg5_L37qOjJ-AsnvBkBRXCwVeUavC41XO_dy5z3Ecg.JPEG.westernkr/output_2372124713.jpg?type=w800" width ="800", height = "500">
		</div>
		
		<p></p>
		
		<h2><p>오시는 길</p></h2>
		<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d940.0042158177356!2d127.00031406126165!3d37.58368716190797!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357ca32babaaaa87%3A0x43506d5046df1817!2z7ISc7Jq47Yq567OE7IucIOyiheuhnOq1rCDssL3qsr3qtoHroZwgMjU0IDfsuLU!5e0!3m2!1sko!2skr!4v1667999704719!5m2!1sko!2skr" width ="800", height = "500" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
		<p></p>
		
		<div id = "botton_see" float = 'left''">
		<div>자세히 보기</div>
		&nbsp;&nbsp;
		<div>교통편</div>
		</div>

		
		
	<!--  <div id="map" style="width:500px;height:400px;"></div>
			<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4418998bb58cf2797b65c8c5f8efd7ed"></script>
			<script>
				var container = document.getElementById('map');
				var options = {
					center: new kakao.maps.LatLng(37.58365491017818, 127.00004981506068),
					level: 3
				};

				var map = new kakao.maps.Map(container, options);
				
				var markerPosition  = new kakao.maps.LatLng(37.58365491017818, 127.00004981506068); 

				// 마커를 생성합니다
				var marker = new kakao.maps.Marker({
				    position: markerPosition
				});

				marker.setMap(map);

				// 마커가 지도 위에 표시되도록 설정
			</script>  -->
		
	</article>

		<div id="footer">
			<div
				class="xans-element- xans-layout xans-layout-footer footer_start ">
				<ul class="inner">
					<div class="cs">
						<div class="cs_left">
							<ul>
								<li class="title">C/S<span></span>
								</li>
							</ul>
							<ul class="cs_info">
								<li class="tel">02-548-3339</li>
								<li class="tel_time">AM 9:00 - PM 6:00 <span>(주말 및
										공휴일 휴무)</span>
								</li>
							</ul>
						</div>

						<div class="company_pg">
							<ul>
								<li class="title">COMPANY</li>
							</ul>
							<div class="inner2">
								<li class="info"><span>상호 <span>(주)000</span></span> <span>대표
										<span class="han">000</span>
								</span> <span>사업자등록번호 <span>123-98-05123</span></span> <br> <span>통신판매업
										신고 <span>2022-서울종로-0500</span>
								</span><span> <br> <span>전화 <span>02-517-1470</span></span>
										<span>주소 <span> 서울 종로구 창경궁로 254 7층</span></span> <br> <br></li>
							</div>
						</div>

						<div class="cs_right">
							<ul>
								<li class="title">BANK</li>
							</ul>
							<li class="info"><span class="han">국민은행</span> <span
								class="num">98760212341562</span><br> <span class="name">예금주
									<strong> (주)000</strong>
							</span></li>
				</ul>
				<div class="company_i">
					<div class="inner2">
						<li class="utilMenu"><a href='../etc/policy.jsp'">이용약관</onclick>&nbsp;&nbsp;
							<a href="/member/privacy.html">개인정보취급방침</a> &nbsp;&nbsp; <a
							href="/shopinfo/guide.html">이용안내</a></li>
					</div>
				</div>

			</div>

		</div>
</body>
</html>