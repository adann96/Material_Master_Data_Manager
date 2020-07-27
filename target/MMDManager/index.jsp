<%@ page contentType="text/html; ISO-8859-1" language="java" %>
<html>
<head>
    <title>Material Master Data Manager</title>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/login_style.css">
    <link rel="stylesheet" href="css/bootstrap/bootstrap.min.css">
    <script type="text/javascript" src='javaScript/bootstrap/jquery.min.js'></script>
    <script type="text/javascript" src='javaScript/bootstrap/bootstrap.min.js'></script>
</head>
<body>
<header class="m-0 p-2 navbar">
    <h2 class="m-0 p-2 navbar-brand"><b class="text-light">user<span class="main-color">Login</span></b></h2>
</header>
<nav class="m-0 p-2 navbar navbar">
    <form action="SetPassword" method="POST">
        <fieldset>
            <ul class="m-0 p-0 navbar d-flex">
                <li class="m-1 p-1 nav-item"><button type="submit" class="p-1 btn btn-secondary">Forgot Password</button></li>
                <li class="m-1 p-1 nav-item"><button id="getInfoAboutProject" type="button" class="p-1 btn btn-secondary">Info</button></li>
            </ul>
        </fieldset>
    </form>
</nav>
<section>
    <div class="container p-5">
        <ul class="nav nav-pills py-3 px-md-5" id="pills-tab" role="tablist">
            <li class="nav-item">
                <button class="btn btn-secondary" id="pills-users-tab" data-toggle="pill" href="#pills-users" role="tab" aria-controls="pills-users" aria-selected="true">User</button>
                <button class="btn btn-secondary" id="pills-admin-tab" data-toggle="pill" href="#pills-admin" role="tab" aria-controls="pills-admin" aria-selected="false">Admin</button>
            </li>
        </ul>
        <div class="tab-content py-0 px-md-5" id="pills-tabContent">
            <div class="tab-pane fade show active" id="pills-users" role="tabpanel" aria-labelledby="pills-users-tab">
                <form class="tabcontent" action="MaterialDashboard" method="POST">
                    <fieldset>
                        <label for="client" class="text-light">Client</label><br>
                        <input type="text" name="client" id="client" onkeydown="return event.key != 'Enter';" required><br>
                        <label for="userID" class="text-light">User ID</label><br>
                        <input type="text" id="userID" name="userID" onkeydown="return event.key != 'Enter';" required><br>
                        <label for="userPassword" class="text-light">Password</label><br>
                        <input type="password" id="userPassword" name="userPassword" onkeydown="return event.key != 'Enter';" required><br>
                        <button type="submit" class="p-1 btn btn-secondary" id="userLoginButton">Log In</button>
                    </fieldset>
                </form>
            </div>
            <div class="tab-pane fade" id="pills-admin" role="tabpanel" aria-labelledby="pills-admin-tab">
                <form class="tabcontent" action="AdminDashboard" method="POST">
                    <fieldset>
                        <label for="adminID" class="text-light">Admin ID</label><br>
                        <input type="text" id="adminID" name="adminID" onkeydown="return event.key != 'Enter';" required><br>
                        <label for="adminPassword" class="text-light">Password</label><br>
                        <input type="password" id="adminPassword" name="adminPassword" onkeydown="return event.key != 'Enter';" required><br>
                        <button type="submit" class="p-1 btn btn-secondary" value="addUserToDb" name="adminLoginButton" id="adminLoginButton">Log In</button>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
</section>
</body>
</html>