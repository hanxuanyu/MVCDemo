;

plugin = {
    init: function () {
        this.eventBind();
    },
    eventBind: function () {
        $(".btn-delete-com").click(function () {

            var comId = $(this).parent().attr("id");
            var data = {
                "com_id": comId
            };
            console.log(data);
            let callback = function () {
                $.ajax({
                    url: "/commodity/delete",
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
            utils.alert_msg("删除商品", "您确定要删除该商品吗", callback)
        });


        $("#btn-add-com").click(function () {
            let com_name = $("#commodity-name").val();
            let com_origin = $("#commodity-origin").val();
            let com_production_date = $("#commodity-production-date").val();
            let com_shelf_lift = $("#commodity-shelf-life").val();

            console.log(com_name);
            if (com_name === undefined || com_name.length === 0) {
                utils.toastError("请输入正确的商品名");
                return;
            }

            if (com_origin === undefined || com_origin.length === 0) {
                utils.toastError("请输入正确的产地")
                return;
            }

            var regex = new RegExp("^(?:(?:([0-9]{4}(-|/)(?:(?:0?[1,3-9]|1[0-2])(-|/)(?:29|30)|((?:0?[13578]|1[02])(-|/)31)))|([0-9]{4}(-|/)(?:0?[1-9]|1[0-2])(-|/)(?:0?[1-9]|1//d|2[0-8]))|(((?:(//d//d(?:0[48]|[2468][048]|[13579][26]))|(?:0[48]00|[2468][048]00|[13579][26]00))(-|/)0?2(-|/)29))))$");
            if (com_production_date === undefined || com_production_date.length === 0 || !regex.test(com_production_date)) {
                utils.toastError("请输入正确的生产日期")
                return;
            }

            if (com_shelf_lift === undefined || com_shelf_lift.length === 0) {
                utils.toastError("请输入正确的保质期")
                return;
            }

            let data = {
                "com_name": com_name,
                "com_origin": com_origin,
                "com_production_date": com_production_date,
                "com_shelf_lift": com_shelf_lift
            }

            $.ajax({
                url: "/commodity/add",
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


        $(".btn-update-com").click(function () {
            let com_id = $(this).parent().attr("id");
            console.log("com_id: " + com_id);
            let com_name = $("#com_name_" + com_id).text();
            let com_origin = $("#com_origin_" + com_id).text();
            let com_production_date = $("#com_production_date_" + com_id).text();
            let com_shelf_lift = $("#com_shelf_life_" + com_id).text();

            $("#commodity-id-update").val(com_id);
            $("#commodity-name-update").val(com_name);
            $("#commodity-origin-update").val(com_origin);
            $("#commodity-production-date-update").val(com_production_date);
            $("#commodity-shelf-life-update").val(com_shelf_lift);

            console.log("com_name: " + com_name);
            $('#myModal-update').modal('show');
        });

        $("#btn-update-com").click(
            function () {
                let com_name = $("#commodity-name-update").val();
                let com_id = $("#commodity-id-update").val();
                let com_origin = $("#commodity-origin-update").val();
                let com_production_date = $("#commodity-production-date-update").val();
                let com_shelf_lift = $("#commodity-shelf-life-update").val();

                if (com_name === undefined || com_name.length === 0) {
                    utils.toastError("请输入正确的商品名")
                }

                if (com_origin === undefined || com_origin.length === 0) {
                    utils.toastError("请输入正确的产地")
                }

                if (com_production_date === undefined || com_production_date.length === 0) {
                    utils.toastError("请输入正确的生产日期")
                }

                if (com_shelf_lift === undefined || com_shelf_lift.length === 0) {
                    utils.toastError("请输入正确的保质期")
                }

                let data = {
                    "com_id": com_id,
                    "com_name": com_name,
                    "com_origin": com_origin,
                    "com_production_date": com_production_date + " 00:00:00",
                    "com_shelf_lift": com_shelf_lift
                }

                $.ajax({
                    url: "/commodity/update",
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