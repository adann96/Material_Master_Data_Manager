document.getElementById("client").selectedIndex = -1;

const newPassReq = document.getElementsByClassName("fas fa-question");
const userID = document.getElementById("userID");
const userLoginButton = document.getElementsByClassName("userLoginButton");

newPassReq[0].addEventListener('click', function () {
    setTimeout(function() {
        alert("Title: Material Master Data Manager \n" +
            "Reason: Engineer's Thesis \n" +
            "Creator: Adam Domanski \n" +
            "Index No: 212305");
    }, 500);
});