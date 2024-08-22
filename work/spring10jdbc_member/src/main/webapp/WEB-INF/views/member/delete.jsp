<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>JSP - Hello World</title>
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
	margin: 20px;
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
	<h1><%="게시글 삭제 페이지"%></h1>
	<br />
	<jsp:include page="../top_menu.jsp" />
	<div>
		<form action="m_deleteOK.do" method="post">
			<input type="hidden" name="num" value="${param.num}">
			<table id="insertTable">
				<tr>
					<th>${param.num}번회원을 정말 삭제하시겠습니까?<input type="submit" value="삭제완료"></th>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>