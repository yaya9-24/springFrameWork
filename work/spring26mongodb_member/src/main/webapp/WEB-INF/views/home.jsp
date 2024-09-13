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
<P><a href="findOne.do?num=3">findOne.do</a></P>
<P><a href="searchList.do?searchKey=id&searchWord=4">searchList.do</a></P>
<P><a href="insertOneOK.do?num=6&id=account6&pw=qwer123&name=yang&tel=010-3111">insertOneOK.do</a></P>
<P><a href="updateOneOK.do?num=5&id=account5&pw=qwer555&name=choi&tel=010-5555">updateOneOK.do</a></P>
<P><a href="deleteOneOK.do?num=6">deleteOneOK.do</a></P>
</body>
</html>
