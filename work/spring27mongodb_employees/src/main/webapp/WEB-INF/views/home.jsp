<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P><a href="findAll.do?page=1&limit=10">findAll.do</a></P>
<P><a href="findOne.do?employee_id=199">findOne.do</a></P>
<P><a href="searchList.do?searchKey=first_name&searchWord=J&page=1&limit=5">searchList.do : skip,limit</a></P>
<P><a href="insertOneOK.do?employee_id=207&first_name=Yang&last_name=Young&email=NAVER">insertOneOK.do</a></P>
<P><a href="updateOneOK.do?employee_id=206&first_name=AAAA&last_name=BBBB&email=KAKAO">updateOneOK.do</a></P>
<P><a href="deleteOneOK.do?employee_id=207">deleteOneOK.do</a></P>
</body>
</html>
