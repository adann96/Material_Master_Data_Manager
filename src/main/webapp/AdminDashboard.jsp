<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>

<head>
    <title>MMD Manager - Admin Dashboard</title>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/adminDashStyle.css">
    <link rel="stylesheet" href="css/bootstrap/bootstrap.min.css">
    <script type="text/javascript" src='javaScript/bootstrap/jquery.min.js'></script>
    <script type="text/javascript" src='javaScript/bootstrap/bootstrap.min.js'></script>
</head>

<body>
<header class="m-0 p-2 navbar">
    <h2 class="m-0 p-2 navbar-brand"><b class="text-light">admin<span class="main-color">Dashboard</span></b></h2>
</header>
<div class="pos-f-t">
    <nav class="m-0 p-2 navbar">
        <form id="logoutButton" action="AdminLogout" method="POST">
            <fieldset>
                <ul class="m-0 p-0 navbar d-flex">
                    <li class="m-1 p-1 nav-item">
                        <button type="submit" class="p-1 btn btn-secondary">Logout</button>
                    </li>
                </ul>
            </fieldset>
        </form>
    </nav>
</div>

<div class="welcome text-light">
    <div class="container-fluid">
        <div class="row">
            <div class="col">
                <h2>Welcome to Dashboard</h2>
                <p>Today is <%= new java.util.Date() %></p>
            </div>
        </div>
    </div>
</div>
<section>
    <div>
        <div class="btn-group btn-group-toggle nav nav-pills py-3 px-md-5" data-toggle="buttons" id="pills-tab" role="tablist">
            <label class="btn btn-secondary active">
                <input type="radio" name="options" id="pills-logons-tab" data-toggle="pill" href="#pills-logons" role="tab" aria-controls="pills-logons" aria-selected="true"> Logons
            </label>
            <label class="btn btn-secondary">
                <input type="radio" name="options" id="pills-users-tab" data-toggle="pill" href="#pills-users" role="tab" aria-controls="pills-users" aria-selected="false"> Users
            </label>
            <label class="btn btn-secondary">
                <input type="radio" name="options" id="pills-clients-tab" data-toggle="pill" href="#pills-clients" role="tab" aria-controls="pills-clients" aria-selected="false"> Clients
            </label>
        </div>
        <div class="tab-content py-0 px-md-5" id="pills-tabContent">
            <div class="tab-pane fade show active" id="pills-logons" role="tabpanel" aria-labelledby="pills-logons-tab">
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
            <div class="tab-pane fade" id="pills-users" role="tabpanel" aria-labelledby="pills-users-tab">
                <table class="table table-striped table-dark table-hover">
                    <thead>
                    <tr>
                        <th scope="col">User ID</th>
                        <th scope="col">First Name</th>
                        <th scope="col">Middle Name</th>
                        <th scope="col">Last Name</th>
                        <th scope="col">Sex</th>
                        <th scope="col">Company ID</th>
                        <th scope="col">Is Admin?</th>
                        <th scope="col">Account Password</th>
                        <th><a href="NewUser" class="btn btn-success btn-sm" id="addNewUser" type="submit">Add</a></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="user" items="${listUsers}">
                        <tr>
                            <th scope="row">
                                <c:out value="${user.getUser_id()}" />
                            </th>
                            <td>
                                <c:out value="${user.getFirst_name()}" />
                            </td>
                            <td>
                                <c:out value="${user.getMiddle_name()}" />
                            </td>
                            <td>
                                <c:out value="${user.getLast_name()}" />
                            </td>
                            <td>
                                <c:out value="${user.getSex()}" />
                            </td>
                            <td>
                                <c:out value="${user.getCompany_id()}" />
                            </td>
                            <td>
                                <c:out value="${user.getIs_admin()}" />
                            </td>
                            <td>
                                <c:out value="${user.getAcc_password()}" />
                            </td>
                            <td>
                                <form method="get">
                                    <button class="btn btn-warning btn-sm" type="submit" formaction="ModifyUser" name="editUser" value="<c:out value='${user.getUser_id()}'/>">Edit</button>
                                    <button class="btn btn-danger btn-sm" type="submit" formaction="DeleteUser" name="deleteUser" value="<c:out value='${user.getUser_id()}'/>">Delete</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

            <div class="tab-pane fade" id="pills-clients" role="tabpanel" aria-labelledby="pills-clients-tab">
                <table class="table table-striped table-dark table-hover">
                    <thead>
                    <tr>
                        <th scope="col">Company ID</th>
                        <th scope="col">Company Name</th>
                        <th scope="col">Company Short Name</th>
                        <th scope="col">Country</th>
                        <th><a href="NewClient" class="btn btn-success btn-sm" id="addNewClient" type="submit">Add</a></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="client" items="${listClients}">
                        <tr>
                            <th scope="row">
                                <c:out value="${client.getCompany_id()}" />
                            </th>
                            <td>
                                <c:out value="${client.getCompany_name()}" />
                            </td>
                            <td>
                                <c:out value="${client.getCompany_short_name()}" />
                            </td>
                            <td>
                                <c:out value="${client.getCompany_country()}" />
                            </td>
                            <td>
                                <form method="get">
                                    <button class="btn btn-warning btn-sm" type="submit" formaction="ModifyClient" name="modifyClient" value="<c:out value='${client.getCompany_id()}'/>">Edit</button>
                                    <button class="btn btn-danger btn-sm" type="submit" formaction="DeleteClient" name="deleteClient" value="<c:out value='${client.getCompany_id()}'/>">Delete</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

        </div>
    </div>
</section>
</body>
</html>