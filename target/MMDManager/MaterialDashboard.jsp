<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>MMD Manager - User Dashboard</title>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/userDashStyle.css">
    <link rel="stylesheet" href="css/bootstrap/bootstrap.min.css">
    <script type="text/javascript" src='javaScript/bootstrap/jquery.min.js'></script>
    <script type="text/javascript" src='javaScript/bootstrap/bootstrap.min.js'></script>
</head>
<body>
<header class="m-0 p-2 navbar">
    <h2 class="m-0 p-2 navbar-brand"><b class="text-light">user<span class="main-color">Login</span> - Material Creation | You are logged in as <%= session.getAttribute("user_id") %></b></h2>
</header>
<nav class="m-0 p-2 navbar">
    <form id="matDashForm" method="post">
        <fieldset>
            <ul class="m-0 p-0 navbar d-flex">
                <li class="m-1 p-1 nav-item"><button id="userLogOut" formaction="UserLogout" class="p-1 btn btn-secondary" type="submit">Log Out</button></li>
                <li class="m-1 p-1 nav-item"><button id="showStats" class="p-1 btn btn-secondary" type="submit">Stats</button></li>
            </ul>
        </fieldset>
    </form>
</nav>
<section>
    <div class="container-fluid">
        <div class="row">
            <div class="m-5 col">
                <div class="container p-4">
                    <nav>
                        <div class="nav nav-tabs" id="nav-tab" role="tablist">
                            <a class="nav-item nav-link active" id="nav-generalData-tab" data-toggle="tab" href="#nav-generalData" role="tab" aria-controls="nav-generalData" aria-selected="true">General<br>Data</a>
                            <a class="nav-item nav-link" id="nav-materialData-tab" data-toggle="tab" href="#nav-materialData" role="tab" aria-controls="nav-materialData" aria-selected="false">Material<br>Data</a>
                            <a class="nav-item nav-link" id="nav-weightsAndDimensions-tab" data-toggle="tab" href="#nav-weightsAndDimensions" role="tab" aria-controls="nav-weightsAndDimensions" aria-selected="false">Weigths &<br>Dimensions</a>
                            <a class="nav-item nav-link" id="nav-technicalData-tab" data-toggle="tab" href="#nav-technicalData" role="tab" aria-controls="nav-technicalData" aria-selected="false">Technical<br>Data</a>
                            <a class="nav-item nav-link" id="nav-logisticData-tab" data-toggle="tab" href="#nav-logisticData" role="tab" aria-controls="nav-logisticData" aria-selected="false">Logistic<br>Data</a>
                        </div>
                    </nav>
                    <form action="Materials" method="get">
                        <div class="tab-content text-light" id="nav-tabContent">
                            <div class="tab-pane fade show active" id="nav-generalData" role="tabpanel" aria-labelledby="nav-generalData-tab"><label for="employeeID">Employee ID: </label><br>
                                <input type="text" name="employeeID" id="employeeID" value="<%= session.getAttribute("user_id") %>" readonly><br>
                                <hr>
                                <label for="eskNumber">(E)SK Number: </label><br>
                                <input type="text" name="eskNumber" id="eskNumber" required><br>
                                <hr>
                                <label for="requestTypeSelection">Request Type: </label><br>
                                <select id="requestTypeSelection" name="requestType">
                                    <option value="creation">CREATION</option>
                                </select><br>
                                <label for="requestSubtypeSelection">Request Subtype: </label><br>
                                <select id="requestSubtypeSelection" name="requestSubType">
                                    <option value="HAWA/ZPLA">HAWA/ZPLA</option>
                                    <option value="NEW BATCH">NEW BATCH</option>
                                    <option value="ZPLA>HAWA">ZPLA>HAWA</option>
                                    <option value="DIEN">DIEN</option>
                                </select></div>
                            <div class="tab-pane fade" id="nav-materialData" role="tabpanel" aria-labelledby="nav-materialData-tab">
                                <label for="productNumber">Product Number: </label><br>
                                <input type="text" maxlength="12" name="productNumber" id="productNumber" required><br>
                                <label for="materialName">Material Name: </label><br>
                                <input type="text" maxlength="8" name="materialName" id="materialName" required><br>
                                <label for="remark">Remark: </label><br>
                                <textarea name="remark" id="remark" rows="3" cols="30"></textarea><br>
                                <label>Batch: </label><br>
                                    <select class="batch" name="batchCountry">
                                        <option value="DE">DE</option>
                                        <option value="PL">PL</option>
                                        <option value="HU">HU</option>
                                        <option value="GB">GB</option>
                                    </select>
                                    <select class="batch" name="batchNumber">
                                        <option value="1">01</option>
                                        <option value="2">02</option>
                                        <option value="3">03</option>
                                        <option value="4">04</option>
                                    </select>
                                <br>
                                <label>Material Group: </label><br>
                                    <select class="materialGroup" name="firstLevelMG" id="select1">
                                        <option value="210 - HOUSEHOLD">210 - HOUSEHOLD</option>
                                    </select>
                                    <select class="materialGroup" name="secondLevelMG" id="select2">
                                    </select>
                                </br>
                                <label>Product Hierarchy: </label><br>
                                    <select class="materialGroup" name="productHierarchy1" id="select3">
                                    </select>
                                    <select class="materialGroup" name="productHierarchy2" id="select4">
                                    </select>
                                    <select class="materialGroup" name="productHierarchy3" id="select5">
                                    </select>
                            </div>
                            <div class="tab-pane fade" id="nav-weightsAndDimensions" role="tabpanel" aria-labelledby="nav-weightsAndDimensions-tab">
                                <label for="grossWeight">Gross Weight (Kg): </label><br>
                                <input type="number" step="0.001" value="0.034" name="grossWeight" id="grossWeight" required><br>
                                <label for="length">Length (M): </label><br>
                                <input type="number" step="0.001" value="0.034" name="length" id="length" required><br>
                                <label for="width">Width (M): </label><br>
                                <input type="number" step="0.001" value="0.034" name="width" id="width" required><br>
                                <label for="height">Height (M): </label><br>
                                <input type="number" step="0.001" value="0.034" name="height" id="height" required><br>
                                <label for="volume">Volume (M<sup>³</sup>): </label><br>
                                <input type="number" step="0.001" value="0.034" name="volume" id="volume" required><br>
                            </div>
                            <div class="tab-pane fade" id="nav-technicalData" role="tabpanel" aria-labelledby="nav-technicalData-tab">
                                <label>Capacity Unit of Measure: </label><br>
                                    <select class="capacityUnitOfMeasure" name="capacityUnitOfMeasure">
                                        <option value="1">Wh</option>
                                        <option value="2">kWh</option>
                                        <option value="3">eV</option>
                                        <option value="4">cal</option>
                                    </select>
                                <br>
                                <label>Inverter: </label><br>
                                    <select class="inverter" name="inverter">
                                        <option value="1">N</option>
                                        <option value="2">Y</option>
                                    </select>
                                <br>

                                <label>Power Supply: </label><br>
                                    <select class="powerSupply" name="powerSupply">
                                        <option value="1">+12V1</option>
                                        <option value="2">+12V2</option>
                                        <option value="3">+3,3V</option>
                                        <option value="4">+5V</option>
                                        <option value="5">-12V</option>
                                        <option value="6">+5Vsb</option>
                                        <option value="7">-5V</option>
                                        <option value="8">V1</option>
                                        <option value="9">V1.5</option>
                                    </select>
                                <br>

                                <label>CE-mark: </label><br>
                                    <select class="ceMark" name="ceMark">
                                        <option value="1">Y</option>
                                        <option value="2">N</option>
                                        <option value="3">N/A</option>
                                    </select>
                                <br>

                                <label>Application: </label><br>
                                    <select class="application" name="application">
                                        <option value="1">Food processing, preservation and distribution</option>
                                        <option value="2">Chemical and process industries</option>
                                        <option value="3">Special Applications such as cold treatment of metals, medical, construction etc.</option>
                                        <option value="4">Comfort air-conditioning</option>
                                        <option value="5">Industrial, such as in textiles, manufacturing, photographic, computer rooms etc.</option>
                                        <option value="6">Comfort – commercial, residential etc.</option>
                                    </select>
                                <br>

                                <label>Mode: </label><br>
                                    <select class="mode" name="mode">
                                        <option value="1">Normal Mode</option>
                                        <option value="2">Extra Fridge Mode</option>
                                        <option value="3">Seasonal Mode</option>
                                        <option value="4">Vacation Mode</option>
                                        <option value="5">Home Alone Mode</option>
                                    </select>
                                <br>

                                <label>Refrigerant: </label><br>
                                    <select class="refrigerant" name="refrigerant">
                                        <option value="1">CFCs-R11</option>
                                        <option value="2">CFCs-R12</option>
                                        <option value="3">CFCs-R13</option>
                                        <option value="4">CFCs-R14</option>
                                        <option value="5">CFCs-R15</option>
                                        <option value="6">HCFCs–R22</option>
                                        <option value="7">HCFCs–R123</option>
                                        <option value="8">HFCs-R134a</option>
                                        <option value="9">HFCs-R404a</option>
                                        <option value="10">HFCs-R407C</option>
                                        <option value="11">HFCs-R410a</option>
                                    </select>
                                <br>

                                <label for="refrigerantWeight">Refrigerant Weight (Kg):</label><br>
                                <input type="number" step="0.001" value="0.034" id="refrigerantWeight" name="refrigerantWeight"><br>

                                <label for="frequency">Frequency:<br></label><br>
                                <input type="number" step="0.001" value="0.034" id="frequency" name="frequency"><br>

                                <label>Compressor type: </label><br>
                                    <select class="compressorType" name="compressorType">
                                        <option value="1">Piston compressors</option>
                                        <option value="2">Vane compressors</option>
                                        <option value="3">Scroll compressors</option>
                                        <option value="4">N/A</option>
                                    </select>
                                <br>

                            </div>
                            <div class="tab-pane fade" id="nav-logisticData" role="tabpanel" aria-labelledby="nav-logisticData-tab">
                                <label>Packing style: </label><br>
                                    <select class="packingStyle" name="packingStyle">
                                        <option value="1">Canada</option>
                                        <option value="2">Hungary</option>
                                        <option value="3">Poland</option>
                                        <option value="4">Great Britain</option>
                                        <option value="5">Germany</option>
                                        <option value="6">Slovakia</option>
                                        <option value="7">Slovenia</option>
                                        <option value="8">Turkey</option>
                                        <option value="9">Belgium</option>
                                        <option value="10">Italy</option>
                                    </select>
                                <br>
                                <label>Sales OEM Product: </label><br>
                                    <select class="salesOemProduct" name="salesOemProduct">
                                        <option value="1">Yes</option>
                                        <option value="2">No</option>
                                        <option value="3">N/A</option>
                                    </select>
                                <br>
                                <label>Buy OEM Product: </label><br>
                                    <select class="buyOemProduct" name="buyOemProduct">
                                        <option value="1">Yes</option>
                                        <option value="2">No</option>
                                        <option value="3">N/A</option>
                                    </select>
                                <br>
                                <label>Indoor / Outdoor: </label><br>
                                    <select class="indoorOutdoor" name="indoorOutdoor">
                                        <option value="1">Yes</option>
                                        <option value="2">No</option>
                                        <option value="3">N/A</option>
                                    </select>
                                <br>
                                <label>DG Indicator Profile: </label><br>
                                    <select class="dgIndicatorProfile" name="dgIndicatorProfile">
                                        <option value="1">Relevant for dangerous goods</option>
                                        <option value="2">Relevant for dangerous goods and documents</option>
                                        <option value="3">Relevant for dangerous goods and checks</option>
                                        <option value="4">Relevant for dangerous goods, checks, and documents</option>
                                        <option value="5">N/A</option>
                                    </select>
                                <br>
                                <label for="salesBrand">Sales Brand: </label><br>
                                <input type="text" name="salesBrand" id="salesBrand" required><br>
                                <label>Business Pilar: </label><br>
                                    <select class="businessPilar" name="businessPilar">
                                        <option value="1">N/A</option>
                                        <option value="2">Applied</option>
                                        <option value="3">Not-Applied</option>
                                    </select>
                                <br>
                                <label>Source / Country of Origin: </label><br>
                                    <select class="sourceCountryOfOrg" name="sourceCountryOfOrg">
                                        <option value="TR">Turkey</option>
                                        <option value="PL">Poland</option>
                                        <option value="HU">Hungary</option>
                                        <option value="GB">Great Britain</option>
                                        <option value="CR">Croatia</option>
                                        <option value="SK">Slovakia</option>
                                    </select>
                                <br>
                                <label for="factory">Factory: </label><br>
                                <input type="text" name="factory" id="factory" required><br>
                                <label>Destination Market: </label><br>
                                    <div class="p-1 container custom-control custom-checkbox">
                                        <input type="checkbox" name="destMarket" value="AT">AT
                                        <input type="checkbox" name="destMarket" value="BE">BE
                                        <input type="checkbox" name="destMarket" value="BG">BG
                                        <input type="checkbox" name="destMarket" value="CH">CH
                                        <input type="checkbox" name="destMarket" value="CY">CY
                                        <input type="checkbox" name="destMarket" value="CZ">CZ<br>
                                        <input type="checkbox" name="destMarket" value="DE">DE
                                        <input type="checkbox" name="destMarket" value="DK">DK
                                        <input type="checkbox" name="destMarket" value="EE">EE
                                        <input type="checkbox" name="destMarket" value="ES">ES
                                        <input type="checkbox" name="destMarket" value="FI">FI
                                        <input type="checkbox" name="destMarket" value="FR">FR<br>
                                        <input type="checkbox" name="destMarket" value="GR">GR
                                        <input type="checkbox" name="destMarket" value="HR">HR
                                        <input type="checkbox" name="destMarket" value="HU">HU
                                        <input type="checkbox" name="destMarket" value="IE">IE
                                        <input type="checkbox" name="destMarket" value="IS">IS
                                        <input type="checkbox" name="destMarket" value="IT">IT<br>
                                        <input type="checkbox" name="destMarket" value="LI">LI
                                        <input type="checkbox" name="destMarket" value="LT">LT
                                        <input type="checkbox" name="destMarket" value="LU">LU
                                        <input type="checkbox" name="destMarket" value="LV">LV
                                        <input type="checkbox" name="destMarket" value="MT">MT
                                        <input type="checkbox" name="destMarket" value="NL">NL<br>
                                        <input type="checkbox" name="destMarket" value="NO">NO
                                        <input type="checkbox" name="destMarket" value="PL">PL
                                        <input type="checkbox" name="destMarket" value="PT">PT
                                        <input type="checkbox" name="destMarket" value="RO">RO
                                        <input type="checkbox" name="destMarket" value="SE">SE
                                        <input type="checkbox" name="destMarket" value="SI">SI<br>
                                        <input type="checkbox" name="destMarket" value="SK">SK
                                        <input type="checkbox" name="destMarket" value="UK">UK
                                        <input type="checkbox" name="destMarket" value="AL">AL
                                        <input type="checkbox" name="destMarket" value="BA">BA
                                        <input type="checkbox" name="destMarket" value="MD">MD
                                        <input type="checkbox" name="destMarket" value="ME">ME<br>
                                        <input type="checkbox" name="destMarket" value="MK">MK
                                        <input type="checkbox" name="destMarket" value="RS">RS
                                        <input type="checkbox" name="destMarket" value="AM">AM
                                        <input type="checkbox" name="destMarket" value="AZ">AZ
                                        <input type="checkbox" name="destMarket" value="GE">GE
                                        <input type="checkbox" name="destMarket" value="KG">KG<br>
                                        <input type="checkbox" name="destMarket" value="KA">KZ
                                        <input type="checkbox" name="destMarket" value="TM">TM
                                        <input type="checkbox" name="destMarket" value="TR">TR
                                        <input type="checkbox" name="destMarket" value="UZ">UZ
                                        <input type="checkbox" name="destMarket" value="BY">BY
                                        <input type="checkbox" name="destMarket" value="RU">RU<br>
                                        <input type="checkbox" name="destMarket" value="TJ">TJ
                                        <input type="checkbox" name="destMarket" value="UA">UA
                                    </div>
                                <br>
                                <label>MRP Type: </label><br>
                                    <select class="mrpType" name="mrpType">
                                        <option value="ND">No Planning</option>
                                        <option value="PD">MRP</option>
                                        <option value="R1">Time-phased planning</option>
                                        <option value="VB">Manual reorder point planning</option>
                                        <option value="VM">Automatic reorder point planning</option>
                                        <option value="VV">Forecast-based planning</option>
                                    </select>
                                <br>
                                <label>SNP Planner: </label><br>
                                    <select class="snpPlanner" name="snpPlanner">
                                        <option value="APO-DP">Demand Planning</option>
                                        <option value="APO-SNP">Supply Network Planning</option>
                                        <option value="APO-SDM">Supply and Demand Matching</option>
                                        <option value="APO-PPDS">Production Planning and Detailed Scheduling</option>
                                        <option value="APO-GATP">Global Available-to-Promise</option>
                                        <option value="APO-TPVS">Transportation Planning and Vehicle Scheduling</option>
                                    </select><br>
                                <input type="submit" class="m-1 btn btn-warning" value="save" name="save">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="m-5 col">
                <div class="container p-4">
                    <form action="Materials" method="post">
                        <fieldset>
                            <div class="table-responsive text-nowrap">
                                <table class="table table-striped table-dark">
                                    <thead>
                                    <tr>
                                        <th scope="col">Material Name</th>
                                        <th scope="col">Product Number</th>
                                        <th scope="col">Employee ID</th>
                                        <th scope="col">Requested Date</th>
                                        <th scope="col">Request Subtype</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="mat" items="${materialList}">
                                        <tr>
                                            <th scope="row">
                                                <c:out value="${mat.getMaterialData().getMaterialName()}" />
                                            </th>
                                            <td>
                                                <c:out value="${mat.getMaterialData().getProductNumber()}" />
                                            </td>
                                            <td>
                                                <c:out value="${mat.getGeneralData().getEmployeeID()}" />
                                            </td>
                                            <td>
                                                <c:out value="${mat.getGeneralData().getRequestDateTime()}" />
                                            </td>
                                            <td>
                                                <c:out value="${mat.getGeneralData().getRequestSubType()}" />
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <input type="submit" class="m-1 btn btn-success" id="sendMaterial" value="send" name="send">
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
<script type="text/javascript" src='javaScript/userFormMaterial.js'></script>
</html>