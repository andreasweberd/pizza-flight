
function tokenOK() {
     jQuery.ajax({
            url: '/login/tokenOK?user=dummy&token='+ new URLSearchParams(window.location).get('token'),
            success: function (result) {
                console.log($(result));
                if (result.isOk == false) alert(result.message);
            },
            async: false
        });
}
