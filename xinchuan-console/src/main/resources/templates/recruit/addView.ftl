<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.0</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="/css/font.css">
    <link rel="stylesheet" href="/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script src="/plugin/jquery.serializejson.js"></script>
</head>

<body>
<div class="x-body">
    <form class="layui-form" id="recruit_form">
        <input type="hidden" name="id" value="">
        <div class="layui-form-item">
            <label for="L_email" class="layui-form-label">
                <span class="x-red">*</span>职位名称
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_postName" name="postName" required  lay-verify="required"
                       autocomplete="off" class="layui-input" value="">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_username" class="layui-form-label">
                <span class="x-red">*</span>岗位职责
            </label>
            <div class="layui-input-inline">
                <input type="text" placeholder="添加职责描述" name="dutyClaim" required lay-verify="required" autocomplete="off" class="layui-input" value="">
            </div>
            <a href="javascript:;" onclick="addInput(this)" class="layui-btn layui-btn-sm"><i class="layui-icon"></i></a>
        </div>
        <div class="layui-form-item">
            <label for="L_username" class="layui-form-label">
                <span class="x-red">*</span>岗位要求
            </label>
            <div class="layui-input-inline">
                <input type="text" placeholder="添加要求描述" name="requireClaim" required lay-verify="required" autocomplete="off" class="layui-input" value="">
            </div>
            <a href="javascript:;" onclick="addInput(this)" class="layui-btn layui-btn-sm"><i class="layui-icon"></i></a>
        </div>

        <div class="layui-form-item">
            <label for="L_repass" class="layui-form-label">
            </label>
            <button  class="layui-btn" lay-filter="add" lay-submit="">
                增加
            </button>
        </div>
    </form>
</div>
<script>

    $.fn.serializeObject = function()
    {
        var o = {};
        var a = this.serializeArray();
        $.each(a, function() {
            if (o[this.name] !== undefined) {
                if (!o[this.name].push) {
                    o[this.name] = [o[this.name]];
                }
                o[this.name].push(this.value || '');
            } else {
                o[this.name] = this.value || '';
            }
        });
        return o;
    };

    function addInput(_this){
        var _prev = $(_this).prev();
        var _input = _prev.find('input')[0];
        var _cloneInput =$(_input).clone();
        _cloneInput.val("");
        _prev.append(_cloneInput);
        console.log();
    }

    layui.use(['form','layer'], function(){
        $ = layui.jquery;
        var form = layui.form
                ,layer = layui.layer;

        //自定义验证规则
        form.verify({
            nikename: function(value){
                if(value.length < 5){
                    return '昵称至少得5个字符啊';
                }
            }
            ,pass: [/(.+){6,12}$/, '密码必须6到12位']
            ,repass: function(value){
                if($('#L_pass').val()!=$('#L_repass').val()){
                    return '两次密码不一致';
                }
            }
        });

        //监听提交
        form.on('submit(add)', function(data){
            console.log(data);

            console.log($(data.form).serializeObject());
            //console.log($.serializeJSON($('#recruit_form').serialize()));
            data.field.isShow = data.field.isShow=='on'?0:1;
            $.ajax({
                url:'./add',
                data:$(data.form).serializeObject(),
                type:"POST",
                dataType:'JSON',
                success:function (d) {
                    //发异步，把数据提交给php
                    layer.alert("增加成功", {icon: 6},function () {
                        this.index;
                        // 获得frame索引
                        if(window.name != ""){
                            var index = parent.layer.getFrameIndex(window.name);
                            //关闭当前frame
                            parent.layer.close(index);
                        }else{
                            layer.closeAll();
                            //('.layui-form')[0].reset();
                        }
                    });
                }
            });
            return false;
        });
    });
</script>
<script>var _hmt = _hmt || []; (function() {
    var hm = document.createElement("script");
    hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
    var s = document.getElementsByTagName("script")[0];
    s.parentNode.insertBefore(hm, s);
})();</script>
</body>

</html>