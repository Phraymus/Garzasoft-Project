function abrirUrl(url,contenedor) {
    $.get(url,{},function(data) {
       $("#"+contenedor).html(data); 
    });
}