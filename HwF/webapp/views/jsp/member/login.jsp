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

<script type="text/javascript" src="${path}/views/js/all.js"></script>
<!-- <script src="//code.jquery.com/jquery-1.11.1.min.js"></script> -->
<!-- <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script> -->

<link rel="stylesheet" type="text/css" href="${path}/views/css/MainCss.css" />
<%-- <link rel="stylesheet" type="text/css" href="${path}/views/css/allList.css" /> --%>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" type="text/css" href="${path}/views/css/login.css" />

<title>login</title>
</head>

<body>

	<!-- header -->
	<header>
		<div id="headerFirstDiv">
			<div>
				<a href="javascript:location.href='Main.jsp'"><img src="${path}/views/img/logo.png" /></a>
			</div>
			<div>홈페이지 제목 (팀명)</div>
		</div>

		<nav style="display: flex;">
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


			<!-- <form action="./Member?cmd=logincheck" method="post">
				<table>
					<tr>
						<td>아이디</td>
						<td><input type="text" name="memberid" required></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="password" name="memberpwd" required>
					</tr>
					<tr>
						<td colspan="2" align="center">
						<input type="submit"value="로그인"> 
						<input type="button" value="회원가입" onclick="location.href='Member?cmd=self'"></td>
					</tr>
				</table> 	

			</form> -->

		</nav>
	</header>
	
	
	<form action="./Member?cmd=logincheck" method="post">
		
		<div class="container">
	        <div class="card card-container">
	            <img id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
	            <p id="profile-name" class="profile-name-card"></p>
	            
	                <span id="reauth-email" class="reauth-email"></span>
	                <input type="text" id="memberid" name="memberid" class="form-control" placeholder="Id 입력" required autofocus> <br>
	                <input type="password" id="memberpwd" name="memberpwd" class="form-control" placeholder="Password 입력" required> <br>
	                
	                <!--  <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">로그인</button> -->
	                <input type="submit" value="로그인" class="btn btn-lg btn-primary btn-block btn-signin">
	            
	        </div><!-- end card-container -->
	        
	    </div> <!-- end container -->
			
	</form>	
	
	<c:if test="${logincheck == false}">
		<p style="color: red;" align="center">로그인 실패! 아이디와 비밀번호 확인해주세요.</p>
	</c:if>

	<!-- footer -->
	<footer>회사 이름, 대표 이름 등등</footer>
	
</body>

</html>