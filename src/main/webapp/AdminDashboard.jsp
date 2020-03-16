<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>Company ID</th>
                <th>Company Name</th>
                <th>Company Short Name</th>
                <th>Company Country</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="comp" items="${listCompanies}">
                <tr>
                    <td>
                        <c:out value="${comp.company_id}"/>
                    </td>
                    <td>
                        <c:out value="${comp.company_name}"/>
                    </td>
                    <td>
                        <c:out value="${comp.company_short_name}"/>
                    </td>
                    <td>
                        <c:out value="${comp.company_country}"/>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
