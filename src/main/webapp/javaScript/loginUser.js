document.getElementById("client").selectedIndex = -1;
const userLoginButton = document.getElementById("getInfoAboutProject");

userLoginButton.addEventListener('click', function () {
    setTimeout(function() {
        alert("Title: Material Master Data Manager \n" +
            "Reason: Engineer's Thesis \n" +
            "Creator: Adam Domanski \n" +
            "Index No: 212305");
    }, 500);
});