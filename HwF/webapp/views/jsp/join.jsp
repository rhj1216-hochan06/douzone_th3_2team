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
<title>login</title>
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
			<form action="${path}/user/login_check.do" method="post">
				<table>

					<h2>회원가입</h2>
					<form action="${path}/user/insertUser.do" method="post">
						<table>
							<tr>
								<td>아이디</td>
								<td><input name="userid"></td>
							</tr>
							<tr>
								<td>비밀번호</td>
								<td><input type="password" name="passwd"></td>
							</tr>
							<tr>
								<td>이름</td>
								<td><input name="name"></td>
							</tr>
							<tr>
								<td>사용권한</td>
								<td><select name="authority">
										<option value="ROLE_USER">일반사용자</option>
										<option value="ROLE_ADMIN">관리자</option>
								</select></td>
							</tr>
							<tr>
								<td colspan="2" align="center"><input type="submit"
									value="회원가입"></td>
							</tr>
						</table>
					</form>
</body>
</html>



















