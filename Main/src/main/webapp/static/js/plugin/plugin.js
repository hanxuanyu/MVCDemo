;

//定义函数
window.Clipboard = (function(window, document, navigator) {
    var textArea,
        copy;

    // 判断是不是ios端
    function isOS() {
        return navigator.userAgent.match(/ipad|iphone/i);
    }
    //创建文本元素
    function createTextArea(text) {
        textArea = document.createElement('textArea');
        textArea.value = text;
        document.body.appendChild(textArea);
    }
    //选择内容
    function selectText() {
        var range,
            selection;

        if (isOS()) {
            range = document.createRange();
            range.selectNodeContents(textArea);
            selection = window.getSelection();
            selection.removeAllRanges();
            selection.addRange(range);
            textArea.setSelectionRange(0, 999999);
        } else {
            textArea.select();
        }
    }

//复制到剪贴板
    function copyToClipboard() {
        try{
            if(document.execCommand("Copy")){
                utils.toastTip("复制成功！");
            }else{
                utils.toastTip("复制失败！请手动复制！");
            }
        }catch(err){
            utils.toastTip("复制错误！请手动复制！")
        }
        document.body.removeChild(textArea);
    }

    copy = function(text) {
        createTextArea(text);
        selectText();
        copyToClipboard();
    };

    return {
        copy: copy
    };
})(window, document, navigator);


plugin = {
    init:function () {
        this.eventBind();
    },



    eventBind: function () {
        var qrcode = new QRCode(document.getElementById("qrcode"), {
            width: 200, //生成的二维码的宽度
            height: 200, //生成的二维码的高度
            colorDark : "#000000", // 生成的二维码的深色部分
            colorLight : "#ffffff", //生成二维码的浅色部分
            correctLevel : QRCode.CorrectLevel.H
        });
        $(".download-btn").click(function () {
            var downloadBtn = $(this);
            var link = "http://"+window.location.host + "/plugin/download?id=" + downloadBtn.parent().attr("id");
            $("#link-text").val(link);
            qrcode.clear(); // 清除代码
            qrcode.makeCode(link); // 生成另外一个二维码
            Clipboard.copy(link);
        });

        $(".delete-btn").click(function () {

            var pluginId = $(this).parent().attr("id");
            var data = {
                pluginId: pluginId
            };
            var callback = function(){
                $.ajax({
                    url: "/plugin/delete",
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

            utils.alert_msg("删除商品","您确定要删除该插件吗",callback)

        });

        $(".update-btn").click(function () {
            window.location.href = "/plugin/update?pluginid="+$(this).parent().attr("id");
        });

    }
};

$(document).ready(function () {
    plugin.init();
});