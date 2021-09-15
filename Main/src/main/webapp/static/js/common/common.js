;

toastr.options = {
    "closeButton": false,
    "debug": false,
    "newestOnTop": false,
    "progressBar": false,
    "positionClass": "toast-top-right",
    "preventDuplicates": false,
    "onclick": null,
    "showDuration": "300",
    "hideDuration": "1000",
    "timeOut": "5000",
    "extendedTimeOut": "1000",
    "showEasing": "swing",
    "hideEasing": "linear",
    "showMethod": "fadeIn",
    "hideMethod": "fadeOut"
};

var utils = {

    toastTip: function (msg) {
        toastr["success"](msg)
    },
    toastError: function (msg) {
        toastr["error"](msg)
    },
    alert_msg: function (title,msg,yesCallback,noCallback) {
        $.alert({
            title: title,
            content: msg,
            buttons: {
                confirm: {
                    text: '确认',
                    btnClass: 'btn-primary',
                    action: function(){
                        if(typeof(yesCallback) == 'function'){
                            yesCallback()
                        }
                    }
                },
                cancel: {
                    text: '取消',
                    action: function () {
                        if(typeof(noCallback) == 'function'){
                            noCallback()
                        }
                    }
                }
            }
        })
    },
    copyText:function(obj){
        if (!obj) {
            return false;
        }
        var text;
        if (typeof(obj) == 'object') {
            if (obj.nodeType) { // DOM node
                obj = $(obj); // to jQuery object
            }
            try {
                text = obj.text();
                if (!text) { // Maybe <textarea />
                    text = obj.val();
                }
            } catch (err) { // as JSON
                text = JSON.stringify(obj);
            }
        } else {
            text = obj;
        }
        //var $temp = $('<input>'); // Line feed is not supported
        var $temp = $('<textarea>');
        $('body').append($temp);
        $temp.val(text).select();
        var res = document.execCommand('copy');
        $temp.remove();
        return res;
    },
};
