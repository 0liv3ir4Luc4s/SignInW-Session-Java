const password_eye = document.getElementById("svg-password_eye");
const password_input = document.getElementById("password");
if (getCookie("PHPSESSID")) {
    window.location.href = "http://localhost/SignInW-Session/app/back/login.php";
}
password_eye.addEventListener("click", (ev) => {
    if(password_input.type == "password") {
        password_eye.classList.add("show-password");
        password_input.type = "text";
    } else {
        password_eye.classList.remove("show-password");
        password_input.type = "password";
    }
});
function getCookie(nome) {
    var name = nome + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var ca = decodedCookie.split(';');
    for(var i = 0; i <ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}