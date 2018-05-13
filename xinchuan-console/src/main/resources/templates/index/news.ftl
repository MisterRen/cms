<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>原优</title>
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
    <meta name="format-detection" content="telephone=no"/>
    <link rel="shortcut icon" href="/index/img/index/icon.png">
    <link rel="stylesheet" href="/index/common/bootstrap/bootstrap.css">
    <link rel="stylesheet" href="/index/common/swiper/swiper.min.css">
    <link rel="stylesheet" href="/index/common/swiper/animate.min.css">
    <link rel="stylesheet" href="/index/css/reset.css">
    <link rel="stylesheet" href="/index/css/header.css">
    <link rel="stylesheet" href="/index/css/news.css">
    <#--<link rel="stylesheet" href="/css/font.css">-->
   <#-- <link rel="stylesheet" href="/css/xadmin.css">-->


</head>
<body>
<!--header-->
<header class="h-con">
    <div class="container">
        <div class="m-nav-btn">
            <span></span>
            <span></span>
            <span></span>
        </div>
        <a href="./index.html">
            <img src="/index/img/index/logo-m.png" alt="">
        </a>
        <ul class="h-ul">
            <li class="">
                <a href="/">
                    首页
                </a>
                <span class="h-angle"></span>
            </li>
            <li>
                <a href="/xinchuan/company">
                    公司简介
                </a>
                <span class="h-angle"></span>
            </li>
            <li>
                <a href="/xinchuan/server">
                    产品服务
                </a>
                <span class="h-angle"></span>
            </li>
            <li class="active">
                <a href="/xinchuan/news">
                    动态新闻
                </a>
                <span class="h-angle"></span>
            </li>
            <li>
                <a href="/xinchuan/recruit">
                    招聘合作
                </a>
                <span class="h-angle"></span>
            </li>
            <li>
                <a href="/xinchuan/about">
                    联系我们
                </a>
                <span class="h-angle"></span>
            </li>
        </ul>
    </div>
</header>
<!--sider-->
<div class="sider">
    <a href="tel:17302676883" class="sider0 m-show">
        <img src="/index/img/index/sider1.png" alt="">
    </a>
    <div class="sider1 pc-show">
        <img src="/index/img/index/sider1.png" alt="">
        <span>17302676883</span>
    </div>
    <div class="sider2">
        <img src="/index/img/index/sider2.png" alt="">
        <div class="qrcode-wx">
            <img src="/index/img/index/xcqr.jpg" alt="">
        </div>
    </div>
    <div class="sider3">
        <img src="/index/img/index/sider3.png" alt="">
        <a class="c-qq" href="#"></a>
    </div>
    <div class="sider4">
        <img src="/index/img/index/sider4.png" alt="">
    </div>
