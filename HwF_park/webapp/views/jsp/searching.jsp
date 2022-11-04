<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>searchlist</title>
</head>
<body>
	<h3>상품검색</h3>
	<form action="../search?cmd=searching" method="post">
		<select name="column">
			<option value="Healthgoodsname">품목</option>
			<option value="Healthgoodsname">상품</option>
		</select> <input type="text" name="keyvalue"> <input type="submit"	value="검색">
	</form>

	<h3>다중검색하기</h3>
	
	<form action="board?cmd=searchListSelect" method="post">
		<input type="checkbox" name="healthgoodsname" value="healthgoodsname" checked>
		   헬스용품 : <input	type="checkbox" name="hfname" value="hfname">
			식품 : <input type="checkbox" name="nutrientsname" value="nutrientsname">영양제 <br> 
			내용 : <input	type="text" name="keyvalue"> <input type="submit" value="검색">
	</form>


	<hr>
	<table class="qnatable" width="2000" cellpadding="3">
		<tr>
			<!-- <th width="150">헬스아이디삭제예정</th> -->
			<th width="100">헬스용품 이름</th>
			<th width="270">가격</th>
			<th width="200">카테고리번호 삭제예정</th>
			<th width="400">이미지</th>
			<th width="400">상세설명</th>

		</tr>
		<c:forEach var="list" items="${ list }">

			<tr>
				<td>${ list.goodsId }</td>
				<td>${ list.goodsName }</td>
				<td>${ list.goodsPrice }</td>
				<td>${ list.goodsCategory}</td>
				<td>${ list.goodsImg }</td>
				<td>${ list.goodsDetail}</td>

			</tr>
		</c:forEach>
	</table>

</body>
</html>