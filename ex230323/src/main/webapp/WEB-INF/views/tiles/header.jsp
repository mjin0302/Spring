<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav>
	<ul class="nav">
<!--         <li class="nav-item"> -->
<!--             <a href="${pageContext.request.contextPath}" class="nav-link"></a>전체조회 --!>
<!--         </li> -->
<!--         <li class="nav-item"> -->
<!--             <a href="${pageContext.request.contextPath}" class="nav-link"></a>등록 --!>
<!--         </li> -->
        <li class="nav-item">
            <a href="${pageContext.request.contextPath}/getBoardList" class="nav-link">전체조회</a>
        </li>
        <li class="nav-item">
            <a href="${pageContext.request.contextPath}/boardInsert" class="nav-link">등록</a>
        </li>
    </ul>
</nav>