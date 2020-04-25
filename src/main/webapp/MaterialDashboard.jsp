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
                                        <option value="1">Y</option>
                                        <option value="2">N</option>
                                        <option value="3">N/A</option>
                                    </select>
                                </label><br>

                                <label>Application:<br>
                                    <select class="application" name="application">
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                        <option value="4">4</option>
                                        <option value="5">5</option>
                                        <option value="6">6</option>
                                        <option value="7">7</option>
                                        <option value="8">8</option>
                                        <option value="9">9</option>
                                        <option value="10">10</option>
                                        <option value="11">11</option>
                                        <option value="12">12</option>
                                        <option value="13">13</option>
                                        <option value="14">14</option>
                                        <option value="15">15</option>
                                        <option value="16">16</option>
                                        <option value="17">17</option>
                                        <option value="18">18</option>
                                        <option value="19">19</option>
                                        <option value="20">20</option>
                                        <option value="21">21</option>
                                        <option value="22">22</option>
                                        <option value="23">23</option>
                                        <option value="24">24</option>
                                        <option value="25">25</option>
                                        <option value="26">26</option>
                                        <option value="27">27</option>
                                        <option value="28">28</option>
                                        <option value="29">29</option>
                                        <option value="30">30</option>
                                        <option value="31">31</option>
                                        <option value="32">32</option>
                                        <option value="33">33</option>
                                        <option value="34">34</option>
                                        <option value="35">35</option>
                                        <option value="36">36</option>
                                        <option value="37">37</option>
                                        <option value="38">38</option>
                                        <option value="39">39</option>
                                        <option value="40">40</option>
                                        <option value="41">41</option>
                                        <option value="42">42</option>
                                        <option value="43">43</option>
                                        <option value="44">44</option>
                                        <option value="45">45</option>
                                        <option value="46">46</option>
                                        <option value="47">47</option>
                                        <option value="48">48</option>
                                        <option value="49">49</option>
                                        <option value="50">50</option>
                                        <option value="51">51</option>
                                        <option value="52">52</option>
                                        <option value="53">53</option>
                                        <option value="54">54</option>
                                        <option value="55">55</option>
                                        <option value="56">56</option>
                                        <option value="57">57</option>
                                        <option value="58">58</option>
                                        <option value="59">59</option>
                                        <option value="60">60</option>
                                        <option value="61">61</option>
                                        <option value="62">62</option>
                                        <option value="63">63</option>
                                        <option value="64">64</option>
                                        <option value="65">65</option>
                                        <option value="66">66</option>
                                        <option value="67">67</option>
                                        <option value="68">68</option>
                                        <option value="69">69</option>
                                        <option value="70">70</option>
                                        <option value="71">71</option>
                                        <option value="72">72</option>
                                        <option value="73">73</option>
                                        <option value="74">74</option>
                                        <option value="75">75</option>
                                        <option value="76">76</option>
                                        <option value="77">77</option>
                                        <option value="78">78</option>
                                        <option value="79">79</option>
                                        <option value="80">80</option>
                                        <option value="81">81</option>
                                        <option value="82">82</option>
                                        <option value="83">83</option>
                                        <option value="84">84</option>
                                        <option value="85">85</option>
                                        <option value="86">86</option>
                                        <option value="87">87</option>
                                        <option value="88">88</option>
                                        <option value="89">89</option>
                                        <option value="90">90</option>
                                        <option value="91">91</option>
                                        <option value="92">92</option>
                                        <option value="93">93</option>
                                        <option value="94">94</option>
                                        <option value="95">95</option>
                                        <option value="96">96</option>
                                        <option value="97">97</option>
                                        <option value="98">98</option>
                                        <option value="99">99</option>
                                        <option value="100">100</option>
                                        <option value="101">101</option>
                                        <option value="102">102</option>
                                        <option value="103">103</option>
                                        <option value="104">104</option>
                                        <option value="105">105</option>
                                        <option value="106">106</option>
                                        <option value="107">107</option>
                                        <option value="108">108</option>
                                        <option value="109">109</option>
                                        <option value="110">110</option>
                                        <option value="111">111</option>
                                        <option value="112">112</option>
                                        <option value="113">113</option>
                                        <option value="114">114</option>
                                        <option value="115">115</option>
                                        <option value="116">116</option>
                                        <option value="117">117</option>
                                        <option value="118">118</option>
                                        <option value="119">119</option>
                                        <option value="120">120</option>
                                        <option value="121">121</option>
                                        <option value="122">122</option>
                                        <option value="123">123</option>
                                        <option value="124">124</option>
                                        <option value="125">125</option>
                                        <option value="126">126</option>
                                        <option value="127">127</option>
                                        <option value="128">128</option>
                                        <option value="129">129</option>
                                        <option value="130">130</option>
                                        <option value="131">131</option>
                                        <option value="132">132</option>
                                        <option value="133">133</option>
                                        <option value="134">134</option>
                                        <option value="135">135</option>
                                        <option value="136">136</option>
                                        <option value="137">137</option>
                                        <option value="138">138</option>
                                        <option value="139">139</option>
                                        <option value="140">140</option>
                                        <option value="141">141</option>
                                        <option value="142">142</option>
                                        <option value="143">143</option>
                                        <option value="144">144</option>
                                        <option value="145">145</option>
                                        <option value="146">146</option>
                                        <option value="147">147</option>
                                        <option value="148">148</option>
                                        <option value="149">149</option>
                                    </select>
                                </label><br>

                                <label>Mode:<br>
                                    <select class="mode" name="mode">
                                        <option value="1">001</option>
                                        <option value="2">002</option>
                                        <option value="3">003</option>
                                        <option value="4">004</option>
                                        <option value="5">005</option>
                                        <option value="6">006</option>
                                        <option value="7">007</option>
                                        <option value="8">008</option>
                                        <option value="9">009</option>
                                        <option value="10">010</option>
                                        <option value="11">011</option>
                                        <option value="12">012</option>
                                        <option value="13">013</option>
                                        <option value="14">014</option>
                                        <option value="15">015</option>
                                        <option value="16">016</option>
                                        <option value="17">017</option>
                                        <option value="18">018</option>
                                        <option value="19">019</option>
                                        <option value="20">020</option>
                                        <option value="21">021</option>
                                        <option value="22">022</option>
                                        <option value="23">023</option>
                                        <option value="24">024</option>
                                        <option value="25">025</option>
                                    </select>
                                </label><br>
                                <label>Refrigerant: <br>
                                    <select class="refrigerant" name="refrigerant">
                                        <option value="1">CFCs - R11</option>
                                        <option value="2">CFCs - R12</option>
                                        <option value="3">CFCs - R13</option>
                                        <option value="4">CFCs - R14</option>
                                        <option value="5">CFCs - R15</option>
                                        <option value="6">HCFCs – R22</option>
                                        <option value="7">HCFCs – R123</option>
                                        <option value="8">HFCs - R134a</option>
                                        <option value="9">HFCs - R404a</option>
                                        <option value="10">HFCs - R407C</option>
                                        <option value="11">HFCs - R410a</option>
                                    </select>
                                </label><br>

                                <label for="refrigerantWeight">Refrigerant Weight (Kg):</label><br>
                                <input type="number" step="0.001" id="refrigerantWeight" name="refrigerantWeight"><br>
                                <label for="frequency">Frequency:<br></label><br>
                                <input type="number" step="0.01" id="frequency" name="frequency"><br>
                                <label>Compressor type:<br>
                                    <select class="refrigerant" name="refrigerant">
                                        <option value="1">N/A</option>
                                        <option value="2">Piston compressors</option>
                                        <option value="3">Vane compressors</option>
                                        <option value="4">Scroll compressors</option>
                                    </select>
                                </label><br>
                                <!--
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