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
    <link rel="stylesheet" href="/index/css/about.css">
    <#--<link rel="stylesheet" href="/css/xadmin.css">-->
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
        <a href="/">
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
            <li>
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
            <li class="active">
                <a href="/xinchuan/about">
                    联系我们
                </a>
                <span class="h-angle"></span>
            </li>
        </ul>
    </div>
</header>
<!--banner-->
<div class="keep-xy banner">
</div>
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
<!-- contact -->
<div class="container about-us-con">
    <h3 class="wow flipInX" data-wow-duration="0.5s" data-wow-delay="0s">联系我们</h3>
    <!--<p class="wow flipInX" data-wow-duration="0.5s" data-wow-delay="0s">CONTACT US</p>-->
    <!-- map -->
    <div id="map"></div>
    <!--contact-con-->
    <div class="row contact-row" style="position: relative;">
        <!--left-->
        <div class="col-sm-5 flex-fate contact-l">
            <div class="flex-fate contact-info wow slideInLeft" data-wow-duration="0.5s" data-wow-delay="0s">
                <!--<div class="contact-time">-->
                    <!--<p class="start-t">营业时间：</p>-->
                    <!--<p>08：00-20：00（周一至周五）</p>-->
                    <!--<p>10：00-18：00（周六周日）</p>-->
                <!--</div>-->
                <div class="contact-add">
                    <p>地址：上海市徐汇区番禺路888号方糖小镇R22室</p>
                    <p>电话：17302676883</p>
                    <p>手机：17621202587</p>
                    <p>邮箱：liny@infomax.net.cn</p>
                    <p>邮编：200030</p>
                </div>
            </div>
        </div>
        <!--right-->
        <div class="col-sm-7 col-sm-offset-5 contact-r">
            <div class="flex-fate contact-form wow slideInRight" data-wow-duration="0.5s" data-wow-delay="0s">
                <form id="form-sub" class="form-sub" action="">
                    <div>
                        <label for="userName">联系人</label>
                        <input id="userName" name="userName" type="text">
                    </div>
                    <div>
                        <label for="userEmail">邮箱地址</label>
                        <input id="userEmail" name="userEmail" type="text">
                    </div>
                    <div>
                        <label for="userPhone">联系电话</label>
                        <input id="userPhone" name="userPhone" type="text">
                    </div>
                    <div class="note-con">
                        <label for="remarks">备注说明</label>
                        <textarea id="remarks" name="remarks" type="text"></textarea>
                    </div>
                    <div id="commit">发送</div>
                </form>
            </div>
        </div>
    </div>
</div>
<!--footer-->
<div class="footer" style="">
    <div class="container">
        <img class="footer-logo" src="/index/img/index/logo-m.png" alt="">
        <a href="javascript:;" class="footer-contact">
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
<script type="text/javascript" src="/lib/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="https://api.map.baidu.com/api?v=2.0&ak=dYvdoiRD3W5IGIzQmbFqfp6GBbm4q2hu"></script>
<script src="/index/js/common.js"></script>
<script src="/index/js/about.js"></script>
</body>
</html>