<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>

<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/adminDashStyle.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
</head>

<body>
<header>
    <h2><b>admin<span class="main-color">Dashboard</span></b></h2>
</header>
<div id="menuToggle">
    <nav id="navMainPanel">
        <ul>
            <li class="fas fa-bars" id="hamburger"></li>
            <li class="fas fa-calendar"></li>
            <li class="fa fa-comments"></li>

        </ul>
    </nav>
    <nav id="navTogglePanel">
        <ul>
            <h1>Users</h1>
            <li><a href="">Add New User</a></li>
            <li><a href="">Delete User</a></li>
            <li><a href="">Update User</a></li>
            <li><a href="">Set New Password</a></li>
        </ul>
        <ul>
            <h1>Clients</h1>
            <li><a href="">Add New Client</a></li>
            <li><a href="">Delete Client</a></li>
            <li><a href="">Update Client</a></li>
        </ul>
        <ul>
            <h1>Stats</h1>
            <li><a href="">Sessions</a></li>
            <li><a href="">Creations</a></li>
            <li><a href="">Modifications</a></li>
        </ul>
    </nav>
</div>
<section>
    <div class="dashData" id="welcomeContent">
        <h2>Welcome to Dashboard, ADMIN1</h2>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor.</p>
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
<div id="barChart" style="width: 100%; height: 250px;"></div>
</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script src='javaScript/toggleMenu.js'></script>
<script src='javaScript/barChart.js'></script>
<script src="https://www.google.com/jsapi"></script>
</html>