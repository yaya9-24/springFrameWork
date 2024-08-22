<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        input[type=text],
        textarea,
        select {
            width: 100%;
            padding: 8px 8px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ff8f8f;
            border-radius: 14px;
            box-sizing: border-box;
        }

        input[type=submit] {
            width: 30%;
            background-color: #4CAF50;
            color: white;
            padding: 8px 8px;
            margin: 8px 0;
            border: none;
            border-radius: 14px;
            cursor: pointer;
        }

        input[type=submit]:hover {
            background-color: #b7e5b9;
        }

        div {
            border-radius: 15px;
            background-color: #f0f0f0;
            padding: 20px;
        }

        #insertTable {
            font-family: Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        #insertTable td {
            border: 1px solid #ddd;
            padding: 8px;
        }

        #insertTable tr:nth-child(even) {
            background-color: #ebebeb;
        }

        #insertTable tr:hover {
            background-color: #ffc6c6;
        }
    </style>
</head>
<body>
<jsp:include page="../top_menu.jsp"/>
<div>
    <h1><%= "구매정보 수정 페이지" %></h1>
    <form action="p_updateOK.do" method="post">
        <table id="insertTable">
            <tr>
                <td><label for="num">번호</label></td>
                <td>${param.num}<input type="hidden" id="num" name="num" value=${param.num} ></td>
            </tr>
            <tr>
                <td><label for="pname">상품이름</label></td>
                <td><input type="text" id="pname" name="pname" value="${vo2.pname}"></td>
            </tr>
            <tr>
                <td><label for="model">모델이름</label></td>
                <td><input type="text" name="model" id="model" value="${vo2.model}"></td>
            </tr>
            <tr>
                <td><label for="price">가격</label></td>
                <td><input type="text" id="price" name="price" value="${vo2.price}"></td>
            </tr>
            <tr>
                <td><label for="count">개수</label></td>
                <td><input type="text" id="count" name="count" value="${vo2.count}"></td>
            </tr>
            <tr>
                <td><label for="user_id">구매자</label></td>
                <td>${vo2.user_id}<input type="hidden" id="user_id" name="user_id" value="${vo2.user_id}"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="수정완료"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>