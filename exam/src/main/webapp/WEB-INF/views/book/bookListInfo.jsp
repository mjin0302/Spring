<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h3>도서 조회/수정</h3>
    <table border="1">
        <thead>
            <tr>
                <th>도서번호</th>
                <th>도서명</th>
                <th>대여총계</th>
                <th>대여횟수</th>
            </tr>
        </thead>
    
        <tbody>
            <c:forEach items="${bookListInfo}" var="bookListInfo">
            <tr>
                <td>${bookListInfo.bookNo}</td>
                <td>${bookListInfo.bookName}</td>
                <td>${bookListInfo.totalPrice}</td>
                <td>${bookListInfo.bookCount}</td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>