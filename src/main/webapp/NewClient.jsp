<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>

<head>
    <title>MMD Manager - Add Client</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/login_style.css">
    <link rel="stylesheet" href="css/bootstrap/bootstrap.min.css">
    <script type="text/javascript" src='javaScript/bootstrap/jquery.min.js'></script>
    <script type="text/javascript" src='javaScript/bootstrap/bootstrap.min.js'></script>
</head>

<body>
<header class="m-0 p-2 navbar">
    <h2 class="m-0 p-2 navbar-brand"><b class="text-light">add<span class="main-color">Client</span></b></h2>
</header>
<nav class="m-0 p-2 navbar navbar">
    <form class="tabcontent" action="" method="POST">
        <fieldset>
            <ul class="m-0 p-0 navbar d-flex">
                <li class="m-1 p-1 nav-item"><button type="submit" class="p-1 btn btn-secondary">
                    <-Back</button>
                </li>
            </ul>
        </fieldset>
    </form>
</nav>
<section>
    <div class="container p-5">
        <div class="tab-content py-0 px-md-5">
            <form class="tabcontent" action="AddClient" method="post">
                <fieldset>
                    <label class="text-light" for="companyName">Company Name:</label><br>
                    <input type="text" id="companyName" name="companyName" maxlength="50" onkeydown="return event.key != 'Enter';" required><br>
                    <label class="text-light" for="shortName">Short Name:</label><br>
                    <input type="text" id="shortName" name="shortName" maxlength="20" onkeydown="return event.key != 'Enter';" required><br>
                    <label class="text-light" for="countryName">Country:</label><br>
                    <input type="text" id="countryName" name="countryName" maxlength="40" onkeydown="return event.key != 'Enter';" required><br>
                    <button type="submit" class="p-1 btn btn-success" value="addClientToDb" name="addClientToDb">Add Client</button>
                </fieldset>
            </form>
        </div>
    </div>
</section>
</body>

</html>