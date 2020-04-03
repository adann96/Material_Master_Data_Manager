document.getElementById("requestTypeSelection").selectedIndex = -1;
document.getElementById("requestSubtypeSelection").selectedIndex = -1;
document.getElementsByClassName("batch")[0].selectedIndex = -1;
document.getElementsByClassName("batch")[1].selectedIndex = -1;
document.getElementsByClassName("materialGroup")[0].selectedIndex = -1;

document.getElementById("button1").addEventListener("click", function(event) {
    openTab(event, "generalData");
});

document.getElementById("button2").addEventListener("click", function(event) {
    openTab(event, "materialData");
});

document.getElementById("button3").addEventListener("click", function(event) {
    openTab(event, "weigthsAndDimensions");
});

document.getElementById("button4").addEventListener("click", function(event) {
    openTab(event, "technicalData");
});

document.getElementById("button5").addEventListener("click", function(event) {
    openTab(event, "logisticsData");
});

function openTab(evt, tabName) {
    var i, tabcontent, tablinks;

    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }

    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
        if (tabName != "generalData") {
            tablinks[0].style.backgroundColor = "#3e405b";
        } else {
            tablinks[0].style.backgroundColor = "#6f6486";
        }
    }
    document.getElementById(tabName).style.display = "block";
    event.currentTarget.className += " active";
}

window.onload = function() {
    var i, tabcontent, tablinks;

    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }

    // Get all elements with class="tablinks" and remove the class "active"
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }

    document.getElementById("generalData").style.display = "block";
    event.currentTarget.className += " active";
    tablinks[0].style.backgroundColor = "#6f6486";
};

const $select1 = $("#select1"),
    $select2 = $("#select2"),
    $options = $select2.find("option");

$select1
    .on("change", function() {
        $select2.html($options.filter('[value="' + this.value + '"]'));
    })
    .trigger("change");

const select1 = document.getElementById("select1");
const select2 = document.getElementById("select2");
const select3 = document.getElementById("select3");
const select4 = document.getElementById("select4");
const select5 = document.getElementById("select5");

const matGroupSecLevel = [
    "001 - SWAC",
    "002 - SC",
    "003 - CU",
    "004 - FCU",
    "005 - CHU",
    "006 - CM",
    "007 - MVOU",
    "008 - MVIU",
    "009 - CACWHSP",
    "010 - WAC",
    "011 - RAC",
    "012 - WAHP",
    "013 - PAC",
    "014 - PD",
    "015 - AF",
    "016 - OAS"
];

select1.addEventListener("change", changeMatGroupSecLevel);

function changeMatGroupSecLevel() {
    if (select1.options[select1.selectedIndex].text == "210 - HOUSEHOLD") {
        select2.options.length = 0;
        select3.options.length = 0;
        select4.options.length = 0;
        select5.options.length = 0;
        for (var i = 0; i <= matGroupSecLevel.length - 1; i++) {
            select2.add(new Option(matGroupSecLevel[i]));
        }
        document.getElementsByClassName("materialGroup")[1].selectedIndex = -1;
    }
}

var matGroupSwac = [
    "001 - SRAY",
    "002 - SVIS",
    "003 - SFP",
    "004 - SSP",
    "005 - SSPP"
];
var matGroupSc = ["001 - SKON"];
var matGroupCu = ["001 - SUSP"];
var matGroupFcu = ["000 - NA"];
var matGroupChu = ["001 - SUSP"];
var matGroupCm = ["001 - CMOD"];
var matGroupMvou = ["001 - SMV", "002 - CHPMS"];
var matGroupMviu = ["001 - SMV"];
var matGroupCacwhsp = ["001 - HSCS"];
var matGroupWac = ["001 - SWIN"];
var matGroupRac = ["000 - NA"];
var matGroupWahp = ["001 - SBOAT"];
var matGroupPac = ["001 - SMOB"];
var matGroupOas = ["001 - WCON", "002 - CCON", "003 - DTFMSU"];

select2.addEventListener("change", changeMatGroup);

