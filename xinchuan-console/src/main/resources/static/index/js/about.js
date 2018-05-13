$(function(){

    //加载弹出层
    layui.use(["form",'element'],
        function() {
            layer = layui.layer;
            element = layui.element;
        });

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

    //stop submit
    $("#commit").on("click",function(e) {
        submit();
    });

    function submit() {
        $("#commit").unbind('click');
        if(!require()){
            return false;
        }
        $.ajax({
            type: "POST",
            dataType: "json",
            url: '/xc/add' ,
            data: $('#form-sub').serialize(),
            success: function (res) {
                if(res.success){
                    layer.msg(res.msg, {icon: 1, time: 1000});
                    //all_swiper.slideTo(0,500,true);
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

});



