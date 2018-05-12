<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">

<head>
    <meta charset="UTF-8">
    <title>产品管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/font.css">
    <link rel="stylesheet" href="/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/js/xadmin.js"></script>
</head>

<body>
<div class="x-body">
    <form class="layui-form" id="prodectForm">
        <div class="layui-form-item">
            <label for="prodectIcon" class="layui-form-label">
                <span class="x-red">*</span>产品icon
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
                    <div class="layui-upload-drag" style="width: 100px;height: 100px">
                        <img class="layui-upload-img" style="width: 100px;height: 100px" src="${product.prodectIcon!''}" id="demo1">
                        <input type="hidden" id="pic" name="prodectIcon" value="${product.prodectIcon!''}">
                        <p id="demoText"></p>
                    </div>
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="createTime" class="layui-form-label">
                <span class="x-red">*</span>日期
            </label>
            <div class="layui-input-inline">
                <input type="text" id="createTime" name="createTime"  value="${product.createTime!''}" required lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="createTime" class="layui-form-label">
                <span class="x-red">*</span>产品名称
            </label>
            <div class="layui-input-block">
                <input type="hidden" name="id" value="${product.id!''}">
                <input type="text" id="prodectName" name="prodectName"  value="${product.prodectName!''}" lay-verify="prodectName"  placeholder="最大长度在2-30之间"  required lay-verify="prodectName"
                       autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="summary" class="layui-form-label">
                <span class="x-red">*</span>产品简介
            </label>
            <div class="layui-input-block">
                <textarea name="summary"  required lay-verify="summary"  placeholder="最大长度在10-300之间"
                          class="layui-textarea">${product.summary!""}</textarea>
            </div>
        </div>

        <div class="layui-form-item">
            <label for="isShow" class="layui-form-label">
                <span class="x-red">*</span>是否显示
            </label>
            <div class="layui-input-block">
            <input type="checkbox" name="isShow" id="isShow"
                  <#if product.isShow??> <#if product.isShow==0>checked="checked" </#if></#if>
                   lay-skin="switch" lay-text="ON|OFF" >
            </div>
        </div>
        <div class="layui-form-item">
            <label for="level" class="layui-form-label">
                <span class="x-red">*</span>产品顺序
            </label>
            <div class="layui-input-inline">
                <input type="number" class="layui-input"  value="${product.level!''}" required  lay-verify="required|number|level" name="level" id="level" min="1" max="7">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_repass" class="layui-form-label">
            </label>
            <button class="layui-btn" lay-filter="productcAdd" lay-submit="" id="productcAdd">
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

        //执行一个laydate实例
        laydate.render({
            elem: '#createTime' //指定元素
        });
    })
    layui.use(['upload'], function(){
        var $ = layui.jquery
                ,upload = layui.upload;
        upload.render({
            elem: '#uploadDemo'
            ,url: '/loadImgae'
            ,before: function(obj){
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $('#demo1').attr('src', result); //图片链接（base64）
                });
            }
            ,done: function(res){
                //如果上传失败
                if(!res.success){//自定义返回失败
                    return layer.msg('上传失败');
                }else{
                    $('#pic').val(res.msg);
                   // $('#demo1').attr('src', res.msg); //图片链接（base64）
                }
                //上传成功
            }
            ,error: function(){
                //演示失败状态，并实现重传
                var demoText = $('#demoText');
                demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
                demoText.find('.demo-reload').on('click', function(){
                    uploadInst.upload();
                });
            }
        });

    })

    layui.use(['form', 'layer'], function () {
        $ = layui.jquery;
        var form = layui.form
                , layer = layui.layer;

        //自定义验证规则
        form.verify({
            prodectName: function (value) {
                if (value.length >20 || value.length<2) {
                    return '产品名称字数限制2~20';
                }
            },
            summary: function (value) {
                if (value.length >200 || value.length<10) {
                    return '产品简介字数限制10~200';
                }
            },
            level: function (value) {
                if (value >7 || value<0) {
                    return '产品顺序在1-7之间';
                }
            }
        });
        //监听提交
        form.on('submit(productcAdd)', function(data){
            console.log(data);
            data.field.isShow = data.field.isShow=='on'?0:1;
            $.ajax({
                url:'/product/productSave',
                data:data.field,
                type:"POST",
                dataType:'JSON',
                error:function (request){
                    layer.alert("网络超时");
                },
                success: function (data) {
                    if (data.success) {
                        layer.alert("增加成功", {icon: 6}, function () {
                            this.index;
                            // 获得frame索引
                            if(window.name != ""){
                                var index = parent.layer.getFrameIndex(window.name);
                                //关闭当前frame
                                parent.layer.close(index);
                                parent.location.reload();
                            }else{
                                layer.closeAll();
                                $('.layui-form')[0].reset();
                                parent.location.reload();
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


</script>

</body>

</html>