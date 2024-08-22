<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>글번호검색</title>
</head>
<body>
<h1><%= "상품번호검색" %>
</h1>
<br/>
<jsp:include page="../top_menu.jsp"/>
<table border="1">
    <thead>
    <tr>
        <th>번호</th>
        <th>상품이름</th>
        <th>모델이름</th>
        <th>가격</th>
        <th>개수</th>
        <th>구매자</th>
    </tr>
    </thead>
    <tbody>
        <tr>
            <td>${vo2.num}</td>
            <td>${vo2.pname}</td>
            <td>${vo2.model}</td>
            <td>${vo2.price}</td>
            <td>${vo2.count}</td>
            <td>${vo2.user_id}</td>
        </tr>
    </tbody>
</table>
<a href="p_update.do?num=${vo2.num}">구매정보 수정</a>
<a href="p_delete.do?num=${vo2.num}">구매정보 삭제</a>
</body>
</html>
