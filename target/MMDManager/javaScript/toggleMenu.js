$(document).ready(function()
{
    $('#navTogglePanel').css('display','none');
    $("#hamburger").click(function()
    {
        $('#navTogglePanel').slideToggle("slow");
    });
});