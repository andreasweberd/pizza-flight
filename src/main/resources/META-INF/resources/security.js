const token = "8J+NlfCfjZXwn42VIFN1cGVyIGdlaGVpbWVyIFRleHQg8J+NlfCfjZXwn42V"

function tokenOK() {
    return window.location.search.includes(token);
}
