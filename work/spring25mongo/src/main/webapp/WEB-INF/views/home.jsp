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
<P><a href="findAll2.do?page=1&limit=3">1페이지 - findAll2.do : skip, limit</a></P>
<P><a href="findAll2.do?page=2&limit=3">2페이지 - findAll2.do : skip, limit</a></P>
<P><a href="findAllDoc.do">findAllDoc.do</a></P>
<P><a href="findOne.do?age=11">findOne.do</a></P>

<P><a href="searchList.do?searchKey=name&searchWord=nn">searchList.do-name</a></P>
<P><a href="searchList2.do?searchKey=name&searchWord=nn&page=1&limit=3">searchList2.do-name : skip,limit</a></P>

<P><a href="searchList3.do?age1=3&age2=6">searchList3.do-age &gt;=3 and age &lt;=6</a></P>
<P><a href="searchList4.do?age1=3&age2=6">searchList4.do-age = 3 or(in) age=6</a></P>

<P><a href="searchList.do?searchKey=phone&searchWord=10">searchList.do-phone</a></P>

<P><a href="insertOneOK.do?age=101&name=kim1&office=multi&phone=0201">insertOneOK</a></P>
<P><a href="insertManyOK.do">insertManyOK</a></P>
<P><a href="updateOneOK.do?age=102&name=yang2&office=multi2&phone=0222">updateOneOK</a></P>
<P><a href="updateManyOK.do?age=102&name=aaa2&office=bbb&phone=010">updateManyOK-102이상 모두 변경</a></P>
<P><a href="deleteOneOK.do?age=101">deleteOneOK</a></P>
<P><a href="deleteManyOK.do?age=101">deleteManyOK-101 이상 모두삭제</a></P>
</body>
</html>
