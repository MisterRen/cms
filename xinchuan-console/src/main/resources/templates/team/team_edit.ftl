<!doctype html>
<html lang="en">
<html>
<head>
    <meta charset="UTF-8">
    <title>团队列表--编辑</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="/css/font.css">
    <link rel="stylesheet" href="/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/js/xadmin.js"></script>
</head>

<body>
<div class="x-body">
    <form class="layui-form">

        <div class="layui-form-item">
            <label for="L_userIcon" class="layui-form-label">
                <span class="x-red">*</span>头像
            </label>
            <div class="layui-input-inline">
                <div class="layui-upload">
                    <button type="button" class="layui-btn" id="test1">上传图片</button>
                    <div class="layui-upload-list">
                        <img class="layui-upload-img" id="demo1">
                        <p id="demoText"></p>
                    </div>
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <label for="L_name" class="layui-form-label">
                <span class="x-red">*</span>姓名
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_name" name="name" required lay-verify="required"
                       autocomplete="off" class="layui-input" value="${xcTeamManage.name}">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="L_position" class="layui-form-label">
                <span class="x-red">*</span>岗位
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_position" name="position" required lay-verify="required"
                       autocomplete="off" class="layui-input" value="${xcTeamManage.profile}">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="L_profile" class="layui-form-label">
                <span class="x-red">*</span>简介
            </label>
            <div class="layui-input-inline">
                <textarea name="" required lay-verify="required" placeholder="请输入" class="layui-textarea">${xcTeamManage.position}</textarea>
            </div>
        </div>

        <div class="layui-form-item">
            <label for="L_isShow" class="layui-form-label">
                <span class="x-red">*</span>是否显示
            </label>
            <input type="checkbox" name="isShow" lay-skin="switch" lay-text="YES|NO">
        </div>

        <div class="layui-form-item">
            <label for="L_repass" class="layui-form-label">
            </label>
            <button  class="layui-btn" lay-filter="add" lay-submit="">
                增加
            </button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>


    </form>
</div>
<script>
    layui.use(['form','layer'], function(){
        $ = layui.jquery;
        var form = layui.form
                ,layer = layui.layer;
        //监听提交
        form.on('submit(add)', function(data){
            console.log(data);
            //发异步，把数据提交给php
            layer.alert("增加成功", {icon: 6},function () {
                // 获得frame索引
                var index = parent.layer.getFrameIndex(window.name);
                //关闭当前frame
                parent.layer.close(index);
            });
            return false;
        });


    });
</script>
</body>

</html>