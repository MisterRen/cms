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

        <input type="hidden" name="id" value="${xcTeamManage.id!''}">

        <div class="layui-form-item">
            <label for="L_pass" class="layui-form-label">
                <span class="x-red">*</span>头像
            </label>
            <div class="layui-input-inline">
                <div class="layui-upload">
                    <div class="layui-upload-drag" id="uploadDemo">
                        <i class="layui-icon"></i>
                        <p>点击上传，或将文件拖拽到此处(图片大小不超过1M)</p>
                    </div>
                </div>
            </div>

            <div class="layui-input-inline">
                <div class="layui-upload">
                    <div class="layui-upload-drag"  style="width: 100px;height: 100px">
                        <img class="layui-upload-img" style="max-width: 100px;max-height: 100px" src="${xcTeamManage.userIcon!''}" id="demo1">
                        <input type="hidden" value="${xcTeamManage.userIcon!''}" id="userIcon" name="userIcon" required lay-verify="required">
                        <p id="demoText"></p>
                    </div>
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <label for="L_email" class="layui-form-label">
                <span class="x-red">*</span>姓名
            </label>
            <div class="layui-input-inline">
                <input type="text" id="name" name="name" required  lay-verify="required"
                       autocomplete="off" class="layui-input" value="${xcTeamManage.name!''}">
            </div>
        </div>


        <div class="layui-form-item">
            <label for="L_username" class="layui-form-label">
                <span class="x-red">*</span>岗位
            </label>
            <div class="layui-input-inline">
                <input type="text" id="position" name="position" required lay-verify="required"
                       autocomplete="off" class="layui-input" value="${xcTeamManage.position!''}">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="L_repass" class="layui-form-label">
                <span class="x-red">*</span>简介
            </label>
            <div class="layui-input-block">
                <textarea class="layui-textarea" name="profile" lay-verify="content" id="profile" required lay-verify="required">${xcTeamManage.profile!''}</textarea>
            </div>
        </div>

        <div class="layui-form-item">
            <label for="L_username" class="layui-form-label">
                <span class="x-red">*</span>加入时间
            </label>
            <div class="layui-input-inline">
                <input type="text" id="createTime" name="createTime" required lay-verify="required"
                   placeholder="yyyy-MM-dd HH:mm:ss"    autocomplete="off" class="layui-input"   value="${xcTeamManage.createTime!''}">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="L_username" class="layui-form-label">
                <span class="x-red">*</span>是否显示
            </label>
            <div class="layui-input-inline">
                <input <#if xcTeamManage.isShow??><#if xcTeamManage.isShow==0>checked="checked"</#if></#if> name="isShow" lay-skin="switch" lay-filter="switchTest" lay-text="ON|OFF" type="checkbox">
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
    layui.use('laydate', function () {
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#createTime', //指定元素
            type: 'datetime'
        });
    })
    layui.use(['form','layer','upload'], function(){
        $ = layui.jquery;
        var form = layui.form
                ,layer = layui.layer
                ,upload = layui.upload;


        //监听提交
        form.on('submit(add)', function(data){
            console.log(data);
            data.field.isShow = data.field.isShow=='on'?0:1;
            $.ajax({
                url:'/xt/add',
                data:data.field,
                type:"POST",
                dataType:'JSON',
                success:function (d) {
                    if(d.success){
                        layer.alert("增加成功", {icon: 6},function () {
                            this.index;
                            // 获得frame索引
                            debugger;
                            console.info(window.name)
                            if(window.name != ""){
                                var index = parent.layer.getFrameIndex(window.name);
                                //关闭当前frame
                                parent.layer.close(index);
                                parent.location.reload()
                            }else{
                                layer.closeAll();
                                $('.layui-form')[0].reset();
                                //location.href="/xt/listView"
                            }
                        });
                    }else{
                        layer.alert(d.msg, {icon: 4})
                    }
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
                $('#userIcon').val(res.msg)
            },before:function (obj) {
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $('#demo1').attr('src', result); //图片链接（base64）
                });

            }
        });


    });
</script>
</body>

</html>