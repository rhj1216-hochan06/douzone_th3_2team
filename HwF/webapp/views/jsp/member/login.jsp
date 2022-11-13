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

<%-- <script type="text/javascript" src="${path}/views/js/all.js"></script> --%>
<script type="text/javascript" src="${path}/views/js/Join.js"></script>

<link rel="stylesheet" type="text/css" href="${path}/views/css/allList.css" />
<link rel="stylesheet" type="text/css" href="${path}/views/css/memberTemplate.css" />
<link rel="stylesheet" type="text/css" href="${path}/views/css/memberTemplate2.css" />

<title>login</title>
</head>

<body> 		

	<!-- header -->
	<header>
		<div id="headerFirstDiv">
			<div>
				<a href="javascript:location.href='Main.jsp'"><img
					src="${path}/views/img/logo.png" /></a>
			</div>
			<div>홈페이지 제목 (팀명)</div>
		</div>


		<nav style="display: flex;">

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
					<td id="5" onclick="change(this.id)">Survey</td>
					<td id="6" onclick="change(this.id)">InbodyTest</td>
					<td id="7" onclick="change(this.id)">Community</td>
				</tr>
			</table>
		</nav>
	</header>
	
	<div id="selectList">

		<!--이달의 메뉴 추천 & 헬스장 운동법 소개-->
		<article class="MonthMenu" id="s1">
			<img src="./views/img/getMuscle.jpg" />
			<div>
				<table>
					<th colspan="2">이달의 HOT & SALE 메뉴</th>
					<tr>
						<!-- <td onclick="location.href='nutrients?cmd=list'"> -->
						<td onclick="location.href='nutrients?cmd=nutrientsDetail30001'">
							<img
							src="https://img.danawa.com/prod_img/500000/426/012/img/2012426_1.jpg?shrink=330:330&_v=20210817132717"
							width="200" , height="200" />
							<h4>고려은단 비타민C 1000 600정</h4>
						</td>
						<td onclick="location.href='nutrients?cmd=nutrientsDetail30002'">
							<img
							src="https://img.danawa.com/prod_img/500000/444/243/img/6243444_1.jpg?shrink=330:330&_v=20200626121658"
							width="200" , height="200" />
							<h4>코스트코 커클랜드 슈퍼 B-컴플렉스 500정</h4>
						</td>
					</tr>
					<tr>
						<td onclick="location.href='nutrients?cmd=nutrientsDetail30003'">
							<img
							src="https://img.danawa.com/prod_img/500000/178/261/img/5261178_1.jpg?shrink=330:330&_v=20200618170729"
							width="200" , height="200" />
							<h4>BSN 신타6 초콜렛 밀크쉐이크 2.27kg</h4>
						</td>
						<td onclick="location.href='nutrients?cmd=nutrientsDetail30007'">
							<img
							src="https://img.danawa.com/prod_img/500000/566/871/img/17871566_2.jpg?shrink=500:500&_v=20220920155658"
							width="200" , height="200" />
							<h4>비상썬라이즈 경성건강원 수국잎 열수 추출물 분말 110g</h4>
						</td>
					</tr>
				</table>

				<table id="healthintro">
					<th colspan="2">헬스장 소개</th>
					<!-- <th>헬스장 및 운동법 소개</th> -->
					<tr>
						<td onclick="location.href='./views/jsp/etc/introduce.jsp'">
							<img
							src="https://contents.hiltonhotels.jp/ko/h/selhi/hotel_service_20191209111241_main_sp.jpg"
							width="640" , height="200">
						</td>
					</tr>

					<th>운동법 소개</th>
					<tr>
						<td><iframe width="640" height="300"
								src="https://www.youtube.com/embed/TY0HF4SMzhU?autoplay=1&mute=1"
								title="YouTube video player" frameborder="0"
								allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
								allowfullscreen></iframe></td>
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
						<h1>전체</h1> <img src="./views/img/IconHealthGoods.png"
						style="width: 150px; height: 150px" />
					</td>
					<td onclick="location.href='healthgoods?cmd=selectDumbbell'">
						<h1>운동용품</h1> <img src="./views/img/IconHealthGoodsDumbbell.png"
						style="width: 150px; height: 150px" />
					</td>
					<td onclick="location.href='healthgoods?cmd=selectBelt'">
						<h1>벨트</h1> <img src="./views/img/IconHealthGoodsBelt.png"
						style="width: 150px; height: 150px" />
					</td>
					<td onclick="location.href='healthgoods?cmd=selectGloves'">
						<h1>장갑</h1> <img src="./views/img/IconHealthGoodsGloves.png"
						style="width: 150px; height: 150px" />
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
						<h1>전체</h1> <img src="./views/img/IconHealthFoodAll.png"
						style="width: 200px; height: 200px" />
					</td>
					<td onclick="location.href='healthfood?cmd=selectFood'">
						<h1>음식</h1> <img src="./views/img/IconHealthFoodSalad.png"
						style="width: 200px; height: 200px" />
					</td>
					<td onclick="location.href='healthfood?cmd=selectCafe'">
						<h1>음료</h1> <img src="./views/img/IconHealthFoodCafe.png"
						style="width: 200pxx; height: 200px" />
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


		<!--커뮤니티 카테고리-->
		<article class="category" id="s7">
			<table>
				<th colspan="2">문의</th>
				<tr>

					<td id="memberboard"
						onclick="location.href='./views/jsp/qna/FQA.jsp'">
						<h1>FQA</h1> <img src="./views/img/IconFQA.png" style="width: 200pxx; height: 200px" />
					</td>

					<td id="memberboard"
						onclick="location.href='Member?cmd=membersearch'">
						<h1>1:1 문의</h1> <img src="./views/img/IconOneToOne.png" style="width: 200pxx; height: 200px" />
					</td>
				</tr>
			</table>
		</article>

	</div> <!-- end selectList -->
		
	
	<div id="con">
		<form action="./Member?cmd=logincheck"  method="post">
			
			<div class="container">
		        <div class="card card-container">
		        
		       		<h2 align="center">로그인</h2><br>
		        
		            <img id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
		            <p id="profile-name" class="profile-name-card"></p>
		            
		                <span id="reauth-email" class="reauth-email"></span>
		                <input type="text" id="memberid" name="memberid" class="form-control" placeholder="Id 입력" required autofocus> <br>
		                <input type="password" id="memberpwd" name="memberpwd" class="form-control" placeholder="Password 입력" required> <br>
		                
		                <!--  <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">로그인</button> -->
		                <div id="sbButton">
		                	<input type="submit" value="로그인" class="btn btn-lg btn-primary btn-block btn-signin" >
		                	<input type="button" value="회원가입" class="btn btn-lg btn-primary btn-block btn-signin" onclick="location.href='Member?cmd=self'" ></td>
		            	</div>
		        </div><!-- end card-container -->
		        
		    </div> <!-- end container -->
				
		</form>	
		
	</div>
	
	<c:if test="${logincheck == false}">
		<p style="color: red;" align="center">로그인 실패! 아이디와 비밀번호 확인해주세요.</p>
	</c:if>

	<!-- footer -->
	<footer>회사 이름, 대표 이름 등등</footer>
	
</body>

</html>