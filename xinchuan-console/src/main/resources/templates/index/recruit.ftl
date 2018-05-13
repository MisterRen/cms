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
    <link rel="stylesheet" href="/index/css/recruit.css">

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
            <li class="active">
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
<div class="content">
    <div class="dot-banner"></div>
    <div class="container recruit-con">
        <h3 class="tog-t-zh wow flipInX" data-wow-duration="0.5s" data-wow-delay="0s">合作伙伴</h3>
        <!--<p class="tog-t-en wow flipInX" data-wow-duration="0.5s" data-wow-delay="0s">COOPERATIVE PARTNER</p>-->
        <span class="p-line wow flipInX" data-wow-duration="0.5s" data-wow-delay="0s"></span>
        <div class="blue-con wow rotateIn" data-wow-duration="0.5s" data-wow-delay="0s">
            <img src="/index/img/recruit/bluerot.png" alt="">
        </div>
        <div class="fzqk-con">
            <p class="wow slideInLeft" data-wow-duration="0.5s" data-wow-delay="0s">我们坚持“诚招天下客，誉在客户心”的原则,热忱欢迎国内有实力的渠道伙伴合作，共同开创美好明天!</p>
            <p class="fzqk-h3 wow slideInRight" data-wow-duration="0.5s" data-wow-delay="0s">合作双赢，共享市场，真诚期待与您的合作!</p>
            <p class="wow slideInLeft" data-wow-duration="0.5s" data-wow-delay="0s">合作形式可以有很多种，只要你有优质的行业相关资源，信传信息欢迎您和我们共同成长，做大做强！</p>
        </div>
    </div>
    <!-- 招聘信息 -->
    <div class="container recruit-info">
        <h3 class="wow flipInX" data-wow-duration="0.5s" data-wow-delay="0s">招聘信息</h3>
        <!--<p class="wow flipInX" data-wow-duration="0.5s" data-wow-delay="0s">RECRUITMENT INFORMATION</p>-->
        <div class="rc-con">
            <!-- 单个招聘要求 -->
             <#if recruitPage ??>
                 <#list recruitPage.list as recruit>
            <div class="rc-item">
                <h3>${recruit.postName}</h3>
                <div class="rc-item-duty">
                    <span>岗位职责:</span>
                    ${recruit.duty}
                </div>
                <div class="rc-item-req">
                    <span>岗位要求：</span>
                    ${recruit.requirements}
                </div>
               <#-- <p style="color:#686565;font-size:16px;line-height:2em;margin-top:14px;">福利：全额五险一金+绩效+奖金+期权，全薪病假 </p>-->
            </div>
                 </#list>
             </#if>

        </div>
        <!--contact email-->
        <div class="contact-email">
            招聘邮箱：chendx@infomax.net.cn
        </div>
    </div>
</div>
<!-- footer -->
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
<script src="/index/js/recruit.js"></script>
</body>
</html>