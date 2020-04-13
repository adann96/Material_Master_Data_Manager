<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>

<head>
    <title>Material Master Data Manager</title>
    <link rel="stylesheet" href="css/adminDashStyle.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>

<body>
<header class="m-0 p-2 navbar">
    <h2 class="m-0 p-2 navbar-brand"><b class="text-light">admin<span class="main-color">Dashboard</span></b></h2>
</header>

<div class="pos-f-t">
    <nav class="m-0 p-2 navbar">
        <form action="" method="POST">
            <fieldset>
                <ul class="m-0 p-0 navbar d-flex">
                    <li class="m-1 p-1 nav-item">
                        <button type="submit" class="p-1 btn btn-secondary">Logout</button>
                    </li>
                </ul>
            </fieldset>
        </form>
        <ul class="m-0 p-0 navbar d-flex">
            <li class="m-1 p-1 nav-item">
                <button class="p-1 btn btn-secondary" type="submit" data-toggle="collapse" data-target="#navbarToggleUsers" aria-controls="navbarToggleUsers" aria-expanded="false" aria-label="Toggle navigation">Users</button>
            </li>
            <li class="m-1 p-1 nav-item">
                <button class="p-1 btn btn-secondary" type="submit" data-toggle="collapse" data-target="#navbarToggleClients" aria-controls="navbarToggleClients" aria-expanded="false" aria-label="Toggle navigation">Clients</button>
            </li>
        </ul>
    </nav>
    <div class="collapse" id="navbarToggleUsers">
        <div class="crudButtons p-3">
            <h4 class="m-1 text-white">Users</h4>
            <ul class="m-0 p-0 nav flex-column">
                <li class="m-1 p-0 nav-item">
                    <button type="submit" class="p-1 btn btn-secondary">Add New User</button>
                </li>
                <li class="m-1 p-0 nav-item">
                    <button type="submit" class="p-1 btn btn-secondary">Delete User</button>
                </li>
                <li class="m-1 p-0 nav-item">
                    <button type="submit" class="p-1 btn btn-secondary">Update User</button>
                </li>
                <div class="dropdown-divider"></div>
                <li class="m-1 p-0 nav-item">
                    <button type="submit" class="p-1 btn btn-secondary">Set New Password</button>
                </li>
            </ul>
        </div>
    </div>
    <div class="collapse" id="navbarToggleClients">
        <div class="crudButtons p-3">
            <h4 class="m-1 text-white">Clients</h4>
            <ul class="m-0 p-0 nav flex-column">
                <li class="m-1 p-0 nav-item">
                    <button type="submit" class="p-1 btn btn-secondary">Add New Client</button>
                </li>
                <li class="m-1 p-0 nav-item">
                    <button type="submit" class="p-1 btn btn-secondary">Delete Client</button>
                </li>
                <li class="m-1 p-0 nav-item">
                    <button type="submit" class="p-1 btn btn-secondary">Update Client</button>
                </li>
            </ul>
        </div>
    </div>
</div>

<div class="welcome text-light">
    <div class="container-fluid">
        <div class="row">
            <div class="col">
                <h2>Welcome to Dashboard</h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor.</p>
            </div>
        </div>
    </div>
</div>

<section>
    <div class="stats text-light">
        <div class="container-fluid">
            <div class="row">
                <div class="col">
                    <h2>Welcome to Dashboard</h2>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor.</p>
                </div>
                <div class="col">
                    <h2>Welcome to Dashboard</h2>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor.</p>
                </div>
                <div class="col">
                    <h2>Welcome to Dashboard</h2>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor.</p>
                </div>
            </div>
        </div>
    </div>
</section>

<section>
    <div class="stats text-light">
        <div class="container-fluid">
            <div class="row">
                <div class="p-0 col">
                    <table class="table table-striped table-dark table-hover">
                        <thead>
                        <tr>
                            <th scope="col">Logon ID</th>
                            <th scope="col">User ID</th>
                            <th scope="col">First Name</th>
                            <th scope="col">Last Name</th>
                            <th scope="col">Client</th>
                            <th scope="col">Start of Session</th>
                            <th scope="col">End of Session</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="log" items="${listLogons}">
                            <tr>
                                <th scope="row">
                                    <c:out value="${log.logon_id}" />
                                </th>
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
                <div class="col">
                    <h2>Welcome to Dashboard</h2>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor.</p>
                </div>
            </div>
        </div>
    </div>
</section>


<!--<div id="barChart" style="width: 100%; height: 250px;"></div>-->
</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!--<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>-->
<!--<script src='javaScript/barChart.js'></script>-->
<!--<script src="https://www.google.com/jsapi"></script>-->
</html>