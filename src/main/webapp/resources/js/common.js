/**
 * Created by celine on 2015/7/2.
 */
function initLogin(btn){
    var ajaxCallUrl =basepath+"/account/loginAjax"
    $(btn).click(function(){
        $.ajax({
            dataType:"json",
            type: "POST",
            url:ajaxCallUrl,
            data:$(this).parent().serialize(),// form
            async: false,
            error: function(XMLHttpRequest, error, errorThrown){
                alert(error);
                alert(errorThrown);
            },
            success: function(data) {
                if(data.msg=="success!")
                    alert(data.msg+"---"+data.name);
                else
                    alert(data.msg);
            }
        });
    });
}