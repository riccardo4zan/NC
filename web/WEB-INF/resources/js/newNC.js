function display() {
    var selected = document.getElementById("ief").value;
    switch (selected) {
        case "Reparto":
            document.getElementById("Sreparto").style.display = "block";
            document.getElementById("Sfornitore").style.display = "none";
            document.getElementById("Scliente").style.display = "none";
            break;
        case "Fornitore":
            document.getElementById("Sfornitore").style.display = "block";
            document.getElementById("Sreparto").style.display = "none";
            document.getElementById("Scliente").style.display = "none";
            break;
        case "Cliente":
            document.getElementById("Scliente").style.display = "block";
            document.getElementById("Sreparto").style.display = "none";
            document.getElementById("Sfornitore").style.display = "none";
            break;
        default:
            break;
    }
}