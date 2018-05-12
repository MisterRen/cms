<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>新闻列表</title>
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
    <script src="https://cdn.jsdelivr.net/npm/vue@2.5.16/dist/vue.js"></script>
    <script src="/common/pagination.js"></script>
</head>

<body>
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a href="">演示</a>
        <a>
          <cite>导航元素</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div id="vueApp" class="x-body">
    <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so">
            <input class="layui-input" placeholder="姓名" name="start" id="start">
            <input class="layui-input" placeholder="电话" name="end" id="end">
            <input type="text" name="username"  placeholder="邮箱" autocomplete="off" class="layui-input">
            <button class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
        </form>
    </div>
    <div>
    <#--<button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>-->
    <#--<button class="layui-btn" onclick="x_admin_show('添加新闻','./addView',600,400)"><i class="layui-icon"></i>添加</button>-->
        <span class="x-right" style="line-height:40px">共有数据：{{pageData.totalElements}} 条</span>
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
        <tr v-for="(consult,index) in pageData.content">
        <#--<td>
            <div class="layui-unselect layui-form-checkbox" lay-skin="primary" v-bind:data-id='index'><i class="layui-icon">&#xe605;</i></div>
        </td>-->
            <td>{{consult.id}}</td>
            <td>{{consult.userName}}</td>
            <td>{{consult.userPhone}}</td>
            <td>{{consult.userEmail}}</td>
            <td>{{consult.Remarks}}</td>
            <td>{{consult.createTime | formatDate}}</td>
            <td class="td-status">
                <span class="layui-btn layui-btn-normal layui-btn-mini" v-if="consult.status == 0">新建</span>
                <span class="layui-btn layui-btn-danger layui-btn-mini" v-if="consult.status == 1">跟进</span>
            <#--<span class="layui-btn layui-btn-warm layui-btn-mini" v-if="consult.status == 2">完成</span>-->
            </td>
            <td class="td-manage">
                <a @click="member_enable(this,consult.id,consult.status)" href="javascript:;"  title="跟进">
                    <i class="layui-icon">&#xe601;</i>
                </a>
                <a title="删除" @click="member_del(this,consult.id)" href="javascript:;">
                    <i class="layui-icon">&#xe640;</i>
                </a>
            </td>
        </tr>
        </tbody>
    </table>
    <div class="page">
        <div>
            <a class="prev" href="">&lt;&lt;</a>
            <a class="num" href="">1</a>
            <span class="current">2</span>
            <a class="num" href="">3</a>
            <a class="next" href="">&gt;&gt;</a>
        </div>
    </div>
</div>
</body>
<script>
    var vue = new Vue({
        el:"#vueApp",
        data:{
            pageData:{},
            total: 81,     // 记录总条数
            display: 10,   // 每页显示条数
            current: 1
        },events:{

        },methods:{
            member_del:function (object,id) {
                var _this = this;
                layer.confirm('确认要删除吗？',function(index){
                    //发异步删除数据
                    $.ajax({
                        url:'./delete',
                        dataType:'JSON',
                        type:'POST',
                        data:{
                            id:id
                        },
                        success:function (e) {
                            $(_this).parents("tr").remove();
                            pageQuery();
                            layer.close();
                            layer.msg('已删除!',{icon:1,time:1000});
                        }
                    })
                });
            },member_enable:function (object,id,status) {
                if(status == 1){
                    layer.msg("当前咨询已经跟进。。。")
                    return;
                }
                layer.confirm('确认要跟进吗？', function (index) {
                    //发异步删除数据
                    $.ajax({
                        url:'./enable',
                        dataType:'JSON',
                        type:'POST',
                        data:{
                            id:id,
                            status: status
                        },
                        success:function (e) {
                            pageQuery();
                            layer.msg('已跟进!', {icon: 1, time: 1000});
                        }
                    })
                    layer.close();
                });
            },x_window_show:function (title,url,w,h) {
                if (title == null || title == '') {
                    title=false;
                };
                if (url == null || url == '') {
                    url="404.html";
                };
                if (w == null || w == '') {
                    w=($(window).width()*0.9);
                };
                if (h == null || h == '') {
                    h=($(window).height() - 50);
                };
                layer.open({
                    type: 2,
                    area: [w+'px', h +'px'],
                    fix: false, //不固定
                    maxmin: true,
                    shadeClose: true,
                    shade:0.4,
                    title: title,
                    content: url
                });
            }
        },filters:{
            formatDate:function (date) {
                return dateFtt("yyyy-MM-dd hh:mm:ss",new Date(date));
            },isEnable:function (status) {
                if(status == 0){
                    return '跟进';
                }else{
                    return '停用';
                }
            }
        }
    });
    layui.use('laydate', function(){
        var laydate = layui.laydate;

    });

    function pageQuery() {
        $.ajax({
            url:"./pageQuery",
            dataType:'JSON',
            type:'GET',
            success:function (d) {
                vue.pageData = d;
            }
        })
    }
    pageQuery();


    /**************************************时间格式化处理************************************/
    function dateFtt(fmt,date){
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
    }

</script>
<script>
    var _hmt = _hmt || [];
    (function () {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();
</script>

</html>