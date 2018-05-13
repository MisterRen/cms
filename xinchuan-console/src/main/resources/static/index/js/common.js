$(function () {

    //mobile header
    $(".m-nav-btn").on("click",function () {
        if($(window).width() <= 768) {
            console.log("down1");
            $(".h-ul").slideToggle();
        }
    });
    $(".h-ul").on("click",function () {
        if($(window).width() <= 768){
            console.log("down2");
            $(".h-ul").slideToggle();
        }
    });
    
    //sider
    $(".sider1").mouseenter(function () {
        $(this).animate({
           "width": "182px",
           "left": "-130px",
        },200);
        $(this).css("background-color","#58328b");
    });
    $(".sider1").mouseleave(function () {
        $(this).animate({
            "width": "52px",
            "left": "0px",
        },200);
        $(this).css("background-color","#31353d");
    });
    $(".sider2").mouseenter(function () {
        $(".qrcode-wx").css("display","block");
    });
    $(".sider2").mouseleave(function () {
        $(".qrcode-wx").css("display","none");
    });
    $(".sider4").click(function(){
        $("html,body").animate({scrollTop:0}, 200);
    });

    //wow动画
    var wow = new WOW({
        boxClass: 'wow',
        animateClass: 'animated',
        offset: 0,
        mobile: true,
        live: true
    });
    wow.init();

});