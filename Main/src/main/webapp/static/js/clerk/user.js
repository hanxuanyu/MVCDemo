;


plugin = {
    init:function () {
        this.eventBind();
    },



    eventBind: function () {

        $(".delete-btn").click(function () {

            var userId = $(this).parent().attr("id");
            var data = {
                userId: userId
            };
            var callback = function(){
                $.ajax({
                    url: "/user/delete",
                    type: "POST",
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify(data),
                    dataType: "json",
                    success: function (res) {
                        if (res.code === 200) {
                            utils.toastTip(res.msg);
                            window.location.reload();
                        }else {
                            utils.toastError(res.msg)
                        }

                    }
                });
            };

            utils.alert_msg("删除用户","您确定要删除该用户吗",callback)

        });

        $(".update-btn").click(function () {
            window.location.href = "/plugin/update?pluginid="+$(this).parent().attr("id");
        });

    }
};

$(document).ready(function () {
    plugin.init();
});