<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Companies</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Short Name</th>
            <th>Country</th>
        </tr>
        <c:forEach var="comp" items="${listComp}">
            <tr>
                <td>${comp.company_id}</td>
                <td><c:out value="${comp.company_name}" /></td>
                <td><c:out value="${comp.company_name_short}" /></td>
                <td><c:out value="${comp.company_country}" /></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
