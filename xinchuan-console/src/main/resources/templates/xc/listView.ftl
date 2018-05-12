<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>邮件管理</title>
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
    <!--[if lt IE 9]>-->
<#-- <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>

    <script src="https://cdn.jsdelivr.net/npm/vue@2.5.16/dist/vue.js"></script>-->
    <script src="/common/pagination.js"></script>
</head>

<body>
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a href="">邮件管理</a>
        <a>
          <cite>邮件列表</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so" action="/xc/listView" method="get" id="pageForm">
            <input class="layui-input" placeholder="姓名" name="userName" value="${seracheForm.userName?default('')}">
            <input class="layui-input" placeholder="电话" name="userPhone" value="${seracheForm.userPhone?default('')}">
            <input type="text" name="userEmail" placeholder="邮箱" value="${seracheForm.userEmail?default('')}"
                   class="layui-input">
            <input type="hidden" id="totalCount" value="${consultList.totalCount}">
            <input type="hidden" name="currentPage" id="currentPage" value="${consultList.currentPage}">
            <button class="layui-btn" onclick="serachForm()"><i class="layui-icon">&#xe615;</i></button>
        </form>
    </div>
    <div>
    <#--<button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>-->
    <#--<button class="layui-btn" onclick="x_admin_show('添加新闻','./addView',600,400)"><i class="layui-icon"></i>添加</button>-->
        <span class="x-right" style="line-height:40px">共有数据：${consultList.totalCount} 条</span>
    </div>
    <table class="layui-table">
        <thead>
        <tr>
        <#--<th>
            <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>
        </th>-->
            <th>ID</th>
            <th>姓名</th>
            <th>电话</th>
            <th>邮箱</th>
            <th>备注</th>
            <th>时间</th>
            <th>状态</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
         <#if consultList.list ??>
             <#list consultList.list as consult>
        <tr>
        <#--<td>
            <div class="layui-unselect layui-form-checkbox" lay-skin="primary" v-bind:data-id='index'><i class="layui-icon">&#xe605;</i></div>
        </td>-->
            <td>${consult.id}</td>
            <td>${consult.userName!''}</td>
            <td>${consult.userPhone!''}</td>
            <td>${consult.userEmail!''}</td>
            <td>
               <#if consult.remarks??>
                   <#if consult.remarks?length gt 30>${consult.remarks?substring(0,30)}...
                   <#else>
                       ${consult.remarks!''}
                   </#if>
               </#if>
            </td>
            <td>${consult.createTime!''}</td>
            <td class="td-status">
                 <#if consult.status==0>
                <span class="layui-btn layui-btn-normal layui-btn-mini">新建</span>
                 <#else>
                <span class="layui-btn layui-btn-danger layui-btn-mini">跟进</span>
                 </#if>
            <#--<span class="layui-btn layui-btn-warm layui-btn-mini" v-if="consult.status == 2">完成</span>-->
            </td>
            <td class="td-manage">
                <a onclick="member_enable(this,consult.id,consult.status)" href="javascript:;" title="跟进">
                    <i class="layui-icon">&#xe601;</i>
                </a>
                <a title="删除" onclick="member_del(this,consult.id)" href="javascript:;">
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
                    layer.close();
                    layer.msg('已删除!', {icon: 1, time: 1000});
                    $("#currentPage").val(0);
                    location.reload();
                }
            })
        });
    }

    function member_enable(object, id, status) {
        if (status == 1) {
            layer.msg("当前咨询已经跟进。。。")
            return;
        }
        layer.confirm('确认要跟进吗？', function (index) {
            //发异步删除数据
            $.ajax({
                url: './enable',
                dataType: 'JSON',
                type: 'POST',
                data: {
                    id: id,
                    status: status
                },
                success: function (e) {
                    layer.msg('已跟进!', {icon: 1, time: 1000});
                    $("#currentPage").val(0);
                    location.reload();
                }
            })
            layer.close();
        });
    }

    function serachForm() {
        $("#currentPage").val(0);
        $("#pageForm").submit();
    }

    /**************************************时间格式化处理************************************/
    /*    function dateFtt(fmt,date){
            var o = {
                "M+" : date.getMonth()+1,                 //月份
                "d+" : date.getDate(),                    //日
                "h+" : date.getHours(),                   //小时
                "m+" : date.getMinutes(),                 //分
                "s+" : date.getSeconds(),                 //秒
                "q+" : Math.floor((date.getMonth()+3)/3), //季度
                "S"  : date.getMilliseconds()             //毫秒
            };
            if(/(y+)/.test(fmt))
                fmt=fmt.replace(RegExp.$1, (date.getFullYear()+"").substr(4 - RegExp.$1.length));
            for(var k in o)
                if(new RegExp("("+ k +")").test(fmt))
                    fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
            return fmt;
        }*/

</script>

</html>