<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>新闻管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/font.css">
    <link rel="stylesheet" href="/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <script src="/common/pagination.js"></script>
</head>

<body>
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a href="">新闻管理</a>
        <a>
          <cite>新闻列表</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div id="vueApp" class="x-body">
    <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so" action="/xn/listView" method="get" id="pageForm">
            <input class="layui-input" placeholder="开始日" name="startTime" value="${seracheForm.startTime!""}"
                   id="startTime">
            <input class="layui-input" placeholder="截止日" name="endTime" id="endTime" value="${seracheForm.endTime!""}">
            <input type="text" name="title" placeholder="新闻标题" value="${seracheForm.title!""}" autocomplete="off"
                   class="layui-input">
            <input type="hidden" id="totalCount" value="${newsList.totalCount}">
            <input type="hidden" name="currentPage" id="currentPage" value="${newsList.currentPage}">
            <button class="layui-btn" onclick="serachForm()"><i class="layui-icon">&#xe615;</i></button>
        </form>
    </div>
<#--<xblock>
        <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>-->
        <#--<button class="layui-btn" onclick="x_admin_show('添加新闻','addView',600,400)"><i class="layui-icon"></i>添加
        </button>
        <span class="x-right" style="line-height:40px">共有数据：${newsList.totalCount} 条</span>
    </xblock>-->
    <table class="layui-table">
        <thead>
        <tr>
        <#--<th>
            <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>
        </th>-->
            <th>ID</th>
            <th>标题</th>
            <th>摘要</th>
        <#--   <th>内容</th>-->
            <th>封面</th>
            <th>时间</th>
            <th>状态</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <#if newsList.list ??>
            <#list newsList.list as news>
        <tr>
        <#--<td>
            <div class="layui-unselect layui-form-checkbox" lay-skin="primary" v-bind:data-id='index'><i class="layui-icon">&#xe605;</i></div>
        </td>-->
            <td>${news.id}</td>
            <td>${news.title}</td>
            <td>
                <#if news.summary??>
               <#if news.summary?length gt 30>${news.summary?substring(0,30)}...
               <#else>
                   ${news.summary!''}
               </#if>
                </#if>
            </td>
        <#--  <td>${news.content}</td>-->
            <td><img style="width: 30%" src="${news.newsImage!""}"></td>
            <td>${news.createTime}</td>
            <td class="td-status">
                <#if news.isShow==1>
                    <span class="layui-btn layui-btn-disabled layui-btn-mini">未发布</span>
                <#else>
                    <span class="layui-btn layui-btn-normal layui-btn-mini">已发布</span>
                </#if>
            </td>
            <td class="td-manage">
                <a onclick="member_enable(this,${news.id},${news.isShow})" href="javascript:;">
                    <i class="layui-icon">&#xe601;</i>
                </a>
                <a onclick="x_admin_show('修改新闻','addView?id='+${news.id},800,500)" href="javascript:;">
                    <i class="layui-icon">&#xe642;</i>
                </a>
                <a title="删除" onclick="member_del(this,${news.id})" href="javascript:;">
                    <i class="layui-icon">&#xe640;</i>
                </a>
            </td>
        </tr>
            </#list>
        </#if>
        </tbody>
    </table>
    <div id="page" style="text-align: center">

    </div>
</div>
</body>
<script>
    function member_del(object, id) {
        var _this = this;
        layer.confirm('确认要删除吗？', function (index) {
            //发异步删除数据
            $.ajax({
                url: './delete',
                dataType: 'JSON',
                type: 'POST',
                data: {
                    id: id
                },
                success: function (e) {
                    $(_this).parents("tr").remove();
                    $("#currentPage").val(0);
                    location.reload();
                    layer.close();
                    layer.msg('已删除!', {icon: 1, time: 1000});
                }
            })
        });
    }

    function member_enable(object, id, isShow) {
        layer.confirm('确认要' + (isShow == 1 ? '发布' : '停止发布') + '吗？', function (index) {
            //发异步删除数据
            $.ajax({
                url: './enable',
                dataType: 'JSON',
                type: 'POST',
                data: {
                    id: id,
                    isShow: isShow == 0 ? 1 : 0
                },
                success: function (e) {
                    $("#currentPage").val(0);
                    location.reload();
                    layer.msg('已' + (isShow == 0 ? '发布' : '停止发布') + '!', {icon: 1, time: 1000});
                }
            })
            layer.close();
        });
    }

    function serachForm() {
        $("#currentPage").val(0);
        $("#pageForm").submit();
    }

    layui.use('laydate', function () {
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#startTime',
            type: 'datetime'//指定元素
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#endTime',
            type: 'datetime'//指定元素
        });
    });


    /**************************************时间格式化处理************************************/


</script>

</html>