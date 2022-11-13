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
<script type="text/javascript" src="${path}/views/js/Join.js"></script>

<link rel="stylesheet" type="text/css" href="${path}/views/css/allList.css" />
<link rel="stylesheet" type="text/css" href="${path}/views/css/bootstrapCustom.css" />
<!-- <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css"> -->
<link rel="stylesheet" type="text/css" href="${path}/views/css/login.css" />

<title>join</title>
</head>

<body>
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
			
		<form action="./Member?cmd=insertmember" method="post">
		
		<div class="container">
	        <div class="card card-container">
	        
	        	<h2 align="center">회원가입</h2><br>
	        	
	            <img id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
	            <p id="profile-name" class="profile-name-card"></p>
	            
	                <span id="reauth-email" class="reauth-email"></span>
	                <input type="text" id="userid" name="userid" class="form-control" placeholder="아이디" required autofocus> <br>
	                <input type="password" id="password" name="password" class="form-control"placeholder="비밀번호" required> <br>
	                <input type="text" id="userid" name="userid" class="form-control" placeholder="이름" required autofocus> <br>
	                <select name="sex" required class="form-control">
	                	<option>성별</option>
						<option value="2">여자</option>
						<option value="1">남자</option>
					</select> <br>
	                <input type="submit" value="회원가입" class="btn btn-lg btn-primary btn-block btn-signin" onclick="send();">
	            
	        </div><!-- end card-container -->
	        
	    </div> <!-- end container -->
	    
		</form>
			
		<c:if test="${joincheck == false}">
        	 <p style="color: red;" align="center">회원가입 실패! 이미 있는 아이디입니다.</p>
        </c:if>

		<footer>회사 이름, 대표 이름 등등</footer>
</body>

</html>