function changeMatGroup() {
    if (select2.options[select2.selectedIndex].text == "001 - SWAC") {
        select3.options.length = 0;
        select4.options.length = 0;
        select5.options.length = 0;
        for (var i = 0; i <= matGroupSwac.length - 1; i++) {
            select3.add(new Option(matGroupSwac[i]));
        }
        document.getElementsByClassName("materialGroup")[2].selectedIndex = -1;
    } else if (select2.options[select2.selectedIndex].text == "002 - SC") {
        select3.options.length = 0;
        select4.options.length = 0;
        select5.options.length = 0;
        for (var i = 0; i <= matGroupSc.length - 1; i++) {
            select3.add(new Option(matGroupSc[i]));
        }
        document.getElementsByClassName("materialGroup")[2].selectedIndex = -1;
    } else if (select2.options[select2.selectedIndex].text == "003 - CU") {
        select3.options.length = 0;
        select4.options.length = 0;
        select5.options.length = 0;
        for (var i = 0; i <= matGroupCu.length - 1; i++) {
            select3.add(new Option(matGroupCu[i]));
        }
        document.getElementsByClassName("materialGroup")[2].selectedIndex = -1;
    } else if (select2.options[select2.selectedIndex].text == "004 - FCU") {
        select3.options.length = 0;
        select4.options.length = 0;
        select5.options.length = 0;
        for (var i = 0; i <= matGroupFcu.length - 1; i++) {
            select3.add(new Option(matGroupFcu[i]));
        }
        document.getElementsByClassName("materialGroup")[2].selectedIndex = -1;
    } else if (select2.options[select2.selectedIndex].text == "005 - CHU") {
        select3.options.length = 0;
        select4.options.length = 0;
        select5.options.length = 0;
        for (var i = 0; i <= matGroupChu.length - 1; i++) {
            select3.add(new Option(matGroupChu[i]));
        }
        document.getElementsByClassName("materialGroup")[2].selectedIndex = -1;
    } else if (select2.options[select2.selectedIndex].text == "006 - CM") {
        select3.options.length = 0;
        select4.options.length = 0;
        select5.options.length = 0;
        for (var i = 0; i <= matGroupCm.length - 1; i++) {
            select3.add(new Option(matGroupCm[i]));
        }
        document.getElementsByClassName("materialGroup")[2].selectedIndex = -1;
    } else if (select2.options[select2.selectedIndex].text == "007 - MVOU") {
        select3.options.length = 0;
        select4.options.length = 0;
        select5.options.length = 0;
        for (var i = 0; i <= matGroupMvou.length - 1; i++) {
            select3.add(new Option(matGroupMvou[i]));
        }
        document.getElementsByClassName("materialGroup")[2].selectedIndex = -1;
    } else if (select2.options[select2.selectedIndex].text == "008 - MVIU") {
        select3.options.length = 0;
        select4.options.length = 0;
        select5.options.length = 0;
        for (var i = 0; i <= matGroupMviu.length - 1; i++) {
            select3.add(new Option(matGroupMviu[i]));
        }
        document.getElementsByClassName("materialGroup")[2].selectedIndex = -1;
    } else if (select2.options[select2.selectedIndex].text == "009 - CACWHSP") {
        select3.options.length = 0;
        select4.options.length = 0;
        select5.options.length = 0;
        for (var i = 0; i <= matGroupCacwhsp.length - 1; i++) {
            select3.add(new Option(matGroupCacwhsp[i]));
        }
        document.getElementsByClassName("materialGroup")[2].selectedIndex = -1;
    } else if (select2.options[select2.selectedIndex].text == "010 - WAC") {
        select3.options.length = 0;
        select4.options.length = 0;
        select5.options.length = 0;
        for (var i = 0; i <= matGroupWac.length - 1; i++) {
            select3.add(new Option(matGroupWac[i]));
        }
        document.getElementsByClassName("materialGroup")[2].selectedIndex = -1;
    } else if (select2.options[select2.selectedIndex].text == "011 - RAC") {
        select3.options.length = 0;
        select4.options.length = 0;
        select5.options.length = 0;
        for (var i = 0; i <= matGroupRac.length - 1; i++) {
            select3.add(new Option(matGroupRac[i]));
        }
        document.getElementsByClassName("materialGroup")[2].selectedIndex = -1;
    } else if (select2.options[select2.selectedIndex].text == "012 - WAHP") {
        select3.options.length = 0;
        select4.options.length = 0;
        select5.options.length = 0;
        for (var i = 0; i <= matGroupWahp.length - 1; i++) {
            select3.add(new Option(matGroupWahp[i]));
        }
        document.getElementsByClassName("materialGroup")[2].selectedIndex = -1;
    } else if (
        select2.options[select2.selectedIndex].text == "013 - PAC" ||
        select2.options[select2.selectedIndex].text == "014 - PD" ||
        select2.options[select2.selectedIndex].text == "015 - AF"
    ) {
        select3.options.length = 0;
        select4.options.length = 0;
        select5.options.length = 0;
        for (var i = 0; i <= matGroupPac.length - 1; i++) {
            select3.add(new Option(matGroupPac[i]));
        }
        document.getElementsByClassName("materialGroup")[2].selectedIndex = -1;
    } else if (select2.options[select2.selectedIndex].text == "016 - OAS") {
        select3.options.length = 0;
        select4.options.length = 0;
        select5.options.length = 0;
        for (var i = 0; i <= matGroupOas.length - 1; i++) {
            select3.add(new Option(matGroupOas[i]));
        }
        document.getElementsByClassName("materialGroup")[2].selectedIndex = -1;
    }
}

