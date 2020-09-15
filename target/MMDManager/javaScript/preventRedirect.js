const adminLogOut = document.getElementById("adminLogOut");

adminLogOut.addEventListener('click', function () {
    window.alert("Are You sure You want to leave?");
});

window.onbeforeunload = function() {
    return "Are You sure You want to leave?"
}