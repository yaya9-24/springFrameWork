<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>글삭제</title>
</head>
<body>
<h1><%= "구매정보 삭제 페이지" %>
</h1>
<br/>
<jsp:include page="../top_menu.jsp"/>
<%--정말 삭제하시겠습니까?> 폼처리구현. and 로그찍기--%>
<form action="p_deleteOK.do" method="post">
    <table>
        <tbody>
        <tr>
            <th>${param.num}번 제품을 정말 삭제하시겠습니까?</th>
            <td><input type="hidden" name="num" value=${param.num}></td>
        </tr>
        </tbody>
        <tfoot>
        <tr>
            <td><input type="submit" value="삭제완료"></td>
        </tr>
        </tfoot>
    </table>
</form>
</body>
</html>
