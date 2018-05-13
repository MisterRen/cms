$(function () {
    //模糊图片
    var img = new Image();
    img.src = "/index/img/company/banner.png";
    img.onload = function() {
        $(".company-banner").css("transition","background-image 0.3s");
        $(".company-banner").css("background-image","url('/index/img/company/banner.png')");
    };

    var slide_h = $(".swiper-slide").eq(0).innerHeight();
    console.log(slide_h);

    $(".swiper-container").css("height",slide_h*3+"px");

    //swiper1
    var mySwiper1 = new Swiper ('.index-swiper1', {
        direction : 'vertical',
        slidesPerView : 3,
        navigation: {
            nextEl: '.swiper-button-next1',
        },
    })
});