const prodHierSeriaRay = ["001 - ASH-09BIR", "002 - ASH-12BIR"];
const prodHierSeriaVision = [
    "001 - ASH-09BIV",
    "002 - ASH-12BIV",
    "003 - ASH-18BIV",
    "004 - ASH-24BIV"
];
const prodHierSeriaFocusPlus = [
    "001 - ASH-09BIF2",
    "002 - ASH-13BIF2",
    "003 - ASH-18BIF2",
    "004 - ASH-24BIF2"
];
const prodHierSeriaSpectrum = [
    "001 - ASH-09BIS/W",
    "002 - ASH-13BIS/W",
    "003 - ASH-18BIS/W",
    "004 - ASH-24BIS/W",
    "005 - ASH-09BIS/B",
    "007 - ASH-13BIS/B",
    "008 - ASH-18BIS/B",
    "009 - ASH-24BIS/B"
];
const prodHierSeriaSpectrumPlus = [
    "001 - ASH-09BIS2/W",
    "002 - ASH-13BIS2/W",
    "003 - ASH-18BIS2/W",
    "004 - ASH-24BIS2/W"
];
const prodHierSeriaKonsola = [
    "001 - ASP-09BI",
    "002 - ASP-12BI",
    "003 - ASP-18BI"
];
const prodHierSeriaUniSplit = [
    "001 - ASC-12BI",
    "002 - ASC-18BI",
    "003 - ASC-24BI",
    "004 - ASC-30BI",
    "005 - ASC-36BI",
    "006 - ASC-42BI",
    "007 - ASC-48BI",
    "008 - ASC-60BI"
];
const prodHierNa = [
    "001 - ASF-12BI",
    "002 - ASF-18BI",
    "003 - ASF-24BI",
    "004 - AASF-30BI",
    "005 - ASF-36BI",
    "006 - ASF-42BI",
    "007 - ASF-48BI",
    "008 - ASF-60BI"
];
const prodHierSeriaUniSplit2 = [
    "001 - ASD-12BI",
    "002 - ASD-18BI",
    "003 - ASD-24BI",
    "004 - AASD-30BI",
    "005 - ASD-36BI",
    "006 - ASD-42BI",
    "007 - ASD-48BI",
    "008 - ASD-60BI"
];
const prodHierComMod = ["001 - SCMI-01.4"];
const prodHierSeriaMultiVariable = [
    "001 - MV-E14BI",
    "002 - MV-E18BI",
    "003 - MV-E21BI",
    "004 - MV-E24BI",
    "005 - MV-E28BI",
    "006 - MV-E36BI",
    "007 - MV-E42BI"
];
const prodHierSeriaChpms = ["001 - MS-E48AIN", "002 - MS-E56AIN"];
const prodHierSeriaMultiVariableIu = [
    "001 - WMU",
    "002 - CONS",
    "003 - CASSU",
    "004 - CHU",
    "005 - FCU"
];
const prodHierSeriaHIGHSpringChannel = ["001 - ASDH-96AI"];
const prodHierSeriaWindow = ["001 - ASW-09BI", "002 - ASW-12BI"];
const prodHierRac = ["001 - ASV-25AS", "002 - ASV-35AS"];
const prodHierSeriaBoat = [
    "001 - ASB-05A",
    "002 - ASB-09A",
    "003 - ASB-12A",
    "004 - ASB-16A"
];
const prodHierPac = ["001 - AMC-11P", "002 - AMC-14P"];
const prodHierPdryers = ["001 - CFO-16P", "002 - CFO-20P", "003 - CFO-40P"];
const prodHierAirFilter = ["001 - SP-45A"];
const prodHierOasWc = [
    "001 - SWC-02",
    "002 - SWC-03",
    "003 - SMG-01",
    "004 - SCC-16",
    "005 - SCC-36"
];
const prodHierCentralCon = ["001 - EWPE", "002 - G2S"];
const prodHierDtfmSunit = ["001 - SDT-MV", "002 - SDT-ASH"];

