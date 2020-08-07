<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>MMD Manager - Edit Client</title>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/adminDashStyle.css">
    <link rel="stylesheet" href="css/bootstrap/bootstrap.min.css">
    <script type="text/javascript" src='javaScript/bootstrap/jquery.min.js'></script>
    <script type="text/javascript" src='javaScript/bootstrap/bootstrap.min.js'></script>
</head>
<body>
<header class="m-0 p-2 navbar">
    <h2 class="m-0 p-2 navbar-brand"><b class="text-light">edit<span class="main-color">Client</span></b></h2>
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
    <div>
        <div class="btn-group btn-group-toggle nav nav-pills py-3 px-md-5" data-toggle="buttons" id="pills-tab" role="tablist">
            <label class="btn btn-secondary active">
                <input type="radio" name="options" id="pills-companyData-tab" data-toggle="pill" href="#pills-companyData" role="tab" aria-controls="pills-companyData" aria-selected="true">Data
            </label>
            <label class="btn btn-secondary">
                <input type="radio" name="options" id="pills-password-tab" data-toggle="pill" href="#pills-password" role="tab" aria-controls="pills-password" aria-selected="false">Password
            </label>
        </div>
        <div class="tab-content py-0 px-md-5" id="pills-tabContent">
            <div class="tab-pane fade show active" id="pills-companyData" role="tabpanel" aria-labelledby="pills-companyData-tab">
                <label for="companyId"></label>
                <input type="text" id="companyId" value="<c:out value="${client.getCompany_id()}" />">

                <label for="companyName"></label>
                <input type="text" id="companyName" value="<c:out value="${client.getCompany_name()}" />">

                <label for="shortName"></label>
                <input type="text" id="shortName" value="<c:out value="${client.getCompany_short_name()}" />">

                <label for="country"></label>
                <input type="text" id="country" value="<c:out value="${client.getCompany_country()}" />">
            </div>
        </div>
    </div>
</section>
</body>
</html>
