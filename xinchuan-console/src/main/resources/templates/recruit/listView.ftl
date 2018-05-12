<!DOCTYPE html>
<html>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>团队管理</title>
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
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a href="">招聘管理</a>
        <a>
          <cite>招聘列表</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <form class="layui-row" action="/recruit/findByDateAndName" method="get">
        <div class="layui-form layui-col-md12 x-so">
            <input class="layui-input" placeholder="开始日" name="startDate" id="startDate" value="${startDate!""}">
            <input class="layui-input" placeholder="截止日" name="endDate" id="endDate" value="${endDate!""}">
            <input  name="postName" id="postName" placeholder="请输入岗位名称"  class="layui-input" value="${postName!""}">
            <button  class="layui-btn"><i class="layui-icon">&#xe615;</i></button>
        </div>
    </form>
    <xblock>
        <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
        <button class="layui-btn" onclick="x_admin_show('添加用户','saveOrUpdate')"><i class="layui-icon"></i>添加
        </button>
        <span class="x-right" style="line-height:40px">共有数据：${xcRecruitOldList?size} 条</span>
    </xblock>
    <table class="layui-table">
        <thead>
        <tr>
            <th>
                <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i
                        class="layui-icon">&#xe605;</i></div>
            </th>
            <th>ID</th>
            <th>岗位名称</th>
            <th>岗位职责</th>
            <th>岗位要求</th>
            <th>时间</th>
            <th>操作</th>
        </thead>
    <#list xcRecruitOldList as recruit>
        <tbody>
        <tr>
            <td>
                <div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='${recruit.id}'><i class="layui-icon">&#xe605;</i>
                </div>
            </td>
            <td>${recruit.id}</td>
            <td>${recruit.postName}</td>
            <td>${recruit.duty}</td>
            <td>${recruit.requirements}</td>
            <td>${recruit.createTime}</td>
            <td class="td-manage">
                <a title="编辑" onclick="x_admin_show('编辑','saveOrUpdate?id='+${recruit.id})" href="javascript:;">
                    <i class="layui-icon">&#xe642;</i>
                </a>
            </td>
        </tr>
        </tbody>
    </#list>
    </table>
    <div class="page">
        <div>
            <a class="prev" href="">&lt;&lt;</a>
            <a class="num" href="">1</a>
            <span class="current">2</span>
            <a class="num" href="">3</a>
            <a class="num" href="">489</a>
            <a class="next" href="">&gt;&gt;</a>
        </div>
    </div>

</div>
<script>
    layui.use('laydate', function () {
        var laydate = layui.laydate;
        //执行一个laydate实例
        laydate.render({
            elem: '#startDate' //指定元素
        });
        //执行一个laydate实例
        laydate.render({
            elem: '#endDate' //指定元素
        });
    });

    /*删除所有*/
    function delAll(argument) {
        var data = tableCheck.getData().toString();
        if(data.length==0){
            layer.msg('请选择要删除的数据！');
            return;
        }
        layer.confirm('确认要删除吗？' + data, function (index) {
            //捉到所有被选中的，发异步进行删除
            $.post("/recruit/delAll",{ids:data},function(result){
                if(result.success){
                    location.reload();
                    layer.msg('删除成功', {icon: 1});
                }else{
                    layer.msg(result.msg, {icon: 5});
                }

            });
        });
    }
</script>
</body>

</html>