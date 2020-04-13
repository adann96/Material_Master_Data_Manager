<%@ page contentType="text/html; ISO-8859-1" language="java" %>
<html>
<head>
    <title>Material Master Data Manager</title>
    <meta charset="ISO-8859-1">
    <link rel="stylesheet" href="css/login_style.css">
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
    <h2 class="m-0 p-2 navbar-brand"><b class="text-light">user<span class="main-color">Login</span></b></h2>
</header>
<nav class="m-0 p-2 navbar navbar">
    <form action="AdminLogin" method="POST">
        <fieldset>
            <ul class="m-0 p-0 navbar d-flex">
                <li class="m-1 p-1 nav-item"><button type="submit" class="p-1 btn btn-secondary">Execute</button></li>
                <li class="m-1 p-1 nav-item"><input type="text" class="p-1" id="transactions" name="transactions" required></li>
                <li class="m-1 p-1 nav-item"><button type="button" class="p-1 btn btn-secondary">Password</button></li>
                <li class="m-1 p-1 nav-item"><button id="getInfoAboutProject" type="button" class="p-1 btn btn-secondary">Info</button></li>
            </ul>
        </fieldset>
    </form>
</nav>
<section>
    <div class="container p-5">
        <div class="row p-4">
            <div class="col">
                <form class="tabcontent" id="userLoginForm" action="MaterialDashboard" method="POST">
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
</section>
</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src='javaScript/loginUser.js'></script>
</html>