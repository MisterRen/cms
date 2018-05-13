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
<div class="container detail-con">
    <h3 class="del-t">${news.title}</h3>
    <p class="del-d">
        <span>发布日期：</span>
        <span class="del-date">${news.createTime}</span>
    </p>
    <p class="del-p">

    </p>
    ${news.content}
   <#-- <p class="del-p">
        日前，河北印发《钢铁工业大气污染物超低排放标准（征求意见稿）》，拟在2016年公布的排放标准的基础上，调整对烧结（球团）、高炉炼铁、炼钢和轧钢工序颗粒物、二氧化硫、氮氧化物大气污染物排放浓度限值。
    </p>
    <p class="del-p">
        现有企业烧结球团2020年1月1日起执行颗粒物10mg/m3、二氧化硫35mg/m3、氮氧化物50mg/m3。新建企业自标准实施之日起执行表1～表4规定的排放限值。
    </p>
    <p style="font-size:18px;font-weight:bold;line-height:3em;">
        钢铁行业有组织排放大气污染物排放标准如下：
    </p>
    <p class="del-p">
        现有企业2020年1月1日前执行DB13/2169-2015和《河北省环境保护厅关于河北省钢铁行业执行大气污染物特别排放限值的公告》（2016年第1号）中规定的排放限值，2020年1月1日起执行表1～表4规定的排放限值。
    </p>
    <img class="del-img" src="/index/img/news/d1-1.jpg" alt="">
    <img class="del-img" src="/index/img/news/d1-2.jpg" alt="">
    <img class="del-img" src="/index/img/news/d1-3.jpg" alt="">
    <p class="del-p">
        企业边界大气污染物任何1小时平均浓度执行表5规定的限值。
    </p>
    <img class="del-img" src="/index/img/news/d1-4.jpg" alt="">
    <p class="del-p">
        大 铁精矿等原料，煤、焦粉等燃料以及石灰石等辅料的储存建设封闭料场（仓、棚、库），并采取喷淋等抑尘措施。各生产单元在装卸、加工、贮存、输送物料时的扬尘点，烧结（球团）设备，炼铁出铁场的出铁口、主沟、铁沟、渣沟等，以及炼钢铁水预处理、转炉兑铁、电炉加料、出渣、出钢等产生大气污染物的生产工序必须设立局部气体收集系统和集中净化处理装置，净化后的气体由排气筒排放。
    </p>
    <p class="del-p">
        据悉，唐山地区新建项目已经按新标准要求实施了，我们要不断为大气环保做贡献，还祖国一片绿水青山，促进传统行业绿色、健康、可持续发展！
    </p>
    <img class="del-img" src="/index/img/news/d1-5.jpg" alt="">-->
</div>
<div class="container share">
    <p class="detail-pre">
        <#if prevNew??>
            <a style="color:#999;" href="/xinchuan/newsDetail?id=${prevNew.id}">
            <span>上一篇：</span>
            <span>${prevNew.title}</span>
        <#else>
            <a style="color:#999;" href="javascript:;">
            <span>上一篇：</span>
            <span>暂无更多</span>
        </#if>
    </p>
    <p class="detail-next">
        <#if nextNew??>
            <a style="color:#999;" href="/xinchuan/newsDetail?id=${nextNew.id}">
            <span>下一篇：</span>
            <span>${nextNew.title}</span>
        <#else>
            <a style="color:#999;" href="javascript:;">
            <span>下一篇：</span>
            <span>暂无更多</span>
        </#if>
        </a>
    </p>
    <div class="share3 bdsharebuttonbox">
        <span>分享到:</span>
        <!--<img class="share-wx" src="/index/img/news/wx.png" alt="">-->
        <!--<img class="share-qq" src="/index/img/news/qq.png" alt="">-->
        <a href="#" id="share-wx" class="bds_weixin" data-cmd="weixin" title="分享到微信"></a>
        <a href="#" id="share-qq" class="bds_sqq" data-cmd="sqq" title="分享到QQ好友"></a>
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



<!--<div class="bdsharebuttonbox">-->
    <!--<a href="#" class="bds_more" data-cmd="more"></a>-->
    <!--<a href="#" class="bds_weixin" data-cmd="weixin" title="分享到微信"></a>-->
    <!--<a href="#" class="bds_sqq" data-cmd="sqq" title="分享到QQ好友"></a>-->
<!--</div>-->
<script>
    window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdMiniList":false,"bdPic":"","bdStyle":"0","bdSize":"16"},"share":{}};
    with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];
</script>

<!--&lt;!&ndash;最后加入一个百度分享公共的js脚本，如果您希望在增加一个侧栏式按钮，可以向下面这样将type设置成slide&ndash;&gt;-->
<!--<script type="text/javascript" id="bdshare_js" data="type=slide&mini=1" ></script>-->
<!--<script type="text/javascript" id="bdshell_js"></script>-->
<!--<script type="text/javascript">-->
    <!--document.getElementById('bdshell_js').src = "http://bdimg.share.baidu.com/static/js/shell_v2.js?cdnversion=" + Math.ceil(new Date()/3600000);-->
<!--</script>-->
<!-- Baidu Button END -->

<script src="/index/common/jquery/jquery-3.2.1.min.js"></script>
<script src="/index/common/swiper/swiper.min.js"></script>
<script src="/index/common/swiper/swiper.animate.min.js"></script>
<script src="/index/common/wow/wow.min.js"></script>
<script src="/index/js/common.js"></script>
<script src="/index/js/news.js"></script>
</body>
</html>