;


plugin_add = {
    init: function () {
        this.eventBind();
    },
    eventBind: function () {
        var file_flag = false;
        var guide = $('.guide-box').bootstrapWizard({
            'tabClass': 'nav-step',
            'nextSelector': '[data-wizard="next"]',
            'previousSelector': '[data-wizard="prev"]',
            'finishSelector': '[data-wizard="finish"]',
            'onTabClick': function (e, t, i) {
                return false;
            },
            //下一步事件绑定 index 从0开始
            'onNext': function (tab, navigation, index) {

                if (index === 1) {
                    var plugin_name = $("#plugin-name").val();
                    var plugin_version = $("#plugin-version").val();
                    var plugin_desc = $("#plugin-desc").val();
                    if (plugin_name === undefined || plugin_name.length < 1) {
                        utils.toastError("请输入插件名称");
                        $("#plugin-name").focus();
                        return false;
                    }
                    if (plugin_version === undefined || plugin_version.length < 1) {
                        utils.toastError("请输入插件版本");
                        $("#plugin_version").focus();
                        return false;
                    }
                    if (plugin_desc === undefined || plugin_desc.length < 1) {
                        utils.toastError("请输入插件描述");
                        $("#plugin-desc").focus();
                        return false;
                    }
                    $("#name_value").text(plugin_name);
                    $("#version_value").text(plugin_version);
                    $("#desc_value").text(plugin_desc);

                } else if (index === 2) {
                    if (file_flag === false) {
                        utils.toastError("请等待上传完成");
                        return false;
                    }
                    $("#file_value").text($("#file_name").text());
                }

            },

            'onTabShow': function (tab, navigation, index) {
                navigation.children(":gt(" + index + ").complete").removeClass("complete");
                navigation.children(":lt(" + index + "):not(.complete)").addClass("complete");
            },
            'onFinish': function (tab, navigation, index) {
                // 点击完成后处理提交
                var reg_btn = $(this);
                if (reg_btn.hasClass("disabled")){
                    utils.toastError("正在处理，请不要重复点击")
                    return;
                }
                var name = $("#name_value").text();
                var desc = $("#desc_value").text();
                var version = $("#version_value").text();
                var fileName = $("#file_value").text();
                if (name === undefined || name.length < 1) {
                    utils.toastError("请输入正确的插件名");
                    return;
                }
                if (desc === undefined || desc.length < 1) {
                    utils.toastError("请输入正确的插件描述");
                    return;
                }
                if (version === undefined || version.length < 1) {
                    utils.toastError("请输入正确的插件描述");
                    return;
                }
                if (fileName === undefined || fileName.length < 1) {
                    utils.toastError("请选择正确的插件文件");
                    return;
                }
                var data = {
                    name:name,
                    desc:desc,
                    version:Number(version),
                    fileName:fileName
                };
                reg_btn.addClass("disabled");
                $.ajax({
                    url: "/plugin/add",
                    type: "POST",
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify(data),
                    dataType: "json",
                    success: function (res) {
                        reg_btn.removeClass("disabled");
                        if (res.code === 200) {
                            utils.toastTip(res.msg+"  即将跳转到商品列表页面");
                            setTimeout(function () {
                                window.location.href = "/plugin";
                            },1000)
                        }else {
                            utils.toastError(res.msg)
                        }

                    }
                });

            }
        });


        // Get the template HTML and remove it from the doument
        var previewNode = document.querySelector("#template");
        previewNode.id = "";
        var previewTemplate = previewNode.parentNode.innerHTML;
        previewNode.parentNode.removeChild(previewNode);

        var dropZone = new Dropzone("#dropz", { // Make the whole body a dropzone
            url: "/plugin/upload", // Set the url
            paramName: "plugin-file",
            previewTemplate: previewTemplate,
            maxFiles: 1,
            autoQueue: false,
            previewsContainer: "#previews", // Define the container to display the previews
            clickable: ".add-file", // Define the element that should be used as click trigger to select files.
            init: function () {


            }
        });

        dropZone.on("addedfile", function (file) {
            // Hookup the start button
            document.querySelector(".start").onclick = function () {
                dropZone.enqueueFile(file);
            };
            $(".start").removeClass("hidden");
            $(".add-file").addClass("hidden");
        });
        dropZone.on("sending", function (file) {
            // And disable the start button
            document.querySelector(".start").setAttribute("disabled", "disabled");
        });
        dropZone.on("success", function (file,response) {
            utils.toastTip(response.msg);
            document.querySelector(".start").removeAttribute("disabled");
            $(".start").addClass("hidden");
            file_flag = true;
            guide.bootstrapWizard('next');

        });
        dropZone.on("error",function (file) {
            dropZone.removeAllFiles(true);
            $(".start").addClass("hidden");
            $(".add-file").removeClass("hidden");
        });



    }

};

$(document).ready(function () {
    plugin_add.init();
});