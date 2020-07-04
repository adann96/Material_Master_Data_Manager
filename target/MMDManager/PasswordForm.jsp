<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <h2 class="m-0 p-2 navbar-brand"><b class="text-light">user<span class="main-color">Password</span> - Forgot?</b></h2>
</header>
<nav class="m-0 p-2 navbar">
    <form action="UserLogout" method="post">
        <fieldset>
            <ul class="m-0 p-0 navbar d-flex">
                <li class="m-1 p-1 nav-item"><button type="submit" class="p-1 btn btn-secondary"><- Back</button></li>
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
                            <label for="userID" class="text-light">User ID</label><br>
                            <input type="text" id="userID" name="userID" onkeydown="return event.key != 'Enter';" required><br>

                            <label for="newUserPassword" class="text-light">New Password</label><br>
                            <input type="text" id="newUserPassword" name="newUserPassword" onkeydown="return event.key != 'Enter';" required><br>

                            <button type="submit" class="p-1 btn btn-secondary" id="userLoginButton">Request</button>
                        </fieldset>
                    </form>
                </div>
            </div>
    </div>
</section>
</body>
</html>
