<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Material Master Data Manager</title>
    <meta charset="ISO-8859-1">
    <link rel="stylesheet" href="css/login_style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
</head>
<body>
<section id="basicData">
    <div id="createMaterialHeader">
        <h2><b>Material Master Data Manager - ADMIN Login</b></h2>
    </div>
    <form id="transactionsLoginForm" action="UserLogin" method="POST">
        <fieldset>
            <p><button type="submit" class="fa fa-check"></button></p>
            <p><input type="text" id="transactions" name="transactions" required></p>
            <p><button type="button" class="fas fa-unlock"></button></p>
            <p><button type="button" class="fas fa-question"></button></p>
        </fieldset>
    </form>
    <form class="tabcontent" id="userLoginForm" action="AdminDashboard" method="POST">
        <fieldset>
            <label for="userID">User ID</label><br>
            <input type="text" id="userID" name="userID" onkeydown="return event.key != 'Enter';" required><br>
            <label for="userPassword">Password</label><br>
            <input type="password" id="userPassword" name="userPassword" onkeydown="return event.key != 'Enter';" required><br>
            <button type="submit" class="userLoginButton">Log In</button>
        </fieldset>
    </form>
</section>
<footer>
    <p><a>© Created by Lorem Ipsum. 2017</a></p>
</footer>
</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src='javaScript/loginAdmin.js'></script>
</html>

