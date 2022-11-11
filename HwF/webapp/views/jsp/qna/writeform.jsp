<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}" />	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>writeform.jsp 게시판 글쓰기</title>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" type="text/css" href="${path}/views/css/MainCss.css" />
<link rel="stylesheet" type="text/css" href="${path}/views/css/listqna.css" />
<title>리스트</title>
<style type="text/css">
th {
	background: orange
}
;
</style>
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
					<!-- <td id="1" onclick="location.href='./views/main.jsp">Home</td> -->
					<td id="1" onclick="location.href='../../../Main.jsp'">Home</td>
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
	<div class="container">
		<div class="headerqna">1:1 문의</div>
		<div class="side">side bar</div>
		<div class="main">

			<form action="../../../Member?cmd=memberwriteboard" method="post">
				제목 : <input type="text" name="qnatitle" required= required> <br>
				내용 :
				<textarea rows="5" cols="50" required="required" name="qnacontent" placeholder="내용기재요망"></textarea>
				<br>
				<input type="submit" value="게시글 등록">
			</form>
		</div>
		
<!-- 		<div class="main">

		<form action="../../../board?cmd=write" method="post">
				아이디 : <input type="text" name="memberid" required> <br>
				제목 : <input type="text" name="qnatitle" required= required> <br>
				내용 :
				<textarea rows="5" cols="50" required="required" name="qnacontent" placeholder="내용기재요망"></textarea>
				<br>
				<input type="submit" value="게시글 등록">
			</form>
		</div> -->

		<div class="footer">footer</div>
	</div>
</body>
</html>