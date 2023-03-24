<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <!-- ContextPath     1) 씨태그<씨:유알엘=""/>      2)el태그 -->
    <form action='empInsert' method="POST">
        <div>
            <label>first_name : <input type="text" name="firstName"></label>
        </div>
        <div>
            <label>last_name : <input type="text" name="lastName"></label>
        </div>
        <div>
            <label>email : <input type="email" name="email"></label>
        </div>
        <div>
            <label>job_id : <input type="text" name="jobId"></label>
        </div>
        <div>
            <label>salary : <input type="number" name="salary"></label>
        </div>

        <button type="submit">등록</button>
        <button type="button">목록</button>
    </form>
</body>
</html>