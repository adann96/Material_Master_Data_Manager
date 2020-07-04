<%@ page contentType="text/html; ISO-8859-1" language="java" %>
<html>
<head>
    <title>Material Master Data Manager</title>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/login_style.css">
    <link rel="stylesheet" href="css/bootstrap/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
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
        <ul class="nav nav-tabs" id="myTab" role="tablist">
            <li class="nav-item">
                <a class="nav-link active" id="user-tab" data-toggle="tab" href="#user" role="tab" aria-controls="user" aria-selected="true">User</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" id="admin-tab" data-toggle="tab" href="#admin" role="tab" aria-controls="admin" aria-selected="false">Admin</a>
            </li>
        </ul>
        <div class="tab-content" id="myTabContent">
            <div class="tab-pane fade show active" id="user" role="tabpanel" aria-labelledby="user-tab">
                <div class="row p-4" id="home" role="tabpanel" aria-labelledby="home-tab">
                    <div class="col">
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
                </div>
            </div>
            <div class="tab-pane fade" id="admin" role="tabpanel" aria-labelledby="admin-tab">
                <div class="row p-4">
                    <div class="col">
                        <form class="tabcontent" action="AdminDashboard" method="POST">
                            <fieldset>
                                <label for="adminID" class="text-light">Admin ID</label><br>
                                <input type="text" id="adminID" name="adminID" onkeydown="return event.key != 'Enter';" required><br>
                                <label for="adminPassword" class="text-light">Password</label><br>
                                <input type="password" id="adminPassword" name="adminPassword" onkeydown="return event.key != 'Enter';" required><br>
                                <button type="submit" class="p-1 btn btn-secondary" id="adminLoginButton">Log In</button>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src='javaScript/bootstrap/bootstrap.min.js'></script>
</html>