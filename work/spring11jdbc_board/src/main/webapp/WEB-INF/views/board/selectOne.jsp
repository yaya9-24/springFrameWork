<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>글번호검색</title>
<style>
input[type=text], textarea, select {
	padding: 8px 8px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ff8f8f;
	border-radius: 14px;
	box-sizing: border-box;
}

input[type=submit], a {
	width: 15%;
	background-color: #4CAF50;
	color: white;
	padding: 8px 8px;
	margin: 8px 0px;
	border: none;
	border-radius: 14px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #b7e5b9;
}

div {
	border-radius: 15px;
	background-color: #f0f0f0;
	margin: 40px;
}

#insertTable {
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#insertTable td, th {
	border: 1px solid #ddd;
	padding: 8px;
}

#insertTable tr:nth-child(even) {
	background-color: #ebebeb;
}

#insertTable tr:hover {
	background-color: #ffc6c6;
}
</style>
</head>
<body>
	<h1><%="글번호검색"%></h1>

	<jsp:include page="../top_menu.jsp" />
	<div>
		<table id="insertTable">
			<thead>
				<tr>
					<th>글번호</th>
					<th>글제목</th>
					<th>글내용</th>
					<th>작성자</th>
					<th>작성일자</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${vo2.num}</td>
					<td>${vo2.title}</td>
					<td>${vo2.content}</td>
					<td>${vo2.writer}</td>
					<td>${vo2.wdate}</td>
				</tr>
			</tbody>
		</table>
	</div>
	<a href="b_update.do?num=${vo2.num}">게시글수정</a>
	<a href="b_delete.do?num=${vo2.num}">게시글삭제</a>

	<hr>

	<form action="c_insertOK.do" method="post">
		<input type="hidden" id="bnum" name="bnum" value="${vo2.num}">
		<table id="insertTable">
			<tr>
				<td>댓글 입력</td>
				<td><textarea id="content" name="content" cols="30" rows="10">comment1</textarea></td>
			</tr>
			<tr>
				<td><label for="writer">작성자:</label></td>
				<td>${user_id}<input type="hidden" id="writer" name="writer"
					value="${user_id}"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="댓글입력"></td>
			</tr>
		</table>
	</form>

	<hr>

	<table id="insertTable">
		<thead>
			<th>번호</th>
			<th>내용</th>
			<th>작성자</th>
			<th>작성일자</th>
		</thead>
		<tbody>
			<c:forEach var="cvo" items="${clist}">
				<tr>
					<td>${cvo.num}</td>
					<td>${cvo.content}</td>
					<td>${cvo.writer}</td>
					<td>${cvo.wdate}</td>
					<td><c:if test="${user_id==cvo.writer}">
							<a href="c_deleteOK.do?num=${cvo.num}&bnum=${vo2.num}">댓글삭제</a>
						</c:if></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</body>
</html>
