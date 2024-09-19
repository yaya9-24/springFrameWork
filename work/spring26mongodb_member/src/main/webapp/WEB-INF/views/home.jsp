<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P><a href="findAll.do">findAll.do</a></P>
<P><a href="findAll2.do?page=1&limit=3">findAll2.do</a></P>
<P><a href="findAllDoc.do">findAllDoc.do</a></P>
<P><a href="findOne.do?num=3">findOne.do</a></P>

<P><a href="searchList.do?searchKey=id&searchWord=4">searchList.do</a></P>
<P><a href="searchList2.do?searchKey=id&searchWord=ad&page=1&limit=3">searchList2.do : skip,limit</a></P>
<P><a href="searchList.do?searchKey=tel&searchWord=10">searchList.do</a></P>

<P><a href="searchList3.do?num1=3&num2=6">searchList3.do-num &gt;=3 and num &lt;=6</a></P>
<P><a href="searchList4.do?num1=3&num2=6">searchList4.do-num = 3 or(in) num=6</a></P>

<P><a href="insertOneOK.do?num=6&id=account6&pw=qwer123&name=yang&tel=010-3111">insertOneOK.do</a></P>
<P><a href="insertManyOK.do">insertManyOK</a></P>
<P><a href="updateOneOK.do?num=5&id=account5&pw=qwer555&name=choi&tel=010-5555">updateOneOK.do</a></P>
<P><a href="updateManyOK.do?num=8&id=aaa2&pw=bbb&name=yang&tel=010">updateManyOK-8이상 모두 변경</a></P>
<P><a href="deleteOneOK.do?num=6">deleteOneOK.do</a></P>
<P><a href="deleteManyOK.do?num=6">deleteManyOK-6 이상 모두삭제</a></P>
</body>
</html>