select3.addEventListener("change", changeMatGroup2);

function changeMatGroup2() {
    if (select3.options[select3.selectedIndex].text == "001 - SRAY") {
        select4.options.length = 0;
        select5.options.length = 0;
        for (var i = 0; i <= prodHierSeriaRay.length - 1; i++) {
            select4.add(new Option(prodHierSeriaRay[i]));
        }
        document.getElementsByClassName("materialGroup")[3].selectedIndex = -1;
    } else if (select3.options[select3.selectedIndex].text == "002 - SVIS") {
        select4.options.length = 0;
        select5.options.length = 0;
        for (var i = 0; i <= prodHierSeriaVision.length - 1; i++) {
            select4.add(new Option(prodHierSeriaVision[i]));
        }
        document.getElementsByClassName("materialGroup")[3].selectedIndex = -1;
    } else if (select3.options[select3.selectedIndex].text == "003 - SFP") {
        select4.options.length = 0;
        select5.options.length = 0;
        for (var i = 0; i <= prodHierSeriaFocusPlus.length - 1; i++) {
            select4.add(new Option(prodHierSeriaFocusPlus[i]));
        }
        document.getElementsByClassName("materialGroup")[3].selectedIndex = -1;
    } else if (select3.options[select3.selectedIndex].text == "004 - SSP") {
        select4.options.length = 0;
        select5.options.length = 0;
        for (var i = 0; i <= prodHierSeriaSpectrum.length - 1; i++) {
            select4.add(new Option(prodHierSeriaSpectrum[i]));
        }
        document.getElementsByClassName("materialGroup")[3].selectedIndex = -1;
    } else if (select3.options[select3.selectedIndex].text == "005 - SSPP") {
        select4.options.length = 0;
        select5.options.length = 0;
        for (var i = 0; i <= prodHierSeriaSpectrumPlus.length - 1; i++) {
            select4.add(new Option(prodHierSeriaSpectrumPlus[i]));
        }
        document.getElementsByClassName("materialGroup")[3].selectedIndex = -1;
    } else if (select3.options[select3.selectedIndex].text == "001 - SKON") {
        select4.options.length = 0;
        select5.options.length = 0;
        for (var i = 0; i <= prodHierSeriaKonsola.length - 1; i++) {
            select4.add(new Option(prodHierSeriaKonsola[i]));
        }
        document.getElementsByClassName("materialGroup")[3].selectedIndex = -1;
    } else if (
        select2.options[select2.selectedIndex].text == "003 - CU" &&
        select3.options[select3.selectedIndex].text == "001 - SUSP"
    ) {
        select4.options.length = 0;
        select5.options.length = 0;
        for (var i = 0; i <= prodHierSeriaUniSplit.length - 1; i++) {
            select4.add(new Option(prodHierSeriaUniSplit[i]));
        }
        document.getElementsByClassName("materialGroup")[3].selectedIndex = -1;
    } else if (
        select2.options[select2.selectedIndex].text == "004 - FCU" &&
        select3.options[select3.selectedIndex].text == "000 - NA"
    ) {
        select4.options.length = 0;
        select5.options.length = 0;
        for (var i = 0; i <= prodHierNa.length - 1; i++) {
            select4.add(new Option(prodHierNa[i]));
        }
        document.getElementsByClassName("materialGroup")[3].selectedIndex = -1;
    } else if (
        select2.options[select2.selectedIndex].text == "005 - CHU" &&
        select3.options[select3.selectedIndex].text == "001 - SUSP"
    ) {
        select4.options.length = 0;
        select5.options.length = 0;
        for (var i = 0; i <= prodHierSeriaUniSplit2.length - 1; i++) {
            select4.add(new Option(prodHierSeriaUniSplit2[i]));
        }
        document.getElementsByClassName("materialGroup")[3].selectedIndex = -1;
    } else if (
        select2.options[select2.selectedIndex].text == "006 - CM" &&
        select3.options[select3.selectedIndex].text == "001 - CMOD"
    ) {
        select4.options.length = 0;
        select5.options.length = 0;
        for (var i = 0; i <= prodHierComMod.length - 1; i++) {
            select4.add(new Option(prodHierComMod[i]));
        }
        document.getElementsByClassName("materialGroup")[3].selectedIndex = -1;
    } else if (
        select2.options[select2.selectedIndex].text == "007 - MVOU" &&
        select3.options[select3.selectedIndex].text == "001 - SMV"
    ) {
        select4.options.length = 0;
        select5.options.length = 0;
        for (var i = 0; i <= prodHierSeriaMultiVariable.length - 1; i++) {
            select4.add(new Option(prodHierSeriaMultiVariable[i]));
        }
        document.getElementsByClassName("materialGroup")[3].selectedIndex = -1;
    } else if (
        select2.options[select2.selectedIndex].text == "007 - MVOU" &&
        select3.options[select3.selectedIndex].text == "002 - CHPMS"
    ) {
        select4.options.length = 0;
        select5.options.length = 0;
        for (var i = 0; i <= prodHierSeriaChpms.length - 1; i++) {
            select4.add(new Option(prodHierSeriaChpms[i]));
        }
        document.getElementsByClassName("materialGroup")[3].selectedIndex = -1;
    } else if (
        select2.options[select2.selectedIndex].text == "008 - MVIU" &&
        select3.options[select3.selectedIndex].text == "001 - SMV"
    ) {
        select4.options.length = 0;
        select5.options.length = 0;
        for (var i = 0; i <= prodHierSeriaMultiVariableIu.length - 1; i++) {
            select4.add(new Option(prodHierSeriaMultiVariableIu[i]));
        }
        document.getElementsByClassName("materialGroup")[3].selectedIndex = -1;
    } else if (
        select2.options[select2.selectedIndex].text == "009 - CACWHSP" &&
        select3.options[select3.selectedIndex].text == "001 - HSCS"
    ) {
        select4.options.length = 0;
        select5.options.length = 0;
        for (var i = 0; i <= prodHierSeriaHIGHSpringChannel.length - 1; i++) {
            select4.add(new Option(prodHierSeriaHIGHSpringChannel[i]));
        }
        document.getElementsByClassName("materialGroup")[3].selectedIndex = -1;
    } else if (
        select2.options[select2.selectedIndex].text == "010 - WAC" &&
        select3.options[select3.selectedIndex].text == "001 - SWIN"
    ) {
        select4.options.length = 0;
        select5.options.length = 0;
        for (var i = 0; i <= prodHierSeriaWindow.length - 1; i++) {
            select4.add(new Option(prodHierSeriaWindow[i]));
        }
        document.getElementsByClassName("materialGroup")[3].selectedIndex = -1;
    } else if (
        select2.options[select2.selectedIndex].text == "011 - RAC" &&
        select3.options[select3.selectedIndex].text == "000 - NA"
    ) {
        select4.options.length = 0;
        select5.options.length = 0;
        for (var i = 0; i <= prodHierSeriaWindow.length - 1; i++) {
            select4.add(new Option(prodHierSeriaWindow[i]));
        }
        document.getElementsByClassName("materialGroup")[3].selectedIndex = -1;
    } else if (
        select2.options[select2.selectedIndex].text == "012 - WAHP" &&
        select3.options[select3.selectedIndex].text == "001 - SBOAT"
    ) {
        select4.options.length = 0;
        select5.options.length = 0;
        for (var i = 0; i <= prodHierSeriaBoat.length - 1; i++) {
            select4.add(new Option(prodHierSeriaBoat[i]));
        }
        document.getElementsByClassName("materialGroup")[3].selectedIndex = -1;
    } else if (
        select2.options[select2.selectedIndex].text == "013 - PAC" &&
        select3.options[select3.selectedIndex].text == "001 - SMOB"
    ) {
        select4.options.length = 0;
        select5.options.length = 0;
        for (var i = 0; i <= prodHierPac.length - 1; i++) {
            select4.add(new Option(prodHierPac[i]));
        }
        document.getElementsByClassName("materialGroup")[3].selectedIndex = -1;
    } else if (
        select2.options[select2.selectedIndex].text == "014 - PD" &&
        select3.options[select3.selectedIndex].text == "001 - SMOB"
    ) {
        select4.options.length = 0;
        select5.options.length = 0;
        for (var i = 0; i <= prodHierPdryers.length - 1; i++) {
            select4.add(new Option(prodHierPdryers[i]));
        }
        document.getElementsByClassName("materialGroup")[3].selectedIndex = -1;
    } else if (
        select2.options[select2.selectedIndex].text == "015 - AF" &&
        select3.options[select3.selectedIndex].text == "001 - SMOB"
    ) {
        select4.options.length = 0;
        select5.options.length = 0;
        for (var i = 0; i <= prodHierAirFilter.length - 1; i++) {
            select4.add(new Option(prodHierAirFilter[i]));
        }
        document.getElementsByClassName("materialGroup")[3].selectedIndex = -1;
    } else if (
        select2.options[select2.selectedIndex].text == "016 - OAS" &&
        select3.options[select3.selectedIndex].text == "001 - WCON"
    ) {
        select4.options.length = 0;
        select5.options.length = 0;
        for (var i = 0; i <= prodHierOasWc.length - 1; i++) {
            select4.add(new Option(prodHierOasWc[i]));
        }
        document.getElementsByClassName("materialGroup")[3].selectedIndex = -1;
    } else if (
        select2.options[select2.selectedIndex].text == "016 - OAS" &&
        select3.options[select3.selectedIndex].text == "002 - CCON"
    ) {
        select4.options.length = 0;
        select5.options.length = 0;
        for (var i = 0; i <= prodHierCentralCon.length - 1; i++) {
            select4.add(new Option(prodHierCentralCon[i]));
        }
        document.getElementsByClassName("materialGroup")[3].selectedIndex = -1;
    } else if (
        select2.options[select2.selectedIndex].text == "016 - OAS" &&
        select3.options[select3.selectedIndex].text == "003 - DTFMSU"
    ) {
        select4.options.length = 0;
        select5.options.length = 0;
        for (var i = 0; i <= prodHierDtfmSunit.length - 1; i++) {
            select4.add(new Option(prodHierDtfmSunit[i]));
        }
        document.getElementsByClassName("materialGroup")[3].selectedIndex = -1;
    }
}

