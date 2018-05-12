<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>产品管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="/css/font.css">
    <link rel="stylesheet" href="/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/js/xadmin.js"></script>
</head>

<body>
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">产品管理</a>
        <a href="">产品列表</a>
        <a>
          <cite>导航元素</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so" action="/product/findAll" id="serachForm">
            <input class="layui-input" placeholder="开始日" value="${seracheForm.startTime?default('')}" name="startTime" id="startTime">
            <input class="layui-input" placeholder="截止日" value="${seracheForm.endTime?default('')}" name="endTime" id="endTime">
            <input type="text" name="prodectName"  value="${seracheForm.prodectName?default('')}" placeholder="请输入产品名称" autocomplete="off" class="layui-input">
            <input type="hidden"  name="currentPage" id="currentPage" value="${products.currentPage}">
            <input type="hidden" id="totalCount" value="${products.totalCount}">
            <button type="button" onclick="serachForm()" class="layui-btn"><i class="layui-icon">&#xe615;</i></button>
        </form>
    </div>
    <xblock>
        <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
        <button class="layui-btn" onclick="x_admin_show('添加产品','addView')"><i class="layui-icon"></i>添加</button>
        <span class="x-right" style="line-height:40px">共有数据：${products.totalCount} 条</span>
    </xblock>
    <table class="layui-table">
        <thead>
        <tr>
            <th>
                <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>
            </th>
            <th>ID</th>
            <th>产品名称</th>
            <th>产品icon</th>
            <th>产品简介</th>
            <th>创建时间</th>
            <th>发布状态</th>
            <th>产品顺序</th>
            <th>操作</th>
        </thead>
        <tbody>
        <tr>
        <#if products.list ??>
        <#list products.list as product>
            <td>
                <div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='${product.id}'><i class="layui-icon">&#xe605;</i></div>
            </td>
            <td>${product.id}</td>
            <td>${product.prodectName}</td>
            <td><img src="${product.prodectIcon}"></td>
            <td>
                <#if product.summary?length gt 30>${product.summary?substring(0,30)}...
                <#else>
                ${product.summary}
                </#if>
            </td>
            <td>${product.createTime}</td>
            <td>
            <#if product.isShow==1>
                <span class="layui-btn layui-btn-disabled layui-btn-mini">未发布</span>
            <#else>
                <span class="layui-btn layui-btn-normal layui-btn-mini">已发布</span>
            </#if>
            </td>
            <td>${product.level}</td>
            <td class="td-manage">
                <a title="编辑" onclick="x_admin_show('编辑','addView?id='+${product.id})" href="javascript:;">
                    <i class="layui-icon layui-icon-edit site-doc-icon">&#xe642;</i>
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
    layui.use('laydate', function(){
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#startTime' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#endTime' //指定元素
        });
    });




    function delAll (argument) {
        var data = tableCheck.getData();
        var ids=data.toString();
        layer.confirm('确认要删除吗？'+data,function(index){
            $.post("/xp/deleteProduct",{ids:ids},function(result){
                $("#currentPage").val(0);
                location.replace(location.href);
            });

        });
    }
    function serachForm() {
        $("#currentPage").val(0);
        $("#serachForm").submit();
    }
</script>
</body>

</html>