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
</head>

<body>
<div class="x-body">
    <form class="layui-form">
        <input type="hidden" name="id" value="${news.id!''}">
        <div class="layui-form-item">
            <label for="L_email" class="layui-form-label">
                <span class="x-red">*</span>新闻标题
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_title" name="title" required  lay-verify="required"
                       autocomplete="off" class="layui-input" value="${news.title!''}">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_username" class="layui-form-label">
                <span class="x-red">*</span>新闻摘要
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_summary" name="summary" required lay-verify="required"
                       autocomplete="off" class="layui-input" value="${news.summary!''}">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_username" class="layui-form-label">
                <span class="x-red">*</span>是否启用
            </label>
            <div class="layui-input-inline">
                <input <#if news.isShow??><#if news.isShow==1><#else>checked="checked"</#if></#if> name="isShow" lay-skin="switch" lay-filter="switchTest" lay-text="ON|OFF" type="checkbox">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_pass" class="layui-form-label">
                <span class="x-red">*</span>新闻封面
            </label>
            <div class="layui-input-inline">
                <input type="hidden" value="${news.newsImage!''}" id="newsImage" name="newsImage" required lay-verify="required">
                <div class="layui-upload-drag" id="uploadDemo">
                    <i class="layui-icon"></i>
                    <p>点击上传，或将文件拖拽到此处</p>
                </div>
                <#--<div class="layui-upload-drag">
                    <img style="width: 92px;height: 92px;margin: 0 10px 0 0px;" id="demo1">
                </div>-->
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_repass" class="layui-form-label">
                <span class="x-red">*</span>内容
            </label>
            <div class="layui-input-block">
                <textarea class="layui-textarea" name="content" lay-verify="content" id="LAY_demo_editor" required lay-verify="required">${news.content!''}</textarea>
            </div>
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
    layui.use(['form','layer','upload'], function(){
        $ = layui.jquery;
        var form = layui.form
                ,layer = layui.layer
                ,upload = layui.upload;

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
            data.field.isShow = data.field.isShow=='on'?0:1;
            $.ajax({
                url:'./add',
                data:data.field,
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
                            $('.layui-form')[0].reset();
                        }
                    });
                }
            });
            return false;
        });

        //上传
        upload.render({
            elem: '#uploadDemo'
            ,url: '/loadImgae' //上传接口
            ,done: function(res){
                console.log(res)
                $('#newsImage').val(res.msg)
            },before:function (obj) {
                //预读本地文件示例，不支持ie8
                /*obj.preview(function(index, file, result){
                    $('#demo1').attr('src', result); //图片链接（base64）
                });*/

            }
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