$(document).ready(function()
{
    $('nav').css('display','none');
    $("#hamburger").click(function()
    {
        $('nav').slideToggle("slow");
    });
});