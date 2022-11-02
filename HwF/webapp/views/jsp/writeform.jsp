<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>writeform.jsp 게시판 글쓰기</title>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" type="text/css" href="../css/MainCss.css" />
<link rel="stylesheet" type="text/css" href="../css/listqna.css" />
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
	<p></p>
	<p></p>
	<div class="container">
		<div class="headerqna">1:1 문의</div>
		<div class="side">side bar</div>
		<div class="main">

			<form action="../board?cmd=write" method="post">
				아이디 : <input type="text" name="memberid" required> <br>
				제목 : <input type="text" name="qnacontent" required= required> <br>
				내용 :
				<textarea rows="5" cols="50" required="required" name="qnaanswer">내용기재요망</textarea>
				<br>
				<!-- 작성날짜	 : <input type="date" name="regdate"> <br>  -->
				<input type="submit" value="게시글 등록">
			</form>
		</div>

		<div class="footer">footer</div>
	</div>
</body>
</html>