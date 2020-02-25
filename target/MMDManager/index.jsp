<html>

<head>
    <title>Material Master Data Manager</title>
    <meta charset="ISO-8859-1">
    <script type='text/javascript' src='javaScript/loginJs.js'></script>
    <link rel="stylesheet" href="css/login_style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
<div id="basicData">
    <div id="createMaterialHeader">
        <h2><i><b>Material Master Data Creator</b></i></h2>
        <div id="newPasswordBar">
            <p><button type="submit" class="fa fa-check"></button></p>
            <p><a href="">New Password</a></p>
        </div>
    </div>
    <div class="tabcontent">
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
        <input type="text" id="isAdmin" name="isAdmin">
    </div>
</div>
</div>
<footer>
    <p><a>© Created by Lorem Ipsum. 2017</a></p>
</footer>
</body>

</html>