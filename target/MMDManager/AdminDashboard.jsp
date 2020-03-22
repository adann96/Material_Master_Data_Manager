<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/adminDashStyle.css">
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>Logon ID</th>
                <th>User ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Client</th>
                <th>Start of Session</th>
                <th>End of Session</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="log" items="${listLogons}">
                <tr>
                    <td>
                        <c:out value="${log.logon_id}"/>
                    </td>
                    <td>
                        <c:out value="${log.user_id}"/>
                    </td>
                    <td>
                        <c:out value="${log.first_name}"/>
                    </td>
                    <td>
                        <c:out value="${log.last_name}"/>
                    </td>
                    <td>
                        <c:out value="${log.company_short_name}"/>
                    </td>
                    <td>
                        <c:out value="${log.start_session}"/>
                    </td>
                    <td>
                        <c:out value="${log.end_of_session}"/>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
