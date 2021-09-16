;

plugin = {
    init: function () {
        this.eventBind();
    },
    eventBind: function () {
        $(".btn-delete-clc").click(function () {

            var clerkId = $(this).parent().attr("id");
            var data = {
                "clerk_id": clerkId
            };
            console.log(data);
            let callback = function () {
                $.ajax({
                    url: "/clerk/delete",
                    type: "POST",
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify(data),
                    dataType: "json",
                    success: function (res) {
                        if (res.code === 200) {
                            utils.toastTip(res.msg);
                            window.location.reload();
                        } else {
                            utils.toastError(res.msg)
                        }

                    }
                });
            };
            utils.alert_msg("删除用户", "您确定要删除该用户吗", callback)
        });


        $("#btn-add-clc").click(function () {
            let clerk_name = $("#clerk-name").val();
            let clerk_gender;
            if ($("#clerk-gender-0-update").prop('checked')) {
                clerk_gender = 0;
            } else {
                clerk_gender = 1;
            }
            let clerk_phone = $("#clerk-phone").val();
            let clerk_password = $("#clerk-password").val();
            console.log(clerk_gender);
            if (clerk_name === undefined || clerk_name.length === 0) {
                utils.toastError("请输入正确的用户名");
                return;
            }

            if (clerk_password === undefined || clerk_password.length === 0) {
                utils.toastError("请输入正确的密码")
                return;
            }

            if (clerk_phone === undefined || clerk_phone.length === 0) {
                utils.toastError("请输入正确的号码")
                return;
            }

            let data = {
                "clerk_name": clerk_name,
                "clerk_gender": clerk_gender,
                "clerk_phone": clerk_phone,
                "clerk_password": clerk_password
            }

            $.ajax({
                url: "/clerk/add",
                type: "POST",
                contentType: "application/json; charset=utf-8",
                data: JSON.stringify(data),
                dataType: "json",
                success: function (res) {
                    $('#myModal').modal('hide')
                    if (res.code === 200) {
                        utils.toastTip(res.msg);
                        window.location.reload();
                    } else {
                        utils.toastError(res.msg)
                    }
                }
            })
        });


        $(".btn-update-clc").click(function () {
            let clc_id = $(this).parent().attr("id");
            console.log("clc_id: " + clc_id);
            let clc_name = $("#clc_name_" + clc_id).text();
            let clc_phone = $("#clc_phone_" + clc_id).text();
            let clc_gender = $("#clc_gender_" + clc_id).text();

            $("#clerk-id-update").val(clc_id);
            $("#clerk-name-update").val(clc_name);
            $("#clerk-phone-update").val(clc_phone);
            if (clc_gender === '男') {
                $("#clerk-gender-1-update").prop("checked",true);
            } else {
                $("#clerk-gender-0-update").prop("checked",true);
            }

            console.log("com_name: " + clc_name);
            $('#myModal-update').modal('show');
        });

        $("#btn-update-clc").click(
            function () {
                let clerk_name = $("#clerk-name-update").val();
                let clerk_id = $("#clerk-id-update").val();
                let clerk_phone = $("#clerk-phone-update").val();
                let clerk_password = $("#clerk-password-update").val();
                let clerk_gender
                if ($("#clerk-gender-0-update").prop('checked')) {
                    clerk_gender = 0;
                } else {
                    clerk_gender = 1;
                }


                if (clerk_name === undefined || clerk_name.length === 0) {
                    utils.toastError("请输入正确的用户名");
                    return;
                }

                if (clerk_password === undefined || clerk_password.length === 0) {
                    utils.toastError("请输入正确的密码")
                    return;
                }

                if (clerk_phone === undefined || clerk_phone.length === 0) {
                    utils.toastError("请输入正确的号码")
                    return;
                }

                let data = {
                    "clerk_id": clerk_id,
                    "clerk_name": clerk_name,
                    "clerk_phone": clerk_phone,
                    "clerk_password": clerk_password,
                    "clerk_gender": clerk_gender
                }

                $.ajax({
                    url: "/clerk/update",
                    type: "POST",
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify(data),
                    dataType: "json",
                    success: function (res) {
                        $('#myModal').modal('hide')
                        if (res.code === 200) {
                            utils.toastTip(res.msg);
                            window.location.reload();
                        } else {
                            utils.toastError(res.msg)
                        }
                    }
                });
            }
        );

    }
};

$(document).ready(function () {
    plugin.init();
});