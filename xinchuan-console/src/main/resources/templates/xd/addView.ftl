<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">

<head>
    <meta charset="UTF-8">
    <title>动态管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/font.css">
    <link rel="stylesheet" href="/css/xadmin.css">
    <script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>
    <script src="/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/js/xadmin.js"></script>
</head>

<body>
<div class="x-body">
    <form class="layui-form" id="dynamic">
        <div class="layui-form-item">
            <label for="title" class="layui-form-label">
                <span class="x-red">*</span>动态图片
            </label>
            <div class="layui-input-inline">
                <div class="layui-upload">
                    <div class="layui-upload-drag" id="fileUpload">
                        <i class="layui-icon"></i>
                        <p>点击上传，或将文件拖拽到此处(<span class="x-red">建议比例8:5</span>)</p>
                    </div>
                </div>
            </div>
            <div class="layui-input-inline">
                <div class="layui-upload">
                    <div class="layui-upload-drag" style="width: 100px;height: 100px">
                        <img class="layui-upload-img" style="max-width: 100px;max-height:100px" src="${dynamic.image!''}" id="uploadImg">
                        <input type="hidden" id="pic" name="image" value="${dynamic.prodectIcon!''}">
                        <p id="demoText"></p>
                    </div>
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="createTime" class="layui-form-label">
                <span class="x-red">*</span>动态日期
            </label>
            <div class="layui-input-inline">
                <input type="text" id="createTime" name="createTime" value="${dynamic.createTime!''}" required
                       placeholder="yyyy-MM-dd HH:mm:ss" lay-verify="required" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="L_profile" class="layui-form-label">
                <span class="x-red">*</span>标题
            </label>
            <div class="layui-input-block">
                <input type="hidden" name="id" value="${dynamic.id!''}">
                <textarea name="title" required lay-verify="title" style="width: 80%" placeholder="标题在10-100之间"
                          class="layui-textarea">${dynamic.title!''}</textarea>
            </div>
        </div>

        <div class="layui-form-item">
            <label for="isShow" class="layui-form-label">
                <span class="x-red">*</span>是否显示
            </label>
            <div class="layui-input-block">
                <input type="checkbox" name="isShow" id="isShow" lay-skin="switch" lay-text="ON|OFF"
               <#if dynamic.isShow??> <#if dynamic.isShow==0> checked="checked"</#if></#if>
                >
            </div>
        </div>

        <div class="layui-form-item">
            <label for="L_repass" class="layui-form-label">
            </label>
            <button class="layui-btn" lay-filter="dynamicAdd" lay-submit="" id="dynamicAdd">
                增加
            </button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>


    </form>
</div>

<script>
    var uploadFile;
    layui.use('laydate', function () {
        var laydate = layui.laydate;
        laydate.render({
            elem: '#createTime', //指定元素
            type: 'datetime'
        });
    })

    layui.use(['form', 'layer'], function () {
        $ = layui.jquery;
        var form = layui.form
                , layer = layui.layer;

        //自定义验证规则
        form.verify({
            title: function (value) {
                if (value.length > 100 || value.length < 10) {
                    return '标题字数限制10~100';
                }
            }
        });
        //监听提交
        form.on('submit(dynamicAdd)', function (data) {
            console.log(data);
            data.field.isShow = data.field.isShow == 'on' ? 0 : 1;
            $.ajax({
                url: '/xd/dynamicSave',
                data: data.field,
                type: "POST",
                dataType: 'JSON',
                error: function (request) {
                    layer.alert("网络超时");
                },
                success: function (data) {
                    if (data.success) {
                        layer.alert("增加成功", {icon: 6}, function () {
                            this.index;
                            // 获得frame索引
                            if (window.name != "") {
                                var index = parent.layer.getFrameIndex(window.name);
                                //关闭当前frame
                                parent.layer.close(index);
                                parent.location.reload();
                            } else {
                                layer.closeAll();
                                $('.layui-form')[0].reset();
                                //parent.location.reload();
                            }
                        })
                    } else {// 提示失败
                        layer.alert(data, {title: '提示信息', icon: 5});
                    }
                }
            });
            return false;
        });


    });
    layui.use(['upload'], function () {
        var $ = layui.jquery
                , upload = layui.upload;
        var uploadInst = upload.render({
            elem: '#fileUpload'
            , url: '/loadImgae'
            , before: function (obj) {
                //预读本地文件示例，不支持ie8
                obj.preview(function (index, file, result) {
                    $('#uploadImg').attr('src', result); //图片链接（base64）
                });
            }
            , done: function (res) {
                //如果上传失败
                if (res.code > 0) {//自定义返回失败
                    return layer.msg('上传失败');
                } else {
                    $('#pic').val(res.msg);
                }
                //上传成功
            }
            , error: function () {
                //演示失败状态，并实现重传
                var demoText = $('#demoText');
                demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
                demoText.find('.demo-reload').on('click', function () {
                    uploadInst.upload();
                });
            }
        });

    })


</script>
</body>

</html>