const enClass = [
    "001 - A+++",
    "002 - A++",
    "003 - A+",
    "004 - A",
    "005 - B",
    "006 - C",
    "007 - D",
    "008 - E",
    "009 - F",
    "010 - G"
];

select4.addEventListener("change", changeMatGroup3);

function changeMatGroup3() {
    if (
        select4.options[select4.selectedIndex].text == "001 - ASH-09BIR" ||
        select4.options[select4.selectedIndex].text == "002 - ASH-12BIR" ||
        select4.options[select4.selectedIndex].text == "001 - ASH-09BIV" ||
        select4.options[select4.selectedIndex].text == "002 - ASH-12BIV" ||
        select4.options[select4.selectedIndex].text == "003 - ASH-18BIV" ||
        select4.options[select4.selectedIndex].text == "004 - ASH-24BIV" ||
        select4.options[select4.selectedIndex].text == "001 - ASH-09BIF2" ||
        (select4.options[select4.selectedIndex].text == "002 - ASH-13BIF2")  ||
        (select4.options[select4.selectedIndex].text == "003 - ASH-18BIF2")  ||
        (select4.options[select4.selectedIndex].text == "004 - ASH-24BIF2")  ||
        (select4.options[select4.selectedIndex].text == "001 - ASH-09BIS/W")  ||
        (select4.options[select4.selectedIndex].text == "002 - ASH-13BIS/W")  ||
        (select4.options[select4.selectedIndex].text == "003 - ASH-18BIS/W")  ||
        (select4.options[select4.selectedIndex].text == "004 - ASH-24BIS/W") ||
        (select4.options[select4.selectedIndex].text == "005 - ASH-09BIS/B")  ||
        (select4.options[select4.selectedIndex].text == "006 - ASH-13BIS/B")  ||
        (select4.options[select4.selectedIndex].text == "007 - ASH-18BIS/B")  ||
        (select4.options[select4.selectedIndex].text == "008 - ASH-24BIS/B")  ||
        (select4.options[select4.selectedIndex].text == "001 - ASH-09BIS2/W")  ||
        (select4.options[select4.selectedIndex].text == "002 - ASH-13BIS2/W")  ||
        (select4.options[select4.selectedIndex].text == "003 - ASH-18BIS2/W")  ||
        (select4.options[select4.selectedIndex].text == "004 - ASH-24BIS2/W")  ||
        (select4.options[select4.selectedIndex].text == "001 - ASP-09BI") ||
        select4.options[select4.selectedIndex].text == "002 - ASP-12BI" ||
        select4.options[select4.selectedIndex].text == "003 - ASP-18BI" ||
        select4.options[select4.selectedIndex].text == "001 - ASC-12BI" ||
        select4.options[select4.selectedIndex].text == "002 - ASC-18BI" ||
        select4.options[select4.selectedIndex].text == "003 - ASC-24BI" ||
        select4.options[select4.selectedIndex].text == "004 - ASC-30BI" ||
        select4.options[select4.selectedIndex].text == "005 - ASC-36BI" ||
        select4.options[select4.selectedIndex].text == "006 - ASC-42BI" ||
        select4.options[select4.selectedIndex].text == "007 - ASC-48BI" ||
        select4.options[select4.selectedIndex].text == "008 - ASC-60BI" ||
        select4.options[select4.selectedIndex].text == "001 - ASF-12BI" ||
        select4.options[select4.selectedIndex].text == "002 - ASF-18BI" ||
        select4.options[select4.selectedIndex].text == "003 - ASF-24BI" ||
        select4.options[select4.selectedIndex].text == "004 - ASF-30BI" ||
        select4.options[select4.selectedIndex].text == "005 - ASF-36BI" ||
        select4.options[select4.selectedIndex].text == "006 - ASF-42BI" ||
        select4.options[select4.selectedIndex].text == "007 - ASF-48BI" ||
        select4.options[select4.selectedIndex].text == "008 - ASF-60BI" ||
        select4.options[select4.selectedIndex].text == "001 - ASD-12BI" ||
        select4.options[select4.selectedIndex].text == "002 - ASD-18BI" ||
        select4.options[select4.selectedIndex].text == "003 - ASD-24BI" ||
        select4.options[select4.selectedIndex].text == "004 - ASD-30BI" ||
        select4.options[select4.selectedIndex].text == "005 - ASD-36BI" ||
        select4.options[select4.selectedIndex].text == "006 - ASD-42BI" ||
        select4.options[select4.selectedIndex].text == "007 - ASD-48BI" ||
        select4.options[select4.selectedIndex].text == "008 - ASD-60BI" ||
        select4.options[select4.selectedIndex].text == "001 - MV-E14BI" ||
        select4.options[select4.selectedIndex].text == "002 -MV-E18BI" ||
        select4.options[select4.selectedIndex].text == "003 -MV-E21BI" ||
        select4.options[select4.selectedIndex].text == "004 -MV-E24BI" ||
        select4.options[select4.selectedIndex].text == "005 -MV-E28BI" ||
        select4.options[select4.selectedIndex].text == "006 -MV-E36BI" ||
        select4.options[select4.selectedIndex].text == "007 -MV-E42BI" ||
        select4.options[select4.selectedIndex].text == "001 - ASW-09BI" ||
        select4.options[select4.selectedIndex].text == "002 - ASW-12BI" ||
        select4.options[select4.selectedIndex].text == "001 - AMC-11P" ||
        select4.options[select4.selectedIndex].text == "002 - AMC-14P"
    ) {
        select5.options.length = 0;
        for (var i = 0; i <= enClass.length - 1; i++) {
            select5.add(new Option(enClass[i]));
        }
        document.getElementsByClassName("materialGroup")[4].selectedIndex = -1;
    }
}
