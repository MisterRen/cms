$(function () {
    //模糊图片
    var img = new Image();
    img.src = "/index/img/news/banner.png";
    img.onload = function() {
        $(".banner").css("transition","background-image 0.3s");
        $(".banner").css("background-image","url('/index/img/news/banner.png')");
    };
    var totalPage=$("#totalPage").val();
    var currentPage=$("#currentPage").val();
    var html=""
    for (var i=0;i<totalPage;i++){
        if (i+1==currentPage) {
            html+="<li  class='active'><a href='javascript:void(0)' onclick='goPage("+(i+1)+")' class='page-num-i'>"+(i+1)+"</a> </li>";
        }else{
        html+="<li><a href='javascript:void(0)' onclick='goPage("+(i+1)+")' class='page-num-i'>"+(i+1)+"</a> </li>";
        }
        console.info(html);
    }
    $(".page-num").html(html);

});

function goPage(currentPage){
    debugger;
    var totalPage=$("#totalPage").val();
    //var PageNum=$("#currentPage").val();
    if(currentPage<1 ||currentPage>totalPage){
    return;
    }
    $("#currentPage").val(currentPage)
    $("#pageForm").submit();
}