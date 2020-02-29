<%@ page contentType="text/html; ISO-8859-1" language="java" %>
<html>
<head>
    <title>Material Master Data Manager</title>
    <meta charset="ISO-8859-1">
    <link rel="stylesheet" href="css/login_style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<div id="basicData">
    <div id="createMaterialHeader">
        <h2><b>Material Master Data Manager</b></h2>
    </div>
    <form class="tabcontent" action="MaterialCreator" method="POST">
        <fieldset>
            <div id="newPasswordBar">
                <p><button type="submit" class="fa fa-check"></button></p>
                <p><a href="">New Password</a></p>
            </div>
            <label for="client">Client</label><br>
            <select type="text" name="client" id="client">
                <option>Commerzbank AG S.A. Branch in Lodz</option>
                <option>Daikin Airconditioning Poland Sp. z o.o.</option>
                <option>Infosys Consulting</option>
            </select><br>
            <label for="userID">User ID</label><br>
            <input type="text" id="userID" name="userID"><br>
            <label for="userPassword">Password</label><br>
            <input type="password" id="userPassword" name="userPassword"><br>
            <label for="isAdmin">Admin</label><br>
            <input type="text" id="isAdmin" name="isAdmin"><br>
        </fieldset>
    </form>
</div>
</div>
<footer>
    <p><a>© Created by Lorem Ipsum. 2017</a></p>
</footer>
</body>
<script src='javaScript/loginJs.js'></script>
</html>