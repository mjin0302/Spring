<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
  <meta charset="UTF-8">
	<title>전체조회</title>

  <style>
	
    table {
      margin: auto;
      border: 1px sloid #f5dce0;
    }
    tr, th, td {
      border: 1px sloid #f5dce0;
      padding: 5px;
    }
  </style>

</head>
<body>
  <table>
    <thead>
      <tr>
        <th>employee_id</th>
        <th>first_name</th>
        <th>last_name</th>
        <th>email</th>
        <th>hire_date</th>
        <th>job_id</th>
        <th>salary</th>
      </tr>
    </thead>

    <tbody>
      <c:forEach items="${empList}" var="emp">
        <tr>
          <td>${emp.employeeId}</td>
          <td>${emp.firstName}</td>
          <td>${emp.lastName}</td>
          <td>${emp.email}</td>
          <td>${emp.hireDate}</td>
          <td>${emp.jobId}</td>
          <td>${emp.salary}</td>
        </tr>

      </c:forEach>
    </tbody>
  </table>
  <script>
    function printAlert(message) {
      alert(message);
    }
    // 우리가 보낸 데이터로 변환되서 들어감
    printAlert(`${result}`);
  </script>
</body>
</html>
