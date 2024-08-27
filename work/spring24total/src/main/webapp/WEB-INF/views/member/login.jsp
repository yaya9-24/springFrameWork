<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>로그인</title>

</head>
<body>
<h1>로그인</h1>
	<div class="content-container">
		<div class="form-container">
			
			<form action="loginOK.do" method="post">
				<label for="id">ID</label> <input type="text" id="id" name="id"value="admin"> 
				<label for="pw">PW</label> <input type="text" id="pw" name="pw" value="hi1111"> 
				<input type="submit" value="로그인">
			</form>
		</div>
	</div>
</body>
</html>