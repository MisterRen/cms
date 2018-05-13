$(function(){
    //模糊图片
    var img = new Image();
    img.src = "/index/img/recruit/banner.png";
    img.onload = function() {
        $(".banner").css("transition","background-image 0.1s");
        $(".banner").css("background-image","url('/index/img/recruit/banner.png')");
    };

    // 百度地图API功能
    var map = new BMap.Map("map");
    var point = new BMap.Point(121.434663, 31.202561);
    map.centerAndZoom(point, 18);
    map.addControl(new BMap.NavigationControl());
    var marker = new BMap.Marker(point);  // 创建标注
    map.addOverlay(marker);              // 将标注添加到地图中

    marker.addEventListener("click", getAttr);

    function getAttr() {
        var p = marker.getPosition();       //获取marker的位置
        alert("marker的位置是" + p.lng + "," + p.lat);
    }

    //错误提示
    var show_info = function(id, t) {
        var this_ = $(id)
        this_.prev().css("color", "red")
        this_.parent().css("border-color", "red")

        if (t) {
            this_.prev().css("color", "#4f4f4f")
            this_.parent().css("border-color", "#4f4f4f")
        }
    }
    // 验证
    var check_name = function() {
        if ($("#name").val().length <= 0) {
            show_info("#name")
            return false;
        }
        show_info("#name", true)
        return true;
    }
    var check_phone = function() {
        var reg = /^((\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$)$/
        var num = $("#phone").val();
        if (!reg.test(num)) {
            show_info("#phone")
            return false
        }
        show_info("#phone", true)
        return true
    }
    var check_email = function() {
        var reg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/
        if (!reg.test($("#email").val())) {
            show_info("#email")
            return false
        }
        show_info("#email", true)
        return true
    }
    var check_text = function() {
        if ($("#note").val().length <= 0) {
            show_info("#note")
            return false;
        }
        show_info("#note", true)
        return true;
    }
    // 表单验证
    function require() {
        return check_name() && check_email() && check_phone() && check_text()
    }
    //keyup触发验证
    $("#name").on("keydown keyup blur",function () {
        check_name()
    });
    $("#email").on("keydown keyup blur",function () {
        check_email()
    });
    $("#phone").on("keydown keyup blur",function () {
        check_phone()
    });
    $("#note").on("keydown keyup blur",function () {
        check_text()
    });
    //stop submit
    $("#commit").on("click",function(e) {
        e.preventDefault();
        if(!require()){
            return false;
        }
        $.ajax({
            // type: "POST",
            // dataType: "json",
            // url: '/index/message/message' ,
            // data: $('.get_form').serialize(),
            // success: function (res) {
            //     console.log(res);
            //     if(res.state=='success'){
            //         alert(res.msg);
            //         all_swiper.slideTo(0,500,true);
            //         $(".get_form")[0].reset();
            //     }else{
            //         alert(res.msg);
            //     }
            //
            // }
        });
    });


});



