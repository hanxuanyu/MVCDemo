;
user_login = {
    init: function () {
        this.eventBind();
    },
    eventBind:function () {
        $("#do_login").click(function () {
            var reg_btn = $(this);
            if (reg_btn.hasClass("disabled")){
                utils.toastError("正在处理，请不要重复点击")
                return;
            }

            var name = $("#username").val();
            var password = $("#password").val();

            if (name === undefined || name.length < 1) {
                utils.toastError("请输入正确的用户名");
                return;
            }
            if (password === undefined || password.length === 0) {
                utils.toastError("请输入正确的密码");
                return;
            }

            var data = {
                username: name,
                password: password,
            };
            reg_btn.addClass("disabled");
            $.ajax({
                url: "/doLogin",
                type: "POST",
                contentType: "application/json; charset=utf-8",
                data: JSON.stringify(data),
                dataType: "json",
                success: function (res) {
                    reg_btn.removeClass("disabled");
                    if (res.code === 200) {
                        utils.toastTip(res.msg+"  即将跳转到首页");
                        setTimeout(function () {
                            window.location.href = "../../..";
                        },1000)
                    }else {
                        utils.toastError(res.msg)
                    }

                }
            });
        })
    }
};

$(document).ready(function () {
    user_login.init();
});
