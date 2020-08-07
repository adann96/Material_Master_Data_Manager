<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>MMD Manager - Add Client</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/login_style.css">
    <link rel="stylesheet" href="css/newObjectStyle.css">
    <link rel="stylesheet" href="css/bootstrap/bootstrap.min.css">
    <script type="text/javascript" src='javaScript/bootstrap/jquery.min.js'></script>
    <script type="text/javascript" src='javaScript/bootstrap/bootstrap.min.js'></script>
</head>
<body>
<header class="m-0 p-2 navbar">
    <h2 class="m-0 p-2 navbar-brand"><b class="text-light">add<span class="main-color">User</span></b></h2>
</header>
<nav class="m-0 p-2 navbar navbar">
    <form action="" method="POST">
        <fieldset>
            <ul class="m-0 p-0 navbar d-flex">
                <li class="m-1 p-1 nav-item"><button type="submit" class="p-1 btn btn-secondary"><-Back</button></li>
            </ul>
        </fieldset>
    </form>
</nav>
<section>
    <div class="container p-5">
        <div class="tab-content py-0 px-md-5">
            <form class="tabcontent" action="AddUser" method="post">
                <fieldset>
                    <label class="text-light" for="userId">User ID:</label><br>
                    <input type="text" id="userId" name="userId" maxlength="6" onkeydown="return event.key != 'Enter';" required><br>
                    <label class="text-light" for="firstName">First Name:</label><br>
                    <input type="text" id="firstName" name="firstName" maxlength="15" onkeydown="return event.key != 'Enter';" required><br>
                    <label class="text-light" for="middleName">Middle Name:</label><br>
                    <input type="text" id="middleName" name="middleName" maxlength="15" onkeydown="return event.key != 'Enter';"><br>
                    <label class="text-light" for="lastName">Last Name:</label><br>
                    <input type="text" id="lastName" name="lastName" maxlength="30" onkeydown="return event.key != 'Enter';" required><br>
                    <label class="text-light">Sex: </label><br>
                        <select class="sex" name="sex">
                            <option value="M">Male</option>
                            <option value="F">Female</option>
                        </select>
                    <br>
                    <label class="text-light">Company: </label><br>
                        <select class="company" name="company">
                            <option value="106">Daikin Airconditioning Poland Sp. z o.o.</option>
                            <option value="105">Nordea Bank Abp SA Oddział w Polsce</option>
                            <option value="104">Fujitsu Technology Solutions</option>
                            <option value="103">Comarch SA</option>
                            <option value="102">GFT Poland Sp. z o.o.</option>
                            <option value="101">Commerzbank AG S.A. Branch in Lodz</option>
                            <option value="100">Infosys Consulting</option>
                        </select>
                    <br>
                    <label class="text-light">Is Admin? </label><br>
                        <select class="isAdmin" name="isAdmin">
                            <option value="N">No</option>
                            <option value="Y">Yes</option>
                        </select>
                    <br>
                    <button type="submit" class="p-1 btn btn-success" value="addUserToDb" name="addUserToDb">Add User</button>
                </fieldset>
            </form>
        </div>
    </div>
</section>
</body>
</html>
