//index.js
$(function () {

    //加载弹出层
    layui.use(["form",'element'],
        function() {
            layer = layui.layer;
            element = layui.element;
        });

    //模糊图片
    var img = new Image();
    img.src = "/index/img/index/banner2.png";
    img.onload = function() {
        $(".slide-swiper2").eq(0).css("transition","background-image 0.3s");
        $(".slide-swiper2").eq(0).css("background-image","url('/index/img/index/banner2.png')");
    };
    var img2 = new Image();
    img2.src = "/index/img/index/banner1.png";
    img2.onload = function() {
        $(".slide-swiper2").eq(1).css("transition","background-image 0.3s");
        $(".slide-swiper2").eq(1).css("background-image","url('/index/img/index/banner1.png')");
    };
    var img3 = new Image();
    img3.src = "/index/img/index/banner3.png";
    img3.onload = function() {
        $(".slide-swiper2").eq(2).css("transition","background-image 0.3s");
        $(".slide-swiper2").eq(2).css("background-image","url('/index/img/index/banner3.png')");
    };

    //mobile 在线留言
    $(".footer-contact").click(function () {
        $(".lase-stream-right-color").css("display","block");
        $(".lastpage-right").css("display","block");
    });

    //swiper1
    var mySwiper1 = new Swiper ('.index-swiper1', {
        direction: 'vertical',
        longSwipesRatio : 0.5,
        mousewheel: true,
        hashNavigation: true,
        pagination: {
            el: '.index-swiperpagination1',
            clickable :true,
        },
        on:{
            init: function(){
                swiperAnimateCache(this); //隐藏动画元素
                swiperAnimate(this); //初始化完成开始动画
                if(this.activeIndex == 0){
                    $(".h-con").css("background-color","transparent");
                }else{
                    $(".h-con").css("background-color","#ffffff");
                    $(".index-con>.index-swiper1").css("overflow","hidden");
                }
                if(this.activeIndex == 0 && $(window).width()>768){
                    $(".h-ul>li>a").css("color","#ffffff");
                }else{
                    $(".h-ul>li>a").css("color","#000000");
                }
            },
            slideChangeTransitionStart: function () {
                console.log(this.activeIndex);
                if(this.activeIndex == 0){
                    $(".h-con").css("background-color","transparent");
                }else{
                    $(".h-con").css("background-color","#ffffff");
                    $(".index-con>.index-swiper1").css("overflow","hidden");
                }
                if(this.activeIndex == 0 && $(window).width()>768){
                    $(".h-ul>li>a").css("color","#ffffff");
                }else{
                    $(".h-ul>li>a").css("color","#000000");
                }
            },
            slideChangeTransitionEnd: function(){
                swiperAnimate(this); //每个slide切换结束时也运行当前slide动画
                // console.log(this.preIndex);
                if(this.activeIndex == 4 && $(window).width()<=768){
                    $(".lase-stream-right-color").css("display","none");
                    $(".lastpage-right").css("display","none");
                }
            },
            reachEnd: function(){
                // console.log(this.activeIndex);
                // console.log(location.hash);
                if(location.hash == "#slide7" && this.activeIndex == 0 && $(window).width()<=768){
                    $(".lase-stream-right-color").css("display","block");
                    setTimeout(function () {
                        $(".lastpage-right").css("display","block");
                    },0)
                }
            },
        }
    })

    //swiper2
    var mySwiper2 = new Swiper ('.index-swiper2', {
        // autoplay: true,
        nested: true,
        pagination: {
            el: '.index-swiperpagination2',
            clickable :true,
        },
        on:{
            init: function(){
                swiperAnimateCache(this); //隐藏动画元素
                swiperAnimate(this); //初始化完成开始动画
            },
            slideChangeTransitionEnd: function(){
                swiperAnimate(this); //每个slide切换结束时也运行当前slide动画
            }
        }
    })

    //swiper3
    var mySwiper3 = new Swiper ('.index-swiper3', {
        autoplay: true,
        simulateTouch : false,//禁止鼠标模拟
        nested:true,
        loop:true,
        loopAdditionalSlides : 3,
        centeredSlides : true,
        slidesPerView: 1.4,
        pagination: {
            el: '.index-swiperpagination3',
            clickable :true,
        }
    })

    //转盘
    console.log($(".grayitem").eq(0).width());
    console.log($(".grayitem").eq(0).height());
    var rot_w = $(".grayitem").eq(0).width();
    var rot_h = $(".grayitem").eq(0).height();
    var rot1,rot2,rot3,rot4,rot5,rot6;
    rot1 = {
        top: -rot_h,
        left: 0,
        opacity: 0
    };
    rot2 = {
        top: 0,
        left: 0,
        opacity: 1
    };
    rot3 = {
        top: rot_h,
        left: 0,
        opacity: 1
    };
    rot4 = {
        top: rot_h,
        left: rot_w,
        opacity: 1
    };
    rot5 = {
        top: 0,
        left: rot_w,
        opacity: 1
    };
    rot6 = {
        top: -rot_h,
        left: rot_w,
        opacity: 0
    };
    $(".grayitem").eq(0).css(rot1);
    $(".grayitem").eq(1).css(rot2);
    $(".grayitem").eq(2).css(rot3);
    $(".grayitem").eq(3).css(rot4);
    $(".grayitem").eq(4).css(rot5);
    function startRot(index){
        $(".grayitem").eq( (6-index)>=0 ? 6-index : 6-index+5 ).css(rot6);
        $(".grayitem").eq( (5-index)>=0 ? 5-index : 5-index+5 ).css(rot5);
        $(".grayitem").eq( (4-index)>=0 ? 4-index : 4-index+5 ).css(rot4);
        $(".grayitem").eq( (3-index)>=0 ? 3-index : 3-index+5 ).css(rot3);
        $(".grayitem").eq( (2-index)>=0 ? 2-index : 2-index+5 ).css(rot2);
        setTimeout(function () {
            $(".grayitem").eq( (6-index)>=0 ? 6-index : 6-index+5 ).css(rot1);
        },500);
    }
    //swiper4
    var mySwiper4 = new Swiper ('.index-swiper4', {
        autoplay: true,
        allowSlidePrev : false,
        grabCursor: true,
        loop: true,
        nested:true,
        pagination: {
            el: '.index-swiperpagination4',
            clickable :true,
        },
        on: {
            slideChangeTransitionStart: function () {
                startRot(this.activeIndex);
            }
        }
    })


    //swiper5
    // var mySwiper5 = new Swiper ('.index-swiper5', {
    //     nested:true,
    //     navigation: {
    //         nextEl: '.swiper-button-next5',
    //         prevEl: '.swiper-button-prev5',
    //     },
    // })

    function staffpc(index) {
        $(".team-img").each(function () {
            $(this).removeClass("active");
        });
        $(".team-img").eq(index).addClass("active");
    }
    function staffm(index) {
        $(".team-img-m").each(function () {
            $(this).removeClass("active");
        });
        $(".team-img-m").eq(index).addClass("active");
    }

    //swiper6
    var mySwiper6 = new Swiper ('.index-swiper6', {
        // autoplay: true,
        nested:true,
        // pagination: {
        //     el: '.index-swiperpagination6',
        //     clickable :true,
        // },
        on:{
            init: function () {
                //pc
                $(".team-img").eq(0).addClass("active");
                //m
                $(".team-img-m").eq(0).addClass("active");
            },
            slideChangeTransitionStart: function(){
                //pc
                staffpc(this.activeIndex);
                //m
                staffm(this.activeIndex);
            },
        }
    })
    
    //pc
    $(".team-img").each(function () {
        $(this).click(function () {
            mySwiper6.slideTo($(this).index(), 200, false);
            staffpc($(this).index());
        });
    });
    //m
    $(".team-img-m").each(function () {
        $(this).click(function () {
            mySwiper6.slideTo($(this).index(), 200, false);
            staffm($(this).index());
        });
    });

    //swiper7
    // var mySwiper7 = new Swiper ('.index-swiper7', {
    //     autoplay: true,
    //     nested:true,
    //     pagination: {
    //         el: '.index-swiperpagination7',
    //         clickable :true,
    //     }
    // })

    //错误提示
    var show_info = function(id, t) {
        var this_ = $(id)
        this_.prev().css("color", "red")
        this_.parent().css("border-color", "red")

        if (t) {
            this_.prev().css("color", "#9a7fbf")
            this_.parent().css("border-color", "#9a7fbf")
        }
    }
    // 验证
    var check_name = function() {
        if ($("#userName").val().length <= 0) {
            show_info("#userName")
            return false;
        }
        show_info("#userName", true)
        return true;
    }
    var check_phone = function() {
        var reg = /^((\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$)$/
        var num = $("#userPhone").val();
        if (!reg.test(num)) {
            show_info("#userPhone")
            return false
        }
        show_info("#userPhone", true)
        return true
    }
    var check_email = function() {
        var reg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/
        if (!reg.test($("#userEmail").val())) {
            show_info("#userEmail")
            return false
        }
        show_info("#userEmail", true)
        return true
    }
    var check_text = function() {
        if ($("#remarks").val().length <= 0) {
            show_info("#remarks")
            return false;
        }
        show_info("#remarks", true)
        return true;
    }
    // 表单验证
    function require() {
        return check_name() && check_email() && check_phone() && check_text()
    }
    //keyup触发验证
    $("#userName").on("keydown keyup blur",function () {
        check_name()
    });
    $("#userEmail").on("keydown keyup blur",function () {
        check_email()
    });
    $("#userPhone").on("keydown keyup blur",function () {
        check_phone()
    });
    $("#remarks").on("keydown keyup blur",function () {
        check_text()
    });

    $("#commit").on("click",function(e) {
        submit();
    });


    function submit() {
        if(!require()){
            return false;
        }
        $("#commit").unbind('click');
        $.ajax({
            type: "POST",
            dataType: "json",
            url: '/xc/add' ,
            data: $('#form-sub').serialize(),
            success: function (res) {
                if(res.success){
                    layer.msg(res.msg, {icon: 1, time: 1000});
                    $('#form-sub')[0].reset();
                    $("#commit").on("click",function(e) {
                        submit();
                    });
                }else{
                    layer.msg(res.msg, {icon: 1, time: 1000});
                }

            }
        });
    }

    //top
    $(".sider4").click(function(){
        mySwiper1.slideTo(0, 200, true);
    });

});