function cambiarTitulo() {
    var seleccion = document.getElementById('cmbTipoProyecto');
    if (seleccion.selectedIndex == 0) {
        document.getElementById('lblSelect').innerHTML = "CheckList";
    } else {
        document.getElementById('lblSelect').innerHTML = "Tarea";
    }
}