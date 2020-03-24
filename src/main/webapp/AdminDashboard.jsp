<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<html>

<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/adminDashStyle.css">
</head>

<body>
<section>
    <div id="materialHeader">
        <h2><b>Material Master Data Manager - Admin Dashboard</b></h2>
    </div>
    <div id="menuToggle">
        <div id="hamburger">&#9776;</div>
        <nav>
            <ul>
                <h1>Users</h1>
                <li><button type="submit">Add New User</button></li>
                <li><button type="submit">Delete User</button></li>
                <li><button type="submit">Update User</button></li>
                <li><button type="submit">Set New Password</button></li>
            </ul>
            <ul>
                <h1>Clients</h1>
                <li><button type="submit">Add New Client</button></li>
                <li><button type="submit">Delete Client</button></li>
                <li><button type="submit">Update Client</button></li>
            </ul>
        </nav>
    </div>
</section>
<section id="sectionDash">
    <div class="dashData" id="leftPanel">Lala</div>
    <div class="dashData" id="midPanel">
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
                        <c:out value="${log.logon_id}" />
                    </td>
                    <td>
                        <c:out value="${log.user_id}" />
                    </td>
                    <td>
                        <c:out value="${log.first_name}" />
                    </td>
                    <td>
                        <c:out value="${log.last_name}" />
                    </td>
                    <td>
                        <c:out value="${log.company_short_name}" />
                    </td>
                    <td>
                        <c:out value="${log.start_session}" />
                    </td>
                    <td>
                        <c:out value="${log.end_of_session}" />
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div  class="dashData" id="rightPanel">Lala</div>
</section>
</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src='javaScript/toggleMenu.js'></script>

</html>