<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul id="menu">
	<li><a href="home.do">HOME</a></li>
	<li><a href=m_selectAll.do">회원목록</a>
		<ul>
			<li><a href="m_selectAll.do">회원목록</a></li>
			<li><a href="m_insert.do">회원가입</a></li>
					
		</ul>
	</li>
	<c:if test="${user_id==null}"><li><a href="m_login.do">로그인</a></li></c:if>
	<c:if test="${user_id!=null}"><li><a href="logout.do">로그아웃</a></li></c:if>
</ul>