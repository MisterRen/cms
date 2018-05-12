<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>动态管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<#--
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
-->
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/font.css">
    <link rel="stylesheet" href="/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/js/xadmin.js"></script>
</head>

<body>
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">动态管理</a>
        <a href="">动态列表</a>
        <a>
          <cite>导航元素</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so" action="/dynamic/findAll" method="get" id="pageForm">
         <input class="layui-input" placeholder="开始日" value="${seracheForm.startTime?default('')}" name="startTime" id="startTime">
            <input class="layui-input" placeholder="截止日" value="${seracheForm.endTime?default('')}" name="endTime" id="endTime">
            <input type="text" name="title" id="title" value="${seracheForm.title?default('')}" placeholder="请输入标题" autocomplete="off" class="layui-input">
            <input type="hidden" id="totalCount" value="${dynamics.totalCount}">
            <input type="hidden"  name="currentPage" id="currentPage" value="${dynamics.currentPage}">
            <button type="button" onclick="serachForm()" class="layui-btn"><i class="layui-icon">&#xe615;</i></button>
        </form>
    </div>
    <xblock>
        <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
        <button class="layui-btn" onclick="x_admin_show('添加动态','saveOrUpdatePage')"><i class="layui-icon"></i>添加</button>
        <span class="x-right" style="line-height:40px">共有数据：${dynamics.totalCount} 条</span>
    </xblock>
    <table class="layui-table">
        <thead>
        <tr>
            <th>
                <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i
                        class="layui-icon">&#xe605;</i></div>
            </th>
            <th>ID</th>
            <th>标题</th>
            <th>图片</th>
            <th>创建时间</th>
            <th>发布状态</th>
            <th>操作</th>
        </thead>
        <tbody>
        <tr>
        <#if dynamics.list ??>
            <#list dynamics.list as dynamic>
            <td>
                <div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='${dynamic.id}'><i
                        class="layui-icon">&#xe605;</i></div>
            </td>
            <td>${dynamic.id}</td>
            <td>${dynamic.title}</td>
            <td><img src="${dynamic.image}"></td>
            <td>${dynamic.createTime}</td>
            <td>
            <#if dynamic.isShow==1>
                <span class="layui-btn layui-btn-disabled  layui-btn-mini">未发布</span>
            <#else>
                <span class="layui-btn layui-btn-normal layui-btn-mini">已发布</span>
            </#if>
            </td>
            <td class="td-manage">
                <a title="编辑" onclick="x_admin_show('编辑','saveOrUpdatePage?id='+${dynamic.id})" href="javascript:;">
                    <i class="layui-icon layui-btn-big">&#xe642;</i>
                </a>
            </td>
        </tr>
            </#list>
        </#if>
        </tbody>
    </table>
    <div id="page">
    </div>
</div>
<script type="text/javascript" src="/common/pagination.js"></script>
<script>
    layui.use('laydate', function () {
        var laydate = layui.laydate;
        laydate.render({
            elem: '#startTime' //指定元素
        });
        laydate.render({
            elem: '#endTime' //指定元素
        });
    });

    function delAll(argument) {
        var data = tableCheck.getData();
        var ids = data.toString();
        layer.confirm('确认要删除吗？' + data, function (index) {
            $.post("/dynamic/deleteDynamic", {ids: ids}, function (result) {
                $("#currentPage").val(0);
                location.replace(location.href);
            });

        });
    }

    function serachForm() {
        $("#currentPage").val(0);
        $("#pageForm").submit();
    }
</script>
</body>

</html>