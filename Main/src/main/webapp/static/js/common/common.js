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
    }
};
