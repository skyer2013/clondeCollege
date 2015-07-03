/**
 * Created by celine on 2015/7/2.
 */
function btnLoginClick(btn){
    var ajaxCallUrl =basepath+"/account/loginAjax"
    $.post(ajaxCallUrl, $(btn).parent().serialize(), function (response) {
        $("#navbar").html('<div class="navbar-brand navbar-right white">欢迎您，'+response+'<button id="btn_logout" onclick="btnLogoutClick(this)">[登出]</button></div>');
    });
}
function btnLogoutClick(btn){
    var ajaxCallUrl =basepath+"/account/logoutAjax"
    var html='<form class="navbar-form navbar-right" action="<%=request.getContextPath()%>/account/login" method="post">'+
    '<div class="form-group"><input type="text" placeholder="Username" class="form-control" name="username">'+
    '                          </div>'+
                          '<div class="form-group">'+
                            '<input type="password" placeholder="Password" class="form-control" name="password">'+
                          '</div>'+
                          '<button id="btn_submit" onclick="btnLoginClick(this)" class="btn btn-success">登录</button>'+
                          '<a href="<%=request.getContextPath()%>/account/register" class="btn btn-success">注册</a>'+
                        '</form>';
    $.post(ajaxCallUrl, '', function (response) {
        $("#navbar").html(html);
    });

}