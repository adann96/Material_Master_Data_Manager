const newPassReq = document.getElementsByClassName("fas fa-question");

newPassReq[0].addEventListener('click', function () {
    setTimeout(function() {
        alert("Title: Material Master Data Manager \n" +
            "Reason: Engineer's Thesis \n" +
            "Creator: Adam Domanski \n" +
            "Index No: 212305");
    }, 500);
});