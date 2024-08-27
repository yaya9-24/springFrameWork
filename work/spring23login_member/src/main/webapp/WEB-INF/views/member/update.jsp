<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>

</head>

<body>

	<h1>회원수정 페이지</h1>
	
	<div>

		<form action="m_updateOK.do" method="post" enctype="multipart/form-data">
			<table id="insertTable">
				<tr>
					<td><label for="num">NUM</label></td>
					<td>${param.num}<input type="hidden" id="num" name="num"
						value="${param.num}"></td>
				</tr>
				<tr>
					<td><label for="id">ID</label></td>
					<td><input type="text" id="id" name="id" value="${vo2.id}"
						placeholder="ID를 입력하세요"></td>
				</tr>
				<tr>
					<td><label for="pw">PW</label></td>
					<td><input type="text" id="pw" name="pw" value="${vo2.pw}"
						placeholder="PW를 입력하세요"></td>
				</tr>
				<tr>
				<tr>
					<td><label for="name">NAME</label></td>
					<td><input type="text" id="name" name="name"
						value="${vo2.name}" placeholder="NAME를 입력하세요"></td>
				</tr>
				<tr>
					<td><label for="tel">TEL</label></td>
					<td><input type="text" id="tel" name="tel" value="${vo2.tel}"
						placeholder="TEL를 입력하세요"></td>
				</tr>
				<tr>
					<td><label for=file>FILE</label><img
						src="resources/upload_img/${vo2.profile}" width=200></td>
					<td>
					<input type="file" id=file name=file>
					<input type="hidden" id=profile name="profile"
						value="${vo2.profile}"></td>

				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="수정완료"></td>
				</tr>
			</table>
		</form>
	</div>
</body>

</html>