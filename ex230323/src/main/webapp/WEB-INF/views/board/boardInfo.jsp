<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>게시판</title>
</head>

<body>
    <table>
        <tr>
            <th>번호</th>
            <td>${boardInfo.bno }</td>
        </tr>
        <tr>
            <th>제목</th>
            <td>${boardInfo.title }</td>
        </tr>
        <tr>
            <th>작성자</th>
            <td>${boardInfo.writer }</td>
        </tr>
        <tr>
            <th>내용</th>
            <td>${boardInfo.contents}</td>
        </tr>
        <tr>
            <th>첨부이미지</th>
            <c:choose>
                <c:when test="${not empty boardInfo.image}">
                    <td>
                        <img src="<c:url value=" /resources/images/${boardInfo.image }" />" style="width: 50%;" alt="이미지" />
                    </td>
                </c:when>
                <c:otherwise>
                    <td></td>
                </c:otherwise>
            </c:choose>
            
        </tr>
        <tr>
            <th>작성일자</th>
            <td>
                <fmt:formatDate value="${boardInfo.regdate }" pattern="yyyy/MM/dd" />
            </td>
        </tr>
    </table>
    <button type="button" onclick="location.href='boardUpdate?bno=${boardInfo.bno}'">수정</button>
    <button type="button" onclick="location.href='boardDelete?bno=${boardInfo.bno}'">삭제</button>
</body>

</html>