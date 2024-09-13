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

<P><a href="findAll.do">findAll.do</a></P>
<P><a href="findOne.do?age=11">findOne.do</a></P>
<P><a href="searchList.do?searchKey=name&searchWord=nn">searchList.do-name</a></P>
<P><a href="searchList.do?searchKey=phone&searchWord=10">searchList.do-phone</a></P>
<P><a href="insertOneOK.do?age=101&name=kim1&office=multi&phone=0201">insertOneOK</a></P>
<P><a href="updateOneOK.do?age=102&name=yang2&office=multi2&phone=0222">updateOneOK</a></P>
<P><a href="deleteOneOK.do?age=101">deleteOneOK</a></P>
</body>
</html>
