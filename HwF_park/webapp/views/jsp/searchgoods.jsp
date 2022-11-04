<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>searchgoods</title>
</head>
<body>
	<h3>단일검색하기</h3>
	<form action="../search?cmd=Searchgoods" method="post">
		<select name="column">
			<option value="healthgoodsname">헬스</option>
			<option value="hfname">헬스</option>
			<option value="nutrientsname">헬스</option>
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
		<c:forEach var="Searchgoods" items="${ Searchgoods }">

			<tr>
				<td>${ Searchgoods.goodsId }</td>
				<td>${ Searchgoods.goodsName }</td>
				<td>${ Searchgoods.goodsPrice }</td>
				<td>${ Searchgoods.goodsCategory}</td>
				<td>${ Searchgoods.goodsImg }</td>
				<td>${ Searchgoods.goodsDetail}</td>

			</tr>
		</c:forEach>
	</table>

</body>
</html>