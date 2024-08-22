<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>전체 회원가입 목록</title>
</head>
<body>
<h1><%= "상품 구매 목록" %></h1>
<br/>
<jsp:include page="../top_menu.jsp"/>
<%--검색어 검색은 post로 넘기는 일이 별로 없다.--%>
<form action="p_searchList.do">
  <select name="searchKey">
    <option value="pname">pname</option>
    <option value="model">model</option>
  </select>
  <input type="text" name="searchWord" value="제네시스2" placeholder="검색어를 입력하세요">
  <input type="submit" value="검색">
</form>
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
  <c:forEach var="vo" items="${list}">
    <tr>
      <td><a href="p_selectOne.do?num=${vo.num}">${vo.num}</a></td>
      <td><a href="p_selectOne.do?num=${vo.num}">${vo.pname}</a></td>
      <td>${vo.model}</td>
      <td>${vo.price}</td>
      <td>${vo.count}</td>
      <td>${vo.user_id}</td>
    </tr>
  </c:forEach>

  </tbody>
  <tfoot>
  <tr>
    <td colspan="6" align="center"><<1 2 3 4 5>></td>
  </tr>
  </tfoot>
</table>
</body>
</html>