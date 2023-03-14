
function tokenOK() {
     var t = new URLSearchParams(window.location.search).get('token');
     console.log("token ok? " + t);
     return $.getJSON( '/login/tokenOK?user=dummy&token='+ t, function( data ) {
          console.log(data);
     });
}
