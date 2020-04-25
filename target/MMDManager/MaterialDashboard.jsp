<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<html>

<head>
    <title>Material Master Data Manager</title>
    <meta charset="ISO-8859-1">
    <link rel="stylesheet" href="css/userDashStyle.css">
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
    <h2 class="m-0 p-2 navbar-brand"><b class="text-light">user<span class="main-color">Login</span> - Material Creation</b></h2>
</header>
<nav class="m-0 p-2 navbar">
    <form action="UserLogout" method="get">
        <fieldset>
            <ul class="m-0 p-0 navbar d-flex">
                <li class="m-1 p-1 nav-item"><button type="submit" class="p-1 btn btn-secondary">Log Out</button></li>
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
                                <input type="text" name="employeeID" id="employeeID" readonly><br>
                                <hr>
                                <label for="requestNo">Request Number: </label><br>
                                <input type="text" name="requestNo" id="requestNo" readonly><br>
                                <label for="requestedBy">Requested By: </label><br>
                                <input type="text" name="requestedBy" id="requestedBy" readonly><br>
                                <label for="requestDate">Request Date: </label><br>
                                <input type="text" name="requestDate" id="requestDate" readonly><br>
                                <label for="requestTime">Request Time: </label><br>
                                <input type="text" name="requestTime" id="requestTime" readonly><br>
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
                                <input type="text" name="productNumber" id="productNumber" required><br>
                                <label for="materialName">Material Name: </label><br>
                                <input type="text" name="materialName" id="materialName" required><br>
                                <label for="remark">Remark: </label><br>
                                <textarea name="remark" id="remark" rows="3" cols="30"></textarea><br>
                                <label>Batch:<br>
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
                                </label>
                                <br>
                                <label>Material Group:<br>
                                    <select class="materialGroup" name="firstLevelMG" id="select1">
                                        <option value="210 - HOUSEHOLD">210 - HOUSEHOLD</option>
                                    </select>
                                    <select class="materialGroup" name="secondLevelMG" id="select2">
                                    </select>
                                </label></br>
                                <label>Product Hierarchy:<br>
                                    <select class="materialGroup" name="productHierarchy1" id="select3">
                                    </select>
                                    <select class="materialGroup" name="productHierarchy2" id="select4">
                                    </select>
                                    <select class="materialGroup" name="productHierarchy3" id="select5">
                                    </select>
                                </label>
                            </div>
                            <div class="tab-pane fade" id="nav-weightsAndDimensions" role="tabpanel" aria-labelledby="nav-weightsAndDimensions-tab">
                                <label for="grossWeight">Gross Weight (Kg): </label><br>
                                <input type="number" step="0.001" name="grossWeight" id="grossWeight" required><br>
                                <label for="length">Length (M): </label><br>
                                <input type="number" step="0.001" name="length" id="length" required><br>
                                <label for="width">Width (M): </label><br>
                                <input type="number" step="0.001" name="width" id="width" required><br>
                                <label for="height">Height (M): </label><br>
                                <input type="number" step="0.001" name="height" id="height" required><br>
                                <label for="volume">Volume (M<sup>³</sup>): </label><br>
                                <input type="number" step="0.001" name="volume" id="volume" required><br>
                                <!--
                            </div>
                            <div class="tab-pane fade" id="nav-technicalData" role="tabpanel" aria-labelledby="nav-technicalData-tab">
                                <label>Capacity Unit of Measure:<br>
                                    <select class="capacityUnitOfMeasure" name="capacityUnitOfMeasure">
                                        <option value="1">Wh</option>
                                        <option value="2">kWh</option>
                                        <option value="3">eV</option>
                                        <option value="4">cal</option>
                                    </select>
                                </label><br>
                                <label>Inverter:<br>
                                    <select class="inverter" name="inverter">
                                        <option value="1">N</option>
                                        <option value="2">Y</option>
                                    </select>
                                </label><br>

                                <label>Power Supply:<br>
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
                                </label><br>

                                <label>CE-mark:<br>
                                    <select class="ceMark" name="ceMark">
                                        <option value="1">YY</option>
                                        <option value="2">N/A</option>
                                    </select>
                                </label><br>

                                <label>Application:<br>
                                    <select class="application" name="application">
                                        <option>001</option>
                                        <option>002</option>
                                        <option>003</option>
                                        <option>004</option>
                                        <option>005</option>
                                        <option>006</option>
                                        <option>007</option>
                                        <option>008</option>
                                        <option>009</option>
                                        <option>010</option>
                                        <option>011</option>
                                        <option>012</option>
                                        <option>013</option>
                                        <option>014</option>
                                        <option>015</option>
                                        <option>016</option>
                                        <option>017</option>
                                        <option>018</option>
                                        <option>019</option>
                                        <option>020</option>
                                        <option>021</option>
                                        <option>022</option>
                                        <option>023</option>
                                        <option>024</option>
                                        <option>025</option>
                                        <option>026</option>
                                        <option>027</option>
                                        <option>028</option>
                                        <option>029</option>
                                        <option>030</option>
                                        <option>031</option>
                                        <option>032</option>
                                        <option>033</option>
                                        <option>034</option>
                                        <option>035</option>
                                        <option>036</option>
                                        <option>037</option>
                                        <option>038</option>
                                        <option>039</option>
                                        <option>040</option>
                                        <option>041</option>
                                        <option>042</option>
                                        <option>043</option>
                                        <option>044</option>
                                        <option>045</option>
                                        <option>046</option>
                                        <option>047</option>
                                        <option>048</option>
                                        <option>049</option>
                                        <option>050</option>
                                        <option>051</option>
                                        <option>052</option>
                                        <option>053</option>
                                        <option>054</option>
                                        <option>055</option>
                                        <option>056</option>
                                        <option>057</option>
                                        <option>058</option>
                                        <option>059</option>
                                        <option>060</option>
                                        <option>061</option>
                                        <option>062</option>
                                        <option>063</option>
                                        <option>064</option>
                                        <option>065</option>
                                        <option>066</option>
                                        <option>067</option>
                                        <option>068</option>
                                        <option>069</option>
                                        <option>070</option>
                                        <option>071</option>
                                        <option>072</option>
                                        <option>073</option>
                                        <option>074</option>
                                        <option>075</option>
                                        <option>076</option>
                                        <option>077</option>
                                        <option>078</option>
                                        <option>079</option>
                                        <option>080</option>
                                        <option>081</option>
                                        <option>082</option>
                                        <option>083</option>
                                        <option>084</option>
                                        <option>085</option>
                                        <option>086</option>
                                        <option>087</option>
                                        <option>088</option>
                                        <option>089</option>
                                        <option>090</option>
                                        <option>091</option>
                                        <option>092</option>
                                        <option>093</option>
                                        <option>094</option>
                                        <option>095</option>
                                        <option>096</option>
                                        <option>097</option>
                                        <option>098</option>
                                        <option>099</option>
                                        <option>100</option>
                                        <option>101</option>
                                        <option>102</option>
                                        <option>103</option>
                                        <option>104</option>
                                        <option>105</option>
                                        <option>106</option>
                                        <option>107</option>
                                        <option>108</option>
                                        <option>109</option>
                                        <option>110</option>
                                        <option>111</option>
                                        <option>112</option>
                                        <option>113</option>
                                        <option>114</option>
                                        <option>115</option>
                                        <option>116</option>
                                        <option>117</option>
                                        <option>118</option>
                                        <option>119</option>
                                        <option>120</option>
                                        <option>121</option>
                                        <option>122</option>
                                        <option>123</option>
                                        <option>124</option>
                                        <option>125</option>
                                        <option>126</option>
                                        <option>127</option>
                                        <option>128</option>
                                        <option>129</option>
                                        <option>130</option>
                                        <option>131</option>
                                        <option>132</option>
                                        <option>133</option>
                                        <option>134</option>
                                        <option>135</option>
                                        <option>136</option>
                                        <option>137</option>
                                        <option>138</option>
                                        <option>139</option>
                                        <option>140</option>
                                        <option>141</option>
                                        <option>142</option>
                                        <option>143</option>
                                        <option>144</option>
                                        <option>145</option>
                                        <option>146</option>
                                        <option>147</option>
                                        <option>148</option>
                                        <option>149</option>
                                    </select>
                                </label><br>

                                <label>Mode:<br>
                                    <select class="mode" name="mode">
                                        <option>001</option>
                                        <option>002</option>
                                        <option>003</option>
                                        <option>004</option>
                                        <option>005</option>
                                        <option>006</option>
                                        <option>007</option>
                                        <option>008</option>
                                        <option>009</option>
                                        <option>010</option>
                                        <option>011</option>
                                        <option>012</option>
                                        <option>013</option>
                                        <option>014</option>
                                        <option>015</option>
                                        <option>016</option>
                                        <option>017</option>
                                        <option>018</option>
                                        <option>019</option>
                                        <option>020</option>
                                        <option>021</option>
                                        <option>022</option>
                                        <option>023</option>
                                        <option>024</option>
                                        <option>025</option>
                                    </select>
                                </label><br>

                                <label>Refrigerant: <br>
                                    <select class="refrigerant" name="refrigerant">
                                        <option>001</option>
                                        <option>002</option>
                                        <option>003</option>
                                        <option>004</option>
                                        <option>005</option>
                                        <option>006</option>
                                        <option>007</option>
                                        <option>008</option>
                                    </select>
                                </label><br>

                                <label for="refrigerantWeight">Refrigerant Weight (Kg):</label><br>
                                <input type="number" step="0.001" id="refrigerantWeight" name="refrigerantWeight"><br>
                                <label for="frequency">Frequency:<br></label><br>
                                <input type="number" step="0.01" id="frequency" name="frequency"><br>
                                <label>Compressor type:<br>
                                    <select class="refrigerant" name="refrigerant">
                                        <option>000 - NA</option>
                                        <option>001 - Piston compressors</option>
                                        <option>002 - Vane compressors</option>
                                        <option>003 - Scroll compressors</option>
                                    </select>
                                </label><br>
                            </div>
                            <div class="tab-pane fade" id="nav-logisticData" role="tabpanel" aria-labelledby="nav-logisticData-tab">
                                <label>Packing style: <br>
                                    <select class="packingStyle" name="packingStyle">
                                        <option value="1">CA - Canada</option>
                                        <option value="2">HU - Hungary</option>
                                        <option value="3">PL - Poland</option>
                                        <option value="4">GB - Great Britain</option>
                                        <option value="5">DE - Germany</option>
                                        <option value="6">SK - Slovakia</option>
                                        <option value="7">SN - Slovenia</option>
                                        <option value="8">TR - Turkey</option>
                                        <option value="9">BE - Belgium</option>
                                    </select>
                                </label><br>
                                <label>Sales OEM Product: <br>
                                    <select class="salesOemProduct" name="salesOemProduct">
                                        <option value="1">Yes</option>
                                        <option value="2">No</option>
                                        <option value="3">N/A</option>
                                    </select>
                                </label><br>
                                <label>Buy OEM Product: <br>
                                    <select class="buyOemProduct" name="buyOemProduct">
                                        <option value="1">Yes</option>
                                        <option value="2">No</option>
                                        <option value="3">N/A</option>
                                    </select>
                                </label><br>
                                <label>Indoor / Outdoor: <br>
                                    <select class="indoorOutdoor" name="indoorOutdoor">
                                        <option value="1">Yes</option>
                                        <option value="2">No</option>
                                        <option value="3">N\A</option>
                                    </select>
                                </label><br>
                                <label>DG Indicator Profile:<br>
                                    <select class="dgIndicatorProfile" name="dgIndicatorProfile">
                                        <option value="1">000 - NA</option>
                                        <option value="2">001 - Relevant for dangerous goods</option>
                                        <option value="3">002 - Relevant for dangerous goods and documents</option>
                                        <option value="2">003 - Relevant for dangerous goods and checks</option>
                                        <option value="3">004 - Relevant for dangerous goods, checks, and documents</option>
                                    </select>
                                </label><br>
                                <label for="salesBrand">Sales Brand: </label><br>
                                <input type="text" name="salesBrand" id="salesBrand" required><br>
                                <label>Business Pilar: <br>
                                    <select class="businessPilar" name="businessPilar">
                                        <option value="1">NA</option>
                                        <option value="2">Applied</option>
                                        <option value="3">Not-Applied</option>
                                    </select>
                                </label><br>
                                <label>Source: <br>
                                    <select class="source" name="source">
                                        <option value="1">TR</option>
                                        <option value="2">PL</option>
                                        <option value="3">HU</option>
                                        <option value="4">GB</option>
                                        <option value="5">CR</option>
                                        <option value="6">SK</option>
                                    </select>
                                </label><br>
                                <label for="factory">Factory: </label><br>
                                <input type="text" name="factory" id="factory" required><br>
                                <label>Destination Market: <br>
                                    <input type="checkbox" name="at" value="at">AT
                                    <input type="checkbox" name="be" value="be">BE
                                    <input type="checkbox" name="bg" value="bg">BG
                                    <input type="checkbox" name="ch" value="ch">CH
                                    <input type="checkbox" name="cy" value="cy">CY
                                    <input type="checkbox" name="cz" value="cz">CZ<br>
                                    <input type="checkbox" name="de" value="de">DE
                                    <input type="checkbox" name="dk" value="dk">DK
                                    <input type="checkbox" name="ee" value="ee">EE
                                    <input type="checkbox" name="es" value="es">ES
                                    <input type="checkbox" name="fi" value="fi">FI
                                    <input type="checkbox" name="fr" value="fr">FR<br>
                                    <input type="checkbox" name="gr" value="gr">GR
                                    <input type="checkbox" name="hr" value="hr">HR
                                    <input type="checkbox" name="hu" value="hu">HU
                                    <input type="checkbox" name="ie" value="ie">IE
                                    <input type="checkbox" name="is" value="is">IS
                                    <input type="checkbox" name="it" value="it">IT<br>
                                    <input type="checkbox" name="li" value="li">LI
                                    <input type="checkbox" name="lt" value="lt">LT
                                    <input type="checkbox" name="lu" value="lu">LU
                                    <input type="checkbox" name="lv" value="lv">LV
                                    <input type="checkbox" name="mt" value="mt">MT
                                    <input type="checkbox" name="nl" value="nl">NL<br>
                                    <input type="checkbox" name="no" value="no">NO
                                    <input type="checkbox" name="pl" value="pl">PL
                                    <input type="checkbox" name="pt" value="pt">PT
                                    <input type="checkbox" name="ro" value="ro">RO
                                    <input type="checkbox" name="se" value="se">SE
                                    <input type="checkbox" name="si" value="si">SI<br>
                                    <input type="checkbox" name="sk" value="sk">SK
                                    <input type="checkbox" name="uk" value="uk">UK
                                    <input type="checkbox" name="al" value="al">AL
                                    <input type="checkbox" name="ba" value="ba">BA
                                    <input type="checkbox" name="md" value="md">MD
                                    <input type="checkbox" name="me" value="me">ME<br>
                                    <input type="checkbox" name="mk" value="mk">MK
                                    <input type="checkbox" name="rs" value="rs">RS
                                    <input type="checkbox" name="am" value="am">AM
                                    <input type="checkbox" name="az" value="az">AZ
                                    <input type="checkbox" name="ge" value="ge">GE
                                    <input type="checkbox" name="kg" value="kg">KG<br>
                                    <input type="checkbox" name="kz" value="kz">KZ
                                    <input type="checkbox" name="tm" value="tm">TM
                                    <input type="checkbox" name="tr" value="tr">TR
                                    <input type="checkbox" name="uz" value="uz">UZ
                                    <input type="checkbox" name="by" value="by">BY
                                    <input type="checkbox" name="ru" value="ru">RU<br>
                                    <input type="checkbox" name="tj" value="tj">TJ
                                    <input type="checkbox" name="ua" value="ua">UA
                                </label>-->
                                <input type="submit" value="save" name="save">
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
                                        <th scope="col">Requested By</th>
                                        <th scope="col">Employee ID</th>
                                        <th scope="col">Requested Date</th>
                                        <th scope="col">Request Subtype</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="material" items="${materialList}">
                                        <tr>
                                            <th scope="row">
                                                <c:out value="${material.getMaterialName()}" />
                                            </th>
                                            <td>
                                                <c:out value="${material.getProductNumber()}" />
                                            </td>
                                            <td>
                                                <c:out value="${material.getRequestedBy()}" />
                                            </td>
                                            <td>
                                                <c:out value="${material.getEmployeeID()}" />
                                            </td>
                                            <td>
                                                <c:out value="${material.getRequestDateTime()}" />
                                            </td>
                                            <td>
                                                <c:out value="${material.getRequestSubType()}" />
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <input type="submit" value="send" name="send">
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src='javaScript/userFormMaterial.js'></script>
</html>