</div>
<!--banner-->
<div class="keep-xy banner">
</div>
<!--content-->
<div class="container news-con">
    <!--<h3 class="dy-t-en wow flipInX" data-wow-duration="0.5s" data-wow-delay="0s">DYNAMIC NEWS</h3>-->
    <h3 class="dy-t-zh wow flipInX" data-wow-duration="0.5s" data-wow-delay="0s">动态新闻</h3>
    <!--新闻列表-->
    <ul class="new-ul" style="overflow:hidden;">
        <#if newsPage??>
        <#list newsPage.list as news>
        <a href="/xinchuan/newsDetail?id=${news.id}" class="news-li">
            <div class="keep-xy news-org1" style="background-image: url(${news.newsImage})">
            </div>
            <div class="flex-fate news-org2">
                <div class="news-txt">
                    <h3 class="news-i-title">${news.title}</h3>
                    <p class="news-i-d">
                        <span>发布日期：</span>
                        <span class="news-i-date">${news.createTime}</span>
                    </p>
                    <p class="news-i-info">
                       <#if news.summary??>
                           <#if news.summary?length gt 60>${news.summary?substring(0,60)}...
                           <#else>
                               ${news.summary!''}
                           </#if>
                       </#if>
                    </p>
                </div>
            </div>
            <span class="flex-fate news-org3">
                <img src="/index/img/news/arrow.png" alt="">
            </span>
        </a>
        </#list>
        </#if>
       <#-- <a href="./detail2.html" class="news-li">
            <div class="keep-xy news-org1" style="background-image: url('/index/img/news/n2.jpg')">
            </div>
            <div class="flex-fate news-org2">
                <div class="news-txt">
                    <h3 class="news-i-title">智能钢企了解一下</h3>
                    <p class="news-i-d">
                        <span>发布日期：</span>
                        <span class="news-i-date">2018-03-08</span>
                    </p>
                    <p class="news-i-info">
                        “十三五 ”以来，智能制造在钢铁生产制造、企业管理、物流配送、产品销售等方面应用不断深化，关键工艺流程数控化率超过65%，企业资源计划装备率超过70%。
                    </p>
                </div>
            </div>
            <span class="flex-fate news-org3">
                <img src="/index/img/news/arrow.png" alt="">
            </span>
        </a>
        <a href="./detail3.html" class="news-li">
            <div class="keep-xy news-org1" style="background-image: url('/index/img/news/n3.png')">
            </div>
            <div class="flex-fate news-org2">
                <div class="news-txt">
                    <h3 class="news-i-title">领导发话啦！智能制造是钢铁行业未来最核心竞争力！</h3>
                    <p class="news-i-d">
                        <span>发布日期：</span>
                        <span class="news-i-date">2017-12-26</span>
                    </p>
                    <p class="news-i-info">
                        2017年12月21日，“国是论坛2017年会”于北京钓鱼台国宾馆举行。冶金工业规划研究院院长李新创表示，智能制造是钢铁行业未来最核心的竞争力，也是各种传统行业的最核心竞争力，今后要加快智能制造的普及和推广应用。
                    </p>
                </div>
            </div>
            <span class="flex-fate news-org3">
                <img src="/index/img/news/arrow.png" alt="">
            </span>
        </a>
        <a href="./detail4.html" class="news-li">
            <div class="keep-xy news-org1" style="background-image: url('/index/img/news/n4.png')">
            </div>
            <div class="flex-fate news-org2">
                <div class="news-txt">
                    <h3 class="news-i-title">行业动态</h3>
                    <p class="news-i-d">
                        <span>发布日期：</span>
                        <span class="news-i-date">2017-10-31</span>
                    </p>
                    <p class="news-i-info">
                        工业软件是一种以数据与指令集合对工业知识、经验、控制逻辑等进行固化封装的数字化技术，从而成为在工业领域中建立数据自动流动规则体系、对业务活动具有赋能作用、延伸人类知识与智能的载体和工具。
                    </p>
                </div>
            </div>
            <span class="flex-fate news-org3">
                <img src="/index/img/news/arrow.png" alt="">
            </span>
        </a>-->
    </ul>
    <!--切换页码-->
   <div class="page-con" id="page">
       <form class="layui-form layui-col-md12 x-so" action="/xinchuan/news" method="get" id="pageForm">
           <input type="hidden" id="totalPage" value="${newsPage.totalPage}">
           <input type="hidden" name="currentPage" id="currentPage" value="${newsPage.currentPage}">
       </form>
        <a href="javascript:void(0)"
           onclick="goPage(${newsPage.currentPage-1})" class="page-pre
             <#if newsPage.currentPage=1> page-dis  </#if>
            ">上一页</a>
        <ul class="page-num">
            <li class="active">
                <a href="#" class="page-num-i">
                    1
                </a>
            </li>
            <li class="active">
                <a href="#" class="page-num-i">
                    1
                </a>
            </li>
        </ul>
       <a href="javascript:void(0)"
          onclick="goPage(${newsPage.currentPage+1})" class="page-pre
         <#if newsPage.currentPage=newsPage.totalPage> page-dis </#if>
        ">下一页</a>

    </div>
</div>
<!--footer-->
<div class="footer" style="">
    <div class="container">
        <img class="footer-logo" src="/index/img/index/logo-m.png" alt="">
        <a href="/xinchuan/about" class="footer-contact">
            <img src="/index/img/index/phone-logo.png" alt="">
            联系我们
        </a>
    </div>
    <span class="footer-line"></span>
    <div class="container footer-down">
        <p class="com-area">信息技术服务传统行业</p><span class="line-gray"></span>
        <p>Copyright ©2018 All Rights Reserved <br> 版权所有 上海信传信息技术有限公司 <a href="http://www.miitbeian.gov.cn">沪ICP10021789号-2</a></p>
        <div>
            <span>技术支持:</span>
            <a href="http://www.qiniuniu.com" target="_blank"><img src="/index/img/index/qiniuniu.png" alt=""></a>
        </div>
    </div>
</div>

<script src="/index/common/jquery/jquery-3.2.1.min.js"></script>
<script src="/index/common/swiper/swiper.min.js"></script>
<script src="/index/common/swiper/swiper.animate.min.js"></script>
<script src="/index/common/wow/wow.min.js"></script>
<script src="/index/js/common.js"></script>
<script src="/index/js/news.js"></script>
<#--<script src="/lib/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="/js/xadmin.js"></script>
<script src="/common/pagination.js"></script>-->
<script>


</script>
</body>
</html>